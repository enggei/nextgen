package com.generator.generators.mysql.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class MySqlParserNeoListener extends MySqlParserBaseListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MySqlParserNeoListener.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public MySqlParserNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public MySqlParserNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) log.debug(delim.toString() + node.getProperty("text"));
		delim.append("\t");
   }

   protected void onExit() {
      if (nodeStack.size() > 1) {
			nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
		}
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	protected java.util.Stack<Boolean> inCreate_index = new java.util.Stack<>();

	@Override
	public void enterCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		final Node node = model.newNode(Label.label("Create_index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_index.push(true);
	}

	public void exitCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		onExit();
		this.inCreate_index.pop();
	}

	public boolean inCreate_index() {
      return !inCreate_index.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_logfile_group = new java.util.Stack<>();

	@Override
	public void enterCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		final Node node = model.newNode(Label.label("Create_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_logfile_group.push(true);
	}

	public void exitCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		onExit();
		this.inCreate_logfile_group.pop();
	}

	public boolean inCreate_logfile_group() {
      return !inCreate_logfile_group.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_procedure = new java.util.Stack<>();

	@Override
	public void enterCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		final Node node = model.newNode(Label.label("Create_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_procedure.push(true);
	}

	public void exitCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		onExit();
		this.inCreate_procedure.pop();
	}

	public boolean inCreate_procedure() {
      return !inCreate_procedure.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_function = new java.util.Stack<>();

	@Override
	public void enterCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		final Node node = model.newNode(Label.label("Create_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_function.push(true);
	}

	public void exitCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		onExit();
		this.inCreate_function.pop();
	}

	public boolean inCreate_function() {
      return !inCreate_function.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_server = new java.util.Stack<>();

	@Override
	public void enterCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		final Node node = model.newNode(Label.label("Create_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_server.push(true);
	}

	public void exitCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		onExit();
		this.inCreate_server.pop();
	}

	public boolean inCreate_server() {
      return !inCreate_server.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCopyCreateTable = new java.util.Stack<>();

	@Override
	public void enterCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		final Node node = model.newNode(Label.label("CopyCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCopyCreateTable.push(true);
	}

	public void exitCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		onExit();
		this.inCopyCreateTable.pop();
	}

	public boolean inCopyCreateTable() {
      return !inCopyCreateTable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQueryCreateTable = new java.util.Stack<>();

	@Override
	public void enterQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		final Node node = model.newNode(Label.label("QueryCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQueryCreateTable.push(true);
	}

	public void exitQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		onExit();
		this.inQueryCreateTable.pop();
	}

	public boolean inQueryCreateTable() {
      return !inQueryCreateTable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColCreateTable = new java.util.Stack<>();

	@Override
	public void enterColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		final Node node = model.newNode(Label.label("ColCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColCreateTable.push(true);
	}

	public void exitColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		onExit();
		this.inColCreateTable.pop();
	}

	public boolean inColCreateTable() {
      return !inColCreateTable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_tablespace_innodb = new java.util.Stack<>();

	@Override
	public void enterCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		final Node node = model.newNode(Label.label("Create_tablespace_innodb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_tablespace_innodb.push(true);
	}

	public void exitCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		onExit();
		this.inCreate_tablespace_innodb.pop();
	}

	public boolean inCreate_tablespace_innodb() {
      return !inCreate_tablespace_innodb.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_tablespace_ndb = new java.util.Stack<>();

	@Override
	public void enterCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		final Node node = model.newNode(Label.label("Create_tablespace_ndb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_tablespace_ndb.push(true);
	}

	public void exitCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		onExit();
		this.inCreate_tablespace_ndb.pop();
	}

	public boolean inCreate_tablespace_ndb() {
      return !inCreate_tablespace_ndb.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_trigger = new java.util.Stack<>();

	@Override
	public void enterCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		final Node node = model.newNode(Label.label("Create_trigger"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_trigger.push(true);
	}

	public void exitCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		onExit();
		this.inCreate_trigger.pop();
	}

	public boolean inCreate_trigger() {
      return !inCreate_trigger.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_view = new java.util.Stack<>();

	@Override
	public void enterCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		final Node node = model.newNode(Label.label("Create_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_view.push(true);
	}

	public void exitCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		onExit();
		this.inCreate_view.pop();
	}

	public boolean inCreate_view() {
      return !inCreate_view.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_database_option = new java.util.Stack<>();

	@Override
	public void enterCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		final Node node = model.newNode(Label.label("Create_database_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_database_option.push(true);
	}

	public void exitCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		onExit();
		this.inCreate_database_option.pop();
	}

	public boolean inCreate_database_option() {
      return !inCreate_database_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOwner_statement = new java.util.Stack<>();

	@Override
	public void enterOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		final Node node = model.newNode(Label.label("Owner_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOwner_statement.push(true);
	}

	public void exitOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		onExit();
		this.inOwner_statement.pop();
	}

	public boolean inOwner_statement() {
      return !inOwner_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPreciseSchedule = new java.util.Stack<>();

	@Override
	public void enterPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		final Node node = model.newNode(Label.label("PreciseSchedule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPreciseSchedule.push(true);
	}

	public void exitPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		onExit();
		this.inPreciseSchedule.pop();
	}

	public boolean inPreciseSchedule() {
      return !inPreciseSchedule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIntervalSchedule = new java.util.Stack<>();

	@Override
	public void enterIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		final Node node = model.newNode(Label.label("IntervalSchedule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIntervalSchedule.push(true);
	}

	public void exitIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		onExit();
		this.inIntervalSchedule.pop();
	}

	public boolean inIntervalSchedule() {
      return !inIntervalSchedule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTimestamp_value = new java.util.Stack<>();

	@Override
	public void enterTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		final Node node = model.newNode(Label.label("Timestamp_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTimestamp_value.push(true);
	}

	public void exitTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		onExit();
		this.inTimestamp_value.pop();
	}

	public boolean inTimestamp_value() {
      return !inTimestamp_value.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterval_expr = new java.util.Stack<>();

	@Override
	public void enterInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		final Node node = model.newNode(Label.label("Interval_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterval_expr.push(true);
	}

	public void exitInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		onExit();
		this.inInterval_expr.pop();
	}

	public boolean inInterval_expr() {
      return !inInterval_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterval_type = new java.util.Stack<>();

	@Override
	public void enterInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		final Node node = model.newNode(Label.label("Interval_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterval_type.push(true);
	}

	public void exitInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		onExit();
		this.inInterval_type.pop();
	}

	public boolean inInterval_type() {
      return !inInterval_type.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndex_type = new java.util.Stack<>();

	@Override
	public void enterIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		final Node node = model.newNode(Label.label("Index_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIndex_type.push(true);
	}

	public void exitIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		onExit();
		this.inIndex_type.pop();
	}

	public boolean inIndex_type() {
      return !inIndex_type.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndex_option = new java.util.Stack<>();

	@Override
	public void enterIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		final Node node = model.newNode(Label.label("Index_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIndex_option.push(true);
	}

	public void exitIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		onExit();
		this.inIndex_option.pop();
	}

	public boolean inIndex_option() {
      return !inIndex_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProc_param = new java.util.Stack<>();

	@Override
	public void enterProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		final Node node = model.newNode(Label.label("Proc_param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inProc_param.push(true);
	}

	public void exitProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		onExit();
		this.inProc_param.pop();
	}

	public boolean inProc_param() {
      return !inProc_param.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunc_param = new java.util.Stack<>();

	@Override
	public void enterFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		final Node node = model.newNode(Label.label("Func_param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunc_param.push(true);
	}

	public void exitFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		onExit();
		this.inFunc_param.pop();
	}

	public boolean inFunc_param() {
      return !inFunc_param.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRcComment = new java.util.Stack<>();

	@Override
	public void enterRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		final Node node = model.newNode(Label.label("RcComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRcComment.push(true);
	}

	public void exitRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		onExit();
		this.inRcComment.pop();
	}

	public boolean inRcComment() {
      return !inRcComment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRcSqllang = new java.util.Stack<>();

	@Override
	public void enterRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		final Node node = model.newNode(Label.label("RcSqllang"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRcSqllang.push(true);
	}

	public void exitRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		onExit();
		this.inRcSqllang.pop();
	}

	public boolean inRcSqllang() {
      return !inRcSqllang.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRcDeterm = new java.util.Stack<>();

	@Override
	public void enterRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		final Node node = model.newNode(Label.label("RcDeterm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRcDeterm.push(true);
	}

	public void exitRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		onExit();
		this.inRcDeterm.pop();
	}

	public boolean inRcDeterm() {
      return !inRcDeterm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRcSqldata = new java.util.Stack<>();

	@Override
	public void enterRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		final Node node = model.newNode(Label.label("RcSqldata"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRcSqldata.push(true);
	}

	public void exitRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		onExit();
		this.inRcSqldata.pop();
	}

	public boolean inRcSqldata() {
      return !inRcSqldata.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRcSecurestmt = new java.util.Stack<>();

	@Override
	public void enterRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		final Node node = model.newNode(Label.label("RcSecurestmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRcSecurestmt.push(true);
	}

	public void exitRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		onExit();
		this.inRcSecurestmt.pop();
	}

	public boolean inRcSecurestmt() {
      return !inRcSecurestmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inServer_option = new java.util.Stack<>();

	@Override
	public void enterServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		final Node node = model.newNode(Label.label("Server_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inServer_option.push(true);
	}

	public void exitServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		onExit();
		this.inServer_option.pop();
	}

	public boolean inServer_option() {
      return !inServer_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColumn_def_table_constraints = new java.util.Stack<>();

	@Override
	public void enterColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		final Node node = model.newNode(Label.label("Column_def_table_constraints"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColumn_def_table_constraints.push(true);
	}

	public void exitColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		onExit();
		this.inColumn_def_table_constraints.pop();
	}

	public boolean inColumn_def_table_constraints() {
      return !inColumn_def_table_constraints.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColumnDefinition = new java.util.Stack<>();

	@Override
	public void enterColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		final Node node = model.newNode(Label.label("ColumnDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColumnDefinition.push(true);
	}

	public void exitColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		onExit();
		this.inColumnDefinition.pop();
	}

	public boolean inColumnDefinition() {
      return !inColumnDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstraintDefinition = new java.util.Stack<>();

	@Override
	public void enterConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		final Node node = model.newNode(Label.label("ConstraintDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstraintDefinition.push(true);
	}

	public void exitConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		onExit();
		this.inConstraintDefinition.pop();
	}

	public boolean inConstraintDefinition() {
      return !inConstraintDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndexDefinition = new java.util.Stack<>();

	@Override
	public void enterIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		final Node node = model.newNode(Label.label("IndexDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIndexDefinition.push(true);
	}

	public void exitIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		onExit();
		this.inIndexDefinition.pop();
	}

	public boolean inIndexDefinition() {
      return !inIndexDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColumn_definition = new java.util.Stack<>();

	@Override
	public void enterColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		final Node node = model.newNode(Label.label("Column_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColumn_definition.push(true);
	}

	public void exitColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		onExit();
		this.inColumn_definition.pop();
	}

	public boolean inColumn_definition() {
      return !inColumn_definition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrNull = new java.util.Stack<>();

	@Override
	public void enterColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		final Node node = model.newNode(Label.label("ColConstrNull"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrNull.push(true);
	}

	public void exitColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		onExit();
		this.inColConstrNull.pop();
	}

	public boolean inColConstrNull() {
      return !inColConstrNull.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrDflt = new java.util.Stack<>();

	@Override
	public void enterColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		final Node node = model.newNode(Label.label("ColConstrDflt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrDflt.push(true);
	}

	public void exitColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		onExit();
		this.inColConstrDflt.pop();
	}

	public boolean inColConstrDflt() {
      return !inColConstrDflt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrAuInc = new java.util.Stack<>();

	@Override
	public void enterColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		final Node node = model.newNode(Label.label("ColConstrAuInc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrAuInc.push(true);
	}

	public void exitColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		onExit();
		this.inColConstrAuInc.pop();
	}

	public boolean inColConstrAuInc() {
      return !inColConstrAuInc.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrPK = new java.util.Stack<>();

	@Override
	public void enterColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		final Node node = model.newNode(Label.label("ColConstrPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrPK.push(true);
	}

	public void exitColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		onExit();
		this.inColConstrPK.pop();
	}

	public boolean inColConstrPK() {
      return !inColConstrPK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrUK = new java.util.Stack<>();

	@Override
	public void enterColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		final Node node = model.newNode(Label.label("ColConstrUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrUK.push(true);
	}

	public void exitColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		onExit();
		this.inColConstrUK.pop();
	}

	public boolean inColConstrUK() {
      return !inColConstrUK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrComment = new java.util.Stack<>();

	@Override
	public void enterColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		final Node node = model.newNode(Label.label("ColConstrComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrComment.push(true);
	}

	public void exitColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		onExit();
		this.inColConstrComment.pop();
	}

	public boolean inColConstrComment() {
      return !inColConstrComment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrForm = new java.util.Stack<>();

	@Override
	public void enterColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		final Node node = model.newNode(Label.label("ColConstrForm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrForm.push(true);
	}

	public void exitColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		onExit();
		this.inColConstrForm.pop();
	}

	public boolean inColConstrForm() {
      return !inColConstrForm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrStorage = new java.util.Stack<>();

	@Override
	public void enterColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		final Node node = model.newNode(Label.label("ColConstrStorage"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrStorage.push(true);
	}

	public void exitColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		onExit();
		this.inColConstrStorage.pop();
	}

	public boolean inColConstrStorage() {
      return !inColConstrStorage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inColConstrRefdef = new java.util.Stack<>();

	@Override
	public void enterColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		final Node node = model.newNode(Label.label("ColConstrRefdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inColConstrRefdef.push(true);
	}

	public void exitColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		onExit();
		this.inColConstrRefdef.pop();
	}

	public boolean inColConstrRefdef() {
      return !inColConstrRefdef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblConstrPK = new java.util.Stack<>();

	@Override
	public void enterTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		final Node node = model.newNode(Label.label("TblConstrPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblConstrPK.push(true);
	}

	public void exitTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		onExit();
		this.inTblConstrPK.pop();
	}

	public boolean inTblConstrPK() {
      return !inTblConstrPK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblConstrUK = new java.util.Stack<>();

	@Override
	public void enterTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		final Node node = model.newNode(Label.label("TblConstrUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblConstrUK.push(true);
	}

	public void exitTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		onExit();
		this.inTblConstrUK.pop();
	}

	public boolean inTblConstrUK() {
      return !inTblConstrUK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblConstrFK = new java.util.Stack<>();

	@Override
	public void enterTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		final Node node = model.newNode(Label.label("TblConstrFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblConstrFK.push(true);
	}

	public void exitTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		onExit();
		this.inTblConstrFK.pop();
	}

	public boolean inTblConstrFK() {
      return !inTblConstrFK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblConstCheck = new java.util.Stack<>();

	@Override
	public void enterTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		final Node node = model.newNode(Label.label("TblConstCheck"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblConstCheck.push(true);
	}

	public void exitTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		onExit();
		this.inTblConstCheck.pop();
	}

	public boolean inTblConstCheck() {
      return !inTblConstCheck.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReference_definition = new java.util.Stack<>();

	@Override
	public void enterReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		final Node node = model.newNode(Label.label("Reference_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReference_definition.push(true);
	}

	public void exitReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		onExit();
		this.inReference_definition.pop();
	}

	public boolean inReference_definition() {
      return !inReference_definition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOn_delete_action = new java.util.Stack<>();

	@Override
	public void enterOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		final Node node = model.newNode(Label.label("On_delete_action"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOn_delete_action.push(true);
	}

	public void exitOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		onExit();
		this.inOn_delete_action.pop();
	}

	public boolean inOn_delete_action() {
      return !inOn_delete_action.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOn_update_action = new java.util.Stack<>();

	@Override
	public void enterOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		final Node node = model.newNode(Label.label("On_update_action"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOn_update_action.push(true);
	}

	public void exitOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		onExit();
		this.inOn_update_action.pop();
	}

	public boolean inOn_update_action() {
      return !inOn_update_action.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReference_action_control_type = new java.util.Stack<>();

	@Override
	public void enterReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		final Node node = model.newNode(Label.label("Reference_action_control_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReference_action_control_type.push(true);
	}

	public void exitReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		onExit();
		this.inReference_action_control_type.pop();
	}

	public boolean inReference_action_control_type() {
      return !inReference_action_control_type.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleIndex = new java.util.Stack<>();

	@Override
	public void enterSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		final Node node = model.newNode(Label.label("SimpleIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleIndex.push(true);
	}

	public void exitSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		onExit();
		this.inSimpleIndex.pop();
	}

	public boolean inSimpleIndex() {
      return !inSimpleIndex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSpecIndex = new java.util.Stack<>();

	@Override
	public void enterSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		final Node node = model.newNode(Label.label("SpecIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSpecIndex.push(true);
	}

	public void exitSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		onExit();
		this.inSpecIndex.pop();
	}

	public boolean inSpecIndex() {
      return !inSpecIndex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptEngine = new java.util.Stack<>();

	@Override
	public void enterTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		final Node node = model.newNode(Label.label("TblOptEngine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptEngine.push(true);
	}

	public void exitTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		onExit();
		this.inTblOptEngine.pop();
	}

	public boolean inTblOptEngine() {
      return !inTblOptEngine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptAuInc = new java.util.Stack<>();

	@Override
	public void enterTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		final Node node = model.newNode(Label.label("TblOptAuInc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptAuInc.push(true);
	}

	public void exitTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		onExit();
		this.inTblOptAuInc.pop();
	}

	public boolean inTblOptAuInc() {
      return !inTblOptAuInc.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptAvgRLen = new java.util.Stack<>();

	@Override
	public void enterTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		final Node node = model.newNode(Label.label("TblOptAvgRLen"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptAvgRLen.push(true);
	}

	public void exitTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		onExit();
		this.inTblOptAvgRLen.pop();
	}

	public boolean inTblOptAvgRLen() {
      return !inTblOptAvgRLen.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptDefCharSet = new java.util.Stack<>();

	@Override
	public void enterTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		final Node node = model.newNode(Label.label("TblOptDefCharSet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptDefCharSet.push(true);
	}

	public void exitTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		onExit();
		this.inTblOptDefCharSet.pop();
	}

	public boolean inTblOptDefCharSet() {
      return !inTblOptDefCharSet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptChkSum = new java.util.Stack<>();

	@Override
	public void enterTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		final Node node = model.newNode(Label.label("TblOptChkSum"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptChkSum.push(true);
	}

	public void exitTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		onExit();
		this.inTblOptChkSum.pop();
	}

	public boolean inTblOptChkSum() {
      return !inTblOptChkSum.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptDefCollate = new java.util.Stack<>();

	@Override
	public void enterTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		final Node node = model.newNode(Label.label("TblOptDefCollate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptDefCollate.push(true);
	}

	public void exitTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		onExit();
		this.inTblOptDefCollate.pop();
	}

	public boolean inTblOptDefCollate() {
      return !inTblOptDefCollate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptComment = new java.util.Stack<>();

	@Override
	public void enterTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		final Node node = model.newNode(Label.label("TblOptComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptComment.push(true);
	}

	public void exitTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		onExit();
		this.inTblOptComment.pop();
	}

	public boolean inTblOptComment() {
      return !inTblOptComment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptCompr = new java.util.Stack<>();

	@Override
	public void enterTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		final Node node = model.newNode(Label.label("TblOptCompr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptCompr.push(true);
	}

	public void exitTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		onExit();
		this.inTblOptCompr.pop();
	}

	public boolean inTblOptCompr() {
      return !inTblOptCompr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptConn = new java.util.Stack<>();

	@Override
	public void enterTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		final Node node = model.newNode(Label.label("TblOptConn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptConn.push(true);
	}

	public void exitTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		onExit();
		this.inTblOptConn.pop();
	}

	public boolean inTblOptConn() {
      return !inTblOptConn.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptDataDir = new java.util.Stack<>();

	@Override
	public void enterTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		final Node node = model.newNode(Label.label("TblOptDataDir"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptDataDir.push(true);
	}

	public void exitTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		onExit();
		this.inTblOptDataDir.pop();
	}

	public boolean inTblOptDataDir() {
      return !inTblOptDataDir.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptDelKW = new java.util.Stack<>();

	@Override
	public void enterTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		final Node node = model.newNode(Label.label("TblOptDelKW"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptDelKW.push(true);
	}

	public void exitTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		onExit();
		this.inTblOptDelKW.pop();
	}

	public boolean inTblOptDelKW() {
      return !inTblOptDelKW.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptEncr = new java.util.Stack<>();

	@Override
	public void enterTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		final Node node = model.newNode(Label.label("TblOptEncr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptEncr.push(true);
	}

	public void exitTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		onExit();
		this.inTblOptEncr.pop();
	}

	public boolean inTblOptEncr() {
      return !inTblOptEncr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptIndexDir = new java.util.Stack<>();

	@Override
	public void enterTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		final Node node = model.newNode(Label.label("TblOptIndexDir"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptIndexDir.push(true);
	}

	public void exitTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		onExit();
		this.inTblOptIndexDir.pop();
	}

	public boolean inTblOptIndexDir() {
      return !inTblOptIndexDir.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptInsMeth = new java.util.Stack<>();

	@Override
	public void enterTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		final Node node = model.newNode(Label.label("TblOptInsMeth"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptInsMeth.push(true);
	}

	public void exitTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		onExit();
		this.inTblOptInsMeth.pop();
	}

	public boolean inTblOptInsMeth() {
      return !inTblOptInsMeth.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptKeyBlockSz = new java.util.Stack<>();

	@Override
	public void enterTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		final Node node = model.newNode(Label.label("TblOptKeyBlockSz"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptKeyBlockSz.push(true);
	}

	public void exitTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		onExit();
		this.inTblOptKeyBlockSz.pop();
	}

	public boolean inTblOptKeyBlockSz() {
      return !inTblOptKeyBlockSz.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptMaxRows = new java.util.Stack<>();

	@Override
	public void enterTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		final Node node = model.newNode(Label.label("TblOptMaxRows"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptMaxRows.push(true);
	}

	public void exitTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		onExit();
		this.inTblOptMaxRows.pop();
	}

	public boolean inTblOptMaxRows() {
      return !inTblOptMaxRows.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptMinRows = new java.util.Stack<>();

	@Override
	public void enterTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		final Node node = model.newNode(Label.label("TblOptMinRows"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptMinRows.push(true);
	}

	public void exitTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		onExit();
		this.inTblOptMinRows.pop();
	}

	public boolean inTblOptMinRows() {
      return !inTblOptMinRows.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptPackK = new java.util.Stack<>();

	@Override
	public void enterTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		final Node node = model.newNode(Label.label("TblOptPackK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptPackK.push(true);
	}

	public void exitTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		onExit();
		this.inTblOptPackK.pop();
	}

	public boolean inTblOptPackK() {
      return !inTblOptPackK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptPasswd = new java.util.Stack<>();

	@Override
	public void enterTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		final Node node = model.newNode(Label.label("TblOptPasswd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptPasswd.push(true);
	}

	public void exitTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		onExit();
		this.inTblOptPasswd.pop();
	}

	public boolean inTblOptPasswd() {
      return !inTblOptPasswd.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptRowFormat = new java.util.Stack<>();

	@Override
	public void enterTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		final Node node = model.newNode(Label.label("TblOptRowFormat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptRowFormat.push(true);
	}

	public void exitTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		onExit();
		this.inTblOptRowFormat.pop();
	}

	public boolean inTblOptRowFormat() {
      return !inTblOptRowFormat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptStatAutoR = new java.util.Stack<>();

	@Override
	public void enterTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		final Node node = model.newNode(Label.label("TblOptStatAutoR"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptStatAutoR.push(true);
	}

	public void exitTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		onExit();
		this.inTblOptStatAutoR.pop();
	}

	public boolean inTblOptStatAutoR() {
      return !inTblOptStatAutoR.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptStatPersist = new java.util.Stack<>();

	@Override
	public void enterTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		final Node node = model.newNode(Label.label("TblOptStatPersist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptStatPersist.push(true);
	}

	public void exitTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		onExit();
		this.inTblOptStatPersist.pop();
	}

	public boolean inTblOptStatPersist() {
      return !inTblOptStatPersist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptStatSamplPg = new java.util.Stack<>();

	@Override
	public void enterTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		final Node node = model.newNode(Label.label("TblOptStatSamplPg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptStatSamplPg.push(true);
	}

	public void exitTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		onExit();
		this.inTblOptStatSamplPg.pop();
	}

	public boolean inTblOptStatSamplPg() {
      return !inTblOptStatSamplPg.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptTablespace = new java.util.Stack<>();

	@Override
	public void enterTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		final Node node = model.newNode(Label.label("TblOptTablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptTablespace.push(true);
	}

	public void exitTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		onExit();
		this.inTblOptTablespace.pop();
	}

	public boolean inTblOptTablespace() {
      return !inTblOptTablespace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTblOptUnion = new java.util.Stack<>();

	@Override
	public void enterTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		final Node node = model.newNode(Label.label("TblOptUnion"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTblOptUnion.push(true);
	}

	public void exitTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		onExit();
		this.inTblOptUnion.pop();
	}

	public boolean inTblOptUnion() {
      return !inTblOptUnion.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPartition_options = new java.util.Stack<>();

	@Override
	public void enterPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		final Node node = model.newNode(Label.label("Partition_options"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPartition_options.push(true);
	}

	public void exitPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		onExit();
		this.inPartition_options.pop();
	}

	public boolean inPartition_options() {
      return !inPartition_options.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPartition_function_definition = new java.util.Stack<>();

	@Override
	public void enterPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		final Node node = model.newNode(Label.label("Partition_function_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPartition_function_definition.push(true);
	}

	public void exitPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		onExit();
		this.inPartition_function_definition.pop();
	}

	public boolean inPartition_function_definition() {
      return !inPartition_function_definition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLinear_partition_func_def = new java.util.Stack<>();

	@Override
	public void enterLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		final Node node = model.newNode(Label.label("Linear_partition_func_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLinear_partition_func_def.push(true);
	}

	public void exitLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		onExit();
		this.inLinear_partition_func_def.pop();
	}

	public boolean inLinear_partition_func_def() {
      return !inLinear_partition_func_def.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPartition_def = new java.util.Stack<>();

	@Override
	public void enterPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		final Node node = model.newNode(Label.label("Partition_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPartition_def.push(true);
	}

	public void exitPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		onExit();
		this.inPartition_def.pop();
	}

	public boolean inPartition_def() {
      return !inPartition_def.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubpartition_def = new java.util.Stack<>();

	@Override
	public void enterSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		final Node node = model.newNode(Label.label("Subpartition_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubpartition_def.push(true);
	}

	public void exitSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		onExit();
		this.inSubpartition_def.pop();
	}

	public boolean inSubpartition_def() {
      return !inSubpartition_def.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlterDb = new java.util.Stack<>();

	@Override
	public void enterAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		final Node node = model.newNode(Label.label("AlterDb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlterDb.push(true);
	}

	public void exitAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		onExit();
		this.inAlterDb.pop();
	}

	public boolean inAlterDb() {
      return !inAlterDb.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlterDbUpgradeName = new java.util.Stack<>();

	@Override
	public void enterAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		final Node node = model.newNode(Label.label("AlterDbUpgradeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlterDbUpgradeName.push(true);
	}

	public void exitAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		onExit();
		this.inAlterDbUpgradeName.pop();
	}

	public boolean inAlterDbUpgradeName() {
      return !inAlterDbUpgradeName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_event = new java.util.Stack<>();

	@Override
	public void enterAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		final Node node = model.newNode(Label.label("Alter_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_event.push(true);
	}

	public void exitAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		onExit();
		this.inAlter_event.pop();
	}

	public boolean inAlter_event() {
      return !inAlter_event.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_function = new java.util.Stack<>();

	@Override
	public void enterAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		final Node node = model.newNode(Label.label("Alter_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_function.push(true);
	}

	public void exitAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		onExit();
		this.inAlter_function.pop();
	}

	public boolean inAlter_function() {
      return !inAlter_function.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_instance = new java.util.Stack<>();

	@Override
	public void enterAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		final Node node = model.newNode(Label.label("Alter_instance"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_instance.push(true);
	}

	public void exitAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		onExit();
		this.inAlter_instance.pop();
	}

	public boolean inAlter_instance() {
      return !inAlter_instance.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_logfile_group = new java.util.Stack<>();

	@Override
	public void enterAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		final Node node = model.newNode(Label.label("Alter_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_logfile_group.push(true);
	}

	public void exitAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		onExit();
		this.inAlter_logfile_group.pop();
	}

	public boolean inAlter_logfile_group() {
      return !inAlter_logfile_group.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_procedure = new java.util.Stack<>();

	@Override
	public void enterAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		final Node node = model.newNode(Label.label("Alter_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_procedure.push(true);
	}

	public void exitAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		onExit();
		this.inAlter_procedure.pop();
	}

	public boolean inAlter_procedure() {
      return !inAlter_procedure.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_server = new java.util.Stack<>();

	@Override
	public void enterAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		final Node node = model.newNode(Label.label("Alter_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_server.push(true);
	}

	public void exitAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		onExit();
		this.inAlter_server.pop();
	}

	public boolean inAlter_server() {
      return !inAlter_server.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_table = new java.util.Stack<>();

	@Override
	public void enterAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		final Node node = model.newNode(Label.label("Alter_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_table.push(true);
	}

	public void exitAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		onExit();
		this.inAlter_table.pop();
	}

	public boolean inAlter_table() {
      return !inAlter_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_tablespace = new java.util.Stack<>();

	@Override
	public void enterAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		final Node node = model.newNode(Label.label("Alter_tablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_tablespace.push(true);
	}

	public void exitAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		onExit();
		this.inAlter_tablespace.pop();
	}

	public boolean inAlter_tablespace() {
      return !inAlter_tablespace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlter_view = new java.util.Stack<>();

	@Override
	public void enterAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		final Node node = model.newNode(Label.label("Alter_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlter_view.push(true);
	}

	public void exitAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		onExit();
		this.inAlter_view.pop();
	}

	public boolean inAlter_view() {
      return !inAlter_view.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblTableOpt = new java.util.Stack<>();

	@Override
	public void enterAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		final Node node = model.newNode(Label.label("AltblTableOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblTableOpt.push(true);
	}

	public void exitAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		onExit();
		this.inAltblTableOpt.pop();
	}

	public boolean inAltblTableOpt() {
      return !inAltblTableOpt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddCol = new java.util.Stack<>();

	@Override
	public void enterAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		final Node node = model.newNode(Label.label("AltblAddCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddCol.push(true);
	}

	public void exitAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		onExit();
		this.inAltblAddCol.pop();
	}

	public boolean inAltblAddCol() {
      return !inAltblAddCol.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddCols = new java.util.Stack<>();

	@Override
	public void enterAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		final Node node = model.newNode(Label.label("AltblAddCols"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddCols.push(true);
	}

	public void exitAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		onExit();
		this.inAltblAddCols.pop();
	}

	public boolean inAltblAddCols() {
      return !inAltblAddCols.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddIndex = new java.util.Stack<>();

	@Override
	public void enterAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		final Node node = model.newNode(Label.label("AltblAddIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddIndex.push(true);
	}

	public void exitAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		onExit();
		this.inAltblAddIndex.pop();
	}

	public boolean inAltblAddIndex() {
      return !inAltblAddIndex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddPK = new java.util.Stack<>();

	@Override
	public void enterAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		final Node node = model.newNode(Label.label("AltblAddPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddPK.push(true);
	}

	public void exitAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		onExit();
		this.inAltblAddPK.pop();
	}

	public boolean inAltblAddPK() {
      return !inAltblAddPK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddUK = new java.util.Stack<>();

	@Override
	public void enterAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		final Node node = model.newNode(Label.label("AltblAddUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddUK.push(true);
	}

	public void exitAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		onExit();
		this.inAltblAddUK.pop();
	}

	public boolean inAltblAddUK() {
      return !inAltblAddUK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddSpecIndex = new java.util.Stack<>();

	@Override
	public void enterAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		final Node node = model.newNode(Label.label("AltblAddSpecIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddSpecIndex.push(true);
	}

	public void exitAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		onExit();
		this.inAltblAddSpecIndex.pop();
	}

	public boolean inAltblAddSpecIndex() {
      return !inAltblAddSpecIndex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddFK = new java.util.Stack<>();

	@Override
	public void enterAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		final Node node = model.newNode(Label.label("AltblAddFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddFK.push(true);
	}

	public void exitAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		onExit();
		this.inAltblAddFK.pop();
	}

	public boolean inAltblAddFK() {
      return !inAltblAddFK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAlg = new java.util.Stack<>();

	@Override
	public void enterAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		final Node node = model.newNode(Label.label("AltblAlg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAlg.push(true);
	}

	public void exitAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		onExit();
		this.inAltblAlg.pop();
	}

	public boolean inAltblAlg() {
      return !inAltblAlg.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblColDef = new java.util.Stack<>();

	@Override
	public void enterAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		final Node node = model.newNode(Label.label("AltblColDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblColDef.push(true);
	}

	public void exitAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		onExit();
		this.inAltblColDef.pop();
	}

	public boolean inAltblColDef() {
      return !inAltblColDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblColChange = new java.util.Stack<>();

	@Override
	public void enterAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		final Node node = model.newNode(Label.label("AltblColChange"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblColChange.push(true);
	}

	public void exitAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		onExit();
		this.inAltblColChange.pop();
	}

	public boolean inAltblColChange() {
      return !inAltblColChange.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblLock = new java.util.Stack<>();

	@Override
	public void enterAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		final Node node = model.newNode(Label.label("AltblLock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblLock.push(true);
	}

	public void exitAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		onExit();
		this.inAltblLock.pop();
	}

	public boolean inAltblLock() {
      return !inAltblLock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblColMod = new java.util.Stack<>();

	@Override
	public void enterAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		final Node node = model.newNode(Label.label("AltblColMod"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblColMod.push(true);
	}

	public void exitAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		onExit();
		this.inAltblColMod.pop();
	}

	public boolean inAltblColMod() {
      return !inAltblColMod.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblColDrop = new java.util.Stack<>();

	@Override
	public void enterAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		final Node node = model.newNode(Label.label("AltblColDrop"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblColDrop.push(true);
	}

	public void exitAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		onExit();
		this.inAltblColDrop.pop();
	}

	public boolean inAltblColDrop() {
      return !inAltblColDrop.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDropPK = new java.util.Stack<>();

	@Override
	public void enterAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		final Node node = model.newNode(Label.label("AltblDropPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDropPK.push(true);
	}

	public void exitAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		onExit();
		this.inAltblDropPK.pop();
	}

	public boolean inAltblDropPK() {
      return !inAltblDropPK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDropIndex = new java.util.Stack<>();

	@Override
	public void enterAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		final Node node = model.newNode(Label.label("AltblDropIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDropIndex.push(true);
	}

	public void exitAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		onExit();
		this.inAltblDropIndex.pop();
	}

	public boolean inAltblDropIndex() {
      return !inAltblDropIndex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDropFK = new java.util.Stack<>();

	@Override
	public void enterAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		final Node node = model.newNode(Label.label("AltblDropFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDropFK.push(true);
	}

	public void exitAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		onExit();
		this.inAltblDropFK.pop();
	}

	public boolean inAltblDropFK() {
      return !inAltblDropFK.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDisKey = new java.util.Stack<>();

	@Override
	public void enterAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		final Node node = model.newNode(Label.label("AltblDisKey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDisKey.push(true);
	}

	public void exitAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		onExit();
		this.inAltblDisKey.pop();
	}

	public boolean inAltblDisKey() {
      return !inAltblDisKey.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblEnKey = new java.util.Stack<>();

	@Override
	public void enterAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		final Node node = model.newNode(Label.label("AltblEnKey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblEnKey.push(true);
	}

	public void exitAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		onExit();
		this.inAltblEnKey.pop();
	}

	public boolean inAltblEnKey() {
      return !inAltblEnKey.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblRenameTbl = new java.util.Stack<>();

	@Override
	public void enterAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		final Node node = model.newNode(Label.label("AltblRenameTbl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblRenameTbl.push(true);
	}

	public void exitAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		onExit();
		this.inAltblRenameTbl.pop();
	}

	public boolean inAltblRenameTbl() {
      return !inAltblRenameTbl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblResort = new java.util.Stack<>();

	@Override
	public void enterAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		final Node node = model.newNode(Label.label("AltblResort"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblResort.push(true);
	}

	public void exitAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		onExit();
		this.inAltblResort.pop();
	}

	public boolean inAltblResort() {
      return !inAltblResort.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblConvert = new java.util.Stack<>();

	@Override
	public void enterAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		final Node node = model.newNode(Label.label("AltblConvert"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblConvert.push(true);
	}

	public void exitAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		onExit();
		this.inAltblConvert.pop();
	}

	public boolean inAltblConvert() {
      return !inAltblConvert.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDefCharset = new java.util.Stack<>();

	@Override
	public void enterAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		final Node node = model.newNode(Label.label("AltblDefCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDefCharset.push(true);
	}

	public void exitAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		onExit();
		this.inAltblDefCharset.pop();
	}

	public boolean inAltblDefCharset() {
      return !inAltblDefCharset.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDisTblspace = new java.util.Stack<>();

	@Override
	public void enterAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		final Node node = model.newNode(Label.label("AltblDisTblspace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDisTblspace.push(true);
	}

	public void exitAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		onExit();
		this.inAltblDisTblspace.pop();
	}

	public boolean inAltblDisTblspace() {
      return !inAltblDisTblspace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblImpTblSpace = new java.util.Stack<>();

	@Override
	public void enterAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		final Node node = model.newNode(Label.label("AltblImpTblSpace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblImpTblSpace.push(true);
	}

	public void exitAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		onExit();
		this.inAltblImpTblSpace.pop();
	}

	public boolean inAltblImpTblSpace() {
      return !inAltblImpTblSpace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblForce = new java.util.Stack<>();

	@Override
	public void enterAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		final Node node = model.newNode(Label.label("AltblForce"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblForce.push(true);
	}

	public void exitAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		onExit();
		this.inAltblForce.pop();
	}

	public boolean inAltblForce() {
      return !inAltblForce.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblValid = new java.util.Stack<>();

	@Override
	public void enterAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		final Node node = model.newNode(Label.label("AltblValid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblValid.push(true);
	}

	public void exitAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		onExit();
		this.inAltblValid.pop();
	}

	public boolean inAltblValid() {
      return !inAltblValid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTls_option = new java.util.Stack<>();

	@Override
	public void enterTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		final Node node = model.newNode(Label.label("Tls_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTls_option.push(true);
	}

	public void exitTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		onExit();
		this.inTls_option.pop();
	}

	public boolean inTls_option() {
      return !inTls_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAddPart = new java.util.Stack<>();

	@Override
	public void enterAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		final Node node = model.newNode(Label.label("AltblAddPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAddPart.push(true);
	}

	public void exitAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		onExit();
		this.inAltblAddPart.pop();
	}

	public boolean inAltblAddPart() {
      return !inAltblAddPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDropPart = new java.util.Stack<>();

	@Override
	public void enterAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		final Node node = model.newNode(Label.label("AltblDropPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDropPart.push(true);
	}

	public void exitAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		onExit();
		this.inAltblDropPart.pop();
	}

	public boolean inAltblDropPart() {
      return !inAltblDropPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblDiscartPart = new java.util.Stack<>();

	@Override
	public void enterAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		final Node node = model.newNode(Label.label("AltblDiscartPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblDiscartPart.push(true);
	}

	public void exitAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		onExit();
		this.inAltblDiscartPart.pop();
	}

	public boolean inAltblDiscartPart() {
      return !inAltblDiscartPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblImportPart = new java.util.Stack<>();

	@Override
	public void enterAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		final Node node = model.newNode(Label.label("AltblImportPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblImportPart.push(true);
	}

	public void exitAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		onExit();
		this.inAltblImportPart.pop();
	}

	public boolean inAltblImportPart() {
      return !inAltblImportPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblTruncPart = new java.util.Stack<>();

	@Override
	public void enterAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		final Node node = model.newNode(Label.label("AltblTruncPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblTruncPart.push(true);
	}

	public void exitAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		onExit();
		this.inAltblTruncPart.pop();
	}

	public boolean inAltblTruncPart() {
      return !inAltblTruncPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblCoalPart = new java.util.Stack<>();

	@Override
	public void enterAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		final Node node = model.newNode(Label.label("AltblCoalPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblCoalPart.push(true);
	}

	public void exitAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		onExit();
		this.inAltblCoalPart.pop();
	}

	public boolean inAltblCoalPart() {
      return !inAltblCoalPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblReorgPart = new java.util.Stack<>();

	@Override
	public void enterAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		final Node node = model.newNode(Label.label("AltblReorgPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblReorgPart.push(true);
	}

	public void exitAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		onExit();
		this.inAltblReorgPart.pop();
	}

	public boolean inAltblReorgPart() {
      return !inAltblReorgPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblExchPart = new java.util.Stack<>();

	@Override
	public void enterAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		final Node node = model.newNode(Label.label("AltblExchPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblExchPart.push(true);
	}

	public void exitAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		onExit();
		this.inAltblExchPart.pop();
	}

	public boolean inAltblExchPart() {
      return !inAltblExchPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblAnalPart = new java.util.Stack<>();

	@Override
	public void enterAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		final Node node = model.newNode(Label.label("AltblAnalPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblAnalPart.push(true);
	}

	public void exitAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		onExit();
		this.inAltblAnalPart.pop();
	}

	public boolean inAltblAnalPart() {
      return !inAltblAnalPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblCheckPart = new java.util.Stack<>();

	@Override
	public void enterAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		final Node node = model.newNode(Label.label("AltblCheckPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblCheckPart.push(true);
	}

	public void exitAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		onExit();
		this.inAltblCheckPart.pop();
	}

	public boolean inAltblCheckPart() {
      return !inAltblCheckPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblOptimPart = new java.util.Stack<>();

	@Override
	public void enterAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		final Node node = model.newNode(Label.label("AltblOptimPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblOptimPart.push(true);
	}

	public void exitAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		onExit();
		this.inAltblOptimPart.pop();
	}

	public boolean inAltblOptimPart() {
      return !inAltblOptimPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblRebuildPart = new java.util.Stack<>();

	@Override
	public void enterAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		final Node node = model.newNode(Label.label("AltblRebuildPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblRebuildPart.push(true);
	}

	public void exitAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		onExit();
		this.inAltblRebuildPart.pop();
	}

	public boolean inAltblRebuildPart() {
      return !inAltblRebuildPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblRepairPart = new java.util.Stack<>();

	@Override
	public void enterAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		final Node node = model.newNode(Label.label("AltblRepairPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblRepairPart.push(true);
	}

	public void exitAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		onExit();
		this.inAltblRepairPart.pop();
	}

	public boolean inAltblRepairPart() {
      return !inAltblRepairPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblRemovePart = new java.util.Stack<>();

	@Override
	public void enterAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		final Node node = model.newNode(Label.label("AltblRemovePart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblRemovePart.push(true);
	}

	public void exitAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		onExit();
		this.inAltblRemovePart.pop();
	}

	public boolean inAltblRemovePart() {
      return !inAltblRemovePart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltblUpgrPart = new java.util.Stack<>();

	@Override
	public void enterAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		final Node node = model.newNode(Label.label("AltblUpgrPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAltblUpgrPart.push(true);
	}

	public void exitAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		onExit();
		this.inAltblUpgrPart.pop();
	}

	public boolean inAltblUpgrPart() {
      return !inAltblUpgrPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_database = new java.util.Stack<>();

	@Override
	public void enterDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		final Node node = model.newNode(Label.label("Drop_database"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_database.push(true);
	}

	public void exitDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		onExit();
		this.inDrop_database.pop();
	}

	public boolean inDrop_database() {
      return !inDrop_database.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_event = new java.util.Stack<>();

	@Override
	public void enterDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		final Node node = model.newNode(Label.label("Drop_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_event.push(true);
	}

	public void exitDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		onExit();
		this.inDrop_event.pop();
	}

	public boolean inDrop_event() {
      return !inDrop_event.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_index = new java.util.Stack<>();

	@Override
	public void enterDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		final Node node = model.newNode(Label.label("Drop_index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_index.push(true);
	}

	public void exitDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		onExit();
		this.inDrop_index.pop();
	}

	public boolean inDrop_index() {
      return !inDrop_index.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_logfile_group = new java.util.Stack<>();

	@Override
	public void enterDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		final Node node = model.newNode(Label.label("Drop_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_logfile_group.push(true);
	}

	public void exitDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		onExit();
		this.inDrop_logfile_group.pop();
	}

	public boolean inDrop_logfile_group() {
      return !inDrop_logfile_group.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_procedure = new java.util.Stack<>();

	@Override
	public void enterDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		final Node node = model.newNode(Label.label("Drop_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_procedure.push(true);
	}

	public void exitDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		onExit();
		this.inDrop_procedure.pop();
	}

	public boolean inDrop_procedure() {
      return !inDrop_procedure.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_function = new java.util.Stack<>();

	@Override
	public void enterDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		final Node node = model.newNode(Label.label("Drop_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_function.push(true);
	}

	public void exitDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		onExit();
		this.inDrop_function.pop();
	}

	public boolean inDrop_function() {
      return !inDrop_function.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_server = new java.util.Stack<>();

	@Override
	public void enterDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		final Node node = model.newNode(Label.label("Drop_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_server.push(true);
	}

	public void exitDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		onExit();
		this.inDrop_server.pop();
	}

	public boolean inDrop_server() {
      return !inDrop_server.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_table = new java.util.Stack<>();

	@Override
	public void enterDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		final Node node = model.newNode(Label.label("Drop_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_table.push(true);
	}

	public void exitDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		onExit();
		this.inDrop_table.pop();
	}

	public boolean inDrop_table() {
      return !inDrop_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_tablespace = new java.util.Stack<>();

	@Override
	public void enterDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		final Node node = model.newNode(Label.label("Drop_tablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_tablespace.push(true);
	}

	public void exitDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		onExit();
		this.inDrop_tablespace.pop();
	}

	public boolean inDrop_tablespace() {
      return !inDrop_tablespace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_trigger = new java.util.Stack<>();

	@Override
	public void enterDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		final Node node = model.newNode(Label.label("Drop_trigger"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_trigger.push(true);
	}

	public void exitDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		onExit();
		this.inDrop_trigger.pop();
	}

	public boolean inDrop_trigger() {
      return !inDrop_trigger.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_view = new java.util.Stack<>();

	@Override
	public void enterDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		final Node node = model.newNode(Label.label("Drop_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_view.push(true);
	}

	public void exitDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		onExit();
		this.inDrop_view.pop();
	}

	public boolean inDrop_view() {
      return !inDrop_view.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRename_table = new java.util.Stack<>();

	@Override
	public void enterRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		final Node node = model.newNode(Label.label("Rename_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRename_table.push(true);
	}

	public void exitRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		onExit();
		this.inRename_table.pop();
	}

	public boolean inRename_table() {
      return !inRename_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTruncate_table = new java.util.Stack<>();

	@Override
	public void enterTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		final Node node = model.newNode(Label.label("Truncate_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTruncate_table.push(true);
	}

	public void exitTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		onExit();
		this.inTruncate_table.pop();
	}

	public boolean inTruncate_table() {
      return !inTruncate_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCall_statement = new java.util.Stack<>();

	@Override
	public void enterCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		final Node node = model.newNode(Label.label("Call_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCall_statement.push(true);
	}

	public void exitCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		onExit();
		this.inCall_statement.pop();
	}

	public boolean inCall_statement() {
      return !inCall_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDelete_statement = new java.util.Stack<>();

	@Override
	public void enterDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		final Node node = model.newNode(Label.label("Delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDelete_statement.push(true);
	}

	public void exitDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		onExit();
		this.inDelete_statement.pop();
	}

	public boolean inDelete_statement() {
      return !inDelete_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDo_statement = new java.util.Stack<>();

	@Override
	public void enterDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		final Node node = model.newNode(Label.label("Do_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDo_statement.push(true);
	}

	public void exitDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		onExit();
		this.inDo_statement.pop();
	}

	public boolean inDo_statement() {
      return !inDo_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandler_statement = new java.util.Stack<>();

	@Override
	public void enterHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		final Node node = model.newNode(Label.label("Handler_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHandler_statement.push(true);
	}

	public void exitHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		onExit();
		this.inHandler_statement.pop();
	}

	public boolean inHandler_statement() {
      return !inHandler_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInsert_statement = new java.util.Stack<>();

	@Override
	public void enterInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		final Node node = model.newNode(Label.label("Insert_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInsert_statement.push(true);
	}

	public void exitInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		onExit();
		this.inInsert_statement.pop();
	}

	public boolean inInsert_statement() {
      return !inInsert_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLoad_data_statement = new java.util.Stack<>();

	@Override
	public void enterLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		final Node node = model.newNode(Label.label("Load_data_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLoad_data_statement.push(true);
	}

	public void exitLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		onExit();
		this.inLoad_data_statement.pop();
	}

	public boolean inLoad_data_statement() {
      return !inLoad_data_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLoad_xml_statement = new java.util.Stack<>();

	@Override
	public void enterLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		final Node node = model.newNode(Label.label("Load_xml_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLoad_xml_statement.push(true);
	}

	public void exitLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		onExit();
		this.inLoad_xml_statement.pop();
	}

	public boolean inLoad_xml_statement() {
      return !inLoad_xml_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReplace_statement = new java.util.Stack<>();

	@Override
	public void enterReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		final Node node = model.newNode(Label.label("Replace_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReplace_statement.push(true);
	}

	public void exitReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		onExit();
		this.inReplace_statement.pop();
	}

	public boolean inReplace_statement() {
      return !inReplace_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleSelect = new java.util.Stack<>();

	@Override
	public void enterSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		final Node node = model.newNode(Label.label("SimpleSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleSelect.push(true);
	}

	public void exitSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		onExit();
		this.inSimpleSelect.pop();
	}

	public boolean inSimpleSelect() {
      return !inSimpleSelect.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParenSelect = new java.util.Stack<>();

	@Override
	public void enterParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		final Node node = model.newNode(Label.label("ParenSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParenSelect.push(true);
	}

	public void exitParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		onExit();
		this.inParenSelect.pop();
	}

	public boolean inParenSelect() {
      return !inParenSelect.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnionSelect = new java.util.Stack<>();

	@Override
	public void enterUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		final Node node = model.newNode(Label.label("UnionSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnionSelect.push(true);
	}

	public void exitUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		onExit();
		this.inUnionSelect.pop();
	}

	public boolean inUnionSelect() {
      return !inUnionSelect.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnionParenSelect = new java.util.Stack<>();

	@Override
	public void enterUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		final Node node = model.newNode(Label.label("UnionParenSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnionParenSelect.push(true);
	}

	public void exitUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		onExit();
		this.inUnionParenSelect.pop();
	}

	public boolean inUnionParenSelect() {
      return !inUnionParenSelect.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUpdate_statement = new java.util.Stack<>();

	@Override
	public void enterUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		final Node node = model.newNode(Label.label("Update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUpdate_statement.push(true);
	}

	public void exitUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		onExit();
		this.inUpdate_statement.pop();
	}

	public boolean inUpdate_statement() {
      return !inUpdate_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInsert_statement_value = new java.util.Stack<>();

	@Override
	public void enterInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		final Node node = model.newNode(Label.label("Insert_statement_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInsert_statement_value.push(true);
	}

	public void exitInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		onExit();
		this.inInsert_statement_value.pop();
	}

	public boolean inInsert_statement_value() {
      return !inInsert_statement_value.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUpdate_elem = new java.util.Stack<>();

	@Override
	public void enterUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		final Node node = model.newNode(Label.label("Update_elem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUpdate_elem.push(true);
	}

	public void exitUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		onExit();
		this.inUpdate_elem.pop();
	}

	public boolean inUpdate_elem() {
      return !inUpdate_elem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCol_or_uservar = new java.util.Stack<>();

	@Override
	public void enterCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		final Node node = model.newNode(Label.label("Col_or_uservar"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCol_or_uservar.push(true);
	}

	public void exitCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		onExit();
		this.inCol_or_uservar.pop();
	}

	public boolean inCol_or_uservar() {
      return !inCol_or_uservar.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSingle_delete_statement = new java.util.Stack<>();

	@Override
	public void enterSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		final Node node = model.newNode(Label.label("Single_delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSingle_delete_statement.push(true);
	}

	public void exitSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		onExit();
		this.inSingle_delete_statement.pop();
	}

	public boolean inSingle_delete_statement() {
      return !inSingle_delete_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiple_delete_statement = new java.util.Stack<>();

	@Override
	public void enterMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		final Node node = model.newNode(Label.label("Multiple_delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMultiple_delete_statement.push(true);
	}

	public void exitMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		onExit();
		this.inMultiple_delete_statement.pop();
	}

	public boolean inMultiple_delete_statement() {
      return !inMultiple_delete_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandler_open_statement = new java.util.Stack<>();

	@Override
	public void enterHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		final Node node = model.newNode(Label.label("Handler_open_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHandler_open_statement.push(true);
	}

	public void exitHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		onExit();
		this.inHandler_open_statement.pop();
	}

	public boolean inHandler_open_statement() {
      return !inHandler_open_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandler_read_index_statement = new java.util.Stack<>();

	@Override
	public void enterHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		final Node node = model.newNode(Label.label("Handler_read_index_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHandler_read_index_statement.push(true);
	}

	public void exitHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		onExit();
		this.inHandler_read_index_statement.pop();
	}

	public boolean inHandler_read_index_statement() {
      return !inHandler_read_index_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandler_read_statement = new java.util.Stack<>();

	@Override
	public void enterHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		final Node node = model.newNode(Label.label("Handler_read_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHandler_read_statement.push(true);
	}

	public void exitHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		onExit();
		this.inHandler_read_statement.pop();
	}

	public boolean inHandler_read_statement() {
      return !inHandler_read_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandler_close_statement = new java.util.Stack<>();

	@Override
	public void enterHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		final Node node = model.newNode(Label.label("Handler_close_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHandler_close_statement.push(true);
	}

	public void exitHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		onExit();
		this.inHandler_close_statement.pop();
	}

	public boolean inHandler_close_statement() {
      return !inHandler_close_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSingle_update_statement = new java.util.Stack<>();

	@Override
	public void enterSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		final Node node = model.newNode(Label.label("Single_update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSingle_update_statement.push(true);
	}

	public void exitSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		onExit();
		this.inSingle_update_statement.pop();
	}

	public boolean inSingle_update_statement() {
      return !inSingle_update_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiple_update_statement = new java.util.Stack<>();

	@Override
	public void enterMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		final Node node = model.newNode(Label.label("Multiple_update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMultiple_update_statement.push(true);
	}

	public void exitMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		onExit();
		this.inMultiple_update_statement.pop();
	}

	public boolean inMultiple_update_statement() {
      return !inMultiple_update_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrder_by_clause = new java.util.Stack<>();

	@Override
	public void enterOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		final Node node = model.newNode(Label.label("Order_by_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOrder_by_clause.push(true);
	}

	public void exitOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		onExit();
		this.inOrder_by_clause.pop();
	}

	public boolean inOrder_by_clause() {
      return !inOrder_by_clause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrder_by_expression = new java.util.Stack<>();

	@Override
	public void enterOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		final Node node = model.newNode(Label.label("Order_by_expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOrder_by_expression.push(true);
	}

	public void exitOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		onExit();
		this.inOrder_by_expression.pop();
	}

	public boolean inOrder_by_expression() {
      return !inOrder_by_expression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTable_sources = new java.util.Stack<>();

	@Override
	public void enterTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		final Node node = model.newNode(Label.label("Table_sources"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTable_sources.push(true);
	}

	public void exitTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		onExit();
		this.inTable_sources.pop();
	}

	public boolean inTable_sources() {
      return !inTable_sources.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTable_source = new java.util.Stack<>();

	@Override
	public void enterTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		final Node node = model.newNode(Label.label("Table_source"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTable_source.push(true);
	}

	public void exitTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		onExit();
		this.inTable_source.pop();
	}

	public boolean inTable_source() {
      return !inTable_source.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAtomTableItem = new java.util.Stack<>();

	@Override
	public void enterAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		final Node node = model.newNode(Label.label("AtomTableItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAtomTableItem.push(true);
	}

	public void exitAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		onExit();
		this.inAtomTableItem.pop();
	}

	public boolean inAtomTableItem() {
      return !inAtomTableItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubqueryTableItem = new java.util.Stack<>();

	@Override
	public void enterSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		final Node node = model.newNode(Label.label("SubqueryTableItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubqueryTableItem.push(true);
	}

	public void exitSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		onExit();
		this.inSubqueryTableItem.pop();
	}

	public boolean inSubqueryTableItem() {
      return !inSubqueryTableItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTableSourcesItem = new java.util.Stack<>();

	@Override
	public void enterTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		final Node node = model.newNode(Label.label("TableSourcesItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTableSourcesItem.push(true);
	}

	public void exitTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		onExit();
		this.inTableSourcesItem.pop();
	}

	public boolean inTableSourcesItem() {
      return !inTableSourcesItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndex_hint = new java.util.Stack<>();

	@Override
	public void enterIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		final Node node = model.newNode(Label.label("Index_hint"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIndex_hint.push(true);
	}

	public void exitIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		onExit();
		this.inIndex_hint.pop();
	}

	public boolean inIndex_hint() {
      return !inIndex_hint.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInnerJoin = new java.util.Stack<>();

	@Override
	public void enterInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		final Node node = model.newNode(Label.label("InnerJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInnerJoin.push(true);
	}

	public void exitInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		onExit();
		this.inInnerJoin.pop();
	}

	public boolean inInnerJoin() {
      return !inInnerJoin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStraightJoin = new java.util.Stack<>();

	@Override
	public void enterStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		final Node node = model.newNode(Label.label("StraightJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStraightJoin.push(true);
	}

	public void exitStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		onExit();
		this.inStraightJoin.pop();
	}

	public boolean inStraightJoin() {
      return !inStraightJoin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOuterJoin = new java.util.Stack<>();

	@Override
	public void enterOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		final Node node = model.newNode(Label.label("OuterJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOuterJoin.push(true);
	}

	public void exitOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		onExit();
		this.inOuterJoin.pop();
	}

	public boolean inOuterJoin() {
      return !inOuterJoin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNaturalJoin = new java.util.Stack<>();

	@Override
	public void enterNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		final Node node = model.newNode(Label.label("NaturalJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNaturalJoin.push(true);
	}

	public void exitNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		onExit();
		this.inNaturalJoin.pop();
	}

	public boolean inNaturalJoin() {
      return !inNaturalJoin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubquery = new java.util.Stack<>();

	@Override
	public void enterSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		final Node node = model.newNode(Label.label("Subquery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubquery.push(true);
	}

	public void exitSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		onExit();
		this.inSubquery.pop();
	}

	public boolean inSubquery() {
      return !inSubquery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery_expression = new java.util.Stack<>();

	@Override
	public void enterQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		final Node node = model.newNode(Label.label("Query_expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQuery_expression.push(true);
	}

	public void exitQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		onExit();
		this.inQuery_expression.pop();
	}

	public boolean inQuery_expression() {
      return !inQuery_expression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery_expression_nointo = new java.util.Stack<>();

	@Override
	public void enterQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		final Node node = model.newNode(Label.label("Query_expression_nointo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQuery_expression_nointo.push(true);
	}

	public void exitQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		onExit();
		this.inQuery_expression_nointo.pop();
	}

	public boolean inQuery_expression_nointo() {
      return !inQuery_expression_nointo.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery_specification = new java.util.Stack<>();

	@Override
	public void enterQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		final Node node = model.newNode(Label.label("Query_specification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQuery_specification.push(true);
	}

	public void exitQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		onExit();
		this.inQuery_specification.pop();
	}

	public boolean inQuery_specification() {
      return !inQuery_specification.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery_specification_nointo = new java.util.Stack<>();

	@Override
	public void enterQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		final Node node = model.newNode(Label.label("Query_specification_nointo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQuery_specification_nointo.push(true);
	}

	public void exitQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		onExit();
		this.inQuery_specification_nointo.pop();
	}

	public boolean inQuery_specification_nointo() {
      return !inQuery_specification_nointo.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnion_parenth = new java.util.Stack<>();

	@Override
	public void enterUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		final Node node = model.newNode(Label.label("Union_parenth"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnion_parenth.push(true);
	}

	public void exitUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		onExit();
		this.inUnion_parenth.pop();
	}

	public boolean inUnion_parenth() {
      return !inUnion_parenth.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnion_statement = new java.util.Stack<>();

	@Override
	public void enterUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		final Node node = model.newNode(Label.label("Union_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnion_statement.push(true);
	}

	public void exitUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		onExit();
		this.inUnion_statement.pop();
	}

	public boolean inUnion_statement() {
      return !inUnion_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelect_spec = new java.util.Stack<>();

	@Override
	public void enterSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		final Node node = model.newNode(Label.label("Select_spec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelect_spec.push(true);
	}

	public void exitSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		onExit();
		this.inSelect_spec.pop();
	}

	public boolean inSelect_spec() {
      return !inSelect_spec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelect_list = new java.util.Stack<>();

	@Override
	public void enterSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		final Node node = model.newNode(Label.label("Select_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelect_list.push(true);
	}

	public void exitSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		onExit();
		this.inSelect_list.pop();
	}

	public boolean inSelect_list() {
      return !inSelect_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSellistelAllCol = new java.util.Stack<>();

	@Override
	public void enterSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		final Node node = model.newNode(Label.label("SellistelAllCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSellistelAllCol.push(true);
	}

	public void exitSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		onExit();
		this.inSellistelAllCol.pop();
	}

	public boolean inSellistelAllCol() {
      return !inSellistelAllCol.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSellistelCol = new java.util.Stack<>();

	@Override
	public void enterSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		final Node node = model.newNode(Label.label("SellistelCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSellistelCol.push(true);
	}

	public void exitSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		onExit();
		this.inSellistelCol.pop();
	}

	public boolean inSellistelCol() {
      return !inSellistelCol.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSellistelFunc = new java.util.Stack<>();

	@Override
	public void enterSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		final Node node = model.newNode(Label.label("SellistelFunc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSellistelFunc.push(true);
	}

	public void exitSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		onExit();
		this.inSellistelFunc.pop();
	}

	public boolean inSellistelFunc() {
      return !inSellistelFunc.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSellistelExpr = new java.util.Stack<>();

	@Override
	public void enterSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		final Node node = model.newNode(Label.label("SellistelExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSellistelExpr.push(true);
	}

	public void exitSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		onExit();
		this.inSellistelExpr.pop();
	}

	public boolean inSellistelExpr() {
      return !inSellistelExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectIntoVars = new java.util.Stack<>();

	@Override
	public void enterSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		final Node node = model.newNode(Label.label("SelectIntoVars"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelectIntoVars.push(true);
	}

	public void exitSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		onExit();
		this.inSelectIntoVars.pop();
	}

	public boolean inSelectIntoVars() {
      return !inSelectIntoVars.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectIntoDump = new java.util.Stack<>();

	@Override
	public void enterSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		final Node node = model.newNode(Label.label("SelectIntoDump"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelectIntoDump.push(true);
	}

	public void exitSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		onExit();
		this.inSelectIntoDump.pop();
	}

	public boolean inSelectIntoDump() {
      return !inSelectIntoDump.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectIntoOutfile = new java.util.Stack<>();

	@Override
	public void enterSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		final Node node = model.newNode(Label.label("SelectIntoOutfile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelectIntoOutfile.push(true);
	}

	public void exitSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		onExit();
		this.inSelectIntoOutfile.pop();
	}

	public boolean inSelectIntoOutfile() {
      return !inSelectIntoOutfile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFrom_clause = new java.util.Stack<>();

	@Override
	public void enterFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		final Node node = model.newNode(Label.label("From_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFrom_clause.push(true);
	}

	public void exitFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		onExit();
		this.inFrom_clause.pop();
	}

	public boolean inFrom_clause() {
      return !inFrom_clause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGroup_by_item = new java.util.Stack<>();

	@Override
	public void enterGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		final Node node = model.newNode(Label.label("Group_by_item"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGroup_by_item.push(true);
	}

	public void exitGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		onExit();
		this.inGroup_by_item.pop();
	}

	public boolean inGroup_by_item() {
      return !inGroup_by_item.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLimit_clause = new java.util.Stack<>();

	@Override
	public void enterLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		final Node node = model.newNode(Label.label("Limit_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLimit_clause.push(true);
	}

	public void exitLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		onExit();
		this.inLimit_clause.pop();
	}

	public boolean inLimit_clause() {
      return !inLimit_clause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStart_transaction = new java.util.Stack<>();

	@Override
	public void enterStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		final Node node = model.newNode(Label.label("Start_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStart_transaction.push(true);
	}

	public void exitStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		onExit();
		this.inStart_transaction.pop();
	}

	public boolean inStart_transaction() {
      return !inStart_transaction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBegin_work = new java.util.Stack<>();

	@Override
	public void enterBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		final Node node = model.newNode(Label.label("Begin_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBegin_work.push(true);
	}

	public void exitBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		onExit();
		this.inBegin_work.pop();
	}

	public boolean inBegin_work() {
      return !inBegin_work.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCommit_work = new java.util.Stack<>();

	@Override
	public void enterCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		final Node node = model.newNode(Label.label("Commit_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCommit_work.push(true);
	}

	public void exitCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		onExit();
		this.inCommit_work.pop();
	}

	public boolean inCommit_work() {
      return !inCommit_work.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRollback_work = new java.util.Stack<>();

	@Override
	public void enterRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		final Node node = model.newNode(Label.label("Rollback_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRollback_work.push(true);
	}

	public void exitRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		onExit();
		this.inRollback_work.pop();
	}

	public boolean inRollback_work() {
      return !inRollback_work.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSavepoint_statement = new java.util.Stack<>();

	@Override
	public void enterSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		final Node node = model.newNode(Label.label("Savepoint_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSavepoint_statement.push(true);
	}

	public void exitSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		onExit();
		this.inSavepoint_statement.pop();
	}

	public boolean inSavepoint_statement() {
      return !inSavepoint_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRollback_statement = new java.util.Stack<>();

	@Override
	public void enterRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		final Node node = model.newNode(Label.label("Rollback_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRollback_statement.push(true);
	}

	public void exitRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		onExit();
		this.inRollback_statement.pop();
	}

	public boolean inRollback_statement() {
      return !inRollback_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelease_statement = new java.util.Stack<>();

	@Override
	public void enterRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		final Node node = model.newNode(Label.label("Release_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRelease_statement.push(true);
	}

	public void exitRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		onExit();
		this.inRelease_statement.pop();
	}

	public boolean inRelease_statement() {
      return !inRelease_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLock_tables = new java.util.Stack<>();

	@Override
	public void enterLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		final Node node = model.newNode(Label.label("Lock_tables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLock_tables.push(true);
	}

	public void exitLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		onExit();
		this.inLock_tables.pop();
	}

	public boolean inLock_tables() {
      return !inLock_tables.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnlock_tables = new java.util.Stack<>();

	@Override
	public void enterUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		final Node node = model.newNode(Label.label("Unlock_tables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnlock_tables.push(true);
	}

	public void exitUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		onExit();
		this.inUnlock_tables.pop();
	}

	public boolean inUnlock_tables() {
      return !inUnlock_tables.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSet_autocommit_statement = new java.util.Stack<>();

	@Override
	public void enterSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		final Node node = model.newNode(Label.label("Set_autocommit_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSet_autocommit_statement.push(true);
	}

	public void exitSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		onExit();
		this.inSet_autocommit_statement.pop();
	}

	public boolean inSet_autocommit_statement() {
      return !inSet_autocommit_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSet_transaction_statement = new java.util.Stack<>();

	@Override
	public void enterSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		final Node node = model.newNode(Label.label("Set_transaction_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSet_transaction_statement.push(true);
	}

	public void exitSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		onExit();
		this.inSet_transaction_statement.pop();
	}

	public boolean inSet_transaction_statement() {
      return !inSet_transaction_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTransact_option = new java.util.Stack<>();

	@Override
	public void enterTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		final Node node = model.newNode(Label.label("Transact_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTransact_option.push(true);
	}

	public void exitTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		onExit();
		this.inTransact_option.pop();
	}

	public boolean inTransact_option() {
      return !inTransact_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLock_table_element = new java.util.Stack<>();

	@Override
	public void enterLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		final Node node = model.newNode(Label.label("Lock_table_element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLock_table_element.push(true);
	}

	public void exitLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		onExit();
		this.inLock_table_element.pop();
	}

	public boolean inLock_table_element() {
      return !inLock_table_element.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTrans_characteristic = new java.util.Stack<>();

	@Override
	public void enterTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		final Node node = model.newNode(Label.label("Trans_characteristic"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTrans_characteristic.push(true);
	}

	public void exitTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		onExit();
		this.inTrans_characteristic.pop();
	}

	public boolean inTrans_characteristic() {
      return !inTrans_characteristic.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTransaction_level = new java.util.Stack<>();

	@Override
	public void enterTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		final Node node = model.newNode(Label.label("Transaction_level"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTransaction_level.push(true);
	}

	public void exitTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		onExit();
		this.inTransaction_level.pop();
	}

	public boolean inTransaction_level() {
      return !inTransaction_level.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChange_master = new java.util.Stack<>();

	@Override
	public void enterChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		final Node node = model.newNode(Label.label("Change_master"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inChange_master.push(true);
	}

	public void exitChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		onExit();
		this.inChange_master.pop();
	}

	public boolean inChange_master() {
      return !inChange_master.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChange_repl_filter = new java.util.Stack<>();

	@Override
	public void enterChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		final Node node = model.newNode(Label.label("Change_repl_filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inChange_repl_filter.push(true);
	}

	public void exitChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		onExit();
		this.inChange_repl_filter.pop();
	}

	public boolean inChange_repl_filter() {
      return !inChange_repl_filter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPurge_binary_logs = new java.util.Stack<>();

	@Override
	public void enterPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		final Node node = model.newNode(Label.label("Purge_binary_logs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPurge_binary_logs.push(true);
	}

	public void exitPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		onExit();
		this.inPurge_binary_logs.pop();
	}

	public boolean inPurge_binary_logs() {
      return !inPurge_binary_logs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReset_master = new java.util.Stack<>();

	@Override
	public void enterReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		final Node node = model.newNode(Label.label("Reset_master"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReset_master.push(true);
	}

	public void exitReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		onExit();
		this.inReset_master.pop();
	}

	public boolean inReset_master() {
      return !inReset_master.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReset_slave = new java.util.Stack<>();

	@Override
	public void enterReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		final Node node = model.newNode(Label.label("Reset_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReset_slave.push(true);
	}

	public void exitReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		onExit();
		this.inReset_slave.pop();
	}

	public boolean inReset_slave() {
      return !inReset_slave.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStart_slave = new java.util.Stack<>();

	@Override
	public void enterStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		final Node node = model.newNode(Label.label("Start_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStart_slave.push(true);
	}

	public void exitStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		onExit();
		this.inStart_slave.pop();
	}

	public boolean inStart_slave() {
      return !inStart_slave.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStop_slave = new java.util.Stack<>();

	@Override
	public void enterStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		final Node node = model.newNode(Label.label("Stop_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStop_slave.push(true);
	}

	public void exitStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		onExit();
		this.inStop_slave.pop();
	}

	public boolean inStop_slave() {
      return !inStop_slave.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStart_group_repl = new java.util.Stack<>();

	@Override
	public void enterStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		final Node node = model.newNode(Label.label("Start_group_repl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStart_group_repl.push(true);
	}

	public void exitStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		onExit();
		this.inStart_group_repl.pop();
	}

	public boolean inStart_group_repl() {
      return !inStart_group_repl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStop_group_repl = new java.util.Stack<>();

	@Override
	public void enterStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		final Node node = model.newNode(Label.label("Stop_group_repl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStop_group_repl.push(true);
	}

	public void exitStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		onExit();
		this.inStop_group_repl.pop();
	}

	public boolean inStop_group_repl() {
      return !inStop_group_repl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMasterOptString = new java.util.Stack<>();

	@Override
	public void enterMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		final Node node = model.newNode(Label.label("MasterOptString"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMasterOptString.push(true);
	}

	public void exitMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		onExit();
		this.inMasterOptString.pop();
	}

	public boolean inMasterOptString() {
      return !inMasterOptString.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMasterOptDecimal = new java.util.Stack<>();

	@Override
	public void enterMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		final Node node = model.newNode(Label.label("MasterOptDecimal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMasterOptDecimal.push(true);
	}

	public void exitMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		onExit();
		this.inMasterOptDecimal.pop();
	}

	public boolean inMasterOptDecimal() {
      return !inMasterOptDecimal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMasterOptBool = new java.util.Stack<>();

	@Override
	public void enterMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		final Node node = model.newNode(Label.label("MasterOptBool"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMasterOptBool.push(true);
	}

	public void exitMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		onExit();
		this.inMasterOptBool.pop();
	}

	public boolean inMasterOptBool() {
      return !inMasterOptBool.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMasterOptReal = new java.util.Stack<>();

	@Override
	public void enterMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		final Node node = model.newNode(Label.label("MasterOptReal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMasterOptReal.push(true);
	}

	public void exitMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		onExit();
		this.inMasterOptReal.pop();
	}

	public boolean inMasterOptReal() {
      return !inMasterOptReal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMasterOptIdList = new java.util.Stack<>();

	@Override
	public void enterMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		final Node node = model.newNode(Label.label("MasterOptIdList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMasterOptIdList.push(true);
	}

	public void exitMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		onExit();
		this.inMasterOptIdList.pop();
	}

	public boolean inMasterOptIdList() {
      return !inMasterOptIdList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inString_master_option = new java.util.Stack<>();

	@Override
	public void enterString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		final Node node = model.newNode(Label.label("String_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inString_master_option.push(true);
	}

	public void exitString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		onExit();
		this.inString_master_option.pop();
	}

	public boolean inString_master_option() {
      return !inString_master_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDecimal_master_option = new java.util.Stack<>();

	@Override
	public void enterDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		final Node node = model.newNode(Label.label("Decimal_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDecimal_master_option.push(true);
	}

	public void exitDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		onExit();
		this.inDecimal_master_option.pop();
	}

	public boolean inDecimal_master_option() {
      return !inDecimal_master_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBool_master_option = new java.util.Stack<>();

	@Override
	public void enterBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		final Node node = model.newNode(Label.label("Bool_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBool_master_option.push(true);
	}

	public void exitBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		onExit();
		this.inBool_master_option.pop();
	}

	public boolean inBool_master_option() {
      return !inBool_master_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChannel_option = new java.util.Stack<>();

	@Override
	public void enterChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		final Node node = model.newNode(Label.label("Channel_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inChannel_option.push(true);
	}

	public void exitChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		onExit();
		this.inChannel_option.pop();
	}

	public boolean inChannel_option() {
      return !inChannel_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReplfilterDbList = new java.util.Stack<>();

	@Override
	public void enterReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		final Node node = model.newNode(Label.label("ReplfilterDbList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReplfilterDbList.push(true);
	}

	public void exitReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		onExit();
		this.inReplfilterDbList.pop();
	}

	public boolean inReplfilterDbList() {
      return !inReplfilterDbList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReplfilterTableList = new java.util.Stack<>();

	@Override
	public void enterReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		final Node node = model.newNode(Label.label("ReplfilterTableList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReplfilterTableList.push(true);
	}

	public void exitReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		onExit();
		this.inReplfilterTableList.pop();
	}

	public boolean inReplfilterTableList() {
      return !inReplfilterTableList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReplfilterStableList = new java.util.Stack<>();

	@Override
	public void enterReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		final Node node = model.newNode(Label.label("ReplfilterStableList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReplfilterStableList.push(true);
	}

	public void exitReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		onExit();
		this.inReplfilterStableList.pop();
	}

	public boolean inReplfilterStableList() {
      return !inReplfilterStableList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReplfilterTablepairList = new java.util.Stack<>();

	@Override
	public void enterReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		final Node node = model.newNode(Label.label("ReplfilterTablepairList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReplfilterTablepairList.push(true);
	}

	public void exitReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		onExit();
		this.inReplfilterTablepairList.pop();
	}

	public boolean inReplfilterTablepairList() {
      return !inReplfilterTablepairList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inThread_type = new java.util.Stack<>();

	@Override
	public void enterThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		final Node node = model.newNode(Label.label("Thread_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inThread_type.push(true);
	}

	public void exitThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		onExit();
		this.inThread_type.pop();
	}

	public boolean inThread_type() {
      return !inThread_type.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUntilGtidSset = new java.util.Stack<>();

	@Override
	public void enterUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		final Node node = model.newNode(Label.label("UntilGtidSset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUntilGtidSset.push(true);
	}

	public void exitUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		onExit();
		this.inUntilGtidSset.pop();
	}

	public boolean inUntilGtidSset() {
      return !inUntilGtidSset.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUntilMasterLog = new java.util.Stack<>();

	@Override
	public void enterUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		final Node node = model.newNode(Label.label("UntilMasterLog"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUntilMasterLog.push(true);
	}

	public void exitUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		onExit();
		this.inUntilMasterLog.pop();
	}

	public boolean inUntilMasterLog() {
      return !inUntilMasterLog.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUntilRelayLog = new java.util.Stack<>();

	@Override
	public void enterUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		final Node node = model.newNode(Label.label("UntilRelayLog"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUntilRelayLog.push(true);
	}

	public void exitUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		onExit();
		this.inUntilRelayLog.pop();
	}

	public boolean inUntilRelayLog() {
      return !inUntilRelayLog.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUntilSqlGaps = new java.util.Stack<>();

	@Override
	public void enterUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		final Node node = model.newNode(Label.label("UntilSqlGaps"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUntilSqlGaps.push(true);
	}

	public void exitUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		onExit();
		this.inUntilSqlGaps.pop();
	}

	public boolean inUntilSqlGaps() {
      return !inUntilSqlGaps.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStart_slave_connection_option = new java.util.Stack<>();

	@Override
	public void enterStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		final Node node = model.newNode(Label.label("Start_slave_connection_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStart_slave_connection_option.push(true);
	}

	public void exitStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		onExit();
		this.inStart_slave_connection_option.pop();
	}

	public boolean inStart_slave_connection_option() {
      return !inStart_slave_connection_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGtid_set = new java.util.Stack<>();

	@Override
	public void enterGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		final Node node = model.newNode(Label.label("Gtid_set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGtid_set.push(true);
	}

	public void exitGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		onExit();
		this.inGtid_set.pop();
	}

	public boolean inGtid_set() {
      return !inGtid_set.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXa_start_transaction = new java.util.Stack<>();

	@Override
	public void enterXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		final Node node = model.newNode(Label.label("Xa_start_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXa_start_transaction.push(true);
	}

	public void exitXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		onExit();
		this.inXa_start_transaction.pop();
	}

	public boolean inXa_start_transaction() {
      return !inXa_start_transaction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXa_end_transaction = new java.util.Stack<>();

	@Override
	public void enterXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		final Node node = model.newNode(Label.label("Xa_end_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXa_end_transaction.push(true);
	}

	public void exitXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		onExit();
		this.inXa_end_transaction.pop();
	}

	public boolean inXa_end_transaction() {
      return !inXa_end_transaction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXa_prepare = new java.util.Stack<>();

	@Override
	public void enterXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		final Node node = model.newNode(Label.label("Xa_prepare"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXa_prepare.push(true);
	}

	public void exitXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		onExit();
		this.inXa_prepare.pop();
	}

	public boolean inXa_prepare() {
      return !inXa_prepare.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXa_commit_work = new java.util.Stack<>();

	@Override
	public void enterXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		final Node node = model.newNode(Label.label("Xa_commit_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXa_commit_work.push(true);
	}

	public void exitXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		onExit();
		this.inXa_commit_work.pop();
	}

	public boolean inXa_commit_work() {
      return !inXa_commit_work.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXa_rollback_work = new java.util.Stack<>();

	@Override
	public void enterXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		final Node node = model.newNode(Label.label("Xa_rollback_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXa_rollback_work.push(true);
	}

	public void exitXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		onExit();
		this.inXa_rollback_work.pop();
	}

	public boolean inXa_rollback_work() {
      return !inXa_rollback_work.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXa_recover_work = new java.util.Stack<>();

	@Override
	public void enterXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		final Node node = model.newNode(Label.label("Xa_recover_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXa_recover_work.push(true);
	}

	public void exitXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		onExit();
		this.inXa_recover_work.pop();
	}

	public boolean inXa_recover_work() {
      return !inXa_recover_work.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrepare_statement = new java.util.Stack<>();

	@Override
	public void enterPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		final Node node = model.newNode(Label.label("Prepare_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrepare_statement.push(true);
	}

	public void exitPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		onExit();
		this.inPrepare_statement.pop();
	}

	public boolean inPrepare_statement() {
      return !inPrepare_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExecute_statement = new java.util.Stack<>();

	@Override
	public void enterExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		final Node node = model.newNode(Label.label("Execute_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExecute_statement.push(true);
	}

	public void exitExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		onExit();
		this.inExecute_statement.pop();
	}

	public boolean inExecute_statement() {
      return !inExecute_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeallocate_prepare = new java.util.Stack<>();

	@Override
	public void enterDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		final Node node = model.newNode(Label.label("Deallocate_prepare"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDeallocate_prepare.push(true);
	}

	public void exitDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		onExit();
		this.inDeallocate_prepare.pop();
	}

	public boolean inDeallocate_prepare() {
      return !inDeallocate_prepare.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRoutine_body = new java.util.Stack<>();

	@Override
	public void enterRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		final Node node = model.newNode(Label.label("Routine_body"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRoutine_body.push(true);
	}

	public void exitRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		onExit();
		this.inRoutine_body.pop();
	}

	public boolean inRoutine_body() {
      return !inRoutine_body.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlock_statement = new java.util.Stack<>();

	@Override
	public void enterBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		final Node node = model.newNode(Label.label("Block_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlock_statement.push(true);
	}

	public void exitBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		onExit();
		this.inBlock_statement.pop();
	}

	public boolean inBlock_statement() {
      return !inBlock_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCase_statement = new java.util.Stack<>();

	@Override
	public void enterCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		final Node node = model.newNode(Label.label("Case_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCase_statement.push(true);
	}

	public void exitCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		onExit();
		this.inCase_statement.pop();
	}

	public boolean inCase_statement() {
      return !inCase_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIf_statement = new java.util.Stack<>();

	@Override
	public void enterIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		final Node node = model.newNode(Label.label("If_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIf_statement.push(true);
	}

	public void exitIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		onExit();
		this.inIf_statement.pop();
	}

	public boolean inIf_statement() {
      return !inIf_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIterate_statement = new java.util.Stack<>();

	@Override
	public void enterIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		final Node node = model.newNode(Label.label("Iterate_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIterate_statement.push(true);
	}

	public void exitIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		onExit();
		this.inIterate_statement.pop();
	}

	public boolean inIterate_statement() {
      return !inIterate_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLeave_statement = new java.util.Stack<>();

	@Override
	public void enterLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		final Node node = model.newNode(Label.label("Leave_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLeave_statement.push(true);
	}

	public void exitLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		onExit();
		this.inLeave_statement.pop();
	}

	public boolean inLeave_statement() {
      return !inLeave_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLoop_statement = new java.util.Stack<>();

	@Override
	public void enterLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		final Node node = model.newNode(Label.label("Loop_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLoop_statement.push(true);
	}

	public void exitLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		onExit();
		this.inLoop_statement.pop();
	}

	public boolean inLoop_statement() {
      return !inLoop_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRepeat_statement = new java.util.Stack<>();

	@Override
	public void enterRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		final Node node = model.newNode(Label.label("Repeat_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRepeat_statement.push(true);
	}

	public void exitRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		onExit();
		this.inRepeat_statement.pop();
	}

	public boolean inRepeat_statement() {
      return !inRepeat_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturn_statement = new java.util.Stack<>();

	@Override
	public void enterReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		final Node node = model.newNode(Label.label("Return_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReturn_statement.push(true);
	}

	public void exitReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		onExit();
		this.inReturn_statement.pop();
	}

	public boolean inReturn_statement() {
      return !inReturn_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWhile_statement = new java.util.Stack<>();

	@Override
	public void enterWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		final Node node = model.newNode(Label.label("While_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inWhile_statement.push(true);
	}

	public void exitWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		onExit();
		this.inWhile_statement.pop();
	}

	public boolean inWhile_statement() {
      return !inWhile_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCursor_statement = new java.util.Stack<>();

	@Override
	public void enterCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		final Node node = model.newNode(Label.label("Cursor_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCursor_statement.push(true);
	}

	public void exitCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		onExit();
		this.inCursor_statement.pop();
	}

	public boolean inCursor_statement() {
      return !inCursor_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclare_variable = new java.util.Stack<>();

	@Override
	public void enterDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		final Node node = model.newNode(Label.label("Declare_variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDeclare_variable.push(true);
	}

	public void exitDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		onExit();
		this.inDeclare_variable.pop();
	}

	public boolean inDeclare_variable() {
      return !inDeclare_variable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclare_condition = new java.util.Stack<>();

	@Override
	public void enterDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		final Node node = model.newNode(Label.label("Declare_condition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDeclare_condition.push(true);
	}

	public void exitDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		onExit();
		this.inDeclare_condition.pop();
	}

	public boolean inDeclare_condition() {
      return !inDeclare_condition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclare_cursor = new java.util.Stack<>();

	@Override
	public void enterDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		final Node node = model.newNode(Label.label("Declare_cursor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDeclare_cursor.push(true);
	}

	public void exitDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		onExit();
		this.inDeclare_cursor.pop();
	}

	public boolean inDeclare_cursor() {
      return !inDeclare_cursor.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclare_handler = new java.util.Stack<>();

	@Override
	public void enterDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		final Node node = model.newNode(Label.label("Declare_handler"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDeclare_handler.push(true);
	}

	public void exitDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		onExit();
		this.inDeclare_handler.pop();
	}

	public boolean inDeclare_handler() {
      return !inDeclare_handler.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandler_condition_value = new java.util.Stack<>();

	@Override
	public void enterHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		final Node node = model.newNode(Label.label("Handler_condition_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHandler_condition_value.push(true);
	}

	public void exitHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		onExit();
		this.inHandler_condition_value.pop();
	}

	public boolean inHandler_condition_value() {
      return !inHandler_condition_value.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProcedure_sql_statement = new java.util.Stack<>();

	@Override
	public void enterProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		final Node node = model.newNode(Label.label("Procedure_sql_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inProcedure_sql_statement.push(true);
	}

	public void exitProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		onExit();
		this.inProcedure_sql_statement.pop();
	}

	public boolean inProcedure_sql_statement() {
      return !inProcedure_sql_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlterUserMysql56 = new java.util.Stack<>();

	@Override
	public void enterAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		final Node node = model.newNode(Label.label("AlterUserMysql56"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlterUserMysql56.push(true);
	}

	public void exitAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		onExit();
		this.inAlterUserMysql56.pop();
	}

	public boolean inAlterUserMysql56() {
      return !inAlterUserMysql56.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlterUserMysql57 = new java.util.Stack<>();

	@Override
	public void enterAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		final Node node = model.newNode(Label.label("AlterUserMysql57"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlterUserMysql57.push(true);
	}

	public void exitAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		onExit();
		this.inAlterUserMysql57.pop();
	}

	public boolean inAlterUserMysql57() {
      return !inAlterUserMysql57.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreateUserMysql56 = new java.util.Stack<>();

	@Override
	public void enterCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		final Node node = model.newNode(Label.label("CreateUserMysql56"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreateUserMysql56.push(true);
	}

	public void exitCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		onExit();
		this.inCreateUserMysql56.pop();
	}

	public boolean inCreateUserMysql56() {
      return !inCreateUserMysql56.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreateUserMysql57 = new java.util.Stack<>();

	@Override
	public void enterCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		final Node node = model.newNode(Label.label("CreateUserMysql57"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreateUserMysql57.push(true);
	}

	public void exitCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		onExit();
		this.inCreateUserMysql57.pop();
	}

	public boolean inCreateUserMysql57() {
      return !inCreateUserMysql57.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDrop_user = new java.util.Stack<>();

	@Override
	public void enterDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		final Node node = model.newNode(Label.label("Drop_user"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDrop_user.push(true);
	}

	public void exitDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		onExit();
		this.inDrop_user.pop();
	}

	public boolean inDrop_user() {
      return !inDrop_user.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGrant_statement = new java.util.Stack<>();

	@Override
	public void enterGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		final Node node = model.newNode(Label.label("Grant_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGrant_statement.push(true);
	}

	public void exitGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		onExit();
		this.inGrant_statement.pop();
	}

	public boolean inGrant_statement() {
      return !inGrant_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGrant_proxy = new java.util.Stack<>();

	@Override
	public void enterGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		final Node node = model.newNode(Label.label("Grant_proxy"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGrant_proxy.push(true);
	}

	public void exitGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		onExit();
		this.inGrant_proxy.pop();
	}

	public boolean inGrant_proxy() {
      return !inGrant_proxy.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRename_user = new java.util.Stack<>();

	@Override
	public void enterRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		final Node node = model.newNode(Label.label("Rename_user"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRename_user.push(true);
	}

	public void exitRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		onExit();
		this.inRename_user.pop();
	}

	public boolean inRename_user() {
      return !inRename_user.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDetailRevoke = new java.util.Stack<>();

	@Override
	public void enterDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		final Node node = model.newNode(Label.label("DetailRevoke"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDetailRevoke.push(true);
	}

	public void exitDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		onExit();
		this.inDetailRevoke.pop();
	}

	public boolean inDetailRevoke() {
      return !inDetailRevoke.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShortRevoke = new java.util.Stack<>();

	@Override
	public void enterShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		final Node node = model.newNode(Label.label("ShortRevoke"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShortRevoke.push(true);
	}

	public void exitShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		onExit();
		this.inShortRevoke.pop();
	}

	public boolean inShortRevoke() {
      return !inShortRevoke.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRevoke_proxy = new java.util.Stack<>();

	@Override
	public void enterRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		final Node node = model.newNode(Label.label("Revoke_proxy"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRevoke_proxy.push(true);
	}

	public void exitRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		onExit();
		this.inRevoke_proxy.pop();
	}

	public boolean inRevoke_proxy() {
      return !inRevoke_proxy.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSet_password_statement = new java.util.Stack<>();

	@Override
	public void enterSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		final Node node = model.newNode(Label.label("Set_password_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSet_password_statement.push(true);
	}

	public void exitSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		onExit();
		this.inSet_password_statement.pop();
	}

	public boolean inSet_password_statement() {
      return !inSet_password_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUser_password_option = new java.util.Stack<>();

	@Override
	public void enterUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		final Node node = model.newNode(Label.label("User_password_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUser_password_option.push(true);
	}

	public void exitUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		onExit();
		this.inUser_password_option.pop();
	}

	public boolean inUser_password_option() {
      return !inUser_password_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAuthByPassword = new java.util.Stack<>();

	@Override
	public void enterAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		final Node node = model.newNode(Label.label("AuthByPassword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAuthByPassword.push(true);
	}

	public void exitAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		onExit();
		this.inAuthByPassword.pop();
	}

	public boolean inAuthByPassword() {
      return !inAuthByPassword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAuthByString = new java.util.Stack<>();

	@Override
	public void enterAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		final Node node = model.newNode(Label.label("AuthByString"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAuthByString.push(true);
	}

	public void exitAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		onExit();
		this.inAuthByString.pop();
	}

	public boolean inAuthByString() {
      return !inAuthByString.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAuthByHash = new java.util.Stack<>();

	@Override
	public void enterAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		final Node node = model.newNode(Label.label("AuthByHash"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAuthByHash.push(true);
	}

	public void exitAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		onExit();
		this.inAuthByHash.pop();
	}

	public boolean inAuthByHash() {
      return !inAuthByHash.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUser_resource_option = new java.util.Stack<>();

	@Override
	public void enterUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		final Node node = model.newNode(Label.label("User_resource_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUser_resource_option.push(true);
	}

	public void exitUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		onExit();
		this.inUser_resource_option.pop();
	}

	public boolean inUser_resource_option() {
      return !inUser_resource_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUser_lock_option = new java.util.Stack<>();

	@Override
	public void enterUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		final Node node = model.newNode(Label.label("User_lock_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUser_lock_option.push(true);
	}

	public void exitUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		onExit();
		this.inUser_lock_option.pop();
	}

	public boolean inUser_lock_option() {
      return !inUser_lock_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrivelege_clause = new java.util.Stack<>();

	@Override
	public void enterPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		final Node node = model.newNode(Label.label("Privelege_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrivelege_clause.push(true);
	}

	public void exitPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		onExit();
		this.inPrivelege_clause.pop();
	}

	public boolean inPrivelege_clause() {
      return !inPrivelege_clause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrivilege = new java.util.Stack<>();

	@Override
	public void enterPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		final Node node = model.newNode(Label.label("Privilege"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrivilege.push(true);
	}

	public void exitPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		onExit();
		this.inPrivilege.pop();
	}

	public boolean inPrivilege() {
      return !inPrivilege.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrivilege_level = new java.util.Stack<>();

	@Override
	public void enterPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		final Node node = model.newNode(Label.label("Privilege_level"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrivilege_level.push(true);
	}

	public void exitPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		onExit();
		this.inPrivilege_level.pop();
	}

	public boolean inPrivilege_level() {
      return !inPrivilege_level.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSet_password_option = new java.util.Stack<>();

	@Override
	public void enterSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		final Node node = model.newNode(Label.label("Set_password_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSet_password_option.push(true);
	}

	public void exitSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		onExit();
		this.inSet_password_option.pop();
	}

	public boolean inSet_password_option() {
      return !inSet_password_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnalyze_table = new java.util.Stack<>();

	@Override
	public void enterAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		final Node node = model.newNode(Label.label("Analyze_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnalyze_table.push(true);
	}

	public void exitAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		onExit();
		this.inAnalyze_table.pop();
	}

	public boolean inAnalyze_table() {
      return !inAnalyze_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCheck_table = new java.util.Stack<>();

	@Override
	public void enterCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		final Node node = model.newNode(Label.label("Check_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCheck_table.push(true);
	}

	public void exitCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		onExit();
		this.inCheck_table.pop();
	}

	public boolean inCheck_table() {
      return !inCheck_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChecksum_table = new java.util.Stack<>();

	@Override
	public void enterChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		final Node node = model.newNode(Label.label("Checksum_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inChecksum_table.push(true);
	}

	public void exitChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		onExit();
		this.inChecksum_table.pop();
	}

	public boolean inChecksum_table() {
      return !inChecksum_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOptimize_table = new java.util.Stack<>();

	@Override
	public void enterOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		final Node node = model.newNode(Label.label("Optimize_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOptimize_table.push(true);
	}

	public void exitOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		onExit();
		this.inOptimize_table.pop();
	}

	public boolean inOptimize_table() {
      return !inOptimize_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRepair_table = new java.util.Stack<>();

	@Override
	public void enterRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		final Node node = model.newNode(Label.label("Repair_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRepair_table.push(true);
	}

	public void exitRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		onExit();
		this.inRepair_table.pop();
	}

	public boolean inRepair_table() {
      return !inRepair_table.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCheck_table_option = new java.util.Stack<>();

	@Override
	public void enterCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		final Node node = model.newNode(Label.label("Check_table_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCheck_table_option.push(true);
	}

	public void exitCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		onExit();
		this.inCheck_table_option.pop();
	}

	public boolean inCheck_table_option() {
      return !inCheck_table_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_udfunction = new java.util.Stack<>();

	@Override
	public void enterCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		final Node node = model.newNode(Label.label("Create_udfunction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_udfunction.push(true);
	}

	public void exitCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		onExit();
		this.inCreate_udfunction.pop();
	}

	public boolean inCreate_udfunction() {
      return !inCreate_udfunction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInstall_plugin = new java.util.Stack<>();

	@Override
	public void enterInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		final Node node = model.newNode(Label.label("Install_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInstall_plugin.push(true);
	}

	public void exitInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		onExit();
		this.inInstall_plugin.pop();
	}

	public boolean inInstall_plugin() {
      return !inInstall_plugin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUninstall_plugin = new java.util.Stack<>();

	@Override
	public void enterUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		final Node node = model.newNode(Label.label("Uninstall_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUninstall_plugin.push(true);
	}

	public void exitUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		onExit();
		this.inUninstall_plugin.pop();
	}

	public boolean inUninstall_plugin() {
      return !inUninstall_plugin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetVariableAssignment = new java.util.Stack<>();

	@Override
	public void enterSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		final Node node = model.newNode(Label.label("SetVariableAssignment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSetVariableAssignment.push(true);
	}

	public void exitSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		onExit();
		this.inSetVariableAssignment.pop();
	}

	public boolean inSetVariableAssignment() {
      return !inSetVariableAssignment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetCharset = new java.util.Stack<>();

	@Override
	public void enterSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		final Node node = model.newNode(Label.label("SetCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSetCharset.push(true);
	}

	public void exitSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		onExit();
		this.inSetCharset.pop();
	}

	public boolean inSetCharset() {
      return !inSetCharset.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetNames = new java.util.Stack<>();

	@Override
	public void enterSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		final Node node = model.newNode(Label.label("SetNames"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSetNames.push(true);
	}

	public void exitSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		onExit();
		this.inSetNames.pop();
	}

	public boolean inSetNames() {
      return !inSetNames.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetPasswordStatement = new java.util.Stack<>();

	@Override
	public void enterSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		final Node node = model.newNode(Label.label("SetPasswordStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSetPasswordStatement.push(true);
	}

	public void exitSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		onExit();
		this.inSetPasswordStatement.pop();
	}

	public boolean inSetPasswordStatement() {
      return !inSetPasswordStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetTransaction = new java.util.Stack<>();

	@Override
	public void enterSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		final Node node = model.newNode(Label.label("SetTransaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSetTransaction.push(true);
	}

	public void exitSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		onExit();
		this.inSetTransaction.pop();
	}

	public boolean inSetTransaction() {
      return !inSetTransaction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetAutocommit = new java.util.Stack<>();

	@Override
	public void enterSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		final Node node = model.newNode(Label.label("SetAutocommit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSetAutocommit.push(true);
	}

	public void exitSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		onExit();
		this.inSetAutocommit.pop();
	}

	public boolean inSetAutocommit() {
      return !inSetAutocommit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowMasterlogs = new java.util.Stack<>();

	@Override
	public void enterShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		final Node node = model.newNode(Label.label("ShowMasterlogs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowMasterlogs.push(true);
	}

	public void exitShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		onExit();
		this.inShowMasterlogs.pop();
	}

	public boolean inShowMasterlogs() {
      return !inShowMasterlogs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowLogevents = new java.util.Stack<>();

	@Override
	public void enterShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		final Node node = model.newNode(Label.label("ShowLogevents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowLogevents.push(true);
	}

	public void exitShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		onExit();
		this.inShowLogevents.pop();
	}

	public boolean inShowLogevents() {
      return !inShowLogevents.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowObjWithFilter = new java.util.Stack<>();

	@Override
	public void enterShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		final Node node = model.newNode(Label.label("ShowObjWithFilter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowObjWithFilter.push(true);
	}

	public void exitShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		onExit();
		this.inShowObjWithFilter.pop();
	}

	public boolean inShowObjWithFilter() {
      return !inShowObjWithFilter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowColumns = new java.util.Stack<>();

	@Override
	public void enterShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		final Node node = model.newNode(Label.label("ShowColumns"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowColumns.push(true);
	}

	public void exitShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		onExit();
		this.inShowColumns.pop();
	}

	public boolean inShowColumns() {
      return !inShowColumns.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowCreateDb = new java.util.Stack<>();

	@Override
	public void enterShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		final Node node = model.newNode(Label.label("ShowCreateDb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowCreateDb.push(true);
	}

	public void exitShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		onExit();
		this.inShowCreateDb.pop();
	}

	public boolean inShowCreateDb() {
      return !inShowCreateDb.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowCreateFullidobj = new java.util.Stack<>();

	@Override
	public void enterShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		final Node node = model.newNode(Label.label("ShowCreateFullidobj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowCreateFullidobj.push(true);
	}

	public void exitShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		onExit();
		this.inShowCreateFullidobj.pop();
	}

	public boolean inShowCreateFullidobj() {
      return !inShowCreateFullidobj.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowCreateUser = new java.util.Stack<>();

	@Override
	public void enterShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		final Node node = model.newNode(Label.label("ShowCreateUser"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowCreateUser.push(true);
	}

	public void exitShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		onExit();
		this.inShowCreateUser.pop();
	}

	public boolean inShowCreateUser() {
      return !inShowCreateUser.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowEngine = new java.util.Stack<>();

	@Override
	public void enterShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		final Node node = model.newNode(Label.label("ShowEngine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowEngine.push(true);
	}

	public void exitShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		onExit();
		this.inShowEngine.pop();
	}

	public boolean inShowEngine() {
      return !inShowEngine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowGlobalinfo = new java.util.Stack<>();

	@Override
	public void enterShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		final Node node = model.newNode(Label.label("ShowGlobalinfo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowGlobalinfo.push(true);
	}

	public void exitShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		onExit();
		this.inShowGlobalinfo.pop();
	}

	public boolean inShowGlobalinfo() {
      return !inShowGlobalinfo.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowErrWarn = new java.util.Stack<>();

	@Override
	public void enterShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		final Node node = model.newNode(Label.label("ShowErrWarn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowErrWarn.push(true);
	}

	public void exitShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		onExit();
		this.inShowErrWarn.pop();
	}

	public boolean inShowErrWarn() {
      return !inShowErrWarn.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowCountErrWarn = new java.util.Stack<>();

	@Override
	public void enterShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		final Node node = model.newNode(Label.label("ShowCountErrWarn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowCountErrWarn.push(true);
	}

	public void exitShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		onExit();
		this.inShowCountErrWarn.pop();
	}

	public boolean inShowCountErrWarn() {
      return !inShowCountErrWarn.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowFromschemaFilter = new java.util.Stack<>();

	@Override
	public void enterShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		final Node node = model.newNode(Label.label("ShowFromschemaFilter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowFromschemaFilter.push(true);
	}

	public void exitShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		onExit();
		this.inShowFromschemaFilter.pop();
	}

	public boolean inShowFromschemaFilter() {
      return !inShowFromschemaFilter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowRoutinecode = new java.util.Stack<>();

	@Override
	public void enterShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		final Node node = model.newNode(Label.label("ShowRoutinecode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowRoutinecode.push(true);
	}

	public void exitShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		onExit();
		this.inShowRoutinecode.pop();
	}

	public boolean inShowRoutinecode() {
      return !inShowRoutinecode.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowGrants = new java.util.Stack<>();

	@Override
	public void enterShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		final Node node = model.newNode(Label.label("ShowGrants"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowGrants.push(true);
	}

	public void exitShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		onExit();
		this.inShowGrants.pop();
	}

	public boolean inShowGrants() {
      return !inShowGrants.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowIndexes = new java.util.Stack<>();

	@Override
	public void enterShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		final Node node = model.newNode(Label.label("ShowIndexes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowIndexes.push(true);
	}

	public void exitShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		onExit();
		this.inShowIndexes.pop();
	}

	public boolean inShowIndexes() {
      return !inShowIndexes.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowOpentables = new java.util.Stack<>();

	@Override
	public void enterShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		final Node node = model.newNode(Label.label("ShowOpentables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowOpentables.push(true);
	}

	public void exitShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		onExit();
		this.inShowOpentables.pop();
	}

	public boolean inShowOpentables() {
      return !inShowOpentables.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowProfile = new java.util.Stack<>();

	@Override
	public void enterShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		final Node node = model.newNode(Label.label("ShowProfile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowProfile.push(true);
	}

	public void exitShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		onExit();
		this.inShowProfile.pop();
	}

	public boolean inShowProfile() {
      return !inShowProfile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShowSlavestatus = new java.util.Stack<>();

	@Override
	public void enterShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		final Node node = model.newNode(Label.label("ShowSlavestatus"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShowSlavestatus.push(true);
	}

	public void exitShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		onExit();
		this.inShowSlavestatus.pop();
	}

	public boolean inShowSlavestatus() {
      return !inShowSlavestatus.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariable_clause = new java.util.Stack<>();

	@Override
	public void enterVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		final Node node = model.newNode(Label.label("Variable_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariable_clause.push(true);
	}

	public void exitVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		onExit();
		this.inVariable_clause.pop();
	}

	public boolean inVariable_clause() {
      return !inVariable_clause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShow_filter = new java.util.Stack<>();

	@Override
	public void enterShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		final Node node = model.newNode(Label.label("Show_filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShow_filter.push(true);
	}

	public void exitShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		onExit();
		this.inShow_filter.pop();
	}

	public boolean inShow_filter() {
      return !inShow_filter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShow_profile_type = new java.util.Stack<>();

	@Override
	public void enterShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		final Node node = model.newNode(Label.label("Show_profile_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShow_profile_type.push(true);
	}

	public void exitShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		onExit();
		this.inShow_profile_type.pop();
	}

	public boolean inShow_profile_type() {
      return !inShow_profile_type.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBinlog_statement = new java.util.Stack<>();

	@Override
	public void enterBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		final Node node = model.newNode(Label.label("Binlog_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBinlog_statement.push(true);
	}

	public void exitBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		onExit();
		this.inBinlog_statement.pop();
	}

	public boolean inBinlog_statement() {
      return !inBinlog_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCache_index_statement = new java.util.Stack<>();

	@Override
	public void enterCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		final Node node = model.newNode(Label.label("Cache_index_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCache_index_statement.push(true);
	}

	public void exitCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		onExit();
		this.inCache_index_statement.pop();
	}

	public boolean inCache_index_statement() {
      return !inCache_index_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFlush_statement = new java.util.Stack<>();

	@Override
	public void enterFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		final Node node = model.newNode(Label.label("Flush_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFlush_statement.push(true);
	}

	public void exitFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		onExit();
		this.inFlush_statement.pop();
	}

	public boolean inFlush_statement() {
      return !inFlush_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKill_statement = new java.util.Stack<>();

	@Override
	public void enterKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		final Node node = model.newNode(Label.label("Kill_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inKill_statement.push(true);
	}

	public void exitKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		onExit();
		this.inKill_statement.pop();
	}

	public boolean inKill_statement() {
      return !inKill_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLoad_index_into_cache = new java.util.Stack<>();

	@Override
	public void enterLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		final Node node = model.newNode(Label.label("Load_index_into_cache"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLoad_index_into_cache.push(true);
	}

	public void exitLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		onExit();
		this.inLoad_index_into_cache.pop();
	}

	public boolean inLoad_index_into_cache() {
      return !inLoad_index_into_cache.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReset_statement = new java.util.Stack<>();

	@Override
	public void enterReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		final Node node = model.newNode(Label.label("Reset_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReset_statement.push(true);
	}

	public void exitReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		onExit();
		this.inReset_statement.pop();
	}

	public boolean inReset_statement() {
      return !inReset_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShutdown_statement = new java.util.Stack<>();

	@Override
	public void enterShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		final Node node = model.newNode(Label.label("Shutdown_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShutdown_statement.push(true);
	}

	public void exitShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		onExit();
		this.inShutdown_statement.pop();
	}

	public boolean inShutdown_statement() {
      return !inShutdown_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTbl_index_list = new java.util.Stack<>();

	@Override
	public void enterTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		final Node node = model.newNode(Label.label("Tbl_index_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTbl_index_list.push(true);
	}

	public void exitTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		onExit();
		this.inTbl_index_list.pop();
	}

	public boolean inTbl_index_list() {
      return !inTbl_index_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFlush_option = new java.util.Stack<>();

	@Override
	public void enterFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		final Node node = model.newNode(Label.label("Flush_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFlush_option.push(true);
	}

	public void exitFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		onExit();
		this.inFlush_option.pop();
	}

	public boolean inFlush_option() {
      return !inFlush_option.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLoad_tbl_index_list = new java.util.Stack<>();

	@Override
	public void enterLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		final Node node = model.newNode(Label.label("Load_tbl_index_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLoad_tbl_index_list.push(true);
	}

	public void exitLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		onExit();
		this.inLoad_tbl_index_list.pop();
	}

	public boolean inLoad_tbl_index_list() {
      return !inLoad_tbl_index_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimple_describe_statement = new java.util.Stack<>();

	@Override
	public void enterSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		final Node node = model.newNode(Label.label("Simple_describe_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimple_describe_statement.push(true);
	}

	public void exitSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		onExit();
		this.inSimple_describe_statement.pop();
	}

	public boolean inSimple_describe_statement() {
      return !inSimple_describe_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFull_describe_statement = new java.util.Stack<>();

	@Override
	public void enterFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		final Node node = model.newNode(Label.label("Full_describe_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFull_describe_statement.push(true);
	}

	public void exitFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		onExit();
		this.inFull_describe_statement.pop();
	}

	public boolean inFull_describe_statement() {
      return !inFull_describe_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHelp_statement = new java.util.Stack<>();

	@Override
	public void enterHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		final Node node = model.newNode(Label.label("Help_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHelp_statement.push(true);
	}

	public void exitHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		onExit();
		this.inHelp_statement.pop();
	}

	public boolean inHelp_statement() {
      return !inHelp_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUse_statement = new java.util.Stack<>();

	@Override
	public void enterUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		final Node node = model.newNode(Label.label("Use_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUse_statement.push(true);
	}

	public void exitUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		onExit();
		this.inUse_statement.pop();
	}

	public boolean inUse_statement() {
      return !inUse_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDescstmtDescObj = new java.util.Stack<>();

	@Override
	public void enterDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		final Node node = model.newNode(Label.label("DescstmtDescObj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDescstmtDescObj.push(true);
	}

	public void exitDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		onExit();
		this.inDescstmtDescObj.pop();
	}

	public boolean inDescstmtDescObj() {
      return !inDescstmtDescObj.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConnectionDescObj = new java.util.Stack<>();

	@Override
	public void enterConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		final Node node = model.newNode(Label.label("ConnectionDescObj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConnectionDescObj.push(true);
	}

	public void exitConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		onExit();
		this.inConnectionDescObj.pop();
	}

	public boolean inConnectionDescObj() {
      return !inConnectionDescObj.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTable_name = new java.util.Stack<>();

	@Override
	public void enterTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		final Node node = model.newNode(Label.label("Table_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTable_name.push(true);
	}

	public void exitTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		onExit();
		this.inTable_name.pop();
	}

	public boolean inTable_name() {
      return !inTable_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFull_id = new java.util.Stack<>();

	@Override
	public void enterFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		final Node node = model.newNode(Label.label("Full_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFull_id.push(true);
	}

	public void exitFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		onExit();
		this.inFull_id.pop();
	}

	public boolean inFull_id() {
      return !inFull_id.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFull_column_name = new java.util.Stack<>();

	@Override
	public void enterFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		final Node node = model.newNode(Label.label("Full_column_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFull_column_name.push(true);
	}

	public void exitFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		onExit();
		this.inFull_column_name.pop();
	}

	public boolean inFull_column_name() {
      return !inFull_column_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndex_col_name = new java.util.Stack<>();

	@Override
	public void enterIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		final Node node = model.newNode(Label.label("Index_col_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIndex_col_name.push(true);
	}

	public void exitIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		onExit();
		this.inIndex_col_name.pop();
	}

	public boolean inIndex_col_name() {
      return !inIndex_col_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUser_name = new java.util.Stack<>();

	@Override
	public void enterUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		final Node node = model.newNode(Label.label("User_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUser_name.push(true);
	}

	public void exitUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		onExit();
		this.inUser_name.pop();
	}

	public boolean inUser_name() {
      return !inUser_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMysql_variable = new java.util.Stack<>();

	@Override
	public void enterMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		final Node node = model.newNode(Label.label("Mysql_variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMysql_variable.push(true);
	}

	public void exitMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		onExit();
		this.inMysql_variable.pop();
	}

	public boolean inMysql_variable() {
      return !inMysql_variable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCharset_name = new java.util.Stack<>();

	@Override
	public void enterCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		final Node node = model.newNode(Label.label("Charset_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCharset_name.push(true);
	}

	public void exitCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		onExit();
		this.inCharset_name.pop();
	}

	public boolean inCharset_name() {
      return !inCharset_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCollation_name = new java.util.Stack<>();

	@Override
	public void enterCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		final Node node = model.newNode(Label.label("Collation_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCollation_name.push(true);
	}

	public void exitCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		onExit();
		this.inCollation_name.pop();
	}

	public boolean inCollation_name() {
      return !inCollation_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEngine_name = new java.util.Stack<>();

	@Override
	public void enterEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		final Node node = model.newNode(Label.label("Engine_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEngine_name.push(true);
	}

	public void exitEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		onExit();
		this.inEngine_name.pop();
	}

	public boolean inEngine_name() {
      return !inEngine_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUuid_set = new java.util.Stack<>();

	@Override
	public void enterUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		final Node node = model.newNode(Label.label("Uuid_set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUuid_set.push(true);
	}

	public void exitUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		onExit();
		this.inUuid_set.pop();
	}

	public boolean inUuid_set() {
      return !inUuid_set.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXid = new java.util.Stack<>();

	@Override
	public void enterXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		final Node node = model.newNode(Label.label("Xid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXid.push(true);
	}

	public void exitXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		onExit();
		this.inXid.pop();
	}

	public boolean inXid() {
      return !inXid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXid_string_id = new java.util.Stack<>();

	@Override
	public void enterXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		final Node node = model.newNode(Label.label("Xid_string_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXid_string_id.push(true);
	}

	public void exitXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		onExit();
		this.inXid_string_id.pop();
	}

	public boolean inXid_string_id() {
      return !inXid_string_id.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAuth_plugin = new java.util.Stack<>();

	@Override
	public void enterAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		final Node node = model.newNode(Label.label("Auth_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAuth_plugin.push(true);
	}

	public void exitAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		onExit();
		this.inAuth_plugin.pop();
	}

	public boolean inAuth_plugin() {
      return !inAuth_plugin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inId_ = new java.util.Stack<>();

	@Override
	public void enterId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		final Node node = model.newNode(Label.label("Id_"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inId_.push(true);
	}

	public void exitId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		onExit();
		this.inId_.pop();
	}

	public boolean inId_() {
      return !inId_.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimple_id = new java.util.Stack<>();

	@Override
	public void enterSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		final Node node = model.newNode(Label.label("Simple_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimple_id.push(true);
	}

	public void exitSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		onExit();
		this.inSimple_id.pop();
	}

	public boolean inSimple_id() {
      return !inSimple_id.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDot_ext_id = new java.util.Stack<>();

	@Override
	public void enterDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		final Node node = model.newNode(Label.label("Dot_ext_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDot_ext_id.push(true);
	}

	public void exitDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		onExit();
		this.inDot_ext_id.pop();
	}

	public boolean inDot_ext_id() {
      return !inDot_ext_id.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDecimal_literal = new java.util.Stack<>();

	@Override
	public void enterDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		final Node node = model.newNode(Label.label("Decimal_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDecimal_literal.push(true);
	}

	public void exitDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		onExit();
		this.inDecimal_literal.pop();
	}

	public boolean inDecimal_literal() {
      return !inDecimal_literal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFilesize_literal = new java.util.Stack<>();

	@Override
	public void enterFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		final Node node = model.newNode(Label.label("Filesize_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFilesize_literal.push(true);
	}

	public void exitFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		onExit();
		this.inFilesize_literal.pop();
	}

	public boolean inFilesize_literal() {
      return !inFilesize_literal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inString_literal = new java.util.Stack<>();

	@Override
	public void enterString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		final Node node = model.newNode(Label.label("String_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inString_literal.push(true);
	}

	public void exitString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		onExit();
		this.inString_literal.pop();
	}

	public boolean inString_literal() {
      return !inString_literal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBoolean_literal = new java.util.Stack<>();

	@Override
	public void enterBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		final Node node = model.newNode(Label.label("Boolean_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBoolean_literal.push(true);
	}

	public void exitBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		onExit();
		this.inBoolean_literal.pop();
	}

	public boolean inBoolean_literal() {
      return !inBoolean_literal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHexadecimal_literal = new java.util.Stack<>();

	@Override
	public void enterHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		final Node node = model.newNode(Label.label("Hexadecimal_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHexadecimal_literal.push(true);
	}

	public void exitHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		onExit();
		this.inHexadecimal_literal.pop();
	}

	public boolean inHexadecimal_literal() {
      return !inHexadecimal_literal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNull_notnull = new java.util.Stack<>();

	@Override
	public void enterNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		final Node node = model.newNode(Label.label("Null_notnull"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNull_notnull.push(true);
	}

	public void exitNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		onExit();
		this.inNull_notnull.pop();
	}

	public boolean inNull_notnull() {
      return !inNull_notnull.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstant = new java.util.Stack<>();

	@Override
	public void enterConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		final Node node = model.newNode(Label.label("Constant"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstant.push(true);
	}

	public void exitConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		onExit();
		this.inConstant.pop();
	}

	public boolean inConstant() {
      return !inConstant.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCharDatatype = new java.util.Stack<>();

	@Override
	public void enterCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		final Node node = model.newNode(Label.label("CharDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCharDatatype.push(true);
	}

	public void exitCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		onExit();
		this.inCharDatatype.pop();
	}

	public boolean inCharDatatype() {
      return !inCharDatatype.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDimensionDatatype = new java.util.Stack<>();

	@Override
	public void enterDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		final Node node = model.newNode(Label.label("DimensionDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDimensionDatatype.push(true);
	}

	public void exitDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		onExit();
		this.inDimensionDatatype.pop();
	}

	public boolean inDimensionDatatype() {
      return !inDimensionDatatype.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleDatatype = new java.util.Stack<>();

	@Override
	public void enterSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		final Node node = model.newNode(Label.label("SimpleDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleDatatype.push(true);
	}

	public void exitSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		onExit();
		this.inSimpleDatatype.pop();
	}

	public boolean inSimpleDatatype() {
      return !inSimpleDatatype.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCollectCharDatatype = new java.util.Stack<>();

	@Override
	public void enterCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		final Node node = model.newNode(Label.label("CollectCharDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCollectCharDatatype.push(true);
	}

	public void exitCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		onExit();
		this.inCollectCharDatatype.pop();
	}

	public boolean inCollectCharDatatype() {
      return !inCollectCharDatatype.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSpatialDatatype = new java.util.Stack<>();

	@Override
	public void enterSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		final Node node = model.newNode(Label.label("SpatialDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSpatialDatatype.push(true);
	}

	public void exitSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		onExit();
		this.inSpatialDatatype.pop();
	}

	public boolean inSpatialDatatype() {
      return !inSpatialDatatype.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inData_type_to_convert = new java.util.Stack<>();

	@Override
	public void enterData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		final Node node = model.newNode(Label.label("Data_type_to_convert"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inData_type_to_convert.push(true);
	}

	public void exitData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		onExit();
		this.inData_type_to_convert.pop();
	}

	public boolean inData_type_to_convert() {
      return !inData_type_to_convert.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSpatial_data_type = new java.util.Stack<>();

	@Override
	public void enterSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		final Node node = model.newNode(Label.label("Spatial_data_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSpatial_data_type.push(true);
	}

	public void exitSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		onExit();
		this.inSpatial_data_type.pop();
	}

	public boolean inSpatial_data_type() {
      return !inSpatial_data_type.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLength_one_dimension = new java.util.Stack<>();

	@Override
	public void enterLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		final Node node = model.newNode(Label.label("Length_one_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLength_one_dimension.push(true);
	}

	public void exitLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		onExit();
		this.inLength_one_dimension.pop();
	}

	public boolean inLength_one_dimension() {
      return !inLength_one_dimension.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLength_two_dimension = new java.util.Stack<>();

	@Override
	public void enterLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		final Node node = model.newNode(Label.label("Length_two_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLength_two_dimension.push(true);
	}

	public void exitLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		onExit();
		this.inLength_two_dimension.pop();
	}

	public boolean inLength_two_dimension() {
      return !inLength_two_dimension.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLength_two_optional_dimension = new java.util.Stack<>();

	@Override
	public void enterLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		final Node node = model.newNode(Label.label("Length_two_optional_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLength_two_optional_dimension.push(true);
	}

	public void exitLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		onExit();
		this.inLength_two_optional_dimension.pop();
	}

	public boolean inLength_two_optional_dimension() {
      return !inLength_two_optional_dimension.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inId_list = new java.util.Stack<>();

	@Override
	public void enterId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		final Node node = model.newNode(Label.label("Id_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inId_list.push(true);
	}

	public void exitId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		onExit();
		this.inId_list.pop();
	}

	public boolean inId_list() {
      return !inId_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTable_list = new java.util.Stack<>();

	@Override
	public void enterTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		final Node node = model.newNode(Label.label("Table_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTable_list.push(true);
	}

	public void exitTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		onExit();
		this.inTable_list.pop();
	}

	public boolean inTable_list() {
      return !inTable_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTable_pair_list = new java.util.Stack<>();

	@Override
	public void enterTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		final Node node = model.newNode(Label.label("Table_pair_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTable_pair_list.push(true);
	}

	public void exitTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		onExit();
		this.inTable_pair_list.pop();
	}

	public boolean inTable_pair_list() {
      return !inTable_pair_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndex_colname_list = new java.util.Stack<>();

	@Override
	public void enterIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		final Node node = model.newNode(Label.label("Index_colname_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIndex_colname_list.push(true);
	}

	public void exitIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		onExit();
		this.inIndex_colname_list.pop();
	}

	public boolean inIndex_colname_list() {
      return !inIndex_colname_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression_list = new java.util.Stack<>();

	@Override
	public void enterExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		final Node node = model.newNode(Label.label("Expression_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpression_list.push(true);
	}

	public void exitExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		onExit();
		this.inExpression_list.pop();
	}

	public boolean inExpression_list() {
      return !inExpression_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstant_list = new java.util.Stack<>();

	@Override
	public void enterConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		final Node node = model.newNode(Label.label("Constant_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstant_list.push(true);
	}

	public void exitConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		onExit();
		this.inConstant_list.pop();
	}

	public boolean inConstant_list() {
      return !inConstant_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimple_string_list = new java.util.Stack<>();

	@Override
	public void enterSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		final Node node = model.newNode(Label.label("Simple_string_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimple_string_list.push(true);
	}

	public void exitSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		onExit();
		this.inSimple_string_list.pop();
	}

	public boolean inSimple_string_list() {
      return !inSimple_string_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUser_var_list = new java.util.Stack<>();

	@Override
	public void enterUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		final Node node = model.newNode(Label.label("User_var_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUser_var_list.push(true);
	}

	public void exitUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		onExit();
		this.inUser_var_list.pop();
	}

	public boolean inUser_var_list() {
      return !inUser_var_list.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefault_value = new java.util.Stack<>();

	@Override
	public void enterDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		final Node node = model.newNode(Label.label("Default_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDefault_value.push(true);
	}

	public void exitDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		onExit();
		this.inDefault_value.pop();
	}

	public boolean inDefault_value() {
      return !inDefault_value.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIf_exists = new java.util.Stack<>();

	@Override
	public void enterIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		final Node node = model.newNode(Label.label("If_exists"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIf_exists.push(true);
	}

	public void exitIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		onExit();
		this.inIf_exists.pop();
	}

	public boolean inIf_exists() {
      return !inIf_exists.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIf_not_exists = new java.util.Stack<>();

	@Override
	public void enterIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		final Node node = model.newNode(Label.label("If_not_exists"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIf_not_exists.push(true);
	}

	public void exitIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		onExit();
		this.inIf_not_exists.pop();
	}

	public boolean inIf_not_exists() {
      return !inIf_not_exists.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSpecificFunctionCall = new java.util.Stack<>();

	@Override
	public void enterSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		final Node node = model.newNode(Label.label("SpecificFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSpecificFunctionCall.push(true);
	}

	public void exitSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		onExit();
		this.inSpecificFunctionCall.pop();
	}

	public boolean inSpecificFunctionCall() {
      return !inSpecificFunctionCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAggregateFunctionCall = new java.util.Stack<>();

	@Override
	public void enterAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		final Node node = model.newNode(Label.label("AggregateFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAggregateFunctionCall.push(true);
	}

	public void exitAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		onExit();
		this.inAggregateFunctionCall.pop();
	}

	public boolean inAggregateFunctionCall() {
      return !inAggregateFunctionCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inScalarFunctionCall = new java.util.Stack<>();

	@Override
	public void enterScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		final Node node = model.newNode(Label.label("ScalarFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inScalarFunctionCall.push(true);
	}

	public void exitScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		onExit();
		this.inScalarFunctionCall.pop();
	}

	public boolean inScalarFunctionCall() {
      return !inScalarFunctionCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUdfFunctionCall = new java.util.Stack<>();

	@Override
	public void enterUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		final Node node = model.newNode(Label.label("UdfFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUdfFunctionCall.push(true);
	}

	public void exitUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		onExit();
		this.inUdfFunctionCall.pop();
	}

	public boolean inUdfFunctionCall() {
      return !inUdfFunctionCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleSpecificFCall = new java.util.Stack<>();

	@Override
	public void enterSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		final Node node = model.newNode(Label.label("SimpleSpecificFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleSpecificFCall.push(true);
	}

	public void exitSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		onExit();
		this.inSimpleSpecificFCall.pop();
	}

	public boolean inSimpleSpecificFCall() {
      return !inSimpleSpecificFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConvertDataTypeFCall = new java.util.Stack<>();

	@Override
	public void enterConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		final Node node = model.newNode(Label.label("ConvertDataTypeFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConvertDataTypeFCall.push(true);
	}

	public void exitConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		onExit();
		this.inConvertDataTypeFCall.pop();
	}

	public boolean inConvertDataTypeFCall() {
      return !inConvertDataTypeFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inValuesFCall = new java.util.Stack<>();

	@Override
	public void enterValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		final Node node = model.newNode(Label.label("ValuesFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inValuesFCall.push(true);
	}

	public void exitValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		onExit();
		this.inValuesFCall.pop();
	}

	public boolean inValuesFCall() {
      return !inValuesFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseFCall = new java.util.Stack<>();

	@Override
	public void enterCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		final Node node = model.newNode(Label.label("CaseFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCaseFCall.push(true);
	}

	public void exitCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		onExit();
		this.inCaseFCall.pop();
	}

	public boolean inCaseFCall() {
      return !inCaseFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCharFCall = new java.util.Stack<>();

	@Override
	public void enterCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		final Node node = model.newNode(Label.label("CharFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCharFCall.push(true);
	}

	public void exitCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		onExit();
		this.inCharFCall.pop();
	}

	public boolean inCharFCall() {
      return !inCharFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPositionFCall = new java.util.Stack<>();

	@Override
	public void enterPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		final Node node = model.newNode(Label.label("PositionFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPositionFCall.push(true);
	}

	public void exitPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		onExit();
		this.inPositionFCall.pop();
	}

	public boolean inPositionFCall() {
      return !inPositionFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubstrFCall = new java.util.Stack<>();

	@Override
	public void enterSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		final Node node = model.newNode(Label.label("SubstrFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubstrFCall.push(true);
	}

	public void exitSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		onExit();
		this.inSubstrFCall.pop();
	}

	public boolean inSubstrFCall() {
      return !inSubstrFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTrimFCall = new java.util.Stack<>();

	@Override
	public void enterTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		final Node node = model.newNode(Label.label("TrimFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTrimFCall.push(true);
	}

	public void exitTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		onExit();
		this.inTrimFCall.pop();
	}

	public boolean inTrimFCall() {
      return !inTrimFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWeightFCall = new java.util.Stack<>();

	@Override
	public void enterWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		final Node node = model.newNode(Label.label("WeightFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inWeightFCall.push(true);
	}

	public void exitWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		onExit();
		this.inWeightFCall.pop();
	}

	public boolean inWeightFCall() {
      return !inWeightFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExtractFCall = new java.util.Stack<>();

	@Override
	public void enterExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		final Node node = model.newNode(Label.label("ExtractFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExtractFCall.push(true);
	}

	public void exitExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		onExit();
		this.inExtractFCall.pop();
	}

	public boolean inExtractFCall() {
      return !inExtractFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGetFormatFCall = new java.util.Stack<>();

	@Override
	public void enterGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		final Node node = model.newNode(Label.label("GetFormatFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGetFormatFCall.push(true);
	}

	public void exitGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		onExit();
		this.inGetFormatFCall.pop();
	}

	public boolean inGetFormatFCall() {
      return !inGetFormatFCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLevelWeightFList = new java.util.Stack<>();

	@Override
	public void enterLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		final Node node = model.newNode(Label.label("LevelWeightFList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLevelWeightFList.push(true);
	}

	public void exitLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		onExit();
		this.inLevelWeightFList.pop();
	}

	public boolean inLevelWeightFList() {
      return !inLevelWeightFList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLevelWeightFRange = new java.util.Stack<>();

	@Override
	public void enterLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		final Node node = model.newNode(Label.label("LevelWeightFRange"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLevelWeightFRange.push(true);
	}

	public void exitLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		onExit();
		this.inLevelWeightFRange.pop();
	}

	public boolean inLevelWeightFRange() {
      return !inLevelWeightFRange.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAggregate_windowed_function = new java.util.Stack<>();

	@Override
	public void enterAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		final Node node = model.newNode(Label.label("Aggregate_windowed_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAggregate_windowed_function.push(true);
	}

	public void exitAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		onExit();
		this.inAggregate_windowed_function.pop();
	}

	public boolean inAggregate_windowed_function() {
      return !inAggregate_windowed_function.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inScalar_function_name = new java.util.Stack<>();

	@Override
	public void enterScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		final Node node = model.newNode(Label.label("Scalar_function_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inScalar_function_name.push(true);
	}

	public void exitScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		onExit();
		this.inScalar_function_name.pop();
	}

	public boolean inScalar_function_name() {
      return !inScalar_function_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunction_args = new java.util.Stack<>();

	@Override
	public void enterFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		final Node node = model.newNode(Label.label("Function_args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunction_args.push(true);
	}

	public void exitFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		onExit();
		this.inFunction_args.pop();
	}

	public boolean inFunction_args() {
      return !inFunction_args.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunction_arg = new java.util.Stack<>();

	@Override
	public void enterFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		final Node node = model.newNode(Label.label("Function_arg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunction_arg.push(true);
	}

	public void exitFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		onExit();
		this.inFunction_arg.pop();
	}

	public boolean inFunction_arg() {
      return !inFunction_arg.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIsExpression = new java.util.Stack<>();

	@Override
	public void enterIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		final Node node = model.newNode(Label.label("IsExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIsExpression.push(true);
	}

	public void exitIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		onExit();
		this.inIsExpression.pop();
	}

	public boolean inIsExpression() {
      return !inIsExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLogicalExpression = new java.util.Stack<>();

	@Override
	public void enterLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		final Node node = model.newNode(Label.label("LogicalExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLogicalExpression.push(true);
	}

	public void exitLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		onExit();
		this.inLogicalExpression.pop();
	}

	public boolean inLogicalExpression() {
      return !inLogicalExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPredicateExpression = new java.util.Stack<>();

	@Override
	public void enterPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		final Node node = model.newNode(Label.label("PredicateExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPredicateExpression.push(true);
	}

	public void exitPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		onExit();
		this.inPredicateExpression.pop();
	}

	public boolean inPredicateExpression() {
      return !inPredicateExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSoundsLikePredicate = new java.util.Stack<>();

	@Override
	public void enterSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		final Node node = model.newNode(Label.label("SoundsLikePredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSoundsLikePredicate.push(true);
	}

	public void exitSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		onExit();
		this.inSoundsLikePredicate.pop();
	}

	public boolean inSoundsLikePredicate() {
      return !inSoundsLikePredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionAtomPredicate = new java.util.Stack<>();

	@Override
	public void enterExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		final Node node = model.newNode(Label.label("ExpressionAtomPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpressionAtomPredicate.push(true);
	}

	public void exitExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		onExit();
		this.inExpressionAtomPredicate.pop();
	}

	public boolean inExpressionAtomPredicate() {
      return !inExpressionAtomPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInPredicate = new java.util.Stack<>();

	@Override
	public void enterInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		final Node node = model.newNode(Label.label("InPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInPredicate.push(true);
	}

	public void exitInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		onExit();
		this.inInPredicate.pop();
	}

	public boolean inInPredicate() {
      return !inInPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubqueryComparasionPredicate = new java.util.Stack<>();

	@Override
	public void enterSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		final Node node = model.newNode(Label.label("SubqueryComparasionPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubqueryComparasionPredicate.push(true);
	}

	public void exitSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		onExit();
		this.inSubqueryComparasionPredicate.pop();
	}

	public boolean inSubqueryComparasionPredicate() {
      return !inSubqueryComparasionPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBetweenPredicate = new java.util.Stack<>();

	@Override
	public void enterBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		final Node node = model.newNode(Label.label("BetweenPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBetweenPredicate.push(true);
	}

	public void exitBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		onExit();
		this.inBetweenPredicate.pop();
	}

	public boolean inBetweenPredicate() {
      return !inBetweenPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBinaryComparasionPredicate = new java.util.Stack<>();

	@Override
	public void enterBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		final Node node = model.newNode(Label.label("BinaryComparasionPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBinaryComparasionPredicate.push(true);
	}

	public void exitBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		onExit();
		this.inBinaryComparasionPredicate.pop();
	}

	public boolean inBinaryComparasionPredicate() {
      return !inBinaryComparasionPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIsNullPredicate = new java.util.Stack<>();

	@Override
	public void enterIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		final Node node = model.newNode(Label.label("IsNullPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIsNullPredicate.push(true);
	}

	public void exitIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		onExit();
		this.inIsNullPredicate.pop();
	}

	public boolean inIsNullPredicate() {
      return !inIsNullPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLikePredicate = new java.util.Stack<>();

	@Override
	public void enterLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		final Node node = model.newNode(Label.label("LikePredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLikePredicate.push(true);
	}

	public void exitLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		onExit();
		this.inLikePredicate.pop();
	}

	public boolean inLikePredicate() {
      return !inLikePredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRegexpPredicate = new java.util.Stack<>();

	@Override
	public void enterRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		final Node node = model.newNode(Label.label("RegexpPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRegexpPredicate.push(true);
	}

	public void exitRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		onExit();
		this.inRegexpPredicate.pop();
	}

	public boolean inRegexpPredicate() {
      return !inRegexpPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("UnaryExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnaryExpressionAtom.push(true);
	}

	public void exitUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		onExit();
		this.inUnaryExpressionAtom.pop();
	}

	public boolean inUnaryExpressionAtom() {
      return !inUnaryExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExistsExpessionAtom = new java.util.Stack<>();

	@Override
	public void enterExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		final Node node = model.newNode(Label.label("ExistsExpessionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExistsExpessionAtom.push(true);
	}

	public void exitExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		onExit();
		this.inExistsExpessionAtom.pop();
	}

	public boolean inExistsExpessionAtom() {
      return !inExistsExpessionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstantExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("ConstantExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstantExpressionAtom.push(true);
	}

	public void exitConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		onExit();
		this.inConstantExpressionAtom.pop();
	}

	public boolean inConstantExpressionAtom() {
      return !inConstantExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionCallExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("FunctionCallExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunctionCallExpressionAtom.push(true);
	}

	public void exitFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		onExit();
		this.inFunctionCallExpressionAtom.pop();
	}

	public boolean inFunctionCallExpressionAtom() {
      return !inFunctionCallExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMysqlVariableExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("MysqlVariableExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMysqlVariableExpressionAtom.push(true);
	}

	public void exitMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		onExit();
		this.inMysqlVariableExpressionAtom.pop();
	}

	public boolean inMysqlVariableExpressionAtom() {
      return !inMysqlVariableExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBinaryExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("BinaryExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBinaryExpressionAtom.push(true);
	}

	public void exitBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		onExit();
		this.inBinaryExpressionAtom.pop();
	}

	public boolean inBinaryExpressionAtom() {
      return !inBinaryExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFullColumnNameExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("FullColumnNameExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFullColumnNameExpressionAtom.push(true);
	}

	public void exitFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		onExit();
		this.inFullColumnNameExpressionAtom.pop();
	}

	public boolean inFullColumnNameExpressionAtom() {
      return !inFullColumnNameExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("DefaultExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDefaultExpressionAtom.push(true);
	}

	public void exitDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		onExit();
		this.inDefaultExpressionAtom.pop();
	}

	public boolean inDefaultExpressionAtom() {
      return !inDefaultExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBitExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("BitExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBitExpressionAtom.push(true);
	}

	public void exitBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		onExit();
		this.inBitExpressionAtom.pop();
	}

	public boolean inBitExpressionAtom() {
      return !inBitExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNestedExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("NestedExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNestedExpressionAtom.push(true);
	}

	public void exitNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		onExit();
		this.inNestedExpressionAtom.pop();
	}

	public boolean inNestedExpressionAtom() {
      return !inNestedExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMathExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("MathExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMathExpressionAtom.push(true);
	}

	public void exitMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		onExit();
		this.inMathExpressionAtom.pop();
	}

	public boolean inMathExpressionAtom() {
      return !inMathExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIntervalExpressionAtom = new java.util.Stack<>();

	@Override
	public void enterIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		final Node node = model.newNode(Label.label("IntervalExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIntervalExpressionAtom.push(true);
	}

	public void exitIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		onExit();
		this.inIntervalExpressionAtom.pop();
	}

	public boolean inIntervalExpressionAtom() {
      return !inIntervalExpressionAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnary_operator = new java.util.Stack<>();

	@Override
	public void enterUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		final Node node = model.newNode(Label.label("Unary_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnary_operator.push(true);
	}

	public void exitUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		onExit();
		this.inUnary_operator.pop();
	}

	public boolean inUnary_operator() {
      return !inUnary_operator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComparison_operator = new java.util.Stack<>();

	@Override
	public void enterComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		final Node node = model.newNode(Label.label("Comparison_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inComparison_operator.push(true);
	}

	public void exitComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		onExit();
		this.inComparison_operator.pop();
	}

	public boolean inComparison_operator() {
      return !inComparison_operator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLogical_operator = new java.util.Stack<>();

	@Override
	public void enterLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		final Node node = model.newNode(Label.label("Logical_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLogical_operator.push(true);
	}

	public void exitLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		onExit();
		this.inLogical_operator.pop();
	}

	public boolean inLogical_operator() {
      return !inLogical_operator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBit_operator = new java.util.Stack<>();

	@Override
	public void enterBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		final Node node = model.newNode(Label.label("Bit_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBit_operator.push(true);
	}

	public void exitBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		onExit();
		this.inBit_operator.pop();
	}

	public boolean inBit_operator() {
      return !inBit_operator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMath_operator = new java.util.Stack<>();

	@Override
	public void enterMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		final Node node = model.newNode(Label.label("Math_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMath_operator.push(true);
	}

	public void exitMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		onExit();
		this.inMath_operator.pop();
	}

	public boolean inMath_operator() {
      return !inMath_operator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCharset_name_base = new java.util.Stack<>();

	@Override
	public void enterCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		final Node node = model.newNode(Label.label("Charset_name_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCharset_name_base.push(true);
	}

	public void exitCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		onExit();
		this.inCharset_name_base.pop();
	}

	public boolean inCharset_name_base() {
      return !inCharset_name_base.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTransaction_level_base = new java.util.Stack<>();

	@Override
	public void enterTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		final Node node = model.newNode(Label.label("Transaction_level_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTransaction_level_base.push(true);
	}

	public void exitTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		onExit();
		this.inTransaction_level_base.pop();
	}

	public boolean inTransaction_level_base() {
      return !inTransaction_level_base.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrivileges_base = new java.util.Stack<>();

	@Override
	public void enterPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		final Node node = model.newNode(Label.label("Privileges_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrivileges_base.push(true);
	}

	public void exitPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		onExit();
		this.inPrivileges_base.pop();
	}

	public boolean inPrivileges_base() {
      return !inPrivileges_base.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterval_type_base = new java.util.Stack<>();

	@Override
	public void enterInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		final Node node = model.newNode(Label.label("Interval_type_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterval_type_base.push(true);
	}

	public void exitInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		onExit();
		this.inInterval_type_base.pop();
	}

	public boolean inInterval_type_base() {
      return !inInterval_type_base.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inData_type_base = new java.util.Stack<>();

	@Override
	public void enterData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		final Node node = model.newNode(Label.label("Data_type_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inData_type_base.push(true);
	}

	public void exitData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		onExit();
		this.inData_type_base.pop();
	}

	public boolean inData_type_base() {
      return !inData_type_base.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeywords_can_be_id = new java.util.Stack<>();

	@Override
	public void enterKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		final Node node = model.newNode(Label.label("Keywords_can_be_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inKeywords_can_be_id.push(true);
	}

	public void exitKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		onExit();
		this.inKeywords_can_be_id.pop();
	}

	public boolean inKeywords_can_be_id() {
      return !inKeywords_can_be_id.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunction_name_base = new java.util.Stack<>();

	@Override
	public void enterFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		final Node node = model.newNode(Label.label("Function_name_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunction_name_base.push(true);
	}

	public void exitFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		onExit();
		this.inFunction_name_base.pop();
	}

	public boolean inFunction_name_base() {
      return !inFunction_name_base.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNotExpression = new java.util.Stack<>();

	@Override
	public void enterNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		final Node node = model.newNode(Label.label("NotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNotExpression.push(true);
	}

	public void exitNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		onExit();
		this.inNotExpression.pop();
	}

	public boolean inNotExpression() {
      return !inNotExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRoot = new java.util.Stack<>();

	@Override
	public void enterRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		final Node node = model.newNode(Label.label("Root"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRoot.push(true);
	}

	public void exitRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		onExit();
		this.inRoot.pop();
	}

	public boolean inRoot() {
      return !inRoot.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSql_statements = new java.util.Stack<>();

	@Override
	public void enterSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		final Node node = model.newNode(Label.label("Sql_statements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSql_statements.push(true);
	}

	public void exitSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		onExit();
		this.inSql_statements.pop();
	}

	public boolean inSql_statements() {
      return !inSql_statements.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSql_statement = new java.util.Stack<>();

	@Override
	public void enterSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		final Node node = model.newNode(Label.label("Sql_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSql_statement.push(true);
	}

	public void exitSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		onExit();
		this.inSql_statement.pop();
	}

	public boolean inSql_statement() {
      return !inSql_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEmpty_statement = new java.util.Stack<>();

	@Override
	public void enterEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		final Node node = model.newNode(Label.label("Empty_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEmpty_statement.push(true);
	}

	public void exitEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		onExit();
		this.inEmpty_statement.pop();
	}

	public boolean inEmpty_statement() {
      return !inEmpty_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDdl_statement = new java.util.Stack<>();

	@Override
	public void enterDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		final Node node = model.newNode(Label.label("Ddl_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDdl_statement.push(true);
	}

	public void exitDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		onExit();
		this.inDdl_statement.pop();
	}

	public boolean inDdl_statement() {
      return !inDdl_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDml_statement = new java.util.Stack<>();

	@Override
	public void enterDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		final Node node = model.newNode(Label.label("Dml_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDml_statement.push(true);
	}

	public void exitDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		onExit();
		this.inDml_statement.pop();
	}

	public boolean inDml_statement() {
      return !inDml_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTransaction_statement = new java.util.Stack<>();

	@Override
	public void enterTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		final Node node = model.newNode(Label.label("Transaction_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTransaction_statement.push(true);
	}

	public void exitTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		onExit();
		this.inTransaction_statement.pop();
	}

	public boolean inTransaction_statement() {
      return !inTransaction_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReplication_statement = new java.util.Stack<>();

	@Override
	public void enterReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		final Node node = model.newNode(Label.label("Replication_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReplication_statement.push(true);
	}

	public void exitReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		onExit();
		this.inReplication_statement.pop();
	}

	public boolean inReplication_statement() {
      return !inReplication_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrepared_statement = new java.util.Stack<>();

	@Override
	public void enterPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		final Node node = model.newNode(Label.label("Prepared_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrepared_statement.push(true);
	}

	public void exitPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		onExit();
		this.inPrepared_statement.pop();
	}

	public boolean inPrepared_statement() {
      return !inPrepared_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompound_statement = new java.util.Stack<>();

	@Override
	public void enterCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		final Node node = model.newNode(Label.label("Compound_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCompound_statement.push(true);
	}

	public void exitCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		onExit();
		this.inCompound_statement.pop();
	}

	public boolean inCompound_statement() {
      return !inCompound_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAdministration_statement = new java.util.Stack<>();

	@Override
	public void enterAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		final Node node = model.newNode(Label.label("Administration_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAdministration_statement.push(true);
	}

	public void exitAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		onExit();
		this.inAdministration_statement.pop();
	}

	public boolean inAdministration_statement() {
      return !inAdministration_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUtility_statement = new java.util.Stack<>();

	@Override
	public void enterUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		final Node node = model.newNode(Label.label("Utility_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUtility_statement.push(true);
	}

	public void exitUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		onExit();
		this.inUtility_statement.pop();
	}

	public boolean inUtility_statement() {
      return !inUtility_statement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_database = new java.util.Stack<>();

	@Override
	public void enterCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		final Node node = model.newNode(Label.label("Create_database"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_database.push(true);
	}

	public void exitCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		onExit();
		this.inCreate_database.pop();
	}

	public boolean inCreate_database() {
      return !inCreate_database.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate_event = new java.util.Stack<>();

	@Override
	public void enterCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		final Node node = model.newNode(Label.label("Create_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreate_event.push(true);
	}

	public void exitCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		onExit();
		this.inCreate_event.pop();
	}

	public boolean inCreate_event() {
      return !inCreate_event.isEmpty(); 
   }

}