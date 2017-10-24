package com.generator.generators.scala.parser;

public class ScalaNodeVisitor extends ScalaBaseVisitor<ScalaNodeVisitor.Node> {

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

	public ScalaNodeVisitor() {
		this(false);
	}

	public ScalaNodeVisitor(boolean debug) {
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
	public Node visitGuard(com.generator.generators.scala.parser.ScalaParser.GuardContext arg) {
		final Node node = new Node("Guard", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern1(com.generator.generators.scala.parser.ScalaParser.Pattern1Context arg) {
		final Node node = new Node("Pattern1", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern2(com.generator.generators.scala.parser.ScalaParser.Pattern2Context arg) {
		final Node node = new Node("Pattern2", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern3(com.generator.generators.scala.parser.ScalaParser.Pattern3Context arg) {
		final Node node = new Node("Pattern3", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimplePattern(com.generator.generators.scala.parser.ScalaParser.SimplePatternContext arg) {
		final Node node = new Node("SimplePattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatterns(com.generator.generators.scala.parser.ScalaParser.PatternsContext arg) {
		final Node node = new Node("Patterns", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParamClause(com.generator.generators.scala.parser.ScalaParser.TypeParamClauseContext arg) {
		final Node node = new Node("TypeParamClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunTypeParamClause(com.generator.generators.scala.parser.ScalaParser.FunTypeParamClauseContext arg) {
		final Node node = new Node("FunTypeParamClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariantTypeParam(com.generator.generators.scala.parser.ScalaParser.VariantTypeParamContext arg) {
		final Node node = new Node("VariantTypeParam", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParam(com.generator.generators.scala.parser.ScalaParser.TypeParamContext arg) {
		final Node node = new Node("TypeParam", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamClauses(com.generator.generators.scala.parser.ScalaParser.ParamClausesContext arg) {
		final Node node = new Node("ParamClauses", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamClause(com.generator.generators.scala.parser.ScalaParser.ParamClauseContext arg) {
		final Node node = new Node("ParamClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParams(com.generator.generators.scala.parser.ScalaParser.ParamsContext arg) {
		final Node node = new Node("Params", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParam(com.generator.generators.scala.parser.ScalaParser.ParamContext arg) {
		final Node node = new Node("Param", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamType(com.generator.generators.scala.parser.ScalaParser.ParamTypeContext arg) {
		final Node node = new Node("ParamType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParamClauses(com.generator.generators.scala.parser.ScalaParser.ClassParamClausesContext arg) {
		final Node node = new Node("ClassParamClauses", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParamClause(com.generator.generators.scala.parser.ScalaParser.ClassParamClauseContext arg) {
		final Node node = new Node("ClassParamClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParams(com.generator.generators.scala.parser.ScalaParser.ClassParamsContext arg) {
		final Node node = new Node("ClassParams", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParam(com.generator.generators.scala.parser.ScalaParser.ClassParamContext arg) {
		final Node node = new Node("ClassParam", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBindings(com.generator.generators.scala.parser.ScalaParser.BindingsContext arg) {
		final Node node = new Node("Bindings", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinding(com.generator.generators.scala.parser.ScalaParser.BindingContext arg) {
		final Node node = new Node("Binding", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLocalModifier(com.generator.generators.scala.parser.ScalaParser.LocalModifierContext arg) {
		final Node node = new Node("LocalModifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAccessModifier(com.generator.generators.scala.parser.ScalaParser.AccessModifierContext arg) {
		final Node node = new Node("AccessModifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAccessQualifier(com.generator.generators.scala.parser.ScalaParser.AccessQualifierContext arg) {
		final Node node = new Node("AccessQualifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrAnnotation(com.generator.generators.scala.parser.ScalaParser.ConstrAnnotationContext arg) {
		final Node node = new Node("ConstrAnnotation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateBody(com.generator.generators.scala.parser.ScalaParser.TemplateBodyContext arg) {
		final Node node = new Node("TemplateBody", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateStat(com.generator.generators.scala.parser.ScalaParser.TemplateStatContext arg) {
		final Node node = new Node("TemplateStat", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelfType(com.generator.generators.scala.parser.ScalaParser.SelfTypeContext arg) {
		final Node node = new Node("SelfType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_(com.generator.generators.scala.parser.ScalaParser.Import_Context arg) {
		final Node node = new Node("Import_", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportExpr(com.generator.generators.scala.parser.ScalaParser.ImportExprContext arg) {
		final Node node = new Node("ImportExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSelectors(com.generator.generators.scala.parser.ScalaParser.ImportSelectorsContext arg) {
		final Node node = new Node("ImportSelectors", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSelector(com.generator.generators.scala.parser.ScalaParser.ImportSelectorContext arg) {
		final Node node = new Node("ImportSelector", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDcl(com.generator.generators.scala.parser.ScalaParser.DclContext arg) {
		final Node node = new Node("Dcl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValDcl(com.generator.generators.scala.parser.ScalaParser.ValDclContext arg) {
		final Node node = new Node("ValDcl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDcl(com.generator.generators.scala.parser.ScalaParser.VarDclContext arg) {
		final Node node = new Node("VarDcl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunDcl(com.generator.generators.scala.parser.ScalaParser.FunDclContext arg) {
		final Node node = new Node("FunDcl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunSig(com.generator.generators.scala.parser.ScalaParser.FunSigContext arg) {
		final Node node = new Node("FunSig", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDcl(com.generator.generators.scala.parser.ScalaParser.TypeDclContext arg) {
		final Node node = new Node("TypeDcl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatVarDef(com.generator.generators.scala.parser.ScalaParser.PatVarDefContext arg) {
		final Node node = new Node("PatVarDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDef(com.generator.generators.scala.parser.ScalaParser.DefContext arg) {
		final Node node = new Node("Def", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatDef(com.generator.generators.scala.parser.ScalaParser.PatDefContext arg) {
		final Node node = new Node("PatDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDef(com.generator.generators.scala.parser.ScalaParser.VarDefContext arg) {
		final Node node = new Node("VarDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunDef(com.generator.generators.scala.parser.ScalaParser.FunDefContext arg) {
		final Node node = new Node("FunDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDef(com.generator.generators.scala.parser.ScalaParser.TypeDefContext arg) {
		final Node node = new Node("TypeDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTmplDef(com.generator.generators.scala.parser.ScalaParser.TmplDefContext arg) {
		final Node node = new Node("TmplDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassDef(com.generator.generators.scala.parser.ScalaParser.ClassDefContext arg) {
		final Node node = new Node("ClassDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitDef(com.generator.generators.scala.parser.ScalaParser.TraitDefContext arg) {
		final Node node = new Node("TraitDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectDef(com.generator.generators.scala.parser.ScalaParser.ObjectDefContext arg) {
		final Node node = new Node("ObjectDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassTemplateOpt(com.generator.generators.scala.parser.ScalaParser.ClassTemplateOptContext arg) {
		final Node node = new Node("ClassTemplateOpt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitTemplateOpt(com.generator.generators.scala.parser.ScalaParser.TraitTemplateOptContext arg) {
		final Node node = new Node("TraitTemplateOpt", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassTemplate(com.generator.generators.scala.parser.ScalaParser.ClassTemplateContext arg) {
		final Node node = new Node("ClassTemplate", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitTemplate(com.generator.generators.scala.parser.ScalaParser.TraitTemplateContext arg) {
		final Node node = new Node("TraitTemplate", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParents(com.generator.generators.scala.parser.ScalaParser.ClassParentsContext arg) {
		final Node node = new Node("ClassParents", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitParents(com.generator.generators.scala.parser.ScalaParser.TraitParentsContext arg) {
		final Node node = new Node("TraitParents", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstr(com.generator.generators.scala.parser.ScalaParser.ConstrContext arg) {
		final Node node = new Node("Constr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEarlyDefs(com.generator.generators.scala.parser.ScalaParser.EarlyDefsContext arg) {
		final Node node = new Node("EarlyDefs", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEarlyDef(com.generator.generators.scala.parser.ScalaParser.EarlyDefContext arg) {
		final Node node = new Node("EarlyDef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrExpr(com.generator.generators.scala.parser.ScalaParser.ConstrExprContext arg) {
		final Node node = new Node("ConstrExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrBlock(com.generator.generators.scala.parser.ScalaParser.ConstrBlockContext arg) {
		final Node node = new Node("ConstrBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelfInvocation(com.generator.generators.scala.parser.ScalaParser.SelfInvocationContext arg) {
		final Node node = new Node("SelfInvocation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopStatSeq(com.generator.generators.scala.parser.ScalaParser.TopStatSeqContext arg) {
		final Node node = new Node("TopStatSeq", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopStat(com.generator.generators.scala.parser.ScalaParser.TopStatContext arg) {
		final Node node = new Node("TopStat", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackaging(com.generator.generators.scala.parser.ScalaParser.PackagingContext arg) {
		final Node node = new Node("Packaging", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageObject(com.generator.generators.scala.parser.ScalaParser.PackageObjectContext arg) {
		final Node node = new Node("PackageObject", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistentialClause(com.generator.generators.scala.parser.ScalaParser.ExistentialClauseContext arg) {
		final Node node = new Node("ExistentialClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistentialDcl(com.generator.generators.scala.parser.ScalaParser.ExistentialDclContext arg) {
		final Node node = new Node("ExistentialDcl", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompoundType(com.generator.generators.scala.parser.ScalaParser.CompoundTypeContext arg) {
		final Node node = new Node("CompoundType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotType(com.generator.generators.scala.parser.ScalaParser.AnnotTypeContext arg) {
		final Node node = new Node("AnnotType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleType(com.generator.generators.scala.parser.ScalaParser.SimpleTypeContext arg) {
		final Node node = new Node("SimpleType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArgs(com.generator.generators.scala.parser.ScalaParser.TypeArgsContext arg) {
		final Node node = new Node("TypeArgs", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypes(com.generator.generators.scala.parser.ScalaParser.TypesContext arg) {
		final Node node = new Node("Types", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRefinement(com.generator.generators.scala.parser.ScalaParser.RefinementContext arg) {
		final Node node = new Node("Refinement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRefineStat(com.generator.generators.scala.parser.ScalaParser.RefineStatContext arg) {
		final Node node = new Node("RefineStat", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypePat(com.generator.generators.scala.parser.ScalaParser.TypePatContext arg) {
		final Node node = new Node("TypePat", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAscription(com.generator.generators.scala.parser.ScalaParser.AscriptionContext arg) {
		final Node node = new Node("Ascription", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr1(com.generator.generators.scala.parser.ScalaParser.Expr1Context arg) {
		final Node node = new Node("Expr1", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostfixExpr(com.generator.generators.scala.parser.ScalaParser.PostfixExprContext arg) {
		final Node node = new Node("PostfixExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInfixExpr(com.generator.generators.scala.parser.ScalaParser.InfixExprContext arg) {
		final Node node = new Node("InfixExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixExpr(com.generator.generators.scala.parser.ScalaParser.PrefixExprContext arg) {
		final Node node = new Node("PrefixExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr(com.generator.generators.scala.parser.ScalaParser.SimpleExprContext arg) {
		final Node node = new Node("SimpleExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr1(com.generator.generators.scala.parser.ScalaParser.SimpleExpr1Context arg) {
		final Node node = new Node("SimpleExpr1", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr2(com.generator.generators.scala.parser.ScalaParser.SimpleExpr2Context arg) {
		final Node node = new Node("SimpleExpr2", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprs(com.generator.generators.scala.parser.ScalaParser.ExprsContext arg) {
		final Node node = new Node("Exprs", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgumentExprs(com.generator.generators.scala.parser.ScalaParser.ArgumentExprsContext arg) {
		final Node node = new Node("ArgumentExprs", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockExpr(com.generator.generators.scala.parser.ScalaParser.BlockExprContext arg) {
		final Node node = new Node("BlockExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockStat(com.generator.generators.scala.parser.ScalaParser.BlockStatContext arg) {
		final Node node = new Node("BlockStat", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResultExpr(com.generator.generators.scala.parser.ScalaParser.ResultExprContext arg) {
		final Node node = new Node("ResultExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumerators(com.generator.generators.scala.parser.ScalaParser.EnumeratorsContext arg) {
		final Node node = new Node("Enumerators", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenerator(com.generator.generators.scala.parser.ScalaParser.GeneratorContext arg) {
		final Node node = new Node("Generator", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock(com.generator.generators.scala.parser.ScalaParser.BlockContext arg) {
		final Node node = new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualId(com.generator.generators.scala.parser.ScalaParser.QualIdContext arg) {
		final Node node = new Node("QualId", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIds(com.generator.generators.scala.parser.ScalaParser.IdsContext arg) {
		final Node node = new Node("Ids", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStableId(com.generator.generators.scala.parser.ScalaParser.StableIdContext arg) {
		final Node node = new Node("StableId", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassQualifier(com.generator.generators.scala.parser.ScalaParser.ClassQualifierContext arg) {
		final Node node = new Node("ClassQualifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionArgTypes(com.generator.generators.scala.parser.ScalaParser.FunctionArgTypesContext arg) {
		final Node node = new Node("FunctionArgTypes", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInfixType(com.generator.generators.scala.parser.ScalaParser.InfixTypeContext arg) {
		final Node node = new Node("InfixType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.scala.parser.ScalaParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.scala.parser.ScalaParser.ExprContext arg) {
		final Node node = new Node("Expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern(com.generator.generators.scala.parser.ScalaParser.PatternContext arg) {
		final Node node = new Node("Pattern", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClauses(com.generator.generators.scala.parser.ScalaParser.CaseClausesContext arg) {
		final Node node = new Node("CaseClauses", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClause(com.generator.generators.scala.parser.ScalaParser.CaseClauseContext arg) {
		final Node node = new Node("CaseClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.scala.parser.ScalaParser.TypeContext arg) {
		final Node node = new Node("Type", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompilationUnit(com.generator.generators.scala.parser.ScalaParser.CompilationUnitContext arg) {
		final Node node = new Node("CompilationUnit", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitModifier(com.generator.generators.scala.parser.ScalaParser.ModifierContext arg) {
		final Node node = new Node("Modifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotation(com.generator.generators.scala.parser.ScalaParser.AnnotationContext arg) {
		final Node node = new Node("Annotation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}