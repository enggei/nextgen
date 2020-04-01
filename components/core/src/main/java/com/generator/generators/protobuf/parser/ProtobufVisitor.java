// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/protobuf/parser/Protobuf.g4 by ANTLR 4.7
package com.generator.generators.protobuf.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProtobufParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProtobufVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(ProtobufParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#packageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDecl(ProtobufParser.PackageDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(ProtobufParser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(ProtobufParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(ProtobufParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(ProtobufParser.MessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#enumName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumName(ProtobufParser.EnumNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#messageContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageContent(ProtobufParser.MessageContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(ProtobufParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(ProtobufParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#packedValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackedValue(ProtobufParser.PackedValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#extensions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensions(ProtobufParser.ExtensionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#propertyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyName(ProtobufParser.PropertyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#propertyType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyType(ProtobufParser.PropertyTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProtobufParser#extensionMax}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensionMax(ProtobufParser.ExtensionMaxContext ctx);
}