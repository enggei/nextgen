package com.generator.generators.csv;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainDomainPlugin;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain CSVDomainPlugin
 */
public abstract class CSVDomainPlugin extends Plugin {

	public enum Entities implements Label {
      CSV, Header, HeaderColumn, Row, Value
   }

   public enum Relations implements RelationshipType {
      CSV, HEADER, COLUMNS, ROW, VALUE
   }

   public enum Properties {
      name, isString
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   CSVDomainPlugin(App app) {
      super(app, "CSV");

		domainNode = DomainMotif.newDomainNode(getGraph(), "CSV");
		entitiesNodeMap.put(Entities.CSV, DomainMotif.newDomainEntity(getGraph(), Entities.CSV, domainNode));
		entitiesNodeMap.put(Entities.Header, DomainMotif.newDomainEntity(getGraph(), Entities.Header, domainNode));
		entitiesNodeMap.put(Entities.HeaderColumn, DomainMotif.newDomainEntity(getGraph(), Entities.HeaderColumn, domainNode));
		entitiesNodeMap.put(Entities.Row, DomainMotif.newDomainEntity(getGraph(), Entities.Row, domainNode));
		entitiesNodeMap.put(Entities.Value, DomainMotif.newDomainEntity(getGraph(), Entities.Value, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.CSV), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.HeaderColumn), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Value), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Value), Properties.isString.name());

		relate(domainNode, entitiesNodeMap.get(Entities.CSV), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.CSV), Relations.HEADER.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Header));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.CSV), Relations.ROW.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Row));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Header), Relations.COLUMNS.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.HeaderColumn));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Row), Relations.VALUE.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Value));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Value), Relations.HEADER.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.HeaderColumn));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isCSV(neoNode.getNode())) handleCSV(pop, neoNode, selectedNodes);
		if (isHeader(neoNode.getNode())) handleHeader(pop, neoNode, selectedNodes);
		if (isHeaderColumn(neoNode.getNode())) handleHeaderColumn(pop, neoNode, selectedNodes);
		if (isRow(neoNode.getNode())) handleRow(pop, neoNode, selectedNodes);
		if (isValue(neoNode.getNode())) handleValue(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isCSV(neoNode.getNode())) return newCSVEditor(neoNode);
		if (isHeader(neoNode.getNode())) return newHeaderEditor(neoNode);
		if (isHeaderColumn(neoNode.getNode())) return newHeaderColumnEditor(neoNode);
		if (isRow(neoNode.getNode())) return newRowEditor(neoNode);
		if (isValue(neoNode.getNode())) return newValueEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleCSV(JPopupMenu pop, NeoNode cSVNode, Set<NeoNode> selectedNodes) { }
	protected void handleHeader(JPopupMenu pop, NeoNode headerNode, Set<NeoNode> selectedNodes) { }
	protected void handleHeaderColumn(JPopupMenu pop, NeoNode headerColumnNode, Set<NeoNode> selectedNodes) { }
	protected void handleRow(JPopupMenu pop, NeoNode rowNode, Set<NeoNode> selectedNodes) { }
	protected void handleValue(JPopupMenu pop, NeoNode valueNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newCSVEditor(NeoNode cSVNode) { return null; }
	protected JComponent newHeaderEditor(NeoNode headerNode) { return null; }
	protected JComponent newHeaderColumnEditor(NeoNode headerColumnNode) { return null; }
	protected JComponent newRowEditor(NeoNode rowNode) { return null; }
	protected JComponent newValueEditor(NeoNode valueNode) { return null; }

	public static boolean isCSV(Node node) { return hasLabel(node, Entities.CSV); }
	public static boolean isHeader(Node node) { return hasLabel(node, Entities.Header); }
	public static boolean isHeaderColumn(Node node) { return hasLabel(node, Entities.HeaderColumn); }
	public static boolean isRow(Node node) { return hasLabel(node, Entities.Row); }
	public static boolean isValue(Node node) { return hasLabel(node, Entities.Value); }

	protected Node newCSV() { return newCSV(getGraph()); } 
	protected Node newCSV(Object name) { return newCSV(getGraph(), name); } 

	public static Node newCSV(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.CSV)); } 
	public static Node newCSV(NeoModel graph, Object name) {  	
		final Node newNode = newCSV(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newHeader() { return newHeader(getGraph()); }
	public static Node newHeader(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Header)); }

	protected Node newHeaderColumn() { return newHeaderColumn(getGraph()); } 
	protected Node newHeaderColumn(Object name) { return newHeaderColumn(getGraph(), name); } 

	public static Node newHeaderColumn(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.HeaderColumn)); } 
	public static Node newHeaderColumn(NeoModel graph, Object name) {  	
		final Node newNode = newHeaderColumn(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newRow() { return newRow(getGraph()); }
	public static Node newRow(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Row)); }

	protected Node newValue() { return newValue(getGraph()); } 
	protected Node newValue(Object name, Object isString) { return newValue(getGraph(), name, isString); } 

	public static Node newValue(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Value)); } 
	public static Node newValue(NeoModel graph, Object name, Object isString) {  	
		final Node newNode = newValue(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (isString != null) relate(newNode, DomainMotif.newValueNode(graph, isString), RelationshipType.withName(Properties.isString.name())); 	
		return newNode; 
	}


	public static void outgoingCSV(Node src, RelationConsumer consumer) { outgoing(src, Relations.CSV).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCSV(Node src) { return other(src, singleOutgoing(src, Relations.CSV)); }
	public static void incomingCSV(Node src, RelationConsumer consumer) { incoming(src, Relations.CSV).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCSV(Node src) { return other(src, singleIncoming(src, Relations.CSV)); }

	public static void outgoingHEADER(Node src, RelationConsumer consumer) { outgoing(src, Relations.HEADER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingHEADER(Node src) { return other(src, singleOutgoing(src, Relations.HEADER)); }
	public static void incomingHEADER(Node src, RelationConsumer consumer) { incoming(src, Relations.HEADER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingHEADER(Node src) { return other(src, singleIncoming(src, Relations.HEADER)); }

	public static void outgoingCOLUMNS(Node src, RelationConsumer consumer) { outgoing(src, Relations.COLUMNS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOLUMNS(Node src) { return other(src, singleOutgoing(src, Relations.COLUMNS)); }
	public static void incomingCOLUMNS(Node src, RelationConsumer consumer) { incoming(src, Relations.COLUMNS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOLUMNS(Node src) { return other(src, singleIncoming(src, Relations.COLUMNS)); }

	public static void outgoingROW(Node src, RelationConsumer consumer) { outgoing(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingROW(Node src) { return other(src, singleOutgoing(src, Relations.ROW)); }
	public static void incomingROW(Node src, RelationConsumer consumer) { incoming(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingROW(Node src) { return other(src, singleIncoming(src, Relations.ROW)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }


	public static Relationship relateCSV(Node src, Node dst) { return relate(src, dst, Relations.CSV); }
	public static Relationship relateHEADER(Node src, Node dst) { return relate(src, dst, Relations.HEADER); }
	public static Relationship relateCOLUMNS(Node src, Node dst) { return relate(src, dst, Relations.COLUMNS); }
	public static Relationship relateROW(Node src, Node dst) { return relate(src, dst, Relations.ROW); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// isString
	public static <T> T getIsStringProperty(PropertyContainer container) { return getIsStringProperty(container, null); }
	public static <T> T getIsStringProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isString.name(), defaultValue); }
	public static boolean hasIsStringProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isString.name()); }
	public static <T extends PropertyContainer> T setIsStringProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isString.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsStringProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isString.name()); return container; }

	protected <T extends PropertyContainer> T setIsStringProperty(T container, Object value) { setIsStringProperty(getGraph(), container, value); return container; }

}