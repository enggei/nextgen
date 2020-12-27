package nextgen.templates.nextgen;

public class STModelEditor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _model;
	private String _name;
	private Object _packageName;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	STModelEditor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STModelEditor");
		st.add("model", _model);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{component,name}", map.get("component"), map.get("name"));
		return st.render().trim();
	}

	public STModelEditor setModel(Object value) {
		this._model = value;
		return this;
	}

	public Object getModel() {
		return this._model;
	}

	public Object getModel(Object defaultValue) {
		return this._model == null ? defaultValue : this._model;
	}

	public boolean hasModel() {
		return this._model != null;
	}

	public STModelEditor removeModel() {
		this._model = null;
		return this;
	} 

	public STModelEditor setName(String value) {
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

	public STModelEditor removeName() {
		this._name = null;
		return this;
	} 

	public STModelEditor setPackageName(Object value) {
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

	public STModelEditor removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STModelEditor addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public STModelEditor setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STModelEditor setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public STModelEditor removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public STModelEditor removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public STModelEditor addProperties(Object _component, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("component", _component);
		map.put("name", _name);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public STModelEditor addProperties(STModelEditor_Properties value) {
		return addProperties(value._component, value._name);
	}

	public java.util.stream.Stream<STModelEditor_Properties> streamProperties() {
		return this._properties.stream().map(STModelEditor_Properties::new);
	}

	public java.util.List<Object> getProperties_Component() {
		return streamProperties().map(STModelEditor_Properties::getComponent).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(STModelEditor_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class STModelEditor_Properties {

		Object _component;
		Object _name;

		public STModelEditor_Properties(Object _component, Object _name) {
			this._component = _component;
			this._name = _name;
		}

		private STModelEditor_Properties(java.util.Map<String, Object> map) {
			this._component = (Object) map.get("component");
			this._name = (Object) map.get("name");
		}

		public Object getComponent() {
			return this._component;
		}

		public Object getName() {
			return this._name;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STModelEditor that = (STModelEditor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "STModelEditor(model,statements,properties,name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ extends nextgen.swing.AbstractEditor {\n" + 
				"\n" + 
				"   public ~name~(~model~ model) {\n" + 
				"\n" + 
				"      ~properties:{it|final FlowPanel ~it.name~Panel = newFlowPanel().append(newLabel(\"~it.name;format=\"capitalize\"~\")).append(new ~it.component~(model.get~it.name;format=\"capitalize\"~()));};separator=\"\\n\"~\n" + 
				"\n" + 
				"      final ColumnPanel center = newColumnPanel()~properties:{it|.append(~it.name~Panel)}~;\n" + 
				"\n" + 
				"      ~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"      add(center, java.awt.BorderLayout.CENTER);\n" + 
				"   }\n" + 
				"} >>";
}  