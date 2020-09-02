package nextgen.templates.piccolo2d;

public class CanvasInputEventsHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _canvasName;

	CanvasInputEventsHandler(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasInputEventsHandler");
		st.add("canvasName", _canvasName);
		return st.render().trim();
	}

	public CanvasInputEventsHandler setCanvasName(Object value) {
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

	public CanvasInputEventsHandler removeCanvasName() {
		this._canvasName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CanvasInputEventsHandler that = (CanvasInputEventsHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasInputEventsHandler(canvasName) ::= <<private final class CanvasInputEventsHandler extends PBasicInputEventHandler {\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseEntered(PInputEvent event) {\n" + 
				"		if (!this.equals(event.getInputManager().getKeyboardFocus())) {\n" + 
				"			event.getInputManager().setKeyboardFocus(this);\n" + 
				"			requestFocusInWindow();\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseExited(PInputEvent event) {\n" + 
				"		event.getInputManager().setKeyboardFocus(null);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseClicked(PInputEvent event) {\n" + 
				"		removeInputEventListener(selectEventHandler);\n" + 
				"		if (!this.equals(event.getInputManager().getKeyboardFocus())) event.getInputManager().setKeyboardFocus(this);\n" + 
				"		if (event.isRightMouseButton()) {\n" + 
				"			SwingUtilities.invokeLater(() -> {\n" + 
				"				final JPopupMenu pop = new JPopupMenu();\n" + 
				"				~canvasName~.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));\n" + 
				"				onCanvasRightClick(pop, event);\n" + 
				"				~canvasName~.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));\n" + 
				"				pop.show(~canvasName~.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"			});\n" + 
				"		} else if (event.isLeftMouseButton()) SwingUtilities.invokeLater(() -> onCanvasLeftClick(event));\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void keyPressed(PInputEvent event) {\n" + 
				"		if (event.isControlDown()) {\n" + 
				"			removeInputEventListener(selectEventHandler);\n" + 
				"			addInputEventListener(selectEventHandler.init(event));\n" + 
				"		} else {\n" + 
				"			onCanvasKeyPressed(event);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void keyReleased(PInputEvent event) {\n" + 
				"		if (event.getKeyCode() == KeyEvent.VK_CONTROL) removeInputEventListener(selectEventHandler.end());\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseMoved(PInputEvent event) {\n" + 
				"		if (!event.isControlDown()) removeInputEventListener(selectEventHandler.end());\n" + 
				"		invalidate();\n" + 
				"		repaint();\n" + 
				"	}\n" + 
				"} >>";
}  