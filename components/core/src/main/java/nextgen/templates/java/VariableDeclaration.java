package nextgen.templates.java;

public class VariableDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _initializer;
	private Object _type;

	VariableDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VariableDeclaration that = (VariableDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VariableDeclaration");
		st.add("name", _name);
		st.add("initializer", _initializer);
		st.add("type", _type);
		return st.render().trim();
	}

	public VariableDeclaration setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public VariableDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public VariableDeclaration setInitializer(Object value) {
		this._initializer = value;
		return this;
	}

	public Object getInitializer() {
		return this._initializer;
	}

	public boolean hasInitializer() {
		return this._initializer != null;
	}

	public VariableDeclaration removeInitializer() {
		this._initializer = null;
		return this;
	} 

	public VariableDeclaration setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public VariableDeclaration removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "VariableDeclaration(name,initializer,type) ::= <<~if(type)~~type~ ~endif~~name~~if(initializer)~ = ~initializer~~endif~>> ";
} 