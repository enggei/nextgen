package com.generator.generators.turtle.parser;

public class TurtleNodeVisitor extends TurtleBaseVisitor<TurtleNodeVisitor.Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TurtleNodeVisitor.class);

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

	public TurtleNodeVisitor() {
		this(false);
	}

	public TurtleNodeVisitor(boolean debug) {
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

	@Override
	public Node visitLiteral(com.generator.generators.turtle.parser.TurtleParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.turtle.parser.TurtleParser.StatementContext arg) {
		final Node node = new Node("Statement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDirective(com.generator.generators.turtle.parser.TurtleParser.DirectiveContext arg) {
		final Node node = new Node("Directive", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectList(com.generator.generators.turtle.parser.TurtleParser.ObjectListContext arg) {
		final Node node = new Node("ObjectList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObject(com.generator.generators.turtle.parser.TurtleParser.ObjectContext arg) {
		final Node node = new Node("Object", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVerb(com.generator.generators.turtle.parser.TurtleParser.VerbContext arg) {
		final Node node = new Node("Verb", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlankNodePropertyList(com.generator.generators.turtle.parser.TurtleParser.BlankNodePropertyListContext arg) {
		final Node node = new Node("BlankNodePropertyList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollection(com.generator.generators.turtle.parser.TurtleParser.CollectionContext arg) {
		final Node node = new Node("Collection", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRdfLiteral(com.generator.generators.turtle.parser.TurtleParser.RdfLiteralContext arg) {
		final Node node = new Node("RdfLiteral", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIri(com.generator.generators.turtle.parser.TurtleParser.IriContext arg) {
		final Node node = new Node("Iri", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTurtleDoc(com.generator.generators.turtle.parser.TurtleParser.TurtleDocContext arg) {
		final Node node = new Node("TurtleDoc", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixID(com.generator.generators.turtle.parser.TurtleParser.PrefixIDContext arg) {
		final Node node = new Node("PrefixID", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBase(com.generator.generators.turtle.parser.TurtleParser.BaseContext arg) {
		final Node node = new Node("Base", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSparqlBase(com.generator.generators.turtle.parser.TurtleParser.SparqlBaseContext arg) {
		final Node node = new Node("SparqlBase", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSparqlPrefix(com.generator.generators.turtle.parser.TurtleParser.SparqlPrefixContext arg) {
		final Node node = new Node("SparqlPrefix", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriples(com.generator.generators.turtle.parser.TurtleParser.TriplesContext arg) {
		final Node node = new Node("Triples", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicateObjectList(com.generator.generators.turtle.parser.TurtleParser.PredicateObjectListContext arg) {
		final Node node = new Node("PredicateObjectList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubject(com.generator.generators.turtle.parser.TurtleParser.SubjectContext arg) {
		final Node node = new Node("Subject", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicate(com.generator.generators.turtle.parser.TurtleParser.PredicateContext arg) {
		final Node node = new Node("Predicate", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}