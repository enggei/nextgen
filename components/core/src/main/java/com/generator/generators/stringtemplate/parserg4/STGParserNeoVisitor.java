package com.generator.generators.stringtemplate.parserg4;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class STGParserNeoVisitor extends STGParserBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGParserNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public STGParserNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitImports(com.generator.generators.stringtemplate.parserg4.STGParser.ImportsContext arg) {
		log.info("Imports");
		final Node node = model.newNode(Label.label("Imports"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplate(com.generator.generators.stringtemplate.parserg4.STGParser.TemplateContext arg) {
		log.info("Template");
		final Node node = model.newNode(Label.label("Template"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroup(com.generator.generators.stringtemplate.parserg4.STGParser.GroupContext arg) {
		log.info("Group");
		final Node node = model.newNode(Label.label("Group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelimiters(com.generator.generators.stringtemplate.parserg4.STGParser.DelimitersContext arg) {
		log.info("Delimiters");
		final Node node = model.newNode(Label.label("Delimiters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalArgs(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgsContext arg) {
		log.info("FormalArgs");
		final Node node = model.newNode(Label.label("FormalArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalArg(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgContext arg) {
		log.info("FormalArg");
		final Node node = model.newNode(Label.label("FormalArg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDict(com.generator.generators.stringtemplate.parserg4.STGParser.DictContext arg) {
		log.info("Dict");
		final Node node = model.newNode(Label.label("Dict"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDictPairs(com.generator.generators.stringtemplate.parserg4.STGParser.DictPairsContext arg) {
		log.info("DictPairs");
		final Node node = model.newNode(Label.label("DictPairs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValuePairContext arg) {
		log.info("KeyValuePair");
		final Node node = model.newNode(Label.label("KeyValuePair"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.DefaultValuePairContext arg) {
		log.info("DefaultValuePair");
		final Node node = model.newNode(Label.label("DefaultValuePair"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyValue(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValueContext arg) {
		log.info("KeyValue");
		final Node node = model.newNode(Label.label("KeyValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}