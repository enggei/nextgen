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

	protected boolean inFragmentaddress = false;

	@Override
	public void enterFragmentaddress(com.generator.generators.url.parser.urlParser.FragmentaddressContext arg) {
		final Node node = model.findOrCreate(Label.label("Fragmentaddress"), "text", arg.getText());
		onEnter(node);
		this.inFragmentaddress = true;
	}

	public void exitFragmentaddress(com.generator.generators.url.parser.urlParser.FragmentaddressContext arg) {
		onExit();
		this.inFragmentaddress = false;
	}

	protected boolean inUri = false;

	@Override
	public void enterUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		final Node node = model.findOrCreate(Label.label("Uri"), "text", arg.getText());
		onEnter(node);
		this.inUri = true;
	}

	public void exitUri(com.generator.generators.url.parser.urlParser.UriContext arg) {
		onExit();
		this.inUri = false;
	}

	protected boolean inUrl = false;

	@Override
	public void enterUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		final Node node = model.findOrCreate(Label.label("Url"), "text", arg.getText());
		onEnter(node);
		this.inUrl = true;
	}

	public void exitUrl(com.generator.generators.url.parser.urlParser.UrlContext arg) {
		onExit();
		this.inUrl = false;
	}

	protected boolean inAuthority = false;

	@Override
	public void enterAuthority(com.generator.generators.url.parser.urlParser.AuthorityContext arg) {
		final Node node = model.findOrCreate(Label.label("Authority"), "text", arg.getText());
		onEnter(node);
		this.inAuthority = true;
	}

	public void exitAuthority(com.generator.generators.url.parser.urlParser.AuthorityContext arg) {
		onExit();
		this.inAuthority = false;
	}

	protected boolean inHost = false;

	@Override
	public void enterHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		final Node node = model.findOrCreate(Label.label("Host"), "text", arg.getText());
		onEnter(node);
		this.inHost = true;
	}

	public void exitHost(com.generator.generators.url.parser.urlParser.HostContext arg) {
		onExit();
		this.inHost = false;
	}

	protected boolean inHostname = false;

	@Override
	public void enterHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Hostname"), "text", arg.getText());
		onEnter(node);
		this.inHostname = true;
	}

	public void exitHostname(com.generator.generators.url.parser.urlParser.HostnameContext arg) {
		onExit();
		this.inHostname = false;
	}

	protected boolean inHostnumber = false;

	@Override
	public void enterHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		final Node node = model.findOrCreate(Label.label("Hostnumber"), "text", arg.getText());
		onEnter(node);
		this.inHostnumber = true;
	}

	public void exitHostnumber(com.generator.generators.url.parser.urlParser.HostnumberContext arg) {
		onExit();
		this.inHostnumber = false;
	}

	protected boolean inPort = false;

	@Override
	public void enterPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		final Node node = model.findOrCreate(Label.label("Port"), "text", arg.getText());
		onEnter(node);
		this.inPort = true;
	}

	public void exitPort(com.generator.generators.url.parser.urlParser.PortContext arg) {
		onExit();
		this.inPort = false;
	}

	protected boolean inPath = false;

	@Override
	public void enterPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		final Node node = model.findOrCreate(Label.label("Path"), "text", arg.getText());
		onEnter(node);
		this.inPath = true;
	}

	public void exitPath(com.generator.generators.url.parser.urlParser.PathContext arg) {
		onExit();
		this.inPath = false;
	}

	protected boolean inSearch = false;

	@Override
	public void enterSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		final Node node = model.findOrCreate(Label.label("Search"), "text", arg.getText());
		onEnter(node);
		this.inSearch = true;
	}

	public void exitSearch(com.generator.generators.url.parser.urlParser.SearchContext arg) {
		onExit();
		this.inSearch = false;
	}

	protected boolean inSearchparameter = false;

	@Override
	public void enterSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		final Node node = model.findOrCreate(Label.label("Searchparameter"), "text", arg.getText());
		onEnter(node);
		this.inSearchparameter = true;
	}

	public void exitSearchparameter(com.generator.generators.url.parser.urlParser.SearchparameterContext arg) {
		onExit();
		this.inSearchparameter = false;
	}

	protected boolean inUser = false;

	@Override
	public void enterUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		final Node node = model.findOrCreate(Label.label("User"), "text", arg.getText());
		onEnter(node);
		this.inUser = true;
	}

	public void exitUser(com.generator.generators.url.parser.urlParser.UserContext arg) {
		onExit();
		this.inUser = false;
	}

	protected boolean inLogin = false;

	@Override
	public void enterLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		final Node node = model.findOrCreate(Label.label("Login"), "text", arg.getText());
		onEnter(node);
		this.inLogin = true;
	}

	public void exitLogin(com.generator.generators.url.parser.urlParser.LoginContext arg) {
		onExit();
		this.inLogin = false;
	}

	protected boolean inPassword = false;

	@Override
	public void enterPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		final Node node = model.findOrCreate(Label.label("Password"), "text", arg.getText());
		onEnter(node);
		this.inPassword = true;
	}

	public void exitPassword(com.generator.generators.url.parser.urlParser.PasswordContext arg) {
		onExit();
		this.inPassword = false;
	}

	protected boolean inFragmentid = false;

	@Override
	public void enterFragmentid(com.generator.generators.url.parser.urlParser.FragmentidContext arg) {
		final Node node = model.findOrCreate(Label.label("Fragmentid"), "text", arg.getText());
		onEnter(node);
		this.inFragmentid = true;
	}

	public void exitFragmentid(com.generator.generators.url.parser.urlParser.FragmentidContext arg) {
		onExit();
		this.inFragmentid = false;
	}

}