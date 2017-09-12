package com.generator.generators.protobuf.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ProtobufNeoListener extends ProtobufBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public ProtobufNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public ProtobufNeoListener(com.generator.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
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

	protected boolean inOption = false;

	@Override
	public void enterOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		final Node node = model.findOrCreate(Label.label("Option"), "text", arg.getText());
		onEnter(node);
		this.inOption = true;
	}

	public void exitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		onExit();
		this.inOption = false;
	}

	protected boolean inPropertyName = false;

	@Override
	public void enterPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyName"), "text", arg.getText());
		onEnter(node);
		this.inPropertyName = true;
	}

	public void exitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		onExit();
		this.inPropertyName = false;
	}

	protected boolean inDefaultValue = false;

	@Override
	public void enterDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		final Node node = model.findOrCreate(Label.label("DefaultValue"), "text", arg.getText());
		onEnter(node);
		this.inDefaultValue = true;
	}

	public void exitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		onExit();
		this.inDefaultValue = false;
	}

	protected boolean inFile = false;

	@Override
	public void enterFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		final Node node = model.findOrCreate(Label.label("File"), "text", arg.getText());
		onEnter(node);
		this.inFile = true;
	}

	public void exitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		onExit();
		this.inFile = false;
	}

	protected boolean inPackageDecl = false;

	@Override
	public void enterPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageDecl"), "text", arg.getText());
		onEnter(node);
		this.inPackageDecl = true;
	}

	public void exitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		onExit();
		this.inPackageDecl = false;
	}

	protected boolean inPackageName = false;

	@Override
	public void enterPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		final Node node = model.findOrCreate(Label.label("PackageName"), "text", arg.getText());
		onEnter(node);
		this.inPackageName = true;
	}

	public void exitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		onExit();
		this.inPackageName = false;
	}

	protected boolean inImports = false;

	@Override
	public void enterImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		final Node node = model.findOrCreate(Label.label("Imports"), "text", arg.getText());
		onEnter(node);
		this.inImports = true;
	}

	public void exitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		onExit();
		this.inImports = false;
	}

	protected boolean inMessage = false;

	@Override
	public void enterMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		final Node node = model.findOrCreate(Label.label("Message"), "text", arg.getText());
		onEnter(node);
		this.inMessage = true;
	}

	public void exitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		onExit();
		this.inMessage = false;
	}

	protected boolean inEnumName = false;

	@Override
	public void enterEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		final Node node = model.findOrCreate(Label.label("EnumName"), "text", arg.getText());
		onEnter(node);
		this.inEnumName = true;
	}

	public void exitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		onExit();
		this.inEnumName = false;
	}

	protected boolean inMessageContent = false;

	@Override
	public void enterMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		final Node node = model.findOrCreate(Label.label("MessageContent"), "text", arg.getText());
		onEnter(node);
		this.inMessageContent = true;
	}

	public void exitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		onExit();
		this.inMessageContent = false;
	}

	protected boolean inProperty = false;

	@Override
	public void enterProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		final Node node = model.findOrCreate(Label.label("Property"), "text", arg.getText());
		onEnter(node);
		this.inProperty = true;
	}

	public void exitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		onExit();
		this.inProperty = false;
	}

	protected boolean inPackedValue = false;

	@Override
	public void enterPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		final Node node = model.findOrCreate(Label.label("PackedValue"), "text", arg.getText());
		onEnter(node);
		this.inPackedValue = true;
	}

	public void exitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		onExit();
		this.inPackedValue = false;
	}

	protected boolean inExtensions = false;

	@Override
	public void enterExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		final Node node = model.findOrCreate(Label.label("Extensions"), "text", arg.getText());
		onEnter(node);
		this.inExtensions = true;
	}

	public void exitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		onExit();
		this.inExtensions = false;
	}

	protected boolean inPropertyType = false;

	@Override
	public void enterPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertyType"), "text", arg.getText());
		onEnter(node);
		this.inPropertyType = true;
	}

	public void exitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		onExit();
		this.inPropertyType = false;
	}

	protected boolean inExtensionMax = false;

	@Override
	public void enterExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		final Node node = model.findOrCreate(Label.label("ExtensionMax"), "text", arg.getText());
		onEnter(node);
		this.inExtensionMax = true;
	}

	public void exitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		onExit();
		this.inExtensionMax = false;
	}

}