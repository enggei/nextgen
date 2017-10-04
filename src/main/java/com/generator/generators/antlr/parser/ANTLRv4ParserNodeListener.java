package com.generator.generators.antlr.parser;

public class ANTLRv4ParserNodeListener extends ANTLRv4ParserBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final String endToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken, String endToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
			this.endToken = endToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public ANTLRv4ParserNodeListener() {
		this(false);
	}

	public ANTLRv4ParserNodeListener(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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

	protected java.util.Stack<Boolean> inRuleModifier = new java.util.Stack<>();

	@Override
	public void enterRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		onEnter(new Node("RuleModifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleModifier.push(true);
	}

	public void exitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		onExit();
		this.inRuleModifier.pop();
	}

	public boolean inRuleModifier() {
      return !inRuleModifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRuleBlock = new java.util.Stack<>();

	@Override
	public void enterRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		onEnter(new Node("RuleBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleBlock.push(true);
	}

	public void exitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		onExit();
		this.inRuleBlock.pop();
	}

	public boolean inRuleBlock() {
      return !inRuleBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRuleAltList = new java.util.Stack<>();

	@Override
	public void enterRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		onEnter(new Node("RuleAltList", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleAltList.push(true);
	}

	public void exitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		onExit();
		this.inRuleAltList.pop();
	}

	public boolean inRuleAltList() {
      return !inRuleAltList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabeledAlt = new java.util.Stack<>();

	@Override
	public void enterLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		onEnter(new Node("LabeledAlt", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLabeledAlt.push(true);
	}

	public void exitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		onExit();
		this.inLabeledAlt.pop();
	}

	public boolean inLabeledAlt() {
      return !inLabeledAlt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerRuleSpec = new java.util.Stack<>();

	@Override
	public void enterLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		onEnter(new Node("LexerRuleSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerRuleSpec.push(true);
	}

	public void exitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		onExit();
		this.inLexerRuleSpec.pop();
	}

	public boolean inLexerRuleSpec() {
      return !inLexerRuleSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerRuleBlock = new java.util.Stack<>();

	@Override
	public void enterLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		onEnter(new Node("LexerRuleBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerRuleBlock.push(true);
	}

	public void exitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		onExit();
		this.inLexerRuleBlock.pop();
	}

	public boolean inLexerRuleBlock() {
      return !inLexerRuleBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerAltList = new java.util.Stack<>();

	@Override
	public void enterLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		onEnter(new Node("LexerAltList", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerAltList.push(true);
	}

	public void exitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		onExit();
		this.inLexerAltList.pop();
	}

	public boolean inLexerAltList() {
      return !inLexerAltList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerAlt = new java.util.Stack<>();

	@Override
	public void enterLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		onEnter(new Node("LexerAlt", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerAlt.push(true);
	}

	public void exitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		onExit();
		this.inLexerAlt.pop();
	}

	public boolean inLexerAlt() {
      return !inLexerAlt.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerElements = new java.util.Stack<>();

	@Override
	public void enterLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		onEnter(new Node("LexerElements", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerElements.push(true);
	}

	public void exitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		onExit();
		this.inLexerElements.pop();
	}

	public boolean inLexerElements() {
      return !inLexerElements.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerElement = new java.util.Stack<>();

	@Override
	public void enterLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		onEnter(new Node("LexerElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerElement.push(true);
	}

	public void exitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		onExit();
		this.inLexerElement.pop();
	}

	public boolean inLexerElement() {
      return !inLexerElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabeledLexerElement = new java.util.Stack<>();

	@Override
	public void enterLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		onEnter(new Node("LabeledLexerElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLabeledLexerElement.push(true);
	}

	public void exitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		onExit();
		this.inLabeledLexerElement.pop();
	}

	public boolean inLabeledLexerElement() {
      return !inLabeledLexerElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerCommands = new java.util.Stack<>();

	@Override
	public void enterLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		onEnter(new Node("LexerCommands", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerCommands.push(true);
	}

	public void exitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		onExit();
		this.inLexerCommands.pop();
	}

	public boolean inLexerCommands() {
      return !inLexerCommands.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerCommand = new java.util.Stack<>();

	@Override
	public void enterLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		onEnter(new Node("LexerCommand", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerCommand.push(true);
	}

	public void exitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		onExit();
		this.inLexerCommand.pop();
	}

	public boolean inLexerCommand() {
      return !inLexerCommand.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerCommandName = new java.util.Stack<>();

	@Override
	public void enterLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		onEnter(new Node("LexerCommandName", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerCommandName.push(true);
	}

	public void exitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		onExit();
		this.inLexerCommandName.pop();
	}

	public boolean inLexerCommandName() {
      return !inLexerCommandName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerCommandExpr = new java.util.Stack<>();

	@Override
	public void enterLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		onEnter(new Node("LexerCommandExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerCommandExpr.push(true);
	}

	public void exitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		onExit();
		this.inLexerCommandExpr.pop();
	}

	public boolean inLexerCommandExpr() {
      return !inLexerCommandExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAltList = new java.util.Stack<>();

	@Override
	public void enterAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		onEnter(new Node("AltList", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inAltList.push(true);
	}

	public void exitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		onExit();
		this.inAltList.pop();
	}

	public boolean inAltList() {
      return !inAltList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAlternative = new java.util.Stack<>();

	@Override
	public void enterAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		onEnter(new Node("Alternative", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inAlternative.push(true);
	}

	public void exitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		onExit();
		this.inAlternative.pop();
	}

	public boolean inAlternative() {
      return !inAlternative.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElement = new java.util.Stack<>();

	@Override
	public void enterElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		onEnter(new Node("Element", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inElement.push(true);
	}

	public void exitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		onExit();
		this.inElement.pop();
	}

	public boolean inElement() {
      return !inElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLabeledElement = new java.util.Stack<>();

	@Override
	public void enterLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		onEnter(new Node("LabeledElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLabeledElement.push(true);
	}

	public void exitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		onExit();
		this.inLabeledElement.pop();
	}

	public boolean inLabeledElement() {
      return !inLabeledElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEbnf = new java.util.Stack<>();

	@Override
	public void enterEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		onEnter(new Node("Ebnf", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inEbnf.push(true);
	}

	public void exitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		onExit();
		this.inEbnf.pop();
	}

	public boolean inEbnf() {
      return !inEbnf.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlockSuffix = new java.util.Stack<>();

	@Override
	public void enterBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		onEnter(new Node("BlockSuffix", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBlockSuffix.push(true);
	}

	public void exitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		onExit();
		this.inBlockSuffix.pop();
	}

	public boolean inBlockSuffix() {
      return !inBlockSuffix.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inEbnfSuffix = new java.util.Stack<>();

	@Override
	public void enterEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		onEnter(new Node("EbnfSuffix", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inEbnfSuffix.push(true);
	}

	public void exitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		onExit();
		this.inEbnfSuffix.pop();
	}

	public boolean inEbnfSuffix() {
      return !inEbnfSuffix.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerAtom = new java.util.Stack<>();

	@Override
	public void enterLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		onEnter(new Node("LexerAtom", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerAtom.push(true);
	}

	public void exitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		onExit();
		this.inLexerAtom.pop();
	}

	public boolean inLexerAtom() {
      return !inLexerAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAtom = new java.util.Stack<>();

	@Override
	public void enterAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		onEnter(new Node("Atom", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inAtom.push(true);
	}

	public void exitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		onExit();
		this.inAtom.pop();
	}

	public boolean inAtom() {
      return !inAtom.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNotSet = new java.util.Stack<>();

	@Override
	public void enterNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		onEnter(new Node("NotSet", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inNotSet.push(true);
	}

	public void exitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		onExit();
		this.inNotSet.pop();
	}

	public boolean inNotSet() {
      return !inNotSet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlockSet = new java.util.Stack<>();

	@Override
	public void enterBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		onEnter(new Node("BlockSet", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBlockSet.push(true);
	}

	public void exitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		onExit();
		this.inBlockSet.pop();
	}

	public boolean inBlockSet() {
      return !inBlockSet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSetElement = new java.util.Stack<>();

	@Override
	public void enterSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		onEnter(new Node("SetElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSetElement.push(true);
	}

	public void exitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		onExit();
		this.inSetElement.pop();
	}

	public boolean inSetElement() {
      return !inSetElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRuleref = new java.util.Stack<>();

	@Override
	public void enterRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		onEnter(new Node("Ruleref", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleref.push(true);
	}

	public void exitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		onExit();
		this.inRuleref.pop();
	}

	public boolean inRuleref() {
      return !inRuleref.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCharacterRange = new java.util.Stack<>();

	@Override
	public void enterCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		onEnter(new Node("CharacterRange", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCharacterRange.push(true);
	}

	public void exitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		onExit();
		this.inCharacterRange.pop();
	}

	public boolean inCharacterRange() {
      return !inCharacterRange.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTerminal = new java.util.Stack<>();

	@Override
	public void enterTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		onEnter(new Node("Terminal", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inTerminal.push(true);
	}

	public void exitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		onExit();
		this.inTerminal.pop();
	}

	public boolean inTerminal() {
      return !inTerminal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementOptions = new java.util.Stack<>();

	@Override
	public void enterElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		onEnter(new Node("ElementOptions", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inElementOptions.push(true);
	}

	public void exitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		onExit();
		this.inElementOptions.pop();
	}

	public boolean inElementOptions() {
      return !inElementOptions.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementOption = new java.util.Stack<>();

	@Override
	public void enterElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		onEnter(new Node("ElementOption", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inElementOption.push(true);
	}

	public void exitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		onExit();
		this.inElementOption.pop();
	}

	public boolean inElementOption() {
      return !inElementOption.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdentifier = new java.util.Stack<>();

	@Override
	public void enterIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		onEnter(new Node("Identifier", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inIdentifier.push(true);
	}

	public void exitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		onExit();
		this.inIdentifier.pop();
	}

	public boolean inIdentifier() {
      return !inIdentifier.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGrammarSpec = new java.util.Stack<>();

	@Override
	public void enterGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		onEnter(new Node("GrammarSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGrammarSpec.push(true);
	}

	public void exitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		onExit();
		this.inGrammarSpec.pop();
	}

	public boolean inGrammarSpec() {
      return !inGrammarSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrequelConstruct = new java.util.Stack<>();

	@Override
	public void enterPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		onEnter(new Node("PrequelConstruct", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inPrequelConstruct.push(true);
	}

	public void exitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		onExit();
		this.inPrequelConstruct.pop();
	}

	public boolean inPrequelConstruct() {
      return !inPrequelConstruct.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGrammarType = new java.util.Stack<>();

	@Override
	public void enterGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		onEnter(new Node("GrammarType", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGrammarType.push(true);
	}

	public void exitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		onExit();
		this.inGrammarType.pop();
	}

	public boolean inGrammarType() {
      return !inGrammarType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOptionsSpec = new java.util.Stack<>();

	@Override
	public void enterOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		onEnter(new Node("OptionsSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inOptionsSpec.push(true);
	}

	public void exitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		onExit();
		this.inOptionsSpec.pop();
	}

	public boolean inOptionsSpec() {
      return !inOptionsSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOption = new java.util.Stack<>();

	@Override
	public void enterOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		onEnter(new Node("Option", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inOption.push(true);
	}

	public void exitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		onExit();
		this.inOption.pop();
	}

	public boolean inOption() {
      return !inOption.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOptionValue = new java.util.Stack<>();

	@Override
	public void enterOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		onEnter(new Node("OptionValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inOptionValue.push(true);
	}

	public void exitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		onExit();
		this.inOptionValue.pop();
	}

	public boolean inOptionValue() {
      return !inOptionValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDelegateGrammars = new java.util.Stack<>();

	@Override
	public void enterDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		onEnter(new Node("DelegateGrammars", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inDelegateGrammars.push(true);
	}

	public void exitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		onExit();
		this.inDelegateGrammars.pop();
	}

	public boolean inDelegateGrammars() {
      return !inDelegateGrammars.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLexerBlock = new java.util.Stack<>();

	@Override
	public void enterLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		onEnter(new Node("LexerBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLexerBlock.push(true);
	}

	public void exitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		onExit();
		this.inLexerBlock.pop();
	}

	public boolean inLexerBlock() {
      return !inLexerBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDelegateGrammar = new java.util.Stack<>();

	@Override
	public void enterDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		onEnter(new Node("DelegateGrammar", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inDelegateGrammar.push(true);
	}

	public void exitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		onExit();
		this.inDelegateGrammar.pop();
	}

	public boolean inDelegateGrammar() {
      return !inDelegateGrammar.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTokensSpec = new java.util.Stack<>();

	@Override
	public void enterTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		onEnter(new Node("TokensSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inTokensSpec.push(true);
	}

	public void exitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		onExit();
		this.inTokensSpec.pop();
	}

	public boolean inTokensSpec() {
      return !inTokensSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inChannelsSpec = new java.util.Stack<>();

	@Override
	public void enterChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		onEnter(new Node("ChannelsSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inChannelsSpec.push(true);
	}

	public void exitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		onExit();
		this.inChannelsSpec.pop();
	}

	public boolean inChannelsSpec() {
      return !inChannelsSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdList = new java.util.Stack<>();

	@Override
	public void enterIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		onEnter(new Node("IdList", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inIdList.push(true);
	}

	public void exitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		onExit();
		this.inIdList.pop();
	}

	public boolean inIdList() {
      return !inIdList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAction = new java.util.Stack<>();

	@Override
	public void enterAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		onEnter(new Node("Action", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inAction.push(true);
	}

	public void exitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		onExit();
		this.inAction.pop();
	}

	public boolean inAction() {
      return !inAction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inActionScopeName = new java.util.Stack<>();

	@Override
	public void enterActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		onEnter(new Node("ActionScopeName", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inActionScopeName.push(true);
	}

	public void exitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		onExit();
		this.inActionScopeName.pop();
	}

	public boolean inActionScopeName() {
      return !inActionScopeName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inActionBlock = new java.util.Stack<>();

	@Override
	public void enterActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		onEnter(new Node("ActionBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inActionBlock.push(true);
	}

	public void exitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		onExit();
		this.inActionBlock.pop();
	}

	public boolean inActionBlock() {
      return !inActionBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgActionBlock = new java.util.Stack<>();

	@Override
	public void enterArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		onEnter(new Node("ArgActionBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inArgActionBlock.push(true);
	}

	public void exitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		onExit();
		this.inArgActionBlock.pop();
	}

	public boolean inArgActionBlock() {
      return !inArgActionBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inModeSpec = new java.util.Stack<>();

	@Override
	public void enterModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		onEnter(new Node("ModeSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inModeSpec.push(true);
	}

	public void exitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		onExit();
		this.inModeSpec.pop();
	}

	public boolean inModeSpec() {
      return !inModeSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRules = new java.util.Stack<>();

	@Override
	public void enterRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		onEnter(new Node("Rules", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRules.push(true);
	}

	public void exitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		onExit();
		this.inRules.pop();
	}

	public boolean inRules() {
      return !inRules.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRuleSpec = new java.util.Stack<>();

	@Override
	public void enterRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		onEnter(new Node("RuleSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleSpec.push(true);
	}

	public void exitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		onExit();
		this.inRuleSpec.pop();
	}

	public boolean inRuleSpec() {
      return !inRuleSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inParserRuleSpec = new java.util.Stack<>();

	@Override
	public void enterParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		onEnter(new Node("ParserRuleSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inParserRuleSpec.push(true);
	}

	public void exitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		onExit();
		this.inParserRuleSpec.pop();
	}

	public boolean inParserRuleSpec() {
      return !inParserRuleSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExceptionGroup = new java.util.Stack<>();

	@Override
	public void enterExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		onEnter(new Node("ExceptionGroup", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inExceptionGroup.push(true);
	}

	public void exitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		onExit();
		this.inExceptionGroup.pop();
	}

	public boolean inExceptionGroup() {
      return !inExceptionGroup.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExceptionHandler = new java.util.Stack<>();

	@Override
	public void enterExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		onEnter(new Node("ExceptionHandler", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inExceptionHandler.push(true);
	}

	public void exitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		onExit();
		this.inExceptionHandler.pop();
	}

	public boolean inExceptionHandler() {
      return !inExceptionHandler.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFinallyClause = new java.util.Stack<>();

	@Override
	public void enterFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		onEnter(new Node("FinallyClause", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFinallyClause.push(true);
	}

	public void exitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		onExit();
		this.inFinallyClause.pop();
	}

	public boolean inFinallyClause() {
      return !inFinallyClause.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRulePrequel = new java.util.Stack<>();

	@Override
	public void enterRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		onEnter(new Node("RulePrequel", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRulePrequel.push(true);
	}

	public void exitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		onExit();
		this.inRulePrequel.pop();
	}

	public boolean inRulePrequel() {
      return !inRulePrequel.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRuleReturns = new java.util.Stack<>();

	@Override
	public void enterRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		onEnter(new Node("RuleReturns", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleReturns.push(true);
	}

	public void exitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		onExit();
		this.inRuleReturns.pop();
	}

	public boolean inRuleReturns() {
      return !inRuleReturns.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inThrowsSpec = new java.util.Stack<>();

	@Override
	public void enterThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		onEnter(new Node("ThrowsSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inThrowsSpec.push(true);
	}

	public void exitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		onExit();
		this.inThrowsSpec.pop();
	}

	public boolean inThrowsSpec() {
      return !inThrowsSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inLocalsSpec = new java.util.Stack<>();

	@Override
	public void enterLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		onEnter(new Node("LocalsSpec", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inLocalsSpec.push(true);
	}

	public void exitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		onExit();
		this.inLocalsSpec.pop();
	}

	public boolean inLocalsSpec() {
      return !inLocalsSpec.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRuleAction = new java.util.Stack<>();

	@Override
	public void enterRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		onEnter(new Node("RuleAction", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleAction.push(true);
	}

	public void exitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		onExit();
		this.inRuleAction.pop();
	}

	public boolean inRuleAction() {
      return !inRuleAction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRuleModifiers = new java.util.Stack<>();

	@Override
	public void enterRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		onEnter(new Node("RuleModifiers", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inRuleModifiers.push(true);
	}

	public void exitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		onExit();
		this.inRuleModifiers.pop();
	}

	public boolean inRuleModifiers() {
      return !inRuleModifiers.isEmpty(); 
   }

}