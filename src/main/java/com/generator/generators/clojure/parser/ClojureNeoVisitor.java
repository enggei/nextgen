package com.generator.generators.clojure.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ClojureNeoVisitor extends ClojureBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public ClojureNeoVisitor(com.generator.neo.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.neo.BaseDomainVisitor.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitReader_macro(com.generator.generators.clojure.parser.ClojureParser.Reader_macroContext arg) {
		System.out.println("Reader_macro");
		final Node node = model.findOrCreate(Label.label("Reader_macro"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet(com.generator.generators.clojure.parser.ClojureParser.SetContext arg) {
		System.out.println("Set");
		final Node node = model.findOrCreate(Label.label("Set"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQuote(com.generator.generators.clojure.parser.ClojureParser.QuoteContext arg) {
		System.out.println("Quote");
		final Node node = model.findOrCreate(Label.label("Quote"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBacktick(com.generator.generators.clojure.parser.ClojureParser.BacktickContext arg) {
		System.out.println("Backtick");
		final Node node = model.findOrCreate(Label.label("Backtick"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnquote(com.generator.generators.clojure.parser.ClojureParser.UnquoteContext arg) {
		System.out.println("Unquote");
		final Node node = model.findOrCreate(Label.label("Unquote"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnquote_splicing(com.generator.generators.clojure.parser.ClojureParser.Unquote_splicingContext arg) {
		System.out.println("Unquote_splicing");
		final Node node = model.findOrCreate(Label.label("Unquote_splicing"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTag(com.generator.generators.clojure.parser.ClojureParser.TagContext arg) {
		System.out.println("Tag");
		final Node node = model.findOrCreate(Label.label("Tag"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.clojure.parser.ClojureParser.StringContext arg) {
		System.out.println("String");
		final Node node = model.findOrCreate(Label.label("String"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHex(com.generator.generators.clojure.parser.ClojureParser.HexContext arg) {
		System.out.println("Hex");
		final Node node = model.findOrCreate(Label.label("Hex"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBin(com.generator.generators.clojure.parser.ClojureParser.BinContext arg) {
		System.out.println("Bin");
		final Node node = model.findOrCreate(Label.label("Bin"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBign(com.generator.generators.clojure.parser.ClojureParser.BignContext arg) {
		System.out.println("Bign");
		final Node node = model.findOrCreate(Label.label("Bign"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.clojure.parser.ClojureParser.NumberContext arg) {
		System.out.println("Number");
		final Node node = model.findOrCreate(Label.label("Number"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharacter(com.generator.generators.clojure.parser.ClojureParser.CharacterContext arg) {
		System.out.println("Character");
		final Node node = model.findOrCreate(Label.label("Character"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamed_char(com.generator.generators.clojure.parser.ClojureParser.Named_charContext arg) {
		System.out.println("Named_char");
		final Node node = model.findOrCreate(Label.label("Named_char"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAny_char(com.generator.generators.clojure.parser.ClojureParser.Any_charContext arg) {
		System.out.println("Any_char");
		final Node node = model.findOrCreate(Label.label("Any_char"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitU_hex_quad(com.generator.generators.clojure.parser.ClojureParser.U_hex_quadContext arg) {
		System.out.println("U_hex_quad");
		final Node node = model.findOrCreate(Label.label("U_hex_quad"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNil(com.generator.generators.clojure.parser.ClojureParser.NilContext arg) {
		System.out.println("Nil");
		final Node node = model.findOrCreate(Label.label("Nil"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyword(com.generator.generators.clojure.parser.ClojureParser.KeywordContext arg) {
		System.out.println("Keyword");
		final Node node = model.findOrCreate(Label.label("Keyword"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_keyword(com.generator.generators.clojure.parser.ClojureParser.Simple_keywordContext arg) {
		System.out.println("Simple_keyword");
		final Node node = model.findOrCreate(Label.label("Simple_keyword"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMacro_keyword(com.generator.generators.clojure.parser.ClojureParser.Macro_keywordContext arg) {
		System.out.println("Macro_keyword");
		final Node node = model.findOrCreate(Label.label("Macro_keyword"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSymbol(com.generator.generators.clojure.parser.ClojureParser.SymbolContext arg) {
		System.out.println("Symbol");
		final Node node = model.findOrCreate(Label.label("Symbol"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_sym(com.generator.generators.clojure.parser.ClojureParser.Simple_symContext arg) {
		System.out.println("Simple_sym");
		final Node node = model.findOrCreate(Label.label("Simple_sym"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNs_symbol(com.generator.generators.clojure.parser.ClojureParser.Ns_symbolContext arg) {
		System.out.println("Ns_symbol");
		final Node node = model.findOrCreate(Label.label("Ns_symbol"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParam_name(com.generator.generators.clojure.parser.ClojureParser.Param_nameContext arg) {
		System.out.println("Param_name");
		final Node node = model.findOrCreate(Label.label("Param_name"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile(com.generator.generators.clojure.parser.ClojureParser.FileContext arg) {
		System.out.println("File");
		final Node node = model.findOrCreate(Label.label("File"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForm(com.generator.generators.clojure.parser.ClojureParser.FormContext arg) {
		System.out.println("Form");
		final Node node = model.findOrCreate(Label.label("Form"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForms(com.generator.generators.clojure.parser.ClojureParser.FormsContext arg) {
		System.out.println("Forms");
		final Node node = model.findOrCreate(Label.label("Forms"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitList(com.generator.generators.clojure.parser.ClojureParser.ListContext arg) {
		System.out.println("List");
		final Node node = model.findOrCreate(Label.label("List"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVector(com.generator.generators.clojure.parser.ClojureParser.VectorContext arg) {
		System.out.println("Vector");
		final Node node = model.findOrCreate(Label.label("Vector"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMap(com.generator.generators.clojure.parser.ClojureParser.MapContext arg) {
		System.out.println("Map");
		final Node node = model.findOrCreate(Label.label("Map"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeref(com.generator.generators.clojure.parser.ClojureParser.DerefContext arg) {
		System.out.println("Deref");
		final Node node = model.findOrCreate(Label.label("Deref"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGensym(com.generator.generators.clojure.parser.ClojureParser.GensymContext arg) {
		System.out.println("Gensym");
		final Node node = model.findOrCreate(Label.label("Gensym"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambda(com.generator.generators.clojure.parser.ClojureParser.LambdaContext arg) {
		System.out.println("Lambda");
		final Node node = model.findOrCreate(Label.label("Lambda"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMeta_data(com.generator.generators.clojure.parser.ClojureParser.Meta_dataContext arg) {
		System.out.println("Meta_data");
		final Node node = model.findOrCreate(Label.label("Meta_data"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar_quote(com.generator.generators.clojure.parser.ClojureParser.Var_quoteContext arg) {
		System.out.println("Var_quote");
		final Node node = model.findOrCreate(Label.label("Var_quote"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHost_expr(com.generator.generators.clojure.parser.ClojureParser.Host_exprContext arg) {
		System.out.println("Host_expr");
		final Node node = model.findOrCreate(Label.label("Host_expr"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDiscard(com.generator.generators.clojure.parser.ClojureParser.DiscardContext arg) {
		System.out.println("Discard");
		final Node node = model.findOrCreate(Label.label("Discard"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDispatch(com.generator.generators.clojure.parser.ClojureParser.DispatchContext arg) {
		System.out.println("Dispatch");
		final Node node = model.findOrCreate(Label.label("Dispatch"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegex(com.generator.generators.clojure.parser.ClojureParser.RegexContext arg) {
		System.out.println("Regex");
		final Node node = model.findOrCreate(Label.label("Regex"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.clojure.parser.ClojureParser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}