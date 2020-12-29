package nextgen.templates.javaswing;

public class JPanel {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private PANEL_LAYOUT _layout;
	private Object _innerClass;
	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _constructorParameters = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	JPanel(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JPanel");
		st.add("layout", _layout);
		st.add("innerClass", _innerClass);
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _imports) st.add("imports", o);
		for (java.util.Map<String, Object> map : _constructorParameters) st.addAggr("constructorParameters.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{init,name,type}", map.get("init"), map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public JPanel setLayout(PANEL_LAYOUT value) {
		this._layout = value;
		return this;
	}

	public PANEL_LAYOUT getLayout() {
		return this._layout;
	}

	public PANEL_LAYOUT getLayout(PANEL_LAYOUT defaultValue) {
		return this._layout == null ? defaultValue : this._layout;
	}

	public boolean hasLayout() {
		return this._layout != null;
	}

	public JPanel removeLayout() {
		this._layout = null;
		return this;
	} 

	public JPanel setInnerClass(Object value) {
		this._innerClass = value;
		return this;
	}

	public Object getInnerClass() {
		return this._innerClass;
	}

	public Object getInnerClass(Object defaultValue) {
		return this._innerClass == null ? defaultValue : this._innerClass;
	}

	public boolean hasInnerClass() {
		return this._innerClass != null;
	}

	public JPanel removeInnerClass() {
		this._innerClass = null;
		return this;
	} 

	public JPanel setPackageName(Object value) {
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

	public JPanel removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JPanel setName(Object value) {
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

	public JPanel removeName() {
		this._name = null;
		return this;
	} 

	public JPanel addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public JPanel setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JPanel setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public JPanel removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public JPanel removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public JPanel addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public JPanel setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JPanel setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public JPanel removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public JPanel removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public JPanel addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public JPanel setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JPanel setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public JPanel removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public JPanel removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public JPanel addConstructorParameters(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._constructorParameters.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getConstructorParameters() {
		return this._constructorParameters;
	}

	public JPanel addConstructorParameters(JPanel_ConstructorParameters value) {
		return addConstructorParameters(value._type, value._name);
	}

	public java.util.stream.Stream<JPanel_ConstructorParameters> streamConstructorParameters() {
		return this._constructorParameters.stream().map(JPanel_ConstructorParameters::new);
	}

	public java.util.List<Object> getConstructorParameters_Type() {
		return streamConstructorParameters().map(JPanel_ConstructorParameters::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getConstructorParameters_Name() {
		return streamConstructorParameters().map(JPanel_ConstructorParameters::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class JPanel_ConstructorParameters {

		Object _type;
		Object _name;

		public JPanel_ConstructorParameters(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private JPanel_ConstructorParameters(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	}  

	public JPanel addFields(Object _init, Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("init", _init);
		map.put("name", _name);
		map.put("type", _type);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public JPanel addFields(JPanel_Fields value) {
		return addFields(value._init, value._name, value._type);
	}

	public java.util.stream.Stream<JPanel_Fields> streamFields() {
		return this._fields.stream().map(JPanel_Fields::new);
	}

	public java.util.List<Object> getFields_Init() {
		return streamFields().map(JPanel_Fields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(JPanel_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(JPanel_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class JPanel_Fields {

		Object _init;
		Object _name;
		Object _type;

		public JPanel_Fields(Object _init, Object _name, Object _type) {
			this._init = _init;
			this._name = _name;
			this._type = _type;
		}

		private JPanel_Fields(java.util.Map<String, Object> map) {
			this._init = (Object) map.get("init");
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getInit() {
			return this._init;
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
		JPanel that = (JPanel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JPanel(layout,constructorParameters,constructorStatements,methods,innerClass,imports,packageName,fields,name) ::= <<~if(innerClass)~~else~package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~\n" + 
				"public class ~name~ extends javax.swing.JPanel {\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~(~constructorParameters:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(~layout~);\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  