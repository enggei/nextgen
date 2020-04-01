package com.generator.chronicle;

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
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.generator.chronicle.ChronicleUtil.*;

public class ChronicleTestSession {

	private static final Logger log = LoggerFactory.getLogger(ChronicleTestSession.class);

	private static final int NUM_RECORDS = 10000;

	// 5 seconds total running time - so we get a few roll cycles in Chronicle
	private static final int CHILL_TIME = 5000d / NUM_RECORDS < 1.0d ? 1 : 5000 / NUM_RECORDS;

	private static String basePath;

	private enum SearchType {
		BINARY, SEQUENTIAL
	}

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
					.filter(s -> s.endsWith(".cq4"))
					.map(s -> new File(String.format("%s/%s", basePath, s)))
					.forEach(f -> {
						if (!f.delete()) {
							log.error("Could not delete " + f);
							context.fail("Could not delete " + f);
						} else log.info("Removed " + f);

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
			final int debugOutputPer = NUM_RECORDS / 10;

			log.debug("CHILL_TIME: " + CHILL_TIME);

			IntStream.generate(() -> ThreadLocalRandom.current().nextInt(105900, 106000)).limit(NUM_RECORDS).forEach(i -> {
				marketData
					.setTimestamp(timestamp.plusSeconds(written.getAndIncrement()).toInstant().toEpochMilli())
					.setVolume(ThreadLocalRandom.current().nextLong(1, 21) * 1000000l)
					.setBid(i)
					.setOffer(i + 10);

				appender.writeDocument(wireOut -> marketDataRecord.write(marketData, wireOut));

				// Debug output of the first and last 10 records + every NUM_RECORDS / 10 record
				if (written.get() % debugOutputPer == 0 || written.get() <= 11 || written.get() >= NUM_RECORDS - 10) {
					log.debug(written.get() + ": lastIndexAppended: " + appender.lastIndexAppended() + ", seq_num: " + rollCycle.toSequenceNumber(appender.lastIndexAppended()));
					debugMarketData(marketData, written);
				}

				try {
					Thread.currentThread().sleep(CHILL_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

			ExcerptTailer tailer = queue.createTailer();

			log.debug("Tailer is: " + tailer.getClass().getCanonicalName());

			final StringBuilder sb = new StringBuilder();

			final AtomicInteger read = new AtomicInteger(0);

			while (tailer.readDocument(wireIn -> marketDataRecord.read(wireIn, marketData))) {

				// Debug output of the first and last 10 records + every NUM_RECORDS / 10 record
				if (read.incrementAndGet() % debugOutputPer == 0 || read.get() < 11 || read.get() >= NUM_RECORDS - 10) {
					log.debug(read.get() + ": index: " + tailer.index() + ", seq_num: " + rollCycle.toSequenceNumber(tailer.index()));
					debugMarketData(marketData, read);
				}
			}

			queue.close();

			after.handle(sb.toString());
		}

		private void doSearchTest(final SearchType type, final Stream<Long> timestamps, BiConsumer<MarketData, Long> checkResult) {
			SingleChronicleQueue queue = getChronicleQueue();

			final MarketData marketData = new MarketData();

			final ExcerptTailer tailer = queue.createTailer();

			timestamps.forEach(searchFor -> {
				long result = 0;

				switch (type) {

					case BINARY: {
						result = binaryExcerptSearch(queue, searchFor, marketDataRecord);
						break;
					}

					case SEQUENTIAL: {
						result = sequentialExcerptSearch(queue, searchFor, marketDataRecord);
						long result2 = sequentialExcerptSearchReverse(queue, searchFor, marketDataRecord);
						context.assertEquals(result, result2, "forward and reverse search did not hit same result");
						break;
					}
				}

				log.info("Search for " + searchFor + " result: " + result);

				context.assertTrue(result > 0, "search failed: " + result);

				final boolean success = tailer.moveToIndex(result);

				context.assertTrue(success, "erroneous index from search result: " + result);

				tailer.readDocument(wireIn -> marketDataRecord.read(wireIn, marketData));

				log.debug("Search: index: " + tailer.index() + ", seq_num: " + queue.rollCycle().toSequenceNumber(tailer.index()));
				debugMarketData(marketData, new AtomicInteger(0));

				checkResult.accept(marketData, searchFor);
			});

			queue.close();
		}

		private void doRandomSearchTest(final SearchType type, Handler<String> after) {

			final ZonedDateTime timestamp = getZonedDateTime();

			doSearchTest(
				type,
				LongStream.generate(() -> ThreadLocalRandom.current().nextLong(0, NUM_RECORDS))
					.limit(1)
					.map(recordNum -> timestamp.plusSeconds(recordNum).toInstant().toEpochMilli())
					.boxed(),
				(marketData, searchFor) -> context.assertTrue(marketData.getTimestamp() == searchFor, "did not hit exact record")
			);

			after.handle("PASSED");
		}

		private void doSearchTest(final SearchType type, Long timestamp, Handler<String> after) {

			doSearchTest(
				type,
				LongStream.builder().add(timestamp).build().boxed(),
				(marketData, searchFor) -> context.assertTrue(marketData.getTimestamp() != 0, "did not find any records")
			);

			after.handle("PASSED");
		}

		public void doSequentialSearchTest(Handler<String> after) {
			doRandomSearchTest(SearchType.SEQUENTIAL, after);
		}

		public void doBinarySearchTest(Handler<String> after) {
			doRandomSearchTest(SearchType.BINARY, after);
		}

		public void doBinarySearchTest(Long timestamp, Handler<String> after) {
			doSearchTest(SearchType.BINARY, timestamp, after);
		}
	}

	private static void debugMarketData(MarketData marketData, AtomicInteger i) {
		LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(marketData.getTimestamp()), ZoneId.of("CET"));
		log.debug(i.get() + " [" + ldt.format(DateTimeFormatter.ISO_DATE_TIME) + "]: " + marketData);
	}
}
