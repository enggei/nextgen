package com.nextgen.tests;

import io.vertx.core.Handler;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import net.openhft.chronicle.queue.*;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.nextgen.tests.util.ChronicleUtil.*;

public class ChronicleTestSession {

	private static final Logger log = LoggerFactory.getLogger(ChronicleTestSession.class);

	private static String basePath;

	@BeforeClass
	public static void setup(TestContext context) {
		basePath = System.getProperty("java.io.tmpdir") + "/getting-started";
	}

	@Rule
	public RunTestOnContext rule = new RunTestOnContext();

	protected class TestSession {
		private final ChronicleRecord<MarketData> marketDataRecord;
		private final TestContext context;
		protected final Async async;

		public TestSession(TestContext context) {
			this.context = context;
			this.async = context.async();
			this.marketDataRecord = new ChronicleRecord<MarketData>() {
				@Override
				public long id(WireIn wireIn) {
					return wireIn.read(() -> "t").int64();
				}

				@Override
				public void read(WireIn wireIn, MarketData recordOut) {
					recordOut
						.setTimestamp(wireIn.read(() -> "t").int64())
						.setInstrument(wireIn.read(() -> "i").text())
						.setBid(wireIn.read(() -> "b").int32())
						.setOffer(wireIn.read(() -> "o").int32())
						.setVolume(wireIn.read(() -> "v").int64());
				}

				@Override
				public void write(final MarketData recordOut, WireOut wireOut) {
					wireOut
						.write(() -> "t").int64(recordOut.getTimestamp())
						.write(() -> "i").text(recordOut.getInstrument())
						.write(() -> "b").int32(recordOut.getBid())
						.write(() -> "o").int32(recordOut.getOffer())
						.write(() -> "v").int64(recordOut.getVolume());
				}
			};
		}

		void done() {
			async.complete();
			log.info("async complete");
		}

		private SingleChronicleQueue getChronicleQueue() {
			return ChronicleQueueBuilder
				.single(basePath)
				.rollCycle(RollCycles.TEST_SECONDLY)
				.build();
		}

		private ZonedDateTime getZonedDateTime() {
			return LocalDateTime.now()
				.with(TemporalAdjusters.firstDayOfMonth())
				.withHour(0)
				.withMinute(0)
				.withSecond(0)
				.withYear(2017)
				.truncatedTo(ChronoUnit.SECONDS).atZone(ZoneId.of("CET"));
		}

		private void clearChronicle() {
			File file = new File(basePath);
			if (file.exists() && file.isDirectory()) {
				Arrays.asList(file.list())
					.stream()
					.filter(s -> new File(s).toString().endsWith(".cq4")).map(s1 -> new File(String.format("%s/%s", basePath, s1))).forEach(f -> {
					if (!f.delete()) {
						log.error("Could not delete " + f);
						context.fail("Could not delete " + f);
					}
					else log.info("Removed " + f);

				});
			}
			else if (file.exists() && file.delete()) {
				log.error("Could not delete " + file);
				context.fail("Could not delete " + file);
			}
		}

