package nextgen.templates.piccolo2d;

public class PNodeInputEventHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	PNodeInputEventHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PNodeInputEventHandler");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PNodeInputEventHandler that = (PNodeInputEventHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PNodeInputEventHandler() ::= <<private final class NodeInputEventHandler extends PDragSequenceEventHandler {\n" + 
				"\n" + 
				"	@Override\n" + 
				"	final protected void startDrag(PInputEvent event) {\n" + 
				"		super.startDrag(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	final protected void drag(PInputEvent event) {\n" + 
				"		super.drag(event);\n" + 
				"		translate(event.getDelta().width, event.getDelta().height);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	final protected void endDrag(PInputEvent event) {\n" + 
				"		super.endDrag(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	final protected boolean shouldStartDragInteraction(PInputEvent event) {\n" + 
				"		return super.shouldStartDragInteraction(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseEntered(PInputEvent event) {\n" + 
				"		if (!event.isControlDown()) \n" + 
				"			event.getInputManager().setKeyboardFocus(this);\n" + 
				"		highlight();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseExited(PInputEvent event) {\n" + 
				"		unhighlight();\n" + 
				"		if (!event.isControlDown()) \n" + 
				"			event.getInputManager().setKeyboardFocus(canvas);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseClicked(PInputEvent event) {\n" + 
				"		if (event.isRightMouseButton()) {\n" + 
				"			final JPopupMenu pop = new JPopupMenu();\n" + 
				"			canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));\n" + 
				"			onNodeRightClick(event, pop);\n" + 
				"			canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));\n" + 
				"			pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"		} else if (event.isLeftMouseButton()) {\n" + 
				"			SwingUtilities.invokeLater(() -> onNodeLeftClick(event));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void keyPressed(PInputEvent event) {\n" + 
				"		onNodeKeyPressed(event);\n" + 
				"	}\n" + 
				"} >>";
}  