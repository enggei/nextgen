package com.generator.generators.templates.editor;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.SingleValue;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 10.01.17.
 */
class SingleValuePNode extends TemplateDomainPNode {

    SingleValuePNode(Node valueNode, NeoEditor editor) {
        super(valueNode, new PText(), SingleValue, "0, 109, 44".split(", "), editor);
        pNode.setFont(new Font("Hack", Font.PLAIN, 11));
        updateView();
    }

    @Override
    public void showDependents() {
        final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

        for (Relationship relationship : node.getRelationships(INCOMING)) {
            if (NeoEditor.isAppRelated(relationship)) continue;
            final Node other = other(node, relationship);
            if (hasLabel(other, TemplateDomain.TemplateLabels.Statement.name()))
                pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Statement);
            else if (hasLabel(other, TemplateDomain.TemplateLabels.KeyValueSet.name()))
                pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.KeyValueSet);
            else
                System.out.println(other.getLabels().iterator().next());
        }

        editor.showAndLayout(pNodes, pNode);
    }

    @Override
    public void updateView() {
        final String value = getString(node, TemplateDomain.TemplateProperties.value.name());
        pNode.setText(value == null ? SingleValue.name() : (value.length() == 0 ? "EMPTY" : value));
    }

    @Override
    public void showNodeActions(JPopupMenu pop, PInputEvent event) {
        pop.add(new SetValue());
        super.showNodeActions(pop, event);
    }

    private class SetValue extends NeoEditor.TransactionAction {

        SetValue() {
            super("Edit value", editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String defaultValue = get(node, TemplateDomain.TemplateProperties.value.name());
            final String newValue = SwingUtil.showInputDialog("Value", editor.canvas, defaultValue);
            if (newValue == null || newValue.trim().equals(defaultValue)) return;

            node.setProperty(TemplateDomain.TemplateProperties.value.name(), newValue.trim());

            // notify any nodes referencing this
            editor.visitRelations(neoRelationshipPath -> {
                if (!neoRelationshipPath.target.node.equals(node)) return;
                // node is being referred by another visible node, update view on this node:
                neoRelationshipPath.source.updateView();
            });

            updateView();
        }
    }
}
