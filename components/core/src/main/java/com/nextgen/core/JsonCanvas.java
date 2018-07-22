package com.nextgen.core;

import io.vertx.core.json.JsonObject;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class JsonCanvas extends NodeCanvas {

    public JsonCanvas() {
        super(new Dimension(1024, 768), Color.WHITE);
    }

    protected class JsonPNode extends NodeCanvas.BasePNode {

        final Color defaultColor;
        final Color highlightedColor;
        final Color selectedColor;

        final PText child;
        final String label;

        public JsonPNode(JsonObject jsonObject, String label, Color defaultColor, Color highlightedColor, Color selectedColor) {
            super(UUID.fromString(jsonObject.getString("uuid")), jsonObject);

            this.defaultColor = defaultColor;
            this.highlightedColor = highlightedColor;
            this.selectedColor = selectedColor;

            this.label = label;
            this.child = new PText(jsonObject.getString(label) == null || jsonObject.getString(label).length() == 0 ? getClass().getSimpleName() : jsonObject.getString(label));
            this.child.setTextPaint(defaultColor);
            addChild(this.child);

        }

        @Override
        public JComponent getEditor() {
            final JTextArea editor = newTextArea();
            editor.setText(content().encodePrettily());
            editor.setEditable(false);
            nodeChangeSupport.addPropertyChangeListener(nodeEvent("content"), evt -> SwingUtilities.invokeLater(() -> editor.setText(((JsonObject) evt.getNewValue()).encodePrettily())));
            return editor;
        }

        @Override
        public void setNodeChangeSupport(PropertyChangeSupport canvasChangeSupport) {
            super.setNodeChangeSupport(canvasChangeSupport);
            nodeChangeSupport.addPropertyChangeListener(nodeEvent("content"), evt -> SwingUtilities.invokeLater(() -> setLabel(content().getString(label) == null || content().getString(label).length() == 0 ? getClass().getSimpleName() : content().getString(label))));
        }

        public JsonObject content() {
            return ((JsonObject) getAttribute("content")).copy();
        }

        public void setLabel(String label) {
            this.child.setText(label);
            SwingUtilities.invokeLater(() -> {
                invalidatePaint();
                repaint();
            });
        }

        @Override
        public void highlight() {
            child.setTextPaint(highlightedColor);
            super.highlight();
        }

        @Override
        public void unhighlight() {
            child.setTextPaint(getBooleanAttribute("selected", false) ? selectedColor : defaultColor);
            super.unhighlight();
        }

        @Override
        public void unselect() {
            child.setTextPaint(defaultColor);
            super.unselect();
        }

        @Override
        public void select() {
            child.setTextPaint(selectedColor);
            super.select();
        }

        @Override
        public String toString() {
            return child.getText();
        }
    }

    protected class JsonRelationship extends Relation {

        public JsonRelationship(JsonObject relationship, String label, JsonPNode src, JsonPNode dst) {
            this(relationship, label, src, dst, Color.decode("#bdbdbd"), Color.decode("#e34a33"), Color.decode("#636363"));
        }

        public JsonRelationship(JsonObject relationship, String label, JsonPNode src, JsonPNode dst, Color defaultColor, Color selectedColor, Color highlightedColor) {
            super(relationship.getString("uuid") != null ? UUID.fromString(relationship.getString("uuid")) : UUID.randomUUID(), relationship, label, src, dst, defaultColor, selectedColor, highlightedColor);
        }

        @Override
        public JComponent getEditor() {
            final JTextArea textArea = newTextArea();
            textArea.setText(((JsonObject)getContent()).encodePrettily());
            return textArea;
        }
    }

    public static class EditorPanel extends JPanel {

        public EditorPanel(JsonCanvas canvas) {
            super(new BorderLayout(), true);

            final JTabbedPane contentPanel = new JTabbedPane();
            add(contentPanel, BorderLayout.CENTER);

            final JTextArea textArea = newTextArea();
            final JScrollPane logComponent = new JScrollPane(textArea);
            contentPanel.add("log", logComponent);

            final Map<String, Component> componentMap = new ConcurrentHashMap<>();
            componentMap.put("log", logComponent);

            canvas.getCanvasChangeSupport().addPropertyChangeListener(evt -> SwingUtilities.invokeLater(() -> {

                textArea.append("\n" + evt.getPropertyName() + " : " + evt.getOldValue() + " -> " + evt.getNewValue());

                final String[] n = evt.getPropertyName().split("[.]");
                final String uuid = n[1];

                if ("node".equals(n[0])) {

                    if ("selected".equals(n[2])) {

                        final BasePNode node = (BasePNode) evt.getOldValue();
                        if (node == null)
                            return;

                        if (Boolean.valueOf(evt.getNewValue().toString())) {

                            componentMap.put(uuid, new JScrollPane(node.getEditor()));
                            contentPanel.add(uuid, componentMap.get(uuid));
                            contentPanel.setSelectedComponent(componentMap.get(uuid));

                        } else {
                            final Component remove = componentMap.remove(uuid);
                            if (remove != null) contentPanel.remove(remove);
                        }

                    } else if ("closed".equals(n[2])) {
                        final Component remove = componentMap.remove(uuid);
                        if (remove != null) contentPanel.remove(remove);
                    }

                } else if ("relation".equals(n[0])) {

                    if ("selected".equals(n[2])) {

                        final Relation relation = (Relation) evt.getOldValue();
                        if (relation == null)
                            return;

                        if (Boolean.valueOf(evt.getNewValue().toString())) {

                            componentMap.put(uuid, new JScrollPane(relation.getEditor()));
                            contentPanel.add(uuid, componentMap.get(uuid));
                            contentPanel.setSelectedComponent(componentMap.get(uuid));

                        } else {
                            final Component remove = componentMap.remove(uuid);
                            if (remove != null) contentPanel.remove(remove);
                        }

                    } else if ("closed".equals(n[2])) {
                        final Component remove = componentMap.remove(uuid);
                        if (remove != null) contentPanel.remove(remove);
                    }
                }
            }));
        }
    }
}