package com.generator.generators.javaparser.test;

import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.FileUtil;
import com.github.javaparser.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;

public class TestOutput {
	public static void main(String[] args) {
		
		new PackageDeclaration(new QualifiedNameExpr(new QualifiedNameExpr(new QualifiedNameExpr(new QualifiedNameExpr(new NameExpr("com") , "generator") , "generators") , "javaparser") , "test") ) ;
		new ClassOrInterfaceDeclaration(ModifierSet.PUBLIC, false, "ParserTestClass") ;
		new ConstructorDeclaration(ModifierSet.PUBLIC, "ParserTestClass"); ;
	}
}