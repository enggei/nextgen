package nextgen.templates.javaswing;

public class JTabbedPane {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _packageName;
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _imports = new java.util.ArrayList<>();

	JTabbedPane(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JTabbedPane");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _imports) st.add("imports", o);
		return st.render().trim();
	}

	public JTabbedPane setName(Object value) {
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

	public JTabbedPane removeName() {
		this._name = null;
		return this;
	} 

	public JTabbedPane setPackageName(Object value) {
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

	public JTabbedPane removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JTabbedPane addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public JTabbedPane setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JTabbedPane setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public JTabbedPane removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public JTabbedPane removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public JTabbedPane addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public JTabbedPane setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JTabbedPane setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public JTabbedPane removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public JTabbedPane removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public JTabbedPane addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public JTabbedPane setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JTabbedPane setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public JTabbedPane removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public JTabbedPane removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JTabbedPane that = (JTabbedPane) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JTabbedPane(name,constructorStatements,methods,packageName,imports) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.Component;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.function.Predicate;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends JTabbedPane {\n" + 
				"\n" + 
				"	public ~name~() {\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	public <T extends Component> Optional<T> find(Predicate<Component> predicate) {\n" + 
				"		for (int i = 0; i < getTabCount(); i++) \n" + 
				"			if (predicate.test(getComponentAt(i)))\n" + 
				"				return Optional.of((T) getComponentAt(i));\n" + 
				"		return Optional.empty();\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  