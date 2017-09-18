package com.generator.generators.clojure.parser;

public class ClojureNodeVisitor extends ClojureBaseVisitor<ClojureNodeVisitor.Node> {

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

	public ClojureNodeVisitor() {
		this(false);
	}

	public ClojureNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
		delim.append("\t");
   }

   private void onExit() {
      if (nodeStack.size() > 1) {
         nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
      }
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitQuote(com.generator.generators.clojure.parser.ClojureParser.QuoteContext arg) {
		final Node node = new Node("Quote", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBacktick(com.generator.generators.clojure.parser.ClojureParser.BacktickContext arg) {
		final Node node = new Node("Backtick", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnquote(com.generator.generators.clojure.parser.ClojureParser.UnquoteContext arg) {
		final Node node = new Node("Unquote", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnquote_splicing(com.generator.generators.clojure.parser.ClojureParser.Unquote_splicingContext arg) {
		final Node node = new Node("Unquote_splicing", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTag(com.generator.generators.clojure.parser.ClojureParser.TagContext arg) {
		final Node node = new Node("Tag", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeref(com.generator.generators.clojure.parser.ClojureParser.DerefContext arg) {
		final Node node = new Node("Deref", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGensym(com.generator.generators.clojure.parser.ClojureParser.GensymContext arg) {
		final Node node = new Node("Gensym", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLambda(com.generator.generators.clojure.parser.ClojureParser.LambdaContext arg) {
		final Node node = new Node("Lambda", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMeta_data(com.generator.generators.clojure.parser.ClojureParser.Meta_dataContext arg) {
		final Node node = new Node("Meta_data", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile(com.generator.generators.clojure.parser.ClojureParser.FileContext arg) {
		final Node node = new Node("File", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForm(com.generator.generators.clojure.parser.ClojureParser.FormContext arg) {
		final Node node = new Node("Form", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitForms(com.generator.generators.clojure.parser.ClojureParser.FormsContext arg) {
		final Node node = new Node("Forms", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitList(com.generator.generators.clojure.parser.ClojureParser.ListContext arg) {
		final Node node = new Node("List", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVector(com.generator.generators.clojure.parser.ClojureParser.VectorContext arg) {
		final Node node = new Node("Vector", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMap(com.generator.generators.clojure.parser.ClojureParser.MapContext arg) {
		final Node node = new Node("Map", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSet(com.generator.generators.clojure.parser.ClojureParser.SetContext arg) {
		final Node node = new Node("Set", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar_quote(com.generator.generators.clojure.parser.ClojureParser.Var_quoteContext arg) {
		final Node node = new Node("Var_quote", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHost_expr(com.generator.generators.clojure.parser.ClojureParser.Host_exprContext arg) {
		final Node node = new Node("Host_expr", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDiscard(com.generator.generators.clojure.parser.ClojureParser.DiscardContext arg) {
		final Node node = new Node("Discard", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDispatch(com.generator.generators.clojure.parser.ClojureParser.DispatchContext arg) {
		final Node node = new Node("Dispatch", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegex(com.generator.generators.clojure.parser.ClojureParser.RegexContext arg) {
		final Node node = new Node("Regex", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.clojure.parser.ClojureParser.LiteralContext arg) {
		final Node node = new Node("Literal", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitString(com.generator.generators.clojure.parser.ClojureParser.StringContext arg) {
		final Node node = new Node("String", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHex(com.generator.generators.clojure.parser.ClojureParser.HexContext arg) {
		final Node node = new Node("Hex", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBin(com.generator.generators.clojure.parser.ClojureParser.BinContext arg) {
		final Node node = new Node("Bin", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBign(com.generator.generators.clojure.parser.ClojureParser.BignContext arg) {
		final Node node = new Node("Bign", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.clojure.parser.ClojureParser.NumberContext arg) {
		final Node node = new Node("Number", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharacter(com.generator.generators.clojure.parser.ClojureParser.CharacterContext arg) {
		final Node node = new Node("Character", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamed_char(com.generator.generators.clojure.parser.ClojureParser.Named_charContext arg) {
		final Node node = new Node("Named_char", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAny_char(com.generator.generators.clojure.parser.ClojureParser.Any_charContext arg) {
		final Node node = new Node("Any_char", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitU_hex_quad(com.generator.generators.clojure.parser.ClojureParser.U_hex_quadContext arg) {
		final Node node = new Node("U_hex_quad", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNil(com.generator.generators.clojure.parser.ClojureParser.NilContext arg) {
		final Node node = new Node("Nil", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyword(com.generator.generators.clojure.parser.ClojureParser.KeywordContext arg) {
		final Node node = new Node("Keyword", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_keyword(com.generator.generators.clojure.parser.ClojureParser.Simple_keywordContext arg) {
		final Node node = new Node("Simple_keyword", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMacro_keyword(com.generator.generators.clojure.parser.ClojureParser.Macro_keywordContext arg) {
		final Node node = new Node("Macro_keyword", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSymbol(com.generator.generators.clojure.parser.ClojureParser.SymbolContext arg) {
		final Node node = new Node("Symbol", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimple_sym(com.generator.generators.clojure.parser.ClojureParser.Simple_symContext arg) {
		final Node node = new Node("Simple_sym", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNs_symbol(com.generator.generators.clojure.parser.ClojureParser.Ns_symbolContext arg) {
		final Node node = new Node("Ns_symbol", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParam_name(com.generator.generators.clojure.parser.ClojureParser.Param_nameContext arg) {
		final Node node = new Node("Param_name", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReader_macro(com.generator.generators.clojure.parser.ClojureParser.Reader_macroContext arg) {
		final Node node = new Node("Reader_macro", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}