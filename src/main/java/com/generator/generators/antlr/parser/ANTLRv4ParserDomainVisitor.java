package com.generator.generators.antlr.parser;

import org.neo4j.graphdb.*;

public abstract class ANTLRv4ParserDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "RuleModifiers")) visitRuleModifiers(node);
		else if(hasLabel(node, "RuleModifier")) visitRuleModifier(node);
		else if(hasLabel(node, "RuleBlock")) visitRuleBlock(node);
		else if(hasLabel(node, "RuleAltList")) visitRuleAltList(node);
		else if(hasLabel(node, "LabeledAlt")) visitLabeledAlt(node);
		else if(hasLabel(node, "LexerRuleSpec")) visitLexerRuleSpec(node);
		else if(hasLabel(node, "LexerRuleBlock")) visitLexerRuleBlock(node);
		else if(hasLabel(node, "LexerAltList")) visitLexerAltList(node);
		else if(hasLabel(node, "LexerAlt")) visitLexerAlt(node);
		else if(hasLabel(node, "LexerElements")) visitLexerElements(node);
		else if(hasLabel(node, "LexerElement")) visitLexerElement(node);
		else if(hasLabel(node, "LabeledLexerElement")) visitLabeledLexerElement(node);
		else if(hasLabel(node, "LexerBlock")) visitLexerBlock(node);
		else if(hasLabel(node, "LexerCommands")) visitLexerCommands(node);
		else if(hasLabel(node, "LexerCommand")) visitLexerCommand(node);
		else if(hasLabel(node, "LexerCommandName")) visitLexerCommandName(node);
		else if(hasLabel(node, "LexerCommandExpr")) visitLexerCommandExpr(node);
		else if(hasLabel(node, "AltList")) visitAltList(node);
		else if(hasLabel(node, "Alternative")) visitAlternative(node);
		else if(hasLabel(node, "Element")) visitElement(node);
		else if(hasLabel(node, "LabeledElement")) visitLabeledElement(node);
		else if(hasLabel(node, "Ebnf")) visitEbnf(node);
		else if(hasLabel(node, "BlockSuffix")) visitBlockSuffix(node);
		else if(hasLabel(node, "EbnfSuffix")) visitEbnfSuffix(node);
		else if(hasLabel(node, "LexerAtom")) visitLexerAtom(node);
		else if(hasLabel(node, "Atom")) visitAtom(node);
		else if(hasLabel(node, "NotSet")) visitNotSet(node);
		else if(hasLabel(node, "BlockSet")) visitBlockSet(node);
		else if(hasLabel(node, "SetElement")) visitSetElement(node);
		else if(hasLabel(node, "Block")) visitBlock(node);
		else if(hasLabel(node, "Ruleref")) visitRuleref(node);
		else if(hasLabel(node, "CharacterRange")) visitCharacterRange(node);
		else if(hasLabel(node, "Terminal")) visitTerminal(node);
		else if(hasLabel(node, "ElementOptions")) visitElementOptions(node);
		else if(hasLabel(node, "ElementOption")) visitElementOption(node);
		else if(hasLabel(node, "Identifier")) visitIdentifier(node);
		else if(hasLabel(node, "GrammarSpec")) visitGrammarSpec(node);
		else if(hasLabel(node, "PrequelConstruct")) visitPrequelConstruct(node);
		else if(hasLabel(node, "GrammarType")) visitGrammarType(node);
		else if(hasLabel(node, "OptionsSpec")) visitOptionsSpec(node);
		else if(hasLabel(node, "Option")) visitOption(node);
		else if(hasLabel(node, "OptionValue")) visitOptionValue(node);
		else if(hasLabel(node, "DelegateGrammars")) visitDelegateGrammars(node);
		else if(hasLabel(node, "DelegateGrammar")) visitDelegateGrammar(node);
		else if(hasLabel(node, "TokensSpec")) visitTokensSpec(node);
		else if(hasLabel(node, "ChannelsSpec")) visitChannelsSpec(node);
		else if(hasLabel(node, "IdList")) visitIdList(node);
		else if(hasLabel(node, "Action")) visitAction(node);
		else if(hasLabel(node, "ActionScopeName")) visitActionScopeName(node);
		else if(hasLabel(node, "ActionBlock")) visitActionBlock(node);
		else if(hasLabel(node, "ArgActionBlock")) visitArgActionBlock(node);
		else if(hasLabel(node, "ModeSpec")) visitModeSpec(node);
		else if(hasLabel(node, "Rules")) visitRules(node);
		else if(hasLabel(node, "RuleSpec")) visitRuleSpec(node);
		else if(hasLabel(node, "ParserRuleSpec")) visitParserRuleSpec(node);
		else if(hasLabel(node, "ExceptionGroup")) visitExceptionGroup(node);
		else if(hasLabel(node, "ExceptionHandler")) visitExceptionHandler(node);
		else if(hasLabel(node, "FinallyClause")) visitFinallyClause(node);
		else if(hasLabel(node, "RulePrequel")) visitRulePrequel(node);
		else if(hasLabel(node, "RuleReturns")) visitRuleReturns(node);
		else if(hasLabel(node, "ThrowsSpec")) visitThrowsSpec(node);
		else if(hasLabel(node, "LocalsSpec")) visitLocalsSpec(node);
		else if(hasLabel(node, "RuleAction")) visitRuleAction(node);
   }

	public void visitRuleModifiers(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRuleModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRuleBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRuleAltList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLabeledAlt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerRuleSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerRuleBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerAltList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerAlt(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerElements(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLabeledLexerElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerCommands(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerCommand(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerCommandName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerCommandExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAltList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlternative(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLabeledElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEbnf(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlockSuffix(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEbnfSuffix(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLexerAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAtom(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNotSet(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlockSet(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSetElement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRuleref(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCharacterRange(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTerminal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementOptions(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementOption(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdentifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGrammarSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrequelConstruct(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGrammarType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOptionsSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOption(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOptionValue(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDelegateGrammars(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDelegateGrammar(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTokensSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitChannelsSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitActionScopeName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitActionBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArgActionBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitModeSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRules(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRuleSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParserRuleSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExceptionGroup(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExceptionHandler(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFinallyClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRulePrequel(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRuleReturns(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitThrowsSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLocalsSpec(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRuleAction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	private boolean hasLabel(Node node, String label) {
   	for (org.neo4j.graphdb.Label lbl : node.getLabels())
      	if (lbl.name().equals(label)) return true;
      return false;
   }

	protected Iterable<Relationship> outgoing(Node node, RelationshipType type) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type));
   }

	protected Iterable<Relationship> outgoing(Node node) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING));
   }

	protected static Iterable<Relationship> sort(Iterable<Relationship> relationships) {
		final java.util.Set<Relationship> relations = new java.util.TreeSet<>(java.util.Comparator.comparingLong(Relationship::getId));
		for (Relationship relationship : relationships)
			relations.add(relationship);
		return relations;
	}

	protected Node other(Node node, Relationship relationship) {
     	return relationship == null ? null : relationship.getOtherNode(node);
   }
}