package com.generator.generators.antlr.parser;

import com.generator.generators.antlr.AntlrGroup;
import com.generator.util.NeoUtil;

import java.util.ArrayList;
import java.util.Stack;
import java.util.UUID;

public class ANTLRv4ParserDomain { 

	protected static final java.util.Random random = new java.util.Random(System.currentTimeMillis());

	protected final Stack<AntlrGrammarNode> grammarStack = new Stack<>();

   public GrammarSpec getGrammarSpec() {
		return grammarStack.isEmpty() ? null : (GrammarSpec) grammarStack.peek();
	}

	public static abstract class ANTLRv4Visitor {

		public void visit(AntlrGrammarNode node) {
			switch(node.type) {
				case "GrammarSpec": 
					visitGrammarSpec((GrammarSpec) node); 
					break;
				case "GrammarType": 
					visitGrammarType((GrammarType) node); 
					break;
				case "Identifier": 
					visitIdentifier((Identifier) node); 
					break;
				case "PrequelConstruct": 
					visitPrequelConstruct((PrequelConstruct) node); 
					break;
				case "OptionsSpec": 
					visitOptionsSpec((OptionsSpec) node); 
					break;
				case "Option": 
					visitOption((Option) node); 
					break;
				case "OptionValue": 
					visitOptionValue((OptionValue) node); 
					break;
				case "Rules": 
					visitRules((Rules) node); 
					break;
				case "RuleSpec": 
					visitRuleSpec((RuleSpec) node); 
					break;
				case "ParserRuleSpec": 
					visitParserRuleSpec((ParserRuleSpec) node); 
					break;
				case "RuleBlock": 
					visitRuleBlock((RuleBlock) node); 
					break;
				case "RuleAltList": 
					visitRuleAltList((RuleAltList) node); 
					break;
				case "LabeledAlt": 
					visitLabeledAlt((LabeledAlt) node); 
					break;
				case "Alternative": 
					visitAlternative((Alternative) node); 
					break;
				case "Element": 
					visitElement((Element) node); 
					break;
				case "Atom": 
					visitAtom((Atom) node); 
					break;
				case "Terminal": 
					visitTerminal((Terminal) node); 
					break;
				case "EbnfSuffix": 
					visitEbnfSuffix((EbnfSuffix) node); 
					break;
				case "Ruleref": 
					visitRuleref((Ruleref) node); 
					break;
				case "ExceptionGroup": 
					visitExceptionGroup((ExceptionGroup) node); 
					break;
				case "Ebnf": 
					visitEbnf((Ebnf) node); 
					break;
				case "Block": 
					visitBlock((Block) node); 
					break;
				case "AltList": 
					visitAltList((AltList) node); 
					break;
				case "BlockSuffix": 
					visitBlockSuffix((BlockSuffix) node); 
					break;
				case "DelegateGrammars": 
					visitDelegateGrammars((DelegateGrammars) node); 
					break;
				case "DelegateGrammar": 
					visitDelegateGrammar((DelegateGrammar) node); 
					break;
				case "TokensSpec": 
					visitTokensSpec((TokensSpec) node); 
					break;
				case "IdList": 
					visitIdList((IdList) node); 
					break;
				case "ChannelsSpec": 
					visitChannelsSpec((ChannelsSpec) node); 
					break;
				case "LexerRuleSpec": 
					visitLexerRuleSpec((LexerRuleSpec) node); 
					break;
				case "LexerRuleBlock": 
					visitLexerRuleBlock((LexerRuleBlock) node); 
					break;
				case "LexerAltList": 
					visitLexerAltList((LexerAltList) node); 
					break;
				case "LexerAlt": 
					visitLexerAlt((LexerAlt) node); 
					break;
				case "LexerElements": 
					visitLexerElements((LexerElements) node); 
					break;
				case "LexerElement": 
					visitLexerElement((LexerElement) node); 
					break;
				case "LexerAtom": 
					visitLexerAtom((LexerAtom) node); 
					break;
				case "LexerCommands": 
					visitLexerCommands((LexerCommands) node); 
					break;
				case "LexerCommand": 
					visitLexerCommand((LexerCommand) node); 
					break;
				case "LexerCommandName": 
					visitLexerCommandName((LexerCommandName) node); 
					break;
				case "LexerCommandExpr": 
					visitLexerCommandExpr((LexerCommandExpr) node); 
					break;
				case "ActionBlock": 
					visitActionBlock((ActionBlock) node); 
					break;
				case "ModeSpec": 
					visitModeSpec((ModeSpec) node); 
					break;
				case "LexerBlock": 
					visitLexerBlock((LexerBlock) node); 
					break;
				case "NotSet": 
					visitNotSet((NotSet) node); 
					break;
				case "SetElement": 
					visitSetElement((SetElement) node); 
					break;
				case "CharacterRange": 
					visitCharacterRange((CharacterRange) node); 
					break;
			}
		}

