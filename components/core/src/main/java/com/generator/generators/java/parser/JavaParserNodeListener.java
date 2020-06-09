package com.generator.generators.java.parser;

public class JavaParserNodeListener extends JavaParserBaseListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JavaParserNodeListener.class);

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final String endToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken, String endToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
			this.endToken = endToken;
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

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) log.debug(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Expression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Statement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("IntegerLiteral", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FormalParameterList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Arguments", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ExpressionList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inTypeList.push(true);
	}

	public void exitTypeList(com.generator.generators.java.parser.JavaParser.TypeListContext arg) {
		onExit();
		this.inTypeList.pop();
	}

	public boolean inTypeList() {
      return !inTypeList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultValue = new java.util.Stack<>();

	@Override
	public void enterDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDefaultValue.push(true);
	}

	public void exitDefaultValue(com.generator.generators.java.parser.JavaParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue.pop();
	}

	public boolean inDefaultValue() {
      return !inDefaultValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompilationUnit = new java.util.Stack<>();

	@Override
	public void enterCompilationUnit(com.generator.generators.java.parser.JavaParser.CompilationUnitContext arg) {
		onEnter(new Node("CompilationUnit", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PackageDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ImportDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Modifier", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ClassOrInterfaceModifier", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableModifier", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ClassDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeParameters", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeParameter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeBound", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("EnumDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("EnumConstants", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("EnumConstant", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("EnumBodyDeclarations", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InterfaceDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ClassBody", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InterfaceBody", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ClassBodyDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("MemberDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("MethodDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("MethodBody", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeTypeOrVoid", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("GenericMethodDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("GenericConstructorDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ConstructorDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FieldDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InterfaceBodyDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InterfaceMemberDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ConstDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ConstantDeclarator", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InterfaceMethodDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InterfaceMethodModifier", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("GenericInterfaceMethodDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableDeclarators", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableDeclarator", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableDeclaratorId", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("VariableInitializer", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ArrayInitializer", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ClassOrInterfaceType", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeArgument", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("QualifiedNameList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FormalParameters", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FormalParameter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LastFormalParameter", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("QualifiedName", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Annotation", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ElementValuePairs", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ElementValuePair", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ElementValue", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ElementValueArrayInitializer", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AnnotationTypeDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AnnotationTypeBody", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AnnotationTypeElementDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AnnotationTypeElementRest", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AnnotationMethodOrConstantRest", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AnnotationMethodRest", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("AnnotationConstantRest", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inAnnotationConstantRest.push(true);
	}

	public void exitAnnotationConstantRest(com.generator.generators.java.parser.JavaParser.AnnotationConstantRestContext arg) {
		onExit();
		this.inAnnotationConstantRest.pop();
	}

	public boolean inAnnotationConstantRest() {
      return !inAnnotationConstantRest.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlockStatement = new java.util.Stack<>();

	@Override
	public void enterBlockStatement(com.generator.generators.java.parser.JavaParser.BlockStatementContext arg) {
		onEnter(new Node("BlockStatement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LocalVariableDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("CatchClause", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("CatchType", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("FinallyBlock", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ResourceSpecification", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Resources", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Resource", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SwitchBlockStatementGroup", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SwitchLabel", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ForControl", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ForInit", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("EnhancedForControl", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ParExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LambdaExpression", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LambdaParameters", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("LambdaBody", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Primary", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("MethodReference", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ClassType", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Creator", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("CreatedName", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("InnerCreator", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ArrayCreatorRest", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ClassCreatorRest", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ExplicitGenericInvocation", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("NonWildcardTypeArgumentsOrDiamond", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("NonWildcardTypeArguments", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeType", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("PrimitiveType", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("TypeArguments", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("SuperSuffix", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("ExplicitGenericInvocationSuffix", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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