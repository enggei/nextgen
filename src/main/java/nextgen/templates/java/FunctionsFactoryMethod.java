package nextgen.templates.java;

public class FunctionsFactoryMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _type;
	private java.util.List<java.util.Map<String, Object>> _arguments = new java.util.ArrayList<>();

	FunctionsFactoryMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionsFactoryMethod");
		st.add("name", _name);
		st.add("type", _type);
		for (java.util.Map<String, Object> map : _arguments) st.addAggr("arguments.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public FunctionsFactoryMethod setName(String value) {
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

	public FunctionsFactoryMethod removeName() {
		this._name = null;
		return this;
	} 

	public FunctionsFactoryMethod setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public FunctionsFactoryMethod removeType() {
		this._type = null;
		return this;
	} 


	public FunctionsFactoryMethod addArguments(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._arguments.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getArguments() {
		return this._arguments;
	}

	public FunctionsFactoryMethod addArguments(FunctionsFactoryMethod_Arguments value) {
		return addArguments(value._type, value._name);
	}

	public java.util.stream.Stream<FunctionsFactoryMethod_Arguments> streamArguments() {
		return this._arguments.stream().map(FunctionsFactoryMethod_Arguments::new);
	}

	public java.util.List<Object> getArguments_Type() {
		return streamArguments().map(FunctionsFactoryMethod_Arguments::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getArguments_Name() {
		return streamArguments().map(FunctionsFactoryMethod_Arguments::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class FunctionsFactoryMethod_Arguments {

		Object _type;
		Object _name;

		public FunctionsFactoryMethod_Arguments(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private FunctionsFactoryMethod_Arguments(java.util.Map<String, Object> map) {
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
		FunctionsFactoryMethod that = (FunctionsFactoryMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionsFactoryMethod(arguments,name,type) ::= <<public static ~type~ ~name~(~arguments:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"	return new ~type~(~arguments:{it|~it.name~};separator=\", \"~);	\n" + 
				"} >>";
}  