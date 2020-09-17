package schoolEnlightmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


//This class is the Model of MVC(ProfileView,ProfileModel,ProfileController) pattern.
public class ProfileModel {
	private String username;
	private String firstname_input;
	private String lastname_input;
	private String student_id_input,birthdate_input,email_input,contact_number_input,address_input;

//class constructor	
public ProfileModel(String username) {
	this.username=username;
	
}
//getters and setters
public String getUsername() {
	return username;
}

	
public String getstudent_id_textField() {
		return student_id_input;
	}

public void setstudent_id_textField(String student_id_input) {
		this.student_id_input = student_id_input;
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


//This method is creating database connection to get the profile details of respective logged in user.
public void getProfileDetails( ) throws ClassNotFoundException{
	    try {
	
	Connection conn= ConnectionProvider.getConnection();
	PreparedStatement ps = conn.prepareStatement("select first_name,last_name,address,email,contact_number,birthdate,student_id from user_data where user_name=?");
    ps.setString(1, username);
    
    ResultSet rs = ps.executeQuery();
   if (rs.next()) {    	
       	firstname_input=rs.getString("first_name");
    	lastname_input=rs.getString("last_name");
       	email_input=rs.getString("email");
       	student_id_input=rs.getString("student_id");
       	contact_number_input=rs.getString("contact_number");
       	birthdate_input=rs.getString("birthdate");
       	address_input=rs.getString("address");
   	 }
    
   else {
	   JOptionPane.showMessageDialog(null,"Could not load profile details");
   }
    conn.close();
    }
catch(Exception e) {
	JOptionPane.showMessageDialog(null,"Could not establish the connection!");
	
}
		  
	  }
}
