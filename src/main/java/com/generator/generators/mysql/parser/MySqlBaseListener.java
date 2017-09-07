package com.generator.generators.mysql.parser;

public class MySqlBaseListener extends MySqlParserBaseListener {

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

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		 //System.out.println("Dml_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Dml_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		 //System.out.println("Transaction_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Transaction_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		 //System.out.println("Create_view");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_view", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		 onExit();
	}

	@Override
	public void enterDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		 //System.out.println("Ddl_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Ddl_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		 //System.out.println("ConstraintDefinition");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ConstraintDefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		 //System.out.println("IndexDefinition");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IndexDefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		 //System.out.println("Column_definition");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Column_definition", arg.getText(), arg.getStart().getText()));
	}

	public void exitColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		 //System.out.println("ColConstrNull");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrNull", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		 //System.out.println("ColConstrDflt");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrDflt", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		 //System.out.println("ColConstrAuInc");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrAuInc", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		 //System.out.println("ColConstrUK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrUK", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		 //System.out.println("ColConstrComment");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrComment", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		 //System.out.println("ColConstrForm");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrForm", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		 //System.out.println("ColConstrStorage");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrStorage", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		 //System.out.println("ColConstrRefdef");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrRefdef", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		 onExit();
	}

	@Override
	public void enterTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		 //System.out.println("TblConstrPK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblConstrPK", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		 onExit();
	}

	@Override
	public void enterTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		 //System.out.println("TblConstrUK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblConstrUK", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		 onExit();
	}

	@Override
	public void enterTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		 //System.out.println("TblConstrFK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblConstrFK", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		 onExit();
	}

	@Override
	public void enterRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		 //System.out.println("Root");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Root", arg.getText(), arg.getStart().getText()));
	}

	public void exitRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		 onExit();
	}

	@Override
	public void enterEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		 //System.out.println("Empty_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Empty_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		 //System.out.println("Interval_type");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Interval_type", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		 onExit();
	}

	@Override
	public void enterIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		 //System.out.println("Index_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Index_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		 //System.out.println("Proc_param");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Proc_param", arg.getText(), arg.getStart().getText()));
	}

	public void exitProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		 onExit();
	}

	@Override
	public void enterFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		 //System.out.println("Func_param");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Func_param", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		 onExit();
	}

	@Override
	public void enterRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		 //System.out.println("RcComment");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RcComment", arg.getText(), arg.getStart().getText()));
	}

	public void exitRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		 onExit();
	}

	@Override
	public void enterRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		 //System.out.println("RcSqllang");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RcSqllang", arg.getText(), arg.getStart().getText()));
	}

	public void exitRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		 onExit();
	}

	@Override
	public void enterRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		 //System.out.println("RcDeterm");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RcDeterm", arg.getText(), arg.getStart().getText()));
	}

	public void exitRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		 onExit();
	}

	@Override
	public void enterRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		 //System.out.println("RcSqldata");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RcSqldata", arg.getText(), arg.getStart().getText()));
	}

	public void exitRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		 onExit();
	}

	@Override
	public void enterRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		 //System.out.println("RcSecurestmt");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RcSecurestmt", arg.getText(), arg.getStart().getText()));
	}

	public void exitRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		 onExit();
	}

	@Override
	public void enterServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		 //System.out.println("Server_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Server_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		 //System.out.println("Column_def_table_constraints");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Column_def_table_constraints", arg.getText(), arg.getStart().getText()));
	}

	public void exitColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		 onExit();
	}

	@Override
	public void enterColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		 //System.out.println("ColumnDefinition");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColumnDefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		 //System.out.println("ColConstrPK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColConstrPK", arg.getText(), arg.getStart().getText()));
	}

	public void exitColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		 onExit();
	}

	@Override
	public void enterColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		 //System.out.println("ColCreateTable");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ColCreateTable", arg.getText(), arg.getStart().getText()));
	}

	public void exitColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		 //System.out.println("Create_tablespace_innodb");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_tablespace_innodb", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		 //System.out.println("Create_tablespace_ndb");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_tablespace_ndb", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		 //System.out.println("Create_trigger");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_trigger", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		 //System.out.println("Create_database_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_database_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		 //System.out.println("Owner_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Owner_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		 //System.out.println("PreciseSchedule");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PreciseSchedule", arg.getText(), arg.getStart().getText()));
	}

	public void exitPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		 onExit();
	}

	@Override
	public void enterIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		 //System.out.println("IntervalSchedule");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IntervalSchedule", arg.getText(), arg.getStart().getText()));
	}

	public void exitIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		 onExit();
	}

	@Override
	public void enterTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		 //System.out.println("Timestamp_value");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Timestamp_value", arg.getText(), arg.getStart().getText()));
	}

	public void exitTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		 onExit();
	}

	@Override
	public void enterInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		 //System.out.println("Interval_expr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Interval_expr", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		 onExit();
	}

	@Override
	public void enterIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		 //System.out.println("Index_type");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Index_type", arg.getText(), arg.getStart().getText()));
	}

	public void exitIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		 onExit();
	}

	@Override
	public void enterStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		 //System.out.println("Start_slave_connection_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Start_slave_connection_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		 //System.out.println("Gtid_set");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Gtid_set", arg.getText(), arg.getStart().getText()));
	}

	public void exitGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		 onExit();
	}

	@Override
	public void enterXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		 //System.out.println("Xa_start_transaction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xa_start_transaction", arg.getText(), arg.getStart().getText()));
	}

	public void exitXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		 onExit();
	}

	@Override
	public void enterXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		 //System.out.println("Xa_end_transaction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xa_end_transaction", arg.getText(), arg.getStart().getText()));
	}

	public void exitXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		 onExit();
	}

	@Override
	public void enterXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		 //System.out.println("Xa_prepare");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xa_prepare", arg.getText(), arg.getStart().getText()));
	}

	public void exitXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		 onExit();
	}

	@Override
	public void enterXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		 //System.out.println("Xa_commit_work");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xa_commit_work", arg.getText(), arg.getStart().getText()));
	}

	public void exitXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		 onExit();
	}

	@Override
	public void enterXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		 //System.out.println("Xa_rollback_work");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xa_rollback_work", arg.getText(), arg.getStart().getText()));
	}

	public void exitXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		 onExit();
	}

	@Override
	public void enterXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		 //System.out.println("Xa_recover_work");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xa_recover_work", arg.getText(), arg.getStart().getText()));
	}

	public void exitXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		 onExit();
	}

	@Override
	public void enterPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		 //System.out.println("Prepare_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Prepare_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		 //System.out.println("Execute_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Execute_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		 //System.out.println("Deallocate_prepare");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Deallocate_prepare", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		 onExit();
	}

	@Override
	public void enterRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		 //System.out.println("Routine_body");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Routine_body", arg.getText(), arg.getStart().getText()));
	}

	public void exitRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		 onExit();
	}

	@Override
	public void enterBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		 //System.out.println("Block_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Block_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		 //System.out.println("Case_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Case_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		 //System.out.println("If_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("If_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		 //System.out.println("Iterate_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Iterate_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		 //System.out.println("Leave_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Leave_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		 //System.out.println("Loop_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Loop_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		 //System.out.println("Repeat_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Repeat_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		 //System.out.println("Return_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Return_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		 //System.out.println("While_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("While_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		 //System.out.println("Cursor_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Cursor_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		 //System.out.println("Declare_variable");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Declare_variable", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		 //System.out.println("Declare_condition");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Declare_condition", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		 //System.out.println("Declare_cursor");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Declare_cursor", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		 //System.out.println("Declare_handler");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Declare_handler", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		 onExit();
	}

	@Override
	public void enterHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		 //System.out.println("Handler_condition_value");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Handler_condition_value", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		 onExit();
	}

	@Override
	public void enterProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		 //System.out.println("Procedure_sql_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Procedure_sql_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		 //System.out.println("AlterUserMysql56");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AlterUserMysql56", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		 onExit();
	}

	@Override
	public void enterAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		 //System.out.println("AlterUserMysql57");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AlterUserMysql57", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		 onExit();
	}

	@Override
	public void enterCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		 //System.out.println("CreateUserMysql56");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CreateUserMysql56", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		 onExit();
	}

	@Override
	public void enterCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		 //System.out.println("CreateUserMysql57");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CreateUserMysql57", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		 onExit();
	}

	@Override
	public void enterDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		 //System.out.println("Drop_user");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_user", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		 onExit();
	}

	@Override
	public void enterGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		 //System.out.println("Grant_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Grant_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		 //System.out.println("Grant_proxy");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Grant_proxy", arg.getText(), arg.getStart().getText()));
	}

	public void exitGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		 onExit();
	}

	@Override
	public void enterRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		 //System.out.println("Rename_user");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Rename_user", arg.getText(), arg.getStart().getText()));
	}

	public void exitRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		 onExit();
	}

	@Override
	public void enterDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		 //System.out.println("DetailRevoke");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DetailRevoke", arg.getText(), arg.getStart().getText()));
	}

	public void exitDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		 onExit();
	}

	@Override
	public void enterShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		 //System.out.println("ShortRevoke");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShortRevoke", arg.getText(), arg.getStart().getText()));
	}

	public void exitShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		 onExit();
	}

	@Override
	public void enterRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		 //System.out.println("Revoke_proxy");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Revoke_proxy", arg.getText(), arg.getStart().getText()));
	}

	public void exitRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		 onExit();
	}

	@Override
	public void enterSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		 //System.out.println("Set_password_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Set_password_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		 //System.out.println("User_password_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("User_password_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		 //System.out.println("AuthByPassword");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AuthByPassword", arg.getText(), arg.getStart().getText()));
	}

	public void exitAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		 onExit();
	}

	@Override
	public void enterAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		 //System.out.println("AuthByString");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AuthByString", arg.getText(), arg.getStart().getText()));
	}

	public void exitAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		 onExit();
	}

	@Override
	public void enterAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		 //System.out.println("AuthByHash");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AuthByHash", arg.getText(), arg.getStart().getText()));
	}

	public void exitAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		 onExit();
	}

	@Override
	public void enterTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		 //System.out.println("Tls_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Tls_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		 //System.out.println("User_resource_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("User_resource_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		 //System.out.println("User_lock_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("User_lock_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		 //System.out.println("Privelege_clause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Privelege_clause", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		 onExit();
	}

	@Override
	public void enterPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		 //System.out.println("Privilege");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Privilege", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		 onExit();
	}

	@Override
	public void enterPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		 //System.out.println("Privilege_level");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Privilege_level", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		 onExit();
	}

	@Override
	public void enterSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		 //System.out.println("Set_password_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Set_password_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		 //System.out.println("Analyze_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Analyze_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		 //System.out.println("Check_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Check_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		 //System.out.println("Checksum_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Checksum_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		 //System.out.println("Optimize_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Optimize_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		 //System.out.println("Repair_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Repair_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		 //System.out.println("Check_table_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Check_table_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		 //System.out.println("Create_udfunction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_udfunction", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		 onExit();
	}

	@Override
	public void enterInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		 //System.out.println("Install_plugin");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Install_plugin", arg.getText(), arg.getStart().getText()));
	}

	public void exitInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		 onExit();
	}

	@Override
	public void enterUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		 //System.out.println("Uninstall_plugin");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Uninstall_plugin", arg.getText(), arg.getStart().getText()));
	}

	public void exitUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		 onExit();
	}

	@Override
	public void enterSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		 //System.out.println("SetVariableAssignment");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SetVariableAssignment", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		 onExit();
	}

	@Override
	public void enterSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		 //System.out.println("SetCharset");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SetCharset", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		 onExit();
	}

	@Override
	public void enterSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		 //System.out.println("SetNames");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SetNames", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		 onExit();
	}

	@Override
	public void enterSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		 //System.out.println("SetPasswordStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SetPasswordStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		 //System.out.println("SetTransaction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SetTransaction", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		 onExit();
	}

	@Override
	public void enterSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		 //System.out.println("SetAutocommit");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SetAutocommit", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		 onExit();
	}

	@Override
	public void enterShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		 //System.out.println("ShowMasterlogs");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowMasterlogs", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		 onExit();
	}

	@Override
	public void enterShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		 //System.out.println("ShowLogevents");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowLogevents", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		 onExit();
	}

	@Override
	public void enterShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		 //System.out.println("ShowObjWithFilter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowObjWithFilter", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		 onExit();
	}

	@Override
	public void enterShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		 //System.out.println("ShowColumns");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowColumns", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		 onExit();
	}

	@Override
	public void enterShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		 //System.out.println("ShowCreateDb");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowCreateDb", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		 onExit();
	}

	@Override
	public void enterShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		 //System.out.println("ShowCreateFullidobj");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowCreateFullidobj", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		 onExit();
	}

	@Override
	public void enterShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		 //System.out.println("ShowCreateUser");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowCreateUser", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		 onExit();
	}

	@Override
	public void enterShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		 //System.out.println("ShowEngine");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowEngine", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		 onExit();
	}

	@Override
	public void enterShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		 //System.out.println("ShowGlobalinfo");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowGlobalinfo", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		 onExit();
	}

	@Override
	public void enterShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		 //System.out.println("ShowErrWarn");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowErrWarn", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		 onExit();
	}

	@Override
	public void enterShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		 //System.out.println("ShowCountErrWarn");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowCountErrWarn", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		 onExit();
	}

	@Override
	public void enterShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		 //System.out.println("ShowFromschemaFilter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowFromschemaFilter", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		 onExit();
	}

	@Override
	public void enterShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		 //System.out.println("ShowRoutinecode");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowRoutinecode", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		 onExit();
	}

	@Override
	public void enterShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		 //System.out.println("ShowGrants");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowGrants", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		 onExit();
	}

	@Override
	public void enterShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		 //System.out.println("ShowIndexes");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowIndexes", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		 onExit();
	}

	@Override
	public void enterShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		 //System.out.println("ShowOpentables");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowOpentables", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		 onExit();
	}

	@Override
	public void enterShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		 //System.out.println("ShowProfile");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowProfile", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		 onExit();
	}

	@Override
	public void enterShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		 //System.out.println("ShowSlavestatus");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ShowSlavestatus", arg.getText(), arg.getStart().getText()));
	}

	public void exitShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		 onExit();
	}

	@Override
	public void enterVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		 //System.out.println("Variable_clause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Variable_clause", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		 onExit();
	}

	@Override
	public void enterShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		 //System.out.println("Show_filter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Show_filter", arg.getText(), arg.getStart().getText()));
	}

	public void exitShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		 onExit();
	}

	@Override
	public void enterShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		 //System.out.println("Show_profile_type");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Show_profile_type", arg.getText(), arg.getStart().getText()));
	}

	public void exitShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		 onExit();
	}

	@Override
	public void enterBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		 //System.out.println("Binlog_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Binlog_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		 //System.out.println("Cache_index_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Cache_index_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		 //System.out.println("Flush_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Flush_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		 //System.out.println("Kill_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Kill_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		 //System.out.println("Load_index_into_cache");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Load_index_into_cache", arg.getText(), arg.getStart().getText()));
	}

	public void exitLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		 onExit();
	}

	@Override
	public void enterReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		 //System.out.println("Reset_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Reset_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		 //System.out.println("Shutdown_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Shutdown_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		 //System.out.println("Tbl_index_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Tbl_index_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		 onExit();
	}

	@Override
	public void enterFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		 //System.out.println("Flush_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Flush_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		 //System.out.println("Load_tbl_index_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Load_tbl_index_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		 onExit();
	}

	@Override
	public void enterSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		 //System.out.println("Simple_describe_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Simple_describe_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		 //System.out.println("Full_describe_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Full_describe_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		 //System.out.println("Help_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Help_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		 //System.out.println("Use_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Use_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		 //System.out.println("DescstmtDescObj");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DescstmtDescObj", arg.getText(), arg.getStart().getText()));
	}

	public void exitDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		 onExit();
	}

	@Override
	public void enterConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		 //System.out.println("ConnectionDescObj");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ConnectionDescObj", arg.getText(), arg.getStart().getText()));
	}

	public void exitConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		 onExit();
	}

	@Override
	public void enterTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		 //System.out.println("Table_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Table_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		 //System.out.println("Full_id");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Full_id", arg.getText(), arg.getStart().getText()));
	}

	public void exitFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		 onExit();
	}

	@Override
	public void enterFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		 //System.out.println("Full_column_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Full_column_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		 //System.out.println("Index_col_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Index_col_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		 //System.out.println("User_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("User_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		 //System.out.println("Mysql_variable");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Mysql_variable", arg.getText(), arg.getStart().getText()));
	}

	public void exitMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		 onExit();
	}

	@Override
	public void enterCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		 //System.out.println("Charset_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Charset_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		 //System.out.println("Collation_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Collation_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		 //System.out.println("Engine_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Engine_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		 //System.out.println("Uuid_set");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Uuid_set", arg.getText(), arg.getStart().getText()));
	}

	public void exitUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		 onExit();
	}

	@Override
	public void enterXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		 //System.out.println("Xid");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xid", arg.getText(), arg.getStart().getText()));
	}

	public void exitXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		 onExit();
	}

	@Override
	public void enterXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		 //System.out.println("Xid_string_id");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xid_string_id", arg.getText(), arg.getStart().getText()));
	}

	public void exitXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		 onExit();
	}

	@Override
	public void enterAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		 //System.out.println("Auth_plugin");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Auth_plugin", arg.getText(), arg.getStart().getText()));
	}

	public void exitAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		 onExit();
	}

	@Override
	public void enterId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		 //System.out.println("Id_");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Id_", arg.getText(), arg.getStart().getText()));
	}

	public void exitId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		 onExit();
	}

	@Override
	public void enterSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		 //System.out.println("Simple_id");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Simple_id", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		 onExit();
	}

	@Override
	public void enterDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		 //System.out.println("Dot_ext_id");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Dot_ext_id", arg.getText(), arg.getStart().getText()));
	}

	public void exitDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		 onExit();
	}

	@Override
	public void enterDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		 //System.out.println("Decimal_literal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Decimal_literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		 onExit();
	}

	@Override
	public void enterFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		 //System.out.println("Filesize_literal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Filesize_literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		 onExit();
	}

	@Override
	public void enterString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		 //System.out.println("String_literal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("String_literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		 onExit();
	}

	@Override
	public void enterBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		 //System.out.println("Boolean_literal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Boolean_literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		 onExit();
	}

	@Override
	public void enterHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		 //System.out.println("Hexadecimal_literal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Hexadecimal_literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		 onExit();
	}

	@Override
	public void enterNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		 //System.out.println("Null_notnull");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Null_notnull", arg.getText(), arg.getStart().getText()));
	}

	public void exitNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		 onExit();
	}

	@Override
	public void enterConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		 //System.out.println("Constant");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Constant", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		 onExit();
	}

	@Override
	public void enterCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		 //System.out.println("CharDatatype");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CharDatatype", arg.getText(), arg.getStart().getText()));
	}

	public void exitCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		 onExit();
	}

	@Override
	public void enterDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		 //System.out.println("DimensionDatatype");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DimensionDatatype", arg.getText(), arg.getStart().getText()));
	}

	public void exitDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		 onExit();
	}

	@Override
	public void enterSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		 //System.out.println("SimpleDatatype");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SimpleDatatype", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		 onExit();
	}

	@Override
	public void enterCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		 //System.out.println("CollectCharDatatype");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CollectCharDatatype", arg.getText(), arg.getStart().getText()));
	}

	public void exitCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		 onExit();
	}

	@Override
	public void enterSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		 //System.out.println("SpatialDatatype");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SpatialDatatype", arg.getText(), arg.getStart().getText()));
	}

	public void exitSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		 onExit();
	}

	@Override
	public void enterData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		 //System.out.println("Data_type_to_convert");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Data_type_to_convert", arg.getText(), arg.getStart().getText()));
	}

	public void exitData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		 onExit();
	}

	@Override
	public void enterSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		 //System.out.println("Spatial_data_type");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Spatial_data_type", arg.getText(), arg.getStart().getText()));
	}

	public void exitSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		 onExit();
	}

	@Override
	public void enterLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		 //System.out.println("Length_one_dimension");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Length_one_dimension", arg.getText(), arg.getStart().getText()));
	}

	public void exitLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		 onExit();
	}

	@Override
	public void enterLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		 //System.out.println("Length_two_dimension");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Length_two_dimension", arg.getText(), arg.getStart().getText()));
	}

	public void exitLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		 onExit();
	}

	@Override
	public void enterLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		 //System.out.println("Length_two_optional_dimension");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Length_two_optional_dimension", arg.getText(), arg.getStart().getText()));
	}

	public void exitLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		 onExit();
	}

	@Override
	public void enterId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		 //System.out.println("Id_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Id_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		 onExit();
	}

	@Override
	public void enterTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		 //System.out.println("Table_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Table_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		 onExit();
	}

	@Override
	public void enterTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		 //System.out.println("Table_pair_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Table_pair_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		 onExit();
	}

	@Override
	public void enterIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		 //System.out.println("Index_colname_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Index_colname_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		 onExit();
	}

	@Override
	public void enterExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		 //System.out.println("Expression_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Expression_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		 onExit();
	}

	@Override
	public void enterConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		 //System.out.println("Constant_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Constant_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		 onExit();
	}

	@Override
	public void enterSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		 //System.out.println("Simple_string_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Simple_string_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		 onExit();
	}

	@Override
	public void enterUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		 //System.out.println("User_var_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("User_var_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		 onExit();
	}

	@Override
	public void enterDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		 //System.out.println("Default_value");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Default_value", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		 onExit();
	}

	@Override
	public void enterIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		 //System.out.println("If_exists");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("If_exists", arg.getText(), arg.getStart().getText()));
	}

	public void exitIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		 onExit();
	}

	@Override
	public void enterIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		 //System.out.println("If_not_exists");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("If_not_exists", arg.getText(), arg.getStart().getText()));
	}

	public void exitIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		 onExit();
	}

	@Override
	public void enterTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		 //System.out.println("TblConstCheck");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblConstCheck", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		 onExit();
	}

	@Override
	public void enterReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		 //System.out.println("Reference_definition");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Reference_definition", arg.getText(), arg.getStart().getText()));
	}

	public void exitReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		 onExit();
	}

	@Override
	public void enterOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		 //System.out.println("On_delete_action");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("On_delete_action", arg.getText(), arg.getStart().getText()));
	}

	public void exitOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		 onExit();
	}

	@Override
	public void enterOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		 //System.out.println("On_update_action");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("On_update_action", arg.getText(), arg.getStart().getText()));
	}

	public void exitOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		 onExit();
	}

	@Override
	public void enterReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		 //System.out.println("Reference_action_control_type");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Reference_action_control_type", arg.getText(), arg.getStart().getText()));
	}

	public void exitReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		 onExit();
	}

	@Override
	public void enterSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		 //System.out.println("SimpleIndex");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SimpleIndex", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		 onExit();
	}

	@Override
	public void enterSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		 //System.out.println("SpecIndex");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SpecIndex", arg.getText(), arg.getStart().getText()));
	}

	public void exitSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		 //System.out.println("TblOptEngine");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptEngine", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		 //System.out.println("TblOptAuInc");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptAuInc", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		 //System.out.println("TblOptAvgRLen");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptAvgRLen", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		 //System.out.println("TblOptDefCharSet");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptDefCharSet", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		 //System.out.println("TblOptChkSum");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptChkSum", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		 //System.out.println("TblOptDefCollate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptDefCollate", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		 //System.out.println("TblOptComment");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptComment", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		 //System.out.println("TblOptCompr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptCompr", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		 //System.out.println("TblOptConn");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptConn", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		 //System.out.println("TblOptDataDir");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptDataDir", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		 //System.out.println("TblOptDelKW");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptDelKW", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		 //System.out.println("TblOptEncr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptEncr", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		 //System.out.println("TblOptIndexDir");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptIndexDir", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		 //System.out.println("TblOptInsMeth");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptInsMeth", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		 //System.out.println("TblOptKeyBlockSz");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptKeyBlockSz", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		 //System.out.println("TblOptMaxRows");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptMaxRows", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		 //System.out.println("TblOptMinRows");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptMinRows", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		 //System.out.println("TblOptPackK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptPackK", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		 //System.out.println("TblOptPasswd");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptPasswd", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		 //System.out.println("TblOptRowFormat");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptRowFormat", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		 //System.out.println("TblOptStatAutoR");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptStatAutoR", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		 //System.out.println("TblOptStatPersist");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptStatPersist", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		 //System.out.println("TblOptStatSamplPg");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptStatSamplPg", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		 //System.out.println("TblOptTablespace");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptTablespace", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		 onExit();
	}

	@Override
	public void enterTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		 //System.out.println("TblOptUnion");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TblOptUnion", arg.getText(), arg.getStart().getText()));
	}

	public void exitTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		 onExit();
	}

	@Override
	public void enterPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		 //System.out.println("Partition_options");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Partition_options", arg.getText(), arg.getStart().getText()));
	}

	public void exitPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		 onExit();
	}

	@Override
	public void enterPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		 //System.out.println("Partition_function_definition");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Partition_function_definition", arg.getText(), arg.getStart().getText()));
	}

	public void exitPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		 onExit();
	}

	@Override
	public void enterLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		 //System.out.println("Linear_partition_func_def");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Linear_partition_func_def", arg.getText(), arg.getStart().getText()));
	}

	public void exitLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		 onExit();
	}

	@Override
	public void enterPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		 //System.out.println("Partition_def");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Partition_def", arg.getText(), arg.getStart().getText()));
	}

	public void exitPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		 onExit();
	}

	@Override
	public void enterSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		 //System.out.println("Subpartition_def");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Subpartition_def", arg.getText(), arg.getStart().getText()));
	}

	public void exitSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		 onExit();
	}

	@Override
	public void enterAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		 //System.out.println("AlterDb");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AlterDb", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		 onExit();
	}

	@Override
	public void enterAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		 //System.out.println("AlterDbUpgradeName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AlterDbUpgradeName", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		 //System.out.println("Alter_event");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_event", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		 //System.out.println("Alter_function");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_function", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		 //System.out.println("Alter_instance");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_instance", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		 //System.out.println("Alter_logfile_group");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_logfile_group", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		 //System.out.println("Alter_procedure");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_procedure", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		 //System.out.println("Alter_server");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_server", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		 //System.out.println("Alter_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		 //System.out.println("Alter_tablespace");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_tablespace", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		 onExit();
	}

	@Override
	public void enterAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		 //System.out.println("Alter_view");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alter_view", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		 //System.out.println("AltblTableOpt");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblTableOpt", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		 //System.out.println("AltblAddCol");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddCol", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		 //System.out.println("AltblAddCols");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddCols", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		 //System.out.println("AltblAddIndex");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddIndex", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		 //System.out.println("AltblAddPK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddPK", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		 //System.out.println("AltblAddUK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddUK", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		 onExit();
	}

	@Override
	public void enterSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		 //System.out.println("Sql_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Sql_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		 //System.out.println("AltblAddSpecIndex");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddSpecIndex", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		 //System.out.println("AltblAddFK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddFK", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		 //System.out.println("AltblAlg");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAlg", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		 //System.out.println("AltblColDef");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblColDef", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		 //System.out.println("AltblColChange");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblColChange", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		 //System.out.println("AltblLock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblLock", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		 //System.out.println("AltblColMod");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblColMod", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		 //System.out.println("AltblColDrop");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblColDrop", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		 //System.out.println("AltblDropPK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDropPK", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		 //System.out.println("AltblDropIndex");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDropIndex", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		 //System.out.println("AltblDropFK");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDropFK", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		 //System.out.println("AltblDisKey");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDisKey", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		 //System.out.println("AltblEnKey");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblEnKey", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		 //System.out.println("AltblRenameTbl");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblRenameTbl", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		 //System.out.println("AltblResort");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblResort", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		 //System.out.println("AltblConvert");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblConvert", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		 //System.out.println("AltblDefCharset");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDefCharset", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		 //System.out.println("AltblDisTblspace");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDisTblspace", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		 //System.out.println("AltblImpTblSpace");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblImpTblSpace", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		 //System.out.println("AltblForce");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblForce", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		 //System.out.println("AltblValid");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblValid", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		 //System.out.println("AltblAddPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAddPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		 //System.out.println("Create_event");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_event", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		 //System.out.println("Create_index");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_index", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		 //System.out.println("Create_logfile_group");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_logfile_group", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		 //System.out.println("Create_procedure");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_procedure", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		 //System.out.println("Create_function");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_function", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		 //System.out.println("Create_server");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_server", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		 onExit();
	}

	@Override
	public void enterCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		 //System.out.println("CopyCreateTable");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CopyCreateTable", arg.getText(), arg.getStart().getText()));
	}

	public void exitCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		 onExit();
	}

	@Override
	public void enterQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		 //System.out.println("QueryCreateTable");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("QueryCreateTable", arg.getText(), arg.getStart().getText()));
	}

	public void exitQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		 //System.out.println("AltblDropPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDropPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		 //System.out.println("AltblDiscartPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblDiscartPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		 //System.out.println("AltblImportPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblImportPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		 //System.out.println("AltblTruncPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblTruncPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		 //System.out.println("AltblCoalPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblCoalPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		 //System.out.println("AltblReorgPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblReorgPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		 //System.out.println("AltblExchPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblExchPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		 //System.out.println("AltblAnalPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblAnalPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		 //System.out.println("AltblCheckPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblCheckPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		 //System.out.println("AltblOptimPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblOptimPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		 //System.out.println("AltblRebuildPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblRebuildPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		 //System.out.println("AltblRepairPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblRepairPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		 //System.out.println("AltblRemovePart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblRemovePart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		 onExit();
	}

	@Override
	public void enterAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		 //System.out.println("AltblUpgrPart");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltblUpgrPart", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		 //System.out.println("Drop_database");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_database", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		 //System.out.println("Drop_event");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_event", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		 //System.out.println("Drop_index");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_index", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		 //System.out.println("Drop_logfile_group");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_logfile_group", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		 //System.out.println("Drop_procedure");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_procedure", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		 //System.out.println("Drop_function");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_function", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		 //System.out.println("Drop_server");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_server", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		 //System.out.println("Drop_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		 //System.out.println("Drop_tablespace");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_tablespace", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		 //System.out.println("Drop_trigger");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_trigger", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		 onExit();
	}

	@Override
	public void enterDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		 //System.out.println("Drop_view");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Drop_view", arg.getText(), arg.getStart().getText()));
	}

	public void exitDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		 onExit();
	}

	@Override
	public void enterRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		 //System.out.println("Rename_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Rename_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		 //System.out.println("Truncate_table");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Truncate_table", arg.getText(), arg.getStart().getText()));
	}

	public void exitTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		 onExit();
	}

	@Override
	public void enterCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		 //System.out.println("Call_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Call_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		 //System.out.println("Delete_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Delete_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		 //System.out.println("Do_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Do_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		 //System.out.println("Handler_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Handler_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		 //System.out.println("Insert_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Insert_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		 //System.out.println("Load_data_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Load_data_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		 //System.out.println("Load_xml_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Load_xml_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		 //System.out.println("Replace_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Replace_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		 //System.out.println("SimpleSelect");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SimpleSelect", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		 onExit();
	}

	@Override
	public void enterParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		 //System.out.println("ParenSelect");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ParenSelect", arg.getText(), arg.getStart().getText()));
	}

	public void exitParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		 onExit();
	}

	@Override
	public void enterUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		 //System.out.println("UnionSelect");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UnionSelect", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		 onExit();
	}

	@Override
	public void enterUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		 //System.out.println("UnionParenSelect");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UnionParenSelect", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		 onExit();
	}

	@Override
	public void enterUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		 //System.out.println("Update_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Update_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		 //System.out.println("Insert_statement_value");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Insert_statement_value", arg.getText(), arg.getStart().getText()));
	}

	public void exitInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		 onExit();
	}

	@Override
	public void enterUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		 //System.out.println("Update_elem");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Update_elem", arg.getText(), arg.getStart().getText()));
	}

	public void exitUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		 onExit();
	}

	@Override
	public void enterCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		 //System.out.println("Col_or_uservar");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Col_or_uservar", arg.getText(), arg.getStart().getText()));
	}

	public void exitCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		 onExit();
	}

	@Override
	public void enterSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		 //System.out.println("Single_delete_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Single_delete_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		 //System.out.println("Multiple_delete_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Multiple_delete_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		 //System.out.println("Handler_open_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Handler_open_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		 //System.out.println("Handler_read_index_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Handler_read_index_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		 //System.out.println("Handler_read_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Handler_read_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		 //System.out.println("Handler_close_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Handler_close_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		 //System.out.println("Single_update_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Single_update_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		 //System.out.println("Multiple_update_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Multiple_update_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		 //System.out.println("Order_by_clause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Order_by_clause", arg.getText(), arg.getStart().getText()));
	}

	public void exitOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		 onExit();
	}

	@Override
	public void enterOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		 //System.out.println("Order_by_expression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Order_by_expression", arg.getText(), arg.getStart().getText()));
	}

	public void exitOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		 onExit();
	}

	@Override
	public void enterTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		 //System.out.println("Table_sources");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Table_sources", arg.getText(), arg.getStart().getText()));
	}

	public void exitTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		 onExit();
	}

	@Override
	public void enterTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		 //System.out.println("Table_source");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Table_source", arg.getText(), arg.getStart().getText()));
	}

	public void exitTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		 onExit();
	}

	@Override
	public void enterAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		 //System.out.println("AtomTableItem");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AtomTableItem", arg.getText(), arg.getStart().getText()));
	}

	public void exitAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		 onExit();
	}

	@Override
	public void enterSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		 //System.out.println("SubqueryTableItem");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SubqueryTableItem", arg.getText(), arg.getStart().getText()));
	}

	public void exitSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		 onExit();
	}

	@Override
	public void enterTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		 //System.out.println("TableSourcesItem");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TableSourcesItem", arg.getText(), arg.getStart().getText()));
	}

	public void exitTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		 onExit();
	}

	@Override
	public void enterIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		 //System.out.println("Index_hint");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Index_hint", arg.getText(), arg.getStart().getText()));
	}

	public void exitIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		 onExit();
	}

	@Override
	public void enterInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		 //System.out.println("InnerJoin");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InnerJoin", arg.getText(), arg.getStart().getText()));
	}

	public void exitInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		 onExit();
	}

	@Override
	public void enterStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		 //System.out.println("StraightJoin");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("StraightJoin", arg.getText(), arg.getStart().getText()));
	}

	public void exitStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		 onExit();
	}

	@Override
	public void enterOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		 //System.out.println("OuterJoin");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("OuterJoin", arg.getText(), arg.getStart().getText()));
	}

	public void exitOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		 onExit();
	}

	@Override
	public void enterNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		 //System.out.println("NaturalJoin");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NaturalJoin", arg.getText(), arg.getStart().getText()));
	}

	public void exitNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		 onExit();
	}

	@Override
	public void enterSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		 //System.out.println("Subquery");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Subquery", arg.getText(), arg.getStart().getText()));
	}

	public void exitSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		 onExit();
	}

	@Override
	public void enterQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		 //System.out.println("Query_expression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Query_expression", arg.getText(), arg.getStart().getText()));
	}

	public void exitQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		 onExit();
	}

	@Override
	public void enterQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		 //System.out.println("Query_expression_nointo");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Query_expression_nointo", arg.getText(), arg.getStart().getText()));
	}

	public void exitQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		 onExit();
	}

	@Override
	public void enterQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		 //System.out.println("Query_specification");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Query_specification", arg.getText(), arg.getStart().getText()));
	}

	public void exitQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		 onExit();
	}

	@Override
	public void enterQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		 //System.out.println("Query_specification_nointo");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Query_specification_nointo", arg.getText(), arg.getStart().getText()));
	}

	public void exitQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		 onExit();
	}

	@Override
	public void enterUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		 //System.out.println("Union_parenth");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Union_parenth", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		 onExit();
	}

	@Override
	public void enterUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		 //System.out.println("Union_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Union_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		 //System.out.println("Select_spec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Select_spec", arg.getText(), arg.getStart().getText()));
	}

	public void exitSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		 onExit();
	}

	@Override
	public void enterSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		 //System.out.println("Select_list");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Select_list", arg.getText(), arg.getStart().getText()));
	}

	public void exitSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		 onExit();
	}

	@Override
	public void enterSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		 //System.out.println("SellistelAllCol");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SellistelAllCol", arg.getText(), arg.getStart().getText()));
	}

	public void exitSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		 onExit();
	}

	@Override
	public void enterSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		 //System.out.println("SellistelCol");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SellistelCol", arg.getText(), arg.getStart().getText()));
	}

	public void exitSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		 onExit();
	}

	@Override
	public void enterSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		 //System.out.println("SellistelFunc");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SellistelFunc", arg.getText(), arg.getStart().getText()));
	}

	public void exitSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		 onExit();
	}

	@Override
	public void enterSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		 //System.out.println("SellistelExpr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SellistelExpr", arg.getText(), arg.getStart().getText()));
	}

	public void exitSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		 onExit();
	}

	@Override
	public void enterSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		 //System.out.println("SelectIntoVars");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SelectIntoVars", arg.getText(), arg.getStart().getText()));
	}

	public void exitSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		 onExit();
	}

	@Override
	public void enterSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		 //System.out.println("SelectIntoDump");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SelectIntoDump", arg.getText(), arg.getStart().getText()));
	}

	public void exitSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		 onExit();
	}

	@Override
	public void enterSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		 //System.out.println("SelectIntoOutfile");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SelectIntoOutfile", arg.getText(), arg.getStart().getText()));
	}

	public void exitSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		 onExit();
	}

	@Override
	public void enterFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		 //System.out.println("From_clause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("From_clause", arg.getText(), arg.getStart().getText()));
	}

	public void exitFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		 onExit();
	}

	@Override
	public void enterGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		 //System.out.println("Group_by_item");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Group_by_item", arg.getText(), arg.getStart().getText()));
	}

	public void exitGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		 onExit();
	}

	@Override
	public void enterLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		 //System.out.println("Limit_clause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Limit_clause", arg.getText(), arg.getStart().getText()));
	}

	public void exitLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		 onExit();
	}

	@Override
	public void enterStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		 //System.out.println("Start_transaction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Start_transaction", arg.getText(), arg.getStart().getText()));
	}

	public void exitStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		 onExit();
	}

	@Override
	public void enterBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		 //System.out.println("Begin_work");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Begin_work", arg.getText(), arg.getStart().getText()));
	}

	public void exitBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		 onExit();
	}

	@Override
	public void enterCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		 //System.out.println("Commit_work");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Commit_work", arg.getText(), arg.getStart().getText()));
	}

	public void exitCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		 onExit();
	}

	@Override
	public void enterRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		 //System.out.println("Rollback_work");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Rollback_work", arg.getText(), arg.getStart().getText()));
	}

	public void exitRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		 onExit();
	}

	@Override
	public void enterSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		 //System.out.println("Savepoint_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Savepoint_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		 //System.out.println("Rollback_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Rollback_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		 //System.out.println("Release_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Release_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		 //System.out.println("Lock_tables");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Lock_tables", arg.getText(), arg.getStart().getText()));
	}

	public void exitLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		 onExit();
	}

	@Override
	public void enterUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		 //System.out.println("Unlock_tables");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Unlock_tables", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		 onExit();
	}

	@Override
	public void enterSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		 //System.out.println("Set_autocommit_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Set_autocommit_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		 //System.out.println("Set_transaction_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Set_transaction_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		 //System.out.println("Transact_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Transact_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		 //System.out.println("Lock_table_element");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Lock_table_element", arg.getText(), arg.getStart().getText()));
	}

	public void exitLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		 onExit();
	}

	@Override
	public void enterTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		 //System.out.println("Trans_characteristic");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Trans_characteristic", arg.getText(), arg.getStart().getText()));
	}

	public void exitTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		 onExit();
	}

	@Override
	public void enterTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		 //System.out.println("Transaction_level");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Transaction_level", arg.getText(), arg.getStart().getText()));
	}

	public void exitTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		 onExit();
	}

	@Override
	public void enterChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		 //System.out.println("Change_master");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Change_master", arg.getText(), arg.getStart().getText()));
	}

	public void exitChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		 onExit();
	}

	@Override
	public void enterChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		 //System.out.println("Change_repl_filter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Change_repl_filter", arg.getText(), arg.getStart().getText()));
	}

	public void exitChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		 onExit();
	}

	@Override
	public void enterPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		 //System.out.println("Purge_binary_logs");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Purge_binary_logs", arg.getText(), arg.getStart().getText()));
	}

	public void exitPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		 onExit();
	}

	@Override
	public void enterReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		 //System.out.println("Reset_master");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Reset_master", arg.getText(), arg.getStart().getText()));
	}

	public void exitReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		 onExit();
	}

	@Override
	public void enterReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		 //System.out.println("Reset_slave");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Reset_slave", arg.getText(), arg.getStart().getText()));
	}

	public void exitReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		 onExit();
	}

	@Override
	public void enterStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		 //System.out.println("Start_slave");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Start_slave", arg.getText(), arg.getStart().getText()));
	}

	public void exitStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		 onExit();
	}

	@Override
	public void enterStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		 //System.out.println("Stop_slave");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Stop_slave", arg.getText(), arg.getStart().getText()));
	}

	public void exitStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		 onExit();
	}

	@Override
	public void enterStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		 //System.out.println("Start_group_repl");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Start_group_repl", arg.getText(), arg.getStart().getText()));
	}

	public void exitStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		 onExit();
	}

	@Override
	public void enterStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		 //System.out.println("Stop_group_repl");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Stop_group_repl", arg.getText(), arg.getStart().getText()));
	}

	public void exitStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		 onExit();
	}

	@Override
	public void enterMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		 //System.out.println("MasterOptString");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MasterOptString", arg.getText(), arg.getStart().getText()));
	}

	public void exitMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		 onExit();
	}

	@Override
	public void enterMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		 //System.out.println("MasterOptDecimal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MasterOptDecimal", arg.getText(), arg.getStart().getText()));
	}

	public void exitMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		 onExit();
	}

	@Override
	public void enterMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		 //System.out.println("MasterOptBool");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MasterOptBool", arg.getText(), arg.getStart().getText()));
	}

	public void exitMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		 onExit();
	}

	@Override
	public void enterMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		 //System.out.println("MasterOptReal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MasterOptReal", arg.getText(), arg.getStart().getText()));
	}

	public void exitMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		 onExit();
	}

	@Override
	public void enterMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		 //System.out.println("MasterOptIdList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MasterOptIdList", arg.getText(), arg.getStart().getText()));
	}

	public void exitMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		 onExit();
	}

	@Override
	public void enterString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		 //System.out.println("String_master_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("String_master_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		 //System.out.println("Decimal_master_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Decimal_master_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		 //System.out.println("Bool_master_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Bool_master_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		 //System.out.println("Channel_option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Channel_option", arg.getText(), arg.getStart().getText()));
	}

	public void exitChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		 onExit();
	}

	@Override
	public void enterReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		 //System.out.println("ReplfilterDbList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ReplfilterDbList", arg.getText(), arg.getStart().getText()));
	}

	public void exitReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		 onExit();
	}

	@Override
	public void enterReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		 //System.out.println("ReplfilterTableList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ReplfilterTableList", arg.getText(), arg.getStart().getText()));
	}

	public void exitReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		 onExit();
	}

	@Override
	public void enterReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		 //System.out.println("ReplfilterStableList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ReplfilterStableList", arg.getText(), arg.getStart().getText()));
	}

	public void exitReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		 onExit();
	}

	@Override
	public void enterReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		 //System.out.println("ReplfilterTablepairList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ReplfilterTablepairList", arg.getText(), arg.getStart().getText()));
	}

	public void exitReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		 onExit();
	}

	@Override
	public void enterThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		 //System.out.println("Thread_type");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Thread_type", arg.getText(), arg.getStart().getText()));
	}

	public void exitThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		 onExit();
	}

	@Override
	public void enterUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		 //System.out.println("UntilGtidSset");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UntilGtidSset", arg.getText(), arg.getStart().getText()));
	}

	public void exitUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		 onExit();
	}

	@Override
	public void enterUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		 //System.out.println("UntilMasterLog");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UntilMasterLog", arg.getText(), arg.getStart().getText()));
	}

	public void exitUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		 onExit();
	}

	@Override
	public void enterUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		 //System.out.println("UntilRelayLog");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UntilRelayLog", arg.getText(), arg.getStart().getText()));
	}

	public void exitUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		 onExit();
	}

	@Override
	public void enterUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		 //System.out.println("UntilSqlGaps");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UntilSqlGaps", arg.getText(), arg.getStart().getText()));
	}

	public void exitUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		 onExit();
	}

	@Override
	public void enterReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		 //System.out.println("Replication_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Replication_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		 //System.out.println("Prepared_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Prepared_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		 //System.out.println("Compound_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Compound_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		 //System.out.println("Administration_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Administration_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		 //System.out.println("Utility_statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Utility_statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		 onExit();
	}

	@Override
	public void enterCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		 //System.out.println("Create_database");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Create_database", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		 onExit();
	}

	@Override
	public void enterSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		 //System.out.println("Sql_statements");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Sql_statements", arg.getText(), arg.getStart().getText()));
	}

	public void exitSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		 onExit();
	}

	@Override
	public void enterSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		 //System.out.println("SpecificFunctionCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SpecificFunctionCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		 onExit();
	}

	@Override
	public void enterAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		 //System.out.println("AggregateFunctionCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AggregateFunctionCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		 onExit();
	}

	@Override
	public void enterScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		 //System.out.println("ScalarFunctionCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ScalarFunctionCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		 onExit();
	}

	@Override
	public void enterUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		 //System.out.println("UdfFunctionCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UdfFunctionCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		 onExit();
	}

	@Override
	public void enterSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		 //System.out.println("SimpleSpecificFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SimpleSpecificFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		 //System.out.println("ConvertDataTypeFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ConvertDataTypeFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		 //System.out.println("ValuesFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ValuesFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		 //System.out.println("CaseFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CaseFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		 //System.out.println("CharFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CharFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		 //System.out.println("PositionFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PositionFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		 //System.out.println("SubstrFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SubstrFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		 //System.out.println("TrimFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TrimFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		 //System.out.println("WeightFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("WeightFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		 //System.out.println("ExtractFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExtractFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		 //System.out.println("GetFormatFCall");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("GetFormatFCall", arg.getText(), arg.getStart().getText()));
	}

	public void exitGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		 onExit();
	}

	@Override
	public void enterLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		 //System.out.println("LevelWeightFList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LevelWeightFList", arg.getText(), arg.getStart().getText()));
	}

	public void exitLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		 onExit();
	}

	@Override
	public void enterLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		 //System.out.println("LevelWeightFRange");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LevelWeightFRange", arg.getText(), arg.getStart().getText()));
	}

	public void exitLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		 onExit();
	}

	@Override
	public void enterAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		 //System.out.println("Aggregate_windowed_function");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Aggregate_windowed_function", arg.getText(), arg.getStart().getText()));
	}

	public void exitAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		 onExit();
	}

	@Override
	public void enterScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		 //System.out.println("Scalar_function_name");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Scalar_function_name", arg.getText(), arg.getStart().getText()));
	}

	public void exitScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		 onExit();
	}

	@Override
	public void enterFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		 //System.out.println("Function_args");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Function_args", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		 onExit();
	}

	@Override
	public void enterFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		 //System.out.println("Function_arg");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Function_arg", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		 onExit();
	}

	@Override
	public void enterIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		 //System.out.println("IsExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IsExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		 //System.out.println("NotExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NotExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		 //System.out.println("LogicalExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LogicalExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		 //System.out.println("PredicateExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PredicateExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		 //System.out.println("SoundsLikePredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SoundsLikePredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		 //System.out.println("ExpressionAtomPredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExpressionAtomPredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		 //System.out.println("InPredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InPredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		 //System.out.println("SubqueryComparasionPredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SubqueryComparasionPredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		 //System.out.println("BetweenPredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BetweenPredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		 //System.out.println("BinaryComparasionPredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BinaryComparasionPredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		 //System.out.println("IsNullPredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IsNullPredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		 //System.out.println("LikePredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LikePredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		 //System.out.println("RegexpPredicate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RegexpPredicate", arg.getText(), arg.getStart().getText()));
	}

	public void exitRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		 onExit();
	}

	@Override
	public void enterUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		 //System.out.println("UnaryExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UnaryExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		 //System.out.println("ExistsExpessionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExistsExpessionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		 //System.out.println("ConstantExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ConstantExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		 //System.out.println("FunctionCallExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FunctionCallExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		 //System.out.println("MysqlVariableExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MysqlVariableExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		 //System.out.println("BinaryExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BinaryExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		 //System.out.println("FullColumnNameExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FullColumnNameExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		 //System.out.println("DefaultExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DefaultExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		 //System.out.println("BitExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BitExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		 //System.out.println("NestedExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NestedExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		 //System.out.println("MathExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MathExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		 //System.out.println("IntervalExpressionAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IntervalExpressionAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		 //System.out.println("Unary_operator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Unary_operator", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		 onExit();
	}

	@Override
	public void enterComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		 //System.out.println("Comparison_operator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Comparison_operator", arg.getText(), arg.getStart().getText()));
	}

	public void exitComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		 onExit();
	}

	@Override
	public void enterLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		 //System.out.println("Logical_operator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Logical_operator", arg.getText(), arg.getStart().getText()));
	}

	public void exitLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		 onExit();
	}

	@Override
	public void enterBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		 //System.out.println("Bit_operator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Bit_operator", arg.getText(), arg.getStart().getText()));
	}

	public void exitBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		 onExit();
	}

	@Override
	public void enterMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		 //System.out.println("Math_operator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Math_operator", arg.getText(), arg.getStart().getText()));
	}

	public void exitMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		 onExit();
	}

	@Override
	public void enterCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		 //System.out.println("Charset_name_base");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Charset_name_base", arg.getText(), arg.getStart().getText()));
	}

	public void exitCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		 onExit();
	}

	@Override
	public void enterTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		 //System.out.println("Transaction_level_base");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Transaction_level_base", arg.getText(), arg.getStart().getText()));
	}

	public void exitTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		 onExit();
	}

	@Override
	public void enterPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		 //System.out.println("Privileges_base");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Privileges_base", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		 onExit();
	}

	@Override
	public void enterInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		 //System.out.println("Interval_type_base");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Interval_type_base", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		 onExit();
	}

	@Override
	public void enterData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		 //System.out.println("Data_type_base");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Data_type_base", arg.getText(), arg.getStart().getText()));
	}

	public void exitData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		 onExit();
	}

	@Override
	public void enterKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		 //System.out.println("Keywords_can_be_id");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Keywords_can_be_id", arg.getText(), arg.getStart().getText()));
	}

	public void exitKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		 onExit();
	}

	@Override
	public void enterFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		 //System.out.println("Function_name_base");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Function_name_base", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		 onExit();
	}

}