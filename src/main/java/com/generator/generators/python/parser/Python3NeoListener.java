package com.generator.generators.python.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class Python3NeoListener extends Python3BaseListener {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Python3NeoListener.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public Python3NeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public Python3NeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inAtom = new java.util.Stack<>();

	@Override
	public void enterAtom(com.generator.generators.python.parser.Python3Parser.AtomContext arg) {
		final Node node = model.newNode(Label.label("Atom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAtom.push(true);
	}

	public void exitAtom(com.generator.generators.python.parser.Python3Parser.AtomContext arg) {
		onExit();
		this.inAtom.pop();
	}

	public boolean inAtom() {
      return !inAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumber = new java.util.Stack<>();

	@Override
	public void enterNumber(com.generator.generators.python.parser.Python3Parser.NumberContext arg) {
		final Node node = model.newNode(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNumber.push(true);
	}

	public void exitNumber(com.generator.generators.python.parser.Python3Parser.NumberContext arg) {
		onExit();
		this.inNumber.pop();
	}

	public boolean inNumber() {
      return !inNumber.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpr = new java.util.Stack<>();

	@Override
	public void enterExpr(com.generator.generators.python.parser.Python3Parser.ExprContext arg) {
		final Node node = model.newNode(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpr.push(true);
	}

	public void exitExpr(com.generator.generators.python.parser.Python3Parser.ExprContext arg) {
		onExit();
		this.inExpr.pop();
	}

	public boolean inExpr() {
      return !inExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameters = new java.util.Stack<>();

	@Override
	public void enterParameters(com.generator.generators.python.parser.Python3Parser.ParametersContext arg) {
		final Node node = model.newNode(Label.label("Parameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParameters.push(true);
	}

	public void exitParameters(com.generator.generators.python.parser.Python3Parser.ParametersContext arg) {
		onExit();
		this.inParameters.pop();
	}

	public boolean inParameters() {
      return !inParameters.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgument = new java.util.Stack<>();

	@Override
	public void enterArgument(com.generator.generators.python.parser.Python3Parser.ArgumentContext arg) {
		final Node node = model.newNode(Label.label("Argument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArgument.push(true);
	}

	public void exitArgument(com.generator.generators.python.parser.Python3Parser.ArgumentContext arg) {
		onExit();
		this.inArgument.pop();
	}

	public boolean inArgument() {
      return !inArgument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSingle_input = new java.util.Stack<>();

	@Override
	public void enterSingle_input(com.generator.generators.python.parser.Python3Parser.Single_inputContext arg) {
		final Node node = model.newNode(Label.label("Single_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSingle_input.push(true);
	}

	public void exitSingle_input(com.generator.generators.python.parser.Python3Parser.Single_inputContext arg) {
		onExit();
		this.inSingle_input.pop();
	}

	public boolean inSingle_input() {
      return !inSingle_input.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFile_input = new java.util.Stack<>();

	@Override
	public void enterFile_input(com.generator.generators.python.parser.Python3Parser.File_inputContext arg) {
		final Node node = model.newNode(Label.label("File_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFile_input.push(true);
	}

	public void exitFile_input(com.generator.generators.python.parser.Python3Parser.File_inputContext arg) {
		onExit();
		this.inFile_input.pop();
	}

	public boolean inFile_input() {
      return !inFile_input.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEval_input = new java.util.Stack<>();

	@Override
	public void enterEval_input(com.generator.generators.python.parser.Python3Parser.Eval_inputContext arg) {
		final Node node = model.newNode(Label.label("Eval_input"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEval_input.push(true);
	}

	public void exitEval_input(com.generator.generators.python.parser.Python3Parser.Eval_inputContext arg) {
		onExit();
		this.inEval_input.pop();
	}

	public boolean inEval_input() {
      return !inEval_input.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDecorator = new java.util.Stack<>();

	@Override
	public void enterDecorator(com.generator.generators.python.parser.Python3Parser.DecoratorContext arg) {
		final Node node = model.newNode(Label.label("Decorator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDecorator.push(true);
	}

	public void exitDecorator(com.generator.generators.python.parser.Python3Parser.DecoratorContext arg) {
		onExit();
		this.inDecorator.pop();
	}

	public boolean inDecorator() {
      return !inDecorator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDecorators = new java.util.Stack<>();

	@Override
	public void enterDecorators(com.generator.generators.python.parser.Python3Parser.DecoratorsContext arg) {
		final Node node = model.newNode(Label.label("Decorators"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDecorators.push(true);
	}

	public void exitDecorators(com.generator.generators.python.parser.Python3Parser.DecoratorsContext arg) {
		onExit();
		this.inDecorators.pop();
	}

	public boolean inDecorators() {
      return !inDecorators.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDecorated = new java.util.Stack<>();

	@Override
	public void enterDecorated(com.generator.generators.python.parser.Python3Parser.DecoratedContext arg) {
		final Node node = model.newNode(Label.label("Decorated"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDecorated.push(true);
	}

	public void exitDecorated(com.generator.generators.python.parser.Python3Parser.DecoratedContext arg) {
		onExit();
		this.inDecorated.pop();
	}

	public boolean inDecorated() {
      return !inDecorated.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFuncdef = new java.util.Stack<>();

	@Override
	public void enterFuncdef(com.generator.generators.python.parser.Python3Parser.FuncdefContext arg) {
		final Node node = model.newNode(Label.label("Funcdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFuncdef.push(true);
	}

	public void exitFuncdef(com.generator.generators.python.parser.Python3Parser.FuncdefContext arg) {
		onExit();
		this.inFuncdef.pop();
	}

	public boolean inFuncdef() {
      return !inFuncdef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypedargslist = new java.util.Stack<>();

	@Override
	public void enterTypedargslist(com.generator.generators.python.parser.Python3Parser.TypedargslistContext arg) {
		final Node node = model.newNode(Label.label("Typedargslist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypedargslist.push(true);
	}

	public void exitTypedargslist(com.generator.generators.python.parser.Python3Parser.TypedargslistContext arg) {
		onExit();
		this.inTypedargslist.pop();
	}

	public boolean inTypedargslist() {
      return !inTypedargslist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTfpdef = new java.util.Stack<>();

	@Override
	public void enterTfpdef(com.generator.generators.python.parser.Python3Parser.TfpdefContext arg) {
		final Node node = model.newNode(Label.label("Tfpdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTfpdef.push(true);
	}

	public void exitTfpdef(com.generator.generators.python.parser.Python3Parser.TfpdefContext arg) {
		onExit();
		this.inTfpdef.pop();
	}

	public boolean inTfpdef() {
      return !inTfpdef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarargslist = new java.util.Stack<>();

	@Override
	public void enterVarargslist(com.generator.generators.python.parser.Python3Parser.VarargslistContext arg) {
		final Node node = model.newNode(Label.label("Varargslist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVarargslist.push(true);
	}

	public void exitVarargslist(com.generator.generators.python.parser.Python3Parser.VarargslistContext arg) {
		onExit();
		this.inVarargslist.pop();
	}

	public boolean inVarargslist() {
      return !inVarargslist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVfpdef = new java.util.Stack<>();

	@Override
	public void enterVfpdef(com.generator.generators.python.parser.Python3Parser.VfpdefContext arg) {
		final Node node = model.newNode(Label.label("Vfpdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVfpdef.push(true);
	}

	public void exitVfpdef(com.generator.generators.python.parser.Python3Parser.VfpdefContext arg) {
		onExit();
		this.inVfpdef.pop();
	}

	public boolean inVfpdef() {
      return !inVfpdef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStmt = new java.util.Stack<>();

	@Override
	public void enterStmt(com.generator.generators.python.parser.Python3Parser.StmtContext arg) {
		final Node node = model.newNode(Label.label("Stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStmt.push(true);
	}

	public void exitStmt(com.generator.generators.python.parser.Python3Parser.StmtContext arg) {
		onExit();
		this.inStmt.pop();
	}

	public boolean inStmt() {
      return !inStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimple_stmt = new java.util.Stack<>();

	@Override
	public void enterSimple_stmt(com.generator.generators.python.parser.Python3Parser.Simple_stmtContext arg) {
		final Node node = model.newNode(Label.label("Simple_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimple_stmt.push(true);
	}

	public void exitSimple_stmt(com.generator.generators.python.parser.Python3Parser.Simple_stmtContext arg) {
		onExit();
		this.inSimple_stmt.pop();
	}

	public boolean inSimple_stmt() {
      return !inSimple_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSmall_stmt = new java.util.Stack<>();

	@Override
	public void enterSmall_stmt(com.generator.generators.python.parser.Python3Parser.Small_stmtContext arg) {
		final Node node = model.newNode(Label.label("Small_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSmall_stmt.push(true);
	}

	public void exitSmall_stmt(com.generator.generators.python.parser.Python3Parser.Small_stmtContext arg) {
		onExit();
		this.inSmall_stmt.pop();
	}

	public boolean inSmall_stmt() {
      return !inSmall_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrint_stmt = new java.util.Stack<>();

	@Override
	public void enterPrint_stmt(com.generator.generators.python.parser.Python3Parser.Print_stmtContext arg) {
		final Node node = model.newNode(Label.label("Print_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrint_stmt.push(true);
	}

	public void exitPrint_stmt(com.generator.generators.python.parser.Python3Parser.Print_stmtContext arg) {
		onExit();
		this.inPrint_stmt.pop();
	}

	public boolean inPrint_stmt() {
      return !inPrint_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpr_stmt = new java.util.Stack<>();

	@Override
	public void enterExpr_stmt(com.generator.generators.python.parser.Python3Parser.Expr_stmtContext arg) {
		final Node node = model.newNode(Label.label("Expr_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpr_stmt.push(true);
	}

	public void exitExpr_stmt(com.generator.generators.python.parser.Python3Parser.Expr_stmtContext arg) {
		onExit();
		this.inExpr_stmt.pop();
	}

	public boolean inExpr_stmt() {
      return !inExpr_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTestlist_star_expr = new java.util.Stack<>();

	@Override
	public void enterTestlist_star_expr(com.generator.generators.python.parser.Python3Parser.Testlist_star_exprContext arg) {
		final Node node = model.newNode(Label.label("Testlist_star_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTestlist_star_expr.push(true);
	}

	public void exitTestlist_star_expr(com.generator.generators.python.parser.Python3Parser.Testlist_star_exprContext arg) {
		onExit();
		this.inTestlist_star_expr.pop();
	}

	public boolean inTestlist_star_expr() {
      return !inTestlist_star_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAugassign = new java.util.Stack<>();

	@Override
	public void enterAugassign(com.generator.generators.python.parser.Python3Parser.AugassignContext arg) {
		final Node node = model.newNode(Label.label("Augassign"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAugassign.push(true);
	}

	public void exitAugassign(com.generator.generators.python.parser.Python3Parser.AugassignContext arg) {
		onExit();
		this.inAugassign.pop();
	}

	public boolean inAugassign() {
      return !inAugassign.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDel_stmt = new java.util.Stack<>();

	@Override
	public void enterDel_stmt(com.generator.generators.python.parser.Python3Parser.Del_stmtContext arg) {
		final Node node = model.newNode(Label.label("Del_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDel_stmt.push(true);
	}

	public void exitDel_stmt(com.generator.generators.python.parser.Python3Parser.Del_stmtContext arg) {
		onExit();
		this.inDel_stmt.pop();
	}

	public boolean inDel_stmt() {
      return !inDel_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPass_stmt = new java.util.Stack<>();

	@Override
	public void enterPass_stmt(com.generator.generators.python.parser.Python3Parser.Pass_stmtContext arg) {
		final Node node = model.newNode(Label.label("Pass_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPass_stmt.push(true);
	}

	public void exitPass_stmt(com.generator.generators.python.parser.Python3Parser.Pass_stmtContext arg) {
		onExit();
		this.inPass_stmt.pop();
	}

	public boolean inPass_stmt() {
      return !inPass_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFlow_stmt = new java.util.Stack<>();

	@Override
	public void enterFlow_stmt(com.generator.generators.python.parser.Python3Parser.Flow_stmtContext arg) {
		final Node node = model.newNode(Label.label("Flow_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFlow_stmt.push(true);
	}

	public void exitFlow_stmt(com.generator.generators.python.parser.Python3Parser.Flow_stmtContext arg) {
		onExit();
		this.inFlow_stmt.pop();
	}

	public boolean inFlow_stmt() {
      return !inFlow_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBreak_stmt = new java.util.Stack<>();

	@Override
	public void enterBreak_stmt(com.generator.generators.python.parser.Python3Parser.Break_stmtContext arg) {
		final Node node = model.newNode(Label.label("Break_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBreak_stmt.push(true);
	}

	public void exitBreak_stmt(com.generator.generators.python.parser.Python3Parser.Break_stmtContext arg) {
		onExit();
		this.inBreak_stmt.pop();
	}

	public boolean inBreak_stmt() {
      return !inBreak_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inContinue_stmt = new java.util.Stack<>();

	@Override
	public void enterContinue_stmt(com.generator.generators.python.parser.Python3Parser.Continue_stmtContext arg) {
		final Node node = model.newNode(Label.label("Continue_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inContinue_stmt.push(true);
	}

	public void exitContinue_stmt(com.generator.generators.python.parser.Python3Parser.Continue_stmtContext arg) {
		onExit();
		this.inContinue_stmt.pop();
	}

	public boolean inContinue_stmt() {
      return !inContinue_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturn_stmt = new java.util.Stack<>();

	@Override
	public void enterReturn_stmt(com.generator.generators.python.parser.Python3Parser.Return_stmtContext arg) {
		final Node node = model.newNode(Label.label("Return_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReturn_stmt.push(true);
	}

	public void exitReturn_stmt(com.generator.generators.python.parser.Python3Parser.Return_stmtContext arg) {
		onExit();
		this.inReturn_stmt.pop();
	}

	public boolean inReturn_stmt() {
      return !inReturn_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inYield_stmt = new java.util.Stack<>();

	@Override
	public void enterYield_stmt(com.generator.generators.python.parser.Python3Parser.Yield_stmtContext arg) {
		final Node node = model.newNode(Label.label("Yield_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inYield_stmt.push(true);
	}

	public void exitYield_stmt(com.generator.generators.python.parser.Python3Parser.Yield_stmtContext arg) {
		onExit();
		this.inYield_stmt.pop();
	}

	public boolean inYield_stmt() {
      return !inYield_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRaise_stmt = new java.util.Stack<>();

	@Override
	public void enterRaise_stmt(com.generator.generators.python.parser.Python3Parser.Raise_stmtContext arg) {
		final Node node = model.newNode(Label.label("Raise_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRaise_stmt.push(true);
	}

	public void exitRaise_stmt(com.generator.generators.python.parser.Python3Parser.Raise_stmtContext arg) {
		onExit();
		this.inRaise_stmt.pop();
	}

	public boolean inRaise_stmt() {
      return !inRaise_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImport_stmt = new java.util.Stack<>();

	@Override
	public void enterImport_stmt(com.generator.generators.python.parser.Python3Parser.Import_stmtContext arg) {
		final Node node = model.newNode(Label.label("Import_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImport_stmt.push(true);
	}

	public void exitImport_stmt(com.generator.generators.python.parser.Python3Parser.Import_stmtContext arg) {
		onExit();
		this.inImport_stmt.pop();
	}

	public boolean inImport_stmt() {
      return !inImport_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImport_name = new java.util.Stack<>();

	@Override
	public void enterImport_name(com.generator.generators.python.parser.Python3Parser.Import_nameContext arg) {
		final Node node = model.newNode(Label.label("Import_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImport_name.push(true);
	}

	public void exitImport_name(com.generator.generators.python.parser.Python3Parser.Import_nameContext arg) {
		onExit();
		this.inImport_name.pop();
	}

	public boolean inImport_name() {
      return !inImport_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImport_from = new java.util.Stack<>();

	@Override
	public void enterImport_from(com.generator.generators.python.parser.Python3Parser.Import_fromContext arg) {
		final Node node = model.newNode(Label.label("Import_from"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImport_from.push(true);
	}

	public void exitImport_from(com.generator.generators.python.parser.Python3Parser.Import_fromContext arg) {
		onExit();
		this.inImport_from.pop();
	}

	public boolean inImport_from() {
      return !inImport_from.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImport_as_name = new java.util.Stack<>();

	@Override
	public void enterImport_as_name(com.generator.generators.python.parser.Python3Parser.Import_as_nameContext arg) {
		final Node node = model.newNode(Label.label("Import_as_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImport_as_name.push(true);
	}

	public void exitImport_as_name(com.generator.generators.python.parser.Python3Parser.Import_as_nameContext arg) {
		onExit();
		this.inImport_as_name.pop();
	}

	public boolean inImport_as_name() {
      return !inImport_as_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDotted_as_name = new java.util.Stack<>();

	@Override
	public void enterDotted_as_name(com.generator.generators.python.parser.Python3Parser.Dotted_as_nameContext arg) {
		final Node node = model.newNode(Label.label("Dotted_as_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDotted_as_name.push(true);
	}

	public void exitDotted_as_name(com.generator.generators.python.parser.Python3Parser.Dotted_as_nameContext arg) {
		onExit();
		this.inDotted_as_name.pop();
	}

	public boolean inDotted_as_name() {
      return !inDotted_as_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImport_as_names = new java.util.Stack<>();

	@Override
	public void enterImport_as_names(com.generator.generators.python.parser.Python3Parser.Import_as_namesContext arg) {
		final Node node = model.newNode(Label.label("Import_as_names"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImport_as_names.push(true);
	}

	public void exitImport_as_names(com.generator.generators.python.parser.Python3Parser.Import_as_namesContext arg) {
		onExit();
		this.inImport_as_names.pop();
	}

	public boolean inImport_as_names() {
      return !inImport_as_names.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDotted_as_names = new java.util.Stack<>();

	@Override
	public void enterDotted_as_names(com.generator.generators.python.parser.Python3Parser.Dotted_as_namesContext arg) {
		final Node node = model.newNode(Label.label("Dotted_as_names"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDotted_as_names.push(true);
	}

	public void exitDotted_as_names(com.generator.generators.python.parser.Python3Parser.Dotted_as_namesContext arg) {
		onExit();
		this.inDotted_as_names.pop();
	}

	public boolean inDotted_as_names() {
      return !inDotted_as_names.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDotted_name = new java.util.Stack<>();

	@Override
	public void enterDotted_name(com.generator.generators.python.parser.Python3Parser.Dotted_nameContext arg) {
		final Node node = model.newNode(Label.label("Dotted_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDotted_name.push(true);
	}

	public void exitDotted_name(com.generator.generators.python.parser.Python3Parser.Dotted_nameContext arg) {
		onExit();
		this.inDotted_name.pop();
	}

	public boolean inDotted_name() {
      return !inDotted_name.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGlobal_stmt = new java.util.Stack<>();

	@Override
	public void enterGlobal_stmt(com.generator.generators.python.parser.Python3Parser.Global_stmtContext arg) {
		final Node node = model.newNode(Label.label("Global_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGlobal_stmt.push(true);
	}

	public void exitGlobal_stmt(com.generator.generators.python.parser.Python3Parser.Global_stmtContext arg) {
		onExit();
		this.inGlobal_stmt.pop();
	}

	public boolean inGlobal_stmt() {
      return !inGlobal_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNonlocal_stmt = new java.util.Stack<>();

	@Override
	public void enterNonlocal_stmt(com.generator.generators.python.parser.Python3Parser.Nonlocal_stmtContext arg) {
		final Node node = model.newNode(Label.label("Nonlocal_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNonlocal_stmt.push(true);
	}

	public void exitNonlocal_stmt(com.generator.generators.python.parser.Python3Parser.Nonlocal_stmtContext arg) {
		onExit();
		this.inNonlocal_stmt.pop();
	}

	public boolean inNonlocal_stmt() {
      return !inNonlocal_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssert_stmt = new java.util.Stack<>();

	@Override
	public void enterAssert_stmt(com.generator.generators.python.parser.Python3Parser.Assert_stmtContext arg) {
		final Node node = model.newNode(Label.label("Assert_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAssert_stmt.push(true);
	}

	public void exitAssert_stmt(com.generator.generators.python.parser.Python3Parser.Assert_stmtContext arg) {
		onExit();
		this.inAssert_stmt.pop();
	}

	public boolean inAssert_stmt() {
      return !inAssert_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompound_stmt = new java.util.Stack<>();

	@Override
	public void enterCompound_stmt(com.generator.generators.python.parser.Python3Parser.Compound_stmtContext arg) {
		final Node node = model.newNode(Label.label("Compound_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCompound_stmt.push(true);
	}

	public void exitCompound_stmt(com.generator.generators.python.parser.Python3Parser.Compound_stmtContext arg) {
		onExit();
		this.inCompound_stmt.pop();
	}

	public boolean inCompound_stmt() {
      return !inCompound_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIf_stmt = new java.util.Stack<>();

	@Override
	public void enterIf_stmt(com.generator.generators.python.parser.Python3Parser.If_stmtContext arg) {
		final Node node = model.newNode(Label.label("If_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIf_stmt.push(true);
	}

	public void exitIf_stmt(com.generator.generators.python.parser.Python3Parser.If_stmtContext arg) {
		onExit();
		this.inIf_stmt.pop();
	}

	public boolean inIf_stmt() {
      return !inIf_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWhile_stmt = new java.util.Stack<>();

	@Override
	public void enterWhile_stmt(com.generator.generators.python.parser.Python3Parser.While_stmtContext arg) {
		final Node node = model.newNode(Label.label("While_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inWhile_stmt.push(true);
	}

	public void exitWhile_stmt(com.generator.generators.python.parser.Python3Parser.While_stmtContext arg) {
		onExit();
		this.inWhile_stmt.pop();
	}

	public boolean inWhile_stmt() {
      return !inWhile_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFor_stmt = new java.util.Stack<>();

	@Override
	public void enterFor_stmt(com.generator.generators.python.parser.Python3Parser.For_stmtContext arg) {
		final Node node = model.newNode(Label.label("For_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFor_stmt.push(true);
	}

	public void exitFor_stmt(com.generator.generators.python.parser.Python3Parser.For_stmtContext arg) {
		onExit();
		this.inFor_stmt.pop();
	}

	public boolean inFor_stmt() {
      return !inFor_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTry_stmt = new java.util.Stack<>();

	@Override
	public void enterTry_stmt(com.generator.generators.python.parser.Python3Parser.Try_stmtContext arg) {
		final Node node = model.newNode(Label.label("Try_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTry_stmt.push(true);
	}

	public void exitTry_stmt(com.generator.generators.python.parser.Python3Parser.Try_stmtContext arg) {
		onExit();
		this.inTry_stmt.pop();
	}

	public boolean inTry_stmt() {
      return !inTry_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWith_stmt = new java.util.Stack<>();

	@Override
	public void enterWith_stmt(com.generator.generators.python.parser.Python3Parser.With_stmtContext arg) {
		final Node node = model.newNode(Label.label("With_stmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inWith_stmt.push(true);
	}

	public void exitWith_stmt(com.generator.generators.python.parser.Python3Parser.With_stmtContext arg) {
		onExit();
		this.inWith_stmt.pop();
	}

	public boolean inWith_stmt() {
      return !inWith_stmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWith_item = new java.util.Stack<>();

	@Override
	public void enterWith_item(com.generator.generators.python.parser.Python3Parser.With_itemContext arg) {
		final Node node = model.newNode(Label.label("With_item"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inWith_item.push(true);
	}

	public void exitWith_item(com.generator.generators.python.parser.Python3Parser.With_itemContext arg) {
		onExit();
		this.inWith_item.pop();
	}

	public boolean inWith_item() {
      return !inWith_item.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExcept_clause = new java.util.Stack<>();

	@Override
	public void enterExcept_clause(com.generator.generators.python.parser.Python3Parser.Except_clauseContext arg) {
		final Node node = model.newNode(Label.label("Except_clause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExcept_clause.push(true);
	}

	public void exitExcept_clause(com.generator.generators.python.parser.Python3Parser.Except_clauseContext arg) {
		onExit();
		this.inExcept_clause.pop();
	}

	public boolean inExcept_clause() {
      return !inExcept_clause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSuite = new java.util.Stack<>();

	@Override
	public void enterSuite(com.generator.generators.python.parser.Python3Parser.SuiteContext arg) {
		final Node node = model.newNode(Label.label("Suite"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSuite.push(true);
	}

	public void exitSuite(com.generator.generators.python.parser.Python3Parser.SuiteContext arg) {
		onExit();
		this.inSuite.pop();
	}

	public boolean inSuite() {
      return !inSuite.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTest = new java.util.Stack<>();

	@Override
	public void enterTest(com.generator.generators.python.parser.Python3Parser.TestContext arg) {
		final Node node = model.newNode(Label.label("Test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTest.push(true);
	}

	public void exitTest(com.generator.generators.python.parser.Python3Parser.TestContext arg) {
		onExit();
		this.inTest.pop();
	}

	public boolean inTest() {
      return !inTest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTest_nocond = new java.util.Stack<>();

	@Override
	public void enterTest_nocond(com.generator.generators.python.parser.Python3Parser.Test_nocondContext arg) {
		final Node node = model.newNode(Label.label("Test_nocond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTest_nocond.push(true);
	}

	public void exitTest_nocond(com.generator.generators.python.parser.Python3Parser.Test_nocondContext arg) {
		onExit();
		this.inTest_nocond.pop();
	}

	public boolean inTest_nocond() {
      return !inTest_nocond.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdef = new java.util.Stack<>();

	@Override
	public void enterLambdef(com.generator.generators.python.parser.Python3Parser.LambdefContext arg) {
		final Node node = model.newNode(Label.label("Lambdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLambdef.push(true);
	}

	public void exitLambdef(com.generator.generators.python.parser.Python3Parser.LambdefContext arg) {
		onExit();
		this.inLambdef.pop();
	}

	public boolean inLambdef() {
      return !inLambdef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdef_nocond = new java.util.Stack<>();

	@Override
	public void enterLambdef_nocond(com.generator.generators.python.parser.Python3Parser.Lambdef_nocondContext arg) {
		final Node node = model.newNode(Label.label("Lambdef_nocond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLambdef_nocond.push(true);
	}

	public void exitLambdef_nocond(com.generator.generators.python.parser.Python3Parser.Lambdef_nocondContext arg) {
		onExit();
		this.inLambdef_nocond.pop();
	}

	public boolean inLambdef_nocond() {
      return !inLambdef_nocond.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOr_test = new java.util.Stack<>();

	@Override
	public void enterOr_test(com.generator.generators.python.parser.Python3Parser.Or_testContext arg) {
		final Node node = model.newNode(Label.label("Or_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOr_test.push(true);
	}

	public void exitOr_test(com.generator.generators.python.parser.Python3Parser.Or_testContext arg) {
		onExit();
		this.inOr_test.pop();
	}

	public boolean inOr_test() {
      return !inOr_test.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnd_test = new java.util.Stack<>();

	@Override
	public void enterAnd_test(com.generator.generators.python.parser.Python3Parser.And_testContext arg) {
		final Node node = model.newNode(Label.label("And_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnd_test.push(true);
	}

	public void exitAnd_test(com.generator.generators.python.parser.Python3Parser.And_testContext arg) {
		onExit();
		this.inAnd_test.pop();
	}

	public boolean inAnd_test() {
      return !inAnd_test.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNot_test = new java.util.Stack<>();

	@Override
	public void enterNot_test(com.generator.generators.python.parser.Python3Parser.Not_testContext arg) {
		final Node node = model.newNode(Label.label("Not_test"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNot_test.push(true);
	}

	public void exitNot_test(com.generator.generators.python.parser.Python3Parser.Not_testContext arg) {
		onExit();
		this.inNot_test.pop();
	}

	public boolean inNot_test() {
      return !inNot_test.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComparison = new java.util.Stack<>();

	@Override
	public void enterComparison(com.generator.generators.python.parser.Python3Parser.ComparisonContext arg) {
		final Node node = model.newNode(Label.label("Comparison"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inComparison.push(true);
	}

	public void exitComparison(com.generator.generators.python.parser.Python3Parser.ComparisonContext arg) {
		onExit();
		this.inComparison.pop();
	}

	public boolean inComparison() {
      return !inComparison.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComp_op = new java.util.Stack<>();

	@Override
	public void enterComp_op(com.generator.generators.python.parser.Python3Parser.Comp_opContext arg) {
		final Node node = model.newNode(Label.label("Comp_op"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inComp_op.push(true);
	}

	public void exitComp_op(com.generator.generators.python.parser.Python3Parser.Comp_opContext arg) {
		onExit();
		this.inComp_op.pop();
	}

	public boolean inComp_op() {
      return !inComp_op.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStar_expr = new java.util.Stack<>();

	@Override
	public void enterStar_expr(com.generator.generators.python.parser.Python3Parser.Star_exprContext arg) {
		final Node node = model.newNode(Label.label("Star_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStar_expr.push(true);
	}

	public void exitStar_expr(com.generator.generators.python.parser.Python3Parser.Star_exprContext arg) {
		onExit();
		this.inStar_expr.pop();
	}

	public boolean inStar_expr() {
      return !inStar_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXor_expr = new java.util.Stack<>();

	@Override
	public void enterXor_expr(com.generator.generators.python.parser.Python3Parser.Xor_exprContext arg) {
		final Node node = model.newNode(Label.label("Xor_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXor_expr.push(true);
	}

	public void exitXor_expr(com.generator.generators.python.parser.Python3Parser.Xor_exprContext arg) {
		onExit();
		this.inXor_expr.pop();
	}

	public boolean inXor_expr() {
      return !inXor_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnd_expr = new java.util.Stack<>();

	@Override
	public void enterAnd_expr(com.generator.generators.python.parser.Python3Parser.And_exprContext arg) {
		final Node node = model.newNode(Label.label("And_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnd_expr.push(true);
	}

	public void exitAnd_expr(com.generator.generators.python.parser.Python3Parser.And_exprContext arg) {
		onExit();
		this.inAnd_expr.pop();
	}

	public boolean inAnd_expr() {
      return !inAnd_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShift_expr = new java.util.Stack<>();

	@Override
	public void enterShift_expr(com.generator.generators.python.parser.Python3Parser.Shift_exprContext arg) {
		final Node node = model.newNode(Label.label("Shift_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inShift_expr.push(true);
	}

	public void exitShift_expr(com.generator.generators.python.parser.Python3Parser.Shift_exprContext arg) {
		onExit();
		this.inShift_expr.pop();
	}

	public boolean inShift_expr() {
      return !inShift_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArith_expr = new java.util.Stack<>();

	@Override
	public void enterArith_expr(com.generator.generators.python.parser.Python3Parser.Arith_exprContext arg) {
		final Node node = model.newNode(Label.label("Arith_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArith_expr.push(true);
	}

	public void exitArith_expr(com.generator.generators.python.parser.Python3Parser.Arith_exprContext arg) {
		onExit();
		this.inArith_expr.pop();
	}

	public boolean inArith_expr() {
      return !inArith_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTerm = new java.util.Stack<>();

	@Override
	public void enterTerm(com.generator.generators.python.parser.Python3Parser.TermContext arg) {
		final Node node = model.newNode(Label.label("Term"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTerm.push(true);
	}

	public void exitTerm(com.generator.generators.python.parser.Python3Parser.TermContext arg) {
		onExit();
		this.inTerm.pop();
	}

	public boolean inTerm() {
      return !inTerm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFactor = new java.util.Stack<>();

	@Override
	public void enterFactor(com.generator.generators.python.parser.Python3Parser.FactorContext arg) {
		final Node node = model.newNode(Label.label("Factor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFactor.push(true);
	}

	public void exitFactor(com.generator.generators.python.parser.Python3Parser.FactorContext arg) {
		onExit();
		this.inFactor.pop();
	}

	public boolean inFactor() {
      return !inFactor.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPower = new java.util.Stack<>();

	@Override
	public void enterPower(com.generator.generators.python.parser.Python3Parser.PowerContext arg) {
		final Node node = model.newNode(Label.label("Power"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPower.push(true);
	}

	public void exitPower(com.generator.generators.python.parser.Python3Parser.PowerContext arg) {
		onExit();
		this.inPower.pop();
	}

	public boolean inPower() {
      return !inPower.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTestlist_comp = new java.util.Stack<>();

	@Override
	public void enterTestlist_comp(com.generator.generators.python.parser.Python3Parser.Testlist_compContext arg) {
		final Node node = model.newNode(Label.label("Testlist_comp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTestlist_comp.push(true);
	}

	public void exitTestlist_comp(com.generator.generators.python.parser.Python3Parser.Testlist_compContext arg) {
		onExit();
		this.inTestlist_comp.pop();
	}

	public boolean inTestlist_comp() {
      return !inTestlist_comp.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTrailer = new java.util.Stack<>();

	@Override
	public void enterTrailer(com.generator.generators.python.parser.Python3Parser.TrailerContext arg) {
		final Node node = model.newNode(Label.label("Trailer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTrailer.push(true);
	}

	public void exitTrailer(com.generator.generators.python.parser.Python3Parser.TrailerContext arg) {
		onExit();
		this.inTrailer.pop();
	}

	public boolean inTrailer() {
      return !inTrailer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubscriptlist = new java.util.Stack<>();

	@Override
	public void enterSubscriptlist(com.generator.generators.python.parser.Python3Parser.SubscriptlistContext arg) {
		final Node node = model.newNode(Label.label("Subscriptlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubscriptlist.push(true);
	}

	public void exitSubscriptlist(com.generator.generators.python.parser.Python3Parser.SubscriptlistContext arg) {
		onExit();
		this.inSubscriptlist.pop();
	}

	public boolean inSubscriptlist() {
      return !inSubscriptlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubscript = new java.util.Stack<>();

	@Override
	public void enterSubscript(com.generator.generators.python.parser.Python3Parser.SubscriptContext arg) {
		final Node node = model.newNode(Label.label("Subscript"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubscript.push(true);
	}

	public void exitSubscript(com.generator.generators.python.parser.Python3Parser.SubscriptContext arg) {
		onExit();
		this.inSubscript.pop();
	}

	public boolean inSubscript() {
      return !inSubscript.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSliceop = new java.util.Stack<>();

	@Override
	public void enterSliceop(com.generator.generators.python.parser.Python3Parser.SliceopContext arg) {
		final Node node = model.newNode(Label.label("Sliceop"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSliceop.push(true);
	}

	public void exitSliceop(com.generator.generators.python.parser.Python3Parser.SliceopContext arg) {
		onExit();
		this.inSliceop.pop();
	}

	public boolean inSliceop() {
      return !inSliceop.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprlist = new java.util.Stack<>();

	@Override
	public void enterExprlist(com.generator.generators.python.parser.Python3Parser.ExprlistContext arg) {
		final Node node = model.newNode(Label.label("Exprlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExprlist.push(true);
	}

	public void exitExprlist(com.generator.generators.python.parser.Python3Parser.ExprlistContext arg) {
		onExit();
		this.inExprlist.pop();
	}

	public boolean inExprlist() {
      return !inExprlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTestlist = new java.util.Stack<>();

	@Override
	public void enterTestlist(com.generator.generators.python.parser.Python3Parser.TestlistContext arg) {
		final Node node = model.newNode(Label.label("Testlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTestlist.push(true);
	}

	public void exitTestlist(com.generator.generators.python.parser.Python3Parser.TestlistContext arg) {
		onExit();
		this.inTestlist.pop();
	}

	public boolean inTestlist() {
      return !inTestlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDictorsetmaker = new java.util.Stack<>();

	@Override
	public void enterDictorsetmaker(com.generator.generators.python.parser.Python3Parser.DictorsetmakerContext arg) {
		final Node node = model.newNode(Label.label("Dictorsetmaker"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDictorsetmaker.push(true);
	}

	public void exitDictorsetmaker(com.generator.generators.python.parser.Python3Parser.DictorsetmakerContext arg) {
		onExit();
		this.inDictorsetmaker.pop();
	}

	public boolean inDictorsetmaker() {
      return !inDictorsetmaker.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassdef = new java.util.Stack<>();

	@Override
	public void enterClassdef(com.generator.generators.python.parser.Python3Parser.ClassdefContext arg) {
		final Node node = model.newNode(Label.label("Classdef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassdef.push(true);
	}

	public void exitClassdef(com.generator.generators.python.parser.Python3Parser.ClassdefContext arg) {
		onExit();
		this.inClassdef.pop();
	}

	public boolean inClassdef() {
      return !inClassdef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArglist = new java.util.Stack<>();

	@Override
	public void enterArglist(com.generator.generators.python.parser.Python3Parser.ArglistContext arg) {
		final Node node = model.newNode(Label.label("Arglist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArglist.push(true);
	}

	public void exitArglist(com.generator.generators.python.parser.Python3Parser.ArglistContext arg) {
		onExit();
		this.inArglist.pop();
	}

	public boolean inArglist() {
      return !inArglist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComp_iter = new java.util.Stack<>();

	@Override
	public void enterComp_iter(com.generator.generators.python.parser.Python3Parser.Comp_iterContext arg) {
		final Node node = model.newNode(Label.label("Comp_iter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inComp_iter.push(true);
	}

	public void exitComp_iter(com.generator.generators.python.parser.Python3Parser.Comp_iterContext arg) {
		onExit();
		this.inComp_iter.pop();
	}

	public boolean inComp_iter() {
      return !inComp_iter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComp_for = new java.util.Stack<>();

	@Override
	public void enterComp_for(com.generator.generators.python.parser.Python3Parser.Comp_forContext arg) {
		final Node node = model.newNode(Label.label("Comp_for"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inComp_for.push(true);
	}

	public void exitComp_for(com.generator.generators.python.parser.Python3Parser.Comp_forContext arg) {
		onExit();
		this.inComp_for.pop();
	}

	public boolean inComp_for() {
      return !inComp_for.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComp_if = new java.util.Stack<>();

	@Override
	public void enterComp_if(com.generator.generators.python.parser.Python3Parser.Comp_ifContext arg) {
		final Node node = model.newNode(Label.label("Comp_if"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inComp_if.push(true);
	}

	public void exitComp_if(com.generator.generators.python.parser.Python3Parser.Comp_ifContext arg) {
		onExit();
		this.inComp_if.pop();
	}

	public boolean inComp_if() {
      return !inComp_if.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inYield_expr = new java.util.Stack<>();

	@Override
	public void enterYield_expr(com.generator.generators.python.parser.Python3Parser.Yield_exprContext arg) {
		final Node node = model.newNode(Label.label("Yield_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inYield_expr.push(true);
	}

	public void exitYield_expr(com.generator.generators.python.parser.Python3Parser.Yield_exprContext arg) {
		onExit();
		this.inYield_expr.pop();
	}

	public boolean inYield_expr() {
      return !inYield_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inYield_arg = new java.util.Stack<>();

	@Override
	public void enterYield_arg(com.generator.generators.python.parser.Python3Parser.Yield_argContext arg) {
		final Node node = model.newNode(Label.label("Yield_arg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inYield_arg.push(true);
	}

	public void exitYield_arg(com.generator.generators.python.parser.Python3Parser.Yield_argContext arg) {
		onExit();
		this.inYield_arg.pop();
	}

	public boolean inYield_arg() {
      return !inYield_arg.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStr = new java.util.Stack<>();

	@Override
	public void enterStr(com.generator.generators.python.parser.Python3Parser.StrContext arg) {
		final Node node = model.newNode(Label.label("Str"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStr.push(true);
	}

	public void exitStr(com.generator.generators.python.parser.Python3Parser.StrContext arg) {
		onExit();
		this.inStr.pop();
	}

	public boolean inStr() {
      return !inStr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInteger = new java.util.Stack<>();

	@Override
	public void enterInteger(com.generator.generators.python.parser.Python3Parser.IntegerContext arg) {
		final Node node = model.newNode(Label.label("Integer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInteger.push(true);
	}

	public void exitInteger(com.generator.generators.python.parser.Python3Parser.IntegerContext arg) {
		onExit();
		this.inInteger.pop();
	}

	public boolean inInteger() {
      return !inInteger.isEmpty(); 
   }

}