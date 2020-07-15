package nextgen.templates.java;

public class JavaPatterns {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	JavaPatterns(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaPatterns");
		return st.render().trim();
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

	static final String st = "JavaPatterns() ::= <<public static class JavaPatterns extends nextgen.templates.java.JavaST {\n" + 
				"\n" + 
				"	// declarations\n" + 
				"	public static PackageDeclaration newPackageDeclaration(String packageName) {\n" + 
				"		return newPackageDeclaration()\n" + 
				"				.setName(packageName);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {\n" + 
				"		return newPackageDeclaration()\n" + 
				"				.setName(parent.getName() + \".\" + packageName);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPublicMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.PUBLIC);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPublicMethodDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration(classOrInterfaceType, name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.PUBLIC);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPublicStaticMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newPublicMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.STATIC);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPublicStaticFinalMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newPublicStaticMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPublicFinalMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newPublicMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPublicFinalMethodDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, BlockStmt blockStmt) {\n" + 
				"		return newPublicMethodDeclaration(classOrInterfaceType, name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newProtectedMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.PROTECTED);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newProtectedStaticMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newProtectedMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.STATIC);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPrivateMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.PRIVATE);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newPrivateStaticMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newPrivateMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.STATIC);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newStaticMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.STATIC);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newStaticFinalMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newStaticMethodDeclaration(name, blockStmt)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration()\n" + 
				"				.setName(name)\n" + 
				"				.setBlockStmt(blockStmt);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newMethodDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration()\n" + 
				"				.setType(classOrInterfaceType)\n" + 
				"				.setName(name)\n" + 
				"				.setBlockStmt(blockStmt);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newOverriddenMethodDeclaration(String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration()\n" + 
				"				.addAnnotations(newSingleMemberAnnotationExpression().setName(\"Override\"))\n" + 
				"				.setName(name)\n" + 
				"				.setBlockStmt(blockStmt);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodDeclaration newOverridenMethodDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, BlockStmt blockStmt) {\n" + 
				"		return newMethodDeclaration()\n" + 
				"				.addAnnotations(newSingleMemberAnnotationExpression().setName(\"Override\"))\n" + 
				"				.setType(classOrInterfaceType)\n" + 
				"				.setName(name)\n" + 
				"				.setBlockStmt(blockStmt);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static VariableDeclaration newVariableDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, Object initializer) {\n" + 
				"		return newVariableDeclaration()\n" + 
				"				.setType(classOrInterfaceType)\n" + 
				"				.setName(name)\n" + 
				"				.setInitializer(initializer);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newPrivateFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newFieldDeclaration(variableDeclaration)\n" + 
				"				.addModifiers(Modifiers.PRIVATE);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newProtectedFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newFieldDeclaration(variableDeclaration)\n" + 
				"				.addModifiers(Modifiers.PROTECTED);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newPublicFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newFieldDeclaration(variableDeclaration)\n" + 
				"				.addModifiers(Modifiers.PUBLIC);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newFinalFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newFieldDeclaration(variableDeclaration)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newPrivateFinalFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newPrivateFieldDeclaration(variableDeclaration)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newProtectedFinalFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newProtectedFieldDeclaration(variableDeclaration)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newPublicFinalFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newPublicFieldDeclaration(variableDeclaration)\n" + 
				"				.addModifiers(Modifiers.FINAL);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldDeclaration newFieldDeclaration(VariableDeclaration variableDeclaration) {\n" + 
				"		return newFieldDeclaration()\n" + 
				"				.addVariables(variableDeclaration);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static ClassOrInterfaceType newClassOrInterfaceType(Object scope, String name) {\n" + 
				"		return newClassOrInterfaceType()\n" + 
				"				.setScope(scope)\n" + 
				"				.addNames(name);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Parameter newParameter(ClassOrInterfaceType type, String name) {\n" + 
				"		return newParameter()\n" + 
				"				.setType(type)\n" + 
				"				.setName(name);\n" + 
				"	}\n" + 
				"\n" + 
				"	// statements\n" + 
				"	public static Statement newExpressionStmt(Expression expression) {\n" + 
				"		return newExpressionStmt()\n" + 
				"				.setExpression(expression);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Statement newReturnStatement(Expression expression) {\n" + 
				"		return newReturnStmt()\n" + 
				"				.setExpression(expression);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static SwitchStmt newSwitchStmt(Object selector) {\n" + 
				"		return newSwitchStmt()\n" + 
				"				.setSelector(selector);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static SwitchEntryStmt newSwitchEntryStmt(Object label, BlockStmt blockStmt) {\n" + 
				"		return newSwitchEntryStmt()\n" + 
				"				.addLabels(label)\n" + 
				"				.addStatements(blockStmt);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static BlockStmt newBlockStmt(String ... statements) {\n" + 
				"		return newBlockStmt()\n" + 
				"				.setStatements(statements);\n" + 
				"	}\n" + 
				"\n" + 
				"	// expressions\n" + 
				"	public static ObjectCreationExpression newObjectCreationExpression(ClassOrInterfaceType classOrInterfaceType) {\n" + 
				"		return newObjectCreationExpression()\n" + 
				"				.setType(classOrInterfaceType);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static LambdaExpression newLambdaExpression(Expression expression) {\n" + 
				"		return newLambdaExpression()\n" + 
				"				.setBody(expression);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static LambdaExpression newLambdaExpression(String expression) {\n" + 
				"		return newLambdaExpression()\n" + 
				"				.setBody(expression);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static LambdaExpression newLambdaExpression(Statement... statements) {\n" + 
				"		return newLambdaExpression()\n" + 
				"				.setBody(newBlockStmt()\n" + 
				"					.setStatements(statements));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldAccessExpression newFieldAccessExpression(ClassOrInterfaceType scope, String name) {\n" + 
				"		return newFieldAccessExpression()\n" + 
				"				.setScope(scope)\n" + 
				"				.setName(name);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldAccessExpression newFieldAccessExpression(Expression scope, String name) {\n" + 
				"		return newFieldAccessExpression()\n" + 
				"				.setScope(scope)\n" + 
				"				.setName(name);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static FieldAccessExpression newFieldAccessExpression(String scope, String name) {\n" + 
				"		return newFieldAccessExpression()\n" + 
				"				.setScope(scope)\n" + 
				"				.setName(name);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static VariableDeclarationExpression newFinalVariableDeclarationExpression(VariableDeclaration variableDeclaration) {\n" + 
				"		return newVariableDeclarationExpression()\n" + 
				"				.addModifiers(Modifiers.FINAL)\n" + 
				"				.addVariables(variableDeclaration);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodCallExpression newMethodCallExpression(Expression scope, String name, Object... arguments) {\n" + 
				"		return newMethodCallExpression()\n" + 
				"				.setScope(scope)\n" + 
				"				.setName(name)\n" + 
				"				.setArguments(arguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodCallExpression newMethodCallExpression(VariableDeclaration scope, String name, Object... arguments) {\n" + 
				"		return newMethodCallExpression()\n" + 
				"				.setScope(scope.getName())\n" + 
				"				.setName(name)\n" + 
				"				.setArguments(arguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodCallExpression newMethodCallExpression(ClassOrInterfaceType scope, String name, Object... arguments) {\n" + 
				"		return newMethodCallExpression()\n" + 
				"				.setScope(scope)\n" + 
				"				.setName(name)\n" + 
				"				.setArguments(arguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static MethodCallExpression newMethodCallExpression(String name, Object... arguments) {\n" + 
				"		return newMethodCallExpression()\n" + 
				"				.setName(name)\n" + 
				"				.setArguments(arguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Expression newExpression(String expression) {\n" + 
				"		return newNameExpression().setValue(expression);\n" + 
				"	}\n" + 
				"\n" + 
				"	// formatting\n" + 
				"	public static Object asString(Object value) {\n" + 
				"		return \"\\\"\" + value + \"\\\"\";\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"public static class NamedEntity {\n" + 
				"\n" + 
				"	private final String name;\n" + 
				"	private final PackageDeclaration packageDeclaration;\n" + 
				"	private String variableName;\n" + 
				"\n" + 
				"	NamedEntity(String name, PackageDeclaration packageDeclaration) {\n" + 
				"		this.name = name;\n" + 
				"		this.packageDeclaration = packageDeclaration;\n" + 
				"	}\n" + 
				"\n" + 
				"	NamedEntity(String name, PackageDeclaration packageDeclaration, String variableName) {\n" + 
				"		this(name, packageDeclaration);\n" + 
				"		this.variableName = variableName;\n" + 
				"	}\n" + 
				"\n" + 
				"	String name() {\n" + 
				"		return name;\n" + 
				"	}\n" + 
				"\n" + 
				"	String variableName() {\n" + 
				"		return variableName == null ? Character.toLowerCase(name.charAt(0)) + name.substring(1) : variableName;\n" + 
				"	}\n" + 
				"\n" + 
				"	MethodCallExpression staticMethodCall(String name, Object... arguments) {\n" + 
				"		return newMethodCallExpression(asClassOrInterfaceType(), name, arguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	MethodCallExpression methodCall(String name, Object... arguments) {\n" + 
				"		return newMethodCallExpression(newExpression(variableName()), name, arguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	Parameter asParameter(Object... typeArguments) {\n" + 
				"		return newParameter(asClassOrInterfaceType(typeArguments), variableName());\n" + 
				"	}\n" + 
				"\n" + 
				"	Parameter asParameter(NamedEntity typeArguments) {\n" + 
				"		return newParameter(asClassOrInterfaceType(typeArguments.asClassOrInterfaceType()), variableName());\n" + 
				"	}\n" + 
				"\n" + 
				"	Statement asFinalVariableDeclaration(Object initializer) {\n" + 
				"		return newExpressionStmt(newFinalVariableDeclarationExpression(newVariableDeclaration(asClassOrInterfaceType(), variableName(), initializer)));\n" + 
				"	}\n" + 
				"\n" + 
				"	ClassOrInterfaceType asClassOrInterfaceType(Object... typeArguments) {\n" + 
				"		return newClassOrInterfaceType(packageDeclaration == null ? null : packageDeclaration.getName(), name)\n" + 
				"				.setTypeArguments(typeArguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	ClassOrInterfaceType asClassOrInterfaceType(NamedEntity typeArgument) {\n" + 
				"		return asClassOrInterfaceType(typeArgument.asClassOrInterfaceType());\n" + 
				"	}\n" + 
				"\n" + 
				"	ObjectCreationExpression asObjectCreationExpression(Object... arguments) {\n" + 
				"		return newObjectCreationExpression(asClassOrInterfaceType())\n" + 
				"				.setArguments(arguments);\n" + 
				"	}\n" + 
				"\n" + 
				"	FieldAccessExpression asFieldAccessExpression(String fieldName) {\n" + 
				"		return newFieldAccessExpression(asClassOrInterfaceType(), fieldName);\n" + 
				"	}\n" + 
				"} >>";
}  