package nextgen.templates.maven;

public class Pom {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private DependencyManagement _dependencyManagement;
	private Build _build;
	private Object _packaging;
	private Object _version;
	private String _artifactId;
	private String _groupId;
	private String _name;
	private Object _parent;
	private java.util.List<Repository> _repositories = new java.util.ArrayList<>();
	private java.util.List<Object> _distributionManagement = new java.util.ArrayList<>();
	private java.util.List<Dependency> _dependencies = new java.util.ArrayList<>();
	private java.util.List<PomProperty> _properties = new java.util.ArrayList<>();
	private java.util.List<Object> _modules = new java.util.ArrayList<>();

	Pom(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("pom");
		st.add("dependencyManagement", _dependencyManagement);
		st.add("build", _build);
		st.add("packaging", _packaging);
		st.add("version", _version);
		st.add("artifactId", _artifactId);
		st.add("groupId", _groupId);
		st.add("name", _name);
		st.add("parent", _parent);
		for (Object o : _repositories) st.add("repositories", o);
		for (Object o : _distributionManagement) st.add("distributionManagement", o);
		for (Object o : _dependencies) st.add("dependencies", o);
		for (Object o : _properties) st.add("properties", o);
		for (Object o : _modules) st.add("modules", o);
		return st.render().trim();
	}

	public Pom setDependencyManagement(DependencyManagement value) {
		this._dependencyManagement = value;
		return this;
	}

	public DependencyManagement getDependencyManagement() {
		return this._dependencyManagement;
	}

	public DependencyManagement getDependencyManagement(DependencyManagement defaultValue) {
		return this._dependencyManagement == null ? defaultValue : this._dependencyManagement;
	}

	public boolean hasDependencyManagement() {
		return this._dependencyManagement != null;
	}

	public Pom removeDependencyManagement() {
		this._dependencyManagement = null;
		return this;
	} 

	public Pom setBuild(Build value) {
		this._build = value;
		return this;
	}

	public Build getBuild() {
		return this._build;
	}

	public Build getBuild(Build defaultValue) {
		return this._build == null ? defaultValue : this._build;
	}

	public boolean hasBuild() {
		return this._build != null;
	}

	public Pom removeBuild() {
		this._build = null;
		return this;
	} 

	public Pom setPackaging(Object value) {
		this._packaging = value;
		return this;
	}

	public Object getPackaging() {
		return this._packaging;
	}

	public Object getPackaging(Object defaultValue) {
		return this._packaging == null ? defaultValue : this._packaging;
	}

	public boolean hasPackaging() {
		return this._packaging != null;
	}

	public Pom removePackaging() {
		this._packaging = null;
		return this;
	} 

