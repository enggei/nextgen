// Generated from /media/Storage/projects/gullkode/nextgen/src/main/java/com/generator/generators/sparql/parser/Sparql.g4 by ANTLR 4.7
package com.generator.generators.sparql.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SparqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SparqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SparqlParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(SparqlParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#prologue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrologue(SparqlParser.PrologueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#baseDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseDecl(SparqlParser.BaseDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#prefixDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixDecl(SparqlParser.PrefixDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#selectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQuery(SparqlParser.SelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#constructQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructQuery(SparqlParser.ConstructQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#describeQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescribeQuery(SparqlParser.DescribeQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#askQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAskQuery(SparqlParser.AskQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#datasetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatasetClause(SparqlParser.DatasetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#defaultGraphClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultGraphClause(SparqlParser.DefaultGraphClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#namedGraphClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedGraphClause(SparqlParser.NamedGraphClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#sourceSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceSelector(SparqlParser.SourceSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(SparqlParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#solutionModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolutionModifier(SparqlParser.SolutionModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#limitOffsetClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitOffsetClauses(SparqlParser.LimitOffsetClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#orderClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderClause(SparqlParser.OrderClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#orderCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderCondition(SparqlParser.OrderConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#limitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitClause(SparqlParser.LimitClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#offsetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffsetClause(SparqlParser.OffsetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#groupGraphPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupGraphPattern(SparqlParser.GroupGraphPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#triplesBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriplesBlock(SparqlParser.TriplesBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#graphPatternNotTriples}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphPatternNotTriples(SparqlParser.GraphPatternNotTriplesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#optionalGraphPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalGraphPattern(SparqlParser.OptionalGraphPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#graphGraphPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphGraphPattern(SparqlParser.GraphGraphPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#groupOrUnionGraphPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupOrUnionGraphPattern(SparqlParser.GroupOrUnionGraphPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(SparqlParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(SparqlParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SparqlParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(SparqlParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#constructTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructTemplate(SparqlParser.ConstructTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#constructTriples}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructTriples(SparqlParser.ConstructTriplesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#triplesSameSubject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriplesSameSubject(SparqlParser.TriplesSameSubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#propertyListNotEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyListNotEmpty(SparqlParser.PropertyListNotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#propertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyList(SparqlParser.PropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#objectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectList(SparqlParser.ObjectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(SparqlParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#verb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb(SparqlParser.VerbContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#triplesNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriplesNode(SparqlParser.TriplesNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#blankNodePropertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankNodePropertyList(SparqlParser.BlankNodePropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection(SparqlParser.CollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#graphNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphNode(SparqlParser.GraphNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#varOrTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarOrTerm(SparqlParser.VarOrTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#varOrIRIref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarOrIRIref(SparqlParser.VarOrIRIrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SparqlParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#graphTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphTerm(SparqlParser.GraphTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SparqlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(SparqlParser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(SparqlParser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#valueLogical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueLogical(SparqlParser.ValueLogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(SparqlParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#numericExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericExpression(SparqlParser.NumericExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(SparqlParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(SparqlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(SparqlParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(SparqlParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#brackettedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrackettedExpression(SparqlParser.BrackettedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#builtInCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInCall(SparqlParser.BuiltInCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#regexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexExpression(SparqlParser.RegexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#iriRefOrFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIriRefOrFunction(SparqlParser.IriRefOrFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#rdfLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRdfLiteral(SparqlParser.RdfLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(SparqlParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#numericLiteralUnsigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteralUnsigned(SparqlParser.NumericLiteralUnsignedContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#numericLiteralPositive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteralPositive(SparqlParser.NumericLiteralPositiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#numericLiteralNegative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteralNegative(SparqlParser.NumericLiteralNegativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(SparqlParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(SparqlParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#iriRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIriRef(SparqlParser.IriRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#prefixedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixedName(SparqlParser.PrefixedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparqlParser#blankNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankNode(SparqlParser.BlankNodeContext ctx);
}