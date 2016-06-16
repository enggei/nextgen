// Generated from src/com/generator/generators/protobuf/parser/Protobuf.g4 by ANTLR 4.1
package com.generator.generators.protobuf.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link com.generator.generators.protobuf.parser.ProtobufParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProtobufVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#propertyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyName(@NotNull ProtobufParser.PropertyNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#packageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDecl(@NotNull ProtobufParser.PackageDeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(@NotNull ProtobufParser.PackageNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#messageContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageContent(@NotNull ProtobufParser.MessageContentContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#extensionMax}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensionMax(@NotNull ProtobufParser.ExtensionMaxContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(@NotNull ProtobufParser.PropertyContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#extensions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensions(@NotNull ProtobufParser.ExtensionsContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(@NotNull ProtobufParser.ImportsContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(@NotNull ProtobufParser.MessageContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#propertyType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyType(@NotNull ProtobufParser.PropertyTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(@NotNull ProtobufParser.FileContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#enumName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumName(@NotNull ProtobufParser.EnumNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(@NotNull ProtobufParser.DefaultValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(@NotNull ProtobufParser.OptionContext ctx);
}