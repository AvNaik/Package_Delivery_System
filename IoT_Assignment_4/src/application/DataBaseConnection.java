package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

		private Connection connect = null;
		public Connection getConnected() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex_tracking?useSSL=false","root", "Avadhut_2392");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return connect;
		}
		public void closeConnection()
		{
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
