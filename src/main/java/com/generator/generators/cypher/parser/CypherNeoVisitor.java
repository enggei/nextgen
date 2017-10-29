package com.generator.generators.cypher.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CypherNeoVisitor extends CypherBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public CypherNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitAtom(com.generator.generators.cypher.parser.CypherParser.AtomContext arg) {
		System.out.println("Atom");
		final Node node = model.newNode(Label.label("Atom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameter(com.generator.generators.cypher.parser.CypherParser.ParameterContext arg) {
		System.out.println("Parameter");
		final Node node = model.newNode(Label.label("Parameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.cypher.parser.CypherParser.QueryContext arg) {
		System.out.println("Query");
		final Node node = model.newNode(Label.label("Query"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet(com.generator.generators.cypher.parser.CypherParser.SetContext arg) {
		System.out.println("Set");
		final Node node = model.newNode(Label.label("Set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.cypher.parser.CypherParser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		System.out.println("Expression");
		final Node node = model.newNode(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.cypher.parser.CypherParser.StatementContext arg) {
		System.out.println("Statement");
		final Node node = model.newNode(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		System.out.println("RegularQuery");
		final Node node = model.newNode(Label.label("RegularQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher(com.generator.generators.cypher.parser.CypherParser.CypherContext arg) {
		System.out.println("Cypher");
		final Node node = model.newNode(Label.label("Cypher"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion(com.generator.generators.cypher.parser.CypherParser.UnionContext arg) {
		System.out.println("Union");
		final Node node = model.newNode(Label.label("Union"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingleQuery(com.generator.generators.cypher.parser.CypherParser.SingleQueryContext arg) {
		System.out.println("SingleQuery");
		final Node node = model.newNode(Label.label("SingleQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSinglePartQuery(com.generator.generators.cypher.parser.CypherParser.SinglePartQueryContext arg) {
		System.out.println("SinglePartQuery");
		final Node node = model.newNode(Label.label("SinglePartQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadOnlyEnd(com.generator.generators.cypher.parser.CypherParser.ReadOnlyEndContext arg) {
		System.out.println("ReadOnlyEnd");
		final Node node = model.newNode(Label.label("ReadOnlyEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadUpdateEnd(com.generator.generators.cypher.parser.CypherParser.ReadUpdateEndContext arg) {
		System.out.println("ReadUpdateEnd");
		final Node node = model.newNode(Label.label("ReadUpdateEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingEnd(com.generator.generators.cypher.parser.CypherParser.UpdatingEndContext arg) {
		System.out.println("UpdatingEnd");
		final Node node = model.newNode(Label.label("UpdatingEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiPartQuery(com.generator.generators.cypher.parser.CypherParser.MultiPartQueryContext arg) {
		System.out.println("MultiPartQuery");
		final Node node = model.newNode(Label.label("MultiPartQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadPart(com.generator.generators.cypher.parser.CypherParser.ReadPartContext arg) {
		System.out.println("ReadPart");
		final Node node = model.newNode(Label.label("ReadPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingPart(com.generator.generators.cypher.parser.CypherParser.UpdatingPartContext arg) {
		System.out.println("UpdatingPart");
		final Node node = model.newNode(Label.label("UpdatingPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingStartClause(com.generator.generators.cypher.parser.CypherParser.UpdatingStartClauseContext arg) {
		System.out.println("UpdatingStartClause");
		final Node node = model.newNode(Label.label("UpdatingStartClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingClause(com.generator.generators.cypher.parser.CypherParser.UpdatingClauseContext arg) {
		System.out.println("UpdatingClause");
		final Node node = model.newNode(Label.label("UpdatingClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadingClause(com.generator.generators.cypher.parser.CypherParser.ReadingClauseContext arg) {
		System.out.println("ReadingClause");
		final Node node = model.newNode(Label.label("ReadingClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCyper_match(com.generator.generators.cypher.parser.CypherParser.Cyper_matchContext arg) {
		System.out.println("Cyper_match");
		final Node node = model.newNode(Label.label("Cyper_match"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnwind(com.generator.generators.cypher.parser.CypherParser.UnwindContext arg) {
		System.out.println("Unwind");
		final Node node = model.newNode(Label.label("Unwind"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMerge(com.generator.generators.cypher.parser.CypherParser.MergeContext arg) {
		System.out.println("Merge");
		final Node node = model.newNode(Label.label("Merge"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMergeAction(com.generator.generators.cypher.parser.CypherParser.MergeActionContext arg) {
		System.out.println("MergeAction");
		final Node node = model.newNode(Label.label("MergeAction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate(com.generator.generators.cypher.parser.CypherParser.CreateContext arg) {
		System.out.println("Create");
		final Node node = model.newNode(Label.label("Create"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetItem(com.generator.generators.cypher.parser.CypherParser.SetItemContext arg) {
		System.out.println("SetItem");
		final Node node = model.newNode(Label.label("SetItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelete(com.generator.generators.cypher.parser.CypherParser.DeleteContext arg) {
		System.out.println("Delete");
		final Node node = model.newNode(Label.label("Delete"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemove(com.generator.generators.cypher.parser.CypherParser.RemoveContext arg) {
		System.out.println("Remove");
		final Node node = model.newNode(Label.label("Remove"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemoveItem(com.generator.generators.cypher.parser.CypherParser.RemoveItemContext arg) {
		System.out.println("RemoveItem");
		final Node node = model.newNode(Label.label("RemoveItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInQueryCall(com.generator.generators.cypher.parser.CypherParser.InQueryCallContext arg) {
		System.out.println("InQueryCall");
		final Node node = model.newNode(Label.label("InQueryCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStandaloneCall(com.generator.generators.cypher.parser.CypherParser.StandaloneCallContext arg) {
		System.out.println("StandaloneCall");
		final Node node = model.newNode(Label.label("StandaloneCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItems(com.generator.generators.cypher.parser.CypherParser.YieldItemsContext arg) {
		System.out.println("YieldItems");
		final Node node = model.newNode(Label.label("YieldItems"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItem(com.generator.generators.cypher.parser.CypherParser.YieldItemContext arg) {
		System.out.println("YieldItem");
		final Node node = model.newNode(Label.label("YieldItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith(com.generator.generators.cypher.parser.CypherParser.WithContext arg) {
		System.out.println("With");
		final Node node = model.newNode(Label.label("With"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher_return(com.generator.generators.cypher.parser.CypherParser.Cypher_returnContext arg) {
		System.out.println("Cypher_return");
		final Node node = model.newNode(Label.label("Cypher_return"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnBody(com.generator.generators.cypher.parser.CypherParser.ReturnBodyContext arg) {
		System.out.println("ReturnBody");
		final Node node = model.newNode(Label.label("ReturnBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItems(com.generator.generators.cypher.parser.CypherParser.ReturnItemsContext arg) {
		System.out.println("ReturnItems");
		final Node node = model.newNode(Label.label("ReturnItems"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItem(com.generator.generators.cypher.parser.CypherParser.ReturnItemContext arg) {
		System.out.println("ReturnItem");
		final Node node = model.newNode(Label.label("ReturnItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder(com.generator.generators.cypher.parser.CypherParser.OrderContext arg) {
		System.out.println("Order");
		final Node node = model.newNode(Label.label("Order"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSkip(com.generator.generators.cypher.parser.CypherParser.SkipContext arg) {
		System.out.println("Skip");
		final Node node = model.newNode(Label.label("Skip"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimit(com.generator.generators.cypher.parser.CypherParser.LimitContext arg) {
		System.out.println("Limit");
		final Node node = model.newNode(Label.label("Limit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSortItem(com.generator.generators.cypher.parser.CypherParser.SortItemContext arg) {
		System.out.println("SortItem");
		final Node node = model.newNode(Label.label("SortItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhere(com.generator.generators.cypher.parser.CypherParser.WhereContext arg) {
		System.out.println("Where");
		final Node node = model.newNode(Label.label("Where"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern(com.generator.generators.cypher.parser.CypherParser.PatternContext arg) {
		System.out.println("Pattern");
		final Node node = model.newNode(Label.label("Pattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternPart(com.generator.generators.cypher.parser.CypherParser.PatternPartContext arg) {
		System.out.println("PatternPart");
		final Node node = model.newNode(Label.label("PatternPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnonymousPatternPart(com.generator.generators.cypher.parser.CypherParser.AnonymousPatternPartContext arg) {
		System.out.println("AnonymousPatternPart");
		final Node node = model.newNode(Label.label("AnonymousPatternPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElement(com.generator.generators.cypher.parser.CypherParser.PatternElementContext arg) {
		System.out.println("PatternElement");
		final Node node = model.newNode(Label.label("PatternElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodePattern(com.generator.generators.cypher.parser.CypherParser.NodePatternContext arg) {
		System.out.println("NodePattern");
		final Node node = model.newNode(Label.label("NodePattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElementChain(com.generator.generators.cypher.parser.CypherParser.PatternElementChainContext arg) {
		System.out.println("PatternElementChain");
		final Node node = model.newNode(Label.label("PatternElementChain"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipPatternContext arg) {
		System.out.println("RelationshipPattern");
		final Node node = model.newNode(Label.label("RelationshipPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipDetail(com.generator.generators.cypher.parser.CypherParser.RelationshipDetailContext arg) {
		System.out.println("RelationshipDetail");
		final Node node = model.newNode(Label.label("RelationshipDetail"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProperties(com.generator.generators.cypher.parser.CypherParser.PropertiesContext arg) {
		System.out.println("Properties");
		final Node node = model.newNode(Label.label("Properties"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipTypes(com.generator.generators.cypher.parser.CypherParser.RelationshipTypesContext arg) {
		System.out.println("RelationshipTypes");
		final Node node = model.newNode(Label.label("RelationshipTypes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabels(com.generator.generators.cypher.parser.CypherParser.NodeLabelsContext arg) {
		System.out.println("NodeLabels");
		final Node node = model.newNode(Label.label("NodeLabels"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabel(com.generator.generators.cypher.parser.CypherParser.NodeLabelContext arg) {
		System.out.println("NodeLabel");
		final Node node = model.newNode(Label.label("NodeLabel"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRangeLiteral(com.generator.generators.cypher.parser.CypherParser.RangeLiteralContext arg) {
		System.out.println("RangeLiteral");
		final Node node = model.newNode(Label.label("RangeLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabelName(com.generator.generators.cypher.parser.CypherParser.LabelNameContext arg) {
		System.out.println("LabelName");
		final Node node = model.newNode(Label.label("LabelName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelTypeName(com.generator.generators.cypher.parser.CypherParser.RelTypeNameContext arg) {
		System.out.println("RelTypeName");
		final Node node = model.newNode(Label.label("RelTypeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrExpression(com.generator.generators.cypher.parser.CypherParser.OrExpressionContext arg) {
		System.out.println("OrExpression");
		final Node node = model.newNode(Label.label("OrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXorExpression(com.generator.generators.cypher.parser.CypherParser.XorExpressionContext arg) {
		System.out.println("XorExpression");
		final Node node = model.newNode(Label.label("XorExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndExpression(com.generator.generators.cypher.parser.CypherParser.AndExpressionContext arg) {
		System.out.println("AndExpression");
		final Node node = model.newNode(Label.label("AndExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotExpression(com.generator.generators.cypher.parser.CypherParser.NotExpressionContext arg) {
		System.out.println("NotExpression");
		final Node node = model.newNode(Label.label("NotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparisonExpression(com.generator.generators.cypher.parser.CypherParser.ComparisonExpressionContext arg) {
		System.out.println("ComparisonExpression");
		final Node node = model.newNode(Label.label("ComparisonExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.AddOrSubtractExpressionContext arg) {
		System.out.println("AddOrSubtractExpression");
		final Node node = model.newNode(Label.label("AddOrSubtractExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplyDivideModuloExpression(com.generator.generators.cypher.parser.CypherParser.MultiplyDivideModuloExpressionContext arg) {
		System.out.println("MultiplyDivideModuloExpression");
		final Node node = model.newNode(Label.label("MultiplyDivideModuloExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPowerOfExpression(com.generator.generators.cypher.parser.CypherParser.PowerOfExpressionContext arg) {
		System.out.println("PowerOfExpression");
		final Node node = model.newNode(Label.label("PowerOfExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.UnaryAddOrSubtractExpressionContext arg) {
		System.out.println("UnaryAddOrSubtractExpression");
		final Node node = model.newNode(Label.label("UnaryAddOrSubtractExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStringListNullOperatorExpression(com.generator.generators.cypher.parser.CypherParser.StringListNullOperatorExpressionContext arg) {
		System.out.println("StringListNullOperatorExpression");
		final Node node = model.newNode(Label.label("StringListNullOperatorExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyOrLabelsExpression(com.generator.generators.cypher.parser.CypherParser.PropertyOrLabelsExpressionContext arg) {
		System.out.println("PropertyOrLabelsExpression");
		final Node node = model.newNode(Label.label("PropertyOrLabelsExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanLiteral(com.generator.generators.cypher.parser.CypherParser.BooleanLiteralContext arg) {
		System.out.println("BooleanLiteral");
		final Node node = model.newNode(Label.label("BooleanLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListLiteral(com.generator.generators.cypher.parser.CypherParser.ListLiteralContext arg) {
		System.out.println("ListLiteral");
		final Node node = model.newNode(Label.label("ListLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartialComparisonExpression(com.generator.generators.cypher.parser.CypherParser.PartialComparisonExpressionContext arg) {
		System.out.println("PartialComparisonExpression");
		final Node node = model.newNode(Label.label("PartialComparisonExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenthesizedExpression(com.generator.generators.cypher.parser.CypherParser.ParenthesizedExpressionContext arg) {
		System.out.println("ParenthesizedExpression");
		final Node node = model.newNode(Label.label("ParenthesizedExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipsPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipsPatternContext arg) {
		System.out.println("RelationshipsPattern");
		final Node node = model.newNode(Label.label("RelationshipsPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilterExpression(com.generator.generators.cypher.parser.CypherParser.FilterExpressionContext arg) {
		System.out.println("FilterExpression");
		final Node node = model.newNode(Label.label("FilterExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdInColl(com.generator.generators.cypher.parser.CypherParser.IdInCollContext arg) {
		System.out.println("IdInColl");
		final Node node = model.newNode(Label.label("IdInColl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionInvocation(com.generator.generators.cypher.parser.CypherParser.FunctionInvocationContext arg) {
		System.out.println("FunctionInvocation");
		final Node node = model.newNode(Label.label("FunctionInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionName(com.generator.generators.cypher.parser.CypherParser.FunctionNameContext arg) {
		System.out.println("FunctionName");
		final Node node = model.newNode(Label.label("FunctionName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ExplicitProcedureInvocationContext arg) {
		System.out.println("ExplicitProcedureInvocation");
		final Node node = model.newNode(Label.label("ExplicitProcedureInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ImplicitProcedureInvocationContext arg) {
		System.out.println("ImplicitProcedureInvocation");
		final Node node = model.newNode(Label.label("ImplicitProcedureInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureResultField(com.generator.generators.cypher.parser.CypherParser.ProcedureResultFieldContext arg) {
		System.out.println("ProcedureResultField");
		final Node node = model.newNode(Label.label("ProcedureResultField"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureName(com.generator.generators.cypher.parser.CypherParser.ProcedureNameContext arg) {
		System.out.println("ProcedureName");
		final Node node = model.newNode(Label.label("ProcedureName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespace(com.generator.generators.cypher.parser.CypherParser.NamespaceContext arg) {
		System.out.println("Namespace");
		final Node node = model.newNode(Label.label("Namespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListComprehension(com.generator.generators.cypher.parser.CypherParser.ListComprehensionContext arg) {
		System.out.println("ListComprehension");
		final Node node = model.newNode(Label.label("ListComprehension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternComprehension(com.generator.generators.cypher.parser.CypherParser.PatternComprehensionContext arg) {
		System.out.println("PatternComprehension");
		final Node node = model.newNode(Label.label("PatternComprehension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyLookup(com.generator.generators.cypher.parser.CypherParser.PropertyLookupContext arg) {
		System.out.println("PropertyLookup");
		final Node node = model.newNode(Label.label("PropertyLookup"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseExpression(com.generator.generators.cypher.parser.CypherParser.CaseExpressionContext arg) {
		System.out.println("CaseExpression");
		final Node node = model.newNode(Label.label("CaseExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseAlternatives(com.generator.generators.cypher.parser.CypherParser.CaseAlternativesContext arg) {
		System.out.println("CaseAlternatives");
		final Node node = model.newNode(Label.label("CaseAlternatives"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariable(com.generator.generators.cypher.parser.CypherParser.VariableContext arg) {
		System.out.println("Variable");
		final Node node = model.newNode(Label.label("Variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumberLiteral(com.generator.generators.cypher.parser.CypherParser.NumberLiteralContext arg) {
		System.out.println("NumberLiteral");
		final Node node = model.newNode(Label.label("NumberLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapLiteral(com.generator.generators.cypher.parser.CypherParser.MapLiteralContext arg) {
		System.out.println("MapLiteral");
		final Node node = model.newNode(Label.label("MapLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyExpression(com.generator.generators.cypher.parser.CypherParser.PropertyExpressionContext arg) {
		System.out.println("PropertyExpression");
		final Node node = model.newNode(Label.label("PropertyExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyKeyName(com.generator.generators.cypher.parser.CypherParser.PropertyKeyNameContext arg) {
		System.out.println("PropertyKeyName");
		final Node node = model.newNode(Label.label("PropertyKeyName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntegerLiteral(com.generator.generators.cypher.parser.CypherParser.IntegerLiteralContext arg) {
		System.out.println("IntegerLiteral");
		final Node node = model.newNode(Label.label("IntegerLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDoubleLiteral(com.generator.generators.cypher.parser.CypherParser.DoubleLiteralContext arg) {
		System.out.println("DoubleLiteral");
		final Node node = model.newNode(Label.label("DoubleLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSchemaName(com.generator.generators.cypher.parser.CypherParser.SchemaNameContext arg) {
		System.out.println("SchemaName");
		final Node node = model.newNode(Label.label("SchemaName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReservedWord(com.generator.generators.cypher.parser.CypherParser.ReservedWordContext arg) {
		System.out.println("ReservedWord");
		final Node node = model.newNode(Label.label("ReservedWord"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSymbolicName(com.generator.generators.cypher.parser.CypherParser.SymbolicNameContext arg) {
		System.out.println("SymbolicName");
		final Node node = model.newNode(Label.label("SymbolicName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLeftArrowHead(com.generator.generators.cypher.parser.CypherParser.LeftArrowHeadContext arg) {
		System.out.println("LeftArrowHead");
		final Node node = model.newNode(Label.label("LeftArrowHead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRightArrowHead(com.generator.generators.cypher.parser.CypherParser.RightArrowHeadContext arg) {
		System.out.println("RightArrowHead");
		final Node node = model.newNode(Label.label("RightArrowHead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDash(com.generator.generators.cypher.parser.CypherParser.DashContext arg) {
		System.out.println("Dash");
		final Node node = model.newNode(Label.label("Dash"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}