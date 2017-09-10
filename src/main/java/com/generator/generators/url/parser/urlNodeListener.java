package com.generator.generators.url.parser;

public class urlNodeListener extends urlBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public urlNodeListener() {
		this(false);
	}

	public urlNodeListener(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
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

	protected boolean inFragmentaddress = false;

	@Override
	public void enterFragmentaddress(com.generator.generators.url.parser.urlParser.FragmentaddressContext arg) {
		onEnter(new Node("Fragmentaddress", arg.getText(), arg.getStart().getText()));
		this.inFragmentaddress = true;
	}

	public void exitFragmentaddress(com.generator.generators.url.parser.urlParser.FragmentaddressContext arg) {
		onExit();
		this.inFragmentaddress = false;
	}

	protected boolean inUri = false;

	@Override
	public void enterUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		onEnter(new Node("Uri", arg.getText(), arg.getStart().getText()));
		this.inUri = true;
	}

	public void exitUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		onExit();
		this.inUri = false;
	}

	protected boolean inUrl = false;

	@Override
	public void enterUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		onEnter(new Node("Url", arg.getText(), arg.getStart().getText()));
		this.inUrl = true;
	}

	public void exitUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		onExit();
		this.inUrl = false;
	}

	protected boolean inAuthority = false;

	@Override
	public void enterAuthority(com.generator.generators.url.parser.urlParser.AuthorityContext arg) {
		onEnter(new Node("Authority", arg.getText(), arg.getStart().getText()));
		this.inAuthority = true;
	}

	public void exitAuthority(com.generator.generators.url.parser.urlParser.AuthorityContext arg) {
		onExit();
		this.inAuthority = false;
	}

	protected boolean inHost = false;

	@Override
	public void enterHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		onEnter(new Node("Host", arg.getText(), arg.getStart().getText()));
		this.inHost = true;
	}

	public void exitHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		onExit();
		this.inHost = false;
	}

	protected boolean inHostname = false;

	@Override
	public void enterHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		onEnter(new Node("Hostname", arg.getText(), arg.getStart().getText()));
		this.inHostname = true;
	}

	public void exitHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		onExit();
		this.inHostname = false;
	}

	protected boolean inHostnumber = false;

	@Override
	public void enterHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		onEnter(new Node("Hostnumber", arg.getText(), arg.getStart().getText()));
		this.inHostnumber = true;
	}

	public void exitHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		onExit();
		this.inHostnumber = false;
	}

	protected boolean inPort = false;

	@Override
	public void enterPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		onEnter(new Node("Port", arg.getText(), arg.getStart().getText()));
		this.inPort = true;
	}

	public void exitPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		onExit();
		this.inPort = false;
	}

	protected boolean inPath = false;

	@Override
	public void enterPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		onEnter(new Node("Path", arg.getText(), arg.getStart().getText()));
		this.inPath = true;
	}

	public void exitPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		onExit();
		this.inPath = false;
	}

	protected boolean inSearch = false;

	@Override
	public void enterSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		onEnter(new Node("Search", arg.getText(), arg.getStart().getText()));
		this.inSearch = true;
	}

	public void exitSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		onExit();
		this.inSearch = false;
	}

	protected boolean inSearchparameter = false;

	@Override
	public void enterSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		onEnter(new Node("Searchparameter", arg.getText(), arg.getStart().getText()));
		this.inSearchparameter = true;
	}

	public void exitSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		onExit();
		this.inSearchparameter = false;
	}

	protected boolean inUser = false;

	@Override
	public void enterUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		onEnter(new Node("User", arg.getText(), arg.getStart().getText()));
		this.inUser = true;
	}

	public void exitUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		onExit();
		this.inUser = false;
	}

	protected boolean inLogin = false;

	@Override
	public void enterLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		onEnter(new Node("Login", arg.getText(), arg.getStart().getText()));
		this.inLogin = true;
	}

	public void exitLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		onExit();
		this.inLogin = false;
	}

	protected boolean inPassword = false;

	@Override
	public void enterPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		onEnter(new Node("Password", arg.getText(), arg.getStart().getText()));
		this.inPassword = true;
	}

	public void exitPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		onExit();
		this.inPassword = false;
	}

	protected boolean inFragmentid = false;

	@Override
	public void enterFragmentid(com.generator.generators.url.parser.urlParser.FragmentidContext arg) {
		onEnter(new Node("Fragmentid", arg.getText(), arg.getStart().getText()));
		this.inFragmentid = true;
	}

	public void exitFragmentid(com.generator.generators.url.parser.urlParser.FragmentidContext arg) {
		onExit();
		this.inFragmentid = false;
	}

}