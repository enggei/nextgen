package nextgen.templates.java;

public class StaticPublicFinalFieldDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _initializer;
	private Object _name;
	private Object _type;

	StaticPublicFinalFieldDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StaticPublicFinalFieldDeclaration that = (StaticPublicFinalFieldDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("staticPublicFinalFieldDeclaration");
		st.add("initializer", _initializer);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public StaticPublicFinalFieldDeclaration setInitializer(Object value) {
		this._initializer = value;
		return this;
	}

	public Object getInitializer() {
		return this._initializer;
	}

	public Object getInitializer(Object defaultValue) {
		return this._initializer == null ? defaultValue : this._initializer;
	}

	public boolean hasInitializer() {
		return this._initializer != null;
	}

	public StaticPublicFinalFieldDeclaration removeInitializer() {
		this._initializer = null;
		return this;
	} 

	public StaticPublicFinalFieldDeclaration setName(Object value) {
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

	public StaticPublicFinalFieldDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public StaticPublicFinalFieldDeclaration setType(Object value) {
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

	public StaticPublicFinalFieldDeclaration removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "staticPublicFinalFieldDeclaration(initializer,name,type) ::= <<static public final ~VariableDeclaration(initializer,name,type)~;>> ";
} 