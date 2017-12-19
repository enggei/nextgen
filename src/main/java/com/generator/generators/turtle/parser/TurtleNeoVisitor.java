package com.generator.generators.turtle.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class TurtleNeoVisitor extends TurtleBaseVisitor<Node> {

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
	public Node visitPrefixID(com.generator.generators.turtle.parser.TurtleParser.PrefixIDContext arg) {
		System.out.println("PrefixID");
		final Node node = model.newNode(Label.label("PrefixID"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.turtle.parser.TurtleParser.StatementContext arg) {
		System.out.println("Statement");
		final Node node = model.newNode(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTurtleDoc(com.generator.generators.turtle.parser.TurtleParser.TurtleDocContext arg) {
		System.out.println("TurtleDoc");
		final Node node = model.newNode(Label.label("TurtleDoc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDirective(com.generator.generators.turtle.parser.TurtleParser.DirectiveContext arg) {
		System.out.println("Directive");
		final Node node = model.newNode(Label.label("Directive"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBase(com.generator.generators.turtle.parser.TurtleParser.BaseContext arg) {
		System.out.println("Base");
		final Node node = model.newNode(Label.label("Base"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSparqlBase(com.generator.generators.turtle.parser.TurtleParser.SparqlBaseContext arg) {
		System.out.println("SparqlBase");
		final Node node = model.newNode(Label.label("SparqlBase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSparqlPrefix(com.generator.generators.turtle.parser.TurtleParser.SparqlPrefixContext arg) {
		System.out.println("SparqlPrefix");
		final Node node = model.newNode(Label.label("SparqlPrefix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTriples(com.generator.generators.turtle.parser.TurtleParser.TriplesContext arg) {
		System.out.println("Triples");
		final Node node = model.newNode(Label.label("Triples"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicateObjectList(com.generator.generators.turtle.parser.TurtleParser.PredicateObjectListContext arg) {
		System.out.println("PredicateObjectList");
		final Node node = model.newNode(Label.label("PredicateObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectList(com.generator.generators.turtle.parser.TurtleParser.ObjectListContext arg) {
		System.out.println("ObjectList");
		final Node node = model.newNode(Label.label("ObjectList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVerb(com.generator.generators.turtle.parser.TurtleParser.VerbContext arg) {
		System.out.println("Verb");
		final Node node = model.newNode(Label.label("Verb"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubject(com.generator.generators.turtle.parser.TurtleParser.SubjectContext arg) {
		System.out.println("Subject");
		final Node node = model.newNode(Label.label("Subject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPredicate(com.generator.generators.turtle.parser.TurtleParser.PredicateContext arg) {
		System.out.println("Predicate");
		final Node node = model.newNode(Label.label("Predicate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObject(com.generator.generators.turtle.parser.TurtleParser.ObjectContext arg) {
		System.out.println("Object");
		final Node node = model.newNode(Label.label("Object"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.turtle.parser.TurtleParser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlankNodePropertyList(com.generator.generators.turtle.parser.TurtleParser.BlankNodePropertyListContext arg) {
		System.out.println("BlankNodePropertyList");
		final Node node = model.newNode(Label.label("BlankNodePropertyList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCollection(com.generator.generators.turtle.parser.TurtleParser.CollectionContext arg) {
		System.out.println("Collection");
		final Node node = model.newNode(Label.label("Collection"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRdfLiteral(com.generator.generators.turtle.parser.TurtleParser.RdfLiteralContext arg) {
		System.out.println("RdfLiteral");
		final Node node = model.newNode(Label.label("RdfLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIri(com.generator.generators.turtle.parser.TurtleParser.IriContext arg) {
		System.out.println("Iri");
		final Node node = model.newNode(Label.label("Iri"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}