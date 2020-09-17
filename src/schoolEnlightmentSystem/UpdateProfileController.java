package schoolEnlightmentSystem;


import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

//This class is the Controller of MVC(UpdateProfileView,UpdateProfileModel,UpdateProfileController) pattern.
public class UpdateProfileController {
	private UpdateProfileView view;
    private UpdateProfileModel model;
    private String username;
    private String firstname_input;
	private String lastname_input;
	private String username_input,password_input,birthdate_input,email_input,contact_number_input,address_input,loginas_input;
	

/*Initializing the UpdateProfileController constructor and 
* also initializing UpdateProfileView and UpdateProfileModel objects */	
public UpdateProfileController(UpdateProfileView view){
        this.view=view;
        username=view.getUsername();
        model = new UpdateProfileModel(username);
        
    }

//This method is providing data to the ProfileView
public void initView() {
	  
	   view.getFirst_name_textField().setText(firstname_input);
	   view.getLast_name_textField().setText(lastname_input);;
	   view.getUsername_textField().setText(username_input);
	   view.getAddress_textField().setText(address_input);
	   view.getLoginas_textField().setText(loginas_input);
	   view.getBirthdate_textField().setText(birthdate_input);
	   view.getContact_number_textField().setText(contact_number_input);
	   view.getPassword_textField().setText(password_input);
	   view.getEmail_textField().setText(email_input);
	  
   	
    }

//This method is getting user details from model and providing it to view
public void checkProfileDetials() {
	try {
		model.getProfileDetials(view);
		firstname_input=model.getFirst_name_textField();
		lastname_input=model.getLast_name_textField();
		 username_input=model.getUsername_textField();
		 password_input=model.getPassword_textField();
		 birthdate_input=model.getBirthdate_textField();
		 email_input=model.getEmail_textField();
		contact_number_input=model.getContact_number_textField();
		address_input=model.getAddress_textField();
		loginas_input=model.getLoginas_textField();
		initView();
		
	
	} catch (ClassNotFoundException e) {
		view.setMessage("Could not extract profile details");
	}
}

//This method is updating user profile details view to model
public void checkUpdatedProfileDetails() throws ClassNotFoundException {
	model.getUpdatedProfileDetails(view);	
	
	
}
}
