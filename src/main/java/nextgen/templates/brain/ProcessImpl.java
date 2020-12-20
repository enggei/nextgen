package nextgen.templates.brain;

public class ProcessImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _I;
	private Object _process;
	private Object _apply;
	private Object _packageName;
	private Object _O;
	private String _name;

	ProcessImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ProcessImpl");
		st.add("I", _I);
		st.add("process", _process);
		st.add("apply", _apply);
		st.add("packageName", _packageName);
		st.add("O", _O);
		st.add("name", _name);
		return st.render().trim();
	}

	public ProcessImpl setI(Object value) {
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

	public ProcessImpl removeI() {
		this._I = null;
		return this;
	} 

	public ProcessImpl setProcess(Object value) {
		this._process = value;
		return this;
	}

	public Object getProcess() {
		return this._process;
	}

	public Object getProcess(Object defaultValue) {
		return this._process == null ? defaultValue : this._process;
	}

	public boolean hasProcess() {
		return this._process != null;
	}

	public ProcessImpl removeProcess() {
		this._process = null;
		return this;
	} 

	public ProcessImpl setApply(Object value) {
		this._apply = value;
		return this;
	}

	public Object getApply() {
		return this._apply;
	}

	public Object getApply(Object defaultValue) {
		return this._apply == null ? defaultValue : this._apply;
	}

	public boolean hasApply() {
		return this._apply != null;
	}

	public ProcessImpl removeApply() {
		this._apply = null;
		return this;
	} 

	public ProcessImpl setPackageName(Object value) {
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

	public ProcessImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ProcessImpl setO(Object value) {
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

	public ProcessImpl removeO() {
		this._O = null;
		return this;
	} 

	public ProcessImpl setName(String value) {
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

	public ProcessImpl removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProcessImpl that = (ProcessImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ProcessImpl(I,process,apply,packageName,O,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ implements ~process~ {\n" + 
				"\n" + 
				"	@Override\n" + 
				"   public ~O~ apply(~I~ input) {\n" + 
				"      ~apply~\n" + 
				"   }\n" + 
				"} >>";
}  