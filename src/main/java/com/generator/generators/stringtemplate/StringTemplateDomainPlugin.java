package com.generator.generators.stringtemplate;

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
 * Auto-generated from domain StringTemplateDomainPlugin
 */
public abstract class StringTemplateDomainPlugin extends Plugin {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StringTemplateDomainPlugin.class);

	public enum Entities implements Label {
      STGroup, STTemplate
   }

   public enum Relations implements RelationshipType {
      STGROUP, NAME, TEMPLATE, TEXT
   }

   public enum Properties {
      name, text
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   StringTemplateDomainPlugin(App app) {
      super(app, "StringTemplate");

		domainNode = DomainMotif.newDomainNode(getGraph(), "StringTemplate");
		entitiesNodeMap.put(Entities.STGroup, DomainMotif.newDomainEntity(getGraph(), Entities.STGroup, domainNode));
		entitiesNodeMap.put(Entities.STTemplate, DomainMotif.newDomainEntity(getGraph(), Entities.STTemplate, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STGroup), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.text.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.STGroup), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.STGroup), Relations.TEMPLATE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.STTemplate));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isSTGroup(neoNode.getNode())) handleSTGroup(pop, neoNode, selectedNodes);
		if (isSTTemplate(neoNode.getNode())) handleSTTemplate(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isSTGroup(neoNode.getNode())) return newSTGroupEditor(neoNode);
		if (isSTTemplate(neoNode.getNode())) return newSTTemplateEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleSTGroup(JPopupMenu pop, NeoNode sTGroupNode, Set<NeoNode> selectedNodes) { }
	protected void handleSTTemplate(JPopupMenu pop, NeoNode sTTemplateNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newSTGroupEditor(NeoNode sTGroupNode) { return null; }
	protected JComponent newSTTemplateEditor(NeoNode sTTemplateNode) { return null; }

	public static boolean isSTGroup(Node node) { return hasLabel(node, Entities.STGroup); }
	public static boolean isSTTemplate(Node node) { return hasLabel(node, Entities.STTemplate); }

	protected Node newSTGroup() { return newSTGroup(getGraph()); } 
	protected Node newSTGroup(Object name) { return newSTGroup(getGraph(), name); } 

	public static Node newSTGroup(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.STGroup)); } 
	public static Node newSTGroup(NeoModel graph, Object name) {  	
		final Node newNode = newSTGroup(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newSTTemplate() { return newSTTemplate(getGraph()); } 
	protected Node newSTTemplate(Object text, Object name) { return newSTTemplate(getGraph(), text, name); } 

	public static Node newSTTemplate(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.STTemplate)); } 
	public static Node newSTTemplate(NeoModel graph, Object text, Object name) {  	
		final Node newNode = newSTTemplate(graph); 	
		if (text != null) relate(newNode, DomainMotif.newValueNode(graph, text), RelationshipType.withName(Properties.text.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingSTGROUP(Node src, RelationConsumer consumer) { outgoing(src, Relations.STGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTGROUP(Node src) { return other(src, singleOutgoing(src, Relations.STGROUP)); }
	public static void incomingSTGROUP(Node src, RelationConsumer consumer) { incoming(src, Relations.STGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTGROUP(Node src) { return other(src, singleIncoming(src, Relations.STGROUP)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingTEMPLATE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEMPLATE(Node src) { return other(src, singleOutgoing(src, Relations.TEMPLATE)); }
	public static void incomingTEMPLATE(Node src, RelationConsumer consumer) { incoming(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEMPLATE(Node src) { return other(src, singleIncoming(src, Relations.TEMPLATE)); }

	public static void outgoingTEXT(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEXT(Node src) { return other(src, singleOutgoing(src, Relations.TEXT)); }
	public static void incomingTEXT(Node src, RelationConsumer consumer) { incoming(src, Relations.TEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEXT(Node src) { return other(src, singleIncoming(src, Relations.TEXT)); }


	public static Relationship relateSTGROUP(Node src, Node dst) { return relate(src, dst, Relations.STGROUP); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateTEMPLATE(Node src, Node dst) { return relate(src, dst, Relations.TEMPLATE); }
	public static Relationship relateTEXT(Node src, Node dst) { return relate(src, dst, Relations.TEXT); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// text
	public static <T> T getTextProperty(PropertyContainer container) { return getTextProperty(container, null); }
	public static <T> T getTextProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.text.name(), defaultValue); }
	public static boolean hasTextProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.text.name()); }
	public static <T extends PropertyContainer> T setTextProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.text.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTextProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.text.name()); return container; }

	protected <T extends PropertyContainer> T setTextProperty(T container, Object value) { setTextProperty(getGraph(), container, value); return container; }

}