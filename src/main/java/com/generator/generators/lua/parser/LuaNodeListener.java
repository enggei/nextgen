package com.generator.generators.lua.parser;

public class LuaNodeListener extends LuaBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public LuaNodeListener() {
		this(false);
	}

	public LuaNodeListener(boolean debug) {
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

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.lua.parser.LuaParser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.lua.parser.LuaParser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inString = new java.util.Stack<>();

	@Override
	public void enterString(com.generator.generators.lua.parser.LuaParser.StringContext arg) {
		onEnter(new Node("String", arg.getText(), arg.getStart().getText()));
		this.inString.push(true);
	}

	public void exitString(com.generator.generators.lua.parser.LuaParser.StringContext arg) {
		onExit();
		this.inString.pop();
	}

	public boolean inString() {
      return !inString.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumber = new java.util.Stack<>();

	@Override
	public void enterNumber(com.generator.generators.lua.parser.LuaParser.NumberContext arg) {
		onEnter(new Node("Number", arg.getText(), arg.getStart().getText()));
		this.inNumber.push(true);
	}

	public void exitNumber(com.generator.generators.lua.parser.LuaParser.NumberContext arg) {
		onExit();
		this.inNumber.pop();
	}

	public boolean inNumber() {
      return !inNumber.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inField = new java.util.Stack<>();

	@Override
	public void enterField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		onEnter(new Node("Field", arg.getText(), arg.getStart().getText()));
		this.inField.push(true);
	}

	public void exitField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		onExit();
		this.inField.pop();
	}

	public boolean inField() {
      return !inField.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVar = new java.util.Stack<>();

	@Override
	public void enterVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		onEnter(new Node("Var", arg.getText(), arg.getStart().getText()));
		this.inVar.push(true);
	}

	public void exitVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		onExit();
		this.inVar.pop();
	}

	public boolean inVar() {
      return !inVar.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChunk = new java.util.Stack<>();

	@Override
	public void enterChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		onEnter(new Node("Chunk", arg.getText(), arg.getStart().getText()));
		this.inChunk.push(true);
	}

	public void exitChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		onExit();
		this.inChunk.pop();
	}

	public boolean inChunk() {
      return !inChunk.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStat = new java.util.Stack<>();

	@Override
	public void enterStat(com.generator.generators.lua.parser.LuaParser.StatContext arg) {
		onEnter(new Node("Stat", arg.getText(), arg.getStart().getText()));
		this.inStat.push(true);
	}

	public void exitStat(com.generator.generators.lua.parser.LuaParser.StatContext arg) {
		onExit();
		this.inStat.pop();
	}

	public boolean inStat() {
      return !inStat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRetstat = new java.util.Stack<>();

	@Override
	public void enterRetstat(com.generator.generators.lua.parser.LuaParser.RetstatContext arg) {
		onEnter(new Node("Retstat", arg.getText(), arg.getStart().getText()));
		this.inRetstat.push(true);
	}

	public void exitRetstat(com.generator.generators.lua.parser.LuaParser.RetstatContext arg) {
		onExit();
		this.inRetstat.pop();
	}

	public boolean inRetstat() {
      return !inRetstat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabel = new java.util.Stack<>();

	@Override
	public void enterLabel(com.generator.generators.lua.parser.LuaParser.LabelContext arg) {
		onEnter(new Node("Label", arg.getText(), arg.getStart().getText()));
		this.inLabel.push(true);
	}

	public void exitLabel(com.generator.generators.lua.parser.LuaParser.LabelContext arg) {
		onExit();
		this.inLabel.pop();
	}

	public boolean inLabel() {
      return !inLabel.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFuncname = new java.util.Stack<>();

	@Override
	public void enterFuncname(com.generator.generators.lua.parser.LuaParser.FuncnameContext arg) {
		onEnter(new Node("Funcname", arg.getText(), arg.getStart().getText()));
		this.inFuncname.push(true);
	}

	public void exitFuncname(com.generator.generators.lua.parser.LuaParser.FuncnameContext arg) {
		onExit();
		this.inFuncname.pop();
	}

	public boolean inFuncname() {
      return !inFuncname.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarlist = new java.util.Stack<>();

	@Override
	public void enterVarlist(com.generator.generators.lua.parser.LuaParser.VarlistContext arg) {
		onEnter(new Node("Varlist", arg.getText(), arg.getStart().getText()));
		this.inVarlist.push(true);
	}

	public void exitVarlist(com.generator.generators.lua.parser.LuaParser.VarlistContext arg) {
		onExit();
		this.inVarlist.pop();
	}

	public boolean inVarlist() {
      return !inVarlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamelist = new java.util.Stack<>();

	@Override
	public void enterNamelist(com.generator.generators.lua.parser.LuaParser.NamelistContext arg) {
		onEnter(new Node("Namelist", arg.getText(), arg.getStart().getText()));
		this.inNamelist.push(true);
	}

	public void exitNamelist(com.generator.generators.lua.parser.LuaParser.NamelistContext arg) {
		onExit();
		this.inNamelist.pop();
	}

	public boolean inNamelist() {
      return !inNamelist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExplist = new java.util.Stack<>();

	@Override
	public void enterExplist(com.generator.generators.lua.parser.LuaParser.ExplistContext arg) {
		onEnter(new Node("Explist", arg.getText(), arg.getStart().getText()));
		this.inExplist.push(true);
	}

	public void exitExplist(com.generator.generators.lua.parser.LuaParser.ExplistContext arg) {
		onExit();
		this.inExplist.pop();
	}

	public boolean inExplist() {
      return !inExplist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExp = new java.util.Stack<>();

	@Override
	public void enterExp(com.generator.generators.lua.parser.LuaParser.ExpContext arg) {
		onEnter(new Node("Exp", arg.getText(), arg.getStart().getText()));
		this.inExp.push(true);
	}

	public void exitExp(com.generator.generators.lua.parser.LuaParser.ExpContext arg) {
		onExit();
		this.inExp.pop();
	}

	public boolean inExp() {
      return !inExp.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrefixexp = new java.util.Stack<>();

	@Override
	public void enterPrefixexp(com.generator.generators.lua.parser.LuaParser.PrefixexpContext arg) {
		onEnter(new Node("Prefixexp", arg.getText(), arg.getStart().getText()));
		this.inPrefixexp.push(true);
	}

	public void exitPrefixexp(com.generator.generators.lua.parser.LuaParser.PrefixexpContext arg) {
		onExit();
		this.inPrefixexp.pop();
	}

	public boolean inPrefixexp() {
      return !inPrefixexp.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctioncall = new java.util.Stack<>();

	@Override
	public void enterFunctioncall(com.generator.generators.lua.parser.LuaParser.FunctioncallContext arg) {
		onEnter(new Node("Functioncall", arg.getText(), arg.getStart().getText()));
		this.inFunctioncall.push(true);
	}

	public void exitFunctioncall(com.generator.generators.lua.parser.LuaParser.FunctioncallContext arg) {
		onExit();
		this.inFunctioncall.pop();
	}

	public boolean inFunctioncall() {
      return !inFunctioncall.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarOrExp = new java.util.Stack<>();

	@Override
	public void enterVarOrExp(com.generator.generators.lua.parser.LuaParser.VarOrExpContext arg) {
		onEnter(new Node("VarOrExp", arg.getText(), arg.getStart().getText()));
		this.inVarOrExp.push(true);
	}

	public void exitVarOrExp(com.generator.generators.lua.parser.LuaParser.VarOrExpContext arg) {
		onExit();
		this.inVarOrExp.pop();
	}

	public boolean inVarOrExp() {
      return !inVarOrExp.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVarSuffix = new java.util.Stack<>();

	@Override
	public void enterVarSuffix(com.generator.generators.lua.parser.LuaParser.VarSuffixContext arg) {
		onEnter(new Node("VarSuffix", arg.getText(), arg.getStart().getText()));
		this.inVarSuffix.push(true);
	}

	public void exitVarSuffix(com.generator.generators.lua.parser.LuaParser.VarSuffixContext arg) {
		onExit();
		this.inVarSuffix.pop();
	}

	public boolean inVarSuffix() {
      return !inVarSuffix.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNameAndArgs = new java.util.Stack<>();

	@Override
	public void enterNameAndArgs(com.generator.generators.lua.parser.LuaParser.NameAndArgsContext arg) {
		onEnter(new Node("NameAndArgs", arg.getText(), arg.getStart().getText()));
		this.inNameAndArgs.push(true);
	}

	public void exitNameAndArgs(com.generator.generators.lua.parser.LuaParser.NameAndArgsContext arg) {
		onExit();
		this.inNameAndArgs.pop();
	}

	public boolean inNameAndArgs() {
      return !inNameAndArgs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgs = new java.util.Stack<>();

	@Override
	public void enterArgs(com.generator.generators.lua.parser.LuaParser.ArgsContext arg) {
		onEnter(new Node("Args", arg.getText(), arg.getStart().getText()));
		this.inArgs.push(true);
	}

	public void exitArgs(com.generator.generators.lua.parser.LuaParser.ArgsContext arg) {
		onExit();
		this.inArgs.pop();
	}

	public boolean inArgs() {
      return !inArgs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctiondef = new java.util.Stack<>();

	@Override
	public void enterFunctiondef(com.generator.generators.lua.parser.LuaParser.FunctiondefContext arg) {
		onEnter(new Node("Functiondef", arg.getText(), arg.getStart().getText()));
		this.inFunctiondef.push(true);
	}

	public void exitFunctiondef(com.generator.generators.lua.parser.LuaParser.FunctiondefContext arg) {
		onExit();
		this.inFunctiondef.pop();
	}

	public boolean inFunctiondef() {
      return !inFunctiondef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFuncbody = new java.util.Stack<>();

	@Override
	public void enterFuncbody(com.generator.generators.lua.parser.LuaParser.FuncbodyContext arg) {
		onEnter(new Node("Funcbody", arg.getText(), arg.getStart().getText()));
		this.inFuncbody.push(true);
	}

	public void exitFuncbody(com.generator.generators.lua.parser.LuaParser.FuncbodyContext arg) {
		onExit();
		this.inFuncbody.pop();
	}

	public boolean inFuncbody() {
      return !inFuncbody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParlist = new java.util.Stack<>();

	@Override
	public void enterParlist(com.generator.generators.lua.parser.LuaParser.ParlistContext arg) {
		onEnter(new Node("Parlist", arg.getText(), arg.getStart().getText()));
		this.inParlist.push(true);
	}

	public void exitParlist(com.generator.generators.lua.parser.LuaParser.ParlistContext arg) {
		onExit();
		this.inParlist.pop();
	}

	public boolean inParlist() {
      return !inParlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTableconstructor = new java.util.Stack<>();

	@Override
	public void enterTableconstructor(com.generator.generators.lua.parser.LuaParser.TableconstructorContext arg) {
		onEnter(new Node("Tableconstructor", arg.getText(), arg.getStart().getText()));
		this.inTableconstructor.push(true);
	}

	public void exitTableconstructor(com.generator.generators.lua.parser.LuaParser.TableconstructorContext arg) {
		onExit();
		this.inTableconstructor.pop();
	}

	public boolean inTableconstructor() {
      return !inTableconstructor.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFieldlist = new java.util.Stack<>();

	@Override
	public void enterFieldlist(com.generator.generators.lua.parser.LuaParser.FieldlistContext arg) {
		onEnter(new Node("Fieldlist", arg.getText(), arg.getStart().getText()));
		this.inFieldlist.push(true);
	}

	public void exitFieldlist(com.generator.generators.lua.parser.LuaParser.FieldlistContext arg) {
		onExit();
		this.inFieldlist.pop();
	}

	public boolean inFieldlist() {
      return !inFieldlist.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFieldsep = new java.util.Stack<>();

	@Override
	public void enterFieldsep(com.generator.generators.lua.parser.LuaParser.FieldsepContext arg) {
		onEnter(new Node("Fieldsep", arg.getText(), arg.getStart().getText()));
		this.inFieldsep.push(true);
	}

	public void exitFieldsep(com.generator.generators.lua.parser.LuaParser.FieldsepContext arg) {
		onExit();
		this.inFieldsep.pop();
	}

	public boolean inFieldsep() {
      return !inFieldsep.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorOr = new java.util.Stack<>();

	@Override
	public void enterOperatorOr(com.generator.generators.lua.parser.LuaParser.OperatorOrContext arg) {
		onEnter(new Node("OperatorOr", arg.getText(), arg.getStart().getText()));
		this.inOperatorOr.push(true);
	}

	public void exitOperatorOr(com.generator.generators.lua.parser.LuaParser.OperatorOrContext arg) {
		onExit();
		this.inOperatorOr.pop();
	}

	public boolean inOperatorOr() {
      return !inOperatorOr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorAnd = new java.util.Stack<>();

	@Override
	public void enterOperatorAnd(com.generator.generators.lua.parser.LuaParser.OperatorAndContext arg) {
		onEnter(new Node("OperatorAnd", arg.getText(), arg.getStart().getText()));
		this.inOperatorAnd.push(true);
	}

	public void exitOperatorAnd(com.generator.generators.lua.parser.LuaParser.OperatorAndContext arg) {
		onExit();
		this.inOperatorAnd.pop();
	}

	public boolean inOperatorAnd() {
      return !inOperatorAnd.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorComparison = new java.util.Stack<>();

	@Override
	public void enterOperatorComparison(com.generator.generators.lua.parser.LuaParser.OperatorComparisonContext arg) {
		onEnter(new Node("OperatorComparison", arg.getText(), arg.getStart().getText()));
		this.inOperatorComparison.push(true);
	}

	public void exitOperatorComparison(com.generator.generators.lua.parser.LuaParser.OperatorComparisonContext arg) {
		onExit();
		this.inOperatorComparison.pop();
	}

	public boolean inOperatorComparison() {
      return !inOperatorComparison.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorStrcat = new java.util.Stack<>();

	@Override
	public void enterOperatorStrcat(com.generator.generators.lua.parser.LuaParser.OperatorStrcatContext arg) {
		onEnter(new Node("OperatorStrcat", arg.getText(), arg.getStart().getText()));
		this.inOperatorStrcat.push(true);
	}

	public void exitOperatorStrcat(com.generator.generators.lua.parser.LuaParser.OperatorStrcatContext arg) {
		onExit();
		this.inOperatorStrcat.pop();
	}

	public boolean inOperatorStrcat() {
      return !inOperatorStrcat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorAddSub = new java.util.Stack<>();

	@Override
	public void enterOperatorAddSub(com.generator.generators.lua.parser.LuaParser.OperatorAddSubContext arg) {
		onEnter(new Node("OperatorAddSub", arg.getText(), arg.getStart().getText()));
		this.inOperatorAddSub.push(true);
	}

	public void exitOperatorAddSub(com.generator.generators.lua.parser.LuaParser.OperatorAddSubContext arg) {
		onExit();
		this.inOperatorAddSub.pop();
	}

	public boolean inOperatorAddSub() {
      return !inOperatorAddSub.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorMulDivMod = new java.util.Stack<>();

	@Override
	public void enterOperatorMulDivMod(com.generator.generators.lua.parser.LuaParser.OperatorMulDivModContext arg) {
		onEnter(new Node("OperatorMulDivMod", arg.getText(), arg.getStart().getText()));
		this.inOperatorMulDivMod.push(true);
	}

	public void exitOperatorMulDivMod(com.generator.generators.lua.parser.LuaParser.OperatorMulDivModContext arg) {
		onExit();
		this.inOperatorMulDivMod.pop();
	}

	public boolean inOperatorMulDivMod() {
      return !inOperatorMulDivMod.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorBitwise = new java.util.Stack<>();

	@Override
	public void enterOperatorBitwise(com.generator.generators.lua.parser.LuaParser.OperatorBitwiseContext arg) {
		onEnter(new Node("OperatorBitwise", arg.getText(), arg.getStart().getText()));
		this.inOperatorBitwise.push(true);
	}

	public void exitOperatorBitwise(com.generator.generators.lua.parser.LuaParser.OperatorBitwiseContext arg) {
		onExit();
		this.inOperatorBitwise.pop();
	}

	public boolean inOperatorBitwise() {
      return !inOperatorBitwise.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorUnary = new java.util.Stack<>();

	@Override
	public void enterOperatorUnary(com.generator.generators.lua.parser.LuaParser.OperatorUnaryContext arg) {
		onEnter(new Node("OperatorUnary", arg.getText(), arg.getStart().getText()));
		this.inOperatorUnary.push(true);
	}

	public void exitOperatorUnary(com.generator.generators.lua.parser.LuaParser.OperatorUnaryContext arg) {
		onExit();
		this.inOperatorUnary.pop();
	}

	public boolean inOperatorUnary() {
      return !inOperatorUnary.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperatorPower = new java.util.Stack<>();

	@Override
	public void enterOperatorPower(com.generator.generators.lua.parser.LuaParser.OperatorPowerContext arg) {
		onEnter(new Node("OperatorPower", arg.getText(), arg.getStart().getText()));
		this.inOperatorPower.push(true);
	}

	public void exitOperatorPower(com.generator.generators.lua.parser.LuaParser.OperatorPowerContext arg) {
		onExit();
		this.inOperatorPower.pop();
	}

	public boolean inOperatorPower() {
      return !inOperatorPower.isEmpty(); 
   }

}