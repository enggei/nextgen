package com.generator.generators.excel;

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
 * Auto-generated from domain ExcelDomainPlugin
 */
public abstract class ExcelDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Workbook, Sheet, Column, Cell, Row
   }

   public enum Relations implements RelationshipType {
      WORKBOOK, SHEET, COL, CELL, REFERENCE, ROW
   }

   public enum Properties {
      name, cellType, value
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   ExcelDomainPlugin(App app) {
      super(app, "Excel");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "Excel");
		entitiesNodeMap.put(Entities.Workbook, newDomainEntity(getGraph(), Entities.Workbook, domainNode));
		entitiesNodeMap.put(Entities.Sheet, newDomainEntity(getGraph(), Entities.Sheet, domainNode));
		entitiesNodeMap.put(Entities.Column, newDomainEntity(getGraph(), Entities.Column, domainNode));
		entitiesNodeMap.put(Entities.Cell, newDomainEntity(getGraph(), Entities.Cell, domainNode));
		entitiesNodeMap.put(Entities.Row, newDomainEntity(getGraph(), Entities.Row, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Workbook), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Sheet), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Cell), Properties.cellType.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Cell), Properties.value.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Row), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Workbook), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Workbook), Relations.SHEET.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Sheet));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sheet), Relations.COL.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Column));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sheet), Relations.ROW.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Row));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Column), Relations.CELL.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Cell));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Cell), Relations.REFERENCE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Cell));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Row), Relations.CELL.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Cell));
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

	public static boolean isWorkbook(Node node) { return hasLabel(node, Entities.Workbook); }
	public static boolean isSheet(Node node) { return hasLabel(node, Entities.Sheet); }
	public static boolean isColumn(Node node) { return hasLabel(node, Entities.Column); }
	public static boolean isCell(Node node) { return hasLabel(node, Entities.Cell); }
	public static boolean isRow(Node node) { return hasLabel(node, Entities.Row); }

	protected Node newWorkbook() { return newWorkbook(getGraph()); } 
	public static Node newWorkbook(NeoModel graph) { return newInstanceNode(graph, Entities.Workbook.name(), entitiesNodeMap.get(Entities.Workbook)); } 
	protected Node newWorkbook(Object name) { return newWorkbook(getGraph(), name); } 
	public static Node newWorkbook(NeoModel graph, Object name) {  	
		final Node newNode = newWorkbook(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newSheet() { return newSheet(getGraph()); } 
	public static Node newSheet(NeoModel graph) { return newInstanceNode(graph, Entities.Sheet.name(), entitiesNodeMap.get(Entities.Sheet)); } 
	protected Node newSheet(Object name) { return newSheet(getGraph(), name); } 
	public static Node newSheet(NeoModel graph, Object name) {  	
		final Node newNode = newSheet(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newColumn() { return newColumn(getGraph()); } 
	public static Node newColumn(NeoModel graph) { return newInstanceNode(graph, Entities.Column.name(), entitiesNodeMap.get(Entities.Column)); } 
	protected Node newColumn(Object name) { return newColumn(getGraph(), name); } 
	public static Node newColumn(NeoModel graph, Object name) {  	
		final Node newNode = newColumn(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newCell() { return newCell(getGraph()); } 
	public static Node newCell(NeoModel graph) { return newInstanceNode(graph, Entities.Cell.name(), entitiesNodeMap.get(Entities.Cell)); } 
	protected Node newCell(Object cellType, Object value) { return newCell(getGraph(), cellType, value); } 
	public static Node newCell(NeoModel graph, Object cellType, Object value) {  	
		final Node newNode = newCell(graph); 	
		if (cellType != null) relate(newNode, newValueNode(graph, cellType), RelationshipType.withName(Properties.cellType.name()));
		if (value != null) relate(newNode, newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}

	protected Node newRow() { return newRow(getGraph()); } 
	public static Node newRow(NeoModel graph) { return newInstanceNode(graph, Entities.Row.name(), entitiesNodeMap.get(Entities.Row)); } 
	protected Node newRow(Object name) { return newRow(getGraph(), name); } 
	public static Node newRow(NeoModel graph, Object name) {  	
		final Node newNode = newRow(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingWORKBOOK(Node src, RelationConsumer consumer) { outgoing(src, Relations.WORKBOOK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingWORKBOOK(Node src) { return other(src, singleOutgoing(src, Relations.WORKBOOK)); }
	public static void incomingWORKBOOK(Node src, RelationConsumer consumer) { incoming(src, Relations.WORKBOOK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingWORKBOOK(Node src) { return other(src, singleIncoming(src, Relations.WORKBOOK)); }

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


	public static Relationship relateWORKBOOK(Node src, Node dst) { return relate(src, dst, Relations.WORKBOOK); }
	public static Relationship relateSHEET(Node src, Node dst) { return relate(src, dst, Relations.SHEET); }
	public static Relationship relateCOL(Node src, Node dst) { return relate(src, dst, Relations.COL); }
	public static Relationship relateCELL(Node src, Node dst) { return relate(src, dst, Relations.CELL); }
	public static Relationship relateREFERENCE(Node src, Node dst) { return relate(src, dst, Relations.REFERENCE); }
	public static Relationship relateROW(Node src, Node dst) { return relate(src, dst, Relations.ROW); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	// cellType
	public static <T> T getCellTypeProperty(PropertyContainer container) { return getEntityProperty(container, Properties.cellType.name()); }
	public static <T> T getCellTypeProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.cellType.name(), defaultValue); }
	public static boolean hasCellTypeProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.cellType.name()); }
	public static <T extends PropertyContainer> T setCellTypeProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.cellType.name(), value); return container; }
	protected <T extends PropertyContainer> T setCellTypeProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.cellType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCellTypeProperty(T container) { removeEntityProperty(container, Properties.cellType.name()); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getEntityProperty(container, Properties.value.name()); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { removeEntityProperty(container, Properties.value.name()); return container; }

}