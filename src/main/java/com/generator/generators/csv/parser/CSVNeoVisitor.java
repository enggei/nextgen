package com.generator.generators.csv.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CSVNeoVisitor extends CSVBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public CSVNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitHdr(com.generator.generators.csv.parser.CSVParser.HdrContext arg) {
		System.out.println("Hdr");
		final Node node = model.findOrCreate(Label.label("Hdr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRow(com.generator.generators.csv.parser.CSVParser.RowContext arg) {
		System.out.println("Row");
		final Node node = model.findOrCreate(Label.label("Row"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCsvFile(com.generator.generators.csv.parser.CSVParser.CsvFileContext arg) {
		System.out.println("CsvFile");
		final Node node = model.findOrCreate(Label.label("CsvFile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.csv.parser.CSVParser.FieldContext arg) {
		System.out.println("Field");
		final Node node = model.findOrCreate(Label.label("Field"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}