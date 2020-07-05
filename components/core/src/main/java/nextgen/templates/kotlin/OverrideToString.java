package nextgen.templates.kotlin;

public class OverrideToString {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _className;
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	OverrideToString(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("OverrideToString");
		st.add("className", _className);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name,output}", map.get("name"), map.get("output"));
		return st.render().trim();
	}

	public OverrideToString setClassName(String value) {
		this._className = value;
		return this;
	}

	public String getClassName() {
		return this._className;
	}

	public String getClassName(String defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public OverrideToString removeClassName() {
		this._className = null;
		return this;
	} 


	public OverrideToString addFields(String _name, KotlinStringTemplate _output) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("output", _output);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public OverrideToString addFields(OverrideToString_Fields value) {
		return addFields(value._name, value._output);
	}

	public java.util.stream.Stream<OverrideToString_Fields> streamFields() {
		return this._fields.stream().map(OverrideToString_Fields::new);
	}

	public static final class OverrideToString_Fields {

		String _name;
		KotlinStringTemplate _output;

		public OverrideToString_Fields(String _name, KotlinStringTemplate _output) {
			this._name = _name;
			this._output = _output;
		}

		private OverrideToString_Fields(java.util.Map<String, Object> map) {
			this._name = (String) map.get("name");
			this._output = (KotlinStringTemplate) map.get("output");
		}

		public String getName() {
			return this._name;
		}

		public KotlinStringTemplate getOutput() {
			return this._output;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OverrideToString that = (OverrideToString) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "OverrideToString(className,fields) ::= <<override fun toString(): String {\n" + 
				"	return \"~className~(~fields:{it|~it.name~=~it.output~};separator=\", \"~)\"\n" + 
				"} >>";
}  