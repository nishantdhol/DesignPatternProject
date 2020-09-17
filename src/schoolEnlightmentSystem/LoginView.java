package schoolEnlightmentSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LoginView extends JFrame {

        private JPanel contentPane;
		private JTextField username_textField;
		private JLabel Loginas_label, Username_label,Password_label;
		private JComboBox<String> LoginAs_comboBox;
		private JLabel image_label;
		private JPasswordField password_textField;
		private JButton Register_button;
		private JButton Login_Button;
		private JButton Cancel_button;
		protected RoleTypeFactory controller;
		

public LoginView() {
   
    	setBackground(new Color(240, 240, 240));
    	setBounds(100, 100, 660, 450);
  	  // Create UI elements
  	    contentPane = new JPanel();
  		contentPane.setBackground(new Color(51, 102, 204));
  		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  		setContentPane(contentPane);
  		contentPane.setLayout(null);
  		password_textField = new JPasswordField();
  		password_textField.setBounds(314, 130, 115, 32);
  		contentPane.add(password_textField);
  		
  		username_textField = new JTextField();
  		username_textField.setBounds(314, 65, 115, 32);
  		contentPane.add(username_textField);
  		
  		
  		Register_button = new JButton("REGISTER HERE");
  		Register_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
  		Register_button.setForeground(new Color(0, 0, 0));
  		Register_button.setBounds(210, 331, 170, 33);
  		contentPane.add(Register_button);
  		Register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationView register_frame = new RegistrationView();
				//register_frame.registerData();
				register_frame.setVisible(true);
				
			}
		});
  		
  		Cancel_button = new JButton("CANCEL");
   		Cancel_button.setForeground(new Color(0, 0, 0));
  		Cancel_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
  		Cancel_button.setBounds(314, 263, 115, 33);
  		contentPane.add(Cancel_button);
  		Cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
  		
  		Username_label = new JLabel("USERNAME");
  		Username_label.setForeground(new Color(0, 0, 0));
  		Username_label.setBounds(159, 65, 115, 32);
  		Username_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
  		contentPane.add(Username_label);
  		
  		Password_label = new JLabel("PASSWORD");
  		Password_label.setBackground(new Color(255, 255, 255));
  		Password_label.setForeground(new Color(0, 0, 0));
  		Password_label.setBounds(159, 130, 115, 32);
  		Password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
  		contentPane.add(Password_label);
  		
  		Loginas_label = new JLabel("LOGIN_AS");
  		Loginas_label.setForeground(new Color(0, 0, 0));
  		Loginas_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
  		Loginas_label.setBounds(159, 195, 110, 32);
  		contentPane.add(Loginas_label);
  		
  		LoginAs_comboBox = new JComboBox<String>();
  		LoginAs_comboBox.setBackground(Color.WHITE);
  		LoginAs_comboBox.setForeground(new Color(0, 0, 0));
  		LoginAs_comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
  		LoginAs_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT", "TEACHER", "STUDENT"}));
  		LoginAs_comboBox.setSelectedIndex(0);
  		LoginAs_comboBox.setBounds(314, 195, 115, 32);
  		contentPane.add(LoginAs_comboBox);
  		
  		Login_Button = new JButton("LOGIN");
  		Login_Button.setForeground(new Color(0, 0, 0));
  		Login_Button.setDefaultCapable(true);
  		Login_Button.setBounds(159, 263, 115, 32);
  		Login_Button.setActionCommand("");
  		
  		Login_Button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
  		contentPane.add(Login_Button);
  		
  		
        Login_Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	
            	String s=(String) (getLoginAs_comboBox().getSelectedItem());
          		
          		if((s.equalsIgnoreCase("SELECT")) || s.equalsIgnoreCase("select")) {
          			JOptionPane.showMessageDialog(Login_Button, "Select the login role properly");   		}
          		if((s.equalsIgnoreCase("TEACHER")) || s.equalsIgnoreCase("teacher"))
          		{
                	controller=new TeacherFactory().checkCredentials( new String(username_textField.getText()), 
                			 new String(password_textField.getPassword()),
                			  new String((String) LoginAs_comboBox.getSelectedItem()));
                }
          		if((s.equalsIgnoreCase("STUDENT")) || s.equalsIgnoreCase("student")) {
          			controller=new StudentFactory().checkCredentials( new String(username_textField.getText()), 
               			 new String(password_textField.getPassword()),
               			  new String((String) LoginAs_comboBox.getSelectedItem()));
          	}
            	
  
            }
            
        });
        
        image_label = new JLabel("");
  		image_label.setForeground(new Color(0, 0, 0));
  		//image_label.setIcon(new ImageIcon("images\\notebook-336634_640_opacity60.jpg"));
  		image_label.setBounds(-2, -4, 660, 450);
		contentPane.add(image_label);
        

    }



public void setMessage(String Message) {
        JOptionPane.showMessageDialog(Login_Button,Message);
    }

	 
public JTextField getusername_textField() {
		  return username_textField;
	 }
		 
public void setusername_textField(JTextField username_textField) {
		 this.username_textField = username_textField;
		
	} 
	  
	 public JPasswordField getpassword_textField() {
	  return password_textField;
	 }
	 
	 public void setpassword_textField(JPasswordField password_textField) {
	 this.password_textField =  password_textField;
		
	 }
	 
	 
public JComboBox<String> getLoginAs_comboBox() {
		  return LoginAs_comboBox;
		 }
		 
public void setLoginAs_comboBox(JComboBox<String> LoginAs_comboBox) {
		  this.LoginAs_comboBox =  LoginAs_comboBox;
			
		 }
	 
	 public JButton getRegister_button() {
	  return Register_button;
	 }
	 
	 public void setRegister_button(JButton Register_button) {
	  this.Register_button = Register_button;
	 }
	 
	 public JButton getLogin_Button() {
	  return Login_Button;
	 }
	 
	 public void setLogin_Button(JButton Login_Button) {
	  this.Login_Button = Login_Button;
	 }
	 
	 public JButton getCancel_button() {
	  return Cancel_button;
	 }
	 
	 public void setCancel_button(JButton Cancel_button) {
	  this.Cancel_button = Cancel_button;
	 }
}