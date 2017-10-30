package com.generator.generators.csv;

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
 * Auto-generated from domain CSVDomainPlugin
 */
abstract class CSVDomainPlugin extends Plugin {

	public enum Entities implements Label {
      CSV, Row, Value, Column, Header, stringValue, row
   }

   public enum Relations implements RelationshipType {
      ROW, VALUE, COLUMN, HEADER
   }

   public enum Properties {
      header, row, stringValue, value, column
   }

   CSVDomainPlugin(App app) {
      super(app, "CSV");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isCSV(neoNode.getNode())) handleCSV(pop, neoNode, selectedNodes);
		if (isRow(neoNode.getNode())) handleRow(pop, neoNode, selectedNodes);
		if (isValue(neoNode.getNode())) handleValue(pop, neoNode, selectedNodes);
		if (isColumn(neoNode.getNode())) handleColumn(pop, neoNode, selectedNodes);
		if (isHeader(neoNode.getNode())) handleHeader(pop, neoNode, selectedNodes);
		if (isstringValue(neoNode.getNode())) handlestringValue(pop, neoNode, selectedNodes);
		if (isrow(neoNode.getNode())) handlerow(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isCSV(neoNode.getNode())) return newCSVEditor(neoNode);
		if (isRow(neoNode.getNode())) return newRowEditor(neoNode);
		if (isValue(neoNode.getNode())) return newValueEditor(neoNode);
		if (isColumn(neoNode.getNode())) return newColumnEditor(neoNode);
		if (isHeader(neoNode.getNode())) return newHeaderEditor(neoNode);
		if (isstringValue(neoNode.getNode())) return newstringValueEditor(neoNode);
		if (isrow(neoNode.getNode())) return newrowEditor(neoNode);
      return null;
   }

	protected void handleCSV(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleRow(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleValue(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleColumn(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleHeader(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handlestringValue(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handlerow(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newCSVEditor(NeoNode neoNode) { return null; }
	protected JComponent newRowEditor(NeoNode neoNode) { return null; }
	protected JComponent newValueEditor(NeoNode neoNode) { return null; }
	protected JComponent newColumnEditor(NeoNode neoNode) { return null; }
	protected JComponent newHeaderEditor(NeoNode neoNode) { return null; }
	protected JComponent newstringValueEditor(NeoNode neoNode) { return null; }
	protected JComponent newrowEditor(NeoNode neoNode) { return null; }

	protected Node newCSV(String name) { return newCSV(getGraph(), name); }
	protected Node newCSV() { return newCSV(getGraph()); } 
	protected Node newRow(String name) { return newRow(getGraph(), name); }
	protected Node newRow() { return newRow(getGraph()); } 
	protected Node newValue(String name) { return newValue(getGraph(), name); }
	protected Node newValue() { return newValue(getGraph()); } 
	protected Node newColumn(String name) { return newColumn(getGraph(), name); }
	protected Node newColumn() { return newColumn(getGraph()); } 
	protected Node newHeader(String name) { return newHeader(getGraph(), name); }
	protected Node newHeader() { return newHeader(getGraph()); } 
	protected Node newstringValue(String name) { return newstringValue(getGraph(), name); }
	protected Node newstringValue() { return newstringValue(getGraph()); } 
	protected Node newrow(String name) { return newrow(getGraph(), name); }
	protected Node newrow() { return newrow(getGraph()); } 

	public static boolean isCSV(Node node) { return hasLabel(node, Entities.CSV); }
	public static boolean isRow(Node node) { return hasLabel(node, Entities.Row); }
	public static boolean isValue(Node node) { return hasLabel(node, Entities.Value); }
	public static boolean isColumn(Node node) { return hasLabel(node, Entities.Column); }
	public static boolean isHeader(Node node) { return hasLabel(node, Entities.Header); }
	public static boolean isstringValue(Node node) { return hasLabel(node, Entities.stringValue); }
	public static boolean isrow(Node node) { return hasLabel(node, Entities.row); }

	public static Node newCSV(NeoModel graph, String name) { return graph.newNode(Entities.CSV, AppMotif.Properties.name.name(), name); }
	public static Node newCSV(NeoModel graph) { return graph.newNode(Entities.CSV); }
	public static Node newRow(NeoModel graph, String name) { return graph.newNode(Entities.Row, AppMotif.Properties.name.name(), name); }
	public static Node newRow(NeoModel graph) { return graph.newNode(Entities.Row); }
	public static Node newValue(NeoModel graph, String name) { return graph.newNode(Entities.Value, AppMotif.Properties.name.name(), name); }
	public static Node newValue(NeoModel graph) { return graph.newNode(Entities.Value); }
	public static Node newColumn(NeoModel graph, String name) { return graph.newNode(Entities.Column, AppMotif.Properties.name.name(), name); }
	public static Node newColumn(NeoModel graph) { return graph.newNode(Entities.Column); }
	public static Node newHeader(NeoModel graph, String name) { return graph.newNode(Entities.Header, AppMotif.Properties.name.name(), name); }
	public static Node newHeader(NeoModel graph) { return graph.newNode(Entities.Header); }
	public static Node newstringValue(NeoModel graph, String name) { return graph.newNode(Entities.stringValue, AppMotif.Properties.name.name(), name); }
	public static Node newstringValue(NeoModel graph) { return graph.newNode(Entities.stringValue); }
	public static Node newrow(NeoModel graph, String name) { return graph.newNode(Entities.row, AppMotif.Properties.name.name(), name); }
	public static Node newrow(NeoModel graph) { return graph.newNode(Entities.row); }

	public static void outgoingROW(Node src, RelationConsumer consumer) { outgoing(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingROW(Node src, RelationConsumer consumer) { incoming(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingCOLUMN(Node src, RelationConsumer consumer) { outgoing(src, Relations.COLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingCOLUMN(Node src, RelationConsumer consumer) { incoming(src, Relations.COLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void outgoingHEADER(Node src, RelationConsumer consumer) { outgoing(src, Relations.HEADER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static void incomingHEADER(Node src, RelationConsumer consumer) { incoming(src, Relations.HEADER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }

	public static Relationship relateROW(Node src, Node dst) { return relate(src, dst, Relations.ROW); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relateCOLUMN(Node src, Node dst) { return relate(src, dst, Relations.COLUMN); }
	public static Relationship relateHEADER(Node src, Node dst) { return relate(src, dst, Relations.HEADER); }

	public static String getName(Node node) { return DomainMotif.getName(node); }
	public static String getName(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setName(Node node, String name) { DomainMotif.setName(node, name); }
	public static void setName(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	public static <T> T getHeader(PropertyContainer container) { return get(container, Properties.header.name()); }
	public static <T> T getHeader(PropertyContainer container, T defaultValue) { return has(container, Properties.header.name()) ? get(container, Properties.header.name()) : defaultValue; }
	public static boolean hasHeader(PropertyContainer container) { return has(container, Properties.header.name()); }
	public static <T extends PropertyContainer> T setHeader(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.header.name());
	   else
	   	container.setProperty(Properties.header.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeHeader(T container) {
		if (has(container, Properties.header.name())) container.removeProperty(Properties.header.name());
	      return container;
	}

	public static <T> T getRow(PropertyContainer container) { return get(container, Properties.row.name()); }
	public static <T> T getRow(PropertyContainer container, T defaultValue) { return has(container, Properties.row.name()) ? get(container, Properties.row.name()) : defaultValue; }
	public static boolean hasRow(PropertyContainer container) { return has(container, Properties.row.name()); }
	public static <T extends PropertyContainer> T setRow(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.row.name());
	   else
	   	container.setProperty(Properties.row.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeRow(T container) {
		if (has(container, Properties.row.name())) container.removeProperty(Properties.row.name());
	      return container;
	}

	public static <T> T getStringValue(PropertyContainer container) { return get(container, Properties.stringValue.name()); }
	public static <T> T getStringValue(PropertyContainer container, T defaultValue) { return has(container, Properties.stringValue.name()) ? get(container, Properties.stringValue.name()) : defaultValue; }
	public static boolean hasStringValue(PropertyContainer container) { return has(container, Properties.stringValue.name()); }
	public static <T extends PropertyContainer> T setStringValue(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.stringValue.name());
	   else
	   	container.setProperty(Properties.stringValue.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeStringValue(T container) {
		if (has(container, Properties.stringValue.name())) container.removeProperty(Properties.stringValue.name());
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

	public static <T> T getColumn(PropertyContainer container) { return get(container, Properties.column.name()); }
	public static <T> T getColumn(PropertyContainer container, T defaultValue) { return has(container, Properties.column.name()) ? get(container, Properties.column.name()) : defaultValue; }
	public static boolean hasColumn(PropertyContainer container) { return has(container, Properties.column.name()); }
	public static <T extends PropertyContainer> T setColumn(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.column.name());
	   else
	   	container.setProperty(Properties.column.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeColumn(T container) {
		if (has(container, Properties.column.name())) container.removeProperty(Properties.column.name());
	      return container;
	}

}