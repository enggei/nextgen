package com.generator.generators.sparql.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class SparqlNeoListener extends SparqlBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public SparqlNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public SparqlNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inLimitOffsetClauses = new java.util.Stack<>();

	@Override
	public void enterLimitOffsetClauses(com.generator.generators.sparql.parser.SparqlParser.LimitOffsetClausesContext arg) {
		final Node node = model.findOrCreate(Label.label("LimitOffsetClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLimitOffsetClauses.push(true);
	}

	public void exitLimitOffsetClauses(com.generator.generators.sparql.parser.SparqlParser.LimitOffsetClausesContext arg) {
		onExit();
		this.inLimitOffsetClauses.pop();
	}

	public boolean inLimitOffsetClauses() {
      return !inLimitOffsetClauses.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrderCondition = new java.util.Stack<>();

	@Override
	public void enterOrderCondition(com.generator.generators.sparql.parser.SparqlParser.OrderConditionContext arg) {
		final Node node = model.findOrCreate(Label.label("OrderCondition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("LimitClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OffsetClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("GroupGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("TriplesBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("GraphPatternNotTriples"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OptionalGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("GraphGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("GroupOrUnionGraphPattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Filter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Constraint"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("FunctionCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ArgList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ConstructTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ConstructTriples"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("TriplesSameSubject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PropertyListNotEmpty"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PropertyList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Object"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Verb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("TriplesNode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("BlankNodePropertyList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Collection"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("GraphNode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("VarOrTerm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("VarOrIRIref"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inVarOrIRIref.push(true);
	}

	public void exitVarOrIRIref(com.generator.generators.sparql.parser.SparqlParser.VarOrIRIrefContext arg) {
		onExit();
		this.inVarOrIRIref.pop();
	}

	public boolean inVarOrIRIref() {
      return !inVarOrIRIref.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVar = new java.util.Stack<>();

	@Override
	public void enterVar(com.generator.generators.sparql.parser.SparqlParser.VarContext arg) {
		final Node node = model.findOrCreate(Label.label("Var"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inVar.push(true);
	}

	public void exitVar(com.generator.generators.sparql.parser.SparqlParser.VarContext arg) {
		onExit();
		this.inVar.pop();
	}

	public boolean inVar() {
      return !inVar.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGraphTerm = new java.util.Stack<>();

	@Override
	public void enterGraphTerm(com.generator.generators.sparql.parser.SparqlParser.GraphTermContext arg) {
		final Node node = model.findOrCreate(Label.label("GraphTerm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inGraphTerm.push(true);
	}

	public void exitGraphTerm(com.generator.generators.sparql.parser.SparqlParser.GraphTermContext arg) {
		onExit();
		this.inGraphTerm.pop();
	}

	public boolean inGraphTerm() {
      return !inGraphTerm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.sparql.parser.SparqlParser.ExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.sparql.parser.SparqlParser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConditionalOrExpression = new java.util.Stack<>();

	@Override
	public void enterConditionalOrExpression(com.generator.generators.sparql.parser.SparqlParser.ConditionalOrExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ConditionalOrExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ConditionalAndExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ValueLogical"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inValueLogical.push(true);
	}

	public void exitValueLogical(com.generator.generators.sparql.parser.SparqlParser.ValueLogicalContext arg) {
		onExit();
		this.inValueLogical.pop();
	}

	public boolean inValueLogical() {
      return !inValueLogical.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationalExpression = new java.util.Stack<>();

	@Override
	public void enterRelationalExpression(com.generator.generators.sparql.parser.SparqlParser.RelationalExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("RelationalExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRelationalExpression.push(true);
	}

	public void exitRelationalExpression(com.generator.generators.sparql.parser.SparqlParser.RelationalExpressionContext arg) {
		onExit();
		this.inRelationalExpression.pop();
	}

	public boolean inRelationalExpression() {
      return !inRelationalExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericExpression = new java.util.Stack<>();

	@Override
	public void enterNumericExpression(com.generator.generators.sparql.parser.SparqlParser.NumericExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("NumericExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNumericExpression.push(true);
	}

	public void exitNumericExpression(com.generator.generators.sparql.parser.SparqlParser.NumericExpressionContext arg) {
		onExit();
		this.inNumericExpression.pop();
	}

	public boolean inNumericExpression() {
      return !inNumericExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAdditiveExpression = new java.util.Stack<>();

	@Override
	public void enterAdditiveExpression(com.generator.generators.sparql.parser.SparqlParser.AdditiveExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("AdditiveExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAdditiveExpression.push(true);
	}

	public void exitAdditiveExpression(com.generator.generators.sparql.parser.SparqlParser.AdditiveExpressionContext arg) {
		onExit();
		this.inAdditiveExpression.pop();
	}

	public boolean inAdditiveExpression() {
      return !inAdditiveExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiplicativeExpression = new java.util.Stack<>();

	@Override
	public void enterMultiplicativeExpression(com.generator.generators.sparql.parser.SparqlParser.MultiplicativeExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("MultiplicativeExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMultiplicativeExpression.push(true);
	}

	public void exitMultiplicativeExpression(com.generator.generators.sparql.parser.SparqlParser.MultiplicativeExpressionContext arg) {
		onExit();
		this.inMultiplicativeExpression.pop();
	}

	public boolean inMultiplicativeExpression() {
      return !inMultiplicativeExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryExpression = new java.util.Stack<>();

	@Override
	public void enterUnaryExpression(com.generator.generators.sparql.parser.SparqlParser.UnaryExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("UnaryExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PrimaryExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("BrackettedExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("BuiltInCall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RegexExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("IriRefOrFunction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("RdfLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRdfLiteral.push(true);
	}

	public void exitRdfLiteral(com.generator.generators.sparql.parser.SparqlParser.RdfLiteralContext arg) {
		onExit();
		this.inRdfLiteral.pop();
	}

	public boolean inRdfLiteral() {
      return !inRdfLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericLiteral = new java.util.Stack<>();

	@Override
	public void enterNumericLiteral(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("NumericLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNumericLiteral.push(true);
	}

	public void exitNumericLiteral(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralContext arg) {
		onExit();
		this.inNumericLiteral.pop();
	}

	public boolean inNumericLiteral() {
      return !inNumericLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumericLiteralUnsigned = new java.util.Stack<>();

	@Override
	public void enterNumericLiteralUnsigned(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralUnsignedContext arg) {
		final Node node = model.findOrCreate(Label.label("NumericLiteralUnsigned"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NumericLiteralPositive"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NumericLiteralNegative"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNumericLiteralNegative.push(true);
	}

	public void exitNumericLiteralNegative(com.generator.generators.sparql.parser.SparqlParser.NumericLiteralNegativeContext arg) {
		onExit();
		this.inNumericLiteralNegative.pop();
	}

	public boolean inNumericLiteralNegative() {
      return !inNumericLiteralNegative.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBooleanLiteral = new java.util.Stack<>();

	@Override
	public void enterBooleanLiteral(com.generator.generators.sparql.parser.SparqlParser.BooleanLiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("BooleanLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBooleanLiteral.push(true);
	}

	public void exitBooleanLiteral(com.generator.generators.sparql.parser.SparqlParser.BooleanLiteralContext arg) {
		onExit();
		this.inBooleanLiteral.pop();
	}

	public boolean inBooleanLiteral() {
      return !inBooleanLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inString = new java.util.Stack<>();

	@Override
	public void enterString(com.generator.generators.sparql.parser.SparqlParser.StringContext arg) {
		final Node node = model.findOrCreate(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inString.push(true);
	}

	public void exitString(com.generator.generators.sparql.parser.SparqlParser.StringContext arg) {
		onExit();
		this.inString.pop();
	}

	public boolean inString() {
      return !inString.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIriRef = new java.util.Stack<>();

	@Override
	public void enterIriRef(com.generator.generators.sparql.parser.SparqlParser.IriRefContext arg) {
		final Node node = model.findOrCreate(Label.label("IriRef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("PrefixedName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("BlankNode"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBlankNode.push(true);
	}

	public void exitBlankNode(com.generator.generators.sparql.parser.SparqlParser.BlankNodeContext arg) {
		onExit();
		this.inBlankNode.pop();
	}

	public boolean inBlankNode() {
      return !inBlankNode.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery = new java.util.Stack<>();

	@Override
	public void enterQuery(com.generator.generators.sparql.parser.SparqlParser.QueryContext arg) {
		final Node node = model.findOrCreate(Label.label("Query"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inQuery.push(true);
	}

	public void exitQuery(com.generator.generators.sparql.parser.SparqlParser.QueryContext arg) {
		onExit();
		this.inQuery.pop();
	}

	public boolean inQuery() {
      return !inQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstructQuery = new java.util.Stack<>();

	@Override
	public void enterConstructQuery(com.generator.generators.sparql.parser.SparqlParser.ConstructQueryContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstructQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConstructQuery.push(true);
	}

	public void exitConstructQuery(com.generator.generators.sparql.parser.SparqlParser.ConstructQueryContext arg) {
		onExit();
		this.inConstructQuery.pop();
	}

	public boolean inConstructQuery() {
      return !inConstructQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrologue = new java.util.Stack<>();

	@Override
	public void enterPrologue(com.generator.generators.sparql.parser.SparqlParser.PrologueContext arg) {
		final Node node = model.findOrCreate(Label.label("Prologue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("BaseDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBaseDecl.push(true);
	}

	public void exitBaseDecl(com.generator.generators.sparql.parser.SparqlParser.BaseDeclContext arg) {
		onExit();
		this.inBaseDecl.pop();
	}

	public boolean inBaseDecl() {
      return !inBaseDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAskQuery = new java.util.Stack<>();

	@Override
	public void enterAskQuery(com.generator.generators.sparql.parser.SparqlParser.AskQueryContext arg) {
		final Node node = model.findOrCreate(Label.label("AskQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAskQuery.push(true);
	}

	public void exitAskQuery(com.generator.generators.sparql.parser.SparqlParser.AskQueryContext arg) {
		onExit();
		this.inAskQuery.pop();
	}

	public boolean inAskQuery() {
      return !inAskQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrefixDecl = new java.util.Stack<>();

	@Override
	public void enterPrefixDecl(com.generator.generators.sparql.parser.SparqlParser.PrefixDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("PrefixDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SelectQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSelectQuery.push(true);
	}

	public void exitSelectQuery(com.generator.generators.sparql.parser.SparqlParser.SelectQueryContext arg) {
		onExit();
		this.inSelectQuery.pop();
	}

	public boolean inSelectQuery() {
      return !inSelectQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDescribeQuery = new java.util.Stack<>();

	@Override
	public void enterDescribeQuery(com.generator.generators.sparql.parser.SparqlParser.DescribeQueryContext arg) {
		final Node node = model.findOrCreate(Label.label("DescribeQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDescribeQuery.push(true);
	}

	public void exitDescribeQuery(com.generator.generators.sparql.parser.SparqlParser.DescribeQueryContext arg) {
		onExit();
		this.inDescribeQuery.pop();
	}

	public boolean inDescribeQuery() {
      return !inDescribeQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSolutionModifier = new java.util.Stack<>();

	@Override
	public void enterSolutionModifier(com.generator.generators.sparql.parser.SparqlParser.SolutionModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("SolutionModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSolutionModifier.push(true);
	}

	public void exitSolutionModifier(com.generator.generators.sparql.parser.SparqlParser.SolutionModifierContext arg) {
		onExit();
		this.inSolutionModifier.pop();
	}

	public boolean inSolutionModifier() {
      return !inSolutionModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOrderClause = new java.util.Stack<>();

	@Override
	public void enterOrderClause(com.generator.generators.sparql.parser.SparqlParser.OrderClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("OrderClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOrderClause.push(true);
	}

	public void exitOrderClause(com.generator.generators.sparql.parser.SparqlParser.OrderClauseContext arg) {
		onExit();
		this.inOrderClause.pop();
	}

	public boolean inOrderClause() {
      return !inOrderClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDatasetClause = new java.util.Stack<>();

	@Override
	public void enterDatasetClause(com.generator.generators.sparql.parser.SparqlParser.DatasetClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("DatasetClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("DefaultGraphClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NamedGraphClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("SourceSelector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("WhereClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inWhereClause.push(true);
	}

	public void exitWhereClause(com.generator.generators.sparql.parser.SparqlParser.WhereClauseContext arg) {
		onExit();
		this.inWhereClause.pop();
	}

	public boolean inWhereClause() {
      return !inWhereClause.isEmpty(); 
   }

}