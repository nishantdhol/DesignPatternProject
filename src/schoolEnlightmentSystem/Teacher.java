package schoolEnlightmentSystem;

/*Teacher class is a concrete product of factor method. The class is implementing the methods of Product(Role)*/
public class Teacher implements Role{
	
	//This method is to open the respective student or teacher page.
	public void openWindow(String username) {		
		TeacherDashboard teacher = new TeacherDashboard(username);
		teacher.setTitle("Teacher Dashboard " + username);
		teacher.setVisible(true);
	};
}