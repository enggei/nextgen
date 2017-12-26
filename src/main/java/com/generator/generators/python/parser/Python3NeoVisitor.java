package com.generator.generators.python.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class Python3NeoVisitor extends Python3BaseVisitor<Node> {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Python3NeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public Python3NeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitSingle_input(com.generator.generators.python.parser.Python3Parser.Single_inputContext arg) {
		log.info("Single_input");
		final Node node = model.newNode(Label.label("Single_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile_input(com.generator.generators.python.parser.Python3Parser.File_inputContext arg) {
		log.info("File_input");
		final Node node = model.newNode(Label.label("File_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEval_input(com.generator.generators.python.parser.Python3Parser.Eval_inputContext arg) {
		log.info("Eval_input");
		final Node node = model.newNode(Label.label("Eval_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorator(com.generator.generators.python.parser.Python3Parser.DecoratorContext arg) {
		log.info("Decorator");
		final Node node = model.newNode(Label.label("Decorator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorators(com.generator.generators.python.parser.Python3Parser.DecoratorsContext arg) {
		log.info("Decorators");
		final Node node = model.newNode(Label.label("Decorators"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorated(com.generator.generators.python.parser.Python3Parser.DecoratedContext arg) {
		log.info("Decorated");
		final Node node = model.newNode(Label.label("Decorated"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncdef(com.generator.generators.python.parser.Python3Parser.FuncdefContext arg) {
		log.info("Funcdef");
		final Node node = model.newNode(Label.label("Funcdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypedargslist(com.generator.generators.python.parser.Python3Parser.TypedargslistContext arg) {
		log.info("Typedargslist");
		final Node node = model.newNode(Label.label("Typedargslist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTfpdef(com.generator.generators.python.parser.Python3Parser.TfpdefContext arg) {
		log.info("Tfpdef");
		final Node node = model.newNode(Label.label("Tfpdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarargslist(com.generator.generators.python.parser.Python3Parser.VarargslistContext arg) {
		log.info("Varargslist");
		final Node node = model.newNode(Label.label("Varargslist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVfpdef(com.generator.generators.python.parser.Python3Parser.VfpdefContext arg) {
		log.info("Vfpdef");
		final Node node = model.newNode(Label.label("Vfpdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtom(com.generator.generators.python.parser.Python3Parser.AtomContext arg) {
		log.info("Atom");
		final Node node = model.newNode(Label.label("Atom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.python.parser.Python3Parser.NumberContext arg) {
		log.info("Number");
		final Node node = model.newNode(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.python.parser.Python3Parser.ExprContext arg) {
		log.info("Expr");
		final Node node = model.newNode(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameters(com.generator.generators.python.parser.Python3Parser.ParametersContext arg) {
		log.info("Parameters");
		final Node node = model.newNode(Label.label("Parameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgument(com.generator.generators.python.parser.Python3Parser.ArgumentContext arg) {
		log.info("Argument");
		final Node node = model.newNode(Label.label("Argument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStmt(com.generator.generators.python.parser.Python3Parser.StmtContext arg) {
		log.info("Stmt");
		final Node node = model.newNode(Label.label("Stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_stmt(com.generator.generators.python.parser.Python3Parser.Simple_stmtContext arg) {
		log.info("Simple_stmt");
		final Node node = model.newNode(Label.label("Simple_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSmall_stmt(com.generator.generators.python.parser.Python3Parser.Small_stmtContext arg) {
		log.info("Small_stmt");
		final Node node = model.newNode(Label.label("Small_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrint_stmt(com.generator.generators.python.parser.Python3Parser.Print_stmtContext arg) {
		log.info("Print_stmt");
		final Node node = model.newNode(Label.label("Print_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr_stmt(com.generator.generators.python.parser.Python3Parser.Expr_stmtContext arg) {
		log.info("Expr_stmt");
		final Node node = model.newNode(Label.label("Expr_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist_star_expr(com.generator.generators.python.parser.Python3Parser.Testlist_star_exprContext arg) {
		log.info("Testlist_star_expr");
		final Node node = model.newNode(Label.label("Testlist_star_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAugassign(com.generator.generators.python.parser.Python3Parser.AugassignContext arg) {
		log.info("Augassign");
		final Node node = model.newNode(Label.label("Augassign"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDel_stmt(com.generator.generators.python.parser.Python3Parser.Del_stmtContext arg) {
		log.info("Del_stmt");
		final Node node = model.newNode(Label.label("Del_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPass_stmt(com.generator.generators.python.parser.Python3Parser.Pass_stmtContext arg) {
		log.info("Pass_stmt");
		final Node node = model.newNode(Label.label("Pass_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFlow_stmt(com.generator.generators.python.parser.Python3Parser.Flow_stmtContext arg) {
		log.info("Flow_stmt");
		final Node node = model.newNode(Label.label("Flow_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreak_stmt(com.generator.generators.python.parser.Python3Parser.Break_stmtContext arg) {
		log.info("Break_stmt");
		final Node node = model.newNode(Label.label("Break_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinue_stmt(com.generator.generators.python.parser.Python3Parser.Continue_stmtContext arg) {
		log.info("Continue_stmt");
		final Node node = model.newNode(Label.label("Continue_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturn_stmt(com.generator.generators.python.parser.Python3Parser.Return_stmtContext arg) {
		log.info("Return_stmt");
		final Node node = model.newNode(Label.label("Return_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_stmt(com.generator.generators.python.parser.Python3Parser.Yield_stmtContext arg) {
		log.info("Yield_stmt");
		final Node node = model.newNode(Label.label("Yield_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRaise_stmt(com.generator.generators.python.parser.Python3Parser.Raise_stmtContext arg) {
		log.info("Raise_stmt");
		final Node node = model.newNode(Label.label("Raise_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_stmt(com.generator.generators.python.parser.Python3Parser.Import_stmtContext arg) {
		log.info("Import_stmt");
		final Node node = model.newNode(Label.label("Import_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_name(com.generator.generators.python.parser.Python3Parser.Import_nameContext arg) {
		log.info("Import_name");
		final Node node = model.newNode(Label.label("Import_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_from(com.generator.generators.python.parser.Python3Parser.Import_fromContext arg) {
		log.info("Import_from");
		final Node node = model.newNode(Label.label("Import_from"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_as_name(com.generator.generators.python.parser.Python3Parser.Import_as_nameContext arg) {
		log.info("Import_as_name");
		final Node node = model.newNode(Label.label("Import_as_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_as_name(com.generator.generators.python.parser.Python3Parser.Dotted_as_nameContext arg) {
		log.info("Dotted_as_name");
		final Node node = model.newNode(Label.label("Dotted_as_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_as_names(com.generator.generators.python.parser.Python3Parser.Import_as_namesContext arg) {
		log.info("Import_as_names");
		final Node node = model.newNode(Label.label("Import_as_names"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_as_names(com.generator.generators.python.parser.Python3Parser.Dotted_as_namesContext arg) {
		log.info("Dotted_as_names");
		final Node node = model.newNode(Label.label("Dotted_as_names"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_name(com.generator.generators.python.parser.Python3Parser.Dotted_nameContext arg) {
		log.info("Dotted_name");
		final Node node = model.newNode(Label.label("Dotted_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGlobal_stmt(com.generator.generators.python.parser.Python3Parser.Global_stmtContext arg) {
		log.info("Global_stmt");
		final Node node = model.newNode(Label.label("Global_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonlocal_stmt(com.generator.generators.python.parser.Python3Parser.Nonlocal_stmtContext arg) {
		log.info("Nonlocal_stmt");
		final Node node = model.newNode(Label.label("Nonlocal_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssert_stmt(com.generator.generators.python.parser.Python3Parser.Assert_stmtContext arg) {
		log.info("Assert_stmt");
		final Node node = model.newNode(Label.label("Assert_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompound_stmt(com.generator.generators.python.parser.Python3Parser.Compound_stmtContext arg) {
		log.info("Compound_stmt");
		final Node node = model.newNode(Label.label("Compound_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_stmt(com.generator.generators.python.parser.Python3Parser.If_stmtContext arg) {
		log.info("If_stmt");
		final Node node = model.newNode(Label.label("If_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhile_stmt(com.generator.generators.python.parser.Python3Parser.While_stmtContext arg) {
		log.info("While_stmt");
		final Node node = model.newNode(Label.label("While_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFor_stmt(com.generator.generators.python.parser.Python3Parser.For_stmtContext arg) {
		log.info("For_stmt");
		final Node node = model.newNode(Label.label("For_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTry_stmt(com.generator.generators.python.parser.Python3Parser.Try_stmtContext arg) {
		log.info("Try_stmt");
		final Node node = model.newNode(Label.label("Try_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith_stmt(com.generator.generators.python.parser.Python3Parser.With_stmtContext arg) {
		log.info("With_stmt");
		final Node node = model.newNode(Label.label("With_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith_item(com.generator.generators.python.parser.Python3Parser.With_itemContext arg) {
		log.info("With_item");
		final Node node = model.newNode(Label.label("With_item"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExcept_clause(com.generator.generators.python.parser.Python3Parser.Except_clauseContext arg) {
		log.info("Except_clause");
		final Node node = model.newNode(Label.label("Except_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSuite(com.generator.generators.python.parser.Python3Parser.SuiteContext arg) {
		log.info("Suite");
		final Node node = model.newNode(Label.label("Suite"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTest(com.generator.generators.python.parser.Python3Parser.TestContext arg) {
		log.info("Test");
		final Node node = model.newNode(Label.label("Test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTest_nocond(com.generator.generators.python.parser.Python3Parser.Test_nocondContext arg) {
		log.info("Test_nocond");
		final Node node = model.newNode(Label.label("Test_nocond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdef(com.generator.generators.python.parser.Python3Parser.LambdefContext arg) {
		log.info("Lambdef");
		final Node node = model.newNode(Label.label("Lambdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdef_nocond(com.generator.generators.python.parser.Python3Parser.Lambdef_nocondContext arg) {
		log.info("Lambdef_nocond");
		final Node node = model.newNode(Label.label("Lambdef_nocond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOr_test(com.generator.generators.python.parser.Python3Parser.Or_testContext arg) {
		log.info("Or_test");
		final Node node = model.newNode(Label.label("Or_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnd_test(com.generator.generators.python.parser.Python3Parser.And_testContext arg) {
		log.info("And_test");
		final Node node = model.newNode(Label.label("And_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNot_test(com.generator.generators.python.parser.Python3Parser.Not_testContext arg) {
		log.info("Not_test");
		final Node node = model.newNode(Label.label("Not_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparison(com.generator.generators.python.parser.Python3Parser.ComparisonContext arg) {
		log.info("Comparison");
		final Node node = model.newNode(Label.label("Comparison"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_op(com.generator.generators.python.parser.Python3Parser.Comp_opContext arg) {
		log.info("Comp_op");
		final Node node = model.newNode(Label.label("Comp_op"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStar_expr(com.generator.generators.python.parser.Python3Parser.Star_exprContext arg) {
		log.info("Star_expr");
		final Node node = model.newNode(Label.label("Star_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXor_expr(com.generator.generators.python.parser.Python3Parser.Xor_exprContext arg) {
		log.info("Xor_expr");
		final Node node = model.newNode(Label.label("Xor_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnd_expr(com.generator.generators.python.parser.Python3Parser.And_exprContext arg) {
		log.info("And_expr");
		final Node node = model.newNode(Label.label("And_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShift_expr(com.generator.generators.python.parser.Python3Parser.Shift_exprContext arg) {
		log.info("Shift_expr");
		final Node node = model.newNode(Label.label("Shift_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArith_expr(com.generator.generators.python.parser.Python3Parser.Arith_exprContext arg) {
		log.info("Arith_expr");
		final Node node = model.newNode(Label.label("Arith_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTerm(com.generator.generators.python.parser.Python3Parser.TermContext arg) {
		log.info("Term");
		final Node node = model.newNode(Label.label("Term"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFactor(com.generator.generators.python.parser.Python3Parser.FactorContext arg) {
		log.info("Factor");
		final Node node = model.newNode(Label.label("Factor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPower(com.generator.generators.python.parser.Python3Parser.PowerContext arg) {
		log.info("Power");
		final Node node = model.newNode(Label.label("Power"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist_comp(com.generator.generators.python.parser.Python3Parser.Testlist_compContext arg) {
		log.info("Testlist_comp");
		final Node node = model.newNode(Label.label("Testlist_comp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrailer(com.generator.generators.python.parser.Python3Parser.TrailerContext arg) {
		log.info("Trailer");
		final Node node = model.newNode(Label.label("Trailer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubscriptlist(com.generator.generators.python.parser.Python3Parser.SubscriptlistContext arg) {
		log.info("Subscriptlist");
		final Node node = model.newNode(Label.label("Subscriptlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubscript(com.generator.generators.python.parser.Python3Parser.SubscriptContext arg) {
		log.info("Subscript");
		final Node node = model.newNode(Label.label("Subscript"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSliceop(com.generator.generators.python.parser.Python3Parser.SliceopContext arg) {
		log.info("Sliceop");
		final Node node = model.newNode(Label.label("Sliceop"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprlist(com.generator.generators.python.parser.Python3Parser.ExprlistContext arg) {
		log.info("Exprlist");
		final Node node = model.newNode(Label.label("Exprlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist(com.generator.generators.python.parser.Python3Parser.TestlistContext arg) {
		log.info("Testlist");
		final Node node = model.newNode(Label.label("Testlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDictorsetmaker(com.generator.generators.python.parser.Python3Parser.DictorsetmakerContext arg) {
		log.info("Dictorsetmaker");
		final Node node = model.newNode(Label.label("Dictorsetmaker"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassdef(com.generator.generators.python.parser.Python3Parser.ClassdefContext arg) {
		log.info("Classdef");
		final Node node = model.newNode(Label.label("Classdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArglist(com.generator.generators.python.parser.Python3Parser.ArglistContext arg) {
		log.info("Arglist");
		final Node node = model.newNode(Label.label("Arglist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_iter(com.generator.generators.python.parser.Python3Parser.Comp_iterContext arg) {
		log.info("Comp_iter");
		final Node node = model.newNode(Label.label("Comp_iter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_for(com.generator.generators.python.parser.Python3Parser.Comp_forContext arg) {
		log.info("Comp_for");
		final Node node = model.newNode(Label.label("Comp_for"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_if(com.generator.generators.python.parser.Python3Parser.Comp_ifContext arg) {
		log.info("Comp_if");
		final Node node = model.newNode(Label.label("Comp_if"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_expr(com.generator.generators.python.parser.Python3Parser.Yield_exprContext arg) {
		log.info("Yield_expr");
		final Node node = model.newNode(Label.label("Yield_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_arg(com.generator.generators.python.parser.Python3Parser.Yield_argContext arg) {
		log.info("Yield_arg");
		final Node node = model.newNode(Label.label("Yield_arg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStr(com.generator.generators.python.parser.Python3Parser.StrContext arg) {
		log.info("Str");
		final Node node = model.newNode(Label.label("Str"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInteger(com.generator.generators.python.parser.Python3Parser.IntegerContext arg) {
		log.info("Integer");
		final Node node = model.newNode(Label.label("Integer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}