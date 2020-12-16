package nextgen.templates.brain;

public class Entity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;

	Entity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Entity");
		st.add("name", _name);
		return st.render().trim();
	}

	public Entity setName(String value) {
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

	public Entity removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entity that = (Entity) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Entity(name) ::= <<package graph;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"   private final java.util.UUID uuid = java.util.UUID.randomUUID();\n" + 
				"\n" + 
				"   @Override\n" + 
				"   public String toString() {\n" + 
				"      return uuid.toString();\n" + 
				"   }\n" + 
				"\n" + 
				"   @Override\n" + 
				"   public boolean equals(Object o) {\n" + 
				"      if (this == o) return true;\n" + 
				"      if (o == null || getClass() != o.getClass()) return false;\n" + 
				"      graph.~name~ node = (graph.~name~) o;\n" + 
				"      return uuid.equals(node.uuid);\n" + 
				"   }\n" + 
				"\n" + 
				"   @Override\n" + 
				"   public int hashCode() {\n" + 
				"      return java.util.Objects.hash(uuid);\n" + 
				"   }\n" + 
				"} >>";
}  