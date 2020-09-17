package schoolEnlightmentSystem;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//This is the Model of MVC(LibraryModel,LibraryView,LibraryController) pattern
public class LibraryModel {
	private JPanel view_book_panel,issue_books_panel,
	view_issuedbooks_panel,return_books_panel;
	private String username;
	private JButton return_books_button,view_books_button,issue_books_button,view_issuedbooks_button;
	
	
//class constructor
public LibraryModel(String username) {
		this.username = username;
	}

//getters and setters
public JPanel getView_book_panel() {
		return view_book_panel;
	}
public void setView_book_panel(JPanel view_book_panel) {
		this.view_book_panel = view_book_panel;
	}
public JPanel getIssue_books_panel() {
		return issue_books_panel;
	}
public void setIssue_books_panel(JPanel issue_books_panel) {
		this.issue_books_panel = issue_books_panel;
	}
public JPanel getView_issuedbooks_panel() {
		return view_issuedbooks_panel;
	}
public void setView_issuedbooks_panel(JPanel view_issuedbooks_panel) {
		this.view_issuedbooks_panel = view_issuedbooks_panel;
	}
public JPanel getReturn_books_panel() {
		return return_books_panel;
	}
public void setReturn_books_panel(JPanel return_books_panel) {
		this.return_books_panel = return_books_panel;
	}
public String getUsername() {
		return username;
	}
public JButton getReturn_books_button() {
		return return_books_button;
	}
public void setReturn_books_button(JButton return_books_button) {
		this.return_books_button = return_books_button;
	}
public JButton getView_books_button() {
		return view_books_button;
	}
public void setView_books_button(JButton view_books_button) {
		this.view_books_button = view_books_button;
	}
public JButton getIssue_books_button() {
		return issue_books_button;
	}
public void setIssue_books_button(JButton issue_books_button) {
		this.issue_books_button = issue_books_button;
	}
public JButton getView_issuedbooks_button() {
		return view_issuedbooks_button;
	}
public void setView_issuedbooks_button(JButton view_issuedbooks_button) {
		this.view_issuedbooks_button = view_issuedbooks_button;
	}
public void setColor(JPanel panel) {
		panel.setBackground(new java.awt.Color(197,197,197));
	}
public void resetColor(JPanel panel) {
		panel.setBackground(new java.awt.Color(240,240,240));
	}


}
