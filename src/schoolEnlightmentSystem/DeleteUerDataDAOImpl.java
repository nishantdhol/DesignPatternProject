package schoolEnlightmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


//This is the concrete implementation of Data Access Object pattern
public class DeleteUerDataDAOImpl extends JFrame implements UserDataOperationsDAO{
	private JPanel contentPane;
	private String username;
	private JButton btnYes,btnNo;

public DeleteUerDataDAOImpl(String username) {
		setTitle("Profile Deletion");
		this.username=username;
	 	initComponents();
	 	btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	 	
	 	btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDataBean b=new UserDataBean();
				deleteUserData(b); 
					
				}
			});
	 	
			      
		}
	

public void initComponents() {
			
		
		setBounds(100, 100, 380, 211);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnYes = new JButton("YES");
		btnYes.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnYes.setToolTipText("\r\nAction can not be undone.");
		btnYes.setBounds(84, 79, 100, 25);
		contentPane.add(btnYes);
		
		JLabel lblNewLabel = new JLabel("Are you sure?");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(127, 30, 152, 25);
		contentPane.add(lblNewLabel);
		
		btnNo = new JButton("NO");		
		btnNo.setToolTipText("\r\nAction can not be undone.");
		btnNo.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNo.setBounds(209, 79, 100, 25);
		contentPane.add(btnNo);
}

//This method is deleting user profile
public void deleteUserData(UserDataBean b) {
	
		try {
				Connection con= ConnectionProvider.getConnection();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement("DELETE FROM USER_DATA WHERE USER_NAME=?");
				username=b.setUser_name(username);
				pst.setString(1, username);
		
				int rs=pst.executeUpdate();
				if(rs == 1) {
				JOptionPane.showMessageDialog(null, "Profile is deleted."); 
				}
				con.close();  
				//System.exit(0);
		        
		    } catch (SQLException se) {  
		        JOptionPane.showMessageDialog(null,"Could not connect to database!");  
		    } 
	
}


@Override
public void updateUserPassword(UserDataBean userdatabean) {
	// TODO Auto-generated method stub
	
}
}