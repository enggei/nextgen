package com.generator.generators.cypher.parser;

public class CypherNodeVisitor extends CypherBaseVisitor<CypherNodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public CypherNodeVisitor() {
		this(false);
	}

	public CypherNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " '" + node.value + "'");
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

	@Override
	public Node visitAtom(com.generator.generators.cypher.parser.CypherParser.AtomContext arg) {
		final Node node = new Node("Atom", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameter(com.generator.generators.cypher.parser.CypherParser.ParameterContext arg) {
		final Node node = new Node("Parameter", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		final Node node = new Node("Expression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.cypher.parser.CypherParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet(com.generator.generators.cypher.parser.CypherParser.SetContext arg) {
		final Node node = new Node("Set", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.cypher.parser.CypherParser.StatementContext arg) {
		final Node node = new Node("Statement", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher(com.generator.generators.cypher.parser.CypherParser.CypherContext arg) {
		final Node node = new Node("Cypher", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.cypher.parser.CypherParser.QueryContext arg) {
		final Node node = new Node("Query", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		final Node node = new Node("RegularQuery", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion(com.generator.generators.cypher.parser.CypherParser.UnionContext arg) {
		final Node node = new Node("Union", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingleQuery(com.generator.generators.cypher.parser.CypherParser.SingleQueryContext arg) {
		final Node node = new Node("SingleQuery", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSinglePartQuery(com.generator.generators.cypher.parser.CypherParser.SinglePartQueryContext arg) {
		final Node node = new Node("SinglePartQuery", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadOnlyEnd(com.generator.generators.cypher.parser.CypherParser.ReadOnlyEndContext arg) {
		final Node node = new Node("ReadOnlyEnd", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadUpdateEnd(com.generator.generators.cypher.parser.CypherParser.ReadUpdateEndContext arg) {
		final Node node = new Node("ReadUpdateEnd", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingEnd(com.generator.generators.cypher.parser.CypherParser.UpdatingEndContext arg) {
		final Node node = new Node("UpdatingEnd", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiPartQuery(com.generator.generators.cypher.parser.CypherParser.MultiPartQueryContext arg) {
		final Node node = new Node("MultiPartQuery", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadPart(com.generator.generators.cypher.parser.CypherParser.ReadPartContext arg) {
		final Node node = new Node("ReadPart", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingPart(com.generator.generators.cypher.parser.CypherParser.UpdatingPartContext arg) {
		final Node node = new Node("UpdatingPart", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingStartClause(com.generator.generators.cypher.parser.CypherParser.UpdatingStartClauseContext arg) {
		final Node node = new Node("UpdatingStartClause", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingClause(com.generator.generators.cypher.parser.CypherParser.UpdatingClauseContext arg) {
		final Node node = new Node("UpdatingClause", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadingClause(com.generator.generators.cypher.parser.CypherParser.ReadingClauseContext arg) {
		final Node node = new Node("ReadingClause", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCyper_match(com.generator.generators.cypher.parser.CypherParser.Cyper_matchContext arg) {
		final Node node = new Node("Cyper_match", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnwind(com.generator.generators.cypher.parser.CypherParser.UnwindContext arg) {
		final Node node = new Node("Unwind", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMerge(com.generator.generators.cypher.parser.CypherParser.MergeContext arg) {
		final Node node = new Node("Merge", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMergeAction(com.generator.generators.cypher.parser.CypherParser.MergeActionContext arg) {
		final Node node = new Node("MergeAction", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate(com.generator.generators.cypher.parser.CypherParser.CreateContext arg) {
		final Node node = new Node("Create", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetItem(com.generator.generators.cypher.parser.CypherParser.SetItemContext arg) {
		final Node node = new Node("SetItem", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelete(com.generator.generators.cypher.parser.CypherParser.DeleteContext arg) {
		final Node node = new Node("Delete", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemove(com.generator.generators.cypher.parser.CypherParser.RemoveContext arg) {
		final Node node = new Node("Remove", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemoveItem(com.generator.generators.cypher.parser.CypherParser.RemoveItemContext arg) {
		final Node node = new Node("RemoveItem", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInQueryCall(com.generator.generators.cypher.parser.CypherParser.InQueryCallContext arg) {
		final Node node = new Node("InQueryCall", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStandaloneCall(com.generator.generators.cypher.parser.CypherParser.StandaloneCallContext arg) {
		final Node node = new Node("StandaloneCall", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItems(com.generator.generators.cypher.parser.CypherParser.YieldItemsContext arg) {
		final Node node = new Node("YieldItems", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItem(com.generator.generators.cypher.parser.CypherParser.YieldItemContext arg) {
		final Node node = new Node("YieldItem", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith(com.generator.generators.cypher.parser.CypherParser.WithContext arg) {
		final Node node = new Node("With", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher_return(com.generator.generators.cypher.parser.CypherParser.Cypher_returnContext arg) {
		final Node node = new Node("Cypher_return", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnBody(com.generator.generators.cypher.parser.CypherParser.ReturnBodyContext arg) {
		final Node node = new Node("ReturnBody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItems(com.generator.generators.cypher.parser.CypherParser.ReturnItemsContext arg) {
		final Node node = new Node("ReturnItems", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItem(com.generator.generators.cypher.parser.CypherParser.ReturnItemContext arg) {
		final Node node = new Node("ReturnItem", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder(com.generator.generators.cypher.parser.CypherParser.OrderContext arg) {
		final Node node = new Node("Order", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSkip(com.generator.generators.cypher.parser.CypherParser.SkipContext arg) {
		final Node node = new Node("Skip", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimit(com.generator.generators.cypher.parser.CypherParser.LimitContext arg) {
		final Node node = new Node("Limit", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSortItem(com.generator.generators.cypher.parser.CypherParser.SortItemContext arg) {
		final Node node = new Node("SortItem", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhere(com.generator.generators.cypher.parser.CypherParser.WhereContext arg) {
		final Node node = new Node("Where", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern(com.generator.generators.cypher.parser.CypherParser.PatternContext arg) {
		final Node node = new Node("Pattern", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternPart(com.generator.generators.cypher.parser.CypherParser.PatternPartContext arg) {
		final Node node = new Node("PatternPart", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnonymousPatternPart(com.generator.generators.cypher.parser.CypherParser.AnonymousPatternPartContext arg) {
		final Node node = new Node("AnonymousPatternPart", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElement(com.generator.generators.cypher.parser.CypherParser.PatternElementContext arg) {
		final Node node = new Node("PatternElement", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodePattern(com.generator.generators.cypher.parser.CypherParser.NodePatternContext arg) {
		final Node node = new Node("NodePattern", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElementChain(com.generator.generators.cypher.parser.CypherParser.PatternElementChainContext arg) {
		final Node node = new Node("PatternElementChain", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipPatternContext arg) {
		final Node node = new Node("RelationshipPattern", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipDetail(com.generator.generators.cypher.parser.CypherParser.RelationshipDetailContext arg) {
		final Node node = new Node("RelationshipDetail", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProperties(com.generator.generators.cypher.parser.CypherParser.PropertiesContext arg) {
		final Node node = new Node("Properties", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipTypes(com.generator.generators.cypher.parser.CypherParser.RelationshipTypesContext arg) {
		final Node node = new Node("RelationshipTypes", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabels(com.generator.generators.cypher.parser.CypherParser.NodeLabelsContext arg) {
		final Node node = new Node("NodeLabels", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabel(com.generator.generators.cypher.parser.CypherParser.NodeLabelContext arg) {
		final Node node = new Node("NodeLabel", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRangeLiteral(com.generator.generators.cypher.parser.CypherParser.RangeLiteralContext arg) {
		final Node node = new Node("RangeLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabelName(com.generator.generators.cypher.parser.CypherParser.LabelNameContext arg) {
		final Node node = new Node("LabelName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelTypeName(com.generator.generators.cypher.parser.CypherParser.RelTypeNameContext arg) {
		final Node node = new Node("RelTypeName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrExpression(com.generator.generators.cypher.parser.CypherParser.OrExpressionContext arg) {
		final Node node = new Node("OrExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXorExpression(com.generator.generators.cypher.parser.CypherParser.XorExpressionContext arg) {
		final Node node = new Node("XorExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndExpression(com.generator.generators.cypher.parser.CypherParser.AndExpressionContext arg) {
		final Node node = new Node("AndExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotExpression(com.generator.generators.cypher.parser.CypherParser.NotExpressionContext arg) {
		final Node node = new Node("NotExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparisonExpression(com.generator.generators.cypher.parser.CypherParser.ComparisonExpressionContext arg) {
		final Node node = new Node("ComparisonExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.AddOrSubtractExpressionContext arg) {
		final Node node = new Node("AddOrSubtractExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplyDivideModuloExpression(com.generator.generators.cypher.parser.CypherParser.MultiplyDivideModuloExpressionContext arg) {
		final Node node = new Node("MultiplyDivideModuloExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPowerOfExpression(com.generator.generators.cypher.parser.CypherParser.PowerOfExpressionContext arg) {
		final Node node = new Node("PowerOfExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.UnaryAddOrSubtractExpressionContext arg) {
		final Node node = new Node("UnaryAddOrSubtractExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStringListNullOperatorExpression(com.generator.generators.cypher.parser.CypherParser.StringListNullOperatorExpressionContext arg) {
		final Node node = new Node("StringListNullOperatorExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyOrLabelsExpression(com.generator.generators.cypher.parser.CypherParser.PropertyOrLabelsExpressionContext arg) {
		final Node node = new Node("PropertyOrLabelsExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanLiteral(com.generator.generators.cypher.parser.CypherParser.BooleanLiteralContext arg) {
		final Node node = new Node("BooleanLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListLiteral(com.generator.generators.cypher.parser.CypherParser.ListLiteralContext arg) {
		final Node node = new Node("ListLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartialComparisonExpression(com.generator.generators.cypher.parser.CypherParser.PartialComparisonExpressionContext arg) {
		final Node node = new Node("PartialComparisonExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenthesizedExpression(com.generator.generators.cypher.parser.CypherParser.ParenthesizedExpressionContext arg) {
		final Node node = new Node("ParenthesizedExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipsPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipsPatternContext arg) {
		final Node node = new Node("RelationshipsPattern", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilterExpression(com.generator.generators.cypher.parser.CypherParser.FilterExpressionContext arg) {
		final Node node = new Node("FilterExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdInColl(com.generator.generators.cypher.parser.CypherParser.IdInCollContext arg) {
		final Node node = new Node("IdInColl", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionInvocation(com.generator.generators.cypher.parser.CypherParser.FunctionInvocationContext arg) {
		final Node node = new Node("FunctionInvocation", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionName(com.generator.generators.cypher.parser.CypherParser.FunctionNameContext arg) {
		final Node node = new Node("FunctionName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ExplicitProcedureInvocationContext arg) {
		final Node node = new Node("ExplicitProcedureInvocation", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ImplicitProcedureInvocationContext arg) {
		final Node node = new Node("ImplicitProcedureInvocation", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureResultField(com.generator.generators.cypher.parser.CypherParser.ProcedureResultFieldContext arg) {
		final Node node = new Node("ProcedureResultField", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureName(com.generator.generators.cypher.parser.CypherParser.ProcedureNameContext arg) {
		final Node node = new Node("ProcedureName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespace(com.generator.generators.cypher.parser.CypherParser.NamespaceContext arg) {
		final Node node = new Node("Namespace", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListComprehension(com.generator.generators.cypher.parser.CypherParser.ListComprehensionContext arg) {
		final Node node = new Node("ListComprehension", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternComprehension(com.generator.generators.cypher.parser.CypherParser.PatternComprehensionContext arg) {
		final Node node = new Node("PatternComprehension", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyLookup(com.generator.generators.cypher.parser.CypherParser.PropertyLookupContext arg) {
		final Node node = new Node("PropertyLookup", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseExpression(com.generator.generators.cypher.parser.CypherParser.CaseExpressionContext arg) {
		final Node node = new Node("CaseExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseAlternatives(com.generator.generators.cypher.parser.CypherParser.CaseAlternativesContext arg) {
		final Node node = new Node("CaseAlternatives", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariable(com.generator.generators.cypher.parser.CypherParser.VariableContext arg) {
		final Node node = new Node("Variable", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumberLiteral(com.generator.generators.cypher.parser.CypherParser.NumberLiteralContext arg) {
		final Node node = new Node("NumberLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapLiteral(com.generator.generators.cypher.parser.CypherParser.MapLiteralContext arg) {
		final Node node = new Node("MapLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyExpression(com.generator.generators.cypher.parser.CypherParser.PropertyExpressionContext arg) {
		final Node node = new Node("PropertyExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyKeyName(com.generator.generators.cypher.parser.CypherParser.PropertyKeyNameContext arg) {
		final Node node = new Node("PropertyKeyName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntegerLiteral(com.generator.generators.cypher.parser.CypherParser.IntegerLiteralContext arg) {
		final Node node = new Node("IntegerLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDoubleLiteral(com.generator.generators.cypher.parser.CypherParser.DoubleLiteralContext arg) {
		final Node node = new Node("DoubleLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSchemaName(com.generator.generators.cypher.parser.CypherParser.SchemaNameContext arg) {
		final Node node = new Node("SchemaName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReservedWord(com.generator.generators.cypher.parser.CypherParser.ReservedWordContext arg) {
		final Node node = new Node("ReservedWord", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSymbolicName(com.generator.generators.cypher.parser.CypherParser.SymbolicNameContext arg) {
		final Node node = new Node("SymbolicName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLeftArrowHead(com.generator.generators.cypher.parser.CypherParser.LeftArrowHeadContext arg) {
		final Node node = new Node("LeftArrowHead", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRightArrowHead(com.generator.generators.cypher.parser.CypherParser.RightArrowHeadContext arg) {
		final Node node = new Node("RightArrowHead", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDash(com.generator.generators.cypher.parser.CypherParser.DashContext arg) {
		final Node node = new Node("Dash", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}