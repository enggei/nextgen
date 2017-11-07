package com.generator.generators.ssh;

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
 * Auto-generated from domain SSHDomainPlugin
 */
public abstract class SSHDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Host, Session, Channel, Path, CommandRoot, CommandCategory, Command
   }

   public enum Relations implements RelationshipType {
      HOST, COMMANDROOT, SESSIONS, CHANNELS, PATHS, CATEGORIES, COMMANDS
   }

   public enum Properties {
      path, ip, username, password, port, privateKeyPath, cmdCommand, name
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   SSHDomainPlugin(App app) {
      super(app, "SSH");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "SSH");
		entitiesNodeMap.put(Entities.Host, newDomainEntity(getGraph(), Entities.Host, domainNode));
		entitiesNodeMap.put(Entities.Session, newDomainEntity(getGraph(), Entities.Session, domainNode));
		entitiesNodeMap.put(Entities.Channel, newDomainEntity(getGraph(), Entities.Channel, domainNode));
		entitiesNodeMap.put(Entities.Path, newDomainEntity(getGraph(), Entities.Path, domainNode));
		entitiesNodeMap.put(Entities.CommandRoot, newDomainEntity(getGraph(), Entities.CommandRoot, domainNode));
		entitiesNodeMap.put(Entities.CommandCategory, newDomainEntity(getGraph(), Entities.CommandCategory, domainNode));
		entitiesNodeMap.put(Entities.Command, newDomainEntity(getGraph(), Entities.Command, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.ip.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.username.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.password.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.port.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Host), Properties.privateKeyPath.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Path), Properties.path.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Command), Properties.cmdCommand.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Command), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Host), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.CommandRoot), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Host), Relations.SESSIONS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Session));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Host), Relations.PATHS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Path));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Session), Relations.CHANNELS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Channel));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.CommandRoot), Relations.CATEGORIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.CommandCategory));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.CommandCategory), Relations.COMMANDS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Command));
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
		if (isCommandRoot(neoNode.getNode())) return newCommandRootEditor(neoNode);
		if (isCommandCategory(neoNode.getNode())) return newCommandCategoryEditor(neoNode);
		if (isCommand(neoNode.getNode())) return newCommandEditor(neoNode);
      return null;
   }

	protected void handleHost(JPopupMenu pop, NeoNode hostNode, Set<NeoNode> selectedNodes) { }
	protected void handleSession(JPopupMenu pop, NeoNode sessionNode, Set<NeoNode> selectedNodes) { }
	protected void handleChannel(JPopupMenu pop, NeoNode channelNode, Set<NeoNode> selectedNodes) { }
	protected void handlePath(JPopupMenu pop, NeoNode pathNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommandRoot(JPopupMenu pop, NeoNode commandRootNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommandCategory(JPopupMenu pop, NeoNode commandCategoryNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommand(JPopupMenu pop, NeoNode commandNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newHostEditor(NeoNode hostNode) { return null; }
	protected JComponent newSessionEditor(NeoNode sessionNode) { return null; }
	protected JComponent newChannelEditor(NeoNode channelNode) { return null; }
	protected JComponent newPathEditor(NeoNode pathNode) { return null; }
	protected JComponent newCommandRootEditor(NeoNode commandRootNode) { return null; }
	protected JComponent newCommandCategoryEditor(NeoNode commandCategoryNode) { return null; }
	protected JComponent newCommandEditor(NeoNode commandNode) { return null; }

	public static boolean isHost(Node node) { return hasLabel(node, Entities.Host); }
	public static boolean isSession(Node node) { return hasLabel(node, Entities.Session); }
	public static boolean isChannel(Node node) { return hasLabel(node, Entities.Channel); }
	public static boolean isPath(Node node) { return hasLabel(node, Entities.Path); }
	public static boolean isCommandRoot(Node node) { return hasLabel(node, Entities.CommandRoot); }
	public static boolean isCommandCategory(Node node) { return hasLabel(node, Entities.CommandCategory); }
	public static boolean isCommand(Node node) { return hasLabel(node, Entities.Command); }

	protected Node newHost() { return newHost(getGraph()); } 
	public static Node newHost(NeoModel graph) { return newInstanceNode(graph, Entities.Host.name(), entitiesNodeMap.get(Entities.Host)); } 
	protected Node newHost(Object ip, Object username, Object password, Object port, Object privateKeyPath) { return newHost(getGraph(), ip, username, password, port, privateKeyPath); } 
	public static Node newHost(NeoModel graph, Object ip, Object username, Object password, Object port, Object privateKeyPath) {  	
		final Node newNode = newHost(graph); 	
		if (ip != null) relate(newNode, newValueNode(graph, ip), RelationshipType.withName(Properties.ip.name()));
		if (username != null) relate(newNode, newValueNode(graph, username), RelationshipType.withName(Properties.username.name()));
		if (password != null) relate(newNode, newValueNode(graph, password), RelationshipType.withName(Properties.password.name()));
		if (port != null) relate(newNode, newValueNode(graph, port), RelationshipType.withName(Properties.port.name()));
		if (privateKeyPath != null) relate(newNode, newValueNode(graph, privateKeyPath), RelationshipType.withName(Properties.privateKeyPath.name())); 	
		return newNode; 
	}

	protected Node newSession() { return newSession(getGraph()); } 
	public static Node newSession(NeoModel graph) { return newInstanceNode(graph, Entities.Session.name(), entitiesNodeMap.get(Entities.Session)); }

	protected Node newChannel() { return newChannel(getGraph()); } 
	public static Node newChannel(NeoModel graph) { return newInstanceNode(graph, Entities.Channel.name(), entitiesNodeMap.get(Entities.Channel)); }

	protected Node newPath() { return newPath(getGraph()); } 
	public static Node newPath(NeoModel graph) { return newInstanceNode(graph, Entities.Path.name(), entitiesNodeMap.get(Entities.Path)); } 
	protected Node newPath(Object path) { return newPath(getGraph(), path); } 
	public static Node newPath(NeoModel graph, Object path) {  	
		final Node newNode = newPath(graph); 	
		if (path != null) relate(newNode, newValueNode(graph, path), RelationshipType.withName(Properties.path.name())); 	
		return newNode; 
	}

	protected Node newCommandRoot() { return newCommandRoot(getGraph()); } 
	public static Node newCommandRoot(NeoModel graph) { return newInstanceNode(graph, Entities.CommandRoot.name(), entitiesNodeMap.get(Entities.CommandRoot)); }

	protected Node newCommandCategory() { return newCommandCategory(getGraph()); } 
	public static Node newCommandCategory(NeoModel graph) { return newInstanceNode(graph, Entities.CommandCategory.name(), entitiesNodeMap.get(Entities.CommandCategory)); }

	protected Node newCommand() { return newCommand(getGraph()); } 
	public static Node newCommand(NeoModel graph) { return newInstanceNode(graph, Entities.Command.name(), entitiesNodeMap.get(Entities.Command)); } 
	protected Node newCommand(Object cmdCommand, Object name) { return newCommand(getGraph(), cmdCommand, name); } 
	public static Node newCommand(NeoModel graph, Object cmdCommand, Object name) {  	
		final Node newNode = newCommand(graph); 	
		if (cmdCommand != null) relate(newNode, newValueNode(graph, cmdCommand), RelationshipType.withName(Properties.cmdCommand.name()));
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
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
	public static Relationship relateCATEGORIES(Node src, Node dst) { return relate(src, dst, Relations.CATEGORIES); }
	public static Relationship relateCOMMANDS(Node src, Node dst) { return relate(src, dst, Relations.COMMANDS); }

	// path
	public static <T> T getPathProperty(PropertyContainer container) { return getEntityProperty(container, Properties.path.name()); }
	public static <T> T getPathProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.path.name(), defaultValue); }
	public static boolean hasPathProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.path.name()); }
	public static <T extends PropertyContainer> T setPathProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.path.name(), value); return container; }
	protected <T extends PropertyContainer> T setPathProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.path.name(), value); return container; }
	public static <T extends PropertyContainer> T removePathProperty(T container) { removeEntityProperty(container, Properties.path.name()); return container; }

	// ip
	public static <T> T getIpProperty(PropertyContainer container) { return getEntityProperty(container, Properties.ip.name()); }
	public static <T> T getIpProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.ip.name(), defaultValue); }
	public static boolean hasIpProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.ip.name()); }
	public static <T extends PropertyContainer> T setIpProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.ip.name(), value); return container; }
	protected <T extends PropertyContainer> T setIpProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.ip.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIpProperty(T container) { removeEntityProperty(container, Properties.ip.name()); return container; }

	// username
	public static <T> T getUsernameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.username.name()); }
	public static <T> T getUsernameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.username.name(), defaultValue); }
	public static boolean hasUsernameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.username.name()); }
	public static <T extends PropertyContainer> T setUsernameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.username.name(), value); return container; }
	protected <T extends PropertyContainer> T setUsernameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.username.name(), value); return container; }
	public static <T extends PropertyContainer> T removeUsernameProperty(T container) { removeEntityProperty(container, Properties.username.name()); return container; }

	// password
	public static <T> T getPasswordProperty(PropertyContainer container) { return getEntityProperty(container, Properties.password.name()); }
	public static <T> T getPasswordProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.password.name(), defaultValue); }
	public static boolean hasPasswordProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.password.name()); }
	public static <T extends PropertyContainer> T setPasswordProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.password.name(), value); return container; }
	protected <T extends PropertyContainer> T setPasswordProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.password.name(), value); return container; }
	public static <T extends PropertyContainer> T removePasswordProperty(T container) { removeEntityProperty(container, Properties.password.name()); return container; }

	// port
	public static <T> T getPortProperty(PropertyContainer container) { return getEntityProperty(container, Properties.port.name()); }
	public static <T> T getPortProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.port.name(), defaultValue); }
	public static boolean hasPortProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.port.name()); }
	public static <T extends PropertyContainer> T setPortProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.port.name(), value); return container; }
	protected <T extends PropertyContainer> T setPortProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.port.name(), value); return container; }
	public static <T extends PropertyContainer> T removePortProperty(T container) { removeEntityProperty(container, Properties.port.name()); return container; }

	// privateKeyPath
	public static <T> T getPrivateKeyPathProperty(PropertyContainer container) { return getEntityProperty(container, Properties.privateKeyPath.name()); }
	public static <T> T getPrivateKeyPathProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.privateKeyPath.name(), defaultValue); }
	public static boolean hasPrivateKeyPathProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.privateKeyPath.name()); }
	public static <T extends PropertyContainer> T setPrivateKeyPathProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.privateKeyPath.name(), value); return container; }
	protected <T extends PropertyContainer> T setPrivateKeyPathProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.privateKeyPath.name(), value); return container; }
	public static <T extends PropertyContainer> T removePrivateKeyPathProperty(T container) { removeEntityProperty(container, Properties.privateKeyPath.name()); return container; }

	// cmdCommand
	public static <T> T getCmdCommandProperty(PropertyContainer container) { return getEntityProperty(container, Properties.cmdCommand.name()); }
	public static <T> T getCmdCommandProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.cmdCommand.name(), defaultValue); }
	public static boolean hasCmdCommandProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.cmdCommand.name()); }
	public static <T extends PropertyContainer> T setCmdCommandProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.cmdCommand.name(), value); return container; }
	protected <T extends PropertyContainer> T setCmdCommandProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.cmdCommand.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCmdCommandProperty(T container) { removeEntityProperty(container, Properties.cmdCommand.name()); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

}