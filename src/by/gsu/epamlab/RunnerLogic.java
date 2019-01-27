package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.factory.MarkFactory;
import by.gsu.epamlab.interfaces.IResultDAO;

import static by.gsu.epamlab.constants.SqlQuery.*;
import static by.gsu.epamlab.constants.Constants.*;

public class RunnerLogic {

	public static void execute(IResultDAO reader, MarkFactory markFactory) {
		Connection cn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			cn = ConnectionManager.createConnection();
			st = cn.createStatement();
			rs = st.executeQuery(markFactory.getAvgMarkSqlQuery());
			while (rs.next()) {
				System.out.printf(FORMAT_AVG_OUTPUT, 
						rs.getString(LOGIN_NAME_POSITION), 
						rs.getDouble(AVG_MARK_POSITION));
			}
			rs.close();
			
			System.out.println();
			rs = st.executeQuery(GET_RESULTS_BY_DATE);
			List<Result> results = new LinkedList<>();
			while (rs.next()) {
				Result result = new Result(rs.getString(LOGIN_NAME_POSITION), 
						rs.getString(TEST_NAME_POSITION), 
						rs.getDate(RESULT_DATE_POSITION), 
						markFactory.getMarkFromFactory(rs.getInt(RESULT_MARK_POSITION)));
				results.add(result);
				System.out.println(result);
			}
			
			System.out.println();
			ListIterator<Result> it = results.listIterator(results.size());
			if (it.hasPrevious()) {
				Result res = it.previous();
				System.out.println(res);
				while (it.hasPrevious()) {
					Result previousRes = it.previous();
					if (res.getDate().compareTo(previousRes.getDate()) == 0) {
						System.out.println(previousRes);
					} else
						return;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAllResourses(rs, st, ps, cn);
		}

	}

}
