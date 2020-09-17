package schoolEnlightmentSystem;

/*The Role interface is a product of factory method.
 *  Teacher and Student classes are the concrete products of Role*/
public interface Role{
	
//This method is to open the respective student or teacher page.
public void openWindow(String username);
}
