package nextgen.templates.javaeasyflows;

public class Work {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _inputs = new java.util.ArrayList<>();

	Work(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Work");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _inputs) st.addAggr("inputs.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public Work setPackageName(Object value) {
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

	public Work removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Work setName(Object value) {
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

	public Work removeName() {
		this._name = null;
		return this;
	} 

	public Work addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public Work setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Work setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public Work removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public Work removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public Work addInputs(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._inputs.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getInputs() {
		return this._inputs;
	}

	public Work addInputs(Work_Inputs value) {
		return addInputs(value._type, value._name);
	}

	public java.util.stream.Stream<Work_Inputs> streamInputs() {
		return this._inputs.stream().map(Work_Inputs::new);
	}

	public java.util.List<Object> getInputs_Type() {
		return streamInputs().map(Work_Inputs::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getInputs_Name() {
		return streamInputs().map(Work_Inputs::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Work_Inputs {

		Object _type;
		Object _name;

		public Work_Inputs(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private Work_Inputs(java.util.Map<String, Object> map) {
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
		Work that = (Work) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Work(packageName,name,inputs,statements) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.jeasy.flows.work.*;\n" + 
				"\n" + 
				"public class ~name~ implements Work {\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String getName() {\n" + 
				"		return \"~name~\";\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public WorkReport call(WorkContext context) {\n" + 
				"		~inputs:{it|final ~it.type~ ~it.name~ = (~it.type~) context.get(\"~it.name~\");};separator=\"\\n\"~\n" + 
				"\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"		\n" + 
				"		return new DefaultWorkReport(WorkStatus.COMPLETED, context);\n" + 
				"	}\n" + 
				"} >>";
}  