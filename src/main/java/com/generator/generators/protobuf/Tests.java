package com.generator.generators.protobuf;

import com.generator.ProjectConstants;
import com.generator.generators.protobuf.parser.ProtobufLexer;
import com.generator.generators.protobuf.parser.ProtobufNodeListener;
import com.generator.generators.protobuf.parser.ProtobufParser;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Tests {


   @Test
   public void testProtobufParser() throws IOException {
      final ProtobufParser parser = new ProtobufParser(new CommonTokenStream(new ProtobufLexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/protobuf/test.proto"))));
      final ProtobufNodeListener listener = new ProtobufNodeListener();
      new ParseTreeWalker().walk(listener, parser.file());
      visit("", listener.getRoot());
   }

   private void visit(String delim, ProtobufNodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");
      for (ProtobufNodeListener.Node child : node.children) {
         visit(delim + "\t", child);
      }
   }

   @Test
   public void testProtobufGroup() {
      final ProtobufGroup protobufGroup = new ProtobufGroup();

      // test.proto
      final ProtobufGroup.protobufPackageST test = protobufGroup.newprotobufPackage().
            setPackage("com.generator.generators.protobuf").
            addOptionsValue("optimize_for", "SPEED");

      test.addImportsValue("test2");

      int ordinal = 1;
      int innerOrdinal = 1;
      test.addDeliverablesValue(protobufGroup.newmessage().
            setName("MessageOne").
            addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("required").setType("string").setName("node").setOrdinal(ordinal++)).
            addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("required").setType("Type").setName("type").setOrdinal(ordinal++)).
            addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("required").setType("int64").setName("id").setOrdinal(ordinal++)).
            addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("required").setType("int32").setName("localtime").setOrdinal(ordinal++)).
            addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("optional").setType("bytes").setName("data").setOrdinal(ordinal++)).
            addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("optional").setType("ImportedMessage").setName("imported").setOrdinal(ordinal)).
            addPropertiesValue(protobufGroup.newmessage().
                  setName("Result").
                  addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("required").setType("string").setName("url").setOrdinal(innerOrdinal++)).
                  addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("required").setType("string").setName("title").setOrdinal(innerOrdinal++)).
                  addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("repeated").setType("string").setName("snippets").setOrdinal(innerOrdinal++)).
                  addPropertiesValue(protobufGroup.newmessageField().setFieldConstraint("repeated").setType("int32").setName("values").setPackedValue("true").setOrdinal(innerOrdinal))));

      FileUtil.write(test, new File(ProjectConstants.TEST_ROOT + "/protobuf", "test.proto"));

      // test2.proto
      final ProtobufGroup.protobufPackageST test2 = protobufGroup.newprotobufPackage().
            setPackage("com.generator.generators.protobuf");

      test2.addDeliverablesValue(protobufGroup.newmessage().
            setName("ImportedMessage").
            addPropertiesValue(protobufGroup.newmessageField().
                  setName("node").
                  setType("String").
                  setFieldConstraint("required").setOrdinal(1)));

      FileUtil.write(test2, new File(ProjectConstants.TEST_ROOT + "/protobuf", "test2.proto"));
   }
}