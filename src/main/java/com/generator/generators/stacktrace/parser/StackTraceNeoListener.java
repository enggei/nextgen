package com.generator.generators.stacktrace.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class StackTraceNeoListener extends StackTraceBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public StackTraceNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public StackTraceNeoListener(com.generator.NeoModel model, boolean debug) {
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

	protected boolean inIdentifier = false;

	@Override
	public void enterIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Identifier"), "text", arg.getText());
		onEnter(node);
		this.inIdentifier = true;
	}

	public void exitIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		onExit();
		this.inIdentifier = false;
	}

	protected boolean inInnerClassName = false;

	@Override
	public void enterInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		final Node node = model.findOrCreate(Label.label("InnerClassName"), "text", arg.getText());
		onEnter(node);
		this.inInnerClassName = true;
	}

	public void exitInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		onExit();
		this.inInnerClassName = false;
	}

	protected boolean inConstructor = false;

	@Override
	public void enterConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		final Node node = model.findOrCreate(Label.label("Constructor"), "text", arg.getText());
		onEnter(node);
		this.inConstructor = true;
	}

	public void exitConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		onExit();
		this.inConstructor = false;
	}

	protected boolean inMessage = false;

	@Override
	public void enterMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		final Node node = model.findOrCreate(Label.label("Message"), "text", arg.getText());
		onEnter(node);
		this.inMessage = true;
	}

	public void exitMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		onExit();
		this.inMessage = false;
	}

	protected boolean inStartRule = false;

	@Override
	public void enterStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		final Node node = model.findOrCreate(Label.label("StartRule"), "text", arg.getText());
		onEnter(node);
		this.inStartRule = true;
	}

	public void exitStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		onExit();
		this.inStartRule = false;
	}

	protected boolean inStackTrace = false;

	@Override
	public void enterStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		final Node node = model.findOrCreate(Label.label("StackTrace"), "text", arg.getText());
		onEnter(node);
		this.inStackTrace = true;
	}

	public void exitStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		onExit();
		this.inStackTrace = false;
	}

	protected boolean inStackTraceLine = false;

	@Override
	public void enterStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		final Node node = model.findOrCreate(Label.label("StackTraceLine"), "text", arg.getText());
		onEnter(node);
		this.inStackTraceLine = true;
	}

	public void exitStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		onExit();
		this.inStackTraceLine = false;
	}

	protected boolean inAtLine = false;

	@Override
	public void enterAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		final Node node = model.findOrCreate(Label.label("AtLine"), "text", arg.getText());
		onEnter(node);
		this.inAtLine = true;
	}

	public void exitAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		onExit();
		this.inAtLine = false;
	}

	protected boolean inCausedByLine = false;

	@Override
	public void enterCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		final Node node = model.findOrCreate(Label.label("CausedByLine"), "text", arg.getText());
		onEnter(node);
		this.inCausedByLine = true;
	}

	public void exitCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		onExit();
		this.inCausedByLine = false;
	}

	protected boolean inEllipsisLine = false;

	@Override
	public void enterEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		final Node node = model.findOrCreate(Label.label("EllipsisLine"), "text", arg.getText());
		onEnter(node);
		this.inEllipsisLine = true;
	}

	public void exitEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		onExit();
		this.inEllipsisLine = false;
	}

	protected boolean inMessageLine = false;

	@Override
	public void enterMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		final Node node = model.findOrCreate(Label.label("MessageLine"), "text", arg.getText());
		onEnter(node);
		this.inMessageLine = true;
	}

	public void exitMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		onExit();
		this.inMessageLine = false;
	}

	protected boolean inQualifiedClass = false;

	@Override
	public void enterQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedClass"), "text", arg.getText());
		onEnter(node);
		this.inQualifiedClass = true;
	}

	public void exitQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		onExit();
		this.inQualifiedClass = false;
	}

	protected boolean inClassFile = false;

	@Override
	public void enterClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassFile"), "text", arg.getText());
		onEnter(node);
		this.inClassFile = true;
	}

	public void exitClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		onExit();
		this.inClassFile = false;
	}

	protected boolean inQualifiedMethod = false;

	@Override
	public void enterQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedMethod"), "text", arg.getText());
		onEnter(node);
		this.inQualifiedMethod = true;
	}

	public void exitQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		onExit();
		this.inQualifiedMethod = false;
	}

	protected boolean inMethodName = false;

	@Override
	public void enterMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodName"), "text", arg.getText());
		onEnter(node);
		this.inMethodName = true;
	}

	public void exitMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		onExit();
		this.inMethodName = false;
	}

	protected boolean inPackagePath = false;

	@Override
	public void enterPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		final Node node = model.findOrCreate(Label.label("PackagePath"), "text", arg.getText());
		onEnter(node);
		this.inPackagePath = true;
	}

	public void exitPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		onExit();
		this.inPackagePath = false;
	}

	protected boolean inClassName = false;

	@Override
	public void enterClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassName"), "text", arg.getText());
		onEnter(node);
		this.inClassName = true;
	}

	public void exitClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		onExit();
		this.inClassName = false;
	}

}