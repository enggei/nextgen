package com.generator.generators.ecmascript.parser;

import org.neo4j.graphdb.*;

public abstract class ECMAScriptDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Block")) visitBlock(node);
		else if(hasLabel(node, "Literal")) visitLiteral(node);
		else if(hasLabel(node, "Keyword")) visitKeyword(node);
		else if(hasLabel(node, "Statement")) visitStatement(node);
		else if(hasLabel(node, "NotExpression")) visitNotExpression(node);
		else if(hasLabel(node, "ParenthesizedExpression")) visitParenthesizedExpression(node);
		else if(hasLabel(node, "ReservedWord")) visitReservedWord(node);
		else if(hasLabel(node, "VariableStatement")) visitVariableStatement(node);
		else if(hasLabel(node, "VariableDeclarationList")) visitVariableDeclarationList(node);
		else if(hasLabel(node, "VariableDeclaration")) visitVariableDeclaration(node);
		else if(hasLabel(node, "Initialiser")) visitInitialiser(node);
		else if(hasLabel(node, "EmptyStatement")) visitEmptyStatement(node);
		else if(hasLabel(node, "ExpressionStatement")) visitExpressionStatement(node);
		else if(hasLabel(node, "IfStatement")) visitIfStatement(node);
		else if(hasLabel(node, "DoStatement")) visitDoStatement(node);
		else if(hasLabel(node, "WhileStatement")) visitWhileStatement(node);
		else if(hasLabel(node, "Program")) visitProgram(node);
		else if(hasLabel(node, "SourceElements")) visitSourceElements(node);
		else if(hasLabel(node, "SourceElement")) visitSourceElement(node);
		else if(hasLabel(node, "StatementList")) visitStatementList(node);
		else if(hasLabel(node, "ForStatement")) visitForStatement(node);
		else if(hasLabel(node, "ForVarStatement")) visitForVarStatement(node);
		else if(hasLabel(node, "ForInStatement")) visitForInStatement(node);
		else if(hasLabel(node, "ForVarInStatement")) visitForVarInStatement(node);
		else if(hasLabel(node, "ContinueStatement")) visitContinueStatement(node);
		else if(hasLabel(node, "BreakStatement")) visitBreakStatement(node);
		else if(hasLabel(node, "ReturnStatement")) visitReturnStatement(node);
		else if(hasLabel(node, "WithStatement")) visitWithStatement(node);
		else if(hasLabel(node, "SwitchStatement")) visitSwitchStatement(node);
		else if(hasLabel(node, "CaseBlock")) visitCaseBlock(node);
		else if(hasLabel(node, "CaseClauses")) visitCaseClauses(node);
		else if(hasLabel(node, "CaseClause")) visitCaseClause(node);
		else if(hasLabel(node, "DefaultClause")) visitDefaultClause(node);
		else if(hasLabel(node, "LabelledStatement")) visitLabelledStatement(node);
		else if(hasLabel(node, "ThrowStatement")) visitThrowStatement(node);
		else if(hasLabel(node, "TryStatement")) visitTryStatement(node);
		else if(hasLabel(node, "CatchProduction")) visitCatchProduction(node);
		else if(hasLabel(node, "FinallyProduction")) visitFinallyProduction(node);
		else if(hasLabel(node, "DebuggerStatement")) visitDebuggerStatement(node);
		else if(hasLabel(node, "FunctionDeclaration")) visitFunctionDeclaration(node);
		else if(hasLabel(node, "FormalParameterList")) visitFormalParameterList(node);
		else if(hasLabel(node, "FunctionBody")) visitFunctionBody(node);
		else if(hasLabel(node, "ArrayLiteral")) visitArrayLiteral(node);
		else if(hasLabel(node, "ElementList")) visitElementList(node);
		else if(hasLabel(node, "Elision")) visitElision(node);
		else if(hasLabel(node, "ObjectLiteral")) visitObjectLiteral(node);
		else if(hasLabel(node, "PropertyNameAndValueList")) visitPropertyNameAndValueList(node);
		else if(hasLabel(node, "PropertyExpressionAssignment")) visitPropertyExpressionAssignment(node);
		else if(hasLabel(node, "PropertyGetter")) visitPropertyGetter(node);
		else if(hasLabel(node, "Arguments")) visitArguments(node);
		else if(hasLabel(node, "PropertySetter")) visitPropertySetter(node);
		else if(hasLabel(node, "PropertyName")) visitPropertyName(node);
		else if(hasLabel(node, "PropertySetParameterList")) visitPropertySetParameterList(node);
		else if(hasLabel(node, "ArgumentList")) visitArgumentList(node);
		else if(hasLabel(node, "ExpressionSequence")) visitExpressionSequence(node);
		else if(hasLabel(node, "TernaryExpression")) visitTernaryExpression(node);
		else if(hasLabel(node, "LogicalAndExpression")) visitLogicalAndExpression(node);
		else if(hasLabel(node, "PreIncrementExpression")) visitPreIncrementExpression(node);
		else if(hasLabel(node, "ObjectLiteralExpression")) visitObjectLiteralExpression(node);
		else if(hasLabel(node, "InExpression")) visitInExpression(node);
		else if(hasLabel(node, "LogicalOrExpression")) visitLogicalOrExpression(node);
		else if(hasLabel(node, "PreDecreaseExpression")) visitPreDecreaseExpression(node);
		else if(hasLabel(node, "ArgumentsExpression")) visitArgumentsExpression(node);
		else if(hasLabel(node, "ThisExpression")) visitThisExpression(node);
		else if(hasLabel(node, "FunctionExpression")) visitFunctionExpression(node);
		else if(hasLabel(node, "UnaryMinusExpression")) visitUnaryMinusExpression(node);
		else if(hasLabel(node, "AssignmentExpression")) visitAssignmentExpression(node);
		else if(hasLabel(node, "PostDecreaseExpression")) visitPostDecreaseExpression(node);
		else if(hasLabel(node, "TypeofExpression")) visitTypeofExpression(node);
		else if(hasLabel(node, "InstanceofExpression")) visitInstanceofExpression(node);
		else if(hasLabel(node, "UnaryPlusExpression")) visitUnaryPlusExpression(node);
		else if(hasLabel(node, "DeleteExpression")) visitDeleteExpression(node);
		else if(hasLabel(node, "EqualityExpression")) visitEqualityExpression(node);
		else if(hasLabel(node, "BitXOrExpression")) visitBitXOrExpression(node);
		else if(hasLabel(node, "MultiplicativeExpression")) visitMultiplicativeExpression(node);
		else if(hasLabel(node, "BitShiftExpression")) visitBitShiftExpression(node);
		else if(hasLabel(node, "AdditiveExpression")) visitAdditiveExpression(node);
		else if(hasLabel(node, "RelationalExpression")) visitRelationalExpression(node);
		else if(hasLabel(node, "PostIncrementExpression")) visitPostIncrementExpression(node);
		else if(hasLabel(node, "BitNotExpression")) visitBitNotExpression(node);
		else if(hasLabel(node, "NewExpression")) visitNewExpression(node);
		else if(hasLabel(node, "LiteralExpression")) visitLiteralExpression(node);
		else if(hasLabel(node, "ArrayLiteralExpression")) visitArrayLiteralExpression(node);
		else if(hasLabel(node, "MemberDotExpression")) visitMemberDotExpression(node);
		else if(hasLabel(node, "MemberIndexExpression")) visitMemberIndexExpression(node);
		else if(hasLabel(node, "IdentifierExpression")) visitIdentifierExpression(node);
		else if(hasLabel(node, "BitAndExpression")) visitBitAndExpression(node);
		else if(hasLabel(node, "BitOrExpression")) visitBitOrExpression(node);
		else if(hasLabel(node, "AssignmentOperatorExpression")) visitAssignmentOperatorExpression(node);
		else if(hasLabel(node, "VoidExpression")) visitVoidExpression(node);
		else if(hasLabel(node, "AssignmentOperator")) visitAssignmentOperator(node);
		else if(hasLabel(node, "NumericLiteral")) visitNumericLiteral(node);
		else if(hasLabel(node, "IdentifierName")) visitIdentifierName(node);
		else if(hasLabel(node, "FutureReservedWord")) visitFutureReservedWord(node);
		else if(hasLabel(node, "Getter")) visitGetter(node);
		else if(hasLabel(node, "Setter")) visitSetter(node);
		else if(hasLabel(node, "Eos")) visitEos(node);
		else if(hasLabel(node, "Eof")) visitEof(node);
   }

	public void visitBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKeyword(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNotExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParenthesizedExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReservedWord(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableDeclarationList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInitialiser(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEmptyStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIfStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDoStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWhileStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitProgram(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSourceElements(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSourceElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatementList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForVarStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForInStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForVarInStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitContinueStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBreakStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReturnStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWithStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSwitchStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseClauses(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDefaultClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLabelledStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitThrowStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTryStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCatchProduction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFinallyProduction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDebuggerStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFormalParameterList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArrayLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElision(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitObjectLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyNameAndValueList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyExpressionAssignment(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyGetter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArguments(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertySetter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertySetParameterList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArgumentList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionSequence(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTernaryExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLogicalAndExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPreIncrementExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitObjectLiteralExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLogicalOrExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPreDecreaseExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArgumentsExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitThisExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryMinusExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssignmentExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPostDecreaseExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeofExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInstanceofExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryPlusExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeleteExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEqualityExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBitXOrExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMultiplicativeExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBitShiftExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAdditiveExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelationalExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPostIncrementExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBitNotExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNewExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteralExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArrayLiteralExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMemberDotExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMemberIndexExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdentifierExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBitAndExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBitOrExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssignmentOperatorExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVoidExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssignmentOperator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumericLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdentifierName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFutureReservedWord(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGetter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEos(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEof(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	private boolean hasLabel(Node node, String label) {
   	for (org.neo4j.graphdb.Label lbl : node.getLabels())
      	if (lbl.name().equals(label)) return true;
      return false;
   }

	protected Iterable<Relationship> outgoing(Node node, RelationshipType type) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type));
   }

	protected Iterable<Relationship> outgoing(Node node) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING));
   }

	protected static Iterable<Relationship> sort(Iterable<Relationship> relationships) {
		final java.util.Set<Relationship> relations = new java.util.TreeSet<>(java.util.Comparator.comparingLong(Relationship::getId));
		for (Relationship relationship : relationships)
			relations.add(relationship);
		return relations;
	}

	protected Node other(Node node, Relationship relationship) {
     	return relationship == null ? null : relationship.getOtherNode(node);
   }
}