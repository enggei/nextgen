package nextgen.templates.nextgen;

public class STWorkspace {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _height;
	private Object _width;
	private Object _name;
	private Object _packageName;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorParameters = new java.util.ArrayList<>();
	private java.util.List<Object> _componentMethods = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	STWorkspace(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STWorkspace");
		st.add("height", _height);
		st.add("width", _width);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _constructorParameters) st.add("constructorParameters", o);
		for (Object o : _componentMethods) st.add("componentMethods", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name,init,type}", map.get("name"), map.get("init"), map.get("type"));
		return st.render().trim();
	}

	public STWorkspace setHeight(Object value) {
		this._height = value;
		return this;
	}

	public Object getHeight() {
		return this._height;
	}

	public Object getHeight(Object defaultValue) {
		return this._height == null ? defaultValue : this._height;
	}

	public boolean hasHeight() {
		return this._height != null;
	}

	public STWorkspace removeHeight() {
		this._height = null;
		return this;
	} 

	public STWorkspace setWidth(Object value) {
		this._width = value;
		return this;
	}

	public Object getWidth() {
		return this._width;
	}

	public Object getWidth(Object defaultValue) {
		return this._width == null ? defaultValue : this._width;
	}

	public boolean hasWidth() {
		return this._width != null;
	}

	public STWorkspace removeWidth() {
		this._width = null;
		return this;
	} 

	public STWorkspace setName(Object value) {
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

	public STWorkspace removeName() {
		this._name = null;
		return this;
	} 

	public STWorkspace setPackageName(Object value) {
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

	public STWorkspace removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STWorkspace addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public STWorkspace setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STWorkspace setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public STWorkspace removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public STWorkspace removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public STWorkspace addConstructorParameters(Object value) {
		this._constructorParameters.add(value);
		return this;
	}

	public STWorkspace setConstructorParameters(Object[] value) {
		this._constructorParameters.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STWorkspace setConstructorParameters(java.util.Collection<Object> values) {
		this._constructorParameters.addAll(values);
		return this;
	}

	public STWorkspace removeConstructorParameters(Object value) {
		this._constructorParameters.remove(value);
		return this;
	}

	public STWorkspace removeConstructorParameters(int index) {
		this._constructorParameters.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorParameters() {
		return this._constructorParameters;
	} 

	public STWorkspace addComponentMethods(Object value) {
		this._componentMethods.add(value);
		return this;
	}

	public STWorkspace setComponentMethods(Object[] value) {
		this._componentMethods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STWorkspace setComponentMethods(java.util.Collection<Object> values) {
		this._componentMethods.addAll(values);
		return this;
	}

	public STWorkspace removeComponentMethods(Object value) {
		this._componentMethods.remove(value);
		return this;
	}

	public STWorkspace removeComponentMethods(int index) {
		this._componentMethods.remove(index);
		return this;
	}

	public java.util.List<Object> getComponentMethods() {
		return this._componentMethods;
	} 

	public STWorkspace addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public STWorkspace setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STWorkspace setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public STWorkspace removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public STWorkspace removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public STWorkspace setFields(java.util.Collection<STWorkspace_Fields> values) {
			this._fields.clear();
			values.stream().map(STWorkspace_Fields::asMap).forEach(map -> _fields.add(map));
			return this;
		}

	public STWorkspace addFields(Object _name, Object _init, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("init", _init);
		map.put("type", _type);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public STWorkspace addFields(STWorkspace_Fields value) {
		return addFields(value._name, value._init, value._type);
	}

	public java.util.stream.Stream<STWorkspace_Fields> streamFields() {
		return this._fields.stream().map(STWorkspace_Fields::new);
	}

	public java.util.List<Object> getFields_Name() {
		return streamFields().map(STWorkspace_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Init() {
		return streamFields().map(STWorkspace_Fields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(STWorkspace_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class STWorkspace_Fields {

		Object _name;
		Object _init;
		Object _type;

		public STWorkspace_Fields(Object _name, Object _init, Object _type) {
			this._name = _name;
			this._init = _init;
			this._type = _type;
		}

		private STWorkspace_Fields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._init = (Object) map.get("init");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getInit() {
			return this._init;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("init", _init);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STWorkspace that = (STWorkspace) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "STWorkspace(height,width,imports,name,packageName,constructorParameters,fields,componentMethods,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.awt.event.MouseAdapter;\n" + 
				"import java.awt.event.MouseEvent;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.function.Predicate;\n" + 
				"~imports:{it|import ~it~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends JTabbedPane {\n" + 
				"\n" + 
				"	private final java.util.Map<java.awt.Component, nextgen.swing.STWorkspace.ButtonTabComponent> tabComponents = new java.util.LinkedHashMap<>();\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~() {\n" + 
				"		setPreferredSize(new Dimension(~width~, ~height~));\n" + 
				"		setMinimumSize(new Dimension(100, 100));\n" + 
				"		~constructorParameters:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~fields:{it|public ~it.type~ get~it.name;format=\"capitalize\"~() {\n" + 
				"	return ~it.name~;\n" + 
				"~eom()~\n" + 
				"};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	// components\n" + 
				"\n" + 
				"	~componentMethods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private nextgen.swing.STAppPresentationModel appModel() {\n" + 
				"		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();\n" + 
				"	}\n" + 
				"\n" + 
				"	public <T extends Component> Optional<T> find(Predicate<Component> predicate) {\n" + 
				"		for (int i = 0; i < getTabCount(); i++)\n" + 
				"			if (predicate.test(getComponentAt(i)))\n" + 
				"				return Optional.of((T) getComponentAt(i));\n" + 
				"		return Optional.empty();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void addPane(String title, JComponent component) {\n" + 
				"		addTab(title, component);\n" + 
				"		final nextgen.swing.STWorkspace.ButtonTabComponent tabComponent = new nextgen.swing.STWorkspace.ButtonTabComponent(this, title, component);\n" + 
				"		tabComponents.put(component, tabComponent);\n" + 
				"		setTabComponentAt(indexOfComponent(component), tabComponent);\n" + 
				"	}\n" + 
				"\n" + 
				"	class ButtonTabComponent extends JPanel {\n" + 
				"\n" + 
				"		private final javax.swing.JLabel label;\n" + 
				"\n" + 
				"		ButtonTabComponent(final JTabbedPane pane, String title, JComponent component) {\n" + 
				"			super(new FlowLayout(FlowLayout.LEFT, 0, 0));\n" + 
				"			setOpaque(false);\n" + 
				"\n" + 
				"			this.label = nextgen.swing.ComponentFactory.newJLabel(title);\n" + 
				"			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));\n" + 
				"			add(label);\n" + 
				"\n" + 
				"			addMouseListener(new MouseAdapter() {\n" + 
				"				@Override\n" + 
				"				public void mouseClicked(MouseEvent e) {\n" + 
				"					if (SwingUtilities.isRightMouseButton(e))\n" + 
				"						SwingUtilities.invokeLater(() -> {\n" + 
				"							final JPopupMenu pop = new JPopupMenu();\n" + 
				"\n" + 
				"							pop.add(new AbstractAction(\"Close\") {\n" + 
				"								@Override\n" + 
				"								public void actionPerformed(ActionEvent actionEvent) {\n" + 
				"									close(component);\n" + 
				"								}\n" + 
				"							});\n" + 
				"\n" + 
				"							pop.add(new AbstractAction(\"Close Others\") {\n" + 
				"								@Override\n" + 
				"								public void actionPerformed(ActionEvent actionEvent) {\n" + 
				"									closeAllExcept(component);\n" + 
				"								}\n" + 
				"							});\n" + 
				"\n" + 
				"							pop.add(new AbstractAction(\"Close All\") {\n" + 
				"								@Override\n" + 
				"								public void actionPerformed(ActionEvent actionEvent) {\n" + 
				"									closeAll();\n" + 
				"								}\n" + 
				"							});\n" + 
				"\n" + 
				"							pop.show(ButtonTabComponent.this, e.getX(), e.getY());\n" + 
				"						});\n" + 
				"					else {\n" + 
				"						SwingUtilities.invokeLater(() -> pane.setSelectedComponent(component));\n" + 
				"					}\n" + 
				"				}\n" + 
				"			});\n" + 
				"		}\n" + 
				"\n" + 
				"		void setTitle(String title) {\n" + 
				"			SwingUtilities.invokeLater(() -> label.setText(title));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private void close(JComponent component) {\n" + 
				"		SwingUtilities.invokeLater(() -> remove(component));\n" + 
				"	}\n" + 
				"\n" + 
				"	private void closeAllExcept(JComponent component) {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			for (int i = getTabCount() - 1; i >= 0; i--) {\n" + 
				"				final Component componentAt = getComponentAt(i);\n" + 
				"				if (componentAt.equals(component)) continue;\n" + 
				"				remove(i);\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void closeAll() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			for (int i = getTabCount() - 1; i >= 0; i--) {\n" + 
				"				remove(i);\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"} >>";
}  