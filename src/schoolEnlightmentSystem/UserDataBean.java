package schoolEnlightmentSystem;

import java.util.Date;

public class UserDataBean {
	String user_name;
	String first_name;
	String last_name;
	String email;
	String login_as;
	int student_id;
	Date birthdate;
	int contact_number;
	String address;
	String password;

//This class is Model object/Value Object of Data Access Object pattern
public UserDataBean() {

	}

public UserDataBean(String user_name,String first_name,
	String last_name,String email,String login_as,int student_id,Date birthdate,int contact_number,
	String address,	String password)
	{
		this.user_name=user_name;
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;
		this.login_as=login_as;
		this.student_id=student_id;
		this.address=address;
		this.password=password;
		this.contact_number=contact_number;
		this.birthdate=birthdate;
	}

	public String getUser_name() {
		return user_name;
	}
	public String setUser_name(String user_name) {
		return this.user_name = user_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin_as() {
		return login_as;
	}
	public void setLogin_as(String login_as) {
		this.login_as = login_as;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public int getContact_number() {
		return contact_number;
	}
	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	
	

}
