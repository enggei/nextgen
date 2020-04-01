package com.generator.chronicle;

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
 * NextGen core Chronicle utils 26.01.17
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
		private final List<Tuple<Integer, Long> >  cycleRanges;	// List of <chronicle cycle, chronicle sequence length>
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

			size = collectCycleSequenceNumbers2(queue, cycleRanges);
		}

		public List<Tuple<Integer, Long> >  cycleRanges() {
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
	 * @return       Chronicle queue index, or 0 if not found
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
	 * @return       Chronicle queue index, or 0 if not found
	 */
	public static long sequentialExcerptSearchReverse(final RollingChronicleQueue queue, final long t, ChronicleRecord record) {
		final ChronicleMetaData metaData = new ChronicleMetaData(queue);
		return sequentialExcerptSearch(queue, t, metaData.lastIndex(), metaData, record);
	}

	/**
	 * Helper method.
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
	 * @param queue Chronicle queue
	 * @param t     Search value (e.g. a timestamp or other sequential record id field)
	 * @return      Chronicle queue index, or 0 if not found
	 */
	public static long binaryExcerptSearch(final RollingChronicleQueue queue, final long t, ChronicleRecord record) {

		ChronicleMetaData metaData = new ChronicleMetaData(queue);

		log.debug("Searching for: " + t);

		long result = binaryExcerptSearch(queue.createTailer(), t, metaData.size() / 2, metaData.size() / 4, metaData, record, 1);

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
	 * @param tailer   Chronicle Excerpt tailer
	 * @param t        Search value (e.g. a timestamp or other sequential record id field)
	 * @param start    Starting index
	 * @param metaData Metadata
	 * @param record   Function that extracts record id field
	 * @return         Chronicle queue index, or -1 if an error occurred
	 * @throws         IndexOutOfBoundsException
	 */
	static long sequentialExcerptSearch(final ExcerptTailer tailer, final long t, final long start, final ChronicleMetaData metaData, ChronicleRecord record) throws IndexOutOfBoundsException {

		final RollCycle rollCycle = metaData.rollCycle();
		final List<Tuple<Integer, Long> >  cycleRanges = metaData.cycleRanges();

		final long lastIndex = metaData.lastIndex();

		if (start > lastIndex || start < tailer.queue().firstIndex()) {
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
		//log.debug("Scanning " + (goDown ? "DOWN" : "UP"));
		//log.debug("Current position: (cycle: " + cycle.get() + ", seqNum: " + seqNum + ", length: " + cycleRange.getSecond() + ")");

		while (goDown ? (t < id.get()) : (t > id.get())) {
			// Go to next cycle when needed
			if (goDown && seqNum == 0) {
				if (cycleIndex.get() == 0) {
					// We're at the very start
					log.debug("Scanned to START without locating the record");
					log.debug("Returning index " + index);
					return index;
				}
				cycleRange = cycleRanges.get(cycleIndex.decrementAndGet());
				cycle.set(cycleRange.getFirst());
				seqNum = cycleRange.getSecond() - 1;
			}
			else if (!goDown && seqNum == (cycleRange.getSecond() - 1)) {
				if (cycleIndex.get() == (cycleRanges.size() - 1)) {
					// We're at the very end
					log.debug("Scanned to END without locating the record");
					log.debug("Returning index " + index);
					return index;
				}
				cycleRange = cycleRanges.get(cycleIndex.incrementAndGet());
				cycle.set(cycleRange.getFirst());
				seqNum = 0;
			}
			else seqNum += goDown ? -1l : 1l;

			//log.debug("Next position: (cycle: " + cycle.get() + ", seqNum: " + seqNum + ", length: " + cycleRange.getSecond() + ")");

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
	 * @param recordNum Record number between 0 and s
	 * @param metaData  Meta data
	 * @return          Chronicle queue index
	 * @throws          IndexOutOfBoundsException
	 */
	public static long translateRecordNum(final long recordNum, final ChronicleMetaData metaData) throws IndexOutOfBoundsException {

		final RollCycle rollCycle = metaData.rollCycle();
		final List<Tuple<Integer, Long> >  cycleRanges = metaData.cycleRanges();

		if (cycleRanges == null || cycleRanges.isEmpty())
			throw new IllegalArgumentException("cycleRanges cannot be " + (cycleRanges != null ? "empty" : "null") + "!");

		if (recordNum >= metaData.size())
			throw new IndexOutOfBoundsException("recordNum out of bounds: " + recordNum + " >= " + metaData.size());

		long seqNum = 0;

		for (Tuple<Integer, Long> cycleRange : cycleRanges) {
			// Accumulate until we locate cycle
			seqNum += cycleRange.getSecond();

			if (seqNum <= recordNum)
				continue;

			// Adjust to correct sequence number in the cycle
			seqNum = cycleRange.getSecond() - (seqNum - recordNum);
			//log.debug("Translated seqNum: " + recordNum + " -> " + seqNum + " (" + cycleRange.getSecond() + " - (" + seqNum + " - " + recordNum + "))");

			return rollCycle.toIndex(cycleRange.getFirst(), seqNum);
		}

		// Should never reach here!
		throw new RuntimeException("*** SHOULD NEVER SEE THIS ***");
	}

	/**
	 * Helper method.
	 * Binary Chronicle Excerpt record search.
	 * O(log N)
	 *
	 * @param tailer   Chronicle Excerpt tailer
	 * @param t        Search value (e.g. a timestamp or other sequential record id field)
	 * @param i        Relative index
	 * @param l        Length to go next
	 * @param metaData Meta data
	 * @param record   Function that extracts record id field
	 * @param d        Recursion depth
	 * @return         Chronicle queue index, or -1 if an error occurred
	 */
	static long binaryExcerptSearch(final ExcerptTailer tailer, final long t, final long i, final long l, final ChronicleMetaData metaData, ChronicleRecord record, final int d) {

		long current = translateRecordNum(i, metaData);

		//log.debug("depth: " + d + ", length: " + l + ", index: " + i + ", t: " + t + ", current: " + current);

		if (!tailer.moveToIndex(current)) {
			log.error("No excerpt at " + current);
			return -1l;
		}

		// Close enough, try to scan for exact match
		if (l <= 3l) return sequentialExcerptSearch(tailer, t, current, metaData, record);

		final AtomicLong id = new AtomicLong(0);
		tailer.readDocument(wireIn -> id.set(record.id(wireIn)));

		// Spot on! Not likely though
		if (id.get() == t) {
			log.debug("Spot on!");
			return current;
		}

		if (log.isDebugEnabled() && t > id.get()) log.debug("Going UP  : " + t + " > " + id);
		else if (log.isDebugEnabled() && t < id.get()) log.debug("Going DOWN: " + t + " < " + id);

		return binaryExcerptSearch(tailer, t, (t > id.get() ? i + l : i - l), l / 2l, metaData, record, d + 1);
	}

	/**
	 * Helper method.
	 * Retrieves all cycles in a RollingChronicleQueue.
	 *
	 * @param queue Chronicle queue
	 * @throws      ParseException
	 * @return      List of cycle numbers
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

	/**
	 * Helper method.
	 * Sequentially calculates the total number of excerpts in a cycle.
	 *
	 * @param queue       Chronicle queue
	 * @param cycleRanges List of cycle ranges
	 * @return            Total number of excerpts
	 */
	@Deprecated
	static long collectCycleSequenceNumbers(final RollingChronicleQueue queue, final List<Tuple<Integer, Long> > cycleRanges) {

		final RollCycle rollCycle = queue.rollCycle();
		final ExcerptTailer tailer = queue.createTailer();

		final long currentIndex = tailer.index();
		int currentCycle = tailer.cycle();

		tailer.toStart();

		long size = 0;
		long currentSeqNum = rollCycle.toSequenceNumber(currentIndex);

		// Collect highest populated sequence number per cycle
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

		return size;
	}

	/**
	 * Helper method.
	 * Recursively calculates the total number of excerpts in a cycle.
	 *
	 * @param tailer    Chronicle Excerpt tailer
	 * @param rollCycle Chronicle queue rolling cycle
	 * @param c         Cycle number
	 * @param s         Sequence number
	 * @param l         Length to go next
	 * @param d         Recursion depth
	 * @return          Total number of excerpts
	 */
	static long findCycleLastIndex(final ExcerptTailer tailer, final RollCycle rollCycle, final int c, final long s, final long l, final int d) {

		long i = rollCycle.toIndex(c, s);

		//log.debug("depth: " + d + ", seqNum: " + s + ", length: " + l + ", cycle: " + c + ", index: " + i);

		boolean found = tailer.moveToIndex(i);
		boolean finalScan = l == 1 && found;

		while (finalScan && tailer.moveToIndex(i++));
		if (finalScan) return i - 1;

		return findCycleLastIndex(tailer, rollCycle, c, found ? s + l : s - l, l > 1 ? l / 2l : 1, d + 1);
	}

	/**
	 * Helper method.
	 * Calculates the total number of excerpts in a cycle.
	 *
	 * @param tailer     Chronicle Excerpt tailer
	 * @param rollCycle  Chronicle queue rolling cycle
	 * @param cycleRange Tuple of cycle range (cycle number and number of excerpts)
	 * @return           Total number of excerpts
	 */
	static long findCycleLastIndex(final ExcerptTailer tailer, final RollCycle rollCycle, final Tuple<Integer, Long> cycleRange) {
		long maxIndex = rollCycle.toIndex(cycleRange.getFirst(), Long.MAX_VALUE);
		long maxSeqNum = rollCycle.toSequenceNumber(maxIndex);

		return findCycleLastIndex(tailer, rollCycle, cycleRange.getFirst(), maxSeqNum / 2l, maxSeqNum / 4l, 1);
	}

	/**
	 * Helper method.
	 * Calculates the total number of excerpts for all cycles.
	 *
	 * @param queue       Chronicle queue
	 * @param cycleRanges List of cycle ranges (cycle number and number of excerpts)
	 * @return            Total number of excerpts
	 */
	static long collectCycleSequenceNumbers2(final RollingChronicleQueue queue, final List<Tuple<Integer, Long> > cycleRanges) {

		final RollCycle rollCycle = queue.rollCycle();
		final ExcerptTailer forwardTailer = queue.createTailer().toStart();

		// When only one cycle
		if (cycleRanges.size() == 1) {
			final ExcerptTailer reverseTailer = queue.createTailer().direction(TailerDirection.BACKWARD);

			// NOTE: countExcerpts() does not work across cycles!
			long totalExcerpts = queue.countExcerpts(forwardTailer.index(), reverseTailer.toEnd().index());

			cycleRanges.get(0).setSecond(totalExcerpts);

			return totalExcerpts;
		}

		final AtomicLong size = new AtomicLong(0);

		cycleRanges.stream().forEach(cr -> {
			long lastIndex = findCycleLastIndex(forwardTailer, rollCycle, cr);
			long lastSeqNum = rollCycle.toSequenceNumber(lastIndex);

			cr.setSecond(lastSeqNum);

			size.addAndGet(lastSeqNum);
		});

		return size.get();
	}
}