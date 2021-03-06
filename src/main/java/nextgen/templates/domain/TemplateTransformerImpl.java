package nextgen.templates.domain;

public class TemplateTransformerImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _init;
	private Object _T;
	private String _name;
	private java.util.List<Object> _mapName = new java.util.ArrayList<>();
	private java.util.List<Object> _mapTypeDeclaration = new java.util.ArrayList<>();
	private java.util.List<Object> _mapType = new java.util.ArrayList<>();
	private java.util.List<Object> _mapQuantifier = new java.util.ArrayList<>();
	private java.util.List<Object> _onComplete = new java.util.ArrayList<>();
	private java.util.List<Object> _onEntity = new java.util.ArrayList<>();
	private java.util.List<Object> _onProperty = new java.util.ArrayList<>();
	private java.util.List<Object> _onDomain = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	TemplateTransformerImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TemplateTransformerImpl");
		st.add("packageName", _packageName);
		st.add("init", _init);
		st.add("T", _T);
		st.add("name", _name);
		for (Object o : _mapName) st.add("mapName", o);
		for (Object o : _mapTypeDeclaration) st.add("mapTypeDeclaration", o);
		for (Object o : _mapType) st.add("mapType", o);
		for (Object o : _mapQuantifier) st.add("mapQuantifier", o);
		for (Object o : _onComplete) st.add("onComplete", o);
		for (Object o : _onEntity) st.add("onEntity", o);
		for (Object o : _onProperty) st.add("onProperty", o);
		for (Object o : _onDomain) st.add("onDomain", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{init,type,name}", map.get("init"), map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public TemplateTransformerImpl setPackageName(Object value) {
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

	public TemplateTransformerImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TemplateTransformerImpl setInit(Object value) {
		this._init = value;
		return this;
	}

	public Object getInit() {
		return this._init;
	}

	public Object getInit(Object defaultValue) {
		return this._init == null ? defaultValue : this._init;
	}

	public boolean hasInit() {
		return this._init != null;
	}

	public TemplateTransformerImpl removeInit() {
		this._init = null;
		return this;
	} 

	public TemplateTransformerImpl setT(Object value) {
		this._T = value;
		return this;
	}

	public Object getT() {
		return this._T;
	}

	public Object getT(Object defaultValue) {
		return this._T == null ? defaultValue : this._T;
	}

	public boolean hasT() {
		return this._T != null;
	}

	public TemplateTransformerImpl removeT() {
		this._T = null;
		return this;
	} 

	public TemplateTransformerImpl setName(String value) {
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

	public TemplateTransformerImpl removeName() {
		this._name = null;
		return this;
	} 

	public TemplateTransformerImpl addMapName(Object value) {
		this._mapName.add(value);
		return this;
	}

	public TemplateTransformerImpl setMapName(Object[] value) {
		this._mapName.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setMapName(java.util.Collection<Object> values) {
		this._mapName.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeMapName(Object value) {
		this._mapName.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeMapName(int index) {
		this._mapName.remove(index);
		return this;
	}

	public java.util.List<Object> getMapName() {
		return this._mapName;
	} 

	public TemplateTransformerImpl addMapTypeDeclaration(Object value) {
		this._mapTypeDeclaration.add(value);
		return this;
	}

	public TemplateTransformerImpl setMapTypeDeclaration(Object[] value) {
		this._mapTypeDeclaration.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setMapTypeDeclaration(java.util.Collection<Object> values) {
		this._mapTypeDeclaration.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeMapTypeDeclaration(Object value) {
		this._mapTypeDeclaration.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeMapTypeDeclaration(int index) {
		this._mapTypeDeclaration.remove(index);
		return this;
	}

	public java.util.List<Object> getMapTypeDeclaration() {
		return this._mapTypeDeclaration;
	} 

	public TemplateTransformerImpl addMapType(Object value) {
		this._mapType.add(value);
		return this;
	}

	public TemplateTransformerImpl setMapType(Object[] value) {
		this._mapType.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setMapType(java.util.Collection<Object> values) {
		this._mapType.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeMapType(Object value) {
		this._mapType.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeMapType(int index) {
		this._mapType.remove(index);
		return this;
	}

	public java.util.List<Object> getMapType() {
		return this._mapType;
	} 

	public TemplateTransformerImpl addMapQuantifier(Object value) {
		this._mapQuantifier.add(value);
		return this;
	}

	public TemplateTransformerImpl setMapQuantifier(Object[] value) {
		this._mapQuantifier.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setMapQuantifier(java.util.Collection<Object> values) {
		this._mapQuantifier.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeMapQuantifier(Object value) {
		this._mapQuantifier.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeMapQuantifier(int index) {
		this._mapQuantifier.remove(index);
		return this;
	}

	public java.util.List<Object> getMapQuantifier() {
		return this._mapQuantifier;
	} 

	public TemplateTransformerImpl addOnComplete(Object value) {
		this._onComplete.add(value);
		return this;
	}

	public TemplateTransformerImpl setOnComplete(Object[] value) {
		this._onComplete.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setOnComplete(java.util.Collection<Object> values) {
		this._onComplete.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeOnComplete(Object value) {
		this._onComplete.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeOnComplete(int index) {
		this._onComplete.remove(index);
		return this;
	}

	public java.util.List<Object> getOnComplete() {
		return this._onComplete;
	} 

	public TemplateTransformerImpl addOnEntity(Object value) {
		this._onEntity.add(value);
		return this;
	}

	public TemplateTransformerImpl setOnEntity(Object[] value) {
		this._onEntity.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setOnEntity(java.util.Collection<Object> values) {
		this._onEntity.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeOnEntity(Object value) {
		this._onEntity.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeOnEntity(int index) {
		this._onEntity.remove(index);
		return this;
	}

	public java.util.List<Object> getOnEntity() {
		return this._onEntity;
	} 

	public TemplateTransformerImpl addOnProperty(Object value) {
		this._onProperty.add(value);
		return this;
	}

	public TemplateTransformerImpl setOnProperty(Object[] value) {
		this._onProperty.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setOnProperty(java.util.Collection<Object> values) {
		this._onProperty.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeOnProperty(Object value) {
		this._onProperty.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeOnProperty(int index) {
		this._onProperty.remove(index);
		return this;
	}

	public java.util.List<Object> getOnProperty() {
		return this._onProperty;
	} 

	public TemplateTransformerImpl addOnDomain(Object value) {
		this._onDomain.add(value);
		return this;
	}

	public TemplateTransformerImpl setOnDomain(Object[] value) {
		this._onDomain.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setOnDomain(java.util.Collection<Object> values) {
		this._onDomain.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeOnDomain(Object value) {
		this._onDomain.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeOnDomain(int index) {
		this._onDomain.remove(index);
		return this;
	}

	public java.util.List<Object> getOnDomain() {
		return this._onDomain;
	} 

	public TemplateTransformerImpl addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public TemplateTransformerImpl setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateTransformerImpl setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public TemplateTransformerImpl removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public TemplateTransformerImpl removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public TemplateTransformerImpl setFields(java.util.Collection<TemplateTransformerImpl_Fields> values) {
			this._fields.clear();
			values.stream().map(TemplateTransformerImpl_Fields::asMap).forEach(map -> _fields.add(map));
			return this;
		}

	public TemplateTransformerImpl addFields(Object _init, Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("init", _init);
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public TemplateTransformerImpl addFields(TemplateTransformerImpl_Fields value) {
		return addFields(value._init, value._type, value._name);
	}

	public java.util.stream.Stream<TemplateTransformerImpl_Fields> streamFields() {
		return this._fields.stream().map(TemplateTransformerImpl_Fields::new);
	}

	public java.util.List<Object> getFields_Init() {
		return streamFields().map(TemplateTransformerImpl_Fields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(TemplateTransformerImpl_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(TemplateTransformerImpl_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class TemplateTransformerImpl_Fields {

		Object _init;
		Object _type;
		Object _name;

		public TemplateTransformerImpl_Fields(Object _init, Object _type, Object _name) {
			this._init = _init;
			this._type = _type;
			this._name = _name;
		}

		private TemplateTransformerImpl_Fields(java.util.Map<String, Object> map) {
			this._init = (Object) map.get("init");
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getInit() {
			return this._init;
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("init", _init);
			map.put("type", _type);
			map.put("name", _name);
			return map;
		}

	}  

	public TemplateTransformerImpl setProperties(java.util.Collection<TemplateTransformerImpl_Properties> values) {
			this._properties.clear();
			values.stream().map(TemplateTransformerImpl_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public TemplateTransformerImpl addProperties(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public TemplateTransformerImpl addProperties(TemplateTransformerImpl_Properties value) {
		return addProperties(value._name, value._type);
	}

	public java.util.stream.Stream<TemplateTransformerImpl_Properties> streamProperties() {
		return this._properties.stream().map(TemplateTransformerImpl_Properties::new);
	}

	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(TemplateTransformerImpl_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(TemplateTransformerImpl_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class TemplateTransformerImpl_Properties {

		Object _name;
		Object _type;

		public TemplateTransformerImpl_Properties(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private TemplateTransformerImpl_Properties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TemplateTransformerImpl that = (TemplateTransformerImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TemplateTransformerImpl(mapName,mapTypeDeclaration,mapType,mapQuantifier,fields,packageName,onComplete,onEntity,onProperty,onDomain,init,properties,methods,T,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.templates.domain.*;\n" + 
				"import java.util.*;\n" + 
				"import static domain.DomainProcessor.*;\n" + 
				"\n" + 
				"public class ~name~ extends TemplateDomainTransformer<~T~> {\n" + 
				"\n" + 
				"	final ~T~ result = ~init~;\n" + 
				"	\n" + 
				"	~fields:{it|final ~it.type~ ~it.name~ = ~it.init~;};separator=\"\\n\"~\n" + 
				"	~properties:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~(~properties:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		~properties:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void onDomain(MetaDomain domain) {\n" + 
				"		~onDomain:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void onProperty(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		~onProperty:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void onEntity(MetaDomain entity) {\n" + 
				"		~onEntity:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public ~T~ onComplete() {\n" + 
				"		~onComplete:{it|~it~};separator=\"\\n\"~\n" + 
				"		return result;\n" + 
				"	}\n" + 
				"\n" + 
				"~if(mapQuantifier)~\n" + 
				"	@Override\n" + 
				"	public Object quantifier(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		~mapQuantifier:{it|~it~}~\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"~if(mapName)~\n" + 
				"	@Override\n" + 
				"	public Object name(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		~mapName:{it|~it~}~\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"~if(mapType)~\n" + 
				"	@Override\n" + 
				"	public Object type(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		~mapType:{it|~it~}~\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"~if(mapTypeDeclaration)~\n" + 
				"	@Override\n" + 
				"	public Object typeDeclaration(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		~mapTypeDeclaration:{it|~it~}~\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  