package nextgen.st;

import com.generator.util.SwingUtil;
import nextgen.st.canvas.STCanvas;
import nextgen.st.canvas.STModelNode;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;
import nextgen.st.model.STModelDB;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class STModelNavigator extends JPanel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelNavigator.class);
    private final JTree tree = new JTree();
    private final DefaultTreeModel treeModel;
    private final JTabbedPane tabbedPane;
    final STModelDB db;
    final STRenderer stRenderer;

    public STModelNavigator(STModelDB db, STRenderer stRenderer, JTabbedPane contentPanel) {
        super(new BorderLayout());

        this.tabbedPane = contentPanel;
        this.db = db;
        this.stRenderer = stRenderer;

        final RootNode rootNode = new RootNode(db);
        treeModel = new DefaultTreeModel(rootNode);
        tree.setModel(treeModel);
        ToolTipManager.sharedInstance().registerComponent(tree);

        tree.setCellRenderer(new DefaultTreeCellRenderer() {

            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                final boolean isBaseTreeNode = value instanceof BaseTreeNode;
                if (isBaseTreeNode) {
                    final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;
                    setIcon(baseTreeNode.getIcon());
                    setOpenIcon(baseTreeNode.getIcon());
                    setClosedIcon(baseTreeNode.getIcon());
                    setLeafIcon(baseTreeNode.getIcon());
                    setToolTipText(baseTreeNode.getTooltip());
                    return super.getTreeCellRendererComponent(tree, baseTreeNode.getLabel(), sel, expanded, leaf, row, hasFocus);
                }
                return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
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

        tree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    final TreePath selectionPath = tree.getSelectionPath();
                    if (selectionPath == null) return;
                    final Object lastPathComponent = selectionPath.getLastPathComponent();
                    if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

                    final Rectangle bounds = tree.getPathBounds(selectionPath);
                    if (bounds == null) return;

                    showPopup((BaseTreeNode<?>) lastPathComponent, (int) bounds.getX(), (int) bounds.getY());
                }
            }
        });

        tree.addTreeSelectionListener(e -> {
            if (e.getNewLeadSelectionPath() == null) return;

            if (tree.getSelectionCount() == 1) {
                final TreePath path = e.getPath();
                final Object lastPathComponent = path.getLastPathComponent();

//                if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode) {
//                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode) lastPathComponent);
//                } else if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) {
//                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) lastPathComponent);
//                } else if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode.STEnumTreeNode) {
//                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode.STEnumTreeNode) lastPathComponent);
//                } else if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode.STInterfaceTreeNode) {
//                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode.STInterfaceTreeNode) lastPathComponent);
//                }
            }
        });

        setPreferredSize(new Dimension(300, 600));
        add(new JScrollPane(tree), BorderLayout.CENTER);
    }

    private class BaseTreeNode<T> extends DefaultMutableTreeNode {

        protected ImageIcon icon;
        protected String tooltip;

        public BaseTreeNode(T model, String icon) {
            setUserObject(model);
            this.icon = loadIcon(icon);
            this.tooltip = "";
        }

        @SuppressWarnings("unchecked")
        public T getModel() {
            return (T) getUserObject();
        }

        public String getLabel() {
            return getUserObject().toString();
        }

        public ImageIcon getIcon() {
            return icon;
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

        protected Optional<String> getNameFromUser() {
            return getInputFromUser("Name");
        }

        protected Optional<Boolean> confirm(String description) {
            final boolean b = SwingUtil.showConfirmDialog(tree, description + "?");
            return Optional.ofNullable(b ? Boolean.TRUE : null);
        }

        protected Action newExpandAction() {
            return newAction("Expand", actionEvent ->
                    SwingUtilities.invokeLater(() -> {

                        final List<Object> nodes = new ArrayList<>();
                        nodes.add(this);
                        TreeNode treeNode = getParent();
                        while (treeNode != null) {
                            nodes.add(0, treeNode);
                            treeNode = treeNode.getParent();
                        }

                        final TreePath treePath = new TreePath(nodes.toArray());
                        final int rowForPath = tree.getRowForPath(treePath);

                        final AtomicInteger childCount = new AtomicInteger(0);
                        getAllChildCount(this, childCount);

                        final int childOffset = rowForPath + childCount.get();
                        for (int i = rowForPath; i < childOffset; i++) {
                            tree.expandRow(i);
                        }
                    }));
        }

        private void getAllChildCount(TreeNode treeNode, AtomicInteger childCount) {
            for (int i = 0; i < treeNode.getChildCount(); i++) {
                childCount.incrementAndGet();
                final TreeNode childAt = treeNode.getChildAt(i);
                getAllChildCount(childAt, childCount);
            }
        }

        public String getTooltip() {
            return tooltip;
        }
    }

    class RootNode extends BaseTreeNode<String> {

        public RootNode(STModelDB db) {
            super("DB", "RootNode");

            db.doInTransaction(transaction -> {
                db.getGroupModels().forEach(stGroupModel -> {
                    add(new STGroupModelTreeNode(stGroupModel));
                });
            });
        }

        class STGroupModelTreeNode extends BaseTreeNode<STGroupModel> {

            public STGroupModelTreeNode(STGroupModel model) {
                super(model, model.getIcon());

                model.getTemplates().forEach(stTemplate -> {
                    add(new STTemplateTreeNode(stTemplate));
                });
            }

            @Override
            public String getLabel() {
                return getModel().getName();
            }

            class STTemplateTreeNode extends BaseTreeNode<STTemplate> {

                public STTemplateTreeNode(STTemplate model) {
                    super(model, "STTemplate");

                    db.findAllSTModelByStTemplate(model.uuid()).forEach(stModel -> {
                        add(new STModelTreeNode(stModel));
                    });

                    model.getChildren().forEach(stTemplate -> {
                        add(new STTemplateTreeNode(stTemplate));
                    });
                }

                @Override
                public String getLabel() {
                    return getModel().getName();
                }

                class STModelTreeNode extends BaseTreeNode<STModel> {

                    private String label;

                    public STModelTreeNode(STModel model) {
                        super(model, "STGDirectory");

                        tooltip = stRenderer.render(model);
                        label = cut(tooltip);
                    }

                    @Override
                    public String getLabel() {
                        return label;
                    }

                    @Override
                    protected List<Action> getActions() {
                        final List<Action> actions = new ArrayList<>();
                        actions.add(openModelAction());
                        return actions;
                    }

                    private Action openModelAction() {
                        return newAction("Open", actionEvent -> {
                            getParentNode(STTemplateTreeNode.class)
                                    .ifPresent(stTemplateTreeNode -> findCanvas(tabbedPane)
                                            .ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> db.doInTransaction(transaction -> {
                                                final STModelNode node = new STModelNode(stCanvas, stTemplateTreeNode.getModel(), getModel(), stRenderer);
                                                stCanvas.addNode(node);

                                                tabbedPane.setSelectedComponent(stCanvas);
                                                stCanvas.requestFocusInWindow();
                                                stCanvas.centerNode(node);
                                            }))));
                        });
                    }
                }
            }
        }
    }

    private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {
        return new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionEventConsumer.accept(e);
            }
        };
    }

    private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();

    private ImageIcon loadIcon(String iconName) {

        if (cache.containsKey(iconName)) return cache.get(iconName);

        URL resource = getClass().getClassLoader().getResource("icons/" + iconName + "16x16.png");
        if (resource == null) resource = getClass().getClassLoader().getResource("icons/STGroup16x16.png");

        cache.put(iconName, new ImageIcon(Objects.requireNonNull(resource)));
        return cache.get(iconName);
    }

    private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
        final List<Action> actions = lastPathComponent.getActions();
        if (actions.isEmpty()) return;

        final JPopupMenu pop = new JPopupMenu();
        pop.add("With " + lastPathComponent.getLabel() + " :");
        for (Action action : actions)
            pop.add(action);

        SwingUtilities.invokeLater(() -> pop.show(tree, x, y));
    }

    public static String cut(String text) {
        return text.substring(0, Math.min(text.length(), 20));
    }

    public Optional<STCanvas> findCanvas(JTabbedPane tabbedPane) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            final Component tabComponentAt = tabbedPane.getComponentAt(i);
            if (tabComponentAt instanceof STCanvas)
                return Optional.of((STCanvas) tabComponentAt);
        }
        return Optional.empty();
    }
}