package nextgen.templates.javaswing;

public class GetTreeNodeAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _arguments = new java.util.ArrayList<>();

	GetTreeNodeAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GetTreeNodeAction");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _arguments) st.addAggr("arguments.{name}", map.get("name"));
		return st.render().trim();
	}

	public GetTreeNodeAction setName(Object value) {
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

	public GetTreeNodeAction removeName() {
		this._name = null;
		return this;
	} 


	public GetTreeNodeAction addArguments(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._arguments.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getArguments() {
		return this._arguments;
	}

	public GetTreeNodeAction addArguments(GetTreeNodeAction_Arguments value) {
		return addArguments(value._name);
	}

	public java.util.stream.Stream<GetTreeNodeAction_Arguments> streamArguments() {
		return this._arguments.stream().map(GetTreeNodeAction_Arguments::new);
	}

	public java.util.List<Object> getArguments_Name() {
		return streamArguments().map(GetTreeNodeAction_Arguments::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class GetTreeNodeAction_Arguments {

		Object _name;

		public GetTreeNodeAction_Arguments(Object _name) {
			this._name = _name;
		}

		private GetTreeNodeAction_Arguments(java.util.Map<String, Object> map) {
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
		GetTreeNodeAction that = (GetTreeNodeAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GetTreeNodeAction(name,arguments) ::= <<actions.add(new ~name~(~arguments:{it|~it.name~};separator=\", \"~)); >>";
}  