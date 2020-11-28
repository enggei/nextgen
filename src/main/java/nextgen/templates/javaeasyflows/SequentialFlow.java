package nextgen.templates.javaeasyflows;

public class SequentialFlow {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _execute;
	private java.util.List<Object> _then = new java.util.ArrayList<>();

	SequentialFlow(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SequentialFlow");
		st.add("name", _name);
		st.add("execute", _execute);
		for (Object o : _then) st.add("then", o);
		return st.render().trim();
	}

	public SequentialFlow setName(Object value) {
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

	public SequentialFlow removeName() {
		this._name = null;
		return this;
	} 

	public SequentialFlow setExecute(Object value) {
		this._execute = value;
		return this;
	}

	public Object getExecute() {
		return this._execute;
	}

	public Object getExecute(Object defaultValue) {
		return this._execute == null ? defaultValue : this._execute;
	}

	public boolean hasExecute() {
		return this._execute != null;
	}

	public SequentialFlow removeExecute() {
		this._execute = null;
		return this;
	} 

	public SequentialFlow addThen(Object value) {
		this._then.add(value);
		return this;
	}

	public SequentialFlow setThen(Object[] value) {
		this._then.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SequentialFlow setThen(java.util.Collection<Object> values) {
		this._then.addAll(values);
		return this;
	}

	public SequentialFlow removeThen(Object value) {
		this._then.remove(value);
		return this;
	}

	public SequentialFlow removeThen(int index) {
		this._then.remove(index);
		return this;
	}

	public java.util.List<Object> getThen() {
		return this._then;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SequentialFlow that = (SequentialFlow) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SequentialFlow(name,execute,then) ::= <<SequentialFlow.Builder.aNewSequentialFlow()\n" + 
				"		.named(\"~name~\")\n" + 
				"		.execute(~execute~)~then:{it|\n" + 
				"		.then(~it~)}~\n" + 
				"		.build() >>";
}  