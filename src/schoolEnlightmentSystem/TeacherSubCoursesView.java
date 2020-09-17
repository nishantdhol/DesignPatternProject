package schoolEnlightmentSystem;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//This class is the View of MVC(TeacherSubCoursesView,TeacherSubCoursesModel,TeacherSubCoursesController) pattern.
public class TeacherSubCoursesView extends JFrame {
	private String username,subcourse;
	private JTextField subject_textField;
	private JTextField std_textField;
	private JTextField filename_textField;
	private JTextField fileext_textField;
	private JTextField file_textField;
	private JTextField uploader_textField;
	private JButton btnNewButton,upload_button;
	private JLabel subject_label,lblNewLabel,last_name_label,studentid_label,fileext_label,file_label,uploader_label;

//Initializing constructor		
public TeacherSubCoursesView(String username,String subcourse) {
	        this.username=username;
	        this.subcourse=subcourse;
	      //calling UI creation method
	        initComponents();
	        
	      //creating object of TeacherSubCoursesController class
	     TeacherSubCoursesController con=new TeacherSubCoursesController(this);
	        
	        //close button action
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        });
	        
	        //Upload button action
	        upload_button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		con.checkFileDetails(new String(file_textField.getText()),new String(std_textField.getText()),
							new String(subject_textField.getText()), new String(filename_textField.getText()), 
							new String(fileext_textField.getText()), new String(uploader_textField.getText()));
	        	}
	        });
}

//This method is creating UI elements
public void initComponents() {
	        //setTitle("User Profile");
	        getContentPane().setBackground(new Color(51, 102, 204));
			//setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\list_64px.png"));
			getContentPane().setLayout(null);
	        setBounds(100, 100, 509, 522);
	        
	        subject_label = new JLabel("Subject");
	        subject_label.setForeground(new Color(0, 0, 0));
	        subject_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        subject_label.setBounds(35, 60, 100, 24);
	        getContentPane().add(subject_label);
	        
	        subject_textField = new JTextField();
	        subject_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        subject_textField.setBounds(190, 60, 260, 27);
	        getContentPane().add(subject_textField);
	        subject_textField.setColumns(10);
	        
	        lblNewLabel = new JLabel("File Upload");
	        lblNewLabel.setForeground(new Color(0, 0, 0));
	        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	        lblNewLabel.setBounds(165, 10, 130, 30);
	        getContentPane().add(lblNewLabel);
	        
	        last_name_label = new JLabel("Standard");
	        last_name_label.setForeground(new Color(0, 0, 0));
	        last_name_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        last_name_label.setBounds(35, 110, 100, 24);
	        getContentPane().add(last_name_label);
	        
	        studentid_label = new JLabel("File Name");
	        studentid_label.setForeground(new Color(0, 0, 0));
	        studentid_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        studentid_label.setBounds(35, 160, 100, 24);
	        getContentPane().add(studentid_label);
	        
	        fileext_label = new JLabel("File Extension\r\n");
	        fileext_label.setForeground(new Color(0, 0, 0));
	        fileext_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        fileext_label.setBounds(35, 210, 130, 24);
	        getContentPane().add(fileext_label);
	        
	        file_label = new JLabel("File");
	        file_label.setForeground(new Color(0, 0, 0));
	        file_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        file_label.setBounds(35, 260, 130, 24);
	        getContentPane().add(file_label);
	       
	        
	        uploader_label = new JLabel("Uploaded By");
	        uploader_label.setForeground(new Color(0, 0, 0));
	        uploader_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        uploader_label.setBounds(35, 310, 130, 24);
	        getContentPane().add(uploader_label);
	        
	        std_textField = new JTextField();
	        std_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        std_textField.setColumns(10);
	        std_textField.setBounds(190, 110, 260, 27);
	        getContentPane().add(std_textField);
	        
	        filename_textField = new JTextField();
	        filename_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        filename_textField.setColumns(10);
	        filename_textField.setBounds(190, 160, 260, 27);
	        getContentPane().add(filename_textField);
	        
	        fileext_textField = new JTextField();
	        fileext_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        fileext_textField.setColumns(10);
	        fileext_textField.setBounds(190, 210, 260, 27);
	        getContentPane().add(fileext_textField);
	        
	        file_textField = new JTextField();
	        file_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        file_textField.setColumns(10);
	        file_textField.setBounds(190, 260, 260, 27);
	        getContentPane().add(file_textField);
	        
	        uploader_textField = new JTextField();
	        uploader_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        uploader_textField.setColumns(10);
	        uploader_textField.setBounds(190, 310, 260, 27);
	        getContentPane().add(uploader_textField);
	        
	        btnNewButton = new JButton("Close");
	        
	        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        btnNewButton.setForeground(new Color(0, 0, 0));
	        btnNewButton.setBounds(35, 382, 97, 30);
	        getContentPane().add(btnNewButton);
	        
	        upload_button = new JButton("Upload");	        
	        upload_button.setForeground(Color.BLACK);
	        upload_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        upload_button.setBounds(212, 382, 178, 30);
	        getContentPane().add(upload_button);
	   
	    }

//getters and setters
public String getUsername() {
	return username;
}

public JTextField getSubject_textField() {
	return subject_textField;
}

public void setSubject_textField(JTextField first_name_textField) {
	this.subject_textField = first_name_textField;
}

public JTextField getStd_textField() {
	return std_textField;
}

public void setStd_textField(JTextField last_name_textField) {
	this.std_textField = last_name_textField;
}

public JTextField getFilename_textField() {
	return filename_textField;
}

public void setFilename_textField(JTextField student_id_textField) {
	this.filename_textField = student_id_textField;
}

public JTextField getFileext_textField() {
	return fileext_textField;
}

public void setFileext_textField(JTextField contact_number_textField) {
	this.fileext_textField = contact_number_textField;
}

public JTextField getFile_textField() {
	return file_textField;
}

public void setFile_textField(JTextField birthdate_textField) {
	this.file_textField = birthdate_textField;
}


public JTextField getUploader_textField() {
	return uploader_textField;
}

public void setUploader_textField(JTextField email_textField) {
	this.uploader_textField = email_textField;
}

public JButton getBtnNewButton() {
	return btnNewButton;
}

public void setBtnNewButton(JButton btnNewButton) {
	this.btnNewButton = btnNewButton;
}

public JButton getBtnUpdateProfile() {
	return upload_button;
}

public void setBtnUpdateProfile(JButton btnUpdateProfile) {
	this.upload_button = btnUpdateProfile;
}
public void setMessage(String Message) {
    JOptionPane.showMessageDialog(null,Message);
}
}
