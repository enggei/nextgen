package nextgen.templates.piccolo2d;

public class Readme {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Readme(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("readme");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Readme that = (Readme) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "readme() ::= <<http://piccolo2d.org/\n" + 
				"\n" + 
				"Piccolo2D is a toolkit that supports the development of 2D structured graphics programs, in general, and Zoomable User Interfaces (ZUIs), in particular. \n" + 
				"A ZUI is a new kind of interface that presents a huge canvas of information on a traditional computer display by letting the user smoothly zoom in, \n" + 
				"to get more detailed information, and zoom out for an overview.\n" + 
				"\n" + 
				"There are 3 classes:\n" + 
				"\n" + 
				"PCanvas contains PNode and PRelation instances. \n" + 
				"	It displays nodes and relations.\n" + 
				"	Its zoomable by mouse-scroll.\n" + 
				"	One can add right-click actions by adding a CanvasAction.\n" + 
				"\n" + 
				"PNode is a node.\n" + 
				"	It displays a label using a PText child.\n" + 
				"	One can add right-click actions by adding a NodeAction.\n" + 
				"\n" + 
				"PRelation is a relation between two nodes.\n" + 
				"	It displays a label using a PText child.\n" + 
				"	One can add right-click actions by adding a RelationAction. >>";
}  