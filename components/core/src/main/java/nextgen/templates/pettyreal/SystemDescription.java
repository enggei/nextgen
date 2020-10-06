package nextgen.templates.pettyreal;

public class SystemDescription {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _appName;
	private Object _appTitle;
	private java.util.List<Object> _pages = new java.util.ArrayList<>();

	SystemDescription(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SystemDescription");
		st.add("appName", _appName);
		st.add("appTitle", _appTitle);
		for (Object o : _pages) st.add("pages", o);
		return st.render().trim();
	}

	public SystemDescription setAppName(Object value) {
		this._appName = value;
		return this;
	}

	public Object getAppName() {
		return this._appName;
	}

	public Object getAppName(Object defaultValue) {
		return this._appName == null ? defaultValue : this._appName;
	}

	public boolean hasAppName() {
		return this._appName != null;
	}

	public SystemDescription removeAppName() {
		this._appName = null;
		return this;
	} 

	public SystemDescription setAppTitle(Object value) {
		this._appTitle = value;
		return this;
	}

	public Object getAppTitle() {
		return this._appTitle;
	}

	public Object getAppTitle(Object defaultValue) {
		return this._appTitle == null ? defaultValue : this._appTitle;
	}

	public boolean hasAppTitle() {
		return this._appTitle != null;
	}

	public SystemDescription removeAppTitle() {
		this._appTitle = null;
		return this;
	} 

	public SystemDescription addPages(Object value) {
		this._pages.add(value);
		return this;
	}

	public SystemDescription setPages(Object[] value) {
		this._pages.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SystemDescription setPages(java.util.Collection<Object> values) {
		this._pages.addAll(values);
		return this;
	}

	public SystemDescription removePages(Object value) {
		this._pages.remove(value);
		return this;
	}

	public SystemDescription removePages(int index) {
		this._pages.remove(index);
		return this;
	}

	public java.util.List<Object> getPages() {
		return this._pages;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SystemDescription that = (SystemDescription) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SystemDescription(appName,appTitle,pages) ::= <<~appName~\n" + 
				"~appTitle~\n" + 
				"\n" + 
				"Routes:\n" + 
				"\n" + 
				"\n" + 
				"Pages:\n" + 
				"~pages:{it|~it~};separator=\"\\n\\n\"~ >>";
}  