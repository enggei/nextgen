package com.generator.generators.turtle.parser;

public class TurtleNodeListener extends TurtleBaseListener {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TurtleNodeListener.class);

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

	public TurtleNodeListener() {
		this(false);
	}

	public TurtleNodeListener(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) log.debug(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Directive", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ObjectList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Object", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Verb", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("BlankNodePropertyList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Collection", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("RdfLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Subject", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Predicate", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Iri", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TurtleDoc", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PrefixID", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Base", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SparqlBase", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SparqlPrefix", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Triples", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PredicateObjectList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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