package com.generator.generators.domain;

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
public abstract class DomainVisitor<T> implements Visitor<T> {
   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DomainVisitor.class);
   private final Set<Relationship> visitedRelations = new LinkedHashSet<>();

   protected final Stack<Node> nodeStack = new Stack<>();
   protected final StringBuilder delim = new StringBuilder("");
   protected final boolean debug;

   public DomainVisitor(boolean debug) {
      this.debug = debug;
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
      if (NeoUtil.hasLabel(node, DomainPlugin.Entities.Visitor.name())) visitVisitor(node);
   }

   public void visitDomain(Node node) {
      delim.append("\t");
      if (debug) log.info(delim.toString() + getNameAndLabelsFrom(node) + " " + node.getId());
      visitOutgoing(node, DomainPlugin.Relations.ENTITY);
      visitOutgoing(node, DomainPlugin.Relations.VISITOR);
      delim.deleteCharAt(delim.length() - 1);
   }

   public void visitEntity(Node node) {
      delim.append("\t");
      if (debug) log.info(delim.toString() + getNameAndLabelsFrom(node) + " " + node.getId());
      visitOutgoing(node, DomainPlugin.Relations.SRC);
      delim.deleteCharAt(delim.length() - 1);
   }

   public void visitVisitor(Node node) {
      delim.append("\t");
      if (debug) log.info(delim.toString() + getNameAndLabelsFrom(node) + " " + node.getId());
      visitOutgoing(node, DomainPlugin.Relations.SRC);
      delim.deleteCharAt(delim.length() - 1);
   }

   public void visitRelation(Node node) {
      delim.append("\t");
      if (debug) log.info(delim.toString() + getNameAndLabelsFrom(node) + " " + node.getId());
      visitOutgoing(node, DomainPlugin.Relations.SRC);   // properties for relation
      visitOutgoing(node, DomainPlugin.Relations.DST);   // targets for relation
      delim.deleteCharAt(delim.length() - 1);
   }

   public void visitProperty(Node node) {
      delim.append("\t");
      if (debug) log.info(delim.toString() + getNameAndLabelsFrom(node) + " " + node.getId());
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
