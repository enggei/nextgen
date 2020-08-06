package nextgen.templates.kotlin;

public class EnumClassDeclaration implements CompilationUnit, ClassDefinition {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Comment _comments;
	private String _name;
	private java.util.List<PropertyDeclaration> _params = new java.util.ArrayList<>();
	private java.util.List<EnumField> _values = new java.util.ArrayList<>();

	EnumClassDeclaration(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnumClassDeclaration");
		st.add("comments", _comments);
		st.add("name", _name);
		for (Object o : _params) st.add("params", o);
		for (Object o : _values) st.add("values", o);
		return st.render().trim();
	}

	public EnumClassDeclaration setComments(Comment value) {
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

	public EnumClassDeclaration removeComments() {
		this._comments = null;
		return this;
	} 

	public EnumClassDeclaration setName(String value) {
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

	public EnumClassDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public EnumClassDeclaration addParams(PropertyDeclaration value) {
		this._params.add(value);
		return this;
	}

	public EnumClassDeclaration setParams(PropertyDeclaration[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumClassDeclaration setParams(java.util.Collection<PropertyDeclaration> values) {
		this._params.addAll(values);
		return this;
	}

	public EnumClassDeclaration removeParams(PropertyDeclaration value) {
		this._params.remove(value);
		return this;
	}

	public EnumClassDeclaration removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<PropertyDeclaration> getParams() {
		return this._params;
	} 

	public EnumClassDeclaration addValues(EnumField value) {
		this._values.add(value);
		return this;
	}

	public EnumClassDeclaration setValues(EnumField[] value) {
		this._values.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumClassDeclaration setValues(java.util.Collection<EnumField> values) {
		this._values.addAll(values);
		return this;
	}

	public EnumClassDeclaration removeValues(EnumField value) {
		this._values.remove(value);
		return this;
	}

	public EnumClassDeclaration removeValues(int index) {
		this._values.remove(index);
		return this;
	}

	public java.util.List<EnumField> getValues() {
		return this._values;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnumClassDeclaration that = (EnumClassDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EnumClassDeclaration(comments,name,params,values) ::= <<~comments~\n" + 
				"enum class ~name~~if(params)~(~params:{it|~it~};separator=\", \"~)~endif~ {\n" + 
				"	~values:{it|~it~};separator=\",\\n\"~\n" + 
				"} >>";
}  