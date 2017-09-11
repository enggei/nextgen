package com.generator.generators.java.parser;

public class JavaParserNodeVisitor extends JavaParserBaseVisitor<JavaParserNodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public JavaParserNodeVisitor() {
		this(false);
	}

	public JavaParserNodeVisitor(boolean debug) {
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

	@Override
	public Node visitBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		final Node node = new Node("Block", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		final Node node = new Node("Statement", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		final Node node = new Node("Expression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		final Node node = new Node("FormalParameterList", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		final Node node = new Node("Arguments", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		final Node node = new Node("CompilationUnit", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		final Node node = new Node("PackageDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		final Node node = new Node("ImportDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		final Node node = new Node("TypeDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		final Node node = new Node("Modifier", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		final Node node = new Node("ClassOrInterfaceModifier", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		final Node node = new Node("VariableModifier", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		final Node node = new Node("ClassDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		final Node node = new Node("TypeParameters", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		final Node node = new Node("TypeParameter", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		final Node node = new Node("TypeBound", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		final Node node = new Node("EnumDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		final Node node = new Node("EnumConstants", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		final Node node = new Node("EnumConstant", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		final Node node = new Node("EnumBodyDeclarations", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		final Node node = new Node("InterfaceDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		final Node node = new Node("ClassBody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		final Node node = new Node("InterfaceBody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		final Node node = new Node("ClassBodyDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		final Node node = new Node("MemberDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		final Node node = new Node("MethodDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		final Node node = new Node("MethodBody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		final Node node = new Node("TypeTypeOrVoid", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		final Node node = new Node("GenericMethodDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		final Node node = new Node("GenericConstructorDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		final Node node = new Node("ConstructorDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		final Node node = new Node("FieldDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		final Node node = new Node("InterfaceBodyDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		final Node node = new Node("InterfaceMemberDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		final Node node = new Node("ConstDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		final Node node = new Node("ConstantDeclarator", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		final Node node = new Node("InterfaceMethodDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		final Node node = new Node("InterfaceMethodModifier", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		final Node node = new Node("GenericInterfaceMethodDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		final Node node = new Node("VariableDeclarators", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		final Node node = new Node("VariableDeclarator", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		final Node node = new Node("VariableDeclaratorId", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		final Node node = new Node("VariableInitializer", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		final Node node = new Node("ArrayInitializer", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		final Node node = new Node("ClassOrInterfaceType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		final Node node = new Node("TypeArgument", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		final Node node = new Node("QualifiedNameList", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		final Node node = new Node("FormalParameters", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		final Node node = new Node("FormalParameter", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		final Node node = new Node("LastFormalParameter", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		final Node node = new Node("QualifiedName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		final Node node = new Node("IntegerLiteral", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		final Node node = new Node("Annotation", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		final Node node = new Node("ElementValuePairs", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		final Node node = new Node("ElementValuePair", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		final Node node = new Node("ElementValue", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		final Node node = new Node("ElementValueArrayInitializer", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		final Node node = new Node("AnnotationTypeDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		final Node node = new Node("AnnotationTypeBody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		final Node node = new Node("AnnotationTypeElementDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		final Node node = new Node("AnnotationTypeElementRest", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		final Node node = new Node("AnnotationMethodOrConstantRest", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		final Node node = new Node("AnnotationMethodRest", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		final Node node = new Node("AnnotationConstantRest", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		final Node node = new Node("DefaultValue", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		final Node node = new Node("BlockStatement", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		final Node node = new Node("LocalVariableDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		final Node node = new Node("CatchClause", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		final Node node = new Node("CatchType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		final Node node = new Node("FinallyBlock", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		final Node node = new Node("ResourceSpecification", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		final Node node = new Node("Resources", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		final Node node = new Node("Resource", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		final Node node = new Node("SwitchBlockStatementGroup", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		final Node node = new Node("SwitchLabel", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		final Node node = new Node("ForControl", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		final Node node = new Node("ForInit", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		final Node node = new Node("EnhancedForControl", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		final Node node = new Node("ParExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		final Node node = new Node("ExpressionList", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		final Node node = new Node("LambdaExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		final Node node = new Node("LambdaParameters", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		final Node node = new Node("LambdaBody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		final Node node = new Node("Primary", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		final Node node = new Node("MethodReference", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		final Node node = new Node("ClassType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		final Node node = new Node("Creator", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		final Node node = new Node("CreatedName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		final Node node = new Node("InnerCreator", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		final Node node = new Node("ArrayCreatorRest", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		final Node node = new Node("ClassCreatorRest", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		final Node node = new Node("ExplicitGenericInvocation", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		final Node node = new Node("TypeArgumentsOrDiamond", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		final Node node = new Node("NonWildcardTypeArgumentsOrDiamond", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		final Node node = new Node("NonWildcardTypeArguments", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		final Node node = new Node("TypeList", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		final Node node = new Node("TypeType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		final Node node = new Node("PrimitiveType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		final Node node = new Node("TypeArguments", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		final Node node = new Node("SuperSuffix", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		final Node node = new Node("ExplicitGenericInvocationSuffix", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}