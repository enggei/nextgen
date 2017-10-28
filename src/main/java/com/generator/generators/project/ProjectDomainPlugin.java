package com.generator.generators.project;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
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
      super(app, "ProjectDomainPlugin");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if(hasLabel(neoNode.getNode(), Entities.Project)) handleProject(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.Directory)) handleDirectory(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.File)) handleFile(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.generators)) handlegenerators(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.Visitor)) handleVisitor(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.Entity)) handleEntity(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if(hasLabel(neoNode.getNode(), Entities.Project)) return newProjectEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.Directory)) return newDirectoryEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.File)) return newFileEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.generators)) return newgeneratorsEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.Visitor)) return newVisitorEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.Entity)) return newEntityEditor(neoNode);
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

	protected Node newProject(String name) { return getGraph().newNode(Entities.Project, AppMotif.Properties.name.name(), name); } 
	protected Node newDirectory(String name) { return getGraph().newNode(Entities.Directory, AppMotif.Properties.name.name(), name); } 
	protected Node newFile(String name) { return getGraph().newNode(Entities.File, AppMotif.Properties.name.name(), name); } 
	protected Node newgenerators(String name) { return getGraph().newNode(Entities.generators, AppMotif.Properties.name.name(), name); } 
	protected Node newVisitor(String name) { return getGraph().newNode(Entities.Visitor, AppMotif.Properties.name.name(), name); } 
	protected Node newEntity(String name) { return getGraph().newNode(Entities.Entity, AppMotif.Properties.name.name(), name); } 

}