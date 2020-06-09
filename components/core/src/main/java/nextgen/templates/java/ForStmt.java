package nextgen.templates.java;

public class ForStmt {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _compare;
	private Object _body;
	private java.util.List<Object> _update = new java.util.ArrayList<>();
	private java.util.List<Object> _initialization = new java.util.ArrayList<>();

	ForStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ForStmt that = (ForStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ForStmt");
		st.add("compare", _compare);
		st.add("body", _body);
		for (Object o : _update) st.add("update", o);
		for (Object o : _initialization) st.add("initialization", o);
		return st.render().trim();
	}

	public ForStmt setCompare(Object value) {
		this._compare = value;
		return this;
	}

	public Object getCompare() {
		return this._compare;
	}

	public Object getCompare(Object defaultValue) {
		return this._compare == null ? defaultValue : this._compare;
	}

	public boolean hasCompare() {
		return this._compare != null;
	}

	public ForStmt removeCompare() {
		this._compare = null;
		return this;
	} 

	public ForStmt setBody(Object value) {
		this._body = value;
		return this;
	}

	public Object getBody() {
		return this._body;
	}

	public Object getBody(Object defaultValue) {
		return this._body == null ? defaultValue : this._body;
	}

	public boolean hasBody() {
		return this._body != null;
	}

	public ForStmt removeBody() {
		this._body = null;
		return this;
	} 
	public ForStmt addUpdate(Object value) {
		this._update.add(value);
		return this;
	}

	public ForStmt removeUpdate(Object value) {
		this._update.remove(value);
		return this;
	}

	public ForStmt removeUpdate(int index) {
		this._update.remove(index);
		return this;
	}

	public java.util.List<Object> getUpdate() {
		return this._update;
	} 

	public ForStmt addInitialization(Object value) {
		this._initialization.add(value);
		return this;
	}

	public ForStmt removeInitialization(Object value) {
		this._initialization.remove(value);
		return this;
	}

	public ForStmt removeInitialization(int index) {
		this._initialization.remove(index);
		return this;
	}

	public java.util.List<Object> getInitialization() {
		return this._initialization;
	} 

	static final String st = "ForStmt(update,initialization,compare,body) ::= <<for (~initialization:{it|~it~};separator=\", \"~; ~compare~; ~update:{it|~it~};separator=\", \"~) ~body~>> ";
} 