package nextgen.projects;

import nextgen.templates.java.*;

import static nextgen.st.STGenerator.*;
import static nextgen.templates.JavaPatterns.*;

public class BaseSTProject {

	final java.io.File root = new java.io.File("/home/goe/projects/nextgen/components/core");
	final java.io.File mainJava = new java.io.File(root, "src/main/java");
	final java.io.File mainResources = new java.io.File(root, "src/main/resources");

	final java.io.File testJava = new java.io.File(root, "src/test/java");
	final java.io.File testResources = new java.io.File(root, "src/test/resources");


	final PackageDeclaration stPackage = newPackageDeclaration("nextgen.st");
	final NamedEntity STRenderer = new NamedEntity("STRenderer", stPackage).setVariableName("stRenderer");

	final PackageDeclaration stCanvasPackage = newPackageDeclaration(stPackage, "canvas");
	final NamedEntity STModelNode = new NamedEntity("STModelNode", stCanvasPackage).setVariableName("stModelNode");
	final NamedEntity STValueNode = new NamedEntity("STValueNode", stCanvasPackage).setVariableName("stValueNode");
	final NamedEntity STArgumentRelation = new NamedEntity("STArgumentRelation", stCanvasPackage).setVariableName("stArgumentRelation");
	final NamedEntity STKVArgumentRelation = new NamedEntity("STKVArgumentRelation", stCanvasPackage).setVariableName("stkArgumentRelation");
	final NamedEntity STValueModelRelation = new NamedEntity("STValueModelRelation", stCanvasPackage).setVariableName("stValueModelRelation");
	final NamedEntity STKVNode = new NamedEntity("STKVNode", stCanvasPackage).setVariableName("stKVNode");
	final NamedEntity STFileNode = new NamedEntity("STFileNode", stCanvasPackage).setVariableName("stFileNode");
	final NamedEntity STCanvas = new NamedEntity("STCanvas", stCanvasPackage).setVariableName("canvas");
	final NamedEntity STRelation = new NamedEntity("STRelation", stCanvasPackage).setVariableName("stRelation");
	final NamedEntity STNode = new NamedEntity("STNode", stCanvasPackage).setVariableName("stNode");

	// ST template domain
	final PackageDeclaration stDomainPackage = newPackageDeclaration(stPackage, "domain");
	final NamedEntity STTemplate = new NamedEntity("STTemplate", stDomainPackage).setVariableName("stTemplate");
	final NamedEntity STParameter = new NamedEntity("STParameter", stDomainPackage).setVariableName("stParameter");
	final NamedEntity STParameterKey = new NamedEntity("STParameterKey", stDomainPackage).setVariableName("stParameterKey");

	// ST value domain
	final PackageDeclaration stModelPackage = newPackageDeclaration(stPackage, "model");
	final NamedEntity STModelDB = new NamedEntity("STModelDB", stModelPackage).setVariableName("modelDb");
	final NamedEntity STModel = new NamedEntity("STModel", stModelPackage).setVariableName("stModel");
	final NamedEntity STValue = new NamedEntity("STValue", stModelPackage).setVariableName("stValue");
	final NamedEntity STArgument = new NamedEntity("STArgument", stModelPackage).setVariableName("stArgument");
	final NamedEntity STFile = new NamedEntity("STFile", stModelPackage).setVariableName("stFile");
	final NamedEntity STArgumentKV = new NamedEntity("STArgumentKV", stModelPackage).setVariableName("stArgumentKV");

	// Java core --
	final NamedEntity String = new NamedEntity("String");
	final NamedEntity intType = new NamedEntity("int");

	final PackageDeclaration javaUtil = newPackageDeclaration("java.util");
	final NamedEntity UUID = new NamedEntity("UUID", javaUtil);
	final NamedEntity Map = new NamedEntity("Map", javaUtil);
	final NamedEntity Set = new NamedEntity("Set", javaUtil);
	final NamedEntity List = new NamedEntity("List", javaUtil);
	final NamedEntity Collection = new NamedEntity("Collection", javaUtil);
	final NamedEntity LinkedHashMap = new NamedEntity("LinkedHashMap", javaUtil);
	final NamedEntity LinkedHashSet = new NamedEntity("LinkedHashSet", javaUtil);
	final NamedEntity TreeSet = new NamedEntity("TreeSet", javaUtil);

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
	// -- Java core

	// Java swing --
	final PackageDeclaration javaxSwing = newPackageDeclaration("javax.swing");
	final NamedEntity JTextField = new NamedEntity("JTextField", javaxSwing);
	// -- Java swing


	void writeToMainJava(NamedEntity entity) {
		writeJavaFile(entity.content, entity.packageDeclaration, entity.name, mainJava);
	}

	Statement statement(Expression expression) {
		return newExpressionStmt().setExpression(expression);
	}

	Object asString(Object value) {
		return "\"" + value + "\"";
	}

	static class NamedEntity {

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

		NamedEntity(String name, PackageDeclaration packageDeclaration, Object content) {
			this(name, packageDeclaration);
			this.content = content;
		}

		NamedEntity setVariableName(String variableName) {
			this.variableName = variableName;
			return this;
		}

		String name() {
			return name;
		}

		String type() {
			return packageDeclaration == null ? name : (packageDeclaration.getName() + "." + name);
		}

		String variableName() {
			return variableName == null ? Character.toLowerCase(name.charAt(0)) + name.substring(1) : variableName;
		}

		Parameter asParameter() {
			return newParameter(type(), variableName());
		}

		MethodCallExpression staticMethodCall(String name, Object... arguments) {
			return newMethodCallExpression()
					.setScope(type())
					.setName(name)
					.setArguments(arguments);
		}

		MethodCallExpression methodCall(String name, Object... arguments) {
			return newMethodCallExpression()
					.setScope(variableName())
					.setName(name)
					.setArguments(arguments);
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

		ClassOrInterfaceType asClassOrInterfaceType() {
			return newClassOrInterfaceType()
					.addNames(name())
					.setScope(packageDeclaration == null ? null : packageDeclaration.getName());
		}

		ObjectCreationExpression newInstance(Object... arguments) {
			return newObjectCreationExpression()
					.setType(type())
					.setArguments(arguments);
		}
	}
}