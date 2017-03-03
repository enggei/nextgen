package com.generator.generators.java;

import com.generator.editors.BaseDomainVisitor;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.BaseDomainVisitor.other;

/**
 * Created 02.03.17.
 */
public interface JavaVisitor {

   static void visitClass(Node classNode, JavaVisitor... visitors) {

      for (JavaVisitor visitor : visitors) visitor.onClass(getString(classNode, "name"), classNode);

      for (Relationship relationship : outgoing(classNode, JavaDomain.Relations.FIELD)) {
         final Node fieldNode = other(classNode, relationship);
         for (JavaVisitor visitor : visitors)
            visitor.onField(getString(fieldNode, "scope"), getString(fieldNode, "type"), getString(fieldNode, "name"), getString(fieldNode, "value"), fieldNode);
      }

      for (Relationship relationship : outgoing(classNode, JavaDomain.Relations.METHOD)) {
         final Node fieldNode = other(classNode, relationship);
         for (JavaVisitor visitor : visitors)
            visitor.onField(getString(fieldNode, "scope"), getString(fieldNode, "type"), getString(fieldNode, "name"), getString(fieldNode, "value"), fieldNode);
      }
   }

   void onClass(String name, Node node);

   void onField(String scope, String type, String name, String value, Node node);

   void onMethod(String scope, String name, String returnValue, Node node);
}