package com.generator.generators.cypher.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CypherNeoListener extends CypherBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public CypherNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public CypherNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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
		final Node node = model.findOrCreate(Label.label("Atom"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
		this.inAtom.push(true);
	}

	public void exitAtom(com.generator.generators.cypher.parser.CypherParser.AtomContext arg) {
		onExit();
		this.inAtom.pop();
	}

	public boolean inAtom() {
      return !inAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.cypher.parser.CypherParser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.cypher.parser.CypherParser.StatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.cypher.parser.CypherParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCypher = new java.util.Stack<>();

	@Override
	public void enterCypher(com.generator.generators.cypher.parser.CypherParser.CypherContext arg) {
		final Node node = model.findOrCreate(Label.label("Cypher"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Query"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
		this.inQuery.push(true);
	}

	public void exitQuery(com.generator.generators.cypher.parser.CypherParser.QueryContext arg) {
		onExit();
		this.inQuery.pop();
	}

	public boolean inQuery() {
      return !inQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRegularQuery = new java.util.Stack<>();

	@Override
	public void enterRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		final Node node = model.findOrCreate(Label.label("RegularQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
		this.inRegularQuery.push(true);
	}

	public void exitRegularQuery(com.generator.generators.cypher.parser.CypherParser.RegularQueryContext arg) {
		onExit();
		this.inRegularQuery.pop();
	}

	public boolean inRegularQuery() {
      return !inRegularQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnion = new java.util.Stack<>();

	@Override
	public void enterUnion(com.generator.generators.cypher.parser.CypherParser.UnionContext arg) {
		final Node node = model.findOrCreate(Label.label("Union"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SingleQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SinglePartQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReadOnlyEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReadUpdateEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("UpdatingEnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("MultiPartQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReadPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("UpdatingPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("UpdatingStartClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("UpdatingClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReadingClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Cyper_match"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Unwind"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Merge"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("MergeAction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Create"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SetItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Delete"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Remove"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RemoveItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("InQueryCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("StandaloneCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("YieldItems"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("YieldItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("With"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Cypher_return"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReturnBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReturnItems"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReturnItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Order"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Skip"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Limit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SortItem"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Where"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Pattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PatternPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("AnonymousPatternPart"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PatternElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NodePattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PatternElementChain"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RelationshipPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RelationshipDetail"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
		this.inRelationshipDetail.push(true);
	}

	public void exitRelationshipDetail(com.generator.generators.cypher.parser.CypherParser.RelationshipDetailContext arg) {
		onExit();
		this.inRelationshipDetail.pop();
	}

	public boolean inRelationshipDetail() {
      return !inRelationshipDetail.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProperties = new java.util.Stack<>();

	@Override
	public void enterProperties(com.generator.generators.cypher.parser.CypherParser.PropertiesContext arg) {
		final Node node = model.findOrCreate(Label.label("Properties"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RelationshipTypes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NodeLabels"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NodeLabel"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RangeLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("LabelName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RelTypeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("XorExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("AndExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NotExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ComparisonExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("AddOrSubtractExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("MultiplyDivideModuloExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PowerOfExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("UnaryAddOrSubtractExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("StringListNullOperatorExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PropertyOrLabelsExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("BooleanLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ListLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PartialComparisonExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ParenthesizedExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RelationshipsPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("FilterExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("IdInColl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("FunctionInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("FunctionName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ExplicitProcedureInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ImplicitProcedureInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ProcedureResultField"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ProcedureName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Namespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ListComprehension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PatternComprehension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PropertyLookup"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("CaseExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("CaseAlternatives"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NumberLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("MapLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Parameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PropertyExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PropertyKeyName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("IntegerLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("DoubleLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SchemaName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ReservedWord"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SymbolicName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("LeftArrowHead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RightArrowHead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Dash"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endtoken", arg.getStop().getText());
		onEnter(node);
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