package nextgen.templates.domain;

public class JavaCorePackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	JavaCorePackage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaCorePackage");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaCorePackage that = (JavaCorePackage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaCorePackage() ::= <<final NamedEntity String = new NamedEntity(\"String\");\n" + 
				"final NamedEntity intType = new NamedEntity(\"int\");\n" + 
				"\n" + 
				"final NamedEntity Map = new NamedEntity(\"Map\", javaUtil);\n" + 
				"final NamedEntity Set = new NamedEntity(\"Set\", javaUtil);\n" + 
				"final NamedEntity List = new NamedEntity(\"List\", javaUtil);\n" + 
				"final NamedEntity Collection = new NamedEntity(\"Collection\", javaUtil);\n" + 
				"final NamedEntity LinkedHashMap = new NamedEntity(\"LinkedHashMap\", javaUtil);\n" + 
				"final NamedEntity LinkedHashSet = new NamedEntity(\"LinkedHashSet\", javaUtil);\n" + 
				"final NamedEntity TreeSet = new NamedEntity(\"TreeSet\", javaUtil);\n" + 
				"\n" + 
				"final PackageDeclaration javaUtilFunction = newPackageDeclaration(\"java.util.function\");\n" + 
				"final NamedEntity Consumer = new NamedEntity(\"Consumer\", javaUtilFunction);\n" + 
				"final NamedEntity BiConsumer = new NamedEntity(\"BiConsumer\", javaUtilFunction, \"consumer\");\n" + 
				"\n" + 
				"Statement newLinkedHashMap(String variableName, Object keyType, Object valueType) {\n" + 
				"	return statement(newVariableDeclarationExpression()\n" + 
				"			.addModifiers(\"final\")\n" + 
				"			.addVariables(newVariableDeclaration()\n" + 
				"					.setName(variableName)\n" + 
				"					.setType(Map.asClassOrInterfaceType()\n" + 
				"							.addTypeArguments(keyType)\n" + 
				"							.addTypeArguments(valueType))\n" + 
				"					.setInitializer(LinkedHashMap.newInstance()\n" + 
				"							.addTypeArguments(\"\"))));\n" + 
				"}\n" + 
				"\n" + 
				"Statement put(String scope, Object key, Object value) {\n" + 
				"	return newExpressionStmt()\n" + 
				"		.setExpression(newMethodCallExpression()\n" + 
				"		.setScope(scope)\n" + 
				"		.setName(\"put\")\n" + 
				"		.addArguments(key)\n" + 
				"		.addArguments(value));\n" + 
				"} >>";
}  