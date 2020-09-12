package nextgen.templates.log4j;

public class Category {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _logLevel;
	private Object _appender;

	Category(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("category");
		st.add("className", _className);
		st.add("logLevel", _logLevel);
		st.add("appender", _appender);
		return st.render().trim();
	}

	public Category setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public Category removeClassName() {
		this._className = null;
		return this;
	} 

	public Category setLogLevel(Object value) {
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

	public Category removeLogLevel() {
		this._logLevel = null;
		return this;
	} 

	public Category setAppender(Object value) {
		this._appender = value;
		return this;
	}

	public Object getAppender() {
		return this._appender;
	}

	public Object getAppender(Object defaultValue) {
		return this._appender == null ? defaultValue : this._appender;
	}

	public boolean hasAppender() {
		return this._appender != null;
	}

	public Category removeAppender() {
		this._appender = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Category that = (Category) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "category(className,logLevel,appender) ::= <<log4j.category.~className~ = ~logLevel~, ~appender~ >>";
}  