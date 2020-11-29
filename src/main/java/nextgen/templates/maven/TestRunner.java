package nextgen.templates.maven;

public class TestRunner {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _projectName;
	private java.util.List<java.util.Map<String, Object>> _generators = new java.util.ArrayList<>();

	TestRunner(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TestRunner");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("projectName", _projectName);
		for (java.util.Map<String, Object> map : _generators) st.addAggr("generators.{name,run}", map.get("name"), map.get("run"));
		return st.render().trim();
	}

	public TestRunner setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public TestRunner removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TestRunner setName(Object value) {
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

	public TestRunner removeName() {
		this._name = null;
		return this;
	} 

	public TestRunner setProjectName(Object value) {
		this._projectName = value;
		return this;
	}

	public Object getProjectName() {
		return this._projectName;
	}

	public Object getProjectName(Object defaultValue) {
		return this._projectName == null ? defaultValue : this._projectName;
	}

	public boolean hasProjectName() {
		return this._projectName != null;
	}

	public TestRunner removeProjectName() {
		this._projectName = null;
		return this;
	} 


	public TestRunner addGenerators(Object _name, Object _run) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("run", _run);
		this._generators.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getGenerators() {
		return this._generators;
	}

	public TestRunner addGenerators(TestRunner_Generators value) {
		return addGenerators(value._name, value._run);
	}

	public java.util.stream.Stream<TestRunner_Generators> streamGenerators() {
		return this._generators.stream().map(TestRunner_Generators::new);
	}

	public java.util.List<Object> getGenerators_Name() {
		return streamGenerators().map(TestRunner_Generators::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getGenerators_Run() {
		return streamGenerators().map(TestRunner_Generators::getRun).collect(java.util.stream.Collectors.toList());
	}


	public static final class TestRunner_Generators {

		Object _name;
		Object _run;

		public TestRunner_Generators(Object _name, Object _run) {
			this._name = _name;
			this._run = _run;
		}

		private TestRunner_Generators(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._run = (Object) map.get("run");
		}

		public Object getName() {
			return this._name;
		}

		public Object getRun() {
			return this._run;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TestRunner that = (TestRunner) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TestRunner(packageName,name,projectName,generators) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ extends ~projectName~ {\n" + 
				"\n" + 
				"~generators:{it|\n" + 
				"	@Override\n" + 
				"	public void ~it.name~() {\n" + 
				"		~if(it.run)~super.~it.name~();~endif~\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	public static void main(String[] args) {\n" + 
				"		final org.junit.runner.JUnitCore junit = new org.junit.runner.JUnitCore();\n" + 
				"		junit.addListener(new org.junit.internal.TextListener(System.out));\n" + 
				"		final org.junit.runner.Result result = junit.run(~name~.class);\n" + 
				"		for (org.junit.runner.notification.Failure failure : result.getFailures()) {\n" + 
				"			System.out.println(failure.toString());\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  