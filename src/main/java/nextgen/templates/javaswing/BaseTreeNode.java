package nextgen.templates.javaswing;

public class BaseTreeNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _methods = new java.util.ArrayList<>();

	BaseTreeNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BaseTreeNode");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _methods) st.add("methods", o);
		return st.render().trim();
	}

	public BaseTreeNode setPackageName(Object value) {
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

	public BaseTreeNode removePackageName() {
		this._packageName = null;
		return this;
	} 

	public BaseTreeNode setName(Object value) {
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

	public BaseTreeNode removeName() {
		this._name = null;
		return this;
	} 

	public BaseTreeNode addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public BaseTreeNode setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BaseTreeNode setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public BaseTreeNode removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public BaseTreeNode removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseTreeNode that = (BaseTreeNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BaseTreeNode(methods,packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import javax.swing.tree.*;\n" + 
				"import java.util.ArrayList;\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"public class ~name~<T> extends DefaultMutableTreeNode {\n" + 
				"\n" + 
				"	private String label;\n" + 
				"	private ImageIcon icon;\n" + 
				"	private String tooltip;\n" + 
				"	private String uuid;\n" + 
				"\n" + 
				"	public ~name~(T model) {\n" + 
				"		setUserObject(model);\n" + 
				"		this.label = \"\";\n" + 
				"		this.icon = null;\n" + 
				"		this.tooltip = \"\";\n" + 
				"		this.uuid = java.util.UUID.randomUUID().toString();\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name~(T model, String uuid) {\n" + 
				"		setUserObject(model);\n" + 
				"		this.label = \"NO_NAME\";\n" + 
				"		this.icon = null;\n" + 
				"		this.tooltip = \"\";\n" + 
				"		this.uuid = uuid;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public ~name~(T model, String uuid, String label, ImageIcon icon, String tooltip) {\n" + 
				"		setUserObject(model);\n" + 
				"		this.label = label;\n" + 
				"		this.icon = icon;\n" + 
				"		this.tooltip = tooltip;\n" + 
				"		this.uuid = uuid;\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	T getModel() { return (T) this.getUserObject(); }\n" + 
				"\n" + 
				"	String getLabel() { return label; }\n" + 
				"\n" + 
				"	void setLabel(String value) { this.label = value == null || value.trim().length() == 0 ? \"NO_NAME\" : value; }\n" + 
				"\n" + 
				"	ImageIcon getIcon() { return icon; }\n" + 
				"\n" + 
				"	void setIcon(ImageIcon value) { this.icon = value; }\n" + 
				"\n" + 
				"	String getTooltip() { return tooltip; }\n" + 
				"\n" + 
				"	void setTooltip(String value) { this.tooltip = tooltip; }\n" + 
				"\n" + 
				"	String getUuid() {\n" + 
				"		return uuid;\n" + 
				"	}\n" + 
				"	\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	List<Action> getActions() {\n" + 
				"		return new ArrayList<>();\n" + 
				"	}\n" + 
				"\n" + 
				"	public void setSelected() {\n" + 
				"	}\n" + 
				"} >>";
}  