		public void visitGrammarSpec(GrammarSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitGrammarType(GrammarType node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitIdentifier(Identifier node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitPrequelConstruct(PrequelConstruct node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitOptionsSpec(OptionsSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitOption(Option node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitOptionValue(OptionValue node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitRules(Rules node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitRuleSpec(RuleSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitParserRuleSpec(ParserRuleSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitRuleBlock(RuleBlock node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitRuleAltList(RuleAltList node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLabeledAlt(LabeledAlt node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitAlternative(Alternative node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitElement(Element node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitAtom(Atom node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitTerminal(Terminal node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitEbnfSuffix(EbnfSuffix node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitRuleref(Ruleref node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitExceptionGroup(ExceptionGroup node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitEbnf(Ebnf node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitBlock(Block node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitAltList(AltList node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitBlockSuffix(BlockSuffix node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitDelegateGrammars(DelegateGrammars node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitDelegateGrammar(DelegateGrammar node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitTokensSpec(TokensSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitIdList(IdList node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitChannelsSpec(ChannelsSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerRuleSpec(LexerRuleSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerRuleBlock(LexerRuleBlock node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerAltList(LexerAltList node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerAlt(LexerAlt node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerElements(LexerElements node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerElement(LexerElement node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerAtom(LexerAtom node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerCommands(LexerCommands node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerCommand(LexerCommand node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerCommandName(LexerCommandName node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerCommandExpr(LexerCommandExpr node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitActionBlock(ActionBlock node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitModeSpec(ModeSpec node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitLexerBlock(LexerBlock node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitNotSet(NotSet node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitSetElement(SetElement node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}

		public void visitCharacterRange(CharacterRange node) {
			for (AntlrGrammarNode child : node.children) visit(child);
		}
	}

	public void onNode(AntlrGrammarNode grammarNode) { 
	}

	protected ANTLRv4ParserDomainVisitor getANTLRv4ParserDomainVisitor() {
   	return new ANTLRv4ParserDomainVisitor() {
		
			@Override
			public void visitGrammarSpec(org.neo4j.graphdb.Node node) { 
				final GrammarSpec grammarNode = newGrammarSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitGrammarSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitGrammarType(org.neo4j.graphdb.Node node) { 
				final GrammarType grammarNode = newGrammarType(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitGrammarType(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitIdentifier(org.neo4j.graphdb.Node node) { 
				final Identifier grammarNode = newIdentifier(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitIdentifier(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitPrequelConstruct(org.neo4j.graphdb.Node node) { 
				final PrequelConstruct grammarNode = newPrequelConstruct(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitPrequelConstruct(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitOptionsSpec(org.neo4j.graphdb.Node node) { 
				final OptionsSpec grammarNode = newOptionsSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitOptionsSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitOption(org.neo4j.graphdb.Node node) { 
				final Option grammarNode = newOption(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitOption(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitOptionValue(org.neo4j.graphdb.Node node) { 
				final OptionValue grammarNode = newOptionValue(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitOptionValue(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitRules(org.neo4j.graphdb.Node node) { 
				final Rules grammarNode = newRules(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitRules(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitRuleSpec(org.neo4j.graphdb.Node node) { 
				final RuleSpec grammarNode = newRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitRuleSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitParserRuleSpec(org.neo4j.graphdb.Node node) { 
				final ParserRuleSpec grammarNode = newParserRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitParserRuleSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitRuleBlock(org.neo4j.graphdb.Node node) { 
				final RuleBlock grammarNode = newRuleBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitRuleBlock(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitRuleAltList(org.neo4j.graphdb.Node node) { 
				final RuleAltList grammarNode = newRuleAltList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitRuleAltList(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLabeledAlt(org.neo4j.graphdb.Node node) { 
				final LabeledAlt grammarNode = newLabeledAlt(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLabeledAlt(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitAlternative(org.neo4j.graphdb.Node node) { 
				final Alternative grammarNode = newAlternative(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitAlternative(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitElement(org.neo4j.graphdb.Node node) { 
				final Element grammarNode = newElement(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitElement(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitAtom(org.neo4j.graphdb.Node node) { 
				final Atom grammarNode = newAtom(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitAtom(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitTerminal(org.neo4j.graphdb.Node node) { 
				final Terminal grammarNode = newTerminal(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitTerminal(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitEbnfSuffix(org.neo4j.graphdb.Node node) { 
				final EbnfSuffix grammarNode = newEbnfSuffix(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitEbnfSuffix(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitRuleref(org.neo4j.graphdb.Node node) { 
				final Ruleref grammarNode = newRuleref(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitRuleref(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitExceptionGroup(org.neo4j.graphdb.Node node) { 
				final ExceptionGroup grammarNode = newExceptionGroup(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitExceptionGroup(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitEbnf(org.neo4j.graphdb.Node node) { 
				final Ebnf grammarNode = newEbnf(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitEbnf(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitBlock(org.neo4j.graphdb.Node node) { 
				final Block grammarNode = newBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitBlock(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitAltList(org.neo4j.graphdb.Node node) { 
				final AltList grammarNode = newAltList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitAltList(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitBlockSuffix(org.neo4j.graphdb.Node node) { 
				final BlockSuffix grammarNode = newBlockSuffix(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitBlockSuffix(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitDelegateGrammars(org.neo4j.graphdb.Node node) { 
				final DelegateGrammars grammarNode = newDelegateGrammars(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitDelegateGrammars(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitDelegateGrammar(org.neo4j.graphdb.Node node) { 
				final DelegateGrammar grammarNode = newDelegateGrammar(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitDelegateGrammar(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitTokensSpec(org.neo4j.graphdb.Node node) { 
				final TokensSpec grammarNode = newTokensSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitTokensSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitIdList(org.neo4j.graphdb.Node node) { 
				final IdList grammarNode = newIdList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitIdList(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitChannelsSpec(org.neo4j.graphdb.Node node) { 
				final ChannelsSpec grammarNode = newChannelsSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitChannelsSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerRuleSpec(org.neo4j.graphdb.Node node) { 
				final LexerRuleSpec grammarNode = newLexerRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerRuleSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerRuleBlock(org.neo4j.graphdb.Node node) { 
				final LexerRuleBlock grammarNode = newLexerRuleBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerRuleBlock(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerAltList(org.neo4j.graphdb.Node node) { 
				final LexerAltList grammarNode = newLexerAltList(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerAltList(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerAlt(org.neo4j.graphdb.Node node) { 
				final LexerAlt grammarNode = newLexerAlt(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerAlt(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerElements(org.neo4j.graphdb.Node node) { 
				final LexerElements grammarNode = newLexerElements(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerElements(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerElement(org.neo4j.graphdb.Node node) { 
				final LexerElement grammarNode = newLexerElement(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerElement(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerAtom(org.neo4j.graphdb.Node node) { 
				final LexerAtom grammarNode = newLexerAtom(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerAtom(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerCommands(org.neo4j.graphdb.Node node) { 
				final LexerCommands grammarNode = newLexerCommands(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerCommands(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerCommand(org.neo4j.graphdb.Node node) { 
				final LexerCommand grammarNode = newLexerCommand(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerCommand(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerCommandName(org.neo4j.graphdb.Node node) { 
				final LexerCommandName grammarNode = newLexerCommandName(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerCommandName(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerCommandExpr(org.neo4j.graphdb.Node node) { 
				final LexerCommandExpr grammarNode = newLexerCommandExpr(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerCommandExpr(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitActionBlock(org.neo4j.graphdb.Node node) { 
				final ActionBlock grammarNode = newActionBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitActionBlock(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitModeSpec(org.neo4j.graphdb.Node node) { 
				final ModeSpec grammarNode = newModeSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitModeSpec(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitLexerBlock(org.neo4j.graphdb.Node node) { 
				final LexerBlock grammarNode = newLexerBlock(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitLexerBlock(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitNotSet(org.neo4j.graphdb.Node node) { 
				final NotSet grammarNode = newNotSet(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitNotSet(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitSetElement(org.neo4j.graphdb.Node node) { 
				final SetElement grammarNode = newSetElement(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitSetElement(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		
			@Override
			public void visitCharacterRange(org.neo4j.graphdb.Node node) { 
				final CharacterRange grammarNode = newCharacterRange(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
				onNode(grammarNode);
		 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		 		grammarStack.push(grammarNode);
		 		super.visitCharacterRange(node);
		 		if (grammarStack.size() > 1) grammarStack.pop();
			} 
		};
	}

	public ANTLRv4ParserNodeListener getANTLRv4ParserNodeListener(boolean debug) {
		return new ANTLRv4ParserNodeListener(debug) {

			@Override
			public void enterGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
				super.enterGrammarSpec(arg);
				final GrammarSpec grammarNode = newGrammarSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
				super.exitGrammarSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterGrammarType(ANTLRv4Parser.GrammarTypeContext arg) {
				super.enterGrammarType(arg);
				final GrammarType grammarNode = newGrammarType(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitGrammarType(ANTLRv4Parser.GrammarTypeContext arg) {
				super.exitGrammarType(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterIdentifier(ANTLRv4Parser.IdentifierContext arg) {
				super.enterIdentifier(arg);
				final Identifier grammarNode = newIdentifier(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitIdentifier(ANTLRv4Parser.IdentifierContext arg) {
				super.exitIdentifier(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterPrequelConstruct(ANTLRv4Parser.PrequelConstructContext arg) {
				super.enterPrequelConstruct(arg);
				final PrequelConstruct grammarNode = newPrequelConstruct(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitPrequelConstruct(ANTLRv4Parser.PrequelConstructContext arg) {
				super.exitPrequelConstruct(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterOptionsSpec(ANTLRv4Parser.OptionsSpecContext arg) {
				super.enterOptionsSpec(arg);
				final OptionsSpec grammarNode = newOptionsSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitOptionsSpec(ANTLRv4Parser.OptionsSpecContext arg) {
				super.exitOptionsSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterOption(ANTLRv4Parser.OptionContext arg) {
				super.enterOption(arg);
				final Option grammarNode = newOption(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitOption(ANTLRv4Parser.OptionContext arg) {
				super.exitOption(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterOptionValue(ANTLRv4Parser.OptionValueContext arg) {
				super.enterOptionValue(arg);
				final OptionValue grammarNode = newOptionValue(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitOptionValue(ANTLRv4Parser.OptionValueContext arg) {
				super.exitOptionValue(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterRules(ANTLRv4Parser.RulesContext arg) {
				super.enterRules(arg);
				final Rules grammarNode = newRules(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitRules(ANTLRv4Parser.RulesContext arg) {
				super.exitRules(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
				super.enterRuleSpec(arg);
				final RuleSpec grammarNode = newRuleSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
				super.exitRuleSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
				super.enterParserRuleSpec(arg);
				final ParserRuleSpec grammarNode = newParserRuleSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
				super.exitParserRuleSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterRuleBlock(ANTLRv4Parser.RuleBlockContext arg) {
				super.enterRuleBlock(arg);
				final RuleBlock grammarNode = newRuleBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitRuleBlock(ANTLRv4Parser.RuleBlockContext arg) {
				super.exitRuleBlock(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterRuleAltList(ANTLRv4Parser.RuleAltListContext arg) {
				super.enterRuleAltList(arg);
				final RuleAltList grammarNode = newRuleAltList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitRuleAltList(ANTLRv4Parser.RuleAltListContext arg) {
				super.exitRuleAltList(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLabeledAlt(ANTLRv4Parser.LabeledAltContext arg) {
				super.enterLabeledAlt(arg);
				final LabeledAlt grammarNode = newLabeledAlt(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLabeledAlt(ANTLRv4Parser.LabeledAltContext arg) {
				super.exitLabeledAlt(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterAlternative(ANTLRv4Parser.AlternativeContext arg) {
				super.enterAlternative(arg);
				final Alternative grammarNode = newAlternative(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitAlternative(ANTLRv4Parser.AlternativeContext arg) {
				super.exitAlternative(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterElement(ANTLRv4Parser.ElementContext arg) {
				super.enterElement(arg);
				final Element grammarNode = newElement(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitElement(ANTLRv4Parser.ElementContext arg) {
				super.exitElement(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterAtom(ANTLRv4Parser.AtomContext arg) {
				super.enterAtom(arg);
				final Atom grammarNode = newAtom(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitAtom(ANTLRv4Parser.AtomContext arg) {
				super.exitAtom(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterTerminal(ANTLRv4Parser.TerminalContext arg) {
				super.enterTerminal(arg);
				final Terminal grammarNode = newTerminal(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitTerminal(ANTLRv4Parser.TerminalContext arg) {
				super.exitTerminal(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
				super.enterEbnfSuffix(arg);
				final EbnfSuffix grammarNode = newEbnfSuffix(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
				super.exitEbnfSuffix(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterRuleref(ANTLRv4Parser.RulerefContext arg) {
				super.enterRuleref(arg);
				final Ruleref grammarNode = newRuleref(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitRuleref(ANTLRv4Parser.RulerefContext arg) {
				super.exitRuleref(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterExceptionGroup(ANTLRv4Parser.ExceptionGroupContext arg) {
				super.enterExceptionGroup(arg);
				final ExceptionGroup grammarNode = newExceptionGroup(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitExceptionGroup(ANTLRv4Parser.ExceptionGroupContext arg) {
				super.exitExceptionGroup(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterEbnf(ANTLRv4Parser.EbnfContext arg) {
				super.enterEbnf(arg);
				final Ebnf grammarNode = newEbnf(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitEbnf(ANTLRv4Parser.EbnfContext arg) {
				super.exitEbnf(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterBlock(ANTLRv4Parser.BlockContext arg) {
				super.enterBlock(arg);
				final Block grammarNode = newBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitBlock(ANTLRv4Parser.BlockContext arg) {
				super.exitBlock(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterAltList(ANTLRv4Parser.AltListContext arg) {
				super.enterAltList(arg);
				final AltList grammarNode = newAltList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitAltList(ANTLRv4Parser.AltListContext arg) {
				super.exitAltList(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterBlockSuffix(ANTLRv4Parser.BlockSuffixContext arg) {
				super.enterBlockSuffix(arg);
				final BlockSuffix grammarNode = newBlockSuffix(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitBlockSuffix(ANTLRv4Parser.BlockSuffixContext arg) {
				super.exitBlockSuffix(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext arg) {
				super.enterDelegateGrammars(arg);
				final DelegateGrammars grammarNode = newDelegateGrammars(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext arg) {
				super.exitDelegateGrammars(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext arg) {
				super.enterDelegateGrammar(arg);
				final DelegateGrammar grammarNode = newDelegateGrammar(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext arg) {
				super.exitDelegateGrammar(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterTokensSpec(ANTLRv4Parser.TokensSpecContext arg) {
				super.enterTokensSpec(arg);
				final TokensSpec grammarNode = newTokensSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitTokensSpec(ANTLRv4Parser.TokensSpecContext arg) {
				super.exitTokensSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterIdList(ANTLRv4Parser.IdListContext arg) {
				super.enterIdList(arg);
				final IdList grammarNode = newIdList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitIdList(ANTLRv4Parser.IdListContext arg) {
				super.exitIdList(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterChannelsSpec(ANTLRv4Parser.ChannelsSpecContext arg) {
				super.enterChannelsSpec(arg);
				final ChannelsSpec grammarNode = newChannelsSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitChannelsSpec(ANTLRv4Parser.ChannelsSpecContext arg) {
				super.exitChannelsSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
				super.enterLexerRuleSpec(arg);
				final LexerRuleSpec grammarNode = newLexerRuleSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
				super.exitLexerRuleSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext arg) {
				super.enterLexerRuleBlock(arg);
				final LexerRuleBlock grammarNode = newLexerRuleBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext arg) {
				super.exitLexerRuleBlock(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerAltList(ANTLRv4Parser.LexerAltListContext arg) {
				super.enterLexerAltList(arg);
				final LexerAltList grammarNode = newLexerAltList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerAltList(ANTLRv4Parser.LexerAltListContext arg) {
				super.exitLexerAltList(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerAlt(ANTLRv4Parser.LexerAltContext arg) {
				super.enterLexerAlt(arg);
				final LexerAlt grammarNode = newLexerAlt(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerAlt(ANTLRv4Parser.LexerAltContext arg) {
				super.exitLexerAlt(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerElements(ANTLRv4Parser.LexerElementsContext arg) {
				super.enterLexerElements(arg);
				final LexerElements grammarNode = newLexerElements(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerElements(ANTLRv4Parser.LexerElementsContext arg) {
				super.exitLexerElements(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerElement(ANTLRv4Parser.LexerElementContext arg) {
				super.enterLexerElement(arg);
				final LexerElement grammarNode = newLexerElement(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerElement(ANTLRv4Parser.LexerElementContext arg) {
				super.exitLexerElement(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerAtom(ANTLRv4Parser.LexerAtomContext arg) {
				super.enterLexerAtom(arg);
				final LexerAtom grammarNode = newLexerAtom(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerAtom(ANTLRv4Parser.LexerAtomContext arg) {
				super.exitLexerAtom(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerCommands(ANTLRv4Parser.LexerCommandsContext arg) {
				super.enterLexerCommands(arg);
				final LexerCommands grammarNode = newLexerCommands(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerCommands(ANTLRv4Parser.LexerCommandsContext arg) {
				super.exitLexerCommands(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerCommand(ANTLRv4Parser.LexerCommandContext arg) {
				super.enterLexerCommand(arg);
				final LexerCommand grammarNode = newLexerCommand(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerCommand(ANTLRv4Parser.LexerCommandContext arg) {
				super.exitLexerCommand(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerCommandName(ANTLRv4Parser.LexerCommandNameContext arg) {
				super.enterLexerCommandName(arg);
				final LexerCommandName grammarNode = newLexerCommandName(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerCommandName(ANTLRv4Parser.LexerCommandNameContext arg) {
				super.exitLexerCommandName(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext arg) {
				super.enterLexerCommandExpr(arg);
				final LexerCommandExpr grammarNode = newLexerCommandExpr(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext arg) {
				super.exitLexerCommandExpr(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterActionBlock(ANTLRv4Parser.ActionBlockContext arg) {
				super.enterActionBlock(arg);
				final ActionBlock grammarNode = newActionBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitActionBlock(ANTLRv4Parser.ActionBlockContext arg) {
				super.exitActionBlock(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterModeSpec(ANTLRv4Parser.ModeSpecContext arg) {
				super.enterModeSpec(arg);
				final ModeSpec grammarNode = newModeSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitModeSpec(ANTLRv4Parser.ModeSpecContext arg) {
				super.exitModeSpec(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterLexerBlock(ANTLRv4Parser.LexerBlockContext arg) {
				super.enterLexerBlock(arg);
				final LexerBlock grammarNode = newLexerBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitLexerBlock(ANTLRv4Parser.LexerBlockContext arg) {
				super.exitLexerBlock(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterNotSet(ANTLRv4Parser.NotSetContext arg) {
				super.enterNotSet(arg);
				final NotSet grammarNode = newNotSet(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitNotSet(ANTLRv4Parser.NotSetContext arg) {
				super.exitNotSet(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterSetElement(ANTLRv4Parser.SetElementContext arg) {
				super.enterSetElement(arg);
				final SetElement grammarNode = newSetElement(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitSetElement(ANTLRv4Parser.SetElementContext arg) {
				super.exitSetElement(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

			@Override
			public void enterCharacterRange(ANTLRv4Parser.CharacterRangeContext arg) {
				super.enterCharacterRange(arg);
				final CharacterRange grammarNode = newCharacterRange(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		      onNode(grammarNode);
				if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);
		      grammarStack.push(grammarNode);
			}

			@Override
			public void exitCharacterRange(ANTLRv4Parser.CharacterRangeContext arg) {
				super.exitCharacterRange(arg);
				if (grammarStack.size() > 1) grammarStack.pop();
			}

		};
	}

	public GrammarSpec newGrammarSpec(String text, String startToken, String endToken) {
		return new GrammarSpec(text, startToken, endToken);
	}

	public class GrammarSpec extends AntlrGrammarNode {

		public GrammarSpec(String text, String startToken, String endToken) {
			super("GrammarSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addGrammarType(GrammarType child) { return super.addChild(child); }

		public AntlrGrammarNode setGrammarType(GrammarType child) { return super.setChild(child); }

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }

		public AntlrGrammarNode addPrequelConstruct(PrequelConstruct child) { return super.addChild(child); }

		public AntlrGrammarNode setPrequelConstruct(PrequelConstruct child) { return super.setChild(child); }

		public AntlrGrammarNode addRules(Rules child) { return super.addChild(child); }

		public AntlrGrammarNode setRules(Rules child) { return super.setChild(child); }

		public AntlrGrammarNode addModeSpec(ModeSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setModeSpec(ModeSpec child) { return super.setChild(child); }

		public AntlrGrammarNode addGrammarSpec(GrammarSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setGrammarSpec(GrammarSpec child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public GrammarType newGrammarType(String text, String startToken, String endToken) {
		return new GrammarType(text, startToken, endToken);
	}

	public class GrammarType extends AntlrGrammarNode {

		public GrammarType(String text, String startToken, String endToken) {
			super("GrammarType", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Identifier newIdentifier(String text, String startToken, String endToken) {
		return new Identifier(text, startToken, endToken);
	}

	public class Identifier extends AntlrGrammarNode {

		public Identifier(String text, String startToken, String endToken) {
			super("Identifier", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public PrequelConstruct newPrequelConstruct(String text, String startToken, String endToken) {
		return new PrequelConstruct(text, startToken, endToken);
	}

	public class PrequelConstruct extends AntlrGrammarNode {

		public PrequelConstruct(String text, String startToken, String endToken) {
			super("PrequelConstruct", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addOptionsSpec(OptionsSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setOptionsSpec(OptionsSpec child) { return super.setChild(child); }

		public AntlrGrammarNode addDelegateGrammars(DelegateGrammars child) { return super.addChild(child); }

		public AntlrGrammarNode setDelegateGrammars(DelegateGrammars child) { return super.setChild(child); }

		public AntlrGrammarNode addTokensSpec(TokensSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setTokensSpec(TokensSpec child) { return super.setChild(child); }

		public AntlrGrammarNode addChannelsSpec(ChannelsSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setChannelsSpec(ChannelsSpec child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public OptionsSpec newOptionsSpec(String text, String startToken, String endToken) {
		return new OptionsSpec(text, startToken, endToken);
	}

	public class OptionsSpec extends AntlrGrammarNode {

		public OptionsSpec(String text, String startToken, String endToken) {
			super("OptionsSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addOption(Option child) { return super.addChild(child); }

		public AntlrGrammarNode setOption(Option child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Option newOption(String text, String startToken, String endToken) {
		return new Option(text, startToken, endToken);
	}

	public class Option extends AntlrGrammarNode {

		public Option(String text, String startToken, String endToken) {
			super("Option", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }

		public AntlrGrammarNode addOptionValue(OptionValue child) { return super.addChild(child); }

		public AntlrGrammarNode setOptionValue(OptionValue child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public OptionValue newOptionValue(String text, String startToken, String endToken) {
		return new OptionValue(text, startToken, endToken);
	}

	public class OptionValue extends AntlrGrammarNode {

		public OptionValue(String text, String startToken, String endToken) {
			super("OptionValue", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Rules newRules(String text, String startToken, String endToken) {
		return new Rules(text, startToken, endToken);
	}

	public class Rules extends AntlrGrammarNode {

		public Rules(String text, String startToken, String endToken) {
			super("Rules", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addRuleSpec(RuleSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setRuleSpec(RuleSpec child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public RuleSpec newRuleSpec(String text, String startToken, String endToken) {
		return new RuleSpec(text, startToken, endToken);
	}

	public class RuleSpec extends AntlrGrammarNode {

		public RuleSpec(String text, String startToken, String endToken) {
			super("RuleSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addParserRuleSpec(ParserRuleSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setParserRuleSpec(ParserRuleSpec child) { return super.setChild(child); }

		public AntlrGrammarNode addLexerRuleSpec(LexerRuleSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerRuleSpec(LexerRuleSpec child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public ParserRuleSpec newParserRuleSpec(String text, String startToken, String endToken) {
		return new ParserRuleSpec(text, startToken, endToken);
	}

	public class ParserRuleSpec extends AntlrGrammarNode {

		public ParserRuleSpec(String text, String startToken, String endToken) {
			super("ParserRuleSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addRuleBlock(RuleBlock child) { return super.addChild(child); }

		public AntlrGrammarNode setRuleBlock(RuleBlock child) { return super.setChild(child); }

		public AntlrGrammarNode addExceptionGroup(ExceptionGroup child) { return super.addChild(child); }

		public AntlrGrammarNode setExceptionGroup(ExceptionGroup child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public RuleBlock newRuleBlock(String text, String startToken, String endToken) {
		return new RuleBlock(text, startToken, endToken);
	}

	public class RuleBlock extends AntlrGrammarNode {

		public RuleBlock(String text, String startToken, String endToken) {
			super("RuleBlock", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addRuleAltList(RuleAltList child) { return super.addChild(child); }

		public AntlrGrammarNode setRuleAltList(RuleAltList child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public RuleAltList newRuleAltList(String text, String startToken, String endToken) {
		return new RuleAltList(text, startToken, endToken);
	}

	public class RuleAltList extends AntlrGrammarNode {

		public RuleAltList(String text, String startToken, String endToken) {
			super("RuleAltList", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLabeledAlt(LabeledAlt child) { return super.addChild(child); }

		public AntlrGrammarNode setLabeledAlt(LabeledAlt child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LabeledAlt newLabeledAlt(String text, String startToken, String endToken) {
		return new LabeledAlt(text, startToken, endToken);
	}

	public class LabeledAlt extends AntlrGrammarNode {

		public LabeledAlt(String text, String startToken, String endToken) {
			super("LabeledAlt", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addAlternative(Alternative child) { return super.addChild(child); }

		public AntlrGrammarNode setAlternative(Alternative child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Alternative newAlternative(String text, String startToken, String endToken) {
		return new Alternative(text, startToken, endToken);
	}

	public class Alternative extends AntlrGrammarNode {

		public Alternative(String text, String startToken, String endToken) {
			super("Alternative", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addElement(Element child) { return super.addChild(child); }

		public AntlrGrammarNode setElement(Element child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Element newElement(String text, String startToken, String endToken) {
		return new Element(text, startToken, endToken);
	}

	public class Element extends AntlrGrammarNode {

		public Element(String text, String startToken, String endToken) {
			super("Element", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addAtom(Atom child) { return super.addChild(child); }

		public AntlrGrammarNode setAtom(Atom child) { return super.setChild(child); }

		public AntlrGrammarNode addEbnfSuffix(EbnfSuffix child) { return super.addChild(child); }

		public AntlrGrammarNode setEbnfSuffix(EbnfSuffix child) { return super.setChild(child); }

		public AntlrGrammarNode addEbnf(Ebnf child) { return super.addChild(child); }

		public AntlrGrammarNode setEbnf(Ebnf child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Atom newAtom(String text, String startToken, String endToken) {
		return new Atom(text, startToken, endToken);
	}

	public class Atom extends AntlrGrammarNode {

		public Atom(String text, String startToken, String endToken) {
			super("Atom", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addTerminal(Terminal child) { return super.addChild(child); }

		public AntlrGrammarNode setTerminal(Terminal child) { return super.setChild(child); }

		public AntlrGrammarNode addRuleref(Ruleref child) { return super.addChild(child); }

		public AntlrGrammarNode setRuleref(Ruleref child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Terminal newTerminal(String text, String startToken, String endToken) {
		return new Terminal(text, startToken, endToken);
	}

	public class Terminal extends AntlrGrammarNode {

		public Terminal(String text, String startToken, String endToken) {
			super("Terminal", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public EbnfSuffix newEbnfSuffix(String text, String startToken, String endToken) {
		return new EbnfSuffix(text, startToken, endToken);
	}

	public class EbnfSuffix extends AntlrGrammarNode {

		public EbnfSuffix(String text, String startToken, String endToken) {
			super("EbnfSuffix", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Ruleref newRuleref(String text, String startToken, String endToken) {
		return new Ruleref(text, startToken, endToken);
	}

	public class Ruleref extends AntlrGrammarNode {

		public Ruleref(String text, String startToken, String endToken) {
			super("Ruleref", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public ExceptionGroup newExceptionGroup(String text, String startToken, String endToken) {
		return new ExceptionGroup(text, startToken, endToken);
	}

	public class ExceptionGroup extends AntlrGrammarNode {

		public ExceptionGroup(String text, String startToken, String endToken) {
			super("ExceptionGroup", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Ebnf newEbnf(String text, String startToken, String endToken) {
		return new Ebnf(text, startToken, endToken);
	}

	public class Ebnf extends AntlrGrammarNode {

		public Ebnf(String text, String startToken, String endToken) {
			super("Ebnf", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addBlock(Block child) { return super.addChild(child); }

		public AntlrGrammarNode setBlock(Block child) { return super.setChild(child); }

		public AntlrGrammarNode addBlockSuffix(BlockSuffix child) { return super.addChild(child); }

		public AntlrGrammarNode setBlockSuffix(BlockSuffix child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public Block newBlock(String text, String startToken, String endToken) {
		return new Block(text, startToken, endToken);
	}

	public class Block extends AntlrGrammarNode {

		public Block(String text, String startToken, String endToken) {
			super("Block", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addAltList(AltList child) { return super.addChild(child); }

		public AntlrGrammarNode setAltList(AltList child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public AltList newAltList(String text, String startToken, String endToken) {
		return new AltList(text, startToken, endToken);
	}

	public class AltList extends AntlrGrammarNode {

		public AltList(String text, String startToken, String endToken) {
			super("AltList", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addAlternative(Alternative child) { return super.addChild(child); }

		public AntlrGrammarNode setAlternative(Alternative child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public BlockSuffix newBlockSuffix(String text, String startToken, String endToken) {
		return new BlockSuffix(text, startToken, endToken);
	}

	public class BlockSuffix extends AntlrGrammarNode {

		public BlockSuffix(String text, String startToken, String endToken) {
			super("BlockSuffix", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addEbnfSuffix(EbnfSuffix child) { return super.addChild(child); }

		public AntlrGrammarNode setEbnfSuffix(EbnfSuffix child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public DelegateGrammars newDelegateGrammars(String text, String startToken, String endToken) {
		return new DelegateGrammars(text, startToken, endToken);
	}

	public class DelegateGrammars extends AntlrGrammarNode {

		public DelegateGrammars(String text, String startToken, String endToken) {
			super("DelegateGrammars", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addDelegateGrammar(DelegateGrammar child) { return super.addChild(child); }

		public AntlrGrammarNode setDelegateGrammar(DelegateGrammar child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public DelegateGrammar newDelegateGrammar(String text, String startToken, String endToken) {
		return new DelegateGrammar(text, startToken, endToken);
	}

	public class DelegateGrammar extends AntlrGrammarNode {

		public DelegateGrammar(String text, String startToken, String endToken) {
			super("DelegateGrammar", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public TokensSpec newTokensSpec(String text, String startToken, String endToken) {
		return new TokensSpec(text, startToken, endToken);
	}

	public class TokensSpec extends AntlrGrammarNode {

		public TokensSpec(String text, String startToken, String endToken) {
			super("TokensSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdList(IdList child) { return super.addChild(child); }

		public AntlrGrammarNode setIdList(IdList child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public IdList newIdList(String text, String startToken, String endToken) {
		return new IdList(text, startToken, endToken);
	}

	public class IdList extends AntlrGrammarNode {

		public IdList(String text, String startToken, String endToken) {
			super("IdList", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public ChannelsSpec newChannelsSpec(String text, String startToken, String endToken) {
		return new ChannelsSpec(text, startToken, endToken);
	}

	public class ChannelsSpec extends AntlrGrammarNode {

		public ChannelsSpec(String text, String startToken, String endToken) {
			super("ChannelsSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdList(IdList child) { return super.addChild(child); }

		public AntlrGrammarNode setIdList(IdList child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerRuleSpec newLexerRuleSpec(String text, String startToken, String endToken) {
		return new LexerRuleSpec(text, startToken, endToken);
	}

	public class LexerRuleSpec extends AntlrGrammarNode {

		public LexerRuleSpec(String text, String startToken, String endToken) {
			super("LexerRuleSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerRuleBlock(LexerRuleBlock child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerRuleBlock(LexerRuleBlock child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerRuleBlock newLexerRuleBlock(String text, String startToken, String endToken) {
		return new LexerRuleBlock(text, startToken, endToken);
	}

	public class LexerRuleBlock extends AntlrGrammarNode {

		public LexerRuleBlock(String text, String startToken, String endToken) {
			super("LexerRuleBlock", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerAltList(LexerAltList child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerAltList(LexerAltList child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerAltList newLexerAltList(String text, String startToken, String endToken) {
		return new LexerAltList(text, startToken, endToken);
	}

	public class LexerAltList extends AntlrGrammarNode {

		public LexerAltList(String text, String startToken, String endToken) {
			super("LexerAltList", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerAlt(LexerAlt child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerAlt(LexerAlt child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerAlt newLexerAlt(String text, String startToken, String endToken) {
		return new LexerAlt(text, startToken, endToken);
	}

	public class LexerAlt extends AntlrGrammarNode {

		public LexerAlt(String text, String startToken, String endToken) {
			super("LexerAlt", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerElements(LexerElements child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerElements(LexerElements child) { return super.setChild(child); }

		public AntlrGrammarNode addLexerCommands(LexerCommands child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerCommands(LexerCommands child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerElements newLexerElements(String text, String startToken, String endToken) {
		return new LexerElements(text, startToken, endToken);
	}

	public class LexerElements extends AntlrGrammarNode {

		public LexerElements(String text, String startToken, String endToken) {
			super("LexerElements", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerElement(LexerElement child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerElement(LexerElement child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerElement newLexerElement(String text, String startToken, String endToken) {
		return new LexerElement(text, startToken, endToken);
	}

	public class LexerElement extends AntlrGrammarNode {

		public LexerElement(String text, String startToken, String endToken) {
			super("LexerElement", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerAtom(LexerAtom child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerAtom(LexerAtom child) { return super.setChild(child); }

		public AntlrGrammarNode addActionBlock(ActionBlock child) { return super.addChild(child); }

		public AntlrGrammarNode setActionBlock(ActionBlock child) { return super.setChild(child); }

		public AntlrGrammarNode addEbnfSuffix(EbnfSuffix child) { return super.addChild(child); }

		public AntlrGrammarNode setEbnfSuffix(EbnfSuffix child) { return super.setChild(child); }

		public AntlrGrammarNode addLexerBlock(LexerBlock child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerBlock(LexerBlock child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerAtom newLexerAtom(String text, String startToken, String endToken) {
		return new LexerAtom(text, startToken, endToken);
	}

	public class LexerAtom extends AntlrGrammarNode {

		public LexerAtom(String text, String startToken, String endToken) {
			super("LexerAtom", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addTerminal(Terminal child) { return super.addChild(child); }

		public AntlrGrammarNode setTerminal(Terminal child) { return super.setChild(child); }

		public AntlrGrammarNode addNotSet(NotSet child) { return super.addChild(child); }

		public AntlrGrammarNode setNotSet(NotSet child) { return super.setChild(child); }

		public AntlrGrammarNode addCharacterRange(CharacterRange child) { return super.addChild(child); }

		public AntlrGrammarNode setCharacterRange(CharacterRange child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerCommands newLexerCommands(String text, String startToken, String endToken) {
		return new LexerCommands(text, startToken, endToken);
	}

	public class LexerCommands extends AntlrGrammarNode {

		public LexerCommands(String text, String startToken, String endToken) {
			super("LexerCommands", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerCommand(LexerCommand child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerCommand(LexerCommand child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerCommand newLexerCommand(String text, String startToken, String endToken) {
		return new LexerCommand(text, startToken, endToken);
	}

	public class LexerCommand extends AntlrGrammarNode {

		public LexerCommand(String text, String startToken, String endToken) {
			super("LexerCommand", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerCommandName(LexerCommandName child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerCommandName(LexerCommandName child) { return super.setChild(child); }

		public AntlrGrammarNode addLexerCommandExpr(LexerCommandExpr child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerCommandExpr(LexerCommandExpr child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerCommandName newLexerCommandName(String text, String startToken, String endToken) {
		return new LexerCommandName(text, startToken, endToken);
	}

	public class LexerCommandName extends AntlrGrammarNode {

		public LexerCommandName(String text, String startToken, String endToken) {
			super("LexerCommandName", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerCommandExpr newLexerCommandExpr(String text, String startToken, String endToken) {
		return new LexerCommandExpr(text, startToken, endToken);
	}

	public class LexerCommandExpr extends AntlrGrammarNode {

		public LexerCommandExpr(String text, String startToken, String endToken) {
			super("LexerCommandExpr", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public ActionBlock newActionBlock(String text, String startToken, String endToken) {
		return new ActionBlock(text, startToken, endToken);
	}

	public class ActionBlock extends AntlrGrammarNode {

		public ActionBlock(String text, String startToken, String endToken) {
			super("ActionBlock", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public ModeSpec newModeSpec(String text, String startToken, String endToken) {
		return new ModeSpec(text, startToken, endToken);
	}

	public class ModeSpec extends AntlrGrammarNode {

		public ModeSpec(String text, String startToken, String endToken) {
			super("ModeSpec", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addIdentifier(Identifier child) { return super.addChild(child); }

		public AntlrGrammarNode setIdentifier(Identifier child) { return super.setChild(child); }

		public AntlrGrammarNode addLexerRuleSpec(LexerRuleSpec child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerRuleSpec(LexerRuleSpec child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public LexerBlock newLexerBlock(String text, String startToken, String endToken) {
		return new LexerBlock(text, startToken, endToken);
	}

	public class LexerBlock extends AntlrGrammarNode {

		public LexerBlock(String text, String startToken, String endToken) {
			super("LexerBlock", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addLexerAltList(LexerAltList child) { return super.addChild(child); }

		public AntlrGrammarNode setLexerAltList(LexerAltList child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public NotSet newNotSet(String text, String startToken, String endToken) {
		return new NotSet(text, startToken, endToken);
	}

	public class NotSet extends AntlrGrammarNode {

		public NotSet(String text, String startToken, String endToken) {
			super("NotSet", startToken, text, startToken, endToken);
		}

		public AntlrGrammarNode addSetElement(SetElement child) { return super.addChild(child); }

		public AntlrGrammarNode setSetElement(SetElement child) { return super.setChild(child); }


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public SetElement newSetElement(String text, String startToken, String endToken) {
		return new SetElement(text, startToken, endToken);
	}

	public class SetElement extends AntlrGrammarNode {

		public SetElement(String text, String startToken, String endToken) {
			super("SetElement", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

	public CharacterRange newCharacterRange(String text, String startToken, String endToken) {
		return new CharacterRange(text, startToken, endToken);
	}

	public class CharacterRange extends AntlrGrammarNode {

		public CharacterRange(String text, String startToken, String endToken) {
			super("CharacterRange", startToken, text, startToken, endToken);
		}


		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
}