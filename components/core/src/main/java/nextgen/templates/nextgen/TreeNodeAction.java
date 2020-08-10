package nextgen.templates.nextgen;

public class TreeNodeAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _title;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	TreeNodeAction(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TreeNodeAction");
		st.add("title", _title);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public TreeNodeAction setTitle(Object value) {
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

	public TreeNodeAction removeTitle() {
		this._title = null;
		return this;
	} 

	public TreeNodeAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public TreeNodeAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNodeAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public TreeNodeAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public TreeNodeAction removeStatements(int index) {
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
		TreeNodeAction that = (TreeNodeAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TreeNodeAction(title,statements) ::= <<newAction(\"~title~\", actionEvent -> {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"}) >>";
}  