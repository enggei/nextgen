package com.generator.generators.go.parser;

public class GolangNodeVisitor extends GolangBaseVisitor<GolangNodeVisitor.Node> {

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

	public GolangNodeVisitor() {
		this(false);
	}

	public GolangNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
				if (debug) System.out.println(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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

	@Override
	public Node visitElement(com.generator.generators.go.parser.GolangParser.ElementContext arg) {
		final Node node = new Node("Element", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock(com.generator.generators.go.parser.GolangParser.BlockContext arg) {
		final Node node = new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelector(com.generator.generators.go.parser.GolangParser.SelectorContext arg) {
		final Node node = new Node("Selector", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclaration(com.generator.generators.go.parser.GolangParser.DeclarationContext arg) {
		final Node node = new Node("Declaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.go.parser.GolangParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.go.parser.GolangParser.ExpressionContext arg) {
		final Node node = new Node("Expression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.go.parser.GolangParser.StatementContext arg) {
		final Node node = new Node("Statement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction(com.generator.generators.go.parser.GolangParser.FunctionContext arg) {
		final Node node = new Node("Function", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatementList(com.generator.generators.go.parser.GolangParser.StatementListContext arg) {
		final Node node = new Node("StatementList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementList(com.generator.generators.go.parser.GolangParser.ElementListContext arg) {
		final Node node = new Node("ElementList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.go.parser.GolangParser.ArgumentsContext arg) {
		final Node node = new Node("Arguments", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEos(com.generator.generators.go.parser.GolangParser.EosContext arg) {
		final Node node = new Node("Eos", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceFile(com.generator.generators.go.parser.GolangParser.SourceFileContext arg) {
		final Node node = new Node("SourceFile", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageClause(com.generator.generators.go.parser.GolangParser.PackageClauseContext arg) {
		final Node node = new Node("PackageClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportDecl(com.generator.generators.go.parser.GolangParser.ImportDeclContext arg) {
		final Node node = new Node("ImportDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSpec(com.generator.generators.go.parser.GolangParser.ImportSpecContext arg) {
		final Node node = new Node("ImportSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportPath(com.generator.generators.go.parser.GolangParser.ImportPathContext arg) {
		final Node node = new Node("ImportPath", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopLevelDecl(com.generator.generators.go.parser.GolangParser.TopLevelDeclContext arg) {
		final Node node = new Node("TopLevelDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstDecl(com.generator.generators.go.parser.GolangParser.ConstDeclContext arg) {
		final Node node = new Node("ConstDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstSpec(com.generator.generators.go.parser.GolangParser.ConstSpecContext arg) {
		final Node node = new Node("ConstSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifierList(com.generator.generators.go.parser.GolangParser.IdentifierListContext arg) {
		final Node node = new Node("IdentifierList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionList(com.generator.generators.go.parser.GolangParser.ExpressionListContext arg) {
		final Node node = new Node("ExpressionList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDecl(com.generator.generators.go.parser.GolangParser.TypeDeclContext arg) {
		final Node node = new Node("TypeDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSpec(com.generator.generators.go.parser.GolangParser.TypeSpecContext arg) {
		final Node node = new Node("TypeSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionDecl(com.generator.generators.go.parser.GolangParser.FunctionDeclContext arg) {
		final Node node = new Node("FunctionDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodDecl(com.generator.generators.go.parser.GolangParser.MethodDeclContext arg) {
		final Node node = new Node("MethodDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReceiver(com.generator.generators.go.parser.GolangParser.ReceiverContext arg) {
		final Node node = new Node("Receiver", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDecl(com.generator.generators.go.parser.GolangParser.VarDeclContext arg) {
		final Node node = new Node("VarDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarSpec(com.generator.generators.go.parser.GolangParser.VarSpecContext arg) {
		final Node node = new Node("VarSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleStmt(com.generator.generators.go.parser.GolangParser.SimpleStmtContext arg) {
		final Node node = new Node("SimpleStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionStmt(com.generator.generators.go.parser.GolangParser.ExpressionStmtContext arg) {
		final Node node = new Node("ExpressionStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSendStmt(com.generator.generators.go.parser.GolangParser.SendStmtContext arg) {
		final Node node = new Node("SendStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIncDecStmt(com.generator.generators.go.parser.GolangParser.IncDecStmtContext arg) {
		final Node node = new Node("IncDecStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignment(com.generator.generators.go.parser.GolangParser.AssignmentContext arg) {
		final Node node = new Node("Assignment", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssign_op(com.generator.generators.go.parser.GolangParser.Assign_opContext arg) {
		final Node node = new Node("Assign_op", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShortVarDecl(com.generator.generators.go.parser.GolangParser.ShortVarDeclContext arg) {
		final Node node = new Node("ShortVarDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmptyStmt(com.generator.generators.go.parser.GolangParser.EmptyStmtContext arg) {
		final Node node = new Node("EmptyStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabeledStmt(com.generator.generators.go.parser.GolangParser.LabeledStmtContext arg) {
		final Node node = new Node("LabeledStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnStmt(com.generator.generators.go.parser.GolangParser.ReturnStmtContext arg) {
		final Node node = new Node("ReturnStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreakStmt(com.generator.generators.go.parser.GolangParser.BreakStmtContext arg) {
		final Node node = new Node("BreakStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinueStmt(com.generator.generators.go.parser.GolangParser.ContinueStmtContext arg) {
		final Node node = new Node("ContinueStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGotoStmt(com.generator.generators.go.parser.GolangParser.GotoStmtContext arg) {
		final Node node = new Node("GotoStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFallthroughStmt(com.generator.generators.go.parser.GolangParser.FallthroughStmtContext arg) {
		final Node node = new Node("FallthroughStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeferStmt(com.generator.generators.go.parser.GolangParser.DeferStmtContext arg) {
		final Node node = new Node("DeferStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfStmt(com.generator.generators.go.parser.GolangParser.IfStmtContext arg) {
		final Node node = new Node("IfStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchStmt(com.generator.generators.go.parser.GolangParser.SwitchStmtContext arg) {
		final Node node = new Node("SwitchStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprSwitchStmt(com.generator.generators.go.parser.GolangParser.ExprSwitchStmtContext arg) {
		final Node node = new Node("ExprSwitchStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprCaseClause(com.generator.generators.go.parser.GolangParser.ExprCaseClauseContext arg) {
		final Node node = new Node("ExprCaseClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprSwitchCase(com.generator.generators.go.parser.GolangParser.ExprSwitchCaseContext arg) {
		final Node node = new Node("ExprSwitchCase", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchStmt(com.generator.generators.go.parser.GolangParser.TypeSwitchStmtContext arg) {
		final Node node = new Node("TypeSwitchStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchGuard(com.generator.generators.go.parser.GolangParser.TypeSwitchGuardContext arg) {
		final Node node = new Node("TypeSwitchGuard", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeCaseClause(com.generator.generators.go.parser.GolangParser.TypeCaseClauseContext arg) {
		final Node node = new Node("TypeCaseClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchCase(com.generator.generators.go.parser.GolangParser.TypeSwitchCaseContext arg) {
		final Node node = new Node("TypeSwitchCase", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeList(com.generator.generators.go.parser.GolangParser.TypeListContext arg) {
		final Node node = new Node("TypeList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectStmt(com.generator.generators.go.parser.GolangParser.SelectStmtContext arg) {
		final Node node = new Node("SelectStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommClause(com.generator.generators.go.parser.GolangParser.CommClauseContext arg) {
		final Node node = new Node("CommClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommCase(com.generator.generators.go.parser.GolangParser.CommCaseContext arg) {
		final Node node = new Node("CommCase", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRecvStmt(com.generator.generators.go.parser.GolangParser.RecvStmtContext arg) {
		final Node node = new Node("RecvStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForStmt(com.generator.generators.go.parser.GolangParser.ForStmtContext arg) {
		final Node node = new Node("ForStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForClause(com.generator.generators.go.parser.GolangParser.ForClauseContext arg) {
		final Node node = new Node("ForClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRangeClause(com.generator.generators.go.parser.GolangParser.RangeClauseContext arg) {
		final Node node = new Node("RangeClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoStmt(com.generator.generators.go.parser.GolangParser.GoStmtContext arg) {
		final Node node = new Node("GoStmt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.go.parser.GolangParser.TypeContext arg) {
		final Node node = new Node("Type", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeName(com.generator.generators.go.parser.GolangParser.TypeNameContext arg) {
		final Node node = new Node("TypeName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeLit(com.generator.generators.go.parser.GolangParser.TypeLitContext arg) {
		final Node node = new Node("TypeLit", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayType(com.generator.generators.go.parser.GolangParser.ArrayTypeContext arg) {
		final Node node = new Node("ArrayType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayLength(com.generator.generators.go.parser.GolangParser.ArrayLengthContext arg) {
		final Node node = new Node("ArrayLength", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementType(com.generator.generators.go.parser.GolangParser.ElementTypeContext arg) {
		final Node node = new Node("ElementType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPointerType(com.generator.generators.go.parser.GolangParser.PointerTypeContext arg) {
		final Node node = new Node("PointerType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceType(com.generator.generators.go.parser.GolangParser.InterfaceTypeContext arg) {
		final Node node = new Node("InterfaceType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSliceType(com.generator.generators.go.parser.GolangParser.SliceTypeContext arg) {
		final Node node = new Node("SliceType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapType(com.generator.generators.go.parser.GolangParser.MapTypeContext arg) {
		final Node node = new Node("MapType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChannelType(com.generator.generators.go.parser.GolangParser.ChannelTypeContext arg) {
		final Node node = new Node("ChannelType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodSpec(com.generator.generators.go.parser.GolangParser.MethodSpecContext arg) {
		final Node node = new Node("MethodSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionType(com.generator.generators.go.parser.GolangParser.FunctionTypeContext arg) {
		final Node node = new Node("FunctionType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSignature(com.generator.generators.go.parser.GolangParser.SignatureContext arg) {
		final Node node = new Node("Signature", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResult(com.generator.generators.go.parser.GolangParser.ResultContext arg) {
		final Node node = new Node("Result", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameters(com.generator.generators.go.parser.GolangParser.ParametersContext arg) {
		final Node node = new Node("Parameters", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterList(com.generator.generators.go.parser.GolangParser.ParameterListContext arg) {
		final Node node = new Node("ParameterList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterDecl(com.generator.generators.go.parser.GolangParser.ParameterDeclContext arg) {
		final Node node = new Node("ParameterDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperand(com.generator.generators.go.parser.GolangParser.OperandContext arg) {
		final Node node = new Node("Operand", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBasicLit(com.generator.generators.go.parser.GolangParser.BasicLitContext arg) {
		final Node node = new Node("BasicLit", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperandName(com.generator.generators.go.parser.GolangParser.OperandNameContext arg) {
		final Node node = new Node("OperandName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedIdent(com.generator.generators.go.parser.GolangParser.QualifiedIdentContext arg) {
		final Node node = new Node("QualifiedIdent", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompositeLit(com.generator.generators.go.parser.GolangParser.CompositeLitContext arg) {
		final Node node = new Node("CompositeLit", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralType(com.generator.generators.go.parser.GolangParser.LiteralTypeContext arg) {
		final Node node = new Node("LiteralType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralValue(com.generator.generators.go.parser.GolangParser.LiteralValueContext arg) {
		final Node node = new Node("LiteralValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyedElement(com.generator.generators.go.parser.GolangParser.KeyedElementContext arg) {
		final Node node = new Node("KeyedElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKey(com.generator.generators.go.parser.GolangParser.KeyContext arg) {
		final Node node = new Node("Key", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStructType(com.generator.generators.go.parser.GolangParser.StructTypeContext arg) {
		final Node node = new Node("StructType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldDecl(com.generator.generators.go.parser.GolangParser.FieldDeclContext arg) {
		final Node node = new Node("FieldDecl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnonymousField(com.generator.generators.go.parser.GolangParser.AnonymousFieldContext arg) {
		final Node node = new Node("AnonymousField", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionLit(com.generator.generators.go.parser.GolangParser.FunctionLitContext arg) {
		final Node node = new Node("FunctionLit", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimaryExpr(com.generator.generators.go.parser.GolangParser.PrimaryExprContext arg) {
		final Node node = new Node("PrimaryExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex(com.generator.generators.go.parser.GolangParser.IndexContext arg) {
		final Node node = new Node("Index", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSlice(com.generator.generators.go.parser.GolangParser.SliceContext arg) {
		final Node node = new Node("Slice", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeAssertion(com.generator.generators.go.parser.GolangParser.TypeAssertionContext arg) {
		final Node node = new Node("TypeAssertion", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodExpr(com.generator.generators.go.parser.GolangParser.MethodExprContext arg) {
		final Node node = new Node("MethodExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReceiverType(com.generator.generators.go.parser.GolangParser.ReceiverTypeContext arg) {
		final Node node = new Node("ReceiverType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryExpr(com.generator.generators.go.parser.GolangParser.UnaryExprContext arg) {
		final Node node = new Node("UnaryExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConversion(com.generator.generators.go.parser.GolangParser.ConversionContext arg) {
		final Node node = new Node("Conversion", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}