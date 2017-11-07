package com.generator.generators.cypher.parser;

import org.neo4j.graphdb.*;

public abstract class CypherDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Atom")) visitAtom(node);
		else if(hasLabel(node, "Set")) visitSet(node);
		else if(hasLabel(node, "Expression")) visitExpression(node);
		else if(hasLabel(node, "Statement")) visitStatement(node);
		else if(hasLabel(node, "Literal")) visitLiteral(node);
		else if(hasLabel(node, "Cypher")) visitCypher(node);
		else if(hasLabel(node, "Query")) visitQuery(node);
		else if(hasLabel(node, "RegularQuery")) visitRegularQuery(node);
		else if(hasLabel(node, "Union")) visitUnion(node);
		else if(hasLabel(node, "SingleQuery")) visitSingleQuery(node);
		else if(hasLabel(node, "SinglePartQuery")) visitSinglePartQuery(node);
		else if(hasLabel(node, "ReadOnlyEnd")) visitReadOnlyEnd(node);
		else if(hasLabel(node, "ReadUpdateEnd")) visitReadUpdateEnd(node);
		else if(hasLabel(node, "UpdatingEnd")) visitUpdatingEnd(node);
		else if(hasLabel(node, "MultiPartQuery")) visitMultiPartQuery(node);
		else if(hasLabel(node, "ReadPart")) visitReadPart(node);
		else if(hasLabel(node, "UpdatingPart")) visitUpdatingPart(node);
		else if(hasLabel(node, "UpdatingStartClause")) visitUpdatingStartClause(node);
		else if(hasLabel(node, "UpdatingClause")) visitUpdatingClause(node);
		else if(hasLabel(node, "ReadingClause")) visitReadingClause(node);
		else if(hasLabel(node, "Cyper_match")) visitCyper_match(node);
		else if(hasLabel(node, "Unwind")) visitUnwind(node);
		else if(hasLabel(node, "Merge")) visitMerge(node);
		else if(hasLabel(node, "MergeAction")) visitMergeAction(node);
		else if(hasLabel(node, "Create")) visitCreate(node);
		else if(hasLabel(node, "SetItem")) visitSetItem(node);
		else if(hasLabel(node, "Delete")) visitDelete(node);
		else if(hasLabel(node, "Remove")) visitRemove(node);
		else if(hasLabel(node, "RemoveItem")) visitRemoveItem(node);
		else if(hasLabel(node, "InQueryCall")) visitInQueryCall(node);
		else if(hasLabel(node, "StandaloneCall")) visitStandaloneCall(node);
		else if(hasLabel(node, "YieldItems")) visitYieldItems(node);
		else if(hasLabel(node, "YieldItem")) visitYieldItem(node);
		else if(hasLabel(node, "With")) visitWith(node);
		else if(hasLabel(node, "Cypher_return")) visitCypher_return(node);
		else if(hasLabel(node, "ReturnBody")) visitReturnBody(node);
		else if(hasLabel(node, "ReturnItems")) visitReturnItems(node);
		else if(hasLabel(node, "ReturnItem")) visitReturnItem(node);
		else if(hasLabel(node, "Order")) visitOrder(node);
		else if(hasLabel(node, "Skip")) visitSkip(node);
		else if(hasLabel(node, "Limit")) visitLimit(node);
		else if(hasLabel(node, "SortItem")) visitSortItem(node);
		else if(hasLabel(node, "Where")) visitWhere(node);
		else if(hasLabel(node, "Pattern")) visitPattern(node);
		else if(hasLabel(node, "PatternPart")) visitPatternPart(node);
		else if(hasLabel(node, "AnonymousPatternPart")) visitAnonymousPatternPart(node);
		else if(hasLabel(node, "PatternElement")) visitPatternElement(node);
		else if(hasLabel(node, "NodePattern")) visitNodePattern(node);
		else if(hasLabel(node, "PatternElementChain")) visitPatternElementChain(node);
		else if(hasLabel(node, "RelationshipPattern")) visitRelationshipPattern(node);
		else if(hasLabel(node, "RelationshipDetail")) visitRelationshipDetail(node);
		else if(hasLabel(node, "Properties")) visitProperties(node);
		else if(hasLabel(node, "RelationshipTypes")) visitRelationshipTypes(node);
		else if(hasLabel(node, "NodeLabels")) visitNodeLabels(node);
		else if(hasLabel(node, "NodeLabel")) visitNodeLabel(node);
		else if(hasLabel(node, "RangeLiteral")) visitRangeLiteral(node);
		else if(hasLabel(node, "LabelName")) visitLabelName(node);
		else if(hasLabel(node, "RelTypeName")) visitRelTypeName(node);
		else if(hasLabel(node, "OrExpression")) visitOrExpression(node);
		else if(hasLabel(node, "XorExpression")) visitXorExpression(node);
		else if(hasLabel(node, "AndExpression")) visitAndExpression(node);
		else if(hasLabel(node, "NotExpression")) visitNotExpression(node);
		else if(hasLabel(node, "ComparisonExpression")) visitComparisonExpression(node);
		else if(hasLabel(node, "AddOrSubtractExpression")) visitAddOrSubtractExpression(node);
		else if(hasLabel(node, "MultiplyDivideModuloExpression")) visitMultiplyDivideModuloExpression(node);
		else if(hasLabel(node, "PowerOfExpression")) visitPowerOfExpression(node);
		else if(hasLabel(node, "UnaryAddOrSubtractExpression")) visitUnaryAddOrSubtractExpression(node);
		else if(hasLabel(node, "StringListNullOperatorExpression")) visitStringListNullOperatorExpression(node);
		else if(hasLabel(node, "PropertyOrLabelsExpression")) visitPropertyOrLabelsExpression(node);
		else if(hasLabel(node, "BooleanLiteral")) visitBooleanLiteral(node);
		else if(hasLabel(node, "ListLiteral")) visitListLiteral(node);
		else if(hasLabel(node, "PartialComparisonExpression")) visitPartialComparisonExpression(node);
		else if(hasLabel(node, "ParenthesizedExpression")) visitParenthesizedExpression(node);
		else if(hasLabel(node, "RelationshipsPattern")) visitRelationshipsPattern(node);
		else if(hasLabel(node, "FilterExpression")) visitFilterExpression(node);
		else if(hasLabel(node, "IdInColl")) visitIdInColl(node);
		else if(hasLabel(node, "FunctionInvocation")) visitFunctionInvocation(node);
		else if(hasLabel(node, "FunctionName")) visitFunctionName(node);
		else if(hasLabel(node, "ExplicitProcedureInvocation")) visitExplicitProcedureInvocation(node);
		else if(hasLabel(node, "ImplicitProcedureInvocation")) visitImplicitProcedureInvocation(node);
		else if(hasLabel(node, "ProcedureResultField")) visitProcedureResultField(node);
		else if(hasLabel(node, "ProcedureName")) visitProcedureName(node);
		else if(hasLabel(node, "Namespace")) visitNamespace(node);
		else if(hasLabel(node, "ListComprehension")) visitListComprehension(node);
		else if(hasLabel(node, "PatternComprehension")) visitPatternComprehension(node);
		else if(hasLabel(node, "PropertyLookup")) visitPropertyLookup(node);
		else if(hasLabel(node, "CaseExpression")) visitCaseExpression(node);
		else if(hasLabel(node, "CaseAlternatives")) visitCaseAlternatives(node);
		else if(hasLabel(node, "Variable")) visitVariable(node);
		else if(hasLabel(node, "NumberLiteral")) visitNumberLiteral(node);
		else if(hasLabel(node, "MapLiteral")) visitMapLiteral(node);
		else if(hasLabel(node, "Parameter")) visitParameter(node);
		else if(hasLabel(node, "PropertyExpression")) visitPropertyExpression(node);
		else if(hasLabel(node, "PropertyKeyName")) visitPropertyKeyName(node);
		else if(hasLabel(node, "IntegerLiteral")) visitIntegerLiteral(node);
		else if(hasLabel(node, "DoubleLiteral")) visitDoubleLiteral(node);
		else if(hasLabel(node, "SchemaName")) visitSchemaName(node);
		else if(hasLabel(node, "ReservedWord")) visitReservedWord(node);
		else if(hasLabel(node, "SymbolicName")) visitSymbolicName(node);
		else if(hasLabel(node, "LeftArrowHead")) visitLeftArrowHead(node);
		else if(hasLabel(node, "RightArrowHead")) visitRightArrowHead(node);
		else if(hasLabel(node, "Dash")) visitDash(node);
   }

	public void visitAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSet(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCypher(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRegularQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnion(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSingleQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSinglePartQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReadOnlyEnd(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReadUpdateEnd(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUpdatingEnd(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMultiPartQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReadPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUpdatingPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUpdatingStartClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUpdatingClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReadingClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCyper_match(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnwind(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMerge(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMergeAction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDelete(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRemove(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRemoveItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInQueryCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStandaloneCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitYieldItems(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitYieldItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWith(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCypher_return(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReturnBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReturnItems(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReturnItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOrder(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSkip(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLimit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSortItem(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWhere(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPatternPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnonymousPatternPart(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPatternElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNodePattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPatternElementChain(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelationshipPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelationshipDetail(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitProperties(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelationshipTypes(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNodeLabels(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNodeLabel(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRangeLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLabelName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelTypeName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOrExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXorExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAndExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNotExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitComparisonExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAddOrSubtractExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMultiplyDivideModuloExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPowerOfExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryAddOrSubtractExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStringListNullOperatorExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyOrLabelsExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBooleanLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitListLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPartialComparisonExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParenthesizedExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelationshipsPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFilterExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdInColl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionInvocation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExplicitProcedureInvocation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImplicitProcedureInvocation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitProcedureResultField(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitProcedureName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamespace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitListComprehension(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPatternComprehension(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyLookup(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseAlternatives(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariable(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumberLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMapLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyKeyName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIntegerLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDoubleLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSchemaName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReservedWord(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSymbolicName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLeftArrowHead(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRightArrowHead(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDash(Node node) {
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