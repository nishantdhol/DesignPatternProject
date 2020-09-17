package schoolEnlightmentSystem;	

class StudentFactory implements RoleTypeFactory{
	private LoginView view;
    private LoginModel model;
	
public StudentFactory() {
	   view=new LoginView();
	   model = new LoginModel();
	   initView();
	   	   	   
   }
public void initView() {
		
		   view.getusername_textField();
		   view.getpassword_textField();
		   view.getLoginAs_comboBox();
}
	 
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
	   				if(loginas.equalsIgnoreCase("STUDENT") && loginas.equalsIgnoreCase("student")){
	   					view.setMessage("Login Successful...");
	   					Student s=new Student();
	   					s.openWindow(username);
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

