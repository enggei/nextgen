package nextgen.st;

import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STJsonFactory;
import nextgen.st.domain.STTemplate;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Optional;

import static com.nextgen.core.GeneratedFile.packageToPath;

public class STNavigator extends JPanel {

    private final JTree tree = new JTree();

    private final JTabbedPane tabbedPane;
    private final DefaultTreeModel treeModel;

    public STNavigator(STGDirectory stgDirectory, JTabbedPane contentPanel) {
        super(new BorderLayout());

        tabbedPane = contentPanel;

        treeModel = new DefaultTreeModel(new STGDirectoryTreeNode(stgDirectory));
        tree.setModel(treeModel);
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                return super.getTreeCellRendererComponent(tree, (value instanceof BaseTreeNode ? ((BaseTreeNode<?>) value).getLabel() : value), sel, expanded, leaf, row, hasFocus);
            }
        });

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {

                    final TreePath selectionPath = tree.getSelectionPath();
                    if (selectionPath == null) return;
                    final Object lastPathComponent = selectionPath.getLastPathComponent();
                    if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

                    final Action[] actions = ((BaseTreeNode<?>) lastPathComponent).getActions();
                    if (actions.length == 0) return;

                    final JPopupMenu pop = new JPopupMenu();
                    for (Action action : actions)
                        pop.add(action);

                    SwingUtilities.invokeLater(() -> pop.show(tree, e.getX(), e.getY()));
                }
            }
        });

        tree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:

                        final TreePath selectionPath = tree.getSelectionPath();
                        if (selectionPath == null) return;
                        final Object lastPathComponent = selectionPath.getLastPathComponent();
                        if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

                        final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) lastPathComponent;

                        final Action[] actions = baseTreeNode.getActions();
                        if (actions.length == 0) return;

                        final JPopupMenu pop = new JPopupMenu();
                        for (Action action : actions)
                            pop.add(action);

                        final Rectangle bounds = tree.getPathBounds(selectionPath);
                        if (bounds == null) return;

                        SwingUtilities.invokeLater(() -> pop.show(tree, (int) bounds.getCenterX(), (int) bounds.getCenterY()));
                        break;
                }
            }
        });

        tree.addTreeSelectionListener(e -> {
            if (e.getNewLeadSelectionPath() == null) return;

            final TreePath path = e.getPath();
            final Object lastPathComponent = path.getLastPathComponent();

            if (lastPathComponent instanceof STGDirectoryTreeNode.STGroupTreeNode) {
                show((STGDirectoryTreeNode.STGroupTreeNode) lastPathComponent);

            } else if (lastPathComponent instanceof STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) {
                show((STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) lastPathComponent);
            }
        });

        setPreferredSize(new Dimension(300, 600));
        add(new JScrollPane(tree), BorderLayout.CENTER);
    }

    public void show(STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode) {

        final STEditor stEditor = findSTTemplateEditor(tabbedPane, stGroupTreeNode)
                .orElseGet(() -> {
                    final STEditor stEditor1 = new STEditor(stGroupTreeNode);
                    tabbedPane.addTab(stGroupTreeNode.getLabel(), stEditor1);
                    return stEditor1;
                });

        SwingUtilities.invokeLater(() -> {
            stEditor.setSTTemplate(null);
            tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor), stGroupTreeNode.getModel().getName());
            tabbedPane.setSelectedComponent(stEditor);
        });
    }

    public void show(STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode stTemplateTreeNode) {

        stTemplateTreeNode
                .getParentNode(STGDirectoryTreeNode.STGroupTreeNode.class)
                .ifPresent(parent -> {

                    final STEditor stEditor = findSTTemplateEditor(tabbedPane, parent)
                            .orElseGet(() -> {
                                final STEditor stEditor1 = new STEditor(parent);
                                tabbedPane.addTab(parent.getLabel(), stEditor1);
                                return stEditor1;
                            });

                    SwingUtilities.invokeLater(() -> {
                        stEditor.setSTTemplate(stTemplateTreeNode);
                        tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor), parent.getModel().getName() + " - " + stTemplateTreeNode.getModel().getName());
                        tabbedPane.setSelectedComponent(stEditor);
                    });
                });
    }

    public Optional<STEditor> findSTTemplateEditor(JTabbedPane tabbedPane, STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            final Component tabComponentAt = tabbedPane.getComponentAt(i);
            if (tabComponentAt instanceof STEditor) {
                final STEditor stEditor = (STEditor) tabComponentAt;
                if (stEditor.getStGroupTreeNode().equals(stGroupTreeNode))
                    return Optional.of(stEditor);
            }
        }
        return Optional.empty();
    }

    private class BaseTreeNode<T> extends DefaultMutableTreeNode {

        public BaseTreeNode(T model) {
            setUserObject(model);
        }

        @SuppressWarnings("unchecked")
        public T getModel() {
            return (T) getUserObject();
        }

        public String getLabel() {
            return getUserObject().toString();
        }

        protected Action[] getActions() {
            return new Action[0];
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
    }

    class STGDirectoryTreeNode extends BaseTreeNode<STGDirectory> {

        public STGDirectoryTreeNode(STGDirectory model) {
            super(model);

            model.getGroups().forEach(stGroupModel -> add(new STGroupTreeNode(stGroupModel)));
        }

        @Override
        public String getLabel() {
            return getModel().getPath();
        }

        @Override
        protected Action[] getActions() {
            return new Action[]{
                    new AbstractAction("New STGroup") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            final String name = SwingUtil.showInputDialog("Name", tree);
                            if (name == null) return;

                            final Optional<STGroupModel> existing = getModel().getGroups().filter(groupModel -> groupModel.getName().toLowerCase().equals(name)).findAny();
                            if (existing.isPresent()) {
                                SwingUtil.showMessage(name + " group already exists", tree);
                                return;
                            }

                            final STGroupModel stGroupModel = STJsonFactory.newSTGroupModel()
                                    .setName(name)
                                    .setDelimiter("~")
                                    .setStgFile(FileUtil.tryToCreateFileIfNotExists(new File(getModel().getPath(), name + ".stg")).getPath());

                            getModel().addGroups(stGroupModel);

                            SwingUtilities.invokeLater(() -> {
                                final STGroupTreeNode stGroupTreeNode = new STGroupTreeNode(stGroupModel);
                                stGroupTreeNode.save();

                                treeModel.insertNodeInto(stGroupTreeNode, STGDirectoryTreeNode.this, getChildCount());
                                show(stGroupTreeNode);
                            });
                        }
                    },
                    new AbstractAction("Generate All") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            SwingUtilities.invokeLater(() -> {

                                final Optional<STGroupModel> renderer = getModel().getGroups()
                                        .filter(stGroupModel1 -> stGroupModel1.getName().equals("StringTemplate"))
                                        .findFirst();

                                renderer.ifPresent(generator -> {

                                    final STGenerator stGenerator = new STGenerator(generator);

                                    getModel().getGroups()
                                            .forEach(stGroupModel -> {
                                                final String outputPackage = getModel().getOutputPackage("templates.st");
                                                final String outputPath = getModel().getOutputPath("src/test/java");
                                                stGenerator.generateSTGroup(stGroupModel, outputPackage, outputPath);
                                            });
                                });

                            });
                        }
                    }
            };
        }

        class STGroupTreeNode extends BaseTreeNode<STGroupModel> {

            public STGroupTreeNode(STGroupModel model) {
                super(model);

                model.getTemplates().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
            }

            public void save() {
                final STGroupModel model = getModel();
                final File dir = new File(model.getStgFile()).getParentFile();
                FileUtil.write(model.getJsonObject().encodePrettily(), FileUtil.tryToCreateFileIfNotExists(new File(dir, model.getName() + ".json")));
            }

            @Override
            public String getLabel() {
                return getModel().getName();
            }

            @Override
            protected Action[] getActions() {
                return new Action[]{
                        new AbstractAction("Generate") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                SwingUtilities.invokeLater(() -> {

                                    getParentNode(STGDirectoryTreeNode.class).ifPresent(parent -> {

                                        final Optional<STGroupModel> renderer = parent.getModel().getGroups()
                                                .filter(stGroupModel1 -> stGroupModel1.getName().equals("StringTemplate"))
                                                .findFirst();

                                        renderer.ifPresent(generator -> {

                                            save();

                                            final String outputPackage = parent.getModel().getOutputPackage("templates.st");
                                            final String outputPath = parent.getModel().getOutputPath("src/test/java");

                                            new STGenerator(generator).generateSTGroup(getModel(), outputPackage, outputPath);
                                        });

                                    });
                                });
                            }
                        },
                        new AbstractAction("New template") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                final String name = SwingUtil.showInputDialog("Name", tree);
                                if (name == null) return;

                                final Optional<STTemplate> existing = getModel().getTemplates().filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name)).findAny();
                                if (existing.isPresent()) {
                                    SwingUtil.showMessage(name + " already in use in this group", tree);
                                    return;
                                }

                                if (name.equals("eom") || name.equals("gt")) {
                                    SwingUtil.showMessage(name + " is a reserved name", tree);
                                    return;
                                }

                                final STTemplate stTemplate = STJsonFactory.newSTTemplate()
                                        .setName(name)
                                        .setText("");

                                getModel().addTemplates(stTemplate);
                                save();

                                SwingUtilities.invokeLater(() -> {
                                    final STTemplateTreeNode stTemplateTreeNode = new STTemplateTreeNode(stTemplate);
                                    treeModel.insertNodeInto(stTemplateTreeNode, STGroupTreeNode.this, getChildCount());
                                    show(stTemplateTreeNode);
                                });
                            }
                        },
                        new AbstractAction("Rename") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                final String name = SwingUtil.showInputDialog("Name", tree, getModel().getName());
                                if (name == null) return;

                                getParentNode(STGDirectoryTreeNode.class)
                                        .ifPresent(parent -> {

                                            final Optional<STGroupModel> existing = parent.getModel()
                                                    .getGroups()
                                                    .filter(groupModel -> !groupModel.equals(getModel()))
                                                    .filter(groupModel -> groupModel.getName().toLowerCase().equals(name))
                                                    .findAny();

                                            if (existing.isPresent()) {
                                                SwingUtil.showMessage(name + " group already exists", tree);
                                                return;
                                            }

                                            getModel().setName(name);
                                            save();

                                            SwingUtilities.invokeLater(() -> {
                                                treeModel.nodeChanged(STGroupTreeNode.this);
                                                findSTTemplateEditor(tabbedPane, STGroupTreeNode.this)
                                                        .ifPresent(stEditor1 -> tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor1), getModel().getName()));
                                            });
                                        });

                            }
                        },
                        new AbstractAction("Delete") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!SwingUtil.showConfirmDialog(tree, "Delete " + getModel().getName())) return;

                                getParentNode(STGDirectoryTreeNode.class)
                                        .ifPresent(parent -> {

                                            parent.getModel().removeGroups(getModel());
                                            save();

                                            SwingUtilities.invokeLater(() -> {
                                                treeModel.removeNodeFromParent(STGroupTreeNode.this);
                                                findSTTemplateEditor(tabbedPane, STGroupTreeNode.this).ifPresent(tabbedPane::remove);
                                                final File stgFile = new File(parent.getModel().getPath(), getModel().getName() + ".stg");
                                                if (stgFile.exists()) {
                                                    stgFile.renameTo(new File(parent.getModel().getPath(), getModel().getName() + ".stg.deleted"));
                                                }
                                            });
                                        });

                            }
                        }
                };
            }

            class STTemplateTreeNode extends BaseTreeNode<STTemplate> {

                public STTemplateTreeNode(STTemplate model) {
                    super(model);

                    model.getChildren().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
                }

                @Override
                public String getLabel() {
                    return getModel().getName();
                }

                @Override
                protected Action[] getActions() {
                    return new Action[]{
                            new AbstractAction("New Child-template") {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    final String name = SwingUtil.showInputDialog("Name", tree);
                                    if (name == null) return;

                                    getParentNode(STGroupTreeNode.class)
                                            .ifPresent(parent -> {
                                                final Optional<STTemplate> existing = parent.getModel().getTemplates().filter(stTemplate -> !stTemplate.equals(getModel())).filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name)).findAny();
                                                if (existing.isPresent()) {
                                                    SwingUtil.showMessage(name + " already in use in this group", tree);
                                                    return;
                                                }

                                                if (name.equals("eom") || name.equals("gt")) {
                                                    SwingUtil.showMessage(name + " is a reserved name", tree);
                                                    return;
                                                }

                                                final STTemplate stTemplate = STJsonFactory.newSTTemplate()
                                                        .setName(name)
                                                        .setText("");

                                                getModel().addChildren(stTemplate);
                                                save();

                                                SwingUtilities.invokeLater(() -> {
                                                    final STTemplateTreeNode stTemplateTreeNode = new STTemplateTreeNode(stTemplate);
                                                    treeModel.insertNodeInto(stTemplateTreeNode, STTemplateTreeNode.this, getChildCount());
                                                    show(stTemplateTreeNode);
                                                });
                                            });


                                }
                            },
                            new AbstractAction("Rename") {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    final String name = SwingUtil.showInputDialog("Name", tree, getModel().getName());
                                    if (name == null) return;

                                    getParentNode(STGroupTreeNode.class)
                                            .ifPresent(parent -> {
                                                final Optional<STTemplate> existing = parent.getModel().getTemplates().filter(stTemplate -> !stTemplate.equals(getModel())).filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name)).findAny();
                                                if (existing.isPresent()) {
                                                    SwingUtil.showMessage(name + " already in use in this group", tree);
                                                    return;
                                                }

                                                if (name.equals("eom") || name.equals("gt")) {
                                                    SwingUtil.showMessage(name + " is a reserved name", tree);
                                                    return;
                                                }

                                                getModel().setName(name);
                                                save();

                                                SwingUtilities.invokeLater(() -> {
                                                    treeModel.nodeChanged(STTemplateTreeNode.this);
                                                    findSTTemplateEditor(tabbedPane, parent)
                                                            .ifPresent(stEditor1 -> tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor1), getModel().getName()));
                                                });
                                            });
                                }
                            },
                            new AbstractAction("Remove") {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (!SwingUtil.showConfirmDialog(tree, "Delete " + getModel().getName())) return;

                                    final TreeNode check = getParent();

                                    if (check instanceof STGroupTreeNode) {
                                        final STGroupTreeNode parent = (STGroupTreeNode) check;

                                        parent.getModel().removeTemplates(getModel());
                                        save();

                                        SwingUtilities.invokeLater(() -> {
                                            treeModel.removeNodeFromParent(STTemplateTreeNode.this);
                                            findSTTemplateEditor(tabbedPane, parent).ifPresent(tabbedPane::remove);
                                        });

                                    } else if (check instanceof STTemplateTreeNode) {
                                        final STTemplateTreeNode parent = (STTemplateTreeNode) check;

                                        parent.getModel().removeChildren(getModel());
                                        save();

                                        SwingUtilities.invokeLater(() -> {
                                            treeModel.removeNodeFromParent(STTemplateTreeNode.this);
                                            getParentNode(STGroupTreeNode.class)
                                                    .flatMap(stGroupTreeNode -> findSTTemplateEditor(tabbedPane, stGroupTreeNode))
                                                    .ifPresent(tabbedPane::remove);
                                        });
                                    }
                                }
                            }
                    };
                }
            }
        }
    }
}