package com.generator.generators.java;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.generators.javareflection.BaseClassVisitor;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

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

   public ClasstoNeo(NeoModel graph) {
      this.graph = graph;
   }

   @Override
   public void onClass(Package classPackage, String className, Class superClass) {
      Node classNode = newNode(JavaDomain.Entities.Class.name());
      classNode.setProperty("package", classPackage.getName());
      classNode.setProperty("name", className);
      if (superClass != null) classNode.setProperty("super", superClass.getName());
      nodes.push(classNode);
   }

   @Override
   public void onInterface(Class classInterface) {
      final Node node = newNode(JavaDomain.Entities.Interface.name());
      node.setProperty("name", classInterface.getName());
      nodes.peek().createRelationshipTo(node, JavaDomain.Relations.IMPLEMENTS);
   }

   @Override
   public void onPublicField(String name, Class<?> returnType) {
      newField(name, returnType, "public");
   }

   @Override
   public void onProtectedField(String name, Class<?> returnType) {
      newField(name, returnType, "protected");
   }

   @Override
   public void onPackageField(String name, Class<?> returnType) {
      newField(name, returnType, "package");
   }

   @Override
   public void onPrivateField(String name, Class<?> returnType) {
      newField(name, returnType, "private");
   }

   @Override
   public void onPublicConstructor(String name) {
      newConstructor(name, "public");
   }

   @Override
   public void onProtectedConstructor(String name) {
      newConstructor(name, "protected");
   }

   @Override
   public void onPackageConstructor(String name) {
      newConstructor(name, "package");
   }

   @Override
   public void onPrivateConstructor(String name) {
      newConstructor(name, "private");
   }

   @Override
   public void onConstructorComplete() {
      nodes.pop();
   }

   @Override
   public void onParameter(String name, Class<?> type) {
      final Node node = newNode("Parameter");
      node.setProperty("name", name);
      node.setProperty("type", type.getName());
      nodes.peek().createRelationshipTo(node, JavaDomain.Relations.PARAMETER);
   }

   @Override
   public void onTypeParameter(String name, Type[] bounds) {
      final Node node = newNode("TypeParameter");
      node.setProperty("name", name);
      final Relationship relationship = nodes.peek().createRelationshipTo(node, JavaDomain.Relations.PARAMETER);
      relationship.setProperty("bounds", Boolean.TRUE);

      for (Type bound : bounds) {
         System.out.println("Parameter Bound " + bound);
//         final Node boundNode = newNode("Bound");
//         boundNode.setProperty("name", bound.getTypeName());
//         node.createRelationshipTo(boundNode, JavaDomain.Relations.TYPE);
      }
   }

   @Override
   public void onDeclaredMethod(Method method) {
      final Node node = newNode("Method");
      node.setProperty("name", method.getName());
      node.setProperty("returnType", method.getReturnType().getName());
      nodes.peek().createRelationshipTo(node, JavaDomain.Relations.METHOD);
   }

   @Override
   public void onInnerClass(Class innerClass) {
      final ClasstoNeo innerClassVisitor = new ClasstoNeo(graph);
      innerClassVisitor.visit(innerClass);
   }

   @Override
   public void done() {
      final Node classNode = nodes.pop();
      if (nodes.empty() || !BaseDomainVisitor.hasLabel(nodes.peek(), JavaDomain.Entities.Class)) return;
      nodes.peek().createRelationshipTo(classNode, JavaDomain.Relations.INNERCLASS);
   }

   private Node newNode(String label) {
      Node node = graph.createNode(Label.label(label));
      node.setProperty("_uuid", UUID.randomUUID().toString());
      return node;
   }

   private void newField(String name, Class<?> returnType, String scope) {
      final Node node = newNode(JavaDomain.Entities.Field.name());
      node.setProperty("name", name);
      node.setProperty("type", returnType.getName());
      node.setProperty("scope", scope);
      nodes.peek().createRelationshipTo(node, JavaDomain.Relations.FIELD);
   }

   private void newConstructor(String name, String scope) {
      final Node node = newNode(JavaDomain.Entities.Constructor.name());
      node.setProperty("name", name);
      node.setProperty("scope", scope);
      nodes.peek().createRelationshipTo(node, JavaDomain.Relations.CONSTRUCTOR);
      nodes.push(node);
   }
}