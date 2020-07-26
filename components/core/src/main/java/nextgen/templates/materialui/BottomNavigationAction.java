package nextgen.templates.materialui;

public class BottomNavigationAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	BottomNavigationAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BottomNavigationAction");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BottomNavigationAction that = (BottomNavigationAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BottomNavigationAction() ::= <<BottomNavigationAction\n" + 
				"\n" + 
				"	BottomNavigationActionImport\n" + 
				"\n" + 
				"	BottomNavigationActionElement >>";
}  