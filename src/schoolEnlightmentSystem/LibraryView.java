package schoolEnlightmentSystem;

import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

//This is the View of MVC(LibraryModel,LibraryView,LibraryController) pattern
public class LibraryView extends JFrame{
	private JPanel contentPane,view_book_panel,issue_books_panel,
	view_issuedbooks_panel,return_books_panel;
	private String username;
	private JButton return_books_button,view_books_button,
	issue_books_button,view_issuedbooks_button;
	private JLabel lblNewLabel,view_books_label_img,issue_books_label_img,
	view_issuedbooks_label_img,return_books_label_img;
	private LibraryViewBooksDAOImpl vb;
	private LibraryIssueBooksDAOImpl ib;
	private LibraryViewIssuedBooksDAOImpl vib;
	private LibraryReturnBooksDAOImpl rb;
	
//class constructor		
public LibraryView(String username) {
	this.username=username;
	//calling create UI method
	initComponents();
	this.vb=new LibraryViewBooksDAOImpl(username);
	this.ib=new LibraryIssueBooksDAOImpl(username);
	this.vib=new LibraryViewIssuedBooksDAOImpl(username);
	this.rb=new LibraryReturnBooksDAOImpl(username);
	
	//creating object of LibraryController class
	//LibraryController controller=new LibraryController(this);
	
	//view book panel click action
	view_book_panel.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			setColor(view_book_panel);
		}
		public void mouseExited(MouseEvent e) {
			resetColor(view_book_panel);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			//LibraryViewBooksDAOImpl books=new LibraryViewBooksDAOImpl(username);
			//LibraryBooksBean b=new LibraryBooksBean();
			vb.setVisible(true);
			vb.viewBookDetails();
			vb.setTitle("View Available Books");
			vb.setSize(600, 600);
			
			}
	});
	
	//issue book panel click action
	issue_books_panel.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			setColor(issue_books_panel);
		}
		public void mouseExited(MouseEvent e) {
			resetColor(issue_books_panel);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			//LibraryIssueBooksDAOImpl books=new LibraryIssueBooksDAOImpl(username);
			ib.setVisible(true);
			
			ib.setTitle("Checkout Books");
			ib.setSize(600, 600);
		}
	});
	
	//view issued books panel click action
	view_issuedbooks_panel.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			setColor(view_issuedbooks_panel);
		}
		public void mouseExited(MouseEvent e) {
			resetColor(view_issuedbooks_panel);
		}
			@Override
		public void mouseClicked(MouseEvent e) {
				//LibraryViewIssuedBooksDAOImpl issued_books=new LibraryViewIssuedBooksDAOImpl(username);
				vib.setVisible(true);
				vib.viewIssuedBookDetails();
				vib.setTitle("View CheckOut Books");
				vib.setSize(600, 600);
				
		}
	});
	
	//return books panel click action
	return_books_panel.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			setColor(return_books_panel);
		}
		public void mouseExited(MouseEvent e) {
			resetColor(return_books_panel);
		}
			@Override
		public void mouseClicked(MouseEvent e) {
			//LibraryReturnBooksDAOImpl books_return=new LibraryReturnBooksDAOImpl(username);
			rb.setTitle("Returned Books");
			rb.setVisible(true);
		} 
	});
	
	
		
}

//This method is creating UI elements
public void initComponents() {
	setBounds(100, 100, 705, 512);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(51, 102, 204));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	lblNewLabel = new JLabel("My Library Account");
	lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	lblNewLabel.setBounds(0, 0, 227, 37);
	contentPane.add(lblNewLabel);
	
	view_book_panel = new JPanel();
	view_book_panel.setBackground(new Color(240, 240, 240));
	view_book_panel.setBounds(15, 65, 144, 130);
	contentPane.add(view_book_panel);
	view_book_panel.setLayout(null);
	
	view_books_label_img = new JLabel("");
	view_books_label_img.setIcon(new ImageIcon("Images\\icons8-book-shelf-viewbooks-96.png"));
	view_books_label_img.setBounds(19, 8, 107, 74);
	view_book_panel.add(view_books_label_img);
	
	view_books_button = new JButton("View Books");
	view_books_button.setForeground(new Color(0, 0, 0));
	view_books_button.setBackground(new Color(51, 102, 204));
	view_books_button.setBounds(8, 92, 124, 31);
	view_book_panel.add(view_books_button);
	view_books_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	
	issue_books_panel = new JPanel();
	issue_books_panel.setLayout(null);
	issue_books_panel.setBounds(160, 235, 144, 130);
	contentPane.add(issue_books_panel);
	
			
	issue_books_label_img = new JLabel("");
	issue_books_label_img.setIcon(new ImageIcon("Images\\icons8-add-book-96.png"));
	issue_books_label_img.setBounds(19, 5, 113, 83);
	issue_books_panel.add(issue_books_label_img);
	
	issue_books_button = new JButton("Checkout Books");
	issue_books_button.setForeground(new Color(0, 0, 0));
	issue_books_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	issue_books_button.setBackground(new Color(51, 102, 204));
	issue_books_button.setBounds(8, 92, 124, 31);
	issue_books_panel.add(issue_books_button);
	
	view_issuedbooks_panel = new JPanel();
	view_issuedbooks_panel.setLayout(null);
	view_issuedbooks_panel.setBounds(305, 65, 150, 130);
	contentPane.add(view_issuedbooks_panel);
	
	view_issuedbooks_label_img = new JLabel("");
	view_issuedbooks_label_img.setIcon(new ImageIcon("Images\\icons8-content-issuedbooks-96.png"));
	view_issuedbooks_label_img.setBounds(19, 8, 96, 68);
	view_issuedbooks_panel.add(view_issuedbooks_label_img);
	
	view_issuedbooks_button = new JButton("View CheckedOutBooks");
	view_issuedbooks_button.setForeground(new Color(0, 0, 0));
	view_issuedbooks_button.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
	view_issuedbooks_button.setBackground(new Color(51, 102, 204));
	view_issuedbooks_button.setBounds(4, 92, 143, 33);
	view_issuedbooks_panel.add(view_issuedbooks_button);
	
	return_books_panel = new JPanel();
	return_books_panel.setLayout(null);
	return_books_panel.setBounds(450, 235, 150, 130);
	contentPane.add(return_books_panel);
	
	return_books_label_img = new JLabel("");
	return_books_label_img.setIcon(new ImageIcon("Images\\icons8-return-book-96.png"));
	return_books_label_img.setBounds(19, 8, 107, 74);
	return_books_panel.add(return_books_label_img);
	
	return_books_button = new JButton("Return Books");
	return_books_button.setForeground(new Color(0, 0, 0));
	return_books_button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	return_books_button.setBackground(new Color(51, 102, 204));
	return_books_button.setBounds(7, 92, 134, 31);
	return_books_panel.add(return_books_button);
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

public String getUsername() {
	return username;
}
public void setColor(JPanel panel) {
	panel.setBackground(new java.awt.Color(197,197,197));
}
public void resetColor(JPanel panel) {
	panel.setBackground(new java.awt.Color(240,240,240));
}



}

