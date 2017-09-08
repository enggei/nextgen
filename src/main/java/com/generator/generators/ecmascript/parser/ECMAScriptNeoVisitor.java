package com.generator.generators.ecmascript.parser;

import com.generator.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ECMAScriptNeoVisitor extends ECMAScriptBaseVisitor<Node> {

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	private final NeoModel model;

	public ECMAScriptNeoVisitor(NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.BlockContext arg) {
		System.out.println("Block");
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyword(com.generator.generators.ecmascript.parser.ECMAScriptParser.KeywordContext arg) {
		System.out.println("Keyword");
		final Node node = model.findOrCreate(Label.label("Keyword"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProgram(com.generator.generators.ecmascript.parser.ECMAScriptParser.ProgramContext arg) {
		System.out.println("Program");
		final Node node = model.findOrCreate(Label.label("Program"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceElements(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementsContext arg) {
		System.out.println("SourceElements");
		final Node node = model.findOrCreate(Label.label("SourceElements"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceElement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SourceElementContext arg) {
		System.out.println("SourceElement");
		final Node node = model.findOrCreate(Label.label("SourceElement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementListContext arg) {
		System.out.println("StatementList");
		final Node node = model.findOrCreate(Label.label("StatementList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableStatementContext arg) {
		System.out.println("VariableStatement");
		final Node node = model.findOrCreate(Label.label("VariableStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclarationList(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationListContext arg) {
		System.out.println("VariableDeclarationList");
		final Node node = model.findOrCreate(Label.label("VariableDeclarationList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.VariableDeclarationContext arg) {
		System.out.println("VariableDeclaration");
		final Node node = model.findOrCreate(Label.label("VariableDeclaration"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitialiser(com.generator.generators.ecmascript.parser.ECMAScriptParser.InitialiserContext arg) {
		System.out.println("Initialiser");
		final Node node = model.findOrCreate(Label.label("Initialiser"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmptyStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.EmptyStatementContext arg) {
		System.out.println("EmptyStatement");
		final Node node = model.findOrCreate(Label.label("EmptyStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionStatementContext arg) {
		System.out.println("ExpressionStatement");
		final Node node = model.findOrCreate(Label.label("ExpressionStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.IfStatementContext arg) {
		System.out.println("IfStatement");
		final Node node = model.findOrCreate(Label.label("IfStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDoStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DoStatementContext arg) {
		System.out.println("DoStatement");
		final Node node = model.findOrCreate(Label.label("DoStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhileStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WhileStatementContext arg) {
		System.out.println("WhileStatement");
		final Node node = model.findOrCreate(Label.label("WhileStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForStatementContext arg) {
		System.out.println("ForStatement");
		final Node node = model.findOrCreate(Label.label("ForStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForVarStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarStatementContext arg) {
		System.out.println("ForVarStatement");
		final Node node = model.findOrCreate(Label.label("ForVarStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForInStatementContext arg) {
		System.out.println("ForInStatement");
		final Node node = model.findOrCreate(Label.label("ForInStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForVarInStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ForVarInStatementContext arg) {
		System.out.println("ForVarInStatement");
		final Node node = model.findOrCreate(Label.label("ForVarInStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinueStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ContinueStatementContext arg) {
		System.out.println("ContinueStatement");
		final Node node = model.findOrCreate(Label.label("ContinueStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreakStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.BreakStatementContext arg) {
		System.out.println("BreakStatement");
		final Node node = model.findOrCreate(Label.label("BreakStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReturnStatementContext arg) {
		System.out.println("ReturnStatement");
		final Node node = model.findOrCreate(Label.label("ReturnStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWithStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.WithStatementContext arg) {
		System.out.println("WithStatement");
		final Node node = model.findOrCreate(Label.label("WithStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.SwitchStatementContext arg) {
		System.out.println("SwitchStatement");
		final Node node = model.findOrCreate(Label.label("SwitchStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseBlock(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseBlockContext arg) {
		System.out.println("CaseBlock");
		final Node node = model.findOrCreate(Label.label("CaseBlock"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClauses(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClausesContext arg) {
		System.out.println("CaseClauses");
		final Node node = model.findOrCreate(Label.label("CaseClauses"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.CaseClauseContext arg) {
		System.out.println("CaseClause");
		final Node node = model.findOrCreate(Label.label("CaseClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultClause(com.generator.generators.ecmascript.parser.ECMAScriptParser.DefaultClauseContext arg) {
		System.out.println("DefaultClause");
		final Node node = model.findOrCreate(Label.label("DefaultClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabelledStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.LabelledStatementContext arg) {
		System.out.println("LabelledStatement");
		final Node node = model.findOrCreate(Label.label("LabelledStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThrowStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThrowStatementContext arg) {
		System.out.println("ThrowStatement");
		final Node node = model.findOrCreate(Label.label("ThrowStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTryStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.TryStatementContext arg) {
		System.out.println("TryStatement");
		final Node node = model.findOrCreate(Label.label("TryStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCatchProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.CatchProductionContext arg) {
		System.out.println("CatchProduction");
		final Node node = model.findOrCreate(Label.label("CatchProduction"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFinallyProduction(com.generator.generators.ecmascript.parser.ECMAScriptParser.FinallyProductionContext arg) {
		System.out.println("FinallyProduction");
		final Node node = model.findOrCreate(Label.label("FinallyProduction"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDebuggerStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.DebuggerStatementContext arg) {
		System.out.println("DebuggerStatement");
		final Node node = model.findOrCreate(Label.label("DebuggerStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionDeclaration(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionDeclarationContext arg) {
		System.out.println("FunctionDeclaration");
		final Node node = model.findOrCreate(Label.label("FunctionDeclaration"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.FormalParameterListContext arg) {
		System.out.println("FormalParameterList");
		final Node node = model.findOrCreate(Label.label("FormalParameterList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionBody(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionBodyContext arg) {
		System.out.println("FunctionBody");
		final Node node = model.findOrCreate(Label.label("FunctionBody"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralContext arg) {
		System.out.println("ArrayLiteral");
		final Node node = model.findOrCreate(Label.label("ArrayLiteral"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElementListContext arg) {
		System.out.println("ElementList");
		final Node node = model.findOrCreate(Label.label("ElementList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElision(com.generator.generators.ecmascript.parser.ECMAScriptParser.ElisionContext arg) {
		System.out.println("Elision");
		final Node node = model.findOrCreate(Label.label("Elision"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralContext arg) {
		System.out.println("ObjectLiteral");
		final Node node = model.findOrCreate(Label.label("ObjectLiteral"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyNameAndValueList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameAndValueListContext arg) {
		System.out.println("PropertyNameAndValueList");
		final Node node = model.findOrCreate(Label.label("PropertyNameAndValueList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyExpressionAssignment(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyExpressionAssignmentContext arg) {
		System.out.println("PropertyExpressionAssignment");
		final Node node = model.findOrCreate(Label.label("PropertyExpressionAssignment"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyGetterContext arg) {
		System.out.println("PropertyGetter");
		final Node node = model.findOrCreate(Label.label("PropertyGetter"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertySetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetterContext arg) {
		System.out.println("PropertySetter");
		final Node node = model.findOrCreate(Label.label("PropertySetter"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyName(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertyNameContext arg) {
		System.out.println("PropertyName");
		final Node node = model.findOrCreate(Label.label("PropertyName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertySetParameterList(com.generator.generators.ecmascript.parser.ECMAScriptParser.PropertySetParameterListContext arg) {
		System.out.println("PropertySetParameterList");
		final Node node = model.findOrCreate(Label.label("PropertySetParameterList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsContext arg) {
		System.out.println("Arguments");
		final Node node = model.findOrCreate(Label.label("Arguments"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgumentList(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentListContext arg) {
		System.out.println("ArgumentList");
		final Node node = model.findOrCreate(Label.label("ArgumentList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionSequence(com.generator.generators.ecmascript.parser.ECMAScriptParser.ExpressionSequenceContext arg) {
		System.out.println("ExpressionSequence");
		final Node node = model.findOrCreate(Label.label("ExpressionSequence"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTernaryExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TernaryExpressionContext arg) {
		System.out.println("TernaryExpression");
		final Node node = model.findOrCreate(Label.label("TernaryExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalAndExpressionContext arg) {
		System.out.println("LogicalAndExpression");
		final Node node = model.findOrCreate(Label.label("LogicalAndExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPreIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreIncrementExpressionContext arg) {
		System.out.println("PreIncrementExpression");
		final Node node = model.findOrCreate(Label.label("PreIncrementExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ObjectLiteralExpressionContext arg) {
		System.out.println("ObjectLiteralExpression");
		final Node node = model.findOrCreate(Label.label("ObjectLiteralExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InExpressionContext arg) {
		System.out.println("InExpression");
		final Node node = model.findOrCreate(Label.label("InExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LogicalOrExpressionContext arg) {
		System.out.println("LogicalOrExpression");
		final Node node = model.findOrCreate(Label.label("LogicalOrExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NotExpressionContext arg) {
		System.out.println("NotExpression");
		final Node node = model.findOrCreate(Label.label("NotExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPreDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PreDecreaseExpressionContext arg) {
		System.out.println("PreDecreaseExpression");
		final Node node = model.findOrCreate(Label.label("PreDecreaseExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgumentsExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArgumentsExpressionContext arg) {
		System.out.println("ArgumentsExpression");
		final Node node = model.findOrCreate(Label.label("ArgumentsExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThisExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ThisExpressionContext arg) {
		System.out.println("ThisExpression");
		final Node node = model.findOrCreate(Label.label("ThisExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.FunctionExpressionContext arg) {
		System.out.println("FunctionExpression");
		final Node node = model.findOrCreate(Label.label("FunctionExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryMinusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryMinusExpressionContext arg) {
		System.out.println("UnaryMinusExpression");
		final Node node = model.findOrCreate(Label.label("UnaryMinusExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentExpressionContext arg) {
		System.out.println("AssignmentExpression");
		final Node node = model.findOrCreate(Label.label("AssignmentExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostDecreaseExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostDecreaseExpressionContext arg) {
		System.out.println("PostDecreaseExpression");
		final Node node = model.findOrCreate(Label.label("PostDecreaseExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.TypeofExpressionContext arg) {
		System.out.println("TypeofExpression");
		final Node node = model.findOrCreate(Label.label("TypeofExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInstanceofExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.InstanceofExpressionContext arg) {
		System.out.println("InstanceofExpression");
		final Node node = model.findOrCreate(Label.label("InstanceofExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryPlusExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.UnaryPlusExpressionContext arg) {
		System.out.println("UnaryPlusExpression");
		final Node node = model.findOrCreate(Label.label("UnaryPlusExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeleteExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.DeleteExpressionContext arg) {
		System.out.println("DeleteExpression");
		final Node node = model.findOrCreate(Label.label("DeleteExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEqualityExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.EqualityExpressionContext arg) {
		System.out.println("EqualityExpression");
		final Node node = model.findOrCreate(Label.label("EqualityExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitXOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitXOrExpressionContext arg) {
		System.out.println("BitXOrExpression");
		final Node node = model.findOrCreate(Label.label("BitXOrExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplicativeExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MultiplicativeExpressionContext arg) {
		System.out.println("MultiplicativeExpression");
		final Node node = model.findOrCreate(Label.label("MultiplicativeExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitShiftExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitShiftExpressionContext arg) {
		System.out.println("BitShiftExpression");
		final Node node = model.findOrCreate(Label.label("BitShiftExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenthesizedExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ParenthesizedExpressionContext arg) {
		System.out.println("ParenthesizedExpression");
		final Node node = model.findOrCreate(Label.label("ParenthesizedExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAdditiveExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AdditiveExpressionContext arg) {
		System.out.println("AdditiveExpression");
		final Node node = model.findOrCreate(Label.label("AdditiveExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationalExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.RelationalExpressionContext arg) {
		System.out.println("RelationalExpression");
		final Node node = model.findOrCreate(Label.label("RelationalExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostIncrementExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.PostIncrementExpressionContext arg) {
		System.out.println("PostIncrementExpression");
		final Node node = model.findOrCreate(Label.label("PostIncrementExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitNotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitNotExpressionContext arg) {
		System.out.println("BitNotExpression");
		final Node node = model.findOrCreate(Label.label("BitNotExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNewExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.NewExpressionContext arg) {
		System.out.println("NewExpression");
		final Node node = model.findOrCreate(Label.label("NewExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralExpressionContext arg) {
		System.out.println("LiteralExpression");
		final Node node = model.findOrCreate(Label.label("LiteralExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayLiteralExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.ArrayLiteralExpressionContext arg) {
		System.out.println("ArrayLiteralExpression");
		final Node node = model.findOrCreate(Label.label("ArrayLiteralExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberDotExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberDotExpressionContext arg) {
		System.out.println("MemberDotExpression");
		final Node node = model.findOrCreate(Label.label("MemberDotExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberIndexExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.MemberIndexExpressionContext arg) {
		System.out.println("MemberIndexExpression");
		final Node node = model.findOrCreate(Label.label("MemberIndexExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifierExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierExpressionContext arg) {
		System.out.println("IdentifierExpression");
		final Node node = model.findOrCreate(Label.label("IdentifierExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitAndExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitAndExpressionContext arg) {
		System.out.println("BitAndExpression");
		final Node node = model.findOrCreate(Label.label("BitAndExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBitOrExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.BitOrExpressionContext arg) {
		System.out.println("BitOrExpression");
		final Node node = model.findOrCreate(Label.label("BitOrExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentOperatorExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorExpressionContext arg) {
		System.out.println("AssignmentOperatorExpression");
		final Node node = model.findOrCreate(Label.label("AssignmentOperatorExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVoidExpression(com.generator.generators.ecmascript.parser.ECMAScriptParser.VoidExpressionContext arg) {
		System.out.println("VoidExpression");
		final Node node = model.findOrCreate(Label.label("VoidExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentOperator(com.generator.generators.ecmascript.parser.ECMAScriptParser.AssignmentOperatorContext arg) {
		System.out.println("AssignmentOperator");
		final Node node = model.findOrCreate(Label.label("AssignmentOperator"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.NumericLiteralContext arg) {
		System.out.println("NumericLiteral");
		final Node node = model.findOrCreate(Label.label("NumericLiteral"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifierName(com.generator.generators.ecmascript.parser.ECMAScriptParser.IdentifierNameContext arg) {
		System.out.println("IdentifierName");
		final Node node = model.findOrCreate(Label.label("IdentifierName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.ReservedWordContext arg) {
		System.out.println("ReservedWord");
		final Node node = model.findOrCreate(Label.label("ReservedWord"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFutureReservedWord(com.generator.generators.ecmascript.parser.ECMAScriptParser.FutureReservedWordContext arg) {
		System.out.println("FutureReservedWord");
		final Node node = model.findOrCreate(Label.label("FutureReservedWord"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.GetterContext arg) {
		System.out.println("Getter");
		final Node node = model.findOrCreate(Label.label("Getter"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetter(com.generator.generators.ecmascript.parser.ECMAScriptParser.SetterContext arg) {
		System.out.println("Setter");
		final Node node = model.findOrCreate(Label.label("Setter"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEos(com.generator.generators.ecmascript.parser.ECMAScriptParser.EosContext arg) {
		System.out.println("Eos");
		final Node node = model.findOrCreate(Label.label("Eos"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEof(com.generator.generators.ecmascript.parser.ECMAScriptParser.EofContext arg) {
		System.out.println("Eof");
		final Node node = model.findOrCreate(Label.label("Eof"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.ecmascript.parser.ECMAScriptParser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.ecmascript.parser.ECMAScriptParser.StatementContext arg) {
		System.out.println("Statement");
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}