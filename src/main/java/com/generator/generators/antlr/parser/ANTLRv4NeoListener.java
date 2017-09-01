package com.generator.generators.antlr.parser;

import com.generator.editors.NeoModel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;import java.util.Stack;
import static com.generator.app.plugins.DomainPlugin.Entities.Entity;

public class ANTLRv4NeoListener extends ANTLRv4ParserBaseListener {

	private final NeoModel graph;
   private final Stack<Node> nodeStack = new Stack<>();

   public ANTLRv4NeoListener(NeoModel graph) {
      this.graph = graph;
   }

	public Node getRoot() { return nodeStack.isEmpty() ? null : nodeStack.peek(); }

	@Override
	public void exitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "DelegateGrammars");
      final Node node = graph.findOrCreate(Label.label("DelegateGrammars"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("DelegateGrammars"));
      nodeStack.push(node);
	}

	@Override
	public void exitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "DelegateGrammar");
      final Node node = graph.findOrCreate(Label.label("DelegateGrammar"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("DelegateGrammar"));
      nodeStack.push(node);
	}

	@Override
	public void exitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "TokensSpec");
      final Node node = graph.findOrCreate(Label.label("TokensSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("TokensSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ChannelsSpec");
      final Node node = graph.findOrCreate(Label.label("ChannelsSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ChannelsSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "IdList");
      final Node node = graph.findOrCreate(Label.label("IdList"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("IdList"));
      nodeStack.push(node);
	}

	@Override
	public void exitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Action");
      final Node node = graph.findOrCreate(Label.label("Action"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Action"));
      nodeStack.push(node);
	}

	@Override
	public void exitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ActionScopeName");
      final Node node = graph.findOrCreate(Label.label("ActionScopeName"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ActionScopeName"));
      nodeStack.push(node);
	}

	@Override
	public void exitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ActionBlock");
      final Node node = graph.findOrCreate(Label.label("ActionBlock"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ActionBlock"));
      nodeStack.push(node);
	}

	@Override
	public void exitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ArgActionBlock");
      final Node node = graph.findOrCreate(Label.label("ArgActionBlock"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ArgActionBlock"));
      nodeStack.push(node);
	}

	@Override
	public void exitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ModeSpec");
      final Node node = graph.findOrCreate(Label.label("ModeSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ModeSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Rules");
      final Node node = graph.findOrCreate(Label.label("Rules"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Rules"));
      nodeStack.push(node);
	}

	@Override
	public void exitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RuleSpec");
      final Node node = graph.findOrCreate(Label.label("RuleSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RuleSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ParserRuleSpec");
      final Node node = graph.findOrCreate(Label.label("ParserRuleSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ParserRuleSpec"));
      nodeStack.push(node);
	}

	@Override
	public void enterExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ExceptionGroup");
      final Node node = graph.findOrCreate(Label.label("ExceptionGroup"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ExceptionGroup"));
      nodeStack.push(node);
	}

	@Override
	public void exitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ExceptionHandler");
      final Node node = graph.findOrCreate(Label.label("ExceptionHandler"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ExceptionHandler"));
      nodeStack.push(node);
	}

	@Override
	public void exitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "FinallyClause");
      final Node node = graph.findOrCreate(Label.label("FinallyClause"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("FinallyClause"));
      nodeStack.push(node);
	}

	@Override
	public void exitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RulePrequel");
      final Node node = graph.findOrCreate(Label.label("RulePrequel"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RulePrequel"));
      nodeStack.push(node);
	}

	@Override
	public void exitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RuleReturns");
      final Node node = graph.findOrCreate(Label.label("RuleReturns"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RuleReturns"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ThrowsSpec");
      final Node node = graph.findOrCreate(Label.label("ThrowsSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ThrowsSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LocalsSpec");
      final Node node = graph.findOrCreate(Label.label("LocalsSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LocalsSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "GrammarSpec");
      final Node node = graph.findOrCreate(Label.label("GrammarSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("GrammarSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "OptionValue");
      final Node node = graph.findOrCreate(Label.label("OptionValue"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("OptionValue"));
      nodeStack.push(node);
	}

	@Override
	public void exitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "GrammarType");
      final Node node = graph.findOrCreate(Label.label("GrammarType"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("GrammarType"));
      nodeStack.push(node);
	}

	@Override
	public void exitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "PrequelConstruct");
      final Node node = graph.findOrCreate(Label.label("PrequelConstruct"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("PrequelConstruct"));
      nodeStack.push(node);
	}

	@Override
	public void exitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "OptionsSpec");
      final Node node = graph.findOrCreate(Label.label("OptionsSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("OptionsSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Option");
      final Node node = graph.findOrCreate(Label.label("Option"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Option"));
      nodeStack.push(node);
	}

	@Override
	public void exitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RuleAction");
      final Node node = graph.findOrCreate(Label.label("RuleAction"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RuleAction"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RuleModifiers");
      final Node node = graph.findOrCreate(Label.label("RuleModifiers"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RuleModifiers"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RuleModifier");
      final Node node = graph.findOrCreate(Label.label("RuleModifier"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RuleModifier"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RuleBlock");
      final Node node = graph.findOrCreate(Label.label("RuleBlock"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RuleBlock"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "RuleAltList");
      final Node node = graph.findOrCreate(Label.label("RuleAltList"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("RuleAltList"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LabeledAlt");
      final Node node = graph.findOrCreate(Label.label("LabeledAlt"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LabeledAlt"));
      nodeStack.push(node);
	}

	@Override
	public void exitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerRuleSpec");
      final Node node = graph.findOrCreate(Label.label("LexerRuleSpec"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerRuleSpec"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerRuleBlock");
      final Node node = graph.findOrCreate(Label.label("LexerRuleBlock"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerRuleBlock"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerAltList");
      final Node node = graph.findOrCreate(Label.label("LexerAltList"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerAltList"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerAlt");
      final Node node = graph.findOrCreate(Label.label("LexerAlt"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerAlt"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerElements");
      final Node node = graph.findOrCreate(Label.label("LexerElements"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerElements"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerElement");
      final Node node = graph.findOrCreate(Label.label("LexerElement"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerElement"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LabeledLexerElement");
      final Node node = graph.findOrCreate(Label.label("LabeledLexerElement"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LabeledLexerElement"));
      nodeStack.push(node);
	}

	@Override
	public void exitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerBlock");
      final Node node = graph.findOrCreate(Label.label("LexerBlock"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerBlock"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerCommands");
      final Node node = graph.findOrCreate(Label.label("LexerCommands"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerCommands"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerCommand");
      final Node node = graph.findOrCreate(Label.label("LexerCommand"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerCommand"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerCommandName");
      final Node node = graph.findOrCreate(Label.label("LexerCommandName"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerCommandName"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerCommandExpr");
      final Node node = graph.findOrCreate(Label.label("LexerCommandExpr"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerCommandExpr"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "AltList");
      final Node node = graph.findOrCreate(Label.label("AltList"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("AltList"));
      nodeStack.push(node);
	}

	@Override
	public void exitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Alternative");
      final Node node = graph.findOrCreate(Label.label("Alternative"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Alternative"));
      nodeStack.push(node);
	}

	@Override
	public void exitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Element");
      final Node node = graph.findOrCreate(Label.label("Element"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Element"));
      nodeStack.push(node);
	}

	@Override
	public void exitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LabeledElement");
      final Node node = graph.findOrCreate(Label.label("LabeledElement"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LabeledElement"));
      nodeStack.push(node);
	}

	@Override
	public void exitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Ebnf");
      final Node node = graph.findOrCreate(Label.label("Ebnf"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Ebnf"));
      nodeStack.push(node);
	}

	@Override
	public void exitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "BlockSuffix");
      final Node node = graph.findOrCreate(Label.label("BlockSuffix"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("BlockSuffix"));
      nodeStack.push(node);
	}

	@Override
	public void exitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "EbnfSuffix");
      final Node node = graph.findOrCreate(Label.label("EbnfSuffix"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("EbnfSuffix"));
      nodeStack.push(node);
	}

	@Override
	public void exitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "LexerAtom");
      final Node node = graph.findOrCreate(Label.label("LexerAtom"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("LexerAtom"));
      nodeStack.push(node);
	}

	@Override
	public void exitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Atom");
      final Node node = graph.findOrCreate(Label.label("Atom"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Atom"));
      nodeStack.push(node);
	}

	@Override
	public void exitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "NotSet");
      final Node node = graph.findOrCreate(Label.label("NotSet"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("NotSet"));
      nodeStack.push(node);
	}

	@Override
	public void exitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "BlockSet");
      final Node node = graph.findOrCreate(Label.label("BlockSet"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("BlockSet"));
      nodeStack.push(node);
	}

	@Override
	public void exitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "SetElement");
      final Node node = graph.findOrCreate(Label.label("SetElement"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("SetElement"));
      nodeStack.push(node);
	}

	@Override
	public void exitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Block");
      final Node node = graph.findOrCreate(Label.label("Block"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Block"));
      nodeStack.push(node);
	}

	@Override
	public void exitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Ruleref");
      final Node node = graph.findOrCreate(Label.label("Ruleref"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Ruleref"));
      nodeStack.push(node);
	}

	@Override
	public void exitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "CharacterRange");
      final Node node = graph.findOrCreate(Label.label("CharacterRange"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("CharacterRange"));
      nodeStack.push(node);
	}

	@Override
	public void exitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Terminal");
      final Node node = graph.findOrCreate(Label.label("Terminal"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Terminal"));
      nodeStack.push(node);
	}

	@Override
	public void exitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ElementOptions");
      final Node node = graph.findOrCreate(Label.label("ElementOptions"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ElementOptions"));
      nodeStack.push(node);
	}

	@Override
	public void exitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "ElementOption");
      final Node node = graph.findOrCreate(Label.label("ElementOption"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("ElementOption"));
      nodeStack.push(node);
	}

	@Override
	public void exitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}

	@Override
	public void enterIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg0) {
		final Node entityNode = graph.findOrCreate(Entity, "name", "Identifier");
      final Node node = graph.findOrCreate(Label.label("Identifier"), "name", arg0.getText());
      graph.relate(entityNode, node, RelationshipType.withName("INSTANCE"));
      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName("Identifier"));
      nodeStack.push(node);
	}

	@Override
	public void exitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg0) {
		if (nodeStack.size() > 1) nodeStack.pop();
	}
}