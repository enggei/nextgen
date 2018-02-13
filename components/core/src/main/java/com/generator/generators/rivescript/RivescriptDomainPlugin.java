package com.generator.generators.rivescript;

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
 * Auto-generated from domain RivescriptDomainPlugin
 */
public abstract class RivescriptDomainPlugin extends Plugin {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RivescriptDomainPlugin.class);

	public enum Entities implements Label {
      Bot, Script
   }

   public enum Relations implements RelationshipType {
      BOT, SCRIPT, SCRIPTS
   }

   public enum Properties {
      name, script
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   RivescriptDomainPlugin(App app) {
      super(app, "Rivescript");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Rivescript");
		entitiesNodeMap.put(Entities.Bot, DomainMotif.newDomainEntity(getGraph(), Entities.Bot, domainNode));
		entitiesNodeMap.put(Entities.Script, DomainMotif.newDomainEntity(getGraph(), Entities.Script, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Bot), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Script), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Script), Properties.script.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Bot), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Script), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Bot), Relations.SCRIPTS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Script));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isBot(neoNode.getNode())) handleBot(pop, neoNode, selectedNodes);
		if (isScript(neoNode.getNode())) handleScript(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isBot(neoNode.getNode())) return newBotEditor(neoNode);
		if (isScript(neoNode.getNode())) return newScriptEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleBot(JPopupMenu pop, NeoNode botNode, Set<NeoNode> selectedNodes) { }
	protected void handleScript(JPopupMenu pop, NeoNode scriptNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newBotEditor(NeoNode botNode) { return null; }
	protected JComponent newScriptEditor(NeoNode scriptNode) { return null; }

	public static boolean isBot(Node node) { return hasLabel(node, Entities.Bot); }
	public static boolean isScript(Node node) { return hasLabel(node, Entities.Script); }

	protected Node newBot() { return newBot(getGraph()); } 
	protected Node newBot(Object name) { return newBot(getGraph(), name); } 

	public static Node newBot(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Bot)); } 
	public static Node newBot(NeoModel graph, Object name) {  	
		final Node newNode = newBot(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newScript() { return newScript(getGraph()); } 
	protected Node newScript(Object name, Object script) { return newScript(getGraph(), name, script); } 

	public static Node newScript(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Script)); } 
	public static Node newScript(NeoModel graph, Object name, Object script) {  	
		final Node newNode = newScript(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (script != null) relate(newNode, DomainMotif.newValueNode(graph, script), RelationshipType.withName(Properties.script.name())); 	
		return newNode; 
	}


	public static void outgoingBOT(Node src, RelationConsumer consumer) { outgoing(src, Relations.BOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingBOT(Node src) { return other(src, singleOutgoing(src, Relations.BOT)); }
	public static void incomingBOT(Node src, RelationConsumer consumer) { incoming(src, Relations.BOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingBOT(Node src) { return other(src, singleIncoming(src, Relations.BOT)); }

	public static void outgoingSCRIPT(Node src, RelationConsumer consumer) { outgoing(src, Relations.SCRIPT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSCRIPT(Node src) { return other(src, singleOutgoing(src, Relations.SCRIPT)); }
	public static void incomingSCRIPT(Node src, RelationConsumer consumer) { incoming(src, Relations.SCRIPT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSCRIPT(Node src) { return other(src, singleIncoming(src, Relations.SCRIPT)); }

	public static void outgoingSCRIPTS(Node src, RelationConsumer consumer) { outgoing(src, Relations.SCRIPTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSCRIPTS(Node src) { return other(src, singleOutgoing(src, Relations.SCRIPTS)); }
	public static void incomingSCRIPTS(Node src, RelationConsumer consumer) { incoming(src, Relations.SCRIPTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSCRIPTS(Node src) { return other(src, singleIncoming(src, Relations.SCRIPTS)); }


	public static Relationship relateBOT(Node src, Node dst) { return relate(src, dst, Relations.BOT); }
	public static Relationship relateSCRIPT(Node src, Node dst) { return relate(src, dst, Relations.SCRIPT); }
	public static Relationship relateSCRIPTS(Node src, Node dst) { return relate(src, dst, Relations.SCRIPTS); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// script
	public static <T> T getScriptProperty(PropertyContainer container) { return getScriptProperty(container, null); }
	public static <T> T getScriptProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.script.name(), defaultValue); }
	public static boolean hasScriptProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.script.name()); }
	public static <T extends PropertyContainer> T setScriptProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.script.name(), value); return container; }
	public static <T extends PropertyContainer> T removeScriptProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.script.name()); return container; }

	protected <T extends PropertyContainer> T setScriptProperty(T container, Object value) { setScriptProperty(getGraph(), container, value); return container; }

}