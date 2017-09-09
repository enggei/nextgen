package com.generator.generators.mysql;

import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.util.StringUtil;
import org.paukov.combinatorics3.Generator;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created 09.09.17.
 */
public class MySqlToQueriesGenerator extends MySqlParserNodeListener {

   private final MysqlGroup mysqlGroup = new MysqlGroup();
   private final Stack<MysqlGroup.selectST> selectSTStack = new Stack<>();

   // flags (todo try to generate these as a mask, in MySqlParserNodeListener ?)
   private boolean isTableName = false;
   private boolean columnDefinition = false;
   private boolean isConstraint = false;

   private String tableName;
   private final Set<String> tableColumns = new LinkedHashSet<>();

   public MySqlToQueriesGenerator(boolean debug) {
      super(debug);
   }

   public Stack<MysqlGroup.selectST> done() throws IOException {
      return selectSTStack;
   }

   @Override
   public void exitColCreateTable(MySqlParser.ColCreateTableContext arg) {
      super.exitColCreateTable(arg);
      this.tableName = null;
   }

   @Override
   public void enterTable_name(MySqlParser.Table_nameContext arg) {
      super.enterTable_name(arg);
      this.isTableName = !isConstraint;
   }

   @Override
   public void exitTable_name(MySqlParser.Table_nameContext arg) {
      super.exitTable_name(arg);
      this.isTableName = false;
   }

   @Override
   public void enterConstraintDefinition(MySqlParser.ConstraintDefinitionContext arg) {
      super.enterConstraintDefinition(arg);
      this.isConstraint = true;
   }

   @Override
   public void exitConstraintDefinition(MySqlParser.ConstraintDefinitionContext arg) {
      super.exitConstraintDefinition(arg);
      this.isConstraint = false;
   }

   @Override
   public void enterId_(MySqlParser.Id_Context arg) {
      super.enterId_(arg);
      if (isTableName) {
         this.tableName = StringUtil.trimEnds(1, arg.getText());
      } else if (columnDefinition) {
         tableColumns.add(StringUtil.trimEnds(1, arg.getText()));
      }
   }

   @Override
   public void enterColumnDefinition(MySqlParser.ColumnDefinitionContext arg) {
      super.enterColumnDefinition(arg);
      this.columnDefinition = true;
   }

   @Override
   public void exitColumnDefinition(MySqlParser.ColumnDefinitionContext arg) {
      super.exitColumnDefinition(arg);
      this.columnDefinition = false;
   }

   @Override
   public void exitColumn_def_table_constraints(MySqlParser.Column_def_table_constraintsContext arg) {
      super.exitColumn_def_table_constraints(arg);

      for (int i = 0; i < tableColumns.size(); i++) {
         Generator.combination(tableColumns).simple(i).stream().forEach(cols -> {
            if (cols.isEmpty()) return;

            final MysqlGroup.selectST selectST = mysqlGroup.newselect().
                  setTable(tableName);
            for (String col : cols)
               selectST.addColumnsValue(col);
            selectSTStack.push(selectST);
         });
      }

      final MysqlGroup.selectST selectST = mysqlGroup.newselect().
            setTable(tableName).
            addColumnsValue("*");
      selectSTStack.push(selectST);

      tableColumns.clear();
   }
}