package schoolEnlightmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//This class is providing connection with the database-jdbc
public class ConnectionProvider {
	public static Connection getConnection()
	{
		Connection con = null;
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/client", "root", "");
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null,"Unable to connect to database");
	}
	return con;
	}
}
