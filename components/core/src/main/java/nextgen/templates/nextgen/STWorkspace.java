package nextgen.templates.nextgen;

public class STWorkspace {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _constructorParameters = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();

	STWorkspace(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STWorkspace");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _constructorParameters) st.add("constructorParameters", o);
		for (Object o : _methods) st.add("methods", o);
		return st.render().trim();
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

	static final String st = "STWorkspace(packageName,name,constructorParameters,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import ~packageName~.domain.STGroupModel;\n" + 
				"import ~packageName~.domain.STTemplate;\n" + 
				"import ~packageName~.model.STModel;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.util.Optional;\n" + 
				"\n" + 
				"public class ~name~ extends JTabbedPane {\n" + 
				"\n" + 
				"	private final STAppPresentationModel presentationModel;\n" + 
				"\n" + 
				"	public ~name~(STAppPresentationModel presentationModel) {\n" + 
				"		this.presentationModel = presentationModel;\n" + 
				"		setPreferredSize(new Dimension(800, 600));\n" + 
				"		~constructorParameters:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	public Optional<STModelCanvas> findCanvas() {\n" + 
				"		for (int i = 0; i < getTabCount(); i++) {\n" + 
				"				final Component tabComponentAt = getComponentAt(i);\n" + 
				"				if (tabComponentAt instanceof STModelCanvas)\n" + 
				"					return Optional.of((STModelCanvas) tabComponentAt);\n" + 
				"		}\n" + 
				"\n" + 
				"		final STModelCanvas stModelCanvas = new STModelCanvas(Color.WHITE, new Dimension(800,600),presentationModel);\n" + 
				"		addPane(\"Canvas\", stModelCanvas);\n" + 
				"		return Optional.of(stModelCanvas);\n" + 
				"	}\n" + 
				"\n" + 
				"	public STModelGrid getModelGrid(STTemplate stTemplate) {\n" + 
				"		for (int i = 0; i < getTabCount(); i++) {\n" + 
				"				final Component tabComponentAt = getComponentAt(i);\n" + 
				"				if (tabComponentAt instanceof STModelGrid) {\n" + 
				"					if (((STModelGrid) tabComponentAt).getModel().equals(stTemplate))\n" + 
				"						return (STModelGrid) tabComponentAt;\n" + 
				"				}\n" + 
				"		}\n" + 
				"\n" + 
				"		final STModelGrid stModelGrid = new STModelGrid(presentationModel, stTemplate);\n" + 
				"		addPane(stTemplate.getName() + \"-Models\", stModelGrid);\n" + 
				"		return stModelGrid;\n" + 
				"	}\n" + 
				"\n" + 
				"	public STModelEditor getModelEditor(STTemplate stTemplate, STModel stModel) {\n" + 
				"		for (int i = 0; i < getTabCount(); i++) {\n" + 
				"				final Component tabComponentAt = getComponentAt(i);\n" + 
				"				if (tabComponentAt instanceof STModelEditor) {\n" + 
				"					if (((STModelEditor) tabComponentAt).getModel().equals(stModel))\n" + 
				"						return (STModelEditor) tabComponentAt;\n" + 
				"				}\n" + 
				"		}\n" + 
				"\n" + 
				"		final STModelEditor component = new STModelEditor(presentationModel, stModel);\n" + 
				"		addPane(stTemplate.getName() + \"Model\", component);\n" + 
				"		return component;\n" + 
				"	}\n" + 
				"\n" + 
				"	public void removeSTEditor(STGroupModel stGroup) {\n" + 
				"		for (int i = 0; i < getTabCount(); i++) {\n" + 
				"				final Component tabComponentAt = getComponentAt(i);\n" + 
				"				if (tabComponentAt instanceof STEditor) {\n" + 
				"					if (((STEditor) tabComponentAt).getModel().equals(stGroup)) {\n" + 
				"						remove(i);\n" + 
				"					}\n" + 
				"				}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public STEditor getSTEditor(STGroupModel stGroup) {\n" + 
				"		for (int i = 0; i < getTabCount(); i++) {\n" + 
				"				final Component tabComponentAt = getComponentAt(i);\n" + 
				"				if (tabComponentAt instanceof STEditor) {\n" + 
				"					if (((STEditor) tabComponentAt).getModel().equals(stGroup)) {\n" + 
				"						final STEditor stEditor = (STEditor) tabComponentAt;\n" + 
				"						stEditor.setSTTemplate(null);\n" + 
				"						setSelectedComponent(stEditor);\n" + 
				"						return stEditor;\n" + 
				"					}\n" + 
				"				}\n" + 
				"		}\n" + 
				"\n" + 
				"		final STEditor component = new STEditor(stGroup, presentationModel);\n" + 
				"		component.setSTTemplate(null);\n" + 
				"		addPane(stGroup.getName(), component);\n" + 
				"		setSelectedComponent(component);\n" + 
				"		return component;\n" + 
				"	}\n" + 
				"\n" + 
				"	public STValueGrid getValueGrid() {\n" + 
				"		for (int i = 0; i < getTabCount(); i++) {\n" + 
				"				final Component tabComponentAt = getComponentAt(i);\n" + 
				"				if (tabComponentAt instanceof STValueGrid)\n" + 
				"					return (STValueGrid) tabComponentAt;\n" + 
				"		}\n" + 
				"\n" + 
				"		final STValueGrid component = new STValueGrid(presentationModel);\n" + 
				"		addPane(\"Values\", component);\n" + 
				"		return component;\n" + 
				"	}\n" + 
				"\n" + 
				"	private void addPane(String title, JComponent component) {\n" + 
				"		addTab(title, component);\n" + 
				"		setTabComponentAt(indexOfComponent(component), new ButtonTabComponent(this, title, component));\n" + 
				"	}\n" + 
				"\n" + 
				"	public void showCanvas() {\n" + 
				"		findCanvas().ifPresent(stModelCanvas -> SwingUtilities.invokeLater(() -> setSelectedComponent(stModelCanvas)));\n" + 
				"	}\n" + 
				"\n" + 
				"	class ButtonTabComponent extends JPanel {\n" + 
				"\n" + 
				"		ButtonTabComponent(final JTabbedPane pane, String title, JComponent component) {\n" + 
				"				super(new FlowLayout(FlowLayout.LEFT, 0, 0));\n" + 
				"				setOpaque(false);\n" + 
				"\n" + 
				"				final JLabel label = new JLabel(title);\n" + 
				"				label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));\n" + 
				"				add(label);\n" + 
				"\n" + 
				"				final JButton btnClose = new JButton(presentationModel.loadIcon(\"close\", \"12x12\"));\n" + 
				"				final Dimension dimension = new Dimension(12, 16);\n" + 
				"				btnClose.setMaximumSize(dimension);\n" + 
				"				btnClose.setPreferredSize(dimension);\n" + 
				"				btnClose.setMinimumSize(dimension);\n" + 
				"				btnClose.setOpaque(false);\n" + 
				"				btnClose.setContentAreaFilled(false);\n" + 
				"				btnClose.setBorderPainted(false);\n" + 
				"				btnClose.addActionListener(e -> SwingUtilities.invokeLater(() -> pane.remove(component)));\n" + 
				"				add(btnClose);\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  