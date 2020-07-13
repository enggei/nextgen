package nextgen.templates.kotlin;

public class DataClassDeclaration implements CompilationUnit, ClassDefinition {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Comment _comments;
	private String _name;
	private java.util.List<AnnotationDeclaration> _annotations = new java.util.ArrayList<>();
	private java.util.List<PropertyDeclaration> _fields = new java.util.ArrayList<>();
	private java.util.List<FunctionDeclaration> _members = new java.util.ArrayList<>();
	private java.util.List<ClassDefinition> _subclasses = new java.util.ArrayList<>();

	DataClassDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DataClassDeclaration");
		st.add("comments", _comments);
		st.add("name", _name);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _fields) st.add("fields", o);
		for (Object o : _members) st.add("members", o);
		for (Object o : _subclasses) st.add("subclasses", o);
		return st.render().trim();
	}

	public DataClassDeclaration setComments(Comment value) {
		this._comments = value;
		return this;
	}

	public Comment getComments() {
		return this._comments;
	}

	public Comment getComments(Comment defaultValue) {
		return this._comments == null ? defaultValue : this._comments;
	}

	public boolean hasComments() {
		return this._comments != null;
	}

	public DataClassDeclaration removeComments() {
		this._comments = null;
		return this;
	} 

	public DataClassDeclaration setName(String value) {
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

	public DataClassDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public DataClassDeclaration addAnnotations(AnnotationDeclaration value) {
		this._annotations.add(value);
		return this;
	}

	public DataClassDeclaration setAnnotations(AnnotationDeclaration[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DataClassDeclaration setAnnotations(java.util.Collection<AnnotationDeclaration> values) {
		this._annotations.addAll(values);
		return this;
	}

	public DataClassDeclaration removeAnnotations(AnnotationDeclaration value) {
		this._annotations.remove(value);
		return this;
	}

	public DataClassDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<AnnotationDeclaration> getAnnotations() {
		return this._annotations;
	} 

	public DataClassDeclaration addFields(PropertyDeclaration value) {
		this._fields.add(value);
		return this;
	}

	public DataClassDeclaration setFields(PropertyDeclaration[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DataClassDeclaration setFields(java.util.Collection<PropertyDeclaration> values) {
		this._fields.addAll(values);
		return this;
	}

	public DataClassDeclaration removeFields(PropertyDeclaration value) {
		this._fields.remove(value);
		return this;
	}

	public DataClassDeclaration removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<PropertyDeclaration> getFields() {
		return this._fields;
	} 

	public DataClassDeclaration addMembers(FunctionDeclaration value) {
		this._members.add(value);
		return this;
	}

	public DataClassDeclaration setMembers(FunctionDeclaration[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DataClassDeclaration setMembers(java.util.Collection<FunctionDeclaration> values) {
		this._members.addAll(values);
		return this;
	}

	public DataClassDeclaration removeMembers(FunctionDeclaration value) {
		this._members.remove(value);
		return this;
	}

	public DataClassDeclaration removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<FunctionDeclaration> getMembers() {
		return this._members;
	} 

	public DataClassDeclaration addSubclasses(ClassDefinition value) {
		this._subclasses.add(value);
		return this;
	}

	public DataClassDeclaration setSubclasses(ClassDefinition[] value) {
		this._subclasses.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DataClassDeclaration setSubclasses(java.util.Collection<ClassDefinition> values) {
		this._subclasses.addAll(values);
		return this;
	}

	public DataClassDeclaration removeSubclasses(ClassDefinition value) {
		this._subclasses.remove(value);
		return this;
	}

	public DataClassDeclaration removeSubclasses(int index) {
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
		DataClassDeclaration that = (DataClassDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DataClassDeclaration(comments,annotations,name,fields,members,subclasses) ::= <<~comments~\n" + 
				"~annotations:{it|~it~};separator=\"\\n\"~\n" + 
				"data class ~name~(\n" + 
				"	~fields:{it|~it~};separator=\",\\n\"~\n" + 
				")~if(members)~ {\n" + 
				"\n" + 
				"	~members:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~subclasses:{it|~it~};separator=\"\\n\"~\n" + 
				"}~endif~ >>";
}  