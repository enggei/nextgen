// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/properties/parser/properties.g4 by ANTLR 4.7
package com.generator.generators.properties.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link propertiesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface propertiesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link propertiesParser#propertiesFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertiesFile(propertiesParser.PropertiesFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link propertiesParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(propertiesParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link propertiesParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(propertiesParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link propertiesParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(propertiesParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link propertiesParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(propertiesParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link propertiesParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(propertiesParser.CommentContext ctx);
}