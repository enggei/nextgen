package com.generator.generators.scala.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ScalaNeoListener extends ScalaBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public ScalaNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public ScalaNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inPatVarDef = new java.util.Stack<>();

	@Override
	public void enterPatVarDef(com.generator.generators.scala.parser.ScalaParser.PatVarDefContext arg) {
		final Node node = model.findOrCreate(Label.label("PatVarDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPatVarDef.push(true);
	}

	public void exitPatVarDef(com.generator.generators.scala.parser.ScalaParser.PatVarDefContext arg) {
		onExit();
		this.inPatVarDef.pop();
	}

	public boolean inPatVarDef() {
      return !inPatVarDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDef = new java.util.Stack<>();

	@Override
	public void enterDef(com.generator.generators.scala.parser.ScalaParser.DefContext arg) {
		final Node node = model.findOrCreate(Label.label("Def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDef.push(true);
	}

	public void exitDef(com.generator.generators.scala.parser.ScalaParser.DefContext arg) {
		onExit();
		this.inDef.pop();
	}

	public boolean inDef() {
      return !inDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPatDef = new java.util.Stack<>();

	@Override
	public void enterPatDef(com.generator.generators.scala.parser.ScalaParser.PatDefContext arg) {
		final Node node = model.findOrCreate(Label.label("PatDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPatDef.push(true);
	}

	public void exitPatDef(com.generator.generators.scala.parser.ScalaParser.PatDefContext arg) {
		onExit();
		this.inPatDef.pop();
	}

	public boolean inPatDef() {
      return !inPatDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarDef = new java.util.Stack<>();

	@Override
	public void enterVarDef(com.generator.generators.scala.parser.ScalaParser.VarDefContext arg) {
		final Node node = model.findOrCreate(Label.label("VarDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVarDef.push(true);
	}

	public void exitVarDef(com.generator.generators.scala.parser.ScalaParser.VarDefContext arg) {
		onExit();
		this.inVarDef.pop();
	}

	public boolean inVarDef() {
      return !inVarDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunDef = new java.util.Stack<>();

	@Override
	public void enterFunDef(com.generator.generators.scala.parser.ScalaParser.FunDefContext arg) {
		final Node node = model.findOrCreate(Label.label("FunDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunDef.push(true);
	}

	public void exitFunDef(com.generator.generators.scala.parser.ScalaParser.FunDefContext arg) {
		onExit();
		this.inFunDef.pop();
	}

	public boolean inFunDef() {
      return !inFunDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeDef = new java.util.Stack<>();

	@Override
	public void enterTypeDef(com.generator.generators.scala.parser.ScalaParser.TypeDefContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeDef.push(true);
	}

	public void exitTypeDef(com.generator.generators.scala.parser.ScalaParser.TypeDefContext arg) {
		onExit();
		this.inTypeDef.pop();
	}

	public boolean inTypeDef() {
      return !inTypeDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTmplDef = new java.util.Stack<>();

	@Override
	public void enterTmplDef(com.generator.generators.scala.parser.ScalaParser.TmplDefContext arg) {
		final Node node = model.findOrCreate(Label.label("TmplDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTmplDef.push(true);
	}

	public void exitTmplDef(com.generator.generators.scala.parser.ScalaParser.TmplDefContext arg) {
		onExit();
		this.inTmplDef.pop();
	}

	public boolean inTmplDef() {
      return !inTmplDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassDef = new java.util.Stack<>();

	@Override
	public void enterClassDef(com.generator.generators.scala.parser.ScalaParser.ClassDefContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassDef.push(true);
	}

	public void exitClassDef(com.generator.generators.scala.parser.ScalaParser.ClassDefContext arg) {
		onExit();
		this.inClassDef.pop();
	}

	public boolean inClassDef() {
      return !inClassDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTraitDef = new java.util.Stack<>();

	@Override
	public void enterTraitDef(com.generator.generators.scala.parser.ScalaParser.TraitDefContext arg) {
		final Node node = model.findOrCreate(Label.label("TraitDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTraitDef.push(true);
	}

	public void exitTraitDef(com.generator.generators.scala.parser.ScalaParser.TraitDefContext arg) {
		onExit();
		this.inTraitDef.pop();
	}

	public boolean inTraitDef() {
      return !inTraitDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObjectDef = new java.util.Stack<>();

	@Override
	public void enterObjectDef(com.generator.generators.scala.parser.ScalaParser.ObjectDefContext arg) {
		final Node node = model.findOrCreate(Label.label("ObjectDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inObjectDef.push(true);
	}

	public void exitObjectDef(com.generator.generators.scala.parser.ScalaParser.ObjectDefContext arg) {
		onExit();
		this.inObjectDef.pop();
	}

	public boolean inObjectDef() {
      return !inObjectDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassTemplateOpt = new java.util.Stack<>();

	@Override
	public void enterClassTemplateOpt(com.generator.generators.scala.parser.ScalaParser.ClassTemplateOptContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassTemplateOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassTemplateOpt.push(true);
	}

	public void exitClassTemplateOpt(com.generator.generators.scala.parser.ScalaParser.ClassTemplateOptContext arg) {
		onExit();
		this.inClassTemplateOpt.pop();
	}

	public boolean inClassTemplateOpt() {
      return !inClassTemplateOpt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTraitTemplateOpt = new java.util.Stack<>();

	@Override
	public void enterTraitTemplateOpt(com.generator.generators.scala.parser.ScalaParser.TraitTemplateOptContext arg) {
		final Node node = model.findOrCreate(Label.label("TraitTemplateOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTraitTemplateOpt.push(true);
	}

	public void exitTraitTemplateOpt(com.generator.generators.scala.parser.ScalaParser.TraitTemplateOptContext arg) {
		onExit();
		this.inTraitTemplateOpt.pop();
	}

	public boolean inTraitTemplateOpt() {
      return !inTraitTemplateOpt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassTemplate = new java.util.Stack<>();

	@Override
	public void enterClassTemplate(com.generator.generators.scala.parser.ScalaParser.ClassTemplateContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassTemplate.push(true);
	}

	public void exitClassTemplate(com.generator.generators.scala.parser.ScalaParser.ClassTemplateContext arg) {
		onExit();
		this.inClassTemplate.pop();
	}

	public boolean inClassTemplate() {
      return !inClassTemplate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTraitTemplate = new java.util.Stack<>();

	@Override
	public void enterTraitTemplate(com.generator.generators.scala.parser.ScalaParser.TraitTemplateContext arg) {
		final Node node = model.findOrCreate(Label.label("TraitTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTraitTemplate.push(true);
	}

	public void exitTraitTemplate(com.generator.generators.scala.parser.ScalaParser.TraitTemplateContext arg) {
		onExit();
		this.inTraitTemplate.pop();
	}

	public boolean inTraitTemplate() {
      return !inTraitTemplate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassParents = new java.util.Stack<>();

	@Override
	public void enterClassParents(com.generator.generators.scala.parser.ScalaParser.ClassParentsContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassParents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassParents.push(true);
	}

	public void exitClassParents(com.generator.generators.scala.parser.ScalaParser.ClassParentsContext arg) {
		onExit();
		this.inClassParents.pop();
	}

	public boolean inClassParents() {
      return !inClassParents.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTraitParents = new java.util.Stack<>();

	@Override
	public void enterTraitParents(com.generator.generators.scala.parser.ScalaParser.TraitParentsContext arg) {
		final Node node = model.findOrCreate(Label.label("TraitParents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTraitParents.push(true);
	}

	public void exitTraitParents(com.generator.generators.scala.parser.ScalaParser.TraitParentsContext arg) {
		onExit();
		this.inTraitParents.pop();
	}

	public boolean inTraitParents() {
      return !inTraitParents.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstr = new java.util.Stack<>();

	@Override
	public void enterConstr(com.generator.generators.scala.parser.ScalaParser.ConstrContext arg) {
		final Node node = model.findOrCreate(Label.label("Constr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstr.push(true);
	}

	public void exitConstr(com.generator.generators.scala.parser.ScalaParser.ConstrContext arg) {
		onExit();
		this.inConstr.pop();
	}

	public boolean inConstr() {
      return !inConstr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEarlyDefs = new java.util.Stack<>();

	@Override
	public void enterEarlyDefs(com.generator.generators.scala.parser.ScalaParser.EarlyDefsContext arg) {
		final Node node = model.findOrCreate(Label.label("EarlyDefs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEarlyDefs.push(true);
	}

	public void exitEarlyDefs(com.generator.generators.scala.parser.ScalaParser.EarlyDefsContext arg) {
		onExit();
		this.inEarlyDefs.pop();
	}

	public boolean inEarlyDefs() {
      return !inEarlyDefs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEarlyDef = new java.util.Stack<>();

	@Override
	public void enterEarlyDef(com.generator.generators.scala.parser.ScalaParser.EarlyDefContext arg) {
		final Node node = model.findOrCreate(Label.label("EarlyDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEarlyDef.push(true);
	}

	public void exitEarlyDef(com.generator.generators.scala.parser.ScalaParser.EarlyDefContext arg) {
		onExit();
		this.inEarlyDef.pop();
	}

	public boolean inEarlyDef() {
      return !inEarlyDef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstrExpr = new java.util.Stack<>();

	@Override
	public void enterConstrExpr(com.generator.generators.scala.parser.ScalaParser.ConstrExprContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstrExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstrExpr.push(true);
	}

	public void exitConstrExpr(com.generator.generators.scala.parser.ScalaParser.ConstrExprContext arg) {
		onExit();
		this.inConstrExpr.pop();
	}

	public boolean inConstrExpr() {
      return !inConstrExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstrBlock = new java.util.Stack<>();

	@Override
	public void enterConstrBlock(com.generator.generators.scala.parser.ScalaParser.ConstrBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstrBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstrBlock.push(true);
	}

	public void exitConstrBlock(com.generator.generators.scala.parser.ScalaParser.ConstrBlockContext arg) {
		onExit();
		this.inConstrBlock.pop();
	}

	public boolean inConstrBlock() {
      return !inConstrBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelfInvocation = new java.util.Stack<>();

	@Override
	public void enterSelfInvocation(com.generator.generators.scala.parser.ScalaParser.SelfInvocationContext arg) {
		final Node node = model.findOrCreate(Label.label("SelfInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelfInvocation.push(true);
	}

	public void exitSelfInvocation(com.generator.generators.scala.parser.ScalaParser.SelfInvocationContext arg) {
		onExit();
		this.inSelfInvocation.pop();
	}

	public boolean inSelfInvocation() {
      return !inSelfInvocation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTopStatSeq = new java.util.Stack<>();

	@Override
	public void enterTopStatSeq(com.generator.generators.scala.parser.ScalaParser.TopStatSeqContext arg) {
		final Node node = model.findOrCreate(Label.label("TopStatSeq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTopStatSeq.push(true);
	}

	public void exitTopStatSeq(com.generator.generators.scala.parser.ScalaParser.TopStatSeqContext arg) {
		onExit();
		this.inTopStatSeq.pop();
	}

	public boolean inTopStatSeq() {
      return !inTopStatSeq.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTopStat = new java.util.Stack<>();

	@Override
	public void enterTopStat(com.generator.generators.scala.parser.ScalaParser.TopStatContext arg) {
		final Node node = model.findOrCreate(Label.label("TopStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTopStat.push(true);
	}

	public void exitTopStat(com.generator.generators.scala.parser.ScalaParser.TopStatContext arg) {
		onExit();
		this.inTopStat.pop();
	}

	public boolean inTopStat() {
      return !inTopStat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackaging = new java.util.Stack<>();

	@Override
	public void enterPackaging(com.generator.generators.scala.parser.ScalaParser.PackagingContext arg) {
		final Node node = model.findOrCreate(Label.label("Packaging"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPackaging.push(true);
	}

	public void exitPackaging(com.generator.generators.scala.parser.ScalaParser.PackagingContext arg) {
		onExit();
		this.inPackaging.pop();
	}

	public boolean inPackaging() {
      return !inPackaging.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackageObject = new java.util.Stack<>();

	@Override
	public void enterPackageObject(com.generator.generators.scala.parser.ScalaParser.PackageObjectContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageObject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPackageObject.push(true);
	}

	public void exitPackageObject(com.generator.generators.scala.parser.ScalaParser.PackageObjectContext arg) {
		onExit();
		this.inPackageObject.pop();
	}

	public boolean inPackageObject() {
      return !inPackageObject.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParamType = new java.util.Stack<>();

	@Override
	public void enterParamType(com.generator.generators.scala.parser.ScalaParser.ParamTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("ParamType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParamType.push(true);
	}

	public void exitParamType(com.generator.generators.scala.parser.ScalaParser.ParamTypeContext arg) {
		onExit();
		this.inParamType.pop();
	}

	public boolean inParamType() {
      return !inParamType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassParamClauses = new java.util.Stack<>();

	@Override
	public void enterClassParamClauses(com.generator.generators.scala.parser.ScalaParser.ClassParamClausesContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassParamClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassParamClauses.push(true);
	}

	public void exitClassParamClauses(com.generator.generators.scala.parser.ScalaParser.ClassParamClausesContext arg) {
		onExit();
		this.inClassParamClauses.pop();
	}

	public boolean inClassParamClauses() {
      return !inClassParamClauses.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassParamClause = new java.util.Stack<>();

	@Override
	public void enterClassParamClause(com.generator.generators.scala.parser.ScalaParser.ClassParamClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassParamClause.push(true);
	}

	public void exitClassParamClause(com.generator.generators.scala.parser.ScalaParser.ClassParamClauseContext arg) {
		onExit();
		this.inClassParamClause.pop();
	}

	public boolean inClassParamClause() {
      return !inClassParamClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassParams = new java.util.Stack<>();

	@Override
	public void enterClassParams(com.generator.generators.scala.parser.ScalaParser.ClassParamsContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassParams"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassParams.push(true);
	}

	public void exitClassParams(com.generator.generators.scala.parser.ScalaParser.ClassParamsContext arg) {
		onExit();
		this.inClassParams.pop();
	}

	public boolean inClassParams() {
      return !inClassParams.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassParam = new java.util.Stack<>();

	@Override
	public void enterClassParam(com.generator.generators.scala.parser.ScalaParser.ClassParamContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassParam.push(true);
	}

	public void exitClassParam(com.generator.generators.scala.parser.ScalaParser.ClassParamContext arg) {
		onExit();
		this.inClassParam.pop();
	}

	public boolean inClassParam() {
      return !inClassParam.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBindings = new java.util.Stack<>();

	@Override
	public void enterBindings(com.generator.generators.scala.parser.ScalaParser.BindingsContext arg) {
		final Node node = model.findOrCreate(Label.label("Bindings"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBindings.push(true);
	}

	public void exitBindings(com.generator.generators.scala.parser.ScalaParser.BindingsContext arg) {
		onExit();
		this.inBindings.pop();
	}

	public boolean inBindings() {
      return !inBindings.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBinding = new java.util.Stack<>();

	@Override
	public void enterBinding(com.generator.generators.scala.parser.ScalaParser.BindingContext arg) {
		final Node node = model.findOrCreate(Label.label("Binding"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBinding.push(true);
	}

	public void exitBinding(com.generator.generators.scala.parser.ScalaParser.BindingContext arg) {
		onExit();
		this.inBinding.pop();
	}

	public boolean inBinding() {
      return !inBinding.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLocalModifier = new java.util.Stack<>();

	@Override
	public void enterLocalModifier(com.generator.generators.scala.parser.ScalaParser.LocalModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("LocalModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLocalModifier.push(true);
	}

	public void exitLocalModifier(com.generator.generators.scala.parser.ScalaParser.LocalModifierContext arg) {
		onExit();
		this.inLocalModifier.pop();
	}

	public boolean inLocalModifier() {
      return !inLocalModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAccessModifier = new java.util.Stack<>();

	@Override
	public void enterAccessModifier(com.generator.generators.scala.parser.ScalaParser.AccessModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("AccessModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAccessModifier.push(true);
	}

	public void exitAccessModifier(com.generator.generators.scala.parser.ScalaParser.AccessModifierContext arg) {
		onExit();
		this.inAccessModifier.pop();
	}

	public boolean inAccessModifier() {
      return !inAccessModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAccessQualifier = new java.util.Stack<>();

	@Override
	public void enterAccessQualifier(com.generator.generators.scala.parser.ScalaParser.AccessQualifierContext arg) {
		final Node node = model.findOrCreate(Label.label("AccessQualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAccessQualifier.push(true);
	}

	public void exitAccessQualifier(com.generator.generators.scala.parser.ScalaParser.AccessQualifierContext arg) {
		onExit();
		this.inAccessQualifier.pop();
	}

	public boolean inAccessQualifier() {
      return !inAccessQualifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConstrAnnotation = new java.util.Stack<>();

	@Override
	public void enterConstrAnnotation(com.generator.generators.scala.parser.ScalaParser.ConstrAnnotationContext arg) {
		final Node node = model.findOrCreate(Label.label("ConstrAnnotation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inConstrAnnotation.push(true);
	}

	public void exitConstrAnnotation(com.generator.generators.scala.parser.ScalaParser.ConstrAnnotationContext arg) {
		onExit();
		this.inConstrAnnotation.pop();
	}

	public boolean inConstrAnnotation() {
      return !inConstrAnnotation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplateBody = new java.util.Stack<>();

	@Override
	public void enterTemplateBody(com.generator.generators.scala.parser.ScalaParser.TemplateBodyContext arg) {
		final Node node = model.findOrCreate(Label.label("TemplateBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTemplateBody.push(true);
	}

	public void exitTemplateBody(com.generator.generators.scala.parser.ScalaParser.TemplateBodyContext arg) {
		onExit();
		this.inTemplateBody.pop();
	}

	public boolean inTemplateBody() {
      return !inTemplateBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplateStat = new java.util.Stack<>();

	@Override
	public void enterTemplateStat(com.generator.generators.scala.parser.ScalaParser.TemplateStatContext arg) {
		final Node node = model.findOrCreate(Label.label("TemplateStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTemplateStat.push(true);
	}

	public void exitTemplateStat(com.generator.generators.scala.parser.ScalaParser.TemplateStatContext arg) {
		onExit();
		this.inTemplateStat.pop();
	}

	public boolean inTemplateStat() {
      return !inTemplateStat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelfType = new java.util.Stack<>();

	@Override
	public void enterSelfType(com.generator.generators.scala.parser.ScalaParser.SelfTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("SelfType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelfType.push(true);
	}

	public void exitSelfType(com.generator.generators.scala.parser.ScalaParser.SelfTypeContext arg) {
		onExit();
		this.inSelfType.pop();
	}

	public boolean inSelfType() {
      return !inSelfType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImport_ = new java.util.Stack<>();

	@Override
	public void enterImport_(com.generator.generators.scala.parser.ScalaParser.Import_Context arg) {
		final Node node = model.findOrCreate(Label.label("Import_"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImport_.push(true);
	}

	public void exitImport_(com.generator.generators.scala.parser.ScalaParser.Import_Context arg) {
		onExit();
		this.inImport_.pop();
	}

	public boolean inImport_() {
      return !inImport_.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportExpr = new java.util.Stack<>();

	@Override
	public void enterImportExpr(com.generator.generators.scala.parser.ScalaParser.ImportExprContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImportExpr.push(true);
	}

	public void exitImportExpr(com.generator.generators.scala.parser.ScalaParser.ImportExprContext arg) {
		onExit();
		this.inImportExpr.pop();
	}

	public boolean inImportExpr() {
      return !inImportExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportSelectors = new java.util.Stack<>();

	@Override
	public void enterImportSelectors(com.generator.generators.scala.parser.ScalaParser.ImportSelectorsContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportSelectors"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImportSelectors.push(true);
	}

	public void exitImportSelectors(com.generator.generators.scala.parser.ScalaParser.ImportSelectorsContext arg) {
		onExit();
		this.inImportSelectors.pop();
	}

	public boolean inImportSelectors() {
      return !inImportSelectors.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImportSelector = new java.util.Stack<>();

	@Override
	public void enterImportSelector(com.generator.generators.scala.parser.ScalaParser.ImportSelectorContext arg) {
		final Node node = model.findOrCreate(Label.label("ImportSelector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inImportSelector.push(true);
	}

	public void exitImportSelector(com.generator.generators.scala.parser.ScalaParser.ImportSelectorContext arg) {
		onExit();
		this.inImportSelector.pop();
	}

	public boolean inImportSelector() {
      return !inImportSelector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDcl = new java.util.Stack<>();

	@Override
	public void enterDcl(com.generator.generators.scala.parser.ScalaParser.DclContext arg) {
		final Node node = model.findOrCreate(Label.label("Dcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDcl.push(true);
	}

	public void exitDcl(com.generator.generators.scala.parser.ScalaParser.DclContext arg) {
		onExit();
		this.inDcl.pop();
	}

	public boolean inDcl() {
      return !inDcl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inValDcl = new java.util.Stack<>();

	@Override
	public void enterValDcl(com.generator.generators.scala.parser.ScalaParser.ValDclContext arg) {
		final Node node = model.findOrCreate(Label.label("ValDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inValDcl.push(true);
	}

	public void exitValDcl(com.generator.generators.scala.parser.ScalaParser.ValDclContext arg) {
		onExit();
		this.inValDcl.pop();
	}

	public boolean inValDcl() {
      return !inValDcl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarDcl = new java.util.Stack<>();

	@Override
	public void enterVarDcl(com.generator.generators.scala.parser.ScalaParser.VarDclContext arg) {
		final Node node = model.findOrCreate(Label.label("VarDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVarDcl.push(true);
	}

	public void exitVarDcl(com.generator.generators.scala.parser.ScalaParser.VarDclContext arg) {
		onExit();
		this.inVarDcl.pop();
	}

	public boolean inVarDcl() {
      return !inVarDcl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunDcl = new java.util.Stack<>();

	@Override
	public void enterFunDcl(com.generator.generators.scala.parser.ScalaParser.FunDclContext arg) {
		final Node node = model.findOrCreate(Label.label("FunDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunDcl.push(true);
	}

	public void exitFunDcl(com.generator.generators.scala.parser.ScalaParser.FunDclContext arg) {
		onExit();
		this.inFunDcl.pop();
	}

	public boolean inFunDcl() {
      return !inFunDcl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunSig = new java.util.Stack<>();

	@Override
	public void enterFunSig(com.generator.generators.scala.parser.ScalaParser.FunSigContext arg) {
		final Node node = model.findOrCreate(Label.label("FunSig"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunSig.push(true);
	}

	public void exitFunSig(com.generator.generators.scala.parser.ScalaParser.FunSigContext arg) {
		onExit();
		this.inFunSig.pop();
	}

	public boolean inFunSig() {
      return !inFunSig.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeDcl = new java.util.Stack<>();

	@Override
	public void enterTypeDcl(com.generator.generators.scala.parser.ScalaParser.TypeDclContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeDcl.push(true);
	}

	public void exitTypeDcl(com.generator.generators.scala.parser.ScalaParser.TypeDclContext arg) {
		onExit();
		this.inTypeDcl.pop();
	}

	public boolean inTypeDcl() {
      return !inTypeDcl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQualId = new java.util.Stack<>();

	@Override
	public void enterQualId(com.generator.generators.scala.parser.ScalaParser.QualIdContext arg) {
		final Node node = model.findOrCreate(Label.label("QualId"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQualId.push(true);
	}

	public void exitQualId(com.generator.generators.scala.parser.ScalaParser.QualIdContext arg) {
		onExit();
		this.inQualId.pop();
	}

	public boolean inQualId() {
      return !inQualId.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIds = new java.util.Stack<>();

	@Override
	public void enterIds(com.generator.generators.scala.parser.ScalaParser.IdsContext arg) {
		final Node node = model.findOrCreate(Label.label("Ids"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inIds.push(true);
	}

	public void exitIds(com.generator.generators.scala.parser.ScalaParser.IdsContext arg) {
		onExit();
		this.inIds.pop();
	}

	public boolean inIds() {
      return !inIds.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStableId = new java.util.Stack<>();

	@Override
	public void enterStableId(com.generator.generators.scala.parser.ScalaParser.StableIdContext arg) {
		final Node node = model.findOrCreate(Label.label("StableId"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStableId.push(true);
	}

	public void exitStableId(com.generator.generators.scala.parser.ScalaParser.StableIdContext arg) {
		onExit();
		this.inStableId.pop();
	}

	public boolean inStableId() {
      return !inStableId.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassQualifier = new java.util.Stack<>();

	@Override
	public void enterClassQualifier(com.generator.generators.scala.parser.ScalaParser.ClassQualifierContext arg) {
		final Node node = model.findOrCreate(Label.label("ClassQualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inClassQualifier.push(true);
	}

	public void exitClassQualifier(com.generator.generators.scala.parser.ScalaParser.ClassQualifierContext arg) {
		onExit();
		this.inClassQualifier.pop();
	}

	public boolean inClassQualifier() {
      return !inClassQualifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionArgTypes = new java.util.Stack<>();

	@Override
	public void enterFunctionArgTypes(com.generator.generators.scala.parser.ScalaParser.FunctionArgTypesContext arg) {
		final Node node = model.findOrCreate(Label.label("FunctionArgTypes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunctionArgTypes.push(true);
	}

	public void exitFunctionArgTypes(com.generator.generators.scala.parser.ScalaParser.FunctionArgTypesContext arg) {
		onExit();
		this.inFunctionArgTypes.pop();
	}

	public boolean inFunctionArgTypes() {
      return !inFunctionArgTypes.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExistentialClause = new java.util.Stack<>();

	@Override
	public void enterExistentialClause(com.generator.generators.scala.parser.ScalaParser.ExistentialClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("ExistentialClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExistentialClause.push(true);
	}

	public void exitExistentialClause(com.generator.generators.scala.parser.ScalaParser.ExistentialClauseContext arg) {
		onExit();
		this.inExistentialClause.pop();
	}

	public boolean inExistentialClause() {
      return !inExistentialClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExistentialDcl = new java.util.Stack<>();

	@Override
	public void enterExistentialDcl(com.generator.generators.scala.parser.ScalaParser.ExistentialDclContext arg) {
		final Node node = model.findOrCreate(Label.label("ExistentialDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExistentialDcl.push(true);
	}

	public void exitExistentialDcl(com.generator.generators.scala.parser.ScalaParser.ExistentialDclContext arg) {
		onExit();
		this.inExistentialDcl.pop();
	}

	public boolean inExistentialDcl() {
      return !inExistentialDcl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInfixType = new java.util.Stack<>();

	@Override
	public void enterInfixType(com.generator.generators.scala.parser.ScalaParser.InfixTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("InfixType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInfixType.push(true);
	}

	public void exitInfixType(com.generator.generators.scala.parser.ScalaParser.InfixTypeContext arg) {
		onExit();
		this.inInfixType.pop();
	}

	public boolean inInfixType() {
      return !inInfixType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompoundType = new java.util.Stack<>();

	@Override
	public void enterCompoundType(com.generator.generators.scala.parser.ScalaParser.CompoundTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("CompoundType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCompoundType.push(true);
	}

	public void exitCompoundType(com.generator.generators.scala.parser.ScalaParser.CompoundTypeContext arg) {
		onExit();
		this.inCompoundType.pop();
	}

	public boolean inCompoundType() {
      return !inCompoundType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotType = new java.util.Stack<>();

	@Override
	public void enterAnnotType(com.generator.generators.scala.parser.ScalaParser.AnnotTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("AnnotType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotType.push(true);
	}

	public void exitAnnotType(com.generator.generators.scala.parser.ScalaParser.AnnotTypeContext arg) {
		onExit();
		this.inAnnotType.pop();
	}

	public boolean inAnnotType() {
      return !inAnnotType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleType = new java.util.Stack<>();

	@Override
	public void enterSimpleType(com.generator.generators.scala.parser.ScalaParser.SimpleTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("SimpleType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleType.push(true);
	}

	public void exitSimpleType(com.generator.generators.scala.parser.ScalaParser.SimpleTypeContext arg) {
		onExit();
		this.inSimpleType.pop();
	}

	public boolean inSimpleType() {
      return !inSimpleType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeArgs = new java.util.Stack<>();

	@Override
	public void enterTypeArgs(com.generator.generators.scala.parser.ScalaParser.TypeArgsContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeArgs.push(true);
	}

	public void exitTypeArgs(com.generator.generators.scala.parser.ScalaParser.TypeArgsContext arg) {
		onExit();
		this.inTypeArgs.pop();
	}

	public boolean inTypeArgs() {
      return !inTypeArgs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypes = new java.util.Stack<>();

	@Override
	public void enterTypes(com.generator.generators.scala.parser.ScalaParser.TypesContext arg) {
		final Node node = model.findOrCreate(Label.label("Types"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypes.push(true);
	}

	public void exitTypes(com.generator.generators.scala.parser.ScalaParser.TypesContext arg) {
		onExit();
		this.inTypes.pop();
	}

	public boolean inTypes() {
      return !inTypes.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRefinement = new java.util.Stack<>();

	@Override
	public void enterRefinement(com.generator.generators.scala.parser.ScalaParser.RefinementContext arg) {
		final Node node = model.findOrCreate(Label.label("Refinement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRefinement.push(true);
	}

	public void exitRefinement(com.generator.generators.scala.parser.ScalaParser.RefinementContext arg) {
		onExit();
		this.inRefinement.pop();
	}

	public boolean inRefinement() {
      return !inRefinement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRefineStat = new java.util.Stack<>();

	@Override
	public void enterRefineStat(com.generator.generators.scala.parser.ScalaParser.RefineStatContext arg) {
		final Node node = model.findOrCreate(Label.label("RefineStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRefineStat.push(true);
	}

	public void exitRefineStat(com.generator.generators.scala.parser.ScalaParser.RefineStatContext arg) {
		onExit();
		this.inRefineStat.pop();
	}

	public boolean inRefineStat() {
      return !inRefineStat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypePat = new java.util.Stack<>();

	@Override
	public void enterTypePat(com.generator.generators.scala.parser.ScalaParser.TypePatContext arg) {
		final Node node = model.findOrCreate(Label.label("TypePat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypePat.push(true);
	}

	public void exitTypePat(com.generator.generators.scala.parser.ScalaParser.TypePatContext arg) {
		onExit();
		this.inTypePat.pop();
	}

	public boolean inTypePat() {
      return !inTypePat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAscription = new java.util.Stack<>();

	@Override
	public void enterAscription(com.generator.generators.scala.parser.ScalaParser.AscriptionContext arg) {
		final Node node = model.findOrCreate(Label.label("Ascription"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAscription.push(true);
	}

	public void exitAscription(com.generator.generators.scala.parser.ScalaParser.AscriptionContext arg) {
		onExit();
		this.inAscription.pop();
	}

	public boolean inAscription() {
      return !inAscription.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpr1 = new java.util.Stack<>();

	@Override
	public void enterExpr1(com.generator.generators.scala.parser.ScalaParser.Expr1Context arg) {
		final Node node = model.findOrCreate(Label.label("Expr1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpr1.push(true);
	}

	public void exitExpr1(com.generator.generators.scala.parser.ScalaParser.Expr1Context arg) {
		onExit();
		this.inExpr1.pop();
	}

	public boolean inExpr1() {
      return !inExpr1.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPostfixExpr = new java.util.Stack<>();

	@Override
	public void enterPostfixExpr(com.generator.generators.scala.parser.ScalaParser.PostfixExprContext arg) {
		final Node node = model.findOrCreate(Label.label("PostfixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPostfixExpr.push(true);
	}

	public void exitPostfixExpr(com.generator.generators.scala.parser.ScalaParser.PostfixExprContext arg) {
		onExit();
		this.inPostfixExpr.pop();
	}

	public boolean inPostfixExpr() {
      return !inPostfixExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInfixExpr = new java.util.Stack<>();

	@Override
	public void enterInfixExpr(com.generator.generators.scala.parser.ScalaParser.InfixExprContext arg) {
		final Node node = model.findOrCreate(Label.label("InfixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInfixExpr.push(true);
	}

	public void exitInfixExpr(com.generator.generators.scala.parser.ScalaParser.InfixExprContext arg) {
		onExit();
		this.inInfixExpr.pop();
	}

	public boolean inInfixExpr() {
      return !inInfixExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrefixExpr = new java.util.Stack<>();

	@Override
	public void enterPrefixExpr(com.generator.generators.scala.parser.ScalaParser.PrefixExprContext arg) {
		final Node node = model.findOrCreate(Label.label("PrefixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPrefixExpr.push(true);
	}

	public void exitPrefixExpr(com.generator.generators.scala.parser.ScalaParser.PrefixExprContext arg) {
		onExit();
		this.inPrefixExpr.pop();
	}

	public boolean inPrefixExpr() {
      return !inPrefixExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleExpr = new java.util.Stack<>();

	@Override
	public void enterSimpleExpr(com.generator.generators.scala.parser.ScalaParser.SimpleExprContext arg) {
		final Node node = model.findOrCreate(Label.label("SimpleExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleExpr.push(true);
	}

	public void exitSimpleExpr(com.generator.generators.scala.parser.ScalaParser.SimpleExprContext arg) {
		onExit();
		this.inSimpleExpr.pop();
	}

	public boolean inSimpleExpr() {
      return !inSimpleExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleExpr1 = new java.util.Stack<>();

	@Override
	public void enterSimpleExpr1(com.generator.generators.scala.parser.ScalaParser.SimpleExpr1Context arg) {
		final Node node = model.findOrCreate(Label.label("SimpleExpr1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleExpr1.push(true);
	}

	public void exitSimpleExpr1(com.generator.generators.scala.parser.ScalaParser.SimpleExpr1Context arg) {
		onExit();
		this.inSimpleExpr1.pop();
	}

	public boolean inSimpleExpr1() {
      return !inSimpleExpr1.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleExpr2 = new java.util.Stack<>();

	@Override
	public void enterSimpleExpr2(com.generator.generators.scala.parser.ScalaParser.SimpleExpr2Context arg) {
		final Node node = model.findOrCreate(Label.label("SimpleExpr2"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimpleExpr2.push(true);
	}

	public void exitSimpleExpr2(com.generator.generators.scala.parser.ScalaParser.SimpleExpr2Context arg) {
		onExit();
		this.inSimpleExpr2.pop();
	}

	public boolean inSimpleExpr2() {
      return !inSimpleExpr2.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprs = new java.util.Stack<>();

	@Override
	public void enterExprs(com.generator.generators.scala.parser.ScalaParser.ExprsContext arg) {
		final Node node = model.findOrCreate(Label.label("Exprs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExprs.push(true);
	}

	public void exitExprs(com.generator.generators.scala.parser.ScalaParser.ExprsContext arg) {
		onExit();
		this.inExprs.pop();
	}

	public boolean inExprs() {
      return !inExprs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgumentExprs = new java.util.Stack<>();

	@Override
	public void enterArgumentExprs(com.generator.generators.scala.parser.ScalaParser.ArgumentExprsContext arg) {
		final Node node = model.findOrCreate(Label.label("ArgumentExprs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArgumentExprs.push(true);
	}

	public void exitArgumentExprs(com.generator.generators.scala.parser.ScalaParser.ArgumentExprsContext arg) {
		onExit();
		this.inArgumentExprs.pop();
	}

	public boolean inArgumentExprs() {
      return !inArgumentExprs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlockExpr = new java.util.Stack<>();

	@Override
	public void enterBlockExpr(com.generator.generators.scala.parser.ScalaParser.BlockExprContext arg) {
		final Node node = model.findOrCreate(Label.label("BlockExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlockExpr.push(true);
	}

	public void exitBlockExpr(com.generator.generators.scala.parser.ScalaParser.BlockExprContext arg) {
		onExit();
		this.inBlockExpr.pop();
	}

	public boolean inBlockExpr() {
      return !inBlockExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlockStat = new java.util.Stack<>();

	@Override
	public void enterBlockStat(com.generator.generators.scala.parser.ScalaParser.BlockStatContext arg) {
		final Node node = model.findOrCreate(Label.label("BlockStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlockStat.push(true);
	}

	public void exitBlockStat(com.generator.generators.scala.parser.ScalaParser.BlockStatContext arg) {
		onExit();
		this.inBlockStat.pop();
	}

	public boolean inBlockStat() {
      return !inBlockStat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inResultExpr = new java.util.Stack<>();

	@Override
	public void enterResultExpr(com.generator.generators.scala.parser.ScalaParser.ResultExprContext arg) {
		final Node node = model.findOrCreate(Label.label("ResultExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inResultExpr.push(true);
	}

	public void exitResultExpr(com.generator.generators.scala.parser.ScalaParser.ResultExprContext arg) {
		onExit();
		this.inResultExpr.pop();
	}

	public boolean inResultExpr() {
      return !inResultExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumerators = new java.util.Stack<>();

	@Override
	public void enterEnumerators(com.generator.generators.scala.parser.ScalaParser.EnumeratorsContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumerators"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inEnumerators.push(true);
	}

	public void exitEnumerators(com.generator.generators.scala.parser.ScalaParser.EnumeratorsContext arg) {
		onExit();
		this.inEnumerators.pop();
	}

	public boolean inEnumerators() {
      return !inEnumerators.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGenerator = new java.util.Stack<>();

	@Override
	public void enterGenerator(com.generator.generators.scala.parser.ScalaParser.GeneratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Generator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGenerator.push(true);
	}

	public void exitGenerator(com.generator.generators.scala.parser.ScalaParser.GeneratorContext arg) {
		onExit();
		this.inGenerator.pop();
	}

	public boolean inGenerator() {
      return !inGenerator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGuard = new java.util.Stack<>();

	@Override
	public void enterGuard(com.generator.generators.scala.parser.ScalaParser.GuardContext arg) {
		final Node node = model.findOrCreate(Label.label("Guard"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGuard.push(true);
	}

	public void exitGuard(com.generator.generators.scala.parser.ScalaParser.GuardContext arg) {
		onExit();
		this.inGuard.pop();
	}

	public boolean inGuard() {
      return !inGuard.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPattern1 = new java.util.Stack<>();

	@Override
	public void enterPattern1(com.generator.generators.scala.parser.ScalaParser.Pattern1Context arg) {
		final Node node = model.findOrCreate(Label.label("Pattern1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPattern1.push(true);
	}

	public void exitPattern1(com.generator.generators.scala.parser.ScalaParser.Pattern1Context arg) {
		onExit();
		this.inPattern1.pop();
	}

	public boolean inPattern1() {
      return !inPattern1.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPattern2 = new java.util.Stack<>();

	@Override
	public void enterPattern2(com.generator.generators.scala.parser.ScalaParser.Pattern2Context arg) {
		final Node node = model.findOrCreate(Label.label("Pattern2"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPattern2.push(true);
	}

	public void exitPattern2(com.generator.generators.scala.parser.ScalaParser.Pattern2Context arg) {
		onExit();
		this.inPattern2.pop();
	}

	public boolean inPattern2() {
      return !inPattern2.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPattern3 = new java.util.Stack<>();

	@Override
	public void enterPattern3(com.generator.generators.scala.parser.ScalaParser.Pattern3Context arg) {
		final Node node = model.findOrCreate(Label.label("Pattern3"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPattern3.push(true);
	}

	public void exitPattern3(com.generator.generators.scala.parser.ScalaParser.Pattern3Context arg) {
		onExit();
		this.inPattern3.pop();
	}

	public boolean inPattern3() {
      return !inPattern3.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimplePattern = new java.util.Stack<>();

	@Override
	public void enterSimplePattern(com.generator.generators.scala.parser.ScalaParser.SimplePatternContext arg) {
		final Node node = model.findOrCreate(Label.label("SimplePattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimplePattern.push(true);
	}

	public void exitSimplePattern(com.generator.generators.scala.parser.ScalaParser.SimplePatternContext arg) {
		onExit();
		this.inSimplePattern.pop();
	}

	public boolean inSimplePattern() {
      return !inSimplePattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPatterns = new java.util.Stack<>();

	@Override
	public void enterPatterns(com.generator.generators.scala.parser.ScalaParser.PatternsContext arg) {
		final Node node = model.findOrCreate(Label.label("Patterns"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPatterns.push(true);
	}

	public void exitPatterns(com.generator.generators.scala.parser.ScalaParser.PatternsContext arg) {
		onExit();
		this.inPatterns.pop();
	}

	public boolean inPatterns() {
      return !inPatterns.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeParamClause = new java.util.Stack<>();

	@Override
	public void enterTypeParamClause(com.generator.generators.scala.parser.ScalaParser.TypeParamClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeParamClause.push(true);
	}

	public void exitTypeParamClause(com.generator.generators.scala.parser.ScalaParser.TypeParamClauseContext arg) {
		onExit();
		this.inTypeParamClause.pop();
	}

	public boolean inTypeParamClause() {
      return !inTypeParamClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunTypeParamClause = new java.util.Stack<>();

	@Override
	public void enterFunTypeParamClause(com.generator.generators.scala.parser.ScalaParser.FunTypeParamClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("FunTypeParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFunTypeParamClause.push(true);
	}

	public void exitFunTypeParamClause(com.generator.generators.scala.parser.ScalaParser.FunTypeParamClauseContext arg) {
		onExit();
		this.inFunTypeParamClause.pop();
	}

	public boolean inFunTypeParamClause() {
      return !inFunTypeParamClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariantTypeParam = new java.util.Stack<>();

	@Override
	public void enterVariantTypeParam(com.generator.generators.scala.parser.ScalaParser.VariantTypeParamContext arg) {
		final Node node = model.findOrCreate(Label.label("VariantTypeParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariantTypeParam.push(true);
	}

	public void exitVariantTypeParam(com.generator.generators.scala.parser.ScalaParser.VariantTypeParamContext arg) {
		onExit();
		this.inVariantTypeParam.pop();
	}

	public boolean inVariantTypeParam() {
      return !inVariantTypeParam.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeParam = new java.util.Stack<>();

	@Override
	public void enterTypeParam(com.generator.generators.scala.parser.ScalaParser.TypeParamContext arg) {
		final Node node = model.findOrCreate(Label.label("TypeParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeParam.push(true);
	}

	public void exitTypeParam(com.generator.generators.scala.parser.ScalaParser.TypeParamContext arg) {
		onExit();
		this.inTypeParam.pop();
	}

	public boolean inTypeParam() {
      return !inTypeParam.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParamClauses = new java.util.Stack<>();

	@Override
	public void enterParamClauses(com.generator.generators.scala.parser.ScalaParser.ParamClausesContext arg) {
		final Node node = model.findOrCreate(Label.label("ParamClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParamClauses.push(true);
	}

	public void exitParamClauses(com.generator.generators.scala.parser.ScalaParser.ParamClausesContext arg) {
		onExit();
		this.inParamClauses.pop();
	}

	public boolean inParamClauses() {
      return !inParamClauses.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParamClause = new java.util.Stack<>();

	@Override
	public void enterParamClause(com.generator.generators.scala.parser.ScalaParser.ParamClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("ParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParamClause.push(true);
	}

	public void exitParamClause(com.generator.generators.scala.parser.ScalaParser.ParamClauseContext arg) {
		onExit();
		this.inParamClause.pop();
	}

	public boolean inParamClause() {
      return !inParamClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParams = new java.util.Stack<>();

	@Override
	public void enterParams(com.generator.generators.scala.parser.ScalaParser.ParamsContext arg) {
		final Node node = model.findOrCreate(Label.label("Params"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParams.push(true);
	}

	public void exitParams(com.generator.generators.scala.parser.ScalaParser.ParamsContext arg) {
		onExit();
		this.inParams.pop();
	}

	public boolean inParams() {
      return !inParams.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParam = new java.util.Stack<>();

	@Override
	public void enterParam(com.generator.generators.scala.parser.ScalaParser.ParamContext arg) {
		final Node node = model.findOrCreate(Label.label("Param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParam.push(true);
	}

	public void exitParam(com.generator.generators.scala.parser.ScalaParser.ParamContext arg) {
		onExit();
		this.inParam.pop();
	}

	public boolean inParam() {
      return !inParam.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.scala.parser.ScalaParser.BlockContext arg) {
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.scala.parser.ScalaParser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.scala.parser.ScalaParser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.scala.parser.ScalaParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpr = new java.util.Stack<>();

	@Override
	public void enterExpr(com.generator.generators.scala.parser.ScalaParser.ExprContext arg) {
		final Node node = model.findOrCreate(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inExpr.push(true);
	}

	public void exitExpr(com.generator.generators.scala.parser.ScalaParser.ExprContext arg) {
		onExit();
		this.inExpr.pop();
	}

	public boolean inExpr() {
      return !inExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPattern = new java.util.Stack<>();

	@Override
	public void enterPattern(com.generator.generators.scala.parser.ScalaParser.PatternContext arg) {
		final Node node = model.findOrCreate(Label.label("Pattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inPattern.push(true);
	}

	public void exitPattern(com.generator.generators.scala.parser.ScalaParser.PatternContext arg) {
		onExit();
		this.inPattern.pop();
	}

	public boolean inPattern() {
      return !inPattern.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseClauses = new java.util.Stack<>();

	@Override
	public void enterCaseClauses(com.generator.generators.scala.parser.ScalaParser.CaseClausesContext arg) {
		final Node node = model.findOrCreate(Label.label("CaseClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCaseClauses.push(true);
	}

	public void exitCaseClauses(com.generator.generators.scala.parser.ScalaParser.CaseClausesContext arg) {
		onExit();
		this.inCaseClauses.pop();
	}

	public boolean inCaseClauses() {
      return !inCaseClauses.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCaseClause = new java.util.Stack<>();

	@Override
	public void enterCaseClause(com.generator.generators.scala.parser.ScalaParser.CaseClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("CaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCaseClause.push(true);
	}

	public void exitCaseClause(com.generator.generators.scala.parser.ScalaParser.CaseClauseContext arg) {
		onExit();
		this.inCaseClause.pop();
	}

	public boolean inCaseClause() {
      return !inCaseClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inType = new java.util.Stack<>();

	@Override
	public void enterType(com.generator.generators.scala.parser.ScalaParser.TypeContext arg) {
		final Node node = model.findOrCreate(Label.label("Type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inType.push(true);
	}

	public void exitType(com.generator.generators.scala.parser.ScalaParser.TypeContext arg) {
		onExit();
		this.inType.pop();
	}

	public boolean inType() {
      return !inType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompilationUnit = new java.util.Stack<>();

	@Override
	public void enterCompilationUnit(com.generator.generators.scala.parser.ScalaParser.CompilationUnitContext arg) {
		final Node node = model.findOrCreate(Label.label("CompilationUnit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCompilationUnit.push(true);
	}

	public void exitCompilationUnit(com.generator.generators.scala.parser.ScalaParser.CompilationUnitContext arg) {
		onExit();
		this.inCompilationUnit.pop();
	}

	public boolean inCompilationUnit() {
      return !inCompilationUnit.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inModifier = new java.util.Stack<>();

	@Override
	public void enterModifier(com.generator.generators.scala.parser.ScalaParser.ModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Modifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inModifier.push(true);
	}

	public void exitModifier(com.generator.generators.scala.parser.ScalaParser.ModifierContext arg) {
		onExit();
		this.inModifier.pop();
	}

	public boolean inModifier() {
      return !inModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAnnotation = new java.util.Stack<>();

	@Override
	public void enterAnnotation(com.generator.generators.scala.parser.ScalaParser.AnnotationContext arg) {
		final Node node = model.findOrCreate(Label.label("Annotation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAnnotation.push(true);
	}

	public void exitAnnotation(com.generator.generators.scala.parser.ScalaParser.AnnotationContext arg) {
		onExit();
		this.inAnnotation.pop();
	}

	public boolean inAnnotation() {
      return !inAnnotation.isEmpty(); 
   }

}