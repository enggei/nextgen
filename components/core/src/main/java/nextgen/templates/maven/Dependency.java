package nextgen.templates.maven;

public class Dependency {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _groupId;
	private Object _artifactId;
	private Object _version;
	private DependencyScope _scope;
	private Object _systemPath;
	private Object _classifier;
	private Object _type;

	Dependency(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("dependency");
		st.add("groupId", _groupId);
		st.add("artifactId", _artifactId);
		st.add("version", _version);
		st.add("scope", _scope);
		st.add("systemPath", _systemPath);
		st.add("classifier", _classifier);
		st.add("type", _type);
		return st.render().trim();
	}

	public Dependency setGroupId(Object value) {
		this._groupId = value;
		return this;
	}

	public Object getGroupId() {
		return this._groupId;
	}

	public Object getGroupId(Object defaultValue) {
		return this._groupId == null ? defaultValue : this._groupId;
	}

	public boolean hasGroupId() {
		return this._groupId != null;
	}

	public Dependency removeGroupId() {
		this._groupId = null;
		return this;
	} 

	public Dependency setArtifactId(Object value) {
		this._artifactId = value;
		return this;
	}

	public Object getArtifactId() {
		return this._artifactId;
	}

	public Object getArtifactId(Object defaultValue) {
		return this._artifactId == null ? defaultValue : this._artifactId;
	}

	public boolean hasArtifactId() {
		return this._artifactId != null;
	}

	public Dependency removeArtifactId() {
		this._artifactId = null;
		return this;
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

	public Dependency setScope(DependencyScope value) {
		this._scope = value;
		return this;
	}

	public DependencyScope getScope() {
		return this._scope;
	}

	public DependencyScope getScope(DependencyScope defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public Dependency removeScope() {
		this._scope = null;
		return this;
	} 

	public Dependency setSystemPath(Object value) {
		this._systemPath = value;
		return this;
	}

	public Object getSystemPath() {
		return this._systemPath;
	}

	public Object getSystemPath(Object defaultValue) {
		return this._systemPath == null ? defaultValue : this._systemPath;
	}

	public boolean hasSystemPath() {
		return this._systemPath != null;
	}

	public Dependency removeSystemPath() {
		this._systemPath = null;
		return this;
	} 

	public Dependency setClassifier(Object value) {
		this._classifier = value;
		return this;
	}

	public Object getClassifier() {
		return this._classifier;
	}

	public Object getClassifier(Object defaultValue) {
		return this._classifier == null ? defaultValue : this._classifier;
	}

	public boolean hasClassifier() {
		return this._classifier != null;
	}

	public Dependency removeClassifier() {
		this._classifier = null;
		return this;
	} 

	public Dependency setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public Dependency removeType() {
		this._type = null;
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

	static final String st = "dependency(groupId,artifactId,version,scope,systemPath,classifier,type) ::= <<<dependency>\n" + 
				"	<groupId>~groupId~</groupId>\n" + 
				"	<artifactId>~artifactId~</artifactId>~if(version)~\n" + 
				"	<version>~version~</version>~endif~~if(scope)~\n" + 
				"	<scope>~scope~</scope>~endif~~if(systemPath)~\n" + 
				"	<systemPath>~systemPath~</systemPath>~endif~~if(classifier)~\n" + 
				"	<classifier>~classifier~</classifier>~endif~~if(type)~\n" + 
				"	<type>~type~</type>~endif~\n" + 
				"	\n" + 
				"</dependency> >>";
}  