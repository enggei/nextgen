package nextgen.templates.materialui;

public class SpeedDialIcon {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	SpeedDialIcon(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SpeedDialIcon");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SpeedDialIcon that = (SpeedDialIcon) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SpeedDialIcon() ::= <<SpeedDialIcon\n" + 
				"\n" + 
				"	SpeedDialIconImport\n" + 
				"\n" + 
				"	SpeedDialIconElement >>";
}  