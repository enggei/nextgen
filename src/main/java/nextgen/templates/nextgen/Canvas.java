package nextgen.templates.nextgen;

public class Canvas {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _packageName;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _rightClickStatements = new java.util.ArrayList<>();
	private java.util.List<CanvasRelation> _canvasRelations = new java.util.ArrayList<>();
	private java.util.List<CanvasNode> _canvasNodes = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _finalFields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _keyPressActions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _rightClickActions = new java.util.ArrayList<>();

	Canvas(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Canvas");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _rightClickStatements) st.add("rightClickStatements", o);
		for (Object o : _canvasRelations) st.add("canvasRelations", o);
		for (Object o : _canvasNodes) st.add("canvasNodes", o);
		for (Object o : _actions) st.add("actions", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _finalFields) st.addAggr("finalFields.{init,type,name}", map.get("init"), map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _keyPressActions) st.addAggr("keyPressActions.{key,name}", map.get("key"), map.get("name"));
		for (java.util.Map<String, Object> map : _rightClickActions) st.addAggr("rightClickActions.{name}", map.get("name"));
		return st.render().trim();
	}

	public Canvas setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Canvas removeName() {
		this._name = null;
		return this;
	} 

	public Canvas setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public Canvas removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Canvas addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public Canvas setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Canvas setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public Canvas removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public Canvas removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public Canvas addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public Canvas setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Canvas setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public Canvas removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public Canvas removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public Canvas addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public Canvas setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Canvas setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public Canvas removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public Canvas removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public Canvas addRightClickStatements(Object value) {
		this._rightClickStatements.add(value);
		return this;
	}

