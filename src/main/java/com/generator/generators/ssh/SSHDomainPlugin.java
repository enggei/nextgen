package com.generator.generators.ssh;

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
 * Auto-generated from domain SSHDomainPlugin
 */
abstract class SSHDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Host, Session, Channel, Path, CommandRoot, CommandCategory, Command
   }

   public enum Relations implements RelationshipType {
      SESSIONS, CHANNELS, PATHS, CATEGORIES, COMMANDS
   }

   public enum Properties {
      ip, username, password, port, privateKeyPath, cmdCommand
   }

   SSHDomainPlugin(App app) {
      super(app, "SSH");
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

	protected void handleHost(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleSession(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleChannel(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handlePath(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommandRoot(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommandCategory(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommand(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newHostEditor(NeoNode neoNode) { return null; }
	protected JComponent newSessionEditor(NeoNode neoNode) { return null; }
	protected JComponent newChannelEditor(NeoNode neoNode) { return null; }
	protected JComponent newPathEditor(NeoNode neoNode) { return null; }
	protected JComponent newCommandRootEditor(NeoNode neoNode) { return null; }
	protected JComponent newCommandCategoryEditor(NeoNode neoNode) { return null; }
	protected JComponent newCommandEditor(NeoNode neoNode) { return null; }

	protected Node newHost(String name) { return newHost(getGraph(), name); }
	protected Node newHost() { return newHost(getGraph()); } 
	protected Node newSession(String name) { return newSession(getGraph(), name); }
	protected Node newSession() { return newSession(getGraph()); } 
	protected Node newChannel(String name) { return newChannel(getGraph(), name); }
	protected Node newChannel() { return newChannel(getGraph()); } 
	protected Node newPath(String name) { return newPath(getGraph(), name); }
	protected Node newPath() { return newPath(getGraph()); } 
	protected Node newCommandRoot(String name) { return newCommandRoot(getGraph(), name); }
	protected Node newCommandRoot() { return newCommandRoot(getGraph()); } 
	protected Node newCommandCategory(String name) { return newCommandCategory(getGraph(), name); }
	protected Node newCommandCategory() { return newCommandCategory(getGraph()); } 
	protected Node newCommand(String name) { return newCommand(getGraph(), name); }
	protected Node newCommand() { return newCommand(getGraph()); } 

	public static boolean isHost(Node node) { return hasLabel(node, Entities.Host); }
	public static boolean isSession(Node node) { return hasLabel(node, Entities.Session); }
	public static boolean isChannel(Node node) { return hasLabel(node, Entities.Channel); }
	public static boolean isPath(Node node) { return hasLabel(node, Entities.Path); }
	public static boolean isCommandRoot(Node node) { return hasLabel(node, Entities.CommandRoot); }
	public static boolean isCommandCategory(Node node) { return hasLabel(node, Entities.CommandCategory); }
	public static boolean isCommand(Node node) { return hasLabel(node, Entities.Command); }

	public static Node newHost(NeoModel graph, String name) { return graph.newNode(Entities.Host, AppMotif.Properties.name.name(), name); }
	public static Node newHost(NeoModel graph) { return graph.newNode(Entities.Host); }
	public static Node newSession(NeoModel graph, String name) { return graph.newNode(Entities.Session, AppMotif.Properties.name.name(), name); }
	public static Node newSession(NeoModel graph) { return graph.newNode(Entities.Session); }
	public static Node newChannel(NeoModel graph, String name) { return graph.newNode(Entities.Channel, AppMotif.Properties.name.name(), name); }
	public static Node newChannel(NeoModel graph) { return graph.newNode(Entities.Channel); }
	public static Node newPath(NeoModel graph, String name) { return graph.newNode(Entities.Path, AppMotif.Properties.name.name(), name); }
	public static Node newPath(NeoModel graph) { return graph.newNode(Entities.Path); }
	public static Node newCommandRoot(NeoModel graph, String name) { return graph.newNode(Entities.CommandRoot, AppMotif.Properties.name.name(), name); }
	public static Node newCommandRoot(NeoModel graph) { return graph.newNode(Entities.CommandRoot); }
	public static Node newCommandCategory(NeoModel graph, String name) { return graph.newNode(Entities.CommandCategory, AppMotif.Properties.name.name(), name); }
	public static Node newCommandCategory(NeoModel graph) { return graph.newNode(Entities.CommandCategory); }
	public static Node newCommand(NeoModel graph, String name) { return graph.newNode(Entities.Command, AppMotif.Properties.name.name(), name); }
	public static Node newCommand(NeoModel graph) { return graph.newNode(Entities.Command); }

	public static void outgoingSESSIONS(Node src, RelationConsumer consumer) { outgoing(src, Relations.SESSIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingSESSIONS(Node src, RelationConsumer consumer) { incoming(src, Relations.SESSIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingCHANNELS(Node src, RelationConsumer consumer) { outgoing(src, Relations.CHANNELS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingCHANNELS(Node src, RelationConsumer consumer) { incoming(src, Relations.CHANNELS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingPATHS(Node src, RelationConsumer consumer) { outgoing(src, Relations.PATHS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingPATHS(Node src, RelationConsumer consumer) { incoming(src, Relations.PATHS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingCATEGORIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.CATEGORIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingCATEGORIES(Node src, RelationConsumer consumer) { incoming(src, Relations.CATEGORIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingCOMMANDS(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMMANDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingCOMMANDS(Node src, RelationConsumer consumer) { incoming(src, Relations.COMMANDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }

	public static Relationship relateSESSIONS(Node src, Node dst) { return relate(src, dst, Relations.SESSIONS); }
	public static Relationship relateCHANNELS(Node src, Node dst) { return relate(src, dst, Relations.CHANNELS); }
	public static Relationship relatePATHS(Node src, Node dst) { return relate(src, dst, Relations.PATHS); }
	public static Relationship relateCATEGORIES(Node src, Node dst) { return relate(src, dst, Relations.CATEGORIES); }
	public static Relationship relateCOMMANDS(Node src, Node dst) { return relate(src, dst, Relations.COMMANDS); }

	public static String getName(Node node) { return DomainMotif.getName(node); }
	public static String getName(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setName(Node node, String name) { DomainMotif.setName(node, name); }
	public static void setName(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	public static <T> T getIp(PropertyContainer container) { return get(container, Properties.ip.name()); }
	public static <T> T getIp(PropertyContainer container, T defaultValue) { return has(container, Properties.ip.name()) ? get(container, Properties.ip.name()) : defaultValue; }
	public static boolean hasIp(PropertyContainer container) { return has(container, Properties.ip.name()); }
	public static <T extends PropertyContainer> T setIp(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.ip.name());
	   else
	   	container.setProperty(Properties.ip.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeIp(T container) {
		if (has(container, Properties.ip.name())) container.removeProperty(Properties.ip.name());
	      return container;
	}

	public static <T> T getUsername(PropertyContainer container) { return get(container, Properties.username.name()); }
	public static <T> T getUsername(PropertyContainer container, T defaultValue) { return has(container, Properties.username.name()) ? get(container, Properties.username.name()) : defaultValue; }
	public static boolean hasUsername(PropertyContainer container) { return has(container, Properties.username.name()); }
	public static <T extends PropertyContainer> T setUsername(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.username.name());
	   else
	   	container.setProperty(Properties.username.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeUsername(T container) {
		if (has(container, Properties.username.name())) container.removeProperty(Properties.username.name());
	      return container;
	}

	public static <T> T getPassword(PropertyContainer container) { return get(container, Properties.password.name()); }
	public static <T> T getPassword(PropertyContainer container, T defaultValue) { return has(container, Properties.password.name()) ? get(container, Properties.password.name()) : defaultValue; }
	public static boolean hasPassword(PropertyContainer container) { return has(container, Properties.password.name()); }
	public static <T extends PropertyContainer> T setPassword(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.password.name());
	   else
	   	container.setProperty(Properties.password.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removePassword(T container) {
		if (has(container, Properties.password.name())) container.removeProperty(Properties.password.name());
	      return container;
	}

	public static <T> T getPort(PropertyContainer container) { return get(container, Properties.port.name()); }
	public static <T> T getPort(PropertyContainer container, T defaultValue) { return has(container, Properties.port.name()) ? get(container, Properties.port.name()) : defaultValue; }
	public static boolean hasPort(PropertyContainer container) { return has(container, Properties.port.name()); }
	public static <T extends PropertyContainer> T setPort(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.port.name());
	   else
	   	container.setProperty(Properties.port.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removePort(T container) {
		if (has(container, Properties.port.name())) container.removeProperty(Properties.port.name());
	      return container;
	}

	public static <T> T getPrivateKeyPath(PropertyContainer container) { return get(container, Properties.privateKeyPath.name()); }
	public static <T> T getPrivateKeyPath(PropertyContainer container, T defaultValue) { return has(container, Properties.privateKeyPath.name()) ? get(container, Properties.privateKeyPath.name()) : defaultValue; }
	public static boolean hasPrivateKeyPath(PropertyContainer container) { return has(container, Properties.privateKeyPath.name()); }
	public static <T extends PropertyContainer> T setPrivateKeyPath(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.privateKeyPath.name());
	   else
	   	container.setProperty(Properties.privateKeyPath.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removePrivateKeyPath(T container) {
		if (has(container, Properties.privateKeyPath.name())) container.removeProperty(Properties.privateKeyPath.name());
	      return container;
	}

	public static <T> T getCmdCommand(PropertyContainer container) { return get(container, Properties.cmdCommand.name()); }
	public static <T> T getCmdCommand(PropertyContainer container, T defaultValue) { return has(container, Properties.cmdCommand.name()) ? get(container, Properties.cmdCommand.name()) : defaultValue; }
	public static boolean hasCmdCommand(PropertyContainer container) { return has(container, Properties.cmdCommand.name()); }
	public static <T extends PropertyContainer> T setCmdCommand(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.cmdCommand.name());
	   else
	   	container.setProperty(Properties.cmdCommand.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeCmdCommand(T container) {
		if (has(container, Properties.cmdCommand.name())) container.removeProperty(Properties.cmdCommand.name());
	      return container;
	}

}