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
	final NamedEntity VertxFuture = new NamedEntity("Future", vertxCore, "future");

	// Java Core
	final PackageDeclaration javaLang = newPackageDeclaration("java.lang");
	final NamedEntity longType = new NamedEntity("long", null);
	final NamedEntity doubleType = new NamedEntity("double", null);
	final NamedEntity intType = new NamedEntity("int", null);
	final NamedEntity String = new NamedEntity("String", null, "string");

	// Java Util
	final PackageDeclaration javaUtil = newPackageDeclaration("java.util");
	final NamedEntity UUID = new NamedEntity("UUID", javaUtil, "uuid");
	final NamedEntity Map = new NamedEntity("Map", javaUtil);
	final NamedEntity Set = new NamedEntity("Set", javaUtil);
	final NamedEntity List = new NamedEntity("List", javaUtil);
	final NamedEntity Collection = new NamedEntity("Collection", javaUtil);
	final NamedEntity LinkedHashMap = new NamedEntity("LinkedHashMap", javaUtil);
	final NamedEntity LinkedHashSet = new NamedEntity("LinkedHashSet", javaUtil);
	final NamedEntity TreeSet = new NamedEntity("TreeSet", javaUtil);

	public Statement newLinkedHashMap(String name, ClassOrInterfaceType keyType, ClassOrInterfaceType valueType) {
		return newExpressionStmt(newFinalVariableDeclarationExpression(newVariableDeclaration(LinkedHashMap.asClassOrInterfaceType(keyType, valueType), name, newObjectCreationExpression(LinkedHashMap.asClassOrInterfaceType().setIsTyped(Boolean.TRUE)))));
	}

	final PackageDeclaration javaUtilConcurrent = newPackageDeclaration(javaUtil, "concurrent");
	final NamedEntity Executor = new NamedEntity("Executor", javaUtilConcurrent);
	final NamedEntity ExecutorService = new NamedEntity("ExecutorService", javaUtilConcurrent);
	final NamedEntity ScheduledExecutorService = new NamedEntity("ScheduledExecutorService", javaUtilConcurrent);
	final NamedEntity Future = new NamedEntity("Future", javaUtilConcurrent);
	final NamedEntity CountDownLatch = new NamedEntity("CountDownLatch", javaUtilConcurrent);
	final NamedEntity CyclicBarrier = new NamedEntity("CyclicBarrier", javaUtilConcurrent);
	final NamedEntity Semaphore = new NamedEntity("Semaphore", javaUtilConcurrent);
	final NamedEntity ThreadFactory = new NamedEntity("ThreadFactory", javaUtilConcurrent);
	final NamedEntity BlockingQueue = new NamedEntity("BlockingQueue", javaUtilConcurrent);
	final NamedEntity DelayQueue = new NamedEntity("DelayQueue", javaUtilConcurrent);
	final NamedEntity Locks = new NamedEntity("Locks", javaUtilConcurrent);
	final NamedEntity Phaser = new NamedEntity("Phaser", javaUtilConcurrent);


	final PackageDeclaration javaUtilConcurrentAtomic = newPackageDeclaration(javaUtilConcurrent, "atomic");
	final NamedEntity AtomicBoolean = new NamedEntity("AtomicBoolean", javaUtilConcurrentAtomic);
	final NamedEntity AtomicInteger = new NamedEntity("AtomicInteger", javaUtilConcurrentAtomic);
	final NamedEntity AtomicLong = new NamedEntity("AtomicLong", javaUtilConcurrentAtomic);
	final NamedEntity AtomicReference = new NamedEntity("AtomicReference", javaUtilConcurrentAtomic);

	final PackageDeclaration javaUtilFunction = newPackageDeclaration(javaUtil, "function");
	final NamedEntity Consumer = new NamedEntity("Consumer", javaUtilFunction, "consumer");
	final NamedEntity BiConsumer = new NamedEntity("BiConsumer", javaUtilFunction, "consumer");

	final PackageDeclaration javaIO = newPackageDeclaration("java.io");
	final NamedEntity File = new NamedEntity("File", javaIO, "file");

	// ST App
	final PackageDeclaration stPackage = newPackageDeclaration("nextgen.st");
	final NamedEntity STRenderer = new NamedEntity("STRenderer", stPackage, "stRenderer");
	final NamedEntity STGenerator = new NamedEntity("STGenerator", stPackage, "stGenerator");


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
	final NamedEntity STSinkRelation = new NamedEntity("STSinkRelation", stCanvasPackage, "stSinkRelation");


	final PackageDeclaration layout = newPackageDeclaration(stCanvasPackage, "layout");
	final NamedEntity Layout = new NamedEntity("Layout", layout, "layout");
	final NamedEntity LayoutNode = new NamedEntity("LayoutNode", layout, "layoutNode");

	// Neo4J
	// graphdb
	final PackageDeclaration graphdb = newPackageDeclaration("org.neo4j.graphdb");
	final NamedEntity NeoNode = new NamedEntity("Node", graphdb, "node");
	final NamedEntity NeoRelation = new NamedEntity("Relationship", graphdb, "relation");
	final NamedEntity NeoDirection = new NamedEntity("Direction", graphdb);
	final NamedEntity NeoRelationType = new NamedEntity("RelationshipType", graphdb, "relationType");
	final NamedEntity NeoTransaction = new NamedEntity("Transaction", graphdb, "tx");

	// java Swing
	// Java Swing
	final PackageDeclaration javaxSwing = newPackageDeclaration("javax.swing");
	final NamedEntity BorderFactory = new NamedEntity("BorderFactory", javaxSwing);
	final NamedEntity JButton = new NamedEntity("JButton", javaxSwing);
	final NamedEntity JCheckBox = new NamedEntity("JCheckBox", javaxSwing);
	final NamedEntity JComboBox = new NamedEntity("JComboBox", javaxSwing);
	final NamedEntity JLabel = new NamedEntity("JLabel", javaxSwing);
	final NamedEntity JPopupMenu = new NamedEntity("JPopupMenu", javaxSwing);
	final NamedEntity JTree = new NamedEntity("JTree", javaxSwing);
	final NamedEntity JTextField = new NamedEntity("JTextField", javaxSwing, "textField");
	final NamedEntity JTextArea = new NamedEntity("JTextArea", javaxSwing, "textArea");
	final NamedEntity SwingUtilities = new NamedEntity("SwingUtilities", javaxSwing);
	final NamedEntity JMenu = new NamedEntity("JMenu", javaxSwing, "jMenu");
	final NamedEntity JPanel = new NamedEntity("JPanel", javaxSwing, "panel");
	final NamedEntity JTabbedPane = new NamedEntity("JTabbedPane", javaxSwing, "tabbedPane");
	final NamedEntity JFrame = new NamedEntity("JFrame", javaxSwing, "frame");

	public Statement invokeLater(Expression expression) {
		return newExpressionStmt(newMethodCallExpression().setScope(SwingUtilities.asClassOrInterfaceType()).setName("invokeLater").addArguments(newLambdaExpression(expression)));
	}

	// Generator
	final PackageDeclaration generatorUtil = newPackageDeclaration("com.generator.util");
	final NamedEntity SwingUtil = new NamedEntity("SwingUtil", generatorUtil);


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
					.addModifiers(Modifiers.PUBLIC);
		}

		public static MethodDeclaration newPublicMethodDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, BlockStmt blockStmt) {
			return newMethodDeclaration(classOrInterfaceType, name, blockStmt)
					.addModifiers(Modifiers.PUBLIC);
		}

		public static MethodDeclaration newPublicStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPublicMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.STATIC);
		}

		public static MethodDeclaration newPublicStaticFinalMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPublicStaticMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.FINAL);
		}

		public static MethodDeclaration newPublicFinalMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPublicMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.FINAL);
		}

		public static MethodDeclaration newPublicFinalMethodDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, BlockStmt blockStmt) {
			return newPublicMethodDeclaration(classOrInterfaceType, name, blockStmt)
					.addModifiers(Modifiers.FINAL);
		}

		public static MethodDeclaration newProtectedMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.PROTECTED);
		}

		public static MethodDeclaration newProtectedStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newProtectedMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.STATIC);
		}

		public static MethodDeclaration newPrivateMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.PRIVATE);
		}

		public static MethodDeclaration newPrivateStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newPrivateMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.STATIC);
		}

		public static MethodDeclaration newStaticMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.STATIC);
		}

		public static MethodDeclaration newStaticFinalMethodDeclaration(String name, BlockStmt blockStmt) {
			return newStaticMethodDeclaration(name, blockStmt)
					.addModifiers(Modifiers.FINAL);
		}

		public static MethodDeclaration newMethodDeclaration(String name, BlockStmt blockStmt) {
			return newMethodDeclaration()
					.setName(name)
					.setBlockStmt(blockStmt);
		}

		public static MethodDeclaration newMethodDeclaration(ClassOrInterfaceType classOrInterfaceType, String name, BlockStmt blockStmt) {
			return newMethodDeclaration()
					.setType(classOrInterfaceType)
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
					.addModifiers(Modifiers.PRIVATE);
		}

		public static FieldDeclaration newProtectedFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration(variableDeclaration)
					.addModifiers(Modifiers.PROTECTED);
		}

		public static FieldDeclaration newPublicFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration(variableDeclaration)
					.addModifiers(Modifiers.PUBLIC);
		}

		public static FieldDeclaration newFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newFieldDeclaration(variableDeclaration)
					.addModifiers(Modifiers.FINAL);
		}

		public static FieldDeclaration newPrivateFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newPrivateFieldDeclaration(variableDeclaration)
					.addModifiers(Modifiers.FINAL);
		}

		public static FieldDeclaration newProtectedFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newProtectedFieldDeclaration(variableDeclaration)
					.addModifiers(Modifiers.FINAL);
		}

		public static FieldDeclaration newPublicFinalFieldDeclaration(VariableDeclaration variableDeclaration) {
			return newPublicFieldDeclaration(variableDeclaration)
					.addModifiers(Modifiers.FINAL);
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

		public static SwitchStmt newSwitchStmt(Object selector) {
			return newSwitchStmt()
					.setSelector(selector);
		}

		public static SwitchEntryStmt newSwitchEntryStmt(Object label, BlockStmt blockStmt) {
			return newSwitchEntryStmt()
					.addLabels(label)
					.addStatements(blockStmt);
		}

		public static BlockStmt newBlockStmt(String ... statements) {
			return newBlockStmt()
					.setStatements(statements);
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

		public static LambdaExpression newLambdaExpression(String expression) {
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
					.addModifiers(Modifiers.FINAL)
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

		String variableName() {
			return variableName == null ? Character.toLowerCase(name.charAt(0)) + name.substring(1) : variableName;
		}

		MethodCallExpression staticMethodCall(String name, Object... arguments) {
			return newMethodCallExpression(asClassOrInterfaceType(), name, arguments);
		}

		MethodCallExpression methodCall(String name, Object... arguments) {
			return newMethodCallExpression(variableName(), name, arguments);
		}

		Parameter asParameter(Object... typeArguments) {
			return newParameter(asClassOrInterfaceType(typeArguments), variableName());
		}

		Parameter asParameter(NamedEntity typeArguments) {
			return newParameter(asClassOrInterfaceType(typeArguments.asClassOrInterfaceType()), variableName());
		}

		Statement asFinalVariableDeclaration(Object initializer) {
			return newExpressionStmt(newFinalVariableDeclarationExpression(newVariableDeclaration(asClassOrInterfaceType(), variableName(), initializer)));
		}

		ClassOrInterfaceType asClassOrInterfaceType(Object... typeArguments) {
			return newClassOrInterfaceType(packageDeclaration == null ? null : packageDeclaration.getName(), name)
					.setTypeArguments(typeArguments);
		}

		ClassOrInterfaceType asClassOrInterfaceType(NamedEntity typeArgument) {
			return asClassOrInterfaceType(typeArgument.asClassOrInterfaceType());
		}

		ObjectCreationExpression asObjectCreationExpression(Object... arguments) {
			return newObjectCreationExpression(asClassOrInterfaceType())
					.setArguments(arguments);
		}
	}
}