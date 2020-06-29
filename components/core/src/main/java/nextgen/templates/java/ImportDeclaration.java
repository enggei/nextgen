package nextgen.templates.java;

public class ImportDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _isStatic;
	private Object _name;
	private Object _isAsterisk;

	ImportDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ImportDeclaration");
		st.add("isStatic", _isStatic);
		st.add("name", _name);
		st.add("isAsterisk", _isAsterisk);
		return st.render().trim();
	}

	public ImportDeclaration setIsStatic(Object value) {
		this._isStatic = value;
		return this;
	}

	public Object getIsStatic() {
		return this._isStatic;
	}

	public Object getIsStatic(Object defaultValue) {
		return this._isStatic == null ? defaultValue : this._isStatic;
	}

	public boolean hasIsStatic() {
		return this._isStatic != null;
	}

	public ImportDeclaration removeIsStatic() {
		this._isStatic = null;
		return this;
	} 

	public ImportDeclaration setName(Object value) {
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

	public ImportDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public ImportDeclaration setIsAsterisk(Object value) {
		this._isAsterisk = value;
		return this;
	}

	public Object getIsAsterisk() {
		return this._isAsterisk;
	}

	public Object getIsAsterisk(Object defaultValue) {
		return this._isAsterisk == null ? defaultValue : this._isAsterisk;
	}

	public boolean hasIsAsterisk() {
		return this._isAsterisk != null;
	}

	public ImportDeclaration removeIsAsterisk() {
		this._isAsterisk = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ImportDeclaration that = (ImportDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ImportDeclaration(isStatic,name,isAsterisk) ::= <<import ~if(isStatic)~static ~endif~~name~~if(isAsterisk)~.*~endif~; >>";
}  