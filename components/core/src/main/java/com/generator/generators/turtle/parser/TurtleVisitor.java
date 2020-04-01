// Generated from /media/Storage/projects/gullkode/nextgen/src/main/java/com/generator/generators/turtle/parser/Turtle.g4 by ANTLR 4.7
package com.generator.generators.turtle.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TurtleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TurtleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TurtleParser#turtleDoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurtleDoc(TurtleParser.TurtleDocContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TurtleParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(TurtleParser.DirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#prefixID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixID(TurtleParser.PrefixIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase(TurtleParser.BaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#sparqlBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSparqlBase(TurtleParser.SparqlBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#sparqlPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSparqlPrefix(TurtleParser.SparqlPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#triples}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriples(TurtleParser.TriplesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#predicateObjectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateObjectList(TurtleParser.PredicateObjectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#objectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectList(TurtleParser.ObjectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#verb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb(TurtleParser.VerbContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject(TurtleParser.SubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(TurtleParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(TurtleParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(TurtleParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#blankNodePropertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankNodePropertyList(TurtleParser.BlankNodePropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection(TurtleParser.CollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#rdfLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRdfLiteral(TurtleParser.RdfLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#iri}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIri(TurtleParser.IriContext ctx);
}