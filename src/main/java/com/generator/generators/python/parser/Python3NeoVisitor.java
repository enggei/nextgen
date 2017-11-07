package com.generator.generators.python.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class Python3NeoVisitor extends Python3BaseVisitor<Node> {

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
	public Node visitTypedargslist(com.generator.generators.python.parser.Python3Parser.TypedargslistContext arg) {
		System.out.println("Typedargslist");
		final Node node = model.newNode(Label.label("Typedargslist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTfpdef(com.generator.generators.python.parser.Python3Parser.TfpdefContext arg) {
		System.out.println("Tfpdef");
		final Node node = model.newNode(Label.label("Tfpdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarargslist(com.generator.generators.python.parser.Python3Parser.VarargslistContext arg) {
		System.out.println("Varargslist");
		final Node node = model.newNode(Label.label("Varargslist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVfpdef(com.generator.generators.python.parser.Python3Parser.VfpdefContext arg) {
		System.out.println("Vfpdef");
		final Node node = model.newNode(Label.label("Vfpdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStmt(com.generator.generators.python.parser.Python3Parser.StmtContext arg) {
		System.out.println("Stmt");
		final Node node = model.newNode(Label.label("Stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_stmt(com.generator.generators.python.parser.Python3Parser.Simple_stmtContext arg) {
		System.out.println("Simple_stmt");
		final Node node = model.newNode(Label.label("Simple_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSmall_stmt(com.generator.generators.python.parser.Python3Parser.Small_stmtContext arg) {
		System.out.println("Small_stmt");
		final Node node = model.newNode(Label.label("Small_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrint_stmt(com.generator.generators.python.parser.Python3Parser.Print_stmtContext arg) {
		System.out.println("Print_stmt");
		final Node node = model.newNode(Label.label("Print_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr_stmt(com.generator.generators.python.parser.Python3Parser.Expr_stmtContext arg) {
		System.out.println("Expr_stmt");
		final Node node = model.newNode(Label.label("Expr_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist_star_expr(com.generator.generators.python.parser.Python3Parser.Testlist_star_exprContext arg) {
		System.out.println("Testlist_star_expr");
		final Node node = model.newNode(Label.label("Testlist_star_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAugassign(com.generator.generators.python.parser.Python3Parser.AugassignContext arg) {
		System.out.println("Augassign");
		final Node node = model.newNode(Label.label("Augassign"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDel_stmt(com.generator.generators.python.parser.Python3Parser.Del_stmtContext arg) {
		System.out.println("Del_stmt");
		final Node node = model.newNode(Label.label("Del_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPass_stmt(com.generator.generators.python.parser.Python3Parser.Pass_stmtContext arg) {
		System.out.println("Pass_stmt");
		final Node node = model.newNode(Label.label("Pass_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFlow_stmt(com.generator.generators.python.parser.Python3Parser.Flow_stmtContext arg) {
		System.out.println("Flow_stmt");
		final Node node = model.newNode(Label.label("Flow_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreak_stmt(com.generator.generators.python.parser.Python3Parser.Break_stmtContext arg) {
		System.out.println("Break_stmt");
		final Node node = model.newNode(Label.label("Break_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinue_stmt(com.generator.generators.python.parser.Python3Parser.Continue_stmtContext arg) {
		System.out.println("Continue_stmt");
		final Node node = model.newNode(Label.label("Continue_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturn_stmt(com.generator.generators.python.parser.Python3Parser.Return_stmtContext arg) {
		System.out.println("Return_stmt");
		final Node node = model.newNode(Label.label("Return_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_stmt(com.generator.generators.python.parser.Python3Parser.Yield_stmtContext arg) {
		System.out.println("Yield_stmt");
		final Node node = model.newNode(Label.label("Yield_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRaise_stmt(com.generator.generators.python.parser.Python3Parser.Raise_stmtContext arg) {
		System.out.println("Raise_stmt");
		final Node node = model.newNode(Label.label("Raise_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_from(com.generator.generators.python.parser.Python3Parser.Import_fromContext arg) {
		System.out.println("Import_from");
		final Node node = model.newNode(Label.label("Import_from"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_as_name(com.generator.generators.python.parser.Python3Parser.Import_as_nameContext arg) {
		System.out.println("Import_as_name");
		final Node node = model.newNode(Label.label("Import_as_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_as_name(com.generator.generators.python.parser.Python3Parser.Dotted_as_nameContext arg) {
		System.out.println("Dotted_as_name");
		final Node node = model.newNode(Label.label("Dotted_as_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_as_names(com.generator.generators.python.parser.Python3Parser.Import_as_namesContext arg) {
		System.out.println("Import_as_names");
		final Node node = model.newNode(Label.label("Import_as_names"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_as_names(com.generator.generators.python.parser.Python3Parser.Dotted_as_namesContext arg) {
		System.out.println("Dotted_as_names");
		final Node node = model.newNode(Label.label("Dotted_as_names"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_name(com.generator.generators.python.parser.Python3Parser.Dotted_nameContext arg) {
		System.out.println("Dotted_name");
		final Node node = model.newNode(Label.label("Dotted_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGlobal_stmt(com.generator.generators.python.parser.Python3Parser.Global_stmtContext arg) {
		System.out.println("Global_stmt");
		final Node node = model.newNode(Label.label("Global_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonlocal_stmt(com.generator.generators.python.parser.Python3Parser.Nonlocal_stmtContext arg) {
		System.out.println("Nonlocal_stmt");
		final Node node = model.newNode(Label.label("Nonlocal_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssert_stmt(com.generator.generators.python.parser.Python3Parser.Assert_stmtContext arg) {
		System.out.println("Assert_stmt");
		final Node node = model.newNode(Label.label("Assert_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompound_stmt(com.generator.generators.python.parser.Python3Parser.Compound_stmtContext arg) {
		System.out.println("Compound_stmt");
		final Node node = model.newNode(Label.label("Compound_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_stmt(com.generator.generators.python.parser.Python3Parser.If_stmtContext arg) {
		System.out.println("If_stmt");
		final Node node = model.newNode(Label.label("If_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhile_stmt(com.generator.generators.python.parser.Python3Parser.While_stmtContext arg) {
		System.out.println("While_stmt");
		final Node node = model.newNode(Label.label("While_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFor_stmt(com.generator.generators.python.parser.Python3Parser.For_stmtContext arg) {
		System.out.println("For_stmt");
		final Node node = model.newNode(Label.label("For_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTry_stmt(com.generator.generators.python.parser.Python3Parser.Try_stmtContext arg) {
		System.out.println("Try_stmt");
		final Node node = model.newNode(Label.label("Try_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith_stmt(com.generator.generators.python.parser.Python3Parser.With_stmtContext arg) {
		System.out.println("With_stmt");
		final Node node = model.newNode(Label.label("With_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith_item(com.generator.generators.python.parser.Python3Parser.With_itemContext arg) {
		System.out.println("With_item");
		final Node node = model.newNode(Label.label("With_item"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExcept_clause(com.generator.generators.python.parser.Python3Parser.Except_clauseContext arg) {
		System.out.println("Except_clause");
		final Node node = model.newNode(Label.label("Except_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSuite(com.generator.generators.python.parser.Python3Parser.SuiteContext arg) {
		System.out.println("Suite");
		final Node node = model.newNode(Label.label("Suite"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTest(com.generator.generators.python.parser.Python3Parser.TestContext arg) {
		System.out.println("Test");
		final Node node = model.newNode(Label.label("Test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTest_nocond(com.generator.generators.python.parser.Python3Parser.Test_nocondContext arg) {
		System.out.println("Test_nocond");
		final Node node = model.newNode(Label.label("Test_nocond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdef(com.generator.generators.python.parser.Python3Parser.LambdefContext arg) {
		System.out.println("Lambdef");
		final Node node = model.newNode(Label.label("Lambdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdef_nocond(com.generator.generators.python.parser.Python3Parser.Lambdef_nocondContext arg) {
		System.out.println("Lambdef_nocond");
		final Node node = model.newNode(Label.label("Lambdef_nocond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOr_test(com.generator.generators.python.parser.Python3Parser.Or_testContext arg) {
		System.out.println("Or_test");
		final Node node = model.newNode(Label.label("Or_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnd_test(com.generator.generators.python.parser.Python3Parser.And_testContext arg) {
		System.out.println("And_test");
		final Node node = model.newNode(Label.label("And_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNot_test(com.generator.generators.python.parser.Python3Parser.Not_testContext arg) {
		System.out.println("Not_test");
		final Node node = model.newNode(Label.label("Not_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparison(com.generator.generators.python.parser.Python3Parser.ComparisonContext arg) {
		System.out.println("Comparison");
		final Node node = model.newNode(Label.label("Comparison"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_op(com.generator.generators.python.parser.Python3Parser.Comp_opContext arg) {
		System.out.println("Comp_op");
		final Node node = model.newNode(Label.label("Comp_op"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStar_expr(com.generator.generators.python.parser.Python3Parser.Star_exprContext arg) {
		System.out.println("Star_expr");
		final Node node = model.newNode(Label.label("Star_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXor_expr(com.generator.generators.python.parser.Python3Parser.Xor_exprContext arg) {
		System.out.println("Xor_expr");
		final Node node = model.newNode(Label.label("Xor_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnd_expr(com.generator.generators.python.parser.Python3Parser.And_exprContext arg) {
		System.out.println("And_expr");
		final Node node = model.newNode(Label.label("And_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShift_expr(com.generator.generators.python.parser.Python3Parser.Shift_exprContext arg) {
		System.out.println("Shift_expr");
		final Node node = model.newNode(Label.label("Shift_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArith_expr(com.generator.generators.python.parser.Python3Parser.Arith_exprContext arg) {
		System.out.println("Arith_expr");
		final Node node = model.newNode(Label.label("Arith_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTerm(com.generator.generators.python.parser.Python3Parser.TermContext arg) {
		System.out.println("Term");
		final Node node = model.newNode(Label.label("Term"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFactor(com.generator.generators.python.parser.Python3Parser.FactorContext arg) {
		System.out.println("Factor");
		final Node node = model.newNode(Label.label("Factor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPower(com.generator.generators.python.parser.Python3Parser.PowerContext arg) {
		System.out.println("Power");
		final Node node = model.newNode(Label.label("Power"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist_comp(com.generator.generators.python.parser.Python3Parser.Testlist_compContext arg) {
		System.out.println("Testlist_comp");
		final Node node = model.newNode(Label.label("Testlist_comp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrailer(com.generator.generators.python.parser.Python3Parser.TrailerContext arg) {
		System.out.println("Trailer");
		final Node node = model.newNode(Label.label("Trailer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubscriptlist(com.generator.generators.python.parser.Python3Parser.SubscriptlistContext arg) {
		System.out.println("Subscriptlist");
		final Node node = model.newNode(Label.label("Subscriptlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubscript(com.generator.generators.python.parser.Python3Parser.SubscriptContext arg) {
		System.out.println("Subscript");
		final Node node = model.newNode(Label.label("Subscript"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSliceop(com.generator.generators.python.parser.Python3Parser.SliceopContext arg) {
		System.out.println("Sliceop");
		final Node node = model.newNode(Label.label("Sliceop"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprlist(com.generator.generators.python.parser.Python3Parser.ExprlistContext arg) {
		System.out.println("Exprlist");
		final Node node = model.newNode(Label.label("Exprlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist(com.generator.generators.python.parser.Python3Parser.TestlistContext arg) {
		System.out.println("Testlist");
		final Node node = model.newNode(Label.label("Testlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDictorsetmaker(com.generator.generators.python.parser.Python3Parser.DictorsetmakerContext arg) {
		System.out.println("Dictorsetmaker");
		final Node node = model.newNode(Label.label("Dictorsetmaker"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassdef(com.generator.generators.python.parser.Python3Parser.ClassdefContext arg) {
		System.out.println("Classdef");
		final Node node = model.newNode(Label.label("Classdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArglist(com.generator.generators.python.parser.Python3Parser.ArglistContext arg) {
		System.out.println("Arglist");
		final Node node = model.newNode(Label.label("Arglist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgument(com.generator.generators.python.parser.Python3Parser.ArgumentContext arg) {
		System.out.println("Argument");
		final Node node = model.newNode(Label.label("Argument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_iter(com.generator.generators.python.parser.Python3Parser.Comp_iterContext arg) {
		System.out.println("Comp_iter");
		final Node node = model.newNode(Label.label("Comp_iter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_for(com.generator.generators.python.parser.Python3Parser.Comp_forContext arg) {
		System.out.println("Comp_for");
		final Node node = model.newNode(Label.label("Comp_for"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_if(com.generator.generators.python.parser.Python3Parser.Comp_ifContext arg) {
		System.out.println("Comp_if");
		final Node node = model.newNode(Label.label("Comp_if"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_expr(com.generator.generators.python.parser.Python3Parser.Yield_exprContext arg) {
		System.out.println("Yield_expr");
		final Node node = model.newNode(Label.label("Yield_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_arg(com.generator.generators.python.parser.Python3Parser.Yield_argContext arg) {
		System.out.println("Yield_arg");
		final Node node = model.newNode(Label.label("Yield_arg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStr(com.generator.generators.python.parser.Python3Parser.StrContext arg) {
		System.out.println("Str");
		final Node node = model.newNode(Label.label("Str"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInteger(com.generator.generators.python.parser.Python3Parser.IntegerContext arg) {
		System.out.println("Integer");
		final Node node = model.newNode(Label.label("Integer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtom(com.generator.generators.python.parser.Python3Parser.AtomContext arg) {
		System.out.println("Atom");
		final Node node = model.newNode(Label.label("Atom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingle_input(com.generator.generators.python.parser.Python3Parser.Single_inputContext arg) {
		System.out.println("Single_input");
		final Node node = model.newNode(Label.label("Single_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_stmt(com.generator.generators.python.parser.Python3Parser.Import_stmtContext arg) {
		System.out.println("Import_stmt");
		final Node node = model.newNode(Label.label("Import_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_name(com.generator.generators.python.parser.Python3Parser.Import_nameContext arg) {
		System.out.println("Import_name");
		final Node node = model.newNode(Label.label("Import_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile_input(com.generator.generators.python.parser.Python3Parser.File_inputContext arg) {
		System.out.println("File_input");
		final Node node = model.newNode(Label.label("File_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEval_input(com.generator.generators.python.parser.Python3Parser.Eval_inputContext arg) {
		System.out.println("Eval_input");
		final Node node = model.newNode(Label.label("Eval_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorator(com.generator.generators.python.parser.Python3Parser.DecoratorContext arg) {
		System.out.println("Decorator");
		final Node node = model.newNode(Label.label("Decorator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorators(com.generator.generators.python.parser.Python3Parser.DecoratorsContext arg) {
		System.out.println("Decorators");
		final Node node = model.newNode(Label.label("Decorators"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorated(com.generator.generators.python.parser.Python3Parser.DecoratedContext arg) {
		System.out.println("Decorated");
		final Node node = model.newNode(Label.label("Decorated"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncdef(com.generator.generators.python.parser.Python3Parser.FuncdefContext arg) {
		System.out.println("Funcdef");
		final Node node = model.newNode(Label.label("Funcdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.python.parser.Python3Parser.NumberContext arg) {
		System.out.println("Number");
		final Node node = model.newNode(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.python.parser.Python3Parser.ExprContext arg) {
		System.out.println("Expr");
		final Node node = model.newNode(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameters(com.generator.generators.python.parser.Python3Parser.ParametersContext arg) {
		System.out.println("Parameters");
		final Node node = model.newNode(Label.label("Parameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}