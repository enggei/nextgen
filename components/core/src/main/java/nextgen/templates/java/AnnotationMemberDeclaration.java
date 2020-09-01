package nextgen.templates.java;

public class AnnotationMemberDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _type;
	private Object _defaultValue;

	AnnotationMemberDeclaration(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnnotationMemberDeclaration");
		st.add("name", _name);
		st.add("type", _type);
		st.add("defaultValue", _defaultValue);
		return st.render().trim();
	}

	public AnnotationMemberDeclaration setName(Object value) {
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

	public AnnotationMemberDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public AnnotationMemberDeclaration setType(Object value) {
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

	public AnnotationMemberDeclaration removeType() {
		this._type = null;
		return this;
	} 

	public AnnotationMemberDeclaration setDefaultValue(Object value) {
		this._defaultValue = value;
		return this;
	}

	public Object getDefaultValue() {
		return this._defaultValue;
	}

	public Object getDefaultValue(Object defaultValue) {
		return this._defaultValue == null ? defaultValue : this._defaultValue;
	}

	public boolean hasDefaultValue() {
		return this._defaultValue != null;
	}

	public AnnotationMemberDeclaration removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnnotationMemberDeclaration that = (AnnotationMemberDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AnnotationMemberDeclaration(name,type,defaultValue) ::= <<~type~ ~name~()~if(defaultValue)~ default ~defaultValue~~endif~; >>";
}  