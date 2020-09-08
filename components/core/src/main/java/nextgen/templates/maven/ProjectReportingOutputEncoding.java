package nextgen.templates.maven;

public class ProjectReportingOutputEncoding implements PomProperty {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _value;

	ProjectReportingOutputEncoding(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ProjectReportingOutputEncoding");
		st.add("value", _value);
		return st.render().trim();
	}

	public ProjectReportingOutputEncoding setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public ProjectReportingOutputEncoding removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProjectReportingOutputEncoding that = (ProjectReportingOutputEncoding) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ProjectReportingOutputEncoding(value) ::= <<<project.reporting.outputEncoding>~if(value)~~value~~else~UTF-8~endif~</project.reporting.outputEncoding> >>";
}  