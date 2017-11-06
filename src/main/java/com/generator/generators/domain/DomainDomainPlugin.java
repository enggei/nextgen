package com.generator.generators.domain;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.app.DomainMotif.*;
import static com.generator.generators.domain.DomainDomainPlugin.Entities.Domain;
import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain DomainDomainPlugin
 */
public abstract class DomainDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Domain, Entity, Relation, Property, Value, Visitor, Instance
   }

   public enum Relations implements RelationshipType {
      DOMAIN, ENTITY, SRC, DST, PROPERTY, VALUE, VISITOR, INSTANCE
   }

   public enum Properties {
      name, visitorClass, relationCardinality, packageName
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   DomainDomainPlugin(App app) {
      super(app, "Domain");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "Domain");
		entitiesNodeMap.put(Entities.Domain, newDomainEntity(getGraph(), Entities.Domain, domainNode));
		entitiesNodeMap.put(Entities.Entity, newDomainEntity(getGraph(), Entities.Entity, domainNode));
		entitiesNodeMap.put(Entities.Relation, newDomainEntity(getGraph(), Entities.Relation, domainNode));
		entitiesNodeMap.put(Entities.Property, newDomainEntity(getGraph(), Entities.Property, domainNode));
		entitiesNodeMap.put(Entities.Value, newDomainEntity(getGraph(), Entities.Value, domainNode));
		entitiesNodeMap.put(Entities.Visitor, newDomainEntity(getGraph(), Entities.Visitor, domainNode));
		entitiesNodeMap.put(Entities.Instance, newDomainEntity(getGraph(), Entities.Instance, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Domain), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Domain), Properties.packageName.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Entity), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Relation), Properties.relationCardinality.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Property), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Visitor), Properties.visitorClass.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Domain), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Domain), Relations.ENTITY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Entity));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Entity), Relations.SRC.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Relation));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Entity), Relations.PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Property));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Entity), Relations.VISITOR.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Visitor));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Entity), Relations.INSTANCE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Instance));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Relation), Relations.DST.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Entity));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Relation), Relations.PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Property));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Property), Relations.VALUE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Value));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Property), Relations.VALUE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Value));
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

	protected void handleDomain(JPopupMenu pop, NeoNode domainNode, Set<NeoNode> selectedNodes) { }
	protected void handleEntity(JPopupMenu pop, NeoNode entityNode, Set<NeoNode> selectedNodes) { }
	protected void handleRelation(JPopupMenu pop, NeoNode relationNode, Set<NeoNode> selectedNodes) { }
	protected void handleProperty(JPopupMenu pop, NeoNode propertyNode, Set<NeoNode> selectedNodes) { }
	protected void handleValue(JPopupMenu pop, NeoNode valueNode, Set<NeoNode> selectedNodes) { }
	protected void handleVisitor(JPopupMenu pop, NeoNode visitorNode, Set<NeoNode> selectedNodes) { }
	protected void handleInstance(JPopupMenu pop, NeoNode instanceNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDomainEditor(NeoNode domainNode) { return null; }
	protected JComponent newEntityEditor(NeoNode entityNode) { return null; }
	protected JComponent newRelationEditor(NeoNode relationNode) { return null; }
	protected JComponent newPropertyEditor(NeoNode propertyNode) { return null; }
	protected JComponent newValueEditor(NeoNode valueNode) { return null; }
	protected JComponent newVisitorEditor(NeoNode visitorNode) { return null; }
	protected JComponent newInstanceEditor(NeoNode instanceNode) { return null; }

	public static boolean isDomain(Node node) { return hasLabel(node, Entities.Domain); }
	public static boolean isEntity(Node node) { return hasLabel(node, Entities.Entity); }
	public static boolean isRelation(Node node) { return hasLabel(node, Entities.Relation); }
	public static boolean isProperty(Node node) { return hasLabel(node, Entities.Property); }
	public static boolean isValue(Node node) { return hasLabel(node, Entities.Value); }
	public static boolean isVisitor(Node node) { return hasLabel(node, Entities.Visitor); }
	public static boolean isInstance(Node node) { return hasLabel(node, Entities.Instance); }

	protected Node newDomain() { return newDomain(getGraph()); } 
	public static Node newDomain(NeoModel graph) { return newInstanceNode(graph, Entities.Domain.name(), entitiesNodeMap.get(Entities.Domain)); } 
	protected Node newDomain(Object name, Object packageName) { return newDomain(getGraph(), name, packageName); } 
	public static Node newDomain(NeoModel graph, Object name, Object packageName) {  	
		final Node newNode = newDomain(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (packageName != null) relate(newNode, newValueNode(graph, packageName), RelationshipType.withName(Properties.packageName.name())); 	
		return newNode; 
	}

	protected Node newEntity() { return newEntity(getGraph()); } 
	public static Node newEntity(NeoModel graph) { return newInstanceNode(graph, Entities.Entity.name(), entitiesNodeMap.get(Entities.Entity)); } 
	protected Node newEntity(Object name) { return newEntity(getGraph(), name); } 
	public static Node newEntity(NeoModel graph, Object name) {  	
		final Node newNode = newEntity(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newRelation() { return newRelation(getGraph()); } 
	public static Node newRelation(NeoModel graph) { return newInstanceNode(graph, Entities.Relation.name(), entitiesNodeMap.get(Entities.Relation)); } 
	protected Node newRelation(Object relationCardinality) { return newRelation(getGraph(), relationCardinality); } 
	public static Node newRelation(NeoModel graph, Object relationCardinality) {  	
		final Node newNode = newRelation(graph); 	
		if (relationCardinality != null) relate(newNode, newValueNode(graph, relationCardinality), RelationshipType.withName(Properties.relationCardinality.name())); 	
		return newNode; 
	}

	protected Node newProperty() { return newProperty(getGraph()); } 
	public static Node newProperty(NeoModel graph) { return newInstanceNode(graph, Entities.Property.name(), entitiesNodeMap.get(Entities.Property)); } 
	protected Node newProperty(Object name) { return newProperty(getGraph(), name); } 
	public static Node newProperty(NeoModel graph, Object name) {  	
		final Node newNode = newProperty(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newValue() { return newValue(getGraph()); } 
	public static Node newValue(NeoModel graph) { return newInstanceNode(graph, Entities.Value.name(), entitiesNodeMap.get(Entities.Value)); }

	protected Node newVisitor() { return newVisitor(getGraph()); } 
	public static Node newVisitor(NeoModel graph) { return newInstanceNode(graph, Entities.Visitor.name(), entitiesNodeMap.get(Entities.Visitor)); } 
	protected Node newVisitor(Object visitorClass) { return newVisitor(getGraph(), visitorClass); } 
	public static Node newVisitor(NeoModel graph, Object visitorClass) {  	
		final Node newNode = newVisitor(graph); 	
		if (visitorClass != null) relate(newNode, newValueNode(graph, visitorClass), RelationshipType.withName(Properties.visitorClass.name())); 	
		return newNode; 
	}

	protected Node newInstance() { return newInstance(getGraph()); } 
	public static Node newInstance(NeoModel graph) { return newInstanceNode(graph, Entities.Instance.name(), entitiesNodeMap.get(Entities.Instance)); }


	public static void outgoingDOMAIN(Node src, RelationConsumer consumer) { outgoing(src, Relations.DOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDOMAIN(Node src) { return other(src, singleOutgoing(src, Relations.DOMAIN)); }
	public static void incomingDOMAIN(Node src, RelationConsumer consumer) { incoming(src, Relations.DOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDOMAIN(Node src) { return other(src, singleIncoming(src, Relations.DOMAIN)); }

	public static void outgoingENTITY(Node src, RelationConsumer consumer) { outgoing(src, Relations.ENTITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingENTITY(Node src) { return other(src, singleOutgoing(src, Relations.ENTITY)); }
	public static void incomingENTITY(Node src, RelationConsumer consumer) { incoming(src, Relations.ENTITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingENTITY(Node src) { return other(src, singleIncoming(src, Relations.ENTITY)); }

	public static void outgoingSRC(Node src, RelationConsumer consumer) { outgoing(src, Relations.SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSRC(Node src) { return other(src, singleOutgoing(src, Relations.SRC)); }
	public static void incomingSRC(Node src, RelationConsumer consumer) { incoming(src, Relations.SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSRC(Node src) { return other(src, singleIncoming(src, Relations.SRC)); }

	public static void outgoingDST(Node src, RelationConsumer consumer) { outgoing(src, Relations.DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDST(Node src) { return other(src, singleOutgoing(src, Relations.DST)); }
	public static void incomingDST(Node src, RelationConsumer consumer) { incoming(src, Relations.DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDST(Node src) { return other(src, singleIncoming(src, Relations.DST)); }

	public static void outgoingPROPERTY(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROPERTY(Node src) { return other(src, singleOutgoing(src, Relations.PROPERTY)); }
	public static void incomingPROPERTY(Node src, RelationConsumer consumer) { incoming(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROPERTY(Node src) { return other(src, singleIncoming(src, Relations.PROPERTY)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }

	public static void outgoingVISITOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVISITOR(Node src) { return other(src, singleOutgoing(src, Relations.VISITOR)); }
	public static void incomingVISITOR(Node src, RelationConsumer consumer) { incoming(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVISITOR(Node src) { return other(src, singleIncoming(src, Relations.VISITOR)); }

	public static void outgoingINSTANCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINSTANCE(Node src) { return other(src, singleOutgoing(src, Relations.INSTANCE)); }
	public static void incomingINSTANCE(Node src, RelationConsumer consumer) { incoming(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINSTANCE(Node src) { return other(src, singleIncoming(src, Relations.INSTANCE)); }


	public static Relationship relateDOMAIN(Node src, Node dst) { return relate(src, dst, Relations.DOMAIN); }
	public static Relationship relateENTITY(Node src, Node dst) { return relate(src, dst, Relations.ENTITY); }
	public static Relationship relateSRC(Node src, Node dst) { return relate(src, dst, Relations.SRC); }
	public static Relationship relateDST(Node src, Node dst) { return relate(src, dst, Relations.DST); }
	public static Relationship relatePROPERTY(Node src, Node dst) { return relate(src, dst, Relations.PROPERTY); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relateVISITOR(Node src, Node dst) { return relate(src, dst, Relations.VISITOR); }
	public static Relationship relateINSTANCE(Node src, Node dst) { return relate(src, dst, Relations.INSTANCE); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	// visitorClass
	public static <T> T getVisitorClassProperty(PropertyContainer container) { return getEntityProperty(container, Properties.visitorClass.name()); }
	public static <T> T getVisitorClassProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.visitorClass.name(), defaultValue); }
	public static boolean hasVisitorClassProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.visitorClass.name()); }
	public static <T extends PropertyContainer> T setVisitorClassProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.visitorClass.name(), value); return container; }
	protected <T extends PropertyContainer> T setVisitorClassProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.visitorClass.name(), value); return container; }
	public static <T extends PropertyContainer> T removeVisitorClassProperty(T container) { removeEntityProperty(container, Properties.visitorClass.name()); return container; }

	// relationCardinality
	public static <T> T getRelationCardinalityProperty(PropertyContainer container) { return getEntityProperty(container, Properties.relationCardinality.name()); }
	public static <T> T getRelationCardinalityProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.relationCardinality.name(), defaultValue); }
	public static boolean hasRelationCardinalityProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.relationCardinality.name()); }
	public static <T extends PropertyContainer> T setRelationCardinalityProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.relationCardinality.name(), value); return container; }
	protected <T extends PropertyContainer> T setRelationCardinalityProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.relationCardinality.name(), value); return container; }
	public static <T extends PropertyContainer> T removeRelationCardinalityProperty(T container) { removeEntityProperty(container, Properties.relationCardinality.name()); return container; }

	// packageName
	public static <T> T getPackageNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.packageName.name()); }
	public static <T> T getPackageNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.packageName.name(), defaultValue); }
	public static boolean hasPackageNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.packageName.name(), value); return container; }
	protected <T extends PropertyContainer> T setPackageNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.packageName.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackageNameProperty(T container) { removeEntityProperty(container, Properties.packageName.name()); return container; }

}