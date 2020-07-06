package nextgen.templates.piccolo2d;

public class PRelation {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private String _canvasName;
	private String _nodeName;
	private java.util.List<java.util.Map<String, Object>> _onRightClickActions = new java.util.ArrayList<>();

	PRelation(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PRelation");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("canvasName", _canvasName);
		st.add("nodeName", _nodeName);
		for (java.util.Map<String, Object> map : _onRightClickActions) st.addAggr("onRightClickActions.{name,declaration}", map.get("name"), map.get("declaration"));
		return st.render().trim();
	}

	public PRelation setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public PRelation removePackageName() {
		this._packageName = null;
		return this;
	} 

	public PRelation setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public PRelation removeName() {
		this._name = null;
		return this;
	} 

	public PRelation setCanvasName(String value) {
		this._canvasName = value;
		return this;
	}

	public String getCanvasName() {
		return this._canvasName;
	}

	public String getCanvasName(String defaultValue) {
		return this._canvasName == null ? defaultValue : this._canvasName;
	}

	public boolean hasCanvasName() {
		return this._canvasName != null;
	}

	public PRelation removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public PRelation setNodeName(String value) {
		this._nodeName = value;
		return this;
	}

	public String getNodeName() {
		return this._nodeName;
	}

	public String getNodeName(String defaultValue) {
		return this._nodeName == null ? defaultValue : this._nodeName;
	}

	public boolean hasNodeName() {
		return this._nodeName != null;
	}

	public PRelation removeNodeName() {
		this._nodeName = null;
		return this;
	} 


