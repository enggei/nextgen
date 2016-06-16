
package com.generator.generators.java;

import org.junit.Test;

public class JavaGroupTests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	final JavaGroup group = new JavaGroup();

	@Test
	public void testJava() {
		// todo add JavaGroup- tests here;

		System.out.println(group.newclass().
			setPackage("package").
			setName("Name").
			setExtends("Extends"));
	}
}