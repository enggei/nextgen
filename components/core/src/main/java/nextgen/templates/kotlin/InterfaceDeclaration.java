package nextgen.templates.kotlin;

public class InterfaceDeclaration implements InterfaceDefinition, CompilationUnit {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Comment _comments;
	private String _name;
	private java.util.List<Extending> _extends = new java.util.ArrayList<>();
	private java.util.List<FunctionDeclaration> _members = new java.util.ArrayList<>();
	private java.util.List<PropertyDeclaration> _properties = new java.util.ArrayList<>();

	InterfaceDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InterfaceDeclaration");
		st.add("comments", _comments);
		st.add("name", _name);
		for (Object o : _extends) st.add("extends", o);
		for (Object o : _members) st.add("members", o);
		for (Object o : _properties) st.add("properties", o);
		return st.render().trim();
	}

	public InterfaceDeclaration setComments(Comment value) {
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

	public InterfaceDeclaration removeComments() {
		this._comments = null;
		return this;
	} 

	public InterfaceDeclaration setName(String value) {
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

	public InterfaceDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public InterfaceDeclaration addExtends(Extending value) {
		this._extends.add(value);
		return this;
	}

	public InterfaceDeclaration setExtends(Extending[] value) {
		this._extends.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public InterfaceDeclaration setExtends(java.util.Collection<Extending> values) {
		this._extends.addAll(values);
		return this;
	}

	public InterfaceDeclaration removeExtends(Extending value) {
		this._extends.remove(value);
		return this;
	}

	public InterfaceDeclaration removeExtends(int index) {
		this._extends.remove(index);
		return this;
	}

	public java.util.List<Extending> getExtends() {
		return this._extends;
	} 

	public InterfaceDeclaration addMembers(FunctionDeclaration value) {
		this._members.add(value);
		return this;
	}

	public InterfaceDeclaration setMembers(FunctionDeclaration[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public InterfaceDeclaration setMembers(java.util.Collection<FunctionDeclaration> values) {
		this._members.addAll(values);
		return this;
	}

	public InterfaceDeclaration removeMembers(FunctionDeclaration value) {
		this._members.remove(value);
		return this;
	}

	public InterfaceDeclaration removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<FunctionDeclaration> getMembers() {
		return this._members;
	} 

	public InterfaceDeclaration addProperties(PropertyDeclaration value) {
		this._properties.add(value);
		return this;
	}

	public InterfaceDeclaration setProperties(PropertyDeclaration[] value) {
		this._properties.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public InterfaceDeclaration setProperties(java.util.Collection<PropertyDeclaration> values) {
		this._properties.addAll(values);
		return this;
	}

	public InterfaceDeclaration removeProperties(PropertyDeclaration value) {
		this._properties.remove(value);
		return this;
	}

	public InterfaceDeclaration removeProperties(int index) {
		this._properties.remove(index);
		return this;
	}

	public java.util.List<PropertyDeclaration> getProperties() {
		return this._properties;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InterfaceDeclaration that = (InterfaceDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "InterfaceDeclaration(comments,name,extends,members,properties) ::= <<~comments~\n" + 
				"interface ~name~~if(extends)~: ~extends:{it|~it~};separator=\", \"~~endif~~if(members)~ { ~elseif(properties)~ {~endif~\n" + 
				"\n" + 
				"	~properties:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	~members:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"~if(members)~}~elseif(properties)~}~endif~ >>";
}  