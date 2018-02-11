package com.generator.generators.clojure.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ClojureNeoVisitor extends ClojureBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ClojureNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public ClojureNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitMeta_data(com.generator.generators.clojure.parser.ClojureParser.Meta_dataContext arg) {
		log.info("Meta_data");
		final Node node = model.newNode(Label.label("Meta_data"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar_quote(com.generator.generators.clojure.parser.ClojureParser.Var_quoteContext arg) {
		log.info("Var_quote");
		final Node node = model.newNode(Label.label("Var_quote"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHost_expr(com.generator.generators.clojure.parser.ClojureParser.Host_exprContext arg) {
		log.info("Host_expr");
		final Node node = model.newNode(Label.label("Host_expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDiscard(com.generator.generators.clojure.parser.ClojureParser.DiscardContext arg) {
		log.info("Discard");
		final Node node = model.newNode(Label.label("Discard"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDispatch(com.generator.generators.clojure.parser.ClojureParser.DispatchContext arg) {
		log.info("Dispatch");
		final Node node = model.newNode(Label.label("Dispatch"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegex(com.generator.generators.clojure.parser.ClojureParser.RegexContext arg) {
		log.info("Regex");
		final Node node = model.newNode(Label.label("Regex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.clojure.parser.ClojureParser.LiteralContext arg) {
		log.info("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.clojure.parser.ClojureParser.StringContext arg) {
		log.info("String");
		final Node node = model.newNode(Label.label("String"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile(com.generator.generators.clojure.parser.ClojureParser.FileContext arg) {
		log.info("File");
		final Node node = model.newNode(Label.label("File"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnquote(com.generator.generators.clojure.parser.ClojureParser.UnquoteContext arg) {
		log.info("Unquote");
		final Node node = model.newNode(Label.label("Unquote"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnquote_splicing(com.generator.generators.clojure.parser.ClojureParser.Unquote_splicingContext arg) {
		log.info("Unquote_splicing");
		final Node node = model.newNode(Label.label("Unquote_splicing"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTag(com.generator.generators.clojure.parser.ClojureParser.TagContext arg) {
		log.info("Tag");
		final Node node = model.newNode(Label.label("Tag"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeref(com.generator.generators.clojure.parser.ClojureParser.DerefContext arg) {
		log.info("Deref");
		final Node node = model.newNode(Label.label("Deref"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGensym(com.generator.generators.clojure.parser.ClojureParser.GensymContext arg) {
		log.info("Gensym");
		final Node node = model.newNode(Label.label("Gensym"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambda(com.generator.generators.clojure.parser.ClojureParser.LambdaContext arg) {
		log.info("Lambda");
		final Node node = model.newNode(Label.label("Lambda"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet(com.generator.generators.clojure.parser.ClojureParser.SetContext arg) {
		log.info("Set");
		final Node node = model.newNode(Label.label("Set"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForm(com.generator.generators.clojure.parser.ClojureParser.FormContext arg) {
		log.info("Form");
		final Node node = model.newNode(Label.label("Form"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForms(com.generator.generators.clojure.parser.ClojureParser.FormsContext arg) {
		log.info("Forms");
		final Node node = model.newNode(Label.label("Forms"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitList(com.generator.generators.clojure.parser.ClojureParser.ListContext arg) {
		log.info("List");
		final Node node = model.newNode(Label.label("List"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVector(com.generator.generators.clojure.parser.ClojureParser.VectorContext arg) {
		log.info("Vector");
		final Node node = model.newNode(Label.label("Vector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMap(com.generator.generators.clojure.parser.ClojureParser.MapContext arg) {
		log.info("Map");
		final Node node = model.newNode(Label.label("Map"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReader_macro(com.generator.generators.clojure.parser.ClojureParser.Reader_macroContext arg) {
		log.info("Reader_macro");
		final Node node = model.newNode(Label.label("Reader_macro"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuote(com.generator.generators.clojure.parser.ClojureParser.QuoteContext arg) {
		log.info("Quote");
		final Node node = model.newNode(Label.label("Quote"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBacktick(com.generator.generators.clojure.parser.ClojureParser.BacktickContext arg) {
		log.info("Backtick");
		final Node node = model.newNode(Label.label("Backtick"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHex(com.generator.generators.clojure.parser.ClojureParser.HexContext arg) {
		log.info("Hex");
		final Node node = model.newNode(Label.label("Hex"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBin(com.generator.generators.clojure.parser.ClojureParser.BinContext arg) {
		log.info("Bin");
		final Node node = model.newNode(Label.label("Bin"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBign(com.generator.generators.clojure.parser.ClojureParser.BignContext arg) {
		log.info("Bign");
		final Node node = model.newNode(Label.label("Bign"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.clojure.parser.ClojureParser.NumberContext arg) {
		log.info("Number");
		final Node node = model.newNode(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharacter(com.generator.generators.clojure.parser.ClojureParser.CharacterContext arg) {
		log.info("Character");
		final Node node = model.newNode(Label.label("Character"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamed_char(com.generator.generators.clojure.parser.ClojureParser.Named_charContext arg) {
		log.info("Named_char");
		final Node node = model.newNode(Label.label("Named_char"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAny_char(com.generator.generators.clojure.parser.ClojureParser.Any_charContext arg) {
		log.info("Any_char");
		final Node node = model.newNode(Label.label("Any_char"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitU_hex_quad(com.generator.generators.clojure.parser.ClojureParser.U_hex_quadContext arg) {
		log.info("U_hex_quad");
		final Node node = model.newNode(Label.label("U_hex_quad"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNil(com.generator.generators.clojure.parser.ClojureParser.NilContext arg) {
		log.info("Nil");
		final Node node = model.newNode(Label.label("Nil"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyword(com.generator.generators.clojure.parser.ClojureParser.KeywordContext arg) {
		log.info("Keyword");
		final Node node = model.newNode(Label.label("Keyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_keyword(com.generator.generators.clojure.parser.ClojureParser.Simple_keywordContext arg) {
		log.info("Simple_keyword");
		final Node node = model.newNode(Label.label("Simple_keyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMacro_keyword(com.generator.generators.clojure.parser.ClojureParser.Macro_keywordContext arg) {
		log.info("Macro_keyword");
		final Node node = model.newNode(Label.label("Macro_keyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSymbol(com.generator.generators.clojure.parser.ClojureParser.SymbolContext arg) {
		log.info("Symbol");
		final Node node = model.newNode(Label.label("Symbol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_sym(com.generator.generators.clojure.parser.ClojureParser.Simple_symContext arg) {
		log.info("Simple_sym");
		final Node node = model.newNode(Label.label("Simple_sym"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNs_symbol(com.generator.generators.clojure.parser.ClojureParser.Ns_symbolContext arg) {
		log.info("Ns_symbol");
		final Node node = model.newNode(Label.label("Ns_symbol"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParam_name(com.generator.generators.clojure.parser.ClojureParser.Param_nameContext arg) {
		log.info("Param_name");
		final Node node = model.newNode(Label.label("Param_name"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}