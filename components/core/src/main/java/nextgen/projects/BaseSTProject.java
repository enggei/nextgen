package nextgen.projects;

import nextgen.templates.java.*;

import static nextgen.projects.BaseSTProject.JavaPatterns.*;

public class BaseSTProject {

	final java.io.File root = new java.io.File("/home/goe/projects/nextgen/components/core");
	final java.io.File mainJava = new java.io.File(root, "src/main/java");
	final java.io.File mainResources = new java.io.File(root, "src/main/resources");
	final java.io.File testJava = new java.io.File(root, "src/test/java");
	final java.io.File testResources = new java.io.File(root, "src/test/resources");

	// Vertx
	// core
	final PackageDeclaration vertxCore = newPackageDeclaration("io.vertx.core");
	final NamedEntity Future = new NamedEntity("Future", vertxCore, "future");

	// Java Core
	// Java Util
	final PackageDeclaration javaUtil = newPackageDeclaration("java.util");
	final NamedEntity UUID = new NamedEntity("UUID", javaUtil, "uuid");

	// todo refactor away, into JavaPackage "Java Core"

	final NamedEntity String = new NamedEntity("String");
	final NamedEntity intType = new NamedEntity("int");

	final NamedEntity Map = new NamedEntity("Map", javaUtil);
	final NamedEntity Set = new NamedEntity("Set", javaUtil);
	final NamedEntity List = new NamedEntity("List", javaUtil);
	final NamedEntity Collection = new NamedEntity("Collection", javaUtil);
	final NamedEntity LinkedHashMap = new NamedEntity("LinkedHashMap", javaUtil);
	final NamedEntity LinkedHashSet = new NamedEntity("LinkedHashSet", javaUtil);
	final NamedEntity TreeSet = new NamedEntity("TreeSet", javaUtil);

	final PackageDeclaration javaUtilFunction = newPackageDeclaration("java.util.function");
	final NamedEntity Consumer = new NamedEntity("Consumer", javaUtilFunction);
	final NamedEntity BiConsumer = new NamedEntity("BiConsumer", javaUtilFunction, "consumer");

	Statement newLinkedHashMap(String variableName, Object keyType, Object valueType) {
		return statement(newVariableDeclarationExpression()
				.addModifiers("final")
				.addVariables(newVariableDeclaration()
						.setName(variableName)
						.setType(Map.asClassOrInterfaceType()
								.addTypeArguments(keyType)
								.addTypeArguments(valueType))
						.setInitializer(LinkedHashMap.newInstance()
								.addTypeArguments(""))));
	}

	Statement put(String scope, Object key, Object value) {
		return newExpressionStmt()
			.setExpression(newMethodCallExpression()
			.setScope(scope)
			.setName("put")
			.addArguments(key)
			.addArguments(value));
	}

	// ST App
	final PackageDeclaration stPackage = newPackageDeclaration("nextgen.st");
	final NamedEntity STRenderer = new NamedEntity("STRenderer", stPackage, "stRenderer");
	// ST template domain
	final PackageDeclaration stDomainPackage = newPackageDeclaration(stPackage, "domain");
	final NamedEntity STTemplate = new NamedEntity("STTemplate", stDomainPackage, "stTemplate");
	final NamedEntity STParameter = new NamedEntity("STParameter", stDomainPackage, "stParameter");
	final NamedEntity STParameterKey = new NamedEntity("STParameterKey", stDomainPackage, "stParameterKey");

	// ST value domain
	final PackageDeclaration stModelPackage = newPackageDeclaration(stPackage, "model");
	final NamedEntity STModelDB = new NamedEntity("STModelDB", stModelPackage, "modelDb");
	final NamedEntity STModel = new NamedEntity("STModel", stModelPackage, "stModel");
	final NamedEntity STValue = new NamedEntity("STValue", stModelPackage, "stValue");
	final NamedEntity STArgument = new NamedEntity("STArgument", stModelPackage, "stArgument");
	final NamedEntity STFile = new NamedEntity("STFile", stModelPackage, "stFile");
	final NamedEntity STArgumentKV = new NamedEntity("STArgumentKV", stModelPackage, "stArgumentKV");

