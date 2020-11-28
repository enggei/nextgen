package nextgen.templates.javascript;

public class Conditional {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _condition;
	private Object _then;
	private Object _otherwise;

	Conditional(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Conditional");
		st.add("condition", _condition);
		st.add("then", _then);
		st.add("otherwise", _otherwise);
		return st.render().trim();
	}

	public Conditional setCondition(Object value) {
		this._condition = value;
		return this;
	}

	public Object getCondition() {
		return this._condition;
	}

	public Object getCondition(Object defaultValue) {
		return this._condition == null ? defaultValue : this._condition;
	}

	public boolean hasCondition() {
		return this._condition != null;
	}

	public Conditional removeCondition() {
		this._condition = null;
		return this;
	} 

	public Conditional setThen(Object value) {
		this._then = value;
		return this;
	}

	public Object getThen() {
		return this._then;
	}

	public Object getThen(Object defaultValue) {
		return this._then == null ? defaultValue : this._then;
	}

	public boolean hasThen() {
		return this._then != null;
	}

	public Conditional removeThen() {
		this._then = null;
		return this;
	} 

	public Conditional setOtherwise(Object value) {
		this._otherwise = value;
		return this;
	}

	public Object getOtherwise() {
		return this._otherwise;
	}

	public Object getOtherwise(Object defaultValue) {
		return this._otherwise == null ? defaultValue : this._otherwise;
	}

	public boolean hasOtherwise() {
		return this._otherwise != null;
	}

	public Conditional removeOtherwise() {
		this._otherwise = null;
		return this;
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

	static final String st = "Conditional(condition,then,otherwise) ::= <<~condition~ ? ~then~ : ~otherwise~ >>";
}  