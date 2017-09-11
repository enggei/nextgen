package com.generator.generators.java.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class JavaParserNeoListener extends JavaParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public JavaParserNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public JavaParserNeoListener(com.generator.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
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

	protected boolean inBlock = false;

	@Override
	public void enterBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText());
		onEnter(node);
		this.inBlock = true;
	}

	public void exitBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		onExit();
		this.inBlock = false;
	}

	protected boolean inStatement = false;

	@Override
	public void enterStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText());
		onEnter(node);
		this.inStatement = true;
	}

	public void exitStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		onExit();
		this.inStatement = false;
	}

	protected boolean inLiteral = false;

	@Override
	public void enterLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText());
		onEnter(node);
		this.inLiteral = true;
	}

	public void exitLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		onExit();
		this.inLiteral = false;
	}

	protected boolean inExpression = false;

	@Override
	public void enterExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText());
		onEnter(node);
		this.inExpression = true;
	}

	public void exitExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		onExit();
		this.inExpression = false;
	}

	protected boolean inFormalParameterList = false;

	@Override
	public void enterFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		final Node node = model.findOrCreate(Label.label("FormalParameterList"), "text", arg.getText());
		onEnter(node);
		this.inFormalParameterList = true;
	}

	public void exitFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		onExit();
		this.inFormalParameterList = false;
	}

	protected boolean inArguments = false;

	@Override
	public void enterArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("Arguments"), "text", arg.getText());
		onEnter(node);
		this.inArguments = true;
	}

	public void exitArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		onExit();
		this.inArguments = false;
	}

	protected boolean inCompilationUnit = false;

	@Override
	public void enterCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		final Node node = model.findOrCreate(Label.label("CompilationUnit"), "text", arg.getText());
		onEnter(node);
		this.inCompilationUnit = true;
	}

	public void exitCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		onExit();
		this.inCompilationUnit = false;
	}

	protected boolean inPackageDeclaration = false;

	@Override
	public void enterPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inPackageDeclaration = true;
	}

	public void exitPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		onExit();
		this.inPackageDeclaration = false;
	}

	protected boolean inImportDeclaration = false;

	@Override
	public void enterImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inImportDeclaration = true;
	}

	public void exitImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		onExit();
		this.inImportDeclaration = false;
	}

	protected boolean inTypeDeclaration = false;

	@Override
	public void enterTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inTypeDeclaration = true;
	}

	public void exitTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		onExit();
		this.inTypeDeclaration = false;
	}

	protected boolean inModifier = false;

	@Override
	public void enterModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Modifier"), "text", arg.getText());
		onEnter(node);
		this.inModifier = true;
	}

	public void exitModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		onExit();
		this.inModifier = false;
	}

	protected boolean inClassOrInterfaceModifier = false;

	@Override
	public void enterClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassOrInterfaceModifier"), "text", arg.getText());
		onEnter(node);
		this.inClassOrInterfaceModifier = true;
	}

	public void exitClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		onExit();
		this.inClassOrInterfaceModifier = false;
	}

	protected boolean inVariableModifier = false;

	@Override
	public void enterVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableModifier"), "text", arg.getText());
		onEnter(node);
		this.inVariableModifier = true;
	}

	public void exitVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		onExit();
		this.inVariableModifier = false;
	}

	protected boolean inClassDeclaration = false;

	@Override
	public void enterClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inClassDeclaration = true;
	}

	public void exitClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		onExit();
		this.inClassDeclaration = false;
	}

	protected boolean inTypeParameters = false;

	@Override
	public void enterTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeParameters"), "text", arg.getText());
		onEnter(node);
		this.inTypeParameters = true;
	}

	public void exitTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		onExit();
		this.inTypeParameters = false;
	}

	protected boolean inTypeParameter = false;

	@Override
	public void enterTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeParameter"), "text", arg.getText());
		onEnter(node);
		this.inTypeParameter = true;
	}

	public void exitTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		onExit();
		this.inTypeParameter = false;
	}

	protected boolean inTypeBound = false;

	@Override
	public void enterTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeBound"), "text", arg.getText());
		onEnter(node);
		this.inTypeBound = true;
	}

	public void exitTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		onExit();
		this.inTypeBound = false;
	}

	protected boolean inEnumDeclaration = false;

	@Override
	public void enterEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inEnumDeclaration = true;
	}

	public void exitEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		onExit();
		this.inEnumDeclaration = false;
	}

	protected boolean inEnumConstants = false;

	@Override
	public void enterEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumConstants"), "text", arg.getText());
		onEnter(node);
		this.inEnumConstants = true;
	}

	public void exitEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		onExit();
		this.inEnumConstants = false;
	}

	protected boolean inEnumConstant = false;

	@Override
	public void enterEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumConstant"), "text", arg.getText());
		onEnter(node);
		this.inEnumConstant = true;
	}

	public void exitEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		onExit();
		this.inEnumConstant = false;
	}

	protected boolean inEnumBodyDeclarations = false;

	@Override
	public void enterEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumBodyDeclarations"), "text", arg.getText());
		onEnter(node);
		this.inEnumBodyDeclarations = true;
	}

	public void exitEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		onExit();
		this.inEnumBodyDeclarations = false;
	}

	protected boolean inInterfaceDeclaration = false;

	@Override
	public void enterInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inInterfaceDeclaration = true;
	}

	public void exitInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		onExit();
		this.inInterfaceDeclaration = false;
	}

	protected boolean inClassBody = false;

	@Override
	public void enterClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassBody"), "text", arg.getText());
		onEnter(node);
		this.inClassBody = true;
	}

	public void exitClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		onExit();
		this.inClassBody = false;
	}

	protected boolean inInterfaceBody = false;

	@Override
	public void enterInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceBody"), "text", arg.getText());
		onEnter(node);
		this.inInterfaceBody = true;
	}

	public void exitInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		onExit();
		this.inInterfaceBody = false;
	}

	protected boolean inClassBodyDeclaration = false;

	@Override
	public void enterClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassBodyDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inClassBodyDeclaration = true;
	}

	public void exitClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		onExit();
		this.inClassBodyDeclaration = false;
	}

	protected boolean inMemberDeclaration = false;

	@Override
	public void enterMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("MemberDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inMemberDeclaration = true;
	}

	public void exitMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		onExit();
		this.inMemberDeclaration = false;
	}

	protected boolean inMethodDeclaration = false;

	@Override
	public void enterMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inMethodDeclaration = true;
	}

	public void exitMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		onExit();
		this.inMethodDeclaration = false;
	}

	protected boolean inMethodBody = false;

	@Override
	public void enterMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodBody"), "text", arg.getText());
		onEnter(node);
		this.inMethodBody = true;
	}

	public void exitMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		onExit();
		this.inMethodBody = false;
	}

	protected boolean inTypeTypeOrVoid = false;

	@Override
	public void enterTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeTypeOrVoid"), "text", arg.getText());
		onEnter(node);
		this.inTypeTypeOrVoid = true;
	}

	public void exitTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		onExit();
		this.inTypeTypeOrVoid = false;
	}

	protected boolean inGenericMethodDeclaration = false;

	@Override
	public void enterGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("GenericMethodDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inGenericMethodDeclaration = true;
	}

	public void exitGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		onExit();
		this.inGenericMethodDeclaration = false;
	}

	protected boolean inGenericConstructorDeclaration = false;

	@Override
	public void enterGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("GenericConstructorDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inGenericConstructorDeclaration = true;
	}

	public void exitGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		onExit();
		this.inGenericConstructorDeclaration = false;
	}

	protected boolean inConstructorDeclaration = false;

	@Override
	public void enterConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstructorDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inConstructorDeclaration = true;
	}

	public void exitConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		onExit();
		this.inConstructorDeclaration = false;
	}

	protected boolean inFieldDeclaration = false;

	@Override
	public void enterFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("FieldDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inFieldDeclaration = true;
	}

	public void exitFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		onExit();
		this.inFieldDeclaration = false;
	}

	protected boolean inInterfaceBodyDeclaration = false;

	@Override
	public void enterInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceBodyDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inInterfaceBodyDeclaration = true;
	}

	public void exitInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		onExit();
		this.inInterfaceBodyDeclaration = false;
	}

	protected boolean inInterfaceMemberDeclaration = false;

	@Override
	public void enterInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceMemberDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inInterfaceMemberDeclaration = true;
	}

	public void exitInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		onExit();
		this.inInterfaceMemberDeclaration = false;
	}

	protected boolean inConstDeclaration = false;

	@Override
	public void enterConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inConstDeclaration = true;
	}

	public void exitConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		onExit();
		this.inConstDeclaration = false;
	}

	protected boolean inConstantDeclarator = false;

	@Override
	public void enterConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstantDeclarator"), "text", arg.getText());
		onEnter(node);
		this.inConstantDeclarator = true;
	}

	public void exitConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		onExit();
		this.inConstantDeclarator = false;
	}

	protected boolean inInterfaceMethodDeclaration = false;

	@Override
	public void enterInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceMethodDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inInterfaceMethodDeclaration = true;
	}

	public void exitInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		onExit();
		this.inInterfaceMethodDeclaration = false;
	}

	protected boolean inInterfaceMethodModifier = false;

	@Override
	public void enterInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceMethodModifier"), "text", arg.getText());
		onEnter(node);
		this.inInterfaceMethodModifier = true;
	}

	public void exitInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		onExit();
		this.inInterfaceMethodModifier = false;
	}

	protected boolean inGenericInterfaceMethodDeclaration = false;

	@Override
	public void enterGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("GenericInterfaceMethodDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inGenericInterfaceMethodDeclaration = true;
	}

	public void exitGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		onExit();
		this.inGenericInterfaceMethodDeclaration = false;
	}

	protected boolean inVariableDeclarators = false;

	@Override
	public void enterVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclarators"), "text", arg.getText());
		onEnter(node);
		this.inVariableDeclarators = true;
	}

	public void exitVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		onExit();
		this.inVariableDeclarators = false;
	}

	protected boolean inVariableDeclarator = false;

	@Override
	public void enterVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclarator"), "text", arg.getText());
		onEnter(node);
		this.inVariableDeclarator = true;
	}

	public void exitVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		onExit();
		this.inVariableDeclarator = false;
	}

	protected boolean inVariableDeclaratorId = false;

	@Override
	public void enterVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclaratorId"), "text", arg.getText());
		onEnter(node);
		this.inVariableDeclaratorId = true;
	}

	public void exitVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		onExit();
		this.inVariableDeclaratorId = false;
	}

	protected boolean inVariableInitializer = false;

	@Override
	public void enterVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableInitializer"), "text", arg.getText());
		onEnter(node);
		this.inVariableInitializer = true;
	}

	public void exitVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		onExit();
		this.inVariableInitializer = false;
	}

	protected boolean inArrayInitializer = false;

	@Override
	public void enterArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayInitializer"), "text", arg.getText());
		onEnter(node);
		this.inArrayInitializer = true;
	}

	public void exitArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		onExit();
		this.inArrayInitializer = false;
	}

	protected boolean inClassOrInterfaceType = false;

	@Override
	public void enterClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassOrInterfaceType"), "text", arg.getText());
		onEnter(node);
		this.inClassOrInterfaceType = true;
	}

	public void exitClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		onExit();
		this.inClassOrInterfaceType = false;
	}

	protected boolean inTypeArgument = false;

	@Override
	public void enterTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeArgument"), "text", arg.getText());
		onEnter(node);
		this.inTypeArgument = true;
	}

	public void exitTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		onExit();
		this.inTypeArgument = false;
	}

	protected boolean inQualifiedNameList = false;

	@Override
	public void enterQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedNameList"), "text", arg.getText());
		onEnter(node);
		this.inQualifiedNameList = true;
	}

	public void exitQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		onExit();
		this.inQualifiedNameList = false;
	}

	protected boolean inFormalParameters = false;

	@Override
	public void enterFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		final Node node = model.findOrCreate(Label.label("FormalParameters"), "text", arg.getText());
		onEnter(node);
		this.inFormalParameters = true;
	}

	public void exitFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		onExit();
		this.inFormalParameters = false;
	}

	protected boolean inFormalParameter = false;

	@Override
	public void enterFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		final Node node = model.findOrCreate(Label.label("FormalParameter"), "text", arg.getText());
		onEnter(node);
		this.inFormalParameter = true;
	}

	public void exitFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		onExit();
		this.inFormalParameter = false;
	}

	protected boolean inLastFormalParameter = false;

	@Override
	public void enterLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		final Node node = model.findOrCreate(Label.label("LastFormalParameter"), "text", arg.getText());
		onEnter(node);
		this.inLastFormalParameter = true;
	}

	public void exitLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		onExit();
		this.inLastFormalParameter = false;
	}

	protected boolean inQualifiedName = false;

	@Override
	public void enterQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedName"), "text", arg.getText());
		onEnter(node);
		this.inQualifiedName = true;
	}

	public void exitQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		onExit();
		this.inQualifiedName = false;
	}

	protected boolean inIntegerLiteral = false;

	@Override
	public void enterIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("IntegerLiteral"), "text", arg.getText());
		onEnter(node);
		this.inIntegerLiteral = true;
	}

	public void exitIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		onExit();
		this.inIntegerLiteral = false;
	}

	protected boolean inAnnotation = false;

	@Override
	public void enterAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		final Node node = model.findOrCreate(Label.label("Annotation"), "text", arg.getText());
		onEnter(node);
		this.inAnnotation = true;
	}

	public void exitAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		onExit();
		this.inAnnotation = false;
	}

	protected boolean inElementValuePairs = false;

	@Override
	public void enterElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValuePairs"), "text", arg.getText());
		onEnter(node);
		this.inElementValuePairs = true;
	}

	public void exitElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		onExit();
		this.inElementValuePairs = false;
	}

	protected boolean inElementValuePair = false;

	@Override
	public void enterElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValuePair"), "text", arg.getText());
		onEnter(node);
		this.inElementValuePair = true;
	}

	public void exitElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		onExit();
		this.inElementValuePair = false;
	}

	protected boolean inElementValue = false;

	@Override
	public void enterElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValue"), "text", arg.getText());
		onEnter(node);
		this.inElementValue = true;
	}

	public void exitElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		onExit();
		this.inElementValue = false;
	}

	protected boolean inElementValueArrayInitializer = false;

	@Override
	public void enterElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValueArrayInitializer"), "text", arg.getText());
		onEnter(node);
		this.inElementValueArrayInitializer = true;
	}

	public void exitElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		onExit();
		this.inElementValueArrayInitializer = false;
	}

	protected boolean inAnnotationTypeDeclaration = false;

	@Override
	public void enterAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inAnnotationTypeDeclaration = true;
	}

	public void exitAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		onExit();
		this.inAnnotationTypeDeclaration = false;
	}

	protected boolean inAnnotationTypeBody = false;

	@Override
	public void enterAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeBody"), "text", arg.getText());
		onEnter(node);
		this.inAnnotationTypeBody = true;
	}

	public void exitAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		onExit();
		this.inAnnotationTypeBody = false;
	}

	protected boolean inAnnotationTypeElementDeclaration = false;

	@Override
	public void enterAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeElementDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inAnnotationTypeElementDeclaration = true;
	}

	public void exitAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		onExit();
		this.inAnnotationTypeElementDeclaration = false;
	}

	protected boolean inAnnotationTypeElementRest = false;

	@Override
	public void enterAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeElementRest"), "text", arg.getText());
		onEnter(node);
		this.inAnnotationTypeElementRest = true;
	}

	public void exitAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		onExit();
		this.inAnnotationTypeElementRest = false;
	}

	protected boolean inAnnotationMethodOrConstantRest = false;

	@Override
	public void enterAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationMethodOrConstantRest"), "text", arg.getText());
		onEnter(node);
		this.inAnnotationMethodOrConstantRest = true;
	}

	public void exitAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		onExit();
		this.inAnnotationMethodOrConstantRest = false;
	}

	protected boolean inAnnotationMethodRest = false;

	@Override
	public void enterAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationMethodRest"), "text", arg.getText());
		onEnter(node);
		this.inAnnotationMethodRest = true;
	}

	public void exitAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		onExit();
		this.inAnnotationMethodRest = false;
	}

	protected boolean inAnnotationConstantRest = false;

	@Override
	public void enterAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationConstantRest"), "text", arg.getText());
		onEnter(node);
		this.inAnnotationConstantRest = true;
	}

	public void exitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		onExit();
		this.inAnnotationConstantRest = false;
	}

	protected boolean inDefaultValue = false;

	@Override
	public void enterDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		final Node node = model.findOrCreate(Label.label("DefaultValue"), "text", arg.getText());
		onEnter(node);
		this.inDefaultValue = true;
	}

	public void exitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue = false;
	}

	protected boolean inBlockStatement = false;

	@Override
	public void enterBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("BlockStatement"), "text", arg.getText());
		onEnter(node);
		this.inBlockStatement = true;
	}

	public void exitBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		onExit();
		this.inBlockStatement = false;
	}

	protected boolean inLocalVariableDeclaration = false;

	@Override
	public void enterLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("LocalVariableDeclaration"), "text", arg.getText());
		onEnter(node);
		this.inLocalVariableDeclaration = true;
	}

	public void exitLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		onExit();
		this.inLocalVariableDeclaration = false;
	}

	protected boolean inCatchClause = false;

	@Override
	public void enterCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("CatchClause"), "text", arg.getText());
		onEnter(node);
		this.inCatchClause = true;
	}

	public void exitCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		onExit();
		this.inCatchClause = false;
	}

	protected boolean inCatchType = false;

	@Override
	public void enterCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("CatchType"), "text", arg.getText());
		onEnter(node);
		this.inCatchType = true;
	}

	public void exitCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		onExit();
		this.inCatchType = false;
	}

	protected boolean inFinallyBlock = false;

	@Override
	public void enterFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("FinallyBlock"), "text", arg.getText());
		onEnter(node);
		this.inFinallyBlock = true;
	}

	public void exitFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		onExit();
		this.inFinallyBlock = false;
	}

	protected boolean inResourceSpecification = false;

	@Override
	public void enterResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("ResourceSpecification"), "text", arg.getText());
		onEnter(node);
		this.inResourceSpecification = true;
	}

	public void exitResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		onExit();
		this.inResourceSpecification = false;
	}

	protected boolean inResources = false;

	@Override
	public void enterResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		final Node node = model.findOrCreate(Label.label("Resources"), "text", arg.getText());
		onEnter(node);
		this.inResources = true;
	}

	public void exitResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		onExit();
		this.inResources = false;
	}

	protected boolean inResource = false;

	@Override
	public void enterResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		final Node node = model.findOrCreate(Label.label("Resource"), "text", arg.getText());
		onEnter(node);
		this.inResource = true;
	}

	public void exitResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		onExit();
		this.inResource = false;
	}

	protected boolean inSwitchBlockStatementGroup = false;

	@Override
	public void enterSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		final Node node = model.findOrCreate(Label.label("SwitchBlockStatementGroup"), "text", arg.getText());
		onEnter(node);
		this.inSwitchBlockStatementGroup = true;
	}

	public void exitSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		onExit();
		this.inSwitchBlockStatementGroup = false;
	}

	protected boolean inSwitchLabel = false;

	@Override
	public void enterSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		final Node node = model.findOrCreate(Label.label("SwitchLabel"), "text", arg.getText());
		onEnter(node);
		this.inSwitchLabel = true;
	}

	public void exitSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		onExit();
		this.inSwitchLabel = false;
	}

	protected boolean inForControl = false;

	@Override
	public void enterForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		final Node node = model.findOrCreate(Label.label("ForControl"), "text", arg.getText());
		onEnter(node);
		this.inForControl = true;
	}

	public void exitForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		onExit();
		this.inForControl = false;
	}

	protected boolean inForInit = false;

	@Override
	public void enterForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		final Node node = model.findOrCreate(Label.label("ForInit"), "text", arg.getText());
		onEnter(node);
		this.inForInit = true;
	}

	public void exitForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		onExit();
		this.inForInit = false;
	}

	protected boolean inEnhancedForControl = false;

	@Override
	public void enterEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		final Node node = model.findOrCreate(Label.label("EnhancedForControl"), "text", arg.getText());
		onEnter(node);
		this.inEnhancedForControl = true;
	}

	public void exitEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		onExit();
		this.inEnhancedForControl = false;
	}

	protected boolean inParExpression = false;

	@Override
	public void enterParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ParExpression"), "text", arg.getText());
		onEnter(node);
		this.inParExpression = true;
	}

	public void exitParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		onExit();
		this.inParExpression = false;
	}

	protected boolean inExpressionList = false;

	@Override
	public void enterExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		final Node node = model.findOrCreate(Label.label("ExpressionList"), "text", arg.getText());
		onEnter(node);
		this.inExpressionList = true;
	}

	public void exitExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		onExit();
		this.inExpressionList = false;
	}

	protected boolean inLambdaExpression = false;

	@Override
	public void enterLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("LambdaExpression"), "text", arg.getText());
		onEnter(node);
		this.inLambdaExpression = true;
	}

	public void exitLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		onExit();
		this.inLambdaExpression = false;
	}

	protected boolean inLambdaParameters = false;

	@Override
	public void enterLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		final Node node = model.findOrCreate(Label.label("LambdaParameters"), "text", arg.getText());
		onEnter(node);
		this.inLambdaParameters = true;
	}

	public void exitLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		onExit();
		this.inLambdaParameters = false;
	}

	protected boolean inLambdaBody = false;

	@Override
	public void enterLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("LambdaBody"), "text", arg.getText());
		onEnter(node);
		this.inLambdaBody = true;
	}

	public void exitLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		onExit();
		this.inLambdaBody = false;
	}

	protected boolean inPrimary = false;

	@Override
	public void enterPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		final Node node = model.findOrCreate(Label.label("Primary"), "text", arg.getText());
		onEnter(node);
		this.inPrimary = true;
	}

	public void exitPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		onExit();
		this.inPrimary = false;
	}

	protected boolean inMethodReference = false;

	@Override
	public void enterMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodReference"), "text", arg.getText());
		onEnter(node);
		this.inMethodReference = true;
	}

	public void exitMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		onExit();
		this.inMethodReference = false;
	}

	protected boolean inClassType = false;

	@Override
	public void enterClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassType"), "text", arg.getText());
		onEnter(node);
		this.inClassType = true;
	}

	public void exitClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		onExit();
		this.inClassType = false;
	}

	protected boolean inCreator = false;

	@Override
	public void enterCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Creator"), "text", arg.getText());
		onEnter(node);
		this.inCreator = true;
	}

	public void exitCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		onExit();
		this.inCreator = false;
	}

	protected boolean inCreatedName = false;

	@Override
	public void enterCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		final Node node = model.findOrCreate(Label.label("CreatedName"), "text", arg.getText());
		onEnter(node);
		this.inCreatedName = true;
	}

	public void exitCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		onExit();
		this.inCreatedName = false;
	}

	protected boolean inInnerCreator = false;

	@Override
	public void enterInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		final Node node = model.findOrCreate(Label.label("InnerCreator"), "text", arg.getText());
		onEnter(node);
		this.inInnerCreator = true;
	}

	public void exitInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		onExit();
		this.inInnerCreator = false;
	}

	protected boolean inArrayCreatorRest = false;

	@Override
	public void enterArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayCreatorRest"), "text", arg.getText());
		onEnter(node);
		this.inArrayCreatorRest = true;
	}

	public void exitArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		onExit();
		this.inArrayCreatorRest = false;
	}

	protected boolean inClassCreatorRest = false;

	@Override
	public void enterClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassCreatorRest"), "text", arg.getText());
		onEnter(node);
		this.inClassCreatorRest = true;
	}

	public void exitClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		onExit();
		this.inClassCreatorRest = false;
	}

	protected boolean inExplicitGenericInvocation = false;

	@Override
	public void enterExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		final Node node = model.findOrCreate(Label.label("ExplicitGenericInvocation"), "text", arg.getText());
		onEnter(node);
		this.inExplicitGenericInvocation = true;
	}

	public void exitExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		onExit();
		this.inExplicitGenericInvocation = false;
	}

	protected boolean inTypeArgumentsOrDiamond = false;

	@Override
	public void enterTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeArgumentsOrDiamond"), "text", arg.getText());
		onEnter(node);
		this.inTypeArgumentsOrDiamond = true;
	}

	public void exitTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		onExit();
		this.inTypeArgumentsOrDiamond = false;
	}

	protected boolean inNonWildcardTypeArgumentsOrDiamond = false;

	@Override
	public void enterNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		final Node node = model.findOrCreate(Label.label("NonWildcardTypeArgumentsOrDiamond"), "text", arg.getText());
		onEnter(node);
		this.inNonWildcardTypeArgumentsOrDiamond = true;
	}

	public void exitNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		onExit();
		this.inNonWildcardTypeArgumentsOrDiamond = false;
	}

	protected boolean inNonWildcardTypeArguments = false;

	@Override
	public void enterNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("NonWildcardTypeArguments"), "text", arg.getText());
		onEnter(node);
		this.inNonWildcardTypeArguments = true;
	}

	public void exitNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		onExit();
		this.inNonWildcardTypeArguments = false;
	}

	protected boolean inTypeList = false;

	@Override
	public void enterTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeList"), "text", arg.getText());
		onEnter(node);
		this.inTypeList = true;
	}

	public void exitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		onExit();
		this.inTypeList = false;
	}

	protected boolean inTypeType = false;

	@Override
	public void enterTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeType"), "text", arg.getText());
		onEnter(node);
		this.inTypeType = true;
	}

	public void exitTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		onExit();
		this.inTypeType = false;
	}

	protected boolean inPrimitiveType = false;

	@Override
	public void enterPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("PrimitiveType"), "text", arg.getText());
		onEnter(node);
		this.inPrimitiveType = true;
	}

	public void exitPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		onExit();
		this.inPrimitiveType = false;
	}

	protected boolean inTypeArguments = false;

	@Override
	public void enterTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeArguments"), "text", arg.getText());
		onEnter(node);
		this.inTypeArguments = true;
	}

	public void exitTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		onExit();
		this.inTypeArguments = false;
	}

	protected boolean inSuperSuffix = false;

	@Override
	public void enterSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		final Node node = model.findOrCreate(Label.label("SuperSuffix"), "text", arg.getText());
		onEnter(node);
		this.inSuperSuffix = true;
	}

	public void exitSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		onExit();
		this.inSuperSuffix = false;
	}

	protected boolean inExplicitGenericInvocationSuffix = false;

	@Override
	public void enterExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		final Node node = model.findOrCreate(Label.label("ExplicitGenericInvocationSuffix"), "text", arg.getText());
		onEnter(node);
		this.inExplicitGenericInvocationSuffix = true;
	}

	public void exitExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		onExit();
		this.inExplicitGenericInvocationSuffix = false;
	}

}