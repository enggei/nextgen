package com.generator.generators.vertx;

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
 * Auto-generated from domain VertxDomainPlugin
 */
public abstract class VertxDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(VertxDomainPlugin.class);

	public enum Entities implements Label {
      MessageDomain, Message, KeyValue, List, TcpBridgeServer, TcpBridgeHost, Application
   }

   public enum Relations implements RelationshipType {
      MESSAGEDOMAIN, TCPBRIDGESERVER, TCPBRIDGEHOST, APPLICATION, NAME, MESSAGE, KEYVALUE, KEY, VALUE, LIST, ELEMENT, HOST, PORT, SESSION, UUID
   }

   public enum Properties {
      name, key, value, host, port, uuid
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   VertxDomainPlugin(App app) {
      super(app, "Vertx");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Vertx");
		entitiesNodeMap.put(Entities.MessageDomain, DomainMotif.newDomainEntity(getGraph(), Entities.MessageDomain, domainNode));
		entitiesNodeMap.put(Entities.Message, DomainMotif.newDomainEntity(getGraph(), Entities.Message, domainNode));
		entitiesNodeMap.put(Entities.KeyValue, DomainMotif.newDomainEntity(getGraph(), Entities.KeyValue, domainNode));
		entitiesNodeMap.put(Entities.List, DomainMotif.newDomainEntity(getGraph(), Entities.List, domainNode));
		entitiesNodeMap.put(Entities.TcpBridgeServer, DomainMotif.newDomainEntity(getGraph(), Entities.TcpBridgeServer, domainNode));
		entitiesNodeMap.put(Entities.TcpBridgeHost, DomainMotif.newDomainEntity(getGraph(), Entities.TcpBridgeHost, domainNode));
		entitiesNodeMap.put(Entities.Application, DomainMotif.newDomainEntity(getGraph(), Entities.Application, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.MessageDomain), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Message), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.KeyValue), Properties.key.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.KeyValue), Properties.value.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.List), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TcpBridgeServer), Properties.host.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TcpBridgeServer), Properties.port.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TcpBridgeHost), Properties.uuid.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Application), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.MessageDomain), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.MessageDomain), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.TcpBridgeServer), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.TcpBridgeHost), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Application), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.TcpBridgeServer), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.TcpBridgeHost), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Application), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.MessageDomain), Relations.MESSAGE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Message));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Message), Relations.KEYVALUE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.KeyValue));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Message), Relations.LIST.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.List));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.List), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.KeyValue));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.MessageDomain), Relations.MESSAGE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Message));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Message), Relations.KEYVALUE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.KeyValue));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Message), Relations.LIST.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.List));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.List), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.KeyValue));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TcpBridgeServer), Relations.SESSION.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.TcpBridgeHost));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TcpBridgeServer), Relations.SESSION.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.TcpBridgeHost));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isMessageDomain(neoNode.getNode())) handleMessageDomain(pop, neoNode, selectedNodes);
		if (isMessage(neoNode.getNode())) handleMessage(pop, neoNode, selectedNodes);
		if (isKeyValue(neoNode.getNode())) handleKeyValue(pop, neoNode, selectedNodes);
		if (isList(neoNode.getNode())) handleList(pop, neoNode, selectedNodes);
		if (isTcpBridgeServer(neoNode.getNode())) handleTcpBridgeServer(pop, neoNode, selectedNodes);
		if (isTcpBridgeHost(neoNode.getNode())) handleTcpBridgeHost(pop, neoNode, selectedNodes);
		if (isApplication(neoNode.getNode())) handleApplication(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isMessageDomain(neoNode.getNode())) return newMessageDomainEditor(neoNode);
		if (isMessage(neoNode.getNode())) return newMessageEditor(neoNode);
		if (isKeyValue(neoNode.getNode())) return newKeyValueEditor(neoNode);
		if (isList(neoNode.getNode())) return newListEditor(neoNode);
		if (isTcpBridgeServer(neoNode.getNode())) return newTcpBridgeServerEditor(neoNode);
		if (isTcpBridgeHost(neoNode.getNode())) return newTcpBridgeHostEditor(neoNode);
		if (isApplication(neoNode.getNode())) return newApplicationEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleMessageDomain(JPopupMenu pop, NeoNode messageDomainNode, Set<NeoNode> selectedNodes) { }
	protected void handleMessage(JPopupMenu pop, NeoNode messageNode, Set<NeoNode> selectedNodes) { }
	protected void handleKeyValue(JPopupMenu pop, NeoNode keyValueNode, Set<NeoNode> selectedNodes) { }
	protected void handleList(JPopupMenu pop, NeoNode listNode, Set<NeoNode> selectedNodes) { }
	protected void handleTcpBridgeServer(JPopupMenu pop, NeoNode tcpBridgeServerNode, Set<NeoNode> selectedNodes) { }
	protected void handleTcpBridgeHost(JPopupMenu pop, NeoNode tcpBridgeHostNode, Set<NeoNode> selectedNodes) { }
	protected void handleApplication(JPopupMenu pop, NeoNode applicationNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newMessageDomainEditor(NeoNode messageDomainNode) { return null; }
	protected JComponent newMessageEditor(NeoNode messageNode) { return null; }
	protected JComponent newKeyValueEditor(NeoNode keyValueNode) { return null; }
	protected JComponent newListEditor(NeoNode listNode) { return null; }
	protected JComponent newTcpBridgeServerEditor(NeoNode tcpBridgeServerNode) { return null; }
	protected JComponent newTcpBridgeHostEditor(NeoNode tcpBridgeHostNode) { return null; }
	protected JComponent newApplicationEditor(NeoNode applicationNode) { return null; }

	public static boolean isMessageDomain(Node node) { return hasLabel(node, Entities.MessageDomain); }
	public static boolean isMessage(Node node) { return hasLabel(node, Entities.Message); }
	public static boolean isKeyValue(Node node) { return hasLabel(node, Entities.KeyValue); }
	public static boolean isList(Node node) { return hasLabel(node, Entities.List); }
	public static boolean isTcpBridgeServer(Node node) { return hasLabel(node, Entities.TcpBridgeServer); }
	public static boolean isTcpBridgeHost(Node node) { return hasLabel(node, Entities.TcpBridgeHost); }
	public static boolean isApplication(Node node) { return hasLabel(node, Entities.Application); }

	protected Node newMessageDomain() { return newMessageDomain(getGraph()); } 
	protected Node newMessageDomain(Object name) { return newMessageDomain(getGraph(), name); } 

	public static Node newMessageDomain(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.MessageDomain)); } 
	public static Node newMessageDomain(NeoModel graph, Object name) {  	
		final Node newNode = newMessageDomain(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newMessage() { return newMessage(getGraph()); } 
	protected Node newMessage(Object name) { return newMessage(getGraph(), name); } 

	public static Node newMessage(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Message)); } 
	public static Node newMessage(NeoModel graph, Object name) {  	
		final Node newNode = newMessage(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newKeyValue() { return newKeyValue(getGraph()); } 
	protected Node newKeyValue(Object key, Object value) { return newKeyValue(getGraph(), key, value); } 

	public static Node newKeyValue(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.KeyValue)); } 
	public static Node newKeyValue(NeoModel graph, Object key, Object value) {  	
		final Node newNode = newKeyValue(graph); 	
		if (key != null) relate(newNode, DomainMotif.newValueNode(graph, key), RelationshipType.withName(Properties.key.name()));
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}

	protected Node newList() { return newList(getGraph()); } 
	protected Node newList(Object name) { return newList(getGraph(), name); } 

	public static Node newList(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.List)); } 
	public static Node newList(NeoModel graph, Object name) {  	
		final Node newNode = newList(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newTcpBridgeServer() { return newTcpBridgeServer(getGraph()); } 
	protected Node newTcpBridgeServer(Object host, Object port) { return newTcpBridgeServer(getGraph(), host, port); } 

	public static Node newTcpBridgeServer(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TcpBridgeServer)); } 
	public static Node newTcpBridgeServer(NeoModel graph, Object host, Object port) {  	
		final Node newNode = newTcpBridgeServer(graph); 	
		if (host != null) relate(newNode, DomainMotif.newValueNode(graph, host), RelationshipType.withName(Properties.host.name()));
		if (port != null) relate(newNode, DomainMotif.newValueNode(graph, port), RelationshipType.withName(Properties.port.name())); 	
		return newNode; 
	}

	protected Node newTcpBridgeHost() { return newTcpBridgeHost(getGraph()); } 
	protected Node newTcpBridgeHost(Object uuid) { return newTcpBridgeHost(getGraph(), uuid); } 

	public static Node newTcpBridgeHost(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TcpBridgeHost)); } 
	public static Node newTcpBridgeHost(NeoModel graph, Object uuid) {  	
		final Node newNode = newTcpBridgeHost(graph); 	
		if (uuid != null) relate(newNode, DomainMotif.newValueNode(graph, uuid), RelationshipType.withName(Properties.uuid.name())); 	
		return newNode; 
	}

	protected Node newApplication() { return newApplication(getGraph()); } 
	protected Node newApplication(Object name) { return newApplication(getGraph(), name); } 

	public static Node newApplication(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Application)); } 
	public static Node newApplication(NeoModel graph, Object name) {  	
		final Node newNode = newApplication(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingMESSAGEDOMAIN(Node src, RelationConsumer consumer) { outgoing(src, Relations.MESSAGEDOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMESSAGEDOMAIN(Node src) { return other(src, singleOutgoing(src, Relations.MESSAGEDOMAIN)); }
	public static void incomingMESSAGEDOMAIN(Node src, RelationConsumer consumer) { incoming(src, Relations.MESSAGEDOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMESSAGEDOMAIN(Node src) { return other(src, singleIncoming(src, Relations.MESSAGEDOMAIN)); }

	public static void outgoingTCPBRIDGESERVER(Node src, RelationConsumer consumer) { outgoing(src, Relations.TCPBRIDGESERVER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTCPBRIDGESERVER(Node src) { return other(src, singleOutgoing(src, Relations.TCPBRIDGESERVER)); }
	public static void incomingTCPBRIDGESERVER(Node src, RelationConsumer consumer) { incoming(src, Relations.TCPBRIDGESERVER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTCPBRIDGESERVER(Node src) { return other(src, singleIncoming(src, Relations.TCPBRIDGESERVER)); }

	public static void outgoingTCPBRIDGEHOST(Node src, RelationConsumer consumer) { outgoing(src, Relations.TCPBRIDGEHOST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTCPBRIDGEHOST(Node src) { return other(src, singleOutgoing(src, Relations.TCPBRIDGEHOST)); }
	public static void incomingTCPBRIDGEHOST(Node src, RelationConsumer consumer) { incoming(src, Relations.TCPBRIDGEHOST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTCPBRIDGEHOST(Node src) { return other(src, singleIncoming(src, Relations.TCPBRIDGEHOST)); }

	public static void outgoingAPPLICATION(Node src, RelationConsumer consumer) { outgoing(src, Relations.APPLICATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingAPPLICATION(Node src) { return other(src, singleOutgoing(src, Relations.APPLICATION)); }
	public static void incomingAPPLICATION(Node src, RelationConsumer consumer) { incoming(src, Relations.APPLICATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingAPPLICATION(Node src) { return other(src, singleIncoming(src, Relations.APPLICATION)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingMESSAGE(Node src, RelationConsumer consumer) { outgoing(src, Relations.MESSAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMESSAGE(Node src) { return other(src, singleOutgoing(src, Relations.MESSAGE)); }
	public static void incomingMESSAGE(Node src, RelationConsumer consumer) { incoming(src, Relations.MESSAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMESSAGE(Node src) { return other(src, singleIncoming(src, Relations.MESSAGE)); }

	public static void outgoingKEYVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.KEYVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingKEYVALUE(Node src) { return other(src, singleOutgoing(src, Relations.KEYVALUE)); }
	public static void incomingKEYVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.KEYVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingKEYVALUE(Node src) { return other(src, singleIncoming(src, Relations.KEYVALUE)); }

	public static void outgoingKEY(Node src, RelationConsumer consumer) { outgoing(src, Relations.KEY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingKEY(Node src) { return other(src, singleOutgoing(src, Relations.KEY)); }
	public static void incomingKEY(Node src, RelationConsumer consumer) { incoming(src, Relations.KEY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingKEY(Node src) { return other(src, singleIncoming(src, Relations.KEY)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }

	public static void outgoingLIST(Node src, RelationConsumer consumer) { outgoing(src, Relations.LIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLIST(Node src) { return other(src, singleOutgoing(src, Relations.LIST)); }
	public static void incomingLIST(Node src, RelationConsumer consumer) { incoming(src, Relations.LIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLIST(Node src) { return other(src, singleIncoming(src, Relations.LIST)); }

	public static void outgoingELEMENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.ELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingELEMENT(Node src) { return other(src, singleOutgoing(src, Relations.ELEMENT)); }
	public static void incomingELEMENT(Node src, RelationConsumer consumer) { incoming(src, Relations.ELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingELEMENT(Node src) { return other(src, singleIncoming(src, Relations.ELEMENT)); }

	public static void outgoingHOST(Node src, RelationConsumer consumer) { outgoing(src, Relations.HOST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingHOST(Node src) { return other(src, singleOutgoing(src, Relations.HOST)); }
	public static void incomingHOST(Node src, RelationConsumer consumer) { incoming(src, Relations.HOST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingHOST(Node src) { return other(src, singleIncoming(src, Relations.HOST)); }

	public static void outgoingPORT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PORT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPORT(Node src) { return other(src, singleOutgoing(src, Relations.PORT)); }
	public static void incomingPORT(Node src, RelationConsumer consumer) { incoming(src, Relations.PORT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPORT(Node src) { return other(src, singleIncoming(src, Relations.PORT)); }

	public static void outgoingSESSION(Node src, RelationConsumer consumer) { outgoing(src, Relations.SESSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSESSION(Node src) { return other(src, singleOutgoing(src, Relations.SESSION)); }
	public static void incomingSESSION(Node src, RelationConsumer consumer) { incoming(src, Relations.SESSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSESSION(Node src) { return other(src, singleIncoming(src, Relations.SESSION)); }

	public static void outgoingUUID(Node src, RelationConsumer consumer) { outgoing(src, Relations.UUID).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingUUID(Node src) { return other(src, singleOutgoing(src, Relations.UUID)); }
	public static void incomingUUID(Node src, RelationConsumer consumer) { incoming(src, Relations.UUID).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingUUID(Node src) { return other(src, singleIncoming(src, Relations.UUID)); }


	public static Relationship relateMESSAGEDOMAIN(Node src, Node dst) { return relate(src, dst, Relations.MESSAGEDOMAIN); }
	public static Relationship relateTCPBRIDGESERVER(Node src, Node dst) { return relate(src, dst, Relations.TCPBRIDGESERVER); }
	public static Relationship relateTCPBRIDGEHOST(Node src, Node dst) { return relate(src, dst, Relations.TCPBRIDGEHOST); }
	public static Relationship relateAPPLICATION(Node src, Node dst) { return relate(src, dst, Relations.APPLICATION); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateMESSAGE(Node src, Node dst) { return relate(src, dst, Relations.MESSAGE); }
	public static Relationship relateKEYVALUE(Node src, Node dst) { return relate(src, dst, Relations.KEYVALUE); }
	public static Relationship relateKEY(Node src, Node dst) { return relate(src, dst, Relations.KEY); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relateLIST(Node src, Node dst) { return relate(src, dst, Relations.LIST); }
	public static Relationship relateELEMENT(Node src, Node dst) { return relate(src, dst, Relations.ELEMENT); }
	public static Relationship relateHOST(Node src, Node dst) { return relate(src, dst, Relations.HOST); }
	public static Relationship relatePORT(Node src, Node dst) { return relate(src, dst, Relations.PORT); }
	public static Relationship relateSESSION(Node src, Node dst) { return relate(src, dst, Relations.SESSION); }
	public static Relationship relateUUID(Node src, Node dst) { return relate(src, dst, Relations.UUID); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// key
	public static <T> T getKeyProperty(PropertyContainer container) { return getKeyProperty(container, null); }
	public static <T> T getKeyProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.key.name(), defaultValue); }
	public static boolean hasKeyProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.key.name()); }
	public static <T extends PropertyContainer> T setKeyProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.key.name(), value); return container; }
	public static <T extends PropertyContainer> T removeKeyProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.key.name()); return container; }

	protected <T extends PropertyContainer> T setKeyProperty(T container, Object value) { setKeyProperty(getGraph(), container, value); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getValueProperty(container, null); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.value.name()); return container; }

	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setValueProperty(getGraph(), container, value); return container; }

	// host
	public static <T> T getHostProperty(PropertyContainer container) { return getHostProperty(container, null); }
	public static <T> T getHostProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.host.name(), defaultValue); }
	public static boolean hasHostProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.host.name()); }
	public static <T extends PropertyContainer> T setHostProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.host.name(), value); return container; }
	public static <T extends PropertyContainer> T removeHostProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.host.name()); return container; }

	protected <T extends PropertyContainer> T setHostProperty(T container, Object value) { setHostProperty(getGraph(), container, value); return container; }

	// port
	public static <T> T getPortProperty(PropertyContainer container) { return getPortProperty(container, null); }
	public static <T> T getPortProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.port.name(), defaultValue); }
	public static boolean hasPortProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.port.name()); }
	public static <T extends PropertyContainer> T setPortProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.port.name(), value); return container; }
	public static <T extends PropertyContainer> T removePortProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.port.name()); return container; }

	protected <T extends PropertyContainer> T setPortProperty(T container, Object value) { setPortProperty(getGraph(), container, value); return container; }

	// uuid
	public static <T> T getUuidProperty(PropertyContainer container) { return getUuidProperty(container, null); }
	public static <T> T getUuidProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.uuid.name(), defaultValue); }
	public static boolean hasUuidProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.uuid.name()); }
	public static <T extends PropertyContainer> T setUuidProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.uuid.name(), value); return container; }
	public static <T extends PropertyContainer> T removeUuidProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.uuid.name()); return container; }

	protected <T extends PropertyContainer> T setUuidProperty(T container, Object value) { setUuidProperty(getGraph(), container, value); return container; }

}