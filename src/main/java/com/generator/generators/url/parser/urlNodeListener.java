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

	protected java.util.Stack<Boolean> inString = new java.util.Stack<>();

	@Override
	public void enterString(com.generator.generators.url.parser.urlParser.StringContext arg) {
		onEnter(new Node("String", arg.getText(), arg.getStart().getText()));
		this.inString.push(true);
	}

	public void exitString(com.generator.generators.url.parser.urlParser.StringContext arg) {
		onExit();
		this.inString.pop();
	}

	public boolean inString() {
      return inString.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUrl = new java.util.Stack<>();

	@Override
	public void enterUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		onEnter(new Node("Url", arg.getText(), arg.getStart().getText()));
		this.inUrl.push(true);
	}

	public void exitUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		onExit();
		this.inUrl.pop();
	}

	public boolean inUrl() {
      return inUrl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUser = new java.util.Stack<>();

	@Override
	public void enterUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		onEnter(new Node("User", arg.getText(), arg.getStart().getText()));
		this.inUser.push(true);
	}

	public void exitUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		onExit();
		this.inUser.pop();
	}

	public boolean inUser() {
      return inUser.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLogin = new java.util.Stack<>();

	@Override
	public void enterLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		onEnter(new Node("Login", arg.getText(), arg.getStart().getText()));
		this.inLogin.push(true);
	}

	public void exitLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		onExit();
		this.inLogin.pop();
	}

	public boolean inLogin() {
      return inLogin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPassword = new java.util.Stack<>();

	@Override
	public void enterPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		onEnter(new Node("Password", arg.getText(), arg.getStart().getText()));
		this.inPassword.push(true);
	}

	public void exitPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		onExit();
		this.inPassword.pop();
	}

	public boolean inPassword() {
      return inPassword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFrag = new java.util.Stack<>();

	@Override
	public void enterFrag(com.generator.generators.url.parser.urlParser.FragContext arg) {
		onEnter(new Node("Frag", arg.getText(), arg.getStart().getText()));
		this.inFrag.push(true);
	}

	public void exitFrag(com.generator.generators.url.parser.urlParser.FragContext arg) {
		onExit();
		this.inFrag.pop();
	}

	public boolean inFrag() {
      return inFrag.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuery = new java.util.Stack<>();

	@Override
	public void enterQuery(com.generator.generators.url.parser.urlParser.QueryContext arg) {
		onEnter(new Node("Query", arg.getText(), arg.getStart().getText()));
		this.inQuery.push(true);
	}

	public void exitQuery(com.generator.generators.url.parser.urlParser.QueryContext arg) {
		onExit();
		this.inQuery.pop();
	}

	public boolean inQuery() {
      return inQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSearch = new java.util.Stack<>();

	@Override
	public void enterSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		onEnter(new Node("Search", arg.getText(), arg.getStart().getText()));
		this.inSearch.push(true);
	}

	public void exitSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		onExit();
		this.inSearch.pop();
	}

	public boolean inSearch() {
      return inSearch.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSearchparameter = new java.util.Stack<>();

	@Override
	public void enterSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		onEnter(new Node("Searchparameter", arg.getText(), arg.getStart().getText()));
		this.inSearchparameter.push(true);
	}

	public void exitSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		onExit();
		this.inSearchparameter.pop();
	}

	public boolean inSearchparameter() {
      return inSearchparameter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUri = new java.util.Stack<>();

	@Override
	public void enterUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		onEnter(new Node("Uri", arg.getText(), arg.getStart().getText()));
		this.inUri.push(true);
	}

	public void exitUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		onExit();
		this.inUri.pop();
	}

	public boolean inUri() {
      return inUri.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inScheme = new java.util.Stack<>();

	@Override
	public void enterScheme(com.generator.generators.url.parser.urlParser.SchemeContext arg) {
		onEnter(new Node("Scheme", arg.getText(), arg.getStart().getText()));
		this.inScheme.push(true);
	}

	public void exitScheme(com.generator.generators.url.parser.urlParser.SchemeContext arg) {
		onExit();
		this.inScheme.pop();
	}

	public boolean inScheme() {
      return inScheme.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHost = new java.util.Stack<>();

	@Override
	public void enterHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		onEnter(new Node("Host", arg.getText(), arg.getStart().getText()));
		this.inHost.push(true);
	}

	public void exitHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		onExit();
		this.inHost.pop();
	}

	public boolean inHost() {
      return inHost.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHostname = new java.util.Stack<>();

	@Override
	public void enterHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		onEnter(new Node("Hostname", arg.getText(), arg.getStart().getText()));
		this.inHostname.push(true);
	}

	public void exitHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		onExit();
		this.inHostname.pop();
	}

	public boolean inHostname() {
      return inHostname.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHostnumber = new java.util.Stack<>();

	@Override
	public void enterHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		onEnter(new Node("Hostnumber", arg.getText(), arg.getStart().getText()));
		this.inHostnumber.push(true);
	}

	public void exitHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		onExit();
		this.inHostnumber.pop();
	}

	public boolean inHostnumber() {
      return inHostnumber.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPort = new java.util.Stack<>();

	@Override
	public void enterPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		onEnter(new Node("Port", arg.getText(), arg.getStart().getText()));
		this.inPort.push(true);
	}

	public void exitPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		onExit();
		this.inPort.pop();
	}

	public boolean inPort() {
      return inPort.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPath = new java.util.Stack<>();

	@Override
	public void enterPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		onEnter(new Node("Path", arg.getText(), arg.getStart().getText()));
		this.inPath.push(true);
	}

	public void exitPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		onExit();
		this.inPath.pop();
	}

	public boolean inPath() {
      return inPath.isEmpty(); 
   }

}