package nextgen.templates.nextgen;

public class BaseCanvasRelation {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	BaseCanvasRelation(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BaseCanvasRelation");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseCanvasRelation that = (BaseCanvasRelation) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BaseCanvasRelation() ::= <<protected class BaseCanvasRelation extends PPath.Double implements Comparator<BaseCanvasRelation> {\n" + 
				"\n" + 
				"	final protected PText child;\n" + 
				"	private final PNodeChangeListener nodeChangeListener = new PNodeChangeListener();\n" + 
				"\n" + 
				"	public BaseCanvasRelation(BaseCanvasNode src, BaseCanvasNode dst, String type, UUID uuid) {\n" + 
				"		this.addAttribute(\"_defaultColor\", Color.decode(\"#bababa\"));\n" + 
				"		this.addAttribute(\"_selectedColor\", Color.decode(\"#b2182b\"));\n" + 
				"		this.addAttribute(\"_highlightedColor\", Color.decode(\"#f4a582\"));\n" + 
				"		this.addAttribute(\"_uuid\", uuid);\n" + 
				"		this.addAttribute(\"_type\", type);\n" + 
				"		this.addAttribute(\"_src\", src);\n" + 
				"		this.addAttribute(\"_dst\", dst);\n" + 
				"\n" + 
				"		src.addOutgoingRelation(getUuid());\n" + 
				"		dst.addIncomingRelation(getUuid());\n" + 
				"\n" + 
				"		this.child = new PText(type);\n" + 
				"\n" + 
				"		setPaint((Color) getAttribute(\"_defaultColor\"));\n" + 
				"		child.setTextPaint((Color) getAttribute(\"_defaultColor\"));\n" + 
				"\n" + 
				"		final RelationInputEventHandler relationInputEventHandler = new RelationInputEventHandler();\n" + 
				"		relationInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);\n" + 
				"		addInputEventListener(relationInputEventHandler);\n" + 
				"		addInputEventListener(canvasZoomHandler);\n" + 
				"\n" + 
				"		src.addPropertyChangeListener(nodeChangeListener);\n" + 
				"		dst.addPropertyChangeListener(nodeChangeListener);\n" + 
				"		addChild(this.child);\n" + 
				"\n" + 
				"		//org.greenrobot.eventbus.EventBus.getDefault().register(this);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return getUuid() + \" \" + getSrc() + \" -> \" + getType() + \" -> \" + getDst();\n" + 
				"	}\n" + 
				"\n" + 
				"	public void close() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			log.info(\"R-\" + getUuid() + \" closed\");\n" + 
				"			getSrc().outgoing.remove(getUuid());\n" + 
				"			getDst().incoming.remove(getUuid());\n" + 
				"			getSrc().removePropertyChangeListener(nodeChangeListener);\n" + 
				"			getDst().removePropertyChangeListener(nodeChangeListener);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"\n" + 
				"		BaseCanvasRelation other = (BaseCanvasRelation) o;\n" + 
				"\n" + 
				"		return getUuid().equals(other.getUuid());\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return getUuid().hashCode();\n" + 
				"	}\n" + 
				"\n" + 
				"	public UUID getUuid() {\n" + 
				"		return (UUID) getAttribute(\"_uuid\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getType() {\n" + 
				"		return (String) getAttribute(\"_type\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public void unselect() {\n" + 
				"		addAttribute(\"_selected\", Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(\"_defaultColor\")));\n" + 
				"	}\n" + 
				"\n" + 
				"	public void select() {\n" + 
				"		addAttribute(\"_selected\", Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(\"_selectedColor\")));\n" + 
				"	}\n" + 
				"\n" + 
				"	public boolean isSelected() {\n" + 
				"		return getBooleanAttribute(\"_selected\", false);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void unhighlight() {\n" + 
				"		addAttribute(\"_highlight\", Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath(isSelected() ? (Color) getAttribute(\"_selectedColor\") : (Color) getAttribute(\"_defaultColor\")));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void highlight() {\n" + 
				"		addAttribute(\"_highlight\", Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(\"_highlightedColor\")));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected BaseCanvasNode getSrc() {\n" + 
				"		return (BaseCanvasNode) getAttribute(\"_src\");\n" + 
				"	}\n" + 
				"\n" + 
				"	protected BaseCanvasNode getDst() {\n" + 
				"		return (BaseCanvasNode) getAttribute(\"_dst\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public Long getOrder() {\n" + 
				"		return (Long) getAttribute(\"_order\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void updatePath(Color color) {\n" + 
				"		child.setTextPaint(color);\n" + 
				"		setPaint(color);\n" + 
				"		setStrokePaint(color);\n" + 
				"		setPaintInvalid(true);\n" + 
				"		validateFullPaint();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void updatePath(BaseCanvasNode source, BaseCanvasNode target) {\n" + 
				"		//log.info(getUuid() + \" updatePath\");\n" + 
				"		final PBounds src = source.getFullBoundsReference();\n" + 
				"		final PBounds dst = target.getFullBoundsReference();\n" + 
				"		final boolean horizontalOverlap = !(src.getMaxX() < dst.getMinX() || src.getMinX() > dst.getMaxX());\n" + 
				"		final Point2D.Double startCenterBottom = new Point2D.Double(src.getCenterX(), src.getMaxY());\n" + 
				"		final Point2D.Double endCenterTop = new Point2D.Double(dst.getCenterX(), dst.getMinY());\n" + 
				"		final Point2D.Double startCenterTop = new Point2D.Double(src.getCenterX(), src.getMinY());\n" + 
				"		final Point2D.Double endCenterBottom = new Point2D.Double(dst.getCenterX(), dst.getMaxY());\n" + 
				"		if (src.getCenterX() < dst.getCenterX()) {\n" + 
				"			final Point2D.Double startRightCenter = new Point2D.Double(src.getMaxX(), src.getCenterY());\n" + 
				"			final Point2D.Double endRightCenter = new Point2D.Double(dst.getMinX(), dst.getCenterY());\n" + 
				"			if (src.getCenterY() < dst.getCenterY()) {\n" + 
				"				if (!horizontalOverlap) {\n" + 
				"					drawStraightPath(startRightCenter, endRightCenter);\n" + 
				"				} else {\n" + 
				"					drawStraightPath(startCenterBottom, endCenterTop);\n" + 
				"				}\n" + 
				"			} else {\n" + 
				"				if (!horizontalOverlap) {\n" + 
				"					drawStraightPath(startRightCenter, endRightCenter);\n" + 
				"				} else {\n" + 
				"					drawStraightPath(startCenterTop, endCenterBottom);\n" + 
				"				}\n" + 
				"			}\n" + 
				"		} else {\n" + 
				"			final Point2D.Double startLeftCenter = new Point2D.Double(src.getMinX(), src.getCenterY());\n" + 
				"			final Point2D.Double endLeftCenter = new Point2D.Double(dst.getMaxX(), dst.getCenterY());\n" + 
				"			if (src.getCenterY() < dst.getCenterY()) {\n" + 
				"				if (!horizontalOverlap) {\n" + 
				"					drawStraightPath(startLeftCenter, endLeftCenter);\n" + 
				"				} else {\n" + 
				"					drawStraightPath(startCenterBottom, endCenterTop);\n" + 
				"				}\n" + 
				"			} else {\n" + 
				"				if (!horizontalOverlap) {\n" + 
				"					drawStraightPath(startLeftCenter, endLeftCenter);\n" + 
				"				} else {\n" + 
				"					drawStraightPath(startCenterTop, endCenterBottom);\n" + 
				"				}\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private void drawStraightPath(Point2D start, Point2D end) {\n" + 
				"		reset();\n" + 
				"		setStrokePaint(child.getTextPaint());\n" + 
				"		moveTo(start.getX(), start.getY());\n" + 
				"		lineTo(end.getX(), end.getY());\n" + 
				"		child.setOffset(getBounds().getCenter2D());\n" + 
				"		final int ARR_SIZE = 4;\n" + 
				"		final double dx = end.getX() - start.getX();\n" + 
				"		final double dy = end.getY() - start.getY();\n" + 
				"		final double angle = Math.atan2(dy, dx);\n" + 
				"		final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 10);\n" + 
				"		final AffineTransform at = AffineTransform.getTranslateInstance(start.getX(), start.getY());\n" + 
				"		at.concatenate(AffineTransform.getRotateInstance(angle));\n" + 
				"		append(new Polygon(new int[]{len,\n" + 
				"					len - ARR_SIZE,\n" + 
				"					len - ARR_SIZE,\n" + 
				"					len}, new int[]{0,\n" + 
				"					-ARR_SIZE,\n" + 
				"					ARR_SIZE,\n" + 
				"					0}, 4).getPathIterator(at), false);\n" + 
				"		setPaintInvalid(true);\n" + 
				"		validateFullPaint();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int compare(BaseCanvasRelation o1, BaseCanvasRelation o2) {\n" + 
				"		return o1.getOrder().compareTo(o2.getOrder());\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class PNodeChangeListener implements PropertyChangeListener {\n" + 
				"\n" + 
				"		private final java.util.UUID uuid = java.util.UUID.randomUUID();\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public boolean equals(Object o) {\n" + 
				"			if (this == o) return true;\n" + 
				"			if (o == null || getClass() != o.getClass()) return false;\n" + 
				"			PNodeChangeListener that = (PNodeChangeListener) o;\n" + 
				"			return uuid.equals(that.uuid);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public int hashCode() {\n" + 
				"			return java.util.Objects.hash(uuid);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void propertyChange(PropertyChangeEvent evt) {\n" + 
				"			switch (evt.getPropertyName()) {\n" + 
				"				case PNode.PROPERTY_FULL_BOUNDS:\n" + 
				"					break;\n" + 
				"				case PNode.PROPERTY_TRANSFORM:\n" + 
				"					SwingUtilities.invokeLater(() -> updatePath((getSrc()), getDst()));\n" + 
				"					break;\n" + 
				"				case PNode.PROPERTY_PARENT:\n" + 
				"					break;\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}  \n" + 
				"\n" + 
				"	private final class RelationInputEventHandler extends PBasicInputEventHandler {\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseEntered(PInputEvent event) {\n" + 
				"			event.getInputManager().setKeyboardFocus(this);\n" + 
				"			highlight();\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseExited(PInputEvent event) {\n" + 
				"			unhighlight();\n" + 
				"			event.getInputManager().setKeyboardFocus(STModelCanvas.this);\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void mouseClicked(PInputEvent event) {\n" + 
				"			if (event.isRightMouseButton()) {\n" + 
				"				final JPopupMenu pop = new JPopupMenu();\n" + 
				"				STModelCanvas.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));\n" + 
				"				onRelationRightClick(event, pop);\n" + 
				"				STModelCanvas.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));\n" + 
				"				pop.show(STModelCanvas.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"			} else if (event.isLeftMouseButton()) {\n" + 
				"				SwingUtilities.invokeLater(() -> onRelationLeftClick(event));\n" + 
				"			}\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void keyPressed(PInputEvent event) {\n" + 
				"			onRelationKeyPressed(event);\n" + 
				"		}\n" + 
				"	}  \n" + 
				"\n" + 
				"	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onRelationLeftClick(PInputEvent event) {\n" + 
				"		if (isSelected()) unselect();\n" + 
				"		else select();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onRelationKeyPressed(PInputEvent event) {\n" + 
				"	}\n" + 
				"\n" + 
				"	abstract class RelationAction extends AbstractAction {\n" + 
				"\n" + 
				"		final PInputEvent event;\n" + 
				"\n" + 
				"		RelationAction(String name, PInputEvent event) {\n" + 
				"			super(name);\n" + 
				"			this.event = event;\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void actionPerformed(ActionEvent e) {\n" + 
				"			actionPerformed(event, e);\n" + 
				"		}\n" + 
				"\n" + 
				"		abstract void actionPerformed(PInputEvent event, ActionEvent e);\n" + 
				"	}\n" + 
				"} >>";
}  