package net.filescan;

import nextgen.templates.java.*;

import static net.filescan.FilesScan.JavaPatterns.*;

public class FilesScan {

	final java.io.File root = new java.io.File("/home/goe/projects/filescan");
	final java.io.File mainJava = new java.io.File(root, "src/main/java");
	final java.io.File mainResources = new java.io.File(root, "src/main/resources");
	final java.io.File testJava = new java.io.File(root, "src/test/java");
	final java.io.File testResources = new java.io.File(root, "src/test/resources");

	// JSCH
	final PackageDeclaration jsch = newPackageDeclaration("com.jcraft.jsch");
	final NamedEntity JSch = new NamedEntity("JSch", jsch, "jsch");
	final NamedEntity Session = new NamedEntity("Session", jsch, "session");
	final NamedEntity UserInfo = new NamedEntity("UserInfo", jsch, "userInfo");
	final NamedEntity Channel = new NamedEntity("Channel", jsch, "channel");
	final NamedEntity ChannelExec = new NamedEntity("ChannelExec", jsch, "execChannel");

	final PackageDeclaration domain = newPackageDeclaration("net.filescan.domain");


	public static class JavaPatterns extends nextgen.templates.java.JavaST {

		// declarations
		public static PackageDeclaration newPackageDeclaration(String packageName) {
			return newPackageDeclaration()
					.setName(packageName);
		}

		public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {
			return newPackageDeclaration()
					.setName(parent.getName() + "." + packageName);
		}

		public static MethodDeclaration newPublicMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration(name, blockStmt)
					.addModifiers("public");
		}

