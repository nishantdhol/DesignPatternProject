package schoolEnlightmentSystem;

import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

//This class is the Concrete Class of Data Access Object pattern
//It is also used as a UI of UI-Model/Delegation-Model pattern
public class LibraryIssueBooksDAOImpl extends JFrame implements LibraryBooksDAO  {
	static LibraryIssueBooksDAOImpl frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String username;
	private JButton btnIssueBook;
	private JLabel lblNewLabel,lblBookName,lblStudentId,lblStudentName,lblStudentContact,lblNewLabel_1;
	private GroupLayout gl_contentPane;
	
//class constructor	
public LibraryIssueBooksDAOImpl(String username) {
		this.username=username;
		
		//calling UI creation method
		initComponents();
		
		//issue button click action
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LibraryBooksBean b=new LibraryBooksBean();
				try {
					
				issueBook();
				}				
				catch(Exception ex) {
					JOptionPane.showMessageDialog(btnIssueBook, "Data not entered properly, Enter again!");
				}
	} });
	}

//This method is creating UI elements
public void initComponents() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Check Out Book ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.GRAY);
		
		lblBookName = new JLabel("Book ID:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		lblStudentId = new JLabel("Student Id:");
		
	    lblStudentName = new JLabel("Student Name:");
		
	    lblStudentContact = new JLabel("Student Email:");
		
		btnIssueBook = new JButton("Checkout Book");
			
		lblNewLabel_1 = new JLabel("Note: Please check Student ID Carefully before issuing book!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//lblNewLabel_1.setForeground(Color.RED);
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookName)
								.addComponent(lblStudentId)
								.addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStudentContact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(47)))
							.addGap(100))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(lblNewLabel)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentContact)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		
		
}
			
//This method is issuing books
public void issueBook() {
	//LibraryBooksBean b=new LibraryBooksBean();
		String book_id=textField_1.getText();		
		int student_id=Integer.parseInt(textField_2.getText());
		String student_name=textField_3.getText();
		String email=textField_4.getText();
		
		
		if(LibraryIssueBookState.checkBook(book_id)){
		
		int i=LibraryIssueBookState.save(book_id, student_id,student_name, email);
		if(i>0){
			JOptionPane.showMessageDialog(btnIssueBook,"Book checked out successfully!");
			//LibrarianSuccess.main(new String[]{});
			//frame.dispose();
			
		}else{
			JOptionPane.showMessageDialog(btnIssueBook,"Sorry, unable to issue!");
		}//end of save if-else
		
		}else{
			JOptionPane.showMessageDialog(btnIssueBook,"Sorry, Callno doesn't exist!");
		}//end of checkbook if-else
		
		
}	
@Override
public void viewBookDetails() {
	// TODO Auto-generated method stub
	
}
@Override
public void viewIssuedBookDetails() {
	// TODO Auto-generated method stub
	
}
@Override
public void returnBook() {
	// TODO Auto-generated method stub
	
}
		

}
