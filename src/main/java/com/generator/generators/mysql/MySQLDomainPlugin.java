package com.generator.generators.mysql;

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
 * Auto-generated from domain MySQLDomainPlugin
 */
public abstract class MySQLDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Database, Table, Column, ForeignKey, Query
   }

   public enum Relations implements RelationshipType {
      DATABASE, TABLE, COLUMN, FK_SRC, FK_DST, QUERY, QUERY_TABLE, QUERY_COLUMN
   }

   public enum Properties {
      username, value, columnType, name, onDelete, whereOperator, inSelect, lastParam, host
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   MySQLDomainPlugin(App app) {
      super(app, "MySQL");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "MySQL");
		entitiesNodeMap.put(Entities.Database, newDomainEntity(getGraph(), Entities.Database, domainNode));
		entitiesNodeMap.put(Entities.Table, newDomainEntity(getGraph(), Entities.Table, domainNode));
		entitiesNodeMap.put(Entities.Column, newDomainEntity(getGraph(), Entities.Column, domainNode));
		entitiesNodeMap.put(Entities.ForeignKey, newDomainEntity(getGraph(), Entities.ForeignKey, domainNode));
		entitiesNodeMap.put(Entities.Query, newDomainEntity(getGraph(), Entities.Query, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Database), Properties.username.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Database), Properties.host.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.value.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.columnType.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Column), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ForeignKey), Properties.onDelete.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Query), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Database), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Database), Relations.TABLE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Table));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Database), Relations.QUERY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Query));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Table), Relations.COLUMN.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Column));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Column), Relations.FK_SRC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ForeignKey));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ForeignKey), Relations.FK_DST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Column));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Query), Relations.QUERY_TABLE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Table));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Query), Relations.QUERY_COLUMN.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Column));
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
		if (isQuery(neoNode.getNode())) handleQuery(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isDatabase(neoNode.getNode())) return newDatabaseEditor(neoNode);
		if (isTable(neoNode.getNode())) return newTableEditor(neoNode);
		if (isColumn(neoNode.getNode())) return newColumnEditor(neoNode);
		if (isForeignKey(neoNode.getNode())) return newForeignKeyEditor(neoNode);
		if (isQuery(neoNode.getNode())) return newQueryEditor(neoNode);
      return null;
   }

	protected void handleDatabase(JPopupMenu pop, NeoNode databaseNode, Set<NeoNode> selectedNodes) { }
	protected void handleTable(JPopupMenu pop, NeoNode tableNode, Set<NeoNode> selectedNodes) { }
	protected void handleColumn(JPopupMenu pop, NeoNode columnNode, Set<NeoNode> selectedNodes) { }
	protected void handleForeignKey(JPopupMenu pop, NeoNode foreignKeyNode, Set<NeoNode> selectedNodes) { }
	protected void handleQuery(JPopupMenu pop, NeoNode queryNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDatabaseEditor(NeoNode databaseNode) { return null; }
	protected JComponent newTableEditor(NeoNode tableNode) { return null; }
	protected JComponent newColumnEditor(NeoNode columnNode) { return null; }
	protected JComponent newForeignKeyEditor(NeoNode foreignKeyNode) { return null; }
	protected JComponent newQueryEditor(NeoNode queryNode) { return null; }

	public static boolean isDatabase(Node node) { return hasLabel(node, Entities.Database); }
	public static boolean isTable(Node node) { return hasLabel(node, Entities.Table); }
	public static boolean isColumn(Node node) { return hasLabel(node, Entities.Column); }
	public static boolean isForeignKey(Node node) { return hasLabel(node, Entities.ForeignKey); }
	public static boolean isQuery(Node node) { return hasLabel(node, Entities.Query); }

	protected Node newDatabase() { return newDatabase(getGraph()); } 
	public static Node newDatabase(NeoModel graph) { return newInstanceNode(graph, Entities.Database.name(), entitiesNodeMap.get(Entities.Database)); } 
	protected Node newDatabase(Object username, Object host) { return newDatabase(getGraph(), username, host); } 
	public static Node newDatabase(NeoModel graph, Object username, Object host) {  	
		final Node newNode = newDatabase(graph); 	
		if (username != null) relate(newNode, newValueNode(graph, username), RelationshipType.withName(Properties.username.name()));
		if (host != null) relate(newNode, newValueNode(graph, host), RelationshipType.withName(Properties.host.name())); 	
		return newNode; 
	}

	protected Node newTable() { return newTable(getGraph()); } 
	public static Node newTable(NeoModel graph) { return newInstanceNode(graph, Entities.Table.name(), entitiesNodeMap.get(Entities.Table)); }

	protected Node newColumn() { return newColumn(getGraph()); } 
	public static Node newColumn(NeoModel graph) { return newInstanceNode(graph, Entities.Column.name(), entitiesNodeMap.get(Entities.Column)); } 
	protected Node newColumn(Object value, Object columnType, Object name) { return newColumn(getGraph(), value, columnType, name); } 
	public static Node newColumn(NeoModel graph, Object value, Object columnType, Object name) {  	
		final Node newNode = newColumn(graph); 	
		if (value != null) relate(newNode, newValueNode(graph, value), RelationshipType.withName(Properties.value.name()));
		if (columnType != null) relate(newNode, newValueNode(graph, columnType), RelationshipType.withName(Properties.columnType.name()));
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newForeignKey() { return newForeignKey(getGraph()); } 
	public static Node newForeignKey(NeoModel graph) { return newInstanceNode(graph, Entities.ForeignKey.name(), entitiesNodeMap.get(Entities.ForeignKey)); } 
	protected Node newForeignKey(Object onDelete) { return newForeignKey(getGraph(), onDelete); } 
	public static Node newForeignKey(NeoModel graph, Object onDelete) {  	
		final Node newNode = newForeignKey(graph); 	
		if (onDelete != null) relate(newNode, newValueNode(graph, onDelete), RelationshipType.withName(Properties.onDelete.name())); 	
		return newNode; 
	}

	protected Node newQuery() { return newQuery(getGraph()); } 
	public static Node newQuery(NeoModel graph) { return newInstanceNode(graph, Entities.Query.name(), entitiesNodeMap.get(Entities.Query)); } 
	protected Node newQuery(Object name) { return newQuery(getGraph(), name); } 
	public static Node newQuery(NeoModel graph, Object name) {  	
		final Node newNode = newQuery(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingDATABASE(Node src, RelationConsumer consumer) { outgoing(src, Relations.DATABASE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDATABASE(Node src) { return other(src, singleOutgoing(src, Relations.DATABASE)); }
	public static void incomingDATABASE(Node src, RelationConsumer consumer) { incoming(src, Relations.DATABASE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDATABASE(Node src) { return other(src, singleIncoming(src, Relations.DATABASE)); }

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
	public static Relationship relateTABLE(Node src, Node dst) { return relate(src, dst, Relations.TABLE); }
	public static Relationship relateCOLUMN(Node src, Node dst) { return relate(src, dst, Relations.COLUMN); }
	public static Relationship relateFK_SRC(Node src, Node dst) { return relate(src, dst, Relations.FK_SRC); }
	public static Relationship relateFK_DST(Node src, Node dst) { return relate(src, dst, Relations.FK_DST); }
	public static Relationship relateQUERY(Node src, Node dst) { return relate(src, dst, Relations.QUERY); }
	public static Relationship relateQUERY_TABLE(Node src, Node dst) { return relate(src, dst, Relations.QUERY_TABLE); }
	public static Relationship relateQUERY_COLUMN(Node src, Node dst) { return relate(src, dst, Relations.QUERY_COLUMN); }

	// username
	public static <T> T getUsernameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.username.name()); }
	public static <T> T getUsernameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.username.name(), defaultValue); }
	public static boolean hasUsernameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.username.name()); }
	public static <T extends PropertyContainer> T setUsernameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.username.name(), value); return container; }
	protected <T extends PropertyContainer> T setUsernameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.username.name(), value); return container; }
	public static <T extends PropertyContainer> T removeUsernameProperty(T container) { removeEntityProperty(container, Properties.username.name()); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getEntityProperty(container, Properties.value.name()); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { removeEntityProperty(container, Properties.value.name()); return container; }

	// columnType
	public static <T> T getColumnTypeProperty(PropertyContainer container) { return getEntityProperty(container, Properties.columnType.name()); }
	public static <T> T getColumnTypeProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.columnType.name(), defaultValue); }
	public static boolean hasColumnTypeProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.columnType.name()); }
	public static <T extends PropertyContainer> T setColumnTypeProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.columnType.name(), value); return container; }
	protected <T extends PropertyContainer> T setColumnTypeProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.columnType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeColumnTypeProperty(T container) { removeEntityProperty(container, Properties.columnType.name()); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	// onDelete
	public static <T> T getOnDeleteProperty(PropertyContainer container) { return getEntityProperty(container, Properties.onDelete.name()); }
	public static <T> T getOnDeleteProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.onDelete.name(), defaultValue); }
	public static boolean hasOnDeleteProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.onDelete.name()); }
	public static <T extends PropertyContainer> T setOnDeleteProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.onDelete.name(), value); return container; }
	protected <T extends PropertyContainer> T setOnDeleteProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.onDelete.name(), value); return container; }
	public static <T extends PropertyContainer> T removeOnDeleteProperty(T container) { removeEntityProperty(container, Properties.onDelete.name()); return container; }

	// whereOperator
	public static <T> T getWhereOperatorProperty(PropertyContainer container) { return getEntityProperty(container, Properties.whereOperator.name()); }
	public static <T> T getWhereOperatorProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.whereOperator.name(), defaultValue); }
	public static boolean hasWhereOperatorProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.whereOperator.name()); }
	public static <T extends PropertyContainer> T setWhereOperatorProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.whereOperator.name(), value); return container; }
	protected <T extends PropertyContainer> T setWhereOperatorProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.whereOperator.name(), value); return container; }
	public static <T extends PropertyContainer> T removeWhereOperatorProperty(T container) { removeEntityProperty(container, Properties.whereOperator.name()); return container; }

	// inSelect
	public static <T> T getInSelectProperty(PropertyContainer container) { return getEntityProperty(container, Properties.inSelect.name()); }
	public static <T> T getInSelectProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.inSelect.name(), defaultValue); }
	public static boolean hasInSelectProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.inSelect.name()); }
	public static <T extends PropertyContainer> T setInSelectProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.inSelect.name(), value); return container; }
	protected <T extends PropertyContainer> T setInSelectProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.inSelect.name(), value); return container; }
	public static <T extends PropertyContainer> T removeInSelectProperty(T container) { removeEntityProperty(container, Properties.inSelect.name()); return container; }

	// lastParam
	public static <T> T getLastParamProperty(PropertyContainer container) { return getEntityProperty(container, Properties.lastParam.name()); }
	public static <T> T getLastParamProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.lastParam.name(), defaultValue); }
	public static boolean hasLastParamProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.lastParam.name()); }
	public static <T extends PropertyContainer> T setLastParamProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.lastParam.name(), value); return container; }
	protected <T extends PropertyContainer> T setLastParamProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.lastParam.name(), value); return container; }
	public static <T extends PropertyContainer> T removeLastParamProperty(T container) { removeEntityProperty(container, Properties.lastParam.name()); return container; }

	// host
	public static <T> T getHostProperty(PropertyContainer container) { return getEntityProperty(container, Properties.host.name()); }
	public static <T> T getHostProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.host.name(), defaultValue); }
	public static boolean hasHostProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.host.name()); }
	public static <T extends PropertyContainer> T setHostProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.host.name(), value); return container; }
	protected <T extends PropertyContainer> T setHostProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.host.name(), value); return container; }
	public static <T extends PropertyContainer> T removeHostProperty(T container) { removeEntityProperty(container, Properties.host.name()); return container; }

}