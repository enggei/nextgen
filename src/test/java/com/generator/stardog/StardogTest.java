package com.generator.stardog;

import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@RunWith(VertxUnitRunner.class)
public class StardogTest extends StardogTestSession {

	private static final Logger log = LoggerFactory.getLogger(StardogTest.class);

	@Test
	public void testAdminConnection(TestContext context) {

		final TestSession session = new TestSession(context);

		session.doTestAdminConnect(result -> {
			log.info("Result:\n" + result);
			session.done();
		});
	}

	@Test
	public void testGetGraphs(TestContext context) throws IOException {
		final String query = "select distinct ?g where {\n" +
			"   graph ?g {\n" +
			"      ?s ?p ?o\n" +
			"   }\n" +
			"}";

		final TestSession session = new TestSession(context);

		session.doTestConnection(query, result -> {
			log.info("Result:\n" + result);
			session.done();
		});

//		session.doTestRepositoryConnection(query, result -> {
//			log.info("Result:\n" + result);
//			session.done();
//		});
	}


}
