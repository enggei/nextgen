package nextgen.templates.java;

public class AnnotationDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _members = new java.util.ArrayList<>();
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();

	AnnotationDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnnotationDeclaration that = (AnnotationDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnnotationDeclaration");
		st.add("name", _name);
		for (Object o : _members) st.add("members", o);
		for (Object o : _modifiers) st.add("modifiers", o);
		for (Object o : _annotations) st.add("annotations", o);
		return st.render().trim();
	}

	public AnnotationDeclaration setName(Object value) {
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

	public AnnotationDeclaration removeName() {
		this._name = null;
		return this;
	} 
	public AnnotationDeclaration addMembers(Object value) {
		this._members.add(value);
		return this;
	}

	public AnnotationDeclaration removeMembers(Object value) {
		this._members.remove(value);
		return this;
	}

	public AnnotationDeclaration removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<Object> getMembers() {
		return this._members;
	} 

	public AnnotationDeclaration addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public AnnotationDeclaration removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public AnnotationDeclaration removeModifiers(int index) {
		this._modifiers.remove(index);
		return this;
	}

	public java.util.List<Object> getModifiers() {
		return this._modifiers;
	} 

	public AnnotationDeclaration addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public AnnotationDeclaration removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public AnnotationDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	} 

	static final String st = "AnnotationDeclaration(members,name,modifiers,annotations) ::= <<~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~@interface ~name~ {\n" + 
				"	~members:{it|~it~};separator=\"\\n\"~\n" + 
				"}>> ";
} 