	final PackageDeclaration stCanvasPackage = newPackageDeclaration(stPackage, "canvas");
	final NamedEntity STModelNode = new NamedEntity("STModelNode", stCanvasPackage, "stModelNode");
	final NamedEntity STValueNode = new NamedEntity("STValueNode", stCanvasPackage, "stValueNode");
	final NamedEntity STArgumentRelation = new NamedEntity("STArgumentRelation", stCanvasPackage, "stArgumentRelation");
	final NamedEntity STKVArgumentRelation = new NamedEntity("STKVArgumentRelation", stCanvasPackage, "stkArgumentRelation");
	final NamedEntity STValueModelRelation = new NamedEntity("STValueModelRelation", stCanvasPackage, "stValueModelRelation");
	final NamedEntity STKVNode = new NamedEntity("STKVNode", stCanvasPackage, "stKVNode");
	final NamedEntity STFileNode = new NamedEntity("STFileNode", stCanvasPackage, "stFileNode");
	final NamedEntity STCanvas = new NamedEntity("STCanvas", stCanvasPackage, "canvas");
	final NamedEntity STRelation = new NamedEntity("STRelation", stCanvasPackage, "stRelation");
	final NamedEntity STNode = new NamedEntity("STNode", stCanvasPackage, "stNode");

	// Neo4J
	final PackageDeclaration neo4jGraphdb = newPackageDeclaration("org.neo4j.graphdb");
	final NamedEntity NeoTransaction = new NamedEntity("Transaction", neo4jGraphdb);

	// java Swing
	// Java Swing
	final PackageDeclaration javaxSwing = newPackageDeclaration("javax.swing");
	final NamedEntity JTextField = new NamedEntity("JTextField", javaxSwing, "textField");
	final NamedEntity JTextArea = new NamedEntity("JTextArea", javaxSwing, "textArea");
	final NamedEntity SwingUtilities = new NamedEntity("SwingUtilities", javaxSwing);
	public MethodCallExpression invokeLater(Expression expression) {
	    	return newMethodCallExpression().setScope(SwingUtilities.type()).setName("invokeLater").addArguments(newLambdaExpression().setBody(expression));
		}


	public static class NamedEntity {

		private final String name;
		private final PackageDeclaration packageDeclaration;
		Object content;

		private String variableName;

		NamedEntity(String name) {
			this.name = name;
			this.packageDeclaration = null;
		}

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
			return newParameter().setType(asClassOrInterfaceType(typeArguments)).setName(variableName());
		}

		MethodCallExpression staticMethodCall(String name, Object... arguments) {
			return methodCallExpression(type(), name, arguments);
		}

		MethodCallExpression methodCall(String name, Object... arguments) {
			return methodCallExpression(variableName(), name, arguments);
		}

		Statement asVariable(Object initializer) {
			return newExpressionStmt()
					.setExpression(newVariableDeclarationExpression()
							.addModifiers("final")
							.addVariables(newVariableDeclaration()
									.setName(variableName())
									.setType(type())
									.setInitializer(initializer)));
		}

		ClassOrInterfaceType asClassOrInterfaceType(Object... typeArguments) {
			return newClassOrInterfaceType()
					.addNames(name())
					.setScope(packageDeclaration == null ? null : packageDeclaration.getName())
					.setTypeArguments(typeArguments);
		}

		ObjectCreationExpression newInstance(Object... arguments) {
			return newObjectCreationExpression()
					.setType(type())
					.setArguments(arguments);
		}
	}

	public static class JavaPatterns extends nextgen.templates.java.JavaST {

		public static PackageDeclaration newPackageDeclaration(String packageName) {
			return newPackageDeclaration().setName(packageName);
		}

		public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {
			return newPackageDeclaration().setName(parent.getName() + "." + packageName);
		}

		public static ObjectCreationExpression newArrayListInstance() {
			return newObjectCreationExpression().setType(newArrayListType());
		}

		public static ObjectCreationExpression newThread(Object body) {
			return newObjectCreationExpression()
						.setScope(CoreTypes.ThreadType)
						.addArguments(newLambdaExpression().setBody(body));
		}

		public static Statement invokeLater(Object body) {
			return newExpressionStmt()
						.setExpression(newMethodCallExpression()
									.setScope(SwingTypes.SwingUtilitiesType)
									.setName("invokeLater")
									.addArguments(newLambdaExpression()
											.setBody(body)));
		}

		public static MethodDeclaration newProtectedMethod(String name, BlockStmt blockStmt) {
			return newMethodDeclaration()
						.addModifiers("protected")
						.setName(name)
						.setBlockStmt(blockStmt);
		}

		public static Parameter newParameter(ClassOrInterfaceType type, String name) {
			return newParameter().setType(type).setName(name);
		}

		public static Statement statement(Expression expression) {
			return newExpressionStmt()
					.setExpression(expression);
		}

		public static MethodCallExpression methodCallExpression(Object scope, String name, Object... arguments) {
			return newMethodCallExpression()
						.setScope(scope)
						.setName(name)
						.setArguments(arguments);
		}

		public static MethodCallExpression methodCallExpression(String name, Object... arguments) {
			return methodCallExpression(null, name, arguments);
		}

		public static Object asString(Object value) {
			return "\"" + value + "\"";
		}
	}
}