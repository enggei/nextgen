// Generated from src/com/generator/generators/html/parser/HTMLParser.g4 by ANTLR 4.1
package com.generator.generators.html5.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLParser}.
 */
public interface HTMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttributeValue(@NotNull HTMLParser.HtmlAttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttributeValue(@NotNull HTMLParser.HtmlAttributeValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#xhtmlCDATA}.
	 * @param ctx the parse tree
	 */
	void enterXhtmlCDATA(@NotNull HTMLParser.XhtmlCDATAContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#xhtmlCDATA}.
	 * @param ctx the parse tree
	 */
	void exitXhtmlCDATA(@NotNull HTMLParser.XhtmlCDATAContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void enterHtmlDocument(@NotNull HTMLParser.HtmlDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void exitHtmlDocument(@NotNull HTMLParser.HtmlDocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlTagName}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTagName(@NotNull HTMLParser.HtmlTagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlTagName}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTagName(@NotNull HTMLParser.HtmlTagNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlMisc}.
	 * @param ctx the parse tree
	 */
	void enterHtmlMisc(@NotNull HTMLParser.HtmlMiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlMisc}.
	 * @param ctx the parse tree
	 */
	void exitHtmlMisc(@NotNull HTMLParser.HtmlMiscContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#xml}.
	 * @param ctx the parse tree
	 */
	void enterXml(@NotNull HTMLParser.XmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#xml}.
	 * @param ctx the parse tree
	 */
	void exitXml(@NotNull HTMLParser.XmlContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(@NotNull HTMLParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(@NotNull HTMLParser.ScriptContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#scriptlet}.
	 * @param ctx the parse tree
	 */
	void enterScriptlet(@NotNull HTMLParser.ScriptletContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#scriptlet}.
	 * @param ctx the parse tree
	 */
	void exitScriptlet(@NotNull HTMLParser.ScriptletContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContent(@NotNull HTMLParser.HtmlContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContent(@NotNull HTMLParser.HtmlContentContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlAttributeName}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttributeName(@NotNull HTMLParser.HtmlAttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlAttributeName}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttributeName(@NotNull HTMLParser.HtmlAttributeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlElements}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElements(@NotNull HTMLParser.HtmlElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlElements}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElements(@NotNull HTMLParser.HtmlElementsContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElement(@NotNull HTMLParser.HtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElement(@NotNull HTMLParser.HtmlElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttribute(@NotNull HTMLParser.HtmlAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttribute(@NotNull HTMLParser.HtmlAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlComment}.
	 * @param ctx the parse tree
	 */
	void enterHtmlComment(@NotNull HTMLParser.HtmlCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlComment}.
	 * @param ctx the parse tree
	 */
	void exitHtmlComment(@NotNull HTMLParser.HtmlCommentContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(@NotNull HTMLParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(@NotNull HTMLParser.StyleContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void enterHtmlChardata(@NotNull HTMLParser.HtmlChardataContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void exitHtmlChardata(@NotNull HTMLParser.HtmlChardataContext ctx);

	/**
	 * Enter a parse tree produced by {@link HTMLParser#dtd}.
	 * @param ctx the parse tree
	 */
	void enterDtd(@NotNull HTMLParser.DtdContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#dtd}.
	 * @param ctx the parse tree
	 */
	void exitDtd(@NotNull HTMLParser.DtdContext ctx);
}