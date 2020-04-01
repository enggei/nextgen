package com.generator.generators.npm;

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
 * Auto-generated from domain npmDomainPlugin
 */
public abstract class npmDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(npmDomainPlugin.class);

	public enum Entities implements Label {
      npmProject, Command
   }

   public enum Relations implements RelationshipType {
      NPMPROJECT, COMMAND, NAME, PATH, DESCRIPTION
   }

   public enum Properties {
      name, path, description
   }
	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   npmDomainPlugin(App app) {
      super(app, "npm");

		domainNode = DomainMotif.newDomainNode(getGraph(), "npm");
		entitiesNodeMap.put(Entities.npmProject, DomainMotif.newDomainEntity(getGraph(), Entities.npmProject, domainNode));
		entitiesNodeMap.put(Entities.Command, DomainMotif.newDomainEntity(getGraph(), Entities.Command, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.npmProject), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.npmProject), Properties.path.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Command), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Command), Properties.description.name());

		relate(domainNode, entitiesNodeMap.get(Entities.npmProject), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Command), DomainPlugin.Relations.ENTITY);
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isnpmProject(neoNode.getNode())) handlenpmProject(pop, neoNode, selectedNodes);
		if (isCommand(neoNode.getNode())) handleCommand(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isnpmProject(neoNode.getNode())) return newnpmProjectEditor(neoNode);
		if (isCommand(neoNode.getNode())) return newCommandEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handlenpmProject(JPopupMenu pop, NeoNode npmProjectNode, Set<NeoNode> selectedNodes) { }
	protected void handleCommand(JPopupMenu pop, NeoNode commandNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newnpmProjectEditor(NeoNode npmProjectNode) { return null; }
	protected JComponent newCommandEditor(NeoNode commandNode) { return null; }

	public static boolean isnpmProject(Node node) { return hasLabel(node, Entities.npmProject); }
	public static boolean isCommand(Node node) { return hasLabel(node, Entities.Command); }

	protected Node newnpmProject() { return newnpmProject(getGraph()); } 
	protected Node newnpmProject(Object name, Object path) { return newnpmProject(getGraph(), name, path); } 

	public static Node newnpmProject(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.npmProject)); } 
	public static Node newnpmProject(NeoModel graph, Object name, Object path) {  	
		final Node newNode = newnpmProject(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (path != null) relate(newNode, DomainMotif.newValueNode(graph, path), RelationshipType.withName(Properties.path.name())); 	
		return newNode; 
	}
	/* todo
	public Action newnpmProjectAction() {
		return new App.TransactionAction("New npmProject", app) {
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

	protected Node newCommand() { return newCommand(getGraph()); } 
	protected Node newCommand(Object name, Object description) { return newCommand(getGraph(), name, description); } 

	public static Node newCommand(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Command)); } 
	public static Node newCommand(NeoModel graph, Object name, Object description) {  	
		final Node newNode = newCommand(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (description != null) relate(newNode, DomainMotif.newValueNode(graph, description), RelationshipType.withName(Properties.description.name())); 	
		return newNode; 
	}
	/* todo
	public Action newCommandAction() {
		return new App.TransactionAction("New Command", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String description = com.generator.util.SwingUtil.showInputDialog("description", app);
				if (description != null && description.length() > 0)
					properties.put("description", description);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/


	public static void outgoingNPMPROJECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.NPMPROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNPMPROJECT(Node src) { return other(src, singleOutgoing(src, Relations.NPMPROJECT)); }
	public static void incomingNPMPROJECT(Node src, RelationConsumer consumer) { incoming(src, Relations.NPMPROJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNPMPROJECT(Node src) { return other(src, singleIncoming(src, Relations.NPMPROJECT)); }

	public static void outgoingCOMMAND(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMMAND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMMAND(Node src) { return other(src, singleOutgoing(src, Relations.COMMAND)); }
	public static void incomingCOMMAND(Node src, RelationConsumer consumer) { incoming(src, Relations.COMMAND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMMAND(Node src) { return other(src, singleIncoming(src, Relations.COMMAND)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingPATH(Node src, RelationConsumer consumer) { outgoing(src, Relations.PATH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPATH(Node src) { return other(src, singleOutgoing(src, Relations.PATH)); }
	public static void incomingPATH(Node src, RelationConsumer consumer) { incoming(src, Relations.PATH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPATH(Node src) { return other(src, singleIncoming(src, Relations.PATH)); }

	public static void outgoingDESCRIPTION(Node src, RelationConsumer consumer) { outgoing(src, Relations.DESCRIPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDESCRIPTION(Node src) { return other(src, singleOutgoing(src, Relations.DESCRIPTION)); }
	public static void incomingDESCRIPTION(Node src, RelationConsumer consumer) { incoming(src, Relations.DESCRIPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDESCRIPTION(Node src) { return other(src, singleIncoming(src, Relations.DESCRIPTION)); }


	public static Relationship relateNPMPROJECT(Node src, Node dst) { return relate(src, dst, Relations.NPMPROJECT); }
	public static Relationship relateCOMMAND(Node src, Node dst) { return relate(src, dst, Relations.COMMAND); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relatePATH(Node src, Node dst) { return relate(src, dst, Relations.PATH); }
	public static Relationship relateDESCRIPTION(Node src, Node dst) { return relate(src, dst, Relations.DESCRIPTION); }

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

	// description
	public static <T> T getDescriptionProperty(PropertyContainer container) { return getDescriptionProperty(container, null); }
	public static <T> T getDescriptionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.description.name(), defaultValue); }
	public static boolean hasDescriptionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.description.name()); }
	public static <T extends PropertyContainer> T setDescriptionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.description.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDescriptionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.description.name()); return container; }

	protected <T extends PropertyContainer> T setDescriptionProperty(T container, Object value) { setDescriptionProperty(getGraph(), container, value); return container; }

}