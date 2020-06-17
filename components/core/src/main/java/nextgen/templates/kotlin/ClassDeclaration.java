package nextgen.templates.kotlin;

public class ClassDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.Collection<AnnotationDeclaration> _annotations;
	private Boolean _isOpen;
	private Boolean _isAbstract;
	private String _name;
	private OverrideEquals _overrideEquals;
	private OverrideHashCode _overrideHashCode;
	private java.util.List<Object> _fields = new java.util.ArrayList<>();
	private java.util.List<Object> _extends = new java.util.ArrayList<>();
	private java.util.List<Object> _members = new java.util.ArrayList<>();

	ClassDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassDeclaration");
		st.add("annotations", _annotations);
		st.add("isOpen", _isOpen);
		st.add("isAbstract", _isAbstract);
		st.add("name", _name);
		st.add("overrideEquals", _overrideEquals);
		st.add("overrideHashCode", _overrideHashCode);
		for (Object o : _fields) st.add("fields", o);
		for (Object o : _extends) st.add("extends", o);
		for (Object o : _members) st.add("members", o);
		return st.render().trim();
	}

	public ClassDeclaration setAnnotations(java.util.Collection<AnnotationDeclaration> value) {
		this._annotations = value;
		return this;
	}

	public java.util.Collection<AnnotationDeclaration> getAnnotations() {
		return this._annotations;
	}

	public java.util.Collection<AnnotationDeclaration> getAnnotations(java.util.Collection<AnnotationDeclaration> defaultValue) {
		return this._annotations == null ? defaultValue : this._annotations;
	}

	public boolean hasAnnotations() {
		return this._annotations != null;
	}

	public ClassDeclaration removeAnnotations() {
		this._annotations = null;
		return this;
	} 

	public ClassDeclaration setIsOpen(Boolean value) {
		this._isOpen = value;
		return this;
	}

	public Boolean getIsOpen() {
		return this._isOpen;
	}

	public Boolean getIsOpen(Boolean defaultValue) {
		return this._isOpen == null ? defaultValue : this._isOpen;
	}

	public boolean hasIsOpen() {
		return this._isOpen != null;
	}

	public ClassDeclaration removeIsOpen() {
		this._isOpen = null;
		return this;
	} 

	public ClassDeclaration setIsAbstract(Boolean value) {
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

	public ClassDeclaration removeIsAbstract() {
		this._isAbstract = null;
		return this;
	} 

	public ClassDeclaration setName(String value) {
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

	public ClassDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public ClassDeclaration setOverrideEquals(OverrideEquals value) {
		this._overrideEquals = value;
		return this;
	}

	public OverrideEquals getOverrideEquals() {
		return this._overrideEquals;
	}

	public OverrideEquals getOverrideEquals(OverrideEquals defaultValue) {
		return this._overrideEquals == null ? defaultValue : this._overrideEquals;
	}

	public boolean hasOverrideEquals() {
		return this._overrideEquals != null;
	}

	public ClassDeclaration removeOverrideEquals() {
		this._overrideEquals = null;
		return this;
	} 

	public ClassDeclaration setOverrideHashCode(OverrideHashCode value) {
		this._overrideHashCode = value;
		return this;
	}

	public OverrideHashCode getOverrideHashCode() {
		return this._overrideHashCode;
	}

	public OverrideHashCode getOverrideHashCode(OverrideHashCode defaultValue) {
		return this._overrideHashCode == null ? defaultValue : this._overrideHashCode;
	}

	public boolean hasOverrideHashCode() {
		return this._overrideHashCode != null;
	}

	public ClassDeclaration removeOverrideHashCode() {
		this._overrideHashCode = null;
		return this;
	} 

	public ClassDeclaration addFields(Object value) {
		this._fields.add(value);
		return this;
	}

	public ClassDeclaration setFields(Object[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setFields(java.util.Collection<Object> values) {
		this._fields.addAll(values);
		return this;
	}

	public ClassDeclaration removeFields(Object value) {
		this._fields.remove(value);
		return this;
	}

	public ClassDeclaration removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<Object> getFields() {
		return this._fields;
	} 

	public ClassDeclaration addExtends(Object value) {
		this._extends.add(value);
		return this;
	}

	public ClassDeclaration setExtends(Object[] value) {
		this._extends.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setExtends(java.util.Collection<Object> values) {
		this._extends.addAll(values);
		return this;
	}

	public ClassDeclaration removeExtends(Object value) {
		this._extends.remove(value);
		return this;
	}

	public ClassDeclaration removeExtends(int index) {
		this._extends.remove(index);
		return this;
	}

	public java.util.List<Object> getExtends() {
		return this._extends;
	} 

	public ClassDeclaration addMembers(Object value) {
		this._members.add(value);
		return this;
	}

	public ClassDeclaration setMembers(Object[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setMembers(java.util.Collection<Object> values) {
		this._members.addAll(values);
		return this;
	}

	public ClassDeclaration removeMembers(Object value) {
		this._members.remove(value);
		return this;
	}

	public ClassDeclaration removeMembers(int index) {
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
		ClassDeclaration that = (ClassDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ClassDeclaration(annotations,isOpen,isAbstract,name,fields,extends,overrideEquals,overrideHashCode,members) ::= <<~annotations~~if(annotations)~\n" + 
				"~endif~~if(isOpen)~open ~elseif(isAbstract)~abstract ~endif~class ~name~(\n" + 
				"	~fields:{it|~it~};separator=\",\\n\"~\n" + 
				")~if(extends)~: ~extends:{it|~it~};separator=\", \"~~endif~ {\n" + 
				"\n" + 
				"	~if(overrideEquals)~~overrideEquals~\n" + 
				"\n" + 
				"	~endif~\n" + 
				"\n" + 
				"	~if(overrideHashCode)~~overrideHashCode~\n" + 
				"\n" + 
				"	~endif~\n" + 
				"\n" + 
				"	~members:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
} 