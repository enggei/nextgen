package com.generator.generators.sparql.parser;

public class SparqlNodeListener extends SparqlBaseListener {

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

	public SparqlNodeListener() {
		this(false);
	}

	public SparqlNodeListener(boolean debug) {
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

	protected java.util.Stack<Boolean> inString = new java.util.Stack<>();

	@Override
	public void enterString(com.generator.generators.sparql.parser.SparqlParser.StringContext arg) {
		onEnter(new Node("String", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inString.push(true);
	}

	public void exitString(com.generator.generators.sparql.parser.SparqlParser.StringContext arg) {
		onExit();
		this.inString.pop();
	}

	public boolean inString() {
      return !inString.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.sparql.parser.SparqlParser.ExpressionContext arg) {
		onEnter(new Node("Expression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.sparql.parser.SparqlParser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVar = new java.util.Stack<>();

	@Override
	public void enterVar(com.generator.generators.sparql.parser.SparqlParser.VarContext arg) {
		onEnter(new Node("Var", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inVar.push(true);
	}

	public void exitVar(com.generator.generators.sparql.parser.SparqlParser.VarContext arg) {
		onExit();
		this.inVar.pop();
	}

	public boolean inVar() {
      return !inVar.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery = new java.util.Stack<>();

	@Override
	public void enterQuery(com.generator.generators.sparql.parser.SparqlParser.QueryContext arg) {
		onEnter(new Node("Query", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inQuery.push(true);
	}

	public void exitQuery(com.generator.generators.sparql.parser.SparqlParser.QueryContext arg) {
		onExit();
		this.inQuery.pop();
	}

	public boolean inQuery() {
      return !inQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBooleanLiteral = new java.util.Stack<>();

	@Override
	public void enterBooleanLiteral(com.generator.generators.sparql.parser.SparqlParser.BooleanLiteralContext arg) {
		onEnter(new Node("BooleanLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inBooleanLiteral.push(true);
	}

	public void exitBooleanLiteral(com.generator.generators.sparql.parser.SparqlParser.BooleanLiteralContext arg) {
		onExit();
		this.inBooleanLiteral.pop();
	}

	public boolean inBooleanLiteral() {
      return !inBooleanLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiplicativeExpression = new java.util.Stack<>();

	@Override
	public void enterMultiplicativeExpression(com.generator.generators.sparql.parser.SparqlParser.MultiplicativeExpressionContext arg) {
		onEnter(new Node("MultiplicativeExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inMultiplicativeExpression.push(true);
	}

	public void exitMultiplicativeExpression(com.generator.generators.sparql.parser.SparqlParser.MultiplicativeExpressionContext arg) {
		onExit();
		this.inMultiplicativeExpression.pop();
	}

	public boolean inMultiplicativeExpression() {
      return !inMultiplicativeExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAdditiveExpression = new java.util.Stack<>();

	@Override
	public void enterAdditiveExpression(com.generator.generators.sparql.parser.SparqlParser.AdditiveExpressionContext arg) {
		onEnter(new Node("AdditiveExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inAdditiveExpression.push(true);
	}

	public void exitAdditiveExpression(com.generator.generators.sparql.parser.SparqlParser.AdditiveExpressionContext arg) {
		onExit();
		this.inAdditiveExpression.pop();
	}

	public boolean inAdditiveExpression() {
      return !inAdditiveExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationalExpression = new java.util.Stack<>();

	@Override
	public void enterRelationalExpression(com.generator.generators.sparql.parser.SparqlParser.RelationalExpressionContext arg) {
		onEnter(new Node("RelationalExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inRelationalExpression.push(true);
	}

	public void exitRelationalExpression(com.generator.generators.sparql.parser.SparqlParser.RelationalExpressionContext arg) {
		onExit();
		this.inRelationalExpression.pop();
	}

	public boolean inRelationalExpression() {
      return !inRelationalExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericLiteral = new java.util.Stack<>();

	@Override
	public void enterNumericLiteral(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralContext arg) {
		onEnter(new Node("NumericLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNumericLiteral.push(true);
	}

	public void exitNumericLiteral(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralContext arg) {
		onExit();
		this.inNumericLiteral.pop();
	}

	public boolean inNumericLiteral() {
      return !inNumericLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrologue = new java.util.Stack<>();

	@Override
	public void enterPrologue(com.generator.generators.sparql.parser.SparqlParser.PrologueContext arg) {
		onEnter(new Node("Prologue", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPrologue.push(true);
	}

	public void exitPrologue(com.generator.generators.sparql.parser.SparqlParser.PrologueContext arg) {
		onExit();
		this.inPrologue.pop();
	}

	public boolean inPrologue() {
      return !inPrologue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBaseDecl = new java.util.Stack<>();

	@Override
	public void enterBaseDecl(com.generator.generators.sparql.parser.SparqlParser.BaseDeclContext arg) {
		onEnter(new Node("BaseDecl", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inBaseDecl.push(true);
	}

	public void exitBaseDecl(com.generator.generators.sparql.parser.SparqlParser.BaseDeclContext arg) {
		onExit();
		this.inBaseDecl.pop();
	}

	public boolean inBaseDecl() {
      return !inBaseDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrefixDecl = new java.util.Stack<>();

	@Override
	public void enterPrefixDecl(com.generator.generators.sparql.parser.SparqlParser.PrefixDeclContext arg) {
		onEnter(new Node("PrefixDecl", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPrefixDecl.push(true);
	}

	public void exitPrefixDecl(com.generator.generators.sparql.parser.SparqlParser.PrefixDeclContext arg) {
		onExit();
		this.inPrefixDecl.pop();
	}

	public boolean inPrefixDecl() {
      return !inPrefixDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectQuery = new java.util.Stack<>();

	@Override
	public void enterSelectQuery(com.generator.generators.sparql.parser.SparqlParser.SelectQueryContext arg) {
		onEnter(new Node("SelectQuery", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inSelectQuery.push(true);
	}

	public void exitSelectQuery(com.generator.generators.sparql.parser.SparqlParser.SelectQueryContext arg) {
		onExit();
		this.inSelectQuery.pop();
	}

	public boolean inSelectQuery() {
      return !inSelectQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstructQuery = new java.util.Stack<>();

	@Override
	public void enterConstructQuery(com.generator.generators.sparql.parser.SparqlParser.ConstructQueryContext arg) {
		onEnter(new Node("ConstructQuery", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inConstructQuery.push(true);
	}

	public void exitConstructQuery(com.generator.generators.sparql.parser.SparqlParser.ConstructQueryContext arg) {
		onExit();
		this.inConstructQuery.pop();
	}

	public boolean inConstructQuery() {
      return !inConstructQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDescribeQuery = new java.util.Stack<>();

	@Override
	public void enterDescribeQuery(com.generator.generators.sparql.parser.SparqlParser.DescribeQueryContext arg) {
		onEnter(new Node("DescribeQuery", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDescribeQuery.push(true);
	}

	public void exitDescribeQuery(com.generator.generators.sparql.parser.SparqlParser.DescribeQueryContext arg) {
		onExit();
		this.inDescribeQuery.pop();
	}

	public boolean inDescribeQuery() {
      return !inDescribeQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAskQuery = new java.util.Stack<>();

	@Override
	public void enterAskQuery(com.generator.generators.sparql.parser.SparqlParser.AskQueryContext arg) {
		onEnter(new Node("AskQuery", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inAskQuery.push(true);
	}

	public void exitAskQuery(com.generator.generators.sparql.parser.SparqlParser.AskQueryContext arg) {
		onExit();
		this.inAskQuery.pop();
	}

	public boolean inAskQuery() {
      return !inAskQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDatasetClause = new java.util.Stack<>();

	@Override
	public void enterDatasetClause(com.generator.generators.sparql.parser.SparqlParser.DatasetClauseContext arg) {
		onEnter(new Node("DatasetClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDatasetClause.push(true);
	}

	public void exitDatasetClause(com.generator.generators.sparql.parser.SparqlParser.DatasetClauseContext arg) {
		onExit();
		this.inDatasetClause.pop();
	}

	public boolean inDatasetClause() {
      return !inDatasetClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultGraphClause = new java.util.Stack<>();

	@Override
	public void enterDefaultGraphClause(com.generator.generators.sparql.parser.SparqlParser.DefaultGraphClauseContext arg) {
		onEnter(new Node("DefaultGraphClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDefaultGraphClause.push(true);
	}

	public void exitDefaultGraphClause(com.generator.generators.sparql.parser.SparqlParser.DefaultGraphClauseContext arg) {
		onExit();
		this.inDefaultGraphClause.pop();
	}

	public boolean inDefaultGraphClause() {
      return !inDefaultGraphClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamedGraphClause = new java.util.Stack<>();

	@Override
	public void enterNamedGraphClause(com.generator.generators.sparql.parser.SparqlParser.NamedGraphClauseContext arg) {
		onEnter(new Node("NamedGraphClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNamedGraphClause.push(true);
	}

	public void exitNamedGraphClause(com.generator.generators.sparql.parser.SparqlParser.NamedGraphClauseContext arg) {
		onExit();
		this.inNamedGraphClause.pop();
	}

	public boolean inNamedGraphClause() {
      return !inNamedGraphClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSourceSelector = new java.util.Stack<>();

	@Override
	public void enterSourceSelector(com.generator.generators.sparql.parser.SparqlParser.SourceSelectorContext arg) {
		onEnter(new Node("SourceSelector", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inSourceSelector.push(true);
	}

	public void exitSourceSelector(com.generator.generators.sparql.parser.SparqlParser.SourceSelectorContext arg) {
		onExit();
		this.inSourceSelector.pop();
	}

	public boolean inSourceSelector() {
      return !inSourceSelector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWhereClause = new java.util.Stack<>();

	@Override
	public void enterWhereClause(com.generator.generators.sparql.parser.SparqlParser.WhereClauseContext arg) {
		onEnter(new Node("WhereClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inWhereClause.push(true);
	}

	public void exitWhereClause(com.generator.generators.sparql.parser.SparqlParser.WhereClauseContext arg) {
		onExit();
		this.inWhereClause.pop();
	}

	public boolean inWhereClause() {
      return !inWhereClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSolutionModifier = new java.util.Stack<>();

	@Override
	public void enterSolutionModifier(com.generator.generators.sparql.parser.SparqlParser.SolutionModifierContext arg) {
		onEnter(new Node("SolutionModifier", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inSolutionModifier.push(true);
	}

	public void exitSolutionModifier(com.generator.generators.sparql.parser.SparqlParser.SolutionModifierContext arg) {
		onExit();
		this.inSolutionModifier.pop();
	}

	public boolean inSolutionModifier() {
      return !inSolutionModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLimitOffsetClauses = new java.util.Stack<>();

	@Override
	public void enterLimitOffsetClauses(com.generator.generators.sparql.parser.SparqlParser.LimitOffsetClausesContext arg) {
		onEnter(new Node("LimitOffsetClauses", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inLimitOffsetClauses.push(true);
	}

	public void exitLimitOffsetClauses(com.generator.generators.sparql.parser.SparqlParser.LimitOffsetClausesContext arg) {
		onExit();
		this.inLimitOffsetClauses.pop();
	}

	public boolean inLimitOffsetClauses() {
      return !inLimitOffsetClauses.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrderClause = new java.util.Stack<>();

	@Override
	public void enterOrderClause(com.generator.generators.sparql.parser.SparqlParser.OrderClauseContext arg) {
		onEnter(new Node("OrderClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inOrderClause.push(true);
	}

	public void exitOrderClause(com.generator.generators.sparql.parser.SparqlParser.OrderClauseContext arg) {
		onExit();
		this.inOrderClause.pop();
	}

	public boolean inOrderClause() {
      return !inOrderClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrderCondition = new java.util.Stack<>();

	@Override
	public void enterOrderCondition(com.generator.generators.sparql.parser.SparqlParser.OrderConditionContext arg) {
		onEnter(new Node("OrderCondition", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inOrderCondition.push(true);
	}

	public void exitOrderCondition(com.generator.generators.sparql.parser.SparqlParser.OrderConditionContext arg) {
		onExit();
		this.inOrderCondition.pop();
	}

	public boolean inOrderCondition() {
      return !inOrderCondition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLimitClause = new java.util.Stack<>();

	@Override
	public void enterLimitClause(com.generator.generators.sparql.parser.SparqlParser.LimitClauseContext arg) {
		onEnter(new Node("LimitClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inLimitClause.push(true);
	}

	public void exitLimitClause(com.generator.generators.sparql.parser.SparqlParser.LimitClauseContext arg) {
		onExit();
		this.inLimitClause.pop();
	}

	public boolean inLimitClause() {
      return !inLimitClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOffsetClause = new java.util.Stack<>();

	@Override
	public void enterOffsetClause(com.generator.generators.sparql.parser.SparqlParser.OffsetClauseContext arg) {
		onEnter(new Node("OffsetClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inOffsetClause.push(true);
	}

	public void exitOffsetClause(com.generator.generators.sparql.parser.SparqlParser.OffsetClauseContext arg) {
		onExit();
		this.inOffsetClause.pop();
	}

	public boolean inOffsetClause() {
      return !inOffsetClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGroupGraphPattern = new java.util.Stack<>();

	@Override
	public void enterGroupGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupGraphPatternContext arg) {
		onEnter(new Node("GroupGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inGroupGraphPattern.push(true);
	}

	public void exitGroupGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupGraphPatternContext arg) {
		onExit();
		this.inGroupGraphPattern.pop();
	}

	public boolean inGroupGraphPattern() {
      return !inGroupGraphPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTriplesBlock = new java.util.Stack<>();

	@Override
	public void enterTriplesBlock(com.generator.generators.sparql.parser.SparqlParser.TriplesBlockContext arg) {
		onEnter(new Node("TriplesBlock", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inTriplesBlock.push(true);
	}

	public void exitTriplesBlock(com.generator.generators.sparql.parser.SparqlParser.TriplesBlockContext arg) {
		onExit();
		this.inTriplesBlock.pop();
	}

	public boolean inTriplesBlock() {
      return !inTriplesBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGraphPatternNotTriples = new java.util.Stack<>();

	@Override
	public void enterGraphPatternNotTriples(com.generator.generators.sparql.parser.SparqlParser.GraphPatternNotTriplesContext arg) {
		onEnter(new Node("GraphPatternNotTriples", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inGraphPatternNotTriples.push(true);
	}

	public void exitGraphPatternNotTriples(com.generator.generators.sparql.parser.SparqlParser.GraphPatternNotTriplesContext arg) {
		onExit();
		this.inGraphPatternNotTriples.pop();
	}

	public boolean inGraphPatternNotTriples() {
      return !inGraphPatternNotTriples.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOptionalGraphPattern = new java.util.Stack<>();

	@Override
	public void enterOptionalGraphPattern(com.generator.generators.sparql.parser.SparqlParser.OptionalGraphPatternContext arg) {
		onEnter(new Node("OptionalGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inOptionalGraphPattern.push(true);
	}

	public void exitOptionalGraphPattern(com.generator.generators.sparql.parser.SparqlParser.OptionalGraphPatternContext arg) {
		onExit();
		this.inOptionalGraphPattern.pop();
	}

	public boolean inOptionalGraphPattern() {
      return !inOptionalGraphPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGraphGraphPattern = new java.util.Stack<>();

	@Override
	public void enterGraphGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GraphGraphPatternContext arg) {
		onEnter(new Node("GraphGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inGraphGraphPattern.push(true);
	}

	public void exitGraphGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GraphGraphPatternContext arg) {
		onExit();
		this.inGraphGraphPattern.pop();
	}

	public boolean inGraphGraphPattern() {
      return !inGraphGraphPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGroupOrUnionGraphPattern = new java.util.Stack<>();

	@Override
	public void enterGroupOrUnionGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupOrUnionGraphPatternContext arg) {
		onEnter(new Node("GroupOrUnionGraphPattern", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inGroupOrUnionGraphPattern.push(true);
	}

	public void exitGroupOrUnionGraphPattern(com.generator.generators.sparql.parser.SparqlParser.GroupOrUnionGraphPatternContext arg) {
		onExit();
		this.inGroupOrUnionGraphPattern.pop();
	}

	public boolean inGroupOrUnionGraphPattern() {
      return !inGroupOrUnionGraphPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFilter = new java.util.Stack<>();

	@Override
	public void enterFilter(com.generator.generators.sparql.parser.SparqlParser.FilterContext arg) {
		onEnter(new Node("Filter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inFilter.push(true);
	}

	public void exitFilter(com.generator.generators.sparql.parser.SparqlParser.FilterContext arg) {
		onExit();
		this.inFilter.pop();
	}

	public boolean inFilter() {
      return !inFilter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstraint = new java.util.Stack<>();

	@Override
	public void enterConstraint(com.generator.generators.sparql.parser.SparqlParser.ConstraintContext arg) {
		onEnter(new Node("Constraint", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inConstraint.push(true);
	}

	public void exitConstraint(com.generator.generators.sparql.parser.SparqlParser.ConstraintContext arg) {
		onExit();
		this.inConstraint.pop();
	}

	public boolean inConstraint() {
      return !inConstraint.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionCall = new java.util.Stack<>();

	@Override
	public void enterFunctionCall(com.generator.generators.sparql.parser.SparqlParser.FunctionCallContext arg) {
		onEnter(new Node("FunctionCall", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inFunctionCall.push(true);
	}

	public void exitFunctionCall(com.generator.generators.sparql.parser.SparqlParser.FunctionCallContext arg) {
		onExit();
		this.inFunctionCall.pop();
	}

	public boolean inFunctionCall() {
      return !inFunctionCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgList = new java.util.Stack<>();

	@Override
	public void enterArgList(com.generator.generators.sparql.parser.SparqlParser.ArgListContext arg) {
		onEnter(new Node("ArgList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inArgList.push(true);
	}

	public void exitArgList(com.generator.generators.sparql.parser.SparqlParser.ArgListContext arg) {
		onExit();
		this.inArgList.pop();
	}

	public boolean inArgList() {
      return !inArgList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstructTemplate = new java.util.Stack<>();

	@Override
	public void enterConstructTemplate(com.generator.generators.sparql.parser.SparqlParser.ConstructTemplateContext arg) {
		onEnter(new Node("ConstructTemplate", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inConstructTemplate.push(true);
	}

	public void exitConstructTemplate(com.generator.generators.sparql.parser.SparqlParser.ConstructTemplateContext arg) {
		onExit();
		this.inConstructTemplate.pop();
	}

	public boolean inConstructTemplate() {
      return !inConstructTemplate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstructTriples = new java.util.Stack<>();

	@Override
	public void enterConstructTriples(com.generator.generators.sparql.parser.SparqlParser.ConstructTriplesContext arg) {
		onEnter(new Node("ConstructTriples", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inConstructTriples.push(true);
	}

	public void exitConstructTriples(com.generator.generators.sparql.parser.SparqlParser.ConstructTriplesContext arg) {
		onExit();
		this.inConstructTriples.pop();
	}

	public boolean inConstructTriples() {
      return !inConstructTriples.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTriplesSameSubject = new java.util.Stack<>();

	@Override
	public void enterTriplesSameSubject(com.generator.generators.sparql.parser.SparqlParser.TriplesSameSubjectContext arg) {
		onEnter(new Node("TriplesSameSubject", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inTriplesSameSubject.push(true);
	}

	public void exitTriplesSameSubject(com.generator.generators.sparql.parser.SparqlParser.TriplesSameSubjectContext arg) {
		onExit();
		this.inTriplesSameSubject.pop();
	}

	public boolean inTriplesSameSubject() {
      return !inTriplesSameSubject.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyListNotEmpty = new java.util.Stack<>();

	@Override
	public void enterPropertyListNotEmpty(com.generator.generators.sparql.parser.SparqlParser.PropertyListNotEmptyContext arg) {
		onEnter(new Node("PropertyListNotEmpty", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPropertyListNotEmpty.push(true);
	}

	public void exitPropertyListNotEmpty(com.generator.generators.sparql.parser.SparqlParser.PropertyListNotEmptyContext arg) {
		onExit();
		this.inPropertyListNotEmpty.pop();
	}

	public boolean inPropertyListNotEmpty() {
      return !inPropertyListNotEmpty.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyList = new java.util.Stack<>();

	@Override
	public void enterPropertyList(com.generator.generators.sparql.parser.SparqlParser.PropertyListContext arg) {
		onEnter(new Node("PropertyList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPropertyList.push(true);
	}

	public void exitPropertyList(com.generator.generators.sparql.parser.SparqlParser.PropertyListContext arg) {
		onExit();
		this.inPropertyList.pop();
	}

	public boolean inPropertyList() {
      return !inPropertyList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObjectList = new java.util.Stack<>();

	@Override
	public void enterObjectList(com.generator.generators.sparql.parser.SparqlParser.ObjectListContext arg) {
		onEnter(new Node("ObjectList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inObjectList.push(true);
	}

	public void exitObjectList(com.generator.generators.sparql.parser.SparqlParser.ObjectListContext arg) {
		onExit();
		this.inObjectList.pop();
	}

	public boolean inObjectList() {
      return !inObjectList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObject = new java.util.Stack<>();

	@Override
	public void enterObject(com.generator.generators.sparql.parser.SparqlParser.ObjectContext arg) {
		onEnter(new Node("Object", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inObject.push(true);
	}

	public void exitObject(com.generator.generators.sparql.parser.SparqlParser.ObjectContext arg) {
		onExit();
		this.inObject.pop();
	}

	public boolean inObject() {
      return !inObject.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVerb = new java.util.Stack<>();

	@Override
	public void enterVerb(com.generator.generators.sparql.parser.SparqlParser.VerbContext arg) {
		onEnter(new Node("Verb", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inVerb.push(true);
	}

	public void exitVerb(com.generator.generators.sparql.parser.SparqlParser.VerbContext arg) {
		onExit();
		this.inVerb.pop();
	}

	public boolean inVerb() {
      return !inVerb.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTriplesNode = new java.util.Stack<>();

	@Override
	public void enterTriplesNode(com.generator.generators.sparql.parser.SparqlParser.TriplesNodeContext arg) {
		onEnter(new Node("TriplesNode", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inTriplesNode.push(true);
	}

	public void exitTriplesNode(com.generator.generators.sparql.parser.SparqlParser.TriplesNodeContext arg) {
		onExit();
		this.inTriplesNode.pop();
	}

	public boolean inTriplesNode() {
      return !inTriplesNode.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlankNodePropertyList = new java.util.Stack<>();

	@Override
	public void enterBlankNodePropertyList(com.generator.generators.sparql.parser.SparqlParser.BlankNodePropertyListContext arg) {
		onEnter(new Node("BlankNodePropertyList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inBlankNodePropertyList.push(true);
	}

	public void exitBlankNodePropertyList(com.generator.generators.sparql.parser.SparqlParser.BlankNodePropertyListContext arg) {
		onExit();
		this.inBlankNodePropertyList.pop();
	}

	public boolean inBlankNodePropertyList() {
      return !inBlankNodePropertyList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCollection = new java.util.Stack<>();

	@Override
	public void enterCollection(com.generator.generators.sparql.parser.SparqlParser.CollectionContext arg) {
		onEnter(new Node("Collection", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inCollection.push(true);
	}

	public void exitCollection(com.generator.generators.sparql.parser.SparqlParser.CollectionContext arg) {
		onExit();
		this.inCollection.pop();
	}

	public boolean inCollection() {
      return !inCollection.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGraphNode = new java.util.Stack<>();

	@Override
	public void enterGraphNode(com.generator.generators.sparql.parser.SparqlParser.GraphNodeContext arg) {
		onEnter(new Node("GraphNode", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inGraphNode.push(true);
	}

	public void exitGraphNode(com.generator.generators.sparql.parser.SparqlParser.GraphNodeContext arg) {
		onExit();
		this.inGraphNode.pop();
	}

	public boolean inGraphNode() {
      return !inGraphNode.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarOrTerm = new java.util.Stack<>();

	@Override
	public void enterVarOrTerm(com.generator.generators.sparql.parser.SparqlParser.VarOrTermContext arg) {
		onEnter(new Node("VarOrTerm", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inVarOrTerm.push(true);
	}

	public void exitVarOrTerm(com.generator.generators.sparql.parser.SparqlParser.VarOrTermContext arg) {
		onExit();
		this.inVarOrTerm.pop();
	}

	public boolean inVarOrTerm() {
      return !inVarOrTerm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarOrIRIref = new java.util.Stack<>();

	@Override
	public void enterVarOrIRIref(com.generator.generators.sparql.parser.SparqlParser.VarOrIRIrefContext arg) {
		onEnter(new Node("VarOrIRIref", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inVarOrIRIref.push(true);
	}

	public void exitVarOrIRIref(com.generator.generators.sparql.parser.SparqlParser.VarOrIRIrefContext arg) {
		onExit();
		this.inVarOrIRIref.pop();
	}

	public boolean inVarOrIRIref() {
      return !inVarOrIRIref.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGraphTerm = new java.util.Stack<>();

	@Override
	public void enterGraphTerm(com.generator.generators.sparql.parser.SparqlParser.GraphTermContext arg) {
		onEnter(new Node("GraphTerm", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inGraphTerm.push(true);
	}

	public void exitGraphTerm(com.generator.generators.sparql.parser.SparqlParser.GraphTermContext arg) {
		onExit();
		this.inGraphTerm.pop();
	}

	public boolean inGraphTerm() {
      return !inGraphTerm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConditionalOrExpression = new java.util.Stack<>();

	@Override
	public void enterConditionalOrExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalOrExpressionContext arg) {
		onEnter(new Node("ConditionalOrExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inConditionalOrExpression.push(true);
	}

	public void exitConditionalOrExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalOrExpressionContext arg) {
		onExit();
		this.inConditionalOrExpression.pop();
	}

	public boolean inConditionalOrExpression() {
      return !inConditionalOrExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConditionalAndExpression = new java.util.Stack<>();

	@Override
	public void enterConditionalAndExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalAndExpressionContext arg) {
		onEnter(new Node("ConditionalAndExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inConditionalAndExpression.push(true);
	}

	public void exitConditionalAndExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalAndExpressionContext arg) {
		onExit();
		this.inConditionalAndExpression.pop();
	}

	public boolean inConditionalAndExpression() {
      return !inConditionalAndExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inValueLogical = new java.util.Stack<>();

	@Override
	public void enterValueLogical(com.generator.generators.sparql.parser.SparqlParser.ValueLogicalContext arg) {
		onEnter(new Node("ValueLogical", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inValueLogical.push(true);
	}

	public void exitValueLogical(com.generator.generators.sparql.parser.SparqlParser.ValueLogicalContext arg) {
		onExit();
		this.inValueLogical.pop();
	}

	public boolean inValueLogical() {
      return !inValueLogical.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericExpression = new java.util.Stack<>();

	@Override
	public void enterNumericExpression(com.generator.generators.sparql.parser.SparqlParser.NumericExpressionContext arg) {
		onEnter(new Node("NumericExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNumericExpression.push(true);
	}

	public void exitNumericExpression(com.generator.generators.sparql.parser.SparqlParser.NumericExpressionContext arg) {
		onExit();
		this.inNumericExpression.pop();
	}

	public boolean inNumericExpression() {
      return !inNumericExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryExpression = new java.util.Stack<>();

	@Override
	public void enterUnaryExpression(com.generator.generators.sparql.parser.SparqlParser.UnaryExpressionContext arg) {
		onEnter(new Node("UnaryExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inUnaryExpression.push(true);
	}

	public void exitUnaryExpression(com.generator.generators.sparql.parser.SparqlParser.UnaryExpressionContext arg) {
		onExit();
		this.inUnaryExpression.pop();
	}

	public boolean inUnaryExpression() {
      return !inUnaryExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrimaryExpression = new java.util.Stack<>();

	@Override
	public void enterPrimaryExpression(com.generator.generators.sparql.parser.SparqlParser.PrimaryExpressionContext arg) {
		onEnter(new Node("PrimaryExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPrimaryExpression.push(true);
	}

	public void exitPrimaryExpression(com.generator.generators.sparql.parser.SparqlParser.PrimaryExpressionContext arg) {
		onExit();
		this.inPrimaryExpression.pop();
	}

	public boolean inPrimaryExpression() {
      return !inPrimaryExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBrackettedExpression = new java.util.Stack<>();

	@Override
	public void enterBrackettedExpression(com.generator.generators.sparql.parser.SparqlParser.BrackettedExpressionContext arg) {
		onEnter(new Node("BrackettedExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inBrackettedExpression.push(true);
	}

	public void exitBrackettedExpression(com.generator.generators.sparql.parser.SparqlParser.BrackettedExpressionContext arg) {
		onExit();
		this.inBrackettedExpression.pop();
	}

	public boolean inBrackettedExpression() {
      return !inBrackettedExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBuiltInCall = new java.util.Stack<>();

	@Override
	public void enterBuiltInCall(com.generator.generators.sparql.parser.SparqlParser.BuiltInCallContext arg) {
		onEnter(new Node("BuiltInCall", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inBuiltInCall.push(true);
	}

	public void exitBuiltInCall(com.generator.generators.sparql.parser.SparqlParser.BuiltInCallContext arg) {
		onExit();
		this.inBuiltInCall.pop();
	}

	public boolean inBuiltInCall() {
      return !inBuiltInCall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRegexExpression = new java.util.Stack<>();

	@Override
	public void enterRegexExpression(com.generator.generators.sparql.parser.SparqlParser.RegexExpressionContext arg) {
		onEnter(new Node("RegexExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inRegexExpression.push(true);
	}

	public void exitRegexExpression(com.generator.generators.sparql.parser.SparqlParser.RegexExpressionContext arg) {
		onExit();
		this.inRegexExpression.pop();
	}

	public boolean inRegexExpression() {
      return !inRegexExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIriRefOrFunction = new java.util.Stack<>();

	@Override
	public void enterIriRefOrFunction(com.generator.generators.sparql.parser.SparqlParser.IriRefOrFunctionContext arg) {
		onEnter(new Node("IriRefOrFunction", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inIriRefOrFunction.push(true);
	}

	public void exitIriRefOrFunction(com.generator.generators.sparql.parser.SparqlParser.IriRefOrFunctionContext arg) {
		onExit();
		this.inIriRefOrFunction.pop();
	}

	public boolean inIriRefOrFunction() {
      return !inIriRefOrFunction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRdfLiteral = new java.util.Stack<>();

	@Override
	public void enterRdfLiteral(com.generator.generators.sparql.parser.SparqlParser.RdfLiteralContext arg) {
		onEnter(new Node("RdfLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inRdfLiteral.push(true);
	}

	public void exitRdfLiteral(com.generator.generators.sparql.parser.SparqlParser.RdfLiteralContext arg) {
		onExit();
		this.inRdfLiteral.pop();
	}

	public boolean inRdfLiteral() {
      return !inRdfLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericLiteralUnsigned = new java.util.Stack<>();

	@Override
	public void enterNumericLiteralUnsigned(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralUnsignedContext arg) {
		onEnter(new Node("NumericLiteralUnsigned", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNumericLiteralUnsigned.push(true);
	}

	public void exitNumericLiteralUnsigned(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralUnsignedContext arg) {
		onExit();
		this.inNumericLiteralUnsigned.pop();
	}

	public boolean inNumericLiteralUnsigned() {
      return !inNumericLiteralUnsigned.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericLiteralPositive = new java.util.Stack<>();

	@Override
	public void enterNumericLiteralPositive(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralPositiveContext arg) {
		onEnter(new Node("NumericLiteralPositive", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNumericLiteralPositive.push(true);
	}

	public void exitNumericLiteralPositive(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralPositiveContext arg) {
		onExit();
		this.inNumericLiteralPositive.pop();
	}

	public boolean inNumericLiteralPositive() {
      return !inNumericLiteralPositive.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericLiteralNegative = new java.util.Stack<>();

	@Override
	public void enterNumericLiteralNegative(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralNegativeContext arg) {
		onEnter(new Node("NumericLiteralNegative", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNumericLiteralNegative.push(true);
	}

	public void exitNumericLiteralNegative(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralNegativeContext arg) {
		onExit();
		this.inNumericLiteralNegative.pop();
	}

	public boolean inNumericLiteralNegative() {
      return !inNumericLiteralNegative.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIriRef = new java.util.Stack<>();

	@Override
	public void enterIriRef(com.generator.generators.sparql.parser.SparqlParser.IriRefContext arg) {
		onEnter(new Node("IriRef", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inIriRef.push(true);
	}

	public void exitIriRef(com.generator.generators.sparql.parser.SparqlParser.IriRefContext arg) {
		onExit();
		this.inIriRef.pop();
	}

	public boolean inIriRef() {
      return !inIriRef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrefixedName = new java.util.Stack<>();

	@Override
	public void enterPrefixedName(com.generator.generators.sparql.parser.SparqlParser.PrefixedNameContext arg) {
		onEnter(new Node("PrefixedName", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPrefixedName.push(true);
	}

	public void exitPrefixedName(com.generator.generators.sparql.parser.SparqlParser.PrefixedNameContext arg) {
		onExit();
		this.inPrefixedName.pop();
	}

	public boolean inPrefixedName() {
      return !inPrefixedName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlankNode = new java.util.Stack<>();

	@Override
	public void enterBlankNode(com.generator.generators.sparql.parser.SparqlParser.BlankNodeContext arg) {
		onEnter(new Node("BlankNode", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inBlankNode.push(true);
	}

	public void exitBlankNode(com.generator.generators.sparql.parser.SparqlParser.BlankNodeContext arg) {
		onExit();
		this.inBlankNode.pop();
	}

	public boolean inBlankNode() {
      return !inBlankNode.isEmpty(); 
   }

}