package com.generator.generators.cypher.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CypherNeoVisitor extends CypherBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CypherNeoVisitor.class);

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
		log.info("Atom");
		final Node node = model.newNode(Label.label("Atom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameter(com.generator.generators.cypher.parser.CypherParser.ParameterContext arg) {
		log.info("Parameter");
		final Node node = model.newNode(Label.label("Parameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.cypher.parser.CypherParser.LiteralContext arg) {
		log.info("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet(com.generator.generators.cypher.parser.CypherParser.SetContext arg) {
		log.info("Set");
		final Node node = model.newNode(Label.label("Set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		log.info("Expression");
		final Node node = model.newNode(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.cypher.parser.CypherParser.StatementContext arg) {
		log.info("Statement");
		final Node node = model.newNode(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher(com.generator.generators.cypher.parser.CypherParser.CypherContext arg) {
		log.info("Cypher");
		final Node node = model.newNode(Label.label("Cypher"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.cypher.parser.CypherParser.QueryContext arg) {
		log.info("Query");
		final Node node = model.newNode(Label.label("Query"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		log.info("RegularQuery");
		final Node node = model.newNode(Label.label("RegularQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnion(com.generator.generators.cypher.parser.CypherParser.UnionContext arg) {
		log.info("Union");
		final Node node = model.newNode(Label.label("Union"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingleQuery(com.generator.generators.cypher.parser.CypherParser.SingleQueryContext arg) {
		log.info("SingleQuery");
		final Node node = model.newNode(Label.label("SingleQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSinglePartQuery(com.generator.generators.cypher.parser.CypherParser.SinglePartQueryContext arg) {
		log.info("SinglePartQuery");
		final Node node = model.newNode(Label.label("SinglePartQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadOnlyEnd(com.generator.generators.cypher.parser.CypherParser.ReadOnlyEndContext arg) {
		log.info("ReadOnlyEnd");
		final Node node = model.newNode(Label.label("ReadOnlyEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadUpdateEnd(com.generator.generators.cypher.parser.CypherParser.ReadUpdateEndContext arg) {
		log.info("ReadUpdateEnd");
		final Node node = model.newNode(Label.label("ReadUpdateEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingEnd(com.generator.generators.cypher.parser.CypherParser.UpdatingEndContext arg) {
		log.info("UpdatingEnd");
		final Node node = model.newNode(Label.label("UpdatingEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiPartQuery(com.generator.generators.cypher.parser.CypherParser.MultiPartQueryContext arg) {
		log.info("MultiPartQuery");
		final Node node = model.newNode(Label.label("MultiPartQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadPart(com.generator.generators.cypher.parser.CypherParser.ReadPartContext arg) {
		log.info("ReadPart");
		final Node node = model.newNode(Label.label("ReadPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingPart(com.generator.generators.cypher.parser.CypherParser.UpdatingPartContext arg) {
		log.info("UpdatingPart");
		final Node node = model.newNode(Label.label("UpdatingPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingStartClause(com.generator.generators.cypher.parser.CypherParser.UpdatingStartClauseContext arg) {
		log.info("UpdatingStartClause");
		final Node node = model.newNode(Label.label("UpdatingStartClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUpdatingClause(com.generator.generators.cypher.parser.CypherParser.UpdatingClauseContext arg) {
		log.info("UpdatingClause");
		final Node node = model.newNode(Label.label("UpdatingClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReadingClause(com.generator.generators.cypher.parser.CypherParser.ReadingClauseContext arg) {
		log.info("ReadingClause");
		final Node node = model.newNode(Label.label("ReadingClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCyper_match(com.generator.generators.cypher.parser.CypherParser.Cyper_matchContext arg) {
		log.info("Cyper_match");
		final Node node = model.newNode(Label.label("Cyper_match"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnwind(com.generator.generators.cypher.parser.CypherParser.UnwindContext arg) {
		log.info("Unwind");
		final Node node = model.newNode(Label.label("Unwind"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMerge(com.generator.generators.cypher.parser.CypherParser.MergeContext arg) {
		log.info("Merge");
		final Node node = model.newNode(Label.label("Merge"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMergeAction(com.generator.generators.cypher.parser.CypherParser.MergeActionContext arg) {
		log.info("MergeAction");
		final Node node = model.newNode(Label.label("MergeAction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreate(com.generator.generators.cypher.parser.CypherParser.CreateContext arg) {
		log.info("Create");
		final Node node = model.newNode(Label.label("Create"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetItem(com.generator.generators.cypher.parser.CypherParser.SetItemContext arg) {
		log.info("SetItem");
		final Node node = model.newNode(Label.label("SetItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelete(com.generator.generators.cypher.parser.CypherParser.DeleteContext arg) {
		log.info("Delete");
		final Node node = model.newNode(Label.label("Delete"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemove(com.generator.generators.cypher.parser.CypherParser.RemoveContext arg) {
		log.info("Remove");
		final Node node = model.newNode(Label.label("Remove"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRemoveItem(com.generator.generators.cypher.parser.CypherParser.RemoveItemContext arg) {
		log.info("RemoveItem");
		final Node node = model.newNode(Label.label("RemoveItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInQueryCall(com.generator.generators.cypher.parser.CypherParser.InQueryCallContext arg) {
		log.info("InQueryCall");
		final Node node = model.newNode(Label.label("InQueryCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStandaloneCall(com.generator.generators.cypher.parser.CypherParser.StandaloneCallContext arg) {
		log.info("StandaloneCall");
		final Node node = model.newNode(Label.label("StandaloneCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItems(com.generator.generators.cypher.parser.CypherParser.YieldItemsContext arg) {
		log.info("YieldItems");
		final Node node = model.newNode(Label.label("YieldItems"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitYieldItem(com.generator.generators.cypher.parser.CypherParser.YieldItemContext arg) {
		log.info("YieldItem");
		final Node node = model.newNode(Label.label("YieldItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWith(com.generator.generators.cypher.parser.CypherParser.WithContext arg) {
		log.info("With");
		final Node node = model.newNode(Label.label("With"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCypher_return(com.generator.generators.cypher.parser.CypherParser.Cypher_returnContext arg) {
		log.info("Cypher_return");
		final Node node = model.newNode(Label.label("Cypher_return"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnBody(com.generator.generators.cypher.parser.CypherParser.ReturnBodyContext arg) {
		log.info("ReturnBody");
		final Node node = model.newNode(Label.label("ReturnBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItems(com.generator.generators.cypher.parser.CypherParser.ReturnItemsContext arg) {
		log.info("ReturnItems");
		final Node node = model.newNode(Label.label("ReturnItems"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnItem(com.generator.generators.cypher.parser.CypherParser.ReturnItemContext arg) {
		log.info("ReturnItem");
		final Node node = model.newNode(Label.label("ReturnItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrder(com.generator.generators.cypher.parser.CypherParser.OrderContext arg) {
		log.info("Order");
		final Node node = model.newNode(Label.label("Order"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSkip(com.generator.generators.cypher.parser.CypherParser.SkipContext arg) {
		log.info("Skip");
		final Node node = model.newNode(Label.label("Skip"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLimit(com.generator.generators.cypher.parser.CypherParser.LimitContext arg) {
		log.info("Limit");
		final Node node = model.newNode(Label.label("Limit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSortItem(com.generator.generators.cypher.parser.CypherParser.SortItemContext arg) {
		log.info("SortItem");
		final Node node = model.newNode(Label.label("SortItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWhere(com.generator.generators.cypher.parser.CypherParser.WhereContext arg) {
		log.info("Where");
		final Node node = model.newNode(Label.label("Where"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern(com.generator.generators.cypher.parser.CypherParser.PatternContext arg) {
		log.info("Pattern");
		final Node node = model.newNode(Label.label("Pattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternPart(com.generator.generators.cypher.parser.CypherParser.PatternPartContext arg) {
		log.info("PatternPart");
		final Node node = model.newNode(Label.label("PatternPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnonymousPatternPart(com.generator.generators.cypher.parser.CypherParser.AnonymousPatternPartContext arg) {
		log.info("AnonymousPatternPart");
		final Node node = model.newNode(Label.label("AnonymousPatternPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElement(com.generator.generators.cypher.parser.CypherParser.PatternElementContext arg) {
		log.info("PatternElement");
		final Node node = model.newNode(Label.label("PatternElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodePattern(com.generator.generators.cypher.parser.CypherParser.NodePatternContext arg) {
		log.info("NodePattern");
		final Node node = model.newNode(Label.label("NodePattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternElementChain(com.generator.generators.cypher.parser.CypherParser.PatternElementChainContext arg) {
		log.info("PatternElementChain");
		final Node node = model.newNode(Label.label("PatternElementChain"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipPatternContext arg) {
		log.info("RelationshipPattern");
		final Node node = model.newNode(Label.label("RelationshipPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipDetail(com.generator.generators.cypher.parser.CypherParser.RelationshipDetailContext arg) {
		log.info("RelationshipDetail");
		final Node node = model.newNode(Label.label("RelationshipDetail"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProperties(com.generator.generators.cypher.parser.CypherParser.PropertiesContext arg) {
		log.info("Properties");
		final Node node = model.newNode(Label.label("Properties"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipTypes(com.generator.generators.cypher.parser.CypherParser.RelationshipTypesContext arg) {
		log.info("RelationshipTypes");
		final Node node = model.newNode(Label.label("RelationshipTypes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabels(com.generator.generators.cypher.parser.CypherParser.NodeLabelsContext arg) {
		log.info("NodeLabels");
		final Node node = model.newNode(Label.label("NodeLabels"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNodeLabel(com.generator.generators.cypher.parser.CypherParser.NodeLabelContext arg) {
		log.info("NodeLabel");
		final Node node = model.newNode(Label.label("NodeLabel"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRangeLiteral(com.generator.generators.cypher.parser.CypherParser.RangeLiteralContext arg) {
		log.info("RangeLiteral");
		final Node node = model.newNode(Label.label("RangeLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabelName(com.generator.generators.cypher.parser.CypherParser.LabelNameContext arg) {
		log.info("LabelName");
		final Node node = model.newNode(Label.label("LabelName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelTypeName(com.generator.generators.cypher.parser.CypherParser.RelTypeNameContext arg) {
		log.info("RelTypeName");
		final Node node = model.newNode(Label.label("RelTypeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOrExpression(com.generator.generators.cypher.parser.CypherParser.OrExpressionContext arg) {
		log.info("OrExpression");
		final Node node = model.newNode(Label.label("OrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXorExpression(com.generator.generators.cypher.parser.CypherParser.XorExpressionContext arg) {
		log.info("XorExpression");
		final Node node = model.newNode(Label.label("XorExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndExpression(com.generator.generators.cypher.parser.CypherParser.AndExpressionContext arg) {
		log.info("AndExpression");
		final Node node = model.newNode(Label.label("AndExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotExpression(com.generator.generators.cypher.parser.CypherParser.NotExpressionContext arg) {
		log.info("NotExpression");
		final Node node = model.newNode(Label.label("NotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComparisonExpression(com.generator.generators.cypher.parser.CypherParser.ComparisonExpressionContext arg) {
		log.info("ComparisonExpression");
		final Node node = model.newNode(Label.label("ComparisonExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.AddOrSubtractExpressionContext arg) {
		log.info("AddOrSubtractExpression");
		final Node node = model.newNode(Label.label("AddOrSubtractExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplyDivideModuloExpression(com.generator.generators.cypher.parser.CypherParser.MultiplyDivideModuloExpressionContext arg) {
		log.info("MultiplyDivideModuloExpression");
		final Node node = model.newNode(Label.label("MultiplyDivideModuloExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPowerOfExpression(com.generator.generators.cypher.parser.CypherParser.PowerOfExpressionContext arg) {
		log.info("PowerOfExpression");
		final Node node = model.newNode(Label.label("PowerOfExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.UnaryAddOrSubtractExpressionContext arg) {
		log.info("UnaryAddOrSubtractExpression");
		final Node node = model.newNode(Label.label("UnaryAddOrSubtractExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStringListNullOperatorExpression(com.generator.generators.cypher.parser.CypherParser.StringListNullOperatorExpressionContext arg) {
		log.info("StringListNullOperatorExpression");
		final Node node = model.newNode(Label.label("StringListNullOperatorExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyOrLabelsExpression(com.generator.generators.cypher.parser.CypherParser.PropertyOrLabelsExpressionContext arg) {
		log.info("PropertyOrLabelsExpression");
		final Node node = model.newNode(Label.label("PropertyOrLabelsExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanLiteral(com.generator.generators.cypher.parser.CypherParser.BooleanLiteralContext arg) {
		log.info("BooleanLiteral");
		final Node node = model.newNode(Label.label("BooleanLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListLiteral(com.generator.generators.cypher.parser.CypherParser.ListLiteralContext arg) {
		log.info("ListLiteral");
		final Node node = model.newNode(Label.label("ListLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPartialComparisonExpression(com.generator.generators.cypher.parser.CypherParser.PartialComparisonExpressionContext arg) {
		log.info("PartialComparisonExpression");
		final Node node = model.newNode(Label.label("PartialComparisonExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParenthesizedExpression(com.generator.generators.cypher.parser.CypherParser.ParenthesizedExpressionContext arg) {
		log.info("ParenthesizedExpression");
		final Node node = model.newNode(Label.label("ParenthesizedExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationshipsPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipsPatternContext arg) {
		log.info("RelationshipsPattern");
		final Node node = model.newNode(Label.label("RelationshipsPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFilterExpression(com.generator.generators.cypher.parser.CypherParser.FilterExpressionContext arg) {
		log.info("FilterExpression");
		final Node node = model.newNode(Label.label("FilterExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdInColl(com.generator.generators.cypher.parser.CypherParser.IdInCollContext arg) {
		log.info("IdInColl");
		final Node node = model.newNode(Label.label("IdInColl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionInvocation(com.generator.generators.cypher.parser.CypherParser.FunctionInvocationContext arg) {
		log.info("FunctionInvocation");
		final Node node = model.newNode(Label.label("FunctionInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionName(com.generator.generators.cypher.parser.CypherParser.FunctionNameContext arg) {
		log.info("FunctionName");
		final Node node = model.newNode(Label.label("FunctionName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ExplicitProcedureInvocationContext arg) {
		log.info("ExplicitProcedureInvocation");
		final Node node = model.newNode(Label.label("ExplicitProcedureInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ImplicitProcedureInvocationContext arg) {
		log.info("ImplicitProcedureInvocation");
		final Node node = model.newNode(Label.label("ImplicitProcedureInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureResultField(com.generator.generators.cypher.parser.CypherParser.ProcedureResultFieldContext arg) {
		log.info("ProcedureResultField");
		final Node node = model.newNode(Label.label("ProcedureResultField"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProcedureName(com.generator.generators.cypher.parser.CypherParser.ProcedureNameContext arg) {
		log.info("ProcedureName");
		final Node node = model.newNode(Label.label("ProcedureName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespace(com.generator.generators.cypher.parser.CypherParser.NamespaceContext arg) {
		log.info("Namespace");
		final Node node = model.newNode(Label.label("Namespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListComprehension(com.generator.generators.cypher.parser.CypherParser.ListComprehensionContext arg) {
		log.info("ListComprehension");
		final Node node = model.newNode(Label.label("ListComprehension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatternComprehension(com.generator.generators.cypher.parser.CypherParser.PatternComprehensionContext arg) {
		log.info("PatternComprehension");
		final Node node = model.newNode(Label.label("PatternComprehension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyLookup(com.generator.generators.cypher.parser.CypherParser.PropertyLookupContext arg) {
		log.info("PropertyLookup");
		final Node node = model.newNode(Label.label("PropertyLookup"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseExpression(com.generator.generators.cypher.parser.CypherParser.CaseExpressionContext arg) {
		log.info("CaseExpression");
		final Node node = model.newNode(Label.label("CaseExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseAlternatives(com.generator.generators.cypher.parser.CypherParser.CaseAlternativesContext arg) {
		log.info("CaseAlternatives");
		final Node node = model.newNode(Label.label("CaseAlternatives"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariable(com.generator.generators.cypher.parser.CypherParser.VariableContext arg) {
		log.info("Variable");
		final Node node = model.newNode(Label.label("Variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumberLiteral(com.generator.generators.cypher.parser.CypherParser.NumberLiteralContext arg) {
		log.info("NumberLiteral");
		final Node node = model.newNode(Label.label("NumberLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapLiteral(com.generator.generators.cypher.parser.CypherParser.MapLiteralContext arg) {
		log.info("MapLiteral");
		final Node node = model.newNode(Label.label("MapLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyExpression(com.generator.generators.cypher.parser.CypherParser.PropertyExpressionContext arg) {
		log.info("PropertyExpression");
		final Node node = model.newNode(Label.label("PropertyExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyKeyName(com.generator.generators.cypher.parser.CypherParser.PropertyKeyNameContext arg) {
		log.info("PropertyKeyName");
		final Node node = model.newNode(Label.label("PropertyKeyName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntegerLiteral(com.generator.generators.cypher.parser.CypherParser.IntegerLiteralContext arg) {
		log.info("IntegerLiteral");
		final Node node = model.newNode(Label.label("IntegerLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDoubleLiteral(com.generator.generators.cypher.parser.CypherParser.DoubleLiteralContext arg) {
		log.info("DoubleLiteral");
		final Node node = model.newNode(Label.label("DoubleLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSchemaName(com.generator.generators.cypher.parser.CypherParser.SchemaNameContext arg) {
		log.info("SchemaName");
		final Node node = model.newNode(Label.label("SchemaName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReservedWord(com.generator.generators.cypher.parser.CypherParser.ReservedWordContext arg) {
		log.info("ReservedWord");
		final Node node = model.newNode(Label.label("ReservedWord"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSymbolicName(com.generator.generators.cypher.parser.CypherParser.SymbolicNameContext arg) {
		log.info("SymbolicName");
		final Node node = model.newNode(Label.label("SymbolicName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLeftArrowHead(com.generator.generators.cypher.parser.CypherParser.LeftArrowHeadContext arg) {
		log.info("LeftArrowHead");
		final Node node = model.newNode(Label.label("LeftArrowHead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRightArrowHead(com.generator.generators.cypher.parser.CypherParser.RightArrowHeadContext arg) {
		log.info("RightArrowHead");
		final Node node = model.newNode(Label.label("RightArrowHead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDash(com.generator.generators.cypher.parser.CypherParser.DashContext arg) {
		log.info("Dash");
		final Node node = model.newNode(Label.label("Dash"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}