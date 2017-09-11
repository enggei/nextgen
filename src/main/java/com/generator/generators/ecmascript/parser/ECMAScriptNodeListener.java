package com.generator.generators.ecmascript.parser;

public class ECMAScriptNodeListener extends ECMAScriptBaseListener {

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

	public ECMAScriptNodeListener() {
		this(false);
	}

	public ECMAScriptNodeListener(boolean debug) {
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

	protected boolean inBlock = false;

	@Override
	public void enterBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
		this.inBlock = true;
	}

	public void exitBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		onExit();
		this.inBlock = false;
	}

	protected boolean inStatement = false;

	@Override
	public void enterStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
		this.inStatement = true;
	}

	public void exitStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		onExit();
		this.inStatement = false;
	}

	protected boolean inLiteral = false;

	@Override
	public void enterLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
		this.inLiteral = true;
	}

	public void exitLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		onExit();
		this.inLiteral = false;
	}

	protected boolean inProgram = false;

	@Override
	public void enterProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		onEnter(new Node("Program", arg.getText(), arg.getStart().getText()));
		this.inProgram = true;
	}

	public void exitProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		onExit();
		this.inProgram = false;
	}

	protected boolean inSourceElements = false;

	@Override
	public void enterSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		onEnter(new Node("SourceElements", arg.getText(), arg.getStart().getText()));
		this.inSourceElements = true;
	}

	public void exitSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		onExit();
		this.inSourceElements = false;
	}

	protected boolean inSourceElement = false;

	@Override
	public void enterSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		onEnter(new Node("SourceElement", arg.getText(), arg.getStart().getText()));
		this.inSourceElement = true;
	}

	public void exitSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		onExit();
		this.inSourceElement = false;
	}

	protected boolean inStatementList = false;

	@Override
	public void enterStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		onEnter(new Node("StatementList", arg.getText(), arg.getStart().getText()));
		this.inStatementList = true;
	}

	public void exitStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		onExit();
		this.inStatementList = false;
	}

	protected boolean inVariableStatement = false;

	@Override
	public void enterVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		onEnter(new Node("VariableStatement", arg.getText(), arg.getStart().getText()));
		this.inVariableStatement = true;
	}

	public void exitVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		onExit();
		this.inVariableStatement = false;
	}

	protected boolean inVariableDeclarationList = false;

	@Override
	public void enterVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		onEnter(new Node("VariableDeclarationList", arg.getText(), arg.getStart().getText()));
		this.inVariableDeclarationList = true;
	}

	public void exitVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		onExit();
		this.inVariableDeclarationList = false;
	}

	protected boolean inVariableDeclaration = false;

	@Override
	public void enterVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		onEnter(new Node("VariableDeclaration", arg.getText(), arg.getStart().getText()));
		this.inVariableDeclaration = true;
	}

	public void exitVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		onExit();
		this.inVariableDeclaration = false;
	}

	protected boolean inInitialiser = false;

	@Override
	public void enterInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		onEnter(new Node("Initialiser", arg.getText(), arg.getStart().getText()));
		this.inInitialiser = true;
	}

	public void exitInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		onExit();
		this.inInitialiser = false;
	}

	protected boolean inEmptyStatement = false;

	@Override
	public void enterEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		onEnter(new Node("EmptyStatement", arg.getText(), arg.getStart().getText()));
		this.inEmptyStatement = true;
	}

	public void exitEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		onExit();
		this.inEmptyStatement = false;
	}

	protected boolean inExpressionStatement = false;

	@Override
	public void enterExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		onEnter(new Node("ExpressionStatement", arg.getText(), arg.getStart().getText()));
		this.inExpressionStatement = true;
	}

	public void exitExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		onExit();
		this.inExpressionStatement = false;
	}

	protected boolean inIfStatement = false;

	@Override
	public void enterIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		onEnter(new Node("IfStatement", arg.getText(), arg.getStart().getText()));
		this.inIfStatement = true;
	}

	public void exitIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		onExit();
		this.inIfStatement = false;
	}

	protected boolean inDoStatement = false;

	@Override
	public void enterDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		onEnter(new Node("DoStatement", arg.getText(), arg.getStart().getText()));
		this.inDoStatement = true;
	}

	public void exitDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		onExit();
		this.inDoStatement = false;
	}

	protected boolean inWhileStatement = false;

	@Override
	public void enterWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		onEnter(new Node("WhileStatement", arg.getText(), arg.getStart().getText()));
		this.inWhileStatement = true;
	}

	public void exitWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		onExit();
		this.inWhileStatement = false;
	}

	protected boolean inForStatement = false;

	@Override
	public void enterForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		onEnter(new Node("ForStatement", arg.getText(), arg.getStart().getText()));
		this.inForStatement = true;
	}

	public void exitForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		onExit();
		this.inForStatement = false;
	}

	protected boolean inForVarStatement = false;

	@Override
	public void enterForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		onEnter(new Node("ForVarStatement", arg.getText(), arg.getStart().getText()));
		this.inForVarStatement = true;
	}

	public void exitForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		onExit();
		this.inForVarStatement = false;
	}

	protected boolean inForInStatement = false;

	@Override
	public void enterForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		onEnter(new Node("ForInStatement", arg.getText(), arg.getStart().getText()));
		this.inForInStatement = true;
	}

	public void exitForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		onExit();
		this.inForInStatement = false;
	}

	protected boolean inForVarInStatement = false;

	@Override
	public void enterForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		onEnter(new Node("ForVarInStatement", arg.getText(), arg.getStart().getText()));
		this.inForVarInStatement = true;
	}

	public void exitForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		onExit();
		this.inForVarInStatement = false;
	}

	protected boolean inContinueStatement = false;

	@Override
	public void enterContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		onEnter(new Node("ContinueStatement", arg.getText(), arg.getStart().getText()));
		this.inContinueStatement = true;
	}

	public void exitContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		onExit();
		this.inContinueStatement = false;
	}

	protected boolean inBreakStatement = false;

	@Override
	public void enterBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		onEnter(new Node("BreakStatement", arg.getText(), arg.getStart().getText()));
		this.inBreakStatement = true;
	}

	public void exitBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		onExit();
		this.inBreakStatement = false;
	}

	protected boolean inReturnStatement = false;

	@Override
	public void enterReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		onEnter(new Node("ReturnStatement", arg.getText(), arg.getStart().getText()));
		this.inReturnStatement = true;
	}

	public void exitReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		onExit();
		this.inReturnStatement = false;
	}

	protected boolean inWithStatement = false;

	@Override
	public void enterWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		onEnter(new Node("WithStatement", arg.getText(), arg.getStart().getText()));
		this.inWithStatement = true;
	}

	public void exitWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		onExit();
		this.inWithStatement = false;
	}

	protected boolean inSwitchStatement = false;

	@Override
	public void enterSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		onEnter(new Node("SwitchStatement", arg.getText(), arg.getStart().getText()));
		this.inSwitchStatement = true;
	}

	public void exitSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		onExit();
		this.inSwitchStatement = false;
	}

	protected boolean inCaseBlock = false;

	@Override
	public void enterCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		onEnter(new Node("CaseBlock", arg.getText(), arg.getStart().getText()));
		this.inCaseBlock = true;
	}

	public void exitCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		onExit();
		this.inCaseBlock = false;
	}

	protected boolean inCaseClauses = false;

	@Override
	public void enterCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		onEnter(new Node("CaseClauses", arg.getText(), arg.getStart().getText()));
		this.inCaseClauses = true;
	}

	public void exitCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		onExit();
		this.inCaseClauses = false;
	}

	protected boolean inCaseClause = false;

	@Override
	public void enterCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		onEnter(new Node("CaseClause", arg.getText(), arg.getStart().getText()));
		this.inCaseClause = true;
	}

	public void exitCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		onExit();
		this.inCaseClause = false;
	}

	protected boolean inDefaultClause = false;

	@Override
	public void enterDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		onEnter(new Node("DefaultClause", arg.getText(), arg.getStart().getText()));
		this.inDefaultClause = true;
	}

	public void exitDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		onExit();
		this.inDefaultClause = false;
	}

	protected boolean inLabelledStatement = false;

	@Override
	public void enterLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		onEnter(new Node("LabelledStatement", arg.getText(), arg.getStart().getText()));
		this.inLabelledStatement = true;
	}

	public void exitLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		onExit();
		this.inLabelledStatement = false;
	}

	protected boolean inThrowStatement = false;

	@Override
	public void enterThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		onEnter(new Node("ThrowStatement", arg.getText(), arg.getStart().getText()));
		this.inThrowStatement = true;
	}

	public void exitThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		onExit();
		this.inThrowStatement = false;
	}

	protected boolean inTryStatement = false;

	@Override
	public void enterTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		onEnter(new Node("TryStatement", arg.getText(), arg.getStart().getText()));
		this.inTryStatement = true;
	}

	public void exitTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		onExit();
		this.inTryStatement = false;
	}

	protected boolean inCatchProduction = false;

	@Override
	public void enterCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		onEnter(new Node("CatchProduction", arg.getText(), arg.getStart().getText()));
		this.inCatchProduction = true;
	}

	public void exitCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		onExit();
		this.inCatchProduction = false;
	}

	protected boolean inFinallyProduction = false;

	@Override
	public void enterFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		onEnter(new Node("FinallyProduction", arg.getText(), arg.getStart().getText()));
		this.inFinallyProduction = true;
	}

	public void exitFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		onExit();
		this.inFinallyProduction = false;
	}

	protected boolean inDebuggerStatement = false;

	@Override
	public void enterDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		onEnter(new Node("DebuggerStatement", arg.getText(), arg.getStart().getText()));
		this.inDebuggerStatement = true;
	}

	public void exitDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		onExit();
		this.inDebuggerStatement = false;
	}

	protected boolean inFunctionDeclaration = false;

	@Override
	public void enterFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		onEnter(new Node("FunctionDeclaration", arg.getText(), arg.getStart().getText()));
		this.inFunctionDeclaration = true;
	}

	public void exitFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		onExit();
		this.inFunctionDeclaration = false;
	}

	protected boolean inFormalParameterList = false;

	@Override
	public void enterFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		onEnter(new Node("FormalParameterList", arg.getText(), arg.getStart().getText()));
		this.inFormalParameterList = true;
	}

	public void exitFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		onExit();
		this.inFormalParameterList = false;
	}

	protected boolean inFunctionBody = false;

	@Override
	public void enterFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		onEnter(new Node("FunctionBody", arg.getText(), arg.getStart().getText()));
		this.inFunctionBody = true;
	}

	public void exitFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		onExit();
		this.inFunctionBody = false;
	}

	protected boolean inArrayLiteral = false;

	@Override
	public void enterArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		onEnter(new Node("ArrayLiteral", arg.getText(), arg.getStart().getText()));
		this.inArrayLiteral = true;
	}

	public void exitArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		onExit();
		this.inArrayLiteral = false;
	}

	protected boolean inElementList = false;

	@Override
	public void enterElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		onEnter(new Node("ElementList", arg.getText(), arg.getStart().getText()));
		this.inElementList = true;
	}

	public void exitElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		onExit();
		this.inElementList = false;
	}

	protected boolean inElision = false;

	@Override
	public void enterElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		onEnter(new Node("Elision", arg.getText(), arg.getStart().getText()));
		this.inElision = true;
	}

	public void exitElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		onExit();
		this.inElision = false;
	}

	protected boolean inObjectLiteral = false;

	@Override
	public void enterObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		onEnter(new Node("ObjectLiteral", arg.getText(), arg.getStart().getText()));
		this.inObjectLiteral = true;
	}

	public void exitObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		onExit();
		this.inObjectLiteral = false;
	}

	protected boolean inPropertyNameAndValueList = false;

	@Override
	public void enterPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		onEnter(new Node("PropertyNameAndValueList", arg.getText(), arg.getStart().getText()));
		this.inPropertyNameAndValueList = true;
	}

	public void exitPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		onExit();
		this.inPropertyNameAndValueList = false;
	}

	protected boolean inPropertyExpressionAssignment = false;

	@Override
	public void enterPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		onEnter(new Node("PropertyExpressionAssignment", arg.getText(), arg.getStart().getText()));
		this.inPropertyExpressionAssignment = true;
	}

	public void exitPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		onExit();
		this.inPropertyExpressionAssignment = false;
	}

	protected boolean inPropertyGetter = false;

	@Override
	public void enterPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		onEnter(new Node("PropertyGetter", arg.getText(), arg.getStart().getText()));
		this.inPropertyGetter = true;
	}

	public void exitPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		onExit();
		this.inPropertyGetter = false;
	}

	protected boolean inAssignmentOperatorExpression = false;

	@Override
	public void enterAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		onEnter(new Node("AssignmentOperatorExpression", arg.getText(), arg.getStart().getText()));
		this.inAssignmentOperatorExpression = true;
	}

	public void exitAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		onExit();
		this.inAssignmentOperatorExpression = false;
	}

	protected boolean inPropertySetter = false;

	@Override
	public void enterPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		onEnter(new Node("PropertySetter", arg.getText(), arg.getStart().getText()));
		this.inPropertySetter = true;
	}

	public void exitPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		onExit();
		this.inPropertySetter = false;
	}

	protected boolean inPropertyName = false;

	@Override
	public void enterPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		onEnter(new Node("PropertyName", arg.getText(), arg.getStart().getText()));
		this.inPropertyName = true;
	}

	public void exitPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		onExit();
		this.inPropertyName = false;
	}

	protected boolean inPropertySetParameterList = false;

	@Override
	public void enterPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		onEnter(new Node("PropertySetParameterList", arg.getText(), arg.getStart().getText()));
		this.inPropertySetParameterList = true;
	}

	public void exitPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		onExit();
		this.inPropertySetParameterList = false;
	}

	protected boolean inArguments = false;

	@Override
	public void enterArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText()));
		this.inArguments = true;
	}

	public void exitArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		onExit();
		this.inArguments = false;
	}

	protected boolean inArgumentList = false;

	@Override
	public void enterArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		onEnter(new Node("ArgumentList", arg.getText(), arg.getStart().getText()));
		this.inArgumentList = true;
	}

	public void exitArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		onExit();
		this.inArgumentList = false;
	}

	protected boolean inExpressionSequence = false;

	@Override
	public void enterExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		onEnter(new Node("ExpressionSequence", arg.getText(), arg.getStart().getText()));
		this.inExpressionSequence = true;
	}

	public void exitExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		onExit();
		this.inExpressionSequence = false;
	}

	protected boolean inTernaryExpression = false;

	@Override
	public void enterTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		onEnter(new Node("TernaryExpression", arg.getText(), arg.getStart().getText()));
		this.inTernaryExpression = true;
	}

	public void exitTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		onExit();
		this.inTernaryExpression = false;
	}

	protected boolean inLogicalAndExpression = false;

	@Override
	public void enterLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		onEnter(new Node("LogicalAndExpression", arg.getText(), arg.getStart().getText()));
		this.inLogicalAndExpression = true;
	}

	public void exitLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		onExit();
		this.inLogicalAndExpression = false;
	}

	protected boolean inPreIncrementExpression = false;

	@Override
	public void enterPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		onEnter(new Node("PreIncrementExpression", arg.getText(), arg.getStart().getText()));
		this.inPreIncrementExpression = true;
	}

	public void exitPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		onExit();
		this.inPreIncrementExpression = false;
	}

	protected boolean inObjectLiteralExpression = false;

	@Override
	public void enterObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		onEnter(new Node("ObjectLiteralExpression", arg.getText(), arg.getStart().getText()));
		this.inObjectLiteralExpression = true;
	}

	public void exitObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		onExit();
		this.inObjectLiteralExpression = false;
	}

	protected boolean inInExpression = false;

	@Override
	public void enterInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		onEnter(new Node("InExpression", arg.getText(), arg.getStart().getText()));
		this.inInExpression = true;
	}

	public void exitInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		onExit();
		this.inInExpression = false;
	}

	protected boolean inLogicalOrExpression = false;

	@Override
	public void enterLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		onEnter(new Node("LogicalOrExpression", arg.getText(), arg.getStart().getText()));
		this.inLogicalOrExpression = true;
	}

	public void exitLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		onExit();
		this.inLogicalOrExpression = false;
	}

	protected boolean inNotExpression = false;

	@Override
	public void enterNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		onEnter(new Node("NotExpression", arg.getText(), arg.getStart().getText()));
		this.inNotExpression = true;
	}

	public void exitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		onExit();
		this.inNotExpression = false;
	}

	protected boolean inPreDecreaseExpression = false;

	@Override
	public void enterPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		onEnter(new Node("PreDecreaseExpression", arg.getText(), arg.getStart().getText()));
		this.inPreDecreaseExpression = true;
	}

	public void exitPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		onExit();
		this.inPreDecreaseExpression = false;
	}

	protected boolean inArgumentsExpression = false;

	@Override
	public void enterArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		onEnter(new Node("ArgumentsExpression", arg.getText(), arg.getStart().getText()));
		this.inArgumentsExpression = true;
	}

	public void exitArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		onExit();
		this.inArgumentsExpression = false;
	}

	protected boolean inThisExpression = false;

	@Override
	public void enterThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		onEnter(new Node("ThisExpression", arg.getText(), arg.getStart().getText()));
		this.inThisExpression = true;
	}

	public void exitThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		onExit();
		this.inThisExpression = false;
	}

	protected boolean inFunctionExpression = false;

	@Override
	public void enterFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		onEnter(new Node("FunctionExpression", arg.getText(), arg.getStart().getText()));
		this.inFunctionExpression = true;
	}

	public void exitFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		onExit();
		this.inFunctionExpression = false;
	}

	protected boolean inUnaryMinusExpression = false;

	@Override
	public void enterUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		onEnter(new Node("UnaryMinusExpression", arg.getText(), arg.getStart().getText()));
		this.inUnaryMinusExpression = true;
	}

	public void exitUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		onExit();
		this.inUnaryMinusExpression = false;
	}

	protected boolean inAssignmentExpression = false;

	@Override
	public void enterAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		onEnter(new Node("AssignmentExpression", arg.getText(), arg.getStart().getText()));
		this.inAssignmentExpression = true;
	}

	public void exitAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		onExit();
		this.inAssignmentExpression = false;
	}

	protected boolean inPostDecreaseExpression = false;

	@Override
	public void enterPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		onEnter(new Node("PostDecreaseExpression", arg.getText(), arg.getStart().getText()));
		this.inPostDecreaseExpression = true;
	}

	public void exitPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		onExit();
		this.inPostDecreaseExpression = false;
	}

	protected boolean inTypeofExpression = false;

	@Override
	public void enterTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		onEnter(new Node("TypeofExpression", arg.getText(), arg.getStart().getText()));
		this.inTypeofExpression = true;
	}

	public void exitTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		onExit();
		this.inTypeofExpression = false;
	}

	protected boolean inInstanceofExpression = false;

	@Override
	public void enterInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		onEnter(new Node("InstanceofExpression", arg.getText(), arg.getStart().getText()));
		this.inInstanceofExpression = true;
	}

	public void exitInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		onExit();
		this.inInstanceofExpression = false;
	}

	protected boolean inUnaryPlusExpression = false;

	@Override
	public void enterUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		onEnter(new Node("UnaryPlusExpression", arg.getText(), arg.getStart().getText()));
		this.inUnaryPlusExpression = true;
	}

	public void exitUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		onExit();
		this.inUnaryPlusExpression = false;
	}

	protected boolean inDeleteExpression = false;

	@Override
	public void enterDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		onEnter(new Node("DeleteExpression", arg.getText(), arg.getStart().getText()));
		this.inDeleteExpression = true;
	}

	public void exitDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		onExit();
		this.inDeleteExpression = false;
	}

	protected boolean inEqualityExpression = false;

	@Override
	public void enterEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		onEnter(new Node("EqualityExpression", arg.getText(), arg.getStart().getText()));
		this.inEqualityExpression = true;
	}

	public void exitEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		onExit();
		this.inEqualityExpression = false;
	}

	protected boolean inBitXOrExpression = false;

	@Override
	public void enterBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		onEnter(new Node("BitXOrExpression", arg.getText(), arg.getStart().getText()));
		this.inBitXOrExpression = true;
	}

	public void exitBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		onExit();
		this.inBitXOrExpression = false;
	}

	protected boolean inMultiplicativeExpression = false;

	@Override
	public void enterMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		onEnter(new Node("MultiplicativeExpression", arg.getText(), arg.getStart().getText()));
		this.inMultiplicativeExpression = true;
	}

	public void exitMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		onExit();
		this.inMultiplicativeExpression = false;
	}

	protected boolean inBitShiftExpression = false;

	@Override
	public void enterBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		onEnter(new Node("BitShiftExpression", arg.getText(), arg.getStart().getText()));
		this.inBitShiftExpression = true;
	}

	public void exitBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		onExit();
		this.inBitShiftExpression = false;
	}

	protected boolean inParenthesizedExpression = false;

	@Override
	public void enterParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		onEnter(new Node("ParenthesizedExpression", arg.getText(), arg.getStart().getText()));
		this.inParenthesizedExpression = true;
	}

	public void exitParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		onExit();
		this.inParenthesizedExpression = false;
	}

	protected boolean inAdditiveExpression = false;

	@Override
	public void enterAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		onEnter(new Node("AdditiveExpression", arg.getText(), arg.getStart().getText()));
		this.inAdditiveExpression = true;
	}

	public void exitAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		onExit();
		this.inAdditiveExpression = false;
	}

	protected boolean inRelationalExpression = false;

	@Override
	public void enterRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		onEnter(new Node("RelationalExpression", arg.getText(), arg.getStart().getText()));
		this.inRelationalExpression = true;
	}

	public void exitRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		onExit();
		this.inRelationalExpression = false;
	}

	protected boolean inPostIncrementExpression = false;

	@Override
	public void enterPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		onEnter(new Node("PostIncrementExpression", arg.getText(), arg.getStart().getText()));
		this.inPostIncrementExpression = true;
	}

	public void exitPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		onExit();
		this.inPostIncrementExpression = false;
	}

	protected boolean inBitNotExpression = false;

	@Override
	public void enterBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		onEnter(new Node("BitNotExpression", arg.getText(), arg.getStart().getText()));
		this.inBitNotExpression = true;
	}

	public void exitBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		onExit();
		this.inBitNotExpression = false;
	}

	protected boolean inNewExpression = false;

	@Override
	public void enterNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		onEnter(new Node("NewExpression", arg.getText(), arg.getStart().getText()));
		this.inNewExpression = true;
	}

	public void exitNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		onExit();
		this.inNewExpression = false;
	}

	protected boolean inLiteralExpression = false;

	@Override
	public void enterLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		onEnter(new Node("LiteralExpression", arg.getText(), arg.getStart().getText()));
		this.inLiteralExpression = true;
	}

	public void exitLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		onExit();
		this.inLiteralExpression = false;
	}

	protected boolean inArrayLiteralExpression = false;

	@Override
	public void enterArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		onEnter(new Node("ArrayLiteralExpression", arg.getText(), arg.getStart().getText()));
		this.inArrayLiteralExpression = true;
	}

	public void exitArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		onExit();
		this.inArrayLiteralExpression = false;
	}

	protected boolean inMemberDotExpression = false;

	@Override
	public void enterMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		onEnter(new Node("MemberDotExpression", arg.getText(), arg.getStart().getText()));
		this.inMemberDotExpression = true;
	}

	public void exitMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		onExit();
		this.inMemberDotExpression = false;
	}

	protected boolean inMemberIndexExpression = false;

	@Override
	public void enterMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		onEnter(new Node("MemberIndexExpression", arg.getText(), arg.getStart().getText()));
		this.inMemberIndexExpression = true;
	}

	public void exitMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		onExit();
		this.inMemberIndexExpression = false;
	}

	protected boolean inIdentifierExpression = false;

	@Override
	public void enterIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		onEnter(new Node("IdentifierExpression", arg.getText(), arg.getStart().getText()));
		this.inIdentifierExpression = true;
	}

	public void exitIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		onExit();
		this.inIdentifierExpression = false;
	}

	protected boolean inBitAndExpression = false;

	@Override
	public void enterBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		onEnter(new Node("BitAndExpression", arg.getText(), arg.getStart().getText()));
		this.inBitAndExpression = true;
	}

	public void exitBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		onExit();
		this.inBitAndExpression = false;
	}

	protected boolean inBitOrExpression = false;

	@Override
	public void enterBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		onEnter(new Node("BitOrExpression", arg.getText(), arg.getStart().getText()));
		this.inBitOrExpression = true;
	}

	public void exitBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		onExit();
		this.inBitOrExpression = false;
	}

	protected boolean inVoidExpression = false;

	@Override
	public void enterVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		onEnter(new Node("VoidExpression", arg.getText(), arg.getStart().getText()));
		this.inVoidExpression = true;
	}

	public void exitVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		onExit();
		this.inVoidExpression = false;
	}

	protected boolean inAssignmentOperator = false;

	@Override
	public void enterAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		onEnter(new Node("AssignmentOperator", arg.getText(), arg.getStart().getText()));
		this.inAssignmentOperator = true;
	}

	public void exitAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		onExit();
		this.inAssignmentOperator = false;
	}

	protected boolean inNumericLiteral = false;

	@Override
	public void enterNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		onEnter(new Node("NumericLiteral", arg.getText(), arg.getStart().getText()));
		this.inNumericLiteral = true;
	}

	public void exitNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		onExit();
		this.inNumericLiteral = false;
	}

	protected boolean inIdentifierName = false;

	@Override
	public void enterIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		onEnter(new Node("IdentifierName", arg.getText(), arg.getStart().getText()));
		this.inIdentifierName = true;
	}

	public void exitIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		onExit();
		this.inIdentifierName = false;
	}

	protected boolean inReservedWord = false;

	@Override
	public void enterReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		onEnter(new Node("ReservedWord", arg.getText(), arg.getStart().getText()));
		this.inReservedWord = true;
	}

	public void exitReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		onExit();
		this.inReservedWord = false;
	}

	protected boolean inKeyword = false;

	@Override
	public void enterKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		onEnter(new Node("Keyword", arg.getText(), arg.getStart().getText()));
		this.inKeyword = true;
	}

	public void exitKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		onExit();
		this.inKeyword = false;
	}

	protected boolean inFutureReservedWord = false;

	@Override
	public void enterFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		onEnter(new Node("FutureReservedWord", arg.getText(), arg.getStart().getText()));
		this.inFutureReservedWord = true;
	}

	public void exitFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		onExit();
		this.inFutureReservedWord = false;
	}

	protected boolean inGetter = false;

	@Override
	public void enterGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		onEnter(new Node("Getter", arg.getText(), arg.getStart().getText()));
		this.inGetter = true;
	}

	public void exitGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		onExit();
		this.inGetter = false;
	}

	protected boolean inSetter = false;

	@Override
	public void enterSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		onEnter(new Node("Setter", arg.getText(), arg.getStart().getText()));
		this.inSetter = true;
	}

	public void exitSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		onExit();
		this.inSetter = false;
	}

	protected boolean inEos = false;

	@Override
	public void enterEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		onEnter(new Node("Eos", arg.getText(), arg.getStart().getText()));
		this.inEos = true;
	}

	public void exitEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		onExit();
		this.inEos = false;
	}

	protected boolean inEof = false;

	@Override
	public void enterEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		onEnter(new Node("Eof", arg.getText(), arg.getStart().getText()));
		this.inEof = true;
	}

	public void exitEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		onExit();
		this.inEof = false;
	}

}