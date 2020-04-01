package com.generator.generators.mysql.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class MySqlParserNeoVisitor extends MySqlParserBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MySqlParserNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public MySqlParserNeoVisitor(com.generator.neo.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		log.info("Root");
		final Node node = model.newNode(Label.label("Root"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		log.info("Sql_statements");
		final Node node = model.newNode(Label.label("Sql_statements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		log.info("Sql_statement");
		final Node node = model.newNode(Label.label("Sql_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		log.info("Empty_statement");
		final Node node = model.newNode(Label.label("Empty_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		log.info("Create_view");
		final Node node = model.newNode(Label.label("Create_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		log.info("Ddl_statement");
		final Node node = model.newNode(Label.label("Ddl_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		log.info("Dml_statement");
		final Node node = model.newNode(Label.label("Dml_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		log.info("Transaction_statement");
		final Node node = model.newNode(Label.label("Transaction_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		log.info("Replication_statement");
		final Node node = model.newNode(Label.label("Replication_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		log.info("Prepared_statement");
		final Node node = model.newNode(Label.label("Prepared_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		log.info("Compound_statement");
		final Node node = model.newNode(Label.label("Compound_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		log.info("Administration_statement");
		final Node node = model.newNode(Label.label("Administration_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		log.info("Utility_statement");
		final Node node = model.newNode(Label.label("Utility_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		log.info("Create_database");
		final Node node = model.newNode(Label.label("Create_database"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		log.info("Create_event");
		final Node node = model.newNode(Label.label("Create_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		log.info("Index_type");
		final Node node = model.newNode(Label.label("Index_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		log.info("Revoke_proxy");
		final Node node = model.newNode(Label.label("Revoke_proxy"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		log.info("Set_password_statement");
		final Node node = model.newNode(Label.label("Set_password_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		log.info("User_password_option");
		final Node node = model.newNode(Label.label("User_password_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		log.info("AuthByPassword");
		final Node node = model.newNode(Label.label("AuthByPassword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		log.info("AuthByString");
		final Node node = model.newNode(Label.label("AuthByString"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		log.info("AuthByHash");
		final Node node = model.newNode(Label.label("AuthByHash"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		log.info("Tls_option");
		final Node node = model.newNode(Label.label("Tls_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		log.info("User_resource_option");
		final Node node = model.newNode(Label.label("User_resource_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		log.info("User_lock_option");
		final Node node = model.newNode(Label.label("User_lock_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		log.info("Privelege_clause");
		final Node node = model.newNode(Label.label("Privelege_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		log.info("Privilege");
		final Node node = model.newNode(Label.label("Privilege"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		log.info("Privilege_level");
		final Node node = model.newNode(Label.label("Privilege_level"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		log.info("Set_password_option");
		final Node node = model.newNode(Label.label("Set_password_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		log.info("Analyze_table");
		final Node node = model.newNode(Label.label("Analyze_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		log.info("Check_table");
		final Node node = model.newNode(Label.label("Check_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		log.info("Checksum_table");
		final Node node = model.newNode(Label.label("Checksum_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		log.info("Optimize_table");
		final Node node = model.newNode(Label.label("Optimize_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		log.info("Repair_table");
		final Node node = model.newNode(Label.label("Repair_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		log.info("Check_table_option");
		final Node node = model.newNode(Label.label("Check_table_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		log.info("Create_udfunction");
		final Node node = model.newNode(Label.label("Create_udfunction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		log.info("Install_plugin");
		final Node node = model.newNode(Label.label("Install_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		log.info("Uninstall_plugin");
		final Node node = model.newNode(Label.label("Uninstall_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		log.info("SetVariableAssignment");
		final Node node = model.newNode(Label.label("SetVariableAssignment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		log.info("SetCharset");
		final Node node = model.newNode(Label.label("SetCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		log.info("SetNames");
		final Node node = model.newNode(Label.label("SetNames"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		log.info("SetPasswordStatement");
		final Node node = model.newNode(Label.label("SetPasswordStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		log.info("SetTransaction");
		final Node node = model.newNode(Label.label("SetTransaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		log.info("SetAutocommit");
		final Node node = model.newNode(Label.label("SetAutocommit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		log.info("ShowMasterlogs");
		final Node node = model.newNode(Label.label("ShowMasterlogs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		log.info("ShowLogevents");
		final Node node = model.newNode(Label.label("ShowLogevents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		log.info("ShowObjWithFilter");
		final Node node = model.newNode(Label.label("ShowObjWithFilter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		log.info("ShowColumns");
		final Node node = model.newNode(Label.label("ShowColumns"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		log.info("ShowCreateDb");
		final Node node = model.newNode(Label.label("ShowCreateDb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		log.info("ShowCreateFullidobj");
		final Node node = model.newNode(Label.label("ShowCreateFullidobj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		log.info("ShowCreateUser");
		final Node node = model.newNode(Label.label("ShowCreateUser"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		log.info("ShowEngine");
		final Node node = model.newNode(Label.label("ShowEngine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		log.info("ShowGlobalinfo");
		final Node node = model.newNode(Label.label("ShowGlobalinfo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		log.info("ShowErrWarn");
		final Node node = model.newNode(Label.label("ShowErrWarn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		log.info("ShowCountErrWarn");
		final Node node = model.newNode(Label.label("ShowCountErrWarn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		log.info("ShowFromschemaFilter");
		final Node node = model.newNode(Label.label("ShowFromschemaFilter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		log.info("ShowRoutinecode");
		final Node node = model.newNode(Label.label("ShowRoutinecode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		log.info("ShowGrants");
		final Node node = model.newNode(Label.label("ShowGrants"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		log.info("ShowIndexes");
		final Node node = model.newNode(Label.label("ShowIndexes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		log.info("ShowOpentables");
		final Node node = model.newNode(Label.label("ShowOpentables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		log.info("ShowProfile");
		final Node node = model.newNode(Label.label("ShowProfile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		log.info("ShowSlavestatus");
		final Node node = model.newNode(Label.label("ShowSlavestatus"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		log.info("Variable_clause");
		final Node node = model.newNode(Label.label("Variable_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		log.info("Show_filter");
		final Node node = model.newNode(Label.label("Show_filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		log.info("Show_profile_type");
		final Node node = model.newNode(Label.label("Show_profile_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		log.info("Binlog_statement");
		final Node node = model.newNode(Label.label("Binlog_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		log.info("Cache_index_statement");
		final Node node = model.newNode(Label.label("Cache_index_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		log.info("Flush_statement");
		final Node node = model.newNode(Label.label("Flush_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		log.info("Kill_statement");
		final Node node = model.newNode(Label.label("Kill_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		log.info("Load_index_into_cache");
		final Node node = model.newNode(Label.label("Load_index_into_cache"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		log.info("Reset_statement");
		final Node node = model.newNode(Label.label("Reset_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		log.info("Shutdown_statement");
		final Node node = model.newNode(Label.label("Shutdown_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		log.info("Tbl_index_list");
		final Node node = model.newNode(Label.label("Tbl_index_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		log.info("Flush_option");
		final Node node = model.newNode(Label.label("Flush_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		log.info("Load_tbl_index_list");
		final Node node = model.newNode(Label.label("Load_tbl_index_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		log.info("Simple_describe_statement");
		final Node node = model.newNode(Label.label("Simple_describe_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		log.info("Full_describe_statement");
		final Node node = model.newNode(Label.label("Full_describe_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		log.info("Help_statement");
		final Node node = model.newNode(Label.label("Help_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		log.info("Use_statement");
		final Node node = model.newNode(Label.label("Use_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		log.info("DescstmtDescObj");
		final Node node = model.newNode(Label.label("DescstmtDescObj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		log.info("ConnectionDescObj");
		final Node node = model.newNode(Label.label("ConnectionDescObj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		log.info("Table_name");
		final Node node = model.newNode(Label.label("Table_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		log.info("Full_id");
		final Node node = model.newNode(Label.label("Full_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		log.info("Full_column_name");
		final Node node = model.newNode(Label.label("Full_column_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		log.info("Index_col_name");
		final Node node = model.newNode(Label.label("Index_col_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		log.info("User_name");
		final Node node = model.newNode(Label.label("User_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		log.info("Mysql_variable");
		final Node node = model.newNode(Label.label("Mysql_variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		log.info("Charset_name");
		final Node node = model.newNode(Label.label("Charset_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		log.info("Collation_name");
		final Node node = model.newNode(Label.label("Collation_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		log.info("Engine_name");
		final Node node = model.newNode(Label.label("Engine_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		log.info("Uuid_set");
		final Node node = model.newNode(Label.label("Uuid_set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		log.info("Xid");
		final Node node = model.newNode(Label.label("Xid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		log.info("Xid_string_id");
		final Node node = model.newNode(Label.label("Xid_string_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		log.info("Auth_plugin");
		final Node node = model.newNode(Label.label("Auth_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		log.info("Id_");
		final Node node = model.newNode(Label.label("Id_"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		log.info("Simple_id");
		final Node node = model.newNode(Label.label("Simple_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		log.info("Dot_ext_id");
		final Node node = model.newNode(Label.label("Dot_ext_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		log.info("Decimal_literal");
		final Node node = model.newNode(Label.label("Decimal_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		log.info("Filesize_literal");
		final Node node = model.newNode(Label.label("Filesize_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		log.info("String_literal");
		final Node node = model.newNode(Label.label("String_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		log.info("Boolean_literal");
		final Node node = model.newNode(Label.label("Boolean_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		log.info("Hexadecimal_literal");
		final Node node = model.newNode(Label.label("Hexadecimal_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		log.info("Null_notnull");
		final Node node = model.newNode(Label.label("Null_notnull"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		log.info("Constant");
		final Node node = model.newNode(Label.label("Constant"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		log.info("CharDatatype");
		final Node node = model.newNode(Label.label("CharDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		log.info("DimensionDatatype");
		final Node node = model.newNode(Label.label("DimensionDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		log.info("SimpleDatatype");
		final Node node = model.newNode(Label.label("SimpleDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		log.info("CollectCharDatatype");
		final Node node = model.newNode(Label.label("CollectCharDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		log.info("SpatialDatatype");
		final Node node = model.newNode(Label.label("SpatialDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		log.info("Data_type_to_convert");
		final Node node = model.newNode(Label.label("Data_type_to_convert"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		log.info("Spatial_data_type");
		final Node node = model.newNode(Label.label("Spatial_data_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		log.info("Length_one_dimension");
		final Node node = model.newNode(Label.label("Length_one_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		log.info("Length_two_dimension");
		final Node node = model.newNode(Label.label("Length_two_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		log.info("Length_two_optional_dimension");
		final Node node = model.newNode(Label.label("Length_two_optional_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		log.info("Id_list");
		final Node node = model.newNode(Label.label("Id_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		log.info("Table_list");
		final Node node = model.newNode(Label.label("Table_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		log.info("Table_pair_list");
		final Node node = model.newNode(Label.label("Table_pair_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		log.info("Index_colname_list");
		final Node node = model.newNode(Label.label("Index_colname_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		log.info("Expression_list");
		final Node node = model.newNode(Label.label("Expression_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		log.info("Constant_list");
		final Node node = model.newNode(Label.label("Constant_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		log.info("If_exists");
		final Node node = model.newNode(Label.label("If_exists"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		log.info("Create_index");
		final Node node = model.newNode(Label.label("Create_index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		log.info("Create_logfile_group");
		final Node node = model.newNode(Label.label("Create_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		log.info("Create_procedure");
		final Node node = model.newNode(Label.label("Create_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		log.info("Create_function");
		final Node node = model.newNode(Label.label("Create_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		log.info("Create_server");
		final Node node = model.newNode(Label.label("Create_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		log.info("CopyCreateTable");
		final Node node = model.newNode(Label.label("CopyCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		log.info("QueryCreateTable");
		final Node node = model.newNode(Label.label("QueryCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		log.info("ColCreateTable");
		final Node node = model.newNode(Label.label("ColCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		log.info("Create_tablespace_innodb");
		final Node node = model.newNode(Label.label("Create_tablespace_innodb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		log.info("Create_tablespace_ndb");
		final Node node = model.newNode(Label.label("Create_tablespace_ndb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		log.info("Create_trigger");
		final Node node = model.newNode(Label.label("Create_trigger"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		log.info("Create_database_option");
		final Node node = model.newNode(Label.label("Create_database_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		log.info("Owner_statement");
		final Node node = model.newNode(Label.label("Owner_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		log.info("PreciseSchedule");
		final Node node = model.newNode(Label.label("PreciseSchedule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		log.info("IntervalSchedule");
		final Node node = model.newNode(Label.label("IntervalSchedule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		log.info("Timestamp_value");
		final Node node = model.newNode(Label.label("Timestamp_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		log.info("Interval_expr");
		final Node node = model.newNode(Label.label("Interval_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		log.info("Interval_type");
		final Node node = model.newNode(Label.label("Interval_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		log.info("Index_option");
		final Node node = model.newNode(Label.label("Index_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		log.info("Proc_param");
		final Node node = model.newNode(Label.label("Proc_param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		log.info("Func_param");
		final Node node = model.newNode(Label.label("Func_param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		log.info("RcComment");
		final Node node = model.newNode(Label.label("RcComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		log.info("RcSqllang");
		final Node node = model.newNode(Label.label("RcSqllang"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		log.info("RcDeterm");
		final Node node = model.newNode(Label.label("RcDeterm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		log.info("RcSqldata");
		final Node node = model.newNode(Label.label("RcSqldata"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		log.info("RcSecurestmt");
		final Node node = model.newNode(Label.label("RcSecurestmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		log.info("Server_option");
		final Node node = model.newNode(Label.label("Server_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		log.info("Column_def_table_constraints");
		final Node node = model.newNode(Label.label("Column_def_table_constraints"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		log.info("ColumnDefinition");
		final Node node = model.newNode(Label.label("ColumnDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		log.info("ConstraintDefinition");
		final Node node = model.newNode(Label.label("ConstraintDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		log.info("IndexDefinition");
		final Node node = model.newNode(Label.label("IndexDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		log.info("Column_definition");
		final Node node = model.newNode(Label.label("Column_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		log.info("ColConstrNull");
		final Node node = model.newNode(Label.label("ColConstrNull"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		log.info("ColConstrDflt");
		final Node node = model.newNode(Label.label("ColConstrDflt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		log.info("ColConstrAuInc");
		final Node node = model.newNode(Label.label("ColConstrAuInc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		log.info("ColConstrPK");
		final Node node = model.newNode(Label.label("ColConstrPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		log.info("ColConstrUK");
		final Node node = model.newNode(Label.label("ColConstrUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		log.info("ColConstrComment");
		final Node node = model.newNode(Label.label("ColConstrComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		log.info("ColConstrForm");
		final Node node = model.newNode(Label.label("ColConstrForm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		log.info("ColConstrStorage");
		final Node node = model.newNode(Label.label("ColConstrStorage"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		log.info("ColConstrRefdef");
		final Node node = model.newNode(Label.label("ColConstrRefdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		log.info("TblConstrPK");
		final Node node = model.newNode(Label.label("TblConstrPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		log.info("TblConstrUK");
		final Node node = model.newNode(Label.label("TblConstrUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		log.info("TblConstrFK");
		final Node node = model.newNode(Label.label("TblConstrFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		log.info("TblConstCheck");
		final Node node = model.newNode(Label.label("TblConstCheck"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		log.info("Reference_definition");
		final Node node = model.newNode(Label.label("Reference_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		log.info("On_delete_action");
		final Node node = model.newNode(Label.label("On_delete_action"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		log.info("On_update_action");
		final Node node = model.newNode(Label.label("On_update_action"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		log.info("Reference_action_control_type");
		final Node node = model.newNode(Label.label("Reference_action_control_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		log.info("SimpleIndex");
		final Node node = model.newNode(Label.label("SimpleIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		log.info("SpecIndex");
		final Node node = model.newNode(Label.label("SpecIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		log.info("TblOptEngine");
		final Node node = model.newNode(Label.label("TblOptEngine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		log.info("TblOptAuInc");
		final Node node = model.newNode(Label.label("TblOptAuInc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		log.info("TblOptAvgRLen");
		final Node node = model.newNode(Label.label("TblOptAvgRLen"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		log.info("TblOptDefCharSet");
		final Node node = model.newNode(Label.label("TblOptDefCharSet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		log.info("TblOptChkSum");
		final Node node = model.newNode(Label.label("TblOptChkSum"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		log.info("TblOptDefCollate");
		final Node node = model.newNode(Label.label("TblOptDefCollate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		log.info("TblOptComment");
		final Node node = model.newNode(Label.label("TblOptComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		log.info("TblOptCompr");
		final Node node = model.newNode(Label.label("TblOptCompr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		log.info("TblOptConn");
		final Node node = model.newNode(Label.label("TblOptConn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		log.info("TblOptDataDir");
		final Node node = model.newNode(Label.label("TblOptDataDir"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		log.info("TblOptDelKW");
		final Node node = model.newNode(Label.label("TblOptDelKW"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		log.info("TblOptEncr");
		final Node node = model.newNode(Label.label("TblOptEncr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		log.info("TblOptIndexDir");
		final Node node = model.newNode(Label.label("TblOptIndexDir"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		log.info("TblOptInsMeth");
		final Node node = model.newNode(Label.label("TblOptInsMeth"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		log.info("TblOptKeyBlockSz");
		final Node node = model.newNode(Label.label("TblOptKeyBlockSz"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		log.info("TblOptMaxRows");
		final Node node = model.newNode(Label.label("TblOptMaxRows"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		log.info("TblOptMinRows");
		final Node node = model.newNode(Label.label("TblOptMinRows"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		log.info("TblOptPackK");
		final Node node = model.newNode(Label.label("TblOptPackK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		log.info("TblOptPasswd");
		final Node node = model.newNode(Label.label("TblOptPasswd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		log.info("TblOptRowFormat");
		final Node node = model.newNode(Label.label("TblOptRowFormat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		log.info("TblOptStatAutoR");
		final Node node = model.newNode(Label.label("TblOptStatAutoR"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		log.info("TblOptStatPersist");
		final Node node = model.newNode(Label.label("TblOptStatPersist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		log.info("TblOptStatSamplPg");
		final Node node = model.newNode(Label.label("TblOptStatSamplPg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		log.info("TblOptTablespace");
		final Node node = model.newNode(Label.label("TblOptTablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		log.info("TblOptUnion");
		final Node node = model.newNode(Label.label("TblOptUnion"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		log.info("InnerJoin");
		final Node node = model.newNode(Label.label("InnerJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		log.info("StraightJoin");
		final Node node = model.newNode(Label.label("StraightJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		log.info("OuterJoin");
		final Node node = model.newNode(Label.label("OuterJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		log.info("NaturalJoin");
		final Node node = model.newNode(Label.label("NaturalJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		log.info("Subquery");
		final Node node = model.newNode(Label.label("Subquery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		log.info("Query_expression");
		final Node node = model.newNode(Label.label("Query_expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		log.info("Query_expression_nointo");
		final Node node = model.newNode(Label.label("Query_expression_nointo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		log.info("Query_specification");
		final Node node = model.newNode(Label.label("Query_specification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		log.info("Query_specification_nointo");
		final Node node = model.newNode(Label.label("Query_specification_nointo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		log.info("Union_parenth");
		final Node node = model.newNode(Label.label("Union_parenth"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		log.info("Union_statement");
		final Node node = model.newNode(Label.label("Union_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		log.info("Select_spec");
		final Node node = model.newNode(Label.label("Select_spec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		log.info("Select_list");
		final Node node = model.newNode(Label.label("Select_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		log.info("SellistelAllCol");
		final Node node = model.newNode(Label.label("SellistelAllCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		log.info("SellistelCol");
		final Node node = model.newNode(Label.label("SellistelCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		log.info("SellistelFunc");
		final Node node = model.newNode(Label.label("SellistelFunc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		log.info("SellistelExpr");
		final Node node = model.newNode(Label.label("SellistelExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		log.info("SelectIntoVars");
		final Node node = model.newNode(Label.label("SelectIntoVars"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		log.info("SelectIntoDump");
		final Node node = model.newNode(Label.label("SelectIntoDump"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		log.info("SelectIntoOutfile");
		final Node node = model.newNode(Label.label("SelectIntoOutfile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		log.info("From_clause");
		final Node node = model.newNode(Label.label("From_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		log.info("Group_by_item");
		final Node node = model.newNode(Label.label("Group_by_item"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		log.info("Limit_clause");
		final Node node = model.newNode(Label.label("Limit_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		log.info("Start_transaction");
		final Node node = model.newNode(Label.label("Start_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		log.info("Begin_work");
		final Node node = model.newNode(Label.label("Begin_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		log.info("Commit_work");
		final Node node = model.newNode(Label.label("Commit_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		log.info("Rollback_work");
		final Node node = model.newNode(Label.label("Rollback_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		log.info("Savepoint_statement");
		final Node node = model.newNode(Label.label("Savepoint_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		log.info("Rollback_statement");
		final Node node = model.newNode(Label.label("Rollback_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		log.info("Release_statement");
		final Node node = model.newNode(Label.label("Release_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		log.info("Lock_tables");
		final Node node = model.newNode(Label.label("Lock_tables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		log.info("Unlock_tables");
		final Node node = model.newNode(Label.label("Unlock_tables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		log.info("Set_autocommit_statement");
		final Node node = model.newNode(Label.label("Set_autocommit_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		log.info("Set_transaction_statement");
		final Node node = model.newNode(Label.label("Set_transaction_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		log.info("Transact_option");
		final Node node = model.newNode(Label.label("Transact_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		log.info("Lock_table_element");
		final Node node = model.newNode(Label.label("Lock_table_element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		log.info("Trans_characteristic");
		final Node node = model.newNode(Label.label("Trans_characteristic"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		log.info("Transaction_level");
		final Node node = model.newNode(Label.label("Transaction_level"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		log.info("Change_master");
		final Node node = model.newNode(Label.label("Change_master"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		log.info("Change_repl_filter");
		final Node node = model.newNode(Label.label("Change_repl_filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		log.info("Purge_binary_logs");
		final Node node = model.newNode(Label.label("Purge_binary_logs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		log.info("Reset_master");
		final Node node = model.newNode(Label.label("Reset_master"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		log.info("Reset_slave");
		final Node node = model.newNode(Label.label("Reset_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		log.info("Start_slave");
		final Node node = model.newNode(Label.label("Start_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		log.info("Stop_slave");
		final Node node = model.newNode(Label.label("Stop_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		log.info("Start_group_repl");
		final Node node = model.newNode(Label.label("Start_group_repl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		log.info("Stop_group_repl");
		final Node node = model.newNode(Label.label("Stop_group_repl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		log.info("MasterOptString");
		final Node node = model.newNode(Label.label("MasterOptString"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		log.info("MasterOptDecimal");
		final Node node = model.newNode(Label.label("MasterOptDecimal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		log.info("MasterOptBool");
		final Node node = model.newNode(Label.label("MasterOptBool"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		log.info("MasterOptReal");
		final Node node = model.newNode(Label.label("MasterOptReal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		log.info("MasterOptIdList");
		final Node node = model.newNode(Label.label("MasterOptIdList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		log.info("String_master_option");
		final Node node = model.newNode(Label.label("String_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		log.info("Decimal_master_option");
		final Node node = model.newNode(Label.label("Decimal_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		log.info("Bool_master_option");
		final Node node = model.newNode(Label.label("Bool_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		log.info("Channel_option");
		final Node node = model.newNode(Label.label("Channel_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		log.info("ReplfilterDbList");
		final Node node = model.newNode(Label.label("ReplfilterDbList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		log.info("ReplfilterTableList");
		final Node node = model.newNode(Label.label("ReplfilterTableList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		log.info("ReplfilterStableList");
		final Node node = model.newNode(Label.label("ReplfilterStableList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		log.info("ReplfilterTablepairList");
		final Node node = model.newNode(Label.label("ReplfilterTablepairList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		log.info("Thread_type");
		final Node node = model.newNode(Label.label("Thread_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		log.info("UntilGtidSset");
		final Node node = model.newNode(Label.label("UntilGtidSset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		log.info("UntilMasterLog");
		final Node node = model.newNode(Label.label("UntilMasterLog"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		log.info("UntilRelayLog");
		final Node node = model.newNode(Label.label("UntilRelayLog"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		log.info("UntilSqlGaps");
		final Node node = model.newNode(Label.label("UntilSqlGaps"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		log.info("Start_slave_connection_option");
		final Node node = model.newNode(Label.label("Start_slave_connection_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		log.info("Gtid_set");
		final Node node = model.newNode(Label.label("Gtid_set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		log.info("Xa_start_transaction");
		final Node node = model.newNode(Label.label("Xa_start_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		log.info("Xa_end_transaction");
		final Node node = model.newNode(Label.label("Xa_end_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		log.info("Xa_prepare");
		final Node node = model.newNode(Label.label("Xa_prepare"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		log.info("Xa_commit_work");
		final Node node = model.newNode(Label.label("Xa_commit_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		log.info("Xa_rollback_work");
		final Node node = model.newNode(Label.label("Xa_rollback_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		log.info("Xa_recover_work");
		final Node node = model.newNode(Label.label("Xa_recover_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		log.info("Prepare_statement");
		final Node node = model.newNode(Label.label("Prepare_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		log.info("Execute_statement");
		final Node node = model.newNode(Label.label("Execute_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		log.info("Deallocate_prepare");
		final Node node = model.newNode(Label.label("Deallocate_prepare"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		log.info("Routine_body");
		final Node node = model.newNode(Label.label("Routine_body"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		log.info("Block_statement");
		final Node node = model.newNode(Label.label("Block_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		log.info("Case_statement");
		final Node node = model.newNode(Label.label("Case_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		log.info("If_statement");
		final Node node = model.newNode(Label.label("If_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		log.info("Iterate_statement");
		final Node node = model.newNode(Label.label("Iterate_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		log.info("Leave_statement");
		final Node node = model.newNode(Label.label("Leave_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		log.info("Loop_statement");
		final Node node = model.newNode(Label.label("Loop_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		log.info("Repeat_statement");
		final Node node = model.newNode(Label.label("Repeat_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		log.info("Return_statement");
		final Node node = model.newNode(Label.label("Return_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		log.info("While_statement");
		final Node node = model.newNode(Label.label("While_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		log.info("Cursor_statement");
		final Node node = model.newNode(Label.label("Cursor_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		log.info("Declare_variable");
		final Node node = model.newNode(Label.label("Declare_variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		log.info("Declare_condition");
		final Node node = model.newNode(Label.label("Declare_condition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		log.info("Declare_cursor");
		final Node node = model.newNode(Label.label("Declare_cursor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		log.info("Declare_handler");
		final Node node = model.newNode(Label.label("Declare_handler"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		log.info("Handler_condition_value");
		final Node node = model.newNode(Label.label("Handler_condition_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		log.info("Procedure_sql_statement");
		final Node node = model.newNode(Label.label("Procedure_sql_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		log.info("AlterUserMysql56");
		final Node node = model.newNode(Label.label("AlterUserMysql56"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		log.info("AlterUserMysql57");
		final Node node = model.newNode(Label.label("AlterUserMysql57"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		log.info("CreateUserMysql56");
		final Node node = model.newNode(Label.label("CreateUserMysql56"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		log.info("CreateUserMysql57");
		final Node node = model.newNode(Label.label("CreateUserMysql57"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		log.info("Drop_user");
		final Node node = model.newNode(Label.label("Drop_user"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		log.info("Grant_statement");
		final Node node = model.newNode(Label.label("Grant_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		log.info("Grant_proxy");
		final Node node = model.newNode(Label.label("Grant_proxy"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		log.info("Rename_user");
		final Node node = model.newNode(Label.label("Rename_user"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		log.info("DetailRevoke");
		final Node node = model.newNode(Label.label("DetailRevoke"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		log.info("ShortRevoke");
		final Node node = model.newNode(Label.label("ShortRevoke"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		log.info("Partition_options");
		final Node node = model.newNode(Label.label("Partition_options"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		log.info("Partition_function_definition");
		final Node node = model.newNode(Label.label("Partition_function_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		log.info("Linear_partition_func_def");
		final Node node = model.newNode(Label.label("Linear_partition_func_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		log.info("Partition_def");
		final Node node = model.newNode(Label.label("Partition_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		log.info("Subpartition_def");
		final Node node = model.newNode(Label.label("Subpartition_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		log.info("AlterDb");
		final Node node = model.newNode(Label.label("AlterDb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		log.info("AlterDbUpgradeName");
		final Node node = model.newNode(Label.label("AlterDbUpgradeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		log.info("Alter_event");
		final Node node = model.newNode(Label.label("Alter_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		log.info("Alter_function");
		final Node node = model.newNode(Label.label("Alter_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		log.info("Alter_instance");
		final Node node = model.newNode(Label.label("Alter_instance"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		log.info("Alter_logfile_group");
		final Node node = model.newNode(Label.label("Alter_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		log.info("Alter_procedure");
		final Node node = model.newNode(Label.label("Alter_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		log.info("Alter_server");
		final Node node = model.newNode(Label.label("Alter_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		log.info("Alter_table");
		final Node node = model.newNode(Label.label("Alter_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		log.info("Alter_tablespace");
		final Node node = model.newNode(Label.label("Alter_tablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		log.info("Alter_view");
		final Node node = model.newNode(Label.label("Alter_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		log.info("AltblTableOpt");
		final Node node = model.newNode(Label.label("AltblTableOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		log.info("AltblAddCol");
		final Node node = model.newNode(Label.label("AltblAddCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		log.info("AltblAddCols");
		final Node node = model.newNode(Label.label("AltblAddCols"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		log.info("AltblAddIndex");
		final Node node = model.newNode(Label.label("AltblAddIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		log.info("AltblAddPK");
		final Node node = model.newNode(Label.label("AltblAddPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		log.info("AltblAddUK");
		final Node node = model.newNode(Label.label("AltblAddUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		log.info("AltblAddSpecIndex");
		final Node node = model.newNode(Label.label("AltblAddSpecIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		log.info("AltblAddFK");
		final Node node = model.newNode(Label.label("AltblAddFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		log.info("AltblAlg");
		final Node node = model.newNode(Label.label("AltblAlg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		log.info("AltblColDef");
		final Node node = model.newNode(Label.label("AltblColDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		log.info("AltblColChange");
		final Node node = model.newNode(Label.label("AltblColChange"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		log.info("AltblLock");
		final Node node = model.newNode(Label.label("AltblLock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		log.info("AltblColMod");
		final Node node = model.newNode(Label.label("AltblColMod"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		log.info("AltblColDrop");
		final Node node = model.newNode(Label.label("AltblColDrop"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		log.info("AltblDropPK");
		final Node node = model.newNode(Label.label("AltblDropPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		log.info("AltblDropIndex");
		final Node node = model.newNode(Label.label("AltblDropIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		log.info("AltblDropFK");
		final Node node = model.newNode(Label.label("AltblDropFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		log.info("AltblDisKey");
		final Node node = model.newNode(Label.label("AltblDisKey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		log.info("AltblEnKey");
		final Node node = model.newNode(Label.label("AltblEnKey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		log.info("AltblRenameTbl");
		final Node node = model.newNode(Label.label("AltblRenameTbl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		log.info("AltblResort");
		final Node node = model.newNode(Label.label("AltblResort"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		log.info("AltblConvert");
		final Node node = model.newNode(Label.label("AltblConvert"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		log.info("AltblDefCharset");
		final Node node = model.newNode(Label.label("AltblDefCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		log.info("AltblDisTblspace");
		final Node node = model.newNode(Label.label("AltblDisTblspace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		log.info("AltblImpTblSpace");
		final Node node = model.newNode(Label.label("AltblImpTblSpace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		log.info("AltblForce");
		final Node node = model.newNode(Label.label("AltblForce"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		log.info("AltblValid");
		final Node node = model.newNode(Label.label("AltblValid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		log.info("AltblAddPart");
		final Node node = model.newNode(Label.label("AltblAddPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		log.info("AltblDropPart");
		final Node node = model.newNode(Label.label("AltblDropPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		log.info("AltblDiscartPart");
		final Node node = model.newNode(Label.label("AltblDiscartPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		log.info("AltblImportPart");
		final Node node = model.newNode(Label.label("AltblImportPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		log.info("AltblTruncPart");
		final Node node = model.newNode(Label.label("AltblTruncPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		log.info("AltblCoalPart");
		final Node node = model.newNode(Label.label("AltblCoalPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		log.info("AltblReorgPart");
		final Node node = model.newNode(Label.label("AltblReorgPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		log.info("AltblExchPart");
		final Node node = model.newNode(Label.label("AltblExchPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		log.info("AltblAnalPart");
		final Node node = model.newNode(Label.label("AltblAnalPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		log.info("AltblCheckPart");
		final Node node = model.newNode(Label.label("AltblCheckPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		log.info("AltblOptimPart");
		final Node node = model.newNode(Label.label("AltblOptimPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		log.info("AltblRebuildPart");
		final Node node = model.newNode(Label.label("AltblRebuildPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		log.info("AltblRepairPart");
		final Node node = model.newNode(Label.label("AltblRepairPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		log.info("AltblRemovePart");
		final Node node = model.newNode(Label.label("AltblRemovePart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		log.info("AltblUpgrPart");
		final Node node = model.newNode(Label.label("AltblUpgrPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		log.info("Drop_database");
		final Node node = model.newNode(Label.label("Drop_database"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		log.info("Drop_event");
		final Node node = model.newNode(Label.label("Drop_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		log.info("Drop_index");
		final Node node = model.newNode(Label.label("Drop_index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		log.info("Drop_logfile_group");
		final Node node = model.newNode(Label.label("Drop_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		log.info("Drop_procedure");
		final Node node = model.newNode(Label.label("Drop_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		log.info("Drop_function");
		final Node node = model.newNode(Label.label("Drop_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		log.info("Drop_server");
		final Node node = model.newNode(Label.label("Drop_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		log.info("Drop_table");
		final Node node = model.newNode(Label.label("Drop_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		log.info("Drop_tablespace");
		final Node node = model.newNode(Label.label("Drop_tablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		log.info("Drop_trigger");
		final Node node = model.newNode(Label.label("Drop_trigger"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		log.info("Drop_view");
		final Node node = model.newNode(Label.label("Drop_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		log.info("Rename_table");
		final Node node = model.newNode(Label.label("Rename_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		log.info("Truncate_table");
		final Node node = model.newNode(Label.label("Truncate_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		log.info("Call_statement");
		final Node node = model.newNode(Label.label("Call_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		log.info("Delete_statement");
		final Node node = model.newNode(Label.label("Delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		log.info("Do_statement");
		final Node node = model.newNode(Label.label("Do_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		log.info("Handler_statement");
		final Node node = model.newNode(Label.label("Handler_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		log.info("Insert_statement");
		final Node node = model.newNode(Label.label("Insert_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		log.info("Load_data_statement");
		final Node node = model.newNode(Label.label("Load_data_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		log.info("Load_xml_statement");
		final Node node = model.newNode(Label.label("Load_xml_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		log.info("Replace_statement");
		final Node node = model.newNode(Label.label("Replace_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		log.info("SimpleSelect");
		final Node node = model.newNode(Label.label("SimpleSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		log.info("ParenSelect");
		final Node node = model.newNode(Label.label("ParenSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		log.info("UnionSelect");
		final Node node = model.newNode(Label.label("UnionSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		log.info("UnionParenSelect");
		final Node node = model.newNode(Label.label("UnionParenSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		log.info("Update_statement");
		final Node node = model.newNode(Label.label("Update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		log.info("Insert_statement_value");
		final Node node = model.newNode(Label.label("Insert_statement_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		log.info("Update_elem");
		final Node node = model.newNode(Label.label("Update_elem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		log.info("Col_or_uservar");
		final Node node = model.newNode(Label.label("Col_or_uservar"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		log.info("Single_delete_statement");
		final Node node = model.newNode(Label.label("Single_delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		log.info("Multiple_delete_statement");
		final Node node = model.newNode(Label.label("Multiple_delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		log.info("Handler_open_statement");
		final Node node = model.newNode(Label.label("Handler_open_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		log.info("Handler_read_index_statement");
		final Node node = model.newNode(Label.label("Handler_read_index_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		log.info("Handler_read_statement");
		final Node node = model.newNode(Label.label("Handler_read_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		log.info("Handler_close_statement");
		final Node node = model.newNode(Label.label("Handler_close_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		log.info("Single_update_statement");
		final Node node = model.newNode(Label.label("Single_update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		log.info("Multiple_update_statement");
		final Node node = model.newNode(Label.label("Multiple_update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		log.info("Order_by_clause");
		final Node node = model.newNode(Label.label("Order_by_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		log.info("Order_by_expression");
		final Node node = model.newNode(Label.label("Order_by_expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		log.info("Table_sources");
		final Node node = model.newNode(Label.label("Table_sources"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		log.info("Table_source");
		final Node node = model.newNode(Label.label("Table_source"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		log.info("AtomTableItem");
		final Node node = model.newNode(Label.label("AtomTableItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		log.info("SubqueryTableItem");
		final Node node = model.newNode(Label.label("SubqueryTableItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		log.info("TableSourcesItem");
		final Node node = model.newNode(Label.label("TableSourcesItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		log.info("Index_hint");
		final Node node = model.newNode(Label.label("Index_hint"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		log.info("Simple_string_list");
		final Node node = model.newNode(Label.label("Simple_string_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		log.info("User_var_list");
		final Node node = model.newNode(Label.label("User_var_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		log.info("Default_value");
		final Node node = model.newNode(Label.label("Default_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		log.info("If_not_exists");
		final Node node = model.newNode(Label.label("If_not_exists"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		log.info("SpecificFunctionCall");
		final Node node = model.newNode(Label.label("SpecificFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		log.info("AggregateFunctionCall");
		final Node node = model.newNode(Label.label("AggregateFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		log.info("ScalarFunctionCall");
		final Node node = model.newNode(Label.label("ScalarFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		log.info("UdfFunctionCall");
		final Node node = model.newNode(Label.label("UdfFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		log.info("SimpleSpecificFCall");
		final Node node = model.newNode(Label.label("SimpleSpecificFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		log.info("ConvertDataTypeFCall");
		final Node node = model.newNode(Label.label("ConvertDataTypeFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		log.info("ValuesFCall");
		final Node node = model.newNode(Label.label("ValuesFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		log.info("CaseFCall");
		final Node node = model.newNode(Label.label("CaseFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		log.info("CharFCall");
		final Node node = model.newNode(Label.label("CharFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		log.info("PositionFCall");
		final Node node = model.newNode(Label.label("PositionFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		log.info("SubstrFCall");
		final Node node = model.newNode(Label.label("SubstrFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		log.info("TrimFCall");
		final Node node = model.newNode(Label.label("TrimFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		log.info("WeightFCall");
		final Node node = model.newNode(Label.label("WeightFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		log.info("ExtractFCall");
		final Node node = model.newNode(Label.label("ExtractFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		log.info("GetFormatFCall");
		final Node node = model.newNode(Label.label("GetFormatFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		log.info("LevelWeightFList");
		final Node node = model.newNode(Label.label("LevelWeightFList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		log.info("LevelWeightFRange");
		final Node node = model.newNode(Label.label("LevelWeightFRange"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		log.info("Aggregate_windowed_function");
		final Node node = model.newNode(Label.label("Aggregate_windowed_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		log.info("Scalar_function_name");
		final Node node = model.newNode(Label.label("Scalar_function_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		log.info("Function_args");
		final Node node = model.newNode(Label.label("Function_args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		log.info("Function_arg");
		final Node node = model.newNode(Label.label("Function_arg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		log.info("IsExpression");
		final Node node = model.newNode(Label.label("IsExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		log.info("LogicalExpression");
		final Node node = model.newNode(Label.label("LogicalExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		log.info("PredicateExpression");
		final Node node = model.newNode(Label.label("PredicateExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		log.info("SoundsLikePredicate");
		final Node node = model.newNode(Label.label("SoundsLikePredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		log.info("ExpressionAtomPredicate");
		final Node node = model.newNode(Label.label("ExpressionAtomPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		log.info("InPredicate");
		final Node node = model.newNode(Label.label("InPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		log.info("SubqueryComparasionPredicate");
		final Node node = model.newNode(Label.label("SubqueryComparasionPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		log.info("BetweenPredicate");
		final Node node = model.newNode(Label.label("BetweenPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		log.info("BinaryComparasionPredicate");
		final Node node = model.newNode(Label.label("BinaryComparasionPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		log.info("IsNullPredicate");
		final Node node = model.newNode(Label.label("IsNullPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		log.info("LikePredicate");
		final Node node = model.newNode(Label.label("LikePredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		log.info("RegexpPredicate");
		final Node node = model.newNode(Label.label("RegexpPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		log.info("UnaryExpressionAtom");
		final Node node = model.newNode(Label.label("UnaryExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		log.info("ExistsExpessionAtom");
		final Node node = model.newNode(Label.label("ExistsExpessionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		log.info("ConstantExpressionAtom");
		final Node node = model.newNode(Label.label("ConstantExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		log.info("FunctionCallExpressionAtom");
		final Node node = model.newNode(Label.label("FunctionCallExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		log.info("MysqlVariableExpressionAtom");
		final Node node = model.newNode(Label.label("MysqlVariableExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		log.info("BinaryExpressionAtom");
		final Node node = model.newNode(Label.label("BinaryExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		log.info("FullColumnNameExpressionAtom");
		final Node node = model.newNode(Label.label("FullColumnNameExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		log.info("DefaultExpressionAtom");
		final Node node = model.newNode(Label.label("DefaultExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		log.info("BitExpressionAtom");
		final Node node = model.newNode(Label.label("BitExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		log.info("NestedExpressionAtom");
		final Node node = model.newNode(Label.label("NestedExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		log.info("MathExpressionAtom");
		final Node node = model.newNode(Label.label("MathExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		log.info("IntervalExpressionAtom");
		final Node node = model.newNode(Label.label("IntervalExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		log.info("Unary_operator");
		final Node node = model.newNode(Label.label("Unary_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		log.info("Comparison_operator");
		final Node node = model.newNode(Label.label("Comparison_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		log.info("Logical_operator");
		final Node node = model.newNode(Label.label("Logical_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		log.info("Bit_operator");
		final Node node = model.newNode(Label.label("Bit_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		log.info("Math_operator");
		final Node node = model.newNode(Label.label("Math_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		log.info("Charset_name_base");
		final Node node = model.newNode(Label.label("Charset_name_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		log.info("Transaction_level_base");
		final Node node = model.newNode(Label.label("Transaction_level_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		log.info("Privileges_base");
		final Node node = model.newNode(Label.label("Privileges_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		log.info("Interval_type_base");
		final Node node = model.newNode(Label.label("Interval_type_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		log.info("Data_type_base");
		final Node node = model.newNode(Label.label("Data_type_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		log.info("Keywords_can_be_id");
		final Node node = model.newNode(Label.label("Keywords_can_be_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		log.info("Function_name_base");
		final Node node = model.newNode(Label.label("Function_name_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		log.info("NotExpression");
		final Node node = model.newNode(Label.label("NotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}