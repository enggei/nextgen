package nextgen.templates.piccolo2d;

public class LayoutVerticallyAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _canvasName;
	private Object _nodeType;

	LayoutVerticallyAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LayoutVerticallyAction");
		st.add("canvasName", _canvasName);
		st.add("nodeType", _nodeType);
		return st.render().trim();
	}

	public LayoutVerticallyAction setCanvasName(Object value) {
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

	public LayoutVerticallyAction removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public LayoutVerticallyAction setNodeType(Object value) {
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

	public LayoutVerticallyAction removeNodeType() {
		this._nodeType = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LayoutVerticallyAction that = (LayoutVerticallyAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LayoutVerticallyAction(canvasName,nodeType) ::= <<private static final class LayoutVerticallyAction extends CanvasAction {\n" + 
				"\n" + 
				"	private final Point position;\n" + 
				"	private final int heightPadding = 20;\n" + 
				"\n" + 
				"	LayoutVerticallyAction(~canvasName~ canvas, PInputEvent event) {\n" + 
				"		super(\"Layout selected nodes vertically\", canvas, event);\n" + 
				"		this.position = canvas.getCurrentMousePosition();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	void actionPerformed(~canvasName~ canvas, PInputEvent event, ActionEvent e) {\n" + 
				"\n" + 
				"		SwingUtilities.invokeLater(() -> canvas.getSelectedNodes().forEach(new Consumer<~nodeType~>() {\n" + 
				"\n" + 
				"			double x = position.getX();\n" + 
				"			double y = position.getY();\n" + 
				"			double height = -1d;\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void accept(~nodeType~ abstractNode) {\n" + 
				"				if (height == -1) {\n" + 
				"					abstractNode.setOffset(x, y);\n" + 
				"					height = abstractNode.getHeight();\n" + 
				"				} else {\n" + 
				"					y += height + heightPadding;\n" + 
				"					abstractNode.setOffset(x, y);\n" + 
				"					height = abstractNode.getHeight();\n" + 
				"				}\n" + 
				"			}\n" + 
				"		}));\n" + 
				"	}\n" + 
				"} >>";
}  