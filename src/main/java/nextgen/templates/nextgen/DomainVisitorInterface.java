package nextgen.templates.nextgen;

public class DomainVisitorInterface {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _onComplete = new java.util.ArrayList<>();
	private java.util.List<Object> _onRelation = new java.util.ArrayList<>();
	private java.util.List<Object> _onEntity = new java.util.ArrayList<>();
	private java.util.List<Object> _onDomain = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _templates = new java.util.ArrayList<>();

	DomainVisitorInterface(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainVisitorInterface");
		for (Object o : _onComplete) st.add("onComplete", o);
		for (Object o : _onRelation) st.add("onRelation", o);
		for (Object o : _onEntity) st.add("onEntity", o);
		for (Object o : _onDomain) st.add("onDomain", o);
		for (java.util.Map<String, Object> map : _templates) st.addAggr("templates.{name,uuid}", map.get("name"), map.get("uuid"));
		return st.render().trim();
	}


	public DomainVisitorInterface addOnComplete(Object value) {
		this._onComplete.add(value);
		return this;
	}

	public DomainVisitorInterface setOnComplete(Object[] value) {
		this._onComplete.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnComplete(java.util.Collection<Object> values) {
		this._onComplete.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnComplete(Object value) {
		this._onComplete.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnComplete(int index) {
		this._onComplete.remove(index);
		return this;
	}

	public java.util.List<Object> getOnComplete() {
		return this._onComplete;
	} 

	public DomainVisitorInterface addOnRelation(Object value) {
		this._onRelation.add(value);
		return this;
	}

	public DomainVisitorInterface setOnRelation(Object[] value) {
		this._onRelation.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnRelation(java.util.Collection<Object> values) {
		this._onRelation.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnRelation(Object value) {
		this._onRelation.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnRelation(int index) {
		this._onRelation.remove(index);
		return this;
	}

	public java.util.List<Object> getOnRelation() {
		return this._onRelation;
	} 

	public DomainVisitorInterface addOnEntity(Object value) {
		this._onEntity.add(value);
		return this;
	}

	public DomainVisitorInterface setOnEntity(Object[] value) {
		this._onEntity.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnEntity(java.util.Collection<Object> values) {
		this._onEntity.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnEntity(Object value) {
		this._onEntity.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnEntity(int index) {
		this._onEntity.remove(index);
		return this;
	}

	public java.util.List<Object> getOnEntity() {
		return this._onEntity;
	} 

	public DomainVisitorInterface addOnDomain(Object value) {
		this._onDomain.add(value);
		return this;
	}

	public DomainVisitorInterface setOnDomain(Object[] value) {
		this._onDomain.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnDomain(java.util.Collection<Object> values) {
		this._onDomain.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnDomain(Object value) {
		this._onDomain.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnDomain(int index) {
		this._onDomain.remove(index);
		return this;
	}

	public java.util.List<Object> getOnDomain() {
		return this._onDomain;
	} 

	public DomainVisitorInterface setTemplates(java.util.Collection<DomainVisitorInterface_Templates> values) {
			this._templates.clear();
			values.stream().map(DomainVisitorInterface_Templates::asMap).forEach(map -> _templates.add(map));
			return this;
		}

	public DomainVisitorInterface addTemplates(Object _name, Object _uuid) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("uuid", _uuid);
		this._templates.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTemplates() {
		return this._templates;
	}

	public DomainVisitorInterface addTemplates(DomainVisitorInterface_Templates value) {
		return addTemplates(value._name, value._uuid);
	}

	public java.util.stream.Stream<DomainVisitorInterface_Templates> streamTemplates() {
		return this._templates.stream().map(DomainVisitorInterface_Templates::new);
	}

	public java.util.List<Object> getTemplates_Name() {
		return streamTemplates().map(DomainVisitorInterface_Templates::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getTemplates_Uuid() {
		return streamTemplates().map(DomainVisitorInterface_Templates::getUuid).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainVisitorInterface_Templates {

		Object _name;
		Object _uuid;

		public DomainVisitorInterface_Templates(Object _name, Object _uuid) {
			this._name = _name;
			this._uuid = _uuid;
		}

		private DomainVisitorInterface_Templates(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._uuid = (Object) map.get("uuid");
		}

		public Object getName() {
			return this._name;
		}

		public Object getUuid() {
			return this._uuid;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("uuid", _uuid);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainVisitorInterface that = (DomainVisitorInterface) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainVisitorInterface(templates,onComplete,onRelation,onEntity,onDomain) ::= <<final java.util.Map<String, java.util.Map<String, STModel>~gt()~ stModels = new java.util.HashMap<>();\n" + 
				"\n" + 
				"public void onDomain(String name) {\n" + 
				"	~onDomain:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"public void onEntity(DomainEntity entity) {\n" + 
				"	final String entityName = entity.getName();\n" + 
				"	final String entityUuid = entity.getUuid();\n" + 
				"	~onEntity:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"public void onRelation(DomainRelation relation) {\n" + 
				"	final String relationName = relation.getName();\n" + 
				"	final nextgen.model.DomainRelationType relationType = relation.getType();\n" + 
				"	final nextgen.model.DomainEntity src = relation.getSrc();\n" + 
				"	final String srcName = src.getName();\n" + 
				"	final String srcUuid = src.getUuid();\n" + 
				"	final nextgen.model.DomainEntity dst = relation.getDst();\n" + 
				"	final String dstName = dst.getName();\n" + 
				"	final String dstUuid = dst.getUuid();\n" + 
				"\n" + 
				"	System.out.println(\"\\ton relation \" + relationName + \" \" + srcName + \" \" + relationType + \" \" + dstName);\n" + 
				"	~onRelation:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"public void onComplete() {\n" + 
				"	~onComplete:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"// utility methods\n" + 
				"~templates:{it|\n" + 
				"private nextgen.model.STModel new~it.name;format=\"capitalize\"~(String key) {\n" + 
				"	stModels.putIfAbsent(key, new java.util.LinkedHashMap<>());\n" + 
				"	stModels.get(key).put(key, appModel().newSTModel(appModel().db.findSTTemplateByUuid(\"~it.uuid~\")));\n" + 
				"	return stModels.get(key).get(key);\n" + 
				"~eom()~\n" + 
				"};separator=\"\\n\"~\n" + 
				"\n" + 
				"private nextgen.model.STModel newModel(String uuid) {\n" + 
				"	return appModel().newSTModel(appModel().db.findSTTemplateByUuid(uuid));\n" + 
				"}\n" + 
				"\n" + 
				"private nextgen.model.STModel newModel(String key, String uuid) {\n" + 
				"	stModels.putIfAbsent(key, new java.util.TreeMap<>());\n" + 
				"	stModels.get(key).put(key, newModel(uuid));\n" + 
				"	return stModels.get(key).get(key);\n" + 
				"}\n" + 
				"\n" + 
				"private nextgen.model.STModel newModel(DomainEntity entity, String key, String uuid) {\n" + 
				"	stModels.putIfAbsent(entity.getUuid(), new java.util.TreeMap<>());\n" + 
				"	stModels.get(entity.getUuid()).put(key, newModel(uuid));\n" + 
				"	return stModels.get(entity.getUuid()).get(key);\n" + 
				"}\n" + 
				"\n" + 
				"private void set(nextgen.model.STModel stModel, String parameterName, String value) {\n" + 
				"	appModel().setArgument(stModel, parameterName, value);\n" + 
				"}\n" + 
				"\n" + 
				"private nextgen.model.STModel get(nextgen.model.DomainEntity domainEntity, String key) {\n" + 
				"	return stModels.get(domainEntity.getUuid()).get(key);\n" + 
				"}\n" + 
				"\n" + 
				"private void add(nextgen.model.STModel stModel, String parameterName, String value) {\n" + 
				"	appModel().addArgument(stModel, parameterName, value);\n" + 
				"}\n" + 
				"\n" + 
				"private void writeModel(String key) {\n" + 
				"	write(stModels.get(key).get(key));\n" + 
				"}\n" + 
				"\n" + 
				"private void write(STModel stModel) {\n" + 
				"	final java.io.File file = new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath());\n" + 
				"	nextgen.st.STGenerator.writeJavaFile(appModel().render(stModel), nextgen.swing.STAppPresentationModel.getSTModelPackage(stModel), nextgen.swing.STAppPresentationModel.getSTModelName(stModel), file);\n" + 
				"} >>";
}  