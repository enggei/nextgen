package nextgen.templates.materialui;

public class ListItemAvatar {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	ListItemAvatar(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListItemAvatar");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListItemAvatar that = (ListItemAvatar) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListItemAvatar() ::= <<ListItemAvatar\n" + 
				"\n" + 
				"	ListItemAvatarImport\n" + 
				"\n" + 
				"	ListItemAvatarElement >>";
}  