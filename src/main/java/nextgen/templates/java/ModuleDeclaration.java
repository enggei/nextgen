package nextgen.templates.java;

public class ModuleDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _providesDirective = new java.util.ArrayList<>();
	private java.util.List<Object> _usesDirective = new java.util.ArrayList<>();
	private java.util.List<Object> _requiresDirective = new java.util.ArrayList<>();
	private java.util.List<Object> _exportsDirective = new java.util.ArrayList<>();
	private java.util.List<Object> _opens = new java.util.ArrayList<>();

	ModuleDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ModuleDeclaration");
		st.add("name", _name);
		for (Object o : _providesDirective) st.add("providesDirective", o);
		for (Object o : _usesDirective) st.add("usesDirective", o);
		for (Object o : _requiresDirective) st.add("requiresDirective", o);
		for (Object o : _exportsDirective) st.add("exportsDirective", o);
		for (Object o : _opens) st.add("opens", o);
		return st.render().trim();
	}

	public ModuleDeclaration setName(Object value) {
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

	public ModuleDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public ModuleDeclaration addProvidesDirective(Object value) {
		this._providesDirective.add(value);
		return this;
	}

	public ModuleDeclaration setProvidesDirective(Object[] value) {
		this._providesDirective.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModuleDeclaration setProvidesDirective(java.util.Collection<Object> values) {
		this._providesDirective.addAll(values);
		return this;
	}

	public ModuleDeclaration removeProvidesDirective(Object value) {
		this._providesDirective.remove(value);
		return this;
	}

	public ModuleDeclaration removeProvidesDirective(int index) {
		this._providesDirective.remove(index);
		return this;
	}

	public java.util.List<Object> getProvidesDirective() {
		return this._providesDirective;
	} 

	public ModuleDeclaration addUsesDirective(Object value) {
		this._usesDirective.add(value);
		return this;
	}

	public ModuleDeclaration setUsesDirective(Object[] value) {
		this._usesDirective.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModuleDeclaration setUsesDirective(java.util.Collection<Object> values) {
		this._usesDirective.addAll(values);
		return this;
	}

	public ModuleDeclaration removeUsesDirective(Object value) {
		this._usesDirective.remove(value);
		return this;
	}

	public ModuleDeclaration removeUsesDirective(int index) {
		this._usesDirective.remove(index);
		return this;
	}

	public java.util.List<Object> getUsesDirective() {
		return this._usesDirective;
	} 

	public ModuleDeclaration addRequiresDirective(Object value) {
		this._requiresDirective.add(value);
		return this;
	}

	public ModuleDeclaration setRequiresDirective(Object[] value) {
		this._requiresDirective.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModuleDeclaration setRequiresDirective(java.util.Collection<Object> values) {
		this._requiresDirective.addAll(values);
		return this;
	}

	public ModuleDeclaration removeRequiresDirective(Object value) {
		this._requiresDirective.remove(value);
		return this;
	}

	public ModuleDeclaration removeRequiresDirective(int index) {
		this._requiresDirective.remove(index);
		return this;
	}

	public java.util.List<Object> getRequiresDirective() {
		return this._requiresDirective;
	} 

	public ModuleDeclaration addExportsDirective(Object value) {
		this._exportsDirective.add(value);
		return this;
	}

	public ModuleDeclaration setExportsDirective(Object[] value) {
		this._exportsDirective.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModuleDeclaration setExportsDirective(java.util.Collection<Object> values) {
		this._exportsDirective.addAll(values);
		return this;
	}

	public ModuleDeclaration removeExportsDirective(Object value) {
		this._exportsDirective.remove(value);
		return this;
	}

	public ModuleDeclaration removeExportsDirective(int index) {
		this._exportsDirective.remove(index);
		return this;
	}

	public java.util.List<Object> getExportsDirective() {
		return this._exportsDirective;
	} 

	public ModuleDeclaration addOpens(Object value) {
		this._opens.add(value);
		return this;
	}

	public ModuleDeclaration setOpens(Object[] value) {
		this._opens.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModuleDeclaration setOpens(java.util.Collection<Object> values) {
		this._opens.addAll(values);
		return this;
	}

	public ModuleDeclaration removeOpens(Object value) {
		this._opens.remove(value);
		return this;
	}

	public ModuleDeclaration removeOpens(int index) {
		this._opens.remove(index);
		return this;
	}

	public java.util.List<Object> getOpens() {
		return this._opens;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ModuleDeclaration that = (ModuleDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ModuleDeclaration(providesDirective,usesDirective,name,requiresDirective,exportsDirective,opens) ::= <<module ~name~ {\n" + 
				"    ~requiresDirective:{it|requires ~it~};separator=\"\\n\"~\n" + 
				"    ~exportsDirective:{it|exports ~it~};separator=\"\\n\"~\n" + 
				"    ~providesDirective:{it|provides ~it~};separator=\"\\n\"~\n" + 
				"    ~usesDirective:{it|uses ~it~};separator=\"\\n\"~\n" + 
				"    ~opens:{it|opens ~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  