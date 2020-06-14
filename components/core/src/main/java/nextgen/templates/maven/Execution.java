package nextgen.templates.maven;

public class Execution {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Execution(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("execution");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Execution that = (Execution) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "execution() ::= <<<execution>\n" + 
				"    <phase>package</phase>\n" + 
				"    <goals>\n" + 
				"        <goal>shade</goal>\n" + 
				"    </goals>\n" + 
				"</execution> >>";
} 