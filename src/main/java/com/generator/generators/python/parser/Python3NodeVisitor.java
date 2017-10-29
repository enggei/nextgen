package com.generator.generators.python.parser;

public class Python3NodeVisitor extends Python3BaseVisitor<Python3NodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final String endToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken, String endToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
			this.endToken = endToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public Python3NodeVisitor() {
		this(false);
	}

	public Python3NodeVisitor(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
				if (debug) System.out.println(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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

	@Override
	public Node visitGlobal_stmt(com.generator.generators.python.parser.Python3Parser.Global_stmtContext arg) {
		final Node node = new Node("Global_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonlocal_stmt(com.generator.generators.python.parser.Python3Parser.Nonlocal_stmtContext arg) {
		final Node node = new Node("Nonlocal_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssert_stmt(com.generator.generators.python.parser.Python3Parser.Assert_stmtContext arg) {
		final Node node = new Node("Assert_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompound_stmt(com.generator.generators.python.parser.Python3Parser.Compound_stmtContext arg) {
		final Node node = new Node("Compound_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIf_stmt(com.generator.generators.python.parser.Python3Parser.If_stmtContext arg) {
		final Node node = new Node("If_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhile_stmt(com.generator.generators.python.parser.Python3Parser.While_stmtContext arg) {
		final Node node = new Node("While_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFor_stmt(com.generator.generators.python.parser.Python3Parser.For_stmtContext arg) {
		final Node node = new Node("For_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTry_stmt(com.generator.generators.python.parser.Python3Parser.Try_stmtContext arg) {
		final Node node = new Node("Try_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith_stmt(com.generator.generators.python.parser.Python3Parser.With_stmtContext arg) {
		final Node node = new Node("With_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith_item(com.generator.generators.python.parser.Python3Parser.With_itemContext arg) {
		final Node node = new Node("With_item", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExcept_clause(com.generator.generators.python.parser.Python3Parser.Except_clauseContext arg) {
		final Node node = new Node("Except_clause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSuite(com.generator.generators.python.parser.Python3Parser.SuiteContext arg) {
		final Node node = new Node("Suite", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTest(com.generator.generators.python.parser.Python3Parser.TestContext arg) {
		final Node node = new Node("Test", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTest_nocond(com.generator.generators.python.parser.Python3Parser.Test_nocondContext arg) {
		final Node node = new Node("Test_nocond", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdef(com.generator.generators.python.parser.Python3Parser.LambdefContext arg) {
		final Node node = new Node("Lambdef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdef_nocond(com.generator.generators.python.parser.Python3Parser.Lambdef_nocondContext arg) {
		final Node node = new Node("Lambdef_nocond", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOr_test(com.generator.generators.python.parser.Python3Parser.Or_testContext arg) {
		final Node node = new Node("Or_test", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnd_test(com.generator.generators.python.parser.Python3Parser.And_testContext arg) {
		final Node node = new Node("And_test", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNot_test(com.generator.generators.python.parser.Python3Parser.Not_testContext arg) {
		final Node node = new Node("Not_test", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparison(com.generator.generators.python.parser.Python3Parser.ComparisonContext arg) {
		final Node node = new Node("Comparison", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_op(com.generator.generators.python.parser.Python3Parser.Comp_opContext arg) {
		final Node node = new Node("Comp_op", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStar_expr(com.generator.generators.python.parser.Python3Parser.Star_exprContext arg) {
		final Node node = new Node("Star_expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXor_expr(com.generator.generators.python.parser.Python3Parser.Xor_exprContext arg) {
		final Node node = new Node("Xor_expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnd_expr(com.generator.generators.python.parser.Python3Parser.And_exprContext arg) {
		final Node node = new Node("And_expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShift_expr(com.generator.generators.python.parser.Python3Parser.Shift_exprContext arg) {
		final Node node = new Node("Shift_expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArith_expr(com.generator.generators.python.parser.Python3Parser.Arith_exprContext arg) {
		final Node node = new Node("Arith_expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTerm(com.generator.generators.python.parser.Python3Parser.TermContext arg) {
		final Node node = new Node("Term", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFactor(com.generator.generators.python.parser.Python3Parser.FactorContext arg) {
		final Node node = new Node("Factor", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPower(com.generator.generators.python.parser.Python3Parser.PowerContext arg) {
		final Node node = new Node("Power", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist_comp(com.generator.generators.python.parser.Python3Parser.Testlist_compContext arg) {
		final Node node = new Node("Testlist_comp", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrailer(com.generator.generators.python.parser.Python3Parser.TrailerContext arg) {
		final Node node = new Node("Trailer", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubscriptlist(com.generator.generators.python.parser.Python3Parser.SubscriptlistContext arg) {
		final Node node = new Node("Subscriptlist", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubscript(com.generator.generators.python.parser.Python3Parser.SubscriptContext arg) {
		final Node node = new Node("Subscript", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSliceop(com.generator.generators.python.parser.Python3Parser.SliceopContext arg) {
		final Node node = new Node("Sliceop", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprlist(com.generator.generators.python.parser.Python3Parser.ExprlistContext arg) {
		final Node node = new Node("Exprlist", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist(com.generator.generators.python.parser.Python3Parser.TestlistContext arg) {
		final Node node = new Node("Testlist", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDictorsetmaker(com.generator.generators.python.parser.Python3Parser.DictorsetmakerContext arg) {
		final Node node = new Node("Dictorsetmaker", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassdef(com.generator.generators.python.parser.Python3Parser.ClassdefContext arg) {
		final Node node = new Node("Classdef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArglist(com.generator.generators.python.parser.Python3Parser.ArglistContext arg) {
		final Node node = new Node("Arglist", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgument(com.generator.generators.python.parser.Python3Parser.ArgumentContext arg) {
		final Node node = new Node("Argument", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_iter(com.generator.generators.python.parser.Python3Parser.Comp_iterContext arg) {
		final Node node = new Node("Comp_iter", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_for(com.generator.generators.python.parser.Python3Parser.Comp_forContext arg) {
		final Node node = new Node("Comp_for", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComp_if(com.generator.generators.python.parser.Python3Parser.Comp_ifContext arg) {
		final Node node = new Node("Comp_if", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_expr(com.generator.generators.python.parser.Python3Parser.Yield_exprContext arg) {
		final Node node = new Node("Yield_expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_arg(com.generator.generators.python.parser.Python3Parser.Yield_argContext arg) {
		final Node node = new Node("Yield_arg", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStr(com.generator.generators.python.parser.Python3Parser.StrContext arg) {
		final Node node = new Node("Str", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInteger(com.generator.generators.python.parser.Python3Parser.IntegerContext arg) {
		final Node node = new Node("Integer", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingle_input(com.generator.generators.python.parser.Python3Parser.Single_inputContext arg) {
		final Node node = new Node("Single_input", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile_input(com.generator.generators.python.parser.Python3Parser.File_inputContext arg) {
		final Node node = new Node("File_input", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEval_input(com.generator.generators.python.parser.Python3Parser.Eval_inputContext arg) {
		final Node node = new Node("Eval_input", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorator(com.generator.generators.python.parser.Python3Parser.DecoratorContext arg) {
		final Node node = new Node("Decorator", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorators(com.generator.generators.python.parser.Python3Parser.DecoratorsContext arg) {
		final Node node = new Node("Decorators", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecorated(com.generator.generators.python.parser.Python3Parser.DecoratedContext arg) {
		final Node node = new Node("Decorated", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncdef(com.generator.generators.python.parser.Python3Parser.FuncdefContext arg) {
		final Node node = new Node("Funcdef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypedargslist(com.generator.generators.python.parser.Python3Parser.TypedargslistContext arg) {
		final Node node = new Node("Typedargslist", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTfpdef(com.generator.generators.python.parser.Python3Parser.TfpdefContext arg) {
		final Node node = new Node("Tfpdef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarargslist(com.generator.generators.python.parser.Python3Parser.VarargslistContext arg) {
		final Node node = new Node("Varargslist", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVfpdef(com.generator.generators.python.parser.Python3Parser.VfpdefContext arg) {
		final Node node = new Node("Vfpdef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStmt(com.generator.generators.python.parser.Python3Parser.StmtContext arg) {
		final Node node = new Node("Stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_stmt(com.generator.generators.python.parser.Python3Parser.Simple_stmtContext arg) {
		final Node node = new Node("Simple_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSmall_stmt(com.generator.generators.python.parser.Python3Parser.Small_stmtContext arg) {
		final Node node = new Node("Small_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrint_stmt(com.generator.generators.python.parser.Python3Parser.Print_stmtContext arg) {
		final Node node = new Node("Print_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr_stmt(com.generator.generators.python.parser.Python3Parser.Expr_stmtContext arg) {
		final Node node = new Node("Expr_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTestlist_star_expr(com.generator.generators.python.parser.Python3Parser.Testlist_star_exprContext arg) {
		final Node node = new Node("Testlist_star_expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAugassign(com.generator.generators.python.parser.Python3Parser.AugassignContext arg) {
		final Node node = new Node("Augassign", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDel_stmt(com.generator.generators.python.parser.Python3Parser.Del_stmtContext arg) {
		final Node node = new Node("Del_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPass_stmt(com.generator.generators.python.parser.Python3Parser.Pass_stmtContext arg) {
		final Node node = new Node("Pass_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFlow_stmt(com.generator.generators.python.parser.Python3Parser.Flow_stmtContext arg) {
		final Node node = new Node("Flow_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreak_stmt(com.generator.generators.python.parser.Python3Parser.Break_stmtContext arg) {
		final Node node = new Node("Break_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinue_stmt(com.generator.generators.python.parser.Python3Parser.Continue_stmtContext arg) {
		final Node node = new Node("Continue_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturn_stmt(com.generator.generators.python.parser.Python3Parser.Return_stmtContext arg) {
		final Node node = new Node("Return_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYield_stmt(com.generator.generators.python.parser.Python3Parser.Yield_stmtContext arg) {
		final Node node = new Node("Yield_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRaise_stmt(com.generator.generators.python.parser.Python3Parser.Raise_stmtContext arg) {
		final Node node = new Node("Raise_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_stmt(com.generator.generators.python.parser.Python3Parser.Import_stmtContext arg) {
		final Node node = new Node("Import_stmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_name(com.generator.generators.python.parser.Python3Parser.Import_nameContext arg) {
		final Node node = new Node("Import_name", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_from(com.generator.generators.python.parser.Python3Parser.Import_fromContext arg) {
		final Node node = new Node("Import_from", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_as_name(com.generator.generators.python.parser.Python3Parser.Import_as_nameContext arg) {
		final Node node = new Node("Import_as_name", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_as_name(com.generator.generators.python.parser.Python3Parser.Dotted_as_nameContext arg) {
		final Node node = new Node("Dotted_as_name", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_as_names(com.generator.generators.python.parser.Python3Parser.Import_as_namesContext arg) {
		final Node node = new Node("Import_as_names", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_as_names(com.generator.generators.python.parser.Python3Parser.Dotted_as_namesContext arg) {
		final Node node = new Node("Dotted_as_names", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDotted_name(com.generator.generators.python.parser.Python3Parser.Dotted_nameContext arg) {
		final Node node = new Node("Dotted_name", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtom(com.generator.generators.python.parser.Python3Parser.AtomContext arg) {
		final Node node = new Node("Atom", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.python.parser.Python3Parser.NumberContext arg) {
		final Node node = new Node("Number", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.python.parser.Python3Parser.ExprContext arg) {
		final Node node = new Node("Expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameters(com.generator.generators.python.parser.Python3Parser.ParametersContext arg) {
		final Node node = new Node("Parameters", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}