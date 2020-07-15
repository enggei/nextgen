package nextgen.templates.greenrobot;

public class Maven {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Maven(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("maven");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Maven that = (Maven) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "maven() ::= <<<dependency>\n" + 
				"	<groupId>org.greenrobot</groupId>\n" + 
				"	<artifactId>eventbus</artifactId>\n" + 
				"	<version>3.2.0</version>\n" + 
				"</dependency> >>";
}  