package com.generator.generators.sparql.parser;

import org.neo4j.graphdb.*;

public abstract class SparqlDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "DefaultGraphClause")) visitDefaultGraphClause(node);
		else if(hasLabel(node, "NamedGraphClause")) visitNamedGraphClause(node);
		else if(hasLabel(node, "SourceSelector")) visitSourceSelector(node);
		else if(hasLabel(node, "WhereClause")) visitWhereClause(node);
		else if(hasLabel(node, "SolutionModifier")) visitSolutionModifier(node);
		else if(hasLabel(node, "LimitOffsetClauses")) visitLimitOffsetClauses(node);
		else if(hasLabel(node, "OrderClause")) visitOrderClause(node);
		else if(hasLabel(node, "OrderCondition")) visitOrderCondition(node);
		else if(hasLabel(node, "LimitClause")) visitLimitClause(node);
		else if(hasLabel(node, "OffsetClause")) visitOffsetClause(node);
		else if(hasLabel(node, "GroupGraphPattern")) visitGroupGraphPattern(node);
		else if(hasLabel(node, "TriplesBlock")) visitTriplesBlock(node);
		else if(hasLabel(node, "GraphPatternNotTriples")) visitGraphPatternNotTriples(node);
		else if(hasLabel(node, "OptionalGraphPattern")) visitOptionalGraphPattern(node);
		else if(hasLabel(node, "GraphGraphPattern")) visitGraphGraphPattern(node);
		else if(hasLabel(node, "GroupOrUnionGraphPattern")) visitGroupOrUnionGraphPattern(node);
		else if(hasLabel(node, "Filter")) visitFilter(node);
		else if(hasLabel(node, "Constraint")) visitConstraint(node);
		else if(hasLabel(node, "FunctionCall")) visitFunctionCall(node);
		else if(hasLabel(node, "ArgList")) visitArgList(node);
		else if(hasLabel(node, "ConstructTemplate")) visitConstructTemplate(node);
		else if(hasLabel(node, "ConstructTriples")) visitConstructTriples(node);
		else if(hasLabel(node, "TriplesSameSubject")) visitTriplesSameSubject(node);
		else if(hasLabel(node, "PropertyListNotEmpty")) visitPropertyListNotEmpty(node);
		else if(hasLabel(node, "PropertyList")) visitPropertyList(node);
		else if(hasLabel(node, "ObjectList")) visitObjectList(node);
		else if(hasLabel(node, "Object")) visitObject(node);
		else if(hasLabel(node, "Verb")) visitVerb(node);
		else if(hasLabel(node, "TriplesNode")) visitTriplesNode(node);
		else if(hasLabel(node, "BlankNodePropertyList")) visitBlankNodePropertyList(node);
		else if(hasLabel(node, "Collection")) visitCollection(node);
		else if(hasLabel(node, "GraphNode")) visitGraphNode(node);
		else if(hasLabel(node, "VarOrTerm")) visitVarOrTerm(node);
		else if(hasLabel(node, "VarOrIRIref")) visitVarOrIRIref(node);
		else if(hasLabel(node, "GraphTerm")) visitGraphTerm(node);
		else if(hasLabel(node, "ConditionalOrExpression")) visitConditionalOrExpression(node);
		else if(hasLabel(node, "ConditionalAndExpression")) visitConditionalAndExpression(node);
		else if(hasLabel(node, "ValueLogical")) visitValueLogical(node);
		else if(hasLabel(node, "NumericExpression")) visitNumericExpression(node);
		else if(hasLabel(node, "UnaryExpression")) visitUnaryExpression(node);
		else if(hasLabel(node, "PrimaryExpression")) visitPrimaryExpression(node);
		else if(hasLabel(node, "BrackettedExpression")) visitBrackettedExpression(node);
		else if(hasLabel(node, "BuiltInCall")) visitBuiltInCall(node);
		else if(hasLabel(node, "RegexExpression")) visitRegexExpression(node);
		else if(hasLabel(node, "IriRefOrFunction")) visitIriRefOrFunction(node);
		else if(hasLabel(node, "RdfLiteral")) visitRdfLiteral(node);
		else if(hasLabel(node, "NumericLiteralUnsigned")) visitNumericLiteralUnsigned(node);
		else if(hasLabel(node, "NumericLiteralPositive")) visitNumericLiteralPositive(node);
		else if(hasLabel(node, "NumericLiteralNegative")) visitNumericLiteralNegative(node);
		else if(hasLabel(node, "IriRef")) visitIriRef(node);
		else if(hasLabel(node, "PrefixedName")) visitPrefixedName(node);
		else if(hasLabel(node, "BlankNode")) visitBlankNode(node);
		else if(hasLabel(node, "Prologue")) visitPrologue(node);
		else if(hasLabel(node, "BaseDecl")) visitBaseDecl(node);
		else if(hasLabel(node, "PrefixDecl")) visitPrefixDecl(node);
		else if(hasLabel(node, "SelectQuery")) visitSelectQuery(node);
		else if(hasLabel(node, "ConstructQuery")) visitConstructQuery(node);
		else if(hasLabel(node, "DescribeQuery")) visitDescribeQuery(node);
		else if(hasLabel(node, "AskQuery")) visitAskQuery(node);
		else if(hasLabel(node, "DatasetClause")) visitDatasetClause(node);
		else if(hasLabel(node, "String")) visitString(node);
		else if(hasLabel(node, "Expression")) visitExpression(node);
		else if(hasLabel(node, "Var")) visitVar(node);
		else if(hasLabel(node, "Query")) visitQuery(node);
		else if(hasLabel(node, "BooleanLiteral")) visitBooleanLiteral(node);
		else if(hasLabel(node, "MultiplicativeExpression")) visitMultiplicativeExpression(node);
		else if(hasLabel(node, "AdditiveExpression")) visitAdditiveExpression(node);
		else if(hasLabel(node, "RelationalExpression")) visitRelationalExpression(node);
		else if(hasLabel(node, "NumericLiteral")) visitNumericLiteral(node);
   }

	public void visitDefaultGraphClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamedGraphClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSourceSelector(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWhereClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSolutionModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLimitOffsetClauses(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOrderClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOrderCondition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLimitClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOffsetClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGroupGraphPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTriplesBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGraphPatternNotTriples(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOptionalGraphPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGraphGraphPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGroupOrUnionGraphPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFilter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstraint(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArgList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstructTemplate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstructTriples(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTriplesSameSubject(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyListNotEmpty(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPropertyList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitObjectList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitObject(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVerb(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTriplesNode(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlankNodePropertyList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCollection(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGraphNode(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVarOrTerm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVarOrIRIref(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGraphTerm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConditionalOrExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConditionalAndExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitValueLogical(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumericExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrimaryExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBrackettedExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBuiltInCall(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRegexExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIriRefOrFunction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRdfLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumericLiteralUnsigned(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumericLiteralPositive(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumericLiteralNegative(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIriRef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrefixedName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlankNode(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrologue(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBaseDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrefixDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelectQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstructQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDescribeQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAskQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDatasetClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitString(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVar(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBooleanLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMultiplicativeExpression(Node node) {
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

	public void visitNumericLiteral(Node node) {
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