package com.generator.generators.templates.editor;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created 10.01.17.
 */
class TemplateDomainPNode extends NeoPNode<PText> {

    final Color selectedColor = Color.RED;
    final Color defaultColor;
    private final String property;
    final TemplateDomain.TemplateLabels nodeType;

    TemplateDomainPNode(Node node, TemplateDomain.TemplateLabels nodeType, String property, String[] defaultColor, NeoEditor editor) {
        super(node, new PText(node.getProperty(property).toString()), nodeType.name(), editor);
        this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
        this.property = property;
        this.nodeType = nodeType;
        pNode.setTextPaint(this.defaultColor);
        pNode.setFont(new Font("Hack", Font.BOLD, 12));
    }

    TemplateDomainPNode(Node node, PText representation, TemplateDomain.TemplateLabels nodeType, String[] defaultColor, NeoEditor editor) {
        super(node, representation, nodeType.name(), editor);
        this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
        this.property = null;
        this.nodeType = nodeType;
        pNode.setTextPaint(this.defaultColor);
        pNode.setFont(new Font("Hack", Font.PLAIN, 12));
    }

    @Override
    public String getNodeType() {
        return nodeType.name();
    }

    @Override
    public void expand() {

    }

    @Override
    public void showDependents() {

    }

    @Override
    public void keyPressed(PInputEvent event) {
        super.keyPressed(event);
    }

    @Override
    public void updateView() {
        if (property == null) System.out.println("override updateView: property not set");
        pNode.setText(property == null ? "?" : node.getProperty(property).toString());
    }

    @Override
    public void onSelect() {
        pNode.setTextPaint(selectedColor);
    }

    @Override
    public void onUnselect() {
        pNode.setTextPaint(defaultColor);
    }

    @Override
    public void onStartHighlight() {
        pNode.setTextPaint(Color.ORANGE);
    }

    @Override
    public void onEndHighlight() {
        pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
    }

    @Override
    public void showNodeActions(JPopupMenu pop, PInputEvent event) {

        pop.add(new NeoEditor.TransactionAction("Select all " + nodeType, editor.getGraph(), editor.canvas) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                editor.getAllNodes().forEach(neoPNode -> {
                    if (neoPNode.getNodeType().equals(nodeType.name()) && !neoPNode.selected.get())
                        neoPNode.select();
                });
            }
        });
        pop.add(new NeoEditor.TransactionAction("Hide all " + nodeType, editor.getGraph(), editor.canvas) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                final Set<UUID> hide = new LinkedHashSet<>();
                editor.getAllNodes().forEach(pNode -> {
                    if (pNode.getNodeType().equals(nodeType.name())) hide.add(pNode.uuid);
                });
                hide.forEach(editor::removeNodeFromCanvas);
            }
        });

        pop.add(retainNode());
        pop.add(hideNode());
        pop.add(deleteNode());
    }
}
