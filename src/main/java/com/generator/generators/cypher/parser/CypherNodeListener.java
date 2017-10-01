package com.generator.generators.cypher.parser;

public class CypherNodeListener extends CypherBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public CypherNodeListener() {
		this(false);
	}

	public CypherNodeListener(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " '" + node.value + "'");
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

	protected java.util.Stack<Boolean> inAtom = new java.util.Stack<>();

	@Override
	public void enterAtom(com.generator.generators.cypher.parser.CypherParser.AtomContext arg) {
		onEnter(new Node("Atom", arg.getText(), arg.getStart().getText()));
		this.inAtom.push(true);
	}

	public void exitAtom(com.generator.generators.cypher.parser.CypherParser.AtomContext arg) {
		onExit();
		this.inAtom.pop();
	}

	public boolean inAtom() {
      return !inAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.cypher.parser.CypherParser.StatementContext arg) {
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.cypher.parser.CypherParser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return !inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSet = new java.util.Stack<>();

	@Override
	public void enterSet(com.generator.generators.cypher.parser.CypherParser.SetContext arg) {
		onEnter(new Node("Set", arg.getText(), arg.getStart().getText()));
		this.inSet.push(true);
	}

	public void exitSet(com.generator.generators.cypher.parser.CypherParser.SetContext arg) {
		onExit();
		this.inSet.pop();
	}

	public boolean inSet() {
      return !inSet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.cypher.parser.CypherParser.LiteralContext arg) {
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.cypher.parser.CypherParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		onEnter(new Node("Expression", arg.getText(), arg.getStart().getText()));
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCypher = new java.util.Stack<>();

	@Override
	public void enterCypher(com.generator.generators.cypher.parser.CypherParser.CypherContext arg) {
		onEnter(new Node("Cypher", arg.getText(), arg.getStart().getText()));
		this.inCypher.push(true);
	}

	public void exitCypher(com.generator.generators.cypher.parser.CypherParser.CypherContext arg) {
		onExit();
		this.inCypher.pop();
	}

	public boolean inCypher() {
      return !inCypher.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery = new java.util.Stack<>();

	@Override
	public void enterQuery(com.generator.generators.cypher.parser.CypherParser.QueryContext arg) {
		onEnter(new Node("Query", arg.getText(), arg.getStart().getText()));
		this.inQuery.push(true);
	}

	public void exitQuery(com.generator.generators.cypher.parser.CypherParser.QueryContext arg) {
		onExit();
		this.inQuery.pop();
	}

	public boolean inQuery() {
      return !inQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnion = new java.util.Stack<>();

	@Override
	public void enterUnion(com.generator.generators.cypher.parser.CypherParser.UnionContext arg) {
		onEnter(new Node("Union", arg.getText(), arg.getStart().getText()));
		this.inUnion.push(true);
	}

	public void exitUnion(com.generator.generators.cypher.parser.CypherParser.UnionContext arg) {
		onExit();
		this.inUnion.pop();
	}

	public boolean inUnion() {
      return !inUnion.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSingleQuery = new java.util.Stack<>();

	@Override
	public void enterSingleQuery(com.generator.generators.cypher.parser.CypherParser.SingleQueryContext arg) {
		onEnter(new Node("SingleQuery", arg.getText(), arg.getStart().getText()));
		this.inSingleQuery.push(true);
	}

	public void exitSingleQuery(com.generator.generators.cypher.parser.CypherParser.SingleQueryContext arg) {
		onExit();
		this.inSingleQuery.pop();
	}

	public boolean inSingleQuery() {
      return !inSingleQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSinglePartQuery = new java.util.Stack<>();

	@Override
	public void enterSinglePartQuery(com.generator.generators.cypher.parser.CypherParser.SinglePartQueryContext arg) {
		onEnter(new Node("SinglePartQuery", arg.getText(), arg.getStart().getText()));
		this.inSinglePartQuery.push(true);
	}

	public void exitSinglePartQuery(com.generator.generators.cypher.parser.CypherParser.SinglePartQueryContext arg) {
		onExit();
		this.inSinglePartQuery.pop();
	}

	public boolean inSinglePartQuery() {
      return !inSinglePartQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReadOnlyEnd = new java.util.Stack<>();

	@Override
	public void enterReadOnlyEnd(com.generator.generators.cypher.parser.CypherParser.ReadOnlyEndContext arg) {
		onEnter(new Node("ReadOnlyEnd", arg.getText(), arg.getStart().getText()));
		this.inReadOnlyEnd.push(true);
	}

	public void exitReadOnlyEnd(com.generator.generators.cypher.parser.CypherParser.ReadOnlyEndContext arg) {
		onExit();
		this.inReadOnlyEnd.pop();
	}

	public boolean inReadOnlyEnd() {
      return !inReadOnlyEnd.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReadUpdateEnd = new java.util.Stack<>();

	@Override
	public void enterReadUpdateEnd(com.generator.generators.cypher.parser.CypherParser.ReadUpdateEndContext arg) {
		onEnter(new Node("ReadUpdateEnd", arg.getText(), arg.getStart().getText()));
		this.inReadUpdateEnd.push(true);
	}

	public void exitReadUpdateEnd(com.generator.generators.cypher.parser.CypherParser.ReadUpdateEndContext arg) {
		onExit();
		this.inReadUpdateEnd.pop();
	}

	public boolean inReadUpdateEnd() {
      return !inReadUpdateEnd.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUpdatingEnd = new java.util.Stack<>();

	@Override
	public void enterUpdatingEnd(com.generator.generators.cypher.parser.CypherParser.UpdatingEndContext arg) {
		onEnter(new Node("UpdatingEnd", arg.getText(), arg.getStart().getText()));
		this.inUpdatingEnd.push(true);
	}

	public void exitUpdatingEnd(com.generator.generators.cypher.parser.CypherParser.UpdatingEndContext arg) {
		onExit();
		this.inUpdatingEnd.pop();
	}

	public boolean inUpdatingEnd() {
      return !inUpdatingEnd.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiPartQuery = new java.util.Stack<>();

	@Override
	public void enterMultiPartQuery(com.generator.generators.cypher.parser.CypherParser.MultiPartQueryContext arg) {
		onEnter(new Node("MultiPartQuery", arg.getText(), arg.getStart().getText()));
		this.inMultiPartQuery.push(true);
	}

	public void exitMultiPartQuery(com.generator.generators.cypher.parser.CypherParser.MultiPartQueryContext arg) {
		onExit();
		this.inMultiPartQuery.pop();
	}

	public boolean inMultiPartQuery() {
      return !inMultiPartQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReadPart = new java.util.Stack<>();

	@Override
	public void enterReadPart(com.generator.generators.cypher.parser.CypherParser.ReadPartContext arg) {
		onEnter(new Node("ReadPart", arg.getText(), arg.getStart().getText()));
		this.inReadPart.push(true);
	}

	public void exitReadPart(com.generator.generators.cypher.parser.CypherParser.ReadPartContext arg) {
		onExit();
		this.inReadPart.pop();
	}

	public boolean inReadPart() {
      return !inReadPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUpdatingPart = new java.util.Stack<>();

	@Override
	public void enterUpdatingPart(com.generator.generators.cypher.parser.CypherParser.UpdatingPartContext arg) {
		onEnter(new Node("UpdatingPart", arg.getText(), arg.getStart().getText()));
		this.inUpdatingPart.push(true);
	}

	public void exitUpdatingPart(com.generator.generators.cypher.parser.CypherParser.UpdatingPartContext arg) {
		onExit();
		this.inUpdatingPart.pop();
	}

	public boolean inUpdatingPart() {
      return !inUpdatingPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUpdatingStartClause = new java.util.Stack<>();

	@Override
	public void enterUpdatingStartClause(com.generator.generators.cypher.parser.CypherParser.UpdatingStartClauseContext arg) {
		onEnter(new Node("UpdatingStartClause", arg.getText(), arg.getStart().getText()));
		this.inUpdatingStartClause.push(true);
	}

	public void exitUpdatingStartClause(com.generator.generators.cypher.parser.CypherParser.UpdatingStartClauseContext arg) {
		onExit();
		this.inUpdatingStartClause.pop();
	}

	public boolean inUpdatingStartClause() {
      return !inUpdatingStartClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUpdatingClause = new java.util.Stack<>();

	@Override
	public void enterUpdatingClause(com.generator.generators.cypher.parser.CypherParser.UpdatingClauseContext arg) {
		onEnter(new Node("UpdatingClause", arg.getText(), arg.getStart().getText()));
		this.inUpdatingClause.push(true);
	}

	public void exitUpdatingClause(com.generator.generators.cypher.parser.CypherParser.UpdatingClauseContext arg) {
		onExit();
		this.inUpdatingClause.pop();
	}

	public boolean inUpdatingClause() {
      return !inUpdatingClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReadingClause = new java.util.Stack<>();

	@Override
	public void enterReadingClause(com.generator.generators.cypher.parser.CypherParser.ReadingClauseContext arg) {
		onEnter(new Node("ReadingClause", arg.getText(), arg.getStart().getText()));
		this.inReadingClause.push(true);
	}

	public void exitReadingClause(com.generator.generators.cypher.parser.CypherParser.ReadingClauseContext arg) {
		onExit();
		this.inReadingClause.pop();
	}

	public boolean inReadingClause() {
      return !inReadingClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCyper_match = new java.util.Stack<>();

	@Override
	public void enterCyper_match(com.generator.generators.cypher.parser.CypherParser.Cyper_matchContext arg) {
		onEnter(new Node("Cyper_match", arg.getText(), arg.getStart().getText()));
		this.inCyper_match.push(true);
	}

	public void exitCyper_match(com.generator.generators.cypher.parser.CypherParser.Cyper_matchContext arg) {
		onExit();
		this.inCyper_match.pop();
	}

	public boolean inCyper_match() {
      return !inCyper_match.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnwind = new java.util.Stack<>();

	@Override
	public void enterUnwind(com.generator.generators.cypher.parser.CypherParser.UnwindContext arg) {
		onEnter(new Node("Unwind", arg.getText(), arg.getStart().getText()));
		this.inUnwind.push(true);
	}

	public void exitUnwind(com.generator.generators.cypher.parser.CypherParser.UnwindContext arg) {
		onExit();
		this.inUnwind.pop();
	}

	public boolean inUnwind() {
      return !inUnwind.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMerge = new java.util.Stack<>();

	@Override
	public void enterMerge(com.generator.generators.cypher.parser.CypherParser.MergeContext arg) {
		onEnter(new Node("Merge", arg.getText(), arg.getStart().getText()));
		this.inMerge.push(true);
	}

	public void exitMerge(com.generator.generators.cypher.parser.CypherParser.MergeContext arg) {
		onExit();
		this.inMerge.pop();
	}

	public boolean inMerge() {
      return !inMerge.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMergeAction = new java.util.Stack<>();

	@Override
	public void enterMergeAction(com.generator.generators.cypher.parser.CypherParser.MergeActionContext arg) {
		onEnter(new Node("MergeAction", arg.getText(), arg.getStart().getText()));
		this.inMergeAction.push(true);
	}

	public void exitMergeAction(com.generator.generators.cypher.parser.CypherParser.MergeActionContext arg) {
		onExit();
		this.inMergeAction.pop();
	}

	public boolean inMergeAction() {
      return !inMergeAction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreate = new java.util.Stack<>();

	@Override
	public void enterCreate(com.generator.generators.cypher.parser.CypherParser.CreateContext arg) {
		onEnter(new Node("Create", arg.getText(), arg.getStart().getText()));
		this.inCreate.push(true);
	}

	public void exitCreate(com.generator.generators.cypher.parser.CypherParser.CreateContext arg) {
		onExit();
		this.inCreate.pop();
	}

	public boolean inCreate() {
      return !inCreate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetItem = new java.util.Stack<>();

	@Override
	public void enterSetItem(com.generator.generators.cypher.parser.CypherParser.SetItemContext arg) {
		onEnter(new Node("SetItem", arg.getText(), arg.getStart().getText()));
		this.inSetItem.push(true);
	}

	public void exitSetItem(com.generator.generators.cypher.parser.CypherParser.SetItemContext arg) {
		onExit();
		this.inSetItem.pop();
	}

	public boolean inSetItem() {
      return !inSetItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDelete = new java.util.Stack<>();

	@Override
	public void enterDelete(com.generator.generators.cypher.parser.CypherParser.DeleteContext arg) {
		onEnter(new Node("Delete", arg.getText(), arg.getStart().getText()));
		this.inDelete.push(true);
	}

	public void exitDelete(com.generator.generators.cypher.parser.CypherParser.DeleteContext arg) {
		onExit();
		this.inDelete.pop();
	}

	public boolean inDelete() {
      return !inDelete.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRemove = new java.util.Stack<>();

	@Override
	public void enterRemove(com.generator.generators.cypher.parser.CypherParser.RemoveContext arg) {
		onEnter(new Node("Remove", arg.getText(), arg.getStart().getText()));
		this.inRemove.push(true);
	}

	public void exitRemove(com.generator.generators.cypher.parser.CypherParser.RemoveContext arg) {
		onExit();
		this.inRemove.pop();
	}

	public boolean inRemove() {
      return !inRemove.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRemoveItem = new java.util.Stack<>();

	@Override
	public void enterRemoveItem(com.generator.generators.cypher.parser.CypherParser.RemoveItemContext arg) {
		onEnter(new Node("RemoveItem", arg.getText(), arg.getStart().getText()));
		this.inRemoveItem.push(true);
	}

	public void exitRemoveItem(com.generator.generators.cypher.parser.CypherParser.RemoveItemContext arg) {
		onExit();
		this.inRemoveItem.pop();
	}

	public boolean inRemoveItem() {
      return !inRemoveItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInQueryCall = new java.util.Stack<>();

	@Override
	public void enterInQueryCall(com.generator.generators.cypher.parser.CypherParser.InQueryCallContext arg) {
		onEnter(new Node("InQueryCall", arg.getText(), arg.getStart().getText()));
		this.inInQueryCall.push(true);
	}

	public void exitInQueryCall(com.generator.generators.cypher.parser.CypherParser.InQueryCallContext arg) {
		onExit();
		this.inInQueryCall.pop();
	}

	public boolean inInQueryCall() {
      return !inInQueryCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStandaloneCall = new java.util.Stack<>();

	@Override
	public void enterStandaloneCall(com.generator.generators.cypher.parser.CypherParser.StandaloneCallContext arg) {
		onEnter(new Node("StandaloneCall", arg.getText(), arg.getStart().getText()));
		this.inStandaloneCall.push(true);
	}

	public void exitStandaloneCall(com.generator.generators.cypher.parser.CypherParser.StandaloneCallContext arg) {
		onExit();
		this.inStandaloneCall.pop();
	}

	public boolean inStandaloneCall() {
      return !inStandaloneCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inYieldItems = new java.util.Stack<>();

	@Override
	public void enterYieldItems(com.generator.generators.cypher.parser.CypherParser.YieldItemsContext arg) {
		onEnter(new Node("YieldItems", arg.getText(), arg.getStart().getText()));
		this.inYieldItems.push(true);
	}

	public void exitYieldItems(com.generator.generators.cypher.parser.CypherParser.YieldItemsContext arg) {
		onExit();
		this.inYieldItems.pop();
	}

	public boolean inYieldItems() {
      return !inYieldItems.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inYieldItem = new java.util.Stack<>();

	@Override
	public void enterYieldItem(com.generator.generators.cypher.parser.CypherParser.YieldItemContext arg) {
		onEnter(new Node("YieldItem", arg.getText(), arg.getStart().getText()));
		this.inYieldItem.push(true);
	}

	public void exitYieldItem(com.generator.generators.cypher.parser.CypherParser.YieldItemContext arg) {
		onExit();
		this.inYieldItem.pop();
	}

	public boolean inYieldItem() {
      return !inYieldItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWith = new java.util.Stack<>();

	@Override
	public void enterWith(com.generator.generators.cypher.parser.CypherParser.WithContext arg) {
		onEnter(new Node("With", arg.getText(), arg.getStart().getText()));
		this.inWith.push(true);
	}

	public void exitWith(com.generator.generators.cypher.parser.CypherParser.WithContext arg) {
		onExit();
		this.inWith.pop();
	}

	public boolean inWith() {
      return !inWith.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCypher_return = new java.util.Stack<>();

	@Override
	public void enterCypher_return(com.generator.generators.cypher.parser.CypherParser.Cypher_returnContext arg) {
		onEnter(new Node("Cypher_return", arg.getText(), arg.getStart().getText()));
		this.inCypher_return.push(true);
	}

	public void exitCypher_return(com.generator.generators.cypher.parser.CypherParser.Cypher_returnContext arg) {
		onExit();
		this.inCypher_return.pop();
	}

	public boolean inCypher_return() {
      return !inCypher_return.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturnBody = new java.util.Stack<>();

	@Override
	public void enterReturnBody(com.generator.generators.cypher.parser.CypherParser.ReturnBodyContext arg) {
		onEnter(new Node("ReturnBody", arg.getText(), arg.getStart().getText()));
		this.inReturnBody.push(true);
	}

	public void exitReturnBody(com.generator.generators.cypher.parser.CypherParser.ReturnBodyContext arg) {
		onExit();
		this.inReturnBody.pop();
	}

	public boolean inReturnBody() {
      return !inReturnBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturnItems = new java.util.Stack<>();

	@Override
	public void enterReturnItems(com.generator.generators.cypher.parser.CypherParser.ReturnItemsContext arg) {
		onEnter(new Node("ReturnItems", arg.getText(), arg.getStart().getText()));
		this.inReturnItems.push(true);
	}

	public void exitReturnItems(com.generator.generators.cypher.parser.CypherParser.ReturnItemsContext arg) {
		onExit();
		this.inReturnItems.pop();
	}

	public boolean inReturnItems() {
      return !inReturnItems.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReturnItem = new java.util.Stack<>();

	@Override
	public void enterReturnItem(com.generator.generators.cypher.parser.CypherParser.ReturnItemContext arg) {
		onEnter(new Node("ReturnItem", arg.getText(), arg.getStart().getText()));
		this.inReturnItem.push(true);
	}

	public void exitReturnItem(com.generator.generators.cypher.parser.CypherParser.ReturnItemContext arg) {
		onExit();
		this.inReturnItem.pop();
	}

	public boolean inReturnItem() {
      return !inReturnItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrder = new java.util.Stack<>();

	@Override
	public void enterOrder(com.generator.generators.cypher.parser.CypherParser.OrderContext arg) {
		onEnter(new Node("Order", arg.getText(), arg.getStart().getText()));
		this.inOrder.push(true);
	}

	public void exitOrder(com.generator.generators.cypher.parser.CypherParser.OrderContext arg) {
		onExit();
		this.inOrder.pop();
	}

	public boolean inOrder() {
      return !inOrder.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSkip = new java.util.Stack<>();

	@Override
	public void enterSkip(com.generator.generators.cypher.parser.CypherParser.SkipContext arg) {
		onEnter(new Node("Skip", arg.getText(), arg.getStart().getText()));
		this.inSkip.push(true);
	}

	public void exitSkip(com.generator.generators.cypher.parser.CypherParser.SkipContext arg) {
		onExit();
		this.inSkip.pop();
	}

	public boolean inSkip() {
      return !inSkip.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLimit = new java.util.Stack<>();

	@Override
	public void enterLimit(com.generator.generators.cypher.parser.CypherParser.LimitContext arg) {
		onEnter(new Node("Limit", arg.getText(), arg.getStart().getText()));
		this.inLimit.push(true);
	}

	public void exitLimit(com.generator.generators.cypher.parser.CypherParser.LimitContext arg) {
		onExit();
		this.inLimit.pop();
	}

	public boolean inLimit() {
      return !inLimit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSortItem = new java.util.Stack<>();

	@Override
	public void enterSortItem(com.generator.generators.cypher.parser.CypherParser.SortItemContext arg) {
		onEnter(new Node("SortItem", arg.getText(), arg.getStart().getText()));
		this.inSortItem.push(true);
	}

	public void exitSortItem(com.generator.generators.cypher.parser.CypherParser.SortItemContext arg) {
		onExit();
		this.inSortItem.pop();
	}

	public boolean inSortItem() {
      return !inSortItem.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWhere = new java.util.Stack<>();

	@Override
	public void enterWhere(com.generator.generators.cypher.parser.CypherParser.WhereContext arg) {
		onEnter(new Node("Where", arg.getText(), arg.getStart().getText()));
		this.inWhere.push(true);
	}

	public void exitWhere(com.generator.generators.cypher.parser.CypherParser.WhereContext arg) {
		onExit();
		this.inWhere.pop();
	}

	public boolean inWhere() {
      return !inWhere.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPattern = new java.util.Stack<>();

	@Override
	public void enterPattern(com.generator.generators.cypher.parser.CypherParser.PatternContext arg) {
		onEnter(new Node("Pattern", arg.getText(), arg.getStart().getText()));
		this.inPattern.push(true);
	}

	public void exitPattern(com.generator.generators.cypher.parser.CypherParser.PatternContext arg) {
		onExit();
		this.inPattern.pop();
	}

	public boolean inPattern() {
      return !inPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPatternPart = new java.util.Stack<>();

	@Override
	public void enterPatternPart(com.generator.generators.cypher.parser.CypherParser.PatternPartContext arg) {
		onEnter(new Node("PatternPart", arg.getText(), arg.getStart().getText()));
		this.inPatternPart.push(true);
	}

	public void exitPatternPart(com.generator.generators.cypher.parser.CypherParser.PatternPartContext arg) {
		onExit();
		this.inPatternPart.pop();
	}

	public boolean inPatternPart() {
      return !inPatternPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnonymousPatternPart = new java.util.Stack<>();

	@Override
	public void enterAnonymousPatternPart(com.generator.generators.cypher.parser.CypherParser.AnonymousPatternPartContext arg) {
		onEnter(new Node("AnonymousPatternPart", arg.getText(), arg.getStart().getText()));
		this.inAnonymousPatternPart.push(true);
	}

	public void exitAnonymousPatternPart(com.generator.generators.cypher.parser.CypherParser.AnonymousPatternPartContext arg) {
		onExit();
		this.inAnonymousPatternPart.pop();
	}

	public boolean inAnonymousPatternPart() {
      return !inAnonymousPatternPart.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPatternElement = new java.util.Stack<>();

	@Override
	public void enterPatternElement(com.generator.generators.cypher.parser.CypherParser.PatternElementContext arg) {
		onEnter(new Node("PatternElement", arg.getText(), arg.getStart().getText()));
		this.inPatternElement.push(true);
	}

	public void exitPatternElement(com.generator.generators.cypher.parser.CypherParser.PatternElementContext arg) {
		onExit();
		this.inPatternElement.pop();
	}

	public boolean inPatternElement() {
      return !inPatternElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNodePattern = new java.util.Stack<>();

	@Override
	public void enterNodePattern(com.generator.generators.cypher.parser.CypherParser.NodePatternContext arg) {
		onEnter(new Node("NodePattern", arg.getText(), arg.getStart().getText()));
		this.inNodePattern.push(true);
	}

	public void exitNodePattern(com.generator.generators.cypher.parser.CypherParser.NodePatternContext arg) {
		onExit();
		this.inNodePattern.pop();
	}

	public boolean inNodePattern() {
      return !inNodePattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPatternElementChain = new java.util.Stack<>();

	@Override
	public void enterPatternElementChain(com.generator.generators.cypher.parser.CypherParser.PatternElementChainContext arg) {
		onEnter(new Node("PatternElementChain", arg.getText(), arg.getStart().getText()));
		this.inPatternElementChain.push(true);
	}

	public void exitPatternElementChain(com.generator.generators.cypher.parser.CypherParser.PatternElementChainContext arg) {
		onExit();
		this.inPatternElementChain.pop();
	}

	public boolean inPatternElementChain() {
      return !inPatternElementChain.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationshipPattern = new java.util.Stack<>();

	@Override
	public void enterRelationshipPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipPatternContext arg) {
		onEnter(new Node("RelationshipPattern", arg.getText(), arg.getStart().getText()));
		this.inRelationshipPattern.push(true);
	}

	public void exitRelationshipPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipPatternContext arg) {
		onExit();
		this.inRelationshipPattern.pop();
	}

	public boolean inRelationshipPattern() {
      return !inRelationshipPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationshipDetail = new java.util.Stack<>();

	@Override
	public void enterRelationshipDetail(com.generator.generators.cypher.parser.CypherParser.RelationshipDetailContext arg) {
		onEnter(new Node("RelationshipDetail", arg.getText(), arg.getStart().getText()));
		this.inRelationshipDetail.push(true);
	}

	public void exitRelationshipDetail(com.generator.generators.cypher.parser.CypherParser.RelationshipDetailContext arg) {
		onExit();
		this.inRelationshipDetail.pop();
	}

	public boolean inRelationshipDetail() {
      return !inRelationshipDetail.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRegularQuery = new java.util.Stack<>();

	@Override
	public void enterRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		onEnter(new Node("RegularQuery", arg.getText(), arg.getStart().getText()));
		this.inRegularQuery.push(true);
	}

	public void exitRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		onExit();
		this.inRegularQuery.pop();
	}

	public boolean inRegularQuery() {
      return !inRegularQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProperties = new java.util.Stack<>();

	@Override
	public void enterProperties(com.generator.generators.cypher.parser.CypherParser.PropertiesContext arg) {
		onEnter(new Node("Properties", arg.getText(), arg.getStart().getText()));
		this.inProperties.push(true);
	}

	public void exitProperties(com.generator.generators.cypher.parser.CypherParser.PropertiesContext arg) {
		onExit();
		this.inProperties.pop();
	}

	public boolean inProperties() {
      return !inProperties.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationshipTypes = new java.util.Stack<>();

	@Override
	public void enterRelationshipTypes(com.generator.generators.cypher.parser.CypherParser.RelationshipTypesContext arg) {
		onEnter(new Node("RelationshipTypes", arg.getText(), arg.getStart().getText()));
		this.inRelationshipTypes.push(true);
	}

	public void exitRelationshipTypes(com.generator.generators.cypher.parser.CypherParser.RelationshipTypesContext arg) {
		onExit();
		this.inRelationshipTypes.pop();
	}

	public boolean inRelationshipTypes() {
      return !inRelationshipTypes.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNodeLabels = new java.util.Stack<>();

	@Override
	public void enterNodeLabels(com.generator.generators.cypher.parser.CypherParser.NodeLabelsContext arg) {
		onEnter(new Node("NodeLabels", arg.getText(), arg.getStart().getText()));
		this.inNodeLabels.push(true);
	}

	public void exitNodeLabels(com.generator.generators.cypher.parser.CypherParser.NodeLabelsContext arg) {
		onExit();
		this.inNodeLabels.pop();
	}

	public boolean inNodeLabels() {
      return !inNodeLabels.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNodeLabel = new java.util.Stack<>();

	@Override
	public void enterNodeLabel(com.generator.generators.cypher.parser.CypherParser.NodeLabelContext arg) {
		onEnter(new Node("NodeLabel", arg.getText(), arg.getStart().getText()));
		this.inNodeLabel.push(true);
	}

	public void exitNodeLabel(com.generator.generators.cypher.parser.CypherParser.NodeLabelContext arg) {
		onExit();
		this.inNodeLabel.pop();
	}

	public boolean inNodeLabel() {
      return !inNodeLabel.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRangeLiteral = new java.util.Stack<>();

	@Override
	public void enterRangeLiteral(com.generator.generators.cypher.parser.CypherParser.RangeLiteralContext arg) {
		onEnter(new Node("RangeLiteral", arg.getText(), arg.getStart().getText()));
		this.inRangeLiteral.push(true);
	}

	public void exitRangeLiteral(com.generator.generators.cypher.parser.CypherParser.RangeLiteralContext arg) {
		onExit();
		this.inRangeLiteral.pop();
	}

	public boolean inRangeLiteral() {
      return !inRangeLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabelName = new java.util.Stack<>();

	@Override
	public void enterLabelName(com.generator.generators.cypher.parser.CypherParser.LabelNameContext arg) {
		onEnter(new Node("LabelName", arg.getText(), arg.getStart().getText()));
		this.inLabelName.push(true);
	}

	public void exitLabelName(com.generator.generators.cypher.parser.CypherParser.LabelNameContext arg) {
		onExit();
		this.inLabelName.pop();
	}

	public boolean inLabelName() {
      return !inLabelName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelTypeName = new java.util.Stack<>();

	@Override
	public void enterRelTypeName(com.generator.generators.cypher.parser.CypherParser.RelTypeNameContext arg) {
		onEnter(new Node("RelTypeName", arg.getText(), arg.getStart().getText()));
		this.inRelTypeName.push(true);
	}

	public void exitRelTypeName(com.generator.generators.cypher.parser.CypherParser.RelTypeNameContext arg) {
		onExit();
		this.inRelTypeName.pop();
	}

	public boolean inRelTypeName() {
      return !inRelTypeName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrExpression = new java.util.Stack<>();

	@Override
	public void enterOrExpression(com.generator.generators.cypher.parser.CypherParser.OrExpressionContext arg) {
		onEnter(new Node("OrExpression", arg.getText(), arg.getStart().getText()));
		this.inOrExpression.push(true);
	}

	public void exitOrExpression(com.generator.generators.cypher.parser.CypherParser.OrExpressionContext arg) {
		onExit();
		this.inOrExpression.pop();
	}

	public boolean inOrExpression() {
      return !inOrExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXorExpression = new java.util.Stack<>();

	@Override
	public void enterXorExpression(com.generator.generators.cypher.parser.CypherParser.XorExpressionContext arg) {
		onEnter(new Node("XorExpression", arg.getText(), arg.getStart().getText()));
		this.inXorExpression.push(true);
	}

	public void exitXorExpression(com.generator.generators.cypher.parser.CypherParser.XorExpressionContext arg) {
		onExit();
		this.inXorExpression.pop();
	}

	public boolean inXorExpression() {
      return !inXorExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAndExpression = new java.util.Stack<>();

	@Override
	public void enterAndExpression(com.generator.generators.cypher.parser.CypherParser.AndExpressionContext arg) {
		onEnter(new Node("AndExpression", arg.getText(), arg.getStart().getText()));
		this.inAndExpression.push(true);
	}

	public void exitAndExpression(com.generator.generators.cypher.parser.CypherParser.AndExpressionContext arg) {
		onExit();
		this.inAndExpression.pop();
	}

	public boolean inAndExpression() {
      return !inAndExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNotExpression = new java.util.Stack<>();

	@Override
	public void enterNotExpression(com.generator.generators.cypher.parser.CypherParser.NotExpressionContext arg) {
		onEnter(new Node("NotExpression", arg.getText(), arg.getStart().getText()));
		this.inNotExpression.push(true);
	}

	public void exitNotExpression(com.generator.generators.cypher.parser.CypherParser.NotExpressionContext arg) {
		onExit();
		this.inNotExpression.pop();
	}

	public boolean inNotExpression() {
      return !inNotExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComparisonExpression = new java.util.Stack<>();

	@Override
	public void enterComparisonExpression(com.generator.generators.cypher.parser.CypherParser.ComparisonExpressionContext arg) {
		onEnter(new Node("ComparisonExpression", arg.getText(), arg.getStart().getText()));
		this.inComparisonExpression.push(true);
	}

	public void exitComparisonExpression(com.generator.generators.cypher.parser.CypherParser.ComparisonExpressionContext arg) {
		onExit();
		this.inComparisonExpression.pop();
	}

	public boolean inComparisonExpression() {
      return !inComparisonExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAddOrSubtractExpression = new java.util.Stack<>();

	@Override
	public void enterAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.AddOrSubtractExpressionContext arg) {
		onEnter(new Node("AddOrSubtractExpression", arg.getText(), arg.getStart().getText()));
		this.inAddOrSubtractExpression.push(true);
	}

	public void exitAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.AddOrSubtractExpressionContext arg) {
		onExit();
		this.inAddOrSubtractExpression.pop();
	}

	public boolean inAddOrSubtractExpression() {
      return !inAddOrSubtractExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiplyDivideModuloExpression = new java.util.Stack<>();

	@Override
	public void enterMultiplyDivideModuloExpression(com.generator.generators.cypher.parser.CypherParser.MultiplyDivideModuloExpressionContext arg) {
		onEnter(new Node("MultiplyDivideModuloExpression", arg.getText(), arg.getStart().getText()));
		this.inMultiplyDivideModuloExpression.push(true);
	}

	public void exitMultiplyDivideModuloExpression(com.generator.generators.cypher.parser.CypherParser.MultiplyDivideModuloExpressionContext arg) {
		onExit();
		this.inMultiplyDivideModuloExpression.pop();
	}

	public boolean inMultiplyDivideModuloExpression() {
      return !inMultiplyDivideModuloExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPowerOfExpression = new java.util.Stack<>();

	@Override
	public void enterPowerOfExpression(com.generator.generators.cypher.parser.CypherParser.PowerOfExpressionContext arg) {
		onEnter(new Node("PowerOfExpression", arg.getText(), arg.getStart().getText()));
		this.inPowerOfExpression.push(true);
	}

	public void exitPowerOfExpression(com.generator.generators.cypher.parser.CypherParser.PowerOfExpressionContext arg) {
		onExit();
		this.inPowerOfExpression.pop();
	}

	public boolean inPowerOfExpression() {
      return !inPowerOfExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryAddOrSubtractExpression = new java.util.Stack<>();

	@Override
	public void enterUnaryAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.UnaryAddOrSubtractExpressionContext arg) {
		onEnter(new Node("UnaryAddOrSubtractExpression", arg.getText(), arg.getStart().getText()));
		this.inUnaryAddOrSubtractExpression.push(true);
	}

	public void exitUnaryAddOrSubtractExpression(com.generator.generators.cypher.parser.CypherParser.UnaryAddOrSubtractExpressionContext arg) {
		onExit();
		this.inUnaryAddOrSubtractExpression.pop();
	}

	public boolean inUnaryAddOrSubtractExpression() {
      return !inUnaryAddOrSubtractExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStringListNullOperatorExpression = new java.util.Stack<>();

	@Override
	public void enterStringListNullOperatorExpression(com.generator.generators.cypher.parser.CypherParser.StringListNullOperatorExpressionContext arg) {
		onEnter(new Node("StringListNullOperatorExpression", arg.getText(), arg.getStart().getText()));
		this.inStringListNullOperatorExpression.push(true);
	}

	public void exitStringListNullOperatorExpression(com.generator.generators.cypher.parser.CypherParser.StringListNullOperatorExpressionContext arg) {
		onExit();
		this.inStringListNullOperatorExpression.pop();
	}

	public boolean inStringListNullOperatorExpression() {
      return !inStringListNullOperatorExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyOrLabelsExpression = new java.util.Stack<>();

	@Override
	public void enterPropertyOrLabelsExpression(com.generator.generators.cypher.parser.CypherParser.PropertyOrLabelsExpressionContext arg) {
		onEnter(new Node("PropertyOrLabelsExpression", arg.getText(), arg.getStart().getText()));
		this.inPropertyOrLabelsExpression.push(true);
	}

	public void exitPropertyOrLabelsExpression(com.generator.generators.cypher.parser.CypherParser.PropertyOrLabelsExpressionContext arg) {
		onExit();
		this.inPropertyOrLabelsExpression.pop();
	}

	public boolean inPropertyOrLabelsExpression() {
      return !inPropertyOrLabelsExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBooleanLiteral = new java.util.Stack<>();

	@Override
	public void enterBooleanLiteral(com.generator.generators.cypher.parser.CypherParser.BooleanLiteralContext arg) {
		onEnter(new Node("BooleanLiteral", arg.getText(), arg.getStart().getText()));
		this.inBooleanLiteral.push(true);
	}

	public void exitBooleanLiteral(com.generator.generators.cypher.parser.CypherParser.BooleanLiteralContext arg) {
		onExit();
		this.inBooleanLiteral.pop();
	}

	public boolean inBooleanLiteral() {
      return !inBooleanLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inListLiteral = new java.util.Stack<>();

	@Override
	public void enterListLiteral(com.generator.generators.cypher.parser.CypherParser.ListLiteralContext arg) {
		onEnter(new Node("ListLiteral", arg.getText(), arg.getStart().getText()));
		this.inListLiteral.push(true);
	}

	public void exitListLiteral(com.generator.generators.cypher.parser.CypherParser.ListLiteralContext arg) {
		onExit();
		this.inListLiteral.pop();
	}

	public boolean inListLiteral() {
      return !inListLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPartialComparisonExpression = new java.util.Stack<>();

	@Override
	public void enterPartialComparisonExpression(com.generator.generators.cypher.parser.CypherParser.PartialComparisonExpressionContext arg) {
		onEnter(new Node("PartialComparisonExpression", arg.getText(), arg.getStart().getText()));
		this.inPartialComparisonExpression.push(true);
	}

	public void exitPartialComparisonExpression(com.generator.generators.cypher.parser.CypherParser.PartialComparisonExpressionContext arg) {
		onExit();
		this.inPartialComparisonExpression.pop();
	}

	public boolean inPartialComparisonExpression() {
      return !inPartialComparisonExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParenthesizedExpression = new java.util.Stack<>();

	@Override
	public void enterParenthesizedExpression(com.generator.generators.cypher.parser.CypherParser.ParenthesizedExpressionContext arg) {
		onEnter(new Node("ParenthesizedExpression", arg.getText(), arg.getStart().getText()));
		this.inParenthesizedExpression.push(true);
	}

	public void exitParenthesizedExpression(com.generator.generators.cypher.parser.CypherParser.ParenthesizedExpressionContext arg) {
		onExit();
		this.inParenthesizedExpression.pop();
	}

	public boolean inParenthesizedExpression() {
      return !inParenthesizedExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationshipsPattern = new java.util.Stack<>();

	@Override
	public void enterRelationshipsPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipsPatternContext arg) {
		onEnter(new Node("RelationshipsPattern", arg.getText(), arg.getStart().getText()));
		this.inRelationshipsPattern.push(true);
	}

	public void exitRelationshipsPattern(com.generator.generators.cypher.parser.CypherParser.RelationshipsPatternContext arg) {
		onExit();
		this.inRelationshipsPattern.pop();
	}

	public boolean inRelationshipsPattern() {
      return !inRelationshipsPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFilterExpression = new java.util.Stack<>();

	@Override
	public void enterFilterExpression(com.generator.generators.cypher.parser.CypherParser.FilterExpressionContext arg) {
		onEnter(new Node("FilterExpression", arg.getText(), arg.getStart().getText()));
		this.inFilterExpression.push(true);
	}

	public void exitFilterExpression(com.generator.generators.cypher.parser.CypherParser.FilterExpressionContext arg) {
		onExit();
		this.inFilterExpression.pop();
	}

	public boolean inFilterExpression() {
      return !inFilterExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdInColl = new java.util.Stack<>();

	@Override
	public void enterIdInColl(com.generator.generators.cypher.parser.CypherParser.IdInCollContext arg) {
		onEnter(new Node("IdInColl", arg.getText(), arg.getStart().getText()));
		this.inIdInColl.push(true);
	}

	public void exitIdInColl(com.generator.generators.cypher.parser.CypherParser.IdInCollContext arg) {
		onExit();
		this.inIdInColl.pop();
	}

	public boolean inIdInColl() {
      return !inIdInColl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionInvocation = new java.util.Stack<>();

	@Override
	public void enterFunctionInvocation(com.generator.generators.cypher.parser.CypherParser.FunctionInvocationContext arg) {
		onEnter(new Node("FunctionInvocation", arg.getText(), arg.getStart().getText()));
		this.inFunctionInvocation.push(true);
	}

	public void exitFunctionInvocation(com.generator.generators.cypher.parser.CypherParser.FunctionInvocationContext arg) {
		onExit();
		this.inFunctionInvocation.pop();
	}

	public boolean inFunctionInvocation() {
      return !inFunctionInvocation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionName = new java.util.Stack<>();

	@Override
	public void enterFunctionName(com.generator.generators.cypher.parser.CypherParser.FunctionNameContext arg) {
		onEnter(new Node("FunctionName", arg.getText(), arg.getStart().getText()));
		this.inFunctionName.push(true);
	}

	public void exitFunctionName(com.generator.generators.cypher.parser.CypherParser.FunctionNameContext arg) {
		onExit();
		this.inFunctionName.pop();
	}

	public boolean inFunctionName() {
      return !inFunctionName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExplicitProcedureInvocation = new java.util.Stack<>();

	@Override
	public void enterExplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ExplicitProcedureInvocationContext arg) {
		onEnter(new Node("ExplicitProcedureInvocation", arg.getText(), arg.getStart().getText()));
		this.inExplicitProcedureInvocation.push(true);
	}

	public void exitExplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ExplicitProcedureInvocationContext arg) {
		onExit();
		this.inExplicitProcedureInvocation.pop();
	}

	public boolean inExplicitProcedureInvocation() {
      return !inExplicitProcedureInvocation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImplicitProcedureInvocation = new java.util.Stack<>();

	@Override
	public void enterImplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ImplicitProcedureInvocationContext arg) {
		onEnter(new Node("ImplicitProcedureInvocation", arg.getText(), arg.getStart().getText()));
		this.inImplicitProcedureInvocation.push(true);
	}

	public void exitImplicitProcedureInvocation(com.generator.generators.cypher.parser.CypherParser.ImplicitProcedureInvocationContext arg) {
		onExit();
		this.inImplicitProcedureInvocation.pop();
	}

	public boolean inImplicitProcedureInvocation() {
      return !inImplicitProcedureInvocation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProcedureResultField = new java.util.Stack<>();

	@Override
	public void enterProcedureResultField(com.generator.generators.cypher.parser.CypherParser.ProcedureResultFieldContext arg) {
		onEnter(new Node("ProcedureResultField", arg.getText(), arg.getStart().getText()));
		this.inProcedureResultField.push(true);
	}

	public void exitProcedureResultField(com.generator.generators.cypher.parser.CypherParser.ProcedureResultFieldContext arg) {
		onExit();
		this.inProcedureResultField.pop();
	}

	public boolean inProcedureResultField() {
      return !inProcedureResultField.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProcedureName = new java.util.Stack<>();

	@Override
	public void enterProcedureName(com.generator.generators.cypher.parser.CypherParser.ProcedureNameContext arg) {
		onEnter(new Node("ProcedureName", arg.getText(), arg.getStart().getText()));
		this.inProcedureName.push(true);
	}

	public void exitProcedureName(com.generator.generators.cypher.parser.CypherParser.ProcedureNameContext arg) {
		onExit();
		this.inProcedureName.pop();
	}

	public boolean inProcedureName() {
      return !inProcedureName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamespace = new java.util.Stack<>();

	@Override
	public void enterNamespace(com.generator.generators.cypher.parser.CypherParser.NamespaceContext arg) {
		onEnter(new Node("Namespace", arg.getText(), arg.getStart().getText()));
		this.inNamespace.push(true);
	}

	public void exitNamespace(com.generator.generators.cypher.parser.CypherParser.NamespaceContext arg) {
		onExit();
		this.inNamespace.pop();
	}

	public boolean inNamespace() {
      return !inNamespace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inListComprehension = new java.util.Stack<>();

	@Override
	public void enterListComprehension(com.generator.generators.cypher.parser.CypherParser.ListComprehensionContext arg) {
		onEnter(new Node("ListComprehension", arg.getText(), arg.getStart().getText()));
		this.inListComprehension.push(true);
	}

	public void exitListComprehension(com.generator.generators.cypher.parser.CypherParser.ListComprehensionContext arg) {
		onExit();
		this.inListComprehension.pop();
	}

	public boolean inListComprehension() {
      return !inListComprehension.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPatternComprehension = new java.util.Stack<>();

	@Override
	public void enterPatternComprehension(com.generator.generators.cypher.parser.CypherParser.PatternComprehensionContext arg) {
		onEnter(new Node("PatternComprehension", arg.getText(), arg.getStart().getText()));
		this.inPatternComprehension.push(true);
	}

	public void exitPatternComprehension(com.generator.generators.cypher.parser.CypherParser.PatternComprehensionContext arg) {
		onExit();
		this.inPatternComprehension.pop();
	}

	public boolean inPatternComprehension() {
      return !inPatternComprehension.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyLookup = new java.util.Stack<>();

	@Override
	public void enterPropertyLookup(com.generator.generators.cypher.parser.CypherParser.PropertyLookupContext arg) {
		onEnter(new Node("PropertyLookup", arg.getText(), arg.getStart().getText()));
		this.inPropertyLookup.push(true);
	}

	public void exitPropertyLookup(com.generator.generators.cypher.parser.CypherParser.PropertyLookupContext arg) {
		onExit();
		this.inPropertyLookup.pop();
	}

	public boolean inPropertyLookup() {
      return !inPropertyLookup.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseExpression = new java.util.Stack<>();

	@Override
	public void enterCaseExpression(com.generator.generators.cypher.parser.CypherParser.CaseExpressionContext arg) {
		onEnter(new Node("CaseExpression", arg.getText(), arg.getStart().getText()));
		this.inCaseExpression.push(true);
	}

	public void exitCaseExpression(com.generator.generators.cypher.parser.CypherParser.CaseExpressionContext arg) {
		onExit();
		this.inCaseExpression.pop();
	}

	public boolean inCaseExpression() {
      return !inCaseExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseAlternatives = new java.util.Stack<>();

	@Override
	public void enterCaseAlternatives(com.generator.generators.cypher.parser.CypherParser.CaseAlternativesContext arg) {
		onEnter(new Node("CaseAlternatives", arg.getText(), arg.getStart().getText()));
		this.inCaseAlternatives.push(true);
	}

	public void exitCaseAlternatives(com.generator.generators.cypher.parser.CypherParser.CaseAlternativesContext arg) {
		onExit();
		this.inCaseAlternatives.pop();
	}

	public boolean inCaseAlternatives() {
      return !inCaseAlternatives.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariable = new java.util.Stack<>();

	@Override
	public void enterVariable(com.generator.generators.cypher.parser.CypherParser.VariableContext arg) {
		onEnter(new Node("Variable", arg.getText(), arg.getStart().getText()));
		this.inVariable.push(true);
	}

	public void exitVariable(com.generator.generators.cypher.parser.CypherParser.VariableContext arg) {
		onExit();
		this.inVariable.pop();
	}

	public boolean inVariable() {
      return !inVariable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumberLiteral = new java.util.Stack<>();

	@Override
	public void enterNumberLiteral(com.generator.generators.cypher.parser.CypherParser.NumberLiteralContext arg) {
		onEnter(new Node("NumberLiteral", arg.getText(), arg.getStart().getText()));
		this.inNumberLiteral.push(true);
	}

	public void exitNumberLiteral(com.generator.generators.cypher.parser.CypherParser.NumberLiteralContext arg) {
		onExit();
		this.inNumberLiteral.pop();
	}

	public boolean inNumberLiteral() {
      return !inNumberLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMapLiteral = new java.util.Stack<>();

	@Override
	public void enterMapLiteral(com.generator.generators.cypher.parser.CypherParser.MapLiteralContext arg) {
		onEnter(new Node("MapLiteral", arg.getText(), arg.getStart().getText()));
		this.inMapLiteral.push(true);
	}

	public void exitMapLiteral(com.generator.generators.cypher.parser.CypherParser.MapLiteralContext arg) {
		onExit();
		this.inMapLiteral.pop();
	}

	public boolean inMapLiteral() {
      return !inMapLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameter = new java.util.Stack<>();

	@Override
	public void enterParameter(com.generator.generators.cypher.parser.CypherParser.ParameterContext arg) {
		onEnter(new Node("Parameter", arg.getText(), arg.getStart().getText()));
		this.inParameter.push(true);
	}

	public void exitParameter(com.generator.generators.cypher.parser.CypherParser.ParameterContext arg) {
		onExit();
		this.inParameter.pop();
	}

	public boolean inParameter() {
      return !inParameter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyExpression = new java.util.Stack<>();

	@Override
	public void enterPropertyExpression(com.generator.generators.cypher.parser.CypherParser.PropertyExpressionContext arg) {
		onEnter(new Node("PropertyExpression", arg.getText(), arg.getStart().getText()));
		this.inPropertyExpression.push(true);
	}

	public void exitPropertyExpression(com.generator.generators.cypher.parser.CypherParser.PropertyExpressionContext arg) {
		onExit();
		this.inPropertyExpression.pop();
	}

	public boolean inPropertyExpression() {
      return !inPropertyExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyKeyName = new java.util.Stack<>();

	@Override
	public void enterPropertyKeyName(com.generator.generators.cypher.parser.CypherParser.PropertyKeyNameContext arg) {
		onEnter(new Node("PropertyKeyName", arg.getText(), arg.getStart().getText()));
		this.inPropertyKeyName.push(true);
	}

	public void exitPropertyKeyName(com.generator.generators.cypher.parser.CypherParser.PropertyKeyNameContext arg) {
		onExit();
		this.inPropertyKeyName.pop();
	}

	public boolean inPropertyKeyName() {
      return !inPropertyKeyName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIntegerLiteral = new java.util.Stack<>();

	@Override
	public void enterIntegerLiteral(com.generator.generators.cypher.parser.CypherParser.IntegerLiteralContext arg) {
		onEnter(new Node("IntegerLiteral", arg.getText(), arg.getStart().getText()));
		this.inIntegerLiteral.push(true);
	}

	public void exitIntegerLiteral(com.generator.generators.cypher.parser.CypherParser.IntegerLiteralContext arg) {
		onExit();
		this.inIntegerLiteral.pop();
	}

	public boolean inIntegerLiteral() {
      return !inIntegerLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDoubleLiteral = new java.util.Stack<>();

	@Override
	public void enterDoubleLiteral(com.generator.generators.cypher.parser.CypherParser.DoubleLiteralContext arg) {
		onEnter(new Node("DoubleLiteral", arg.getText(), arg.getStart().getText()));
		this.inDoubleLiteral.push(true);
	}

	public void exitDoubleLiteral(com.generator.generators.cypher.parser.CypherParser.DoubleLiteralContext arg) {
		onExit();
		this.inDoubleLiteral.pop();
	}

	public boolean inDoubleLiteral() {
      return !inDoubleLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSchemaName = new java.util.Stack<>();

	@Override
	public void enterSchemaName(com.generator.generators.cypher.parser.CypherParser.SchemaNameContext arg) {
		onEnter(new Node("SchemaName", arg.getText(), arg.getStart().getText()));
		this.inSchemaName.push(true);
	}

	public void exitSchemaName(com.generator.generators.cypher.parser.CypherParser.SchemaNameContext arg) {
		onExit();
		this.inSchemaName.pop();
	}

	public boolean inSchemaName() {
      return !inSchemaName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReservedWord = new java.util.Stack<>();

	@Override
	public void enterReservedWord(com.generator.generators.cypher.parser.CypherParser.ReservedWordContext arg) {
		onEnter(new Node("ReservedWord", arg.getText(), arg.getStart().getText()));
		this.inReservedWord.push(true);
	}

	public void exitReservedWord(com.generator.generators.cypher.parser.CypherParser.ReservedWordContext arg) {
		onExit();
		this.inReservedWord.pop();
	}

	public boolean inReservedWord() {
      return !inReservedWord.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSymbolicName = new java.util.Stack<>();

	@Override
	public void enterSymbolicName(com.generator.generators.cypher.parser.CypherParser.SymbolicNameContext arg) {
		onEnter(new Node("SymbolicName", arg.getText(), arg.getStart().getText()));
		this.inSymbolicName.push(true);
	}

	public void exitSymbolicName(com.generator.generators.cypher.parser.CypherParser.SymbolicNameContext arg) {
		onExit();
		this.inSymbolicName.pop();
	}

	public boolean inSymbolicName() {
      return !inSymbolicName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLeftArrowHead = new java.util.Stack<>();

	@Override
	public void enterLeftArrowHead(com.generator.generators.cypher.parser.CypherParser.LeftArrowHeadContext arg) {
		onEnter(new Node("LeftArrowHead", arg.getText(), arg.getStart().getText()));
		this.inLeftArrowHead.push(true);
	}

	public void exitLeftArrowHead(com.generator.generators.cypher.parser.CypherParser.LeftArrowHeadContext arg) {
		onExit();
		this.inLeftArrowHead.pop();
	}

	public boolean inLeftArrowHead() {
      return !inLeftArrowHead.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRightArrowHead = new java.util.Stack<>();

	@Override
	public void enterRightArrowHead(com.generator.generators.cypher.parser.CypherParser.RightArrowHeadContext arg) {
		onEnter(new Node("RightArrowHead", arg.getText(), arg.getStart().getText()));
		this.inRightArrowHead.push(true);
	}

	public void exitRightArrowHead(com.generator.generators.cypher.parser.CypherParser.RightArrowHeadContext arg) {
		onExit();
		this.inRightArrowHead.pop();
	}

	public boolean inRightArrowHead() {
      return !inRightArrowHead.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDash = new java.util.Stack<>();

	@Override
	public void enterDash(com.generator.generators.cypher.parser.CypherParser.DashContext arg) {
		onEnter(new Node("Dash", arg.getText(), arg.getStart().getText()));
		this.inDash.push(true);
	}

	public void exitDash(com.generator.generators.cypher.parser.CypherParser.DashContext arg) {
		onExit();
		this.inDash.pop();
	}

	public boolean inDash() {
      return !inDash.isEmpty(); 
   }

}