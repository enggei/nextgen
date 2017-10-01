package com.generator.generators.mysql.parser;

import org.neo4j.graphdb.*;

public abstract class MySqlParserDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "NotExpression")) visitNotExpression(node);
		else if(hasLabel(node, "Root")) visitRoot(node);
		else if(hasLabel(node, "Sql_statements")) visitSql_statements(node);
		else if(hasLabel(node, "Sql_statement")) visitSql_statement(node);
		else if(hasLabel(node, "Empty_statement")) visitEmpty_statement(node);
		else if(hasLabel(node, "Ddl_statement")) visitDdl_statement(node);
		else if(hasLabel(node, "Dml_statement")) visitDml_statement(node);
		else if(hasLabel(node, "Transaction_statement")) visitTransaction_statement(node);
		else if(hasLabel(node, "Replication_statement")) visitReplication_statement(node);
		else if(hasLabel(node, "Prepared_statement")) visitPrepared_statement(node);
		else if(hasLabel(node, "Compound_statement")) visitCompound_statement(node);
		else if(hasLabel(node, "Administration_statement")) visitAdministration_statement(node);
		else if(hasLabel(node, "Utility_statement")) visitUtility_statement(node);
		else if(hasLabel(node, "Create_database")) visitCreate_database(node);
		else if(hasLabel(node, "Create_event")) visitCreate_event(node);
		else if(hasLabel(node, "Create_index")) visitCreate_index(node);
		else if(hasLabel(node, "Create_logfile_group")) visitCreate_logfile_group(node);
		else if(hasLabel(node, "Create_procedure")) visitCreate_procedure(node);
		else if(hasLabel(node, "Create_function")) visitCreate_function(node);
		else if(hasLabel(node, "Create_server")) visitCreate_server(node);
		else if(hasLabel(node, "CopyCreateTable")) visitCopyCreateTable(node);
		else if(hasLabel(node, "QueryCreateTable")) visitQueryCreateTable(node);
		else if(hasLabel(node, "ColCreateTable")) visitColCreateTable(node);
		else if(hasLabel(node, "Create_tablespace_innodb")) visitCreate_tablespace_innodb(node);
		else if(hasLabel(node, "Create_tablespace_ndb")) visitCreate_tablespace_ndb(node);
		else if(hasLabel(node, "Create_trigger")) visitCreate_trigger(node);
		else if(hasLabel(node, "Create_view")) visitCreate_view(node);
		else if(hasLabel(node, "Create_database_option")) visitCreate_database_option(node);
		else if(hasLabel(node, "Owner_statement")) visitOwner_statement(node);
		else if(hasLabel(node, "PreciseSchedule")) visitPreciseSchedule(node);
		else if(hasLabel(node, "IntervalSchedule")) visitIntervalSchedule(node);
		else if(hasLabel(node, "Timestamp_value")) visitTimestamp_value(node);
		else if(hasLabel(node, "Interval_expr")) visitInterval_expr(node);
		else if(hasLabel(node, "Interval_type")) visitInterval_type(node);
		else if(hasLabel(node, "Index_type")) visitIndex_type(node);
		else if(hasLabel(node, "Index_option")) visitIndex_option(node);
		else if(hasLabel(node, "Proc_param")) visitProc_param(node);
		else if(hasLabel(node, "Func_param")) visitFunc_param(node);
		else if(hasLabel(node, "RcComment")) visitRcComment(node);
		else if(hasLabel(node, "RcSqllang")) visitRcSqllang(node);
		else if(hasLabel(node, "RcDeterm")) visitRcDeterm(node);
		else if(hasLabel(node, "RcSqldata")) visitRcSqldata(node);
		else if(hasLabel(node, "RcSecurestmt")) visitRcSecurestmt(node);
		else if(hasLabel(node, "Server_option")) visitServer_option(node);
		else if(hasLabel(node, "Column_def_table_constraints")) visitColumn_def_table_constraints(node);
		else if(hasLabel(node, "ColumnDefinition")) visitColumnDefinition(node);
		else if(hasLabel(node, "ConstraintDefinition")) visitConstraintDefinition(node);
		else if(hasLabel(node, "IndexDefinition")) visitIndexDefinition(node);
		else if(hasLabel(node, "Column_definition")) visitColumn_definition(node);
		else if(hasLabel(node, "ColConstrNull")) visitColConstrNull(node);
		else if(hasLabel(node, "ColConstrDflt")) visitColConstrDflt(node);
		else if(hasLabel(node, "ColConstrAuInc")) visitColConstrAuInc(node);
		else if(hasLabel(node, "ColConstrPK")) visitColConstrPK(node);
		else if(hasLabel(node, "ColConstrUK")) visitColConstrUK(node);
		else if(hasLabel(node, "ColConstrComment")) visitColConstrComment(node);
		else if(hasLabel(node, "ColConstrForm")) visitColConstrForm(node);
		else if(hasLabel(node, "ColConstrStorage")) visitColConstrStorage(node);
		else if(hasLabel(node, "ColConstrRefdef")) visitColConstrRefdef(node);
		else if(hasLabel(node, "TblConstrPK")) visitTblConstrPK(node);
		else if(hasLabel(node, "TblConstrUK")) visitTblConstrUK(node);
		else if(hasLabel(node, "TblConstrFK")) visitTblConstrFK(node);
		else if(hasLabel(node, "TblConstCheck")) visitTblConstCheck(node);
		else if(hasLabel(node, "Reference_definition")) visitReference_definition(node);
		else if(hasLabel(node, "On_delete_action")) visitOn_delete_action(node);
		else if(hasLabel(node, "On_update_action")) visitOn_update_action(node);
		else if(hasLabel(node, "Reference_action_control_type")) visitReference_action_control_type(node);
		else if(hasLabel(node, "SimpleIndex")) visitSimpleIndex(node);
		else if(hasLabel(node, "SpecIndex")) visitSpecIndex(node);
		else if(hasLabel(node, "TblOptEngine")) visitTblOptEngine(node);
		else if(hasLabel(node, "TblOptAuInc")) visitTblOptAuInc(node);
		else if(hasLabel(node, "TblOptAvgRLen")) visitTblOptAvgRLen(node);
		else if(hasLabel(node, "TblOptDefCharSet")) visitTblOptDefCharSet(node);
		else if(hasLabel(node, "TblOptChkSum")) visitTblOptChkSum(node);
		else if(hasLabel(node, "TblOptDefCollate")) visitTblOptDefCollate(node);
		else if(hasLabel(node, "TblOptComment")) visitTblOptComment(node);
		else if(hasLabel(node, "TblOptCompr")) visitTblOptCompr(node);
		else if(hasLabel(node, "TblOptConn")) visitTblOptConn(node);
		else if(hasLabel(node, "TblOptDataDir")) visitTblOptDataDir(node);
		else if(hasLabel(node, "TblOptDelKW")) visitTblOptDelKW(node);
		else if(hasLabel(node, "TblOptEncr")) visitTblOptEncr(node);
		else if(hasLabel(node, "TblOptIndexDir")) visitTblOptIndexDir(node);
		else if(hasLabel(node, "TblOptInsMeth")) visitTblOptInsMeth(node);
		else if(hasLabel(node, "TblOptKeyBlockSz")) visitTblOptKeyBlockSz(node);
		else if(hasLabel(node, "TblOptMaxRows")) visitTblOptMaxRows(node);
		else if(hasLabel(node, "TblOptMinRows")) visitTblOptMinRows(node);
		else if(hasLabel(node, "TblOptPackK")) visitTblOptPackK(node);
		else if(hasLabel(node, "TblOptPasswd")) visitTblOptPasswd(node);
		else if(hasLabel(node, "TblOptRowFormat")) visitTblOptRowFormat(node);
		else if(hasLabel(node, "TblOptStatAutoR")) visitTblOptStatAutoR(node);
		else if(hasLabel(node, "TblOptStatPersist")) visitTblOptStatPersist(node);
		else if(hasLabel(node, "TblOptStatSamplPg")) visitTblOptStatSamplPg(node);
		else if(hasLabel(node, "TblOptTablespace")) visitTblOptTablespace(node);
		else if(hasLabel(node, "TblOptUnion")) visitTblOptUnion(node);
		else if(hasLabel(node, "Partition_options")) visitPartition_options(node);
		else if(hasLabel(node, "Partition_function_definition")) visitPartition_function_definition(node);
		else if(hasLabel(node, "Linear_partition_func_def")) visitLinear_partition_func_def(node);
		else if(hasLabel(node, "Partition_def")) visitPartition_def(node);
		else if(hasLabel(node, "Subpartition_def")) visitSubpartition_def(node);
		else if(hasLabel(node, "AlterDb")) visitAlterDb(node);
		else if(hasLabel(node, "AlterDbUpgradeName")) visitAlterDbUpgradeName(node);
		else if(hasLabel(node, "Alter_event")) visitAlter_event(node);
		else if(hasLabel(node, "Alter_function")) visitAlter_function(node);
		else if(hasLabel(node, "Alter_instance")) visitAlter_instance(node);
		else if(hasLabel(node, "Alter_logfile_group")) visitAlter_logfile_group(node);
		else if(hasLabel(node, "Alter_procedure")) visitAlter_procedure(node);
		else if(hasLabel(node, "Alter_server")) visitAlter_server(node);
		else if(hasLabel(node, "Alter_table")) visitAlter_table(node);
		else if(hasLabel(node, "Alter_tablespace")) visitAlter_tablespace(node);
		else if(hasLabel(node, "Alter_view")) visitAlter_view(node);
		else if(hasLabel(node, "AltblTableOpt")) visitAltblTableOpt(node);
		else if(hasLabel(node, "AltblAddCol")) visitAltblAddCol(node);
		else if(hasLabel(node, "AltblAddCols")) visitAltblAddCols(node);
		else if(hasLabel(node, "AltblAddIndex")) visitAltblAddIndex(node);
		else if(hasLabel(node, "AltblAddPK")) visitAltblAddPK(node);
		else if(hasLabel(node, "AltblAddUK")) visitAltblAddUK(node);
		else if(hasLabel(node, "AltblAddSpecIndex")) visitAltblAddSpecIndex(node);
		else if(hasLabel(node, "AltblAddFK")) visitAltblAddFK(node);
		else if(hasLabel(node, "AltblAlg")) visitAltblAlg(node);
		else if(hasLabel(node, "AltblColDef")) visitAltblColDef(node);
		else if(hasLabel(node, "AltblColChange")) visitAltblColChange(node);
		else if(hasLabel(node, "AltblLock")) visitAltblLock(node);
		else if(hasLabel(node, "AltblColMod")) visitAltblColMod(node);
		else if(hasLabel(node, "AltblColDrop")) visitAltblColDrop(node);
		else if(hasLabel(node, "AltblDropPK")) visitAltblDropPK(node);
		else if(hasLabel(node, "AltblDropIndex")) visitAltblDropIndex(node);
		else if(hasLabel(node, "AltblDropFK")) visitAltblDropFK(node);
		else if(hasLabel(node, "AltblDisKey")) visitAltblDisKey(node);
		else if(hasLabel(node, "AltblEnKey")) visitAltblEnKey(node);
		else if(hasLabel(node, "AltblRenameTbl")) visitAltblRenameTbl(node);
		else if(hasLabel(node, "AltblResort")) visitAltblResort(node);
		else if(hasLabel(node, "AltblConvert")) visitAltblConvert(node);
		else if(hasLabel(node, "AltblDefCharset")) visitAltblDefCharset(node);
		else if(hasLabel(node, "AltblDisTblspace")) visitAltblDisTblspace(node);
		else if(hasLabel(node, "AltblImpTblSpace")) visitAltblImpTblSpace(node);
		else if(hasLabel(node, "AltblForce")) visitAltblForce(node);
		else if(hasLabel(node, "AltblValid")) visitAltblValid(node);
		else if(hasLabel(node, "AltblAddPart")) visitAltblAddPart(node);
		else if(hasLabel(node, "AltblDropPart")) visitAltblDropPart(node);
		else if(hasLabel(node, "AltblDiscartPart")) visitAltblDiscartPart(node);
		else if(hasLabel(node, "AltblImportPart")) visitAltblImportPart(node);
		else if(hasLabel(node, "AltblTruncPart")) visitAltblTruncPart(node);
		else if(hasLabel(node, "AltblCoalPart")) visitAltblCoalPart(node);
		else if(hasLabel(node, "AltblReorgPart")) visitAltblReorgPart(node);
		else if(hasLabel(node, "AltblExchPart")) visitAltblExchPart(node);
		else if(hasLabel(node, "AltblAnalPart")) visitAltblAnalPart(node);
		else if(hasLabel(node, "AltblCheckPart")) visitAltblCheckPart(node);
		else if(hasLabel(node, "AltblOptimPart")) visitAltblOptimPart(node);
		else if(hasLabel(node, "AltblRebuildPart")) visitAltblRebuildPart(node);
		else if(hasLabel(node, "AltblRepairPart")) visitAltblRepairPart(node);
		else if(hasLabel(node, "AltblRemovePart")) visitAltblRemovePart(node);
		else if(hasLabel(node, "AltblUpgrPart")) visitAltblUpgrPart(node);
		else if(hasLabel(node, "Drop_database")) visitDrop_database(node);
		else if(hasLabel(node, "Drop_event")) visitDrop_event(node);
		else if(hasLabel(node, "Drop_index")) visitDrop_index(node);
		else if(hasLabel(node, "Drop_logfile_group")) visitDrop_logfile_group(node);
		else if(hasLabel(node, "Drop_procedure")) visitDrop_procedure(node);
		else if(hasLabel(node, "Drop_function")) visitDrop_function(node);
		else if(hasLabel(node, "Drop_server")) visitDrop_server(node);
		else if(hasLabel(node, "Drop_table")) visitDrop_table(node);
		else if(hasLabel(node, "Drop_tablespace")) visitDrop_tablespace(node);
		else if(hasLabel(node, "Drop_trigger")) visitDrop_trigger(node);
		else if(hasLabel(node, "Drop_view")) visitDrop_view(node);
		else if(hasLabel(node, "Rename_table")) visitRename_table(node);
		else if(hasLabel(node, "Truncate_table")) visitTruncate_table(node);
		else if(hasLabel(node, "Call_statement")) visitCall_statement(node);
		else if(hasLabel(node, "Delete_statement")) visitDelete_statement(node);
		else if(hasLabel(node, "Do_statement")) visitDo_statement(node);
		else if(hasLabel(node, "Handler_statement")) visitHandler_statement(node);
		else if(hasLabel(node, "Insert_statement")) visitInsert_statement(node);
		else if(hasLabel(node, "Load_data_statement")) visitLoad_data_statement(node);
		else if(hasLabel(node, "Load_xml_statement")) visitLoad_xml_statement(node);
		else if(hasLabel(node, "Replace_statement")) visitReplace_statement(node);
		else if(hasLabel(node, "SimpleSelect")) visitSimpleSelect(node);
		else if(hasLabel(node, "ParenSelect")) visitParenSelect(node);
		else if(hasLabel(node, "UnionSelect")) visitUnionSelect(node);
		else if(hasLabel(node, "UnionParenSelect")) visitUnionParenSelect(node);
		else if(hasLabel(node, "Update_statement")) visitUpdate_statement(node);
		else if(hasLabel(node, "Insert_statement_value")) visitInsert_statement_value(node);
		else if(hasLabel(node, "Update_elem")) visitUpdate_elem(node);
		else if(hasLabel(node, "Col_or_uservar")) visitCol_or_uservar(node);
		else if(hasLabel(node, "Single_delete_statement")) visitSingle_delete_statement(node);
		else if(hasLabel(node, "Multiple_delete_statement")) visitMultiple_delete_statement(node);
		else if(hasLabel(node, "Handler_open_statement")) visitHandler_open_statement(node);
		else if(hasLabel(node, "Handler_read_index_statement")) visitHandler_read_index_statement(node);
		else if(hasLabel(node, "Handler_read_statement")) visitHandler_read_statement(node);
		else if(hasLabel(node, "Handler_close_statement")) visitHandler_close_statement(node);
		else if(hasLabel(node, "Single_update_statement")) visitSingle_update_statement(node);
		else if(hasLabel(node, "Multiple_update_statement")) visitMultiple_update_statement(node);
		else if(hasLabel(node, "Order_by_clause")) visitOrder_by_clause(node);
		else if(hasLabel(node, "Order_by_expression")) visitOrder_by_expression(node);
		else if(hasLabel(node, "Table_sources")) visitTable_sources(node);
		else if(hasLabel(node, "Table_source")) visitTable_source(node);
		else if(hasLabel(node, "AtomTableItem")) visitAtomTableItem(node);
		else if(hasLabel(node, "SubqueryTableItem")) visitSubqueryTableItem(node);
		else if(hasLabel(node, "TableSourcesItem")) visitTableSourcesItem(node);
		else if(hasLabel(node, "Index_hint")) visitIndex_hint(node);
		else if(hasLabel(node, "InnerJoin")) visitInnerJoin(node);
		else if(hasLabel(node, "StraightJoin")) visitStraightJoin(node);
		else if(hasLabel(node, "OuterJoin")) visitOuterJoin(node);
		else if(hasLabel(node, "NaturalJoin")) visitNaturalJoin(node);
		else if(hasLabel(node, "Subquery")) visitSubquery(node);
		else if(hasLabel(node, "Query_expression")) visitQuery_expression(node);
		else if(hasLabel(node, "Query_expression_nointo")) visitQuery_expression_nointo(node);
		else if(hasLabel(node, "Query_specification")) visitQuery_specification(node);
		else if(hasLabel(node, "Query_specification_nointo")) visitQuery_specification_nointo(node);
		else if(hasLabel(node, "Union_parenth")) visitUnion_parenth(node);
		else if(hasLabel(node, "Union_statement")) visitUnion_statement(node);
		else if(hasLabel(node, "Select_spec")) visitSelect_spec(node);
		else if(hasLabel(node, "Select_list")) visitSelect_list(node);
		else if(hasLabel(node, "SellistelAllCol")) visitSellistelAllCol(node);
		else if(hasLabel(node, "SellistelCol")) visitSellistelCol(node);
		else if(hasLabel(node, "SellistelFunc")) visitSellistelFunc(node);
		else if(hasLabel(node, "SellistelExpr")) visitSellistelExpr(node);
		else if(hasLabel(node, "SelectIntoVars")) visitSelectIntoVars(node);
		else if(hasLabel(node, "SelectIntoDump")) visitSelectIntoDump(node);
		else if(hasLabel(node, "SelectIntoOutfile")) visitSelectIntoOutfile(node);
		else if(hasLabel(node, "From_clause")) visitFrom_clause(node);
		else if(hasLabel(node, "Group_by_item")) visitGroup_by_item(node);
		else if(hasLabel(node, "Limit_clause")) visitLimit_clause(node);
		else if(hasLabel(node, "Start_transaction")) visitStart_transaction(node);
		else if(hasLabel(node, "Begin_work")) visitBegin_work(node);
		else if(hasLabel(node, "Commit_work")) visitCommit_work(node);
		else if(hasLabel(node, "Rollback_work")) visitRollback_work(node);
		else if(hasLabel(node, "Savepoint_statement")) visitSavepoint_statement(node);
		else if(hasLabel(node, "Rollback_statement")) visitRollback_statement(node);
		else if(hasLabel(node, "Release_statement")) visitRelease_statement(node);
		else if(hasLabel(node, "Lock_tables")) visitLock_tables(node);
		else if(hasLabel(node, "Unlock_tables")) visitUnlock_tables(node);
		else if(hasLabel(node, "Set_autocommit_statement")) visitSet_autocommit_statement(node);
		else if(hasLabel(node, "Set_transaction_statement")) visitSet_transaction_statement(node);
		else if(hasLabel(node, "Transact_option")) visitTransact_option(node);
		else if(hasLabel(node, "Lock_table_element")) visitLock_table_element(node);
		else if(hasLabel(node, "Trans_characteristic")) visitTrans_characteristic(node);
		else if(hasLabel(node, "Transaction_level")) visitTransaction_level(node);
		else if(hasLabel(node, "Change_master")) visitChange_master(node);
		else if(hasLabel(node, "Change_repl_filter")) visitChange_repl_filter(node);
		else if(hasLabel(node, "Purge_binary_logs")) visitPurge_binary_logs(node);
		else if(hasLabel(node, "Reset_master")) visitReset_master(node);
		else if(hasLabel(node, "Reset_slave")) visitReset_slave(node);
		else if(hasLabel(node, "Start_slave")) visitStart_slave(node);
		else if(hasLabel(node, "Stop_slave")) visitStop_slave(node);
		else if(hasLabel(node, "Start_group_repl")) visitStart_group_repl(node);
		else if(hasLabel(node, "Stop_group_repl")) visitStop_group_repl(node);
		else if(hasLabel(node, "MasterOptString")) visitMasterOptString(node);
		else if(hasLabel(node, "MasterOptDecimal")) visitMasterOptDecimal(node);
		else if(hasLabel(node, "MasterOptBool")) visitMasterOptBool(node);
		else if(hasLabel(node, "MasterOptReal")) visitMasterOptReal(node);
		else if(hasLabel(node, "MasterOptIdList")) visitMasterOptIdList(node);
		else if(hasLabel(node, "String_master_option")) visitString_master_option(node);
		else if(hasLabel(node, "Decimal_master_option")) visitDecimal_master_option(node);
		else if(hasLabel(node, "Bool_master_option")) visitBool_master_option(node);
		else if(hasLabel(node, "Channel_option")) visitChannel_option(node);
		else if(hasLabel(node, "ReplfilterDbList")) visitReplfilterDbList(node);
		else if(hasLabel(node, "ReplfilterTableList")) visitReplfilterTableList(node);
		else if(hasLabel(node, "ReplfilterStableList")) visitReplfilterStableList(node);
		else if(hasLabel(node, "ReplfilterTablepairList")) visitReplfilterTablepairList(node);
		else if(hasLabel(node, "Thread_type")) visitThread_type(node);
		else if(hasLabel(node, "UntilGtidSset")) visitUntilGtidSset(node);
		else if(hasLabel(node, "UntilMasterLog")) visitUntilMasterLog(node);
		else if(hasLabel(node, "UntilRelayLog")) visitUntilRelayLog(node);
		else if(hasLabel(node, "UntilSqlGaps")) visitUntilSqlGaps(node);
		else if(hasLabel(node, "Start_slave_connection_option")) visitStart_slave_connection_option(node);
		else if(hasLabel(node, "Gtid_set")) visitGtid_set(node);
		else if(hasLabel(node, "Xa_start_transaction")) visitXa_start_transaction(node);
		else if(hasLabel(node, "Xa_end_transaction")) visitXa_end_transaction(node);
		else if(hasLabel(node, "Xa_prepare")) visitXa_prepare(node);
		else if(hasLabel(node, "Xa_commit_work")) visitXa_commit_work(node);
		else if(hasLabel(node, "Xa_rollback_work")) visitXa_rollback_work(node);
		else if(hasLabel(node, "Xa_recover_work")) visitXa_recover_work(node);
		else if(hasLabel(node, "Prepare_statement")) visitPrepare_statement(node);
		else if(hasLabel(node, "Execute_statement")) visitExecute_statement(node);
		else if(hasLabel(node, "Deallocate_prepare")) visitDeallocate_prepare(node);
		else if(hasLabel(node, "Routine_body")) visitRoutine_body(node);
		else if(hasLabel(node, "Block_statement")) visitBlock_statement(node);
		else if(hasLabel(node, "Case_statement")) visitCase_statement(node);
		else if(hasLabel(node, "If_statement")) visitIf_statement(node);
		else if(hasLabel(node, "Iterate_statement")) visitIterate_statement(node);
		else if(hasLabel(node, "Leave_statement")) visitLeave_statement(node);
		else if(hasLabel(node, "Loop_statement")) visitLoop_statement(node);
		else if(hasLabel(node, "Repeat_statement")) visitRepeat_statement(node);
		else if(hasLabel(node, "Return_statement")) visitReturn_statement(node);
		else if(hasLabel(node, "While_statement")) visitWhile_statement(node);
		else if(hasLabel(node, "Cursor_statement")) visitCursor_statement(node);
		else if(hasLabel(node, "Declare_variable")) visitDeclare_variable(node);
		else if(hasLabel(node, "Declare_condition")) visitDeclare_condition(node);
		else if(hasLabel(node, "Declare_cursor")) visitDeclare_cursor(node);
		else if(hasLabel(node, "Declare_handler")) visitDeclare_handler(node);
		else if(hasLabel(node, "Handler_condition_value")) visitHandler_condition_value(node);
		else if(hasLabel(node, "Procedure_sql_statement")) visitProcedure_sql_statement(node);
		else if(hasLabel(node, "AlterUserMysql56")) visitAlterUserMysql56(node);
		else if(hasLabel(node, "AlterUserMysql57")) visitAlterUserMysql57(node);
		else if(hasLabel(node, "CreateUserMysql56")) visitCreateUserMysql56(node);
		else if(hasLabel(node, "CreateUserMysql57")) visitCreateUserMysql57(node);
		else if(hasLabel(node, "Drop_user")) visitDrop_user(node);
		else if(hasLabel(node, "Grant_statement")) visitGrant_statement(node);
		else if(hasLabel(node, "Grant_proxy")) visitGrant_proxy(node);
		else if(hasLabel(node, "Rename_user")) visitRename_user(node);
		else if(hasLabel(node, "DetailRevoke")) visitDetailRevoke(node);
		else if(hasLabel(node, "ShortRevoke")) visitShortRevoke(node);
		else if(hasLabel(node, "Revoke_proxy")) visitRevoke_proxy(node);
		else if(hasLabel(node, "Set_password_statement")) visitSet_password_statement(node);
		else if(hasLabel(node, "User_password_option")) visitUser_password_option(node);
		else if(hasLabel(node, "AuthByPassword")) visitAuthByPassword(node);
		else if(hasLabel(node, "AuthByString")) visitAuthByString(node);
		else if(hasLabel(node, "AuthByHash")) visitAuthByHash(node);
		else if(hasLabel(node, "Tls_option")) visitTls_option(node);
		else if(hasLabel(node, "User_resource_option")) visitUser_resource_option(node);
		else if(hasLabel(node, "User_lock_option")) visitUser_lock_option(node);
		else if(hasLabel(node, "Privelege_clause")) visitPrivelege_clause(node);
		else if(hasLabel(node, "Privilege")) visitPrivilege(node);
		else if(hasLabel(node, "Privilege_level")) visitPrivilege_level(node);
		else if(hasLabel(node, "Set_password_option")) visitSet_password_option(node);
		else if(hasLabel(node, "Analyze_table")) visitAnalyze_table(node);
		else if(hasLabel(node, "Check_table")) visitCheck_table(node);
		else if(hasLabel(node, "Checksum_table")) visitChecksum_table(node);
		else if(hasLabel(node, "Optimize_table")) visitOptimize_table(node);
		else if(hasLabel(node, "Repair_table")) visitRepair_table(node);
		else if(hasLabel(node, "Check_table_option")) visitCheck_table_option(node);
		else if(hasLabel(node, "Create_udfunction")) visitCreate_udfunction(node);
		else if(hasLabel(node, "Install_plugin")) visitInstall_plugin(node);
		else if(hasLabel(node, "Uninstall_plugin")) visitUninstall_plugin(node);
		else if(hasLabel(node, "SetVariableAssignment")) visitSetVariableAssignment(node);
		else if(hasLabel(node, "SetCharset")) visitSetCharset(node);
		else if(hasLabel(node, "SetNames")) visitSetNames(node);
		else if(hasLabel(node, "SetPasswordStatement")) visitSetPasswordStatement(node);
		else if(hasLabel(node, "SetTransaction")) visitSetTransaction(node);
		else if(hasLabel(node, "SetAutocommit")) visitSetAutocommit(node);
		else if(hasLabel(node, "ShowMasterlogs")) visitShowMasterlogs(node);
		else if(hasLabel(node, "ShowLogevents")) visitShowLogevents(node);
		else if(hasLabel(node, "ShowObjWithFilter")) visitShowObjWithFilter(node);
		else if(hasLabel(node, "ShowColumns")) visitShowColumns(node);
		else if(hasLabel(node, "ShowCreateDb")) visitShowCreateDb(node);
		else if(hasLabel(node, "ShowCreateFullidobj")) visitShowCreateFullidobj(node);
		else if(hasLabel(node, "ShowCreateUser")) visitShowCreateUser(node);
		else if(hasLabel(node, "ShowEngine")) visitShowEngine(node);
		else if(hasLabel(node, "ShowGlobalinfo")) visitShowGlobalinfo(node);
		else if(hasLabel(node, "ShowErrWarn")) visitShowErrWarn(node);
		else if(hasLabel(node, "ShowCountErrWarn")) visitShowCountErrWarn(node);
		else if(hasLabel(node, "ShowFromschemaFilter")) visitShowFromschemaFilter(node);
		else if(hasLabel(node, "ShowRoutinecode")) visitShowRoutinecode(node);
		else if(hasLabel(node, "ShowGrants")) visitShowGrants(node);
		else if(hasLabel(node, "ShowIndexes")) visitShowIndexes(node);
		else if(hasLabel(node, "ShowOpentables")) visitShowOpentables(node);
		else if(hasLabel(node, "ShowProfile")) visitShowProfile(node);
		else if(hasLabel(node, "ShowSlavestatus")) visitShowSlavestatus(node);
		else if(hasLabel(node, "Variable_clause")) visitVariable_clause(node);
		else if(hasLabel(node, "Show_filter")) visitShow_filter(node);
		else if(hasLabel(node, "Show_profile_type")) visitShow_profile_type(node);
		else if(hasLabel(node, "Binlog_statement")) visitBinlog_statement(node);
		else if(hasLabel(node, "Cache_index_statement")) visitCache_index_statement(node);
		else if(hasLabel(node, "Flush_statement")) visitFlush_statement(node);
		else if(hasLabel(node, "Kill_statement")) visitKill_statement(node);
		else if(hasLabel(node, "Load_index_into_cache")) visitLoad_index_into_cache(node);
		else if(hasLabel(node, "Reset_statement")) visitReset_statement(node);
		else if(hasLabel(node, "Shutdown_statement")) visitShutdown_statement(node);
		else if(hasLabel(node, "Tbl_index_list")) visitTbl_index_list(node);
		else if(hasLabel(node, "Flush_option")) visitFlush_option(node);
		else if(hasLabel(node, "Load_tbl_index_list")) visitLoad_tbl_index_list(node);
		else if(hasLabel(node, "Simple_describe_statement")) visitSimple_describe_statement(node);
		else if(hasLabel(node, "Full_describe_statement")) visitFull_describe_statement(node);
		else if(hasLabel(node, "Help_statement")) visitHelp_statement(node);
		else if(hasLabel(node, "Use_statement")) visitUse_statement(node);
		else if(hasLabel(node, "DescstmtDescObj")) visitDescstmtDescObj(node);
		else if(hasLabel(node, "ConnectionDescObj")) visitConnectionDescObj(node);
		else if(hasLabel(node, "Table_name")) visitTable_name(node);
		else if(hasLabel(node, "Full_id")) visitFull_id(node);
		else if(hasLabel(node, "Full_column_name")) visitFull_column_name(node);
		else if(hasLabel(node, "Index_col_name")) visitIndex_col_name(node);
		else if(hasLabel(node, "User_name")) visitUser_name(node);
		else if(hasLabel(node, "Mysql_variable")) visitMysql_variable(node);
		else if(hasLabel(node, "Charset_name")) visitCharset_name(node);
		else if(hasLabel(node, "Collation_name")) visitCollation_name(node);
		else if(hasLabel(node, "Engine_name")) visitEngine_name(node);
		else if(hasLabel(node, "Uuid_set")) visitUuid_set(node);
		else if(hasLabel(node, "Xid")) visitXid(node);
		else if(hasLabel(node, "Xid_string_id")) visitXid_string_id(node);
		else if(hasLabel(node, "Auth_plugin")) visitAuth_plugin(node);
		else if(hasLabel(node, "Id_")) visitId_(node);
		else if(hasLabel(node, "Simple_id")) visitSimple_id(node);
		else if(hasLabel(node, "Dot_ext_id")) visitDot_ext_id(node);
		else if(hasLabel(node, "Decimal_literal")) visitDecimal_literal(node);
		else if(hasLabel(node, "Filesize_literal")) visitFilesize_literal(node);
		else if(hasLabel(node, "String_literal")) visitString_literal(node);
		else if(hasLabel(node, "Boolean_literal")) visitBoolean_literal(node);
		else if(hasLabel(node, "Hexadecimal_literal")) visitHexadecimal_literal(node);
		else if(hasLabel(node, "Null_notnull")) visitNull_notnull(node);
		else if(hasLabel(node, "Constant")) visitConstant(node);
		else if(hasLabel(node, "CharDatatype")) visitCharDatatype(node);
		else if(hasLabel(node, "DimensionDatatype")) visitDimensionDatatype(node);
		else if(hasLabel(node, "SimpleDatatype")) visitSimpleDatatype(node);
		else if(hasLabel(node, "CollectCharDatatype")) visitCollectCharDatatype(node);
		else if(hasLabel(node, "SpatialDatatype")) visitSpatialDatatype(node);
		else if(hasLabel(node, "Data_type_to_convert")) visitData_type_to_convert(node);
		else if(hasLabel(node, "Spatial_data_type")) visitSpatial_data_type(node);
		else if(hasLabel(node, "Length_one_dimension")) visitLength_one_dimension(node);
		else if(hasLabel(node, "Length_two_dimension")) visitLength_two_dimension(node);
		else if(hasLabel(node, "Length_two_optional_dimension")) visitLength_two_optional_dimension(node);
		else if(hasLabel(node, "Id_list")) visitId_list(node);
		else if(hasLabel(node, "Table_list")) visitTable_list(node);
		else if(hasLabel(node, "Table_pair_list")) visitTable_pair_list(node);
		else if(hasLabel(node, "Index_colname_list")) visitIndex_colname_list(node);
		else if(hasLabel(node, "Expression_list")) visitExpression_list(node);
		else if(hasLabel(node, "Constant_list")) visitConstant_list(node);
		else if(hasLabel(node, "Simple_string_list")) visitSimple_string_list(node);
		else if(hasLabel(node, "User_var_list")) visitUser_var_list(node);
		else if(hasLabel(node, "Default_value")) visitDefault_value(node);
		else if(hasLabel(node, "If_exists")) visitIf_exists(node);
		else if(hasLabel(node, "If_not_exists")) visitIf_not_exists(node);
		else if(hasLabel(node, "SpecificFunctionCall")) visitSpecificFunctionCall(node);
		else if(hasLabel(node, "AggregateFunctionCall")) visitAggregateFunctionCall(node);
		else if(hasLabel(node, "ScalarFunctionCall")) visitScalarFunctionCall(node);
		else if(hasLabel(node, "UdfFunctionCall")) visitUdfFunctionCall(node);
		else if(hasLabel(node, "SimpleSpecificFCall")) visitSimpleSpecificFCall(node);
		else if(hasLabel(node, "ConvertDataTypeFCall")) visitConvertDataTypeFCall(node);
		else if(hasLabel(node, "ValuesFCall")) visitValuesFCall(node);
		else if(hasLabel(node, "CaseFCall")) visitCaseFCall(node);
		else if(hasLabel(node, "CharFCall")) visitCharFCall(node);
		else if(hasLabel(node, "PositionFCall")) visitPositionFCall(node);
		else if(hasLabel(node, "SubstrFCall")) visitSubstrFCall(node);
		else if(hasLabel(node, "TrimFCall")) visitTrimFCall(node);
		else if(hasLabel(node, "WeightFCall")) visitWeightFCall(node);
		else if(hasLabel(node, "ExtractFCall")) visitExtractFCall(node);
		else if(hasLabel(node, "GetFormatFCall")) visitGetFormatFCall(node);
		else if(hasLabel(node, "LevelWeightFList")) visitLevelWeightFList(node);
		else if(hasLabel(node, "LevelWeightFRange")) visitLevelWeightFRange(node);
		else if(hasLabel(node, "Aggregate_windowed_function")) visitAggregate_windowed_function(node);
		else if(hasLabel(node, "Scalar_function_name")) visitScalar_function_name(node);
		else if(hasLabel(node, "Function_args")) visitFunction_args(node);
		else if(hasLabel(node, "Function_arg")) visitFunction_arg(node);
		else if(hasLabel(node, "IsExpression")) visitIsExpression(node);
		else if(hasLabel(node, "LogicalExpression")) visitLogicalExpression(node);
		else if(hasLabel(node, "PredicateExpression")) visitPredicateExpression(node);
		else if(hasLabel(node, "SoundsLikePredicate")) visitSoundsLikePredicate(node);
		else if(hasLabel(node, "ExpressionAtomPredicate")) visitExpressionAtomPredicate(node);
		else if(hasLabel(node, "InPredicate")) visitInPredicate(node);
		else if(hasLabel(node, "SubqueryComparasionPredicate")) visitSubqueryComparasionPredicate(node);
		else if(hasLabel(node, "BetweenPredicate")) visitBetweenPredicate(node);
		else if(hasLabel(node, "BinaryComparasionPredicate")) visitBinaryComparasionPredicate(node);
		else if(hasLabel(node, "IsNullPredicate")) visitIsNullPredicate(node);
		else if(hasLabel(node, "LikePredicate")) visitLikePredicate(node);
		else if(hasLabel(node, "RegexpPredicate")) visitRegexpPredicate(node);
		else if(hasLabel(node, "UnaryExpressionAtom")) visitUnaryExpressionAtom(node);
		else if(hasLabel(node, "ExistsExpessionAtom")) visitExistsExpessionAtom(node);
		else if(hasLabel(node, "ConstantExpressionAtom")) visitConstantExpressionAtom(node);
		else if(hasLabel(node, "FunctionCallExpressionAtom")) visitFunctionCallExpressionAtom(node);
		else if(hasLabel(node, "MysqlVariableExpressionAtom")) visitMysqlVariableExpressionAtom(node);
		else if(hasLabel(node, "BinaryExpressionAtom")) visitBinaryExpressionAtom(node);
		else if(hasLabel(node, "FullColumnNameExpressionAtom")) visitFullColumnNameExpressionAtom(node);
		else if(hasLabel(node, "DefaultExpressionAtom")) visitDefaultExpressionAtom(node);
		else if(hasLabel(node, "BitExpressionAtom")) visitBitExpressionAtom(node);
		else if(hasLabel(node, "NestedExpressionAtom")) visitNestedExpressionAtom(node);
		else if(hasLabel(node, "MathExpressionAtom")) visitMathExpressionAtom(node);
		else if(hasLabel(node, "IntervalExpressionAtom")) visitIntervalExpressionAtom(node);
		else if(hasLabel(node, "Unary_operator")) visitUnary_operator(node);
		else if(hasLabel(node, "Comparison_operator")) visitComparison_operator(node);
		else if(hasLabel(node, "Logical_operator")) visitLogical_operator(node);
		else if(hasLabel(node, "Bit_operator")) visitBit_operator(node);
		else if(hasLabel(node, "Math_operator")) visitMath_operator(node);
		else if(hasLabel(node, "Charset_name_base")) visitCharset_name_base(node);
		else if(hasLabel(node, "Transaction_level_base")) visitTransaction_level_base(node);
		else if(hasLabel(node, "Privileges_base")) visitPrivileges_base(node);
		else if(hasLabel(node, "Interval_type_base")) visitInterval_type_base(node);
		else if(hasLabel(node, "Data_type_base")) visitData_type_base(node);
		else if(hasLabel(node, "Keywords_can_be_id")) visitKeywords_can_be_id(node);
		else if(hasLabel(node, "Function_name_base")) visitFunction_name_base(node);
   }

	public void visitNotExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRoot(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSql_statements(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSql_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEmpty_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDdl_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDml_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTransaction_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReplication_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrepared_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCompound_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAdministration_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUtility_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_database(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_event(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_index(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_logfile_group(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_procedure(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_function(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_server(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCopyCreateTable(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQueryCreateTable(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColCreateTable(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_tablespace_innodb(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_tablespace_ndb(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_trigger(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_view(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_database_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOwner_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPreciseSchedule(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIntervalSchedule(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTimestamp_value(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterval_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterval_type(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIndex_type(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIndex_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitProc_param(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunc_param(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRcComment(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRcSqllang(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRcDeterm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRcSqldata(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRcSecurestmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitServer_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColumn_def_table_constraints(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColumnDefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstraintDefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIndexDefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColumn_definition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrNull(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrDflt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrAuInc(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrPK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrUK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrComment(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrForm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrStorage(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitColConstrRefdef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblConstrPK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblConstrUK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblConstrFK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblConstCheck(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReference_definition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOn_delete_action(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOn_update_action(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReference_action_control_type(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleIndex(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSpecIndex(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptEngine(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptAuInc(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptAvgRLen(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptDefCharSet(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptChkSum(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptDefCollate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptComment(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptCompr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptConn(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptDataDir(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptDelKW(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptEncr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptIndexDir(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptInsMeth(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptKeyBlockSz(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptMaxRows(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptMinRows(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptPackK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptPasswd(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptRowFormat(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptStatAutoR(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptStatPersist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptStatSamplPg(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptTablespace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTblOptUnion(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPartition_options(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPartition_function_definition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLinear_partition_func_def(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPartition_def(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSubpartition_def(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlterDb(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlterDbUpgradeName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_event(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_function(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_instance(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_logfile_group(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_procedure(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_server(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_tablespace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlter_view(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblTableOpt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddCol(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddCols(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddIndex(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddPK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddUK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddSpecIndex(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddFK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAlg(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblColDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblColChange(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblLock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblColMod(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblColDrop(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDropPK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDropIndex(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDropFK(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDisKey(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblEnKey(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblRenameTbl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblResort(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblConvert(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDefCharset(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDisTblspace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblImpTblSpace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblForce(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblValid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAddPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDropPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblDiscartPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblImportPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblTruncPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblCoalPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblReorgPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblExchPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblAnalPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblCheckPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblOptimPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblRebuildPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblRepairPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblRemovePart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltblUpgrPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_database(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_event(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_index(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_logfile_group(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_procedure(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_function(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_server(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_tablespace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_trigger(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_view(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRename_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTruncate_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCall_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDelete_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDo_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandler_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInsert_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLoad_data_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLoad_xml_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReplace_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleSelect(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParenSelect(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnionSelect(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnionParenSelect(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUpdate_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInsert_statement_value(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUpdate_elem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCol_or_uservar(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSingle_delete_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMultiple_delete_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandler_open_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandler_read_index_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandler_read_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandler_close_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSingle_update_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMultiple_update_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOrder_by_clause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOrder_by_expression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTable_sources(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTable_source(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAtomTableItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSubqueryTableItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTableSourcesItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIndex_hint(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInnerJoin(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStraightJoin(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOuterJoin(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNaturalJoin(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSubquery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQuery_expression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQuery_expression_nointo(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQuery_specification(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQuery_specification_nointo(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnion_parenth(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnion_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelect_spec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelect_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSellistelAllCol(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSellistelCol(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSellistelFunc(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSellistelExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelectIntoVars(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelectIntoDump(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelectIntoOutfile(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFrom_clause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGroup_by_item(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLimit_clause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStart_transaction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBegin_work(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCommit_work(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRollback_work(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSavepoint_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRollback_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelease_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLock_tables(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnlock_tables(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSet_autocommit_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSet_transaction_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTransact_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLock_table_element(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTrans_characteristic(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTransaction_level(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitChange_master(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitChange_repl_filter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPurge_binary_logs(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReset_master(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReset_slave(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStart_slave(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStop_slave(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStart_group_repl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStop_group_repl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMasterOptString(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMasterOptDecimal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMasterOptBool(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMasterOptReal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMasterOptIdList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitString_master_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDecimal_master_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBool_master_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitChannel_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReplfilterDbList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReplfilterTableList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReplfilterStableList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReplfilterTablepairList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitThread_type(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUntilGtidSset(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUntilMasterLog(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUntilRelayLog(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUntilSqlGaps(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStart_slave_connection_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGtid_set(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXa_start_transaction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXa_end_transaction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXa_prepare(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXa_commit_work(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXa_rollback_work(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXa_recover_work(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrepare_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExecute_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeallocate_prepare(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRoutine_body(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlock_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCase_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIf_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIterate_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLeave_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLoop_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRepeat_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReturn_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWhile_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCursor_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclare_variable(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclare_condition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclare_cursor(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclare_handler(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandler_condition_value(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitProcedure_sql_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlterUserMysql56(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlterUserMysql57(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreateUserMysql56(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreateUserMysql57(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDrop_user(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGrant_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGrant_proxy(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRename_user(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDetailRevoke(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShortRevoke(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRevoke_proxy(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSet_password_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUser_password_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAuthByPassword(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAuthByString(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAuthByHash(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTls_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUser_resource_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUser_lock_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrivelege_clause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrivilege(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrivilege_level(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSet_password_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnalyze_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCheck_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitChecksum_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOptimize_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRepair_table(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCheck_table_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate_udfunction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInstall_plugin(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUninstall_plugin(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetVariableAssignment(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetCharset(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetNames(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetPasswordStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetTransaction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetAutocommit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowMasterlogs(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowLogevents(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowObjWithFilter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowColumns(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowCreateDb(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowCreateFullidobj(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowCreateUser(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowEngine(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowGlobalinfo(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowErrWarn(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowCountErrWarn(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowFromschemaFilter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowRoutinecode(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowGrants(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowIndexes(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowOpentables(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowProfile(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShowSlavestatus(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariable_clause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShow_filter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShow_profile_type(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBinlog_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCache_index_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFlush_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKill_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLoad_index_into_cache(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReset_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShutdown_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTbl_index_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFlush_option(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLoad_tbl_index_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimple_describe_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFull_describe_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHelp_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUse_statement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDescstmtDescObj(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConnectionDescObj(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTable_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFull_id(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFull_column_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIndex_col_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUser_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMysql_variable(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCharset_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCollation_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEngine_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUuid_set(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXid_string_id(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAuth_plugin(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitId_(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimple_id(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDot_ext_id(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDecimal_literal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFilesize_literal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitString_literal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBoolean_literal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHexadecimal_literal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNull_notnull(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstant(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCharDatatype(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDimensionDatatype(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleDatatype(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCollectCharDatatype(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSpatialDatatype(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitData_type_to_convert(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSpatial_data_type(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLength_one_dimension(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLength_two_dimension(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLength_two_optional_dimension(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitId_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTable_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTable_pair_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIndex_colname_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpression_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstant_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimple_string_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUser_var_list(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDefault_value(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIf_exists(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIf_not_exists(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSpecificFunctionCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAggregateFunctionCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitScalarFunctionCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUdfFunctionCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleSpecificFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConvertDataTypeFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitValuesFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCharFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPositionFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSubstrFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTrimFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWeightFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExtractFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGetFormatFCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLevelWeightFList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLevelWeightFRange(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAggregate_windowed_function(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitScalar_function_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunction_args(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunction_arg(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIsExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLogicalExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPredicateExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSoundsLikePredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionAtomPredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInPredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSubqueryComparasionPredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBetweenPredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBinaryComparasionPredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIsNullPredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLikePredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRegexpPredicate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExistsExpessionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstantExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionCallExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMysqlVariableExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBinaryExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFullColumnNameExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDefaultExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBitExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNestedExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMathExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIntervalExpressionAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnary_operator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitComparison_operator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLogical_operator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBit_operator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMath_operator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCharset_name_base(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTransaction_level_base(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrivileges_base(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterval_type_base(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitData_type_base(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKeywords_can_be_id(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunction_name_base(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	private boolean hasLabel(Node node, String label) {
   	for (org.neo4j.graphdb.Label lbl : node.getLabels())
      	if (lbl.name().equals(label)) return true;
      return false;
   }

	protected Iterable<Relationship> outgoing(Node node, RelationshipType type) {
     	return node == null ? java.util.Collections.emptyList() : node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type);
   }

	protected Iterable<Relationship> outgoing(Node node) {
     	return node == null ? java.util.Collections.emptyList() : node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING);
   }

	protected Node other(Node node, Relationship relationship) {
     	return relationship == null ? null : relationship.getOtherNode(node);
   }
}