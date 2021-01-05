package nextgen.templates.domain;

public class DefaultEntityImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private String _name;
	private java.util.List<java.util.Map<String, Object>> _requiredProperties = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	DefaultEntityImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("defaultEntityImpl");
		st.add("type", _type);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _requiredProperties) st.addAggr("requiredProperties.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{init,getter,assign,impl,element,name,type,methodName}", map.get("init"), map.get("getter"), map.get("assign"), map.get("impl"), map.get("element"), map.get("name"), map.get("type"), map.get("methodName"));
		return st.render().trim();
	}

	public DefaultEntityImpl setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public DefaultEntityImpl removeType() {
		this._type = null;
		return this;
	} 

	public DefaultEntityImpl setName(String value) {
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

	public DefaultEntityImpl removeName() {
		this._name = null;
		return this;
	} 


	public DefaultEntityImpl setRequiredProperties(java.util.Collection<DefaultEntityImpl_RequiredProperties> values) {
			this._requiredProperties.clear();
			values.stream().map(DefaultEntityImpl_RequiredProperties::asMap).forEach(map -> _requiredProperties.add(map));
			return this;
		}

	public DefaultEntityImpl addRequiredProperties(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._requiredProperties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRequiredProperties() {
		return this._requiredProperties;
	}

	public DefaultEntityImpl addRequiredProperties(DefaultEntityImpl_RequiredProperties value) {
		return addRequiredProperties(value._type, value._name);
	}

	public java.util.stream.Stream<DefaultEntityImpl_RequiredProperties> streamRequiredProperties() {
		return this._requiredProperties.stream().map(DefaultEntityImpl_RequiredProperties::new);
	}

	public java.util.List<Object> getRequiredProperties_Type() {
		return streamRequiredProperties().map(DefaultEntityImpl_RequiredProperties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getRequiredProperties_Name() {
		return streamRequiredProperties().map(DefaultEntityImpl_RequiredProperties::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class DefaultEntityImpl_RequiredProperties {

		Object _type;
		Object _name;

		public DefaultEntityImpl_RequiredProperties(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private DefaultEntityImpl_RequiredProperties(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("type", _type);
			map.put("name", _name);
			return map;
		}

	}  

	public DefaultEntityImpl setProperties(java.util.Collection<DefaultEntityImpl_Properties> values) {
			this._properties.clear();
			values.stream().map(DefaultEntityImpl_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public DefaultEntityImpl addProperties(Object _init, Object _getter, Object _assign, Object _impl, Object _element, Object _name, Object _type, Object _methodName) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("init", _init);
		map.put("getter", _getter);
		map.put("assign", _assign);
		map.put("impl", _impl);
		map.put("element", _element);
		map.put("name", _name);
		map.put("type", _type);
		map.put("methodName", _methodName);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public DefaultEntityImpl addProperties(DefaultEntityImpl_Properties value) {
		return addProperties(value._init, value._getter, value._assign, value._impl, value._element, value._name, value._type, value._methodName);
	}

	public java.util.stream.Stream<DefaultEntityImpl_Properties> streamProperties() {
		return this._properties.stream().map(DefaultEntityImpl_Properties::new);
	}

	public java.util.List<Object> getProperties_Init() {
		return streamProperties().map(DefaultEntityImpl_Properties::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Getter() {
		return streamProperties().map(DefaultEntityImpl_Properties::getGetter).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Assign() {
		return streamProperties().map(DefaultEntityImpl_Properties::getAssign).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Impl() {
		return streamProperties().map(DefaultEntityImpl_Properties::getImpl).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Element() {
		return streamProperties().map(DefaultEntityImpl_Properties::getElement).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(DefaultEntityImpl_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(DefaultEntityImpl_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_MethodName() {
		return streamProperties().map(DefaultEntityImpl_Properties::getMethodName).collect(java.util.stream.Collectors.toList());
	}


	public static final class DefaultEntityImpl_Properties {

		Object _init;
		Object _getter;
		Object _assign;
		Object _impl;
		Object _element;
		Object _name;
		Object _type;
		Object _methodName;

		public DefaultEntityImpl_Properties(Object _init, Object _getter, Object _assign, Object _impl, Object _element, Object _name, Object _type, Object _methodName) {
			this._init = _init;
			this._getter = _getter;
			this._assign = _assign;
			this._impl = _impl;
			this._element = _element;
			this._name = _name;
			this._type = _type;
			this._methodName = _methodName;
		}

		private DefaultEntityImpl_Properties(java.util.Map<String, Object> map) {
			this._init = (Object) map.get("init");
			this._getter = (Object) map.get("getter");
			this._assign = (Object) map.get("assign");
			this._impl = (Object) map.get("impl");
			this._element = (Object) map.get("element");
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
			this._methodName = (Object) map.get("methodName");
		}

		public Object getInit() {
			return this._init;
		}

		public Object getGetter() {
			return this._getter;
		}

		public Object getAssign() {
			return this._assign;
		}

		public Object getImpl() {
			return this._impl;
		}

		public Object getElement() {
			return this._element;
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

		public Object getMethodName() {
			return this._methodName;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("init", _init);
			map.put("getter", _getter);
			map.put("assign", _assign);
			map.put("impl", _impl);
			map.put("element", _element);
			map.put("name", _name);
			map.put("type", _type);
			map.put("methodName", _methodName);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DefaultEntityImpl that = (DefaultEntityImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "defaultEntityImpl(requiredProperties,properties,type,name) ::= <<@Override \n" + 
				"public ~type~Builder new~name;format=\"capitalize\"~(~requiredProperties:{it|~it.type~ ~it.name~};separator=\", \"~) { return new ~type~BuilderImpl(~requiredProperties:{it|~it.name~};separator=\", \"~); }\n" + 
				"\n" + 
				"public static final class ~type~BuilderImpl implements ~type~Builder {\n" + 
				"\n" + 
				"	~properties:{it| private~if(it.init)~ final~endif~ ~it.impl~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~type~BuilderImpl(~requiredProperties:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		~requiredProperties:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~properties:{it|\n" + 
				"	@Override\n" + 
				"	public ~it.type~ ~it.name~() { return ~it.getter~; ~eom()~\n" + 
				"	\n" + 
				"	@Override \n" + 
				"	public ~type~Builder ~it.methodName~(~it.element~ element) { ~it.assign~; return this; ~eom()~\n" + 
				"};separator=\"\\n\"~\n" + 
				"} >>";
}  