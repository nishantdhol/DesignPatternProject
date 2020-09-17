package schoolEnlightmentSystem;

/*Student class is a concrete product of factor method. The class is implementing the methods of Product(Role)*/
public class Student implements Role {
	
	//This method is to open the respective student or teacher page.
	public void openWindow(String username) {
		StudentDashboard student=new StudentDashboard(username);
			student.setTitle("Student Dashboard"+username);
			student.setVisible(true);
	}
	
}
