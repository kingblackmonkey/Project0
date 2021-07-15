package model;

public class Employee extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String typeOfUser = "employee";
	
	public Employee(String firstName, String lastName, String passWord) {
		super(firstName, lastName, passWord);
		// TODO Auto-generated constructor stub
	}

}
