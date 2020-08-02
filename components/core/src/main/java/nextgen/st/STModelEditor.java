package nextgen.st;

import nextgen.st.domain.STParameter;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STArgument;
import nextgen.st.model.STArgumentKV;
import nextgen.st.model.STModel;
import nextgen.st.model.STValue;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static nextgen.st.STAppPresentationModel.newAction;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STModelEditor extends JPanel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelEditor.class);

    private final STAppPresentationModel presentationModel;

    private final RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 60);
    private final JTree tree = new JTree();
    private final STModel stModel;
    private final DefaultTreeModel treeModel;

    private STModelNavigator stModelNavigator;

    public STModelEditor(STAppPresentationModel presentationModel, STTemplate stTemplate, STModel stModel) {
        super(new BorderLayout());

        this.stModel = stModel;
        this.presentationModel = presentationModel;
        setBackground(Color.WHITE);

        txtEditor.setEditable(false);
        txtEditor.addKeyListener(getEditorKeyListener());
        final JPopupMenu pop = txtEditor.getPopupMenu();
        pop.addSeparator();
        pop.add(newAction("Save", actionEvent -> tryToSave()));

        final STModelNode rootNode = new STModelNode(stModel, stTemplate);
        treeModel = new DefaultTreeModel(rootNode);
        tree.setModel(treeModel);
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;
                setToolTipText(baseTreeNode.getTooltip());
                return super.getTreeCellRendererComponent(tree, baseTreeNode.getLabel(), sel, expanded, leaf, row, hasFocus);
            }
        });
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());
                    if (selectionPath == null) return;
                    final Object lastPathComponent = selectionPath.getLastPathComponent();
                    if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;
                    showPopup((BaseTreeNode<?>) lastPathComponent, e.getX(), e.getY());
                }
            }
        });
        tree.addTreeSelectionListener(e -> {

            setText("", false);

            if (e.getNewLeadSelectionPath() == null) return;
            if (tree.getSelectionCount() == 1) {
                final TreePath path = e.getPath();
                final Object lastPathComponent = path.getLastPathComponent();
                if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

                SwingUtilities.invokeLater(() -> presentationModel.doInTransaction(transaction -> {
                    if (lastPathComponent instanceof STModelNode.STParameterNode.STArgumentNode) {
                        final STModelNode.STParameterNode.STArgumentNode stArgumentNode = (STModelNode.STParameterNode.STArgumentNode) lastPathComponent;
                        setText(presentationModel.render(stArgumentNode.getModel().getValue()), stArgumentNode.editable);
                    } else if (lastPathComponent instanceof STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode) {
                        final STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode stArgumentKVNode = (STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode) lastPathComponent;
                        setText(presentationModel.render(stArgumentKVNode.getModel().getValue()), stArgumentKVNode.kvEditable);
                    } else if (lastPathComponent instanceof STModelNode) {
                        final STModelNode stModelNode = (STModelNode) lastPathComponent;
                        setText(presentationModel.render(stModelNode.getModel()), false);
                    }
                }));
            }
        });
        final JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setPreferredSize(new Dimension(300, 600));

        add(new RTextScrollPane(txtEditor), BorderLayout.CENTER);
        add(treeScrollPane, BorderLayout.EAST);

        setText(presentationModel.render(stModel), false);
    }

    private KeyListener getEditorKeyListener() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S) {
                    tryToSave();
                }
            }
        };
    }

    public void tryToSave() {
        final TreePath selectionPath = tree.getSelectionPath();
        if (selectionPath == null) return;
        final Object lastPathComponent = selectionPath.getLastPathComponent();
        if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

        if (lastPathComponent instanceof STModelNode.STParameterNode.STArgumentNode) {
            final STModelNode.STParameterNode.STArgumentNode stArgumentNode = (STModelNode.STParameterNode.STArgumentNode) lastPathComponent;
            if (stArgumentNode.isEditable()) {
                presentationModel.doInTransaction(transaction -> {
                    stArgumentNode.getModel().setValue(presentationModel.newSTValue(txtEditor.getText().trim()));
                    stArgumentNode.label = presentationModel.render(stArgumentNode.getModel().getValue());
                    log.info("Saving stArgument");
                });
            }
        } else if (lastPathComponent instanceof STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode) {
            final STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode stArgumentKVNode = (STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode) lastPathComponent;
            if (stArgumentKVNode.isEditable()) {
                presentationModel.doInTransaction(transaction -> {
                    stArgumentKVNode.getModel().setValue(presentationModel.newSTValue(txtEditor.getText().trim()));
                    stArgumentKVNode.label = presentationModel.render(stArgumentKVNode.getModel().getValue());
                    log.info("Saving stArgumentKV");
                });
            }
        }
    }

    public void refresh() {
        final TreePath selectionPath = tree.getSelectionPath();
        if (selectionPath == null) return;
        final Object lastPathComponent = selectionPath.getLastPathComponent();
        if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

        presentationModel.doInTransaction(transaction -> {
            if (lastPathComponent instanceof STModelNode.STParameterNode.STArgumentNode) {
                final STModelNode.STParameterNode.STArgumentNode stArgumentNode = (STModelNode.STParameterNode.STArgumentNode) lastPathComponent;
                setText(presentationModel.render(stArgumentNode.getModel().getValue()), false);
            } else if (lastPathComponent instanceof STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode) {
                final STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode stArgumentKVNode = (STModelNode.STParameterNode.STArgumentNode.STArgumentKVNode) lastPathComponent;
                setText(presentationModel.render(stArgumentKVNode.getModel().getValue()), false);
            }
        });
    }

    private void setText(String text, boolean editable) {
        txtEditor.setText(text);
        txtEditor.setCaretPosition(0);
        txtEditor.setEditable(editable);
    }

    public STModel getModel() {
        return stModel;
    }

    public void setModelNavigator(STModelNavigator stModelNavigator) {
        this.stModelNavigator = stModelNavigator;
    }

    private class BaseTreeNode<T> extends DefaultMutableTreeNode {

        protected String tooltip;
        protected String label;

        public BaseTreeNode(T model) {
            setUserObject(model);
            this.tooltip = "";
            this.label = model.toString();
        }

        @SuppressWarnings("unchecked")
        public T getModel() {
            return (T) getUserObject();
        }

        public String getLabel() {
            return label;
        }

        protected java.util.List<Action> getActions() {
            return Collections.emptyList();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof BaseTreeNode)) return false;
            return getModel().equals(((BaseTreeNode<?>) obj).getModel());
        }

        @Override
        public int hashCode() {
            return getModel().hashCode();
        }

        @SuppressWarnings("unchecked")
        public <T> Optional<T> getParentNode(Class<T> type) {
            if (getClass().equals(type)) return (Optional<T>) Optional.of(this);
            final TreeNode parent = getParent();
            if (!(parent instanceof BaseTreeNode)) return Optional.empty();
            return ((BaseTreeNode<?>) parent).getParentNode(type);
        }

        @SuppressWarnings("unchecked")
        protected <T> Stream<T> getChildren(Class<T> type) {
            final Iterator<BaseTreeNode<?>> iterator = new Iterator<BaseTreeNode<?>>() {
                final Enumeration<BaseTreeNode<?>> e = breadthFirstEnumeration();

                public BaseTreeNode<?> next() {
                    return e.nextElement();
                }

                public boolean hasNext() {
                    return e.hasMoreElements();
                }
            };
            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
                    .filter(baseTreeNode -> baseTreeNode.getClass().equals(type))
                    .map(baseTreeNode -> (T) baseTreeNode);
        }

        protected Optional<String> getInputFromUser(String message) {
            final String s = SwingUtil.showInputDialog(message, tree);
            return Optional.ofNullable(s == null || s.trim().length() == 0 ? null : s);
        }

        public String getTooltip() {
            return tooltip;
        }
    }

    class STModelNode extends BaseTreeNode<STModel> {

        STModelNode(STModel stModel, STTemplate stTemplate) {
            super(stModel);
            label = "[" + stTemplate.getName() + "]";
            stTemplate.getParameters()
                    .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                    .forEach(stParameter -> add(new STParameterNode(stModel, stParameter)));
        }

        private class STParameterNode extends BaseTreeNode<STParameter> {

            private final STModel stModel;

            STParameterNode(STModel stModel, STParameter stParameter) {
                super(stParameter);
                label = stParameter.getName();
                this.stModel = stModel;
                stModel.getArguments()
                        .filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid()))
                        .forEach(stArgument -> add(new STArgumentNode(stArgument, stParameter)));
            }

            @Override
            protected List<Action> getActions() {
                final List<Action> actions = new ArrayList<>();
                switch (getModel().getType()) {
                    case SINGLE:
                        getAvailableValues().forEach(stValue -> actions.add(newSetValueAction(stValue)));
                        actions.add(presentationModel.newTransactionAction("Set from clipboard : " + cut(SwingUtil.fromClipboard()), actionEvent ->
                                newSetValueAction(presentationModel.newSTValue(SwingUtil.fromClipboard())).actionPerformed(actionEvent)));
                        break;
                    case LIST:
                        getAvailableValues().forEach(stValue -> actions.add(newAddValueAction(stValue)));
                        actions.add(presentationModel.newTransactionAction("Add from clipboard : " + cut(SwingUtil.fromClipboard()), actionEvent ->
                                newAddValueAction(presentationModel.newSTValue(SwingUtil.fromClipboard())).actionPerformed(actionEvent)));
                        break;
                    case KVLIST:
                        break;
                }
                return actions;
            }

            private Action newSetValueAction(STValue stValue) {
                return presentationModel.newTransactionAction("Set to " + stValue.getValue(), actionEvent -> {
                    while (getChildCount() != 0) {
                        final STArgumentNode stArgumentNode = (STArgumentNode) getChildAt(0);
                        stModel.removeArguments(stArgumentNode.getModel());
                        treeModel.removeNodeFromParent(stArgumentNode);
                    }
                    addSTArgument(stValue);
                });
            }

            private Action newAddValueAction(STValue stValue) {
                return presentationModel.newTransactionAction("Add " + stValue.getValue(), actionEvent -> {
                    addSTArgument(stValue);
                });
            }

            private void addSTArgument(STValue stValue) {
                final STArgument stArgument = presentationModel.newSTArgument(getModel(), stValue);
                stModel.addArguments(stArgument);
                add(new STArgumentNode(stArgument, getModel()));
                treeModel.nodesWereInserted(STParameterNode.this, new int[]{0});
                refresh();
            }

            private class STArgumentNode extends BaseTreeNode<STArgument> {

                private boolean editable;

                public STArgumentNode(STArgument stArgument, STParameter stParameter) {
                    super(stArgument);

                    switch (stParameter.getType()) {
                        case SINGLE:
                        case LIST:
                            final STValue value = stArgument.getValue();
                            if (value == null) return;

                            label = cut(presentationModel.render(value));

                            switch (value.getType()) {
                                case STMODEL:
                                    final STModel stModel = value.getStModel();
                                    final STTemplate stTemplate = presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
                                    add(new STModelNode(stModel, stTemplate));
                                    editable = false;
                                    break;
                                case PRIMITIVE:
                                    editable = true;
                                    break;
                                case ENUM:
                                    editable = false;
                                    break;
                            }

                            break;

                        case KVLIST:
                            label = stParameter.getName();
                            stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues()
                                    .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
                                    .forEach(stArgumentKV -> add(new STArgumentKVNode(stArgumentKV, stParameterKey))));
                            break;
                    }
                }

                public boolean isEditable() {
                    return editable;
                }

                @Override
                protected List<Action> getActions() {
                    final List<Action> actions = new ArrayList<>();
                    getAvailableValues().forEach(stValue -> actions.add(newSetValueAction(stValue)));
                    actions.add(presentationModel.newTransactionAction("Set from clipboard : " + cut(SwingUtil.fromClipboard()), actionEvent ->
                            newSetValueAction(presentationModel.newSTValue(SwingUtil.fromClipboard())).actionPerformed(actionEvent)));
                    return actions;
                }

                private Action newSetValueAction(STValue stValue) {
                    return presentationModel.newTransactionAction("Set to " + stValue.getValue(), actionEvent -> {
                        getModel().setValue(stValue);
                        label = cut(presentationModel.render(getModel().getValue()));
                        treeModel.nodesChanged(getParent(), new int[]{getParent().getIndex(STArgumentNode.this)});
                    });
                }

                private class STArgumentKVNode extends BaseTreeNode<STArgumentKV> {

                    private boolean kvEditable;

                    public STArgumentKVNode(STArgumentKV stArgumentKV, STParameterKey stParameterKey) {
                        super(stArgumentKV);
                        label = stParameterKey.getName();

                        final STValue value = stArgumentKV.getValue();
                        if (value == null) {
                            kvEditable = false;
                            return;
                        }

                        switch (value.getType()) {
                            case STMODEL:
                                final STModel stModel = value.getStModel();
                                final STTemplate stTemplate = presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
                                add(new STModelNode(stModel, stTemplate));
                                kvEditable = false;
                                break;
                            case PRIMITIVE:
                                kvEditable = true;
                                break;
                            case ENUM:
                                kvEditable = false;
                                break;
                        }
                    }

                    public boolean isEditable() {
                        return kvEditable;
                    }

                    @Override
                    protected List<Action> getActions() {
                        final List<Action> actions = new ArrayList<>();
                        getAvailableValues().forEach(stValue -> actions.add(newSetValueAction(stValue)));
                        actions.add(presentationModel.newTransactionAction("Set from clipboard : " + cut(SwingUtil.fromClipboard()), actionEvent ->
                                newSetValueAction(presentationModel.newSTValue(SwingUtil.fromClipboard())).actionPerformed(actionEvent)));
                        return actions;
                    }

                    private Action newSetValueAction(STValue stValue) {
                        return presentationModel.newTransactionAction("Set to " + stValue.getValue(), actionEvent -> {
                            getModel().setValue(stValue);
                            label = cut(presentationModel.render(getModel().getValue()));
                            treeModel.nodesChanged(getParent(), new int[]{getParent().getIndex(STArgumentNode.this)});
                        });
                    }
                }
            }
        }
    }

    private Collection<STValue> getAvailableValues() {
        final Collection<STValue> set = new ArrayList<>();

        if (stModelNavigator != null)
            set.addAll(new HashSet<>(stModelNavigator.getSelectedValues()));

        return set;
    }

    private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
        presentationModel.doInTransaction(transaction -> {
            final List<Action> actions = lastPathComponent.getActions();
            if (actions.isEmpty()) return;

            final JPopupMenu pop = new JPopupMenu();
            for (Action action : actions)
                pop.add(action);

            SwingUtilities.invokeLater(() -> pop.show(tree, x, y));
        });
    }

    public static String cut(String text) {
        return text == null ? "null" : text.substring(0, Math.min(text.length(), 20));
    }
}