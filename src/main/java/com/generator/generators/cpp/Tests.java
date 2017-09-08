package com.generator.generators.cpp;

import com.generator.ProjectConstants;
import com.generator.generators.cpp.parser.CPP14Lexer;
import com.generator.generators.cpp.parser.CPP14NodeListener;
import com.generator.generators.cpp.parser.CPP14Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.generator.util.FileUtil.write;

public class Tests {

   @Test
   public void testCPPParser() throws IOException {
      final CPP14Parser parser = new CPP14Parser(new CommonTokenStream(new CPP14Lexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/cpp/player.hpp"))));
      final CPP14NodeListener listener = new CPP14NodeListener();
      new ParseTreeWalker().walk(listener, parser.translationunit());
      visitAll("", listener.getRoot());
   }

   private void visitAll(String delim, CPP14NodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.startToken + ")");
      for (CPP14NodeListener.Node child : node.children) {
         visitAll(delim + "\t", child);
      }
   }

   @Test
   public void testCppGroup() {

      final CppGroup group = new CppGroup();

      // todo add CppGroup- tests here;

      final String className = "player";
      final String namespaceName = "test";

      final CppGroup.HeaderFileST headerFileST = group.newHeaderFile().
            setName(className).
            addIncludesValue("string", true).
            addNamespaceValue(namespaceName).
            addEntryValue(
                  group.newClass().
                        setName(className).
                        addPublicValue(
                              group.newMethod().
                                    setName("doSomething").
                                    setConst(true).
                                    setReturnType(group.newType().
                                          setNamespace("std").
                                          setName("string").
                                          setConst(true).
                                          setReference(true)).
                                    addParametersValue("Value", group.newType().setName("int")).
                                    addParametersValue("constValue", group.newType().setName("long").setConst(true)).
                                    addParametersValue("refValue", group.newType().setName("string").setNamespace("std").setReference(true)).
                                    addParametersValue("constRefValue", group.newType().setName("int").setConst(true).setReference(true))
                        ).
                        addProtectedValue(
                              group.newMethod().
                                    setName("Whatever").
                                    addParametersValue("functionRef", group.newType().setName("void").setPointer(true))
                        ).
                        addPrivateValue(
                              group.newMethod().
                                    setName("abc123").setStatic(true)
                        ).
                        addPrivateValue(
                              group.newMember().setName("StaticVariable").setType(group.newType().setName("int")).setStatic(true)
                        ).
                        addPrivateValue(
                              group.newMember().setName("flag").setType(group.newType().setName("bool"))
                        )
            );

//		 System.out.println(headerFileST);
      write(headerFileST, new File(ProjectConstants.MAIN_ROOT + "/com/generator/generators/cpp/" + File.separator + className + ".hpp"));
   }
}