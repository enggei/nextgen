package nextgen.templates.nextgen;

public class FindEditor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _modelType;
	private Object _titleExpression;
	private Object _componentType;
	private Object _componentName;

	FindEditor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("findEditor");
		st.add("modelType", _modelType);
		st.add("titleExpression", _titleExpression);
		st.add("componentType", _componentType);
		st.add("componentName", _componentName);
		return st.render().trim();
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

	static final String st = "findEditor(modelType,titleExpression,componentType,componentName) ::= <<public ~componentType~ get~componentName;format=\"capitalize\"~(~modelType~ model) {\n" + 
				"	for (int i = 0; i < getTabCount(); i++) {\n" + 
				"		final Component tabComponentAt = getComponentAt(i);\n" + 
				"		if (tabComponentAt instanceof ~componentType~ && (((~componentType~) tabComponentAt).getModel().equals(model))) {\n" + 
				"			final ~componentType~ component = (~componentType~) tabComponentAt;\n" + 
				"			setSelectedComponent(component);\n" + 
				"			return component;\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	final ~componentType~ component = new ~componentType~(model);\n" + 
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