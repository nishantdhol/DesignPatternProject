package schoolEnlightmentSystem;


/*TeacherFactory plays two roles-
* 1.it is a Concrete Creator of factory method.
* 2.it is a Controller of MVC pattern*/
class TeacherFactory implements RoleTypeFactory{
		private LoginView view;
	    private LoginModel model;
	   

 /*Initializing the TeacherFactory constructor and 
 ** also initializing LoginView and LoginModel objects since it is a Controller */
public TeacherFactory() {
		   
 view=new LoginView();
 model = new LoginModel();
 initView();
		   	   
}
	
//This method is providing the user inputs
public void initView() {
	   view.getusername_textField();
	   view.getpassword_textField();
	   view.getLoginAs_comboBox();
			    	
 }

/*This	method is performing different tasks -
 * 1.it is the actual factory method of factory design pattern.
 * 2. it is verifying the user input data against the data available in database which is a task of Controller in MVC pattern*/
public RoleTypeFactory checkCredentials(String username, String password,String loginas) {
			
			  model.setUsername(username);
		       model.setPassword(password);
		       model.setLoginAs(loginas);
		       if(username.equals("") || password.equals("") || loginas.equals("SELECT")) {
		    	   view.setMessage("Some Fields are empty");
				}
		       else {
		    	   try {
		   			model.getCredentials();
		   			if(username.equals(model.getUsername()) && password.equals(model.getPassword())){
		   				if(loginas.equalsIgnoreCase("TEACHER") && loginas.equalsIgnoreCase("teacher")){
		   					view.setMessage("Login Successful...");
		   	   					Teacher t= new Teacher();
		   	   					t.openWindow(username);
		   				}
		   			}
		   			else {
	   					view.setMessage("Incorrect Username or Password or loginas");
	   				}
		    	   }
		   			catch(Exception e) {
		   				e.printStackTrace();
		   			}
	}
			return null;
			
		       }
	}




