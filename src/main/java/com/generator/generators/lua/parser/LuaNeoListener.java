package com.generator.generators.lua.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class LuaNeoListener extends LuaBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public LuaNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public LuaNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.lua.parser.LuaParser.BlockContext arg) {
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inNumber.push(true);
	}

	public void exitNumber(com.generator.generators.lua.parser.LuaParser.NumberContext arg) {
		onExit();
		this.inNumber.pop();
	}

	public boolean inNumber() {
      return !inNumber.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVar = new java.util.Stack<>();

	@Override
	public void enterVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		final Node node = model.findOrCreate(Label.label("Var"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inVar.push(true);
	}

	public void exitVar(com.generator.generators.lua.parser.LuaParser.VarContext arg) {
		onExit();
		this.inVar.pop();
	}

	public boolean inVar() {
      return !inVar.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inField = new java.util.Stack<>();

	@Override
	public void enterField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		final Node node = model.findOrCreate(Label.label("Field"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inField.push(true);
	}

	public void exitField(com.generator.generators.lua.parser.LuaParser.FieldContext arg) {
		onExit();
		this.inField.pop();
	}

	public boolean inField() {
      return !inField.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFuncname = new java.util.Stack<>();

	@Override
	public void enterFuncname(com.generator.generators.lua.parser.LuaParser.FuncnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Funcname"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Varlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Namelist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Explist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Exp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Prefixexp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Functioncall"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("VarOrExp"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("VarSuffix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NameAndArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Functiondef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inFunctiondef.push(true);
	}

	public void exitFunctiondef(com.generator.generators.lua.parser.LuaParser.FunctiondefContext arg) {
		onExit();
		this.inFunctiondef.pop();
	}

	public boolean inFunctiondef() {
      return !inFunctiondef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChunk = new java.util.Stack<>();

	@Override
	public void enterChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		final Node node = model.findOrCreate(Label.label("Chunk"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inChunk.push(true);
	}

	public void exitChunk(com.generator.generators.lua.parser.LuaParser.ChunkContext arg) {
		onExit();
		this.inChunk.pop();
	}

	public boolean inChunk() {
      return !inChunk.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFuncbody = new java.util.Stack<>();

	@Override
	public void enterFuncbody(com.generator.generators.lua.parser.LuaParser.FuncbodyContext arg) {
		final Node node = model.findOrCreate(Label.label("Funcbody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Parlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Tableconstructor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Fieldlist"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Fieldsep"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorOr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorAnd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorComparison"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorStrcat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorAddSub"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorMulDivMod"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorBitwise"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorUnary"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("OperatorPower"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inOperatorPower.push(true);
	}

	public void exitOperatorPower(com.generator.generators.lua.parser.LuaParser.OperatorPowerContext arg) {
		onExit();
		this.inOperatorPower.pop();
	}

	public boolean inOperatorPower() {
      return !inOperatorPower.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStat = new java.util.Stack<>();

	@Override
	public void enterStat(com.generator.generators.lua.parser.LuaParser.StatContext arg) {
		final Node node = model.findOrCreate(Label.label("Stat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Retstat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Label"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inLabel.push(true);
	}

	public void exitLabel(com.generator.generators.lua.parser.LuaParser.LabelContext arg) {
		onExit();
		this.inLabel.pop();
	}

	public boolean inLabel() {
      return !inLabel.isEmpty(); 
   }

}