package com.generator.generators.url.parser;

public class urlNodeVisitor extends urlBaseVisitor<urlNodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public urlNodeVisitor() {
		this(false);
	}

	public urlNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " '" + node.value + "'");
		delim.append("\t");
   }

   private void onExit() {
      if (nodeStack.size() > 1) {
         nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
      }
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitString(com.generator.generators.url.parser.urlParser.StringContext arg) {
		final Node node = new Node("String", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		final Node node = new Node("Url", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		final Node node = new Node("Uri", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScheme(com.generator.generators.url.parser.urlParser.SchemeContext arg) {
		final Node node = new Node("Scheme", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		final Node node = new Node("Host", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		final Node node = new Node("Hostname", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		final Node node = new Node("Hostnumber", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		final Node node = new Node("Port", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		final Node node = new Node("Path", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		final Node node = new Node("User", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		final Node node = new Node("Login", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		final Node node = new Node("Password", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFrag(com.generator.generators.url.parser.urlParser.FragContext arg) {
		final Node node = new Node("Frag", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuery(com.generator.generators.url.parser.urlParser.QueryContext arg) {
		final Node node = new Node("Query", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		final Node node = new Node("Search", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		final Node node = new Node("Searchparameter", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}