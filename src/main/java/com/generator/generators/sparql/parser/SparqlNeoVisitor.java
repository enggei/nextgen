package com.generator.generators.sparql.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class SparqlNeoVisitor extends SparqlBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SparqlNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public SparqlNeoVisitor(com.generator.neo.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitString(com.generator.generators.sparql.parser.SparqlParser.StringContext arg) {
		log.info("String");
		final Node node = model.newNode(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.sparql.parser.SparqlParser.ExpressionContext arg) {
		log.info("Expression");
		final Node node = model.newNode(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.sparql.parser.SparqlParser.VarContext arg) {
		log.info("Var");
		final Node node = model.newNode(Label.label("Var"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.sparql.parser.SparqlParser.QueryContext arg) {
		log.info("Query");
		final Node node = model.newNode(Label.label("Query"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanLiteral(com.generator.generators.sparql.parser.SparqlParser.BooleanLiteralContext arg) {
		log.info("BooleanLiteral");
		final Node node = model.newNode(Label.label("BooleanLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplicativeExpression(com.generator.generators.sparql.parser.SparqlParser.MultiplicativeExpressionContext arg) {
		log.info("MultiplicativeExpression");
		final Node node = model.newNode(Label.label("MultiplicativeExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAdditiveExpression(com.generator.generators.sparql.parser.SparqlParser.AdditiveExpressionContext arg) {
		log.info("AdditiveExpression");
		final Node node = model.newNode(Label.label("AdditiveExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationalExpression(com.generator.generators.sparql.parser.SparqlParser.RelationalExpressionContext arg) {
		log.info("RelationalExpression");
		final Node node = model.newNode(Label.label("RelationalExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteral(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralContext arg) {
		log.info("NumericLiteral");
		final Node node = model.newNode(Label.label("NumericLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrologue(com.generator.generators.sparql.parser.SparqlParser.PrologueContext arg) {
		log.info("Prologue");
		final Node node = model.newNode(Label.label("Prologue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBaseDecl(com.generator.generators.sparql.parser.SparqlParser.BaseDeclContext arg) {
		log.info("BaseDecl");
		final Node node = model.newNode(Label.label("BaseDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixDecl(com.generator.generators.sparql.parser.SparqlParser.PrefixDeclContext arg) {
		log.info("PrefixDecl");
		final Node node = model.newNode(Label.label("PrefixDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectQuery(com.generator.generators.sparql.parser.SparqlParser.SelectQueryContext arg) {
		log.info("SelectQuery");
		final Node node = model.newNode(Label.label("SelectQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructQuery(com.generator.generators.sparql.parser.SparqlParser.ConstructQueryContext arg) {
		log.info("ConstructQuery");
		final Node node = model.newNode(Label.label("ConstructQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDescribeQuery(com.generator.generators.sparql.parser.SparqlParser.DescribeQueryContext arg) {
		log.info("DescribeQuery");
		final Node node = model.newNode(Label.label("DescribeQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAskQuery(com.generator.generators.sparql.parser.SparqlParser.AskQueryContext arg) {
		log.info("AskQuery");
		final Node node = model.newNode(Label.label("AskQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDatasetClause(com.generator.generators.sparql.parser.SparqlParser.DatasetClauseContext arg) {
		log.info("DatasetClause");
		final Node node = model.newNode(Label.label("DatasetClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultGraphClause(com.generator.generators.sparql.parser.SparqlParser.DefaultGraphClauseContext arg) {
		log.info("DefaultGraphClause");
		final Node node = model.newNode(Label.label("DefaultGraphClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamedGraphClause(com.generator.generators.sparql.parser.SparqlParser.NamedGraphClauseContext arg) {
		log.info("NamedGraphClause");
		final Node node = model.newNode(Label.label("NamedGraphClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceSelector(com.generator.generators.sparql.parser.SparqlParser.SourceSelectorContext arg) {
		log.info("SourceSelector");
		final Node node = model.newNode(Label.label("SourceSelector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhereClause(com.generator.generators.sparql.parser.SparqlParser.WhereClauseContext arg) {
		log.info("WhereClause");
		final Node node = model.newNode(Label.label("WhereClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSolutionModifier(com.generator.generators.sparql.parser.SparqlParser.SolutionModifierContext arg) {
		log.info("SolutionModifier");
		final Node node = model.newNode(Label.label("SolutionModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimitOffsetClauses(com.generator.generators.sparql.parser.SparqlParser.LimitOffsetClausesContext arg) {
		log.info("LimitOffsetClauses");
		final Node node = model.newNode(Label.label("LimitOffsetClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrderClause(com.generator.generators.sparql.parser.SparqlParser.OrderClauseContext arg) {
		log.info("OrderClause");
		final Node node = model.newNode(Label.label("OrderClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrderCondition(com.generator.generators.sparql.parser.SparqlParser.OrderConditionContext arg) {
		log.info("OrderCondition");
		final Node node = model.newNode(Label.label("OrderCondition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimitClause(com.generator.generators.sparql.parser.SparqlParser.LimitClauseContext arg) {
		log.info("LimitClause");
		final Node node = model.newNode(Label.label("LimitClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOffsetClause(com.generator.generators.sparql.parser.SparqlParser.OffsetClauseContext arg) {
		log.info("OffsetClause");
		final Node node = model.newNode(Label.label("OffsetClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupGraphPatternContext arg) {
		log.info("GroupGraphPattern");
		final Node node = model.newNode(Label.label("GroupGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriplesBlock(com.generator.generators.sparql.parser.SparqlParser.TriplesBlockContext arg) {
		log.info("TriplesBlock");
		final Node node = model.newNode(Label.label("TriplesBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphPatternNotTriples(com.generator.generators.sparql.parser.SparqlParser.GraphPatternNotTriplesContext arg) {
		log.info("GraphPatternNotTriples");
		final Node node = model.newNode(Label.label("GraphPatternNotTriples"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOptionalGraphPattern(com.generator.generators.sparql.parser.SparqlParser.OptionalGraphPatternContext arg) {
		log.info("OptionalGraphPattern");
		final Node node = model.newNode(Label.label("OptionalGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GraphGraphPatternContext arg) {
		log.info("GraphGraphPattern");
		final Node node = model.newNode(Label.label("GraphGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupOrUnionGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupOrUnionGraphPatternContext arg) {
		log.info("GroupOrUnionGraphPattern");
		final Node node = model.newNode(Label.label("GroupOrUnionGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilter(com.generator.generators.sparql.parser.SparqlParser.FilterContext arg) {
		log.info("Filter");
		final Node node = model.newNode(Label.label("Filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstraint(com.generator.generators.sparql.parser.SparqlParser.ConstraintContext arg) {
		log.info("Constraint");
		final Node node = model.newNode(Label.label("Constraint"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionCall(com.generator.generators.sparql.parser.SparqlParser.FunctionCallContext arg) {
		log.info("FunctionCall");
		final Node node = model.newNode(Label.label("FunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgList(com.generator.generators.sparql.parser.SparqlParser.ArgListContext arg) {
		log.info("ArgList");
		final Node node = model.newNode(Label.label("ArgList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructTemplate(com.generator.generators.sparql.parser.SparqlParser.ConstructTemplateContext arg) {
		log.info("ConstructTemplate");
		final Node node = model.newNode(Label.label("ConstructTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructTriples(com.generator.generators.sparql.parser.SparqlParser.ConstructTriplesContext arg) {
		log.info("ConstructTriples");
		final Node node = model.newNode(Label.label("ConstructTriples"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriplesSameSubject(com.generator.generators.sparql.parser.SparqlParser.TriplesSameSubjectContext arg) {
		log.info("TriplesSameSubject");
		final Node node = model.newNode(Label.label("TriplesSameSubject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyListNotEmpty(com.generator.generators.sparql.parser.SparqlParser.PropertyListNotEmptyContext arg) {
		log.info("PropertyListNotEmpty");
		final Node node = model.newNode(Label.label("PropertyListNotEmpty"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyList(com.generator.generators.sparql.parser.SparqlParser.PropertyListContext arg) {
		log.info("PropertyList");
		final Node node = model.newNode(Label.label("PropertyList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectList(com.generator.generators.sparql.parser.SparqlParser.ObjectListContext arg) {
		log.info("ObjectList");
		final Node node = model.newNode(Label.label("ObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObject(com.generator.generators.sparql.parser.SparqlParser.ObjectContext arg) {
		log.info("Object");
		final Node node = model.newNode(Label.label("Object"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVerb(com.generator.generators.sparql.parser.SparqlParser.VerbContext arg) {
		log.info("Verb");
		final Node node = model.newNode(Label.label("Verb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriplesNode(com.generator.generators.sparql.parser.SparqlParser.TriplesNodeContext arg) {
		log.info("TriplesNode");
		final Node node = model.newNode(Label.label("TriplesNode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlankNodePropertyList(com.generator.generators.sparql.parser.SparqlParser.BlankNodePropertyListContext arg) {
		log.info("BlankNodePropertyList");
		final Node node = model.newNode(Label.label("BlankNodePropertyList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollection(com.generator.generators.sparql.parser.SparqlParser.CollectionContext arg) {
		log.info("Collection");
		final Node node = model.newNode(Label.label("Collection"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphNode(com.generator.generators.sparql.parser.SparqlParser.GraphNodeContext arg) {
		log.info("GraphNode");
		final Node node = model.newNode(Label.label("GraphNode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrTerm(com.generator.generators.sparql.parser.SparqlParser.VarOrTermContext arg) {
		log.info("VarOrTerm");
		final Node node = model.newNode(Label.label("VarOrTerm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrIRIref(com.generator.generators.sparql.parser.SparqlParser.VarOrIRIrefContext arg) {
		log.info("VarOrIRIref");
		final Node node = model.newNode(Label.label("VarOrIRIref"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphTerm(com.generator.generators.sparql.parser.SparqlParser.GraphTermContext arg) {
		log.info("GraphTerm");
		final Node node = model.newNode(Label.label("GraphTerm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditionalOrExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalOrExpressionContext arg) {
		log.info("ConditionalOrExpression");
		final Node node = model.newNode(Label.label("ConditionalOrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditionalAndExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalAndExpressionContext arg) {
		log.info("ConditionalAndExpression");
		final Node node = model.newNode(Label.label("ConditionalAndExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValueLogical(com.generator.generators.sparql.parser.SparqlParser.ValueLogicalContext arg) {
		log.info("ValueLogical");
		final Node node = model.newNode(Label.label("ValueLogical"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericExpression(com.generator.generators.sparql.parser.SparqlParser.NumericExpressionContext arg) {
		log.info("NumericExpression");
		final Node node = model.newNode(Label.label("NumericExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryExpression(com.generator.generators.sparql.parser.SparqlParser.UnaryExpressionContext arg) {
		log.info("UnaryExpression");
		final Node node = model.newNode(Label.label("UnaryExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimaryExpression(com.generator.generators.sparql.parser.SparqlParser.PrimaryExpressionContext arg) {
		log.info("PrimaryExpression");
		final Node node = model.newNode(Label.label("PrimaryExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBrackettedExpression(com.generator.generators.sparql.parser.SparqlParser.BrackettedExpressionContext arg) {
		log.info("BrackettedExpression");
		final Node node = model.newNode(Label.label("BrackettedExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBuiltInCall(com.generator.generators.sparql.parser.SparqlParser.BuiltInCallContext arg) {
		log.info("BuiltInCall");
		final Node node = model.newNode(Label.label("BuiltInCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegexExpression(com.generator.generators.sparql.parser.SparqlParser.RegexExpressionContext arg) {
		log.info("RegexExpression");
		final Node node = model.newNode(Label.label("RegexExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIriRefOrFunction(com.generator.generators.sparql.parser.SparqlParser.IriRefOrFunctionContext arg) {
		log.info("IriRefOrFunction");
		final Node node = model.newNode(Label.label("IriRefOrFunction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRdfLiteral(com.generator.generators.sparql.parser.SparqlParser.RdfLiteralContext arg) {
		log.info("RdfLiteral");
		final Node node = model.newNode(Label.label("RdfLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteralUnsigned(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralUnsignedContext arg) {
		log.info("NumericLiteralUnsigned");
		final Node node = model.newNode(Label.label("NumericLiteralUnsigned"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteralPositive(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralPositiveContext arg) {
		log.info("NumericLiteralPositive");
		final Node node = model.newNode(Label.label("NumericLiteralPositive"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteralNegative(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralNegativeContext arg) {
		log.info("NumericLiteralNegative");
		final Node node = model.newNode(Label.label("NumericLiteralNegative"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIriRef(com.generator.generators.sparql.parser.SparqlParser.IriRefContext arg) {
		log.info("IriRef");
		final Node node = model.newNode(Label.label("IriRef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixedName(com.generator.generators.sparql.parser.SparqlParser.PrefixedNameContext arg) {
		log.info("PrefixedName");
		final Node node = model.newNode(Label.label("PrefixedName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlankNode(com.generator.generators.sparql.parser.SparqlParser.BlankNodeContext arg) {
		log.info("BlankNode");
		final Node node = model.newNode(Label.label("BlankNode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}