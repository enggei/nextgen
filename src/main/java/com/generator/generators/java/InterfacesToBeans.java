package com.generator.generators.java;

import com.generator.generators.java.parser.JavaParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import static com.generator.generators.java.parser.JavaParser.createLexer;

/**
 * goe on 6/8/16.
 */
public class InterfacesToBeans {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	public static void main(String[] args) throws IOException {

		final String file = "/media/storage/nextgen/src/main/java/com/generator/generators/protobuf/domain/ProtobufMessage.java";

		final JavaGroup javaGroup = new JavaGroup();

		final Stack<JavaGroup.classST> classSTs = new Stack<>();
		final Stack<JavaGroup.methodST> methodsSTs = new Stack<>();

		new JavaParser(createLexer(new FileReader(new File(file)))) {
			@Override
			public void packageName(String name) {


			}

			@Override
			public void importName(String packageName, String name) {
			}

			@Override
			public void className(String modifier, String name) {

			}

			@Override
			public void interfaceName(String name) {

				final JavaGroup.classST newclass = javaGroup.newclass().
					setName(name + "Bean").
					addImplementValue(name);

				classSTs.push(newclass);
			}

			@Override
			public void annotationName(String name) {

			}

			@Override
			public void newBlock() {

			}

			@Override
			public void endBlock() { }

			@Override
			public void newLocalVariableStatement(String statement) {

			}

			@Override
			public void newStatement(String statement) {

			}

			@Override
			public void newTypeDeclaration(String declaration) {

			}

			@Override
			public void interfaceExtends(String name) {
				final String[] s = name.split(",");
			}

			@Override
			public void enumName(String name) {

			}

			@Override
			public void newMethod(String returnType, String name) {

				final JavaGroup.methodST methodST = javaGroup.newmethod().
					setName(name).
					setReturnVal(returnType);

				methodsSTs.add(methodST);
			}

			@Override
			public void newParameter(String modifier, String type, String name) {
				methodsSTs.peek().addParamsValue(null, null, null, null, null, null, name, type, null);
			}

			@Override
			public void newField(String modifier, String type, String name, String initalizer) {

			}

			@Override
			public void endMethod(String methodBody) {
				classSTs.peek().addMethodsValue(methodsSTs.pop());
			}

		}.compilationUnit();

		for (JavaGroup.classST classST : classSTs) {
			System.out.println(classST);
		}
	}
}