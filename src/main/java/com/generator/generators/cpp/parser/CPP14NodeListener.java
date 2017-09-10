package com.generator.generators.cpp.parser;

public class CPP14NodeListener extends CPP14BaseListener {

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

	public CPP14NodeListener() {
		this(false);
	}

	public CPP14NodeListener(boolean debug) {
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

	protected boolean inTranslationunit = false;

	@Override
	public void enterTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		onEnter(new Node("Translationunit", arg.getText(), arg.getStart().getText()));
		this.inTranslationunit = true;
	}

	public void exitTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		onExit();
		this.inTranslationunit = false;
	}

	protected boolean inPrimaryexpression = false;

	@Override
	public void enterPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		onEnter(new Node("Primaryexpression", arg.getText(), arg.getStart().getText()));
		this.inPrimaryexpression = true;
	}

	public void exitPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		onExit();
		this.inPrimaryexpression = false;
	}

	protected boolean inIdexpression = false;

	@Override
	public void enterIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		onEnter(new Node("Idexpression", arg.getText(), arg.getStart().getText()));
		this.inIdexpression = true;
	}

	public void exitIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		onExit();
		this.inIdexpression = false;
	}

	protected boolean inUnqualifiedid = false;

	@Override
	public void enterUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		onEnter(new Node("Unqualifiedid", arg.getText(), arg.getStart().getText()));
		this.inUnqualifiedid = true;
	}

	public void exitUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		onExit();
		this.inUnqualifiedid = false;
	}

	protected boolean inQualifiedid = false;

	@Override
	public void enterQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		onEnter(new Node("Qualifiedid", arg.getText(), arg.getStart().getText()));
		this.inQualifiedid = true;
	}

	public void exitQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		onExit();
		this.inQualifiedid = false;
	}

	protected boolean inNestednamespecifier = false;

	@Override
	public void enterNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		onEnter(new Node("Nestednamespecifier", arg.getText(), arg.getStart().getText()));
		this.inNestednamespecifier = true;
	}

	public void exitNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		onExit();
		this.inNestednamespecifier = false;
	}

	protected boolean inLambdaexpression = false;

	@Override
	public void enterLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		onEnter(new Node("Lambdaexpression", arg.getText(), arg.getStart().getText()));
		this.inLambdaexpression = true;
	}

	public void exitLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		onExit();
		this.inLambdaexpression = false;
	}

	protected boolean inLambdaintroducer = false;

	@Override
	public void enterLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		onEnter(new Node("Lambdaintroducer", arg.getText(), arg.getStart().getText()));
		this.inLambdaintroducer = true;
	}

	public void exitLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		onExit();
		this.inLambdaintroducer = false;
	}

	protected boolean inLambdacapture = false;

	@Override
	public void enterLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		onEnter(new Node("Lambdacapture", arg.getText(), arg.getStart().getText()));
		this.inLambdacapture = true;
	}

	public void exitLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		onExit();
		this.inLambdacapture = false;
	}

	protected boolean inCapturedefault = false;

	@Override
	public void enterCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		onEnter(new Node("Capturedefault", arg.getText(), arg.getStart().getText()));
		this.inCapturedefault = true;
	}

	public void exitCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		onExit();
		this.inCapturedefault = false;
	}

	protected boolean inCapturelist = false;

	@Override
	public void enterCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		onEnter(new Node("Capturelist", arg.getText(), arg.getStart().getText()));
		this.inCapturelist = true;
	}

	public void exitCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		onExit();
		this.inCapturelist = false;
	}

	protected boolean inCapture = false;

	@Override
	public void enterCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		onEnter(new Node("Capture", arg.getText(), arg.getStart().getText()));
		this.inCapture = true;
	}

	public void exitCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		onExit();
		this.inCapture = false;
	}

	protected boolean inSimplecapture = false;

	@Override
	public void enterSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		onEnter(new Node("Simplecapture", arg.getText(), arg.getStart().getText()));
		this.inSimplecapture = true;
	}

	public void exitSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		onExit();
		this.inSimplecapture = false;
	}

	protected boolean inInitcapture = false;

	@Override
	public void enterInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		onEnter(new Node("Initcapture", arg.getText(), arg.getStart().getText()));
		this.inInitcapture = true;
	}

	public void exitInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		onExit();
		this.inInitcapture = false;
	}

	protected boolean inLambdadeclarator = false;

	@Override
	public void enterLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		onEnter(new Node("Lambdadeclarator", arg.getText(), arg.getStart().getText()));
		this.inLambdadeclarator = true;
	}

	public void exitLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		onExit();
		this.inLambdadeclarator = false;
	}

	protected boolean inPostfixexpression = false;

	@Override
	public void enterPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		onEnter(new Node("Postfixexpression", arg.getText(), arg.getStart().getText()));
		this.inPostfixexpression = true;
	}

	public void exitPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		onExit();
		this.inPostfixexpression = false;
	}

	protected boolean inExpressionlist = false;

	@Override
	public void enterExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		onEnter(new Node("Expressionlist", arg.getText(), arg.getStart().getText()));
		this.inExpressionlist = true;
	}

	public void exitExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		onExit();
		this.inExpressionlist = false;
	}

	protected boolean inPseudodestructorname = false;

	@Override
	public void enterPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		onEnter(new Node("Pseudodestructorname", arg.getText(), arg.getStart().getText()));
		this.inPseudodestructorname = true;
	}

	public void exitPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		onExit();
		this.inPseudodestructorname = false;
	}

	protected boolean inUnaryexpression = false;

	@Override
	public void enterUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		onEnter(new Node("Unaryexpression", arg.getText(), arg.getStart().getText()));
		this.inUnaryexpression = true;
	}

	public void exitUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		onExit();
		this.inUnaryexpression = false;
	}

	protected boolean inUnaryoperator = false;

	@Override
	public void enterUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		onEnter(new Node("Unaryoperator", arg.getText(), arg.getStart().getText()));
		this.inUnaryoperator = true;
	}

	public void exitUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		onExit();
		this.inUnaryoperator = false;
	}

	protected boolean inNewexpression = false;

	@Override
	public void enterNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		onEnter(new Node("Newexpression", arg.getText(), arg.getStart().getText()));
		this.inNewexpression = true;
	}

	public void exitNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		onExit();
		this.inNewexpression = false;
	}

	protected boolean inNewplacement = false;

	@Override
	public void enterNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		onEnter(new Node("Newplacement", arg.getText(), arg.getStart().getText()));
		this.inNewplacement = true;
	}

	public void exitNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		onExit();
		this.inNewplacement = false;
	}

	protected boolean inNewtypeid = false;

	@Override
	public void enterNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		onEnter(new Node("Newtypeid", arg.getText(), arg.getStart().getText()));
		this.inNewtypeid = true;
	}

	public void exitNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		onExit();
		this.inNewtypeid = false;
	}

	protected boolean inNewdeclarator = false;

	@Override
	public void enterNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		onEnter(new Node("Newdeclarator", arg.getText(), arg.getStart().getText()));
		this.inNewdeclarator = true;
	}

	public void exitNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		onExit();
		this.inNewdeclarator = false;
	}

	protected boolean inNoptrnewdeclarator = false;

	@Override
	public void enterNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		onEnter(new Node("Noptrnewdeclarator", arg.getText(), arg.getStart().getText()));
		this.inNoptrnewdeclarator = true;
	}

	public void exitNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		onExit();
		this.inNoptrnewdeclarator = false;
	}

	protected boolean inNewinitializer = false;

	@Override
	public void enterNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		onEnter(new Node("Newinitializer", arg.getText(), arg.getStart().getText()));
		this.inNewinitializer = true;
	}

	public void exitNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		onExit();
		this.inNewinitializer = false;
	}

	protected boolean inDeleteexpression = false;

	@Override
	public void enterDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		onEnter(new Node("Deleteexpression", arg.getText(), arg.getStart().getText()));
		this.inDeleteexpression = true;
	}

	public void exitDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		onExit();
		this.inDeleteexpression = false;
	}

	protected boolean inNoexceptexpression = false;

	@Override
	public void enterNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		onEnter(new Node("Noexceptexpression", arg.getText(), arg.getStart().getText()));
		this.inNoexceptexpression = true;
	}

	public void exitNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		onExit();
		this.inNoexceptexpression = false;
	}

	protected boolean inCastexpression = false;

	@Override
	public void enterCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		onEnter(new Node("Castexpression", arg.getText(), arg.getStart().getText()));
		this.inCastexpression = true;
	}

	public void exitCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		onExit();
		this.inCastexpression = false;
	}

	protected boolean inPmexpression = false;

	@Override
	public void enterPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		onEnter(new Node("Pmexpression", arg.getText(), arg.getStart().getText()));
		this.inPmexpression = true;
	}

	public void exitPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		onExit();
		this.inPmexpression = false;
	}

	protected boolean inMultiplicativeexpression = false;

	@Override
	public void enterMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		onEnter(new Node("Multiplicativeexpression", arg.getText(), arg.getStart().getText()));
		this.inMultiplicativeexpression = true;
	}

	public void exitMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		onExit();
		this.inMultiplicativeexpression = false;
	}

	protected boolean inAdditiveexpression = false;

	@Override
	public void enterAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		onEnter(new Node("Additiveexpression", arg.getText(), arg.getStart().getText()));
		this.inAdditiveexpression = true;
	}

	public void exitAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		onExit();
		this.inAdditiveexpression = false;
	}

	protected boolean inShiftexpression = false;

	@Override
	public void enterShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		onEnter(new Node("Shiftexpression", arg.getText(), arg.getStart().getText()));
		this.inShiftexpression = true;
	}

	public void exitShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		onExit();
		this.inShiftexpression = false;
	}

	protected boolean inRelationalexpression = false;

	@Override
	public void enterRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		onEnter(new Node("Relationalexpression", arg.getText(), arg.getStart().getText()));
		this.inRelationalexpression = true;
	}

	public void exitRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		onExit();
		this.inRelationalexpression = false;
	}

	protected boolean inEqualityexpression = false;

	@Override
	public void enterEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		onEnter(new Node("Equalityexpression", arg.getText(), arg.getStart().getText()));
		this.inEqualityexpression = true;
	}

	public void exitEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		onExit();
		this.inEqualityexpression = false;
	}

	protected boolean inExpression = false;

	@Override
	public void enterExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		onEnter(new Node("Expression", arg.getText(), arg.getStart().getText()));
		this.inExpression = true;
	}

	public void exitExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		onExit();
		this.inExpression = false;
	}

	protected boolean inAndexpression = false;

	@Override
	public void enterAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		onEnter(new Node("Andexpression", arg.getText(), arg.getStart().getText()));
		this.inAndexpression = true;
	}

	public void exitAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		onExit();
		this.inAndexpression = false;
	}

	protected boolean inExclusiveorexpression = false;

	@Override
	public void enterExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		onEnter(new Node("Exclusiveorexpression", arg.getText(), arg.getStart().getText()));
		this.inExclusiveorexpression = true;
	}

	public void exitExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		onExit();
		this.inExclusiveorexpression = false;
	}

	protected boolean inInclusiveorexpression = false;

	@Override
	public void enterInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		onEnter(new Node("Inclusiveorexpression", arg.getText(), arg.getStart().getText()));
		this.inInclusiveorexpression = true;
	}

	public void exitInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		onExit();
		this.inInclusiveorexpression = false;
	}

	protected boolean inLogicalandexpression = false;

	@Override
	public void enterLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		onEnter(new Node("Logicalandexpression", arg.getText(), arg.getStart().getText()));
		this.inLogicalandexpression = true;
	}

	public void exitLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		onExit();
		this.inLogicalandexpression = false;
	}

	protected boolean inLogicalorexpression = false;

	@Override
	public void enterLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		onEnter(new Node("Logicalorexpression", arg.getText(), arg.getStart().getText()));
		this.inLogicalorexpression = true;
	}

	public void exitLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		onExit();
		this.inLogicalorexpression = false;
	}

	protected boolean inConditionalexpression = false;

	@Override
	public void enterConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		onEnter(new Node("Conditionalexpression", arg.getText(), arg.getStart().getText()));
		this.inConditionalexpression = true;
	}

	public void exitConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		onExit();
		this.inConditionalexpression = false;
	}

	protected boolean inAssignmentexpression = false;

	@Override
	public void enterAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		onEnter(new Node("Assignmentexpression", arg.getText(), arg.getStart().getText()));
		this.inAssignmentexpression = true;
	}

	public void exitAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		onExit();
		this.inAssignmentexpression = false;
	}

	protected boolean inAssignmentoperator = false;

	@Override
	public void enterAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		onEnter(new Node("Assignmentoperator", arg.getText(), arg.getStart().getText()));
		this.inAssignmentoperator = true;
	}

	public void exitAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		onExit();
		this.inAssignmentoperator = false;
	}

	protected boolean inConstantexpression = false;

	@Override
	public void enterConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		onEnter(new Node("Constantexpression", arg.getText(), arg.getStart().getText()));
		this.inConstantexpression = true;
	}

	public void exitConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		onExit();
		this.inConstantexpression = false;
	}

	protected boolean inStatement = false;

	@Override
	public void enterStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
		this.inStatement = true;
	}

	public void exitStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		onExit();
		this.inStatement = false;
	}

	protected boolean inLabeledstatement = false;

	@Override
	public void enterLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		onEnter(new Node("Labeledstatement", arg.getText(), arg.getStart().getText()));
		this.inLabeledstatement = true;
	}

	public void exitLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		onExit();
		this.inLabeledstatement = false;
	}

	protected boolean inExpressionstatement = false;

	@Override
	public void enterExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		onEnter(new Node("Expressionstatement", arg.getText(), arg.getStart().getText()));
		this.inExpressionstatement = true;
	}

	public void exitExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		onExit();
		this.inExpressionstatement = false;
	}

	protected boolean inCompoundstatement = false;

	@Override
	public void enterCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		onEnter(new Node("Compoundstatement", arg.getText(), arg.getStart().getText()));
		this.inCompoundstatement = true;
	}

	public void exitCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		onExit();
		this.inCompoundstatement = false;
	}

	protected boolean inStatementseq = false;

	@Override
	public void enterStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		onEnter(new Node("Statementseq", arg.getText(), arg.getStart().getText()));
		this.inStatementseq = true;
	}

	public void exitStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		onExit();
		this.inStatementseq = false;
	}

	protected boolean inSelectionstatement = false;

	@Override
	public void enterSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		onEnter(new Node("Selectionstatement", arg.getText(), arg.getStart().getText()));
		this.inSelectionstatement = true;
	}

	public void exitSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		onExit();
		this.inSelectionstatement = false;
	}

	protected boolean inCondition = false;

	@Override
	public void enterCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		onEnter(new Node("Condition", arg.getText(), arg.getStart().getText()));
		this.inCondition = true;
	}

	public void exitCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		onExit();
		this.inCondition = false;
	}

	protected boolean inIterationstatement = false;

	@Override
	public void enterIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		onEnter(new Node("Iterationstatement", arg.getText(), arg.getStart().getText()));
		this.inIterationstatement = true;
	}

	public void exitIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		onExit();
		this.inIterationstatement = false;
	}

	protected boolean inForinitstatement = false;

	@Override
	public void enterForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		onEnter(new Node("Forinitstatement", arg.getText(), arg.getStart().getText()));
		this.inForinitstatement = true;
	}

	public void exitForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		onExit();
		this.inForinitstatement = false;
	}

	protected boolean inForrangedeclaration = false;

	@Override
	public void enterForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		onEnter(new Node("Forrangedeclaration", arg.getText(), arg.getStart().getText()));
		this.inForrangedeclaration = true;
	}

	public void exitForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		onExit();
		this.inForrangedeclaration = false;
	}

	protected boolean inForrangeinitializer = false;

	@Override
	public void enterForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		onEnter(new Node("Forrangeinitializer", arg.getText(), arg.getStart().getText()));
		this.inForrangeinitializer = true;
	}

	public void exitForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		onExit();
		this.inForrangeinitializer = false;
	}

	protected boolean inJumpstatement = false;

	@Override
	public void enterJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		onEnter(new Node("Jumpstatement", arg.getText(), arg.getStart().getText()));
		this.inJumpstatement = true;
	}

	public void exitJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		onExit();
		this.inJumpstatement = false;
	}

	protected boolean inDeclarationstatement = false;

	@Override
	public void enterDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		onEnter(new Node("Declarationstatement", arg.getText(), arg.getStart().getText()));
		this.inDeclarationstatement = true;
	}

	public void exitDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		onExit();
		this.inDeclarationstatement = false;
	}

	protected boolean inDeclarationseq = false;

	@Override
	public void enterDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		onEnter(new Node("Declarationseq", arg.getText(), arg.getStart().getText()));
		this.inDeclarationseq = true;
	}

	public void exitDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		onExit();
		this.inDeclarationseq = false;
	}

	protected boolean inDeclaration = false;

	@Override
	public void enterDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		onEnter(new Node("Declaration", arg.getText(), arg.getStart().getText()));
		this.inDeclaration = true;
	}

	public void exitDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		onExit();
		this.inDeclaration = false;
	}

	protected boolean inBlockdeclaration = false;

	@Override
	public void enterBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		onEnter(new Node("Blockdeclaration", arg.getText(), arg.getStart().getText()));
		this.inBlockdeclaration = true;
	}

	public void exitBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		onExit();
		this.inBlockdeclaration = false;
	}

	protected boolean inAliasdeclaration = false;

	@Override
	public void enterAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		onEnter(new Node("Aliasdeclaration", arg.getText(), arg.getStart().getText()));
		this.inAliasdeclaration = true;
	}

	public void exitAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		onExit();
		this.inAliasdeclaration = false;
	}

	protected boolean inSimpledeclaration = false;

	@Override
	public void enterSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		onEnter(new Node("Simpledeclaration", arg.getText(), arg.getStart().getText()));
		this.inSimpledeclaration = true;
	}

	public void exitSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		onExit();
		this.inSimpledeclaration = false;
	}

	protected boolean inStatic_assertdeclaration = false;

	@Override
	public void enterStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		onEnter(new Node("Static_assertdeclaration", arg.getText(), arg.getStart().getText()));
		this.inStatic_assertdeclaration = true;
	}

	public void exitStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		onExit();
		this.inStatic_assertdeclaration = false;
	}

	protected boolean inEmptydeclaration = false;

	@Override
	public void enterEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		onEnter(new Node("Emptydeclaration", arg.getText(), arg.getStart().getText()));
		this.inEmptydeclaration = true;
	}

	public void exitEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		onExit();
		this.inEmptydeclaration = false;
	}

	protected boolean inAttributedeclaration = false;

	@Override
	public void enterAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		onEnter(new Node("Attributedeclaration", arg.getText(), arg.getStart().getText()));
		this.inAttributedeclaration = true;
	}

	public void exitAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		onExit();
		this.inAttributedeclaration = false;
	}

	protected boolean inDeclspecifier = false;

	@Override
	public void enterDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		onEnter(new Node("Declspecifier", arg.getText(), arg.getStart().getText()));
		this.inDeclspecifier = true;
	}

	public void exitDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		onExit();
		this.inDeclspecifier = false;
	}

	protected boolean inDeclspecifierseq = false;

	@Override
	public void enterDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		onEnter(new Node("Declspecifierseq", arg.getText(), arg.getStart().getText()));
		this.inDeclspecifierseq = true;
	}

	public void exitDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		onExit();
		this.inDeclspecifierseq = false;
	}

	protected boolean inStorageclassspecifier = false;

	@Override
	public void enterStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		onEnter(new Node("Storageclassspecifier", arg.getText(), arg.getStart().getText()));
		this.inStorageclassspecifier = true;
	}

	public void exitStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		onExit();
		this.inStorageclassspecifier = false;
	}

	protected boolean inFunctionspecifier = false;

	@Override
	public void enterFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		onEnter(new Node("Functionspecifier", arg.getText(), arg.getStart().getText()));
		this.inFunctionspecifier = true;
	}

	public void exitFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		onExit();
		this.inFunctionspecifier = false;
	}

	protected boolean inTypedefname = false;

	@Override
	public void enterTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		onEnter(new Node("Typedefname", arg.getText(), arg.getStart().getText()));
		this.inTypedefname = true;
	}

	public void exitTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		onExit();
		this.inTypedefname = false;
	}

	protected boolean inTypespecifier = false;

	@Override
	public void enterTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		onEnter(new Node("Typespecifier", arg.getText(), arg.getStart().getText()));
		this.inTypespecifier = true;
	}

	public void exitTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		onExit();
		this.inTypespecifier = false;
	}

	protected boolean inTrailingtypespecifier = false;

	@Override
	public void enterTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		onEnter(new Node("Trailingtypespecifier", arg.getText(), arg.getStart().getText()));
		this.inTrailingtypespecifier = true;
	}

	public void exitTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		onExit();
		this.inTrailingtypespecifier = false;
	}

	protected boolean inTypespecifierseq = false;

	@Override
	public void enterTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		onEnter(new Node("Typespecifierseq", arg.getText(), arg.getStart().getText()));
		this.inTypespecifierseq = true;
	}

	public void exitTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		onExit();
		this.inTypespecifierseq = false;
	}

	protected boolean inTrailingtypespecifierseq = false;

	@Override
	public void enterTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		onEnter(new Node("Trailingtypespecifierseq", arg.getText(), arg.getStart().getText()));
		this.inTrailingtypespecifierseq = true;
	}

	public void exitTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		onExit();
		this.inTrailingtypespecifierseq = false;
	}

	protected boolean inSimpletypespecifier = false;

	@Override
	public void enterSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		onEnter(new Node("Simpletypespecifier", arg.getText(), arg.getStart().getText()));
		this.inSimpletypespecifier = true;
	}

	public void exitSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		onExit();
		this.inSimpletypespecifier = false;
	}

	protected boolean inTypename = false;

	@Override
	public void enterTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		onEnter(new Node("Typename", arg.getText(), arg.getStart().getText()));
		this.inTypename = true;
	}

	public void exitTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		onExit();
		this.inTypename = false;
	}

	protected boolean inDecltypespecifier = false;

	@Override
	public void enterDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		onEnter(new Node("Decltypespecifier", arg.getText(), arg.getStart().getText()));
		this.inDecltypespecifier = true;
	}

	public void exitDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		onExit();
		this.inDecltypespecifier = false;
	}

	protected boolean inElaboratedtypespecifier = false;

	@Override
	public void enterElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		onEnter(new Node("Elaboratedtypespecifier", arg.getText(), arg.getStart().getText()));
		this.inElaboratedtypespecifier = true;
	}

	public void exitElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		onExit();
		this.inElaboratedtypespecifier = false;
	}

	protected boolean inEnumname = false;

	@Override
	public void enterEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		onEnter(new Node("Enumname", arg.getText(), arg.getStart().getText()));
		this.inEnumname = true;
	}

	public void exitEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		onExit();
		this.inEnumname = false;
	}

	protected boolean inEnumspecifier = false;

	@Override
	public void enterEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		onEnter(new Node("Enumspecifier", arg.getText(), arg.getStart().getText()));
		this.inEnumspecifier = true;
	}

	public void exitEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		onExit();
		this.inEnumspecifier = false;
	}

	protected boolean inEnumhead = false;

	@Override
	public void enterEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		onEnter(new Node("Enumhead", arg.getText(), arg.getStart().getText()));
		this.inEnumhead = true;
	}

	public void exitEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		onExit();
		this.inEnumhead = false;
	}

	protected boolean inOpaqueenumdeclaration = false;

	@Override
	public void enterOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		onEnter(new Node("Opaqueenumdeclaration", arg.getText(), arg.getStart().getText()));
		this.inOpaqueenumdeclaration = true;
	}

	public void exitOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		onExit();
		this.inOpaqueenumdeclaration = false;
	}

	protected boolean inEnumkey = false;

	@Override
	public void enterEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		onEnter(new Node("Enumkey", arg.getText(), arg.getStart().getText()));
		this.inEnumkey = true;
	}

	public void exitEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		onExit();
		this.inEnumkey = false;
	}

	protected boolean inEnumbase = false;

	@Override
	public void enterEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		onEnter(new Node("Enumbase", arg.getText(), arg.getStart().getText()));
		this.inEnumbase = true;
	}

	public void exitEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		onExit();
		this.inEnumbase = false;
	}

	protected boolean inEnumeratorlist = false;

	@Override
	public void enterEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		onEnter(new Node("Enumeratorlist", arg.getText(), arg.getStart().getText()));
		this.inEnumeratorlist = true;
	}

	public void exitEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		onExit();
		this.inEnumeratorlist = false;
	}

	protected boolean inEnumeratordefinition = false;

	@Override
	public void enterEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		onEnter(new Node("Enumeratordefinition", arg.getText(), arg.getStart().getText()));
		this.inEnumeratordefinition = true;
	}

	public void exitEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		onExit();
		this.inEnumeratordefinition = false;
	}

	protected boolean inEnumerator = false;

	@Override
	public void enterEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		onEnter(new Node("Enumerator", arg.getText(), arg.getStart().getText()));
		this.inEnumerator = true;
	}

	public void exitEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		onExit();
		this.inEnumerator = false;
	}

	protected boolean inNamespacename = false;

	@Override
	public void enterNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		onEnter(new Node("Namespacename", arg.getText(), arg.getStart().getText()));
		this.inNamespacename = true;
	}

	public void exitNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		onExit();
		this.inNamespacename = false;
	}

	protected boolean inOriginalnamespacename = false;

	@Override
	public void enterOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		onEnter(new Node("Originalnamespacename", arg.getText(), arg.getStart().getText()));
		this.inOriginalnamespacename = true;
	}

	public void exitOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		onExit();
		this.inOriginalnamespacename = false;
	}

	protected boolean inNamespacedefinition = false;

	@Override
	public void enterNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		onEnter(new Node("Namespacedefinition", arg.getText(), arg.getStart().getText()));
		this.inNamespacedefinition = true;
	}

	public void exitNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		onExit();
		this.inNamespacedefinition = false;
	}

	protected boolean inNamednamespacedefinition = false;

	@Override
	public void enterNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		onEnter(new Node("Namednamespacedefinition", arg.getText(), arg.getStart().getText()));
		this.inNamednamespacedefinition = true;
	}

	public void exitNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		onExit();
		this.inNamednamespacedefinition = false;
	}

	protected boolean inOriginalnamespacedefinition = false;

	@Override
	public void enterOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		onEnter(new Node("Originalnamespacedefinition", arg.getText(), arg.getStart().getText()));
		this.inOriginalnamespacedefinition = true;
	}

	public void exitOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		onExit();
		this.inOriginalnamespacedefinition = false;
	}

	protected boolean inExtensionnamespacedefinition = false;

	@Override
	public void enterExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		onEnter(new Node("Extensionnamespacedefinition", arg.getText(), arg.getStart().getText()));
		this.inExtensionnamespacedefinition = true;
	}

	public void exitExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		onExit();
		this.inExtensionnamespacedefinition = false;
	}

	protected boolean inUnnamednamespacedefinition = false;

	@Override
	public void enterUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		onEnter(new Node("Unnamednamespacedefinition", arg.getText(), arg.getStart().getText()));
		this.inUnnamednamespacedefinition = true;
	}

	public void exitUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		onExit();
		this.inUnnamednamespacedefinition = false;
	}

	protected boolean inNamespacebody = false;

	@Override
	public void enterNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		onEnter(new Node("Namespacebody", arg.getText(), arg.getStart().getText()));
		this.inNamespacebody = true;
	}

	public void exitNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		onExit();
		this.inNamespacebody = false;
	}

	protected boolean inNamespacealias = false;

	@Override
	public void enterNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		onEnter(new Node("Namespacealias", arg.getText(), arg.getStart().getText()));
		this.inNamespacealias = true;
	}

	public void exitNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		onExit();
		this.inNamespacealias = false;
	}

	protected boolean inNamespacealiasdefinition = false;

	@Override
	public void enterNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		onEnter(new Node("Namespacealiasdefinition", arg.getText(), arg.getStart().getText()));
		this.inNamespacealiasdefinition = true;
	}

	public void exitNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		onExit();
		this.inNamespacealiasdefinition = false;
	}

	protected boolean inQualifiednamespacespecifier = false;

	@Override
	public void enterQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		onEnter(new Node("Qualifiednamespacespecifier", arg.getText(), arg.getStart().getText()));
		this.inQualifiednamespacespecifier = true;
	}

	public void exitQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		onExit();
		this.inQualifiednamespacespecifier = false;
	}

	protected boolean inUsingdeclaration = false;

	@Override
	public void enterUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		onEnter(new Node("Usingdeclaration", arg.getText(), arg.getStart().getText()));
		this.inUsingdeclaration = true;
	}

	public void exitUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		onExit();
		this.inUsingdeclaration = false;
	}

	protected boolean inUsingdirective = false;

	@Override
	public void enterUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		onEnter(new Node("Usingdirective", arg.getText(), arg.getStart().getText()));
		this.inUsingdirective = true;
	}

	public void exitUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		onExit();
		this.inUsingdirective = false;
	}

	protected boolean inAsmdefinition = false;

	@Override
	public void enterAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		onEnter(new Node("Asmdefinition", arg.getText(), arg.getStart().getText()));
		this.inAsmdefinition = true;
	}

	public void exitAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		onExit();
		this.inAsmdefinition = false;
	}

	protected boolean inLinkagespecification = false;

	@Override
	public void enterLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		onEnter(new Node("Linkagespecification", arg.getText(), arg.getStart().getText()));
		this.inLinkagespecification = true;
	}

	public void exitLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		onExit();
		this.inLinkagespecification = false;
	}

	protected boolean inAttributespecifierseq = false;

	@Override
	public void enterAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		onEnter(new Node("Attributespecifierseq", arg.getText(), arg.getStart().getText()));
		this.inAttributespecifierseq = true;
	}

	public void exitAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		onExit();
		this.inAttributespecifierseq = false;
	}

	protected boolean inAttributespecifier = false;

	@Override
	public void enterAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		onEnter(new Node("Attributespecifier", arg.getText(), arg.getStart().getText()));
		this.inAttributespecifier = true;
	}

	public void exitAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		onExit();
		this.inAttributespecifier = false;
	}

	protected boolean inAlignmentspecifier = false;

	@Override
	public void enterAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		onEnter(new Node("Alignmentspecifier", arg.getText(), arg.getStart().getText()));
		this.inAlignmentspecifier = true;
	}

	public void exitAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		onExit();
		this.inAlignmentspecifier = false;
	}

	protected boolean inAttributelist = false;

	@Override
	public void enterAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		onEnter(new Node("Attributelist", arg.getText(), arg.getStart().getText()));
		this.inAttributelist = true;
	}

	public void exitAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		onExit();
		this.inAttributelist = false;
	}

	protected boolean inAttribute = false;

	@Override
	public void enterAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		onEnter(new Node("Attribute", arg.getText(), arg.getStart().getText()));
		this.inAttribute = true;
	}

	public void exitAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		onExit();
		this.inAttribute = false;
	}

	protected boolean inAttributetoken = false;

	@Override
	public void enterAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		onEnter(new Node("Attributetoken", arg.getText(), arg.getStart().getText()));
		this.inAttributetoken = true;
	}

	public void exitAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		onExit();
		this.inAttributetoken = false;
	}

	protected boolean inAttributescopedtoken = false;

	@Override
	public void enterAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		onEnter(new Node("Attributescopedtoken", arg.getText(), arg.getStart().getText()));
		this.inAttributescopedtoken = true;
	}

	public void exitAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		onExit();
		this.inAttributescopedtoken = false;
	}

	protected boolean inAttributenamespace = false;

	@Override
	public void enterAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		onEnter(new Node("Attributenamespace", arg.getText(), arg.getStart().getText()));
		this.inAttributenamespace = true;
	}

	public void exitAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		onExit();
		this.inAttributenamespace = false;
	}

	protected boolean inAttributeargumentclause = false;

	@Override
	public void enterAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		onEnter(new Node("Attributeargumentclause", arg.getText(), arg.getStart().getText()));
		this.inAttributeargumentclause = true;
	}

	public void exitAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		onExit();
		this.inAttributeargumentclause = false;
	}

	protected boolean inBalancedtokenseq = false;

	@Override
	public void enterBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		onEnter(new Node("Balancedtokenseq", arg.getText(), arg.getStart().getText()));
		this.inBalancedtokenseq = true;
	}

	public void exitBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		onExit();
		this.inBalancedtokenseq = false;
	}

	protected boolean inBalancedtoken = false;

	@Override
	public void enterBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		onEnter(new Node("Balancedtoken", arg.getText(), arg.getStart().getText()));
		this.inBalancedtoken = true;
	}

	public void exitBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		onExit();
		this.inBalancedtoken = false;
	}

	protected boolean inInitdeclaratorlist = false;

	@Override
	public void enterInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		onEnter(new Node("Initdeclaratorlist", arg.getText(), arg.getStart().getText()));
		this.inInitdeclaratorlist = true;
	}

	public void exitInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		onExit();
		this.inInitdeclaratorlist = false;
	}

	protected boolean inInitdeclarator = false;

	@Override
	public void enterInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		onEnter(new Node("Initdeclarator", arg.getText(), arg.getStart().getText()));
		this.inInitdeclarator = true;
	}

	public void exitInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		onExit();
		this.inInitdeclarator = false;
	}

	protected boolean inDeclarator = false;

	@Override
	public void enterDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		onEnter(new Node("Declarator", arg.getText(), arg.getStart().getText()));
		this.inDeclarator = true;
	}

	public void exitDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		onExit();
		this.inDeclarator = false;
	}

	protected boolean inPtrdeclarator = false;

	@Override
	public void enterPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		onEnter(new Node("Ptrdeclarator", arg.getText(), arg.getStart().getText()));
		this.inPtrdeclarator = true;
	}

	public void exitPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		onExit();
		this.inPtrdeclarator = false;
	}

	protected boolean inNoptrdeclarator = false;

	@Override
	public void enterNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		onEnter(new Node("Noptrdeclarator", arg.getText(), arg.getStart().getText()));
		this.inNoptrdeclarator = true;
	}

	public void exitNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		onExit();
		this.inNoptrdeclarator = false;
	}

	protected boolean inParametersandqualifiers = false;

	@Override
	public void enterParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		onEnter(new Node("Parametersandqualifiers", arg.getText(), arg.getStart().getText()));
		this.inParametersandqualifiers = true;
	}

	public void exitParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		onExit();
		this.inParametersandqualifiers = false;
	}

	protected boolean inTrailingreturntype = false;

	@Override
	public void enterTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		onEnter(new Node("Trailingreturntype", arg.getText(), arg.getStart().getText()));
		this.inTrailingreturntype = true;
	}

	public void exitTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		onExit();
		this.inTrailingreturntype = false;
	}

	protected boolean inPtroperator = false;

	@Override
	public void enterPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		onEnter(new Node("Ptroperator", arg.getText(), arg.getStart().getText()));
		this.inPtroperator = true;
	}

	public void exitPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		onExit();
		this.inPtroperator = false;
	}

	protected boolean inCvqualifierseq = false;

	@Override
	public void enterCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		onEnter(new Node("Cvqualifierseq", arg.getText(), arg.getStart().getText()));
		this.inCvqualifierseq = true;
	}

	public void exitCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		onExit();
		this.inCvqualifierseq = false;
	}

	protected boolean inCvqualifier = false;

	@Override
	public void enterCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		onEnter(new Node("Cvqualifier", arg.getText(), arg.getStart().getText()));
		this.inCvqualifier = true;
	}

	public void exitCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		onExit();
		this.inCvqualifier = false;
	}

	protected boolean inRefqualifier = false;

	@Override
	public void enterRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		onEnter(new Node("Refqualifier", arg.getText(), arg.getStart().getText()));
		this.inRefqualifier = true;
	}

	public void exitRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		onExit();
		this.inRefqualifier = false;
	}

	protected boolean inDeclaratorid = false;

	@Override
	public void enterDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		onEnter(new Node("Declaratorid", arg.getText(), arg.getStart().getText()));
		this.inDeclaratorid = true;
	}

	public void exitDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		onExit();
		this.inDeclaratorid = false;
	}

	protected boolean inTypeid = false;

	@Override
	public void enterTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		onEnter(new Node("Typeid", arg.getText(), arg.getStart().getText()));
		this.inTypeid = true;
	}

	public void exitTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		onExit();
		this.inTypeid = false;
	}

	protected boolean inAbstractdeclarator = false;

	@Override
	public void enterAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		onEnter(new Node("Abstractdeclarator", arg.getText(), arg.getStart().getText()));
		this.inAbstractdeclarator = true;
	}

	public void exitAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		onExit();
		this.inAbstractdeclarator = false;
	}

	protected boolean inPtrabstractdeclarator = false;

	@Override
	public void enterPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		onEnter(new Node("Ptrabstractdeclarator", arg.getText(), arg.getStart().getText()));
		this.inPtrabstractdeclarator = true;
	}

	public void exitPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		onExit();
		this.inPtrabstractdeclarator = false;
	}

	protected boolean inNoptrabstractdeclarator = false;

	@Override
	public void enterNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		onEnter(new Node("Noptrabstractdeclarator", arg.getText(), arg.getStart().getText()));
		this.inNoptrabstractdeclarator = true;
	}

	public void exitNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		onExit();
		this.inNoptrabstractdeclarator = false;
	}

	protected boolean inAbstractpackdeclarator = false;

	@Override
	public void enterAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		onEnter(new Node("Abstractpackdeclarator", arg.getText(), arg.getStart().getText()));
		this.inAbstractpackdeclarator = true;
	}

	public void exitAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		onExit();
		this.inAbstractpackdeclarator = false;
	}

	protected boolean inNoptrabstractpackdeclarator = false;

	@Override
	public void enterNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		onEnter(new Node("Noptrabstractpackdeclarator", arg.getText(), arg.getStart().getText()));
		this.inNoptrabstractpackdeclarator = true;
	}

	public void exitNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		onExit();
		this.inNoptrabstractpackdeclarator = false;
	}

	protected boolean inParameterdeclarationclause = false;

	@Override
	public void enterParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		onEnter(new Node("Parameterdeclarationclause", arg.getText(), arg.getStart().getText()));
		this.inParameterdeclarationclause = true;
	}

	public void exitParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		onExit();
		this.inParameterdeclarationclause = false;
	}

	protected boolean inParameterdeclarationlist = false;

	@Override
	public void enterParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		onEnter(new Node("Parameterdeclarationlist", arg.getText(), arg.getStart().getText()));
		this.inParameterdeclarationlist = true;
	}

	public void exitParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		onExit();
		this.inParameterdeclarationlist = false;
	}

	protected boolean inParameterdeclaration = false;

	@Override
	public void enterParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		onEnter(new Node("Parameterdeclaration", arg.getText(), arg.getStart().getText()));
		this.inParameterdeclaration = true;
	}

	public void exitParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		onExit();
		this.inParameterdeclaration = false;
	}

	protected boolean inFunctiondefinition = false;

	@Override
	public void enterFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		onEnter(new Node("Functiondefinition", arg.getText(), arg.getStart().getText()));
		this.inFunctiondefinition = true;
	}

	public void exitFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		onExit();
		this.inFunctiondefinition = false;
	}

	protected boolean inFunctionbody = false;

	@Override
	public void enterFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		onEnter(new Node("Functionbody", arg.getText(), arg.getStart().getText()));
		this.inFunctionbody = true;
	}

	public void exitFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		onExit();
		this.inFunctionbody = false;
	}

	protected boolean inInitializer = false;

	@Override
	public void enterInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		onEnter(new Node("Initializer", arg.getText(), arg.getStart().getText()));
		this.inInitializer = true;
	}

	public void exitInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		onExit();
		this.inInitializer = false;
	}

	protected boolean inBraceorequalinitializer = false;

	@Override
	public void enterBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		onEnter(new Node("Braceorequalinitializer", arg.getText(), arg.getStart().getText()));
		this.inBraceorequalinitializer = true;
	}

	public void exitBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		onExit();
		this.inBraceorequalinitializer = false;
	}

	protected boolean inInitializerclause = false;

	@Override
	public void enterInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		onEnter(new Node("Initializerclause", arg.getText(), arg.getStart().getText()));
		this.inInitializerclause = true;
	}

	public void exitInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		onExit();
		this.inInitializerclause = false;
	}

	protected boolean inInitializerlist = false;

	@Override
	public void enterInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		onEnter(new Node("Initializerlist", arg.getText(), arg.getStart().getText()));
		this.inInitializerlist = true;
	}

	public void exitInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		onExit();
		this.inInitializerlist = false;
	}

	protected boolean inBracedinitlist = false;

	@Override
	public void enterBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		onEnter(new Node("Bracedinitlist", arg.getText(), arg.getStart().getText()));
		this.inBracedinitlist = true;
	}

	public void exitBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		onExit();
		this.inBracedinitlist = false;
	}

	protected boolean inClassname = false;

	@Override
	public void enterClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		onEnter(new Node("Classname", arg.getText(), arg.getStart().getText()));
		this.inClassname = true;
	}

	public void exitClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		onExit();
		this.inClassname = false;
	}

	protected boolean inClassspecifier = false;

	@Override
	public void enterClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		onEnter(new Node("Classspecifier", arg.getText(), arg.getStart().getText()));
		this.inClassspecifier = true;
	}

	public void exitClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		onExit();
		this.inClassspecifier = false;
	}

	protected boolean inClasshead = false;

	@Override
	public void enterClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		onEnter(new Node("Classhead", arg.getText(), arg.getStart().getText()));
		this.inClasshead = true;
	}

	public void exitClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		onExit();
		this.inClasshead = false;
	}

	protected boolean inClassheadname = false;

	@Override
	public void enterClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		onEnter(new Node("Classheadname", arg.getText(), arg.getStart().getText()));
		this.inClassheadname = true;
	}

	public void exitClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		onExit();
		this.inClassheadname = false;
	}

	protected boolean inClassvirtspecifier = false;

	@Override
	public void enterClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		onEnter(new Node("Classvirtspecifier", arg.getText(), arg.getStart().getText()));
		this.inClassvirtspecifier = true;
	}

	public void exitClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		onExit();
		this.inClassvirtspecifier = false;
	}

	protected boolean inClasskey = false;

	@Override
	public void enterClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		onEnter(new Node("Classkey", arg.getText(), arg.getStart().getText()));
		this.inClasskey = true;
	}

	public void exitClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		onExit();
		this.inClasskey = false;
	}

	protected boolean inMemberspecification = false;

	@Override
	public void enterMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		onEnter(new Node("Memberspecification", arg.getText(), arg.getStart().getText()));
		this.inMemberspecification = true;
	}

	public void exitMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		onExit();
		this.inMemberspecification = false;
	}

	protected boolean inMemberdeclaration = false;

	@Override
	public void enterMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		onEnter(new Node("Memberdeclaration", arg.getText(), arg.getStart().getText()));
		this.inMemberdeclaration = true;
	}

	public void exitMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		onExit();
		this.inMemberdeclaration = false;
	}

	protected boolean inMemberdeclaratorlist = false;

	@Override
	public void enterMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		onEnter(new Node("Memberdeclaratorlist", arg.getText(), arg.getStart().getText()));
		this.inMemberdeclaratorlist = true;
	}

	public void exitMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		onExit();
		this.inMemberdeclaratorlist = false;
	}

	protected boolean inMemberdeclarator = false;

	@Override
	public void enterMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		onEnter(new Node("Memberdeclarator", arg.getText(), arg.getStart().getText()));
		this.inMemberdeclarator = true;
	}

	public void exitMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		onExit();
		this.inMemberdeclarator = false;
	}

	protected boolean inVirtspecifierseq = false;

	@Override
	public void enterVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		onEnter(new Node("Virtspecifierseq", arg.getText(), arg.getStart().getText()));
		this.inVirtspecifierseq = true;
	}

	public void exitVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		onExit();
		this.inVirtspecifierseq = false;
	}

	protected boolean inVirtspecifier = false;

	@Override
	public void enterVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		onEnter(new Node("Virtspecifier", arg.getText(), arg.getStart().getText()));
		this.inVirtspecifier = true;
	}

	public void exitVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		onExit();
		this.inVirtspecifier = false;
	}

	protected boolean inPurespecifier = false;

	@Override
	public void enterPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		onEnter(new Node("Purespecifier", arg.getText(), arg.getStart().getText()));
		this.inPurespecifier = true;
	}

	public void exitPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		onExit();
		this.inPurespecifier = false;
	}

	protected boolean inBaseclause = false;

	@Override
	public void enterBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		onEnter(new Node("Baseclause", arg.getText(), arg.getStart().getText()));
		this.inBaseclause = true;
	}

	public void exitBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		onExit();
		this.inBaseclause = false;
	}

	protected boolean inBasespecifierlist = false;

	@Override
	public void enterBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		onEnter(new Node("Basespecifierlist", arg.getText(), arg.getStart().getText()));
		this.inBasespecifierlist = true;
	}

	public void exitBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		onExit();
		this.inBasespecifierlist = false;
	}

	protected boolean inBasespecifier = false;

	@Override
	public void enterBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		onEnter(new Node("Basespecifier", arg.getText(), arg.getStart().getText()));
		this.inBasespecifier = true;
	}

	public void exitBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		onExit();
		this.inBasespecifier = false;
	}

	protected boolean inClassordecltype = false;

	@Override
	public void enterClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		onEnter(new Node("Classordecltype", arg.getText(), arg.getStart().getText()));
		this.inClassordecltype = true;
	}

	public void exitClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		onExit();
		this.inClassordecltype = false;
	}

	protected boolean inBasetypespecifier = false;

	@Override
	public void enterBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		onEnter(new Node("Basetypespecifier", arg.getText(), arg.getStart().getText()));
		this.inBasetypespecifier = true;
	}

	public void exitBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		onExit();
		this.inBasetypespecifier = false;
	}

	protected boolean inAccessspecifier = false;

	@Override
	public void enterAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		onEnter(new Node("Accessspecifier", arg.getText(), arg.getStart().getText()));
		this.inAccessspecifier = true;
	}

	public void exitAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		onExit();
		this.inAccessspecifier = false;
	}

	protected boolean inConversionfunctionid = false;

	@Override
	public void enterConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		onEnter(new Node("Conversionfunctionid", arg.getText(), arg.getStart().getText()));
		this.inConversionfunctionid = true;
	}

	public void exitConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		onExit();
		this.inConversionfunctionid = false;
	}

	protected boolean inConversiontypeid = false;

	@Override
	public void enterConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		onEnter(new Node("Conversiontypeid", arg.getText(), arg.getStart().getText()));
		this.inConversiontypeid = true;
	}

	public void exitConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		onExit();
		this.inConversiontypeid = false;
	}

	protected boolean inConversiondeclarator = false;

	@Override
	public void enterConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		onEnter(new Node("Conversiondeclarator", arg.getText(), arg.getStart().getText()));
		this.inConversiondeclarator = true;
	}

	public void exitConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		onExit();
		this.inConversiondeclarator = false;
	}

	protected boolean inCtorinitializer = false;

	@Override
	public void enterCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		onEnter(new Node("Ctorinitializer", arg.getText(), arg.getStart().getText()));
		this.inCtorinitializer = true;
	}

	public void exitCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		onExit();
		this.inCtorinitializer = false;
	}

	protected boolean inMeminitializerlist = false;

	@Override
	public void enterMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		onEnter(new Node("Meminitializerlist", arg.getText(), arg.getStart().getText()));
		this.inMeminitializerlist = true;
	}

	public void exitMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		onExit();
		this.inMeminitializerlist = false;
	}

	protected boolean inMeminitializer = false;

	@Override
	public void enterMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		onEnter(new Node("Meminitializer", arg.getText(), arg.getStart().getText()));
		this.inMeminitializer = true;
	}

	public void exitMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		onExit();
		this.inMeminitializer = false;
	}

	protected boolean inMeminitializerid = false;

	@Override
	public void enterMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		onEnter(new Node("Meminitializerid", arg.getText(), arg.getStart().getText()));
		this.inMeminitializerid = true;
	}

	public void exitMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		onExit();
		this.inMeminitializerid = false;
	}

	protected boolean inOperatorfunctionid = false;

	@Override
	public void enterOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		onEnter(new Node("Operatorfunctionid", arg.getText(), arg.getStart().getText()));
		this.inOperatorfunctionid = true;
	}

	public void exitOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		onExit();
		this.inOperatorfunctionid = false;
	}

	protected boolean inLiteraloperatorid = false;

	@Override
	public void enterLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		onEnter(new Node("Literaloperatorid", arg.getText(), arg.getStart().getText()));
		this.inLiteraloperatorid = true;
	}

	public void exitLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		onExit();
		this.inLiteraloperatorid = false;
	}

	protected boolean inTemplatedeclaration = false;

	@Override
	public void enterTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		onEnter(new Node("Templatedeclaration", arg.getText(), arg.getStart().getText()));
		this.inTemplatedeclaration = true;
	}

	public void exitTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		onExit();
		this.inTemplatedeclaration = false;
	}

	protected boolean inTemplateparameterlist = false;

	@Override
	public void enterTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		onEnter(new Node("Templateparameterlist", arg.getText(), arg.getStart().getText()));
		this.inTemplateparameterlist = true;
	}

	public void exitTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		onExit();
		this.inTemplateparameterlist = false;
	}

	protected boolean inTemplateparameter = false;

	@Override
	public void enterTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		onEnter(new Node("Templateparameter", arg.getText(), arg.getStart().getText()));
		this.inTemplateparameter = true;
	}

	public void exitTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		onExit();
		this.inTemplateparameter = false;
	}

	protected boolean inTypeparameter = false;

	@Override
	public void enterTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		onEnter(new Node("Typeparameter", arg.getText(), arg.getStart().getText()));
		this.inTypeparameter = true;
	}

	public void exitTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		onExit();
		this.inTypeparameter = false;
	}

	protected boolean inSimpletemplateid = false;

	@Override
	public void enterSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		onEnter(new Node("Simpletemplateid", arg.getText(), arg.getStart().getText()));
		this.inSimpletemplateid = true;
	}

	public void exitSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		onExit();
		this.inSimpletemplateid = false;
	}

	protected boolean inTemplateid = false;

	@Override
	public void enterTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		onEnter(new Node("Templateid", arg.getText(), arg.getStart().getText()));
		this.inTemplateid = true;
	}

	public void exitTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		onExit();
		this.inTemplateid = false;
	}

	protected boolean inTemplatename = false;

	@Override
	public void enterTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		onEnter(new Node("Templatename", arg.getText(), arg.getStart().getText()));
		this.inTemplatename = true;
	}

	public void exitTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		onExit();
		this.inTemplatename = false;
	}

	protected boolean inTemplateargumentlist = false;

	@Override
	public void enterTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		onEnter(new Node("Templateargumentlist", arg.getText(), arg.getStart().getText()));
		this.inTemplateargumentlist = true;
	}

	public void exitTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		onExit();
		this.inTemplateargumentlist = false;
	}

	protected boolean inTemplateargument = false;

	@Override
	public void enterTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		onEnter(new Node("Templateargument", arg.getText(), arg.getStart().getText()));
		this.inTemplateargument = true;
	}

	public void exitTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		onExit();
		this.inTemplateargument = false;
	}

	protected boolean inTypenamespecifier = false;

	@Override
	public void enterTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		onEnter(new Node("Typenamespecifier", arg.getText(), arg.getStart().getText()));
		this.inTypenamespecifier = true;
	}

	public void exitTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		onExit();
		this.inTypenamespecifier = false;
	}

	protected boolean inExplicitinstantiation = false;

	@Override
	public void enterExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		onEnter(new Node("Explicitinstantiation", arg.getText(), arg.getStart().getText()));
		this.inExplicitinstantiation = true;
	}

	public void exitExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		onExit();
		this.inExplicitinstantiation = false;
	}

	protected boolean inExplicitspecialization = false;

	@Override
	public void enterExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		onEnter(new Node("Explicitspecialization", arg.getText(), arg.getStart().getText()));
		this.inExplicitspecialization = true;
	}

	public void exitExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		onExit();
		this.inExplicitspecialization = false;
	}

	protected boolean inTryblock = false;

	@Override
	public void enterTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		onEnter(new Node("Tryblock", arg.getText(), arg.getStart().getText()));
		this.inTryblock = true;
	}

	public void exitTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		onExit();
		this.inTryblock = false;
	}

	protected boolean inFunctiontryblock = false;

	@Override
	public void enterFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		onEnter(new Node("Functiontryblock", arg.getText(), arg.getStart().getText()));
		this.inFunctiontryblock = true;
	}

	public void exitFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		onExit();
		this.inFunctiontryblock = false;
	}

	protected boolean inHandlerseq = false;

	@Override
	public void enterHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		onEnter(new Node("Handlerseq", arg.getText(), arg.getStart().getText()));
		this.inHandlerseq = true;
	}

	public void exitHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		onExit();
		this.inHandlerseq = false;
	}

	protected boolean inHandler = false;

	@Override
	public void enterHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		onEnter(new Node("Handler", arg.getText(), arg.getStart().getText()));
		this.inHandler = true;
	}

	public void exitHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		onExit();
		this.inHandler = false;
	}

	protected boolean inExceptiondeclaration = false;

	@Override
	public void enterExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		onEnter(new Node("Exceptiondeclaration", arg.getText(), arg.getStart().getText()));
		this.inExceptiondeclaration = true;
	}

	public void exitExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		onExit();
		this.inExceptiondeclaration = false;
	}

	protected boolean inThrowexpression = false;

	@Override
	public void enterThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		onEnter(new Node("Throwexpression", arg.getText(), arg.getStart().getText()));
		this.inThrowexpression = true;
	}

	public void exitThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		onExit();
		this.inThrowexpression = false;
	}

	protected boolean inExceptionspecification = false;

	@Override
	public void enterExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		onEnter(new Node("Exceptionspecification", arg.getText(), arg.getStart().getText()));
		this.inExceptionspecification = true;
	}

	public void exitExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		onExit();
		this.inExceptionspecification = false;
	}

	protected boolean inDynamicexceptionspecification = false;

	@Override
	public void enterDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		onEnter(new Node("Dynamicexceptionspecification", arg.getText(), arg.getStart().getText()));
		this.inDynamicexceptionspecification = true;
	}

	public void exitDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		onExit();
		this.inDynamicexceptionspecification = false;
	}

	protected boolean inTypeidlist = false;

	@Override
	public void enterTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		onEnter(new Node("Typeidlist", arg.getText(), arg.getStart().getText()));
		this.inTypeidlist = true;
	}

	public void exitTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		onExit();
		this.inTypeidlist = false;
	}

	protected boolean inNoexceptspecification = false;

	@Override
	public void enterNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		onEnter(new Node("Noexceptspecification", arg.getText(), arg.getStart().getText()));
		this.inNoexceptspecification = true;
	}

	public void exitNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		onExit();
		this.inNoexceptspecification = false;
	}

	protected boolean inRightShift = false;

	@Override
	public void enterRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		onEnter(new Node("RightShift", arg.getText(), arg.getStart().getText()));
		this.inRightShift = true;
	}

	public void exitRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		onExit();
		this.inRightShift = false;
	}

	protected boolean inRightShiftAssign = false;

	@Override
	public void enterRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		onEnter(new Node("RightShiftAssign", arg.getText(), arg.getStart().getText()));
		this.inRightShiftAssign = true;
	}

	public void exitRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		onExit();
		this.inRightShiftAssign = false;
	}

	protected boolean inOperator = false;

	@Override
	public void enterOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		onEnter(new Node("Operator", arg.getText(), arg.getStart().getText()));
		this.inOperator = true;
	}

	public void exitOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		onExit();
		this.inOperator = false;
	}

	protected boolean inLiteral = false;

	@Override
	public void enterLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
		this.inLiteral = true;
	}

	public void exitLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		onExit();
		this.inLiteral = false;
	}

	protected boolean inBooleanliteral = false;

	@Override
	public void enterBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		onEnter(new Node("Booleanliteral", arg.getText(), arg.getStart().getText()));
		this.inBooleanliteral = true;
	}

	public void exitBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		onExit();
		this.inBooleanliteral = false;
	}

	protected boolean inPointerliteral = false;

	@Override
	public void enterPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		onEnter(new Node("Pointerliteral", arg.getText(), arg.getStart().getText()));
		this.inPointerliteral = true;
	}

	public void exitPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		onExit();
		this.inPointerliteral = false;
	}

	protected boolean inUserdefinedliteral = false;

	@Override
	public void enterUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		onEnter(new Node("Userdefinedliteral", arg.getText(), arg.getStart().getText()));
		this.inUserdefinedliteral = true;
	}

	public void exitUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		onExit();
		this.inUserdefinedliteral = false;
	}

}