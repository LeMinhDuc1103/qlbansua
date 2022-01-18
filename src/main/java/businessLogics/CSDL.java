package businessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSDL {
	private static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/qlbansua?useUnicode=true&characterEncoding=UTF-8";
			con = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
