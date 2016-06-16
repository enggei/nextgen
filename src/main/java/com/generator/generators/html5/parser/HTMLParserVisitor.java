// Generated from src/com/generator/generators/html/parser/HTMLParser.g4 by ANTLR 4.1
package com.generator.generators.html5.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttributeValue(@NotNull HTMLParser.HtmlAttributeValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#xhtmlCDATA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXhtmlCDATA(@NotNull HTMLParser.XhtmlCDATAContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(@NotNull HTMLParser.HtmlDocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTagName(@NotNull HTMLParser.HtmlTagNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlMisc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlMisc(@NotNull HTMLParser.HtmlMiscContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXml(@NotNull HTMLParser.XmlContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(@NotNull HTMLParser.ScriptContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#scriptlet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptlet(@NotNull HTMLParser.ScriptletContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlContent(@NotNull HTMLParser.HtmlContentContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlAttributeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttributeName(@NotNull HTMLParser.HtmlAttributeNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElements(@NotNull HTMLParser.HtmlElementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(@NotNull HTMLParser.HtmlElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttribute(@NotNull HTMLParser.HtmlAttributeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlComment(@NotNull HTMLParser.HtmlCommentContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle(@NotNull HTMLParser.StyleContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlChardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlChardata(@NotNull HTMLParser.HtmlChardataContext ctx);

	/**
	 * Visit a parse tree produced by {@link HTMLParser#dtd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDtd(@NotNull HTMLParser.DtdContext ctx);
}