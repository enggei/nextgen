package nextgen.templates.nextgen;

public class FindEditor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _componentType;
	private Object _componentName;
	private Object _titleExpression;
	private Object _modelType;
	private java.util.List<java.util.Map<String, Object>> _arguments = new java.util.ArrayList<>();

	FindEditor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("findEditor");
		st.add("componentType", _componentType);
		st.add("componentName", _componentName);
		st.add("titleExpression", _titleExpression);
		st.add("modelType", _modelType);
		for (java.util.Map<String, Object> map : _arguments) st.addAggr("arguments.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public FindEditor setComponentType(Object value) {
		this._componentType = value;
		return this;
	}

	public Object getComponentType() {
		return this._componentType;
	}

	public Object getComponentType(Object defaultValue) {
		return this._componentType == null ? defaultValue : this._componentType;
	}

	public boolean hasComponentType() {
		return this._componentType != null;
	}

	public FindEditor removeComponentType() {
		this._componentType = null;
		return this;
	} 

	public FindEditor setComponentName(Object value) {
		this._componentName = value;
		return this;
	}

	public Object getComponentName() {
		return this._componentName;
	}

	public Object getComponentName(Object defaultValue) {
		return this._componentName == null ? defaultValue : this._componentName;
	}

	public boolean hasComponentName() {
		return this._componentName != null;
	}

	public FindEditor removeComponentName() {
		this._componentName = null;
		return this;
	} 

	public FindEditor setTitleExpression(Object value) {
		this._titleExpression = value;
		return this;
	}

	public Object getTitleExpression() {
		return this._titleExpression;
	}

	public Object getTitleExpression(Object defaultValue) {
		return this._titleExpression == null ? defaultValue : this._titleExpression;
	}

	public boolean hasTitleExpression() {
		return this._titleExpression != null;
	}

	public FindEditor removeTitleExpression() {
		this._titleExpression = null;
		return this;
	} 

	public FindEditor setModelType(Object value) {
		this._modelType = value;
		return this;
	}

	public Object getModelType() {
		return this._modelType;
	}

	public Object getModelType(Object defaultValue) {
		return this._modelType == null ? defaultValue : this._modelType;
	}

	public boolean hasModelType() {
		return this._modelType != null;
	}

	public FindEditor removeModelType() {
		this._modelType = null;
		return this;
	} 


	public FindEditor setArguments(java.util.Collection<FindEditor_Arguments> values) {
			this._arguments.clear();
			values.stream().map(FindEditor_Arguments::asMap).forEach(map -> _arguments.add(map));
			return this;
		}

	public FindEditor addArguments(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._arguments.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getArguments() {
		return this._arguments;
	}

	public FindEditor addArguments(FindEditor_Arguments value) {
		return addArguments(value._type, value._name);
	}

	public java.util.stream.Stream<FindEditor_Arguments> streamArguments() {
		return this._arguments.stream().map(FindEditor_Arguments::new);
	}

	public java.util.List<Object> getArguments_Type() {
		return streamArguments().map(FindEditor_Arguments::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getArguments_Name() {
		return streamArguments().map(FindEditor_Arguments::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class FindEditor_Arguments {

		Object _type;
		Object _name;

		public FindEditor_Arguments(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private FindEditor_Arguments(java.util.Map<String, Object> map) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FindEditor that = (FindEditor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "findEditor(arguments,componentType,componentName,titleExpression,modelType) ::= <<public ~componentType~ get~componentName;format=\"capitalize\"~(~modelType~ model~if(arguments)~,~arguments:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"	for (int i = 0; i < getTabCount(); i++) {\n" + 
				"		final Component tabComponentAt = getComponentAt(i);\n" + 
				"		if (tabComponentAt instanceof ~componentType~ && (((~componentType~) tabComponentAt).getModel().equals(model))) {\n" + 
				"			final ~componentType~ component = (~componentType~) tabComponentAt;\n" + 
				"			setSelectedComponent(component);\n" + 
				"			return component;\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	final ~componentType~ component = new ~componentType~(model~if(arguments)~,~arguments:{it|~it.name~};separator=\", \"~~endif~);\n" + 
				"	addPane(~titleExpression~, component);\n" + 
				"	setSelectedComponent(component);\n" + 
				"	return component;\n" + 
				"}\n" + 
				"\n" + 
				"public void remove~componentName;format=\"capitalize\"~(String uuid) {\n" + 
				"	for (int i = 0; i < getTabCount(); i++) {\n" + 
				"	   if (getComponentAt(i) instanceof ~componentType~ && (((~componentType~) getComponentAt(i)).getUuid().equals(uuid))) {\n" + 
				"	      int componentIndex = i;\n" + 
				"	      SwingUtilities.invokeLater(() -> remove(componentIndex));\n" + 
				"	   }\n" + 
				"	}\n" + 
				"} >>";
}  