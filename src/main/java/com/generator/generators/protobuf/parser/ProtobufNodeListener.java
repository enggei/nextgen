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
	public void enterOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		 //System.out.println("Option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
	}

	public void exitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		 //System.out.println("PropertyName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertyName", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		 onExit();
	}

	@Override
	public void enterDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		 //System.out.println("DefaultValue");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		 onExit();
	}

	@Override
	public void enterFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		 //System.out.println("File");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("File", arg.getText(), arg.getStart().getText()));
	}

	public void exitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		 onExit();
	}

	@Override
	public void enterPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		 //System.out.println("PackageDecl");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PackageDecl", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		 onExit();
	}

	@Override
	public void enterPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		 //System.out.println("PackageName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PackageName", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		 onExit();
	}

	@Override
	public void enterImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		 //System.out.println("Imports");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Imports", arg.getText(), arg.getStart().getText()));
	}

	public void exitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		 onExit();
	}

	@Override
	public void enterMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		 //System.out.println("Message");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Message", arg.getText(), arg.getStart().getText()));
	}

	public void exitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		 onExit();
	}

	@Override
	public void enterEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		 //System.out.println("EnumName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EnumName", arg.getText(), arg.getStart().getText()));
	}

	public void exitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		 onExit();
	}

	@Override
	public void enterMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		 //System.out.println("MessageContent");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MessageContent", arg.getText(), arg.getStart().getText()));
	}

	public void exitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		 onExit();
	}

	@Override
	public void enterProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		 //System.out.println("Property");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Property", arg.getText(), arg.getStart().getText()));
	}

	public void exitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		 onExit();
	}

	@Override
	public void enterPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		 //System.out.println("PackedValue");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PackedValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		 onExit();
	}

	@Override
	public void enterExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		 //System.out.println("Extensions");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Extensions", arg.getText(), arg.getStart().getText()));
	}

	public void exitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		 onExit();
	}

	@Override
	public void enterPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		 //System.out.println("PropertyType");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PropertyType", arg.getText(), arg.getStart().getText()));
	}

	public void exitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		 //System.out.println("ExtensionMax");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExtensionMax", arg.getText(), arg.getStart().getText()));
	}

	public void exitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		 onExit();
	}

}