		public static MethodDeclaration newPublicStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPublicMethodDeclaration(name, blockStmt)
					.addModifiers("static");
		}

		public static MethodDeclaration newPublicStaticFinalMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPublicStaticMethodDeclaration(name, blockStmt)
					.addModifiers("final");
		}

		public static MethodDeclaration newPublicFinalMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPublicMethodDeclaration(name, blockStmt)
					.addModifiers("final");
		}

		public static MethodDeclaration newProtectedMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration(name, blockStmt)
					.addModifiers("protected");
		}

		public static MethodDeclaration newProtectedStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newProtectedMethodDeclaration(name, blockStmt)
					.addModifiers("static");
		}

		public static MethodDeclaration newPrivateMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration(name, blockStmt)
					.addModifiers("private");
		}

		public static MethodDeclaration newPrivateStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPrivateMethodDeclaration(name, blockStmt)
					.addModifiers("static");
		}

		public static MethodDeclaration newStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration(name, blockStmt)
					.addModifiers("static");
		}

		public static MethodDeclaration newStaticFinalMethodDeclaration(String name, BlockStmt blockStmt) {
			return newStaticMethodDeclaration(name, blockStmt)
					.addModifiers("final");
		}

		public static MethodDeclaration newMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration()
					.setName(name)
					.setBlockStmt(blockStmt);
		}

		public static VariableDeclaration newVariableDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, Object initializer) {
			return newVariableDeclaration()
					.setType(classOrInterfaceType)
					.setName(name)
					.setInitializer(initializer);
		}

		public static FieldDeclaration newPrivateFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration(variableDeclaration)
					.addModifiers("private");
		}

		public static FieldDeclaration newProtectedFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration(variableDeclaration)
					.addModifiers("protected");
		}

		public static FieldDeclaration newPublicFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration(variableDeclaration)
					.addModifiers("public");
		}

		public static FieldDeclaration newFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration(variableDeclaration)
					.addModifiers("final");
		}

		public static FieldDeclaration newPrivateFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newPrivateFieldDeclaration(variableDeclaration)
					.addModifiers("final");
		}

		public static FieldDeclaration newProtectedFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newProtectedFieldDeclaration(variableDeclaration)
					.addModifiers("final");
		}

		public static FieldDeclaration newPublicFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newPublicFieldDeclaration(variableDeclaration)
					.addModifiers("final");
		}

		public static FieldDeclaration newFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration()
					.addVariables(variableDeclaration);
		}

		public static ClassOrInterfaceType newClassOrInterfaceType(Object scope, String name) {
			return newClassOrInterfaceType()
					.setScope(scope)
					.addNames(name);
		}

		public static Parameter newParameter(ClassOrInterfaceType type, String name) {
			return newParameter()
					.setType(type)
					.setName(name);
		}

		// statements
		public static Statement newExpressionStmt(Expression expression) {
			return newExpressionStmt()
					.setExpression(expression);
		}

		public static Statement newReturnStatement(Expression expression) {
			return newReturnStmt()
					.setExpression(expression);
		}

		// expressions
		public static ObjectCreationExpression newObjectCreationExpression(ClassOrInterfaceType classOrInterfaceType) {
			return newObjectCreationExpression()
					.setType(classOrInterfaceType);
		}

		public static LambdaExpression newLambdaExpression(Expression expression) {
			return newLambdaExpression()
					.setBody(expression);
		}

		public static LambdaExpression newLambdaExpression(Statement... statements) {
			return newLambdaExpression()
					.setBody(newBlockStmt()
						.setStatements(statements));
		}

		public static FieldAccessExpression newFieldAccessExpression(String scope, String name) {
			return newFieldAccessExpression()
					.setScope(scope)
					.setName(name);
		}

		public static VariableDeclarationExpression newFinalVariableDeclarationExpression(VariableDeclaration variableDeclaration) {
			return newVariableDeclarationExpression()
					.addModifiers("final")
					.addVariables(variableDeclaration);
		}

		public static MethodCallExpression newMethodCallExpression(FieldAccessExpression scope, String name, Object... arguments) {
			return newMethodCallExpression()
					.setScope(scope)
					.setName(name)
					.setArguments(arguments);
		}

		public static MethodCallExpression newMethodCallExpression(MethodCallExpression scope, String name, Object... arguments) {
			return newMethodCallExpression()
					.setScope(scope)
					.setName(name)
					.setArguments(arguments);
		}

		public static MethodCallExpression newMethodCallExpression(VariableDeclaration scope, String name, Object... arguments) {
			return newMethodCallExpression()
					.setScope(scope.getName())
					.setName(name)
					.setArguments(arguments);
		}

		public static MethodCallExpression newMethodCallExpression(ClassOrInterfaceType scope, String name, Object... arguments) {
			return newMethodCallExpression()
					.setScope(scope)
					.setName(name)
					.setArguments(arguments);
		}

		public static MethodCallExpression newMethodCallExpression(String scope, String name, Object... arguments) {
			return newMethodCallExpression()
					.setScope(scope)
					.setName(name)
					.setArguments(arguments);
		}

		public static MethodCallExpression newMethodCallExpression(String name, Object... arguments) {
			return newMethodCallExpression()
					.setName(name)
					.setArguments(arguments);
		}

		// formatting
		public static Object asString(Object value) {
			return "\"" + value + "\"";
		}
	}

	public static class NamedEntity {

		private final String name;
		private final PackageDeclaration packageDeclaration;

		private String variableName;

		NamedEntity(String name, PackageDeclaration packageDeclaration) {
			this.name = name;
			this.packageDeclaration = packageDeclaration;
		}

		NamedEntity(String name, PackageDeclaration packageDeclaration, String variableName) {
			this(name, packageDeclaration);
			this.variableName = variableName;
		}

		String name() {
			return name;
		}

		ClassOrInterfaceType type(Object... typeArguments) {
			return asClassOrInterfaceType(typeArguments);
		}

		String variableName() {
			return variableName == null ? Character.toLowerCase(name.charAt(0)) + name.substring(1) : variableName;
		}

		Parameter asParameter(Object... typeArguments) {
			return newParameter(asClassOrInterfaceType(typeArguments), variableName());
		}

		MethodCallExpression staticMethodCall(String name, Object... arguments) {
			return newMethodCallExpression(type(), name, arguments);
		}

		MethodCallExpression methodCall(String name, Object... arguments) {
			return newMethodCallExpression(variableName(), name, arguments);
		}

		Statement asVariable(Object initializer) {
			return newExpressionStmt(newFinalVariableDeclarationExpression(newVariableDeclaration(type(), variableName(), initializer)));
		}

		ClassOrInterfaceType asClassOrInterfaceType(Object... typeArguments) {
			return newClassOrInterfaceType(packageDeclaration == null ? null : packageDeclaration.getName(), name)
					.setTypeArguments(typeArguments);
		}

		ObjectCreationExpression newInstance(Object... arguments) {
			return newObjectCreationExpression(type())
					.setArguments(arguments);
		}
	}
}