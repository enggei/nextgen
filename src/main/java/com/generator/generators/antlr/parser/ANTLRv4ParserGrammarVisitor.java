package com.generator.generators.antlr.parser;
import com.generator.generators.antlr.bnf.AntlrGrammarModel;
import com.generator.generators.antlr.bnf.AntlrGrammarSymbol;
import com.generator.util.NeoUtil;
import org.neo4j.graphdb.Node;
import java.util.Stack;

public class ANTLRv4ParserGrammarVisitor extends ANTLRv4ParserDomainVisitor { 

	protected final Stack<AntlrGrammarSymbol> symbolStack = new Stack<>();

	public final AntlrGrammarModel grammarModel;

	public ANTLRv4ParserGrammarVisitor(AntlrGrammarModel grammarModel) {
		this.grammarModel = grammarModel;
	}

	
	@Override
	public void visitGrammarSpec(Node node) { 
		final ANTLRv4ParserDomain.GrammarSpec symbol = grammarModel.newGrammarSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitGrammarSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitGrammarType(Node node) { 
		final ANTLRv4ParserDomain.GrammarType symbol = grammarModel.newGrammarType(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitGrammarType(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitIdentifier(Node node) { 
		final ANTLRv4ParserDomain.Identifier symbol = grammarModel.newIdentifier(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitIdentifier(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitPrequelConstruct(Node node) { 
		final ANTLRv4ParserDomain.PrequelConstruct symbol = grammarModel.newPrequelConstruct(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitPrequelConstruct(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitOptionsSpec(Node node) { 
		final ANTLRv4ParserDomain.OptionsSpec symbol = grammarModel.newOptionsSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitOptionsSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitOption(Node node) { 
		final ANTLRv4ParserDomain.Option symbol = grammarModel.newOption(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitOption(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitOptionValue(Node node) { 
		final ANTLRv4ParserDomain.OptionValue symbol = grammarModel.newOptionValue(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitOptionValue(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitRules(Node node) { 
		final ANTLRv4ParserDomain.Rules symbol = grammarModel.newRules(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitRules(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitRuleSpec(Node node) { 
		final ANTLRv4ParserDomain.RuleSpec symbol = grammarModel.newRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitRuleSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitParserRuleSpec(Node node) { 
		final ANTLRv4ParserDomain.ParserRuleSpec symbol = grammarModel.newParserRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitParserRuleSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitRuleBlock(Node node) { 
		final ANTLRv4ParserDomain.RuleBlock symbol = grammarModel.newRuleBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitRuleBlock(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitRuleAltList(Node node) { 
		final ANTLRv4ParserDomain.RuleAltList symbol = grammarModel.newRuleAltList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitRuleAltList(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLabeledAlt(Node node) { 
		final ANTLRv4ParserDomain.LabeledAlt symbol = grammarModel.newLabeledAlt(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLabeledAlt(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitAlternative(Node node) { 
		final ANTLRv4ParserDomain.Alternative symbol = grammarModel.newAlternative(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitAlternative(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitElement(Node node) { 
		final ANTLRv4ParserDomain.Element symbol = grammarModel.newElement(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitElement(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitAtom(Node node) { 
		final ANTLRv4ParserDomain.Atom symbol = grammarModel.newAtom(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitAtom(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitTerminal(Node node) { 
		final ANTLRv4ParserDomain.Terminal symbol = grammarModel.newTerminal(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitTerminal(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitEbnfSuffix(Node node) { 
		final ANTLRv4ParserDomain.EbnfSuffix symbol = grammarModel.newEbnfSuffix(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitEbnfSuffix(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitRuleref(Node node) { 
		final ANTLRv4ParserDomain.Ruleref symbol = grammarModel.newRuleref(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitRuleref(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitExceptionGroup(Node node) { 
		final ANTLRv4ParserDomain.ExceptionGroup symbol = grammarModel.newExceptionGroup(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitExceptionGroup(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitEbnf(Node node) { 
		final ANTLRv4ParserDomain.Ebnf symbol = grammarModel.newEbnf(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitEbnf(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitBlock(Node node) { 
		final ANTLRv4ParserDomain.Block symbol = grammarModel.newBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitBlock(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitAltList(Node node) { 
		final ANTLRv4ParserDomain.AltList symbol = grammarModel.newAltList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitAltList(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitBlockSuffix(Node node) { 
		final ANTLRv4ParserDomain.BlockSuffix symbol = grammarModel.newBlockSuffix(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitBlockSuffix(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitDelegateGrammars(Node node) { 
		final ANTLRv4ParserDomain.DelegateGrammars symbol = grammarModel.newDelegateGrammars(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitDelegateGrammars(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitDelegateGrammar(Node node) { 
		final ANTLRv4ParserDomain.DelegateGrammar symbol = grammarModel.newDelegateGrammar(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitDelegateGrammar(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitTokensSpec(Node node) { 
		final ANTLRv4ParserDomain.TokensSpec symbol = grammarModel.newTokensSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitTokensSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitIdList(Node node) { 
		final ANTLRv4ParserDomain.IdList symbol = grammarModel.newIdList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitIdList(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitChannelsSpec(Node node) { 
		final ANTLRv4ParserDomain.ChannelsSpec symbol = grammarModel.newChannelsSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitChannelsSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerRuleSpec(Node node) { 
		final ANTLRv4ParserDomain.LexerRuleSpec symbol = grammarModel.newLexerRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerRuleSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerRuleBlock(Node node) { 
		final ANTLRv4ParserDomain.LexerRuleBlock symbol = grammarModel.newLexerRuleBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerRuleBlock(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerAltList(Node node) { 
		final ANTLRv4ParserDomain.LexerAltList symbol = grammarModel.newLexerAltList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerAltList(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerAlt(Node node) { 
		final ANTLRv4ParserDomain.LexerAlt symbol = grammarModel.newLexerAlt(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerAlt(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerElements(Node node) { 
		final ANTLRv4ParserDomain.LexerElements symbol = grammarModel.newLexerElements(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerElements(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerElement(Node node) { 
		final ANTLRv4ParserDomain.LexerElement symbol = grammarModel.newLexerElement(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerElement(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerAtom(Node node) { 
		final ANTLRv4ParserDomain.LexerAtom symbol = grammarModel.newLexerAtom(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerAtom(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerCommands(Node node) { 
		final ANTLRv4ParserDomain.LexerCommands symbol = grammarModel.newLexerCommands(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerCommands(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerCommand(Node node) { 
		final ANTLRv4ParserDomain.LexerCommand symbol = grammarModel.newLexerCommand(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerCommand(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerCommandName(Node node) { 
		final ANTLRv4ParserDomain.LexerCommandName symbol = grammarModel.newLexerCommandName(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerCommandName(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerCommandExpr(Node node) { 
		final ANTLRv4ParserDomain.LexerCommandExpr symbol = grammarModel.newLexerCommandExpr(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerCommandExpr(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitActionBlock(Node node) { 
		final ANTLRv4ParserDomain.ActionBlock symbol = grammarModel.newActionBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitActionBlock(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitModeSpec(Node node) { 
		final ANTLRv4ParserDomain.ModeSpec symbol = grammarModel.newModeSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitModeSpec(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitLexerBlock(Node node) { 
		final ANTLRv4ParserDomain.LexerBlock symbol = grammarModel.newLexerBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitLexerBlock(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitNotSet(Node node) { 
		final ANTLRv4ParserDomain.NotSet symbol = grammarModel.newNotSet(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitNotSet(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitSetElement(Node node) { 
		final ANTLRv4ParserDomain.SetElement symbol = grammarModel.newSetElement(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitSetElement(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
	
	@Override
	public void visitCharacterRange(Node node) { 
		final ANTLRv4ParserDomain.CharacterRange symbol = grammarModel.newCharacterRange(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
 		if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
 		symbolStack.push(symbol);
 		super.visitCharacterRange(node);
 		if (symbolStack.size() > 1) symbolStack.pop();
	} 
}