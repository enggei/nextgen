package nextgen.templates.java;

public class EnumDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _members = new java.util.ArrayList<>();
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();
	private java.util.List<Object> _implementedTypes = new java.util.ArrayList<>();
	private java.util.List<Object> _entries = new java.util.ArrayList<>();
	private java.util.List<Object> _extend = new java.util.ArrayList<>();
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();

	EnumDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnumDeclaration that = (EnumDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnumDeclaration");
		st.add("name", _name);
		for (Object o : _members) st.add("members", o);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _implementedTypes) st.add("implementedTypes", o);
		for (Object o : _entries) st.add("entries", o);
		for (Object o : _extend) st.add("extend", o);
		for (Object o : _modifiers) st.add("modifiers", o);
		return st.render().trim();
	}

	public EnumDeclaration setName(Object value) {
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

	public EnumDeclaration removeName() {
		this._name = null;
		return this;
	} 
	public EnumDeclaration addMembers(Object value) {
		this._members.add(value);
		return this;
	}

	public EnumDeclaration removeMembers(Object value) {
		this._members.remove(value);
		return this;
	}

	public EnumDeclaration removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<Object> getMembers() {
		return this._members;
	} 

	public EnumDeclaration addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public EnumDeclaration removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public EnumDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	} 

	public EnumDeclaration addImplementedTypes(Object value) {
		this._implementedTypes.add(value);
		return this;
	}

	public EnumDeclaration removeImplementedTypes(Object value) {
		this._implementedTypes.remove(value);
		return this;
	}

	public EnumDeclaration removeImplementedTypes(int index) {
		this._implementedTypes.remove(index);
		return this;
	}

	public java.util.List<Object> getImplementedTypes() {
		return this._implementedTypes;
	} 

	public EnumDeclaration addEntries(Object value) {
		this._entries.add(value);
		return this;
	}

	public EnumDeclaration removeEntries(Object value) {
		this._entries.remove(value);
		return this;
	}

	public EnumDeclaration removeEntries(int index) {
		this._entries.remove(index);
		return this;
	}

	public java.util.List<Object> getEntries() {
		return this._entries;
	} 

	public EnumDeclaration addExtend(Object value) {
		this._extend.add(value);
		return this;
	}

	public EnumDeclaration removeExtend(Object value) {
		this._extend.remove(value);
		return this;
	}

	public EnumDeclaration removeExtend(int index) {
		this._extend.remove(index);
		return this;
	}

	public java.util.List<Object> getExtend() {
		return this._extend;
	} 

	public EnumDeclaration addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public EnumDeclaration removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public EnumDeclaration removeModifiers(int index) {
		this._modifiers.remove(index);
		return this;
	}

	public java.util.List<Object> getModifiers() {
		return this._modifiers;
	} 

	static final String st = "EnumDeclaration(name,members,annotations,implementedTypes,entries,extend,modifiers) ::= <<~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~enum ~name~~if(extend)~ extends ~extend:{it|~it~};separator=\", \"~~endif~~if(implementedTypes)~ implements ~implementedTypes:{it|~it~};separator=\",\"~~endif~ {\n" + 
				"\n" + 
				"	~entries:{it|~it~};separator=\",\\n\"~~if(members)~;~endif~\n" + 
				"\n" + 
				"	~members:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"}>> ";
} 