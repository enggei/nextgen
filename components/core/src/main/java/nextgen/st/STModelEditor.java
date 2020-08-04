package nextgen.st;

import nextgen.st.domain.STParameter;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.*;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.*;

import static nextgen.st.STAppPresentationModel.newAction;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STModelEditor extends JPanel {

    private final STAppPresentationModel presentationModel;

    private final RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 60);
    private final JTree tree = new JTree();
    private final STModel stModel;
    private final DefaultTreeModel treeModel;

    private STModelNavigator stModelNavigator;

    public STModelEditor(STAppPresentationModel presentationModel, STModel stModel) {
        super(new BorderLayout());

        this.stModel = stModel;
        this.presentationModel = presentationModel;
        setBackground(Color.WHITE);

        txtEditor.setEditable(false);
        txtEditor.addKeyListener(getEditorKeyListener());
        addActionsToPopup();

        final STModelNode rootNode = new STModelNode(stModel);
        treeModel = new DefaultTreeModel(rootNode);
        tree.setModel(treeModel);
        tree.setCellRenderer(getTreeCellRenderer());
        tree.addMouseListener(getTreeMouseListener());
        tree.addTreeSelectionListener(getTreeSelectionListener(presentationModel));

        final JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setPreferredSize(new Dimension(300, 600));

        add(new RTextScrollPane(txtEditor), BorderLayout.CENTER);
        add(treeScrollPane, BorderLayout.EAST);

        setText(presentationModel.render(stModel), false);
    }

    public TreeSelectionListener getTreeSelectionListener(STAppPresentationModel presentationModel) {
        return e -> {
            setText("", false);
            getSelected(tree.getSelectionPath()).ifPresent(baseTreeNode -> presentationModel.doInTransaction(transaction -> baseTreeNode.onSelected()));
        };
    }

    public void addActionsToPopup() {
        final JPopupMenu pop = txtEditor.getPopupMenu();
        pop.addSeparator();
        pop.add(newAction("Save", actionEvent -> tryToSave()));
        pop.add(newAction("Append From Clipboard", actionEvent -> {
            txtEditor.append(SwingUtil.fromClipboard().trim());
            tryToSave();
        }));
        pop.add(newAction("Prepend From Clipboard", actionEvent -> {
            txtEditor.setText(SwingUtil.fromClipboard().trim() + txtEditor.getText());
            tryToSave();
        }));
        pop.addSeparator();
        pop.add(newAction("To Clipboard", actionEvent -> SwingUtil.toClipboard(txtEditor.getText().trim())));
    }

    public MouseListener getTreeMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e))
                    getSelected(tree.getPathForLocation(e.getX(), e.getY())).ifPresent(baseTreeNode -> showPopup(baseTreeNode, e.getX(), e.getY()));
            }
        };
    }

    public DefaultTreeCellRenderer getTreeCellRenderer() {
        return new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;
                setToolTipText(baseTreeNode.getTooltip());
                return super.getTreeCellRendererComponent(tree, baseTreeNode.getLabel(), sel, expanded, leaf, row, hasFocus);
            }
        };
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

    Optional<BaseTreeNode<?>> getSelected(TreePath selectionPath) {
        if (selectionPath == null) return Optional.empty();
        final Object lastPathComponent = selectionPath.getLastPathComponent();
        if (!(lastPathComponent instanceof BaseTreeNode<?>)) return Optional.empty();
        return Optional.of((BaseTreeNode<?>) lastPathComponent);
    }

    void tryToSave() {
        getSelected(tree.getSelectionPath()).ifPresent(baseTreeNode -> presentationModel.doInTransaction(transaction -> baseTreeNode.tryToSave()));
    }

    void refresh() {
        getSelected(tree.getSelectionPath()).ifPresent(baseTreeNode -> presentationModel.doInTransaction(transaction -> baseTreeNode.onSelected()));
    }

    void setText(String text, boolean editable) {
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
            this.tooltip = model.toString();
            this.label = model.toString();
        }

        public T getModel() {
            return (T) getUserObject();
        }

        public String getLabel() {
            return label;
        }

        protected java.util.List<Action> getActions() {
            return Collections.emptyList();
        }

        protected void nodeChanged() {
            SwingUtilities.invokeLater(() -> treeModel.nodeChanged(this));
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
        protected <T> Optional<T> getParentNode(Class<T> type) {
            if (getClass().equals(type)) return (Optional<T>) Optional.of(this);
            final TreeNode parent = getParent();
            if (!(parent instanceof BaseTreeNode)) return Optional.empty();
            return ((BaseTreeNode<?>) parent).getParentNode(type);
        }

        public String getTooltip() {
            return tooltip;
        }

        public void onSelected() {

        }

        public void tryToSave() {

        }
    }

    private class STModelNode extends BaseTreeNode<STModel> {

        private final STTemplate stTemplate;

        STModelNode(STModel stModel) {
            this(stModel, null);
        }

        STModelNode(STModel stModel, STArgument stArgument) {
            super(stModel);
            this.stTemplate = presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
            this.label = presentationModel.tryToFindArgument(stModel, "name", () -> "[" + stTemplate.getName() + "]");

            stTemplate.getParameters()
                    .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                    .forEach(stParameter -> add(new STParameterNode(stModel, stParameter)));
        }

        @Override
        public void onSelected() {
            super.onSelected();
            setText(presentationModel.render(getModel()), false);
        }
    }

    private class STParameterNode extends BaseTreeNode<STParameter> {

        private final STModel stModel;

        STParameterNode(STModel stModel, STParameter stParameter) {
            super(stParameter);
            label = stParameter.getName();
            this.stModel = stModel;
            stModel.getArgumentsSorted()
                    .filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid()))
                    .forEach(presentationModel.stArgumentConsumer(stParameter)
                            .onSingleSTValue((stArgument, stValue) -> add(new STValueNode(stValue)))
                            .onSingleSTModel((stArgument, stValue) -> add(new STModelNode(stValue.getStModel(), stArgument)))
                            .onListSTValue((stArgument, stValue) -> add(new STValueNode(stValue)))
                            .onListSTModel((stArgument, stValue) -> add(new STModelNode(stValue.getStModel(), stArgument)))
                            .onKVListConsumer((stArgument, stKVValues) -> add(new STKVArgumentNode(stKVValues, stArgument, stParameter))));
        }

        @Override
        protected List<Action> getActions() {
            final List<Action> actions = new ArrayList<>();
            switch (getModel().getType()) {
                case SINGLE:
                    actions.add(newAction("Set from Input", actionEvent ->
                            SwingUtil.showInputDialog(getModel().getName(), tree, s ->
                                    newSetValueAction(presentationModel.newSTValue(s)).actionPerformed(actionEvent))));
                    getAvailableValues().forEach(stValue -> actions.add(newSetValueAction(stValue)));
                    actions.add(presentationModel.newTransactionAction("Set from clipboard : " + cut(SwingUtil.fromClipboard()), actionEvent ->
                            newSetValueAction(presentationModel.newSTValue(SwingUtil.fromClipboard())).actionPerformed(actionEvent)));
                    break;
                case LIST:
                    actions.add(newAction("Add from Input", actionEvent ->
                            SwingUtil.showInputDialog(getModel().getName(), tree, s ->
                                    newAddValueAction(presentationModel.newSTValue(s)).actionPerformed(actionEvent))));
                    getAvailableValues().forEach(stValue -> actions.add(newAddValueAction(stValue)));
                    actions.add(presentationModel.newTransactionAction("Add from clipboard : " + cut(SwingUtil.fromClipboard()), actionEvent ->
                            newAddValueAction(presentationModel.newSTValue(SwingUtil.fromClipboard())).actionPerformed(actionEvent)));
                    break;
                case KVLIST:
                    actions.add(presentationModel.newTransactionAction("Add", actionEvent -> {
                        presentationModel.addKVArgument(stModel, getModel(), tree, stArgument -> {
                            add(new STKVArgumentNode(presentationModel.getStArgumentKVS(getModel(), stArgument), stArgument, getModel()));
                            SwingUtilities.invokeLater(() -> {
                                treeModel.nodesWereInserted(STParameterNode.this, new int[]{getChildCount() - 1});
                                refresh();
                            });
                        });
                    }));

                    break;
            }
            return actions;
        }

        private Action newSetValueAction(STValue stValue) {
            return presentationModel.newTransactionAction("Set to " + stValue.getValue(), actionEvent -> {
                while (getChildCount() != 0) treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
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

            switch (stValue.getType()) {
                case STMODEL:
                    add(new STModelNode(stValue.getStModel(), stArgument));
                    break;
                case PRIMITIVE:
                    add(new STValueNode(stValue));
                    break;
                case ENUM:
                    break;
            }
            treeModel.nodesWereInserted(STParameterNode.this, new int[]{getChildCount() - 1});
            refresh();
        }
    }

    class STKVArgumentNode extends BaseTreeNode<Collection<STArgumentKV>> {

        private final STArgument stArgument;

        public STKVArgumentNode(Collection<STArgumentKV> model, STArgument stArgument, STParameter stParameter) {
            super(model);
            this.stArgument = stArgument;
            this.label = presentationModel.tryToFindArgument(model, stParameter, "name", stParameter::getName);
            for (STArgumentKV stArgumentKV : model) {
                stParameter.getKeys()
                        .filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
                        .findFirst()
                        .ifPresent(stParameterKey -> add(new STKVNode(stArgumentKV, stParameterKey)));
            }
        }

        @Override
        protected List<Action> getActions() {
            final List<Action> actions = new ArrayList<>();
            actions.add(presentationModel.newTransactionAction("Remove", actionEvent -> {
                getParentNode(STModelNode.class).ifPresent(stModelNode -> stModelNode.getModel().removeArguments(stArgument));
                treeModel.removeNodeFromParent(STKVArgumentNode.this);
                refresh();
            }));
            return actions;
        }
    }

    private class STKVNode extends BaseTreeNode<STArgumentKV> {

        public STKVNode(STArgumentKV stArgumentKV, STParameterKey stParameterKey) {
            super(stArgumentKV);
            label = stParameterKey.getName();

            final STValue stValue = stArgumentKV.getValue();
            switch (stValue.getType()) {
                case STMODEL:
                    add(new STModelNode(stValue.getStModel()));
                    break;
                case PRIMITIVE:
                    add(new STValueNode(stValue));
                    break;
                case ENUM:
                    break;
            }
        }
    }

    private class STValueNode extends BaseTreeNode<STValue> implements PropertyChangeListener {

        public STValueNode(STValue model) {
            super(model);
            label = presentationModel.render(model);
            model.addPropertyChangeListener(this);
        }

        @Override
        public void onSelected() {
            setText(presentationModel.render(getModel()), !getModel().getType().equals(STValueType.STMODEL));
        }

        @Override
        public void tryToSave() {
            getModel().setValue(txtEditor.getText().trim());
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            presentationModel.doLaterInTransaction(evt, "set", transaction -> {
                label = presentationModel.render(getModel());
                nodeChanged();
            });
        }
    }

    private Collection<STValue> getAvailableValues() {
        final Collection<STValue> set = new ArrayList<>(getSelectedValues());
        if (stModelNavigator != null)
            set.addAll(new HashSet<>(stModelNavigator.getSelectedValues()));
        return set;
    }

    public Set<STValue> getSelectedValues() {
        final Set<STValue> values = new TreeSet<>((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()));
        final TreePath[] selectionPaths = tree.getSelectionPaths();
        if (selectionPaths == null) return values;
        for (TreePath selectionPath : selectionPaths) {
            getSelected(selectionPath).ifPresent(baseTreeNode -> {
                if (baseTreeNode instanceof STValueNode)
                    values.add(((STValueNode) baseTreeNode).getModel());
            });
        }
        return values;
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