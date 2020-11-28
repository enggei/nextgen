package nextgen.templates.kotlin;

public class ImportStatement implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _scope;
	private String _name;

	ImportStatement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ImportStatement");
		st.add("scope", _scope);
		st.add("name", _name);
		return st.render().trim();
	}

	public ImportStatement setScope(String value) {
		this._scope = value;
		return this;
	}

	public String getScope() {
		return this._scope;
	}

	public String getScope(String defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public ImportStatement removeScope() {
		this._scope = null;
		return this;
	} 

	public ImportStatement setName(String value) {
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

	public ImportStatement removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ImportStatement that = (ImportStatement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ImportStatement(scope,name) ::= <<import ~scope~.~name~ >>";
}  