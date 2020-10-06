package nextgen.templates.javaeasyflows;

public class ConditionalFlow {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _execute;
	private Object _then;
	private Object _otherwise;

	ConditionalFlow(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ConditionalFlow");
		st.add("name", _name);
		st.add("execute", _execute);
		st.add("then", _then);
		st.add("otherwise", _otherwise);
		return st.render().trim();
	}

	public ConditionalFlow setName(Object value) {
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

	public ConditionalFlow removeName() {
		this._name = null;
		return this;
	} 

	public ConditionalFlow setExecute(Object value) {
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

	public ConditionalFlow removeExecute() {
		this._execute = null;
		return this;
	} 

	public ConditionalFlow setThen(Object value) {
		this._then = value;
		return this;
	}

	public Object getThen() {
		return this._then;
	}

	public Object getThen(Object defaultValue) {
		return this._then == null ? defaultValue : this._then;
	}

	public boolean hasThen() {
		return this._then != null;
	}

	public ConditionalFlow removeThen() {
		this._then = null;
		return this;
	} 

	public ConditionalFlow setOtherwise(Object value) {
		this._otherwise = value;
		return this;
	}

	public Object getOtherwise() {
		return this._otherwise;
	}

	public Object getOtherwise(Object defaultValue) {
		return this._otherwise == null ? defaultValue : this._otherwise;
	}

	public boolean hasOtherwise() {
		return this._otherwise != null;
	}

	public ConditionalFlow removeOtherwise() {
		this._otherwise = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConditionalFlow that = (ConditionalFlow) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ConditionalFlow(name,execute,then,otherwise) ::= <<ConditionalFlow.Builder.aNewConditionalFlow()\n" + 
				"		.named(\"~name~\")\n" + 
				"		.execute(~execute~)\n" + 
				"		.when(WorkReportPredicate.COMPLETED)\n" + 
				"		.then(~then~)\n" + 
				"		.otherwise(~otherwise~)\n" + 
				"		.build() >>";
}  