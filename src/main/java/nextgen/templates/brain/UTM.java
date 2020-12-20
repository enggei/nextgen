package nextgen.templates.brain;

public class UTM {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private String _name;

	UTM(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UTM");
		st.add("type", _type);
		st.add("name", _name);
		return st.render().trim();
	}

	public UTM setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public UTM removeType() {
		this._type = null;
		return this;
	} 

	public UTM setName(String value) {
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

	public UTM removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UTM that = (UTM) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "UTM(type,name) ::= <<package utm;\n" + 
				"\n" + 
				"public abstract class ~name~ implements java.util.function.Supplier<~type~>, java.util.function.Consumer<~type~>, java.util.function.UnaryOperator<~type~>, java.util.function.Function<~type~, ~type~>, java.util.function.Predicate<~type~> {\n" + 
				"\n" + 
				"} >>";
}  