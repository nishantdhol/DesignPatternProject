package schoolEnlightmentSystem;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//This class is the Concrete Class of Data Access Object pattern
public class LibraryViewIssuedBooksDAOImpl  extends JFrame implements LibraryBooksDAO{
	private JPanel contentPane;
	private JTable view_issuedbooks_jtable;
	private String username;
	ResultSet rs;
	PreparedStatement ps;
	Connection con;
	
//class constructor
public LibraryViewIssuedBooksDAOImpl(String username) {
	this.username = username;
	//calling UI creation method
	initComponent();
}

//This method is creating UI elements
public void initComponent() {
	setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
}	


public void viewIssuedBookDetails() {
	String data[][]=null;
	String column[]=null;
	try{
		Connection con= ConnectionProvider.getConnection();
ps=con.prepareStatement("select a.BOOK_ID,a.STUDENT_ID,a.STUDENT_NAME,a.EMAIL,a.ISSUED_DATE from issuebooks a inner join student_data b on a.STUDENT_ID=b.STUDENT_ID where b.user_name=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ps.setString(1, username);
		
		rs=ps.executeQuery();
		
		ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
		int cols=rsmd.getColumnCount();
		column=new String[cols];
		for(int i=1;i<=cols;i++){
			column[i-1]=rsmd.getColumnName(i);
		}
		
		rs.last();
		int rows=rs.getRow();
		rs.beforeFirst();

		data=new String[rows][cols];
		int count=0;
		while(rs.next()){
			for(int i=1;i<=cols;i++){
				data[count][i-1]=rs.getString(i);
			}
			count++;
		}
		con.close();
	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "check the function again");
	}
	
	view_issuedbooks_jtable = new JTable(data,column);
	JScrollPane sp1=new JScrollPane(view_issuedbooks_jtable);
	
	contentPane.add(sp1, BorderLayout.CENTER);
}


@Override
public void viewBookDetails() {
	// TODO Auto-generated method stub
	
}

@Override
public void issueBook() {
	// TODO Auto-generated method stub
	
}
@Override
public void returnBook() {
	// TODO Auto-generated method stub
	
}

}