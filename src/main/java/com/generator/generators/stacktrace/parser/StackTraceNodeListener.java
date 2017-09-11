package com.generator.generators.stacktrace.parser;

public class StackTraceNodeListener extends StackTraceBaseListener {

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

	public StackTraceNodeListener() {
		this(false);
	}

	public StackTraceNodeListener(boolean debug) {
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

	protected boolean inIdentifier = false;

	@Override
	public void enterIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		onEnter(new Node("Identifier", arg.getText(), arg.getStart().getText()));
		this.inIdentifier = true;
	}

	public void exitIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		onExit();
		this.inIdentifier = false;
	}

	protected boolean inInnerClassName = false;

	@Override
	public void enterInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		onEnter(new Node("InnerClassName", arg.getText(), arg.getStart().getText()));
		this.inInnerClassName = true;
	}

	public void exitInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		onExit();
		this.inInnerClassName = false;
	}

	protected boolean inConstructor = false;

	@Override
	public void enterConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		onEnter(new Node("Constructor", arg.getText(), arg.getStart().getText()));
		this.inConstructor = true;
	}

	public void exitConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		onExit();
		this.inConstructor = false;
	}

	protected boolean inMessage = false;

	@Override
	public void enterMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		onEnter(new Node("Message", arg.getText(), arg.getStart().getText()));
		this.inMessage = true;
	}

	public void exitMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		onExit();
		this.inMessage = false;
	}

	protected boolean inStartRule = false;

	@Override
	public void enterStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		onEnter(new Node("StartRule", arg.getText(), arg.getStart().getText()));
		this.inStartRule = true;
	}

	public void exitStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		onExit();
		this.inStartRule = false;
	}

	protected boolean inStackTrace = false;

	@Override
	public void enterStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		onEnter(new Node("StackTrace", arg.getText(), arg.getStart().getText()));
		this.inStackTrace = true;
	}

	public void exitStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		onExit();
		this.inStackTrace = false;
	}

	protected boolean inStackTraceLine = false;

	@Override
	public void enterStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		onEnter(new Node("StackTraceLine", arg.getText(), arg.getStart().getText()));
		this.inStackTraceLine = true;
	}

	public void exitStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		onExit();
		this.inStackTraceLine = false;
	}

	protected boolean inAtLine = false;

	@Override
	public void enterAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		onEnter(new Node("AtLine", arg.getText(), arg.getStart().getText()));
		this.inAtLine = true;
	}

	public void exitAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		onExit();
		this.inAtLine = false;
	}

	protected boolean inCausedByLine = false;

	@Override
	public void enterCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		onEnter(new Node("CausedByLine", arg.getText(), arg.getStart().getText()));
		this.inCausedByLine = true;
	}

	public void exitCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		onExit();
		this.inCausedByLine = false;
	}

	protected boolean inEllipsisLine = false;

	@Override
	public void enterEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		onEnter(new Node("EllipsisLine", arg.getText(), arg.getStart().getText()));
		this.inEllipsisLine = true;
	}

	public void exitEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		onExit();
		this.inEllipsisLine = false;
	}

	protected boolean inMessageLine = false;

	@Override
	public void enterMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		onEnter(new Node("MessageLine", arg.getText(), arg.getStart().getText()));
		this.inMessageLine = true;
	}

	public void exitMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		onExit();
		this.inMessageLine = false;
	}

	protected boolean inQualifiedClass = false;

	@Override
	public void enterQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		onEnter(new Node("QualifiedClass", arg.getText(), arg.getStart().getText()));
		this.inQualifiedClass = true;
	}

	public void exitQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		onExit();
		this.inQualifiedClass = false;
	}

	protected boolean inClassFile = false;

	@Override
	public void enterClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		onEnter(new Node("ClassFile", arg.getText(), arg.getStart().getText()));
		this.inClassFile = true;
	}

	public void exitClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		onExit();
		this.inClassFile = false;
	}

	protected boolean inQualifiedMethod = false;

	@Override
	public void enterQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		onEnter(new Node("QualifiedMethod", arg.getText(), arg.getStart().getText()));
		this.inQualifiedMethod = true;
	}

	public void exitQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		onExit();
		this.inQualifiedMethod = false;
	}

	protected boolean inMethodName = false;

	@Override
	public void enterMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		onEnter(new Node("MethodName", arg.getText(), arg.getStart().getText()));
		this.inMethodName = true;
	}

	public void exitMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		onExit();
		this.inMethodName = false;
	}

	protected boolean inPackagePath = false;

	@Override
	public void enterPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		onEnter(new Node("PackagePath", arg.getText(), arg.getStart().getText()));
		this.inPackagePath = true;
	}

	public void exitPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		onExit();
		this.inPackagePath = false;
	}

	protected boolean inClassName = false;

	@Override
	public void enterClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		onEnter(new Node("ClassName", arg.getText(), arg.getStart().getText()));
		this.inClassName = true;
	}

	public void exitClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		onExit();
		this.inClassName = false;
	}

}