package nextgen.templates.piccolo2d;

public class CanvasZoomHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	CanvasZoomHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasZoomHandler");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CanvasZoomHandler that = (CanvasZoomHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasZoomHandler() ::= <<private static class CanvasZoomHandler extends PBasicInputEventHandler {\n" + 
				"\n" + 
				"	final private static double maxZoomScale = 2.5d;\n" + 
				"	final private static double minZomScale = 0.025d;\n" + 
				"	private double scaleFactor = 0.05d;\n" + 
				"\n" + 
				"	CanvasZoomHandler() {\n" + 
				"		super();\n" + 
				"		final PInputEventFilter eventFilter = new PInputEventFilter();\n" + 
				"		eventFilter.rejectAllEventTypes();\n" + 
				"		eventFilter.setAcceptsMouseWheelRotated(true);\n" + 
				"		setEventFilter(eventFilter);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void mouseWheelRotated(final PInputEvent event) {\n" + 
				"		final PCamera camera = event.getCamera();\n" + 
				"		if ((camera.getViewScale() < minZomScale && event.getWheelRotation() < 0) || (camera.getViewScale() > maxZoomScale && event.getWheelRotation() > 0)) return;\n" + 
				"		final double scale = 1.0d + event.getWheelRotation() * scaleFactor;\n" + 
				"		final java.awt.geom.Point2D viewAboutPoint = event.getPosition();\n" + 
				"		camera.scaleViewAboutPoint(scale, viewAboutPoint.getX(), viewAboutPoint.getY());\n" + 
				"	}\n" + 
				"} >>";
}  