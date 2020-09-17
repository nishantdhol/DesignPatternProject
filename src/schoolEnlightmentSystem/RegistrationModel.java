package schoolEnlightmentSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


//This class is the Model class of MVC(RegistrationView,RegistrationModel,RegistrationController) pattern.
public class RegistrationModel {
	private String firstname_input;
	private String lastname_input;
	private String username_input,password_input,retype_password_input,birthdate_input,loginas_input,
	email_input,contact_number_input,address_input,student_id_input;
	
//getters and setters
public String getfirstname_textField() {
		  return  firstname_input;
	 }
		 
public void setfirstname_textField(String firstname_input) {
		 this.firstname_input = firstname_input;
		
	}
public String getlastname_textField() {
	  return lastname_input;
}
	 
public void setlastname_textField(String lastname_input) {
	 this.lastname_input = lastname_input;
	
}

public String getusername_textField() {
		  return username_input;
	 }
		 
public void setusername_textField(String username_input) {
		 this.username_input = username_input;
		
	}
public String getaddress_textField() {
	  return address_input;
}
	 
public void setaddress_textField(String address_input) {
	 this.address_input = address_input;
	
}
public String getpassword_textField() {
	  return password_input;
}
	 
public void setpassword_textField(String password_input) {
	 this.password_input = password_input;
	
}
public String getretype_password_textField() {
	  return retype_password_input;
}
	 
public void setretype_password_textField(String retype_password_input) {
	 this.retype_password_input = retype_password_input;
	
}
public String getemail_textField() {
	  return email_input;
}
	 
public void setemail_textField(String email_input) {
	 this.email_input = email_input;
	
}
public String getcontact_number_textField() {
	  return contact_number_input;
}
	 
public void setcontact_number_textField(String contact_number_input) {
	 this.contact_number_input = contact_number_input;
	
}
public String getloginas_textField() {
	  return loginas_input;
}
	 
public void setloginas_textField(String loginas_input) {
	 this.loginas_input = loginas_input;
	
}
public String getstudent_id_textField() {
	  return student_id_input;
}
	 
public void setstudent_id_textField(String student_id_input) {
	 this.student_id_input = student_id_input;
	
}
public String getcalendar_birthdate_textField() {
	  return birthdate_input;
}
	 
public void setcalendar_birthdate_textField(String birthdate_input) {
	 this.birthdate_input = birthdate_input;
	
}


//This method is creating database connection to register the user details.
public String getRegistrationDetails(RegistrationView rview) {
	//getting the user inputs from registration form
	/*firstname_input=rview.getfirstname_textField().getText();
	lastname_input=rview.getlastname_textField().getText();
	username_input=rview.getusername_textField().getText();
	password_input=rview.getpassword_textField().getText();
	retype_password_input=rview.getretype_password_textField().getText();
	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
	birthdate_input=dateformat.format(rview.getcalendar_birthdate_textField().getDate());
	loginas_input=rview.getloginas_textField().getText();
	email_input=rview.getemail_textField().getText();
	contact_number_input=rview.getcontact_number_textField().getText();
	address_input=rview.getaddress_textField().getText();
	student_id_input=rview.getstudent_id_textField().getText();*/


PreparedStatement st = null;
    try {
    	Connection con= ConnectionProvider.getConnection();
    	String insert_query="INSERT INTO user_data VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		st=con.prepareStatement(insert_query);
		st.setString(4, firstname_input);
		st.setString(6, lastname_input);
		st.setString(1, username_input);
		st.setString(2, password_input);
		st.setString(9, birthdate_input);
		st.setString(3, loginas_input);
		st.setString(7, email_input);
		st.setString(8, contact_number_input);
		st.setString(5, address_input);
		st.setString(10, student_id_input);
		if(password_input.equals(retype_password_input))
        {
             //Executing query
            st.executeUpdate();
         
         }
		
		else {
			return "NO";
		}
		con.close();
		
    }
    catch(SQLException e1) {
				rview.setMessage("Can not establish the connection for registration!");
		
	}
	return "Registration Failed";
}
}
