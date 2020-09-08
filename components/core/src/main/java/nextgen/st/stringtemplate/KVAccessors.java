package nextgen.st.stringtemplate;

public class KVAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _keys = new java.util.ArrayList<>();

	KVAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("KVAccessors");
		st.add("entity", _entity);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _keys) st.addAggr("keys.{name}", map.get("name"));
		return st.render().trim();
	}

	public KVAccessors setEntity(Object value) {
		this._entity = value;
		return this;
	}

	public Object getEntity() {
		return this._entity;
	}

	public Object getEntity(Object defaultValue) {
		return this._entity == null ? defaultValue : this._entity;
	}

	public boolean hasEntity() {
		return this._entity != null;
	}

	public KVAccessors removeEntity() {
		this._entity = null;
		return this;
	} 

	public KVAccessors setName(Object value) {
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

	public KVAccessors removeName() {
		this._name = null;
		return this;
	} 


	public KVAccessors addKeys(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._keys.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKeys() {
		return this._keys;
	}

	public KVAccessors addKeys(KVAccessors_Keys value) {
		return addKeys(value._name);
	}

	public java.util.stream.Stream<KVAccessors_Keys> streamKeys() {
		return this._keys.stream().map(KVAccessors_Keys::new);
	}

	public static final class KVAccessors_Keys {

		Object _name;

		public KVAccessors_Keys(Object _name) {
			this._name = _name;
		}

		private KVAccessors_Keys(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		KVAccessors that = (KVAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "KVAccessors(entity,name,keys) ::= <<public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~keys:{it|String _~it.name~};separator=\", \"~) {\n" + 
				"	return add~name;format=\"capitalize\"~(~keys:{it|db.newSTValue(_~it.name~)};separator=\", \"~);\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~ value) {\n" + 
				"	return add~name;format=\"capitalize\"~(~keys:{it|value.get~it.name;format=\"capitalize\"~()};separator=\", \"~);\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~keys:{it|STValue _~it.name~};separator=\", \"~) {\n" + 
				"	findParameter(\"~name~\")\n" + 
				"			.ifPresent(stParameter -> {\n" + 
				"				final Collection<STArgumentKV> kvs = new ArrayList<>();\n" + 
				"				~keys:{it|addKV(_~it.name~, stParameter, kvs, \"~it.name~\");};separator=\"\\n\"~\n" + 
				"				db.newSTArgument(stParameter, kvs);\n" + 
				"			});\n" + 
				"\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~> stream~name;format=\"capitalize\"~() {\n" + 
				"	return findParameter(\"~name~\")\n" + 
				"			.map(stParameter -> stModel.getArguments()\n" + 
				"					.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" + 
				"					.map(stArgument -> new ~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~(stArgument, stParameter)))\n" + 
				"			.orElseGet(Stream::empty);\n" + 
				"}\n" + 
				"\n" + 
				"public final class ~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	STArgument stArgument;\n" + 
				"	STParameter stParameter;\n" + 
				"\n" + 
				"	public ~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~(STArgument stArgument, STParameter stParameter) {\n" + 
				"		this.stArgument = stArgument;\n" + 
				"		this.stParameter = stParameter;\n" + 
				"	}\n" + 
				"\n" + 
				"~keys:{it|\n" + 
				"	public ~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~ set~it.name;format=\"capitalize\"~(String value) {\n" + 
				"		return set~it.name;format=\"capitalize\"~(db.newSTValue(value));\n" + 
				"	~eom()~\n" + 
				"\n" + 
				"	public ~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~ set~it.name;format=\"capitalize\"~(STValue value) {\n" + 
				"		return setKVValue(\"~it.name~\", value);\n" + 
				"	~eom()~\n" + 
				"\n" + 
				"	public STValue get~it.name;format=\"capitalize\"~() {\n" + 
				"		return getKVValue(\"~it.name~\");\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private ~entity;format=\"capitalize\"~_~name;format=\"capitalize\"~ setKVValue(String name, STValue value) {\n" + 
				"\n" + 
				"		stParameter.getKeys()\n" + 
				"				.filter(stParameterKey -> stParameterKey.getName().equals(name))\n" + 
				"				.findAny()\n" + 
				"				.ifPresent(stParameterKey -> {\n" + 
				"\n" + 
				"					stArgument.getKeyValues()\n" + 
				"							.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" + 
				"							.findAny()\n" + 
				"							.ifPresent(stArgumentKV -> stArgument.removeKeyValues(stArgumentKV));\n" + 
				"\n" + 
				"					stArgument.addKeyValues(db.newSTArgumentKV(stParameterKey, value));\n" + 
				"				});\n" + 
				"\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	private STValue getKVValue(String name) {\n" + 
				"		final AtomicReference<STValue> value = new AtomicReference<>();\n" + 
				"		stParameter.getKeys()\n" + 
				"				.filter(param -> param.getName().equals(name))\n" + 
				"				.findFirst().flatMap(stParameter -> stArgument.getKeyValues()\n" + 
				"				.filter(stArgument -> stArgument.getStParameterKey().equals(stParameter.getUuid()))\n" + 
				"				.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));\n" + 
				"\n" + 
				"		return value.get();\n" + 
				"	}\n" + 
				"} >>";
}  