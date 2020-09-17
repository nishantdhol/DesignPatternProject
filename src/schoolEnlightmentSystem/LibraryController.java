package schoolEnlightmentSystem;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//This is the Controller of MVC(LibraryModel,LibraryView,LibraryController) pattern
public class LibraryController {
	private LibraryView view;
    private LibraryModel model;
    private String username;

//LibraryController class constructor
public LibraryController(LibraryView view) {
    	this.view=view;
    	model=new LibraryModel(username);
    	   	
    }

//getters and setters returning data from model
public JPanel getLibraryView_book_panel() {
	return model.getView_book_panel();
}
public void setLibraryView_book_panel(JPanel view_book_panel) {
	model.setView_book_panel(view_book_panel);
}
public JPanel getLibraryIssue_books_panel() {
	return model.getIssue_books_panel();
}
public void setLibraryIssue_books_panel(JPanel issue_books_panel) {
	model.setIssue_books_panel(issue_books_panel);
}
public JPanel getLibraryView_issuedbooks_panel() {
	return model.getView_issuedbooks_panel();
}
public void setLibraryView_issuedbooks_panel(JPanel view_issuedbooks_panel) {
	model.setView_issuedbooks_panel(view_issuedbooks_panel);
}
public JPanel getLibraryReturn_books_panel() {
	return model.getReturn_books_panel();
}
public void setLibraryReturn_books_panel(JPanel return_books_panel) {
	model.setReturn_books_panel(return_books_panel);
}
public String getUsername() {
	return username;
}
public void setLibraryUsername(String username) {
	this.username = username;
}
public JButton getLibraryReturn_books_button() {
	return model.getReturn_books_button();
}
public void setLibraryReturn_books_button(JButton return_books_button) {
	model.setReturn_books_button(return_books_button);
}
public JButton getLibraryView_books_button() {
	return model.getView_books_button();
}
public void setLibraryView_books_button(JButton view_books_button) {
	model.setView_books_button(view_books_button);
}
public JButton getLibraryIssue_books_button() {
	return model.getIssue_books_button();
}
public void setLibraryIssue_books_button(JButton issue_books_button) {
	model.setIssue_books_button(issue_books_button);
}
public JButton getLibraryView_issuedbooks_button() {
	return model.getView_issuedbooks_button();
}
public void setLibraryView_issuedbooks_button(JButton view_issuedbooks_button) {
	model.setView_issuedbooks_button(view_issuedbooks_button);
}
public void setLibraryViewColor(JPanel panel) {
	model.setColor(panel);
}
public void resetLibraryViewColor(JPanel panel) {
	model.resetColor(panel);
}

 

}
