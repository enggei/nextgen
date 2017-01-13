package com.generator.generators.templates.editor;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.stream.Collectors;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.*;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.*;

/**
 * Created 10.01.17.
 */
class TemplateStatementPNode extends TemplateDomainPNode {

    TemplateStatementPNode(Node templateStatement, String[] color, NeoEditor editor) {
        super(templateStatement, TemplateStatement, TemplateDomain.TemplateProperties.name.name(), color, editor);
    }

    @Override
    public void expand() {
        final Map<UUID, Label> pNodes = new LinkedHashMap<>();
        for (Relationship relationship : incoming(node, TEMPLATE_STATEMENT))
            pNodes.put(uuidOf(other(node, relationship)), Statement);
        editor.showAndLayout(pNodes, pNode);
    }

    @Override
    public void showDependents() {
        final Map<UUID, Label> pNodes = new LinkedHashMap<>();
        pNodes.put(uuidOf(other(node, singleOutgoing(node, TEMPLATE_GROUP))), TemplateGroup);
        editor.showAndLayout(pNodes, pNode);
    }

    @Override
    public void showNodeActions(JPopupMenu pop, PInputEvent event) {
        pop.add(new NewStatement());
        pop.add(new EditTemplateStatment());
        pop.add(new ShowStatements());
        pop.add(new ShowTemplateGroup());
        pop.add(new ShowTemplateParameters());
        pop.add(new HideParameters());
        super.showNodeActions(pop, event);
    }

