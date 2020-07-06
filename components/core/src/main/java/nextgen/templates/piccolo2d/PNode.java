package nextgen.templates.piccolo2d;

public class PNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private String _canvasName;
	private java.util.List<Object> _nodeActionmethods = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onKeyPressed = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onRightClick = new java.util.ArrayList<>();

	PNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PNode");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("canvasName", _canvasName);
		for (Object o : _nodeActionmethods) st.add("nodeActionmethods", o);
		for (Object o : _actions) st.add("actions", o);
		for (java.util.Map<String, Object> map : _onKeyPressed) st.addAggr("onKeyPressed.{key,name}", map.get("key"), map.get("name"));
		for (java.util.Map<String, Object> map : _onRightClick) st.addAggr("onRightClick.{name}", map.get("name"));
		return st.render().trim();
	}

	public PNode setPackageName(String value) {
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

	public PNode removePackageName() {
		this._packageName = null;
		return this;
	} 

	public PNode setName(String value) {
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

	public PNode removeName() {
		this._name = null;
		return this;
	} 

	public PNode setCanvasName(String value) {
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

	public PNode removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public PNode addNodeActionmethods(Object value) {
		this._nodeActionmethods.add(value);
		return this;
	}

	public PNode setNodeActionmethods(Object[] value) {
		this._nodeActionmethods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNode setNodeActionmethods(java.util.Collection<Object> values) {
		this._nodeActionmethods.addAll(values);
		return this;
	}

	public PNode removeNodeActionmethods(Object value) {
		this._nodeActionmethods.remove(value);
		return this;
	}

	public PNode removeNodeActionmethods(int index) {
		this._nodeActionmethods.remove(index);
		return this;
	}

	public java.util.List<Object> getNodeActionmethods() {
		return this._nodeActionmethods;
	} 

	public PNode addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public PNode setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNode setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public PNode removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public PNode removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public PNode addOnKeyPressed(Object _key, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("name", _name);
		this._onKeyPressed.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnKeyPressed() {
		return this._onKeyPressed;
	}

	public PNode addOnKeyPressed(PNode_OnKeyPressed value) {
		return addOnKeyPressed(value._key, value._name);
	}

	public java.util.stream.Stream<PNode_OnKeyPressed> streamOnKeyPressed() {
		return this._onKeyPressed.stream().map(PNode_OnKeyPressed::new);
	}

	public static final class PNode_OnKeyPressed {

		Object _key;
		Object _name;

		public PNode_OnKeyPressed(Object _key, Object _name) {
			this._key = _key;
			this._name = _name;
		}

		private PNode_OnKeyPressed(java.util.Map<String, Object> map) {
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

	public PNode addOnRightClick(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._onRightClick.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnRightClick() {
		return this._onRightClick;
	}

	public PNode addOnRightClick(PNode_OnRightClick value) {
		return addOnRightClick(value._name);
	}

	public java.util.stream.Stream<PNode_OnRightClick> streamOnRightClick() {
		return this._onRightClick.stream().map(PNode_OnRightClick::new);
	}

	public static final class PNode_OnRightClick {

		Object _name;

		public PNode_OnRightClick(Object _name) {
			this._name = _name;
		}

		private PNode_OnRightClick(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PNode that = (PNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PNode(packageName,name,canvasName,onKeyPressed,onRightClick,nodeActionmethods,actions) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.piccolo2d.PNode;\n" + 
				"import org.piccolo2d.event.PDragSequenceEventHandler;\n" + 
				"import org.piccolo2d.event.PInputEvent;\n" + 
				"import org.piccolo2d.nodes.PPath;\n" + 
				"import org.piccolo2d.nodes.PText;\n" + 
				"import org.piccolo2d.util.PBounds;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.awt.geom.Point2D;\n" + 
				"import java.awt.geom.Rectangle2D;\n" + 
				"import java.beans.PropertyChangeEvent;\n" + 
				"import java.beans.PropertyChangeListener;\n" + 
				"import java.util.*;\n" + 
				"import java.util.stream.Stream;\n" + 
				"\n" + 
				"import static java.awt.event.KeyEvent.*;\n" + 
				"\n" + 
				"public class ~name~ extends PNode implements PropertyChangeListener {\n" + 
				"\n" + 
				"	protected enum Attributes {\n" + 
				"		_defaultColor, _selectedColor, _highlightedColor, _uuid, _text, _selected, _highlight\n" + 
				"	}\n" + 
				"\n" + 
				"	protected final ~canvasName~ canvas;\n" + 
				"	protected final PText child;\n" + 
				"\n" + 
				"	private PPath rectangle;\n" + 
				"\n" + 
				"	protected final Set<UUID> outgoing = new LinkedHashSet<>();\n" + 
				"	protected final Set<UUID> incoming = new LinkedHashSet<>();\n" + 
				"\n" + 
				"	public ~name~(~canvasName~ canvas, String text) {\n" + 
				"		this(canvas, text, UUID.randomUUID());\n" + 
				"	}\n" + 
				"	\n" + 
				"	public ~name~(~canvasName~ canvas, String text, UUID uuid) {\n" + 
				"		this.canvas = canvas;\n" + 
				"\n" + 
				"		this.addAttribute(Attributes._defaultColor, Color.decode(\"#000000\"));\n" + 
				"		this.addAttribute(Attributes._selectedColor, Color.decode(\"#ca0020\"));\n" + 
				"		this.addAttribute(Attributes._highlightedColor, Color.decode(\"#000000\"));\n" + 
				"		this.addAttribute(Attributes._uuid, uuid);\n" + 
				"		this.addAttribute(Attributes._text, text);\n" + 
				"		this.child = new PText(text == null || text.trim().length() == 0 ? getUuid().toString() : text);\n" + 
				"\n" + 
				"		final NodeInputEventHandler nodeInputEventHandler = new NodeInputEventHandler();\n" + 
				"		nodeInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);\n" + 
				"		addInputEventListener(nodeInputEventHandler);\n" + 
				"\n" + 
				"		this.addChild(this.child);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Stream<UUID> getOutgoingReferences() {\n" + 
				"		return Stream.empty();\n" + 
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
				"	public String getText() {\n" + 
				"		return (String) getAttribute(Attributes._text);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void setText(String text) {\n" + 
				"		addAttribute(Attributes._text, text == null || text.trim().length() == 0 ? getUuid().toString() : text);\n" + 
				"		child.setText(getText());\n" + 
				"		refresh();\n" + 
				"	}\n" + 
				"	\n" + 
				"	public void refresh() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			setPaintInvalid(true);\n" + 
				"			repaint();\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public void addOutgoingRelation(UUID relation) {\n" + 
				"		this.outgoing.add(relation);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void addIncomingRelation(UUID relation) {\n" + 
				"		this.incoming.add(relation);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Stream<UUID> outgoing() {\n" + 
				"		return this.outgoing.stream();\n" + 
				"	}\n" + 
				"\n" + 
				"	public Stream<UUID> incoming() {\n" + 
				"		return this.incoming.stream();\n" + 
				"	}\n" + 
				"\n" + 
				"	public void unselect() {\n" + 
				"		addAttribute(Attributes._selected, Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute(Attributes._defaultColor)));\n" + 
				"	}\n" + 
				"\n" + 
				"	public void select() {\n" + 
				"		addAttribute(Attributes._selected, Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute(Attributes._selectedColor)));\n" + 
				"	}\n" + 
				"\n" + 
				"	public boolean isSelected() {\n" + 
				"		return getBooleanAttribute(Attributes._selected, false);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void unhighlight() {\n" + 
				"		addAttribute(Attributes._highlight, Boolean.FALSE);\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			\n" + 
				"			child.setTextPaint(isSelected() ? (Color) getAttribute(Attributes._selectedColor) : (Color) getAttribute(Attributes._defaultColor));\n" + 
				"			if (rectangle != null) ~name~.this.removeChild(rectangle);\n" + 
				"			\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public void highlight() {\n" + 
				"		addAttribute(Attributes._highlight, Boolean.TRUE);\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"\n" + 
				"			final PBounds fullBounds = child.getFullBoundsReference();\n" + 
				"			rectangle = PPath.createRectangle(fullBounds.getX(), fullBounds.getY(), fullBounds.getWidth(), fullBounds.getHeight());\n" + 
				"			final Color green = new Color(0, 255, 0, 50);\n" + 
				"			rectangle.setPaint(green);\n" + 
				"			rectangle.setStroke(new BasicStroke());\n" + 
				"			~name~.this.addChild(rectangle);\n" + 
				"\n" + 
				"			child.setTextPaint((Color) getAttribute(Attributes._highlightedColor));\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public void close() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			\n" + 
				"			for (UUID uuid : incoming) canvas.removeRelation(uuid);\n" + 
				"			for (UUID uuid : outgoing) canvas.removeRelation(uuid);\n" + 
				"			canvas.removeNode(getUuid());\n" + 
				"			\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onNodeKeyPressed(PInputEvent event) {\n" + 
				"~if(onKeyPressed)~\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"			~onKeyPressed:{it|\n" + 
				"case VK_~it.key~:\n" + 
				"	new ~it.name~(this, canvas, event).actionPerformed(null);\n" + 
				"	break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"~endif~\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onNodeLeftClick(PInputEvent event) {\n" + 
				"		if (isSelected()) unselect();\n" + 
				"		else select();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"\n" + 
				"		~onRightClick:{it|pop.add(new ~it.name~(this, canvas, event));};separator=\"\\n\"~\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void propertyChange(PropertyChangeEvent evt) {\n" + 
				"		\n" + 
				"	}\n" + 
				"	\n" + 
				"	~PNodeInputEventHandler()~	\n" + 
				"\n" + 
				"	static abstract class NodeAction<N extends ~name~> extends AbstractAction {\n" + 
				"\n" + 
				"		final N node;\n" + 
				"		final ~canvasName~ canvas;\n" + 
				"		final PInputEvent event;\n" + 
				"	\n" + 
				"		NodeAction(String name, N node, ~canvasName~ canvas, PInputEvent event) {\n" + 
				"			super(name);\n" + 
				"			this.node = node;\n" + 
				"			this.canvas = canvas;\n" + 
				"			this.event = event;\n" + 
				"		}\n" + 
				"\n" + 
				"		protected void setName(String name) {\n" + 
				"			putValue(Action.NAME, name);\n" + 
				"		}\n" + 
				"        \n" + 
				"		@Override\n" + 
				"		public void actionPerformed(ActionEvent e) {\n" + 
				"			actionPerformed(node, canvas, event, e);\n" + 
				"		}\n" + 
				"	\n" + 
				"		abstract void actionPerformed(N node, ~canvasName~ canvas, PInputEvent event, ActionEvent e);\n" + 
				"\n" + 
				"		~nodeActionmethods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  