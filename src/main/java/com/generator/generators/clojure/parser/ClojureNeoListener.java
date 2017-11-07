package com.generator.generators.clojure.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ClojureNeoListener extends ClojureBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public ClojureNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public ClojureNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inFile = new java.util.Stack<>();

	@Override
	public void enterFile(com.generator.generators.clojure.parser.ClojureParser.FileContext arg) {
		final Node node = model.findOrCreate(Label.label("File"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFile.push(true);
	}

	public void exitFile(com.generator.generators.clojure.parser.ClojureParser.FileContext arg) {
		onExit();
		this.inFile.pop();
	}

	public boolean inFile() {
      return !inFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForm = new java.util.Stack<>();

	@Override
	public void enterForm(com.generator.generators.clojure.parser.ClojureParser.FormContext arg) {
		final Node node = model.findOrCreate(Label.label("Form"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForm.push(true);
	}

	public void exitForm(com.generator.generators.clojure.parser.ClojureParser.FormContext arg) {
		onExit();
		this.inForm.pop();
	}

	public boolean inForm() {
      return !inForm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inForms = new java.util.Stack<>();

	@Override
	public void enterForms(com.generator.generators.clojure.parser.ClojureParser.FormsContext arg) {
		final Node node = model.findOrCreate(Label.label("Forms"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inForms.push(true);
	}

	public void exitForms(com.generator.generators.clojure.parser.ClojureParser.FormsContext arg) {
		onExit();
		this.inForms.pop();
	}

	public boolean inForms() {
      return !inForms.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inList = new java.util.Stack<>();

	@Override
	public void enterList(com.generator.generators.clojure.parser.ClojureParser.ListContext arg) {
		final Node node = model.findOrCreate(Label.label("List"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inList.push(true);
	}

	public void exitList(com.generator.generators.clojure.parser.ClojureParser.ListContext arg) {
		onExit();
		this.inList.pop();
	}

	public boolean inList() {
      return !inList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVector = new java.util.Stack<>();

	@Override
	public void enterVector(com.generator.generators.clojure.parser.ClojureParser.VectorContext arg) {
		final Node node = model.findOrCreate(Label.label("Vector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVector.push(true);
	}

	public void exitVector(com.generator.generators.clojure.parser.ClojureParser.VectorContext arg) {
		onExit();
		this.inVector.pop();
	}

	public boolean inVector() {
      return !inVector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMap = new java.util.Stack<>();

	@Override
	public void enterMap(com.generator.generators.clojure.parser.ClojureParser.MapContext arg) {
		final Node node = model.findOrCreate(Label.label("Map"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMap.push(true);
	}

	public void exitMap(com.generator.generators.clojure.parser.ClojureParser.MapContext arg) {
		onExit();
		this.inMap.pop();
	}

	public boolean inMap() {
      return !inMap.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSet = new java.util.Stack<>();

	@Override
	public void enterSet(com.generator.generators.clojure.parser.ClojureParser.SetContext arg) {
		final Node node = model.findOrCreate(Label.label("Set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSet.push(true);
	}

	public void exitSet(com.generator.generators.clojure.parser.ClojureParser.SetContext arg) {
		onExit();
		this.inSet.pop();
	}

	public boolean inSet() {
      return !inSet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inReader_macro = new java.util.Stack<>();

	@Override
	public void enterReader_macro(com.generator.generators.clojure.parser.ClojureParser.Reader_macroContext arg) {
		final Node node = model.findOrCreate(Label.label("Reader_macro"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inReader_macro.push(true);
	}

	public void exitReader_macro(com.generator.generators.clojure.parser.ClojureParser.Reader_macroContext arg) {
		onExit();
		this.inReader_macro.pop();
	}

	public boolean inReader_macro() {
      return !inReader_macro.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inQuote = new java.util.Stack<>();

	@Override
	public void enterQuote(com.generator.generators.clojure.parser.ClojureParser.QuoteContext arg) {
		final Node node = model.findOrCreate(Label.label("Quote"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inQuote.push(true);
	}

	public void exitQuote(com.generator.generators.clojure.parser.ClojureParser.QuoteContext arg) {
		onExit();
		this.inQuote.pop();
	}

	public boolean inQuote() {
      return !inQuote.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBacktick = new java.util.Stack<>();

	@Override
	public void enterBacktick(com.generator.generators.clojure.parser.ClojureParser.BacktickContext arg) {
		final Node node = model.findOrCreate(Label.label("Backtick"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBacktick.push(true);
	}

	public void exitBacktick(com.generator.generators.clojure.parser.ClojureParser.BacktickContext arg) {
		onExit();
		this.inBacktick.pop();
	}

	public boolean inBacktick() {
      return !inBacktick.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnquote = new java.util.Stack<>();

	@Override
	public void enterUnquote(com.generator.generators.clojure.parser.ClojureParser.UnquoteContext arg) {
		final Node node = model.findOrCreate(Label.label("Unquote"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnquote.push(true);
	}

	public void exitUnquote(com.generator.generators.clojure.parser.ClojureParser.UnquoteContext arg) {
		onExit();
		this.inUnquote.pop();
	}

	public boolean inUnquote() {
      return !inUnquote.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnquote_splicing = new java.util.Stack<>();

	@Override
	public void enterUnquote_splicing(com.generator.generators.clojure.parser.ClojureParser.Unquote_splicingContext arg) {
		final Node node = model.findOrCreate(Label.label("Unquote_splicing"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inUnquote_splicing.push(true);
	}

	public void exitUnquote_splicing(com.generator.generators.clojure.parser.ClojureParser.Unquote_splicingContext arg) {
		onExit();
		this.inUnquote_splicing.pop();
	}

	public boolean inUnquote_splicing() {
      return !inUnquote_splicing.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTag = new java.util.Stack<>();

	@Override
	public void enterTag(com.generator.generators.clojure.parser.ClojureParser.TagContext arg) {
		final Node node = model.findOrCreate(Label.label("Tag"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTag.push(true);
	}

	public void exitTag(com.generator.generators.clojure.parser.ClojureParser.TagContext arg) {
		onExit();
		this.inTag.pop();
	}

	public boolean inTag() {
      return !inTag.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeref = new java.util.Stack<>();

	@Override
	public void enterDeref(com.generator.generators.clojure.parser.ClojureParser.DerefContext arg) {
		final Node node = model.findOrCreate(Label.label("Deref"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDeref.push(true);
	}

	public void exitDeref(com.generator.generators.clojure.parser.ClojureParser.DerefContext arg) {
		onExit();
		this.inDeref.pop();
	}

	public boolean inDeref() {
      return !inDeref.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGensym = new java.util.Stack<>();

	@Override
	public void enterGensym(com.generator.generators.clojure.parser.ClojureParser.GensymContext arg) {
		final Node node = model.findOrCreate(Label.label("Gensym"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inGensym.push(true);
	}

	public void exitGensym(com.generator.generators.clojure.parser.ClojureParser.GensymContext arg) {
		onExit();
		this.inGensym.pop();
	}

	public boolean inGensym() {
      return !inGensym.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLambda = new java.util.Stack<>();

	@Override
	public void enterLambda(com.generator.generators.clojure.parser.ClojureParser.LambdaContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambda"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLambda.push(true);
	}

	public void exitLambda(com.generator.generators.clojure.parser.ClojureParser.LambdaContext arg) {
		onExit();
		this.inLambda.pop();
	}

	public boolean inLambda() {
      return !inLambda.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMeta_data = new java.util.Stack<>();

	@Override
	public void enterMeta_data(com.generator.generators.clojure.parser.ClojureParser.Meta_dataContext arg) {
		final Node node = model.findOrCreate(Label.label("Meta_data"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMeta_data.push(true);
	}

	public void exitMeta_data(com.generator.generators.clojure.parser.ClojureParser.Meta_dataContext arg) {
		onExit();
		this.inMeta_data.pop();
	}

	public boolean inMeta_data() {
      return !inMeta_data.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVar_quote = new java.util.Stack<>();

	@Override
	public void enterVar_quote(com.generator.generators.clojure.parser.ClojureParser.Var_quoteContext arg) {
		final Node node = model.findOrCreate(Label.label("Var_quote"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVar_quote.push(true);
	}

	public void exitVar_quote(com.generator.generators.clojure.parser.ClojureParser.Var_quoteContext arg) {
		onExit();
		this.inVar_quote.pop();
	}

	public boolean inVar_quote() {
      return !inVar_quote.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHost_expr = new java.util.Stack<>();

	@Override
	public void enterHost_expr(com.generator.generators.clojure.parser.ClojureParser.Host_exprContext arg) {
		final Node node = model.findOrCreate(Label.label("Host_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHost_expr.push(true);
	}

	public void exitHost_expr(com.generator.generators.clojure.parser.ClojureParser.Host_exprContext arg) {
		onExit();
		this.inHost_expr.pop();
	}

	public boolean inHost_expr() {
      return !inHost_expr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDiscard = new java.util.Stack<>();

	@Override
	public void enterDiscard(com.generator.generators.clojure.parser.ClojureParser.DiscardContext arg) {
		final Node node = model.findOrCreate(Label.label("Discard"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDiscard.push(true);
	}

	public void exitDiscard(com.generator.generators.clojure.parser.ClojureParser.DiscardContext arg) {
		onExit();
		this.inDiscard.pop();
	}

	public boolean inDiscard() {
      return !inDiscard.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDispatch = new java.util.Stack<>();

	@Override
	public void enterDispatch(com.generator.generators.clojure.parser.ClojureParser.DispatchContext arg) {
		final Node node = model.findOrCreate(Label.label("Dispatch"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDispatch.push(true);
	}

	public void exitDispatch(com.generator.generators.clojure.parser.ClojureParser.DispatchContext arg) {
		onExit();
		this.inDispatch.pop();
	}

	public boolean inDispatch() {
      return !inDispatch.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRegex = new java.util.Stack<>();

	@Override
	public void enterRegex(com.generator.generators.clojure.parser.ClojureParser.RegexContext arg) {
		final Node node = model.findOrCreate(Label.label("Regex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inRegex.push(true);
	}

	public void exitRegex(com.generator.generators.clojure.parser.ClojureParser.RegexContext arg) {
		onExit();
		this.inRegex.pop();
	}

	public boolean inRegex() {
      return !inRegex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLiteral = new java.util.Stack<>();

	@Override
	public void enterLiteral(com.generator.generators.clojure.parser.ClojureParser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inLiteral.push(true);
	}

	public void exitLiteral(com.generator.generators.clojure.parser.ClojureParser.LiteralContext arg) {
		onExit();
		this.inLiteral.pop();
	}

	public boolean inLiteral() {
      return !inLiteral.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inString = new java.util.Stack<>();

	@Override
	public void enterString(com.generator.generators.clojure.parser.ClojureParser.StringContext arg) {
		final Node node = model.findOrCreate(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inString.push(true);
	}

	public void exitString(com.generator.generators.clojure.parser.ClojureParser.StringContext arg) {
		onExit();
		this.inString.pop();
	}

	public boolean inString() {
      return !inString.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHex = new java.util.Stack<>();

	@Override
	public void enterHex(com.generator.generators.clojure.parser.ClojureParser.HexContext arg) {
		final Node node = model.findOrCreate(Label.label("Hex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHex.push(true);
	}

	public void exitHex(com.generator.generators.clojure.parser.ClojureParser.HexContext arg) {
		onExit();
		this.inHex.pop();
	}

	public boolean inHex() {
      return !inHex.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBin = new java.util.Stack<>();

	@Override
	public void enterBin(com.generator.generators.clojure.parser.ClojureParser.BinContext arg) {
		final Node node = model.findOrCreate(Label.label("Bin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBin.push(true);
	}

	public void exitBin(com.generator.generators.clojure.parser.ClojureParser.BinContext arg) {
		onExit();
		this.inBin.pop();
	}

	public boolean inBin() {
      return !inBin.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBign = new java.util.Stack<>();

	@Override
	public void enterBign(com.generator.generators.clojure.parser.ClojureParser.BignContext arg) {
		final Node node = model.findOrCreate(Label.label("Bign"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBign.push(true);
	}

	public void exitBign(com.generator.generators.clojure.parser.ClojureParser.BignContext arg) {
		onExit();
		this.inBign.pop();
	}

	public boolean inBign() {
      return !inBign.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumber = new java.util.Stack<>();

	@Override
	public void enterNumber(com.generator.generators.clojure.parser.ClojureParser.NumberContext arg) {
		final Node node = model.findOrCreate(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNumber.push(true);
	}

	public void exitNumber(com.generator.generators.clojure.parser.ClojureParser.NumberContext arg) {
		onExit();
		this.inNumber.pop();
	}

	public boolean inNumber() {
      return !inNumber.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCharacter = new java.util.Stack<>();

	@Override
	public void enterCharacter(com.generator.generators.clojure.parser.ClojureParser.CharacterContext arg) {
		final Node node = model.findOrCreate(Label.label("Character"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inCharacter.push(true);
	}

	public void exitCharacter(com.generator.generators.clojure.parser.ClojureParser.CharacterContext arg) {
		onExit();
		this.inCharacter.pop();
	}

	public boolean inCharacter() {
      return !inCharacter.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamed_char = new java.util.Stack<>();

	@Override
	public void enterNamed_char(com.generator.generators.clojure.parser.ClojureParser.Named_charContext arg) {
		final Node node = model.findOrCreate(Label.label("Named_char"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNamed_char.push(true);
	}

	public void exitNamed_char(com.generator.generators.clojure.parser.ClojureParser.Named_charContext arg) {
		onExit();
		this.inNamed_char.pop();
	}

	public boolean inNamed_char() {
      return !inNamed_char.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAny_char = new java.util.Stack<>();

	@Override
	public void enterAny_char(com.generator.generators.clojure.parser.ClojureParser.Any_charContext arg) {
		final Node node = model.findOrCreate(Label.label("Any_char"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAny_char.push(true);
	}

	public void exitAny_char(com.generator.generators.clojure.parser.ClojureParser.Any_charContext arg) {
		onExit();
		this.inAny_char.pop();
	}

	public boolean inAny_char() {
      return !inAny_char.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inU_hex_quad = new java.util.Stack<>();

	@Override
	public void enterU_hex_quad(com.generator.generators.clojure.parser.ClojureParser.U_hex_quadContext arg) {
		final Node node = model.findOrCreate(Label.label("U_hex_quad"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inU_hex_quad.push(true);
	}

	public void exitU_hex_quad(com.generator.generators.clojure.parser.ClojureParser.U_hex_quadContext arg) {
		onExit();
		this.inU_hex_quad.pop();
	}

	public boolean inU_hex_quad() {
      return !inU_hex_quad.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNil = new java.util.Stack<>();

	@Override
	public void enterNil(com.generator.generators.clojure.parser.ClojureParser.NilContext arg) {
		final Node node = model.findOrCreate(Label.label("Nil"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNil.push(true);
	}

	public void exitNil(com.generator.generators.clojure.parser.ClojureParser.NilContext arg) {
		onExit();
		this.inNil.pop();
	}

	public boolean inNil() {
      return !inNil.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyword = new java.util.Stack<>();

	@Override
	public void enterKeyword(com.generator.generators.clojure.parser.ClojureParser.KeywordContext arg) {
		final Node node = model.findOrCreate(Label.label("Keyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inKeyword.push(true);
	}

	public void exitKeyword(com.generator.generators.clojure.parser.ClojureParser.KeywordContext arg) {
		onExit();
		this.inKeyword.pop();
	}

	public boolean inKeyword() {
      return !inKeyword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimple_keyword = new java.util.Stack<>();

	@Override
	public void enterSimple_keyword(com.generator.generators.clojure.parser.ClojureParser.Simple_keywordContext arg) {
		final Node node = model.findOrCreate(Label.label("Simple_keyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimple_keyword.push(true);
	}

	public void exitSimple_keyword(com.generator.generators.clojure.parser.ClojureParser.Simple_keywordContext arg) {
		onExit();
		this.inSimple_keyword.pop();
	}

	public boolean inSimple_keyword() {
      return !inSimple_keyword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMacro_keyword = new java.util.Stack<>();

	@Override
	public void enterMacro_keyword(com.generator.generators.clojure.parser.ClojureParser.Macro_keywordContext arg) {
		final Node node = model.findOrCreate(Label.label("Macro_keyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inMacro_keyword.push(true);
	}

	public void exitMacro_keyword(com.generator.generators.clojure.parser.ClojureParser.Macro_keywordContext arg) {
		onExit();
		this.inMacro_keyword.pop();
	}

	public boolean inMacro_keyword() {
      return !inMacro_keyword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSymbol = new java.util.Stack<>();

	@Override
	public void enterSymbol(com.generator.generators.clojure.parser.ClojureParser.SymbolContext arg) {
		final Node node = model.findOrCreate(Label.label("Symbol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSymbol.push(true);
	}

	public void exitSymbol(com.generator.generators.clojure.parser.ClojureParser.SymbolContext arg) {
		onExit();
		this.inSymbol.pop();
	}

	public boolean inSymbol() {
      return !inSymbol.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimple_sym = new java.util.Stack<>();

	@Override
	public void enterSimple_sym(com.generator.generators.clojure.parser.ClojureParser.Simple_symContext arg) {
		final Node node = model.findOrCreate(Label.label("Simple_sym"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSimple_sym.push(true);
	}

	public void exitSimple_sym(com.generator.generators.clojure.parser.ClojureParser.Simple_symContext arg) {
		onExit();
		this.inSimple_sym.pop();
	}

	public boolean inSimple_sym() {
      return !inSimple_sym.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNs_symbol = new java.util.Stack<>();

	@Override
	public void enterNs_symbol(com.generator.generators.clojure.parser.ClojureParser.Ns_symbolContext arg) {
		final Node node = model.findOrCreate(Label.label("Ns_symbol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNs_symbol.push(true);
	}

	public void exitNs_symbol(com.generator.generators.clojure.parser.ClojureParser.Ns_symbolContext arg) {
		onExit();
		this.inNs_symbol.pop();
	}

	public boolean inNs_symbol() {
      return !inNs_symbol.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParam_name = new java.util.Stack<>();

	@Override
	public void enterParam_name(com.generator.generators.clojure.parser.ClojureParser.Param_nameContext arg) {
		final Node node = model.findOrCreate(Label.label("Param_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inParam_name.push(true);
	}

	public void exitParam_name(com.generator.generators.clojure.parser.ClojureParser.Param_nameContext arg) {
		onExit();
		this.inParam_name.pop();
	}

	public boolean inParam_name() {
      return !inParam_name.isEmpty(); 
   }

}