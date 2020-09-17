package schoolEnlightmentSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//This class is a Concrete Class of Data Access Objects pattern
public class UpdateUserPasswordImpl extends JFrame implements UserDataOperationsDAO{
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField old_password_textField;
    private JLabel old_password_label,new_password_label,reenter_new_password_label,change_password_label;
    private JTextField new_password_textField;
    private JTextField reenter_new_password_textField;
    private String username;
    private JButton submit_button;
   

//class constructor
public UpdateUserPasswordImpl(String username) {
		setTitle("Password Update");
		this.username=username;
		
		//calling UI creation method
	 	initComponents();
	 	
	 	//submit button click action
	 	submit_button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	UserDataBean b=new UserDataBean();
	        	updateUserPassword(b);
	        }
	    });


		}

//This method is creating UI elements   
public void initComponents() {
	  setBounds(300, 200, 626, 361);
      setResizable(false);

      contentPane = new JPanel();
      contentPane.setBackground(new Color(51, 102, 204));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      old_password_textField = new JPasswordField();
      old_password_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
      old_password_textField.setBounds(275, 80, 250, 40);
      contentPane.add(old_password_textField);
      old_password_textField.setColumns(10);

    submit_button = new JButton("Submit");
	submit_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
    submit_button.setBackground(new Color(240, 240, 240));
    submit_button.setBounds(215, 274, 120, 39);
    contentPane.add(submit_button);
    
    old_password_label = new JLabel("Enter Old Password :");
    old_password_label.setBackground(new Color(51, 102, 204));
    old_password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
    old_password_label.setBounds(25, 80, 220, 40);
    contentPane.add(old_password_label);
    
    new_password_label = new JLabel("Enter New Password :");
    new_password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
    new_password_label.setBackground(new Color(51, 102, 204));
    new_password_label.setBounds(25, 140, 220, 40);
    contentPane.add(new_password_label);
    
    new_password_textField = new JPasswordField();
    new_password_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
    new_password_textField.setColumns(10);
    new_password_textField.setBounds(275, 140, 250, 40);
    contentPane.add(new_password_textField);
    
    reenter_new_password_textField = new JPasswordField();
    reenter_new_password_textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
    reenter_new_password_textField.setColumns(10);
    reenter_new_password_textField.setBounds(275, 200, 250, 40);
    contentPane.add(reenter_new_password_textField);
    
    reenter_new_password_label = new JLabel("Re-Enter New Password :");
    reenter_new_password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
    reenter_new_password_label.setBackground(new Color(51, 102, 204));
    reenter_new_password_label.setBounds(25, 200, 220, 40);
    contentPane.add(reenter_new_password_label);
    
    change_password_label = new JLabel("Change Password");
    change_password_label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    change_password_label.setBounds(200, 12, 200, 25);
    contentPane.add(change_password_label);

}

//This is a concrete method of DAO implementation class and it is updating the password of the user
public void updateUserPassword(UserDataBean userdatabean) {
	//String pstr= old_password_textField.getText();
    String pstr1 = new_password_textField.getText();
    String pstr2 = reenter_new_password_textField.getText();
    String pstr=userdatabean.setPassword(old_password_textField.getText());
    String username1=userdatabean.setUser_name(username);
    try {

    	Connection con= ConnectionProvider.getConnection();
        PreparedStatement st = (PreparedStatement) con.prepareStatement("Update user_data set password=? where user_name=?");
        if((pstr.equals(pstr1)) && (pstr.equals(pstr2))) {
        	JOptionPane.showMessageDialog(submit_button, "New password should be different than old password");
        }
        if(!(pstr1.equals(pstr2))) {
        	JOptionPane.showMessageDialog(submit_button, "New password and re-entered password did not match");
        }
        if((!(pstr.equals(pstr1))) && (pstr1.equals(pstr2))) {
        	st.setString(1, pstr1);
            st.setString(2, username1);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Password has been successfully changed");
        }
      con.close();  
    } catch (SQLException sqlException) {
    	JOptionPane.showMessageDialog(null,"Not able to update the password in the database!");
    }
}


@Override
public void deleteUserData(UserDataBean b) {
	// TODO Auto-generated method stub
	
}
}