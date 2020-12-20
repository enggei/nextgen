package nextgen.templates.brain;

public class Process {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _O;
	private Object _I;
	private Object _packageName;

	Process(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Process");
		st.add("name", _name);
		st.add("O", _O);
		st.add("I", _I);
		st.add("packageName", _packageName);
		return st.render().trim();
	}

	public Process setName(String value) {
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

	public Process removeName() {
		this._name = null;
		return this;
	} 

	public Process setO(Object value) {
		this._O = value;
		return this;
	}

	public Object getO() {
		return this._O;
	}

	public Object getO(Object defaultValue) {
		return this._O == null ? defaultValue : this._O;
	}

	public boolean hasO() {
		return this._O != null;
	}

	public Process removeO() {
		this._O = null;
		return this;
	} 

	public Process setI(Object value) {
		this._I = value;
		return this;
	}

	public Object getI() {
		return this._I;
	}

	public Object getI(Object defaultValue) {
		return this._I == null ? defaultValue : this._I;
	}

	public boolean hasI() {
		return this._I != null;
	}

	public Process removeI() {
		this._I = null;
		return this;
	} 

	public Process setPackageName(Object value) {
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

	public Process removePackageName() {
		this._packageName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Process that = (Process) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Process(name,O,I,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public interface ~name~ extends java.util.function.Function<~I~,~O~> {\n" + 
				"   \n" + 
				"} >>";
}  