package com.accenture.lkm.dt;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
public class DateTimeAPIDemo {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime datetime = LocalDateTime.now();

		System.out.println(today);
		System.out.println(time);
		System.out.println(datetime);
		System.out.println(datetime.toLocalDate());
		System.out.println(datetime.toLocalTime());
		System.out.println(datetime.getMonth());
		System.out.println(datetime.getDayOfMonth());
		System.out.println(datetime.getDayOfYear());
		System.out.println(datetime.getSecond());
		
		LocalDate date1 = LocalDate.of(2008, 3, 10);
		System.out.println(date1);
		LocalTime time1 = LocalTime.of(5, 30);
		System.out.println(time1);
		System.out.println("Next week "+today.plus(1,ChronoUnit.WEEKS));
		System.out.println("Next 3 years  "+today.plus(3,ChronoUnit.YEARS));
		System.out.println("Next decade "+today.plus(1,ChronoUnit.DECADES));
		System.out.println("Last week "+today.minus(1,ChronoUnit.WEEKS));
		LocalDate nextWeek = today.plus(1,ChronoUnit.WEEKS);
		Period per = Period.between(nextWeek, today);
		System.out.println(per);
		LocalTime lt1 = time.plus(Duration.ofHours(2));
		Duration dur = Duration.between(lt1, time);
		System.out.println(dur);
		LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println(nextMonday);
		
		System.out.println(today.getYear());
		System.out.println(today.isLeapYear());
		System.out.println(today.isBefore(nextWeek));
		System.out.println(today.plusDays(20));
		
	}

}













