package com.generator.generators.go.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class GolangNeoVisitor extends GolangBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public GolangNeoVisitor(com.generator.neo.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.neo.BaseDomainVisitor.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitElement(com.generator.generators.go.parser.GolangParser.ElementContext arg) {
		System.out.println("Element");
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock(com.generator.generators.go.parser.GolangParser.BlockContext arg) {
		System.out.println("Block");
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.go.parser.GolangParser.ExpressionContext arg) {
		System.out.println("Expression");
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.go.parser.GolangParser.StatementContext arg) {
		System.out.println("Statement");
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclaration(com.generator.generators.go.parser.GolangParser.DeclarationContext arg) {
		System.out.println("Declaration");
		final Node node = model.findOrCreate(Label.label("Declaration"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.go.parser.GolangParser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelector(com.generator.generators.go.parser.GolangParser.SelectorContext arg) {
		System.out.println("Selector");
		final Node node = model.findOrCreate(Label.label("Selector"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction(com.generator.generators.go.parser.GolangParser.FunctionContext arg) {
		System.out.println("Function");
		final Node node = model.findOrCreate(Label.label("Function"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatementList(com.generator.generators.go.parser.GolangParser.StatementListContext arg) {
		System.out.println("StatementList");
		final Node node = model.findOrCreate(Label.label("StatementList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementList(com.generator.generators.go.parser.GolangParser.ElementListContext arg) {
		System.out.println("ElementList");
		final Node node = model.findOrCreate(Label.label("ElementList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.go.parser.GolangParser.ArgumentsContext arg) {
		System.out.println("Arguments");
		final Node node = model.findOrCreate(Label.label("Arguments"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEos(com.generator.generators.go.parser.GolangParser.EosContext arg) {
		System.out.println("Eos");
		final Node node = model.findOrCreate(Label.label("Eos"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceFile(com.generator.generators.go.parser.GolangParser.SourceFileContext arg) {
		System.out.println("SourceFile");
		final Node node = model.findOrCreate(Label.label("SourceFile"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageClause(com.generator.generators.go.parser.GolangParser.PackageClauseContext arg) {
		System.out.println("PackageClause");
		final Node node = model.findOrCreate(Label.label("PackageClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportDecl(com.generator.generators.go.parser.GolangParser.ImportDeclContext arg) {
		System.out.println("ImportDecl");
		final Node node = model.findOrCreate(Label.label("ImportDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSpec(com.generator.generators.go.parser.GolangParser.ImportSpecContext arg) {
		System.out.println("ImportSpec");
		final Node node = model.findOrCreate(Label.label("ImportSpec"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportPath(com.generator.generators.go.parser.GolangParser.ImportPathContext arg) {
		System.out.println("ImportPath");
		final Node node = model.findOrCreate(Label.label("ImportPath"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopLevelDecl(com.generator.generators.go.parser.GolangParser.TopLevelDeclContext arg) {
		System.out.println("TopLevelDecl");
		final Node node = model.findOrCreate(Label.label("TopLevelDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstDecl(com.generator.generators.go.parser.GolangParser.ConstDeclContext arg) {
		System.out.println("ConstDecl");
		final Node node = model.findOrCreate(Label.label("ConstDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstSpec(com.generator.generators.go.parser.GolangParser.ConstSpecContext arg) {
		System.out.println("ConstSpec");
		final Node node = model.findOrCreate(Label.label("ConstSpec"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifierList(com.generator.generators.go.parser.GolangParser.IdentifierListContext arg) {
		System.out.println("IdentifierList");
		final Node node = model.findOrCreate(Label.label("IdentifierList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionList(com.generator.generators.go.parser.GolangParser.ExpressionListContext arg) {
		System.out.println("ExpressionList");
		final Node node = model.findOrCreate(Label.label("ExpressionList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDecl(com.generator.generators.go.parser.GolangParser.TypeDeclContext arg) {
		System.out.println("TypeDecl");
		final Node node = model.findOrCreate(Label.label("TypeDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSpec(com.generator.generators.go.parser.GolangParser.TypeSpecContext arg) {
		System.out.println("TypeSpec");
		final Node node = model.findOrCreate(Label.label("TypeSpec"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionDecl(com.generator.generators.go.parser.GolangParser.FunctionDeclContext arg) {
		System.out.println("FunctionDecl");
		final Node node = model.findOrCreate(Label.label("FunctionDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodDecl(com.generator.generators.go.parser.GolangParser.MethodDeclContext arg) {
		System.out.println("MethodDecl");
		final Node node = model.findOrCreate(Label.label("MethodDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReceiver(com.generator.generators.go.parser.GolangParser.ReceiverContext arg) {
		System.out.println("Receiver");
		final Node node = model.findOrCreate(Label.label("Receiver"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDecl(com.generator.generators.go.parser.GolangParser.VarDeclContext arg) {
		System.out.println("VarDecl");
		final Node node = model.findOrCreate(Label.label("VarDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarSpec(com.generator.generators.go.parser.GolangParser.VarSpecContext arg) {
		System.out.println("VarSpec");
		final Node node = model.findOrCreate(Label.label("VarSpec"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleStmt(com.generator.generators.go.parser.GolangParser.SimpleStmtContext arg) {
		System.out.println("SimpleStmt");
		final Node node = model.findOrCreate(Label.label("SimpleStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionStmt(com.generator.generators.go.parser.GolangParser.ExpressionStmtContext arg) {
		System.out.println("ExpressionStmt");
		final Node node = model.findOrCreate(Label.label("ExpressionStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSendStmt(com.generator.generators.go.parser.GolangParser.SendStmtContext arg) {
		System.out.println("SendStmt");
		final Node node = model.findOrCreate(Label.label("SendStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIncDecStmt(com.generator.generators.go.parser.GolangParser.IncDecStmtContext arg) {
		System.out.println("IncDecStmt");
		final Node node = model.findOrCreate(Label.label("IncDecStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignment(com.generator.generators.go.parser.GolangParser.AssignmentContext arg) {
		System.out.println("Assignment");
		final Node node = model.findOrCreate(Label.label("Assignment"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssign_op(com.generator.generators.go.parser.GolangParser.Assign_opContext arg) {
		System.out.println("Assign_op");
		final Node node = model.findOrCreate(Label.label("Assign_op"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShortVarDecl(com.generator.generators.go.parser.GolangParser.ShortVarDeclContext arg) {
		System.out.println("ShortVarDecl");
		final Node node = model.findOrCreate(Label.label("ShortVarDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmptyStmt(com.generator.generators.go.parser.GolangParser.EmptyStmtContext arg) {
		System.out.println("EmptyStmt");
		final Node node = model.findOrCreate(Label.label("EmptyStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabeledStmt(com.generator.generators.go.parser.GolangParser.LabeledStmtContext arg) {
		System.out.println("LabeledStmt");
		final Node node = model.findOrCreate(Label.label("LabeledStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnStmt(com.generator.generators.go.parser.GolangParser.ReturnStmtContext arg) {
		System.out.println("ReturnStmt");
		final Node node = model.findOrCreate(Label.label("ReturnStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreakStmt(com.generator.generators.go.parser.GolangParser.BreakStmtContext arg) {
		System.out.println("BreakStmt");
		final Node node = model.findOrCreate(Label.label("BreakStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinueStmt(com.generator.generators.go.parser.GolangParser.ContinueStmtContext arg) {
		System.out.println("ContinueStmt");
		final Node node = model.findOrCreate(Label.label("ContinueStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGotoStmt(com.generator.generators.go.parser.GolangParser.GotoStmtContext arg) {
		System.out.println("GotoStmt");
		final Node node = model.findOrCreate(Label.label("GotoStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFallthroughStmt(com.generator.generators.go.parser.GolangParser.FallthroughStmtContext arg) {
		System.out.println("FallthroughStmt");
		final Node node = model.findOrCreate(Label.label("FallthroughStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeferStmt(com.generator.generators.go.parser.GolangParser.DeferStmtContext arg) {
		System.out.println("DeferStmt");
		final Node node = model.findOrCreate(Label.label("DeferStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfStmt(com.generator.generators.go.parser.GolangParser.IfStmtContext arg) {
		System.out.println("IfStmt");
		final Node node = model.findOrCreate(Label.label("IfStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchStmt(com.generator.generators.go.parser.GolangParser.SwitchStmtContext arg) {
		System.out.println("SwitchStmt");
		final Node node = model.findOrCreate(Label.label("SwitchStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprSwitchStmt(com.generator.generators.go.parser.GolangParser.ExprSwitchStmtContext arg) {
		System.out.println("ExprSwitchStmt");
		final Node node = model.findOrCreate(Label.label("ExprSwitchStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprCaseClause(com.generator.generators.go.parser.GolangParser.ExprCaseClauseContext arg) {
		System.out.println("ExprCaseClause");
		final Node node = model.findOrCreate(Label.label("ExprCaseClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprSwitchCase(com.generator.generators.go.parser.GolangParser.ExprSwitchCaseContext arg) {
		System.out.println("ExprSwitchCase");
		final Node node = model.findOrCreate(Label.label("ExprSwitchCase"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchStmt(com.generator.generators.go.parser.GolangParser.TypeSwitchStmtContext arg) {
		System.out.println("TypeSwitchStmt");
		final Node node = model.findOrCreate(Label.label("TypeSwitchStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchGuard(com.generator.generators.go.parser.GolangParser.TypeSwitchGuardContext arg) {
		System.out.println("TypeSwitchGuard");
		final Node node = model.findOrCreate(Label.label("TypeSwitchGuard"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeCaseClause(com.generator.generators.go.parser.GolangParser.TypeCaseClauseContext arg) {
		System.out.println("TypeCaseClause");
		final Node node = model.findOrCreate(Label.label("TypeCaseClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchCase(com.generator.generators.go.parser.GolangParser.TypeSwitchCaseContext arg) {
		System.out.println("TypeSwitchCase");
		final Node node = model.findOrCreate(Label.label("TypeSwitchCase"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeList(com.generator.generators.go.parser.GolangParser.TypeListContext arg) {
		System.out.println("TypeList");
		final Node node = model.findOrCreate(Label.label("TypeList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectStmt(com.generator.generators.go.parser.GolangParser.SelectStmtContext arg) {
		System.out.println("SelectStmt");
		final Node node = model.findOrCreate(Label.label("SelectStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommClause(com.generator.generators.go.parser.GolangParser.CommClauseContext arg) {
		System.out.println("CommClause");
		final Node node = model.findOrCreate(Label.label("CommClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommCase(com.generator.generators.go.parser.GolangParser.CommCaseContext arg) {
		System.out.println("CommCase");
		final Node node = model.findOrCreate(Label.label("CommCase"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRecvStmt(com.generator.generators.go.parser.GolangParser.RecvStmtContext arg) {
		System.out.println("RecvStmt");
		final Node node = model.findOrCreate(Label.label("RecvStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForStmt(com.generator.generators.go.parser.GolangParser.ForStmtContext arg) {
		System.out.println("ForStmt");
		final Node node = model.findOrCreate(Label.label("ForStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForClause(com.generator.generators.go.parser.GolangParser.ForClauseContext arg) {
		System.out.println("ForClause");
		final Node node = model.findOrCreate(Label.label("ForClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRangeClause(com.generator.generators.go.parser.GolangParser.RangeClauseContext arg) {
		System.out.println("RangeClause");
		final Node node = model.findOrCreate(Label.label("RangeClause"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoStmt(com.generator.generators.go.parser.GolangParser.GoStmtContext arg) {
		System.out.println("GoStmt");
		final Node node = model.findOrCreate(Label.label("GoStmt"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.go.parser.GolangParser.TypeContext arg) {
		System.out.println("Type");
		final Node node = model.findOrCreate(Label.label("Type"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeName(com.generator.generators.go.parser.GolangParser.TypeNameContext arg) {
		System.out.println("TypeName");
		final Node node = model.findOrCreate(Label.label("TypeName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeLit(com.generator.generators.go.parser.GolangParser.TypeLitContext arg) {
		System.out.println("TypeLit");
		final Node node = model.findOrCreate(Label.label("TypeLit"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayType(com.generator.generators.go.parser.GolangParser.ArrayTypeContext arg) {
		System.out.println("ArrayType");
		final Node node = model.findOrCreate(Label.label("ArrayType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayLength(com.generator.generators.go.parser.GolangParser.ArrayLengthContext arg) {
		System.out.println("ArrayLength");
		final Node node = model.findOrCreate(Label.label("ArrayLength"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementType(com.generator.generators.go.parser.GolangParser.ElementTypeContext arg) {
		System.out.println("ElementType");
		final Node node = model.findOrCreate(Label.label("ElementType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPointerType(com.generator.generators.go.parser.GolangParser.PointerTypeContext arg) {
		System.out.println("PointerType");
		final Node node = model.findOrCreate(Label.label("PointerType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceType(com.generator.generators.go.parser.GolangParser.InterfaceTypeContext arg) {
		System.out.println("InterfaceType");
		final Node node = model.findOrCreate(Label.label("InterfaceType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSliceType(com.generator.generators.go.parser.GolangParser.SliceTypeContext arg) {
		System.out.println("SliceType");
		final Node node = model.findOrCreate(Label.label("SliceType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapType(com.generator.generators.go.parser.GolangParser.MapTypeContext arg) {
		System.out.println("MapType");
		final Node node = model.findOrCreate(Label.label("MapType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChannelType(com.generator.generators.go.parser.GolangParser.ChannelTypeContext arg) {
		System.out.println("ChannelType");
		final Node node = model.findOrCreate(Label.label("ChannelType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodSpec(com.generator.generators.go.parser.GolangParser.MethodSpecContext arg) {
		System.out.println("MethodSpec");
		final Node node = model.findOrCreate(Label.label("MethodSpec"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionType(com.generator.generators.go.parser.GolangParser.FunctionTypeContext arg) {
		System.out.println("FunctionType");
		final Node node = model.findOrCreate(Label.label("FunctionType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSignature(com.generator.generators.go.parser.GolangParser.SignatureContext arg) {
		System.out.println("Signature");
		final Node node = model.findOrCreate(Label.label("Signature"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResult(com.generator.generators.go.parser.GolangParser.ResultContext arg) {
		System.out.println("Result");
		final Node node = model.findOrCreate(Label.label("Result"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameters(com.generator.generators.go.parser.GolangParser.ParametersContext arg) {
		System.out.println("Parameters");
		final Node node = model.findOrCreate(Label.label("Parameters"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterList(com.generator.generators.go.parser.GolangParser.ParameterListContext arg) {
		System.out.println("ParameterList");
		final Node node = model.findOrCreate(Label.label("ParameterList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterDecl(com.generator.generators.go.parser.GolangParser.ParameterDeclContext arg) {
		System.out.println("ParameterDecl");
		final Node node = model.findOrCreate(Label.label("ParameterDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperand(com.generator.generators.go.parser.GolangParser.OperandContext arg) {
		System.out.println("Operand");
		final Node node = model.findOrCreate(Label.label("Operand"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBasicLit(com.generator.generators.go.parser.GolangParser.BasicLitContext arg) {
		System.out.println("BasicLit");
		final Node node = model.findOrCreate(Label.label("BasicLit"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperandName(com.generator.generators.go.parser.GolangParser.OperandNameContext arg) {
		System.out.println("OperandName");
		final Node node = model.findOrCreate(Label.label("OperandName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedIdent(com.generator.generators.go.parser.GolangParser.QualifiedIdentContext arg) {
		System.out.println("QualifiedIdent");
		final Node node = model.findOrCreate(Label.label("QualifiedIdent"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompositeLit(com.generator.generators.go.parser.GolangParser.CompositeLitContext arg) {
		System.out.println("CompositeLit");
		final Node node = model.findOrCreate(Label.label("CompositeLit"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralType(com.generator.generators.go.parser.GolangParser.LiteralTypeContext arg) {
		System.out.println("LiteralType");
		final Node node = model.findOrCreate(Label.label("LiteralType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralValue(com.generator.generators.go.parser.GolangParser.LiteralValueContext arg) {
		System.out.println("LiteralValue");
		final Node node = model.findOrCreate(Label.label("LiteralValue"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyedElement(com.generator.generators.go.parser.GolangParser.KeyedElementContext arg) {
		System.out.println("KeyedElement");
		final Node node = model.findOrCreate(Label.label("KeyedElement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKey(com.generator.generators.go.parser.GolangParser.KeyContext arg) {
		System.out.println("Key");
		final Node node = model.findOrCreate(Label.label("Key"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStructType(com.generator.generators.go.parser.GolangParser.StructTypeContext arg) {
		System.out.println("StructType");
		final Node node = model.findOrCreate(Label.label("StructType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldDecl(com.generator.generators.go.parser.GolangParser.FieldDeclContext arg) {
		System.out.println("FieldDecl");
		final Node node = model.findOrCreate(Label.label("FieldDecl"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnonymousField(com.generator.generators.go.parser.GolangParser.AnonymousFieldContext arg) {
		System.out.println("AnonymousField");
		final Node node = model.findOrCreate(Label.label("AnonymousField"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionLit(com.generator.generators.go.parser.GolangParser.FunctionLitContext arg) {
		System.out.println("FunctionLit");
		final Node node = model.findOrCreate(Label.label("FunctionLit"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimaryExpr(com.generator.generators.go.parser.GolangParser.PrimaryExprContext arg) {
		System.out.println("PrimaryExpr");
		final Node node = model.findOrCreate(Label.label("PrimaryExpr"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex(com.generator.generators.go.parser.GolangParser.IndexContext arg) {
		System.out.println("Index");
		final Node node = model.findOrCreate(Label.label("Index"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSlice(com.generator.generators.go.parser.GolangParser.SliceContext arg) {
		System.out.println("Slice");
		final Node node = model.findOrCreate(Label.label("Slice"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeAssertion(com.generator.generators.go.parser.GolangParser.TypeAssertionContext arg) {
		System.out.println("TypeAssertion");
		final Node node = model.findOrCreate(Label.label("TypeAssertion"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodExpr(com.generator.generators.go.parser.GolangParser.MethodExprContext arg) {
		System.out.println("MethodExpr");
		final Node node = model.findOrCreate(Label.label("MethodExpr"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReceiverType(com.generator.generators.go.parser.GolangParser.ReceiverTypeContext arg) {
		System.out.println("ReceiverType");
		final Node node = model.findOrCreate(Label.label("ReceiverType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryExpr(com.generator.generators.go.parser.GolangParser.UnaryExprContext arg) {
		System.out.println("UnaryExpr");
		final Node node = model.findOrCreate(Label.label("UnaryExpr"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConversion(com.generator.generators.go.parser.GolangParser.ConversionContext arg) {
		System.out.println("Conversion");
		final Node node = model.findOrCreate(Label.label("Conversion"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}