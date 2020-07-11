package nextgen.templates.kotlin;

public class ClassDeclaration implements CompilationUnit, ClassDefinition {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Boolean _isOpen;
	private Boolean _isAbstract;
	private String _name;
	private CompanionObject _companionObject;
	private OverrideEquals _overrideEquals;
	private OverrideHashCode _overrideHashCode;
	private OverrideToString _overrideToString;
	private java.util.List<AnnotationDeclaration> _annotations = new java.util.ArrayList<>();
	private java.util.List<ParameterDefinition> _fields = new java.util.ArrayList<>();
	private java.util.List<Extending> _extends = new java.util.ArrayList<>();
	private java.util.List<PropertyDeclaration> _properties = new java.util.ArrayList<>();
	private java.util.List<FunctionDeclaration> _members = new java.util.ArrayList<>();
	private java.util.List<ClassDefinition> _subclasses = new java.util.ArrayList<>();

	ClassDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassDeclaration");
		st.add("isOpen", _isOpen);
		st.add("isAbstract", _isAbstract);
		st.add("name", _name);
		st.add("companionObject", _companionObject);
		st.add("overrideEquals", _overrideEquals);
		st.add("overrideHashCode", _overrideHashCode);
		st.add("overrideToString", _overrideToString);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _fields) st.add("fields", o);
		for (Object o : _extends) st.add("extends", o);
		for (Object o : _properties) st.add("properties", o);
		for (Object o : _members) st.add("members", o);
		for (Object o : _subclasses) st.add("subclasses", o);
		return st.render().trim();
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

	public ClassDeclaration setCompanionObject(CompanionObject value) {
		this._companionObject = value;
		return this;
	}

	public CompanionObject getCompanionObject() {
		return this._companionObject;
	}

	public CompanionObject getCompanionObject(CompanionObject defaultValue) {
		return this._companionObject == null ? defaultValue : this._companionObject;
	}

	public boolean hasCompanionObject() {
		return this._companionObject != null;
	}

	public ClassDeclaration removeCompanionObject() {
		this._companionObject = null;
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

	public ClassDeclaration setOverrideToString(OverrideToString value) {
		this._overrideToString = value;
		return this;
	}

	public OverrideToString getOverrideToString() {
		return this._overrideToString;
	}

	public OverrideToString getOverrideToString(OverrideToString defaultValue) {
		return this._overrideToString == null ? defaultValue : this._overrideToString;
	}

	public boolean hasOverrideToString() {
		return this._overrideToString != null;
	}

	public ClassDeclaration removeOverrideToString() {
		this._overrideToString = null;
		return this;
	} 

	public ClassDeclaration addAnnotations(AnnotationDeclaration value) {
		this._annotations.add(value);
		return this;
	}

	public ClassDeclaration setAnnotations(AnnotationDeclaration[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setAnnotations(java.util.Collection<AnnotationDeclaration> values) {
		this._annotations.addAll(values);
		return this;
	}

	public ClassDeclaration removeAnnotations(AnnotationDeclaration value) {
		this._annotations.remove(value);
		return this;
	}

	public ClassDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<AnnotationDeclaration> getAnnotations() {
		return this._annotations;
	} 

	public ClassDeclaration addFields(ParameterDefinition value) {
		this._fields.add(value);
		return this;
	}

	public ClassDeclaration setFields(ParameterDefinition[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setFields(java.util.Collection<ParameterDefinition> values) {
		this._fields.addAll(values);
		return this;
	}

	public ClassDeclaration removeFields(ParameterDefinition value) {
		this._fields.remove(value);
		return this;
	}

	public ClassDeclaration removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<ParameterDefinition> getFields() {
		return this._fields;
	} 

	public ClassDeclaration addExtends(Extending value) {
		this._extends.add(value);
		return this;
	}

	public ClassDeclaration setExtends(Extending[] value) {
		this._extends.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setExtends(java.util.Collection<Extending> values) {
		this._extends.addAll(values);
		return this;
	}

	public ClassDeclaration removeExtends(Extending value) {
		this._extends.remove(value);
		return this;
	}

	public ClassDeclaration removeExtends(int index) {
		this._extends.remove(index);
		return this;
	}

	public java.util.List<Extending> getExtends() {
		return this._extends;
	} 

	public ClassDeclaration addProperties(PropertyDeclaration value) {
		this._properties.add(value);
		return this;
	}

	public ClassDeclaration setProperties(PropertyDeclaration[] value) {
		this._properties.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setProperties(java.util.Collection<PropertyDeclaration> values) {
		this._properties.addAll(values);
		return this;
	}

	public ClassDeclaration removeProperties(PropertyDeclaration value) {
		this._properties.remove(value);
		return this;
	}

	public ClassDeclaration removeProperties(int index) {
		this._properties.remove(index);
		return this;
	}

	public java.util.List<PropertyDeclaration> getProperties() {
		return this._properties;
	} 

	public ClassDeclaration addMembers(FunctionDeclaration value) {
		this._members.add(value);
		return this;
	}

	public ClassDeclaration setMembers(FunctionDeclaration[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setMembers(java.util.Collection<FunctionDeclaration> values) {
		this._members.addAll(values);
		return this;
	}

	public ClassDeclaration removeMembers(FunctionDeclaration value) {
		this._members.remove(value);
		return this;
	}

	public ClassDeclaration removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<FunctionDeclaration> getMembers() {
		return this._members;
	} 

	public ClassDeclaration addSubclasses(ClassDefinition value) {
		this._subclasses.add(value);
		return this;
	}

	public ClassDeclaration setSubclasses(ClassDefinition[] value) {
		this._subclasses.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassDeclaration setSubclasses(java.util.Collection<ClassDefinition> values) {
		this._subclasses.addAll(values);
		return this;
	}

	public ClassDeclaration removeSubclasses(ClassDefinition value) {
		this._subclasses.remove(value);
		return this;
	}

	public ClassDeclaration removeSubclasses(int index) {
		this._subclasses.remove(index);
		return this;
	}

	public java.util.List<ClassDefinition> getSubclasses() {
		return this._subclasses;
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

	static final String st = "ClassDeclaration(annotations,isOpen,isAbstract,name,fields,extends,properties,companionObject,overrideEquals,overrideHashCode,overrideToString,members,subclasses) ::= <<~annotations:{it|~it~};separator=\"\\n\"~\n" + 
				"~if(isOpen)~open ~elseif(isAbstract)~abstract ~endif~class ~name~(\n" + 
				"	~fields:{it|~it~};separator=\",\\n\"~\n" + 
				")~if(extends)~: ~extends:{it|~it~};separator=\", \"~~endif~ {\n" + 
				"\n" + 
				"	~properties:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	~companionObject~\n" + 
				"\n" + 
				"	~overrideEquals~\n" + 
				"\n" + 
				"	~overrideHashCode~\n" + 
				"\n" + 
				"	~overrideToString~\n" + 
				"\n" + 
				"	~members:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	~subclasses:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  