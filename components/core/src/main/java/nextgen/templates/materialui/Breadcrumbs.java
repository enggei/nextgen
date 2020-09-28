package nextgen.templates.materialui;

public class Breadcrumbs {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Breadcrumbs(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Breadcrumbs");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Breadcrumbs that = (Breadcrumbs) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Breadcrumbs() ::= <<Breadcrumbs\n" + 
				"\n" + 
				"	BreadcrumbsImport\n" + 
				"\n" + 
				"	BreadcrumbsElement >>";
}  