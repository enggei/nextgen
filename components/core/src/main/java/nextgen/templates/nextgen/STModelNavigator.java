package nextgen.templates.nextgen;

public class STModelNavigator {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;

	STModelNavigator(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STModelNavigator");
		st.add("packageName", _packageName);
		st.add("name", _name);
		return st.render().trim();
	}

	public STModelNavigator setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public STModelNavigator removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STModelNavigator setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public STModelNavigator removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STModelNavigator that = (STModelNavigator) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "STModelNavigator(packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import ~packageName~.canvas.STModelNode;\n" + 
				"import ~packageName~.canvas.STValueNode;\n" + 
				"import ~packageName~.canvas.ScriptNode;\n" + 
				"import ~packageName~.domain.STGroupModel;\n" + 
				"import ~packageName~.domain.STTemplate;\n" + 
				"import ~packageName~.model.*;\n" + 
				"import nextgen.utils.Neo4JUtil;\n" + 
				"import nextgen.utils.SwingUtil;\n" + 
				"import org.neo4j.graphdb.Direction;\n" + 
				"import org.neo4j.graphdb.Node;\n" + 
				"import org.neo4j.graphdb.Relationship;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import javax.swing.tree.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.*;\n" + 
				"import java.net.URL;\n" + 
				"import java.util.List;\n" + 
				"import java.util.*;\n" + 
				"import java.util.concurrent.atomic.AtomicInteger;\n" + 
				"import java.util.function.Consumer;\n" + 
				"import java.util.stream.Stream;\n" + 
				"import java.util.stream.StreamSupport;\n" + 
				"\n" + 
				"public class ~name~ extends JPanel {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	private final JTree tree = new JTree();\n" + 
				"	private final STWorkspace workspace;\n" + 
				"	private final STAppPresentationModel presentationModel;\n" + 
				"	private final DefaultTreeModel treeModel;\n" + 
				"\n" + 
				"	public ~name~(STAppPresentationModel presentationModel, STWorkspace workspace) {\n" + 
				"		super(new BorderLayout());\n" + 
				"\n" + 
				"		this.presentationModel = presentationModel;\n" + 
				"		this.workspace = workspace;\n" + 
				"\n" + 
				"		RootNode rootNode = new RootNode();\n" + 
				"		treeModel = new DefaultTreeModel(rootNode);\n" + 
				"		tree.setModel(treeModel);\n" + 
				"		ToolTipManager.sharedInstance().registerComponent(tree);\n" + 
				"\n" + 
				"		tree.setCellRenderer(new DefaultTreeCellRenderer() {\n" + 
				"\n" + 
				"				@Override\n" + 
				"				public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {\n" + 
				"					final boolean isBaseTreeNode = value instanceof BaseTreeNode;\n" + 
				"					if (isBaseTreeNode) {\n" + 
				"						final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;\n" + 
				"						final ImageIcon icon = baseTreeNode.getIcon();\n" + 
				"						setIcon(icon);\n" + 
				"						setOpenIcon(icon);\n" + 
				"						setClosedIcon(icon);\n" + 
				"						setLeafIcon(icon);\n" + 
				"						setToolTipText(baseTreeNode.getTooltip());\n" + 
				"						return super.getTreeCellRendererComponent(tree, baseTreeNode.getLabel(), sel, expanded, leaf, row, hasFocus);\n" + 
				"					}\n" + 
				"					return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);\n" + 
				"				}\n" + 
				"		});\n" + 
				"\n" + 
				"		tree.addMouseListener(new MouseAdapter() {\n" + 
				"				@Override\n" + 
				"				public void mouseClicked(MouseEvent e) {\n" + 
				"					if (SwingUtilities.isRightMouseButton(e)) {\n" + 
				"\n" + 
				"						final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());\n" + 
				"						if (selectionPath == null) return;\n" + 
				"						final Object lastPathComponent = selectionPath.getLastPathComponent();\n" + 
				"						if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;\n" + 
				"\n" + 
				"						showPopup((BaseTreeNode<?>) lastPathComponent, e.getX(), e.getY());\n" + 
				"					}\n" + 
				"				}\n" + 
				"		});\n" + 
				"\n" + 
				"		tree.addKeyListener(new KeyAdapter() {\n" + 
				"				@Override\n" + 
				"				public void keyPressed(KeyEvent e) {\n" + 
				"\n" + 
				"					if (e.getKeyCode() == KeyEvent.VK_SPACE) {\n" + 
				"						final TreePath selectionPath = tree.getSelectionPath();\n" + 
				"						if (selectionPath == null) return;\n" + 
				"						final Object lastPathComponent = selectionPath.getLastPathComponent();\n" + 
				"						if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;\n" + 
				"\n" + 
				"						final Rectangle bounds = tree.getPathBounds(selectionPath);\n" + 
				"						if (bounds == null) return;\n" + 
				"\n" + 
				"						showPopup((BaseTreeNode<?>) lastPathComponent, (int) bounds.getX(), (int) bounds.getY());\n" + 
				"					}\n" + 
				"				}\n" + 
				"		});\n" + 
				"\n" + 
				"		setPreferredSize(new Dimension(300, 600));\n" + 
				"		add(new JScrollPane(tree), BorderLayout.CENTER);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Set<STValue> getSelectedValues() {\n" + 
				"		final Set<STValue> values = new TreeSet<>((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()));\n" + 
				"\n" + 
				"		final TreePath[] selectionPaths = tree.getSelectionPaths();\n" + 
				"		if (selectionPaths == null) return values;\n" + 
				"		for (TreePath selectionPath : selectionPaths) {\n" + 
				"				if (selectionPath.getLastPathComponent() instanceof STValueTreeNode) {\n" + 
				"					final STValueTreeNode stValuesRootNode = (STValueTreeNode) selectionPath.getLastPathComponent();\n" + 
				"					values.add(stValuesRootNode.getModel());\n" + 
				"				}\n" + 
				"		}\n" + 
				"		return values;\n" + 
				"	}\n" + 
				"\n" + 
				"	public class BaseTreeNode<T> extends DefaultMutableTreeNode {\n" + 
				"\n" + 
				"		protected ImageIcon icon;\n" + 
				"		protected String tooltip;\n" + 
				"\n" + 
				"		public BaseTreeNode(T model, String icon) {\n" + 
				"				setUserObject(model);\n" + 
				"				this.icon = loadIcon(icon);\n" + 
				"				this.tooltip = \"\";\n" + 
				"		}\n" + 
				"\n" + 
				"		@SuppressWarnings(\"unchecked\")\n" + 
				"		public T getModel() {\n" + 
				"				return (T) getUserObject();\n" + 
				"		}\n" + 
				"\n" + 
				"		public String getLabel() {\n" + 
				"				return getUserObject().toString();\n" + 
				"		}\n" + 
				"\n" + 
				"		public ImageIcon getIcon() {\n" + 
				"				return icon;\n" + 
				"		}\n" + 
				"\n" + 
				"		protected java.util.List<Action> getActions() {\n" + 
				"				return new ArrayList<>();\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public boolean equals(Object obj) {\n" + 
				"				if (!(obj instanceof BaseTreeNode)) return false;\n" + 
				"				return getModel().equals(((BaseTreeNode<?>) obj).getModel());\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public int hashCode() {\n" + 
				"				return getModel().hashCode();\n" + 
				"		}\n" + 
				"\n" + 
				"		@SuppressWarnings(\"unchecked\")\n" + 
				"		public <T> Optional<T> getParentNode(Class<T> type) {\n" + 
				"				if (getClass().equals(type)) return (Optional<T>) Optional.of(this);\n" + 
				"\n" + 
				"				final TreeNode parent = getParent();\n" + 
				"				if (!(parent instanceof BaseTreeNode)) return Optional.empty();\n" + 
				"\n" + 
				"				return ((BaseTreeNode<?>) parent).getParentNode(type);\n" + 
				"		}\n" + 
				"		\n" + 
				"\n" + 
				"		public String getTooltip() {\n" + 
				"				return tooltip;\n" + 
				"		}\n" + 
				"\n" + 
				"		protected void nodesWhereInserted() {\n" + 
				"				treeModel.nodesWereInserted(BaseTreeNode.this, new int[]{getChildCount() - 1});\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	class RootNode extends BaseTreeNode<String> {\n" + 
				"\n" + 
				"		public RootNode() {\n" + 
				"				super(\"DB\", \"RootNode\");\n" + 
				"\n" + 
				"				presentationModel.db.doInTransaction(transaction -> {\n" + 
				"					add(new ProjectsRootNode());\n" + 
				"					presentationModel.db.getGroupModels().forEach(stGroupModel -> add(new STGroupModelTreeNode(stGroupModel)));\n" + 
				"					add(new ScriptsRootNode());\n" + 
				"					add(new STValuesRootNode());\n" + 
				"				});\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public class ProjectsRootNode extends BaseTreeNode<String> {\n" + 
				"\n" + 
				"		public ProjectsRootNode() {\n" + 
				"				super(\"Projects\", null);\n" + 
				"\n" + 
				"				presentationModel.db.findAllProject().forEach(project -> add(new ProjectTreeNode(project)));\n" + 
				"				org.greenrobot.eventbus.EventBus.getDefault().register(this);\n" + 
				"		}\n" + 
				"\n" + 
				"		@org.greenrobot.eventbus.Subscribe()\n" + 
				"		public void onNewProject(~packageName~.STAppEvents.NewProject event) {\n" + 
				"				presentationModel.doLaterInTransaction(transaction -> {\n" + 
				"					add(new ProjectTreeNode(event.project));\n" + 
				"					nodesWhereInserted();\n" + 
				"				});\n" + 
				"		}\n" + 
				"\n" + 
				"		private class ProjectTreeNode extends BaseTreeNode<Project> {\n" + 
				"\n" + 
				"				private final String label;\n" + 
				"\n" + 
				"				public ProjectTreeNode(Project project) {\n" + 
				"					super(project, null);\n" + 
				"					tooltip = project.getName();\n" + 
				"					label = project.getName();\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				protected List<Action> getActions() {\n" + 
				"					final List<Action> actions = super.getActions();\n" + 
				"\n" + 
				"					return actions;\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				public String getLabel() {\n" + 
				"					return label;\n" + 
				"				}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	class ScriptsRootNode extends BaseTreeNode<String> {\n" + 
				"\n" + 
				"		public ScriptsRootNode() {\n" + 
				"				super(\"Scripts\", null);\n" + 
				"\n" + 
				"				presentationModel.db.findAllScript().forEach(script -> add(new ScriptTreeNode(script)));\n" + 
				"				org.greenrobot.eventbus.EventBus.getDefault().register(this);\n" + 
				"		}\n" + 
				"\n" + 
				"		@org.greenrobot.eventbus.Subscribe()\n" + 
				"		public void onNewScript(~packageName~.STAppEvents.NewScript event) {\n" + 
				"				presentationModel.doLaterInTransaction(transaction -> {\n" + 
				"					add(new ScriptsRootNode.ScriptTreeNode(event.script));\n" + 
				"					nodesWhereInserted();\n" + 
				"				});\n" + 
				"		}\n" + 
				"\n" + 
				"		private class ScriptTreeNode extends BaseTreeNode<Script> {\n" + 
				"\n" + 
				"				private String label;\n" + 
				"\n" + 
				"				public ScriptTreeNode(Script script) {\n" + 
				"					super(script, \"language-java\");\n" + 
				"					tooltip = presentationModel.render(script.getScript());\n" + 
				"					label = script.getName();\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				protected List<Action> getActions() {\n" + 
				"					final List<Action> actions = super.getActions();\n" + 
				"\n" + 
				"					actions.add(newAction(\"Open\", new Consumer<ActionEvent>() {\n" + 
				"						@Override\n" + 
				"						public void accept(ActionEvent actionEvent) {\n" + 
				"								workspace.findCanvas()\n" + 
				"										.ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {\n" + 
				"												final ScriptNode node = new ScriptNode(stCanvas, getModel());\n" + 
				"												stCanvas.addNode(node);\n" + 
				"\n" + 
				"												workspace.setSelectedComponent(stCanvas);\n" + 
				"												stCanvas.requestFocusInWindow();\n" + 
				"												stCanvas.centerNode(node);\n" + 
				"										})));\n" + 
				"						}\n" + 
				"					}));\n" + 
				"\n" + 
				"					return actions;\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				public String getLabel() {\n" + 
				"					return label;\n" + 
				"				}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public class STValuesRootNode extends BaseTreeNode<String> {\n" + 
				"\n" + 
				"		STValuesRootNode() {\n" + 
				"				super(\"Values\", null);\n" + 
				"				presentationModel.db.findAllSTValue()\n" + 
				"						.filter(stValue -> stValue.getType() != null)\n" + 
				"						.filter(stValue -> stValue.getType().equals(STValueType.PRIMITIVE))\n" + 
				"						.sorted((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()))\n" + 
				"						.forEach(stValue -> add(new STValueTreeNode(stValue)));\n" + 
				"				org.greenrobot.eventbus.EventBus.getDefault().register(this);\n" + 
				"		}\n" + 
				"\n" + 
				"		@org.greenrobot.eventbus.Subscribe()\n" + 
				"		public void onNewSTValue(~packageName~.STAppEvents.NewSTValue event) {\n" + 
				"				presentationModel.doLaterInTransaction(transaction -> {\n" + 
				"					add(new STValueTreeNode(event.sTValue));\n" + 
				"					nodesWhereInserted();\n" + 
				"				});\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		protected List<Action> getActions() {\n" + 
				"				final List<Action> actions = super.getActions();\n" + 
				"				actions.add(newEditValuesAction());\n" + 
				"				actions.add(newReconcileAction());\n" + 
				"				return actions;\n" + 
				"		}\n" + 
				"\n" + 
				"		private Action newEditValuesAction() {\n" + 
				"				return newAction(\"Edit Values\", actionEvent -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {\n" + 
				"					final STValueGrid valueGrid = workspace.getValueGrid();\n" + 
				"					workspace.setSelectedComponent(valueGrid);\n" + 
				"					valueGrid.requestFocusInWindow();\n" + 
				"				})));\n" + 
				"		}\n" + 
				"\n" + 
				"		private Action newReconcileAction() {\n" + 
				"				return new AbstractAction(\"Reconcile\") {\n" + 
				"					@Override\n" + 
				"					public void actionPerformed(ActionEvent e) {\n" + 
				"						SwingUtilities.invokeLater(() -> {\n" + 
				"\n" + 
				"								final Set<Node> delete = new LinkedHashSet<>();\n" + 
				"\n" + 
				"								presentationModel.db.doInTransaction(transaction -> presentationModel.db.findAllSTValue()\n" + 
				"										.filter(stValue -> stValue.getType() != null)\n" + 
				"										.filter(stValue -> stValue.getValue() != null)\n" + 
				"										.filter(stValue -> stValue.getType().equals(STValueType.PRIMITIVE))\n" + 
				"										.forEach(stValue -> {\n" + 
				"												log.info(stValue.getValue());\n" + 
				"												presentationModel.db.findAllSTValueByValue(stValue.getValue())\n" + 
				"														.filter(stValue1 -> !stValue1.getUuid().equals(stValue.getUuid()))\n" + 
				"														.filter(stValue1 -> stValue1.getType() != null)\n" + 
				"														.filter(stValue1 -> stValue1.getType().equals(STValueType.PRIMITIVE))\n" + 
				"														.forEach(stValue1 -> {\n" + 
				"																log.info(\"\\t duplicate \" + stValue1.getValue());\n" + 
				"\n" + 
				"																final Node node = stValue1.getNode();\n" + 
				"																node.getRelationships(Direction.INCOMING).forEach(relationship -> {\n" + 
				"																	if (relationship.getType().equals(org.neo4j.graphdb.RelationshipType.withName(\"ref\")))\n" + 
				"																		relationship.delete();\n" + 
				"\n" + 
				"																	final Node src = relationship.getOtherNode(node);\n" + 
				"																	final Relationship newRelation = src.createRelationshipTo(stValue.getNode(), relationship.getType());\n" + 
				"																	relationship.getPropertyKeys().forEach(s -> newRelation.setProperty(s, relationship.getProperty(s)));\n" + 
				"																	relationship.delete();\n" + 
				"																});\n" + 
				"\n" + 
				"																delete.add(node);\n" + 
				"														});\n" + 
				"										}));\n" + 
				"\n" + 
				"								presentationModel.db.doInTransaction(transaction -> {\n" + 
				"									for (Node node : delete) {\n" + 
				"										if (node.getRelationships().iterator().hasNext()) continue;\n" + 
				"										log.info(\"deleting node \");\n" + 
				"										log.info(Neo4JUtil.toString(node));\n" + 
				"										node.delete();\n" + 
				"									}\n" + 
				"\n" + 
				"									treeModel.nodeStructureChanged(STValuesRootNode.this);\n" + 
				"								});\n" + 
				"						});\n" + 
				"					}\n" + 
				"				};\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public class STValueTreeNode extends BaseTreeNode<STValue> {\n" + 
				"\n" + 
				"		private String label;\n" + 
				"\n" + 
				"		STValueTreeNode(STValue stValue) {\n" + 
				"				super(stValue, null);\n" + 
				"				this.label = stValue.getValue();\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public String getLabel() {\n" + 
				"				return this.label;\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		protected List<Action> getActions() {\n" + 
				"				final List<Action> actions = super.getActions();\n" + 
				"				actions.add(openValueAction());\n" + 
				"				actions.add(toClipboardAction());\n" + 
				"				actions.add(fromClipboardAction());\n" + 
				"				return actions;\n" + 
				"		}\n" + 
				"\n" + 
				"		private Action toClipboardAction() {\n" + 
				"				return newAction(\"To Clipboard\", actionEvent -> presentationModel.db.doInTransaction(transaction -> SwingUtil.toClipboard(presentationModel.render(getModel()).trim())));\n" + 
				"		}\n" + 
				"\n" + 
				"		private Action fromClipboardAction() {\n" + 
				"				return newAction(\"Set From Clipboard\", actionEvent -> presentationModel.db.doInTransaction(transaction -> getModel().setValue(SwingUtil.fromClipboard().trim())));\n" + 
				"		}\n" + 
				"\n" + 
				"		private Action openValueAction() {\n" + 
				"				return newAction(\"Open\", actionEvent -> workspace.findCanvas().ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {\n" + 
				"					final STValueNode node = new STValueNode(stCanvas, getModel());\n" + 
				"					stCanvas.addNode(node);\n" + 
				"\n" + 
				"					workspace.setSelectedComponent(stCanvas);\n" + 
				"					stCanvas.requestFocusInWindow();\n" + 
				"					stCanvas.centerNode(node);\n" + 
				"				}))));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	class STGroupModelTreeNode extends BaseTreeNode<STGroupModel> {\n" + 
				"\n" + 
				"		public STGroupModelTreeNode(STGroupModel model) {\n" + 
				"				super(model, model.getIcon());\n" + 
				"\n" + 
				"				model.getTemplates().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public String getLabel() {\n" + 
				"				return getModel().getName();\n" + 
				"		}\n" + 
				"\n" + 
				"		class STTemplateTreeNode extends BaseTreeNode<STTemplate> {\n" + 
				"\n" + 
				"				public STTemplateTreeNode(STTemplate model) {\n" + 
				"					super(model, \"STTemplate\");\n" + 
				"\n" + 
				"					presentationModel.db.findAllSTModelByStTemplate(model.uuid()).forEach(stModel -> add(new STModelTreeNode(stModel, model)));\n" + 
				"\n" + 
				"					model.getChildren().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				public String getLabel() {\n" + 
				"					return getModel().getName();\n" + 
				"				}\n" + 
				"\n" + 
				"				public void addSTModel(STModel stModel) {\n" + 
				"					final STModelTreeNode newChild = new STModelTreeNode(stModel, getModel());\n" + 
				"					insert(newChild, getChildCount());\n" + 
				"					tree.expandPath(new TreePath(getPath()));\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				protected List<Action> getActions() {\n" + 
				"					final List<Action> actions = super.getActions();\n" + 
				"					actions.add(newEditModelsAction());\n" + 
				"					actions.add(newInstanceAction());\n" + 
				"					return actions;\n" + 
				"				}\n" + 
				"\n" + 
				"				private Action newEditModelsAction() {\n" + 
				"					return newAction(\"Edit Models\", actionEvent -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {\n" + 
				"						final STModelGrid stModelGrid = workspace.getModelGrid(getModel());\n" + 
				"						workspace.setSelectedComponent(stModelGrid);\n" + 
				"						stModelGrid.requestFocusInWindow();\n" + 
				"					})));\n" + 
				"				}\n" + 
				"\n" + 
				"				private Action newInstanceAction() {\n" + 
				"					return newAction(\"New instance\", actionEvent -> workspace.findCanvas().ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {\n" + 
				"						final STModelNode node = new STModelNode(stCanvas, getModel(), presentationModel.db.newSTModel(getModel().uuid(), getModel()));\n" + 
				"						stCanvas.addNode(node);\n" + 
				"						workspace.setSelectedComponent(stCanvas);\n" + 
				"						stCanvas.requestFocusInWindow();\n" + 
				"						stCanvas.centerNode(node);\n" + 
				"					}))));\n" + 
				"				}\n" + 
				"\n" + 
				"				class STModelTreeNode extends BaseTreeNode<STModel> {\n" + 
				"\n" + 
				"					private String label;\n" + 
				"\n" + 
				"					public STModelTreeNode(STModel model, STTemplate stTemplate) {\n" + 
				"						super(model, \"STGDirectory\");\n" + 
				"						tooltip = presentationModel.render(model);\n" + 
				"						label = presentationModel.tryToFindArgument(model, \"name\", () -> cut(tooltip));\n" + 
				"					}\n" + 
				"\n" + 
				"					@Override\n" + 
				"					public String getLabel() {\n" + 
				"						return label;\n" + 
				"					}\n" + 
				"\n" + 
				"					@Override\n" + 
				"					protected List<Action> getActions() {\n" + 
				"						final List<Action> actions = super.getActions();\n" + 
				"						actions.add(openModelAction());\n" + 
				"						actions.add(editModelAction());\n" + 
				"						actions.add(generateAction());\n" + 
				"						return actions;\n" + 
				"					}\n" + 
				"\n" + 
				"					private Action openModelAction() {\n" + 
				"						return newAction(\"Open\", actionEvent -> getParentNode(STTemplateTreeNode.class)\n" + 
				"									.ifPresent(stTemplateTreeNode -> workspace.findCanvas()\n" + 
				"												.ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {\n" + 
				"													final STModelNode node = new STModelNode(stCanvas, stTemplateTreeNode.getModel(), getModel());\n" + 
				"													stCanvas.addNode(node);\n" + 
				"\n" + 
				"													workspace.setSelectedComponent(stCanvas);\n" + 
				"													stCanvas.requestFocusInWindow();\n" + 
				"													stCanvas.centerNode(node);\n" + 
				"												})))));\n" + 
				"					}\n" + 
				"\n" + 
				"					private Action editModelAction() {\n" + 
				"						return newAction(\"Edit\", actionEvent -> getParentNode(STTemplateTreeNode.class)\n" + 
				"									.ifPresent(stTemplateTreeNode -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {\n" + 
				"										final STModelEditor modelEditor = workspace.getModelEditor(stTemplateTreeNode.getModel(), getModel());\n" + 
				"										modelEditor.setModelNavigator(~name~.this);\n" + 
				"										workspace.setSelectedComponent(modelEditor);\n" + 
				"									}))));\n" + 
				"					}\n" + 
				"\n" + 
				"					private Action generateAction() {\n" + 
				"						return newAction(\"Generate\", actionEvent -> SwingUtilities.invokeLater(() -> {\n" + 
				"								presentationModel.doLaterInTransaction(tx -> getModel().getFiles().forEach(stFile -> {\n" + 
				"									if (stFile.getPath() == null) return;\n" + 
				"									~packageName~.STGenerator.writeToFile(presentationModel.render(getModel()), stFile.getPackageName().getValue(), stFile.getName().getValue(), stFile.getType().getValue(), new java.io.File(stFile.getPath().getValue()));\n" + 
				"								}));\n" + 
				"						}));\n" + 
				"					}\n" + 
				"				}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {\n" + 
				"		return new AbstractAction(name) {\n" + 
				"				@Override\n" + 
				"				public void actionPerformed(ActionEvent e) {\n" + 
				"					actionEventConsumer.accept(e);\n" + 
				"				}\n" + 
				"		};\n" + 
				"	}\n" + 
				"\n" + 
				"	private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();\n" + 
				"\n" + 
				"	private ImageIcon loadIcon(String iconName) {\n" + 
				"\n" + 
				"		if (iconName == null) return null;\n" + 
				"\n" + 
				"		if (cache.containsKey(iconName)) return cache.get(iconName);\n" + 
				"\n" + 
				"		URL resource = getClass().getClassLoader().getResource(\"icons/\" + iconName + \"16x16.png\");\n" + 
				"		if (resource == null) resource = getClass().getClassLoader().getResource(\"icons/STGroup16x16.png\");\n" + 
				"\n" + 
				"		cache.put(iconName, new ImageIcon(Objects.requireNonNull(resource)));\n" + 
				"		return cache.get(iconName);\n" + 
				"	}\n" + 
				"\n" + 
				"	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {\n" + 
				"		final List<Action> actions = lastPathComponent.getActions();\n" + 
				"		if (actions.isEmpty()) return;\n" + 
				"\n" + 
				"		final JPopupMenu pop = new JPopupMenu();\n" + 
				"		pop.add(\"With \" + lastPathComponent.getLabel() + \" :\");\n" + 
				"		for (Action action : actions)\n" + 
				"				pop.add(action);\n" + 
				"\n" + 
				"		SwingUtilities.invokeLater(() -> pop.show(tree, x, y));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static String cut(String text) {\n" + 
				"		return text.substring(0, Math.min(text.length(), 20));\n" + 
				"	}\n" + 
				"\n" + 
				"} >>";
}  