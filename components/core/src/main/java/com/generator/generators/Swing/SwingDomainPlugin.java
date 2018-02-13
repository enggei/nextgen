package com.generator.generators.Swing;

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
 * Auto-generated from domain SwingDomainPlugin
 */
public abstract class SwingDomainPlugin extends Plugin {

	public enum Entities implements Label {
      FormPanel, Row, Column
   }

   public enum Relations implements RelationshipType {
      FORMPANEL, ROW, COL
   }

   public enum Properties {
      height, index, width
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   SwingDomainPlugin(App app) {
      super(app, "Swing");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Swing");
		entitiesNodeMap.put(Entities.FormPanel, DomainMotif.newDomainEntity(getGraph(), Entities.FormPanel, domainNode));
		entitiesNodeMap.put(Entities.Row, DomainMotif.newDomainEntity(getGraph(), Entities.Row, domainNode));
		entitiesNodeMap.put(Entities.Column, DomainMotif.newDomainEntity(getGraph(), Entities.Column, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Row), Properties.height.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Row), Properties.index.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.width.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.index.name());

		relate(domainNode, entitiesNodeMap.get(Entities.FormPanel), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.FormPanel), Relations.ROW.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Row));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.FormPanel), Relations.COL.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Column));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isFormPanel(neoNode.getNode())) handleFormPanel(pop, neoNode, selectedNodes);
		if (isRow(neoNode.getNode())) handleRow(pop, neoNode, selectedNodes);
		if (isColumn(neoNode.getNode())) handleColumn(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isFormPanel(neoNode.getNode())) return newFormPanelEditor(neoNode);
		if (isRow(neoNode.getNode())) return newRowEditor(neoNode);
		if (isColumn(neoNode.getNode())) return newColumnEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleFormPanel(JPopupMenu pop, NeoNode formPanelNode, Set<NeoNode> selectedNodes) { }
	protected void handleRow(JPopupMenu pop, NeoNode rowNode, Set<NeoNode> selectedNodes) { }
	protected void handleColumn(JPopupMenu pop, NeoNode columnNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newFormPanelEditor(NeoNode formPanelNode) { return null; }
	protected JComponent newRowEditor(NeoNode rowNode) { return null; }
	protected JComponent newColumnEditor(NeoNode columnNode) { return null; }

	public static boolean isFormPanel(Node node) { return hasLabel(node, Entities.FormPanel); }
	public static boolean isRow(Node node) { return hasLabel(node, Entities.Row); }
	public static boolean isColumn(Node node) { return hasLabel(node, Entities.Column); }

	protected Node newFormPanel() { return newFormPanel(getGraph()); }
	public static Node newFormPanel(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.FormPanel)); }

	protected Node newRow() { return newRow(getGraph()); } 
	protected Node newRow(Object height, Object index) { return newRow(getGraph(), height, index); } 

	public static Node newRow(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Row)); } 
	public static Node newRow(NeoModel graph, Object height, Object index) {  	
		final Node newNode = newRow(graph); 	
		if (height != null) relate(newNode, DomainMotif.newValueNode(graph, height), RelationshipType.withName(Properties.height.name()));
		if (index != null) relate(newNode, DomainMotif.newValueNode(graph, index), RelationshipType.withName(Properties.index.name())); 	
		return newNode; 
	}

	protected Node newColumn() { return newColumn(getGraph()); } 
	protected Node newColumn(Object width, Object index) { return newColumn(getGraph(), width, index); } 

	public static Node newColumn(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Column)); } 
	public static Node newColumn(NeoModel graph, Object width, Object index) {  	
		final Node newNode = newColumn(graph); 	
		if (width != null) relate(newNode, DomainMotif.newValueNode(graph, width), RelationshipType.withName(Properties.width.name()));
		if (index != null) relate(newNode, DomainMotif.newValueNode(graph, index), RelationshipType.withName(Properties.index.name())); 	
		return newNode; 
	}


	public static void outgoingFORMPANEL(Node src, RelationConsumer consumer) { outgoing(src, Relations.FORMPANEL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFORMPANEL(Node src) { return other(src, singleOutgoing(src, Relations.FORMPANEL)); }
	public static void incomingFORMPANEL(Node src, RelationConsumer consumer) { incoming(src, Relations.FORMPANEL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFORMPANEL(Node src) { return other(src, singleIncoming(src, Relations.FORMPANEL)); }

	public static void outgoingROW(Node src, RelationConsumer consumer) { outgoing(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingROW(Node src) { return other(src, singleOutgoing(src, Relations.ROW)); }
	public static void incomingROW(Node src, RelationConsumer consumer) { incoming(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingROW(Node src) { return other(src, singleIncoming(src, Relations.ROW)); }

	public static void outgoingCOL(Node src, RelationConsumer consumer) { outgoing(src, Relations.COL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOL(Node src) { return other(src, singleOutgoing(src, Relations.COL)); }
	public static void incomingCOL(Node src, RelationConsumer consumer) { incoming(src, Relations.COL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOL(Node src) { return other(src, singleIncoming(src, Relations.COL)); }


	public static Relationship relateFORMPANEL(Node src, Node dst) { return relate(src, dst, Relations.FORMPANEL); }
	public static Relationship relateROW(Node src, Node dst) { return relate(src, dst, Relations.ROW); }
	public static Relationship relateCOL(Node src, Node dst) { return relate(src, dst, Relations.COL); }

	// height
	public static <T> T getHeightProperty(PropertyContainer container) { return getHeightProperty(container, null); }
	public static <T> T getHeightProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.height.name(), defaultValue); }
	public static boolean hasHeightProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.height.name()); }
	public static <T extends PropertyContainer> T setHeightProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.height.name(), value); return container; }
	public static <T extends PropertyContainer> T removeHeightProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.height.name()); return container; }

	protected <T extends PropertyContainer> T setHeightProperty(T container, Object value) { setHeightProperty(getGraph(), container, value); return container; }

	// index
	public static <T> T getIndexProperty(PropertyContainer container) { return getIndexProperty(container, null); }
	public static <T> T getIndexProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.index.name(), defaultValue); }
	public static boolean hasIndexProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.index.name()); }
	public static <T extends PropertyContainer> T setIndexProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.index.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIndexProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.index.name()); return container; }

	protected <T extends PropertyContainer> T setIndexProperty(T container, Object value) { setIndexProperty(getGraph(), container, value); return container; }

	// width
	public static <T> T getWidthProperty(PropertyContainer container) { return getWidthProperty(container, null); }
	public static <T> T getWidthProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.width.name(), defaultValue); }
	public static boolean hasWidthProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.width.name()); }
	public static <T extends PropertyContainer> T setWidthProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.width.name(), value); return container; }
	public static <T extends PropertyContainer> T removeWidthProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.width.name()); return container; }

	protected <T extends PropertyContainer> T setWidthProperty(T container, Object value) { setWidthProperty(getGraph(), container, value); return container; }

}