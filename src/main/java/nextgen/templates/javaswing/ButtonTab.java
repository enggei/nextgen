package nextgen.templates.javaswing;

public class ButtonTab {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _packageName;

	ButtonTab(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ButtonTab");
		st.add("name", _name);
		st.add("packageName", _packageName);
		return st.render().trim();
	}

	public ButtonTab setName(Object value) {
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

	public ButtonTab removeName() {
		this._name = null;
		return this;
	} 

	public ButtonTab setPackageName(Object value) {
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

	public ButtonTab removePackageName() {
		this._packageName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ButtonTab that = (ButtonTab) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ButtonTab(name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"\n" + 
				"class ~name~ extends JPanel {\n" + 
				"\n" + 
				"	~name~(final JTabbedPane pane, String title, JComponent component) {\n" + 
				"		super(new FlowLayout(FlowLayout.LEFT, 0, 0));\n" + 
				"		setOpaque(false);\n" + 
				"\n" + 
				"		final JLabel label = new JLabel(title);\n" + 
				"		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));\n" + 
				"		add(label);\n" + 
				"\n" + 
				"		final java.net.URL resource = getClass().getClassLoader().getResource(\"icons/close12x12.png\");\n" + 
				"		final JButton btnClose = new JButton(new ImageIcon(resource));\n" + 
				"		final Dimension dimension = new Dimension(12, 16);\n" + 
				"		btnClose.setMaximumSize(dimension);\n" + 
				"		btnClose.setPreferredSize(dimension);\n" + 
				"		btnClose.setMinimumSize(dimension);\n" + 
				"		btnClose.setOpaque(false);\n" + 
				"		btnClose.setContentAreaFilled(false);\n" + 
				"		btnClose.setBorderPainted(false);\n" + 
				"		btnClose.addActionListener(e -> SwingUtilities.invokeLater(() -> pane.remove(component)));\n" + 
				"		add(btnClose);\n" + 
				"	}\n" + 
				"} >>";
}  