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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * NextGen core Chronicle utils 19.01.17
 * 
 * Chronicle: http://chronicle.software/products/chronicle-queue/
 */
public class ChronicleUtil {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ChronicleUtil.class);

	/**
	 * Interface defining how to read and write a record in the Chronicle queue.
	 */
	public interface ChronicleRecord<R> {
		long id(WireIn wireIn);
		void read(WireIn wireIn, R recordOut);
		void write(final R recordIn, WireOut wireOut);
	}

	private static final class Tuple<F, S> {

		private F first;
		private S second;

		public Tuple(F first, S second) {
			this.first = first;
			this.second = second;
		}

		public F getFirst() {
			return first;
		}

		public S getSecond() {
			return second;
		}

		public void setFirst(F first) {
			this.first = first;
		}

		public void setSecond(S second) {
			this.second = second;
		}

		@Override
		public String toString() {
			return "[" + first + "," + second + "]";
		}
	}

	private static final class ChronicleMetaData {

		private final RollCycle rollCycle;
		private final List<Tuple<Integer, Long>>  cycleRanges;	// List of <chronicle cycle, chronicle sequence length>
		private long size = 0;

		ChronicleMetaData(final RollingChronicleQueue queue) {
			if (queue == null)
				throw new IllegalArgumentException("queue cannot be null!");

			rollCycle = queue.rollCycle();
			cycleRanges = new ArrayList<>();

			try {
				cycleRanges.addAll(
					getQueueCycles(queue)
						.stream()
						.map(c -> new Tuple<>(c, 0l))
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

			final long currentIndex = tailer.index();
			int currentCycle = tailer.cycle();
			long currentSeqNum = rollCycle.toSequenceNumber(currentIndex);

			// Collect highest sequence number per cycle
			// TODO: For large chronicles, find highest sequence number by binary searching for record presence
			try (DocumentContext dc = tailer.readingDocument()) {
				if (dc.isPresent()) {
					// Scan and count all records
					int crIndex = 0;
					do {
						while (tailer.moveToIndex(rollCycle.toIndex(currentCycle, currentSeqNum++))) {
							//log.debug("Found record at: " + tailer.cycle() + ":" + rollCycle.toSequenceNumber(tailer.index()));
						}

						cycleRanges.get(crIndex).setSecond(currentSeqNum - 1);
						size += cycleRanges.get(crIndex).getSecond();

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
		}

		public List<Tuple<Integer, Long>>  cycleRanges() {
			return cycleRanges;
		}

		public RollCycle rollCycle() {
			return rollCycle;
		}

		public long size() {
			return size;
		}

		public long lastIndex() {
			Tuple<Integer, Long> cycleRange = cycleRanges.get(cycleRanges.size() - 1);

			long maxSeqNum = cycleRange.getSecond();

			if (maxSeqNum > 0)
				maxSeqNum -= 1l;

			return rollCycle.toIndex(cycleRange.getFirst(), maxSeqNum);
		}
	}

	/**
	 * Sequential Chronicle Excerpt record search.
	 * O(N)
	 *
	 * @param queue  Chronicle queue
	 * @param t      Search value (e.g. a timestamp or other sequential record id field)
	 * @param record Function that extracts record id field
	 * @return
	 */
	public static long sequentialExcerptSearch(final RollingChronicleQueue queue, final long t, ChronicleRecord record) {
		return sequentialExcerptSearch(queue, t, queue.firstIndex(), new ChronicleMetaData(queue), record);
	}

	/**
	 * Sequential Chronicle Excerpt record search.
	 * O(N)
	 *
	 * @param queue  Chronicle queue
	 * @param t      Search value (e.g. a timestamp or other sequential record id field)
	 * @param record Function that extracts record id field
	 * @return
	 */
	public static long sequentialExcerptSearchReverse(final RollingChronicleQueue queue, final long t, ChronicleRecord record) {
		final ChronicleMetaData metaData = new ChronicleMetaData(queue);
		return sequentialExcerptSearch(queue, t, metaData.lastIndex(), metaData, record);
	}

	/**
	 * Sequential Chronicle Excerpt record search.
	 * O(N)
	 *
	 * @param queue	 Chronicle queue
	 * @param t			 Search value (e.g. a timestamp or other sequential record id field)
	 * @param start    Starting index
	 * @param metaData Meta data
	 * @param record   Function that extracts record id field
	 * @return			 Chronicle queue index, or 0 if not found
	 */
	static long sequentialExcerptSearch(final RollingChronicleQueue queue, final long t, final long start, final ChronicleMetaData metaData, ChronicleRecord record) {

		log.debug("Searching for: " + t);

		long result = sequentialExcerptSearch(queue.createTailer(), t, start, metaData, record);

		if (result < 0) {
			log.debug("Not found: " + t);
			return 0;
		}

		return result;
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

		ChronicleMetaData metaData = new ChronicleMetaData(queue);

		log.debug("Searching for: " + t);

		long result = binaryExcerptSearch(queue.createTailer(), t, metaData.size() / 2, metaData.size() / 4, metaData, record);

		if (result < 0) {
			log.debug("Not found: " + t);
			return 0;
		}

		return result;
	}

	/**
	 * Helper method.
	 * Sequential Chronicle Excerpt record search.
	 * O(N)
	 *
	 * @param tailer      Chronicle Excerpt tailer
	 * @param t           Search value (e.g. a timestamp or other sequential record id field)
	 * @param start       Starting index
	 * @param metaData    Metadata
	 * @param record      Function that extracts record id field
	 * @return            Chronicle queue index, or -1 if an error occurred
	 * @throws IndexOutOfBoundsException
	 */
	static long sequentialExcerptSearch(final ExcerptTailer tailer, final long t, final long start, final ChronicleMetaData metaData, ChronicleRecord record) throws IndexOutOfBoundsException {

		final RollCycle rollCycle = metaData.rollCycle();
		final List<Tuple<Integer, Long>>  cycleRanges = metaData.cycleRanges();

		final long lastIndex = rollCycle.toIndex(cycleRanges.get(cycleRanges.size() - 1).getFirst(), cycleRanges.get(cycleRanges.size() - 1).getSecond());

		if (start >= lastIndex || start < tailer.queue().firstIndex()) {
			throw new IndexOutOfBoundsException("start out of bounds: " + start + " >= " + lastIndex + " || " + start + " < " + tailer.queue().firstIndex());
		}

		if (!tailer.moveToIndex(start)) {
			log.error("No excerpt at " + start);
			return -1l;
		}

		long index = start;
		long seqNum = rollCycle.toSequenceNumber(index);
		final AtomicInteger cycle = new AtomicInteger(rollCycle.toCycle(index));

		final AtomicInteger cycleIndex = new AtomicInteger(0);

		// Which cycle index are we on?
		Tuple<Integer, Long> cycleRange = cycleRanges.stream().filter(cr -> {
			if (cr.getFirst() == cycle.get())
				return true;

			cycleIndex.incrementAndGet();

			return false;
		}).findFirst().get();

		assert(cycleRange.equals(cycleRanges.get(cycleIndex.get())));
		assert(cycle.get() == cycleRanges.get(cycleIndex.get()).getFirst());

		final AtomicLong id = new AtomicLong(0);
		tailer.readDocument(wireIn -> id.set(record.id(wireIn)));

		final boolean goDown = t < id.get();
		log.debug("Scanning " + (goDown ? "DOWN" : "UP"));
		log.debug("Current position: (cycle: " + cycle.get() + ", seqNum: " + seqNum + ", length: " + cycleRange.getSecond() + ")");

		while (goDown ? (t < id.get()) : (t > id.get())) {
			// Go to next cycle when needed
			if (goDown && seqNum == 0) {
				if (cycleIndex.get() == 0) return index; // We're at the very beginning
				cycleRange = cycleRanges.get(cycleIndex.decrementAndGet());
				cycle.set(cycleRange.getFirst());
				seqNum = cycleRange.getSecond() - 1;
			}
			else if (!goDown && seqNum == (cycleRange.getSecond() - 1)) {
				if (cycleIndex.get() == (cycleRanges.size() - 1)) return index; // We're at the very end
				cycleRange = cycleRanges.get(cycleIndex.incrementAndGet());
				cycle.set(cycleRange.getFirst());
				seqNum = 0;
			}
			else seqNum += goDown ? -1l : 1l;

			log.debug("Next position: (cycle: " + cycle.get() + ", seqNum: " + seqNum + ", length: " + cycleRange.getSecond() + ")");

			index = rollCycle.toIndex(cycle.get(), seqNum);
			if (!tailer.moveToIndex(index)) {
				log.error("No excerpt at " + start);
				return -1l;
			}

			if (!tailer.readDocument(wireIn -> id.set(record.id(wireIn)))) {
				log.warn("No record at " + index + " (" + cycle.get() + "," + seqNum + ")");
				return -1l;
			}
		}

		log.debug("Returning index " + index + (id.get() == t ? " *SPOT ON*" : ""));

		return index;
	}

	/**
	 * Translates a virtual record (sequence) number across all cycles into Chronicle queue index.
	 *
	 * @param recordNum   Record number between 0 and s
	 * @param metaData    Meta data
	 * @return            Chronicle queue index
	 * @throws            IndexOutOfBoundsException
	 */
	public static long translateRecordNum(final long recordNum, final ChronicleMetaData metaData) throws IndexOutOfBoundsException {

		final RollCycle rollCycle = metaData.rollCycle();
		final List<Tuple<Integer, Long>>  cycleRanges = metaData.cycleRanges();

		if (cycleRanges == null || cycleRanges.isEmpty())
			throw new IllegalArgumentException("cycleRanges cannot be " + (cycleRanges != null ? "empty" : "null") + "!");

		if (recordNum >= metaData.size())
			throw new IndexOutOfBoundsException("recordNum out of bounds: " + recordNum + " >= " + metaData.size());

		long index = 0;

		for (Tuple<Integer, Long> cycleRange : cycleRanges) {
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
	 * @param metaData    Meta data
	 * @param record      Function that extracts record id field
	 * @return            Chronicle queue index, or -1 if an error occurred
	 */
	static long binaryExcerptSearch(final ExcerptTailer tailer, final long t, final long i, final long l, final ChronicleMetaData metaData, ChronicleRecord record) {

		long current = translateRecordNum(i, metaData);

		log.debug("l: " + l + ", i: " + i + ", t: " + t + ", current: " + current);

		if (!tailer.moveToIndex(current)) {
			log.error("No excerpt at " + current);
			return -1l;
		}

		// Close enough, try to scan for exact match
		if (l <= 3l) {
			log.debug("Close enough: " + l);
			return sequentialExcerptSearch(tailer, t, current, metaData, record);
		}

		final AtomicLong id = new AtomicLong(0);
		tailer.readDocument(wireIn -> id.set(record.id(wireIn)));

		// Spot on! Not likely though
		if (id.get() == t) {
			log.debug("Spot on!");
			return current;
		}

		if (log.isDebugEnabled() && t > id.get()) log.debug("Going UP  : " + t + " > " + id);
		else if (log.isDebugEnabled() && t < id.get()) log.debug("Going DOWN: " + t + " < " + id);

		return binaryExcerptSearch(tailer, t, (t > id.get() ? i + l : i - l), l / 2l, metaData, record);
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