package nextgen.templates.piccolo2d;

public class PNodeChangeListener {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	PNodeChangeListener(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PNodeChangeListener");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PNodeChangeListener that = (PNodeChangeListener) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PNodeChangeListener() ::= <<private final class PNodeChangeListener implements PropertyChangeListener {\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void propertyChange(PropertyChangeEvent evt) {\n" + 
				"		switch (evt.getPropertyName()) {\n" + 
				"			case PNode.PROPERTY_FULL_BOUNDS:\n" + 
				"			case PNode.PROPERTY_TRANSFORM:\n" + 
				"				SwingUtilities.invokeLater(() -> updatePath((getSrc()), getDst()));\n" + 
				"				break;\n" + 
				"			case PNode.PROPERTY_PARENT:\n" + 
				"				break;\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  