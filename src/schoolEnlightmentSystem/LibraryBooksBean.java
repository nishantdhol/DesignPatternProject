package schoolEnlightmentSystem;


import java.io.Serializable;
import java.util.Date;

//This is the Model/Value object of Data Access Object Pattern
public class LibraryBooksBean implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	int book_id;
	int student_id;
	String student_name;
	String email;
	Date issued_date;
	
//class constructor	
public LibraryBooksBean() {	
}
	
//class constructor
public LibraryBooksBean(int book_id,int student_id,String student_name,String email,Date issued_date) {
		this.book_id = book_id;
		this.student_id = student_id;
		this.student_name = student_name;
		this.email = email;
		this.issued_date=issued_date;
		
	}

//getters and setters
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getIssued_date() {
		return issued_date;
	}

	public void setIssued_date(Date issued_date) {
		this.issued_date = issued_date;
	}

	
}
	