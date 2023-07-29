package com.epam.practice.java8.practice;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimePracticeJava8 {

	public static void main(String[] args) {

		System.out.println("Date time practices!!!");
		LocalDate ld1 = LocalDate.now();
		LocalDate ld2 = LocalDate.of(1997, Month.APRIL, 13);
		System.out.println(ld2);
		LocalTime lt1 = LocalTime.now();
		LocalTime lt2 = LocalTime.of(5, 20);
		System.out.println(lt2);
		LocalDateTime ldt1 = LocalDateTime.now();
		LocalDateTime ldtc = LocalDateTime.of(1997, 04, 13, 18, 20, 23);
		LocalDateTime ldtc1 = LocalDateTime.of(1997, 04, 14, 18, 20, 23);
		System.out.println(ldt1);
		for (String zoneId : ZoneId.getAvailableZoneIds()) {
			ZoneId zoneId1 = ZoneId.of(zoneId);
			String zoneIdDisplayName = zoneId1.getDisplayName(TextStyle.FULL, Locale.UK);
			System.out.println(zoneId + " : " + zoneIdDisplayName);

		}
		ZoneId zoneId2 = ZoneId.of("Asia/Singapore");
		LocalDateTime ldt3 = LocalDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.of(ldt3, zoneId2);
		System.out.println(zdt);
		ZonedDateTime zdt1 = ldt3.atZone(zoneId2);
		ZonedDateTime zdt2 = ZonedDateTime.now();// based on systems time zone
		System.out.println(zdt.getZone());

		Clock clock = Clock.system(zoneId2);
		System.out.println(clock);
		Instant instant = clock.instant();
		System.out.println(instant);
		Clock clock2 = Clock.offset(clock, Duration.ofHours(10));
		System.out.println(clock2.instant());
		System.out.println(ldtc1.compareTo(ldtc));
		System.out.println("is after: " + ldtc.isAfter(ldtc1));
		System.out.println("is before: " + ldtc.isBefore(ldtc1));
		System.out.println("is equal: " + ldtc.isEqual(ldtc1));
		String formattedDate = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ldtc1);
		System.out.println(formattedDate);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(dtf.format(ldtc1));
		System.out.println(dtf1.format(ldtc1));

		Period p1 = Period.of(1, 1, 1);
		System.out.println(p1);
		Period p2 = Period.ofWeeks(4);
		System.out.println(p2);
		Period p3 = Period.between(ld2, ld1);
		System.out.println(p3);
		long ageInDays = ChronoUnit.YEARS.between(ld2, ld1);
		System.out.println(ageInDays);

		Duration d1 = Duration.of(5, ChronoUnit.DAYS);
		System.out.println(d1);
		Duration d2 = Duration.ofHours(5);
		System.out.println(d2);
		LocalTime lt = LocalTime.now();
		LocalTime lt3 = LocalTime.of(18, 50);
		Duration d3 = Duration.between(lt3, lt);
		System.out.println(d3);

		LocalDateTime ldt5 = LocalDateTime.now();
		System.out.println(ldt5);
		LocalDateTime ldt6 = ldt5.plusHours(5);
		System.out.println(ldt6);
		LocalDateTime ldt7 = ldt5.plus(Duration.ofHours(5));
		System.out.println(ldt7);
		LocalDateTime ldt8 = ldt5.withMonth(12);
		System.out.println(ldt8);

		Date date = new Date();
		System.out.println(date);
		LocalDateTime ldt9 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(ldt9);
		Calendar cal = Calendar.getInstance();
		LocalDateTime ldt10 = cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(ldt10);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println(LocalDateTime.now().format(df));

	}

}
