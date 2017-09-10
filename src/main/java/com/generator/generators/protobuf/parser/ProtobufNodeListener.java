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

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public ProtobufNodeListener() {
		this(false);
	}

	public ProtobufNodeListener(boolean debug) {
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

	protected boolean inOption = false;

	@Override
	public void enterOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
		this.inOption = true;
	}

	public void exitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		onExit();
		this.inOption = false;
	}

	protected boolean inPropertyName = false;

	@Override
	public void enterPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		onEnter(new Node("PropertyName", arg.getText(), arg.getStart().getText()));
		this.inPropertyName = true;
	}

	public void exitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		onExit();
		this.inPropertyName = false;
	}

	protected boolean inDefaultValue = false;

	@Override
	public void enterDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText()));
		this.inDefaultValue = true;
	}

	public void exitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue = false;
	}

	protected boolean inFile = false;

	@Override
	public void enterFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		onEnter(new Node("File", arg.getText(), arg.getStart().getText()));
		this.inFile = true;
	}

	public void exitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		onExit();
		this.inFile = false;
	}

	protected boolean inPackageDecl = false;

	@Override
	public void enterPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		onEnter(new Node("PackageDecl", arg.getText(), arg.getStart().getText()));
		this.inPackageDecl = true;
	}

	public void exitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		onExit();
		this.inPackageDecl = false;
	}

	protected boolean inPackageName = false;

	@Override
	public void enterPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		onEnter(new Node("PackageName", arg.getText(), arg.getStart().getText()));
		this.inPackageName = true;
	}

	public void exitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		onExit();
		this.inPackageName = false;
	}

	protected boolean inImports = false;

	@Override
	public void enterImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		onEnter(new Node("Imports", arg.getText(), arg.getStart().getText()));
		this.inImports = true;
	}

	public void exitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		onExit();
		this.inImports = false;
	}

	protected boolean inMessage = false;

	@Override
	public void enterMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		onEnter(new Node("Message", arg.getText(), arg.getStart().getText()));
		this.inMessage = true;
	}

	public void exitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		onExit();
		this.inMessage = false;
	}

	protected boolean inEnumName = false;

	@Override
	public void enterEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		onEnter(new Node("EnumName", arg.getText(), arg.getStart().getText()));
		this.inEnumName = true;
	}

	public void exitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		onExit();
		this.inEnumName = false;
	}

	protected boolean inMessageContent = false;

	@Override
	public void enterMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		onEnter(new Node("MessageContent", arg.getText(), arg.getStart().getText()));
		this.inMessageContent = true;
	}

	public void exitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		onExit();
		this.inMessageContent = false;
	}

	protected boolean inProperty = false;

	@Override
	public void enterProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		onEnter(new Node("Property", arg.getText(), arg.getStart().getText()));
		this.inProperty = true;
	}

	public void exitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		onExit();
		this.inProperty = false;
	}

	protected boolean inPackedValue = false;

	@Override
	public void enterPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		onEnter(new Node("PackedValue", arg.getText(), arg.getStart().getText()));
		this.inPackedValue = true;
	}

	public void exitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		onExit();
		this.inPackedValue = false;
	}

	protected boolean inExtensions = false;

	@Override
	public void enterExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		onEnter(new Node("Extensions", arg.getText(), arg.getStart().getText()));
		this.inExtensions = true;
	}

	public void exitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		onExit();
		this.inExtensions = false;
	}

	protected boolean inPropertyType = false;

	@Override
	public void enterPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		onEnter(new Node("PropertyType", arg.getText(), arg.getStart().getText()));
		this.inPropertyType = true;
	}

	public void exitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		onExit();
		this.inPropertyType = false;
	}

	protected boolean inExtensionMax = false;

	@Override
	public void enterExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		onEnter(new Node("ExtensionMax", arg.getText(), arg.getStart().getText()));
		this.inExtensionMax = true;
	}

	public void exitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		onExit();
		this.inExtensionMax = false;
	}

}