package com.generator.generators.ecmascript.parser;

public class ECMAScriptNodeVisitor extends ECMAScriptBaseVisitor<ECMAScriptNodeVisitor.Node> {

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

	public ECMAScriptNodeVisitor() {
		this(false);
	}

	public ECMAScriptNodeVisitor(boolean debug) {
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
	public Node visitBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		final Node node = new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		final Node node = new Node("Statement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		final Node node = new Node("Keyword", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		final Node node = new Node("NotExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		final Node node = new Node("ParenthesizedExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		final Node node = new Node("ReservedWord", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		final Node node = new Node("SourceElements", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		final Node node = new Node("Program", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		final Node node = new Node("SourceElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		final Node node = new Node("StatementList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		final Node node = new Node("VariableStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		final Node node = new Node("VariableDeclarationList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		final Node node = new Node("VariableDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		final Node node = new Node("Initialiser", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		final Node node = new Node("EmptyStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		final Node node = new Node("ExpressionStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		final Node node = new Node("IfStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		final Node node = new Node("DoStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		final Node node = new Node("WhileStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		final Node node = new Node("ForStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		final Node node = new Node("ForVarStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		final Node node = new Node("ForInStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		final Node node = new Node("ForVarInStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		final Node node = new Node("ContinueStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		final Node node = new Node("BreakStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		final Node node = new Node("ReturnStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		final Node node = new Node("WithStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		final Node node = new Node("SwitchStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		final Node node = new Node("CaseBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		final Node node = new Node("CaseClauses", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		final Node node = new Node("CaseClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		final Node node = new Node("DefaultClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		final Node node = new Node("LabelledStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		final Node node = new Node("ThrowStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		final Node node = new Node("TryStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		final Node node = new Node("CatchProduction", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		final Node node = new Node("FinallyProduction", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		final Node node = new Node("DebuggerStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		final Node node = new Node("FunctionDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		final Node node = new Node("FormalParameterList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		final Node node = new Node("FunctionBody", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		final Node node = new Node("ArrayLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		final Node node = new Node("ElementList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		final Node node = new Node("Elision", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		final Node node = new Node("ObjectLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		final Node node = new Node("PropertyNameAndValueList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		final Node node = new Node("PropertyExpressionAssignment", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		final Node node = new Node("PropertyGetter", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		final Node node = new Node("PropertySetter", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		final Node node = new Node("PropertyName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		final Node node = new Node("PropertySetParameterList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		final Node node = new Node("Arguments", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		final Node node = new Node("ArgumentList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		final Node node = new Node("ExpressionSequence", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		final Node node = new Node("TernaryExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		final Node node = new Node("LogicalAndExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		final Node node = new Node("PreIncrementExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		final Node node = new Node("ObjectLiteralExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		final Node node = new Node("InExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		final Node node = new Node("LogicalOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		final Node node = new Node("PreDecreaseExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		final Node node = new Node("ArgumentsExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		final Node node = new Node("ThisExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		final Node node = new Node("FunctionExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		final Node node = new Node("UnaryMinusExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		final Node node = new Node("AssignmentExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		final Node node = new Node("PostDecreaseExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		final Node node = new Node("TypeofExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		final Node node = new Node("InstanceofExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		final Node node = new Node("UnaryPlusExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		final Node node = new Node("DeleteExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		final Node node = new Node("EqualityExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		final Node node = new Node("BitXOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		final Node node = new Node("MultiplicativeExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		final Node node = new Node("BitShiftExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		final Node node = new Node("AdditiveExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		final Node node = new Node("RelationalExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		final Node node = new Node("PostIncrementExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		final Node node = new Node("BitNotExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		final Node node = new Node("NewExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		final Node node = new Node("LiteralExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		final Node node = new Node("ArrayLiteralExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		final Node node = new Node("MemberDotExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		final Node node = new Node("MemberIndexExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		final Node node = new Node("IdentifierExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		final Node node = new Node("BitAndExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		final Node node = new Node("BitOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		final Node node = new Node("AssignmentOperatorExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		final Node node = new Node("VoidExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		final Node node = new Node("AssignmentOperator", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		final Node node = new Node("NumericLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		final Node node = new Node("IdentifierName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		final Node node = new Node("FutureReservedWord", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		final Node node = new Node("Getter", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		final Node node = new Node("Setter", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		final Node node = new Node("Eos", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		final Node node = new Node("Eof", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}