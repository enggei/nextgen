package com.generator.generators.graphQL.parser;

public class GraphQLNodeVisitor extends GraphQLBaseVisitor<GraphQLNodeVisitor.Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GraphQLNodeVisitor.class);

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

	public GraphQLNodeVisitor() {
		this(false);
	}

	public GraphQLNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
				if (debug) log.debug(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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
	public Node visitVariable(com.generator.generators.graphQL.parser.GraphQLParser.VariableContext arg) {
		final Node node = new Node("Variable", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitField(com.generator.generators.graphQL.parser.GraphQLParser.FieldContext arg) {
		final Node node = new Node("Field", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArguments(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentsContext arg) {
		final Node node = new Node("Arguments", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDocument(com.generator.generators.graphQL.parser.GraphQLParser.DocumentContext arg) {
		final Node node = new Node("Document", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.graphQL.parser.GraphQLParser.TypeContext arg) {
		final Node node = new Node("Type", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeName(com.generator.generators.graphQL.parser.GraphQLParser.TypeNameContext arg) {
		final Node node = new Node("TypeName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefinition(com.generator.generators.graphQL.parser.GraphQLParser.DefinitionContext arg) {
		final Node node = new Node("Definition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperationDefinition(com.generator.generators.graphQL.parser.GraphQLParser.OperationDefinitionContext arg) {
		final Node node = new Node("OperationDefinition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectionSet(com.generator.generators.graphQL.parser.GraphQLParser.SelectionSetContext arg) {
		final Node node = new Node("SelectionSet", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOperationType(com.generator.generators.graphQL.parser.GraphQLParser.OperationTypeContext arg) {
		final Node node = new Node("OperationType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelection(com.generator.generators.graphQL.parser.GraphQLParser.SelectionContext arg) {
		final Node node = new Node("Selection", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFieldName(com.generator.generators.graphQL.parser.GraphQLParser.FieldNameContext arg) {
		final Node node = new Node("FieldName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlias(com.generator.generators.graphQL.parser.GraphQLParser.AliasContext arg) {
		final Node node = new Node("Alias", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgument(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentContext arg) {
		final Node node = new Node("Argument", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFragmentSpread(com.generator.generators.graphQL.parser.GraphQLParser.FragmentSpreadContext arg) {
		final Node node = new Node("FragmentSpread", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInlineFragment(com.generator.generators.graphQL.parser.GraphQLParser.InlineFragmentContext arg) {
		final Node node = new Node("InlineFragment", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFragmentDefinition(com.generator.generators.graphQL.parser.GraphQLParser.FragmentDefinitionContext arg) {
		final Node node = new Node("FragmentDefinition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFragmentName(com.generator.generators.graphQL.parser.GraphQLParser.FragmentNameContext arg) {
		final Node node = new Node("FragmentName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDirectives(com.generator.generators.graphQL.parser.GraphQLParser.DirectivesContext arg) {
		final Node node = new Node("Directives", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDirective(com.generator.generators.graphQL.parser.GraphQLParser.DirectiveContext arg) {
		final Node node = new Node("Directive", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeCondition(com.generator.generators.graphQL.parser.GraphQLParser.TypeConditionContext arg) {
		final Node node = new Node("TypeCondition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDefinitions(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionsContext arg) {
		final Node node = new Node("VariableDefinitions", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariableDefinition(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionContext arg) {
		final Node node = new Node("VariableDefinition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValue(com.generator.generators.graphQL.parser.GraphQLParser.DefaultValueContext arg) {
		final Node node = new Node("DefaultValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValueOrVariable(com.generator.generators.graphQL.parser.GraphQLParser.ValueOrVariableContext arg) {
		final Node node = new Node("ValueOrVariable", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStringValue(com.generator.generators.graphQL.parser.GraphQLParser.StringValueContext arg) {
		final Node node = new Node("StringValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumberValue(com.generator.generators.graphQL.parser.GraphQLParser.NumberValueContext arg) {
		final Node node = new Node("NumberValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBooleanValue(com.generator.generators.graphQL.parser.GraphQLParser.BooleanValueContext arg) {
		final Node node = new Node("BooleanValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArrayValue(com.generator.generators.graphQL.parser.GraphQLParser.ArrayValueContext arg) {
		final Node node = new Node("ArrayValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitListType(com.generator.generators.graphQL.parser.GraphQLParser.ListTypeContext arg) {
		final Node node = new Node("ListType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNonNullType(com.generator.generators.graphQL.parser.GraphQLParser.NonNullTypeContext arg) {
		final Node node = new Node("NonNullType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArray(com.generator.generators.graphQL.parser.GraphQLParser.ArrayContext arg) {
		final Node node = new Node("Array", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}