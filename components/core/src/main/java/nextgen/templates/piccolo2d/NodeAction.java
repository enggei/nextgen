package nextgen.templates.piccolo2d;

public class NodeAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _nodeType;
	private Boolean _titleExpression;
	private Object _canvasName;
	private Object _title;
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	NodeAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NodeAction");
		st.add("name", _name);
		st.add("nodeType", _nodeType);
		st.add("titleExpression", _titleExpression);
		st.add("canvasName", _canvasName);
		st.add("title", _title);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public NodeAction setName(Object value) {
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

	public NodeAction removeName() {
		this._name = null;
		return this;
	} 

	public NodeAction setNodeType(Object value) {
		this._nodeType = value;
		return this;
	}

	public Object getNodeType() {
		return this._nodeType;
	}

	public Object getNodeType(Object defaultValue) {
		return this._nodeType == null ? defaultValue : this._nodeType;
	}

	public boolean hasNodeType() {
		return this._nodeType != null;
	}

	public NodeAction removeNodeType() {
		this._nodeType = null;
		return this;
	} 

	public NodeAction setTitleExpression(Boolean value) {
		this._titleExpression = value;
		return this;
	}

	public Boolean getTitleExpression() {
		return this._titleExpression;
	}

	public Boolean getTitleExpression(Boolean defaultValue) {
		return this._titleExpression == null ? defaultValue : this._titleExpression;
	}

	public boolean hasTitleExpression() {
		return this._titleExpression != null;
	}

	public NodeAction removeTitleExpression() {
		this._titleExpression = null;
		return this;
	} 

	public NodeAction setCanvasName(Object value) {
		this._canvasName = value;
		return this;
	}

	public Object getCanvasName() {
		return this._canvasName;
	}

	public Object getCanvasName(Object defaultValue) {
		return this._canvasName == null ? defaultValue : this._canvasName;
	}

	public boolean hasCanvasName() {
		return this._canvasName != null;
	}

	public NodeAction removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public NodeAction setTitle(Object value) {
		this._title = value;
		return this;
	}

	public Object getTitle() {
		return this._title;
	}

	public Object getTitle(Object defaultValue) {
		return this._title == null ? defaultValue : this._title;
	}

	public boolean hasTitle() {
		return this._title != null;
	}

	public NodeAction removeTitle() {
		this._title = null;
		return this;
	} 

	public NodeAction addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public NodeAction setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NodeAction setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public NodeAction removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public NodeAction removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public NodeAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public NodeAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NodeAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public NodeAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public NodeAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public NodeAction addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public NodeAction addFields(NodeAction_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<NodeAction_Fields> streamFields() {
		return this._fields.stream().map(NodeAction_Fields::new);
	}

	public static final class NodeAction_Fields {

		Object _type;
		Object _name;

		public NodeAction_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private NodeAction_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NodeAction that = (NodeAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NodeAction(name,nodeType,fields,titleExpression,canvasName,title,constructorStatements,statements) ::= <<private static final class ~name~ extends NodeAction<~nodeType~> {\n" + 
				"\n" + 
				"	~fields:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~name~(~if(titleExpression)~String name, ~endif~~nodeType~ node, ~canvasName~ canvas, PInputEvent event~if(fields)~, ~endif~~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(~if(titleExpression)~name~else~\"~title~\"~endif~, node, canvas, event);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	void actionPerformed(~nodeType~ node, ~canvasName~ canvas, PInputEvent event, ActionEvent e) {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"} >>";
}  