package schoolEnlightmentSystem;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*This class is the View of MVC(ProfileView,ProfileModel,ProfileController) pattern.*/
public class ProfileView extends JFrame {
	private String username;
	private JTextField first_name_textField;
	private JTextField last_name_textField;
	private JTextField student_id_textField;
	private JTextField contact_number_textField;
	private JTextField birthdate_textField;
	private JTextField adddress_textField;
	private JTextField email_textField;
	private JButton btnNewButton,btnUpdateProfile;
	private JLabel fisrt_name_label,lblNewLabel,last_name_label,studentid_label,contact_number_label,birthdate_label,email_label,adddress_label;

//Initializing constructor		
public ProfileView(String username) {
	        this.username=username;
	      //calling UI creation method
	        initComponents();
	        
	      //creating object of ProfileController class
	        ProfileController con=new ProfileController(this);    		
	        con.checkUserProfile();	
	        
	        //close button action
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        });
	        
	        //Update button action
	        btnUpdateProfile.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		UpdateProfileView update_profile=new UpdateProfileView(username);
	        		update_profile.setVisible(true);
	        	}
	        });
}

//This method is creating UI elements
public void initComponents() {
	        setTitle("User Profile");
	        getContentPane().setBackground(new Color(51, 102, 204));
			setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\list_64px.png"));
			getContentPane().setLayout(null);
	        setBounds(100, 100, 560, 618);
	        
	        fisrt_name_label = new JLabel("First Name");
	        fisrt_name_label.setForeground(new Color(0, 0, 0));
	        fisrt_name_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        fisrt_name_label.setBounds(35, 60, 100, 24);
	        getContentPane().add(fisrt_name_label);
	        
	        first_name_textField = new JTextField();
	        first_name_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        first_name_textField.setBounds(190, 60, 200, 27);
	        getContentPane().add(first_name_textField);
	        first_name_textField.setColumns(10);
	        
	        lblNewLabel = new JLabel("Profile");
	        lblNewLabel.setForeground(new Color(0, 0, 0));
	        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	        lblNewLabel.setBounds(165, 10, 100, 25);
	        getContentPane().add(lblNewLabel);
	        
	        last_name_label = new JLabel("Last Name");
	        last_name_label.setForeground(new Color(0, 0, 0));
	        last_name_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        last_name_label.setBounds(35, 110, 100, 24);
	        getContentPane().add(last_name_label);
	        
	        studentid_label = new JLabel("Student_id");
	        studentid_label.setForeground(new Color(0, 0, 0));
	        studentid_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        studentid_label.setBounds(35, 160, 100, 24);
	        getContentPane().add(studentid_label);
	        
	        contact_number_label = new JLabel("Contact Number");
	        contact_number_label.setForeground(new Color(0, 0, 0));
	        contact_number_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        contact_number_label.setBounds(35, 210, 130, 24);
	        getContentPane().add(contact_number_label);
	        
	        birthdate_label = new JLabel("Birthdate");
	        birthdate_label.setForeground(new Color(0, 0, 0));
	        birthdate_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        birthdate_label.setBounds(35, 260, 130, 24);
	        getContentPane().add(birthdate_label);
	       
	        
	        email_label = new JLabel("Email");
	        email_label.setForeground(new Color(0, 0, 0));
	        email_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        email_label.setBounds(35, 310, 130, 24);
	        getContentPane().add(email_label);
	        
	        last_name_textField = new JTextField();
	        last_name_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        last_name_textField.setColumns(10);
	        last_name_textField.setBounds(190, 110, 200, 27);
	        getContentPane().add(last_name_textField);
	        
	        student_id_textField = new JTextField();
	        student_id_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        student_id_textField.setColumns(10);
	        student_id_textField.setBounds(190, 160, 200, 27);
	        getContentPane().add(student_id_textField);
	        
	        contact_number_textField = new JTextField();
	        contact_number_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        contact_number_textField.setColumns(10);
	        contact_number_textField.setBounds(190, 210, 200, 27);
	        getContentPane().add(contact_number_textField);
	        
	        birthdate_textField = new JTextField();
	        birthdate_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        birthdate_textField.setColumns(10);
	        birthdate_textField.setBounds(190, 260, 200, 27);
	        getContentPane().add(birthdate_textField);
	        
	        adddress_textField = new JTextField();
	        adddress_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        adddress_textField.setColumns(10);
	        adddress_textField.setBounds(190, 370, 200, 100);
	        getContentPane().add(adddress_textField);
	        
	        email_textField = new JTextField();
	        email_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	        email_textField.setColumns(10);
	        email_textField.setBounds(190, 310, 200, 27);
	        getContentPane().add(email_textField);
	        
	        adddress_label = new JLabel("Address");
	        adddress_label.setForeground(new Color(0, 0, 0));
	        adddress_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        adddress_label.setBounds(35, 370, 130, 24);
	        getContentPane().add(adddress_label);
	        
	        btnNewButton = new JButton("Close");
	        
	        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        btnNewButton.setForeground(new Color(0, 0, 0));
	        btnNewButton.setBounds(35, 508, 97, 30);
	        getContentPane().add(btnNewButton);
	        
	        btnUpdateProfile = new JButton("Update Profile");	        
	        btnUpdateProfile.setForeground(Color.BLACK);
	        btnUpdateProfile.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	        btnUpdateProfile.setBounds(212, 508, 178, 30);
	        getContentPane().add(btnUpdateProfile);
	   
	    }

//getters and setters
public String getUsername() {
	return username;
}

public JTextField getFirst_name_textField() {
	return first_name_textField;
}

public void setFirst_name_textField(JTextField first_name_textField) {
	this.first_name_textField = first_name_textField;
}

public JTextField getLast_name_textField() {
	return last_name_textField;
}

public void setLast_name_textField(JTextField last_name_textField) {
	this.last_name_textField = last_name_textField;
}

public JTextField getStudent_id_textField() {
	return student_id_textField;
}

public void setStudent_id_textField(JTextField student_id_textField) {
	this.student_id_textField = student_id_textField;
}

public JTextField getContact_number_textField() {
	return contact_number_textField;
}

public void setContact_number_textField(JTextField contact_number_textField) {
	this.contact_number_textField = contact_number_textField;
}

public JTextField getBirthdate_textField() {
	return birthdate_textField;
}

public void setBirthdate_textField(JTextField birthdate_textField) {
	this.birthdate_textField = birthdate_textField;
}

public JTextField getAdddress_textField() {
	return adddress_textField;
}

public void setAdddress_textField(JTextField adddress_textField) {
	this.adddress_textField = adddress_textField;
}

public JTextField getEmail_textField() {
	return email_textField;
}

public void setEmail_textField(JTextField email_textField) {
	this.email_textField = email_textField;
}

public JButton getBtnNewButton() {
	return btnNewButton;
}

public void setBtnNewButton(JButton btnNewButton) {
	this.btnNewButton = btnNewButton;
}

public JButton getBtnUpdateProfile() {
	return btnUpdateProfile;
}

public void setBtnUpdateProfile(JButton btnUpdateProfile) {
	this.btnUpdateProfile = btnUpdateProfile;
}
public void setMessage(String Message) {
    JOptionPane.showMessageDialog(null,Message);
}
}
