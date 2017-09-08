// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/stringtemplate/parser/STGParser.g4 by ANTLR 4.7
package com.generator.generators.stringtemplate.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link STGParser}.
 */
public interface STGParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link STGParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(STGParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(STGParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#delimiters}.
	 * @param ctx the parse tree
	 */
	void enterDelimiters(STGParser.DelimitersContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#delimiters}.
	 * @param ctx the parse tree
	 */
	void exitDelimiters(STGParser.DelimitersContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(STGParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(STGParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(STGParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(STGParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#formalArgs}.
	 * @param ctx the parse tree
	 */
	void enterFormalArgs(STGParser.FormalArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#formalArgs}.
	 * @param ctx the parse tree
	 */
	void exitFormalArgs(STGParser.FormalArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#formalArg}.
	 * @param ctx the parse tree
	 */
	void enterFormalArg(STGParser.FormalArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#formalArg}.
	 * @param ctx the parse tree
	 */
	void exitFormalArg(STGParser.FormalArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#dict}.
	 * @param ctx the parse tree
	 */
	void enterDict(STGParser.DictContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#dict}.
	 * @param ctx the parse tree
	 */
	void exitDict(STGParser.DictContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#dictPairs}.
	 * @param ctx the parse tree
	 */
	void enterDictPairs(STGParser.DictPairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#dictPairs}.
	 * @param ctx the parse tree
	 */
	void exitDictPairs(STGParser.DictPairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyValuePair(STGParser.KeyValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyValuePair(STGParser.KeyValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#defaultValuePair}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValuePair(STGParser.DefaultValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#defaultValuePair}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValuePair(STGParser.DefaultValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link STGParser#keyValue}.
	 * @param ctx the parse tree
	 */
	void enterKeyValue(STGParser.KeyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link STGParser#keyValue}.
	 * @param ctx the parse tree
	 */
	void exitKeyValue(STGParser.KeyValueContext ctx);
}