package com.nextgen.tests;

import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(VertxUnitRunner.class)
public class ChronicleTest extends ChronicleTestSession {

	private static final Logger log = LoggerFactory.getLogger(ChronicleTest.class);

	@Test
	public void testWire(TestContext context) {

		final TestSession session = new TestSession(context);

		session.doTestWire(result -> {
			log.info("Result:\n" + result);
			session.done();
		});
	}

	@Test
	public void testSequentialSearch(TestContext context) {

		final TestSession session = new TestSession(context);

		session.doSequentialSearchTest(result -> {
			log.info("Result:\n" + result);
			session.done();
		});
	}

	@Test
	public void testBinarySearch(TestContext context) {

		final TestSession session = new TestSession(context);

		session.doBinarySearchTest(result -> {
			log.info("Result:\n" + result);
			session.done();
		});
	}

	@Test
	public void testBinarySearchForTimestamp(TestContext context) {

		final TestSession session = new TestSession(context);

		final Long timestamp = 238746l;

		session.doBinarySearchTest(timestamp,
			result -> {
				log.info("Result:\n" + result);
				session.done();
		});
	}
}
