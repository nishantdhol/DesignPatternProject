package schoolEnlightmentSystem;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//This class is the View of MVC(UpdateProfileView,UpdateProfileModel,UpdateProfileController) pattern.
public class UpdateProfileView extends JFrame {
	private JPanel contentPane;
	private JTextField username_textField;
	private JPasswordField password_textField;
	private JTextField loginas_textField;
	private JTextField first_name_textField;
	private JTextField last_name_textField;
	private JTextField email_textField;
	private JTextField contact_number_textField;
	private JTextField birthdate_textField;
	private JTextField address_textField;
	private JButton update_button;
	private JButton cancel_button;
	private String username;
	private JLabel address_label,username_label,password_label,loginas_label,first_name_label,
	last_name_label,email_label,contact_number_label,birthdate_label,update_profile_label;

	
//Initializing constructor
public UpdateProfileView(String username) {
	this.username = username;
	//calling UI creation method
	initComponents();
	
	//creating object of UpdateProfileController class
	UpdateProfileController conn=new UpdateProfileController(this);
	conn.checkProfileDetials();
	
	//update button click action
	update_button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				conn.checkUpdatedProfileDetails();
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(update_button, "Can not update the record");
			}
			
		}
	});
	
	//cancel button click action
	cancel_button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	});
}

//This method is creating UI elements
public void initComponents() {
	setForeground(new Color(176, 224, 230));
	setBounds(100, 100, 520, 595);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(51, 102, 204));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	username_label = new JLabel("User Name");
	username_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	username_label.setBounds(35, 50, 100, 25);
	contentPane.add(username_label);
	
	password_label = new JLabel("Password");
	password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	password_label.setBounds(35, 90, 100, 26);
	contentPane.add(password_label);
	
    loginas_label = new JLabel("Login As");
	loginas_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	loginas_label.setToolTipText("\r\nEnter TEACHER or STUDENT only.");
	loginas_label.setBounds(35, 130, 89, 26);
	contentPane.add(loginas_label);
	
    first_name_label = new JLabel("First Name");
	first_name_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	first_name_label.setBounds(35, 170, 100, 25);
	contentPane.add(first_name_label);
	
	last_name_label = new JLabel("Last Name");
	last_name_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	last_name_label.setBounds(35, 210, 100, 25);
	contentPane.add(last_name_label);
	
	email_label = new JLabel("Email");
	email_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	email_label.setBounds(35, 250, 100, 25);
	contentPane.add(email_label);
	
	contact_number_label = new JLabel("Contact Number");
	contact_number_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	contact_number_label.setBounds(35, 290, 130, 25);
	contentPane.add(contact_number_label);
	
	birthdate_label = new JLabel("Birthdate");
	birthdate_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	birthdate_label.setBounds(35, 330, 100, 25);
	contentPane.add(birthdate_label);
	
	address_label = new JLabel("Address");
	address_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	address_label.setBounds(35, 370, 100, 25);
	contentPane.add(address_label);
	
	username_textField = new JTextField();
	username_textField.setBounds(175, 50, 200, 25);
	contentPane.add(username_textField);
	username_textField.setColumns(10);
	
	password_textField = new JPasswordField();
	password_textField.setColumns(10);
	password_textField.setBounds(175, 90, 200, 25);
	contentPane.add(password_textField);
	
	loginas_textField = new JTextField();
	loginas_textField.setColumns(10);
	loginas_textField.setBounds(175, 130, 200, 25);
	contentPane.add(loginas_textField);
	
	first_name_textField = new JTextField();
	first_name_textField.setColumns(10);
	first_name_textField.setBounds(175, 170, 200, 25);
	contentPane.add(first_name_textField);
	
	last_name_textField = new JTextField();
	last_name_textField.setColumns(10);
	last_name_textField.setBounds(175, 210, 200, 25);
	contentPane.add(last_name_textField);
	
	email_textField = new JTextField();
	email_textField.setColumns(10);
	email_textField.setBounds(175, 250, 200, 25);
	contentPane.add(email_textField);
	
	contact_number_textField = new JTextField();
	contact_number_textField.setColumns(10);
	contact_number_textField.setBounds(175, 290, 200, 25);
	contentPane.add(contact_number_textField);
	
	birthdate_textField = new JTextField();
	birthdate_textField.setColumns(10);
	birthdate_textField.setBounds(175, 330, 200, 25);
	contentPane.add(birthdate_textField);
	
	address_textField = new JTextField();
	address_textField.setColumns(10);
	address_textField.setBounds(175, 370, 200, 100);
	contentPane.add(address_textField);
	
	update_button = new JButton("Update");
	update_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	update_button.setBounds(35, 505, 120, 30);
	contentPane.add(update_button);
		
	update_profile_label = new JLabel("Profile Updation");
	update_profile_label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	update_profile_label.setBounds(137, 7, 160, 30);
	contentPane.add(update_profile_label);
	
	cancel_button = new JButton("Cancel");
	cancel_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	cancel_button.setBounds(255, 505, 120, 30);
	contentPane.add(cancel_button);
}


//getters and setters
public JTextField getUsername_textField() {
	return username_textField;
}

public void setUsername_textField(JTextField username_textField) {
	this.username_textField = username_textField;
}

public JPasswordField getPassword_textField() {
	return password_textField;
}

public void setPassword_textField(JPasswordField password_textField) {
	this.password_textField = password_textField;
}

public JTextField getLoginas_textField() {
	return loginas_textField;
}

public void setLoginas_textField(JTextField loginas_textField) {
	this.loginas_textField = loginas_textField;
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

public JTextField getEmail_textField() {
	return email_textField;
}

public void setEmail_textField(JTextField email_textField) {
	this.email_textField = email_textField;
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

public JTextField getAddress_textField() {
	return address_textField;
}

public void setAddress_textField(JTextField address_textField) {
	this.address_textField = address_textField;
}

public JButton getCancel_button() {
	return cancel_button;
}

public void setCancel_button(JButton cancel_button) {
	this.cancel_button = cancel_button;
}

public String getUsername() {
	return username;
}
public void setMessage(String Message) {
    JOptionPane.showMessageDialog(null,Message);
}

}
