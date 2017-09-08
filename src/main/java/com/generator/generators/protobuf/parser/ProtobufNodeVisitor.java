package com.generator.generators.protobuf.parser;

public class ProtobufNodeVisitor extends ProtobufBaseVisitor<ProtobufNodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		System.out.println("Option");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		System.out.println("PropertyName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		System.out.println("DefaultValue");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		System.out.println("File");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		System.out.println("PackageDecl");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		System.out.println("PackageName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		System.out.println("Imports");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		System.out.println("Message");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		System.out.println("EnumName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		System.out.println("MessageContent");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		System.out.println("Property");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		System.out.println("PackedValue");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		System.out.println("Extensions");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		System.out.println("PropertyType");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		System.out.println("ExtensionMax");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}