package com.generator.generators.templates.editor;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.generators.templateGroup.TemplateGroupGroup;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.generator.editors.BaseDomainVisitor.get;
import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.TemplateGroup;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.TemplateStatement;

/**
 * Created 10.01.17.
 */
class TemplateGroupPNode extends TemplateDomainPNode {

    TemplateGroupPNode(Node node, String[] defaultColor, NeoEditor editor) {
        super(node, TemplateGroup, TemplateDomain.TemplateProperties.name.name(), defaultColor, editor);
    }

    @Override
    public void expand() {

        final Map<UUID, Label> pNodes = new LinkedHashMap<>();

        new TemplateGroupVisitor() {
            @Override
            protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
                pNodes.put(uuidOf(templateStatement), TemplateStatement);
            }
        }.visitTemplateGroup(node);

        editor.showAndLayout(pNodes, pNode);
    }

    @Override
    public void showNodeActions(JPopupMenu pop, PInputEvent event) {
        pop.add(new NewTemplateStatement(event));
        pop.add(new CreateGroupFile());
        pop.add(new ToSTGGroup());
        pop.add(new ExpandTemplateGroup());
        super.showNodeActions(pop, event);
    }

    private class NewTemplateStatement extends NeoEditor.TransactionAction {

        private final PInputEvent event;

        NewTemplateStatement(PInputEvent event) {
            super("New Templatestatement", editor.getGraph(), editor.canvas);
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String delimiter = get(node, TemplateDomain.TemplateProperties.delimiter.name());
            final TemplateDomainCanvas.TemplateEditor statementEditorPanel = new TemplateDomainCanvas.TemplateEditor(delimiter, "", "", null);
            SwingUtil.showDialogNoDefaultButton(statementEditorPanel, editor.canvas, "Statement", () -> {

                if (statementEditorPanel.txtStatementName.getText().trim().length() == 0)
                    throw new IllegalStateException("Statement must have a name");

                final com.generator.generators.templates.domain.TemplateStatement templateStatement = statementEditorPanel.parseAndValidate(delimiter);
                editor.doInTransaction(tx1 -> {
                    final Node importTemplateStatement = TemplateDomain.importTemplateStatement(node, templateStatement, editor);
                    editor.show(uuidOf(importTemplateStatement), TemplateStatement.name()).
                            setOffset(event);
                });
            });
        }
    }

    private class CreateGroupFile extends NeoEditor.TransactionAction {

        CreateGroupFile() {
            super("Create group-file", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String packageName = SwingUtil.showInputDialog("Package", editor.canvas, getString(node, TemplateDomain.TemplateProperties.packageName.name()));
            node.setProperty(TemplateDomain.TemplateProperties.packageName.name(), packageName);

            final String groupName = getString(node, TemplateDomain.TemplateProperties.name.name()) + "Group";

            //use pattern in JunitGroup (stGroupString) and create a self-standing group-file, containing the template. no need for generator.path anymore

            // todo: make templategroup part of neo-graph, and traverse this to render graph (!)
            System.setProperty("generator.path", "src/main/java/com/generator/generators");
            final TemplateGroupGroup group = new TemplateGroupGroup();

            new TemplateGroupVisitor() {

                private TemplateGroupGroup.GroupClassDeclarationST groupClassDeclaration;
                private TemplateGroupGroup.NewStatementDeclarationST declarationST;
                private String statementName;
                private Object setter;

                @Override
                protected void onTemplateGroupStart(String name, String delimiter, Node templateGroup) {
                    groupClassDeclaration = group.newGroupClassDeclaration().
                            setName(groupName).
                            setDomain(name).
                            setGroupString(TemplateDomain.asSTGString(templateGroup)).
                            setPackageName(packageName);
                }

                @Override
                protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
                    declarationST = group.newNewStatementDeclaration().setGroupname(groupName);
                    statementName = name;
                }

                @Override
                protected void onTemplateParameterStart(String name) {
                    setter = null;
                }

                @Override
                protected void onSingleTemplateParameter(String name, Node parameterNode) {
                    setter = group.newStatementStringPropertySetter().setPropertyName(name).setStatementName(statementName);
                }

                @Override
                protected void onListTemplateParameter(String name, Node parameterNode) {
                    setter = group.newStatementListPropertySetter().setPropertyName(name).setStatementName(statementName);
                }

                @Override
                protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
                    final TemplateGroupGroup.StatementKeyValueListPropertySetterST kvSetter = group.newStatementKeyValueListPropertySetter().
                            setPropertyName(name).
                            setStatementName(statementName);
                    for (String key : keys.split(" ")) kvSetter.addKvNamesValue(key);
                    setter = kvSetter;
                }

                @Override
                protected void onTemplateParameterEnd(String name) {
                    declarationST.addPropertiesValue(name, setter);
                }

                @Override
                protected void onTemplateStatementEnd(String name, String text, Node templateStatement) {
                    groupClassDeclaration.addStatementsValue(declarationST.setName(statementName), group.newNewStatementInstance().setName(statementName));
                }

                @Override
                protected void onTemplateGroupEnd() {
                    SwingUtil.toClipboard(groupClassDeclaration.toString());
                }
            }.visitTemplateGroup(node);
        }
    }

    private class ToSTGGroup extends NeoEditor.TransactionAction {

        ToSTGGroup() {
            super("As STGroup", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            SwingUtil.toClipboard(TemplateDomain.asSTGString(node));
        }
    }

    private class ExpandTemplateGroup extends NeoEditor.TransactionAction {

        ExpandTemplateGroup() {
            super("Expand", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            expand();
        }
    }
}