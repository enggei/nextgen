package com.generator.generators.json;

import com.generator.util.SwingUtil;
import com.jgoodies.forms.layout.CellConstraints;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created 26.05.18.
 */
public class JsonPanels {

    static final Boolean DEBUG = true;

    public static void main(String[] args) {

        final JsonObject jsonObject = new JsonObject().
                put("name", "name").
                put("age", 100).
                put("active", Boolean.FALSE).
                put("status", "Inactive").
                put("currentHost", new JsonObject().
                        put("ip", "127.0.0.1").
                        put("name", "localhost").
                        put("port", 80)).
                put("hosts", new JsonArray().
                        add(new JsonObject().
                                put("ip", "127.0.0.1").
                                put("name", "localhost").
                                put("port", 80)).
                        add(new JsonObject().
                                put("ip", "192.168.1.1").
                                put("name", "nextgen").
                                put("port", 90)).
                        add(110).
                        add("HelloW"));

        final JsonObject meta = new JsonObject();
        meta.put("status", new JsonArray().add("Active").add("Inactive").add("Unknown"));
        final JsonPanel panel = new JsonPanel(null, jsonObject, meta, (name, initialValue, element) -> System.out.println(name + " changed. Initial value '" + initialValue + "' new value '" + element.getValue() + "'"));

        final JTextField txtName = panel.getTextField("name");
        txtName.setBackground(Color.RED);

        final JsonArrayPanel hosts = panel.getJsonArrayPanel("hosts");
        final Set<JTextField> txtHostNames = hosts.getTextFields("name");
        for (JTextField txtHostName : txtHostNames)
            txtHostName.setBackground(Color.LIGHT_GRAY);

        if (!jsonObject.encode().equals(panel.toJsonObject().encode())) {
            System.out.println(jsonObject.encodePrettily());
            System.out.println(panel.toJsonObject().encodePrettily());
        }

        final JsonObjectJTree jTree = new JsonObjectJTree(jsonObject);
        jTree.addNodeAction("name", new NodeAction() {
            @Override
            public String getName() {
                return "Set name";
            }

            @Override
            public void actionPerformed(ActionEvent e, JsonTreeNode node) {

                final String newValue = SwingUtil.showInputDialog("New name", jTree, node.value());
                if (newValue == null || node.value().equals(newValue)) return;

                node.setValue(newValue, jTree);
            }
        });

        jTree.addNodeAction("hosts.*.name", new NodeAction() {
            @Override
            public String getName() {
                return "Set name";
            }

            @Override
            public void actionPerformed(ActionEvent e, JsonTreeNode node) {

                final String newValue = SwingUtil.showInputDialog("New name", jTree, node.value());
                if (newValue == null || node.value().equals(newValue)) return;

                node.setValue(newValue, jTree);
            }
        });

        final JPanel content = new JPanel(new BorderLayout());
        content.add(panel, BorderLayout.CENTER);
        content.add(jTree, BorderLayout.WEST);
        content.add(new JButton(new SwingUtil.SwingAction("ToJson") {
            @Override
            public void onActionPerformed(ActionEvent e) {
                System.out.println(panel.toJsonObject());
            }
        }), BorderLayout.SOUTH);

        SwingUtil.showPanel(content);
    }


    public static final class JsonPanel extends JPanel implements ChangeListener {

        private final Map<String, FormElement> formElementMap;
        private final Set<ChangeListener> changeListeners = Collections.synchronizedSet(new LinkedHashSet<>());

        // fieldName != null when the jsonObject is child of another jsonObject
        private String fieldName = null;

        public JsonPanel(JsonObject jsonObject) {
            this(jsonObject, new JsonObject());
        }

        public JsonPanel(JsonObject jsonObject, JsonObject meta) {
            this(null, jsonObject, meta, null);
        }

        public JsonPanel(JsonObject jsonObject, JsonObject meta, ChangeListener changeListener) {
            this(null, jsonObject, meta, changeListener);
        }

