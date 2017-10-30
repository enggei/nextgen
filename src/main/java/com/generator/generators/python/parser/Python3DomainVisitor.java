package com.generator.generators.python.parser;

import org.neo4j.graphdb.*;

public abstract class Python3DomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Del_stmt")) visitDel_stmt(node);
		else if(hasLabel(node, "Pass_stmt")) visitPass_stmt(node);
		else if(hasLabel(node, "Flow_stmt")) visitFlow_stmt(node);
		else if(hasLabel(node, "Break_stmt")) visitBreak_stmt(node);
		else if(hasLabel(node, "Continue_stmt")) visitContinue_stmt(node);
		else if(hasLabel(node, "Return_stmt")) visitReturn_stmt(node);
		else if(hasLabel(node, "Yield_stmt")) visitYield_stmt(node);
		else if(hasLabel(node, "Raise_stmt")) visitRaise_stmt(node);
		else if(hasLabel(node, "Import_stmt")) visitImport_stmt(node);
		else if(hasLabel(node, "Import_name")) visitImport_name(node);
		else if(hasLabel(node, "Import_from")) visitImport_from(node);
		else if(hasLabel(node, "Import_as_name")) visitImport_as_name(node);
		else if(hasLabel(node, "Dotted_as_name")) visitDotted_as_name(node);
		else if(hasLabel(node, "Import_as_names")) visitImport_as_names(node);
		else if(hasLabel(node, "Dotted_as_names")) visitDotted_as_names(node);
		else if(hasLabel(node, "Dotted_name")) visitDotted_name(node);
		else if(hasLabel(node, "Global_stmt")) visitGlobal_stmt(node);
		else if(hasLabel(node, "Nonlocal_stmt")) visitNonlocal_stmt(node);
		else if(hasLabel(node, "Assert_stmt")) visitAssert_stmt(node);
		else if(hasLabel(node, "Compound_stmt")) visitCompound_stmt(node);
		else if(hasLabel(node, "If_stmt")) visitIf_stmt(node);
		else if(hasLabel(node, "While_stmt")) visitWhile_stmt(node);
		else if(hasLabel(node, "For_stmt")) visitFor_stmt(node);
		else if(hasLabel(node, "Try_stmt")) visitTry_stmt(node);
		else if(hasLabel(node, "With_stmt")) visitWith_stmt(node);
		else if(hasLabel(node, "With_item")) visitWith_item(node);
		else if(hasLabel(node, "Except_clause")) visitExcept_clause(node);
		else if(hasLabel(node, "Suite")) visitSuite(node);
		else if(hasLabel(node, "Test")) visitTest(node);
		else if(hasLabel(node, "Test_nocond")) visitTest_nocond(node);
		else if(hasLabel(node, "Lambdef")) visitLambdef(node);
		else if(hasLabel(node, "Lambdef_nocond")) visitLambdef_nocond(node);
		else if(hasLabel(node, "Or_test")) visitOr_test(node);
		else if(hasLabel(node, "And_test")) visitAnd_test(node);
		else if(hasLabel(node, "Not_test")) visitNot_test(node);
		else if(hasLabel(node, "Comparison")) visitComparison(node);
		else if(hasLabel(node, "Comp_op")) visitComp_op(node);
		else if(hasLabel(node, "Star_expr")) visitStar_expr(node);
		else if(hasLabel(node, "Xor_expr")) visitXor_expr(node);
		else if(hasLabel(node, "And_expr")) visitAnd_expr(node);
		else if(hasLabel(node, "Shift_expr")) visitShift_expr(node);
		else if(hasLabel(node, "Arith_expr")) visitArith_expr(node);
		else if(hasLabel(node, "Term")) visitTerm(node);
		else if(hasLabel(node, "Factor")) visitFactor(node);
		else if(hasLabel(node, "Power")) visitPower(node);
		else if(hasLabel(node, "Testlist_comp")) visitTestlist_comp(node);
		else if(hasLabel(node, "Trailer")) visitTrailer(node);
		else if(hasLabel(node, "Subscriptlist")) visitSubscriptlist(node);
		else if(hasLabel(node, "Subscript")) visitSubscript(node);
		else if(hasLabel(node, "Sliceop")) visitSliceop(node);
		else if(hasLabel(node, "Exprlist")) visitExprlist(node);
		else if(hasLabel(node, "Testlist")) visitTestlist(node);
		else if(hasLabel(node, "Dictorsetmaker")) visitDictorsetmaker(node);
		else if(hasLabel(node, "Classdef")) visitClassdef(node);
		else if(hasLabel(node, "Arglist")) visitArglist(node);
		else if(hasLabel(node, "Argument")) visitArgument(node);
		else if(hasLabel(node, "Comp_iter")) visitComp_iter(node);
		else if(hasLabel(node, "Comp_for")) visitComp_for(node);
		else if(hasLabel(node, "Comp_if")) visitComp_if(node);
		else if(hasLabel(node, "Yield_expr")) visitYield_expr(node);
		else if(hasLabel(node, "Yield_arg")) visitYield_arg(node);
		else if(hasLabel(node, "Str")) visitStr(node);
		else if(hasLabel(node, "Integer")) visitInteger(node);
		else if(hasLabel(node, "Single_input")) visitSingle_input(node);
		else if(hasLabel(node, "File_input")) visitFile_input(node);
		else if(hasLabel(node, "Eval_input")) visitEval_input(node);
		else if(hasLabel(node, "Decorator")) visitDecorator(node);
		else if(hasLabel(node, "Decorators")) visitDecorators(node);
		else if(hasLabel(node, "Decorated")) visitDecorated(node);
		else if(hasLabel(node, "Funcdef")) visitFuncdef(node);
		else if(hasLabel(node, "Typedargslist")) visitTypedargslist(node);
		else if(hasLabel(node, "Tfpdef")) visitTfpdef(node);
		else if(hasLabel(node, "Varargslist")) visitVarargslist(node);
		else if(hasLabel(node, "Vfpdef")) visitVfpdef(node);
		else if(hasLabel(node, "Stmt")) visitStmt(node);
		else if(hasLabel(node, "Simple_stmt")) visitSimple_stmt(node);
		else if(hasLabel(node, "Small_stmt")) visitSmall_stmt(node);
		else if(hasLabel(node, "Print_stmt")) visitPrint_stmt(node);
		else if(hasLabel(node, "Expr_stmt")) visitExpr_stmt(node);
		else if(hasLabel(node, "Testlist_star_expr")) visitTestlist_star_expr(node);
		else if(hasLabel(node, "Augassign")) visitAugassign(node);
		else if(hasLabel(node, "Atom")) visitAtom(node);
		else if(hasLabel(node, "Number")) visitNumber(node);
		else if(hasLabel(node, "Expr")) visitExpr(node);
		else if(hasLabel(node, "Parameters")) visitParameters(node);
   }

	public void visitDel_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPass_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFlow_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBreak_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitContinue_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitReturn_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitYield_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRaise_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImport_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImport_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImport_from(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImport_as_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDotted_as_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImport_as_names(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDotted_as_names(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDotted_name(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGlobal_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNonlocal_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssert_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCompound_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIf_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWhile_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFor_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTry_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWith_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWith_item(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExcept_clause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSuite(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTest(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTest_nocond(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdef_nocond(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOr_test(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnd_test(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNot_test(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitComparison(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitComp_op(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStar_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitXor_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnd_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShift_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArith_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTerm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFactor(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPower(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTestlist_comp(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTrailer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSubscriptlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSubscript(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSliceop(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExprlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTestlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDictorsetmaker(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassdef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArglist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArgument(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitComp_iter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitComp_for(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitComp_if(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitYield_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitYield_arg(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInteger(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSingle_input(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFile_input(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEval_input(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDecorator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDecorators(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDecorated(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFuncdef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypedargslist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTfpdef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVarargslist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVfpdef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimple_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSmall_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrint_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpr_stmt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTestlist_star_expr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAugassign(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumber(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameters(Node node) {
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