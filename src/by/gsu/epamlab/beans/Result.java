package by.gsu.epamlab.beans;

import java.sql.Date;

public class Result {
	private String login;
	private String test;
	private Date date;
	private Mark mark;

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

	public void setDate(String date) {
		this.date = Date.valueOf(date);
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
