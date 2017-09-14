package com.generator.generators.go.parser;

public class GolangNodeListener extends GolangBaseListener {

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

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public GolangNodeListener() {
		this(false);
	}

	public GolangNodeListener(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
		delim.append("\t");
   }

   private void onExit() {
      if (nodeStack.size() > 1) {
			nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
		}
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	protected java.util.Stack<Boolean> inElement = new java.util.Stack<>();

	@Override
	public void enterElement(com.generator.generators.go.parser.GolangParser.ElementContext arg) {
		onEnter(new Node("Element", arg.getText(), arg.getStart().getText()));
		this.inElement.push(true);
	}

	public void exitElement(com.generator.generators.go.parser.GolangParser.ElementContext arg) {
		onExit();
		this.inElement.pop();
	}

	public boolean inElement() {
      return inElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.go.parser.GolangParser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.go.parser.GolangParser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.go.parser.GolangParser.ExpressionContext arg) {
		onEnter(new Node("Expression", arg.getText(), arg.getStart().getText()));
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.go.parser.GolangParser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.go.parser.GolangParser.StatementContext arg) {
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.go.parser.GolangParser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclaration = new java.util.Stack<>();

	@Override
	public void enterDeclaration(com.generator.generators.go.parser.GolangParser.DeclarationContext arg) {
		onEnter(new Node("Declaration", arg.getText(), arg.getStart().getText()));
		this.inDeclaration.push(true);
	}

	public void exitDeclaration(com.generator.generators.go.parser.GolangParser.DeclarationContext arg) {
		onExit();
		this.inDeclaration.pop();
	}

	public boolean inDeclaration() {
      return inDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.go.parser.GolangParser.LiteralContext arg) {
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.go.parser.GolangParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelector = new java.util.Stack<>();

	@Override
	public void enterSelector(com.generator.generators.go.parser.GolangParser.SelectorContext arg) {
		onEnter(new Node("Selector", arg.getText(), arg.getStart().getText()));
		this.inSelector.push(true);
	}

	public void exitSelector(com.generator.generators.go.parser.GolangParser.SelectorContext arg) {
		onExit();
		this.inSelector.pop();
	}

	public boolean inSelector() {
      return inSelector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunction = new java.util.Stack<>();

	@Override
	public void enterFunction(com.generator.generators.go.parser.GolangParser.FunctionContext arg) {
		onEnter(new Node("Function", arg.getText(), arg.getStart().getText()));
		this.inFunction.push(true);
	}

	public void exitFunction(com.generator.generators.go.parser.GolangParser.FunctionContext arg) {
		onExit();
		this.inFunction.pop();
	}

	public boolean inFunction() {
      return inFunction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatementList = new java.util.Stack<>();

	@Override
	public void enterStatementList(com.generator.generators.go.parser.GolangParser.StatementListContext arg) {
		onEnter(new Node("StatementList", arg.getText(), arg.getStart().getText()));
		this.inStatementList.push(true);
	}

	public void exitStatementList(com.generator.generators.go.parser.GolangParser.StatementListContext arg) {
		onExit();
		this.inStatementList.pop();
	}

	public boolean inStatementList() {
      return inStatementList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementList = new java.util.Stack<>();

	@Override
	public void enterElementList(com.generator.generators.go.parser.GolangParser.ElementListContext arg) {
		onEnter(new Node("ElementList", arg.getText(), arg.getStart().getText()));
		this.inElementList.push(true);
	}

	public void exitElementList(com.generator.generators.go.parser.GolangParser.ElementListContext arg) {
		onExit();
		this.inElementList.pop();
	}

	public boolean inElementList() {
      return inElementList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArguments = new java.util.Stack<>();

	@Override
	public void enterArguments(com.generator.generators.go.parser.GolangParser.ArgumentsContext arg) {
		onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText()));
		this.inArguments.push(true);
	}

	public void exitArguments(com.generator.generators.go.parser.GolangParser.ArgumentsContext arg) {
		onExit();
		this.inArguments.pop();
	}

	public boolean inArguments() {
      return inArguments.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEos = new java.util.Stack<>();

	@Override
	public void enterEos(com.generator.generators.go.parser.GolangParser.EosContext arg) {
		onEnter(new Node("Eos", arg.getText(), arg.getStart().getText()));
		this.inEos.push(true);
	}

	public void exitEos(com.generator.generators.go.parser.GolangParser.EosContext arg) {
		onExit();
		this.inEos.pop();
	}

	public boolean inEos() {
      return inEos.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSourceFile = new java.util.Stack<>();

	@Override
	public void enterSourceFile(com.generator.generators.go.parser.GolangParser.SourceFileContext arg) {
		onEnter(new Node("SourceFile", arg.getText(), arg.getStart().getText()));
		this.inSourceFile.push(true);
	}

	public void exitSourceFile(com.generator.generators.go.parser.GolangParser.SourceFileContext arg) {
		onExit();
		this.inSourceFile.pop();
	}

	public boolean inSourceFile() {
      return inSourceFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackageClause = new java.util.Stack<>();

	@Override
	public void enterPackageClause(com.generator.generators.go.parser.GolangParser.PackageClauseContext arg) {
		onEnter(new Node("PackageClause", arg.getText(), arg.getStart().getText()));
		this.inPackageClause.push(true);
	}

	public void exitPackageClause(com.generator.generators.go.parser.GolangParser.PackageClauseContext arg) {
		onExit();
		this.inPackageClause.pop();
	}

	public boolean inPackageClause() {
      return inPackageClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportDecl = new java.util.Stack<>();

	@Override
	public void enterImportDecl(com.generator.generators.go.parser.GolangParser.ImportDeclContext arg) {
		onEnter(new Node("ImportDecl", arg.getText(), arg.getStart().getText()));
		this.inImportDecl.push(true);
	}

	public void exitImportDecl(com.generator.generators.go.parser.GolangParser.ImportDeclContext arg) {
		onExit();
		this.inImportDecl.pop();
	}

	public boolean inImportDecl() {
      return inImportDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportSpec = new java.util.Stack<>();

	@Override
	public void enterImportSpec(com.generator.generators.go.parser.GolangParser.ImportSpecContext arg) {
		onEnter(new Node("ImportSpec", arg.getText(), arg.getStart().getText()));
		this.inImportSpec.push(true);
	}

	public void exitImportSpec(com.generator.generators.go.parser.GolangParser.ImportSpecContext arg) {
		onExit();
		this.inImportSpec.pop();
	}

	public boolean inImportSpec() {
      return inImportSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportPath = new java.util.Stack<>();

	@Override
	public void enterImportPath(com.generator.generators.go.parser.GolangParser.ImportPathContext arg) {
		onEnter(new Node("ImportPath", arg.getText(), arg.getStart().getText()));
		this.inImportPath.push(true);
	}

	public void exitImportPath(com.generator.generators.go.parser.GolangParser.ImportPathContext arg) {
		onExit();
		this.inImportPath.pop();
	}

	public boolean inImportPath() {
      return inImportPath.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTopLevelDecl = new java.util.Stack<>();

	@Override
	public void enterTopLevelDecl(com.generator.generators.go.parser.GolangParser.TopLevelDeclContext arg) {
		onEnter(new Node("TopLevelDecl", arg.getText(), arg.getStart().getText()));
		this.inTopLevelDecl.push(true);
	}

	public void exitTopLevelDecl(com.generator.generators.go.parser.GolangParser.TopLevelDeclContext arg) {
		onExit();
		this.inTopLevelDecl.pop();
	}

	public boolean inTopLevelDecl() {
      return inTopLevelDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstDecl = new java.util.Stack<>();

	@Override
	public void enterConstDecl(com.generator.generators.go.parser.GolangParser.ConstDeclContext arg) {
		onEnter(new Node("ConstDecl", arg.getText(), arg.getStart().getText()));
		this.inConstDecl.push(true);
	}

	public void exitConstDecl(com.generator.generators.go.parser.GolangParser.ConstDeclContext arg) {
		onExit();
		this.inConstDecl.pop();
	}

	public boolean inConstDecl() {
      return inConstDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstSpec = new java.util.Stack<>();

	@Override
	public void enterConstSpec(com.generator.generators.go.parser.GolangParser.ConstSpecContext arg) {
		onEnter(new Node("ConstSpec", arg.getText(), arg.getStart().getText()));
		this.inConstSpec.push(true);
	}

	public void exitConstSpec(com.generator.generators.go.parser.GolangParser.ConstSpecContext arg) {
		onExit();
		this.inConstSpec.pop();
	}

	public boolean inConstSpec() {
      return inConstSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdentifierList = new java.util.Stack<>();

	@Override
	public void enterIdentifierList(com.generator.generators.go.parser.GolangParser.IdentifierListContext arg) {
		onEnter(new Node("IdentifierList", arg.getText(), arg.getStart().getText()));
		this.inIdentifierList.push(true);
	}

	public void exitIdentifierList(com.generator.generators.go.parser.GolangParser.IdentifierListContext arg) {
		onExit();
		this.inIdentifierList.pop();
	}

	public boolean inIdentifierList() {
      return inIdentifierList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionList = new java.util.Stack<>();

	@Override
	public void enterExpressionList(com.generator.generators.go.parser.GolangParser.ExpressionListContext arg) {
		onEnter(new Node("ExpressionList", arg.getText(), arg.getStart().getText()));
		this.inExpressionList.push(true);
	}

	public void exitExpressionList(com.generator.generators.go.parser.GolangParser.ExpressionListContext arg) {
		onExit();
		this.inExpressionList.pop();
	}

	public boolean inExpressionList() {
      return inExpressionList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeDecl = new java.util.Stack<>();

	@Override
	public void enterTypeDecl(com.generator.generators.go.parser.GolangParser.TypeDeclContext arg) {
		onEnter(new Node("TypeDecl", arg.getText(), arg.getStart().getText()));
		this.inTypeDecl.push(true);
	}

	public void exitTypeDecl(com.generator.generators.go.parser.GolangParser.TypeDeclContext arg) {
		onExit();
		this.inTypeDecl.pop();
	}

	public boolean inTypeDecl() {
      return inTypeDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSpec = new java.util.Stack<>();

	@Override
	public void enterTypeSpec(com.generator.generators.go.parser.GolangParser.TypeSpecContext arg) {
		onEnter(new Node("TypeSpec", arg.getText(), arg.getStart().getText()));
		this.inTypeSpec.push(true);
	}

	public void exitTypeSpec(com.generator.generators.go.parser.GolangParser.TypeSpecContext arg) {
		onExit();
		this.inTypeSpec.pop();
	}

	public boolean inTypeSpec() {
      return inTypeSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionDecl = new java.util.Stack<>();

	@Override
	public void enterFunctionDecl(com.generator.generators.go.parser.GolangParser.FunctionDeclContext arg) {
		onEnter(new Node("FunctionDecl", arg.getText(), arg.getStart().getText()));
		this.inFunctionDecl.push(true);
	}

	public void exitFunctionDecl(com.generator.generators.go.parser.GolangParser.FunctionDeclContext arg) {
		onExit();
		this.inFunctionDecl.pop();
	}

	public boolean inFunctionDecl() {
      return inFunctionDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodDecl = new java.util.Stack<>();

	@Override
	public void enterMethodDecl(com.generator.generators.go.parser.GolangParser.MethodDeclContext arg) {
		onEnter(new Node("MethodDecl", arg.getText(), arg.getStart().getText()));
		this.inMethodDecl.push(true);
	}

	public void exitMethodDecl(com.generator.generators.go.parser.GolangParser.MethodDeclContext arg) {
		onExit();
		this.inMethodDecl.pop();
	}

	public boolean inMethodDecl() {
      return inMethodDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReceiver = new java.util.Stack<>();

	@Override
	public void enterReceiver(com.generator.generators.go.parser.GolangParser.ReceiverContext arg) {
		onEnter(new Node("Receiver", arg.getText(), arg.getStart().getText()));
		this.inReceiver.push(true);
	}

	public void exitReceiver(com.generator.generators.go.parser.GolangParser.ReceiverContext arg) {
		onExit();
		this.inReceiver.pop();
	}

	public boolean inReceiver() {
      return inReceiver.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarDecl = new java.util.Stack<>();

	@Override
	public void enterVarDecl(com.generator.generators.go.parser.GolangParser.VarDeclContext arg) {
		onEnter(new Node("VarDecl", arg.getText(), arg.getStart().getText()));
		this.inVarDecl.push(true);
	}

	public void exitVarDecl(com.generator.generators.go.parser.GolangParser.VarDeclContext arg) {
		onExit();
		this.inVarDecl.pop();
	}

	public boolean inVarDecl() {
      return inVarDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarSpec = new java.util.Stack<>();

	@Override
	public void enterVarSpec(com.generator.generators.go.parser.GolangParser.VarSpecContext arg) {
		onEnter(new Node("VarSpec", arg.getText(), arg.getStart().getText()));
		this.inVarSpec.push(true);
	}

	public void exitVarSpec(com.generator.generators.go.parser.GolangParser.VarSpecContext arg) {
		onExit();
		this.inVarSpec.pop();
	}

	public boolean inVarSpec() {
      return inVarSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleStmt = new java.util.Stack<>();

	@Override
	public void enterSimpleStmt(com.generator.generators.go.parser.GolangParser.SimpleStmtContext arg) {
		onEnter(new Node("SimpleStmt", arg.getText(), arg.getStart().getText()));
		this.inSimpleStmt.push(true);
	}

	public void exitSimpleStmt(com.generator.generators.go.parser.GolangParser.SimpleStmtContext arg) {
		onExit();
		this.inSimpleStmt.pop();
	}

	public boolean inSimpleStmt() {
      return inSimpleStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionStmt = new java.util.Stack<>();

	@Override
	public void enterExpressionStmt(com.generator.generators.go.parser.GolangParser.ExpressionStmtContext arg) {
		onEnter(new Node("ExpressionStmt", arg.getText(), arg.getStart().getText()));
		this.inExpressionStmt.push(true);
	}

	public void exitExpressionStmt(com.generator.generators.go.parser.GolangParser.ExpressionStmtContext arg) {
		onExit();
		this.inExpressionStmt.pop();
	}

	public boolean inExpressionStmt() {
      return inExpressionStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSendStmt = new java.util.Stack<>();

	@Override
	public void enterSendStmt(com.generator.generators.go.parser.GolangParser.SendStmtContext arg) {
		onEnter(new Node("SendStmt", arg.getText(), arg.getStart().getText()));
		this.inSendStmt.push(true);
	}

	public void exitSendStmt(com.generator.generators.go.parser.GolangParser.SendStmtContext arg) {
		onExit();
		this.inSendStmt.pop();
	}

	public boolean inSendStmt() {
      return inSendStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIncDecStmt = new java.util.Stack<>();

	@Override
	public void enterIncDecStmt(com.generator.generators.go.parser.GolangParser.IncDecStmtContext arg) {
		onEnter(new Node("IncDecStmt", arg.getText(), arg.getStart().getText()));
		this.inIncDecStmt.push(true);
	}

	public void exitIncDecStmt(com.generator.generators.go.parser.GolangParser.IncDecStmtContext arg) {
		onExit();
		this.inIncDecStmt.pop();
	}

	public boolean inIncDecStmt() {
      return inIncDecStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssignment = new java.util.Stack<>();

	@Override
	public void enterAssignment(com.generator.generators.go.parser.GolangParser.AssignmentContext arg) {
		onEnter(new Node("Assignment", arg.getText(), arg.getStart().getText()));
		this.inAssignment.push(true);
	}

	public void exitAssignment(com.generator.generators.go.parser.GolangParser.AssignmentContext arg) {
		onExit();
		this.inAssignment.pop();
	}

	public boolean inAssignment() {
      return inAssignment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssign_op = new java.util.Stack<>();

	@Override
	public void enterAssign_op(com.generator.generators.go.parser.GolangParser.Assign_opContext arg) {
		onEnter(new Node("Assign_op", arg.getText(), arg.getStart().getText()));
		this.inAssign_op.push(true);
	}

	public void exitAssign_op(com.generator.generators.go.parser.GolangParser.Assign_opContext arg) {
		onExit();
		this.inAssign_op.pop();
	}

	public boolean inAssign_op() {
      return inAssign_op.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShortVarDecl = new java.util.Stack<>();

	@Override
	public void enterShortVarDecl(com.generator.generators.go.parser.GolangParser.ShortVarDeclContext arg) {
		onEnter(new Node("ShortVarDecl", arg.getText(), arg.getStart().getText()));
		this.inShortVarDecl.push(true);
	}

	public void exitShortVarDecl(com.generator.generators.go.parser.GolangParser.ShortVarDeclContext arg) {
		onExit();
		this.inShortVarDecl.pop();
	}

	public boolean inShortVarDecl() {
      return inShortVarDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEmptyStmt = new java.util.Stack<>();

	@Override
	public void enterEmptyStmt(com.generator.generators.go.parser.GolangParser.EmptyStmtContext arg) {
		onEnter(new Node("EmptyStmt", arg.getText(), arg.getStart().getText()));
		this.inEmptyStmt.push(true);
	}

	public void exitEmptyStmt(com.generator.generators.go.parser.GolangParser.EmptyStmtContext arg) {
		onExit();
		this.inEmptyStmt.pop();
	}

	public boolean inEmptyStmt() {
      return inEmptyStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabeledStmt = new java.util.Stack<>();

	@Override
	public void enterLabeledStmt(com.generator.generators.go.parser.GolangParser.LabeledStmtContext arg) {
		onEnter(new Node("LabeledStmt", arg.getText(), arg.getStart().getText()));
		this.inLabeledStmt.push(true);
	}

	public void exitLabeledStmt(com.generator.generators.go.parser.GolangParser.LabeledStmtContext arg) {
		onExit();
		this.inLabeledStmt.pop();
	}

	public boolean inLabeledStmt() {
      return inLabeledStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturnStmt = new java.util.Stack<>();

	@Override
	public void enterReturnStmt(com.generator.generators.go.parser.GolangParser.ReturnStmtContext arg) {
		onEnter(new Node("ReturnStmt", arg.getText(), arg.getStart().getText()));
		this.inReturnStmt.push(true);
	}

	public void exitReturnStmt(com.generator.generators.go.parser.GolangParser.ReturnStmtContext arg) {
		onExit();
		this.inReturnStmt.pop();
	}

	public boolean inReturnStmt() {
      return inReturnStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBreakStmt = new java.util.Stack<>();

	@Override
	public void enterBreakStmt(com.generator.generators.go.parser.GolangParser.BreakStmtContext arg) {
		onEnter(new Node("BreakStmt", arg.getText(), arg.getStart().getText()));
		this.inBreakStmt.push(true);
	}

	public void exitBreakStmt(com.generator.generators.go.parser.GolangParser.BreakStmtContext arg) {
		onExit();
		this.inBreakStmt.pop();
	}

	public boolean inBreakStmt() {
      return inBreakStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inContinueStmt = new java.util.Stack<>();

	@Override
	public void enterContinueStmt(com.generator.generators.go.parser.GolangParser.ContinueStmtContext arg) {
		onEnter(new Node("ContinueStmt", arg.getText(), arg.getStart().getText()));
		this.inContinueStmt.push(true);
	}

	public void exitContinueStmt(com.generator.generators.go.parser.GolangParser.ContinueStmtContext arg) {
		onExit();
		this.inContinueStmt.pop();
	}

	public boolean inContinueStmt() {
      return inContinueStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGotoStmt = new java.util.Stack<>();

	@Override
	public void enterGotoStmt(com.generator.generators.go.parser.GolangParser.GotoStmtContext arg) {
		onEnter(new Node("GotoStmt", arg.getText(), arg.getStart().getText()));
		this.inGotoStmt.push(true);
	}

	public void exitGotoStmt(com.generator.generators.go.parser.GolangParser.GotoStmtContext arg) {
		onExit();
		this.inGotoStmt.pop();
	}

	public boolean inGotoStmt() {
      return inGotoStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFallthroughStmt = new java.util.Stack<>();

	@Override
	public void enterFallthroughStmt(com.generator.generators.go.parser.GolangParser.FallthroughStmtContext arg) {
		onEnter(new Node("FallthroughStmt", arg.getText(), arg.getStart().getText()));
		this.inFallthroughStmt.push(true);
	}

	public void exitFallthroughStmt(com.generator.generators.go.parser.GolangParser.FallthroughStmtContext arg) {
		onExit();
		this.inFallthroughStmt.pop();
	}

	public boolean inFallthroughStmt() {
      return inFallthroughStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeferStmt = new java.util.Stack<>();

	@Override
	public void enterDeferStmt(com.generator.generators.go.parser.GolangParser.DeferStmtContext arg) {
		onEnter(new Node("DeferStmt", arg.getText(), arg.getStart().getText()));
		this.inDeferStmt.push(true);
	}

	public void exitDeferStmt(com.generator.generators.go.parser.GolangParser.DeferStmtContext arg) {
		onExit();
		this.inDeferStmt.pop();
	}

	public boolean inDeferStmt() {
      return inDeferStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIfStmt = new java.util.Stack<>();

	@Override
	public void enterIfStmt(com.generator.generators.go.parser.GolangParser.IfStmtContext arg) {
		onEnter(new Node("IfStmt", arg.getText(), arg.getStart().getText()));
		this.inIfStmt.push(true);
	}

	public void exitIfStmt(com.generator.generators.go.parser.GolangParser.IfStmtContext arg) {
		onExit();
		this.inIfStmt.pop();
	}

	public boolean inIfStmt() {
      return inIfStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSwitchStmt = new java.util.Stack<>();

	@Override
	public void enterSwitchStmt(com.generator.generators.go.parser.GolangParser.SwitchStmtContext arg) {
		onEnter(new Node("SwitchStmt", arg.getText(), arg.getStart().getText()));
		this.inSwitchStmt.push(true);
	}

	public void exitSwitchStmt(com.generator.generators.go.parser.GolangParser.SwitchStmtContext arg) {
		onExit();
		this.inSwitchStmt.pop();
	}

	public boolean inSwitchStmt() {
      return inSwitchStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprSwitchStmt = new java.util.Stack<>();

	@Override
	public void enterExprSwitchStmt(com.generator.generators.go.parser.GolangParser.ExprSwitchStmtContext arg) {
		onEnter(new Node("ExprSwitchStmt", arg.getText(), arg.getStart().getText()));
		this.inExprSwitchStmt.push(true);
	}

	public void exitExprSwitchStmt(com.generator.generators.go.parser.GolangParser.ExprSwitchStmtContext arg) {
		onExit();
		this.inExprSwitchStmt.pop();
	}

	public boolean inExprSwitchStmt() {
      return inExprSwitchStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprCaseClause = new java.util.Stack<>();

	@Override
	public void enterExprCaseClause(com.generator.generators.go.parser.GolangParser.ExprCaseClauseContext arg) {
		onEnter(new Node("ExprCaseClause", arg.getText(), arg.getStart().getText()));
		this.inExprCaseClause.push(true);
	}

	public void exitExprCaseClause(com.generator.generators.go.parser.GolangParser.ExprCaseClauseContext arg) {
		onExit();
		this.inExprCaseClause.pop();
	}

	public boolean inExprCaseClause() {
      return inExprCaseClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprSwitchCase = new java.util.Stack<>();

	@Override
	public void enterExprSwitchCase(com.generator.generators.go.parser.GolangParser.ExprSwitchCaseContext arg) {
		onEnter(new Node("ExprSwitchCase", arg.getText(), arg.getStart().getText()));
		this.inExprSwitchCase.push(true);
	}

	public void exitExprSwitchCase(com.generator.generators.go.parser.GolangParser.ExprSwitchCaseContext arg) {
		onExit();
		this.inExprSwitchCase.pop();
	}

	public boolean inExprSwitchCase() {
      return inExprSwitchCase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSwitchStmt = new java.util.Stack<>();

	@Override
	public void enterTypeSwitchStmt(com.generator.generators.go.parser.GolangParser.TypeSwitchStmtContext arg) {
		onEnter(new Node("TypeSwitchStmt", arg.getText(), arg.getStart().getText()));
		this.inTypeSwitchStmt.push(true);
	}

	public void exitTypeSwitchStmt(com.generator.generators.go.parser.GolangParser.TypeSwitchStmtContext arg) {
		onExit();
		this.inTypeSwitchStmt.pop();
	}

	public boolean inTypeSwitchStmt() {
      return inTypeSwitchStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSwitchGuard = new java.util.Stack<>();

	@Override
	public void enterTypeSwitchGuard(com.generator.generators.go.parser.GolangParser.TypeSwitchGuardContext arg) {
		onEnter(new Node("TypeSwitchGuard", arg.getText(), arg.getStart().getText()));
		this.inTypeSwitchGuard.push(true);
	}

	public void exitTypeSwitchGuard(com.generator.generators.go.parser.GolangParser.TypeSwitchGuardContext arg) {
		onExit();
		this.inTypeSwitchGuard.pop();
	}

	public boolean inTypeSwitchGuard() {
      return inTypeSwitchGuard.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeCaseClause = new java.util.Stack<>();

	@Override
	public void enterTypeCaseClause(com.generator.generators.go.parser.GolangParser.TypeCaseClauseContext arg) {
		onEnter(new Node("TypeCaseClause", arg.getText(), arg.getStart().getText()));
		this.inTypeCaseClause.push(true);
	}

	public void exitTypeCaseClause(com.generator.generators.go.parser.GolangParser.TypeCaseClauseContext arg) {
		onExit();
		this.inTypeCaseClause.pop();
	}

	public boolean inTypeCaseClause() {
      return inTypeCaseClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSwitchCase = new java.util.Stack<>();

	@Override
	public void enterTypeSwitchCase(com.generator.generators.go.parser.GolangParser.TypeSwitchCaseContext arg) {
		onEnter(new Node("TypeSwitchCase", arg.getText(), arg.getStart().getText()));
		this.inTypeSwitchCase.push(true);
	}

	public void exitTypeSwitchCase(com.generator.generators.go.parser.GolangParser.TypeSwitchCaseContext arg) {
		onExit();
		this.inTypeSwitchCase.pop();
	}

	public boolean inTypeSwitchCase() {
      return inTypeSwitchCase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeList = new java.util.Stack<>();

	@Override
	public void enterTypeList(com.generator.generators.go.parser.GolangParser.TypeListContext arg) {
		onEnter(new Node("TypeList", arg.getText(), arg.getStart().getText()));
		this.inTypeList.push(true);
	}

	public void exitTypeList(com.generator.generators.go.parser.GolangParser.TypeListContext arg) {
		onExit();
		this.inTypeList.pop();
	}

	public boolean inTypeList() {
      return inTypeList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectStmt = new java.util.Stack<>();

	@Override
	public void enterSelectStmt(com.generator.generators.go.parser.GolangParser.SelectStmtContext arg) {
		onEnter(new Node("SelectStmt", arg.getText(), arg.getStart().getText()));
		this.inSelectStmt.push(true);
	}

	public void exitSelectStmt(com.generator.generators.go.parser.GolangParser.SelectStmtContext arg) {
		onExit();
		this.inSelectStmt.pop();
	}

	public boolean inSelectStmt() {
      return inSelectStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCommClause = new java.util.Stack<>();

	@Override
	public void enterCommClause(com.generator.generators.go.parser.GolangParser.CommClauseContext arg) {
		onEnter(new Node("CommClause", arg.getText(), arg.getStart().getText()));
		this.inCommClause.push(true);
	}

	public void exitCommClause(com.generator.generators.go.parser.GolangParser.CommClauseContext arg) {
		onExit();
		this.inCommClause.pop();
	}

	public boolean inCommClause() {
      return inCommClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCommCase = new java.util.Stack<>();

	@Override
	public void enterCommCase(com.generator.generators.go.parser.GolangParser.CommCaseContext arg) {
		onEnter(new Node("CommCase", arg.getText(), arg.getStart().getText()));
		this.inCommCase.push(true);
	}

	public void exitCommCase(com.generator.generators.go.parser.GolangParser.CommCaseContext arg) {
		onExit();
		this.inCommCase.pop();
	}

	public boolean inCommCase() {
      return inCommCase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRecvStmt = new java.util.Stack<>();

	@Override
	public void enterRecvStmt(com.generator.generators.go.parser.GolangParser.RecvStmtContext arg) {
		onEnter(new Node("RecvStmt", arg.getText(), arg.getStart().getText()));
		this.inRecvStmt.push(true);
	}

	public void exitRecvStmt(com.generator.generators.go.parser.GolangParser.RecvStmtContext arg) {
		onExit();
		this.inRecvStmt.pop();
	}

	public boolean inRecvStmt() {
      return inRecvStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForStmt = new java.util.Stack<>();

	@Override
	public void enterForStmt(com.generator.generators.go.parser.GolangParser.ForStmtContext arg) {
		onEnter(new Node("ForStmt", arg.getText(), arg.getStart().getText()));
		this.inForStmt.push(true);
	}

	public void exitForStmt(com.generator.generators.go.parser.GolangParser.ForStmtContext arg) {
		onExit();
		this.inForStmt.pop();
	}

	public boolean inForStmt() {
      return inForStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForClause = new java.util.Stack<>();

	@Override
	public void enterForClause(com.generator.generators.go.parser.GolangParser.ForClauseContext arg) {
		onEnter(new Node("ForClause", arg.getText(), arg.getStart().getText()));
		this.inForClause.push(true);
	}

	public void exitForClause(com.generator.generators.go.parser.GolangParser.ForClauseContext arg) {
		onExit();
		this.inForClause.pop();
	}

	public boolean inForClause() {
      return inForClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRangeClause = new java.util.Stack<>();

	@Override
	public void enterRangeClause(com.generator.generators.go.parser.GolangParser.RangeClauseContext arg) {
		onEnter(new Node("RangeClause", arg.getText(), arg.getStart().getText()));
		this.inRangeClause.push(true);
	}

	public void exitRangeClause(com.generator.generators.go.parser.GolangParser.RangeClauseContext arg) {
		onExit();
		this.inRangeClause.pop();
	}

	public boolean inRangeClause() {
      return inRangeClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGoStmt = new java.util.Stack<>();

	@Override
	public void enterGoStmt(com.generator.generators.go.parser.GolangParser.GoStmtContext arg) {
		onEnter(new Node("GoStmt", arg.getText(), arg.getStart().getText()));
		this.inGoStmt.push(true);
	}

	public void exitGoStmt(com.generator.generators.go.parser.GolangParser.GoStmtContext arg) {
		onExit();
		this.inGoStmt.pop();
	}

	public boolean inGoStmt() {
      return inGoStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inType = new java.util.Stack<>();

	@Override
	public void enterType(com.generator.generators.go.parser.GolangParser.TypeContext arg) {
		onEnter(new Node("Type", arg.getText(), arg.getStart().getText()));
		this.inType.push(true);
	}

	public void exitType(com.generator.generators.go.parser.GolangParser.TypeContext arg) {
		onExit();
		this.inType.pop();
	}

	public boolean inType() {
      return inType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeName = new java.util.Stack<>();

	@Override
	public void enterTypeName(com.generator.generators.go.parser.GolangParser.TypeNameContext arg) {
		onEnter(new Node("TypeName", arg.getText(), arg.getStart().getText()));
		this.inTypeName.push(true);
	}

	public void exitTypeName(com.generator.generators.go.parser.GolangParser.TypeNameContext arg) {
		onExit();
		this.inTypeName.pop();
	}

	public boolean inTypeName() {
      return inTypeName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeLit = new java.util.Stack<>();

	@Override
	public void enterTypeLit(com.generator.generators.go.parser.GolangParser.TypeLitContext arg) {
		onEnter(new Node("TypeLit", arg.getText(), arg.getStart().getText()));
		this.inTypeLit.push(true);
	}

	public void exitTypeLit(com.generator.generators.go.parser.GolangParser.TypeLitContext arg) {
		onExit();
		this.inTypeLit.pop();
	}

	public boolean inTypeLit() {
      return inTypeLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayType = new java.util.Stack<>();

	@Override
	public void enterArrayType(com.generator.generators.go.parser.GolangParser.ArrayTypeContext arg) {
		onEnter(new Node("ArrayType", arg.getText(), arg.getStart().getText()));
		this.inArrayType.push(true);
	}

	public void exitArrayType(com.generator.generators.go.parser.GolangParser.ArrayTypeContext arg) {
		onExit();
		this.inArrayType.pop();
	}

	public boolean inArrayType() {
      return inArrayType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayLength = new java.util.Stack<>();

	@Override
	public void enterArrayLength(com.generator.generators.go.parser.GolangParser.ArrayLengthContext arg) {
		onEnter(new Node("ArrayLength", arg.getText(), arg.getStart().getText()));
		this.inArrayLength.push(true);
	}

	public void exitArrayLength(com.generator.generators.go.parser.GolangParser.ArrayLengthContext arg) {
		onExit();
		this.inArrayLength.pop();
	}

	public boolean inArrayLength() {
      return inArrayLength.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementType = new java.util.Stack<>();

	@Override
	public void enterElementType(com.generator.generators.go.parser.GolangParser.ElementTypeContext arg) {
		onEnter(new Node("ElementType", arg.getText(), arg.getStart().getText()));
		this.inElementType.push(true);
	}

	public void exitElementType(com.generator.generators.go.parser.GolangParser.ElementTypeContext arg) {
		onExit();
		this.inElementType.pop();
	}

	public boolean inElementType() {
      return inElementType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPointerType = new java.util.Stack<>();

	@Override
	public void enterPointerType(com.generator.generators.go.parser.GolangParser.PointerTypeContext arg) {
		onEnter(new Node("PointerType", arg.getText(), arg.getStart().getText()));
		this.inPointerType.push(true);
	}

	public void exitPointerType(com.generator.generators.go.parser.GolangParser.PointerTypeContext arg) {
		onExit();
		this.inPointerType.pop();
	}

	public boolean inPointerType() {
      return inPointerType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceType = new java.util.Stack<>();

	@Override
	public void enterInterfaceType(com.generator.generators.go.parser.GolangParser.InterfaceTypeContext arg) {
		onEnter(new Node("InterfaceType", arg.getText(), arg.getStart().getText()));
		this.inInterfaceType.push(true);
	}

	public void exitInterfaceType(com.generator.generators.go.parser.GolangParser.InterfaceTypeContext arg) {
		onExit();
		this.inInterfaceType.pop();
	}

	public boolean inInterfaceType() {
      return inInterfaceType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSliceType = new java.util.Stack<>();

	@Override
	public void enterSliceType(com.generator.generators.go.parser.GolangParser.SliceTypeContext arg) {
		onEnter(new Node("SliceType", arg.getText(), arg.getStart().getText()));
		this.inSliceType.push(true);
	}

	public void exitSliceType(com.generator.generators.go.parser.GolangParser.SliceTypeContext arg) {
		onExit();
		this.inSliceType.pop();
	}

	public boolean inSliceType() {
      return inSliceType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMapType = new java.util.Stack<>();

	@Override
	public void enterMapType(com.generator.generators.go.parser.GolangParser.MapTypeContext arg) {
		onEnter(new Node("MapType", arg.getText(), arg.getStart().getText()));
		this.inMapType.push(true);
	}

	public void exitMapType(com.generator.generators.go.parser.GolangParser.MapTypeContext arg) {
		onExit();
		this.inMapType.pop();
	}

	public boolean inMapType() {
      return inMapType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChannelType = new java.util.Stack<>();

	@Override
	public void enterChannelType(com.generator.generators.go.parser.GolangParser.ChannelTypeContext arg) {
		onEnter(new Node("ChannelType", arg.getText(), arg.getStart().getText()));
		this.inChannelType.push(true);
	}

	public void exitChannelType(com.generator.generators.go.parser.GolangParser.ChannelTypeContext arg) {
		onExit();
		this.inChannelType.pop();
	}

	public boolean inChannelType() {
      return inChannelType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodSpec = new java.util.Stack<>();

	@Override
	public void enterMethodSpec(com.generator.generators.go.parser.GolangParser.MethodSpecContext arg) {
		onEnter(new Node("MethodSpec", arg.getText(), arg.getStart().getText()));
		this.inMethodSpec.push(true);
	}

	public void exitMethodSpec(com.generator.generators.go.parser.GolangParser.MethodSpecContext arg) {
		onExit();
		this.inMethodSpec.pop();
	}

	public boolean inMethodSpec() {
      return inMethodSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionType = new java.util.Stack<>();

	@Override
	public void enterFunctionType(com.generator.generators.go.parser.GolangParser.FunctionTypeContext arg) {
		onEnter(new Node("FunctionType", arg.getText(), arg.getStart().getText()));
		this.inFunctionType.push(true);
	}

	public void exitFunctionType(com.generator.generators.go.parser.GolangParser.FunctionTypeContext arg) {
		onExit();
		this.inFunctionType.pop();
	}

	public boolean inFunctionType() {
      return inFunctionType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSignature = new java.util.Stack<>();

	@Override
	public void enterSignature(com.generator.generators.go.parser.GolangParser.SignatureContext arg) {
		onEnter(new Node("Signature", arg.getText(), arg.getStart().getText()));
		this.inSignature.push(true);
	}

	public void exitSignature(com.generator.generators.go.parser.GolangParser.SignatureContext arg) {
		onExit();
		this.inSignature.pop();
	}

	public boolean inSignature() {
      return inSignature.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inResult = new java.util.Stack<>();

	@Override
	public void enterResult(com.generator.generators.go.parser.GolangParser.ResultContext arg) {
		onEnter(new Node("Result", arg.getText(), arg.getStart().getText()));
		this.inResult.push(true);
	}

	public void exitResult(com.generator.generators.go.parser.GolangParser.ResultContext arg) {
		onExit();
		this.inResult.pop();
	}

	public boolean inResult() {
      return inResult.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameters = new java.util.Stack<>();

	@Override
	public void enterParameters(com.generator.generators.go.parser.GolangParser.ParametersContext arg) {
		onEnter(new Node("Parameters", arg.getText(), arg.getStart().getText()));
		this.inParameters.push(true);
	}

	public void exitParameters(com.generator.generators.go.parser.GolangParser.ParametersContext arg) {
		onExit();
		this.inParameters.pop();
	}

	public boolean inParameters() {
      return inParameters.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameterList = new java.util.Stack<>();

	@Override
	public void enterParameterList(com.generator.generators.go.parser.GolangParser.ParameterListContext arg) {
		onEnter(new Node("ParameterList", arg.getText(), arg.getStart().getText()));
		this.inParameterList.push(true);
	}

	public void exitParameterList(com.generator.generators.go.parser.GolangParser.ParameterListContext arg) {
		onExit();
		this.inParameterList.pop();
	}

	public boolean inParameterList() {
      return inParameterList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameterDecl = new java.util.Stack<>();

	@Override
	public void enterParameterDecl(com.generator.generators.go.parser.GolangParser.ParameterDeclContext arg) {
		onEnter(new Node("ParameterDecl", arg.getText(), arg.getStart().getText()));
		this.inParameterDecl.push(true);
	}

	public void exitParameterDecl(com.generator.generators.go.parser.GolangParser.ParameterDeclContext arg) {
		onExit();
		this.inParameterDecl.pop();
	}

	public boolean inParameterDecl() {
      return inParameterDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperand = new java.util.Stack<>();

	@Override
	public void enterOperand(com.generator.generators.go.parser.GolangParser.OperandContext arg) {
		onEnter(new Node("Operand", arg.getText(), arg.getStart().getText()));
		this.inOperand.push(true);
	}

	public void exitOperand(com.generator.generators.go.parser.GolangParser.OperandContext arg) {
		onExit();
		this.inOperand.pop();
	}

	public boolean inOperand() {
      return inOperand.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBasicLit = new java.util.Stack<>();

	@Override
	public void enterBasicLit(com.generator.generators.go.parser.GolangParser.BasicLitContext arg) {
		onEnter(new Node("BasicLit", arg.getText(), arg.getStart().getText()));
		this.inBasicLit.push(true);
	}

	public void exitBasicLit(com.generator.generators.go.parser.GolangParser.BasicLitContext arg) {
		onExit();
		this.inBasicLit.pop();
	}

	public boolean inBasicLit() {
      return inBasicLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperandName = new java.util.Stack<>();

	@Override
	public void enterOperandName(com.generator.generators.go.parser.GolangParser.OperandNameContext arg) {
		onEnter(new Node("OperandName", arg.getText(), arg.getStart().getText()));
		this.inOperandName.push(true);
	}

	public void exitOperandName(com.generator.generators.go.parser.GolangParser.OperandNameContext arg) {
		onExit();
		this.inOperandName.pop();
	}

	public boolean inOperandName() {
      return inOperandName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedIdent = new java.util.Stack<>();

	@Override
	public void enterQualifiedIdent(com.generator.generators.go.parser.GolangParser.QualifiedIdentContext arg) {
		onEnter(new Node("QualifiedIdent", arg.getText(), arg.getStart().getText()));
		this.inQualifiedIdent.push(true);
	}

	public void exitQualifiedIdent(com.generator.generators.go.parser.GolangParser.QualifiedIdentContext arg) {
		onExit();
		this.inQualifiedIdent.pop();
	}

	public boolean inQualifiedIdent() {
      return inQualifiedIdent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompositeLit = new java.util.Stack<>();

	@Override
	public void enterCompositeLit(com.generator.generators.go.parser.GolangParser.CompositeLitContext arg) {
		onEnter(new Node("CompositeLit", arg.getText(), arg.getStart().getText()));
		this.inCompositeLit.push(true);
	}

	public void exitCompositeLit(com.generator.generators.go.parser.GolangParser.CompositeLitContext arg) {
		onExit();
		this.inCompositeLit.pop();
	}

	public boolean inCompositeLit() {
      return inCompositeLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteralType = new java.util.Stack<>();

	@Override
	public void enterLiteralType(com.generator.generators.go.parser.GolangParser.LiteralTypeContext arg) {
		onEnter(new Node("LiteralType", arg.getText(), arg.getStart().getText()));
		this.inLiteralType.push(true);
	}

	public void exitLiteralType(com.generator.generators.go.parser.GolangParser.LiteralTypeContext arg) {
		onExit();
		this.inLiteralType.pop();
	}

	public boolean inLiteralType() {
      return inLiteralType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteralValue = new java.util.Stack<>();

	@Override
	public void enterLiteralValue(com.generator.generators.go.parser.GolangParser.LiteralValueContext arg) {
		onEnter(new Node("LiteralValue", arg.getText(), arg.getStart().getText()));
		this.inLiteralValue.push(true);
	}

	public void exitLiteralValue(com.generator.generators.go.parser.GolangParser.LiteralValueContext arg) {
		onExit();
		this.inLiteralValue.pop();
	}

	public boolean inLiteralValue() {
      return inLiteralValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyedElement = new java.util.Stack<>();

	@Override
	public void enterKeyedElement(com.generator.generators.go.parser.GolangParser.KeyedElementContext arg) {
		onEnter(new Node("KeyedElement", arg.getText(), arg.getStart().getText()));
		this.inKeyedElement.push(true);
	}

	public void exitKeyedElement(com.generator.generators.go.parser.GolangParser.KeyedElementContext arg) {
		onExit();
		this.inKeyedElement.pop();
	}

	public boolean inKeyedElement() {
      return inKeyedElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKey = new java.util.Stack<>();

	@Override
	public void enterKey(com.generator.generators.go.parser.GolangParser.KeyContext arg) {
		onEnter(new Node("Key", arg.getText(), arg.getStart().getText()));
		this.inKey.push(true);
	}

	public void exitKey(com.generator.generators.go.parser.GolangParser.KeyContext arg) {
		onExit();
		this.inKey.pop();
	}

	public boolean inKey() {
      return inKey.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStructType = new java.util.Stack<>();

	@Override
	public void enterStructType(com.generator.generators.go.parser.GolangParser.StructTypeContext arg) {
		onEnter(new Node("StructType", arg.getText(), arg.getStart().getText()));
		this.inStructType.push(true);
	}

	public void exitStructType(com.generator.generators.go.parser.GolangParser.StructTypeContext arg) {
		onExit();
		this.inStructType.pop();
	}

	public boolean inStructType() {
      return inStructType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFieldDecl = new java.util.Stack<>();

	@Override
	public void enterFieldDecl(com.generator.generators.go.parser.GolangParser.FieldDeclContext arg) {
		onEnter(new Node("FieldDecl", arg.getText(), arg.getStart().getText()));
		this.inFieldDecl.push(true);
	}

	public void exitFieldDecl(com.generator.generators.go.parser.GolangParser.FieldDeclContext arg) {
		onExit();
		this.inFieldDecl.pop();
	}

	public boolean inFieldDecl() {
      return inFieldDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnonymousField = new java.util.Stack<>();

	@Override
	public void enterAnonymousField(com.generator.generators.go.parser.GolangParser.AnonymousFieldContext arg) {
		onEnter(new Node("AnonymousField", arg.getText(), arg.getStart().getText()));
		this.inAnonymousField.push(true);
	}

	public void exitAnonymousField(com.generator.generators.go.parser.GolangParser.AnonymousFieldContext arg) {
		onExit();
		this.inAnonymousField.pop();
	}

	public boolean inAnonymousField() {
      return inAnonymousField.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionLit = new java.util.Stack<>();

	@Override
	public void enterFunctionLit(com.generator.generators.go.parser.GolangParser.FunctionLitContext arg) {
		onEnter(new Node("FunctionLit", arg.getText(), arg.getStart().getText()));
		this.inFunctionLit.push(true);
	}

	public void exitFunctionLit(com.generator.generators.go.parser.GolangParser.FunctionLitContext arg) {
		onExit();
		this.inFunctionLit.pop();
	}

	public boolean inFunctionLit() {
      return inFunctionLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrimaryExpr = new java.util.Stack<>();

	@Override
	public void enterPrimaryExpr(com.generator.generators.go.parser.GolangParser.PrimaryExprContext arg) {
		onEnter(new Node("PrimaryExpr", arg.getText(), arg.getStart().getText()));
		this.inPrimaryExpr.push(true);
	}

	public void exitPrimaryExpr(com.generator.generators.go.parser.GolangParser.PrimaryExprContext arg) {
		onExit();
		this.inPrimaryExpr.pop();
	}

	public boolean inPrimaryExpr() {
      return inPrimaryExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndex = new java.util.Stack<>();

	@Override
	public void enterIndex(com.generator.generators.go.parser.GolangParser.IndexContext arg) {
		onEnter(new Node("Index", arg.getText(), arg.getStart().getText()));
		this.inIndex.push(true);
	}

	public void exitIndex(com.generator.generators.go.parser.GolangParser.IndexContext arg) {
		onExit();
		this.inIndex.pop();
	}

	public boolean inIndex() {
      return inIndex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSlice = new java.util.Stack<>();

	@Override
	public void enterSlice(com.generator.generators.go.parser.GolangParser.SliceContext arg) {
		onEnter(new Node("Slice", arg.getText(), arg.getStart().getText()));
		this.inSlice.push(true);
	}

	public void exitSlice(com.generator.generators.go.parser.GolangParser.SliceContext arg) {
		onExit();
		this.inSlice.pop();
	}

	public boolean inSlice() {
      return inSlice.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeAssertion = new java.util.Stack<>();

	@Override
	public void enterTypeAssertion(com.generator.generators.go.parser.GolangParser.TypeAssertionContext arg) {
		onEnter(new Node("TypeAssertion", arg.getText(), arg.getStart().getText()));
		this.inTypeAssertion.push(true);
	}

	public void exitTypeAssertion(com.generator.generators.go.parser.GolangParser.TypeAssertionContext arg) {
		onExit();
		this.inTypeAssertion.pop();
	}

	public boolean inTypeAssertion() {
      return inTypeAssertion.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodExpr = new java.util.Stack<>();

	@Override
	public void enterMethodExpr(com.generator.generators.go.parser.GolangParser.MethodExprContext arg) {
		onEnter(new Node("MethodExpr", arg.getText(), arg.getStart().getText()));
		this.inMethodExpr.push(true);
	}

	public void exitMethodExpr(com.generator.generators.go.parser.GolangParser.MethodExprContext arg) {
		onExit();
		this.inMethodExpr.pop();
	}

	public boolean inMethodExpr() {
      return inMethodExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReceiverType = new java.util.Stack<>();

	@Override
	public void enterReceiverType(com.generator.generators.go.parser.GolangParser.ReceiverTypeContext arg) {
		onEnter(new Node("ReceiverType", arg.getText(), arg.getStart().getText()));
		this.inReceiverType.push(true);
	}

	public void exitReceiverType(com.generator.generators.go.parser.GolangParser.ReceiverTypeContext arg) {
		onExit();
		this.inReceiverType.pop();
	}

	public boolean inReceiverType() {
      return inReceiverType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryExpr = new java.util.Stack<>();

	@Override
	public void enterUnaryExpr(com.generator.generators.go.parser.GolangParser.UnaryExprContext arg) {
		onEnter(new Node("UnaryExpr", arg.getText(), arg.getStart().getText()));
		this.inUnaryExpr.push(true);
	}

	public void exitUnaryExpr(com.generator.generators.go.parser.GolangParser.UnaryExprContext arg) {
		onExit();
		this.inUnaryExpr.pop();
	}

	public boolean inUnaryExpr() {
      return inUnaryExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConversion = new java.util.Stack<>();

	@Override
	public void enterConversion(com.generator.generators.go.parser.GolangParser.ConversionContext arg) {
		onEnter(new Node("Conversion", arg.getText(), arg.getStart().getText()));
		this.inConversion.push(true);
	}

	public void exitConversion(com.generator.generators.go.parser.GolangParser.ConversionContext arg) {
		onExit();
		this.inConversion.pop();
	}

	public boolean inConversion() {
      return inConversion.isEmpty(); 
   }

}