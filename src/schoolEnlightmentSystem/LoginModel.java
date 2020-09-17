package schoolEnlightmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginModel {
    private String username, password,loginas;
    private Connection conn;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getLoginAs() {
        return loginas;
    }

    public void setLoginAs(String loginas) {
        this.loginas = loginas;
    }


    public void getCredentials() throws ClassNotFoundException{
        try {
        	// establish connection  
	         conn= ConnectionProvider.getConnection();
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/client", "root", "");
            
            PreparedStatement select = conn.prepareStatement("SELECT user_name,password,login_as FROM user_data WHERE user_name =? and password=? and login_as=?");
            select.setString(1, username);
            select.setString(2, password);
            select.setString(3, loginas);
            ResultSet rs = select.executeQuery();
            if(rs.next()){
            	username=rs.getString("user_name");
                password = rs.getString("password");
                loginas=rs.getString("login_as");
             
            }
            else{
            	username="";
                password = "";
                loginas="";
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Unable to get login details!");
        }
        finally{
            try {
                conn.close();
            } catch (SQLException e) {
            	 JOptionPane.showMessageDialog(null,"Connection is not closed properly!");
            }
        }
    }
}