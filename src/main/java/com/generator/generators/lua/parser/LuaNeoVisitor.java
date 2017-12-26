package com.generator.generators.lua.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class LuaNeoVisitor extends LuaBaseVisitor<Node> {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LuaNeoVisitor.class);

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
	public Node visitStat(com.generator.generators.lua.parser.LuaParser.StatContext arg) {
		log.info("Stat");
		final Node node = model.newNode(Label.label("Stat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRetstat(com.generator.generators.lua.parser.LuaParser.RetstatContext arg) {
		log.info("Retstat");
		final Node node = model.newNode(Label.label("Retstat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabel(com.generator.generators.lua.parser.LuaParser.LabelContext arg) {
		log.info("Label");
		final Node node = model.newNode(Label.label("Label"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncname(com.generator.generators.lua.parser.LuaParser.FuncnameContext arg) {
		log.info("Funcname");
		final Node node = model.newNode(Label.label("Funcname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarlist(com.generator.generators.lua.parser.LuaParser.VarlistContext arg) {
		log.info("Varlist");
		final Node node = model.newNode(Label.label("Varlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamelist(com.generator.generators.lua.parser.LuaParser.NamelistContext arg) {
		log.info("Namelist");
		final Node node = model.newNode(Label.label("Namelist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplist(com.generator.generators.lua.parser.LuaParser.ExplistContext arg) {
		log.info("Explist");
		final Node node = model.newNode(Label.label("Explist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixexp(com.generator.generators.lua.parser.LuaParser.PrefixexpContext arg) {
		log.info("Prefixexp");
		final Node node = model.newNode(Label.label("Prefixexp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		log.info("Chunk");
		final Node node = model.newNode(Label.label("Chunk"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctioncall(com.generator.generators.lua.parser.LuaParser.FunctioncallContext arg) {
		log.info("Functioncall");
		final Node node = model.newNode(Label.label("Functioncall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrExp(com.generator.generators.lua.parser.LuaParser.VarOrExpContext arg) {
		log.info("VarOrExp");
		final Node node = model.newNode(Label.label("VarOrExp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarSuffix(com.generator.generators.lua.parser.LuaParser.VarSuffixContext arg) {
		log.info("VarSuffix");
		final Node node = model.newNode(Label.label("VarSuffix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNameAndArgs(com.generator.generators.lua.parser.LuaParser.NameAndArgsContext arg) {
		log.info("NameAndArgs");
		final Node node = model.newNode(Label.label("NameAndArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgs(com.generator.generators.lua.parser.LuaParser.ArgsContext arg) {
		log.info("Args");
		final Node node = model.newNode(Label.label("Args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctiondef(com.generator.generators.lua.parser.LuaParser.FunctiondefContext arg) {
		log.info("Functiondef");
		final Node node = model.newNode(Label.label("Functiondef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncbody(com.generator.generators.lua.parser.LuaParser.FuncbodyContext arg) {
		log.info("Funcbody");
		final Node node = model.newNode(Label.label("Funcbody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParlist(com.generator.generators.lua.parser.LuaParser.ParlistContext arg) {
		log.info("Parlist");
		final Node node = model.newNode(Label.label("Parlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTableconstructor(com.generator.generators.lua.parser.LuaParser.TableconstructorContext arg) {
		log.info("Tableconstructor");
		final Node node = model.newNode(Label.label("Tableconstructor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldlist(com.generator.generators.lua.parser.LuaParser.FieldlistContext arg) {
		log.info("Fieldlist");
		final Node node = model.newNode(Label.label("Fieldlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldsep(com.generator.generators.lua.parser.LuaParser.FieldsepContext arg) {
		log.info("Fieldsep");
		final Node node = model.newNode(Label.label("Fieldsep"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorOr(com.generator.generators.lua.parser.LuaParser.OperatorOrContext arg) {
		log.info("OperatorOr");
		final Node node = model.newNode(Label.label("OperatorOr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAnd(com.generator.generators.lua.parser.LuaParser.OperatorAndContext arg) {
		log.info("OperatorAnd");
		final Node node = model.newNode(Label.label("OperatorAnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorComparison(com.generator.generators.lua.parser.LuaParser.OperatorComparisonContext arg) {
		log.info("OperatorComparison");
		final Node node = model.newNode(Label.label("OperatorComparison"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorStrcat(com.generator.generators.lua.parser.LuaParser.OperatorStrcatContext arg) {
		log.info("OperatorStrcat");
		final Node node = model.newNode(Label.label("OperatorStrcat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAddSub(com.generator.generators.lua.parser.LuaParser.OperatorAddSubContext arg) {
		log.info("OperatorAddSub");
		final Node node = model.newNode(Label.label("OperatorAddSub"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorMulDivMod(com.generator.generators.lua.parser.LuaParser.OperatorMulDivModContext arg) {
		log.info("OperatorMulDivMod");
		final Node node = model.newNode(Label.label("OperatorMulDivMod"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorBitwise(com.generator.generators.lua.parser.LuaParser.OperatorBitwiseContext arg) {
		log.info("OperatorBitwise");
		final Node node = model.newNode(Label.label("OperatorBitwise"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorUnary(com.generator.generators.lua.parser.LuaParser.OperatorUnaryContext arg) {
		log.info("OperatorUnary");
		final Node node = model.newNode(Label.label("OperatorUnary"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorPower(com.generator.generators.lua.parser.LuaParser.OperatorPowerContext arg) {
		log.info("OperatorPower");
		final Node node = model.newNode(Label.label("OperatorPower"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock(com.generator.generators.lua.parser.LuaParser.BlockContext arg) {
		log.info("Block");
		final Node node = model.newNode(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.lua.parser.LuaParser.StringContext arg) {
		log.info("String");
		final Node node = model.newNode(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.lua.parser.LuaParser.NumberContext arg) {
		log.info("Number");
		final Node node = model.newNode(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		log.info("Var");
		final Node node = model.newNode(Label.label("Var"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		log.info("Field");
		final Node node = model.newNode(Label.label("Field"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExp(com.generator.generators.lua.parser.LuaParser.ExpContext arg) {
		log.info("Exp");
		final Node node = model.newNode(Label.label("Exp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}