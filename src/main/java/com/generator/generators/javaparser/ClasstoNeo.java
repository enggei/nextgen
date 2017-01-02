package com.generator.generators.javaparser;

import com.generator.editors.NeoModel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Stack;
import java.util.UUID;

/**
 * goe on 11/9/16.
 */
public class ClasstoNeo extends BaseClassVisitor {

	private final NeoModel graph;
	private final Stack<Node> nodes = new Stack<>();

	protected Node classNode;

	public ClasstoNeo(NeoModel graph) {
		this.graph = graph;
	}

	@Override
	void onClass(Package classPackage, String className, Class superClass) {
		classNode = newNode("Class");
		classNode.setProperty("package", classPackage.getName());
		classNode.setProperty("name", className);
		if (superClass != null) classNode.setProperty("super", superClass.getName());
		nodes.push(classNode);
	}

	@Override
	void onInterface(Class classInterface) {
		final Node node = newNode("Interface");
		node.setProperty("name", classInterface.getName());
		nodes.peek().createRelationshipTo(node, RelationshipType.withName("interface"));
	}

	@Override
	void onPublicField(String name, Class<?> returnType) {
		newField(name, returnType, "public");
	}

	@Override
	void onProtectedField(String name, Class<?> returnType) {
		newField(name, returnType, "protected");
	}

	@Override
	void onPackageField(String name, Class<?> returnType) {
		newField(name, returnType, "package");
	}

	@Override
	void onPrivateField(String name, Class<?> returnType) {
		newField(name, returnType, "private");
	}

	@Override
	void onPublicConstructor(String name) {
		newConstructor(name, "public");
	}

	@Override
	void onProtectedConstructor(String name) {
		newConstructor(name, "protected");
	}

	@Override
	void onPackageConstructor(String name) {
		newConstructor(name, "package");
	}

	@Override
	void onPrivateConstructor(String name) {
		newConstructor(name, "private");
	}

	@Override
	void onConstructorComplete() {
		nodes.pop();
	}

	@Override
	void onParameter(String name, Class<?> type) {
		final Node node = newNode("Parameter");
		node.setProperty("name", name);
		node.setProperty("type", type.getName());
		nodes.peek().createRelationshipTo(node, RelationshipType.withName("parameter"));
	}

	@Override
	void onTypeParameter(String name, Type[] bounds) {
		final Node node = newNode("TypeParameter");
		node.setProperty("name", name);
		final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("parameter"));
		relationship.setProperty("bounds", Boolean.TRUE);

		for (Type bound : bounds) {
			// todo: look this up in db, so types are joined..
			System.out.println("lookup bound-types");
			final Node boundNode =  newNode("Bound");
			boundNode.setProperty("name", bound.getTypeName());
			node.createRelationshipTo(boundNode, RelationshipType.withName("type"));
		}
	}

	@Override
	void onDeclaredMethod(Method method) {
		final Node node = newNode("Method");
		node.setProperty("name", method.getName());
		node.setProperty("returnType", method.getReturnType().getName());
		nodes.peek().createRelationshipTo(node, RelationshipType.withName("method"));
	}

	@Override
	void onInnerClass(Class innerClass) {
		final ClasstoNeo innerClassVisitor = new ClasstoNeo(graph);
		innerClassVisitor.visit(innerClass);
		nodes.peek().createRelationshipTo(innerClassVisitor.classNode, RelationshipType.withName("innerClass"));
	}

	@Override
	public void done() {
	}

	private Node newNode(String label) {
		Node node = graph.createNode(Label.label(label));
		node.setProperty("_uuid", UUID.randomUUID().toString());
		return node;
	}

	private void newField(String name, Class<?> returnType, String scope) {
		final Node node = newNode("Field");
		node.setProperty("name", name);
		node.setProperty("type", returnType.getName());
		node.setProperty("scope", scope);
		nodes.peek().createRelationshipTo(node, RelationshipType.withName("field"));
	}

	private void newConstructor(String name, String scope) {
		final Node node = newNode("Constructor");
		node.setProperty("name", name);
		node.setProperty("scope", scope);
		nodes.peek().createRelationshipTo(node, RelationshipType.withName("constructor"));
		nodes.push(node);
	}
}