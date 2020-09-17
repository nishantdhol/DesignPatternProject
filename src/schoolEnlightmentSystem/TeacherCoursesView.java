package schoolEnlightmentSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

//This class in the View in MVC(TeacherCoursesView,TeacherCoursesModel,TeacherCoursesController) pattern
public class TeacherCoursesView extends JFrame {
	private String username;
	private ArrayList<String> subjects = new ArrayList<String>();
	private ArrayList<String> standard = new ArrayList<String>();
    private JButton btn[] = new JButton[10];
    protected JFrame courseframe;

    
//class constructor 
public TeacherCoursesView(String username) {
		this.username = username;
		
		//creating object of TeacherCoursesController class
		TeacherCoursesController con=new TeacherCoursesController(this);
		con.checkCourses();
		
	}

//getters and setters
public JFrame getCourseframe() {
		return courseframe;
	}

public void setCourseframe(JFrame courseframe) {
		this.courseframe = courseframe;
	}	
    
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
public void setStandard(ArrayList<String> standard_input) {
		this.standard = standard_input;
	}
public JButton[] getBtn() {
		return btn;
	}
public void setBtn(JButton[] btn) {
		this.btn = btn;
	}
public void setColor(JButton button)
	 {
		button.setBackground(new java.awt.Color(197, 197, 197));
	 }
	 
public void resetColor(JButton button)
	 {
		 button.setBackground(new java.awt.Color(240,240,240));
	 }

//creating set message method 
public void setMessage(String Message) {
    JOptionPane.showMessageDialog(null,Message);
}

}
