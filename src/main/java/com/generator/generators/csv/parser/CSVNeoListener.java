package com.generator.generators.csv.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CSVNeoListener extends CSVBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public CSVNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public CSVNeoListener(com.generator.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
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

	protected boolean inCsvFile = false;

	@Override
	public void enterCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		final Node node = model.findOrCreate(Label.label("CsvFile"), "text", arg.getText());
		onEnter(node);
		this.inCsvFile = true;
	}

	public void exitCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		onExit();
		this.inCsvFile = false;
	}

	protected boolean inHdr = false;

	@Override
	public void enterHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		final Node node = model.findOrCreate(Label.label("Hdr"), "text", arg.getText());
		onEnter(node);
		this.inHdr = true;
	}

	public void exitHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		onExit();
		this.inHdr = false;
	}

	protected boolean inRow = false;

	@Override
	public void enterRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		final Node node = model.findOrCreate(Label.label("Row"), "text", arg.getText());
		onEnter(node);
		this.inRow = true;
	}

	public void exitRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		onExit();
		this.inRow = false;
	}

	protected boolean inField = false;

	@Override
	public void enterField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		final Node node = model.findOrCreate(Label.label("Field"), "text", arg.getText());
		onEnter(node);
		this.inField = true;
	}

	public void exitField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		onExit();
		this.inField = false;
	}

}