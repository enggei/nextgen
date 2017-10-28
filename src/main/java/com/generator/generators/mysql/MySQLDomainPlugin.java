package com.generator.generators.mysql;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
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
      username, columnType, onDelete, whereOperator, inSelect, inWhere, lastParam, host
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
		if(hasLabel(neoNode.getNode(), Entities.Database)) handleDatabase(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.Table)) handleTable(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.Column)) handleColumn(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.ForeignKey)) handleForeignKey(pop, neoNode, selectedNodes);
		if(hasLabel(neoNode.getNode(), Entities.Query)) handleQuery(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if(hasLabel(neoNode.getNode(), Entities.Database)) return newDatabaseEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.Table)) return newTableEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.Column)) return newColumnEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.ForeignKey)) return newForeignKeyEditor(neoNode);
		if(hasLabel(neoNode.getNode(), Entities.Query)) return newQueryEditor(neoNode);
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
	protected Node newTable(String name) { return newTable(getGraph(), name); } 
	protected Node newColumn(String name) { return newColumn(getGraph(), name); } 
	protected Node newForeignKey(String name) { return newForeignKey(getGraph(), name); } 
	protected Node newQuery(String name) { return newQuery(getGraph(), name); } 

	public static Node newDatabase(NeoModel graph, String name) { return graph.newNode(Entities.Database, AppMotif.Properties.name.name(), name); } 
	public static Node newTable(NeoModel graph, String name) { return graph.newNode(Entities.Table, AppMotif.Properties.name.name(), name); } 
	public static Node newColumn(NeoModel graph, String name) { return graph.newNode(Entities.Column, AppMotif.Properties.name.name(), name); } 
	public static Node newForeignKey(NeoModel graph, String name) { return graph.newNode(Entities.ForeignKey, AppMotif.Properties.name.name(), name); } 
	public static Node newQuery(NeoModel graph, String name) { return graph.newNode(Entities.Query, AppMotif.Properties.name.name(), name); } 

}