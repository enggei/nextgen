package nextgen.templates.piccolo2d;

public class CanvasEvents {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _canvasName;
	private Object _nodeName;

	CanvasEvents(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasEvents");
		st.add("canvasName", _canvasName);
		st.add("nodeName", _nodeName);
		return st.render().trim();
	}

	public CanvasEvents setCanvasName(Object value) {
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

	public CanvasEvents removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public CanvasEvents setNodeName(Object value) {
		this._nodeName = value;
		return this;
	}

	public Object getNodeName() {
		return this._nodeName;
	}

	public Object getNodeName(Object defaultValue) {
		return this._nodeName == null ? defaultValue : this._nodeName;
	}

	public boolean hasNodeName() {
		return this._nodeName != null;
	}

	public CanvasEvents removeNodeName() {
		this._nodeName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CanvasEvents that = (CanvasEvents) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasEvents(canvasName,nodeName) ::= <<public static final class NodeAdded {\n" + 
				"\n" + 
				"	public ~canvasName~ canvas;\n" + 
				"	public ~nodeName~ node;\n" + 
				"	\n" + 
				"	public NodeAdded(~canvasName~ canvas, ~nodeName~ node) {\n" + 
				"		this.canvas = canvas;\n" + 
				"		this.node = node;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"public static final class NodeClosed {\n" + 
				"\n" + 
				"	public ~canvasName~ canvas;\n" + 
				"	public ~nodeName~ node;\n" + 
				"	\n" + 
				"	public NodeClosed(~canvasName~ canvas, ~nodeName~ node) {\n" + 
				"		this.canvas = canvas;\n" + 
				"		this.node = node;\n" + 
				"	}\n" + 
				"} >>";
}  