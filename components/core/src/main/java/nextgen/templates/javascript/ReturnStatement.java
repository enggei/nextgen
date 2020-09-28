package nextgen.templates.javascript;

public class ReturnStatement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _condition;
	private Object _element;

	ReturnStatement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("returnStatement");
		st.add("condition", _condition);
		st.add("element", _element);
		return st.render().trim();
	}

	public ReturnStatement setCondition(Object value) {
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

	public ReturnStatement removeCondition() {
		this._condition = null;
		return this;
	} 

	public ReturnStatement setElement(Object value) {
		this._element = value;
		return this;
	}

	public Object getElement() {
		return this._element;
	}

	public Object getElement(Object defaultValue) {
		return this._element == null ? defaultValue : this._element;
	}

	public boolean hasElement() {
		return this._element != null;
	}

	public ReturnStatement removeElement() {
		this._element = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ReturnStatement that = (ReturnStatement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "returnStatement(condition,element) ::= <<~if(condition)~if (~condition~) ~endif~return (\n" + 
				"	~if(element)~~element~~else~null~endif~\n" + 
				"	); >>";
}  