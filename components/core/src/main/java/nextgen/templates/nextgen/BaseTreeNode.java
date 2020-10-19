package nextgen.templates.nextgen;

public class BaseTreeNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	BaseTreeNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BaseTreeNode");
		return st.render().trim();
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

	static final String st = "BaseTreeNode() ::= <<public class BaseTreeNode<T> extends DefaultMutableTreeNode {\n" + 
				"\n" + 
				"	protected String label;\n" + 
				"	protected ImageIcon icon;\n" + 
				"	protected String tooltip;\n" + 
				"\n" + 
				"	public BaseTreeNode(T model, ImageIcon icon) {\n" + 
				"		setUserObject(model);\n" + 
				"		setLabel(model.toString());\n" + 
				"		this.icon = icon;\n" + 
				"		this.tooltip = \"\";\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public T getModel() {\n" + 
				"		return (T) getUserObject();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void setLabel(String label) {\n" + 
				"		this.label = label;\n" + 
				"		if (this.label == null || this.label.trim().length() == 0) this.label = \"[EMPTY]\";\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getLabel() {\n" + 
				"		return label;\n" + 
				"	}\n" + 
				"\n" + 
				"	public ImageIcon getIcon() {\n" + 
				"		return icon;\n" + 
				"	}\n" + 
				"\n" + 
				"	protected java.util.List<Action> getActions() {\n" + 
				"		java.util.List<Action> actions = new ArrayList<>();\n" + 
				"		actions.add(newAction(\"Expand\", actionEvent -> {\n" + 
				"			SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), true));\n" + 
				"		}));\n" + 
				"		actions.add(newAction(\"Collapse\", actionEvent -> {\n" + 
				"			SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), false));\n" + 
				"		}));\n" + 
				"		return actions;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object obj) {\n" + 
				"		if (!(obj instanceof BaseTreeNode)) return false;\n" + 
				"		return getModel().equals(((BaseTreeNode<?>) obj).getModel());\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return getModel().hashCode();\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public <T> Optional<T> getParentNode(Class<T> type) {\n" + 
				"		if (getClass().equals(type)) return (Optional<T>) Optional.of(this);\n" + 
				"\n" + 
				"		final TreeNode parent = getParent();\n" + 
				"		if (!(parent instanceof BaseTreeNode)) return Optional.empty();\n" + 
				"\n" + 
				"		return ((BaseTreeNode<?>) parent).getParentNode(type);\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getTooltip() {\n" + 
				"		return tooltip;\n" + 
				"	}\n" + 
				"\n" + 
				"	public void nodeChanged() {\n" + 
				"		treeModel.nodeChanged(this);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected TreePath addChild(BaseTreeNode<?> child) {\n" + 
				"\n" + 
				"		int n = getChildCount();\n" + 
				"		if (n == 0) {\n" + 
				"			add(child);\n" + 
				"			return new javax.swing.tree.TreePath(child.getPath());\n" + 
				"		}\n" + 
				"\n" + 
				"		for (int i = 0; i < n; i++) {\n" + 
				"			final BaseTreeNode<?> node = (BaseTreeNode<?>) getChildAt(i);\n" + 
				"			if (node.getLabel().compareTo(child.getLabel()) > 0) {\n" + 
				"				insert(child, i);\n" + 
				"				return new javax.swing.tree.TreePath(child.getPath());\n" + 
				"			}\n" + 
				"		}\n" + 
				"\n" + 
				"		add(child);\n" + 
				"\n" + 
				"		return new javax.swing.tree.TreePath(child.getPath());\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void addAndSelectChild(BaseTreeNode<?> child) {\n" + 
				"		final TreePath path = addChild(child);\n" + 
				"		tree.scrollPathToVisible(path);\n" + 
				"		tree.setSelectionPath(path);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected <T> java.util.stream.Stream<T> getChildren(Class<T> type) {\n" + 
				"		final java.util.Set<T> set = new java.util.LinkedHashSet<>();\n" + 
				"		final int childCount = getChildCount();\n" + 
				"		for (int i = 0; i < childCount; i++) {\n" + 
				"			if (getChildAt(i).getClass().isAssignableFrom(type))\n" + 
				"				set.add((T) getChildAt(i));\n" + 
				"		}\n" + 
				"\n" + 
				"		return set.stream();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected TreePath find(java.util.function.Predicate<BaseTreeNode<?>~gt()~ predicate) {\n" + 
				"		final int childCount = getChildCount();\n" + 
				"		for (int i = 0; i < childCount; i++) {\n" + 
				"			final BaseTreeNode<?> childAt = (BaseTreeNode<?>) getChildAt(i);\n" + 
				"			if (predicate.test(childAt))\n" + 
				"				return (childAt).getThisPath();\n" + 
				"			else {\n" + 
				"				final TreePath treePath = childAt.find(predicate);\n" + 
				"				if (treePath != null) return treePath;\n" + 
				"			}\n" + 
				"		}\n" + 
				"		return null;\n" + 
				"	}\n" + 
				"\n" + 
				"	protected TreePath getThisPath() {\n" + 
				"		return new TreePath(getPath());\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void expandTreeNodesRecursive(TreePath parent, boolean expand) {\n" + 
				"		TreeModel model = tree.getModel();\n" + 
				"\n" + 
				"		Object node = parent.getLastPathComponent();\n" + 
				"		int childCount = model.getChildCount(node);\n" + 
				"		for (int j = 0; j < childCount; j++) \n" + 
				"			expandTreeNodesRecursive(parent.pathByAddingChild(model.getChild(node, j)), expand);\n" + 
				"\n" + 
				"		if (expand) \n" + 
				"			tree.expandPath(parent);\n" + 
				"		else \n" + 
				"			tree.collapsePath(parent);\n" + 
				"	}\n" + 
				"} >>";
}  