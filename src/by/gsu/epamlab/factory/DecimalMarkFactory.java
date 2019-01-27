package by.gsu.epamlab.factory;

import static by.gsu.epamlab.constants.SqlQuery.GET_AVG_DECIMAL_MARK;

import by.gsu.epamlab.beans.DecimalMark;
import by.gsu.epamlab.beans.Mark;

public class DecimalMarkFactory extends MarkFactory {
	public Mark getMarkFromFactory(int mark) {
		return new DecimalMark(mark);
	}
	
	public String getAvgMarkSqlQuery() {
		return GET_AVG_DECIMAL_MARK;
	}
	
}
