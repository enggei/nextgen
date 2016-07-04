package com.generator.generators.raml;

import org.junit.Test;

public class RamlTests {

	public static void main(String[] args) {
		new RamlTests().testRamlGroup();
	}

	@Test
	public void testRamlGroup() {

		//System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final RamlGroup group = new RamlGroup();

		final RamlGroup.fileST loopsi = group.newfile().
			setTitle("Loopsi REST API").
			setBaseUri("http://localhost:8080/api").
			setVersion("v1");
	}

	private static RamlGroup.stringParamST newStringParam(RamlGroup group, String name, String description, boolean required, int maxLength) {
		return group.newstringParam().
			setName(name).
			setDescription(description).
			setRequired(required).
			setMaxLength(maxLength);
	}

	private static RamlGroup.booleanParamST newBooleanParam(RamlGroup group, String name, String description, boolean required) {
		return group.newbooleanParam().
			setName(name).
			setDescription(description).
			setRequired(required);
	}
}