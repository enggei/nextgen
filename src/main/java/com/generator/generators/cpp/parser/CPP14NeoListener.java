package com.generator.generators.cpp.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CPP14NeoListener extends CPP14BaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public CPP14NeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public CPP14NeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTranslationunit = new java.util.Stack<>();

	@Override
	public void enterTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		final Node node = model.findOrCreate(Label.label("Translationunit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTranslationunit.push(true);
	}

	public void exitTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		onExit();
		this.inTranslationunit.pop();
	}

	public boolean inTranslationunit() {
      return !inTranslationunit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdaexpression = new java.util.Stack<>();

	@Override
	public void enterLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdaexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLambdaexpression.push(true);
	}

	public void exitLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		onExit();
		this.inLambdaexpression.pop();
	}

	public boolean inLambdaexpression() {
      return !inLambdaexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdaintroducer = new java.util.Stack<>();

	@Override
	public void enterLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdaintroducer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLambdaintroducer.push(true);
	}

	public void exitLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		onExit();
		this.inLambdaintroducer.pop();
	}

	public boolean inLambdaintroducer() {
      return !inLambdaintroducer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdacapture = new java.util.Stack<>();

	@Override
	public void enterLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdacapture"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLambdacapture.push(true);
	}

	public void exitLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		onExit();
		this.inLambdacapture.pop();
	}

	public boolean inLambdacapture() {
      return !inLambdacapture.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCapturedefault = new java.util.Stack<>();

	@Override
	public void enterCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		final Node node = model.findOrCreate(Label.label("Capturedefault"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCapturedefault.push(true);
	}

	public void exitCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		onExit();
		this.inCapturedefault.pop();
	}

	public boolean inCapturedefault() {
      return !inCapturedefault.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCapturelist = new java.util.Stack<>();

	@Override
	public void enterCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		final Node node = model.findOrCreate(Label.label("Capturelist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCapturelist.push(true);
	}

	public void exitCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		onExit();
		this.inCapturelist.pop();
	}

	public boolean inCapturelist() {
      return !inCapturelist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCapture = new java.util.Stack<>();

	@Override
	public void enterCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Capture"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCapture.push(true);
	}

	public void exitCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		onExit();
		this.inCapture.pop();
	}

	public boolean inCapture() {
      return !inCapture.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimplecapture = new java.util.Stack<>();

	@Override
	public void enterSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Simplecapture"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSimplecapture.push(true);
	}

	public void exitSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		onExit();
		this.inSimplecapture.pop();
	}

	public boolean inSimplecapture() {
      return !inSimplecapture.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInitcapture = new java.util.Stack<>();

	@Override
	public void enterInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Initcapture"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInitcapture.push(true);
	}

	public void exitInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		onExit();
		this.inInitcapture.pop();
	}

	public boolean inInitcapture() {
      return !inInitcapture.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdadeclarator = new java.util.Stack<>();

	@Override
	public void enterLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdadeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLambdadeclarator.push(true);
	}

	public void exitLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		onExit();
		this.inLambdadeclarator.pop();
	}

	public boolean inLambdadeclarator() {
      return !inLambdadeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPostfixexpression = new java.util.Stack<>();

	@Override
	public void enterPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Postfixexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPostfixexpression.push(true);
	}

	public void exitPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		onExit();
		this.inPostfixexpression.pop();
	}

	public boolean inPostfixexpression() {
      return !inPostfixexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedid = new java.util.Stack<>();

	@Override
	public void enterQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		final Node node = model.findOrCreate(Label.label("Qualifiedid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inQualifiedid.push(true);
	}

	public void exitQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		onExit();
		this.inQualifiedid.pop();
	}

	public boolean inQualifiedid() {
      return !inQualifiedid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrimaryexpression = new java.util.Stack<>();

	@Override
	public void enterPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Primaryexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPrimaryexpression.push(true);
	}

	public void exitPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		onExit();
		this.inPrimaryexpression.pop();
	}

	public boolean inPrimaryexpression() {
      return !inPrimaryexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdexpression = new java.util.Stack<>();

	@Override
	public void enterIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Idexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inIdexpression.push(true);
	}

	public void exitIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		onExit();
		this.inIdexpression.pop();
	}

	public boolean inIdexpression() {
      return !inIdexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnqualifiedid = new java.util.Stack<>();

	@Override
	public void enterUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		final Node node = model.findOrCreate(Label.label("Unqualifiedid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUnqualifiedid.push(true);
	}

	public void exitUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		onExit();
		this.inUnqualifiedid.pop();
	}

	public boolean inUnqualifiedid() {
      return !inUnqualifiedid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNestednamespecifier = new java.util.Stack<>();

	@Override
	public void enterNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Nestednamespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNestednamespecifier.push(true);
	}

	public void exitNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		onExit();
		this.inNestednamespecifier.pop();
	}

	public boolean inNestednamespecifier() {
      return !inNestednamespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionlist = new java.util.Stack<>();

	@Override
	public void enterExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Expressionlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExpressionlist.push(true);
	}

	public void exitExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		onExit();
		this.inExpressionlist.pop();
	}

	public boolean inExpressionlist() {
      return !inExpressionlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPseudodestructorname = new java.util.Stack<>();

	@Override
	public void enterPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		final Node node = model.findOrCreate(Label.label("Pseudodestructorname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPseudodestructorname.push(true);
	}

	public void exitPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		onExit();
		this.inPseudodestructorname.pop();
	}

	public boolean inPseudodestructorname() {
      return !inPseudodestructorname.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryexpression = new java.util.Stack<>();

	@Override
	public void enterUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Unaryexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUnaryexpression.push(true);
	}

	public void exitUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		onExit();
		this.inUnaryexpression.pop();
	}

	public boolean inUnaryexpression() {
      return !inUnaryexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnaryoperator = new java.util.Stack<>();

	@Override
	public void enterUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Unaryoperator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUnaryoperator.push(true);
	}

	public void exitUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		onExit();
		this.inUnaryoperator.pop();
	}

	public boolean inUnaryoperator() {
      return !inUnaryoperator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNewexpression = new java.util.Stack<>();

	@Override
	public void enterNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Newexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNewexpression.push(true);
	}

	public void exitNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		onExit();
		this.inNewexpression.pop();
	}

	public boolean inNewexpression() {
      return !inNewexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNewplacement = new java.util.Stack<>();

	@Override
	public void enterNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		final Node node = model.findOrCreate(Label.label("Newplacement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNewplacement.push(true);
	}

	public void exitNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		onExit();
		this.inNewplacement.pop();
	}

	public boolean inNewplacement() {
      return !inNewplacement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNewtypeid = new java.util.Stack<>();

	@Override
	public void enterNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		final Node node = model.findOrCreate(Label.label("Newtypeid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNewtypeid.push(true);
	}

	public void exitNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		onExit();
		this.inNewtypeid.pop();
	}

	public boolean inNewtypeid() {
      return !inNewtypeid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNewdeclarator = new java.util.Stack<>();

	@Override
	public void enterNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Newdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNewdeclarator.push(true);
	}

	public void exitNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		onExit();
		this.inNewdeclarator.pop();
	}

	public boolean inNewdeclarator() {
      return !inNewdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNoptrnewdeclarator = new java.util.Stack<>();

	@Override
	public void enterNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrnewdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNoptrnewdeclarator.push(true);
	}

	public void exitNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		onExit();
		this.inNoptrnewdeclarator.pop();
	}

	public boolean inNoptrnewdeclarator() {
      return !inNoptrnewdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNewinitializer = new java.util.Stack<>();

	@Override
	public void enterNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Newinitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNewinitializer.push(true);
	}

	public void exitNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		onExit();
		this.inNewinitializer.pop();
	}

	public boolean inNewinitializer() {
      return !inNewinitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeleteexpression = new java.util.Stack<>();

	@Override
	public void enterDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Deleteexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeleteexpression.push(true);
	}

	public void exitDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		onExit();
		this.inDeleteexpression.pop();
	}

	public boolean inDeleteexpression() {
      return !inDeleteexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNoexceptexpression = new java.util.Stack<>();

	@Override
	public void enterNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Noexceptexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNoexceptexpression.push(true);
	}

	public void exitNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		onExit();
		this.inNoexceptexpression.pop();
	}

	public boolean inNoexceptexpression() {
      return !inNoexceptexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCastexpression = new java.util.Stack<>();

	@Override
	public void enterCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Castexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCastexpression.push(true);
	}

	public void exitCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		onExit();
		this.inCastexpression.pop();
	}

	public boolean inCastexpression() {
      return !inCastexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPmexpression = new java.util.Stack<>();

	@Override
	public void enterPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Pmexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPmexpression.push(true);
	}

	public void exitPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		onExit();
		this.inPmexpression.pop();
	}

	public boolean inPmexpression() {
      return !inPmexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMultiplicativeexpression = new java.util.Stack<>();

	@Override
	public void enterMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Multiplicativeexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMultiplicativeexpression.push(true);
	}

	public void exitMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		onExit();
		this.inMultiplicativeexpression.pop();
	}

	public boolean inMultiplicativeexpression() {
      return !inMultiplicativeexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAdditiveexpression = new java.util.Stack<>();

	@Override
	public void enterAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Additiveexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAdditiveexpression.push(true);
	}

	public void exitAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		onExit();
		this.inAdditiveexpression.pop();
	}

	public boolean inAdditiveexpression() {
      return !inAdditiveexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inShiftexpression = new java.util.Stack<>();

	@Override
	public void enterShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Shiftexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inShiftexpression.push(true);
	}

	public void exitShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		onExit();
		this.inShiftexpression.pop();
	}

	public boolean inShiftexpression() {
      return !inShiftexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRelationalexpression = new java.util.Stack<>();

	@Override
	public void enterRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Relationalexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRelationalexpression.push(true);
	}

	public void exitRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		onExit();
		this.inRelationalexpression.pop();
	}

	public boolean inRelationalexpression() {
      return !inRelationalexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEqualityexpression = new java.util.Stack<>();

	@Override
	public void enterEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Equalityexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEqualityexpression.push(true);
	}

	public void exitEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		onExit();
		this.inEqualityexpression.pop();
	}

	public boolean inEqualityexpression() {
      return !inEqualityexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAndexpression = new java.util.Stack<>();

	@Override
	public void enterAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Andexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAndexpression.push(true);
	}

	public void exitAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		onExit();
		this.inAndexpression.pop();
	}

	public boolean inAndexpression() {
      return !inAndexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExclusiveorexpression = new java.util.Stack<>();

	@Override
	public void enterExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Exclusiveorexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExclusiveorexpression.push(true);
	}

	public void exitExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		onExit();
		this.inExclusiveorexpression.pop();
	}

	public boolean inExclusiveorexpression() {
      return !inExclusiveorexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInclusiveorexpression = new java.util.Stack<>();

	@Override
	public void enterInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Inclusiveorexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInclusiveorexpression.push(true);
	}

	public void exitInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		onExit();
		this.inInclusiveorexpression.pop();
	}

	public boolean inInclusiveorexpression() {
      return !inInclusiveorexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLogicalandexpression = new java.util.Stack<>();

	@Override
	public void enterLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Logicalandexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLogicalandexpression.push(true);
	}

	public void exitLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		onExit();
		this.inLogicalandexpression.pop();
	}

	public boolean inLogicalandexpression() {
      return !inLogicalandexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLogicalorexpression = new java.util.Stack<>();

	@Override
	public void enterLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Logicalorexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLogicalorexpression.push(true);
	}

	public void exitLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		onExit();
		this.inLogicalorexpression.pop();
	}

	public boolean inLogicalorexpression() {
      return !inLogicalorexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConditionalexpression = new java.util.Stack<>();

	@Override
	public void enterConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Conditionalexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConditionalexpression.push(true);
	}

	public void exitConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		onExit();
		this.inConditionalexpression.pop();
	}

	public boolean inConditionalexpression() {
      return !inConditionalexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssignmentexpression = new java.util.Stack<>();

	@Override
	public void enterAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Assignmentexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAssignmentexpression.push(true);
	}

	public void exitAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		onExit();
		this.inAssignmentexpression.pop();
	}

	public boolean inAssignmentexpression() {
      return !inAssignmentexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAssignmentoperator = new java.util.Stack<>();

	@Override
	public void enterAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Assignmentoperator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAssignmentoperator.push(true);
	}

	public void exitAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		onExit();
		this.inAssignmentoperator.pop();
	}

	public boolean inAssignmentoperator() {
      return !inAssignmentoperator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstantexpression = new java.util.Stack<>();

	@Override
	public void enterConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Constantexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConstantexpression.push(true);
	}

	public void exitConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		onExit();
		this.inConstantexpression.pop();
	}

	public boolean inConstantexpression() {
      return !inConstantexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return !inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabeledstatement = new java.util.Stack<>();

	@Override
	public void enterLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Labeledstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLabeledstatement.push(true);
	}

	public void exitLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		onExit();
		this.inLabeledstatement.pop();
	}

	public boolean inLabeledstatement() {
      return !inLabeledstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionstatement = new java.util.Stack<>();

	@Override
	public void enterExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Expressionstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExpressionstatement.push(true);
	}

	public void exitExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		onExit();
		this.inExpressionstatement.pop();
	}

	public boolean inExpressionstatement() {
      return !inExpressionstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompoundstatement = new java.util.Stack<>();

	@Override
	public void enterCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Compoundstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCompoundstatement.push(true);
	}

	public void exitCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		onExit();
		this.inCompoundstatement.pop();
	}

	public boolean inCompoundstatement() {
      return !inCompoundstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatementseq = new java.util.Stack<>();

	@Override
	public void enterStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Statementseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inStatementseq.push(true);
	}

	public void exitStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		onExit();
		this.inStatementseq.pop();
	}

	public boolean inStatementseq() {
      return !inStatementseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectionstatement = new java.util.Stack<>();

	@Override
	public void enterSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Selectionstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSelectionstatement.push(true);
	}

	public void exitSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		onExit();
		this.inSelectionstatement.pop();
	}

	public boolean inSelectionstatement() {
      return !inSelectionstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCondition = new java.util.Stack<>();

	@Override
	public void enterCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		final Node node = model.findOrCreate(Label.label("Condition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCondition.push(true);
	}

	public void exitCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		onExit();
		this.inCondition.pop();
	}

	public boolean inCondition() {
      return !inCondition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIterationstatement = new java.util.Stack<>();

	@Override
	public void enterIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Iterationstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inIterationstatement.push(true);
	}

	public void exitIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		onExit();
		this.inIterationstatement.pop();
	}

	public boolean inIterationstatement() {
      return !inIterationstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForinitstatement = new java.util.Stack<>();

	@Override
	public void enterForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Forinitstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inForinitstatement.push(true);
	}

	public void exitForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		onExit();
		this.inForinitstatement.pop();
	}

	public boolean inForinitstatement() {
      return !inForinitstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForrangedeclaration = new java.util.Stack<>();

	@Override
	public void enterForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Forrangedeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inForrangedeclaration.push(true);
	}

	public void exitForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		onExit();
		this.inForrangedeclaration.pop();
	}

	public boolean inForrangedeclaration() {
      return !inForrangedeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForrangeinitializer = new java.util.Stack<>();

	@Override
	public void enterForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Forrangeinitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inForrangeinitializer.push(true);
	}

	public void exitForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		onExit();
		this.inForrangeinitializer.pop();
	}

	public boolean inForrangeinitializer() {
      return !inForrangeinitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inJumpstatement = new java.util.Stack<>();

	@Override
	public void enterJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Jumpstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inJumpstatement.push(true);
	}

	public void exitJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		onExit();
		this.inJumpstatement.pop();
	}

	public boolean inJumpstatement() {
      return !inJumpstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclarationstatement = new java.util.Stack<>();

	@Override
	public void enterDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Declarationstatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclarationstatement.push(true);
	}

	public void exitDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		onExit();
		this.inDeclarationstatement.pop();
	}

	public boolean inDeclarationstatement() {
      return !inDeclarationstatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclarationseq = new java.util.Stack<>();

	@Override
	public void enterDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Declarationseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclarationseq.push(true);
	}

	public void exitDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		onExit();
		this.inDeclarationseq.pop();
	}

	public boolean inDeclarationseq() {
      return !inDeclarationseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclaration = new java.util.Stack<>();

	@Override
	public void enterDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Declaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclaration.push(true);
	}

	public void exitDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		onExit();
		this.inDeclaration.pop();
	}

	public boolean inDeclaration() {
      return !inDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlockdeclaration = new java.util.Stack<>();

	@Override
	public void enterBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Blockdeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBlockdeclaration.push(true);
	}

	public void exitBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		onExit();
		this.inBlockdeclaration.pop();
	}

	public boolean inBlockdeclaration() {
      return !inBlockdeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAliasdeclaration = new java.util.Stack<>();

	@Override
	public void enterAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Aliasdeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAliasdeclaration.push(true);
	}

	public void exitAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		onExit();
		this.inAliasdeclaration.pop();
	}

	public boolean inAliasdeclaration() {
      return !inAliasdeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpledeclaration = new java.util.Stack<>();

	@Override
	public void enterSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Simpledeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSimpledeclaration.push(true);
	}

	public void exitSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		onExit();
		this.inSimpledeclaration.pop();
	}

	public boolean inSimpledeclaration() {
      return !inSimpledeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatic_assertdeclaration = new java.util.Stack<>();

	@Override
	public void enterStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Static_assertdeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inStatic_assertdeclaration.push(true);
	}

	public void exitStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		onExit();
		this.inStatic_assertdeclaration.pop();
	}

	public boolean inStatic_assertdeclaration() {
      return !inStatic_assertdeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEmptydeclaration = new java.util.Stack<>();

	@Override
	public void enterEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Emptydeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEmptydeclaration.push(true);
	}

	public void exitEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		onExit();
		this.inEmptydeclaration.pop();
	}

	public boolean inEmptydeclaration() {
      return !inEmptydeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributedeclaration = new java.util.Stack<>();

	@Override
	public void enterAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributedeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributedeclaration.push(true);
	}

	public void exitAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		onExit();
		this.inAttributedeclaration.pop();
	}

	public boolean inAttributedeclaration() {
      return !inAttributedeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclspecifier = new java.util.Stack<>();

	@Override
	public void enterDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Declspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclspecifier.push(true);
	}

	public void exitDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		onExit();
		this.inDeclspecifier.pop();
	}

	public boolean inDeclspecifier() {
      return !inDeclspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclspecifierseq = new java.util.Stack<>();

	@Override
	public void enterDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Declspecifierseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclspecifierseq.push(true);
	}

	public void exitDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		onExit();
		this.inDeclspecifierseq.pop();
	}

	public boolean inDeclspecifierseq() {
      return !inDeclspecifierseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStorageclassspecifier = new java.util.Stack<>();

	@Override
	public void enterStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Storageclassspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inStorageclassspecifier.push(true);
	}

	public void exitStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		onExit();
		this.inStorageclassspecifier.pop();
	}

	public boolean inStorageclassspecifier() {
      return !inStorageclassspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionspecifier = new java.util.Stack<>();

	@Override
	public void enterFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Functionspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctionspecifier.push(true);
	}

	public void exitFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		onExit();
		this.inFunctionspecifier.pop();
	}

	public boolean inFunctionspecifier() {
      return !inFunctionspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypedefname = new java.util.Stack<>();

	@Override
	public void enterTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Typedefname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypedefname.push(true);
	}

	public void exitTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		onExit();
		this.inTypedefname.pop();
	}

	public boolean inTypedefname() {
      return !inTypedefname.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypespecifier = new java.util.Stack<>();

	@Override
	public void enterTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Typespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypespecifier.push(true);
	}

	public void exitTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		onExit();
		this.inTypespecifier.pop();
	}

	public boolean inTypespecifier() {
      return !inTypespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTrailingtypespecifier = new java.util.Stack<>();

	@Override
	public void enterTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Trailingtypespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTrailingtypespecifier.push(true);
	}

	public void exitTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		onExit();
		this.inTrailingtypespecifier.pop();
	}

	public boolean inTrailingtypespecifier() {
      return !inTrailingtypespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypespecifierseq = new java.util.Stack<>();

	@Override
	public void enterTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Typespecifierseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypespecifierseq.push(true);
	}

	public void exitTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		onExit();
		this.inTypespecifierseq.pop();
	}

	public boolean inTypespecifierseq() {
      return !inTypespecifierseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTrailingtypespecifierseq = new java.util.Stack<>();

	@Override
	public void enterTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Trailingtypespecifierseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTrailingtypespecifierseq.push(true);
	}

	public void exitTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		onExit();
		this.inTrailingtypespecifierseq.pop();
	}

	public boolean inTrailingtypespecifierseq() {
      return !inTrailingtypespecifierseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpletypespecifier = new java.util.Stack<>();

	@Override
	public void enterSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Simpletypespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSimpletypespecifier.push(true);
	}

	public void exitSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		onExit();
		this.inSimpletypespecifier.pop();
	}

	public boolean inSimpletypespecifier() {
      return !inSimpletypespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypename = new java.util.Stack<>();

	@Override
	public void enterTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Typename"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypename.push(true);
	}

	public void exitTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		onExit();
		this.inTypename.pop();
	}

	public boolean inTypename() {
      return !inTypename.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDecltypespecifier = new java.util.Stack<>();

	@Override
	public void enterDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Decltypespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDecltypespecifier.push(true);
	}

	public void exitDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		onExit();
		this.inDecltypespecifier.pop();
	}

	public boolean inDecltypespecifier() {
      return !inDecltypespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElaboratedtypespecifier = new java.util.Stack<>();

	@Override
	public void enterElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Elaboratedtypespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inElaboratedtypespecifier.push(true);
	}

	public void exitElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		onExit();
		this.inElaboratedtypespecifier.pop();
	}

	public boolean inElaboratedtypespecifier() {
      return !inElaboratedtypespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumname = new java.util.Stack<>();

	@Override
	public void enterEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumname.push(true);
	}

	public void exitEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		onExit();
		this.inEnumname.pop();
	}

	public boolean inEnumname() {
      return !inEnumname.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumspecifier = new java.util.Stack<>();

	@Override
	public void enterEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumspecifier.push(true);
	}

	public void exitEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		onExit();
		this.inEnumspecifier.pop();
	}

	public boolean inEnumspecifier() {
      return !inEnumspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumhead = new java.util.Stack<>();

	@Override
	public void enterEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumhead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumhead.push(true);
	}

	public void exitEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		onExit();
		this.inEnumhead.pop();
	}

	public boolean inEnumhead() {
      return !inEnumhead.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOpaqueenumdeclaration = new java.util.Stack<>();

	@Override
	public void enterOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Opaqueenumdeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOpaqueenumdeclaration.push(true);
	}

	public void exitOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		onExit();
		this.inOpaqueenumdeclaration.pop();
	}

	public boolean inOpaqueenumdeclaration() {
      return !inOpaqueenumdeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumkey = new java.util.Stack<>();

	@Override
	public void enterEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumkey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumkey.push(true);
	}

	public void exitEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		onExit();
		this.inEnumkey.pop();
	}

	public boolean inEnumkey() {
      return !inEnumkey.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumbase = new java.util.Stack<>();

	@Override
	public void enterEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumbase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumbase.push(true);
	}

	public void exitEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		onExit();
		this.inEnumbase.pop();
	}

	public boolean inEnumbase() {
      return !inEnumbase.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumeratorlist = new java.util.Stack<>();

	@Override
	public void enterEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumeratorlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumeratorlist.push(true);
	}

	public void exitEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		onExit();
		this.inEnumeratorlist.pop();
	}

	public boolean inEnumeratorlist() {
      return !inEnumeratorlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumeratordefinition = new java.util.Stack<>();

	@Override
	public void enterEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumeratordefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumeratordefinition.push(true);
	}

	public void exitEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		onExit();
		this.inEnumeratordefinition.pop();
	}

	public boolean inEnumeratordefinition() {
      return !inEnumeratordefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumerator = new java.util.Stack<>();

	@Override
	public void enterEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumerator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inEnumerator.push(true);
	}

	public void exitEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		onExit();
		this.inEnumerator.pop();
	}

	public boolean inEnumerator() {
      return !inEnumerator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamespacename = new java.util.Stack<>();

	@Override
	public void enterNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacename"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNamespacename.push(true);
	}

	public void exitNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		onExit();
		this.inNamespacename.pop();
	}

	public boolean inNamespacename() {
      return !inNamespacename.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOriginalnamespacename = new java.util.Stack<>();

	@Override
	public void enterOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Originalnamespacename"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOriginalnamespacename.push(true);
	}

	public void exitOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		onExit();
		this.inOriginalnamespacename.pop();
	}

	public boolean inOriginalnamespacename() {
      return !inOriginalnamespacename.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamespacedefinition = new java.util.Stack<>();

	@Override
	public void enterNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacedefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNamespacedefinition.push(true);
	}

	public void exitNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		onExit();
		this.inNamespacedefinition.pop();
	}

	public boolean inNamespacedefinition() {
      return !inNamespacedefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamednamespacedefinition = new java.util.Stack<>();

	@Override
	public void enterNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Namednamespacedefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNamednamespacedefinition.push(true);
	}

	public void exitNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		onExit();
		this.inNamednamespacedefinition.pop();
	}

	public boolean inNamednamespacedefinition() {
      return !inNamednamespacedefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOriginalnamespacedefinition = new java.util.Stack<>();

	@Override
	public void enterOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Originalnamespacedefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOriginalnamespacedefinition.push(true);
	}

	public void exitOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		onExit();
		this.inOriginalnamespacedefinition.pop();
	}

	public boolean inOriginalnamespacedefinition() {
      return !inOriginalnamespacedefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExtensionnamespacedefinition = new java.util.Stack<>();

	@Override
	public void enterExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Extensionnamespacedefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExtensionnamespacedefinition.push(true);
	}

	public void exitExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		onExit();
		this.inExtensionnamespacedefinition.pop();
	}

	public boolean inExtensionnamespacedefinition() {
      return !inExtensionnamespacedefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnnamednamespacedefinition = new java.util.Stack<>();

	@Override
	public void enterUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Unnamednamespacedefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUnnamednamespacedefinition.push(true);
	}

	public void exitUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		onExit();
		this.inUnnamednamespacedefinition.pop();
	}

	public boolean inUnnamednamespacedefinition() {
      return !inUnnamednamespacedefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamespacebody = new java.util.Stack<>();

	@Override
	public void enterNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacebody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNamespacebody.push(true);
	}

	public void exitNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		onExit();
		this.inNamespacebody.pop();
	}

	public boolean inNamespacebody() {
      return !inNamespacebody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamespacealias = new java.util.Stack<>();

	@Override
	public void enterNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacealias"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNamespacealias.push(true);
	}

	public void exitNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		onExit();
		this.inNamespacealias.pop();
	}

	public boolean inNamespacealias() {
      return !inNamespacealias.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamespacealiasdefinition = new java.util.Stack<>();

	@Override
	public void enterNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacealiasdefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNamespacealiasdefinition.push(true);
	}

	public void exitNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		onExit();
		this.inNamespacealiasdefinition.pop();
	}

	public boolean inNamespacealiasdefinition() {
      return !inNamespacealiasdefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiednamespacespecifier = new java.util.Stack<>();

	@Override
	public void enterQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Qualifiednamespacespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inQualifiednamespacespecifier.push(true);
	}

	public void exitQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		onExit();
		this.inQualifiednamespacespecifier.pop();
	}

	public boolean inQualifiednamespacespecifier() {
      return !inQualifiednamespacespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUsingdeclaration = new java.util.Stack<>();

	@Override
	public void enterUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Usingdeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUsingdeclaration.push(true);
	}

	public void exitUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		onExit();
		this.inUsingdeclaration.pop();
	}

	public boolean inUsingdeclaration() {
      return !inUsingdeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUsingdirective = new java.util.Stack<>();

	@Override
	public void enterUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		final Node node = model.findOrCreate(Label.label("Usingdirective"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUsingdirective.push(true);
	}

	public void exitUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		onExit();
		this.inUsingdirective.pop();
	}

	public boolean inUsingdirective() {
      return !inUsingdirective.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAsmdefinition = new java.util.Stack<>();

	@Override
	public void enterAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Asmdefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAsmdefinition.push(true);
	}

	public void exitAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		onExit();
		this.inAsmdefinition.pop();
	}

	public boolean inAsmdefinition() {
      return !inAsmdefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLinkagespecification = new java.util.Stack<>();

	@Override
	public void enterLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Linkagespecification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLinkagespecification.push(true);
	}

	public void exitLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		onExit();
		this.inLinkagespecification.pop();
	}

	public boolean inLinkagespecification() {
      return !inLinkagespecification.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributespecifierseq = new java.util.Stack<>();

	@Override
	public void enterAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributespecifierseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributespecifierseq.push(true);
	}

	public void exitAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		onExit();
		this.inAttributespecifierseq.pop();
	}

	public boolean inAttributespecifierseq() {
      return !inAttributespecifierseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributespecifier = new java.util.Stack<>();

	@Override
	public void enterAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributespecifier.push(true);
	}

	public void exitAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		onExit();
		this.inAttributespecifier.pop();
	}

	public boolean inAttributespecifier() {
      return !inAttributespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlignmentspecifier = new java.util.Stack<>();

	@Override
	public void enterAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Alignmentspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAlignmentspecifier.push(true);
	}

	public void exitAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		onExit();
		this.inAlignmentspecifier.pop();
	}

	public boolean inAlignmentspecifier() {
      return !inAlignmentspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributelist = new java.util.Stack<>();

	@Override
	public void enterAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributelist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributelist.push(true);
	}

	public void exitAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		onExit();
		this.inAttributelist.pop();
	}

	public boolean inAttributelist() {
      return !inAttributelist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttribute = new java.util.Stack<>();

	@Override
	public void enterAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		final Node node = model.findOrCreate(Label.label("Attribute"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttribute.push(true);
	}

	public void exitAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		onExit();
		this.inAttribute.pop();
	}

	public boolean inAttribute() {
      return !inAttribute.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributetoken = new java.util.Stack<>();

	@Override
	public void enterAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributetoken"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributetoken.push(true);
	}

	public void exitAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		onExit();
		this.inAttributetoken.pop();
	}

	public boolean inAttributetoken() {
      return !inAttributetoken.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributescopedtoken = new java.util.Stack<>();

	@Override
	public void enterAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributescopedtoken"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributescopedtoken.push(true);
	}

	public void exitAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		onExit();
		this.inAttributescopedtoken.pop();
	}

	public boolean inAttributescopedtoken() {
      return !inAttributescopedtoken.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributenamespace = new java.util.Stack<>();

	@Override
	public void enterAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributenamespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributenamespace.push(true);
	}

	public void exitAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		onExit();
		this.inAttributenamespace.pop();
	}

	public boolean inAttributenamespace() {
      return !inAttributenamespace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttributeargumentclause = new java.util.Stack<>();

	@Override
	public void enterAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributeargumentclause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAttributeargumentclause.push(true);
	}

	public void exitAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		onExit();
		this.inAttributeargumentclause.pop();
	}

	public boolean inAttributeargumentclause() {
      return !inAttributeargumentclause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBalancedtokenseq = new java.util.Stack<>();

	@Override
	public void enterBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Balancedtokenseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBalancedtokenseq.push(true);
	}

	public void exitBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		onExit();
		this.inBalancedtokenseq.pop();
	}

	public boolean inBalancedtokenseq() {
      return !inBalancedtokenseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBalancedtoken = new java.util.Stack<>();

	@Override
	public void enterBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		final Node node = model.findOrCreate(Label.label("Balancedtoken"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBalancedtoken.push(true);
	}

	public void exitBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		onExit();
		this.inBalancedtoken.pop();
	}

	public boolean inBalancedtoken() {
      return !inBalancedtoken.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInitdeclaratorlist = new java.util.Stack<>();

	@Override
	public void enterInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Initdeclaratorlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInitdeclaratorlist.push(true);
	}

	public void exitInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		onExit();
		this.inInitdeclaratorlist.pop();
	}

	public boolean inInitdeclaratorlist() {
      return !inInitdeclaratorlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInitdeclarator = new java.util.Stack<>();

	@Override
	public void enterInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Initdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInitdeclarator.push(true);
	}

	public void exitInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		onExit();
		this.inInitdeclarator.pop();
	}

	public boolean inInitdeclarator() {
      return !inInitdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclarator = new java.util.Stack<>();

	@Override
	public void enterDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Declarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclarator.push(true);
	}

	public void exitDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		onExit();
		this.inDeclarator.pop();
	}

	public boolean inDeclarator() {
      return !inDeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPtrdeclarator = new java.util.Stack<>();

	@Override
	public void enterPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Ptrdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPtrdeclarator.push(true);
	}

	public void exitPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		onExit();
		this.inPtrdeclarator.pop();
	}

	public boolean inPtrdeclarator() {
      return !inPtrdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNoptrdeclarator = new java.util.Stack<>();

	@Override
	public void enterNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNoptrdeclarator.push(true);
	}

	public void exitNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		onExit();
		this.inNoptrdeclarator.pop();
	}

	public boolean inNoptrdeclarator() {
      return !inNoptrdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParametersandqualifiers = new java.util.Stack<>();

	@Override
	public void enterParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		final Node node = model.findOrCreate(Label.label("Parametersandqualifiers"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inParametersandqualifiers.push(true);
	}

	public void exitParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		onExit();
		this.inParametersandqualifiers.pop();
	}

	public boolean inParametersandqualifiers() {
      return !inParametersandqualifiers.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTrailingreturntype = new java.util.Stack<>();

	@Override
	public void enterTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		final Node node = model.findOrCreate(Label.label("Trailingreturntype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTrailingreturntype.push(true);
	}

	public void exitTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		onExit();
		this.inTrailingreturntype.pop();
	}

	public boolean inTrailingreturntype() {
      return !inTrailingreturntype.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPtroperator = new java.util.Stack<>();

	@Override
	public void enterPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Ptroperator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPtroperator.push(true);
	}

	public void exitPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		onExit();
		this.inPtroperator.pop();
	}

	public boolean inPtroperator() {
      return !inPtroperator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCvqualifierseq = new java.util.Stack<>();

	@Override
	public void enterCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Cvqualifierseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCvqualifierseq.push(true);
	}

	public void exitCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		onExit();
		this.inCvqualifierseq.pop();
	}

	public boolean inCvqualifierseq() {
      return !inCvqualifierseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCvqualifier = new java.util.Stack<>();

	@Override
	public void enterCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Cvqualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCvqualifier.push(true);
	}

	public void exitCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		onExit();
		this.inCvqualifier.pop();
	}

	public boolean inCvqualifier() {
      return !inCvqualifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRefqualifier = new java.util.Stack<>();

	@Override
	public void enterRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Refqualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRefqualifier.push(true);
	}

	public void exitRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		onExit();
		this.inRefqualifier.pop();
	}

	public boolean inRefqualifier() {
      return !inRefqualifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclaratorid = new java.util.Stack<>();

	@Override
	public void enterDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		final Node node = model.findOrCreate(Label.label("Declaratorid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDeclaratorid.push(true);
	}

	public void exitDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		onExit();
		this.inDeclaratorid.pop();
	}

	public boolean inDeclaratorid() {
      return !inDeclaratorid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeid = new java.util.Stack<>();

	@Override
	public void enterTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		final Node node = model.findOrCreate(Label.label("Typeid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeid.push(true);
	}

	public void exitTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		onExit();
		this.inTypeid.pop();
	}

	public boolean inTypeid() {
      return !inTypeid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAbstractdeclarator = new java.util.Stack<>();

	@Override
	public void enterAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Abstractdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAbstractdeclarator.push(true);
	}

	public void exitAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		onExit();
		this.inAbstractdeclarator.pop();
	}

	public boolean inAbstractdeclarator() {
      return !inAbstractdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPtrabstractdeclarator = new java.util.Stack<>();

	@Override
	public void enterPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Ptrabstractdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPtrabstractdeclarator.push(true);
	}

	public void exitPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		onExit();
		this.inPtrabstractdeclarator.pop();
	}

	public boolean inPtrabstractdeclarator() {
      return !inPtrabstractdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNoptrabstractdeclarator = new java.util.Stack<>();

	@Override
	public void enterNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrabstractdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNoptrabstractdeclarator.push(true);
	}

	public void exitNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		onExit();
		this.inNoptrabstractdeclarator.pop();
	}

	public boolean inNoptrabstractdeclarator() {
      return !inNoptrabstractdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAbstractpackdeclarator = new java.util.Stack<>();

	@Override
	public void enterAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Abstractpackdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAbstractpackdeclarator.push(true);
	}

	public void exitAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		onExit();
		this.inAbstractpackdeclarator.pop();
	}

	public boolean inAbstractpackdeclarator() {
      return !inAbstractpackdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNoptrabstractpackdeclarator = new java.util.Stack<>();

	@Override
	public void enterNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrabstractpackdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNoptrabstractpackdeclarator.push(true);
	}

	public void exitNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		onExit();
		this.inNoptrabstractpackdeclarator.pop();
	}

	public boolean inNoptrabstractpackdeclarator() {
      return !inNoptrabstractpackdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameterdeclarationclause = new java.util.Stack<>();

	@Override
	public void enterParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Parameterdeclarationclause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inParameterdeclarationclause.push(true);
	}

	public void exitParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		onExit();
		this.inParameterdeclarationclause.pop();
	}

	public boolean inParameterdeclarationclause() {
      return !inParameterdeclarationclause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameterdeclarationlist = new java.util.Stack<>();

	@Override
	public void enterParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Parameterdeclarationlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inParameterdeclarationlist.push(true);
	}

	public void exitParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		onExit();
		this.inParameterdeclarationlist.pop();
	}

	public boolean inParameterdeclarationlist() {
      return !inParameterdeclarationlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParameterdeclaration = new java.util.Stack<>();

	@Override
	public void enterParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Parameterdeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inParameterdeclaration.push(true);
	}

	public void exitParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		onExit();
		this.inParameterdeclaration.pop();
	}

	public boolean inParameterdeclaration() {
      return !inParameterdeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctiondefinition = new java.util.Stack<>();

	@Override
	public void enterFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Functiondefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctiondefinition.push(true);
	}

	public void exitFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		onExit();
		this.inFunctiondefinition.pop();
	}

	public boolean inFunctiondefinition() {
      return !inFunctiondefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionbody = new java.util.Stack<>();

	@Override
	public void enterFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		final Node node = model.findOrCreate(Label.label("Functionbody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctionbody.push(true);
	}

	public void exitFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		onExit();
		this.inFunctionbody.pop();
	}

	public boolean inFunctionbody() {
      return !inFunctionbody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInitializer = new java.util.Stack<>();

	@Override
	public void enterInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Initializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInitializer.push(true);
	}

	public void exitInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		onExit();
		this.inInitializer.pop();
	}

	public boolean inInitializer() {
      return !inInitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBraceorequalinitializer = new java.util.Stack<>();

	@Override
	public void enterBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Braceorequalinitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBraceorequalinitializer.push(true);
	}

	public void exitBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		onExit();
		this.inBraceorequalinitializer.pop();
	}

	public boolean inBraceorequalinitializer() {
      return !inBraceorequalinitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInitializerclause = new java.util.Stack<>();

	@Override
	public void enterInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Initializerclause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInitializerclause.push(true);
	}

	public void exitInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		onExit();
		this.inInitializerclause.pop();
	}

	public boolean inInitializerclause() {
      return !inInitializerclause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInitializerlist = new java.util.Stack<>();

	@Override
	public void enterInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Initializerlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inInitializerlist.push(true);
	}

	public void exitInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		onExit();
		this.inInitializerlist.pop();
	}

	public boolean inInitializerlist() {
      return !inInitializerlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBracedinitlist = new java.util.Stack<>();

	@Override
	public void enterBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Bracedinitlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBracedinitlist.push(true);
	}

	public void exitBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		onExit();
		this.inBracedinitlist.pop();
	}

	public boolean inBracedinitlist() {
      return !inBracedinitlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassname = new java.util.Stack<>();

	@Override
	public void enterClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Classname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inClassname.push(true);
	}

	public void exitClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		onExit();
		this.inClassname.pop();
	}

	public boolean inClassname() {
      return !inClassname.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassspecifier = new java.util.Stack<>();

	@Override
	public void enterClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Classspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inClassspecifier.push(true);
	}

	public void exitClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		onExit();
		this.inClassspecifier.pop();
	}

	public boolean inClassspecifier() {
      return !inClassspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClasshead = new java.util.Stack<>();

	@Override
	public void enterClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		final Node node = model.findOrCreate(Label.label("Classhead"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inClasshead.push(true);
	}

	public void exitClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		onExit();
		this.inClasshead.pop();
	}

	public boolean inClasshead() {
      return !inClasshead.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassheadname = new java.util.Stack<>();

	@Override
	public void enterClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Classheadname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inClassheadname.push(true);
	}

	public void exitClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		onExit();
		this.inClassheadname.pop();
	}

	public boolean inClassheadname() {
      return !inClassheadname.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassvirtspecifier = new java.util.Stack<>();

	@Override
	public void enterClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Classvirtspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inClassvirtspecifier.push(true);
	}

	public void exitClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		onExit();
		this.inClassvirtspecifier.pop();
	}

	public boolean inClassvirtspecifier() {
      return !inClassvirtspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClasskey = new java.util.Stack<>();

	@Override
	public void enterClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		final Node node = model.findOrCreate(Label.label("Classkey"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inClasskey.push(true);
	}

	public void exitClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		onExit();
		this.inClasskey.pop();
	}

	public boolean inClasskey() {
      return !inClasskey.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberspecification = new java.util.Stack<>();

	@Override
	public void enterMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberspecification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMemberspecification.push(true);
	}

	public void exitMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		onExit();
		this.inMemberspecification.pop();
	}

	public boolean inMemberspecification() {
      return !inMemberspecification.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberdeclaration = new java.util.Stack<>();

	@Override
	public void enterMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberdeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMemberdeclaration.push(true);
	}

	public void exitMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		onExit();
		this.inMemberdeclaration.pop();
	}

	public boolean inMemberdeclaration() {
      return !inMemberdeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberdeclaratorlist = new java.util.Stack<>();

	@Override
	public void enterMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberdeclaratorlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMemberdeclaratorlist.push(true);
	}

	public void exitMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		onExit();
		this.inMemberdeclaratorlist.pop();
	}

	public boolean inMemberdeclaratorlist() {
      return !inMemberdeclaratorlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberdeclarator = new java.util.Stack<>();

	@Override
	public void enterMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberdeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMemberdeclarator.push(true);
	}

	public void exitMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		onExit();
		this.inMemberdeclarator.pop();
	}

	public boolean inMemberdeclarator() {
      return !inMemberdeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVirtspecifierseq = new java.util.Stack<>();

	@Override
	public void enterVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Virtspecifierseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inVirtspecifierseq.push(true);
	}

	public void exitVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		onExit();
		this.inVirtspecifierseq.pop();
	}

	public boolean inVirtspecifierseq() {
      return !inVirtspecifierseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVirtspecifier = new java.util.Stack<>();

	@Override
	public void enterVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Virtspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inVirtspecifier.push(true);
	}

	public void exitVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		onExit();
		this.inVirtspecifier.pop();
	}

	public boolean inVirtspecifier() {
      return !inVirtspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPurespecifier = new java.util.Stack<>();

	@Override
	public void enterPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Purespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPurespecifier.push(true);
	}

	public void exitPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		onExit();
		this.inPurespecifier.pop();
	}

	public boolean inPurespecifier() {
      return !inPurespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBaseclause = new java.util.Stack<>();

	@Override
	public void enterBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Baseclause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBaseclause.push(true);
	}

	public void exitBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		onExit();
		this.inBaseclause.pop();
	}

	public boolean inBaseclause() {
      return !inBaseclause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBasespecifierlist = new java.util.Stack<>();

	@Override
	public void enterBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Basespecifierlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBasespecifierlist.push(true);
	}

	public void exitBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		onExit();
		this.inBasespecifierlist.pop();
	}

	public boolean inBasespecifierlist() {
      return !inBasespecifierlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBasespecifier = new java.util.Stack<>();

	@Override
	public void enterBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Basespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBasespecifier.push(true);
	}

	public void exitBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		onExit();
		this.inBasespecifier.pop();
	}

	public boolean inBasespecifier() {
      return !inBasespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassordecltype = new java.util.Stack<>();

	@Override
	public void enterClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		final Node node = model.findOrCreate(Label.label("Classordecltype"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inClassordecltype.push(true);
	}

	public void exitClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		onExit();
		this.inClassordecltype.pop();
	}

	public boolean inClassordecltype() {
      return !inClassordecltype.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBasetypespecifier = new java.util.Stack<>();

	@Override
	public void enterBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Basetypespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBasetypespecifier.push(true);
	}

	public void exitBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		onExit();
		this.inBasetypespecifier.pop();
	}

	public boolean inBasetypespecifier() {
      return !inBasetypespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAccessspecifier = new java.util.Stack<>();

	@Override
	public void enterAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Accessspecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inAccessspecifier.push(true);
	}

	public void exitAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		onExit();
		this.inAccessspecifier.pop();
	}

	public boolean inAccessspecifier() {
      return !inAccessspecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConversionfunctionid = new java.util.Stack<>();

	@Override
	public void enterConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		final Node node = model.findOrCreate(Label.label("Conversionfunctionid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConversionfunctionid.push(true);
	}

	public void exitConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		onExit();
		this.inConversionfunctionid.pop();
	}

	public boolean inConversionfunctionid() {
      return !inConversionfunctionid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConversiontypeid = new java.util.Stack<>();

	@Override
	public void enterConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		final Node node = model.findOrCreate(Label.label("Conversiontypeid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConversiontypeid.push(true);
	}

	public void exitConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		onExit();
		this.inConversiontypeid.pop();
	}

	public boolean inConversiontypeid() {
      return !inConversiontypeid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConversiondeclarator = new java.util.Stack<>();

	@Override
	public void enterConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Conversiondeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inConversiondeclarator.push(true);
	}

	public void exitConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		onExit();
		this.inConversiondeclarator.pop();
	}

	public boolean inConversiondeclarator() {
      return !inConversiondeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCtorinitializer = new java.util.Stack<>();

	@Override
	public void enterCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Ctorinitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inCtorinitializer.push(true);
	}

	public void exitCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		onExit();
		this.inCtorinitializer.pop();
	}

	public boolean inCtorinitializer() {
      return !inCtorinitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMeminitializerlist = new java.util.Stack<>();

	@Override
	public void enterMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Meminitializerlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMeminitializerlist.push(true);
	}

	public void exitMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		onExit();
		this.inMeminitializerlist.pop();
	}

	public boolean inMeminitializerlist() {
      return !inMeminitializerlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMeminitializer = new java.util.Stack<>();

	@Override
	public void enterMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Meminitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMeminitializer.push(true);
	}

	public void exitMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		onExit();
		this.inMeminitializer.pop();
	}

	public boolean inMeminitializer() {
      return !inMeminitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMeminitializerid = new java.util.Stack<>();

	@Override
	public void enterMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		final Node node = model.findOrCreate(Label.label("Meminitializerid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inMeminitializerid.push(true);
	}

	public void exitMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		onExit();
		this.inMeminitializerid.pop();
	}

	public boolean inMeminitializerid() {
      return !inMeminitializerid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorfunctionid = new java.util.Stack<>();

	@Override
	public void enterOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		final Node node = model.findOrCreate(Label.label("Operatorfunctionid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOperatorfunctionid.push(true);
	}

	public void exitOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		onExit();
		this.inOperatorfunctionid.pop();
	}

	public boolean inOperatorfunctionid() {
      return !inOperatorfunctionid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteraloperatorid = new java.util.Stack<>();

	@Override
	public void enterLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		final Node node = model.findOrCreate(Label.label("Literaloperatorid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLiteraloperatorid.push(true);
	}

	public void exitLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		onExit();
		this.inLiteraloperatorid.pop();
	}

	public boolean inLiteraloperatorid() {
      return !inLiteraloperatorid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplatedeclaration = new java.util.Stack<>();

	@Override
	public void enterTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Templatedeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTemplatedeclaration.push(true);
	}

	public void exitTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		onExit();
		this.inTemplatedeclaration.pop();
	}

	public boolean inTemplatedeclaration() {
      return !inTemplatedeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplateparameterlist = new java.util.Stack<>();

	@Override
	public void enterTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateparameterlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTemplateparameterlist.push(true);
	}

	public void exitTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		onExit();
		this.inTemplateparameterlist.pop();
	}

	public boolean inTemplateparameterlist() {
      return !inTemplateparameterlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplateparameter = new java.util.Stack<>();

	@Override
	public void enterTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateparameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTemplateparameter.push(true);
	}

	public void exitTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		onExit();
		this.inTemplateparameter.pop();
	}

	public boolean inTemplateparameter() {
      return !inTemplateparameter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeparameter = new java.util.Stack<>();

	@Override
	public void enterTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		final Node node = model.findOrCreate(Label.label("Typeparameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeparameter.push(true);
	}

	public void exitTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		onExit();
		this.inTypeparameter.pop();
	}

	public boolean inTypeparameter() {
      return !inTypeparameter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpletemplateid = new java.util.Stack<>();

	@Override
	public void enterSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		final Node node = model.findOrCreate(Label.label("Simpletemplateid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inSimpletemplateid.push(true);
	}

	public void exitSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		onExit();
		this.inSimpletemplateid.pop();
	}

	public boolean inSimpletemplateid() {
      return !inSimpletemplateid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplateid = new java.util.Stack<>();

	@Override
	public void enterTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTemplateid.push(true);
	}

	public void exitTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		onExit();
		this.inTemplateid.pop();
	}

	public boolean inTemplateid() {
      return !inTemplateid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplatename = new java.util.Stack<>();

	@Override
	public void enterTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Templatename"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTemplatename.push(true);
	}

	public void exitTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		onExit();
		this.inTemplatename.pop();
	}

	public boolean inTemplatename() {
      return !inTemplatename.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplateargumentlist = new java.util.Stack<>();

	@Override
	public void enterTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateargumentlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTemplateargumentlist.push(true);
	}

	public void exitTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		onExit();
		this.inTemplateargumentlist.pop();
	}

	public boolean inTemplateargumentlist() {
      return !inTemplateargumentlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplateargument = new java.util.Stack<>();

	@Override
	public void enterTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateargument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTemplateargument.push(true);
	}

	public void exitTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		onExit();
		this.inTemplateargument.pop();
	}

	public boolean inTemplateargument() {
      return !inTemplateargument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypenamespecifier = new java.util.Stack<>();

	@Override
	public void enterTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Typenamespecifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypenamespecifier.push(true);
	}

	public void exitTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		onExit();
		this.inTypenamespecifier.pop();
	}

	public boolean inTypenamespecifier() {
      return !inTypenamespecifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExplicitinstantiation = new java.util.Stack<>();

	@Override
	public void enterExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		final Node node = model.findOrCreate(Label.label("Explicitinstantiation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExplicitinstantiation.push(true);
	}

	public void exitExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		onExit();
		this.inExplicitinstantiation.pop();
	}

	public boolean inExplicitinstantiation() {
      return !inExplicitinstantiation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExplicitspecialization = new java.util.Stack<>();

	@Override
	public void enterExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		final Node node = model.findOrCreate(Label.label("Explicitspecialization"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExplicitspecialization.push(true);
	}

	public void exitExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		onExit();
		this.inExplicitspecialization.pop();
	}

	public boolean inExplicitspecialization() {
      return !inExplicitspecialization.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTryblock = new java.util.Stack<>();

	@Override
	public void enterTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		final Node node = model.findOrCreate(Label.label("Tryblock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTryblock.push(true);
	}

	public void exitTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		onExit();
		this.inTryblock.pop();
	}

	public boolean inTryblock() {
      return !inTryblock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctiontryblock = new java.util.Stack<>();

	@Override
	public void enterFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		final Node node = model.findOrCreate(Label.label("Functiontryblock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctiontryblock.push(true);
	}

	public void exitFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		onExit();
		this.inFunctiontryblock.pop();
	}

	public boolean inFunctiontryblock() {
      return !inFunctiontryblock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandlerseq = new java.util.Stack<>();

	@Override
	public void enterHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Handlerseq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inHandlerseq.push(true);
	}

	public void exitHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		onExit();
		this.inHandlerseq.pop();
	}

	public boolean inHandlerseq() {
      return !inHandlerseq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHandler = new java.util.Stack<>();

	@Override
	public void enterHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inHandler.push(true);
	}

	public void exitHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		onExit();
		this.inHandler.pop();
	}

	public boolean inHandler() {
      return !inHandler.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExceptiondeclaration = new java.util.Stack<>();

	@Override
	public void enterExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Exceptiondeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExceptiondeclaration.push(true);
	}

	public void exitExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		onExit();
		this.inExceptiondeclaration.pop();
	}

	public boolean inExceptiondeclaration() {
      return !inExceptiondeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inThrowexpression = new java.util.Stack<>();

	@Override
	public void enterThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Throwexpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inThrowexpression.push(true);
	}

	public void exitThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		onExit();
		this.inThrowexpression.pop();
	}

	public boolean inThrowexpression() {
      return !inThrowexpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExceptionspecification = new java.util.Stack<>();

	@Override
	public void enterExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Exceptionspecification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inExceptionspecification.push(true);
	}

	public void exitExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		onExit();
		this.inExceptionspecification.pop();
	}

	public boolean inExceptionspecification() {
      return !inExceptionspecification.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDynamicexceptionspecification = new java.util.Stack<>();

	@Override
	public void enterDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Dynamicexceptionspecification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDynamicexceptionspecification.push(true);
	}

	public void exitDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		onExit();
		this.inDynamicexceptionspecification.pop();
	}

	public boolean inDynamicexceptionspecification() {
      return !inDynamicexceptionspecification.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeidlist = new java.util.Stack<>();

	@Override
	public void enterTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Typeidlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inTypeidlist.push(true);
	}

	public void exitTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		onExit();
		this.inTypeidlist.pop();
	}

	public boolean inTypeidlist() {
      return !inTypeidlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNoexceptspecification = new java.util.Stack<>();

	@Override
	public void enterNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Noexceptspecification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNoexceptspecification.push(true);
	}

	public void exitNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		onExit();
		this.inNoexceptspecification.pop();
	}

	public boolean inNoexceptspecification() {
      return !inNoexceptspecification.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRightShift = new java.util.Stack<>();

	@Override
	public void enterRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		final Node node = model.findOrCreate(Label.label("RightShift"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRightShift.push(true);
	}

	public void exitRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		onExit();
		this.inRightShift.pop();
	}

	public boolean inRightShift() {
      return !inRightShift.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRightShiftAssign = new java.util.Stack<>();

	@Override
	public void enterRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		final Node node = model.findOrCreate(Label.label("RightShiftAssign"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRightShiftAssign.push(true);
	}

	public void exitRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		onExit();
		this.inRightShiftAssign.pop();
	}

	public boolean inRightShiftAssign() {
      return !inRightShiftAssign.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperator = new java.util.Stack<>();

	@Override
	public void enterOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Operator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOperator.push(true);
	}

	public void exitOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		onExit();
		this.inOperator.pop();
	}

	public boolean inOperator() {
      return !inOperator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBooleanliteral = new java.util.Stack<>();

	@Override
	public void enterBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Booleanliteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inBooleanliteral.push(true);
	}

	public void exitBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		onExit();
		this.inBooleanliteral.pop();
	}

	public boolean inBooleanliteral() {
      return !inBooleanliteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPointerliteral = new java.util.Stack<>();

	@Override
	public void enterPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Pointerliteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPointerliteral.push(true);
	}

	public void exitPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		onExit();
		this.inPointerliteral.pop();
	}

	public boolean inPointerliteral() {
      return !inPointerliteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUserdefinedliteral = new java.util.Stack<>();

	@Override
	public void enterUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Userdefinedliteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inUserdefinedliteral.push(true);
	}

	public void exitUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		onExit();
		this.inUserdefinedliteral.pop();
	}

	public boolean inUserdefinedliteral() {
      return !inUserdefinedliteral.isEmpty(); 
   }

}