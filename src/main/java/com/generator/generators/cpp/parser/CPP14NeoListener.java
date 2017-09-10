package com.generator.generators.cpp.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class CPP14NeoListener extends CPP14BaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public CPP14NeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public CPP14NeoListener(com.generator.NeoModel model, boolean debug) {
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

	protected boolean inIterationstatement = false;

	@Override
	public void enterIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Iterationstatement"), "text", arg.getText());
		onEnter(node);
		this.inIterationstatement = true;
	}

	public void exitIterationstatement(com.generator.generators.cpp.parser.CPP14Parser.IterationstatementContext arg) {
		onExit();
		this.inIterationstatement = false;
	}

	protected boolean inForinitstatement = false;

	@Override
	public void enterForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Forinitstatement"), "text", arg.getText());
		onEnter(node);
		this.inForinitstatement = true;
	}

	public void exitForinitstatement(com.generator.generators.cpp.parser.CPP14Parser.ForinitstatementContext arg) {
		onExit();
		this.inForinitstatement = false;
	}

	protected boolean inForrangedeclaration = false;

	@Override
	public void enterForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Forrangedeclaration"), "text", arg.getText());
		onEnter(node);
		this.inForrangedeclaration = true;
	}

	public void exitForrangedeclaration(com.generator.generators.cpp.parser.CPP14Parser.ForrangedeclarationContext arg) {
		onExit();
		this.inForrangedeclaration = false;
	}

	protected boolean inForrangeinitializer = false;

	@Override
	public void enterForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Forrangeinitializer"), "text", arg.getText());
		onEnter(node);
		this.inForrangeinitializer = true;
	}

	public void exitForrangeinitializer(com.generator.generators.cpp.parser.CPP14Parser.ForrangeinitializerContext arg) {
		onExit();
		this.inForrangeinitializer = false;
	}

	protected boolean inJumpstatement = false;

	@Override
	public void enterJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Jumpstatement"), "text", arg.getText());
		onEnter(node);
		this.inJumpstatement = true;
	}

	public void exitJumpstatement(com.generator.generators.cpp.parser.CPP14Parser.JumpstatementContext arg) {
		onExit();
		this.inJumpstatement = false;
	}

	protected boolean inDeclarationstatement = false;

	@Override
	public void enterDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Declarationstatement"), "text", arg.getText());
		onEnter(node);
		this.inDeclarationstatement = true;
	}

	public void exitDeclarationstatement(com.generator.generators.cpp.parser.CPP14Parser.DeclarationstatementContext arg) {
		onExit();
		this.inDeclarationstatement = false;
	}

	protected boolean inDeclarationseq = false;

	@Override
	public void enterDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Declarationseq"), "text", arg.getText());
		onEnter(node);
		this.inDeclarationseq = true;
	}

	public void exitDeclarationseq(com.generator.generators.cpp.parser.CPP14Parser.DeclarationseqContext arg) {
		onExit();
		this.inDeclarationseq = false;
	}

	protected boolean inBlockdeclaration = false;

	@Override
	public void enterBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Blockdeclaration"), "text", arg.getText());
		onEnter(node);
		this.inBlockdeclaration = true;
	}

	public void exitBlockdeclaration(com.generator.generators.cpp.parser.CPP14Parser.BlockdeclarationContext arg) {
		onExit();
		this.inBlockdeclaration = false;
	}

	protected boolean inAliasdeclaration = false;

	@Override
	public void enterAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Aliasdeclaration"), "text", arg.getText());
		onEnter(node);
		this.inAliasdeclaration = true;
	}

	public void exitAliasdeclaration(com.generator.generators.cpp.parser.CPP14Parser.AliasdeclarationContext arg) {
		onExit();
		this.inAliasdeclaration = false;
	}

	protected boolean inSimpledeclaration = false;

	@Override
	public void enterSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Simpledeclaration"), "text", arg.getText());
		onEnter(node);
		this.inSimpledeclaration = true;
	}

	public void exitSimpledeclaration(com.generator.generators.cpp.parser.CPP14Parser.SimpledeclarationContext arg) {
		onExit();
		this.inSimpledeclaration = false;
	}

	protected boolean inStatic_assertdeclaration = false;

	@Override
	public void enterStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Static_assertdeclaration"), "text", arg.getText());
		onEnter(node);
		this.inStatic_assertdeclaration = true;
	}

	public void exitStatic_assertdeclaration(com.generator.generators.cpp.parser.CPP14Parser.Static_assertdeclarationContext arg) {
		onExit();
		this.inStatic_assertdeclaration = false;
	}

	protected boolean inEmptydeclaration = false;

	@Override
	public void enterEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Emptydeclaration"), "text", arg.getText());
		onEnter(node);
		this.inEmptydeclaration = true;
	}

	public void exitEmptydeclaration(com.generator.generators.cpp.parser.CPP14Parser.EmptydeclarationContext arg) {
		onExit();
		this.inEmptydeclaration = false;
	}

	protected boolean inAttributedeclaration = false;

	@Override
	public void enterAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributedeclaration"), "text", arg.getText());
		onEnter(node);
		this.inAttributedeclaration = true;
	}

	public void exitAttributedeclaration(com.generator.generators.cpp.parser.CPP14Parser.AttributedeclarationContext arg) {
		onExit();
		this.inAttributedeclaration = false;
	}

	protected boolean inDeclspecifier = false;

	@Override
	public void enterDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Declspecifier"), "text", arg.getText());
		onEnter(node);
		this.inDeclspecifier = true;
	}

	public void exitDeclspecifier(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierContext arg) {
		onExit();
		this.inDeclspecifier = false;
	}

	protected boolean inDeclspecifierseq = false;

	@Override
	public void enterDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Declspecifierseq"), "text", arg.getText());
		onEnter(node);
		this.inDeclspecifierseq = true;
	}

	public void exitDeclspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.DeclspecifierseqContext arg) {
		onExit();
		this.inDeclspecifierseq = false;
	}

	protected boolean inStorageclassspecifier = false;

	@Override
	public void enterStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Storageclassspecifier"), "text", arg.getText());
		onEnter(node);
		this.inStorageclassspecifier = true;
	}

	public void exitStorageclassspecifier(com.generator.generators.cpp.parser.CPP14Parser.StorageclassspecifierContext arg) {
		onExit();
		this.inStorageclassspecifier = false;
	}

	protected boolean inFunctionspecifier = false;

	@Override
	public void enterFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Functionspecifier"), "text", arg.getText());
		onEnter(node);
		this.inFunctionspecifier = true;
	}

	public void exitFunctionspecifier(com.generator.generators.cpp.parser.CPP14Parser.FunctionspecifierContext arg) {
		onExit();
		this.inFunctionspecifier = false;
	}

	protected boolean inTypedefname = false;

	@Override
	public void enterTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Typedefname"), "text", arg.getText());
		onEnter(node);
		this.inTypedefname = true;
	}

	public void exitTypedefname(com.generator.generators.cpp.parser.CPP14Parser.TypedefnameContext arg) {
		onExit();
		this.inTypedefname = false;
	}

	protected boolean inTypespecifier = false;

	@Override
	public void enterTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Typespecifier"), "text", arg.getText());
		onEnter(node);
		this.inTypespecifier = true;
	}

	public void exitTypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierContext arg) {
		onExit();
		this.inTypespecifier = false;
	}

	protected boolean inTrailingtypespecifier = false;

	@Override
	public void enterTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Trailingtypespecifier"), "text", arg.getText());
		onEnter(node);
		this.inTrailingtypespecifier = true;
	}

	public void exitTrailingtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierContext arg) {
		onExit();
		this.inTrailingtypespecifier = false;
	}

	protected boolean inTypespecifierseq = false;

	@Override
	public void enterTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Typespecifierseq"), "text", arg.getText());
		onEnter(node);
		this.inTypespecifierseq = true;
	}

	public void exitTypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TypespecifierseqContext arg) {
		onExit();
		this.inTypespecifierseq = false;
	}

	protected boolean inTrailingtypespecifierseq = false;

	@Override
	public void enterTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Trailingtypespecifierseq"), "text", arg.getText());
		onEnter(node);
		this.inTrailingtypespecifierseq = true;
	}

	public void exitTrailingtypespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.TrailingtypespecifierseqContext arg) {
		onExit();
		this.inTrailingtypespecifierseq = false;
	}

	protected boolean inSimpletypespecifier = false;

	@Override
	public void enterSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Simpletypespecifier"), "text", arg.getText());
		onEnter(node);
		this.inSimpletypespecifier = true;
	}

	public void exitSimpletypespecifier(com.generator.generators.cpp.parser.CPP14Parser.SimpletypespecifierContext arg) {
		onExit();
		this.inSimpletypespecifier = false;
	}

	protected boolean inTypename = false;

	@Override
	public void enterTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Typename"), "text", arg.getText());
		onEnter(node);
		this.inTypename = true;
	}

	public void exitTypename(com.generator.generators.cpp.parser.CPP14Parser.TypenameContext arg) {
		onExit();
		this.inTypename = false;
	}

	protected boolean inDecltypespecifier = false;

	@Override
	public void enterDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Decltypespecifier"), "text", arg.getText());
		onEnter(node);
		this.inDecltypespecifier = true;
	}

	public void exitDecltypespecifier(com.generator.generators.cpp.parser.CPP14Parser.DecltypespecifierContext arg) {
		onExit();
		this.inDecltypespecifier = false;
	}

	protected boolean inElaboratedtypespecifier = false;

	@Override
	public void enterElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Elaboratedtypespecifier"), "text", arg.getText());
		onEnter(node);
		this.inElaboratedtypespecifier = true;
	}

	public void exitElaboratedtypespecifier(com.generator.generators.cpp.parser.CPP14Parser.ElaboratedtypespecifierContext arg) {
		onExit();
		this.inElaboratedtypespecifier = false;
	}

	protected boolean inEnumname = false;

	@Override
	public void enterEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumname"), "text", arg.getText());
		onEnter(node);
		this.inEnumname = true;
	}

	public void exitEnumname(com.generator.generators.cpp.parser.CPP14Parser.EnumnameContext arg) {
		onExit();
		this.inEnumname = false;
	}

	protected boolean inEnumspecifier = false;

	@Override
	public void enterEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumspecifier"), "text", arg.getText());
		onEnter(node);
		this.inEnumspecifier = true;
	}

	public void exitEnumspecifier(com.generator.generators.cpp.parser.CPP14Parser.EnumspecifierContext arg) {
		onExit();
		this.inEnumspecifier = false;
	}

	protected boolean inEnumhead = false;

	@Override
	public void enterEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumhead"), "text", arg.getText());
		onEnter(node);
		this.inEnumhead = true;
	}

	public void exitEnumhead(com.generator.generators.cpp.parser.CPP14Parser.EnumheadContext arg) {
		onExit();
		this.inEnumhead = false;
	}

	protected boolean inOpaqueenumdeclaration = false;

	@Override
	public void enterOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Opaqueenumdeclaration"), "text", arg.getText());
		onEnter(node);
		this.inOpaqueenumdeclaration = true;
	}

	public void exitOpaqueenumdeclaration(com.generator.generators.cpp.parser.CPP14Parser.OpaqueenumdeclarationContext arg) {
		onExit();
		this.inOpaqueenumdeclaration = false;
	}

	protected boolean inEnumkey = false;

	@Override
	public void enterEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumkey"), "text", arg.getText());
		onEnter(node);
		this.inEnumkey = true;
	}

	public void exitEnumkey(com.generator.generators.cpp.parser.CPP14Parser.EnumkeyContext arg) {
		onExit();
		this.inEnumkey = false;
	}

	protected boolean inEnumbase = false;

	@Override
	public void enterEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumbase"), "text", arg.getText());
		onEnter(node);
		this.inEnumbase = true;
	}

	public void exitEnumbase(com.generator.generators.cpp.parser.CPP14Parser.EnumbaseContext arg) {
		onExit();
		this.inEnumbase = false;
	}

	protected boolean inEnumeratorlist = false;

	@Override
	public void enterEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumeratorlist"), "text", arg.getText());
		onEnter(node);
		this.inEnumeratorlist = true;
	}

	public void exitEnumeratorlist(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorlistContext arg) {
		onExit();
		this.inEnumeratorlist = false;
	}

	protected boolean inEnumeratordefinition = false;

	@Override
	public void enterEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumeratordefinition"), "text", arg.getText());
		onEnter(node);
		this.inEnumeratordefinition = true;
	}

	public void exitEnumeratordefinition(com.generator.generators.cpp.parser.CPP14Parser.EnumeratordefinitionContext arg) {
		onExit();
		this.inEnumeratordefinition = false;
	}

	protected boolean inEnumerator = false;

	@Override
	public void enterEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Enumerator"), "text", arg.getText());
		onEnter(node);
		this.inEnumerator = true;
	}

	public void exitEnumerator(com.generator.generators.cpp.parser.CPP14Parser.EnumeratorContext arg) {
		onExit();
		this.inEnumerator = false;
	}

	protected boolean inNamespacename = false;

	@Override
	public void enterNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacename"), "text", arg.getText());
		onEnter(node);
		this.inNamespacename = true;
	}

	public void exitNamespacename(com.generator.generators.cpp.parser.CPP14Parser.NamespacenameContext arg) {
		onExit();
		this.inNamespacename = false;
	}

	protected boolean inOriginalnamespacename = false;

	@Override
	public void enterOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Originalnamespacename"), "text", arg.getText());
		onEnter(node);
		this.inOriginalnamespacename = true;
	}

	public void exitOriginalnamespacename(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacenameContext arg) {
		onExit();
		this.inOriginalnamespacename = false;
	}

	protected boolean inNamespacedefinition = false;

	@Override
	public void enterNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacedefinition"), "text", arg.getText());
		onEnter(node);
		this.inNamespacedefinition = true;
	}

	public void exitNamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacedefinitionContext arg) {
		onExit();
		this.inNamespacedefinition = false;
	}

	protected boolean inNamednamespacedefinition = false;

	@Override
	public void enterNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Namednamespacedefinition"), "text", arg.getText());
		onEnter(node);
		this.inNamednamespacedefinition = true;
	}

	public void exitNamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.NamednamespacedefinitionContext arg) {
		onExit();
		this.inNamednamespacedefinition = false;
	}

	protected boolean inOriginalnamespacedefinition = false;

	@Override
	public void enterOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Originalnamespacedefinition"), "text", arg.getText());
		onEnter(node);
		this.inOriginalnamespacedefinition = true;
	}

	public void exitOriginalnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.OriginalnamespacedefinitionContext arg) {
		onExit();
		this.inOriginalnamespacedefinition = false;
	}

	protected boolean inExtensionnamespacedefinition = false;

	@Override
	public void enterExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Extensionnamespacedefinition"), "text", arg.getText());
		onEnter(node);
		this.inExtensionnamespacedefinition = true;
	}

	public void exitExtensionnamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.ExtensionnamespacedefinitionContext arg) {
		onExit();
		this.inExtensionnamespacedefinition = false;
	}

	protected boolean inUnnamednamespacedefinition = false;

	@Override
	public void enterUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Unnamednamespacedefinition"), "text", arg.getText());
		onEnter(node);
		this.inUnnamednamespacedefinition = true;
	}

	public void exitUnnamednamespacedefinition(com.generator.generators.cpp.parser.CPP14Parser.UnnamednamespacedefinitionContext arg) {
		onExit();
		this.inUnnamednamespacedefinition = false;
	}

	protected boolean inNamespacebody = false;

	@Override
	public void enterNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacebody"), "text", arg.getText());
		onEnter(node);
		this.inNamespacebody = true;
	}

	public void exitNamespacebody(com.generator.generators.cpp.parser.CPP14Parser.NamespacebodyContext arg) {
		onExit();
		this.inNamespacebody = false;
	}

	protected boolean inNamespacealias = false;

	@Override
	public void enterNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacealias"), "text", arg.getText());
		onEnter(node);
		this.inNamespacealias = true;
	}

	public void exitNamespacealias(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasContext arg) {
		onExit();
		this.inNamespacealias = false;
	}

	protected boolean inNamespacealiasdefinition = false;

	@Override
	public void enterNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Namespacealiasdefinition"), "text", arg.getText());
		onEnter(node);
		this.inNamespacealiasdefinition = true;
	}

	public void exitNamespacealiasdefinition(com.generator.generators.cpp.parser.CPP14Parser.NamespacealiasdefinitionContext arg) {
		onExit();
		this.inNamespacealiasdefinition = false;
	}

	protected boolean inQualifiednamespacespecifier = false;

	@Override
	public void enterQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Qualifiednamespacespecifier"), "text", arg.getText());
		onEnter(node);
		this.inQualifiednamespacespecifier = true;
	}

	public void exitQualifiednamespacespecifier(com.generator.generators.cpp.parser.CPP14Parser.QualifiednamespacespecifierContext arg) {
		onExit();
		this.inQualifiednamespacespecifier = false;
	}

	protected boolean inUsingdeclaration = false;

	@Override
	public void enterUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Usingdeclaration"), "text", arg.getText());
		onEnter(node);
		this.inUsingdeclaration = true;
	}

	public void exitUsingdeclaration(com.generator.generators.cpp.parser.CPP14Parser.UsingdeclarationContext arg) {
		onExit();
		this.inUsingdeclaration = false;
	}

	protected boolean inUsingdirective = false;

	@Override
	public void enterUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		final Node node = model.findOrCreate(Label.label("Usingdirective"), "text", arg.getText());
		onEnter(node);
		this.inUsingdirective = true;
	}

	public void exitUsingdirective(com.generator.generators.cpp.parser.CPP14Parser.UsingdirectiveContext arg) {
		onExit();
		this.inUsingdirective = false;
	}

	protected boolean inAsmdefinition = false;

	@Override
	public void enterAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Asmdefinition"), "text", arg.getText());
		onEnter(node);
		this.inAsmdefinition = true;
	}

	public void exitAsmdefinition(com.generator.generators.cpp.parser.CPP14Parser.AsmdefinitionContext arg) {
		onExit();
		this.inAsmdefinition = false;
	}

	protected boolean inLinkagespecification = false;

	@Override
	public void enterLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Linkagespecification"), "text", arg.getText());
		onEnter(node);
		this.inLinkagespecification = true;
	}

	public void exitLinkagespecification(com.generator.generators.cpp.parser.CPP14Parser.LinkagespecificationContext arg) {
		onExit();
		this.inLinkagespecification = false;
	}

	protected boolean inAttributespecifierseq = false;

	@Override
	public void enterAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributespecifierseq"), "text", arg.getText());
		onEnter(node);
		this.inAttributespecifierseq = true;
	}

	public void exitAttributespecifierseq(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierseqContext arg) {
		onExit();
		this.inAttributespecifierseq = false;
	}

	protected boolean inAttributespecifier = false;

	@Override
	public void enterAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributespecifier"), "text", arg.getText());
		onEnter(node);
		this.inAttributespecifier = true;
	}

	public void exitAttributespecifier(com.generator.generators.cpp.parser.CPP14Parser.AttributespecifierContext arg) {
		onExit();
		this.inAttributespecifier = false;
	}

	protected boolean inAlignmentspecifier = false;

	@Override
	public void enterAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Alignmentspecifier"), "text", arg.getText());
		onEnter(node);
		this.inAlignmentspecifier = true;
	}

	public void exitAlignmentspecifier(com.generator.generators.cpp.parser.CPP14Parser.AlignmentspecifierContext arg) {
		onExit();
		this.inAlignmentspecifier = false;
	}

	protected boolean inAttributelist = false;

	@Override
	public void enterAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributelist"), "text", arg.getText());
		onEnter(node);
		this.inAttributelist = true;
	}

	public void exitAttributelist(com.generator.generators.cpp.parser.CPP14Parser.AttributelistContext arg) {
		onExit();
		this.inAttributelist = false;
	}

	protected boolean inAttribute = false;

	@Override
	public void enterAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		final Node node = model.findOrCreate(Label.label("Attribute"), "text", arg.getText());
		onEnter(node);
		this.inAttribute = true;
	}

	public void exitAttribute(com.generator.generators.cpp.parser.CPP14Parser.AttributeContext arg) {
		onExit();
		this.inAttribute = false;
	}

	protected boolean inAttributetoken = false;

	@Override
	public void enterAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributetoken"), "text", arg.getText());
		onEnter(node);
		this.inAttributetoken = true;
	}

	public void exitAttributetoken(com.generator.generators.cpp.parser.CPP14Parser.AttributetokenContext arg) {
		onExit();
		this.inAttributetoken = false;
	}

	protected boolean inAttributescopedtoken = false;

	@Override
	public void enterAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributescopedtoken"), "text", arg.getText());
		onEnter(node);
		this.inAttributescopedtoken = true;
	}

	public void exitAttributescopedtoken(com.generator.generators.cpp.parser.CPP14Parser.AttributescopedtokenContext arg) {
		onExit();
		this.inAttributescopedtoken = false;
	}

	protected boolean inAttributenamespace = false;

	@Override
	public void enterAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributenamespace"), "text", arg.getText());
		onEnter(node);
		this.inAttributenamespace = true;
	}

	public void exitAttributenamespace(com.generator.generators.cpp.parser.CPP14Parser.AttributenamespaceContext arg) {
		onExit();
		this.inAttributenamespace = false;
	}

	protected boolean inAttributeargumentclause = false;

	@Override
	public void enterAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Attributeargumentclause"), "text", arg.getText());
		onEnter(node);
		this.inAttributeargumentclause = true;
	}

	public void exitAttributeargumentclause(com.generator.generators.cpp.parser.CPP14Parser.AttributeargumentclauseContext arg) {
		onExit();
		this.inAttributeargumentclause = false;
	}

	protected boolean inBalancedtokenseq = false;

	@Override
	public void enterBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Balancedtokenseq"), "text", arg.getText());
		onEnter(node);
		this.inBalancedtokenseq = true;
	}

	public void exitBalancedtokenseq(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenseqContext arg) {
		onExit();
		this.inBalancedtokenseq = false;
	}

	protected boolean inBalancedtoken = false;

	@Override
	public void enterBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		final Node node = model.findOrCreate(Label.label("Balancedtoken"), "text", arg.getText());
		onEnter(node);
		this.inBalancedtoken = true;
	}

	public void exitBalancedtoken(com.generator.generators.cpp.parser.CPP14Parser.BalancedtokenContext arg) {
		onExit();
		this.inBalancedtoken = false;
	}

	protected boolean inInitdeclaratorlist = false;

	@Override
	public void enterInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Initdeclaratorlist"), "text", arg.getText());
		onEnter(node);
		this.inInitdeclaratorlist = true;
	}

	public void exitInitdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorlistContext arg) {
		onExit();
		this.inInitdeclaratorlist = false;
	}

	protected boolean inInitdeclarator = false;

	@Override
	public void enterInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Initdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inInitdeclarator = true;
	}

	public void exitInitdeclarator(com.generator.generators.cpp.parser.CPP14Parser.InitdeclaratorContext arg) {
		onExit();
		this.inInitdeclarator = false;
	}

	protected boolean inDeclarator = false;

	@Override
	public void enterDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Declarator"), "text", arg.getText());
		onEnter(node);
		this.inDeclarator = true;
	}

	public void exitDeclarator(com.generator.generators.cpp.parser.CPP14Parser.DeclaratorContext arg) {
		onExit();
		this.inDeclarator = false;
	}

	protected boolean inPtrdeclarator = false;

	@Override
	public void enterPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Ptrdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inPtrdeclarator = true;
	}

	public void exitPtrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrdeclaratorContext arg) {
		onExit();
		this.inPtrdeclarator = false;
	}

	protected boolean inNoptrdeclarator = false;

	@Override
	public void enterNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inNoptrdeclarator = true;
	}

	public void exitNoptrdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrdeclaratorContext arg) {
		onExit();
		this.inNoptrdeclarator = false;
	}

	protected boolean inParametersandqualifiers = false;

	@Override
	public void enterParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		final Node node = model.findOrCreate(Label.label("Parametersandqualifiers"), "text", arg.getText());
		onEnter(node);
		this.inParametersandqualifiers = true;
	}

	public void exitParametersandqualifiers(com.generator.generators.cpp.parser.CPP14Parser.ParametersandqualifiersContext arg) {
		onExit();
		this.inParametersandqualifiers = false;
	}

	protected boolean inTrailingreturntype = false;

	@Override
	public void enterTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		final Node node = model.findOrCreate(Label.label("Trailingreturntype"), "text", arg.getText());
		onEnter(node);
		this.inTrailingreturntype = true;
	}

	public void exitTrailingreturntype(com.generator.generators.cpp.parser.CPP14Parser.TrailingreturntypeContext arg) {
		onExit();
		this.inTrailingreturntype = false;
	}

	protected boolean inPtroperator = false;

	@Override
	public void enterPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Ptroperator"), "text", arg.getText());
		onEnter(node);
		this.inPtroperator = true;
	}

	public void exitPtroperator(com.generator.generators.cpp.parser.CPP14Parser.PtroperatorContext arg) {
		onExit();
		this.inPtroperator = false;
	}

	protected boolean inCvqualifierseq = false;

	@Override
	public void enterCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Cvqualifierseq"), "text", arg.getText());
		onEnter(node);
		this.inCvqualifierseq = true;
	}

	public void exitCvqualifierseq(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierseqContext arg) {
		onExit();
		this.inCvqualifierseq = false;
	}

	protected boolean inCvqualifier = false;

	@Override
	public void enterCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Cvqualifier"), "text", arg.getText());
		onEnter(node);
		this.inCvqualifier = true;
	}

	public void exitCvqualifier(com.generator.generators.cpp.parser.CPP14Parser.CvqualifierContext arg) {
		onExit();
		this.inCvqualifier = false;
	}

	protected boolean inRefqualifier = false;

	@Override
	public void enterRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Refqualifier"), "text", arg.getText());
		onEnter(node);
		this.inRefqualifier = true;
	}

	public void exitRefqualifier(com.generator.generators.cpp.parser.CPP14Parser.RefqualifierContext arg) {
		onExit();
		this.inRefqualifier = false;
	}

	protected boolean inDeclaratorid = false;

	@Override
	public void enterDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		final Node node = model.findOrCreate(Label.label("Declaratorid"), "text", arg.getText());
		onEnter(node);
		this.inDeclaratorid = true;
	}

	public void exitDeclaratorid(com.generator.generators.cpp.parser.CPP14Parser.DeclaratoridContext arg) {
		onExit();
		this.inDeclaratorid = false;
	}

	protected boolean inTypeid = false;

	@Override
	public void enterTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		final Node node = model.findOrCreate(Label.label("Typeid"), "text", arg.getText());
		onEnter(node);
		this.inTypeid = true;
	}

	public void exitTypeid(com.generator.generators.cpp.parser.CPP14Parser.TypeidContext arg) {
		onExit();
		this.inTypeid = false;
	}

	protected boolean inAbstractdeclarator = false;

	@Override
	public void enterAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Abstractdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inAbstractdeclarator = true;
	}

	public void exitAbstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractdeclaratorContext arg) {
		onExit();
		this.inAbstractdeclarator = false;
	}

	protected boolean inPtrabstractdeclarator = false;

	@Override
	public void enterPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Ptrabstractdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inPtrabstractdeclarator = true;
	}

	public void exitPtrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.PtrabstractdeclaratorContext arg) {
		onExit();
		this.inPtrabstractdeclarator = false;
	}

	protected boolean inNoptrabstractdeclarator = false;

	@Override
	public void enterNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrabstractdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inNoptrabstractdeclarator = true;
	}

	public void exitNoptrabstractdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractdeclaratorContext arg) {
		onExit();
		this.inNoptrabstractdeclarator = false;
	}

	protected boolean inAbstractpackdeclarator = false;

	@Override
	public void enterAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Abstractpackdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inAbstractpackdeclarator = true;
	}

	public void exitAbstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.AbstractpackdeclaratorContext arg) {
		onExit();
		this.inAbstractpackdeclarator = false;
	}

	protected boolean inNoptrabstractpackdeclarator = false;

	@Override
	public void enterNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrabstractpackdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inNoptrabstractpackdeclarator = true;
	}

	public void exitNoptrabstractpackdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrabstractpackdeclaratorContext arg) {
		onExit();
		this.inNoptrabstractpackdeclarator = false;
	}

	protected boolean inParameterdeclarationclause = false;

	@Override
	public void enterParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Parameterdeclarationclause"), "text", arg.getText());
		onEnter(node);
		this.inParameterdeclarationclause = true;
	}

	public void exitParameterdeclarationclause(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationclauseContext arg) {
		onExit();
		this.inParameterdeclarationclause = false;
	}

	protected boolean inParameterdeclarationlist = false;

	@Override
	public void enterParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Parameterdeclarationlist"), "text", arg.getText());
		onEnter(node);
		this.inParameterdeclarationlist = true;
	}

	public void exitParameterdeclarationlist(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationlistContext arg) {
		onExit();
		this.inParameterdeclarationlist = false;
	}

	protected boolean inParameterdeclaration = false;

	@Override
	public void enterParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Parameterdeclaration"), "text", arg.getText());
		onEnter(node);
		this.inParameterdeclaration = true;
	}

	public void exitParameterdeclaration(com.generator.generators.cpp.parser.CPP14Parser.ParameterdeclarationContext arg) {
		onExit();
		this.inParameterdeclaration = false;
	}

	protected boolean inFunctiondefinition = false;

	@Override
	public void enterFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		final Node node = model.findOrCreate(Label.label("Functiondefinition"), "text", arg.getText());
		onEnter(node);
		this.inFunctiondefinition = true;
	}

	public void exitFunctiondefinition(com.generator.generators.cpp.parser.CPP14Parser.FunctiondefinitionContext arg) {
		onExit();
		this.inFunctiondefinition = false;
	}

	protected boolean inFunctionbody = false;

	@Override
	public void enterFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		final Node node = model.findOrCreate(Label.label("Functionbody"), "text", arg.getText());
		onEnter(node);
		this.inFunctionbody = true;
	}

	public void exitFunctionbody(com.generator.generators.cpp.parser.CPP14Parser.FunctionbodyContext arg) {
		onExit();
		this.inFunctionbody = false;
	}

	protected boolean inInitializer = false;

	@Override
	public void enterInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Initializer"), "text", arg.getText());
		onEnter(node);
		this.inInitializer = true;
	}

	public void exitInitializer(com.generator.generators.cpp.parser.CPP14Parser.InitializerContext arg) {
		onExit();
		this.inInitializer = false;
	}

	protected boolean inBraceorequalinitializer = false;

	@Override
	public void enterBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Braceorequalinitializer"), "text", arg.getText());
		onEnter(node);
		this.inBraceorequalinitializer = true;
	}

	public void exitBraceorequalinitializer(com.generator.generators.cpp.parser.CPP14Parser.BraceorequalinitializerContext arg) {
		onExit();
		this.inBraceorequalinitializer = false;
	}

	protected boolean inInitializerclause = false;

	@Override
	public void enterInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Initializerclause"), "text", arg.getText());
		onEnter(node);
		this.inInitializerclause = true;
	}

	public void exitInitializerclause(com.generator.generators.cpp.parser.CPP14Parser.InitializerclauseContext arg) {
		onExit();
		this.inInitializerclause = false;
	}

	protected boolean inInitializerlist = false;

	@Override
	public void enterInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Initializerlist"), "text", arg.getText());
		onEnter(node);
		this.inInitializerlist = true;
	}

	public void exitInitializerlist(com.generator.generators.cpp.parser.CPP14Parser.InitializerlistContext arg) {
		onExit();
		this.inInitializerlist = false;
	}

	protected boolean inBracedinitlist = false;

	@Override
	public void enterBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Bracedinitlist"), "text", arg.getText());
		onEnter(node);
		this.inBracedinitlist = true;
	}

	public void exitBracedinitlist(com.generator.generators.cpp.parser.CPP14Parser.BracedinitlistContext arg) {
		onExit();
		this.inBracedinitlist = false;
	}

	protected boolean inClassname = false;

	@Override
	public void enterClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Classname"), "text", arg.getText());
		onEnter(node);
		this.inClassname = true;
	}

	public void exitClassname(com.generator.generators.cpp.parser.CPP14Parser.ClassnameContext arg) {
		onExit();
		this.inClassname = false;
	}

	protected boolean inClassspecifier = false;

	@Override
	public void enterClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Classspecifier"), "text", arg.getText());
		onEnter(node);
		this.inClassspecifier = true;
	}

	public void exitClassspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassspecifierContext arg) {
		onExit();
		this.inClassspecifier = false;
	}

	protected boolean inClasshead = false;

	@Override
	public void enterClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		final Node node = model.findOrCreate(Label.label("Classhead"), "text", arg.getText());
		onEnter(node);
		this.inClasshead = true;
	}

	public void exitClasshead(com.generator.generators.cpp.parser.CPP14Parser.ClassheadContext arg) {
		onExit();
		this.inClasshead = false;
	}

	protected boolean inClassheadname = false;

	@Override
	public void enterClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		final Node node = model.findOrCreate(Label.label("Classheadname"), "text", arg.getText());
		onEnter(node);
		this.inClassheadname = true;
	}

	public void exitClassheadname(com.generator.generators.cpp.parser.CPP14Parser.ClassheadnameContext arg) {
		onExit();
		this.inClassheadname = false;
	}

	protected boolean inClassvirtspecifier = false;

	@Override
	public void enterClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Classvirtspecifier"), "text", arg.getText());
		onEnter(node);
		this.inClassvirtspecifier = true;
	}

	public void exitClassvirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.ClassvirtspecifierContext arg) {
		onExit();
		this.inClassvirtspecifier = false;
	}

	protected boolean inClasskey = false;

	@Override
	public void enterClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		final Node node = model.findOrCreate(Label.label("Classkey"), "text", arg.getText());
		onEnter(node);
		this.inClasskey = true;
	}

	public void exitClasskey(com.generator.generators.cpp.parser.CPP14Parser.ClasskeyContext arg) {
		onExit();
		this.inClasskey = false;
	}

	protected boolean inMemberspecification = false;

	@Override
	public void enterMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberspecification"), "text", arg.getText());
		onEnter(node);
		this.inMemberspecification = true;
	}

	public void exitMemberspecification(com.generator.generators.cpp.parser.CPP14Parser.MemberspecificationContext arg) {
		onExit();
		this.inMemberspecification = false;
	}

	protected boolean inMemberdeclaration = false;

	@Override
	public void enterMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberdeclaration"), "text", arg.getText());
		onEnter(node);
		this.inMemberdeclaration = true;
	}

	public void exitMemberdeclaration(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclarationContext arg) {
		onExit();
		this.inMemberdeclaration = false;
	}

	protected boolean inMemberdeclaratorlist = false;

	@Override
	public void enterMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberdeclaratorlist"), "text", arg.getText());
		onEnter(node);
		this.inMemberdeclaratorlist = true;
	}

	public void exitMemberdeclaratorlist(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorlistContext arg) {
		onExit();
		this.inMemberdeclaratorlist = false;
	}

	protected boolean inMemberdeclarator = false;

	@Override
	public void enterMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Memberdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inMemberdeclarator = true;
	}

	public void exitMemberdeclarator(com.generator.generators.cpp.parser.CPP14Parser.MemberdeclaratorContext arg) {
		onExit();
		this.inMemberdeclarator = false;
	}

	protected boolean inVirtspecifierseq = false;

	@Override
	public void enterVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Virtspecifierseq"), "text", arg.getText());
		onEnter(node);
		this.inVirtspecifierseq = true;
	}

	public void exitVirtspecifierseq(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierseqContext arg) {
		onExit();
		this.inVirtspecifierseq = false;
	}

	protected boolean inVirtspecifier = false;

	@Override
	public void enterVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Virtspecifier"), "text", arg.getText());
		onEnter(node);
		this.inVirtspecifier = true;
	}

	public void exitVirtspecifier(com.generator.generators.cpp.parser.CPP14Parser.VirtspecifierContext arg) {
		onExit();
		this.inVirtspecifier = false;
	}

	protected boolean inPurespecifier = false;

	@Override
	public void enterPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Purespecifier"), "text", arg.getText());
		onEnter(node);
		this.inPurespecifier = true;
	}

	public void exitPurespecifier(com.generator.generators.cpp.parser.CPP14Parser.PurespecifierContext arg) {
		onExit();
		this.inPurespecifier = false;
	}

	protected boolean inBaseclause = false;

	@Override
	public void enterBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		final Node node = model.findOrCreate(Label.label("Baseclause"), "text", arg.getText());
		onEnter(node);
		this.inBaseclause = true;
	}

	public void exitBaseclause(com.generator.generators.cpp.parser.CPP14Parser.BaseclauseContext arg) {
		onExit();
		this.inBaseclause = false;
	}

	protected boolean inBasespecifierlist = false;

	@Override
	public void enterBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Basespecifierlist"), "text", arg.getText());
		onEnter(node);
		this.inBasespecifierlist = true;
	}

	public void exitBasespecifierlist(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierlistContext arg) {
		onExit();
		this.inBasespecifierlist = false;
	}

	protected boolean inBasespecifier = false;

	@Override
	public void enterBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Basespecifier"), "text", arg.getText());
		onEnter(node);
		this.inBasespecifier = true;
	}

	public void exitBasespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasespecifierContext arg) {
		onExit();
		this.inBasespecifier = false;
	}

	protected boolean inClassordecltype = false;

	@Override
	public void enterClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		final Node node = model.findOrCreate(Label.label("Classordecltype"), "text", arg.getText());
		onEnter(node);
		this.inClassordecltype = true;
	}

	public void exitClassordecltype(com.generator.generators.cpp.parser.CPP14Parser.ClassordecltypeContext arg) {
		onExit();
		this.inClassordecltype = false;
	}

	protected boolean inBasetypespecifier = false;

	@Override
	public void enterBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Basetypespecifier"), "text", arg.getText());
		onEnter(node);
		this.inBasetypespecifier = true;
	}

	public void exitBasetypespecifier(com.generator.generators.cpp.parser.CPP14Parser.BasetypespecifierContext arg) {
		onExit();
		this.inBasetypespecifier = false;
	}

	protected boolean inAccessspecifier = false;

	@Override
	public void enterAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Accessspecifier"), "text", arg.getText());
		onEnter(node);
		this.inAccessspecifier = true;
	}

	public void exitAccessspecifier(com.generator.generators.cpp.parser.CPP14Parser.AccessspecifierContext arg) {
		onExit();
		this.inAccessspecifier = false;
	}

	protected boolean inConversionfunctionid = false;

	@Override
	public void enterConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		final Node node = model.findOrCreate(Label.label("Conversionfunctionid"), "text", arg.getText());
		onEnter(node);
		this.inConversionfunctionid = true;
	}

	public void exitConversionfunctionid(com.generator.generators.cpp.parser.CPP14Parser.ConversionfunctionidContext arg) {
		onExit();
		this.inConversionfunctionid = false;
	}

	protected boolean inConversiontypeid = false;

	@Override
	public void enterConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		final Node node = model.findOrCreate(Label.label("Conversiontypeid"), "text", arg.getText());
		onEnter(node);
		this.inConversiontypeid = true;
	}

	public void exitConversiontypeid(com.generator.generators.cpp.parser.CPP14Parser.ConversiontypeidContext arg) {
		onExit();
		this.inConversiontypeid = false;
	}

	protected boolean inConversiondeclarator = false;

	@Override
	public void enterConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Conversiondeclarator"), "text", arg.getText());
		onEnter(node);
		this.inConversiondeclarator = true;
	}

	public void exitConversiondeclarator(com.generator.generators.cpp.parser.CPP14Parser.ConversiondeclaratorContext arg) {
		onExit();
		this.inConversiondeclarator = false;
	}

	protected boolean inCtorinitializer = false;

	@Override
	public void enterCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Ctorinitializer"), "text", arg.getText());
		onEnter(node);
		this.inCtorinitializer = true;
	}

	public void exitCtorinitializer(com.generator.generators.cpp.parser.CPP14Parser.CtorinitializerContext arg) {
		onExit();
		this.inCtorinitializer = false;
	}

	protected boolean inMeminitializerlist = false;

	@Override
	public void enterMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Meminitializerlist"), "text", arg.getText());
		onEnter(node);
		this.inMeminitializerlist = true;
	}

	public void exitMeminitializerlist(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerlistContext arg) {
		onExit();
		this.inMeminitializerlist = false;
	}

	protected boolean inMeminitializer = false;

	@Override
	public void enterMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Meminitializer"), "text", arg.getText());
		onEnter(node);
		this.inMeminitializer = true;
	}

	public void exitMeminitializer(com.generator.generators.cpp.parser.CPP14Parser.MeminitializerContext arg) {
		onExit();
		this.inMeminitializer = false;
	}

	protected boolean inMeminitializerid = false;

	@Override
	public void enterMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		final Node node = model.findOrCreate(Label.label("Meminitializerid"), "text", arg.getText());
		onEnter(node);
		this.inMeminitializerid = true;
	}

	public void exitMeminitializerid(com.generator.generators.cpp.parser.CPP14Parser.MeminitializeridContext arg) {
		onExit();
		this.inMeminitializerid = false;
	}

	protected boolean inOperatorfunctionid = false;

	@Override
	public void enterOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		final Node node = model.findOrCreate(Label.label("Operatorfunctionid"), "text", arg.getText());
		onEnter(node);
		this.inOperatorfunctionid = true;
	}

	public void exitOperatorfunctionid(com.generator.generators.cpp.parser.CPP14Parser.OperatorfunctionidContext arg) {
		onExit();
		this.inOperatorfunctionid = false;
	}

	protected boolean inLiteraloperatorid = false;

	@Override
	public void enterLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		final Node node = model.findOrCreate(Label.label("Literaloperatorid"), "text", arg.getText());
		onEnter(node);
		this.inLiteraloperatorid = true;
	}

	public void exitLiteraloperatorid(com.generator.generators.cpp.parser.CPP14Parser.LiteraloperatoridContext arg) {
		onExit();
		this.inLiteraloperatorid = false;
	}

	protected boolean inTemplatedeclaration = false;

	@Override
	public void enterTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Templatedeclaration"), "text", arg.getText());
		onEnter(node);
		this.inTemplatedeclaration = true;
	}

	public void exitTemplatedeclaration(com.generator.generators.cpp.parser.CPP14Parser.TemplatedeclarationContext arg) {
		onExit();
		this.inTemplatedeclaration = false;
	}

	protected boolean inTemplateparameterlist = false;

	@Override
	public void enterTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateparameterlist"), "text", arg.getText());
		onEnter(node);
		this.inTemplateparameterlist = true;
	}

	public void exitTemplateparameterlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterlistContext arg) {
		onExit();
		this.inTemplateparameterlist = false;
	}

	protected boolean inTemplateparameter = false;

	@Override
	public void enterTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateparameter"), "text", arg.getText());
		onEnter(node);
		this.inTemplateparameter = true;
	}

	public void exitTemplateparameter(com.generator.generators.cpp.parser.CPP14Parser.TemplateparameterContext arg) {
		onExit();
		this.inTemplateparameter = false;
	}

	protected boolean inTypeparameter = false;

	@Override
	public void enterTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		final Node node = model.findOrCreate(Label.label("Typeparameter"), "text", arg.getText());
		onEnter(node);
		this.inTypeparameter = true;
	}

	public void exitTypeparameter(com.generator.generators.cpp.parser.CPP14Parser.TypeparameterContext arg) {
		onExit();
		this.inTypeparameter = false;
	}

	protected boolean inSimpletemplateid = false;

	@Override
	public void enterSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		final Node node = model.findOrCreate(Label.label("Simpletemplateid"), "text", arg.getText());
		onEnter(node);
		this.inSimpletemplateid = true;
	}

	public void exitSimpletemplateid(com.generator.generators.cpp.parser.CPP14Parser.SimpletemplateidContext arg) {
		onExit();
		this.inSimpletemplateid = false;
	}

	protected boolean inTemplateid = false;

	@Override
	public void enterTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateid"), "text", arg.getText());
		onEnter(node);
		this.inTemplateid = true;
	}

	public void exitTemplateid(com.generator.generators.cpp.parser.CPP14Parser.TemplateidContext arg) {
		onExit();
		this.inTemplateid = false;
	}

	protected boolean inTemplatename = false;

	@Override
	public void enterTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		final Node node = model.findOrCreate(Label.label("Templatename"), "text", arg.getText());
		onEnter(node);
		this.inTemplatename = true;
	}

	public void exitTemplatename(com.generator.generators.cpp.parser.CPP14Parser.TemplatenameContext arg) {
		onExit();
		this.inTemplatename = false;
	}

	protected boolean inTemplateargumentlist = false;

	@Override
	public void enterTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateargumentlist"), "text", arg.getText());
		onEnter(node);
		this.inTemplateargumentlist = true;
	}

	public void exitTemplateargumentlist(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentlistContext arg) {
		onExit();
		this.inTemplateargumentlist = false;
	}

	protected boolean inTemplateargument = false;

	@Override
	public void enterTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		final Node node = model.findOrCreate(Label.label("Templateargument"), "text", arg.getText());
		onEnter(node);
		this.inTemplateargument = true;
	}

	public void exitTemplateargument(com.generator.generators.cpp.parser.CPP14Parser.TemplateargumentContext arg) {
		onExit();
		this.inTemplateargument = false;
	}

	protected boolean inTypenamespecifier = false;

	@Override
	public void enterTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Typenamespecifier"), "text", arg.getText());
		onEnter(node);
		this.inTypenamespecifier = true;
	}

	public void exitTypenamespecifier(com.generator.generators.cpp.parser.CPP14Parser.TypenamespecifierContext arg) {
		onExit();
		this.inTypenamespecifier = false;
	}

	protected boolean inExplicitinstantiation = false;

	@Override
	public void enterExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		final Node node = model.findOrCreate(Label.label("Explicitinstantiation"), "text", arg.getText());
		onEnter(node);
		this.inExplicitinstantiation = true;
	}

	public void exitExplicitinstantiation(com.generator.generators.cpp.parser.CPP14Parser.ExplicitinstantiationContext arg) {
		onExit();
		this.inExplicitinstantiation = false;
	}

	protected boolean inExplicitspecialization = false;

	@Override
	public void enterExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		final Node node = model.findOrCreate(Label.label("Explicitspecialization"), "text", arg.getText());
		onEnter(node);
		this.inExplicitspecialization = true;
	}

	public void exitExplicitspecialization(com.generator.generators.cpp.parser.CPP14Parser.ExplicitspecializationContext arg) {
		onExit();
		this.inExplicitspecialization = false;
	}

	protected boolean inTryblock = false;

	@Override
	public void enterTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		final Node node = model.findOrCreate(Label.label("Tryblock"), "text", arg.getText());
		onEnter(node);
		this.inTryblock = true;
	}

	public void exitTryblock(com.generator.generators.cpp.parser.CPP14Parser.TryblockContext arg) {
		onExit();
		this.inTryblock = false;
	}

	protected boolean inFunctiontryblock = false;

	@Override
	public void enterFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		final Node node = model.findOrCreate(Label.label("Functiontryblock"), "text", arg.getText());
		onEnter(node);
		this.inFunctiontryblock = true;
	}

	public void exitFunctiontryblock(com.generator.generators.cpp.parser.CPP14Parser.FunctiontryblockContext arg) {
		onExit();
		this.inFunctiontryblock = false;
	}

	protected boolean inHandlerseq = false;

	@Override
	public void enterHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Handlerseq"), "text", arg.getText());
		onEnter(node);
		this.inHandlerseq = true;
	}

	public void exitHandlerseq(com.generator.generators.cpp.parser.CPP14Parser.HandlerseqContext arg) {
		onExit();
		this.inHandlerseq = false;
	}

	protected boolean inHandler = false;

	@Override
	public void enterHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		final Node node = model.findOrCreate(Label.label("Handler"), "text", arg.getText());
		onEnter(node);
		this.inHandler = true;
	}

	public void exitHandler(com.generator.generators.cpp.parser.CPP14Parser.HandlerContext arg) {
		onExit();
		this.inHandler = false;
	}

	protected boolean inExceptiondeclaration = false;

	@Override
	public void enterExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Exceptiondeclaration"), "text", arg.getText());
		onEnter(node);
		this.inExceptiondeclaration = true;
	}

	public void exitExceptiondeclaration(com.generator.generators.cpp.parser.CPP14Parser.ExceptiondeclarationContext arg) {
		onExit();
		this.inExceptiondeclaration = false;
	}

	protected boolean inThrowexpression = false;

	@Override
	public void enterThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Throwexpression"), "text", arg.getText());
		onEnter(node);
		this.inThrowexpression = true;
	}

	public void exitThrowexpression(com.generator.generators.cpp.parser.CPP14Parser.ThrowexpressionContext arg) {
		onExit();
		this.inThrowexpression = false;
	}

	protected boolean inExceptionspecification = false;

	@Override
	public void enterExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Exceptionspecification"), "text", arg.getText());
		onEnter(node);
		this.inExceptionspecification = true;
	}

	public void exitExceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.ExceptionspecificationContext arg) {
		onExit();
		this.inExceptionspecification = false;
	}

	protected boolean inDynamicexceptionspecification = false;

	@Override
	public void enterDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Dynamicexceptionspecification"), "text", arg.getText());
		onEnter(node);
		this.inDynamicexceptionspecification = true;
	}

	public void exitDynamicexceptionspecification(com.generator.generators.cpp.parser.CPP14Parser.DynamicexceptionspecificationContext arg) {
		onExit();
		this.inDynamicexceptionspecification = false;
	}

	protected boolean inTypeidlist = false;

	@Override
	public void enterTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Typeidlist"), "text", arg.getText());
		onEnter(node);
		this.inTypeidlist = true;
	}

	public void exitTypeidlist(com.generator.generators.cpp.parser.CPP14Parser.TypeidlistContext arg) {
		onExit();
		this.inTypeidlist = false;
	}

	protected boolean inNoexceptspecification = false;

	@Override
	public void enterNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		final Node node = model.findOrCreate(Label.label("Noexceptspecification"), "text", arg.getText());
		onEnter(node);
		this.inNoexceptspecification = true;
	}

	public void exitNoexceptspecification(com.generator.generators.cpp.parser.CPP14Parser.NoexceptspecificationContext arg) {
		onExit();
		this.inNoexceptspecification = false;
	}

	protected boolean inRightShift = false;

	@Override
	public void enterRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		final Node node = model.findOrCreate(Label.label("RightShift"), "text", arg.getText());
		onEnter(node);
		this.inRightShift = true;
	}

	public void exitRightShift(com.generator.generators.cpp.parser.CPP14Parser.RightShiftContext arg) {
		onExit();
		this.inRightShift = false;
	}

	protected boolean inRightShiftAssign = false;

	@Override
	public void enterRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		final Node node = model.findOrCreate(Label.label("RightShiftAssign"), "text", arg.getText());
		onEnter(node);
		this.inRightShiftAssign = true;
	}

	public void exitRightShiftAssign(com.generator.generators.cpp.parser.CPP14Parser.RightShiftAssignContext arg) {
		onExit();
		this.inRightShiftAssign = false;
	}

	protected boolean inOperator = false;

	@Override
	public void enterOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Operator"), "text", arg.getText());
		onEnter(node);
		this.inOperator = true;
	}

	public void exitOperator(com.generator.generators.cpp.parser.CPP14Parser.OperatorContext arg) {
		onExit();
		this.inOperator = false;
	}

	protected boolean inLiteral = false;

	@Override
	public void enterLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Literal"), "text", arg.getText());
		onEnter(node);
		this.inLiteral = true;
	}

	public void exitLiteral(com.generator.generators.cpp.parser.CPP14Parser.LiteralContext arg) {
		onExit();
		this.inLiteral = false;
	}

	protected boolean inBooleanliteral = false;

	@Override
	public void enterBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Booleanliteral"), "text", arg.getText());
		onEnter(node);
		this.inBooleanliteral = true;
	}

	public void exitBooleanliteral(com.generator.generators.cpp.parser.CPP14Parser.BooleanliteralContext arg) {
		onExit();
		this.inBooleanliteral = false;
	}

	protected boolean inPointerliteral = false;

	@Override
	public void enterPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Pointerliteral"), "text", arg.getText());
		onEnter(node);
		this.inPointerliteral = true;
	}

	public void exitPointerliteral(com.generator.generators.cpp.parser.CPP14Parser.PointerliteralContext arg) {
		onExit();
		this.inPointerliteral = false;
	}

	protected boolean inUserdefinedliteral = false;

	@Override
	public void enterUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		final Node node = model.findOrCreate(Label.label("Userdefinedliteral"), "text", arg.getText());
		onEnter(node);
		this.inUserdefinedliteral = true;
	}

	public void exitUserdefinedliteral(com.generator.generators.cpp.parser.CPP14Parser.UserdefinedliteralContext arg) {
		onExit();
		this.inUserdefinedliteral = false;
	}

	protected boolean inTranslationunit = false;

	@Override
	public void enterTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		final Node node = model.findOrCreate(Label.label("Translationunit"), "text", arg.getText());
		onEnter(node);
		this.inTranslationunit = true;
	}

	public void exitTranslationunit(com.generator.generators.cpp.parser.CPP14Parser.TranslationunitContext arg) {
		onExit();
		this.inTranslationunit = false;
	}

	protected boolean inPrimaryexpression = false;

	@Override
	public void enterPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Primaryexpression"), "text", arg.getText());
		onEnter(node);
		this.inPrimaryexpression = true;
	}

	public void exitPrimaryexpression(com.generator.generators.cpp.parser.CPP14Parser.PrimaryexpressionContext arg) {
		onExit();
		this.inPrimaryexpression = false;
	}

	protected boolean inIdexpression = false;

	@Override
	public void enterIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Idexpression"), "text", arg.getText());
		onEnter(node);
		this.inIdexpression = true;
	}

	public void exitIdexpression(com.generator.generators.cpp.parser.CPP14Parser.IdexpressionContext arg) {
		onExit();
		this.inIdexpression = false;
	}

	protected boolean inUnqualifiedid = false;

	@Override
	public void enterUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		final Node node = model.findOrCreate(Label.label("Unqualifiedid"), "text", arg.getText());
		onEnter(node);
		this.inUnqualifiedid = true;
	}

	public void exitUnqualifiedid(com.generator.generators.cpp.parser.CPP14Parser.UnqualifiedidContext arg) {
		onExit();
		this.inUnqualifiedid = false;
	}

	protected boolean inQualifiedid = false;

	@Override
	public void enterQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		final Node node = model.findOrCreate(Label.label("Qualifiedid"), "text", arg.getText());
		onEnter(node);
		this.inQualifiedid = true;
	}

	public void exitQualifiedid(com.generator.generators.cpp.parser.CPP14Parser.QualifiedidContext arg) {
		onExit();
		this.inQualifiedid = false;
	}

	protected boolean inNestednamespecifier = false;

	@Override
	public void enterNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Nestednamespecifier"), "text", arg.getText());
		onEnter(node);
		this.inNestednamespecifier = true;
	}

	public void exitNestednamespecifier(com.generator.generators.cpp.parser.CPP14Parser.NestednamespecifierContext arg) {
		onExit();
		this.inNestednamespecifier = false;
	}

	protected boolean inLambdaexpression = false;

	@Override
	public void enterLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdaexpression"), "text", arg.getText());
		onEnter(node);
		this.inLambdaexpression = true;
	}

	public void exitLambdaexpression(com.generator.generators.cpp.parser.CPP14Parser.LambdaexpressionContext arg) {
		onExit();
		this.inLambdaexpression = false;
	}

	protected boolean inLambdaintroducer = false;

	@Override
	public void enterLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdaintroducer"), "text", arg.getText());
		onEnter(node);
		this.inLambdaintroducer = true;
	}

	public void exitLambdaintroducer(com.generator.generators.cpp.parser.CPP14Parser.LambdaintroducerContext arg) {
		onExit();
		this.inLambdaintroducer = false;
	}

	protected boolean inLambdacapture = false;

	@Override
	public void enterLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdacapture"), "text", arg.getText());
		onEnter(node);
		this.inLambdacapture = true;
	}

	public void exitLambdacapture(com.generator.generators.cpp.parser.CPP14Parser.LambdacaptureContext arg) {
		onExit();
		this.inLambdacapture = false;
	}

	protected boolean inCapturedefault = false;

	@Override
	public void enterCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		final Node node = model.findOrCreate(Label.label("Capturedefault"), "text", arg.getText());
		onEnter(node);
		this.inCapturedefault = true;
	}

	public void exitCapturedefault(com.generator.generators.cpp.parser.CPP14Parser.CapturedefaultContext arg) {
		onExit();
		this.inCapturedefault = false;
	}

	protected boolean inCapturelist = false;

	@Override
	public void enterCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		final Node node = model.findOrCreate(Label.label("Capturelist"), "text", arg.getText());
		onEnter(node);
		this.inCapturelist = true;
	}

	public void exitCapturelist(com.generator.generators.cpp.parser.CPP14Parser.CapturelistContext arg) {
		onExit();
		this.inCapturelist = false;
	}

	protected boolean inCapture = false;

	@Override
	public void enterCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Capture"), "text", arg.getText());
		onEnter(node);
		this.inCapture = true;
	}

	public void exitCapture(com.generator.generators.cpp.parser.CPP14Parser.CaptureContext arg) {
		onExit();
		this.inCapture = false;
	}

	protected boolean inSimplecapture = false;

	@Override
	public void enterSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Simplecapture"), "text", arg.getText());
		onEnter(node);
		this.inSimplecapture = true;
	}

	public void exitSimplecapture(com.generator.generators.cpp.parser.CPP14Parser.SimplecaptureContext arg) {
		onExit();
		this.inSimplecapture = false;
	}

	protected boolean inInitcapture = false;

	@Override
	public void enterInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		final Node node = model.findOrCreate(Label.label("Initcapture"), "text", arg.getText());
		onEnter(node);
		this.inInitcapture = true;
	}

	public void exitInitcapture(com.generator.generators.cpp.parser.CPP14Parser.InitcaptureContext arg) {
		onExit();
		this.inInitcapture = false;
	}

	protected boolean inLambdadeclarator = false;

	@Override
	public void enterLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Lambdadeclarator"), "text", arg.getText());
		onEnter(node);
		this.inLambdadeclarator = true;
	}

	public void exitLambdadeclarator(com.generator.generators.cpp.parser.CPP14Parser.LambdadeclaratorContext arg) {
		onExit();
		this.inLambdadeclarator = false;
	}

	protected boolean inPostfixexpression = false;

	@Override
	public void enterPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Postfixexpression"), "text", arg.getText());
		onEnter(node);
		this.inPostfixexpression = true;
	}

	public void exitPostfixexpression(com.generator.generators.cpp.parser.CPP14Parser.PostfixexpressionContext arg) {
		onExit();
		this.inPostfixexpression = false;
	}

	protected boolean inExpressionlist = false;

	@Override
	public void enterExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		final Node node = model.findOrCreate(Label.label("Expressionlist"), "text", arg.getText());
		onEnter(node);
		this.inExpressionlist = true;
	}

	public void exitExpressionlist(com.generator.generators.cpp.parser.CPP14Parser.ExpressionlistContext arg) {
		onExit();
		this.inExpressionlist = false;
	}

	protected boolean inPseudodestructorname = false;

	@Override
	public void enterPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		final Node node = model.findOrCreate(Label.label("Pseudodestructorname"), "text", arg.getText());
		onEnter(node);
		this.inPseudodestructorname = true;
	}

	public void exitPseudodestructorname(com.generator.generators.cpp.parser.CPP14Parser.PseudodestructornameContext arg) {
		onExit();
		this.inPseudodestructorname = false;
	}

	protected boolean inUnaryexpression = false;

	@Override
	public void enterUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Unaryexpression"), "text", arg.getText());
		onEnter(node);
		this.inUnaryexpression = true;
	}

	public void exitUnaryexpression(com.generator.generators.cpp.parser.CPP14Parser.UnaryexpressionContext arg) {
		onExit();
		this.inUnaryexpression = false;
	}

	protected boolean inUnaryoperator = false;

	@Override
	public void enterUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Unaryoperator"), "text", arg.getText());
		onEnter(node);
		this.inUnaryoperator = true;
	}

	public void exitUnaryoperator(com.generator.generators.cpp.parser.CPP14Parser.UnaryoperatorContext arg) {
		onExit();
		this.inUnaryoperator = false;
	}

	protected boolean inNewexpression = false;

	@Override
	public void enterNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Newexpression"), "text", arg.getText());
		onEnter(node);
		this.inNewexpression = true;
	}

	public void exitNewexpression(com.generator.generators.cpp.parser.CPP14Parser.NewexpressionContext arg) {
		onExit();
		this.inNewexpression = false;
	}

	protected boolean inNewplacement = false;

	@Override
	public void enterNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		final Node node = model.findOrCreate(Label.label("Newplacement"), "text", arg.getText());
		onEnter(node);
		this.inNewplacement = true;
	}

	public void exitNewplacement(com.generator.generators.cpp.parser.CPP14Parser.NewplacementContext arg) {
		onExit();
		this.inNewplacement = false;
	}

	protected boolean inNewtypeid = false;

	@Override
	public void enterNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		final Node node = model.findOrCreate(Label.label("Newtypeid"), "text", arg.getText());
		onEnter(node);
		this.inNewtypeid = true;
	}

	public void exitNewtypeid(com.generator.generators.cpp.parser.CPP14Parser.NewtypeidContext arg) {
		onExit();
		this.inNewtypeid = false;
	}

	protected boolean inNewdeclarator = false;

	@Override
	public void enterNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Newdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inNewdeclarator = true;
	}

	public void exitNewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NewdeclaratorContext arg) {
		onExit();
		this.inNewdeclarator = false;
	}

	protected boolean inNoptrnewdeclarator = false;

	@Override
	public void enterNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		final Node node = model.findOrCreate(Label.label("Noptrnewdeclarator"), "text", arg.getText());
		onEnter(node);
		this.inNoptrnewdeclarator = true;
	}

	public void exitNoptrnewdeclarator(com.generator.generators.cpp.parser.CPP14Parser.NoptrnewdeclaratorContext arg) {
		onExit();
		this.inNoptrnewdeclarator = false;
	}

	protected boolean inNewinitializer = false;

	@Override
	public void enterNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		final Node node = model.findOrCreate(Label.label("Newinitializer"), "text", arg.getText());
		onEnter(node);
		this.inNewinitializer = true;
	}

	public void exitNewinitializer(com.generator.generators.cpp.parser.CPP14Parser.NewinitializerContext arg) {
		onExit();
		this.inNewinitializer = false;
	}

	protected boolean inDeleteexpression = false;

	@Override
	public void enterDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Deleteexpression"), "text", arg.getText());
		onEnter(node);
		this.inDeleteexpression = true;
	}

	public void exitDeleteexpression(com.generator.generators.cpp.parser.CPP14Parser.DeleteexpressionContext arg) {
		onExit();
		this.inDeleteexpression = false;
	}

	protected boolean inNoexceptexpression = false;

	@Override
	public void enterNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Noexceptexpression"), "text", arg.getText());
		onEnter(node);
		this.inNoexceptexpression = true;
	}

	public void exitNoexceptexpression(com.generator.generators.cpp.parser.CPP14Parser.NoexceptexpressionContext arg) {
		onExit();
		this.inNoexceptexpression = false;
	}

	protected boolean inCastexpression = false;

	@Override
	public void enterCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Castexpression"), "text", arg.getText());
		onEnter(node);
		this.inCastexpression = true;
	}

	public void exitCastexpression(com.generator.generators.cpp.parser.CPP14Parser.CastexpressionContext arg) {
		onExit();
		this.inCastexpression = false;
	}

	protected boolean inPmexpression = false;

	@Override
	public void enterPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Pmexpression"), "text", arg.getText());
		onEnter(node);
		this.inPmexpression = true;
	}

	public void exitPmexpression(com.generator.generators.cpp.parser.CPP14Parser.PmexpressionContext arg) {
		onExit();
		this.inPmexpression = false;
	}

	protected boolean inMultiplicativeexpression = false;

	@Override
	public void enterMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Multiplicativeexpression"), "text", arg.getText());
		onEnter(node);
		this.inMultiplicativeexpression = true;
	}

	public void exitMultiplicativeexpression(com.generator.generators.cpp.parser.CPP14Parser.MultiplicativeexpressionContext arg) {
		onExit();
		this.inMultiplicativeexpression = false;
	}

	protected boolean inAdditiveexpression = false;

	@Override
	public void enterAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Additiveexpression"), "text", arg.getText());
		onEnter(node);
		this.inAdditiveexpression = true;
	}

	public void exitAdditiveexpression(com.generator.generators.cpp.parser.CPP14Parser.AdditiveexpressionContext arg) {
		onExit();
		this.inAdditiveexpression = false;
	}

	protected boolean inShiftexpression = false;

	@Override
	public void enterShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Shiftexpression"), "text", arg.getText());
		onEnter(node);
		this.inShiftexpression = true;
	}

	public void exitShiftexpression(com.generator.generators.cpp.parser.CPP14Parser.ShiftexpressionContext arg) {
		onExit();
		this.inShiftexpression = false;
	}

	protected boolean inRelationalexpression = false;

	@Override
	public void enterRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Relationalexpression"), "text", arg.getText());
		onEnter(node);
		this.inRelationalexpression = true;
	}

	public void exitRelationalexpression(com.generator.generators.cpp.parser.CPP14Parser.RelationalexpressionContext arg) {
		onExit();
		this.inRelationalexpression = false;
	}

	protected boolean inEqualityexpression = false;

	@Override
	public void enterEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Equalityexpression"), "text", arg.getText());
		onEnter(node);
		this.inEqualityexpression = true;
	}

	public void exitEqualityexpression(com.generator.generators.cpp.parser.CPP14Parser.EqualityexpressionContext arg) {
		onExit();
		this.inEqualityexpression = false;
	}

	protected boolean inAndexpression = false;

	@Override
	public void enterAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Andexpression"), "text", arg.getText());
		onEnter(node);
		this.inAndexpression = true;
	}

	public void exitAndexpression(com.generator.generators.cpp.parser.CPP14Parser.AndexpressionContext arg) {
		onExit();
		this.inAndexpression = false;
	}

	protected boolean inExclusiveorexpression = false;

	@Override
	public void enterExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Exclusiveorexpression"), "text", arg.getText());
		onEnter(node);
		this.inExclusiveorexpression = true;
	}

	public void exitExclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.ExclusiveorexpressionContext arg) {
		onExit();
		this.inExclusiveorexpression = false;
	}

	protected boolean inInclusiveorexpression = false;

	@Override
	public void enterInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Inclusiveorexpression"), "text", arg.getText());
		onEnter(node);
		this.inInclusiveorexpression = true;
	}

	public void exitInclusiveorexpression(com.generator.generators.cpp.parser.CPP14Parser.InclusiveorexpressionContext arg) {
		onExit();
		this.inInclusiveorexpression = false;
	}

	protected boolean inLogicalandexpression = false;

	@Override
	public void enterLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Logicalandexpression"), "text", arg.getText());
		onEnter(node);
		this.inLogicalandexpression = true;
	}

	public void exitLogicalandexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalandexpressionContext arg) {
		onExit();
		this.inLogicalandexpression = false;
	}

	protected boolean inLogicalorexpression = false;

	@Override
	public void enterLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Logicalorexpression"), "text", arg.getText());
		onEnter(node);
		this.inLogicalorexpression = true;
	}

	public void exitLogicalorexpression(com.generator.generators.cpp.parser.CPP14Parser.LogicalorexpressionContext arg) {
		onExit();
		this.inLogicalorexpression = false;
	}

	protected boolean inConditionalexpression = false;

	@Override
	public void enterConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Conditionalexpression"), "text", arg.getText());
		onEnter(node);
		this.inConditionalexpression = true;
	}

	public void exitConditionalexpression(com.generator.generators.cpp.parser.CPP14Parser.ConditionalexpressionContext arg) {
		onExit();
		this.inConditionalexpression = false;
	}

	protected boolean inAssignmentexpression = false;

	@Override
	public void enterAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Assignmentexpression"), "text", arg.getText());
		onEnter(node);
		this.inAssignmentexpression = true;
	}

	public void exitAssignmentexpression(com.generator.generators.cpp.parser.CPP14Parser.AssignmentexpressionContext arg) {
		onExit();
		this.inAssignmentexpression = false;
	}

	protected boolean inAssignmentoperator = false;

	@Override
	public void enterAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		final Node node = model.findOrCreate(Label.label("Assignmentoperator"), "text", arg.getText());
		onEnter(node);
		this.inAssignmentoperator = true;
	}

	public void exitAssignmentoperator(com.generator.generators.cpp.parser.CPP14Parser.AssignmentoperatorContext arg) {
		onExit();
		this.inAssignmentoperator = false;
	}

	protected boolean inExpression = false;

	@Override
	public void enterExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText());
		onEnter(node);
		this.inExpression = true;
	}

	public void exitExpression(com.generator.generators.cpp.parser.CPP14Parser.ExpressionContext arg) {
		onExit();
		this.inExpression = false;
	}

	protected boolean inConstantexpression = false;

	@Override
	public void enterConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		final Node node = model.findOrCreate(Label.label("Constantexpression"), "text", arg.getText());
		onEnter(node);
		this.inConstantexpression = true;
	}

	public void exitConstantexpression(com.generator.generators.cpp.parser.CPP14Parser.ConstantexpressionContext arg) {
		onExit();
		this.inConstantexpression = false;
	}

	protected boolean inStatement = false;

	@Override
	public void enterStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Statement"), "text", arg.getText());
		onEnter(node);
		this.inStatement = true;
	}

	public void exitStatement(com.generator.generators.cpp.parser.CPP14Parser.StatementContext arg) {
		onExit();
		this.inStatement = false;
	}

	protected boolean inLabeledstatement = false;

	@Override
	public void enterLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Labeledstatement"), "text", arg.getText());
		onEnter(node);
		this.inLabeledstatement = true;
	}

	public void exitLabeledstatement(com.generator.generators.cpp.parser.CPP14Parser.LabeledstatementContext arg) {
		onExit();
		this.inLabeledstatement = false;
	}

	protected boolean inExpressionstatement = false;

	@Override
	public void enterExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Expressionstatement"), "text", arg.getText());
		onEnter(node);
		this.inExpressionstatement = true;
	}

	public void exitExpressionstatement(com.generator.generators.cpp.parser.CPP14Parser.ExpressionstatementContext arg) {
		onExit();
		this.inExpressionstatement = false;
	}

	protected boolean inCompoundstatement = false;

	@Override
	public void enterCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Compoundstatement"), "text", arg.getText());
		onEnter(node);
		this.inCompoundstatement = true;
	}

	public void exitCompoundstatement(com.generator.generators.cpp.parser.CPP14Parser.CompoundstatementContext arg) {
		onExit();
		this.inCompoundstatement = false;
	}

	protected boolean inStatementseq = false;

	@Override
	public void enterStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		final Node node = model.findOrCreate(Label.label("Statementseq"), "text", arg.getText());
		onEnter(node);
		this.inStatementseq = true;
	}

	public void exitStatementseq(com.generator.generators.cpp.parser.CPP14Parser.StatementseqContext arg) {
		onExit();
		this.inStatementseq = false;
	}

	protected boolean inSelectionstatement = false;

	@Override
	public void enterSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		final Node node = model.findOrCreate(Label.label("Selectionstatement"), "text", arg.getText());
		onEnter(node);
		this.inSelectionstatement = true;
	}

	public void exitSelectionstatement(com.generator.generators.cpp.parser.CPP14Parser.SelectionstatementContext arg) {
		onExit();
		this.inSelectionstatement = false;
	}

	protected boolean inCondition = false;

	@Override
	public void enterCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		final Node node = model.findOrCreate(Label.label("Condition"), "text", arg.getText());
		onEnter(node);
		this.inCondition = true;
	}

	public void exitCondition(com.generator.generators.cpp.parser.CPP14Parser.ConditionContext arg) {
		onExit();
		this.inCondition = false;
	}

	protected boolean inDeclaration = false;

	@Override
	public void enterDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		final Node node = model.findOrCreate(Label.label("Declaration"), "text", arg.getText());
		onEnter(node);
		this.inDeclaration = true;
	}

	public void exitDeclaration(com.generator.generators.cpp.parser.CPP14Parser.DeclarationContext arg) {
		onExit();
		this.inDeclaration = false;
	}

}