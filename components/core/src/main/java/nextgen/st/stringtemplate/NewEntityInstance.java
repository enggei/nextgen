package nextgen.st.stringtemplate;

public class NewEntityInstance {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entityName;

	NewEntityInstance(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("newEntityInstance");
		st.add("entityName", _entityName);
		return st.render().trim();
	}

	public NewEntityInstance setEntityName(Object value) {
		this._entityName = value;
		return this;
	}

	public Object getEntityName() {
		return this._entityName;
	}

	public Object getEntityName(Object defaultValue) {
		return this._entityName == null ? defaultValue : this._entityName;
	}

	public boolean hasEntityName() {
		return this._entityName != null;
	}

	public NewEntityInstance removeEntityName() {
		this._entityName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NewEntityInstance that = (NewEntityInstance) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "newEntityInstance(entityName) ::= <<public static ~entityName~ new~entityName~() {\n" + 
				"	return new ~entityName~(stGroup);\n" + 
				"} >>";
} 