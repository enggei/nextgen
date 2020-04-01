package com.generator.generators.mysql;

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
 * Auto-generated from domain MySQLDomainPlugin
 */
public abstract class MySQLDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Database, Table, Column, ForeignKey, Index, Query, Sql_statements
   }

   public enum Relations implements RelationshipType {
      DATABASE, SQL_STATEMENTS, TABLE, COLUMN, FK_SRC, FK_DST, TABLE_REFERENCE, INDEXCOLUMN, INDEX_TABLE_REFERENCE, QUERY, QUERY_TABLE, QUERY_COLUMN
   }

   public enum Properties {
      username, value, columnType, name, onDelete, type, whereOperator, inSelect, lastParam, host
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   MySQLDomainPlugin(App app) {
      super(app, "MySQL");

		domainNode = DomainMotif.newDomainNode(getGraph(), "MySQL");
		entitiesNodeMap.put(Entities.Database, DomainMotif.newDomainEntity(getGraph(), Entities.Database, domainNode));
		entitiesNodeMap.put(Entities.Table, DomainMotif.newDomainEntity(getGraph(), Entities.Table, domainNode));
		entitiesNodeMap.put(Entities.Column, DomainMotif.newDomainEntity(getGraph(), Entities.Column, domainNode));
		entitiesNodeMap.put(Entities.ForeignKey, DomainMotif.newDomainEntity(getGraph(), Entities.ForeignKey, domainNode));
		entitiesNodeMap.put(Entities.Index, DomainMotif.newDomainEntity(getGraph(), Entities.Index, domainNode));
		entitiesNodeMap.put(Entities.Query, DomainMotif.newDomainEntity(getGraph(), Entities.Query, domainNode));
		entitiesNodeMap.put(Entities.Sql_statements, DomainMotif.newDomainEntity(getGraph(), Entities.Sql_statements, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Database), Properties.username.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Database), Properties.host.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Table), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.value.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.columnType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ForeignKey), Properties.onDelete.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ForeignKey), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Index), Properties.type.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Index), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Query), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Database), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Sql_statements), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Database), Relations.TABLE.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Table));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Database), Relations.QUERY.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Query));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Table), Relations.COLUMN.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Column));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Table), Relations.TABLE_REFERENCE.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Index));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Column), Relations.FK_SRC.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ForeignKey));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ForeignKey), Relations.FK_DST.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Column));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Index), Relations.INDEXCOLUMN.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Column));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Index), Relations.INDEX_TABLE_REFERENCE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Table));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Query), Relations.QUERY_TABLE.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Table));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Query), Relations.QUERY_COLUMN.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Column));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isDatabase(neoNode.getNode())) handleDatabase(pop, neoNode, selectedNodes);
		if (isTable(neoNode.getNode())) handleTable(pop, neoNode, selectedNodes);
		if (isColumn(neoNode.getNode())) handleColumn(pop, neoNode, selectedNodes);
		if (isForeignKey(neoNode.getNode())) handleForeignKey(pop, neoNode, selectedNodes);
		if (isIndex(neoNode.getNode())) handleIndex(pop, neoNode, selectedNodes);
		if (isQuery(neoNode.getNode())) handleQuery(pop, neoNode, selectedNodes);
		if (isSql_statements(neoNode.getNode())) handleSql_statements(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isDatabase(neoNode.getNode())) return newDatabaseEditor(neoNode);
		if (isTable(neoNode.getNode())) return newTableEditor(neoNode);
		if (isColumn(neoNode.getNode())) return newColumnEditor(neoNode);
		if (isForeignKey(neoNode.getNode())) return newForeignKeyEditor(neoNode);
		if (isIndex(neoNode.getNode())) return newIndexEditor(neoNode);
		if (isQuery(neoNode.getNode())) return newQueryEditor(neoNode);
		if (isSql_statements(neoNode.getNode())) return newSql_statementsEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleDatabase(JPopupMenu pop, NeoNode databaseNode, Set<NeoNode> selectedNodes) { }
	protected void handleTable(JPopupMenu pop, NeoNode tableNode, Set<NeoNode> selectedNodes) { }
	protected void handleColumn(JPopupMenu pop, NeoNode columnNode, Set<NeoNode> selectedNodes) { }
	protected void handleForeignKey(JPopupMenu pop, NeoNode foreignKeyNode, Set<NeoNode> selectedNodes) { }
	protected void handleIndex(JPopupMenu pop, NeoNode indexNode, Set<NeoNode> selectedNodes) { }
	protected void handleQuery(JPopupMenu pop, NeoNode queryNode, Set<NeoNode> selectedNodes) { }
	protected void handleSql_statements(JPopupMenu pop, NeoNode sql_statementsNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDatabaseEditor(NeoNode databaseNode) { return null; }
	protected JComponent newTableEditor(NeoNode tableNode) { return null; }
	protected JComponent newColumnEditor(NeoNode columnNode) { return null; }
	protected JComponent newForeignKeyEditor(NeoNode foreignKeyNode) { return null; }
	protected JComponent newIndexEditor(NeoNode indexNode) { return null; }
	protected JComponent newQueryEditor(NeoNode queryNode) { return null; }
	protected JComponent newSql_statementsEditor(NeoNode sql_statementsNode) { return null; }

	public static boolean isDatabase(Node node) { return hasLabel(node, Entities.Database); }
	public static boolean isTable(Node node) { return hasLabel(node, Entities.Table); }
	public static boolean isColumn(Node node) { return hasLabel(node, Entities.Column); }
	public static boolean isForeignKey(Node node) { return hasLabel(node, Entities.ForeignKey); }
	public static boolean isIndex(Node node) { return hasLabel(node, Entities.Index); }
	public static boolean isQuery(Node node) { return hasLabel(node, Entities.Query); }
	public static boolean isSql_statements(Node node) { return hasLabel(node, Entities.Sql_statements); }

	protected Node newDatabase() { return newDatabase(getGraph()); } 
	protected Node newDatabase(Object username, Object host) { return newDatabase(getGraph(), username, host); } 

	public static Node newDatabase(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Database)); } 
	public static Node newDatabase(NeoModel graph, Object username, Object host) {  	
		final Node newNode = newDatabase(graph); 	
		if (username != null) relate(newNode, DomainMotif.newValueNode(graph, username), RelationshipType.withName(Properties.username.name()));
		if (host != null) relate(newNode, DomainMotif.newValueNode(graph, host), RelationshipType.withName(Properties.host.name())); 	
		return newNode; 
	}

	protected Node newTable() { return newTable(getGraph()); } 
	protected Node newTable(Object name) { return newTable(getGraph(), name); } 

	public static Node newTable(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Table)); } 
	public static Node newTable(NeoModel graph, Object name) {  	
		final Node newNode = newTable(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newColumn() { return newColumn(getGraph()); } 
	protected Node newColumn(Object value, Object columnType, Object name) { return newColumn(getGraph(), value, columnType, name); } 

	public static Node newColumn(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Column)); } 
	public static Node newColumn(NeoModel graph, Object value, Object columnType, Object name) {  	
		final Node newNode = newColumn(graph); 	
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name()));
		if (columnType != null) relate(newNode, DomainMotif.newValueNode(graph, columnType), RelationshipType.withName(Properties.columnType.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newForeignKey() { return newForeignKey(getGraph()); } 
	protected Node newForeignKey(Object onDelete, Object name) { return newForeignKey(getGraph(), onDelete, name); } 

	public static Node newForeignKey(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ForeignKey)); } 
	public static Node newForeignKey(NeoModel graph, Object onDelete, Object name) {  	
		final Node newNode = newForeignKey(graph); 	
		if (onDelete != null) relate(newNode, DomainMotif.newValueNode(graph, onDelete), RelationshipType.withName(Properties.onDelete.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newIndex() { return newIndex(getGraph()); } 
	protected Node newIndex(Object type, Object name) { return newIndex(getGraph(), type, name); } 

	public static Node newIndex(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Index)); } 
	public static Node newIndex(NeoModel graph, Object type, Object name) {  	
		final Node newNode = newIndex(graph); 	
		if (type != null) relate(newNode, DomainMotif.newValueNode(graph, type), RelationshipType.withName(Properties.type.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newQuery() { return newQuery(getGraph()); } 
	protected Node newQuery(Object name) { return newQuery(getGraph(), name); } 

	public static Node newQuery(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Query)); } 
	public static Node newQuery(NeoModel graph, Object name) {  	
		final Node newNode = newQuery(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newSql_statements() { return newSql_statements(getGraph()); }
	public static Node newSql_statements(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Sql_statements)); }


	public static void outgoingDATABASE(Node src, RelationConsumer consumer) { outgoing(src, Relations.DATABASE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDATABASE(Node src) { return other(src, singleOutgoing(src, Relations.DATABASE)); }
	public static void incomingDATABASE(Node src, RelationConsumer consumer) { incoming(src, Relations.DATABASE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDATABASE(Node src) { return other(src, singleIncoming(src, Relations.DATABASE)); }

	public static void outgoingSQL_STATEMENTS(Node src, RelationConsumer consumer) { outgoing(src, Relations.SQL_STATEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSQL_STATEMENTS(Node src) { return other(src, singleOutgoing(src, Relations.SQL_STATEMENTS)); }
	public static void incomingSQL_STATEMENTS(Node src, RelationConsumer consumer) { incoming(src, Relations.SQL_STATEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSQL_STATEMENTS(Node src) { return other(src, singleIncoming(src, Relations.SQL_STATEMENTS)); }

	public static void outgoingTABLE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TABLE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTABLE(Node src) { return other(src, singleOutgoing(src, Relations.TABLE)); }
	public static void incomingTABLE(Node src, RelationConsumer consumer) { incoming(src, Relations.TABLE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTABLE(Node src) { return other(src, singleIncoming(src, Relations.TABLE)); }

	public static void outgoingCOLUMN(Node src, RelationConsumer consumer) { outgoing(src, Relations.COLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOLUMN(Node src) { return other(src, singleOutgoing(src, Relations.COLUMN)); }
	public static void incomingCOLUMN(Node src, RelationConsumer consumer) { incoming(src, Relations.COLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOLUMN(Node src) { return other(src, singleIncoming(src, Relations.COLUMN)); }

	public static void outgoingFK_SRC(Node src, RelationConsumer consumer) { outgoing(src, Relations.FK_SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFK_SRC(Node src) { return other(src, singleOutgoing(src, Relations.FK_SRC)); }
	public static void incomingFK_SRC(Node src, RelationConsumer consumer) { incoming(src, Relations.FK_SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFK_SRC(Node src) { return other(src, singleIncoming(src, Relations.FK_SRC)); }

	public static void outgoingFK_DST(Node src, RelationConsumer consumer) { outgoing(src, Relations.FK_DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFK_DST(Node src) { return other(src, singleOutgoing(src, Relations.FK_DST)); }
	public static void incomingFK_DST(Node src, RelationConsumer consumer) { incoming(src, Relations.FK_DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFK_DST(Node src) { return other(src, singleIncoming(src, Relations.FK_DST)); }

	public static void outgoingTABLE_REFERENCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TABLE_REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTABLE_REFERENCE(Node src) { return other(src, singleOutgoing(src, Relations.TABLE_REFERENCE)); }
	public static void incomingTABLE_REFERENCE(Node src, RelationConsumer consumer) { incoming(src, Relations.TABLE_REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTABLE_REFERENCE(Node src) { return other(src, singleIncoming(src, Relations.TABLE_REFERENCE)); }

	public static void outgoingINDEXCOLUMN(Node src, RelationConsumer consumer) { outgoing(src, Relations.INDEXCOLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINDEXCOLUMN(Node src) { return other(src, singleOutgoing(src, Relations.INDEXCOLUMN)); }
	public static void incomingINDEXCOLUMN(Node src, RelationConsumer consumer) { incoming(src, Relations.INDEXCOLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINDEXCOLUMN(Node src) { return other(src, singleIncoming(src, Relations.INDEXCOLUMN)); }

	public static void outgoingINDEX_TABLE_REFERENCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.INDEX_TABLE_REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINDEX_TABLE_REFERENCE(Node src) { return other(src, singleOutgoing(src, Relations.INDEX_TABLE_REFERENCE)); }
	public static void incomingINDEX_TABLE_REFERENCE(Node src, RelationConsumer consumer) { incoming(src, Relations.INDEX_TABLE_REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINDEX_TABLE_REFERENCE(Node src) { return other(src, singleIncoming(src, Relations.INDEX_TABLE_REFERENCE)); }

	public static void outgoingQUERY(Node src, RelationConsumer consumer) { outgoing(src, Relations.QUERY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingQUERY(Node src) { return other(src, singleOutgoing(src, Relations.QUERY)); }
	public static void incomingQUERY(Node src, RelationConsumer consumer) { incoming(src, Relations.QUERY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingQUERY(Node src) { return other(src, singleIncoming(src, Relations.QUERY)); }

	public static void outgoingQUERY_TABLE(Node src, RelationConsumer consumer) { outgoing(src, Relations.QUERY_TABLE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingQUERY_TABLE(Node src) { return other(src, singleOutgoing(src, Relations.QUERY_TABLE)); }
	public static void incomingQUERY_TABLE(Node src, RelationConsumer consumer) { incoming(src, Relations.QUERY_TABLE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingQUERY_TABLE(Node src) { return other(src, singleIncoming(src, Relations.QUERY_TABLE)); }

	public static void outgoingQUERY_COLUMN(Node src, RelationConsumer consumer) { outgoing(src, Relations.QUERY_COLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingQUERY_COLUMN(Node src) { return other(src, singleOutgoing(src, Relations.QUERY_COLUMN)); }
	public static void incomingQUERY_COLUMN(Node src, RelationConsumer consumer) { incoming(src, Relations.QUERY_COLUMN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingQUERY_COLUMN(Node src) { return other(src, singleIncoming(src, Relations.QUERY_COLUMN)); }


	public static Relationship relateDATABASE(Node src, Node dst) { return relate(src, dst, Relations.DATABASE); }
	public static Relationship relateSQL_STATEMENTS(Node src, Node dst) { return relate(src, dst, Relations.SQL_STATEMENTS); }
	public static Relationship relateTABLE(Node src, Node dst) { return relate(src, dst, Relations.TABLE); }
	public static Relationship relateCOLUMN(Node src, Node dst) { return relate(src, dst, Relations.COLUMN); }
	public static Relationship relateFK_SRC(Node src, Node dst) { return relate(src, dst, Relations.FK_SRC); }
	public static Relationship relateFK_DST(Node src, Node dst) { return relate(src, dst, Relations.FK_DST); }
	public static Relationship relateTABLE_REFERENCE(Node src, Node dst) { return relate(src, dst, Relations.TABLE_REFERENCE); }
	public static Relationship relateINDEXCOLUMN(Node src, Node dst) { return relate(src, dst, Relations.INDEXCOLUMN); }
	public static Relationship relateINDEX_TABLE_REFERENCE(Node src, Node dst) { return relate(src, dst, Relations.INDEX_TABLE_REFERENCE); }
	public static Relationship relateQUERY(Node src, Node dst) { return relate(src, dst, Relations.QUERY); }
	public static Relationship relateQUERY_TABLE(Node src, Node dst) { return relate(src, dst, Relations.QUERY_TABLE); }
	public static Relationship relateQUERY_COLUMN(Node src, Node dst) { return relate(src, dst, Relations.QUERY_COLUMN); }

	// username
	public static <T> T getUsernameProperty(PropertyContainer container) { return getUsernameProperty(container, null); }
	public static <T> T getUsernameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.username.name(), defaultValue); }
	public static boolean hasUsernameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.username.name()); }
	public static <T extends PropertyContainer> T setUsernameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.username.name(), value); return container; }
	public static <T extends PropertyContainer> T removeUsernameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.username.name()); return container; }

	protected <T extends PropertyContainer> T setUsernameProperty(T container, Object value) { setUsernameProperty(getGraph(), container, value); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getValueProperty(container, null); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.value.name()); return container; }

	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setValueProperty(getGraph(), container, value); return container; }

	// columnType
	public static <T> T getColumnTypeProperty(PropertyContainer container) { return getColumnTypeProperty(container, null); }
	public static <T> T getColumnTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.columnType.name(), defaultValue); }
	public static boolean hasColumnTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.columnType.name()); }
	public static <T extends PropertyContainer> T setColumnTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.columnType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeColumnTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.columnType.name()); return container; }

	protected <T extends PropertyContainer> T setColumnTypeProperty(T container, Object value) { setColumnTypeProperty(getGraph(), container, value); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// onDelete
	public static <T> T getOnDeleteProperty(PropertyContainer container) { return getOnDeleteProperty(container, null); }
	public static <T> T getOnDeleteProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.onDelete.name(), defaultValue); }
	public static boolean hasOnDeleteProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.onDelete.name()); }
	public static <T extends PropertyContainer> T setOnDeleteProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.onDelete.name(), value); return container; }
	public static <T extends PropertyContainer> T removeOnDeleteProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.onDelete.name()); return container; }

	protected <T extends PropertyContainer> T setOnDeleteProperty(T container, Object value) { setOnDeleteProperty(getGraph(), container, value); return container; }

	// type
	public static <T> T getTypeProperty(PropertyContainer container) { return getTypeProperty(container, null); }
	public static <T> T getTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.type.name(), defaultValue); }
	public static boolean hasTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.type.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.type.name()); return container; }

	protected <T extends PropertyContainer> T setTypeProperty(T container, Object value) { setTypeProperty(getGraph(), container, value); return container; }

	// whereOperator
	public static <T> T getWhereOperatorProperty(PropertyContainer container) { return getWhereOperatorProperty(container, null); }
	public static <T> T getWhereOperatorProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.whereOperator.name(), defaultValue); }
	public static boolean hasWhereOperatorProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.whereOperator.name()); }
	public static <T extends PropertyContainer> T setWhereOperatorProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.whereOperator.name(), value); return container; }
	public static <T extends PropertyContainer> T removeWhereOperatorProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.whereOperator.name()); return container; }

	protected <T extends PropertyContainer> T setWhereOperatorProperty(T container, Object value) { setWhereOperatorProperty(getGraph(), container, value); return container; }

	// inSelect
	public static <T> T getInSelectProperty(PropertyContainer container) { return getInSelectProperty(container, null); }
	public static <T> T getInSelectProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.inSelect.name(), defaultValue); }
	public static boolean hasInSelectProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.inSelect.name()); }
	public static <T extends PropertyContainer> T setInSelectProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.inSelect.name(), value); return container; }
	public static <T extends PropertyContainer> T removeInSelectProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.inSelect.name()); return container; }

	protected <T extends PropertyContainer> T setInSelectProperty(T container, Object value) { setInSelectProperty(getGraph(), container, value); return container; }

	// lastParam
	public static <T> T getLastParamProperty(PropertyContainer container) { return getLastParamProperty(container, null); }
	public static <T> T getLastParamProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.lastParam.name(), defaultValue); }
	public static boolean hasLastParamProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.lastParam.name()); }
	public static <T extends PropertyContainer> T setLastParamProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.lastParam.name(), value); return container; }
	public static <T extends PropertyContainer> T removeLastParamProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.lastParam.name()); return container; }

	protected <T extends PropertyContainer> T setLastParamProperty(T container, Object value) { setLastParamProperty(getGraph(), container, value); return container; }

	// host
	public static <T> T getHostProperty(PropertyContainer container) { return getHostProperty(container, null); }
	public static <T> T getHostProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.host.name(), defaultValue); }
	public static boolean hasHostProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.host.name()); }
	public static <T extends PropertyContainer> T setHostProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.host.name(), value); return container; }
	public static <T extends PropertyContainer> T removeHostProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.host.name()); return container; }

	protected <T extends PropertyContainer> T setHostProperty(T container, Object value) { setHostProperty(getGraph(), container, value); return container; }

}