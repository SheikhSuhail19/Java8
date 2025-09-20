package org.java8;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/**
 * Comprehensive demo of Java 8 Date and Time API (java.time package).
 * Covers all major classes and features.
 */
public class Java8DateTimeApiDemo {
	public static void main(String[] args) {
		demoLocalDateTime();
		demoZonedDateTime();
		demoInstant();
		demoPeriodDuration();
		demoFormattingParsing();
		demoTemporalAdjusters();
		demoClockZoneId();
		demoLegacyInterop();
		demoComparisons();
	}

	static void demoLocalDateTime() {
		// LocalDate, LocalTime, LocalDateTime
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDate specificDate = LocalDate.of(2025, Month.SEPTEMBER, 21);
		LocalTime specificTime = LocalTime.of(14, 30, 15);
		LocalDateTime specificDateTime = LocalDateTime.of(specificDate, specificTime);
		System.out.println("LocalDate: " + date);
		System.out.println("LocalTime: " + time);
		System.out.println("LocalDateTime: " + dateTime);
		System.out.println("Specific LocalDateTime: " + specificDateTime);
		// Plus, minus, with, get
		System.out.println("Tomorrow: " + date.plusDays(1));
		System.out.println("Last week: " + date.minusWeeks(1));
		System.out.println("With day of month: " + date.withDayOfMonth(1));
		System.out.println("Day of week: " + date.getDayOfWeek());
	}

	static void demoZonedDateTime() {
		// ZonedDateTime, OffsetDateTime, OffsetTime
		ZonedDateTime zonedNow = ZonedDateTime.now();
		ZonedDateTime zonedParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		OffsetDateTime offsetNow = OffsetDateTime.now();
		OffsetTime offsetTime = OffsetTime.now();
		System.out.println("ZonedDateTime: " + zonedNow);
		System.out.println("ZonedDateTime Paris: " + zonedParis);
		System.out.println("OffsetDateTime: " + offsetNow);
		System.out.println("OffsetTime: " + offsetTime);
		// List all available zones
		Set<String> zones = ZoneId.getAvailableZoneIds();
		System.out.println("Total available zones: " + zones.size());
	}

	static void demoInstant() {
		// Instant (machine timestamp)
		Instant instant = Instant.now();
		System.out.println("Instant: " + instant);
		// Convert to ZonedDateTime
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		System.out.println("Instant as ZonedDateTime: " + zdt);
		// Epoch seconds/millis
		System.out.println("Epoch seconds: " + instant.getEpochSecond());
		System.out.println("Epoch millis: " + instant.toEpochMilli());
	}

	static void demoPeriodDuration() {
		// Period (date-based), Duration (time-based)
		Period period = Period.between(LocalDate.of(2020, 1, 1), LocalDate.now());
		Duration duration = Duration.between(LocalTime.of(8, 0), LocalTime.now());
		System.out.println("Period since 2020-01-01: " + period);
		System.out.println("Duration since 08:00: " + duration);
		// Add/subtract
		System.out.println("Add 2 weeks: " + LocalDate.now().plus(Period.ofWeeks(2)));
		System.out.println("Add 3 hours: " + LocalTime.now().plus(Duration.ofHours(3)));
	}

	static void demoFormattingParsing() {
		// Formatting and parsing
		LocalDate date = LocalDate.of(2025, 9, 21);
		DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter localized = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.FRANCE);
		String formatted = date.format(customFormatter);
		System.out.println("Formatted date: " + formatted);
		LocalDate parsed = LocalDate.parse("21/09/2025", customFormatter);
		System.out.println("Parsed date: " + parsed);
		System.out.println("Localized format: " + LocalDateTime.now().format(localized));
	}

	static void demoTemporalAdjusters() {
		// TemporalAdjusters
		LocalDate now = LocalDate.now();
		LocalDate nextMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastDayOfYear = now.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("Next Monday: " + nextMonday);
		System.out.println("First day of month: " + firstDayOfMonth);
		System.out.println("Last day of year: " + lastDayOfYear);
		// Week fields
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		int weekNumber = now.get(weekFields.weekOfWeekBasedYear());
		System.out.println("Week number: " + weekNumber);
	}

	static void demoClockZoneId() {
		// Clock, ZoneId, ZoneOffset
		Clock clock = Clock.systemUTC();
		Instant instant = clock.instant();
		ZoneId zoneId = ZoneId.systemDefault();
		ZoneOffset offset = ZoneOffset.ofHours(-5);
		System.out.println("Clock instant: " + instant);
		System.out.println("System ZoneId: " + zoneId);
		System.out.println("Custom ZoneOffset: " + offset);
	}

	static void demoLegacyInterop() {
		// Legacy interop: Date, Calendar
		Instant instant = Instant.now();
		Date legacyDate = Date.from(instant);
		Instant backToInstant = legacyDate.toInstant();
		System.out.println("Legacy Date: " + legacyDate);
		System.out.println("Back to Instant: " + backToInstant);
		// TimeZone to ZoneId
		TimeZone tz = TimeZone.getTimeZone("America/New_York");
		ZoneId zoneId = tz.toZoneId();
		System.out.println("TimeZone to ZoneId: " + zoneId);
	}

	static void demoComparisons() {
		// Compare, isBefore, isAfter, equals
		LocalDate today = LocalDate.now();
		LocalDate future = today.plusDays(10);
		System.out.println("Is today before future? " + today.isBefore(future));
		System.out.println("Is today after future? " + today.isAfter(future));
		System.out.println("Is today equal to today? " + today.equals(LocalDate.now()));
		// ChronoUnit between
		long daysBetween = ChronoUnit.DAYS.between(today, future);
		System.out.println("Days between today and future: " + daysBetween);
	}
}

