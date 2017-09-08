package com.generator.generators.raml;

import org.junit.Test;

public class Tests {

	public static void main(String[] args) {
		new Tests().testRamlGroup();
	}

	@Test
	public void testRamlGroup() {

		//System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final RamlGroup group = new RamlGroup();

		final RamlGroup.fileST loopsi = group.newfile().
			setTitle("Loopsi REST API").
			setBaseUri("http://localhost:8080/api").
			setVersion("v1");

		System.out.println(loopsi);
	}
}