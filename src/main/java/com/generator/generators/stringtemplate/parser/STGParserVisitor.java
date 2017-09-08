// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/stringtemplate/parser/STGParser.g4 by ANTLR 4.7
package com.generator.generators.stringtemplate.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link STGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface STGParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link STGParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(STGParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#delimiters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelimiters(STGParser.DelimitersContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(STGParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(STGParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#formalArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArgs(STGParser.FormalArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#formalArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArg(STGParser.FormalArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#dict}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict(STGParser.DictContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#dictPairs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictPairs(STGParser.DictPairsContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValuePair(STGParser.KeyValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#defaultValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValuePair(STGParser.DefaultValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link STGParser#keyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValue(STGParser.KeyValueContext ctx);
}