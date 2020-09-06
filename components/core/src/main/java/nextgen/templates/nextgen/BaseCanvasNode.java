package nextgen.templates.nextgen;

public class BaseCanvasNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	BaseCanvasNode(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BaseCanvasNode");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseCanvasNode that = (BaseCanvasNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BaseCanvasNode() ::= <<protected class BaseCanvasNode<T> extends PNode {\n" + 
				"\n" + 
				"	protected PText child;\n" + 
				"	protected final Set<String> outgoing = new LinkedHashSet<>();\n" + 
				"	protected final Set<String> incoming = new LinkedHashSet<>();\n" + 
				"\n" + 
				"	private PPath rectangle;\n" + 
				"\n" + 
				"	public BaseCanvasNode(T model, String uuid, String label) {\n" + 
				"		this.addAttribute(\"_defaultColor\", UIManager.getColor(\"TextField.foreground\"));\n" + 
				"		this.addAttribute(\"_selectedColor\", Color.decode(\"#2b8cbe\"));\n" + 
				"		this.addAttribute(\"_highlightedColor\", Color.decode(\"#e66101\"));\n" + 
				"		this.addAttribute(\"_rectangleColor\", new Color(253, 141, 60, 50));\n" + 
				"		this.addAttribute(\"_model\", model);\n" + 
				"		this.addAttribute(\"_uuid\", uuid);\n" + 
				"		this.addAttribute(\"_text\", label);\n" + 
				"		this.child = new PText(getText() == null ? getUuid() : getText());\n" + 
				"		this.addChild(this.child);\n" + 
				"\n" + 
				"		final NodeInputEventHandler nodeInputEventHandler = new NodeInputEventHandler();\n" + 
				"		nodeInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);\n" + 
				"		addInputEventListener(nodeInputEventHandler);\n" + 
				"		addInputEventListener(canvasZoomHandler);\n" + 
				"\n" + 
				"		//org.greenrobot.eventbus.EventBus.getDefault().register(this);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected BaseCanvasNode<T> thisNode() {\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public T getModel() {\n" + 
				"		return (T) getAttribute(\"_model\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public void addedToCanvas() {\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	public void newNodeAdded(BaseCanvasNode<?> node) {\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public double getHeight() {\n" + 
				"		return child.getHeight();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public double getWidth() {\n" + 
				"		return child.getWidth();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return getUuid() + \" \" + getText();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"\n" + 
				"		BaseCanvasNode<?> other = (BaseCanvasNode<?>) o;\n" + 
				"\n" + 
				"		return getUuid().equals(other.getUuid());\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return getUuid().hashCode();\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getUuid() {\n" + 
				"		return (String) getAttribute(\"_uuid\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getText() {\n" + 
				"		return (String) getAttribute(\"_text\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public void setText(String text) {\n" + 
				"		addAttribute(\"_text\", text == null || text.trim().length() == 0 ? getUuid().toString() : text);\n" + 
				"		child.setText(getText());\n" + 
				"		refresh();\n" + 
				"	}\n" + 
				"\n" + 
				"	public void refresh() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			setPaintInvalid(true);\n" + 
				"			repaint();\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public void addOutgoingRelation(String relation) {\n" + 
				"		this.outgoing.add(relation);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void addIncomingRelation(String relation) {\n" + 
				"		this.incoming.add(relation);\n" + 
				"	}\n" + 
				"\n" + 
				"	public java.util.stream.Stream<String> outgoing() {\n" + 
				"		return this.outgoing.stream();\n" + 
				"	}\n" + 
				"\n" + 
				"	public java.util.stream.Stream<String> incoming() {\n" + 
				"		return this.incoming.stream();\n" + 
				"	}\n" + 
				"\n" + 
				"	public void unselect() {\n" + 
				"		addAttribute(\"_selected\", Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute(\"_defaultColor\")));\n" + 
				"	}\n" + 
				"\n" + 
				"	public void select() {\n" + 
				"		addAttribute(\"_selected\", Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute(\"_selectedColor\")));\n" + 
				"	}\n" + 
				"\n" + 
				"	public boolean isSelected() {\n" + 
				"		return getBooleanAttribute(\"_selected\", false);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void unhighlight() {\n" + 
				"		addAttribute(\"_highlight\", Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			child.setTextPaint(isSelected() ? (Color) getAttribute(\"_selectedColor\") : (Color) getAttribute(\"_defaultColor\"));\n" + 
				"			if (rectangle != null) BaseCanvasNode.this.removeChild(rectangle);	\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public void highlight() {\n" + 
				"		addAttribute(\"_highlight\", Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			final PBounds fullBounds = child.getFullBoundsReference();\n" + 
				"			rectangle = PPath.createRectangle(fullBounds.getX(), fullBounds.getY(), fullBounds.getWidth(), fullBounds.getHeight());\n" + 
				"			rectangle.setPaint((Color) getAttribute(\"_rectangleColor\"));\n" + 
				"			rectangle.setStroke(new BasicStroke());\n" + 
				"			BaseCanvasNode.this.addChild(rectangle);\n" + 
				"\n" + 
				"			child.setTextPaint((Color) getAttribute(\"_highlightedColor\"));\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public void close() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			for (String uuid : incoming) removeRelation(uuid);\n" + 
				"			for (String uuid : outgoing) removeRelation(uuid);\n" + 
				"			org.greenrobot.eventbus.EventBus.getDefault().unregister(BaseCanvasNode.this);\n" + 
				"			removeNode(getUuid());			\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onNodeKeyPressed(PInputEvent event) {\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"			case VK_1:\n" + 
				"				new LayoutTreeAction(BaseCanvasNode.this, event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_2:\n" + 
				"				new LayoutCircleAction(BaseCanvasNode.this, event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_C:\n" + 
				"				new CloseNode(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_R:\n" + 
				"				new RetainNode(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_F:\n" + 
				"				new PopupAction(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"			case VK_B:\n" + 
				"				new DebugAction(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onNodeLeftClick(PInputEvent event) {\n" + 
				"		if (isSelected()) unselect();\n" + 
				"		else select();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"\n" + 
				"		pop.add(new LayoutTreeAction(BaseCanvasNode.this, event));\n" + 
				"		pop.add(new LayoutCircleAction(BaseCanvasNode.this, event));\n" + 
				"		pop.add(new RetainNode(event));\n" + 
				"		pop.add(new CloseNode(event));\n" + 
				"		pop.add(new DebugAction(event));\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class NodeInputEventHandler extends PDragSequenceEventHandler {\n" + 
				"\n" + 
				"		@Override\n" + 
				"		final protected void startDrag(PInputEvent event) {\n" + 
				"			super.startDrag(event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		final protected void drag(PInputEvent event) {\n" + 
				"			super.drag(event);\n" + 
				"			translate(event.getDelta().width, event.getDelta().height);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		final protected void endDrag(PInputEvent event) {\n" + 
				"			super.endDrag(event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		final protected boolean shouldStartDragInteraction(PInputEvent event) {\n" + 
				"			return super.shouldStartDragInteraction(event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseEntered(PInputEvent event) {\n" + 
				"			if (!event.isControlDown()) \n" + 
				"				event.getInputManager().setKeyboardFocus(this);\n" + 
				"			highlight();\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseExited(PInputEvent event) {\n" + 
				"			unhighlight();\n" + 
				"			if (!event.isControlDown()) \n" + 
				"				event.getInputManager().setKeyboardFocus(thisCanvas());\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseClicked(PInputEvent event) {\n" + 
				"			if (event.isRightMouseButton()) {\n" + 
				"				final JPopupMenu pop = new JPopupMenu();\n" + 
				"				thisCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));\n" + 
				"				onNodeRightClick(event, pop);\n" + 
				"				thisCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));\n" + 
				"				pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"			} else if (event.isLeftMouseButton()) {\n" + 
				"				SwingUtilities.invokeLater(() -> onNodeLeftClick(event));\n" + 
				"			}\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void keyPressed(PInputEvent event) {\n" + 
				"			onNodeKeyPressed(event);\n" + 
				"		}\n" + 
				"	}  	\n" + 
				"\n" + 
				"	abstract class NodeAction extends AbstractAction {\n" + 
				"\n" + 
				"		final PInputEvent event;\n" + 
				"\n" + 
				"		NodeAction(String name, PInputEvent event) {\n" + 
				"			super(name);\n" + 
				"			this.event = event;\n" + 
				"		}\n" + 
				"\n" + 
				"		protected void setName(String name) {\n" + 
				"			putValue(Action.NAME, name);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void actionPerformed(ActionEvent e) {\n" + 
				"			actionPerformed(event, e);\n" + 
				"		}\n" + 
				"\n" + 
				"		abstract void actionPerformed(PInputEvent event, ActionEvent e);\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	protected final class LayoutTreeAction extends NodeAction {\n" + 
				"\n" + 
				"		private final Map<String, BaseCanvasNode<?>~gt()~ parentsMap = new LinkedHashMap<>();\n" + 
				"		private final Map<String, java.util.List<BaseCanvasNode<?>~gt()~~gt()~ childrensMap = new LinkedHashMap<>();\n" + 
				"		private final org.abego.treelayout.util.DefaultConfiguration<BaseCanvasNode<?~gt()~> configuration;\n" + 
				"\n" + 
				"		protected LayoutTreeAction(BaseCanvasNode<?> root, PInputEvent event) {\n" + 
				"			this(root, event, org.abego.treelayout.Configuration.Location.Left, org.abego.treelayout.Configuration.AlignmentInLevel.TowardsRoot);\n" + 
				"		}\n" + 
				"\n" + 
				"		protected LayoutTreeAction(BaseCanvasNode<?> root, PInputEvent event, org.abego.treelayout.Configuration.Location location, org.abego.treelayout.Configuration.AlignmentInLevel alignmentInLevel) {\n" + 
				"			super(\"Layout Tree\", event);\n" + 
				"			this.configuration = new org.abego.treelayout.util.DefaultConfiguration<>(100, 15, location, alignmentInLevel);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"\n" + 
				"			new Thread(() -> {\n" + 
				"\n" + 
				"				findChildren(BaseCanvasNode.this);\n" + 
				"\n" + 
				"				final org.abego.treelayout.TreeForTreeLayout<BaseCanvasNode<?>~gt()~ tree = new org.abego.treelayout.util.AbstractTreeForTreeLayout<BaseCanvasNode<?>~gt()~(BaseCanvasNode.this) {\n" + 
				"					@Override\n" + 
				"					public BaseCanvasNode<?> getParent(BaseCanvasNode<?> node) {\n" + 
				"						return parentsMap.get(node.getUuid());\n" + 
				"					}\n" + 
				"\n" + 
				"					@Override\n" + 
				"					public java.util.List<BaseCanvasNode<?>~gt()~ getChildrenList(BaseCanvasNode<?> node) {\n" + 
				"						if (node == null) return Collections.emptyList();\n" + 
				"						return childrensMap.get(node.getUuid());\n" + 
				"					}\n" + 
				"				};\n" + 
				"\n" + 
				"				final org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>~gt()~ nodeExtendProvider = new org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>~gt()~() {\n" + 
				"					@Override\n" + 
				"					public double getWidth(BaseCanvasNode<?> node) {\n" + 
				"						return node.getFullBounds().getWidth();\n" + 
				"					}\n" + 
				"\n" + 
				"					@Override\n" + 
				"					public double getHeight(BaseCanvasNode<?> node) {\n" + 
				"						return node.getFullBounds().getHeight();\n" + 
				"					}\n" + 
				"				};\n" + 
				"\n" + 
				"				final org.abego.treelayout.TreeLayout<BaseCanvasNode<?>~gt()~ layout = new org.abego.treelayout.TreeLayout<>(tree, nodeExtendProvider, configuration);\n" + 
				"\n" + 
				"				// apply coordinate transforms in relation to root-node\n" + 
				"				final java.awt.geom.Rectangle2D.Double rootBounds = layout.getNodeBounds().get(BaseCanvasNode.this);\n" + 
				"				final double deltaX = getFullBounds().getX() - rootBounds.getX();\n" + 
				"				final double deltaY = getFullBounds().getY() - rootBounds.getY();\n" + 
				"\n" + 
				"				SwingUtilities.invokeLater(() -> {\n" + 
				"					for (Map.Entry<BaseCanvasNode<?>, java.awt.geom.Rectangle2D.Double> nodeBound : layout.getNodeBounds().entrySet()) {\n" + 
				"						if (nodeBound.getKey().equals(BaseCanvasNode.this)) continue;	// root-node is transformation-root\n" + 
				"						nodeBound.getKey().setOffset(nodeBound.getValue().getX() + deltaX, nodeBound.getValue().getY() + deltaY);\n" + 
				"					}\n" + 
				"				});\n" + 
				"\n" + 
				"			}).start();\n" + 
				"		}\n" + 
				"\n" + 
				"		private void findChildren(BaseCanvasNode<?> node) {\n" + 
				"\n" + 
				"			if (childrensMap.containsKey(node.getUuid())) return;\n" + 
				"\n" + 
				"			childrensMap.put(node.getUuid(), new ArrayList<>());\n" + 
				"\n" + 
				"			node.outgoing()\n" + 
				"					.filter(thisCanvas().relationMap::containsKey)\n" + 
				"					.map(uuid -> thisCanvas().relationMap.get(uuid).getDst())\n" + 
				"					.filter(abstractNode -> !childrensMap.containsKey(abstractNode.getUuid()))\n" + 
				"					.forEach(abstractNode -> {\n" + 
				"							childrensMap.get(node.getUuid()).add(abstractNode);\n" + 
				"							parentsMap.put(abstractNode.getUuid(), node);\n" + 
				"					});\n" + 
				"\n" + 
				"			childrensMap.get(node.getUuid()).forEach(this::findChildren);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	protected final class LayoutCircleAction extends NodeAction {\n" + 
				"\n" + 
				"		private final Map<String, BaseCanvasNode<?>~gt()~ parentsMap = new LinkedHashMap<>();\n" + 
				"		private final Map<String, java.util.List<BaseCanvasNode<?>~gt()~~gt()~ childrensMap = new LinkedHashMap<>();\n" + 
				"\n" + 
				"		protected LayoutCircleAction(BaseCanvasNode<?> root, PInputEvent event) {\n" + 
				"			super(\"Layout Circle\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"\n" + 
				"			new Thread(() -> {\n" + 
				"\n" + 
				"				findChildren(BaseCanvasNode.this);\n" + 
				"\n" + 
				"				final org.abego.treelayout.TreeForTreeLayout<BaseCanvasNode<?>~gt()~ tree = new org.abego.treelayout.util.AbstractTreeForTreeLayout<BaseCanvasNode<?>~gt()~(BaseCanvasNode.this) {\n" + 
				"					@Override\n" + 
				"					public BaseCanvasNode<?> getParent(BaseCanvasNode<?> node) {\n" + 
				"						return parentsMap.get(node.getUuid());\n" + 
				"					}\n" + 
				"\n" + 
				"					@Override\n" + 
				"					public java.util.List<BaseCanvasNode<?>~gt()~ getChildrenList(BaseCanvasNode<?> node) {\n" + 
				"						if (node == null) return Collections.emptyList();\n" + 
				"						return childrensMap.get(node.getUuid());\n" + 
				"					}\n" + 
				"				};\n" + 
				"\n" + 
				"				final org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>~gt()~ nodeExtendProvider = new org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>~gt()~() {\n" + 
				"					@Override\n" + 
				"					public double getWidth(BaseCanvasNode<?> node) {\n" + 
				"						return node.getFullBounds().getWidth();\n" + 
				"					}\n" + 
				"\n" + 
				"					@Override\n" + 
				"					public double getHeight(BaseCanvasNode<?> node) {\n" + 
				"						return node.getFullBounds().getHeight();\n" + 
				"					}\n" + 
				"				};\n" + 
				"\n" + 
				"				final nextgen.st.canvas.layout.CircleLayout<BaseCanvasNode<?>~gt()~ layout = new nextgen.st.canvas.layout.CircleLayout<>(tree, nodeExtendProvider);\n" + 
				"\n" + 
				"				// apply coordinate transforms in relation to root-node\n" + 
				"				final java.awt.geom.Rectangle2D.Double rootBounds = layout.getNodeBounds().get(BaseCanvasNode.this);\n" + 
				"				final double deltaX = getFullBounds().getX() - rootBounds.getX();\n" + 
				"				final double deltaY = getFullBounds().getY() - rootBounds.getY();\n" + 
				"\n" + 
				"				SwingUtilities.invokeLater(() -> {\n" + 
				"					for (Map.Entry<BaseCanvasNode<?>, java.awt.geom.Rectangle2D.Double> nodeBound : layout.getNodeBounds()\n" + 
				"																																	.entrySet()) {\n" + 
				"						if (nodeBound.getKey().equals(BaseCanvasNode.this)) continue;	// root-node is transformation-root\n" + 
				"						nodeBound.getKey()\n" + 
				"									.setOffset(nodeBound.getValue().getX() + deltaX, nodeBound.getValue().getY() + deltaY);\n" + 
				"					}\n" + 
				"				});\n" + 
				"\n" + 
				"			}).start();\n" + 
				"		}\n" + 
				"\n" + 
				"		private void findChildren(BaseCanvasNode<?> node) {\n" + 
				"\n" + 
				"			if (childrensMap.containsKey(node.getUuid())) return;\n" + 
				"\n" + 
				"			childrensMap.put(node.getUuid(), new ArrayList<>());\n" + 
				"\n" + 
				"			node.outgoing()\n" + 
				"				.filter(thisCanvas().relationMap::containsKey)\n" + 
				"				.map(uuid -> thisCanvas().relationMap.get(uuid).getDst())\n" + 
				"				.filter(abstractNode -> !childrensMap.containsKey(abstractNode.getUuid()))\n" + 
				"				.forEach(abstractNode -> {\n" + 
				"					childrensMap.get(node.getUuid()).add(abstractNode);\n" + 
				"					parentsMap.put(abstractNode.getUuid(), node);\n" + 
				"				});\n" + 
				"\n" + 
				"			childrensMap.get(node.getUuid()).forEach(this::findChildren);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class RetainNode extends NodeAction {\n" + 
				"\n" + 
				"		RetainNode(PInputEvent event) {\n" + 
				"			super(\"Retain\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> {\n" + 
				"				thisCanvas().getAllRelations().forEach(relation -> thisCanvas().removeRelation(relation.getUuid()));\n" + 
				"				thisCanvas().relationLayer.removeAllChildren();\n" + 
				"				thisCanvas().getAllNodes().filter(canvasNode -> !canvasNode.getUuid().equals(getUuid())).forEach(BaseCanvasNode::close);\n" + 
				"			});\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class CloseNode extends NodeAction {\n" + 
				"\n" + 
				"		CloseNode(PInputEvent event) {\n" + 
				"			super(\"Close\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> thisNode().close());\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class PopupAction extends NodeAction {\n" + 
				"\n" + 
				"		PopupAction(PInputEvent event) {\n" + 
				"			super(\"Popup\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed( PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> {\n" + 
				"				final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();\n" + 
				"				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));\n" + 
				"				onNodeRightClick(event, pop);\n" + 
				"				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));\n" + 
				"				pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"			});\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class DebugAction extends NodeAction {\n" + 
				"\n" + 
				"		DebugAction(PInputEvent event) {\n" + 
				"			super(\"Debug\", event);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"			javax.swing.SwingUtilities.invokeLater(() -> {\n" + 
				"				final PBounds fullBounds = getFullBoundsReference();\n" + 
				"				log.info(getUuid() + \" : \" + getText());\n" + 
				"				log.info(fullBounds.getX() + \",\" + fullBounds.getY() + \", [\" + fullBounds.getWidth() + \",\" + fullBounds.getHeight() + \"]\");\n" + 
				"				outgoing().forEach(uuid -> log.info(\" -> \" + uuid));\n" + 
				"				incoming().forEach(uuid -> log.info(\" <- \" + uuid));\n" + 
				"			});\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  