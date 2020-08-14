package nextgen.templates.materialui;

public class ToggleButtonGroup {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	ToggleButtonGroup(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ToggleButtonGroup");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToggleButtonGroup that = (ToggleButtonGroup) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ToggleButtonGroup() ::= <<ToggleButtonGroup\n" + 
				"\n" + 
				"	ToggleButtonGroupImport\n" + 
				"\n" + 
				"	ToggleButtonGroupElement >>";
}  