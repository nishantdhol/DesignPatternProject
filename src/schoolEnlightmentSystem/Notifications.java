package schoolEnlightmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//This class is to provide message to other users
public class Notifications extends JFrame{
	private JPanel contentPane;
	private String username;
	private JButton send_button;
	private JTextField to_textField, subject_textField;
	private JTextArea message_textArea;
	private JLabel to_label,subject_label,message_label;
	
//class Constructor	
public Notifications(String username) {
		setTitle("Inbox/OutBox");
		this.username=username;
	   	initComponents();
	   	
	   	send_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendMessage();
			}
		});
		}
//This method is creating UI elements
public void initComponents() {
	setBounds(100, 100, 545, 457);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(51, 102, 204));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	to_label = new JLabel("To\r\n");
	to_label.setHorizontalAlignment(SwingConstants.TRAILING);
	to_label.setVerticalTextPosition(SwingConstants.BOTTOM);
	to_label.setBackground(new Color(51, 102, 204));
	to_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	to_label.setBounds(12, 30, 90, 25);
	contentPane.add(to_label);
	
	subject_label = new JLabel("Subject");
	subject_label.setHorizontalAlignment(SwingConstants.TRAILING);
	subject_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	subject_label.setBackground(new Color(51, 102, 204));
	subject_label.setBounds(12, 80, 90, 25);
	contentPane.add(subject_label);
	
	message_label = new JLabel("Message");
	message_label.setHorizontalAlignment(SwingConstants.TRAILING);
	message_label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	message_label.setBackground(new Color(51, 102, 204));
	message_label.setBounds(12, 136, 90, 25);
	contentPane.add(message_label);
	
	to_textField = new JTextField();
	to_textField.setBounds(120, 30, 320, 27);
	contentPane.add(to_textField);
	to_textField.setColumns(10);
	
	subject_textField = new JTextField();
	subject_textField.setColumns(10);
	subject_textField.setBounds(120, 80, 320, 27);
	contentPane.add(subject_textField);
	
	send_button = new JButton("Send");
	send_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	send_button.setBounds(194, 367, 97, 30);
	contentPane.add(send_button);
	
	message_textArea = new JTextArea();
	message_textArea.setBounds(120, 130, 320, 200);
	contentPane.add(message_textArea);
	
}

//This class is sending message to other users
public void sendMessage() {
	
	try {  
	        
	        // establish connection  
	        Connection con= ConnectionProvider.getConnection();
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO `task`(`USER_NAME`, `RECIPIENT`, `SUBJECT`, `BODY`) VALUES (?,?,?,?)");

			pst.setString(1, username);
			pst.setString(2, to_textField.getText());
			pst.setString(3, subject_textField.getText());
			pst.setString(4, message_textArea.getText());

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Message Sent..."); 
	        con.close();  
	        initComponents();
	        //Refresh(); //Calling Referesh() method  
	    } catch (SQLException se) {  
	        JOptionPane.showMessageDialog(null, "Can not send message!");  
	    }  

}

}
