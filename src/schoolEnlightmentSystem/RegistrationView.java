package schoolEnlightmentSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;

/*This class is the View of MVC(RegistrationView,RegistrationModel,RegistrationController) pattern.*/
public class RegistrationView extends JFrame{
	private JPanel contentPane;
	private JTextField firstname_textField;
	private JTextField lastname_textField;
	private JTextField username_textField;
	private JTextField address_textField;
	private JPasswordField password_textField;
	private JPasswordField retype_password_textField;
	private JTextField email_textField;
	private JTextField contact_number_textField;
	private JTextField loginas_textField;
	private JTextField student_id_textField;
	private JCalendar calendar_birthdate_textField;
	private JButton register_button;
	private JButton cancel_button;
	private JLabel student_id_label, loginas_label,contact_number_label,email_label,background_label,register_label,first_name_label;
	private JLabel address_label,last_name_label,username_label,password_label,retype_password_label,birthdate_label;
	
//Initializing constructor	
public RegistrationView() {
	//calling UI creation method
	initComponents();
	
	//creating object of RegistrationController class
	RegistrationController controller = new RegistrationController(this);
	
	//register button click action
	register_button.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			@Override
            public void actionPerformed(ActionEvent arg0) {
    controller.checkRegistrationDetails(new String(firstname_textField.getText()),new String(lastname_textField.getText()),new String(username_textField.getText()),new String(loginas_textField.getText()),new String(password_textField.getText()),
    		 new String(retype_password_textField.getPassword()),new String(calendar_birthdate_textField.getDate().toString()),  new String(email_textField.getText()), new String(contact_number_textField.getText()),new String(address_textField.getText()),
	 new String(student_id_textField.getText()));
	    }  });
	
	cancel_button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		} });
}

// This method is creating UI elements
public void initComponents() {
		setBounds(100, 100, 541, 816);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		student_id_label = new JLabel("STUDENT_ID");
		student_id_label.setForeground(new Color(0, 0, 0));
		student_id_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		student_id_label.setBounds(12, 520, 170, 25);
		contentPane.add(student_id_label);
		
		calendar_birthdate_textField = new JCalendar();
		calendar_birthdate_textField.setBounds(190, 270, 200, 115);
		contentPane.add(calendar_birthdate_textField);
		
		loginas_label = new JLabel("LOGIN_AS\r\n");
		loginas_label.setForeground(new Color(0, 0, 0));
		loginas_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		loginas_label.setBounds(12, 480, 170, 25);
		contentPane.add(loginas_label);
		
		contact_number_textField = new JTextField();
		contact_number_textField.setColumns(10);
		contact_number_textField.setBounds(190, 440, 200, 30);
		contentPane.add(contact_number_textField);
		
		email_textField = new JTextField();
		email_textField.setColumns(10);
		email_textField.setBounds(190, 400, 200, 30);
		contentPane.add(email_textField);
		
		contact_number_label = new JLabel("CONTACT_NUMBER");
		contact_number_label.setForeground(new Color(0, 0, 0));
		contact_number_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		contact_number_label.setBounds(12, 440, 170, 25);
		contentPane.add(contact_number_label);
		
		email_label = new JLabel("EMAIL");
		email_label.setForeground(new Color(0, 0, 0));
		email_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		email_label.setBounds(8, 400, 170, 25);
		contentPane.add(email_label);
		
		register_label = new JLabel("REGISTRATION FORM");
		register_label.setForeground(new Color(0, 0, 0));
		register_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		register_label.setBounds(100, 13, 226, 32);
		contentPane.add(register_label);
		
		first_name_label = new JLabel("FIRST NAME");
		first_name_label.setForeground(new Color(0, 0, 0));
		first_name_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		first_name_label.setBounds(12, 60, 170, 25);
		contentPane.add(first_name_label);
		
		last_name_label = new JLabel("LAST NAME\r\n");
		last_name_label.setForeground(new Color(0, 0, 0));
		last_name_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		last_name_label.setBounds(12, 100, 170, 25);
		contentPane.add(last_name_label);
		
		username_label = new JLabel("USERNAME\r\n");
		username_label.setForeground(new Color(0, 0, 0));
		username_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		username_label.setBounds(12, 140, 170, 25);
		contentPane.add(username_label);  
		
		password_label = new JLabel("PASSWORD");
		password_label.setForeground(new Color(0, 0, 0));
		password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		password_label.setBounds(12, 180, 170, 25);
		contentPane.add(password_label);
		
		retype_password_label = new JLabel("RETYPE PASSWORD");
		retype_password_label.setForeground(new Color(0, 0, 0));
		retype_password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		retype_password_label.setBounds(12, 220, 170, 25);
		contentPane.add(retype_password_label);
		
		birthdate_label = new JLabel("BIRTHDATE");
		birthdate_label.setForeground(new Color(0, 0, 0));
		birthdate_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		birthdate_label.setBounds(12, 270, 170, 25);
		contentPane.add(birthdate_label);
		
		address_label = new JLabel("ADDRESS");
		address_label.setForeground(new Color(0, 0, 0));
		address_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		address_label.setBounds(12, 597, 170, 25);
		contentPane.add(address_label);
		
		firstname_textField = new JTextField();
		firstname_textField.setBounds(190, 60, 200, 30);
		contentPane.add(firstname_textField);
		firstname_textField.setColumns(10);
		
		lastname_textField = new JTextField();
		lastname_textField.setColumns(10);
		lastname_textField.setBounds(190, 100, 200, 30);
		contentPane.add(lastname_textField);
		
		username_textField = new JTextField();
		username_textField.setColumns(10);
		username_textField.setBounds(190, 140, 200, 30);
		contentPane.add(username_textField);
		
		address_textField = new JTextField();
		address_textField.setColumns(10);
		address_textField.setBounds(190, 570, 200, 80);
		contentPane.add(address_textField);
		
		register_button = new JButton("REGISTER\r\n");
		register_button.setForeground(new Color(0, 0, 0));
		register_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		register_button.setBounds(25, 696, 120, 30);
		contentPane.add(register_button);
		
		cancel_button = new JButton("CANCEL\r\n");
		cancel_button.setForeground(new Color(0, 0, 0));
		cancel_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		cancel_button.setBounds(267, 696, 120, 30);
		contentPane.add(cancel_button);
				
		loginas_textField = new JTextField();
		loginas_textField.setColumns(10);
		loginas_textField.setBounds(190, 480, 200, 30);
		contentPane.add(loginas_textField);
		
		password_textField = new JPasswordField();
		password_textField.setBounds(190, 180, 200, 30);
		contentPane.add(password_textField);
		
		retype_password_textField = new JPasswordField();
		retype_password_textField.setBounds(190, 220, 200, 30);
		contentPane.add(retype_password_textField);
		
		student_id_textField = new JTextField();
		student_id_textField.setColumns(10);
		student_id_textField.setBounds(190, 520, 200, 30);
		contentPane.add(student_id_textField);
		
		background_label = new JLabel("");
		//background_label.setIcon(new ImageIcon("images\\elearning2 (1).jpg"));
		background_label.setBounds(0, -17, 522, 714);
		contentPane.add(background_label);
	}


