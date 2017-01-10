package com.generator.generators.templates.editor;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.BaseDomainVisitor.singleOutgoing;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.KeyValueSet;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.SingleValue;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.Statement;

/**
 * Created 10.01.17.
 */
class KeyValueSetPNode extends TemplateDomainPNode {

    private final Node templateParameter;
    private final Color defaultColor;

    KeyValueSetPNode(Node keyValueNode, PText pText, String[] color, NeoEditor editor, Node templateParameter) {
        super(keyValueNode, pText, KeyValueSet, color, editor);
        pNode.setFont(new Font("Hack", Font.PLAIN, 11));
        this.templateParameter = templateParameter;

        defaultColor = new Color(Integer.valueOf(color[0]), Integer.valueOf(color[1]), Integer.valueOf(color[2]));
        updateView();
    }

    @Override
    public void expand() {
        final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
        for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
            final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
            if (kvRelation == null) continue;
            pNodes.put(uuidOf(other(node, kvRelation)), TemplateDomain.TemplateLabels.valueOf(getString(kvRelation, TemplateDomain.TemplateProperties.relationType.name())));
        }
        editor.showAndLayout(pNodes, pNode);
    }

    @Override
    public void onSelect() {
        super.onSelect();
        for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(selectedColor);
    }

    @Override
    public void onUnselect() {
        super.onUnselect();
        for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(defaultColor);
    }

    @Override
    public void onStartHighlight() {
        super.onStartHighlight();
        for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(Color.ORANGE);
    }

    @Override
    public void onEndHighlight() {
        super.onEndHighlight();
        final Color textPaint = selected.get() ? selectedColor : defaultColor;
        for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(textPaint);
    }

    @Override
    public void updateView() {
        pNode.removeAllChildren();

        for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
            final PText keyName = new PText();
            keyName.setFont(new Font("Hack", Font.PLAIN, 11));
            keyName.setTextPaint(selected.get() ? selectedColor : defaultColor);
            pNode.addChild(keyName);

            final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
            if (kvRelation == null) {
                keyName.setText("[" + key + "]");
                continue;
            }
            keyName.setText(TemplateDomain.renderReferenceNode(other(node, kvRelation), TemplateDomain.TemplateLabels.valueOf(getString(kvRelation, TemplateDomain.TemplateProperties.relationType.name()))));
        }
    }

    @Override
    public void showNodeActions(JPopupMenu pop, PInputEvent event) {

        final JMenu setMenu = new JMenu("Set");
        final JMenu removeMenu = new JMenu("Remove");
        final String[] keys = getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ");
        for (String key : keys) {
            setMenu.add(new SetKeyValue(key));

            final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
            if (kvRelation == null) continue;

            final Node kvValue = other(node, kvRelation);
            removeMenu.add(new DetachReference(key, kvValue));
        }
        pop.add(setMenu);
        if (removeMenu.getMenuComponentCount() > 0) pop.add(removeMenu);

        pop.add(new Expand());
        pop.add(new Edit(keys));
        super.showNodeActions(pop, event);
    }

    @Override
    public void showTargetActions(JPopupMenu pop, PInputEvent event) {

        final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

        for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
            if (selectedNodes.size() == 1) {
                final Node selectedNode = selectedNodes.iterator().next().node;
                if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue)) {
                    pop.add(new NeoEditor.TransactionAction("Set " + key, editor.getGraph(), editor.canvas) {
                        @Override
                        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                            editor.addRelation(TemplateDomain.setSingleReference(selectedNode, node, RelationshipType.withName(key), editor));
                            updateView();
                            editor.clearMousePosition();
                        }
                    });
                }
            }
        }
    }

    private class Expand extends NeoEditor.TransactionAction {

        Expand() {
            super("Expand", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            expand();
        }
    }

    private class SetKeyValue extends NeoEditor.TransactionAction {
        private final String key;

        SetKeyValue(String key) {
            super("Set " + key, editor.getGraph(), editor.canvas);
            this.key = key;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String newValue = SwingUtil.showInputDialog(key + " value", editor.canvas);
            if (newValue == null) return;

            final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
            editor.addRelation(TemplateDomain.setSingleReference(newSingleValue, node, RelationshipType.withName(key), editor));
            updateView();
        }
    }

    private class DetachReference extends NeoEditor.TransactionAction {

        private final Node referencedNode;

        DetachReference(String key, Node referencedNode) {
            super("Detach " + key, editor.getGraph(), editor.canvas);
            this.referencedNode = referencedNode;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
                if (other(node, relationship).equals(referencedNode))
                    relationship.delete();
            });
            updateView();
        }
    }

    private class Edit extends NeoEditor.TransactionAction {

        private final String[] keys;

        public Edit(String[] keys) {
            super("Edit ", editor.getGraph(), editor.canvas);
            this.keys = keys;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<String, JTextField> txtKeyValues = new LinkedHashMap<>();
            final Map<String, String> existingValues = new LinkedHashMap<>();
            final StringBuilder rows = new StringBuilder();
            for (int i = 0; i < keys.length; i++) {
                if (i >= 1) rows.append(", 4dlu, ");
                rows.append("pref");
                txtKeyValues.put(keys[i], new JTextField());
                existingValues.put(keys[i], "");
            }
            final SwingUtil.FormPanel form = new SwingUtil.FormPanel("50dlu, 4dlu, 150dlu:grow", rows.toString().trim());
            form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            for (String key : keys) {
                final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
                if (kvRelation == null) continue;

                final Node kvValue = other(node, kvRelation);
                final String textValue = TemplateDomain.renderReferenceNode(kvValue, TemplateDomain.TemplateLabels.valueOf(getString(kvRelation, TemplateDomain.TemplateProperties.relationType.name())));
                txtKeyValues.get(key).setText(textValue);
                existingValues.put(key, textValue);
            }

            int row = 1;
            for (String key : keys) {
                form.addLabel(key, 1, row);
                form.add(txtKeyValues.get(key), 3, row);
                row += 2;
            }

            SwingUtil.showDialog(form, editor.canvas, "Edit", () -> editor.doInTransaction(tx1 -> {
                for (String key : keys) {
                    final String newValue = txtKeyValues.get(key).getText().trim();
                    if (newValue.equals(existingValues.get(key))) continue;

                    final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
                    editor.addRelation(TemplateDomain.setSingleReference(newSingleValue, node, RelationshipType.withName(key), editor));
                }

                updateView();
            }));
        }
    }
}
