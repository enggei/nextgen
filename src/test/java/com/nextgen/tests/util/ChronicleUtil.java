package com.nextgen.tests.util;

import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.RollCycle;
import net.openhft.chronicle.queue.TailerDirection;
import net.openhft.chronicle.queue.impl.RollingChronicleQueue;
import net.openhft.chronicle.wire.DocumentContext;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * NextGen core Chronicle utils 18.01.17
 * 
 * Chronicle: http://chronicle.software/products/chronicle-queue/
 */
public class ChronicleUtil {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ChronicleUtil.class);

	/**
	 * Interface defining how to read and write a record in the Chronicle queue.
	 */
	public interface ChronicleRecord<R> {
		long getId(WireIn wireIn);
		void read(WireIn wireIn, R recordOut);
		void write(final R recordIn, WireOut wireOut);
	}

	/**
	 * Binary Chronicle Excerpt record search.
	 * O(log N)
	 * 
	 * @param queue	Chronicle queue
	 * @param t			Search value (e.g. a timestamp or other sequential record id field)
	 * @return			Chronicle queue index, or 0 if not found
	 */
	public static long binaryExcerptSearch(final RollingChronicleQueue queue, final long t, ChronicleRecord record) {
		if (queue == null)
			throw new IllegalArgumentException("queue cannot be null!");

		log.debug("Searching for: " + t);

		final RollCycle rollCycle = queue.rollCycle();

		final List<com.nextgen.tests.util.Tuple<Integer, Long>>   cycleRanges = new ArrayList<>();

		try {
			cycleRanges.addAll(
				getQueueCycles(queue)
					.stream()
					.map(c -> new com.nextgen.tests.util.Tuple<>(c, 0l))
					.collect(Collectors.toList())
			);
		}
		catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to collect queue cycles", e);
		}

		if (cycleRanges.isEmpty())
			throw new RuntimeException("cycleRanges is empty");

		ExcerptTailer tailer = queue.createTailer();

		long s = 0;

		final long currentIndex = tailer.index();
		int currentCycle = tailer.cycle();
		long currentSeqNum = rollCycle.toSequenceNumber(currentIndex);

		if (cycleRanges.get(0).getFirst() != currentCycle)
			throw new RuntimeException("cycle at index 0 does not match tailer current cycle");

		//long recordCount = 0;

		// Collect highest sequence number per cycle
		try (DocumentContext dc = tailer.readingDocument()) {
			if (dc.isPresent()) {
				// Scan and count all records
				int crIndex = 0;
				do {
					while (tailer.moveToIndex(rollCycle.toIndex(currentCycle, currentSeqNum++))) {
						//++recordCount;
						//log.debug("Found record at: " + tailer.cycle() + ":" + rollCycle.toSequenceNumber(tailer.index()));
					}

					cycleRanges.get(crIndex).setSecond(currentSeqNum - 1);
					s += cycleRanges.get(crIndex).getSecond();

					if (crIndex < cycleRanges.size() - 1) {
						currentSeqNum = 0;
						currentCycle = cycleRanges.get(++crIndex).getFirst();
						log.debug("Changed cycle to: " + currentCycle);
					}
				} while(currentCycle != tailer.cycle());
			}
			else {
				log.debug("No records present!");
			}
		}

		long result = binaryExcerptSearch(tailer, t, s / 2, s / 4, rollCycle, cycleRanges, s, record);

		if (result < 0) {
			log.debug("Not found: " + t);
			return 0;
		}

		return result;
	}

	/**
	 * Translates a virtual record (sequence) number across all cycles into Chronicle queue index.
	 *
	 * @param recordNum   Record number between 0 and s
	 * @param rollCycle   Chronicle queue's roll cycle
	 * @param cycleRanges List of tuples &lt;chronicle cycle, chronicle last sequence number&gt;
	 * @param s           Total number of records
	 * @return            Chronicle queue index
	 * @throws            IndexOutOfBoundsException
	 */
	public static long translateRecordNum(final long recordNum, final RollCycle rollCycle, final List<com.nextgen.tests.util.Tuple<Integer, Long>>  cycleRanges, final long s) throws IndexOutOfBoundsException {
		if (cycleRanges == null || cycleRanges.isEmpty())
			throw new IllegalArgumentException("cycleRanges cannot be " + (cycleRanges != null ? "empty" : "null") + "!");

		if (recordNum >= s)
			throw new IndexOutOfBoundsException("recordNum out of bounds: " + recordNum + " >= " + s);

		long index = 0;

		for (com.nextgen.tests.util.Tuple<Integer, Long> cycleRange : cycleRanges) {
			// Accumulate until we locate cycle
			index += cycleRange.getSecond();

			if (index <= recordNum)
				continue;

			// Adjust to correct sequence number in the cycle
			index = cycleRange.getSecond() - (index - recordNum);
			//log.debug("Translated index: " + recordNum + " -> " + index + " (" + cycleRange.getSecond() + " - (" + index + " - " + recordNum + "))");

			return rollCycle.toIndex(cycleRange.getFirst(), index);
		}

		// Should never reach here!
		throw new RuntimeException("*** SHOULD NEVER SEE THIS ***");
	}

	/**
	 * Helper method.
	 * Binary Chronicle Excerpt record search.
	 * O(log N)
	 *
	 * @param tailer      Chronicle Excerpt tailer
	 * @param t           Search value (e.g. a timestamp or other sequential record id field)
	 * @param i           Relative index
	 * @param l           Length to go next (forwards or backwards)
	 * @param rollCycle   Chronicle queue's roll cycle
	 * @param cycleRanges List of tuples &lt;chronicle cycle, chronicle last sequence number&gt;
	 * @param s           Total number of records
	 * @param record Function that extracts record id field
	 * @return            Chronicle queue index, or -1 if an error occurred
	 */
	static long binaryExcerptSearch(final ExcerptTailer tailer, final long t, final long i, final long l, final RollCycle rollCycle, final List<com.nextgen.tests.util.Tuple<Integer, Long>>    cycleRanges, final long s, ChronicleRecord record) {


		long current = translateRecordNum(i, rollCycle, cycleRanges, s);

		log.debug("l: " + l + ", i: " + i + ", t: " + t + ", current: " + current);

		if (!tailer.moveToIndex(current)) {
			log.error("No excerpt at " + current);
			return -1l;
		}

		// Close enough for government work
		if (l <= 5l) {
			log.debug("Close enough: " + l);
			return translateRecordNum(i, rollCycle, cycleRanges, s);
		}

		final AtomicLong id = new AtomicLong(0);
		tailer.readDocument(wireIn -> id.set(record.getId(wireIn)));

		// Spot on! Not likely though
		if (id.get() == t) {
			log.debug("Spot on!");
			return current;
		}

		if (log.isDebugEnabled() && t > id.get()) log.debug("Going UP  : " + t + " > " + id);
		else if (log.isDebugEnabled() && t < id.get()) log.debug("Going DOWN: " + t + " < " + id);

		return binaryExcerptSearch(tailer, t, (t > id.get() ? i + l : i - l), l / 2l, rollCycle, cycleRanges, s, record);
	}

	/**
	 * Helper method.
	 * Retrieves all cycles in a RollingChronicleQueue.
	 *
	 * @param queue Chronicle queue
	 * @throws      ParseException
	 * @return      List of cycles
	 */
	static List<Integer> getQueueCycles(final RollingChronicleQueue queue) throws ParseException {
		final List<Integer> cycles = new ArrayList<>();

		int cycle = queue.firstCycle();
		final int lastCycle = queue.lastCycle();

		cycles.add(cycle);	// Add first cycle

		while (cycle != lastCycle) {
			cycle = queue.nextCycle(cycle, TailerDirection.FORWARD);
			cycles.add(cycle);
		}

		return cycles;
	}
}