//getters and setters
public JTextField getfirstname_textField() {
		  return firstname_textField;
	 }
		 
public void setfirstname_textField(JTextField firstname_textField) {
		 this.firstname_textField = firstname_textField;
		
	}
public JTextField getlastname_textField() {
	  return lastname_textField;
}
	 
public void setlastname_textField(JTextField lastname_textField) {
	 this.lastname_textField = lastname_textField;
	
}

public JTextField getusername_textField() {
		  return username_textField;
	 }
		 
public void setusername_textField(JTextField username_textField) {
		 this.username_textField = username_textField;
		
	}
public JTextField getaddress_textField() {
	  return address_textField;
}
	 
public void setaddress_textField(JTextField address_textField) {
	 this.address_textField = address_textField;
	
}
public JTextField getpassword_textField() {
	  return password_textField;
}
	 
public void setpassword_textField(JPasswordField password_textField) {
	 this.password_textField = password_textField;
	
}
public JTextField getretype_password_textField() {
	  return retype_password_textField;
}
	 
public void setretype_password_textField(JPasswordField retype_password_textField) {
	 this.retype_password_textField = retype_password_textField;
	
}
public JTextField getemail_textField() {
	  return email_textField;
}
	 
public void setemail_textField(JTextField email_textField) {
	 this.email_textField = email_textField;
	
}
public JTextField getcontact_number_textField() {
	  return contact_number_textField;
}
	 
public void setcontact_number_textField(JTextField contact_number_textField) {
	 this.contact_number_textField = contact_number_textField;
	
}
public JTextField getloginas_textField() {
	  return loginas_textField;
}
	 
public void setloginas_textField(JTextField loginas_textField) {
	 this.loginas_textField = loginas_textField;
	
}
public JTextField getstudent_id_textField() {
	  return student_id_textField;
}
	 
public void setstudent_id_textField(JTextField student_id_textField) {
	 this.student_id_textField = student_id_textField;
	
}
public JCalendar getcalendar_birthdate_textField() {
	  return calendar_birthdate_textField;
}
	 
public void setcalendar_birthdate_textField(JCalendar calendar_birthdate_textField) {
	 this.calendar_birthdate_textField = calendar_birthdate_textField;
	
}
//setting the message method
public void setMessage(String Message) {
    JOptionPane.showMessageDialog(register_button,Message);
}
}
