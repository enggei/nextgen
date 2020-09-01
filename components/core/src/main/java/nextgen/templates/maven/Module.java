package nextgen.templates.maven;

public class Module {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _pom;
	private java.util.List<Object> _modules = new java.util.ArrayList<>();

	Module(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Module");
		st.add("name", _name);
		st.add("pom", _pom);
		for (Object o : _modules) st.add("modules", o);
		return st.render().trim();
	}

	public Module setName(Object value) {
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

	public Module removeName() {
		this._name = null;
		return this;
	} 

	public Module setPom(Object value) {
		this._pom = value;
		return this;
	}

	public Object getPom() {
		return this._pom;
	}

	public Object getPom(Object defaultValue) {
		return this._pom == null ? defaultValue : this._pom;
	}

	public boolean hasPom() {
		return this._pom != null;
	}

	public Module removePom() {
		this._pom = null;
		return this;
	} 

	public Module addModules(Object value) {
		this._modules.add(value);
		return this;
	}

	public Module setModules(Object[] value) {
		this._modules.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Module setModules(java.util.Collection<Object> values) {
		this._modules.addAll(values);
		return this;
	}

	public Module removeModules(Object value) {
		this._modules.remove(value);
		return this;
	}

	public Module removeModules(int index) {
		this._modules.remove(index);
		return this;
	}

	public java.util.List<Object> getModules() {
		return this._modules;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Module that = (Module) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Module(name,pom,modules) ::= <<Module ~name~\n" + 
				"Pom : ~pom~\n" + 
				"\n" + 
				"Modules:\n" + 
				"~modules:{it|~it~};separator=\"\\n\"~ >>";
}  