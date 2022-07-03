package tracking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BaseDao {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/tracking_product";
	private static final String USER = "root";
	private static final String PASS = "root";

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println("Lỗi khởi tạo connection " + e);
		}
		return null;
	}

	public void closeConnection(Connection connection, PreparedStatement ps, Statement s) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (s != null) {
				s.close();
			}
		} catch (Exception e) {
			System.out.println("Lỗi close connection " + e);
		}
	}
}
