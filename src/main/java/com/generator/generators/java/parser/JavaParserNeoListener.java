package com.generator.generators.java.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class JavaParserNeoListener extends JavaParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public JavaParserNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public JavaParserNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.java.parser.JavaParser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.java.parser.JavaParser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStatement = new java.util.Stack<>();

	@Override
	public void enterStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStatement.push(true);
	}

	public void exitStatement(com.generator.generators.java.parser.JavaParser.StatementContext arg) {
		onExit();
		this.inStatement.pop();
	}

	public boolean inStatement() {
      return !inStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.java.parser.JavaParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIntegerLiteral = new java.util.Stack<>();

	@Override
	public void enterIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("IntegerLiteral"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIntegerLiteral.push(true);
	}

	public void exitIntegerLiteral(com.generator.generators.java.parser.JavaParser.IntegerLiteralContext arg) {
		onExit();
		this.inIntegerLiteral.pop();
	}

	public boolean inIntegerLiteral() {
      return !inIntegerLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFormalParameterList = new java.util.Stack<>();

	@Override
	public void enterFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		final Node node = model.findOrCreate(Label.label("FormalParameterList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFormalParameterList.push(true);
	}

	public void exitFormalParameterList(com.generator.generators.java.parser.JavaParser.FormalParameterListContext arg) {
		onExit();
		this.inFormalParameterList.pop();
	}

	public boolean inFormalParameterList() {
      return !inFormalParameterList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArguments = new java.util.Stack<>();

	@Override
	public void enterArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("Arguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArguments.push(true);
	}

	public void exitArguments(com.generator.generators.java.parser.JavaParser.ArgumentsContext arg) {
		onExit();
		this.inArguments.pop();
	}

	public boolean inArguments() {
      return !inArguments.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpressionList = new java.util.Stack<>();

	@Override
	public void enterExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		final Node node = model.findOrCreate(Label.label("ExpressionList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpressionList.push(true);
	}

	public void exitExpressionList(com.generator.generators.java.parser.JavaParser.ExpressionListContext arg) {
		onExit();
		this.inExpressionList.pop();
	}

	public boolean inExpressionList() {
      return !inExpressionList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeList = new java.util.Stack<>();

	@Override
	public void enterTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeList.push(true);
	}

	public void exitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		onExit();
		this.inTypeList.pop();
	}

	public boolean inTypeList() {
      return !inTypeList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompilationUnit = new java.util.Stack<>();

	@Override
	public void enterCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		final Node node = model.findOrCreate(Label.label("CompilationUnit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCompilationUnit.push(true);
	}

	public void exitCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		onExit();
		this.inCompilationUnit.pop();
	}

	public boolean inCompilationUnit() {
      return !inCompilationUnit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackageDeclaration = new java.util.Stack<>();

	@Override
	public void enterPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPackageDeclaration.push(true);
	}

	public void exitPackageDeclaration(com.generator.generators.java.parser.JavaParser.PackageDeclarationContext arg) {
		onExit();
		this.inPackageDeclaration.pop();
	}

	public boolean inPackageDeclaration() {
      return !inPackageDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportDeclaration = new java.util.Stack<>();

	@Override
	public void enterImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImportDeclaration.push(true);
	}

	public void exitImportDeclaration(com.generator.generators.java.parser.JavaParser.ImportDeclarationContext arg) {
		onExit();
		this.inImportDeclaration.pop();
	}

	public boolean inImportDeclaration() {
      return !inImportDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeDeclaration = new java.util.Stack<>();

	@Override
	public void enterTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeDeclaration.push(true);
	}

	public void exitTypeDeclaration(com.generator.generators.java.parser.JavaParser.TypeDeclarationContext arg) {
		onExit();
		this.inTypeDeclaration.pop();
	}

	public boolean inTypeDeclaration() {
      return !inTypeDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inModifier = new java.util.Stack<>();

	@Override
	public void enterModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Modifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inModifier.push(true);
	}

	public void exitModifier(com.generator.generators.java.parser.JavaParser.ModifierContext arg) {
		onExit();
		this.inModifier.pop();
	}

	public boolean inModifier() {
      return !inModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassOrInterfaceModifier = new java.util.Stack<>();

	@Override
	public void enterClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassOrInterfaceModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassOrInterfaceModifier.push(true);
	}

	public void exitClassOrInterfaceModifier(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceModifierContext arg) {
		onExit();
		this.inClassOrInterfaceModifier.pop();
	}

	public boolean inClassOrInterfaceModifier() {
      return !inClassOrInterfaceModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableModifier = new java.util.Stack<>();

	@Override
	public void enterVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableModifier.push(true);
	}

	public void exitVariableModifier(com.generator.generators.java.parser.JavaParser.VariableModifierContext arg) {
		onExit();
		this.inVariableModifier.pop();
	}

	public boolean inVariableModifier() {
      return !inVariableModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassDeclaration = new java.util.Stack<>();

	@Override
	public void enterClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassDeclaration.push(true);
	}

	public void exitClassDeclaration(com.generator.generators.java.parser.JavaParser.ClassDeclarationContext arg) {
		onExit();
		this.inClassDeclaration.pop();
	}

	public boolean inClassDeclaration() {
      return !inClassDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeParameters = new java.util.Stack<>();

	@Override
	public void enterTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeParameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeParameters.push(true);
	}

	public void exitTypeParameters(com.generator.generators.java.parser.JavaParser.TypeParametersContext arg) {
		onExit();
		this.inTypeParameters.pop();
	}

	public boolean inTypeParameters() {
      return !inTypeParameters.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeParameter = new java.util.Stack<>();

	@Override
	public void enterTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeParameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeParameter.push(true);
	}

	public void exitTypeParameter(com.generator.generators.java.parser.JavaParser.TypeParameterContext arg) {
		onExit();
		this.inTypeParameter.pop();
	}

	public boolean inTypeParameter() {
      return !inTypeParameter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeBound = new java.util.Stack<>();

	@Override
	public void enterTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeBound"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeBound.push(true);
	}

	public void exitTypeBound(com.generator.generators.java.parser.JavaParser.TypeBoundContext arg) {
		onExit();
		this.inTypeBound.pop();
	}

	public boolean inTypeBound() {
      return !inTypeBound.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumDeclaration = new java.util.Stack<>();

	@Override
	public void enterEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEnumDeclaration.push(true);
	}

	public void exitEnumDeclaration(com.generator.generators.java.parser.JavaParser.EnumDeclarationContext arg) {
		onExit();
		this.inEnumDeclaration.pop();
	}

	public boolean inEnumDeclaration() {
      return !inEnumDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumConstants = new java.util.Stack<>();

	@Override
	public void enterEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumConstants"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEnumConstants.push(true);
	}

	public void exitEnumConstants(com.generator.generators.java.parser.JavaParser.EnumConstantsContext arg) {
		onExit();
		this.inEnumConstants.pop();
	}

	public boolean inEnumConstants() {
      return !inEnumConstants.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumConstant = new java.util.Stack<>();

	@Override
	public void enterEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumConstant"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEnumConstant.push(true);
	}

	public void exitEnumConstant(com.generator.generators.java.parser.JavaParser.EnumConstantContext arg) {
		onExit();
		this.inEnumConstant.pop();
	}

	public boolean inEnumConstant() {
      return !inEnumConstant.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumBodyDeclarations = new java.util.Stack<>();

	@Override
	public void enterEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumBodyDeclarations"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEnumBodyDeclarations.push(true);
	}

	public void exitEnumBodyDeclarations(com.generator.generators.java.parser.JavaParser.EnumBodyDeclarationsContext arg) {
		onExit();
		this.inEnumBodyDeclarations.pop();
	}

	public boolean inEnumBodyDeclarations() {
      return !inEnumBodyDeclarations.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceDeclaration = new java.util.Stack<>();

	@Override
	public void enterInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterfaceDeclaration.push(true);
	}

	public void exitInterfaceDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceDeclarationContext arg) {
		onExit();
		this.inInterfaceDeclaration.pop();
	}

	public boolean inInterfaceDeclaration() {
      return !inInterfaceDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassBody = new java.util.Stack<>();

	@Override
	public void enterClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassBody.push(true);
	}

	public void exitClassBody(com.generator.generators.java.parser.JavaParser.ClassBodyContext arg) {
		onExit();
		this.inClassBody.pop();
	}

	public boolean inClassBody() {
      return !inClassBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceBody = new java.util.Stack<>();

	@Override
	public void enterInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterfaceBody.push(true);
	}

	public void exitInterfaceBody(com.generator.generators.java.parser.JavaParser.InterfaceBodyContext arg) {
		onExit();
		this.inInterfaceBody.pop();
	}

	public boolean inInterfaceBody() {
      return !inInterfaceBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassBodyDeclaration = new java.util.Stack<>();

	@Override
	public void enterClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassBodyDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassBodyDeclaration.push(true);
	}

	public void exitClassBodyDeclaration(com.generator.generators.java.parser.JavaParser.ClassBodyDeclarationContext arg) {
		onExit();
		this.inClassBodyDeclaration.pop();
	}

	public boolean inClassBodyDeclaration() {
      return !inClassBodyDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberDeclaration = new java.util.Stack<>();

	@Override
	public void enterMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("MemberDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMemberDeclaration.push(true);
	}

	public void exitMemberDeclaration(com.generator.generators.java.parser.JavaParser.MemberDeclarationContext arg) {
		onExit();
		this.inMemberDeclaration.pop();
	}

	public boolean inMemberDeclaration() {
      return !inMemberDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodDeclaration = new java.util.Stack<>();

	@Override
	public void enterMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMethodDeclaration.push(true);
	}

	public void exitMethodDeclaration(com.generator.generators.java.parser.JavaParser.MethodDeclarationContext arg) {
		onExit();
		this.inMethodDeclaration.pop();
	}

	public boolean inMethodDeclaration() {
      return !inMethodDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodBody = new java.util.Stack<>();

	@Override
	public void enterMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMethodBody.push(true);
	}

	public void exitMethodBody(com.generator.generators.java.parser.JavaParser.MethodBodyContext arg) {
		onExit();
		this.inMethodBody.pop();
	}

	public boolean inMethodBody() {
      return !inMethodBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeTypeOrVoid = new java.util.Stack<>();

	@Override
	public void enterTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeTypeOrVoid"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeTypeOrVoid.push(true);
	}

	public void exitTypeTypeOrVoid(com.generator.generators.java.parser.JavaParser.TypeTypeOrVoidContext arg) {
		onExit();
		this.inTypeTypeOrVoid.pop();
	}

	public boolean inTypeTypeOrVoid() {
      return !inTypeTypeOrVoid.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGenericMethodDeclaration = new java.util.Stack<>();

	@Override
	public void enterGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("GenericMethodDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGenericMethodDeclaration.push(true);
	}

	public void exitGenericMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericMethodDeclarationContext arg) {
		onExit();
		this.inGenericMethodDeclaration.pop();
	}

	public boolean inGenericMethodDeclaration() {
      return !inGenericMethodDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGenericConstructorDeclaration = new java.util.Stack<>();

	@Override
	public void enterGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("GenericConstructorDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGenericConstructorDeclaration.push(true);
	}

	public void exitGenericConstructorDeclaration(com.generator.generators.java.parser.JavaParser.GenericConstructorDeclarationContext arg) {
		onExit();
		this.inGenericConstructorDeclaration.pop();
	}

	public boolean inGenericConstructorDeclaration() {
      return !inGenericConstructorDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstructorDeclaration = new java.util.Stack<>();

	@Override
	public void enterConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstructorDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstructorDeclaration.push(true);
	}

	public void exitConstructorDeclaration(com.generator.generators.java.parser.JavaParser.ConstructorDeclarationContext arg) {
		onExit();
		this.inConstructorDeclaration.pop();
	}

	public boolean inConstructorDeclaration() {
      return !inConstructorDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFieldDeclaration = new java.util.Stack<>();

	@Override
	public void enterFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("FieldDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFieldDeclaration.push(true);
	}

	public void exitFieldDeclaration(com.generator.generators.java.parser.JavaParser.FieldDeclarationContext arg) {
		onExit();
		this.inFieldDeclaration.pop();
	}

	public boolean inFieldDeclaration() {
      return !inFieldDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceBodyDeclaration = new java.util.Stack<>();

	@Override
	public void enterInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceBodyDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterfaceBodyDeclaration.push(true);
	}

	public void exitInterfaceBodyDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceBodyDeclarationContext arg) {
		onExit();
		this.inInterfaceBodyDeclaration.pop();
	}

	public boolean inInterfaceBodyDeclaration() {
      return !inInterfaceBodyDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceMemberDeclaration = new java.util.Stack<>();

	@Override
	public void enterInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceMemberDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterfaceMemberDeclaration.push(true);
	}

	public void exitInterfaceMemberDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMemberDeclarationContext arg) {
		onExit();
		this.inInterfaceMemberDeclaration.pop();
	}

	public boolean inInterfaceMemberDeclaration() {
      return !inInterfaceMemberDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstDeclaration = new java.util.Stack<>();

	@Override
	public void enterConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstDeclaration.push(true);
	}

	public void exitConstDeclaration(com.generator.generators.java.parser.JavaParser.ConstDeclarationContext arg) {
		onExit();
		this.inConstDeclaration.pop();
	}

	public boolean inConstDeclaration() {
      return !inConstDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstantDeclarator = new java.util.Stack<>();

	@Override
	public void enterConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstantDeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstantDeclarator.push(true);
	}

	public void exitConstantDeclarator(com.generator.generators.java.parser.JavaParser.ConstantDeclaratorContext arg) {
		onExit();
		this.inConstantDeclarator.pop();
	}

	public boolean inConstantDeclarator() {
      return !inConstantDeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceMethodDeclaration = new java.util.Stack<>();

	@Override
	public void enterInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceMethodDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterfaceMethodDeclaration.push(true);
	}

	public void exitInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.InterfaceMethodDeclarationContext arg) {
		onExit();
		this.inInterfaceMethodDeclaration.pop();
	}

	public boolean inInterfaceMethodDeclaration() {
      return !inInterfaceMethodDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInterfaceMethodModifier = new java.util.Stack<>();

	@Override
	public void enterInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("InterfaceMethodModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInterfaceMethodModifier.push(true);
	}

	public void exitInterfaceMethodModifier(com.generator.generators.java.parser.JavaParser.InterfaceMethodModifierContext arg) {
		onExit();
		this.inInterfaceMethodModifier.pop();
	}

	public boolean inInterfaceMethodModifier() {
      return !inInterfaceMethodModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGenericInterfaceMethodDeclaration = new java.util.Stack<>();

	@Override
	public void enterGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("GenericInterfaceMethodDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGenericInterfaceMethodDeclaration.push(true);
	}

	public void exitGenericInterfaceMethodDeclaration(com.generator.generators.java.parser.JavaParser.GenericInterfaceMethodDeclarationContext arg) {
		onExit();
		this.inGenericInterfaceMethodDeclaration.pop();
	}

	public boolean inGenericInterfaceMethodDeclaration() {
      return !inGenericInterfaceMethodDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableDeclarators = new java.util.Stack<>();

	@Override
	public void enterVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclarators"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableDeclarators.push(true);
	}

	public void exitVariableDeclarators(com.generator.generators.java.parser.JavaParser.VariableDeclaratorsContext arg) {
		onExit();
		this.inVariableDeclarators.pop();
	}

	public boolean inVariableDeclarators() {
      return !inVariableDeclarators.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableDeclarator = new java.util.Stack<>();

	@Override
	public void enterVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclarator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableDeclarator.push(true);
	}

	public void exitVariableDeclarator(com.generator.generators.java.parser.JavaParser.VariableDeclaratorContext arg) {
		onExit();
		this.inVariableDeclarator.pop();
	}

	public boolean inVariableDeclarator() {
      return !inVariableDeclarator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableDeclaratorId = new java.util.Stack<>();

	@Override
	public void enterVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableDeclaratorId"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableDeclaratorId.push(true);
	}

	public void exitVariableDeclaratorId(com.generator.generators.java.parser.JavaParser.VariableDeclaratorIdContext arg) {
		onExit();
		this.inVariableDeclaratorId.pop();
	}

	public boolean inVariableDeclaratorId() {
      return !inVariableDeclaratorId.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableInitializer = new java.util.Stack<>();

	@Override
	public void enterVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("VariableInitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableInitializer.push(true);
	}

	public void exitVariableInitializer(com.generator.generators.java.parser.JavaParser.VariableInitializerContext arg) {
		onExit();
		this.inVariableInitializer.pop();
	}

	public boolean inVariableInitializer() {
      return !inVariableInitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayInitializer = new java.util.Stack<>();

	@Override
	public void enterArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayInitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArrayInitializer.push(true);
	}

	public void exitArrayInitializer(com.generator.generators.java.parser.JavaParser.ArrayInitializerContext arg) {
		onExit();
		this.inArrayInitializer.pop();
	}

	public boolean inArrayInitializer() {
      return !inArrayInitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassOrInterfaceType = new java.util.Stack<>();

	@Override
	public void enterClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassOrInterfaceType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassOrInterfaceType.push(true);
	}

	public void exitClassOrInterfaceType(com.generator.generators.java.parser.JavaParser.ClassOrInterfaceTypeContext arg) {
		onExit();
		this.inClassOrInterfaceType.pop();
	}

	public boolean inClassOrInterfaceType() {
      return !inClassOrInterfaceType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeArgument = new java.util.Stack<>();

	@Override
	public void enterTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeArgument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeArgument.push(true);
	}

	public void exitTypeArgument(com.generator.generators.java.parser.JavaParser.TypeArgumentContext arg) {
		onExit();
		this.inTypeArgument.pop();
	}

	public boolean inTypeArgument() {
      return !inTypeArgument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedNameList = new java.util.Stack<>();

	@Override
	public void enterQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedNameList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQualifiedNameList.push(true);
	}

	public void exitQualifiedNameList(com.generator.generators.java.parser.JavaParser.QualifiedNameListContext arg) {
		onExit();
		this.inQualifiedNameList.pop();
	}

	public boolean inQualifiedNameList() {
      return !inQualifiedNameList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFormalParameters = new java.util.Stack<>();

	@Override
	public void enterFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		final Node node = model.findOrCreate(Label.label("FormalParameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFormalParameters.push(true);
	}

	public void exitFormalParameters(com.generator.generators.java.parser.JavaParser.FormalParametersContext arg) {
		onExit();
		this.inFormalParameters.pop();
	}

	public boolean inFormalParameters() {
      return !inFormalParameters.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFormalParameter = new java.util.Stack<>();

	@Override
	public void enterFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		final Node node = model.findOrCreate(Label.label("FormalParameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFormalParameter.push(true);
	}

	public void exitFormalParameter(com.generator.generators.java.parser.JavaParser.FormalParameterContext arg) {
		onExit();
		this.inFormalParameter.pop();
	}

	public boolean inFormalParameter() {
      return !inFormalParameter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLastFormalParameter = new java.util.Stack<>();

	@Override
	public void enterLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		final Node node = model.findOrCreate(Label.label("LastFormalParameter"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLastFormalParameter.push(true);
	}

	public void exitLastFormalParameter(com.generator.generators.java.parser.JavaParser.LastFormalParameterContext arg) {
		onExit();
		this.inLastFormalParameter.pop();
	}

	public boolean inLastFormalParameter() {
      return !inLastFormalParameter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualifiedName = new java.util.Stack<>();

	@Override
	public void enterQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		final Node node = model.findOrCreate(Label.label("QualifiedName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQualifiedName.push(true);
	}

	public void exitQualifiedName(com.generator.generators.java.parser.JavaParser.QualifiedNameContext arg) {
		onExit();
		this.inQualifiedName.pop();
	}

	public boolean inQualifiedName() {
      return !inQualifiedName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotation = new java.util.Stack<>();

	@Override
	public void enterAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		final Node node = model.findOrCreate(Label.label("Annotation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotation.push(true);
	}

	public void exitAnnotation(com.generator.generators.java.parser.JavaParser.AnnotationContext arg) {
		onExit();
		this.inAnnotation.pop();
	}

	public boolean inAnnotation() {
      return !inAnnotation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementValuePairs = new java.util.Stack<>();

	@Override
	public void enterElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValuePairs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inElementValuePairs.push(true);
	}

	public void exitElementValuePairs(com.generator.generators.java.parser.JavaParser.ElementValuePairsContext arg) {
		onExit();
		this.inElementValuePairs.pop();
	}

	public boolean inElementValuePairs() {
      return !inElementValuePairs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementValuePair = new java.util.Stack<>();

	@Override
	public void enterElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValuePair"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inElementValuePair.push(true);
	}

	public void exitElementValuePair(com.generator.generators.java.parser.JavaParser.ElementValuePairContext arg) {
		onExit();
		this.inElementValuePair.pop();
	}

	public boolean inElementValuePair() {
      return !inElementValuePair.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementValue = new java.util.Stack<>();

	@Override
	public void enterElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inElementValue.push(true);
	}

	public void exitElementValue(com.generator.generators.java.parser.JavaParser.ElementValueContext arg) {
		onExit();
		this.inElementValue.pop();
	}

	public boolean inElementValue() {
      return !inElementValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementValueArrayInitializer = new java.util.Stack<>();

	@Override
	public void enterElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementValueArrayInitializer"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inElementValueArrayInitializer.push(true);
	}

	public void exitElementValueArrayInitializer(com.generator.generators.java.parser.JavaParser.ElementValueArrayInitializerContext arg) {
		onExit();
		this.inElementValueArrayInitializer.pop();
	}

	public boolean inElementValueArrayInitializer() {
      return !inElementValueArrayInitializer.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotationTypeDeclaration = new java.util.Stack<>();

	@Override
	public void enterAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotationTypeDeclaration.push(true);
	}

	public void exitAnnotationTypeDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeDeclarationContext arg) {
		onExit();
		this.inAnnotationTypeDeclaration.pop();
	}

	public boolean inAnnotationTypeDeclaration() {
      return !inAnnotationTypeDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotationTypeBody = new java.util.Stack<>();

	@Override
	public void enterAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotationTypeBody.push(true);
	}

	public void exitAnnotationTypeBody(com.generator.generators.java.parser.JavaParser.AnnotationTypeBodyContext arg) {
		onExit();
		this.inAnnotationTypeBody.pop();
	}

	public boolean inAnnotationTypeBody() {
      return !inAnnotationTypeBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotationTypeElementDeclaration = new java.util.Stack<>();

	@Override
	public void enterAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeElementDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotationTypeElementDeclaration.push(true);
	}

	public void exitAnnotationTypeElementDeclaration(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementDeclarationContext arg) {
		onExit();
		this.inAnnotationTypeElementDeclaration.pop();
	}

	public boolean inAnnotationTypeElementDeclaration() {
      return !inAnnotationTypeElementDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotationTypeElementRest = new java.util.Stack<>();

	@Override
	public void enterAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationTypeElementRest"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotationTypeElementRest.push(true);
	}

	public void exitAnnotationTypeElementRest(com.generator.generators.java.parser.JavaParser.AnnotationTypeElementRestContext arg) {
		onExit();
		this.inAnnotationTypeElementRest.pop();
	}

	public boolean inAnnotationTypeElementRest() {
      return !inAnnotationTypeElementRest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotationMethodOrConstantRest = new java.util.Stack<>();

	@Override
	public void enterAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationMethodOrConstantRest"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotationMethodOrConstantRest.push(true);
	}

	public void exitAnnotationMethodOrConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodOrConstantRestContext arg) {
		onExit();
		this.inAnnotationMethodOrConstantRest.pop();
	}

	public boolean inAnnotationMethodOrConstantRest() {
      return !inAnnotationMethodOrConstantRest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotationMethodRest = new java.util.Stack<>();

	@Override
	public void enterAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationMethodRest"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotationMethodRest.push(true);
	}

	public void exitAnnotationMethodRest(com.generator.generators.java.parser.JavaParser.AnnotationMethodRestContext arg) {
		onExit();
		this.inAnnotationMethodRest.pop();
	}

	public boolean inAnnotationMethodRest() {
      return !inAnnotationMethodRest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotationConstantRest = new java.util.Stack<>();

	@Override
	public void enterAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotationConstantRest"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotationConstantRest.push(true);
	}

	public void exitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		onExit();
		this.inAnnotationConstantRest.pop();
	}

	public boolean inAnnotationConstantRest() {
      return !inAnnotationConstantRest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultValue = new java.util.Stack<>();

	@Override
	public void enterDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		final Node node = model.findOrCreate(Label.label("DefaultValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDefaultValue.push(true);
	}

	public void exitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue.pop();
	}

	public boolean inDefaultValue() {
      return !inDefaultValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlockStatement = new java.util.Stack<>();

	@Override
	public void enterBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		final Node node = model.findOrCreate(Label.label("BlockStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlockStatement.push(true);
	}

	public void exitBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		onExit();
		this.inBlockStatement.pop();
	}

	public boolean inBlockStatement() {
      return !inBlockStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLocalVariableDeclaration = new java.util.Stack<>();

	@Override
	public void enterLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("LocalVariableDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLocalVariableDeclaration.push(true);
	}

	public void exitLocalVariableDeclaration(com.generator.generators.java.parser.JavaParser.LocalVariableDeclarationContext arg) {
		onExit();
		this.inLocalVariableDeclaration.pop();
	}

	public boolean inLocalVariableDeclaration() {
      return !inLocalVariableDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCatchClause = new java.util.Stack<>();

	@Override
	public void enterCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("CatchClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCatchClause.push(true);
	}

	public void exitCatchClause(com.generator.generators.java.parser.JavaParser.CatchClauseContext arg) {
		onExit();
		this.inCatchClause.pop();
	}

	public boolean inCatchClause() {
      return !inCatchClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCatchType = new java.util.Stack<>();

	@Override
	public void enterCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("CatchType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCatchType.push(true);
	}

	public void exitCatchType(com.generator.generators.java.parser.JavaParser.CatchTypeContext arg) {
		onExit();
		this.inCatchType.pop();
	}

	public boolean inCatchType() {
      return !inCatchType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFinallyBlock = new java.util.Stack<>();

	@Override
	public void enterFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("FinallyBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFinallyBlock.push(true);
	}

	public void exitFinallyBlock(com.generator.generators.java.parser.JavaParser.FinallyBlockContext arg) {
		onExit();
		this.inFinallyBlock.pop();
	}

	public boolean inFinallyBlock() {
      return !inFinallyBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inResourceSpecification = new java.util.Stack<>();

	@Override
	public void enterResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("ResourceSpecification"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inResourceSpecification.push(true);
	}

	public void exitResourceSpecification(com.generator.generators.java.parser.JavaParser.ResourceSpecificationContext arg) {
		onExit();
		this.inResourceSpecification.pop();
	}

	public boolean inResourceSpecification() {
      return !inResourceSpecification.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inResources = new java.util.Stack<>();

	@Override
	public void enterResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		final Node node = model.findOrCreate(Label.label("Resources"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inResources.push(true);
	}

	public void exitResources(com.generator.generators.java.parser.JavaParser.ResourcesContext arg) {
		onExit();
		this.inResources.pop();
	}

	public boolean inResources() {
      return !inResources.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inResource = new java.util.Stack<>();

	@Override
	public void enterResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		final Node node = model.findOrCreate(Label.label("Resource"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inResource.push(true);
	}

	public void exitResource(com.generator.generators.java.parser.JavaParser.ResourceContext arg) {
		onExit();
		this.inResource.pop();
	}

	public boolean inResource() {
      return !inResource.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSwitchBlockStatementGroup = new java.util.Stack<>();

	@Override
	public void enterSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		final Node node = model.findOrCreate(Label.label("SwitchBlockStatementGroup"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSwitchBlockStatementGroup.push(true);
	}

	public void exitSwitchBlockStatementGroup(com.generator.generators.java.parser.JavaParser.SwitchBlockStatementGroupContext arg) {
		onExit();
		this.inSwitchBlockStatementGroup.pop();
	}

	public boolean inSwitchBlockStatementGroup() {
      return !inSwitchBlockStatementGroup.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSwitchLabel = new java.util.Stack<>();

	@Override
	public void enterSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		final Node node = model.findOrCreate(Label.label("SwitchLabel"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSwitchLabel.push(true);
	}

	public void exitSwitchLabel(com.generator.generators.java.parser.JavaParser.SwitchLabelContext arg) {
		onExit();
		this.inSwitchLabel.pop();
	}

	public boolean inSwitchLabel() {
      return !inSwitchLabel.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForControl = new java.util.Stack<>();

	@Override
	public void enterForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		final Node node = model.findOrCreate(Label.label("ForControl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForControl.push(true);
	}

	public void exitForControl(com.generator.generators.java.parser.JavaParser.ForControlContext arg) {
		onExit();
		this.inForControl.pop();
	}

	public boolean inForControl() {
      return !inForControl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForInit = new java.util.Stack<>();

	@Override
	public void enterForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		final Node node = model.findOrCreate(Label.label("ForInit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForInit.push(true);
	}

	public void exitForInit(com.generator.generators.java.parser.JavaParser.ForInitContext arg) {
		onExit();
		this.inForInit.pop();
	}

	public boolean inForInit() {
      return !inForInit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnhancedForControl = new java.util.Stack<>();

	@Override
	public void enterEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		final Node node = model.findOrCreate(Label.label("EnhancedForControl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEnhancedForControl.push(true);
	}

	public void exitEnhancedForControl(com.generator.generators.java.parser.JavaParser.EnhancedForControlContext arg) {
		onExit();
		this.inEnhancedForControl.pop();
	}

	public boolean inEnhancedForControl() {
      return !inEnhancedForControl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParExpression = new java.util.Stack<>();

	@Override
	public void enterParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("ParExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParExpression.push(true);
	}

	public void exitParExpression(com.generator.generators.java.parser.JavaParser.ParExpressionContext arg) {
		onExit();
		this.inParExpression.pop();
	}

	public boolean inParExpression() {
      return !inParExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdaExpression = new java.util.Stack<>();

	@Override
	public void enterLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("LambdaExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLambdaExpression.push(true);
	}

	public void exitLambdaExpression(com.generator.generators.java.parser.JavaParser.LambdaExpressionContext arg) {
		onExit();
		this.inLambdaExpression.pop();
	}

	public boolean inLambdaExpression() {
      return !inLambdaExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdaParameters = new java.util.Stack<>();

	@Override
	public void enterLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		final Node node = model.findOrCreate(Label.label("LambdaParameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLambdaParameters.push(true);
	}

	public void exitLambdaParameters(com.generator.generators.java.parser.JavaParser.LambdaParametersContext arg) {
		onExit();
		this.inLambdaParameters.pop();
	}

	public boolean inLambdaParameters() {
      return !inLambdaParameters.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambdaBody = new java.util.Stack<>();

	@Override
	public void enterLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("LambdaBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLambdaBody.push(true);
	}

	public void exitLambdaBody(com.generator.generators.java.parser.JavaParser.LambdaBodyContext arg) {
		onExit();
		this.inLambdaBody.pop();
	}

	public boolean inLambdaBody() {
      return !inLambdaBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrimary = new java.util.Stack<>();

	@Override
	public void enterPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		final Node node = model.findOrCreate(Label.label("Primary"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrimary.push(true);
	}

	public void exitPrimary(com.generator.generators.java.parser.JavaParser.PrimaryContext arg) {
		onExit();
		this.inPrimary.pop();
	}

	public boolean inPrimary() {
      return !inPrimary.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMethodReference = new java.util.Stack<>();

	@Override
	public void enterMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		final Node node = model.findOrCreate(Label.label("MethodReference"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMethodReference.push(true);
	}

	public void exitMethodReference(com.generator.generators.java.parser.JavaParser.MethodReferenceContext arg) {
		onExit();
		this.inMethodReference.pop();
	}

	public boolean inMethodReference() {
      return !inMethodReference.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassType = new java.util.Stack<>();

	@Override
	public void enterClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassType.push(true);
	}

	public void exitClassType(com.generator.generators.java.parser.JavaParser.ClassTypeContext arg) {
		onExit();
		this.inClassType.pop();
	}

	public boolean inClassType() {
      return !inClassType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreator = new java.util.Stack<>();

	@Override
	public void enterCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Creator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreator.push(true);
	}

	public void exitCreator(com.generator.generators.java.parser.JavaParser.CreatorContext arg) {
		onExit();
		this.inCreator.pop();
	}

	public boolean inCreator() {
      return !inCreator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCreatedName = new java.util.Stack<>();

	@Override
	public void enterCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		final Node node = model.findOrCreate(Label.label("CreatedName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCreatedName.push(true);
	}

	public void exitCreatedName(com.generator.generators.java.parser.JavaParser.CreatedNameContext arg) {
		onExit();
		this.inCreatedName.pop();
	}

	public boolean inCreatedName() {
      return !inCreatedName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInnerCreator = new java.util.Stack<>();

	@Override
	public void enterInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		final Node node = model.findOrCreate(Label.label("InnerCreator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInnerCreator.push(true);
	}

	public void exitInnerCreator(com.generator.generators.java.parser.JavaParser.InnerCreatorContext arg) {
		onExit();
		this.inInnerCreator.pop();
	}

	public boolean inInnerCreator() {
      return !inInnerCreator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayCreatorRest = new java.util.Stack<>();

	@Override
	public void enterArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		final Node node = model.findOrCreate(Label.label("ArrayCreatorRest"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArrayCreatorRest.push(true);
	}

	public void exitArrayCreatorRest(com.generator.generators.java.parser.JavaParser.ArrayCreatorRestContext arg) {
		onExit();
		this.inArrayCreatorRest.pop();
	}

	public boolean inArrayCreatorRest() {
      return !inArrayCreatorRest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassCreatorRest = new java.util.Stack<>();

	@Override
	public void enterClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassCreatorRest"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassCreatorRest.push(true);
	}

	public void exitClassCreatorRest(com.generator.generators.java.parser.JavaParser.ClassCreatorRestContext arg) {
		onExit();
		this.inClassCreatorRest.pop();
	}

	public boolean inClassCreatorRest() {
      return !inClassCreatorRest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExplicitGenericInvocation = new java.util.Stack<>();

	@Override
	public void enterExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		final Node node = model.findOrCreate(Label.label("ExplicitGenericInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExplicitGenericInvocation.push(true);
	}

	public void exitExplicitGenericInvocation(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationContext arg) {
		onExit();
		this.inExplicitGenericInvocation.pop();
	}

	public boolean inExplicitGenericInvocation() {
      return !inExplicitGenericInvocation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeArgumentsOrDiamond = new java.util.Stack<>();

	@Override
	public void enterTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeArgumentsOrDiamond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeArgumentsOrDiamond.push(true);
	}

	public void exitTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.TypeArgumentsOrDiamondContext arg) {
		onExit();
		this.inTypeArgumentsOrDiamond.pop();
	}

	public boolean inTypeArgumentsOrDiamond() {
      return !inTypeArgumentsOrDiamond.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNonWildcardTypeArgumentsOrDiamond = new java.util.Stack<>();

	@Override
	public void enterNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		final Node node = model.findOrCreate(Label.label("NonWildcardTypeArgumentsOrDiamond"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNonWildcardTypeArgumentsOrDiamond.push(true);
	}

	public void exitNonWildcardTypeArgumentsOrDiamond(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsOrDiamondContext arg) {
		onExit();
		this.inNonWildcardTypeArgumentsOrDiamond.pop();
	}

	public boolean inNonWildcardTypeArgumentsOrDiamond() {
      return !inNonWildcardTypeArgumentsOrDiamond.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNonWildcardTypeArguments = new java.util.Stack<>();

	@Override
	public void enterNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("NonWildcardTypeArguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNonWildcardTypeArguments.push(true);
	}

	public void exitNonWildcardTypeArguments(com.generator.generators.java.parser.JavaParser.NonWildcardTypeArgumentsContext arg) {
		onExit();
		this.inNonWildcardTypeArguments.pop();
	}

	public boolean inNonWildcardTypeArguments() {
      return !inNonWildcardTypeArguments.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeType = new java.util.Stack<>();

	@Override
	public void enterTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeType.push(true);
	}

	public void exitTypeType(com.generator.generators.java.parser.JavaParser.TypeTypeContext arg) {
		onExit();
		this.inTypeType.pop();
	}

	public boolean inTypeType() {
      return !inTypeType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrimitiveType = new java.util.Stack<>();

	@Override
	public void enterPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("PrimitiveType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrimitiveType.push(true);
	}

	public void exitPrimitiveType(com.generator.generators.java.parser.JavaParser.PrimitiveTypeContext arg) {
		onExit();
		this.inPrimitiveType.pop();
	}

	public boolean inPrimitiveType() {
      return !inPrimitiveType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeArguments = new java.util.Stack<>();

	@Override
	public void enterTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeArguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeArguments.push(true);
	}

	public void exitTypeArguments(com.generator.generators.java.parser.JavaParser.TypeArgumentsContext arg) {
		onExit();
		this.inTypeArguments.pop();
	}

	public boolean inTypeArguments() {
      return !inTypeArguments.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSuperSuffix = new java.util.Stack<>();

	@Override
	public void enterSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		final Node node = model.findOrCreate(Label.label("SuperSuffix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSuperSuffix.push(true);
	}

	public void exitSuperSuffix(com.generator.generators.java.parser.JavaParser.SuperSuffixContext arg) {
		onExit();
		this.inSuperSuffix.pop();
	}

	public boolean inSuperSuffix() {
      return !inSuperSuffix.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExplicitGenericInvocationSuffix = new java.util.Stack<>();

	@Override
	public void enterExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		final Node node = model.findOrCreate(Label.label("ExplicitGenericInvocationSuffix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExplicitGenericInvocationSuffix.push(true);
	}

	public void exitExplicitGenericInvocationSuffix(com.generator.generators.java.parser.JavaParser.ExplicitGenericInvocationSuffixContext arg) {
		onExit();
		this.inExplicitGenericInvocationSuffix.pop();
	}

	public boolean inExplicitGenericInvocationSuffix() {
      return !inExplicitGenericInvocationSuffix.isEmpty(); 
   }

}