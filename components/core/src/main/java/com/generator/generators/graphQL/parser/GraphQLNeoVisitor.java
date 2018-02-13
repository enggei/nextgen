package com.generator.generators.graphQL.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class GraphQLNeoVisitor extends GraphQLBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GraphQLNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public GraphQLNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitVariable(com.generator.generators.graphQL.parser.GraphQLParser.VariableContext arg) {
		log.info("Variable");
		final Node node = model.newNode(Label.label("Variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.graphQL.parser.GraphQLParser.FieldContext arg) {
		log.info("Field");
		final Node node = model.newNode(Label.label("Field"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentsContext arg) {
		log.info("Arguments");
		final Node node = model.newNode(Label.label("Arguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDocument(com.generator.generators.graphQL.parser.GraphQLParser.DocumentContext arg) {
		log.info("Document");
		final Node node = model.newNode(Label.label("Document"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.graphQL.parser.GraphQLParser.TypeContext arg) {
		log.info("Type");
		final Node node = model.newNode(Label.label("Type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeName(com.generator.generators.graphQL.parser.GraphQLParser.TypeNameContext arg) {
		log.info("TypeName");
		final Node node = model.newNode(Label.label("TypeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefinition(com.generator.generators.graphQL.parser.GraphQLParser.DefinitionContext arg) {
		log.info("Definition");
		final Node node = model.newNode(Label.label("Definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperationDefinition(com.generator.generators.graphQL.parser.GraphQLParser.OperationDefinitionContext arg) {
		log.info("OperationDefinition");
		final Node node = model.newNode(Label.label("OperationDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectionSet(com.generator.generators.graphQL.parser.GraphQLParser.SelectionSetContext arg) {
		log.info("SelectionSet");
		final Node node = model.newNode(Label.label("SelectionSet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperationType(com.generator.generators.graphQL.parser.GraphQLParser.OperationTypeContext arg) {
		log.info("OperationType");
		final Node node = model.newNode(Label.label("OperationType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelection(com.generator.generators.graphQL.parser.GraphQLParser.SelectionContext arg) {
		log.info("Selection");
		final Node node = model.newNode(Label.label("Selection"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldName(com.generator.generators.graphQL.parser.GraphQLParser.FieldNameContext arg) {
		log.info("FieldName");
		final Node node = model.newNode(Label.label("FieldName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlias(com.generator.generators.graphQL.parser.GraphQLParser.AliasContext arg) {
		log.info("Alias");
		final Node node = model.newNode(Label.label("Alias"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgument(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentContext arg) {
		log.info("Argument");
		final Node node = model.newNode(Label.label("Argument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFragmentSpread(com.generator.generators.graphQL.parser.GraphQLParser.FragmentSpreadContext arg) {
		log.info("FragmentSpread");
		final Node node = model.newNode(Label.label("FragmentSpread"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInlineFragment(com.generator.generators.graphQL.parser.GraphQLParser.InlineFragmentContext arg) {
		log.info("InlineFragment");
		final Node node = model.newNode(Label.label("InlineFragment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFragmentDefinition(com.generator.generators.graphQL.parser.GraphQLParser.FragmentDefinitionContext arg) {
		log.info("FragmentDefinition");
		final Node node = model.newNode(Label.label("FragmentDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFragmentName(com.generator.generators.graphQL.parser.GraphQLParser.FragmentNameContext arg) {
		log.info("FragmentName");
		final Node node = model.newNode(Label.label("FragmentName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDirectives(com.generator.generators.graphQL.parser.GraphQLParser.DirectivesContext arg) {
		log.info("Directives");
		final Node node = model.newNode(Label.label("Directives"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDirective(com.generator.generators.graphQL.parser.GraphQLParser.DirectiveContext arg) {
		log.info("Directive");
		final Node node = model.newNode(Label.label("Directive"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeCondition(com.generator.generators.graphQL.parser.GraphQLParser.TypeConditionContext arg) {
		log.info("TypeCondition");
		final Node node = model.newNode(Label.label("TypeCondition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDefinitions(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionsContext arg) {
		log.info("VariableDefinitions");
		final Node node = model.newNode(Label.label("VariableDefinitions"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDefinition(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionContext arg) {
		log.info("VariableDefinition");
		final Node node = model.newNode(Label.label("VariableDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValue(com.generator.generators.graphQL.parser.GraphQLParser.DefaultValueContext arg) {
		log.info("DefaultValue");
		final Node node = model.newNode(Label.label("DefaultValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValueOrVariable(com.generator.generators.graphQL.parser.GraphQLParser.ValueOrVariableContext arg) {
		log.info("ValueOrVariable");
		final Node node = model.newNode(Label.label("ValueOrVariable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStringValue(com.generator.generators.graphQL.parser.GraphQLParser.StringValueContext arg) {
		log.info("StringValue");
		final Node node = model.newNode(Label.label("StringValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumberValue(com.generator.generators.graphQL.parser.GraphQLParser.NumberValueContext arg) {
		log.info("NumberValue");
		final Node node = model.newNode(Label.label("NumberValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanValue(com.generator.generators.graphQL.parser.GraphQLParser.BooleanValueContext arg) {
		log.info("BooleanValue");
		final Node node = model.newNode(Label.label("BooleanValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayValue(com.generator.generators.graphQL.parser.GraphQLParser.ArrayValueContext arg) {
		log.info("ArrayValue");
		final Node node = model.newNode(Label.label("ArrayValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListType(com.generator.generators.graphQL.parser.GraphQLParser.ListTypeContext arg) {
		log.info("ListType");
		final Node node = model.newNode(Label.label("ListType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonNullType(com.generator.generators.graphQL.parser.GraphQLParser.NonNullTypeContext arg) {
		log.info("NonNullType");
		final Node node = model.newNode(Label.label("NonNullType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArray(com.generator.generators.graphQL.parser.GraphQLParser.ArrayContext arg) {
		log.info("Array");
		final Node node = model.newNode(Label.label("Array"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}