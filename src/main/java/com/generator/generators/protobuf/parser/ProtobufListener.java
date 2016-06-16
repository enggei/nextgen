// Generated from src/com/generator/generators/protobuf/parser/Protobuf.g4 by ANTLR 4.1
package com.generator.generators.protobuf.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link com.generator.generators.protobuf.parser.ProtobufParser}.
 */
public interface ProtobufListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void enterPropertyName(@NotNull ProtobufParser.PropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void exitPropertyName(@NotNull ProtobufParser.PropertyNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void enterPackageDecl(@NotNull ProtobufParser.PackageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void exitPackageDecl(@NotNull ProtobufParser.PackageDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(@NotNull ProtobufParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(@NotNull ProtobufParser.PackageNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#messageContent}.
	 * @param ctx the parse tree
	 */
	void enterMessageContent(@NotNull ProtobufParser.MessageContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#messageContent}.
	 * @param ctx the parse tree
	 */
	void exitMessageContent(@NotNull ProtobufParser.MessageContentContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#extensionMax}.
	 * @param ctx the parse tree
	 */
	void enterExtensionMax(@NotNull ProtobufParser.ExtensionMaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#extensionMax}.
	 * @param ctx the parse tree
	 */
	void exitExtensionMax(@NotNull ProtobufParser.ExtensionMaxContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(@NotNull ProtobufParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(@NotNull ProtobufParser.PropertyContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#extensions}.
	 * @param ctx the parse tree
	 */
	void enterExtensions(@NotNull ProtobufParser.ExtensionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#extensions}.
	 * @param ctx the parse tree
	 */
	void exitExtensions(@NotNull ProtobufParser.ExtensionsContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(@NotNull ProtobufParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(@NotNull ProtobufParser.ImportsContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(@NotNull ProtobufParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(@NotNull ProtobufParser.MessageContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void enterPropertyType(@NotNull ProtobufParser.PropertyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void exitPropertyType(@NotNull ProtobufParser.PropertyTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull ProtobufParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull ProtobufParser.FileContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#enumName}.
	 * @param ctx the parse tree
	 */
	void enterEnumName(@NotNull ProtobufParser.EnumNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#enumName}.
	 * @param ctx the parse tree
	 */
	void exitEnumName(@NotNull ProtobufParser.EnumNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(@NotNull ProtobufParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(@NotNull ProtobufParser.DefaultValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(@NotNull ProtobufParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.generator.generators.protobuf.parser.ProtobufParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(@NotNull ProtobufParser.OptionContext ctx);
}