        public JsonPanel(String fieldname, JsonObject jsonObject, JsonObject meta, ChangeListener changeListener) {
            super(new BorderLayout(), true);

            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            this.formElementMap = new LinkedHashMap<>();
            this.fieldName = fieldname;

            final Set<String> fieldNames = jsonObject.fieldNames();
            for (String fieldName : fieldNames) {
                final Object value = jsonObject.getValue(fieldName);
                if (value instanceof String) {

                    final JsonArray jsonArray = meta.getJsonArray(fieldName);
                    if (jsonArray != null)
                        // assume enums:
                        formElementMap.put(fieldName, new EnumElement(fieldName, value, toVector(jsonArray), this));
                    else
                        formElementMap.put(fieldName, new StringElement(fieldName, value, this));

                } else if (value instanceof Integer) {
                    formElementMap.put(fieldName, new IntegerElement(fieldName, value, this));
                } else if (value instanceof Boolean) {
                    formElementMap.put(fieldName, new BooleanElement(fieldName, value, this));
                } else if (value instanceof JsonObject) {
                    formElementMap.put(fieldName, new JsonObjectElement(fieldName, new JsonPanel(fieldName, (JsonObject) value, meta, this)));
                } else if (value instanceof byte[]) {
                    formElementMap.put(fieldName, new ByteElement(fieldName, value, this));
                } else if (value instanceof Double) {
                    formElementMap.put(fieldName, new DoubleElement(fieldName, value, this));
                } else if (value instanceof Float) {
                    formElementMap.put(fieldName, new FloatElement(fieldName, value, this));
                } else if (value instanceof Instant) {
                    formElementMap.put(fieldName, new InstantElement(fieldName, value, this));
                } else if (value instanceof Long) {
                    formElementMap.put(fieldName, new LongElement(fieldName, value, this));
                } else if (value instanceof JsonArray) {
                    formElementMap.put(fieldName, new JsonArrayElement(fieldName, new JsonArrayPanel(fieldName, (JsonArray) value, meta, this)));
                }
            }

            final StringBuilder rowSpec = new StringBuilder("");

            for (int i = 0; i < formElementMap.size(); i++) {
                if (i > 0) rowSpec.append(",4dlu,");
                rowSpec.append("pref");
            }

            if (DEBUG) {

                final SwingUtil.DebugFormPanel formPanel = new SwingUtil.DebugFormPanel("50dlu,4dlu,150dlu:grow", rowSpec.toString());
                int r = 1;
                int c = 1;
                for (Map.Entry<String, FormElement> entry : formElementMap.entrySet()) {
                    formPanel.addLabel(entry.getKey(), c, r, CellConstraints.LEFT, CellConstraints.TOP);
                    formPanel.add(entry.getValue().component, c + 2, r);
                    r += 2;
                }
                add(formPanel.build(), BorderLayout.CENTER);

            } else {

                final SwingUtil.FormPanel formPanel = new SwingUtil.FormPanel("50dlu,4dlu,150dlu:grow", rowSpec.toString());
                int r = 1;
                int c = 1;
                for (Map.Entry<String, FormElement> entry : formElementMap.entrySet()) {
                    formPanel.addLabel(entry.getKey(), c, r, CellConstraints.LEFT, CellConstraints.TOP);
                    formPanel.add(entry.getValue().component, c + 2, r);
                    r += 2;
                }
                add(formPanel.build(), BorderLayout.CENTER);
            }

            if (changeListener != null) changeListeners.add(changeListener);
        }

        public void addChangeListener(ChangeListener changeListener) {
            this.changeListeners.add(changeListener);
        }

