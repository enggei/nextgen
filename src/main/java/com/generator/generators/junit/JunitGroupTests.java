
package com.generator.generators.junit;

import org.junit.Test;

public class JunitGroupTests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	final JunitGroup group = new JunitGroup();

	@Test
	public void testJunit() {
		// todo add JunitGroup- tests here;

		System.out.println(group.
			newtests().
			addTestsValue(group.newtest().
				setName("TestONE").
				addStatementsValue("System.out.println(\"TEST ONE\");")));
	}
}