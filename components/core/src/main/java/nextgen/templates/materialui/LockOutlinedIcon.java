package nextgen.templates.materialui;

public class LockOutlinedIcon {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	LockOutlinedIcon(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LockOutlinedIcon");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LockOutlinedIcon that = (LockOutlinedIcon) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LockOutlinedIcon() ::= <<LockOutlinedIcon\n" + 
				"\n" + 
				"	LockOutlinedIconImport\n" + 
				"\n" + 
				"	LockOutlinedIconElement >>";
}  