package com.generator.generators.java.parser;

public class JavaBaseListener extends JavaParserBaseListener {

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
	public void enterBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		 //System.out.println("Block");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		 onExit();
	}

	@Override
	public void enterCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		 //System.out.println("CompilationUnit");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CompilationUnit", arg.getText(), arg.getStart().getText()));
	}

	public void exitCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		 onExit();
	}

	@Override
	public void enterPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		 //System.out.println("PackageDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PackageDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		 //System.out.println("ImportDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ImportDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		 //System.out.println("TypeDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		 //System.out.println("Modifier");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Modifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		 //System.out.println("ClassOrInterfaceModifier");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ClassOrInterfaceModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		 //System.out.println("VariableModifier");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		 //System.out.println("ClassDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ClassDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		 //System.out.println("TypeParameters");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeParameters", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		 //System.out.println("TypeParameter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeParameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		 //System.out.println("TypeBound");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeBound", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		 //System.out.println("EnumDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EnumDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		 //System.out.println("EnumConstants");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EnumConstants", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		 //System.out.println("EnumConstant");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EnumConstant", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		 //System.out.println("EnumBodyDeclarations");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EnumBodyDeclarations", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		 //System.out.println("InterfaceDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InterfaceDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		 //System.out.println("ClassBody");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ClassBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		 //System.out.println("InterfaceBody");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InterfaceBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		 //System.out.println("ClassBodyDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ClassBodyDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		 //System.out.println("MemberDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MemberDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		 //System.out.println("MethodDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		 //System.out.println("MethodBody");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MethodBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		 //System.out.println("TypeTypeOrVoid");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeTypeOrVoid", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		 onExit();
	}

	@Override
	public void enterGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		 //System.out.println("GenericMethodDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("GenericMethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		 //System.out.println("GenericConstructorDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("GenericConstructorDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		 //System.out.println("ConstructorDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ConstructorDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		 //System.out.println("FieldDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FieldDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		 //System.out.println("InterfaceBodyDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InterfaceBodyDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		 //System.out.println("InterfaceMemberDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InterfaceMemberDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		 //System.out.println("ConstDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ConstDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		 //System.out.println("ConstantDeclarator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ConstantDeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		 //System.out.println("InterfaceMethodDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InterfaceMethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		 //System.out.println("InterfaceMethodModifier");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InterfaceMethodModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		 //System.out.println("GenericInterfaceMethodDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("GenericInterfaceMethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		 //System.out.println("VariableDeclarators");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableDeclarators", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		 //System.out.println("VariableDeclarator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableDeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		 //System.out.println("VariableDeclaratorId");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableDeclaratorId", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		 //System.out.println("VariableInitializer");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("VariableInitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		 //System.out.println("ArrayInitializer");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArrayInitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		 //System.out.println("ClassOrInterfaceType");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ClassOrInterfaceType", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		 //System.out.println("TypeArgument");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeArgument", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		 onExit();
	}

	@Override
	public void enterQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		 //System.out.println("QualifiedNameList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("QualifiedNameList", arg.getText(), arg.getStart().getText()));
	}

	public void exitQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		 //System.out.println("FormalParameters");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FormalParameters", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		 //System.out.println("FormalParameterList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FormalParameterList", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		 //System.out.println("FormalParameter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FormalParameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		 onExit();
	}

	@Override
	public void enterLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		 //System.out.println("LastFormalParameter");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LastFormalParameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		 onExit();
	}

	@Override
	public void enterQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		 //System.out.println("QualifiedName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("QualifiedName", arg.getText(), arg.getStart().getText()));
	}

	public void exitQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		 onExit();
	}

	@Override
	public void enterLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		 //System.out.println("Literal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		 //System.out.println("IntegerLiteral");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IntegerLiteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		 //System.out.println("Annotation");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Annotation", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		 //System.out.println("ElementValuePairs");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ElementValuePairs", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		 //System.out.println("ElementValuePair");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ElementValuePair", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		 //System.out.println("ElementValue");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ElementValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		 //System.out.println("ElementValueArrayInitializer");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ElementValueArrayInitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		 //System.out.println("AnnotationTypeDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AnnotationTypeDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		 //System.out.println("AnnotationTypeBody");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AnnotationTypeBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		 //System.out.println("AnnotationTypeElementDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AnnotationTypeElementDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		 //System.out.println("AnnotationTypeElementRest");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AnnotationTypeElementRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		 //System.out.println("AnnotationMethodOrConstantRest");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AnnotationMethodOrConstantRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		 //System.out.println("AnnotationMethodRest");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AnnotationMethodRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		 //System.out.println("AnnotationConstantRest");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AnnotationConstantRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		 onExit();
	}

	@Override
	public void enterDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		 //System.out.println("DefaultValue");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		 onExit();
	}

	@Override
	public void enterBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		 //System.out.println("BlockStatement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BlockStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		 //System.out.println("LocalVariableDeclaration");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LocalVariableDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		 //System.out.println("Statement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		 onExit();
	}

	@Override
	public void enterCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		 //System.out.println("CatchClause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CatchClause", arg.getText(), arg.getStart().getText()));
	}

	public void exitCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		 onExit();
	}

	@Override
	public void enterCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		 //System.out.println("CatchType");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CatchType", arg.getText(), arg.getStart().getText()));
	}

	public void exitCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		 //System.out.println("FinallyBlock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FinallyBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		 //System.out.println("ResourceSpecification");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ResourceSpecification", arg.getText(), arg.getStart().getText()));
	}

	public void exitResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		 onExit();
	}

	@Override
	public void enterResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		 //System.out.println("Resources");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Resources", arg.getText(), arg.getStart().getText()));
	}

	public void exitResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		 onExit();
	}

	@Override
	public void enterResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		 //System.out.println("Resource");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Resource", arg.getText(), arg.getStart().getText()));
	}

	public void exitResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		 onExit();
	}

	@Override
	public void enterSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		 //System.out.println("SwitchBlockStatementGroup");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SwitchBlockStatementGroup", arg.getText(), arg.getStart().getText()));
	}

	public void exitSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		 onExit();
	}

	@Override
	public void enterSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		 //System.out.println("SwitchLabel");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SwitchLabel", arg.getText(), arg.getStart().getText()));
	}

	public void exitSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		 onExit();
	}

	@Override
	public void enterForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		 //System.out.println("ForControl");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ForControl", arg.getText(), arg.getStart().getText()));
	}

	public void exitForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		 onExit();
	}

	@Override
	public void enterForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		 //System.out.println("ForInit");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ForInit", arg.getText(), arg.getStart().getText()));
	}

	public void exitForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		 onExit();
	}

	@Override
	public void enterEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		 //System.out.println("EnhancedForControl");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EnhancedForControl", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		 onExit();
	}

	@Override
	public void enterParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		 //System.out.println("ParExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ParExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		 //System.out.println("ExpressionList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExpressionList", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		 onExit();
	}

	@Override
	public void enterExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		 //System.out.println("Expression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Expression", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		 //System.out.println("LambdaExpression");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LambdaExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		 //System.out.println("LambdaParameters");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LambdaParameters", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		 //System.out.println("LambdaBody");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LambdaBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		 //System.out.println("Primary");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Primary", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		 onExit();
	}

	@Override
	public void enterMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		 //System.out.println("MethodReference");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MethodReference", arg.getText(), arg.getStart().getText()));
	}

	public void exitMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		 onExit();
	}

	@Override
	public void enterClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		 //System.out.println("ClassType");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ClassType", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		 //System.out.println("Creator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Creator", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		 onExit();
	}

	@Override
	public void enterCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		 //System.out.println("CreatedName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CreatedName", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		 onExit();
	}

	@Override
	public void enterInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		 //System.out.println("InnerCreator");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("InnerCreator", arg.getText(), arg.getStart().getText()));
	}

	public void exitInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		 onExit();
	}

	@Override
	public void enterArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		 //System.out.println("ArrayCreatorRest");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArrayCreatorRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		 onExit();
	}

	@Override
	public void enterClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		 //System.out.println("ClassCreatorRest");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ClassCreatorRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		 onExit();
	}

	@Override
	public void enterExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		 //System.out.println("ExplicitGenericInvocation");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExplicitGenericInvocation", arg.getText(), arg.getStart().getText()));
	}

	public void exitExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		 //System.out.println("TypeArgumentsOrDiamond");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		 onExit();
	}

	@Override
	public void enterNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		 //System.out.println("NonWildcardTypeArgumentsOrDiamond");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NonWildcardTypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText()));
	}

	public void exitNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		 onExit();
	}

	@Override
	public void enterNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		 //System.out.println("NonWildcardTypeArguments");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NonWildcardTypeArguments", arg.getText(), arg.getStart().getText()));
	}

	public void exitNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		 //System.out.println("TypeList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeList", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		 //System.out.println("TypeType");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeType", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		 //System.out.println("PrimitiveType");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PrimitiveType", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		 //System.out.println("TypeArguments");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TypeArguments", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		 onExit();
	}

	@Override
	public void enterSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		 //System.out.println("SuperSuffix");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SuperSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		 onExit();
	}

	@Override
	public void enterExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		 //System.out.println("ExplicitGenericInvocationSuffix");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExplicitGenericInvocationSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		 onExit();
	}

	@Override
	public void enterArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		 //System.out.println("Arguments");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText()));
	}

	public void exitArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		 onExit();
	}

}