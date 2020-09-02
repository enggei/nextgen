package nextgen.templates.piccolo2d;

public class LayoutTreeAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _nodeType;
	private Object _canvasName;

	LayoutTreeAction(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LayoutTreeAction");
		st.add("name", _name);
		st.add("nodeType", _nodeType);
		st.add("canvasName", _canvasName);
		return st.render().trim();
	}

	public LayoutTreeAction setName(Object value) {
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

	public LayoutTreeAction removeName() {
		this._name = null;
		return this;
	} 

	public LayoutTreeAction setNodeType(Object value) {
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

	public LayoutTreeAction removeNodeType() {
		this._nodeType = null;
		return this;
	} 

	public LayoutTreeAction setCanvasName(Object value) {
		this._canvasName = value;
		return this;
	}

	public Object getCanvasName() {
		return this._canvasName;
	}

	public Object getCanvasName(Object defaultValue) {
		return this._canvasName == null ? defaultValue : this._canvasName;
	}

	public boolean hasCanvasName() {
		return this._canvasName != null;
	}

	public LayoutTreeAction removeCanvasName() {
		this._canvasName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LayoutTreeAction that = (LayoutTreeAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LayoutTreeAction(name,nodeType,canvasName) ::= <<protected static final class ~name~ extends NodeAction<~nodeType~> {\n" + 
				"\n" + 
				"	private final Map<UUID, ~nodeType~> parentsMap = new LinkedHashMap<>();\n" + 
				"	private final Map<UUID, java.util.List<~nodeType~~gt()~> childrensMap = new LinkedHashMap<>();\n" + 
				"	private final org.abego.treelayout.util.DefaultConfiguration<~nodeType~> configuration;\n" + 
				"	\n" + 
				"	protected ~name~(~nodeType~ root, ~canvasName~ canvas, PInputEvent event) {\n" + 
				"		this(root, canvas, event, org.abego.treelayout.Configuration.Location.Left, org.abego.treelayout.Configuration.AlignmentInLevel.TowardsRoot);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected ~name~(~nodeType~ root, ~canvasName~ canvas, PInputEvent event, org.abego.treelayout.Configuration.Location location, org.abego.treelayout.Configuration.AlignmentInLevel alignmentInLevel) {\n" + 
				"		super(\"Layout Tree\", root, canvas, event);\n" + 
				"		this.configuration = new org.abego.treelayout.util.DefaultConfiguration<>(100, 15, location, alignmentInLevel);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	void actionPerformed(~nodeType~ node, ~canvasName~ canvas, PInputEvent event, ActionEvent e) {\n" + 
				"\n" + 
				"		new Thread(() -> {\n" + 
				"\n" + 
				"			findChildren(node);\n" + 
				"\n" + 
				"			final org.abego.treelayout.TreeForTreeLayout<~nodeType~> tree = new org.abego.treelayout.util.AbstractTreeForTreeLayout<~nodeType~>(node) {\n" + 
				"				@Override\n" + 
				"				public ~nodeType~ getParent(~nodeType~ node) {\n" + 
				"					return parentsMap.get(node.getUuid());\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				public java.util.List<~nodeType~> getChildrenList(~nodeType~ node) {\n" + 
				"					if (node == null) return Collections.emptyList();\n" + 
				"					return childrensMap.get(node.getUuid());\n" + 
				"				}\n" + 
				"			};\n" + 
				"\n" + 
				"			final org.abego.treelayout.NodeExtentProvider<~nodeType~> nodeExtendProvider = new org.abego.treelayout.NodeExtentProvider<~nodeType~>() {\n" + 
				"				@Override\n" + 
				"				public double getWidth(~nodeType~ node) {\n" + 
				"					return node.getFullBounds().getWidth();\n" + 
				"				}\n" + 
				"\n" + 
				"				@Override\n" + 
				"				public double getHeight(~nodeType~ node) {\n" + 
				"					return node.getFullBounds().getHeight();\n" + 
				"				}\n" + 
				"			};\n" + 
				"\n" + 
				"			final org.abego.treelayout.TreeLayout<~nodeType~> layout = new org.abego.treelayout.TreeLayout<>(tree, nodeExtendProvider, configuration);\n" + 
				"\n" + 
				"			// apply coordinate transforms in relation to root-node\n" + 
				"			final java.awt.geom.Rectangle2D.Double rootBounds = layout.getNodeBounds().get(node);\n" + 
				"			final double deltaX = node.getFullBounds().getX() - rootBounds.getX();\n" + 
				"			final double deltaY = node.getFullBounds().getY() - rootBounds.getY();\n" + 
				"\n" + 
				"			SwingUtilities.invokeLater(() -> {\n" + 
				"				for (Map.Entry<STNode, java.awt.geom.Rectangle2D.Double> nodeBound : layout.getNodeBounds().entrySet()) {\n" + 
				"					if (nodeBound.getKey().equals(node)) continue;	// root-node is transformation-root\n" + 
				"					nodeBound.getKey().setOffset(nodeBound.getValue().getX() + deltaX, nodeBound.getValue().getY() + deltaY);\n" + 
				"				}\n" + 
				"			});\n" + 
				"\n" + 
				"		}).start();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void findChildren(~nodeType~ node) {\n" + 
				"\n" + 
				"		if (childrensMap.containsKey(node.getUuid())) return;\n" + 
				"\n" + 
				"		childrensMap.put(node.getUuid(), new ArrayList<>());\n" + 
				"\n" + 
				"		node.outgoing()\n" + 
				"				.filter(canvas.relationMap::containsKey)\n" + 
				"				.map(uuid -> canvas.relationMap.get(uuid).getDst())\n" + 
				"				.filter(abstractNode -> !childrensMap.containsKey(abstractNode.getUuid()))\n" + 
				"				.forEach(abstractNode -> {\n" + 
				"						childrensMap.get(node.getUuid()).add(abstractNode);\n" + 
				"						parentsMap.put(abstractNode.getUuid(), node);\n" + 
				"				});\n" + 
				"\n" + 
				"		childrensMap.get(node.getUuid()).forEach(this::findChildren);\n" + 
				"	}\n" + 
				"} >>";
}  