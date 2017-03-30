package com.ilion.homecarecenter.service.agendamento;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateTest {
	
	private LocalDate domingo;
	private LocalDate segunda;
	private LocalDate terca;
	/*private LocalDate quarta;
	private LocalDate quinta;
	private LocalDate sexta;
	private LocalDate sabado;*/
	
	@Before
	public void loadDates(){
		
		segunda = new LocalDate(2016,11,21);
		terca = new LocalDate(2016,11,22);
		/*quarta = new LocalDate(2016,11,23);
		quinta = new LocalDate(2016,11,24);
		sexta = new LocalDate(2016,11,25);
		sabado = new LocalDate(2016,11,26);*/
		domingo = new LocalDate(2016,11,27);
	}

	@Test
	public void testDomingo() {
		
		LocalDate inicio = domingo.withDayOfWeek(DateTimeConstants.MONDAY);
		LocalDate fim = domingo.withDayOfWeek(DateTimeConstants.SUNDAY);
		
		System.out.println(inicio);
		System.out.println(fim);
		
		Assert.assertEquals(new LocalDate(2016,11,21), inicio);
		Assert.assertEquals(new LocalDate(2016,11,27), fim);
	}
	
	@Test
	public void testSegunda() {
		
		LocalDate inicio = segunda.withDayOfWeek(DateTimeConstants.MONDAY);
		LocalDate fim = segunda.withDayOfWeek(DateTimeConstants.SUNDAY);
		
		System.out.println(inicio);
		System.out.println(fim);
		
		Assert.assertEquals(new LocalDate(2016,11,21), inicio);
		Assert.assertEquals(new LocalDate(2016,11,27), fim);
	}

	@Test
	public void testTerca() {
		
		LocalDate inicio = terca.withDayOfWeek(DateTimeConstants.MONDAY);
		LocalDate fim = terca.withDayOfWeek(DateTimeConstants.SUNDAY);
		
		System.out.println(inicio);
		System.out.println(fim);
		
		Assert.assertEquals(new LocalDate(2016,11,21), inicio);
		Assert.assertEquals(new LocalDate(2016,11,27), fim);
	}

	@Test
	public void testQuarta() {
		
		LocalDate inicio = terca.withDayOfWeek(DateTimeConstants.MONDAY);
		LocalDate fim = terca.withDayOfWeek(DateTimeConstants.SUNDAY);
		
		System.out.println(inicio);
		System.out.println(fim);
		
		Assert.assertEquals(new LocalDate(2016,11,21), inicio);
		Assert.assertEquals(new LocalDate(2016,11,27), fim);
	}

}
