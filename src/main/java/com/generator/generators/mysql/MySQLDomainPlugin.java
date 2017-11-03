package com.generator.generators.mysql;

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
 * Auto-generated from domain MySQLDomainPlugin
 */
abstract class MySQLDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Database, Table, Column, ForeignKey, Query
   }

   public enum Relations implements RelationshipType {
      TABLE, COLUMN, FK_SRC, FK_DST, QUERY, QUERY_TABLE, QUERY_COLUMN
   }

   public enum Properties {
      username, value, columnType, onDelete, whereOperator, inSelect, lastParam, host
   }

   MySQLDomainPlugin(App app) {
      super(app, "MySQL");
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

	protected void handleDatabase(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleTable(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleColumn(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleForeignKey(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleQuery(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDatabaseEditor(NeoNode neoNode) { return null; }
	protected JComponent newTableEditor(NeoNode neoNode) { return null; }
	protected JComponent newColumnEditor(NeoNode neoNode) { return null; }
	protected JComponent newForeignKeyEditor(NeoNode neoNode) { return null; }
	protected JComponent newQueryEditor(NeoNode neoNode) { return null; }

	protected Node newDatabase(String name) { return newDatabase(getGraph(), name); }
	protected Node newDatabase() { return newDatabase(getGraph()); } 
	protected Node newTable(String name) { return newTable(getGraph(), name); }
	protected Node newTable() { return newTable(getGraph()); } 
	protected Node newColumn(String name) { return newColumn(getGraph(), name); }
	protected Node newColumn() { return newColumn(getGraph()); } 
	protected Node newForeignKey(String name) { return newForeignKey(getGraph(), name); }
	protected Node newForeignKey() { return newForeignKey(getGraph()); } 
	protected Node newQuery(String name) { return newQuery(getGraph(), name); }
	protected Node newQuery() { return newQuery(getGraph()); } 

	public static boolean isDatabase(Node node) { return hasLabel(node, Entities.Database); }
	public static boolean isTable(Node node) { return hasLabel(node, Entities.Table); }
	public static boolean isColumn(Node node) { return hasLabel(node, Entities.Column); }
	public static boolean isForeignKey(Node node) { return hasLabel(node, Entities.ForeignKey); }
	public static boolean isQuery(Node node) { return hasLabel(node, Entities.Query); }

	public static Node newDatabase(NeoModel graph, String name) { return graph.newNode(Entities.Database, AppMotif.Properties.name.name(), name); }
	public static Node newDatabase(NeoModel graph) { return graph.newNode(Entities.Database); }
	public static Node newTable(NeoModel graph, String name) { return graph.newNode(Entities.Table, AppMotif.Properties.name.name(), name); }
	public static Node newTable(NeoModel graph) { return graph.newNode(Entities.Table); }
	public static Node newColumn(NeoModel graph, String name) { return graph.newNode(Entities.Column, AppMotif.Properties.name.name(), name); }
	public static Node newColumn(NeoModel graph) { return graph.newNode(Entities.Column); }
	public static Node newForeignKey(NeoModel graph, String name) { return graph.newNode(Entities.ForeignKey, AppMotif.Properties.name.name(), name); }
	public static Node newForeignKey(NeoModel graph) { return graph.newNode(Entities.ForeignKey); }
	public static Node newQuery(NeoModel graph, String name) { return graph.newNode(Entities.Query, AppMotif.Properties.name.name(), name); }
	public static Node newQuery(NeoModel graph) { return graph.newNode(Entities.Query); }

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


	public static Relationship relateTABLE(Node src, Node dst) { return relate(src, dst, Relations.TABLE); }
	public static Relationship relateCOLUMN(Node src, Node dst) { return relate(src, dst, Relations.COLUMN); }
	public static Relationship relateFK_SRC(Node src, Node dst) { return relate(src, dst, Relations.FK_SRC); }
	public static Relationship relateFK_DST(Node src, Node dst) { return relate(src, dst, Relations.FK_DST); }
	public static Relationship relateQUERY(Node src, Node dst) { return relate(src, dst, Relations.QUERY); }
	public static Relationship relateQUERY_TABLE(Node src, Node dst) { return relate(src, dst, Relations.QUERY_TABLE); }
	public static Relationship relateQUERY_COLUMN(Node src, Node dst) { return relate(src, dst, Relations.QUERY_COLUMN); }

	// get name as property of a node (node.name)
	public static String getNameProperty(PropertyContainer node) { return DomainMotif.getName(node); }
	public static String getNameProperty(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setNameProperty(PropertyContainer node, String name) { DomainMotif.setName(node, name); }
	public static void setNameProperty(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	// get name for Domain-Property (entityNode -> name -> valueNode.name)	
	public static String getEntityName(Node classNode) { return DomainMotif.getPropertyValue(classNode, AppMotif.Properties.name.name()); }
	public static String getEntityName(Node classNode, String defaultValue) { return DomainMotif.getPropertyValue(classNode, AppMotif.Properties.name.name(), defaultValue); }

	public static <T> T getUsername(PropertyContainer container) { return get(container, Properties.username.name()); }
	public static <T> T getUsername(PropertyContainer container, T defaultValue) { return has(container, Properties.username.name()) ? get(container, Properties.username.name()) : defaultValue; }
	public static boolean hasUsername(PropertyContainer container) { return has(container, Properties.username.name()); }
	public static <T extends PropertyContainer> T setUsername(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.username.name());
	   else
	   	container.setProperty(Properties.username.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeUsername(T container) {
		if (has(container, Properties.username.name())) container.removeProperty(Properties.username.name());
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

	public static <T> T getColumnType(PropertyContainer container) { return get(container, Properties.columnType.name()); }
	public static <T> T getColumnType(PropertyContainer container, T defaultValue) { return has(container, Properties.columnType.name()) ? get(container, Properties.columnType.name()) : defaultValue; }
	public static boolean hasColumnType(PropertyContainer container) { return has(container, Properties.columnType.name()); }
	public static <T extends PropertyContainer> T setColumnType(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.columnType.name());
	   else
	   	container.setProperty(Properties.columnType.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeColumnType(T container) {
		if (has(container, Properties.columnType.name())) container.removeProperty(Properties.columnType.name());
	      return container;
	}

	public static <T> T getOnDelete(PropertyContainer container) { return get(container, Properties.onDelete.name()); }
	public static <T> T getOnDelete(PropertyContainer container, T defaultValue) { return has(container, Properties.onDelete.name()) ? get(container, Properties.onDelete.name()) : defaultValue; }
	public static boolean hasOnDelete(PropertyContainer container) { return has(container, Properties.onDelete.name()); }
	public static <T extends PropertyContainer> T setOnDelete(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.onDelete.name());
	   else
	   	container.setProperty(Properties.onDelete.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeOnDelete(T container) {
		if (has(container, Properties.onDelete.name())) container.removeProperty(Properties.onDelete.name());
	      return container;
	}

	public static <T> T getWhereOperator(PropertyContainer container) { return get(container, Properties.whereOperator.name()); }
	public static <T> T getWhereOperator(PropertyContainer container, T defaultValue) { return has(container, Properties.whereOperator.name()) ? get(container, Properties.whereOperator.name()) : defaultValue; }
	public static boolean hasWhereOperator(PropertyContainer container) { return has(container, Properties.whereOperator.name()); }
	public static <T extends PropertyContainer> T setWhereOperator(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.whereOperator.name());
	   else
	   	container.setProperty(Properties.whereOperator.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeWhereOperator(T container) {
		if (has(container, Properties.whereOperator.name())) container.removeProperty(Properties.whereOperator.name());
	      return container;
	}

	public static <T> T getInSelect(PropertyContainer container) { return get(container, Properties.inSelect.name()); }
	public static <T> T getInSelect(PropertyContainer container, T defaultValue) { return has(container, Properties.inSelect.name()) ? get(container, Properties.inSelect.name()) : defaultValue; }
	public static boolean hasInSelect(PropertyContainer container) { return has(container, Properties.inSelect.name()); }
	public static <T extends PropertyContainer> T setInSelect(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.inSelect.name());
	   else
	   	container.setProperty(Properties.inSelect.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeInSelect(T container) {
		if (has(container, Properties.inSelect.name())) container.removeProperty(Properties.inSelect.name());
	      return container;
	}

	public static <T> T getLastParam(PropertyContainer container) { return get(container, Properties.lastParam.name()); }
	public static <T> T getLastParam(PropertyContainer container, T defaultValue) { return has(container, Properties.lastParam.name()) ? get(container, Properties.lastParam.name()) : defaultValue; }
	public static boolean hasLastParam(PropertyContainer container) { return has(container, Properties.lastParam.name()); }
	public static <T extends PropertyContainer> T setLastParam(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.lastParam.name());
	   else
	   	container.setProperty(Properties.lastParam.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeLastParam(T container) {
		if (has(container, Properties.lastParam.name())) container.removeProperty(Properties.lastParam.name());
	      return container;
	}

	public static <T> T getHost(PropertyContainer container) { return get(container, Properties.host.name()); }
	public static <T> T getHost(PropertyContainer container, T defaultValue) { return has(container, Properties.host.name()) ? get(container, Properties.host.name()) : defaultValue; }
	public static boolean hasHost(PropertyContainer container) { return has(container, Properties.host.name()); }
	public static <T extends PropertyContainer> T setHost(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.host.name());
	   else
	   	container.setProperty(Properties.host.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeHost(T container) {
		if (has(container, Properties.host.name())) container.removeProperty(Properties.host.name());
	      return container;
	}

}