package com.generator.generators.mysql.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class MySqlParserNeoVisitor extends MySqlParserBaseVisitor<Node> {

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
	public Node visitNotExpression(com.generator.generators.mysql.parser.MySqlParser.NotExpressionContext arg) {
		System.out.println("NotExpression");
		final Node node = model.newNode(Label.label("NotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrRefdef(com.generator.generators.mysql.parser.MySqlParser.ColConstrRefdefContext arg) {
		System.out.println("ColConstrRefdef");
		final Node node = model.newNode(Label.label("ColConstrRefdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstrUK(com.generator.generators.mysql.parser.MySqlParser.TblConstrUKContext arg) {
		System.out.println("TblConstrUK");
		final Node node = model.newNode(Label.label("TblConstrUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstrFK(com.generator.generators.mysql.parser.MySqlParser.TblConstrFKContext arg) {
		System.out.println("TblConstrFK");
		final Node node = model.newNode(Label.label("TblConstrFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstCheck(com.generator.generators.mysql.parser.MySqlParser.TblConstCheckContext arg) {
		System.out.println("TblConstCheck");
		final Node node = model.newNode(Label.label("TblConstCheck"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference_definition(com.generator.generators.mysql.parser.MySqlParser.Reference_definitionContext arg) {
		System.out.println("Reference_definition");
		final Node node = model.newNode(Label.label("Reference_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOn_delete_action(com.generator.generators.mysql.parser.MySqlParser.On_delete_actionContext arg) {
		System.out.println("On_delete_action");
		final Node node = model.newNode(Label.label("On_delete_action"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOn_update_action(com.generator.generators.mysql.parser.MySqlParser.On_update_actionContext arg) {
		System.out.println("On_update_action");
		final Node node = model.newNode(Label.label("On_update_action"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference_action_control_type(com.generator.generators.mysql.parser.MySqlParser.Reference_action_control_typeContext arg) {
		System.out.println("Reference_action_control_type");
		final Node node = model.newNode(Label.label("Reference_action_control_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleIndex(com.generator.generators.mysql.parser.MySqlParser.SimpleIndexContext arg) {
		System.out.println("SimpleIndex");
		final Node node = model.newNode(Label.label("SimpleIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpecIndex(com.generator.generators.mysql.parser.MySqlParser.SpecIndexContext arg) {
		System.out.println("SpecIndex");
		final Node node = model.newNode(Label.label("SpecIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptEngine(com.generator.generators.mysql.parser.MySqlParser.TblOptEngineContext arg) {
		System.out.println("TblOptEngine");
		final Node node = model.newNode(Label.label("TblOptEngine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptAuInc(com.generator.generators.mysql.parser.MySqlParser.TblOptAuIncContext arg) {
		System.out.println("TblOptAuInc");
		final Node node = model.newNode(Label.label("TblOptAuInc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptAvgRLen(com.generator.generators.mysql.parser.MySqlParser.TblOptAvgRLenContext arg) {
		System.out.println("TblOptAvgRLen");
		final Node node = model.newNode(Label.label("TblOptAvgRLen"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDefCharSet(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCharSetContext arg) {
		System.out.println("TblOptDefCharSet");
		final Node node = model.newNode(Label.label("TblOptDefCharSet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptChkSum(com.generator.generators.mysql.parser.MySqlParser.TblOptChkSumContext arg) {
		System.out.println("TblOptChkSum");
		final Node node = model.newNode(Label.label("TblOptChkSum"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDefCollate(com.generator.generators.mysql.parser.MySqlParser.TblOptDefCollateContext arg) {
		System.out.println("TblOptDefCollate");
		final Node node = model.newNode(Label.label("TblOptDefCollate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptComment(com.generator.generators.mysql.parser.MySqlParser.TblOptCommentContext arg) {
		System.out.println("TblOptComment");
		final Node node = model.newNode(Label.label("TblOptComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptCompr(com.generator.generators.mysql.parser.MySqlParser.TblOptComprContext arg) {
		System.out.println("TblOptCompr");
		final Node node = model.newNode(Label.label("TblOptCompr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptConn(com.generator.generators.mysql.parser.MySqlParser.TblOptConnContext arg) {
		System.out.println("TblOptConn");
		final Node node = model.newNode(Label.label("TblOptConn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDataDir(com.generator.generators.mysql.parser.MySqlParser.TblOptDataDirContext arg) {
		System.out.println("TblOptDataDir");
		final Node node = model.newNode(Label.label("TblOptDataDir"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptDelKW(com.generator.generators.mysql.parser.MySqlParser.TblOptDelKWContext arg) {
		System.out.println("TblOptDelKW");
		final Node node = model.newNode(Label.label("TblOptDelKW"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptEncr(com.generator.generators.mysql.parser.MySqlParser.TblOptEncrContext arg) {
		System.out.println("TblOptEncr");
		final Node node = model.newNode(Label.label("TblOptEncr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptIndexDir(com.generator.generators.mysql.parser.MySqlParser.TblOptIndexDirContext arg) {
		System.out.println("TblOptIndexDir");
		final Node node = model.newNode(Label.label("TblOptIndexDir"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptInsMeth(com.generator.generators.mysql.parser.MySqlParser.TblOptInsMethContext arg) {
		System.out.println("TblOptInsMeth");
		final Node node = model.newNode(Label.label("TblOptInsMeth"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptKeyBlockSz(com.generator.generators.mysql.parser.MySqlParser.TblOptKeyBlockSzContext arg) {
		System.out.println("TblOptKeyBlockSz");
		final Node node = model.newNode(Label.label("TblOptKeyBlockSz"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptMaxRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMaxRowsContext arg) {
		System.out.println("TblOptMaxRows");
		final Node node = model.newNode(Label.label("TblOptMaxRows"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptMinRows(com.generator.generators.mysql.parser.MySqlParser.TblOptMinRowsContext arg) {
		System.out.println("TblOptMinRows");
		final Node node = model.newNode(Label.label("TblOptMinRows"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptPackK(com.generator.generators.mysql.parser.MySqlParser.TblOptPackKContext arg) {
		System.out.println("TblOptPackK");
		final Node node = model.newNode(Label.label("TblOptPackK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptPasswd(com.generator.generators.mysql.parser.MySqlParser.TblOptPasswdContext arg) {
		System.out.println("TblOptPasswd");
		final Node node = model.newNode(Label.label("TblOptPasswd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptRowFormat(com.generator.generators.mysql.parser.MySqlParser.TblOptRowFormatContext arg) {
		System.out.println("TblOptRowFormat");
		final Node node = model.newNode(Label.label("TblOptRowFormat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptStatAutoR(com.generator.generators.mysql.parser.MySqlParser.TblOptStatAutoRContext arg) {
		System.out.println("TblOptStatAutoR");
		final Node node = model.newNode(Label.label("TblOptStatAutoR"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptStatPersist(com.generator.generators.mysql.parser.MySqlParser.TblOptStatPersistContext arg) {
		System.out.println("TblOptStatPersist");
		final Node node = model.newNode(Label.label("TblOptStatPersist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptStatSamplPg(com.generator.generators.mysql.parser.MySqlParser.TblOptStatSamplPgContext arg) {
		System.out.println("TblOptStatSamplPg");
		final Node node = model.newNode(Label.label("TblOptStatSamplPg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptTablespace(com.generator.generators.mysql.parser.MySqlParser.TblOptTablespaceContext arg) {
		System.out.println("TblOptTablespace");
		final Node node = model.newNode(Label.label("TblOptTablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblOptUnion(com.generator.generators.mysql.parser.MySqlParser.TblOptUnionContext arg) {
		System.out.println("TblOptUnion");
		final Node node = model.newNode(Label.label("TblOptUnion"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartition_options(com.generator.generators.mysql.parser.MySqlParser.Partition_optionsContext arg) {
		System.out.println("Partition_options");
		final Node node = model.newNode(Label.label("Partition_options"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartition_function_definition(com.generator.generators.mysql.parser.MySqlParser.Partition_function_definitionContext arg) {
		System.out.println("Partition_function_definition");
		final Node node = model.newNode(Label.label("Partition_function_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLinear_partition_func_def(com.generator.generators.mysql.parser.MySqlParser.Linear_partition_func_defContext arg) {
		System.out.println("Linear_partition_func_def");
		final Node node = model.newNode(Label.label("Linear_partition_func_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartition_def(com.generator.generators.mysql.parser.MySqlParser.Partition_defContext arg) {
		System.out.println("Partition_def");
		final Node node = model.newNode(Label.label("Partition_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubpartition_def(com.generator.generators.mysql.parser.MySqlParser.Subpartition_defContext arg) {
		System.out.println("Subpartition_def");
		final Node node = model.newNode(Label.label("Subpartition_def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterDb(com.generator.generators.mysql.parser.MySqlParser.AlterDbContext arg) {
		System.out.println("AlterDb");
		final Node node = model.newNode(Label.label("AlterDb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterDbUpgradeName(com.generator.generators.mysql.parser.MySqlParser.AlterDbUpgradeNameContext arg) {
		System.out.println("AlterDbUpgradeName");
		final Node node = model.newNode(Label.label("AlterDbUpgradeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_event(com.generator.generators.mysql.parser.MySqlParser.Alter_eventContext arg) {
		System.out.println("Alter_event");
		final Node node = model.newNode(Label.label("Alter_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_function(com.generator.generators.mysql.parser.MySqlParser.Alter_functionContext arg) {
		System.out.println("Alter_function");
		final Node node = model.newNode(Label.label("Alter_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_instance(com.generator.generators.mysql.parser.MySqlParser.Alter_instanceContext arg) {
		System.out.println("Alter_instance");
		final Node node = model.newNode(Label.label("Alter_instance"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Alter_logfile_groupContext arg) {
		System.out.println("Alter_logfile_group");
		final Node node = model.newNode(Label.label("Alter_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_procedure(com.generator.generators.mysql.parser.MySqlParser.Alter_procedureContext arg) {
		System.out.println("Alter_procedure");
		final Node node = model.newNode(Label.label("Alter_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_server(com.generator.generators.mysql.parser.MySqlParser.Alter_serverContext arg) {
		System.out.println("Alter_server");
		final Node node = model.newNode(Label.label("Alter_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_table(com.generator.generators.mysql.parser.MySqlParser.Alter_tableContext arg) {
		System.out.println("Alter_table");
		final Node node = model.newNode(Label.label("Alter_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_tablespace(com.generator.generators.mysql.parser.MySqlParser.Alter_tablespaceContext arg) {
		System.out.println("Alter_tablespace");
		final Node node = model.newNode(Label.label("Alter_tablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlter_view(com.generator.generators.mysql.parser.MySqlParser.Alter_viewContext arg) {
		System.out.println("Alter_view");
		final Node node = model.newNode(Label.label("Alter_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblTableOpt(com.generator.generators.mysql.parser.MySqlParser.AltblTableOptContext arg) {
		System.out.println("AltblTableOpt");
		final Node node = model.newNode(Label.label("AltblTableOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddCol(com.generator.generators.mysql.parser.MySqlParser.AltblAddColContext arg) {
		System.out.println("AltblAddCol");
		final Node node = model.newNode(Label.label("AltblAddCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddCols(com.generator.generators.mysql.parser.MySqlParser.AltblAddColsContext arg) {
		System.out.println("AltblAddCols");
		final Node node = model.newNode(Label.label("AltblAddCols"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddIndexContext arg) {
		System.out.println("AltblAddIndex");
		final Node node = model.newNode(Label.label("AltblAddIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddPK(com.generator.generators.mysql.parser.MySqlParser.AltblAddPKContext arg) {
		System.out.println("AltblAddPK");
		final Node node = model.newNode(Label.label("AltblAddPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddUK(com.generator.generators.mysql.parser.MySqlParser.AltblAddUKContext arg) {
		System.out.println("AltblAddUK");
		final Node node = model.newNode(Label.label("AltblAddUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddSpecIndex(com.generator.generators.mysql.parser.MySqlParser.AltblAddSpecIndexContext arg) {
		System.out.println("AltblAddSpecIndex");
		final Node node = model.newNode(Label.label("AltblAddSpecIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddFK(com.generator.generators.mysql.parser.MySqlParser.AltblAddFKContext arg) {
		System.out.println("AltblAddFK");
		final Node node = model.newNode(Label.label("AltblAddFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAlg(com.generator.generators.mysql.parser.MySqlParser.AltblAlgContext arg) {
		System.out.println("AltblAlg");
		final Node node = model.newNode(Label.label("AltblAlg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColDef(com.generator.generators.mysql.parser.MySqlParser.AltblColDefContext arg) {
		System.out.println("AltblColDef");
		final Node node = model.newNode(Label.label("AltblColDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColChange(com.generator.generators.mysql.parser.MySqlParser.AltblColChangeContext arg) {
		System.out.println("AltblColChange");
		final Node node = model.newNode(Label.label("AltblColChange"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblLock(com.generator.generators.mysql.parser.MySqlParser.AltblLockContext arg) {
		System.out.println("AltblLock");
		final Node node = model.newNode(Label.label("AltblLock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColMod(com.generator.generators.mysql.parser.MySqlParser.AltblColModContext arg) {
		System.out.println("AltblColMod");
		final Node node = model.newNode(Label.label("AltblColMod"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblColDrop(com.generator.generators.mysql.parser.MySqlParser.AltblColDropContext arg) {
		System.out.println("AltblColDrop");
		final Node node = model.newNode(Label.label("AltblColDrop"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropPK(com.generator.generators.mysql.parser.MySqlParser.AltblDropPKContext arg) {
		System.out.println("AltblDropPK");
		final Node node = model.newNode(Label.label("AltblDropPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropIndex(com.generator.generators.mysql.parser.MySqlParser.AltblDropIndexContext arg) {
		System.out.println("AltblDropIndex");
		final Node node = model.newNode(Label.label("AltblDropIndex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropFK(com.generator.generators.mysql.parser.MySqlParser.AltblDropFKContext arg) {
		System.out.println("AltblDropFK");
		final Node node = model.newNode(Label.label("AltblDropFK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDisKey(com.generator.generators.mysql.parser.MySqlParser.AltblDisKeyContext arg) {
		System.out.println("AltblDisKey");
		final Node node = model.newNode(Label.label("AltblDisKey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblEnKey(com.generator.generators.mysql.parser.MySqlParser.AltblEnKeyContext arg) {
		System.out.println("AltblEnKey");
		final Node node = model.newNode(Label.label("AltblEnKey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRenameTbl(com.generator.generators.mysql.parser.MySqlParser.AltblRenameTblContext arg) {
		System.out.println("AltblRenameTbl");
		final Node node = model.newNode(Label.label("AltblRenameTbl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblResort(com.generator.generators.mysql.parser.MySqlParser.AltblResortContext arg) {
		System.out.println("AltblResort");
		final Node node = model.newNode(Label.label("AltblResort"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblConvert(com.generator.generators.mysql.parser.MySqlParser.AltblConvertContext arg) {
		System.out.println("AltblConvert");
		final Node node = model.newNode(Label.label("AltblConvert"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDefCharset(com.generator.generators.mysql.parser.MySqlParser.AltblDefCharsetContext arg) {
		System.out.println("AltblDefCharset");
		final Node node = model.newNode(Label.label("AltblDefCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDisTblspace(com.generator.generators.mysql.parser.MySqlParser.AltblDisTblspaceContext arg) {
		System.out.println("AltblDisTblspace");
		final Node node = model.newNode(Label.label("AltblDisTblspace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblImpTblSpace(com.generator.generators.mysql.parser.MySqlParser.AltblImpTblSpaceContext arg) {
		System.out.println("AltblImpTblSpace");
		final Node node = model.newNode(Label.label("AltblImpTblSpace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblForce(com.generator.generators.mysql.parser.MySqlParser.AltblForceContext arg) {
		System.out.println("AltblForce");
		final Node node = model.newNode(Label.label("AltblForce"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblValid(com.generator.generators.mysql.parser.MySqlParser.AltblValidContext arg) {
		System.out.println("AltblValid");
		final Node node = model.newNode(Label.label("AltblValid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAddPart(com.generator.generators.mysql.parser.MySqlParser.AltblAddPartContext arg) {
		System.out.println("AltblAddPart");
		final Node node = model.newNode(Label.label("AltblAddPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDropPart(com.generator.generators.mysql.parser.MySqlParser.AltblDropPartContext arg) {
		System.out.println("AltblDropPart");
		final Node node = model.newNode(Label.label("AltblDropPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblDiscartPart(com.generator.generators.mysql.parser.MySqlParser.AltblDiscartPartContext arg) {
		System.out.println("AltblDiscartPart");
		final Node node = model.newNode(Label.label("AltblDiscartPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblImportPart(com.generator.generators.mysql.parser.MySqlParser.AltblImportPartContext arg) {
		System.out.println("AltblImportPart");
		final Node node = model.newNode(Label.label("AltblImportPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblTruncPart(com.generator.generators.mysql.parser.MySqlParser.AltblTruncPartContext arg) {
		System.out.println("AltblTruncPart");
		final Node node = model.newNode(Label.label("AltblTruncPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblCoalPart(com.generator.generators.mysql.parser.MySqlParser.AltblCoalPartContext arg) {
		System.out.println("AltblCoalPart");
		final Node node = model.newNode(Label.label("AltblCoalPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblReorgPart(com.generator.generators.mysql.parser.MySqlParser.AltblReorgPartContext arg) {
		System.out.println("AltblReorgPart");
		final Node node = model.newNode(Label.label("AltblReorgPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblExchPart(com.generator.generators.mysql.parser.MySqlParser.AltblExchPartContext arg) {
		System.out.println("AltblExchPart");
		final Node node = model.newNode(Label.label("AltblExchPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblAnalPart(com.generator.generators.mysql.parser.MySqlParser.AltblAnalPartContext arg) {
		System.out.println("AltblAnalPart");
		final Node node = model.newNode(Label.label("AltblAnalPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblCheckPart(com.generator.generators.mysql.parser.MySqlParser.AltblCheckPartContext arg) {
		System.out.println("AltblCheckPart");
		final Node node = model.newNode(Label.label("AltblCheckPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblOptimPart(com.generator.generators.mysql.parser.MySqlParser.AltblOptimPartContext arg) {
		System.out.println("AltblOptimPart");
		final Node node = model.newNode(Label.label("AltblOptimPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRebuildPart(com.generator.generators.mysql.parser.MySqlParser.AltblRebuildPartContext arg) {
		System.out.println("AltblRebuildPart");
		final Node node = model.newNode(Label.label("AltblRebuildPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRepairPart(com.generator.generators.mysql.parser.MySqlParser.AltblRepairPartContext arg) {
		System.out.println("AltblRepairPart");
		final Node node = model.newNode(Label.label("AltblRepairPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblRemovePart(com.generator.generators.mysql.parser.MySqlParser.AltblRemovePartContext arg) {
		System.out.println("AltblRemovePart");
		final Node node = model.newNode(Label.label("AltblRemovePart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltblUpgrPart(com.generator.generators.mysql.parser.MySqlParser.AltblUpgrPartContext arg) {
		System.out.println("AltblUpgrPart");
		final Node node = model.newNode(Label.label("AltblUpgrPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_database(com.generator.generators.mysql.parser.MySqlParser.Drop_databaseContext arg) {
		System.out.println("Drop_database");
		final Node node = model.newNode(Label.label("Drop_database"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_event(com.generator.generators.mysql.parser.MySqlParser.Drop_eventContext arg) {
		System.out.println("Drop_event");
		final Node node = model.newNode(Label.label("Drop_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_index(com.generator.generators.mysql.parser.MySqlParser.Drop_indexContext arg) {
		System.out.println("Drop_index");
		final Node node = model.newNode(Label.label("Drop_index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Drop_logfile_groupContext arg) {
		System.out.println("Drop_logfile_group");
		final Node node = model.newNode(Label.label("Drop_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_procedure(com.generator.generators.mysql.parser.MySqlParser.Drop_procedureContext arg) {
		System.out.println("Drop_procedure");
		final Node node = model.newNode(Label.label("Drop_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_function(com.generator.generators.mysql.parser.MySqlParser.Drop_functionContext arg) {
		System.out.println("Drop_function");
		final Node node = model.newNode(Label.label("Drop_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_server(com.generator.generators.mysql.parser.MySqlParser.Drop_serverContext arg) {
		System.out.println("Drop_server");
		final Node node = model.newNode(Label.label("Drop_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_table(com.generator.generators.mysql.parser.MySqlParser.Drop_tableContext arg) {
		System.out.println("Drop_table");
		final Node node = model.newNode(Label.label("Drop_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_tablespace(com.generator.generators.mysql.parser.MySqlParser.Drop_tablespaceContext arg) {
		System.out.println("Drop_tablespace");
		final Node node = model.newNode(Label.label("Drop_tablespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_trigger(com.generator.generators.mysql.parser.MySqlParser.Drop_triggerContext arg) {
		System.out.println("Drop_trigger");
		final Node node = model.newNode(Label.label("Drop_trigger"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_view(com.generator.generators.mysql.parser.MySqlParser.Drop_viewContext arg) {
		System.out.println("Drop_view");
		final Node node = model.newNode(Label.label("Drop_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRename_table(com.generator.generators.mysql.parser.MySqlParser.Rename_tableContext arg) {
		System.out.println("Rename_table");
		final Node node = model.newNode(Label.label("Rename_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTruncate_table(com.generator.generators.mysql.parser.MySqlParser.Truncate_tableContext arg) {
		System.out.println("Truncate_table");
		final Node node = model.newNode(Label.label("Truncate_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCall_statement(com.generator.generators.mysql.parser.MySqlParser.Call_statementContext arg) {
		System.out.println("Call_statement");
		final Node node = model.newNode(Label.label("Call_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelete_statement(com.generator.generators.mysql.parser.MySqlParser.Delete_statementContext arg) {
		System.out.println("Delete_statement");
		final Node node = model.newNode(Label.label("Delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDo_statement(com.generator.generators.mysql.parser.MySqlParser.Do_statementContext arg) {
		System.out.println("Do_statement");
		final Node node = model.newNode(Label.label("Do_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_statementContext arg) {
		System.out.println("Handler_statement");
		final Node node = model.newNode(Label.label("Handler_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInsert_statement(com.generator.generators.mysql.parser.MySqlParser.Insert_statementContext arg) {
		System.out.println("Insert_statement");
		final Node node = model.newNode(Label.label("Insert_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_data_statement(com.generator.generators.mysql.parser.MySqlParser.Load_data_statementContext arg) {
		System.out.println("Load_data_statement");
		final Node node = model.newNode(Label.label("Load_data_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_xml_statement(com.generator.generators.mysql.parser.MySqlParser.Load_xml_statementContext arg) {
		System.out.println("Load_xml_statement");
		final Node node = model.newNode(Label.label("Load_xml_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplace_statement(com.generator.generators.mysql.parser.MySqlParser.Replace_statementContext arg) {
		System.out.println("Replace_statement");
		final Node node = model.newNode(Label.label("Replace_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSelect(com.generator.generators.mysql.parser.MySqlParser.SimpleSelectContext arg) {
		System.out.println("SimpleSelect");
		final Node node = model.newNode(Label.label("SimpleSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRoot(com.generator.generators.mysql.parser.MySqlParser.RootContext arg) {
		System.out.println("Root");
		final Node node = model.newNode(Label.label("Root"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSql_statements(com.generator.generators.mysql.parser.MySqlParser.Sql_statementsContext arg) {
		System.out.println("Sql_statements");
		final Node node = model.newNode(Label.label("Sql_statements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSql_statement(com.generator.generators.mysql.parser.MySqlParser.Sql_statementContext arg) {
		System.out.println("Sql_statement");
		final Node node = model.newNode(Label.label("Sql_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmpty_statement(com.generator.generators.mysql.parser.MySqlParser.Empty_statementContext arg) {
		System.out.println("Empty_statement");
		final Node node = model.newNode(Label.label("Empty_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDdl_statement(com.generator.generators.mysql.parser.MySqlParser.Ddl_statementContext arg) {
		System.out.println("Ddl_statement");
		final Node node = model.newNode(Label.label("Ddl_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDml_statement(com.generator.generators.mysql.parser.MySqlParser.Dml_statementContext arg) {
		System.out.println("Dml_statement");
		final Node node = model.newNode(Label.label("Dml_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransaction_statement(com.generator.generators.mysql.parser.MySqlParser.Transaction_statementContext arg) {
		System.out.println("Transaction_statement");
		final Node node = model.newNode(Label.label("Transaction_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplication_statement(com.generator.generators.mysql.parser.MySqlParser.Replication_statementContext arg) {
		System.out.println("Replication_statement");
		final Node node = model.newNode(Label.label("Replication_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrepared_statement(com.generator.generators.mysql.parser.MySqlParser.Prepared_statementContext arg) {
		System.out.println("Prepared_statement");
		final Node node = model.newNode(Label.label("Prepared_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompound_statement(com.generator.generators.mysql.parser.MySqlParser.Compound_statementContext arg) {
		System.out.println("Compound_statement");
		final Node node = model.newNode(Label.label("Compound_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAdministration_statement(com.generator.generators.mysql.parser.MySqlParser.Administration_statementContext arg) {
		System.out.println("Administration_statement");
		final Node node = model.newNode(Label.label("Administration_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUtility_statement(com.generator.generators.mysql.parser.MySqlParser.Utility_statementContext arg) {
		System.out.println("Utility_statement");
		final Node node = model.newNode(Label.label("Utility_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_database(com.generator.generators.mysql.parser.MySqlParser.Create_databaseContext arg) {
		System.out.println("Create_database");
		final Node node = model.newNode(Label.label("Create_database"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_event(com.generator.generators.mysql.parser.MySqlParser.Create_eventContext arg) {
		System.out.println("Create_event");
		final Node node = model.newNode(Label.label("Create_event"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_index(com.generator.generators.mysql.parser.MySqlParser.Create_indexContext arg) {
		System.out.println("Create_index");
		final Node node = model.newNode(Label.label("Create_index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_logfile_group(com.generator.generators.mysql.parser.MySqlParser.Create_logfile_groupContext arg) {
		System.out.println("Create_logfile_group");
		final Node node = model.newNode(Label.label("Create_logfile_group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_procedure(com.generator.generators.mysql.parser.MySqlParser.Create_procedureContext arg) {
		System.out.println("Create_procedure");
		final Node node = model.newNode(Label.label("Create_procedure"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_function(com.generator.generators.mysql.parser.MySqlParser.Create_functionContext arg) {
		System.out.println("Create_function");
		final Node node = model.newNode(Label.label("Create_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_server(com.generator.generators.mysql.parser.MySqlParser.Create_serverContext arg) {
		System.out.println("Create_server");
		final Node node = model.newNode(Label.label("Create_server"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCopyCreateTable(com.generator.generators.mysql.parser.MySqlParser.CopyCreateTableContext arg) {
		System.out.println("CopyCreateTable");
		final Node node = model.newNode(Label.label("CopyCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQueryCreateTable(com.generator.generators.mysql.parser.MySqlParser.QueryCreateTableContext arg) {
		System.out.println("QueryCreateTable");
		final Node node = model.newNode(Label.label("QueryCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColCreateTable(com.generator.generators.mysql.parser.MySqlParser.ColCreateTableContext arg) {
		System.out.println("ColCreateTable");
		final Node node = model.newNode(Label.label("ColCreateTable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_tablespace_innodb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_innodbContext arg) {
		System.out.println("Create_tablespace_innodb");
		final Node node = model.newNode(Label.label("Create_tablespace_innodb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_tablespace_ndb(com.generator.generators.mysql.parser.MySqlParser.Create_tablespace_ndbContext arg) {
		System.out.println("Create_tablespace_ndb");
		final Node node = model.newNode(Label.label("Create_tablespace_ndb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_trigger(com.generator.generators.mysql.parser.MySqlParser.Create_triggerContext arg) {
		System.out.println("Create_trigger");
		final Node node = model.newNode(Label.label("Create_trigger"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_view(com.generator.generators.mysql.parser.MySqlParser.Create_viewContext arg) {
		System.out.println("Create_view");
		final Node node = model.newNode(Label.label("Create_view"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_database_option(com.generator.generators.mysql.parser.MySqlParser.Create_database_optionContext arg) {
		System.out.println("Create_database_option");
		final Node node = model.newNode(Label.label("Create_database_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOwner_statement(com.generator.generators.mysql.parser.MySqlParser.Owner_statementContext arg) {
		System.out.println("Owner_statement");
		final Node node = model.newNode(Label.label("Owner_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPreciseSchedule(com.generator.generators.mysql.parser.MySqlParser.PreciseScheduleContext arg) {
		System.out.println("PreciseSchedule");
		final Node node = model.newNode(Label.label("PreciseSchedule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntervalSchedule(com.generator.generators.mysql.parser.MySqlParser.IntervalScheduleContext arg) {
		System.out.println("IntervalSchedule");
		final Node node = model.newNode(Label.label("IntervalSchedule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTimestamp_value(com.generator.generators.mysql.parser.MySqlParser.Timestamp_valueContext arg) {
		System.out.println("Timestamp_value");
		final Node node = model.newNode(Label.label("Timestamp_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterval_expr(com.generator.generators.mysql.parser.MySqlParser.Interval_exprContext arg) {
		System.out.println("Interval_expr");
		final Node node = model.newNode(Label.label("Interval_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterval_type(com.generator.generators.mysql.parser.MySqlParser.Interval_typeContext arg) {
		System.out.println("Interval_type");
		final Node node = model.newNode(Label.label("Interval_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_type(com.generator.generators.mysql.parser.MySqlParser.Index_typeContext arg) {
		System.out.println("Index_type");
		final Node node = model.newNode(Label.label("Index_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_option(com.generator.generators.mysql.parser.MySqlParser.Index_optionContext arg) {
		System.out.println("Index_option");
		final Node node = model.newNode(Label.label("Index_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProc_param(com.generator.generators.mysql.parser.MySqlParser.Proc_paramContext arg) {
		System.out.println("Proc_param");
		final Node node = model.newNode(Label.label("Proc_param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunc_param(com.generator.generators.mysql.parser.MySqlParser.Func_paramContext arg) {
		System.out.println("Func_param");
		final Node node = model.newNode(Label.label("Func_param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcComment(com.generator.generators.mysql.parser.MySqlParser.RcCommentContext arg) {
		System.out.println("RcComment");
		final Node node = model.newNode(Label.label("RcComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcSqllang(com.generator.generators.mysql.parser.MySqlParser.RcSqllangContext arg) {
		System.out.println("RcSqllang");
		final Node node = model.newNode(Label.label("RcSqllang"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcDeterm(com.generator.generators.mysql.parser.MySqlParser.RcDetermContext arg) {
		System.out.println("RcDeterm");
		final Node node = model.newNode(Label.label("RcDeterm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcSqldata(com.generator.generators.mysql.parser.MySqlParser.RcSqldataContext arg) {
		System.out.println("RcSqldata");
		final Node node = model.newNode(Label.label("RcSqldata"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRcSecurestmt(com.generator.generators.mysql.parser.MySqlParser.RcSecurestmtContext arg) {
		System.out.println("RcSecurestmt");
		final Node node = model.newNode(Label.label("RcSecurestmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitServer_option(com.generator.generators.mysql.parser.MySqlParser.Server_optionContext arg) {
		System.out.println("Server_option");
		final Node node = model.newNode(Label.label("Server_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColumn_def_table_constraints(com.generator.generators.mysql.parser.MySqlParser.Column_def_table_constraintsContext arg) {
		System.out.println("Column_def_table_constraints");
		final Node node = model.newNode(Label.label("Column_def_table_constraints"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColumnDefinition(com.generator.generators.mysql.parser.MySqlParser.ColumnDefinitionContext arg) {
		System.out.println("ColumnDefinition");
		final Node node = model.newNode(Label.label("ColumnDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstraintDefinition(com.generator.generators.mysql.parser.MySqlParser.ConstraintDefinitionContext arg) {
		System.out.println("ConstraintDefinition");
		final Node node = model.newNode(Label.label("ConstraintDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndexDefinition(com.generator.generators.mysql.parser.MySqlParser.IndexDefinitionContext arg) {
		System.out.println("IndexDefinition");
		final Node node = model.newNode(Label.label("IndexDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColumn_definition(com.generator.generators.mysql.parser.MySqlParser.Column_definitionContext arg) {
		System.out.println("Column_definition");
		final Node node = model.newNode(Label.label("Column_definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrNull(com.generator.generators.mysql.parser.MySqlParser.ColConstrNullContext arg) {
		System.out.println("ColConstrNull");
		final Node node = model.newNode(Label.label("ColConstrNull"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrDflt(com.generator.generators.mysql.parser.MySqlParser.ColConstrDfltContext arg) {
		System.out.println("ColConstrDflt");
		final Node node = model.newNode(Label.label("ColConstrDflt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrAuInc(com.generator.generators.mysql.parser.MySqlParser.ColConstrAuIncContext arg) {
		System.out.println("ColConstrAuInc");
		final Node node = model.newNode(Label.label("ColConstrAuInc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrPK(com.generator.generators.mysql.parser.MySqlParser.ColConstrPKContext arg) {
		System.out.println("ColConstrPK");
		final Node node = model.newNode(Label.label("ColConstrPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrUK(com.generator.generators.mysql.parser.MySqlParser.ColConstrUKContext arg) {
		System.out.println("ColConstrUK");
		final Node node = model.newNode(Label.label("ColConstrUK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrComment(com.generator.generators.mysql.parser.MySqlParser.ColConstrCommentContext arg) {
		System.out.println("ColConstrComment");
		final Node node = model.newNode(Label.label("ColConstrComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrForm(com.generator.generators.mysql.parser.MySqlParser.ColConstrFormContext arg) {
		System.out.println("ColConstrForm");
		final Node node = model.newNode(Label.label("ColConstrForm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitColConstrStorage(com.generator.generators.mysql.parser.MySqlParser.ColConstrStorageContext arg) {
		System.out.println("ColConstrStorage");
		final Node node = model.newNode(Label.label("ColConstrStorage"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTblConstrPK(com.generator.generators.mysql.parser.MySqlParser.TblConstrPKContext arg) {
		System.out.println("TblConstrPK");
		final Node node = model.newNode(Label.label("TblConstrPK"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenSelect(com.generator.generators.mysql.parser.MySqlParser.ParenSelectContext arg) {
		System.out.println("ParenSelect");
		final Node node = model.newNode(Label.label("ParenSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnionSelect(com.generator.generators.mysql.parser.MySqlParser.UnionSelectContext arg) {
		System.out.println("UnionSelect");
		final Node node = model.newNode(Label.label("UnionSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnionParenSelect(com.generator.generators.mysql.parser.MySqlParser.UnionParenSelectContext arg) {
		System.out.println("UnionParenSelect");
		final Node node = model.newNode(Label.label("UnionParenSelect"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdate_statement(com.generator.generators.mysql.parser.MySqlParser.Update_statementContext arg) {
		System.out.println("Update_statement");
		final Node node = model.newNode(Label.label("Update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInsert_statement_value(com.generator.generators.mysql.parser.MySqlParser.Insert_statement_valueContext arg) {
		System.out.println("Insert_statement_value");
		final Node node = model.newNode(Label.label("Insert_statement_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdate_elem(com.generator.generators.mysql.parser.MySqlParser.Update_elemContext arg) {
		System.out.println("Update_elem");
		final Node node = model.newNode(Label.label("Update_elem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCol_or_uservar(com.generator.generators.mysql.parser.MySqlParser.Col_or_uservarContext arg) {
		System.out.println("Col_or_uservar");
		final Node node = model.newNode(Label.label("Col_or_uservar"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingle_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Single_delete_statementContext arg) {
		System.out.println("Single_delete_statement");
		final Node node = model.newNode(Label.label("Single_delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiple_delete_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_delete_statementContext arg) {
		System.out.println("Multiple_delete_statement");
		final Node node = model.newNode(Label.label("Multiple_delete_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_open_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_open_statementContext arg) {
		System.out.println("Handler_open_statement");
		final Node node = model.newNode(Label.label("Handler_open_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_read_index_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_index_statementContext arg) {
		System.out.println("Handler_read_index_statement");
		final Node node = model.newNode(Label.label("Handler_read_index_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_read_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_read_statementContext arg) {
		System.out.println("Handler_read_statement");
		final Node node = model.newNode(Label.label("Handler_read_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_close_statement(com.generator.generators.mysql.parser.MySqlParser.Handler_close_statementContext arg) {
		System.out.println("Handler_close_statement");
		final Node node = model.newNode(Label.label("Handler_close_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingle_update_statement(com.generator.generators.mysql.parser.MySqlParser.Single_update_statementContext arg) {
		System.out.println("Single_update_statement");
		final Node node = model.newNode(Label.label("Single_update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiple_update_statement(com.generator.generators.mysql.parser.MySqlParser.Multiple_update_statementContext arg) {
		System.out.println("Multiple_update_statement");
		final Node node = model.newNode(Label.label("Multiple_update_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder_by_clause(com.generator.generators.mysql.parser.MySqlParser.Order_by_clauseContext arg) {
		System.out.println("Order_by_clause");
		final Node node = model.newNode(Label.label("Order_by_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder_by_expression(com.generator.generators.mysql.parser.MySqlParser.Order_by_expressionContext arg) {
		System.out.println("Order_by_expression");
		final Node node = model.newNode(Label.label("Order_by_expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_sources(com.generator.generators.mysql.parser.MySqlParser.Table_sourcesContext arg) {
		System.out.println("Table_sources");
		final Node node = model.newNode(Label.label("Table_sources"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_source(com.generator.generators.mysql.parser.MySqlParser.Table_sourceContext arg) {
		System.out.println("Table_source");
		final Node node = model.newNode(Label.label("Table_source"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtomTableItem(com.generator.generators.mysql.parser.MySqlParser.AtomTableItemContext arg) {
		System.out.println("AtomTableItem");
		final Node node = model.newNode(Label.label("AtomTableItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubqueryTableItem(com.generator.generators.mysql.parser.MySqlParser.SubqueryTableItemContext arg) {
		System.out.println("SubqueryTableItem");
		final Node node = model.newNode(Label.label("SubqueryTableItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTableSourcesItem(com.generator.generators.mysql.parser.MySqlParser.TableSourcesItemContext arg) {
		System.out.println("TableSourcesItem");
		final Node node = model.newNode(Label.label("TableSourcesItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_hint(com.generator.generators.mysql.parser.MySqlParser.Index_hintContext arg) {
		System.out.println("Index_hint");
		final Node node = model.newNode(Label.label("Index_hint"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInnerJoin(com.generator.generators.mysql.parser.MySqlParser.InnerJoinContext arg) {
		System.out.println("InnerJoin");
		final Node node = model.newNode(Label.label("InnerJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStraightJoin(com.generator.generators.mysql.parser.MySqlParser.StraightJoinContext arg) {
		System.out.println("StraightJoin");
		final Node node = model.newNode(Label.label("StraightJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOuterJoin(com.generator.generators.mysql.parser.MySqlParser.OuterJoinContext arg) {
		System.out.println("OuterJoin");
		final Node node = model.newNode(Label.label("OuterJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNaturalJoin(com.generator.generators.mysql.parser.MySqlParser.NaturalJoinContext arg) {
		System.out.println("NaturalJoin");
		final Node node = model.newNode(Label.label("NaturalJoin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubquery(com.generator.generators.mysql.parser.MySqlParser.SubqueryContext arg) {
		System.out.println("Subquery");
		final Node node = model.newNode(Label.label("Subquery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_expression(com.generator.generators.mysql.parser.MySqlParser.Query_expressionContext arg) {
		System.out.println("Query_expression");
		final Node node = model.newNode(Label.label("Query_expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_expression_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_expression_nointoContext arg) {
		System.out.println("Query_expression_nointo");
		final Node node = model.newNode(Label.label("Query_expression_nointo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_specification(com.generator.generators.mysql.parser.MySqlParser.Query_specificationContext arg) {
		System.out.println("Query_specification");
		final Node node = model.newNode(Label.label("Query_specification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery_specification_nointo(com.generator.generators.mysql.parser.MySqlParser.Query_specification_nointoContext arg) {
		System.out.println("Query_specification_nointo");
		final Node node = model.newNode(Label.label("Query_specification_nointo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion_parenth(com.generator.generators.mysql.parser.MySqlParser.Union_parenthContext arg) {
		System.out.println("Union_parenth");
		final Node node = model.newNode(Label.label("Union_parenth"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion_statement(com.generator.generators.mysql.parser.MySqlParser.Union_statementContext arg) {
		System.out.println("Union_statement");
		final Node node = model.newNode(Label.label("Union_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelect_spec(com.generator.generators.mysql.parser.MySqlParser.Select_specContext arg) {
		System.out.println("Select_spec");
		final Node node = model.newNode(Label.label("Select_spec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelect_list(com.generator.generators.mysql.parser.MySqlParser.Select_listContext arg) {
		System.out.println("Select_list");
		final Node node = model.newNode(Label.label("Select_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelAllCol(com.generator.generators.mysql.parser.MySqlParser.SellistelAllColContext arg) {
		System.out.println("SellistelAllCol");
		final Node node = model.newNode(Label.label("SellistelAllCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelCol(com.generator.generators.mysql.parser.MySqlParser.SellistelColContext arg) {
		System.out.println("SellistelCol");
		final Node node = model.newNode(Label.label("SellistelCol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelFunc(com.generator.generators.mysql.parser.MySqlParser.SellistelFuncContext arg) {
		System.out.println("SellistelFunc");
		final Node node = model.newNode(Label.label("SellistelFunc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSellistelExpr(com.generator.generators.mysql.parser.MySqlParser.SellistelExprContext arg) {
		System.out.println("SellistelExpr");
		final Node node = model.newNode(Label.label("SellistelExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectIntoVars(com.generator.generators.mysql.parser.MySqlParser.SelectIntoVarsContext arg) {
		System.out.println("SelectIntoVars");
		final Node node = model.newNode(Label.label("SelectIntoVars"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectIntoDump(com.generator.generators.mysql.parser.MySqlParser.SelectIntoDumpContext arg) {
		System.out.println("SelectIntoDump");
		final Node node = model.newNode(Label.label("SelectIntoDump"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectIntoOutfile(com.generator.generators.mysql.parser.MySqlParser.SelectIntoOutfileContext arg) {
		System.out.println("SelectIntoOutfile");
		final Node node = model.newNode(Label.label("SelectIntoOutfile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFrom_clause(com.generator.generators.mysql.parser.MySqlParser.From_clauseContext arg) {
		System.out.println("From_clause");
		final Node node = model.newNode(Label.label("From_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroup_by_item(com.generator.generators.mysql.parser.MySqlParser.Group_by_itemContext arg) {
		System.out.println("Group_by_item");
		final Node node = model.newNode(Label.label("Group_by_item"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimit_clause(com.generator.generators.mysql.parser.MySqlParser.Limit_clauseContext arg) {
		System.out.println("Limit_clause");
		final Node node = model.newNode(Label.label("Limit_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_transaction(com.generator.generators.mysql.parser.MySqlParser.Start_transactionContext arg) {
		System.out.println("Start_transaction");
		final Node node = model.newNode(Label.label("Start_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBegin_work(com.generator.generators.mysql.parser.MySqlParser.Begin_workContext arg) {
		System.out.println("Begin_work");
		final Node node = model.newNode(Label.label("Begin_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommit_work(com.generator.generators.mysql.parser.MySqlParser.Commit_workContext arg) {
		System.out.println("Commit_work");
		final Node node = model.newNode(Label.label("Commit_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRollback_work(com.generator.generators.mysql.parser.MySqlParser.Rollback_workContext arg) {
		System.out.println("Rollback_work");
		final Node node = model.newNode(Label.label("Rollback_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSavepoint_statement(com.generator.generators.mysql.parser.MySqlParser.Savepoint_statementContext arg) {
		System.out.println("Savepoint_statement");
		final Node node = model.newNode(Label.label("Savepoint_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRollback_statement(com.generator.generators.mysql.parser.MySqlParser.Rollback_statementContext arg) {
		System.out.println("Rollback_statement");
		final Node node = model.newNode(Label.label("Rollback_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelease_statement(com.generator.generators.mysql.parser.MySqlParser.Release_statementContext arg) {
		System.out.println("Release_statement");
		final Node node = model.newNode(Label.label("Release_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLock_tables(com.generator.generators.mysql.parser.MySqlParser.Lock_tablesContext arg) {
		System.out.println("Lock_tables");
		final Node node = model.newNode(Label.label("Lock_tables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnlock_tables(com.generator.generators.mysql.parser.MySqlParser.Unlock_tablesContext arg) {
		System.out.println("Unlock_tables");
		final Node node = model.newNode(Label.label("Unlock_tables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_autocommit_statement(com.generator.generators.mysql.parser.MySqlParser.Set_autocommit_statementContext arg) {
		System.out.println("Set_autocommit_statement");
		final Node node = model.newNode(Label.label("Set_autocommit_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_transaction_statement(com.generator.generators.mysql.parser.MySqlParser.Set_transaction_statementContext arg) {
		System.out.println("Set_transaction_statement");
		final Node node = model.newNode(Label.label("Set_transaction_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransact_option(com.generator.generators.mysql.parser.MySqlParser.Transact_optionContext arg) {
		System.out.println("Transact_option");
		final Node node = model.newNode(Label.label("Transact_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLock_table_element(com.generator.generators.mysql.parser.MySqlParser.Lock_table_elementContext arg) {
		System.out.println("Lock_table_element");
		final Node node = model.newNode(Label.label("Lock_table_element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrans_characteristic(com.generator.generators.mysql.parser.MySqlParser.Trans_characteristicContext arg) {
		System.out.println("Trans_characteristic");
		final Node node = model.newNode(Label.label("Trans_characteristic"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransaction_level(com.generator.generators.mysql.parser.MySqlParser.Transaction_levelContext arg) {
		System.out.println("Transaction_level");
		final Node node = model.newNode(Label.label("Transaction_level"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChange_master(com.generator.generators.mysql.parser.MySqlParser.Change_masterContext arg) {
		System.out.println("Change_master");
		final Node node = model.newNode(Label.label("Change_master"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChange_repl_filter(com.generator.generators.mysql.parser.MySqlParser.Change_repl_filterContext arg) {
		System.out.println("Change_repl_filter");
		final Node node = model.newNode(Label.label("Change_repl_filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPurge_binary_logs(com.generator.generators.mysql.parser.MySqlParser.Purge_binary_logsContext arg) {
		System.out.println("Purge_binary_logs");
		final Node node = model.newNode(Label.label("Purge_binary_logs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReset_master(com.generator.generators.mysql.parser.MySqlParser.Reset_masterContext arg) {
		System.out.println("Reset_master");
		final Node node = model.newNode(Label.label("Reset_master"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReset_slave(com.generator.generators.mysql.parser.MySqlParser.Reset_slaveContext arg) {
		System.out.println("Reset_slave");
		final Node node = model.newNode(Label.label("Reset_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_slave(com.generator.generators.mysql.parser.MySqlParser.Start_slaveContext arg) {
		System.out.println("Start_slave");
		final Node node = model.newNode(Label.label("Start_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStop_slave(com.generator.generators.mysql.parser.MySqlParser.Stop_slaveContext arg) {
		System.out.println("Stop_slave");
		final Node node = model.newNode(Label.label("Stop_slave"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_group_repl(com.generator.generators.mysql.parser.MySqlParser.Start_group_replContext arg) {
		System.out.println("Start_group_repl");
		final Node node = model.newNode(Label.label("Start_group_repl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStop_group_repl(com.generator.generators.mysql.parser.MySqlParser.Stop_group_replContext arg) {
		System.out.println("Stop_group_repl");
		final Node node = model.newNode(Label.label("Stop_group_repl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptString(com.generator.generators.mysql.parser.MySqlParser.MasterOptStringContext arg) {
		System.out.println("MasterOptString");
		final Node node = model.newNode(Label.label("MasterOptString"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptDecimal(com.generator.generators.mysql.parser.MySqlParser.MasterOptDecimalContext arg) {
		System.out.println("MasterOptDecimal");
		final Node node = model.newNode(Label.label("MasterOptDecimal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptBool(com.generator.generators.mysql.parser.MySqlParser.MasterOptBoolContext arg) {
		System.out.println("MasterOptBool");
		final Node node = model.newNode(Label.label("MasterOptBool"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptReal(com.generator.generators.mysql.parser.MySqlParser.MasterOptRealContext arg) {
		System.out.println("MasterOptReal");
		final Node node = model.newNode(Label.label("MasterOptReal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMasterOptIdList(com.generator.generators.mysql.parser.MySqlParser.MasterOptIdListContext arg) {
		System.out.println("MasterOptIdList");
		final Node node = model.newNode(Label.label("MasterOptIdList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString_master_option(com.generator.generators.mysql.parser.MySqlParser.String_master_optionContext arg) {
		System.out.println("String_master_option");
		final Node node = model.newNode(Label.label("String_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecimal_master_option(com.generator.generators.mysql.parser.MySqlParser.Decimal_master_optionContext arg) {
		System.out.println("Decimal_master_option");
		final Node node = model.newNode(Label.label("Decimal_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBool_master_option(com.generator.generators.mysql.parser.MySqlParser.Bool_master_optionContext arg) {
		System.out.println("Bool_master_option");
		final Node node = model.newNode(Label.label("Bool_master_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChannel_option(com.generator.generators.mysql.parser.MySqlParser.Channel_optionContext arg) {
		System.out.println("Channel_option");
		final Node node = model.newNode(Label.label("Channel_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterDbList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterDbListContext arg) {
		System.out.println("ReplfilterDbList");
		final Node node = model.newNode(Label.label("ReplfilterDbList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterTableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTableListContext arg) {
		System.out.println("ReplfilterTableList");
		final Node node = model.newNode(Label.label("ReplfilterTableList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterStableList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterStableListContext arg) {
		System.out.println("ReplfilterStableList");
		final Node node = model.newNode(Label.label("ReplfilterStableList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReplfilterTablepairList(com.generator.generators.mysql.parser.MySqlParser.ReplfilterTablepairListContext arg) {
		System.out.println("ReplfilterTablepairList");
		final Node node = model.newNode(Label.label("ReplfilterTablepairList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThread_type(com.generator.generators.mysql.parser.MySqlParser.Thread_typeContext arg) {
		System.out.println("Thread_type");
		final Node node = model.newNode(Label.label("Thread_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilGtidSset(com.generator.generators.mysql.parser.MySqlParser.UntilGtidSsetContext arg) {
		System.out.println("UntilGtidSset");
		final Node node = model.newNode(Label.label("UntilGtidSset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilMasterLog(com.generator.generators.mysql.parser.MySqlParser.UntilMasterLogContext arg) {
		System.out.println("UntilMasterLog");
		final Node node = model.newNode(Label.label("UntilMasterLog"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilRelayLog(com.generator.generators.mysql.parser.MySqlParser.UntilRelayLogContext arg) {
		System.out.println("UntilRelayLog");
		final Node node = model.newNode(Label.label("UntilRelayLog"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUntilSqlGaps(com.generator.generators.mysql.parser.MySqlParser.UntilSqlGapsContext arg) {
		System.out.println("UntilSqlGaps");
		final Node node = model.newNode(Label.label("UntilSqlGaps"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStart_slave_connection_option(com.generator.generators.mysql.parser.MySqlParser.Start_slave_connection_optionContext arg) {
		System.out.println("Start_slave_connection_option");
		final Node node = model.newNode(Label.label("Start_slave_connection_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGtid_set(com.generator.generators.mysql.parser.MySqlParser.Gtid_setContext arg) {
		System.out.println("Gtid_set");
		final Node node = model.newNode(Label.label("Gtid_set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_start_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_start_transactionContext arg) {
		System.out.println("Xa_start_transaction");
		final Node node = model.newNode(Label.label("Xa_start_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_end_transaction(com.generator.generators.mysql.parser.MySqlParser.Xa_end_transactionContext arg) {
		System.out.println("Xa_end_transaction");
		final Node node = model.newNode(Label.label("Xa_end_transaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_prepare(com.generator.generators.mysql.parser.MySqlParser.Xa_prepareContext arg) {
		System.out.println("Xa_prepare");
		final Node node = model.newNode(Label.label("Xa_prepare"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_commit_work(com.generator.generators.mysql.parser.MySqlParser.Xa_commit_workContext arg) {
		System.out.println("Xa_commit_work");
		final Node node = model.newNode(Label.label("Xa_commit_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_rollback_work(com.generator.generators.mysql.parser.MySqlParser.Xa_rollback_workContext arg) {
		System.out.println("Xa_rollback_work");
		final Node node = model.newNode(Label.label("Xa_rollback_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXa_recover_work(com.generator.generators.mysql.parser.MySqlParser.Xa_recover_workContext arg) {
		System.out.println("Xa_recover_work");
		final Node node = model.newNode(Label.label("Xa_recover_work"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrepare_statement(com.generator.generators.mysql.parser.MySqlParser.Prepare_statementContext arg) {
		System.out.println("Prepare_statement");
		final Node node = model.newNode(Label.label("Prepare_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExecute_statement(com.generator.generators.mysql.parser.MySqlParser.Execute_statementContext arg) {
		System.out.println("Execute_statement");
		final Node node = model.newNode(Label.label("Execute_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeallocate_prepare(com.generator.generators.mysql.parser.MySqlParser.Deallocate_prepareContext arg) {
		System.out.println("Deallocate_prepare");
		final Node node = model.newNode(Label.label("Deallocate_prepare"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRoutine_body(com.generator.generators.mysql.parser.MySqlParser.Routine_bodyContext arg) {
		System.out.println("Routine_body");
		final Node node = model.newNode(Label.label("Routine_body"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock_statement(com.generator.generators.mysql.parser.MySqlParser.Block_statementContext arg) {
		System.out.println("Block_statement");
		final Node node = model.newNode(Label.label("Block_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCase_statement(com.generator.generators.mysql.parser.MySqlParser.Case_statementContext arg) {
		System.out.println("Case_statement");
		final Node node = model.newNode(Label.label("Case_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_statement(com.generator.generators.mysql.parser.MySqlParser.If_statementContext arg) {
		System.out.println("If_statement");
		final Node node = model.newNode(Label.label("If_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIterate_statement(com.generator.generators.mysql.parser.MySqlParser.Iterate_statementContext arg) {
		System.out.println("Iterate_statement");
		final Node node = model.newNode(Label.label("Iterate_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLeave_statement(com.generator.generators.mysql.parser.MySqlParser.Leave_statementContext arg) {
		System.out.println("Leave_statement");
		final Node node = model.newNode(Label.label("Leave_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoop_statement(com.generator.generators.mysql.parser.MySqlParser.Loop_statementContext arg) {
		System.out.println("Loop_statement");
		final Node node = model.newNode(Label.label("Loop_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRepeat_statement(com.generator.generators.mysql.parser.MySqlParser.Repeat_statementContext arg) {
		System.out.println("Repeat_statement");
		final Node node = model.newNode(Label.label("Repeat_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturn_statement(com.generator.generators.mysql.parser.MySqlParser.Return_statementContext arg) {
		System.out.println("Return_statement");
		final Node node = model.newNode(Label.label("Return_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhile_statement(com.generator.generators.mysql.parser.MySqlParser.While_statementContext arg) {
		System.out.println("While_statement");
		final Node node = model.newNode(Label.label("While_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCursor_statement(com.generator.generators.mysql.parser.MySqlParser.Cursor_statementContext arg) {
		System.out.println("Cursor_statement");
		final Node node = model.newNode(Label.label("Cursor_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_variable(com.generator.generators.mysql.parser.MySqlParser.Declare_variableContext arg) {
		System.out.println("Declare_variable");
		final Node node = model.newNode(Label.label("Declare_variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_condition(com.generator.generators.mysql.parser.MySqlParser.Declare_conditionContext arg) {
		System.out.println("Declare_condition");
		final Node node = model.newNode(Label.label("Declare_condition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_cursor(com.generator.generators.mysql.parser.MySqlParser.Declare_cursorContext arg) {
		System.out.println("Declare_cursor");
		final Node node = model.newNode(Label.label("Declare_cursor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclare_handler(com.generator.generators.mysql.parser.MySqlParser.Declare_handlerContext arg) {
		System.out.println("Declare_handler");
		final Node node = model.newNode(Label.label("Declare_handler"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler_condition_value(com.generator.generators.mysql.parser.MySqlParser.Handler_condition_valueContext arg) {
		System.out.println("Handler_condition_value");
		final Node node = model.newNode(Label.label("Handler_condition_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedure_sql_statement(com.generator.generators.mysql.parser.MySqlParser.Procedure_sql_statementContext arg) {
		System.out.println("Procedure_sql_statement");
		final Node node = model.newNode(Label.label("Procedure_sql_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterUserMysql56(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql56Context arg) {
		System.out.println("AlterUserMysql56");
		final Node node = model.newNode(Label.label("AlterUserMysql56"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlterUserMysql57(com.generator.generators.mysql.parser.MySqlParser.AlterUserMysql57Context arg) {
		System.out.println("AlterUserMysql57");
		final Node node = model.newNode(Label.label("AlterUserMysql57"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreateUserMysql56(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql56Context arg) {
		System.out.println("CreateUserMysql56");
		final Node node = model.newNode(Label.label("CreateUserMysql56"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreateUserMysql57(com.generator.generators.mysql.parser.MySqlParser.CreateUserMysql57Context arg) {
		System.out.println("CreateUserMysql57");
		final Node node = model.newNode(Label.label("CreateUserMysql57"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDrop_user(com.generator.generators.mysql.parser.MySqlParser.Drop_userContext arg) {
		System.out.println("Drop_user");
		final Node node = model.newNode(Label.label("Drop_user"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGrant_statement(com.generator.generators.mysql.parser.MySqlParser.Grant_statementContext arg) {
		System.out.println("Grant_statement");
		final Node node = model.newNode(Label.label("Grant_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGrant_proxy(com.generator.generators.mysql.parser.MySqlParser.Grant_proxyContext arg) {
		System.out.println("Grant_proxy");
		final Node node = model.newNode(Label.label("Grant_proxy"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRename_user(com.generator.generators.mysql.parser.MySqlParser.Rename_userContext arg) {
		System.out.println("Rename_user");
		final Node node = model.newNode(Label.label("Rename_user"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDetailRevoke(com.generator.generators.mysql.parser.MySqlParser.DetailRevokeContext arg) {
		System.out.println("DetailRevoke");
		final Node node = model.newNode(Label.label("DetailRevoke"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShortRevoke(com.generator.generators.mysql.parser.MySqlParser.ShortRevokeContext arg) {
		System.out.println("ShortRevoke");
		final Node node = model.newNode(Label.label("ShortRevoke"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRevoke_proxy(com.generator.generators.mysql.parser.MySqlParser.Revoke_proxyContext arg) {
		System.out.println("Revoke_proxy");
		final Node node = model.newNode(Label.label("Revoke_proxy"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_password_statement(com.generator.generators.mysql.parser.MySqlParser.Set_password_statementContext arg) {
		System.out.println("Set_password_statement");
		final Node node = model.newNode(Label.label("Set_password_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_password_option(com.generator.generators.mysql.parser.MySqlParser.User_password_optionContext arg) {
		System.out.println("User_password_option");
		final Node node = model.newNode(Label.label("User_password_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuthByPassword(com.generator.generators.mysql.parser.MySqlParser.AuthByPasswordContext arg) {
		System.out.println("AuthByPassword");
		final Node node = model.newNode(Label.label("AuthByPassword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuthByString(com.generator.generators.mysql.parser.MySqlParser.AuthByStringContext arg) {
		System.out.println("AuthByString");
		final Node node = model.newNode(Label.label("AuthByString"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuthByHash(com.generator.generators.mysql.parser.MySqlParser.AuthByHashContext arg) {
		System.out.println("AuthByHash");
		final Node node = model.newNode(Label.label("AuthByHash"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTls_option(com.generator.generators.mysql.parser.MySqlParser.Tls_optionContext arg) {
		System.out.println("Tls_option");
		final Node node = model.newNode(Label.label("Tls_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_resource_option(com.generator.generators.mysql.parser.MySqlParser.User_resource_optionContext arg) {
		System.out.println("User_resource_option");
		final Node node = model.newNode(Label.label("User_resource_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_lock_option(com.generator.generators.mysql.parser.MySqlParser.User_lock_optionContext arg) {
		System.out.println("User_lock_option");
		final Node node = model.newNode(Label.label("User_lock_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivelege_clause(com.generator.generators.mysql.parser.MySqlParser.Privelege_clauseContext arg) {
		System.out.println("Privelege_clause");
		final Node node = model.newNode(Label.label("Privelege_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivilege(com.generator.generators.mysql.parser.MySqlParser.PrivilegeContext arg) {
		System.out.println("Privilege");
		final Node node = model.newNode(Label.label("Privilege"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivilege_level(com.generator.generators.mysql.parser.MySqlParser.Privilege_levelContext arg) {
		System.out.println("Privilege_level");
		final Node node = model.newNode(Label.label("Privilege_level"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet_password_option(com.generator.generators.mysql.parser.MySqlParser.Set_password_optionContext arg) {
		System.out.println("Set_password_option");
		final Node node = model.newNode(Label.label("Set_password_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnalyze_table(com.generator.generators.mysql.parser.MySqlParser.Analyze_tableContext arg) {
		System.out.println("Analyze_table");
		final Node node = model.newNode(Label.label("Analyze_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCheck_table(com.generator.generators.mysql.parser.MySqlParser.Check_tableContext arg) {
		System.out.println("Check_table");
		final Node node = model.newNode(Label.label("Check_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChecksum_table(com.generator.generators.mysql.parser.MySqlParser.Checksum_tableContext arg) {
		System.out.println("Checksum_table");
		final Node node = model.newNode(Label.label("Checksum_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOptimize_table(com.generator.generators.mysql.parser.MySqlParser.Optimize_tableContext arg) {
		System.out.println("Optimize_table");
		final Node node = model.newNode(Label.label("Optimize_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRepair_table(com.generator.generators.mysql.parser.MySqlParser.Repair_tableContext arg) {
		System.out.println("Repair_table");
		final Node node = model.newNode(Label.label("Repair_table"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCheck_table_option(com.generator.generators.mysql.parser.MySqlParser.Check_table_optionContext arg) {
		System.out.println("Check_table_option");
		final Node node = model.newNode(Label.label("Check_table_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate_udfunction(com.generator.generators.mysql.parser.MySqlParser.Create_udfunctionContext arg) {
		System.out.println("Create_udfunction");
		final Node node = model.newNode(Label.label("Create_udfunction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Install_pluginContext arg) {
		System.out.println("Install_plugin");
		final Node node = model.newNode(Label.label("Install_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUninstall_plugin(com.generator.generators.mysql.parser.MySqlParser.Uninstall_pluginContext arg) {
		System.out.println("Uninstall_plugin");
		final Node node = model.newNode(Label.label("Uninstall_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetVariableAssignment(com.generator.generators.mysql.parser.MySqlParser.SetVariableAssignmentContext arg) {
		System.out.println("SetVariableAssignment");
		final Node node = model.newNode(Label.label("SetVariableAssignment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetCharset(com.generator.generators.mysql.parser.MySqlParser.SetCharsetContext arg) {
		System.out.println("SetCharset");
		final Node node = model.newNode(Label.label("SetCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetNames(com.generator.generators.mysql.parser.MySqlParser.SetNamesContext arg) {
		System.out.println("SetNames");
		final Node node = model.newNode(Label.label("SetNames"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetPasswordStatement(com.generator.generators.mysql.parser.MySqlParser.SetPasswordStatementContext arg) {
		System.out.println("SetPasswordStatement");
		final Node node = model.newNode(Label.label("SetPasswordStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetTransaction(com.generator.generators.mysql.parser.MySqlParser.SetTransactionContext arg) {
		System.out.println("SetTransaction");
		final Node node = model.newNode(Label.label("SetTransaction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetAutocommit(com.generator.generators.mysql.parser.MySqlParser.SetAutocommitContext arg) {
		System.out.println("SetAutocommit");
		final Node node = model.newNode(Label.label("SetAutocommit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowMasterlogs(com.generator.generators.mysql.parser.MySqlParser.ShowMasterlogsContext arg) {
		System.out.println("ShowMasterlogs");
		final Node node = model.newNode(Label.label("ShowMasterlogs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowLogevents(com.generator.generators.mysql.parser.MySqlParser.ShowLogeventsContext arg) {
		System.out.println("ShowLogevents");
		final Node node = model.newNode(Label.label("ShowLogevents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowObjWithFilter(com.generator.generators.mysql.parser.MySqlParser.ShowObjWithFilterContext arg) {
		System.out.println("ShowObjWithFilter");
		final Node node = model.newNode(Label.label("ShowObjWithFilter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowColumns(com.generator.generators.mysql.parser.MySqlParser.ShowColumnsContext arg) {
		System.out.println("ShowColumns");
		final Node node = model.newNode(Label.label("ShowColumns"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCreateDb(com.generator.generators.mysql.parser.MySqlParser.ShowCreateDbContext arg) {
		System.out.println("ShowCreateDb");
		final Node node = model.newNode(Label.label("ShowCreateDb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCreateFullidobj(com.generator.generators.mysql.parser.MySqlParser.ShowCreateFullidobjContext arg) {
		System.out.println("ShowCreateFullidobj");
		final Node node = model.newNode(Label.label("ShowCreateFullidobj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCreateUser(com.generator.generators.mysql.parser.MySqlParser.ShowCreateUserContext arg) {
		System.out.println("ShowCreateUser");
		final Node node = model.newNode(Label.label("ShowCreateUser"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowEngine(com.generator.generators.mysql.parser.MySqlParser.ShowEngineContext arg) {
		System.out.println("ShowEngine");
		final Node node = model.newNode(Label.label("ShowEngine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowGlobalinfo(com.generator.generators.mysql.parser.MySqlParser.ShowGlobalinfoContext arg) {
		System.out.println("ShowGlobalinfo");
		final Node node = model.newNode(Label.label("ShowGlobalinfo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowErrWarnContext arg) {
		System.out.println("ShowErrWarn");
		final Node node = model.newNode(Label.label("ShowErrWarn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowCountErrWarn(com.generator.generators.mysql.parser.MySqlParser.ShowCountErrWarnContext arg) {
		System.out.println("ShowCountErrWarn");
		final Node node = model.newNode(Label.label("ShowCountErrWarn"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowFromschemaFilter(com.generator.generators.mysql.parser.MySqlParser.ShowFromschemaFilterContext arg) {
		System.out.println("ShowFromschemaFilter");
		final Node node = model.newNode(Label.label("ShowFromschemaFilter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowRoutinecode(com.generator.generators.mysql.parser.MySqlParser.ShowRoutinecodeContext arg) {
		System.out.println("ShowRoutinecode");
		final Node node = model.newNode(Label.label("ShowRoutinecode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowGrants(com.generator.generators.mysql.parser.MySqlParser.ShowGrantsContext arg) {
		System.out.println("ShowGrants");
		final Node node = model.newNode(Label.label("ShowGrants"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowIndexes(com.generator.generators.mysql.parser.MySqlParser.ShowIndexesContext arg) {
		System.out.println("ShowIndexes");
		final Node node = model.newNode(Label.label("ShowIndexes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowOpentables(com.generator.generators.mysql.parser.MySqlParser.ShowOpentablesContext arg) {
		System.out.println("ShowOpentables");
		final Node node = model.newNode(Label.label("ShowOpentables"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowProfile(com.generator.generators.mysql.parser.MySqlParser.ShowProfileContext arg) {
		System.out.println("ShowProfile");
		final Node node = model.newNode(Label.label("ShowProfile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShowSlavestatus(com.generator.generators.mysql.parser.MySqlParser.ShowSlavestatusContext arg) {
		System.out.println("ShowSlavestatus");
		final Node node = model.newNode(Label.label("ShowSlavestatus"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariable_clause(com.generator.generators.mysql.parser.MySqlParser.Variable_clauseContext arg) {
		System.out.println("Variable_clause");
		final Node node = model.newNode(Label.label("Variable_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShow_filter(com.generator.generators.mysql.parser.MySqlParser.Show_filterContext arg) {
		System.out.println("Show_filter");
		final Node node = model.newNode(Label.label("Show_filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShow_profile_type(com.generator.generators.mysql.parser.MySqlParser.Show_profile_typeContext arg) {
		System.out.println("Show_profile_type");
		final Node node = model.newNode(Label.label("Show_profile_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinlog_statement(com.generator.generators.mysql.parser.MySqlParser.Binlog_statementContext arg) {
		System.out.println("Binlog_statement");
		final Node node = model.newNode(Label.label("Binlog_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCache_index_statement(com.generator.generators.mysql.parser.MySqlParser.Cache_index_statementContext arg) {
		System.out.println("Cache_index_statement");
		final Node node = model.newNode(Label.label("Cache_index_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFlush_statement(com.generator.generators.mysql.parser.MySqlParser.Flush_statementContext arg) {
		System.out.println("Flush_statement");
		final Node node = model.newNode(Label.label("Flush_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKill_statement(com.generator.generators.mysql.parser.MySqlParser.Kill_statementContext arg) {
		System.out.println("Kill_statement");
		final Node node = model.newNode(Label.label("Kill_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_index_into_cache(com.generator.generators.mysql.parser.MySqlParser.Load_index_into_cacheContext arg) {
		System.out.println("Load_index_into_cache");
		final Node node = model.newNode(Label.label("Load_index_into_cache"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReset_statement(com.generator.generators.mysql.parser.MySqlParser.Reset_statementContext arg) {
		System.out.println("Reset_statement");
		final Node node = model.newNode(Label.label("Reset_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShutdown_statement(com.generator.generators.mysql.parser.MySqlParser.Shutdown_statementContext arg) {
		System.out.println("Shutdown_statement");
		final Node node = model.newNode(Label.label("Shutdown_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Tbl_index_listContext arg) {
		System.out.println("Tbl_index_list");
		final Node node = model.newNode(Label.label("Tbl_index_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFlush_option(com.generator.generators.mysql.parser.MySqlParser.Flush_optionContext arg) {
		System.out.println("Flush_option");
		final Node node = model.newNode(Label.label("Flush_option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLoad_tbl_index_list(com.generator.generators.mysql.parser.MySqlParser.Load_tbl_index_listContext arg) {
		System.out.println("Load_tbl_index_list");
		final Node node = model.newNode(Label.label("Load_tbl_index_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Simple_describe_statementContext arg) {
		System.out.println("Simple_describe_statement");
		final Node node = model.newNode(Label.label("Simple_describe_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFull_describe_statement(com.generator.generators.mysql.parser.MySqlParser.Full_describe_statementContext arg) {
		System.out.println("Full_describe_statement");
		final Node node = model.newNode(Label.label("Full_describe_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHelp_statement(com.generator.generators.mysql.parser.MySqlParser.Help_statementContext arg) {
		System.out.println("Help_statement");
		final Node node = model.newNode(Label.label("Help_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUse_statement(com.generator.generators.mysql.parser.MySqlParser.Use_statementContext arg) {
		System.out.println("Use_statement");
		final Node node = model.newNode(Label.label("Use_statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDescstmtDescObj(com.generator.generators.mysql.parser.MySqlParser.DescstmtDescObjContext arg) {
		System.out.println("DescstmtDescObj");
		final Node node = model.newNode(Label.label("DescstmtDescObj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConnectionDescObj(com.generator.generators.mysql.parser.MySqlParser.ConnectionDescObjContext arg) {
		System.out.println("ConnectionDescObj");
		final Node node = model.newNode(Label.label("ConnectionDescObj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_name(com.generator.generators.mysql.parser.MySqlParser.Table_nameContext arg) {
		System.out.println("Table_name");
		final Node node = model.newNode(Label.label("Table_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFull_id(com.generator.generators.mysql.parser.MySqlParser.Full_idContext arg) {
		System.out.println("Full_id");
		final Node node = model.newNode(Label.label("Full_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFull_column_name(com.generator.generators.mysql.parser.MySqlParser.Full_column_nameContext arg) {
		System.out.println("Full_column_name");
		final Node node = model.newNode(Label.label("Full_column_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_col_name(com.generator.generators.mysql.parser.MySqlParser.Index_col_nameContext arg) {
		System.out.println("Index_col_name");
		final Node node = model.newNode(Label.label("Index_col_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_name(com.generator.generators.mysql.parser.MySqlParser.User_nameContext arg) {
		System.out.println("User_name");
		final Node node = model.newNode(Label.label("User_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMysql_variable(com.generator.generators.mysql.parser.MySqlParser.Mysql_variableContext arg) {
		System.out.println("Mysql_variable");
		final Node node = model.newNode(Label.label("Mysql_variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharset_name(com.generator.generators.mysql.parser.MySqlParser.Charset_nameContext arg) {
		System.out.println("Charset_name");
		final Node node = model.newNode(Label.label("Charset_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollation_name(com.generator.generators.mysql.parser.MySqlParser.Collation_nameContext arg) {
		System.out.println("Collation_name");
		final Node node = model.newNode(Label.label("Collation_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEngine_name(com.generator.generators.mysql.parser.MySqlParser.Engine_nameContext arg) {
		System.out.println("Engine_name");
		final Node node = model.newNode(Label.label("Engine_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUuid_set(com.generator.generators.mysql.parser.MySqlParser.Uuid_setContext arg) {
		System.out.println("Uuid_set");
		final Node node = model.newNode(Label.label("Uuid_set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXid(com.generator.generators.mysql.parser.MySqlParser.XidContext arg) {
		System.out.println("Xid");
		final Node node = model.newNode(Label.label("Xid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXid_string_id(com.generator.generators.mysql.parser.MySqlParser.Xid_string_idContext arg) {
		System.out.println("Xid_string_id");
		final Node node = model.newNode(Label.label("Xid_string_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuth_plugin(com.generator.generators.mysql.parser.MySqlParser.Auth_pluginContext arg) {
		System.out.println("Auth_plugin");
		final Node node = model.newNode(Label.label("Auth_plugin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitId_(com.generator.generators.mysql.parser.MySqlParser.Id_Context arg) {
		System.out.println("Id_");
		final Node node = model.newNode(Label.label("Id_"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_id(com.generator.generators.mysql.parser.MySqlParser.Simple_idContext arg) {
		System.out.println("Simple_id");
		final Node node = model.newNode(Label.label("Simple_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDot_ext_id(com.generator.generators.mysql.parser.MySqlParser.Dot_ext_idContext arg) {
		System.out.println("Dot_ext_id");
		final Node node = model.newNode(Label.label("Dot_ext_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Decimal_literalContext arg) {
		System.out.println("Decimal_literal");
		final Node node = model.newNode(Label.label("Decimal_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilesize_literal(com.generator.generators.mysql.parser.MySqlParser.Filesize_literalContext arg) {
		System.out.println("Filesize_literal");
		final Node node = model.newNode(Label.label("Filesize_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString_literal(com.generator.generators.mysql.parser.MySqlParser.String_literalContext arg) {
		System.out.println("String_literal");
		final Node node = model.newNode(Label.label("String_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBoolean_literal(com.generator.generators.mysql.parser.MySqlParser.Boolean_literalContext arg) {
		System.out.println("Boolean_literal");
		final Node node = model.newNode(Label.label("Boolean_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHexadecimal_literal(com.generator.generators.mysql.parser.MySqlParser.Hexadecimal_literalContext arg) {
		System.out.println("Hexadecimal_literal");
		final Node node = model.newNode(Label.label("Hexadecimal_literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNull_notnull(com.generator.generators.mysql.parser.MySqlParser.Null_notnullContext arg) {
		System.out.println("Null_notnull");
		final Node node = model.newNode(Label.label("Null_notnull"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstant(com.generator.generators.mysql.parser.MySqlParser.ConstantContext arg) {
		System.out.println("Constant");
		final Node node = model.newNode(Label.label("Constant"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CharDatatypeContext arg) {
		System.out.println("CharDatatype");
		final Node node = model.newNode(Label.label("CharDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDimensionDatatype(com.generator.generators.mysql.parser.MySqlParser.DimensionDatatypeContext arg) {
		System.out.println("DimensionDatatype");
		final Node node = model.newNode(Label.label("DimensionDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleDatatype(com.generator.generators.mysql.parser.MySqlParser.SimpleDatatypeContext arg) {
		System.out.println("SimpleDatatype");
		final Node node = model.newNode(Label.label("SimpleDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollectCharDatatype(com.generator.generators.mysql.parser.MySqlParser.CollectCharDatatypeContext arg) {
		System.out.println("CollectCharDatatype");
		final Node node = model.newNode(Label.label("CollectCharDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpatialDatatype(com.generator.generators.mysql.parser.MySqlParser.SpatialDatatypeContext arg) {
		System.out.println("SpatialDatatype");
		final Node node = model.newNode(Label.label("SpatialDatatype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitData_type_to_convert(com.generator.generators.mysql.parser.MySqlParser.Data_type_to_convertContext arg) {
		System.out.println("Data_type_to_convert");
		final Node node = model.newNode(Label.label("Data_type_to_convert"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpatial_data_type(com.generator.generators.mysql.parser.MySqlParser.Spatial_data_typeContext arg) {
		System.out.println("Spatial_data_type");
		final Node node = model.newNode(Label.label("Spatial_data_type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLength_one_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_one_dimensionContext arg) {
		System.out.println("Length_one_dimension");
		final Node node = model.newNode(Label.label("Length_one_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLength_two_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_dimensionContext arg) {
		System.out.println("Length_two_dimension");
		final Node node = model.newNode(Label.label("Length_two_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLength_two_optional_dimension(com.generator.generators.mysql.parser.MySqlParser.Length_two_optional_dimensionContext arg) {
		System.out.println("Length_two_optional_dimension");
		final Node node = model.newNode(Label.label("Length_two_optional_dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitId_list(com.generator.generators.mysql.parser.MySqlParser.Id_listContext arg) {
		System.out.println("Id_list");
		final Node node = model.newNode(Label.label("Id_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_list(com.generator.generators.mysql.parser.MySqlParser.Table_listContext arg) {
		System.out.println("Table_list");
		final Node node = model.newNode(Label.label("Table_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTable_pair_list(com.generator.generators.mysql.parser.MySqlParser.Table_pair_listContext arg) {
		System.out.println("Table_pair_list");
		final Node node = model.newNode(Label.label("Table_pair_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex_colname_list(com.generator.generators.mysql.parser.MySqlParser.Index_colname_listContext arg) {
		System.out.println("Index_colname_list");
		final Node node = model.newNode(Label.label("Index_colname_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression_list(com.generator.generators.mysql.parser.MySqlParser.Expression_listContext arg) {
		System.out.println("Expression_list");
		final Node node = model.newNode(Label.label("Expression_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstant_list(com.generator.generators.mysql.parser.MySqlParser.Constant_listContext arg) {
		System.out.println("Constant_list");
		final Node node = model.newNode(Label.label("Constant_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_string_list(com.generator.generators.mysql.parser.MySqlParser.Simple_string_listContext arg) {
		System.out.println("Simple_string_list");
		final Node node = model.newNode(Label.label("Simple_string_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser_var_list(com.generator.generators.mysql.parser.MySqlParser.User_var_listContext arg) {
		System.out.println("User_var_list");
		final Node node = model.newNode(Label.label("User_var_list"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefault_value(com.generator.generators.mysql.parser.MySqlParser.Default_valueContext arg) {
		System.out.println("Default_value");
		final Node node = model.newNode(Label.label("Default_value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_exists(com.generator.generators.mysql.parser.MySqlParser.If_existsContext arg) {
		System.out.println("If_exists");
		final Node node = model.newNode(Label.label("If_exists"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_not_exists(com.generator.generators.mysql.parser.MySqlParser.If_not_existsContext arg) {
		System.out.println("If_not_exists");
		final Node node = model.newNode(Label.label("If_not_exists"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSpecificFunctionCall(com.generator.generators.mysql.parser.MySqlParser.SpecificFunctionCallContext arg) {
		System.out.println("SpecificFunctionCall");
		final Node node = model.newNode(Label.label("SpecificFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAggregateFunctionCall(com.generator.generators.mysql.parser.MySqlParser.AggregateFunctionCallContext arg) {
		System.out.println("AggregateFunctionCall");
		final Node node = model.newNode(Label.label("AggregateFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScalarFunctionCall(com.generator.generators.mysql.parser.MySqlParser.ScalarFunctionCallContext arg) {
		System.out.println("ScalarFunctionCall");
		final Node node = model.newNode(Label.label("ScalarFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUdfFunctionCall(com.generator.generators.mysql.parser.MySqlParser.UdfFunctionCallContext arg) {
		System.out.println("UdfFunctionCall");
		final Node node = model.newNode(Label.label("UdfFunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSpecificFCall(com.generator.generators.mysql.parser.MySqlParser.SimpleSpecificFCallContext arg) {
		System.out.println("SimpleSpecificFCall");
		final Node node = model.newNode(Label.label("SimpleSpecificFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConvertDataTypeFCall(com.generator.generators.mysql.parser.MySqlParser.ConvertDataTypeFCallContext arg) {
		System.out.println("ConvertDataTypeFCall");
		final Node node = model.newNode(Label.label("ConvertDataTypeFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValuesFCall(com.generator.generators.mysql.parser.MySqlParser.ValuesFCallContext arg) {
		System.out.println("ValuesFCall");
		final Node node = model.newNode(Label.label("ValuesFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseFCall(com.generator.generators.mysql.parser.MySqlParser.CaseFCallContext arg) {
		System.out.println("CaseFCall");
		final Node node = model.newNode(Label.label("CaseFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharFCall(com.generator.generators.mysql.parser.MySqlParser.CharFCallContext arg) {
		System.out.println("CharFCall");
		final Node node = model.newNode(Label.label("CharFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPositionFCall(com.generator.generators.mysql.parser.MySqlParser.PositionFCallContext arg) {
		System.out.println("PositionFCall");
		final Node node = model.newNode(Label.label("PositionFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubstrFCall(com.generator.generators.mysql.parser.MySqlParser.SubstrFCallContext arg) {
		System.out.println("SubstrFCall");
		final Node node = model.newNode(Label.label("SubstrFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrimFCall(com.generator.generators.mysql.parser.MySqlParser.TrimFCallContext arg) {
		System.out.println("TrimFCall");
		final Node node = model.newNode(Label.label("TrimFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWeightFCall(com.generator.generators.mysql.parser.MySqlParser.WeightFCallContext arg) {
		System.out.println("WeightFCall");
		final Node node = model.newNode(Label.label("WeightFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtractFCall(com.generator.generators.mysql.parser.MySqlParser.ExtractFCallContext arg) {
		System.out.println("ExtractFCall");
		final Node node = model.newNode(Label.label("ExtractFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGetFormatFCall(com.generator.generators.mysql.parser.MySqlParser.GetFormatFCallContext arg) {
		System.out.println("GetFormatFCall");
		final Node node = model.newNode(Label.label("GetFormatFCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLevelWeightFList(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFListContext arg) {
		System.out.println("LevelWeightFList");
		final Node node = model.newNode(Label.label("LevelWeightFList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLevelWeightFRange(com.generator.generators.mysql.parser.MySqlParser.LevelWeightFRangeContext arg) {
		System.out.println("LevelWeightFRange");
		final Node node = model.newNode(Label.label("LevelWeightFRange"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAggregate_windowed_function(com.generator.generators.mysql.parser.MySqlParser.Aggregate_windowed_functionContext arg) {
		System.out.println("Aggregate_windowed_function");
		final Node node = model.newNode(Label.label("Aggregate_windowed_function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScalar_function_name(com.generator.generators.mysql.parser.MySqlParser.Scalar_function_nameContext arg) {
		System.out.println("Scalar_function_name");
		final Node node = model.newNode(Label.label("Scalar_function_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction_args(com.generator.generators.mysql.parser.MySqlParser.Function_argsContext arg) {
		System.out.println("Function_args");
		final Node node = model.newNode(Label.label("Function_args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction_arg(com.generator.generators.mysql.parser.MySqlParser.Function_argContext arg) {
		System.out.println("Function_arg");
		final Node node = model.newNode(Label.label("Function_arg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIsExpression(com.generator.generators.mysql.parser.MySqlParser.IsExpressionContext arg) {
		System.out.println("IsExpression");
		final Node node = model.newNode(Label.label("IsExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalExpression(com.generator.generators.mysql.parser.MySqlParser.LogicalExpressionContext arg) {
		System.out.println("LogicalExpression");
		final Node node = model.newNode(Label.label("LogicalExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicateExpression(com.generator.generators.mysql.parser.MySqlParser.PredicateExpressionContext arg) {
		System.out.println("PredicateExpression");
		final Node node = model.newNode(Label.label("PredicateExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSoundsLikePredicate(com.generator.generators.mysql.parser.MySqlParser.SoundsLikePredicateContext arg) {
		System.out.println("SoundsLikePredicate");
		final Node node = model.newNode(Label.label("SoundsLikePredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionAtomPredicate(com.generator.generators.mysql.parser.MySqlParser.ExpressionAtomPredicateContext arg) {
		System.out.println("ExpressionAtomPredicate");
		final Node node = model.newNode(Label.label("ExpressionAtomPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInPredicate(com.generator.generators.mysql.parser.MySqlParser.InPredicateContext arg) {
		System.out.println("InPredicate");
		final Node node = model.newNode(Label.label("InPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubqueryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.SubqueryComparasionPredicateContext arg) {
		System.out.println("SubqueryComparasionPredicate");
		final Node node = model.newNode(Label.label("SubqueryComparasionPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBetweenPredicate(com.generator.generators.mysql.parser.MySqlParser.BetweenPredicateContext arg) {
		System.out.println("BetweenPredicate");
		final Node node = model.newNode(Label.label("BetweenPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinaryComparasionPredicate(com.generator.generators.mysql.parser.MySqlParser.BinaryComparasionPredicateContext arg) {
		System.out.println("BinaryComparasionPredicate");
		final Node node = model.newNode(Label.label("BinaryComparasionPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIsNullPredicate(com.generator.generators.mysql.parser.MySqlParser.IsNullPredicateContext arg) {
		System.out.println("IsNullPredicate");
		final Node node = model.newNode(Label.label("IsNullPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLikePredicate(com.generator.generators.mysql.parser.MySqlParser.LikePredicateContext arg) {
		System.out.println("LikePredicate");
		final Node node = model.newNode(Label.label("LikePredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegexpPredicate(com.generator.generators.mysql.parser.MySqlParser.RegexpPredicateContext arg) {
		System.out.println("RegexpPredicate");
		final Node node = model.newNode(Label.label("RegexpPredicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.UnaryExpressionAtomContext arg) {
		System.out.println("UnaryExpressionAtom");
		final Node node = model.newNode(Label.label("UnaryExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistsExpessionAtom(com.generator.generators.mysql.parser.MySqlParser.ExistsExpessionAtomContext arg) {
		System.out.println("ExistsExpessionAtom");
		final Node node = model.newNode(Label.label("ExistsExpessionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstantExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.ConstantExpressionAtomContext arg) {
		System.out.println("ConstantExpressionAtom");
		final Node node = model.newNode(Label.label("ConstantExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionCallExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FunctionCallExpressionAtomContext arg) {
		System.out.println("FunctionCallExpressionAtom");
		final Node node = model.newNode(Label.label("FunctionCallExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMysqlVariableExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MysqlVariableExpressionAtomContext arg) {
		System.out.println("MysqlVariableExpressionAtom");
		final Node node = model.newNode(Label.label("MysqlVariableExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinaryExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BinaryExpressionAtomContext arg) {
		System.out.println("BinaryExpressionAtom");
		final Node node = model.newNode(Label.label("BinaryExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFullColumnNameExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.FullColumnNameExpressionAtomContext arg) {
		System.out.println("FullColumnNameExpressionAtom");
		final Node node = model.newNode(Label.label("FullColumnNameExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.DefaultExpressionAtomContext arg) {
		System.out.println("DefaultExpressionAtom");
		final Node node = model.newNode(Label.label("DefaultExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.BitExpressionAtomContext arg) {
		System.out.println("BitExpressionAtom");
		final Node node = model.newNode(Label.label("BitExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNestedExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.NestedExpressionAtomContext arg) {
		System.out.println("NestedExpressionAtom");
		final Node node = model.newNode(Label.label("NestedExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMathExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.MathExpressionAtomContext arg) {
		System.out.println("MathExpressionAtom");
		final Node node = model.newNode(Label.label("MathExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntervalExpressionAtom(com.generator.generators.mysql.parser.MySqlParser.IntervalExpressionAtomContext arg) {
		System.out.println("IntervalExpressionAtom");
		final Node node = model.newNode(Label.label("IntervalExpressionAtom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnary_operator(com.generator.generators.mysql.parser.MySqlParser.Unary_operatorContext arg) {
		System.out.println("Unary_operator");
		final Node node = model.newNode(Label.label("Unary_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparison_operator(com.generator.generators.mysql.parser.MySqlParser.Comparison_operatorContext arg) {
		System.out.println("Comparison_operator");
		final Node node = model.newNode(Label.label("Comparison_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogical_operator(com.generator.generators.mysql.parser.MySqlParser.Logical_operatorContext arg) {
		System.out.println("Logical_operator");
		final Node node = model.newNode(Label.label("Logical_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBit_operator(com.generator.generators.mysql.parser.MySqlParser.Bit_operatorContext arg) {
		System.out.println("Bit_operator");
		final Node node = model.newNode(Label.label("Bit_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMath_operator(com.generator.generators.mysql.parser.MySqlParser.Math_operatorContext arg) {
		System.out.println("Math_operator");
		final Node node = model.newNode(Label.label("Math_operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharset_name_base(com.generator.generators.mysql.parser.MySqlParser.Charset_name_baseContext arg) {
		System.out.println("Charset_name_base");
		final Node node = model.newNode(Label.label("Charset_name_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTransaction_level_base(com.generator.generators.mysql.parser.MySqlParser.Transaction_level_baseContext arg) {
		System.out.println("Transaction_level_base");
		final Node node = model.newNode(Label.label("Transaction_level_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrivileges_base(com.generator.generators.mysql.parser.MySqlParser.Privileges_baseContext arg) {
		System.out.println("Privileges_base");
		final Node node = model.newNode(Label.label("Privileges_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterval_type_base(com.generator.generators.mysql.parser.MySqlParser.Interval_type_baseContext arg) {
		System.out.println("Interval_type_base");
		final Node node = model.newNode(Label.label("Interval_type_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitData_type_base(com.generator.generators.mysql.parser.MySqlParser.Data_type_baseContext arg) {
		System.out.println("Data_type_base");
		final Node node = model.newNode(Label.label("Data_type_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeywords_can_be_id(com.generator.generators.mysql.parser.MySqlParser.Keywords_can_be_idContext arg) {
		System.out.println("Keywords_can_be_id");
		final Node node = model.newNode(Label.label("Keywords_can_be_id"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction_name_base(com.generator.generators.mysql.parser.MySqlParser.Function_name_baseContext arg) {
		System.out.println("Function_name_base");
		final Node node = model.newNode(Label.label("Function_name_base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}