package nextgen.templates.javaswing;

public class JTree {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _treeModel;
	private Object _nodeType;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();

	JTree(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JTree");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("treeModel", _treeModel);
		st.add("nodeType", _nodeType);
		for (Object o : _imports) st.add("imports", o);
		return st.render().trim();
	}

	public JTree setPackageName(Object value) {
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

	public JTree removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JTree setName(Object value) {
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

	public JTree removeName() {
		this._name = null;
		return this;
	} 

	public JTree setTreeModel(Object value) {
		this._treeModel = value;
		return this;
	}

	public Object getTreeModel() {
		return this._treeModel;
	}

	public Object getTreeModel(Object defaultValue) {
		return this._treeModel == null ? defaultValue : this._treeModel;
	}

	public boolean hasTreeModel() {
		return this._treeModel != null;
	}

	public JTree removeTreeModel() {
		this._treeModel = null;
		return this;
	} 

	public JTree setNodeType(Object value) {
		this._nodeType = value;
		return this;
	}

	public Object getNodeType() {
		return this._nodeType;
	}

	public Object getNodeType(Object defaultValue) {
		return this._nodeType == null ? defaultValue : this._nodeType;
	}

	public boolean hasNodeType() {
		return this._nodeType != null;
	}

	public JTree removeNodeType() {
		this._nodeType = null;
		return this;
	} 

	public JTree addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public JTree setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JTree setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public JTree removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public JTree removeImports(int index) {
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
		JTree that = (JTree) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JTree(packageName,imports,name,treeModel,nodeType) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import javax.swing.tree.DefaultTreeCellRenderer;\n" + 
				"import javax.swing.tree.TreePath;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.MouseAdapter;\n" + 
				"import java.awt.event.MouseEvent;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends JTree {\n" + 
				"\n" + 
				"	public ~name~(~treeModel~ model) {\n" + 
				"		setModel(model);\n" + 
				"		setCellRenderer(new ~name~CellRenderer());\n" + 
				"		addMouseListener(new ~name~MouseListener());\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class ~name~CellRenderer extends DefaultTreeCellRenderer {\n" + 
				"		@Override\n" + 
				"		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {\n" + 
				"			final ~nodeType~ node = (~nodeType~) value;\n" + 
				"			final ImageIcon icon = node.getIcon();\n" + 
				"			setIcon(icon);\n" + 
				"			setOpenIcon(icon);\n" + 
				"			setClosedIcon(icon);\n" + 
				"			setLeafIcon(icon);\n" + 
				"			setToolTipText(node.getTooltip());\n" + 
				"			return super.getTreeCellRendererComponent(tree, node.getLabel(), sel, expanded, leaf, row, hasFocus);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class ~name~MouseListener extends MouseAdapter {\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseClicked(MouseEvent e) {\n" + 
				"\n" + 
				"			final TreePath selectionPath = getPathForLocation(e.getX(), e.getY());\n" + 
				"			if (selectionPath == null) return;\n" + 
				"			final ~nodeType~<?> node = (~nodeType~<?>) selectionPath.getLastPathComponent();\n" + 
				"\n" + 
				"			if (SwingUtilities.isRightMouseButton(e)) {\n" + 
				"\n" + 
				"				final JPopupMenu pop = new JPopupMenu();\n" + 
				"				for (Action action : node.getActions())\n" + 
				"					pop.add(action);\n" + 
				"\n" + 
				"				SwingUtilities.invokeLater(() -> pop.show(~name~.this, e.getX(), e.getY()));\n" + 
				"\n" + 
				"			} else {\n" + 
				"\n" + 
				"				node.setSelected();\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  