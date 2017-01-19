package com.generator.generators.java;

import com.generator.util.FileUtil;
import com.github.javaparser.ParseException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JavaTests {

   @Test
   public void testJavaGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final JavaGroup group = new JavaGroup();

      // todo add JavaGroup- tests here;

   }

   @Test
   public void testJavaParsingVisitor() throws IOException, ParseException {

      File[] list = FileUtil.list("/home/goe/udc/trailer-report/src/main/java/com/ud/tr/domain", ".java");

      for (int i = 0; i < list.length; i++) {
         File file = list[i];
         System.out.println(file);

      }
   }
}