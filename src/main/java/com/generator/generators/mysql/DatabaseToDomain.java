package com.generator.generators.mysql;

import com.generator.NeoModel;
import com.generator.app.AppMotif;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.util.StringUtil;
import org.neo4j.graphdb.Node;

/**
 * Created 10.09.17.
 */
public class DatabaseToDomain extends MySqlParserNodeListener {

   private final NeoModel model;
   protected final java.util.Stack<org.neo4j.graphdb.Node> nodeStack = new java.util.Stack<>();

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

      if (inTable_name && !inConstraintDefinition) {
         final String tableName = StringUtil.capitalize(StringUtil.trimEnds(1, arg.getText()));
         nodeStack.push(model.findOrCreate(MySQLPlugin.Entities.Table, AppMotif.Properties.name.name(), tableName));
      } else if (inColumnDefinition) {
         final org.neo4j.graphdb.Node columnNode = model.findOrCreate(MySQLPlugin.Entities.Column, AppMotif.Properties.name.name(), StringUtil.trimEnds(1, arg.getText()));
         NeoModel.relate(nodeStack.peek(), columnNode, MySQLPlugin.Relations.COLUMN);
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
}