package com.generator.generators.stacktrace.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class StackTraceNeoListener extends StackTraceBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public StackTraceNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public StackTraceNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inIdentifier = new java.util.Stack<>();

	@Override
	public void enterIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Identifier"), "text", arg.getText());
		onEnter(node);
		this.inIdentifier.push(true);
	}

	public void exitIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		onExit();
		this.inIdentifier.pop();
	}

	public boolean inIdentifier() {
      return inIdentifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassName = new java.util.Stack<>();

	@Override
	public void enterClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassName"), "text", arg.getText());
		onEnter(node);
		this.inClassName.push(true);
	}

	public void exitClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		onExit();
		this.inClassName.pop();
	}

	public boolean inClassName() {
      return inClassName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessage = new java.util.Stack<>();

	@Override
	public void enterMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		final Node node = model.findOrCreate(Label.label("Message"), "text", arg.getText());
		onEnter(node);
		this.inMessage.push(true);
	}

	public void exitMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		onExit();
		this.inMessage.pop();
	}

	public boolean inMessage() {
      return inMessage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStartRule = new java.util.Stack<>();

	@Override
	public void enterStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		final Node node = model.findOrCreate(Label.label("StartRule"), "text", arg.getText());
		onEnter(node);
		this.inStartRule.push(true);
	}

	public void exitStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		onExit();
		this.inStartRule.pop();
	}

	public boolean inStartRule() {
      return inStartRule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStackTrace = new java.util.Stack<>();

	@Override
	public void enterStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		final Node node = model.findOrCreate(Label.label("StackTrace"), "text", arg.getText());
		onEnter(node);
		this.inStackTrace.push(true);
	}

	public void exitStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		onExit();
		this.inStackTrace.pop();
	}

	public boolean inStackTrace() {
      return inStackTrace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStackTraceLine = new java.util.Stack<>();

	@Override
	public void enterStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		final Node node = model.findOrCreate(Label.label("StackTraceLine"), "text", arg.getText());
		onEnter(node);
		this.inStackTraceLine.push(true);
	}

	public void exitStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		onExit();
		this.inStackTraceLine.pop();
	}

	public boolean inStackTraceLine() {
      return inStackTraceLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAtLine = new java.util.Stack<>();

	@Override
	public void enterAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		final Node node = model.findOrCreate(Label.label("AtLine"), "text", arg.getText());
		onEnter(node);
		this.inAtLine.push(true);
	}

	public void exitAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		onExit();
		this.inAtLine.pop();
	}

	public boolean inAtLine() {
      return inAtLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCausedByLine = new java.util.Stack<>();

	@Override
	public void enterCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		final Node node = model.findOrCreate(Label.label("CausedByLine"), "text", arg.getText());
		onEnter(node);
		this.inCausedByLine.push(true);
	}

	public void exitCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		onExit();
		this.inCausedByLine.pop();
	}

	public boolean inCausedByLine() {
      return inCausedByLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEllipsisLine = new java.util.Stack<>();

	@Override
	public void enterEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		final Node node = model.findOrCreate(Label.label("EllipsisLine"), "text", arg.getText());
		onEnter(node);
		this.inEllipsisLine.push(true);
	}

	public void exitEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		onExit();
		this.inEllipsisLine.pop();
	}

	public boolean inEllipsisLine() {
      return inEllipsisLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessageLine = new java.util.Stack<>();

	@Override
	public void enterMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		final Node node = model.findOrCreate(Label.label("MessageLine"), "text", arg.getText());
		onEnter(node);
		this.inMessageLine.push(true);
	}

	public void exitMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		onExit();
		this.inMessageLine.pop();
	}

	public boolean inMessageLine() {
      return inMessageLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedClass = new java.util.Stack<>();

	@Override
	public void enterQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedClass"), "text", arg.getText());
		onEnter(node);
		this.inQualifiedClass.push(true);
	}

	public void exitQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		onExit();
		this.inQualifiedClass.pop();
	}

	public boolean inQualifiedClass() {
      return inQualifiedClass.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInnerClassName = new java.util.Stack<>();

	@Override
	public void enterInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		final Node node = model.findOrCreate(Label.label("InnerClassName"), "text", arg.getText());
		onEnter(node);
		this.inInnerClassName.push(true);
	}

	public void exitInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		onExit();
		this.inInnerClassName.pop();
	}

	public boolean inInnerClassName() {
      return inInnerClassName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassFile = new java.util.Stack<>();

	@Override
	public void enterClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassFile"), "text", arg.getText());
		onEnter(node);
		this.inClassFile.push(true);
	}

	public void exitClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		onExit();
		this.inClassFile.pop();
	}

	public boolean inClassFile() {
      return inClassFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedMethod = new java.util.Stack<>();

	@Override
	public void enterQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedMethod"), "text", arg.getText());
		onEnter(node);
		this.inQualifiedMethod.push(true);
	}

	public void exitQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		onExit();
		this.inQualifiedMethod.pop();
	}

	public boolean inQualifiedMethod() {
      return inQualifiedMethod.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstructor = new java.util.Stack<>();

	@Override
	public void enterConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		final Node node = model.findOrCreate(Label.label("Constructor"), "text", arg.getText());
		onEnter(node);
		this.inConstructor.push(true);
	}

	public void exitConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		onExit();
		this.inConstructor.pop();
	}

	public boolean inConstructor() {
      return inConstructor.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodName = new java.util.Stack<>();

	@Override
	public void enterMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodName"), "text", arg.getText());
		onEnter(node);
		this.inMethodName.push(true);
	}

	public void exitMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		onExit();
		this.inMethodName.pop();
	}

	public boolean inMethodName() {
      return inMethodName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackagePath = new java.util.Stack<>();

	@Override
	public void enterPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		final Node node = model.findOrCreate(Label.label("PackagePath"), "text", arg.getText());
		onEnter(node);
		this.inPackagePath.push(true);
	}

	public void exitPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		onExit();
		this.inPackagePath.pop();
	}

	public boolean inPackagePath() {
      return inPackagePath.isEmpty(); 
   }

}