    @Override
    public void showTargetActions(JPopupMenu pop, PInputEvent event) {

        //todo if selected node is a TemplateStatement, ask to assign its statements as values for a given single-template-parameter (also support key-value-values ?)
        final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
        if (selectedNodes.size() != 1) return;

        final Node selectedNode = selectedNodes.iterator().next().node;
        if (!selectedNode.hasLabel(TemplateStatement)) return;

        // assumes selectedNode is a TemplateStatement:
        new TemplateGroupVisitor() {

            @Override
            protected void onSingleTemplateParameter(String name, Node templateParameter) {
                pop.add(new SetTemplateStatementParameter(name, templateParameter, selectedNode));
            }

            @Override
            protected void onListTemplateParameter(String name, Node templateParameter) {
                pop.add(new SetTemplateStatementParameter(name, templateParameter, selectedNode));
            }

            @Override
            protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
                // todo add support for key-value-values
                System.out.println("add support for key-value values for statement as value");
            }

        }.visitTemplateStatement(node);
    }

    private class EditTemplateStatment extends NeoEditor.TransactionAction {

        EditTemplateStatment() {
            super("Edit", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Node templateGroup = other(node, singleOutgoing(node, TEMPLATE_GROUP));
            assert templateGroup != null;
            final String delimiter = get(templateGroup, TemplateDomain.TemplateProperties.delimiter.name());
            final String name = getString(node, TemplateDomain.TemplateProperties.name.name());
            final String text = getString(node, TemplateDomain.TemplateProperties.text.name());
            final String statementLabel = getString(node, TemplateDomain.TemplateProperties.statementLabel.name());

            final TemplateDomainCanvas.TemplateEditor statementEditorPanel = new TemplateDomainCanvas.TemplateEditor(delimiter, name, text, statementLabel);
            final JDialog dialog = new JDialog(SwingUtil.getFrame(editor.canvas), "Edit statement", true);
            dialog.add(statementEditorPanel, BorderLayout.CENTER);
            final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            commandPanel.add(new JButton(new AbstractAction("Save") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editor.getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                            if (statementEditorPanel.txtStatementName.getText().trim().length() == 0)
                                throw new IllegalStateException("Statement must have a name");

                            final com.generator.generators.templates.domain.TemplateStatement editedStatement = statementEditorPanel.parseAndValidate(delimiter);

                            final java.util.List<TemplateParameter> parameters = editedStatement.getParameters();
                            final Set<Node> oldParametersToDelete = new LinkedHashSet<>();
                            final Set<TemplateParameter> newParameters = new LinkedHashSet<>();
                            final Map<Node, String> updatedKeySets = new LinkedHashMap<>();
                            final StringBuilder constraints = new StringBuilder();
                            new TemplateGroupVisitor() {

                                @Override
                                protected void onSingleTemplateParameter(String name, Node parameterNode) {

                                    // todo regarding StatementTemplateParameter, check if there is a need to do changes here:

                                    TemplateParameter found = null;
                                    for (TemplateParameter templateParameter : parameters) {
                                        if (!templateParameter.getPropertyName().equals(name)) continue;
                                        found = templateParameter;

                                        // same name: check if same type and no dependencies:
                                        switch (templateParameter.getDomainEntityType()) {
                                            case LISTPROPERTY:
                                            case KEYVALUELISTPROPERTY:
                                                // type changed: only allow if no dependencies:
                                                if (!hasDependents(parameterNode, constraints)) {
                                                    oldParametersToDelete.add(parameterNode);
                                                    newParameters.add(templateParameter);
                                                }
                                                break;
                                        }
                                    }

                                    if (found != null)
                                        parameters.remove(found);
                                    else if (!hasDependents(parameterNode, constraints))
                                        oldParametersToDelete.add(parameterNode);
                                }

                                @Override
                                protected void onListTemplateParameter(String name, Node parameterNode) {

                                    TemplateParameter found = null;
                                    for (TemplateParameter templateParameter : parameters) {
                                        if (!templateParameter.getPropertyName().equals(name)) continue;
                                        found = templateParameter;

                                        // same name: check if same type and no dependencies:
                                        switch (templateParameter.getDomainEntityType()) {
                                            case STRINGPROPERTY:
                                            case BOOLEANPROPERTY:
                                            case STATEMENTPROPERTY:
                                            case KEYVALUELISTPROPERTY:
                                                // type changed: only allow if no dependencies:
                                                if (!hasDependents(parameterNode, constraints)) {
                                                    oldParametersToDelete.add(parameterNode);
                                                    newParameters.add(templateParameter);
                                                }
                                                break;
                                        }
                                    }

                                    if (found != null)
                                        parameters.remove(found);
                                    else if (!hasDependents(parameterNode, constraints))
                                        oldParametersToDelete.add(parameterNode);
                                }

                                @Override
                                protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {

                                    TemplateParameter found = null;
                                    for (TemplateParameter templateParameter : parameters) {
                                        if (!templateParameter.getPropertyName().equals(name)) continue;
                                        found = templateParameter;

                                        // same name: check if same type and no dependencies:
                                        switch (templateParameter.getDomainEntityType()) {
                                            case STRINGPROPERTY:
                                            case BOOLEANPROPERTY:
                                            case STATEMENTPROPERTY:
                                            case LISTPROPERTY:
                                                // type changed: only allow if no dependencies:
                                                if (!hasDependents(parameterNode, constraints)) {
                                                    oldParametersToDelete.add(parameterNode);
                                                    newParameters.add(templateParameter);
                                                }
                                                break;

                                            case KEYVALUELISTPROPERTY:

                                                final Set<String> newKeySet = new LinkedHashSet<>();
                                                final Set<String> templateKeySet = new LinkedHashSet<>(templateParameter.getKvNames());
                                                boolean isValid = true;
                                                for (String oldKey : keys.split(" ")) {

                                                    if (templateKeySet.contains(oldKey)) {
                                                        newKeySet.add(oldKey);
                                                        templateKeySet.remove(oldKey);
                                                        continue;
                                                    }

                                                    // old key missing, only allow if no dependencies:
                                                    if (hasDependents(parameterNode, constraints, oldKey)) {
                                                        isValid = false;
                                                    }
                                                }

                                                if (isValid) {
                                                    newKeySet.addAll(templateKeySet);
                                                    final StringBuilder serialized = new StringBuilder();
                                                    for (String newKey : newKeySet)
                                                        serialized.append(" ").append(newKey);
                                                    updatedKeySets.put(parameterNode, serialized.toString().trim());
                                                }
                                                break;
                                        }
                                    }

                                    if (found != null)
                                        parameters.remove(found);
                                    else if (!hasDependents(parameterNode, constraints))
                                        oldParametersToDelete.add(parameterNode);
                                }
                            }.visitTemplateStatement(node);

                            if (constraints.length() > 0)
                                throw new IllegalArgumentException("cannot change template as it has parameters in use that is not compatible with new parameters: " + constraints);

                            // update new key-sets:
                            for (Map.Entry<Node, String> kvEntry : updatedKeySets.entrySet())
                                kvEntry.getKey().setProperty(TemplateDomain.TemplateProperties.keys.name(), kvEntry.getValue());

                            newParameters.addAll(parameters.stream().collect(Collectors.toList()));

                            for (TemplateParameter templateParameter : newParameters) {
                                switch (templateParameter.getDomainEntityType()) {
                                    case STRINGPROPERTY:
                                    case BOOLEANPROPERTY:
                                    case STATEMENTPROPERTY:
                                        TemplateDomain.newSingleTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName());
                                        break;

                                    case LISTPROPERTY:
                                        TemplateDomain.newListTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName());
                                        break;

                                    case KEYVALUELISTPROPERTY:
                                        TemplateDomain.newKeyValueListTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName(), templateParameter.getKvNames().toArray(new String[templateParameter.getKvNames().size()]));
                                        break;
                                }
                            }

                            // delete old parameters
                            for (Node oldParameter : oldParametersToDelete) {
                                singleOutgoing(oldParameter, TEMPLATE_PARAMETER).delete();
                                oldParameter.delete();
                            }

                            node.setProperty(TemplateDomain.TemplateProperties.name.name(), editedStatement.getName());
                            node.setProperty(TemplateDomain.TemplateProperties.text.name(), editedStatement.getText().trim());

                            boolean foundStatementLabelParameter = false;
                            for (TemplateParameter parameter : editedStatement.getParameters()) {
                                if (parameter.getPropertyName().equals(statementEditorPanel.getStatementLabel())) {
                                    foundStatementLabelParameter = true;
                                    node.setProperty(TemplateDomain.TemplateProperties.statementLabel.name(), statementEditorPanel.getStatementLabel());
                                    break;
                                }
                            }
                            if (!foundStatementLabelParameter)
                                node.removeProperty(TemplateDomain.TemplateProperties.statementLabel.name());

                            updateView();

                            // for each dependent statement of this template, re-render
                            incoming(node, TEMPLATE_STATEMENT).forEach(relationship -> {
                                final Node statementNode = other(node, relationship);
                                incoming(statementNode, DIRECTORY_MEMBER).forEach(projectRelationship -> TemplateDomain.renderProjectMember(other(statementNode, projectRelationship), editor.canvas));
                            });

                            editor.getAllNodesByLabel(Statement.name()).forEach(neoPNode -> {
                                if (isRelated(neoPNode.node, node, TEMPLATE_STATEMENT))
                                    neoPNode.updateView();
                            });

                            SwingUtilities.invokeLater(dialog::dispose);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                            SwingUtil.showExceptionNoStack(dialog, throwable);
                        }
                    });
                }
            }));
            commandPanel.add(new JButton(new AbstractAction("Cancel") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(dialog::dispose);
                }
            }));
            dialog.add(commandPanel, BorderLayout.SOUTH);

            SwingUtil.showDialog(dialog, editor.canvas);
        }

        //todo use Constraints-exception
        // todo turn into Set<Relationship> constraints like deleteNode pattern
        private boolean hasDependents(final Node parameterNode, StringBuilder constraints) {
            final String constraintsAtStart = constraints.toString();
            incoming(parameterNode, TEMPLATE_PARAMETER).forEach(relationship -> {
                final Node dependentValue = other(parameterNode, relationship);
                constraints.append("\n").append(NeoModel.getNameOrLabelFrom(parameterNode)).append(" (").append(uuidOf(parameterNode)).append(") is used by ").append(NeoModel.getNameOrLabelFrom(dependentValue)).append(" (").append(uuidOf(dependentValue)).append(")");
            });
            return !constraintsAtStart.equals(constraints.toString());
        }

        private boolean hasDependents(final Node parameterNode, StringBuilder constraints, String key) {
            final String constraintsAtStart = constraints.toString();
            incoming(parameterNode, TEMPLATE_PARAMETER).forEach(relationship -> {
                final Node dependentValue = other(parameterNode, relationship);
                if (dependentValue.hasProperty(key))
                    constraints.append("\n").append(NeoModel.getNameOrLabelFrom(parameterNode)).append(" (").append(uuidOf(parameterNode)).append(").").append(key).append(" is used by ").append(NeoModel.getNameOrLabelFrom(dependentValue)).append(" (").append(uuidOf(dependentValue)).append(")");
            });
            return !constraintsAtStart.equals(constraints.toString());
        }
    }

    private class SetTemplateStatementParameter extends NeoEditor.TransactionAction {

        private final Node parameterNode;
        private final Node templateStatement;

        SetTemplateStatementParameter(String name, Node parameterNode, Node templateStatement) {
            super("Set parameter " + name + " to statements of " + get(templateStatement, "name"), editor.getGraph(), editor.canvas);
            this.parameterNode = parameterNode;
            this.templateStatement = templateStatement;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            if (isRelated(parameterNode, templateStatement, TemplateDomain.TemplateRelations.STATEMENT_PARAMETER))
                getRelationship(parameterNode, templateStatement, TemplateDomain.TemplateRelations.STATEMENT_PARAMETER).delete();

            final Relationship statementParameterRelation = parameterNode.createRelationshipTo(templateStatement, TemplateDomain.TemplateRelations.STATEMENT_PARAMETER);
            editor.addRelation(statementParameterRelation);
            updateView();
        }
    }

    private class NewStatement extends NeoEditor.TransactionAction {

        NewStatement() {
            super("New " + get(node, TemplateDomain.TemplateProperties.name.name()), editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            editor.
                    show(uuidOf(TemplateDomain.newStatement(editor.getGraph(), node)), TemplateDomain.TemplateLabels.Statement.name()).
                    setOffset(getRandomPosition());
        }
    }

    private class ShowTemplateGroup extends NeoEditor.TransactionAction {

        ShowTemplateGroup() {
            super("Show TemplateGroup", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            editor.
                    show(uuidOf(other(node, singleOutgoing(node, TEMPLATE_GROUP))), TemplateDomain.TemplateLabels.TemplateGroup.name()).
                    setOffset(getRandomPosition());
        }
    }

    private class ShowTemplateParameters extends NeoEditor.TransactionAction {

        ShowTemplateParameters() {
            super("Show parameters", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<UUID, Label> pNodes = new LinkedHashMap<>();

            // show parameters
            new TemplateGroupVisitor() {
                @Override
                protected void onSingleTemplateParameter(String name, Node parameterNode) {
                    pNodes.put(uuidOf(parameterNode), SingleTemplateParameter);
                }

                @Override
                protected void onListTemplateParameter(String name, Node parameterNode) {
                    pNodes.put(uuidOf(parameterNode), ListTemplateParameter);
                }

                @Override
                protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
                    pNodes.put(uuidOf(parameterNode), KeyValueTemplateParameter);
                }

            }.visitTemplateStatement(node);

            editor.showAndLayout(pNodes, pNode);
        }
    }

    private class ShowStatements extends NeoEditor.TransactionAction {

        ShowStatements() {
            super("Expand", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            expand();
        }
    }

    private class HideParameters extends NeoEditor.TransactionAction {

        HideParameters() {
            super("Hide parameters", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            new TemplateGroupVisitor() {
                @Override
                protected void onSingleTemplateParameter(String name, Node parameterNode) {
                    editor.removeNodeFromCanvas(uuidOf(parameterNode));
                }

                @Override
                protected void onListTemplateParameter(String name, Node parameterNode) {
                    editor.removeNodeFromCanvas(uuidOf(parameterNode));
                }

                @Override
                protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
                    editor.removeNodeFromCanvas(uuidOf(parameterNode));
                }

            }.visitTemplateStatement(node);
        }
    }
}
