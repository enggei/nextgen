// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/graphQL/parser/GraphQL.g4 by ANTLR 4.7
package com.generator.generators.graphQL.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GraphQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GraphQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(GraphQLParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(GraphQLParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#operationDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationDefinition(GraphQLParser.OperationDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#selectionSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionSet(GraphQLParser.SelectionSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#operationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationType(GraphQLParser.OperationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(GraphQLParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(GraphQLParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(GraphQLParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias(GraphQLParser.AliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(GraphQLParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(GraphQLParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#fragmentSpread}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentSpread(GraphQLParser.FragmentSpreadContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#inlineFragment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineFragment(GraphQLParser.InlineFragmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#fragmentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentDefinition(GraphQLParser.FragmentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#fragmentName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentName(GraphQLParser.FragmentNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#directives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectives(GraphQLParser.DirectivesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(GraphQLParser.DirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#typeCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCondition(GraphQLParser.TypeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#variableDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinitions(GraphQLParser.VariableDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(GraphQLParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(GraphQLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(GraphQLParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#valueOrVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueOrVariable(GraphQLParser.ValueOrVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link GraphQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(GraphQLParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link GraphQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(GraphQLParser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link GraphQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(GraphQLParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link GraphQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(GraphQLParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GraphQLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(GraphQLParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#listType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(GraphQLParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#nonNullType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonNullType(GraphQLParser.NonNullTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQLParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(GraphQLParser.ArrayContext ctx);
}