package com.generator.generators.java.parser;

public class JavaParserNodeListener extends JavaParserBaseListener {

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

	public JavaParserNodeListener() {
		this(false);
	}

	public JavaParserNodeListener(boolean debug) {
		this.debug = debug;
	}

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		delim.append("\t");
		if (debug) System.out.println(delim.toString() + node.name);
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
	public void enterBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		 onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		 onExit();
	}

	@Override
	public void enterExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		 onEnter(new Node("Expression", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		 onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
	}

	public void exitStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		 onExit();
	}

	@Override
	public void enterLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		 onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
	}

	public void exitLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		 onEnter(new Node("FormalParameterList", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		 onExit();
	}

	@Override
	public void enterArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		 onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText()));
	}

	public void exitArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		 onExit();
	}

	@Override
	public void enterCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		 onEnter(new Node("CompilationUnit", arg.getText(), arg.getStart().getText()));
	}

	public void exitCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		 onExit();
	}

	@Override
	public void enterPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		 onEnter(new Node("PackageDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		 onEnter(new Node("ImportDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		 onEnter(new Node("TypeDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		 onEnter(new Node("Modifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		 onEnter(new Node("ClassOrInterfaceModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		 onEnter(new Node("VariableModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		 onEnter(new Node("ClassDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		 onEnter(new Node("TypeParameters", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		 onEnter(new Node("TypeParameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		 onEnter(new Node("TypeBound", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		 onEnter(new Node("EnumDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		 onEnter(new Node("EnumConstants", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		 onEnter(new Node("EnumConstant", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		 onEnter(new Node("EnumBodyDeclarations", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		 onEnter(new Node("InterfaceDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		 onEnter(new Node("ClassBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		 onEnter(new Node("InterfaceBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		 onEnter(new Node("ClassBodyDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		 onEnter(new Node("MemberDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		 onEnter(new Node("MethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		 onEnter(new Node("MethodBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		 onEnter(new Node("TypeTypeOrVoid", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		 onExit();
	}

	@Override
	public void enterGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		 onEnter(new Node("GenericMethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		 onEnter(new Node("GenericConstructorDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		 onEnter(new Node("ConstructorDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		 onEnter(new Node("FieldDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		 onEnter(new Node("InterfaceBodyDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		 onEnter(new Node("InterfaceMemberDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		 onEnter(new Node("ConstDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		 onEnter(new Node("ConstantDeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		 onEnter(new Node("InterfaceMethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		 onEnter(new Node("InterfaceMethodModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		 onEnter(new Node("GenericInterfaceMethodDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		 onEnter(new Node("VariableDeclarators", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		 onEnter(new Node("VariableDeclarator", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		 onEnter(new Node("VariableDeclaratorId", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		 onExit();
	}

	@Override
	public void enterVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		 onEnter(new Node("VariableInitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		 onEnter(new Node("ArrayInitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		 onEnter(new Node("ClassOrInterfaceType", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		 onEnter(new Node("TypeArgument", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		 onExit();
	}

	@Override
	public void enterQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		 onEnter(new Node("QualifiedNameList", arg.getText(), arg.getStart().getText()));
	}

	public void exitQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		 onEnter(new Node("FormalParameters", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		 onEnter(new Node("FormalParameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		 onExit();
	}

	@Override
	public void enterLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		 onEnter(new Node("LastFormalParameter", arg.getText(), arg.getStart().getText()));
	}

	public void exitLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		 onExit();
	}

	@Override
	public void enterQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		 onEnter(new Node("QualifiedName", arg.getText(), arg.getStart().getText()));
	}

	public void exitQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		 onExit();
	}

	@Override
	public void enterIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		 onEnter(new Node("IntegerLiteral", arg.getText(), arg.getStart().getText()));
	}

	public void exitIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		 onEnter(new Node("Annotation", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		 onEnter(new Node("ElementValuePairs", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		 onEnter(new Node("ElementValuePair", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		 onEnter(new Node("ElementValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		 onExit();
	}

	@Override
	public void enterElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		 onEnter(new Node("ElementValueArrayInitializer", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		 onEnter(new Node("AnnotationTypeDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		 onEnter(new Node("AnnotationTypeBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		 onEnter(new Node("AnnotationTypeElementDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		 onEnter(new Node("AnnotationTypeElementRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		 onEnter(new Node("AnnotationMethodOrConstantRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		 onEnter(new Node("AnnotationMethodRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		 onExit();
	}

	@Override
	public void enterAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		 onEnter(new Node("AnnotationConstantRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		 onExit();
	}

	@Override
	public void enterDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		 onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		 onExit();
	}

	@Override
	public void enterBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		 onEnter(new Node("BlockStatement", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		 onExit();
	}

	@Override
	public void enterLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		 onEnter(new Node("LocalVariableDeclaration", arg.getText(), arg.getStart().getText()));
	}

	public void exitLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		 onExit();
	}

	@Override
	public void enterCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		 onEnter(new Node("CatchClause", arg.getText(), arg.getStart().getText()));
	}

	public void exitCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		 onExit();
	}

	@Override
	public void enterCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		 onEnter(new Node("CatchType", arg.getText(), arg.getStart().getText()));
	}

	public void exitCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		 onEnter(new Node("FinallyBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		 onEnter(new Node("ResourceSpecification", arg.getText(), arg.getStart().getText()));
	}

	public void exitResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		 onExit();
	}

	@Override
	public void enterResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		 onEnter(new Node("Resources", arg.getText(), arg.getStart().getText()));
	}

	public void exitResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		 onExit();
	}

	@Override
	public void enterResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		 onEnter(new Node("Resource", arg.getText(), arg.getStart().getText()));
	}

	public void exitResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		 onExit();
	}

	@Override
	public void enterSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		 onEnter(new Node("SwitchBlockStatementGroup", arg.getText(), arg.getStart().getText()));
	}

	public void exitSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		 onExit();
	}

	@Override
	public void enterSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		 onEnter(new Node("SwitchLabel", arg.getText(), arg.getStart().getText()));
	}

	public void exitSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		 onExit();
	}

	@Override
	public void enterForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		 onEnter(new Node("ForControl", arg.getText(), arg.getStart().getText()));
	}

	public void exitForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		 onExit();
	}

	@Override
	public void enterForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		 onEnter(new Node("ForInit", arg.getText(), arg.getStart().getText()));
	}

	public void exitForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		 onExit();
	}

	@Override
	public void enterEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		 onEnter(new Node("EnhancedForControl", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		 onExit();
	}

	@Override
	public void enterParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		 onEnter(new Node("ParExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		 onEnter(new Node("ExpressionList", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		 onEnter(new Node("LambdaExpression", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		 onEnter(new Node("LambdaParameters", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		 onExit();
	}

	@Override
	public void enterLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		 onEnter(new Node("LambdaBody", arg.getText(), arg.getStart().getText()));
	}

	public void exitLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		 onExit();
	}

	@Override
	public void enterPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		 onEnter(new Node("Primary", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		 onExit();
	}

	@Override
	public void enterMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		 onEnter(new Node("MethodReference", arg.getText(), arg.getStart().getText()));
	}

	public void exitMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		 onExit();
	}

	@Override
	public void enterClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		 onEnter(new Node("ClassType", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		 onEnter(new Node("Creator", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		 onExit();
	}

	@Override
	public void enterCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		 onEnter(new Node("CreatedName", arg.getText(), arg.getStart().getText()));
	}

	public void exitCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		 onExit();
	}

	@Override
	public void enterInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		 onEnter(new Node("InnerCreator", arg.getText(), arg.getStart().getText()));
	}

	public void exitInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		 onExit();
	}

	@Override
	public void enterArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		 onEnter(new Node("ArrayCreatorRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		 onExit();
	}

	@Override
	public void enterClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		 onEnter(new Node("ClassCreatorRest", arg.getText(), arg.getStart().getText()));
	}

	public void exitClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		 onExit();
	}

	@Override
	public void enterExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		 onEnter(new Node("ExplicitGenericInvocation", arg.getText(), arg.getStart().getText()));
	}

	public void exitExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		 onEnter(new Node("TypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		 onExit();
	}

	@Override
	public void enterNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		 onEnter(new Node("NonWildcardTypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText()));
	}

	public void exitNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		 onExit();
	}

	@Override
	public void enterNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		 onEnter(new Node("NonWildcardTypeArguments", arg.getText(), arg.getStart().getText()));
	}

	public void exitNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		 onEnter(new Node("TypeList", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		 onEnter(new Node("TypeType", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		 onEnter(new Node("PrimitiveType", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		 onEnter(new Node("TypeArguments", arg.getText(), arg.getStart().getText()));
	}

	public void exitTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		 onExit();
	}

	@Override
	public void enterSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		 onEnter(new Node("SuperSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		 onExit();
	}

	@Override
	public void enterExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		 onEnter(new Node("ExplicitGenericInvocationSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		 onExit();
	}

}