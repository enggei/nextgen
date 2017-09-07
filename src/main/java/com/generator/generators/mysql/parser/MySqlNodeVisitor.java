package com.generator.generators.mysql.parser;

public class MySqlNodeVisitor extends MySqlParserBaseVisitor<MySqlNodeVisitor.Node> {

	public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public MySqlNodeVisitor.Node visitSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg0) {
		 System.out.println("visitSql_statements");
		final Node node = new Node("visitSql_statements", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg0) {
		 System.out.println("visitSql_statement");
		final Node node = new Node("visitSql_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg0) {
		 System.out.println("visitEmpty_statement");
		final Node node = new Node("visitEmpty_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg0) {
		 System.out.println("visitDdl_statement");
		final Node node = new Node("visitDdl_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg0) {
		 System.out.println("visitDml_statement");
		final Node node = new Node("visitDml_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg0) {
		 System.out.println("visitTransaction_statement");
		final Node node = new Node("visitTransaction_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg0) {
		 System.out.println("visitReplication_statement");
		final Node node = new Node("visitReplication_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg0) {
		 System.out.println("visitPrepared_statement");
		final Node node = new Node("visitPrepared_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg0) {
		 System.out.println("visitCompound_statement");
		final Node node = new Node("visitCompound_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg0) {
		 System.out.println("visitAdministration_statement");
		final Node node = new Node("visitAdministration_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg0) {
		 System.out.println("visitUtility_statement");
		final Node node = new Node("visitUtility_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg0) {
		 System.out.println("visitCreate_database");
		final Node node = new Node("visitCreate_database", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg0) {
		 System.out.println("visitCreate_event");
		final Node node = new Node("visitCreate_event", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg0) {
		 System.out.println("visitCreate_index");
		final Node node = new Node("visitCreate_index", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg0) {
		 System.out.println("visitCreate_logfile_group");
		final Node node = new Node("visitCreate_logfile_group", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg0) {
		 System.out.println("visitCreate_procedure");
		final Node node = new Node("visitCreate_procedure", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg0) {
		 System.out.println("visitCreate_function");
		final Node node = new Node("visitCreate_function", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg0) {
		 System.out.println("visitCreate_server");
		final Node node = new Node("visitCreate_server", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg0) {
		 System.out.println("visitCopyCreateTable");
		final Node node = new Node("visitCopyCreateTable", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg0) {
		 System.out.println("visitQueryCreateTable");
		final Node node = new Node("visitQueryCreateTable", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg0) {
		 System.out.println("visitColCreateTable");
		final Node node = new Node("visitColCreateTable", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg0) {
		 System.out.println("visitCreate_tablespace_innodb");
		final Node node = new Node("visitCreate_tablespace_innodb", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg0) {
		 System.out.println("visitCreate_tablespace_ndb");
		final Node node = new Node("visitCreate_tablespace_ndb", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg0) {
		 System.out.println("visitCreate_trigger");
		final Node node = new Node("visitCreate_trigger", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg0) {
		 System.out.println("visitCreate_view");
		final Node node = new Node("visitCreate_view", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg0) {
		 System.out.println("visitCreate_database_option");
		final Node node = new Node("visitCreate_database_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg0) {
		 System.out.println("visitOwner_statement");
		final Node node = new Node("visitOwner_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg0) {
		 System.out.println("visitPreciseSchedule");
		final Node node = new Node("visitPreciseSchedule", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg0) {
		 System.out.println("visitIntervalSchedule");
		final Node node = new Node("visitIntervalSchedule", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg0) {
		 System.out.println("visitTimestamp_value");
		final Node node = new Node("visitTimestamp_value", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg0) {
		 System.out.println("visitInterval_expr");
		final Node node = new Node("visitInterval_expr", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg0) {
		 System.out.println("visitInterval_type");
		final Node node = new Node("visitInterval_type", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg0) {
		 System.out.println("visitIndex_type");
		final Node node = new Node("visitIndex_type", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg0) {
		 System.out.println("visitIndex_option");
		final Node node = new Node("visitIndex_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg0) {
		 System.out.println("visitProc_param");
		final Node node = new Node("visitProc_param", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg0) {
		 System.out.println("visitFunc_param");
		final Node node = new Node("visitFunc_param", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg0) {
		 System.out.println("visitRcComment");
		final Node node = new Node("visitRcComment", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg0) {
		 System.out.println("visitRcSqllang");
		final Node node = new Node("visitRcSqllang", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg0) {
		 System.out.println("visitRcDeterm");
		final Node node = new Node("visitRcDeterm", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg0) {
		 System.out.println("visitRoot");
		final Node node = new Node("visitRoot", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg0) {
		 System.out.println("visitRcSqldata");
		final Node node = new Node("visitRcSqldata", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg0) {
		 System.out.println("visitRcSecurestmt");
		final Node node = new Node("visitRcSecurestmt", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg0) {
		 System.out.println("visitServer_option");
		final Node node = new Node("visitServer_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg0) {
		 System.out.println("visitColumn_def_table_constraints");
		final Node node = new Node("visitColumn_def_table_constraints", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg0) {
		 System.out.println("visitColumnDefinition");
		final Node node = new Node("visitColumnDefinition", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg0) {
		 System.out.println("visitConstraintDefinition");
		final Node node = new Node("visitConstraintDefinition", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg0) {
		 System.out.println("visitIndexDefinition");
		final Node node = new Node("visitIndexDefinition", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg0) {
		 System.out.println("visitColumn_definition");
		final Node node = new Node("visitColumn_definition", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg0) {
		 System.out.println("visitColConstrNull");
		final Node node = new Node("visitColConstrNull", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg0) {
		 System.out.println("visitColConstrDflt");
		final Node node = new Node("visitColConstrDflt", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg0) {
		 System.out.println("visitColConstrAuInc");
		final Node node = new Node("visitColConstrAuInc", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg0) {
		 System.out.println("visitColConstrPK");
		final Node node = new Node("visitColConstrPK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg0) {
		 System.out.println("visitColConstrUK");
		final Node node = new Node("visitColConstrUK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg0) {
		 System.out.println("visitColConstrComment");
		final Node node = new Node("visitColConstrComment", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg0) {
		 System.out.println("visitColConstrForm");
		final Node node = new Node("visitColConstrForm", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg0) {
		 System.out.println("visitColConstrStorage");
		final Node node = new Node("visitColConstrStorage", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg0) {
		 System.out.println("visitColConstrRefdef");
		final Node node = new Node("visitColConstrRefdef", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg0) {
		 System.out.println("visitTblConstrPK");
		final Node node = new Node("visitTblConstrPK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg0) {
		 System.out.println("visitTblConstrUK");
		final Node node = new Node("visitTblConstrUK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg0) {
		 System.out.println("visitTblConstrFK");
		final Node node = new Node("visitTblConstrFK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg0) {
		 System.out.println("visitTblConstCheck");
		final Node node = new Node("visitTblConstCheck", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg0) {
		 System.out.println("visitReference_definition");
		final Node node = new Node("visitReference_definition", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg0) {
		 System.out.println("visitOn_delete_action");
		final Node node = new Node("visitOn_delete_action", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg0) {
		 System.out.println("visitOn_update_action");
		final Node node = new Node("visitOn_update_action", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg0) {
		 System.out.println("visitReference_action_control_type");
		final Node node = new Node("visitReference_action_control_type", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg0) {
		 System.out.println("visitSimpleIndex");
		final Node node = new Node("visitSimpleIndex", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg0) {
		 System.out.println("visitSpecIndex");
		final Node node = new Node("visitSpecIndex", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg0) {
		 System.out.println("visitTblOptEngine");
		final Node node = new Node("visitTblOptEngine", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg0) {
		 System.out.println("visitTblOptAuInc");
		final Node node = new Node("visitTblOptAuInc", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg0) {
		 System.out.println("visitTblOptAvgRLen");
		final Node node = new Node("visitTblOptAvgRLen", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg0) {
		 System.out.println("visitTblOptDefCharSet");
		final Node node = new Node("visitTblOptDefCharSet", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg0) {
		 System.out.println("visitTblOptChkSum");
		final Node node = new Node("visitTblOptChkSum", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg0) {
		 System.out.println("visitTblOptDefCollate");
		final Node node = new Node("visitTblOptDefCollate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg0) {
		 System.out.println("visitTblOptComment");
		final Node node = new Node("visitTblOptComment", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg0) {
		 System.out.println("visitTblOptCompr");
		final Node node = new Node("visitTblOptCompr", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg0) {
		 System.out.println("visitTblOptConn");
		final Node node = new Node("visitTblOptConn", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg0) {
		 System.out.println("visitTblOptDataDir");
		final Node node = new Node("visitTblOptDataDir", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg0) {
		 System.out.println("visitTblOptDelKW");
		final Node node = new Node("visitTblOptDelKW", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg0) {
		 System.out.println("visitTblOptEncr");
		final Node node = new Node("visitTblOptEncr", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg0) {
		 System.out.println("visitTblOptIndexDir");
		final Node node = new Node("visitTblOptIndexDir", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg0) {
		 System.out.println("visitTblOptInsMeth");
		final Node node = new Node("visitTblOptInsMeth", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg0) {
		 System.out.println("visitTblOptKeyBlockSz");
		final Node node = new Node("visitTblOptKeyBlockSz", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg0) {
		 System.out.println("visitTblOptMaxRows");
		final Node node = new Node("visitTblOptMaxRows", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg0) {
		 System.out.println("visitTblOptMinRows");
		final Node node = new Node("visitTblOptMinRows", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg0) {
		 System.out.println("visitTblOptPackK");
		final Node node = new Node("visitTblOptPackK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg0) {
		 System.out.println("visitTblOptPasswd");
		final Node node = new Node("visitTblOptPasswd", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg0) {
		 System.out.println("visitTblOptRowFormat");
		final Node node = new Node("visitTblOptRowFormat", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg0) {
		 System.out.println("visitTblOptStatAutoR");
		final Node node = new Node("visitTblOptStatAutoR", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg0) {
		 System.out.println("visitTblOptStatPersist");
		final Node node = new Node("visitTblOptStatPersist", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg0) {
		 System.out.println("visitTblOptStatSamplPg");
		final Node node = new Node("visitTblOptStatSamplPg", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg0) {
		 System.out.println("visitTblOptTablespace");
		final Node node = new Node("visitTblOptTablespace", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg0) {
		 System.out.println("visitTblOptUnion");
		final Node node = new Node("visitTblOptUnion", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg0) {
		 System.out.println("visitPartition_options");
		final Node node = new Node("visitPartition_options", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg0) {
		 System.out.println("visitPartition_function_definition");
		final Node node = new Node("visitPartition_function_definition", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg0) {
		 System.out.println("visitLinear_partition_func_def");
		final Node node = new Node("visitLinear_partition_func_def", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg0) {
		 System.out.println("visitPartition_def");
		final Node node = new Node("visitPartition_def", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg0) {
		 System.out.println("visitSubpartition_def");
		final Node node = new Node("visitSubpartition_def", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg0) {
		 System.out.println("visitAlterDb");
		final Node node = new Node("visitAlterDb", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg0) {
		 System.out.println("visitAlterDbUpgradeName");
		final Node node = new Node("visitAlterDbUpgradeName", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg0) {
		 System.out.println("visitAlter_event");
		final Node node = new Node("visitAlter_event", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg0) {
		 System.out.println("visitAlter_function");
		final Node node = new Node("visitAlter_function", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg0) {
		 System.out.println("visitAlter_instance");
		final Node node = new Node("visitAlter_instance", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg0) {
		 System.out.println("visitAlter_logfile_group");
		final Node node = new Node("visitAlter_logfile_group", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg0) {
		 System.out.println("visitAlter_procedure");
		final Node node = new Node("visitAlter_procedure", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg0) {
		 System.out.println("visitAlter_server");
		final Node node = new Node("visitAlter_server", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg0) {
		 System.out.println("visitAlter_table");
		final Node node = new Node("visitAlter_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg0) {
		 System.out.println("visitAlter_tablespace");
		final Node node = new Node("visitAlter_tablespace", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg0) {
		 System.out.println("visitAlter_view");
		final Node node = new Node("visitAlter_view", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg0) {
		 System.out.println("visitAltblTableOpt");
		final Node node = new Node("visitAltblTableOpt", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg0) {
		 System.out.println("visitAltblAddCol");
		final Node node = new Node("visitAltblAddCol", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg0) {
		 System.out.println("visitAltblAddCols");
		final Node node = new Node("visitAltblAddCols", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg0) {
		 System.out.println("visitAltblAddIndex");
		final Node node = new Node("visitAltblAddIndex", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg0) {
		 System.out.println("visitAltblAddPK");
		final Node node = new Node("visitAltblAddPK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg0) {
		 System.out.println("visitAltblAddUK");
		final Node node = new Node("visitAltblAddUK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg0) {
		 System.out.println("visitAltblAddSpecIndex");
		final Node node = new Node("visitAltblAddSpecIndex", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg0) {
		 System.out.println("visitAltblAddFK");
		final Node node = new Node("visitAltblAddFK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg0) {
		 System.out.println("visitAltblAlg");
		final Node node = new Node("visitAltblAlg", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg0) {
		 System.out.println("visitAltblColDef");
		final Node node = new Node("visitAltblColDef", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg0) {
		 System.out.println("visitAltblColChange");
		final Node node = new Node("visitAltblColChange", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg0) {
		 System.out.println("visitAltblLock");
		final Node node = new Node("visitAltblLock", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg0) {
		 System.out.println("visitAltblColMod");
		final Node node = new Node("visitAltblColMod", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg0) {
		 System.out.println("visitAltblColDrop");
		final Node node = new Node("visitAltblColDrop", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg0) {
		 System.out.println("visitAltblDropPK");
		final Node node = new Node("visitAltblDropPK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg0) {
		 System.out.println("visitAltblDropIndex");
		final Node node = new Node("visitAltblDropIndex", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg0) {
		 System.out.println("visitAltblDropFK");
		final Node node = new Node("visitAltblDropFK", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg0) {
		 System.out.println("visitAltblDisKey");
		final Node node = new Node("visitAltblDisKey", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg0) {
		 System.out.println("visitAltblEnKey");
		final Node node = new Node("visitAltblEnKey", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg0) {
		 System.out.println("visitAltblRenameTbl");
		final Node node = new Node("visitAltblRenameTbl", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg0) {
		 System.out.println("visitAltblResort");
		final Node node = new Node("visitAltblResort", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg0) {
		 System.out.println("visitAltblConvert");
		final Node node = new Node("visitAltblConvert", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg0) {
		 System.out.println("visitAltblDefCharset");
		final Node node = new Node("visitAltblDefCharset", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg0) {
		 System.out.println("visitAltblDisTblspace");
		final Node node = new Node("visitAltblDisTblspace", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg0) {
		 System.out.println("visitAltblImpTblSpace");
		final Node node = new Node("visitAltblImpTblSpace", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg0) {
		 System.out.println("visitAltblForce");
		final Node node = new Node("visitAltblForce", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg0) {
		 System.out.println("visitAltblValid");
		final Node node = new Node("visitAltblValid", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg0) {
		 System.out.println("visitAltblAddPart");
		final Node node = new Node("visitAltblAddPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg0) {
		 System.out.println("visitAltblDropPart");
		final Node node = new Node("visitAltblDropPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg0) {
		 System.out.println("visitAltblDiscartPart");
		final Node node = new Node("visitAltblDiscartPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg0) {
		 System.out.println("visitAltblImportPart");
		final Node node = new Node("visitAltblImportPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg0) {
		 System.out.println("visitAltblTruncPart");
		final Node node = new Node("visitAltblTruncPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg0) {
		 System.out.println("visitAltblCoalPart");
		final Node node = new Node("visitAltblCoalPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg0) {
		 System.out.println("visitAltblReorgPart");
		final Node node = new Node("visitAltblReorgPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg0) {
		 System.out.println("visitAltblExchPart");
		final Node node = new Node("visitAltblExchPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg0) {
		 System.out.println("visitAltblAnalPart");
		final Node node = new Node("visitAltblAnalPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg0) {
		 System.out.println("visitAltblCheckPart");
		final Node node = new Node("visitAltblCheckPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg0) {
		 System.out.println("visitAltblOptimPart");
		final Node node = new Node("visitAltblOptimPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg0) {
		 System.out.println("visitAltblRebuildPart");
		final Node node = new Node("visitAltblRebuildPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg0) {
		 System.out.println("visitAltblRepairPart");
		final Node node = new Node("visitAltblRepairPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg0) {
		 System.out.println("visitAltblRemovePart");
		final Node node = new Node("visitAltblRemovePart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg0) {
		 System.out.println("visitAltblUpgrPart");
		final Node node = new Node("visitAltblUpgrPart", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg0) {
		 System.out.println("visitDrop_database");
		final Node node = new Node("visitDrop_database", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg0) {
		 System.out.println("visitDrop_event");
		final Node node = new Node("visitDrop_event", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg0) {
		 System.out.println("visitDrop_index");
		final Node node = new Node("visitDrop_index", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg0) {
		 System.out.println("visitDrop_logfile_group");
		final Node node = new Node("visitDrop_logfile_group", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg0) {
		 System.out.println("visitDrop_procedure");
		final Node node = new Node("visitDrop_procedure", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg0) {
		 System.out.println("visitDrop_function");
		final Node node = new Node("visitDrop_function", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg0) {
		 System.out.println("visitDrop_server");
		final Node node = new Node("visitDrop_server", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg0) {
		 System.out.println("visitDrop_table");
		final Node node = new Node("visitDrop_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg0) {
		 System.out.println("visitDrop_tablespace");
		final Node node = new Node("visitDrop_tablespace", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg0) {
		 System.out.println("visitDrop_trigger");
		final Node node = new Node("visitDrop_trigger", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg0) {
		 System.out.println("visitDrop_view");
		final Node node = new Node("visitDrop_view", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg0) {
		 System.out.println("visitRename_table");
		final Node node = new Node("visitRename_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg0) {
		 System.out.println("visitTruncate_table");
		final Node node = new Node("visitTruncate_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg0) {
		 System.out.println("visitCall_statement");
		final Node node = new Node("visitCall_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg0) {
		 System.out.println("visitDelete_statement");
		final Node node = new Node("visitDelete_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg0) {
		 System.out.println("visitDo_statement");
		final Node node = new Node("visitDo_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg0) {
		 System.out.println("visitHandler_statement");
		final Node node = new Node("visitHandler_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg0) {
		 System.out.println("visitInsert_statement");
		final Node node = new Node("visitInsert_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg0) {
		 System.out.println("visitLoad_data_statement");
		final Node node = new Node("visitLoad_data_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg0) {
		 System.out.println("visitLoad_xml_statement");
		final Node node = new Node("visitLoad_xml_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg0) {
		 System.out.println("visitReplace_statement");
		final Node node = new Node("visitReplace_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg0) {
		 System.out.println("visitSimpleSelect");
		final Node node = new Node("visitSimpleSelect", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg0) {
		 System.out.println("visitParenSelect");
		final Node node = new Node("visitParenSelect", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg0) {
		 System.out.println("visitUnionSelect");
		final Node node = new Node("visitUnionSelect", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg0) {
		 System.out.println("visitUnionParenSelect");
		final Node node = new Node("visitUnionParenSelect", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg0) {
		 System.out.println("visitUpdate_statement");
		final Node node = new Node("visitUpdate_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg0) {
		 System.out.println("visitInsert_statement_value");
		final Node node = new Node("visitInsert_statement_value", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg0) {
		 System.out.println("visitUpdate_elem");
		final Node node = new Node("visitUpdate_elem", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg0) {
		 System.out.println("visitCol_or_uservar");
		final Node node = new Node("visitCol_or_uservar", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg0) {
		 System.out.println("visitSingle_delete_statement");
		final Node node = new Node("visitSingle_delete_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg0) {
		 System.out.println("visitMultiple_delete_statement");
		final Node node = new Node("visitMultiple_delete_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg0) {
		 System.out.println("visitHandler_open_statement");
		final Node node = new Node("visitHandler_open_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg0) {
		 System.out.println("visitHandler_read_index_statement");
		final Node node = new Node("visitHandler_read_index_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg0) {
		 System.out.println("visitHandler_read_statement");
		final Node node = new Node("visitHandler_read_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg0) {
		 System.out.println("visitHandler_close_statement");
		final Node node = new Node("visitHandler_close_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg0) {
		 System.out.println("visitSingle_update_statement");
		final Node node = new Node("visitSingle_update_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg0) {
		 System.out.println("visitMultiple_update_statement");
		final Node node = new Node("visitMultiple_update_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg0) {
		 System.out.println("visitOrder_by_clause");
		final Node node = new Node("visitOrder_by_clause", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg0) {
		 System.out.println("visitOrder_by_expression");
		final Node node = new Node("visitOrder_by_expression", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg0) {
		 System.out.println("visitTable_sources");
		final Node node = new Node("visitTable_sources", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg0) {
		 System.out.println("visitTable_source");
		final Node node = new Node("visitTable_source", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg0) {
		 System.out.println("visitAtomTableItem");
		final Node node = new Node("visitAtomTableItem", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg0) {
		 System.out.println("visitSubqueryTableItem");
		final Node node = new Node("visitSubqueryTableItem", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg0) {
		 System.out.println("visitTableSourcesItem");
		final Node node = new Node("visitTableSourcesItem", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg0) {
		 System.out.println("visitIndex_hint");
		final Node node = new Node("visitIndex_hint", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg0) {
		 System.out.println("visitInnerJoin");
		final Node node = new Node("visitInnerJoin", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg0) {
		 System.out.println("visitStraightJoin");
		final Node node = new Node("visitStraightJoin", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg0) {
		 System.out.println("visitOuterJoin");
		final Node node = new Node("visitOuterJoin", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg0) {
		 System.out.println("visitNaturalJoin");
		final Node node = new Node("visitNaturalJoin", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg0) {
		 System.out.println("visitSubquery");
		final Node node = new Node("visitSubquery", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg0) {
		 System.out.println("visitQuery_expression");
		final Node node = new Node("visitQuery_expression", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg0) {
		 System.out.println("visitQuery_expression_nointo");
		final Node node = new Node("visitQuery_expression_nointo", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg0) {
		 System.out.println("visitQuery_specification");
		final Node node = new Node("visitQuery_specification", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg0) {
		 System.out.println("visitQuery_specification_nointo");
		final Node node = new Node("visitQuery_specification_nointo", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg0) {
		 System.out.println("visitUnion_parenth");
		final Node node = new Node("visitUnion_parenth", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg0) {
		 System.out.println("visitUnion_statement");
		final Node node = new Node("visitUnion_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg0) {
		 System.out.println("visitSelect_spec");
		final Node node = new Node("visitSelect_spec", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg0) {
		 System.out.println("visitSelect_list");
		final Node node = new Node("visitSelect_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg0) {
		 System.out.println("visitSellistelAllCol");
		final Node node = new Node("visitSellistelAllCol", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg0) {
		 System.out.println("visitSellistelCol");
		final Node node = new Node("visitSellistelCol", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg0) {
		 System.out.println("visitSellistelFunc");
		final Node node = new Node("visitSellistelFunc", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg0) {
		 System.out.println("visitSellistelExpr");
		final Node node = new Node("visitSellistelExpr", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg0) {
		 System.out.println("visitSelectIntoVars");
		final Node node = new Node("visitSelectIntoVars", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg0) {
		 System.out.println("visitSelectIntoDump");
		final Node node = new Node("visitSelectIntoDump", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg0) {
		 System.out.println("visitSelectIntoOutfile");
		final Node node = new Node("visitSelectIntoOutfile", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg0) {
		 System.out.println("visitFrom_clause");
		final Node node = new Node("visitFrom_clause", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg0) {
		 System.out.println("visitGroup_by_item");
		final Node node = new Node("visitGroup_by_item", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg0) {
		 System.out.println("visitLimit_clause");
		final Node node = new Node("visitLimit_clause", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg0) {
		 System.out.println("visitStart_transaction");
		final Node node = new Node("visitStart_transaction", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg0) {
		 System.out.println("visitBegin_work");
		final Node node = new Node("visitBegin_work", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg0) {
		 System.out.println("visitCommit_work");
		final Node node = new Node("visitCommit_work", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg0) {
		 System.out.println("visitRollback_work");
		final Node node = new Node("visitRollback_work", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg0) {
		 System.out.println("visitSavepoint_statement");
		final Node node = new Node("visitSavepoint_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg0) {
		 System.out.println("visitRollback_statement");
		final Node node = new Node("visitRollback_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg0) {
		 System.out.println("visitRelease_statement");
		final Node node = new Node("visitRelease_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg0) {
		 System.out.println("visitLock_tables");
		final Node node = new Node("visitLock_tables", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg0) {
		 System.out.println("visitUnlock_tables");
		final Node node = new Node("visitUnlock_tables", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg0) {
		 System.out.println("visitSet_autocommit_statement");
		final Node node = new Node("visitSet_autocommit_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg0) {
		 System.out.println("visitSet_transaction_statement");
		final Node node = new Node("visitSet_transaction_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg0) {
		 System.out.println("visitTransact_option");
		final Node node = new Node("visitTransact_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg0) {
		 System.out.println("visitLock_table_element");
		final Node node = new Node("visitLock_table_element", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg0) {
		 System.out.println("visitTrans_characteristic");
		final Node node = new Node("visitTrans_characteristic", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg0) {
		 System.out.println("visitTransaction_level");
		final Node node = new Node("visitTransaction_level", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg0) {
		 System.out.println("visitChange_master");
		final Node node = new Node("visitChange_master", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg0) {
		 System.out.println("visitChange_repl_filter");
		final Node node = new Node("visitChange_repl_filter", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg0) {
		 System.out.println("visitPurge_binary_logs");
		final Node node = new Node("visitPurge_binary_logs", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg0) {
		 System.out.println("visitReset_master");
		final Node node = new Node("visitReset_master", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg0) {
		 System.out.println("visitReset_slave");
		final Node node = new Node("visitReset_slave", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg0) {
		 System.out.println("visitStart_slave");
		final Node node = new Node("visitStart_slave", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg0) {
		 System.out.println("visitStop_slave");
		final Node node = new Node("visitStop_slave", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg0) {
		 System.out.println("visitStart_group_repl");
		final Node node = new Node("visitStart_group_repl", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg0) {
		 System.out.println("visitStop_group_repl");
		final Node node = new Node("visitStop_group_repl", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg0) {
		 System.out.println("visitMasterOptString");
		final Node node = new Node("visitMasterOptString", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg0) {
		 System.out.println("visitMasterOptDecimal");
		final Node node = new Node("visitMasterOptDecimal", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg0) {
		 System.out.println("visitMasterOptBool");
		final Node node = new Node("visitMasterOptBool", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg0) {
		 System.out.println("visitMasterOptReal");
		final Node node = new Node("visitMasterOptReal", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg0) {
		 System.out.println("visitMasterOptIdList");
		final Node node = new Node("visitMasterOptIdList", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg0) {
		 System.out.println("visitString_master_option");
		final Node node = new Node("visitString_master_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg0) {
		 System.out.println("visitDecimal_master_option");
		final Node node = new Node("visitDecimal_master_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg0) {
		 System.out.println("visitBool_master_option");
		final Node node = new Node("visitBool_master_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg0) {
		 System.out.println("visitChannel_option");
		final Node node = new Node("visitChannel_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg0) {
		 System.out.println("visitReplfilterDbList");
		final Node node = new Node("visitReplfilterDbList", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg0) {
		 System.out.println("visitReplfilterTableList");
		final Node node = new Node("visitReplfilterTableList", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg0) {
		 System.out.println("visitReplfilterStableList");
		final Node node = new Node("visitReplfilterStableList", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg0) {
		 System.out.println("visitReplfilterTablepairList");
		final Node node = new Node("visitReplfilterTablepairList", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg0) {
		 System.out.println("visitThread_type");
		final Node node = new Node("visitThread_type", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg0) {
		 System.out.println("visitUntilGtidSset");
		final Node node = new Node("visitUntilGtidSset", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg0) {
		 System.out.println("visitUntilMasterLog");
		final Node node = new Node("visitUntilMasterLog", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg0) {
		 System.out.println("visitUntilRelayLog");
		final Node node = new Node("visitUntilRelayLog", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg0) {
		 System.out.println("visitUntilSqlGaps");
		final Node node = new Node("visitUntilSqlGaps", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg0) {
		 System.out.println("visitStart_slave_connection_option");
		final Node node = new Node("visitStart_slave_connection_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg0) {
		 System.out.println("visitGtid_set");
		final Node node = new Node("visitGtid_set", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg0) {
		 System.out.println("visitXa_start_transaction");
		final Node node = new Node("visitXa_start_transaction", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg0) {
		 System.out.println("visitXa_end_transaction");
		final Node node = new Node("visitXa_end_transaction", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg0) {
		 System.out.println("visitXa_prepare");
		final Node node = new Node("visitXa_prepare", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg0) {
		 System.out.println("visitXa_commit_work");
		final Node node = new Node("visitXa_commit_work", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg0) {
		 System.out.println("visitXa_rollback_work");
		final Node node = new Node("visitXa_rollback_work", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg0) {
		 System.out.println("visitXa_recover_work");
		final Node node = new Node("visitXa_recover_work", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg0) {
		 System.out.println("visitPrepare_statement");
		final Node node = new Node("visitPrepare_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg0) {
		 System.out.println("visitExecute_statement");
		final Node node = new Node("visitExecute_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg0) {
		 System.out.println("visitDeallocate_prepare");
		final Node node = new Node("visitDeallocate_prepare", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg0) {
		 System.out.println("visitRoutine_body");
		final Node node = new Node("visitRoutine_body", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg0) {
		 System.out.println("visitBlock_statement");
		final Node node = new Node("visitBlock_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg0) {
		 System.out.println("visitCase_statement");
		final Node node = new Node("visitCase_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg0) {
		 System.out.println("visitIf_statement");
		final Node node = new Node("visitIf_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg0) {
		 System.out.println("visitIterate_statement");
		final Node node = new Node("visitIterate_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg0) {
		 System.out.println("visitLeave_statement");
		final Node node = new Node("visitLeave_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg0) {
		 System.out.println("visitLoop_statement");
		final Node node = new Node("visitLoop_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg0) {
		 System.out.println("visitRepeat_statement");
		final Node node = new Node("visitRepeat_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg0) {
		 System.out.println("visitReturn_statement");
		final Node node = new Node("visitReturn_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg0) {
		 System.out.println("visitWhile_statement");
		final Node node = new Node("visitWhile_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg0) {
		 System.out.println("visitCursor_statement");
		final Node node = new Node("visitCursor_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg0) {
		 System.out.println("visitDeclare_variable");
		final Node node = new Node("visitDeclare_variable", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg0) {
		 System.out.println("visitDeclare_condition");
		final Node node = new Node("visitDeclare_condition", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg0) {
		 System.out.println("visitDeclare_cursor");
		final Node node = new Node("visitDeclare_cursor", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg0) {
		 System.out.println("visitDeclare_handler");
		final Node node = new Node("visitDeclare_handler", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg0) {
		 System.out.println("visitHandler_condition_value");
		final Node node = new Node("visitHandler_condition_value", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg0) {
		 System.out.println("visitProcedure_sql_statement");
		final Node node = new Node("visitProcedure_sql_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg0) {
		 System.out.println("visitAlterUserMysql56");
		final Node node = new Node("visitAlterUserMysql56", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg0) {
		 System.out.println("visitAlterUserMysql57");
		final Node node = new Node("visitAlterUserMysql57", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg0) {
		 System.out.println("visitCreateUserMysql56");
		final Node node = new Node("visitCreateUserMysql56", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg0) {
		 System.out.println("visitCreateUserMysql57");
		final Node node = new Node("visitCreateUserMysql57", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg0) {
		 System.out.println("visitDrop_user");
		final Node node = new Node("visitDrop_user", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg0) {
		 System.out.println("visitGrant_statement");
		final Node node = new Node("visitGrant_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg0) {
		 System.out.println("visitGrant_proxy");
		final Node node = new Node("visitGrant_proxy", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg0) {
		 System.out.println("visitRename_user");
		final Node node = new Node("visitRename_user", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg0) {
		 System.out.println("visitDetailRevoke");
		final Node node = new Node("visitDetailRevoke", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg0) {
		 System.out.println("visitShortRevoke");
		final Node node = new Node("visitShortRevoke", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg0) {
		 System.out.println("visitRevoke_proxy");
		final Node node = new Node("visitRevoke_proxy", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg0) {
		 System.out.println("visitSet_password_statement");
		final Node node = new Node("visitSet_password_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg0) {
		 System.out.println("visitUser_password_option");
		final Node node = new Node("visitUser_password_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg0) {
		 System.out.println("visitAuthByPassword");
		final Node node = new Node("visitAuthByPassword", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg0) {
		 System.out.println("visitAuthByString");
		final Node node = new Node("visitAuthByString", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg0) {
		 System.out.println("visitAuthByHash");
		final Node node = new Node("visitAuthByHash", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg0) {
		 System.out.println("visitTls_option");
		final Node node = new Node("visitTls_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg0) {
		 System.out.println("visitUser_resource_option");
		final Node node = new Node("visitUser_resource_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg0) {
		 System.out.println("visitUser_lock_option");
		final Node node = new Node("visitUser_lock_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg0) {
		 System.out.println("visitPrivelege_clause");
		final Node node = new Node("visitPrivelege_clause", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg0) {
		 System.out.println("visitPrivilege");
		final Node node = new Node("visitPrivilege", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg0) {
		 System.out.println("visitPrivilege_level");
		final Node node = new Node("visitPrivilege_level", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg0) {
		 System.out.println("visitSet_password_option");
		final Node node = new Node("visitSet_password_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg0) {
		 System.out.println("visitAnalyze_table");
		final Node node = new Node("visitAnalyze_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg0) {
		 System.out.println("visitCheck_table");
		final Node node = new Node("visitCheck_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg0) {
		 System.out.println("visitChecksum_table");
		final Node node = new Node("visitChecksum_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg0) {
		 System.out.println("visitOptimize_table");
		final Node node = new Node("visitOptimize_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg0) {
		 System.out.println("visitRepair_table");
		final Node node = new Node("visitRepair_table", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg0) {
		 System.out.println("visitCheck_table_option");
		final Node node = new Node("visitCheck_table_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg0) {
		 System.out.println("visitCreate_udfunction");
		final Node node = new Node("visitCreate_udfunction", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg0) {
		 System.out.println("visitInstall_plugin");
		final Node node = new Node("visitInstall_plugin", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg0) {
		 System.out.println("visitUninstall_plugin");
		final Node node = new Node("visitUninstall_plugin", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg0) {
		 System.out.println("visitSetVariableAssignment");
		final Node node = new Node("visitSetVariableAssignment", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg0) {
		 System.out.println("visitSetCharset");
		final Node node = new Node("visitSetCharset", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg0) {
		 System.out.println("visitSetNames");
		final Node node = new Node("visitSetNames", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg0) {
		 System.out.println("visitSetPasswordStatement");
		final Node node = new Node("visitSetPasswordStatement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg0) {
		 System.out.println("visitSetTransaction");
		final Node node = new Node("visitSetTransaction", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg0) {
		 System.out.println("visitSetAutocommit");
		final Node node = new Node("visitSetAutocommit", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg0) {
		 System.out.println("visitShowMasterlogs");
		final Node node = new Node("visitShowMasterlogs", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg0) {
		 System.out.println("visitShowLogevents");
		final Node node = new Node("visitShowLogevents", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg0) {
		 System.out.println("visitShowObjWithFilter");
		final Node node = new Node("visitShowObjWithFilter", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg0) {
		 System.out.println("visitShowColumns");
		final Node node = new Node("visitShowColumns", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg0) {
		 System.out.println("visitShowCreateDb");
		final Node node = new Node("visitShowCreateDb", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg0) {
		 System.out.println("visitShowCreateFullidobj");
		final Node node = new Node("visitShowCreateFullidobj", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg0) {
		 System.out.println("visitShowCreateUser");
		final Node node = new Node("visitShowCreateUser", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg0) {
		 System.out.println("visitShowEngine");
		final Node node = new Node("visitShowEngine", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg0) {
		 System.out.println("visitShowGlobalinfo");
		final Node node = new Node("visitShowGlobalinfo", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg0) {
		 System.out.println("visitShowErrWarn");
		final Node node = new Node("visitShowErrWarn", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg0) {
		 System.out.println("visitShowCountErrWarn");
		final Node node = new Node("visitShowCountErrWarn", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg0) {
		 System.out.println("visitShowFromschemaFilter");
		final Node node = new Node("visitShowFromschemaFilter", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg0) {
		 System.out.println("visitShowRoutinecode");
		final Node node = new Node("visitShowRoutinecode", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg0) {
		 System.out.println("visitShowGrants");
		final Node node = new Node("visitShowGrants", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg0) {
		 System.out.println("visitShowIndexes");
		final Node node = new Node("visitShowIndexes", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg0) {
		 System.out.println("visitShowOpentables");
		final Node node = new Node("visitShowOpentables", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg0) {
		 System.out.println("visitShowProfile");
		final Node node = new Node("visitShowProfile", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg0) {
		 System.out.println("visitShowSlavestatus");
		final Node node = new Node("visitShowSlavestatus", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg0) {
		 System.out.println("visitVariable_clause");
		final Node node = new Node("visitVariable_clause", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg0) {
		 System.out.println("visitShow_filter");
		final Node node = new Node("visitShow_filter", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg0) {
		 System.out.println("visitShow_profile_type");
		final Node node = new Node("visitShow_profile_type", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg0) {
		 System.out.println("visitBinlog_statement");
		final Node node = new Node("visitBinlog_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg0) {
		 System.out.println("visitCache_index_statement");
		final Node node = new Node("visitCache_index_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg0) {
		 System.out.println("visitFlush_statement");
		final Node node = new Node("visitFlush_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg0) {
		 System.out.println("visitKill_statement");
		final Node node = new Node("visitKill_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg0) {
		 System.out.println("visitLoad_index_into_cache");
		final Node node = new Node("visitLoad_index_into_cache", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg0) {
		 System.out.println("visitReset_statement");
		final Node node = new Node("visitReset_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg0) {
		 System.out.println("visitShutdown_statement");
		final Node node = new Node("visitShutdown_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg0) {
		 System.out.println("visitTbl_index_list");
		final Node node = new Node("visitTbl_index_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg0) {
		 System.out.println("visitFlush_option");
		final Node node = new Node("visitFlush_option", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg0) {
		 System.out.println("visitLoad_tbl_index_list");
		final Node node = new Node("visitLoad_tbl_index_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg0) {
		 System.out.println("visitSimple_describe_statement");
		final Node node = new Node("visitSimple_describe_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg0) {
		 System.out.println("visitFull_describe_statement");
		final Node node = new Node("visitFull_describe_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg0) {
		 System.out.println("visitHelp_statement");
		final Node node = new Node("visitHelp_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg0) {
		 System.out.println("visitUse_statement");
		final Node node = new Node("visitUse_statement", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg0) {
		 System.out.println("visitDescstmtDescObj");
		final Node node = new Node("visitDescstmtDescObj", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg0) {
		 System.out.println("visitConnectionDescObj");
		final Node node = new Node("visitConnectionDescObj", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg0) {
		 System.out.println("visitTable_name");
		final Node node = new Node("visitTable_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg0) {
		 System.out.println("visitFull_id");
		final Node node = new Node("visitFull_id", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg0) {
		 System.out.println("visitFull_column_name");
		final Node node = new Node("visitFull_column_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg0) {
		 System.out.println("visitIndex_col_name");
		final Node node = new Node("visitIndex_col_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg0) {
		 System.out.println("visitUser_name");
		final Node node = new Node("visitUser_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg0) {
		 System.out.println("visitMysql_variable");
		final Node node = new Node("visitMysql_variable", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg0) {
		 System.out.println("visitCharset_name");
		final Node node = new Node("visitCharset_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg0) {
		 System.out.println("visitCollation_name");
		final Node node = new Node("visitCollation_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg0) {
		 System.out.println("visitEngine_name");
		final Node node = new Node("visitEngine_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg0) {
		 System.out.println("visitUuid_set");
		final Node node = new Node("visitUuid_set", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg0) {
		 System.out.println("visitXid");
		final Node node = new Node("visitXid", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg0) {
		 System.out.println("visitXid_string_id");
		final Node node = new Node("visitXid_string_id", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg0) {
		 System.out.println("visitAuth_plugin");
		final Node node = new Node("visitAuth_plugin", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg0) {
		 System.out.println("visitId_");
		final Node node = new Node("visitId_", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg0) {
		 System.out.println("visitSimple_id");
		final Node node = new Node("visitSimple_id", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg0) {
		 System.out.println("visitDot_ext_id");
		final Node node = new Node("visitDot_ext_id", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg0) {
		 System.out.println("visitDecimal_literal");
		final Node node = new Node("visitDecimal_literal", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg0) {
		 System.out.println("visitFilesize_literal");
		final Node node = new Node("visitFilesize_literal", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg0) {
		 System.out.println("visitString_literal");
		final Node node = new Node("visitString_literal", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg0) {
		 System.out.println("visitBoolean_literal");
		final Node node = new Node("visitBoolean_literal", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg0) {
		 System.out.println("visitHexadecimal_literal");
		final Node node = new Node("visitHexadecimal_literal", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg0) {
		 System.out.println("visitNull_notnull");
		final Node node = new Node("visitNull_notnull", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg0) {
		 System.out.println("visitConstant");
		final Node node = new Node("visitConstant", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg0) {
		 System.out.println("visitCharDatatype");
		final Node node = new Node("visitCharDatatype", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg0) {
		 System.out.println("visitDimensionDatatype");
		final Node node = new Node("visitDimensionDatatype", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg0) {
		 System.out.println("visitSimpleDatatype");
		final Node node = new Node("visitSimpleDatatype", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg0) {
		 System.out.println("visitCollectCharDatatype");
		final Node node = new Node("visitCollectCharDatatype", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg0) {
		 System.out.println("visitSpatialDatatype");
		final Node node = new Node("visitSpatialDatatype", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg0) {
		 System.out.println("visitData_type_to_convert");
		final Node node = new Node("visitData_type_to_convert", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg0) {
		 System.out.println("visitSpatial_data_type");
		final Node node = new Node("visitSpatial_data_type", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg0) {
		 System.out.println("visitLength_one_dimension");
		final Node node = new Node("visitLength_one_dimension", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg0) {
		 System.out.println("visitLength_two_dimension");
		final Node node = new Node("visitLength_two_dimension", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg0) {
		 System.out.println("visitLength_two_optional_dimension");
		final Node node = new Node("visitLength_two_optional_dimension", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg0) {
		 System.out.println("visitId_list");
		final Node node = new Node("visitId_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg0) {
		 System.out.println("visitTable_list");
		final Node node = new Node("visitTable_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg0) {
		 System.out.println("visitTable_pair_list");
		final Node node = new Node("visitTable_pair_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg0) {
		 System.out.println("visitIndex_colname_list");
		final Node node = new Node("visitIndex_colname_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg0) {
		 System.out.println("visitExpression_list");
		final Node node = new Node("visitExpression_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg0) {
		 System.out.println("visitConstant_list");
		final Node node = new Node("visitConstant_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg0) {
		 System.out.println("visitSimple_string_list");
		final Node node = new Node("visitSimple_string_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg0) {
		 System.out.println("visitUser_var_list");
		final Node node = new Node("visitUser_var_list", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg0) {
		 System.out.println("visitDefault_value");
		final Node node = new Node("visitDefault_value", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg0) {
		 System.out.println("visitIf_exists");
		final Node node = new Node("visitIf_exists", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg0) {
		 System.out.println("visitIf_not_exists");
		final Node node = new Node("visitIf_not_exists", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg0) {
		 System.out.println("visitSpecificFunctionCall");
		final Node node = new Node("visitSpecificFunctionCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg0) {
		 System.out.println("visitAggregateFunctionCall");
		final Node node = new Node("visitAggregateFunctionCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg0) {
		 System.out.println("visitScalarFunctionCall");
		final Node node = new Node("visitScalarFunctionCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg0) {
		 System.out.println("visitUdfFunctionCall");
		final Node node = new Node("visitUdfFunctionCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg0) {
		 System.out.println("visitSimpleSpecificFCall");
		final Node node = new Node("visitSimpleSpecificFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg0) {
		 System.out.println("visitConvertDataTypeFCall");
		final Node node = new Node("visitConvertDataTypeFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg0) {
		 System.out.println("visitValuesFCall");
		final Node node = new Node("visitValuesFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg0) {
		 System.out.println("visitCaseFCall");
		final Node node = new Node("visitCaseFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg0) {
		 System.out.println("visitCharFCall");
		final Node node = new Node("visitCharFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg0) {
		 System.out.println("visitPositionFCall");
		final Node node = new Node("visitPositionFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg0) {
		 System.out.println("visitSubstrFCall");
		final Node node = new Node("visitSubstrFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg0) {
		 System.out.println("visitTrimFCall");
		final Node node = new Node("visitTrimFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg0) {
		 System.out.println("visitWeightFCall");
		final Node node = new Node("visitWeightFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg0) {
		 System.out.println("visitExtractFCall");
		final Node node = new Node("visitExtractFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg0) {
		 System.out.println("visitGetFormatFCall");
		final Node node = new Node("visitGetFormatFCall", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg0) {
		 System.out.println("visitLevelWeightFList");
		final Node node = new Node("visitLevelWeightFList", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg0) {
		 System.out.println("visitLevelWeightFRange");
		final Node node = new Node("visitLevelWeightFRange", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg0) {
		 System.out.println("visitAggregate_windowed_function");
		final Node node = new Node("visitAggregate_windowed_function", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg0) {
		 System.out.println("visitScalar_function_name");
		final Node node = new Node("visitScalar_function_name", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg0) {
		 System.out.println("visitFunction_args");
		final Node node = new Node("visitFunction_args", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg0) {
		 System.out.println("visitFunction_arg");
		final Node node = new Node("visitFunction_arg", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg0) {
		 System.out.println("visitIsExpression");
		final Node node = new Node("visitIsExpression", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg0) {
		 System.out.println("visitNotExpression");
		final Node node = new Node("visitNotExpression", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg0) {
		 System.out.println("visitLogicalExpression");
		final Node node = new Node("visitLogicalExpression", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg0) {
		 System.out.println("visitPredicateExpression");
		final Node node = new Node("visitPredicateExpression", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg0) {
		 System.out.println("visitSoundsLikePredicate");
		final Node node = new Node("visitSoundsLikePredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg0) {
		 System.out.println("visitExpressionAtomPredicate");
		final Node node = new Node("visitExpressionAtomPredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg0) {
		 System.out.println("visitInPredicate");
		final Node node = new Node("visitInPredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg0) {
		 System.out.println("visitSubqueryComparasionPredicate");
		final Node node = new Node("visitSubqueryComparasionPredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg0) {
		 System.out.println("visitBetweenPredicate");
		final Node node = new Node("visitBetweenPredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg0) {
		 System.out.println("visitBinaryComparasionPredicate");
		final Node node = new Node("visitBinaryComparasionPredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg0) {
		 System.out.println("visitIsNullPredicate");
		final Node node = new Node("visitIsNullPredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg0) {
		 System.out.println("visitLikePredicate");
		final Node node = new Node("visitLikePredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg0) {
		 System.out.println("visitRegexpPredicate");
		final Node node = new Node("visitRegexpPredicate", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg0) {
		 System.out.println("visitUnaryExpressionAtom");
		final Node node = new Node("visitUnaryExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg0) {
		 System.out.println("visitExistsExpessionAtom");
		final Node node = new Node("visitExistsExpessionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg0) {
		 System.out.println("visitConstantExpressionAtom");
		final Node node = new Node("visitConstantExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg0) {
		 System.out.println("visitFunctionCallExpressionAtom");
		final Node node = new Node("visitFunctionCallExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg0) {
		 System.out.println("visitMysqlVariableExpressionAtom");
		final Node node = new Node("visitMysqlVariableExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg0) {
		 System.out.println("visitBinaryExpressionAtom");
		final Node node = new Node("visitBinaryExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg0) {
		 System.out.println("visitFullColumnNameExpressionAtom");
		final Node node = new Node("visitFullColumnNameExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg0) {
		 System.out.println("visitDefaultExpressionAtom");
		final Node node = new Node("visitDefaultExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg0) {
		 System.out.println("visitBitExpressionAtom");
		final Node node = new Node("visitBitExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg0) {
		 System.out.println("visitNestedExpressionAtom");
		final Node node = new Node("visitNestedExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg0) {
		 System.out.println("visitMathExpressionAtom");
		final Node node = new Node("visitMathExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg0) {
		 System.out.println("visitIntervalExpressionAtom");
		final Node node = new Node("visitIntervalExpressionAtom", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg0) {
		 System.out.println("visitUnary_operator");
		final Node node = new Node("visitUnary_operator", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg0) {
		 System.out.println("visitComparison_operator");
		final Node node = new Node("visitComparison_operator", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg0) {
		 System.out.println("visitLogical_operator");
		final Node node = new Node("visitLogical_operator", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg0) {
		 System.out.println("visitBit_operator");
		final Node node = new Node("visitBit_operator", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg0) {
		 System.out.println("visitMath_operator");
		final Node node = new Node("visitMath_operator", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg0) {
		 System.out.println("visitCharset_name_base");
		final Node node = new Node("visitCharset_name_base", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg0) {
		 System.out.println("visitTransaction_level_base");
		final Node node = new Node("visitTransaction_level_base", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg0) {
		 System.out.println("visitPrivileges_base");
		final Node node = new Node("visitPrivileges_base", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg0) {
		 System.out.println("visitInterval_type_base");
		final Node node = new Node("visitInterval_type_base", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg0) {
		 System.out.println("visitData_type_base");
		final Node node = new Node("visitData_type_base", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg0) {
		 System.out.println("visitKeywords_can_be_id");
		final Node node = new Node("visitKeywords_can_be_id", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}

	@Override
	public MySqlNodeVisitor.Node visitFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg0) {
		 System.out.println("visitFunction_name_base");
		final Node node = new Node("visitFunction_name_base", arg0.getText());
      onEnter(node);
      visitChildren(arg0);
      onExit();
      return node;
	}
}