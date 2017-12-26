package com.generator.generators.domain;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain DomainDomainPlugin
 */
public abstract class DomainDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DomainDomainPlugin.class);

	public enum Entities implements Label {
      Domain, Visitor, Entity, Relation, Instance, Property, Enumeration, Value
   }

   public enum Relations implements RelationshipType {
      DOMAIN, NAME, VISITOR, VISITORCLASS, ENTITY, SRC, DST, INSTANCE, RELATIONCARDINALITY, PROPERTY, ENUMERATED, VALUE, PACKAGENAME
   }

   public enum Properties {
      name, visitorClass, relationCardinality, value, packageName
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   DomainDomainPlugin(App app) {
      super(app, "Domain");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Domain");
		entitiesNodeMap.put(Entities.Domain, DomainMotif.newDomainEntity(getGraph(), Entities.Domain, domainNode));
		entitiesNodeMap.put(Entities.Visitor, DomainMotif.newDomainEntity(getGraph(), Entities.Visitor, domainNode));
		entitiesNodeMap.put(Entities.Entity, DomainMotif.newDomainEntity(getGraph(), Entities.Entity, domainNode));
		entitiesNodeMap.put(Entities.Relation, DomainMotif.newDomainEntity(getGraph(), Entities.Relation, domainNode));
		entitiesNodeMap.put(Entities.Instance, DomainMotif.newDomainEntity(getGraph(), Entities.Instance, domainNode));
		entitiesNodeMap.put(Entities.Property, DomainMotif.newDomainEntity(getGraph(), Entities.Property, domainNode));
		entitiesNodeMap.put(Entities.Enumeration, DomainMotif.newDomainEntity(getGraph(), Entities.Enumeration, domainNode));
		entitiesNodeMap.put(Entities.Value, DomainMotif.newDomainEntity(getGraph(), Entities.Value, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Domain), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Domain), Properties.packageName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Visitor), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Visitor), Properties.visitorClass.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Entity), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Relation), Properties.relationCardinality.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Property), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Enumeration), Properties.value.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Domain), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Domain), Relations.VISITOR.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Visitor));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Domain), Relations.ENTITY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Entity));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Entity), Relations.SRC.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Relation));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Entity), Relations.INSTANCE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Instance));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Relation), Relations.DST.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Entity));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Relation), Relations.PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Property));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Property), Relations.ENUMERATED.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Enumeration));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Property), Relations.VALUE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Value));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isDomain(neoNode.getNode())) handleDomain(pop, neoNode, selectedNodes);
		if (isVisitor(neoNode.getNode())) handleVisitor(pop, neoNode, selectedNodes);
		if (isEntity(neoNode.getNode())) handleEntity(pop, neoNode, selectedNodes);
		if (isRelation(neoNode.getNode())) handleRelation(pop, neoNode, selectedNodes);
		if (isInstance(neoNode.getNode())) handleInstance(pop, neoNode, selectedNodes);
		if (isProperty(neoNode.getNode())) handleProperty(pop, neoNode, selectedNodes);
		if (isEnumeration(neoNode.getNode())) handleEnumeration(pop, neoNode, selectedNodes);
		if (isValue(neoNode.getNode())) handleValue(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isDomain(neoNode.getNode())) return newDomainEditor(neoNode);
		if (isVisitor(neoNode.getNode())) return newVisitorEditor(neoNode);
		if (isEntity(neoNode.getNode())) return newEntityEditor(neoNode);
		if (isRelation(neoNode.getNode())) return newRelationEditor(neoNode);
		if (isInstance(neoNode.getNode())) return newInstanceEditor(neoNode);
		if (isProperty(neoNode.getNode())) return newPropertyEditor(neoNode);
		if (isEnumeration(neoNode.getNode())) return newEnumerationEditor(neoNode);
		if (isValue(neoNode.getNode())) return newValueEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleDomain(JPopupMenu pop, NeoNode domainNode, Set<NeoNode> selectedNodes) { }
	protected void handleVisitor(JPopupMenu pop, NeoNode visitorNode, Set<NeoNode> selectedNodes) { }
	protected void handleEntity(JPopupMenu pop, NeoNode entityNode, Set<NeoNode> selectedNodes) { }
	protected void handleRelation(JPopupMenu pop, NeoNode relationNode, Set<NeoNode> selectedNodes) { }
	protected void handleInstance(JPopupMenu pop, NeoNode instanceNode, Set<NeoNode> selectedNodes) { }
	protected void handleProperty(JPopupMenu pop, NeoNode propertyNode, Set<NeoNode> selectedNodes) { }
	protected void handleEnumeration(JPopupMenu pop, NeoNode enumerationNode, Set<NeoNode> selectedNodes) { }
	protected void handleValue(JPopupMenu pop, NeoNode valueNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDomainEditor(NeoNode domainNode) { return null; }
	protected JComponent newVisitorEditor(NeoNode visitorNode) { return null; }
	protected JComponent newEntityEditor(NeoNode entityNode) { return null; }
	protected JComponent newRelationEditor(NeoNode relationNode) { return null; }
	protected JComponent newInstanceEditor(NeoNode instanceNode) { return null; }
	protected JComponent newPropertyEditor(NeoNode propertyNode) { return null; }
	protected JComponent newEnumerationEditor(NeoNode enumerationNode) { return null; }
	protected JComponent newValueEditor(NeoNode valueNode) { return null; }

	public static boolean isDomain(Node node) { return hasLabel(node, Entities.Domain); }
	public static boolean isVisitor(Node node) { return hasLabel(node, Entities.Visitor); }
	public static boolean isEntity(Node node) { return hasLabel(node, Entities.Entity); }
	public static boolean isRelation(Node node) { return hasLabel(node, Entities.Relation); }
	public static boolean isInstance(Node node) { return hasLabel(node, Entities.Instance); }
	public static boolean isProperty(Node node) { return hasLabel(node, Entities.Property); }
	public static boolean isEnumeration(Node node) { return hasLabel(node, Entities.Enumeration); }
	public static boolean isValue(Node node) { return hasLabel(node, Entities.Value); }

	protected Node newDomain() { return newDomain(getGraph()); } 
	protected Node newDomain(Object name, Object packageName) { return newDomain(getGraph(), name, packageName); } 

	public static Node newDomain(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Domain)); } 
	public static Node newDomain(NeoModel graph, Object name, Object packageName) {  	
		final Node newNode = newDomain(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (packageName != null) relate(newNode, DomainMotif.newValueNode(graph, packageName), RelationshipType.withName(Properties.packageName.name())); 	
		return newNode; 
	}

	protected Node newVisitor() { return newVisitor(getGraph()); } 
	protected Node newVisitor(Object name, Object visitorClass) { return newVisitor(getGraph(), name, visitorClass); } 

	public static Node newVisitor(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Visitor)); } 
	public static Node newVisitor(NeoModel graph, Object name, Object visitorClass) {  	
		final Node newNode = newVisitor(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (visitorClass != null) relate(newNode, DomainMotif.newValueNode(graph, visitorClass), RelationshipType.withName(Properties.visitorClass.name())); 	
		return newNode; 
	}

	protected Node newEntity() { return newEntity(getGraph()); } 
	protected Node newEntity(Object name) { return newEntity(getGraph(), name); } 

	public static Node newEntity(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Entity)); } 
	public static Node newEntity(NeoModel graph, Object name) {  	
		final Node newNode = newEntity(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newRelation() { return newRelation(getGraph()); } 
	protected Node newRelation(Object relationCardinality) { return newRelation(getGraph(), relationCardinality); } 

	public static Node newRelation(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Relation)); } 
	public static Node newRelation(NeoModel graph, Object relationCardinality) {  	
		final Node newNode = newRelation(graph); 	
		if (relationCardinality != null) relate(newNode, DomainMotif.newValueNode(graph, relationCardinality), RelationshipType.withName(Properties.relationCardinality.name())); 	
		return newNode; 
	}

	protected Node newInstance() { return newInstance(getGraph()); }
	public static Node newInstance(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Instance)); }

	protected Node newProperty() { return newProperty(getGraph()); } 
	protected Node newProperty(Object name) { return newProperty(getGraph(), name); } 

	public static Node newProperty(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Property)); } 
	public static Node newProperty(NeoModel graph, Object name) {  	
		final Node newNode = newProperty(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newEnumeration() { return newEnumeration(getGraph()); } 
	protected Node newEnumeration(Object value) { return newEnumeration(getGraph(), value); } 

	public static Node newEnumeration(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Enumeration)); } 
	public static Node newEnumeration(NeoModel graph, Object value) {  	
		final Node newNode = newEnumeration(graph); 	
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}

	protected Node newValue() { return newValue(getGraph()); }
	public static Node newValue(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Value)); }


	public static void outgoingDOMAIN(Node src, RelationConsumer consumer) { outgoing(src, Relations.DOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDOMAIN(Node src) { return other(src, singleOutgoing(src, Relations.DOMAIN)); }
	public static void incomingDOMAIN(Node src, RelationConsumer consumer) { incoming(src, Relations.DOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDOMAIN(Node src) { return other(src, singleIncoming(src, Relations.DOMAIN)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingVISITOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVISITOR(Node src) { return other(src, singleOutgoing(src, Relations.VISITOR)); }
	public static void incomingVISITOR(Node src, RelationConsumer consumer) { incoming(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVISITOR(Node src) { return other(src, singleIncoming(src, Relations.VISITOR)); }

	public static void outgoingVISITORCLASS(Node src, RelationConsumer consumer) { outgoing(src, Relations.VISITORCLASS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVISITORCLASS(Node src) { return other(src, singleOutgoing(src, Relations.VISITORCLASS)); }
	public static void incomingVISITORCLASS(Node src, RelationConsumer consumer) { incoming(src, Relations.VISITORCLASS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVISITORCLASS(Node src) { return other(src, singleIncoming(src, Relations.VISITORCLASS)); }

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

	public static void outgoingINSTANCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINSTANCE(Node src) { return other(src, singleOutgoing(src, Relations.INSTANCE)); }
	public static void incomingINSTANCE(Node src, RelationConsumer consumer) { incoming(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINSTANCE(Node src) { return other(src, singleIncoming(src, Relations.INSTANCE)); }

	public static void outgoingRELATIONCARDINALITY(Node src, RelationConsumer consumer) { outgoing(src, Relations.RELATIONCARDINALITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRELATIONCARDINALITY(Node src) { return other(src, singleOutgoing(src, Relations.RELATIONCARDINALITY)); }
	public static void incomingRELATIONCARDINALITY(Node src, RelationConsumer consumer) { incoming(src, Relations.RELATIONCARDINALITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRELATIONCARDINALITY(Node src) { return other(src, singleIncoming(src, Relations.RELATIONCARDINALITY)); }

	public static void outgoingPROPERTY(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROPERTY(Node src) { return other(src, singleOutgoing(src, Relations.PROPERTY)); }
	public static void incomingPROPERTY(Node src, RelationConsumer consumer) { incoming(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROPERTY(Node src) { return other(src, singleIncoming(src, Relations.PROPERTY)); }

	public static void outgoingENUMERATED(Node src, RelationConsumer consumer) { outgoing(src, Relations.ENUMERATED).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingENUMERATED(Node src) { return other(src, singleOutgoing(src, Relations.ENUMERATED)); }
	public static void incomingENUMERATED(Node src, RelationConsumer consumer) { incoming(src, Relations.ENUMERATED).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingENUMERATED(Node src) { return other(src, singleIncoming(src, Relations.ENUMERATED)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }

	public static void outgoingPACKAGENAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPACKAGENAME(Node src) { return other(src, singleOutgoing(src, Relations.PACKAGENAME)); }
	public static void incomingPACKAGENAME(Node src, RelationConsumer consumer) { incoming(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPACKAGENAME(Node src) { return other(src, singleIncoming(src, Relations.PACKAGENAME)); }


	public static Relationship relateDOMAIN(Node src, Node dst) { return relate(src, dst, Relations.DOMAIN); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateVISITOR(Node src, Node dst) { return relate(src, dst, Relations.VISITOR); }
	public static Relationship relateVISITORCLASS(Node src, Node dst) { return relate(src, dst, Relations.VISITORCLASS); }
	public static Relationship relateENTITY(Node src, Node dst) { return relate(src, dst, Relations.ENTITY); }
	public static Relationship relateSRC(Node src, Node dst) { return relate(src, dst, Relations.SRC); }
	public static Relationship relateDST(Node src, Node dst) { return relate(src, dst, Relations.DST); }
	public static Relationship relateINSTANCE(Node src, Node dst) { return relate(src, dst, Relations.INSTANCE); }
	public static Relationship relateRELATIONCARDINALITY(Node src, Node dst) { return relate(src, dst, Relations.RELATIONCARDINALITY); }
	public static Relationship relatePROPERTY(Node src, Node dst) { return relate(src, dst, Relations.PROPERTY); }
	public static Relationship relateENUMERATED(Node src, Node dst) { return relate(src, dst, Relations.ENUMERATED); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relatePACKAGENAME(Node src, Node dst) { return relate(src, dst, Relations.PACKAGENAME); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// visitorClass
	public static <T> T getVisitorClassProperty(PropertyContainer container) { return getVisitorClassProperty(container, null); }
	public static <T> T getVisitorClassProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.visitorClass.name(), defaultValue); }
	public static boolean hasVisitorClassProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.visitorClass.name()); }
	public static <T extends PropertyContainer> T setVisitorClassProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.visitorClass.name(), value); return container; }
	public static <T extends PropertyContainer> T removeVisitorClassProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.visitorClass.name()); return container; }

	protected <T extends PropertyContainer> T setVisitorClassProperty(T container, Object value) { setVisitorClassProperty(getGraph(), container, value); return container; }

	// relationCardinality
	public static <T> T getRelationCardinalityProperty(PropertyContainer container) { return getRelationCardinalityProperty(container, null); }
	public static <T> T getRelationCardinalityProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.relationCardinality.name(), defaultValue); }
	public static boolean hasRelationCardinalityProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.relationCardinality.name()); }
	public static <T extends PropertyContainer> T setRelationCardinalityProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.relationCardinality.name(), value); return container; }
	public static <T extends PropertyContainer> T removeRelationCardinalityProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.relationCardinality.name()); return container; }

	protected <T extends PropertyContainer> T setRelationCardinalityProperty(T container, Object value) { setRelationCardinalityProperty(getGraph(), container, value); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getValueProperty(container, null); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.value.name()); return container; }

	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setValueProperty(getGraph(), container, value); return container; }

	// packageName
	public static <T> T getPackageNameProperty(PropertyContainer container) { return getPackageNameProperty(container, null); }
	public static <T> T getPackageNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.packageName.name(), defaultValue); }
	public static boolean hasPackageNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.packageName.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackageNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.packageName.name()); return container; }

	protected <T extends PropertyContainer> T setPackageNameProperty(T container, Object value) { setPackageNameProperty(getGraph(), container, value); return container; }

}