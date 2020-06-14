package nextgen.templates.java;

public class ClassOrInterfaceDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _isInterface;
	private Object _name;
	private java.util.List<Object> _comments = new java.util.ArrayList<>();
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();
	private java.util.List<Object> _typeParameters = new java.util.ArrayList<>();
	private java.util.List<Object> _extend = new java.util.ArrayList<>();
	private java.util.List<Object> _implementedTypes = new java.util.ArrayList<>();
	private java.util.List<Object> _fields = new java.util.ArrayList<>();
	private java.util.List<Object> _members = new java.util.ArrayList<>();

	ClassOrInterfaceDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassOrInterfaceDeclaration");
		st.add("isInterface", _isInterface);
		st.add("name", _name);
		for (Object o : _comments) st.add("comments", o);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _modifiers) st.add("modifiers", o);
		for (Object o : _typeParameters) st.add("typeParameters", o);
		for (Object o : _extend) st.add("extend", o);
		for (Object o : _implementedTypes) st.add("implementedTypes", o);
		for (Object o : _fields) st.add("fields", o);
		for (Object o : _members) st.add("members", o);
		return st.render().trim();
	}

	public ClassOrInterfaceDeclaration setIsInterface(Object value) {
		this._isInterface = value;
		return this;
	}

	public Object getIsInterface() {
		return this._isInterface;
	}

	public Object getIsInterface(Object defaultValue) {
		return this._isInterface == null ? defaultValue : this._isInterface;
	}

	public boolean hasIsInterface() {
		return this._isInterface != null;
	}

	public ClassOrInterfaceDeclaration removeIsInterface() {
		this._isInterface = null;
		return this;
	}

	public ClassOrInterfaceDeclaration setName(Object value) {
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

	public ClassOrInterfaceDeclaration removeName() {
		this._name = null;
		return this;
	}

	public ClassOrInterfaceDeclaration addComments(Object value) {
		this._comments.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setComments(Object[] value) {
		this._comments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setComments(java.util.Collection<Object> values) {
		this._comments.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeComments(Object value) {
		this._comments.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeComments(int index) {
		this._comments.remove(index);
		return this;
	}

	public java.util.List<Object> getComments() {
		return this._comments;
	}

	public ClassOrInterfaceDeclaration addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setAnnotations(Object[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setAnnotations(java.util.Collection<Object> values) {
		this._annotations.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	}

	public ClassOrInterfaceDeclaration addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setModifiers(Object[] value) {
		this._modifiers.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setModifiers(java.util.Collection<Object> values) {
		this._modifiers.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeModifiers(int index) {
		this._modifiers.remove(index);
		return this;
	}

	public java.util.List<Object> getModifiers() {
		return this._modifiers;
	}

	public ClassOrInterfaceDeclaration addTypeParameters(Object value) {
		this._typeParameters.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setTypeParameters(Object[] value) {
		this._typeParameters.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setTypeParameters(java.util.Collection<Object> values) {
		this._typeParameters.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeTypeParameters(Object value) {
		this._typeParameters.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeTypeParameters(int index) {
		this._typeParameters.remove(index);
		return this;
	}

	public java.util.List<Object> getTypeParameters() {
		return this._typeParameters;
	}

	public ClassOrInterfaceDeclaration addExtend(Object value) {
		this._extend.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setExtend(Object[] value) {
		this._extend.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setExtend(java.util.Collection<Object> values) {
		this._extend.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeExtend(Object value) {
		this._extend.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeExtend(int index) {
		this._extend.remove(index);
		return this;
	}

	public java.util.List<Object> getExtend() {
		return this._extend;
	}

	public ClassOrInterfaceDeclaration addImplementedTypes(Object value) {
		this._implementedTypes.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setImplementedTypes(Object[] value) {
		this._implementedTypes.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setImplementedTypes(java.util.Collection<Object> values) {
		this._implementedTypes.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeImplementedTypes(Object value) {
		this._implementedTypes.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeImplementedTypes(int index) {
		this._implementedTypes.remove(index);
		return this;
	}

	public java.util.List<Object> getImplementedTypes() {
		return this._implementedTypes;
	}

	public ClassOrInterfaceDeclaration addFields(Object value) {
		this._fields.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setFields(Object[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setFields(java.util.Collection<Object> values) {
		this._fields.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeFields(Object value) {
		this._fields.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<Object> getFields() {
		return this._fields;
	}

	public ClassOrInterfaceDeclaration addMembers(Object value) {
		this._members.add(value);
		return this;
	}

	public ClassOrInterfaceDeclaration setMembers(Object[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceDeclaration setMembers(java.util.Collection<Object> values) {
		this._members.addAll(values);
		return this;
	}

	public ClassOrInterfaceDeclaration removeMembers(Object value) {
		this._members.remove(value);
		return this;
	}

	public ClassOrInterfaceDeclaration removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<Object> getMembers() {
		return this._members;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClassOrInterfaceDeclaration that = (ClassOrInterfaceDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ClassOrInterfaceDeclaration(comments,annotations,modifiers,isInterface,name,typeParameters,extend,implementedTypes,fields,members) ::= <<~comments:{it|~it~};separator=\"\\n\"~~if(comments)~\n" + 
				"~endif~~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~~if(isInterface)~interface ~else~class ~endif~~name~~if(typeParameters)~<~typeParameters:{it|~it~};separator=\", \"~>~endif~~if(extend)~ extends ~extend:{it|~it~};separator=\", \"~~endif~~if(implementedTypes)~ implements ~implementedTypes:{it|~it~};separator=\", \"~~endif~ {\n" + 
				"	\n" + 
				"	~fields:{it|~it~};separator=\"\\n\"~\n" + 
				"	~if(fields)~\n" + 
				"	\n" + 
				"	~endif~\n" + 
				"	~members:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"}>>";
}