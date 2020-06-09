package nextgen.st.stringtemplate;

public class STG {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _delimiter;
	private java.util.List<Object> _templates = new java.util.ArrayList<>();

	STG(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STG that = (STG) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STG");
		st.add("delimiter", _delimiter);
		for (Object o : _templates) st.add("templates", o);
		return st.render().trim();
	}

	public STG setDelimiter(Object value) {
		this._delimiter = value;
		return this;
	}

	public Object getDelimiter() {
		return this._delimiter;
	}

	public Object getDelimiter(Object defaultValue) {
		return this._delimiter == null ? defaultValue : this._delimiter;
	}

	public boolean hasDelimiter() {
		return this._delimiter != null;
	}

	public STG removeDelimiter() {
		this._delimiter = null;
		return this;
	} 
	public STG addTemplates(Object value) {
		this._templates.add(value);
		return this;
	}

	public STG removeTemplates(Object value) {
		this._templates.remove(value);
		return this;
	}

	public STG removeTemplates(int index) {
		this._templates.remove(index);
		return this;
	}

	public java.util.List<Object> getTemplates() {
		return this._templates;
	} 

	static final String st = "STG(delimiter,templates) ::= <<delimiters ~delimiter~,~delimiter~\n" + 
				"\n" + 
				"eom() ::= \"}\"\n" + 
				"\n" + 
				"gt() ::= \">\"\n" + 
				"\n" + 
				"~templates:{it|~it~};separator=\"\\n\\n\"~ >\\> >> ";
} 