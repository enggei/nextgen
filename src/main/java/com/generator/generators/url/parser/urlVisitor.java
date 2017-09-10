// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/url/parser/url.g4 by ANTLR 4.7
package com.generator.generators.url.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link urlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface urlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link urlParser#fragmentaddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentaddress(urlParser.FragmentaddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#uri}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUri(urlParser.UriContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(urlParser.UrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#authority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthority(urlParser.AuthorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#host}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHost(urlParser.HostContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#hostname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHostname(urlParser.HostnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#hostnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHostnumber(urlParser.HostnumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#port}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort(urlParser.PortContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(urlParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#search}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch(urlParser.SearchContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#searchparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchparameter(urlParser.SearchparameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUser(urlParser.UserContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#login}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogin(urlParser.LoginContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#password}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassword(urlParser.PasswordContext ctx);
	/**
	 * Visit a parse tree produced by {@link urlParser#fragmentid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentid(urlParser.FragmentidContext ctx);
}