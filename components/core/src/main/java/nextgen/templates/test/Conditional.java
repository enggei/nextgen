package nextgen.templates.test;

public class Conditional {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _condition1;
	private Object _condition2;

	Conditional(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Conditional that = (Conditional) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("conditional");
		st.add("condition1", _condition1);
		st.add("condition2", _condition2);
		return st.render().trim();
	}

	public Conditional setCondition1(Object value) {
		this._condition1 = value;
		return this;
	}

	public Object getCondition1() {
		return this._condition1;
	}

	public Object getCondition1(Object defaultValue) {
		return this._condition1 == null ? defaultValue : this._condition1;
	}

	public boolean hasCondition1() {
		return this._condition1 != null;
	}

	public Conditional removeCondition1() {
		this._condition1 = null;
		return this;
	} 

	public Conditional setCondition2(Object value) {
		this._condition2 = value;
		return this;
	}

	public Object getCondition2() {
		return this._condition2;
	}

	public Object getCondition2(Object defaultValue) {
		return this._condition2 == null ? defaultValue : this._condition2;
	}

	public boolean hasCondition2() {
		return this._condition2 != null;
	}

	public Conditional removeCondition2() {
		this._condition2 = null;
		return this;
	} 

	static final String st = "conditional(condition1,condition2) ::= <<~if(condition1)~condition1: ~condition1~~elseif(condition2)~isCondition2~else~~endif~>> ";
} 