	public Pom setVersion(Object value) {
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

	public Pom removeVersion() {
		this._version = null;
		return this;
	} 

	public Pom setArtifactId(String value) {
		this._artifactId = value;
		return this;
	}

	public String getArtifactId() {
		return this._artifactId;
	}

	public String getArtifactId(String defaultValue) {
		return this._artifactId == null ? defaultValue : this._artifactId;
	}

	public boolean hasArtifactId() {
		return this._artifactId != null;
	}

	public Pom removeArtifactId() {
		this._artifactId = null;
		return this;
	} 

	public Pom setGroupId(String value) {
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

	public Pom removeGroupId() {
		this._groupId = null;
		return this;
	} 

	public Pom setName(String value) {
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

	public Pom removeName() {
		this._name = null;
		return this;
	} 

	public Pom setParent(Object value) {
		this._parent = value;
		return this;
	}

	public Object getParent() {
		return this._parent;
	}

	public Object getParent(Object defaultValue) {
		return this._parent == null ? defaultValue : this._parent;
	}

	public boolean hasParent() {
		return this._parent != null;
	}

	public Pom removeParent() {
		this._parent = null;
		return this;
	} 

	public Pom addRepositories(Repository value) {
		this._repositories.add(value);
		return this;
	}

	public Pom setRepositories(Repository[] value) {
		this._repositories.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pom setRepositories(java.util.Collection<Repository> values) {
		this._repositories.addAll(values);
		return this;
	}

	public Pom removeRepositories(Repository value) {
		this._repositories.remove(value);
		return this;
	}

	public Pom removeRepositories(int index) {
		this._repositories.remove(index);
		return this;
	}

	public java.util.List<Repository> getRepositories() {
		return this._repositories;
	} 

	public Pom addDistributionManagement(Object value) {
		this._distributionManagement.add(value);
		return this;
	}

	public Pom setDistributionManagement(Object[] value) {
		this._distributionManagement.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pom setDistributionManagement(java.util.Collection<Object> values) {
		this._distributionManagement.addAll(values);
		return this;
	}

	public Pom removeDistributionManagement(Object value) {
		this._distributionManagement.remove(value);
		return this;
	}

	public Pom removeDistributionManagement(int index) {
		this._distributionManagement.remove(index);
		return this;
	}

	public java.util.List<Object> getDistributionManagement() {
		return this._distributionManagement;
	} 

	public Pom addDependencies(Dependency value) {
		this._dependencies.add(value);
		return this;
	}

	public Pom setDependencies(Dependency[] value) {
		this._dependencies.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pom setDependencies(java.util.Collection<Dependency> values) {
		this._dependencies.addAll(values);
		return this;
	}

	public Pom removeDependencies(Dependency value) {
		this._dependencies.remove(value);
		return this;
	}

	public Pom removeDependencies(int index) {
		this._dependencies.remove(index);
		return this;
	}

	public java.util.List<Dependency> getDependencies() {
		return this._dependencies;
	} 

	public Pom addProperties(PomProperty value) {
		this._properties.add(value);
		return this;
	}

	public Pom setProperties(PomProperty[] value) {
		this._properties.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pom setProperties(java.util.Collection<PomProperty> values) {
		this._properties.addAll(values);
		return this;
	}

	public Pom removeProperties(PomProperty value) {
		this._properties.remove(value);
		return this;
	}

	public Pom removeProperties(int index) {
		this._properties.remove(index);
		return this;
	}

	public java.util.List<PomProperty> getProperties() {
		return this._properties;
	} 

	public Pom addModules(Object value) {
		this._modules.add(value);
		return this;
	}

	public Pom setModules(Object[] value) {
		this._modules.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pom setModules(java.util.Collection<Object> values) {
		this._modules.addAll(values);
		return this;
	}

	public Pom removeModules(Object value) {
		this._modules.remove(value);
		return this;
	}

	public Pom removeModules(int index) {
		this._modules.remove(index);
		return this;
	}

	public java.util.List<Object> getModules() {
		return this._modules;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pom that = (Pom) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "pom(repositories,distributionManagement,dependencies,dependencyManagement,build,properties,modules,packaging,version,artifactId,groupId,name,parent) ::= <<<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
				"<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" + 
				"~if(parent)~\n" + 
				"\n" + 
				"	~parent~\n" + 
				"~endif~	 \n" + 
				"	<modelVersion>4.0.0</modelVersion>\n" + 
				"\n" + 
				"	<name>~name~</name>\n" + 
				"\n" + 
				"	~if(groupId)~<groupId>~groupId~</groupId>~endif~\n" + 
				"	~if(artifactId)~<artifactId>~artifactId~</artifactId>~endif~\n" + 
				"	~if(version)~<version>~version~</version>~endif~\n" + 
				"	~if(packaging)~<packaging>~packaging~</packaging>~endif~\n" + 
				"\n" + 
				"~if(modules)~\n" + 
				"	<modules>\n" + 
				"		~modules:{it|<module>~it~</module>};separator=\"\\n\"~\n" + 
				"	</modules>\n" + 
				"~endif~\n" + 
				"~if(properties)~\n" + 
				"	<properties>\n" + 
				"		~properties:{it|~it~};separator=\"\\n\"~		\n" + 
				"	</properties>\n" + 
				"~endif~\n" + 
				"~if(build)~\n" + 
				"\n" + 
				"	~build~\n" + 
				"\n" + 
				"~endif~\n" + 
				"~if(dependencyManagement)~\n" + 
				"	~dependencyManagement~\n" + 
				"~endif~\n" + 
				"~if(dependencies)~\n" + 
				"\n" + 
				"	<dependencies>\n" + 
				"		~dependencies:{it|~it~};separator=\"\\n\"~  \n" + 
				"	</dependencies>\n" + 
				"\n" + 
				"~endif~\n" + 
				"~if(distributionManagement)~\n" + 
				"\n" + 
				"	<distributionManagement>\n" + 
				"		~distributionManagement:{it|~it~};separator=\"\\n\"~\n" + 
				"	</distributionManagement>\n" + 
				"~endif~\n" + 
				"~if(repositories)~\n" + 
				"\n" + 
				"	<repositories>\n" + 
				"		~repositories:{it|~it~};separator=\"\\n\"~\n" + 
				"	</repositories>\n" + 
				"~endif~\n" + 
				"</project> >>";
}  