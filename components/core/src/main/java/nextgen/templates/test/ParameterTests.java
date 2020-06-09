package nextgen.templates.test;

public class ParameterTests {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	ParameterTests(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ParameterTests");
		return st.render().trim();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParameterTests that = (ParameterTests) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ParameterTests() ::= <<Test the 3 types of parameters:\n" + 
				"\n" + 
				"* Single value \n" + 
				"* List values\n" + 
				"* Key-Value list values\n" + 
				"\n" + 
				"Test conditional parsing\n" + 
				"\n" + 
				"Test complex combination of all types>> ";
}  