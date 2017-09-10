package com.generator.generators.mysql.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class MySqlParserNeoListener extends MySqlParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public MySqlParserNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public MySqlParserNeoListener(com.generator.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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
		final Node node = model.findOrCreate(Label.label("NotExpression"), "text", arg.getText());
		onEnter(node);
		this.inNotExpression = true;
	}

	public void exitNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		onExit();
		this.inNotExpression = false;
	}

	protected boolean inRoot = false;

	@Override
	public void enterRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		final Node node = model.findOrCreate(Label.label("Root"), "text", arg.getText());
		onEnter(node);
		this.inRoot = true;
	}

	public void exitRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		onExit();
		this.inRoot = false;
	}

	protected boolean inSql_statements = false;

	@Override
	public void enterSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		final Node node = model.findOrCreate(Label.label("Sql_statements"), "text", arg.getText());
		onEnter(node);
		this.inSql_statements = true;
	}

	public void exitSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		onExit();
		this.inSql_statements = false;
	}

	protected boolean inSql_statement = false;

	@Override
	public void enterSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Sql_statement"), "text", arg.getText());
		onEnter(node);
		this.inSql_statement = true;
	}

	public void exitSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		onExit();
		this.inSql_statement = false;
	}

	protected boolean inEmpty_statement = false;

	@Override
	public void enterEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Empty_statement"), "text", arg.getText());
		onEnter(node);
		this.inEmpty_statement = true;
	}

	public void exitEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		onExit();
		this.inEmpty_statement = false;
	}

	protected boolean inDdl_statement = false;

	@Override
	public void enterDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Ddl_statement"), "text", arg.getText());
		onEnter(node);
		this.inDdl_statement = true;
	}

	public void exitDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		onExit();
		this.inDdl_statement = false;
	}

	protected boolean inDml_statement = false;

	@Override
	public void enterDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Dml_statement"), "text", arg.getText());
		onEnter(node);
		this.inDml_statement = true;
	}

	public void exitDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		onExit();
		this.inDml_statement = false;
	}

	protected boolean inTransaction_statement = false;

	@Override
	public void enterTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Transaction_statement"), "text", arg.getText());
		onEnter(node);
		this.inTransaction_statement = true;
	}

	public void exitTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		onExit();
		this.inTransaction_statement = false;
	}

	protected boolean inReplication_statement = false;

	@Override
	public void enterReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Replication_statement"), "text", arg.getText());
		onEnter(node);
		this.inReplication_statement = true;
	}

	public void exitReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		onExit();
		this.inReplication_statement = false;
	}

	protected boolean inPrepared_statement = false;

	@Override
	public void enterPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Prepared_statement"), "text", arg.getText());
		onEnter(node);
		this.inPrepared_statement = true;
	}

	public void exitPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		onExit();
		this.inPrepared_statement = false;
	}

	protected boolean inCompound_statement = false;

	@Override
	public void enterCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Compound_statement"), "text", arg.getText());
		onEnter(node);
		this.inCompound_statement = true;
	}

	public void exitCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		onExit();
		this.inCompound_statement = false;
	}

	protected boolean inAdministration_statement = false;

	@Override
	public void enterAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Administration_statement"), "text", arg.getText());
		onEnter(node);
		this.inAdministration_statement = true;
	}

	public void exitAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		onExit();
		this.inAdministration_statement = false;
	}

	protected boolean inUtility_statement = false;

	@Override
	public void enterUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Utility_statement"), "text", arg.getText());
		onEnter(node);
		this.inUtility_statement = true;
	}

	public void exitUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		onExit();
		this.inUtility_statement = false;
	}

	protected boolean inCreate_database = false;

	@Override
	public void enterCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_database"), "text", arg.getText());
		onEnter(node);
		this.inCreate_database = true;
	}

	public void exitCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		onExit();
		this.inCreate_database = false;
	}

	protected boolean inCreate_event = false;

	@Override
	public void enterCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_event"), "text", arg.getText());
		onEnter(node);
		this.inCreate_event = true;
	}

	public void exitCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		onExit();
		this.inCreate_event = false;
	}

	protected boolean inCreate_index = false;

	@Override
	public void enterCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_index"), "text", arg.getText());
		onEnter(node);
		this.inCreate_index = true;
	}

	public void exitCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		onExit();
		this.inCreate_index = false;
	}

	protected boolean inCreate_logfile_group = false;

	@Override
	public void enterCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_logfile_group"), "text", arg.getText());
		onEnter(node);
		this.inCreate_logfile_group = true;
	}

	public void exitCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		onExit();
		this.inCreate_logfile_group = false;
	}

	protected boolean inCreate_procedure = false;

	@Override
	public void enterCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_procedure"), "text", arg.getText());
		onEnter(node);
		this.inCreate_procedure = true;
	}

	public void exitCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		onExit();
		this.inCreate_procedure = false;
	}

	protected boolean inCreate_function = false;

	@Override
	public void enterCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_function"), "text", arg.getText());
		onEnter(node);
		this.inCreate_function = true;
	}

	public void exitCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		onExit();
		this.inCreate_function = false;
	}

	protected boolean inCreate_server = false;

	@Override
	public void enterCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_server"), "text", arg.getText());
		onEnter(node);
		this.inCreate_server = true;
	}

	public void exitCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		onExit();
		this.inCreate_server = false;
	}

	protected boolean inCopyCreateTable = false;

	@Override
	public void enterCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		final Node node = model.findOrCreate(Label.label("CopyCreateTable"), "text", arg.getText());
		onEnter(node);
		this.inCopyCreateTable = true;
	}

	public void exitCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		onExit();
		this.inCopyCreateTable = false;
	}

	protected boolean inQueryCreateTable = false;

	@Override
	public void enterQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		final Node node = model.findOrCreate(Label.label("QueryCreateTable"), "text", arg.getText());
		onEnter(node);
		this.inQueryCreateTable = true;
	}

	public void exitQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		onExit();
		this.inQueryCreateTable = false;
	}

	protected boolean inColCreateTable = false;

	@Override
	public void enterColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		final Node node = model.findOrCreate(Label.label("ColCreateTable"), "text", arg.getText());
		onEnter(node);
		this.inColCreateTable = true;
	}

	public void exitColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		onExit();
		this.inColCreateTable = false;
	}

	protected boolean inCreate_tablespace_innodb = false;

	@Override
	public void enterCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_tablespace_innodb"), "text", arg.getText());
		onEnter(node);
		this.inCreate_tablespace_innodb = true;
	}

	public void exitCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		onExit();
		this.inCreate_tablespace_innodb = false;
	}

	protected boolean inCreate_tablespace_ndb = false;

	@Override
	public void enterCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_tablespace_ndb"), "text", arg.getText());
		onEnter(node);
		this.inCreate_tablespace_ndb = true;
	}

	public void exitCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		onExit();
		this.inCreate_tablespace_ndb = false;
	}

	protected boolean inCreate_trigger = false;

	@Override
	public void enterCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_trigger"), "text", arg.getText());
		onEnter(node);
		this.inCreate_trigger = true;
	}

	public void exitCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		onExit();
		this.inCreate_trigger = false;
	}

	protected boolean inCreate_view = false;

	@Override
	public void enterCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_view"), "text", arg.getText());
		onEnter(node);
		this.inCreate_view = true;
	}

	public void exitCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		onExit();
		this.inCreate_view = false;
	}

	protected boolean inCreate_database_option = false;

	@Override
	public void enterCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_database_option"), "text", arg.getText());
		onEnter(node);
		this.inCreate_database_option = true;
	}

	public void exitCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		onExit();
		this.inCreate_database_option = false;
	}

	protected boolean inOwner_statement = false;

	@Override
	public void enterOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Owner_statement"), "text", arg.getText());
		onEnter(node);
		this.inOwner_statement = true;
	}

	public void exitOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		onExit();
		this.inOwner_statement = false;
	}

	protected boolean inPreciseSchedule = false;

	@Override
	public void enterPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		final Node node = model.findOrCreate(Label.label("PreciseSchedule"), "text", arg.getText());
		onEnter(node);
		this.inPreciseSchedule = true;
	}

	public void exitPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		onExit();
		this.inPreciseSchedule = false;
	}

	protected boolean inIntervalSchedule = false;

	@Override
	public void enterIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		final Node node = model.findOrCreate(Label.label("IntervalSchedule"), "text", arg.getText());
		onEnter(node);
		this.inIntervalSchedule = true;
	}

	public void exitIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		onExit();
		this.inIntervalSchedule = false;
	}

	protected boolean inTimestamp_value = false;

	@Override
	public void enterTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		final Node node = model.findOrCreate(Label.label("Timestamp_value"), "text", arg.getText());
		onEnter(node);
		this.inTimestamp_value = true;
	}

	public void exitTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		onExit();
		this.inTimestamp_value = false;
	}

	protected boolean inInterval_expr = false;

	@Override
	public void enterInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		final Node node = model.findOrCreate(Label.label("Interval_expr"), "text", arg.getText());
		onEnter(node);
		this.inInterval_expr = true;
	}

	public void exitInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		onExit();
		this.inInterval_expr = false;
	}

	protected boolean inInterval_type = false;

	@Override
	public void enterInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		final Node node = model.findOrCreate(Label.label("Interval_type"), "text", arg.getText());
		onEnter(node);
		this.inInterval_type = true;
	}

	public void exitInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		onExit();
		this.inInterval_type = false;
	}

	protected boolean inIndex_type = false;

	@Override
	public void enterIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		final Node node = model.findOrCreate(Label.label("Index_type"), "text", arg.getText());
		onEnter(node);
		this.inIndex_type = true;
	}

	public void exitIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		onExit();
		this.inIndex_type = false;
	}

	protected boolean inIndex_option = false;

	@Override
	public void enterIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Index_option"), "text", arg.getText());
		onEnter(node);
		this.inIndex_option = true;
	}

	public void exitIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		onExit();
		this.inIndex_option = false;
	}

	protected boolean inProc_param = false;

	@Override
	public void enterProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		final Node node = model.findOrCreate(Label.label("Proc_param"), "text", arg.getText());
		onEnter(node);
		this.inProc_param = true;
	}

	public void exitProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		onExit();
		this.inProc_param = false;
	}

	protected boolean inFunc_param = false;

	@Override
	public void enterFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		final Node node = model.findOrCreate(Label.label("Func_param"), "text", arg.getText());
		onEnter(node);
		this.inFunc_param = true;
	}

	public void exitFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		onExit();
		this.inFunc_param = false;
	}

	protected boolean inRcComment = false;

	@Override
	public void enterRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		final Node node = model.findOrCreate(Label.label("RcComment"), "text", arg.getText());
		onEnter(node);
		this.inRcComment = true;
	}

	public void exitRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		onExit();
		this.inRcComment = false;
	}

	protected boolean inRcSqllang = false;

	@Override
	public void enterRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		final Node node = model.findOrCreate(Label.label("RcSqllang"), "text", arg.getText());
		onEnter(node);
		this.inRcSqllang = true;
	}

	public void exitRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		onExit();
		this.inRcSqllang = false;
	}

	protected boolean inRcDeterm = false;

	@Override
	public void enterRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		final Node node = model.findOrCreate(Label.label("RcDeterm"), "text", arg.getText());
		onEnter(node);
		this.inRcDeterm = true;
	}

	public void exitRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		onExit();
		this.inRcDeterm = false;
	}

	protected boolean inRcSqldata = false;

	@Override
	public void enterRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		final Node node = model.findOrCreate(Label.label("RcSqldata"), "text", arg.getText());
		onEnter(node);
		this.inRcSqldata = true;
	}

	public void exitRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		onExit();
		this.inRcSqldata = false;
	}

	protected boolean inRcSecurestmt = false;

	@Override
	public void enterRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		final Node node = model.findOrCreate(Label.label("RcSecurestmt"), "text", arg.getText());
		onEnter(node);
		this.inRcSecurestmt = true;
	}

	public void exitRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		onExit();
		this.inRcSecurestmt = false;
	}

	protected boolean inServer_option = false;

	@Override
	public void enterServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Server_option"), "text", arg.getText());
		onEnter(node);
		this.inServer_option = true;
	}

	public void exitServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		onExit();
		this.inServer_option = false;
	}

	protected boolean inColumn_def_table_constraints = false;

	@Override
	public void enterColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		final Node node = model.findOrCreate(Label.label("Column_def_table_constraints"), "text", arg.getText());
		onEnter(node);
		this.inColumn_def_table_constraints = true;
	}

	public void exitColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		onExit();
		this.inColumn_def_table_constraints = false;
	}

	protected boolean inColumnDefinition = false;

	@Override
	public void enterColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("ColumnDefinition"), "text", arg.getText());
		onEnter(node);
		this.inColumnDefinition = true;
	}

	public void exitColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		onExit();
		this.inColumnDefinition = false;
	}

	protected boolean inConstraintDefinition = false;

	@Override
	public void enterConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstraintDefinition"), "text", arg.getText());
		onEnter(node);
		this.inConstraintDefinition = true;
	}

	public void exitConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		onExit();
		this.inConstraintDefinition = false;
	}

	protected boolean inIndexDefinition = false;

	@Override
	public void enterIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("IndexDefinition"), "text", arg.getText());
		onEnter(node);
		this.inIndexDefinition = true;
	}

	public void exitIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		onExit();
		this.inIndexDefinition = false;
	}

	protected boolean inColumn_definition = false;

	@Override
	public void enterColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Column_definition"), "text", arg.getText());
		onEnter(node);
		this.inColumn_definition = true;
	}

	public void exitColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		onExit();
		this.inColumn_definition = false;
	}

	protected boolean inColConstrNull = false;

	@Override
	public void enterColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrNull"), "text", arg.getText());
		onEnter(node);
		this.inColConstrNull = true;
	}

	public void exitColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		onExit();
		this.inColConstrNull = false;
	}

	protected boolean inColConstrDflt = false;

	@Override
	public void enterColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrDflt"), "text", arg.getText());
		onEnter(node);
		this.inColConstrDflt = true;
	}

	public void exitColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		onExit();
		this.inColConstrDflt = false;
	}

	protected boolean inColConstrAuInc = false;

	@Override
	public void enterColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrAuInc"), "text", arg.getText());
		onEnter(node);
		this.inColConstrAuInc = true;
	}

	public void exitColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		onExit();
		this.inColConstrAuInc = false;
	}

	protected boolean inColConstrPK = false;

	@Override
	public void enterColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrPK"), "text", arg.getText());
		onEnter(node);
		this.inColConstrPK = true;
	}

	public void exitColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		onExit();
		this.inColConstrPK = false;
	}

	protected boolean inColConstrUK = false;

	@Override
	public void enterColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrUK"), "text", arg.getText());
		onEnter(node);
		this.inColConstrUK = true;
	}

	public void exitColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		onExit();
		this.inColConstrUK = false;
	}

	protected boolean inColConstrComment = false;

	@Override
	public void enterColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrComment"), "text", arg.getText());
		onEnter(node);
		this.inColConstrComment = true;
	}

	public void exitColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		onExit();
		this.inColConstrComment = false;
	}

	protected boolean inColConstrForm = false;

	@Override
	public void enterColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrForm"), "text", arg.getText());
		onEnter(node);
		this.inColConstrForm = true;
	}

	public void exitColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		onExit();
		this.inColConstrForm = false;
	}

	protected boolean inColConstrStorage = false;

	@Override
	public void enterColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrStorage"), "text", arg.getText());
		onEnter(node);
		this.inColConstrStorage = true;
	}

	public void exitColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		onExit();
		this.inColConstrStorage = false;
	}

	protected boolean inColConstrRefdef = false;

	@Override
	public void enterColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		final Node node = model.findOrCreate(Label.label("ColConstrRefdef"), "text", arg.getText());
		onEnter(node);
		this.inColConstrRefdef = true;
	}

	public void exitColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		onExit();
		this.inColConstrRefdef = false;
	}

	protected boolean inTblConstrPK = false;

	@Override
	public void enterTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		final Node node = model.findOrCreate(Label.label("TblConstrPK"), "text", arg.getText());
		onEnter(node);
		this.inTblConstrPK = true;
	}

	public void exitTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		onExit();
		this.inTblConstrPK = false;
	}

	protected boolean inTblConstrUK = false;

	@Override
	public void enterTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		final Node node = model.findOrCreate(Label.label("TblConstrUK"), "text", arg.getText());
		onEnter(node);
		this.inTblConstrUK = true;
	}

	public void exitTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		onExit();
		this.inTblConstrUK = false;
	}

	protected boolean inTblConstrFK = false;

	@Override
	public void enterTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		final Node node = model.findOrCreate(Label.label("TblConstrFK"), "text", arg.getText());
		onEnter(node);
		this.inTblConstrFK = true;
	}

	public void exitTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		onExit();
		this.inTblConstrFK = false;
	}

	protected boolean inTblConstCheck = false;

	@Override
	public void enterTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		final Node node = model.findOrCreate(Label.label("TblConstCheck"), "text", arg.getText());
		onEnter(node);
		this.inTblConstCheck = true;
	}

	public void exitTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		onExit();
		this.inTblConstCheck = false;
	}

	protected boolean inReference_definition = false;

	@Override
	public void enterReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Reference_definition"), "text", arg.getText());
		onEnter(node);
		this.inReference_definition = true;
	}

	public void exitReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		onExit();
		this.inReference_definition = false;
	}

	protected boolean inOn_delete_action = false;

	@Override
	public void enterOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		final Node node = model.findOrCreate(Label.label("On_delete_action"), "text", arg.getText());
		onEnter(node);
		this.inOn_delete_action = true;
	}

	public void exitOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		onExit();
		this.inOn_delete_action = false;
	}

	protected boolean inOn_update_action = false;

	@Override
	public void enterOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		final Node node = model.findOrCreate(Label.label("On_update_action"), "text", arg.getText());
		onEnter(node);
		this.inOn_update_action = true;
	}

	public void exitOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		onExit();
		this.inOn_update_action = false;
	}

	protected boolean inReference_action_control_type = false;

	@Override
	public void enterReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		final Node node = model.findOrCreate(Label.label("Reference_action_control_type"), "text", arg.getText());
		onEnter(node);
		this.inReference_action_control_type = true;
	}

	public void exitReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		onExit();
		this.inReference_action_control_type = false;
	}

	protected boolean inSimpleIndex = false;

	@Override
	public void enterSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		final Node node = model.findOrCreate(Label.label("SimpleIndex"), "text", arg.getText());
		onEnter(node);
		this.inSimpleIndex = true;
	}

	public void exitSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		onExit();
		this.inSimpleIndex = false;
	}

	protected boolean inSpecIndex = false;

	@Override
	public void enterSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		final Node node = model.findOrCreate(Label.label("SpecIndex"), "text", arg.getText());
		onEnter(node);
		this.inSpecIndex = true;
	}

	public void exitSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		onExit();
		this.inSpecIndex = false;
	}

	protected boolean inTblOptEngine = false;

	@Override
	public void enterTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptEngine"), "text", arg.getText());
		onEnter(node);
		this.inTblOptEngine = true;
	}

	public void exitTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		onExit();
		this.inTblOptEngine = false;
	}

	protected boolean inTblOptAuInc = false;

	@Override
	public void enterTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptAuInc"), "text", arg.getText());
		onEnter(node);
		this.inTblOptAuInc = true;
	}

	public void exitTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		onExit();
		this.inTblOptAuInc = false;
	}

	protected boolean inTblOptAvgRLen = false;

	@Override
	public void enterTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptAvgRLen"), "text", arg.getText());
		onEnter(node);
		this.inTblOptAvgRLen = true;
	}

	public void exitTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		onExit();
		this.inTblOptAvgRLen = false;
	}

	protected boolean inTblOptDefCharSet = false;

	@Override
	public void enterTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptDefCharSet"), "text", arg.getText());
		onEnter(node);
		this.inTblOptDefCharSet = true;
	}

	public void exitTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		onExit();
		this.inTblOptDefCharSet = false;
	}

	protected boolean inTblOptChkSum = false;

	@Override
	public void enterTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptChkSum"), "text", arg.getText());
		onEnter(node);
		this.inTblOptChkSum = true;
	}

	public void exitTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		onExit();
		this.inTblOptChkSum = false;
	}

	protected boolean inTblOptDefCollate = false;

	@Override
	public void enterTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptDefCollate"), "text", arg.getText());
		onEnter(node);
		this.inTblOptDefCollate = true;
	}

	public void exitTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		onExit();
		this.inTblOptDefCollate = false;
	}

	protected boolean inTblOptComment = false;

	@Override
	public void enterTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptComment"), "text", arg.getText());
		onEnter(node);
		this.inTblOptComment = true;
	}

	public void exitTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		onExit();
		this.inTblOptComment = false;
	}

	protected boolean inTblOptCompr = false;

	@Override
	public void enterTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptCompr"), "text", arg.getText());
		onEnter(node);
		this.inTblOptCompr = true;
	}

	public void exitTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		onExit();
		this.inTblOptCompr = false;
	}

	protected boolean inTblOptConn = false;

	@Override
	public void enterTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptConn"), "text", arg.getText());
		onEnter(node);
		this.inTblOptConn = true;
	}

	public void exitTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		onExit();
		this.inTblOptConn = false;
	}

	protected boolean inTblOptDataDir = false;

	@Override
	public void enterTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptDataDir"), "text", arg.getText());
		onEnter(node);
		this.inTblOptDataDir = true;
	}

	public void exitTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		onExit();
		this.inTblOptDataDir = false;
	}

	protected boolean inTblOptDelKW = false;

	@Override
	public void enterTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptDelKW"), "text", arg.getText());
		onEnter(node);
		this.inTblOptDelKW = true;
	}

	public void exitTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		onExit();
		this.inTblOptDelKW = false;
	}

	protected boolean inTblOptEncr = false;

	@Override
	public void enterTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptEncr"), "text", arg.getText());
		onEnter(node);
		this.inTblOptEncr = true;
	}

	public void exitTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		onExit();
		this.inTblOptEncr = false;
	}

	protected boolean inTblOptIndexDir = false;

	@Override
	public void enterTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptIndexDir"), "text", arg.getText());
		onEnter(node);
		this.inTblOptIndexDir = true;
	}

	public void exitTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		onExit();
		this.inTblOptIndexDir = false;
	}

	protected boolean inTblOptInsMeth = false;

	@Override
	public void enterTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptInsMeth"), "text", arg.getText());
		onEnter(node);
		this.inTblOptInsMeth = true;
	}

	public void exitTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		onExit();
		this.inTblOptInsMeth = false;
	}

	protected boolean inTblOptKeyBlockSz = false;

	@Override
	public void enterTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptKeyBlockSz"), "text", arg.getText());
		onEnter(node);
		this.inTblOptKeyBlockSz = true;
	}

	public void exitTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		onExit();
		this.inTblOptKeyBlockSz = false;
	}

	protected boolean inTblOptMaxRows = false;

	@Override
	public void enterTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptMaxRows"), "text", arg.getText());
		onEnter(node);
		this.inTblOptMaxRows = true;
	}

	public void exitTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		onExit();
		this.inTblOptMaxRows = false;
	}

	protected boolean inTblOptMinRows = false;

	@Override
	public void enterTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptMinRows"), "text", arg.getText());
		onEnter(node);
		this.inTblOptMinRows = true;
	}

	public void exitTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		onExit();
		this.inTblOptMinRows = false;
	}

	protected boolean inTblOptPackK = false;

	@Override
	public void enterTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptPackK"), "text", arg.getText());
		onEnter(node);
		this.inTblOptPackK = true;
	}

	public void exitTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		onExit();
		this.inTblOptPackK = false;
	}

	protected boolean inTblOptPasswd = false;

	@Override
	public void enterTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptPasswd"), "text", arg.getText());
		onEnter(node);
		this.inTblOptPasswd = true;
	}

	public void exitTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		onExit();
		this.inTblOptPasswd = false;
	}

	protected boolean inTblOptRowFormat = false;

	@Override
	public void enterTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptRowFormat"), "text", arg.getText());
		onEnter(node);
		this.inTblOptRowFormat = true;
	}

	public void exitTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		onExit();
		this.inTblOptRowFormat = false;
	}

	protected boolean inTblOptStatAutoR = false;

	@Override
	public void enterTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptStatAutoR"), "text", arg.getText());
		onEnter(node);
		this.inTblOptStatAutoR = true;
	}

	public void exitTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		onExit();
		this.inTblOptStatAutoR = false;
	}

	protected boolean inTblOptStatPersist = false;

	@Override
	public void enterTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptStatPersist"), "text", arg.getText());
		onEnter(node);
		this.inTblOptStatPersist = true;
	}

	public void exitTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		onExit();
		this.inTblOptStatPersist = false;
	}

	protected boolean inTblOptStatSamplPg = false;

	@Override
	public void enterTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptStatSamplPg"), "text", arg.getText());
		onEnter(node);
		this.inTblOptStatSamplPg = true;
	}

	public void exitTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		onExit();
		this.inTblOptStatSamplPg = false;
	}

	protected boolean inTblOptTablespace = false;

	@Override
	public void enterTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptTablespace"), "text", arg.getText());
		onEnter(node);
		this.inTblOptTablespace = true;
	}

	public void exitTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		onExit();
		this.inTblOptTablespace = false;
	}

	protected boolean inTblOptUnion = false;

	@Override
	public void enterTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		final Node node = model.findOrCreate(Label.label("TblOptUnion"), "text", arg.getText());
		onEnter(node);
		this.inTblOptUnion = true;
	}

	public void exitTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		onExit();
		this.inTblOptUnion = false;
	}

	protected boolean inPartition_options = false;

	@Override
	public void enterPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		final Node node = model.findOrCreate(Label.label("Partition_options"), "text", arg.getText());
		onEnter(node);
		this.inPartition_options = true;
	}

	public void exitPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		onExit();
		this.inPartition_options = false;
	}

	protected boolean inPartition_function_definition = false;

	@Override
	public void enterPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Partition_function_definition"), "text", arg.getText());
		onEnter(node);
		this.inPartition_function_definition = true;
	}

	public void exitPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		onExit();
		this.inPartition_function_definition = false;
	}

	protected boolean inLinear_partition_func_def = false;

	@Override
	public void enterLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		final Node node = model.findOrCreate(Label.label("Linear_partition_func_def"), "text", arg.getText());
		onEnter(node);
		this.inLinear_partition_func_def = true;
	}

	public void exitLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		onExit();
		this.inLinear_partition_func_def = false;
	}

	protected boolean inPartition_def = false;

	@Override
	public void enterPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		final Node node = model.findOrCreate(Label.label("Partition_def"), "text", arg.getText());
		onEnter(node);
		this.inPartition_def = true;
	}

	public void exitPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		onExit();
		this.inPartition_def = false;
	}

	protected boolean inSubpartition_def = false;

	@Override
	public void enterSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		final Node node = model.findOrCreate(Label.label("Subpartition_def"), "text", arg.getText());
		onEnter(node);
		this.inSubpartition_def = true;
	}

	public void exitSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		onExit();
		this.inSubpartition_def = false;
	}

	protected boolean inAlterDb = false;

	@Override
	public void enterAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		final Node node = model.findOrCreate(Label.label("AlterDb"), "text", arg.getText());
		onEnter(node);
		this.inAlterDb = true;
	}

	public void exitAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		onExit();
		this.inAlterDb = false;
	}

	protected boolean inAlterDbUpgradeName = false;

	@Override
	public void enterAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		final Node node = model.findOrCreate(Label.label("AlterDbUpgradeName"), "text", arg.getText());
		onEnter(node);
		this.inAlterDbUpgradeName = true;
	}

	public void exitAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		onExit();
		this.inAlterDbUpgradeName = false;
	}

	protected boolean inAlter_event = false;

	@Override
	public void enterAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_event"), "text", arg.getText());
		onEnter(node);
		this.inAlter_event = true;
	}

	public void exitAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		onExit();
		this.inAlter_event = false;
	}

	protected boolean inAlter_function = false;

	@Override
	public void enterAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_function"), "text", arg.getText());
		onEnter(node);
		this.inAlter_function = true;
	}

	public void exitAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		onExit();
		this.inAlter_function = false;
	}

	protected boolean inAlter_instance = false;

	@Override
	public void enterAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_instance"), "text", arg.getText());
		onEnter(node);
		this.inAlter_instance = true;
	}

	public void exitAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		onExit();
		this.inAlter_instance = false;
	}

	protected boolean inAlter_logfile_group = false;

	@Override
	public void enterAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_logfile_group"), "text", arg.getText());
		onEnter(node);
		this.inAlter_logfile_group = true;
	}

	public void exitAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		onExit();
		this.inAlter_logfile_group = false;
	}

	protected boolean inAlter_procedure = false;

	@Override
	public void enterAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_procedure"), "text", arg.getText());
		onEnter(node);
		this.inAlter_procedure = true;
	}

	public void exitAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		onExit();
		this.inAlter_procedure = false;
	}

	protected boolean inAlter_server = false;

	@Override
	public void enterAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_server"), "text", arg.getText());
		onEnter(node);
		this.inAlter_server = true;
	}

	public void exitAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		onExit();
		this.inAlter_server = false;
	}

	protected boolean inAlter_table = false;

	@Override
	public void enterAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_table"), "text", arg.getText());
		onEnter(node);
		this.inAlter_table = true;
	}

	public void exitAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		onExit();
		this.inAlter_table = false;
	}

	protected boolean inAlter_tablespace = false;

	@Override
	public void enterAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_tablespace"), "text", arg.getText());
		onEnter(node);
		this.inAlter_tablespace = true;
	}

	public void exitAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		onExit();
		this.inAlter_tablespace = false;
	}

	protected boolean inAlter_view = false;

	@Override
	public void enterAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		final Node node = model.findOrCreate(Label.label("Alter_view"), "text", arg.getText());
		onEnter(node);
		this.inAlter_view = true;
	}

	public void exitAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		onExit();
		this.inAlter_view = false;
	}

	protected boolean inAltblTableOpt = false;

	@Override
	public void enterAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblTableOpt"), "text", arg.getText());
		onEnter(node);
		this.inAltblTableOpt = true;
	}

	public void exitAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		onExit();
		this.inAltblTableOpt = false;
	}

	protected boolean inAltblAddCol = false;

	@Override
	public void enterAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddCol"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddCol = true;
	}

	public void exitAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		onExit();
		this.inAltblAddCol = false;
	}

	protected boolean inAltblAddCols = false;

	@Override
	public void enterAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddCols"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddCols = true;
	}

	public void exitAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		onExit();
		this.inAltblAddCols = false;
	}

	protected boolean inAltblAddIndex = false;

	@Override
	public void enterAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddIndex"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddIndex = true;
	}

	public void exitAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		onExit();
		this.inAltblAddIndex = false;
	}

	protected boolean inAltblAddPK = false;

	@Override
	public void enterAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddPK"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddPK = true;
	}

	public void exitAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		onExit();
		this.inAltblAddPK = false;
	}

	protected boolean inAltblAddUK = false;

	@Override
	public void enterAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddUK"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddUK = true;
	}

	public void exitAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		onExit();
		this.inAltblAddUK = false;
	}

	protected boolean inAltblAddSpecIndex = false;

	@Override
	public void enterAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddSpecIndex"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddSpecIndex = true;
	}

	public void exitAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		onExit();
		this.inAltblAddSpecIndex = false;
	}

	protected boolean inAltblAddFK = false;

	@Override
	public void enterAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddFK"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddFK = true;
	}

	public void exitAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		onExit();
		this.inAltblAddFK = false;
	}

	protected boolean inAltblAlg = false;

	@Override
	public void enterAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAlg"), "text", arg.getText());
		onEnter(node);
		this.inAltblAlg = true;
	}

	public void exitAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		onExit();
		this.inAltblAlg = false;
	}

	protected boolean inAltblColDef = false;

	@Override
	public void enterAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblColDef"), "text", arg.getText());
		onEnter(node);
		this.inAltblColDef = true;
	}

	public void exitAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		onExit();
		this.inAltblColDef = false;
	}

	protected boolean inAltblColChange = false;

	@Override
	public void enterAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblColChange"), "text", arg.getText());
		onEnter(node);
		this.inAltblColChange = true;
	}

	public void exitAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		onExit();
		this.inAltblColChange = false;
	}

	protected boolean inAltblLock = false;

	@Override
	public void enterAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblLock"), "text", arg.getText());
		onEnter(node);
		this.inAltblLock = true;
	}

	public void exitAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		onExit();
		this.inAltblLock = false;
	}

	protected boolean inAltblColMod = false;

	@Override
	public void enterAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblColMod"), "text", arg.getText());
		onEnter(node);
		this.inAltblColMod = true;
	}

	public void exitAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		onExit();
		this.inAltblColMod = false;
	}

	protected boolean inAltblColDrop = false;

	@Override
	public void enterAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblColDrop"), "text", arg.getText());
		onEnter(node);
		this.inAltblColDrop = true;
	}

	public void exitAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		onExit();
		this.inAltblColDrop = false;
	}

	protected boolean inAltblDropPK = false;

	@Override
	public void enterAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDropPK"), "text", arg.getText());
		onEnter(node);
		this.inAltblDropPK = true;
	}

	public void exitAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		onExit();
		this.inAltblDropPK = false;
	}

	protected boolean inAltblDropIndex = false;

	@Override
	public void enterAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDropIndex"), "text", arg.getText());
		onEnter(node);
		this.inAltblDropIndex = true;
	}

	public void exitAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		onExit();
		this.inAltblDropIndex = false;
	}

	protected boolean inAltblDropFK = false;

	@Override
	public void enterAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDropFK"), "text", arg.getText());
		onEnter(node);
		this.inAltblDropFK = true;
	}

	public void exitAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		onExit();
		this.inAltblDropFK = false;
	}

	protected boolean inAltblDisKey = false;

	@Override
	public void enterAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDisKey"), "text", arg.getText());
		onEnter(node);
		this.inAltblDisKey = true;
	}

	public void exitAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		onExit();
		this.inAltblDisKey = false;
	}

	protected boolean inAltblEnKey = false;

	@Override
	public void enterAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblEnKey"), "text", arg.getText());
		onEnter(node);
		this.inAltblEnKey = true;
	}

	public void exitAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		onExit();
		this.inAltblEnKey = false;
	}

	protected boolean inAltblRenameTbl = false;

	@Override
	public void enterAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblRenameTbl"), "text", arg.getText());
		onEnter(node);
		this.inAltblRenameTbl = true;
	}

	public void exitAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		onExit();
		this.inAltblRenameTbl = false;
	}

	protected boolean inAltblResort = false;

	@Override
	public void enterAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblResort"), "text", arg.getText());
		onEnter(node);
		this.inAltblResort = true;
	}

	public void exitAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		onExit();
		this.inAltblResort = false;
	}

	protected boolean inAltblConvert = false;

	@Override
	public void enterAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblConvert"), "text", arg.getText());
		onEnter(node);
		this.inAltblConvert = true;
	}

	public void exitAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		onExit();
		this.inAltblConvert = false;
	}

	protected boolean inAltblDefCharset = false;

	@Override
	public void enterAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDefCharset"), "text", arg.getText());
		onEnter(node);
		this.inAltblDefCharset = true;
	}

	public void exitAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		onExit();
		this.inAltblDefCharset = false;
	}

	protected boolean inAltblDisTblspace = false;

	@Override
	public void enterAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDisTblspace"), "text", arg.getText());
		onEnter(node);
		this.inAltblDisTblspace = true;
	}

	public void exitAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		onExit();
		this.inAltblDisTblspace = false;
	}

	protected boolean inAltblImpTblSpace = false;

	@Override
	public void enterAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblImpTblSpace"), "text", arg.getText());
		onEnter(node);
		this.inAltblImpTblSpace = true;
	}

	public void exitAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		onExit();
		this.inAltblImpTblSpace = false;
	}

	protected boolean inAltblForce = false;

	@Override
	public void enterAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblForce"), "text", arg.getText());
		onEnter(node);
		this.inAltblForce = true;
	}

	public void exitAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		onExit();
		this.inAltblForce = false;
	}

	protected boolean inAltblValid = false;

	@Override
	public void enterAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblValid"), "text", arg.getText());
		onEnter(node);
		this.inAltblValid = true;
	}

	public void exitAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		onExit();
		this.inAltblValid = false;
	}

	protected boolean inAltblAddPart = false;

	@Override
	public void enterAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAddPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblAddPart = true;
	}

	public void exitAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		onExit();
		this.inAltblAddPart = false;
	}

	protected boolean inAltblDropPart = false;

	@Override
	public void enterAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDropPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblDropPart = true;
	}

	public void exitAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		onExit();
		this.inAltblDropPart = false;
	}

	protected boolean inAltblDiscartPart = false;

	@Override
	public void enterAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblDiscartPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblDiscartPart = true;
	}

	public void exitAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		onExit();
		this.inAltblDiscartPart = false;
	}

	protected boolean inAltblImportPart = false;

	@Override
	public void enterAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblImportPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblImportPart = true;
	}

	public void exitAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		onExit();
		this.inAltblImportPart = false;
	}

	protected boolean inAltblTruncPart = false;

	@Override
	public void enterAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblTruncPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblTruncPart = true;
	}

	public void exitAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		onExit();
		this.inAltblTruncPart = false;
	}

	protected boolean inAltblCoalPart = false;

	@Override
	public void enterAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblCoalPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblCoalPart = true;
	}

	public void exitAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		onExit();
		this.inAltblCoalPart = false;
	}

	protected boolean inAltblReorgPart = false;

	@Override
	public void enterAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblReorgPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblReorgPart = true;
	}

	public void exitAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		onExit();
		this.inAltblReorgPart = false;
	}

	protected boolean inAltblExchPart = false;

	@Override
	public void enterAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblExchPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblExchPart = true;
	}

	public void exitAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		onExit();
		this.inAltblExchPart = false;
	}

	protected boolean inAltblAnalPart = false;

	@Override
	public void enterAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblAnalPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblAnalPart = true;
	}

	public void exitAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		onExit();
		this.inAltblAnalPart = false;
	}

	protected boolean inAltblCheckPart = false;

	@Override
	public void enterAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblCheckPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblCheckPart = true;
	}

	public void exitAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		onExit();
		this.inAltblCheckPart = false;
	}

	protected boolean inAltblOptimPart = false;

	@Override
	public void enterAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblOptimPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblOptimPart = true;
	}

	public void exitAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		onExit();
		this.inAltblOptimPart = false;
	}

	protected boolean inAltblRebuildPart = false;

	@Override
	public void enterAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblRebuildPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblRebuildPart = true;
	}

	public void exitAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		onExit();
		this.inAltblRebuildPart = false;
	}

	protected boolean inAltblRepairPart = false;

	@Override
	public void enterAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblRepairPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblRepairPart = true;
	}

	public void exitAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		onExit();
		this.inAltblRepairPart = false;
	}

	protected boolean inAltblRemovePart = false;

	@Override
	public void enterAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblRemovePart"), "text", arg.getText());
		onEnter(node);
		this.inAltblRemovePart = true;
	}

	public void exitAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		onExit();
		this.inAltblRemovePart = false;
	}

	protected boolean inAltblUpgrPart = false;

	@Override
	public void enterAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		final Node node = model.findOrCreate(Label.label("AltblUpgrPart"), "text", arg.getText());
		onEnter(node);
		this.inAltblUpgrPart = true;
	}

	public void exitAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		onExit();
		this.inAltblUpgrPart = false;
	}

	protected boolean inDrop_database = false;

	@Override
	public void enterDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_database"), "text", arg.getText());
		onEnter(node);
		this.inDrop_database = true;
	}

	public void exitDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		onExit();
		this.inDrop_database = false;
	}

	protected boolean inDrop_event = false;

	@Override
	public void enterDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_event"), "text", arg.getText());
		onEnter(node);
		this.inDrop_event = true;
	}

	public void exitDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		onExit();
		this.inDrop_event = false;
	}

	protected boolean inDrop_index = false;

	@Override
	public void enterDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_index"), "text", arg.getText());
		onEnter(node);
		this.inDrop_index = true;
	}

	public void exitDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		onExit();
		this.inDrop_index = false;
	}

	protected boolean inDrop_logfile_group = false;

	@Override
	public void enterDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_logfile_group"), "text", arg.getText());
		onEnter(node);
		this.inDrop_logfile_group = true;
	}

	public void exitDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		onExit();
		this.inDrop_logfile_group = false;
	}

	protected boolean inDrop_procedure = false;

	@Override
	public void enterDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_procedure"), "text", arg.getText());
		onEnter(node);
		this.inDrop_procedure = true;
	}

	public void exitDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		onExit();
		this.inDrop_procedure = false;
	}

	protected boolean inDrop_function = false;

	@Override
	public void enterDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_function"), "text", arg.getText());
		onEnter(node);
		this.inDrop_function = true;
	}

	public void exitDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		onExit();
		this.inDrop_function = false;
	}

	protected boolean inDrop_server = false;

	@Override
	public void enterDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_server"), "text", arg.getText());
		onEnter(node);
		this.inDrop_server = true;
	}

	public void exitDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		onExit();
		this.inDrop_server = false;
	}

	protected boolean inDrop_table = false;

	@Override
	public void enterDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_table"), "text", arg.getText());
		onEnter(node);
		this.inDrop_table = true;
	}

	public void exitDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		onExit();
		this.inDrop_table = false;
	}

	protected boolean inDrop_tablespace = false;

	@Override
	public void enterDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_tablespace"), "text", arg.getText());
		onEnter(node);
		this.inDrop_tablespace = true;
	}

	public void exitDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		onExit();
		this.inDrop_tablespace = false;
	}

	protected boolean inDrop_trigger = false;

	@Override
	public void enterDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_trigger"), "text", arg.getText());
		onEnter(node);
		this.inDrop_trigger = true;
	}

	public void exitDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		onExit();
		this.inDrop_trigger = false;
	}

	protected boolean inDrop_view = false;

	@Override
	public void enterDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_view"), "text", arg.getText());
		onEnter(node);
		this.inDrop_view = true;
	}

	public void exitDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		onExit();
		this.inDrop_view = false;
	}

	protected boolean inRename_table = false;

	@Override
	public void enterRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Rename_table"), "text", arg.getText());
		onEnter(node);
		this.inRename_table = true;
	}

	public void exitRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		onExit();
		this.inRename_table = false;
	}

	protected boolean inTruncate_table = false;

	@Override
	public void enterTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Truncate_table"), "text", arg.getText());
		onEnter(node);
		this.inTruncate_table = true;
	}

	public void exitTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		onExit();
		this.inTruncate_table = false;
	}

	protected boolean inCall_statement = false;

	@Override
	public void enterCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Call_statement"), "text", arg.getText());
		onEnter(node);
		this.inCall_statement = true;
	}

	public void exitCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		onExit();
		this.inCall_statement = false;
	}

	protected boolean inDelete_statement = false;

	@Override
	public void enterDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Delete_statement"), "text", arg.getText());
		onEnter(node);
		this.inDelete_statement = true;
	}

	public void exitDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		onExit();
		this.inDelete_statement = false;
	}

	protected boolean inDo_statement = false;

	@Override
	public void enterDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Do_statement"), "text", arg.getText());
		onEnter(node);
		this.inDo_statement = true;
	}

	public void exitDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		onExit();
		this.inDo_statement = false;
	}

	protected boolean inHandler_statement = false;

	@Override
	public void enterHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler_statement"), "text", arg.getText());
		onEnter(node);
		this.inHandler_statement = true;
	}

	public void exitHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		onExit();
		this.inHandler_statement = false;
	}

	protected boolean inInsert_statement = false;

	@Override
	public void enterInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Insert_statement"), "text", arg.getText());
		onEnter(node);
		this.inInsert_statement = true;
	}

	public void exitInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		onExit();
		this.inInsert_statement = false;
	}

	protected boolean inLoad_data_statement = false;

	@Override
	public void enterLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Load_data_statement"), "text", arg.getText());
		onEnter(node);
		this.inLoad_data_statement = true;
	}

	public void exitLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		onExit();
		this.inLoad_data_statement = false;
	}

	protected boolean inLoad_xml_statement = false;

	@Override
	public void enterLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Load_xml_statement"), "text", arg.getText());
		onEnter(node);
		this.inLoad_xml_statement = true;
	}

	public void exitLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		onExit();
		this.inLoad_xml_statement = false;
	}

	protected boolean inReplace_statement = false;

	@Override
	public void enterReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Replace_statement"), "text", arg.getText());
		onEnter(node);
		this.inReplace_statement = true;
	}

	public void exitReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		onExit();
		this.inReplace_statement = false;
	}

	protected boolean inSimpleSelect = false;

	@Override
	public void enterSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		final Node node = model.findOrCreate(Label.label("SimpleSelect"), "text", arg.getText());
		onEnter(node);
		this.inSimpleSelect = true;
	}

	public void exitSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		onExit();
		this.inSimpleSelect = false;
	}

	protected boolean inParenSelect = false;

	@Override
	public void enterParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		final Node node = model.findOrCreate(Label.label("ParenSelect"), "text", arg.getText());
		onEnter(node);
		this.inParenSelect = true;
	}

	public void exitParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		onExit();
		this.inParenSelect = false;
	}

	protected boolean inUnionSelect = false;

	@Override
	public void enterUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		final Node node = model.findOrCreate(Label.label("UnionSelect"), "text", arg.getText());
		onEnter(node);
		this.inUnionSelect = true;
	}

	public void exitUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		onExit();
		this.inUnionSelect = false;
	}

	protected boolean inUnionParenSelect = false;

	@Override
	public void enterUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		final Node node = model.findOrCreate(Label.label("UnionParenSelect"), "text", arg.getText());
		onEnter(node);
		this.inUnionParenSelect = true;
	}

	public void exitUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		onExit();
		this.inUnionParenSelect = false;
	}

	protected boolean inUpdate_statement = false;

	@Override
	public void enterUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Update_statement"), "text", arg.getText());
		onEnter(node);
		this.inUpdate_statement = true;
	}

	public void exitUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		onExit();
		this.inUpdate_statement = false;
	}

	protected boolean inInsert_statement_value = false;

	@Override
	public void enterInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		final Node node = model.findOrCreate(Label.label("Insert_statement_value"), "text", arg.getText());
		onEnter(node);
		this.inInsert_statement_value = true;
	}

	public void exitInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		onExit();
		this.inInsert_statement_value = false;
	}

	protected boolean inUpdate_elem = false;

	@Override
	public void enterUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		final Node node = model.findOrCreate(Label.label("Update_elem"), "text", arg.getText());
		onEnter(node);
		this.inUpdate_elem = true;
	}

	public void exitUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		onExit();
		this.inUpdate_elem = false;
	}

	protected boolean inCol_or_uservar = false;

	@Override
	public void enterCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		final Node node = model.findOrCreate(Label.label("Col_or_uservar"), "text", arg.getText());
		onEnter(node);
		this.inCol_or_uservar = true;
	}

	public void exitCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		onExit();
		this.inCol_or_uservar = false;
	}

	protected boolean inSingle_delete_statement = false;

	@Override
	public void enterSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Single_delete_statement"), "text", arg.getText());
		onEnter(node);
		this.inSingle_delete_statement = true;
	}

	public void exitSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		onExit();
		this.inSingle_delete_statement = false;
	}

	protected boolean inMultiple_delete_statement = false;

	@Override
	public void enterMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Multiple_delete_statement"), "text", arg.getText());
		onEnter(node);
		this.inMultiple_delete_statement = true;
	}

	public void exitMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		onExit();
		this.inMultiple_delete_statement = false;
	}

	protected boolean inHandler_open_statement = false;

	@Override
	public void enterHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler_open_statement"), "text", arg.getText());
		onEnter(node);
		this.inHandler_open_statement = true;
	}

	public void exitHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		onExit();
		this.inHandler_open_statement = false;
	}

	protected boolean inHandler_read_index_statement = false;

	@Override
	public void enterHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler_read_index_statement"), "text", arg.getText());
		onEnter(node);
		this.inHandler_read_index_statement = true;
	}

	public void exitHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		onExit();
		this.inHandler_read_index_statement = false;
	}

	protected boolean inHandler_read_statement = false;

	@Override
	public void enterHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler_read_statement"), "text", arg.getText());
		onEnter(node);
		this.inHandler_read_statement = true;
	}

	public void exitHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		onExit();
		this.inHandler_read_statement = false;
	}

	protected boolean inHandler_close_statement = false;

	@Override
	public void enterHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler_close_statement"), "text", arg.getText());
		onEnter(node);
		this.inHandler_close_statement = true;
	}

	public void exitHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		onExit();
		this.inHandler_close_statement = false;
	}

	protected boolean inSingle_update_statement = false;

	@Override
	public void enterSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Single_update_statement"), "text", arg.getText());
		onEnter(node);
		this.inSingle_update_statement = true;
	}

	public void exitSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		onExit();
		this.inSingle_update_statement = false;
	}

	protected boolean inMultiple_update_statement = false;

	@Override
	public void enterMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Multiple_update_statement"), "text", arg.getText());
		onEnter(node);
		this.inMultiple_update_statement = true;
	}

	public void exitMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		onExit();
		this.inMultiple_update_statement = false;
	}

	protected boolean inOrder_by_clause = false;

	@Override
	public void enterOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Order_by_clause"), "text", arg.getText());
		onEnter(node);
		this.inOrder_by_clause = true;
	}

	public void exitOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		onExit();
		this.inOrder_by_clause = false;
	}

	protected boolean inOrder_by_expression = false;

	@Override
	public void enterOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Order_by_expression"), "text", arg.getText());
		onEnter(node);
		this.inOrder_by_expression = true;
	}

	public void exitOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		onExit();
		this.inOrder_by_expression = false;
	}

	protected boolean inTable_sources = false;

	@Override
	public void enterTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		final Node node = model.findOrCreate(Label.label("Table_sources"), "text", arg.getText());
		onEnter(node);
		this.inTable_sources = true;
	}

	public void exitTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		onExit();
		this.inTable_sources = false;
	}

	protected boolean inTable_source = false;

	@Override
	public void enterTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		final Node node = model.findOrCreate(Label.label("Table_source"), "text", arg.getText());
		onEnter(node);
		this.inTable_source = true;
	}

	public void exitTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		onExit();
		this.inTable_source = false;
	}

	protected boolean inAtomTableItem = false;

	@Override
	public void enterAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		final Node node = model.findOrCreate(Label.label("AtomTableItem"), "text", arg.getText());
		onEnter(node);
		this.inAtomTableItem = true;
	}

	public void exitAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		onExit();
		this.inAtomTableItem = false;
	}

	protected boolean inSubqueryTableItem = false;

	@Override
	public void enterSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		final Node node = model.findOrCreate(Label.label("SubqueryTableItem"), "text", arg.getText());
		onEnter(node);
		this.inSubqueryTableItem = true;
	}

	public void exitSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		onExit();
		this.inSubqueryTableItem = false;
	}

	protected boolean inTableSourcesItem = false;

	@Override
	public void enterTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		final Node node = model.findOrCreate(Label.label("TableSourcesItem"), "text", arg.getText());
		onEnter(node);
		this.inTableSourcesItem = true;
	}

	public void exitTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		onExit();
		this.inTableSourcesItem = false;
	}

	protected boolean inIndex_hint = false;

	@Override
	public void enterIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		final Node node = model.findOrCreate(Label.label("Index_hint"), "text", arg.getText());
		onEnter(node);
		this.inIndex_hint = true;
	}

	public void exitIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		onExit();
		this.inIndex_hint = false;
	}

	protected boolean inInnerJoin = false;

	@Override
	public void enterInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		final Node node = model.findOrCreate(Label.label("InnerJoin"), "text", arg.getText());
		onEnter(node);
		this.inInnerJoin = true;
	}

	public void exitInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		onExit();
		this.inInnerJoin = false;
	}

	protected boolean inStraightJoin = false;

	@Override
	public void enterStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		final Node node = model.findOrCreate(Label.label("StraightJoin"), "text", arg.getText());
		onEnter(node);
		this.inStraightJoin = true;
	}

	public void exitStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		onExit();
		this.inStraightJoin = false;
	}

	protected boolean inOuterJoin = false;

	@Override
	public void enterOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		final Node node = model.findOrCreate(Label.label("OuterJoin"), "text", arg.getText());
		onEnter(node);
		this.inOuterJoin = true;
	}

	public void exitOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		onExit();
		this.inOuterJoin = false;
	}

	protected boolean inNaturalJoin = false;

	@Override
	public void enterNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		final Node node = model.findOrCreate(Label.label("NaturalJoin"), "text", arg.getText());
		onEnter(node);
		this.inNaturalJoin = true;
	}

	public void exitNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		onExit();
		this.inNaturalJoin = false;
	}

	protected boolean inSubquery = false;

	@Override
	public void enterSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		final Node node = model.findOrCreate(Label.label("Subquery"), "text", arg.getText());
		onEnter(node);
		this.inSubquery = true;
	}

	public void exitSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		onExit();
		this.inSubquery = false;
	}

	protected boolean inQuery_expression = false;

	@Override
	public void enterQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Query_expression"), "text", arg.getText());
		onEnter(node);
		this.inQuery_expression = true;
	}

	public void exitQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		onExit();
		this.inQuery_expression = false;
	}

	protected boolean inQuery_expression_nointo = false;

	@Override
	public void enterQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		final Node node = model.findOrCreate(Label.label("Query_expression_nointo"), "text", arg.getText());
		onEnter(node);
		this.inQuery_expression_nointo = true;
	}

	public void exitQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		onExit();
		this.inQuery_expression_nointo = false;
	}

	protected boolean inQuery_specification = false;

	@Override
	public void enterQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Query_specification"), "text", arg.getText());
		onEnter(node);
		this.inQuery_specification = true;
	}

	public void exitQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		onExit();
		this.inQuery_specification = false;
	}

	protected boolean inQuery_specification_nointo = false;

	@Override
	public void enterQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		final Node node = model.findOrCreate(Label.label("Query_specification_nointo"), "text", arg.getText());
		onEnter(node);
		this.inQuery_specification_nointo = true;
	}

	public void exitQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		onExit();
		this.inQuery_specification_nointo = false;
	}

	protected boolean inUnion_parenth = false;

	@Override
	public void enterUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		final Node node = model.findOrCreate(Label.label("Union_parenth"), "text", arg.getText());
		onEnter(node);
		this.inUnion_parenth = true;
	}

	public void exitUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		onExit();
		this.inUnion_parenth = false;
	}

	protected boolean inUnion_statement = false;

	@Override
	public void enterUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Union_statement"), "text", arg.getText());
		onEnter(node);
		this.inUnion_statement = true;
	}

	public void exitUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		onExit();
		this.inUnion_statement = false;
	}

	protected boolean inSelect_spec = false;

	@Override
	public void enterSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		final Node node = model.findOrCreate(Label.label("Select_spec"), "text", arg.getText());
		onEnter(node);
		this.inSelect_spec = true;
	}

	public void exitSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		onExit();
		this.inSelect_spec = false;
	}

	protected boolean inSelect_list = false;

	@Override
	public void enterSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Select_list"), "text", arg.getText());
		onEnter(node);
		this.inSelect_list = true;
	}

	public void exitSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		onExit();
		this.inSelect_list = false;
	}

	protected boolean inSellistelAllCol = false;

	@Override
	public void enterSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		final Node node = model.findOrCreate(Label.label("SellistelAllCol"), "text", arg.getText());
		onEnter(node);
		this.inSellistelAllCol = true;
	}

	public void exitSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		onExit();
		this.inSellistelAllCol = false;
	}

	protected boolean inSellistelCol = false;

	@Override
	public void enterSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		final Node node = model.findOrCreate(Label.label("SellistelCol"), "text", arg.getText());
		onEnter(node);
		this.inSellistelCol = true;
	}

	public void exitSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		onExit();
		this.inSellistelCol = false;
	}

	protected boolean inSellistelFunc = false;

	@Override
	public void enterSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		final Node node = model.findOrCreate(Label.label("SellistelFunc"), "text", arg.getText());
		onEnter(node);
		this.inSellistelFunc = true;
	}

	public void exitSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		onExit();
		this.inSellistelFunc = false;
	}

	protected boolean inSellistelExpr = false;

	@Override
	public void enterSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		final Node node = model.findOrCreate(Label.label("SellistelExpr"), "text", arg.getText());
		onEnter(node);
		this.inSellistelExpr = true;
	}

	public void exitSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		onExit();
		this.inSellistelExpr = false;
	}

	protected boolean inSelectIntoVars = false;

	@Override
	public void enterSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		final Node node = model.findOrCreate(Label.label("SelectIntoVars"), "text", arg.getText());
		onEnter(node);
		this.inSelectIntoVars = true;
	}

	public void exitSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		onExit();
		this.inSelectIntoVars = false;
	}

	protected boolean inSelectIntoDump = false;

	@Override
	public void enterSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		final Node node = model.findOrCreate(Label.label("SelectIntoDump"), "text", arg.getText());
		onEnter(node);
		this.inSelectIntoDump = true;
	}

	public void exitSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		onExit();
		this.inSelectIntoDump = false;
	}

	protected boolean inSelectIntoOutfile = false;

	@Override
	public void enterSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		final Node node = model.findOrCreate(Label.label("SelectIntoOutfile"), "text", arg.getText());
		onEnter(node);
		this.inSelectIntoOutfile = true;
	}

	public void exitSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		onExit();
		this.inSelectIntoOutfile = false;
	}

	protected boolean inFrom_clause = false;

	@Override
	public void enterFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		final Node node = model.findOrCreate(Label.label("From_clause"), "text", arg.getText());
		onEnter(node);
		this.inFrom_clause = true;
	}

	public void exitFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		onExit();
		this.inFrom_clause = false;
	}

	protected boolean inGroup_by_item = false;

	@Override
	public void enterGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		final Node node = model.findOrCreate(Label.label("Group_by_item"), "text", arg.getText());
		onEnter(node);
		this.inGroup_by_item = true;
	}

	public void exitGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		onExit();
		this.inGroup_by_item = false;
	}

	protected boolean inLimit_clause = false;

	@Override
	public void enterLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Limit_clause"), "text", arg.getText());
		onEnter(node);
		this.inLimit_clause = true;
	}

	public void exitLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		onExit();
		this.inLimit_clause = false;
	}

	protected boolean inStart_transaction = false;

	@Override
	public void enterStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		final Node node = model.findOrCreate(Label.label("Start_transaction"), "text", arg.getText());
		onEnter(node);
		this.inStart_transaction = true;
	}

	public void exitStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		onExit();
		this.inStart_transaction = false;
	}

	protected boolean inBegin_work = false;

	@Override
	public void enterBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		final Node node = model.findOrCreate(Label.label("Begin_work"), "text", arg.getText());
		onEnter(node);
		this.inBegin_work = true;
	}

	public void exitBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		onExit();
		this.inBegin_work = false;
	}

	protected boolean inCommit_work = false;

	@Override
	public void enterCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		final Node node = model.findOrCreate(Label.label("Commit_work"), "text", arg.getText());
		onEnter(node);
		this.inCommit_work = true;
	}

	public void exitCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		onExit();
		this.inCommit_work = false;
	}

	protected boolean inRollback_work = false;

	@Override
	public void enterRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		final Node node = model.findOrCreate(Label.label("Rollback_work"), "text", arg.getText());
		onEnter(node);
		this.inRollback_work = true;
	}

	public void exitRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		onExit();
		this.inRollback_work = false;
	}

	protected boolean inSavepoint_statement = false;

	@Override
	public void enterSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Savepoint_statement"), "text", arg.getText());
		onEnter(node);
		this.inSavepoint_statement = true;
	}

	public void exitSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		onExit();
		this.inSavepoint_statement = false;
	}

	protected boolean inRollback_statement = false;

	@Override
	public void enterRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Rollback_statement"), "text", arg.getText());
		onEnter(node);
		this.inRollback_statement = true;
	}

	public void exitRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		onExit();
		this.inRollback_statement = false;
	}

	protected boolean inRelease_statement = false;

	@Override
	public void enterRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Release_statement"), "text", arg.getText());
		onEnter(node);
		this.inRelease_statement = true;
	}

	public void exitRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		onExit();
		this.inRelease_statement = false;
	}

	protected boolean inLock_tables = false;

	@Override
	public void enterLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		final Node node = model.findOrCreate(Label.label("Lock_tables"), "text", arg.getText());
		onEnter(node);
		this.inLock_tables = true;
	}

	public void exitLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		onExit();
		this.inLock_tables = false;
	}

	protected boolean inUnlock_tables = false;

	@Override
	public void enterUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		final Node node = model.findOrCreate(Label.label("Unlock_tables"), "text", arg.getText());
		onEnter(node);
		this.inUnlock_tables = true;
	}

	public void exitUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		onExit();
		this.inUnlock_tables = false;
	}

	protected boolean inSet_autocommit_statement = false;

	@Override
	public void enterSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Set_autocommit_statement"), "text", arg.getText());
		onEnter(node);
		this.inSet_autocommit_statement = true;
	}

	public void exitSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		onExit();
		this.inSet_autocommit_statement = false;
	}

	protected boolean inSet_transaction_statement = false;

	@Override
	public void enterSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Set_transaction_statement"), "text", arg.getText());
		onEnter(node);
		this.inSet_transaction_statement = true;
	}

	public void exitSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		onExit();
		this.inSet_transaction_statement = false;
	}

	protected boolean inTransact_option = false;

	@Override
	public void enterTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Transact_option"), "text", arg.getText());
		onEnter(node);
		this.inTransact_option = true;
	}

	public void exitTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		onExit();
		this.inTransact_option = false;
	}

	protected boolean inLock_table_element = false;

	@Override
	public void enterLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		final Node node = model.findOrCreate(Label.label("Lock_table_element"), "text", arg.getText());
		onEnter(node);
		this.inLock_table_element = true;
	}

	public void exitLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		onExit();
		this.inLock_table_element = false;
	}

	protected boolean inTrans_characteristic = false;

	@Override
	public void enterTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		final Node node = model.findOrCreate(Label.label("Trans_characteristic"), "text", arg.getText());
		onEnter(node);
		this.inTrans_characteristic = true;
	}

	public void exitTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		onExit();
		this.inTrans_characteristic = false;
	}

	protected boolean inTransaction_level = false;

	@Override
	public void enterTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		final Node node = model.findOrCreate(Label.label("Transaction_level"), "text", arg.getText());
		onEnter(node);
		this.inTransaction_level = true;
	}

	public void exitTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		onExit();
		this.inTransaction_level = false;
	}

	protected boolean inChange_master = false;

	@Override
	public void enterChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		final Node node = model.findOrCreate(Label.label("Change_master"), "text", arg.getText());
		onEnter(node);
		this.inChange_master = true;
	}

	public void exitChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		onExit();
		this.inChange_master = false;
	}

	protected boolean inChange_repl_filter = false;

	@Override
	public void enterChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		final Node node = model.findOrCreate(Label.label("Change_repl_filter"), "text", arg.getText());
		onEnter(node);
		this.inChange_repl_filter = true;
	}

	public void exitChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		onExit();
		this.inChange_repl_filter = false;
	}

	protected boolean inPurge_binary_logs = false;

	@Override
	public void enterPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		final Node node = model.findOrCreate(Label.label("Purge_binary_logs"), "text", arg.getText());
		onEnter(node);
		this.inPurge_binary_logs = true;
	}

	public void exitPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		onExit();
		this.inPurge_binary_logs = false;
	}

	protected boolean inReset_master = false;

	@Override
	public void enterReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		final Node node = model.findOrCreate(Label.label("Reset_master"), "text", arg.getText());
		onEnter(node);
		this.inReset_master = true;
	}

	public void exitReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		onExit();
		this.inReset_master = false;
	}

	protected boolean inReset_slave = false;

	@Override
	public void enterReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		final Node node = model.findOrCreate(Label.label("Reset_slave"), "text", arg.getText());
		onEnter(node);
		this.inReset_slave = true;
	}

	public void exitReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		onExit();
		this.inReset_slave = false;
	}

	protected boolean inStart_slave = false;

	@Override
	public void enterStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		final Node node = model.findOrCreate(Label.label("Start_slave"), "text", arg.getText());
		onEnter(node);
		this.inStart_slave = true;
	}

	public void exitStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		onExit();
		this.inStart_slave = false;
	}

	protected boolean inStop_slave = false;

	@Override
	public void enterStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		final Node node = model.findOrCreate(Label.label("Stop_slave"), "text", arg.getText());
		onEnter(node);
		this.inStop_slave = true;
	}

	public void exitStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		onExit();
		this.inStop_slave = false;
	}

	protected boolean inStart_group_repl = false;

	@Override
	public void enterStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		final Node node = model.findOrCreate(Label.label("Start_group_repl"), "text", arg.getText());
		onEnter(node);
		this.inStart_group_repl = true;
	}

	public void exitStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		onExit();
		this.inStart_group_repl = false;
	}

	protected boolean inStop_group_repl = false;

	@Override
	public void enterStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		final Node node = model.findOrCreate(Label.label("Stop_group_repl"), "text", arg.getText());
		onEnter(node);
		this.inStop_group_repl = true;
	}

	public void exitStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		onExit();
		this.inStop_group_repl = false;
	}

	protected boolean inMasterOptString = false;

	@Override
	public void enterMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		final Node node = model.findOrCreate(Label.label("MasterOptString"), "text", arg.getText());
		onEnter(node);
		this.inMasterOptString = true;
	}

	public void exitMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		onExit();
		this.inMasterOptString = false;
	}

	protected boolean inMasterOptDecimal = false;

	@Override
	public void enterMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		final Node node = model.findOrCreate(Label.label("MasterOptDecimal"), "text", arg.getText());
		onEnter(node);
		this.inMasterOptDecimal = true;
	}

	public void exitMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		onExit();
		this.inMasterOptDecimal = false;
	}

	protected boolean inMasterOptBool = false;

	@Override
	public void enterMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		final Node node = model.findOrCreate(Label.label("MasterOptBool"), "text", arg.getText());
		onEnter(node);
		this.inMasterOptBool = true;
	}

	public void exitMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		onExit();
		this.inMasterOptBool = false;
	}

	protected boolean inMasterOptReal = false;

	@Override
	public void enterMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		final Node node = model.findOrCreate(Label.label("MasterOptReal"), "text", arg.getText());
		onEnter(node);
		this.inMasterOptReal = true;
	}

	public void exitMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		onExit();
		this.inMasterOptReal = false;
	}

	protected boolean inMasterOptIdList = false;

	@Override
	public void enterMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		final Node node = model.findOrCreate(Label.label("MasterOptIdList"), "text", arg.getText());
		onEnter(node);
		this.inMasterOptIdList = true;
	}

	public void exitMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		onExit();
		this.inMasterOptIdList = false;
	}

	protected boolean inString_master_option = false;

	@Override
	public void enterString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("String_master_option"), "text", arg.getText());
		onEnter(node);
		this.inString_master_option = true;
	}

	public void exitString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		onExit();
		this.inString_master_option = false;
	}

	protected boolean inDecimal_master_option = false;

	@Override
	public void enterDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Decimal_master_option"), "text", arg.getText());
		onEnter(node);
		this.inDecimal_master_option = true;
	}

	public void exitDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		onExit();
		this.inDecimal_master_option = false;
	}

	protected boolean inBool_master_option = false;

	@Override
	public void enterBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Bool_master_option"), "text", arg.getText());
		onEnter(node);
		this.inBool_master_option = true;
	}

	public void exitBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		onExit();
		this.inBool_master_option = false;
	}

	protected boolean inChannel_option = false;

	@Override
	public void enterChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Channel_option"), "text", arg.getText());
		onEnter(node);
		this.inChannel_option = true;
	}

	public void exitChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		onExit();
		this.inChannel_option = false;
	}

	protected boolean inReplfilterDbList = false;

	@Override
	public void enterReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		final Node node = model.findOrCreate(Label.label("ReplfilterDbList"), "text", arg.getText());
		onEnter(node);
		this.inReplfilterDbList = true;
	}

	public void exitReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		onExit();
		this.inReplfilterDbList = false;
	}

	protected boolean inReplfilterTableList = false;

	@Override
	public void enterReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		final Node node = model.findOrCreate(Label.label("ReplfilterTableList"), "text", arg.getText());
		onEnter(node);
		this.inReplfilterTableList = true;
	}

	public void exitReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		onExit();
		this.inReplfilterTableList = false;
	}

	protected boolean inReplfilterStableList = false;

	@Override
	public void enterReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		final Node node = model.findOrCreate(Label.label("ReplfilterStableList"), "text", arg.getText());
		onEnter(node);
		this.inReplfilterStableList = true;
	}

	public void exitReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		onExit();
		this.inReplfilterStableList = false;
	}

	protected boolean inReplfilterTablepairList = false;

	@Override
	public void enterReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		final Node node = model.findOrCreate(Label.label("ReplfilterTablepairList"), "text", arg.getText());
		onEnter(node);
		this.inReplfilterTablepairList = true;
	}

	public void exitReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		onExit();
		this.inReplfilterTablepairList = false;
	}

	protected boolean inThread_type = false;

	@Override
	public void enterThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		final Node node = model.findOrCreate(Label.label("Thread_type"), "text", arg.getText());
		onEnter(node);
		this.inThread_type = true;
	}

	public void exitThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		onExit();
		this.inThread_type = false;
	}

	protected boolean inUntilGtidSset = false;

	@Override
	public void enterUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		final Node node = model.findOrCreate(Label.label("UntilGtidSset"), "text", arg.getText());
		onEnter(node);
		this.inUntilGtidSset = true;
	}

	public void exitUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		onExit();
		this.inUntilGtidSset = false;
	}

	protected boolean inUntilMasterLog = false;

	@Override
	public void enterUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		final Node node = model.findOrCreate(Label.label("UntilMasterLog"), "text", arg.getText());
		onEnter(node);
		this.inUntilMasterLog = true;
	}

	public void exitUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		onExit();
		this.inUntilMasterLog = false;
	}

	protected boolean inUntilRelayLog = false;

	@Override
	public void enterUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		final Node node = model.findOrCreate(Label.label("UntilRelayLog"), "text", arg.getText());
		onEnter(node);
		this.inUntilRelayLog = true;
	}

	public void exitUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		onExit();
		this.inUntilRelayLog = false;
	}

	protected boolean inUntilSqlGaps = false;

	@Override
	public void enterUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		final Node node = model.findOrCreate(Label.label("UntilSqlGaps"), "text", arg.getText());
		onEnter(node);
		this.inUntilSqlGaps = true;
	}

	public void exitUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		onExit();
		this.inUntilSqlGaps = false;
	}

	protected boolean inStart_slave_connection_option = false;

	@Override
	public void enterStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Start_slave_connection_option"), "text", arg.getText());
		onEnter(node);
		this.inStart_slave_connection_option = true;
	}

	public void exitStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		onExit();
		this.inStart_slave_connection_option = false;
	}

	protected boolean inGtid_set = false;

	@Override
	public void enterGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		final Node node = model.findOrCreate(Label.label("Gtid_set"), "text", arg.getText());
		onEnter(node);
		this.inGtid_set = true;
	}

	public void exitGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		onExit();
		this.inGtid_set = false;
	}

	protected boolean inXa_start_transaction = false;

	@Override
	public void enterXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		final Node node = model.findOrCreate(Label.label("Xa_start_transaction"), "text", arg.getText());
		onEnter(node);
		this.inXa_start_transaction = true;
	}

	public void exitXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		onExit();
		this.inXa_start_transaction = false;
	}

	protected boolean inXa_end_transaction = false;

	@Override
	public void enterXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		final Node node = model.findOrCreate(Label.label("Xa_end_transaction"), "text", arg.getText());
		onEnter(node);
		this.inXa_end_transaction = true;
	}

	public void exitXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		onExit();
		this.inXa_end_transaction = false;
	}

	protected boolean inXa_prepare = false;

	@Override
	public void enterXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		final Node node = model.findOrCreate(Label.label("Xa_prepare"), "text", arg.getText());
		onEnter(node);
		this.inXa_prepare = true;
	}

	public void exitXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		onExit();
		this.inXa_prepare = false;
	}

	protected boolean inXa_commit_work = false;

	@Override
	public void enterXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		final Node node = model.findOrCreate(Label.label("Xa_commit_work"), "text", arg.getText());
		onEnter(node);
		this.inXa_commit_work = true;
	}

	public void exitXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		onExit();
		this.inXa_commit_work = false;
	}

	protected boolean inXa_rollback_work = false;

	@Override
	public void enterXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		final Node node = model.findOrCreate(Label.label("Xa_rollback_work"), "text", arg.getText());
		onEnter(node);
		this.inXa_rollback_work = true;
	}

	public void exitXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		onExit();
		this.inXa_rollback_work = false;
	}

	protected boolean inXa_recover_work = false;

	@Override
	public void enterXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		final Node node = model.findOrCreate(Label.label("Xa_recover_work"), "text", arg.getText());
		onEnter(node);
		this.inXa_recover_work = true;
	}

	public void exitXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		onExit();
		this.inXa_recover_work = false;
	}

	protected boolean inPrepare_statement = false;

	@Override
	public void enterPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Prepare_statement"), "text", arg.getText());
		onEnter(node);
		this.inPrepare_statement = true;
	}

	public void exitPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		onExit();
		this.inPrepare_statement = false;
	}

	protected boolean inExecute_statement = false;

	@Override
	public void enterExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Execute_statement"), "text", arg.getText());
		onEnter(node);
		this.inExecute_statement = true;
	}

	public void exitExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		onExit();
		this.inExecute_statement = false;
	}

	protected boolean inDeallocate_prepare = false;

	@Override
	public void enterDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		final Node node = model.findOrCreate(Label.label("Deallocate_prepare"), "text", arg.getText());
		onEnter(node);
		this.inDeallocate_prepare = true;
	}

	public void exitDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		onExit();
		this.inDeallocate_prepare = false;
	}

	protected boolean inRoutine_body = false;

	@Override
	public void enterRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		final Node node = model.findOrCreate(Label.label("Routine_body"), "text", arg.getText());
		onEnter(node);
		this.inRoutine_body = true;
	}

	public void exitRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		onExit();
		this.inRoutine_body = false;
	}

	protected boolean inBlock_statement = false;

	@Override
	public void enterBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Block_statement"), "text", arg.getText());
		onEnter(node);
		this.inBlock_statement = true;
	}

	public void exitBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		onExit();
		this.inBlock_statement = false;
	}

	protected boolean inCase_statement = false;

	@Override
	public void enterCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Case_statement"), "text", arg.getText());
		onEnter(node);
		this.inCase_statement = true;
	}

	public void exitCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		onExit();
		this.inCase_statement = false;
	}

	protected boolean inIf_statement = false;

	@Override
	public void enterIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("If_statement"), "text", arg.getText());
		onEnter(node);
		this.inIf_statement = true;
	}

	public void exitIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		onExit();
		this.inIf_statement = false;
	}

	protected boolean inIterate_statement = false;

	@Override
	public void enterIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Iterate_statement"), "text", arg.getText());
		onEnter(node);
		this.inIterate_statement = true;
	}

	public void exitIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		onExit();
		this.inIterate_statement = false;
	}

	protected boolean inLeave_statement = false;

	@Override
	public void enterLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Leave_statement"), "text", arg.getText());
		onEnter(node);
		this.inLeave_statement = true;
	}

	public void exitLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		onExit();
		this.inLeave_statement = false;
	}

	protected boolean inLoop_statement = false;

	@Override
	public void enterLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Loop_statement"), "text", arg.getText());
		onEnter(node);
		this.inLoop_statement = true;
	}

	public void exitLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		onExit();
		this.inLoop_statement = false;
	}

	protected boolean inRepeat_statement = false;

	@Override
	public void enterRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Repeat_statement"), "text", arg.getText());
		onEnter(node);
		this.inRepeat_statement = true;
	}

	public void exitRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		onExit();
		this.inRepeat_statement = false;
	}

	protected boolean inReturn_statement = false;

	@Override
	public void enterReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Return_statement"), "text", arg.getText());
		onEnter(node);
		this.inReturn_statement = true;
	}

	public void exitReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		onExit();
		this.inReturn_statement = false;
	}

	protected boolean inWhile_statement = false;

	@Override
	public void enterWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("While_statement"), "text", arg.getText());
		onEnter(node);
		this.inWhile_statement = true;
	}

	public void exitWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		onExit();
		this.inWhile_statement = false;
	}

	protected boolean inCursor_statement = false;

	@Override
	public void enterCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Cursor_statement"), "text", arg.getText());
		onEnter(node);
		this.inCursor_statement = true;
	}

	public void exitCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		onExit();
		this.inCursor_statement = false;
	}

	protected boolean inDeclare_variable = false;

	@Override
	public void enterDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		final Node node = model.findOrCreate(Label.label("Declare_variable"), "text", arg.getText());
		onEnter(node);
		this.inDeclare_variable = true;
	}

	public void exitDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		onExit();
		this.inDeclare_variable = false;
	}

	protected boolean inDeclare_condition = false;

	@Override
	public void enterDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		final Node node = model.findOrCreate(Label.label("Declare_condition"), "text", arg.getText());
		onEnter(node);
		this.inDeclare_condition = true;
	}

	public void exitDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		onExit();
		this.inDeclare_condition = false;
	}

	protected boolean inDeclare_cursor = false;

	@Override
	public void enterDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		final Node node = model.findOrCreate(Label.label("Declare_cursor"), "text", arg.getText());
		onEnter(node);
		this.inDeclare_cursor = true;
	}

	public void exitDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		onExit();
		this.inDeclare_cursor = false;
	}

	protected boolean inDeclare_handler = false;

	@Override
	public void enterDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		final Node node = model.findOrCreate(Label.label("Declare_handler"), "text", arg.getText());
		onEnter(node);
		this.inDeclare_handler = true;
	}

	public void exitDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		onExit();
		this.inDeclare_handler = false;
	}

	protected boolean inHandler_condition_value = false;

	@Override
	public void enterHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler_condition_value"), "text", arg.getText());
		onEnter(node);
		this.inHandler_condition_value = true;
	}

	public void exitHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		onExit();
		this.inHandler_condition_value = false;
	}

	protected boolean inProcedure_sql_statement = false;

	@Override
	public void enterProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Procedure_sql_statement"), "text", arg.getText());
		onEnter(node);
		this.inProcedure_sql_statement = true;
	}

	public void exitProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		onExit();
		this.inProcedure_sql_statement = false;
	}

	protected boolean inAlterUserMysql56 = false;

	@Override
	public void enterAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		final Node node = model.findOrCreate(Label.label("AlterUserMysql56"), "text", arg.getText());
		onEnter(node);
		this.inAlterUserMysql56 = true;
	}

	public void exitAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		onExit();
		this.inAlterUserMysql56 = false;
	}

	protected boolean inAlterUserMysql57 = false;

	@Override
	public void enterAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		final Node node = model.findOrCreate(Label.label("AlterUserMysql57"), "text", arg.getText());
		onEnter(node);
		this.inAlterUserMysql57 = true;
	}

	public void exitAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		onExit();
		this.inAlterUserMysql57 = false;
	}

	protected boolean inCreateUserMysql56 = false;

	@Override
	public void enterCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		final Node node = model.findOrCreate(Label.label("CreateUserMysql56"), "text", arg.getText());
		onEnter(node);
		this.inCreateUserMysql56 = true;
	}

	public void exitCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		onExit();
		this.inCreateUserMysql56 = false;
	}

	protected boolean inCreateUserMysql57 = false;

	@Override
	public void enterCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		final Node node = model.findOrCreate(Label.label("CreateUserMysql57"), "text", arg.getText());
		onEnter(node);
		this.inCreateUserMysql57 = true;
	}

	public void exitCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		onExit();
		this.inCreateUserMysql57 = false;
	}

	protected boolean inDrop_user = false;

	@Override
	public void enterDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		final Node node = model.findOrCreate(Label.label("Drop_user"), "text", arg.getText());
		onEnter(node);
		this.inDrop_user = true;
	}

	public void exitDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		onExit();
		this.inDrop_user = false;
	}

	protected boolean inGrant_statement = false;

	@Override
	public void enterGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Grant_statement"), "text", arg.getText());
		onEnter(node);
		this.inGrant_statement = true;
	}

	public void exitGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		onExit();
		this.inGrant_statement = false;
	}

	protected boolean inGrant_proxy = false;

	@Override
	public void enterGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		final Node node = model.findOrCreate(Label.label("Grant_proxy"), "text", arg.getText());
		onEnter(node);
		this.inGrant_proxy = true;
	}

	public void exitGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		onExit();
		this.inGrant_proxy = false;
	}

	protected boolean inRename_user = false;

	@Override
	public void enterRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		final Node node = model.findOrCreate(Label.label("Rename_user"), "text", arg.getText());
		onEnter(node);
		this.inRename_user = true;
	}

	public void exitRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		onExit();
		this.inRename_user = false;
	}

	protected boolean inDetailRevoke = false;

	@Override
	public void enterDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		final Node node = model.findOrCreate(Label.label("DetailRevoke"), "text", arg.getText());
		onEnter(node);
		this.inDetailRevoke = true;
	}

	public void exitDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		onExit();
		this.inDetailRevoke = false;
	}

	protected boolean inShortRevoke = false;

	@Override
	public void enterShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		final Node node = model.findOrCreate(Label.label("ShortRevoke"), "text", arg.getText());
		onEnter(node);
		this.inShortRevoke = true;
	}

	public void exitShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		onExit();
		this.inShortRevoke = false;
	}

	protected boolean inRevoke_proxy = false;

	@Override
	public void enterRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		final Node node = model.findOrCreate(Label.label("Revoke_proxy"), "text", arg.getText());
		onEnter(node);
		this.inRevoke_proxy = true;
	}

	public void exitRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		onExit();
		this.inRevoke_proxy = false;
	}

	protected boolean inSet_password_statement = false;

	@Override
	public void enterSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Set_password_statement"), "text", arg.getText());
		onEnter(node);
		this.inSet_password_statement = true;
	}

	public void exitSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		onExit();
		this.inSet_password_statement = false;
	}

	protected boolean inUser_password_option = false;

	@Override
	public void enterUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("User_password_option"), "text", arg.getText());
		onEnter(node);
		this.inUser_password_option = true;
	}

	public void exitUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		onExit();
		this.inUser_password_option = false;
	}

	protected boolean inAuthByPassword = false;

	@Override
	public void enterAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		final Node node = model.findOrCreate(Label.label("AuthByPassword"), "text", arg.getText());
		onEnter(node);
		this.inAuthByPassword = true;
	}

	public void exitAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		onExit();
		this.inAuthByPassword = false;
	}

	protected boolean inAuthByString = false;

	@Override
	public void enterAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		final Node node = model.findOrCreate(Label.label("AuthByString"), "text", arg.getText());
		onEnter(node);
		this.inAuthByString = true;
	}

	public void exitAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		onExit();
		this.inAuthByString = false;
	}

	protected boolean inAuthByHash = false;

	@Override
	public void enterAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		final Node node = model.findOrCreate(Label.label("AuthByHash"), "text", arg.getText());
		onEnter(node);
		this.inAuthByHash = true;
	}

	public void exitAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		onExit();
		this.inAuthByHash = false;
	}

	protected boolean inTls_option = false;

	@Override
	public void enterTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Tls_option"), "text", arg.getText());
		onEnter(node);
		this.inTls_option = true;
	}

	public void exitTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		onExit();
		this.inTls_option = false;
	}

	protected boolean inUser_resource_option = false;

	@Override
	public void enterUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("User_resource_option"), "text", arg.getText());
		onEnter(node);
		this.inUser_resource_option = true;
	}

	public void exitUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		onExit();
		this.inUser_resource_option = false;
	}

	protected boolean inUser_lock_option = false;

	@Override
	public void enterUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("User_lock_option"), "text", arg.getText());
		onEnter(node);
		this.inUser_lock_option = true;
	}

	public void exitUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		onExit();
		this.inUser_lock_option = false;
	}

	protected boolean inPrivelege_clause = false;

	@Override
	public void enterPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Privelege_clause"), "text", arg.getText());
		onEnter(node);
		this.inPrivelege_clause = true;
	}

	public void exitPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		onExit();
		this.inPrivelege_clause = false;
	}

	protected boolean inPrivilege = false;

	@Override
	public void enterPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		final Node node = model.findOrCreate(Label.label("Privilege"), "text", arg.getText());
		onEnter(node);
		this.inPrivilege = true;
	}

	public void exitPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		onExit();
		this.inPrivilege = false;
	}

	protected boolean inPrivilege_level = false;

	@Override
	public void enterPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		final Node node = model.findOrCreate(Label.label("Privilege_level"), "text", arg.getText());
		onEnter(node);
		this.inPrivilege_level = true;
	}

	public void exitPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		onExit();
		this.inPrivilege_level = false;
	}

	protected boolean inSet_password_option = false;

	@Override
	public void enterSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Set_password_option"), "text", arg.getText());
		onEnter(node);
		this.inSet_password_option = true;
	}

	public void exitSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		onExit();
		this.inSet_password_option = false;
	}

	protected boolean inAnalyze_table = false;

	@Override
	public void enterAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Analyze_table"), "text", arg.getText());
		onEnter(node);
		this.inAnalyze_table = true;
	}

	public void exitAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		onExit();
		this.inAnalyze_table = false;
	}

	protected boolean inCheck_table = false;

	@Override
	public void enterCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Check_table"), "text", arg.getText());
		onEnter(node);
		this.inCheck_table = true;
	}

	public void exitCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		onExit();
		this.inCheck_table = false;
	}

	protected boolean inChecksum_table = false;

	@Override
	public void enterChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Checksum_table"), "text", arg.getText());
		onEnter(node);
		this.inChecksum_table = true;
	}

	public void exitChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		onExit();
		this.inChecksum_table = false;
	}

	protected boolean inOptimize_table = false;

	@Override
	public void enterOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Optimize_table"), "text", arg.getText());
		onEnter(node);
		this.inOptimize_table = true;
	}

	public void exitOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		onExit();
		this.inOptimize_table = false;
	}

	protected boolean inRepair_table = false;

	@Override
	public void enterRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		final Node node = model.findOrCreate(Label.label("Repair_table"), "text", arg.getText());
		onEnter(node);
		this.inRepair_table = true;
	}

	public void exitRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		onExit();
		this.inRepair_table = false;
	}

	protected boolean inCheck_table_option = false;

	@Override
	public void enterCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Check_table_option"), "text", arg.getText());
		onEnter(node);
		this.inCheck_table_option = true;
	}

	public void exitCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		onExit();
		this.inCheck_table_option = false;
	}

	protected boolean inCreate_udfunction = false;

	@Override
	public void enterCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		final Node node = model.findOrCreate(Label.label("Create_udfunction"), "text", arg.getText());
		onEnter(node);
		this.inCreate_udfunction = true;
	}

	public void exitCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		onExit();
		this.inCreate_udfunction = false;
	}

	protected boolean inInstall_plugin = false;

	@Override
	public void enterInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		final Node node = model.findOrCreate(Label.label("Install_plugin"), "text", arg.getText());
		onEnter(node);
		this.inInstall_plugin = true;
	}

	public void exitInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		onExit();
		this.inInstall_plugin = false;
	}

	protected boolean inUninstall_plugin = false;

	@Override
	public void enterUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		final Node node = model.findOrCreate(Label.label("Uninstall_plugin"), "text", arg.getText());
		onEnter(node);
		this.inUninstall_plugin = true;
	}

	public void exitUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		onExit();
		this.inUninstall_plugin = false;
	}

	protected boolean inSetVariableAssignment = false;

	@Override
	public void enterSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		final Node node = model.findOrCreate(Label.label("SetVariableAssignment"), "text", arg.getText());
		onEnter(node);
		this.inSetVariableAssignment = true;
	}

	public void exitSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		onExit();
		this.inSetVariableAssignment = false;
	}

	protected boolean inSetCharset = false;

	@Override
	public void enterSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		final Node node = model.findOrCreate(Label.label("SetCharset"), "text", arg.getText());
		onEnter(node);
		this.inSetCharset = true;
	}

	public void exitSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		onExit();
		this.inSetCharset = false;
	}

	protected boolean inSetNames = false;

	@Override
	public void enterSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		final Node node = model.findOrCreate(Label.label("SetNames"), "text", arg.getText());
		onEnter(node);
		this.inSetNames = true;
	}

	public void exitSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		onExit();
		this.inSetNames = false;
	}

	protected boolean inSetPasswordStatement = false;

	@Override
	public void enterSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("SetPasswordStatement"), "text", arg.getText());
		onEnter(node);
		this.inSetPasswordStatement = true;
	}

	public void exitSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		onExit();
		this.inSetPasswordStatement = false;
	}

	protected boolean inSetTransaction = false;

	@Override
	public void enterSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		final Node node = model.findOrCreate(Label.label("SetTransaction"), "text", arg.getText());
		onEnter(node);
		this.inSetTransaction = true;
	}

	public void exitSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		onExit();
		this.inSetTransaction = false;
	}

	protected boolean inSetAutocommit = false;

	@Override
	public void enterSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		final Node node = model.findOrCreate(Label.label("SetAutocommit"), "text", arg.getText());
		onEnter(node);
		this.inSetAutocommit = true;
	}

	public void exitSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		onExit();
		this.inSetAutocommit = false;
	}

	protected boolean inShowMasterlogs = false;

	@Override
	public void enterShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowMasterlogs"), "text", arg.getText());
		onEnter(node);
		this.inShowMasterlogs = true;
	}

	public void exitShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		onExit();
		this.inShowMasterlogs = false;
	}

	protected boolean inShowLogevents = false;

	@Override
	public void enterShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowLogevents"), "text", arg.getText());
		onEnter(node);
		this.inShowLogevents = true;
	}

	public void exitShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		onExit();
		this.inShowLogevents = false;
	}

	protected boolean inShowObjWithFilter = false;

	@Override
	public void enterShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowObjWithFilter"), "text", arg.getText());
		onEnter(node);
		this.inShowObjWithFilter = true;
	}

	public void exitShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		onExit();
		this.inShowObjWithFilter = false;
	}

	protected boolean inShowColumns = false;

	@Override
	public void enterShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowColumns"), "text", arg.getText());
		onEnter(node);
		this.inShowColumns = true;
	}

	public void exitShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		onExit();
		this.inShowColumns = false;
	}

	protected boolean inShowCreateDb = false;

	@Override
	public void enterShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowCreateDb"), "text", arg.getText());
		onEnter(node);
		this.inShowCreateDb = true;
	}

	public void exitShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		onExit();
		this.inShowCreateDb = false;
	}

	protected boolean inShowCreateFullidobj = false;

	@Override
	public void enterShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowCreateFullidobj"), "text", arg.getText());
		onEnter(node);
		this.inShowCreateFullidobj = true;
	}

	public void exitShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		onExit();
		this.inShowCreateFullidobj = false;
	}

	protected boolean inShowCreateUser = false;

	@Override
	public void enterShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowCreateUser"), "text", arg.getText());
		onEnter(node);
		this.inShowCreateUser = true;
	}

	public void exitShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		onExit();
		this.inShowCreateUser = false;
	}

	protected boolean inShowEngine = false;

	@Override
	public void enterShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowEngine"), "text", arg.getText());
		onEnter(node);
		this.inShowEngine = true;
	}

	public void exitShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		onExit();
		this.inShowEngine = false;
	}

	protected boolean inShowGlobalinfo = false;

	@Override
	public void enterShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowGlobalinfo"), "text", arg.getText());
		onEnter(node);
		this.inShowGlobalinfo = true;
	}

	public void exitShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		onExit();
		this.inShowGlobalinfo = false;
	}

	protected boolean inShowErrWarn = false;

	@Override
	public void enterShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowErrWarn"), "text", arg.getText());
		onEnter(node);
		this.inShowErrWarn = true;
	}

	public void exitShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		onExit();
		this.inShowErrWarn = false;
	}

	protected boolean inShowCountErrWarn = false;

	@Override
	public void enterShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowCountErrWarn"), "text", arg.getText());
		onEnter(node);
		this.inShowCountErrWarn = true;
	}

	public void exitShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		onExit();
		this.inShowCountErrWarn = false;
	}

	protected boolean inShowFromschemaFilter = false;

	@Override
	public void enterShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowFromschemaFilter"), "text", arg.getText());
		onEnter(node);
		this.inShowFromschemaFilter = true;
	}

	public void exitShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		onExit();
		this.inShowFromschemaFilter = false;
	}

	protected boolean inShowRoutinecode = false;

	@Override
	public void enterShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowRoutinecode"), "text", arg.getText());
		onEnter(node);
		this.inShowRoutinecode = true;
	}

	public void exitShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		onExit();
		this.inShowRoutinecode = false;
	}

	protected boolean inShowGrants = false;

	@Override
	public void enterShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowGrants"), "text", arg.getText());
		onEnter(node);
		this.inShowGrants = true;
	}

	public void exitShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		onExit();
		this.inShowGrants = false;
	}

	protected boolean inShowIndexes = false;

	@Override
	public void enterShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowIndexes"), "text", arg.getText());
		onEnter(node);
		this.inShowIndexes = true;
	}

	public void exitShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		onExit();
		this.inShowIndexes = false;
	}

	protected boolean inShowOpentables = false;

	@Override
	public void enterShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowOpentables"), "text", arg.getText());
		onEnter(node);
		this.inShowOpentables = true;
	}

	public void exitShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		onExit();
		this.inShowOpentables = false;
	}

	protected boolean inShowProfile = false;

	@Override
	public void enterShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowProfile"), "text", arg.getText());
		onEnter(node);
		this.inShowProfile = true;
	}

	public void exitShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		onExit();
		this.inShowProfile = false;
	}

	protected boolean inShowSlavestatus = false;

	@Override
	public void enterShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		final Node node = model.findOrCreate(Label.label("ShowSlavestatus"), "text", arg.getText());
		onEnter(node);
		this.inShowSlavestatus = true;
	}

	public void exitShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		onExit();
		this.inShowSlavestatus = false;
	}

	protected boolean inVariable_clause = false;

	@Override
	public void enterVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Variable_clause"), "text", arg.getText());
		onEnter(node);
		this.inVariable_clause = true;
	}

	public void exitVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		onExit();
		this.inVariable_clause = false;
	}

	protected boolean inShow_filter = false;

	@Override
	public void enterShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		final Node node = model.findOrCreate(Label.label("Show_filter"), "text", arg.getText());
		onEnter(node);
		this.inShow_filter = true;
	}

	public void exitShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		onExit();
		this.inShow_filter = false;
	}

	protected boolean inShow_profile_type = false;

	@Override
	public void enterShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		final Node node = model.findOrCreate(Label.label("Show_profile_type"), "text", arg.getText());
		onEnter(node);
		this.inShow_profile_type = true;
	}

	public void exitShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		onExit();
		this.inShow_profile_type = false;
	}

	protected boolean inBinlog_statement = false;

	@Override
	public void enterBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Binlog_statement"), "text", arg.getText());
		onEnter(node);
		this.inBinlog_statement = true;
	}

	public void exitBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		onExit();
		this.inBinlog_statement = false;
	}

	protected boolean inCache_index_statement = false;

	@Override
	public void enterCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Cache_index_statement"), "text", arg.getText());
		onEnter(node);
		this.inCache_index_statement = true;
	}

	public void exitCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		onExit();
		this.inCache_index_statement = false;
	}

	protected boolean inFlush_statement = false;

	@Override
	public void enterFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Flush_statement"), "text", arg.getText());
		onEnter(node);
		this.inFlush_statement = true;
	}

	public void exitFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		onExit();
		this.inFlush_statement = false;
	}

	protected boolean inKill_statement = false;

	@Override
	public void enterKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Kill_statement"), "text", arg.getText());
		onEnter(node);
		this.inKill_statement = true;
	}

	public void exitKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		onExit();
		this.inKill_statement = false;
	}

	protected boolean inLoad_index_into_cache = false;

	@Override
	public void enterLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		final Node node = model.findOrCreate(Label.label("Load_index_into_cache"), "text", arg.getText());
		onEnter(node);
		this.inLoad_index_into_cache = true;
	}

	public void exitLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		onExit();
		this.inLoad_index_into_cache = false;
	}

	protected boolean inReset_statement = false;

	@Override
	public void enterReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Reset_statement"), "text", arg.getText());
		onEnter(node);
		this.inReset_statement = true;
	}

	public void exitReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		onExit();
		this.inReset_statement = false;
	}

	protected boolean inShutdown_statement = false;

	@Override
	public void enterShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Shutdown_statement"), "text", arg.getText());
		onEnter(node);
		this.inShutdown_statement = true;
	}

	public void exitShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		onExit();
		this.inShutdown_statement = false;
	}

	protected boolean inTbl_index_list = false;

	@Override
	public void enterTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Tbl_index_list"), "text", arg.getText());
		onEnter(node);
		this.inTbl_index_list = true;
	}

	public void exitTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		onExit();
		this.inTbl_index_list = false;
	}

	protected boolean inFlush_option = false;

	@Override
	public void enterFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		final Node node = model.findOrCreate(Label.label("Flush_option"), "text", arg.getText());
		onEnter(node);
		this.inFlush_option = true;
	}

	public void exitFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		onExit();
		this.inFlush_option = false;
	}

	protected boolean inLoad_tbl_index_list = false;

	@Override
	public void enterLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Load_tbl_index_list"), "text", arg.getText());
		onEnter(node);
		this.inLoad_tbl_index_list = true;
	}

	public void exitLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		onExit();
		this.inLoad_tbl_index_list = false;
	}

	protected boolean inSimple_describe_statement = false;

	@Override
	public void enterSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Simple_describe_statement"), "text", arg.getText());
		onEnter(node);
		this.inSimple_describe_statement = true;
	}

	public void exitSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		onExit();
		this.inSimple_describe_statement = false;
	}

	protected boolean inFull_describe_statement = false;

	@Override
	public void enterFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Full_describe_statement"), "text", arg.getText());
		onEnter(node);
		this.inFull_describe_statement = true;
	}

	public void exitFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		onExit();
		this.inFull_describe_statement = false;
	}

	protected boolean inHelp_statement = false;

	@Override
	public void enterHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Help_statement"), "text", arg.getText());
		onEnter(node);
		this.inHelp_statement = true;
	}

	public void exitHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		onExit();
		this.inHelp_statement = false;
	}

	protected boolean inUse_statement = false;

	@Override
	public void enterUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		final Node node = model.findOrCreate(Label.label("Use_statement"), "text", arg.getText());
		onEnter(node);
		this.inUse_statement = true;
	}

	public void exitUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		onExit();
		this.inUse_statement = false;
	}

	protected boolean inDescstmtDescObj = false;

	@Override
	public void enterDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		final Node node = model.findOrCreate(Label.label("DescstmtDescObj"), "text", arg.getText());
		onEnter(node);
		this.inDescstmtDescObj = true;
	}

	public void exitDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		onExit();
		this.inDescstmtDescObj = false;
	}

	protected boolean inConnectionDescObj = false;

	@Override
	public void enterConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		final Node node = model.findOrCreate(Label.label("ConnectionDescObj"), "text", arg.getText());
		onEnter(node);
		this.inConnectionDescObj = true;
	}

	public void exitConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		onExit();
		this.inConnectionDescObj = false;
	}

	protected boolean inTable_name = false;

	@Override
	public void enterTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Table_name"), "text", arg.getText());
		onEnter(node);
		this.inTable_name = true;
	}

	public void exitTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		onExit();
		this.inTable_name = false;
	}

	protected boolean inFull_id = false;

	@Override
	public void enterFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		final Node node = model.findOrCreate(Label.label("Full_id"), "text", arg.getText());
		onEnter(node);
		this.inFull_id = true;
	}

	public void exitFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		onExit();
		this.inFull_id = false;
	}

	protected boolean inFull_column_name = false;

	@Override
	public void enterFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Full_column_name"), "text", arg.getText());
		onEnter(node);
		this.inFull_column_name = true;
	}

	public void exitFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		onExit();
		this.inFull_column_name = false;
	}

	protected boolean inIndex_col_name = false;

	@Override
	public void enterIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Index_col_name"), "text", arg.getText());
		onEnter(node);
		this.inIndex_col_name = true;
	}

	public void exitIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		onExit();
		this.inIndex_col_name = false;
	}

	protected boolean inUser_name = false;

	@Override
	public void enterUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("User_name"), "text", arg.getText());
		onEnter(node);
		this.inUser_name = true;
	}

	public void exitUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		onExit();
		this.inUser_name = false;
	}

	protected boolean inMysql_variable = false;

	@Override
	public void enterMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		final Node node = model.findOrCreate(Label.label("Mysql_variable"), "text", arg.getText());
		onEnter(node);
		this.inMysql_variable = true;
	}

	public void exitMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		onExit();
		this.inMysql_variable = false;
	}

	protected boolean inCharset_name = false;

	@Override
	public void enterCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Charset_name"), "text", arg.getText());
		onEnter(node);
		this.inCharset_name = true;
	}

	public void exitCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		onExit();
		this.inCharset_name = false;
	}

	protected boolean inCollation_name = false;

	@Override
	public void enterCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Collation_name"), "text", arg.getText());
		onEnter(node);
		this.inCollation_name = true;
	}

	public void exitCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		onExit();
		this.inCollation_name = false;
	}

	protected boolean inEngine_name = false;

	@Override
	public void enterEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Engine_name"), "text", arg.getText());
		onEnter(node);
		this.inEngine_name = true;
	}

	public void exitEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		onExit();
		this.inEngine_name = false;
	}

	protected boolean inUuid_set = false;

	@Override
	public void enterUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		final Node node = model.findOrCreate(Label.label("Uuid_set"), "text", arg.getText());
		onEnter(node);
		this.inUuid_set = true;
	}

	public void exitUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		onExit();
		this.inUuid_set = false;
	}

	protected boolean inXid = false;

	@Override
	public void enterXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		final Node node = model.findOrCreate(Label.label("Xid"), "text", arg.getText());
		onEnter(node);
		this.inXid = true;
	}

	public void exitXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		onExit();
		this.inXid = false;
	}

	protected boolean inXid_string_id = false;

	@Override
	public void enterXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		final Node node = model.findOrCreate(Label.label("Xid_string_id"), "text", arg.getText());
		onEnter(node);
		this.inXid_string_id = true;
	}

	public void exitXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		onExit();
		this.inXid_string_id = false;
	}

	protected boolean inAuth_plugin = false;

	@Override
	public void enterAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		final Node node = model.findOrCreate(Label.label("Auth_plugin"), "text", arg.getText());
		onEnter(node);
		this.inAuth_plugin = true;
	}

	public void exitAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		onExit();
		this.inAuth_plugin = false;
	}

	protected boolean inId_ = false;

	@Override
	public void enterId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		final Node node = model.findOrCreate(Label.label("Id_"), "text", arg.getText());
		onEnter(node);
		this.inId_ = true;
	}

	public void exitId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		onExit();
		this.inId_ = false;
	}

	protected boolean inSimple_id = false;

	@Override
	public void enterSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		final Node node = model.findOrCreate(Label.label("Simple_id"), "text", arg.getText());
		onEnter(node);
		this.inSimple_id = true;
	}

	public void exitSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		onExit();
		this.inSimple_id = false;
	}

	protected boolean inDot_ext_id = false;

	@Override
	public void enterDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		final Node node = model.findOrCreate(Label.label("Dot_ext_id"), "text", arg.getText());
		onEnter(node);
		this.inDot_ext_id = true;
	}

	public void exitDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		onExit();
		this.inDot_ext_id = false;
	}

	protected boolean inDecimal_literal = false;

	@Override
	public void enterDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		final Node node = model.findOrCreate(Label.label("Decimal_literal"), "text", arg.getText());
		onEnter(node);
		this.inDecimal_literal = true;
	}

	public void exitDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		onExit();
		this.inDecimal_literal = false;
	}

	protected boolean inFilesize_literal = false;

	@Override
	public void enterFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		final Node node = model.findOrCreate(Label.label("Filesize_literal"), "text", arg.getText());
		onEnter(node);
		this.inFilesize_literal = true;
	}

	public void exitFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		onExit();
		this.inFilesize_literal = false;
	}

	protected boolean inString_literal = false;

	@Override
	public void enterString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		final Node node = model.findOrCreate(Label.label("String_literal"), "text", arg.getText());
		onEnter(node);
		this.inString_literal = true;
	}

	public void exitString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		onExit();
		this.inString_literal = false;
	}

	protected boolean inBoolean_literal = false;

	@Override
	public void enterBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		final Node node = model.findOrCreate(Label.label("Boolean_literal"), "text", arg.getText());
		onEnter(node);
		this.inBoolean_literal = true;
	}

	public void exitBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		onExit();
		this.inBoolean_literal = false;
	}

	protected boolean inHexadecimal_literal = false;

	@Override
	public void enterHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		final Node node = model.findOrCreate(Label.label("Hexadecimal_literal"), "text", arg.getText());
		onEnter(node);
		this.inHexadecimal_literal = true;
	}

	public void exitHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		onExit();
		this.inHexadecimal_literal = false;
	}

	protected boolean inNull_notnull = false;

	@Override
	public void enterNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		final Node node = model.findOrCreate(Label.label("Null_notnull"), "text", arg.getText());
		onEnter(node);
		this.inNull_notnull = true;
	}

	public void exitNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		onExit();
		this.inNull_notnull = false;
	}

	protected boolean inConstant = false;

	@Override
	public void enterConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		final Node node = model.findOrCreate(Label.label("Constant"), "text", arg.getText());
		onEnter(node);
		this.inConstant = true;
	}

	public void exitConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		onExit();
		this.inConstant = false;
	}

	protected boolean inCharDatatype = false;

	@Override
	public void enterCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		final Node node = model.findOrCreate(Label.label("CharDatatype"), "text", arg.getText());
		onEnter(node);
		this.inCharDatatype = true;
	}

	public void exitCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		onExit();
		this.inCharDatatype = false;
	}

	protected boolean inDimensionDatatype = false;

	@Override
	public void enterDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		final Node node = model.findOrCreate(Label.label("DimensionDatatype"), "text", arg.getText());
		onEnter(node);
		this.inDimensionDatatype = true;
	}

	public void exitDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		onExit();
		this.inDimensionDatatype = false;
	}

	protected boolean inSimpleDatatype = false;

	@Override
	public void enterSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		final Node node = model.findOrCreate(Label.label("SimpleDatatype"), "text", arg.getText());
		onEnter(node);
		this.inSimpleDatatype = true;
	}

	public void exitSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		onExit();
		this.inSimpleDatatype = false;
	}

	protected boolean inCollectCharDatatype = false;

	@Override
	public void enterCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		final Node node = model.findOrCreate(Label.label("CollectCharDatatype"), "text", arg.getText());
		onEnter(node);
		this.inCollectCharDatatype = true;
	}

	public void exitCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		onExit();
		this.inCollectCharDatatype = false;
	}

	protected boolean inSpatialDatatype = false;

	@Override
	public void enterSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		final Node node = model.findOrCreate(Label.label("SpatialDatatype"), "text", arg.getText());
		onEnter(node);
		this.inSpatialDatatype = true;
	}

	public void exitSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		onExit();
		this.inSpatialDatatype = false;
	}

	protected boolean inData_type_to_convert = false;

	@Override
	public void enterData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		final Node node = model.findOrCreate(Label.label("Data_type_to_convert"), "text", arg.getText());
		onEnter(node);
		this.inData_type_to_convert = true;
	}

	public void exitData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		onExit();
		this.inData_type_to_convert = false;
	}

	protected boolean inSpatial_data_type = false;

	@Override
	public void enterSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		final Node node = model.findOrCreate(Label.label("Spatial_data_type"), "text", arg.getText());
		onEnter(node);
		this.inSpatial_data_type = true;
	}

	public void exitSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		onExit();
		this.inSpatial_data_type = false;
	}

	protected boolean inLength_one_dimension = false;

	@Override
	public void enterLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		final Node node = model.findOrCreate(Label.label("Length_one_dimension"), "text", arg.getText());
		onEnter(node);
		this.inLength_one_dimension = true;
	}

	public void exitLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		onExit();
		this.inLength_one_dimension = false;
	}

	protected boolean inLength_two_dimension = false;

	@Override
	public void enterLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		final Node node = model.findOrCreate(Label.label("Length_two_dimension"), "text", arg.getText());
		onEnter(node);
		this.inLength_two_dimension = true;
	}

	public void exitLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		onExit();
		this.inLength_two_dimension = false;
	}

	protected boolean inLength_two_optional_dimension = false;

	@Override
	public void enterLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		final Node node = model.findOrCreate(Label.label("Length_two_optional_dimension"), "text", arg.getText());
		onEnter(node);
		this.inLength_two_optional_dimension = true;
	}

	public void exitLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		onExit();
		this.inLength_two_optional_dimension = false;
	}

	protected boolean inId_list = false;

	@Override
	public void enterId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Id_list"), "text", arg.getText());
		onEnter(node);
		this.inId_list = true;
	}

	public void exitId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		onExit();
		this.inId_list = false;
	}

	protected boolean inTable_list = false;

	@Override
	public void enterTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Table_list"), "text", arg.getText());
		onEnter(node);
		this.inTable_list = true;
	}

	public void exitTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		onExit();
		this.inTable_list = false;
	}

	protected boolean inTable_pair_list = false;

	@Override
	public void enterTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Table_pair_list"), "text", arg.getText());
		onEnter(node);
		this.inTable_pair_list = true;
	}

	public void exitTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		onExit();
		this.inTable_pair_list = false;
	}

	protected boolean inIndex_colname_list = false;

	@Override
	public void enterIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Index_colname_list"), "text", arg.getText());
		onEnter(node);
		this.inIndex_colname_list = true;
	}

	public void exitIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		onExit();
		this.inIndex_colname_list = false;
	}

	protected boolean inExpression_list = false;

	@Override
	public void enterExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression_list"), "text", arg.getText());
		onEnter(node);
		this.inExpression_list = true;
	}

	public void exitExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		onExit();
		this.inExpression_list = false;
	}

	protected boolean inConstant_list = false;

	@Override
	public void enterConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Constant_list"), "text", arg.getText());
		onEnter(node);
		this.inConstant_list = true;
	}

	public void exitConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		onExit();
		this.inConstant_list = false;
	}

	protected boolean inSimple_string_list = false;

	@Override
	public void enterSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		final Node node = model.findOrCreate(Label.label("Simple_string_list"), "text", arg.getText());
		onEnter(node);
		this.inSimple_string_list = true;
	}

	public void exitSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		onExit();
		this.inSimple_string_list = false;
	}

	protected boolean inUser_var_list = false;

	@Override
	public void enterUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		final Node node = model.findOrCreate(Label.label("User_var_list"), "text", arg.getText());
		onEnter(node);
		this.inUser_var_list = true;
	}

	public void exitUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		onExit();
		this.inUser_var_list = false;
	}

	protected boolean inDefault_value = false;

	@Override
	public void enterDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		final Node node = model.findOrCreate(Label.label("Default_value"), "text", arg.getText());
		onEnter(node);
		this.inDefault_value = true;
	}

	public void exitDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		onExit();
		this.inDefault_value = false;
	}

	protected boolean inIf_exists = false;

	@Override
	public void enterIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		final Node node = model.findOrCreate(Label.label("If_exists"), "text", arg.getText());
		onEnter(node);
		this.inIf_exists = true;
	}

	public void exitIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		onExit();
		this.inIf_exists = false;
	}

	protected boolean inIf_not_exists = false;

	@Override
	public void enterIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		final Node node = model.findOrCreate(Label.label("If_not_exists"), "text", arg.getText());
		onEnter(node);
		this.inIf_not_exists = true;
	}

	public void exitIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		onExit();
		this.inIf_not_exists = false;
	}

	protected boolean inSpecificFunctionCall = false;

	@Override
	public void enterSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		final Node node = model.findOrCreate(Label.label("SpecificFunctionCall"), "text", arg.getText());
		onEnter(node);
		this.inSpecificFunctionCall = true;
	}

	public void exitSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		onExit();
		this.inSpecificFunctionCall = false;
	}

	protected boolean inAggregateFunctionCall = false;

	@Override
	public void enterAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		final Node node = model.findOrCreate(Label.label("AggregateFunctionCall"), "text", arg.getText());
		onEnter(node);
		this.inAggregateFunctionCall = true;
	}

	public void exitAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		onExit();
		this.inAggregateFunctionCall = false;
	}

	protected boolean inScalarFunctionCall = false;

	@Override
	public void enterScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		final Node node = model.findOrCreate(Label.label("ScalarFunctionCall"), "text", arg.getText());
		onEnter(node);
		this.inScalarFunctionCall = true;
	}

	public void exitScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		onExit();
		this.inScalarFunctionCall = false;
	}

	protected boolean inUdfFunctionCall = false;

	@Override
	public void enterUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		final Node node = model.findOrCreate(Label.label("UdfFunctionCall"), "text", arg.getText());
		onEnter(node);
		this.inUdfFunctionCall = true;
	}

	public void exitUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		onExit();
		this.inUdfFunctionCall = false;
	}

	protected boolean inSimpleSpecificFCall = false;

	@Override
	public void enterSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("SimpleSpecificFCall"), "text", arg.getText());
		onEnter(node);
		this.inSimpleSpecificFCall = true;
	}

	public void exitSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		onExit();
		this.inSimpleSpecificFCall = false;
	}

	protected boolean inConvertDataTypeFCall = false;

	@Override
	public void enterConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("ConvertDataTypeFCall"), "text", arg.getText());
		onEnter(node);
		this.inConvertDataTypeFCall = true;
	}

	public void exitConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		onExit();
		this.inConvertDataTypeFCall = false;
	}

	protected boolean inValuesFCall = false;

	@Override
	public void enterValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("ValuesFCall"), "text", arg.getText());
		onEnter(node);
		this.inValuesFCall = true;
	}

	public void exitValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		onExit();
		this.inValuesFCall = false;
	}

	protected boolean inCaseFCall = false;

	@Override
	public void enterCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("CaseFCall"), "text", arg.getText());
		onEnter(node);
		this.inCaseFCall = true;
	}

	public void exitCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		onExit();
		this.inCaseFCall = false;
	}

	protected boolean inCharFCall = false;

	@Override
	public void enterCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("CharFCall"), "text", arg.getText());
		onEnter(node);
		this.inCharFCall = true;
	}

	public void exitCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		onExit();
		this.inCharFCall = false;
	}

	protected boolean inPositionFCall = false;

	@Override
	public void enterPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("PositionFCall"), "text", arg.getText());
		onEnter(node);
		this.inPositionFCall = true;
	}

	public void exitPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		onExit();
		this.inPositionFCall = false;
	}

	protected boolean inSubstrFCall = false;

	@Override
	public void enterSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("SubstrFCall"), "text", arg.getText());
		onEnter(node);
		this.inSubstrFCall = true;
	}

	public void exitSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		onExit();
		this.inSubstrFCall = false;
	}

	protected boolean inTrimFCall = false;

	@Override
	public void enterTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("TrimFCall"), "text", arg.getText());
		onEnter(node);
		this.inTrimFCall = true;
	}

	public void exitTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		onExit();
		this.inTrimFCall = false;
	}

	protected boolean inWeightFCall = false;

	@Override
	public void enterWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("WeightFCall"), "text", arg.getText());
		onEnter(node);
		this.inWeightFCall = true;
	}

	public void exitWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		onExit();
		this.inWeightFCall = false;
	}

	protected boolean inExtractFCall = false;

	@Override
	public void enterExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("ExtractFCall"), "text", arg.getText());
		onEnter(node);
		this.inExtractFCall = true;
	}

	public void exitExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		onExit();
		this.inExtractFCall = false;
	}

	protected boolean inGetFormatFCall = false;

	@Override
	public void enterGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		final Node node = model.findOrCreate(Label.label("GetFormatFCall"), "text", arg.getText());
		onEnter(node);
		this.inGetFormatFCall = true;
	}

	public void exitGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		onExit();
		this.inGetFormatFCall = false;
	}

	protected boolean inLevelWeightFList = false;

	@Override
	public void enterLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		final Node node = model.findOrCreate(Label.label("LevelWeightFList"), "text", arg.getText());
		onEnter(node);
		this.inLevelWeightFList = true;
	}

	public void exitLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		onExit();
		this.inLevelWeightFList = false;
	}

	protected boolean inLevelWeightFRange = false;

	@Override
	public void enterLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		final Node node = model.findOrCreate(Label.label("LevelWeightFRange"), "text", arg.getText());
		onEnter(node);
		this.inLevelWeightFRange = true;
	}

	public void exitLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		onExit();
		this.inLevelWeightFRange = false;
	}

	protected boolean inAggregate_windowed_function = false;

	@Override
	public void enterAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		final Node node = model.findOrCreate(Label.label("Aggregate_windowed_function"), "text", arg.getText());
		onEnter(node);
		this.inAggregate_windowed_function = true;
	}

	public void exitAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		onExit();
		this.inAggregate_windowed_function = false;
	}

	protected boolean inScalar_function_name = false;

	@Override
	public void enterScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Scalar_function_name"), "text", arg.getText());
		onEnter(node);
		this.inScalar_function_name = true;
	}

	public void exitScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		onExit();
		this.inScalar_function_name = false;
	}

	protected boolean inFunction_args = false;

	@Override
	public void enterFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		final Node node = model.findOrCreate(Label.label("Function_args"), "text", arg.getText());
		onEnter(node);
		this.inFunction_args = true;
	}

	public void exitFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		onExit();
		this.inFunction_args = false;
	}

	protected boolean inFunction_arg = false;

	@Override
	public void enterFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		final Node node = model.findOrCreate(Label.label("Function_arg"), "text", arg.getText());
		onEnter(node);
		this.inFunction_arg = true;
	}

	public void exitFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		onExit();
		this.inFunction_arg = false;
	}

	protected boolean inIsExpression = false;

	@Override
	public void enterIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("IsExpression"), "text", arg.getText());
		onEnter(node);
		this.inIsExpression = true;
	}

	public void exitIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		onExit();
		this.inIsExpression = false;
	}

	protected boolean inLogicalExpression = false;

	@Override
	public void enterLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("LogicalExpression"), "text", arg.getText());
		onEnter(node);
		this.inLogicalExpression = true;
	}

	public void exitLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		onExit();
		this.inLogicalExpression = false;
	}

	protected boolean inPredicateExpression = false;

	@Override
	public void enterPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("PredicateExpression"), "text", arg.getText());
		onEnter(node);
		this.inPredicateExpression = true;
	}

	public void exitPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		onExit();
		this.inPredicateExpression = false;
	}

	protected boolean inSoundsLikePredicate = false;

	@Override
	public void enterSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("SoundsLikePredicate"), "text", arg.getText());
		onEnter(node);
		this.inSoundsLikePredicate = true;
	}

	public void exitSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		onExit();
		this.inSoundsLikePredicate = false;
	}

	protected boolean inExpressionAtomPredicate = false;

	@Override
	public void enterExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("ExpressionAtomPredicate"), "text", arg.getText());
		onEnter(node);
		this.inExpressionAtomPredicate = true;
	}

	public void exitExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		onExit();
		this.inExpressionAtomPredicate = false;
	}

	protected boolean inInPredicate = false;

	@Override
	public void enterInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("InPredicate"), "text", arg.getText());
		onEnter(node);
		this.inInPredicate = true;
	}

	public void exitInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		onExit();
		this.inInPredicate = false;
	}

	protected boolean inSubqueryComparasionPredicate = false;

	@Override
	public void enterSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("SubqueryComparasionPredicate"), "text", arg.getText());
		onEnter(node);
		this.inSubqueryComparasionPredicate = true;
	}

	public void exitSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		onExit();
		this.inSubqueryComparasionPredicate = false;
	}

	protected boolean inBetweenPredicate = false;

	@Override
	public void enterBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("BetweenPredicate"), "text", arg.getText());
		onEnter(node);
		this.inBetweenPredicate = true;
	}

	public void exitBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		onExit();
		this.inBetweenPredicate = false;
	}

	protected boolean inBinaryComparasionPredicate = false;

	@Override
	public void enterBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("BinaryComparasionPredicate"), "text", arg.getText());
		onEnter(node);
		this.inBinaryComparasionPredicate = true;
	}

	public void exitBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		onExit();
		this.inBinaryComparasionPredicate = false;
	}

	protected boolean inIsNullPredicate = false;

	@Override
	public void enterIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("IsNullPredicate"), "text", arg.getText());
		onEnter(node);
		this.inIsNullPredicate = true;
	}

	public void exitIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		onExit();
		this.inIsNullPredicate = false;
	}

	protected boolean inLikePredicate = false;

	@Override
	public void enterLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("LikePredicate"), "text", arg.getText());
		onEnter(node);
		this.inLikePredicate = true;
	}

	public void exitLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		onExit();
		this.inLikePredicate = false;
	}

	protected boolean inRegexpPredicate = false;

	@Override
	public void enterRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		final Node node = model.findOrCreate(Label.label("RegexpPredicate"), "text", arg.getText());
		onEnter(node);
		this.inRegexpPredicate = true;
	}

	public void exitRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		onExit();
		this.inRegexpPredicate = false;
	}

	protected boolean inUnaryExpressionAtom = false;

	@Override
	public void enterUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("UnaryExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inUnaryExpressionAtom = true;
	}

	public void exitUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		onExit();
		this.inUnaryExpressionAtom = false;
	}

	protected boolean inExistsExpessionAtom = false;

	@Override
	public void enterExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("ExistsExpessionAtom"), "text", arg.getText());
		onEnter(node);
		this.inExistsExpessionAtom = true;
	}

	public void exitExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		onExit();
		this.inExistsExpessionAtom = false;
	}

	protected boolean inConstantExpressionAtom = false;

	@Override
	public void enterConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstantExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inConstantExpressionAtom = true;
	}

	public void exitConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		onExit();
		this.inConstantExpressionAtom = false;
	}

	protected boolean inFunctionCallExpressionAtom = false;

	@Override
	public void enterFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionCallExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inFunctionCallExpressionAtom = true;
	}

	public void exitFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		onExit();
		this.inFunctionCallExpressionAtom = false;
	}

	protected boolean inMysqlVariableExpressionAtom = false;

	@Override
	public void enterMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("MysqlVariableExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inMysqlVariableExpressionAtom = true;
	}

	public void exitMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		onExit();
		this.inMysqlVariableExpressionAtom = false;
	}

	protected boolean inBinaryExpressionAtom = false;

	@Override
	public void enterBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("BinaryExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inBinaryExpressionAtom = true;
	}

	public void exitBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		onExit();
		this.inBinaryExpressionAtom = false;
	}

	protected boolean inFullColumnNameExpressionAtom = false;

	@Override
	public void enterFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("FullColumnNameExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inFullColumnNameExpressionAtom = true;
	}

	public void exitFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		onExit();
		this.inFullColumnNameExpressionAtom = false;
	}

	protected boolean inDefaultExpressionAtom = false;

	@Override
	public void enterDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("DefaultExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inDefaultExpressionAtom = true;
	}

	public void exitDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		onExit();
		this.inDefaultExpressionAtom = false;
	}

	protected boolean inBitExpressionAtom = false;

	@Override
	public void enterBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("BitExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inBitExpressionAtom = true;
	}

	public void exitBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		onExit();
		this.inBitExpressionAtom = false;
	}

	protected boolean inNestedExpressionAtom = false;

	@Override
	public void enterNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("NestedExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inNestedExpressionAtom = true;
	}

	public void exitNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		onExit();
		this.inNestedExpressionAtom = false;
	}

	protected boolean inMathExpressionAtom = false;

	@Override
	public void enterMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("MathExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inMathExpressionAtom = true;
	}

	public void exitMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		onExit();
		this.inMathExpressionAtom = false;
	}

	protected boolean inIntervalExpressionAtom = false;

	@Override
	public void enterIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("IntervalExpressionAtom"), "text", arg.getText());
		onEnter(node);
		this.inIntervalExpressionAtom = true;
	}

	public void exitIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		onExit();
		this.inIntervalExpressionAtom = false;
	}

	protected boolean inUnary_operator = false;

	@Override
	public void enterUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Unary_operator"), "text", arg.getText());
		onEnter(node);
		this.inUnary_operator = true;
	}

	public void exitUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		onExit();
		this.inUnary_operator = false;
	}

	protected boolean inComparison_operator = false;

	@Override
	public void enterComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Comparison_operator"), "text", arg.getText());
		onEnter(node);
		this.inComparison_operator = true;
	}

	public void exitComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		onExit();
		this.inComparison_operator = false;
	}

	protected boolean inLogical_operator = false;

	@Override
	public void enterLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Logical_operator"), "text", arg.getText());
		onEnter(node);
		this.inLogical_operator = true;
	}

	public void exitLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		onExit();
		this.inLogical_operator = false;
	}

	protected boolean inBit_operator = false;

	@Override
	public void enterBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Bit_operator"), "text", arg.getText());
		onEnter(node);
		this.inBit_operator = true;
	}

	public void exitBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		onExit();
		this.inBit_operator = false;
	}

	protected boolean inMath_operator = false;

	@Override
	public void enterMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Math_operator"), "text", arg.getText());
		onEnter(node);
		this.inMath_operator = true;
	}

	public void exitMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		onExit();
		this.inMath_operator = false;
	}

	protected boolean inCharset_name_base = false;

	@Override
	public void enterCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		final Node node = model.findOrCreate(Label.label("Charset_name_base"), "text", arg.getText());
		onEnter(node);
		this.inCharset_name_base = true;
	}

	public void exitCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		onExit();
		this.inCharset_name_base = false;
	}

	protected boolean inTransaction_level_base = false;

	@Override
	public void enterTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		final Node node = model.findOrCreate(Label.label("Transaction_level_base"), "text", arg.getText());
		onEnter(node);
		this.inTransaction_level_base = true;
	}

	public void exitTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		onExit();
		this.inTransaction_level_base = false;
	}

	protected boolean inPrivileges_base = false;

	@Override
	public void enterPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		final Node node = model.findOrCreate(Label.label("Privileges_base"), "text", arg.getText());
		onEnter(node);
		this.inPrivileges_base = true;
	}

	public void exitPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		onExit();
		this.inPrivileges_base = false;
	}

	protected boolean inInterval_type_base = false;

	@Override
	public void enterInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		final Node node = model.findOrCreate(Label.label("Interval_type_base"), "text", arg.getText());
		onEnter(node);
		this.inInterval_type_base = true;
	}

	public void exitInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		onExit();
		this.inInterval_type_base = false;
	}

	protected boolean inData_type_base = false;

	@Override
	public void enterData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		final Node node = model.findOrCreate(Label.label("Data_type_base"), "text", arg.getText());
		onEnter(node);
		this.inData_type_base = true;
	}

	public void exitData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		onExit();
		this.inData_type_base = false;
	}

	protected boolean inKeywords_can_be_id = false;

	@Override
	public void enterKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		final Node node = model.findOrCreate(Label.label("Keywords_can_be_id"), "text", arg.getText());
		onEnter(node);
		this.inKeywords_can_be_id = true;
	}

	public void exitKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		onExit();
		this.inKeywords_can_be_id = false;
	}

	protected boolean inFunction_name_base = false;

	@Override
	public void enterFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		final Node node = model.findOrCreate(Label.label("Function_name_base"), "text", arg.getText());
		onEnter(node);
		this.inFunction_name_base = true;
	}

	public void exitFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		onExit();
		this.inFunction_name_base = false;
	}

}