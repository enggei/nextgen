package nextgen.templates.materialui;

public class ListItemSecondaryAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	ListItemSecondaryAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListItemSecondaryAction");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListItemSecondaryAction that = (ListItemSecondaryAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListItemSecondaryAction() ::= <<ListItemSecondaryAction\n" + 
				"\n" + 
				"	ListItemSecondaryActionImport\n" + 
				"\n" + 
				"	ListItemSecondaryActionElement >>";
}  