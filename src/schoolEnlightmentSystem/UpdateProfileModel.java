package schoolEnlightmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//This class is the Model of MVC(UpdateProfileView,UpdateProfileModel,UpdateProfileController) pattern.
public class UpdateProfileModel {
	private String username;
	private String firstname_input;
	private String lastname_input;
	private String username_input,password_input,birthdate_input,loginas_input,
	email_input,contact_number_input,address_input;
	
	
	
//Class constructor
public UpdateProfileModel(String username) {
		this.username=username;
	}

//getters and setters
public String getUsername() {
		return username;
	}
public String getUsername_textField() {
		return username_input;
	}

public void setUsername_textField(String username_input) {
		this.username_input = username_input ;
	}

public String getPassword_textField() {
		return password_input;
	}

public void setPassword_textField(String password_input) {
		this.password_input = password_input;
	}

public String getLoginas_textField() {
		return loginas_input;
	}

public void setLoginas_textField(String loginas_input) {
		this.loginas_input = loginas_input;
	}

public String getFirst_name_textField() {
		return firstname_input;
	}

public void setFirst_name_textField(String firstname_input) {
		this.firstname_input = firstname_input;
	}

public String getLast_name_textField() {
		return lastname_input;
	}

public void setLast_name_textField(String lastname_input) {
		this.lastname_input = lastname_input;
	}

public String getEmail_textField() {
		return email_input;
	}

public void setEmail_textField(String email_input) {
		this.email_input = email_input;
	}

public String getContact_number_textField() {
		return contact_number_input;
	}

public void setContact_number_textField(String contact_number_input) {
		this.contact_number_input = contact_number_input;
	}

public String getBirthdate_textField() {
		return birthdate_input;
	}

public void setBirthdate_textField(String birthdate_input) {
		this.birthdate_input = birthdate_input;
	}

public String getAddress_textField() {
		return address_input;
	}

public void setAddress_textField(String address_input) {
		this.address_input = address_input;
	}
	
//This method is getting the user profile details from the database
public void getProfileDetials(UpdateProfileView view) throws ClassNotFoundException{
	        try {
	           
	        	Connection conn= ConnectionProvider.getConnection();
	            
	            PreparedStatement pst = conn.prepareStatement("Select USER_NAME, PASSWORD, LOGIN_AS, FIRST_NAME, LAST_NAME, EMAIL, CONTACT_NUMBER, BIRTHDATE, ADDRESS from user_data where user_name=?");
	            pst.setString(1, username);
	            
				ResultSet rs=pst.executeQuery();
				if(rs.next()) { 
					username_input = rs.getString("USER_NAME");			      
					password_input = rs.getString("PASSWORD");        
					loginas_input = rs.getString("LOGIN_AS");
			        firstname_input = rs.getString("FIRST_NAME");
			        lastname_input= rs.getString("LAST_NAME");
			        email_input = rs.getString("EMAIL");
			        contact_number_input = rs.getString("CONTACT_NUMBER");
			        birthdate_input = rs.getString("BIRTHDATE");
			        address_input = rs.getString("ADDRESS");			        
			       
			    
			           	
			           	
			     
				}else {
					view.setMessage("Could not load profile information!");
				    
				}
				
				conn.close();
	        } catch (SQLException e) {
	        	view.setMessage("Could not connect to the database!");
	        }
	        
	    }

//This method is updating user profile details in the database
public void getUpdatedProfileDetails(UpdateProfileView view) {
	try { 
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/client", "root", "");
	PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE USER_DATA SET USER_NAME=?,PASSWORD=?, LOGIN_AS=?, FIRST_NAME=?, LAST_NAME=?, EMAIL=?, CONTACT_NUMBER=?, BIRTHDATE=?, ADDRESS=? where user_name=?");
				
				
				pst.setString(1, view.getUsername_textField().getText().toString());
				pst.setString(2, view.getPassword_textField().getText().toString());
				pst.setString(3, view.getLoginas_textField().getText().toString());
				pst.setString(4, view.getFirst_name_textField().getText().toString());
				pst.setString(5, view.getLast_name_textField().getText().toString());
				pst.setString(6, view.getEmail_textField().getText().toString());
				pst.setString(7, view.getContact_number_textField().getText().toString());
				pst.setString(8, view.getBirthdate_textField().getText().toString());
				pst.setString(9, view.getAddress_textField().getText().toString());
				pst.setString(10, username);
				pst.executeUpdate();
			
				view.setMessage("Record is updated..."); 
		        con.close();  
		        
		    } catch (SQLException se) {  
		    	view.setMessage("Could not update the record");  
		    }  
		

}
}
