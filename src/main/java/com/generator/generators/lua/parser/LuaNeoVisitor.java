package com.generator.generators.lua.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class LuaNeoVisitor extends LuaBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public LuaNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitBlock(com.generator.generators.lua.parser.LuaParser.BlockContext arg) {
		System.out.println("Block");
		final Node node = model.newNode(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.lua.parser.LuaParser.StringContext arg) {
		System.out.println("String");
		final Node node = model.newNode(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.lua.parser.LuaParser.NumberContext arg) {
		System.out.println("Number");
		final Node node = model.newNode(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		System.out.println("Var");
		final Node node = model.newNode(Label.label("Var"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		System.out.println("Field");
		final Node node = model.newNode(Label.label("Field"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		System.out.println("Chunk");
		final Node node = model.newNode(Label.label("Chunk"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStat(com.generator.generators.lua.parser.LuaParser.StatContext arg) {
		System.out.println("Stat");
		final Node node = model.newNode(Label.label("Stat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctioncall(com.generator.generators.lua.parser.LuaParser.FunctioncallContext arg) {
		System.out.println("Functioncall");
		final Node node = model.newNode(Label.label("Functioncall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRetstat(com.generator.generators.lua.parser.LuaParser.RetstatContext arg) {
		System.out.println("Retstat");
		final Node node = model.newNode(Label.label("Retstat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabel(com.generator.generators.lua.parser.LuaParser.LabelContext arg) {
		System.out.println("Label");
		final Node node = model.newNode(Label.label("Label"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncname(com.generator.generators.lua.parser.LuaParser.FuncnameContext arg) {
		System.out.println("Funcname");
		final Node node = model.newNode(Label.label("Funcname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarlist(com.generator.generators.lua.parser.LuaParser.VarlistContext arg) {
		System.out.println("Varlist");
		final Node node = model.newNode(Label.label("Varlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamelist(com.generator.generators.lua.parser.LuaParser.NamelistContext arg) {
		System.out.println("Namelist");
		final Node node = model.newNode(Label.label("Namelist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplist(com.generator.generators.lua.parser.LuaParser.ExplistContext arg) {
		System.out.println("Explist");
		final Node node = model.newNode(Label.label("Explist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExp(com.generator.generators.lua.parser.LuaParser.ExpContext arg) {
		System.out.println("Exp");
		final Node node = model.newNode(Label.label("Exp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixexp(com.generator.generators.lua.parser.LuaParser.PrefixexpContext arg) {
		System.out.println("Prefixexp");
		final Node node = model.newNode(Label.label("Prefixexp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrExp(com.generator.generators.lua.parser.LuaParser.VarOrExpContext arg) {
		System.out.println("VarOrExp");
		final Node node = model.newNode(Label.label("VarOrExp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarSuffix(com.generator.generators.lua.parser.LuaParser.VarSuffixContext arg) {
		System.out.println("VarSuffix");
		final Node node = model.newNode(Label.label("VarSuffix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNameAndArgs(com.generator.generators.lua.parser.LuaParser.NameAndArgsContext arg) {
		System.out.println("NameAndArgs");
		final Node node = model.newNode(Label.label("NameAndArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgs(com.generator.generators.lua.parser.LuaParser.ArgsContext arg) {
		System.out.println("Args");
		final Node node = model.newNode(Label.label("Args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctiondef(com.generator.generators.lua.parser.LuaParser.FunctiondefContext arg) {
		System.out.println("Functiondef");
		final Node node = model.newNode(Label.label("Functiondef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncbody(com.generator.generators.lua.parser.LuaParser.FuncbodyContext arg) {
		System.out.println("Funcbody");
		final Node node = model.newNode(Label.label("Funcbody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParlist(com.generator.generators.lua.parser.LuaParser.ParlistContext arg) {
		System.out.println("Parlist");
		final Node node = model.newNode(Label.label("Parlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTableconstructor(com.generator.generators.lua.parser.LuaParser.TableconstructorContext arg) {
		System.out.println("Tableconstructor");
		final Node node = model.newNode(Label.label("Tableconstructor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldlist(com.generator.generators.lua.parser.LuaParser.FieldlistContext arg) {
		System.out.println("Fieldlist");
		final Node node = model.newNode(Label.label("Fieldlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldsep(com.generator.generators.lua.parser.LuaParser.FieldsepContext arg) {
		System.out.println("Fieldsep");
		final Node node = model.newNode(Label.label("Fieldsep"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorOr(com.generator.generators.lua.parser.LuaParser.OperatorOrContext arg) {
		System.out.println("OperatorOr");
		final Node node = model.newNode(Label.label("OperatorOr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAnd(com.generator.generators.lua.parser.LuaParser.OperatorAndContext arg) {
		System.out.println("OperatorAnd");
		final Node node = model.newNode(Label.label("OperatorAnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorComparison(com.generator.generators.lua.parser.LuaParser.OperatorComparisonContext arg) {
		System.out.println("OperatorComparison");
		final Node node = model.newNode(Label.label("OperatorComparison"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorStrcat(com.generator.generators.lua.parser.LuaParser.OperatorStrcatContext arg) {
		System.out.println("OperatorStrcat");
		final Node node = model.newNode(Label.label("OperatorStrcat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAddSub(com.generator.generators.lua.parser.LuaParser.OperatorAddSubContext arg) {
		System.out.println("OperatorAddSub");
		final Node node = model.newNode(Label.label("OperatorAddSub"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorMulDivMod(com.generator.generators.lua.parser.LuaParser.OperatorMulDivModContext arg) {
		System.out.println("OperatorMulDivMod");
		final Node node = model.newNode(Label.label("OperatorMulDivMod"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorBitwise(com.generator.generators.lua.parser.LuaParser.OperatorBitwiseContext arg) {
		System.out.println("OperatorBitwise");
		final Node node = model.newNode(Label.label("OperatorBitwise"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorUnary(com.generator.generators.lua.parser.LuaParser.OperatorUnaryContext arg) {
		System.out.println("OperatorUnary");
		final Node node = model.newNode(Label.label("OperatorUnary"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorPower(com.generator.generators.lua.parser.LuaParser.OperatorPowerContext arg) {
		System.out.println("OperatorPower");
		final Node node = model.newNode(Label.label("OperatorPower"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}