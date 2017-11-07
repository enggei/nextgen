package com.generator.generators.stringtemplate;

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
 * Auto-generated from domain StringTemplateDomainPlugin
 */
public abstract class StringTemplateDomainPlugin extends Plugin {

	public enum Entities implements Label {
      STGroup, STTemplate
   }

   public enum Relations implements RelationshipType {
      STGROUP, TEMPLATE
   }

   public enum Properties {
      name, text
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   StringTemplateDomainPlugin(App app) {
      super(app, "StringTemplate");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "StringTemplate");
		entitiesNodeMap.put(Entities.STGroup, newDomainEntity(getGraph(), Entities.STGroup, domainNode));
		entitiesNodeMap.put(Entities.STTemplate, newDomainEntity(getGraph(), Entities.STTemplate, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STGroup), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.text.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.STGroup), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.STGroup), Relations.TEMPLATE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.STTemplate));
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

	protected void handleSTGroup(JPopupMenu pop, NeoNode sTGroupNode, Set<NeoNode> selectedNodes) { }
	protected void handleSTTemplate(JPopupMenu pop, NeoNode sTTemplateNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newSTGroupEditor(NeoNode sTGroupNode) { return null; }
	protected JComponent newSTTemplateEditor(NeoNode sTTemplateNode) { return null; }

	public static boolean isSTGroup(Node node) { return hasLabel(node, Entities.STGroup); }
	public static boolean isSTTemplate(Node node) { return hasLabel(node, Entities.STTemplate); }

	protected Node newSTGroup() { return newSTGroup(getGraph()); } 
	public static Node newSTGroup(NeoModel graph) { return newInstanceNode(graph, Entities.STGroup.name(), entitiesNodeMap.get(Entities.STGroup)); } 
	protected Node newSTGroup(Object name) { return newSTGroup(getGraph(), name); } 
	public static Node newSTGroup(NeoModel graph, Object name) {  	
		final Node newNode = newSTGroup(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newSTTemplate() { return newSTTemplate(getGraph()); } 
	public static Node newSTTemplate(NeoModel graph) { return newInstanceNode(graph, Entities.STTemplate.name(), entitiesNodeMap.get(Entities.STTemplate)); } 
	protected Node newSTTemplate(Object text, Object name) { return newSTTemplate(getGraph(), text, name); } 
	public static Node newSTTemplate(NeoModel graph, Object text, Object name) {  	
		final Node newNode = newSTTemplate(graph); 	
		if (text != null) relate(newNode, newValueNode(graph, text), RelationshipType.withName(Properties.text.name()));
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingSTGROUP(Node src, RelationConsumer consumer) { outgoing(src, Relations.STGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTGROUP(Node src) { return other(src, singleOutgoing(src, Relations.STGROUP)); }
	public static void incomingSTGROUP(Node src, RelationConsumer consumer) { incoming(src, Relations.STGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTGROUP(Node src) { return other(src, singleIncoming(src, Relations.STGROUP)); }

	public static void outgoingTEMPLATE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEMPLATE(Node src) { return other(src, singleOutgoing(src, Relations.TEMPLATE)); }
	public static void incomingTEMPLATE(Node src, RelationConsumer consumer) { incoming(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEMPLATE(Node src) { return other(src, singleIncoming(src, Relations.TEMPLATE)); }


	public static Relationship relateSTGROUP(Node src, Node dst) { return relate(src, dst, Relations.STGROUP); }
	public static Relationship relateTEMPLATE(Node src, Node dst) { return relate(src, dst, Relations.TEMPLATE); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	// text
	public static <T> T getTextProperty(PropertyContainer container) { return getEntityProperty(container, Properties.text.name()); }
	public static <T> T getTextProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.text.name(), defaultValue); }
	public static boolean hasTextProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.text.name()); }
	public static <T extends PropertyContainer> T setTextProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.text.name(), value); return container; }
	protected <T extends PropertyContainer> T setTextProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.text.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTextProperty(T container) { removeEntityProperty(container, Properties.text.name()); return container; }

}