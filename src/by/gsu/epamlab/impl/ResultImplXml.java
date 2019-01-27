package by.gsu.epamlab.impl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.interfaces.IResultDAO;
import by.gsu.epamlab.parsers.ResultHandler;

import static by.gsu.epamlab.constants.Constants.*;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class ResultImplXml implements IResultDAO {
	private ListIterator<Result> iterator;
	

	public ResultImplXml(String fileName) {
		try {
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			parserFactory.setNamespaceAware(true);
			SAXParser saxParser = parserFactory.newSAXParser();
			ResultHandler handler = new ResultHandler();
			saxParser.parse(XML_FILE_NAME, handler);
			List<Result> list = handler.getResults();
			iterator = list.listIterator();
			if (list.isEmpty()) {
				throw new IOException(EMPTY_FILE);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println(FILE_ERROR);
		} 
	}

	@Override
	public Result nextResult() {
		return iterator.next();
	}

	@Override
	public boolean hasResult() {
		boolean hasNext = false;
		if (iterator != null && iterator.hasNext()) {
			hasNext = true;
		}
		return hasNext;
	}

	@Override
	public void closeReader() {}

}