	public PRelation addOnRightClickActions(Object _name, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("declaration", _declaration);
		this._onRightClickActions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnRightClickActions() {
		return this._onRightClickActions;
	}

	public PRelation addOnRightClickActions(PRelation_OnRightClickActions value) {
		return addOnRightClickActions(value._name, value._declaration);
	}

	public java.util.stream.Stream<PRelation_OnRightClickActions> streamOnRightClickActions() {
		return this._onRightClickActions.stream().map(PRelation_OnRightClickActions::new);
	}

	public static final class PRelation_OnRightClickActions {

		Object _name;
		Object _declaration;

		public PRelation_OnRightClickActions(Object _name, Object _declaration) {
			this._name = _name;
			this._declaration = _declaration;
		}

		private PRelation_OnRightClickActions(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._declaration = (Object) map.get("declaration");
		}

		public Object getName() {
			return this._name;
		}

		public Object getDeclaration() {
			return this._declaration;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PRelation that = (PRelation) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PRelation(packageName,name,canvasName,nodeName,onRightClickActions) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.piccolo2d.PNode;\n" + 
				"import org.piccolo2d.event.PBasicInputEventHandler;\n" + 
				"import org.piccolo2d.event.PInputEvent;\n" + 
				"import org.piccolo2d.nodes.PPath;\n" + 
				"import org.piccolo2d.nodes.PText;\n" + 
				"import org.piccolo2d.util.PBounds;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.awt.geom.AffineTransform;\n" + 
				"import java.awt.geom.Point2D;\n" + 
				"import java.beans.PropertyChangeEvent;\n" + 
				"import java.beans.PropertyChangeListener;\n" + 
				"import java.util.Comparator;\n" + 
				"import java.util.UUID;\n" + 
				"\n" + 
				"public class ~name~ extends PPath.Double implements Comparator<~name~> {\n" + 
				"\n" + 
				"	protected enum Attributes {\n" + 
				"		_defaultColor, _selectedColor, _highlightedColor, _uuid, _text, _selected, _highlight, _order, _type, _src, _dst\n" + 
				"	}\n" + 
				"	\n" + 
				"	private ~canvasName~ canvas;\n" + 
				"	final protected PText child;\n" + 
				"\n" + 
				"	public ~name~(~canvasName~ canvas, ~nodeName~ src, ~nodeName~ dst, String type) {\n" + 
				"		this.canvas = canvas;\n" + 
				"		this.addAttribute(Attributes._defaultColor, Color.decode(\"#bababa\"));\n" + 
				"		this.addAttribute(Attributes._selectedColor, Color.decode(\"#b2182b\"));\n" + 
				"		this.addAttribute(Attributes._highlightedColor, Color.decode(\"#f4a582\"));\n" + 
				"		this.addAttribute(Attributes._uuid, UUID.randomUUID());\n" + 
				"		this.addAttribute(Attributes._type, type);\n" + 
				"		this.addAttribute(Attributes._src, src);\n" + 
				"		this.addAttribute(Attributes._dst, dst);\n" + 
				"\n" + 
				"		src.addOutgoingRelation(getUuid());\n" + 
				"		dst.addIncomingRelation(getUuid());\n" + 
				"\n" + 
				"		this.child = new PText(type);\n" + 
				"\n" + 
				"		setPaint((Color) getAttribute(Attributes._defaultColor));\n" + 
				"		child.setTextPaint((Color) getAttribute(Attributes._defaultColor));\n" + 
				"\n" + 
				"		final RelationInputEventHandler relationInputEventHandler = new RelationInputEventHandler();\n" + 
				"		relationInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);\n" + 
				"		addInputEventListener(relationInputEventHandler);\n" + 
				"\n" + 
				"		final PNodeChangeListener nodeChangeListener = new PNodeChangeListener();\n" + 
				"		src.addPropertyChangeListener(nodeChangeListener);\n" + 
				"		dst.addPropertyChangeListener(nodeChangeListener);\n" + 
				"		addChild(this.child);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return getUuid() + \" \" + getSrc() + \" -> \" + getType() + \" -> \" + getDst();\n" + 
				"	}\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"\n" + 
				"		~name~ other = (~name~) o;\n" + 
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
				"		return (UUID) getAttribute(Attributes._uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getType() {\n" + 
				"		return (String) getAttribute(Attributes._type);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void unselect() {\n" + 
				"		addAttribute(Attributes._selected, Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(Attributes._defaultColor)));\n" + 
				"	}\n" + 
				"\n" + 
				"	public void select() {\n" + 
				"		addAttribute(Attributes._selected, Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(Attributes._selectedColor)));\n" + 
				"	}\n" + 
				"\n" + 
				"	public boolean isSelected() {\n" + 
				"		return getBooleanAttribute(Attributes._selected, false);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void unhighlight() {\n" + 
				"		addAttribute(Attributes._highlight, Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath(isSelected() ? (Color) getAttribute(Attributes._selectedColor) : (Color) getAttribute(Attributes._defaultColor)));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void highlight() {\n" + 
				"		addAttribute(Attributes._highlight, Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(Attributes._highlightedColor)));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected ~nodeName~ getSrc() {\n" + 
				"		return (~nodeName~) getAttribute(Attributes._src);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected ~nodeName~ getDst() {\n" + 
				"		return (~nodeName~) getAttribute(Attributes._dst);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Long getOrder() {\n" + 
				"		return (Long) getAttribute(Attributes._order);\n" + 
				"	}\n" + 
				"\n" + 
				"	private void updatePath(Color color) {\n" + 
				"		setPaint(color);\n" + 
				"		child.setTextPaint(color);\n" + 
				"		updatePath(getSrc(), getDst());\n" + 
				"	}\n" + 
				"\n" + 
				"	private void updatePath(~nodeName~ source, ~nodeName~ target) {\n" + 
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
				"	public int compare(~name~ o1, ~name~ o2) {\n" + 
				"		return o1.getOrder().compareTo(o2.getOrder());\n" + 
				"	}\n" + 
				"\n" + 
				"	~PNodeChangeListener()~\n" + 
				"\n" + 
				"	~RelationInputEventHandler()~\n" + 
				"\n" + 
				"	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~onRightClickActions:{it|pop.add(new ~it.name~(this, canvas, event));};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onRelationLeftClick(PInputEvent event) {\n" + 
				"		if (isSelected()) unselect();\n" + 
				"		else select();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onRelationKeyPressed(PInputEvent event) {\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	static abstract class RelationAction extends AbstractAction {\n" + 
				"\n" + 
				"		final ~name~ relation;\n" + 
				"		final ~canvasName~ canvas;\n" + 
				"		final PInputEvent event;\n" + 
				"	\n" + 
				"		RelationAction(String name, ~name~ relation, ~canvasName~ canvas, PInputEvent event) {\n" + 
				"			super(name);\n" + 
				"			this.relation = relation;\n" + 
				"			this.canvas = canvas;\n" + 
				"			this.event = event;\n" + 
				"		}\n" + 
				"	\n" + 
				"		@Override\n" + 
				"		public void actionPerformed(ActionEvent e) {\n" + 
				"			actionPerformed(relation, canvas, event, e);\n" + 
				"		}\n" + 
				"	\n" + 
				"		abstract void actionPerformed(~name~ relation, ~canvasName~ canvas, PInputEvent event, ActionEvent e);\n" + 
				"	}\n" + 
				"	\n" + 
				"	~onRightClickActions:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  