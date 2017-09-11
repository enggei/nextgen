// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/stacktrace/parser/StackTrace.g4 by ANTLR 4.7
package com.generator.generators.stacktrace.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StackTraceParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StackTraceVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#startRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartRule(StackTraceParser.StartRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#stackTrace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStackTrace(StackTraceParser.StackTraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#stackTraceLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStackTraceLine(StackTraceParser.StackTraceLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#atLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtLine(StackTraceParser.AtLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#causedByLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCausedByLine(StackTraceParser.CausedByLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#ellipsisLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEllipsisLine(StackTraceParser.EllipsisLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#messageLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageLine(StackTraceParser.MessageLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#qualifiedClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedClass(StackTraceParser.QualifiedClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#innerClassName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerClassName(StackTraceParser.InnerClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#classFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassFile(StackTraceParser.ClassFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#qualifiedMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedMethod(StackTraceParser.QualifiedMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(StackTraceParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(StackTraceParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#packagePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackagePath(StackTraceParser.PackagePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(StackTraceParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(StackTraceParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link StackTraceParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(StackTraceParser.MessageContext ctx);
}