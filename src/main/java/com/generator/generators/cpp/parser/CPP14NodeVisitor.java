package com.generator.generators.cpp.parser;

public class CPP14NodeVisitor extends CPP14BaseVisitor<CPP14NodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		System.out.println("Namespacename");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		System.out.println("Originalnamespacename");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		System.out.println("Namespacedefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		System.out.println("Namednamespacedefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		System.out.println("Originalnamespacedefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		System.out.println("Extensionnamespacedefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		System.out.println("Unnamednamespacedefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		System.out.println("Namespacebody");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		System.out.println("Namespacealias");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		System.out.println("Namespacealiasdefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		System.out.println("Qualifiednamespacespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		System.out.println("Usingdeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		System.out.println("Usingdirective");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		System.out.println("Asmdefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		System.out.println("Linkagespecification");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		System.out.println("Attributespecifierseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		System.out.println("Attributespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		System.out.println("Alignmentspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		System.out.println("Attributelist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		System.out.println("Attribute");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		System.out.println("Attributetoken");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		System.out.println("Attributescopedtoken");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		System.out.println("Attributenamespace");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		System.out.println("Attributeargumentclause");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		System.out.println("Balancedtokenseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		System.out.println("Balancedtoken");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		System.out.println("Initdeclaratorlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		System.out.println("Initdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		System.out.println("Declarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		System.out.println("Ptrdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		System.out.println("Noptrdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		System.out.println("Parametersandqualifiers");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		System.out.println("Trailingreturntype");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		System.out.println("Ptroperator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		System.out.println("Cvqualifierseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		System.out.println("Cvqualifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		System.out.println("Refqualifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		System.out.println("Declaratorid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		System.out.println("Typeid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		System.out.println("Abstractdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		System.out.println("Ptrabstractdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		System.out.println("Noptrabstractdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		System.out.println("Abstractpackdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		System.out.println("Noptrabstractpackdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		System.out.println("Parameterdeclarationclause");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		System.out.println("Parameterdeclarationlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		System.out.println("Parameterdeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		System.out.println("Functiondefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		System.out.println("Functionbody");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		System.out.println("Initializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		System.out.println("Braceorequalinitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		System.out.println("Initializerclause");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		System.out.println("Initializerlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		System.out.println("Bracedinitlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		System.out.println("Classname");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		System.out.println("Classspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		System.out.println("Classhead");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		System.out.println("Classheadname");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		System.out.println("Classvirtspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		System.out.println("Classkey");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		System.out.println("Memberspecification");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		System.out.println("Memberdeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		System.out.println("Memberdeclaratorlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		System.out.println("Memberdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		System.out.println("Virtspecifierseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		System.out.println("Virtspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		System.out.println("Purespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		System.out.println("Baseclause");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		System.out.println("Basespecifierlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		System.out.println("Basespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		System.out.println("Classordecltype");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		System.out.println("Basetypespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		System.out.println("Accessspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		System.out.println("Conversionfunctionid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		System.out.println("Conversiontypeid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		System.out.println("Conversiondeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		System.out.println("Ctorinitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		System.out.println("Meminitializerlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		System.out.println("Meminitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		System.out.println("Meminitializerid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		System.out.println("Operatorfunctionid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		System.out.println("Literaloperatorid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		System.out.println("Templatedeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		System.out.println("Templateparameterlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		System.out.println("Templateparameter");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		System.out.println("Templateid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		System.out.println("Typeparameter");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		System.out.println("Simpletemplateid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		System.out.println("Templatename");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		System.out.println("Templateargumentlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		System.out.println("Templateargument");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		System.out.println("Typenamespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		System.out.println("Explicitinstantiation");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		System.out.println("Explicitspecialization");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		System.out.println("Tryblock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		System.out.println("Functiontryblock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		System.out.println("Handlerseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		System.out.println("Handler");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		System.out.println("Exceptiondeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		System.out.println("Throwexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		System.out.println("Exceptionspecification");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		System.out.println("Dynamicexceptionspecification");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		System.out.println("Typeidlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		System.out.println("Noexceptspecification");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		System.out.println("RightShift");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		System.out.println("RightShiftAssign");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		System.out.println("Operator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		System.out.println("Booleanliteral");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		System.out.println("Pointerliteral");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		System.out.println("Userdefinedliteral");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		System.out.println("Capturedefault");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		System.out.println("Capturelist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		System.out.println("Capture");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		System.out.println("Simplecapture");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		System.out.println("Initcapture");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		System.out.println("Lambdadeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		System.out.println("Postfixexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		System.out.println("Expressionlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		System.out.println("Pseudodestructorname");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		System.out.println("Unaryexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		System.out.println("Unaryoperator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		System.out.println("Newexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		System.out.println("Newplacement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		System.out.println("Newtypeid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		System.out.println("Newdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		System.out.println("Noptrnewdeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		System.out.println("Newinitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		System.out.println("Deleteexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		System.out.println("Noexceptexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		System.out.println("Translationunit");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		System.out.println("Primaryexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		System.out.println("Idexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		System.out.println("Unqualifiedid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		System.out.println("Qualifiedid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		System.out.println("Nestednamespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		System.out.println("Lambdaexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		System.out.println("Lambdaintroducer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		System.out.println("Lambdacapture");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		System.out.println("Pmexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		System.out.println("Multiplicativeexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		System.out.println("Additiveexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		System.out.println("Shiftexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		System.out.println("Relationalexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		System.out.println("Equalityexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		System.out.println("Andexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		System.out.println("Exclusiveorexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		System.out.println("Inclusiveorexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		System.out.println("Logicalandexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		System.out.println("Logicalorexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		System.out.println("Conditionalexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		System.out.println("Assignmentexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		System.out.println("Assignmentoperator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		System.out.println("Expression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		System.out.println("Constantexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		System.out.println("Statement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		System.out.println("Labeledstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		System.out.println("Expressionstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		System.out.println("Compoundstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		System.out.println("Statementseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		System.out.println("Selectionstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		System.out.println("Condition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		System.out.println("Iterationstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		System.out.println("Forinitstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		System.out.println("Forrangedeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		System.out.println("Forrangeinitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		System.out.println("Jumpstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		System.out.println("Declarationstatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		System.out.println("Declarationseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		System.out.println("Declaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		System.out.println("Blockdeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		System.out.println("Aliasdeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		System.out.println("Simpledeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		System.out.println("Static_assertdeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		System.out.println("Emptydeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		System.out.println("Attributedeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		System.out.println("Declspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		System.out.println("Declspecifierseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		System.out.println("Storageclassspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		System.out.println("Functionspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		System.out.println("Typedefname");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		System.out.println("Typespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		System.out.println("Trailingtypespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		System.out.println("Typespecifierseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		System.out.println("Trailingtypespecifierseq");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		System.out.println("Simpletypespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		System.out.println("Typename");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		System.out.println("Decltypespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		System.out.println("Elaboratedtypespecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		System.out.println("Enumname");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		System.out.println("Enumspecifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		System.out.println("Enumhead");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		System.out.println("Opaqueenumdeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		System.out.println("Enumkey");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		System.out.println("Enumbase");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		System.out.println("Enumeratorlist");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		System.out.println("Enumeratordefinition");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		System.out.println("Enumerator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		System.out.println("Castexpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}