package com.generator.generators.ssh;

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
 * Auto-generated from domain SSHDomainPlugin
 */
public abstract class SSHDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Host, Session, Channel, Path, CommandHistory, CommandRoot, CommandCategory, Command
   }

   public enum Relations implements RelationshipType {
      HOST, COMMANDROOT, SESSIONS, CHANNELS, PATHS, HISTORY, CATEGORIES, COMMANDS
   }

   public enum Properties {
      path, ip, username, password, port, privateKeyPath, command, cmdCommand, name
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   SSHDomainPlugin(App app) {
      super(app, "SSH");

		domainNode = DomainMotif.newDomainNode(getGraph(), "SSH");
		entitiesNodeMap.put(Entities.Host, DomainMotif.newDomainEntity(getGraph(), Entities.Host, domainNode));
		entitiesNodeMap.put(Entities.Session, DomainMotif.newDomainEntity(getGraph(), Entities.Session, domainNode));
		entitiesNodeMap.put(Entities.Channel, DomainMotif.newDomainEntity(getGraph(), Entities.Channel, domainNode));
		entitiesNodeMap.put(Entities.Path, DomainMotif.newDomainEntity(getGraph(), Entities.Path, domainNode));
		entitiesNodeMap.put(Entities.CommandHistory, DomainMotif.newDomainEntity(getGraph(), Entities.CommandHistory, domainNode));
		entitiesNodeMap.put(Entities.CommandRoot, DomainMotif.newDomainEntity(getGraph(), Entities.CommandRoot, domainNode));
		entitiesNodeMap.put(Entities.CommandCategory, DomainMotif.newDomainEntity(getGraph(), Entities.CommandCategory, domainNode));
		entitiesNodeMap.put(Entities.Command, DomainMotif.newDomainEntity(getGraph(), Entities.Command, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.ip.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.username.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.password.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.port.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.privateKeyPath.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Path), Properties.path.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.CommandHistory), Properties.command.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Command), Properties.cmdCommand.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Command), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Host), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.CommandRoot), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Host), Relations.SESSIONS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Session));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Host), Relations.PATHS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Path));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Host), Relations.HISTORY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.CommandHistory));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Session), Relations.CHANNELS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Channel));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.CommandRoot), Relations.CATEGORIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.CommandCategory));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.CommandCategory), Relations.COMMANDS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Command));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isHost(neoNode.getNode())) handleHost(pop, neoNode, selectedNodes);
		if (isSession(neoNode.getNode())) handleSession(pop, neoNode, selectedNodes);
		if (isChannel(neoNode.getNode())) handleChannel(pop, neoNode, selectedNodes);
		if (isPath(neoNode.getNode())) handlePath(pop, neoNode, selectedNodes);
		if (isCommandHistory(neoNode.getNode())) handleCommandHistory(pop, neoNode, selectedNodes);
		if (isCommandRoot(neoNode.getNode())) handleCommandRoot(pop, neoNode, selectedNodes);
		if (isCommandCategory(neoNode.getNode())) handleCommandCategory(pop, neoNode, selectedNodes);
		if (isCommand(neoNode.getNode())) handleCommand(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isHost(neoNode.getNode())) return newHostEditor(neoNode);
		if (isSession(neoNode.getNode())) return newSessionEditor(neoNode);
		if (isChannel(neoNode.getNode())) return newChannelEditor(neoNode);
		if (isPath(neoNode.getNode())) return newPathEditor(neoNode);
		if (isCommandHistory(neoNode.getNode())) return newCommandHistoryEditor(neoNode);
		if (isCommandRoot(neoNode.getNode())) return newCommandRootEditor(neoNode);
		if (isCommandCategory(neoNode.getNode())) return newCommandCategoryEditor(neoNode);
		if (isCommand(neoNode.getNode())) return newCommandEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleHost(JPopupMenu pop, NeoNode hostNode, Set<NeoNode> selectedNodes) { }
	protected void handleSession(JPopupMenu pop, NeoNode sessionNode, Set<NeoNode> selectedNodes) { }
	protected void handleChannel(JPopupMenu pop, NeoNode channelNode, Set<NeoNode> selectedNodes) { }
	protected void handlePath(JPopupMenu pop, NeoNode pathNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommandHistory(JPopupMenu pop, NeoNode commandHistoryNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommandRoot(JPopupMenu pop, NeoNode commandRootNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommandCategory(JPopupMenu pop, NeoNode commandCategoryNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommand(JPopupMenu pop, NeoNode commandNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newHostEditor(NeoNode hostNode) { return null; }
	protected JComponent newSessionEditor(NeoNode sessionNode) { return null; }
	protected JComponent newChannelEditor(NeoNode channelNode) { return null; }
	protected JComponent newPathEditor(NeoNode pathNode) { return null; }
	protected JComponent newCommandHistoryEditor(NeoNode commandHistoryNode) { return null; }
	protected JComponent newCommandRootEditor(NeoNode commandRootNode) { return null; }
	protected JComponent newCommandCategoryEditor(NeoNode commandCategoryNode) { return null; }
	protected JComponent newCommandEditor(NeoNode commandNode) { return null; }

	public static boolean isHost(Node node) { return hasLabel(node, Entities.Host); }
	public static boolean isSession(Node node) { return hasLabel(node, Entities.Session); }
	public static boolean isChannel(Node node) { return hasLabel(node, Entities.Channel); }
	public static boolean isPath(Node node) { return hasLabel(node, Entities.Path); }
	public static boolean isCommandHistory(Node node) { return hasLabel(node, Entities.CommandHistory); }
	public static boolean isCommandRoot(Node node) { return hasLabel(node, Entities.CommandRoot); }
	public static boolean isCommandCategory(Node node) { return hasLabel(node, Entities.CommandCategory); }
	public static boolean isCommand(Node node) { return hasLabel(node, Entities.Command); }

	protected Node newHost() { return newHost(getGraph()); } 
	protected Node newHost(Object ip, Object username, Object password, Object port, Object privateKeyPath) { return newHost(getGraph(), ip, username, password, port, privateKeyPath); } 

	public static Node newHost(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Host)); } 
	public static Node newHost(NeoModel graph, Object ip, Object username, Object password, Object port, Object privateKeyPath) {  	
		final Node newNode = newHost(graph); 	
		if (ip != null) relate(newNode, DomainMotif.newValueNode(graph, ip), RelationshipType.withName(Properties.ip.name()));
		if (username != null) relate(newNode, DomainMotif.newValueNode(graph, username), RelationshipType.withName(Properties.username.name()));
		if (password != null) relate(newNode, DomainMotif.newValueNode(graph, password), RelationshipType.withName(Properties.password.name()));
		if (port != null) relate(newNode, DomainMotif.newValueNode(graph, port), RelationshipType.withName(Properties.port.name()));
		if (privateKeyPath != null) relate(newNode, DomainMotif.newValueNode(graph, privateKeyPath), RelationshipType.withName(Properties.privateKeyPath.name())); 	
		return newNode; 
	}

	protected Node newSession() { return newSession(getGraph()); }
	public static Node newSession(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Session)); }

	protected Node newChannel() { return newChannel(getGraph()); }
	public static Node newChannel(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Channel)); }

	protected Node newPath() { return newPath(getGraph()); } 
	protected Node newPath(Object path) { return newPath(getGraph(), path); } 

	public static Node newPath(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Path)); } 
	public static Node newPath(NeoModel graph, Object path) {  	
		final Node newNode = newPath(graph); 	
		if (path != null) relate(newNode, DomainMotif.newValueNode(graph, path), RelationshipType.withName(Properties.path.name())); 	
		return newNode; 
	}

	protected Node newCommandHistory() { return newCommandHistory(getGraph()); } 
	protected Node newCommandHistory(Object command) { return newCommandHistory(getGraph(), command); } 

	public static Node newCommandHistory(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.CommandHistory)); } 
	public static Node newCommandHistory(NeoModel graph, Object command) {  	
		final Node newNode = newCommandHistory(graph); 	
		if (command != null) relate(newNode, DomainMotif.newValueNode(graph, command), RelationshipType.withName(Properties.command.name())); 	
		return newNode; 
	}

	protected Node newCommandRoot() { return newCommandRoot(getGraph()); }
	public static Node newCommandRoot(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.CommandRoot)); }

	protected Node newCommandCategory() { return newCommandCategory(getGraph()); }
	public static Node newCommandCategory(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.CommandCategory)); }

	protected Node newCommand() { return newCommand(getGraph()); } 
	protected Node newCommand(Object cmdCommand, Object name) { return newCommand(getGraph(), cmdCommand, name); } 

	public static Node newCommand(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Command)); } 
	public static Node newCommand(NeoModel graph, Object cmdCommand, Object name) {  	
		final Node newNode = newCommand(graph); 	
		if (cmdCommand != null) relate(newNode, DomainMotif.newValueNode(graph, cmdCommand), RelationshipType.withName(Properties.cmdCommand.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingHOST(Node src, RelationConsumer consumer) { outgoing(src, Relations.HOST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingHOST(Node src) { return other(src, singleOutgoing(src, Relations.HOST)); }
	public static void incomingHOST(Node src, RelationConsumer consumer) { incoming(src, Relations.HOST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingHOST(Node src) { return other(src, singleIncoming(src, Relations.HOST)); }

	public static void outgoingCOMMANDROOT(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMMANDROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMMANDROOT(Node src) { return other(src, singleOutgoing(src, Relations.COMMANDROOT)); }
	public static void incomingCOMMANDROOT(Node src, RelationConsumer consumer) { incoming(src, Relations.COMMANDROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMMANDROOT(Node src) { return other(src, singleIncoming(src, Relations.COMMANDROOT)); }

	public static void outgoingSESSIONS(Node src, RelationConsumer consumer) { outgoing(src, Relations.SESSIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSESSIONS(Node src) { return other(src, singleOutgoing(src, Relations.SESSIONS)); }
	public static void incomingSESSIONS(Node src, RelationConsumer consumer) { incoming(src, Relations.SESSIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSESSIONS(Node src) { return other(src, singleIncoming(src, Relations.SESSIONS)); }

	public static void outgoingCHANNELS(Node src, RelationConsumer consumer) { outgoing(src, Relations.CHANNELS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCHANNELS(Node src) { return other(src, singleOutgoing(src, Relations.CHANNELS)); }
	public static void incomingCHANNELS(Node src, RelationConsumer consumer) { incoming(src, Relations.CHANNELS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCHANNELS(Node src) { return other(src, singleIncoming(src, Relations.CHANNELS)); }

	public static void outgoingPATHS(Node src, RelationConsumer consumer) { outgoing(src, Relations.PATHS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPATHS(Node src) { return other(src, singleOutgoing(src, Relations.PATHS)); }
	public static void incomingPATHS(Node src, RelationConsumer consumer) { incoming(src, Relations.PATHS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPATHS(Node src) { return other(src, singleIncoming(src, Relations.PATHS)); }

	public static void outgoingHISTORY(Node src, RelationConsumer consumer) { outgoing(src, Relations.HISTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingHISTORY(Node src) { return other(src, singleOutgoing(src, Relations.HISTORY)); }
	public static void incomingHISTORY(Node src, RelationConsumer consumer) { incoming(src, Relations.HISTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingHISTORY(Node src) { return other(src, singleIncoming(src, Relations.HISTORY)); }

	public static void outgoingCATEGORIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.CATEGORIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCATEGORIES(Node src) { return other(src, singleOutgoing(src, Relations.CATEGORIES)); }
	public static void incomingCATEGORIES(Node src, RelationConsumer consumer) { incoming(src, Relations.CATEGORIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCATEGORIES(Node src) { return other(src, singleIncoming(src, Relations.CATEGORIES)); }

	public static void outgoingCOMMANDS(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMMANDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMMANDS(Node src) { return other(src, singleOutgoing(src, Relations.COMMANDS)); }
	public static void incomingCOMMANDS(Node src, RelationConsumer consumer) { incoming(src, Relations.COMMANDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMMANDS(Node src) { return other(src, singleIncoming(src, Relations.COMMANDS)); }


	public static Relationship relateHOST(Node src, Node dst) { return relate(src, dst, Relations.HOST); }
	public static Relationship relateCOMMANDROOT(Node src, Node dst) { return relate(src, dst, Relations.COMMANDROOT); }
	public static Relationship relateSESSIONS(Node src, Node dst) { return relate(src, dst, Relations.SESSIONS); }
	public static Relationship relateCHANNELS(Node src, Node dst) { return relate(src, dst, Relations.CHANNELS); }
	public static Relationship relatePATHS(Node src, Node dst) { return relate(src, dst, Relations.PATHS); }
	public static Relationship relateHISTORY(Node src, Node dst) { return relate(src, dst, Relations.HISTORY); }
	public static Relationship relateCATEGORIES(Node src, Node dst) { return relate(src, dst, Relations.CATEGORIES); }
	public static Relationship relateCOMMANDS(Node src, Node dst) { return relate(src, dst, Relations.COMMANDS); }

	// path
	public static <T> T getPathProperty(PropertyContainer container) { return getPathProperty(container, null); }
	public static <T> T getPathProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.path.name(), defaultValue); }
	public static boolean hasPathProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.path.name()); }
	public static <T extends PropertyContainer> T setPathProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.path.name(), value); return container; }
	public static <T extends PropertyContainer> T removePathProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.path.name()); return container; }

	protected <T extends PropertyContainer> T setPathProperty(T container, Object value) { setPathProperty(getGraph(), container, value); return container; }

	// ip
	public static <T> T getIpProperty(PropertyContainer container) { return getIpProperty(container, null); }
	public static <T> T getIpProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.ip.name(), defaultValue); }
	public static boolean hasIpProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.ip.name()); }
	public static <T extends PropertyContainer> T setIpProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.ip.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIpProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.ip.name()); return container; }

	protected <T extends PropertyContainer> T setIpProperty(T container, Object value) { setIpProperty(getGraph(), container, value); return container; }

	// username
	public static <T> T getUsernameProperty(PropertyContainer container) { return getUsernameProperty(container, null); }
	public static <T> T getUsernameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.username.name(), defaultValue); }
	public static boolean hasUsernameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.username.name()); }
	public static <T extends PropertyContainer> T setUsernameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.username.name(), value); return container; }
	public static <T extends PropertyContainer> T removeUsernameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.username.name()); return container; }

	protected <T extends PropertyContainer> T setUsernameProperty(T container, Object value) { setUsernameProperty(getGraph(), container, value); return container; }

	// password
	public static <T> T getPasswordProperty(PropertyContainer container) { return getPasswordProperty(container, null); }
	public static <T> T getPasswordProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.password.name(), defaultValue); }
	public static boolean hasPasswordProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.password.name()); }
	public static <T extends PropertyContainer> T setPasswordProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.password.name(), value); return container; }
	public static <T extends PropertyContainer> T removePasswordProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.password.name()); return container; }

	protected <T extends PropertyContainer> T setPasswordProperty(T container, Object value) { setPasswordProperty(getGraph(), container, value); return container; }

	// port
	public static <T> T getPortProperty(PropertyContainer container) { return getPortProperty(container, null); }
	public static <T> T getPortProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.port.name(), defaultValue); }
	public static boolean hasPortProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.port.name()); }
	public static <T extends PropertyContainer> T setPortProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.port.name(), value); return container; }
	public static <T extends PropertyContainer> T removePortProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.port.name()); return container; }

	protected <T extends PropertyContainer> T setPortProperty(T container, Object value) { setPortProperty(getGraph(), container, value); return container; }

	// privateKeyPath
	public static <T> T getPrivateKeyPathProperty(PropertyContainer container) { return getPrivateKeyPathProperty(container, null); }
	public static <T> T getPrivateKeyPathProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.privateKeyPath.name(), defaultValue); }
	public static boolean hasPrivateKeyPathProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.privateKeyPath.name()); }
	public static <T extends PropertyContainer> T setPrivateKeyPathProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.privateKeyPath.name(), value); return container; }
	public static <T extends PropertyContainer> T removePrivateKeyPathProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.privateKeyPath.name()); return container; }

	protected <T extends PropertyContainer> T setPrivateKeyPathProperty(T container, Object value) { setPrivateKeyPathProperty(getGraph(), container, value); return container; }

	// command
	public static <T> T getCommandProperty(PropertyContainer container) { return getCommandProperty(container, null); }
	public static <T> T getCommandProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.command.name(), defaultValue); }
	public static boolean hasCommandProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.command.name()); }
	public static <T extends PropertyContainer> T setCommandProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.command.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCommandProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.command.name()); return container; }

	protected <T extends PropertyContainer> T setCommandProperty(T container, Object value) { setCommandProperty(getGraph(), container, value); return container; }

	// cmdCommand
	public static <T> T getCmdCommandProperty(PropertyContainer container) { return getCmdCommandProperty(container, null); }
	public static <T> T getCmdCommandProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.cmdCommand.name(), defaultValue); }
	public static boolean hasCmdCommandProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.cmdCommand.name()); }
	public static <T extends PropertyContainer> T setCmdCommandProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.cmdCommand.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCmdCommandProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.cmdCommand.name()); return container; }

	protected <T extends PropertyContainer> T setCmdCommandProperty(T container, Object value) { setCmdCommandProperty(getGraph(), container, value); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

}