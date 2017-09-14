package com.generator.generators.url.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class urlNeoListener extends urlBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public urlNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public urlNeoListener(com.generator.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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
		final Node node = model.findOrCreate(Label.label("String"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Url"), "text", arg.getText());
		onEnter(node);
		this.inUrl.push(true);
	}

	public void exitUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		onExit();
		this.inUrl.pop();
	}

	public boolean inUrl() {
      return inUrl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUri = new java.util.Stack<>();

	@Override
	public void enterUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		final Node node = model.findOrCreate(Label.label("Uri"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Scheme"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Host"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Hostname"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Hostnumber"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Port"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Path"), "text", arg.getText());
		onEnter(node);
		this.inPath.push(true);
	}

	public void exitPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		onExit();
		this.inPath.pop();
	}

	public boolean inPath() {
      return inPath.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUser = new java.util.Stack<>();

	@Override
	public void enterUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		final Node node = model.findOrCreate(Label.label("User"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Login"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Password"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Frag"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Query"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Search"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Searchparameter"), "text", arg.getText());
		onEnter(node);
		this.inSearchparameter.push(true);
	}

	public void exitSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		onExit();
		this.inSearchparameter.pop();
	}

	public boolean inSearchparameter() {
      return inSearchparameter.isEmpty(); 
   }

}