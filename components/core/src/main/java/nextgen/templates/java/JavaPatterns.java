package nextgen.templates.java;

public class JavaPatterns {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;

	JavaPatterns(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaPatterns");
		st.add("packageName", _packageName);
		st.add("name", _name);
		return st.render().trim();
	}

	public JavaPatterns setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public JavaPatterns removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JavaPatterns setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public JavaPatterns removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaPatterns that = (JavaPatterns) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaPatterns(packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.st.STGenerator;\n" + 
				"import nextgen.templates.java.Enum;\n" + 
				"import nextgen.templates.java.*;\n" + 
				"\n" + 
				"import java.io.File;\n" + 
				"import java.util.Collection;\n" + 
				"\n" + 
				"public class ~name~ extends JavaST {\n" + 
				"\n" + 
				"	public static void writeEnum(File root, PackageDeclaration packageDeclaration, String name, Object[] enumValues) {\n" + 
				"		final Enum content = JavaST.newEnum().setName(name).setPackage(packageDeclaration.getName());\n" + 
				"		for (Object enumValue : enumValues)\n" + 
				"				content.addEnumValues(enumValue);\n" + 
				"		STGenerator.writeJavaFile(content, packageDeclaration.getName(), name, root);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void writeEnum(File root, PackageDeclaration packageDeclaration, String name, Collection<EnumValue> enumValues) {\n" + 
				"		final Enum content = JavaST.newEnum().setName(name).setPackage(packageDeclaration.getName());\n" + 
				"		for (EnumValue enumValue : enumValues)\n" + 
				"				content.addEnumValues(enumValue);\n" + 
				"		STGenerator.writeJavaFile(content, packageDeclaration.getName(), name, root);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static PackageDeclaration newPackageDeclaration(String packageName) {\n" + 
				"		return newPackageDeclaration().setName(packageName);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {\n" + 
				"		return newPackageDeclaration().setName(parent.getName() + \".\" + packageName);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static ObjectCreationExpression newArrayListInstance() {\n" + 
				"		return newObjectCreationExpression().setType(newArrayListType());\n" + 
				"	}\n" + 
				"\n" + 
				"	public static ObjectCreationExpression newThread(Object body) {\n" + 
				"		return newObjectCreationExpression()\n" + 
				"					.setScope(CoreTypes.ThreadType)\n" + 
				"					.addArguments(newLambdaExpression().setBody(body));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Statement invokeLater(Object body) {\n" + 
				"		return newExpressionStmt()\n" + 
				"					.setExpression(newMethodCallExpression()\n" + 
				"								.setScope(SwingTypes.SwingUtilitiesType)\n" + 
				"								.setName(\"invokeLater\")\n" + 
				"								.addArguments(newLambdaExpression()\n" + 
				"										.setBody(body)));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Object newInvokeLater(Object statement) {\n" + 
				"		return newInvokeLater().setStatement(statement);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Object newInvokeLater(Object... statements) {\n" + 
				"		final InvokeLater invokeLater = newInvokeLater();\n" + 
				"		for (Object statement : statements)\n" + 
				"				invokeLater.addStatements(statement);\n" + 
				"		return invokeLater;\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newProtectedMethod(String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration()\n" + 
				"					.addModifiers(\"protected\")\n" + 
				"					.setName(name)\n" + 
				"					.setBlockStmt(blockStmt);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Parameter newParameter(ClassOrInterfaceType type, String name) {\n" + 
				"		return newParameter().setType(type).setName(name);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newMethodDeclarationFrom(MethodDeclaration prototype) {\n" + 
				"\n" + 
				"		final MethodDeclaration methodDeclaration = newMethodDeclaration()\n" + 
				"					.setName(prototype.getName())\n" + 
				"					.setType(prototype.getType());\n" + 
				"\n" + 
				"		prototype.getModifiers().forEach(methodDeclaration::addModifiers);\n" + 
				"		prototype.getParameters().forEach(methodDeclaration::addParameters);\n" + 
				"		return methodDeclaration;\n" + 
				"	}\n" + 
				"\n" + 
				"	public Statement statement(Expression expression) {\n" + 
				"		return newExpressionStmt()\n" + 
				"				.setExpression(expression);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodCallExpression methodCallExpression(Object scope, String name, Object... arguments) {\n" + 
				"		return newMethodCallExpression()\n" + 
				"					.setScope(scope)\n" + 
				"					.setName(name)\n" + 
				"					.setArguments(arguments);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static Object string(Object value) {\n" + 
				"		return \"\\\"\" + value + \"\\\"\";\n" + 
				"	}\n" + 
				"} >>";
}  