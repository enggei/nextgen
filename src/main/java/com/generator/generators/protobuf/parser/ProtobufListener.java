// Generated from src/main/java/com/generator/generators/protobuf/parser/Protobuf.g4 by ANTLR 4.5.3
package com.generator.generators.protobuf.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProtobufParser}.
 */
public interface ProtobufListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(ProtobufParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(ProtobufParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void enterPackageDecl(ProtobufParser.PackageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void exitPackageDecl(ProtobufParser.PackageDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(ProtobufParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(ProtobufParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(ProtobufParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(ProtobufParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(ProtobufParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(ProtobufParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(ProtobufParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(ProtobufParser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#enumName}.
	 * @param ctx the parse tree
	 */
	void enterEnumName(ProtobufParser.EnumNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#enumName}.
	 * @param ctx the parse tree
	 */
	void exitEnumName(ProtobufParser.EnumNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#messageContent}.
	 * @param ctx the parse tree
	 */
	void enterMessageContent(ProtobufParser.MessageContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#messageContent}.
	 * @param ctx the parse tree
	 */
	void exitMessageContent(ProtobufParser.MessageContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(ProtobufParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(ProtobufParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(ProtobufParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(ProtobufParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#packedValue}.
	 * @param ctx the parse tree
	 */
	void enterPackedValue(ProtobufParser.PackedValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#packedValue}.
	 * @param ctx the parse tree
	 */
	void exitPackedValue(ProtobufParser.PackedValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#extensions}.
	 * @param ctx the parse tree
	 */
	void enterExtensions(ProtobufParser.ExtensionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#extensions}.
	 * @param ctx the parse tree
	 */
	void exitExtensions(ProtobufParser.ExtensionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void enterPropertyName(ProtobufParser.PropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void exitPropertyName(ProtobufParser.PropertyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void enterPropertyType(ProtobufParser.PropertyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void exitPropertyType(ProtobufParser.PropertyTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufParser#extensionMax}.
	 * @param ctx the parse tree
	 */
	void enterExtensionMax(ProtobufParser.ExtensionMaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufParser#extensionMax}.
	 * @param ctx the parse tree
	 */
	void exitExtensionMax(ProtobufParser.ExtensionMaxContext ctx);
}