package nextgen.templates.java;

public class SingleMemberAnnotationExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _members = new java.util.ArrayList<>();

	SingleMemberAnnotationExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SingleMemberAnnotationExpression");
		st.add("name", _name);
		for (Object o : _members) st.add("members", o);
		return st.render().trim();
	}

	public SingleMemberAnnotationExpression setName(Object value) {
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

	public SingleMemberAnnotationExpression removeName() {
		this._name = null;
		return this;
	} 
	public SingleMemberAnnotationExpression addMembers(Object value) {
		this._members.add(value);
		return this;
	}

	public SingleMemberAnnotationExpression removeMembers(Object value) {
		this._members.remove(value);
		return this;
	}

	public SingleMemberAnnotationExpression removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<Object> getMembers() {
		return this._members;
	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SingleMemberAnnotationExpression that = (SingleMemberAnnotationExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SingleMemberAnnotationExpression(members,name) ::= <<@~name~~if(members)~(~members:{it|~it~};separator=\", \"~)~endif~>> ";
}  