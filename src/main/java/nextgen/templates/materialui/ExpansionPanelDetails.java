package nextgen.templates.materialui;

public class ExpansionPanelDetails {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	ExpansionPanelDetails(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpansionPanelDetails");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExpansionPanelDetails that = (ExpansionPanelDetails) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpansionPanelDetails() ::= <<ExpansionPanelDetails\n" + 
				"\n" + 
				"	ExpansionPanelDetailsImport\n" + 
				"\n" + 
				"	ExpansionPanelDetailsElement >>";
}  