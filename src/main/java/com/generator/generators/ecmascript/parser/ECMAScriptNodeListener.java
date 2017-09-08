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

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		 //System.out.println("Block");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		 onExit();
	}

	@Override
	public void enterProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		 //System.out.println("Program");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Program", arg.getText(), arg.getStart().getText()));
	}

	public void exitProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		 onExit();
	}

	@Override
	public void enterSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		 //System.out.println("SourceElements");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SourceElements", arg.getText(), arg.getStart().getText()));
	}

	public void exitSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		 onExit();
	}

	@Override
	public void enterSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		 //System.out.println("SourceElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SourceElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		 onExit();
	}

	@Override
	public void enterStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		 //System.out.println("StatementList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("StatementList", arg.getText(), arg.getStart().getText()));
	}

	public void exitStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		 //System.out.println("VariableStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		 //System.out.println("VariableDeclarationList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableDeclarationList", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		 //System.out.println("VariableDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		 //System.out.println("Initialiser");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Initialiser", arg.getText(), arg.getStart().getText()));
	}

	public void exitInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		 onExit();
	}

	@Override
	public void enterEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		 //System.out.println("EmptyStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EmptyStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		 //System.out.println("ExpressionStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExpressionStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		 //System.out.println("IfStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IfStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		 //System.out.println("DoStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DoStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		 //System.out.println("WhileStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("WhileStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		 //System.out.println("ForStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ForStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		 //System.out.println("ForVarStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ForVarStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		 //System.out.println("ForInStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ForInStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		 //System.out.println("ForVarInStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ForVarInStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		 //System.out.println("ContinueStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ContinueStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		 //System.out.println("BreakStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BreakStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		 //System.out.println("ReturnStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ReturnStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		 //System.out.println("WithStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("WithStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		 //System.out.println("SwitchStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SwitchStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		 //System.out.println("CaseBlock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CaseBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		 //System.out.println("CaseClauses");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CaseClauses", arg.getText(), arg.getStart().getText()));
	}

	public void exitCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		 onExit();
	}

	@Override
	public void enterCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		 //System.out.println("CaseClause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CaseClause", arg.getText(), arg.getStart().getText()));
	}

	public void exitCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		 onExit();
	}

	@Override
	public void enterDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		 //System.out.println("DefaultClause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DefaultClause", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		 onExit();
	}

	@Override
	public void enterLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		 //System.out.println("LabelledStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LabelledStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		 //System.out.println("ThrowStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ThrowStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		 //System.out.println("TryStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TryStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		 //System.out.println("CatchProduction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CatchProduction", arg.getText(), arg.getStart().getText()));
	}

	public void exitCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		 onExit();
	}

	@Override
	public void enterFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		 //System.out.println("FinallyProduction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FinallyProduction", arg.getText(), arg.getStart().getText()));
	}

	public void exitFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		 onExit();
	}

	@Override
	public void enterDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		 //System.out.println("DebuggerStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DebuggerStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		 //System.out.println("FunctionDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FunctionDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		 //System.out.println("FormalParameterList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FormalParameterList", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		 //System.out.println("FunctionBody");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FunctionBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		 //System.out.println("ArrayLiteral");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArrayLiteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		 //System.out.println("ElementList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ElementList", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		 onExit();
	}

	@Override
	public void enterElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		 //System.out.println("Elision");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Elision", arg.getText(), arg.getStart().getText()));
	}

	public void exitElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		 onExit();
	}

	@Override
	public void enterObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		 //System.out.println("ObjectLiteral");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ObjectLiteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		 //System.out.println("PropertyNameAndValueList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertyNameAndValueList", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		 //System.out.println("PropertyExpressionAssignment");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertyExpressionAssignment", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		 //System.out.println("PropertyGetter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertyGetter", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		 onExit();
	}

	@Override
	public void enterAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		 //System.out.println("AssignmentOperatorExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AssignmentOperatorExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		 //System.out.println("PropertySetter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertySetter", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		 //System.out.println("PropertyName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertyName", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		 //System.out.println("PropertySetParameterList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertySetParameterList", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		 onExit();
	}

	@Override
	public void enterArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		 //System.out.println("Arguments");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText()));
	}

	public void exitArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		 onExit();
	}

	@Override
	public void enterArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		 //System.out.println("ArgumentList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArgumentList", arg.getText(), arg.getStart().getText()));
	}

	public void exitArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		 onExit();
	}

	@Override
	public void enterExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		 //System.out.println("ExpressionSequence");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExpressionSequence", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		 onExit();
	}

	@Override
	public void enterTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		 //System.out.println("TernaryExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TernaryExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		 //System.out.println("LogicalAndExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LogicalAndExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		 //System.out.println("PreIncrementExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PreIncrementExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		 //System.out.println("ObjectLiteralExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ObjectLiteralExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		 //System.out.println("InExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		 //System.out.println("LogicalOrExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LogicalOrExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		 //System.out.println("NotExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NotExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		 //System.out.println("PreDecreaseExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PreDecreaseExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		 //System.out.println("ArgumentsExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArgumentsExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		 //System.out.println("ThisExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ThisExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		 //System.out.println("FunctionExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FunctionExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		 //System.out.println("UnaryMinusExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UnaryMinusExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		 //System.out.println("AssignmentExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AssignmentExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		 //System.out.println("PostDecreaseExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PostDecreaseExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		 //System.out.println("TypeofExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeofExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		 //System.out.println("InstanceofExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InstanceofExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		 //System.out.println("UnaryPlusExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("UnaryPlusExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		 //System.out.println("DeleteExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DeleteExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		 //System.out.println("EqualityExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EqualityExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		 //System.out.println("BitXOrExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BitXOrExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		 //System.out.println("MultiplicativeExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MultiplicativeExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		 //System.out.println("BitShiftExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BitShiftExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		 //System.out.println("ParenthesizedExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ParenthesizedExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		 //System.out.println("AdditiveExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AdditiveExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		 //System.out.println("RelationalExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RelationalExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		 //System.out.println("PostIncrementExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PostIncrementExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		 //System.out.println("BitNotExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BitNotExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		 //System.out.println("NewExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NewExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		 //System.out.println("LiteralExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LiteralExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		 //System.out.println("ArrayLiteralExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArrayLiteralExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		 //System.out.println("MemberDotExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MemberDotExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		 //System.out.println("MemberIndexExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MemberIndexExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		 //System.out.println("IdentifierExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IdentifierExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		 //System.out.println("BitAndExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BitAndExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		 //System.out.println("BitOrExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BitOrExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		 //System.out.println("VoidExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VoidExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		 //System.out.println("AssignmentOperator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AssignmentOperator", arg.getText(), arg.getStart().getText()));
	}

	public void exitAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		 onExit();
	}

	@Override
	public void enterNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		 //System.out.println("NumericLiteral");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NumericLiteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		 //System.out.println("IdentifierName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IdentifierName", arg.getText(), arg.getStart().getText()));
	}

	public void exitIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		 onExit();
	}

	@Override
	public void enterReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		 //System.out.println("ReservedWord");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ReservedWord", arg.getText(), arg.getStart().getText()));
	}

	public void exitReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		 onExit();
	}

	@Override
	public void enterKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		 //System.out.println("Keyword");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Keyword", arg.getText(), arg.getStart().getText()));
	}

	public void exitKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		 onExit();
	}

	@Override
	public void enterFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		 //System.out.println("FutureReservedWord");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FutureReservedWord", arg.getText(), arg.getStart().getText()));
	}

	public void exitFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		 onExit();
	}

	@Override
	public void enterGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		 //System.out.println("Getter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Getter", arg.getText(), arg.getStart().getText()));
	}

	public void exitGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		 onExit();
	}

	@Override
	public void enterSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		 //System.out.println("Setter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Setter", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		 onExit();
	}

	@Override
	public void enterEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		 //System.out.println("Eos");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Eos", arg.getText(), arg.getStart().getText()));
	}

	public void exitEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		 onExit();
	}

	@Override
	public void enterEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		 //System.out.println("Eof");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Eof", arg.getText(), arg.getStart().getText()));
	}

	public void exitEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		 onExit();
	}

	@Override
	public void enterStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		 //System.out.println("Statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		 onExit();
	}

	@Override
	public void enterLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		 //System.out.println("Literal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		 onExit();
	}

}