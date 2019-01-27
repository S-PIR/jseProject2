package by.gsu.epamlab.factory;

import static by.gsu.epamlab.constants.SqlQuery.GET_AVG_HALF_MARK;

import by.gsu.epamlab.beans.HalfMark;
import by.gsu.epamlab.beans.Mark;

public class HalfMarkFactory extends MarkFactory {
	public Mark getMarkFromFactory(int mark) {
		return new HalfMark(mark);
	}
	
	public Mark getMarkFromFactory(String mark) {
		return new HalfMark(mark);
	}
	
	public String getAvgMarkSqlQuery() {
		return GET_AVG_HALF_MARK;
	}
}
