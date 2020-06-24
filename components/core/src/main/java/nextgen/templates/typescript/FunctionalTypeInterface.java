package nextgen.templates.typescript;

public class FunctionalTypeInterface {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	FunctionalTypeInterface(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("functionalTypeInterface");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionalTypeInterface that = (FunctionalTypeInterface) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "functionalTypeInterface() ::= <<interface SearchFunc {\n" + 
				"	(source: string, subString: string): boolean;\n" + 
				"} >>";
} 