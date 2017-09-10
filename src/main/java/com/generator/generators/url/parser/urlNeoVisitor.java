package com.generator.generators.url.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class urlNeoVisitor extends urlBaseVisitor<Node> {

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	private final com.generator.NeoModel model;

	public urlNeoVisitor(com.generator.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitFragmentaddress(com.generator.generators.url.parser.urlParser.FragmentaddressContext arg) {
		System.out.println("Fragmentaddress");
		final Node node = model.findOrCreate(Label.label("Fragmentaddress"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		System.out.println("Uri");
		final Node node = model.findOrCreate(Label.label("Uri"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		System.out.println("Url");
		final Node node = model.findOrCreate(Label.label("Url"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAuthority(com.generator.generators.url.parser.urlParser.AuthorityContext arg) {
		System.out.println("Authority");
		final Node node = model.findOrCreate(Label.label("Authority"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		System.out.println("Host");
		final Node node = model.findOrCreate(Label.label("Host"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		System.out.println("Hostname");
		final Node node = model.findOrCreate(Label.label("Hostname"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		System.out.println("Hostnumber");
		final Node node = model.findOrCreate(Label.label("Hostnumber"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		System.out.println("Port");
		final Node node = model.findOrCreate(Label.label("Port"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		System.out.println("Path");
		final Node node = model.findOrCreate(Label.label("Path"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		System.out.println("Search");
		final Node node = model.findOrCreate(Label.label("Search"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		System.out.println("Searchparameter");
		final Node node = model.findOrCreate(Label.label("Searchparameter"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		System.out.println("User");
		final Node node = model.findOrCreate(Label.label("User"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		System.out.println("Login");
		final Node node = model.findOrCreate(Label.label("Login"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		System.out.println("Password");
		final Node node = model.findOrCreate(Label.label("Password"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFragmentid(com.generator.generators.url.parser.urlParser.FragmentidContext arg) {
		System.out.println("Fragmentid");
		final Node node = model.findOrCreate(Label.label("Fragmentid"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}