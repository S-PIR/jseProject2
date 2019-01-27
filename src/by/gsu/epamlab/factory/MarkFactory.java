package by.gsu.epamlab.factory;

import by.gsu.epamlab.beans.Mark;

import static by.gsu.epamlab.constants.SqlQuery.GET_AVG_MARK;

public class MarkFactory {

	public Mark getMarkFromFactory(int mark) {
		return new Mark(mark);
	}
	
	public Mark getMarkFromFactory(String mark) {
		return new Mark(mark);
	}
	
	public String getAvgMarkSqlQuery() {
		return GET_AVG_MARK;
	}

}
