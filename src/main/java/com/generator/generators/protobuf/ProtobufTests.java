package com.generator.generators.protobuf;

import com.generator.generators.protobuf.parser.ProtobufParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class ProtobufTests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	final ProtobufGroup group = new ProtobufGroup();

	@Test
	public void testProtobufGroup() {
		// todo add ProtobufGroup- tests here;

	}

	@Test
	public void testParser() throws IOException {

		final String testFile = "src/main/java/com/generator/generators/protobuf/test.proto";

		ProtobufParser parser = new ProtobufParser(ProtobufParser.createLexer(new FileReader(testFile))) {

			@Override
			public void packageName(String name) {
				System.out.println("package: " + name);
			}

			@Override
			public void newMessage(String name, String comment) {
				System.out.println("New message: " + name + " comment: " + comment);
			}

			@Override
			public void newProperty(FieldRules rule, String propertyType, String propertyName, Integer ordinal, String comment, String parent, String defaultValue) {
				switch (rule) {
					case required:
						System.out.println("\tproperty " + rule + " " + propertyType + " " + (parent != null ? ("(PARENT: " + parent + ") ") : "") + propertyName + " " + ordinal + " comment: " + comment + " default:" + defaultValue);
						break;
					case optional:
						System.out.println("\tproperty " + rule + " " + propertyType + " " + (parent != null ? ("(PARENT: " + parent + ") ") : "") + propertyName + " " + ordinal + " comment: " + comment + " default:" + defaultValue);
						break;
					case repeated:
						System.out.println("\tproperty " + rule + " " + propertyType + " " + (parent != null ? ("(PARENT: " + parent + ") ") : "") + propertyName + " " + ordinal + " comment: " + comment + " default:" + defaultValue);
						break;
				}
			}

			@Override
			public void newExtensions(String min, String max) {
				System.out.println("new extensions: " + min + " - " + max);
			}

			@Override
			public void newEnum(String name, String comment) {
				System.out.println("new enum: " + name + ", comment: " + comment);
			}

			@Override
			public void newEnumValue(String name, Integer ordinal, String comment) {
				System.out.println("\tnew enum value: " + name + " " + ordinal);
			}

			@Override
			public void newExtension(String name) {
				System.out.println("new extension: " + name);
			}
		};

		// begin parsing at init rule
		ParseTree tree = parser.file();

		// print LISP-style tree
		System.out.println(tree.toStringTree(parser));
	}
} 