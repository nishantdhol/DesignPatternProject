package schoolEnlightmentSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

//This class in the View in MVC(CoursesView,CoursesModel,CoursesController) pattern
public class CoursesView extends JFrame {
	private String username;
	private ArrayList<String> subjects = new ArrayList<String>();
	private String standard;
    private JButton btn[] = new JButton[10];
    protected JFrame courseframe;

    
//class constructor 
public CoursesView(String username) {
		this.username = username;
		
		//creating object of CoursesController class
		CoursesController con=new CoursesController(this);
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
