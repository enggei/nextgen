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

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DependencyGroup");
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

	static final String st = "DependencyGroup(name,groupId,version,artifacts) ::= <<Name ~name~\n" + 
				"GroupId ~groupId~\n" + 
				"Version ~version~\n" + 
				"\n" + 
				"~artifacts:{it|~it~};separator=\"\\n\"~>> ";
} 