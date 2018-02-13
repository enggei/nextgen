package com.generator.generators.go.parser;

import org.neo4j.graphdb.*;

public abstract class GolangDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Element")) visitElement(node);
		else if(hasLabel(node, "Block")) visitBlock(node);
		else if(hasLabel(node, "Expression")) visitExpression(node);
		else if(hasLabel(node, "Statement")) visitStatement(node);
		else if(hasLabel(node, "Declaration")) visitDeclaration(node);
		else if(hasLabel(node, "Literal")) visitLiteral(node);
		else if(hasLabel(node, "Selector")) visitSelector(node);
		else if(hasLabel(node, "Function")) visitFunction(node);
		else if(hasLabel(node, "StatementList")) visitStatementList(node);
		else if(hasLabel(node, "ElementList")) visitElementList(node);
		else if(hasLabel(node, "Arguments")) visitArguments(node);
		else if(hasLabel(node, "Eos")) visitEos(node);
		else if(hasLabel(node, "SourceFile")) visitSourceFile(node);
		else if(hasLabel(node, "PackageClause")) visitPackageClause(node);
		else if(hasLabel(node, "ImportDecl")) visitImportDecl(node);
		else if(hasLabel(node, "ImportSpec")) visitImportSpec(node);
		else if(hasLabel(node, "ImportPath")) visitImportPath(node);
		else if(hasLabel(node, "TopLevelDecl")) visitTopLevelDecl(node);
		else if(hasLabel(node, "ConstDecl")) visitConstDecl(node);
		else if(hasLabel(node, "ConstSpec")) visitConstSpec(node);
		else if(hasLabel(node, "IdentifierList")) visitIdentifierList(node);
		else if(hasLabel(node, "ExpressionList")) visitExpressionList(node);
		else if(hasLabel(node, "TypeDecl")) visitTypeDecl(node);
		else if(hasLabel(node, "TypeSpec")) visitTypeSpec(node);
		else if(hasLabel(node, "FunctionDecl")) visitFunctionDecl(node);
		else if(hasLabel(node, "MethodDecl")) visitMethodDecl(node);
		else if(hasLabel(node, "Receiver")) visitReceiver(node);
		else if(hasLabel(node, "VarDecl")) visitVarDecl(node);
		else if(hasLabel(node, "VarSpec")) visitVarSpec(node);
		else if(hasLabel(node, "SimpleStmt")) visitSimpleStmt(node);
		else if(hasLabel(node, "ExpressionStmt")) visitExpressionStmt(node);
		else if(hasLabel(node, "SendStmt")) visitSendStmt(node);
		else if(hasLabel(node, "IncDecStmt")) visitIncDecStmt(node);
		else if(hasLabel(node, "Assignment")) visitAssignment(node);
		else if(hasLabel(node, "Assign_op")) visitAssign_op(node);
		else if(hasLabel(node, "ShortVarDecl")) visitShortVarDecl(node);
		else if(hasLabel(node, "EmptyStmt")) visitEmptyStmt(node);
		else if(hasLabel(node, "LabeledStmt")) visitLabeledStmt(node);
		else if(hasLabel(node, "ReturnStmt")) visitReturnStmt(node);
		else if(hasLabel(node, "BreakStmt")) visitBreakStmt(node);
		else if(hasLabel(node, "ContinueStmt")) visitContinueStmt(node);
		else if(hasLabel(node, "GotoStmt")) visitGotoStmt(node);
		else if(hasLabel(node, "FallthroughStmt")) visitFallthroughStmt(node);
		else if(hasLabel(node, "DeferStmt")) visitDeferStmt(node);
		else if(hasLabel(node, "IfStmt")) visitIfStmt(node);
		else if(hasLabel(node, "SwitchStmt")) visitSwitchStmt(node);
		else if(hasLabel(node, "ExprSwitchStmt")) visitExprSwitchStmt(node);
		else if(hasLabel(node, "ExprCaseClause")) visitExprCaseClause(node);
		else if(hasLabel(node, "ExprSwitchCase")) visitExprSwitchCase(node);
		else if(hasLabel(node, "TypeSwitchStmt")) visitTypeSwitchStmt(node);
		else if(hasLabel(node, "TypeSwitchGuard")) visitTypeSwitchGuard(node);
		else if(hasLabel(node, "TypeCaseClause")) visitTypeCaseClause(node);
		else if(hasLabel(node, "TypeSwitchCase")) visitTypeSwitchCase(node);
		else if(hasLabel(node, "TypeList")) visitTypeList(node);
		else if(hasLabel(node, "SelectStmt")) visitSelectStmt(node);
		else if(hasLabel(node, "CommClause")) visitCommClause(node);
		else if(hasLabel(node, "CommCase")) visitCommCase(node);
		else if(hasLabel(node, "RecvStmt")) visitRecvStmt(node);
		else if(hasLabel(node, "ForStmt")) visitForStmt(node);
		else if(hasLabel(node, "ForClause")) visitForClause(node);
		else if(hasLabel(node, "RangeClause")) visitRangeClause(node);
		else if(hasLabel(node, "GoStmt")) visitGoStmt(node);
		else if(hasLabel(node, "Type")) visitType(node);
		else if(hasLabel(node, "TypeName")) visitTypeName(node);
		else if(hasLabel(node, "TypeLit")) visitTypeLit(node);
		else if(hasLabel(node, "ArrayType")) visitArrayType(node);
		else if(hasLabel(node, "ArrayLength")) visitArrayLength(node);
		else if(hasLabel(node, "ElementType")) visitElementType(node);
		else if(hasLabel(node, "PointerType")) visitPointerType(node);
		else if(hasLabel(node, "InterfaceType")) visitInterfaceType(node);
		else if(hasLabel(node, "SliceType")) visitSliceType(node);
		else if(hasLabel(node, "MapType")) visitMapType(node);
		else if(hasLabel(node, "ChannelType")) visitChannelType(node);
		else if(hasLabel(node, "MethodSpec")) visitMethodSpec(node);
		else if(hasLabel(node, "FunctionType")) visitFunctionType(node);
		else if(hasLabel(node, "Signature")) visitSignature(node);
		else if(hasLabel(node, "Result")) visitResult(node);
		else if(hasLabel(node, "Parameters")) visitParameters(node);
		else if(hasLabel(node, "ParameterList")) visitParameterList(node);
		else if(hasLabel(node, "ParameterDecl")) visitParameterDecl(node);
		else if(hasLabel(node, "Operand")) visitOperand(node);
		else if(hasLabel(node, "BasicLit")) visitBasicLit(node);
		else if(hasLabel(node, "OperandName")) visitOperandName(node);
		else if(hasLabel(node, "QualifiedIdent")) visitQualifiedIdent(node);
		else if(hasLabel(node, "CompositeLit")) visitCompositeLit(node);
		else if(hasLabel(node, "LiteralType")) visitLiteralType(node);
		else if(hasLabel(node, "LiteralValue")) visitLiteralValue(node);
		else if(hasLabel(node, "KeyedElement")) visitKeyedElement(node);
		else if(hasLabel(node, "Key")) visitKey(node);
		else if(hasLabel(node, "StructType")) visitStructType(node);
		else if(hasLabel(node, "FieldDecl")) visitFieldDecl(node);
		else if(hasLabel(node, "AnonymousField")) visitAnonymousField(node);
		else if(hasLabel(node, "FunctionLit")) visitFunctionLit(node);
		else if(hasLabel(node, "PrimaryExpr")) visitPrimaryExpr(node);
		else if(hasLabel(node, "Index")) visitIndex(node);
		else if(hasLabel(node, "Slice")) visitSlice(node);
		else if(hasLabel(node, "TypeAssertion")) visitTypeAssertion(node);
		else if(hasLabel(node, "MethodExpr")) visitMethodExpr(node);
		else if(hasLabel(node, "ReceiverType")) visitReceiverType(node);
		else if(hasLabel(node, "UnaryExpr")) visitUnaryExpr(node);
		else if(hasLabel(node, "Conversion")) visitConversion(node);
   }

	public void visitElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelector(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatementList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArguments(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEos(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSourceFile(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPackageClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImportDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImportSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImportPath(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTopLevelDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdentifierList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMethodDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReceiver(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVarDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVarSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSendStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIncDecStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssignment(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssign_op(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShortVarDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEmptyStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLabeledStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReturnStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBreakStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitContinueStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGotoStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFallthroughStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeferStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIfStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSwitchStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExprSwitchStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExprCaseClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExprSwitchCase(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeSwitchStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeSwitchGuard(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeCaseClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeSwitchCase(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelectStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCommClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCommCase(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRecvStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRangeClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGoStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeLit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArrayType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArrayLength(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPointerType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterfaceType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSliceType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMapType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitChannelType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMethodSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSignature(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitResult(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameters(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameterList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameterDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOperand(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBasicLit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOperandName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQualifiedIdent(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCompositeLit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteralType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteralValue(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKeyedElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKey(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStructType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFieldDecl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnonymousField(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionLit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrimaryExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIndex(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSlice(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeAssertion(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMethodExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReceiverType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConversion(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	private boolean hasLabel(Node node, String label) {
   	for (org.neo4j.graphdb.Label lbl : node.getLabels())
      	if (lbl.name().equals(label)) return true;
      return false;
   }

	protected Iterable<Relationship> outgoing(Node node, RelationshipType type) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type));
   }

	protected Iterable<Relationship> outgoing(Node node) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING));
   }

	protected static Iterable<Relationship> sort(Iterable<Relationship> relationships) {
		final java.util.Set<Relationship> relations = new java.util.TreeSet<>(java.util.Comparator.comparingLong(Relationship::getId));
		for (Relationship relationship : relationships)
			relations.add(relationship);
		return relations;
	}

	protected Node other(Node node, Relationship relationship) {
     	return relationship == null ? null : relationship.getOtherNode(node);
   }
}