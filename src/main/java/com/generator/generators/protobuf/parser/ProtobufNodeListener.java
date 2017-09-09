package com.generator.generators.protobuf.parser;

public class ProtobufNodeListener extends ProtobufBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public ProtobufNodeListener() {
		this(false);
	}

	public ProtobufNodeListener(boolean debug) {
		this.debug = debug;
	}

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		delim.append("\t");
		if (debug) System.out.println(delim.toString() + node.name);
   }

   void onExit() {
      if (nodeStack.size() > 1) {
			nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
		}
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		 onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
	}

	public void exitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		 onEnter(new Node("PropertyName", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		 onExit();
	}

	@Override
	public void enterDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		 onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		 onExit();
	}

	@Override
	public void enterFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		 onEnter(new Node("File", arg.getText(), arg.getStart().getText()));
	}

	public void exitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		 onExit();
	}

	@Override
	public void enterPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		 onEnter(new Node("PackageDecl", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		 onExit();
	}

	@Override
	public void enterPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		 onEnter(new Node("PackageName", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		 onExit();
	}

	@Override
	public void enterImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		 onEnter(new Node("Imports", arg.getText(), arg.getStart().getText()));
	}

	public void exitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		 onExit();
	}

	@Override
	public void enterMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		 onEnter(new Node("Message", arg.getText(), arg.getStart().getText()));
	}

	public void exitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		 onEnter(new Node("EnumName", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		 onExit();
	}

	@Override
	public void enterMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		 onEnter(new Node("MessageContent", arg.getText(), arg.getStart().getText()));
	}

	public void exitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		 onExit();
	}

	@Override
	public void enterProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		 onEnter(new Node("Property", arg.getText(), arg.getStart().getText()));
	}

	public void exitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		 onExit();
	}

	@Override
	public void enterPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		 onEnter(new Node("PackedValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		 onExit();
	}

	@Override
	public void enterExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		 onEnter(new Node("Extensions", arg.getText(), arg.getStart().getText()));
	}

	public void exitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		 onEnter(new Node("PropertyType", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		 onEnter(new Node("ExtensionMax", arg.getText(), arg.getStart().getText()));
	}

	public void exitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		 onExit();
	}

}