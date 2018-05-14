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
      Project, Directory, File, STGroup, STTemplate, Node, Visitor
   }

   public enum Relations implements RelationshipType {
      PROJECT, NODE, NAME, DIRECTORY, PATH, CHILD, FILE, FILETYPE, FILENAME, EXTENSION, GENERATOR, TEMPLATE, TEXT, GENERATOR_ROOT, GROUPID, ARTIFACTID, VERSION, DESCRIPTION, ISVERTXPROJECT, RENDERER, CLASSNAME, PACKAGENAME, DIR
   }

   public enum Properties {
      name, path, fileType, filename, extension, text, groupId, artifactId, version, description, isVertxProject, className, packageName, file, dir
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   ProjectDomainPlugin(App app) {
      super(app, "Project");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Project");
		entitiesNodeMap.put(Entities.Project, DomainMotif.newDomainEntity(getGraph(), Entities.Project, domainNode));
		entitiesNodeMap.put(Entities.Directory, DomainMotif.newDomainEntity(getGraph(), Entities.Directory, domainNode));
		entitiesNodeMap.put(Entities.File, DomainMotif.newDomainEntity(getGraph(), Entities.File, domainNode));
		entitiesNodeMap.put(Entities.STGroup, DomainMotif.newDomainEntity(getGraph(), Entities.STGroup, domainNode));
		entitiesNodeMap.put(Entities.STTemplate, DomainMotif.newDomainEntity(getGraph(), Entities.STTemplate, domainNode));
		entitiesNodeMap.put(Entities.Node, DomainMotif.newDomainEntity(getGraph(), Entities.Node, domainNode));
		entitiesNodeMap.put(Entities.Visitor, DomainMotif.newDomainEntity(getGraph(), Entities.Visitor, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.groupId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.artifactId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.version.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.description.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Project), Properties.isVertxProject.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Directory), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Directory), Properties.path.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.fileType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.filename.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.File), Properties.extension.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STGroup), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.text.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Project), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Node), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Project), Relations.DIRECTORY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Project), Relations.GENERATOR.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.STGroup));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Project), Relations.GENERATOR_ROOT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Directory));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Directory), Relations.CHILD.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Directory));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Directory), Relations.FILE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.File));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.STGroup), Relations.TEMPLATE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.STTemplate));
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
		if (isSTGroup(neoNode.getNode())) handleSTGroup(pop, neoNode, selectedNodes);
		if (isSTTemplate(neoNode.getNode())) handleSTTemplate(pop, neoNode, selectedNodes);
		if (isNode(neoNode.getNode())) handleNode(pop, neoNode, selectedNodes);
		if (isVisitor(neoNode.getNode())) handleVisitor(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isProject(neoNode.getNode())) return newProjectEditor(neoNode);
		if (isDirectory(neoNode.getNode())) return newDirectoryEditor(neoNode);
		if (isFile(neoNode.getNode())) return newFileEditor(neoNode);
		if (isSTGroup(neoNode.getNode())) return newSTGroupEditor(neoNode);
		if (isSTTemplate(neoNode.getNode())) return newSTTemplateEditor(neoNode);
		if (isNode(neoNode.getNode())) return newNodeEditor(neoNode);
		if (isVisitor(neoNode.getNode())) return newVisitorEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleProject(JPopupMenu pop, NeoNode projectNode, Set<NeoNode> selectedNodes) { }
	protected void handleDirectory(JPopupMenu pop, NeoNode directoryNode, Set<NeoNode> selectedNodes) { }
	protected void handleFile(JPopupMenu pop, NeoNode fileNode, Set<NeoNode> selectedNodes) { }
	protected void handleSTGroup(JPopupMenu pop, NeoNode sTGroupNode, Set<NeoNode> selectedNodes) { }
	protected void handleSTTemplate(JPopupMenu pop, NeoNode sTTemplateNode, Set<NeoNode> selectedNodes) { }
	protected void handleNode(JPopupMenu pop, NeoNode nodeNode, Set<NeoNode> selectedNodes) { }
	protected void handleVisitor(JPopupMenu pop, NeoNode visitorNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newProjectEditor(NeoNode projectNode) { return null; }
	protected JComponent newDirectoryEditor(NeoNode directoryNode) { return null; }
	protected JComponent newFileEditor(NeoNode fileNode) { return null; }
	protected JComponent newSTGroupEditor(NeoNode sTGroupNode) { return null; }
	protected JComponent newSTTemplateEditor(NeoNode sTTemplateNode) { return null; }
	protected JComponent newNodeEditor(NeoNode nodeNode) { return null; }
	protected JComponent newVisitorEditor(NeoNode visitorNode) { return null; }

	public static boolean isProject(Node node) { return hasLabel(node, Entities.Project); }
	public static boolean isDirectory(Node node) { return hasLabel(node, Entities.Directory); }
	public static boolean isFile(Node node) { return hasLabel(node, Entities.File); }
	public static boolean isSTGroup(Node node) { return hasLabel(node, Entities.STGroup); }
	public static boolean isSTTemplate(Node node) { return hasLabel(node, Entities.STTemplate); }
	public static boolean isNode(Node node) { return hasLabel(node, Entities.Node); }
	public static boolean isVisitor(Node node) { return hasLabel(node, Entities.Visitor); }

	protected Node newProject() { return newProject(getGraph()); } 
	protected Node newProject(Object name, Object groupId, Object artifactId, Object version, Object description, Object isVertxProject) { return newProject(getGraph(), name, groupId, artifactId, version, description, isVertxProject); } 

	public static Node newProject(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Project)); } 
	public static Node newProject(NeoModel graph, Object name, Object groupId, Object artifactId, Object version, Object description, Object isVertxProject) {  	
		final Node newNode = newProject(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (groupId != null) relate(newNode, DomainMotif.newValueNode(graph, groupId), RelationshipType.withName(Properties.groupId.name()));
		if (artifactId != null) relate(newNode, DomainMotif.newValueNode(graph, artifactId), RelationshipType.withName(Properties.artifactId.name()));
		if (version != null) relate(newNode, DomainMotif.newValueNode(graph, version), RelationshipType.withName(Properties.version.name()));
		if (description != null) relate(newNode, DomainMotif.newValueNode(graph, description), RelationshipType.withName(Properties.description.name()));
		if (isVertxProject != null) relate(newNode, DomainMotif.newValueNode(graph, isVertxProject), RelationshipType.withName(Properties.isVertxProject.name())); 	
		return newNode; 
	}
	/* todo
	public Action newProjectAction() {
		return new App.TransactionAction("New Project", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String groupId = com.generator.util.SwingUtil.showInputDialog("groupId", app);
				if (groupId != null && groupId.length() > 0)
					properties.put("groupId", groupId);

			   final String artifactId = com.generator.util.SwingUtil.showInputDialog("artifactId", app);
				if (artifactId != null && artifactId.length() > 0)
					properties.put("artifactId", artifactId);

			   final String version = com.generator.util.SwingUtil.showInputDialog("version", app);
				if (version != null && version.length() > 0)
					properties.put("version", version);

			   final String description = com.generator.util.SwingUtil.showInputDialog("description", app);
				if (description != null && description.length() > 0)
					properties.put("description", description);

			   final String isVertxProject = com.generator.util.SwingUtil.showInputDialog("isVertxProject", app);
				if (isVertxProject != null && isVertxProject.length() > 0)
					properties.put("isVertxProject", isVertxProject);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newDirectory() { return newDirectory(getGraph()); } 
	protected Node newDirectory(Object name, Object path) { return newDirectory(getGraph(), name, path); } 

	public static Node newDirectory(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Directory)); } 
	public static Node newDirectory(NeoModel graph, Object name, Object path) {  	
		final Node newNode = newDirectory(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (path != null) relate(newNode, DomainMotif.newValueNode(graph, path), RelationshipType.withName(Properties.path.name())); 	
		return newNode; 
	}
	/* todo
	public Action newDirectoryAction() {
		return new App.TransactionAction("New Directory", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String path = com.generator.util.SwingUtil.showInputDialog("path", app);
				if (path != null && path.length() > 0)
					properties.put("path", path);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

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
	/* todo
	public Action newFileAction() {
		return new App.TransactionAction("New File", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String fileType = com.generator.util.SwingUtil.showInputDialog("fileType", app);
				if (fileType != null && fileType.length() > 0)
					properties.put("fileType", fileType);

			   final String filename = com.generator.util.SwingUtil.showInputDialog("filename", app);
				if (filename != null && filename.length() > 0)
					properties.put("filename", filename);

			   final String extension = com.generator.util.SwingUtil.showInputDialog("extension", app);
				if (extension != null && extension.length() > 0)
					properties.put("extension", extension);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newSTGroup() { return newSTGroup(getGraph()); } 
	protected Node newSTGroup(Object name) { return newSTGroup(getGraph(), name); } 

	public static Node newSTGroup(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.STGroup)); } 
	public static Node newSTGroup(NeoModel graph, Object name) {  	
		final Node newNode = newSTGroup(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newSTGroupAction() {
		return new App.TransactionAction("New STGroup", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newSTTemplate() { return newSTTemplate(getGraph()); } 
	protected Node newSTTemplate(Object text, Object name) { return newSTTemplate(getGraph(), text, name); } 

	public static Node newSTTemplate(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.STTemplate)); } 
	public static Node newSTTemplate(NeoModel graph, Object text, Object name) {  	
		final Node newNode = newSTTemplate(graph); 	
		if (text != null) relate(newNode, DomainMotif.newValueNode(graph, text), RelationshipType.withName(Properties.text.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newSTTemplateAction() {
		return new App.TransactionAction("New STTemplate", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String text = com.generator.util.SwingUtil.showInputDialog("text", app);
				if (text != null && text.length() > 0)
					properties.put("text", text);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newNode() { return newNode(getGraph()); }
	public static Node newNode(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Node)); }
	/* todo
	public Action newNodeAction() {
		return new App.TransactionAction("New Node", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();

			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newVisitor() { return newVisitor(getGraph()); }
	public static Node newVisitor(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Visitor)); }
	/* todo
	public Action newVisitorAction() {
		return new App.TransactionAction("New Visitor", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();

			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/


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

	public static void outgoingGENERATOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.GENERATOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingGENERATOR(Node src) { return other(src, singleOutgoing(src, Relations.GENERATOR)); }
	public static void incomingGENERATOR(Node src, RelationConsumer consumer) { incoming(src, Relations.GENERATOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingGENERATOR(Node src) { return other(src, singleIncoming(src, Relations.GENERATOR)); }

	public static void outgoingTEMPLATE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEMPLATE(Node src) { return other(src, singleOutgoing(src, Relations.TEMPLATE)); }
	public static void incomingTEMPLATE(Node src, RelationConsumer consumer) { incoming(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEMPLATE(Node src) { return other(src, singleIncoming(src, Relations.TEMPLATE)); }

	public static void outgoingTEXT(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEXT(Node src) { return other(src, singleOutgoing(src, Relations.TEXT)); }
	public static void incomingTEXT(Node src, RelationConsumer consumer) { incoming(src, Relations.TEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEXT(Node src) { return other(src, singleIncoming(src, Relations.TEXT)); }

	public static void outgoingGENERATOR_ROOT(Node src, RelationConsumer consumer) { outgoing(src, Relations.GENERATOR_ROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingGENERATOR_ROOT(Node src) { return other(src, singleOutgoing(src, Relations.GENERATOR_ROOT)); }
	public static void incomingGENERATOR_ROOT(Node src, RelationConsumer consumer) { incoming(src, Relations.GENERATOR_ROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingGENERATOR_ROOT(Node src) { return other(src, singleIncoming(src, Relations.GENERATOR_ROOT)); }

	public static void outgoingGROUPID(Node src, RelationConsumer consumer) { outgoing(src, Relations.GROUPID).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingGROUPID(Node src) { return other(src, singleOutgoing(src, Relations.GROUPID)); }
	public static void incomingGROUPID(Node src, RelationConsumer consumer) { incoming(src, Relations.GROUPID).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingGROUPID(Node src) { return other(src, singleIncoming(src, Relations.GROUPID)); }

	public static void outgoingARTIFACTID(Node src, RelationConsumer consumer) { outgoing(src, Relations.ARTIFACTID).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingARTIFACTID(Node src) { return other(src, singleOutgoing(src, Relations.ARTIFACTID)); }
	public static void incomingARTIFACTID(Node src, RelationConsumer consumer) { incoming(src, Relations.ARTIFACTID).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingARTIFACTID(Node src) { return other(src, singleIncoming(src, Relations.ARTIFACTID)); }

	public static void outgoingVERSION(Node src, RelationConsumer consumer) { outgoing(src, Relations.VERSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVERSION(Node src) { return other(src, singleOutgoing(src, Relations.VERSION)); }
	public static void incomingVERSION(Node src, RelationConsumer consumer) { incoming(src, Relations.VERSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVERSION(Node src) { return other(src, singleIncoming(src, Relations.VERSION)); }

	public static void outgoingDESCRIPTION(Node src, RelationConsumer consumer) { outgoing(src, Relations.DESCRIPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDESCRIPTION(Node src) { return other(src, singleOutgoing(src, Relations.DESCRIPTION)); }
	public static void incomingDESCRIPTION(Node src, RelationConsumer consumer) { incoming(src, Relations.DESCRIPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDESCRIPTION(Node src) { return other(src, singleIncoming(src, Relations.DESCRIPTION)); }

	public static void outgoingISVERTXPROJECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISVERTXPROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISVERTXPROJECT(Node src) { return other(src, singleOutgoing(src, Relations.ISVERTXPROJECT)); }
	public static void incomingISVERTXPROJECT(Node src, RelationConsumer consumer) { incoming(src, Relations.ISVERTXPROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISVERTXPROJECT(Node src) { return other(src, singleIncoming(src, Relations.ISVERTXPROJECT)); }

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
	public static Relationship relateGENERATOR(Node src, Node dst) { return relate(src, dst, Relations.GENERATOR); }
	public static Relationship relateTEMPLATE(Node src, Node dst) { return relate(src, dst, Relations.TEMPLATE); }
	public static Relationship relateTEXT(Node src, Node dst) { return relate(src, dst, Relations.TEXT); }
	public static Relationship relateGENERATOR_ROOT(Node src, Node dst) { return relate(src, dst, Relations.GENERATOR_ROOT); }
	public static Relationship relateGROUPID(Node src, Node dst) { return relate(src, dst, Relations.GROUPID); }
	public static Relationship relateARTIFACTID(Node src, Node dst) { return relate(src, dst, Relations.ARTIFACTID); }
	public static Relationship relateVERSION(Node src, Node dst) { return relate(src, dst, Relations.VERSION); }
	public static Relationship relateDESCRIPTION(Node src, Node dst) { return relate(src, dst, Relations.DESCRIPTION); }
	public static Relationship relateISVERTXPROJECT(Node src, Node dst) { return relate(src, dst, Relations.ISVERTXPROJECT); }
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

	// text
	public static <T> T getTextProperty(PropertyContainer container) { return getTextProperty(container, null); }
	public static <T> T getTextProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.text.name(), defaultValue); }
	public static boolean hasTextProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.text.name()); }
	public static <T extends PropertyContainer> T setTextProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.text.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTextProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.text.name()); return container; }

	protected <T extends PropertyContainer> T setTextProperty(T container, Object value) { setTextProperty(getGraph(), container, value); return container; }

	// groupId
	public static <T> T getGroupIdProperty(PropertyContainer container) { return getGroupIdProperty(container, null); }
	public static <T> T getGroupIdProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.groupId.name(), defaultValue); }
	public static boolean hasGroupIdProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.groupId.name()); }
	public static <T extends PropertyContainer> T setGroupIdProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.groupId.name(), value); return container; }
	public static <T extends PropertyContainer> T removeGroupIdProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.groupId.name()); return container; }

	protected <T extends PropertyContainer> T setGroupIdProperty(T container, Object value) { setGroupIdProperty(getGraph(), container, value); return container; }

	// artifactId
	public static <T> T getArtifactIdProperty(PropertyContainer container) { return getArtifactIdProperty(container, null); }
	public static <T> T getArtifactIdProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.artifactId.name(), defaultValue); }
	public static boolean hasArtifactIdProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.artifactId.name()); }
	public static <T extends PropertyContainer> T setArtifactIdProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.artifactId.name(), value); return container; }
	public static <T extends PropertyContainer> T removeArtifactIdProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.artifactId.name()); return container; }

	protected <T extends PropertyContainer> T setArtifactIdProperty(T container, Object value) { setArtifactIdProperty(getGraph(), container, value); return container; }

	// version
	public static <T> T getVersionProperty(PropertyContainer container) { return getVersionProperty(container, null); }
	public static <T> T getVersionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.version.name(), defaultValue); }
	public static boolean hasVersionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.version.name()); }
	public static <T extends PropertyContainer> T setVersionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.version.name(), value); return container; }
	public static <T extends PropertyContainer> T removeVersionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.version.name()); return container; }

	protected <T extends PropertyContainer> T setVersionProperty(T container, Object value) { setVersionProperty(getGraph(), container, value); return container; }

	// description
	public static <T> T getDescriptionProperty(PropertyContainer container) { return getDescriptionProperty(container, null); }
	public static <T> T getDescriptionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.description.name(), defaultValue); }
	public static boolean hasDescriptionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.description.name()); }
	public static <T extends PropertyContainer> T setDescriptionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.description.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDescriptionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.description.name()); return container; }

	protected <T extends PropertyContainer> T setDescriptionProperty(T container, Object value) { setDescriptionProperty(getGraph(), container, value); return container; }

	// isVertxProject
	public static <T> T getIsVertxProjectProperty(PropertyContainer container) { return getIsVertxProjectProperty(container, null); }
	public static <T> T getIsVertxProjectProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isVertxProject.name(), defaultValue); }
	public static boolean hasIsVertxProjectProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isVertxProject.name()); }
	public static <T extends PropertyContainer> T setIsVertxProjectProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isVertxProject.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsVertxProjectProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isVertxProject.name()); return container; }

	protected <T extends PropertyContainer> T setIsVertxProjectProperty(T container, Object value) { setIsVertxProjectProperty(getGraph(), container, value); return container; }

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