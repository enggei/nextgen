package com.generator.generators.mysql;

import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.util.StringUtil;
import org.paukov.combinatorics3.Generator;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created 09.09.17.
 */
public class MySqlToQueriesGenerator extends MySqlParserNodeListener {

   private final MysqlGroup mysqlGroup = new MysqlGroup();
   private final Stack<MysqlGroup.selectST> selectSTStack = new Stack<>();

   private String tableName;
   private final Set<String> tableColumns = new LinkedHashSet<>();

   public MySqlToQueriesGenerator(boolean debug) {
      super(debug);
   }

   public Stack<MysqlGroup.selectST> done() throws IOException {
      return selectSTStack;
   }

   @Override
   public void enterId_(MySqlParser.Id_Context arg) {
      super.enterId_(arg);
      if (inTable_name && !inConstraintDefinition) {
         this.tableName = StringUtil.trimEnds(1, arg.getText());
      } else if (inColumnDefinition) {
         tableColumns.add(StringUtil.trimEnds(1, arg.getText()));
      }
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