package com.generator.generators.graphQL.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class GraphQLNeoListener extends GraphQLBaseListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GraphQLNeoListener.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public GraphQLNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public GraphQLNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) log.debug(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inField = new java.util.Stack<>();

	@Override
	public void enterField(com.generator.generators.graphQL.parser.GraphQLParser.FieldContext arg) {
		final Node node = model.newNode(Label.label("Field"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inField.push(true);
	}

	public void exitField(com.generator.generators.graphQL.parser.GraphQLParser.FieldContext arg) {
		onExit();
		this.inField.pop();
	}

	public boolean inField() {
      return !inField.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariable = new java.util.Stack<>();

	@Override
	public void enterVariable(com.generator.generators.graphQL.parser.GraphQLParser.VariableContext arg) {
		final Node node = model.newNode(Label.label("Variable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariable.push(true);
	}

	public void exitVariable(com.generator.generators.graphQL.parser.GraphQLParser.VariableContext arg) {
		onExit();
		this.inVariable.pop();
	}

	public boolean inVariable() {
      return !inVariable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArguments = new java.util.Stack<>();

	@Override
	public void enterArguments(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentsContext arg) {
		final Node node = model.newNode(Label.label("Arguments"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArguments.push(true);
	}

	public void exitArguments(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentsContext arg) {
		onExit();
		this.inArguments.pop();
	}

	public boolean inArguments() {
      return !inArguments.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inType = new java.util.Stack<>();

	@Override
	public void enterType(com.generator.generators.graphQL.parser.GraphQLParser.TypeContext arg) {
		final Node node = model.newNode(Label.label("Type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inType.push(true);
	}

	public void exitType(com.generator.generators.graphQL.parser.GraphQLParser.TypeContext arg) {
		onExit();
		this.inType.pop();
	}

	public boolean inType() {
      return !inType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeName = new java.util.Stack<>();

	@Override
	public void enterTypeName(com.generator.generators.graphQL.parser.GraphQLParser.TypeNameContext arg) {
		final Node node = model.newNode(Label.label("TypeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeName.push(true);
	}

	public void exitTypeName(com.generator.generators.graphQL.parser.GraphQLParser.TypeNameContext arg) {
		onExit();
		this.inTypeName.pop();
	}

	public boolean inTypeName() {
      return !inTypeName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDocument = new java.util.Stack<>();

	@Override
	public void enterDocument(com.generator.generators.graphQL.parser.GraphQLParser.DocumentContext arg) {
		final Node node = model.newNode(Label.label("Document"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDocument.push(true);
	}

	public void exitDocument(com.generator.generators.graphQL.parser.GraphQLParser.DocumentContext arg) {
		onExit();
		this.inDocument.pop();
	}

	public boolean inDocument() {
      return !inDocument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefinition = new java.util.Stack<>();

	@Override
	public void enterDefinition(com.generator.generators.graphQL.parser.GraphQLParser.DefinitionContext arg) {
		final Node node = model.newNode(Label.label("Definition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDefinition.push(true);
	}

	public void exitDefinition(com.generator.generators.graphQL.parser.GraphQLParser.DefinitionContext arg) {
		onExit();
		this.inDefinition.pop();
	}

	public boolean inDefinition() {
      return !inDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperationDefinition = new java.util.Stack<>();

	@Override
	public void enterOperationDefinition(com.generator.generators.graphQL.parser.GraphQLParser.OperationDefinitionContext arg) {
		final Node node = model.newNode(Label.label("OperationDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOperationDefinition.push(true);
	}

	public void exitOperationDefinition(com.generator.generators.graphQL.parser.GraphQLParser.OperationDefinitionContext arg) {
		onExit();
		this.inOperationDefinition.pop();
	}

	public boolean inOperationDefinition() {
      return !inOperationDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectionSet = new java.util.Stack<>();

	@Override
	public void enterSelectionSet(com.generator.generators.graphQL.parser.GraphQLParser.SelectionSetContext arg) {
		final Node node = model.newNode(Label.label("SelectionSet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelectionSet.push(true);
	}

	public void exitSelectionSet(com.generator.generators.graphQL.parser.GraphQLParser.SelectionSetContext arg) {
		onExit();
		this.inSelectionSet.pop();
	}

	public boolean inSelectionSet() {
      return !inSelectionSet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOperationType = new java.util.Stack<>();

	@Override
	public void enterOperationType(com.generator.generators.graphQL.parser.GraphQLParser.OperationTypeContext arg) {
		final Node node = model.newNode(Label.label("OperationType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inOperationType.push(true);
	}

	public void exitOperationType(com.generator.generators.graphQL.parser.GraphQLParser.OperationTypeContext arg) {
		onExit();
		this.inOperationType.pop();
	}

	public boolean inOperationType() {
      return !inOperationType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelection = new java.util.Stack<>();

	@Override
	public void enterSelection(com.generator.generators.graphQL.parser.GraphQLParser.SelectionContext arg) {
		final Node node = model.newNode(Label.label("Selection"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inSelection.push(true);
	}

	public void exitSelection(com.generator.generators.graphQL.parser.GraphQLParser.SelectionContext arg) {
		onExit();
		this.inSelection.pop();
	}

	public boolean inSelection() {
      return !inSelection.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFieldName = new java.util.Stack<>();

	@Override
	public void enterFieldName(com.generator.generators.graphQL.parser.GraphQLParser.FieldNameContext arg) {
		final Node node = model.newNode(Label.label("FieldName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFieldName.push(true);
	}

	public void exitFieldName(com.generator.generators.graphQL.parser.GraphQLParser.FieldNameContext arg) {
		onExit();
		this.inFieldName.pop();
	}

	public boolean inFieldName() {
      return !inFieldName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlias = new java.util.Stack<>();

	@Override
	public void enterAlias(com.generator.generators.graphQL.parser.GraphQLParser.AliasContext arg) {
		final Node node = model.newNode(Label.label("Alias"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inAlias.push(true);
	}

	public void exitAlias(com.generator.generators.graphQL.parser.GraphQLParser.AliasContext arg) {
		onExit();
		this.inAlias.pop();
	}

	public boolean inAlias() {
      return !inAlias.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgument = new java.util.Stack<>();

	@Override
	public void enterArgument(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentContext arg) {
		final Node node = model.newNode(Label.label("Argument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArgument.push(true);
	}

	public void exitArgument(com.generator.generators.graphQL.parser.GraphQLParser.ArgumentContext arg) {
		onExit();
		this.inArgument.pop();
	}

	public boolean inArgument() {
      return !inArgument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFragmentSpread = new java.util.Stack<>();

	@Override
	public void enterFragmentSpread(com.generator.generators.graphQL.parser.GraphQLParser.FragmentSpreadContext arg) {
		final Node node = model.newNode(Label.label("FragmentSpread"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFragmentSpread.push(true);
	}

	public void exitFragmentSpread(com.generator.generators.graphQL.parser.GraphQLParser.FragmentSpreadContext arg) {
		onExit();
		this.inFragmentSpread.pop();
	}

	public boolean inFragmentSpread() {
      return !inFragmentSpread.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inInlineFragment = new java.util.Stack<>();

	@Override
	public void enterInlineFragment(com.generator.generators.graphQL.parser.GraphQLParser.InlineFragmentContext arg) {
		final Node node = model.newNode(Label.label("InlineFragment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inInlineFragment.push(true);
	}

	public void exitInlineFragment(com.generator.generators.graphQL.parser.GraphQLParser.InlineFragmentContext arg) {
		onExit();
		this.inInlineFragment.pop();
	}

	public boolean inInlineFragment() {
      return !inInlineFragment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFragmentDefinition = new java.util.Stack<>();

	@Override
	public void enterFragmentDefinition(com.generator.generators.graphQL.parser.GraphQLParser.FragmentDefinitionContext arg) {
		final Node node = model.newNode(Label.label("FragmentDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFragmentDefinition.push(true);
	}

	public void exitFragmentDefinition(com.generator.generators.graphQL.parser.GraphQLParser.FragmentDefinitionContext arg) {
		onExit();
		this.inFragmentDefinition.pop();
	}

	public boolean inFragmentDefinition() {
      return !inFragmentDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFragmentName = new java.util.Stack<>();

	@Override
	public void enterFragmentName(com.generator.generators.graphQL.parser.GraphQLParser.FragmentNameContext arg) {
		final Node node = model.newNode(Label.label("FragmentName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inFragmentName.push(true);
	}

	public void exitFragmentName(com.generator.generators.graphQL.parser.GraphQLParser.FragmentNameContext arg) {
		onExit();
		this.inFragmentName.pop();
	}

	public boolean inFragmentName() {
      return !inFragmentName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDirectives = new java.util.Stack<>();

	@Override
	public void enterDirectives(com.generator.generators.graphQL.parser.GraphQLParser.DirectivesContext arg) {
		final Node node = model.newNode(Label.label("Directives"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDirectives.push(true);
	}

	public void exitDirectives(com.generator.generators.graphQL.parser.GraphQLParser.DirectivesContext arg) {
		onExit();
		this.inDirectives.pop();
	}

	public boolean inDirectives() {
      return !inDirectives.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeCondition = new java.util.Stack<>();

	@Override
	public void enterTypeCondition(com.generator.generators.graphQL.parser.GraphQLParser.TypeConditionContext arg) {
		final Node node = model.newNode(Label.label("TypeCondition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inTypeCondition.push(true);
	}

	public void exitTypeCondition(com.generator.generators.graphQL.parser.GraphQLParser.TypeConditionContext arg) {
		onExit();
		this.inTypeCondition.pop();
	}

	public boolean inTypeCondition() {
      return !inTypeCondition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDirective = new java.util.Stack<>();

	@Override
	public void enterDirective(com.generator.generators.graphQL.parser.GraphQLParser.DirectiveContext arg) {
		final Node node = model.newNode(Label.label("Directive"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDirective.push(true);
	}

	public void exitDirective(com.generator.generators.graphQL.parser.GraphQLParser.DirectiveContext arg) {
		onExit();
		this.inDirective.pop();
	}

	public boolean inDirective() {
      return !inDirective.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableDefinitions = new java.util.Stack<>();

	@Override
	public void enterVariableDefinitions(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionsContext arg) {
		final Node node = model.newNode(Label.label("VariableDefinitions"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableDefinitions.push(true);
	}

	public void exitVariableDefinitions(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionsContext arg) {
		onExit();
		this.inVariableDefinitions.pop();
	}

	public boolean inVariableDefinitions() {
      return !inVariableDefinitions.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVariableDefinition = new java.util.Stack<>();

	@Override
	public void enterVariableDefinition(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionContext arg) {
		final Node node = model.newNode(Label.label("VariableDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inVariableDefinition.push(true);
	}

	public void exitVariableDefinition(com.generator.generators.graphQL.parser.GraphQLParser.VariableDefinitionContext arg) {
		onExit();
		this.inVariableDefinition.pop();
	}

	public boolean inVariableDefinition() {
      return !inVariableDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultValue = new java.util.Stack<>();

	@Override
	public void enterDefaultValue(com.generator.generators.graphQL.parser.GraphQLParser.DefaultValueContext arg) {
		final Node node = model.newNode(Label.label("DefaultValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDefaultValue.push(true);
	}

	public void exitDefaultValue(com.generator.generators.graphQL.parser.GraphQLParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue.pop();
	}

	public boolean inDefaultValue() {
      return !inDefaultValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inValueOrVariable = new java.util.Stack<>();

	@Override
	public void enterValueOrVariable(com.generator.generators.graphQL.parser.GraphQLParser.ValueOrVariableContext arg) {
		final Node node = model.newNode(Label.label("ValueOrVariable"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inValueOrVariable.push(true);
	}

	public void exitValueOrVariable(com.generator.generators.graphQL.parser.GraphQLParser.ValueOrVariableContext arg) {
		onExit();
		this.inValueOrVariable.pop();
	}

	public boolean inValueOrVariable() {
      return !inValueOrVariable.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStringValue = new java.util.Stack<>();

	@Override
	public void enterStringValue(com.generator.generators.graphQL.parser.GraphQLParser.StringValueContext arg) {
		final Node node = model.newNode(Label.label("StringValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStringValue.push(true);
	}

	public void exitStringValue(com.generator.generators.graphQL.parser.GraphQLParser.StringValueContext arg) {
		onExit();
		this.inStringValue.pop();
	}

	public boolean inStringValue() {
      return !inStringValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumberValue = new java.util.Stack<>();

	@Override
	public void enterNumberValue(com.generator.generators.graphQL.parser.GraphQLParser.NumberValueContext arg) {
		final Node node = model.newNode(Label.label("NumberValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNumberValue.push(true);
	}

	public void exitNumberValue(com.generator.generators.graphQL.parser.GraphQLParser.NumberValueContext arg) {
		onExit();
		this.inNumberValue.pop();
	}

	public boolean inNumberValue() {
      return !inNumberValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBooleanValue = new java.util.Stack<>();

	@Override
	public void enterBooleanValue(com.generator.generators.graphQL.parser.GraphQLParser.BooleanValueContext arg) {
		final Node node = model.newNode(Label.label("BooleanValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inBooleanValue.push(true);
	}

	public void exitBooleanValue(com.generator.generators.graphQL.parser.GraphQLParser.BooleanValueContext arg) {
		onExit();
		this.inBooleanValue.pop();
	}

	public boolean inBooleanValue() {
      return !inBooleanValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArrayValue = new java.util.Stack<>();

	@Override
	public void enterArrayValue(com.generator.generators.graphQL.parser.GraphQLParser.ArrayValueContext arg) {
		final Node node = model.newNode(Label.label("ArrayValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArrayValue.push(true);
	}

	public void exitArrayValue(com.generator.generators.graphQL.parser.GraphQLParser.ArrayValueContext arg) {
		onExit();
		this.inArrayValue.pop();
	}

	public boolean inArrayValue() {
      return !inArrayValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inListType = new java.util.Stack<>();

	@Override
	public void enterListType(com.generator.generators.graphQL.parser.GraphQLParser.ListTypeContext arg) {
		final Node node = model.newNode(Label.label("ListType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inListType.push(true);
	}

	public void exitListType(com.generator.generators.graphQL.parser.GraphQLParser.ListTypeContext arg) {
		onExit();
		this.inListType.pop();
	}

	public boolean inListType() {
      return !inListType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNonNullType = new java.util.Stack<>();

	@Override
	public void enterNonNullType(com.generator.generators.graphQL.parser.GraphQLParser.NonNullTypeContext arg) {
		final Node node = model.newNode(Label.label("NonNullType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inNonNullType.push(true);
	}

	public void exitNonNullType(com.generator.generators.graphQL.parser.GraphQLParser.NonNullTypeContext arg) {
		onExit();
		this.inNonNullType.pop();
	}

	public boolean inNonNullType() {
      return !inNonNullType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArray = new java.util.Stack<>();

	@Override
	public void enterArray(com.generator.generators.graphQL.parser.GraphQLParser.ArrayContext arg) {
		final Node node = model.newNode(Label.label("Array"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inArray.push(true);
	}

	public void exitArray(com.generator.generators.graphQL.parser.GraphQLParser.ArrayContext arg) {
		onExit();
		this.inArray.pop();
	}

	public boolean inArray() {
      return !inArray.isEmpty(); 
   }

}