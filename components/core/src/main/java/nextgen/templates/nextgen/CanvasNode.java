package nextgen.templates.nextgen;

public class CanvasNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _modelType;
	private java.util.List<Object> _onNodeRightClick = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	CanvasNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasNode");
		st.add("modelType", _modelType);
		for (Object o : _onNodeRightClick) st.add("onNodeRightClick", o);
		for (Object o : _actions) st.add("actions", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public CanvasNode setModelType(Object value) {
		this._modelType = value;
		return this;
	}

	public Object getModelType() {
		return this._modelType;
	}

	public Object getModelType(Object defaultValue) {
		return this._modelType == null ? defaultValue : this._modelType;
	}

	public boolean hasModelType() {
		return this._modelType != null;
	}

	public CanvasNode removeModelType() {
		this._modelType = null;
		return this;
	} 

	public CanvasNode addOnNodeRightClick(Object value) {
		this._onNodeRightClick.add(value);
		return this;
	}

	public CanvasNode setOnNodeRightClick(Object[] value) {
		this._onNodeRightClick.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setOnNodeRightClick(java.util.Collection<Object> values) {
		this._onNodeRightClick.addAll(values);
		return this;
	}

	public CanvasNode removeOnNodeRightClick(Object value) {
		this._onNodeRightClick.remove(value);
		return this;
	}

	public CanvasNode removeOnNodeRightClick(int index) {
		this._onNodeRightClick.remove(index);
		return this;
	}

	public java.util.List<Object> getOnNodeRightClick() {
		return this._onNodeRightClick;
	} 

	public CanvasNode addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public CanvasNode setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public CanvasNode removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public CanvasNode removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public CanvasNode addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public CanvasNode addFields(CanvasNode_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<CanvasNode_Fields> streamFields() {
		return this._fields.stream().map(CanvasNode_Fields::new);
	}

	public static final class CanvasNode_Fields {

		Object _type;
		Object _name;

		public CanvasNode_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private CanvasNode_Fields(java.util.Map<String, Object> map) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CanvasNode that = (CanvasNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasNode(modelType,fields,onNodeRightClick,actions) ::= <<final class ~modelType~Node extends BaseCanvasNode<~modelType~> {\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ProjectNode(~modelType~ model, UUID uuid, String label~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(model, uuid, label);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void addedToCanvas() {\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void newNodeAdded(BaseCanvasNode<?> node) {\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~onNodeRightClick:{it|~it~};separator=\"\\n\"~\n" + 
				"		super.onNodeRightClick(event, pop);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeKeyPressed(PInputEvent event) {\n" + 
				"		super.onNodeKeyPressed(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeLeftClick(PInputEvent event) {\n" + 
				"		super.onNodeLeftClick(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  