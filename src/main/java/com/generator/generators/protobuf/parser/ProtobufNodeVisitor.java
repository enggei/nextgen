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
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public ProtobufNodeVisitor() {
		this(false);
	}

	public ProtobufNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
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

	@Override
	public Node visitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		final Node node = new Node("Option", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		final Node node = new Node("PackageDecl", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		final Node node = new Node("DefaultValue", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		final Node node = new Node("PackageName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		final Node node = new Node("File", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		final Node node = new Node("PropertyName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		final Node node = new Node("Imports", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		final Node node = new Node("Message", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		final Node node = new Node("EnumName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		final Node node = new Node("MessageContent", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		final Node node = new Node("Property", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		final Node node = new Node("PackedValue", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		final Node node = new Node("Extensions", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		final Node node = new Node("PropertyType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		final Node node = new Node("ExtensionMax", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}