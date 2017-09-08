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
	public Node visitBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		System.out.println("Block");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		System.out.println("FormalParameterList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		System.out.println("Arguments");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		System.out.println("Expression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		System.out.println("Statement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		System.out.println("CompilationUnit");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		System.out.println("PackageDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		System.out.println("ImportDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		System.out.println("TypeDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		System.out.println("Modifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		System.out.println("ClassOrInterfaceModifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		System.out.println("VariableModifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		System.out.println("ClassDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		System.out.println("TypeParameters");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		System.out.println("TypeParameter");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		System.out.println("TypeBound");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		System.out.println("EnumDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		System.out.println("EnumConstants");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		System.out.println("EnumConstant");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		System.out.println("EnumBodyDeclarations");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		System.out.println("InterfaceDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		System.out.println("ClassBody");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		System.out.println("InterfaceBody");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		System.out.println("ClassBodyDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		System.out.println("MemberDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		System.out.println("MethodDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		System.out.println("MethodBody");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		System.out.println("TypeTypeOrVoid");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		System.out.println("GenericMethodDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		System.out.println("GenericConstructorDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		System.out.println("ConstructorDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		System.out.println("FieldDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		System.out.println("InterfaceBodyDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		System.out.println("InterfaceMemberDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		System.out.println("ConstDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		System.out.println("ConstantDeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		System.out.println("InterfaceMethodDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		System.out.println("InterfaceMethodModifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		System.out.println("GenericInterfaceMethodDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		System.out.println("VariableDeclarators");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		System.out.println("VariableDeclarator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		System.out.println("VariableDeclaratorId");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		System.out.println("VariableInitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		System.out.println("ArrayInitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		System.out.println("ClassOrInterfaceType");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		System.out.println("TypeArgument");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		System.out.println("QualifiedNameList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		System.out.println("FormalParameters");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		System.out.println("FormalParameter");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		System.out.println("LastFormalParameter");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		System.out.println("QualifiedName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		System.out.println("IntegerLiteral");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		System.out.println("Annotation");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		System.out.println("ElementValuePairs");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		System.out.println("ElementValuePair");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		System.out.println("ElementValue");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		System.out.println("ElementValueArrayInitializer");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		System.out.println("AnnotationTypeDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		System.out.println("AnnotationTypeBody");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		System.out.println("AnnotationTypeElementDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		System.out.println("AnnotationTypeElementRest");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		System.out.println("AnnotationMethodOrConstantRest");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		System.out.println("AnnotationMethodRest");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		System.out.println("AnnotationConstantRest");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		System.out.println("DefaultValue");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		System.out.println("BlockStatement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		System.out.println("LocalVariableDeclaration");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		System.out.println("CatchClause");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		System.out.println("CatchType");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		System.out.println("FinallyBlock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		System.out.println("ResourceSpecification");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		System.out.println("Resources");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		System.out.println("Resource");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		System.out.println("SwitchBlockStatementGroup");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		System.out.println("SwitchLabel");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		System.out.println("ForControl");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		System.out.println("ForInit");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		System.out.println("EnhancedForControl");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		System.out.println("ParExpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		System.out.println("ExpressionList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		System.out.println("LambdaExpression");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		System.out.println("LambdaParameters");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		System.out.println("LambdaBody");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		System.out.println("Primary");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		System.out.println("MethodReference");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		System.out.println("ClassType");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		System.out.println("Creator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		System.out.println("CreatedName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		System.out.println("InnerCreator");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		System.out.println("ArrayCreatorRest");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		System.out.println("ClassCreatorRest");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		System.out.println("ExplicitGenericInvocation");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		System.out.println("TypeArgumentsOrDiamond");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		System.out.println("NonWildcardTypeArgumentsOrDiamond");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		System.out.println("NonWildcardTypeArguments");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		System.out.println("TypeList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		System.out.println("TypeType");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		System.out.println("PrimitiveType");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		System.out.println("TypeArguments");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		System.out.println("SuperSuffix");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		System.out.println("ExplicitGenericInvocationSuffix");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}