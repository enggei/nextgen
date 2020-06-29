package nextgen.templates.piccolo2d;

public class RelationInputEventHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	RelationInputEventHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RelationInputEventHandler");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RelationInputEventHandler that = (RelationInputEventHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RelationInputEventHandler() ::= <<private final class RelationInputEventHandler extends PBasicInputEventHandler {\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void mouseEntered(PInputEvent event) {\n" + 
				"		event.getInputManager().setKeyboardFocus(this);\n" + 
				"		highlight();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseExited(PInputEvent event) {\n" + 
				"		unhighlight();\n" + 
				"		event.getInputManager().setKeyboardFocus(canvas);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseClicked(PInputEvent event) {\n" + 
				"		if (event.isRightMouseButton()) {\n" + 
				"			final JPopupMenu pop = new JPopupMenu();\n" + 
				"			canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));\n" + 
				"			onRelationRightClick(event, pop);\n" + 
				"			canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));\n" + 
				"			pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());\n" + 
				"		} else if (event.isLeftMouseButton()) {\n" + 
				"			SwingUtilities.invokeLater(() -> onRelationLeftClick(event));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void keyPressed(PInputEvent event) {\n" + 
				"		onRelationKeyPressed(event);\n" + 
				"	}\n" + 
				"} >>";
}  