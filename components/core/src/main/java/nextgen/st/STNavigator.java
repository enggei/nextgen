package nextgen.st;

import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import nextgen.st.domain.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static nextgen.st.STGenerator.toSTGroup;

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

                if (lastPathComponent instanceof STGDirectoryTreeNode.STGroupTreeNode) {
                    show((STGDirectoryTreeNode.STGroupTreeNode) lastPathComponent);

                } else if (lastPathComponent instanceof STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) {
                    show((STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) lastPathComponent);
                }

            }
        });

        setPreferredSize(new Dimension(300, 600));
        add(new JScrollPane(tree), BorderLayout.CENTER);
    }

    public void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
        final Action[] actions = lastPathComponent.getActions();
        if (actions.length == 0) return;

        final JPopupMenu pop = new JPopupMenu();
        pop.add("With " + lastPathComponent.getLabel() + " :");
        for (Action action : actions)
            pop.add(action);

        SwingUtilities.invokeLater(() -> pop.show(tree, x, y));
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
                        stEditor.requestFocusInWindow();
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

            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                    iterator,
                    Spliterator.ORDERED), false)
                    .filter(baseTreeNode -> baseTreeNode.getClass().equals(type))
                    .map(baseTreeNode -> (T) baseTreeNode);
        }

        protected Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {
            return new AbstractAction(name) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionEventConsumer.accept(e);
                }
            };
        }

        protected Optional<String> getStringFromUser(String description) {
            final String s = SwingUtil.showInputDialog(description, tree);
            return Optional.ofNullable(s == null || s.trim().length() == 0 ? null : s);
        }

        protected Optional<Boolean> confirm(String description) {
            final boolean b = SwingUtil.showConfirmDialog(tree, description);
            return Optional.ofNullable(b ? Boolean.TRUE : null);
        }
    }

    class STGDirectoryTreeNode extends BaseTreeNode<STGDirectory> {

        public STGDirectoryTreeNode(STGDirectory model) {
            super(model);

            model.getGroups().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stGroupModel -> add(new STGroupTreeNode(stGroupModel)));
        }

        @Override
        public String getLabel() {
            return getModel().getPath();
        }

        @Override
        protected Action[] getActions() {
            return new Action[]{
                    newAction("New STGroup", actionEvent -> {

                        getStringFromUser("Name").ifPresent(name -> {

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
                        });
                    }),
                    newAction("Generate", actionEvent ->
                            SwingUtilities.invokeLater(() -> {
                                getModel().getGroups()
                                        .filter(stGroupModel1 -> stGroupModel1.getName().equals("StringTemplate"))
                                        .findFirst()
                                        .ifPresent(generator ->
                                                getModel().getGroups()
                                                        .forEach(stGroupModel -> {
                                                            final String outputPackage = getModel().getOutputPackage("templates.st");
                                                            final String outputPath = getModel().getOutputPath("src/test/java");
                                                            new STGenerator(generator).generateSTGroup(stGroupModel, outputPackage, outputPath);
                                                        }));

                            })
                    ),
                    newAction("Verify and Save all groups", actionEvent ->
                            SwingUtilities.invokeLater(() -> {
                                getChildren(STGroupTreeNode.class).forEach(stGroupTreeNode -> {
                                    final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupTreeNode.getModel()));
                                    if (parseResult.getErrors().count() == 0) {
                                        stGroupTreeNode.save();
                                    } else {
                                        System.out.println(stGroupTreeNode.getModel().getName() + " has errors: ");
                                        parseResult.getErrors().forEach(stgError -> {
                                            System.out.println("\t" + stgError.getType() + " " + stgError.getMessage());
                                        });
                                    }
                                });
                            }))
            };
        }

        class STGroupTreeNode extends BaseTreeNode<STGroupModel> {

            public STGroupTreeNode(STGroupModel model) {
                super(model);

                model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
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
                        newAction("Generate", actionEvent -> {
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
                        }),
                        newAction("New template", actionEvent -> {

                            getStringFromUser("Name").ifPresent(name -> {
                                final Optional<STTemplate> existing = getModel().getTemplates().filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name.toLowerCase())).findAny();

                                if (existing.isPresent()) {
                                    SwingUtil.showMessage(name + " already in use in this group", tree);
                                    return;
                                }

                                if (name.toLowerCase().equals("eom") || name.toLowerCase().equals("gt")) {
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
                            });
                        }),
                        newAction("Rename", actionEvent -> {
                            getStringFromUser("Name").ifPresent(name -> {
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
                            });
                        }),
                        newAction("Delete", actionEvent -> {

                            confirm("Delete " + getModel().getName())
                                    .flatMap(aBoolean -> getParentNode(STGDirectoryTreeNode.class))
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
                        })
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

                    final Set<STTemplateTreeNode> candidateChildren = new LinkedHashSet<>();
                    final TreePath[] selectionPaths = tree.getSelectionPaths();
                    if (selectionPaths != null)
                        for (TreePath selectionPath : selectionPaths)
                            if (selectionPath.getLastPathComponent() != null && (selectionPath.getLastPathComponent() instanceof STTemplateTreeNode) && !(STTemplateTreeNode.this.equals(selectionPath.getLastPathComponent())))
                                candidateChildren.add((STTemplateTreeNode) selectionPath.getLastPathComponent());

                    if (!candidateChildren.isEmpty()) {
                        final Action setAsChildrenAction = newAction("Add " + candidateChildren.size() + " nodes as children", actionEvent -> {
                            SwingUtilities.invokeLater(() -> {
                                for (STTemplateTreeNode stTemplateTreeNode : candidateChildren) {

                                    final TreeNode check = stTemplateTreeNode.getParent();
                                    if (check instanceof STGroupTreeNode) {
                                        ((STGroupTreeNode) check).getModel().removeTemplates(stTemplateTreeNode.getModel());
                                    } else if (check instanceof STTemplateTreeNode) {
                                        ((STTemplateTreeNode) check).getModel().removeChildren(stTemplateTreeNode.getModel());
                                    }
                                    treeModel.removeNodeFromParent(stTemplateTreeNode);

                                    getModel().addChildren(stTemplateTreeNode.getModel());
                                    treeModel.insertNodeInto(stTemplateTreeNode, STTemplateTreeNode.this, getChildCount());
                                }

                                save();
                                treeModel.nodeStructureChanged(getParent());
                            });
                        });
                        return new Action[]{
                                setAsChildrenAction,
                                newChildTemplateAction(),
                                renameSTTemplateAction(),
                                removeSTTemplateAction()
                        };
                    }

                    return new Action[]{
                            newChildTemplateAction(),
                            renameSTTemplateAction(),
                            removeSTTemplateAction()
                    };
                }

                private Action newChildTemplateAction() {
                    return newAction("New Child-template", actionEvent -> getStringFromUser("Name")
                            .ifPresent(name -> getParentNode(STGroupTreeNode.class)
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
                                    })));
                }

                private Action renameSTTemplateAction() {
                    return newAction("Rename", actionEvent -> {
                        getStringFromUser("Name").ifPresent(name -> {
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
                        });
                    });
                }

                private Action removeSTTemplateAction() {
                    return newAction("Remove", actionEvent -> {

                        confirm("Delete " + getModel().getName()).ifPresent(aBoolean -> {

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
                        });
                    });
                }
            }
        }
    }
}