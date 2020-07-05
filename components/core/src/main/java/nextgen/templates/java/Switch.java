package nextgen.templates.java;

public class Switch {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _selector;
	private java.util.List<java.util.Map<String, Object>> _cases = new java.util.ArrayList<>();

	Switch(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Switch");
		st.add("selector", _selector);
		for (java.util.Map<String, Object> map : _cases) st.addAggr("cases.{trigger,statement}", map.get("trigger"), map.get("statement"));
		return st.render().trim();
	}

	public Switch setSelector(Object value) {
		this._selector = value;
		return this;
	}

	public Object getSelector() {
		return this._selector;
	}

	public Object getSelector(Object defaultValue) {
		return this._selector == null ? defaultValue : this._selector;
	}

	public boolean hasSelector() {
		return this._selector != null;
	}

	public Switch removeSelector() {
		this._selector = null;
		return this;
	} 


	public Switch addCases(Object _trigger, Object _statement) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("trigger", _trigger);
		map.put("statement", _statement);
		this._cases.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getCases() {
		return this._cases;
	}

	public Switch addCases(Switch_Cases value) {
		return addCases(value._trigger, value._statement);
	}

	public java.util.stream.Stream<Switch_Cases> streamCases() {
		return this._cases.stream().map(Switch_Cases::new);
	}

	public static final class Switch_Cases {

		Object _trigger;
		Object _statement;

		public Switch_Cases(Object _trigger, Object _statement) {
			this._trigger = _trigger;
			this._statement = _statement;
		}

		private Switch_Cases(java.util.Map<String, Object> map) {
			this._trigger = (Object) map.get("trigger");
			this._statement = (Object) map.get("statement");
		}

		public Object getTrigger() {
			return this._trigger;
		}

		public Object getStatement() {
			return this._statement;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Switch that = (Switch) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Switch(selector,cases) ::= <<switch (~selector~) {\n" + 
				"	~cases:{it|\n" + 
				"case ~it.trigger~: {\n" + 
				"	~it.statement~\n" + 
				"	break;\n" + 
				"\\}};separator=\"\\n\"~\n" + 
				"} >>";
}  