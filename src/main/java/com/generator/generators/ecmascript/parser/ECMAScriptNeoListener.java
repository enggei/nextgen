package com.generator.generators.ecmascript.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ECMAScriptNeoListener extends ECMAScriptBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public ECMAScriptNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public ECMAScriptNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyword = new java.util.Stack<>();

	@Override
	public void enterKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		final Node node = model.findOrCreate(Label.label("Keyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inKeyword.push(true);
	}

	public void exitKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		onExit();
		this.inKeyword.pop();
	}

	public boolean inKeyword() {
      return !inKeyword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return !inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNotExpression = new java.util.Stack<>();

	@Override
	public void enterNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("NotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNotExpression.push(true);
	}

	public void exitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		onExit();
		this.inNotExpression.pop();
	}

	public boolean inNotExpression() {
      return !inNotExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParenthesizedExpression = new java.util.Stack<>();

	@Override
	public void enterParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ParenthesizedExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParenthesizedExpression.push(true);
	}

	public void exitParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		onExit();
		this.inParenthesizedExpression.pop();
	}

	public boolean inParenthesizedExpression() {
      return !inParenthesizedExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReservedWord = new java.util.Stack<>();

	@Override
	public void enterReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		final Node node = model.findOrCreate(Label.label("ReservedWord"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReservedWord.push(true);
	}

	public void exitReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		onExit();
		this.inReservedWord.pop();
	}

	public boolean inReservedWord() {
      return !inReservedWord.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDoStatement = new java.util.Stack<>();

	@Override
	public void enterDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("DoStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDoStatement.push(true);
	}

	public void exitDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		onExit();
		this.inDoStatement.pop();
	}

	public boolean inDoStatement() {
      return !inDoStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWhileStatement = new java.util.Stack<>();

	@Override
	public void enterWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("WhileStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inWhileStatement.push(true);
	}

	public void exitWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		onExit();
		this.inWhileStatement.pop();
	}

	public boolean inWhileStatement() {
      return !inWhileStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForStatement = new java.util.Stack<>();

	@Override
	public void enterForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ForStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForStatement.push(true);
	}

	public void exitForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		onExit();
		this.inForStatement.pop();
	}

	public boolean inForStatement() {
      return !inForStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForVarStatement = new java.util.Stack<>();

	@Override
	public void enterForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ForVarStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForVarStatement.push(true);
	}

	public void exitForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		onExit();
		this.inForVarStatement.pop();
	}

	public boolean inForVarStatement() {
      return !inForVarStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForInStatement = new java.util.Stack<>();

	@Override
	public void enterForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ForInStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForInStatement.push(true);
	}

	public void exitForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		onExit();
		this.inForInStatement.pop();
	}

	public boolean inForInStatement() {
      return !inForInStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForVarInStatement = new java.util.Stack<>();

	@Override
	public void enterForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ForVarInStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForVarInStatement.push(true);
	}

	public void exitForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		onExit();
		this.inForVarInStatement.pop();
	}

	public boolean inForVarInStatement() {
      return !inForVarInStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inContinueStatement = new java.util.Stack<>();

	@Override
	public void enterContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ContinueStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inContinueStatement.push(true);
	}

	public void exitContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		onExit();
		this.inContinueStatement.pop();
	}

	public boolean inContinueStatement() {
      return !inContinueStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBreakStatement = new java.util.Stack<>();

	@Override
	public void enterBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("BreakStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBreakStatement.push(true);
	}

	public void exitBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		onExit();
		this.inBreakStatement.pop();
	}

	public boolean inBreakStatement() {
      return !inBreakStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturnStatement = new java.util.Stack<>();

	@Override
	public void enterReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ReturnStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReturnStatement.push(true);
	}

	public void exitReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		onExit();
		this.inReturnStatement.pop();
	}

	public boolean inReturnStatement() {
      return !inReturnStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWithStatement = new java.util.Stack<>();

	@Override
	public void enterWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("WithStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inWithStatement.push(true);
	}

	public void exitWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		onExit();
		this.inWithStatement.pop();
	}

	public boolean inWithStatement() {
      return !inWithStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSwitchStatement = new java.util.Stack<>();

	@Override
	public void enterSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("SwitchStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSwitchStatement.push(true);
	}

	public void exitSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		onExit();
		this.inSwitchStatement.pop();
	}

	public boolean inSwitchStatement() {
      return !inSwitchStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseBlock = new java.util.Stack<>();

	@Override
	public void enterCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("CaseBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCaseBlock.push(true);
	}

	public void exitCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		onExit();
		this.inCaseBlock.pop();
	}

	public boolean inCaseBlock() {
      return !inCaseBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseClauses = new java.util.Stack<>();

	@Override
	public void enterCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		final Node node = model.findOrCreate(Label.label("CaseClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCaseClauses.push(true);
	}

	public void exitCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		onExit();
		this.inCaseClauses.pop();
	}

	public boolean inCaseClauses() {
      return !inCaseClauses.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseClause = new java.util.Stack<>();

	@Override
	public void enterCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("CaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCaseClause.push(true);
	}

	public void exitCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		onExit();
		this.inCaseClause.pop();
	}

	public boolean inCaseClause() {
      return !inCaseClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultClause = new java.util.Stack<>();

	@Override
	public void enterDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("DefaultClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDefaultClause.push(true);
	}

	public void exitDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		onExit();
		this.inDefaultClause.pop();
	}

	public boolean inDefaultClause() {
      return !inDefaultClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabelledStatement = new java.util.Stack<>();

	@Override
	public void enterLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("LabelledStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLabelledStatement.push(true);
	}

	public void exitLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		onExit();
		this.inLabelledStatement.pop();
	}

	public boolean inLabelledStatement() {
      return !inLabelledStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inThrowStatement = new java.util.Stack<>();

	@Override
	public void enterThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ThrowStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inThrowStatement.push(true);
	}

	public void exitThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		onExit();
		this.inThrowStatement.pop();
	}

	public boolean inThrowStatement() {
      return !inThrowStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTryStatement = new java.util.Stack<>();

	@Override
	public void enterTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("TryStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTryStatement.push(true);
	}

	public void exitTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		onExit();
		this.inTryStatement.pop();
	}

	public boolean inTryStatement() {
      return !inTryStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCatchProduction = new java.util.Stack<>();

	@Override
	public void enterCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		final Node node = model.findOrCreate(Label.label("CatchProduction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCatchProduction.push(true);
	}

	public void exitCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		onExit();
		this.inCatchProduction.pop();
	}

	public boolean inCatchProduction() {
      return !inCatchProduction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFinallyProduction = new java.util.Stack<>();

	@Override
	public void enterFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		final Node node = model.findOrCreate(Label.label("FinallyProduction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFinallyProduction.push(true);
	}

	public void exitFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		onExit();
		this.inFinallyProduction.pop();
	}

	public boolean inFinallyProduction() {
      return !inFinallyProduction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDebuggerStatement = new java.util.Stack<>();

	@Override
	public void enterDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("DebuggerStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDebuggerStatement.push(true);
	}

	public void exitDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		onExit();
		this.inDebuggerStatement.pop();
	}

	public boolean inDebuggerStatement() {
      return !inDebuggerStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionDeclaration = new java.util.Stack<>();

	@Override
	public void enterFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunctionDeclaration.push(true);
	}

	public void exitFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		onExit();
		this.inFunctionDeclaration.pop();
	}

	public boolean inFunctionDeclaration() {
      return !inFunctionDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFormalParameterList = new java.util.Stack<>();

	@Override
	public void enterFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		final Node node = model.findOrCreate(Label.label("FormalParameterList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFormalParameterList.push(true);
	}

	public void exitFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		onExit();
		this.inFormalParameterList.pop();
	}

	public boolean inFormalParameterList() {
      return !inFormalParameterList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionBody = new java.util.Stack<>();

	@Override
	public void enterFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunctionBody.push(true);
	}

	public void exitFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		onExit();
		this.inFunctionBody.pop();
	}

	public boolean inFunctionBody() {
      return !inFunctionBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayLiteral = new java.util.Stack<>();

	@Override
	public void enterArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArrayLiteral.push(true);
	}

	public void exitArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		onExit();
		this.inArrayLiteral.pop();
	}

	public boolean inArrayLiteral() {
      return !inArrayLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementList = new java.util.Stack<>();

	@Override
	public void enterElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inElementList.push(true);
	}

	public void exitElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		onExit();
		this.inElementList.pop();
	}

	public boolean inElementList() {
      return !inElementList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElision = new java.util.Stack<>();

	@Override
	public void enterElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		final Node node = model.findOrCreate(Label.label("Elision"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inElision.push(true);
	}

	public void exitElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		onExit();
		this.inElision.pop();
	}

	public boolean inElision() {
      return !inElision.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObjectLiteral = new java.util.Stack<>();

	@Override
	public void enterObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("ObjectLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inObjectLiteral.push(true);
	}

	public void exitObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		onExit();
		this.inObjectLiteral.pop();
	}

	public boolean inObjectLiteral() {
      return !inObjectLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyNameAndValueList = new java.util.Stack<>();

	@Override
	public void enterPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyNameAndValueList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPropertyNameAndValueList.push(true);
	}

	public void exitPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		onExit();
		this.inPropertyNameAndValueList.pop();
	}

	public boolean inPropertyNameAndValueList() {
      return !inPropertyNameAndValueList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyExpressionAssignment = new java.util.Stack<>();

	@Override
	public void enterPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyExpressionAssignment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPropertyExpressionAssignment.push(true);
	}

	public void exitPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		onExit();
		this.inPropertyExpressionAssignment.pop();
	}

	public boolean inPropertyExpressionAssignment() {
      return !inPropertyExpressionAssignment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyGetter = new java.util.Stack<>();

	@Override
	public void enterPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyGetter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPropertyGetter.push(true);
	}

	public void exitPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		onExit();
		this.inPropertyGetter.pop();
	}

	public boolean inPropertyGetter() {
      return !inPropertyGetter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertySetter = new java.util.Stack<>();

	@Override
	public void enterPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertySetter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPropertySetter.push(true);
	}

	public void exitPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		onExit();
		this.inPropertySetter.pop();
	}

	public boolean inPropertySetter() {
      return !inPropertySetter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyName = new java.util.Stack<>();

	@Override
	public void enterPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPropertyName.push(true);
	}

	public void exitPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		onExit();
		this.inPropertyName.pop();
	}

	public boolean inPropertyName() {
      return !inPropertyName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertySetParameterList = new java.util.Stack<>();

	@Override
	public void enterPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertySetParameterList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPropertySetParameterList.push(true);
	}

	public void exitPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		onExit();
		this.inPropertySetParameterList.pop();
	}

	public boolean inPropertySetParameterList() {
      return !inPropertySetParameterList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArguments = new java.util.Stack<>();

	@Override
	public void enterArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("Arguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArguments.push(true);
	}

	public void exitArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		onExit();
		this.inArguments.pop();
	}

	public boolean inArguments() {
      return !inArguments.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgumentList = new java.util.Stack<>();

	@Override
	public void enterArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		final Node node = model.findOrCreate(Label.label("ArgumentList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArgumentList.push(true);
	}

	public void exitArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		onExit();
		this.inArgumentList.pop();
	}

	public boolean inArgumentList() {
      return !inArgumentList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionSequence = new java.util.Stack<>();

	@Override
	public void enterExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		final Node node = model.findOrCreate(Label.label("ExpressionSequence"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpressionSequence.push(true);
	}

	public void exitExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		onExit();
		this.inExpressionSequence.pop();
	}

	public boolean inExpressionSequence() {
      return !inExpressionSequence.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTernaryExpression = new java.util.Stack<>();

	@Override
	public void enterTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("TernaryExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTernaryExpression.push(true);
	}

	public void exitTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		onExit();
		this.inTernaryExpression.pop();
	}

	public boolean inTernaryExpression() {
      return !inTernaryExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLogicalAndExpression = new java.util.Stack<>();

	@Override
	public void enterLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("LogicalAndExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLogicalAndExpression.push(true);
	}

	public void exitLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		onExit();
		this.inLogicalAndExpression.pop();
	}

	public boolean inLogicalAndExpression() {
      return !inLogicalAndExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPreIncrementExpression = new java.util.Stack<>();

	@Override
	public void enterPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("PreIncrementExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPreIncrementExpression.push(true);
	}

	public void exitPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		onExit();
		this.inPreIncrementExpression.pop();
	}

	public boolean inPreIncrementExpression() {
      return !inPreIncrementExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObjectLiteralExpression = new java.util.Stack<>();

	@Override
	public void enterObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ObjectLiteralExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inObjectLiteralExpression.push(true);
	}

	public void exitObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		onExit();
		this.inObjectLiteralExpression.pop();
	}

	public boolean inObjectLiteralExpression() {
      return !inObjectLiteralExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInExpression = new java.util.Stack<>();

	@Override
	public void enterInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("InExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInExpression.push(true);
	}

	public void exitInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		onExit();
		this.inInExpression.pop();
	}

	public boolean inInExpression() {
      return !inInExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLogicalOrExpression = new java.util.Stack<>();

	@Override
	public void enterLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("LogicalOrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLogicalOrExpression.push(true);
	}

	public void exitLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		onExit();
		this.inLogicalOrExpression.pop();
	}

	public boolean inLogicalOrExpression() {
      return !inLogicalOrExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPreDecreaseExpression = new java.util.Stack<>();

	@Override
	public void enterPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("PreDecreaseExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPreDecreaseExpression.push(true);
	}

	public void exitPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		onExit();
		this.inPreDecreaseExpression.pop();
	}

	public boolean inPreDecreaseExpression() {
      return !inPreDecreaseExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgumentsExpression = new java.util.Stack<>();

	@Override
	public void enterArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ArgumentsExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArgumentsExpression.push(true);
	}

	public void exitArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		onExit();
		this.inArgumentsExpression.pop();
	}

	public boolean inArgumentsExpression() {
      return !inArgumentsExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inThisExpression = new java.util.Stack<>();

	@Override
	public void enterThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ThisExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inThisExpression.push(true);
	}

	public void exitThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		onExit();
		this.inThisExpression.pop();
	}

	public boolean inThisExpression() {
      return !inThisExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionExpression = new java.util.Stack<>();

	@Override
	public void enterFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunctionExpression.push(true);
	}

	public void exitFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		onExit();
		this.inFunctionExpression.pop();
	}

	public boolean inFunctionExpression() {
      return !inFunctionExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryMinusExpression = new java.util.Stack<>();

	@Override
	public void enterUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("UnaryMinusExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnaryMinusExpression.push(true);
	}

	public void exitUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		onExit();
		this.inUnaryMinusExpression.pop();
	}

	public boolean inUnaryMinusExpression() {
      return !inUnaryMinusExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssignmentExpression = new java.util.Stack<>();

	@Override
	public void enterAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("AssignmentExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAssignmentExpression.push(true);
	}

	public void exitAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		onExit();
		this.inAssignmentExpression.pop();
	}

	public boolean inAssignmentExpression() {
      return !inAssignmentExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPostDecreaseExpression = new java.util.Stack<>();

	@Override
	public void enterPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("PostDecreaseExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPostDecreaseExpression.push(true);
	}

	public void exitPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		onExit();
		this.inPostDecreaseExpression.pop();
	}

	public boolean inPostDecreaseExpression() {
      return !inPostDecreaseExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeofExpression = new java.util.Stack<>();

	@Override
	public void enterTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeofExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeofExpression.push(true);
	}

	public void exitTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		onExit();
		this.inTypeofExpression.pop();
	}

	public boolean inTypeofExpression() {
      return !inTypeofExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInstanceofExpression = new java.util.Stack<>();

	@Override
	public void enterInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("InstanceofExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInstanceofExpression.push(true);
	}

	public void exitInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		onExit();
		this.inInstanceofExpression.pop();
	}

	public boolean inInstanceofExpression() {
      return !inInstanceofExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryPlusExpression = new java.util.Stack<>();

	@Override
	public void enterUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("UnaryPlusExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnaryPlusExpression.push(true);
	}

	public void exitUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		onExit();
		this.inUnaryPlusExpression.pop();
	}

	public boolean inUnaryPlusExpression() {
      return !inUnaryPlusExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeleteExpression = new java.util.Stack<>();

	@Override
	public void enterDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("DeleteExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDeleteExpression.push(true);
	}

	public void exitDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		onExit();
		this.inDeleteExpression.pop();
	}

	public boolean inDeleteExpression() {
      return !inDeleteExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEqualityExpression = new java.util.Stack<>();

	@Override
	public void enterEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("EqualityExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEqualityExpression.push(true);
	}

	public void exitEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		onExit();
		this.inEqualityExpression.pop();
	}

	public boolean inEqualityExpression() {
      return !inEqualityExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBitXOrExpression = new java.util.Stack<>();

	@Override
	public void enterBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("BitXOrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBitXOrExpression.push(true);
	}

	public void exitBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		onExit();
		this.inBitXOrExpression.pop();
	}

	public boolean inBitXOrExpression() {
      return !inBitXOrExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiplicativeExpression = new java.util.Stack<>();

	@Override
	public void enterMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("MultiplicativeExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMultiplicativeExpression.push(true);
	}

	public void exitMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		onExit();
		this.inMultiplicativeExpression.pop();
	}

	public boolean inMultiplicativeExpression() {
      return !inMultiplicativeExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBitShiftExpression = new java.util.Stack<>();

	@Override
	public void enterBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("BitShiftExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBitShiftExpression.push(true);
	}

	public void exitBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		onExit();
		this.inBitShiftExpression.pop();
	}

	public boolean inBitShiftExpression() {
      return !inBitShiftExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAdditiveExpression = new java.util.Stack<>();

	@Override
	public void enterAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("AdditiveExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAdditiveExpression.push(true);
	}

	public void exitAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		onExit();
		this.inAdditiveExpression.pop();
	}

	public boolean inAdditiveExpression() {
      return !inAdditiveExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationalExpression = new java.util.Stack<>();

	@Override
	public void enterRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("RelationalExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRelationalExpression.push(true);
	}

	public void exitRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		onExit();
		this.inRelationalExpression.pop();
	}

	public boolean inRelationalExpression() {
      return !inRelationalExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPostIncrementExpression = new java.util.Stack<>();

	@Override
	public void enterPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("PostIncrementExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPostIncrementExpression.push(true);
	}

	public void exitPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		onExit();
		this.inPostIncrementExpression.pop();
	}

	public boolean inPostIncrementExpression() {
      return !inPostIncrementExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBitNotExpression = new java.util.Stack<>();

	@Override
	public void enterBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("BitNotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBitNotExpression.push(true);
	}

	public void exitBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		onExit();
		this.inBitNotExpression.pop();
	}

	public boolean inBitNotExpression() {
      return !inBitNotExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNewExpression = new java.util.Stack<>();

	@Override
	public void enterNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("NewExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNewExpression.push(true);
	}

	public void exitNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		onExit();
		this.inNewExpression.pop();
	}

	public boolean inNewExpression() {
      return !inNewExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteralExpression = new java.util.Stack<>();

	@Override
	public void enterLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("LiteralExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLiteralExpression.push(true);
	}

	public void exitLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		onExit();
		this.inLiteralExpression.pop();
	}

	public boolean inLiteralExpression() {
      return !inLiteralExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayLiteralExpression = new java.util.Stack<>();

	@Override
	public void enterArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayLiteralExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArrayLiteralExpression.push(true);
	}

	public void exitArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		onExit();
		this.inArrayLiteralExpression.pop();
	}

	public boolean inArrayLiteralExpression() {
      return !inArrayLiteralExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberDotExpression = new java.util.Stack<>();

	@Override
	public void enterMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("MemberDotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMemberDotExpression.push(true);
	}

	public void exitMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		onExit();
		this.inMemberDotExpression.pop();
	}

	public boolean inMemberDotExpression() {
      return !inMemberDotExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberIndexExpression = new java.util.Stack<>();

	@Override
	public void enterMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("MemberIndexExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMemberIndexExpression.push(true);
	}

	public void exitMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		onExit();
		this.inMemberIndexExpression.pop();
	}

	public boolean inMemberIndexExpression() {
      return !inMemberIndexExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdentifierExpression = new java.util.Stack<>();

	@Override
	public void enterIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("IdentifierExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIdentifierExpression.push(true);
	}

	public void exitIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		onExit();
		this.inIdentifierExpression.pop();
	}

	public boolean inIdentifierExpression() {
      return !inIdentifierExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBitAndExpression = new java.util.Stack<>();

	@Override
	public void enterBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("BitAndExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBitAndExpression.push(true);
	}

	public void exitBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		onExit();
		this.inBitAndExpression.pop();
	}

	public boolean inBitAndExpression() {
      return !inBitAndExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBitOrExpression = new java.util.Stack<>();

	@Override
	public void enterBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("BitOrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBitOrExpression.push(true);
	}

	public void exitBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		onExit();
		this.inBitOrExpression.pop();
	}

	public boolean inBitOrExpression() {
      return !inBitOrExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssignmentOperatorExpression = new java.util.Stack<>();

	@Override
	public void enterAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("AssignmentOperatorExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAssignmentOperatorExpression.push(true);
	}

	public void exitAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		onExit();
		this.inAssignmentOperatorExpression.pop();
	}

	public boolean inAssignmentOperatorExpression() {
      return !inAssignmentOperatorExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVoidExpression = new java.util.Stack<>();

	@Override
	public void enterVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("VoidExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVoidExpression.push(true);
	}

	public void exitVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		onExit();
		this.inVoidExpression.pop();
	}

	public boolean inVoidExpression() {
      return !inVoidExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssignmentOperator = new java.util.Stack<>();

	@Override
	public void enterAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("AssignmentOperator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAssignmentOperator.push(true);
	}

	public void exitAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		onExit();
		this.inAssignmentOperator.pop();
	}

	public boolean inAssignmentOperator() {
      return !inAssignmentOperator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericLiteral = new java.util.Stack<>();

	@Override
	public void enterNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("NumericLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNumericLiteral.push(true);
	}

	public void exitNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		onExit();
		this.inNumericLiteral.pop();
	}

	public boolean inNumericLiteral() {
      return !inNumericLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdentifierName = new java.util.Stack<>();

	@Override
	public void enterIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		final Node node = model.findOrCreate(Label.label("IdentifierName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIdentifierName.push(true);
	}

	public void exitIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		onExit();
		this.inIdentifierName.pop();
	}

	public boolean inIdentifierName() {
      return !inIdentifierName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFutureReservedWord = new java.util.Stack<>();

	@Override
	public void enterFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		final Node node = model.findOrCreate(Label.label("FutureReservedWord"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFutureReservedWord.push(true);
	}

	public void exitFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		onExit();
		this.inFutureReservedWord.pop();
	}

	public boolean inFutureReservedWord() {
      return !inFutureReservedWord.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGetter = new java.util.Stack<>();

	@Override
	public void enterGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		final Node node = model.findOrCreate(Label.label("Getter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGetter.push(true);
	}

	public void exitGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		onExit();
		this.inGetter.pop();
	}

	public boolean inGetter() {
      return !inGetter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetter = new java.util.Stack<>();

	@Override
	public void enterSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		final Node node = model.findOrCreate(Label.label("Setter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSetter.push(true);
	}

	public void exitSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		onExit();
		this.inSetter.pop();
	}

	public boolean inSetter() {
      return !inSetter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEos = new java.util.Stack<>();

	@Override
	public void enterEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		final Node node = model.findOrCreate(Label.label("Eos"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEos.push(true);
	}

	public void exitEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		onExit();
		this.inEos.pop();
	}

	public boolean inEos() {
      return !inEos.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEof = new java.util.Stack<>();

	@Override
	public void enterEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		final Node node = model.findOrCreate(Label.label("Eof"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEof.push(true);
	}

	public void exitEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		onExit();
		this.inEof.pop();
	}

	public boolean inEof() {
      return !inEof.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProgram = new java.util.Stack<>();

	@Override
	public void enterProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		final Node node = model.findOrCreate(Label.label("Program"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inProgram.push(true);
	}

	public void exitProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		onExit();
		this.inProgram.pop();
	}

	public boolean inProgram() {
      return !inProgram.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSourceElements = new java.util.Stack<>();

	@Override
	public void enterSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		final Node node = model.findOrCreate(Label.label("SourceElements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSourceElements.push(true);
	}

	public void exitSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		onExit();
		this.inSourceElements.pop();
	}

	public boolean inSourceElements() {
      return !inSourceElements.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSourceElement = new java.util.Stack<>();

	@Override
	public void enterSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		final Node node = model.findOrCreate(Label.label("SourceElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSourceElement.push(true);
	}

	public void exitSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		onExit();
		this.inSourceElement.pop();
	}

	public boolean inSourceElement() {
      return !inSourceElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatementList = new java.util.Stack<>();

	@Override
	public void enterStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		final Node node = model.findOrCreate(Label.label("StatementList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStatementList.push(true);
	}

	public void exitStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		onExit();
		this.inStatementList.pop();
	}

	public boolean inStatementList() {
      return !inStatementList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableStatement = new java.util.Stack<>();

	@Override
	public void enterVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableStatement.push(true);
	}

	public void exitVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		onExit();
		this.inVariableStatement.pop();
	}

	public boolean inVariableStatement() {
      return !inVariableStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableDeclarationList = new java.util.Stack<>();

	@Override
	public void enterVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclarationList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableDeclarationList.push(true);
	}

	public void exitVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		onExit();
		this.inVariableDeclarationList.pop();
	}

	public boolean inVariableDeclarationList() {
      return !inVariableDeclarationList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableDeclaration = new java.util.Stack<>();

	@Override
	public void enterVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableDeclaration.push(true);
	}

	public void exitVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		onExit();
		this.inVariableDeclaration.pop();
	}

	public boolean inVariableDeclaration() {
      return !inVariableDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInitialiser = new java.util.Stack<>();

	@Override
	public void enterInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		final Node node = model.findOrCreate(Label.label("Initialiser"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInitialiser.push(true);
	}

	public void exitInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		onExit();
		this.inInitialiser.pop();
	}

	public boolean inInitialiser() {
      return !inInitialiser.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEmptyStatement = new java.util.Stack<>();

	@Override
	public void enterEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("EmptyStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEmptyStatement.push(true);
	}

	public void exitEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		onExit();
		this.inEmptyStatement.pop();
	}

	public boolean inEmptyStatement() {
      return !inEmptyStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionStatement = new java.util.Stack<>();

	@Override
	public void enterExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("ExpressionStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpressionStatement.push(true);
	}

	public void exitExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		onExit();
		this.inExpressionStatement.pop();
	}

	public boolean inExpressionStatement() {
      return !inExpressionStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIfStatement = new java.util.Stack<>();

	@Override
	public void enterIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("IfStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIfStatement.push(true);
	}

	public void exitIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		onExit();
		this.inIfStatement.pop();
	}

	public boolean inIfStatement() {
      return !inIfStatement.isEmpty(); 
   }

}