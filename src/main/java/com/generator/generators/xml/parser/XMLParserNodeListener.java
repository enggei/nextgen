package com.generator.generators.xml.parser;

public class XMLParserNodeListener extends XMLParserBaseListener {

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

	public XMLParserNodeListener() {
		this(false);
	}

	public XMLParserNodeListener(boolean debug) {
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

	protected java.util.Stack<Boolean> inDocument = new java.util.Stack<>();

	@Override
	public void enterDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		onEnter(new Node("Document", arg.getText(), arg.getStart().getText()));
		this.inDocument.push(true);
	}

	public void exitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		onExit();
		this.inDocument.pop();
	}

	public boolean inDocument() {
      return !inDocument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProlog = new java.util.Stack<>();

	@Override
	public void enterProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		onEnter(new Node("Prolog", arg.getText(), arg.getStart().getText()));
		this.inProlog.push(true);
	}

	public void exitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		onExit();
		this.inProlog.pop();
	}

	public boolean inProlog() {
      return !inProlog.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inContent = new java.util.Stack<>();

	@Override
	public void enterContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		onEnter(new Node("Content", arg.getText(), arg.getStart().getText()));
		this.inContent.push(true);
	}

	public void exitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		onExit();
		this.inContent.pop();
	}

	public boolean inContent() {
      return !inContent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReference = new java.util.Stack<>();

	@Override
	public void enterReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		onEnter(new Node("Reference", arg.getText(), arg.getStart().getText()));
		this.inReference.push(true);
	}

	public void exitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		onExit();
		this.inReference.pop();
	}

	public boolean inReference() {
      return !inReference.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChardata = new java.util.Stack<>();

	@Override
	public void enterChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		onEnter(new Node("Chardata", arg.getText(), arg.getStart().getText()));
		this.inChardata.push(true);
	}

	public void exitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		onExit();
		this.inChardata.pop();
	}

	public boolean inChardata() {
      return !inChardata.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMisc = new java.util.Stack<>();

	@Override
	public void enterMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		onEnter(new Node("Misc", arg.getText(), arg.getStart().getText()));
		this.inMisc.push(true);
	}

	public void exitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		onExit();
		this.inMisc.pop();
	}

	public boolean inMisc() {
      return !inMisc.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElement = new java.util.Stack<>();

	@Override
	public void enterElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		onEnter(new Node("Element", arg.getText(), arg.getStart().getText()));
		this.inElement.push(true);
	}

	public void exitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		onExit();
		this.inElement.pop();
	}

	public boolean inElement() {
      return !inElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttribute = new java.util.Stack<>();

	@Override
	public void enterAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		onEnter(new Node("Attribute", arg.getText(), arg.getStart().getText()));
		this.inAttribute.push(true);
	}

	public void exitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		onExit();
		this.inAttribute.pop();
	}

	public boolean inAttribute() {
      return !inAttribute.isEmpty(); 
   }

}