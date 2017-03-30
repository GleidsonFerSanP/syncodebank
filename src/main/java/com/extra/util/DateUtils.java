package com.extra.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class DateUtils {

	private static SimpleDateFormat simpleDateFormat;

	static {
		simpleDateFormat = new SimpleDateFormat("", new Locale("pt", "br"));
	}

	public static String formatarDataHora(Date data, String pattern) {
		if (data == null)
			return "";

		simpleDateFormat.applyPattern(pattern);
		return simpleDateFormat.format(data);
	}

	public static Date diminuir(Date data, int tipoCalendar, int qtd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(tipoCalendar, calendar.get(tipoCalendar) - qtd);
		return calendar.getTime();
	}
	
	public static Date acrescentar(Date data, int tipoCalendar, int qtd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(tipoCalendar, calendar.get(tipoCalendar) + qtd);
		return calendar.getTime();
	}

	public static Date inicioDia(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	public static Date fimDia(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);

		return c.getTime();
	}

	public static Date converterDataHora(String dataString, String pattern) {
		if (dataString == null || dataString.length() == 0)
			return null;

		simpleDateFormat.applyPattern(pattern);
		try {
			return simpleDateFormat.parse(dataString);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DateTime toDateTime(Date date){
		return new DateTime(date);
	}

	public static DateTime toDateTime(int year, int month, int day, int hour, int min){
		return new LocalDateTime(
				year,
				month,
				day,
				hour,
				min).toDateTime().withZoneRetainFields(DateTimeZone.UTC);
	}

	public static CustomDateEditor novoCustomDateEditor(String pattern,
			boolean permitirVazio) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setLenient(false);
		return new CustomDateEditor(simpleDateFormat, permitirVazio);
	}

}
