package schoolEnlightmentSystem;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


/*it is a Controller of MVC pattern*/
public class RegistrationController {
	private RegistrationView view;
    private RegistrationModel model;
    private String firstname_input;
	private String lastname_input;
	private String username_input,password_input,retype_password_input,birthdate_input,loginas_input,
	email_input,contact_number_input,address_input,student_id_input;

/*Initializing the RegistrationController constructor and 
* also initializing RegistrationView and RegistrationModel objects */	 
public RegistrationController(RegistrationView view){
        this.view = view;
        model = new RegistrationModel();
       
    }

//This method is providing the user inputs
public void initView() {
	firstname_input=view.getfirstname_textField().getText();
	lastname_input=view.getlastname_textField().getText();
	username_input=view.getusername_textField().getText();
	password_input=view.getpassword_textField().getText();
	retype_password_input=view.getretype_password_textField().getText();
	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
	birthdate_input=dateformat.format(view.getcalendar_birthdate_textField().getDate());
	loginas_input=view.getloginas_textField().getText();
	email_input=view.getemail_textField().getText();
	contact_number_input=view.getcontact_number_textField().getText();
	address_input=view.getaddress_textField().getText();
	student_id_input=view.getstudent_id_textField().getText();
   	
    }

/*This method is providing the user input data to the database model*/
public void checkRegistrationDetails(String firstname, String lastname,String username,String loginas, String password, 
		String retype_password, String birthdate, String email,String contact_number,String address,String student_id) {
	 initView();
	firstname=firstname_input;
	lastname=lastname_input;
	username=username_input;
	loginas=loginas_input;
	password=password_input;
	retype_password=retype_password_input;
	birthdate=birthdate_input;
	email=email_input;
	contact_number=contact_number_input;
	address=address_input;
	student_id=student_id_input;
	   model.setfirstname_textField(firstname);
	   model.setlastname_textField(lastname);
	   model.setusername_textField(username);
	   model.setloginas_textField(loginas);
	   model.setpassword_textField(password);
	   model.setretype_password_textField(retype_password);
	   model.setemail_textField(email);
	   model.setcalendar_birthdate_textField(birthdate);
	   model.setcontact_number_textField(contact_number);
	   model.setaddress_textField(address);
	   model.setstudent_id_textField(student_id);
		if(firstname.equals("")) {
			view.setMessage("Enter the firstname");
		}if(lastname.equals("")) {
			view.setMessage("Enter the lastname");
		}
		
		if(username.equals("")) {
			view.setMessage("Enter the username");
		}
		if(password.equals("")) {
			view.setMessage("Enter the password");
		}
		if(retype_password.equals("")) {
			view.setMessage("Re-Enter the password");
		}		
		if(email.equals("")) {
			view.setMessage("Enter email id");
		}
		if(contact_number.equals("")) {
			view.setMessage("Enter the contact details");
		}
		if(address.equals("")) {
			view.setMessage("Enter the address");
		}
		if(student_id.equals("")) {
			view.setMessage("Enter the student_id");
		}
		else {
			try {
				model.getRegistrationDetails(view);	
			if(password.equals(retype_password))
            {
                 
				
				view.setMessage("Data Registered Successfully");
            
            }
            else
            {
            	view.setMessage("password did not match");
            }
		 
	} catch (Exception e1) {
		view.setMessage("Check the details again");
		
	}
		}

   }
}
