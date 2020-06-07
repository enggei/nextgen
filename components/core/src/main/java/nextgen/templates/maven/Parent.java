package nextgen.templates.maven;

public class Parent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _artifactId;
	private Object _groupId;
	private Object _version;

	Parent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Parent that = (Parent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("parent");
		st.add("artifactId" ,_artifactId);
		st.add("groupId" ,_groupId);
		st.add("version" ,_version);
		return st.render().trim();
	}

	public Parent setArtifactId(Object value) {
		this._artifactId = value;
		return this;
	}

	public Object getArtifactId() {
		return this._artifactId;
	}

	public boolean hasArtifactId() {
		return this._artifactId != null;
	}

	public Parent removeArtifactId() {
		this._artifactId = null;
		return this;
	} 

	public Parent setGroupId(Object value) {
		this._groupId = value;
		return this;
	}

	public Object getGroupId() {
		return this._groupId;
	}

	public boolean hasGroupId() {
		return this._groupId != null;
	}

	public Parent removeGroupId() {
		this._groupId = null;
		return this;
	} 

	public Parent setVersion(Object value) {
		this._version = value;
		return this;
	}

	public Object getVersion() {
		return this._version;
	}

	public boolean hasVersion() {
		return this._version != null;
	}

	public Parent removeVersion() {
		this._version = null;
		return this;
	} 

	static final String st = "parent(artifactId,groupId,version) ::= <<<parent>\n" + 
				"	<artifactId>~artifactId~</artifactId>\n" + 
				"	<groupId>~groupId~</groupId>\n" + 
				"	<version>~version~</version>\n" + 
				"</parent> >> ";
} 