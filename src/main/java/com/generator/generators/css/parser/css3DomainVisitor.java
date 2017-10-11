package com.generator.generators.css.parser;

import org.neo4j.graphdb.*;

public abstract class css3DomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Block")) visitBlock(node);
		else if(hasLabel(node, "Number")) visitNumber(node);
		else if(hasLabel(node, "Expression")) visitExpression(node);
		else if(hasLabel(node, "Stylesheet")) visitStylesheet(node);
		else if(hasLabel(node, "GoodCharset")) visitGoodCharset(node);
		else if(hasLabel(node, "BadCharset")) visitBadCharset(node);
		else if(hasLabel(node, "GoodImport")) visitGoodImport(node);
		else if(hasLabel(node, "BadImport")) visitBadImport(node);
		else if(hasLabel(node, "GoodNamespace")) visitGoodNamespace(node);
		else if(hasLabel(node, "BadNamespace")) visitBadNamespace(node);
		else if(hasLabel(node, "NamespacePrefix")) visitNamespacePrefix(node);
		else if(hasLabel(node, "Media")) visitMedia(node);
		else if(hasLabel(node, "MediaQueryList")) visitMediaQueryList(node);
		else if(hasLabel(node, "MediaQuery")) visitMediaQuery(node);
		else if(hasLabel(node, "MediaType")) visitMediaType(node);
		else if(hasLabel(node, "MediaExpression")) visitMediaExpression(node);
		else if(hasLabel(node, "MediaFeature")) visitMediaFeature(node);
		else if(hasLabel(node, "Page")) visitPage(node);
		else if(hasLabel(node, "PseudoPage")) visitPseudoPage(node);
		else if(hasLabel(node, "SelectorGroup")) visitSelectorGroup(node);
		else if(hasLabel(node, "Selector")) visitSelector(node);
		else if(hasLabel(node, "Combinator")) visitCombinator(node);
		else if(hasLabel(node, "SimpleSelectorSequence")) visitSimpleSelectorSequence(node);
		else if(hasLabel(node, "TypeSelector")) visitTypeSelector(node);
		else if(hasLabel(node, "TypeNamespacePrefix")) visitTypeNamespacePrefix(node);
		else if(hasLabel(node, "ElementName")) visitElementName(node);
		else if(hasLabel(node, "Universal")) visitUniversal(node);
		else if(hasLabel(node, "ClassName")) visitClassName(node);
		else if(hasLabel(node, "Attrib")) visitAttrib(node);
		else if(hasLabel(node, "Pseudo")) visitPseudo(node);
		else if(hasLabel(node, "FunctionalPseudo")) visitFunctionalPseudo(node);
		else if(hasLabel(node, "Negation")) visitNegation(node);
		else if(hasLabel(node, "NegationArg")) visitNegationArg(node);
		else if(hasLabel(node, "GoodOperator")) visitGoodOperator(node);
		else if(hasLabel(node, "BadOperator")) visitBadOperator(node);
		else if(hasLabel(node, "GoodProperty")) visitGoodProperty(node);
		else if(hasLabel(node, "BadProperty")) visitBadProperty(node);
		else if(hasLabel(node, "KnownRuleset")) visitKnownRuleset(node);
		else if(hasLabel(node, "UnknownRuleset")) visitUnknownRuleset(node);
		else if(hasLabel(node, "DeclarationList")) visitDeclarationList(node);
		else if(hasLabel(node, "KnownDeclaration")) visitKnownDeclaration(node);
		else if(hasLabel(node, "UnknownDeclaration")) visitUnknownDeclaration(node);
		else if(hasLabel(node, "Prio")) visitPrio(node);
		else if(hasLabel(node, "Value")) visitValue(node);
		else if(hasLabel(node, "Expr")) visitExpr(node);
		else if(hasLabel(node, "KnownTerm")) visitKnownTerm(node);
		else if(hasLabel(node, "UnknownTerm")) visitUnknownTerm(node);
		else if(hasLabel(node, "BadTerm")) visitBadTerm(node);
		else if(hasLabel(node, "Function")) visitFunction(node);
		else if(hasLabel(node, "DxImageTransform")) visitDxImageTransform(node);
		else if(hasLabel(node, "Hexcolor")) visitHexcolor(node);
		else if(hasLabel(node, "Percentage")) visitPercentage(node);
		else if(hasLabel(node, "Dimension")) visitDimension(node);
		else if(hasLabel(node, "UnknownDimension")) visitUnknownDimension(node);
		else if(hasLabel(node, "Any")) visitAny(node);
		else if(hasLabel(node, "UnknownAtRule")) visitUnknownAtRule(node);
		else if(hasLabel(node, "AtKeyword")) visitAtKeyword(node);
		else if(hasLabel(node, "Unused")) visitUnused(node);
		else if(hasLabel(node, "NestedStatement")) visitNestedStatement(node);
		else if(hasLabel(node, "GroupRuleBody")) visitGroupRuleBody(node);
		else if(hasLabel(node, "SupportsRule")) visitSupportsRule(node);
		else if(hasLabel(node, "SupportsCondition")) visitSupportsCondition(node);
		else if(hasLabel(node, "SupportsConditionInParens")) visitSupportsConditionInParens(node);
		else if(hasLabel(node, "SupportsNegation")) visitSupportsNegation(node);
		else if(hasLabel(node, "SupportsConjunction")) visitSupportsConjunction(node);
		else if(hasLabel(node, "SupportsDisjunction")) visitSupportsDisjunction(node);
		else if(hasLabel(node, "SupportsDeclarationCondition")) visitSupportsDeclarationCondition(node);
		else if(hasLabel(node, "GeneralEnclosed")) visitGeneralEnclosed(node);
		else if(hasLabel(node, "Var")) visitVar(node);
		else if(hasLabel(node, "Calc")) visitCalc(node);
		else if(hasLabel(node, "CalcSum")) visitCalcSum(node);
		else if(hasLabel(node, "CalcProduct")) visitCalcProduct(node);
		else if(hasLabel(node, "CalcValue")) visitCalcValue(node);
		else if(hasLabel(node, "FontFaceRule")) visitFontFaceRule(node);
		else if(hasLabel(node, "KnownFontFaceDeclaration")) visitKnownFontFaceDeclaration(node);
		else if(hasLabel(node, "UnknownFontFaceDeclaration")) visitUnknownFontFaceDeclaration(node);
		else if(hasLabel(node, "KeyframesRule")) visitKeyframesRule(node);
		else if(hasLabel(node, "KeyframesBlocks")) visitKeyframesBlocks(node);
		else if(hasLabel(node, "KeyframeSelector")) visitKeyframeSelector(node);
		else if(hasLabel(node, "Viewport")) visitViewport(node);
		else if(hasLabel(node, "CounterStyle")) visitCounterStyle(node);
		else if(hasLabel(node, "FontFeatureValuesRule")) visitFontFeatureValuesRule(node);
		else if(hasLabel(node, "FontFamilyNameList")) visitFontFamilyNameList(node);
		else if(hasLabel(node, "FontFamilyName")) visitFontFamilyName(node);
		else if(hasLabel(node, "FeatureValueBlock")) visitFeatureValueBlock(node);
		else if(hasLabel(node, "FeatureType")) visitFeatureType(node);
		else if(hasLabel(node, "FeatureValueDefinition")) visitFeatureValueDefinition(node);
		else if(hasLabel(node, "Ident")) visitIdent(node);
		else if(hasLabel(node, "Ws")) visitWs(node);
   }

	public void visitBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNumber(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStylesheet(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGoodCharset(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBadCharset(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGoodImport(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBadImport(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGoodNamespace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBadNamespace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamespacePrefix(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMedia(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMediaQueryList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMediaQuery(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMediaType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMediaExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMediaFeature(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPage(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPseudoPage(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelectorGroup(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelector(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCombinator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpleSelectorSequence(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeSelector(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeNamespacePrefix(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUniversal(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttrib(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPseudo(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionalPseudo(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNegation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNegationArg(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGoodOperator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBadOperator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGoodProperty(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBadProperty(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKnownRuleset(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnknownRuleset(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclarationList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKnownDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnknownDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrio(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitValue(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKnownTerm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnknownTerm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBadTerm(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDxImageTransform(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHexcolor(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPercentage(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDimension(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnknownDimension(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAny(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnknownAtRule(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAtKeyword(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnused(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNestedStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGroupRuleBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSupportsRule(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSupportsCondition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSupportsConditionInParens(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSupportsNegation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSupportsConjunction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSupportsDisjunction(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSupportsDeclarationCondition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGeneralEnclosed(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVar(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCalc(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCalcSum(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCalcProduct(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCalcValue(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFontFaceRule(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKnownFontFaceDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnknownFontFaceDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKeyframesRule(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKeyframesBlocks(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitKeyframeSelector(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitViewport(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCounterStyle(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFontFeatureValuesRule(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFontFamilyNameList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFontFamilyName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFeatureValueBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFeatureType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFeatureValueDefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdent(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitWs(Node node) {
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