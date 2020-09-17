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

//This class in the View in MVC(TeacherCoursesView,TeacherCoursesModel,TeacherCoursesController) pattern
public class TeacherCoursesModel {
	private String username;
	private ArrayList<String> subjects = new ArrayList<String>();

	private ArrayList<String> standard=new ArrayList<String>() ;
    private JButton btn[] = new JButton[10];
	
    //class constructor
    public TeacherCoursesModel(String username) {
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

	public ArrayList<String> getStandard() {
		return standard;
	}

	public void setStandard(ArrayList<String> standard) {
		this.standard = standard;
	}
	public JButton[] getBtn() {
		return btn;
	}

	public void setBtn(JButton[] btn) {
		this.btn = btn;
	}
	
//This method is getting all the sub courses teacher is assigned with    
public void getCourses( ) {
	try {
		
	Connection conn= ConnectionProvider.getConnection();
	PreparedStatement pst = (PreparedStatement) conn.prepareStatement("SELECT subject,standard FROM teacher_data WHERE teacher_data.USER_NAME=?");
		pst.setString(1, username);
		
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			
			standard.add(rs.getString("Standard"));
			subjects.add(rs.getString("subject"));
		}
		
		conn.close();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Could not fetch subcourses details!");
	}
	


}



}
