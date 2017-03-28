package com.generator.generators.java;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.BaseDomainVisitor.other;

/**
 * Created 02.03.17.
 */
public interface JavaVisitor {

   static void visitClass(Node classNode, JavaVisitor... visitors) {

      for (JavaVisitor visitor : visitors) visitor.onClass(getString(classNode, JavaDomain.Properties.name.name()), classNode);

      for (Relationship relationship : outgoing(classNode, JavaDomain.Relations.FIELD)) {
         final Node fieldNode = other(classNode, relationship);
         for (JavaVisitor visitor : visitors)
            visitor.onField(getString(fieldNode, JavaDomain.Properties.scope.name()), getString(fieldNode, JavaDomain.Properties.type.name()), getString(fieldNode, JavaDomain.Properties.name.name()), getString(fieldNode, JavaDomain.Properties.value.name()), Boolean.valueOf(get(fieldNode, JavaDomain.Properties.getter.name(), "false")), Boolean.valueOf(get(fieldNode, JavaDomain.Properties.setter.name(), "false")), fieldNode);
      }

      for (Relationship relationship : outgoing(classNode, JavaDomain.Relations.METHOD)) {
         final Node fieldNode = other(classNode, relationship);
         for (JavaVisitor visitor : visitors)
            visitor.onMethod(getString(fieldNode, JavaDomain.Properties.scope.name()), getString(fieldNode, JavaDomain.Properties.type.name()), getString(fieldNode, JavaDomain.Properties.name.name()), fieldNode);
      }
   }

   void onClass(String name, Node node);

   void onField(String scope, String type, String name, String value, Boolean getter, Boolean setter, Node node);
   
   void onMethod(String scope, String name, String returnValue, Node node);
}