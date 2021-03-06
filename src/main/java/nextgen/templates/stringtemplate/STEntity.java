package nextgen.templates.stringtemplate;

public class STEntity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _packageName;
	private Object _stString;
	private Object _template;
	private java.util.List<Object> _interfaces = new java.util.ArrayList<>();
	private java.util.List<Object> _kvListAccessors = new java.util.ArrayList<>();
	private java.util.List<Object> _singleAccessors = new java.util.ArrayList<>();
	private java.util.List<Object> _listAccessors = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _singleFields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _kvListFields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _listFields = new java.util.ArrayList<>();

	STEntity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STEntity");
		st.add("name", _name);
		st.add("packageName", _packageName);
		st.add("stString", _stString);
		st.add("template", _template);
		for (Object o : _interfaces) st.add("interfaces", o);
		for (Object o : _kvListAccessors) st.add("kvListAccessors", o);
		for (Object o : _singleAccessors) st.add("singleAccessors", o);
		for (Object o : _listAccessors) st.add("listAccessors", o);
		for (java.util.Map<String, Object> map : _singleFields) st.addAggr("singleFields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _kvListFields) st.addAggr("kvListFields.{aggrValues,name,aggrSpec}", map.get("aggrValues"), map.get("name"), map.get("aggrSpec"));
		for (java.util.Map<String, Object> map : _listFields) st.addAggr("listFields.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public STEntity setName(Object value) {
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

	public STEntity removeName() {
		this._name = null;
		return this;
	} 

	public STEntity setPackageName(Object value) {
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

	public STEntity removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STEntity setStString(Object value) {
		this._stString = value;
		return this;
	}

	public Object getStString() {
		return this._stString;
	}

	public Object getStString(Object defaultValue) {
		return this._stString == null ? defaultValue : this._stString;
	}

	public boolean hasStString() {
		return this._stString != null;
	}

	public STEntity removeStString() {
		this._stString = null;
		return this;
	} 

	public STEntity setTemplate(Object value) {
		this._template = value;
		return this;
	}

	public Object getTemplate() {
		return this._template;
	}

	public Object getTemplate(Object defaultValue) {
		return this._template == null ? defaultValue : this._template;
	}

	public boolean hasTemplate() {
		return this._template != null;
	}

	public STEntity removeTemplate() {
		this._template = null;
		return this;
	} 

	public STEntity addInterfaces(Object value) {
		this._interfaces.add(value);
		return this;
	}

	public STEntity setInterfaces(Object[] value) {
		this._interfaces.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STEntity setInterfaces(java.util.Collection<Object> values) {
		this._interfaces.addAll(values);
		return this;
	}

	public STEntity removeInterfaces(Object value) {
		this._interfaces.remove(value);
		return this;
	}

	public STEntity removeInterfaces(int index) {
		this._interfaces.remove(index);
		return this;
	}

	public java.util.List<Object> getInterfaces() {
		return this._interfaces;
	} 

	public STEntity addKvListAccessors(Object value) {
		this._kvListAccessors.add(value);
		return this;
	}

	public STEntity setKvListAccessors(Object[] value) {
		this._kvListAccessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STEntity setKvListAccessors(java.util.Collection<Object> values) {
		this._kvListAccessors.addAll(values);
		return this;
	}

	public STEntity removeKvListAccessors(Object value) {
		this._kvListAccessors.remove(value);
		return this;
	}

	public STEntity removeKvListAccessors(int index) {
		this._kvListAccessors.remove(index);
		return this;
	}

	public java.util.List<Object> getKvListAccessors() {
		return this._kvListAccessors;
	} 

	public STEntity addSingleAccessors(Object value) {
		this._singleAccessors.add(value);
		return this;
	}

	public STEntity setSingleAccessors(Object[] value) {
		this._singleAccessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STEntity setSingleAccessors(java.util.Collection<Object> values) {
		this._singleAccessors.addAll(values);
		return this;
	}

	public STEntity removeSingleAccessors(Object value) {
		this._singleAccessors.remove(value);
		return this;
	}

	public STEntity removeSingleAccessors(int index) {
		this._singleAccessors.remove(index);
		return this;
	}

	public java.util.List<Object> getSingleAccessors() {
		return this._singleAccessors;
	} 

	public STEntity addListAccessors(Object value) {
		this._listAccessors.add(value);
		return this;
	}

	public STEntity setListAccessors(Object[] value) {
		this._listAccessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STEntity setListAccessors(java.util.Collection<Object> values) {
		this._listAccessors.addAll(values);
		return this;
	}

	public STEntity removeListAccessors(Object value) {
		this._listAccessors.remove(value);
		return this;
	}

	public STEntity removeListAccessors(int index) {
		this._listAccessors.remove(index);
		return this;
	}

	public java.util.List<Object> getListAccessors() {
		return this._listAccessors;
	} 

	public STEntity setSingleFields(java.util.Collection<STEntity_SingleFields> values) {
			this._singleFields.clear();
			values.stream().map(STEntity_SingleFields::asMap).forEach(map -> _singleFields.add(map));
			return this;
		}

	public STEntity addSingleFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._singleFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getSingleFields() {
		return this._singleFields;
	}

	public STEntity addSingleFields(STEntity_SingleFields value) {
		return addSingleFields(value._type, value._name);
	}

	public java.util.stream.Stream<STEntity_SingleFields> streamSingleFields() {
		return this._singleFields.stream().map(STEntity_SingleFields::new);
	}

	public java.util.List<Object> getSingleFields_Type() {
		return streamSingleFields().map(STEntity_SingleFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getSingleFields_Name() {
		return streamSingleFields().map(STEntity_SingleFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class STEntity_SingleFields {

		Object _type;
		Object _name;

		public STEntity_SingleFields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private STEntity_SingleFields(java.util.Map<String, Object> map) {
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

	public STEntity setKvListFields(java.util.Collection<STEntity_KvListFields> values) {
			this._kvListFields.clear();
			values.stream().map(STEntity_KvListFields::asMap).forEach(map -> _kvListFields.add(map));
			return this;
		}

	public STEntity addKvListFields(Object _aggrValues, Object _name, Object _aggrSpec) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("aggrValues", _aggrValues);
		map.put("name", _name);
		map.put("aggrSpec", _aggrSpec);
		this._kvListFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKvListFields() {
		return this._kvListFields;
	}

	public STEntity addKvListFields(STEntity_KvListFields value) {
		return addKvListFields(value._aggrValues, value._name, value._aggrSpec);
	}

	public java.util.stream.Stream<STEntity_KvListFields> streamKvListFields() {
		return this._kvListFields.stream().map(STEntity_KvListFields::new);
	}

	public java.util.List<Object> getKvListFields_AggrValues() {
		return streamKvListFields().map(STEntity_KvListFields::getAggrValues).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getKvListFields_Name() {
		return streamKvListFields().map(STEntity_KvListFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getKvListFields_AggrSpec() {
		return streamKvListFields().map(STEntity_KvListFields::getAggrSpec).collect(java.util.stream.Collectors.toList());
	}


	public static final class STEntity_KvListFields {

		Object _aggrValues;
		Object _name;
		Object _aggrSpec;

		public STEntity_KvListFields(Object _aggrValues, Object _name, Object _aggrSpec) {
			this._aggrValues = _aggrValues;
			this._name = _name;
			this._aggrSpec = _aggrSpec;
		}

		private STEntity_KvListFields(java.util.Map<String, Object> map) {
			this._aggrValues = (Object) map.get("aggrValues");
			this._name = (Object) map.get("name");
			this._aggrSpec = (Object) map.get("aggrSpec");
		}

		public Object getAggrValues() {
			return this._aggrValues;
		}

		public Object getName() {
			return this._name;
		}

		public Object getAggrSpec() {
			return this._aggrSpec;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("aggrValues", _aggrValues);
			map.put("name", _name);
			map.put("aggrSpec", _aggrSpec);
			return map;
		}

	}  

	public STEntity setListFields(java.util.Collection<STEntity_ListFields> values) {
			this._listFields.clear();
			values.stream().map(STEntity_ListFields::asMap).forEach(map -> _listFields.add(map));
			return this;
		}

	public STEntity addListFields(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._listFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getListFields() {
		return this._listFields;
	}

	public STEntity addListFields(STEntity_ListFields value) {
		return addListFields(value._name, value._type);
	}

	public java.util.stream.Stream<STEntity_ListFields> streamListFields() {
		return this._listFields.stream().map(STEntity_ListFields::new);
	}

	public java.util.List<Object> getListFields_Name() {
		return streamListFields().map(STEntity_ListFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getListFields_Type() {
		return streamListFields().map(STEntity_ListFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class STEntity_ListFields {

		Object _name;
		Object _type;

		public STEntity_ListFields(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private STEntity_ListFields(java.util.Map<String, Object> map) {
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
		STEntity that = (STEntity) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "STEntity(singleFields,interfaces,name,packageName,kvListAccessors,stString,template,singleAccessors,listAccessors,kvListFields,listFields) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~~if(interfaces)~ implements ~endif~~interfaces:{it|~it~};separator=\", \"~ {\n" + 
				"\n" + 
				"	private final java.util.UUID uuid = java.util.UUID.randomUUID();\n" + 
				"	private final org.stringtemplate.v4.STGroup stGroup;\n" + 
				"	\n" + 
				"	~singleFields:{it|private ~it.type~ _~it.name~;};separator=\"\\n\"~\n" + 
				"	~listFields:{it|private java.util.List<~it.type~> _~it.name~ = new java.util.ArrayList<>();};separator=\"\\n\"~\n" + 
				"	~kvListFields:{it|private java.util.List<java.util.Map<String, Object~gt()~> _~it.name~ = new java.util.ArrayList<>();};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~name~(org.stringtemplate.v4.STGroup stGroup) {\n" + 
				"		this.stGroup = stGroup;\n" + 
				"	}\n" + 
				"\n" + 
				"	public java.util.UUID getUuid() {\n" + 
				"		return uuid;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf(\"~template~\");\n" + 
				"		~singleFields:{it|st.add(\"~it.name~\", _~it.name~);};separator=\"\\n\"~\n" + 
				"		~listFields:{it|for (Object o : _~it.name~) st.add(\"~it.name~\", o);};separator=\"\\n\"~\n" + 
				"		~kvListFields:{it|for (java.util.Map<String, Object> map : _~it.name~) st.addAggr(\"~it.aggrSpec~\", ~it.aggrValues~);};separator=\"\\n\"~\n" + 
				"		return st.render().trim();\n" + 
				"	}\n" + 
				"	\n" + 
				"	~singleAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"	~listAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"	~kvListAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		~name~ that = (~name~) o;\n" + 
				"		return uuid.equals(that.uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return java.util.Objects.hash(uuid);\n" + 
				"	}\n" + 
				"	\n" + 
				"	~if(stString)~static final String st = \"~stString~\";~endif~\n" + 
				"} >>";
}  