package com.generator.generators.go.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class GolangNeoListener extends GolangBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public GolangNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public GolangNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inElement = new java.util.Stack<>();

	@Override
	public void enterElement(com.generator.generators.go.parser.GolangParser.ElementContext arg) {
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inElement.push(true);
	}

	public void exitElement(com.generator.generators.go.parser.GolangParser.ElementContext arg) {
		onExit();
		this.inElement.pop();
	}

	public boolean inElement() {
      return !inElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.go.parser.GolangParser.BlockContext arg) {
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.go.parser.GolangParser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.go.parser.GolangParser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.go.parser.GolangParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.go.parser.GolangParser.ExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.go.parser.GolangParser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.go.parser.GolangParser.StatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.go.parser.GolangParser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return !inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclaration = new java.util.Stack<>();

	@Override
	public void enterDeclaration(com.generator.generators.go.parser.GolangParser.DeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Declaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclaration.push(true);
	}

	public void exitDeclaration(com.generator.generators.go.parser.GolangParser.DeclarationContext arg) {
		onExit();
		this.inDeclaration.pop();
	}

	public boolean inDeclaration() {
      return !inDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelector = new java.util.Stack<>();

	@Override
	public void enterSelector(com.generator.generators.go.parser.GolangParser.SelectorContext arg) {
		final Node node = model.findOrCreate(Label.label("Selector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSelector.push(true);
	}

	public void exitSelector(com.generator.generators.go.parser.GolangParser.SelectorContext arg) {
		onExit();
		this.inSelector.pop();
	}

	public boolean inSelector() {
      return !inSelector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunction = new java.util.Stack<>();

	@Override
	public void enterFunction(com.generator.generators.go.parser.GolangParser.FunctionContext arg) {
		final Node node = model.findOrCreate(Label.label("Function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunction.push(true);
	}

	public void exitFunction(com.generator.generators.go.parser.GolangParser.FunctionContext arg) {
		onExit();
		this.inFunction.pop();
	}

	public boolean inFunction() {
      return !inFunction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatementList = new java.util.Stack<>();

	@Override
	public void enterStatementList(com.generator.generators.go.parser.GolangParser.StatementListContext arg) {
		final Node node = model.findOrCreate(Label.label("StatementList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inStatementList.push(true);
	}

	public void exitStatementList(com.generator.generators.go.parser.GolangParser.StatementListContext arg) {
		onExit();
		this.inStatementList.pop();
	}

	public boolean inStatementList() {
      return !inStatementList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementList = new java.util.Stack<>();

	@Override
	public void enterElementList(com.generator.generators.go.parser.GolangParser.ElementListContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inElementList.push(true);
	}

	public void exitElementList(com.generator.generators.go.parser.GolangParser.ElementListContext arg) {
		onExit();
		this.inElementList.pop();
	}

	public boolean inElementList() {
      return !inElementList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArguments = new java.util.Stack<>();

	@Override
	public void enterArguments(com.generator.generators.go.parser.GolangParser.ArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("Arguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inArguments.push(true);
	}

	public void exitArguments(com.generator.generators.go.parser.GolangParser.ArgumentsContext arg) {
		onExit();
		this.inArguments.pop();
	}

	public boolean inArguments() {
      return !inArguments.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEos = new java.util.Stack<>();

	@Override
	public void enterEos(com.generator.generators.go.parser.GolangParser.EosContext arg) {
		final Node node = model.findOrCreate(Label.label("Eos"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEos.push(true);
	}

	public void exitEos(com.generator.generators.go.parser.GolangParser.EosContext arg) {
		onExit();
		this.inEos.pop();
	}

	public boolean inEos() {
      return !inEos.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSourceFile = new java.util.Stack<>();

	@Override
	public void enterSourceFile(com.generator.generators.go.parser.GolangParser.SourceFileContext arg) {
		final Node node = model.findOrCreate(Label.label("SourceFile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSourceFile.push(true);
	}

	public void exitSourceFile(com.generator.generators.go.parser.GolangParser.SourceFileContext arg) {
		onExit();
		this.inSourceFile.pop();
	}

	public boolean inSourceFile() {
      return !inSourceFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportDecl = new java.util.Stack<>();

	@Override
	public void enterImportDecl(com.generator.generators.go.parser.GolangParser.ImportDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inImportDecl.push(true);
	}

	public void exitImportDecl(com.generator.generators.go.parser.GolangParser.ImportDeclContext arg) {
		onExit();
		this.inImportDecl.pop();
	}

	public boolean inImportDecl() {
      return !inImportDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportSpec = new java.util.Stack<>();

	@Override
	public void enterImportSpec(com.generator.generators.go.parser.GolangParser.ImportSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inImportSpec.push(true);
	}

	public void exitImportSpec(com.generator.generators.go.parser.GolangParser.ImportSpecContext arg) {
		onExit();
		this.inImportSpec.pop();
	}

	public boolean inImportSpec() {
      return !inImportSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportPath = new java.util.Stack<>();

	@Override
	public void enterImportPath(com.generator.generators.go.parser.GolangParser.ImportPathContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportPath"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inImportPath.push(true);
	}

	public void exitImportPath(com.generator.generators.go.parser.GolangParser.ImportPathContext arg) {
		onExit();
		this.inImportPath.pop();
	}

	public boolean inImportPath() {
      return !inImportPath.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTopLevelDecl = new java.util.Stack<>();

	@Override
	public void enterTopLevelDecl(com.generator.generators.go.parser.GolangParser.TopLevelDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("TopLevelDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTopLevelDecl.push(true);
	}

	public void exitTopLevelDecl(com.generator.generators.go.parser.GolangParser.TopLevelDeclContext arg) {
		onExit();
		this.inTopLevelDecl.pop();
	}

	public boolean inTopLevelDecl() {
      return !inTopLevelDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstDecl = new java.util.Stack<>();

	@Override
	public void enterConstDecl(com.generator.generators.go.parser.GolangParser.ConstDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConstDecl.push(true);
	}

	public void exitConstDecl(com.generator.generators.go.parser.GolangParser.ConstDeclContext arg) {
		onExit();
		this.inConstDecl.pop();
	}

	public boolean inConstDecl() {
      return !inConstDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstSpec = new java.util.Stack<>();

	@Override
	public void enterConstSpec(com.generator.generators.go.parser.GolangParser.ConstSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConstSpec.push(true);
	}

	public void exitConstSpec(com.generator.generators.go.parser.GolangParser.ConstSpecContext arg) {
		onExit();
		this.inConstSpec.pop();
	}

	public boolean inConstSpec() {
      return !inConstSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdentifierList = new java.util.Stack<>();

	@Override
	public void enterIdentifierList(com.generator.generators.go.parser.GolangParser.IdentifierListContext arg) {
		final Node node = model.findOrCreate(Label.label("IdentifierList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inIdentifierList.push(true);
	}

	public void exitIdentifierList(com.generator.generators.go.parser.GolangParser.IdentifierListContext arg) {
		onExit();
		this.inIdentifierList.pop();
	}

	public boolean inIdentifierList() {
      return !inIdentifierList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionList = new java.util.Stack<>();

	@Override
	public void enterExpressionList(com.generator.generators.go.parser.GolangParser.ExpressionListContext arg) {
		final Node node = model.findOrCreate(Label.label("ExpressionList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExpressionList.push(true);
	}

	public void exitExpressionList(com.generator.generators.go.parser.GolangParser.ExpressionListContext arg) {
		onExit();
		this.inExpressionList.pop();
	}

	public boolean inExpressionList() {
      return !inExpressionList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeDecl = new java.util.Stack<>();

	@Override
	public void enterTypeDecl(com.generator.generators.go.parser.GolangParser.TypeDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeDecl.push(true);
	}

	public void exitTypeDecl(com.generator.generators.go.parser.GolangParser.TypeDeclContext arg) {
		onExit();
		this.inTypeDecl.pop();
	}

	public boolean inTypeDecl() {
      return !inTypeDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSpec = new java.util.Stack<>();

	@Override
	public void enterTypeSpec(com.generator.generators.go.parser.GolangParser.TypeSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeSpec.push(true);
	}

	public void exitTypeSpec(com.generator.generators.go.parser.GolangParser.TypeSpecContext arg) {
		onExit();
		this.inTypeSpec.pop();
	}

	public boolean inTypeSpec() {
      return !inTypeSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionDecl = new java.util.Stack<>();

	@Override
	public void enterFunctionDecl(com.generator.generators.go.parser.GolangParser.FunctionDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctionDecl.push(true);
	}

	public void exitFunctionDecl(com.generator.generators.go.parser.GolangParser.FunctionDeclContext arg) {
		onExit();
		this.inFunctionDecl.pop();
	}

	public boolean inFunctionDecl() {
      return !inFunctionDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodDecl = new java.util.Stack<>();

	@Override
	public void enterMethodDecl(com.generator.generators.go.parser.GolangParser.MethodDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMethodDecl.push(true);
	}

	public void exitMethodDecl(com.generator.generators.go.parser.GolangParser.MethodDeclContext arg) {
		onExit();
		this.inMethodDecl.pop();
	}

	public boolean inMethodDecl() {
      return !inMethodDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReceiver = new java.util.Stack<>();

	@Override
	public void enterReceiver(com.generator.generators.go.parser.GolangParser.ReceiverContext arg) {
		final Node node = model.findOrCreate(Label.label("Receiver"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inReceiver.push(true);
	}

	public void exitReceiver(com.generator.generators.go.parser.GolangParser.ReceiverContext arg) {
		onExit();
		this.inReceiver.pop();
	}

	public boolean inReceiver() {
      return !inReceiver.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarDecl = new java.util.Stack<>();

	@Override
	public void enterVarDecl(com.generator.generators.go.parser.GolangParser.VarDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("VarDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inVarDecl.push(true);
	}

	public void exitVarDecl(com.generator.generators.go.parser.GolangParser.VarDeclContext arg) {
		onExit();
		this.inVarDecl.pop();
	}

	public boolean inVarDecl() {
      return !inVarDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarSpec = new java.util.Stack<>();

	@Override
	public void enterVarSpec(com.generator.generators.go.parser.GolangParser.VarSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("VarSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inVarSpec.push(true);
	}

	public void exitVarSpec(com.generator.generators.go.parser.GolangParser.VarSpecContext arg) {
		onExit();
		this.inVarSpec.pop();
	}

	public boolean inVarSpec() {
      return !inVarSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleStmt = new java.util.Stack<>();

	@Override
	public void enterSimpleStmt(com.generator.generators.go.parser.GolangParser.SimpleStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("SimpleStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSimpleStmt.push(true);
	}

	public void exitSimpleStmt(com.generator.generators.go.parser.GolangParser.SimpleStmtContext arg) {
		onExit();
		this.inSimpleStmt.pop();
	}

	public boolean inSimpleStmt() {
      return !inSimpleStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionStmt = new java.util.Stack<>();

	@Override
	public void enterExpressionStmt(com.generator.generators.go.parser.GolangParser.ExpressionStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("ExpressionStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExpressionStmt.push(true);
	}

	public void exitExpressionStmt(com.generator.generators.go.parser.GolangParser.ExpressionStmtContext arg) {
		onExit();
		this.inExpressionStmt.pop();
	}

	public boolean inExpressionStmt() {
      return !inExpressionStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSendStmt = new java.util.Stack<>();

	@Override
	public void enterSendStmt(com.generator.generators.go.parser.GolangParser.SendStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("SendStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSendStmt.push(true);
	}

	public void exitSendStmt(com.generator.generators.go.parser.GolangParser.SendStmtContext arg) {
		onExit();
		this.inSendStmt.pop();
	}

	public boolean inSendStmt() {
      return !inSendStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIncDecStmt = new java.util.Stack<>();

	@Override
	public void enterIncDecStmt(com.generator.generators.go.parser.GolangParser.IncDecStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("IncDecStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inIncDecStmt.push(true);
	}

	public void exitIncDecStmt(com.generator.generators.go.parser.GolangParser.IncDecStmtContext arg) {
		onExit();
		this.inIncDecStmt.pop();
	}

	public boolean inIncDecStmt() {
      return !inIncDecStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssignment = new java.util.Stack<>();

	@Override
	public void enterAssignment(com.generator.generators.go.parser.GolangParser.AssignmentContext arg) {
		final Node node = model.findOrCreate(Label.label("Assignment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAssignment.push(true);
	}

	public void exitAssignment(com.generator.generators.go.parser.GolangParser.AssignmentContext arg) {
		onExit();
		this.inAssignment.pop();
	}

	public boolean inAssignment() {
      return !inAssignment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssign_op = new java.util.Stack<>();

	@Override
	public void enterAssign_op(com.generator.generators.go.parser.GolangParser.Assign_opContext arg) {
		final Node node = model.findOrCreate(Label.label("Assign_op"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAssign_op.push(true);
	}

	public void exitAssign_op(com.generator.generators.go.parser.GolangParser.Assign_opContext arg) {
		onExit();
		this.inAssign_op.pop();
	}

	public boolean inAssign_op() {
      return !inAssign_op.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShortVarDecl = new java.util.Stack<>();

	@Override
	public void enterShortVarDecl(com.generator.generators.go.parser.GolangParser.ShortVarDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("ShortVarDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inShortVarDecl.push(true);
	}

	public void exitShortVarDecl(com.generator.generators.go.parser.GolangParser.ShortVarDeclContext arg) {
		onExit();
		this.inShortVarDecl.pop();
	}

	public boolean inShortVarDecl() {
      return !inShortVarDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEmptyStmt = new java.util.Stack<>();

	@Override
	public void enterEmptyStmt(com.generator.generators.go.parser.GolangParser.EmptyStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("EmptyStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEmptyStmt.push(true);
	}

	public void exitEmptyStmt(com.generator.generators.go.parser.GolangParser.EmptyStmtContext arg) {
		onExit();
		this.inEmptyStmt.pop();
	}

	public boolean inEmptyStmt() {
      return !inEmptyStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabeledStmt = new java.util.Stack<>();

	@Override
	public void enterLabeledStmt(com.generator.generators.go.parser.GolangParser.LabeledStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("LabeledStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLabeledStmt.push(true);
	}

	public void exitLabeledStmt(com.generator.generators.go.parser.GolangParser.LabeledStmtContext arg) {
		onExit();
		this.inLabeledStmt.pop();
	}

	public boolean inLabeledStmt() {
      return !inLabeledStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturnStmt = new java.util.Stack<>();

	@Override
	public void enterReturnStmt(com.generator.generators.go.parser.GolangParser.ReturnStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("ReturnStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inReturnStmt.push(true);
	}

	public void exitReturnStmt(com.generator.generators.go.parser.GolangParser.ReturnStmtContext arg) {
		onExit();
		this.inReturnStmt.pop();
	}

	public boolean inReturnStmt() {
      return !inReturnStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBreakStmt = new java.util.Stack<>();

	@Override
	public void enterBreakStmt(com.generator.generators.go.parser.GolangParser.BreakStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("BreakStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBreakStmt.push(true);
	}

	public void exitBreakStmt(com.generator.generators.go.parser.GolangParser.BreakStmtContext arg) {
		onExit();
		this.inBreakStmt.pop();
	}

	public boolean inBreakStmt() {
      return !inBreakStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inContinueStmt = new java.util.Stack<>();

	@Override
	public void enterContinueStmt(com.generator.generators.go.parser.GolangParser.ContinueStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("ContinueStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inContinueStmt.push(true);
	}

	public void exitContinueStmt(com.generator.generators.go.parser.GolangParser.ContinueStmtContext arg) {
		onExit();
		this.inContinueStmt.pop();
	}

	public boolean inContinueStmt() {
      return !inContinueStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGotoStmt = new java.util.Stack<>();

	@Override
	public void enterGotoStmt(com.generator.generators.go.parser.GolangParser.GotoStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("GotoStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inGotoStmt.push(true);
	}

	public void exitGotoStmt(com.generator.generators.go.parser.GolangParser.GotoStmtContext arg) {
		onExit();
		this.inGotoStmt.pop();
	}

	public boolean inGotoStmt() {
      return !inGotoStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFallthroughStmt = new java.util.Stack<>();

	@Override
	public void enterFallthroughStmt(com.generator.generators.go.parser.GolangParser.FallthroughStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("FallthroughStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFallthroughStmt.push(true);
	}

	public void exitFallthroughStmt(com.generator.generators.go.parser.GolangParser.FallthroughStmtContext arg) {
		onExit();
		this.inFallthroughStmt.pop();
	}

	public boolean inFallthroughStmt() {
      return !inFallthroughStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeferStmt = new java.util.Stack<>();

	@Override
	public void enterDeferStmt(com.generator.generators.go.parser.GolangParser.DeferStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("DeferStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeferStmt.push(true);
	}

	public void exitDeferStmt(com.generator.generators.go.parser.GolangParser.DeferStmtContext arg) {
		onExit();
		this.inDeferStmt.pop();
	}

	public boolean inDeferStmt() {
      return !inDeferStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIfStmt = new java.util.Stack<>();

	@Override
	public void enterIfStmt(com.generator.generators.go.parser.GolangParser.IfStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("IfStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inIfStmt.push(true);
	}

	public void exitIfStmt(com.generator.generators.go.parser.GolangParser.IfStmtContext arg) {
		onExit();
		this.inIfStmt.pop();
	}

	public boolean inIfStmt() {
      return !inIfStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSwitchStmt = new java.util.Stack<>();

	@Override
	public void enterSwitchStmt(com.generator.generators.go.parser.GolangParser.SwitchStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("SwitchStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSwitchStmt.push(true);
	}

	public void exitSwitchStmt(com.generator.generators.go.parser.GolangParser.SwitchStmtContext arg) {
		onExit();
		this.inSwitchStmt.pop();
	}

	public boolean inSwitchStmt() {
      return !inSwitchStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprSwitchStmt = new java.util.Stack<>();

	@Override
	public void enterExprSwitchStmt(com.generator.generators.go.parser.GolangParser.ExprSwitchStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("ExprSwitchStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExprSwitchStmt.push(true);
	}

	public void exitExprSwitchStmt(com.generator.generators.go.parser.GolangParser.ExprSwitchStmtContext arg) {
		onExit();
		this.inExprSwitchStmt.pop();
	}

	public boolean inExprSwitchStmt() {
      return !inExprSwitchStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprCaseClause = new java.util.Stack<>();

	@Override
	public void enterExprCaseClause(com.generator.generators.go.parser.GolangParser.ExprCaseClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("ExprCaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExprCaseClause.push(true);
	}

	public void exitExprCaseClause(com.generator.generators.go.parser.GolangParser.ExprCaseClauseContext arg) {
		onExit();
		this.inExprCaseClause.pop();
	}

	public boolean inExprCaseClause() {
      return !inExprCaseClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprSwitchCase = new java.util.Stack<>();

	@Override
	public void enterExprSwitchCase(com.generator.generators.go.parser.GolangParser.ExprSwitchCaseContext arg) {
		final Node node = model.findOrCreate(Label.label("ExprSwitchCase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExprSwitchCase.push(true);
	}

	public void exitExprSwitchCase(com.generator.generators.go.parser.GolangParser.ExprSwitchCaseContext arg) {
		onExit();
		this.inExprSwitchCase.pop();
	}

	public boolean inExprSwitchCase() {
      return !inExprSwitchCase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSwitchStmt = new java.util.Stack<>();

	@Override
	public void enterTypeSwitchStmt(com.generator.generators.go.parser.GolangParser.TypeSwitchStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeSwitchStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeSwitchStmt.push(true);
	}

	public void exitTypeSwitchStmt(com.generator.generators.go.parser.GolangParser.TypeSwitchStmtContext arg) {
		onExit();
		this.inTypeSwitchStmt.pop();
	}

	public boolean inTypeSwitchStmt() {
      return !inTypeSwitchStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSwitchGuard = new java.util.Stack<>();

	@Override
	public void enterTypeSwitchGuard(com.generator.generators.go.parser.GolangParser.TypeSwitchGuardContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeSwitchGuard"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeSwitchGuard.push(true);
	}

	public void exitTypeSwitchGuard(com.generator.generators.go.parser.GolangParser.TypeSwitchGuardContext arg) {
		onExit();
		this.inTypeSwitchGuard.pop();
	}

	public boolean inTypeSwitchGuard() {
      return !inTypeSwitchGuard.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeCaseClause = new java.util.Stack<>();

	@Override
	public void enterTypeCaseClause(com.generator.generators.go.parser.GolangParser.TypeCaseClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeCaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeCaseClause.push(true);
	}

	public void exitTypeCaseClause(com.generator.generators.go.parser.GolangParser.TypeCaseClauseContext arg) {
		onExit();
		this.inTypeCaseClause.pop();
	}

	public boolean inTypeCaseClause() {
      return !inTypeCaseClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSwitchCase = new java.util.Stack<>();

	@Override
	public void enterTypeSwitchCase(com.generator.generators.go.parser.GolangParser.TypeSwitchCaseContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeSwitchCase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeSwitchCase.push(true);
	}

	public void exitTypeSwitchCase(com.generator.generators.go.parser.GolangParser.TypeSwitchCaseContext arg) {
		onExit();
		this.inTypeSwitchCase.pop();
	}

	public boolean inTypeSwitchCase() {
      return !inTypeSwitchCase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeList = new java.util.Stack<>();

	@Override
	public void enterTypeList(com.generator.generators.go.parser.GolangParser.TypeListContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeList.push(true);
	}

	public void exitTypeList(com.generator.generators.go.parser.GolangParser.TypeListContext arg) {
		onExit();
		this.inTypeList.pop();
	}

	public boolean inTypeList() {
      return !inTypeList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectStmt = new java.util.Stack<>();

	@Override
	public void enterSelectStmt(com.generator.generators.go.parser.GolangParser.SelectStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("SelectStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSelectStmt.push(true);
	}

	public void exitSelectStmt(com.generator.generators.go.parser.GolangParser.SelectStmtContext arg) {
		onExit();
		this.inSelectStmt.pop();
	}

	public boolean inSelectStmt() {
      return !inSelectStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackageClause = new java.util.Stack<>();

	@Override
	public void enterPackageClause(com.generator.generators.go.parser.GolangParser.PackageClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPackageClause.push(true);
	}

	public void exitPackageClause(com.generator.generators.go.parser.GolangParser.PackageClauseContext arg) {
		onExit();
		this.inPackageClause.pop();
	}

	public boolean inPackageClause() {
      return !inPackageClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCommClause = new java.util.Stack<>();

	@Override
	public void enterCommClause(com.generator.generators.go.parser.GolangParser.CommClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("CommClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCommClause.push(true);
	}

	public void exitCommClause(com.generator.generators.go.parser.GolangParser.CommClauseContext arg) {
		onExit();
		this.inCommClause.pop();
	}

	public boolean inCommClause() {
      return !inCommClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCommCase = new java.util.Stack<>();

	@Override
	public void enterCommCase(com.generator.generators.go.parser.GolangParser.CommCaseContext arg) {
		final Node node = model.findOrCreate(Label.label("CommCase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCommCase.push(true);
	}

	public void exitCommCase(com.generator.generators.go.parser.GolangParser.CommCaseContext arg) {
		onExit();
		this.inCommCase.pop();
	}

	public boolean inCommCase() {
      return !inCommCase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRecvStmt = new java.util.Stack<>();

	@Override
	public void enterRecvStmt(com.generator.generators.go.parser.GolangParser.RecvStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("RecvStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRecvStmt.push(true);
	}

	public void exitRecvStmt(com.generator.generators.go.parser.GolangParser.RecvStmtContext arg) {
		onExit();
		this.inRecvStmt.pop();
	}

	public boolean inRecvStmt() {
      return !inRecvStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForStmt = new java.util.Stack<>();

	@Override
	public void enterForStmt(com.generator.generators.go.parser.GolangParser.ForStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("ForStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inForStmt.push(true);
	}

	public void exitForStmt(com.generator.generators.go.parser.GolangParser.ForStmtContext arg) {
		onExit();
		this.inForStmt.pop();
	}

	public boolean inForStmt() {
      return !inForStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForClause = new java.util.Stack<>();

	@Override
	public void enterForClause(com.generator.generators.go.parser.GolangParser.ForClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("ForClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inForClause.push(true);
	}

	public void exitForClause(com.generator.generators.go.parser.GolangParser.ForClauseContext arg) {
		onExit();
		this.inForClause.pop();
	}

	public boolean inForClause() {
      return !inForClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRangeClause = new java.util.Stack<>();

	@Override
	public void enterRangeClause(com.generator.generators.go.parser.GolangParser.RangeClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("RangeClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRangeClause.push(true);
	}

	public void exitRangeClause(com.generator.generators.go.parser.GolangParser.RangeClauseContext arg) {
		onExit();
		this.inRangeClause.pop();
	}

	public boolean inRangeClause() {
      return !inRangeClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGoStmt = new java.util.Stack<>();

	@Override
	public void enterGoStmt(com.generator.generators.go.parser.GolangParser.GoStmtContext arg) {
		final Node node = model.findOrCreate(Label.label("GoStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inGoStmt.push(true);
	}

	public void exitGoStmt(com.generator.generators.go.parser.GolangParser.GoStmtContext arg) {
		onExit();
		this.inGoStmt.pop();
	}

	public boolean inGoStmt() {
      return !inGoStmt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inType = new java.util.Stack<>();

	@Override
	public void enterType(com.generator.generators.go.parser.GolangParser.TypeContext arg) {
		final Node node = model.findOrCreate(Label.label("Type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inType.push(true);
	}

	public void exitType(com.generator.generators.go.parser.GolangParser.TypeContext arg) {
		onExit();
		this.inType.pop();
	}

	public boolean inType() {
      return !inType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeName = new java.util.Stack<>();

	@Override
	public void enterTypeName(com.generator.generators.go.parser.GolangParser.TypeNameContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeName.push(true);
	}

	public void exitTypeName(com.generator.generators.go.parser.GolangParser.TypeNameContext arg) {
		onExit();
		this.inTypeName.pop();
	}

	public boolean inTypeName() {
      return !inTypeName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeLit = new java.util.Stack<>();

	@Override
	public void enterTypeLit(com.generator.generators.go.parser.GolangParser.TypeLitContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeLit.push(true);
	}

	public void exitTypeLit(com.generator.generators.go.parser.GolangParser.TypeLitContext arg) {
		onExit();
		this.inTypeLit.pop();
	}

	public boolean inTypeLit() {
      return !inTypeLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayType = new java.util.Stack<>();

	@Override
	public void enterArrayType(com.generator.generators.go.parser.GolangParser.ArrayTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inArrayType.push(true);
	}

	public void exitArrayType(com.generator.generators.go.parser.GolangParser.ArrayTypeContext arg) {
		onExit();
		this.inArrayType.pop();
	}

	public boolean inArrayType() {
      return !inArrayType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayLength = new java.util.Stack<>();

	@Override
	public void enterArrayLength(com.generator.generators.go.parser.GolangParser.ArrayLengthContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayLength"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inArrayLength.push(true);
	}

	public void exitArrayLength(com.generator.generators.go.parser.GolangParser.ArrayLengthContext arg) {
		onExit();
		this.inArrayLength.pop();
	}

	public boolean inArrayLength() {
      return !inArrayLength.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementType = new java.util.Stack<>();

	@Override
	public void enterElementType(com.generator.generators.go.parser.GolangParser.ElementTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inElementType.push(true);
	}

	public void exitElementType(com.generator.generators.go.parser.GolangParser.ElementTypeContext arg) {
		onExit();
		this.inElementType.pop();
	}

	public boolean inElementType() {
      return !inElementType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPointerType = new java.util.Stack<>();

	@Override
	public void enterPointerType(com.generator.generators.go.parser.GolangParser.PointerTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("PointerType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPointerType.push(true);
	}

	public void exitPointerType(com.generator.generators.go.parser.GolangParser.PointerTypeContext arg) {
		onExit();
		this.inPointerType.pop();
	}

	public boolean inPointerType() {
      return !inPointerType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceType = new java.util.Stack<>();

	@Override
	public void enterInterfaceType(com.generator.generators.go.parser.GolangParser.InterfaceTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInterfaceType.push(true);
	}

	public void exitInterfaceType(com.generator.generators.go.parser.GolangParser.InterfaceTypeContext arg) {
		onExit();
		this.inInterfaceType.pop();
	}

	public boolean inInterfaceType() {
      return !inInterfaceType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSliceType = new java.util.Stack<>();

	@Override
	public void enterSliceType(com.generator.generators.go.parser.GolangParser.SliceTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("SliceType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSliceType.push(true);
	}

	public void exitSliceType(com.generator.generators.go.parser.GolangParser.SliceTypeContext arg) {
		onExit();
		this.inSliceType.pop();
	}

	public boolean inSliceType() {
      return !inSliceType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMapType = new java.util.Stack<>();

	@Override
	public void enterMapType(com.generator.generators.go.parser.GolangParser.MapTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("MapType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMapType.push(true);
	}

	public void exitMapType(com.generator.generators.go.parser.GolangParser.MapTypeContext arg) {
		onExit();
		this.inMapType.pop();
	}

	public boolean inMapType() {
      return !inMapType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChannelType = new java.util.Stack<>();

	@Override
	public void enterChannelType(com.generator.generators.go.parser.GolangParser.ChannelTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ChannelType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inChannelType.push(true);
	}

	public void exitChannelType(com.generator.generators.go.parser.GolangParser.ChannelTypeContext arg) {
		onExit();
		this.inChannelType.pop();
	}

	public boolean inChannelType() {
      return !inChannelType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodSpec = new java.util.Stack<>();

	@Override
	public void enterMethodSpec(com.generator.generators.go.parser.GolangParser.MethodSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMethodSpec.push(true);
	}

	public void exitMethodSpec(com.generator.generators.go.parser.GolangParser.MethodSpecContext arg) {
		onExit();
		this.inMethodSpec.pop();
	}

	public boolean inMethodSpec() {
      return !inMethodSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionType = new java.util.Stack<>();

	@Override
	public void enterFunctionType(com.generator.generators.go.parser.GolangParser.FunctionTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctionType.push(true);
	}

	public void exitFunctionType(com.generator.generators.go.parser.GolangParser.FunctionTypeContext arg) {
		onExit();
		this.inFunctionType.pop();
	}

	public boolean inFunctionType() {
      return !inFunctionType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSignature = new java.util.Stack<>();

	@Override
	public void enterSignature(com.generator.generators.go.parser.GolangParser.SignatureContext arg) {
		final Node node = model.findOrCreate(Label.label("Signature"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSignature.push(true);
	}

	public void exitSignature(com.generator.generators.go.parser.GolangParser.SignatureContext arg) {
		onExit();
		this.inSignature.pop();
	}

	public boolean inSignature() {
      return !inSignature.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inResult = new java.util.Stack<>();

	@Override
	public void enterResult(com.generator.generators.go.parser.GolangParser.ResultContext arg) {
		final Node node = model.findOrCreate(Label.label("Result"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inResult.push(true);
	}

	public void exitResult(com.generator.generators.go.parser.GolangParser.ResultContext arg) {
		onExit();
		this.inResult.pop();
	}

	public boolean inResult() {
      return !inResult.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameters = new java.util.Stack<>();

	@Override
	public void enterParameters(com.generator.generators.go.parser.GolangParser.ParametersContext arg) {
		final Node node = model.findOrCreate(Label.label("Parameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inParameters.push(true);
	}

	public void exitParameters(com.generator.generators.go.parser.GolangParser.ParametersContext arg) {
		onExit();
		this.inParameters.pop();
	}

	public boolean inParameters() {
      return !inParameters.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameterList = new java.util.Stack<>();

	@Override
	public void enterParameterList(com.generator.generators.go.parser.GolangParser.ParameterListContext arg) {
		final Node node = model.findOrCreate(Label.label("ParameterList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inParameterList.push(true);
	}

	public void exitParameterList(com.generator.generators.go.parser.GolangParser.ParameterListContext arg) {
		onExit();
		this.inParameterList.pop();
	}

	public boolean inParameterList() {
      return !inParameterList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameterDecl = new java.util.Stack<>();

	@Override
	public void enterParameterDecl(com.generator.generators.go.parser.GolangParser.ParameterDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("ParameterDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inParameterDecl.push(true);
	}

	public void exitParameterDecl(com.generator.generators.go.parser.GolangParser.ParameterDeclContext arg) {
		onExit();
		this.inParameterDecl.pop();
	}

	public boolean inParameterDecl() {
      return !inParameterDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperand = new java.util.Stack<>();

	@Override
	public void enterOperand(com.generator.generators.go.parser.GolangParser.OperandContext arg) {
		final Node node = model.findOrCreate(Label.label("Operand"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOperand.push(true);
	}

	public void exitOperand(com.generator.generators.go.parser.GolangParser.OperandContext arg) {
		onExit();
		this.inOperand.pop();
	}

	public boolean inOperand() {
      return !inOperand.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBasicLit = new java.util.Stack<>();

	@Override
	public void enterBasicLit(com.generator.generators.go.parser.GolangParser.BasicLitContext arg) {
		final Node node = model.findOrCreate(Label.label("BasicLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBasicLit.push(true);
	}

	public void exitBasicLit(com.generator.generators.go.parser.GolangParser.BasicLitContext arg) {
		onExit();
		this.inBasicLit.pop();
	}

	public boolean inBasicLit() {
      return !inBasicLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperandName = new java.util.Stack<>();

	@Override
	public void enterOperandName(com.generator.generators.go.parser.GolangParser.OperandNameContext arg) {
		final Node node = model.findOrCreate(Label.label("OperandName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOperandName.push(true);
	}

	public void exitOperandName(com.generator.generators.go.parser.GolangParser.OperandNameContext arg) {
		onExit();
		this.inOperandName.pop();
	}

	public boolean inOperandName() {
      return !inOperandName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedIdent = new java.util.Stack<>();

	@Override
	public void enterQualifiedIdent(com.generator.generators.go.parser.GolangParser.QualifiedIdentContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedIdent"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inQualifiedIdent.push(true);
	}

	public void exitQualifiedIdent(com.generator.generators.go.parser.GolangParser.QualifiedIdentContext arg) {
		onExit();
		this.inQualifiedIdent.pop();
	}

	public boolean inQualifiedIdent() {
      return !inQualifiedIdent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompositeLit = new java.util.Stack<>();

	@Override
	public void enterCompositeLit(com.generator.generators.go.parser.GolangParser.CompositeLitContext arg) {
		final Node node = model.findOrCreate(Label.label("CompositeLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCompositeLit.push(true);
	}

	public void exitCompositeLit(com.generator.generators.go.parser.GolangParser.CompositeLitContext arg) {
		onExit();
		this.inCompositeLit.pop();
	}

	public boolean inCompositeLit() {
      return !inCompositeLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteralType = new java.util.Stack<>();

	@Override
	public void enterLiteralType(com.generator.generators.go.parser.GolangParser.LiteralTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("LiteralType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLiteralType.push(true);
	}

	public void exitLiteralType(com.generator.generators.go.parser.GolangParser.LiteralTypeContext arg) {
		onExit();
		this.inLiteralType.pop();
	}

	public boolean inLiteralType() {
      return !inLiteralType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteralValue = new java.util.Stack<>();

	@Override
	public void enterLiteralValue(com.generator.generators.go.parser.GolangParser.LiteralValueContext arg) {
		final Node node = model.findOrCreate(Label.label("LiteralValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLiteralValue.push(true);
	}

	public void exitLiteralValue(com.generator.generators.go.parser.GolangParser.LiteralValueContext arg) {
		onExit();
		this.inLiteralValue.pop();
	}

	public boolean inLiteralValue() {
      return !inLiteralValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyedElement = new java.util.Stack<>();

	@Override
	public void enterKeyedElement(com.generator.generators.go.parser.GolangParser.KeyedElementContext arg) {
		final Node node = model.findOrCreate(Label.label("KeyedElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inKeyedElement.push(true);
	}

	public void exitKeyedElement(com.generator.generators.go.parser.GolangParser.KeyedElementContext arg) {
		onExit();
		this.inKeyedElement.pop();
	}

	public boolean inKeyedElement() {
      return !inKeyedElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKey = new java.util.Stack<>();

	@Override
	public void enterKey(com.generator.generators.go.parser.GolangParser.KeyContext arg) {
		final Node node = model.findOrCreate(Label.label("Key"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inKey.push(true);
	}

	public void exitKey(com.generator.generators.go.parser.GolangParser.KeyContext arg) {
		onExit();
		this.inKey.pop();
	}

	public boolean inKey() {
      return !inKey.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStructType = new java.util.Stack<>();

	@Override
	public void enterStructType(com.generator.generators.go.parser.GolangParser.StructTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("StructType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inStructType.push(true);
	}

	public void exitStructType(com.generator.generators.go.parser.GolangParser.StructTypeContext arg) {
		onExit();
		this.inStructType.pop();
	}

	public boolean inStructType() {
      return !inStructType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFieldDecl = new java.util.Stack<>();

	@Override
	public void enterFieldDecl(com.generator.generators.go.parser.GolangParser.FieldDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("FieldDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFieldDecl.push(true);
	}

	public void exitFieldDecl(com.generator.generators.go.parser.GolangParser.FieldDeclContext arg) {
		onExit();
		this.inFieldDecl.pop();
	}

	public boolean inFieldDecl() {
      return !inFieldDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnonymousField = new java.util.Stack<>();

	@Override
	public void enterAnonymousField(com.generator.generators.go.parser.GolangParser.AnonymousFieldContext arg) {
		final Node node = model.findOrCreate(Label.label("AnonymousField"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAnonymousField.push(true);
	}

	public void exitAnonymousField(com.generator.generators.go.parser.GolangParser.AnonymousFieldContext arg) {
		onExit();
		this.inAnonymousField.pop();
	}

	public boolean inAnonymousField() {
      return !inAnonymousField.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionLit = new java.util.Stack<>();

	@Override
	public void enterFunctionLit(com.generator.generators.go.parser.GolangParser.FunctionLitContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctionLit.push(true);
	}

	public void exitFunctionLit(com.generator.generators.go.parser.GolangParser.FunctionLitContext arg) {
		onExit();
		this.inFunctionLit.pop();
	}

	public boolean inFunctionLit() {
      return !inFunctionLit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrimaryExpr = new java.util.Stack<>();

	@Override
	public void enterPrimaryExpr(com.generator.generators.go.parser.GolangParser.PrimaryExprContext arg) {
		final Node node = model.findOrCreate(Label.label("PrimaryExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPrimaryExpr.push(true);
	}

	public void exitPrimaryExpr(com.generator.generators.go.parser.GolangParser.PrimaryExprContext arg) {
		onExit();
		this.inPrimaryExpr.pop();
	}

	public boolean inPrimaryExpr() {
      return !inPrimaryExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIndex = new java.util.Stack<>();

	@Override
	public void enterIndex(com.generator.generators.go.parser.GolangParser.IndexContext arg) {
		final Node node = model.findOrCreate(Label.label("Index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inIndex.push(true);
	}

	public void exitIndex(com.generator.generators.go.parser.GolangParser.IndexContext arg) {
		onExit();
		this.inIndex.pop();
	}

	public boolean inIndex() {
      return !inIndex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSlice = new java.util.Stack<>();

	@Override
	public void enterSlice(com.generator.generators.go.parser.GolangParser.SliceContext arg) {
		final Node node = model.findOrCreate(Label.label("Slice"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSlice.push(true);
	}

	public void exitSlice(com.generator.generators.go.parser.GolangParser.SliceContext arg) {
		onExit();
		this.inSlice.pop();
	}

	public boolean inSlice() {
      return !inSlice.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeAssertion = new java.util.Stack<>();

	@Override
	public void enterTypeAssertion(com.generator.generators.go.parser.GolangParser.TypeAssertionContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeAssertion"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeAssertion.push(true);
	}

	public void exitTypeAssertion(com.generator.generators.go.parser.GolangParser.TypeAssertionContext arg) {
		onExit();
		this.inTypeAssertion.pop();
	}

	public boolean inTypeAssertion() {
      return !inTypeAssertion.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodExpr = new java.util.Stack<>();

	@Override
	public void enterMethodExpr(com.generator.generators.go.parser.GolangParser.MethodExprContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMethodExpr.push(true);
	}

	public void exitMethodExpr(com.generator.generators.go.parser.GolangParser.MethodExprContext arg) {
		onExit();
		this.inMethodExpr.pop();
	}

	public boolean inMethodExpr() {
      return !inMethodExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReceiverType = new java.util.Stack<>();

	@Override
	public void enterReceiverType(com.generator.generators.go.parser.GolangParser.ReceiverTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ReceiverType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inReceiverType.push(true);
	}

	public void exitReceiverType(com.generator.generators.go.parser.GolangParser.ReceiverTypeContext arg) {
		onExit();
		this.inReceiverType.pop();
	}

	public boolean inReceiverType() {
      return !inReceiverType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryExpr = new java.util.Stack<>();

	@Override
	public void enterUnaryExpr(com.generator.generators.go.parser.GolangParser.UnaryExprContext arg) {
		final Node node = model.findOrCreate(Label.label("UnaryExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUnaryExpr.push(true);
	}

	public void exitUnaryExpr(com.generator.generators.go.parser.GolangParser.UnaryExprContext arg) {
		onExit();
		this.inUnaryExpr.pop();
	}

	public boolean inUnaryExpr() {
      return !inUnaryExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConversion = new java.util.Stack<>();

	@Override
	public void enterConversion(com.generator.generators.go.parser.GolangParser.ConversionContext arg) {
		final Node node = model.findOrCreate(Label.label("Conversion"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConversion.push(true);
	}

	public void exitConversion(com.generator.generators.go.parser.GolangParser.ConversionContext arg) {
		onExit();
		this.inConversion.pop();
	}

	public boolean inConversion() {
      return !inConversion.isEmpty(); 
   }

}