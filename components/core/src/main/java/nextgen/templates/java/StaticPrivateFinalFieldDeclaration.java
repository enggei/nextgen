package nextgen.templates.java;

public class StaticPrivateFinalFieldDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _initializer;
	private Object _name;
	private Object _type;

	StaticPrivateFinalFieldDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StaticPrivateFinalFieldDeclaration that = (StaticPrivateFinalFieldDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StaticPrivateFinalFieldDeclaration");
		st.add("initializer", _initializer);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public StaticPrivateFinalFieldDeclaration setInitializer(Object value) {
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

	public StaticPrivateFinalFieldDeclaration removeInitializer() {
		this._initializer = null;
		return this;
	} 

	public StaticPrivateFinalFieldDeclaration setName(Object value) {
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

	public StaticPrivateFinalFieldDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public StaticPrivateFinalFieldDeclaration setType(Object value) {
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

	public StaticPrivateFinalFieldDeclaration removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "StaticPrivateFinalFieldDeclaration(initializer,name,type) ::= <<static final ~VariableDeclaration(initializer,name,type)~;>> ";
} 