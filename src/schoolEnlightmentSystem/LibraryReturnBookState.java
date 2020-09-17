package schoolEnlightmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//This class is used as a model of UI-Model/Delegate-Model pattern
public class LibraryReturnBookState {

//This method is deleting the record from issued book list
public static int delete(String book_id,int student_id){
		int status=0;
		try{
			Connection con= ConnectionProvider.getConnection();
			
			status=updatebook(book_id);//updating quantity and issue
			
			if(status>0){
			PreparedStatement ps=con.prepareStatement("delete from issuebooks where book_id=? and student_id=?");
			ps.setString(1,book_id);
			ps.setInt(2,student_id);
			status=ps.executeUpdate();
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
//This method is updating quantity of books to available books and number of issued books
public static int updatebook(String book_id){
		int status=0;
		int quantity=0,issued=0;
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/client", "root", "");
			
			PreparedStatement ps=con.prepareStatement("select quantity,issued from books where book_id=?");
			ps.setString(1,book_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}
			
			if(issued>0){
			PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where book_id=?");
			ps2.setInt(1,quantity+1);
			ps2.setInt(2,issued-1);
			ps2.setString(3,book_id);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
