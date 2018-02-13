package com.generator.generators.scala.parser;

import org.neo4j.graphdb.*;

public abstract class ScalaDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Block")) visitBlock(node);
		else if(hasLabel(node, "Literal")) visitLiteral(node);
		else if(hasLabel(node, "Expr")) visitExpr(node);
		else if(hasLabel(node, "Pattern")) visitPattern(node);
		else if(hasLabel(node, "CaseClauses")) visitCaseClauses(node);
		else if(hasLabel(node, "CaseClause")) visitCaseClause(node);
		else if(hasLabel(node, "Type")) visitType(node);
		else if(hasLabel(node, "CompilationUnit")) visitCompilationUnit(node);
		else if(hasLabel(node, "Modifier")) visitModifier(node);
		else if(hasLabel(node, "Annotation")) visitAnnotation(node);
		else if(hasLabel(node, "SimpleExpr2")) visitSimpleExpr2(node);
		else if(hasLabel(node, "Exprs")) visitExprs(node);
		else if(hasLabel(node, "ArgumentExprs")) visitArgumentExprs(node);
		else if(hasLabel(node, "BlockExpr")) visitBlockExpr(node);
		else if(hasLabel(node, "BlockStat")) visitBlockStat(node);
		else if(hasLabel(node, "ResultExpr")) visitResultExpr(node);
		else if(hasLabel(node, "Enumerators")) visitEnumerators(node);
		else if(hasLabel(node, "Generator")) visitGenerator(node);
		else if(hasLabel(node, "Guard")) visitGuard(node);
		else if(hasLabel(node, "Pattern1")) visitPattern1(node);
		else if(hasLabel(node, "Pattern2")) visitPattern2(node);
		else if(hasLabel(node, "Pattern3")) visitPattern3(node);
		else if(hasLabel(node, "SimplePattern")) visitSimplePattern(node);
		else if(hasLabel(node, "Patterns")) visitPatterns(node);
		else if(hasLabel(node, "TypeParamClause")) visitTypeParamClause(node);
		else if(hasLabel(node, "FunTypeParamClause")) visitFunTypeParamClause(node);
		else if(hasLabel(node, "VariantTypeParam")) visitVariantTypeParam(node);
		else if(hasLabel(node, "TypeParam")) visitTypeParam(node);
		else if(hasLabel(node, "ParamClauses")) visitParamClauses(node);
		else if(hasLabel(node, "ParamClause")) visitParamClause(node);
		else if(hasLabel(node, "Params")) visitParams(node);
		else if(hasLabel(node, "Param")) visitParam(node);
		else if(hasLabel(node, "ParamType")) visitParamType(node);
		else if(hasLabel(node, "ClassParamClauses")) visitClassParamClauses(node);
		else if(hasLabel(node, "ClassParamClause")) visitClassParamClause(node);
		else if(hasLabel(node, "ClassParams")) visitClassParams(node);
		else if(hasLabel(node, "ClassParam")) visitClassParam(node);
		else if(hasLabel(node, "Bindings")) visitBindings(node);
		else if(hasLabel(node, "Binding")) visitBinding(node);
		else if(hasLabel(node, "LocalModifier")) visitLocalModifier(node);
		else if(hasLabel(node, "AccessModifier")) visitAccessModifier(node);
		else if(hasLabel(node, "AccessQualifier")) visitAccessQualifier(node);
		else if(hasLabel(node, "ConstrAnnotation")) visitConstrAnnotation(node);
		else if(hasLabel(node, "TemplateBody")) visitTemplateBody(node);
		else if(hasLabel(node, "TemplateStat")) visitTemplateStat(node);
		else if(hasLabel(node, "SelfType")) visitSelfType(node);
		else if(hasLabel(node, "Import_")) visitImport_(node);
		else if(hasLabel(node, "ImportExpr")) visitImportExpr(node);
		else if(hasLabel(node, "ImportSelectors")) visitImportSelectors(node);
		else if(hasLabel(node, "ImportSelector")) visitImportSelector(node);
		else if(hasLabel(node, "Dcl")) visitDcl(node);
		else if(hasLabel(node, "ValDcl")) visitValDcl(node);
		else if(hasLabel(node, "VarDcl")) visitVarDcl(node);
		else if(hasLabel(node, "FunDcl")) visitFunDcl(node);
		else if(hasLabel(node, "FunSig")) visitFunSig(node);
		else if(hasLabel(node, "TypeDcl")) visitTypeDcl(node);
		else if(hasLabel(node, "PatVarDef")) visitPatVarDef(node);
		else if(hasLabel(node, "Def")) visitDef(node);
		else if(hasLabel(node, "PatDef")) visitPatDef(node);
		else if(hasLabel(node, "VarDef")) visitVarDef(node);
		else if(hasLabel(node, "FunDef")) visitFunDef(node);
		else if(hasLabel(node, "TypeDef")) visitTypeDef(node);
		else if(hasLabel(node, "TmplDef")) visitTmplDef(node);
		else if(hasLabel(node, "ClassDef")) visitClassDef(node);
		else if(hasLabel(node, "TraitDef")) visitTraitDef(node);
		else if(hasLabel(node, "ObjectDef")) visitObjectDef(node);
		else if(hasLabel(node, "ClassTemplateOpt")) visitClassTemplateOpt(node);
		else if(hasLabel(node, "TraitTemplateOpt")) visitTraitTemplateOpt(node);
		else if(hasLabel(node, "ClassTemplate")) visitClassTemplate(node);
		else if(hasLabel(node, "TraitTemplate")) visitTraitTemplate(node);
		else if(hasLabel(node, "ClassParents")) visitClassParents(node);
		else if(hasLabel(node, "TraitParents")) visitTraitParents(node);
		else if(hasLabel(node, "Constr")) visitConstr(node);
		else if(hasLabel(node, "EarlyDefs")) visitEarlyDefs(node);
		else if(hasLabel(node, "EarlyDef")) visitEarlyDef(node);
		else if(hasLabel(node, "ConstrExpr")) visitConstrExpr(node);
		else if(hasLabel(node, "ConstrBlock")) visitConstrBlock(node);
		else if(hasLabel(node, "SelfInvocation")) visitSelfInvocation(node);
		else if(hasLabel(node, "TopStatSeq")) visitTopStatSeq(node);
		else if(hasLabel(node, "TopStat")) visitTopStat(node);
		else if(hasLabel(node, "Packaging")) visitPackaging(node);
		else if(hasLabel(node, "PackageObject")) visitPackageObject(node);
		else if(hasLabel(node, "QualId")) visitQualId(node);
		else if(hasLabel(node, "Ids")) visitIds(node);
		else if(hasLabel(node, "StableId")) visitStableId(node);
		else if(hasLabel(node, "ClassQualifier")) visitClassQualifier(node);
		else if(hasLabel(node, "FunctionArgTypes")) visitFunctionArgTypes(node);
		else if(hasLabel(node, "ExistentialClause")) visitExistentialClause(node);
		else if(hasLabel(node, "ExistentialDcl")) visitExistentialDcl(node);
		else if(hasLabel(node, "InfixType")) visitInfixType(node);
		else if(hasLabel(node, "CompoundType")) visitCompoundType(node);
		else if(hasLabel(node, "AnnotType")) visitAnnotType(node);
		else if(hasLabel(node, "SimpleType")) visitSimpleType(node);
		else if(hasLabel(node, "TypeArgs")) visitTypeArgs(node);
		else if(hasLabel(node, "Types")) visitTypes(node);
		else if(hasLabel(node, "Refinement")) visitRefinement(node);
		else if(hasLabel(node, "RefineStat")) visitRefineStat(node);
		else if(hasLabel(node, "TypePat")) visitTypePat(node);
		else if(hasLabel(node, "Ascription")) visitAscription(node);
		else if(hasLabel(node, "Expr1")) visitExpr1(node);
		else if(hasLabel(node, "PostfixExpr")) visitPostfixExpr(node);
		else if(hasLabel(node, "InfixExpr")) visitInfixExpr(node);
		else if(hasLabel(node, "PrefixExpr")) visitPrefixExpr(node);
		else if(hasLabel(node, "SimpleExpr")) visitSimpleExpr(node);
		else if(hasLabel(node, "SimpleExpr1")) visitSimpleExpr1(node);
   }

	public void visitBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseClauses(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCaseClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCompilationUnit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleExpr2(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExprs(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArgumentExprs(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlockExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlockStat(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitResultExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumerators(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGenerator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGuard(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPattern1(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPattern2(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPattern3(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimplePattern(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPatterns(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeParamClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunTypeParamClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariantTypeParam(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeParam(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParamClauses(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParamClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParams(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParam(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParamType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassParamClauses(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassParamClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassParams(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassParam(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBindings(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBinding(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLocalModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAccessModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAccessQualifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstrAnnotation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplateBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplateStat(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelfType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImport_(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImportExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImportSelectors(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImportSelector(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDcl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitValDcl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVarDcl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunDcl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunSig(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeDcl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPatVarDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPatDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVarDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTmplDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTraitDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitObjectDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassTemplateOpt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTraitTemplateOpt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassTemplate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTraitTemplate(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassParents(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTraitParents(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEarlyDefs(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEarlyDef(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstrExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstrBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelfInvocation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTopStatSeq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTopStat(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPackaging(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPackageObject(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQualId(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIds(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStableId(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassQualifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionArgTypes(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExistentialClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExistentialDcl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInfixType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCompoundType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeArgs(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypes(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRefinement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRefineStat(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypePat(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAscription(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpr1(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPostfixExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInfixExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrefixExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleExpr1(Node node) {
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