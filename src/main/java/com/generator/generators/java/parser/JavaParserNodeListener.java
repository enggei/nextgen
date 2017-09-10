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

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public JavaParserNodeListener() {
		this(false);
	}

	public JavaParserNodeListener(boolean debug) {
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

	protected boolean inBlock = false;

	@Override
	public void enterBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
		this.inBlock = true;
	}

	public void exitBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		onExit();
		this.inBlock = false;
	}

	protected boolean inLiteral = false;

	@Override
	public void enterLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText()));
		this.inLiteral = true;
	}

	public void exitLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		onExit();
		this.inLiteral = false;
	}

	protected boolean inExpression = false;

	@Override
	public void enterExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		onEnter(new Node("Expression", arg.getText(), arg.getStart().getText()));
		this.inExpression = true;
	}

	public void exitExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		onExit();
		this.inExpression = false;
	}

	protected boolean inStatement = false;

	@Override
	public void enterStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText()));
		this.inStatement = true;
	}

	public void exitStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		onExit();
		this.inStatement = false;
	}

	protected boolean inFormalParameterList = false;

	@Override
	public void enterFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		onEnter(new Node("FormalParameterList", arg.getText(), arg.getStart().getText()));
		this.inFormalParameterList = true;
	}

	public void exitFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		onExit();
		this.inFormalParameterList = false;
	}

	protected boolean inArguments = false;

	@Override
	public void enterArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText()));
		this.inArguments = true;
	}

	public void exitArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		onExit();
		this.inArguments = false;
	}

	protected boolean inCompilationUnit = false;

	@Override
	public void enterCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		onEnter(new Node("CompilationUnit", arg.getText(), arg.getStart().getText()));
		this.inCompilationUnit = true;
	}

	public void exitCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		onExit();
		this.inCompilationUnit = false;
	}

	protected boolean inPackageDeclaration = false;

	@Override
	public void enterPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		onEnter(new Node("PackageDeclaration", arg.getText(), arg.getStart().getText()));
		this.inPackageDeclaration = true;
	}

	public void exitPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		onExit();
		this.inPackageDeclaration = false;
	}

	protected boolean inImportDeclaration = false;

	@Override
	public void enterImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		onEnter(new Node("ImportDeclaration", arg.getText(), arg.getStart().getText()));
		this.inImportDeclaration = true;
	}

	public void exitImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		onExit();
		this.inImportDeclaration = false;
	}

	protected boolean inTypeDeclaration = false;

	@Override
	public void enterTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		onEnter(new Node("TypeDeclaration", arg.getText(), arg.getStart().getText()));
		this.inTypeDeclaration = true;
	}

	public void exitTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		onExit();
		this.inTypeDeclaration = false;
	}

	protected boolean inModifier = false;

	@Override
	public void enterModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		onEnter(new Node("Modifier", arg.getText(), arg.getStart().getText()));
		this.inModifier = true;
	}

	public void exitModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		onExit();
		this.inModifier = false;
	}

	protected boolean inClassOrInterfaceModifier = false;

	@Override
	public void enterClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		onEnter(new Node("ClassOrInterfaceModifier", arg.getText(), arg.getStart().getText()));
		this.inClassOrInterfaceModifier = true;
	}

	public void exitClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		onExit();
		this.inClassOrInterfaceModifier = false;
	}

	protected boolean inVariableModifier = false;

	@Override
	public void enterVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		onEnter(new Node("VariableModifier", arg.getText(), arg.getStart().getText()));
		this.inVariableModifier = true;
	}

	public void exitVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		onExit();
		this.inVariableModifier = false;
	}

	protected boolean inClassDeclaration = false;

	@Override
	public void enterClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		onEnter(new Node("ClassDeclaration", arg.getText(), arg.getStart().getText()));
		this.inClassDeclaration = true;
	}

	public void exitClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		onExit();
		this.inClassDeclaration = false;
	}

	protected boolean inTypeParameters = false;

	@Override
	public void enterTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		onEnter(new Node("TypeParameters", arg.getText(), arg.getStart().getText()));
		this.inTypeParameters = true;
	}

	public void exitTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		onExit();
		this.inTypeParameters = false;
	}

	protected boolean inTypeParameter = false;

	@Override
	public void enterTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		onEnter(new Node("TypeParameter", arg.getText(), arg.getStart().getText()));
		this.inTypeParameter = true;
	}

	public void exitTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		onExit();
		this.inTypeParameter = false;
	}

	protected boolean inTypeBound = false;

	@Override
	public void enterTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		onEnter(new Node("TypeBound", arg.getText(), arg.getStart().getText()));
		this.inTypeBound = true;
	}

	public void exitTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		onExit();
		this.inTypeBound = false;
	}

	protected boolean inEnumDeclaration = false;

	@Override
	public void enterEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		onEnter(new Node("EnumDeclaration", arg.getText(), arg.getStart().getText()));
		this.inEnumDeclaration = true;
	}

	public void exitEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		onExit();
		this.inEnumDeclaration = false;
	}

	protected boolean inEnumConstants = false;

	@Override
	public void enterEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		onEnter(new Node("EnumConstants", arg.getText(), arg.getStart().getText()));
		this.inEnumConstants = true;
	}

	public void exitEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		onExit();
		this.inEnumConstants = false;
	}

	protected boolean inEnumConstant = false;

	@Override
	public void enterEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		onEnter(new Node("EnumConstant", arg.getText(), arg.getStart().getText()));
		this.inEnumConstant = true;
	}

	public void exitEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		onExit();
		this.inEnumConstant = false;
	}

	protected boolean inEnumBodyDeclarations = false;

	@Override
	public void enterEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		onEnter(new Node("EnumBodyDeclarations", arg.getText(), arg.getStart().getText()));
		this.inEnumBodyDeclarations = true;
	}

	public void exitEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		onExit();
		this.inEnumBodyDeclarations = false;
	}

	protected boolean inInterfaceDeclaration = false;

	@Override
	public void enterInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		onEnter(new Node("InterfaceDeclaration", arg.getText(), arg.getStart().getText()));
		this.inInterfaceDeclaration = true;
	}

	public void exitInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		onExit();
		this.inInterfaceDeclaration = false;
	}

	protected boolean inClassBody = false;

	@Override
	public void enterClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		onEnter(new Node("ClassBody", arg.getText(), arg.getStart().getText()));
		this.inClassBody = true;
	}

	public void exitClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		onExit();
		this.inClassBody = false;
	}

	protected boolean inInterfaceBody = false;

	@Override
	public void enterInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		onEnter(new Node("InterfaceBody", arg.getText(), arg.getStart().getText()));
		this.inInterfaceBody = true;
	}

	public void exitInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		onExit();
		this.inInterfaceBody = false;
	}

	protected boolean inClassBodyDeclaration = false;

	@Override
	public void enterClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		onEnter(new Node("ClassBodyDeclaration", arg.getText(), arg.getStart().getText()));
		this.inClassBodyDeclaration = true;
	}

	public void exitClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		onExit();
		this.inClassBodyDeclaration = false;
	}

	protected boolean inMemberDeclaration = false;

	@Override
	public void enterMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		onEnter(new Node("MemberDeclaration", arg.getText(), arg.getStart().getText()));
		this.inMemberDeclaration = true;
	}

	public void exitMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		onExit();
		this.inMemberDeclaration = false;
	}

	protected boolean inMethodDeclaration = false;

	@Override
	public void enterMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		onEnter(new Node("MethodDeclaration", arg.getText(), arg.getStart().getText()));
		this.inMethodDeclaration = true;
	}

	public void exitMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		onExit();
		this.inMethodDeclaration = false;
	}

	protected boolean inMethodBody = false;

	@Override
	public void enterMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		onEnter(new Node("MethodBody", arg.getText(), arg.getStart().getText()));
		this.inMethodBody = true;
	}

	public void exitMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		onExit();
		this.inMethodBody = false;
	}

	protected boolean inTypeTypeOrVoid = false;

	@Override
	public void enterTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		onEnter(new Node("TypeTypeOrVoid", arg.getText(), arg.getStart().getText()));
		this.inTypeTypeOrVoid = true;
	}

	public void exitTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		onExit();
		this.inTypeTypeOrVoid = false;
	}

	protected boolean inGenericMethodDeclaration = false;

	@Override
	public void enterGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		onEnter(new Node("GenericMethodDeclaration", arg.getText(), arg.getStart().getText()));
		this.inGenericMethodDeclaration = true;
	}

	public void exitGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		onExit();
		this.inGenericMethodDeclaration = false;
	}

	protected boolean inGenericConstructorDeclaration = false;

	@Override
	public void enterGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		onEnter(new Node("GenericConstructorDeclaration", arg.getText(), arg.getStart().getText()));
		this.inGenericConstructorDeclaration = true;
	}

	public void exitGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		onExit();
		this.inGenericConstructorDeclaration = false;
	}

	protected boolean inConstructorDeclaration = false;

	@Override
	public void enterConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		onEnter(new Node("ConstructorDeclaration", arg.getText(), arg.getStart().getText()));
		this.inConstructorDeclaration = true;
	}

	public void exitConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		onExit();
		this.inConstructorDeclaration = false;
	}

	protected boolean inFieldDeclaration = false;

	@Override
	public void enterFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		onEnter(new Node("FieldDeclaration", arg.getText(), arg.getStart().getText()));
		this.inFieldDeclaration = true;
	}

	public void exitFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		onExit();
		this.inFieldDeclaration = false;
	}

	protected boolean inInterfaceBodyDeclaration = false;

	@Override
	public void enterInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		onEnter(new Node("InterfaceBodyDeclaration", arg.getText(), arg.getStart().getText()));
		this.inInterfaceBodyDeclaration = true;
	}

	public void exitInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		onExit();
		this.inInterfaceBodyDeclaration = false;
	}

	protected boolean inInterfaceMemberDeclaration = false;

	@Override
	public void enterInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		onEnter(new Node("InterfaceMemberDeclaration", arg.getText(), arg.getStart().getText()));
		this.inInterfaceMemberDeclaration = true;
	}

	public void exitInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		onExit();
		this.inInterfaceMemberDeclaration = false;
	}

	protected boolean inConstDeclaration = false;

	@Override
	public void enterConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		onEnter(new Node("ConstDeclaration", arg.getText(), arg.getStart().getText()));
		this.inConstDeclaration = true;
	}

	public void exitConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		onExit();
		this.inConstDeclaration = false;
	}

	protected boolean inConstantDeclarator = false;

	@Override
	public void enterConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		onEnter(new Node("ConstantDeclarator", arg.getText(), arg.getStart().getText()));
		this.inConstantDeclarator = true;
	}

	public void exitConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		onExit();
		this.inConstantDeclarator = false;
	}

	protected boolean inInterfaceMethodDeclaration = false;

	@Override
	public void enterInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		onEnter(new Node("InterfaceMethodDeclaration", arg.getText(), arg.getStart().getText()));
		this.inInterfaceMethodDeclaration = true;
	}

	public void exitInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		onExit();
		this.inInterfaceMethodDeclaration = false;
	}

	protected boolean inInterfaceMethodModifier = false;

	@Override
	public void enterInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		onEnter(new Node("InterfaceMethodModifier", arg.getText(), arg.getStart().getText()));
		this.inInterfaceMethodModifier = true;
	}

	public void exitInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		onExit();
		this.inInterfaceMethodModifier = false;
	}

	protected boolean inGenericInterfaceMethodDeclaration = false;

	@Override
	public void enterGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		onEnter(new Node("GenericInterfaceMethodDeclaration", arg.getText(), arg.getStart().getText()));
		this.inGenericInterfaceMethodDeclaration = true;
	}

	public void exitGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		onExit();
		this.inGenericInterfaceMethodDeclaration = false;
	}

	protected boolean inVariableDeclarators = false;

	@Override
	public void enterVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		onEnter(new Node("VariableDeclarators", arg.getText(), arg.getStart().getText()));
		this.inVariableDeclarators = true;
	}

	public void exitVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		onExit();
		this.inVariableDeclarators = false;
	}

	protected boolean inVariableDeclarator = false;

	@Override
	public void enterVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		onEnter(new Node("VariableDeclarator", arg.getText(), arg.getStart().getText()));
		this.inVariableDeclarator = true;
	}

	public void exitVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		onExit();
		this.inVariableDeclarator = false;
	}

	protected boolean inVariableDeclaratorId = false;

	@Override
	public void enterVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		onEnter(new Node("VariableDeclaratorId", arg.getText(), arg.getStart().getText()));
		this.inVariableDeclaratorId = true;
	}

	public void exitVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		onExit();
		this.inVariableDeclaratorId = false;
	}

	protected boolean inVariableInitializer = false;

	@Override
	public void enterVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		onEnter(new Node("VariableInitializer", arg.getText(), arg.getStart().getText()));
		this.inVariableInitializer = true;
	}

	public void exitVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		onExit();
		this.inVariableInitializer = false;
	}

	protected boolean inArrayInitializer = false;

	@Override
	public void enterArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		onEnter(new Node("ArrayInitializer", arg.getText(), arg.getStart().getText()));
		this.inArrayInitializer = true;
	}

	public void exitArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		onExit();
		this.inArrayInitializer = false;
	}

	protected boolean inClassOrInterfaceType = false;

	@Override
	public void enterClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		onEnter(new Node("ClassOrInterfaceType", arg.getText(), arg.getStart().getText()));
		this.inClassOrInterfaceType = true;
	}

	public void exitClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		onExit();
		this.inClassOrInterfaceType = false;
	}

	protected boolean inTypeArgument = false;

	@Override
	public void enterTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		onEnter(new Node("TypeArgument", arg.getText(), arg.getStart().getText()));
		this.inTypeArgument = true;
	}

	public void exitTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		onExit();
		this.inTypeArgument = false;
	}

	protected boolean inQualifiedNameList = false;

	@Override
	public void enterQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		onEnter(new Node("QualifiedNameList", arg.getText(), arg.getStart().getText()));
		this.inQualifiedNameList = true;
	}

	public void exitQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		onExit();
		this.inQualifiedNameList = false;
	}

	protected boolean inFormalParameters = false;

	@Override
	public void enterFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		onEnter(new Node("FormalParameters", arg.getText(), arg.getStart().getText()));
		this.inFormalParameters = true;
	}

	public void exitFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		onExit();
		this.inFormalParameters = false;
	}

	protected boolean inFormalParameter = false;

	@Override
	public void enterFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		onEnter(new Node("FormalParameter", arg.getText(), arg.getStart().getText()));
		this.inFormalParameter = true;
	}

	public void exitFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		onExit();
		this.inFormalParameter = false;
	}

	protected boolean inLastFormalParameter = false;

	@Override
	public void enterLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		onEnter(new Node("LastFormalParameter", arg.getText(), arg.getStart().getText()));
		this.inLastFormalParameter = true;
	}

	public void exitLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		onExit();
		this.inLastFormalParameter = false;
	}

	protected boolean inQualifiedName = false;

	@Override
	public void enterQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		onEnter(new Node("QualifiedName", arg.getText(), arg.getStart().getText()));
		this.inQualifiedName = true;
	}

	public void exitQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		onExit();
		this.inQualifiedName = false;
	}

	protected boolean inIntegerLiteral = false;

	@Override
	public void enterIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		onEnter(new Node("IntegerLiteral", arg.getText(), arg.getStart().getText()));
		this.inIntegerLiteral = true;
	}

	public void exitIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		onExit();
		this.inIntegerLiteral = false;
	}

	protected boolean inAnnotation = false;

	@Override
	public void enterAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		onEnter(new Node("Annotation", arg.getText(), arg.getStart().getText()));
		this.inAnnotation = true;
	}

	public void exitAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		onExit();
		this.inAnnotation = false;
	}

	protected boolean inElementValuePairs = false;

	@Override
	public void enterElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		onEnter(new Node("ElementValuePairs", arg.getText(), arg.getStart().getText()));
		this.inElementValuePairs = true;
	}

	public void exitElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		onExit();
		this.inElementValuePairs = false;
	}

	protected boolean inElementValuePair = false;

	@Override
	public void enterElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		onEnter(new Node("ElementValuePair", arg.getText(), arg.getStart().getText()));
		this.inElementValuePair = true;
	}

	public void exitElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		onExit();
		this.inElementValuePair = false;
	}

	protected boolean inElementValue = false;

	@Override
	public void enterElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		onEnter(new Node("ElementValue", arg.getText(), arg.getStart().getText()));
		this.inElementValue = true;
	}

	public void exitElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		onExit();
		this.inElementValue = false;
	}

	protected boolean inElementValueArrayInitializer = false;

	@Override
	public void enterElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		onEnter(new Node("ElementValueArrayInitializer", arg.getText(), arg.getStart().getText()));
		this.inElementValueArrayInitializer = true;
	}

	public void exitElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		onExit();
		this.inElementValueArrayInitializer = false;
	}

	protected boolean inAnnotationTypeDeclaration = false;

	@Override
	public void enterAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		onEnter(new Node("AnnotationTypeDeclaration", arg.getText(), arg.getStart().getText()));
		this.inAnnotationTypeDeclaration = true;
	}

	public void exitAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		onExit();
		this.inAnnotationTypeDeclaration = false;
	}

	protected boolean inAnnotationTypeBody = false;

	@Override
	public void enterAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		onEnter(new Node("AnnotationTypeBody", arg.getText(), arg.getStart().getText()));
		this.inAnnotationTypeBody = true;
	}

	public void exitAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		onExit();
		this.inAnnotationTypeBody = false;
	}

	protected boolean inAnnotationTypeElementDeclaration = false;

	@Override
	public void enterAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		onEnter(new Node("AnnotationTypeElementDeclaration", arg.getText(), arg.getStart().getText()));
		this.inAnnotationTypeElementDeclaration = true;
	}

	public void exitAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		onExit();
		this.inAnnotationTypeElementDeclaration = false;
	}

	protected boolean inAnnotationTypeElementRest = false;

	@Override
	public void enterAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		onEnter(new Node("AnnotationTypeElementRest", arg.getText(), arg.getStart().getText()));
		this.inAnnotationTypeElementRest = true;
	}

	public void exitAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		onExit();
		this.inAnnotationTypeElementRest = false;
	}

	protected boolean inAnnotationMethodOrConstantRest = false;

	@Override
	public void enterAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		onEnter(new Node("AnnotationMethodOrConstantRest", arg.getText(), arg.getStart().getText()));
		this.inAnnotationMethodOrConstantRest = true;
	}

	public void exitAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		onExit();
		this.inAnnotationMethodOrConstantRest = false;
	}

	protected boolean inAnnotationMethodRest = false;

	@Override
	public void enterAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		onEnter(new Node("AnnotationMethodRest", arg.getText(), arg.getStart().getText()));
		this.inAnnotationMethodRest = true;
	}

	public void exitAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		onExit();
		this.inAnnotationMethodRest = false;
	}

	protected boolean inAnnotationConstantRest = false;

	@Override
	public void enterAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		onEnter(new Node("AnnotationConstantRest", arg.getText(), arg.getStart().getText()));
		this.inAnnotationConstantRest = true;
	}

	public void exitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		onExit();
		this.inAnnotationConstantRest = false;
	}

	protected boolean inDefaultValue = false;

	@Override
	public void enterDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText()));
		this.inDefaultValue = true;
	}

	public void exitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue = false;
	}

	protected boolean inBlockStatement = false;

	@Override
	public void enterBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		onEnter(new Node("BlockStatement", arg.getText(), arg.getStart().getText()));
		this.inBlockStatement = true;
	}

	public void exitBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		onExit();
		this.inBlockStatement = false;
	}

	protected boolean inLocalVariableDeclaration = false;

	@Override
	public void enterLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		onEnter(new Node("LocalVariableDeclaration", arg.getText(), arg.getStart().getText()));
		this.inLocalVariableDeclaration = true;
	}

	public void exitLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		onExit();
		this.inLocalVariableDeclaration = false;
	}

	protected boolean inCatchClause = false;

	@Override
	public void enterCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		onEnter(new Node("CatchClause", arg.getText(), arg.getStart().getText()));
		this.inCatchClause = true;
	}

	public void exitCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		onExit();
		this.inCatchClause = false;
	}

	protected boolean inCatchType = false;

	@Override
	public void enterCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		onEnter(new Node("CatchType", arg.getText(), arg.getStart().getText()));
		this.inCatchType = true;
	}

	public void exitCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		onExit();
		this.inCatchType = false;
	}

	protected boolean inFinallyBlock = false;

	@Override
	public void enterFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		onEnter(new Node("FinallyBlock", arg.getText(), arg.getStart().getText()));
		this.inFinallyBlock = true;
	}

	public void exitFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		onExit();
		this.inFinallyBlock = false;
	}

	protected boolean inResourceSpecification = false;

	@Override
	public void enterResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		onEnter(new Node("ResourceSpecification", arg.getText(), arg.getStart().getText()));
		this.inResourceSpecification = true;
	}

	public void exitResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		onExit();
		this.inResourceSpecification = false;
	}

	protected boolean inResources = false;

	@Override
	public void enterResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		onEnter(new Node("Resources", arg.getText(), arg.getStart().getText()));
		this.inResources = true;
	}

	public void exitResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		onExit();
		this.inResources = false;
	}

	protected boolean inResource = false;

	@Override
	public void enterResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		onEnter(new Node("Resource", arg.getText(), arg.getStart().getText()));
		this.inResource = true;
	}

	public void exitResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		onExit();
		this.inResource = false;
	}

	protected boolean inSwitchBlockStatementGroup = false;

	@Override
	public void enterSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		onEnter(new Node("SwitchBlockStatementGroup", arg.getText(), arg.getStart().getText()));
		this.inSwitchBlockStatementGroup = true;
	}

	public void exitSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		onExit();
		this.inSwitchBlockStatementGroup = false;
	}

	protected boolean inSwitchLabel = false;

	@Override
	public void enterSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		onEnter(new Node("SwitchLabel", arg.getText(), arg.getStart().getText()));
		this.inSwitchLabel = true;
	}

	public void exitSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		onExit();
		this.inSwitchLabel = false;
	}

	protected boolean inForControl = false;

	@Override
	public void enterForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		onEnter(new Node("ForControl", arg.getText(), arg.getStart().getText()));
		this.inForControl = true;
	}

	public void exitForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		onExit();
		this.inForControl = false;
	}

	protected boolean inForInit = false;

	@Override
	public void enterForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		onEnter(new Node("ForInit", arg.getText(), arg.getStart().getText()));
		this.inForInit = true;
	}

	public void exitForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		onExit();
		this.inForInit = false;
	}

	protected boolean inEnhancedForControl = false;

	@Override
	public void enterEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		onEnter(new Node("EnhancedForControl", arg.getText(), arg.getStart().getText()));
		this.inEnhancedForControl = true;
	}

	public void exitEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		onExit();
		this.inEnhancedForControl = false;
	}

	protected boolean inParExpression = false;

	@Override
	public void enterParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		onEnter(new Node("ParExpression", arg.getText(), arg.getStart().getText()));
		this.inParExpression = true;
	}

	public void exitParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		onExit();
		this.inParExpression = false;
	}

	protected boolean inExpressionList = false;

	@Override
	public void enterExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		onEnter(new Node("ExpressionList", arg.getText(), arg.getStart().getText()));
		this.inExpressionList = true;
	}

	public void exitExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		onExit();
		this.inExpressionList = false;
	}

	protected boolean inLambdaExpression = false;

	@Override
	public void enterLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		onEnter(new Node("LambdaExpression", arg.getText(), arg.getStart().getText()));
		this.inLambdaExpression = true;
	}

	public void exitLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		onExit();
		this.inLambdaExpression = false;
	}

	protected boolean inLambdaParameters = false;

	@Override
	public void enterLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		onEnter(new Node("LambdaParameters", arg.getText(), arg.getStart().getText()));
		this.inLambdaParameters = true;
	}

	public void exitLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		onExit();
		this.inLambdaParameters = false;
	}

	protected boolean inLambdaBody = false;

	@Override
	public void enterLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		onEnter(new Node("LambdaBody", arg.getText(), arg.getStart().getText()));
		this.inLambdaBody = true;
	}

	public void exitLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		onExit();
		this.inLambdaBody = false;
	}

	protected boolean inPrimary = false;

	@Override
	public void enterPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		onEnter(new Node("Primary", arg.getText(), arg.getStart().getText()));
		this.inPrimary = true;
	}

	public void exitPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		onExit();
		this.inPrimary = false;
	}

	protected boolean inMethodReference = false;

	@Override
	public void enterMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		onEnter(new Node("MethodReference", arg.getText(), arg.getStart().getText()));
		this.inMethodReference = true;
	}

	public void exitMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		onExit();
		this.inMethodReference = false;
	}

	protected boolean inClassType = false;

	@Override
	public void enterClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		onEnter(new Node("ClassType", arg.getText(), arg.getStart().getText()));
		this.inClassType = true;
	}

	public void exitClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		onExit();
		this.inClassType = false;
	}

	protected boolean inCreator = false;

	@Override
	public void enterCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		onEnter(new Node("Creator", arg.getText(), arg.getStart().getText()));
		this.inCreator = true;
	}

	public void exitCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		onExit();
		this.inCreator = false;
	}

	protected boolean inCreatedName = false;

	@Override
	public void enterCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		onEnter(new Node("CreatedName", arg.getText(), arg.getStart().getText()));
		this.inCreatedName = true;
	}

	public void exitCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		onExit();
		this.inCreatedName = false;
	}

	protected boolean inInnerCreator = false;

	@Override
	public void enterInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		onEnter(new Node("InnerCreator", arg.getText(), arg.getStart().getText()));
		this.inInnerCreator = true;
	}

	public void exitInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		onExit();
		this.inInnerCreator = false;
	}

	protected boolean inArrayCreatorRest = false;

	@Override
	public void enterArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		onEnter(new Node("ArrayCreatorRest", arg.getText(), arg.getStart().getText()));
		this.inArrayCreatorRest = true;
	}

	public void exitArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		onExit();
		this.inArrayCreatorRest = false;
	}

	protected boolean inClassCreatorRest = false;

	@Override
	public void enterClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		onEnter(new Node("ClassCreatorRest", arg.getText(), arg.getStart().getText()));
		this.inClassCreatorRest = true;
	}

	public void exitClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		onExit();
		this.inClassCreatorRest = false;
	}

	protected boolean inExplicitGenericInvocation = false;

	@Override
	public void enterExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		onEnter(new Node("ExplicitGenericInvocation", arg.getText(), arg.getStart().getText()));
		this.inExplicitGenericInvocation = true;
	}

	public void exitExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		onExit();
		this.inExplicitGenericInvocation = false;
	}

	protected boolean inTypeArgumentsOrDiamond = false;

	@Override
	public void enterTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		onEnter(new Node("TypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText()));
		this.inTypeArgumentsOrDiamond = true;
	}

	public void exitTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		onExit();
		this.inTypeArgumentsOrDiamond = false;
	}

	protected boolean inNonWildcardTypeArgumentsOrDiamond = false;

	@Override
	public void enterNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		onEnter(new Node("NonWildcardTypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText()));
		this.inNonWildcardTypeArgumentsOrDiamond = true;
	}

	public void exitNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		onExit();
		this.inNonWildcardTypeArgumentsOrDiamond = false;
	}

	protected boolean inNonWildcardTypeArguments = false;

	@Override
	public void enterNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		onEnter(new Node("NonWildcardTypeArguments", arg.getText(), arg.getStart().getText()));
		this.inNonWildcardTypeArguments = true;
	}

	public void exitNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		onExit();
		this.inNonWildcardTypeArguments = false;
	}

	protected boolean inTypeList = false;

	@Override
	public void enterTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		onEnter(new Node("TypeList", arg.getText(), arg.getStart().getText()));
		this.inTypeList = true;
	}

	public void exitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		onExit();
		this.inTypeList = false;
	}

	protected boolean inTypeType = false;

	@Override
	public void enterTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		onEnter(new Node("TypeType", arg.getText(), arg.getStart().getText()));
		this.inTypeType = true;
	}

	public void exitTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		onExit();
		this.inTypeType = false;
	}

	protected boolean inPrimitiveType = false;

	@Override
	public void enterPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		onEnter(new Node("PrimitiveType", arg.getText(), arg.getStart().getText()));
		this.inPrimitiveType = true;
	}

	public void exitPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		onExit();
		this.inPrimitiveType = false;
	}

	protected boolean inTypeArguments = false;

	@Override
	public void enterTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		onEnter(new Node("TypeArguments", arg.getText(), arg.getStart().getText()));
		this.inTypeArguments = true;
	}

	public void exitTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		onExit();
		this.inTypeArguments = false;
	}

	protected boolean inSuperSuffix = false;

	@Override
	public void enterSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		onEnter(new Node("SuperSuffix", arg.getText(), arg.getStart().getText()));
		this.inSuperSuffix = true;
	}

	public void exitSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		onExit();
		this.inSuperSuffix = false;
	}

	protected boolean inExplicitGenericInvocationSuffix = false;

	@Override
	public void enterExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		onEnter(new Node("ExplicitGenericInvocationSuffix", arg.getText(), arg.getStart().getText()));
		this.inExplicitGenericInvocationSuffix = true;
	}

	public void exitExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		onExit();
		this.inExplicitGenericInvocationSuffix = false;
	}

}