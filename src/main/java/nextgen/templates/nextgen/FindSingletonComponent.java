package nextgen.templates.nextgen;

public class FindSingletonComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _componentType;
	private Object _newInstanceExpression;
	private Object _nameExpression;
	private String _name;

	FindSingletonComponent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("findSingletonComponent");
		st.add("componentType", _componentType);
		st.add("newInstanceExpression", _newInstanceExpression);
		st.add("nameExpression", _nameExpression);
		st.add("name", _name);
		return st.render().trim();
	}

	public FindSingletonComponent setComponentType(Object value) {
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

	public FindSingletonComponent removeComponentType() {
		this._componentType = null;
		return this;
	} 

	public FindSingletonComponent setNewInstanceExpression(Object value) {
		this._newInstanceExpression = value;
		return this;
	}

	public Object getNewInstanceExpression() {
		return this._newInstanceExpression;
	}

	public Object getNewInstanceExpression(Object defaultValue) {
		return this._newInstanceExpression == null ? defaultValue : this._newInstanceExpression;
	}

	public boolean hasNewInstanceExpression() {
		return this._newInstanceExpression != null;
	}

	public FindSingletonComponent removeNewInstanceExpression() {
		this._newInstanceExpression = null;
		return this;
	} 

	public FindSingletonComponent setNameExpression(Object value) {
		this._nameExpression = value;
		return this;
	}

	public Object getNameExpression() {
		return this._nameExpression;
	}

	public Object getNameExpression(Object defaultValue) {
		return this._nameExpression == null ? defaultValue : this._nameExpression;
	}

	public boolean hasNameExpression() {
		return this._nameExpression != null;
	}

	public FindSingletonComponent removeNameExpression() {
		this._nameExpression = null;
		return this;
	} 

	public FindSingletonComponent setName(String value) {
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

	public FindSingletonComponent removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FindSingletonComponent that = (FindSingletonComponent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "findSingletonComponent(componentType,newInstanceExpression,nameExpression,name) ::= <<public ~componentType~ get~name;format=\"capitalize\"~() {\n" + 
				"	return (~componentType~) find(component -> component instanceof ~componentType~)\n" + 
				"			.orElseGet(() -> {\n" + 
				"				final ~componentType~ component = ~newInstanceExpression~;\n" + 
				"				addPane(~nameExpression~, component);\n" + 
				"				return component;\n" + 
				"			});\n" + 
				"}\n" + 
				"\n" + 
				"public void remove~name;format=\"capitalize\"~() {\n" + 
				"   for (int i = 0; i < getTabCount(); i++) {\n" + 
				"      final Component tabComponentAt = getComponentAt(i);\n" + 
				"      if (tabComponentAt instanceof ~componentType~) {\n" + 
				"      	int componentIndex = i;\n" + 
				"			SwingUtilities.invokeLater(() -> remove(componentIndex));\n" + 
				"		}\n" + 
				"   }\n" + 
				"} >>";
}  