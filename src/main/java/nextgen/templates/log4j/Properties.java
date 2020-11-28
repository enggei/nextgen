package nextgen.templates.log4j;

public class Properties {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _logLevel;
	private Object _rootAppender;
	private java.util.List<Object> _categories = new java.util.ArrayList<>();
	private java.util.List<Object> _appenders = new java.util.ArrayList<>();

	Properties(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("properties");
		st.add("logLevel", _logLevel);
		st.add("rootAppender", _rootAppender);
		for (Object o : _categories) st.add("categories", o);
		for (Object o : _appenders) st.add("appenders", o);
		return st.render().trim();
	}

	public Properties setLogLevel(Object value) {
		this._logLevel = value;
		return this;
	}

	public Object getLogLevel() {
		return this._logLevel;
	}

	public Object getLogLevel(Object defaultValue) {
		return this._logLevel == null ? defaultValue : this._logLevel;
	}

	public boolean hasLogLevel() {
		return this._logLevel != null;
	}

	public Properties removeLogLevel() {
		this._logLevel = null;
		return this;
	} 

	public Properties setRootAppender(Object value) {
		this._rootAppender = value;
		return this;
	}

	public Object getRootAppender() {
		return this._rootAppender;
	}

	public Object getRootAppender(Object defaultValue) {
		return this._rootAppender == null ? defaultValue : this._rootAppender;
	}

	public boolean hasRootAppender() {
		return this._rootAppender != null;
	}

	public Properties removeRootAppender() {
		this._rootAppender = null;
		return this;
	} 

	public Properties addCategories(Object value) {
		this._categories.add(value);
		return this;
	}

	public Properties setCategories(Object[] value) {
		this._categories.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Properties setCategories(java.util.Collection<Object> values) {
		this._categories.addAll(values);
		return this;
	}

	public Properties removeCategories(Object value) {
		this._categories.remove(value);
		return this;
	}

	public Properties removeCategories(int index) {
		this._categories.remove(index);
		return this;
	}

	public java.util.List<Object> getCategories() {
		return this._categories;
	} 

	public Properties addAppenders(Object value) {
		this._appenders.add(value);
		return this;
	}

	public Properties setAppenders(Object[] value) {
		this._appenders.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Properties setAppenders(java.util.Collection<Object> values) {
		this._appenders.addAll(values);
		return this;
	}

	public Properties removeAppenders(Object value) {
		this._appenders.remove(value);
		return this;
	}

	public Properties removeAppenders(int index) {
		this._appenders.remove(index);
		return this;
	}

	public java.util.List<Object> getAppenders() {
		return this._appenders;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Properties that = (Properties) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "properties(logLevel,rootAppender,categories,appenders) ::= <<# Root logger option\n" + 
				"log4j.rootLogger=~logLevel~, ~rootAppender~\n" + 
				"\n" + 
				"~categories:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~appenders:{it|~it~};separator=\"\\n\\n\"~ >>";
}  