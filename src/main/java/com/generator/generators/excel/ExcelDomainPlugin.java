package com.generator.generators.excel;

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
 * Auto-generated from domain ExcelDomainPlugin
 */
abstract class ExcelDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Workbook, Sheet, Column, Cell, Row
   }

   public enum Relations implements RelationshipType {
      SHEET, COL, CELL, REFERENCE, ROW
   }

   public enum Properties {
      cellType, value
   }

   ExcelDomainPlugin(App app) {
      super(app, "Excel");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isWorkbook(neoNode.getNode())) handleWorkbook(pop, neoNode, selectedNodes);
		if (isSheet(neoNode.getNode())) handleSheet(pop, neoNode, selectedNodes);
		if (isColumn(neoNode.getNode())) handleColumn(pop, neoNode, selectedNodes);
		if (isCell(neoNode.getNode())) handleCell(pop, neoNode, selectedNodes);
		if (isRow(neoNode.getNode())) handleRow(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isWorkbook(neoNode.getNode())) return newWorkbookEditor(neoNode);
		if (isSheet(neoNode.getNode())) return newSheetEditor(neoNode);
		if (isColumn(neoNode.getNode())) return newColumnEditor(neoNode);
		if (isCell(neoNode.getNode())) return newCellEditor(neoNode);
		if (isRow(neoNode.getNode())) return newRowEditor(neoNode);
      return null;
   }

	protected void handleWorkbook(JPopupMenu pop, NeoNode workbookNode, Set<NeoNode> selectedNodes) { }
	protected void handleSheet(JPopupMenu pop, NeoNode sheetNode, Set<NeoNode> selectedNodes) { }
	protected void handleColumn(JPopupMenu pop, NeoNode columnNode, Set<NeoNode> selectedNodes) { }
	protected void handleCell(JPopupMenu pop, NeoNode cellNode, Set<NeoNode> selectedNodes) { }
	protected void handleRow(JPopupMenu pop, NeoNode rowNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newWorkbookEditor(NeoNode workbookNode) { return null; }
	protected JComponent newSheetEditor(NeoNode sheetNode) { return null; }
	protected JComponent newColumnEditor(NeoNode columnNode) { return null; }
	protected JComponent newCellEditor(NeoNode cellNode) { return null; }
	protected JComponent newRowEditor(NeoNode rowNode) { return null; }

	protected Node newWorkbook(String name) { return newWorkbook(getGraph(), name); }
	protected Node newWorkbook() { return newWorkbook(getGraph()); } 
	protected Node newSheet(String name) { return newSheet(getGraph(), name); }
	protected Node newSheet() { return newSheet(getGraph()); } 
	protected Node newColumn(String name) { return newColumn(getGraph(), name); }
	protected Node newColumn() { return newColumn(getGraph()); } 
	protected Node newCell(String name) { return newCell(getGraph(), name); }
	protected Node newCell() { return newCell(getGraph()); } 
	protected Node newRow(String name) { return newRow(getGraph(), name); }
	protected Node newRow() { return newRow(getGraph()); } 

	public static boolean isWorkbook(Node node) { return hasLabel(node, Entities.Workbook); }
	public static boolean isSheet(Node node) { return hasLabel(node, Entities.Sheet); }
	public static boolean isColumn(Node node) { return hasLabel(node, Entities.Column); }
	public static boolean isCell(Node node) { return hasLabel(node, Entities.Cell); }
	public static boolean isRow(Node node) { return hasLabel(node, Entities.Row); }

	public static Node newWorkbook(NeoModel graph, String name) { return graph.newNode(Entities.Workbook, AppMotif.Properties.name.name(), name); }
	public static Node newWorkbook(NeoModel graph) { return graph.newNode(Entities.Workbook); }
	public static Node newSheet(NeoModel graph, String name) { return graph.newNode(Entities.Sheet, AppMotif.Properties.name.name(), name); }
	public static Node newSheet(NeoModel graph) { return graph.newNode(Entities.Sheet); }
	public static Node newColumn(NeoModel graph, String name) { return graph.newNode(Entities.Column, AppMotif.Properties.name.name(), name); }
	public static Node newColumn(NeoModel graph) { return graph.newNode(Entities.Column); }
	public static Node newCell(NeoModel graph, String name) { return graph.newNode(Entities.Cell, AppMotif.Properties.name.name(), name); }
	public static Node newCell(NeoModel graph) { return graph.newNode(Entities.Cell); }
	public static Node newRow(NeoModel graph, String name) { return graph.newNode(Entities.Row, AppMotif.Properties.name.name(), name); }
	public static Node newRow(NeoModel graph) { return graph.newNode(Entities.Row); }

	public static void outgoingSHEET(Node src, RelationConsumer consumer) { outgoing(src, Relations.SHEET).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSHEET(Node src) { return other(src, singleOutgoing(src, Relations.SHEET)); }
	public static void incomingSHEET(Node src, RelationConsumer consumer) { incoming(src, Relations.SHEET).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSHEET(Node src) { return other(src, singleIncoming(src, Relations.SHEET)); }

	public static void outgoingCOL(Node src, RelationConsumer consumer) { outgoing(src, Relations.COL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOL(Node src) { return other(src, singleOutgoing(src, Relations.COL)); }
	public static void incomingCOL(Node src, RelationConsumer consumer) { incoming(src, Relations.COL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOL(Node src) { return other(src, singleIncoming(src, Relations.COL)); }

	public static void outgoingCELL(Node src, RelationConsumer consumer) { outgoing(src, Relations.CELL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCELL(Node src) { return other(src, singleOutgoing(src, Relations.CELL)); }
	public static void incomingCELL(Node src, RelationConsumer consumer) { incoming(src, Relations.CELL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCELL(Node src) { return other(src, singleIncoming(src, Relations.CELL)); }

	public static void outgoingREFERENCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingREFERENCE(Node src) { return other(src, singleOutgoing(src, Relations.REFERENCE)); }
	public static void incomingREFERENCE(Node src, RelationConsumer consumer) { incoming(src, Relations.REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingREFERENCE(Node src) { return other(src, singleIncoming(src, Relations.REFERENCE)); }

	public static void outgoingROW(Node src, RelationConsumer consumer) { outgoing(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingROW(Node src) { return other(src, singleOutgoing(src, Relations.ROW)); }
	public static void incomingROW(Node src, RelationConsumer consumer) { incoming(src, Relations.ROW).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingROW(Node src) { return other(src, singleIncoming(src, Relations.ROW)); }


	public static Relationship relateSHEET(Node src, Node dst) { return relate(src, dst, Relations.SHEET); }
	public static Relationship relateCOL(Node src, Node dst) { return relate(src, dst, Relations.COL); }
	public static Relationship relateCELL(Node src, Node dst) { return relate(src, dst, Relations.CELL); }
	public static Relationship relateREFERENCE(Node src, Node dst) { return relate(src, dst, Relations.REFERENCE); }
	public static Relationship relateROW(Node src, Node dst) { return relate(src, dst, Relations.ROW); }

	// get name as property of a node (node.name)
	public static String getNameProperty(PropertyContainer node) { return DomainMotif.getName(node); }
	public static String getNameProperty(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setNameProperty(PropertyContainer node, String name) { DomainMotif.setName(node, name); }
	public static void setNameProperty(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	// get name for Domain-Property (entityNode -> name -> valueNode.name)	
	public static String getEntityName(Node classNode) { return DomainMotif.getEntityProperty(classNode, AppMotif.Properties.name.name()); }
	public static String getEntityName(Node classNode, String defaultValue) { return DomainMotif.getEntityProperty(classNode, AppMotif.Properties.name.name(), defaultValue); }

	public static <T> T getCellType(PropertyContainer container) { return get(container, Properties.cellType.name()); }
	public static <T> T getCellType(PropertyContainer container, T defaultValue) { return has(container, Properties.cellType.name()) ? get(container, Properties.cellType.name()) : defaultValue; }
	public static boolean hasCellType(PropertyContainer container) { return has(container, Properties.cellType.name()); }
	public static <T extends PropertyContainer> T setCellType(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.cellType.name());
	   else
	   	container.setProperty(Properties.cellType.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeCellType(T container) {
		if (has(container, Properties.cellType.name())) container.removeProperty(Properties.cellType.name());
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