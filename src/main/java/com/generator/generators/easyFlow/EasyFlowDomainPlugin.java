package com.generator.generators.easyFlow;

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
 * Auto-generated from domain EasyFlowDomainPlugin
 */
abstract class EasyFlowDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Flow, State, Event, ContextProperty
   }

   public enum Relations implements RelationshipType {
      FROM, ON, TO, FINISH, CONTEXT_PROPERTY
   }

   public enum Properties {
      name, extending, modifier, comment, type, value
   }

   EasyFlowDomainPlugin(App app) {
      super(app, "EasyFlow");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isFlow(neoNode.getNode())) handleFlow(pop, neoNode, selectedNodes);
		if (isState(neoNode.getNode())) handleState(pop, neoNode, selectedNodes);
		if (isEvent(neoNode.getNode())) handleEvent(pop, neoNode, selectedNodes);
		if (isContextProperty(neoNode.getNode())) handleContextProperty(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isFlow(neoNode.getNode())) return newFlowEditor(neoNode);
		if (isState(neoNode.getNode())) return newStateEditor(neoNode);
		if (isEvent(neoNode.getNode())) return newEventEditor(neoNode);
		if (isContextProperty(neoNode.getNode())) return newContextPropertyEditor(neoNode);
      return null;
   }

	protected void handleFlow(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleState(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleEvent(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleContextProperty(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newFlowEditor(NeoNode neoNode) { return null; }
	protected JComponent newStateEditor(NeoNode neoNode) { return null; }
	protected JComponent newEventEditor(NeoNode neoNode) { return null; }
	protected JComponent newContextPropertyEditor(NeoNode neoNode) { return null; }

	protected Node newFlow(String name) { return newFlow(getGraph(), name); }
	protected Node newFlow() { return newFlow(getGraph()); } 
	protected Node newState(String name) { return newState(getGraph(), name); }
	protected Node newState() { return newState(getGraph()); } 
	protected Node newEvent(String name) { return newEvent(getGraph(), name); }
	protected Node newEvent() { return newEvent(getGraph()); } 
	protected Node newContextProperty(String name) { return newContextProperty(getGraph(), name); }
	protected Node newContextProperty() { return newContextProperty(getGraph()); } 

	public static boolean isFlow(Node node) { return hasLabel(node, Entities.Flow); }
	public static boolean isState(Node node) { return hasLabel(node, Entities.State); }
	public static boolean isEvent(Node node) { return hasLabel(node, Entities.Event); }
	public static boolean isContextProperty(Node node) { return hasLabel(node, Entities.ContextProperty); }

	public static Node newFlow(NeoModel graph, String name) { return graph.newNode(Entities.Flow, AppMotif.Properties.name.name(), name); }
	public static Node newFlow(NeoModel graph) { return graph.newNode(Entities.Flow); }
	public static Node newState(NeoModel graph, String name) { return graph.newNode(Entities.State, AppMotif.Properties.name.name(), name); }
	public static Node newState(NeoModel graph) { return graph.newNode(Entities.State); }
	public static Node newEvent(NeoModel graph, String name) { return graph.newNode(Entities.Event, AppMotif.Properties.name.name(), name); }
	public static Node newEvent(NeoModel graph) { return graph.newNode(Entities.Event); }
	public static Node newContextProperty(NeoModel graph, String name) { return graph.newNode(Entities.ContextProperty, AppMotif.Properties.name.name(), name); }
	public static Node newContextProperty(NeoModel graph) { return graph.newNode(Entities.ContextProperty); }

	public static void outgoingFROM(Node src, RelationConsumer consumer) { outgoing(src, Relations.FROM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingFROM(Node src, RelationConsumer consumer) { incoming(src, Relations.FROM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingON(Node src, RelationConsumer consumer) { outgoing(src, Relations.ON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingON(Node src, RelationConsumer consumer) { incoming(src, Relations.ON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingTO(Node src, RelationConsumer consumer) { outgoing(src, Relations.TO).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingTO(Node src, RelationConsumer consumer) { incoming(src, Relations.TO).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingFINISH(Node src, RelationConsumer consumer) { outgoing(src, Relations.FINISH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingFINISH(Node src, RelationConsumer consumer) { incoming(src, Relations.FINISH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingCONTEXT_PROPERTY(Node src, RelationConsumer consumer) { outgoing(src, Relations.CONTEXT_PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingCONTEXT_PROPERTY(Node src, RelationConsumer consumer) { incoming(src, Relations.CONTEXT_PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }

	public static Relationship relateFROM(Node src, Node dst) { return relate(src, dst, Relations.FROM); }
	public static Relationship relateON(Node src, Node dst) { return relate(src, dst, Relations.ON); }
	public static Relationship relateTO(Node src, Node dst) { return relate(src, dst, Relations.TO); }
	public static Relationship relateFINISH(Node src, Node dst) { return relate(src, dst, Relations.FINISH); }
	public static Relationship relateCONTEXT_PROPERTY(Node src, Node dst) { return relate(src, dst, Relations.CONTEXT_PROPERTY); }

	public static String getName(Node node) { return DomainMotif.getName(node); }
	public static String getName(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setName(Node node, String name) { DomainMotif.setName(node, name); }
	public static void setName(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

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

	public static <T> T getExtending(PropertyContainer container) { return get(container, Properties.extending.name()); }
	public static <T> T getExtending(PropertyContainer container, T defaultValue) { return has(container, Properties.extending.name()) ? get(container, Properties.extending.name()) : defaultValue; }
	public static boolean hasExtending(PropertyContainer container) { return has(container, Properties.extending.name()); }
	public static <T extends PropertyContainer> T setExtending(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.extending.name());
	   else
	   	container.setProperty(Properties.extending.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeExtending(T container) {
		if (has(container, Properties.extending.name())) container.removeProperty(Properties.extending.name());
	      return container;
	}

	public static <T> T getModifier(PropertyContainer container) { return get(container, Properties.modifier.name()); }
	public static <T> T getModifier(PropertyContainer container, T defaultValue) { return has(container, Properties.modifier.name()) ? get(container, Properties.modifier.name()) : defaultValue; }
	public static boolean hasModifier(PropertyContainer container) { return has(container, Properties.modifier.name()); }
	public static <T extends PropertyContainer> T setModifier(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.modifier.name());
	   else
	   	container.setProperty(Properties.modifier.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeModifier(T container) {
		if (has(container, Properties.modifier.name())) container.removeProperty(Properties.modifier.name());
	      return container;
	}

	public static <T> T getComment(PropertyContainer container) { return get(container, Properties.comment.name()); }
	public static <T> T getComment(PropertyContainer container, T defaultValue) { return has(container, Properties.comment.name()) ? get(container, Properties.comment.name()) : defaultValue; }
	public static boolean hasComment(PropertyContainer container) { return has(container, Properties.comment.name()); }
	public static <T extends PropertyContainer> T setComment(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.comment.name());
	   else
	   	container.setProperty(Properties.comment.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeComment(T container) {
		if (has(container, Properties.comment.name())) container.removeProperty(Properties.comment.name());
	      return container;
	}

	public static <T> T getType(PropertyContainer container) { return get(container, Properties.type.name()); }
	public static <T> T getType(PropertyContainer container, T defaultValue) { return has(container, Properties.type.name()) ? get(container, Properties.type.name()) : defaultValue; }
	public static boolean hasType(PropertyContainer container) { return has(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setType(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.type.name());
	   else
	   	container.setProperty(Properties.type.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeType(T container) {
		if (has(container, Properties.type.name())) container.removeProperty(Properties.type.name());
	      return container;
	}

	public static <T> T getValue(PropertyContainer container) { return get(container, Properties.value.name()); }
	public static <T> T getValue(PropertyContainer container, T defaultValue) { return has(container, Properties.value.name()) ? get(container, Properties.value.name()) : defaultValue; }
	public static boolean hasValue(PropertyContainer container) { return has(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValue(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.value.name());
	   else
	   	container.setProperty(Properties.value.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeValue(T container) {
		if (has(container, Properties.value.name())) container.removeProperty(Properties.value.name());
	      return container;
	}

}