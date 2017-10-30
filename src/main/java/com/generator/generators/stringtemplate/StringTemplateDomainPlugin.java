package com.generator.generators.stringtemplate;

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
 * Auto-generated from domain StringTemplateDomainPlugin
 */
abstract class StringTemplateDomainPlugin extends Plugin {

	public enum Entities implements Label {
      STGroup, STTemplate
   }

   public enum Relations implements RelationshipType {
      TEMPLATE
   }

   public enum Properties {
      text
   }

   StringTemplateDomainPlugin(App app) {
      super(app, "StringTemplate");
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

	protected void handleSTGroup(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleSTTemplate(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newSTGroupEditor(NeoNode neoNode) { return null; }
	protected JComponent newSTTemplateEditor(NeoNode neoNode) { return null; }

	protected Node newSTGroup(String name) { return newSTGroup(getGraph(), name); }
	protected Node newSTGroup() { return newSTGroup(getGraph()); } 
	protected Node newSTTemplate(String name) { return newSTTemplate(getGraph(), name); }
	protected Node newSTTemplate() { return newSTTemplate(getGraph()); } 

	public static boolean isSTGroup(Node node) { return hasLabel(node, Entities.STGroup); }
	public static boolean isSTTemplate(Node node) { return hasLabel(node, Entities.STTemplate); }

	public static Node newSTGroup(NeoModel graph, String name) { return graph.newNode(Entities.STGroup, AppMotif.Properties.name.name(), name); }
	public static Node newSTGroup(NeoModel graph) { return graph.newNode(Entities.STGroup); }
	public static Node newSTTemplate(NeoModel graph, String name) { return graph.newNode(Entities.STTemplate, AppMotif.Properties.name.name(), name); }
	public static Node newSTTemplate(NeoModel graph) { return graph.newNode(Entities.STTemplate); }

	public static void outgoingTEMPLATE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingTEMPLATE(Node src, RelationConsumer consumer) { incoming(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }

	public static Relationship relateTEMPLATE(Node src, Node dst) { return relate(src, dst, Relations.TEMPLATE); }

	public static String getName(Node node) { return DomainMotif.getName(node); }
	public static String getName(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setName(Node node, String name) { DomainMotif.setName(node, name); }
	public static void setName(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	public static <T> T getText(PropertyContainer container) { return get(container, Properties.text.name()); }
	public static <T> T getText(PropertyContainer container, T defaultValue) { return has(container, Properties.text.name()) ? get(container, Properties.text.name()) : defaultValue; }
	public static boolean hasText(PropertyContainer container) { return has(container, Properties.text.name()); }
	public static <T extends PropertyContainer> T setText(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.text.name());
	   else
	   	container.setProperty(Properties.text.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeText(T container) {
		if (has(container, Properties.text.name())) container.removeProperty(Properties.text.name());
	      return container;
	}

}