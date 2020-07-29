package nextgen.templates.apachepoi;

public class Dependency {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _version;

	Dependency(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("dependency");
		st.add("version", _version);
		return st.render().trim();
	}

	public Dependency setVersion(Object value) {
		this._version = value;
		return this;
	}

	public Object getVersion() {
		return this._version;
	}

	public Object getVersion(Object defaultValue) {
		return this._version == null ? defaultValue : this._version;
	}

	public boolean hasVersion() {
		return this._version != null;
	}

	public Dependency removeVersion() {
		this._version = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dependency that = (Dependency) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "dependency(version) ::= <<<dependency>\n" + 
				"	<groupId>org.apache.poi</groupId>\n" + 
				"	<artifactId>poi</artifactId>\n" + 
				"	<version>~if(version)~~version~~else~3.17~endif~</version>\n" + 
				"</dependency>\n" + 
				"<dependency>\n" + 
				"	<groupId>org.apache.poi</groupId>\n" + 
				"	<artifactId>poi-ooxml</artifactId>\n" + 
				"	<version>~if(version)~~version~~else~3.17~endif~</version>\n" + 
				"</dependency> >>";
}  