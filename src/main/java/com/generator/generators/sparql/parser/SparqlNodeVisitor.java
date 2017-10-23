package com.generator.generators.sparql.parser;

public class SparqlNodeVisitor extends SparqlBaseVisitor<SparqlNodeVisitor.Node> {

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

	public SparqlNodeVisitor() {
		this(false);
	}

	public SparqlNodeVisitor(boolean debug) {
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
	public Node visitBaseDecl(com.generator.generators.sparql.parser.SparqlParser.BaseDeclContext arg) {
		final Node node = new Node("BaseDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.sparql.parser.SparqlParser.QueryContext arg) {
		final Node node = new Node("Query", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrologue(com.generator.generators.sparql.parser.SparqlParser.PrologueContext arg) {
		final Node node = new Node("Prologue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixDecl(com.generator.generators.sparql.parser.SparqlParser.PrefixDeclContext arg) {
		final Node node = new Node("PrefixDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectQuery(com.generator.generators.sparql.parser.SparqlParser.SelectQueryContext arg) {
		final Node node = new Node("SelectQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructQuery(com.generator.generators.sparql.parser.SparqlParser.ConstructQueryContext arg) {
		final Node node = new Node("ConstructQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDescribeQuery(com.generator.generators.sparql.parser.SparqlParser.DescribeQueryContext arg) {
		final Node node = new Node("DescribeQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAskQuery(com.generator.generators.sparql.parser.SparqlParser.AskQueryContext arg) {
		final Node node = new Node("AskQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDatasetClause(com.generator.generators.sparql.parser.SparqlParser.DatasetClauseContext arg) {
		final Node node = new Node("DatasetClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultGraphClause(com.generator.generators.sparql.parser.SparqlParser.DefaultGraphClauseContext arg) {
		final Node node = new Node("DefaultGraphClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamedGraphClause(com.generator.generators.sparql.parser.SparqlParser.NamedGraphClauseContext arg) {
		final Node node = new Node("NamedGraphClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceSelector(com.generator.generators.sparql.parser.SparqlParser.SourceSelectorContext arg) {
		final Node node = new Node("SourceSelector", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhereClause(com.generator.generators.sparql.parser.SparqlParser.WhereClauseContext arg) {
		final Node node = new Node("WhereClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSolutionModifier(com.generator.generators.sparql.parser.SparqlParser.SolutionModifierContext arg) {
		final Node node = new Node("SolutionModifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimitOffsetClauses(com.generator.generators.sparql.parser.SparqlParser.LimitOffsetClausesContext arg) {
		final Node node = new Node("LimitOffsetClauses", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrderClause(com.generator.generators.sparql.parser.SparqlParser.OrderClauseContext arg) {
		final Node node = new Node("OrderClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrderCondition(com.generator.generators.sparql.parser.SparqlParser.OrderConditionContext arg) {
		final Node node = new Node("OrderCondition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimitClause(com.generator.generators.sparql.parser.SparqlParser.LimitClauseContext arg) {
		final Node node = new Node("LimitClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOffsetClause(com.generator.generators.sparql.parser.SparqlParser.OffsetClauseContext arg) {
		final Node node = new Node("OffsetClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupGraphPatternContext arg) {
		final Node node = new Node("GroupGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriplesBlock(com.generator.generators.sparql.parser.SparqlParser.TriplesBlockContext arg) {
		final Node node = new Node("TriplesBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphPatternNotTriples(com.generator.generators.sparql.parser.SparqlParser.GraphPatternNotTriplesContext arg) {
		final Node node = new Node("GraphPatternNotTriples", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOptionalGraphPattern(com.generator.generators.sparql.parser.SparqlParser.OptionalGraphPatternContext arg) {
		final Node node = new Node("OptionalGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GraphGraphPatternContext arg) {
		final Node node = new Node("GraphGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupOrUnionGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupOrUnionGraphPatternContext arg) {
		final Node node = new Node("GroupOrUnionGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilter(com.generator.generators.sparql.parser.SparqlParser.FilterContext arg) {
		final Node node = new Node("Filter", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstraint(com.generator.generators.sparql.parser.SparqlParser.ConstraintContext arg) {
		final Node node = new Node("Constraint", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionCall(com.generator.generators.sparql.parser.SparqlParser.FunctionCallContext arg) {
		final Node node = new Node("FunctionCall", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgList(com.generator.generators.sparql.parser.SparqlParser.ArgListContext arg) {
		final Node node = new Node("ArgList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructTemplate(com.generator.generators.sparql.parser.SparqlParser.ConstructTemplateContext arg) {
		final Node node = new Node("ConstructTemplate", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructTriples(com.generator.generators.sparql.parser.SparqlParser.ConstructTriplesContext arg) {
		final Node node = new Node("ConstructTriples", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriplesSameSubject(com.generator.generators.sparql.parser.SparqlParser.TriplesSameSubjectContext arg) {
		final Node node = new Node("TriplesSameSubject", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyListNotEmpty(com.generator.generators.sparql.parser.SparqlParser.PropertyListNotEmptyContext arg) {
		final Node node = new Node("PropertyListNotEmpty", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyList(com.generator.generators.sparql.parser.SparqlParser.PropertyListContext arg) {
		final Node node = new Node("PropertyList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectList(com.generator.generators.sparql.parser.SparqlParser.ObjectListContext arg) {
		final Node node = new Node("ObjectList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObject(com.generator.generators.sparql.parser.SparqlParser.ObjectContext arg) {
		final Node node = new Node("Object", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVerb(com.generator.generators.sparql.parser.SparqlParser.VerbContext arg) {
		final Node node = new Node("Verb", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriplesNode(com.generator.generators.sparql.parser.SparqlParser.TriplesNodeContext arg) {
		final Node node = new Node("TriplesNode", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlankNodePropertyList(com.generator.generators.sparql.parser.SparqlParser.BlankNodePropertyListContext arg) {
		final Node node = new Node("BlankNodePropertyList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollection(com.generator.generators.sparql.parser.SparqlParser.CollectionContext arg) {
		final Node node = new Node("Collection", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphNode(com.generator.generators.sparql.parser.SparqlParser.GraphNodeContext arg) {
		final Node node = new Node("GraphNode", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrTerm(com.generator.generators.sparql.parser.SparqlParser.VarOrTermContext arg) {
		final Node node = new Node("VarOrTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrIRIref(com.generator.generators.sparql.parser.SparqlParser.VarOrIRIrefContext arg) {
		final Node node = new Node("VarOrIRIref", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.sparql.parser.SparqlParser.VarContext arg) {
		final Node node = new Node("Var", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGraphTerm(com.generator.generators.sparql.parser.SparqlParser.GraphTermContext arg) {
		final Node node = new Node("GraphTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.sparql.parser.SparqlParser.ExpressionContext arg) {
		final Node node = new Node("Expression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditionalOrExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalOrExpressionContext arg) {
		final Node node = new Node("ConditionalOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditionalAndExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalAndExpressionContext arg) {
		final Node node = new Node("ConditionalAndExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValueLogical(com.generator.generators.sparql.parser.SparqlParser.ValueLogicalContext arg) {
		final Node node = new Node("ValueLogical", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationalExpression(com.generator.generators.sparql.parser.SparqlParser.RelationalExpressionContext arg) {
		final Node node = new Node("RelationalExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericExpression(com.generator.generators.sparql.parser.SparqlParser.NumericExpressionContext arg) {
		final Node node = new Node("NumericExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAdditiveExpression(com.generator.generators.sparql.parser.SparqlParser.AdditiveExpressionContext arg) {
		final Node node = new Node("AdditiveExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplicativeExpression(com.generator.generators.sparql.parser.SparqlParser.MultiplicativeExpressionContext arg) {
		final Node node = new Node("MultiplicativeExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryExpression(com.generator.generators.sparql.parser.SparqlParser.UnaryExpressionContext arg) {
		final Node node = new Node("UnaryExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimaryExpression(com.generator.generators.sparql.parser.SparqlParser.PrimaryExpressionContext arg) {
		final Node node = new Node("PrimaryExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBrackettedExpression(com.generator.generators.sparql.parser.SparqlParser.BrackettedExpressionContext arg) {
		final Node node = new Node("BrackettedExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBuiltInCall(com.generator.generators.sparql.parser.SparqlParser.BuiltInCallContext arg) {
		final Node node = new Node("BuiltInCall", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegexExpression(com.generator.generators.sparql.parser.SparqlParser.RegexExpressionContext arg) {
		final Node node = new Node("RegexExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIriRefOrFunction(com.generator.generators.sparql.parser.SparqlParser.IriRefOrFunctionContext arg) {
		final Node node = new Node("IriRefOrFunction", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRdfLiteral(com.generator.generators.sparql.parser.SparqlParser.RdfLiteralContext arg) {
		final Node node = new Node("RdfLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteral(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralContext arg) {
		final Node node = new Node("NumericLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteralUnsigned(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralUnsignedContext arg) {
		final Node node = new Node("NumericLiteralUnsigned", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteralPositive(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralPositiveContext arg) {
		final Node node = new Node("NumericLiteralPositive", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumericLiteralNegative(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralNegativeContext arg) {
		final Node node = new Node("NumericLiteralNegative", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanLiteral(com.generator.generators.sparql.parser.SparqlParser.BooleanLiteralContext arg) {
		final Node node = new Node("BooleanLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.sparql.parser.SparqlParser.StringContext arg) {
		final Node node = new Node("String", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIriRef(com.generator.generators.sparql.parser.SparqlParser.IriRefContext arg) {
		final Node node = new Node("IriRef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixedName(com.generator.generators.sparql.parser.SparqlParser.PrefixedNameContext arg) {
		final Node node = new Node("PrefixedName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlankNode(com.generator.generators.sparql.parser.SparqlParser.BlankNodeContext arg) {
		final Node node = new Node("BlankNode", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}