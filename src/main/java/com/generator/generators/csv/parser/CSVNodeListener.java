package com.generator.generators.csv.parser;

public class CSVNodeListener extends CSVBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final String endToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken, String endToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
			this.endToken = endToken;
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

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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

	protected java.util.Stack<Boolean> inCsvFile = new java.util.Stack<>();

	@Override
	public void enterCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		onEnter(new Node("CsvFile", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCsvFile.push(true);
	}

	public void exitCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		onExit();
		this.inCsvFile.pop();
	}

	public boolean inCsvFile() {
      return !inCsvFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHdr = new java.util.Stack<>();

	@Override
	public void enterHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		onEnter(new Node("Hdr", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inHdr.push(true);
	}

	public void exitHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		onExit();
		this.inHdr.pop();
	}

	public boolean inHdr() {
      return !inHdr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRow = new java.util.Stack<>();

	@Override
	public void enterRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		onEnter(new Node("Row", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRow.push(true);
	}

	public void exitRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		onExit();
		this.inRow.pop();
	}

	public boolean inRow() {
      return !inRow.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inField = new java.util.Stack<>();

	@Override
	public void enterField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		onEnter(new Node("Field", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inField.push(true);
	}

	public void exitField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		onExit();
		this.inField.pop();
	}

	public boolean inField() {
      return !inField.isEmpty(); 
   }

}