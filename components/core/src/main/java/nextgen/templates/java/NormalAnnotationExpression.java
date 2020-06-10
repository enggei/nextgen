package nextgen.templates.java;

public class NormalAnnotationExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _memberValues = new java.util.ArrayList<>();

	NormalAnnotationExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NormalAnnotationExpression");
		st.add("name", _name);
		for (Object o : _memberValues) st.add("memberValues", o);
		return st.render().trim();
	}

	public NormalAnnotationExpression setName(Object value) {
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

	public NormalAnnotationExpression removeName() {
		this._name = null;
		return this;
	} 
	public NormalAnnotationExpression addMemberValues(Object value) {
		this._memberValues.add(value);
		return this;
	}

	public NormalAnnotationExpression removeMemberValues(Object value) {
		this._memberValues.remove(value);
		return this;
	}

	public NormalAnnotationExpression removeMemberValues(int index) {
		this._memberValues.remove(index);
		return this;
	}

	public java.util.List<Object> getMemberValues() {
		return this._memberValues;
	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NormalAnnotationExpression that = (NormalAnnotationExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NormalAnnotationExpression(name,memberValues) ::= <<@~name~~if(memberValues)~(~memberValues:{it|~it~};separator=\", \"~)~endif~>> ";
}  