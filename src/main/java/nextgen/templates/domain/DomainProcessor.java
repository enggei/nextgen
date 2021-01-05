package nextgen.templates.domain;

public class DomainProcessor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _i;
	private Object _packageName;
	private String _name;
	private java.util.List<Object> _domains = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _transforms = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _parameters = new java.util.ArrayList<>();

	DomainProcessor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainProcessor");
		st.add("i", _i);
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _domains) st.add("domains", o);
		for (java.util.Map<String, Object> map : _transforms) st.addAggr("transforms.{writeJavaFile,name,type}", map.get("writeJavaFile"), map.get("name"), map.get("type"));
		for (java.util.Map<String, Object> map : _parameters) st.addAggr("parameters.{defaultValue,name}", map.get("defaultValue"), map.get("name"));
		return st.render().trim();
	}

	public DomainProcessor setI(Object value) {
		this._i = value;
		return this;
	}

	public Object getI() {
		return this._i;
	}

	public Object getI(Object defaultValue) {
		return this._i == null ? defaultValue : this._i;
	}

	public boolean hasI() {
		return this._i != null;
	}

	public DomainProcessor removeI() {
		this._i = null;
		return this;
	} 

	public DomainProcessor setPackageName(Object value) {
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

	public DomainProcessor removePackageName() {
		this._packageName = null;
		return this;
	} 

	public DomainProcessor setName(String value) {
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

	public DomainProcessor removeName() {
		this._name = null;
		return this;
	} 

	public DomainProcessor addDomains(Object value) {
		this._domains.add(value);
		return this;
	}

	public DomainProcessor setDomains(Object[] value) {
		this._domains.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainProcessor setDomains(java.util.Collection<Object> values) {
		this._domains.addAll(values);
		return this;
	}

	public DomainProcessor removeDomains(Object value) {
		this._domains.remove(value);
		return this;
	}

	public DomainProcessor removeDomains(int index) {
		this._domains.remove(index);
		return this;
	}

	public java.util.List<Object> getDomains() {
		return this._domains;
	} 

	public DomainProcessor setTransforms(java.util.Collection<DomainProcessor_Transforms> values) {
			this._transforms.clear();
			values.stream().map(DomainProcessor_Transforms::asMap).forEach(map -> _transforms.add(map));
			return this;
		}

	public DomainProcessor addTransforms(Object _writeJavaFile, Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("writeJavaFile", _writeJavaFile);
		map.put("name", _name);
		map.put("type", _type);
		this._transforms.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTransforms() {
		return this._transforms;
	}

	public DomainProcessor addTransforms(DomainProcessor_Transforms value) {
		return addTransforms(value._writeJavaFile, value._name, value._type);
	}

	public java.util.stream.Stream<DomainProcessor_Transforms> streamTransforms() {
		return this._transforms.stream().map(DomainProcessor_Transforms::new);
	}

	public java.util.List<Object> getTransforms_WriteJavaFile() {
		return streamTransforms().map(DomainProcessor_Transforms::getWriteJavaFile).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getTransforms_Name() {
		return streamTransforms().map(DomainProcessor_Transforms::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getTransforms_Type() {
		return streamTransforms().map(DomainProcessor_Transforms::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainProcessor_Transforms {

		Object _writeJavaFile;
		Object _name;
		Object _type;

		public DomainProcessor_Transforms(Object _writeJavaFile, Object _name, Object _type) {
			this._writeJavaFile = _writeJavaFile;
			this._name = _name;
			this._type = _type;
		}

		private DomainProcessor_Transforms(java.util.Map<String, Object> map) {
			this._writeJavaFile = (Object) map.get("writeJavaFile");
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getWriteJavaFile() {
			return this._writeJavaFile;
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("writeJavaFile", _writeJavaFile);
			map.put("name", _name);
			map.put("type", _type);
			return map;
		}

	}  

	public DomainProcessor setParameters(java.util.Collection<DomainProcessor_Parameters> values) {
			this._parameters.clear();
			values.stream().map(DomainProcessor_Parameters::asMap).forEach(map -> _parameters.add(map));
			return this;
		}

	public DomainProcessor addParameters(Object _defaultValue, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("defaultValue", _defaultValue);
		map.put("name", _name);
		this._parameters.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParameters() {
		return this._parameters;
	}

	public DomainProcessor addParameters(DomainProcessor_Parameters value) {
		return addParameters(value._defaultValue, value._name);
	}

	public java.util.stream.Stream<DomainProcessor_Parameters> streamParameters() {
		return this._parameters.stream().map(DomainProcessor_Parameters::new);
	}

	public java.util.List<Object> getParameters_DefaultValue() {
		return streamParameters().map(DomainProcessor_Parameters::getDefaultValue).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getParameters_Name() {
		return streamParameters().map(DomainProcessor_Parameters::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainProcessor_Parameters {

		Object _defaultValue;
		Object _name;

		public DomainProcessor_Parameters(Object _defaultValue, Object _name) {
			this._defaultValue = _defaultValue;
			this._name = _name;
		}

		private DomainProcessor_Parameters(java.util.Map<String, Object> map) {
			this._defaultValue = (Object) map.get("defaultValue");
			this._name = (Object) map.get("name");
		}

		public Object getDefaultValue() {
			return this._defaultValue;
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("defaultValue", _defaultValue);
			map.put("name", _name);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainProcessor that = (DomainProcessor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainProcessor(i,transforms,parameters,domains,packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import domain.meta.*;\n" + 
				"import nextgen.st.STGenerator;\n" + 
				"import nextgen.templates.domain.*;\n" + 
				"\n" + 
				"import java.util.*;\n" + 
				"\n" + 
				"import static domain.meta.MetaDomain.Quantifier.*;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"   ~domains:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	public static MetaDomainFactory newDomain(String name) {\n" + 
				"		return new MetaDomainFactoryImpl(name);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static MetaDomain.MetaProperty enumerate(MetaDomainFactory domain, String value) {\n" + 
				"		return domain.newMetaProperty(value);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static MetaDomainFactory.MetaPropertyBuilder many(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {\n" + 
				"		return domain.newMetaProperty(name)\n" + 
				"				.setquantifier(MANY)\n" + 
				"				.settype(type)\n" + 
				"				.settypeDeclaration(typeDeclaration);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static MetaDomainFactory.MetaPropertyBuilder many(MetaDomainFactory domain, String name, String type) {\n" + 
				"		return many(domain, name, type, null);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static MetaDomain.MetaProperty single(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {\n" + 
				"		return domain.newMetaProperty(name)\n" + 
				"				.setname(name)\n" + 
				"				.setquantifier(ONE)\n" + 
				"				.settype(type)\n" + 
				"				.settypeDeclaration(typeDeclaration);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static MetaDomain.MetaProperty single(MetaDomainFactory domain, String name, String type) {\n" + 
				"		return single(domain, name, type, null);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static MetaDomain.MetaProperty optional(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {\n" + 
				"		return domain.newMetaProperty(name)\n" + 
				"				.setname(name)\n" + 
				"				.setquantifier(OPTIONAL)\n" + 
				"				.settype(type)\n" + 
				"				.settypeDeclaration(typeDeclaration);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static MetaDomain.MetaProperty optional(MetaDomainFactory domain, String name, String type) {\n" + 
				"		return optional(domain, name, type, null);\n" + 
				"	}\n" + 
				"\n" + 
				"   interface DomainTransformer<T> {\n" + 
				"\n" + 
				"      T transform(MetaDomain domain);\n" + 
				"   }\n" + 
				"\n" + 
				"   ~TemplateTransformer()~\n" + 
				"\n" + 
				"   public static void main(String[] args) {\n" + 
				"\n" + 
				"		final String root = args.length <= 0 ? \"./src/main/java\" : args[0];\n" + 
				"		~parameters:{it|final String ~it.name~ = args.length <= ~i~ ? ~if(it.defaultValue)~~it.defaultValue~~else~\"./src/main/java\"~endif~ : args[~i~];};separator=\"\\n\"~\n" + 
				"		\n" + 
				"		final MetaDomain metaDomain = nextgenDomain();\n" + 
				"		\n" + 
				"~transforms:{it|\n" + 
				"		final ~it.type~ ~it.type;format=\"lowFirst\"~ = new ~it.name~(~parameters:{it|~it.name~};separator=\", \"~).transform(metaDomain);~if(it.writeJavaFile)~\n" + 
				"		STGenerator.writeJavaFile(~it.type;format=\"lowFirst\"~, ~it.type;format=\"lowFirst\"~.getPackageName().toString(), ~it.type;format=\"lowFirst\"~.getName(), root);\n" + 
				"~endif~};separator=\"\\n\"~\n" + 
				"   }	\n" + 
				"} >>";
}  