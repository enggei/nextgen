package com.generator.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * goe on 9/6/16.
 */
public class FormatUtil {

	public static final long SECONDms = 1000;
	public static final long MINUTEms = SECONDms * 60L;
	public static final long HOURms = MINUTEms * 60L;
	public static final long DAYms = HOURms * 24L;

	private static final DecimalFormat percentFormat = new DecimalFormat("##.##%");

	public static String formatPct(double pct) {
		return percentFormat.format(pct);
	}

	public static String formatPct(int count, int total) {
		return percentFormat.format(count / (double)total);
	}

	public static String formatPct(long count, long total) {
		return percentFormat.format(count / (double)total);
	}

	public static String formatTime(long runningTime) {

		final boolean negative = runningTime < 0;

		runningTime = Math.abs(runningTime);

		final StringBuilder t = new StringBuilder();
		final long d = runningTime / DAYms;
		if (d > 0L) {
			t.append(" ").append(d).append(" day").append(d == 1 ? "" : "s");
			runningTime %= DAYms;
		}
		final long h = runningTime / HOURms;
		if (h > 0L) {
			t.append(" ").append(h).append(" hour").append(h == 1 ? "" : "s");
			runningTime %= HOURms;
		}
		final long m = runningTime / MINUTEms;
		if (m > 0L) {
			t.append(" ").append(m).append(" minute").append(m == 1 ? "" : "s");
			runningTime %= MINUTEms;
		}
		final long s = runningTime / SECONDms;
		if (s > 0L) {
			t.append(" ").append(s).append(" second").append(s == 1 ? "" : "s");
			runningTime %= SECONDms;
		}

		final String x = t.toString().trim();
		return (negative ? "-" : "") + (x.length() == 0 ? (runningTime + " ms") : x);
	}

	public static String filterTimeMinutes(long runningTime) {
		final boolean negative = runningTime < 0;

		runningTime = Math.abs(runningTime);

		final StringBuilder t = new StringBuilder();
		final long m = runningTime / MINUTEms;
		if (m > 0L) {
			t.append(" ").append(pad(m, 4)).append(" minute").append(m == 1 ? "" : "s");
		}

		final String x = t.toString().trim();
		return (negative ? "-" : "") + (x.length() == 0 ? (pad(m, 4) + " minutes") : x);
	}

	public static String pad(long m, int padding) {
		return String.format("%0" + padding + "d", m);
	}

	/**
	 * Formats a Date/time as "Mon, 25 Jun 2013 21:31:12 GMT"
	 * @param zonedDateTime
	 * @return Date/time in RFC 1123 format
	 */
	public static String formatHTTPDateTime(final ZonedDateTime zonedDateTime) {
		return DateTimeFormatter.RFC_1123_DATE_TIME.format(zonedDateTime);
	}

	public static ZonedDateTime toZonedDateTime(long timestamp) {
		final int seconds = (int)(timestamp / 1000L);
		final int nano = (int)(timestamp - (seconds * 1000L)) * 1000000;

		return ZonedDateTime.of(
			LocalDateTime.ofEpochSecond(seconds, nano, ZoneOffset.UTC),
			ZoneId.of("UTC")
		);
	}

	/**
	 * Parses an RFC 1123 formatted date/time string.
	 * @param httpDateTime
	 * @return
	 * @throws DateTimeParseException
	 */
	public static ZonedDateTime parseHTTPDateTime(final String httpDateTime) throws DateTimeParseException {
		return ZonedDateTime.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(httpDateTime));
	}

	/**
	 * Formats a Date/time as "Mon, 25 Jun 2013 21:31:12 GMT"
	 * @param localDateTime
	 * @return Date/time in RFC 1123 format
	 */
	public static String formatHTTPDateTime(LocalDateTime localDateTime) {
		return formatHTTPDateTime(
			toZonedDateTime(localDateTime.toEpochSecond(ZoneOffset.UTC) * 1000L)
		);
	}

	public static String formatBytes(long bytes, boolean si) {
		int unit = si ? 1000 : 1024;
		if (bytes < unit) return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}

	private static final String[] lowNames = {
			"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	private static final String[] tensNames = {
			"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	private static final String[] bigNames = {
			"thousand", "million", "billion"};

	/**
	 * Converts an integer number into words (american english).
	 * @author Christian d'Heureuse, Inventec Informatik AG, Switzerland, www.source-code.biz
	 **/
	public static String convertNumberToWords (int n) {
		if (n < 0) {
			return "minus " + convertNumberToWords(-n); }
		if (n <= 999) {
			return convert999(n); }
		String s = null;
		int t = 0;
		while (n > 0) {
			if (n % 1000 != 0) {
				String s2 = convert999(n % 1000);
				if (t > 0) {
					s2 = s2 + " " + bigNames[t-1]; }
				if (s == null) {
					s = s2; }
				else {
					s = s2 + ", " + s; }}
			n /= 1000;
			t++; }
		return s; }

	// Range 0 to 999.
	private static String convert999 (int n) {
		String s1 = lowNames[n / 100] + " hundred";
		String s2 = convert99(n % 100);
		if (n <= 99) {
			return s2; }
		else if (n % 100 == 0) {
			return s1; }
		else {
			return s1 + " " + s2; }}

	// Range 0 to 99.
	private static String convert99 (int n) {
		if (n < 20) {
			return lowNames[n]; }
		String s = tensNames[n / 10 - 2];
		if (n % 10 == 0) {
			return s; }
		return s + "-" + lowNames[n % 10]; }
}
