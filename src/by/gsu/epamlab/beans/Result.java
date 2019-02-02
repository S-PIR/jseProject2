package by.gsu.epamlab.beans;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import by.gsu.epamlab.constants.Constants;

public class Result {
	private String login;
	private String test;
	private Date date;
	private Mark mark;

	private final static SimpleDateFormat GET_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	private final static SimpleDateFormat SET_DATE_FORMAT = new SimpleDateFormat("yy-MM-dd");

	public Result() {
		super();
	}

	public Result(String login, String test, Date date, Mark mark) {
		super();
		this.login = login;
		this.test = test;
		this.date = date;
		this.mark = mark;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDate(String dateString) {
		try {
			date = new Date(SET_DATE_FORMAT.parse(dateString).getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(Constants.ERROR_PARSE_DATE);
		}
	}

	public String getStringDate() {
		return GET_DATE_FORMAT.format(date);
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return login + ";" + test + ";" + date + ";" + mark;
	}

}
