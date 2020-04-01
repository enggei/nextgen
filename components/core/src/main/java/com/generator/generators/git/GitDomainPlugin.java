package com.generator.generators.git;

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
 * Auto-generated from domain GitDomainPlugin
 */
public abstract class GitDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(GitDomainPlugin.class);

	public enum Entities implements Label {
      Git
   }

   public enum Relations implements RelationshipType {
      GIT, REPOSITORY, NAME
   }

   public enum Properties {
      repository, name
   }
	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   GitDomainPlugin(App app) {
      super(app, "Git");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Git");
		entitiesNodeMap.put(Entities.Git, DomainMotif.newDomainEntity(getGraph(), Entities.Git, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Git), Properties.repository.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Git), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Git), DomainPlugin.Relations.ENTITY);
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isGit(neoNode.getNode())) handleGit(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isGit(neoNode.getNode())) return newGitEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleGit(JPopupMenu pop, NeoNode gitNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newGitEditor(NeoNode gitNode) { return null; }

	public static boolean isGit(Node node) { return hasLabel(node, Entities.Git); }

	protected Node newGit() { return newGit(getGraph()); } 
	protected Node newGit(Object repository, Object name) { return newGit(getGraph(), repository, name); } 

	public static Node newGit(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Git)); } 
	public static Node newGit(NeoModel graph, Object repository, Object name) {  	
		final Node newNode = newGit(graph); 	
		if (repository != null) relate(newNode, DomainMotif.newValueNode(graph, repository), RelationshipType.withName(Properties.repository.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newGitAction() {
		return new App.TransactionAction("New Git", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String repository = com.generator.util.SwingUtil.showInputDialog("repository", app);
				if (repository != null && repository.length() > 0)
					properties.put("repository", repository);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/


	public static void outgoingGIT(Node src, RelationConsumer consumer) { outgoing(src, Relations.GIT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingGIT(Node src) { return other(src, singleOutgoing(src, Relations.GIT)); }
	public static void incomingGIT(Node src, RelationConsumer consumer) { incoming(src, Relations.GIT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingGIT(Node src) { return other(src, singleIncoming(src, Relations.GIT)); }

	public static void outgoingREPOSITORY(Node src, RelationConsumer consumer) { outgoing(src, Relations.REPOSITORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingREPOSITORY(Node src) { return other(src, singleOutgoing(src, Relations.REPOSITORY)); }
	public static void incomingREPOSITORY(Node src, RelationConsumer consumer) { incoming(src, Relations.REPOSITORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingREPOSITORY(Node src) { return other(src, singleIncoming(src, Relations.REPOSITORY)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }


	public static Relationship relateGIT(Node src, Node dst) { return relate(src, dst, Relations.GIT); }
	public static Relationship relateREPOSITORY(Node src, Node dst) { return relate(src, dst, Relations.REPOSITORY); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }

	// repository
	public static <T> T getRepositoryProperty(PropertyContainer container) { return getRepositoryProperty(container, null); }
	public static <T> T getRepositoryProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.repository.name(), defaultValue); }
	public static boolean hasRepositoryProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.repository.name()); }
	public static <T extends PropertyContainer> T setRepositoryProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.repository.name(), value); return container; }
	public static <T extends PropertyContainer> T removeRepositoryProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.repository.name()); return container; }

	protected <T extends PropertyContainer> T setRepositoryProperty(T container, Object value) { setRepositoryProperty(getGraph(), container, value); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

}