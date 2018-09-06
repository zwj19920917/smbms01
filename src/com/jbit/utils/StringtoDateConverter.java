package com.jbit.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringtoDateConverter implements Converter<String, Date> {
	private String pattern; //外部指定(调用者)
	
	public StringtoDateConverter(String pattern) {
		super();
		this.pattern = pattern;
	}

	public Date convert(String dateStr) {
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
