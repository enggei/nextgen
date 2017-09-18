package com.generator.generators.protobuf.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ProtobufNeoListener extends ProtobufBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public ProtobufNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public ProtobufNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inOption = new java.util.Stack<>();

	@Override
	public void enterOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		final Node node = model.findOrCreate(Label.label("Option"), "text", arg.getText());
		onEnter(node);
		this.inOption.push(true);
	}

	public void exitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		onExit();
		this.inOption.pop();
	}

	public boolean inOption() {
      return inOption.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFile = new java.util.Stack<>();

	@Override
	public void enterFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		final Node node = model.findOrCreate(Label.label("File"), "text", arg.getText());
		onEnter(node);
		this.inFile.push(true);
	}

	public void exitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		onExit();
		this.inFile.pop();
	}

	public boolean inFile() {
      return inFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyName = new java.util.Stack<>();

	@Override
	public void enterPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyName"), "text", arg.getText());
		onEnter(node);
		this.inPropertyName.push(true);
	}

	public void exitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		onExit();
		this.inPropertyName.pop();
	}

	public boolean inPropertyName() {
      return inPropertyName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultValue = new java.util.Stack<>();

	@Override
	public void enterDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		final Node node = model.findOrCreate(Label.label("DefaultValue"), "text", arg.getText());
		onEnter(node);
		this.inDefaultValue.push(true);
	}

	public void exitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue.pop();
	}

	public boolean inDefaultValue() {
      return inDefaultValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackageDecl = new java.util.Stack<>();

	@Override
	public void enterPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageDecl"), "text", arg.getText());
		onEnter(node);
		this.inPackageDecl.push(true);
	}

	public void exitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		onExit();
		this.inPackageDecl.pop();
	}

	public boolean inPackageDecl() {
      return inPackageDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackageName = new java.util.Stack<>();

	@Override
	public void enterPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageName"), "text", arg.getText());
		onEnter(node);
		this.inPackageName.push(true);
	}

	public void exitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		onExit();
		this.inPackageName.pop();
	}

	public boolean inPackageName() {
      return inPackageName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inImports = new java.util.Stack<>();

	@Override
	public void enterImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		final Node node = model.findOrCreate(Label.label("Imports"), "text", arg.getText());
		onEnter(node);
		this.inImports.push(true);
	}

	public void exitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		onExit();
		this.inImports.pop();
	}

	public boolean inImports() {
      return inImports.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessage = new java.util.Stack<>();

	@Override
	public void enterMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		final Node node = model.findOrCreate(Label.label("Message"), "text", arg.getText());
		onEnter(node);
		this.inMessage.push(true);
	}

	public void exitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		onExit();
		this.inMessage.pop();
	}

	public boolean inMessage() {
      return inMessage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEnumName = new java.util.Stack<>();

	@Override
	public void enterEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumName"), "text", arg.getText());
		onEnter(node);
		this.inEnumName.push(true);
	}

	public void exitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		onExit();
		this.inEnumName.pop();
	}

	public boolean inEnumName() {
      return inEnumName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMessageContent = new java.util.Stack<>();

	@Override
	public void enterMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		final Node node = model.findOrCreate(Label.label("MessageContent"), "text", arg.getText());
		onEnter(node);
		this.inMessageContent.push(true);
	}

	public void exitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		onExit();
		this.inMessageContent.pop();
	}

	public boolean inMessageContent() {
      return inMessageContent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inProperty = new java.util.Stack<>();

	@Override
	public void enterProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		final Node node = model.findOrCreate(Label.label("Property"), "text", arg.getText());
		onEnter(node);
		this.inProperty.push(true);
	}

	public void exitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		onExit();
		this.inProperty.pop();
	}

	public boolean inProperty() {
      return inProperty.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPackedValue = new java.util.Stack<>();

	@Override
	public void enterPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		final Node node = model.findOrCreate(Label.label("PackedValue"), "text", arg.getText());
		onEnter(node);
		this.inPackedValue.push(true);
	}

	public void exitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		onExit();
		this.inPackedValue.pop();
	}

	public boolean inPackedValue() {
      return inPackedValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExtensions = new java.util.Stack<>();

	@Override
	public void enterExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		final Node node = model.findOrCreate(Label.label("Extensions"), "text", arg.getText());
		onEnter(node);
		this.inExtensions.push(true);
	}

	public void exitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		onExit();
		this.inExtensions.pop();
	}

	public boolean inExtensions() {
      return inExtensions.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertyType = new java.util.Stack<>();

	@Override
	public void enterPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyType"), "text", arg.getText());
		onEnter(node);
		this.inPropertyType.push(true);
	}

	public void exitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		onExit();
		this.inPropertyType.pop();
	}

	public boolean inPropertyType() {
      return inPropertyType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExtensionMax = new java.util.Stack<>();

	@Override
	public void enterExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		final Node node = model.findOrCreate(Label.label("ExtensionMax"), "text", arg.getText());
		onEnter(node);
		this.inExtensionMax.push(true);
	}

	public void exitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		onExit();
		this.inExtensionMax.pop();
	}

	public boolean inExtensionMax() {
      return inExtensionMax.isEmpty(); 
   }

}