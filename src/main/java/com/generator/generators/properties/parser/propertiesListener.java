// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/properties/parser/properties.g4 by ANTLR 4.7
package com.generator.generators.properties.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link propertiesParser}.
 */
public interface propertiesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link propertiesParser#propertiesFile}.
	 * @param ctx the parse tree
	 */
	void enterPropertiesFile(propertiesParser.PropertiesFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link propertiesParser#propertiesFile}.
	 * @param ctx the parse tree
	 */
	void exitPropertiesFile(propertiesParser.PropertiesFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link propertiesParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(propertiesParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link propertiesParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(propertiesParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link propertiesParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(propertiesParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link propertiesParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(propertiesParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link propertiesParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(propertiesParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link propertiesParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(propertiesParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link propertiesParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(propertiesParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link propertiesParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(propertiesParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link propertiesParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(propertiesParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link propertiesParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(propertiesParser.CommentContext ctx);
}