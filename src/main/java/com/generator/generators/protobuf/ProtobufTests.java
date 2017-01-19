package com.generator.generators.protobuf;

import com.generator.generators.protobuf.parser.ProtobufParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProtobufTests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	final ProtobufGroup group = new ProtobufGroup();

	@Test
	public void testDomainConstraintsForProtobuf() {

		// this is a programmatic test for protobuf-domain
		final File file = new File("/media/storage/nextgen/src/main/java/com/generator/generators/protobuf/Protobuf.stg");

//		final TemplateGroupConstraints protobufConstraints = new TemplateGroupConstraints();
//
//		// constraints for protobufPackage (is root, and deliverables-parameter can only accept templates (enum, extend or message)
//		protobufConstraints.addRoot("protobufPackage");
//		protobufConstraints.addStatementConstraint(new TemplateGroupConstraints.TemplateStatementConstraint("protobufPackage").
//			addParameterConstraint(new TemplateGroupConstraints.TemplateParameterConstraint("deliverables").
//				addAllowedTemplate("enum").
//				addAllowedTemplate("extend").
//				addAllowedTemplate("message")));
//
//		//todo: add support for dynamic-values (e.g. all new messages)
//		//todo: add support for optional/required- parameters
//		protobufConstraints.addStatementConstraint(new TemplateGroupConstraints.TemplateStatementConstraint("messageField").
//			addParameterConstraint(new TemplateGroupConstraints.TemplateParameterConstraint("fieldConstraint").
//				addAllowedValue("required").
//				addAllowedValue("repeated").
//				addAllowedValue("optional")).
//
//			addParameterConstraint(new TemplateGroupConstraints.TemplateParameterConstraint("type").
//				addAllowedValue("bytes").
//				addAllowedValue("string").
//				addAllowedValue("bool").
//				addAllowedValue("sfixed64").
//				addAllowedValue("sfixed32").
//				addAllowedValue("fixed64").
//				addAllowedValue("fixed32").
//				addAllowedValue("sint64").
//				addAllowedValue("sint32").
//				addAllowedValue("uint64").
//				addAllowedValue("uin32").
//				addAllowedValue("int64").
//				addAllowedValue("int32").
//				addAllowedValue("float").
//				addAllowedValue("double")).
//			addParameterConstraint(new TemplateGroupConstraints.TemplateParameterConstraint("packedValue").
//				isTrueFalseValue()));
//
//		protobufConstraints.addStatementConstraint(new TemplateGroupConstraints.TemplateStatementConstraint("message").
//			addParameterConstraint(new TemplateGroupConstraints.TemplateParameterConstraint("properties").
//				addAllowedValue("messageField").
//				addAllowedValue("extensions").
//				addAllowedValue("message").
//				addAllowedValue("enum")));

	}

	@Test
	public void testProtobufGroup() {
		// todo add ProtobufGroup- tests here;

		// test2.proto
		final ProtobufGroup.protobufPackageST test2 = group.newprotobufPackage().
			setPackage("com.generator.generators.protobuf");

		test2.addDeliverablesValue(group.newmessage().
			setName("ImportedMessage").
			addPropertiesValue(group.newmessageField().
				setName("node").
				setType("String").
				setFieldConstraint("required")));

		System.out.println(test2);

		// test.proto
		final ProtobufGroup.protobufPackageST test = group.newprotobufPackage().
			setPackage("com.generator.generators.protobuf").
			addOptionsValue("optimize_for", "SPEED");

		test.addImportsValue("test2");

		int ordinal = 1;
		int innerOrdinal = 1;
		test.addDeliverablesValue(group.newmessage().
			setName("MessageOne").
			addPropertiesValue(group.newmessageField().setFieldConstraint("required").setType("string").setName("node").setOrdinal(ordinal++)).
			addPropertiesValue(group.newmessageField().setFieldConstraint("required").setType("Type").setName("type").setOrdinal(ordinal++)).
			addPropertiesValue(group.newmessageField().setFieldConstraint("required").setType("int64").setName("id").setOrdinal(ordinal++)).
			addPropertiesValue(group.newmessageField().setFieldConstraint("required").setType("int32").setName("localtime").setOrdinal(ordinal++)).
			addPropertiesValue(group.newmessageField().setFieldConstraint("optional").setType("bytes").setName("data").setOrdinal(ordinal++)).
			addPropertiesValue(group.newmessageField().setFieldConstraint("optional").setType("ImportedMessage").setName("imported").setOrdinal(ordinal)).
			addPropertiesValue(group.newmessage().
				setName("Result").
				addPropertiesValue(group.newmessageField().setFieldConstraint("required").setType("string").setName("url").setOrdinal(innerOrdinal++)).
				addPropertiesValue(group.newmessageField().setFieldConstraint("required").setType("string").setName("title").setOrdinal(innerOrdinal++)).
				addPropertiesValue(group.newmessageField().setFieldConstraint("repeated").setType("string").setName("snippets").setOrdinal(innerOrdinal++)).
				addPropertiesValue(group.newmessageField().setFieldConstraint("repeated").setType("int32").setName("values").setPackedValue("true").setOrdinal(innerOrdinal))));

		System.out.println(test);

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
			public void newProperty(FieldRules rule, String propertyType, String propertyName, Integer ordinal, String comment, String parent, String defaultValue, String packedValue) {
				switch (rule) {
					case required:
						System.out.println("\tproperty " + rule + " " + propertyType + " " + (parent != null ? ("(PARENT: " + parent + ") ") : "") + propertyName + " " + ordinal + " comment: " + comment + " default:" + defaultValue + " packed:" + packedValue);
						break;
					case optional:
						System.out.println("\tproperty " + rule + " " + propertyType + " " + (parent != null ? ("(PARENT: " + parent + ") ") : "") + propertyName + " " + ordinal + " comment: " + comment + " default:" + defaultValue + " packed:" + packedValue);
						break;
					case repeated:
						System.out.println("\tproperty " + rule + " " + propertyType + " " + (parent != null ? ("(PARENT: " + parent + ") ") : "") + propertyName + " " + ordinal + " comment: " + comment + " default:" + defaultValue + " packed:" + packedValue);
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