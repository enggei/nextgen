package nextgen.templates.maven;

public class Antlr4Simple {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Antlr4Simple(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("antlr4Simple");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Antlr4Simple that = (Antlr4Simple) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "antlr4Simple() ::= <<<plugin>\n" + 
				"	<groupId>org.antlr</groupId>\n" + 
				"	<artifactId>antlr4-maven-plugin</artifactId>\n" + 
				"	<version>4.3</version>\n" + 
				"	<configuration>\n" + 
				"		<outputDirectory>${basedir}/src/main/java</outputDirectory>\n" + 
				"		<visitor>true</visitor>\n" + 
				"	</configuration>\n" + 
				"	<executions>\n" + 
				"		<execution>\n" + 
				"			<goals>\n" + 
				"				<goal>antlr4</goal>\n" + 
				"			</goals>\n" + 
				"		</execution>\n" + 
				"	</executions>\n" + 
				"</plugin> >>";
}  