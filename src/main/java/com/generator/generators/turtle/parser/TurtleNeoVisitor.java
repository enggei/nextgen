package com.generator.generators.turtle.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class TurtleNeoVisitor extends TurtleBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TurtleNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public TurtleNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitLiteral(com.generator.generators.turtle.parser.TurtleParser.LiteralContext arg) {
		log.info("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.turtle.parser.TurtleParser.StatementContext arg) {
		log.info("Statement");
		final Node node = model.newNode(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDirective(com.generator.generators.turtle.parser.TurtleParser.DirectiveContext arg) {
		log.info("Directive");
		final Node node = model.newNode(Label.label("Directive"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectList(com.generator.generators.turtle.parser.TurtleParser.ObjectListContext arg) {
		log.info("ObjectList");
		final Node node = model.newNode(Label.label("ObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObject(com.generator.generators.turtle.parser.TurtleParser.ObjectContext arg) {
		log.info("Object");
		final Node node = model.newNode(Label.label("Object"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVerb(com.generator.generators.turtle.parser.TurtleParser.VerbContext arg) {
		log.info("Verb");
		final Node node = model.newNode(Label.label("Verb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlankNodePropertyList(com.generator.generators.turtle.parser.TurtleParser.BlankNodePropertyListContext arg) {
		log.info("BlankNodePropertyList");
		final Node node = model.newNode(Label.label("BlankNodePropertyList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollection(com.generator.generators.turtle.parser.TurtleParser.CollectionContext arg) {
		log.info("Collection");
		final Node node = model.newNode(Label.label("Collection"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRdfLiteral(com.generator.generators.turtle.parser.TurtleParser.RdfLiteralContext arg) {
		log.info("RdfLiteral");
		final Node node = model.newNode(Label.label("RdfLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIri(com.generator.generators.turtle.parser.TurtleParser.IriContext arg) {
		log.info("Iri");
		final Node node = model.newNode(Label.label("Iri"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTurtleDoc(com.generator.generators.turtle.parser.TurtleParser.TurtleDocContext arg) {
		log.info("TurtleDoc");
		final Node node = model.newNode(Label.label("TurtleDoc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixID(com.generator.generators.turtle.parser.TurtleParser.PrefixIDContext arg) {
		log.info("PrefixID");
		final Node node = model.newNode(Label.label("PrefixID"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBase(com.generator.generators.turtle.parser.TurtleParser.BaseContext arg) {
		log.info("Base");
		final Node node = model.newNode(Label.label("Base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSparqlBase(com.generator.generators.turtle.parser.TurtleParser.SparqlBaseContext arg) {
		log.info("SparqlBase");
		final Node node = model.newNode(Label.label("SparqlBase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSparqlPrefix(com.generator.generators.turtle.parser.TurtleParser.SparqlPrefixContext arg) {
		log.info("SparqlPrefix");
		final Node node = model.newNode(Label.label("SparqlPrefix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriples(com.generator.generators.turtle.parser.TurtleParser.TriplesContext arg) {
		log.info("Triples");
		final Node node = model.newNode(Label.label("Triples"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicateObjectList(com.generator.generators.turtle.parser.TurtleParser.PredicateObjectListContext arg) {
		log.info("PredicateObjectList");
		final Node node = model.newNode(Label.label("PredicateObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubject(com.generator.generators.turtle.parser.TurtleParser.SubjectContext arg) {
		log.info("Subject");
		final Node node = model.newNode(Label.label("Subject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicate(com.generator.generators.turtle.parser.TurtleParser.PredicateContext arg) {
		log.info("Predicate");
		final Node node = model.newNode(Label.label("Predicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}