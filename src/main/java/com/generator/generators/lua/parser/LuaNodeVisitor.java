package com.generator.generators.lua.parser;

public class LuaNodeVisitor extends LuaBaseVisitor<LuaNodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public LuaNodeVisitor() {
		this(false);
	}

	public LuaNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " '" + node.value + "'");
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
	public Node visitBlock(com.generator.generators.lua.parser.LuaParser.BlockContext arg) {
		final Node node = new Node("Block", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.lua.parser.LuaParser.NumberContext arg) {
		final Node node = new Node("Number", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.lua.parser.LuaParser.StringContext arg) {
		final Node node = new Node("String", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		final Node node = new Node("Field", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		final Node node = new Node("Var", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		final Node node = new Node("Chunk", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStat(com.generator.generators.lua.parser.LuaParser.StatContext arg) {
		final Node node = new Node("Stat", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRetstat(com.generator.generators.lua.parser.LuaParser.RetstatContext arg) {
		final Node node = new Node("Retstat", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctioncall(com.generator.generators.lua.parser.LuaParser.FunctioncallContext arg) {
		final Node node = new Node("Functioncall", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabel(com.generator.generators.lua.parser.LuaParser.LabelContext arg) {
		final Node node = new Node("Label", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncname(com.generator.generators.lua.parser.LuaParser.FuncnameContext arg) {
		final Node node = new Node("Funcname", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarlist(com.generator.generators.lua.parser.LuaParser.VarlistContext arg) {
		final Node node = new Node("Varlist", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamelist(com.generator.generators.lua.parser.LuaParser.NamelistContext arg) {
		final Node node = new Node("Namelist", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExplist(com.generator.generators.lua.parser.LuaParser.ExplistContext arg) {
		final Node node = new Node("Explist", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExp(com.generator.generators.lua.parser.LuaParser.ExpContext arg) {
		final Node node = new Node("Exp", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixexp(com.generator.generators.lua.parser.LuaParser.PrefixexpContext arg) {
		final Node node = new Node("Prefixexp", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarOrExp(com.generator.generators.lua.parser.LuaParser.VarOrExpContext arg) {
		final Node node = new Node("VarOrExp", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarSuffix(com.generator.generators.lua.parser.LuaParser.VarSuffixContext arg) {
		final Node node = new Node("VarSuffix", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNameAndArgs(com.generator.generators.lua.parser.LuaParser.NameAndArgsContext arg) {
		final Node node = new Node("NameAndArgs", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgs(com.generator.generators.lua.parser.LuaParser.ArgsContext arg) {
		final Node node = new Node("Args", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctiondef(com.generator.generators.lua.parser.LuaParser.FunctiondefContext arg) {
		final Node node = new Node("Functiondef", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFuncbody(com.generator.generators.lua.parser.LuaParser.FuncbodyContext arg) {
		final Node node = new Node("Funcbody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParlist(com.generator.generators.lua.parser.LuaParser.ParlistContext arg) {
		final Node node = new Node("Parlist", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTableconstructor(com.generator.generators.lua.parser.LuaParser.TableconstructorContext arg) {
		final Node node = new Node("Tableconstructor", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldlist(com.generator.generators.lua.parser.LuaParser.FieldlistContext arg) {
		final Node node = new Node("Fieldlist", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldsep(com.generator.generators.lua.parser.LuaParser.FieldsepContext arg) {
		final Node node = new Node("Fieldsep", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorOr(com.generator.generators.lua.parser.LuaParser.OperatorOrContext arg) {
		final Node node = new Node("OperatorOr", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAnd(com.generator.generators.lua.parser.LuaParser.OperatorAndContext arg) {
		final Node node = new Node("OperatorAnd", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorComparison(com.generator.generators.lua.parser.LuaParser.OperatorComparisonContext arg) {
		final Node node = new Node("OperatorComparison", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorStrcat(com.generator.generators.lua.parser.LuaParser.OperatorStrcatContext arg) {
		final Node node = new Node("OperatorStrcat", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorAddSub(com.generator.generators.lua.parser.LuaParser.OperatorAddSubContext arg) {
		final Node node = new Node("OperatorAddSub", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorMulDivMod(com.generator.generators.lua.parser.LuaParser.OperatorMulDivModContext arg) {
		final Node node = new Node("OperatorMulDivMod", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorBitwise(com.generator.generators.lua.parser.LuaParser.OperatorBitwiseContext arg) {
		final Node node = new Node("OperatorBitwise", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorUnary(com.generator.generators.lua.parser.LuaParser.OperatorUnaryContext arg) {
		final Node node = new Node("OperatorUnary", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperatorPower(com.generator.generators.lua.parser.LuaParser.OperatorPowerContext arg) {
		final Node node = new Node("OperatorPower", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}