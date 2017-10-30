package com.generator.generators.mysql;

import com.generator.app.AppMotif;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.generators.mysql.parser.MySqlParserNodeVisitor;
import com.generator.neo.NeoModel;
import com.generator.util.StringUtil;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.relate;

/**
 * Created 10.09.17.
 */
public class DatabaseToDomain extends MySqlParserNodeListener {

   private final NeoModel model;
   protected final java.util.Stack<org.neo4j.graphdb.Node> nodeStack = new java.util.Stack<>();

   private String currentTableName = "";
   private final Map<String, TableReference> tableMap = new HashMap<>();
   private final Set<ForeignKeyVisitor> foreignKeyVisitorSet = new LinkedHashSet<>();

   DatabaseToDomain(boolean debug, NeoModel model) {
      super(debug);
      this.model = model;
   }

   public org.neo4j.graphdb.Node done() {
      return nodeStack.peek();
   }

   @Override
   public void enterId_(MySqlParser.Id_Context arg) {
      super.enterId_(arg);

      if (inTable_name() && !inConstraintDefinition()) {
         currentTableName = StringUtil.trimEnds(1, arg.getText());
         nodeStack.push(model.newNode(MySQLPlugin.Entities.Table, AppMotif.Properties.name.name(), currentTableName));
         tableMap.put(currentTableName, new TableReference(nodeStack.peek()));

      } else if (inColumnDefinition()) {
         final String columnName = StringUtil.trimEnds(1, arg.getText());
         final org.neo4j.graphdb.Node columnNode = model.newNode(MySQLPlugin.Entities.Column, AppMotif.Properties.name.name(), columnName);
         relate(nodeStack.peek(), columnNode, MySQLPlugin.Relations.COLUMN);
         tableMap.get(currentTableName).columnNodes.put(columnName, columnNode);
         nodeStack.push(columnNode);
      }
   }

   @Override
   public void enterDimensionDatatype(MySqlParser.DimensionDatatypeContext arg) {
      super.enterDimensionDatatype(arg);
      nodeStack.peek().setProperty(MySQLPlugin.Properties.columnType.name(), arg.getText());
   }

   @Override
   public void enterCharDatatype(MySqlParser.CharDatatypeContext arg) {
      super.enterCharDatatype(arg);
      nodeStack.peek().setProperty(MySQLPlugin.Properties.columnType.name(), arg.getText());
   }

   @Override
   public void enterSimpleDatatype(MySqlParser.SimpleDatatypeContext arg) {
      super.enterSimpleDatatype(arg);
      nodeStack.peek().setProperty(MySQLPlugin.Properties.columnType.name(), arg.getText());
   }

   @Override
   public void exitColumnDefinition(MySqlParser.ColumnDefinitionContext arg) {
      super.exitColumnDefinition(arg);
      nodeStack.pop();
   }

   @Override
   public void enterTblConstrFK(MySqlParser.TblConstrFKContext arg) {
      foreignKeyVisitorSet.add(new ForeignKeyVisitor(currentTableName, arg));
      super.enterTblConstrFK(arg);
   }

   void assignForeignKeys() {
      for (ForeignKeyVisitor foreignKeyVisitor : foreignKeyVisitorSet) {
         final TableReference tableReference = tableMap.get(foreignKeyVisitor.tableName);
         final org.neo4j.graphdb.Node fkNode = model.newNode(MySQLPlugin.Entities.ForeignKey, AppMotif.Properties.name.name(), foreignKeyVisitor.id, MySQLPlugin.Properties.onDelete.name(), foreignKeyVisitor.onDeleteAction);
         for (String colName : foreignKeyVisitor.indexColNames) {
            final org.neo4j.graphdb.Node columnNode = tableReference.columnNodes.get(colName);
            relate(columnNode, fkNode, MySQLPlugin.Relations.FK_SRC);
         }

         final TableReference referenceTableReference = tableMap.get(foreignKeyVisitor.referenceTable);
         for (String referenceColumn : foreignKeyVisitor.indexReferenceColNames) {
            final org.neo4j.graphdb.Node referenceColumnNode = referenceTableReference.columnNodes.get(referenceColumn);
            relate(fkNode, referenceColumnNode, MySQLPlugin.Relations.FK_DST);
         }

      }
   }

   private final class TableReference {

      private final org.neo4j.graphdb.Node tableNode;
      private final Map<String, org.neo4j.graphdb.Node> columnNodes = new HashMap<>();

      private TableReference(org.neo4j.graphdb.Node tableNode) {
         this.tableNode = tableNode;
      }
   }

   private final class ForeignKeyVisitor extends MySqlParserNodeVisitor {

      private final String tableName;
      private String id = "";
      private final Set<String> indexColNames = new LinkedHashSet<>();
      private final Set<String> indexReferenceColNames = new LinkedHashSet<>();
      private String referenceTable = "";
      private String onDeleteAction = "";

      ForeignKeyVisitor(String currentTableName, MySqlParser.TblConstrFKContext arg) {
         tableName = currentTableName;
         visitTblConstrFK(arg);
      }

      @Override
      public Node visitTblConstrFK(MySqlParser.TblConstrFKContext arg) {
         final Node node = super.visitTblConstrFK(arg);
         for (Node child : node.children) {
            if ("Id_".equals(child.name)) {
               id = StringUtil.trimEnds(1, child.value);
            } else if ("Index_colname_list".equals(child.name)) {
               final Node indexColNameList = child.children.iterator().next();
               for (Node colName : indexColNameList.children) {
                  indexColNames.add(StringUtil.trimEnds(1, colName.value));
               }
            }
         }
         return node;
      }

      @Override
      public Node visitReference_definition(MySqlParser.Reference_definitionContext arg) {

         final Node node = super.visitReference_definition(arg);

         for (Node child : node.children) {
            if ("Table_name".equals(child.name)) {
               final Node tableId = child.children.iterator().next();
               referenceTable = StringUtil.trimEnds(1, tableId.value);
            } else if ("Index_colname_list".equals(child.name)) {
               final Node colNames = child.children.iterator().next();
               for (Node colName : colNames.children) {
                  this.indexReferenceColNames.add(StringUtil.trimEnds(1, colName.value));
               }
            } else if ("On_delete_action".equals(child.name)) {
               final Node referenceAction = child.children.iterator().next();
               this.onDeleteAction = referenceAction.value;
            }
         }

         return node;
      }

      @Override
      public String toString() {
         final StringBuilder stringBuilder = new StringBuilder("");
         stringBuilder.append("\n\tid ").append(id).append("\n\t");
         for (String indexColName : indexColNames) {
            stringBuilder.append(indexColName).append(" ");
         }
         stringBuilder.append("-> ").append(referenceTable).append(" (");
         for (String referenceColName : indexReferenceColNames) {
            stringBuilder.append(referenceColName);
         }
         stringBuilder.append(")");

         stringBuilder.append("\n\ton delete ").append(onDeleteAction);

         return stringBuilder.toString();
      }
   }
}