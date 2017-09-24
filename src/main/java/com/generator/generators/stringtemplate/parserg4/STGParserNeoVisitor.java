package com.generator.generators.stringtemplate.parserg4;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class STGParserNeoVisitor extends STGParserBaseVisitor<Node> {

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
	public Node visitGroup(com.generator.generators.stringtemplate.parserg4.STGParser.GroupContext arg) {
		System.out.println("Group");
		final Node node = model.findOrCreate(Label.label("Group"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelimiters(com.generator.generators.stringtemplate.parserg4.STGParser.DelimitersContext arg) {
		System.out.println("Delimiters");
		final Node node = model.findOrCreate(Label.label("Delimiters"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalArgs(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgsContext arg) {
		System.out.println("FormalArgs");
		final Node node = model.findOrCreate(Label.label("FormalArgs"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalArg(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgContext arg) {
		System.out.println("FormalArg");
		final Node node = model.findOrCreate(Label.label("FormalArg"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDict(com.generator.generators.stringtemplate.parserg4.STGParser.DictContext arg) {
		System.out.println("Dict");
		final Node node = model.findOrCreate(Label.label("Dict"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDictPairs(com.generator.generators.stringtemplate.parserg4.STGParser.DictPairsContext arg) {
		System.out.println("DictPairs");
		final Node node = model.findOrCreate(Label.label("DictPairs"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValuePairContext arg) {
		System.out.println("KeyValuePair");
		final Node node = model.findOrCreate(Label.label("KeyValuePair"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.DefaultValuePairContext arg) {
		System.out.println("DefaultValuePair");
		final Node node = model.findOrCreate(Label.label("DefaultValuePair"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyValue(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValueContext arg) {
		System.out.println("KeyValue");
		final Node node = model.findOrCreate(Label.label("KeyValue"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplate(com.generator.generators.stringtemplate.parserg4.STGParser.TemplateContext arg) {
		System.out.println("Template");
		final Node node = model.findOrCreate(Label.label("Template"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImports(com.generator.generators.stringtemplate.parserg4.STGParser.ImportsContext arg) {
		System.out.println("Imports");
		final Node node = model.findOrCreate(Label.label("Imports"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}