package nextgen.templates.domain;

public class DefaultFactoryImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _factory;
	private String _name;
	private Object _packageName;
	private java.util.List<Object> _entities = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	DefaultFactoryImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("defaultFactoryImpl");
		st.add("factory", _factory);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _entities) st.add("entities", o);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{init,getter,impl,assign,element,methodName,name,type}", map.get("init"), map.get("getter"), map.get("impl"), map.get("assign"), map.get("element"), map.get("methodName"), map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public DefaultFactoryImpl setFactory(Object value) {
		this._factory = value;
		return this;
	}

	public Object getFactory() {
		return this._factory;
	}

	public Object getFactory(Object defaultValue) {
		return this._factory == null ? defaultValue : this._factory;
	}

	public boolean hasFactory() {
		return this._factory != null;
	}

	public DefaultFactoryImpl removeFactory() {
		this._factory = null;
		return this;
	} 

	public DefaultFactoryImpl setName(String value) {
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

	public DefaultFactoryImpl removeName() {
		this._name = null;
		return this;
	} 

	public DefaultFactoryImpl setPackageName(Object value) {
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

	public DefaultFactoryImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public DefaultFactoryImpl addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public DefaultFactoryImpl setEntities(Object[] value) {
		this._entities.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DefaultFactoryImpl setEntities(java.util.Collection<Object> values) {
		this._entities.addAll(values);
		return this;
	}

	public DefaultFactoryImpl removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public DefaultFactoryImpl removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
	} 

	public DefaultFactoryImpl setProperties(java.util.Collection<DefaultFactoryImpl_Properties> values) {
			this._properties.clear();
			values.stream().map(DefaultFactoryImpl_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public DefaultFactoryImpl addProperties(Object _init, Object _getter, Object _impl, Object _assign, Object _element, Object _methodName, Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("init", _init);
		map.put("getter", _getter);
		map.put("impl", _impl);
		map.put("assign", _assign);
		map.put("element", _element);
		map.put("methodName", _methodName);
		map.put("name", _name);
		map.put("type", _type);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public DefaultFactoryImpl addProperties(DefaultFactoryImpl_Properties value) {
		return addProperties(value._init, value._getter, value._impl, value._assign, value._element, value._methodName, value._name, value._type);
	}

	public java.util.stream.Stream<DefaultFactoryImpl_Properties> streamProperties() {
		return this._properties.stream().map(DefaultFactoryImpl_Properties::new);
	}

	public java.util.List<Object> getProperties_Init() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Getter() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getGetter).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Impl() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getImpl).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Assign() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getAssign).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Element() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getElement).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_MethodName() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getMethodName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(DefaultFactoryImpl_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class DefaultFactoryImpl_Properties {

		Object _init;
		Object _getter;
		Object _impl;
		Object _assign;
		Object _element;
		Object _methodName;
		Object _name;
		Object _type;

		public DefaultFactoryImpl_Properties(Object _init, Object _getter, Object _impl, Object _assign, Object _element, Object _methodName, Object _name, Object _type) {
			this._init = _init;
			this._getter = _getter;
			this._impl = _impl;
			this._assign = _assign;
			this._element = _element;
			this._methodName = _methodName;
			this._name = _name;
			this._type = _type;
		}

		private DefaultFactoryImpl_Properties(java.util.Map<String, Object> map) {
			this._init = (Object) map.get("init");
			this._getter = (Object) map.get("getter");
			this._impl = (Object) map.get("impl");
			this._assign = (Object) map.get("assign");
			this._element = (Object) map.get("element");
			this._methodName = (Object) map.get("methodName");
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getInit() {
			return this._init;
		}

		public Object getGetter() {
			return this._getter;
		}

		public Object getImpl() {
			return this._impl;
		}

		public Object getAssign() {
			return this._assign;
		}

		public Object getElement() {
			return this._element;
		}

		public Object getMethodName() {
			return this._methodName;
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("init", _init);
			map.put("getter", _getter);
			map.put("impl", _impl);
			map.put("assign", _assign);
			map.put("element", _element);
			map.put("methodName", _methodName);
			map.put("name", _name);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DefaultFactoryImpl that = (DefaultFactoryImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "defaultFactoryImpl(properties,entities,factory,name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ implements ~factory~ {\n" + 
				"\n" + 
				"	~properties:{it| private~if(it.init)~ final~endif~ ~it.impl~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"~properties:{it|\n" + 
				"	@Override\n" + 
				"	public ~it.type~ ~it.name~() { return ~it.getter~; ~eom()~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public ~factory~ ~it.methodName~(~it.element~ element) { ~it.assign~; return this; ~eom()~\n" + 
				"};separator=\"\\n\"~\n" + 
				"	~entities:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  