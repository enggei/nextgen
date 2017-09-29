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
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.lua.parser.LuaParser.StringContext arg) {
		System.out.println("String");
		final Node node = model.findOrCreate(Label.label("String"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.lua.parser.LuaParser.NumberContext arg) {
		System.out.println("Number");
		final Node node = model.findOrCreate(Label.label("Number"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		System.out.println("Var");
		final Node node = model.findOrCreate(Label.label("Var"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		System.out.println("Field");
		final Node node = model.findOrCreate(Label.label("Field"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		System.out.println("Chunk");
		final Node node = model.findOrCreate(Label.label("Chunk"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStat(com.generator.generators.lua.parser.LuaParser.StatContext arg) {
		System.out.println("Stat");
		final Node node = model.findOrCreate(Label.label("Stat"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRetstat(com.generator.generators.lua.parser.LuaParser.RetstatContext arg) {
		System.out.println("Retstat");
		final Node node = model.findOrCreate(Label.label("Retstat"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabel(com.generator.generators.lua.parser.LuaParser.LabelContext arg) {
		System.out.println("Label");
		final Node node = model.findOrCreate(Label.label("Label"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncname(com.generator.generators.lua.parser.LuaParser.FuncnameContext arg) {
		System.out.println("Funcname");
		final Node node = model.findOrCreate(Label.label("Funcname"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarlist(com.generator.generators.lua.parser.LuaParser.VarlistContext arg) {
		System.out.println("Varlist");
		final Node node = model.findOrCreate(Label.label("Varlist"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamelist(com.generator.generators.lua.parser.LuaParser.NamelistContext arg) {
		System.out.println("Namelist");
		final Node node = model.findOrCreate(Label.label("Namelist"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplist(com.generator.generators.lua.parser.LuaParser.ExplistContext arg) {
		System.out.println("Explist");
		final Node node = model.findOrCreate(Label.label("Explist"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExp(com.generator.generators.lua.parser.LuaParser.ExpContext arg) {
		System.out.println("Exp");
		final Node node = model.findOrCreate(Label.label("Exp"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixexp(com.generator.generators.lua.parser.LuaParser.PrefixexpContext arg) {
		System.out.println("Prefixexp");
		final Node node = model.findOrCreate(Label.label("Prefixexp"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctioncall(com.generator.generators.lua.parser.LuaParser.FunctioncallContext arg) {
		System.out.println("Functioncall");
		final Node node = model.findOrCreate(Label.label("Functioncall"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrExp(com.generator.generators.lua.parser.LuaParser.VarOrExpContext arg) {
		System.out.println("VarOrExp");
		final Node node = model.findOrCreate(Label.label("VarOrExp"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarSuffix(com.generator.generators.lua.parser.LuaParser.VarSuffixContext arg) {
		System.out.println("VarSuffix");
		final Node node = model.findOrCreate(Label.label("VarSuffix"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNameAndArgs(com.generator.generators.lua.parser.LuaParser.NameAndArgsContext arg) {
		System.out.println("NameAndArgs");
		final Node node = model.findOrCreate(Label.label("NameAndArgs"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgs(com.generator.generators.lua.parser.LuaParser.ArgsContext arg) {
		System.out.println("Args");
		final Node node = model.findOrCreate(Label.label("Args"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctiondef(com.generator.generators.lua.parser.LuaParser.FunctiondefContext arg) {
		System.out.println("Functiondef");
		final Node node = model.findOrCreate(Label.label("Functiondef"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncbody(com.generator.generators.lua.parser.LuaParser.FuncbodyContext arg) {
		System.out.println("Funcbody");
		final Node node = model.findOrCreate(Label.label("Funcbody"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParlist(com.generator.generators.lua.parser.LuaParser.ParlistContext arg) {
		System.out.println("Parlist");
		final Node node = model.findOrCreate(Label.label("Parlist"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTableconstructor(com.generator.generators.lua.parser.LuaParser.TableconstructorContext arg) {
		System.out.println("Tableconstructor");
		final Node node = model.findOrCreate(Label.label("Tableconstructor"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldlist(com.generator.generators.lua.parser.LuaParser.FieldlistContext arg) {
		System.out.println("Fieldlist");
		final Node node = model.findOrCreate(Label.label("Fieldlist"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldsep(com.generator.generators.lua.parser.LuaParser.FieldsepContext arg) {
		System.out.println("Fieldsep");
		final Node node = model.findOrCreate(Label.label("Fieldsep"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorOr(com.generator.generators.lua.parser.LuaParser.OperatorOrContext arg) {
		System.out.println("OperatorOr");
		final Node node = model.findOrCreate(Label.label("OperatorOr"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAnd(com.generator.generators.lua.parser.LuaParser.OperatorAndContext arg) {
		System.out.println("OperatorAnd");
		final Node node = model.findOrCreate(Label.label("OperatorAnd"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorComparison(com.generator.generators.lua.parser.LuaParser.OperatorComparisonContext arg) {
		System.out.println("OperatorComparison");
		final Node node = model.findOrCreate(Label.label("OperatorComparison"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorStrcat(com.generator.generators.lua.parser.LuaParser.OperatorStrcatContext arg) {
		System.out.println("OperatorStrcat");
		final Node node = model.findOrCreate(Label.label("OperatorStrcat"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAddSub(com.generator.generators.lua.parser.LuaParser.OperatorAddSubContext arg) {
		System.out.println("OperatorAddSub");
		final Node node = model.findOrCreate(Label.label("OperatorAddSub"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorMulDivMod(com.generator.generators.lua.parser.LuaParser.OperatorMulDivModContext arg) {
		System.out.println("OperatorMulDivMod");
		final Node node = model.findOrCreate(Label.label("OperatorMulDivMod"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorBitwise(com.generator.generators.lua.parser.LuaParser.OperatorBitwiseContext arg) {
		System.out.println("OperatorBitwise");
		final Node node = model.findOrCreate(Label.label("OperatorBitwise"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorUnary(com.generator.generators.lua.parser.LuaParser.OperatorUnaryContext arg) {
		System.out.println("OperatorUnary");
		final Node node = model.findOrCreate(Label.label("OperatorUnary"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorPower(com.generator.generators.lua.parser.LuaParser.OperatorPowerContext arg) {
		System.out.println("OperatorPower");
		final Node node = model.findOrCreate(Label.label("OperatorPower"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}