package nextgen.templates.maven;

public class ProjectGenerator {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _description;
	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	ProjectGenerator(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ProjectGenerator");
		st.add("description", _description);
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public ProjectGenerator setDescription(Object value) {
		this._description = value;
		return this;
	}

	public Object getDescription() {
		return this._description;
	}

	public Object getDescription(Object defaultValue) {
		return this._description == null ? defaultValue : this._description;
	}

	public boolean hasDescription() {
		return this._description != null;
	}

	public ProjectGenerator removeDescription() {
		this._description = null;
		return this;
	} 

	public ProjectGenerator setName(Object value) {
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

	public ProjectGenerator removeName() {
		this._name = null;
		return this;
	} 

	public ProjectGenerator addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public ProjectGenerator setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ProjectGenerator setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public ProjectGenerator removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public ProjectGenerator removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProjectGenerator that = (ProjectGenerator) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ProjectGenerator(statements,description,name) ::= <</**\n" + 
				" * ~name~\n" + 
				" * ~description~\n" + 
				" */\n" + 
				"@org.junit.Test\n" + 
				"public void ~name~() {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  