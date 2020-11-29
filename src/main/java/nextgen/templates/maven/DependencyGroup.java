package nextgen.templates.maven;

public class DependencyGroup {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _groupId;
	private Object _version;
	private java.util.List<Object> _artifacts = new java.util.ArrayList<>();

	DependencyGroup(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("dependencyGroup");
		st.add("name", _name);
		st.add("groupId", _groupId);
		st.add("version", _version);
		for (Object o : _artifacts) st.add("artifacts", o);
		return st.render().trim();
	}

	public DependencyGroup setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public DependencyGroup removeName() {
		this._name = null;
		return this;
	} 

	public DependencyGroup setGroupId(Object value) {
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

	public DependencyGroup removeGroupId() {
		this._groupId = null;
		return this;
	} 

	public DependencyGroup setVersion(Object value) {
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

	public DependencyGroup removeVersion() {
		this._version = null;
		return this;
	} 

	public DependencyGroup addArtifacts(Object value) {
		this._artifacts.add(value);
		return this;
	}

	public DependencyGroup setArtifacts(Object[] value) {
		this._artifacts.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DependencyGroup setArtifacts(java.util.Collection<Object> values) {
		this._artifacts.addAll(values);
		return this;
	}

	public DependencyGroup removeArtifacts(Object value) {
		this._artifacts.remove(value);
		return this;
	}

	public DependencyGroup removeArtifacts(int index) {
		this._artifacts.remove(index);
		return this;
	}

	public java.util.List<Object> getArtifacts() {
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

	static final String st = "dependencyGroup(name,groupId,version,artifacts) ::= <<~name~\n" + 
				"~groupId~\n" + 
				"~version~\n" + 
				"~artifacts:{it|~it~};separator=\"\\n\"~ >>";
}  