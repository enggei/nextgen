package nextgen.templates.piccolo2d;

public class CanvasAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _canvasName;
	private Object _title;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	CanvasAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasAction");
		st.add("name", _name);
		st.add("canvasName", _canvasName);
		st.add("title", _title);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public CanvasAction setName(Object value) {
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

	public CanvasAction removeName() {
		this._name = null;
		return this;
	} 

	public CanvasAction setCanvasName(Object value) {
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

	public CanvasAction removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public CanvasAction setTitle(Object value) {
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

	public CanvasAction removeTitle() {
		this._title = null;
		return this;
	} 

	public CanvasAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public CanvasAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public CanvasAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public CanvasAction removeStatements(int index) {
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
		CanvasAction that = (CanvasAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasAction(name,canvasName,title,statements) ::= <<private static final class ~name~ extends CanvasAction {\n" + 
				"\n" + 
				"	~name~(~canvasName~ canvas, PInputEvent event) {\n" + 
				"		super(\"~title~\", canvas, event);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	void actionPerformed(~canvasName~ canvas, PInputEvent event, ActionEvent e) {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"} >>";
}  