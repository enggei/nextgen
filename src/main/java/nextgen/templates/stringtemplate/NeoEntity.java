package nextgen.templates.stringtemplate;

public class NeoEntity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _stTemplate;
	private Object _name;
	private Object _stGroupModel;
	private Object _package;
	private java.util.List<Object> _singleAccessors = new java.util.ArrayList<>();
	private java.util.List<Object> _listAccessors = new java.util.ArrayList<>();
	private java.util.List<Object> _kvAccessors = new java.util.ArrayList<>();

	NeoEntity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NeoEntity");
		st.add("stTemplate", _stTemplate);
		st.add("name", _name);
		st.add("stGroupModel", _stGroupModel);
		st.add("package", _package);
		for (Object o : _singleAccessors) st.add("singleAccessors", o);
		for (Object o : _listAccessors) st.add("listAccessors", o);
		for (Object o : _kvAccessors) st.add("kvAccessors", o);
		return st.render().trim();
	}

	public NeoEntity setStTemplate(Object value) {
		this._stTemplate = value;
		return this;
	}

	public Object getStTemplate() {
		return this._stTemplate;
	}

	public Object getStTemplate(Object defaultValue) {
		return this._stTemplate == null ? defaultValue : this._stTemplate;
	}

	public boolean hasStTemplate() {
		return this._stTemplate != null;
	}

	public NeoEntity removeStTemplate() {
		this._stTemplate = null;
		return this;
	} 

	public NeoEntity setName(Object value) {
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

	public NeoEntity removeName() {
		this._name = null;
		return this;
	} 

	public NeoEntity setStGroupModel(Object value) {
		this._stGroupModel = value;
		return this;
	}

	public Object getStGroupModel() {
		return this._stGroupModel;
	}

	public Object getStGroupModel(Object defaultValue) {
		return this._stGroupModel == null ? defaultValue : this._stGroupModel;
	}

	public boolean hasStGroupModel() {
		return this._stGroupModel != null;
	}

	public NeoEntity removeStGroupModel() {
		this._stGroupModel = null;
		return this;
	} 

	public NeoEntity setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public Object getPackage(Object defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public NeoEntity removePackage() {
		this._package = null;
		return this;
	} 

	public NeoEntity addSingleAccessors(Object value) {
		this._singleAccessors.add(value);
		return this;
	}

	public NeoEntity setSingleAccessors(Object[] value) {
		this._singleAccessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NeoEntity setSingleAccessors(java.util.Collection<Object> values) {
		this._singleAccessors.addAll(values);
		return this;
	}

	public NeoEntity removeSingleAccessors(Object value) {
		this._singleAccessors.remove(value);
		return this;
	}

	public NeoEntity removeSingleAccessors(int index) {
		this._singleAccessors.remove(index);
		return this;
	}

	public java.util.List<Object> getSingleAccessors() {
		return this._singleAccessors;
	} 

	public NeoEntity addListAccessors(Object value) {
		this._listAccessors.add(value);
		return this;
	}

	public NeoEntity setListAccessors(Object[] value) {
		this._listAccessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NeoEntity setListAccessors(java.util.Collection<Object> values) {
		this._listAccessors.addAll(values);
		return this;
	}

	public NeoEntity removeListAccessors(Object value) {
		this._listAccessors.remove(value);
		return this;
	}

	public NeoEntity removeListAccessors(int index) {
		this._listAccessors.remove(index);
		return this;
	}

	public java.util.List<Object> getListAccessors() {
		return this._listAccessors;
	} 

	public NeoEntity addKvAccessors(Object value) {
		this._kvAccessors.add(value);
		return this;
	}

	public NeoEntity setKvAccessors(Object[] value) {
		this._kvAccessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NeoEntity setKvAccessors(java.util.Collection<Object> values) {
		this._kvAccessors.addAll(values);
		return this;
	}

	public NeoEntity removeKvAccessors(Object value) {
		this._kvAccessors.remove(value);
		return this;
	}

	public NeoEntity removeKvAccessors(int index) {
		this._kvAccessors.remove(index);
		return this;
	}

	public java.util.List<Object> getKvAccessors() {
		return this._kvAccessors;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NeoEntity that = (NeoEntity) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NeoEntity(stTemplate,singleAccessors,name,stGroupModel,listAccessors,kvAccessors,package) ::= <<package ~package~;\n" + 
				"\n" + 
				"import nextgen.st.model.*;\n" + 
				"import nextgen.st.domain.*;\n" + 
				"\n" + 
				"import java.util.ArrayList;\n" + 
				"import java.util.Collection;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.concurrent.atomic.AtomicReference;\n" + 
				"import java.util.stream.Stream;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	public static final String stGroupModelUuid = \"~stGroupModel~\";\n" + 
				"	public static final String stTemplateUuid = \"~stTemplate~\";\n" + 
				"\n" + 
				"	private final STModelDB db;\n" + 
				"	private final STModel stModel;\n" + 
				"	private final STTemplate stTemplate;\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(STModelDB db) {\n" + 
				"		this.db = db;\n" + 
				"		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);\n" + 
				"		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(STModelDB db, STModel stModel) {\n" + 
				"		this.db = db;\n" + 
				"		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);\n" + 
				"		this.stModel = stModel;\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(STModelDB db, org.neo4j.graphdb.Node node) {\n" + 
				"		this.db = db;\n" + 
				"		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);\n" + 
				"		this.stModel = this.db.newSTModel(node);\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(STModelDB db, String uuid) {\n" + 
				"		this.db = db;\n" + 
				"		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);\n" + 
				"		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		~name;format=\"capitalize\"~ that = (~name;format=\"capitalize\"~) o;\n" + 
				"		return stModel.equals(that.stModel);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return java.util.Objects.hash(stModel);\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getUuid() {\n" + 
				"		return stModel.getUuid();\n" + 
				"	}\n" + 
				"\n" + 
				"	public STValue asSTValue () {\n" + 
				"		return db.newSTValue(stModel);\n" + 
				"	}\n" + 
				"\n" + 
				"	~singleAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~listAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~kvAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private ~name;format=\"capitalize\"~ set(STValue value, String name) {\n" + 
				"		findParameter(name)\n" + 
				"				.ifPresent(stParameter -> {\n" + 
				"\n" + 
				"					stModel.getArguments()\n" + 
				"							.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" + 
				"							.findAny()\n" + 
				"							.ifPresent(stModel::removeArguments);\n" + 
				"\n" + 
				"					stModel.addArguments(db.newSTArgument(stParameter, value));\n" + 
				"				});\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	private STValue get(String name) {\n" + 
				"		final AtomicReference<STValue> value = new AtomicReference<>();\n" + 
				"		findParameter(name).flatMap(stParameter -> stModel.getArguments()\n" + 
				"				.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" + 
				"				.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));\n" + 
				"		return value.get();\n" + 
				"	}\n" + 
				"\n" + 
				"	private STArgument getArgument(String name) {\n" + 
				"		final AtomicReference<STArgument> value = new AtomicReference<>();\n" + 
				"		findParameter(name).flatMap(stParameter -> stModel.getArguments()\n" + 
				"				.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" + 
				"				.findAny()).ifPresent(value::set);\n" + 
				"		return value.get();\n" + 
				"	}\n" + 
				"\n" + 
				"	private ~name;format=\"capitalize\"~ removeArgument(String name) {\n" + 
				"		final STArgument stArgument = getArgument(name);\n" + 
				"		if (stArgument != null) stModel.removeArguments(stArgument);\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	private ~name;format=\"capitalize\"~ add(STValue value, String name) {\n" + 
				"		findParameter(name)\n" + 
				"				.ifPresent(stParameter -> stModel.addArguments(db.newSTArgument(stParameter, value)));\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	private Stream<STValue> stream(String name) {\n" + 
				"		return findParameter(name)\n" + 
				"				.map(stParameter -> stModel.getArguments()\n" + 
				"						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" + 
				"						.map(STArgument::getValue)).orElseGet(Stream::empty);\n" + 
				"	}\n" + 
				"\n" + 
				"	private Optional<STParameter> findParameter(String name) {\n" + 
				"		return stTemplate.getParameters()\n" + 
				"				.filter(param -> param.getName().equals(name))\n" + 
				"				.findFirst();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void addKV(STValue _type, STParameter stParameter, Collection<STArgumentKV> kvs, String type) {\n" + 
				"		stParameter.getKeys()\n" + 
				"				.filter(stParameterKey -> stParameterKey.getName().equals(type))\n" + 
				"				.findFirst()\n" + 
				"				.ifPresent(stParameterKey -> kvs.add(db.newSTArgumentKV(stParameterKey, _type)));\n" + 
				"	}\n" + 
				"} >>";
}  