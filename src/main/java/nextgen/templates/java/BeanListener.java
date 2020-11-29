package nextgen.templates.java;

public class BeanListener {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _singleProperties = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _listProperties = new java.util.ArrayList<>();

	BeanListener(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BeanListener");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _singleProperties) st.addAggr("singleProperties.{name,type}", map.get("name"), map.get("type"));
		for (java.util.Map<String, Object> map : _listProperties) st.addAggr("listProperties.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public BeanListener setName(Object value) {
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

	public BeanListener removeName() {
		this._name = null;
		return this;
	} 


	public BeanListener addSingleProperties(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._singleProperties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getSingleProperties() {
		return this._singleProperties;
	}

	public BeanListener addSingleProperties(BeanListener_SingleProperties value) {
		return addSingleProperties(value._name, value._type);
	}

	public java.util.stream.Stream<BeanListener_SingleProperties> streamSingleProperties() {
		return this._singleProperties.stream().map(BeanListener_SingleProperties::new);
	}

	public java.util.List<Object> getSingleProperties_Name() {
		return streamSingleProperties().map(BeanListener_SingleProperties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getSingleProperties_Type() {
		return streamSingleProperties().map(BeanListener_SingleProperties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class BeanListener_SingleProperties {

		Object _name;
		Object _type;

		public BeanListener_SingleProperties(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private BeanListener_SingleProperties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

	}  

	public BeanListener addListProperties(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._listProperties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getListProperties() {
		return this._listProperties;
	}

	public BeanListener addListProperties(BeanListener_ListProperties value) {
		return addListProperties(value._name, value._type);
	}

	public java.util.stream.Stream<BeanListener_ListProperties> streamListProperties() {
		return this._listProperties.stream().map(BeanListener_ListProperties::new);
	}

	public java.util.List<Object> getListProperties_Name() {
		return streamListProperties().map(BeanListener_ListProperties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getListProperties_Type() {
		return streamListProperties().map(BeanListener_ListProperties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class BeanListener_ListProperties {

		Object _name;
		Object _type;

		public BeanListener_ListProperties(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private BeanListener_ListProperties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BeanListener that = (BeanListener) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BeanListener(name,singleProperties,listProperties) ::= <<public static class ~name;format=\"capitalize\"~ChangeListener implements java.beans.PropertyChangeListener {\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void propertyChange(java.beans.PropertyChangeEvent propertyChangeEvent) {\n" + 
				"		switch (propertyChangeEvent.getPropertyName()) {\n" + 
				"			\n" + 
				"			case \"~name;format=\"capitalize\"~\":\n" + 
				"				on~name;format=\"capitalize\"~Change((~name;format=\"capitalize\"~) propertyChangeEvent.getOldValue(), (java.beans.PropertyChangeEvent) propertyChangeEvent.getNewValue());\n" + 
				"				break;\n" + 
				"				\n" + 
				"~singleProperties:{it|\n" + 
				"			case \"set.~it.name~\":\n" + 
				"				onSet~it.name;format=\"capitalize\"~((~it.type~) propertyChangeEvent.getOldValue(), (~it.type~) propertyChangeEvent.getNewValue());\n" + 
				"				break;\n" + 
				"			case \"remove.~it.name~\":\n" + 
				"				onRemove~it.name;format=\"capitalize\"~((~it.type~) propertyChangeEvent.getOldValue(), (~it.type~) propertyChangeEvent.getNewValue());\n" + 
				"				break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"\n" + 
				"~listProperties:{it|\n" + 
				"			case \"add.~it.name~\":\n" + 
				"				onAdd~it.name;format=\"capitalize\"~((~it.type~) propertyChangeEvent.getOldValue(), (~it.type~) propertyChangeEvent.getNewValue());\n" + 
				"				break;\n" + 
				"			case \"remove.~it.name~\":\n" + 
				"				onRemove~it.name;format=\"capitalize\"~((~it.type~) propertyChangeEvent.getOldValue(), (~it.type~) propertyChangeEvent.getNewValue());\n" + 
				"				break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void on~name;format=\"capitalize\"~Change(~name;format=\"capitalize\"~ instance, java.beans.PropertyChangeEvent event) {\n" + 
				"		log.info(\"on~name;format=\"capitalize\"~Change \" + instance + \" \" + event);\n" + 
				"	}\n" + 
				"	\n" + 
				"~singleProperties:{it|\n" + 
				"	protected void onSet~it.name;format=\"capitalize\"~(~it.type~ oldValue, ~it.type~ newValue) {\n" + 
				"		log.info(\"onSet~it.name;format=\"capitalize\"~ \" + oldValue + \" \" + newValue);\n" + 
				"	~eom()~\n" + 
				"	\n" + 
				"	protected void onRemove~it.name;format=\"capitalize\"~(~it.type~ oldValue, ~it.type~ newValue) {\n" + 
				"		log.info(\"onRemove~it.name;format=\"capitalize\"~ \" + oldValue + \" \" + newValue);\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"~listProperties:{it|\n" + 
				"	protected void onAdd~it.name;format=\"capitalize\"~(~it.type~ oldValue, ~it.type~ newValue) {\n" + 
				"		log.info(\"onAdd~it.name;format=\"capitalize\"~ \" + oldValue + \" \" + newValue);\n" + 
				"	~eom()~\n" + 
				"	\n" + 
				"	protected void onRemove~it.name;format=\"capitalize\"~(~it.type~ oldValue, ~it.type~ newValue) {\n" + 
				"		log.info(\"onRemove~it.name;format=\"capitalize\"~ \" + oldValue + \" \" + newValue);\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  