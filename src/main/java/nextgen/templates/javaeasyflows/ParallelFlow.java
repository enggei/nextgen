package nextgen.templates.javaeasyflows;

public class ParallelFlow {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _execute = new java.util.ArrayList<>();

	ParallelFlow(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ParallelFlow");
		st.add("name", _name);
		for (Object o : _execute) st.add("execute", o);
		return st.render().trim();
	}

	public ParallelFlow setName(Object value) {
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

	public ParallelFlow removeName() {
		this._name = null;
		return this;
	} 

	public ParallelFlow addExecute(Object value) {
		this._execute.add(value);
		return this;
	}

	public ParallelFlow setExecute(Object[] value) {
		this._execute.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ParallelFlow setExecute(java.util.Collection<Object> values) {
		this._execute.addAll(values);
		return this;
	}

	public ParallelFlow removeExecute(Object value) {
		this._execute.remove(value);
		return this;
	}

	public ParallelFlow removeExecute(int index) {
		this._execute.remove(index);
		return this;
	}

	public java.util.List<Object> getExecute() {
		return this._execute;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParallelFlow that = (ParallelFlow) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ParallelFlow(name,execute) ::= <<ParallelFlow.Builder.aNewParallelFlow(executorService)\n" + 
				"		.named(\"~name~\")\n" + 
				"		.execute(~execute:{it|~it~};separator=\", \"~)\n" + 
				"		.build() >>";
}  