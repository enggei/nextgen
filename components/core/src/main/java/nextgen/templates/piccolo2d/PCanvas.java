package nextgen.templates.piccolo2d;

public class PCanvas {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private String _nodeName;
	private String _relationName;
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _canvasActionmethods = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onRightClick = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onKeyPressed = new java.util.ArrayList<>();

	PCanvas(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PCanvas");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("nodeName", _nodeName);
		st.add("relationName", _relationName);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _canvasActionmethods) st.add("canvasActionmethods", o);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _onRightClick) st.addAggr("onRightClick.{name}", map.get("name"));
		for (java.util.Map<String, Object> map : _onKeyPressed) st.addAggr("onKeyPressed.{key,name}", map.get("key"), map.get("name"));
		return st.render().trim();
	}

	public PCanvas setPackageName(String value) {
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

	public PCanvas removePackageName() {
		this._packageName = null;
		return this;
	} 

	public PCanvas setName(String value) {
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

	public PCanvas removeName() {
		this._name = null;
		return this;
	} 

	public PCanvas setNodeName(String value) {
		this._nodeName = value;
		return this;
	}

	public String getNodeName() {
		return this._nodeName;
	}

	public String getNodeName(String defaultValue) {
		return this._nodeName == null ? defaultValue : this._nodeName;
	}

	public boolean hasNodeName() {
		return this._nodeName != null;
	}

	public PCanvas removeNodeName() {
		this._nodeName = null;
		return this;
	} 

	public PCanvas setRelationName(String value) {
		this._relationName = value;
		return this;
	}

	public String getRelationName() {
		return this._relationName;
	}

	public String getRelationName(String defaultValue) {
		return this._relationName == null ? defaultValue : this._relationName;
	}

	public boolean hasRelationName() {
		return this._relationName != null;
	}

	public PCanvas removeRelationName() {
		this._relationName = null;
		return this;
	} 

	public PCanvas addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public PCanvas setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PCanvas setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public PCanvas removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public PCanvas removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public PCanvas addCanvasActionmethods(Object value) {
		this._canvasActionmethods.add(value);
		return this;
	}

	public PCanvas setCanvasActionmethods(Object[] value) {
		this._canvasActionmethods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PCanvas setCanvasActionmethods(java.util.Collection<Object> values) {
		this._canvasActionmethods.addAll(values);
		return this;
	}

	public PCanvas removeCanvasActionmethods(Object value) {
		this._canvasActionmethods.remove(value);
		return this;
	}

	public PCanvas removeCanvasActionmethods(int index) {
		this._canvasActionmethods.remove(index);
		return this;
	}

	public java.util.List<Object> getCanvasActionmethods() {
		return this._canvasActionmethods;
	} 

	public PCanvas addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public PCanvas setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PCanvas setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public PCanvas removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public PCanvas removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public PCanvas addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public PCanvas setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PCanvas setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public PCanvas removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public PCanvas removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public PCanvas addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public PCanvas addFields(PCanvas_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<PCanvas_Fields> streamFields() {
		return this._fields.stream().map(PCanvas_Fields::new);
	}

	public static final class PCanvas_Fields {

		Object _type;
		Object _name;

		public PCanvas_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private PCanvas_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	} 

	public PCanvas addOnRightClick(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._onRightClick.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnRightClick() {
		return this._onRightClick;
	}

	public PCanvas addOnRightClick(PCanvas_OnRightClick value) {
		return addOnRightClick(value._name);
	}

	public java.util.stream.Stream<PCanvas_OnRightClick> streamOnRightClick() {
		return this._onRightClick.stream().map(PCanvas_OnRightClick::new);
	}

	public static final class PCanvas_OnRightClick {

		Object _name;

		public PCanvas_OnRightClick(Object _name) {
			this._name = _name;
		}

		private PCanvas_OnRightClick(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	public PCanvas addOnKeyPressed(Object _key, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("name", _name);
		this._onKeyPressed.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnKeyPressed() {
		return this._onKeyPressed;
	}

	public PCanvas addOnKeyPressed(PCanvas_OnKeyPressed value) {
		return addOnKeyPressed(value._key, value._name);
	}

	public java.util.stream.Stream<PCanvas_OnKeyPressed> streamOnKeyPressed() {
		return this._onKeyPressed.stream().map(PCanvas_OnKeyPressed::new);
	}

	public static final class PCanvas_OnKeyPressed {

		Object _key;
		Object _name;

		public PCanvas_OnKeyPressed(Object _key, Object _name) {
			this._key = _key;
			this._name = _name;
		}

		private PCanvas_OnKeyPressed(java.util.Map<String, Object> map) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PCanvas that = (PCanvas) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PCanvas(packageName,name,nodeName,relationName,fields,constructorStatements,onRightClick,onKeyPressed,canvasActionmethods,actions,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.piccolo2d.PCamera;\n" + 
				"import org.piccolo2d.PCanvas;\n" + 
				"import org.piccolo2d.PLayer;\n" + 
				"import org.piccolo2d.PNode;\n" + 
				"import org.piccolo2d.event.PBasicInputEventHandler;\n" + 
				"import org.piccolo2d.event.PInputEvent;\n" + 
				"import org.piccolo2d.event.PInputEventFilter;\n" + 
				"import org.piccolo2d.event.PInputEventListener;\n" + 
				"import org.piccolo2d.nodes.PPath;\n" + 
				"import org.piccolo2d.util.PBounds;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.awt.event.KeyEvent;\n" + 
				"import java.awt.geom.Point2D;\n" + 
				"import java.util.Map;\n" + 
				"import java.util.UUID;\n" + 
				"import java.util.concurrent.ConcurrentHashMap;\n" + 
				"import java.util.function.Consumer;\n" + 
				"import java.util.function.Predicate;\n" + 
				"import java.util.stream.Stream;\n" + 
				"\n" + 
				"import static java.awt.event.KeyEvent.*;\n" + 
				"\n" + 
				"public class ~name~ extends PCanvas implements PInputEventListener {\n" + 
				"\n" + 
				"	static boolean debug = true;\n" + 
				"\n" + 
				"	private final PLayer nodeLayer;\n" + 
				"	private final PLayer relationLayer = new PLayer();\n" + 
				"	\n" + 
				"	final Map<UUID, ~nodeName~> nodeMap = new ConcurrentHashMap<>();\n" + 
				"	final Map<UUID, ~relationName~> relationMap = new ConcurrentHashMap<>();\n" + 
				"	\n" + 
				"	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();\n" + 
				"	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();\n" + 
				"\n" + 
				"	~fields:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\",\"~) {\n" + 
				"		this(~fields:{it|~it.name~};separator=\", \"~~if(fields)~, ~endif~Color.WHITE, new Dimension(1024, 1024));\n" + 
				"	}\n" + 
				"	\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~~if(fields)~, ~endif~Color background, Dimension preferredSize) {\n" + 
				"		super();\n" + 
				"		setBackground(background);\n" + 
				"		setPreferredSize(preferredSize);\n" + 
				"		nodeLayer = getLayer();\n" + 
				"		getCamera().addLayer(0, relationLayer);\n" + 
				"\n" + 
				"		removeInputEventListener(getZoomEventHandler());\n" + 
				"		addInputEventListener(new CanvasZoomHandler());\n" + 
				"		addInputEventListener(canvasInputEventsHandler);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		//org.greenrobot.eventbus.EventBus.getDefault().register(this);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void processEvent(PInputEvent pInputEvent, int i) {\n" + 
				"		canvasInputEventsHandler.processEvent(pInputEvent, i);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Point getCenterPosition() {\n" + 
				"		final Point2D center2D = getCamera().getViewBounds().getCenter2D();\n" + 
				"		return new Point((int) center2D.getX(), (int) center2D.getY());\n" + 
				"	}\n" + 
				"\n" + 
				"	public Point getCurrentMousePosition() {\n" + 
				"		final Point mousePosition = getMousePosition();\n" + 
				"		if (mousePosition == null) return getCenterPosition();\n" + 
				"		final Point2D localToView = getCamera().localToView(mousePosition);\n" + 
				"		return new Point((int) localToView.getX(), (int) localToView.getY());\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public <N extends ~nodeName~> Stream<N> getAllNodes() {\n" + 
				"		return nodeLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof ~nodeName~);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends ~nodeName~> Stream<N> getSelectedNodes() {\n" + 
				"		return (Stream<N>) getAllNodes().filter(~nodeName~::isSelected);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends STNode> Stream<N> getUnselectedNodes() {\n" + 
				"		return (Stream<N>) getAllNodes().filter(stNode -> !stNode.isSelected());\n" + 
				"	}\n" + 
				"	\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public <R extends ~relationName~> Stream<R> getAllRelations() {\n" + 
				"		return relationLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof ~relationName~);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <R extends ~relationName~> Stream<R> getSelectedRelations() {\n" + 
				"		return (Stream<R>) getAllRelations().filter(~relationName~::isSelected);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends ~nodeName~> N addNode(String uuid, java.util.function.Supplier<N> supplier) {\n" + 
				"		return addNode(java.util.UUID.fromString(uuid), supplier);\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends ~nodeName~> N addNode(N node) {\n" + 
				"		return addNode(node.getUuid(), () -> node);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public <N extends ~nodeName~> N addNode(java.util.UUID uuid, java.util.function.Supplier<N> supplier) {\n" + 
				"		\n" + 
				"		final N existing = getNode(uuid);\n" + 
				"		if (existing != null) {\n" + 
				"			if (debug) System.out.println(\"N-\" + uuid + \" exists in canvas\");\n" + 
				"			existing.refresh();\n" + 
				"			existing.select();\n" + 
				"			return existing;\n" + 
				"		}\n" + 
				"		if (debug) System.out.println(\"N-\" + uuid + \" added to canvas\");\n" + 
				"		\n" + 
				"		final N node= supplier.get();\n" + 
				"		node.select();\n" + 
				"		nodeMap.put(node.getUuid(), node);\n" + 
				"		nodeLayer.addChild(node);\n" + 
				"\n" + 
				"		node.addedToCanvas();\n" + 
				"\n" + 
				"		//org.greenrobot.eventbus.EventBus.getDefault().post(new NodeAdded(this, node));\n" + 
				"\n" + 
				"		getAllNodes()\n" + 
				"				.filter(stNode -> !stNode.getUuid().equals(node.getUuid()))\n" + 
				"				.forEach(stNode -> stNode.newNodeAdded(node));\n" + 
				"		\n" + 
				"		return node;\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends ~nodeName~> N getNode(String uuid) {\n" + 
				"		return getNode(java.util.UUID.fromString(uuid));\n" + 
				"	}\n" + 
				"\n" + 
				"	public <N extends ~nodeName~> N getNode(UUID uuid) {\n" + 
				"		return (N) nodeMap.get(uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	<N extends ~nodeName~> N removeNode(UUID uuid) {\n" + 
				"		final ~nodeName~ remove = nodeMap.remove(uuid);\n" + 
				"		final N old = (N) nodeLayer.removeChild(remove);\n" + 
				"		if (debug) System.out.println(\"\\tN-\"+ uuid + \" removed from canvas : \" + (old == null ? \"null\" : old.getUuid()));\n" + 
				"		return (N) remove;\n" + 
				"	}\n" + 
				"\n" + 
				"	public <R extends ~relationName~> R addRelation(R relation) {\n" + 
				"		return addRelation(relation.getUuid(), () -> relation);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public <R extends ~relationName~> R addRelation(String uuid, java.util.function.Supplier<R> supplier) {\n" + 
				"		return addRelation(java.util.UUID.fromString(uuid), supplier);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public <R extends ~relationName~> R addRelation(java.util.UUID uuid, java.util.function.Supplier<R> supplier) {\n" + 
				"\n" + 
				"		final R existing = getRelation(uuid);\n" + 
				"		if (existing != null) {\n" + 
				"			if (debug) System.out.println(\"R-\"+ uuid + \" exists in canvas\");\n" + 
				"			return existing;\n" + 
				"		}\n" + 
				"		if (debug) System.out.println(\"R-\"+ uuid + \" added to canvas\");\n" + 
				"		\n" + 
				"		final R relation = supplier.get();\n" + 
				"		relationMap.put(relation.getUuid(), relation);\n" + 
				"		relationLayer.addChild(relation);\n" + 
				"		return relation;\n" + 
				"	}\n" + 
				"		\n" + 
				"	<R extends ~relationName~> R removeRelation(UUID uuid) {\n" + 
				"		final ~relationName~ remove = relationMap.remove(uuid);\n" + 
				"		final R old = (R) relationLayer.removeChild(remove);\n" + 
				"		if (debug) System.out.println(\"\\tR-\"+ uuid + \" removed from canvas : \" + (old == null ? \"null\" : old.getUuid()));\n" + 
				"		return (R) remove;\n" + 
				"	}\n" + 
				"\n" + 
				"	public <R extends ~relationName~> R getRelation(UUID uuid) {\n" + 
				"		return (R) relationMap.get(uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onCanvasRightClick(JPopupMenu pop, PInputEvent event) {\n" + 
				"		~onRightClick:{it|pop.add(new ~it.name~(this, event));};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onCanvasLeftClick(PInputEvent event) {\n" + 
				"		SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(~nodeName~::unselect));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onCanvasKeyPressed(PInputEvent event) {\n" + 
				"~if(onKeyPressed)~\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"	~onKeyPressed:{it|\n" + 
				"		case VK_~it.key~:\n" + 
				"			new ~it.name~(this, event).actionPerformed(null);\n" + 
				"			break;\n" + 
				"		};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"~endif~\n" + 
				"	}\n" + 
				"\n" + 
				"	~CanvasInputEventsHandler(canvasName=name)~\n" + 
				"	\n" + 
				"	~SelectEventsHandler(nodeName=nodeName)~\n" + 
				"	\n" + 
				"	~CanvasZoomHandler()~\n" + 
				"\n" + 
				"	static abstract class CanvasAction extends AbstractAction {\n" + 
				"\n" + 
				"		final ~name~ canvas;\n" + 
				"		final PInputEvent event;\n" + 
				"	\n" + 
				"		CanvasAction(String name, ~name~ canvas, PInputEvent event) {\n" + 
				"			super(name);\n" + 
				"			this.canvas = canvas;\n" + 
				"			this.event = event;\n" + 
				"		}\n" + 
				"	\n" + 
				"		@Override\n" + 
				"		public void actionPerformed(ActionEvent e) {\n" + 
				"			actionPerformed(canvas, event, e);\n" + 
				"		}\n" + 
				"	\n" + 
				"		abstract void actionPerformed(~name~ canvas, PInputEvent event, ActionEvent e);\n" + 
				"\n" + 
				"		~canvasActionmethods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"	~CanvasEvents(canvasName=name,nodeName=nodeName)~\n" + 
				"} >>";
}  