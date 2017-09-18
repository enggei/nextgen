package com.generator.generators.csv.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CSVNeoListener extends CSVBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public CSVNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public CSVNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inCsvFile = new java.util.Stack<>();

	@Override
	public void enterCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		final Node node = model.findOrCreate(Label.label("CsvFile"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Hdr"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Row"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Field"), "text", arg.getText());
		onEnter(node);
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