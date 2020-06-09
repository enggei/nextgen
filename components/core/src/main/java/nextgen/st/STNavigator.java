package nextgen.st;

import com.generator.util.SwingUtil;
import io.vertx.core.json.JsonObject;
import nextgen.st.domain.*;

import javax.lang.model.SourceVersion;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static nextgen.st.STGenerator.toSTGroup;

public class STNavigator extends JPanel {

    private final JTree tree = new JTree();

    private final JTabbedPane tabbedPane;
    private final DefaultTreeModel treeModel;

    public STNavigator(STAppModel appModel, JTabbedPane contentPanel) {
        super(new BorderLayout());

        tabbedPane = contentPanel;

        treeModel = new DefaultTreeModel(new RootNode(appModel));
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

                if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode) {
                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode) lastPathComponent);

                } else if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) {
                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) lastPathComponent);
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

    public void show(RootNode.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode) {

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

    public void show(RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode stTemplateTreeNode) {
        stTemplateTreeNode
                .getParentNode(RootNode.STGDirectoryTreeNode.STGroupTreeNode.class)
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

    public Optional<STEditor> findSTTemplateEditor(JTabbedPane tabbedPane, RootNode.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode) {
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

            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
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

        protected Optional<String> getStringFromUser(String description, String initialValue) {
            final String s = SwingUtil.showInputDialog(description, tree, initialValue);
            return Optional.ofNullable(s == null || s.trim().length() == 0 || s.equals(initialValue) ? null : s);
        }

        protected Optional<Boolean> confirm(String description) {
            final boolean b = SwingUtil.showConfirmDialog(tree, description + "?");
            return Optional.ofNullable(b ? Boolean.TRUE : null);
        }
    }

    class RootNode extends BaseTreeNode<String> {

        private final STGDirectoryTreeNode generatorTreeNode;

        public RootNode(STAppModel appModel) {
            super("App");

            final File jsonFileDir = new File(appModel.getGeneratorRoot(), STGenerator.packageToPath(appModel.getGeneratorPackage()));
            add(generatorTreeNode = new STGDirectoryTreeNode(STJsonFactory.newSTGDirectory()
                    .setOutputPath(appModel.getGeneratorRoot())
                    .setOutputPackage(appModel.getGeneratorPackage())
                    .setPath(jsonFileDir.getAbsolutePath())
                    .addGroups(new STGroupModel(new JsonObject(STParser.read(new File(jsonFileDir, appModel.getGeneratorName() + ".json")))))
            ));

            appModel.getDirectories().forEach(stgDirectory -> {
                add(new STGDirectoryTreeNode(stgDirectory));
            });
        }

        public STGroupModel getGenerator() {
            return generatorTreeNode.getModel().getGroups().iterator().next();
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
                        newSTGroupAction(),
                        generateGroupAction(),
                        verifyAndSaveGroupAction()
                };
            }

            private Action newSTGroupAction() {
                return newAction("New STGroup", actionEvent -> {

                    getStringFromUser("Name").ifPresent(name -> {

                        final Optional<STGroupModel> existing = getModel().getGroups().filter(groupModel -> groupModel.getName().toLowerCase().equals(name)).findAny();
                        if (existing.isPresent()) {
                            SwingUtil.showMessage(name + " group already exists in this directory", tree);
                            return;
                        }

                        if (!SourceVersion.isIdentifier(name)) {
                            SwingUtil.showMessage(name + " is a reserved java keyword", tree);
                            return;
                        }

                        final STGroupModel stGroupModel = STJsonFactory.newSTGroupModel()
                                .setName(name)
                                .setDelimiter(STGenerator.DELIMITER);

                        getModel().addGroups(stGroupModel);

                        SwingUtilities.invokeLater(() -> {
                            final STGroupTreeNode stGroupTreeNode = new STGroupTreeNode(stGroupModel);
                            stGroupTreeNode.save();

                            treeModel.insertNodeInto(stGroupTreeNode, STGDirectoryTreeNode.this, getChildCount());
                            show(stGroupTreeNode);
                        });
                    });
                });
            }

            private Action generateGroupAction() {
                return newAction("Generate", actionEvent ->
                        SwingUtilities.invokeLater(() -> getModel().getGroups().forEach(this::generate))
                );
            }

            private void generate(STGroupModel stGroupModel) {
                final String outputPackage = getModel().getOutputPackage();
                final String outputPath = getModel().getOutputPath();
                new STGenerator(getGenerator()).generateSTGroup(stGroupModel, outputPackage, outputPath);
            }

            private Action verifyAndSaveGroupAction() {
                return newAction("Verify and Save all groups", actionEvent ->
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
                        }));
            }

            class STGroupTreeNode extends BaseTreeNode<STGroupModel> {

                public STGroupTreeNode(STGroupModel model) {
                    super(model);

                    model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));
                    model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
                }

                public void save() {
                    getParentNode(STGDirectoryTreeNode.class)
                            .ifPresent(stgDirectoryTreeNode -> {
                                final File dir = new File(stgDirectoryTreeNode.getModel().getPath());
                                final STGroupModel model = getModel();
                                STGenerator.write(new File(dir, model.getName() + ".json"), model.getJsonObject().encodePrettily());
                            });
                }

                @Override
                public String getLabel() {
                    return getModel().getName();
                }

                @Override
                protected Action[] getActions() {
                    return new Action[]{
                            generateAction(),
                            newEnumAction(),
                            newTemplateAction(),
                            renameSTGroupAction(),
                            deleteGroupAction()
                    };
                }

                private Action generateAction() {
                    return newAction("Generate", actionEvent -> generate());
                }

                private Action newEnumAction() {
                    return newAction("New enum", actionEvent ->
                            getStringFromUser("Name").ifPresent(name ->
                                    isValidTemplateName(name).ifPresent(s -> {

                                        final STEnum stEnum = STJsonFactory.newSTEnum()
                                                .setName(name);

                                        getModel().addEnums(stEnum);
                                        save();

                                        SwingUtilities.invokeLater(() -> {
                                            final STEnumTreeNode stTemplateTreeNode = new STEnumTreeNode(stEnum);
                                            treeModel.insertNodeInto(stTemplateTreeNode, STGroupTreeNode.this, getChildCount());
                                        });
                                    })));
                }

                private Action newTemplateAction() {
                    return newAction("New template", actionEvent ->
                            getStringFromUser("Name").ifPresent(name ->
                                    isValidTemplateName(name).ifPresent(s -> {

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
                                    })));
                }

                private Action renameSTGroupAction() {
                    return newAction("Rename", actionEvent ->
                            getStringFromUser("Name").ifPresent(name ->
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
                                            })));
                }

                private Action deleteGroupAction() {
                    return newAction("Delete", actionEvent ->
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
                                    }));
                }

                private Optional<String> isValidTemplateName(String name) {

                    final Optional<STTemplate> existing = getModel().getTemplates().filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name.toLowerCase())).findAny();

                    if (existing.isPresent()) {
                        SwingUtil.showMessage(name + " already in use in this group", tree);
                        return Optional.empty();
                    }

                    if (name.toLowerCase().equals("eom") || name.toLowerCase().equals("gt")) {
                        SwingUtil.showMessage(name + " is a reserved name", tree);
                        return Optional.empty();
                    }

                    if (!SourceVersion.isIdentifier(name)) {
                        SwingUtil.showMessage(name + " is a reserved java keyword", tree);
                        return Optional.empty();
                    }

                    return Optional.of(name);
                }

                public void generate() {
                    SwingUtilities.invokeLater(() ->
                            getParentNode(STGDirectoryTreeNode.class).ifPresent(parent -> {
                                save();
                                parent.generate(getModel());
                            }));
                }

                class STEnumTreeNode extends BaseTreeNode<STEnum> {

                    public STEnumTreeNode(STEnum model) {
                        super(model);
                    }

                    @Override
                    public String getLabel() {
                        return getModel().getName();
                    }

                    @Override
                    protected Action[] getActions() {

                        final Action[] actions = new Action[(int) getModel().getValues().count() + 3];

                        final AtomicInteger index = new AtomicInteger(-1);
                        getModel().getValues().forEach(stEnumValue -> actions[index.incrementAndGet()] = newEditSTEnumValueAction(stEnumValue));
                        actions[index.incrementAndGet()] = addSTEnumValueAction();
                        actions[index.incrementAndGet()] = renameSTEnumAction();
                        actions[index.incrementAndGet()] = removeSTEnumAction();

                        return actions;
                    }

                    private Action newEditSTEnumValueAction(STEnumValue stEnumValue) {
                        return newAction("Edit " + stEnumValue.getName(), actionEvent ->
                                getStringFromUser("Name [lexical]").ifPresent(s -> {

                                    final String[] kv = s.split("[ ]");

                                    stEnumValue.setName(kv[0].trim());
                                    if (kv.length != 1) stEnumValue.setLexical(kv[1].trim());
                                    save();
                                }));
                    }

                    private Action addSTEnumValueAction() {
                        return newAction("New STEnum value", actionEvent ->
                                getStringFromUser("Name [lexical]").ifPresent(s -> {

                                    final String[] kv = s.split("[ ]");

                                    final STEnumValue stEnumValue = STJsonFactory.newSTEnumValue()
                                            .setName(kv[0].trim());

                                    if (kv.length != 1) stEnumValue.setLexical(kv[1].trim());

                                    getModel().addValues(stEnumValue);
                                    save();
                                }));
                    }

                    private Action renameSTEnumAction() {
                        return newAction("Rename", actionEvent ->
                                getStringFromUser("Name").ifPresent(name ->
                                        getParentNode(STGroupTreeNode.class)
                                                .ifPresent(parent -> parent.isValidTemplateName(name)
                                                        .ifPresent(s -> {

                                                            getModel().setName(name);
                                                            save();

                                                            SwingUtilities.invokeLater(() -> {
                                                                treeModel.nodeChanged(STEnumTreeNode.this);
                                                            });
                                                        }))));
                    }

                    private Action removeSTEnumAction() {
                        return newAction("Remove", actionEvent ->
                                confirm("Delete " + getModel().getName()).ifPresent(aBoolean -> {

                                    final STGroupTreeNode parent = (STGroupTreeNode) getParent();

                                    parent.getModel().removeEnums(getModel());
                                    save();

                                    SwingUtilities.invokeLater(() -> {
                                        treeModel.removeNodeFromParent(STEnumTreeNode.this);
                                    });
                                }));
                    }
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
                            return new Action[]{
                                    reparentAction(candidateChildren),
                                    newChildTemplateAction(),
                                    newSetParameterTypesAction(),
                                    renameSTTemplateAction(),
                                    removeSTTemplateAction()
                            };
                        }

                        return new Action[]{
                                newChildTemplateAction(),
                                newSetParameterTypesAction(),
                                renameSTTemplateAction(),
                                removeSTTemplateAction()
                        };
                    }

                    private Action reparentAction(Set<STTemplateTreeNode> candidateChildren) {
                        return newAction("Add " + candidateChildren.size() + " nodes as children", actionEvent ->
                                SwingUtilities.invokeLater(() -> {
                                    for (STTemplateTreeNode stTemplateTreeNode : candidateChildren) {

                                        final TreeNode parent = stTemplateTreeNode.getParent();
                                        if (parent instanceof STGroupTreeNode)
                                            ((STGroupTreeNode) parent).getModel().removeTemplates(stTemplateTreeNode.getModel());
                                        else if (parent instanceof STTemplateTreeNode)
                                            ((STTemplateTreeNode) parent).getModel().removeChildren(stTemplateTreeNode.getModel());
                                        getModel().addChildren(stTemplateTreeNode.getModel());

                                        treeModel.removeNodeFromParent(stTemplateTreeNode);
                                        treeModel.insertNodeInto(stTemplateTreeNode, STTemplateTreeNode.this, getChildCount());
                                    }

                                    save();
                                    treeModel.nodeStructureChanged(getParent());
                                }));
                    }

                    private Action newSetParameterTypesAction() {
                        return newAction("Set parameter types", actionEvent -> {

                            final Map<String, JTextField> txtParameterMap = new TreeMap<>();
                            getModel().getParameters().forEach(stParameter -> {

                                switch (stParameter.getType()) {

                                    case SINGLE:
                                    case LIST:
                                        txtParameterMap.put(stParameter.getName(), new JTextField(stParameter.getArgumentType("Object"), 15));
                                        break;
                                    case KVLIST:
                                        stParameter.getKeys().forEach(stParameterKey -> {
                                            txtParameterMap.put(stParameter.getName() + "." + stParameterKey.getName(), new JTextField(stParameterKey.getArgumentType("Object"), 15));
                                        });
                                        break;
                                }
                            });

                            final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Set Parameter types", true);
                            final JPanel contentPanel = new JPanel(new GridLayout(txtParameterMap.size(), 2));
                            contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
                            txtParameterMap.forEach((key, value) -> {
                                contentPanel.add(new JLabel(key));
                                contentPanel.add(value);
                            });
                            dialog.add(contentPanel, BorderLayout.CENTER);

                            final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {
                                getModel().getParameters().forEach(stParameter -> {

                                    switch (stParameter.getType()) {

                                        case SINGLE:
                                        case LIST:
                                            final JTextField txtTypes = txtParameterMap.get(stParameter.getName());
                                            final String types = txtTypes.getText().trim();
                                            stParameter.setArgumentType(types.length() == 0 ? "Object" : types);
                                            break;

                                        case KVLIST:
                                            stParameter.getKeys().forEach(stParameterKey -> {
                                                final JTextField txtKVTypes = txtParameterMap.get(stParameter.getName() + "." + stParameterKey.getName());
                                                final String kvTypes = txtKVTypes.getText().trim();
                                                stParameterKey.setArgumentType(kvTypes.length() == 0 ? "Object" : kvTypes);
                                            });
                                            break;
                                    }
                                });

                                save();

                                SwingUtilities.invokeLater(dialog::dispose);
                            }));
                            dialog.getRootPane().setDefaultButton(btnSave);

                            final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                            commandPanel.add(btnSave);
                            commandPanel.add(new JButton(newAction("Cancel", actionEvent1 -> SwingUtilities.invokeLater(dialog::dispose))));
                            dialog.add(commandPanel, BorderLayout.SOUTH);

                            SwingUtilities.invokeLater(() -> {
                                dialog.pack();
                                dialog.setLocationRelativeTo(tree);
                                dialog.setVisible(true);
                            });
                        });
                    }

                    private Action newChildTemplateAction() {
                        return newAction("New Child-template", actionEvent -> getStringFromUser("Name")
                                .ifPresent(name -> getParentNode(STGroupTreeNode.class)
                                        .flatMap(parent -> parent.isValidTemplateName(name))
                                        .ifPresent(s -> {
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
                        return newAction("Rename", actionEvent ->
                                getStringFromUser("Name").ifPresent(name ->
                                        getParentNode(STGroupTreeNode.class)
                                                .ifPresent(parent -> parent.isValidTemplateName(name)
                                                        .ifPresent(s -> {

                                                            getModel().setName(name);
                                                            save();

                                                            SwingUtilities.invokeLater(() -> {
                                                                treeModel.nodeChanged(STTemplateTreeNode.this);
                                                                findSTTemplateEditor(tabbedPane, parent)
                                                                        .ifPresent(stEditor1 -> tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor1), getModel().getName()));
                                                            });
                                                        }))));
                    }

                    private Action removeSTTemplateAction() {
                        return newAction("Remove", actionEvent ->
                                confirm("Delete " + getModel().getName()).ifPresent(aBoolean -> {

                                    if (getParent() instanceof STGroupTreeNode) {
                                        final STGroupTreeNode parent = (STGroupTreeNode) getParent();

                                        parent.getModel().removeTemplates(getModel());
                                        save();

                                        SwingUtilities.invokeLater(() -> {
                                            treeModel.removeNodeFromParent(STTemplateTreeNode.this);
                                            findSTTemplateEditor(tabbedPane, parent).ifPresent(tabbedPane::remove);
                                        });

                                    } else if (getParent() instanceof STTemplateTreeNode) {
                                        final STTemplateTreeNode parent = (STTemplateTreeNode) getParent();

                                        parent.getModel().removeChildren(getModel());
                                        save();

                                        SwingUtilities.invokeLater(() -> {
                                            treeModel.removeNodeFromParent(STTemplateTreeNode.this);
                                            getParentNode(STGroupTreeNode.class)
                                                    .flatMap(stGroupTreeNode -> findSTTemplateEditor(tabbedPane, stGroupTreeNode))
                                                    .ifPresent(tabbedPane::remove);
                                        });
                                    }
                                }));
                    }
                }
            }
        }
    }


}