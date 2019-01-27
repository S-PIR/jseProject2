package by.gsu.epamlab.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.factory.MarkFactory;
import by.gsu.epamlab.interfaces.IResultDAO;

import static by.gsu.epamlab.constants.Constants.*;

public class ResultImplCsv implements IResultDAO {
	private Scanner scanner;
	private MarkFactory markFactory;
	
	public ResultImplCsv(String fileName, MarkFactory markFactory) {
		try {
			scanner = new Scanner(new FileReader(fileName));
			scanner.useLocale(Locale.ENGLISH);
			this.markFactory = markFactory;
		} catch (FileNotFoundException e) {
			System.err.println(FILE_ERROR);
		} 
	}

	@Override
	public Result nextResult() {
		Result result = new Result();
		String[] tmp = scanner.nextLine().split(DELIMITER);
		result.setLogin(tmp[LOGIN_INDEX]);
		result.setTest(tmp[TEST_INDEX]);
		result.setDate(tmp[DATE_INDEX]);
		result.setMark(markFactory.getMarkFromFactory(tmp[MARK_INDEX]));
		return result;
	}

	@Override
	public boolean hasResult() {
		boolean hasNext = false;
		if (scanner != null && scanner.hasNext()) {
			hasNext = true;
		}
		return hasNext;
	}

	@Override
	public void closeReader() {
		if (scanner != null) {
			scanner.close();
		}
	}

}
