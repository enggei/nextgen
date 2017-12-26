package com.generator.generators.raml;

import org.junit.Test;

public class Tests {
	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Tests.class);
	public static void main(String[] args) {
		new Tests().testRamlGroup();
	}

	//@Test
	public void testRamlGroup() {

		final RamlGroup group = new RamlGroup();

		final RamlGroup.fileST loopsi = group.newfile().
			setTitle("Loopsi REST API").
			setBaseUri("http://localhost:8080/api").
			setVersion("v1");

		log.info(loopsi);
	}
}