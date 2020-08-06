package nextgen.templates.kotlin;

public class PropertyDeclaration implements ParameterDefinition {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Boolean _isAbstract;
	private Boolean _override;
	private Boolean _isPrivate;
	private Boolean _isProtected;
	private Boolean _isMutable;
	private String _name;
	private TypeDeclaration _type;
	private Expression _initializer;
	private Boolean _privateSetter;
	private java.util.List<AnnotationDeclaration> _annotations = new java.util.ArrayList<>();

	PropertyDeclaration(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PropertyDeclaration");
		st.add("isAbstract", _isAbstract);
		st.add("override", _override);
		st.add("isPrivate", _isPrivate);
		st.add("isProtected", _isProtected);
		st.add("isMutable", _isMutable);
		st.add("name", _name);
		st.add("type", _type);
		st.add("initializer", _initializer);
		st.add("privateSetter", _privateSetter);
		for (Object o : _annotations) st.add("annotations", o);
		return st.render().trim();
	}

	public PropertyDeclaration setIsAbstract(Boolean value) {
		this._isAbstract = value;
		return this;
	}

	public Boolean getIsAbstract() {
		return this._isAbstract;
	}

	public Boolean getIsAbstract(Boolean defaultValue) {
		return this._isAbstract == null ? defaultValue : this._isAbstract;
	}

	public boolean hasIsAbstract() {
		return this._isAbstract != null;
	}

	public PropertyDeclaration removeIsAbstract() {
		this._isAbstract = null;
		return this;
	} 

	public PropertyDeclaration setOverride(Boolean value) {
		this._override = value;
		return this;
	}

	public Boolean getOverride() {
		return this._override;
	}

	public Boolean getOverride(Boolean defaultValue) {
		return this._override == null ? defaultValue : this._override;
	}

	public boolean hasOverride() {
		return this._override != null;
	}

	public PropertyDeclaration removeOverride() {
		this._override = null;
		return this;
	} 

	public PropertyDeclaration setIsPrivate(Boolean value) {
		this._isPrivate = value;
		return this;
	}

	public Boolean getIsPrivate() {
		return this._isPrivate;
	}

	public Boolean getIsPrivate(Boolean defaultValue) {
		return this._isPrivate == null ? defaultValue : this._isPrivate;
	}

	public boolean hasIsPrivate() {
		return this._isPrivate != null;
	}

	public PropertyDeclaration removeIsPrivate() {
		this._isPrivate = null;
		return this;
	} 

	public PropertyDeclaration setIsProtected(Boolean value) {
		this._isProtected = value;
		return this;
	}

	public Boolean getIsProtected() {
		return this._isProtected;
	}

	public Boolean getIsProtected(Boolean defaultValue) {
		return this._isProtected == null ? defaultValue : this._isProtected;
	}

	public boolean hasIsProtected() {
		return this._isProtected != null;
	}

	public PropertyDeclaration removeIsProtected() {
		this._isProtected = null;
		return this;
	} 

	public PropertyDeclaration setIsMutable(Boolean value) {
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

	public PropertyDeclaration removeIsMutable() {
		this._isMutable = null;
		return this;
	} 

	public PropertyDeclaration setName(String value) {
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

	public PropertyDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public PropertyDeclaration setType(TypeDeclaration value) {
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

	public PropertyDeclaration removeType() {
		this._type = null;
		return this;
	} 

	public PropertyDeclaration setInitializer(Expression value) {
		this._initializer = value;
		return this;
	}

	public Expression getInitializer() {
		return this._initializer;
	}

	public Expression getInitializer(Expression defaultValue) {
		return this._initializer == null ? defaultValue : this._initializer;
	}

	public boolean hasInitializer() {
		return this._initializer != null;
	}

	public PropertyDeclaration removeInitializer() {
		this._initializer = null;
		return this;
	} 

	public PropertyDeclaration setPrivateSetter(Boolean value) {
		this._privateSetter = value;
		return this;
	}

	public Boolean getPrivateSetter() {
		return this._privateSetter;
	}

	public Boolean getPrivateSetter(Boolean defaultValue) {
		return this._privateSetter == null ? defaultValue : this._privateSetter;
	}

	public boolean hasPrivateSetter() {
		return this._privateSetter != null;
	}

	public PropertyDeclaration removePrivateSetter() {
		this._privateSetter = null;
		return this;
	} 

	public PropertyDeclaration addAnnotations(AnnotationDeclaration value) {
		this._annotations.add(value);
		return this;
	}

	public PropertyDeclaration setAnnotations(AnnotationDeclaration[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PropertyDeclaration setAnnotations(java.util.Collection<AnnotationDeclaration> values) {
		this._annotations.addAll(values);
		return this;
	}

	public PropertyDeclaration removeAnnotations(AnnotationDeclaration value) {
		this._annotations.remove(value);
		return this;
	}

	public PropertyDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<AnnotationDeclaration> getAnnotations() {
		return this._annotations;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PropertyDeclaration that = (PropertyDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PropertyDeclaration(annotations,isAbstract,override,isPrivate,isProtected,isMutable,name,type,initializer,privateSetter) ::= <<~annotations:{it|~it~};separator=\"\\n\"~\n" + 
				"~if(isAbstract)~abstract ~endif~~if(override)~override ~endif~~if(isPrivate)~private ~elseif(isProtected)~protected ~endif~~if(isMutable)~var ~else~val ~endif~~name~~if(type)~: ~type~~endif~~if(initializer)~ = ~initializer~~endif~~if(privateSetter)~\n" + 
				"	private set~endif~ >>";
}  