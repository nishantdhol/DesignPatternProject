package schoolEnlightmentSystem;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//This class is the View of MVC(SettingsView,SettingsModel,SettingsController) pattern.
public class SettingsView extends JFrame{
	private JPanel contentPane;
	private String username;
	private static JTextArea jTextArea;
	private JMenuBar menuBar;
	private JMenu menu_profile_settings,menu_conact_us,menu_help,menu_password_settings;
	private JMenuItem menu_item_changepassword,menu_item_delete_profile;

//class constructor	
public SettingsView(String username) {
	this.username=username;
	//calling UI creation method
	initComponents();
	
	//creating object of SettingsController class
	SettingsController controller=new SettingsController(this);
	
	//change password menu item action
    menu_item_changepassword.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			UpdateUserPasswordImpl pwd=new UpdateUserPasswordImpl(username);
			pwd.setVisible(true);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			controller.setSettingsColor(menu_item_changepassword);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			controller.resetSettingsColor(menu_item_changepassword);
		}
	});
    
    //delete profile menu item action
    menu_item_delete_profile.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			DeleteUerDataDAOImpl delete_frame = new DeleteUerDataDAOImpl(username);
			//delete_frame.deleteData();
			delete_frame.setVisible(true);
		}
		public void mouseEntered(MouseEvent e) {
			controller.setSettingsColor(menu_item_changepassword);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			controller.resetSettingsColor(menu_item_changepassword);
		}
	});
    
    /*menu_help.addMouseListener(new MouseAdapter() {
	@Override
	public void mousePressed(java.awt.event.MouseEvent evt) {
		JFrame_FileOpener my_file_object = new JFrame_FileOpener();
		
		//frame.setSize(1000, 1000);
		//FileOpenerClass my_file_object=new FileOpenerClass();
		try {
			my_file_object.pick_me();
			my_file_object.setVisible(true);

		}
		catch(Exception e) {
			e.printStackTrace();				
		}
		jTextArea.setText(my_file_object.sb.toString()); 
		
	}
});*/
}

//This method is creating UI elements
public void initComponents() {
	
	setBounds(100, 100, 511, 322);
	
	menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	menu_password_settings = new JMenu("Password Settings");
	menuBar.add(menu_password_settings);
	
	menu_item_changepassword = new JMenuItem("Change Password");
	
	menu_password_settings.add(menu_item_changepassword);
	
	menu_profile_settings = new JMenu("Profile Settings");
	menuBar.add(menu_profile_settings);
	
	menu_item_delete_profile = new JMenuItem("Delete Profile");
	menu_profile_settings.add(menu_item_delete_profile);
	
	//menu_help = new JMenu("Help");
	
	//jTextArea=new JTextArea();
	
	//menuBar.add(menu_help);
	//menu_conact_us = new JMenu("Contact Us");
	//menuBar.add(menu_conact_us);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
}


	
	
}
