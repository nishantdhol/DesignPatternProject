package schoolEnlightmentSystem;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//This class in the Model in MVC(CoursesView,CoursesModel,CoursesController) pattern
public class CoursesModel {
	private String username;
	private ArrayList<String> subjects = new ArrayList<String>();

	private String standard;
    private JButton btn[] = new JButton[10];
	
    //class constructor
    public CoursesModel(String username) {
		this.username = username;
	}
    
    //getters and setters
    public String getUsername() {
		return username;
	}

	public ArrayList<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}
	public JButton[] getBtn() {
		return btn;
	}

	public void setBtn(JButton[] btn) {
		this.btn = btn;
	}
	
//This method is getting all the sub courses student is assigned with    
public void getCourses() {
	try {
		
	Connection conn= ConnectionProvider.getConnection();
	PreparedStatement pst = (PreparedStatement) conn.prepareStatement("SELECT Standard FROM student_data WHERE student_data.USER_NAME=?");
		pst.setString(1, username);
		
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			standard = rs.getString("Standard");

		}
		
		PreparedStatement pst2 = (PreparedStatement) conn.prepareStatement("SELECT course_name FROM courses WHERE courses.Standard = ?");
		pst2.setString(1, standard);
		ResultSet rs2 = pst2.executeQuery();

		while (rs2.next()) {
			String coursename = rs2.getString("course_name");
			subjects.add(coursename);
			
		}
		
		
		

		conn.close();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Could not fetch subcourses details!");
	}
	


}



}
