// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/url/parser/url.g4 by ANTLR 4.7
package com.generator.generators.url.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link urlParser}.
 */
public interface urlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link urlParser#fragmentaddress}.
	 * @param ctx the parse tree
	 */
	void enterFragmentaddress(urlParser.FragmentaddressContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#fragmentaddress}.
	 * @param ctx the parse tree
	 */
	void exitFragmentaddress(urlParser.FragmentaddressContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#uri}.
	 * @param ctx the parse tree
	 */
	void enterUri(urlParser.UriContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#uri}.
	 * @param ctx the parse tree
	 */
	void exitUri(urlParser.UriContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(urlParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(urlParser.UrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#authority}.
	 * @param ctx the parse tree
	 */
	void enterAuthority(urlParser.AuthorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#authority}.
	 * @param ctx the parse tree
	 */
	void exitAuthority(urlParser.AuthorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#host}.
	 * @param ctx the parse tree
	 */
	void enterHost(urlParser.HostContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#host}.
	 * @param ctx the parse tree
	 */
	void exitHost(urlParser.HostContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#hostname}.
	 * @param ctx the parse tree
	 */
	void enterHostname(urlParser.HostnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#hostname}.
	 * @param ctx the parse tree
	 */
	void exitHostname(urlParser.HostnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#hostnumber}.
	 * @param ctx the parse tree
	 */
	void enterHostnumber(urlParser.HostnumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#hostnumber}.
	 * @param ctx the parse tree
	 */
	void exitHostnumber(urlParser.HostnumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(urlParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(urlParser.PortContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(urlParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(urlParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#search}.
	 * @param ctx the parse tree
	 */
	void enterSearch(urlParser.SearchContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#search}.
	 * @param ctx the parse tree
	 */
	void exitSearch(urlParser.SearchContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#searchparameter}.
	 * @param ctx the parse tree
	 */
	void enterSearchparameter(urlParser.SearchparameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#searchparameter}.
	 * @param ctx the parse tree
	 */
	void exitSearchparameter(urlParser.SearchparameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#user}.
	 * @param ctx the parse tree
	 */
	void enterUser(urlParser.UserContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#user}.
	 * @param ctx the parse tree
	 */
	void exitUser(urlParser.UserContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#login}.
	 * @param ctx the parse tree
	 */
	void enterLogin(urlParser.LoginContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#login}.
	 * @param ctx the parse tree
	 */
	void exitLogin(urlParser.LoginContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#password}.
	 * @param ctx the parse tree
	 */
	void enterPassword(urlParser.PasswordContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#password}.
	 * @param ctx the parse tree
	 */
	void exitPassword(urlParser.PasswordContext ctx);
	/**
	 * Enter a parse tree produced by {@link urlParser#fragmentid}.
	 * @param ctx the parse tree
	 */
	void enterFragmentid(urlParser.FragmentidContext ctx);
	/**
	 * Exit a parse tree produced by {@link urlParser#fragmentid}.
	 * @param ctx the parse tree
	 */
	void exitFragmentid(urlParser.FragmentidContext ctx);
}