 package com.generator.generators.cpp;
import com.generator.generators.cpp.parser.CPP14Lexer;
import com.generator.generators.cpp.parser.CPP14Parser;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.generator.util.FileUtil.*;

 public class CppTests {

    @Test
   public void testCPPParser() throws IOException {
		 final ANTLRInputStream input = new ANTLRInputStream(new FileReader("/home/sogern/projects/gullkode/nextgen/src/main/java/com/generator/generators/cpp/player.hpp"));
		 final CPP14Lexer lexer = new CPP14Lexer(input);
		 CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		 CPP14Parser parser = new CPP14Parser(tokenStream);
		 final CPP14Parser.TranslationunitContext translationunit = parser.translationunit();
		 System.out.println(translationunit.toStringTree());
	 }

    @Test
   public void testCppGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
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
		 write(headerFileST, new File("/home/sogern/projects/gullkode/nextgen/src/main/java/com/generator/generators/cpp/" + File.separator + className + ".hpp"));
	 }

	 @Test
	 public void helloWorld() {

		 ST hello = new ST("Hello, <name>");
		 hello.add("name", "World");
		 System.out.println(hello.render());

		 STGroup group = new STGroupFile("/home/sogern/projects/gullkode/nextgen/src/main/java/com/generator/generators/cpp/cpp.stg");
		 ST cppClass = group.getInstanceOf("CppClass");
		 cppClass.add("name","XXX");
		 System.out.println(cppClass.render());



	 }
}