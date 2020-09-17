package schoolEnlightmentSystem;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//This class is the Model of MVC(SettingsView,SettingsModel,SettingsController) pattern.
public class SettingsModel {
	private JPanel contentPane;
	private String username;
	private JMenu menu_profile_settings;
	private JMenu menu_conact_us;
	private JMenu menu_help;
	private JMenu menu_password_settings;
	private JMenuItem menu_item_changepassword;
	private JMenuItem menu_item_delete_profile;
	

//getters and setters
public void setColor(JMenuItem menuitem) {
		menuitem.setBackground(new Color(197,197,197));
	}
public JPanel getContentPane() {
		return contentPane;
	}

public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

public String getUsername() {
		return username;
	}

public SettingsModel(String username) {
		this.username = username;
	}


public JMenu getMenu_profile_settings() {
		return menu_profile_settings;
	}

public void setMenu_profile_settings(JMenu menu_profile_settings) {
		this.menu_profile_settings = menu_profile_settings;
	}

public JMenu getMenu_conact_us() {
		return menu_conact_us;
	}

public void setMenu_conact_us(JMenu menu_conact_us) {
		this.menu_conact_us = menu_conact_us;
	}

public JMenu getMenu_help() {
		return menu_help;
	}

public void setMenu_help(JMenu menu_help) {
		this.menu_help = menu_help;
	}

public JMenu getMenu_password_settings() {
		return menu_password_settings;
	}

public void setMenu_password_settings(JMenu menu_password_settings) {
		this.menu_password_settings = menu_password_settings;
	}

public JMenuItem getMenu_item_changepassword() {
		return menu_item_changepassword;
	}

public void setMenu_item_changepassword(JMenuItem menu_item_changepassword) {
		this.menu_item_changepassword = menu_item_changepassword;
	}

public JMenuItem getMenu_item_delete_profile() {
		return menu_item_delete_profile;
	}

public void setMenu_item_delete_profile(JMenuItem menu_item_delete_profile) {
		this.menu_item_delete_profile = menu_item_delete_profile;
	}

public void resetColor(JMenuItem menuitem) {
		menuitem.setBackground(new Color(240,240,240));
	}
}
