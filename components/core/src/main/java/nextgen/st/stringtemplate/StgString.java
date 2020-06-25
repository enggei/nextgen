package nextgen.st.stringtemplate;

public class StgString {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _templates = new java.util.ArrayList<>();

	StgString(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("stgString");
		for (Object o : _templates) st.add("templates", o);
		return st.render().trim();
	}


	public StgString addTemplates(Object value) {
		this._templates.add(value);
		return this;
	}

	public StgString setTemplates(Object[] value) {
		this._templates.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StgString setTemplates(java.util.Collection<Object> values) {
		this._templates.addAll(values);
		return this;
	}

	public StgString removeTemplates(Object value) {
		this._templates.remove(value);
		return this;
	}

	public StgString removeTemplates(int index) {
		this._templates.remove(index);
		return this;
	}

	public java.util.List<Object> getTemplates() {
		return this._templates;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StgString that = (StgString) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "stgString(templates) ::= <<\"delimiters \\\"\\~\\\", \\\"\\~\\\"\\\\n\" +\n" + 
				"	\"eom() ::= \\\"}\\\"\\\\n\" +\n" + 
				"	\"gt() ::= \\\">\\\"\\\\n\"~if(templates)~ +\n" + 
				"	~templates:{it|~it~.st + \"\\\\n\"};separator=\" + \\n\"~~else~~endif~ >>";
}  