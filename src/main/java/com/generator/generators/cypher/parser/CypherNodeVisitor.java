package com.generator.generators.cypher.parser;

public class CypherNodeVisitor extends CypherBaseVisitor<CypherNodeVisitor.Node> {

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

	public CypherNodeVisitor() {
		this(false);
	}

	public CypherNodeVisitor(boolean debug) {
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
	public Node visitAtom(com.generator.generators.cypher.parser.CypherParser.AtomContext arg) {
		final Node node = new Node("Atom", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameter(com.generator.generators.cypher.parser.CypherParser.ParameterContext arg) {
		final Node node = new Node("Parameter", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet(com.generator.generators.cypher.parser.CypherParser.SetContext arg) {
		final Node node = new Node("Set", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		final Node node = new Node("Expression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.cypher.parser.CypherParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.cypher.parser.CypherParser.StatementContext arg) {
		final Node node = new Node("Statement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		final Node node = new Node("RegularQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion(com.generator.generators.cypher.parser.CypherParser.UnionContext arg) {
		final Node node = new Node("Union", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingleQuery(com.generator.generators.cypher.parser.CypherParser.SingleQueryContext arg) {
		final Node node = new Node("SingleQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSinglePartQuery(com.generator.generators.cypher.parser.CypherParser.SinglePartQueryContext arg) {
		final Node node = new Node("SinglePartQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadOnlyEnd(com.generator.generators.cypher.parser.CypherParser.ReadOnlyEndContext arg) {
		final Node node = new Node("ReadOnlyEnd", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadUpdateEnd(com.generator.generators.cypher.parser.CypherParser.ReadUpdateEndContext arg) {
		final Node node = new Node("ReadUpdateEnd", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher(com.generator.generators.cypher.parser.CypherParser.CypherContext arg) {
		final Node node = new Node("Cypher", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.cypher.parser.CypherParser.QueryContext arg) {
		final Node node = new Node("Query", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingEnd(com.generator.generators.cypher.parser.CypherParser.UpdatingEndContext arg) {
		final Node node = new Node("UpdatingEnd", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiPartQuery(com.generator.generators.cypher.parser.CypherParser.MultiPartQueryContext arg) {
		final Node node = new Node("MultiPartQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadPart(com.generator.generators.cypher.parser.CypherParser.ReadPartContext arg) {
		final Node node = new Node("ReadPart", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingPart(com.generator.generators.cypher.parser.CypherParser.UpdatingPartContext arg) {
		final Node node = new Node("UpdatingPart", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingStartClause(com.generator.generators.cypher.parser.CypherParser.UpdatingStartClauseContext arg) {
		final Node node = new Node("UpdatingStartClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingClause(com.generator.generators.cypher.parser.CypherParser.UpdatingClauseContext arg) {
		final Node node = new Node("UpdatingClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadingClause(com.generator.generators.cypher.parser.CypherParser.ReadingClauseContext arg) {
		final Node node = new Node("ReadingClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCyper_match(com.generator.generators.cypher.parser.CypherParser.Cyper_matchContext arg) {
		final Node node = new Node("Cyper_match", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnwind(com.generator.generators.cypher.parser.CypherParser.UnwindContext arg) {
		final Node node = new Node("Unwind", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMerge(com.generator.generators.cypher.parser.CypherParser.MergeContext arg) {
		final Node node = new Node("Merge", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMergeAction(com.generator.generators.cypher.parser.CypherParser.MergeActionContext arg) {
		final Node node = new Node("MergeAction", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate(com.generator.generators.cypher.parser.CypherParser.CreateContext arg) {
		final Node node = new Node("Create", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetItem(com.generator.generators.cypher.parser.CypherParser.SetItemContext arg) {
		final Node node = new Node("SetItem", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelete(com.generator.generators.cypher.parser.CypherParser.DeleteContext arg) {
		final Node node = new Node("Delete", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemove(com.generator.generators.cypher.parser.CypherParser.RemoveContext arg) {
		final Node node = new Node("Remove", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemoveItem(com.generator.generators.cypher.parser.CypherParser.RemoveItemContext arg) {
		final Node node = new Node("RemoveItem", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInQueryCall(com.generator.generators.cypher.parser.CypherParser.InQueryCallContext arg) {
		final Node node = new Node("InQueryCall", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStandaloneCall(com.generator.generators.cypher.parser.CypherParser.StandaloneCallContext arg) {
		final Node node = new Node("StandaloneCall", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItems(com.generator.generators.cypher.parser.CypherParser.YieldItemsContext arg) {
		final Node node = new Node("YieldItems", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItem(com.generator.generators.cypher.parser.CypherParser.YieldItemContext arg) {
		final Node node = new Node("YieldItem", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith(com.generator.generators.cypher.parser.CypherParser.WithContext arg) {
		final Node node = new Node("With", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher_return(com.generator.generators.cypher.parser.CypherParser.Cypher_returnContext arg) {
		final Node node = new Node("Cypher_return", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnBody(com.generator.generators.cypher.parser.CypherParser.ReturnBodyContext arg) {
		final Node node = new Node("ReturnBody", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItems(com.generator.generators.cypher.parser.CypherParser.ReturnItemsContext arg) {
		final Node node = new Node("ReturnItems", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItem(com.generator.generators.cypher.parser.CypherParser.ReturnItemContext arg) {
		final Node node = new Node("ReturnItem", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder(com.generator.generators.cypher.parser.CypherParser.OrderContext arg) {
		final Node node = new Node("Order", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSkip(com.generator.generators.cypher.parser.CypherParser.SkipContext arg) {
		final Node node = new Node("Skip", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimit(com.generator.generators.cypher.parser.CypherParser.LimitContext arg) {
		final Node node = new Node("Limit", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSortItem(com.generator.generators.cypher.parser.CypherParser.SortItemContext arg) {
		final Node node = new Node("SortItem", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhere(com.generator.generators.cypher.parser.CypherParser.WhereContext arg) {
		final Node node = new Node("Where", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern(com.generator.generators.cypher.parser.CypherParser.PatternContext arg) {
		final Node node = new Node("Pattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternPart(com.generator.generators.cypher.parser.CypherParser.PatternPartContext arg) {
		final Node node = new Node("PatternPart", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnonymousPatternPart(com.generator.generators.cypher.parser.CypherParser.AnonymousPatternPartContext arg) {
		final Node node = new Node("AnonymousPatternPart", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElement(com.generator.generators.cypher.parser.CypherParser.PatternElementContext arg) {
		final Node node = new Node("PatternElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodePattern(com.generator.generators.cypher.parser.CypherParser.NodePatternContext arg) {
		final Node node = new Node("NodePattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElementChain(com.generator.generators.cypher.parser.CypherParser.PatternElementChainContext arg) {
		final Node node = new Node("PatternElementChain", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipPatternContext arg) {
		final Node node = new Node("RelationshipPattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipDetail(com.generator.generators.cypher.parser.CypherParser.RelationshipDetailContext arg) {
		final Node node = new Node("RelationshipDetail", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProperties(com.generator.generators.cypher.parser.CypherParser.PropertiesContext arg) {
		final Node node = new Node("Properties", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipTypes(com.generator.generators.cypher.parser.CypherParser.RelationshipTypesContext arg) {
		final Node node = new Node("RelationshipTypes", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabels(com.generator.generators.cypher.parser.CypherParser.NodeLabelsContext arg) {
		final Node node = new Node("NodeLabels", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabel(com.generator.generators.cypher.parser.CypherParser.NodeLabelContext arg) {
		final Node node = new Node("NodeLabel", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRangeLiteral(com.generator.generators.cypher.parser.CypherParser.RangeLiteralContext arg) {
		final Node node = new Node("RangeLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabelName(com.generator.generators.cypher.parser.CypherParser.LabelNameContext arg) {
		final Node node = new Node("LabelName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelTypeName(com.generator.generators.cypher.parser.CypherParser.RelTypeNameContext arg) {
		final Node node = new Node("RelTypeName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrExpression(com.generator.generators.cypher.parser.CypherParser.OrExpressionContext arg) {
		final Node node = new Node("OrExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXorExpression(com.generator.generators.cypher.parser.CypherParser.XorExpressionContext arg) {
		final Node node = new Node("XorExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndExpression(com.generator.generators.cypher.parser.CypherParser.AndExpressionContext arg) {
		final Node node = new Node("AndExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotExpression(com.generator.generators.cypher.parser.CypherParser.NotExpressionContext arg) {
		final Node node = new Node("NotExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparisonExpression(com.generator.generators.cypher.parser.CypherParser.ComparisonExpressionContext arg) {
		final Node node = new Node("ComparisonExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.AddOrSubtractExpressionContext arg) {
		final Node node = new Node("AddOrSubtractExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplyDivideModuloExpression(com.generator.generators.cypher.parser.CypherParser.MultiplyDivideModuloExpressionContext arg) {
		final Node node = new Node("MultiplyDivideModuloExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPowerOfExpression(com.generator.generators.cypher.parser.CypherParser.PowerOfExpressionContext arg) {
		final Node node = new Node("PowerOfExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.UnaryAddOrSubtractExpressionContext arg) {
		final Node node = new Node("UnaryAddOrSubtractExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStringListNullOperatorExpression(com.generator.generators.cypher.parser.CypherParser.StringListNullOperatorExpressionContext arg) {
		final Node node = new Node("StringListNullOperatorExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyOrLabelsExpression(com.generator.generators.cypher.parser.CypherParser.PropertyOrLabelsExpressionContext arg) {
		final Node node = new Node("PropertyOrLabelsExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanLiteral(com.generator.generators.cypher.parser.CypherParser.BooleanLiteralContext arg) {
		final Node node = new Node("BooleanLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListLiteral(com.generator.generators.cypher.parser.CypherParser.ListLiteralContext arg) {
		final Node node = new Node("ListLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartialComparisonExpression(com.generator.generators.cypher.parser.CypherParser.PartialComparisonExpressionContext arg) {
		final Node node = new Node("PartialComparisonExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenthesizedExpression(com.generator.generators.cypher.parser.CypherParser.ParenthesizedExpressionContext arg) {
		final Node node = new Node("ParenthesizedExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipsPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipsPatternContext arg) {
		final Node node = new Node("RelationshipsPattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilterExpression(com.generator.generators.cypher.parser.CypherParser.FilterExpressionContext arg) {
		final Node node = new Node("FilterExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdInColl(com.generator.generators.cypher.parser.CypherParser.IdInCollContext arg) {
		final Node node = new Node("IdInColl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionInvocation(com.generator.generators.cypher.parser.CypherParser.FunctionInvocationContext arg) {
		final Node node = new Node("FunctionInvocation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionName(com.generator.generators.cypher.parser.CypherParser.FunctionNameContext arg) {
		final Node node = new Node("FunctionName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ExplicitProcedureInvocationContext arg) {
		final Node node = new Node("ExplicitProcedureInvocation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ImplicitProcedureInvocationContext arg) {
		final Node node = new Node("ImplicitProcedureInvocation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureResultField(com.generator.generators.cypher.parser.CypherParser.ProcedureResultFieldContext arg) {
		final Node node = new Node("ProcedureResultField", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureName(com.generator.generators.cypher.parser.CypherParser.ProcedureNameContext arg) {
		final Node node = new Node("ProcedureName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespace(com.generator.generators.cypher.parser.CypherParser.NamespaceContext arg) {
		final Node node = new Node("Namespace", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListComprehension(com.generator.generators.cypher.parser.CypherParser.ListComprehensionContext arg) {
		final Node node = new Node("ListComprehension", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternComprehension(com.generator.generators.cypher.parser.CypherParser.PatternComprehensionContext arg) {
		final Node node = new Node("PatternComprehension", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyLookup(com.generator.generators.cypher.parser.CypherParser.PropertyLookupContext arg) {
		final Node node = new Node("PropertyLookup", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseExpression(com.generator.generators.cypher.parser.CypherParser.CaseExpressionContext arg) {
		final Node node = new Node("CaseExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseAlternatives(com.generator.generators.cypher.parser.CypherParser.CaseAlternativesContext arg) {
		final Node node = new Node("CaseAlternatives", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariable(com.generator.generators.cypher.parser.CypherParser.VariableContext arg) {
		final Node node = new Node("Variable", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumberLiteral(com.generator.generators.cypher.parser.CypherParser.NumberLiteralContext arg) {
		final Node node = new Node("NumberLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapLiteral(com.generator.generators.cypher.parser.CypherParser.MapLiteralContext arg) {
		final Node node = new Node("MapLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyExpression(com.generator.generators.cypher.parser.CypherParser.PropertyExpressionContext arg) {
		final Node node = new Node("PropertyExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyKeyName(com.generator.generators.cypher.parser.CypherParser.PropertyKeyNameContext arg) {
		final Node node = new Node("PropertyKeyName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntegerLiteral(com.generator.generators.cypher.parser.CypherParser.IntegerLiteralContext arg) {
		final Node node = new Node("IntegerLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDoubleLiteral(com.generator.generators.cypher.parser.CypherParser.DoubleLiteralContext arg) {
		final Node node = new Node("DoubleLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSchemaName(com.generator.generators.cypher.parser.CypherParser.SchemaNameContext arg) {
		final Node node = new Node("SchemaName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReservedWord(com.generator.generators.cypher.parser.CypherParser.ReservedWordContext arg) {
		final Node node = new Node("ReservedWord", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSymbolicName(com.generator.generators.cypher.parser.CypherParser.SymbolicNameContext arg) {
		final Node node = new Node("SymbolicName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLeftArrowHead(com.generator.generators.cypher.parser.CypherParser.LeftArrowHeadContext arg) {
		final Node node = new Node("LeftArrowHead", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRightArrowHead(com.generator.generators.cypher.parser.CypherParser.RightArrowHeadContext arg) {
		final Node node = new Node("RightArrowHead", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDash(com.generator.generators.cypher.parser.CypherParser.DashContext arg) {
		final Node node = new Node("Dash", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}