		public void doTestWire(Handler<String> after) {
			clearChronicle();

			SingleChronicleQueue queue = getChronicleQueue();

			final RollCycle rollCycle = queue.rollCycle();

			ExcerptAppender appender = queue.acquireAppender();

			log.debug("Appender is: " + appender.getClass().getCanonicalName());

			final MarketData marketData = new MarketData();
			marketData.setInstrument("EURUSD");

			final ZonedDateTime timestamp = getZonedDateTime();

			final AtomicInteger written = new AtomicInteger(0);

			//
			final int numEntries = 1000;
			final int chillTime = 5000 / numEntries;	// 5 seconds total running time - so we get a few roll cycles in Chronicle

			IntStream.generate(() -> ThreadLocalRandom.current().nextInt(105900, 106000)).limit(numEntries).forEach(i -> {
				marketData
					.setTimestamp(timestamp.plusSeconds(written.get()).toInstant().toEpochMilli())
					.setVolume(ThreadLocalRandom.current().nextLong(1, 11) * 1000000l)
					.setBid(i)
					.setOffer(i + 10);

				appender.writeDocument(wireOut -> marketDataRecord.write(marketData, wireOut));

				if (written.incrementAndGet() % 100 == 0 || written.get() < 11 || written.get() >= 990) {
					log.debug(written.get() + ": lastIndexAppended: " + appender.lastIndexAppended() + ", seq_num: " + rollCycle.toSequenceNumber(appender.lastIndexAppended()));
					debugMarketData(marketData, written);
				}

				try {
					Thread.currentThread().sleep(chillTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

			ExcerptTailer tailer = queue.createTailer();

			log.debug("Tailer is: " + tailer.getClass().getCanonicalName());

			final StringBuilder sb = new StringBuilder();

			final AtomicInteger read = new AtomicInteger(0);

			while (tailer.readDocument(wireIn -> marketDataRecord.read(wireIn, marketData))) {

				if (read.incrementAndGet() % 100 == 0 || read.get() < 11 || read.get() >= 990) {
					log.debug(read.get() + ": index: " + tailer.index() + ", seq_num: " + rollCycle.toSequenceNumber(tailer.index()));
					debugMarketData(marketData, read);
				}
			}

			queue.close();

			after.handle(sb.toString());
		}

		public void doSequentialSearchTest(Handler<String> after) {
			SingleChronicleQueue queue = getChronicleQueue();

			final ZonedDateTime timestamp = getZonedDateTime();

			final MarketData marketData = new MarketData();

			final ExcerptTailer tailer = queue.createTailer();

			IntStream.generate(() -> ThreadLocalRandom.current().nextInt(0, 1000)).limit(1).forEach(recordNum -> {
				long searchFor = timestamp.plusSeconds(recordNum).toInstant().getEpochSecond() * 1000;

				long result = sequentialExcerptSearch(queue, searchFor, marketDataRecord);
				long result2 = sequentialExcerptSearchReverse(queue, searchFor, marketDataRecord);

				context.assertEquals(result, result2, "forward and reverse search did not hit same result");

				log.info("Search for " + searchFor + " hit: " + result);

				context.assertTrue(result > 0, "search failed: " + result);
				context.assertTrue(tailer.moveToIndex(result), "erroneous index from search result: " + result);

				tailer.readDocument(wireIn -> marketDataRecord.read(wireIn, marketData));

				log.debug("Search: index: " + tailer.index() + ", seq_num: " + queue.rollCycle().toSequenceNumber(tailer.index()));
				debugMarketData(marketData, new AtomicInteger(recordNum));

				context.assertTrue(marketData.getTimestamp() == searchFor, "did not hit exact record");
			});

			queue.close();

			after.handle(marketData.toString());
		}

		public void doBinarySearchTest(Handler<String> after) {
			SingleChronicleQueue queue = getChronicleQueue();

			final ZonedDateTime timestamp = getZonedDateTime();

			final MarketData marketData = new MarketData();

			final ExcerptTailer tailer = queue.createTailer();

			IntStream.generate(() -> ThreadLocalRandom.current().nextInt(0, 1000)).limit(1).forEach(recordNum -> {
				long searchFor = timestamp.plusSeconds(recordNum).toInstant().getEpochSecond() * 1000;

				long result = binaryExcerptSearch(queue, searchFor, marketDataRecord);

				log.info("Search for " + searchFor + " hit: " + result);

				context.assertTrue(result > 0, "search failed: " + result);
				context.assertTrue(tailer.moveToIndex(result), "erroneous index from search result: " + result);

				tailer.readDocument(wireIn -> marketDataRecord.read(wireIn, marketData));

				log.debug("Search: index: " + tailer.index() + ", seq_num: " + queue.rollCycle().toSequenceNumber(tailer.index()));
				debugMarketData(marketData, new AtomicInteger(recordNum));

				context.assertTrue(Math.abs(marketData.getTimestamp() - searchFor) < 10000, "not close enough");
			});

			queue.close();

			after.handle(marketData.toString());
		}
	}

	private static void debugMarketData(MarketData marketData, AtomicInteger i) {
		LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(marketData.getTimestamp()), ZoneId.of("CET"));
		log.debug(i.get() + " [" + ldt + "]: " + marketData);
	}
}
