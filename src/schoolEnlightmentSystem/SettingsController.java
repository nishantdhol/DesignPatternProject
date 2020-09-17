package schoolEnlightmentSystem;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//This class is the View of MVC(SettingsView,SettingsModel,SettingsController) pattern.
public class SettingsController {
	SettingsView view;
    SettingsModel model;
    private String username;

/*Initializing the SettingsController constructor and 
 * also initializing SettingsModel and SettingsView objects */
    public SettingsController(SettingsView view) {
    	this.view=view;
    	model=new SettingsModel(username);
    	   	
    }
 
    public void setSettingsColor(JMenuItem menuitem) {
		model.setColor(menuitem);
	}
    public void resetSettingsColor(JMenuItem menuitem) {
		model.resetColor(menuitem);
	}
	public JPanel getSettingsContentPane() {
		return model.getContentPane();
	}

	public void setSettingsContentPane(JPanel contentPane) {
		model.setContentPane(contentPane);
	}

	public JMenu getSettingsMenu_profile_settings() {
		return model.getMenu_profile_settings();
	}

	public void setSettingsMenu_profile_settings(JMenu menu_profile_settings) {
		model.setMenu_profile_settings(menu_profile_settings);
	}
	public JMenu getSettingsMenu_conact_us() {
		return model.getMenu_conact_us();
	}

	public void setSettingsMenu_conact_us(JMenu menu_conact_us) {
		model.setMenu_conact_us(menu_conact_us);
	}

	public JMenu getSettingsMenu_help() {
		return model.getMenu_help();
	}

	public void setSettingsMenu_help(JMenu menu_help) {
		model.setMenu_help(menu_help);
	}

	public JMenu getSettingsMenu_password_settings() {
		return model.getMenu_password_settings();
	}

	public void setSettingsMenu_password_settings(JMenu menu_password_settings) {
		model.setMenu_password_settings(menu_password_settings);
	}

	public JMenuItem getSettingsMenu_item_changepassword() {
		return model.getMenu_item_changepassword();
	}

	public void setSettingsMenu_item_changepassword(JMenuItem menu_item_changepassword) {
		model.setMenu_item_changepassword(menu_item_changepassword);
	}

	public JMenuItem getSettingsMenu_item_delete_profile() {
		return model.getMenu_item_delete_profile();
	}

	public void setSettingsMenu_item_delete_profile(JMenuItem menu_item_delete_profile) {
		model.setMenu_item_delete_profile(menu_item_delete_profile);
	}

		
	
}
