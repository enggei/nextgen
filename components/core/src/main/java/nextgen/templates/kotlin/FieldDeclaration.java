package nextgen.templates.kotlin;

public class FieldDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Boolean _isMutable;
	private Boolean _isNonMember;
	private String _name;
	private TypeDeclaration _type;
	private Initializer _initializer;
	private java.util.List<java.util.Collection<AnnotationDeclaration>> _annotations = new java.util.ArrayList<>();

	FieldDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FieldDeclaration");
		st.add("isMutable", _isMutable);
		st.add("isNonMember", _isNonMember);
		st.add("name", _name);
		st.add("type", _type);
		st.add("initializer", _initializer);
		for (Object o : _annotations) st.add("annotations", o);
		return st.render().trim();
	}

	public FieldDeclaration setIsMutable(Boolean value) {
		this._isMutable = value;
		return this;
	}

	public Boolean getIsMutable() {
		return this._isMutable;
	}

	public Boolean getIsMutable(Boolean defaultValue) {
		return this._isMutable == null ? defaultValue : this._isMutable;
	}

	public boolean hasIsMutable() {
		return this._isMutable != null;
	}

	public FieldDeclaration removeIsMutable() {
		this._isMutable = null;
		return this;
	} 

	public FieldDeclaration setIsNonMember(Boolean value) {
		this._isNonMember = value;
		return this;
	}

	public Boolean getIsNonMember() {
		return this._isNonMember;
	}

	public Boolean getIsNonMember(Boolean defaultValue) {
		return this._isNonMember == null ? defaultValue : this._isNonMember;
	}

	public boolean hasIsNonMember() {
		return this._isNonMember != null;
	}

	public FieldDeclaration removeIsNonMember() {
		this._isNonMember = null;
		return this;
	} 

	public FieldDeclaration setName(String value) {
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

	public FieldDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public FieldDeclaration setType(TypeDeclaration value) {
		this._type = value;
		return this;
	}

	public TypeDeclaration getType() {
		return this._type;
	}

	public TypeDeclaration getType(TypeDeclaration defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public FieldDeclaration removeType() {
		this._type = null;
		return this;
	} 

	public FieldDeclaration setInitializer(Initializer value) {
		this._initializer = value;
		return this;
	}

	public Initializer getInitializer() {
		return this._initializer;
	}

	public Initializer getInitializer(Initializer defaultValue) {
		return this._initializer == null ? defaultValue : this._initializer;
	}

	public boolean hasInitializer() {
		return this._initializer != null;
	}

	public FieldDeclaration removeInitializer() {
		this._initializer = null;
		return this;
	} 

	public FieldDeclaration addAnnotations(java.util.Collection<AnnotationDeclaration> value) {
		this._annotations.add(value);
		return this;
	}

	public FieldDeclaration setAnnotations(java.util.Collection<AnnotationDeclaration>[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FieldDeclaration setAnnotations(java.util.Collection<java.util.Collection<AnnotationDeclaration>> values) {
		this._annotations.addAll(values);
		return this;
	}

	public FieldDeclaration removeAnnotations(java.util.Collection<AnnotationDeclaration> value) {
		this._annotations.remove(value);
		return this;
	}

	public FieldDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<java.util.Collection<AnnotationDeclaration>> getAnnotations() {
		return this._annotations;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FieldDeclaration that = (FieldDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FieldDeclaration(annotations,isMutable,isNonMember,name,type,initializer) ::= <<~annotations:{it|~it~};separator=\"\\n\"~\n" + 
				"~if(isMutable)~var ~elseif(isNonMember)~~else~val ~endif~~name~: ~type~~if(initializer)~ = ~initializer~~endif~ >>";
} 