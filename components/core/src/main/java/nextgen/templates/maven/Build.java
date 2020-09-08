package nextgen.templates.maven;

public class Build {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _plugin = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _testResources = new java.util.ArrayList<>();

	Build(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("build");
		for (Object o : _plugin) st.add("plugin", o);
		for (java.util.Map<String, Object> map : _testResources) st.addAggr("testResources.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}


	public Build addPlugin(Object value) {
		this._plugin.add(value);
		return this;
	}

	public Build setPlugin(Object[] value) {
		this._plugin.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Build setPlugin(java.util.Collection<Object> values) {
		this._plugin.addAll(values);
		return this;
	}

	public Build removePlugin(Object value) {
		this._plugin.remove(value);
		return this;
	}

	public Build removePlugin(int index) {
		this._plugin.remove(index);
		return this;
	}

	public java.util.List<Object> getPlugin() {
		return this._plugin;
	} 

	public Build addTestResources(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._testResources.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTestResources() {
		return this._testResources;
	}

	public Build addTestResources(Build_TestResources value) {
		return addTestResources(value._name, value._value);
	}

	public java.util.stream.Stream<Build_TestResources> streamTestResources() {
		return this._testResources.stream().map(Build_TestResources::new);
	}

	public static final class Build_TestResources {

		Object _name;
		Object _value;

		public Build_TestResources(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Build_TestResources(java.util.Map<String, Object> map) {
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
		Build that = (Build) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "build(testResources,plugin) ::= <<<build>\n" + 
				"~if(testResources)~\n" + 
				"	<testResources>\n" + 
				"		<testResource>\n" + 
				"			~testResources:{it|<~it.name~>~it.value~</~it.name~>};separator=\"\\n\"~\n" + 
				"		</testResource>\n" + 
				"	</testResources>\n" + 
				"~endif~\n" + 
				"	<plugins>\n" + 
				"		~plugin:{it|~it~};separator=\"\\n\"~\n" + 
				"	</plugins>\n" + 
				"</build> >>";
}  