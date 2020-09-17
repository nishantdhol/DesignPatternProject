package schoolEnlightmentSystem;

//This is the interface of Data Access Object pattern
public interface LibraryBooksDAO {
	public void viewBookDetails();
	public void viewIssuedBookDetails();
	public void issueBook();
	public void returnBook();
}
