package com.generator.generators.csv.parser;

public class CSVNodeListener extends CSVBaseListener {

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

	public CSVNodeListener() {
		this(false);
	}

	public CSVNodeListener(boolean debug) {
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

	protected boolean inCsvFile = false;

	@Override
	public void enterCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		onEnter(new Node("CsvFile", arg.getText(), arg.getStart().getText()));
		this.inCsvFile = true;
	}

	public void exitCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		onExit();
		this.inCsvFile = false;
	}

	protected boolean inHdr = false;

	@Override
	public void enterHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		onEnter(new Node("Hdr", arg.getText(), arg.getStart().getText()));
		this.inHdr = true;
	}

	public void exitHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		onExit();
		this.inHdr = false;
	}

	protected boolean inField = false;

	@Override
	public void enterField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		onEnter(new Node("Field", arg.getText(), arg.getStart().getText()));
		this.inField = true;
	}

	public void exitField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		onExit();
		this.inField = false;
	}

	protected boolean inRow = false;

	@Override
	public void enterRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		onEnter(new Node("Row", arg.getText(), arg.getStart().getText()));
		this.inRow = true;
	}

	public void exitRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		onExit();
		this.inRow = false;
	}

}