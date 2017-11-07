package com.generator.generators.easyFlow;

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
 * Auto-generated from domain EasyFlowDomainPlugin
 */
public abstract class EasyFlowDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Flow, State, Event, ContextProperty
   }

   public enum Relations implements RelationshipType {
      FLOW, FROM, ON, TO, FINISH, CONTEXT_PROPERTY
   }

   public enum Properties {
      name, extending, modifier, comment, type, value
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   EasyFlowDomainPlugin(App app) {
      super(app, "EasyFlow");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "EasyFlow");
		entitiesNodeMap.put(Entities.Flow, newDomainEntity(getGraph(), Entities.Flow, domainNode));
		entitiesNodeMap.put(Entities.State, newDomainEntity(getGraph(), Entities.State, domainNode));
		entitiesNodeMap.put(Entities.Event, newDomainEntity(getGraph(), Entities.Event, domainNode));
		entitiesNodeMap.put(Entities.ContextProperty, newDomainEntity(getGraph(), Entities.ContextProperty, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Flow), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Flow), Properties.extending.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.State), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Event), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.modifier.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.comment.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.type.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.value.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Flow), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Flow), Relations.FROM.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.State));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Flow), Relations.CONTEXT_PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.ContextProperty));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.State), Relations.ON.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Event));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Event), Relations.TO.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.State));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Event), Relations.FINISH.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.State));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isFlow(neoNode.getNode())) handleFlow(pop, neoNode, selectedNodes);
		if (isState(neoNode.getNode())) handleState(pop, neoNode, selectedNodes);
		if (isEvent(neoNode.getNode())) handleEvent(pop, neoNode, selectedNodes);
		if (isContextProperty(neoNode.getNode())) handleContextProperty(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isFlow(neoNode.getNode())) return newFlowEditor(neoNode);
		if (isState(neoNode.getNode())) return newStateEditor(neoNode);
		if (isEvent(neoNode.getNode())) return newEventEditor(neoNode);
		if (isContextProperty(neoNode.getNode())) return newContextPropertyEditor(neoNode);
      return null;
   }

	protected void handleFlow(JPopupMenu pop, NeoNode flowNode, Set<NeoNode> selectedNodes) { }
	protected void handleState(JPopupMenu pop, NeoNode stateNode, Set<NeoNode> selectedNodes) { }
	protected void handleEvent(JPopupMenu pop, NeoNode eventNode, Set<NeoNode> selectedNodes) { }
	protected void handleContextProperty(JPopupMenu pop, NeoNode contextPropertyNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newFlowEditor(NeoNode flowNode) { return null; }
	protected JComponent newStateEditor(NeoNode stateNode) { return null; }
	protected JComponent newEventEditor(NeoNode eventNode) { return null; }
	protected JComponent newContextPropertyEditor(NeoNode contextPropertyNode) { return null; }

	public static boolean isFlow(Node node) { return hasLabel(node, Entities.Flow); }
	public static boolean isState(Node node) { return hasLabel(node, Entities.State); }
	public static boolean isEvent(Node node) { return hasLabel(node, Entities.Event); }
	public static boolean isContextProperty(Node node) { return hasLabel(node, Entities.ContextProperty); }

	protected Node newFlow() { return newFlow(getGraph()); } 
	public static Node newFlow(NeoModel graph) { return newInstanceNode(graph, Entities.Flow.name(), entitiesNodeMap.get(Entities.Flow)); } 
	protected Node newFlow(Object name, Object extending) { return newFlow(getGraph(), name, extending); } 
	public static Node newFlow(NeoModel graph, Object name, Object extending) {  	
		final Node newNode = newFlow(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (extending != null) relate(newNode, newValueNode(graph, extending), RelationshipType.withName(Properties.extending.name())); 	
		return newNode; 
	}

	protected Node newState() { return newState(getGraph()); } 
	public static Node newState(NeoModel graph) { return newInstanceNode(graph, Entities.State.name(), entitiesNodeMap.get(Entities.State)); } 
	protected Node newState(Object name) { return newState(getGraph(), name); } 
	public static Node newState(NeoModel graph, Object name) {  	
		final Node newNode = newState(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newEvent() { return newEvent(getGraph()); } 
	public static Node newEvent(NeoModel graph) { return newInstanceNode(graph, Entities.Event.name(), entitiesNodeMap.get(Entities.Event)); } 
	protected Node newEvent(Object name) { return newEvent(getGraph(), name); } 
	public static Node newEvent(NeoModel graph, Object name) {  	
		final Node newNode = newEvent(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newContextProperty() { return newContextProperty(getGraph()); } 
	public static Node newContextProperty(NeoModel graph) { return newInstanceNode(graph, Entities.ContextProperty.name(), entitiesNodeMap.get(Entities.ContextProperty)); } 
	protected Node newContextProperty(Object name, Object modifier, Object comment, Object type, Object value) { return newContextProperty(getGraph(), name, modifier, comment, type, value); } 
	public static Node newContextProperty(NeoModel graph, Object name, Object modifier, Object comment, Object type, Object value) {  	
		final Node newNode = newContextProperty(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (modifier != null) relate(newNode, newValueNode(graph, modifier), RelationshipType.withName(Properties.modifier.name()));
		if (comment != null) relate(newNode, newValueNode(graph, comment), RelationshipType.withName(Properties.comment.name()));
		if (type != null) relate(newNode, newValueNode(graph, type), RelationshipType.withName(Properties.type.name()));
		if (value != null) relate(newNode, newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}


	public static void outgoingFLOW(Node src, RelationConsumer consumer) { outgoing(src, Relations.FLOW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFLOW(Node src) { return other(src, singleOutgoing(src, Relations.FLOW)); }
	public static void incomingFLOW(Node src, RelationConsumer consumer) { incoming(src, Relations.FLOW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFLOW(Node src) { return other(src, singleIncoming(src, Relations.FLOW)); }

	public static void outgoingFROM(Node src, RelationConsumer consumer) { outgoing(src, Relations.FROM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFROM(Node src) { return other(src, singleOutgoing(src, Relations.FROM)); }
	public static void incomingFROM(Node src, RelationConsumer consumer) { incoming(src, Relations.FROM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFROM(Node src) { return other(src, singleIncoming(src, Relations.FROM)); }

	public static void outgoingON(Node src, RelationConsumer consumer) { outgoing(src, Relations.ON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingON(Node src) { return other(src, singleOutgoing(src, Relations.ON)); }
	public static void incomingON(Node src, RelationConsumer consumer) { incoming(src, Relations.ON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingON(Node src) { return other(src, singleIncoming(src, Relations.ON)); }

	public static void outgoingTO(Node src, RelationConsumer consumer) { outgoing(src, Relations.TO).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTO(Node src) { return other(src, singleOutgoing(src, Relations.TO)); }
	public static void incomingTO(Node src, RelationConsumer consumer) { incoming(src, Relations.TO).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTO(Node src) { return other(src, singleIncoming(src, Relations.TO)); }

	public static void outgoingFINISH(Node src, RelationConsumer consumer) { outgoing(src, Relations.FINISH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFINISH(Node src) { return other(src, singleOutgoing(src, Relations.FINISH)); }
	public static void incomingFINISH(Node src, RelationConsumer consumer) { incoming(src, Relations.FINISH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFINISH(Node src) { return other(src, singleIncoming(src, Relations.FINISH)); }

	public static void outgoingCONTEXT_PROPERTY(Node src, RelationConsumer consumer) { outgoing(src, Relations.CONTEXT_PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCONTEXT_PROPERTY(Node src) { return other(src, singleOutgoing(src, Relations.CONTEXT_PROPERTY)); }
	public static void incomingCONTEXT_PROPERTY(Node src, RelationConsumer consumer) { incoming(src, Relations.CONTEXT_PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCONTEXT_PROPERTY(Node src) { return other(src, singleIncoming(src, Relations.CONTEXT_PROPERTY)); }


	public static Relationship relateFLOW(Node src, Node dst) { return relate(src, dst, Relations.FLOW); }
	public static Relationship relateFROM(Node src, Node dst) { return relate(src, dst, Relations.FROM); }
	public static Relationship relateON(Node src, Node dst) { return relate(src, dst, Relations.ON); }
	public static Relationship relateTO(Node src, Node dst) { return relate(src, dst, Relations.TO); }
	public static Relationship relateFINISH(Node src, Node dst) { return relate(src, dst, Relations.FINISH); }
	public static Relationship relateCONTEXT_PROPERTY(Node src, Node dst) { return relate(src, dst, Relations.CONTEXT_PROPERTY); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	// extending
	public static <T> T getExtendingProperty(PropertyContainer container) { return getEntityProperty(container, Properties.extending.name()); }
	public static <T> T getExtendingProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.extending.name(), defaultValue); }
	public static boolean hasExtendingProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.extending.name()); }
	public static <T extends PropertyContainer> T setExtendingProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.extending.name(), value); return container; }
	protected <T extends PropertyContainer> T setExtendingProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.extending.name(), value); return container; }
	public static <T extends PropertyContainer> T removeExtendingProperty(T container) { removeEntityProperty(container, Properties.extending.name()); return container; }

	// modifier
	public static <T> T getModifierProperty(PropertyContainer container) { return getEntityProperty(container, Properties.modifier.name()); }
	public static <T> T getModifierProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.modifier.name(), defaultValue); }
	public static boolean hasModifierProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.modifier.name()); }
	public static <T extends PropertyContainer> T setModifierProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.modifier.name(), value); return container; }
	protected <T extends PropertyContainer> T setModifierProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.modifier.name(), value); return container; }
	public static <T extends PropertyContainer> T removeModifierProperty(T container) { removeEntityProperty(container, Properties.modifier.name()); return container; }

	// comment
	public static <T> T getCommentProperty(PropertyContainer container) { return getEntityProperty(container, Properties.comment.name()); }
	public static <T> T getCommentProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.comment.name(), defaultValue); }
	public static boolean hasCommentProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.comment.name()); }
	public static <T extends PropertyContainer> T setCommentProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.comment.name(), value); return container; }
	protected <T extends PropertyContainer> T setCommentProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.comment.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCommentProperty(T container) { removeEntityProperty(container, Properties.comment.name()); return container; }

	// type
	public static <T> T getTypeProperty(PropertyContainer container) { return getEntityProperty(container, Properties.type.name()); }
	public static <T> T getTypeProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.type.name(), defaultValue); }
	public static boolean hasTypeProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setTypeProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.type.name(), value); return container; }
	protected <T extends PropertyContainer> T setTypeProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.type.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTypeProperty(T container) { removeEntityProperty(container, Properties.type.name()); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getEntityProperty(container, Properties.value.name()); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { removeEntityProperty(container, Properties.value.name()); return container; }

}