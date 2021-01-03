package nextgen.templates.domain;

public class DomainProcessor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private String _name;
	private java.util.List<Object> _domains = new java.util.ArrayList<>();
	private java.util.List<Object> _transformers = new java.util.ArrayList<>();

	DomainProcessor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainProcessor");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _domains) st.add("domains", o);
		for (Object o : _transformers) st.add("transformers", o);
		return st.render().trim();
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

	public DomainProcessor addTransformers(Object value) {
		this._transformers.add(value);
		return this;
	}

	public DomainProcessor setTransformers(Object[] value) {
		this._transformers.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainProcessor setTransformers(java.util.Collection<Object> values) {
		this._transformers.addAll(values);
		return this;
	}

	public DomainProcessor removeTransformers(Object value) {
		this._transformers.remove(value);
		return this;
	}

	public DomainProcessor removeTransformers(int index) {
		this._transformers.remove(index);
		return this;
	}

	public java.util.List<Object> getTransformers() {
		return this._transformers;
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

	static final String st = "DomainProcessor(domains,transformers,packageName,name) ::= <<package ~packageName~;\n" + 
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
				"   public static void main(String[] args) {\n" + 
				"\n" + 
				"      final String root = \"/home/goe/projects/nextgen/src/main/java\";\n" + 
				"\n" + 
				"      write(newMetaDomain(), \"domain.meta\", root);\n" + 
				"      write(nextgenDomain(), \"domain.nextgen\", root);\n" + 
				"   }\n" + 
				"\n" + 
				"	~domains:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"   \n" + 
				"   private static MetaDomain nextgenDomain() {\n" + 
				"      final MetaDomainFactory domain = new MetaDomainFactoryImpl()\n" + 
				"            .setname(\"Nextgen\");\n" + 
				"      return domain\n" + 
				"            .addproperties(many(domain, \"projects\", \"STProject\", newDomain(\"STProject\")\n" + 
				"                  .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                  .addproperties(single(domain, \"root\", \"String\"))\n" + 
				"                  .addproperties(many(domain, \"models\", \"STModel\", newDomain(\"STModel\")\n" + 
				"                        .addproperties(single(domain, \"stTemplate\", \"STTemplate\"))\n" + 
				"                        .addproperties(many(domain, \"files\", \"STFile\", newDomain(\"STFile\")\n" + 
				"                              .addproperties(single(domain, \"type\", \"STValue\"))\n" + 
				"                              .addproperties(single(domain, \"packageName\", \"STValue\"))\n" + 
				"                              .addproperties(single(domain, \"path\", \"STValue\"))))\n" + 
				"                        .addproperties(many(domain, \"arguments\", \"STArgument\", newDomain(\"STArgument\")\n" + 
				"                              .addproperties(single(domain, \"stParameter\", \"STParameter\"))\n" + 
				"                              .addproperties(single(domain, \"value\", \"STValue\"))\n" + 
				"                              .addproperties(many(domain, \"keyValues\", \"STArgumentKV\", newDomain(\"STArgumentKV\")\n" + 
				"                                    .addproperties(single(domain, \"stParameterKey\", \"STParameterKey\"))\n" + 
				"                                    .addproperties(single(domain, \"values\", \"STValue\"))))))))\n" + 
				"                  .addproperties(many(domain, \"values\", \"STValue\", newDomain(\"STValue\")\n" + 
				"                        .addproperties(single(domain, \"type\", \"STValueType\", newDomain(\"STValueType\")\n" + 
				"                              .addproperties(enumerate(domain, \"STMODEL\"))\n" + 
				"                              .addproperties(enumerate(domain, \"PRIMITIVE\"))\n" + 
				"                              .addproperties(enumerate(domain, \"ENUM\"))))\n" + 
				"                        .addproperties(optional(domain, \"value\", \"String\"))\n" + 
				"                        .addproperties(optional(domain, \"stModel\", \"STModel\"))\n" + 
				"                        .addproperties(optional(domain, \"stEnum\", \"STEnumValue\"))))))\n" + 
				"            .addproperties(many(domain, \"groups\", \"STGroup\", newDomain(\"STGroup\")\n" + 
				"                  .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                  .addproperties(many(domain, \"files\", \"STGroupFile\", newDomain(\"STGroupFile\")\n" + 
				"                        .addproperties(single(domain, \"packageName\", \"STValue\"))\n" + 
				"                        .addproperties(single(domain, \"path\", \"STValue\"))))\n" + 
				"                  .addproperties(many(domain, \"templates\", \"STTemplate\", newDomain(\"STTemplate\")\n" + 
				"                        .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                        .addproperties(single(domain, \"text\", \"String\"))\n" + 
				"                        .addproperties(many(domain, \"interfaces\", \"STInterface\"))\n" + 
				"                        .addproperties(many(domain, \"parameter\", \"STParameter\", newDomain(\"STParameter\")\n" + 
				"                              .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                              .addproperties(single(domain, \"type\", \"STParameterType\", newDomain(\"STParameterType\")\n" + 
				"                                    .addproperties(enumerate(domain, \"SINGLE\"))\n" + 
				"                                    .addproperties(enumerate(domain, \"LIST\"))\n" + 
				"                                    .addproperties(enumerate(domain, \"KVLIST\"))))\n" + 
				"                              .addproperties(many(domain, \"keys\", \"STParameterKey\", newDomain(\"STParameterKey\")\n" + 
				"                                    .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                                    .addproperties(single(domain, \"argumentType\", \"STInterface\"))))\n" + 
				"                              .addproperties(single(domain, \"argumentType\", \"String\"))))\n" + 
				"                        .addproperties(many(domain, \"children\", \"STTemplate\"))))\n" + 
				"                  .addproperties(many(domain, \"interfaces\", \"STInterface\", newDomain(\"STInterface\")\n" + 
				"                        .addproperties(single(domain, \"name\", \"String\"))))\n" + 
				"                  .addproperties(many(domain, \"enums\", \"STEnum\", newDomain(\"STEnum\")\n" + 
				"                        .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                        .addproperties(many(domain, \"values\", \"STEnumValue\", newDomain(\"STEnumValue\")\n" + 
				"                              .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                              .addproperties(single(domain, \"lexical\", \"String\"))))))\n" + 
				"                  .addproperties(many(domain, \"actions\", \"STAction\", newDomain(\"STAction\")\n" + 
				"                        .addproperties(single(domain, \"name\", \"String\"))\n" + 
				"                        .addproperties(many(domain, \"statements\", \"String\"))\n" + 
				"                        .addproperties(many(domain, \"imports\", \"String\"))\n" + 
				"                        .addproperties(many(domain, \"methods\", \"String\"))))));\n" + 
				"   }\n" + 
				"\n" + 
				"	private static MetaDomainFactory newDomain(String name) {\n" + 
				"      return new MetaDomainFactoryImpl().setname(name);\n" + 
				"   }\n" + 
				"   \n" + 
				"   private static MetaDomain.MetaProperty enumerate(MetaDomainFactory domain, String value) {\n" + 
				"      return domain.newMetaProperty()\n" + 
				"            .setname(value);\n" + 
				"   }\n" + 
				"\n" + 
				"   private static MetaDomainFactory.MetaPropertyBuilder many(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {\n" + 
				"      return domain.newMetaProperty()\n" + 
				"            .setname(name)\n" + 
				"            .setquantifier(MANY)\n" + 
				"            .settype(type)\n" + 
				"            .settypeDeclaration(typeDeclaration);\n" + 
				"   }\n" + 
				"\n" + 
				"   private static MetaDomainFactory.MetaPropertyBuilder many(MetaDomainFactory domain, String name, String type) {\n" + 
				"      return many(domain, name, type, null);\n" + 
				"   }\n" + 
				"\n" + 
				"   private static MetaDomain.MetaProperty single(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {\n" + 
				"      return domain.newMetaProperty()\n" + 
				"            .setname(name)\n" + 
				"            .setquantifier(ONE)\n" + 
				"            .settype(type)\n" + 
				"            .settypeDeclaration(typeDeclaration);\n" + 
				"   }\n" + 
				"\n" + 
				"   private static MetaDomain.MetaProperty single(MetaDomainFactory domain, String name, String type) {\n" + 
				"      return single(domain, name, type, null);\n" + 
				"   }\n" + 
				"\n" + 
				"   private static MetaDomain.MetaProperty optional(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {\n" + 
				"      return domain.newMetaProperty()\n" + 
				"            .setname(name)\n" + 
				"            .setquantifier(OPTIONAL)\n" + 
				"            .settype(type)\n" + 
				"            .settypeDeclaration(typeDeclaration);\n" + 
				"   }\n" + 
				"\n" + 
				"   private static MetaDomain.MetaProperty optional(MetaDomainFactory domain, String name, String type) {\n" + 
				"      return optional(domain, name, type, null);\n" + 
				"   }\n" + 
				"\n" + 
				"   interface DomainTransformer<T> {\n" + 
				"\n" + 
				"      T transform(MetaDomain domain);\n" + 
				"   }\n" + 
				"\n" + 
				"   ~TemplateTransformer()~\n" + 
				"\n" + 
				"	~transformers:{it|~it~};separator=\"\\n\\n\"~    \n" + 
				"\n" + 
				"   private static void write(MetaDomain domain, String packageName, String root) {\n" + 
				"\n" + 
				"      final ToInterfaces toInterfaces = new ToInterfacesTransformer(packageName).transform(domain);\n" + 
				"      STGenerator.writeJavaFile(toInterfaces, toInterfaces.getPackageName().toString(), toInterfaces.getName(), root);\n" + 
				"\n" + 
				"      final ToFactory toFactory = new ToFactoryTransformer(packageName).transform(domain);\n" + 
				"      STGenerator.writeJavaFile(toFactory, toFactory.getPackageName().toString(), toFactory.getName(), root);\n" + 
				"\n" + 
				"      final nextgen.templates.domain.DefaultFactoryImpl toFactoryImpl = new InterfaceImpl(packageName).transform(domain);\n" + 
				"      STGenerator.writeJavaFile(toFactoryImpl, toFactoryImpl.getPackageName().toString(), toFactoryImpl.getName(), root);\n" + 
				"   }\n" + 
				"} >>";
}  