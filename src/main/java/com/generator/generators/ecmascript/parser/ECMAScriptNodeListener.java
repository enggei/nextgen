package com.generator.generators.ecmascript.parser;

public class ECMAScriptNodeListener extends ECMAScriptBaseListener {

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

	public ECMAScriptNodeListener() {
		this(false);
	}

	public ECMAScriptNodeListener(boolean debug) {
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

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return !inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Keyword", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inKeyword.push(true);
	}

	public void exitKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		onExit();
		this.inKeyword.pop();
	}

	public boolean inKeyword() {
      return !inKeyword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNotExpression = new java.util.Stack<>();

	@Override
	public void enterNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		onEnter(new Node("NotExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ParenthesizedExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ReservedWord", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("DoStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("WhileStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ForStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ForVarStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ForInStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ForVarInStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ContinueStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("BreakStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ReturnStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("WithStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SwitchStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("CaseBlock", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("CaseClauses", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("CaseClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("DefaultClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LabelledStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ThrowStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TryStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("CatchProduction", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FinallyProduction", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("DebuggerStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FunctionDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FormalParameterList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FunctionBody", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ArrayLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ElementList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Elision", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ObjectLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PropertyNameAndValueList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PropertyExpressionAssignment", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PropertyGetter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PropertySetter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PropertyName", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PropertySetParameterList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ArgumentList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ExpressionSequence", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TernaryExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LogicalAndExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PreIncrementExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ObjectLiteralExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LogicalOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PreDecreaseExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ArgumentsExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ThisExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FunctionExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("UnaryMinusExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AssignmentExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PostDecreaseExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeofExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InstanceofExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("UnaryPlusExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("DeleteExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("EqualityExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("BitXOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("MultiplicativeExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("BitShiftExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AdditiveExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("RelationalExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PostIncrementExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("BitNotExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("NewExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LiteralExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ArrayLiteralExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("MemberDotExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("MemberIndexExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("IdentifierExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("BitAndExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("BitOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AssignmentOperatorExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VoidExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AssignmentOperator", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("NumericLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("IdentifierName", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FutureReservedWord", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Getter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Setter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Eos", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Eof", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Program", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SourceElements", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SourceElement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("StatementList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableDeclarationList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Initialiser", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("EmptyStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ExpressionStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("IfStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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