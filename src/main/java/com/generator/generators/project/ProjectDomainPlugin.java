package com.generator.generators.project;

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
 * Auto-generated from domain ProjectDomainPlugin
 */
abstract class ProjectDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Project, Directory, File, generators, Visitor, Entity
   }

   public enum Relations implements RelationshipType {
      DIRECTORY, CHILD, FILE, generators, VISITOR, RENDERER
   }

   public enum Properties {
      name, path, fileType, filename, extension, packageName, version, artifactId, groupId, root, comments, className, file, dir
   }

   ProjectDomainPlugin(App app) {
      super(app, "Project");
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
		if (isgenerators(neoNode.getNode())) handlegenerators(pop, neoNode, selectedNodes);
		if (isVisitor(neoNode.getNode())) handleVisitor(pop, neoNode, selectedNodes);
		if (isEntity(neoNode.getNode())) handleEntity(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isProject(neoNode.getNode())) return newProjectEditor(neoNode);
		if (isDirectory(neoNode.getNode())) return newDirectoryEditor(neoNode);
		if (isFile(neoNode.getNode())) return newFileEditor(neoNode);
		if (isgenerators(neoNode.getNode())) return newgeneratorsEditor(neoNode);
		if (isVisitor(neoNode.getNode())) return newVisitorEditor(neoNode);
		if (isEntity(neoNode.getNode())) return newEntityEditor(neoNode);
      return null;
   }

	protected void handleProject(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleDirectory(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleFile(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handlegenerators(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleVisitor(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleEntity(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newProjectEditor(NeoNode neoNode) { return null; }
	protected JComponent newDirectoryEditor(NeoNode neoNode) { return null; }
	protected JComponent newFileEditor(NeoNode neoNode) { return null; }
	protected JComponent newgeneratorsEditor(NeoNode neoNode) { return null; }
	protected JComponent newVisitorEditor(NeoNode neoNode) { return null; }
	protected JComponent newEntityEditor(NeoNode neoNode) { return null; }

	protected Node newProject(String name) { return newProject(getGraph(), name); }
	protected Node newProject() { return newProject(getGraph()); } 
	protected Node newDirectory(String name) { return newDirectory(getGraph(), name); }
	protected Node newDirectory() { return newDirectory(getGraph()); } 
	protected Node newFile(String name) { return newFile(getGraph(), name); }
	protected Node newFile() { return newFile(getGraph()); } 
	protected Node newgenerators(String name) { return newgenerators(getGraph(), name); }
	protected Node newgenerators() { return newgenerators(getGraph()); } 
	protected Node newVisitor(String name) { return newVisitor(getGraph(), name); }
	protected Node newVisitor() { return newVisitor(getGraph()); } 
	protected Node newEntity(String name) { return newEntity(getGraph(), name); }
	protected Node newEntity() { return newEntity(getGraph()); } 

	public static boolean isProject(Node node) { return hasLabel(node, Entities.Project); }
	public static boolean isDirectory(Node node) { return hasLabel(node, Entities.Directory); }
	public static boolean isFile(Node node) { return hasLabel(node, Entities.File); }
	public static boolean isgenerators(Node node) { return hasLabel(node, Entities.generators); }
	public static boolean isVisitor(Node node) { return hasLabel(node, Entities.Visitor); }
	public static boolean isEntity(Node node) { return hasLabel(node, Entities.Entity); }

	public static Node newProject(NeoModel graph, String name) { return graph.newNode(Entities.Project, AppMotif.Properties.name.name(), name); }
	public static Node newProject(NeoModel graph) { return graph.newNode(Entities.Project); }
	public static Node newDirectory(NeoModel graph, String name) { return graph.newNode(Entities.Directory, AppMotif.Properties.name.name(), name); }
	public static Node newDirectory(NeoModel graph) { return graph.newNode(Entities.Directory); }
	public static Node newFile(NeoModel graph, String name) { return graph.newNode(Entities.File, AppMotif.Properties.name.name(), name); }
	public static Node newFile(NeoModel graph) { return graph.newNode(Entities.File); }
	public static Node newgenerators(NeoModel graph, String name) { return graph.newNode(Entities.generators, AppMotif.Properties.name.name(), name); }
	public static Node newgenerators(NeoModel graph) { return graph.newNode(Entities.generators); }
	public static Node newVisitor(NeoModel graph, String name) { return graph.newNode(Entities.Visitor, AppMotif.Properties.name.name(), name); }
	public static Node newVisitor(NeoModel graph) { return graph.newNode(Entities.Visitor); }
	public static Node newEntity(NeoModel graph, String name) { return graph.newNode(Entities.Entity, AppMotif.Properties.name.name(), name); }
	public static Node newEntity(NeoModel graph) { return graph.newNode(Entities.Entity); }

	public static void outgoingDIRECTORY(Node src, RelationConsumer consumer) { outgoing(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingDIRECTORY(Node src, RelationConsumer consumer) { incoming(src, Relations.DIRECTORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingCHILD(Node src, RelationConsumer consumer) { outgoing(src, Relations.CHILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingCHILD(Node src, RelationConsumer consumer) { incoming(src, Relations.CHILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoinggenerators(Node src, RelationConsumer consumer) { outgoing(src, Relations.generators).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incominggenerators(Node src, RelationConsumer consumer) { incoming(src, Relations.generators).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingVISITOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingVISITOR(Node src, RelationConsumer consumer) { incoming(src, Relations.VISITOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingRENDERER(Node src, RelationConsumer consumer) { outgoing(src, Relations.RENDERER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingRENDERER(Node src, RelationConsumer consumer) { incoming(src, Relations.RENDERER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }

	public static Relationship relateDIRECTORY(Node src, Node dst) { return relate(src, dst, Relations.DIRECTORY); }
	public static Relationship relateCHILD(Node src, Node dst) { return relate(src, dst, Relations.CHILD); }
	public static Relationship relateFILE(Node src, Node dst) { return relate(src, dst, Relations.FILE); }
	public static Relationship relategenerators(Node src, Node dst) { return relate(src, dst, Relations.generators); }
	public static Relationship relateVISITOR(Node src, Node dst) { return relate(src, dst, Relations.VISITOR); }
	public static Relationship relateRENDERER(Node src, Node dst) { return relate(src, dst, Relations.RENDERER); }

	public static String getName(Node node) { return DomainMotif.getName(node); }
	public static String getName(NeoNode neoNode) { return DomainMotif.getName(neoNode); }

	public static <T> T getName(PropertyContainer container) { return get(container, Properties.name.name()); }
	public static <T> T getName(PropertyContainer container, T defaultValue) { return has(container, Properties.name.name()) ? get(container, Properties.name.name()) : defaultValue; }
	public static boolean hasName(PropertyContainer container) { return has(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setName(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.name.name());
	   else
	   	container.setProperty(Properties.name.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeName(T container) {
		if (has(container, Properties.name.name())) container.removeProperty(Properties.name.name());
	      return container;
	}

	public static <T> T getPath(PropertyContainer container) { return get(container, Properties.path.name()); }
	public static <T> T getPath(PropertyContainer container, T defaultValue) { return has(container, Properties.path.name()) ? get(container, Properties.path.name()) : defaultValue; }
	public static boolean hasPath(PropertyContainer container) { return has(container, Properties.path.name()); }
	public static <T extends PropertyContainer> T setPath(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.path.name());
	   else
	   	container.setProperty(Properties.path.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removePath(T container) {
		if (has(container, Properties.path.name())) container.removeProperty(Properties.path.name());
	      return container;
	}

	public static <T> T getFileType(PropertyContainer container) { return get(container, Properties.fileType.name()); }
	public static <T> T getFileType(PropertyContainer container, T defaultValue) { return has(container, Properties.fileType.name()) ? get(container, Properties.fileType.name()) : defaultValue; }
	public static boolean hasFileType(PropertyContainer container) { return has(container, Properties.fileType.name()); }
	public static <T extends PropertyContainer> T setFileType(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.fileType.name());
	   else
	   	container.setProperty(Properties.fileType.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeFileType(T container) {
		if (has(container, Properties.fileType.name())) container.removeProperty(Properties.fileType.name());
	      return container;
	}

	public static <T> T getFilename(PropertyContainer container) { return get(container, Properties.filename.name()); }
	public static <T> T getFilename(PropertyContainer container, T defaultValue) { return has(container, Properties.filename.name()) ? get(container, Properties.filename.name()) : defaultValue; }
	public static boolean hasFilename(PropertyContainer container) { return has(container, Properties.filename.name()); }
	public static <T extends PropertyContainer> T setFilename(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.filename.name());
	   else
	   	container.setProperty(Properties.filename.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeFilename(T container) {
		if (has(container, Properties.filename.name())) container.removeProperty(Properties.filename.name());
	      return container;
	}

	public static <T> T getExtension(PropertyContainer container) { return get(container, Properties.extension.name()); }
	public static <T> T getExtension(PropertyContainer container, T defaultValue) { return has(container, Properties.extension.name()) ? get(container, Properties.extension.name()) : defaultValue; }
	public static boolean hasExtension(PropertyContainer container) { return has(container, Properties.extension.name()); }
	public static <T extends PropertyContainer> T setExtension(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.extension.name());
	   else
	   	container.setProperty(Properties.extension.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeExtension(T container) {
		if (has(container, Properties.extension.name())) container.removeProperty(Properties.extension.name());
	      return container;
	}

	public static <T> T getPackageName(PropertyContainer container) { return get(container, Properties.packageName.name()); }
	public static <T> T getPackageName(PropertyContainer container, T defaultValue) { return has(container, Properties.packageName.name()) ? get(container, Properties.packageName.name()) : defaultValue; }
	public static boolean hasPackageName(PropertyContainer container) { return has(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageName(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.packageName.name());
	   else
	   	container.setProperty(Properties.packageName.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removePackageName(T container) {
		if (has(container, Properties.packageName.name())) container.removeProperty(Properties.packageName.name());
	      return container;
	}

	public static <T> T getVersion(PropertyContainer container) { return get(container, Properties.version.name()); }
	public static <T> T getVersion(PropertyContainer container, T defaultValue) { return has(container, Properties.version.name()) ? get(container, Properties.version.name()) : defaultValue; }
	public static boolean hasVersion(PropertyContainer container) { return has(container, Properties.version.name()); }
	public static <T extends PropertyContainer> T setVersion(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.version.name());
	   else
	   	container.setProperty(Properties.version.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeVersion(T container) {
		if (has(container, Properties.version.name())) container.removeProperty(Properties.version.name());
	      return container;
	}

	public static <T> T getArtifactId(PropertyContainer container) { return get(container, Properties.artifactId.name()); }
	public static <T> T getArtifactId(PropertyContainer container, T defaultValue) { return has(container, Properties.artifactId.name()) ? get(container, Properties.artifactId.name()) : defaultValue; }
	public static boolean hasArtifactId(PropertyContainer container) { return has(container, Properties.artifactId.name()); }
	public static <T extends PropertyContainer> T setArtifactId(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.artifactId.name());
	   else
	   	container.setProperty(Properties.artifactId.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeArtifactId(T container) {
		if (has(container, Properties.artifactId.name())) container.removeProperty(Properties.artifactId.name());
	      return container;
	}

	public static <T> T getGroupId(PropertyContainer container) { return get(container, Properties.groupId.name()); }
	public static <T> T getGroupId(PropertyContainer container, T defaultValue) { return has(container, Properties.groupId.name()) ? get(container, Properties.groupId.name()) : defaultValue; }
	public static boolean hasGroupId(PropertyContainer container) { return has(container, Properties.groupId.name()); }
	public static <T extends PropertyContainer> T setGroupId(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.groupId.name());
	   else
	   	container.setProperty(Properties.groupId.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeGroupId(T container) {
		if (has(container, Properties.groupId.name())) container.removeProperty(Properties.groupId.name());
	      return container;
	}

	public static <T> T getRoot(PropertyContainer container) { return get(container, Properties.root.name()); }
	public static <T> T getRoot(PropertyContainer container, T defaultValue) { return has(container, Properties.root.name()) ? get(container, Properties.root.name()) : defaultValue; }
	public static boolean hasRoot(PropertyContainer container) { return has(container, Properties.root.name()); }
	public static <T extends PropertyContainer> T setRoot(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.root.name());
	   else
	   	container.setProperty(Properties.root.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeRoot(T container) {
		if (has(container, Properties.root.name())) container.removeProperty(Properties.root.name());
	      return container;
	}

	public static <T> T getComments(PropertyContainer container) { return get(container, Properties.comments.name()); }
	public static <T> T getComments(PropertyContainer container, T defaultValue) { return has(container, Properties.comments.name()) ? get(container, Properties.comments.name()) : defaultValue; }
	public static boolean hasComments(PropertyContainer container) { return has(container, Properties.comments.name()); }
	public static <T extends PropertyContainer> T setComments(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.comments.name());
	   else
	   	container.setProperty(Properties.comments.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeComments(T container) {
		if (has(container, Properties.comments.name())) container.removeProperty(Properties.comments.name());
	      return container;
	}

	public static <T> T getClassName(PropertyContainer container) { return get(container, Properties.className.name()); }
	public static <T> T getClassName(PropertyContainer container, T defaultValue) { return has(container, Properties.className.name()) ? get(container, Properties.className.name()) : defaultValue; }
	public static boolean hasClassName(PropertyContainer container) { return has(container, Properties.className.name()); }
	public static <T extends PropertyContainer> T setClassName(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.className.name());
	   else
	   	container.setProperty(Properties.className.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeClassName(T container) {
		if (has(container, Properties.className.name())) container.removeProperty(Properties.className.name());
	      return container;
	}

	public static <T> T getFile(PropertyContainer container) { return get(container, Properties.file.name()); }
	public static <T> T getFile(PropertyContainer container, T defaultValue) { return has(container, Properties.file.name()) ? get(container, Properties.file.name()) : defaultValue; }
	public static boolean hasFile(PropertyContainer container) { return has(container, Properties.file.name()); }
	public static <T extends PropertyContainer> T setFile(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.file.name());
	   else
	   	container.setProperty(Properties.file.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeFile(T container) {
		if (has(container, Properties.file.name())) container.removeProperty(Properties.file.name());
	      return container;
	}

	public static <T> T getDir(PropertyContainer container) { return get(container, Properties.dir.name()); }
	public static <T> T getDir(PropertyContainer container, T defaultValue) { return has(container, Properties.dir.name()) ? get(container, Properties.dir.name()) : defaultValue; }
	public static boolean hasDir(PropertyContainer container) { return has(container, Properties.dir.name()); }
	public static <T extends PropertyContainer> T setDir(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.dir.name());
	   else
	   	container.setProperty(Properties.dir.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeDir(T container) {
		if (has(container, Properties.dir.name())) container.removeProperty(Properties.dir.name());
	      return container;
	}

}