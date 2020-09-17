package schoolEnlightmentSystem;

//This class is the Controller of MVC(ProfileView,ProfileModel,ProfileController) pattern.
public class ProfileController {
	private ProfileView view;
    private ProfileModel model;
    private String username,firstname,lastname;
    private String student_id,birthdate,email,contact_number,address;
   
    
/*Initializing the ProfileController constructor and 
* also initializing ProfileView and ProfileModel objects */
public ProfileController(ProfileView view){
        this.view = view;
        username=view.getUsername();
        model = new ProfileModel(username);
    }

//This method provides data to the ProfileView
public void initView() {
	view.getFirst_name_textField().setText(firstname);
	view.getLast_name_textField().setText(lastname);
	view.getStudent_id_textField().setText(student_id);
	view.getBirthdate_textField().setText(birthdate);
	view.getEmail_textField().setText(email);
	view.getContact_number_textField().setText(contact_number);
	view.getAdddress_textField().setText(address);
		
    }

//This method is to take user profile details from ProfileModel and provide them to ProfileView
public void checkUserProfile() {
	
	try {
		model.getProfileDetails();
		firstname=model.getFirst_name_textField();
		lastname=model.getLast_name_textField();
		birthdate=model.getBirthdate_textField();
		email=model.getEmail_textField();
		contact_number=model.getContact_number_textField();
		address=model.getAddress_textField();
		student_id=model.getstudent_id_textField();
		
		initView();
		
		
		
	} catch (ClassNotFoundException e) {
		view.setMessage("Could not extract profile details");
	}
}

}
