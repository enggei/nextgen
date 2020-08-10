package nextgen.templates.nextgen;

public class CanvasRelation {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _onRelationRightClick = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	CanvasRelation(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasRelation");
		st.add("name", _name);
		for (Object o : _onRelationRightClick) st.add("onRelationRightClick", o);
		for (Object o : _actions) st.add("actions", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public CanvasRelation setName(Object value) {
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

	public CanvasRelation removeName() {
		this._name = null;
		return this;
	} 

	public CanvasRelation addOnRelationRightClick(Object value) {
		this._onRelationRightClick.add(value);
		return this;
	}

	public CanvasRelation setOnRelationRightClick(Object[] value) {
		this._onRelationRightClick.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasRelation setOnRelationRightClick(java.util.Collection<Object> values) {
		this._onRelationRightClick.addAll(values);
		return this;
	}

	public CanvasRelation removeOnRelationRightClick(Object value) {
		this._onRelationRightClick.remove(value);
		return this;
	}

	public CanvasRelation removeOnRelationRightClick(int index) {
		this._onRelationRightClick.remove(index);
		return this;
	}

	public java.util.List<Object> getOnRelationRightClick() {
		return this._onRelationRightClick;
	} 

	public CanvasRelation addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public CanvasRelation setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasRelation setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public CanvasRelation removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public CanvasRelation removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public CanvasRelation addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public CanvasRelation addFields(CanvasRelation_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<CanvasRelation_Fields> streamFields() {
		return this._fields.stream().map(CanvasRelation_Fields::new);
	}

	public static final class CanvasRelation_Fields {

		Object _type;
		Object _name;

		public CanvasRelation_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private CanvasRelation_Fields(java.util.Map<String, Object> map) {
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
		CanvasRelation that = (CanvasRelation) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasRelation(name,fields,onRelationRightClick,actions) ::= <<final class ~name~ extends BaseCanvasRelation {\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(BaseCanvasNode src, BaseCanvasNode dst, String type, UUID uuid~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(src, dst, type, uuid);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~onRelationRightClick:{it|~it~};separator=\"\\n\"~\n" + 
				"		super.onRelationRightClick(event, pop);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onRelationKeyPressed(PInputEvent event) {\n" + 
				"		super.onRelationKeyPressed(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  