package nextgen.templates.piccolo2d;

public class PRelation {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private String _canvasName;
	private String _nodeName;
	private java.util.List<Object> _relationActionmethods = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onRightClick = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onKeyPressed = new java.util.ArrayList<>();

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
		for (Object o : _relationActionmethods) st.add("relationActionmethods", o);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _onRightClick) st.addAggr("onRightClick.{name,isSeparator}", map.get("name"), map.get("isSeparator"));
		for (java.util.Map<String, Object> map : _onKeyPressed) st.addAggr("onKeyPressed.{key,name}", map.get("key"), map.get("name"));
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

	public PRelation addRelationActionmethods(Object value) {
		this._relationActionmethods.add(value);
		return this;
	}

	public PRelation setRelationActionmethods(Object[] value) {
		this._relationActionmethods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PRelation setRelationActionmethods(java.util.Collection<Object> values) {
		this._relationActionmethods.addAll(values);
		return this;
	}

	public PRelation removeRelationActionmethods(Object value) {
		this._relationActionmethods.remove(value);
		return this;
	}

	public PRelation removeRelationActionmethods(int index) {
		this._relationActionmethods.remove(index);
		return this;
	}

	public java.util.List<Object> getRelationActionmethods() {
		return this._relationActionmethods;
	} 

	public PRelation addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public PRelation setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PRelation setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public PRelation removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public PRelation removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public PRelation addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public PRelation setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PRelation setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public PRelation removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public PRelation removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public PRelation addOnRightClick(Object _name, Object _isSeparator) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("isSeparator", _isSeparator);
		this._onRightClick.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnRightClick() {
		return this._onRightClick;
	}

	public PRelation addOnRightClick(PRelation_OnRightClick value) {
		return addOnRightClick(value._name, value._isSeparator);
	}

	public java.util.stream.Stream<PRelation_OnRightClick> streamOnRightClick() {
		return this._onRightClick.stream().map(PRelation_OnRightClick::new);
	}

	public static final class PRelation_OnRightClick {

		Object _name;
		Object _isSeparator;

		public PRelation_OnRightClick(Object _name, Object _isSeparator) {
			this._name = _name;
			this._isSeparator = _isSeparator;
		}

		private PRelation_OnRightClick(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._isSeparator = (Object) map.get("isSeparator");
		}

		public Object getName() {
			return this._name;
		}

		public Object getIsSeparator() {
			return this._isSeparator;
		}

	} 

	public PRelation addOnKeyPressed(Object _key, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("name", _name);
		this._onKeyPressed.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnKeyPressed() {
		return this._onKeyPressed;
	}

	public PRelation addOnKeyPressed(PRelation_OnKeyPressed value) {
		return addOnKeyPressed(value._key, value._name);
	}

	public java.util.stream.Stream<PRelation_OnKeyPressed> streamOnKeyPressed() {
		return this._onKeyPressed.stream().map(PRelation_OnKeyPressed::new);
	}

	public static final class PRelation_OnKeyPressed {

		Object _key;
		Object _name;

		public PRelation_OnKeyPressed(Object _key, Object _name) {
			this._key = _key;
			this._name = _name;
		}

		private PRelation_OnKeyPressed(java.util.Map<String, Object> map) {
			this._key = (Object) map.get("key");
			this._name = (Object) map.get("name");
		}

		public Object getKey() {
			return this._key;
		}

		public Object getName() {
			return this._name;
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

	static final String st = "PRelation(packageName,name,canvasName,nodeName,onRightClick,onKeyPressed,relationActionmethods,actions,methods) ::= <<package ~packageName~;\n" + 
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
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	protected enum Attributes {\n" + 
				"		_defaultColor, _selectedColor, _highlightedColor, _uuid, _text, _selected, _highlight, _order, _type, _src, _dst\n" + 
				"	}\n" + 
				"\n" + 
				"	protected ~canvasName~ canvas;\n" + 
				"	final protected PText child;\n" + 
				"	private final PNodeChangeListener nodeChangeListener = new PNodeChangeListener();\n" + 
				"\n" + 
				"	public ~name~(~canvasName~ canvas, ~nodeName~ src, ~nodeName~ dst, String type, UUID uuid) {\n" + 
				"		this.canvas = canvas;\n" + 
				"		this.addAttribute(Attributes._defaultColor, Color.decode(\"#bababa\"));\n" + 
				"		this.addAttribute(Attributes._selectedColor, Color.decode(\"#b2182b\"));\n" + 
				"		this.addAttribute(Attributes._highlightedColor, Color.decode(\"#f4a582\"));\n" + 
				"		this.addAttribute(Attributes._uuid, uuid);\n" + 
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
				"		addInputEventListener(canvas.canvasZoomHandler);\n" + 
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
				"		child.setTextPaint(color);\n" + 
				"		setPaint(color);\n" + 
				"		setStrokePaint(color);\n" + 
				"		setPaintInvalid(true);\n" + 
				"		validateFullPaint();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void updatePath(~nodeName~ source, ~nodeName~ target) {\n" + 
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
				"	public int compare(~name~ o1, ~name~ o2) {\n" + 
				"		return o1.getOrder().compareTo(o2.getOrder());\n" + 
				"	}\n" + 
				"\n" + 
				"	~PNodeChangeListener()~\n" + 
				"\n" + 
				"	~RelationInputEventHandler()~\n" + 
				"\n" + 
				"	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~onRightClick:{it|~if(it.isSeparator)~pop.addSeparator()~else~pop.add(new ~it.name~(this, canvas, event))~endif~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onRelationLeftClick(PInputEvent event) {\n" + 
				"		if (isSelected()) unselect();\n" + 
				"		else select();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onRelationKeyPressed(PInputEvent event) {\n" + 
				"~if(onKeyPressed)~\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"			~onKeyPressed:{it|\n" + 
				"case java.awt.event.KeyEvent.VK_~it.key~:\n" + 
				"	new ~it.name~(this, canvas, event).actionPerformed(null);\n" + 
				"	break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"~endif~\n" + 
				"	}\n" + 
				"\n" + 
				"	static abstract class RelationAction<N extends ~name~> extends AbstractAction {\n" + 
				"\n" + 
				"		final N relation;\n" + 
				"		final ~canvasName~ canvas;\n" + 
				"		final PInputEvent event;\n" + 
				"\n" + 
				"		RelationAction(String name, N relation, ~canvasName~ canvas, PInputEvent event) {\n" + 
				"			super(name);\n" + 
				"			this.relation = relation;\n" + 
				"			this.canvas = canvas;\n" + 
				"			this.event = event;\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void actionPerformed(ActionEvent e) {\n" + 
				"			actionPerformed(relation, canvas, event, e);\n" + 
				"		}\n" + 
				"\n" + 
				"		abstract void actionPerformed(N relation, ~canvasName~ canvas, PInputEvent event, ActionEvent e);\n" + 
				"\n" + 
				"		~relationActionmethods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  