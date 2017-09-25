package com.generator.generators.domain;

import com.generator.app.App;
import com.generator.util.NeoUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import static com.generator.util.NeoUtil.*;

/**
 * Created 20.09.17.
 */
public abstract class DomainVisitor<T> {

   private final Set<Relationship> visitedRelations = new LinkedHashSet<>();

   protected final Stack<Node> nodeStack = new Stack<>();
   protected final StringBuilder delim = new StringBuilder("");
   protected final boolean debug;

   protected final Node visitorNode;
   protected final App app;

   public DomainVisitor(boolean debug, Node visitorNode, App app) {
      this.debug = debug;
      this.visitorNode = visitorNode;
      this.app = app;
   }

   public T getResult() {
      return null;
   }

   public void visit(Node node) {
      if (node == null) return;
      if (NeoUtil.hasLabel(node, DomainPlugin.Entities.Domain.name())) visitDomain(node);
      if (NeoUtil.hasLabel(node, DomainPlugin.Entities.Entity.name())) visitEntity(node);
      if (NeoUtil.hasLabel(node, DomainPlugin.Entities.Relation.name())) visitRelation(node);
      if (NeoUtil.hasLabel(node, DomainPlugin.Entities.Property.name())) visitProperty(node);
   }

   public void visitDomain(Node node) {
      delim.append("\t");
      if (debug) System.out.println(delim.toString() + getNameAndLabelsFrom(node));
      visitOutgoing(node, DomainPlugin.Relations.ENTITY);
      delim.deleteCharAt(delim.length() - 1);
   }

   public void visitEntity(Node node) {
      delim.append("\t");
      if (debug) System.out.println(delim.toString() + getNameAndLabelsFrom(node));
      visitOutgoing(node, DomainPlugin.Relations.SRC);
      delim.deleteCharAt(delim.length() - 1);
   }

   public void visitRelation(Node node) {
      delim.append("\t");
      if (debug) System.out.println(delim.toString() + getNameAndLabelsFrom(node));
      visitOutgoing(node, DomainPlugin.Relations.DST);
      delim.deleteCharAt(delim.length() - 1);
   }

   public void visitProperty(Node node) {
      delim.append("\t");
      if (debug) System.out.println(delim.toString() + getNameAndLabelsFrom(node));
      delim.deleteCharAt(delim.length() - 1);
   }

   private void visitOutgoing(Node node, DomainPlugin.Relations relation) {
      outgoing(node, relation).forEach(relationship -> {
         if (visitedRelations.contains(relationship)) return;
         visitedRelations.add(relationship);
         visit(other(node, relationship));
      });
   }
}
