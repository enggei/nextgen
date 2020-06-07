package nextgen.st.stringtemplate;

public class STEntity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _template;
	private Object _stString;
	private java.util.List<Object> _singleFields = new java.util.ArrayList<>();
	private java.util.List<Object> _listFields = new java.util.ArrayList<>();
	private java.util.List<Object> _singleAccessors = new java.util.ArrayList<>();
	private java.util.List<Object> _listAccessors = new java.util.ArrayList<>();
	private java.util.List<Object> _kvListAccessors = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _kvListFields = new java.util.ArrayList<>();

	STEntity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
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

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STEntity");
		st.add("packageName" ,_packageName);
		st.add("name" ,_name);
		st.add("template" ,_template);
		st.add("stString" ,_stString);
		for (Object o : _singleFields) st.add("singleFields", o);
		for (Object o : _listFields) st.add("listFields", o);
		for (Object o : _singleAccessors) st.add("singleAccessors", o);
		for (Object o : _listAccessors) st.add("listAccessors", o);
		for (Object o : _kvListAccessors) st.add("kvListAccessors", o);
		for (java.util.Map<String, Object> map : _kvListFields) st.addAggr("kvListFields.{name,aggrSpec,aggrValues}", map.get("name"), map.get("aggrSpec"), map.get("aggrValues"));
		return st.render().trim();
	}

	public STEntity setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public STEntity removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STEntity setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public STEntity removeName() {
		this._name = null;
		return this;
	} 

	public STEntity setTemplate(Object value) {
		this._template = value;
		return this;
	}

	public Object getTemplate() {
		return this._template;
	}

	public boolean hasTemplate() {
		return this._template != null;
	}

	public STEntity removeTemplate() {
		this._template = null;
		return this;
	} 

	public STEntity setStString(Object value) {
		this._stString = value;
		return this;
	}

	public Object getStString() {
		return this._stString;
	}

	public boolean hasStString() {
		return this._stString != null;
	}

	public STEntity removeStString() {
		this._stString = null;
		return this;
	} 
	public STEntity addSingleFields(Object value) {
		this._singleFields.add(value);
		return this;
	}

	public STEntity removeSingleFields(Object value) {
		this._singleFields.remove(value);
		return this;
	}

	public STEntity removeSingleFields(int index) {
		this._singleFields.remove(index);
		return this;
	}

	public java.util.List<Object> getSingleFields() {
		return this._singleFields;
	} 

	public STEntity addListFields(Object value) {
		this._listFields.add(value);
		return this;
	}

	public STEntity removeListFields(Object value) {
		this._listFields.remove(value);
		return this;
	}

	public STEntity removeListFields(int index) {
		this._listFields.remove(index);
		return this;
	}

	public java.util.List<Object> getListFields() {
		return this._listFields;
	} 

	public STEntity addSingleAccessors(Object value) {
		this._singleAccessors.add(value);
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

	public STEntity addKvListAccessors(Object value) {
		this._kvListAccessors.add(value);
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
	public STEntity addKvListFields(Object _name, Object _aggrSpec, Object _aggrValues) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("aggrSpec", _aggrSpec);
		map.put("aggrValues", _aggrValues);
		this._kvListFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKvListFields() {
		return this._kvListFields;
	}

	public STEntity addKvListFields(STEntity_KvListFields value) {
		return addKvListFields(value._name, value._aggrSpec, value._aggrValues);
	}

	public java.util.stream.Stream<STEntity_KvListFields> streamKvListFields() {
		return this._kvListFields.stream().map(STEntity_KvListFields::new);
	}

	public static final class STEntity_KvListFields {

		Object _name;
		Object _aggrSpec;
		Object _aggrValues;

		public STEntity_KvListFields(Object _name, Object _aggrSpec, Object _aggrValues) {
			this._name = _name;
			this._aggrSpec = _aggrSpec;
			this._aggrValues = _aggrValues;
		}

		private STEntity_KvListFields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._aggrSpec = (Object) map.get("aggrSpec");
			this._aggrValues = (Object) map.get("aggrValues");
		}

		public Object getName() {
			return this._name;
		}

		public Object getAggrSpec() {
			return this._aggrSpec;
		}

		public Object getAggrValues() {
			return this._aggrValues;
		}

	} 

	static final String st = "STEntity(packageName,name,singleFields,listFields,kvListFields,template,singleAccessors,listAccessors,kvListAccessors,stString) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	private final java.util.UUID uuid = java.util.UUID.randomUUID();\n" + 
				"	private final org.stringtemplate.v4.STGroup stGroup;\n" + 
				"	\n" + 
				"	~singleFields:{it|private Object _~it~;};separator=\"\\n\"~\n" + 
				"	~listFields:{it|private java.util.List<Object> _~it~ = new java.util.ArrayList<>();};separator=\"\\n\"~\n" + 
				"	~kvListFields:{it|private java.util.List<java.util.Map<String, Object~gt()~> _~it.name~ = new java.util.ArrayList<>();};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~name~(org.stringtemplate.v4.STGroup stGroup) {\n" + 
				"		this.stGroup = stGroup;\n" + 
				"	}\n" + 
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
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf(\"~template~\");\n" + 
				"		~singleFields:{it|st.add(\"~it~\" ,_~it~);};separator=\"\\n\"~\n" + 
				"		~listFields:{it|for (Object o : _~it~) st.add(\"~it~\", o);};separator=\"\\n\"~\n" + 
				"		~kvListFields:{it|for (java.util.Map<String, Object> map : _~it.name~) st.addAggr(\"~it.aggrSpec~\", ~it.aggrValues~);};separator=\"\\n\"~\n" + 
				"		return st.render().trim();\n" + 
				"	}\n" + 
				"	\n" + 
				"	~singleAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	~listAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	~kvListAccessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~if(stString)~static final String st = \"~stString~\";~endif~\n" + 
				"}>> ";
} 