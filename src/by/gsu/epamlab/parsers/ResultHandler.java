package by.gsu.epamlab.parsers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.gsu.epamlab.beans.DecimalMark;
import by.gsu.epamlab.beans.Result;

public class ResultHandler extends DefaultHandler {
	private static enum ResultEnum {
		RESULTS, STUDENT, LOGIN, TESTS, TEST; 
	}
	private List<Result> results = new ArrayList<>();
	private ResultEnum currentEnum;
	private String login;
	
	public List<Result> getResults() {
		return results;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentEnum = ResultEnum.valueOf(localName.toUpperCase());
		if (currentEnum == ResultEnum.TEST) {
			final int TEST_INDEX = 0, DATE_INDEX = 1, MARK_INDEX = 2;
			Result result = new Result();
			result.setLogin(login);
			result.setTest(attributes.getValue(TEST_INDEX));
			result.setDate(attributes.getValue(DATE_INDEX));
			result.setMark(new DecimalMark(attributes.getValue(MARK_INDEX)));
			results.add(result);
		}
		

	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentEnum == ResultEnum.LOGIN) {
			String str = new String (ch, start, length).trim(); 
			if(!str.isEmpty()) {
				login = str;
			}
		}

	}
}
