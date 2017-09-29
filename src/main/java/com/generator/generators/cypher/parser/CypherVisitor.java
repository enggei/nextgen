// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/cypher/parser/Cypher.g4 by ANTLR 4.7
package com.generator.generators.cypher.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CypherParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CypherVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CypherParser#cypher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCypher(CypherParser.CypherContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CypherParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(CypherParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#regularQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularQuery(CypherParser.RegularQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(CypherParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#singleQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQuery(CypherParser.SingleQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#singlePartQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglePartQuery(CypherParser.SinglePartQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#readOnlyEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadOnlyEnd(CypherParser.ReadOnlyEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#readUpdateEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadUpdateEnd(CypherParser.ReadUpdateEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#updatingEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatingEnd(CypherParser.UpdatingEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#multiPartQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiPartQuery(CypherParser.MultiPartQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#readPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadPart(CypherParser.ReadPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#updatingPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatingPart(CypherParser.UpdatingPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#updatingStartClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatingStartClause(CypherParser.UpdatingStartClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#updatingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatingClause(CypherParser.UpdatingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#readingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadingClause(CypherParser.ReadingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#cyper_match}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCyper_match(CypherParser.Cyper_matchContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#unwind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnwind(CypherParser.UnwindContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#merge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge(CypherParser.MergeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#mergeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeAction(CypherParser.MergeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#create}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(CypherParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(CypherParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#setItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetItem(CypherParser.SetItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(CypherParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#remove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemove(CypherParser.RemoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#removeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveItem(CypherParser.RemoveItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#inQueryCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInQueryCall(CypherParser.InQueryCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#standaloneCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandaloneCall(CypherParser.StandaloneCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#yieldItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldItems(CypherParser.YieldItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#yieldItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldItem(CypherParser.YieldItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#with}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith(CypherParser.WithContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#cypher_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCypher_return(CypherParser.Cypher_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#returnBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnBody(CypherParser.ReturnBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#returnItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnItems(CypherParser.ReturnItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#returnItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnItem(CypherParser.ReturnItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#order}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder(CypherParser.OrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#skip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(CypherParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit(CypherParser.LimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#sortItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortItem(CypherParser.SortItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(CypherParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(CypherParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#patternPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternPart(CypherParser.PatternPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#anonymousPatternPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousPatternPart(CypherParser.AnonymousPatternPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#patternElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternElement(CypherParser.PatternElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#nodePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodePattern(CypherParser.NodePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#patternElementChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternElementChain(CypherParser.PatternElementChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#relationshipPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationshipPattern(CypherParser.RelationshipPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#relationshipDetail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationshipDetail(CypherParser.RelationshipDetailContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(CypherParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#relationshipTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationshipTypes(CypherParser.RelationshipTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#nodeLabels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeLabels(CypherParser.NodeLabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#nodeLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeLabel(CypherParser.NodeLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#rangeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeLiteral(CypherParser.RangeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#labelName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelName(CypherParser.LabelNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#relTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelTypeName(CypherParser.RelTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CypherParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(CypherParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#xorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpression(CypherParser.XorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(CypherParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(CypherParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(CypherParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#addOrSubtractExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOrSubtractExpression(CypherParser.AddOrSubtractExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#multiplyDivideModuloExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyDivideModuloExpression(CypherParser.MultiplyDivideModuloExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#powerOfExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerOfExpression(CypherParser.PowerOfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#unaryAddOrSubtractExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAddOrSubtractExpression(CypherParser.UnaryAddOrSubtractExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#stringListNullOperatorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringListNullOperatorExpression(CypherParser.StringListNullOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#propertyOrLabelsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyOrLabelsExpression(CypherParser.PropertyOrLabelsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(CypherParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CypherParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(CypherParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(CypherParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#partialComparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialComparisonExpression(CypherParser.PartialComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(CypherParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#relationshipsPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationshipsPattern(CypherParser.RelationshipsPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#filterExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterExpression(CypherParser.FilterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#idInColl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdInColl(CypherParser.IdInCollContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(CypherParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(CypherParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#explicitProcedureInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitProcedureInvocation(CypherParser.ExplicitProcedureInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#implicitProcedureInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitProcedureInvocation(CypherParser.ImplicitProcedureInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#procedureResultField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureResultField(CypherParser.ProcedureResultFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#procedureName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureName(CypherParser.ProcedureNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(CypherParser.NamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#listComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehension(CypherParser.ListComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#patternComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternComprehension(CypherParser.PatternComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#propertyLookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyLookup(CypherParser.PropertyLookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#caseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpression(CypherParser.CaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#caseAlternatives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseAlternatives(CypherParser.CaseAlternativesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CypherParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(CypherParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#mapLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapLiteral(CypherParser.MapLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(CypherParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#propertyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyExpression(CypherParser.PropertyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#propertyKeyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyKeyName(CypherParser.PropertyKeyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(CypherParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#doubleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteral(CypherParser.DoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#schemaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaName(CypherParser.SchemaNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#reservedWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedWord(CypherParser.ReservedWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#symbolicName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicName(CypherParser.SymbolicNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#leftArrowHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftArrowHead(CypherParser.LeftArrowHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#rightArrowHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightArrowHead(CypherParser.RightArrowHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CypherParser#dash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDash(CypherParser.DashContext ctx);
}