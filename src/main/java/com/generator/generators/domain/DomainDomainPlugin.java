package com.generator.generators.domain;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.app.DomainMotif;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain DomainDomainPlugin
 */
abstract class DomainDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Domain, Entity, Relation, Property, Value, Visitor, Instance
   }

   public enum Relations implements RelationshipType {
      ENTITY, SRC, DST, PROPERTY, VALUE, VISITOR, INSTANCE
   }

   public enum Properties {
      visitorClass, relationCardinality, packageName
   }

   DomainDomainPlugin(App app) {
      super(app, "Domain");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isDomain(neoNode.getNode())) handleDomain(pop, neoNode, selectedNodes);
		if (isEntity(neoNode.getNode())) handleEntity(pop, neoNode, selectedNodes);
		if (isRelation(neoNode.getNode())) handleRelation(pop, neoNode, selectedNodes);
		if (isProperty(neoNode.getNode())) handleProperty(pop, neoNode, selectedNodes);
		if (isValue(neoNode.getNode())) handleValue(pop, neoNode, selectedNodes);
		if (isVisitor(neoNode.getNode())) handleVisitor(pop, neoNode, selectedNodes);
		if (isInstance(neoNode.getNode())) handleInstance(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isDomain(neoNode.getNode())) return newDomainEditor(neoNode);
		if (isEntity(neoNode.getNode())) return newEntityEditor(neoNode);
		if (isRelation(neoNode.getNode())) return newRelationEditor(neoNode);
		if (isProperty(neoNode.getNode())) return newPropertyEditor(neoNode);
		if (isValue(neoNode.getNode())) return newValueEditor(neoNode);
		if (isVisitor(neoNode.getNode())) return newVisitorEditor(neoNode);
		if (isInstance(neoNode.getNode())) return newInstanceEditor(neoNode);
      return null;
   }

	protected void handleDomain(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleEntity(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleRelation(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleProperty(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleValue(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleVisitor(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleInstance(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDomainEditor(NeoNode neoNode) { return null; }
	protected JComponent newEntityEditor(NeoNode neoNode) { return null; }
	protected JComponent newRelationEditor(NeoNode neoNode) { return null; }
	protected JComponent newPropertyEditor(NeoNode neoNode) { return null; }
	protected JComponent newValueEditor(NeoNode neoNode) { return null; }
	protected JComponent newVisitorEditor(NeoNode neoNode) { return null; }
	protected JComponent newInstanceEditor(NeoNode neoNode) { return null; }

	protected Node newDomain(String name) { return newDomain(getGraph(), name); }
	protected Node newDomain() { return newDomain(getGraph()); } 
	protected Node newEntity(String name) { return newEntity(getGraph(), name); }
	protected Node newEntity() { return newEntity(getGraph()); } 
	protected Node newRelation(String name) { return newRelation(getGraph(), name); }
	protected Node newRelation() { return newRelation(getGraph()); } 
	protected Node newProperty(String name) { return newProperty(getGraph(), name); }
	protected Node newProperty() { return newProperty(getGraph()); } 
	protected Node newValue(String name) { return newValue(getGraph(), name); }
	protected Node newValue() { return newValue(getGraph()); } 
	protected Node newVisitor(String name) { return newVisitor(getGraph(), name); }
	protected Node newVisitor() { return newVisitor(getGraph()); } 
	protected Node newInstance(String name) { return newInstance(getGraph(), name); }
	protected Node newInstance() { return newInstance(getGraph()); } 

	public static boolean isDomain(Node node) { return hasLabel(node, Entities.Domain); }
	public static boolean isEntity(Node node) { return hasLabel(node, Entities.Entity); }
	public static boolean isRelation(Node node) { return hasLabel(node, Entities.Relation); }
	public static boolean isProperty(Node node) { return hasLabel(node, Entities.Property); }
	public static boolean isValue(Node node) { return hasLabel(node, Entities.Value); }
	public static boolean isVisitor(Node node) { return hasLabel(node, Entities.Visitor); }
	public static boolean isInstance(Node node) { return hasLabel(node, Entities.Instance); }

	public static Node newDomain(NeoModel graph, String name) { return graph.newNode(Entities.Domain, AppMotif.Properties.name.name(), name); }
	public static Node newDomain(NeoModel graph) { return graph.newNode(Entities.Domain); }
	public static Node newEntity(NeoModel graph, String name) { return graph.newNode(Entities.Entity, AppMotif.Properties.name.name(), name); }
	public static Node newEntity(NeoModel graph) { return graph.newNode(Entities.Entity); }
	public static Node newRelation(NeoModel graph, String name) { return graph.newNode(Entities.Relation, AppMotif.Properties.name.name(), name); }
	public static Node newRelation(NeoModel graph) { return graph.newNode(Entities.Relation); }
	public static Node newProperty(NeoModel graph, String name) { return graph.newNode(Entities.Property, AppMotif.Properties.name.name(), name); }
	public static Node newProperty(NeoModel graph) { return graph.newNode(Entities.Property); }
	public static Node newValue(NeoModel graph, String name) { return graph.newNode(Entities.Value, AppMotif.Properties.name.name(), name); }
	public static Node newValue(NeoModel graph) { return graph.newNode(Entities.Value); }
	public static Node newVisitor(NeoModel graph, String name) { return graph.newNode(Entities.Visitor, AppMotif.Properties.name.name(), name); }
	public static Node newVisitor(NeoModel graph) { return graph.newNode(Entities.Visitor); }
	public static Node newInstance(NeoModel graph, String name) { return graph.newNode(Entities.Instance, AppMotif.Properties.name.name(), name); }
	public static Node newInstance(NeoModel graph) { return graph.newNode(Entities.Instance); }

	public static void outgoingENTITY(Node src, RelationConsumer consumer) { outgoing(src, Relations.ENTITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingENTITY(Node src, RelationConsumer consumer) { incoming(src, Relations.ENTITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingSRC(Node src, RelationConsumer consumer) { outgoing(src, Relations.SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingSRC(Node src, RelationConsumer consumer) { incoming(src, Relations.SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingDST(Node src, RelationConsumer consumer) { outgoing(src, Relations.DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingDST(Node src, RelationConsumer consumer) { incoming(src, Relations.DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingPROPERTY(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingPROPERTY(Node src, RelationConsumer consumer) { incoming(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingVISITOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingVISITOR(Node src, RelationConsumer consumer) { incoming(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingINSTANCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingINSTANCE(Node src, RelationConsumer consumer) { incoming(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }

	public static Relationship relateENTITY(Node src, Node dst) { return relate(src, dst, Relations.ENTITY); }
	public static Relationship relateSRC(Node src, Node dst) { return relate(src, dst, Relations.SRC); }
	public static Relationship relateDST(Node src, Node dst) { return relate(src, dst, Relations.DST); }
	public static Relationship relatePROPERTY(Node src, Node dst) { return relate(src, dst, Relations.PROPERTY); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relateVISITOR(Node src, Node dst) { return relate(src, dst, Relations.VISITOR); }
	public static Relationship relateINSTANCE(Node src, Node dst) { return relate(src, dst, Relations.INSTANCE); }

	public static String getName(Node node) { return DomainMotif.getName(node); }
	public static String getName(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setName(Node node, String name) { DomainMotif.setName(node, name); }
	public static void setName(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	public static <T> T getVisitorClass(PropertyContainer container) { return get(container, Properties.visitorClass.name()); }
	public static <T> T getVisitorClass(PropertyContainer container, T defaultValue) { return has(container, Properties.visitorClass.name()) ? get(container, Properties.visitorClass.name()) : defaultValue; }
	public static boolean hasVisitorClass(PropertyContainer container) { return has(container, Properties.visitorClass.name()); }
	public static <T extends PropertyContainer> T setVisitorClass(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.visitorClass.name());
	   else
	   	container.setProperty(Properties.visitorClass.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeVisitorClass(T container) {
		if (has(container, Properties.visitorClass.name())) container.removeProperty(Properties.visitorClass.name());
	      return container;
	}

	public static <T> T getRelationCardinality(PropertyContainer container) { return get(container, Properties.relationCardinality.name()); }
	public static <T> T getRelationCardinality(PropertyContainer container, T defaultValue) { return has(container, Properties.relationCardinality.name()) ? get(container, Properties.relationCardinality.name()) : defaultValue; }
	public static boolean hasRelationCardinality(PropertyContainer container) { return has(container, Properties.relationCardinality.name()); }
	public static <T extends PropertyContainer> T setRelationCardinality(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.relationCardinality.name());
	   else
	   	container.setProperty(Properties.relationCardinality.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeRelationCardinality(T container) {
		if (has(container, Properties.relationCardinality.name())) container.removeProperty(Properties.relationCardinality.name());
	      return container;
	}

	public static <T> T getPackageName(PropertyContainer container) { return get(container, Properties.packageName.name()); }
	public static <T> T getPackageName(PropertyContainer container, T defaultValue) { return has(container, Properties.packageName.name()) ? get(container, Properties.packageName.name()) : defaultValue; }
	public static boolean hasPackageName(PropertyContainer container) { return has(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageName(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.packageName.name());
	   else
	   	container.setProperty(Properties.packageName.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removePackageName(T container) {
		if (has(container, Properties.packageName.name())) container.removeProperty(Properties.packageName.name());
	      return container;
	}

}