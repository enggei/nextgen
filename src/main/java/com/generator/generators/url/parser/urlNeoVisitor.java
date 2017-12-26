package com.generator.generators.url.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class urlNeoVisitor extends urlBaseVisitor<Node> {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(urlNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public urlNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitString(com.generator.generators.url.parser.urlParser.StringContext arg) {
		log.info("String");
		final Node node = model.newNode(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.url.parser.urlParser.QueryContext arg) {
		log.info("Query");
		final Node node = model.newNode(Label.label("Query"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		log.info("Url");
		final Node node = model.newNode(Label.label("Url"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		log.info("Uri");
		final Node node = model.newNode(Label.label("Uri"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScheme(com.generator.generators.url.parser.urlParser.SchemeContext arg) {
		log.info("Scheme");
		final Node node = model.newNode(Label.label("Scheme"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		log.info("Host");
		final Node node = model.newNode(Label.label("Host"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		log.info("Hostname");
		final Node node = model.newNode(Label.label("Hostname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		log.info("Hostnumber");
		final Node node = model.newNode(Label.label("Hostnumber"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		log.info("Port");
		final Node node = model.newNode(Label.label("Port"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		log.info("Path");
		final Node node = model.newNode(Label.label("Path"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		log.info("User");
		final Node node = model.newNode(Label.label("User"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		log.info("Login");
		final Node node = model.newNode(Label.label("Login"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		log.info("Password");
		final Node node = model.newNode(Label.label("Password"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFrag(com.generator.generators.url.parser.urlParser.FragContext arg) {
		log.info("Frag");
		final Node node = model.newNode(Label.label("Frag"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		log.info("Search");
		final Node node = model.newNode(Label.label("Search"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		log.info("Searchparameter");
		final Node node = model.newNode(Label.label("Searchparameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}