package nextgen.templates.maven;

public class Plugin {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _groupId;
	private Object _artifactId;
	private Object _version;
	private java.util.List<Object> _executions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _configuration = new java.util.ArrayList<>();

	Plugin(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("plugin");
		st.add("groupId", _groupId);
		st.add("artifactId", _artifactId);
		st.add("version", _version);
		for (Object o : _executions) st.add("executions", o);
		for (java.util.Map<String, Object> map : _configuration) st.addAggr("configuration.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public Plugin setGroupId(Object value) {
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

	public Plugin removeGroupId() {
		this._groupId = null;
		return this;
	}

	public Plugin setArtifactId(Object value) {
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

	public Plugin removeArtifactId() {
		this._artifactId = null;
		return this;
	}

	public Plugin setVersion(Object value) {
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

	public Plugin removeVersion() {
		this._version = null;
		return this;
	}

	public Plugin addExecutions(Object value) {
		this._executions.add(value);
		return this;
	}

	public Plugin setExecutions(Object[] value) {
		this._executions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Plugin setExecutions(java.util.Collection<Object> values) {
		this._executions.addAll(values);
		return this;
	}

	public Plugin removeExecutions(Object value) {
		this._executions.remove(value);
		return this;
	}

	public Plugin removeExecutions(int index) {
		this._executions.remove(index);
		return this;
	}

	public java.util.List<Object> getExecutions() {
		return this._executions;
	}

	public Plugin addConfiguration(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._configuration.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getConfiguration() {
		return this._configuration;
	}

	public Plugin addConfiguration(Plugin_Configuration value) {
		return addConfiguration(value._name, value._value);
	}

	public java.util.stream.Stream<Plugin_Configuration> streamConfiguration() {
		return this._configuration.stream().map(Plugin_Configuration::new);
	}

	public static final class Plugin_Configuration {

		Object _name;
		Object _value;

		public Plugin_Configuration(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Plugin_Configuration(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Plugin that = (Plugin) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "plugin(groupId,artifactId,version,configuration,executions) ::= <<<plugin>\n" + 
				"	<groupId>~groupId~</groupId>\n" + 
				"	<artifactId>~artifactId~</artifactId>\n" + 
				"	<version>~version~</version>\n" + 
				"	<configuration>\n" + 
				"		~configuration:{it|<~it.name~>~it.value~</~it.name~>};separator=\"\\n\"~\n" + 
				"	</configuration>\n" + 
				"	<executions>\n" + 
				"		~executions:{it|~it~};separator=\"\\n\"~\n" + 
				"	</executions>\n" + 
				"</plugin> >>";
} 