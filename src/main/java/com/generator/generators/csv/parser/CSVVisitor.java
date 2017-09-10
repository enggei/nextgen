// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/csv/parser/CSV.g4 by ANTLR 4.7
package com.generator.generators.csv.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSVParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CSVVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CSVParser#csvFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCsvFile(CSVParser.CsvFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVParser#hdr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHdr(CSVParser.HdrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(CSVParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(CSVParser.FieldContext ctx);
}