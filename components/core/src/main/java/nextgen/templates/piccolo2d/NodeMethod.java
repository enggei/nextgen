package nextgen.templates.piccolo2d;

public class NodeMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _name;
	private Object _returnStatement;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _params = new java.util.ArrayList<>();

	NodeMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("nodeMethod");
		st.add("type", _type);
		st.add("name", _name);
		st.add("returnStatement", _returnStatement);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public NodeMethod setType(Object value) {
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

	public NodeMethod removeType() {
		this._type = null;
		return this;
	} 

	public NodeMethod setName(Object value) {
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

	public NodeMethod removeName() {
		this._name = null;
		return this;
	} 

	public NodeMethod setReturnStatement(Object value) {
		this._returnStatement = value;
		return this;
	}

	public Object getReturnStatement() {
		return this._returnStatement;
	}

	public Object getReturnStatement(Object defaultValue) {
		return this._returnStatement == null ? defaultValue : this._returnStatement;
	}

	public boolean hasReturnStatement() {
		return this._returnStatement != null;
	}

	public NodeMethod removeReturnStatement() {
		this._returnStatement = null;
		return this;
	} 

	public NodeMethod addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public NodeMethod setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NodeMethod setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public NodeMethod removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public NodeMethod removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public NodeMethod addParams(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public NodeMethod addParams(NodeMethod_Params value) {
		return addParams(value._name, value._type);
	}

	public java.util.stream.Stream<NodeMethod_Params> streamParams() {
		return this._params.stream().map(NodeMethod_Params::new);
	}

	public static final class NodeMethod_Params {

		Object _name;
		Object _type;

		public NodeMethod_Params(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private NodeMethod_Params(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NodeMethod that = (NodeMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "nodeMethod(type,name,params,statements,returnStatement) ::= <<public ~if(type)~~type~~else~void~endif~ ~name~(~params:{it|~it.type~ ~it.name~};separator=\",\"~) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~~if(returnStatement)~\n" + 
				"	return ~returnStatement~~endif~\n" + 
				"	\n" + 
				"} >>";
}  