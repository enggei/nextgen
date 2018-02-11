package com.generator.generators.easyFlow;

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
 * Auto-generated from domain EasyFlowDomainPlugin
 */
public abstract class EasyFlowDomainPlugin extends Plugin {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EasyFlowDomainPlugin.class);

	public enum Entities implements Label {
      Flow, State, Event, ContextProperty
   }

   public enum Relations implements RelationshipType {
      FLOW, NAME, EXTENDING, FROM, ON, TO, FINISH, CONTEXT_PROPERTY, MODIFIER, COMMENT, TYPE, VALUE, ISHANDLINGJSONMESSAGES
   }

   public enum Properties {
      name, extending, modifier, comment, type, value, isHandlingJsonMessages
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   EasyFlowDomainPlugin(App app) {
      super(app, "EasyFlow");

		domainNode = DomainMotif.newDomainNode(getGraph(), "EasyFlow");
		entitiesNodeMap.put(Entities.Flow, DomainMotif.newDomainEntity(getGraph(), Entities.Flow, domainNode));
		entitiesNodeMap.put(Entities.State, DomainMotif.newDomainEntity(getGraph(), Entities.State, domainNode));
		entitiesNodeMap.put(Entities.Event, DomainMotif.newDomainEntity(getGraph(), Entities.Event, domainNode));
		entitiesNodeMap.put(Entities.ContextProperty, DomainMotif.newDomainEntity(getGraph(), Entities.ContextProperty, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Flow), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Flow), Properties.extending.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Flow), Properties.isHandlingJsonMessages.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.State), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Event), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.modifier.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.comment.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.type.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ContextProperty), Properties.value.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Flow), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Flow), Relations.FROM.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.State));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Flow), Relations.CONTEXT_PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.ContextProperty));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.State), Relations.ON.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Event));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Event), Relations.TO.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.State));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Event), Relations.FINISH.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.State));
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

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

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
	protected Node newFlow(Object name, Object extending, Object isHandlingJsonMessages) { return newFlow(getGraph(), name, extending, isHandlingJsonMessages); } 

	public static Node newFlow(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Flow)); } 
	public static Node newFlow(NeoModel graph, Object name, Object extending, Object isHandlingJsonMessages) {  	
		final Node newNode = newFlow(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (extending != null) relate(newNode, DomainMotif.newValueNode(graph, extending), RelationshipType.withName(Properties.extending.name()));
		if (isHandlingJsonMessages != null) relate(newNode, DomainMotif.newValueNode(graph, isHandlingJsonMessages), RelationshipType.withName(Properties.isHandlingJsonMessages.name())); 	
		return newNode; 
	}

	protected Node newState() { return newState(getGraph()); } 
	protected Node newState(Object name) { return newState(getGraph(), name); } 

	public static Node newState(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.State)); } 
	public static Node newState(NeoModel graph, Object name) {  	
		final Node newNode = newState(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newEvent() { return newEvent(getGraph()); } 
	protected Node newEvent(Object name) { return newEvent(getGraph(), name); } 

	public static Node newEvent(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Event)); } 
	public static Node newEvent(NeoModel graph, Object name) {  	
		final Node newNode = newEvent(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newContextProperty() { return newContextProperty(getGraph()); } 
	protected Node newContextProperty(Object name, Object modifier, Object comment, Object type, Object value) { return newContextProperty(getGraph(), name, modifier, comment, type, value); } 

	public static Node newContextProperty(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ContextProperty)); } 
	public static Node newContextProperty(NeoModel graph, Object name, Object modifier, Object comment, Object type, Object value) {  	
		final Node newNode = newContextProperty(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (modifier != null) relate(newNode, DomainMotif.newValueNode(graph, modifier), RelationshipType.withName(Properties.modifier.name()));
		if (comment != null) relate(newNode, DomainMotif.newValueNode(graph, comment), RelationshipType.withName(Properties.comment.name()));
		if (type != null) relate(newNode, DomainMotif.newValueNode(graph, type), RelationshipType.withName(Properties.type.name()));
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}


	public static void outgoingFLOW(Node src, RelationConsumer consumer) { outgoing(src, Relations.FLOW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFLOW(Node src) { return other(src, singleOutgoing(src, Relations.FLOW)); }
	public static void incomingFLOW(Node src, RelationConsumer consumer) { incoming(src, Relations.FLOW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFLOW(Node src) { return other(src, singleIncoming(src, Relations.FLOW)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingEXTENDING(Node src, RelationConsumer consumer) { outgoing(src, Relations.EXTENDING).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEXTENDING(Node src) { return other(src, singleOutgoing(src, Relations.EXTENDING)); }
	public static void incomingEXTENDING(Node src, RelationConsumer consumer) { incoming(src, Relations.EXTENDING).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEXTENDING(Node src) { return other(src, singleIncoming(src, Relations.EXTENDING)); }

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

	public static void outgoingMODIFIER(Node src, RelationConsumer consumer) { outgoing(src, Relations.MODIFIER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMODIFIER(Node src) { return other(src, singleOutgoing(src, Relations.MODIFIER)); }
	public static void incomingMODIFIER(Node src, RelationConsumer consumer) { incoming(src, Relations.MODIFIER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMODIFIER(Node src) { return other(src, singleIncoming(src, Relations.MODIFIER)); }

	public static void outgoingCOMMENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMMENT(Node src) { return other(src, singleOutgoing(src, Relations.COMMENT)); }
	public static void incomingCOMMENT(Node src, RelationConsumer consumer) { incoming(src, Relations.COMMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMMENT(Node src) { return other(src, singleIncoming(src, Relations.COMMENT)); }

	public static void outgoingTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPE(Node src) { return other(src, singleOutgoing(src, Relations.TYPE)); }
	public static void incomingTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPE(Node src) { return other(src, singleIncoming(src, Relations.TYPE)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }

	public static void outgoingISHANDLINGJSONMESSAGES(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISHANDLINGJSONMESSAGES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISHANDLINGJSONMESSAGES(Node src) { return other(src, singleOutgoing(src, Relations.ISHANDLINGJSONMESSAGES)); }
	public static void incomingISHANDLINGJSONMESSAGES(Node src, RelationConsumer consumer) { incoming(src, Relations.ISHANDLINGJSONMESSAGES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISHANDLINGJSONMESSAGES(Node src) { return other(src, singleIncoming(src, Relations.ISHANDLINGJSONMESSAGES)); }


	public static Relationship relateFLOW(Node src, Node dst) { return relate(src, dst, Relations.FLOW); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateEXTENDING(Node src, Node dst) { return relate(src, dst, Relations.EXTENDING); }
	public static Relationship relateFROM(Node src, Node dst) { return relate(src, dst, Relations.FROM); }
	public static Relationship relateON(Node src, Node dst) { return relate(src, dst, Relations.ON); }
	public static Relationship relateTO(Node src, Node dst) { return relate(src, dst, Relations.TO); }
	public static Relationship relateFINISH(Node src, Node dst) { return relate(src, dst, Relations.FINISH); }
	public static Relationship relateCONTEXT_PROPERTY(Node src, Node dst) { return relate(src, dst, Relations.CONTEXT_PROPERTY); }
	public static Relationship relateMODIFIER(Node src, Node dst) { return relate(src, dst, Relations.MODIFIER); }
	public static Relationship relateCOMMENT(Node src, Node dst) { return relate(src, dst, Relations.COMMENT); }
	public static Relationship relateTYPE(Node src, Node dst) { return relate(src, dst, Relations.TYPE); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relateISHANDLINGJSONMESSAGES(Node src, Node dst) { return relate(src, dst, Relations.ISHANDLINGJSONMESSAGES); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// extending
	public static <T> T getExtendingProperty(PropertyContainer container) { return getExtendingProperty(container, null); }
	public static <T> T getExtendingProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.extending.name(), defaultValue); }
	public static boolean hasExtendingProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.extending.name()); }
	public static <T extends PropertyContainer> T setExtendingProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.extending.name(), value); return container; }
	public static <T extends PropertyContainer> T removeExtendingProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.extending.name()); return container; }

	protected <T extends PropertyContainer> T setExtendingProperty(T container, Object value) { setExtendingProperty(getGraph(), container, value); return container; }

	// modifier
	public static <T> T getModifierProperty(PropertyContainer container) { return getModifierProperty(container, null); }
	public static <T> T getModifierProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.modifier.name(), defaultValue); }
	public static boolean hasModifierProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.modifier.name()); }
	public static <T extends PropertyContainer> T setModifierProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.modifier.name(), value); return container; }
	public static <T extends PropertyContainer> T removeModifierProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.modifier.name()); return container; }

	protected <T extends PropertyContainer> T setModifierProperty(T container, Object value) { setModifierProperty(getGraph(), container, value); return container; }

	// comment
	public static <T> T getCommentProperty(PropertyContainer container) { return getCommentProperty(container, null); }
	public static <T> T getCommentProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.comment.name(), defaultValue); }
	public static boolean hasCommentProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.comment.name()); }
	public static <T extends PropertyContainer> T setCommentProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.comment.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCommentProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.comment.name()); return container; }

	protected <T extends PropertyContainer> T setCommentProperty(T container, Object value) { setCommentProperty(getGraph(), container, value); return container; }

	// type
	public static <T> T getTypeProperty(PropertyContainer container) { return getTypeProperty(container, null); }
	public static <T> T getTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.type.name(), defaultValue); }
	public static boolean hasTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.type.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.type.name()); return container; }

	protected <T extends PropertyContainer> T setTypeProperty(T container, Object value) { setTypeProperty(getGraph(), container, value); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getValueProperty(container, null); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.value.name()); return container; }

	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setValueProperty(getGraph(), container, value); return container; }

	// isHandlingJsonMessages
	public static <T> T getIsHandlingJsonMessagesProperty(PropertyContainer container) { return getIsHandlingJsonMessagesProperty(container, null); }
	public static <T> T getIsHandlingJsonMessagesProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isHandlingJsonMessages.name(), defaultValue); }
	public static boolean hasIsHandlingJsonMessagesProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isHandlingJsonMessages.name()); }
	public static <T extends PropertyContainer> T setIsHandlingJsonMessagesProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isHandlingJsonMessages.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsHandlingJsonMessagesProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isHandlingJsonMessages.name()); return container; }

	protected <T extends PropertyContainer> T setIsHandlingJsonMessagesProperty(T container, Object value) { setIsHandlingJsonMessagesProperty(getGraph(), container, value); return container; }

}