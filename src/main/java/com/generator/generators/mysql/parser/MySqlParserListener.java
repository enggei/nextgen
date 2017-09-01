// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/mysql/parser/MySqlParser.g4 by ANTLR 4.7
package com.generator.generators.mysql.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MySqlParser}.
 */
public interface MySqlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MySqlParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(MySqlParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(MySqlParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#sql_statements}.
	 * @param ctx the parse tree
	 */
	void enterSql_statements(MySqlParser.Sql_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#sql_statements}.
	 * @param ctx the parse tree
	 */
	void exitSql_statements(MySqlParser.Sql_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#sql_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_statement(MySqlParser.Sql_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#sql_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_statement(MySqlParser.Sql_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_statement(MySqlParser.Empty_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_statement(MySqlParser.Empty_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#ddl_statement}.
	 * @param ctx the parse tree
	 */
	void enterDdl_statement(MySqlParser.Ddl_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#ddl_statement}.
	 * @param ctx the parse tree
	 */
	void exitDdl_statement(MySqlParser.Ddl_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#dml_statement}.
	 * @param ctx the parse tree
	 */
	void enterDml_statement(MySqlParser.Dml_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#dml_statement}.
	 * @param ctx the parse tree
	 */
	void exitDml_statement(MySqlParser.Dml_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#transaction_statement}.
	 * @param ctx the parse tree
	 */
	void enterTransaction_statement(MySqlParser.Transaction_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#transaction_statement}.
	 * @param ctx the parse tree
	 */
	void exitTransaction_statement(MySqlParser.Transaction_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#replication_statement}.
	 * @param ctx the parse tree
	 */
	void enterReplication_statement(MySqlParser.Replication_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#replication_statement}.
	 * @param ctx the parse tree
	 */
	void exitReplication_statement(MySqlParser.Replication_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#prepared_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrepared_statement(MySqlParser.Prepared_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#prepared_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrepared_statement(MySqlParser.Prepared_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(MySqlParser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(MySqlParser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#administration_statement}.
	 * @param ctx the parse tree
	 */
	void enterAdministration_statement(MySqlParser.Administration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#administration_statement}.
	 * @param ctx the parse tree
	 */
	void exitAdministration_statement(MySqlParser.Administration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#utility_statement}.
	 * @param ctx the parse tree
	 */
	void enterUtility_statement(MySqlParser.Utility_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#utility_statement}.
	 * @param ctx the parse tree
	 */
	void exitUtility_statement(MySqlParser.Utility_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_database}.
	 * @param ctx the parse tree
	 */
	void enterCreate_database(MySqlParser.Create_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_database}.
	 * @param ctx the parse tree
	 */
	void exitCreate_database(MySqlParser.Create_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_event}.
	 * @param ctx the parse tree
	 */
	void enterCreate_event(MySqlParser.Create_eventContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_event}.
	 * @param ctx the parse tree
	 */
	void exitCreate_event(MySqlParser.Create_eventContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_index}.
	 * @param ctx the parse tree
	 */
	void enterCreate_index(MySqlParser.Create_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_index}.
	 * @param ctx the parse tree
	 */
	void exitCreate_index(MySqlParser.Create_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_logfile_group}.
	 * @param ctx the parse tree
	 */
	void enterCreate_logfile_group(MySqlParser.Create_logfile_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_logfile_group}.
	 * @param ctx the parse tree
	 */
	void exitCreate_logfile_group(MySqlParser.Create_logfile_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_procedure}.
	 * @param ctx the parse tree
	 */
	void enterCreate_procedure(MySqlParser.Create_procedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_procedure}.
	 * @param ctx the parse tree
	 */
	void exitCreate_procedure(MySqlParser.Create_procedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_function}.
	 * @param ctx the parse tree
	 */
	void enterCreate_function(MySqlParser.Create_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_function}.
	 * @param ctx the parse tree
	 */
	void exitCreate_function(MySqlParser.Create_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_server}.
	 * @param ctx the parse tree
	 */
	void enterCreate_server(MySqlParser.Create_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_server}.
	 * @param ctx the parse tree
	 */
	void exitCreate_server(MySqlParser.Create_serverContext ctx);
	/**
	 * Enter a parse tree produced by the {@code copyCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void enterCopyCreateTable(MySqlParser.CopyCreateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code copyCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void exitCopyCreateTable(MySqlParser.CopyCreateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void enterQueryCreateTable(MySqlParser.QueryCreateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void exitQueryCreateTable(MySqlParser.QueryCreateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void enterColCreateTable(MySqlParser.ColCreateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void exitColCreateTable(MySqlParser.ColCreateTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_tablespace_innodb}.
	 * @param ctx the parse tree
	 */
	void enterCreate_tablespace_innodb(MySqlParser.Create_tablespace_innodbContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_tablespace_innodb}.
	 * @param ctx the parse tree
	 */
	void exitCreate_tablespace_innodb(MySqlParser.Create_tablespace_innodbContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_tablespace_ndb}.
	 * @param ctx the parse tree
	 */
	void enterCreate_tablespace_ndb(MySqlParser.Create_tablespace_ndbContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_tablespace_ndb}.
	 * @param ctx the parse tree
	 */
	void exitCreate_tablespace_ndb(MySqlParser.Create_tablespace_ndbContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_trigger}.
	 * @param ctx the parse tree
	 */
	void enterCreate_trigger(MySqlParser.Create_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_trigger}.
	 * @param ctx the parse tree
	 */
	void exitCreate_trigger(MySqlParser.Create_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_view}.
	 * @param ctx the parse tree
	 */
	void enterCreate_view(MySqlParser.Create_viewContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_view}.
	 * @param ctx the parse tree
	 */
	void exitCreate_view(MySqlParser.Create_viewContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_database_option}.
	 * @param ctx the parse tree
	 */
	void enterCreate_database_option(MySqlParser.Create_database_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_database_option}.
	 * @param ctx the parse tree
	 */
	void exitCreate_database_option(MySqlParser.Create_database_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#owner_statement}.
	 * @param ctx the parse tree
	 */
	void enterOwner_statement(MySqlParser.Owner_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#owner_statement}.
	 * @param ctx the parse tree
	 */
	void exitOwner_statement(MySqlParser.Owner_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preciseSchedule}
	 * labeled alternative in {@link MySqlParser#schedule_expression}.
	 * @param ctx the parse tree
	 */
	void enterPreciseSchedule(MySqlParser.PreciseScheduleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preciseSchedule}
	 * labeled alternative in {@link MySqlParser#schedule_expression}.
	 * @param ctx the parse tree
	 */
	void exitPreciseSchedule(MySqlParser.PreciseScheduleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalSchedule}
	 * labeled alternative in {@link MySqlParser#schedule_expression}.
	 * @param ctx the parse tree
	 */
	void enterIntervalSchedule(MySqlParser.IntervalScheduleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalSchedule}
	 * labeled alternative in {@link MySqlParser#schedule_expression}.
	 * @param ctx the parse tree
	 */
	void exitIntervalSchedule(MySqlParser.IntervalScheduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#timestamp_value}.
	 * @param ctx the parse tree
	 */
	void enterTimestamp_value(MySqlParser.Timestamp_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#timestamp_value}.
	 * @param ctx the parse tree
	 */
	void exitTimestamp_value(MySqlParser.Timestamp_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#interval_expr}.
	 * @param ctx the parse tree
	 */
	void enterInterval_expr(MySqlParser.Interval_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#interval_expr}.
	 * @param ctx the parse tree
	 */
	void exitInterval_expr(MySqlParser.Interval_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#interval_type}.
	 * @param ctx the parse tree
	 */
	void enterInterval_type(MySqlParser.Interval_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#interval_type}.
	 * @param ctx the parse tree
	 */
	void exitInterval_type(MySqlParser.Interval_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#index_type}.
	 * @param ctx the parse tree
	 */
	void enterIndex_type(MySqlParser.Index_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#index_type}.
	 * @param ctx the parse tree
	 */
	void exitIndex_type(MySqlParser.Index_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#index_option}.
	 * @param ctx the parse tree
	 */
	void enterIndex_option(MySqlParser.Index_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#index_option}.
	 * @param ctx the parse tree
	 */
	void exitIndex_option(MySqlParser.Index_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#proc_param}.
	 * @param ctx the parse tree
	 */
	void enterProc_param(MySqlParser.Proc_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#proc_param}.
	 * @param ctx the parse tree
	 */
	void exitProc_param(MySqlParser.Proc_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#func_param}.
	 * @param ctx the parse tree
	 */
	void enterFunc_param(MySqlParser.Func_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#func_param}.
	 * @param ctx the parse tree
	 */
	void exitFunc_param(MySqlParser.Func_paramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rcComment}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void enterRcComment(MySqlParser.RcCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rcComment}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void exitRcComment(MySqlParser.RcCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rcSqllang}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void enterRcSqllang(MySqlParser.RcSqllangContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rcSqllang}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void exitRcSqllang(MySqlParser.RcSqllangContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rcDeterm}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void enterRcDeterm(MySqlParser.RcDetermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rcDeterm}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void exitRcDeterm(MySqlParser.RcDetermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rcSqldata}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void enterRcSqldata(MySqlParser.RcSqldataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rcSqldata}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void exitRcSqldata(MySqlParser.RcSqldataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rcSecurestmt}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void enterRcSecurestmt(MySqlParser.RcSecurestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rcSecurestmt}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 */
	void exitRcSecurestmt(MySqlParser.RcSecurestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#server_option}.
	 * @param ctx the parse tree
	 */
	void enterServer_option(MySqlParser.Server_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#server_option}.
	 * @param ctx the parse tree
	 */
	void exitServer_option(MySqlParser.Server_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#column_def_table_constraints}.
	 * @param ctx the parse tree
	 */
	void enterColumn_def_table_constraints(MySqlParser.Column_def_table_constraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#column_def_table_constraints}.
	 * @param ctx the parse tree
	 */
	void exitColumn_def_table_constraints(MySqlParser.Column_def_table_constraintsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(MySqlParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(MySqlParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraintDefinition(MySqlParser.ConstraintDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraintDefinition(MySqlParser.ConstraintDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterIndexDefinition(MySqlParser.IndexDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitIndexDefinition(MySqlParser.IndexDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#column_definition}.
	 * @param ctx the parse tree
	 */
	void enterColumn_definition(MySqlParser.Column_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#column_definition}.
	 * @param ctx the parse tree
	 */
	void exitColumn_definition(MySqlParser.Column_definitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrNull}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrNull(MySqlParser.ColConstrNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrNull}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrNull(MySqlParser.ColConstrNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrDflt}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrDflt(MySqlParser.ColConstrDfltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrDflt}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrDflt(MySqlParser.ColConstrDfltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrAuInc}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrAuInc(MySqlParser.ColConstrAuIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrAuInc}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrAuInc(MySqlParser.ColConstrAuIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrPK}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrPK(MySqlParser.ColConstrPKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrPK}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrPK(MySqlParser.ColConstrPKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrUK}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrUK(MySqlParser.ColConstrUKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrUK}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrUK(MySqlParser.ColConstrUKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrComment}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrComment(MySqlParser.ColConstrCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrComment}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrComment(MySqlParser.ColConstrCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrForm}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrForm(MySqlParser.ColConstrFormContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrForm}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrForm(MySqlParser.ColConstrFormContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrStorage}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrStorage(MySqlParser.ColConstrStorageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrStorage}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrStorage(MySqlParser.ColConstrStorageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colConstrRefdef}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstrRefdef(MySqlParser.ColConstrRefdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colConstrRefdef}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstrRefdef(MySqlParser.ColConstrRefdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblConstrPK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTblConstrPK(MySqlParser.TblConstrPKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblConstrPK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTblConstrPK(MySqlParser.TblConstrPKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblConstrUK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTblConstrUK(MySqlParser.TblConstrUKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblConstrUK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTblConstrUK(MySqlParser.TblConstrUKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblConstrFK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTblConstrFK(MySqlParser.TblConstrFKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblConstrFK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTblConstrFK(MySqlParser.TblConstrFKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblConstCheck}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTblConstCheck(MySqlParser.TblConstCheckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblConstCheck}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTblConstCheck(MySqlParser.TblConstCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#reference_definition}.
	 * @param ctx the parse tree
	 */
	void enterReference_definition(MySqlParser.Reference_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#reference_definition}.
	 * @param ctx the parse tree
	 */
	void exitReference_definition(MySqlParser.Reference_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#on_delete_action}.
	 * @param ctx the parse tree
	 */
	void enterOn_delete_action(MySqlParser.On_delete_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#on_delete_action}.
	 * @param ctx the parse tree
	 */
	void exitOn_delete_action(MySqlParser.On_delete_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#on_update_action}.
	 * @param ctx the parse tree
	 */
	void enterOn_update_action(MySqlParser.On_update_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#on_update_action}.
	 * @param ctx the parse tree
	 */
	void exitOn_update_action(MySqlParser.On_update_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#reference_action_control_type}.
	 * @param ctx the parse tree
	 */
	void enterReference_action_control_type(MySqlParser.Reference_action_control_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#reference_action_control_type}.
	 * @param ctx the parse tree
	 */
	void exitReference_action_control_type(MySqlParser.Reference_action_control_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleIndex}
	 * labeled alternative in {@link MySqlParser#index_column_definition}.
	 * @param ctx the parse tree
	 */
	void enterSimpleIndex(MySqlParser.SimpleIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleIndex}
	 * labeled alternative in {@link MySqlParser#index_column_definition}.
	 * @param ctx the parse tree
	 */
	void exitSimpleIndex(MySqlParser.SimpleIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specIndex}
	 * labeled alternative in {@link MySqlParser#index_column_definition}.
	 * @param ctx the parse tree
	 */
	void enterSpecIndex(MySqlParser.SpecIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specIndex}
	 * labeled alternative in {@link MySqlParser#index_column_definition}.
	 * @param ctx the parse tree
	 */
	void exitSpecIndex(MySqlParser.SpecIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptEngine}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptEngine(MySqlParser.TblOptEngineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptEngine}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptEngine(MySqlParser.TblOptEngineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptAuInc}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptAuInc(MySqlParser.TblOptAuIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptAuInc}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptAuInc(MySqlParser.TblOptAuIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptAvgRLen}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptAvgRLen(MySqlParser.TblOptAvgRLenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptAvgRLen}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptAvgRLen(MySqlParser.TblOptAvgRLenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptDefCharSet}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptDefCharSet(MySqlParser.TblOptDefCharSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptDefCharSet}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptDefCharSet(MySqlParser.TblOptDefCharSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptChkSum}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptChkSum(MySqlParser.TblOptChkSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptChkSum}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptChkSum(MySqlParser.TblOptChkSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptDefCollate}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptDefCollate(MySqlParser.TblOptDefCollateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptDefCollate}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptDefCollate(MySqlParser.TblOptDefCollateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptComment}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptComment(MySqlParser.TblOptCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptComment}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptComment(MySqlParser.TblOptCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptCompr}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptCompr(MySqlParser.TblOptComprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptCompr}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptCompr(MySqlParser.TblOptComprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptConn}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptConn(MySqlParser.TblOptConnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptConn}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptConn(MySqlParser.TblOptConnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptDataDir}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptDataDir(MySqlParser.TblOptDataDirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptDataDir}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptDataDir(MySqlParser.TblOptDataDirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptDelKW}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptDelKW(MySqlParser.TblOptDelKWContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptDelKW}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptDelKW(MySqlParser.TblOptDelKWContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptEncr}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptEncr(MySqlParser.TblOptEncrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptEncr}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptEncr(MySqlParser.TblOptEncrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptIndexDir}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptIndexDir(MySqlParser.TblOptIndexDirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptIndexDir}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptIndexDir(MySqlParser.TblOptIndexDirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptInsMeth}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptInsMeth(MySqlParser.TblOptInsMethContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptInsMeth}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptInsMeth(MySqlParser.TblOptInsMethContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptKeyBlockSz}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptKeyBlockSz(MySqlParser.TblOptKeyBlockSzContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptKeyBlockSz}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptKeyBlockSz(MySqlParser.TblOptKeyBlockSzContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptMaxRows}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptMaxRows(MySqlParser.TblOptMaxRowsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptMaxRows}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptMaxRows(MySqlParser.TblOptMaxRowsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptMinRows}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptMinRows(MySqlParser.TblOptMinRowsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptMinRows}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptMinRows(MySqlParser.TblOptMinRowsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptPackK}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptPackK(MySqlParser.TblOptPackKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptPackK}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptPackK(MySqlParser.TblOptPackKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptPasswd}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptPasswd(MySqlParser.TblOptPasswdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptPasswd}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptPasswd(MySqlParser.TblOptPasswdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptRowFormat}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptRowFormat(MySqlParser.TblOptRowFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptRowFormat}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptRowFormat(MySqlParser.TblOptRowFormatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptStatAutoR}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptStatAutoR(MySqlParser.TblOptStatAutoRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptStatAutoR}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptStatAutoR(MySqlParser.TblOptStatAutoRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptStatPersist}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptStatPersist(MySqlParser.TblOptStatPersistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptStatPersist}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptStatPersist(MySqlParser.TblOptStatPersistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptStatSamplPg}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptStatSamplPg(MySqlParser.TblOptStatSamplPgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptStatSamplPg}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptStatSamplPg(MySqlParser.TblOptStatSamplPgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptTablespace}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptTablespace(MySqlParser.TblOptTablespaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptTablespace}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptTablespace(MySqlParser.TblOptTablespaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tblOptUnion}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void enterTblOptUnion(MySqlParser.TblOptUnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tblOptUnion}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 */
	void exitTblOptUnion(MySqlParser.TblOptUnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#partition_options}.
	 * @param ctx the parse tree
	 */
	void enterPartition_options(MySqlParser.Partition_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#partition_options}.
	 * @param ctx the parse tree
	 */
	void exitPartition_options(MySqlParser.Partition_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#partition_function_definition}.
	 * @param ctx the parse tree
	 */
	void enterPartition_function_definition(MySqlParser.Partition_function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#partition_function_definition}.
	 * @param ctx the parse tree
	 */
	void exitPartition_function_definition(MySqlParser.Partition_function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#linear_partition_func_def}.
	 * @param ctx the parse tree
	 */
	void enterLinear_partition_func_def(MySqlParser.Linear_partition_func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#linear_partition_func_def}.
	 * @param ctx the parse tree
	 */
	void exitLinear_partition_func_def(MySqlParser.Linear_partition_func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#partition_def}.
	 * @param ctx the parse tree
	 */
	void enterPartition_def(MySqlParser.Partition_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#partition_def}.
	 * @param ctx the parse tree
	 */
	void exitPartition_def(MySqlParser.Partition_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#subpartition_def}.
	 * @param ctx the parse tree
	 */
	void enterSubpartition_def(MySqlParser.Subpartition_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#subpartition_def}.
	 * @param ctx the parse tree
	 */
	void exitSubpartition_def(MySqlParser.Subpartition_defContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alterDb}
	 * labeled alternative in {@link MySqlParser#alter_database}.
	 * @param ctx the parse tree
	 */
	void enterAlterDb(MySqlParser.AlterDbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alterDb}
	 * labeled alternative in {@link MySqlParser#alter_database}.
	 * @param ctx the parse tree
	 */
	void exitAlterDb(MySqlParser.AlterDbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alterDbUpgradeName}
	 * labeled alternative in {@link MySqlParser#alter_database}.
	 * @param ctx the parse tree
	 */
	void enterAlterDbUpgradeName(MySqlParser.AlterDbUpgradeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alterDbUpgradeName}
	 * labeled alternative in {@link MySqlParser#alter_database}.
	 * @param ctx the parse tree
	 */
	void exitAlterDbUpgradeName(MySqlParser.AlterDbUpgradeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_event}.
	 * @param ctx the parse tree
	 */
	void enterAlter_event(MySqlParser.Alter_eventContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_event}.
	 * @param ctx the parse tree
	 */
	void exitAlter_event(MySqlParser.Alter_eventContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_function}.
	 * @param ctx the parse tree
	 */
	void enterAlter_function(MySqlParser.Alter_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_function}.
	 * @param ctx the parse tree
	 */
	void exitAlter_function(MySqlParser.Alter_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_instance}.
	 * @param ctx the parse tree
	 */
	void enterAlter_instance(MySqlParser.Alter_instanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_instance}.
	 * @param ctx the parse tree
	 */
	void exitAlter_instance(MySqlParser.Alter_instanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_logfile_group}.
	 * @param ctx the parse tree
	 */
	void enterAlter_logfile_group(MySqlParser.Alter_logfile_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_logfile_group}.
	 * @param ctx the parse tree
	 */
	void exitAlter_logfile_group(MySqlParser.Alter_logfile_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_procedure}.
	 * @param ctx the parse tree
	 */
	void enterAlter_procedure(MySqlParser.Alter_procedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_procedure}.
	 * @param ctx the parse tree
	 */
	void exitAlter_procedure(MySqlParser.Alter_procedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_server}.
	 * @param ctx the parse tree
	 */
	void enterAlter_server(MySqlParser.Alter_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_server}.
	 * @param ctx the parse tree
	 */
	void exitAlter_server(MySqlParser.Alter_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_table}.
	 * @param ctx the parse tree
	 */
	void enterAlter_table(MySqlParser.Alter_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_table}.
	 * @param ctx the parse tree
	 */
	void exitAlter_table(MySqlParser.Alter_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_tablespace}.
	 * @param ctx the parse tree
	 */
	void enterAlter_tablespace(MySqlParser.Alter_tablespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_tablespace}.
	 * @param ctx the parse tree
	 */
	void exitAlter_tablespace(MySqlParser.Alter_tablespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#alter_view}.
	 * @param ctx the parse tree
	 */
	void enterAlter_view(MySqlParser.Alter_viewContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#alter_view}.
	 * @param ctx the parse tree
	 */
	void exitAlter_view(MySqlParser.Alter_viewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblTableOpt}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblTableOpt(MySqlParser.AltblTableOptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblTableOpt}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblTableOpt(MySqlParser.AltblTableOptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddCol}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddCol(MySqlParser.AltblAddColContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddCol}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddCol(MySqlParser.AltblAddColContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddCols}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddCols(MySqlParser.AltblAddColsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddCols}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddCols(MySqlParser.AltblAddColsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddIndex(MySqlParser.AltblAddIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddIndex(MySqlParser.AltblAddIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddPK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddPK(MySqlParser.AltblAddPKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddPK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddPK(MySqlParser.AltblAddPKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddUK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddUK(MySqlParser.AltblAddUKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddUK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddUK(MySqlParser.AltblAddUKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddSpecIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddSpecIndex(MySqlParser.AltblAddSpecIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddSpecIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddSpecIndex(MySqlParser.AltblAddSpecIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddFK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddFK(MySqlParser.AltblAddFKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddFK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddFK(MySqlParser.AltblAddFKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAlg}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAlg(MySqlParser.AltblAlgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAlg}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAlg(MySqlParser.AltblAlgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblColDef}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblColDef(MySqlParser.AltblColDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblColDef}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblColDef(MySqlParser.AltblColDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblColChange}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblColChange(MySqlParser.AltblColChangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblColChange}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblColChange(MySqlParser.AltblColChangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblLock}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblLock(MySqlParser.AltblLockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblLock}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblLock(MySqlParser.AltblLockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblColMod}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblColMod(MySqlParser.AltblColModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblColMod}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblColMod(MySqlParser.AltblColModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblColDrop}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblColDrop(MySqlParser.AltblColDropContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblColDrop}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblColDrop(MySqlParser.AltblColDropContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDropPK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDropPK(MySqlParser.AltblDropPKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDropPK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDropPK(MySqlParser.AltblDropPKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDropIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDropIndex(MySqlParser.AltblDropIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDropIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDropIndex(MySqlParser.AltblDropIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDropFK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDropFK(MySqlParser.AltblDropFKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDropFK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDropFK(MySqlParser.AltblDropFKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDisKey}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDisKey(MySqlParser.AltblDisKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDisKey}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDisKey(MySqlParser.AltblDisKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblEnKey}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblEnKey(MySqlParser.AltblEnKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblEnKey}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblEnKey(MySqlParser.AltblEnKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblRenameTbl}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblRenameTbl(MySqlParser.AltblRenameTblContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblRenameTbl}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblRenameTbl(MySqlParser.AltblRenameTblContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblResort}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblResort(MySqlParser.AltblResortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblResort}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblResort(MySqlParser.AltblResortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblConvert}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblConvert(MySqlParser.AltblConvertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblConvert}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblConvert(MySqlParser.AltblConvertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDefCharset}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDefCharset(MySqlParser.AltblDefCharsetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDefCharset}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDefCharset(MySqlParser.AltblDefCharsetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDisTblspace}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDisTblspace(MySqlParser.AltblDisTblspaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDisTblspace}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDisTblspace(MySqlParser.AltblDisTblspaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblImpTblSpace}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblImpTblSpace(MySqlParser.AltblImpTblSpaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblImpTblSpace}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblImpTblSpace(MySqlParser.AltblImpTblSpaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblForce}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblForce(MySqlParser.AltblForceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblForce}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblForce(MySqlParser.AltblForceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblValid}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblValid(MySqlParser.AltblValidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblValid}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblValid(MySqlParser.AltblValidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAddPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAddPart(MySqlParser.AltblAddPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAddPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAddPart(MySqlParser.AltblAddPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDropPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDropPart(MySqlParser.AltblDropPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDropPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDropPart(MySqlParser.AltblDropPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblDiscartPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblDiscartPart(MySqlParser.AltblDiscartPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblDiscartPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblDiscartPart(MySqlParser.AltblDiscartPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblImportPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblImportPart(MySqlParser.AltblImportPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblImportPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblImportPart(MySqlParser.AltblImportPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblTruncPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblTruncPart(MySqlParser.AltblTruncPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblTruncPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblTruncPart(MySqlParser.AltblTruncPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblCoalPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblCoalPart(MySqlParser.AltblCoalPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblCoalPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblCoalPart(MySqlParser.AltblCoalPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblReorgPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblReorgPart(MySqlParser.AltblReorgPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblReorgPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblReorgPart(MySqlParser.AltblReorgPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblExchPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblExchPart(MySqlParser.AltblExchPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblExchPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblExchPart(MySqlParser.AltblExchPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblAnalPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblAnalPart(MySqlParser.AltblAnalPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblAnalPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblAnalPart(MySqlParser.AltblAnalPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblCheckPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblCheckPart(MySqlParser.AltblCheckPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblCheckPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblCheckPart(MySqlParser.AltblCheckPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblOptimPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblOptimPart(MySqlParser.AltblOptimPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblOptimPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblOptimPart(MySqlParser.AltblOptimPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblRebuildPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblRebuildPart(MySqlParser.AltblRebuildPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblRebuildPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblRebuildPart(MySqlParser.AltblRebuildPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblRepairPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblRepairPart(MySqlParser.AltblRepairPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblRepairPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblRepairPart(MySqlParser.AltblRepairPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblRemovePart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblRemovePart(MySqlParser.AltblRemovePartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblRemovePart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblRemovePart(MySqlParser.AltblRemovePartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code altblUpgrPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void enterAltblUpgrPart(MySqlParser.AltblUpgrPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code altblUpgrPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 */
	void exitAltblUpgrPart(MySqlParser.AltblUpgrPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_database}.
	 * @param ctx the parse tree
	 */
	void enterDrop_database(MySqlParser.Drop_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_database}.
	 * @param ctx the parse tree
	 */
	void exitDrop_database(MySqlParser.Drop_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_event}.
	 * @param ctx the parse tree
	 */
	void enterDrop_event(MySqlParser.Drop_eventContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_event}.
	 * @param ctx the parse tree
	 */
	void exitDrop_event(MySqlParser.Drop_eventContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_index}.
	 * @param ctx the parse tree
	 */
	void enterDrop_index(MySqlParser.Drop_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_index}.
	 * @param ctx the parse tree
	 */
	void exitDrop_index(MySqlParser.Drop_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_logfile_group}.
	 * @param ctx the parse tree
	 */
	void enterDrop_logfile_group(MySqlParser.Drop_logfile_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_logfile_group}.
	 * @param ctx the parse tree
	 */
	void exitDrop_logfile_group(MySqlParser.Drop_logfile_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_procedure}.
	 * @param ctx the parse tree
	 */
	void enterDrop_procedure(MySqlParser.Drop_procedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_procedure}.
	 * @param ctx the parse tree
	 */
	void exitDrop_procedure(MySqlParser.Drop_procedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_function}.
	 * @param ctx the parse tree
	 */
	void enterDrop_function(MySqlParser.Drop_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_function}.
	 * @param ctx the parse tree
	 */
	void exitDrop_function(MySqlParser.Drop_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_server}.
	 * @param ctx the parse tree
	 */
	void enterDrop_server(MySqlParser.Drop_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_server}.
	 * @param ctx the parse tree
	 */
	void exitDrop_server(MySqlParser.Drop_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_table}.
	 * @param ctx the parse tree
	 */
	void enterDrop_table(MySqlParser.Drop_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_table}.
	 * @param ctx the parse tree
	 */
	void exitDrop_table(MySqlParser.Drop_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_tablespace}.
	 * @param ctx the parse tree
	 */
	void enterDrop_tablespace(MySqlParser.Drop_tablespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_tablespace}.
	 * @param ctx the parse tree
	 */
	void exitDrop_tablespace(MySqlParser.Drop_tablespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_trigger}.
	 * @param ctx the parse tree
	 */
	void enterDrop_trigger(MySqlParser.Drop_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_trigger}.
	 * @param ctx the parse tree
	 */
	void exitDrop_trigger(MySqlParser.Drop_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_view}.
	 * @param ctx the parse tree
	 */
	void enterDrop_view(MySqlParser.Drop_viewContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_view}.
	 * @param ctx the parse tree
	 */
	void exitDrop_view(MySqlParser.Drop_viewContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#rename_table}.
	 * @param ctx the parse tree
	 */
	void enterRename_table(MySqlParser.Rename_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#rename_table}.
	 * @param ctx the parse tree
	 */
	void exitRename_table(MySqlParser.Rename_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#truncate_table}.
	 * @param ctx the parse tree
	 */
	void enterTruncate_table(MySqlParser.Truncate_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#truncate_table}.
	 * @param ctx the parse tree
	 */
	void exitTruncate_table(MySqlParser.Truncate_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#call_statement}.
	 * @param ctx the parse tree
	 */
	void enterCall_statement(MySqlParser.Call_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#call_statement}.
	 * @param ctx the parse tree
	 */
	void exitCall_statement(MySqlParser.Call_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#delete_statement}.
	 * @param ctx the parse tree
	 */
	void enterDelete_statement(MySqlParser.Delete_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#delete_statement}.
	 * @param ctx the parse tree
	 */
	void exitDelete_statement(MySqlParser.Delete_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#do_statement}.
	 * @param ctx the parse tree
	 */
	void enterDo_statement(MySqlParser.Do_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#do_statement}.
	 * @param ctx the parse tree
	 */
	void exitDo_statement(MySqlParser.Do_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#handler_statement}.
	 * @param ctx the parse tree
	 */
	void enterHandler_statement(MySqlParser.Handler_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#handler_statement}.
	 * @param ctx the parse tree
	 */
	void exitHandler_statement(MySqlParser.Handler_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void enterInsert_statement(MySqlParser.Insert_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void exitInsert_statement(MySqlParser.Insert_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#load_data_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoad_data_statement(MySqlParser.Load_data_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#load_data_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoad_data_statement(MySqlParser.Load_data_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#load_xml_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoad_xml_statement(MySqlParser.Load_xml_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#load_xml_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoad_xml_statement(MySqlParser.Load_xml_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#replace_statement}.
	 * @param ctx the parse tree
	 */
	void enterReplace_statement(MySqlParser.Replace_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#replace_statement}.
	 * @param ctx the parse tree
	 */
	void exitReplace_statement(MySqlParser.Replace_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSelect(MySqlParser.SimpleSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterParenSelect(MySqlParser.ParenSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitParenSelect(MySqlParser.ParenSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterUnionSelect(MySqlParser.UnionSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitUnionSelect(MySqlParser.UnionSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionParenSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterUnionParenSelect(MySqlParser.UnionParenSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionParenSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitUnionParenSelect(MySqlParser.UnionParenSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#update_statement}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_statement(MySqlParser.Update_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#update_statement}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_statement(MySqlParser.Update_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#insert_statement_value}.
	 * @param ctx the parse tree
	 */
	void enterInsert_statement_value(MySqlParser.Insert_statement_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#insert_statement_value}.
	 * @param ctx the parse tree
	 */
	void exitInsert_statement_value(MySqlParser.Insert_statement_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#update_elem}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_elem(MySqlParser.Update_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#update_elem}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_elem(MySqlParser.Update_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#col_or_uservar}.
	 * @param ctx the parse tree
	 */
	void enterCol_or_uservar(MySqlParser.Col_or_uservarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#col_or_uservar}.
	 * @param ctx the parse tree
	 */
	void exitCol_or_uservar(MySqlParser.Col_or_uservarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#single_delete_statement}.
	 * @param ctx the parse tree
	 */
	void enterSingle_delete_statement(MySqlParser.Single_delete_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#single_delete_statement}.
	 * @param ctx the parse tree
	 */
	void exitSingle_delete_statement(MySqlParser.Single_delete_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#multiple_delete_statement}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_delete_statement(MySqlParser.Multiple_delete_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#multiple_delete_statement}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_delete_statement(MySqlParser.Multiple_delete_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#handler_open_statement}.
	 * @param ctx the parse tree
	 */
	void enterHandler_open_statement(MySqlParser.Handler_open_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#handler_open_statement}.
	 * @param ctx the parse tree
	 */
	void exitHandler_open_statement(MySqlParser.Handler_open_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#handler_read_index_statement}.
	 * @param ctx the parse tree
	 */
	void enterHandler_read_index_statement(MySqlParser.Handler_read_index_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#handler_read_index_statement}.
	 * @param ctx the parse tree
	 */
	void exitHandler_read_index_statement(MySqlParser.Handler_read_index_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#handler_read_statement}.
	 * @param ctx the parse tree
	 */
	void enterHandler_read_statement(MySqlParser.Handler_read_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#handler_read_statement}.
	 * @param ctx the parse tree
	 */
	void exitHandler_read_statement(MySqlParser.Handler_read_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#handler_close_statement}.
	 * @param ctx the parse tree
	 */
	void enterHandler_close_statement(MySqlParser.Handler_close_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#handler_close_statement}.
	 * @param ctx the parse tree
	 */
	void exitHandler_close_statement(MySqlParser.Handler_close_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#single_update_statement}.
	 * @param ctx the parse tree
	 */
	void enterSingle_update_statement(MySqlParser.Single_update_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#single_update_statement}.
	 * @param ctx the parse tree
	 */
	void exitSingle_update_statement(MySqlParser.Single_update_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#multiple_update_statement}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_update_statement(MySqlParser.Multiple_update_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#multiple_update_statement}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_update_statement(MySqlParser.Multiple_update_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_clause(MySqlParser.Order_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_clause(MySqlParser.Order_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_expression(MySqlParser.Order_by_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_expression(MySqlParser.Order_by_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#table_sources}.
	 * @param ctx the parse tree
	 */
	void enterTable_sources(MySqlParser.Table_sourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#table_sources}.
	 * @param ctx the parse tree
	 */
	void exitTable_sources(MySqlParser.Table_sourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#table_source}.
	 * @param ctx the parse tree
	 */
	void enterTable_source(MySqlParser.Table_sourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#table_source}.
	 * @param ctx the parse tree
	 */
	void exitTable_source(MySqlParser.Table_sourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomTableItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void enterAtomTableItem(MySqlParser.AtomTableItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomTableItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void exitAtomTableItem(MySqlParser.AtomTableItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryTableItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryTableItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableSourcesItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void enterTableSourcesItem(MySqlParser.TableSourcesItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableSourcesItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void exitTableSourcesItem(MySqlParser.TableSourcesItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#index_hint}.
	 * @param ctx the parse tree
	 */
	void enterIndex_hint(MySqlParser.Index_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#index_hint}.
	 * @param ctx the parse tree
	 */
	void exitIndex_hint(MySqlParser.Index_hintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void enterInnerJoin(MySqlParser.InnerJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void exitInnerJoin(MySqlParser.InnerJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code straightJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void enterStraightJoin(MySqlParser.StraightJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code straightJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void exitStraightJoin(MySqlParser.StraightJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outerJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void enterOuterJoin(MySqlParser.OuterJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outerJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void exitOuterJoin(MySqlParser.OuterJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void enterNaturalJoin(MySqlParser.NaturalJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void exitNaturalJoin(MySqlParser.NaturalJoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(MySqlParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(MySqlParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuery_expression(MySqlParser.Query_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuery_expression(MySqlParser.Query_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#query_expression_nointo}.
	 * @param ctx the parse tree
	 */
	void enterQuery_expression_nointo(MySqlParser.Query_expression_nointoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#query_expression_nointo}.
	 * @param ctx the parse tree
	 */
	void exitQuery_expression_nointo(MySqlParser.Query_expression_nointoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void enterQuery_specification(MySqlParser.Query_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void exitQuery_specification(MySqlParser.Query_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#query_specification_nointo}.
	 * @param ctx the parse tree
	 */
	void enterQuery_specification_nointo(MySqlParser.Query_specification_nointoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#query_specification_nointo}.
	 * @param ctx the parse tree
	 */
	void exitQuery_specification_nointo(MySqlParser.Query_specification_nointoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#union_parenth}.
	 * @param ctx the parse tree
	 */
	void enterUnion_parenth(MySqlParser.Union_parenthContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#union_parenth}.
	 * @param ctx the parse tree
	 */
	void exitUnion_parenth(MySqlParser.Union_parenthContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#union_statement}.
	 * @param ctx the parse tree
	 */
	void enterUnion_statement(MySqlParser.Union_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#union_statement}.
	 * @param ctx the parse tree
	 */
	void exitUnion_statement(MySqlParser.Union_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#select_spec}.
	 * @param ctx the parse tree
	 */
	void enterSelect_spec(MySqlParser.Select_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#select_spec}.
	 * @param ctx the parse tree
	 */
	void exitSelect_spec(MySqlParser.Select_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#select_list}.
	 * @param ctx the parse tree
	 */
	void enterSelect_list(MySqlParser.Select_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#select_list}.
	 * @param ctx the parse tree
	 */
	void exitSelect_list(MySqlParser.Select_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sellistelAllCol}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void enterSellistelAllCol(MySqlParser.SellistelAllColContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sellistelAllCol}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void exitSellistelAllCol(MySqlParser.SellistelAllColContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sellistelCol}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void enterSellistelCol(MySqlParser.SellistelColContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sellistelCol}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void exitSellistelCol(MySqlParser.SellistelColContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sellistelFunc}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void enterSellistelFunc(MySqlParser.SellistelFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sellistelFunc}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void exitSellistelFunc(MySqlParser.SellistelFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sellistelExpr}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void enterSellistelExpr(MySqlParser.SellistelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sellistelExpr}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void exitSellistelExpr(MySqlParser.SellistelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectIntoVars}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 */
	void enterSelectIntoVars(MySqlParser.SelectIntoVarsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectIntoVars}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 */
	void exitSelectIntoVars(MySqlParser.SelectIntoVarsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectIntoDump}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 */
	void enterSelectIntoDump(MySqlParser.SelectIntoDumpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectIntoDump}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 */
	void exitSelectIntoDump(MySqlParser.SelectIntoDumpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectIntoOutfile}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 */
	void enterSelectIntoOutfile(MySqlParser.SelectIntoOutfileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectIntoOutfile}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 */
	void exitSelectIntoOutfile(MySqlParser.SelectIntoOutfileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void enterFrom_clause(MySqlParser.From_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void exitFrom_clause(MySqlParser.From_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void enterGroup_by_item(MySqlParser.Group_by_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void exitGroup_by_item(MySqlParser.Group_by_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void enterLimit_clause(MySqlParser.Limit_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void exitLimit_clause(MySqlParser.Limit_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#start_transaction}.
	 * @param ctx the parse tree
	 */
	void enterStart_transaction(MySqlParser.Start_transactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#start_transaction}.
	 * @param ctx the parse tree
	 */
	void exitStart_transaction(MySqlParser.Start_transactionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#begin_work}.
	 * @param ctx the parse tree
	 */
	void enterBegin_work(MySqlParser.Begin_workContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#begin_work}.
	 * @param ctx the parse tree
	 */
	void exitBegin_work(MySqlParser.Begin_workContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#commit_work}.
	 * @param ctx the parse tree
	 */
	void enterCommit_work(MySqlParser.Commit_workContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#commit_work}.
	 * @param ctx the parse tree
	 */
	void exitCommit_work(MySqlParser.Commit_workContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#rollback_work}.
	 * @param ctx the parse tree
	 */
	void enterRollback_work(MySqlParser.Rollback_workContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#rollback_work}.
	 * @param ctx the parse tree
	 */
	void exitRollback_work(MySqlParser.Rollback_workContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#savepoint_statement}.
	 * @param ctx the parse tree
	 */
	void enterSavepoint_statement(MySqlParser.Savepoint_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#savepoint_statement}.
	 * @param ctx the parse tree
	 */
	void exitSavepoint_statement(MySqlParser.Savepoint_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#rollback_statement}.
	 * @param ctx the parse tree
	 */
	void enterRollback_statement(MySqlParser.Rollback_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#rollback_statement}.
	 * @param ctx the parse tree
	 */
	void exitRollback_statement(MySqlParser.Rollback_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#release_statement}.
	 * @param ctx the parse tree
	 */
	void enterRelease_statement(MySqlParser.Release_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#release_statement}.
	 * @param ctx the parse tree
	 */
	void exitRelease_statement(MySqlParser.Release_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lock_tables}.
	 * @param ctx the parse tree
	 */
	void enterLock_tables(MySqlParser.Lock_tablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lock_tables}.
	 * @param ctx the parse tree
	 */
	void exitLock_tables(MySqlParser.Lock_tablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#unlock_tables}.
	 * @param ctx the parse tree
	 */
	void enterUnlock_tables(MySqlParser.Unlock_tablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#unlock_tables}.
	 * @param ctx the parse tree
	 */
	void exitUnlock_tables(MySqlParser.Unlock_tablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#set_autocommit_statement}.
	 * @param ctx the parse tree
	 */
	void enterSet_autocommit_statement(MySqlParser.Set_autocommit_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#set_autocommit_statement}.
	 * @param ctx the parse tree
	 */
	void exitSet_autocommit_statement(MySqlParser.Set_autocommit_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#set_transaction_statement}.
	 * @param ctx the parse tree
	 */
	void enterSet_transaction_statement(MySqlParser.Set_transaction_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#set_transaction_statement}.
	 * @param ctx the parse tree
	 */
	void exitSet_transaction_statement(MySqlParser.Set_transaction_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#transact_option}.
	 * @param ctx the parse tree
	 */
	void enterTransact_option(MySqlParser.Transact_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#transact_option}.
	 * @param ctx the parse tree
	 */
	void exitTransact_option(MySqlParser.Transact_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lock_table_element}.
	 * @param ctx the parse tree
	 */
	void enterLock_table_element(MySqlParser.Lock_table_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lock_table_element}.
	 * @param ctx the parse tree
	 */
	void exitLock_table_element(MySqlParser.Lock_table_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#trans_characteristic}.
	 * @param ctx the parse tree
	 */
	void enterTrans_characteristic(MySqlParser.Trans_characteristicContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#trans_characteristic}.
	 * @param ctx the parse tree
	 */
	void exitTrans_characteristic(MySqlParser.Trans_characteristicContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#transaction_level}.
	 * @param ctx the parse tree
	 */
	void enterTransaction_level(MySqlParser.Transaction_levelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#transaction_level}.
	 * @param ctx the parse tree
	 */
	void exitTransaction_level(MySqlParser.Transaction_levelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#change_master}.
	 * @param ctx the parse tree
	 */
	void enterChange_master(MySqlParser.Change_masterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#change_master}.
	 * @param ctx the parse tree
	 */
	void exitChange_master(MySqlParser.Change_masterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#change_repl_filter}.
	 * @param ctx the parse tree
	 */
	void enterChange_repl_filter(MySqlParser.Change_repl_filterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#change_repl_filter}.
	 * @param ctx the parse tree
	 */
	void exitChange_repl_filter(MySqlParser.Change_repl_filterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#purge_binary_logs}.
	 * @param ctx the parse tree
	 */
	void enterPurge_binary_logs(MySqlParser.Purge_binary_logsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#purge_binary_logs}.
	 * @param ctx the parse tree
	 */
	void exitPurge_binary_logs(MySqlParser.Purge_binary_logsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#reset_master}.
	 * @param ctx the parse tree
	 */
	void enterReset_master(MySqlParser.Reset_masterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#reset_master}.
	 * @param ctx the parse tree
	 */
	void exitReset_master(MySqlParser.Reset_masterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#reset_slave}.
	 * @param ctx the parse tree
	 */
	void enterReset_slave(MySqlParser.Reset_slaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#reset_slave}.
	 * @param ctx the parse tree
	 */
	void exitReset_slave(MySqlParser.Reset_slaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#start_slave}.
	 * @param ctx the parse tree
	 */
	void enterStart_slave(MySqlParser.Start_slaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#start_slave}.
	 * @param ctx the parse tree
	 */
	void exitStart_slave(MySqlParser.Start_slaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#stop_slave}.
	 * @param ctx the parse tree
	 */
	void enterStop_slave(MySqlParser.Stop_slaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#stop_slave}.
	 * @param ctx the parse tree
	 */
	void exitStop_slave(MySqlParser.Stop_slaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#start_group_repl}.
	 * @param ctx the parse tree
	 */
	void enterStart_group_repl(MySqlParser.Start_group_replContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#start_group_repl}.
	 * @param ctx the parse tree
	 */
	void exitStart_group_repl(MySqlParser.Start_group_replContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#stop_group_repl}.
	 * @param ctx the parse tree
	 */
	void enterStop_group_repl(MySqlParser.Stop_group_replContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#stop_group_repl}.
	 * @param ctx the parse tree
	 */
	void exitStop_group_repl(MySqlParser.Stop_group_replContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masterOptString}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void enterMasterOptString(MySqlParser.MasterOptStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masterOptString}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void exitMasterOptString(MySqlParser.MasterOptStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masterOptDecimal}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void enterMasterOptDecimal(MySqlParser.MasterOptDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masterOptDecimal}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void exitMasterOptDecimal(MySqlParser.MasterOptDecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masterOptBool}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void enterMasterOptBool(MySqlParser.MasterOptBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masterOptBool}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void exitMasterOptBool(MySqlParser.MasterOptBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masterOptReal}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void enterMasterOptReal(MySqlParser.MasterOptRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masterOptReal}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void exitMasterOptReal(MySqlParser.MasterOptRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masterOptIdList}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void enterMasterOptIdList(MySqlParser.MasterOptIdListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masterOptIdList}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 */
	void exitMasterOptIdList(MySqlParser.MasterOptIdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#string_master_option}.
	 * @param ctx the parse tree
	 */
	void enterString_master_option(MySqlParser.String_master_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#string_master_option}.
	 * @param ctx the parse tree
	 */
	void exitString_master_option(MySqlParser.String_master_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#decimal_master_option}.
	 * @param ctx the parse tree
	 */
	void enterDecimal_master_option(MySqlParser.Decimal_master_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#decimal_master_option}.
	 * @param ctx the parse tree
	 */
	void exitDecimal_master_option(MySqlParser.Decimal_master_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#bool_master_option}.
	 * @param ctx the parse tree
	 */
	void enterBool_master_option(MySqlParser.Bool_master_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#bool_master_option}.
	 * @param ctx the parse tree
	 */
	void exitBool_master_option(MySqlParser.Bool_master_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#channel_option}.
	 * @param ctx the parse tree
	 */
	void enterChannel_option(MySqlParser.Channel_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#channel_option}.
	 * @param ctx the parse tree
	 */
	void exitChannel_option(MySqlParser.Channel_optionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code replfilterDbList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void enterReplfilterDbList(MySqlParser.ReplfilterDbListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code replfilterDbList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void exitReplfilterDbList(MySqlParser.ReplfilterDbListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code replfilterTableList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void enterReplfilterTableList(MySqlParser.ReplfilterTableListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code replfilterTableList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void exitReplfilterTableList(MySqlParser.ReplfilterTableListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code replfilterStableList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void enterReplfilterStableList(MySqlParser.ReplfilterStableListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code replfilterStableList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void exitReplfilterStableList(MySqlParser.ReplfilterStableListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code replfilterTablepairList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void enterReplfilterTablepairList(MySqlParser.ReplfilterTablepairListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code replfilterTablepairList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 */
	void exitReplfilterTablepairList(MySqlParser.ReplfilterTablepairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#thread_type}.
	 * @param ctx the parse tree
	 */
	void enterThread_type(MySqlParser.Thread_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#thread_type}.
	 * @param ctx the parse tree
	 */
	void exitThread_type(MySqlParser.Thread_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code untilGtidSset}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void enterUntilGtidSset(MySqlParser.UntilGtidSsetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code untilGtidSset}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void exitUntilGtidSset(MySqlParser.UntilGtidSsetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code untilMasterLog}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void enterUntilMasterLog(MySqlParser.UntilMasterLogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code untilMasterLog}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void exitUntilMasterLog(MySqlParser.UntilMasterLogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code untilRelayLog}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void enterUntilRelayLog(MySqlParser.UntilRelayLogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code untilRelayLog}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void exitUntilRelayLog(MySqlParser.UntilRelayLogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code untilSqlGaps}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void enterUntilSqlGaps(MySqlParser.UntilSqlGapsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code untilSqlGaps}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 */
	void exitUntilSqlGaps(MySqlParser.UntilSqlGapsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#start_slave_connection_option}.
	 * @param ctx the parse tree
	 */
	void enterStart_slave_connection_option(MySqlParser.Start_slave_connection_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#start_slave_connection_option}.
	 * @param ctx the parse tree
	 */
	void exitStart_slave_connection_option(MySqlParser.Start_slave_connection_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#gtid_set}.
	 * @param ctx the parse tree
	 */
	void enterGtid_set(MySqlParser.Gtid_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#gtid_set}.
	 * @param ctx the parse tree
	 */
	void exitGtid_set(MySqlParser.Gtid_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xa_start_transaction}.
	 * @param ctx the parse tree
	 */
	void enterXa_start_transaction(MySqlParser.Xa_start_transactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xa_start_transaction}.
	 * @param ctx the parse tree
	 */
	void exitXa_start_transaction(MySqlParser.Xa_start_transactionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xa_end_transaction}.
	 * @param ctx the parse tree
	 */
	void enterXa_end_transaction(MySqlParser.Xa_end_transactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xa_end_transaction}.
	 * @param ctx the parse tree
	 */
	void exitXa_end_transaction(MySqlParser.Xa_end_transactionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xa_prepare}.
	 * @param ctx the parse tree
	 */
	void enterXa_prepare(MySqlParser.Xa_prepareContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xa_prepare}.
	 * @param ctx the parse tree
	 */
	void exitXa_prepare(MySqlParser.Xa_prepareContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xa_commit_work}.
	 * @param ctx the parse tree
	 */
	void enterXa_commit_work(MySqlParser.Xa_commit_workContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xa_commit_work}.
	 * @param ctx the parse tree
	 */
	void exitXa_commit_work(MySqlParser.Xa_commit_workContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xa_rollback_work}.
	 * @param ctx the parse tree
	 */
	void enterXa_rollback_work(MySqlParser.Xa_rollback_workContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xa_rollback_work}.
	 * @param ctx the parse tree
	 */
	void exitXa_rollback_work(MySqlParser.Xa_rollback_workContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xa_recover_work}.
	 * @param ctx the parse tree
	 */
	void enterXa_recover_work(MySqlParser.Xa_recover_workContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xa_recover_work}.
	 * @param ctx the parse tree
	 */
	void exitXa_recover_work(MySqlParser.Xa_recover_workContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#prepare_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrepare_statement(MySqlParser.Prepare_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#prepare_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrepare_statement(MySqlParser.Prepare_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#execute_statement}.
	 * @param ctx the parse tree
	 */
	void enterExecute_statement(MySqlParser.Execute_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#execute_statement}.
	 * @param ctx the parse tree
	 */
	void exitExecute_statement(MySqlParser.Execute_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#deallocate_prepare}.
	 * @param ctx the parse tree
	 */
	void enterDeallocate_prepare(MySqlParser.Deallocate_prepareContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#deallocate_prepare}.
	 * @param ctx the parse tree
	 */
	void exitDeallocate_prepare(MySqlParser.Deallocate_prepareContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#routine_body}.
	 * @param ctx the parse tree
	 */
	void enterRoutine_body(MySqlParser.Routine_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#routine_body}.
	 * @param ctx the parse tree
	 */
	void exitRoutine_body(MySqlParser.Routine_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(MySqlParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(MySqlParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#case_statement}.
	 * @param ctx the parse tree
	 */
	void enterCase_statement(MySqlParser.Case_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#case_statement}.
	 * @param ctx the parse tree
	 */
	void exitCase_statement(MySqlParser.Case_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MySqlParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MySqlParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#iterate_statement}.
	 * @param ctx the parse tree
	 */
	void enterIterate_statement(MySqlParser.Iterate_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#iterate_statement}.
	 * @param ctx the parse tree
	 */
	void exitIterate_statement(MySqlParser.Iterate_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#leave_statement}.
	 * @param ctx the parse tree
	 */
	void enterLeave_statement(MySqlParser.Leave_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#leave_statement}.
	 * @param ctx the parse tree
	 */
	void exitLeave_statement(MySqlParser.Leave_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(MySqlParser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(MySqlParser.Loop_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#repeat_statement}.
	 * @param ctx the parse tree
	 */
	void enterRepeat_statement(MySqlParser.Repeat_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#repeat_statement}.
	 * @param ctx the parse tree
	 */
	void exitRepeat_statement(MySqlParser.Repeat_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(MySqlParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(MySqlParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(MySqlParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(MySqlParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#cursor_statement}.
	 * @param ctx the parse tree
	 */
	void enterCursor_statement(MySqlParser.Cursor_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#cursor_statement}.
	 * @param ctx the parse tree
	 */
	void exitCursor_statement(MySqlParser.Cursor_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declare_variable}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_variable(MySqlParser.Declare_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declare_variable}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_variable(MySqlParser.Declare_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declare_condition}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_condition(MySqlParser.Declare_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declare_condition}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_condition(MySqlParser.Declare_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declare_cursor}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_cursor(MySqlParser.Declare_cursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declare_cursor}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_cursor(MySqlParser.Declare_cursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declare_handler}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_handler(MySqlParser.Declare_handlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declare_handler}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_handler(MySqlParser.Declare_handlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#handler_condition_value}.
	 * @param ctx the parse tree
	 */
	void enterHandler_condition_value(MySqlParser.Handler_condition_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#handler_condition_value}.
	 * @param ctx the parse tree
	 */
	void exitHandler_condition_value(MySqlParser.Handler_condition_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#procedure_sql_statement}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_sql_statement(MySqlParser.Procedure_sql_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#procedure_sql_statement}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_sql_statement(MySqlParser.Procedure_sql_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alterUserMysql56}
	 * labeled alternative in {@link MySqlParser#alter_user}.
	 * @param ctx the parse tree
	 */
	void enterAlterUserMysql56(MySqlParser.AlterUserMysql56Context ctx);
	/**
	 * Exit a parse tree produced by the {@code alterUserMysql56}
	 * labeled alternative in {@link MySqlParser#alter_user}.
	 * @param ctx the parse tree
	 */
	void exitAlterUserMysql56(MySqlParser.AlterUserMysql56Context ctx);
	/**
	 * Enter a parse tree produced by the {@code alterUserMysql57}
	 * labeled alternative in {@link MySqlParser#alter_user}.
	 * @param ctx the parse tree
	 */
	void enterAlterUserMysql57(MySqlParser.AlterUserMysql57Context ctx);
	/**
	 * Exit a parse tree produced by the {@code alterUserMysql57}
	 * labeled alternative in {@link MySqlParser#alter_user}.
	 * @param ctx the parse tree
	 */
	void exitAlterUserMysql57(MySqlParser.AlterUserMysql57Context ctx);
	/**
	 * Enter a parse tree produced by the {@code createUserMysql56}
	 * labeled alternative in {@link MySqlParser#create_user}.
	 * @param ctx the parse tree
	 */
	void enterCreateUserMysql56(MySqlParser.CreateUserMysql56Context ctx);
	/**
	 * Exit a parse tree produced by the {@code createUserMysql56}
	 * labeled alternative in {@link MySqlParser#create_user}.
	 * @param ctx the parse tree
	 */
	void exitCreateUserMysql56(MySqlParser.CreateUserMysql56Context ctx);
	/**
	 * Enter a parse tree produced by the {@code createUserMysql57}
	 * labeled alternative in {@link MySqlParser#create_user}.
	 * @param ctx the parse tree
	 */
	void enterCreateUserMysql57(MySqlParser.CreateUserMysql57Context ctx);
	/**
	 * Exit a parse tree produced by the {@code createUserMysql57}
	 * labeled alternative in {@link MySqlParser#create_user}.
	 * @param ctx the parse tree
	 */
	void exitCreateUserMysql57(MySqlParser.CreateUserMysql57Context ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#drop_user}.
	 * @param ctx the parse tree
	 */
	void enterDrop_user(MySqlParser.Drop_userContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#drop_user}.
	 * @param ctx the parse tree
	 */
	void exitDrop_user(MySqlParser.Drop_userContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#grant_statement}.
	 * @param ctx the parse tree
	 */
	void enterGrant_statement(MySqlParser.Grant_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#grant_statement}.
	 * @param ctx the parse tree
	 */
	void exitGrant_statement(MySqlParser.Grant_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#grant_proxy}.
	 * @param ctx the parse tree
	 */
	void enterGrant_proxy(MySqlParser.Grant_proxyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#grant_proxy}.
	 * @param ctx the parse tree
	 */
	void exitGrant_proxy(MySqlParser.Grant_proxyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#rename_user}.
	 * @param ctx the parse tree
	 */
	void enterRename_user(MySqlParser.Rename_userContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#rename_user}.
	 * @param ctx the parse tree
	 */
	void exitRename_user(MySqlParser.Rename_userContext ctx);
	/**
	 * Enter a parse tree produced by the {@code detailRevoke}
	 * labeled alternative in {@link MySqlParser#revoke_statement}.
	 * @param ctx the parse tree
	 */
	void enterDetailRevoke(MySqlParser.DetailRevokeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code detailRevoke}
	 * labeled alternative in {@link MySqlParser#revoke_statement}.
	 * @param ctx the parse tree
	 */
	void exitDetailRevoke(MySqlParser.DetailRevokeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shortRevoke}
	 * labeled alternative in {@link MySqlParser#revoke_statement}.
	 * @param ctx the parse tree
	 */
	void enterShortRevoke(MySqlParser.ShortRevokeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shortRevoke}
	 * labeled alternative in {@link MySqlParser#revoke_statement}.
	 * @param ctx the parse tree
	 */
	void exitShortRevoke(MySqlParser.ShortRevokeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#revoke_proxy}.
	 * @param ctx the parse tree
	 */
	void enterRevoke_proxy(MySqlParser.Revoke_proxyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#revoke_proxy}.
	 * @param ctx the parse tree
	 */
	void exitRevoke_proxy(MySqlParser.Revoke_proxyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#set_password_statement}.
	 * @param ctx the parse tree
	 */
	void enterSet_password_statement(MySqlParser.Set_password_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#set_password_statement}.
	 * @param ctx the parse tree
	 */
	void exitSet_password_statement(MySqlParser.Set_password_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#user_password_option}.
	 * @param ctx the parse tree
	 */
	void enterUser_password_option(MySqlParser.User_password_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#user_password_option}.
	 * @param ctx the parse tree
	 */
	void exitUser_password_option(MySqlParser.User_password_optionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code authByPassword}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 */
	void enterAuthByPassword(MySqlParser.AuthByPasswordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code authByPassword}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 */
	void exitAuthByPassword(MySqlParser.AuthByPasswordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code authByString}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 */
	void enterAuthByString(MySqlParser.AuthByStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code authByString}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 */
	void exitAuthByString(MySqlParser.AuthByStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code authByHash}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 */
	void enterAuthByHash(MySqlParser.AuthByHashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code authByHash}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 */
	void exitAuthByHash(MySqlParser.AuthByHashContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tls_option}.
	 * @param ctx the parse tree
	 */
	void enterTls_option(MySqlParser.Tls_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tls_option}.
	 * @param ctx the parse tree
	 */
	void exitTls_option(MySqlParser.Tls_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#user_resource_option}.
	 * @param ctx the parse tree
	 */
	void enterUser_resource_option(MySqlParser.User_resource_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#user_resource_option}.
	 * @param ctx the parse tree
	 */
	void exitUser_resource_option(MySqlParser.User_resource_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#user_lock_option}.
	 * @param ctx the parse tree
	 */
	void enterUser_lock_option(MySqlParser.User_lock_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#user_lock_option}.
	 * @param ctx the parse tree
	 */
	void exitUser_lock_option(MySqlParser.User_lock_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#privelege_clause}.
	 * @param ctx the parse tree
	 */
	void enterPrivelege_clause(MySqlParser.Privelege_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#privelege_clause}.
	 * @param ctx the parse tree
	 */
	void exitPrivelege_clause(MySqlParser.Privelege_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#privilege}.
	 * @param ctx the parse tree
	 */
	void enterPrivilege(MySqlParser.PrivilegeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#privilege}.
	 * @param ctx the parse tree
	 */
	void exitPrivilege(MySqlParser.PrivilegeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#privilege_level}.
	 * @param ctx the parse tree
	 */
	void enterPrivilege_level(MySqlParser.Privilege_levelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#privilege_level}.
	 * @param ctx the parse tree
	 */
	void exitPrivilege_level(MySqlParser.Privilege_levelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#set_password_option}.
	 * @param ctx the parse tree
	 */
	void enterSet_password_option(MySqlParser.Set_password_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#set_password_option}.
	 * @param ctx the parse tree
	 */
	void exitSet_password_option(MySqlParser.Set_password_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#analyze_table}.
	 * @param ctx the parse tree
	 */
	void enterAnalyze_table(MySqlParser.Analyze_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#analyze_table}.
	 * @param ctx the parse tree
	 */
	void exitAnalyze_table(MySqlParser.Analyze_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#check_table}.
	 * @param ctx the parse tree
	 */
	void enterCheck_table(MySqlParser.Check_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#check_table}.
	 * @param ctx the parse tree
	 */
	void exitCheck_table(MySqlParser.Check_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#checksum_table}.
	 * @param ctx the parse tree
	 */
	void enterChecksum_table(MySqlParser.Checksum_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#checksum_table}.
	 * @param ctx the parse tree
	 */
	void exitChecksum_table(MySqlParser.Checksum_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#optimize_table}.
	 * @param ctx the parse tree
	 */
	void enterOptimize_table(MySqlParser.Optimize_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#optimize_table}.
	 * @param ctx the parse tree
	 */
	void exitOptimize_table(MySqlParser.Optimize_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#repair_table}.
	 * @param ctx the parse tree
	 */
	void enterRepair_table(MySqlParser.Repair_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#repair_table}.
	 * @param ctx the parse tree
	 */
	void exitRepair_table(MySqlParser.Repair_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#check_table_option}.
	 * @param ctx the parse tree
	 */
	void enterCheck_table_option(MySqlParser.Check_table_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#check_table_option}.
	 * @param ctx the parse tree
	 */
	void exitCheck_table_option(MySqlParser.Check_table_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#create_udfunction}.
	 * @param ctx the parse tree
	 */
	void enterCreate_udfunction(MySqlParser.Create_udfunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#create_udfunction}.
	 * @param ctx the parse tree
	 */
	void exitCreate_udfunction(MySqlParser.Create_udfunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#install_plugin}.
	 * @param ctx the parse tree
	 */
	void enterInstall_plugin(MySqlParser.Install_pluginContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#install_plugin}.
	 * @param ctx the parse tree
	 */
	void exitInstall_plugin(MySqlParser.Install_pluginContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#uninstall_plugin}.
	 * @param ctx the parse tree
	 */
	void enterUninstall_plugin(MySqlParser.Uninstall_pluginContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#uninstall_plugin}.
	 * @param ctx the parse tree
	 */
	void exitUninstall_plugin(MySqlParser.Uninstall_pluginContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setVariableAssignment}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSetVariableAssignment(MySqlParser.SetVariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setVariableAssignment}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSetVariableAssignment(MySqlParser.SetVariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setCharset}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSetCharset(MySqlParser.SetCharsetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setCharset}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSetCharset(MySqlParser.SetCharsetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setNames}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSetNames(MySqlParser.SetNamesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setNames}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSetNames(MySqlParser.SetNamesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setPasswordStatement}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSetPasswordStatement(MySqlParser.SetPasswordStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setPasswordStatement}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSetPasswordStatement(MySqlParser.SetPasswordStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setTransaction}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSetTransaction(MySqlParser.SetTransactionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setTransaction}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSetTransaction(MySqlParser.SetTransactionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setAutocommit}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSetAutocommit(MySqlParser.SetAutocommitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setAutocommit}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSetAutocommit(MySqlParser.SetAutocommitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showMasterlogs}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowMasterlogs(MySqlParser.ShowMasterlogsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showMasterlogs}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowMasterlogs(MySqlParser.ShowMasterlogsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showLogevents}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowLogevents(MySqlParser.ShowLogeventsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showLogevents}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowLogevents(MySqlParser.ShowLogeventsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showObjWithFilter}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowObjWithFilter(MySqlParser.ShowObjWithFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showObjWithFilter}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowObjWithFilter(MySqlParser.ShowObjWithFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showColumns}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowColumns(MySqlParser.ShowColumnsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showColumns}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowColumns(MySqlParser.ShowColumnsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showCreateDb}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowCreateDb(MySqlParser.ShowCreateDbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showCreateDb}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowCreateDb(MySqlParser.ShowCreateDbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showCreateFullidobj}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowCreateFullidobj(MySqlParser.ShowCreateFullidobjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showCreateFullidobj}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowCreateFullidobj(MySqlParser.ShowCreateFullidobjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showCreateUser}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowCreateUser(MySqlParser.ShowCreateUserContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showCreateUser}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowCreateUser(MySqlParser.ShowCreateUserContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showEngine}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowEngine(MySqlParser.ShowEngineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showEngine}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowEngine(MySqlParser.ShowEngineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showGlobalinfo}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowGlobalinfo(MySqlParser.ShowGlobalinfoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showGlobalinfo}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowGlobalinfo(MySqlParser.ShowGlobalinfoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showErrWarn}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowErrWarn(MySqlParser.ShowErrWarnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showErrWarn}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowErrWarn(MySqlParser.ShowErrWarnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showCountErrWarn}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowCountErrWarn(MySqlParser.ShowCountErrWarnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showCountErrWarn}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowCountErrWarn(MySqlParser.ShowCountErrWarnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showFromschemaFilter}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowFromschemaFilter(MySqlParser.ShowFromschemaFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showFromschemaFilter}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowFromschemaFilter(MySqlParser.ShowFromschemaFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showRoutinecode}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowRoutinecode(MySqlParser.ShowRoutinecodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showRoutinecode}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowRoutinecode(MySqlParser.ShowRoutinecodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showGrants}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowGrants(MySqlParser.ShowGrantsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showGrants}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowGrants(MySqlParser.ShowGrantsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showIndexes}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowIndexes(MySqlParser.ShowIndexesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showIndexes}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowIndexes(MySqlParser.ShowIndexesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showOpentables}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowOpentables(MySqlParser.ShowOpentablesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showOpentables}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowOpentables(MySqlParser.ShowOpentablesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showProfile}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowProfile(MySqlParser.ShowProfileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showProfile}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowProfile(MySqlParser.ShowProfileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showSlavestatus}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void enterShowSlavestatus(MySqlParser.ShowSlavestatusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showSlavestatus}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 */
	void exitShowSlavestatus(MySqlParser.ShowSlavestatusContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#variable_clause}.
	 * @param ctx the parse tree
	 */
	void enterVariable_clause(MySqlParser.Variable_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#variable_clause}.
	 * @param ctx the parse tree
	 */
	void exitVariable_clause(MySqlParser.Variable_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#show_filter}.
	 * @param ctx the parse tree
	 */
	void enterShow_filter(MySqlParser.Show_filterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#show_filter}.
	 * @param ctx the parse tree
	 */
	void exitShow_filter(MySqlParser.Show_filterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#show_profile_type}.
	 * @param ctx the parse tree
	 */
	void enterShow_profile_type(MySqlParser.Show_profile_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#show_profile_type}.
	 * @param ctx the parse tree
	 */
	void exitShow_profile_type(MySqlParser.Show_profile_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#binlog_statement}.
	 * @param ctx the parse tree
	 */
	void enterBinlog_statement(MySqlParser.Binlog_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#binlog_statement}.
	 * @param ctx the parse tree
	 */
	void exitBinlog_statement(MySqlParser.Binlog_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#cache_index_statement}.
	 * @param ctx the parse tree
	 */
	void enterCache_index_statement(MySqlParser.Cache_index_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#cache_index_statement}.
	 * @param ctx the parse tree
	 */
	void exitCache_index_statement(MySqlParser.Cache_index_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#flush_statement}.
	 * @param ctx the parse tree
	 */
	void enterFlush_statement(MySqlParser.Flush_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#flush_statement}.
	 * @param ctx the parse tree
	 */
	void exitFlush_statement(MySqlParser.Flush_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#kill_statement}.
	 * @param ctx the parse tree
	 */
	void enterKill_statement(MySqlParser.Kill_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#kill_statement}.
	 * @param ctx the parse tree
	 */
	void exitKill_statement(MySqlParser.Kill_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#load_index_into_cache}.
	 * @param ctx the parse tree
	 */
	void enterLoad_index_into_cache(MySqlParser.Load_index_into_cacheContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#load_index_into_cache}.
	 * @param ctx the parse tree
	 */
	void exitLoad_index_into_cache(MySqlParser.Load_index_into_cacheContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#reset_statement}.
	 * @param ctx the parse tree
	 */
	void enterReset_statement(MySqlParser.Reset_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#reset_statement}.
	 * @param ctx the parse tree
	 */
	void exitReset_statement(MySqlParser.Reset_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#shutdown_statement}.
	 * @param ctx the parse tree
	 */
	void enterShutdown_statement(MySqlParser.Shutdown_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#shutdown_statement}.
	 * @param ctx the parse tree
	 */
	void exitShutdown_statement(MySqlParser.Shutdown_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tbl_index_list}.
	 * @param ctx the parse tree
	 */
	void enterTbl_index_list(MySqlParser.Tbl_index_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tbl_index_list}.
	 * @param ctx the parse tree
	 */
	void exitTbl_index_list(MySqlParser.Tbl_index_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#flush_option}.
	 * @param ctx the parse tree
	 */
	void enterFlush_option(MySqlParser.Flush_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#flush_option}.
	 * @param ctx the parse tree
	 */
	void exitFlush_option(MySqlParser.Flush_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#load_tbl_index_list}.
	 * @param ctx the parse tree
	 */
	void enterLoad_tbl_index_list(MySqlParser.Load_tbl_index_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#load_tbl_index_list}.
	 * @param ctx the parse tree
	 */
	void exitLoad_tbl_index_list(MySqlParser.Load_tbl_index_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#simple_describe_statement}.
	 * @param ctx the parse tree
	 */
	void enterSimple_describe_statement(MySqlParser.Simple_describe_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#simple_describe_statement}.
	 * @param ctx the parse tree
	 */
	void exitSimple_describe_statement(MySqlParser.Simple_describe_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#full_describe_statement}.
	 * @param ctx the parse tree
	 */
	void enterFull_describe_statement(MySqlParser.Full_describe_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#full_describe_statement}.
	 * @param ctx the parse tree
	 */
	void exitFull_describe_statement(MySqlParser.Full_describe_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#help_statement}.
	 * @param ctx the parse tree
	 */
	void enterHelp_statement(MySqlParser.Help_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#help_statement}.
	 * @param ctx the parse tree
	 */
	void exitHelp_statement(MySqlParser.Help_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#use_statement}.
	 * @param ctx the parse tree
	 */
	void enterUse_statement(MySqlParser.Use_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#use_statement}.
	 * @param ctx the parse tree
	 */
	void exitUse_statement(MySqlParser.Use_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code descstmtDescObj}
	 * labeled alternative in {@link MySqlParser#describe_object_clause}.
	 * @param ctx the parse tree
	 */
	void enterDescstmtDescObj(MySqlParser.DescstmtDescObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descstmtDescObj}
	 * labeled alternative in {@link MySqlParser#describe_object_clause}.
	 * @param ctx the parse tree
	 */
	void exitDescstmtDescObj(MySqlParser.DescstmtDescObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code connectionDescObj}
	 * labeled alternative in {@link MySqlParser#describe_object_clause}.
	 * @param ctx the parse tree
	 */
	void enterConnectionDescObj(MySqlParser.ConnectionDescObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code connectionDescObj}
	 * labeled alternative in {@link MySqlParser#describe_object_clause}.
	 * @param ctx the parse tree
	 */
	void exitConnectionDescObj(MySqlParser.ConnectionDescObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(MySqlParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(MySqlParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#full_id}.
	 * @param ctx the parse tree
	 */
	void enterFull_id(MySqlParser.Full_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#full_id}.
	 * @param ctx the parse tree
	 */
	void exitFull_id(MySqlParser.Full_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#full_column_name}.
	 * @param ctx the parse tree
	 */
	void enterFull_column_name(MySqlParser.Full_column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#full_column_name}.
	 * @param ctx the parse tree
	 */
	void exitFull_column_name(MySqlParser.Full_column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#index_col_name}.
	 * @param ctx the parse tree
	 */
	void enterIndex_col_name(MySqlParser.Index_col_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#index_col_name}.
	 * @param ctx the parse tree
	 */
	void exitIndex_col_name(MySqlParser.Index_col_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#user_name}.
	 * @param ctx the parse tree
	 */
	void enterUser_name(MySqlParser.User_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#user_name}.
	 * @param ctx the parse tree
	 */
	void exitUser_name(MySqlParser.User_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#mysql_variable}.
	 * @param ctx the parse tree
	 */
	void enterMysql_variable(MySqlParser.Mysql_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#mysql_variable}.
	 * @param ctx the parse tree
	 */
	void exitMysql_variable(MySqlParser.Mysql_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#charset_name}.
	 * @param ctx the parse tree
	 */
	void enterCharset_name(MySqlParser.Charset_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#charset_name}.
	 * @param ctx the parse tree
	 */
	void exitCharset_name(MySqlParser.Charset_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#collation_name}.
	 * @param ctx the parse tree
	 */
	void enterCollation_name(MySqlParser.Collation_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#collation_name}.
	 * @param ctx the parse tree
	 */
	void exitCollation_name(MySqlParser.Collation_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#engine_name}.
	 * @param ctx the parse tree
	 */
	void enterEngine_name(MySqlParser.Engine_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#engine_name}.
	 * @param ctx the parse tree
	 */
	void exitEngine_name(MySqlParser.Engine_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#uuid_set}.
	 * @param ctx the parse tree
	 */
	void enterUuid_set(MySqlParser.Uuid_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#uuid_set}.
	 * @param ctx the parse tree
	 */
	void exitUuid_set(MySqlParser.Uuid_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xid}.
	 * @param ctx the parse tree
	 */
	void enterXid(MySqlParser.XidContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xid}.
	 * @param ctx the parse tree
	 */
	void exitXid(MySqlParser.XidContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#xid_string_id}.
	 * @param ctx the parse tree
	 */
	void enterXid_string_id(MySqlParser.Xid_string_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#xid_string_id}.
	 * @param ctx the parse tree
	 */
	void exitXid_string_id(MySqlParser.Xid_string_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#auth_plugin}.
	 * @param ctx the parse tree
	 */
	void enterAuth_plugin(MySqlParser.Auth_pluginContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#auth_plugin}.
	 * @param ctx the parse tree
	 */
	void exitAuth_plugin(MySqlParser.Auth_pluginContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#id_}.
	 * @param ctx the parse tree
	 */
	void enterId_(MySqlParser.Id_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#id_}.
	 * @param ctx the parse tree
	 */
	void exitId_(MySqlParser.Id_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#simple_id}.
	 * @param ctx the parse tree
	 */
	void enterSimple_id(MySqlParser.Simple_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#simple_id}.
	 * @param ctx the parse tree
	 */
	void exitSimple_id(MySqlParser.Simple_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#dot_ext_id}.
	 * @param ctx the parse tree
	 */
	void enterDot_ext_id(MySqlParser.Dot_ext_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#dot_ext_id}.
	 * @param ctx the parse tree
	 */
	void exitDot_ext_id(MySqlParser.Dot_ext_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#decimal_literal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal_literal(MySqlParser.Decimal_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#decimal_literal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal_literal(MySqlParser.Decimal_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#filesize_literal}.
	 * @param ctx the parse tree
	 */
	void enterFilesize_literal(MySqlParser.Filesize_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#filesize_literal}.
	 * @param ctx the parse tree
	 */
	void exitFilesize_literal(MySqlParser.Filesize_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(MySqlParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(MySqlParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(MySqlParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(MySqlParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#hexadecimal_literal}.
	 * @param ctx the parse tree
	 */
	void enterHexadecimal_literal(MySqlParser.Hexadecimal_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#hexadecimal_literal}.
	 * @param ctx the parse tree
	 */
	void exitHexadecimal_literal(MySqlParser.Hexadecimal_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#null_notnull}.
	 * @param ctx the parse tree
	 */
	void enterNull_notnull(MySqlParser.Null_notnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#null_notnull}.
	 * @param ctx the parse tree
	 */
	void exitNull_notnull(MySqlParser.Null_notnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterCharDatatype(MySqlParser.CharDatatypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitCharDatatype(MySqlParser.CharDatatypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dimensionDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterDimensionDatatype(MySqlParser.DimensionDatatypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dimensionDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitDimensionDatatype(MySqlParser.DimensionDatatypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDatatype(MySqlParser.SimpleDatatypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDatatype(MySqlParser.SimpleDatatypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code collectCharDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterCollectCharDatatype(MySqlParser.CollectCharDatatypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code collectCharDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitCollectCharDatatype(MySqlParser.CollectCharDatatypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code spatialDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterSpatialDatatype(MySqlParser.SpatialDatatypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code spatialDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitSpatialDatatype(MySqlParser.SpatialDatatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#data_type_to_convert}.
	 * @param ctx the parse tree
	 */
	void enterData_type_to_convert(MySqlParser.Data_type_to_convertContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#data_type_to_convert}.
	 * @param ctx the parse tree
	 */
	void exitData_type_to_convert(MySqlParser.Data_type_to_convertContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#spatial_data_type}.
	 * @param ctx the parse tree
	 */
	void enterSpatial_data_type(MySqlParser.Spatial_data_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#spatial_data_type}.
	 * @param ctx the parse tree
	 */
	void exitSpatial_data_type(MySqlParser.Spatial_data_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#length_one_dimension}.
	 * @param ctx the parse tree
	 */
	void enterLength_one_dimension(MySqlParser.Length_one_dimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#length_one_dimension}.
	 * @param ctx the parse tree
	 */
	void exitLength_one_dimension(MySqlParser.Length_one_dimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#length_two_dimension}.
	 * @param ctx the parse tree
	 */
	void enterLength_two_dimension(MySqlParser.Length_two_dimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#length_two_dimension}.
	 * @param ctx the parse tree
	 */
	void exitLength_two_dimension(MySqlParser.Length_two_dimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#length_two_optional_dimension}.
	 * @param ctx the parse tree
	 */
	void enterLength_two_optional_dimension(MySqlParser.Length_two_optional_dimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#length_two_optional_dimension}.
	 * @param ctx the parse tree
	 */
	void exitLength_two_optional_dimension(MySqlParser.Length_two_optional_dimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(MySqlParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(MySqlParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#table_list}.
	 * @param ctx the parse tree
	 */
	void enterTable_list(MySqlParser.Table_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#table_list}.
	 * @param ctx the parse tree
	 */
	void exitTable_list(MySqlParser.Table_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#table_pair_list}.
	 * @param ctx the parse tree
	 */
	void enterTable_pair_list(MySqlParser.Table_pair_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#table_pair_list}.
	 * @param ctx the parse tree
	 */
	void exitTable_pair_list(MySqlParser.Table_pair_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#index_colname_list}.
	 * @param ctx the parse tree
	 */
	void enterIndex_colname_list(MySqlParser.Index_colname_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#index_colname_list}.
	 * @param ctx the parse tree
	 */
	void exitIndex_colname_list(MySqlParser.Index_colname_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(MySqlParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(MySqlParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#constant_list}.
	 * @param ctx the parse tree
	 */
	void enterConstant_list(MySqlParser.Constant_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#constant_list}.
	 * @param ctx the parse tree
	 */
	void exitConstant_list(MySqlParser.Constant_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#simple_string_list}.
	 * @param ctx the parse tree
	 */
	void enterSimple_string_list(MySqlParser.Simple_string_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#simple_string_list}.
	 * @param ctx the parse tree
	 */
	void exitSimple_string_list(MySqlParser.Simple_string_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#user_var_list}.
	 * @param ctx the parse tree
	 */
	void enterUser_var_list(MySqlParser.User_var_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#user_var_list}.
	 * @param ctx the parse tree
	 */
	void exitUser_var_list(MySqlParser.User_var_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#default_value}.
	 * @param ctx the parse tree
	 */
	void enterDefault_value(MySqlParser.Default_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#default_value}.
	 * @param ctx the parse tree
	 */
	void exitDefault_value(MySqlParser.Default_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#if_exists}.
	 * @param ctx the parse tree
	 */
	void enterIf_exists(MySqlParser.If_existsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#if_exists}.
	 * @param ctx the parse tree
	 */
	void exitIf_exists(MySqlParser.If_existsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#if_not_exists}.
	 * @param ctx the parse tree
	 */
	void enterIf_not_exists(MySqlParser.If_not_existsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#if_not_exists}.
	 * @param ctx the parse tree
	 */
	void exitIf_not_exists(MySqlParser.If_not_existsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specificFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specificFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggregateFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggregateFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scalarFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scalarFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code udfFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code udfFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleSpecificFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSpecificFCall(MySqlParser.SimpleSpecificFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleSpecificFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSpecificFCall(MySqlParser.SimpleSpecificFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code convertDataTypeFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterConvertDataTypeFCall(MySqlParser.ConvertDataTypeFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code convertDataTypeFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitConvertDataTypeFCall(MySqlParser.ConvertDataTypeFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valuesFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterValuesFCall(MySqlParser.ValuesFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valuesFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitValuesFCall(MySqlParser.ValuesFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caseFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterCaseFCall(MySqlParser.CaseFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caseFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitCaseFCall(MySqlParser.CaseFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterCharFCall(MySqlParser.CharFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitCharFCall(MySqlParser.CharFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code positionFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterPositionFCall(MySqlParser.PositionFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positionFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitPositionFCall(MySqlParser.PositionFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code substrFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterSubstrFCall(MySqlParser.SubstrFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code substrFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitSubstrFCall(MySqlParser.SubstrFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trimFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterTrimFCall(MySqlParser.TrimFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trimFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitTrimFCall(MySqlParser.TrimFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code weightFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterWeightFCall(MySqlParser.WeightFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code weightFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitWeightFCall(MySqlParser.WeightFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extractFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterExtractFCall(MySqlParser.ExtractFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extractFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitExtractFCall(MySqlParser.ExtractFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getFormatFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void enterGetFormatFCall(MySqlParser.GetFormatFCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getFormatFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 */
	void exitGetFormatFCall(MySqlParser.GetFormatFCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code levelWeightFList}
	 * labeled alternative in {@link MySqlParser#levels_in_weight_string}.
	 * @param ctx the parse tree
	 */
	void enterLevelWeightFList(MySqlParser.LevelWeightFListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code levelWeightFList}
	 * labeled alternative in {@link MySqlParser#levels_in_weight_string}.
	 * @param ctx the parse tree
	 */
	void exitLevelWeightFList(MySqlParser.LevelWeightFListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code levelWeightFRange}
	 * labeled alternative in {@link MySqlParser#levels_in_weight_string}.
	 * @param ctx the parse tree
	 */
	void enterLevelWeightFRange(MySqlParser.LevelWeightFRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code levelWeightFRange}
	 * labeled alternative in {@link MySqlParser#levels_in_weight_string}.
	 * @param ctx the parse tree
	 */
	void exitLevelWeightFRange(MySqlParser.LevelWeightFRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 */
	void enterAggregate_windowed_function(MySqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 */
	void exitAggregate_windowed_function(MySqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#scalar_function_name}.
	 * @param ctx the parse tree
	 */
	void enterScalar_function_name(MySqlParser.Scalar_function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#scalar_function_name}.
	 * @param ctx the parse tree
	 */
	void exitScalar_function_name(MySqlParser.Scalar_function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#function_args}.
	 * @param ctx the parse tree
	 */
	void enterFunction_args(MySqlParser.Function_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#function_args}.
	 * @param ctx the parse tree
	 */
	void exitFunction_args(MySqlParser.Function_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#function_arg}.
	 * @param ctx the parse tree
	 */
	void enterFunction_arg(MySqlParser.Function_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#function_arg}.
	 * @param ctx the parse tree
	 */
	void exitFunction_arg(MySqlParser.Function_argContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsExpression(MySqlParser.IsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsExpression(MySqlParser.IsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(MySqlParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(MySqlParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(MySqlParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(MySqlParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExpression(MySqlParser.PredicateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExpression(MySqlParser.PredicateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code soundsLikePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code soundsLikePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAtomPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAtomPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterInPredicate(MySqlParser.InPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitInPredicate(MySqlParser.InPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryComparasionPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryComparasionPredicate(MySqlParser.SubqueryComparasionPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryComparasionPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryComparasionPredicate(MySqlParser.SubqueryComparasionPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code betweenPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterBetweenPredicate(MySqlParser.BetweenPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code betweenPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitBetweenPredicate(MySqlParser.BetweenPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryComparasionPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterBinaryComparasionPredicate(MySqlParser.BinaryComparasionPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryComparasionPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitBinaryComparasionPredicate(MySqlParser.BinaryComparasionPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isNullPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterIsNullPredicate(MySqlParser.IsNullPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isNullPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitIsNullPredicate(MySqlParser.IsNullPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code likePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterLikePredicate(MySqlParser.LikePredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code likePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitLikePredicate(MySqlParser.LikePredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regexpPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterRegexpPredicate(MySqlParser.RegexpPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regexpPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitRegexpPredicate(MySqlParser.RegexpPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code existsExpessionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpessionAtom(MySqlParser.ExistsExpessionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code existsExpessionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpessionAtom(MySqlParser.ExistsExpessionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mysqlVariableExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mysqlVariableExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullColumnNameExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullColumnNameExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterDefaultExpressionAtom(MySqlParser.DefaultExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitDefaultExpressionAtom(MySqlParser.DefaultExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void enterIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 */
	void exitIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(MySqlParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(MySqlParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operator(MySqlParser.Comparison_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operator(MySqlParser.Comparison_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#logical_operator}.
	 * @param ctx the parse tree
	 */
	void enterLogical_operator(MySqlParser.Logical_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#logical_operator}.
	 * @param ctx the parse tree
	 */
	void exitLogical_operator(MySqlParser.Logical_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#bit_operator}.
	 * @param ctx the parse tree
	 */
	void enterBit_operator(MySqlParser.Bit_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#bit_operator}.
	 * @param ctx the parse tree
	 */
	void exitBit_operator(MySqlParser.Bit_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#math_operator}.
	 * @param ctx the parse tree
	 */
	void enterMath_operator(MySqlParser.Math_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#math_operator}.
	 * @param ctx the parse tree
	 */
	void exitMath_operator(MySqlParser.Math_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#charset_name_base}.
	 * @param ctx the parse tree
	 */
	void enterCharset_name_base(MySqlParser.Charset_name_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#charset_name_base}.
	 * @param ctx the parse tree
	 */
	void exitCharset_name_base(MySqlParser.Charset_name_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#transaction_level_base}.
	 * @param ctx the parse tree
	 */
	void enterTransaction_level_base(MySqlParser.Transaction_level_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#transaction_level_base}.
	 * @param ctx the parse tree
	 */
	void exitTransaction_level_base(MySqlParser.Transaction_level_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#privileges_base}.
	 * @param ctx the parse tree
	 */
	void enterPrivileges_base(MySqlParser.Privileges_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#privileges_base}.
	 * @param ctx the parse tree
	 */
	void exitPrivileges_base(MySqlParser.Privileges_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#interval_type_base}.
	 * @param ctx the parse tree
	 */
	void enterInterval_type_base(MySqlParser.Interval_type_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#interval_type_base}.
	 * @param ctx the parse tree
	 */
	void exitInterval_type_base(MySqlParser.Interval_type_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#data_type_base}.
	 * @param ctx the parse tree
	 */
	void enterData_type_base(MySqlParser.Data_type_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#data_type_base}.
	 * @param ctx the parse tree
	 */
	void exitData_type_base(MySqlParser.Data_type_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#keywords_can_be_id}.
	 * @param ctx the parse tree
	 */
	void enterKeywords_can_be_id(MySqlParser.Keywords_can_be_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#keywords_can_be_id}.
	 * @param ctx the parse tree
	 */
	void exitKeywords_can_be_id(MySqlParser.Keywords_can_be_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#function_name_base}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name_base(MySqlParser.Function_name_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#function_name_base}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name_base(MySqlParser.Function_name_baseContext ctx);
}