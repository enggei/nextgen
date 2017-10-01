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

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " '" + node.value + "'");
		delim.append("\t");
   }

   protected void onExit() {
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
		onEnter(new Node("Identifier", arg.getText(), arg.getStart().getText()));
		this.inIdentifier.push(true);
	}

	public void exitIdentifier(com.generator.generators.stacktrace.parser.StackTraceParser.IdentifierContext arg) {
		onExit();
		this.inIdentifier.pop();
	}

	public boolean inIdentifier() {
      return !inIdentifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassName = new java.util.Stack<>();

	@Override
	public void enterClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		onEnter(new Node("ClassName", arg.getText(), arg.getStart().getText()));
		this.inClassName.push(true);
	}

	public void exitClassName(com.generator.generators.stacktrace.parser.StackTraceParser.ClassNameContext arg) {
		onExit();
		this.inClassName.pop();
	}

	public boolean inClassName() {
      return !inClassName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessage = new java.util.Stack<>();

	@Override
	public void enterMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		onEnter(new Node("Message", arg.getText(), arg.getStart().getText()));
		this.inMessage.push(true);
	}

	public void exitMessage(com.generator.generators.stacktrace.parser.StackTraceParser.MessageContext arg) {
		onExit();
		this.inMessage.pop();
	}

	public boolean inMessage() {
      return !inMessage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStartRule = new java.util.Stack<>();

	@Override
	public void enterStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		onEnter(new Node("StartRule", arg.getText(), arg.getStart().getText()));
		this.inStartRule.push(true);
	}

	public void exitStartRule(com.generator.generators.stacktrace.parser.StackTraceParser.StartRuleContext arg) {
		onExit();
		this.inStartRule.pop();
	}

	public boolean inStartRule() {
      return !inStartRule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStackTrace = new java.util.Stack<>();

	@Override
	public void enterStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		onEnter(new Node("StackTrace", arg.getText(), arg.getStart().getText()));
		this.inStackTrace.push(true);
	}

	public void exitStackTrace(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceContext arg) {
		onExit();
		this.inStackTrace.pop();
	}

	public boolean inStackTrace() {
      return !inStackTrace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStackTraceLine = new java.util.Stack<>();

	@Override
	public void enterStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		onEnter(new Node("StackTraceLine", arg.getText(), arg.getStart().getText()));
		this.inStackTraceLine.push(true);
	}

	public void exitStackTraceLine(com.generator.generators.stacktrace.parser.StackTraceParser.StackTraceLineContext arg) {
		onExit();
		this.inStackTraceLine.pop();
	}

	public boolean inStackTraceLine() {
      return !inStackTraceLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAtLine = new java.util.Stack<>();

	@Override
	public void enterAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		onEnter(new Node("AtLine", arg.getText(), arg.getStart().getText()));
		this.inAtLine.push(true);
	}

	public void exitAtLine(com.generator.generators.stacktrace.parser.StackTraceParser.AtLineContext arg) {
		onExit();
		this.inAtLine.pop();
	}

	public boolean inAtLine() {
      return !inAtLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCausedByLine = new java.util.Stack<>();

	@Override
	public void enterCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		onEnter(new Node("CausedByLine", arg.getText(), arg.getStart().getText()));
		this.inCausedByLine.push(true);
	}

	public void exitCausedByLine(com.generator.generators.stacktrace.parser.StackTraceParser.CausedByLineContext arg) {
		onExit();
		this.inCausedByLine.pop();
	}

	public boolean inCausedByLine() {
      return !inCausedByLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEllipsisLine = new java.util.Stack<>();

	@Override
	public void enterEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		onEnter(new Node("EllipsisLine", arg.getText(), arg.getStart().getText()));
		this.inEllipsisLine.push(true);
	}

	public void exitEllipsisLine(com.generator.generators.stacktrace.parser.StackTraceParser.EllipsisLineContext arg) {
		onExit();
		this.inEllipsisLine.pop();
	}

	public boolean inEllipsisLine() {
      return !inEllipsisLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessageLine = new java.util.Stack<>();

	@Override
	public void enterMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		onEnter(new Node("MessageLine", arg.getText(), arg.getStart().getText()));
		this.inMessageLine.push(true);
	}

	public void exitMessageLine(com.generator.generators.stacktrace.parser.StackTraceParser.MessageLineContext arg) {
		onExit();
		this.inMessageLine.pop();
	}

	public boolean inMessageLine() {
      return !inMessageLine.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedClass = new java.util.Stack<>();

	@Override
	public void enterQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		onEnter(new Node("QualifiedClass", arg.getText(), arg.getStart().getText()));
		this.inQualifiedClass.push(true);
	}

	public void exitQualifiedClass(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedClassContext arg) {
		onExit();
		this.inQualifiedClass.pop();
	}

	public boolean inQualifiedClass() {
      return !inQualifiedClass.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassFile = new java.util.Stack<>();

	@Override
	public void enterClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		onEnter(new Node("ClassFile", arg.getText(), arg.getStart().getText()));
		this.inClassFile.push(true);
	}

	public void exitClassFile(com.generator.generators.stacktrace.parser.StackTraceParser.ClassFileContext arg) {
		onExit();
		this.inClassFile.pop();
	}

	public boolean inClassFile() {
      return !inClassFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInnerClassName = new java.util.Stack<>();

	@Override
	public void enterInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		onEnter(new Node("InnerClassName", arg.getText(), arg.getStart().getText()));
		this.inInnerClassName.push(true);
	}

	public void exitInnerClassName(com.generator.generators.stacktrace.parser.StackTraceParser.InnerClassNameContext arg) {
		onExit();
		this.inInnerClassName.pop();
	}

	public boolean inInnerClassName() {
      return !inInnerClassName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedMethod = new java.util.Stack<>();

	@Override
	public void enterQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		onEnter(new Node("QualifiedMethod", arg.getText(), arg.getStart().getText()));
		this.inQualifiedMethod.push(true);
	}

	public void exitQualifiedMethod(com.generator.generators.stacktrace.parser.StackTraceParser.QualifiedMethodContext arg) {
		onExit();
		this.inQualifiedMethod.pop();
	}

	public boolean inQualifiedMethod() {
      return !inQualifiedMethod.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstructor = new java.util.Stack<>();

	@Override
	public void enterConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		onEnter(new Node("Constructor", arg.getText(), arg.getStart().getText()));
		this.inConstructor.push(true);
	}

	public void exitConstructor(com.generator.generators.stacktrace.parser.StackTraceParser.ConstructorContext arg) {
		onExit();
		this.inConstructor.pop();
	}

	public boolean inConstructor() {
      return !inConstructor.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodName = new java.util.Stack<>();

	@Override
	public void enterMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		onEnter(new Node("MethodName", arg.getText(), arg.getStart().getText()));
		this.inMethodName.push(true);
	}

	public void exitMethodName(com.generator.generators.stacktrace.parser.StackTraceParser.MethodNameContext arg) {
		onExit();
		this.inMethodName.pop();
	}

	public boolean inMethodName() {
      return !inMethodName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackagePath = new java.util.Stack<>();

	@Override
	public void enterPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		onEnter(new Node("PackagePath", arg.getText(), arg.getStart().getText()));
		this.inPackagePath.push(true);
	}

	public void exitPackagePath(com.generator.generators.stacktrace.parser.StackTraceParser.PackagePathContext arg) {
		onExit();
		this.inPackagePath.pop();
	}

	public boolean inPackagePath() {
      return !inPackagePath.isEmpty(); 
   }

}