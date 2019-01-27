package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.interfaces.IResultDAO;

import static by.gsu.epamlab.constants.SqlQuery.*;

public class ResultsLoader {
	public static void loadResults(IResultDAO reader) {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.createConnection();
			st = con.createStatement();
			st.executeUpdate(CLEAR_LOGINS + CLEAR_TESTS + CLEAR_RESULTS);
			ps = con.prepareStatement(INSERT_INTO_LOGINS + "" + 
					INSERT_INTO_TESTS + 
					GET_LOGIN_ID + GET_TEST_ID + INSERT_INTO_RESULTS);
			while (reader.hasResult()) {
				Result result = reader.nextResult();
				String login = result.getLogin();
				String test = result.getTest();
				Date date = result.getDate();
				int mark = result.getMark().getValue();
				ps.setString(LOGIN_NAME_POSITION, login);
				ps.setString(TEST_NAME_POSITION, test);
				ps.setString(DESIRED_LOGIN_NAME_POSITION, login);
				ps.setString(DESIRED_TEST_NAME_POSITION, test);
				ps.setDate(DATE_POSITION, date);
				ps.setInt(MARK_POSITION, mark);
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeStatements(st, ps);
			ConnectionManager.closeConnection(con);
			reader.closeReader();
		}
	}
}
