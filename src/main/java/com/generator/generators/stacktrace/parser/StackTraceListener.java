// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/stacktrace/parser/StackTrace.g4 by ANTLR 4.7
package com.generator.generators.stacktrace.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StackTraceParser}.
 */
public interface StackTraceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#startRule}.
	 * @param ctx the parse tree
	 */
	void enterStartRule(StackTraceParser.StartRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#startRule}.
	 * @param ctx the parse tree
	 */
	void exitStartRule(StackTraceParser.StartRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#stackTrace}.
	 * @param ctx the parse tree
	 */
	void enterStackTrace(StackTraceParser.StackTraceContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#stackTrace}.
	 * @param ctx the parse tree
	 */
	void exitStackTrace(StackTraceParser.StackTraceContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#stackTraceLine}.
	 * @param ctx the parse tree
	 */
	void enterStackTraceLine(StackTraceParser.StackTraceLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#stackTraceLine}.
	 * @param ctx the parse tree
	 */
	void exitStackTraceLine(StackTraceParser.StackTraceLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#atLine}.
	 * @param ctx the parse tree
	 */
	void enterAtLine(StackTraceParser.AtLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#atLine}.
	 * @param ctx the parse tree
	 */
	void exitAtLine(StackTraceParser.AtLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#causedByLine}.
	 * @param ctx the parse tree
	 */
	void enterCausedByLine(StackTraceParser.CausedByLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#causedByLine}.
	 * @param ctx the parse tree
	 */
	void exitCausedByLine(StackTraceParser.CausedByLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#ellipsisLine}.
	 * @param ctx the parse tree
	 */
	void enterEllipsisLine(StackTraceParser.EllipsisLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#ellipsisLine}.
	 * @param ctx the parse tree
	 */
	void exitEllipsisLine(StackTraceParser.EllipsisLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#messageLine}.
	 * @param ctx the parse tree
	 */
	void enterMessageLine(StackTraceParser.MessageLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#messageLine}.
	 * @param ctx the parse tree
	 */
	void exitMessageLine(StackTraceParser.MessageLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#qualifiedClass}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedClass(StackTraceParser.QualifiedClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#qualifiedClass}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedClass(StackTraceParser.QualifiedClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#innerClassName}.
	 * @param ctx the parse tree
	 */
	void enterInnerClassName(StackTraceParser.InnerClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#innerClassName}.
	 * @param ctx the parse tree
	 */
	void exitInnerClassName(StackTraceParser.InnerClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#classFile}.
	 * @param ctx the parse tree
	 */
	void enterClassFile(StackTraceParser.ClassFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#classFile}.
	 * @param ctx the parse tree
	 */
	void exitClassFile(StackTraceParser.ClassFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#qualifiedMethod}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedMethod(StackTraceParser.QualifiedMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#qualifiedMethod}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedMethod(StackTraceParser.QualifiedMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(StackTraceParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(StackTraceParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(StackTraceParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(StackTraceParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#packagePath}.
	 * @param ctx the parse tree
	 */
	void enterPackagePath(StackTraceParser.PackagePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#packagePath}.
	 * @param ctx the parse tree
	 */
	void exitPackagePath(StackTraceParser.PackagePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(StackTraceParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(StackTraceParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(StackTraceParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(StackTraceParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link StackTraceParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(StackTraceParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link StackTraceParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(StackTraceParser.MessageContext ctx);
}