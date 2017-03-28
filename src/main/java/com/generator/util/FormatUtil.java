package com.generator.util;

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
	private static final SimpleDateFormat DATETIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

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
}