	public Canvas setRightClickStatements(Object[] value) {
		this._rightClickStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Canvas setRightClickStatements(java.util.Collection<Object> values) {
		this._rightClickStatements.addAll(values);
		return this;
	}

	public Canvas removeRightClickStatements(Object value) {
		this._rightClickStatements.remove(value);
		return this;
	}

	public Canvas removeRightClickStatements(int index) {
		this._rightClickStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRightClickStatements() {
		return this._rightClickStatements;
	} 

	public Canvas addCanvasRelations(CanvasRelation value) {
		this._canvasRelations.add(value);
		return this;
	}

	public Canvas setCanvasRelations(CanvasRelation[] value) {
		this._canvasRelations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Canvas setCanvasRelations(java.util.Collection<CanvasRelation> values) {
		this._canvasRelations.addAll(values);
		return this;
	}

	public Canvas removeCanvasRelations(CanvasRelation value) {
		this._canvasRelations.remove(value);
		return this;
	}

	public Canvas removeCanvasRelations(int index) {
		this._canvasRelations.remove(index);
		return this;
	}

	public java.util.List<CanvasRelation> getCanvasRelations() {
		return this._canvasRelations;
	} 

	public Canvas addCanvasNodes(CanvasNode value) {
		this._canvasNodes.add(value);
		return this;
	}

	public Canvas setCanvasNodes(CanvasNode[] value) {
		this._canvasNodes.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Canvas setCanvasNodes(java.util.Collection<CanvasNode> values) {
		this._canvasNodes.addAll(values);
		return this;
	}

	public Canvas removeCanvasNodes(CanvasNode value) {
		this._canvasNodes.remove(value);
		return this;
	}

	public Canvas removeCanvasNodes(int index) {
		this._canvasNodes.remove(index);
		return this;
	}

	public java.util.List<CanvasNode> getCanvasNodes() {
		return this._canvasNodes;
	} 

	public Canvas addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public Canvas setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Canvas setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public Canvas removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public Canvas removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public Canvas addFields(Object _type, String _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Canvas addFields(Canvas_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<Canvas_Fields> streamFields() {
		return this._fields.stream().map(Canvas_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Canvas_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFields_Name() {
		return streamFields().map(Canvas_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Canvas_Fields {

		Object _type;
		String _name;

		public Canvas_Fields(Object _type, String _name) {
			this._type = _type;
			this._name = _name;
		}

		private Canvas_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (String) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public String getName() {
			return this._name;
		}

	}  

	public Canvas addFinalFields(Object _init, Object _type, String _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("init", _init);
		map.put("type", _type);
		map.put("name", _name);
		this._finalFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFinalFields() {
		return this._finalFields;
	}

	public Canvas addFinalFields(Canvas_FinalFields value) {
		return addFinalFields(value._init, value._type, value._name);
	}

	public java.util.stream.Stream<Canvas_FinalFields> streamFinalFields() {
		return this._finalFields.stream().map(Canvas_FinalFields::new);
	}

	public java.util.List<Object> getFinalFields_Init() {
		return streamFinalFields().map(Canvas_FinalFields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFinalFields_Type() {
		return streamFinalFields().map(Canvas_FinalFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFinalFields_Name() {
		return streamFinalFields().map(Canvas_FinalFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Canvas_FinalFields {

		Object _init;
		Object _type;
		String _name;

		public Canvas_FinalFields(Object _init, Object _type, String _name) {
			this._init = _init;
			this._type = _type;
			this._name = _name;
		}

		private Canvas_FinalFields(java.util.Map<String, Object> map) {
			this._init = (Object) map.get("init");
			this._type = (Object) map.get("type");
			this._name = (String) map.get("name");
		}

		public Object getInit() {
			return this._init;
		}

		public Object getType() {
			return this._type;
		}

		public String getName() {
			return this._name;
		}

	}  

	public Canvas addKeyPressActions(Object _key, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("name", _name);
		this._keyPressActions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKeyPressActions() {
		return this._keyPressActions;
	}

	public Canvas addKeyPressActions(Canvas_KeyPressActions value) {
		return addKeyPressActions(value._key, value._name);
	}

	public java.util.stream.Stream<Canvas_KeyPressActions> streamKeyPressActions() {
		return this._keyPressActions.stream().map(Canvas_KeyPressActions::new);
	}

	public java.util.List<Object> getKeyPressActions_Key() {
		return streamKeyPressActions().map(Canvas_KeyPressActions::getKey).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getKeyPressActions_Name() {
		return streamKeyPressActions().map(Canvas_KeyPressActions::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Canvas_KeyPressActions {

		Object _key;
		Object _name;

		public Canvas_KeyPressActions(Object _key, Object _name) {
			this._key = _key;
			this._name = _name;
		}

		private Canvas_KeyPressActions(java.util.Map<String, Object> map) {
			this._key = (Object) map.get("key");
			this._name = (Object) map.get("name");
		}

		public Object getKey() {
			return this._key;
		}

		public Object getName() {
			return this._name;
		}

	}  

	public Canvas addRightClickActions(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._rightClickActions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRightClickActions() {
		return this._rightClickActions;
	}

	public Canvas addRightClickActions(Canvas_RightClickActions value) {
		return addRightClickActions(value._name);
	}

	public java.util.stream.Stream<Canvas_RightClickActions> streamRightClickActions() {
		return this._rightClickActions.stream().map(Canvas_RightClickActions::new);
	}

	public java.util.List<Object> getRightClickActions_Name() {
		return streamRightClickActions().map(Canvas_RightClickActions::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Canvas_RightClickActions {

		Object _name;

		public Canvas_RightClickActions(Object _name) {
			this._name = _name;
		}

		private Canvas_RightClickActions(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Canvas that = (Canvas) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Canvas(imports,name,fields,packageName,constructorStatements,methods,rightClickStatements,finalFields,keyPressActions,rightClickActions,canvasRelations,canvasNodes,actions) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.piccolo2d.PCamera;\n" + 
				"import org.piccolo2d.PCanvas;\n" + 
				"import org.piccolo2d.PLayer;\n" + 
				"import org.piccolo2d.PNode;\n" + 
				"import org.piccolo2d.event.*;\n" + 
				"import org.piccolo2d.nodes.PPath;\n" + 
				"import org.piccolo2d.nodes.PText;\n" + 
				"import org.piccolo2d.util.PBounds;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.awt.event.KeyEvent;\n" + 
				"import java.awt.geom.AffineTransform;\n" + 
				"import java.awt.geom.Point2D;\n" + 
				"import java.awt.geom.Rectangle2D;\n" + 
				"import java.beans.PropertyChangeEvent;\n" + 
				"import java.beans.PropertyChangeListener;\n" + 
				"import java.util.*;\n" + 
				"import java.util.List;\n" + 
				"import java.util.concurrent.ConcurrentHashMap;\n" + 
				"import java.util.function.Consumer;\n" + 
				"import java.util.function.Predicate;\n" + 
				"import java.util.stream.Collectors;\n" + 
				"import java.util.stream.Stream;\n" + 
				"import java.util.stream.StreamSupport;\n" + 
				"\n" + 
				"import static java.awt.event.KeyEvent.*;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends PCanvas implements PInputEventListener {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	private final PLayer nodeLayer;\n" + 
				"	private final PLayer relationLayer = new PLayer();\n" + 
				"\n" + 
				"	final Map<String, BaseCanvasNode<?~gt()~> nodeMap = new ConcurrentHashMap<>();\n" + 
				"	final Map<String, BaseCanvasRelation> relationMap = new ConcurrentHashMap<>();\n" + 
				"\n" + 
				"	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();\n" + 
				"	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();\n" + 
				"	final CanvasZoomHandler canvasZoomHandler = new CanvasZoomHandler();\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	~finalFields:{it|private final ~it.type~ ~it.name~ = ~it.init~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		this(UIManager.getColor(\"Panel.background\"), new Dimension(1024, 1024)~if(fields)~, ~fields:{it|~it.name~};separator=\", \"~~endif~);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public ~name~(Color background, Dimension preferredSize~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super();\n" + 
				"\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"		setBackground(background);\n" + 
				"		setPreferredSize(preferredSize);\n" + 
				"		nodeLayer = getLayer();\n" + 
				"		getCamera().addLayer(0, relationLayer);\n" + 
				"\n" + 
				"		removeInputEventListener(getZoomEventHandler());\n" + 
				"		addInputEventListener(canvasZoomHandler);\n" + 
				"		addInputEventListener(canvasInputEventsHandler);\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name~ thisCanvas() {\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void processEvent(PInputEvent pInputEvent, int i) {\n" + 
				"		canvasInputEventsHandler.processEvent(pInputEvent, i);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Point getCenterPosition() {\n" + 
				"		final java.awt.geom.Point2D center2D = getCamera().getViewBounds().getCenter2D();\n" + 
				"		return new Point((int) center2D.getX(), (int) center2D.getY());\n" + 
				"	}\n" + 
				"\n" + 
				"	public Point getCurrentMousePosition() {\n" + 
				"		final Point mousePosition = getMousePosition();\n" + 
				"		if (mousePosition == null) return getCenterPosition();\n" + 
				"		final java.awt.geom.Point2D localToView = getCamera().localToView(mousePosition);\n" + 
				"		return new Point((int) localToView.getX(), (int) localToView.getY());\n" + 
				"	}\n" + 
				"\n" + 
				"	public void centerNode(BaseCanvasNode<?> node) {\n" + 
				"		SwingUtilities.invokeLater(() -> getCamera().animateViewToCenterBounds(node.getGlobalFullBounds(), false, 500));\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public Stream<BaseCanvasNode<?~gt()~> getAllNodes() {\n" + 
				"		return nodeLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof BaseCanvasNode);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Stream<BaseCanvasNode<?~gt()~> getSelectedNodes() {\n" + 
				"		return getAllNodes().filter(BaseCanvasNode::isSelected);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Stream<BaseCanvasNode<?~gt()~> getUnselectedNodes() {\n" + 
				"		return getAllNodes().filter(stNode -> !stNode.isSelected());\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public <R extends BaseCanvasRelation> Stream<R> getAllRelations() {\n" + 
				"		return relationLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof BaseCanvasRelation);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <R extends BaseCanvasRelation> Stream<R> getSelectedRelations() {\n" + 
				"		return (Stream<R>) getAllRelations().filter(BaseCanvasRelation::isSelected);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends BaseCanvasNode<?~gt()~> N addNode(N node) {\n" + 
				"		return addNode(node.getUuid(), () -> node);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends BaseCanvasNode<?~gt()~> N addNode(String uuid, java.util.function.Supplier<N> supplier) {\n" + 
				"		return addNode(uuid, supplier, true);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends BaseCanvasNode<?~gt()~> N addNode(String uuid, java.util.function.Supplier<N> supplier, boolean centerNode) {\n" + 
				"\n" + 
				"		final N existing = getNode(uuid);\n" + 
				"		if (existing != null) {\n" + 
				"			log.debug(\"N-\" + uuid + \" exists in canvas\");\n" + 
				"			existing.refresh();\n" + 
				"			existing.select();\n" + 
				"			return existing;\n" + 
				"		}\n" + 
				"		log.debug(\"N-\" + uuid + \" added to canvas\");\n" + 
				"\n" + 
				"		final N node= supplier.get();\n" + 
				"		node.select();\n" + 
				"		node.setOffset(getCenterPosition());\n" + 
				"		nodeMap.put(node.getUuid(), node);\n" + 
				"		nodeLayer.addChild(node);\n" + 
				"\n" + 
				"		//nextgen.st.STAppEvents.postNodeAddedToCanvas(this, node);\n" + 
				"\n" + 
				"		node.addedToCanvas();\n" + 
				"\n" + 
				"		getAllNodes()\n" + 
				"				.filter(stNode -> !stNode.getUuid().equals(node.getUuid()))\n" + 
				"				.forEach(stNode -> stNode.newNodeAdded(node));\n" + 
				"\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			node.refresh();\n" + 
				"			if(centerNode) centerNode(node);\n" + 
				"		});\n" + 
				"\n" + 
				"		return node;\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends BaseCanvasNode<?~gt()~> N getNode(String uuid) {\n" + 
				"		return (N) nodeMap.get(uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	<N extends BaseCanvasNode<?~gt()~> N removeNode(String uuid) {\n" + 
				"		final BaseCanvasNode remove = nodeMap.remove(uuid);\n" + 
				"		final N old = (N) nodeLayer.removeChild(remove);\n" + 
				"		log.debug(\"\\tN-\"+ uuid + \" removed from canvas : \" + (old == null ? \"null\" : old.getUuid()));\n" + 
				"		return (N) remove;\n" + 
				"	}\n" + 
				"\n" + 
				"	public <R extends BaseCanvasRelation> R addRelation(String uuid, java.util.function.Supplier<R> supplier) {\n" + 
				"\n" + 
				"		final R existing = getRelation(uuid);\n" + 
				"		if (existing != null) {\n" + 
				"			log.debug(\"R-\"+ uuid + \" exists in canvas\");\n" + 
				"			return existing;\n" + 
				"		}\n" + 
				"		log.debug(\"R-\"+ uuid + \" added to canvas\");\n" + 
				"\n" + 
				"		final R relation = supplier.get();\n" + 
				"		relationMap.put(relation.getUuid(), relation);\n" + 
				"		relationLayer.addChild(relation);\n" + 
				"		return relation;\n" + 
				"	}\n" + 
				"\n" + 
				"	<R extends BaseCanvasRelation> R removeRelation(String uuid) {\n" + 
				"		final BaseCanvasRelation remove = relationMap.remove(uuid);\n" + 
				"		if (remove == null) return null;\n" + 
				"\n" + 
				"		remove.close();\n" + 
				"		final R old = (R) relationLayer.removeChild(remove);\n" + 
				"		log.debug(\"\\tR-\"+ uuid + \" removed from canvas : \" + (old == null ? \"null\" : old.getUuid()));\n" + 
				"		return (R) remove;\n" + 
				"	}\n" + 
				"\n" + 
				"	public <R extends BaseCanvasRelation> R getRelation(String uuid) {\n" + 
				"		return (R) relationMap.get(uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onCanvasRightClick(JPopupMenu pop, PInputEvent event) {\n" + 
				"\n" + 
				"		~rightClickStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"		~rightClickActions:{it|pop.add(new ~it.name~(event));};separator=\"\\n\"~\n" + 
				"		pop.addSeparator();\n" + 
				"		pop.add(new SelectAllNodes(event));\n" + 
				"		pop.add(new UnselectAllNodes(event));\n" + 
				"		pop.add(new RetainSelectedNodes(event));\n" + 
				"		pop.add(new CloseSelectedNodes(event));\n" + 
				"		pop.add(new CloseAllAction(event));\n" + 
				"		pop.addSeparator();\n" + 
				"		pop.add(new LayoutVerticallyAction(event, getCurrentMousePosition(), 20));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onCanvasLeftClick(PInputEvent event) {\n" + 
				"		SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(BaseCanvasNode::unselect));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onCanvasKeyPressed(PInputEvent event) {\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"~keyPressActions:{it|\n" + 
				"			case VK_~it.key~:\n" + 
				"				new ~it.name~(this, event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"			case VK_A:\n" + 
				"				new SelectAllNodes(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_ESCAPE:\n" + 
				"				new UnselectAllNodes(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_R:\n" + 
				"				new RetainSelectedNodes(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_C:\n" + 
				"				if (event.isControlDown())\n" + 
				"					new CloseAllAction(event).actionPerformed(null);\n" + 
				"				else\n" + 
				"					new CloseSelectedNodes(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_1:\n" + 
				"				new LayoutVerticallyAction(event, getCurrentMousePosition(), 20).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_SPACE:\n" + 
				"				new PopupAction(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class CanvasInputEventsHandler extends PBasicInputEventHandler {\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseEntered(PInputEvent event) {\n" + 
				"			if (!this.equals(event.getInputManager().getKeyboardFocus())) {\n" + 
				"				event.getInputManager().setKeyboardFocus(this);\n" + 
				"				requestFocusInWindow();\n" + 
				"			}\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseExited(PInputEvent event) {\n" + 
				"			event.getInputManager().setKeyboardFocus(null);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseClicked(PInputEvent event) {\n" + 
				"			removeInputEventListener(selectEventHandler);\n" + 
				"			if (!this.equals(event.getInputManager().getKeyboardFocus())) event.getInputManager().setKeyboardFocus(this);\n" + 
				"			if (event.isRightMouseButton()) {\n" + 
				"				SwingUtilities.invokeLater(() -> {\n" + 
				"					final JPopupMenu pop = new JPopupMenu();\n" + 
				"					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));\n" + 
				"					onCanvasRightClick(pop, event);\n" + 
				"					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));\n" + 
				"					pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"				});\n" + 
				"			} else if (event.isLeftMouseButton()) SwingUtilities.invokeLater(() -> onCanvasLeftClick(event));\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void keyPressed(PInputEvent event) {\n" + 
				"			if (event.isControlDown()) {\n" + 
				"				removeInputEventListener(selectEventHandler);\n" + 
				"				addInputEventListener(selectEventHandler.init(event));\n" + 
				"			} else {\n" + 
				"				onCanvasKeyPressed(event);\n" + 
				"			}\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void keyReleased(PInputEvent event) {\n" + 
				"			if (event.getKeyCode() == KeyEvent.VK_CONTROL) removeInputEventListener(selectEventHandler.end());\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseMoved(PInputEvent event) {\n" + 
				"			if (!event.isControlDown()) removeInputEventListener(selectEventHandler.end());\n" + 
				"			invalidate();\n" + 
				"			repaint();\n" + 
				"		}\n" + 
				"	}  \n" + 
				"\n" + 
				"	private final class SelectEventsHandler extends PBasicInputEventHandler {\n" + 
				"\n" + 
				"		private PPath selectionRectangle;\n" + 
				"		private boolean isDragging = true;\n" + 
				"		private double startX;\n" + 
				"		private double startY;\n" + 
				"\n" + 
				"		PInputEventListener init(PInputEvent event) {\n" + 
				"			isDragging = event.isControlDown();\n" + 
				"			if (selectionRectangle != null) nodeLayer.removeChild(selectionRectangle);\n" + 
				"			startX = getCamera().localToView(event.getCanvasPosition()).getX();\n" + 
				"			startY = getCamera().localToView(event.getCanvasPosition()).getY();\n" + 
				"			selectionRectangle = PPath.createRectangle(startX, startY, 1, 1);\n" + 
				"			selectionRectangle.setTransparency(.5f);\n" + 
				"			nodeLayer.addChild(selectionRectangle);\n" + 
				"			return this;\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseMoved(PInputEvent event) {\n" + 
				"			if (isDragging) {\n" + 
				"				final double eventX = getCamera().localToView(event.getCanvasPosition()).getX();\n" + 
				"				final double eventY = getCamera().localToView(event.getCanvasPosition()).getY();\n" + 
				"				final boolean left = eventX < startX;\n" + 
				"				selectionRectangle.setX(left ? eventX : startX);\n" + 
				"				selectionRectangle.setWidth(left ? (startX - eventX) : (eventX - startX));\n" + 
				"				final boolean top = eventY < startY;\n" + 
				"				selectionRectangle.setY(top ? eventY : startY);\n" + 
				"				selectionRectangle.setHeight(top ? (startY - eventY) : (eventY - startY));\n" + 
				"				final PBounds fullBounds = selectionRectangle.getFullBounds();\n" + 
				"				SwingUtilities.invokeLater(() -> getAllNodes()\n" + 
				"					.filter(node -> !node.isSelected())\n" + 
				"					.forEach(node -> {\n" + 
				"						if (fullBounds.contains(node.getFullBounds())) node.select();\n" + 
				"					}));\n" + 
				"			}\n" + 
				"		}\n" + 
				"\n" + 
				"		public PInputEventListener end() {\n" + 
				"			isDragging = false;\n" + 
				"			if (selectionRectangle != null) nodeLayer.removeChild(selectionRectangle);\n" + 
				"			return this;\n" + 
				"		}\n" + 
				"	}  \n" + 
				"\n" + 
				"	private static class CanvasZoomHandler extends PBasicInputEventHandler {\n" + 
				"\n" + 
				"		final private static double maxZoomScale = 2.0d;\n" + 
				"		final private static double minZomScale = 0.025d;\n" + 
				"		private double scaleFactor = 0.05d;\n" + 
				"\n" + 
				"		CanvasZoomHandler() {\n" + 
				"			super();\n" + 
				"			final PInputEventFilter eventFilter = new PInputEventFilter();\n" + 
				"			eventFilter.rejectAllEventTypes();\n" + 
				"			eventFilter.setAcceptsMouseWheelRotated(true);\n" + 
				"			setEventFilter(eventFilter);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void mouseWheelRotated(final PInputEvent event) {\n" + 
				"			final PCamera camera = event.getCamera();\n" + 
				"			if ((camera.getViewScale() < minZomScale && event.getWheelRotation() < 0) || (camera.getViewScale() > maxZoomScale && event.getWheelRotation() > 0)) return;\n" + 
				"			final double scale = 1.0d + event.getWheelRotation() * scaleFactor;\n" + 
				"			final java.awt.geom.Point2D viewAboutPoint = event.getPosition();\n" + 
				"			camera.scaleViewAboutPoint(scale, viewAboutPoint.getX(), viewAboutPoint.getY());\n" + 
				"		}\n" + 
				"	}  \n" + 
				"\n" + 
				"	abstract class CanvasAction extends AbstractAction {\n" + 
				"\n" + 
				"		final PInputEvent event;\n" + 
				"\n" + 
				"		CanvasAction(String name, PInputEvent event) {\n" + 
				"			super(name);\n" + 
				"			this.event = event;\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void actionPerformed(ActionEvent e) {\n" + 
				"			actionPerformed(event, e);\n" + 
				"		}\n" + 
				"\n" + 
				"		abstract void actionPerformed(PInputEvent event, ActionEvent e);\n" + 
				"	}\n" + 
				"\n" + 
				"	~BaseCanvasNode()~\n" + 
				"\n" + 
				"	~BaseCanvasRelation()~\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	final class PopupAction extends CanvasAction {\n" + 
				"\n" + 
				"		PopupAction(PInputEvent event) {\n" + 
				"			super(\"Popup\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> { \n" + 
				"				final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();\n" + 
				"				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));\n" + 
				"				onCanvasRightClick(pop, event);\n" + 
				"				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));\n" + 
				"				pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"			});\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	final class SelectAllNodes extends CanvasAction {\n" + 
				"\n" + 
				"		SelectAllNodes(PInputEvent event) {\n" + 
				"			super(\"Select all nodes\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> getAllNodes().forEach(BaseCanvasNode::select));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	final class RetainSelectedNodes extends CanvasAction {\n" + 
				"\n" + 
				"		RetainSelectedNodes(PInputEvent event) {\n" + 
				"			super(\"Retain selected nodes\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> getUnselectedNodes().forEach(BaseCanvasNode::close));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	final class UnselectAllNodes extends CanvasAction {\n" + 
				"\n" + 
				"		UnselectAllNodes(PInputEvent event) {\n" + 
				"			super(\"Unselect all nodes\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(BaseCanvasNode::unselect));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	final class CloseSelectedNodes extends CanvasAction {\n" + 
				"\n" + 
				"		CloseSelectedNodes(PInputEvent event) {\n" + 
				"			super(\"Close selected nodes\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(BaseCanvasNode::close));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	final class CloseAllAction extends CanvasAction {\n" + 
				"\n" + 
				"		CloseAllAction(PInputEvent event) {\n" + 
				"			super(\"Close all\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			getAllRelations().forEach(relation -> removeRelation(relation.getUuid()));\n" + 
				"			getAllNodes().forEach(node -> removeNode(node.getUuid()));\n" + 
				"			relationLayer.removeAllChildren();\n" + 
				"			SwingUtilities.invokeLater(() -> {\n" + 
				"				invalidate();\n" + 
				"				repaint();\n" + 
				"			});\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	final class LayoutVerticallyAction extends CanvasAction {\n" + 
				"\n" + 
				"		private java.awt.Point position;\n" + 
				"		private int heightPadding;\n" + 
				"\n" + 
				"		LayoutVerticallyAction(PInputEvent event, java.awt.Point position,int heightPadding) {\n" + 
				"			super(\"Layout selected nodes vertically\", event);\n" + 
				"			this.position = position;\n" + 
				"			this.heightPadding = heightPadding;\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(new Consumer<BaseCanvasNode>() {\n" + 
				"\n" + 
				"				double x = position.getX();\n" + 
				"				double y = position.getY();\n" + 
				"				double height = -1d;\n" + 
				"\n" + 
				"				@Override\n" + 
				"				public void accept(BaseCanvasNode abstractNode) {\n" + 
				"					if (height == -1) {\n" + 
				"						abstractNode.setOffset(x, y);\n" + 
				"						height = abstractNode.getHeight();\n" + 
				"					} else {\n" + 
				"						y += height + heightPadding;\n" + 
				"						abstractNode.setOffset(x, y);\n" + 
				"						height = abstractNode.getHeight();\n" + 
				"					}\n" + 
				"				}\n" + 
				"			}));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	~canvasNodes:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~canvasRelations:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  