package com.generator.generators.xml.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class XMLParserNeoListener extends XMLParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public XMLParserNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public XMLParserNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.neo.BaseDomainVisitor.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
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

	protected java.util.Stack<Boolean> inElement = new java.util.Stack<>();

	@Override
	public void enterElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText());
		onEnter(node);
		this.inElement.push(true);
	}

	public void exitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		onExit();
		this.inElement.pop();
	}

	public boolean inElement() {
      return inElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttribute = new java.util.Stack<>();

	@Override
	public void enterAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		final Node node = model.findOrCreate(Label.label("Attribute"), "text", arg.getText());
		onEnter(node);
		this.inAttribute.push(true);
	}

	public void exitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		onExit();
		this.inAttribute.pop();
	}

	public boolean inAttribute() {
      return inAttribute.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDocument = new java.util.Stack<>();

	@Override
	public void enterDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		final Node node = model.findOrCreate(Label.label("Document"), "text", arg.getText());
		onEnter(node);
		this.inDocument.push(true);
	}

	public void exitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		onExit();
		this.inDocument.pop();
	}

	public boolean inDocument() {
      return inDocument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProlog = new java.util.Stack<>();

	@Override
	public void enterProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		final Node node = model.findOrCreate(Label.label("Prolog"), "text", arg.getText());
		onEnter(node);
		this.inProlog.push(true);
	}

	public void exitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		onExit();
		this.inProlog.pop();
	}

	public boolean inProlog() {
      return inProlog.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inContent = new java.util.Stack<>();

	@Override
	public void enterContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		final Node node = model.findOrCreate(Label.label("Content"), "text", arg.getText());
		onEnter(node);
		this.inContent.push(true);
	}

	public void exitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		onExit();
		this.inContent.pop();
	}

	public boolean inContent() {
      return inContent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReference = new java.util.Stack<>();

	@Override
	public void enterReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		final Node node = model.findOrCreate(Label.label("Reference"), "text", arg.getText());
		onEnter(node);
		this.inReference.push(true);
	}

	public void exitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		onExit();
		this.inReference.pop();
	}

	public boolean inReference() {
      return inReference.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChardata = new java.util.Stack<>();

	@Override
	public void enterChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		final Node node = model.findOrCreate(Label.label("Chardata"), "text", arg.getText());
		onEnter(node);
		this.inChardata.push(true);
	}

	public void exitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		onExit();
		this.inChardata.pop();
	}

	public boolean inChardata() {
      return inChardata.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMisc = new java.util.Stack<>();

	@Override
	public void enterMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		final Node node = model.findOrCreate(Label.label("Misc"), "text", arg.getText());
		onEnter(node);
		this.inMisc.push(true);
	}

	public void exitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		onExit();
		this.inMisc.pop();
	}

	public boolean inMisc() {
      return inMisc.isEmpty(); 
   }

}