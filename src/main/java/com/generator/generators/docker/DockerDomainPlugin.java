package com.generator.generators.docker;

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
 * Auto-generated from domain DockerDomainPlugin
 */
abstract class DockerDomainPlugin extends Plugin {

	public enum Entities implements Label {
      DockerFile, Directory, DockerComposeFile
   }

   public enum Relations implements RelationshipType {
      BUILD, COMPOSE
   }

   public enum Properties {
   }

   DockerDomainPlugin(App app) {
      super(app, "Docker");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isDockerFile(neoNode.getNode())) handleDockerFile(pop, neoNode, selectedNodes);
		if (isDirectory(neoNode.getNode())) handleDirectory(pop, neoNode, selectedNodes);
		if (isDockerComposeFile(neoNode.getNode())) handleDockerComposeFile(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isDockerFile(neoNode.getNode())) return newDockerFileEditor(neoNode);
		if (isDirectory(neoNode.getNode())) return newDirectoryEditor(neoNode);
		if (isDockerComposeFile(neoNode.getNode())) return newDockerComposeFileEditor(neoNode);
      return null;
   }

	protected void handleDockerFile(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleDirectory(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleDockerComposeFile(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDockerFileEditor(NeoNode neoNode) { return null; }
	protected JComponent newDirectoryEditor(NeoNode neoNode) { return null; }
	protected JComponent newDockerComposeFileEditor(NeoNode neoNode) { return null; }

	protected Node newDockerFile(String name) { return newDockerFile(getGraph(), name); }
	protected Node newDockerFile() { return newDockerFile(getGraph()); } 
	protected Node newDirectory(String name) { return newDirectory(getGraph(), name); }
	protected Node newDirectory() { return newDirectory(getGraph()); } 
	protected Node newDockerComposeFile(String name) { return newDockerComposeFile(getGraph(), name); }
	protected Node newDockerComposeFile() { return newDockerComposeFile(getGraph()); } 

	public static boolean isDockerFile(Node node) { return hasLabel(node, Entities.DockerFile); }
	public static boolean isDirectory(Node node) { return hasLabel(node, Entities.Directory); }
	public static boolean isDockerComposeFile(Node node) { return hasLabel(node, Entities.DockerComposeFile); }

	public static Node newDockerFile(NeoModel graph, String name) { return graph.newNode(Entities.DockerFile, AppMotif.Properties.name.name(), name); }
	public static Node newDockerFile(NeoModel graph) { return graph.newNode(Entities.DockerFile); }
	public static Node newDirectory(NeoModel graph, String name) { return graph.newNode(Entities.Directory, AppMotif.Properties.name.name(), name); }
	public static Node newDirectory(NeoModel graph) { return graph.newNode(Entities.Directory); }
	public static Node newDockerComposeFile(NeoModel graph, String name) { return graph.newNode(Entities.DockerComposeFile, AppMotif.Properties.name.name(), name); }
	public static Node newDockerComposeFile(NeoModel graph) { return graph.newNode(Entities.DockerComposeFile); }

	public static void outgoingBUILD(Node src, RelationConsumer consumer) { outgoing(src, Relations.BUILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingBUILD(Node src, RelationConsumer consumer) { incoming(src, Relations.BUILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingCOMPOSE(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMPOSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingCOMPOSE(Node src, RelationConsumer consumer) { incoming(src, Relations.COMPOSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }

	public static Relationship relateBUILD(Node src, Node dst) { return relate(src, dst, Relations.BUILD); }
	public static Relationship relateCOMPOSE(Node src, Node dst) { return relate(src, dst, Relations.COMPOSE); }

	public static String getName(PropertyContainer node) { return DomainMotif.getName(node); }
	public static String getName(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setName(PropertyContainer node, String name) { DomainMotif.setName(node, name); }
	public static void setName(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

}