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
public class LibraryViewBooksDAOImpl  extends JFrame implements LibraryBooksDAO{
	private JPanel contentPane;
	private JTable view_books_jtable;
	private String username;
	ResultSet rs;
	PreparedStatement ps;
	Connection con;
	
//LibraryViewBooksDAOImpl class constructor
public LibraryViewBooksDAOImpl(String username) {
	this.username = username;
	
	//calling the method of UI elements
	initComponent();
}

//This method is creating UI elements
public void initComponent() {
	setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
}	

//This method is getting all the available books of library
	@Override
public void viewBookDetails() {
		String data[][]=null;
		String column[]=null;
		try{
			Connection con= ConnectionProvider.getConnection();
			ps=con.prepareStatement("select * from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
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
		}catch(Exception e){System.out.println(e);}
		
		view_books_jtable = new JTable(data,column);
		//view_books_jtable.setSize(300, 300);
		JScrollPane sp=new JScrollPane(view_books_jtable);
		
		contentPane.add(sp, BorderLayout.CENTER);

		
	}
@Override
public void viewIssuedBookDetails() {
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

