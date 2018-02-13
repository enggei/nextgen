package com.generator.generators.turtle.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class TurtleNeoListener extends TurtleBaseListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TurtleNeoListener.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public TurtleNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public TurtleNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) log.debug(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.turtle.parser.TurtleParser.StatementContext arg) {
		final Node node = model.newNode(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.turtle.parser.TurtleParser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return !inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.turtle.parser.TurtleParser.LiteralContext arg) {
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.turtle.parser.TurtleParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDirective = new java.util.Stack<>();

	@Override
	public void enterDirective(com.generator.generators.turtle.parser.TurtleParser.DirectiveContext arg) {
		final Node node = model.newNode(Label.label("Directive"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDirective.push(true);
	}

	public void exitDirective(com.generator.generators.turtle.parser.TurtleParser.DirectiveContext arg) {
		onExit();
		this.inDirective.pop();
	}

	public boolean inDirective() {
      return !inDirective.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObjectList = new java.util.Stack<>();

	@Override
	public void enterObjectList(com.generator.generators.turtle.parser.TurtleParser.ObjectListContext arg) {
		final Node node = model.newNode(Label.label("ObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inObjectList.push(true);
	}

	public void exitObjectList(com.generator.generators.turtle.parser.TurtleParser.ObjectListContext arg) {
		onExit();
		this.inObjectList.pop();
	}

	public boolean inObjectList() {
      return !inObjectList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObject = new java.util.Stack<>();

	@Override
	public void enterObject(com.generator.generators.turtle.parser.TurtleParser.ObjectContext arg) {
		final Node node = model.newNode(Label.label("Object"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inObject.push(true);
	}

	public void exitObject(com.generator.generators.turtle.parser.TurtleParser.ObjectContext arg) {
		onExit();
		this.inObject.pop();
	}

	public boolean inObject() {
      return !inObject.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVerb = new java.util.Stack<>();

	@Override
	public void enterVerb(com.generator.generators.turtle.parser.TurtleParser.VerbContext arg) {
		final Node node = model.newNode(Label.label("Verb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVerb.push(true);
	}

	public void exitVerb(com.generator.generators.turtle.parser.TurtleParser.VerbContext arg) {
		onExit();
		this.inVerb.pop();
	}

	public boolean inVerb() {
      return !inVerb.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlankNodePropertyList = new java.util.Stack<>();

	@Override
	public void enterBlankNodePropertyList(com.generator.generators.turtle.parser.TurtleParser.BlankNodePropertyListContext arg) {
		final Node node = model.newNode(Label.label("BlankNodePropertyList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlankNodePropertyList.push(true);
	}

	public void exitBlankNodePropertyList(com.generator.generators.turtle.parser.TurtleParser.BlankNodePropertyListContext arg) {
		onExit();
		this.inBlankNodePropertyList.pop();
	}

	public boolean inBlankNodePropertyList() {
      return !inBlankNodePropertyList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCollection = new java.util.Stack<>();

	@Override
	public void enterCollection(com.generator.generators.turtle.parser.TurtleParser.CollectionContext arg) {
		final Node node = model.newNode(Label.label("Collection"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCollection.push(true);
	}

	public void exitCollection(com.generator.generators.turtle.parser.TurtleParser.CollectionContext arg) {
		onExit();
		this.inCollection.pop();
	}

	public boolean inCollection() {
      return !inCollection.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRdfLiteral = new java.util.Stack<>();

	@Override
	public void enterRdfLiteral(com.generator.generators.turtle.parser.TurtleParser.RdfLiteralContext arg) {
		final Node node = model.newNode(Label.label("RdfLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRdfLiteral.push(true);
	}

	public void exitRdfLiteral(com.generator.generators.turtle.parser.TurtleParser.RdfLiteralContext arg) {
		onExit();
		this.inRdfLiteral.pop();
	}

	public boolean inRdfLiteral() {
      return !inRdfLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubject = new java.util.Stack<>();

	@Override
	public void enterSubject(com.generator.generators.turtle.parser.TurtleParser.SubjectContext arg) {
		final Node node = model.newNode(Label.label("Subject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSubject.push(true);
	}

	public void exitSubject(com.generator.generators.turtle.parser.TurtleParser.SubjectContext arg) {
		onExit();
		this.inSubject.pop();
	}

	public boolean inSubject() {
      return !inSubject.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPredicate = new java.util.Stack<>();

	@Override
	public void enterPredicate(com.generator.generators.turtle.parser.TurtleParser.PredicateContext arg) {
		final Node node = model.newNode(Label.label("Predicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPredicate.push(true);
	}

	public void exitPredicate(com.generator.generators.turtle.parser.TurtleParser.PredicateContext arg) {
		onExit();
		this.inPredicate.pop();
	}

	public boolean inPredicate() {
      return !inPredicate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIri = new java.util.Stack<>();

	@Override
	public void enterIri(com.generator.generators.turtle.parser.TurtleParser.IriContext arg) {
		final Node node = model.newNode(Label.label("Iri"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIri.push(true);
	}

	public void exitIri(com.generator.generators.turtle.parser.TurtleParser.IriContext arg) {
		onExit();
		this.inIri.pop();
	}

	public boolean inIri() {
      return !inIri.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTurtleDoc = new java.util.Stack<>();

	@Override
	public void enterTurtleDoc(com.generator.generators.turtle.parser.TurtleParser.TurtleDocContext arg) {
		final Node node = model.newNode(Label.label("TurtleDoc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTurtleDoc.push(true);
	}

	public void exitTurtleDoc(com.generator.generators.turtle.parser.TurtleParser.TurtleDocContext arg) {
		onExit();
		this.inTurtleDoc.pop();
	}

	public boolean inTurtleDoc() {
      return !inTurtleDoc.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrefixID = new java.util.Stack<>();

	@Override
	public void enterPrefixID(com.generator.generators.turtle.parser.TurtleParser.PrefixIDContext arg) {
		final Node node = model.newNode(Label.label("PrefixID"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrefixID.push(true);
	}

	public void exitPrefixID(com.generator.generators.turtle.parser.TurtleParser.PrefixIDContext arg) {
		onExit();
		this.inPrefixID.pop();
	}

	public boolean inPrefixID() {
      return !inPrefixID.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBase = new java.util.Stack<>();

	@Override
	public void enterBase(com.generator.generators.turtle.parser.TurtleParser.BaseContext arg) {
		final Node node = model.newNode(Label.label("Base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBase.push(true);
	}

	public void exitBase(com.generator.generators.turtle.parser.TurtleParser.BaseContext arg) {
		onExit();
		this.inBase.pop();
	}

	public boolean inBase() {
      return !inBase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSparqlBase = new java.util.Stack<>();

	@Override
	public void enterSparqlBase(com.generator.generators.turtle.parser.TurtleParser.SparqlBaseContext arg) {
		final Node node = model.newNode(Label.label("SparqlBase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSparqlBase.push(true);
	}

	public void exitSparqlBase(com.generator.generators.turtle.parser.TurtleParser.SparqlBaseContext arg) {
		onExit();
		this.inSparqlBase.pop();
	}

	public boolean inSparqlBase() {
      return !inSparqlBase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSparqlPrefix = new java.util.Stack<>();

	@Override
	public void enterSparqlPrefix(com.generator.generators.turtle.parser.TurtleParser.SparqlPrefixContext arg) {
		final Node node = model.newNode(Label.label("SparqlPrefix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSparqlPrefix.push(true);
	}

	public void exitSparqlPrefix(com.generator.generators.turtle.parser.TurtleParser.SparqlPrefixContext arg) {
		onExit();
		this.inSparqlPrefix.pop();
	}

	public boolean inSparqlPrefix() {
      return !inSparqlPrefix.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTriples = new java.util.Stack<>();

	@Override
	public void enterTriples(com.generator.generators.turtle.parser.TurtleParser.TriplesContext arg) {
		final Node node = model.newNode(Label.label("Triples"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTriples.push(true);
	}

	public void exitTriples(com.generator.generators.turtle.parser.TurtleParser.TriplesContext arg) {
		onExit();
		this.inTriples.pop();
	}

	public boolean inTriples() {
      return !inTriples.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPredicateObjectList = new java.util.Stack<>();

	@Override
	public void enterPredicateObjectList(com.generator.generators.turtle.parser.TurtleParser.PredicateObjectListContext arg) {
		final Node node = model.newNode(Label.label("PredicateObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPredicateObjectList.push(true);
	}

	public void exitPredicateObjectList(com.generator.generators.turtle.parser.TurtleParser.PredicateObjectListContext arg) {
		onExit();
		this.inPredicateObjectList.pop();
	}

	public boolean inPredicateObjectList() {
      return !inPredicateObjectList.isEmpty(); 
   }

}