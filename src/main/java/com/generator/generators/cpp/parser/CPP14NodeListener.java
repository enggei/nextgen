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

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public CPP14NodeListener() {
		this(false);
	}

	public CPP14NodeListener(boolean debug) {
		this.debug = debug;
	}

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
		delim.append("\t");
   }

   void onExit() {
      if (nodeStack.size() > 1) {
			nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
		}
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		 onEnter(new Node("Lambdaexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		 onEnter(new Node("Lambdaintroducer", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		 onEnter(new Node("Lambdacapture", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		 onExit();
	}

	@Override
	public void enterCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		 onEnter(new Node("Capturedefault", arg.getText(), arg.getStart().getText()));
	}

	public void exitCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		 onExit();
	}

	@Override
	public void enterCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		 onEnter(new Node("Capturelist", arg.getText(), arg.getStart().getText()));
	}

	public void exitCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		 onExit();
	}

	@Override
	public void enterCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		 onEnter(new Node("Capture", arg.getText(), arg.getStart().getText()));
	}

	public void exitCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		 onExit();
	}

	@Override
	public void enterSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		 onEnter(new Node("Simplecapture", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		 onExit();
	}

	@Override
	public void enterInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		 onEnter(new Node("Initcapture", arg.getText(), arg.getStart().getText()));
	}

	public void exitInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		 onEnter(new Node("Lambdadeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		 onEnter(new Node("Postfixexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		 onEnter(new Node("Translationunit", arg.getText(), arg.getStart().getText()));
	}

	public void exitTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		 onExit();
	}

	@Override
	public void enterPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		 onEnter(new Node("Primaryexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		 onEnter(new Node("Idexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		 onEnter(new Node("Unqualifiedid", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		 onEnter(new Node("Enumname", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		 onEnter(new Node("Enumspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		 onEnter(new Node("Enumhead", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		 onExit();
	}

	@Override
	public void enterOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		 onEnter(new Node("Opaqueenumdeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		 onEnter(new Node("Enumkey", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		 onEnter(new Node("Enumbase", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		 onEnter(new Node("Enumeratorlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		 onEnter(new Node("Enumeratordefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		 onEnter(new Node("Enumerator", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		 onExit();
	}

	@Override
	public void enterNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		 onEnter(new Node("Namespacename", arg.getText(), arg.getStart().getText()));
	}

	public void exitNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		 onExit();
	}

	@Override
	public void enterOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		 onEnter(new Node("Originalnamespacename", arg.getText(), arg.getStart().getText()));
	}

	public void exitOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		 onExit();
	}

	@Override
	public void enterNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		 onEnter(new Node("Namespacedefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		 onEnter(new Node("Namednamespacedefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		 onEnter(new Node("Originalnamespacedefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		 onEnter(new Node("Extensionnamespacedefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		 onEnter(new Node("Unnamednamespacedefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		 onEnter(new Node("Namespacebody", arg.getText(), arg.getStart().getText()));
	}

	public void exitNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		 onExit();
	}

	@Override
	public void enterNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		 onEnter(new Node("Namespacealias", arg.getText(), arg.getStart().getText()));
	}

	public void exitNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		 onExit();
	}

	@Override
	public void enterNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		 onEnter(new Node("Namespacealiasdefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		 onEnter(new Node("Qualifiednamespacespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		 onEnter(new Node("Usingdeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		 onEnter(new Node("Usingdirective", arg.getText(), arg.getStart().getText()));
	}

	public void exitUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		 onExit();
	}

	@Override
	public void enterAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		 onEnter(new Node("Asmdefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		 onEnter(new Node("Linkagespecification", arg.getText(), arg.getStart().getText()));
	}

	public void exitLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		 onEnter(new Node("Attributespecifierseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		 onEnter(new Node("Attributespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		 onEnter(new Node("Alignmentspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		 onEnter(new Node("Attributelist", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		 onExit();
	}

	@Override
	public void enterAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		 onEnter(new Node("Attribute", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		 onEnter(new Node("Attributetoken", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		 onEnter(new Node("Attributescopedtoken", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		 onEnter(new Node("Attributenamespace", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		 onEnter(new Node("Attributeargumentclause", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		 onExit();
	}

	@Override
	public void enterBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		 onEnter(new Node("Balancedtokenseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		 onExit();
	}

	@Override
	public void enterBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		 onEnter(new Node("Balancedtoken", arg.getText(), arg.getStart().getText()));
	}

	public void exitBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		 onExit();
	}

	@Override
	public void enterInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		 onEnter(new Node("Initdeclaratorlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		 onExit();
	}

	@Override
	public void enterInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		 onEnter(new Node("Initdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		 onEnter(new Node("Declarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		 onEnter(new Node("Ptrdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		 onEnter(new Node("Noptrdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		 onEnter(new Node("Parametersandqualifiers", arg.getText(), arg.getStart().getText()));
	}

	public void exitParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		 onExit();
	}

	@Override
	public void enterTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		 onEnter(new Node("Trailingreturntype", arg.getText(), arg.getStart().getText()));
	}

	public void exitTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		 onExit();
	}

	@Override
	public void enterPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		 onEnter(new Node("Ptroperator", arg.getText(), arg.getStart().getText()));
	}

	public void exitPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		 onExit();
	}

	@Override
	public void enterCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		 onEnter(new Node("Cvqualifierseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		 onExit();
	}

	@Override
	public void enterCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		 onEnter(new Node("Cvqualifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		 onExit();
	}

	@Override
	public void enterRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		 onEnter(new Node("Refqualifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		 onEnter(new Node("Declaratorid", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		 onEnter(new Node("Typeid", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		 onExit();
	}

	@Override
	public void enterAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		 onEnter(new Node("Abstractdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		 onEnter(new Node("Ptrabstractdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		 onEnter(new Node("Noptrabstractdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		 onEnter(new Node("Abstractpackdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		 onEnter(new Node("Noptrabstractpackdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		 onEnter(new Node("Parameterdeclarationclause", arg.getText(), arg.getStart().getText()));
	}

	public void exitParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		 onExit();
	}

	@Override
	public void enterParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		 onEnter(new Node("Parameterdeclarationlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		 onExit();
	}

	@Override
	public void enterParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		 onEnter(new Node("Parameterdeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		 onEnter(new Node("Functiondefinition", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		 onEnter(new Node("Functionbody", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		 onExit();
	}

	@Override
	public void enterInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		 onEnter(new Node("Initializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		 onEnter(new Node("Braceorequalinitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		 onEnter(new Node("Initializerclause", arg.getText(), arg.getStart().getText()));
	}

	public void exitInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		 onExit();
	}

	@Override
	public void enterInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		 onEnter(new Node("Initializerlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		 onExit();
	}

	@Override
	public void enterBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		 onEnter(new Node("Bracedinitlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		 onExit();
	}

	@Override
	public void enterClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		 onEnter(new Node("Classname", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		 onExit();
	}

	@Override
	public void enterClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		 onEnter(new Node("Classspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		 onEnter(new Node("Classhead", arg.getText(), arg.getStart().getText()));
	}

	public void exitClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		 onExit();
	}

	@Override
	public void enterClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		 onEnter(new Node("Classheadname", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		 onExit();
	}

	@Override
	public void enterClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		 onEnter(new Node("Classvirtspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		 onEnter(new Node("Classkey", arg.getText(), arg.getStart().getText()));
	}

	public void exitClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		 onEnter(new Node("Memberspecification", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		 onEnter(new Node("Memberdeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		 onEnter(new Node("Memberdeclaratorlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		 onEnter(new Node("Memberdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		 onEnter(new Node("Virtspecifierseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		 onExit();
	}

	@Override
	public void enterVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		 onEnter(new Node("Virtspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		 onEnter(new Node("Purespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		 onEnter(new Node("Baseclause", arg.getText(), arg.getStart().getText()));
	}

	public void exitBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		 onExit();
	}

	@Override
	public void enterBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		 onEnter(new Node("Basespecifierlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		 onExit();
	}

	@Override
	public void enterBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		 onEnter(new Node("Basespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		 onEnter(new Node("Classordecltype", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		 onExit();
	}

	@Override
	public void enterBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		 onEnter(new Node("Basetypespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		 onEnter(new Node("Accessspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		 onEnter(new Node("Conversionfunctionid", arg.getText(), arg.getStart().getText()));
	}

	public void exitConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		 onExit();
	}

	@Override
	public void enterConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		 onEnter(new Node("Conversiontypeid", arg.getText(), arg.getStart().getText()));
	}

	public void exitConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		 onExit();
	}

	@Override
	public void enterConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		 onEnter(new Node("Conversiondeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		 onEnter(new Node("Ctorinitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		 onEnter(new Node("Meminitializerlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		 onExit();
	}

	@Override
	public void enterMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		 onEnter(new Node("Meminitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		 onEnter(new Node("Meminitializerid", arg.getText(), arg.getStart().getText()));
	}

	public void exitMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		 onExit();
	}

	@Override
	public void enterOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		 onEnter(new Node("Operatorfunctionid", arg.getText(), arg.getStart().getText()));
	}

	public void exitOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		 onExit();
	}

	@Override
	public void enterLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		 onEnter(new Node("Literaloperatorid", arg.getText(), arg.getStart().getText()));
	}

	public void exitLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		 onEnter(new Node("Templatedeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		 onEnter(new Node("Templateparameterlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		 onEnter(new Node("Templateparameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		 onEnter(new Node("Typeparameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		 onExit();
	}

	@Override
	public void enterSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		 onEnter(new Node("Simpletemplateid", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		 onEnter(new Node("Templateid", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		 onEnter(new Node("Templatename", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		 onEnter(new Node("Templateargumentlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		 onEnter(new Node("Templateargument", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		 onExit();
	}

	@Override
	public void enterTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		 onEnter(new Node("Typenamespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		 onEnter(new Node("Explicitinstantiation", arg.getText(), arg.getStart().getText()));
	}

	public void exitExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		 onExit();
	}

	@Override
	public void enterExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		 onEnter(new Node("Explicitspecialization", arg.getText(), arg.getStart().getText()));
	}

	public void exitExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		 onExit();
	}

	@Override
	public void enterTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		 onEnter(new Node("Tryblock", arg.getText(), arg.getStart().getText()));
	}

	public void exitTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		 onEnter(new Node("Functiontryblock", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		 onExit();
	}

	@Override
	public void enterHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		 onEnter(new Node("Handlerseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		 onExit();
	}

	@Override
	public void enterHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		 onEnter(new Node("Handler", arg.getText(), arg.getStart().getText()));
	}

	public void exitHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		 onExit();
	}

	@Override
	public void enterExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		 onEnter(new Node("Exceptiondeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		 onEnter(new Node("Throwexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		 onEnter(new Node("Exceptionspecification", arg.getText(), arg.getStart().getText()));
	}

	public void exitExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		 onExit();
	}

	@Override
	public void enterDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		 onEnter(new Node("Dynamicexceptionspecification", arg.getText(), arg.getStart().getText()));
	}

	public void exitDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		 onEnter(new Node("Typeidlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		 onExit();
	}

	@Override
	public void enterNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		 onEnter(new Node("Noexceptspecification", arg.getText(), arg.getStart().getText()));
	}

	public void exitNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		 onExit();
	}

	@Override
	public void enterRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		 onEnter(new Node("RightShift", arg.getText(), arg.getStart().getText()));
	}

	public void exitRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		 onExit();
	}

	@Override
	public void enterRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		 onEnter(new Node("RightShiftAssign", arg.getText(), arg.getStart().getText()));
	}

	public void exitRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		 onExit();
	}

	@Override
	public void enterOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		 onEnter(new Node("Operator", arg.getText(), arg.getStart().getText()));
	}

	public void exitOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		 onExit();
	}

	@Override
	public void enterLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		 onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		 onEnter(new Node("Booleanliteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		 onExit();
	}

	@Override
	public void enterPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		 onEnter(new Node("Pointerliteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		 onExit();
	}

	@Override
	public void enterUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		 onEnter(new Node("Userdefinedliteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		 onExit();
	}

	@Override
	public void enterQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		 onEnter(new Node("Qualifiedid", arg.getText(), arg.getStart().getText()));
	}

	public void exitQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		 onExit();
	}

	@Override
	public void enterNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		 onEnter(new Node("Nestednamespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		 onEnter(new Node("Expressionlist", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		 onExit();
	}

	@Override
	public void enterPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		 onEnter(new Node("Pseudodestructorname", arg.getText(), arg.getStart().getText()));
	}

	public void exitPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		 onExit();
	}

	@Override
	public void enterUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		 onEnter(new Node("Unaryexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		 onEnter(new Node("Unaryoperator", arg.getText(), arg.getStart().getText()));
	}

	public void exitUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		 onExit();
	}

	@Override
	public void enterNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		 onEnter(new Node("Newexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		 onEnter(new Node("Newplacement", arg.getText(), arg.getStart().getText()));
	}

	public void exitNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		 onExit();
	}

	@Override
	public void enterNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		 onEnter(new Node("Newtypeid", arg.getText(), arg.getStart().getText()));
	}

	public void exitNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		 onExit();
	}

	@Override
	public void enterNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		 onEnter(new Node("Newdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		 onEnter(new Node("Noptrnewdeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		 onEnter(new Node("Newinitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		 onEnter(new Node("Deleteexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		 onEnter(new Node("Noexceptexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		 onEnter(new Node("Castexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		 onEnter(new Node("Pmexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		 onEnter(new Node("Multiplicativeexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		 onEnter(new Node("Additiveexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		 onEnter(new Node("Shiftexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		 onEnter(new Node("Relationalexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		 onEnter(new Node("Equalityexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		 onEnter(new Node("Andexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		 onEnter(new Node("Exclusiveorexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		 onEnter(new Node("Inclusiveorexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		 onEnter(new Node("Logicalandexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		 onEnter(new Node("Logicalorexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		 onEnter(new Node("Conditionalexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		 onEnter(new Node("Assignmentexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		 onEnter(new Node("Assignmentoperator", arg.getText(), arg.getStart().getText()));
	}

	public void exitAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		 onExit();
	}

	@Override
	public void enterExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		 onEnter(new Node("Expression", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		 onEnter(new Node("Constantexpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		 onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		 onExit();
	}

	@Override
	public void enterLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		 onEnter(new Node("Labeledstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		 onEnter(new Node("Expressionstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		 onEnter(new Node("Compoundstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		 onEnter(new Node("Statementseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		 onExit();
	}

	@Override
	public void enterSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		 onEnter(new Node("Selectionstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		 onEnter(new Node("Condition", arg.getText(), arg.getStart().getText()));
	}

	public void exitCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		 onExit();
	}

	@Override
	public void enterIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		 onEnter(new Node("Iterationstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		 onEnter(new Node("Forinitstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		 onEnter(new Node("Forrangedeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		 onEnter(new Node("Forrangeinitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		 onEnter(new Node("Jumpstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		 onEnter(new Node("Declarationstatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		 onEnter(new Node("Declarationseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		 onEnter(new Node("Declaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		 onEnter(new Node("Blockdeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		 onEnter(new Node("Aliasdeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		 onEnter(new Node("Simpledeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		 onEnter(new Node("Static_assertdeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		 onEnter(new Node("Emptydeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		 onEnter(new Node("Attributedeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		 onEnter(new Node("Declspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		 onEnter(new Node("Declspecifierseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		 onExit();
	}

	@Override
	public void enterStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		 onEnter(new Node("Storageclassspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		 onEnter(new Node("Functionspecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		 onEnter(new Node("Typedefname", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		 onExit();
	}

	@Override
	public void enterTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		 onEnter(new Node("Typespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		 onEnter(new Node("Trailingtypespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		 onEnter(new Node("Typespecifierseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		 onExit();
	}

	@Override
	public void enterTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		 onEnter(new Node("Trailingtypespecifierseq", arg.getText(), arg.getStart().getText()));
	}

	public void exitTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		 onExit();
	}

	@Override
	public void enterSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		 onEnter(new Node("Simpletypespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		 onEnter(new Node("Typename", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		 onExit();
	}

	@Override
	public void enterDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		 onEnter(new Node("Decltypespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		 onExit();
	}

	@Override
	public void enterElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		 onEnter(new Node("Elaboratedtypespecifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		 onExit();
	}

}