package nextgen.templates.piccolo2d;

public class SelectEventsHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	SelectEventsHandler(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SelectEventsHandler");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SelectEventsHandler that = (SelectEventsHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SelectEventsHandler() ::= <<private final class SelectEventsHandler extends PBasicInputEventHandler {\n" + 
				"\n" + 
				"	private PPath selectionRectangle;\n" + 
				"	private boolean isDragging = true;\n" + 
				"	private double startX;\n" + 
				"	private double startY;\n" + 
				"\n" + 
				"	PInputEventListener init(PInputEvent event) {\n" + 
				"		isDragging = event.isControlDown();\n" + 
				"		if (selectionRectangle != null) nodeLayer.removeChild(selectionRectangle);\n" + 
				"		startX = getCamera().localToView(event.getCanvasPosition()).getX();\n" + 
				"		startY = getCamera().localToView(event.getCanvasPosition()).getY();\n" + 
				"		selectionRectangle = PPath.createRectangle(startX, startY, 1, 1);\n" + 
				"		selectionRectangle.setTransparency(.5f);\n" + 
				"		nodeLayer.addChild(selectionRectangle);\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void mouseMoved(PInputEvent event) {\n" + 
				"		if (isDragging) {\n" + 
				"			final double eventX = getCamera().localToView(event.getCanvasPosition()).getX();\n" + 
				"			final double eventY = getCamera().localToView(event.getCanvasPosition()).getY();\n" + 
				"			final boolean left = eventX < startX;\n" + 
				"			selectionRectangle.setX(left ? eventX : startX);\n" + 
				"			selectionRectangle.setWidth(left ? (startX - eventX) : (eventX - startX));\n" + 
				"			final boolean top = eventY < startY;\n" + 
				"			selectionRectangle.setY(top ? eventY : startY);\n" + 
				"			selectionRectangle.setHeight(top ? (startY - eventY) : (eventY - startY));\n" + 
				"			final PBounds fullBounds = selectionRectangle.getFullBounds();\n" + 
				"			SwingUtilities.invokeLater(() -> getAllNodes()\n" + 
				"				.filter(node -> !node.isSelected())\n" + 
				"				.forEach(node -> {\n" + 
				"					if (fullBounds.contains(node.getFullBounds())) node.select();\n" + 
				"				}));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public PInputEventListener end() {\n" + 
				"		isDragging = false;\n" + 
				"		if (selectionRectangle != null) nodeLayer.removeChild(selectionRectangle);\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"} >>";
}  