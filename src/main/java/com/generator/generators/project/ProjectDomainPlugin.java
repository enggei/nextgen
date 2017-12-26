package com.generator.generators.project;

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
 * Auto-generated from domain ProjectDomainPlugin
 */
public abstract class ProjectDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ProjectDomainPlugin.class);

	public enum Entities implements Label {
      Project, Directory, File, Node, Visitor
   }

   public enum Relations implements RelationshipType {
      PROJECT, NODE, NAME, DIRECTORY, PATH, CHILD, FILE, FILETYPE, FILENAME, EXTENSION, RENDERER, CLASSNAME, PACKAGENAME, DIR
   }

   public enum Properties {
      name, path, fileType, filename, extension, className, packageName, file, dir
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   ProjectDomainPlugin(App app) {
      super(app, "Project");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Project");
		entitiesNodeMap.put(Entities.Project, DomainMotif.newDomainEntity(getGraph(), Entities.Project, domainNode));
		entitiesNodeMap.put(Entities.Directory, DomainMotif.newDomainEntity(getGraph(), Entities.Directory, domainNode));
		entitiesNodeMap.put(Entities.File, DomainMotif.newDomainEntity(getGraph(), Entities.File, domainNode));
		entitiesNodeMap.put(Entities.Node, DomainMotif.newDomainEntity(getGraph(), Entities.Node, domainNode));
		entitiesNodeMap.put(Entities.Visitor, DomainMotif.newDomainEntity(getGraph(), Entities.Visitor, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Directory), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Directory), Properties.path.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.fileType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.filename.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.extension.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Project), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Node), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Project), Relations.DIRECTORY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Directory), Relations.CHILD.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Directory), Relations.FILE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.File));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Node), Relations.RENDERER.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Visitor));
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

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

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
	protected Node newProject(Object name) { return newProject(getGraph(), name); } 

	public static Node newProject(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Project)); } 
	public static Node newProject(NeoModel graph, Object name) {  	
		final Node newNode = newProject(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newDirectory() { return newDirectory(getGraph()); } 
	protected Node newDirectory(Object name, Object path) { return newDirectory(getGraph(), name, path); } 

	public static Node newDirectory(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Directory)); } 
	public static Node newDirectory(NeoModel graph, Object name, Object path) {  	
		final Node newNode = newDirectory(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (path != null) relate(newNode, DomainMotif.newValueNode(graph, path), RelationshipType.withName(Properties.path.name())); 	
		return newNode; 
	}

	protected Node newFile() { return newFile(getGraph()); } 
	protected Node newFile(Object fileType, Object filename, Object extension) { return newFile(getGraph(), fileType, filename, extension); } 

	public static Node newFile(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.File)); } 
	public static Node newFile(NeoModel graph, Object fileType, Object filename, Object extension) {  	
		final Node newNode = newFile(graph); 	
		if (fileType != null) relate(newNode, DomainMotif.newValueNode(graph, fileType), RelationshipType.withName(Properties.fileType.name()));
		if (filename != null) relate(newNode, DomainMotif.newValueNode(graph, filename), RelationshipType.withName(Properties.filename.name()));
		if (extension != null) relate(newNode, DomainMotif.newValueNode(graph, extension), RelationshipType.withName(Properties.extension.name())); 	
		return newNode; 
	}

	protected Node newNode() { return newNode(getGraph()); }
	public static Node newNode(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Node)); }

	protected Node newVisitor() { return newVisitor(getGraph()); }
	public static Node newVisitor(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Visitor)); }


	public static void outgoingPROJECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROJECT(Node src) { return other(src, singleOutgoing(src, Relations.PROJECT)); }
	public static void incomingPROJECT(Node src, RelationConsumer consumer) { incoming(src, Relations.PROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROJECT(Node src) { return other(src, singleIncoming(src, Relations.PROJECT)); }

	public static void outgoingNODE(Node src, RelationConsumer consumer) { outgoing(src, Relations.NODE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNODE(Node src) { return other(src, singleOutgoing(src, Relations.NODE)); }
	public static void incomingNODE(Node src, RelationConsumer consumer) { incoming(src, Relations.NODE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNODE(Node src) { return other(src, singleIncoming(src, Relations.NODE)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingDIRECTORY(Node src, RelationConsumer consumer) { outgoing(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDIRECTORY(Node src) { return other(src, singleOutgoing(src, Relations.DIRECTORY)); }
	public static void incomingDIRECTORY(Node src, RelationConsumer consumer) { incoming(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDIRECTORY(Node src) { return other(src, singleIncoming(src, Relations.DIRECTORY)); }

	public static void outgoingPATH(Node src, RelationConsumer consumer) { outgoing(src, Relations.PATH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPATH(Node src) { return other(src, singleOutgoing(src, Relations.PATH)); }
	public static void incomingPATH(Node src, RelationConsumer consumer) { incoming(src, Relations.PATH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPATH(Node src) { return other(src, singleIncoming(src, Relations.PATH)); }

	public static void outgoingCHILD(Node src, RelationConsumer consumer) { outgoing(src, Relations.CHILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCHILD(Node src) { return other(src, singleOutgoing(src, Relations.CHILD)); }
	public static void incomingCHILD(Node src, RelationConsumer consumer) { incoming(src, Relations.CHILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCHILD(Node src) { return other(src, singleIncoming(src, Relations.CHILD)); }

	public static void outgoingFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFILE(Node src) { return other(src, singleOutgoing(src, Relations.FILE)); }
	public static void incomingFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFILE(Node src) { return other(src, singleIncoming(src, Relations.FILE)); }

	public static void outgoingFILETYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.FILETYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFILETYPE(Node src) { return other(src, singleOutgoing(src, Relations.FILETYPE)); }
	public static void incomingFILETYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.FILETYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFILETYPE(Node src) { return other(src, singleIncoming(src, Relations.FILETYPE)); }

	public static void outgoingFILENAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.FILENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFILENAME(Node src) { return other(src, singleOutgoing(src, Relations.FILENAME)); }
	public static void incomingFILENAME(Node src, RelationConsumer consumer) { incoming(src, Relations.FILENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFILENAME(Node src) { return other(src, singleIncoming(src, Relations.FILENAME)); }

	public static void outgoingEXTENSION(Node src, RelationConsumer consumer) { outgoing(src, Relations.EXTENSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEXTENSION(Node src) { return other(src, singleOutgoing(src, Relations.EXTENSION)); }
	public static void incomingEXTENSION(Node src, RelationConsumer consumer) { incoming(src, Relations.EXTENSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEXTENSION(Node src) { return other(src, singleIncoming(src, Relations.EXTENSION)); }

	public static void outgoingRENDERER(Node src, RelationConsumer consumer) { outgoing(src, Relations.RENDERER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRENDERER(Node src) { return other(src, singleOutgoing(src, Relations.RENDERER)); }
	public static void incomingRENDERER(Node src, RelationConsumer consumer) { incoming(src, Relations.RENDERER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRENDERER(Node src) { return other(src, singleIncoming(src, Relations.RENDERER)); }

	public static void outgoingCLASSNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.CLASSNAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCLASSNAME(Node src) { return other(src, singleOutgoing(src, Relations.CLASSNAME)); }
	public static void incomingCLASSNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.CLASSNAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCLASSNAME(Node src) { return other(src, singleIncoming(src, Relations.CLASSNAME)); }

	public static void outgoingPACKAGENAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPACKAGENAME(Node src) { return other(src, singleOutgoing(src, Relations.PACKAGENAME)); }
	public static void incomingPACKAGENAME(Node src, RelationConsumer consumer) { incoming(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPACKAGENAME(Node src) { return other(src, singleIncoming(src, Relations.PACKAGENAME)); }

	public static void outgoingDIR(Node src, RelationConsumer consumer) { outgoing(src, Relations.DIR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDIR(Node src) { return other(src, singleOutgoing(src, Relations.DIR)); }
	public static void incomingDIR(Node src, RelationConsumer consumer) { incoming(src, Relations.DIR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDIR(Node src) { return other(src, singleIncoming(src, Relations.DIR)); }


	public static Relationship relatePROJECT(Node src, Node dst) { return relate(src, dst, Relations.PROJECT); }
	public static Relationship relateNODE(Node src, Node dst) { return relate(src, dst, Relations.NODE); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateDIRECTORY(Node src, Node dst) { return relate(src, dst, Relations.DIRECTORY); }
	public static Relationship relatePATH(Node src, Node dst) { return relate(src, dst, Relations.PATH); }
	public static Relationship relateCHILD(Node src, Node dst) { return relate(src, dst, Relations.CHILD); }
	public static Relationship relateFILE(Node src, Node dst) { return relate(src, dst, Relations.FILE); }
	public static Relationship relateFILETYPE(Node src, Node dst) { return relate(src, dst, Relations.FILETYPE); }
	public static Relationship relateFILENAME(Node src, Node dst) { return relate(src, dst, Relations.FILENAME); }
	public static Relationship relateEXTENSION(Node src, Node dst) { return relate(src, dst, Relations.EXTENSION); }
	public static Relationship relateRENDERER(Node src, Node dst) { return relate(src, dst, Relations.RENDERER); }
	public static Relationship relateCLASSNAME(Node src, Node dst) { return relate(src, dst, Relations.CLASSNAME); }
	public static Relationship relatePACKAGENAME(Node src, Node dst) { return relate(src, dst, Relations.PACKAGENAME); }
	public static Relationship relateDIR(Node src, Node dst) { return relate(src, dst, Relations.DIR); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// path
	public static <T> T getPathProperty(PropertyContainer container) { return getPathProperty(container, null); }
	public static <T> T getPathProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.path.name(), defaultValue); }
	public static boolean hasPathProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.path.name()); }
	public static <T extends PropertyContainer> T setPathProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.path.name(), value); return container; }
	public static <T extends PropertyContainer> T removePathProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.path.name()); return container; }

	protected <T extends PropertyContainer> T setPathProperty(T container, Object value) { setPathProperty(getGraph(), container, value); return container; }

	// fileType
	public static <T> T getFileTypeProperty(PropertyContainer container) { return getFileTypeProperty(container, null); }
	public static <T> T getFileTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.fileType.name(), defaultValue); }
	public static boolean hasFileTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.fileType.name()); }
	public static <T extends PropertyContainer> T setFileTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.fileType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFileTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.fileType.name()); return container; }

	protected <T extends PropertyContainer> T setFileTypeProperty(T container, Object value) { setFileTypeProperty(getGraph(), container, value); return container; }

	// filename
	public static <T> T getFilenameProperty(PropertyContainer container) { return getFilenameProperty(container, null); }
	public static <T> T getFilenameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.filename.name(), defaultValue); }
	public static boolean hasFilenameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.filename.name()); }
	public static <T extends PropertyContainer> T setFilenameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.filename.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFilenameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.filename.name()); return container; }

	protected <T extends PropertyContainer> T setFilenameProperty(T container, Object value) { setFilenameProperty(getGraph(), container, value); return container; }

	// extension
	public static <T> T getExtensionProperty(PropertyContainer container) { return getExtensionProperty(container, null); }
	public static <T> T getExtensionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.extension.name(), defaultValue); }
	public static boolean hasExtensionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.extension.name()); }
	public static <T extends PropertyContainer> T setExtensionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.extension.name(), value); return container; }
	public static <T extends PropertyContainer> T removeExtensionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.extension.name()); return container; }

	protected <T extends PropertyContainer> T setExtensionProperty(T container, Object value) { setExtensionProperty(getGraph(), container, value); return container; }

	// className
	public static <T> T getClassNameProperty(PropertyContainer container) { return getClassNameProperty(container, null); }
	public static <T> T getClassNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.className.name(), defaultValue); }
	public static boolean hasClassNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.className.name()); }
	public static <T extends PropertyContainer> T setClassNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.className.name(), value); return container; }
	public static <T extends PropertyContainer> T removeClassNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.className.name()); return container; }

	protected <T extends PropertyContainer> T setClassNameProperty(T container, Object value) { setClassNameProperty(getGraph(), container, value); return container; }

	// packageName
	public static <T> T getPackageNameProperty(PropertyContainer container) { return getPackageNameProperty(container, null); }
	public static <T> T getPackageNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.packageName.name(), defaultValue); }
	public static boolean hasPackageNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.packageName.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackageNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.packageName.name()); return container; }

	protected <T extends PropertyContainer> T setPackageNameProperty(T container, Object value) { setPackageNameProperty(getGraph(), container, value); return container; }

	// file
	public static <T> T getFileProperty(PropertyContainer container) { return getFileProperty(container, null); }
	public static <T> T getFileProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.file.name(), defaultValue); }
	public static boolean hasFileProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.file.name()); }
	public static <T extends PropertyContainer> T setFileProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.file.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFileProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.file.name()); return container; }

	protected <T extends PropertyContainer> T setFileProperty(T container, Object value) { setFileProperty(getGraph(), container, value); return container; }

	// dir
	public static <T> T getDirProperty(PropertyContainer container) { return getDirProperty(container, null); }
	public static <T> T getDirProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.dir.name(), defaultValue); }
	public static boolean hasDirProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.dir.name()); }
	public static <T extends PropertyContainer> T setDirProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.dir.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDirProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.dir.name()); return container; }

	protected <T extends PropertyContainer> T setDirProperty(T container, Object value) { setDirProperty(getGraph(), container, value); return container; }

}