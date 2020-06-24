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
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
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
                final boolean isBaseTreeNode = value instanceof BaseTreeNode;
                if (isBaseTreeNode) {
                    final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;
                    setIcon(baseTreeNode.getIcon());
                    setOpenIcon(baseTreeNode.getIcon());
                    setClosedIcon(baseTreeNode.getIcon());
                    setLeafIcon(baseTreeNode.getIcon());
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

                if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode) {
                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode) lastPathComponent);
                } else if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) {
                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode) lastPathComponent);
                } else if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode.STEnumTreeNode) {
                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode.STEnumTreeNode) lastPathComponent);
                } else if (lastPathComponent instanceof RootNode.STGDirectoryTreeNode.STGroupTreeNode.STInterfaceTreeNode) {
                    show((RootNode.STGDirectoryTreeNode.STGroupTreeNode.STInterfaceTreeNode) lastPathComponent);
                }
            }
        });

        setPreferredSize(new Dimension(300, 600));
        add(new JScrollPane(tree), BorderLayout.CENTER);
    }

    private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();

    private ImageIcon loadIcon(String iconName) {

        if (cache.containsKey(iconName)) return cache.get(iconName);

        URL resource = getClass().getClassLoader().getResource("icons/" + iconName + "16x16.png");
        if (resource == null) resource = getClass().getClassLoader().getResource("icons/STGroup16x16.png");

        cache.put(iconName, new ImageIcon(Objects.requireNonNull(resource)));
        return cache.get(iconName);
    }

    public void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
        final List<Action> actions = lastPathComponent.getActions();
        if (actions.isEmpty()) return;

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

    public void show(RootNode.STGDirectoryTreeNode.STGroupTreeNode.STEnumTreeNode stEnumTreeNode) {

        stEnumTreeNode
                .getParentNode(RootNode.STGDirectoryTreeNode.STGroupTreeNode.class)
                .ifPresent(parent -> {

                    final STEditor stEditor = findSTTemplateEditor(tabbedPane, parent)
                            .orElseGet(() -> {
                                final STEditor stEditor1 = new STEditor(parent);
                                tabbedPane.addTab(parent.getLabel(), stEditor1);
                                return stEditor1;
                            });

                    SwingUtilities.invokeLater(() -> parent.getParentNode(RootNode.class).ifPresent(rootNode -> {
                        stEditor.setSTEnum(stEnumTreeNode);
                        tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor), parent.getModel().getName() + " - " + stEnumTreeNode.getModel().getName());
                        tabbedPane.setSelectedComponent(stEditor);
                    }));
                });
    }

    public void show(RootNode.STGDirectoryTreeNode.STGroupTreeNode.STInterfaceTreeNode stInterfaceTreeNode) {

        stInterfaceTreeNode
                .getParentNode(RootNode.STGDirectoryTreeNode.STGroupTreeNode.class)
                .ifPresent(parent -> {

                    final STEditor stEditor = findSTTemplateEditor(tabbedPane, parent)
                            .orElseGet(() -> {
                                final STEditor stEditor1 = new STEditor(parent);
                                tabbedPane.addTab(parent.getLabel(), stEditor1);
                                return stEditor1;
                            });

                    SwingUtilities.invokeLater(() -> parent.getParentNode(RootNode.class).ifPresent(rootNode -> {
                        stEditor.setSTInterface(stInterfaceTreeNode);
                        tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor), parent.getModel().getName() + " - " + stInterfaceTreeNode.getModel().getName());
                        tabbedPane.setSelectedComponent(stEditor);
                    }));
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

        protected ImageIcon icon;

        public BaseTreeNode(T model, String icon) {
            setUserObject(model);
            this.icon = loadIcon(icon);
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

        protected List<Action> getActions() {
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
    }

    class RootNode extends BaseTreeNode<String> {

        private final STGDirectoryTreeNode generatorTreeNode;

        public RootNode(STAppModel appModel) {
            super("App", "RootNode");

            final File jsonFileDir = new File(appModel.getGeneratorRoot(), STGenerator.packageToPath(appModel.getGeneratorPackage()));
            add(generatorTreeNode = new STGDirectoryTreeNode(STJsonFactory.newSTGDirectory()
                    .setOutputPath(appModel.getGeneratorRoot())
                    .setOutputPackage(appModel.getGeneratorPackage())
                    .setPath(jsonFileDir.getAbsolutePath())
                    .addGroups(new STGroupModel(new JsonObject(STParser.read(new File(jsonFileDir, appModel.getGeneratorName() + ".json")))))
            ));

            appModel.getDirectories().forEach(stgDirectory -> add(new STGDirectoryTreeNode(stgDirectory)));
        }

        public STGroupModel getGenerator() {
            return generatorTreeNode.getModel().getGroups().iterator().next();
        }

        class STGDirectoryTreeNode extends BaseTreeNode<STGDirectory> {

            public STGDirectoryTreeNode(STGDirectory model) {
                super(model, "STGDirectory");
                model.getGroups().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stGroupModel -> add(new STGroupTreeNode(stGroupModel)));
            }

            @Override
            public String getLabel() {
                return getModel().getPath();
            }

            @Override
            protected List<Action> getActions() {
                return Arrays.asList(newSTGroupAction(), generateAllGroupsAction());
            }

            private Action newSTGroupAction() {
                return newAction("New STGroup", actionEvent -> getNameFromUser().ifPresent(name -> {

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
                }));
            }

            private Action generateAllGroupsAction() {
                return newAction("Generate All groups", actionEvent ->
                        SwingUtilities.invokeLater(() -> getChildren(STGroupTreeNode.class).forEach(STGroupTreeNode::generate)));
            }

            private void generate(STGroupModel stGroupModel) {
                final String outputPackage = getModel().getOutputPackage();
                final String outputPath = getModel().getOutputPath();
                new STGenerator(getGenerator()).generateSTGroup(stGroupModel, outputPackage, outputPath);
            }

            class STGroupTreeNode extends BaseTreeNode<STGroupModel> {

                public STGroupTreeNode(STGroupModel model) {
                    super(model, model.getIcon());

                    model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));
                    model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
                    model.getInterfaces().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stInterface -> add(new STInterfaceTreeNode(stInterface)));
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
                protected List<Action> getActions() {
                    return Arrays.asList(
                            generateAction(),
                            newTemplateAction(),
                            newEnumAction(),
                            newInterfaceAction(),
                            newExpandAction(),
                            setIconNameAction(),
                            renameSTGroupAction(),
                            deleteGroupAction());
                }

                private Action generateAction() {
                    return newAction("Generate", actionEvent -> generate());
                }

                private Action newTemplateAction() {
                    return newAction("New template", actionEvent ->
                            getNameFromUser().ifPresent(name ->
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

                private Action newEnumAction() {
                    return newAction("New enum", actionEvent ->
                            getNameFromUser().ifPresent(name ->
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

                private Action newInterfaceAction() {
                    return newAction("New interface", actionEvent ->
                            getNameFromUser().ifPresent(name ->
                                    isValidTemplateName(name).ifPresent(s -> {

                                        final STInterface stInterface = STJsonFactory.newSTInterface()
                                                .setName(name);

                                        getModel().addInterfaces(stInterface);
                                        save();

                                        SwingUtilities.invokeLater(() -> {
                                            final STInterfaceTreeNode stTemplateTreeNode = new STInterfaceTreeNode(stInterface);
                                            treeModel.insertNodeInto(stTemplateTreeNode, STGroupTreeNode.this, getChildCount());
                                        });
                                    })));
                }

                private Action renameSTGroupAction() {
                    return newAction("Rename", actionEvent ->
                            getNameFromUser().ifPresent(name ->
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

                                                final String oldName = getModel().getName();
                                                getModel().setName(name);
                                                save();

                                                SwingUtilities.invokeLater(() -> {
                                                    treeModel.nodeChanged(STGroupTreeNode.this);
                                                    findSTTemplateEditor(tabbedPane, STGroupTreeNode.this)
                                                            .ifPresent(stEditor1 -> tabbedPane.setTitleAt(tabbedPane.indexOfComponent(stEditor1), getModel().getName()));
                                                    deleteSTGFile(parent, oldName);
                                                });
                                            })));
                }

                private Action setIconNameAction() {
                    return newAction("Set Icon name", actionEvent ->
                            getInputFromUser("Icon name").ifPresent(iconName ->
                                    getParentNode(STGDirectoryTreeNode.class)
                                            .ifPresent(parent -> {

                                                getModel().setIcon(iconName);
                                                save();

                                                SwingUtilities.invokeLater(() -> {
                                                    this.icon = loadIcon(iconName);
                                                    treeModel.nodeChanged(STGroupTreeNode.this);
                                                });
                                            })));
                }

                private Action deleteGroupAction() {
                    return newAction("Delete", actionEvent ->
                            confirm("Delete " + getModel().getName())
                                    .flatMap(aBoolean -> getParentNode(STGDirectoryTreeNode.class))
                                    .ifPresent(parent -> {

                                        parent.getModel().removeGroups(getModel());

                                        SwingUtilities.invokeLater(() -> {
                                            treeModel.removeNodeFromParent(STGroupTreeNode.this);
                                            findSTTemplateEditor(tabbedPane, STGroupTreeNode.this).ifPresent(tabbedPane::remove);
                                            deleteSTGFile(parent, getModel().getName());
                                        });
                                    }));
                }

                private void deleteSTGFile(STGDirectoryTreeNode parent, String name) {
                    final File stgFile = new File(parent.getModel().getPath(), name + ".json");
                    if (stgFile.exists())
                        stgFile.renameTo(new File(parent.getModel().getPath(), name + ".json.deleted"));
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
                                final STGParseResult parseResult = STParser.parse(toSTGroup(getModel()));
                                if (parseResult.getErrors().count() == 0) {
                                    save();
                                    parent.generate(getModel());
                                } else {
                                    System.out.println(getModel().getName() + " has errors: ");
                                    parseResult.getErrors().forEach(stgError -> System.out.println("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError.getLine()));
                                }
                            }));
                }

                class STInterfaceTreeNode extends BaseTreeNode<STInterface> {

                    public STInterfaceTreeNode(STInterface model) {
                        super(model, "STInterface");
                    }

                    @Override
                    public String getLabel() {
                        return getModel().getName();
                    }

                    @Override
                    protected List<Action> getActions() {
                        return Arrays.asList(
                                renameSTInterfaceAction(),
                                removeSTInterfaceAction());
                    }

                    private Action renameSTInterfaceAction() {
                        return newAction("Rename", actionEvent ->
                                getNameFromUser()
                                        .flatMap(name -> getParentNode(STGroupTreeNode.class)
                                                .flatMap(parent -> parent.isValidTemplateName(name)))
                                        .ifPresent(s -> {

                                            getModel().setName(s);
                                            save();

                                            SwingUtilities.invokeLater(() -> treeModel.nodeChanged(STInterfaceTreeNode.this));
                                        }));
                    }

                    private Action removeSTInterfaceAction() {
                        return newAction("Remove", actionEvent ->
                                confirm("Delete " + getModel().getName()).ifPresent(aBoolean -> {

                                    final STGroupTreeNode parent = (STGroupTreeNode) getParent();

                                    parent.getModel().removeInterfaces(getModel());
                                    save();

                                    SwingUtilities.invokeLater(() -> treeModel.removeNodeFromParent(STInterfaceTreeNode.this));
                                }));
                    }
                }

                class STEnumTreeNode extends BaseTreeNode<STEnum> {

                    public STEnumTreeNode(STEnum model) {
                        super(model, "STEnum");
                    }

                    @Override
                    public String getLabel() {
                        return getModel().getName();
                    }

                    @Override
                    protected List<Action> getActions() {
                        return Arrays.asList(
                                newEditSTEnumValueAction(),
                                renameSTEnumAction(),
                                removeSTEnumAction());
                    }

                    private Action newEditSTEnumValueAction() {
                        return newAction("Edit", actionEvent -> {

                            final int newFields = 5;

                            final JPanel contentPanel = new JPanel(new GridLayout((int) getModel().getValues().count() + newFields + 1, 2));
                            contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
                            contentPanel.add(new JLabel("Name"));
                            contentPanel.add(new JLabel("Lexical"));

                            // existing values:
                            final Map<STEnumValue, JTextField> txtEnumValuesName = new LinkedHashMap<>();
                            final Map<STEnumValue, JTextField> txtEnumLexical = new LinkedHashMap<>();
                            getModel().getValues().forEach(stEnumValue -> {
                                txtEnumValuesName.put(stEnumValue, new JTextField(stEnumValue.getName(), 10));
                                txtEnumLexical.put(stEnumValue, new JTextField(stEnumValue.getLexical(), 10));

                                contentPanel.add(txtEnumValuesName.get(stEnumValue));
                                contentPanel.add(txtEnumLexical.get(stEnumValue));

                                txtEnumValuesName.get(stEnumValue).addFocusListener(new SelectFocusAdapter());
                                txtEnumLexical.get(stEnumValue).addFocusListener(new SelectFocusAdapter());
                            });

                            // allow adding new values:
                            final Map<Integer, JTextField> newTxtEnumValuesName = new LinkedHashMap<>();
                            final Map<Integer, JTextField> newTxtEnumLexical = new LinkedHashMap<>();
                            for (int i = 0; i < newFields; i++) {
                                newTxtEnumValuesName.put(i, new JTextField("", 10));
                                newTxtEnumLexical.put(i, new JTextField("", 10));

                                contentPanel.add(newTxtEnumValuesName.get(i));
                                contentPanel.add(newTxtEnumLexical.get(i));

                                newTxtEnumValuesName.get(i).addFocusListener(new SelectFocusAdapter());
                                newTxtEnumLexical.get(i).addFocusListener(new SelectFocusAdapter());

                            }

                            final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Edit Enum", true);
                            dialog.add(contentPanel, BorderLayout.CENTER);

                            final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {

                                for (STEnumValue stEnumValue : txtEnumValuesName.keySet()) {
                                    final String txtEnumValueName = txtEnumValuesName.get(stEnumValue).getText().trim();
                                    final String txtEnumValueLexical = txtEnumLexical.get(stEnumValue).getText().trim();

                                    stEnumValue.setName(txtEnumValueName);
                                    stEnumValue.setLexical(txtEnumValueLexical.length() == 0 ? null : txtEnumValueLexical);
                                }

                                for (int i = 0; i < newFields; i++) {
                                    final String newEnumValue = newTxtEnumValuesName.get(i).getText().trim();
                                    final String newEnumLexical = newTxtEnumLexical.get(i).getText().trim();
                                    if (newEnumValue.length() == 0) continue;

                                    getModel().addValues(STJsonFactory.newSTEnumValue()
                                            .setName(newEnumValue)
                                            .setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));
                                }

                                save();

                                SwingUtilities.invokeLater(dialog::dispose);
                            }));

                            showDialog(dialog, btnSave);
                        });
                    }

                    private Action renameSTEnumAction() {
                        return newAction("Rename", actionEvent ->
                                getNameFromUser()
                                        .flatMap(name -> getParentNode(STGroupTreeNode.class)
                                                .flatMap(parent -> parent.isValidTemplateName(name)))
                                        .ifPresent(s -> {

                                            getModel().setName(s);
                                            save();

                                            SwingUtilities.invokeLater(() -> treeModel.nodeChanged(STEnumTreeNode.this));
                                        }));
                    }

                    private Action removeSTEnumAction() {
                        return newAction("Remove", actionEvent ->
                                confirm("Delete " + getModel().getName()).ifPresent(aBoolean -> {

                                    final STGroupTreeNode parent = (STGroupTreeNode) getParent();

                                    parent.getModel().removeEnums(getModel());
                                    save();

                                    SwingUtilities.invokeLater(() -> treeModel.removeNodeFromParent(STEnumTreeNode.this));
                                }));
                    }
                }

                class STTemplateTreeNode extends BaseTreeNode<STTemplate> {

                    public STTemplateTreeNode(STTemplate model) {
                        super(model, "STTemplate");

                        model.getChildren().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
                    }

                    @Override
                    public String getLabel() {
                        return getModel().getName();
                    }

                    @Override
                    protected List<Action> getActions() {

                        final List<Action> actions = new ArrayList<>();

                        final Set<STTemplateTreeNode> candidateChildren = new LinkedHashSet<>();
                        final TreePath[] selectionPaths = tree.getSelectionPaths();
                        if (selectionPaths != null)
                            for (TreePath selectionPath : selectionPaths)
                                if (selectionPath.getLastPathComponent() != null && (selectionPath.getLastPathComponent() instanceof STTemplateTreeNode) && !(STTemplateTreeNode.this.equals(selectionPath.getLastPathComponent())))
                                    candidateChildren.add((STTemplateTreeNode) selectionPath.getLastPathComponent());

                        if (!candidateChildren.isEmpty())
                            actions.add(reparentAction(candidateChildren));

                        final List<STTemplate> childTemplates = getModel().getChildren().collect(Collectors.toList());
                        if (!childTemplates.isEmpty())
                            actions.add(newSetInterfacesAction(childTemplates));

                        actions.add(newChildTemplateAction());
                        actions.add(newSetParameterTypesAction());
                        actions.add(newSetInterfacesAction());
                        actions.add(renameSTTemplateAction());
                        actions.add(removeSTTemplateAction());

                        return actions;
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
                                        final String key = stParameter.getName();
                                        txtParameterMap.put(key, new JTextField(stParameter.getArgumentType("Object"), 15));
                                        txtParameterMap.get(key).addFocusListener(new SelectFocusAdapter());

                                        break;
                                    case KVLIST:
                                        stParameter.getKeys().forEach(stParameterKey -> {
                                            final String kvListKey = stParameter.getName() + "." + stParameterKey.getName();
                                            txtParameterMap.put(kvListKey, new JTextField(stParameterKey.getArgumentType("Object"), 15));
                                            txtParameterMap.get(kvListKey).addFocusListener(new SelectFocusAdapter());
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

                            showDialog(dialog, btnSave);
                        });
                    }

                    private Action newSetInterfacesAction() {
                        return newAction("Set interfaces", actionEvent -> {

                            final List<JTextField> txtImplements = new ArrayList<>();
                            getModel().getImplements().forEach(implement -> {
                                final JTextField textField = new JTextField(implement, 15);
                                txtImplements.add(textField);
                                textField.addFocusListener(new SelectFocusAdapter());
                            });
                            txtImplements.add(new JTextField("", 15));
                            txtImplements.add(new JTextField("", 15));

                            final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Edit interfaces", true);
                            final JPanel contentPanel = new JPanel(new GridLayout(txtImplements.size(), 1));
                            contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
                            for (JTextField txtImplement : txtImplements) {
                                contentPanel.add(txtImplement);
                            }
                            dialog.add(contentPanel, BorderLayout.CENTER);

                            final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {

                                getModel().clearImplements();
                                for (JTextField txtImplement : txtImplements) {
                                    final String trim = txtImplement.getText().trim();
                                    if (trim.length() == 0) continue;
                                    getModel().addImplements(trim);
                                }
                                save();

                                SwingUtilities.invokeLater(dialog::dispose);
                            }));

                            showDialog(dialog, btnSave);
                        });
                    }

                    private Action newSetInterfacesAction(List<STTemplate> children) {
                        return newAction("Set interfaces on " + children.size() + " children", actionEvent -> {

                            final JTextField txtImplements = new JTextField("", 15);

                            final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Edit interfaces", true);
                            final JPanel contentPanel = new JPanel(new GridLayout(1, 1));
                            contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
                            contentPanel.add(txtImplements);
                            dialog.add(contentPanel, BorderLayout.CENTER);

                            final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {

                                final String interfaceName = txtImplements.getText().trim();

                                children.forEach(stTemplate -> stTemplate.getImplements()
                                        .filter(s -> s.equalsIgnoreCase(interfaceName))
                                        .findAny()
                                        .orElseGet(() -> {
                                            stTemplate.addImplements(interfaceName);
                                            return interfaceName;
                                        }));

                                save();

                                SwingUtilities.invokeLater(dialog::dispose);
                            }));

                            showDialog(dialog, btnSave);
                        });
                    }

                    private Action newChildTemplateAction() {
                        return newAction("New Child-template", actionEvent -> getNameFromUser()
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
                                getNameFromUser().ifPresent(name ->
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

    private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {
        return new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionEventConsumer.accept(e);
            }
        };
    }

    private void showDialog(JDialog dialog, JButton btnSave) {

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
    }

    private static class SelectFocusAdapter extends FocusAdapter {

        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            SwingUtilities.invokeLater(() -> ((JTextField) evt.getSource()).selectAll());
        }

        @Override
        public void focusLost(FocusEvent evt) {
            SwingUtilities.invokeLater(() -> {
                ((JTextField) evt.getSource()).setSelectionStart(0);
                ((JTextField) evt.getSource()).setSelectionEnd(0);
            });
        }
    }
}