        public JTextField getTextField(String fieldname) {
            return (JTextField) formElementMap.get(fieldname).component;
        }

//      public JCheckBox getCheckBox(String fieldname) {
//         return (JCheckBox) formElementMap.get(fieldname).component;
//      }

//      public JComboBox getComboBox(String fieldname) {
//         return (JComboBox) formElementMap.get(fieldname).component;
//      }

//      public JsonPanel getJsonPanel(String fieldname) {
//         return (JsonPanel) formElementMap.get(fieldname).component;
//      }

        JsonArrayPanel getJsonArrayPanel(String fieldname) {
            return (JsonArrayPanel) formElementMap.get(fieldname).component;
        }

        public JsonObject toJsonObject() {
            final JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, FormElement> entry : formElementMap.entrySet())
                jsonObject.put(entry.getKey(), entry.getValue().getValue());
            return jsonObject;
        }

        @Override
        public void onChange(String name, Object initialValue, FormElement element) {
            for (ChangeListener changeListener : changeListeners)
                changeListener.onChange((fieldName == null ? "" : (fieldName + ".")) + name, initialValue, element);
        }
    }

    public static final class JsonArrayPanel extends JPanel implements ChangeListener {

        private final List<FormElement> formElementList;
        private final Set<ChangeListener> changeListeners = Collections.synchronizedSet(new LinkedHashSet<>());

        private final String fieldName;

        public JsonArrayPanel(JsonArray jsonArray, JsonObject meta) {
            this(null, jsonArray, meta, null);
        }

        private JsonArrayPanel(String fieldName, JsonArray jsonArray, JsonObject meta, ChangeListener changeListener) {
            super(new BorderLayout(), true);

            this.fieldName = fieldName;
            this.formElementList = new ArrayList<>(jsonArray.size());

            Integer index = 0;
            for (Object value : jsonArray) {

                if (value instanceof String) {
                    formElementList.add(new StringElement(index.toString(), value, this));
                } else if (value instanceof Integer) {
                    formElementList.add(new IntegerElement(index.toString(), value, this));
                } else if (value instanceof Boolean) {
                    formElementList.add(new BooleanElement(index.toString(), value, this));
                } else if (value instanceof JsonObject) {
                    formElementList.add(new JsonObjectElement(new JsonPanel(index.toString(), (JsonObject) value, meta, this)));
                } else if (value instanceof byte[]) {
                    formElementList.add(new ByteElement(index.toString(), value, this));
                } else if (value instanceof Double) {
                    formElementList.add(new DoubleElement(index.toString(), value, this));
                } else if (value instanceof Float) {
                    formElementList.add(new FloatElement(index.toString(), value, this));
                } else if (value instanceof Instant) {
                    formElementList.add(new InstantElement(index.toString(), value, this));
                } else if (value instanceof Long) {
                    formElementList.add(new LongElement(index.toString(), value, this));
                } else if (value instanceof JsonArray) {
                    formElementList.add(new JsonArrayElement(new JsonArrayPanel(index.toString(), (JsonArray) value, meta, this)));
                }

                index++;
            }

            final StringBuilder rowSpec = new StringBuilder("");

            for (int i = 0; i < formElementList.size(); i++) {
                if (i > 0) rowSpec.append(",8dlu,");
                rowSpec.append("pref");
            }

            if (DEBUG) {

                final SwingUtil.DebugFormPanel formPanel = new SwingUtil.DebugFormPanel("150dlu:grow", rowSpec.toString());
                int r = 1;
                for (FormElement formElement : formElementList) {
                    formPanel.add(formElement.component, 1, r);
                    r += 2;
                }
                add(formPanel.build(), BorderLayout.CENTER);

            } else {

                final SwingUtil.FormPanel formPanel = new SwingUtil.FormPanel("150dlu:grow", rowSpec.toString());
                int r = 1;
                for (FormElement formElement : formElementList) {
//               formElement.jsonPanel = this;
                    formPanel.add(formElement.component, 1, r);
                    r += 2;
                }
                add(formPanel.build(), BorderLayout.CENTER);
            }

            if (changeListener != null) changeListeners.add(changeListener);
        }

//      public JsonArrayPanel addChangeListener(ChangeListener changeListener) {
//         this.changeListeners.add(changeListener);
//         return this;
//      }

        public JsonArray toJsonArray() {
            final JsonArray jsonArray = new JsonArray();
            for (FormElement formElement : formElementList)
                jsonArray.add(formElement.getValue());
            return jsonArray;
        }

        public Set<JTextField> getTextFields(String fieldname) {
            final Set<JTextField> set = new LinkedHashSet<>();
            for (FormElement formElement : formElementList) {
                final JComponent component = formElement.component;
                if (component instanceof JsonPanel)
                    set.add(((JsonPanel) component).getTextField(fieldname));
            }
            return set;
        }

        @Override
        public void onChange(String name, Object initialValue, FormElement element) {
            for (ChangeListener changeListener : changeListeners)
                changeListener.onChange((fieldName == null ? "" : (fieldName + ".")) + name, initialValue, element);
        }
    }

    public static abstract class FormElement<T extends JComponent> {

        final String name;
        final T component;

        FormElement(String name, T component) {
            this.name = name;
            this.component = component;
        }

        public abstract Object getValue();
    }

    public static final class StringElement extends FormElement<JTextField> {

        StringElement(String fieldName, Object value, ChangeListener changeListener) {
            super(fieldName, new JTextField(value.toString()));

            component.addActionListener(e -> changeListener.onChange(name, value, StringElement.this));
        }

        @Override
        public Object getValue() {
            return component.getText().trim();
        }
    }

    public static final class EnumElement extends FormElement<JComboBox> {

        EnumElement(String fieldName, Object value, Vector<String> items, ChangeListener changeListener) {
            super(fieldName, new JComboBox<>(items));
            if (value != null) component.setSelectedItem(value);

            component.addActionListener(e -> changeListener.onChange(name, value, EnumElement.this));
        }

        @Override
        public Object getValue() {
            return component.getSelectedItem();
        }
    }

    public static final class IntegerElement extends FormElement<JTextField> {

        IntegerElement(String name, Object value, ChangeListener changeListener) {
            super(name, new JTextField(value.toString()));

            component.addActionListener(e -> changeListener.onChange(name, value, IntegerElement.this));
        }

        @Override
        public Object getValue() {
            try {
                return Integer.valueOf(component.getText().trim());
            } catch (Throwable t) {
                return null;
            }
        }
    }

    public static final class BooleanElement extends FormElement<JCheckBox> {

        BooleanElement(String name, Object value, ChangeListener changeListener) {
            super(name, new JCheckBox(name, (Boolean) value));
            component.addActionListener(e -> changeListener.onChange(name, value, BooleanElement.this));
        }

        @Override
        public Object getValue() {
            return component.isSelected();
        }
    }

    public static final class ByteElement extends FormElement<JTextField> {

        ByteElement(String name, Object value, ChangeListener changeListener) {
            super(name, new JTextField(value.toString()));
            component.addActionListener(e -> changeListener.onChange(name, value, ByteElement.this));
        }

        @Override
        public Object getValue() {
            // todo: find better component for byte, and return appropriately:
            return component.getText().getBytes();
        }
    }

    public static final class DoubleElement extends FormElement<JTextField> {

        DoubleElement(String name, Object value, ChangeListener changeListener) {
            super(name, new JTextField(value.toString()));
            component.addActionListener(e -> changeListener.onChange(name, value, DoubleElement.this));
        }

        @Override
        public Object getValue() {
            try {
                return Double.parseDouble(component.getText().trim());
            } catch (Throwable t) {
                return null;
            }

        }
    }

    public static final class FloatElement extends FormElement<JTextField> {

        FloatElement(String name, Object value, ChangeListener changeListener) {
            super(name, new JTextField(value.toString()));
            component.addActionListener(e -> changeListener.onChange(name, value, FloatElement.this));
        }

        @Override
        public Object getValue() {
            try {
                return Float.parseFloat(component.getText().trim());
            } catch (Throwable t) {
                return null;
            }

        }
    }

    public static final class InstantElement extends FormElement<JTextField> {

        InstantElement(String name, Object value, ChangeListener changeListener) {
            super(name, new JTextField(value.toString()));
            component.addActionListener(e -> changeListener.onChange(name, value, InstantElement.this));
        }

        @Override
        public Object getValue() {
            try {
                return Instant.parse(component.getText().trim());
            } catch (Throwable t) {
                return null;
            }

        }
    }

    public static final class LongElement extends FormElement<JTextField> {

        LongElement(String name, Object value, ChangeListener changeListener) {
            super(name, new JTextField(value.toString()));
            component.addActionListener(e -> changeListener.onChange(name, value, LongElement.this));
        }

        @Override
        public Object getValue() {
            try {
                return Long.parseLong(component.getText().trim());
            } catch (Throwable t) {
                return null;
            }

        }
    }

    public static final class JsonObjectElement extends FormElement<JsonPanel> {

        JsonObjectElement(String name, JsonPanel jsonPanel) {
            super(name, jsonPanel);
        }

        JsonObjectElement(JsonPanel jsonPanel) {
            this(null, jsonPanel);
        }

        @Override
        public Object getValue() {
            return component.toJsonObject();
        }
    }

    public static final class JsonArrayElement extends FormElement<JsonArrayPanel> {

        JsonArrayElement(String name, JsonArrayPanel jsonPanel) {
            super(name, jsonPanel);
        }

        JsonArrayElement(JsonArrayPanel jsonPanel) {
            this(null, jsonPanel);
        }

        @Override
        public Object getValue() {
            return component.toJsonArray();
        }
    }

    private static Vector<String> toVector(JsonArray jsonArray) {
        final Vector<String> vector = new Vector<>();
        for (Object o : jsonArray)
            vector.add(o.toString());
        return vector;
    }

    public interface ChangeListener {

        void onChange(String name, Object initialValue, FormElement element);

    }

    public static class JsonObjectJTree extends JTree {

        private final Map<String, Set<NodeAction>> actions = new ConcurrentHashMap<>();

        public enum Renderer {
            FIELD, VALUE, FIELD_VALUE
        }

        private Renderer renderer = Renderer.FIELD;

        public JsonObjectJTree(JsonObject jsonObject) {
            super(new DefaultTreeModel(new JsonObjectTreeNode("", jsonObject)));

            setRootVisible(false);

            setCellRenderer(new DefaultTreeCellRenderer() {
                @Override
                public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                    final JsonTreeNode nodeEntry = (JsonTreeNode) value;
                    switch (renderer) {
                        case FIELD:
                            return super.getTreeCellRendererComponent(tree, nodeEntry.fieldName(), sel, expanded, leaf, row, hasFocus);
                        case VALUE:
                            return super.getTreeCellRendererComponent(tree, nodeEntry.value(), sel, expanded, leaf, row, hasFocus);
                        case FIELD_VALUE:
                            return super.getTreeCellRendererComponent(tree, nodeEntry.fieldNameAndValue(), sel, expanded, leaf, row, hasFocus);
                    }
                    return super.getTreeCellRendererComponent(tree, nodeEntry.getUserObject().toString(), sel, expanded, leaf, row, hasFocus);
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    final TreePath selectionPath = ((JTree) e.getSource()).getSelectionPath();
                    if (selectionPath == null) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            final JPopupMenu pop = new JPopupMenu();

                            final JMenu rendererMenu = new JMenu("Renderer");
                            rendererMenu.add(new SwingUtil.SwingAction("Field") {
                                @Override
                                public void onActionPerformed(ActionEvent e) {
                                    renderer = Renderer.FIELD;
                                    SwingUtilities.invokeLater(() -> {
                                        invalidate();

                                    });
                                }
                            });
                            rendererMenu.add(new SwingUtil.SwingAction("Value") {
                                @Override
                                public void onActionPerformed(ActionEvent e) {
                                    renderer = Renderer.VALUE;
                                    SwingUtilities.invokeLater(() -> invalidate());
                                }
                            });
                            rendererMenu.add(new SwingUtil.SwingAction("Field and Value") {
                                @Override
                                public void onActionPerformed(ActionEvent e) {
                                    renderer = Renderer.FIELD_VALUE;
                                    SwingUtilities.invokeLater(() -> invalidate());
                                }
                            });
                            pop.add(rendererMenu);

                            if (pop.getComponentCount() == 0) return;
                            SwingUtil.showPopup(pop, ((JTree) e.getSource()), e);
                        }
                        return;
                    }
                    final JsonTreeNode selectedNode = (JsonTreeNode) selectionPath.getLastPathComponent();
                    if (selectedNode == null) return;
                    if (SwingUtilities.isRightMouseButton(e)) {
                        final JPopupMenu pop = new JPopupMenu();

                        final String path = selectedNode.toJsonPath();
                        System.out.println(path);

                        Set<NodeAction> nodeActions = actions.get(path);
                        if (nodeActions == null) return;

                        for (NodeAction nodeAction : nodeActions) {
                            pop.add(new SwingUtil.SwingAction(nodeAction.getName()) {
                                @Override
                                public void onActionPerformed(ActionEvent e) {
                                    nodeAction.actionPerformed(e, selectedNode);
                                }
                            });
                        }

                        if (pop.getComponentCount() == 0) return;
                        SwingUtil.showPopup(pop, ((JTree) e.getSource()), e);
                    }
                }
            });

        }

        public void addNodeAction(String path, NodeAction nodeAction) {
            actions.computeIfAbsent(path, k -> new LinkedHashSet<>()).add(nodeAction);
        }
    }

    public interface NodeAction {

        String getName();

        void actionPerformed(ActionEvent e, JsonTreeNode node);
    }

    public static abstract class JsonTreeNode<T> extends DefaultMutableTreeNode {

        T value;
        final Boolean isArrayElement;

        JsonTreeNode(String fieldName, T value, Boolean isArrayElement) {
            super(fieldName);
            this.value = value;
            this.isArrayElement = isArrayElement;
        }

        String fieldName() {
            return getUserObject() == null ? "" : getUserObject().toString();
        }

        String value() {
            return value.toString();
        }

        String fieldNameAndValue() {
            return getUserObject().toString() + " : " + value.toString();
        }

        String toJsonPath() {
            final TreeNode parent = getParent();
            if (!(parent instanceof JsonTreeNode)) return isArrayElement ? "*" : fieldName();
            final String parentPath = ((JsonTreeNode) parent).toJsonPath();
            return parentPath + ((parentPath == null || parentPath.length() == 0) ? "" : ".") + (isArrayElement ? "*" : fieldName());
        }

        void setValue(T value, JTree tree) {
            this.value = value;
            System.out.println(toJsonPath() + " new value " + value);
            final DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());
            model.valueForPathChanged(getPath(this), value);
        }

        static TreePath getPath(TreeNode treeNode) {
            final List<Object> nodes = new ArrayList<>();
            nodes.add(treeNode);

            treeNode = treeNode.getParent();
            while (treeNode != null) {
                nodes.add(0, treeNode);
                treeNode = treeNode.getParent();
            }

            return nodes.isEmpty() ? new TreePath(new Object[0]) : new TreePath(nodes.toArray());
        }
    }

    public static class JsonObjectTreeNode extends JsonTreeNode<JsonObject> {

        public JsonObjectTreeNode(String name, JsonObject jsonObject) {
            super(name, jsonObject, false);

            final Set<String> fieldNames = jsonObject.fieldNames();
            for (String fieldName : fieldNames) {
                final Object value = jsonObject.getValue(fieldName);
                if (value instanceof String) {
                    add(new StringTreeNode(fieldName, (String) value));
                } else if (value instanceof Integer) {
                    add(new IntegerTreeNode(fieldName, (Integer) value));
                } else if (value instanceof Boolean) {
                    add(new BooleanTreeNode(fieldName, (Boolean) value));
                } else if (value instanceof JsonObject) {
                    add(new JsonObjectTreeNode(fieldName, (JsonObject) value));
                } else if (value instanceof byte[]) {
                    add(new ByteTreeNode(fieldName, (byte[]) value));
                } else if (value instanceof Double) {
                    add(new DoubleTreeNode(fieldName, (Double) value));
                } else if (value instanceof Float) {
                    add(new FloatTreeNode(fieldName, (Float) value));
                } else if (value instanceof Instant) {
                    add(new InstantTreeNode(fieldName, (Instant) value));
                } else if (value instanceof Long) {
                    add(new LongTreeNode(fieldName, (Long) value));
                } else if (value instanceof JsonArray) {
                    add(new JsonArrayTreeNode(fieldName, (JsonArray) value));
                }
            }
        }

        public JsonObjectTreeNode(Integer index, JsonObject jsonObject) {
            super(index.toString(), jsonObject, true);

            final Set<String> fieldNames = jsonObject.fieldNames();
            for (String fieldName : fieldNames) {
                final Object value = jsonObject.getValue(fieldName);
                if (value instanceof String) {
                    add(new StringTreeNode(fieldName, (String) value));
                } else if (value instanceof Integer) {
                    add(new IntegerTreeNode(fieldName, (Integer) value));
                } else if (value instanceof Boolean) {
                    add(new BooleanTreeNode(fieldName, (Boolean) value));
                } else if (value instanceof JsonObject) {
                    add(new JsonObjectTreeNode(fieldName, (JsonObject) value));
                } else if (value instanceof byte[]) {
                    add(new ByteTreeNode(fieldName, (byte[]) value));
                } else if (value instanceof Double) {
                    add(new DoubleTreeNode(fieldName, (Double) value));
                } else if (value instanceof Float) {
                    add(new FloatTreeNode(fieldName, (Float) value));
                } else if (value instanceof Instant) {
                    add(new InstantTreeNode(fieldName, (Instant) value));
                } else if (value instanceof Long) {
                    add(new LongTreeNode(fieldName, (Long) value));
                } else if (value instanceof JsonArray) {
                    add(new JsonArrayTreeNode(fieldName, (JsonArray) value));
                }
            }
        }
    }

    public static class StringTreeNode extends JsonTreeNode<String> {

        public StringTreeNode(String fieldName, String value) {
            super(fieldName, value, false);
        }

        public StringTreeNode(Integer index, String value) {
            super(index.toString(), value, true);
        }
    }

    public static class IntegerTreeNode extends JsonTreeNode<Integer> {

        public IntegerTreeNode(String fieldName, Integer value) {
            super(fieldName, value, false);
        }

        public IntegerTreeNode(Integer index, Integer value) {
            super(index.toString(), value, true);
        }
    }

    public static class BooleanTreeNode extends JsonTreeNode<Boolean> {

        public BooleanTreeNode(String fieldName, Boolean value) {
            super(fieldName, value, false);
        }

        public BooleanTreeNode(Integer index, Boolean value) {
            super(index.toString(), value, true);
        }
    }

    public static class ByteTreeNode extends JsonTreeNode<byte[]> {

        public ByteTreeNode(String fieldName, byte[] value) {
            super(fieldName, value, false);
        }

        public ByteTreeNode(Integer index, byte[] value) {
            super(index.toString(), value, true);
        }
    }

    public static class DoubleTreeNode extends JsonTreeNode<Double> {

        public DoubleTreeNode(String fieldName, Double value) {
            super(fieldName, value, false);
        }

        public DoubleTreeNode(Integer index, Double value) {
            super(index.toString(), value, true);
        }
    }

    public static class FloatTreeNode extends JsonTreeNode<Float> {

        public FloatTreeNode(String fieldName, Float value) {
            super(fieldName, value, false);
        }

        public FloatTreeNode(Integer index, Float value) {
            super(index.toString(), value, true);
        }
    }

    public static class InstantTreeNode extends JsonTreeNode<Instant> {

        public InstantTreeNode(String fieldName, Instant value) {
            super(fieldName, value, false);
        }

        public InstantTreeNode(Integer index, Instant value) {
            super(index.toString(), value, true);
        }
    }

    public static class LongTreeNode extends JsonTreeNode<Long> {

        public LongTreeNode(String fieldName, Long value) {
            super(fieldName, value, false);
        }

        public LongTreeNode(Integer index, Long value) {
            super(index.toString(), value, true);
        }
    }

    public static class JsonArrayTreeNode extends JsonTreeNode<JsonArray> {

        public JsonArrayTreeNode(Integer fieldName, JsonArray value) {
            super(fieldName.toString(), value, true);

            Integer index = 0;
            for (Object v : value) {
                if (v instanceof String) {
                    add(new StringTreeNode(index, (String) v));
                } else if (v instanceof Integer) {
                    add(new IntegerTreeNode(index, (Integer) v));
                } else if (v instanceof Boolean) {
                    add(new BooleanTreeNode(index, (Boolean) v));
                } else if (v instanceof JsonObject) {
                    add(new JsonObjectTreeNode(index, (JsonObject) v));
                } else if (v instanceof byte[]) {
                    add(new ByteTreeNode(index, (byte[]) v));
                } else if (v instanceof Double) {
                    add(new DoubleTreeNode(index, (Double) v));
                } else if (v instanceof Float) {
                    add(new FloatTreeNode(index, (Float) v));
                } else if (v instanceof Instant) {
                    add(new InstantTreeNode(index, (Instant) v));
                } else if (v instanceof Long) {
                    add(new LongTreeNode(index, (Long) v));
                } else if (v instanceof JsonArray) {
                    add(new JsonArrayTreeNode(index, (JsonArray) v));
                }

                index++;
            }
        }

        public JsonArrayTreeNode(String fieldName, JsonArray value) {
            super(fieldName, value, false);

            Integer index = 0;
            for (Object v : value) {
                if (v instanceof String) {
                    add(new StringTreeNode(index, (String) v));
                } else if (v instanceof Integer) {
                    add(new IntegerTreeNode(index, (Integer) v));
                } else if (v instanceof Boolean) {
                    add(new BooleanTreeNode(index, (Boolean) v));
                } else if (v instanceof JsonObject) {
                    add(new JsonObjectTreeNode(index, (JsonObject) v));
                } else if (v instanceof byte[]) {
                    add(new ByteTreeNode(index, (byte[]) v));
                } else if (v instanceof Double) {
                    add(new DoubleTreeNode(index, (Double) v));
                } else if (v instanceof Float) {
                    add(new FloatTreeNode(index, (Float) v));
                } else if (v instanceof Instant) {
                    add(new InstantTreeNode(index, (Instant) v));
                } else if (v instanceof Long) {
                    add(new LongTreeNode(index, (Long) v));
                } else if (v instanceof JsonArray) {
                    add(new JsonArrayTreeNode(index, (JsonArray) v));
                }

                index++;
            }
        }

        public void addElement(JsonObject jsonObject, JTree tree) {
            final JsonObjectTreeNode newChild = new JsonObjectTreeNode(getChildCount(), jsonObject);
            final DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());
            model.insertNodeInto(newChild, this, getChildCount());
        }
    }
}