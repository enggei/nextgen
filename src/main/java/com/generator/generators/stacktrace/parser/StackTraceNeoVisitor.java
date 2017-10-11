package com.generator.generators.stacktrace.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class StackTraceNeoVisitor extends StackTraceBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public StackTraceNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		System.out.println("Identifier");
		final Node node = model.newNode(Label.label("Identifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		System.out.println("StackTrace");
		final Node node = model.newNode(Label.label("StackTrace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		System.out.println("ClassName");
		final Node node = model.newNode(Label.label("ClassName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		System.out.println("Message");
		final Node node = model.newNode(Label.label("Message"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		System.out.println("StackTraceLine");
		final Node node = model.newNode(Label.label("StackTraceLine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		System.out.println("AtLine");
		final Node node = model.newNode(Label.label("AtLine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		System.out.println("CausedByLine");
		final Node node = model.newNode(Label.label("CausedByLine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		System.out.println("EllipsisLine");
		final Node node = model.newNode(Label.label("EllipsisLine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		System.out.println("MessageLine");
		final Node node = model.newNode(Label.label("MessageLine"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		System.out.println("QualifiedClass");
		final Node node = model.newNode(Label.label("QualifiedClass"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		System.out.println("StartRule");
		final Node node = model.newNode(Label.label("StartRule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		System.out.println("InnerClassName");
		final Node node = model.newNode(Label.label("InnerClassName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		System.out.println("ClassFile");
		final Node node = model.newNode(Label.label("ClassFile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		System.out.println("QualifiedMethod");
		final Node node = model.newNode(Label.label("QualifiedMethod"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		System.out.println("Constructor");
		final Node node = model.newNode(Label.label("Constructor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		System.out.println("MethodName");
		final Node node = model.newNode(Label.label("MethodName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		System.out.println("PackagePath");
		final Node node = model.newNode(Label.label("PackagePath"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}