package com.generator.generators.go.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class GolangNeoVisitor extends GolangBaseVisitor<Node> {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(GolangNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public GolangNeoVisitor(com.generator.neo.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
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
		log.info("Element");
		final Node node = model.newNode(Label.label("Element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock(com.generator.generators.go.parser.GolangParser.BlockContext arg) {
		log.info("Block");
		final Node node = model.newNode(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.go.parser.GolangParser.LiteralContext arg) {
		log.info("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclaration(com.generator.generators.go.parser.GolangParser.DeclarationContext arg) {
		log.info("Declaration");
		final Node node = model.newNode(Label.label("Declaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.go.parser.GolangParser.ExpressionContext arg) {
		log.info("Expression");
		final Node node = model.newNode(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatement(com.generator.generators.go.parser.GolangParser.StatementContext arg) {
		log.info("Statement");
		final Node node = model.newNode(Label.label("Statement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelector(com.generator.generators.go.parser.GolangParser.SelectorContext arg) {
		log.info("Selector");
		final Node node = model.newNode(Label.label("Selector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStatementList(com.generator.generators.go.parser.GolangParser.StatementListContext arg) {
		log.info("StatementList");
		final Node node = model.newNode(Label.label("StatementList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction(com.generator.generators.go.parser.GolangParser.FunctionContext arg) {
		log.info("Function");
		final Node node = model.newNode(Label.label("Function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementList(com.generator.generators.go.parser.GolangParser.ElementListContext arg) {
		log.info("ElementList");
		final Node node = model.newNode(Label.label("ElementList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.go.parser.GolangParser.ArgumentsContext arg) {
		log.info("Arguments");
		final Node node = model.newNode(Label.label("Arguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEos(com.generator.generators.go.parser.GolangParser.EosContext arg) {
		log.info("Eos");
		final Node node = model.newNode(Label.label("Eos"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSourceFile(com.generator.generators.go.parser.GolangParser.SourceFileContext arg) {
		log.info("SourceFile");
		final Node node = model.newNode(Label.label("SourceFile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSignature(com.generator.generators.go.parser.GolangParser.SignatureContext arg) {
		log.info("Signature");
		final Node node = model.newNode(Label.label("Signature"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageClause(com.generator.generators.go.parser.GolangParser.PackageClauseContext arg) {
		log.info("PackageClause");
		final Node node = model.newNode(Label.label("PackageClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportDecl(com.generator.generators.go.parser.GolangParser.ImportDeclContext arg) {
		log.info("ImportDecl");
		final Node node = model.newNode(Label.label("ImportDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSpec(com.generator.generators.go.parser.GolangParser.ImportSpecContext arg) {
		log.info("ImportSpec");
		final Node node = model.newNode(Label.label("ImportSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportPath(com.generator.generators.go.parser.GolangParser.ImportPathContext arg) {
		log.info("ImportPath");
		final Node node = model.newNode(Label.label("ImportPath"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopLevelDecl(com.generator.generators.go.parser.GolangParser.TopLevelDeclContext arg) {
		log.info("TopLevelDecl");
		final Node node = model.newNode(Label.label("TopLevelDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstDecl(com.generator.generators.go.parser.GolangParser.ConstDeclContext arg) {
		log.info("ConstDecl");
		final Node node = model.newNode(Label.label("ConstDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstSpec(com.generator.generators.go.parser.GolangParser.ConstSpecContext arg) {
		log.info("ConstSpec");
		final Node node = model.newNode(Label.label("ConstSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifierList(com.generator.generators.go.parser.GolangParser.IdentifierListContext arg) {
		log.info("IdentifierList");
		final Node node = model.newNode(Label.label("IdentifierList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionList(com.generator.generators.go.parser.GolangParser.ExpressionListContext arg) {
		log.info("ExpressionList");
		final Node node = model.newNode(Label.label("ExpressionList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDecl(com.generator.generators.go.parser.GolangParser.TypeDeclContext arg) {
		log.info("TypeDecl");
		final Node node = model.newNode(Label.label("TypeDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSpec(com.generator.generators.go.parser.GolangParser.TypeSpecContext arg) {
		log.info("TypeSpec");
		final Node node = model.newNode(Label.label("TypeSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionDecl(com.generator.generators.go.parser.GolangParser.FunctionDeclContext arg) {
		log.info("FunctionDecl");
		final Node node = model.newNode(Label.label("FunctionDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodDecl(com.generator.generators.go.parser.GolangParser.MethodDeclContext arg) {
		log.info("MethodDecl");
		final Node node = model.newNode(Label.label("MethodDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReceiver(com.generator.generators.go.parser.GolangParser.ReceiverContext arg) {
		log.info("Receiver");
		final Node node = model.newNode(Label.label("Receiver"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDecl(com.generator.generators.go.parser.GolangParser.VarDeclContext arg) {
		log.info("VarDecl");
		final Node node = model.newNode(Label.label("VarDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarSpec(com.generator.generators.go.parser.GolangParser.VarSpecContext arg) {
		log.info("VarSpec");
		final Node node = model.newNode(Label.label("VarSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleStmt(com.generator.generators.go.parser.GolangParser.SimpleStmtContext arg) {
		log.info("SimpleStmt");
		final Node node = model.newNode(Label.label("SimpleStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpressionStmt(com.generator.generators.go.parser.GolangParser.ExpressionStmtContext arg) {
		log.info("ExpressionStmt");
		final Node node = model.newNode(Label.label("ExpressionStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSendStmt(com.generator.generators.go.parser.GolangParser.SendStmtContext arg) {
		log.info("SendStmt");
		final Node node = model.newNode(Label.label("SendStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIncDecStmt(com.generator.generators.go.parser.GolangParser.IncDecStmtContext arg) {
		log.info("IncDecStmt");
		final Node node = model.newNode(Label.label("IncDecStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssignment(com.generator.generators.go.parser.GolangParser.AssignmentContext arg) {
		log.info("Assignment");
		final Node node = model.newNode(Label.label("Assignment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAssign_op(com.generator.generators.go.parser.GolangParser.Assign_opContext arg) {
		log.info("Assign_op");
		final Node node = model.newNode(Label.label("Assign_op"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitShortVarDecl(com.generator.generators.go.parser.GolangParser.ShortVarDeclContext arg) {
		log.info("ShortVarDecl");
		final Node node = model.newNode(Label.label("ShortVarDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEmptyStmt(com.generator.generators.go.parser.GolangParser.EmptyStmtContext arg) {
		log.info("EmptyStmt");
		final Node node = model.newNode(Label.label("EmptyStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabeledStmt(com.generator.generators.go.parser.GolangParser.LabeledStmtContext arg) {
		log.info("LabeledStmt");
		final Node node = model.newNode(Label.label("LabeledStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReturnStmt(com.generator.generators.go.parser.GolangParser.ReturnStmtContext arg) {
		log.info("ReturnStmt");
		final Node node = model.newNode(Label.label("ReturnStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBreakStmt(com.generator.generators.go.parser.GolangParser.BreakStmtContext arg) {
		log.info("BreakStmt");
		final Node node = model.newNode(Label.label("BreakStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContinueStmt(com.generator.generators.go.parser.GolangParser.ContinueStmtContext arg) {
		log.info("ContinueStmt");
		final Node node = model.newNode(Label.label("ContinueStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGotoStmt(com.generator.generators.go.parser.GolangParser.GotoStmtContext arg) {
		log.info("GotoStmt");
		final Node node = model.newNode(Label.label("GotoStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFallthroughStmt(com.generator.generators.go.parser.GolangParser.FallthroughStmtContext arg) {
		log.info("FallthroughStmt");
		final Node node = model.newNode(Label.label("FallthroughStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeferStmt(com.generator.generators.go.parser.GolangParser.DeferStmtContext arg) {
		log.info("DeferStmt");
		final Node node = model.newNode(Label.label("DeferStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfStmt(com.generator.generators.go.parser.GolangParser.IfStmtContext arg) {
		log.info("IfStmt");
		final Node node = model.newNode(Label.label("IfStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSwitchStmt(com.generator.generators.go.parser.GolangParser.SwitchStmtContext arg) {
		log.info("SwitchStmt");
		final Node node = model.newNode(Label.label("SwitchStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprSwitchStmt(com.generator.generators.go.parser.GolangParser.ExprSwitchStmtContext arg) {
		log.info("ExprSwitchStmt");
		final Node node = model.newNode(Label.label("ExprSwitchStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprCaseClause(com.generator.generators.go.parser.GolangParser.ExprCaseClauseContext arg) {
		log.info("ExprCaseClause");
		final Node node = model.newNode(Label.label("ExprCaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprSwitchCase(com.generator.generators.go.parser.GolangParser.ExprSwitchCaseContext arg) {
		log.info("ExprSwitchCase");
		final Node node = model.newNode(Label.label("ExprSwitchCase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchStmt(com.generator.generators.go.parser.GolangParser.TypeSwitchStmtContext arg) {
		log.info("TypeSwitchStmt");
		final Node node = model.newNode(Label.label("TypeSwitchStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchGuard(com.generator.generators.go.parser.GolangParser.TypeSwitchGuardContext arg) {
		log.info("TypeSwitchGuard");
		final Node node = model.newNode(Label.label("TypeSwitchGuard"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeCaseClause(com.generator.generators.go.parser.GolangParser.TypeCaseClauseContext arg) {
		log.info("TypeCaseClause");
		final Node node = model.newNode(Label.label("TypeCaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSwitchCase(com.generator.generators.go.parser.GolangParser.TypeSwitchCaseContext arg) {
		log.info("TypeSwitchCase");
		final Node node = model.newNode(Label.label("TypeSwitchCase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeList(com.generator.generators.go.parser.GolangParser.TypeListContext arg) {
		log.info("TypeList");
		final Node node = model.newNode(Label.label("TypeList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectStmt(com.generator.generators.go.parser.GolangParser.SelectStmtContext arg) {
		log.info("SelectStmt");
		final Node node = model.newNode(Label.label("SelectStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommClause(com.generator.generators.go.parser.GolangParser.CommClauseContext arg) {
		log.info("CommClause");
		final Node node = model.newNode(Label.label("CommClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCommCase(com.generator.generators.go.parser.GolangParser.CommCaseContext arg) {
		log.info("CommCase");
		final Node node = model.newNode(Label.label("CommCase"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRecvStmt(com.generator.generators.go.parser.GolangParser.RecvStmtContext arg) {
		log.info("RecvStmt");
		final Node node = model.newNode(Label.label("RecvStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForStmt(com.generator.generators.go.parser.GolangParser.ForStmtContext arg) {
		log.info("ForStmt");
		final Node node = model.newNode(Label.label("ForStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForClause(com.generator.generators.go.parser.GolangParser.ForClauseContext arg) {
		log.info("ForClause");
		final Node node = model.newNode(Label.label("ForClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRangeClause(com.generator.generators.go.parser.GolangParser.RangeClauseContext arg) {
		log.info("RangeClause");
		final Node node = model.newNode(Label.label("RangeClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoStmt(com.generator.generators.go.parser.GolangParser.GoStmtContext arg) {
		log.info("GoStmt");
		final Node node = model.newNode(Label.label("GoStmt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.go.parser.GolangParser.TypeContext arg) {
		log.info("Type");
		final Node node = model.newNode(Label.label("Type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeName(com.generator.generators.go.parser.GolangParser.TypeNameContext arg) {
		log.info("TypeName");
		final Node node = model.newNode(Label.label("TypeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeLit(com.generator.generators.go.parser.GolangParser.TypeLitContext arg) {
		log.info("TypeLit");
		final Node node = model.newNode(Label.label("TypeLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayType(com.generator.generators.go.parser.GolangParser.ArrayTypeContext arg) {
		log.info("ArrayType");
		final Node node = model.newNode(Label.label("ArrayType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayLength(com.generator.generators.go.parser.GolangParser.ArrayLengthContext arg) {
		log.info("ArrayLength");
		final Node node = model.newNode(Label.label("ArrayLength"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementType(com.generator.generators.go.parser.GolangParser.ElementTypeContext arg) {
		log.info("ElementType");
		final Node node = model.newNode(Label.label("ElementType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPointerType(com.generator.generators.go.parser.GolangParser.PointerTypeContext arg) {
		log.info("PointerType");
		final Node node = model.newNode(Label.label("PointerType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInterfaceType(com.generator.generators.go.parser.GolangParser.InterfaceTypeContext arg) {
		log.info("InterfaceType");
		final Node node = model.newNode(Label.label("InterfaceType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSliceType(com.generator.generators.go.parser.GolangParser.SliceTypeContext arg) {
		log.info("SliceType");
		final Node node = model.newNode(Label.label("SliceType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapType(com.generator.generators.go.parser.GolangParser.MapTypeContext arg) {
		log.info("MapType");
		final Node node = model.newNode(Label.label("MapType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChannelType(com.generator.generators.go.parser.GolangParser.ChannelTypeContext arg) {
		log.info("ChannelType");
		final Node node = model.newNode(Label.label("ChannelType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodSpec(com.generator.generators.go.parser.GolangParser.MethodSpecContext arg) {
		log.info("MethodSpec");
		final Node node = model.newNode(Label.label("MethodSpec"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionType(com.generator.generators.go.parser.GolangParser.FunctionTypeContext arg) {
		log.info("FunctionType");
		final Node node = model.newNode(Label.label("FunctionType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResult(com.generator.generators.go.parser.GolangParser.ResultContext arg) {
		log.info("Result");
		final Node node = model.newNode(Label.label("Result"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameters(com.generator.generators.go.parser.GolangParser.ParametersContext arg) {
		log.info("Parameters");
		final Node node = model.newNode(Label.label("Parameters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterList(com.generator.generators.go.parser.GolangParser.ParameterListContext arg) {
		log.info("ParameterList");
		final Node node = model.newNode(Label.label("ParameterList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParameterDecl(com.generator.generators.go.parser.GolangParser.ParameterDeclContext arg) {
		log.info("ParameterDecl");
		final Node node = model.newNode(Label.label("ParameterDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperand(com.generator.generators.go.parser.GolangParser.OperandContext arg) {
		log.info("Operand");
		final Node node = model.newNode(Label.label("Operand"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBasicLit(com.generator.generators.go.parser.GolangParser.BasicLitContext arg) {
		log.info("BasicLit");
		final Node node = model.newNode(Label.label("BasicLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperandName(com.generator.generators.go.parser.GolangParser.OperandNameContext arg) {
		log.info("OperandName");
		final Node node = model.newNode(Label.label("OperandName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualifiedIdent(com.generator.generators.go.parser.GolangParser.QualifiedIdentContext arg) {
		log.info("QualifiedIdent");
		final Node node = model.newNode(Label.label("QualifiedIdent"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompositeLit(com.generator.generators.go.parser.GolangParser.CompositeLitContext arg) {
		log.info("CompositeLit");
		final Node node = model.newNode(Label.label("CompositeLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralType(com.generator.generators.go.parser.GolangParser.LiteralTypeContext arg) {
		log.info("LiteralType");
		final Node node = model.newNode(Label.label("LiteralType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteralValue(com.generator.generators.go.parser.GolangParser.LiteralValueContext arg) {
		log.info("LiteralValue");
		final Node node = model.newNode(Label.label("LiteralValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyedElement(com.generator.generators.go.parser.GolangParser.KeyedElementContext arg) {
		log.info("KeyedElement");
		final Node node = model.newNode(Label.label("KeyedElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKey(com.generator.generators.go.parser.GolangParser.KeyContext arg) {
		log.info("Key");
		final Node node = model.newNode(Label.label("Key"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStructType(com.generator.generators.go.parser.GolangParser.StructTypeContext arg) {
		log.info("StructType");
		final Node node = model.newNode(Label.label("StructType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldDecl(com.generator.generators.go.parser.GolangParser.FieldDeclContext arg) {
		log.info("FieldDecl");
		final Node node = model.newNode(Label.label("FieldDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnonymousField(com.generator.generators.go.parser.GolangParser.AnonymousFieldContext arg) {
		log.info("AnonymousField");
		final Node node = model.newNode(Label.label("AnonymousField"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionLit(com.generator.generators.go.parser.GolangParser.FunctionLitContext arg) {
		log.info("FunctionLit");
		final Node node = model.newNode(Label.label("FunctionLit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimaryExpr(com.generator.generators.go.parser.GolangParser.PrimaryExprContext arg) {
		log.info("PrimaryExpr");
		final Node node = model.newNode(Label.label("PrimaryExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIndex(com.generator.generators.go.parser.GolangParser.IndexContext arg) {
		log.info("Index");
		final Node node = model.newNode(Label.label("Index"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSlice(com.generator.generators.go.parser.GolangParser.SliceContext arg) {
		log.info("Slice");
		final Node node = model.newNode(Label.label("Slice"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeAssertion(com.generator.generators.go.parser.GolangParser.TypeAssertionContext arg) {
		log.info("TypeAssertion");
		final Node node = model.newNode(Label.label("TypeAssertion"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMethodExpr(com.generator.generators.go.parser.GolangParser.MethodExprContext arg) {
		log.info("MethodExpr");
		final Node node = model.newNode(Label.label("MethodExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReceiverType(com.generator.generators.go.parser.GolangParser.ReceiverTypeContext arg) {
		log.info("ReceiverType");
		final Node node = model.newNode(Label.label("ReceiverType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnaryExpr(com.generator.generators.go.parser.GolangParser.UnaryExprContext arg) {
		log.info("UnaryExpr");
		final Node node = model.newNode(Label.label("UnaryExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConversion(com.generator.generators.go.parser.GolangParser.ConversionContext arg) {
		log.info("Conversion");
		final Node node = model.newNode(Label.label("Conversion"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}