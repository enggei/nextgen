package nextgen.templates.domain;

public class JavaSwingPackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	JavaSwingPackage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaSwingPackage");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaSwingPackage that = (JavaSwingPackage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaSwingPackage() ::= <<final PackageDeclaration javaxSwing = newPackageDeclaration(\"javax.swing\");\n" + 
				"final NamedEntity JTextField = new NamedEntity(\"JTextField\", javaxSwing, \"textField\");\n" + 
				"final NamedEntity JTextArea = new NamedEntity(\"JTextArea\", javaxSwing, \"textArea\");\n" + 
				"\n" + 
				"static Statement invokeLater(Expression expression) {\n" + 
				"	return statement(methodCallExpression(\"javax.swing.SwingUtilities\", \"invokeLater\")\n" + 
				"				.addArguments(newLambdaExpression().setBody(expression)));\n" + 
				"} >>";
}  