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
		if (debug) System.out.println(delim.toString() + node.name + " '" + node.value + "'");
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

	protected java.util.Stack<Boolean> inPackageDecl = new java.util.Stack<>();

	@Override
	public void enterPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		onEnter(new Node("PackageDecl", arg.getText(), arg.getStart().getText()));
		this.inPackageDecl.push(true);
	}

	public void exitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		onExit();
		this.inPackageDecl.pop();
	}

	public boolean inPackageDecl() {
      return !inPackageDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackageName = new java.util.Stack<>();

	@Override
	public void enterPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		onEnter(new Node("PackageName", arg.getText(), arg.getStart().getText()));
		this.inPackageName.push(true);
	}

	public void exitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		onExit();
		this.inPackageName.pop();
	}

	public boolean inPackageName() {
      return !inPackageName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImports = new java.util.Stack<>();

	@Override
	public void enterImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		onEnter(new Node("Imports", arg.getText(), arg.getStart().getText()));
		this.inImports.push(true);
	}

	public void exitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		onExit();
		this.inImports.pop();
	}

	public boolean inImports() {
      return !inImports.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessage = new java.util.Stack<>();

	@Override
	public void enterMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		onEnter(new Node("Message", arg.getText(), arg.getStart().getText()));
		this.inMessage.push(true);
	}

	public void exitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		onExit();
		this.inMessage.pop();
	}

	public boolean inMessage() {
      return !inMessage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumName = new java.util.Stack<>();

	@Override
	public void enterEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		onEnter(new Node("EnumName", arg.getText(), arg.getStart().getText()));
		this.inEnumName.push(true);
	}

	public void exitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		onExit();
		this.inEnumName.pop();
	}

	public boolean inEnumName() {
      return !inEnumName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessageContent = new java.util.Stack<>();

	@Override
	public void enterMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		onEnter(new Node("MessageContent", arg.getText(), arg.getStart().getText()));
		this.inMessageContent.push(true);
	}

	public void exitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		onExit();
		this.inMessageContent.pop();
	}

	public boolean inMessageContent() {
      return !inMessageContent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProperty = new java.util.Stack<>();

	@Override
	public void enterProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		onEnter(new Node("Property", arg.getText(), arg.getStart().getText()));
		this.inProperty.push(true);
	}

	public void exitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		onExit();
		this.inProperty.pop();
	}

	public boolean inProperty() {
      return !inProperty.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackedValue = new java.util.Stack<>();

	@Override
	public void enterPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		onEnter(new Node("PackedValue", arg.getText(), arg.getStart().getText()));
		this.inPackedValue.push(true);
	}

	public void exitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		onExit();
		this.inPackedValue.pop();
	}

	public boolean inPackedValue() {
      return !inPackedValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExtensions = new java.util.Stack<>();

	@Override
	public void enterExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		onEnter(new Node("Extensions", arg.getText(), arg.getStart().getText()));
		this.inExtensions.push(true);
	}

	public void exitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		onExit();
		this.inExtensions.pop();
	}

	public boolean inExtensions() {
      return !inExtensions.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyType = new java.util.Stack<>();

	@Override
	public void enterPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		onEnter(new Node("PropertyType", arg.getText(), arg.getStart().getText()));
		this.inPropertyType.push(true);
	}

	public void exitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		onExit();
		this.inPropertyType.pop();
	}

	public boolean inPropertyType() {
      return !inPropertyType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExtensionMax = new java.util.Stack<>();

	@Override
	public void enterExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		onEnter(new Node("ExtensionMax", arg.getText(), arg.getStart().getText()));
		this.inExtensionMax.push(true);
	}

	public void exitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		onExit();
		this.inExtensionMax.pop();
	}

	public boolean inExtensionMax() {
      return !inExtensionMax.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOption = new java.util.Stack<>();

	@Override
	public void enterOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
		this.inOption.push(true);
	}

	public void exitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		onExit();
		this.inOption.pop();
	}

	public boolean inOption() {
      return !inOption.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFile = new java.util.Stack<>();

	@Override
	public void enterFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		onEnter(new Node("File", arg.getText(), arg.getStart().getText()));
		this.inFile.push(true);
	}

	public void exitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		onExit();
		this.inFile.pop();
	}

	public boolean inFile() {
      return !inFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyName = new java.util.Stack<>();

	@Override
	public void enterPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		onEnter(new Node("PropertyName", arg.getText(), arg.getStart().getText()));
		this.inPropertyName.push(true);
	}

	public void exitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		onExit();
		this.inPropertyName.pop();
	}

	public boolean inPropertyName() {
      return !inPropertyName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultValue = new java.util.Stack<>();

	@Override
	public void enterDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		onEnter(new Node("DefaultValue", arg.getText(), arg.getStart().getText()));
		this.inDefaultValue.push(true);
	}

	public void exitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue.pop();
	}

	public boolean inDefaultValue() {
      return !inDefaultValue.isEmpty(); 
   }

}