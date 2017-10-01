package com.generator.generators.csv.parser;

public class CSVNodeVisitor extends CSVBaseVisitor<CSVNodeVisitor.Node> {

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

	public CSVNodeVisitor() {
		this(false);
	}

	public CSVNodeVisitor(boolean debug) {
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
	public Node visitCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		final Node node = new Node("CsvFile", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		final Node node = new Node("Hdr", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		final Node node = new Node("Row", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		final Node node = new Node("Field", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}