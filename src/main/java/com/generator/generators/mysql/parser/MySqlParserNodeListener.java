package com.generator.generators.mysql.parser;

public class MySqlParserNodeListener extends MySqlParserBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public MySqlParserNodeListener() {
		this(false);
	}

	public MySqlParserNodeListener(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
		delim.append("\t");
   }

   private void onExit() {
      if (nodeStack.size() > 1) {
			nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
		}
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	protected boolean inNotExpression = false;

	@Override
	public void enterNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		onEnter(new Node("NotExpression", arg.getText(), arg.getStart().getText()));
		this.inNotExpression = true;
	}

	public void exitNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		onExit();
		this.inNotExpression = false;
	}

	protected boolean inRoot = false;

	@Override
	public void enterRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		onEnter(new Node("Root", arg.getText(), arg.getStart().getText()));
		this.inRoot = true;
	}

	public void exitRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		onExit();
		this.inRoot = false;
	}

	protected boolean inSql_statements = false;

	@Override
	public void enterSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		onEnter(new Node("Sql_statements", arg.getText(), arg.getStart().getText()));
		this.inSql_statements = true;
	}

	public void exitSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		onExit();
		this.inSql_statements = false;
	}

	protected boolean inSql_statement = false;

	@Override
	public void enterSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		onEnter(new Node("Sql_statement", arg.getText(), arg.getStart().getText()));
		this.inSql_statement = true;
	}

	public void exitSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		onExit();
		this.inSql_statement = false;
	}

	protected boolean inEmpty_statement = false;

	@Override
	public void enterEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		onEnter(new Node("Empty_statement", arg.getText(), arg.getStart().getText()));
		this.inEmpty_statement = true;
	}

	public void exitEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		onExit();
		this.inEmpty_statement = false;
	}

	protected boolean inDdl_statement = false;

	@Override
	public void enterDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		onEnter(new Node("Ddl_statement", arg.getText(), arg.getStart().getText()));
		this.inDdl_statement = true;
	}

	public void exitDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		onExit();
		this.inDdl_statement = false;
	}

	protected boolean inDml_statement = false;

	@Override
	public void enterDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		onEnter(new Node("Dml_statement", arg.getText(), arg.getStart().getText()));
		this.inDml_statement = true;
	}

	public void exitDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		onExit();
		this.inDml_statement = false;
	}

	protected boolean inTransaction_statement = false;

	@Override
	public void enterTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		onEnter(new Node("Transaction_statement", arg.getText(), arg.getStart().getText()));
		this.inTransaction_statement = true;
	}

	public void exitTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		onExit();
		this.inTransaction_statement = false;
	}

	protected boolean inReplication_statement = false;

	@Override
	public void enterReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		onEnter(new Node("Replication_statement", arg.getText(), arg.getStart().getText()));
		this.inReplication_statement = true;
	}

	public void exitReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		onExit();
		this.inReplication_statement = false;
	}

	protected boolean inPrepared_statement = false;

	@Override
	public void enterPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		onEnter(new Node("Prepared_statement", arg.getText(), arg.getStart().getText()));
		this.inPrepared_statement = true;
	}

	public void exitPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		onExit();
		this.inPrepared_statement = false;
	}

	protected boolean inCompound_statement = false;

	@Override
	public void enterCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		onEnter(new Node("Compound_statement", arg.getText(), arg.getStart().getText()));
		this.inCompound_statement = true;
	}

	public void exitCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		onExit();
		this.inCompound_statement = false;
	}

	protected boolean inAdministration_statement = false;

	@Override
	public void enterAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		onEnter(new Node("Administration_statement", arg.getText(), arg.getStart().getText()));
		this.inAdministration_statement = true;
	}

	public void exitAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		onExit();
		this.inAdministration_statement = false;
	}

	protected boolean inUtility_statement = false;

	@Override
	public void enterUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		onEnter(new Node("Utility_statement", arg.getText(), arg.getStart().getText()));
		this.inUtility_statement = true;
	}

	public void exitUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		onExit();
		this.inUtility_statement = false;
	}

	protected boolean inCreate_database = false;

	@Override
	public void enterCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		onEnter(new Node("Create_database", arg.getText(), arg.getStart().getText()));
		this.inCreate_database = true;
	}

	public void exitCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		onExit();
		this.inCreate_database = false;
	}

	protected boolean inCreate_event = false;

	@Override
	public void enterCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		onEnter(new Node("Create_event", arg.getText(), arg.getStart().getText()));
		this.inCreate_event = true;
	}

	public void exitCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		onExit();
		this.inCreate_event = false;
	}

	protected boolean inCreate_index = false;

	@Override
	public void enterCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		onEnter(new Node("Create_index", arg.getText(), arg.getStart().getText()));
		this.inCreate_index = true;
	}

	public void exitCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		onExit();
		this.inCreate_index = false;
	}

	protected boolean inCreate_logfile_group = false;

	@Override
	public void enterCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		onEnter(new Node("Create_logfile_group", arg.getText(), arg.getStart().getText()));
		this.inCreate_logfile_group = true;
	}

	public void exitCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		onExit();
		this.inCreate_logfile_group = false;
	}

	protected boolean inCreate_procedure = false;

	@Override
	public void enterCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		onEnter(new Node("Create_procedure", arg.getText(), arg.getStart().getText()));
		this.inCreate_procedure = true;
	}

	public void exitCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		onExit();
		this.inCreate_procedure = false;
	}

	protected boolean inCreate_function = false;

	@Override
	public void enterCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		onEnter(new Node("Create_function", arg.getText(), arg.getStart().getText()));
		this.inCreate_function = true;
	}

	public void exitCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		onExit();
		this.inCreate_function = false;
	}

	protected boolean inCreate_server = false;

	@Override
	public void enterCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		onEnter(new Node("Create_server", arg.getText(), arg.getStart().getText()));
		this.inCreate_server = true;
	}

	public void exitCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		onExit();
		this.inCreate_server = false;
	}

	protected boolean inCopyCreateTable = false;

	@Override
	public void enterCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		onEnter(new Node("CopyCreateTable", arg.getText(), arg.getStart().getText()));
		this.inCopyCreateTable = true;
	}

	public void exitCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		onExit();
		this.inCopyCreateTable = false;
	}

	protected boolean inQueryCreateTable = false;

	@Override
	public void enterQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		onEnter(new Node("QueryCreateTable", arg.getText(), arg.getStart().getText()));
		this.inQueryCreateTable = true;
	}

	public void exitQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		onExit();
		this.inQueryCreateTable = false;
	}

	protected boolean inColCreateTable = false;

	@Override
	public void enterColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		onEnter(new Node("ColCreateTable", arg.getText(), arg.getStart().getText()));
		this.inColCreateTable = true;
	}

	public void exitColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		onExit();
		this.inColCreateTable = false;
	}

	protected boolean inCreate_tablespace_innodb = false;

	@Override
	public void enterCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		onEnter(new Node("Create_tablespace_innodb", arg.getText(), arg.getStart().getText()));
		this.inCreate_tablespace_innodb = true;
	}

	public void exitCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		onExit();
		this.inCreate_tablespace_innodb = false;
	}

	protected boolean inCreate_tablespace_ndb = false;

	@Override
	public void enterCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		onEnter(new Node("Create_tablespace_ndb", arg.getText(), arg.getStart().getText()));
		this.inCreate_tablespace_ndb = true;
	}

	public void exitCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		onExit();
		this.inCreate_tablespace_ndb = false;
	}

	protected boolean inCreate_trigger = false;

	@Override
	public void enterCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		onEnter(new Node("Create_trigger", arg.getText(), arg.getStart().getText()));
		this.inCreate_trigger = true;
	}

	public void exitCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		onExit();
		this.inCreate_trigger = false;
	}

	protected boolean inCreate_view = false;

	@Override
	public void enterCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		onEnter(new Node("Create_view", arg.getText(), arg.getStart().getText()));
		this.inCreate_view = true;
	}

	public void exitCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		onExit();
		this.inCreate_view = false;
	}

	protected boolean inCreate_database_option = false;

	@Override
	public void enterCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		onEnter(new Node("Create_database_option", arg.getText(), arg.getStart().getText()));
		this.inCreate_database_option = true;
	}

	public void exitCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		onExit();
		this.inCreate_database_option = false;
	}

	protected boolean inOwner_statement = false;

	@Override
	public void enterOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		onEnter(new Node("Owner_statement", arg.getText(), arg.getStart().getText()));
		this.inOwner_statement = true;
	}

	public void exitOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		onExit();
		this.inOwner_statement = false;
	}

	protected boolean inPreciseSchedule = false;

	@Override
	public void enterPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		onEnter(new Node("PreciseSchedule", arg.getText(), arg.getStart().getText()));
		this.inPreciseSchedule = true;
	}

	public void exitPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		onExit();
		this.inPreciseSchedule = false;
	}

	protected boolean inIntervalSchedule = false;

	@Override
	public void enterIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		onEnter(new Node("IntervalSchedule", arg.getText(), arg.getStart().getText()));
		this.inIntervalSchedule = true;
	}

	public void exitIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		onExit();
		this.inIntervalSchedule = false;
	}

	protected boolean inTimestamp_value = false;

	@Override
	public void enterTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		onEnter(new Node("Timestamp_value", arg.getText(), arg.getStart().getText()));
		this.inTimestamp_value = true;
	}

	public void exitTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		onExit();
		this.inTimestamp_value = false;
	}

	protected boolean inInterval_expr = false;

	@Override
	public void enterInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		onEnter(new Node("Interval_expr", arg.getText(), arg.getStart().getText()));
		this.inInterval_expr = true;
	}

	public void exitInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		onExit();
		this.inInterval_expr = false;
	}

	protected boolean inInterval_type = false;

	@Override
	public void enterInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		onEnter(new Node("Interval_type", arg.getText(), arg.getStart().getText()));
		this.inInterval_type = true;
	}

	public void exitInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		onExit();
		this.inInterval_type = false;
	}

	protected boolean inIndex_type = false;

	@Override
	public void enterIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		onEnter(new Node("Index_type", arg.getText(), arg.getStart().getText()));
		this.inIndex_type = true;
	}

	public void exitIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		onExit();
		this.inIndex_type = false;
	}

	protected boolean inIndex_option = false;

	@Override
	public void enterIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		onEnter(new Node("Index_option", arg.getText(), arg.getStart().getText()));
		this.inIndex_option = true;
	}

	public void exitIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		onExit();
		this.inIndex_option = false;
	}

	protected boolean inProc_param = false;

	@Override
	public void enterProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		onEnter(new Node("Proc_param", arg.getText(), arg.getStart().getText()));
		this.inProc_param = true;
	}

	public void exitProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		onExit();
		this.inProc_param = false;
	}

	protected boolean inFunc_param = false;

	@Override
	public void enterFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		onEnter(new Node("Func_param", arg.getText(), arg.getStart().getText()));
		this.inFunc_param = true;
	}

	public void exitFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		onExit();
		this.inFunc_param = false;
	}

	protected boolean inRcComment = false;

	@Override
	public void enterRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		onEnter(new Node("RcComment", arg.getText(), arg.getStart().getText()));
		this.inRcComment = true;
	}

	public void exitRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		onExit();
		this.inRcComment = false;
	}

	protected boolean inRcSqllang = false;

	@Override
	public void enterRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		onEnter(new Node("RcSqllang", arg.getText(), arg.getStart().getText()));
		this.inRcSqllang = true;
	}

	public void exitRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		onExit();
		this.inRcSqllang = false;
	}

	protected boolean inRcDeterm = false;

	@Override
	public void enterRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		onEnter(new Node("RcDeterm", arg.getText(), arg.getStart().getText()));
		this.inRcDeterm = true;
	}

	public void exitRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		onExit();
		this.inRcDeterm = false;
	}

	protected boolean inRcSqldata = false;

	@Override
	public void enterRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		onEnter(new Node("RcSqldata", arg.getText(), arg.getStart().getText()));
		this.inRcSqldata = true;
	}

	public void exitRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		onExit();
		this.inRcSqldata = false;
	}

	protected boolean inRcSecurestmt = false;

	@Override
	public void enterRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		onEnter(new Node("RcSecurestmt", arg.getText(), arg.getStart().getText()));
		this.inRcSecurestmt = true;
	}

	public void exitRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		onExit();
		this.inRcSecurestmt = false;
	}

	protected boolean inServer_option = false;

	@Override
	public void enterServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		onEnter(new Node("Server_option", arg.getText(), arg.getStart().getText()));
		this.inServer_option = true;
	}

	public void exitServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		onExit();
		this.inServer_option = false;
	}

	protected boolean inColumn_def_table_constraints = false;

	@Override
	public void enterColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		onEnter(new Node("Column_def_table_constraints", arg.getText(), arg.getStart().getText()));
		this.inColumn_def_table_constraints = true;
	}

	public void exitColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		onExit();
		this.inColumn_def_table_constraints = false;
	}

	protected boolean inColumnDefinition = false;

	@Override
	public void enterColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		onEnter(new Node("ColumnDefinition", arg.getText(), arg.getStart().getText()));
		this.inColumnDefinition = true;
	}

	public void exitColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		onExit();
		this.inColumnDefinition = false;
	}

	protected boolean inConstraintDefinition = false;

	@Override
	public void enterConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		onEnter(new Node("ConstraintDefinition", arg.getText(), arg.getStart().getText()));
		this.inConstraintDefinition = true;
	}

	public void exitConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		onExit();
		this.inConstraintDefinition = false;
	}

	protected boolean inIndexDefinition = false;

	@Override
	public void enterIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		onEnter(new Node("IndexDefinition", arg.getText(), arg.getStart().getText()));
		this.inIndexDefinition = true;
	}

	public void exitIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		onExit();
		this.inIndexDefinition = false;
	}

	protected boolean inColumn_definition = false;

	@Override
	public void enterColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		onEnter(new Node("Column_definition", arg.getText(), arg.getStart().getText()));
		this.inColumn_definition = true;
	}

	public void exitColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		onExit();
		this.inColumn_definition = false;
	}

	protected boolean inColConstrNull = false;

	@Override
	public void enterColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		onEnter(new Node("ColConstrNull", arg.getText(), arg.getStart().getText()));
		this.inColConstrNull = true;
	}

	public void exitColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		onExit();
		this.inColConstrNull = false;
	}

	protected boolean inColConstrDflt = false;

	@Override
	public void enterColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		onEnter(new Node("ColConstrDflt", arg.getText(), arg.getStart().getText()));
		this.inColConstrDflt = true;
	}

	public void exitColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		onExit();
		this.inColConstrDflt = false;
	}

	protected boolean inColConstrAuInc = false;

	@Override
	public void enterColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		onEnter(new Node("ColConstrAuInc", arg.getText(), arg.getStart().getText()));
		this.inColConstrAuInc = true;
	}

	public void exitColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		onExit();
		this.inColConstrAuInc = false;
	}

	protected boolean inColConstrPK = false;

	@Override
	public void enterColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		onEnter(new Node("ColConstrPK", arg.getText(), arg.getStart().getText()));
		this.inColConstrPK = true;
	}

	public void exitColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		onExit();
		this.inColConstrPK = false;
	}

	protected boolean inColConstrUK = false;

	@Override
	public void enterColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		onEnter(new Node("ColConstrUK", arg.getText(), arg.getStart().getText()));
		this.inColConstrUK = true;
	}

	public void exitColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		onExit();
		this.inColConstrUK = false;
	}

	protected boolean inColConstrComment = false;

	@Override
	public void enterColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		onEnter(new Node("ColConstrComment", arg.getText(), arg.getStart().getText()));
		this.inColConstrComment = true;
	}

	public void exitColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		onExit();
		this.inColConstrComment = false;
	}

	protected boolean inColConstrForm = false;

	@Override
	public void enterColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		onEnter(new Node("ColConstrForm", arg.getText(), arg.getStart().getText()));
		this.inColConstrForm = true;
	}

	public void exitColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		onExit();
		this.inColConstrForm = false;
	}

	protected boolean inColConstrStorage = false;

	@Override
	public void enterColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		onEnter(new Node("ColConstrStorage", arg.getText(), arg.getStart().getText()));
		this.inColConstrStorage = true;
	}

	public void exitColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		onExit();
		this.inColConstrStorage = false;
	}

	protected boolean inColConstrRefdef = false;

	@Override
	public void enterColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		onEnter(new Node("ColConstrRefdef", arg.getText(), arg.getStart().getText()));
		this.inColConstrRefdef = true;
	}

	public void exitColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		onExit();
		this.inColConstrRefdef = false;
	}

	protected boolean inTblConstrPK = false;

	@Override
	public void enterTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		onEnter(new Node("TblConstrPK", arg.getText(), arg.getStart().getText()));
		this.inTblConstrPK = true;
	}

	public void exitTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		onExit();
		this.inTblConstrPK = false;
	}

	protected boolean inTblConstrUK = false;

	@Override
	public void enterTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		onEnter(new Node("TblConstrUK", arg.getText(), arg.getStart().getText()));
		this.inTblConstrUK = true;
	}

	public void exitTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		onExit();
		this.inTblConstrUK = false;
	}

	protected boolean inTblConstrFK = false;

	@Override
	public void enterTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		onEnter(new Node("TblConstrFK", arg.getText(), arg.getStart().getText()));
		this.inTblConstrFK = true;
	}

	public void exitTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		onExit();
		this.inTblConstrFK = false;
	}

	protected boolean inTblConstCheck = false;

	@Override
	public void enterTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		onEnter(new Node("TblConstCheck", arg.getText(), arg.getStart().getText()));
		this.inTblConstCheck = true;
	}

	public void exitTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		onExit();
		this.inTblConstCheck = false;
	}

	protected boolean inReference_definition = false;

	@Override
	public void enterReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		onEnter(new Node("Reference_definition", arg.getText(), arg.getStart().getText()));
		this.inReference_definition = true;
	}

	public void exitReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		onExit();
		this.inReference_definition = false;
	}

	protected boolean inOn_delete_action = false;

	@Override
	public void enterOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		onEnter(new Node("On_delete_action", arg.getText(), arg.getStart().getText()));
		this.inOn_delete_action = true;
	}

	public void exitOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		onExit();
		this.inOn_delete_action = false;
	}

	protected boolean inOn_update_action = false;

	@Override
	public void enterOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		onEnter(new Node("On_update_action", arg.getText(), arg.getStart().getText()));
		this.inOn_update_action = true;
	}

	public void exitOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		onExit();
		this.inOn_update_action = false;
	}

	protected boolean inReference_action_control_type = false;

	@Override
	public void enterReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		onEnter(new Node("Reference_action_control_type", arg.getText(), arg.getStart().getText()));
		this.inReference_action_control_type = true;
	}

	public void exitReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		onExit();
		this.inReference_action_control_type = false;
	}

	protected boolean inSimpleIndex = false;

	@Override
	public void enterSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		onEnter(new Node("SimpleIndex", arg.getText(), arg.getStart().getText()));
		this.inSimpleIndex = true;
	}

	public void exitSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		onExit();
		this.inSimpleIndex = false;
	}

	protected boolean inSpecIndex = false;

	@Override
	public void enterSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		onEnter(new Node("SpecIndex", arg.getText(), arg.getStart().getText()));
		this.inSpecIndex = true;
	}

	public void exitSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		onExit();
		this.inSpecIndex = false;
	}

	protected boolean inTblOptEngine = false;

	@Override
	public void enterTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		onEnter(new Node("TblOptEngine", arg.getText(), arg.getStart().getText()));
		this.inTblOptEngine = true;
	}

	public void exitTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		onExit();
		this.inTblOptEngine = false;
	}

	protected boolean inTblOptAuInc = false;

	@Override
	public void enterTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		onEnter(new Node("TblOptAuInc", arg.getText(), arg.getStart().getText()));
		this.inTblOptAuInc = true;
	}

	public void exitTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		onExit();
		this.inTblOptAuInc = false;
	}

	protected boolean inTblOptAvgRLen = false;

	@Override
	public void enterTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		onEnter(new Node("TblOptAvgRLen", arg.getText(), arg.getStart().getText()));
		this.inTblOptAvgRLen = true;
	}

	public void exitTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		onExit();
		this.inTblOptAvgRLen = false;
	}

	protected boolean inTblOptDefCharSet = false;

	@Override
	public void enterTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		onEnter(new Node("TblOptDefCharSet", arg.getText(), arg.getStart().getText()));
		this.inTblOptDefCharSet = true;
	}

	public void exitTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		onExit();
		this.inTblOptDefCharSet = false;
	}

	protected boolean inTblOptChkSum = false;

	@Override
	public void enterTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		onEnter(new Node("TblOptChkSum", arg.getText(), arg.getStart().getText()));
		this.inTblOptChkSum = true;
	}

	public void exitTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		onExit();
		this.inTblOptChkSum = false;
	}

	protected boolean inTblOptDefCollate = false;

	@Override
	public void enterTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		onEnter(new Node("TblOptDefCollate", arg.getText(), arg.getStart().getText()));
		this.inTblOptDefCollate = true;
	}

	public void exitTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		onExit();
		this.inTblOptDefCollate = false;
	}

	protected boolean inTblOptComment = false;

	@Override
	public void enterTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		onEnter(new Node("TblOptComment", arg.getText(), arg.getStart().getText()));
		this.inTblOptComment = true;
	}

	public void exitTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		onExit();
		this.inTblOptComment = false;
	}

	protected boolean inTblOptCompr = false;

	@Override
	public void enterTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		onEnter(new Node("TblOptCompr", arg.getText(), arg.getStart().getText()));
		this.inTblOptCompr = true;
	}

	public void exitTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		onExit();
		this.inTblOptCompr = false;
	}

	protected boolean inTblOptConn = false;

	@Override
	public void enterTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		onEnter(new Node("TblOptConn", arg.getText(), arg.getStart().getText()));
		this.inTblOptConn = true;
	}

	public void exitTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		onExit();
		this.inTblOptConn = false;
	}

	protected boolean inTblOptDataDir = false;

	@Override
	public void enterTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		onEnter(new Node("TblOptDataDir", arg.getText(), arg.getStart().getText()));
		this.inTblOptDataDir = true;
	}

	public void exitTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		onExit();
		this.inTblOptDataDir = false;
	}

	protected boolean inTblOptDelKW = false;

	@Override
	public void enterTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		onEnter(new Node("TblOptDelKW", arg.getText(), arg.getStart().getText()));
		this.inTblOptDelKW = true;
	}

	public void exitTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		onExit();
		this.inTblOptDelKW = false;
	}

	protected boolean inTblOptEncr = false;

	@Override
	public void enterTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		onEnter(new Node("TblOptEncr", arg.getText(), arg.getStart().getText()));
		this.inTblOptEncr = true;
	}

	public void exitTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		onExit();
		this.inTblOptEncr = false;
	}

	protected boolean inTblOptIndexDir = false;

	@Override
	public void enterTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		onEnter(new Node("TblOptIndexDir", arg.getText(), arg.getStart().getText()));
		this.inTblOptIndexDir = true;
	}

	public void exitTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		onExit();
		this.inTblOptIndexDir = false;
	}

	protected boolean inTblOptInsMeth = false;

	@Override
	public void enterTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		onEnter(new Node("TblOptInsMeth", arg.getText(), arg.getStart().getText()));
		this.inTblOptInsMeth = true;
	}

	public void exitTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		onExit();
		this.inTblOptInsMeth = false;
	}

	protected boolean inTblOptKeyBlockSz = false;

	@Override
	public void enterTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		onEnter(new Node("TblOptKeyBlockSz", arg.getText(), arg.getStart().getText()));
		this.inTblOptKeyBlockSz = true;
	}

	public void exitTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		onExit();
		this.inTblOptKeyBlockSz = false;
	}

	protected boolean inTblOptMaxRows = false;

	@Override
	public void enterTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		onEnter(new Node("TblOptMaxRows", arg.getText(), arg.getStart().getText()));
		this.inTblOptMaxRows = true;
	}

	public void exitTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		onExit();
		this.inTblOptMaxRows = false;
	}

	protected boolean inTblOptMinRows = false;

	@Override
	public void enterTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		onEnter(new Node("TblOptMinRows", arg.getText(), arg.getStart().getText()));
		this.inTblOptMinRows = true;
	}

	public void exitTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		onExit();
		this.inTblOptMinRows = false;
	}

	protected boolean inTblOptPackK = false;

	@Override
	public void enterTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		onEnter(new Node("TblOptPackK", arg.getText(), arg.getStart().getText()));
		this.inTblOptPackK = true;
	}

	public void exitTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		onExit();
		this.inTblOptPackK = false;
	}

	protected boolean inTblOptPasswd = false;

	@Override
	public void enterTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		onEnter(new Node("TblOptPasswd", arg.getText(), arg.getStart().getText()));
		this.inTblOptPasswd = true;
	}

	public void exitTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		onExit();
		this.inTblOptPasswd = false;
	}

	protected boolean inTblOptRowFormat = false;

	@Override
	public void enterTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		onEnter(new Node("TblOptRowFormat", arg.getText(), arg.getStart().getText()));
		this.inTblOptRowFormat = true;
	}

	public void exitTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		onExit();
		this.inTblOptRowFormat = false;
	}

	protected boolean inTblOptStatAutoR = false;

	@Override
	public void enterTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		onEnter(new Node("TblOptStatAutoR", arg.getText(), arg.getStart().getText()));
		this.inTblOptStatAutoR = true;
	}

	public void exitTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		onExit();
		this.inTblOptStatAutoR = false;
	}

	protected boolean inTblOptStatPersist = false;

	@Override
	public void enterTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		onEnter(new Node("TblOptStatPersist", arg.getText(), arg.getStart().getText()));
		this.inTblOptStatPersist = true;
	}

	public void exitTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		onExit();
		this.inTblOptStatPersist = false;
	}

	protected boolean inTblOptStatSamplPg = false;

	@Override
	public void enterTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		onEnter(new Node("TblOptStatSamplPg", arg.getText(), arg.getStart().getText()));
		this.inTblOptStatSamplPg = true;
	}

	public void exitTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		onExit();
		this.inTblOptStatSamplPg = false;
	}

	protected boolean inTblOptTablespace = false;

	@Override
	public void enterTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		onEnter(new Node("TblOptTablespace", arg.getText(), arg.getStart().getText()));
		this.inTblOptTablespace = true;
	}

	public void exitTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		onExit();
		this.inTblOptTablespace = false;
	}

	protected boolean inTblOptUnion = false;

	@Override
	public void enterTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		onEnter(new Node("TblOptUnion", arg.getText(), arg.getStart().getText()));
		this.inTblOptUnion = true;
	}

	public void exitTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		onExit();
		this.inTblOptUnion = false;
	}

	protected boolean inPartition_options = false;

	@Override
	public void enterPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		onEnter(new Node("Partition_options", arg.getText(), arg.getStart().getText()));
		this.inPartition_options = true;
	}

	public void exitPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		onExit();
		this.inPartition_options = false;
	}

	protected boolean inPartition_function_definition = false;

	@Override
	public void enterPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		onEnter(new Node("Partition_function_definition", arg.getText(), arg.getStart().getText()));
		this.inPartition_function_definition = true;
	}

	public void exitPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		onExit();
		this.inPartition_function_definition = false;
	}

	protected boolean inLinear_partition_func_def = false;

	@Override
	public void enterLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		onEnter(new Node("Linear_partition_func_def", arg.getText(), arg.getStart().getText()));
		this.inLinear_partition_func_def = true;
	}

	public void exitLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		onExit();
		this.inLinear_partition_func_def = false;
	}

	protected boolean inPartition_def = false;

	@Override
	public void enterPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		onEnter(new Node("Partition_def", arg.getText(), arg.getStart().getText()));
		this.inPartition_def = true;
	}

	public void exitPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		onExit();
		this.inPartition_def = false;
	}

	protected boolean inSubpartition_def = false;

	@Override
	public void enterSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		onEnter(new Node("Subpartition_def", arg.getText(), arg.getStart().getText()));
		this.inSubpartition_def = true;
	}

	public void exitSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		onExit();
		this.inSubpartition_def = false;
	}

	protected boolean inAlterDb = false;

	@Override
	public void enterAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		onEnter(new Node("AlterDb", arg.getText(), arg.getStart().getText()));
		this.inAlterDb = true;
	}

	public void exitAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		onExit();
		this.inAlterDb = false;
	}

	protected boolean inAlterDbUpgradeName = false;

	@Override
	public void enterAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		onEnter(new Node("AlterDbUpgradeName", arg.getText(), arg.getStart().getText()));
		this.inAlterDbUpgradeName = true;
	}

	public void exitAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		onExit();
		this.inAlterDbUpgradeName = false;
	}

	protected boolean inAlter_event = false;

	@Override
	public void enterAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		onEnter(new Node("Alter_event", arg.getText(), arg.getStart().getText()));
		this.inAlter_event = true;
	}

	public void exitAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		onExit();
		this.inAlter_event = false;
	}

	protected boolean inAlter_function = false;

	@Override
	public void enterAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		onEnter(new Node("Alter_function", arg.getText(), arg.getStart().getText()));
		this.inAlter_function = true;
	}

	public void exitAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		onExit();
		this.inAlter_function = false;
	}

	protected boolean inAlter_instance = false;

	@Override
	public void enterAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		onEnter(new Node("Alter_instance", arg.getText(), arg.getStart().getText()));
		this.inAlter_instance = true;
	}

	public void exitAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		onExit();
		this.inAlter_instance = false;
	}

	protected boolean inAlter_logfile_group = false;

	@Override
	public void enterAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		onEnter(new Node("Alter_logfile_group", arg.getText(), arg.getStart().getText()));
		this.inAlter_logfile_group = true;
	}

	public void exitAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		onExit();
		this.inAlter_logfile_group = false;
	}

	protected boolean inAlter_procedure = false;

	@Override
	public void enterAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		onEnter(new Node("Alter_procedure", arg.getText(), arg.getStart().getText()));
		this.inAlter_procedure = true;
	}

	public void exitAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		onExit();
		this.inAlter_procedure = false;
	}

	protected boolean inAlter_server = false;

	@Override
	public void enterAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		onEnter(new Node("Alter_server", arg.getText(), arg.getStart().getText()));
		this.inAlter_server = true;
	}

	public void exitAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		onExit();
		this.inAlter_server = false;
	}

	protected boolean inAlter_table = false;

	@Override
	public void enterAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		onEnter(new Node("Alter_table", arg.getText(), arg.getStart().getText()));
		this.inAlter_table = true;
	}

	public void exitAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		onExit();
		this.inAlter_table = false;
	}

	protected boolean inAlter_tablespace = false;

	@Override
	public void enterAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		onEnter(new Node("Alter_tablespace", arg.getText(), arg.getStart().getText()));
		this.inAlter_tablespace = true;
	}

	public void exitAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		onExit();
		this.inAlter_tablespace = false;
	}

	protected boolean inAlter_view = false;

	@Override
	public void enterAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		onEnter(new Node("Alter_view", arg.getText(), arg.getStart().getText()));
		this.inAlter_view = true;
	}

	public void exitAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		onExit();
		this.inAlter_view = false;
	}

	protected boolean inAltblTableOpt = false;

	@Override
	public void enterAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		onEnter(new Node("AltblTableOpt", arg.getText(), arg.getStart().getText()));
		this.inAltblTableOpt = true;
	}

	public void exitAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		onExit();
		this.inAltblTableOpt = false;
	}

	protected boolean inAltblAddCol = false;

	@Override
	public void enterAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		onEnter(new Node("AltblAddCol", arg.getText(), arg.getStart().getText()));
		this.inAltblAddCol = true;
	}

	public void exitAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		onExit();
		this.inAltblAddCol = false;
	}

	protected boolean inAltblAddCols = false;

	@Override
	public void enterAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		onEnter(new Node("AltblAddCols", arg.getText(), arg.getStart().getText()));
		this.inAltblAddCols = true;
	}

	public void exitAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		onExit();
		this.inAltblAddCols = false;
	}

	protected boolean inAltblAddIndex = false;

	@Override
	public void enterAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		onEnter(new Node("AltblAddIndex", arg.getText(), arg.getStart().getText()));
		this.inAltblAddIndex = true;
	}

	public void exitAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		onExit();
		this.inAltblAddIndex = false;
	}

	protected boolean inAltblAddPK = false;

	@Override
	public void enterAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		onEnter(new Node("AltblAddPK", arg.getText(), arg.getStart().getText()));
		this.inAltblAddPK = true;
	}

	public void exitAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		onExit();
		this.inAltblAddPK = false;
	}

	protected boolean inAltblAddUK = false;

	@Override
	public void enterAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		onEnter(new Node("AltblAddUK", arg.getText(), arg.getStart().getText()));
		this.inAltblAddUK = true;
	}

	public void exitAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		onExit();
		this.inAltblAddUK = false;
	}

	protected boolean inAltblAddSpecIndex = false;

	@Override
	public void enterAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		onEnter(new Node("AltblAddSpecIndex", arg.getText(), arg.getStart().getText()));
		this.inAltblAddSpecIndex = true;
	}

	public void exitAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		onExit();
		this.inAltblAddSpecIndex = false;
	}

	protected boolean inAltblAddFK = false;

	@Override
	public void enterAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		onEnter(new Node("AltblAddFK", arg.getText(), arg.getStart().getText()));
		this.inAltblAddFK = true;
	}

	public void exitAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		onExit();
		this.inAltblAddFK = false;
	}

	protected boolean inAltblAlg = false;

	@Override
	public void enterAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		onEnter(new Node("AltblAlg", arg.getText(), arg.getStart().getText()));
		this.inAltblAlg = true;
	}

	public void exitAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		onExit();
		this.inAltblAlg = false;
	}

	protected boolean inAltblColDef = false;

	@Override
	public void enterAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		onEnter(new Node("AltblColDef", arg.getText(), arg.getStart().getText()));
		this.inAltblColDef = true;
	}

	public void exitAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		onExit();
		this.inAltblColDef = false;
	}

	protected boolean inAltblColChange = false;

	@Override
	public void enterAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		onEnter(new Node("AltblColChange", arg.getText(), arg.getStart().getText()));
		this.inAltblColChange = true;
	}

	public void exitAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		onExit();
		this.inAltblColChange = false;
	}

	protected boolean inAltblLock = false;

	@Override
	public void enterAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		onEnter(new Node("AltblLock", arg.getText(), arg.getStart().getText()));
		this.inAltblLock = true;
	}

	public void exitAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		onExit();
		this.inAltblLock = false;
	}

	protected boolean inAltblColMod = false;

	@Override
	public void enterAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		onEnter(new Node("AltblColMod", arg.getText(), arg.getStart().getText()));
		this.inAltblColMod = true;
	}

	public void exitAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		onExit();
		this.inAltblColMod = false;
	}

	protected boolean inAltblColDrop = false;

	@Override
	public void enterAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		onEnter(new Node("AltblColDrop", arg.getText(), arg.getStart().getText()));
		this.inAltblColDrop = true;
	}

	public void exitAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		onExit();
		this.inAltblColDrop = false;
	}

	protected boolean inAltblDropPK = false;

	@Override
	public void enterAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		onEnter(new Node("AltblDropPK", arg.getText(), arg.getStart().getText()));
		this.inAltblDropPK = true;
	}

	public void exitAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		onExit();
		this.inAltblDropPK = false;
	}

	protected boolean inAltblDropIndex = false;

	@Override
	public void enterAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		onEnter(new Node("AltblDropIndex", arg.getText(), arg.getStart().getText()));
		this.inAltblDropIndex = true;
	}

	public void exitAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		onExit();
		this.inAltblDropIndex = false;
	}

	protected boolean inAltblDropFK = false;

	@Override
	public void enterAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		onEnter(new Node("AltblDropFK", arg.getText(), arg.getStart().getText()));
		this.inAltblDropFK = true;
	}

	public void exitAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		onExit();
		this.inAltblDropFK = false;
	}

	protected boolean inAltblDisKey = false;

	@Override
	public void enterAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		onEnter(new Node("AltblDisKey", arg.getText(), arg.getStart().getText()));
		this.inAltblDisKey = true;
	}

	public void exitAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		onExit();
		this.inAltblDisKey = false;
	}

	protected boolean inAltblEnKey = false;

	@Override
	public void enterAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		onEnter(new Node("AltblEnKey", arg.getText(), arg.getStart().getText()));
		this.inAltblEnKey = true;
	}

	public void exitAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		onExit();
		this.inAltblEnKey = false;
	}

	protected boolean inAltblRenameTbl = false;

	@Override
	public void enterAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		onEnter(new Node("AltblRenameTbl", arg.getText(), arg.getStart().getText()));
		this.inAltblRenameTbl = true;
	}

	public void exitAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		onExit();
		this.inAltblRenameTbl = false;
	}

	protected boolean inAltblResort = false;

	@Override
	public void enterAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		onEnter(new Node("AltblResort", arg.getText(), arg.getStart().getText()));
		this.inAltblResort = true;
	}

	public void exitAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		onExit();
		this.inAltblResort = false;
	}

	protected boolean inAltblConvert = false;

	@Override
	public void enterAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		onEnter(new Node("AltblConvert", arg.getText(), arg.getStart().getText()));
		this.inAltblConvert = true;
	}

	public void exitAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		onExit();
		this.inAltblConvert = false;
	}

	protected boolean inAltblDefCharset = false;

	@Override
	public void enterAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		onEnter(new Node("AltblDefCharset", arg.getText(), arg.getStart().getText()));
		this.inAltblDefCharset = true;
	}

	public void exitAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		onExit();
		this.inAltblDefCharset = false;
	}

	protected boolean inAltblDisTblspace = false;

	@Override
	public void enterAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		onEnter(new Node("AltblDisTblspace", arg.getText(), arg.getStart().getText()));
		this.inAltblDisTblspace = true;
	}

	public void exitAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		onExit();
		this.inAltblDisTblspace = false;
	}

	protected boolean inAltblImpTblSpace = false;

	@Override
	public void enterAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		onEnter(new Node("AltblImpTblSpace", arg.getText(), arg.getStart().getText()));
		this.inAltblImpTblSpace = true;
	}

	public void exitAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		onExit();
		this.inAltblImpTblSpace = false;
	}

	protected boolean inAltblForce = false;

	@Override
	public void enterAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		onEnter(new Node("AltblForce", arg.getText(), arg.getStart().getText()));
		this.inAltblForce = true;
	}

	public void exitAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		onExit();
		this.inAltblForce = false;
	}

	protected boolean inAltblValid = false;

	@Override
	public void enterAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		onEnter(new Node("AltblValid", arg.getText(), arg.getStart().getText()));
		this.inAltblValid = true;
	}

	public void exitAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		onExit();
		this.inAltblValid = false;
	}

	protected boolean inAltblAddPart = false;

	@Override
	public void enterAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		onEnter(new Node("AltblAddPart", arg.getText(), arg.getStart().getText()));
		this.inAltblAddPart = true;
	}

	public void exitAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		onExit();
		this.inAltblAddPart = false;
	}

	protected boolean inAltblDropPart = false;

	@Override
	public void enterAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		onEnter(new Node("AltblDropPart", arg.getText(), arg.getStart().getText()));
		this.inAltblDropPart = true;
	}

	public void exitAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		onExit();
		this.inAltblDropPart = false;
	}

	protected boolean inAltblDiscartPart = false;

	@Override
	public void enterAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		onEnter(new Node("AltblDiscartPart", arg.getText(), arg.getStart().getText()));
		this.inAltblDiscartPart = true;
	}

	public void exitAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		onExit();
		this.inAltblDiscartPart = false;
	}

	protected boolean inAltblImportPart = false;

	@Override
	public void enterAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		onEnter(new Node("AltblImportPart", arg.getText(), arg.getStart().getText()));
		this.inAltblImportPart = true;
	}

	public void exitAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		onExit();
		this.inAltblImportPart = false;
	}

	protected boolean inAltblTruncPart = false;

	@Override
	public void enterAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		onEnter(new Node("AltblTruncPart", arg.getText(), arg.getStart().getText()));
		this.inAltblTruncPart = true;
	}

	public void exitAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		onExit();
		this.inAltblTruncPart = false;
	}

	protected boolean inAltblCoalPart = false;

	@Override
	public void enterAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		onEnter(new Node("AltblCoalPart", arg.getText(), arg.getStart().getText()));
		this.inAltblCoalPart = true;
	}

	public void exitAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		onExit();
		this.inAltblCoalPart = false;
	}

	protected boolean inAltblReorgPart = false;

	@Override
	public void enterAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		onEnter(new Node("AltblReorgPart", arg.getText(), arg.getStart().getText()));
		this.inAltblReorgPart = true;
	}

	public void exitAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		onExit();
		this.inAltblReorgPart = false;
	}

	protected boolean inAltblExchPart = false;

	@Override
	public void enterAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		onEnter(new Node("AltblExchPart", arg.getText(), arg.getStart().getText()));
		this.inAltblExchPart = true;
	}

	public void exitAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		onExit();
		this.inAltblExchPart = false;
	}

	protected boolean inAltblAnalPart = false;

	@Override
	public void enterAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		onEnter(new Node("AltblAnalPart", arg.getText(), arg.getStart().getText()));
		this.inAltblAnalPart = true;
	}

	public void exitAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		onExit();
		this.inAltblAnalPart = false;
	}

	protected boolean inAltblCheckPart = false;

	@Override
	public void enterAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		onEnter(new Node("AltblCheckPart", arg.getText(), arg.getStart().getText()));
		this.inAltblCheckPart = true;
	}

	public void exitAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		onExit();
		this.inAltblCheckPart = false;
	}

	protected boolean inAltblOptimPart = false;

	@Override
	public void enterAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		onEnter(new Node("AltblOptimPart", arg.getText(), arg.getStart().getText()));
		this.inAltblOptimPart = true;
	}

	public void exitAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		onExit();
		this.inAltblOptimPart = false;
	}

	protected boolean inAltblRebuildPart = false;

	@Override
	public void enterAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		onEnter(new Node("AltblRebuildPart", arg.getText(), arg.getStart().getText()));
		this.inAltblRebuildPart = true;
	}

	public void exitAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		onExit();
		this.inAltblRebuildPart = false;
	}

	protected boolean inAltblRepairPart = false;

	@Override
	public void enterAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		onEnter(new Node("AltblRepairPart", arg.getText(), arg.getStart().getText()));
		this.inAltblRepairPart = true;
	}

	public void exitAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		onExit();
		this.inAltblRepairPart = false;
	}

	protected boolean inAltblRemovePart = false;

	@Override
	public void enterAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		onEnter(new Node("AltblRemovePart", arg.getText(), arg.getStart().getText()));
		this.inAltblRemovePart = true;
	}

	public void exitAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		onExit();
		this.inAltblRemovePart = false;
	}

	protected boolean inAltblUpgrPart = false;

	@Override
	public void enterAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		onEnter(new Node("AltblUpgrPart", arg.getText(), arg.getStart().getText()));
		this.inAltblUpgrPart = true;
	}

	public void exitAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		onExit();
		this.inAltblUpgrPart = false;
	}

	protected boolean inDrop_database = false;

	@Override
	public void enterDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		onEnter(new Node("Drop_database", arg.getText(), arg.getStart().getText()));
		this.inDrop_database = true;
	}

	public void exitDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		onExit();
		this.inDrop_database = false;
	}

	protected boolean inDrop_event = false;

	@Override
	public void enterDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		onEnter(new Node("Drop_event", arg.getText(), arg.getStart().getText()));
		this.inDrop_event = true;
	}

	public void exitDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		onExit();
		this.inDrop_event = false;
	}

	protected boolean inDrop_index = false;

	@Override
	public void enterDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		onEnter(new Node("Drop_index", arg.getText(), arg.getStart().getText()));
		this.inDrop_index = true;
	}

	public void exitDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		onExit();
		this.inDrop_index = false;
	}

	protected boolean inDrop_logfile_group = false;

	@Override
	public void enterDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		onEnter(new Node("Drop_logfile_group", arg.getText(), arg.getStart().getText()));
		this.inDrop_logfile_group = true;
	}

	public void exitDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		onExit();
		this.inDrop_logfile_group = false;
	}

	protected boolean inDrop_procedure = false;

	@Override
	public void enterDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		onEnter(new Node("Drop_procedure", arg.getText(), arg.getStart().getText()));
		this.inDrop_procedure = true;
	}

	public void exitDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		onExit();
		this.inDrop_procedure = false;
	}

	protected boolean inDrop_function = false;

	@Override
	public void enterDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		onEnter(new Node("Drop_function", arg.getText(), arg.getStart().getText()));
		this.inDrop_function = true;
	}

	public void exitDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		onExit();
		this.inDrop_function = false;
	}

	protected boolean inDrop_server = false;

	@Override
	public void enterDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		onEnter(new Node("Drop_server", arg.getText(), arg.getStart().getText()));
		this.inDrop_server = true;
	}

	public void exitDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		onExit();
		this.inDrop_server = false;
	}

	protected boolean inDrop_table = false;

	@Override
	public void enterDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		onEnter(new Node("Drop_table", arg.getText(), arg.getStart().getText()));
		this.inDrop_table = true;
	}

	public void exitDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		onExit();
		this.inDrop_table = false;
	}

	protected boolean inDrop_tablespace = false;

	@Override
	public void enterDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		onEnter(new Node("Drop_tablespace", arg.getText(), arg.getStart().getText()));
		this.inDrop_tablespace = true;
	}

	public void exitDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		onExit();
		this.inDrop_tablespace = false;
	}

	protected boolean inDrop_trigger = false;

	@Override
	public void enterDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		onEnter(new Node("Drop_trigger", arg.getText(), arg.getStart().getText()));
		this.inDrop_trigger = true;
	}

	public void exitDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		onExit();
		this.inDrop_trigger = false;
	}

	protected boolean inDrop_view = false;

	@Override
	public void enterDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		onEnter(new Node("Drop_view", arg.getText(), arg.getStart().getText()));
		this.inDrop_view = true;
	}

	public void exitDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		onExit();
		this.inDrop_view = false;
	}

	protected boolean inRename_table = false;

	@Override
	public void enterRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		onEnter(new Node("Rename_table", arg.getText(), arg.getStart().getText()));
		this.inRename_table = true;
	}

	public void exitRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		onExit();
		this.inRename_table = false;
	}

	protected boolean inTruncate_table = false;

	@Override
	public void enterTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		onEnter(new Node("Truncate_table", arg.getText(), arg.getStart().getText()));
		this.inTruncate_table = true;
	}

	public void exitTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		onExit();
		this.inTruncate_table = false;
	}

	protected boolean inCall_statement = false;

	@Override
	public void enterCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		onEnter(new Node("Call_statement", arg.getText(), arg.getStart().getText()));
		this.inCall_statement = true;
	}

	public void exitCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		onExit();
		this.inCall_statement = false;
	}

	protected boolean inDelete_statement = false;

	@Override
	public void enterDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		onEnter(new Node("Delete_statement", arg.getText(), arg.getStart().getText()));
		this.inDelete_statement = true;
	}

	public void exitDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		onExit();
		this.inDelete_statement = false;
	}

	protected boolean inDo_statement = false;

	@Override
	public void enterDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		onEnter(new Node("Do_statement", arg.getText(), arg.getStart().getText()));
		this.inDo_statement = true;
	}

	public void exitDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		onExit();
		this.inDo_statement = false;
	}

	protected boolean inHandler_statement = false;

	@Override
	public void enterHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		onEnter(new Node("Handler_statement", arg.getText(), arg.getStart().getText()));
		this.inHandler_statement = true;
	}

	public void exitHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		onExit();
		this.inHandler_statement = false;
	}

	protected boolean inInsert_statement = false;

	@Override
	public void enterInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		onEnter(new Node("Insert_statement", arg.getText(), arg.getStart().getText()));
		this.inInsert_statement = true;
	}

	public void exitInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		onExit();
		this.inInsert_statement = false;
	}

	protected boolean inLoad_data_statement = false;

	@Override
	public void enterLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		onEnter(new Node("Load_data_statement", arg.getText(), arg.getStart().getText()));
		this.inLoad_data_statement = true;
	}

	public void exitLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		onExit();
		this.inLoad_data_statement = false;
	}

	protected boolean inLoad_xml_statement = false;

	@Override
	public void enterLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		onEnter(new Node("Load_xml_statement", arg.getText(), arg.getStart().getText()));
		this.inLoad_xml_statement = true;
	}

	public void exitLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		onExit();
		this.inLoad_xml_statement = false;
	}

	protected boolean inReplace_statement = false;

	@Override
	public void enterReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		onEnter(new Node("Replace_statement", arg.getText(), arg.getStart().getText()));
		this.inReplace_statement = true;
	}

	public void exitReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		onExit();
		this.inReplace_statement = false;
	}

	protected boolean inSimpleSelect = false;

	@Override
	public void enterSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		onEnter(new Node("SimpleSelect", arg.getText(), arg.getStart().getText()));
		this.inSimpleSelect = true;
	}

	public void exitSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		onExit();
		this.inSimpleSelect = false;
	}

	protected boolean inParenSelect = false;

	@Override
	public void enterParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		onEnter(new Node("ParenSelect", arg.getText(), arg.getStart().getText()));
		this.inParenSelect = true;
	}

	public void exitParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		onExit();
		this.inParenSelect = false;
	}

	protected boolean inUnionSelect = false;

	@Override
	public void enterUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		onEnter(new Node("UnionSelect", arg.getText(), arg.getStart().getText()));
		this.inUnionSelect = true;
	}

	public void exitUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		onExit();
		this.inUnionSelect = false;
	}

	protected boolean inUnionParenSelect = false;

	@Override
	public void enterUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		onEnter(new Node("UnionParenSelect", arg.getText(), arg.getStart().getText()));
		this.inUnionParenSelect = true;
	}

	public void exitUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		onExit();
		this.inUnionParenSelect = false;
	}

	protected boolean inUpdate_statement = false;

	@Override
	public void enterUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		onEnter(new Node("Update_statement", arg.getText(), arg.getStart().getText()));
		this.inUpdate_statement = true;
	}

	public void exitUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		onExit();
		this.inUpdate_statement = false;
	}

	protected boolean inInsert_statement_value = false;

	@Override
	public void enterInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		onEnter(new Node("Insert_statement_value", arg.getText(), arg.getStart().getText()));
		this.inInsert_statement_value = true;
	}

	public void exitInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		onExit();
		this.inInsert_statement_value = false;
	}

	protected boolean inUpdate_elem = false;

	@Override
	public void enterUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		onEnter(new Node("Update_elem", arg.getText(), arg.getStart().getText()));
		this.inUpdate_elem = true;
	}

	public void exitUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		onExit();
		this.inUpdate_elem = false;
	}

	protected boolean inCol_or_uservar = false;

	@Override
	public void enterCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		onEnter(new Node("Col_or_uservar", arg.getText(), arg.getStart().getText()));
		this.inCol_or_uservar = true;
	}

	public void exitCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		onExit();
		this.inCol_or_uservar = false;
	}

	protected boolean inSingle_delete_statement = false;

	@Override
	public void enterSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		onEnter(new Node("Single_delete_statement", arg.getText(), arg.getStart().getText()));
		this.inSingle_delete_statement = true;
	}

	public void exitSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		onExit();
		this.inSingle_delete_statement = false;
	}

	protected boolean inMultiple_delete_statement = false;

	@Override
	public void enterMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		onEnter(new Node("Multiple_delete_statement", arg.getText(), arg.getStart().getText()));
		this.inMultiple_delete_statement = true;
	}

	public void exitMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		onExit();
		this.inMultiple_delete_statement = false;
	}

	protected boolean inHandler_open_statement = false;

	@Override
	public void enterHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		onEnter(new Node("Handler_open_statement", arg.getText(), arg.getStart().getText()));
		this.inHandler_open_statement = true;
	}

	public void exitHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		onExit();
		this.inHandler_open_statement = false;
	}

	protected boolean inHandler_read_index_statement = false;

	@Override
	public void enterHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		onEnter(new Node("Handler_read_index_statement", arg.getText(), arg.getStart().getText()));
		this.inHandler_read_index_statement = true;
	}

	public void exitHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		onExit();
		this.inHandler_read_index_statement = false;
	}

	protected boolean inHandler_read_statement = false;

	@Override
	public void enterHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		onEnter(new Node("Handler_read_statement", arg.getText(), arg.getStart().getText()));
		this.inHandler_read_statement = true;
	}

	public void exitHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		onExit();
		this.inHandler_read_statement = false;
	}

	protected boolean inHandler_close_statement = false;

	@Override
	public void enterHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		onEnter(new Node("Handler_close_statement", arg.getText(), arg.getStart().getText()));
		this.inHandler_close_statement = true;
	}

	public void exitHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		onExit();
		this.inHandler_close_statement = false;
	}

	protected boolean inSingle_update_statement = false;

	@Override
	public void enterSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		onEnter(new Node("Single_update_statement", arg.getText(), arg.getStart().getText()));
		this.inSingle_update_statement = true;
	}

	public void exitSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		onExit();
		this.inSingle_update_statement = false;
	}

	protected boolean inMultiple_update_statement = false;

	@Override
	public void enterMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		onEnter(new Node("Multiple_update_statement", arg.getText(), arg.getStart().getText()));
		this.inMultiple_update_statement = true;
	}

	public void exitMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		onExit();
		this.inMultiple_update_statement = false;
	}

	protected boolean inOrder_by_clause = false;

	@Override
	public void enterOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		onEnter(new Node("Order_by_clause", arg.getText(), arg.getStart().getText()));
		this.inOrder_by_clause = true;
	}

	public void exitOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		onExit();
		this.inOrder_by_clause = false;
	}

	protected boolean inOrder_by_expression = false;

	@Override
	public void enterOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		onEnter(new Node("Order_by_expression", arg.getText(), arg.getStart().getText()));
		this.inOrder_by_expression = true;
	}

	public void exitOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		onExit();
		this.inOrder_by_expression = false;
	}

	protected boolean inTable_sources = false;

	@Override
	public void enterTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		onEnter(new Node("Table_sources", arg.getText(), arg.getStart().getText()));
		this.inTable_sources = true;
	}

	public void exitTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		onExit();
		this.inTable_sources = false;
	}

	protected boolean inTable_source = false;

	@Override
	public void enterTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		onEnter(new Node("Table_source", arg.getText(), arg.getStart().getText()));
		this.inTable_source = true;
	}

	public void exitTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		onExit();
		this.inTable_source = false;
	}

	protected boolean inAtomTableItem = false;

	@Override
	public void enterAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		onEnter(new Node("AtomTableItem", arg.getText(), arg.getStart().getText()));
		this.inAtomTableItem = true;
	}

	public void exitAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		onExit();
		this.inAtomTableItem = false;
	}

	protected boolean inSubqueryTableItem = false;

	@Override
	public void enterSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		onEnter(new Node("SubqueryTableItem", arg.getText(), arg.getStart().getText()));
		this.inSubqueryTableItem = true;
	}

	public void exitSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		onExit();
		this.inSubqueryTableItem = false;
	}

	protected boolean inTableSourcesItem = false;

	@Override
	public void enterTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		onEnter(new Node("TableSourcesItem", arg.getText(), arg.getStart().getText()));
		this.inTableSourcesItem = true;
	}

	public void exitTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		onExit();
		this.inTableSourcesItem = false;
	}

	protected boolean inIndex_hint = false;

	@Override
	public void enterIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		onEnter(new Node("Index_hint", arg.getText(), arg.getStart().getText()));
		this.inIndex_hint = true;
	}

	public void exitIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		onExit();
		this.inIndex_hint = false;
	}

	protected boolean inInnerJoin = false;

	@Override
	public void enterInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		onEnter(new Node("InnerJoin", arg.getText(), arg.getStart().getText()));
		this.inInnerJoin = true;
	}

	public void exitInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		onExit();
		this.inInnerJoin = false;
	}

	protected boolean inStraightJoin = false;

	@Override
	public void enterStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		onEnter(new Node("StraightJoin", arg.getText(), arg.getStart().getText()));
		this.inStraightJoin = true;
	}

	public void exitStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		onExit();
		this.inStraightJoin = false;
	}

	protected boolean inOuterJoin = false;

	@Override
	public void enterOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		onEnter(new Node("OuterJoin", arg.getText(), arg.getStart().getText()));
		this.inOuterJoin = true;
	}

	public void exitOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		onExit();
		this.inOuterJoin = false;
	}

	protected boolean inNaturalJoin = false;

	@Override
	public void enterNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		onEnter(new Node("NaturalJoin", arg.getText(), arg.getStart().getText()));
		this.inNaturalJoin = true;
	}

	public void exitNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		onExit();
		this.inNaturalJoin = false;
	}

	protected boolean inSubquery = false;

	@Override
	public void enterSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		onEnter(new Node("Subquery", arg.getText(), arg.getStart().getText()));
		this.inSubquery = true;
	}

	public void exitSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		onExit();
		this.inSubquery = false;
	}

	protected boolean inQuery_expression = false;

	@Override
	public void enterQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		onEnter(new Node("Query_expression", arg.getText(), arg.getStart().getText()));
		this.inQuery_expression = true;
	}

	public void exitQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		onExit();
		this.inQuery_expression = false;
	}

	protected boolean inQuery_expression_nointo = false;

	@Override
	public void enterQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		onEnter(new Node("Query_expression_nointo", arg.getText(), arg.getStart().getText()));
		this.inQuery_expression_nointo = true;
	}

	public void exitQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		onExit();
		this.inQuery_expression_nointo = false;
	}

	protected boolean inQuery_specification = false;

	@Override
	public void enterQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		onEnter(new Node("Query_specification", arg.getText(), arg.getStart().getText()));
		this.inQuery_specification = true;
	}

	public void exitQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		onExit();
		this.inQuery_specification = false;
	}

	protected boolean inQuery_specification_nointo = false;

	@Override
	public void enterQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		onEnter(new Node("Query_specification_nointo", arg.getText(), arg.getStart().getText()));
		this.inQuery_specification_nointo = true;
	}

	public void exitQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		onExit();
		this.inQuery_specification_nointo = false;
	}

	protected boolean inUnion_parenth = false;

	@Override
	public void enterUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		onEnter(new Node("Union_parenth", arg.getText(), arg.getStart().getText()));
		this.inUnion_parenth = true;
	}

	public void exitUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		onExit();
		this.inUnion_parenth = false;
	}

	protected boolean inUnion_statement = false;

	@Override
	public void enterUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		onEnter(new Node("Union_statement", arg.getText(), arg.getStart().getText()));
		this.inUnion_statement = true;
	}

	public void exitUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		onExit();
		this.inUnion_statement = false;
	}

	protected boolean inSelect_spec = false;

	@Override
	public void enterSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		onEnter(new Node("Select_spec", arg.getText(), arg.getStart().getText()));
		this.inSelect_spec = true;
	}

	public void exitSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		onExit();
		this.inSelect_spec = false;
	}

	protected boolean inSelect_list = false;

	@Override
	public void enterSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		onEnter(new Node("Select_list", arg.getText(), arg.getStart().getText()));
		this.inSelect_list = true;
	}

	public void exitSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		onExit();
		this.inSelect_list = false;
	}

	protected boolean inSellistelAllCol = false;

	@Override
	public void enterSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		onEnter(new Node("SellistelAllCol", arg.getText(), arg.getStart().getText()));
		this.inSellistelAllCol = true;
	}

	public void exitSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		onExit();
		this.inSellistelAllCol = false;
	}

	protected boolean inSellistelCol = false;

	@Override
	public void enterSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		onEnter(new Node("SellistelCol", arg.getText(), arg.getStart().getText()));
		this.inSellistelCol = true;
	}

	public void exitSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		onExit();
		this.inSellistelCol = false;
	}

	protected boolean inSellistelFunc = false;

	@Override
	public void enterSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		onEnter(new Node("SellistelFunc", arg.getText(), arg.getStart().getText()));
		this.inSellistelFunc = true;
	}

	public void exitSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		onExit();
		this.inSellistelFunc = false;
	}

	protected boolean inSellistelExpr = false;

	@Override
	public void enterSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		onEnter(new Node("SellistelExpr", arg.getText(), arg.getStart().getText()));
		this.inSellistelExpr = true;
	}

	public void exitSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		onExit();
		this.inSellistelExpr = false;
	}

	protected boolean inSelectIntoVars = false;

	@Override
	public void enterSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		onEnter(new Node("SelectIntoVars", arg.getText(), arg.getStart().getText()));
		this.inSelectIntoVars = true;
	}

	public void exitSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		onExit();
		this.inSelectIntoVars = false;
	}

	protected boolean inSelectIntoDump = false;

	@Override
	public void enterSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		onEnter(new Node("SelectIntoDump", arg.getText(), arg.getStart().getText()));
		this.inSelectIntoDump = true;
	}

	public void exitSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		onExit();
		this.inSelectIntoDump = false;
	}

	protected boolean inSelectIntoOutfile = false;

	@Override
	public void enterSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		onEnter(new Node("SelectIntoOutfile", arg.getText(), arg.getStart().getText()));
		this.inSelectIntoOutfile = true;
	}

	public void exitSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		onExit();
		this.inSelectIntoOutfile = false;
	}

	protected boolean inFrom_clause = false;

	@Override
	public void enterFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		onEnter(new Node("From_clause", arg.getText(), arg.getStart().getText()));
		this.inFrom_clause = true;
	}

	public void exitFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		onExit();
		this.inFrom_clause = false;
	}

	protected boolean inGroup_by_item = false;

	@Override
	public void enterGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		onEnter(new Node("Group_by_item", arg.getText(), arg.getStart().getText()));
		this.inGroup_by_item = true;
	}

	public void exitGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		onExit();
		this.inGroup_by_item = false;
	}

	protected boolean inLimit_clause = false;

	@Override
	public void enterLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		onEnter(new Node("Limit_clause", arg.getText(), arg.getStart().getText()));
		this.inLimit_clause = true;
	}

	public void exitLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		onExit();
		this.inLimit_clause = false;
	}

	protected boolean inStart_transaction = false;

	@Override
	public void enterStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		onEnter(new Node("Start_transaction", arg.getText(), arg.getStart().getText()));
		this.inStart_transaction = true;
	}

	public void exitStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		onExit();
		this.inStart_transaction = false;
	}

	protected boolean inBegin_work = false;

	@Override
	public void enterBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		onEnter(new Node("Begin_work", arg.getText(), arg.getStart().getText()));
		this.inBegin_work = true;
	}

	public void exitBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		onExit();
		this.inBegin_work = false;
	}

	protected boolean inCommit_work = false;

	@Override
	public void enterCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		onEnter(new Node("Commit_work", arg.getText(), arg.getStart().getText()));
		this.inCommit_work = true;
	}

	public void exitCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		onExit();
		this.inCommit_work = false;
	}

	protected boolean inRollback_work = false;

	@Override
	public void enterRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		onEnter(new Node("Rollback_work", arg.getText(), arg.getStart().getText()));
		this.inRollback_work = true;
	}

	public void exitRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		onExit();
		this.inRollback_work = false;
	}

	protected boolean inSavepoint_statement = false;

	@Override
	public void enterSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		onEnter(new Node("Savepoint_statement", arg.getText(), arg.getStart().getText()));
		this.inSavepoint_statement = true;
	}

	public void exitSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		onExit();
		this.inSavepoint_statement = false;
	}

	protected boolean inRollback_statement = false;

	@Override
	public void enterRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		onEnter(new Node("Rollback_statement", arg.getText(), arg.getStart().getText()));
		this.inRollback_statement = true;
	}

	public void exitRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		onExit();
		this.inRollback_statement = false;
	}

	protected boolean inRelease_statement = false;

	@Override
	public void enterRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		onEnter(new Node("Release_statement", arg.getText(), arg.getStart().getText()));
		this.inRelease_statement = true;
	}

	public void exitRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		onExit();
		this.inRelease_statement = false;
	}

	protected boolean inLock_tables = false;

	@Override
	public void enterLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		onEnter(new Node("Lock_tables", arg.getText(), arg.getStart().getText()));
		this.inLock_tables = true;
	}

	public void exitLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		onExit();
		this.inLock_tables = false;
	}

	protected boolean inUnlock_tables = false;

	@Override
	public void enterUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		onEnter(new Node("Unlock_tables", arg.getText(), arg.getStart().getText()));
		this.inUnlock_tables = true;
	}

	public void exitUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		onExit();
		this.inUnlock_tables = false;
	}

	protected boolean inSet_autocommit_statement = false;

	@Override
	public void enterSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		onEnter(new Node("Set_autocommit_statement", arg.getText(), arg.getStart().getText()));
		this.inSet_autocommit_statement = true;
	}

	public void exitSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		onExit();
		this.inSet_autocommit_statement = false;
	}

	protected boolean inSet_transaction_statement = false;

	@Override
	public void enterSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		onEnter(new Node("Set_transaction_statement", arg.getText(), arg.getStart().getText()));
		this.inSet_transaction_statement = true;
	}

	public void exitSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		onExit();
		this.inSet_transaction_statement = false;
	}

	protected boolean inTransact_option = false;

	@Override
	public void enterTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		onEnter(new Node("Transact_option", arg.getText(), arg.getStart().getText()));
		this.inTransact_option = true;
	}

	public void exitTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		onExit();
		this.inTransact_option = false;
	}

	protected boolean inLock_table_element = false;

	@Override
	public void enterLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		onEnter(new Node("Lock_table_element", arg.getText(), arg.getStart().getText()));
		this.inLock_table_element = true;
	}

	public void exitLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		onExit();
		this.inLock_table_element = false;
	}

	protected boolean inTrans_characteristic = false;

	@Override
	public void enterTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		onEnter(new Node("Trans_characteristic", arg.getText(), arg.getStart().getText()));
		this.inTrans_characteristic = true;
	}

	public void exitTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		onExit();
		this.inTrans_characteristic = false;
	}

	protected boolean inTransaction_level = false;

	@Override
	public void enterTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		onEnter(new Node("Transaction_level", arg.getText(), arg.getStart().getText()));
		this.inTransaction_level = true;
	}

	public void exitTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		onExit();
		this.inTransaction_level = false;
	}

	protected boolean inChange_master = false;

	@Override
	public void enterChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		onEnter(new Node("Change_master", arg.getText(), arg.getStart().getText()));
		this.inChange_master = true;
	}

	public void exitChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		onExit();
		this.inChange_master = false;
	}

	protected boolean inChange_repl_filter = false;

	@Override
	public void enterChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		onEnter(new Node("Change_repl_filter", arg.getText(), arg.getStart().getText()));
		this.inChange_repl_filter = true;
	}

	public void exitChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		onExit();
		this.inChange_repl_filter = false;
	}

	protected boolean inPurge_binary_logs = false;

	@Override
	public void enterPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		onEnter(new Node("Purge_binary_logs", arg.getText(), arg.getStart().getText()));
		this.inPurge_binary_logs = true;
	}

	public void exitPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		onExit();
		this.inPurge_binary_logs = false;
	}

	protected boolean inReset_master = false;

	@Override
	public void enterReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		onEnter(new Node("Reset_master", arg.getText(), arg.getStart().getText()));
		this.inReset_master = true;
	}

	public void exitReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		onExit();
		this.inReset_master = false;
	}

	protected boolean inReset_slave = false;

	@Override
	public void enterReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		onEnter(new Node("Reset_slave", arg.getText(), arg.getStart().getText()));
		this.inReset_slave = true;
	}

	public void exitReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		onExit();
		this.inReset_slave = false;
	}

	protected boolean inStart_slave = false;

	@Override
	public void enterStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		onEnter(new Node("Start_slave", arg.getText(), arg.getStart().getText()));
		this.inStart_slave = true;
	}

	public void exitStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		onExit();
		this.inStart_slave = false;
	}

	protected boolean inStop_slave = false;

	@Override
	public void enterStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		onEnter(new Node("Stop_slave", arg.getText(), arg.getStart().getText()));
		this.inStop_slave = true;
	}

	public void exitStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		onExit();
		this.inStop_slave = false;
	}

	protected boolean inStart_group_repl = false;

	@Override
	public void enterStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		onEnter(new Node("Start_group_repl", arg.getText(), arg.getStart().getText()));
		this.inStart_group_repl = true;
	}

	public void exitStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		onExit();
		this.inStart_group_repl = false;
	}

	protected boolean inStop_group_repl = false;

	@Override
	public void enterStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		onEnter(new Node("Stop_group_repl", arg.getText(), arg.getStart().getText()));
		this.inStop_group_repl = true;
	}

	public void exitStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		onExit();
		this.inStop_group_repl = false;
	}

	protected boolean inMasterOptString = false;

	@Override
	public void enterMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		onEnter(new Node("MasterOptString", arg.getText(), arg.getStart().getText()));
		this.inMasterOptString = true;
	}

	public void exitMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		onExit();
		this.inMasterOptString = false;
	}

	protected boolean inMasterOptDecimal = false;

	@Override
	public void enterMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		onEnter(new Node("MasterOptDecimal", arg.getText(), arg.getStart().getText()));
		this.inMasterOptDecimal = true;
	}

	public void exitMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		onExit();
		this.inMasterOptDecimal = false;
	}

	protected boolean inMasterOptBool = false;

	@Override
	public void enterMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		onEnter(new Node("MasterOptBool", arg.getText(), arg.getStart().getText()));
		this.inMasterOptBool = true;
	}

	public void exitMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		onExit();
		this.inMasterOptBool = false;
	}

	protected boolean inMasterOptReal = false;

	@Override
	public void enterMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		onEnter(new Node("MasterOptReal", arg.getText(), arg.getStart().getText()));
		this.inMasterOptReal = true;
	}

	public void exitMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		onExit();
		this.inMasterOptReal = false;
	}

	protected boolean inMasterOptIdList = false;

	@Override
	public void enterMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		onEnter(new Node("MasterOptIdList", arg.getText(), arg.getStart().getText()));
		this.inMasterOptIdList = true;
	}

	public void exitMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		onExit();
		this.inMasterOptIdList = false;
	}

	protected boolean inString_master_option = false;

	@Override
	public void enterString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		onEnter(new Node("String_master_option", arg.getText(), arg.getStart().getText()));
		this.inString_master_option = true;
	}

	public void exitString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		onExit();
		this.inString_master_option = false;
	}

	protected boolean inDecimal_master_option = false;

	@Override
	public void enterDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		onEnter(new Node("Decimal_master_option", arg.getText(), arg.getStart().getText()));
		this.inDecimal_master_option = true;
	}

	public void exitDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		onExit();
		this.inDecimal_master_option = false;
	}

	protected boolean inBool_master_option = false;

	@Override
	public void enterBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		onEnter(new Node("Bool_master_option", arg.getText(), arg.getStart().getText()));
		this.inBool_master_option = true;
	}

	public void exitBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		onExit();
		this.inBool_master_option = false;
	}

	protected boolean inChannel_option = false;

	@Override
	public void enterChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		onEnter(new Node("Channel_option", arg.getText(), arg.getStart().getText()));
		this.inChannel_option = true;
	}

	public void exitChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		onExit();
		this.inChannel_option = false;
	}

	protected boolean inReplfilterDbList = false;

	@Override
	public void enterReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		onEnter(new Node("ReplfilterDbList", arg.getText(), arg.getStart().getText()));
		this.inReplfilterDbList = true;
	}

	public void exitReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		onExit();
		this.inReplfilterDbList = false;
	}

	protected boolean inReplfilterTableList = false;

	@Override
	public void enterReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		onEnter(new Node("ReplfilterTableList", arg.getText(), arg.getStart().getText()));
		this.inReplfilterTableList = true;
	}

	public void exitReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		onExit();
		this.inReplfilterTableList = false;
	}

	protected boolean inReplfilterStableList = false;

	@Override
	public void enterReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		onEnter(new Node("ReplfilterStableList", arg.getText(), arg.getStart().getText()));
		this.inReplfilterStableList = true;
	}

	public void exitReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		onExit();
		this.inReplfilterStableList = false;
	}

	protected boolean inReplfilterTablepairList = false;

	@Override
	public void enterReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		onEnter(new Node("ReplfilterTablepairList", arg.getText(), arg.getStart().getText()));
		this.inReplfilterTablepairList = true;
	}

	public void exitReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		onExit();
		this.inReplfilterTablepairList = false;
	}

	protected boolean inThread_type = false;

	@Override
	public void enterThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		onEnter(new Node("Thread_type", arg.getText(), arg.getStart().getText()));
		this.inThread_type = true;
	}

	public void exitThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		onExit();
		this.inThread_type = false;
	}

	protected boolean inUntilGtidSset = false;

	@Override
	public void enterUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		onEnter(new Node("UntilGtidSset", arg.getText(), arg.getStart().getText()));
		this.inUntilGtidSset = true;
	}

	public void exitUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		onExit();
		this.inUntilGtidSset = false;
	}

	protected boolean inUntilMasterLog = false;

	@Override
	public void enterUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		onEnter(new Node("UntilMasterLog", arg.getText(), arg.getStart().getText()));
		this.inUntilMasterLog = true;
	}

	public void exitUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		onExit();
		this.inUntilMasterLog = false;
	}

	protected boolean inUntilRelayLog = false;

	@Override
	public void enterUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		onEnter(new Node("UntilRelayLog", arg.getText(), arg.getStart().getText()));
		this.inUntilRelayLog = true;
	}

	public void exitUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		onExit();
		this.inUntilRelayLog = false;
	}

	protected boolean inUntilSqlGaps = false;

	@Override
	public void enterUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		onEnter(new Node("UntilSqlGaps", arg.getText(), arg.getStart().getText()));
		this.inUntilSqlGaps = true;
	}

	public void exitUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		onExit();
		this.inUntilSqlGaps = false;
	}

	protected boolean inStart_slave_connection_option = false;

	@Override
	public void enterStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		onEnter(new Node("Start_slave_connection_option", arg.getText(), arg.getStart().getText()));
		this.inStart_slave_connection_option = true;
	}

	public void exitStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		onExit();
		this.inStart_slave_connection_option = false;
	}

	protected boolean inGtid_set = false;

	@Override
	public void enterGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		onEnter(new Node("Gtid_set", arg.getText(), arg.getStart().getText()));
		this.inGtid_set = true;
	}

	public void exitGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		onExit();
		this.inGtid_set = false;
	}

	protected boolean inXa_start_transaction = false;

	@Override
	public void enterXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		onEnter(new Node("Xa_start_transaction", arg.getText(), arg.getStart().getText()));
		this.inXa_start_transaction = true;
	}

	public void exitXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		onExit();
		this.inXa_start_transaction = false;
	}

	protected boolean inXa_end_transaction = false;

	@Override
	public void enterXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		onEnter(new Node("Xa_end_transaction", arg.getText(), arg.getStart().getText()));
		this.inXa_end_transaction = true;
	}

	public void exitXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		onExit();
		this.inXa_end_transaction = false;
	}

	protected boolean inXa_prepare = false;

	@Override
	public void enterXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		onEnter(new Node("Xa_prepare", arg.getText(), arg.getStart().getText()));
		this.inXa_prepare = true;
	}

	public void exitXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		onExit();
		this.inXa_prepare = false;
	}

	protected boolean inXa_commit_work = false;

	@Override
	public void enterXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		onEnter(new Node("Xa_commit_work", arg.getText(), arg.getStart().getText()));
		this.inXa_commit_work = true;
	}

	public void exitXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		onExit();
		this.inXa_commit_work = false;
	}

	protected boolean inXa_rollback_work = false;

	@Override
	public void enterXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		onEnter(new Node("Xa_rollback_work", arg.getText(), arg.getStart().getText()));
		this.inXa_rollback_work = true;
	}

	public void exitXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		onExit();
		this.inXa_rollback_work = false;
	}

	protected boolean inXa_recover_work = false;

	@Override
	public void enterXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		onEnter(new Node("Xa_recover_work", arg.getText(), arg.getStart().getText()));
		this.inXa_recover_work = true;
	}

	public void exitXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		onExit();
		this.inXa_recover_work = false;
	}

	protected boolean inPrepare_statement = false;

	@Override
	public void enterPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		onEnter(new Node("Prepare_statement", arg.getText(), arg.getStart().getText()));
		this.inPrepare_statement = true;
	}

	public void exitPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		onExit();
		this.inPrepare_statement = false;
	}

	protected boolean inExecute_statement = false;

	@Override
	public void enterExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		onEnter(new Node("Execute_statement", arg.getText(), arg.getStart().getText()));
		this.inExecute_statement = true;
	}

	public void exitExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		onExit();
		this.inExecute_statement = false;
	}

	protected boolean inDeallocate_prepare = false;

	@Override
	public void enterDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		onEnter(new Node("Deallocate_prepare", arg.getText(), arg.getStart().getText()));
		this.inDeallocate_prepare = true;
	}

	public void exitDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		onExit();
		this.inDeallocate_prepare = false;
	}

	protected boolean inRoutine_body = false;

	@Override
	public void enterRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		onEnter(new Node("Routine_body", arg.getText(), arg.getStart().getText()));
		this.inRoutine_body = true;
	}

	public void exitRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		onExit();
		this.inRoutine_body = false;
	}

	protected boolean inBlock_statement = false;

	@Override
	public void enterBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		onEnter(new Node("Block_statement", arg.getText(), arg.getStart().getText()));
		this.inBlock_statement = true;
	}

	public void exitBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		onExit();
		this.inBlock_statement = false;
	}

	protected boolean inCase_statement = false;

	@Override
	public void enterCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		onEnter(new Node("Case_statement", arg.getText(), arg.getStart().getText()));
		this.inCase_statement = true;
	}

	public void exitCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		onExit();
		this.inCase_statement = false;
	}

	protected boolean inIf_statement = false;

	@Override
	public void enterIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		onEnter(new Node("If_statement", arg.getText(), arg.getStart().getText()));
		this.inIf_statement = true;
	}

	public void exitIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		onExit();
		this.inIf_statement = false;
	}

	protected boolean inIterate_statement = false;

	@Override
	public void enterIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		onEnter(new Node("Iterate_statement", arg.getText(), arg.getStart().getText()));
		this.inIterate_statement = true;
	}

	public void exitIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		onExit();
		this.inIterate_statement = false;
	}

	protected boolean inLeave_statement = false;

	@Override
	public void enterLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		onEnter(new Node("Leave_statement", arg.getText(), arg.getStart().getText()));
		this.inLeave_statement = true;
	}

	public void exitLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		onExit();
		this.inLeave_statement = false;
	}

	protected boolean inLoop_statement = false;

	@Override
	public void enterLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		onEnter(new Node("Loop_statement", arg.getText(), arg.getStart().getText()));
		this.inLoop_statement = true;
	}

	public void exitLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		onExit();
		this.inLoop_statement = false;
	}

	protected boolean inRepeat_statement = false;

	@Override
	public void enterRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		onEnter(new Node("Repeat_statement", arg.getText(), arg.getStart().getText()));
		this.inRepeat_statement = true;
	}

	public void exitRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		onExit();
		this.inRepeat_statement = false;
	}

	protected boolean inReturn_statement = false;

	@Override
	public void enterReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		onEnter(new Node("Return_statement", arg.getText(), arg.getStart().getText()));
		this.inReturn_statement = true;
	}

	public void exitReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		onExit();
		this.inReturn_statement = false;
	}

	protected boolean inWhile_statement = false;

	@Override
	public void enterWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		onEnter(new Node("While_statement", arg.getText(), arg.getStart().getText()));
		this.inWhile_statement = true;
	}

	public void exitWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		onExit();
		this.inWhile_statement = false;
	}

	protected boolean inCursor_statement = false;

	@Override
	public void enterCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		onEnter(new Node("Cursor_statement", arg.getText(), arg.getStart().getText()));
		this.inCursor_statement = true;
	}

	public void exitCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		onExit();
		this.inCursor_statement = false;
	}

	protected boolean inDeclare_variable = false;

	@Override
	public void enterDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		onEnter(new Node("Declare_variable", arg.getText(), arg.getStart().getText()));
		this.inDeclare_variable = true;
	}

	public void exitDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		onExit();
		this.inDeclare_variable = false;
	}

	protected boolean inDeclare_condition = false;

	@Override
	public void enterDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		onEnter(new Node("Declare_condition", arg.getText(), arg.getStart().getText()));
		this.inDeclare_condition = true;
	}

	public void exitDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		onExit();
		this.inDeclare_condition = false;
	}

	protected boolean inDeclare_cursor = false;

	@Override
	public void enterDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		onEnter(new Node("Declare_cursor", arg.getText(), arg.getStart().getText()));
		this.inDeclare_cursor = true;
	}

	public void exitDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		onExit();
		this.inDeclare_cursor = false;
	}

	protected boolean inDeclare_handler = false;

	@Override
	public void enterDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		onEnter(new Node("Declare_handler", arg.getText(), arg.getStart().getText()));
		this.inDeclare_handler = true;
	}

	public void exitDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		onExit();
		this.inDeclare_handler = false;
	}

	protected boolean inHandler_condition_value = false;

	@Override
	public void enterHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		onEnter(new Node("Handler_condition_value", arg.getText(), arg.getStart().getText()));
		this.inHandler_condition_value = true;
	}

	public void exitHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		onExit();
		this.inHandler_condition_value = false;
	}

	protected boolean inProcedure_sql_statement = false;

	@Override
	public void enterProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		onEnter(new Node("Procedure_sql_statement", arg.getText(), arg.getStart().getText()));
		this.inProcedure_sql_statement = true;
	}

	public void exitProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		onExit();
		this.inProcedure_sql_statement = false;
	}

	protected boolean inAlterUserMysql56 = false;

	@Override
	public void enterAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		onEnter(new Node("AlterUserMysql56", arg.getText(), arg.getStart().getText()));
		this.inAlterUserMysql56 = true;
	}

	public void exitAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		onExit();
		this.inAlterUserMysql56 = false;
	}

	protected boolean inAlterUserMysql57 = false;

	@Override
	public void enterAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		onEnter(new Node("AlterUserMysql57", arg.getText(), arg.getStart().getText()));
		this.inAlterUserMysql57 = true;
	}

	public void exitAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		onExit();
		this.inAlterUserMysql57 = false;
	}

	protected boolean inCreateUserMysql56 = false;

	@Override
	public void enterCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		onEnter(new Node("CreateUserMysql56", arg.getText(), arg.getStart().getText()));
		this.inCreateUserMysql56 = true;
	}

	public void exitCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		onExit();
		this.inCreateUserMysql56 = false;
	}

	protected boolean inCreateUserMysql57 = false;

	@Override
	public void enterCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		onEnter(new Node("CreateUserMysql57", arg.getText(), arg.getStart().getText()));
		this.inCreateUserMysql57 = true;
	}

	public void exitCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		onExit();
		this.inCreateUserMysql57 = false;
	}

	protected boolean inDrop_user = false;

	@Override
	public void enterDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		onEnter(new Node("Drop_user", arg.getText(), arg.getStart().getText()));
		this.inDrop_user = true;
	}

	public void exitDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		onExit();
		this.inDrop_user = false;
	}

	protected boolean inGrant_statement = false;

	@Override
	public void enterGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		onEnter(new Node("Grant_statement", arg.getText(), arg.getStart().getText()));
		this.inGrant_statement = true;
	}

	public void exitGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		onExit();
		this.inGrant_statement = false;
	}

	protected boolean inGrant_proxy = false;

	@Override
	public void enterGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		onEnter(new Node("Grant_proxy", arg.getText(), arg.getStart().getText()));
		this.inGrant_proxy = true;
	}

	public void exitGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		onExit();
		this.inGrant_proxy = false;
	}

	protected boolean inRename_user = false;

	@Override
	public void enterRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		onEnter(new Node("Rename_user", arg.getText(), arg.getStart().getText()));
		this.inRename_user = true;
	}

	public void exitRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		onExit();
		this.inRename_user = false;
	}

	protected boolean inDetailRevoke = false;

	@Override
	public void enterDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		onEnter(new Node("DetailRevoke", arg.getText(), arg.getStart().getText()));
		this.inDetailRevoke = true;
	}

	public void exitDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		onExit();
		this.inDetailRevoke = false;
	}

	protected boolean inShortRevoke = false;

	@Override
	public void enterShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		onEnter(new Node("ShortRevoke", arg.getText(), arg.getStart().getText()));
		this.inShortRevoke = true;
	}

	public void exitShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		onExit();
		this.inShortRevoke = false;
	}

	protected boolean inRevoke_proxy = false;

	@Override
	public void enterRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		onEnter(new Node("Revoke_proxy", arg.getText(), arg.getStart().getText()));
		this.inRevoke_proxy = true;
	}

	public void exitRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		onExit();
		this.inRevoke_proxy = false;
	}

	protected boolean inSet_password_statement = false;

	@Override
	public void enterSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		onEnter(new Node("Set_password_statement", arg.getText(), arg.getStart().getText()));
		this.inSet_password_statement = true;
	}

	public void exitSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		onExit();
		this.inSet_password_statement = false;
	}

	protected boolean inUser_password_option = false;

	@Override
	public void enterUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		onEnter(new Node("User_password_option", arg.getText(), arg.getStart().getText()));
		this.inUser_password_option = true;
	}

	public void exitUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		onExit();
		this.inUser_password_option = false;
	}

	protected boolean inAuthByPassword = false;

	@Override
	public void enterAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		onEnter(new Node("AuthByPassword", arg.getText(), arg.getStart().getText()));
		this.inAuthByPassword = true;
	}

	public void exitAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		onExit();
		this.inAuthByPassword = false;
	}

	protected boolean inAuthByString = false;

	@Override
	public void enterAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		onEnter(new Node("AuthByString", arg.getText(), arg.getStart().getText()));
		this.inAuthByString = true;
	}

	public void exitAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		onExit();
		this.inAuthByString = false;
	}

	protected boolean inAuthByHash = false;

	@Override
	public void enterAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		onEnter(new Node("AuthByHash", arg.getText(), arg.getStart().getText()));
		this.inAuthByHash = true;
	}

	public void exitAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		onExit();
		this.inAuthByHash = false;
	}

	protected boolean inTls_option = false;

	@Override
	public void enterTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		onEnter(new Node("Tls_option", arg.getText(), arg.getStart().getText()));
		this.inTls_option = true;
	}

	public void exitTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		onExit();
		this.inTls_option = false;
	}

	protected boolean inUser_resource_option = false;

	@Override
	public void enterUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		onEnter(new Node("User_resource_option", arg.getText(), arg.getStart().getText()));
		this.inUser_resource_option = true;
	}

	public void exitUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		onExit();
		this.inUser_resource_option = false;
	}

	protected boolean inUser_lock_option = false;

	@Override
	public void enterUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		onEnter(new Node("User_lock_option", arg.getText(), arg.getStart().getText()));
		this.inUser_lock_option = true;
	}

	public void exitUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		onExit();
		this.inUser_lock_option = false;
	}

	protected boolean inPrivelege_clause = false;

	@Override
	public void enterPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		onEnter(new Node("Privelege_clause", arg.getText(), arg.getStart().getText()));
		this.inPrivelege_clause = true;
	}

	public void exitPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		onExit();
		this.inPrivelege_clause = false;
	}

	protected boolean inPrivilege = false;

	@Override
	public void enterPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		onEnter(new Node("Privilege", arg.getText(), arg.getStart().getText()));
		this.inPrivilege = true;
	}

	public void exitPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		onExit();
		this.inPrivilege = false;
	}

	protected boolean inPrivilege_level = false;

	@Override
	public void enterPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		onEnter(new Node("Privilege_level", arg.getText(), arg.getStart().getText()));
		this.inPrivilege_level = true;
	}

	public void exitPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		onExit();
		this.inPrivilege_level = false;
	}

	protected boolean inSet_password_option = false;

	@Override
	public void enterSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		onEnter(new Node("Set_password_option", arg.getText(), arg.getStart().getText()));
		this.inSet_password_option = true;
	}

	public void exitSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		onExit();
		this.inSet_password_option = false;
	}

	protected boolean inAnalyze_table = false;

	@Override
	public void enterAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		onEnter(new Node("Analyze_table", arg.getText(), arg.getStart().getText()));
		this.inAnalyze_table = true;
	}

	public void exitAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		onExit();
		this.inAnalyze_table = false;
	}

	protected boolean inCheck_table = false;

	@Override
	public void enterCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		onEnter(new Node("Check_table", arg.getText(), arg.getStart().getText()));
		this.inCheck_table = true;
	}

	public void exitCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		onExit();
		this.inCheck_table = false;
	}

	protected boolean inChecksum_table = false;

	@Override
	public void enterChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		onEnter(new Node("Checksum_table", arg.getText(), arg.getStart().getText()));
		this.inChecksum_table = true;
	}

	public void exitChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		onExit();
		this.inChecksum_table = false;
	}

	protected boolean inOptimize_table = false;

	@Override
	public void enterOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		onEnter(new Node("Optimize_table", arg.getText(), arg.getStart().getText()));
		this.inOptimize_table = true;
	}

	public void exitOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		onExit();
		this.inOptimize_table = false;
	}

	protected boolean inRepair_table = false;

	@Override
	public void enterRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		onEnter(new Node("Repair_table", arg.getText(), arg.getStart().getText()));
		this.inRepair_table = true;
	}

	public void exitRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		onExit();
		this.inRepair_table = false;
	}

	protected boolean inCheck_table_option = false;

	@Override
	public void enterCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		onEnter(new Node("Check_table_option", arg.getText(), arg.getStart().getText()));
		this.inCheck_table_option = true;
	}

	public void exitCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		onExit();
		this.inCheck_table_option = false;
	}

	protected boolean inCreate_udfunction = false;

	@Override
	public void enterCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		onEnter(new Node("Create_udfunction", arg.getText(), arg.getStart().getText()));
		this.inCreate_udfunction = true;
	}

	public void exitCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		onExit();
		this.inCreate_udfunction = false;
	}

	protected boolean inInstall_plugin = false;

	@Override
	public void enterInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		onEnter(new Node("Install_plugin", arg.getText(), arg.getStart().getText()));
		this.inInstall_plugin = true;
	}

	public void exitInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		onExit();
		this.inInstall_plugin = false;
	}

	protected boolean inUninstall_plugin = false;

	@Override
	public void enterUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		onEnter(new Node("Uninstall_plugin", arg.getText(), arg.getStart().getText()));
		this.inUninstall_plugin = true;
	}

	public void exitUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		onExit();
		this.inUninstall_plugin = false;
	}

	protected boolean inSetVariableAssignment = false;

	@Override
	public void enterSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		onEnter(new Node("SetVariableAssignment", arg.getText(), arg.getStart().getText()));
		this.inSetVariableAssignment = true;
	}

	public void exitSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		onExit();
		this.inSetVariableAssignment = false;
	}

	protected boolean inSetCharset = false;

	@Override
	public void enterSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		onEnter(new Node("SetCharset", arg.getText(), arg.getStart().getText()));
		this.inSetCharset = true;
	}

	public void exitSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		onExit();
		this.inSetCharset = false;
	}

	protected boolean inSetNames = false;

	@Override
	public void enterSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		onEnter(new Node("SetNames", arg.getText(), arg.getStart().getText()));
		this.inSetNames = true;
	}

	public void exitSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		onExit();
		this.inSetNames = false;
	}

	protected boolean inSetPasswordStatement = false;

	@Override
	public void enterSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		onEnter(new Node("SetPasswordStatement", arg.getText(), arg.getStart().getText()));
		this.inSetPasswordStatement = true;
	}

	public void exitSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		onExit();
		this.inSetPasswordStatement = false;
	}

	protected boolean inSetTransaction = false;

	@Override
	public void enterSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		onEnter(new Node("SetTransaction", arg.getText(), arg.getStart().getText()));
		this.inSetTransaction = true;
	}

	public void exitSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		onExit();
		this.inSetTransaction = false;
	}

	protected boolean inSetAutocommit = false;

	@Override
	public void enterSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		onEnter(new Node("SetAutocommit", arg.getText(), arg.getStart().getText()));
		this.inSetAutocommit = true;
	}

	public void exitSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		onExit();
		this.inSetAutocommit = false;
	}

	protected boolean inShowMasterlogs = false;

	@Override
	public void enterShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		onEnter(new Node("ShowMasterlogs", arg.getText(), arg.getStart().getText()));
		this.inShowMasterlogs = true;
	}

	public void exitShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		onExit();
		this.inShowMasterlogs = false;
	}

	protected boolean inShowLogevents = false;

	@Override
	public void enterShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		onEnter(new Node("ShowLogevents", arg.getText(), arg.getStart().getText()));
		this.inShowLogevents = true;
	}

	public void exitShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		onExit();
		this.inShowLogevents = false;
	}

	protected boolean inShowObjWithFilter = false;

	@Override
	public void enterShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		onEnter(new Node("ShowObjWithFilter", arg.getText(), arg.getStart().getText()));
		this.inShowObjWithFilter = true;
	}

	public void exitShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		onExit();
		this.inShowObjWithFilter = false;
	}

	protected boolean inShowColumns = false;

	@Override
	public void enterShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		onEnter(new Node("ShowColumns", arg.getText(), arg.getStart().getText()));
		this.inShowColumns = true;
	}

	public void exitShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		onExit();
		this.inShowColumns = false;
	}

	protected boolean inShowCreateDb = false;

	@Override
	public void enterShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		onEnter(new Node("ShowCreateDb", arg.getText(), arg.getStart().getText()));
		this.inShowCreateDb = true;
	}

	public void exitShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		onExit();
		this.inShowCreateDb = false;
	}

	protected boolean inShowCreateFullidobj = false;

	@Override
	public void enterShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		onEnter(new Node("ShowCreateFullidobj", arg.getText(), arg.getStart().getText()));
		this.inShowCreateFullidobj = true;
	}

	public void exitShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		onExit();
		this.inShowCreateFullidobj = false;
	}

	protected boolean inShowCreateUser = false;

	@Override
	public void enterShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		onEnter(new Node("ShowCreateUser", arg.getText(), arg.getStart().getText()));
		this.inShowCreateUser = true;
	}

	public void exitShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		onExit();
		this.inShowCreateUser = false;
	}

	protected boolean inShowEngine = false;

	@Override
	public void enterShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		onEnter(new Node("ShowEngine", arg.getText(), arg.getStart().getText()));
		this.inShowEngine = true;
	}

	public void exitShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		onExit();
		this.inShowEngine = false;
	}

	protected boolean inShowGlobalinfo = false;

	@Override
	public void enterShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		onEnter(new Node("ShowGlobalinfo", arg.getText(), arg.getStart().getText()));
		this.inShowGlobalinfo = true;
	}

	public void exitShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		onExit();
		this.inShowGlobalinfo = false;
	}

	protected boolean inShowErrWarn = false;

	@Override
	public void enterShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		onEnter(new Node("ShowErrWarn", arg.getText(), arg.getStart().getText()));
		this.inShowErrWarn = true;
	}

	public void exitShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		onExit();
		this.inShowErrWarn = false;
	}

	protected boolean inShowCountErrWarn = false;

	@Override
	public void enterShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		onEnter(new Node("ShowCountErrWarn", arg.getText(), arg.getStart().getText()));
		this.inShowCountErrWarn = true;
	}

	public void exitShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		onExit();
		this.inShowCountErrWarn = false;
	}

	protected boolean inShowFromschemaFilter = false;

	@Override
	public void enterShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		onEnter(new Node("ShowFromschemaFilter", arg.getText(), arg.getStart().getText()));
		this.inShowFromschemaFilter = true;
	}

	public void exitShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		onExit();
		this.inShowFromschemaFilter = false;
	}

	protected boolean inShowRoutinecode = false;

	@Override
	public void enterShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		onEnter(new Node("ShowRoutinecode", arg.getText(), arg.getStart().getText()));
		this.inShowRoutinecode = true;
	}

	public void exitShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		onExit();
		this.inShowRoutinecode = false;
	}

	protected boolean inShowGrants = false;

	@Override
	public void enterShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		onEnter(new Node("ShowGrants", arg.getText(), arg.getStart().getText()));
		this.inShowGrants = true;
	}

	public void exitShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		onExit();
		this.inShowGrants = false;
	}

	protected boolean inShowIndexes = false;

	@Override
	public void enterShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		onEnter(new Node("ShowIndexes", arg.getText(), arg.getStart().getText()));
		this.inShowIndexes = true;
	}

	public void exitShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		onExit();
		this.inShowIndexes = false;
	}

	protected boolean inShowOpentables = false;

	@Override
	public void enterShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		onEnter(new Node("ShowOpentables", arg.getText(), arg.getStart().getText()));
		this.inShowOpentables = true;
	}

	public void exitShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		onExit();
		this.inShowOpentables = false;
	}

	protected boolean inShowProfile = false;

	@Override
	public void enterShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		onEnter(new Node("ShowProfile", arg.getText(), arg.getStart().getText()));
		this.inShowProfile = true;
	}

	public void exitShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		onExit();
		this.inShowProfile = false;
	}

	protected boolean inShowSlavestatus = false;

	@Override
	public void enterShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		onEnter(new Node("ShowSlavestatus", arg.getText(), arg.getStart().getText()));
		this.inShowSlavestatus = true;
	}

	public void exitShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		onExit();
		this.inShowSlavestatus = false;
	}

	protected boolean inVariable_clause = false;

	@Override
	public void enterVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		onEnter(new Node("Variable_clause", arg.getText(), arg.getStart().getText()));
		this.inVariable_clause = true;
	}

	public void exitVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		onExit();
		this.inVariable_clause = false;
	}

	protected boolean inShow_filter = false;

	@Override
	public void enterShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		onEnter(new Node("Show_filter", arg.getText(), arg.getStart().getText()));
		this.inShow_filter = true;
	}

	public void exitShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		onExit();
		this.inShow_filter = false;
	}

	protected boolean inShow_profile_type = false;

	@Override
	public void enterShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		onEnter(new Node("Show_profile_type", arg.getText(), arg.getStart().getText()));
		this.inShow_profile_type = true;
	}

	public void exitShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		onExit();
		this.inShow_profile_type = false;
	}

	protected boolean inBinlog_statement = false;

	@Override
	public void enterBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		onEnter(new Node("Binlog_statement", arg.getText(), arg.getStart().getText()));
		this.inBinlog_statement = true;
	}

	public void exitBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		onExit();
		this.inBinlog_statement = false;
	}

	protected boolean inCache_index_statement = false;

	@Override
	public void enterCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		onEnter(new Node("Cache_index_statement", arg.getText(), arg.getStart().getText()));
		this.inCache_index_statement = true;
	}

	public void exitCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		onExit();
		this.inCache_index_statement = false;
	}

	protected boolean inFlush_statement = false;

	@Override
	public void enterFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		onEnter(new Node("Flush_statement", arg.getText(), arg.getStart().getText()));
		this.inFlush_statement = true;
	}

	public void exitFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		onExit();
		this.inFlush_statement = false;
	}

	protected boolean inKill_statement = false;

	@Override
	public void enterKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		onEnter(new Node("Kill_statement", arg.getText(), arg.getStart().getText()));
		this.inKill_statement = true;
	}

	public void exitKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		onExit();
		this.inKill_statement = false;
	}

	protected boolean inLoad_index_into_cache = false;

	@Override
	public void enterLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		onEnter(new Node("Load_index_into_cache", arg.getText(), arg.getStart().getText()));
		this.inLoad_index_into_cache = true;
	}

	public void exitLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		onExit();
		this.inLoad_index_into_cache = false;
	}

	protected boolean inReset_statement = false;

	@Override
	public void enterReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		onEnter(new Node("Reset_statement", arg.getText(), arg.getStart().getText()));
		this.inReset_statement = true;
	}

	public void exitReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		onExit();
		this.inReset_statement = false;
	}

	protected boolean inShutdown_statement = false;

	@Override
	public void enterShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		onEnter(new Node("Shutdown_statement", arg.getText(), arg.getStart().getText()));
		this.inShutdown_statement = true;
	}

	public void exitShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		onExit();
		this.inShutdown_statement = false;
	}

	protected boolean inTbl_index_list = false;

	@Override
	public void enterTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		onEnter(new Node("Tbl_index_list", arg.getText(), arg.getStart().getText()));
		this.inTbl_index_list = true;
	}

	public void exitTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		onExit();
		this.inTbl_index_list = false;
	}

	protected boolean inFlush_option = false;

	@Override
	public void enterFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		onEnter(new Node("Flush_option", arg.getText(), arg.getStart().getText()));
		this.inFlush_option = true;
	}

	public void exitFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		onExit();
		this.inFlush_option = false;
	}

	protected boolean inLoad_tbl_index_list = false;

	@Override
	public void enterLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		onEnter(new Node("Load_tbl_index_list", arg.getText(), arg.getStart().getText()));
		this.inLoad_tbl_index_list = true;
	}

	public void exitLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		onExit();
		this.inLoad_tbl_index_list = false;
	}

	protected boolean inSimple_describe_statement = false;

	@Override
	public void enterSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		onEnter(new Node("Simple_describe_statement", arg.getText(), arg.getStart().getText()));
		this.inSimple_describe_statement = true;
	}

	public void exitSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		onExit();
		this.inSimple_describe_statement = false;
	}

	protected boolean inFull_describe_statement = false;

	@Override
	public void enterFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		onEnter(new Node("Full_describe_statement", arg.getText(), arg.getStart().getText()));
		this.inFull_describe_statement = true;
	}

	public void exitFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		onExit();
		this.inFull_describe_statement = false;
	}

	protected boolean inHelp_statement = false;

	@Override
	public void enterHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		onEnter(new Node("Help_statement", arg.getText(), arg.getStart().getText()));
		this.inHelp_statement = true;
	}

	public void exitHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		onExit();
		this.inHelp_statement = false;
	}

	protected boolean inUse_statement = false;

	@Override
	public void enterUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		onEnter(new Node("Use_statement", arg.getText(), arg.getStart().getText()));
		this.inUse_statement = true;
	}

	public void exitUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		onExit();
		this.inUse_statement = false;
	}

	protected boolean inDescstmtDescObj = false;

	@Override
	public void enterDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		onEnter(new Node("DescstmtDescObj", arg.getText(), arg.getStart().getText()));
		this.inDescstmtDescObj = true;
	}

	public void exitDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		onExit();
		this.inDescstmtDescObj = false;
	}

	protected boolean inConnectionDescObj = false;

	@Override
	public void enterConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		onEnter(new Node("ConnectionDescObj", arg.getText(), arg.getStart().getText()));
		this.inConnectionDescObj = true;
	}

	public void exitConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		onExit();
		this.inConnectionDescObj = false;
	}

	protected boolean inTable_name = false;

	@Override
	public void enterTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		onEnter(new Node("Table_name", arg.getText(), arg.getStart().getText()));
		this.inTable_name = true;
	}

	public void exitTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		onExit();
		this.inTable_name = false;
	}

	protected boolean inFull_id = false;

	@Override
	public void enterFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		onEnter(new Node("Full_id", arg.getText(), arg.getStart().getText()));
		this.inFull_id = true;
	}

	public void exitFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		onExit();
		this.inFull_id = false;
	}

	protected boolean inFull_column_name = false;

	@Override
	public void enterFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		onEnter(new Node("Full_column_name", arg.getText(), arg.getStart().getText()));
		this.inFull_column_name = true;
	}

	public void exitFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		onExit();
		this.inFull_column_name = false;
	}

	protected boolean inIndex_col_name = false;

	@Override
	public void enterIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		onEnter(new Node("Index_col_name", arg.getText(), arg.getStart().getText()));
		this.inIndex_col_name = true;
	}

	public void exitIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		onExit();
		this.inIndex_col_name = false;
	}

	protected boolean inUser_name = false;

	@Override
	public void enterUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		onEnter(new Node("User_name", arg.getText(), arg.getStart().getText()));
		this.inUser_name = true;
	}

	public void exitUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		onExit();
		this.inUser_name = false;
	}

	protected boolean inMysql_variable = false;

	@Override
	public void enterMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		onEnter(new Node("Mysql_variable", arg.getText(), arg.getStart().getText()));
		this.inMysql_variable = true;
	}

	public void exitMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		onExit();
		this.inMysql_variable = false;
	}

	protected boolean inCharset_name = false;

	@Override
	public void enterCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		onEnter(new Node("Charset_name", arg.getText(), arg.getStart().getText()));
		this.inCharset_name = true;
	}

	public void exitCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		onExit();
		this.inCharset_name = false;
	}

	protected boolean inCollation_name = false;

	@Override
	public void enterCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		onEnter(new Node("Collation_name", arg.getText(), arg.getStart().getText()));
		this.inCollation_name = true;
	}

	public void exitCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		onExit();
		this.inCollation_name = false;
	}

	protected boolean inEngine_name = false;

	@Override
	public void enterEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		onEnter(new Node("Engine_name", arg.getText(), arg.getStart().getText()));
		this.inEngine_name = true;
	}

	public void exitEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		onExit();
		this.inEngine_name = false;
	}

	protected boolean inUuid_set = false;

	@Override
	public void enterUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		onEnter(new Node("Uuid_set", arg.getText(), arg.getStart().getText()));
		this.inUuid_set = true;
	}

	public void exitUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		onExit();
		this.inUuid_set = false;
	}

	protected boolean inXid = false;

	@Override
	public void enterXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		onEnter(new Node("Xid", arg.getText(), arg.getStart().getText()));
		this.inXid = true;
	}

	public void exitXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		onExit();
		this.inXid = false;
	}

	protected boolean inXid_string_id = false;

	@Override
	public void enterXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		onEnter(new Node("Xid_string_id", arg.getText(), arg.getStart().getText()));
		this.inXid_string_id = true;
	}

	public void exitXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		onExit();
		this.inXid_string_id = false;
	}

	protected boolean inAuth_plugin = false;

	@Override
	public void enterAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		onEnter(new Node("Auth_plugin", arg.getText(), arg.getStart().getText()));
		this.inAuth_plugin = true;
	}

	public void exitAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		onExit();
		this.inAuth_plugin = false;
	}

	protected boolean inId_ = false;

	@Override
	public void enterId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		onEnter(new Node("Id_", arg.getText(), arg.getStart().getText()));
		this.inId_ = true;
	}

	public void exitId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		onExit();
		this.inId_ = false;
	}

	protected boolean inSimple_id = false;

	@Override
	public void enterSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		onEnter(new Node("Simple_id", arg.getText(), arg.getStart().getText()));
		this.inSimple_id = true;
	}

	public void exitSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		onExit();
		this.inSimple_id = false;
	}

	protected boolean inDot_ext_id = false;

	@Override
	public void enterDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		onEnter(new Node("Dot_ext_id", arg.getText(), arg.getStart().getText()));
		this.inDot_ext_id = true;
	}

	public void exitDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		onExit();
		this.inDot_ext_id = false;
	}

	protected boolean inDecimal_literal = false;

	@Override
	public void enterDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		onEnter(new Node("Decimal_literal", arg.getText(), arg.getStart().getText()));
		this.inDecimal_literal = true;
	}

	public void exitDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		onExit();
		this.inDecimal_literal = false;
	}

	protected boolean inFilesize_literal = false;

	@Override
	public void enterFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		onEnter(new Node("Filesize_literal", arg.getText(), arg.getStart().getText()));
		this.inFilesize_literal = true;
	}

	public void exitFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		onExit();
		this.inFilesize_literal = false;
	}

	protected boolean inString_literal = false;

	@Override
	public void enterString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		onEnter(new Node("String_literal", arg.getText(), arg.getStart().getText()));
		this.inString_literal = true;
	}

	public void exitString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		onExit();
		this.inString_literal = false;
	}

	protected boolean inBoolean_literal = false;

	@Override
	public void enterBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		onEnter(new Node("Boolean_literal", arg.getText(), arg.getStart().getText()));
		this.inBoolean_literal = true;
	}

	public void exitBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		onExit();
		this.inBoolean_literal = false;
	}

	protected boolean inHexadecimal_literal = false;

	@Override
	public void enterHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		onEnter(new Node("Hexadecimal_literal", arg.getText(), arg.getStart().getText()));
		this.inHexadecimal_literal = true;
	}

	public void exitHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		onExit();
		this.inHexadecimal_literal = false;
	}

	protected boolean inNull_notnull = false;

	@Override
	public void enterNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		onEnter(new Node("Null_notnull", arg.getText(), arg.getStart().getText()));
		this.inNull_notnull = true;
	}

	public void exitNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		onExit();
		this.inNull_notnull = false;
	}

	protected boolean inConstant = false;

	@Override
	public void enterConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		onEnter(new Node("Constant", arg.getText(), arg.getStart().getText()));
		this.inConstant = true;
	}

	public void exitConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		onExit();
		this.inConstant = false;
	}

	protected boolean inCharDatatype = false;

	@Override
	public void enterCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		onEnter(new Node("CharDatatype", arg.getText(), arg.getStart().getText()));
		this.inCharDatatype = true;
	}

	public void exitCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		onExit();
		this.inCharDatatype = false;
	}

	protected boolean inDimensionDatatype = false;

	@Override
	public void enterDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		onEnter(new Node("DimensionDatatype", arg.getText(), arg.getStart().getText()));
		this.inDimensionDatatype = true;
	}

	public void exitDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		onExit();
		this.inDimensionDatatype = false;
	}

	protected boolean inSimpleDatatype = false;

	@Override
	public void enterSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		onEnter(new Node("SimpleDatatype", arg.getText(), arg.getStart().getText()));
		this.inSimpleDatatype = true;
	}

	public void exitSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		onExit();
		this.inSimpleDatatype = false;
	}

	protected boolean inCollectCharDatatype = false;

	@Override
	public void enterCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		onEnter(new Node("CollectCharDatatype", arg.getText(), arg.getStart().getText()));
		this.inCollectCharDatatype = true;
	}

	public void exitCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		onExit();
		this.inCollectCharDatatype = false;
	}

	protected boolean inSpatialDatatype = false;

	@Override
	public void enterSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		onEnter(new Node("SpatialDatatype", arg.getText(), arg.getStart().getText()));
		this.inSpatialDatatype = true;
	}

	public void exitSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		onExit();
		this.inSpatialDatatype = false;
	}

	protected boolean inData_type_to_convert = false;

	@Override
	public void enterData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		onEnter(new Node("Data_type_to_convert", arg.getText(), arg.getStart().getText()));
		this.inData_type_to_convert = true;
	}

	public void exitData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		onExit();
		this.inData_type_to_convert = false;
	}

	protected boolean inSpatial_data_type = false;

	@Override
	public void enterSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		onEnter(new Node("Spatial_data_type", arg.getText(), arg.getStart().getText()));
		this.inSpatial_data_type = true;
	}

	public void exitSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		onExit();
		this.inSpatial_data_type = false;
	}

	protected boolean inLength_one_dimension = false;

	@Override
	public void enterLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		onEnter(new Node("Length_one_dimension", arg.getText(), arg.getStart().getText()));
		this.inLength_one_dimension = true;
	}

	public void exitLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		onExit();
		this.inLength_one_dimension = false;
	}

	protected boolean inLength_two_dimension = false;

	@Override
	public void enterLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		onEnter(new Node("Length_two_dimension", arg.getText(), arg.getStart().getText()));
		this.inLength_two_dimension = true;
	}

	public void exitLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		onExit();
		this.inLength_two_dimension = false;
	}

	protected boolean inLength_two_optional_dimension = false;

	@Override
	public void enterLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		onEnter(new Node("Length_two_optional_dimension", arg.getText(), arg.getStart().getText()));
		this.inLength_two_optional_dimension = true;
	}

	public void exitLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		onExit();
		this.inLength_two_optional_dimension = false;
	}

	protected boolean inId_list = false;

	@Override
	public void enterId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		onEnter(new Node("Id_list", arg.getText(), arg.getStart().getText()));
		this.inId_list = true;
	}

	public void exitId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		onExit();
		this.inId_list = false;
	}

	protected boolean inTable_list = false;

	@Override
	public void enterTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		onEnter(new Node("Table_list", arg.getText(), arg.getStart().getText()));
		this.inTable_list = true;
	}

	public void exitTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		onExit();
		this.inTable_list = false;
	}

	protected boolean inTable_pair_list = false;

	@Override
	public void enterTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		onEnter(new Node("Table_pair_list", arg.getText(), arg.getStart().getText()));
		this.inTable_pair_list = true;
	}

	public void exitTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		onExit();
		this.inTable_pair_list = false;
	}

	protected boolean inIndex_colname_list = false;

	@Override
	public void enterIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		onEnter(new Node("Index_colname_list", arg.getText(), arg.getStart().getText()));
		this.inIndex_colname_list = true;
	}

	public void exitIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		onExit();
		this.inIndex_colname_list = false;
	}

	protected boolean inExpression_list = false;

	@Override
	public void enterExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		onEnter(new Node("Expression_list", arg.getText(), arg.getStart().getText()));
		this.inExpression_list = true;
	}

	public void exitExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		onExit();
		this.inExpression_list = false;
	}

	protected boolean inConstant_list = false;

	@Override
	public void enterConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		onEnter(new Node("Constant_list", arg.getText(), arg.getStart().getText()));
		this.inConstant_list = true;
	}

	public void exitConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		onExit();
		this.inConstant_list = false;
	}

	protected boolean inSimple_string_list = false;

	@Override
	public void enterSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		onEnter(new Node("Simple_string_list", arg.getText(), arg.getStart().getText()));
		this.inSimple_string_list = true;
	}

	public void exitSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		onExit();
		this.inSimple_string_list = false;
	}

	protected boolean inUser_var_list = false;

	@Override
	public void enterUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		onEnter(new Node("User_var_list", arg.getText(), arg.getStart().getText()));
		this.inUser_var_list = true;
	}

	public void exitUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		onExit();
		this.inUser_var_list = false;
	}

	protected boolean inDefault_value = false;

	@Override
	public void enterDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		onEnter(new Node("Default_value", arg.getText(), arg.getStart().getText()));
		this.inDefault_value = true;
	}

	public void exitDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		onExit();
		this.inDefault_value = false;
	}

	protected boolean inIf_exists = false;

	@Override
	public void enterIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		onEnter(new Node("If_exists", arg.getText(), arg.getStart().getText()));
		this.inIf_exists = true;
	}

	public void exitIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		onExit();
		this.inIf_exists = false;
	}

	protected boolean inIf_not_exists = false;

	@Override
	public void enterIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		onEnter(new Node("If_not_exists", arg.getText(), arg.getStart().getText()));
		this.inIf_not_exists = true;
	}

	public void exitIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		onExit();
		this.inIf_not_exists = false;
	}

	protected boolean inSpecificFunctionCall = false;

	@Override
	public void enterSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		onEnter(new Node("SpecificFunctionCall", arg.getText(), arg.getStart().getText()));
		this.inSpecificFunctionCall = true;
	}

	public void exitSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		onExit();
		this.inSpecificFunctionCall = false;
	}

	protected boolean inAggregateFunctionCall = false;

	@Override
	public void enterAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		onEnter(new Node("AggregateFunctionCall", arg.getText(), arg.getStart().getText()));
		this.inAggregateFunctionCall = true;
	}

	public void exitAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		onExit();
		this.inAggregateFunctionCall = false;
	}

	protected boolean inScalarFunctionCall = false;

	@Override
	public void enterScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		onEnter(new Node("ScalarFunctionCall", arg.getText(), arg.getStart().getText()));
		this.inScalarFunctionCall = true;
	}

	public void exitScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		onExit();
		this.inScalarFunctionCall = false;
	}

	protected boolean inUdfFunctionCall = false;

	@Override
	public void enterUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		onEnter(new Node("UdfFunctionCall", arg.getText(), arg.getStart().getText()));
		this.inUdfFunctionCall = true;
	}

	public void exitUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		onExit();
		this.inUdfFunctionCall = false;
	}

	protected boolean inSimpleSpecificFCall = false;

	@Override
	public void enterSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		onEnter(new Node("SimpleSpecificFCall", arg.getText(), arg.getStart().getText()));
		this.inSimpleSpecificFCall = true;
	}

	public void exitSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		onExit();
		this.inSimpleSpecificFCall = false;
	}

	protected boolean inConvertDataTypeFCall = false;

	@Override
	public void enterConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		onEnter(new Node("ConvertDataTypeFCall", arg.getText(), arg.getStart().getText()));
		this.inConvertDataTypeFCall = true;
	}

	public void exitConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		onExit();
		this.inConvertDataTypeFCall = false;
	}

	protected boolean inValuesFCall = false;

	@Override
	public void enterValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		onEnter(new Node("ValuesFCall", arg.getText(), arg.getStart().getText()));
		this.inValuesFCall = true;
	}

	public void exitValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		onExit();
		this.inValuesFCall = false;
	}

	protected boolean inCaseFCall = false;

	@Override
	public void enterCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		onEnter(new Node("CaseFCall", arg.getText(), arg.getStart().getText()));
		this.inCaseFCall = true;
	}

	public void exitCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		onExit();
		this.inCaseFCall = false;
	}

	protected boolean inCharFCall = false;

	@Override
	public void enterCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		onEnter(new Node("CharFCall", arg.getText(), arg.getStart().getText()));
		this.inCharFCall = true;
	}

	public void exitCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		onExit();
		this.inCharFCall = false;
	}

	protected boolean inPositionFCall = false;

	@Override
	public void enterPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		onEnter(new Node("PositionFCall", arg.getText(), arg.getStart().getText()));
		this.inPositionFCall = true;
	}

	public void exitPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		onExit();
		this.inPositionFCall = false;
	}

	protected boolean inSubstrFCall = false;

	@Override
	public void enterSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		onEnter(new Node("SubstrFCall", arg.getText(), arg.getStart().getText()));
		this.inSubstrFCall = true;
	}

	public void exitSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		onExit();
		this.inSubstrFCall = false;
	}

	protected boolean inTrimFCall = false;

	@Override
	public void enterTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		onEnter(new Node("TrimFCall", arg.getText(), arg.getStart().getText()));
		this.inTrimFCall = true;
	}

	public void exitTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		onExit();
		this.inTrimFCall = false;
	}

	protected boolean inWeightFCall = false;

	@Override
	public void enterWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		onEnter(new Node("WeightFCall", arg.getText(), arg.getStart().getText()));
		this.inWeightFCall = true;
	}

	public void exitWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		onExit();
		this.inWeightFCall = false;
	}

	protected boolean inExtractFCall = false;

	@Override
	public void enterExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		onEnter(new Node("ExtractFCall", arg.getText(), arg.getStart().getText()));
		this.inExtractFCall = true;
	}

	public void exitExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		onExit();
		this.inExtractFCall = false;
	}

	protected boolean inGetFormatFCall = false;

	@Override
	public void enterGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		onEnter(new Node("GetFormatFCall", arg.getText(), arg.getStart().getText()));
		this.inGetFormatFCall = true;
	}

	public void exitGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		onExit();
		this.inGetFormatFCall = false;
	}

	protected boolean inLevelWeightFList = false;

	@Override
	public void enterLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		onEnter(new Node("LevelWeightFList", arg.getText(), arg.getStart().getText()));
		this.inLevelWeightFList = true;
	}

	public void exitLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		onExit();
		this.inLevelWeightFList = false;
	}

	protected boolean inLevelWeightFRange = false;

	@Override
	public void enterLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		onEnter(new Node("LevelWeightFRange", arg.getText(), arg.getStart().getText()));
		this.inLevelWeightFRange = true;
	}

	public void exitLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		onExit();
		this.inLevelWeightFRange = false;
	}

	protected boolean inAggregate_windowed_function = false;

	@Override
	public void enterAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		onEnter(new Node("Aggregate_windowed_function", arg.getText(), arg.getStart().getText()));
		this.inAggregate_windowed_function = true;
	}

	public void exitAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		onExit();
		this.inAggregate_windowed_function = false;
	}

	protected boolean inScalar_function_name = false;

	@Override
	public void enterScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		onEnter(new Node("Scalar_function_name", arg.getText(), arg.getStart().getText()));
		this.inScalar_function_name = true;
	}

	public void exitScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		onExit();
		this.inScalar_function_name = false;
	}

	protected boolean inFunction_args = false;

	@Override
	public void enterFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		onEnter(new Node("Function_args", arg.getText(), arg.getStart().getText()));
		this.inFunction_args = true;
	}

	public void exitFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		onExit();
		this.inFunction_args = false;
	}

	protected boolean inFunction_arg = false;

	@Override
	public void enterFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		onEnter(new Node("Function_arg", arg.getText(), arg.getStart().getText()));
		this.inFunction_arg = true;
	}

	public void exitFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		onExit();
		this.inFunction_arg = false;
	}

	protected boolean inIsExpression = false;

	@Override
	public void enterIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		onEnter(new Node("IsExpression", arg.getText(), arg.getStart().getText()));
		this.inIsExpression = true;
	}

	public void exitIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		onExit();
		this.inIsExpression = false;
	}

	protected boolean inLogicalExpression = false;

	@Override
	public void enterLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		onEnter(new Node("LogicalExpression", arg.getText(), arg.getStart().getText()));
		this.inLogicalExpression = true;
	}

	public void exitLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		onExit();
		this.inLogicalExpression = false;
	}

	protected boolean inPredicateExpression = false;

	@Override
	public void enterPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		onEnter(new Node("PredicateExpression", arg.getText(), arg.getStart().getText()));
		this.inPredicateExpression = true;
	}

	public void exitPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		onExit();
		this.inPredicateExpression = false;
	}

	protected boolean inSoundsLikePredicate = false;

	@Override
	public void enterSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		onEnter(new Node("SoundsLikePredicate", arg.getText(), arg.getStart().getText()));
		this.inSoundsLikePredicate = true;
	}

	public void exitSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		onExit();
		this.inSoundsLikePredicate = false;
	}

	protected boolean inExpressionAtomPredicate = false;

	@Override
	public void enterExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		onEnter(new Node("ExpressionAtomPredicate", arg.getText(), arg.getStart().getText()));
		this.inExpressionAtomPredicate = true;
	}

	public void exitExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		onExit();
		this.inExpressionAtomPredicate = false;
	}

	protected boolean inInPredicate = false;

	@Override
	public void enterInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		onEnter(new Node("InPredicate", arg.getText(), arg.getStart().getText()));
		this.inInPredicate = true;
	}

	public void exitInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		onExit();
		this.inInPredicate = false;
	}

	protected boolean inSubqueryComparasionPredicate = false;

	@Override
	public void enterSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		onEnter(new Node("SubqueryComparasionPredicate", arg.getText(), arg.getStart().getText()));
		this.inSubqueryComparasionPredicate = true;
	}

	public void exitSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		onExit();
		this.inSubqueryComparasionPredicate = false;
	}

	protected boolean inBetweenPredicate = false;

	@Override
	public void enterBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		onEnter(new Node("BetweenPredicate", arg.getText(), arg.getStart().getText()));
		this.inBetweenPredicate = true;
	}

	public void exitBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		onExit();
		this.inBetweenPredicate = false;
	}

	protected boolean inBinaryComparasionPredicate = false;

	@Override
	public void enterBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		onEnter(new Node("BinaryComparasionPredicate", arg.getText(), arg.getStart().getText()));
		this.inBinaryComparasionPredicate = true;
	}

	public void exitBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		onExit();
		this.inBinaryComparasionPredicate = false;
	}

	protected boolean inIsNullPredicate = false;

	@Override
	public void enterIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		onEnter(new Node("IsNullPredicate", arg.getText(), arg.getStart().getText()));
		this.inIsNullPredicate = true;
	}

	public void exitIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		onExit();
		this.inIsNullPredicate = false;
	}

	protected boolean inLikePredicate = false;

	@Override
	public void enterLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		onEnter(new Node("LikePredicate", arg.getText(), arg.getStart().getText()));
		this.inLikePredicate = true;
	}

	public void exitLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		onExit();
		this.inLikePredicate = false;
	}

	protected boolean inRegexpPredicate = false;

	@Override
	public void enterRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		onEnter(new Node("RegexpPredicate", arg.getText(), arg.getStart().getText()));
		this.inRegexpPredicate = true;
	}

	public void exitRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		onExit();
		this.inRegexpPredicate = false;
	}

	protected boolean inUnaryExpressionAtom = false;

	@Override
	public void enterUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		onEnter(new Node("UnaryExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inUnaryExpressionAtom = true;
	}

	public void exitUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		onExit();
		this.inUnaryExpressionAtom = false;
	}

	protected boolean inExistsExpessionAtom = false;

	@Override
	public void enterExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		onEnter(new Node("ExistsExpessionAtom", arg.getText(), arg.getStart().getText()));
		this.inExistsExpessionAtom = true;
	}

	public void exitExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		onExit();
		this.inExistsExpessionAtom = false;
	}

	protected boolean inConstantExpressionAtom = false;

	@Override
	public void enterConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		onEnter(new Node("ConstantExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inConstantExpressionAtom = true;
	}

	public void exitConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		onExit();
		this.inConstantExpressionAtom = false;
	}

	protected boolean inFunctionCallExpressionAtom = false;

	@Override
	public void enterFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		onEnter(new Node("FunctionCallExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inFunctionCallExpressionAtom = true;
	}

	public void exitFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		onExit();
		this.inFunctionCallExpressionAtom = false;
	}

	protected boolean inMysqlVariableExpressionAtom = false;

	@Override
	public void enterMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		onEnter(new Node("MysqlVariableExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inMysqlVariableExpressionAtom = true;
	}

	public void exitMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		onExit();
		this.inMysqlVariableExpressionAtom = false;
	}

	protected boolean inBinaryExpressionAtom = false;

	@Override
	public void enterBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		onEnter(new Node("BinaryExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inBinaryExpressionAtom = true;
	}

	public void exitBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		onExit();
		this.inBinaryExpressionAtom = false;
	}

	protected boolean inFullColumnNameExpressionAtom = false;

	@Override
	public void enterFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		onEnter(new Node("FullColumnNameExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inFullColumnNameExpressionAtom = true;
	}

	public void exitFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		onExit();
		this.inFullColumnNameExpressionAtom = false;
	}

	protected boolean inDefaultExpressionAtom = false;

	@Override
	public void enterDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		onEnter(new Node("DefaultExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inDefaultExpressionAtom = true;
	}

	public void exitDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		onExit();
		this.inDefaultExpressionAtom = false;
	}

	protected boolean inBitExpressionAtom = false;

	@Override
	public void enterBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		onEnter(new Node("BitExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inBitExpressionAtom = true;
	}

	public void exitBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		onExit();
		this.inBitExpressionAtom = false;
	}

	protected boolean inNestedExpressionAtom = false;

	@Override
	public void enterNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		onEnter(new Node("NestedExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inNestedExpressionAtom = true;
	}

	public void exitNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		onExit();
		this.inNestedExpressionAtom = false;
	}

	protected boolean inMathExpressionAtom = false;

	@Override
	public void enterMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		onEnter(new Node("MathExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inMathExpressionAtom = true;
	}

	public void exitMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		onExit();
		this.inMathExpressionAtom = false;
	}

	protected boolean inIntervalExpressionAtom = false;

	@Override
	public void enterIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		onEnter(new Node("IntervalExpressionAtom", arg.getText(), arg.getStart().getText()));
		this.inIntervalExpressionAtom = true;
	}

	public void exitIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		onExit();
		this.inIntervalExpressionAtom = false;
	}

	protected boolean inUnary_operator = false;

	@Override
	public void enterUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		onEnter(new Node("Unary_operator", arg.getText(), arg.getStart().getText()));
		this.inUnary_operator = true;
	}

	public void exitUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		onExit();
		this.inUnary_operator = false;
	}

	protected boolean inComparison_operator = false;

	@Override
	public void enterComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		onEnter(new Node("Comparison_operator", arg.getText(), arg.getStart().getText()));
		this.inComparison_operator = true;
	}

	public void exitComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		onExit();
		this.inComparison_operator = false;
	}

	protected boolean inLogical_operator = false;

	@Override
	public void enterLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		onEnter(new Node("Logical_operator", arg.getText(), arg.getStart().getText()));
		this.inLogical_operator = true;
	}

	public void exitLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		onExit();
		this.inLogical_operator = false;
	}

	protected boolean inBit_operator = false;

	@Override
	public void enterBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		onEnter(new Node("Bit_operator", arg.getText(), arg.getStart().getText()));
		this.inBit_operator = true;
	}

	public void exitBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		onExit();
		this.inBit_operator = false;
	}

	protected boolean inMath_operator = false;

	@Override
	public void enterMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		onEnter(new Node("Math_operator", arg.getText(), arg.getStart().getText()));
		this.inMath_operator = true;
	}

	public void exitMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		onExit();
		this.inMath_operator = false;
	}

	protected boolean inCharset_name_base = false;

	@Override
	public void enterCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		onEnter(new Node("Charset_name_base", arg.getText(), arg.getStart().getText()));
		this.inCharset_name_base = true;
	}

	public void exitCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		onExit();
		this.inCharset_name_base = false;
	}

	protected boolean inTransaction_level_base = false;

	@Override
	public void enterTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		onEnter(new Node("Transaction_level_base", arg.getText(), arg.getStart().getText()));
		this.inTransaction_level_base = true;
	}

	public void exitTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		onExit();
		this.inTransaction_level_base = false;
	}

	protected boolean inPrivileges_base = false;

	@Override
	public void enterPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		onEnter(new Node("Privileges_base", arg.getText(), arg.getStart().getText()));
		this.inPrivileges_base = true;
	}

	public void exitPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		onExit();
		this.inPrivileges_base = false;
	}

	protected boolean inInterval_type_base = false;

	@Override
	public void enterInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		onEnter(new Node("Interval_type_base", arg.getText(), arg.getStart().getText()));
		this.inInterval_type_base = true;
	}

	public void exitInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		onExit();
		this.inInterval_type_base = false;
	}

	protected boolean inData_type_base = false;

	@Override
	public void enterData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		onEnter(new Node("Data_type_base", arg.getText(), arg.getStart().getText()));
		this.inData_type_base = true;
	}

	public void exitData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		onExit();
		this.inData_type_base = false;
	}

	protected boolean inKeywords_can_be_id = false;

	@Override
	public void enterKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		onEnter(new Node("Keywords_can_be_id", arg.getText(), arg.getStart().getText()));
		this.inKeywords_can_be_id = true;
	}

	public void exitKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		onExit();
		this.inKeywords_can_be_id = false;
	}

	protected boolean inFunction_name_base = false;

	@Override
	public void enterFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		onEnter(new Node("Function_name_base", arg.getText(), arg.getStart().getText()));
		this.inFunction_name_base = true;
	}

	public void exitFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		onExit();
		this.inFunction_name_base = false;
	}

}