package nextgen.templates.maven;

public class DependencyGroup {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _groupId;
	private String _version;
	private java.util.List<String> _artifacts = new java.util.ArrayList<>();

	DependencyGroup(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DependencyGroup");
		st.add("name", _name);
		st.add("groupId", _groupId);
		st.add("version", _version);
		for (Object o : _artifacts) st.add("artifacts", o);
		return st.render().trim();
	}

	public DependencyGroup setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public DependencyGroup removeName() {
		this._name = null;
		return this;
	} 

	public DependencyGroup setGroupId(String value) {
		this._groupId = value;
		return this;
	}

	public String getGroupId() {
		return this._groupId;
	}

	public String getGroupId(String defaultValue) {
		return this._groupId == null ? defaultValue : this._groupId;
	}

	public boolean hasGroupId() {
		return this._groupId != null;
	}

	public DependencyGroup removeGroupId() {
		this._groupId = null;
		return this;
	} 

	public DependencyGroup setVersion(String value) {
		this._version = value;
		return this;
	}

	public String getVersion() {
		return this._version;
	}

	public String getVersion(String defaultValue) {
		return this._version == null ? defaultValue : this._version;
	}

	public boolean hasVersion() {
		return this._version != null;
	}

	public DependencyGroup removeVersion() {
		this._version = null;
		return this;
	} 

	public DependencyGroup addArtifacts(String value) {
		this._artifacts.add(value);
		return this;
	}

	public DependencyGroup setArtifacts(String[] value) {
		this._artifacts.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DependencyGroup setArtifacts(java.util.Collection<String> values) {
		this._artifacts.addAll(values);
		return this;
	}

	public DependencyGroup removeArtifacts(String value) {
		this._artifacts.remove(value);
		return this;
	}

	public DependencyGroup removeArtifacts(int index) {
		this._artifacts.remove(index);
		return this;
	}

	public java.util.List<String> getArtifacts() {
		return this._artifacts;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DependencyGroup that = (DependencyGroup) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DependencyGroup(name,groupId,version,artifacts) ::= <<Name ~name~\n" + 
				"GroupId ~groupId~\n" + 
				"Version ~version~\n" + 
				"\n" + 
				"~artifacts:{it|~it~};separator=\"\\n\"~ >>";
} 