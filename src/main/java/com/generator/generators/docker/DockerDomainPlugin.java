package com.generator.generators.docker;

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
 * Auto-generated from domain DockerDomainPlugin
 */
public abstract class DockerDomainPlugin extends Plugin {

	public enum Entities implements Label {
      DockerFile, Directory, DockerComposeFile
   }

   public enum Relations implements RelationshipType {
      DOCKERFILE, DIRECTORY, DOCKERCOMPOSEFILE, BUILD, COMPOSE
   }

   public enum Properties {
      name
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   DockerDomainPlugin(App app) {
      super(app, "Docker");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "Docker");
		entitiesNodeMap.put(Entities.DockerFile, newDomainEntity(getGraph(), Entities.DockerFile, domainNode));
		entitiesNodeMap.put(Entities.Directory, newDomainEntity(getGraph(), Entities.Directory, domainNode));
		entitiesNodeMap.put(Entities.DockerComposeFile, newDomainEntity(getGraph(), Entities.DockerComposeFile, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DockerFile), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DockerComposeFile), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.DockerFile), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Directory), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.DockerComposeFile), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.DockerFile), Relations.BUILD.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.DockerComposeFile), Relations.COMPOSE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
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

	protected void handleDockerFile(JPopupMenu pop, NeoNode dockerFileNode, Set<NeoNode> selectedNodes) { }
	protected void handleDirectory(JPopupMenu pop, NeoNode directoryNode, Set<NeoNode> selectedNodes) { }
	protected void handleDockerComposeFile(JPopupMenu pop, NeoNode dockerComposeFileNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDockerFileEditor(NeoNode dockerFileNode) { return null; }
	protected JComponent newDirectoryEditor(NeoNode directoryNode) { return null; }
	protected JComponent newDockerComposeFileEditor(NeoNode dockerComposeFileNode) { return null; }

	public static boolean isDockerFile(Node node) { return hasLabel(node, Entities.DockerFile); }
	public static boolean isDirectory(Node node) { return hasLabel(node, Entities.Directory); }
	public static boolean isDockerComposeFile(Node node) { return hasLabel(node, Entities.DockerComposeFile); }

	protected Node newDockerFile() { return newDockerFile(getGraph()); } 
	public static Node newDockerFile(NeoModel graph) { return newInstanceNode(graph, Entities.DockerFile.name(), entitiesNodeMap.get(Entities.DockerFile)); } 
	protected Node newDockerFile(Object name) { return newDockerFile(getGraph(), name); } 
	public static Node newDockerFile(NeoModel graph, Object name) {  	
		final Node newNode = newDockerFile(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newDirectory() { return newDirectory(getGraph()); } 
	public static Node newDirectory(NeoModel graph) { return newInstanceNode(graph, Entities.Directory.name(), entitiesNodeMap.get(Entities.Directory)); }

	protected Node newDockerComposeFile() { return newDockerComposeFile(getGraph()); } 
	public static Node newDockerComposeFile(NeoModel graph) { return newInstanceNode(graph, Entities.DockerComposeFile.name(), entitiesNodeMap.get(Entities.DockerComposeFile)); } 
	protected Node newDockerComposeFile(Object name) { return newDockerComposeFile(getGraph(), name); } 
	public static Node newDockerComposeFile(NeoModel graph, Object name) {  	
		final Node newNode = newDockerComposeFile(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingDOCKERFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.DOCKERFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDOCKERFILE(Node src) { return other(src, singleOutgoing(src, Relations.DOCKERFILE)); }
	public static void incomingDOCKERFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.DOCKERFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDOCKERFILE(Node src) { return other(src, singleIncoming(src, Relations.DOCKERFILE)); }

	public static void outgoingDIRECTORY(Node src, RelationConsumer consumer) { outgoing(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDIRECTORY(Node src) { return other(src, singleOutgoing(src, Relations.DIRECTORY)); }
	public static void incomingDIRECTORY(Node src, RelationConsumer consumer) { incoming(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDIRECTORY(Node src) { return other(src, singleIncoming(src, Relations.DIRECTORY)); }

	public static void outgoingDOCKERCOMPOSEFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.DOCKERCOMPOSEFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDOCKERCOMPOSEFILE(Node src) { return other(src, singleOutgoing(src, Relations.DOCKERCOMPOSEFILE)); }
	public static void incomingDOCKERCOMPOSEFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.DOCKERCOMPOSEFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDOCKERCOMPOSEFILE(Node src) { return other(src, singleIncoming(src, Relations.DOCKERCOMPOSEFILE)); }

	public static void outgoingBUILD(Node src, RelationConsumer consumer) { outgoing(src, Relations.BUILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingBUILD(Node src) { return other(src, singleOutgoing(src, Relations.BUILD)); }
	public static void incomingBUILD(Node src, RelationConsumer consumer) { incoming(src, Relations.BUILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingBUILD(Node src) { return other(src, singleIncoming(src, Relations.BUILD)); }

	public static void outgoingCOMPOSE(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMPOSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMPOSE(Node src) { return other(src, singleOutgoing(src, Relations.COMPOSE)); }
	public static void incomingCOMPOSE(Node src, RelationConsumer consumer) { incoming(src, Relations.COMPOSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMPOSE(Node src) { return other(src, singleIncoming(src, Relations.COMPOSE)); }


	public static Relationship relateDOCKERFILE(Node src, Node dst) { return relate(src, dst, Relations.DOCKERFILE); }
	public static Relationship relateDIRECTORY(Node src, Node dst) { return relate(src, dst, Relations.DIRECTORY); }
	public static Relationship relateDOCKERCOMPOSEFILE(Node src, Node dst) { return relate(src, dst, Relations.DOCKERCOMPOSEFILE); }
	public static Relationship relateBUILD(Node src, Node dst) { return relate(src, dst, Relations.BUILD); }
	public static Relationship relateCOMPOSE(Node src, Node dst) { return relate(src, dst, Relations.COMPOSE); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

}