package com.generator.generators.project;

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
 * Auto-generated from domain ProjectDomainPlugin
 */
public abstract class ProjectDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Project, Directory, File, Node, Visitor
   }

   public enum Relations implements RelationshipType {
      PROJECT, NODE, DIRECTORY, CHILD, FILE, RENDERER
   }

   public enum Properties {
      name, path, fileType, filename, extension, file, packageName, className, dir
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   ProjectDomainPlugin(App app) {
      super(app, "Project");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "Project");
		entitiesNodeMap.put(Entities.Project, newDomainEntity(getGraph(), Entities.Project, domainNode));
		entitiesNodeMap.put(Entities.Directory, newDomainEntity(getGraph(), Entities.Directory, domainNode));
		entitiesNodeMap.put(Entities.File, newDomainEntity(getGraph(), Entities.File, domainNode));
		entitiesNodeMap.put(Entities.Node, newDomainEntity(getGraph(), Entities.Node, domainNode));
		entitiesNodeMap.put(Entities.Visitor, newDomainEntity(getGraph(), Entities.Visitor, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Directory), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Directory), Properties.path.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.fileType.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.filename.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.extension.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Project), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Node), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Project), Relations.DIRECTORY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Directory), Relations.CHILD.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Directory), Relations.FILE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.File));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Node), Relations.RENDERER.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Visitor));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isProject(neoNode.getNode())) handleProject(pop, neoNode, selectedNodes);
		if (isDirectory(neoNode.getNode())) handleDirectory(pop, neoNode, selectedNodes);
		if (isFile(neoNode.getNode())) handleFile(pop, neoNode, selectedNodes);
		if (isNode(neoNode.getNode())) handleNode(pop, neoNode, selectedNodes);
		if (isVisitor(neoNode.getNode())) handleVisitor(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isProject(neoNode.getNode())) return newProjectEditor(neoNode);
		if (isDirectory(neoNode.getNode())) return newDirectoryEditor(neoNode);
		if (isFile(neoNode.getNode())) return newFileEditor(neoNode);
		if (isNode(neoNode.getNode())) return newNodeEditor(neoNode);
		if (isVisitor(neoNode.getNode())) return newVisitorEditor(neoNode);
      return null;
   }

	protected void handleProject(JPopupMenu pop, NeoNode projectNode, Set<NeoNode> selectedNodes) { }
	protected void handleDirectory(JPopupMenu pop, NeoNode directoryNode, Set<NeoNode> selectedNodes) { }
	protected void handleFile(JPopupMenu pop, NeoNode fileNode, Set<NeoNode> selectedNodes) { }
	protected void handleNode(JPopupMenu pop, NeoNode nodeNode, Set<NeoNode> selectedNodes) { }
	protected void handleVisitor(JPopupMenu pop, NeoNode visitorNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newProjectEditor(NeoNode projectNode) { return null; }
	protected JComponent newDirectoryEditor(NeoNode directoryNode) { return null; }
	protected JComponent newFileEditor(NeoNode fileNode) { return null; }
	protected JComponent newNodeEditor(NeoNode nodeNode) { return null; }
	protected JComponent newVisitorEditor(NeoNode visitorNode) { return null; }

	public static boolean isProject(Node node) { return hasLabel(node, Entities.Project); }
	public static boolean isDirectory(Node node) { return hasLabel(node, Entities.Directory); }
	public static boolean isFile(Node node) { return hasLabel(node, Entities.File); }
	public static boolean isNode(Node node) { return hasLabel(node, Entities.Node); }
	public static boolean isVisitor(Node node) { return hasLabel(node, Entities.Visitor); }

	protected Node newProject() { return newProject(getGraph()); } 
	public static Node newProject(NeoModel graph) { return newInstanceNode(graph, Entities.Project.name(), entitiesNodeMap.get(Entities.Project)); } 
	protected Node newProject(Object name) { return newProject(getGraph(), name); } 
	public static Node newProject(NeoModel graph, Object name) {  	
		final Node newNode = newProject(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newDirectory() { return newDirectory(getGraph()); } 
	public static Node newDirectory(NeoModel graph) { return newInstanceNode(graph, Entities.Directory.name(), entitiesNodeMap.get(Entities.Directory)); } 
	protected Node newDirectory(Object name, Object path) { return newDirectory(getGraph(), name, path); } 
	public static Node newDirectory(NeoModel graph, Object name, Object path) {  	
		final Node newNode = newDirectory(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (path != null) relate(newNode, newValueNode(graph, path), RelationshipType.withName(Properties.path.name())); 	
		return newNode; 
	}

	protected Node newFile() { return newFile(getGraph()); } 
	public static Node newFile(NeoModel graph) { return newInstanceNode(graph, Entities.File.name(), entitiesNodeMap.get(Entities.File)); } 
	protected Node newFile(Object fileType, Object filename, Object extension) { return newFile(getGraph(), fileType, filename, extension); } 
	public static Node newFile(NeoModel graph, Object fileType, Object filename, Object extension) {  	
		final Node newNode = newFile(graph); 	
		if (fileType != null) relate(newNode, newValueNode(graph, fileType), RelationshipType.withName(Properties.fileType.name()));
		if (filename != null) relate(newNode, newValueNode(graph, filename), RelationshipType.withName(Properties.filename.name()));
		if (extension != null) relate(newNode, newValueNode(graph, extension), RelationshipType.withName(Properties.extension.name())); 	
		return newNode; 
	}

	protected Node newNode() { return newNode(getGraph()); } 
	public static Node newNode(NeoModel graph) { return newInstanceNode(graph, Entities.Node.name(), entitiesNodeMap.get(Entities.Node)); }

	protected Node newVisitor() { return newVisitor(getGraph()); } 
	public static Node newVisitor(NeoModel graph) { return newInstanceNode(graph, Entities.Visitor.name(), entitiesNodeMap.get(Entities.Visitor)); }


	public static void outgoingPROJECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROJECT(Node src) { return other(src, singleOutgoing(src, Relations.PROJECT)); }
	public static void incomingPROJECT(Node src, RelationConsumer consumer) { incoming(src, Relations.PROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROJECT(Node src) { return other(src, singleIncoming(src, Relations.PROJECT)); }

	public static void outgoingNODE(Node src, RelationConsumer consumer) { outgoing(src, Relations.NODE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNODE(Node src) { return other(src, singleOutgoing(src, Relations.NODE)); }
	public static void incomingNODE(Node src, RelationConsumer consumer) { incoming(src, Relations.NODE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNODE(Node src) { return other(src, singleIncoming(src, Relations.NODE)); }

	public static void outgoingDIRECTORY(Node src, RelationConsumer consumer) { outgoing(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDIRECTORY(Node src) { return other(src, singleOutgoing(src, Relations.DIRECTORY)); }
	public static void incomingDIRECTORY(Node src, RelationConsumer consumer) { incoming(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDIRECTORY(Node src) { return other(src, singleIncoming(src, Relations.DIRECTORY)); }

	public static void outgoingCHILD(Node src, RelationConsumer consumer) { outgoing(src, Relations.CHILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCHILD(Node src) { return other(src, singleOutgoing(src, Relations.CHILD)); }
	public static void incomingCHILD(Node src, RelationConsumer consumer) { incoming(src, Relations.CHILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCHILD(Node src) { return other(src, singleIncoming(src, Relations.CHILD)); }

	public static void outgoingFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFILE(Node src) { return other(src, singleOutgoing(src, Relations.FILE)); }
	public static void incomingFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFILE(Node src) { return other(src, singleIncoming(src, Relations.FILE)); }

	public static void outgoingRENDERER(Node src, RelationConsumer consumer) { outgoing(src, Relations.RENDERER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRENDERER(Node src) { return other(src, singleOutgoing(src, Relations.RENDERER)); }
	public static void incomingRENDERER(Node src, RelationConsumer consumer) { incoming(src, Relations.RENDERER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRENDERER(Node src) { return other(src, singleIncoming(src, Relations.RENDERER)); }


	public static Relationship relatePROJECT(Node src, Node dst) { return relate(src, dst, Relations.PROJECT); }
	public static Relationship relateNODE(Node src, Node dst) { return relate(src, dst, Relations.NODE); }
	public static Relationship relateDIRECTORY(Node src, Node dst) { return relate(src, dst, Relations.DIRECTORY); }
	public static Relationship relateCHILD(Node src, Node dst) { return relate(src, dst, Relations.CHILD); }
	public static Relationship relateFILE(Node src, Node dst) { return relate(src, dst, Relations.FILE); }
	public static Relationship relateRENDERER(Node src, Node dst) { return relate(src, dst, Relations.RENDERER); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	// path
	public static <T> T getPathProperty(PropertyContainer container) { return getEntityProperty(container, Properties.path.name()); }
	public static <T> T getPathProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.path.name(), defaultValue); }
	public static boolean hasPathProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.path.name()); }
	public static <T extends PropertyContainer> T setPathProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.path.name(), value); return container; }
	protected <T extends PropertyContainer> T setPathProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.path.name(), value); return container; }
	public static <T extends PropertyContainer> T removePathProperty(T container) { removeEntityProperty(container, Properties.path.name()); return container; }

	// fileType
	public static <T> T getFileTypeProperty(PropertyContainer container) { return getEntityProperty(container, Properties.fileType.name()); }
	public static <T> T getFileTypeProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.fileType.name(), defaultValue); }
	public static boolean hasFileTypeProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.fileType.name()); }
	public static <T extends PropertyContainer> T setFileTypeProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.fileType.name(), value); return container; }
	protected <T extends PropertyContainer> T setFileTypeProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.fileType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFileTypeProperty(T container) { removeEntityProperty(container, Properties.fileType.name()); return container; }

	// filename
	public static <T> T getFilenameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.filename.name()); }
	public static <T> T getFilenameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.filename.name(), defaultValue); }
	public static boolean hasFilenameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.filename.name()); }
	public static <T extends PropertyContainer> T setFilenameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.filename.name(), value); return container; }
	protected <T extends PropertyContainer> T setFilenameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.filename.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFilenameProperty(T container) { removeEntityProperty(container, Properties.filename.name()); return container; }

	// extension
	public static <T> T getExtensionProperty(PropertyContainer container) { return getEntityProperty(container, Properties.extension.name()); }
	public static <T> T getExtensionProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.extension.name(), defaultValue); }
	public static boolean hasExtensionProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.extension.name()); }
	public static <T extends PropertyContainer> T setExtensionProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.extension.name(), value); return container; }
	protected <T extends PropertyContainer> T setExtensionProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.extension.name(), value); return container; }
	public static <T extends PropertyContainer> T removeExtensionProperty(T container) { removeEntityProperty(container, Properties.extension.name()); return container; }

	// file
	public static <T> T getFileProperty(PropertyContainer container) { return getEntityProperty(container, Properties.file.name()); }
	public static <T> T getFileProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.file.name(), defaultValue); }
	public static boolean hasFileProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.file.name()); }
	public static <T extends PropertyContainer> T setFileProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.file.name(), value); return container; }
	protected <T extends PropertyContainer> T setFileProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.file.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFileProperty(T container) { removeEntityProperty(container, Properties.file.name()); return container; }

	// packageName
	public static <T> T getPackageNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.packageName.name()); }
	public static <T> T getPackageNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.packageName.name(), defaultValue); }
	public static boolean hasPackageNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.packageName.name(), value); return container; }
	protected <T extends PropertyContainer> T setPackageNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.packageName.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackageNameProperty(T container) { removeEntityProperty(container, Properties.packageName.name()); return container; }

	// className
	public static <T> T getClassNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.className.name()); }
	public static <T> T getClassNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.className.name(), defaultValue); }
	public static boolean hasClassNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.className.name()); }
	public static <T extends PropertyContainer> T setClassNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.className.name(), value); return container; }
	protected <T extends PropertyContainer> T setClassNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.className.name(), value); return container; }
	public static <T extends PropertyContainer> T removeClassNameProperty(T container) { removeEntityProperty(container, Properties.className.name()); return container; }

	// dir
	public static <T> T getDirProperty(PropertyContainer container) { return getEntityProperty(container, Properties.dir.name()); }
	public static <T> T getDirProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.dir.name(), defaultValue); }
	public static boolean hasDirProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.dir.name()); }
	public static <T extends PropertyContainer> T setDirProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.dir.name(), value); return container; }
	protected <T extends PropertyContainer> T setDirProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.dir.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDirProperty(T container) { removeEntityProperty(container, Properties.dir.name()); return container; }

}