package nextgen.templates.piccolo2d;

public class AnonymousPNodeAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _nodeType;
	private Object _header;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	AnonymousPNodeAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnonymousPNodeAction");
		st.add("nodeType", _nodeType);
		st.add("header", _header);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public AnonymousPNodeAction setNodeType(Object value) {
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

	public AnonymousPNodeAction removeNodeType() {
		this._nodeType = null;
		return this;
	} 

	public AnonymousPNodeAction setHeader(Object value) {
		this._header = value;
		return this;
	}

	public Object getHeader() {
		return this._header;
	}

	public Object getHeader(Object defaultValue) {
		return this._header == null ? defaultValue : this._header;
	}

	public boolean hasHeader() {
		return this._header != null;
	}

	public AnonymousPNodeAction removeHeader() {
		this._header = null;
		return this;
	} 

	public AnonymousPNodeAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public AnonymousPNodeAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AnonymousPNodeAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public AnonymousPNodeAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public AnonymousPNodeAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnonymousPNodeAction that = (AnonymousPNodeAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AnonymousPNodeAction(nodeType,header,statements) ::= <<new STNode.NodeAction<~nodeType~>(~header~, this, canvas, event) {\n" + 
				"	@Override\n" + 
				"	void actionPerformed(~nodeType~ node, STCanvas canvas, PInputEvent event, ActionEvent e) {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"} >>";
}  