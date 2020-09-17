package schoolEnlightmentSystem;

//RoleTypeFactory is a Creator of factory method.
public interface RoleTypeFactory {
	public void initView();
	public Role checkCredentials(String username, String password, String loginas);
		
}