package com.generator.generators.templates.parser;

import com.generator.util.FileUtil;
import org.antlr.runtime.tree.Tree;

import java.io.File;

/**
 * User: goe
 * Date: 09.09.13
 */
public class Debugger {

   private final StringBuilder out = new StringBuilder();
   private int branch = 0;

   public void newStatement() {
      out.append("\n");
      branch = 0;
   }

   public void done(File file) {
		System.out.println("Test relative path");
		FileUtil.write(out.toString().trim(), new File("src/com/generator/generators/templates/debug/" + file.getName().substring(0, file.getName().length() - 4) + "_debug.txt"));
   }

   public void onType(Tree ast) {
//      out.append(tabs(branch)).append("|").append(ast.getType()).append("|").append(("" + ast.getText()).replaceAll("\r\n", "\\\\r\\\\n").replaceAll("\n", "\\\\n")).append("|").append(ast.toStringTree().replaceAll("\r\n", "\\\\r\\\\n").replaceAll("\n", "\\\\n")).append("\n");
      out.append(tabs(branch)).append("|").append(ast.getType()).append("|").append(("" + ast.getText()).replaceAll("\r\n", "\\\\r\\\\n").replaceAll("\n", "\\\\n")).append("|").append("\n");
   }

   private String tabs(int branch) {
      StringBuilder out = new StringBuilder();
      for (int i = 0; i < branch; i++) out.append("\t");
      return out.toString();
   }

   public Debugger inc() {
      branch++;
      return this;
   }

   public Debugger dec() {
      branch--;
      return this;
   }
}