// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/mysql/parser/MySqlParser.g4 by ANTLR 4.7
package com.generator.generators.mysql.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MySqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MySqlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MySqlParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(MySqlParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#sql_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_statements(MySqlParser.Sql_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#sql_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_statement(MySqlParser.Sql_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#empty_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_statement(MySqlParser.Empty_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#ddl_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdl_statement(MySqlParser.Ddl_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#dml_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDml_statement(MySqlParser.Dml_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#transaction_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransaction_statement(MySqlParser.Transaction_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#replication_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplication_statement(MySqlParser.Replication_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#prepared_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrepared_statement(MySqlParser.Prepared_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement(MySqlParser.Compound_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#administration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdministration_statement(MySqlParser.Administration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#utility_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtility_statement(MySqlParser.Utility_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_database(MySqlParser.Create_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_event(MySqlParser.Create_eventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_index(MySqlParser.Create_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_logfile_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_logfile_group(MySqlParser.Create_logfile_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_procedure(MySqlParser.Create_procedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_function(MySqlParser.Create_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_server(MySqlParser.Create_serverContext ctx);
	/**
	 * Visit a parse tree produced by the {@code copyCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyCreateTable(MySqlParser.CopyCreateTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code queryCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryCreateTable(MySqlParser.QueryCreateTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colCreateTable}
	 * labeled alternative in {@link MySqlParser#create_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColCreateTable(MySqlParser.ColCreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_tablespace_innodb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_tablespace_innodb(MySqlParser.Create_tablespace_innodbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_tablespace_ndb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_tablespace_ndb(MySqlParser.Create_tablespace_ndbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_trigger(MySqlParser.Create_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_view(MySqlParser.Create_viewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_database_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_database_option(MySqlParser.Create_database_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#owner_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOwner_statement(MySqlParser.Owner_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preciseSchedule}
	 * labeled alternative in {@link MySqlParser#schedule_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreciseSchedule(MySqlParser.PreciseScheduleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalSchedule}
	 * labeled alternative in {@link MySqlParser#schedule_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalSchedule(MySqlParser.IntervalScheduleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#timestamp_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestamp_value(MySqlParser.Timestamp_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#interval_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval_expr(MySqlParser.Interval_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#interval_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval_type(MySqlParser.Interval_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#index_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_type(MySqlParser.Index_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#index_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_option(MySqlParser.Index_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#proc_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_param(MySqlParser.Proc_paramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#func_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_param(MySqlParser.Func_paramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rcComment}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRcComment(MySqlParser.RcCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rcSqllang}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRcSqllang(MySqlParser.RcSqllangContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rcDeterm}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRcDeterm(MySqlParser.RcDetermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rcSqldata}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRcSqldata(MySqlParser.RcSqldataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rcSecurestmt}
	 * labeled alternative in {@link MySqlParser#routine_characteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRcSecurestmt(MySqlParser.RcSecurestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#server_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServer_option(MySqlParser.Server_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#column_def_table_constraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_def_table_constraints(MySqlParser.Column_def_table_constraintsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(MySqlParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintDefinition(MySqlParser.ConstraintDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexDefinition}
	 * labeled alternative in {@link MySqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexDefinition(MySqlParser.IndexDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#column_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_definition(MySqlParser.Column_definitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrNull}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrNull(MySqlParser.ColConstrNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrDflt}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrDflt(MySqlParser.ColConstrDfltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrAuInc}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrAuInc(MySqlParser.ColConstrAuIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrPK}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrPK(MySqlParser.ColConstrPKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrUK}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrUK(MySqlParser.ColConstrUKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrComment}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrComment(MySqlParser.ColConstrCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrForm}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrForm(MySqlParser.ColConstrFormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrStorage}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrStorage(MySqlParser.ColConstrStorageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colConstrRefdef}
	 * labeled alternative in {@link MySqlParser#separate_column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstrRefdef(MySqlParser.ColConstrRefdefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblConstrPK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblConstrPK(MySqlParser.TblConstrPKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblConstrUK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblConstrUK(MySqlParser.TblConstrUKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblConstrFK}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblConstrFK(MySqlParser.TblConstrFKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblConstCheck}
	 * labeled alternative in {@link MySqlParser#table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblConstCheck(MySqlParser.TblConstCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#reference_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference_definition(MySqlParser.Reference_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#on_delete_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn_delete_action(MySqlParser.On_delete_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#on_update_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn_update_action(MySqlParser.On_update_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#reference_action_control_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference_action_control_type(MySqlParser.Reference_action_control_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleIndex}
	 * labeled alternative in {@link MySqlParser#index_column_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIndex(MySqlParser.SimpleIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code specIndex}
	 * labeled alternative in {@link MySqlParser#index_column_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecIndex(MySqlParser.SpecIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptEngine}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptEngine(MySqlParser.TblOptEngineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptAuInc}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptAuInc(MySqlParser.TblOptAuIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptAvgRLen}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptAvgRLen(MySqlParser.TblOptAvgRLenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptDefCharSet}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptDefCharSet(MySqlParser.TblOptDefCharSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptChkSum}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptChkSum(MySqlParser.TblOptChkSumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptDefCollate}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptDefCollate(MySqlParser.TblOptDefCollateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptComment}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptComment(MySqlParser.TblOptCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptCompr}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptCompr(MySqlParser.TblOptComprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptConn}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptConn(MySqlParser.TblOptConnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptDataDir}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptDataDir(MySqlParser.TblOptDataDirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptDelKW}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptDelKW(MySqlParser.TblOptDelKWContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptEncr}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptEncr(MySqlParser.TblOptEncrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptIndexDir}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptIndexDir(MySqlParser.TblOptIndexDirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptInsMeth}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptInsMeth(MySqlParser.TblOptInsMethContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptKeyBlockSz}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptKeyBlockSz(MySqlParser.TblOptKeyBlockSzContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptMaxRows}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptMaxRows(MySqlParser.TblOptMaxRowsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptMinRows}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptMinRows(MySqlParser.TblOptMinRowsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptPackK}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptPackK(MySqlParser.TblOptPackKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptPasswd}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptPasswd(MySqlParser.TblOptPasswdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptRowFormat}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptRowFormat(MySqlParser.TblOptRowFormatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptStatAutoR}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptStatAutoR(MySqlParser.TblOptStatAutoRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptStatPersist}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptStatPersist(MySqlParser.TblOptStatPersistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptStatSamplPg}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptStatSamplPg(MySqlParser.TblOptStatSamplPgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptTablespace}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptTablespace(MySqlParser.TblOptTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tblOptUnion}
	 * labeled alternative in {@link MySqlParser#table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTblOptUnion(MySqlParser.TblOptUnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#partition_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_options(MySqlParser.Partition_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#partition_function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_function_definition(MySqlParser.Partition_function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#linear_partition_func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinear_partition_func_def(MySqlParser.Linear_partition_func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#partition_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_def(MySqlParser.Partition_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#subpartition_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartition_def(MySqlParser.Subpartition_defContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterDb}
	 * labeled alternative in {@link MySqlParser#alter_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDb(MySqlParser.AlterDbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterDbUpgradeName}
	 * labeled alternative in {@link MySqlParser#alter_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDbUpgradeName(MySqlParser.AlterDbUpgradeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_event(MySqlParser.Alter_eventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_function(MySqlParser.Alter_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_instance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_instance(MySqlParser.Alter_instanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_logfile_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_logfile_group(MySqlParser.Alter_logfile_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_procedure(MySqlParser.Alter_procedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_server(MySqlParser.Alter_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_table(MySqlParser.Alter_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_tablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_tablespace(MySqlParser.Alter_tablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#alter_view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_view(MySqlParser.Alter_viewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblTableOpt}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblTableOpt(MySqlParser.AltblTableOptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddCol}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddCol(MySqlParser.AltblAddColContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddCols}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddCols(MySqlParser.AltblAddColsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddIndex(MySqlParser.AltblAddIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddPK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddPK(MySqlParser.AltblAddPKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddUK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddUK(MySqlParser.AltblAddUKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddSpecIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddSpecIndex(MySqlParser.AltblAddSpecIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddFK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddFK(MySqlParser.AltblAddFKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAlg}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAlg(MySqlParser.AltblAlgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblColDef}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblColDef(MySqlParser.AltblColDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblColChange}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblColChange(MySqlParser.AltblColChangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblLock}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblLock(MySqlParser.AltblLockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblColMod}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblColMod(MySqlParser.AltblColModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblColDrop}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblColDrop(MySqlParser.AltblColDropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDropPK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDropPK(MySqlParser.AltblDropPKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDropIndex}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDropIndex(MySqlParser.AltblDropIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDropFK}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDropFK(MySqlParser.AltblDropFKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDisKey}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDisKey(MySqlParser.AltblDisKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblEnKey}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblEnKey(MySqlParser.AltblEnKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblRenameTbl}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblRenameTbl(MySqlParser.AltblRenameTblContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblResort}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblResort(MySqlParser.AltblResortContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblConvert}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblConvert(MySqlParser.AltblConvertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDefCharset}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDefCharset(MySqlParser.AltblDefCharsetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDisTblspace}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDisTblspace(MySqlParser.AltblDisTblspaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblImpTblSpace}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblImpTblSpace(MySqlParser.AltblImpTblSpaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblForce}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblForce(MySqlParser.AltblForceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblValid}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblValid(MySqlParser.AltblValidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAddPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAddPart(MySqlParser.AltblAddPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDropPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDropPart(MySqlParser.AltblDropPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblDiscartPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblDiscartPart(MySqlParser.AltblDiscartPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblImportPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblImportPart(MySqlParser.AltblImportPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblTruncPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblTruncPart(MySqlParser.AltblTruncPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblCoalPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblCoalPart(MySqlParser.AltblCoalPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblReorgPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblReorgPart(MySqlParser.AltblReorgPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblExchPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblExchPart(MySqlParser.AltblExchPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblAnalPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblAnalPart(MySqlParser.AltblAnalPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblCheckPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblCheckPart(MySqlParser.AltblCheckPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblOptimPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblOptimPart(MySqlParser.AltblOptimPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblRebuildPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblRebuildPart(MySqlParser.AltblRebuildPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblRepairPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblRepairPart(MySqlParser.AltblRepairPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblRemovePart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblRemovePart(MySqlParser.AltblRemovePartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code altblUpgrPart}
	 * labeled alternative in {@link MySqlParser#alter_table_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltblUpgrPart(MySqlParser.AltblUpgrPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_database(MySqlParser.Drop_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_event(MySqlParser.Drop_eventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_index(MySqlParser.Drop_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_logfile_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_logfile_group(MySqlParser.Drop_logfile_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_procedure(MySqlParser.Drop_procedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_function(MySqlParser.Drop_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_server(MySqlParser.Drop_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_table(MySqlParser.Drop_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_tablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_tablespace(MySqlParser.Drop_tablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_trigger(MySqlParser.Drop_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_view(MySqlParser.Drop_viewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#rename_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRename_table(MySqlParser.Rename_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#truncate_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncate_table(MySqlParser.Truncate_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#call_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_statement(MySqlParser.Call_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#delete_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_statement(MySqlParser.Delete_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#do_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_statement(MySqlParser.Do_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#handler_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler_statement(MySqlParser.Handler_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#insert_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_statement(MySqlParser.Insert_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#load_data_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad_data_statement(MySqlParser.Load_data_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#load_xml_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad_xml_statement(MySqlParser.Load_xml_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#replace_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplace_statement(MySqlParser.Replace_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleSelect(MySqlParser.SimpleSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenSelect(MySqlParser.ParenSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unionSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionSelect(MySqlParser.UnionSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unionParenSelect}
	 * labeled alternative in {@link MySqlParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionParenSelect(MySqlParser.UnionParenSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#update_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_statement(MySqlParser.Update_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#insert_statement_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_statement_value(MySqlParser.Insert_statement_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#update_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_elem(MySqlParser.Update_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#col_or_uservar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol_or_uservar(MySqlParser.Col_or_uservarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#single_delete_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_delete_statement(MySqlParser.Single_delete_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#multiple_delete_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_delete_statement(MySqlParser.Multiple_delete_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#handler_open_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler_open_statement(MySqlParser.Handler_open_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#handler_read_index_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler_read_index_statement(MySqlParser.Handler_read_index_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#handler_read_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler_read_statement(MySqlParser.Handler_read_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#handler_close_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler_close_statement(MySqlParser.Handler_close_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#single_update_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_update_statement(MySqlParser.Single_update_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#multiple_update_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_update_statement(MySqlParser.Multiple_update_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_clause(MySqlParser.Order_by_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_expression(MySqlParser.Order_by_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#table_sources}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_sources(MySqlParser.Table_sourcesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#table_source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_source(MySqlParser.Table_sourceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomTableItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomTableItem(MySqlParser.AtomTableItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subqueryTableItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableSourcesItem}
	 * labeled alternative in {@link MySqlParser#table_source_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSourcesItem(MySqlParser.TableSourcesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#index_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_hint(MySqlParser.Index_hintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerJoin(MySqlParser.InnerJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code straightJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStraightJoin(MySqlParser.StraightJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outerJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuterJoin(MySqlParser.OuterJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link MySqlParser#join_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalJoin(MySqlParser.NaturalJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(MySqlParser.SubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#query_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_expression(MySqlParser.Query_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#query_expression_nointo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_expression_nointo(MySqlParser.Query_expression_nointoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#query_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_specification(MySqlParser.Query_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#query_specification_nointo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_specification_nointo(MySqlParser.Query_specification_nointoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#union_parenth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_parenth(MySqlParser.Union_parenthContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#union_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_statement(MySqlParser.Union_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#select_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_spec(MySqlParser.Select_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#select_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_list(MySqlParser.Select_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sellistelAllCol}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSellistelAllCol(MySqlParser.SellistelAllColContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sellistelCol}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSellistelCol(MySqlParser.SellistelColContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sellistelFunc}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSellistelFunc(MySqlParser.SellistelFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sellistelExpr}
	 * labeled alternative in {@link MySqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSellistelExpr(MySqlParser.SellistelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectIntoVars}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoVars(MySqlParser.SelectIntoVarsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectIntoDump}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoDump(MySqlParser.SelectIntoDumpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectIntoOutfile}
	 * labeled alternative in {@link MySqlParser#select_into_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoOutfile(MySqlParser.SelectIntoOutfileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#from_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_clause(MySqlParser.From_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#group_by_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_by_item(MySqlParser.Group_by_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#limit_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit_clause(MySqlParser.Limit_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#start_transaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_transaction(MySqlParser.Start_transactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#begin_work}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin_work(MySqlParser.Begin_workContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#commit_work}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommit_work(MySqlParser.Commit_workContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#rollback_work}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollback_work(MySqlParser.Rollback_workContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#savepoint_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepoint_statement(MySqlParser.Savepoint_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#rollback_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollback_statement(MySqlParser.Rollback_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#release_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelease_statement(MySqlParser.Release_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#lock_tables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLock_tables(MySqlParser.Lock_tablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#unlock_tables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlock_tables(MySqlParser.Unlock_tablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#set_autocommit_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_autocommit_statement(MySqlParser.Set_autocommit_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#set_transaction_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_transaction_statement(MySqlParser.Set_transaction_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#transact_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransact_option(MySqlParser.Transact_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#lock_table_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLock_table_element(MySqlParser.Lock_table_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#trans_characteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrans_characteristic(MySqlParser.Trans_characteristicContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#transaction_level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransaction_level(MySqlParser.Transaction_levelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#change_master}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_master(MySqlParser.Change_masterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#change_repl_filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_repl_filter(MySqlParser.Change_repl_filterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#purge_binary_logs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPurge_binary_logs(MySqlParser.Purge_binary_logsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#reset_master}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReset_master(MySqlParser.Reset_masterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#reset_slave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReset_slave(MySqlParser.Reset_slaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#start_slave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_slave(MySqlParser.Start_slaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#stop_slave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStop_slave(MySqlParser.Stop_slaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#start_group_repl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_group_repl(MySqlParser.Start_group_replContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#stop_group_repl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStop_group_repl(MySqlParser.Stop_group_replContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterOptString}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterOptString(MySqlParser.MasterOptStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterOptDecimal}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterOptDecimal(MySqlParser.MasterOptDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterOptBool}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterOptBool(MySqlParser.MasterOptBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterOptReal}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterOptReal(MySqlParser.MasterOptRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterOptIdList}
	 * labeled alternative in {@link MySqlParser#master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterOptIdList(MySqlParser.MasterOptIdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#string_master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_master_option(MySqlParser.String_master_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#decimal_master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_master_option(MySqlParser.Decimal_master_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#bool_master_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_master_option(MySqlParser.Bool_master_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#channel_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannel_option(MySqlParser.Channel_optionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code replfilterDbList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplfilterDbList(MySqlParser.ReplfilterDbListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code replfilterTableList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplfilterTableList(MySqlParser.ReplfilterTableListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code replfilterStableList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplfilterStableList(MySqlParser.ReplfilterStableListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code replfilterTablepairList}
	 * labeled alternative in {@link MySqlParser#repl_filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplfilterTablepairList(MySqlParser.ReplfilterTablepairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#thread_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThread_type(MySqlParser.Thread_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code untilGtidSset}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilGtidSset(MySqlParser.UntilGtidSsetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code untilMasterLog}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilMasterLog(MySqlParser.UntilMasterLogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code untilRelayLog}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilRelayLog(MySqlParser.UntilRelayLogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code untilSqlGaps}
	 * labeled alternative in {@link MySqlParser#until_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilSqlGaps(MySqlParser.UntilSqlGapsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#start_slave_connection_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_slave_connection_option(MySqlParser.Start_slave_connection_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#gtid_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtid_set(MySqlParser.Gtid_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xa_start_transaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXa_start_transaction(MySqlParser.Xa_start_transactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xa_end_transaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXa_end_transaction(MySqlParser.Xa_end_transactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xa_prepare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXa_prepare(MySqlParser.Xa_prepareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xa_commit_work}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXa_commit_work(MySqlParser.Xa_commit_workContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xa_rollback_work}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXa_rollback_work(MySqlParser.Xa_rollback_workContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xa_recover_work}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXa_recover_work(MySqlParser.Xa_recover_workContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#prepare_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrepare_statement(MySqlParser.Prepare_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#execute_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_statement(MySqlParser.Execute_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#deallocate_prepare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocate_prepare(MySqlParser.Deallocate_prepareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#routine_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutine_body(MySqlParser.Routine_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_statement(MySqlParser.Block_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#case_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_statement(MySqlParser.Case_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(MySqlParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#iterate_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterate_statement(MySqlParser.Iterate_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#leave_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeave_statement(MySqlParser.Leave_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#loop_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_statement(MySqlParser.Loop_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#repeat_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat_statement(MySqlParser.Repeat_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(MySqlParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(MySqlParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#cursor_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursor_statement(MySqlParser.Cursor_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#declare_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_variable(MySqlParser.Declare_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#declare_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_condition(MySqlParser.Declare_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#declare_cursor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_cursor(MySqlParser.Declare_cursorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#declare_handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_handler(MySqlParser.Declare_handlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#handler_condition_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler_condition_value(MySqlParser.Handler_condition_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#procedure_sql_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_sql_statement(MySqlParser.Procedure_sql_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUserMysql56}
	 * labeled alternative in {@link MySqlParser#alter_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserMysql56(MySqlParser.AlterUserMysql56Context ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUserMysql57}
	 * labeled alternative in {@link MySqlParser#alter_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserMysql57(MySqlParser.AlterUserMysql57Context ctx);
	/**
	 * Visit a parse tree produced by the {@code createUserMysql56}
	 * labeled alternative in {@link MySqlParser#create_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserMysql56(MySqlParser.CreateUserMysql56Context ctx);
	/**
	 * Visit a parse tree produced by the {@code createUserMysql57}
	 * labeled alternative in {@link MySqlParser#create_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserMysql57(MySqlParser.CreateUserMysql57Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#drop_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_user(MySqlParser.Drop_userContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#grant_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrant_statement(MySqlParser.Grant_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#grant_proxy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrant_proxy(MySqlParser.Grant_proxyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#rename_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRename_user(MySqlParser.Rename_userContext ctx);
	/**
	 * Visit a parse tree produced by the {@code detailRevoke}
	 * labeled alternative in {@link MySqlParser#revoke_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDetailRevoke(MySqlParser.DetailRevokeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shortRevoke}
	 * labeled alternative in {@link MySqlParser#revoke_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortRevoke(MySqlParser.ShortRevokeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#revoke_proxy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevoke_proxy(MySqlParser.Revoke_proxyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#set_password_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_password_statement(MySqlParser.Set_password_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#user_password_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUser_password_option(MySqlParser.User_password_optionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code authByPassword}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthByPassword(MySqlParser.AuthByPasswordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code authByString}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthByString(MySqlParser.AuthByStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code authByHash}
	 * labeled alternative in {@link MySqlParser#user_auth_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthByHash(MySqlParser.AuthByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#tls_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTls_option(MySqlParser.Tls_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#user_resource_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUser_resource_option(MySqlParser.User_resource_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#user_lock_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUser_lock_option(MySqlParser.User_lock_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#privelege_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivelege_clause(MySqlParser.Privelege_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#privilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilege(MySqlParser.PrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#privilege_level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilege_level(MySqlParser.Privilege_levelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#set_password_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_password_option(MySqlParser.Set_password_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#analyze_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyze_table(MySqlParser.Analyze_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#check_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_table(MySqlParser.Check_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#checksum_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChecksum_table(MySqlParser.Checksum_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#optimize_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptimize_table(MySqlParser.Optimize_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#repair_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepair_table(MySqlParser.Repair_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#check_table_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_table_option(MySqlParser.Check_table_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#create_udfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_udfunction(MySqlParser.Create_udfunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#install_plugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstall_plugin(MySqlParser.Install_pluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#uninstall_plugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninstall_plugin(MySqlParser.Uninstall_pluginContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setVariableAssignment}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVariableAssignment(MySqlParser.SetVariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setCharset}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCharset(MySqlParser.SetCharsetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setNames}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetNames(MySqlParser.SetNamesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setPasswordStatement}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPasswordStatement(MySqlParser.SetPasswordStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setTransaction}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransaction(MySqlParser.SetTransactionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setAutocommit}
	 * labeled alternative in {@link MySqlParser#set_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAutocommit(MySqlParser.SetAutocommitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showMasterlogs}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowMasterlogs(MySqlParser.ShowMasterlogsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showLogevents}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowLogevents(MySqlParser.ShowLogeventsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showObjWithFilter}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowObjWithFilter(MySqlParser.ShowObjWithFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showColumns}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowColumns(MySqlParser.ShowColumnsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreateDb}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateDb(MySqlParser.ShowCreateDbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreateFullidobj}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateFullidobj(MySqlParser.ShowCreateFullidobjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreateUser}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateUser(MySqlParser.ShowCreateUserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showEngine}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowEngine(MySqlParser.ShowEngineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showGlobalinfo}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGlobalinfo(MySqlParser.ShowGlobalinfoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showErrWarn}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowErrWarn(MySqlParser.ShowErrWarnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCountErrWarn}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCountErrWarn(MySqlParser.ShowCountErrWarnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showFromschemaFilter}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFromschemaFilter(MySqlParser.ShowFromschemaFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showRoutinecode}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowRoutinecode(MySqlParser.ShowRoutinecodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showGrants}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGrants(MySqlParser.ShowGrantsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showIndexes}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowIndexes(MySqlParser.ShowIndexesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showOpentables}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowOpentables(MySqlParser.ShowOpentablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showProfile}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfile(MySqlParser.ShowProfileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showSlavestatus}
	 * labeled alternative in {@link MySqlParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSlavestatus(MySqlParser.ShowSlavestatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#variable_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_clause(MySqlParser.Variable_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#show_filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_filter(MySqlParser.Show_filterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#show_profile_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_profile_type(MySqlParser.Show_profile_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#binlog_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinlog_statement(MySqlParser.Binlog_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#cache_index_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCache_index_statement(MySqlParser.Cache_index_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#flush_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlush_statement(MySqlParser.Flush_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#kill_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKill_statement(MySqlParser.Kill_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#load_index_into_cache}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad_index_into_cache(MySqlParser.Load_index_into_cacheContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#reset_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReset_statement(MySqlParser.Reset_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#shutdown_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShutdown_statement(MySqlParser.Shutdown_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#tbl_index_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTbl_index_list(MySqlParser.Tbl_index_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#flush_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlush_option(MySqlParser.Flush_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#load_tbl_index_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad_tbl_index_list(MySqlParser.Load_tbl_index_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#simple_describe_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_describe_statement(MySqlParser.Simple_describe_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#full_describe_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_describe_statement(MySqlParser.Full_describe_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#help_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHelp_statement(MySqlParser.Help_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#use_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse_statement(MySqlParser.Use_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code descstmtDescObj}
	 * labeled alternative in {@link MySqlParser#describe_object_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescstmtDescObj(MySqlParser.DescstmtDescObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code connectionDescObj}
	 * labeled alternative in {@link MySqlParser#describe_object_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectionDescObj(MySqlParser.ConnectionDescObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(MySqlParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#full_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_id(MySqlParser.Full_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#full_column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_column_name(MySqlParser.Full_column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#index_col_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_col_name(MySqlParser.Index_col_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#user_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUser_name(MySqlParser.User_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#mysql_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_variable(MySqlParser.Mysql_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#charset_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharset_name(MySqlParser.Charset_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#collation_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollation_name(MySqlParser.Collation_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#engine_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEngine_name(MySqlParser.Engine_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#uuid_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUuid_set(MySqlParser.Uuid_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXid(MySqlParser.XidContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#xid_string_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXid_string_id(MySqlParser.Xid_string_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#auth_plugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuth_plugin(MySqlParser.Auth_pluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#id_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_(MySqlParser.Id_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#simple_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_id(MySqlParser.Simple_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#dot_ext_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_ext_id(MySqlParser.Dot_ext_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#decimal_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_literal(MySqlParser.Decimal_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#filesize_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilesize_literal(MySqlParser.Filesize_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(MySqlParser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(MySqlParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#hexadecimal_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimal_literal(MySqlParser.Hexadecimal_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#null_notnull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_notnull(MySqlParser.Null_notnullContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDatatype(MySqlParser.CharDatatypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dimensionDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensionDatatype(MySqlParser.DimensionDatatypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDatatype(MySqlParser.SimpleDatatypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code collectCharDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectCharDatatype(MySqlParser.CollectCharDatatypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code spatialDatatype}
	 * labeled alternative in {@link MySqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpatialDatatype(MySqlParser.SpatialDatatypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#data_type_to_convert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type_to_convert(MySqlParser.Data_type_to_convertContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#spatial_data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpatial_data_type(MySqlParser.Spatial_data_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#length_one_dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength_one_dimension(MySqlParser.Length_one_dimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#length_two_dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength_two_dimension(MySqlParser.Length_two_dimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#length_two_optional_dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength_two_optional_dimension(MySqlParser.Length_two_optional_dimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(MySqlParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#table_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_list(MySqlParser.Table_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#table_pair_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_pair_list(MySqlParser.Table_pair_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#index_colname_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_colname_list(MySqlParser.Index_colname_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(MySqlParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#constant_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_list(MySqlParser.Constant_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#simple_string_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_string_list(MySqlParser.Simple_string_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#user_var_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUser_var_list(MySqlParser.User_var_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#default_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault_value(MySqlParser.Default_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#if_exists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_exists(MySqlParser.If_existsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#if_not_exists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_not_exists(MySqlParser.If_not_existsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code specificFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggregateFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scalarFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code udfFunctionCall}
	 * labeled alternative in {@link MySqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleSpecificFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleSpecificFCall(MySqlParser.SimpleSpecificFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code convertDataTypeFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertDataTypeFCall(MySqlParser.ConvertDataTypeFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valuesFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesFCall(MySqlParser.ValuesFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code caseFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseFCall(MySqlParser.CaseFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharFCall(MySqlParser.CharFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positionFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionFCall(MySqlParser.PositionFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substrFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstrFCall(MySqlParser.SubstrFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trimFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFCall(MySqlParser.TrimFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code weightFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightFCall(MySqlParser.WeightFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extractFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractFCall(MySqlParser.ExtractFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getFormatFCall}
	 * labeled alternative in {@link MySqlParser#specific_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetFormatFCall(MySqlParser.GetFormatFCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code levelWeightFList}
	 * labeled alternative in {@link MySqlParser#levels_in_weight_string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelWeightFList(MySqlParser.LevelWeightFListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code levelWeightFRange}
	 * labeled alternative in {@link MySqlParser#levels_in_weight_string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelWeightFRange(MySqlParser.LevelWeightFRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregate_windowed_function(MySqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#scalar_function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalar_function_name(MySqlParser.Scalar_function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#function_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_args(MySqlParser.Function_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#function_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_arg(MySqlParser.Function_argContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsExpression(MySqlParser.IsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(MySqlParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(MySqlParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code predicateExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpression(MySqlParser.PredicateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code soundsLikePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAtomPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInPredicate(MySqlParser.InPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subqueryComparasionPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryComparasionPredicate(MySqlParser.SubqueryComparasionPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenPredicate(MySqlParser.BetweenPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryComparasionPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryComparasionPredicate(MySqlParser.BinaryComparasionPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNullPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullPredicate(MySqlParser.IsNullPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikePredicate(MySqlParser.LikePredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regexpPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexpPredicate(MySqlParser.RegexpPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code existsExpessionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpessionAtom(MySqlParser.ExistsExpessionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mysqlVariableExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullColumnNameExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultExpressionAtom(MySqlParser.DefaultExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nestedExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expression_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(MySqlParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_operator(MySqlParser.Comparison_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#logical_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_operator(MySqlParser.Logical_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#bit_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBit_operator(MySqlParser.Bit_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#math_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_operator(MySqlParser.Math_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#charset_name_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharset_name_base(MySqlParser.Charset_name_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#transaction_level_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransaction_level_base(MySqlParser.Transaction_level_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#privileges_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivileges_base(MySqlParser.Privileges_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#interval_type_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval_type_base(MySqlParser.Interval_type_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#data_type_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type_base(MySqlParser.Data_type_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#keywords_can_be_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywords_can_be_id(MySqlParser.Keywords_can_be_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#function_name_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name_base(MySqlParser.Function_name_baseContext ctx);
}