 package schoolEnlightmentSystem;


//This is the Interface of Data Access Object(DAO) pattern
public interface UserDataOperationsDAO {
	public void deleteUserData(UserDataBean b);
	public void updateUserPassword(UserDataBean userdatabean);

}
