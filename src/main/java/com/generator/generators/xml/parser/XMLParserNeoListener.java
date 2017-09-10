package com.generator.generators.xml.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class XMLParserNeoListener extends XMLParserBaseListener {

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public XMLParserNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public XMLParserNeoListener(com.generator.NeoModel model, boolean debug) {
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

	protected boolean inElement = false;

	@Override
	public void enterElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText());
		onEnter(node);
		this.inElement = true;
	}

	public void exitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		onExit();
		this.inElement = false;
	}

	protected boolean inAttribute = false;

	@Override
	public void enterAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		final Node node = model.findOrCreate(Label.label("Attribute"), "text", arg.getText());
		onEnter(node);
		this.inAttribute = true;
	}

	public void exitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		onExit();
		this.inAttribute = false;
	}

	protected boolean inContent = false;

	@Override
	public void enterContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		final Node node = model.findOrCreate(Label.label("Content"), "text", arg.getText());
		onEnter(node);
		this.inContent = true;
	}

	public void exitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		onExit();
		this.inContent = false;
	}

	protected boolean inReference = false;

	@Override
	public void enterReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		final Node node = model.findOrCreate(Label.label("Reference"), "text", arg.getText());
		onEnter(node);
		this.inReference = true;
	}

	public void exitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		onExit();
		this.inReference = false;
	}

	protected boolean inChardata = false;

	@Override
	public void enterChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		final Node node = model.findOrCreate(Label.label("Chardata"), "text", arg.getText());
		onEnter(node);
		this.inChardata = true;
	}

	public void exitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		onExit();
		this.inChardata = false;
	}

	protected boolean inDocument = false;

	@Override
	public void enterDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		final Node node = model.findOrCreate(Label.label("Document"), "text", arg.getText());
		onEnter(node);
		this.inDocument = true;
	}

	public void exitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		onExit();
		this.inDocument = false;
	}

	protected boolean inProlog = false;

	@Override
	public void enterProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		final Node node = model.findOrCreate(Label.label("Prolog"), "text", arg.getText());
		onEnter(node);
		this.inProlog = true;
	}

	public void exitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		onExit();
		this.inProlog = false;
	}

	protected boolean inMisc = false;

	@Override
	public void enterMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		final Node node = model.findOrCreate(Label.label("Misc"), "text", arg.getText());
		onEnter(node);
		this.inMisc = true;
	}

	public void exitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		onExit();
		this.inMisc = false;
	}

}