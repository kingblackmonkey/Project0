package model;

//import java.io.Serializable;

public class Customer  extends User   {
	

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	

	
	public Customer() {super();}
	
	public Customer(String first_name, String  last_name, String password) {
		
		super(first_name, last_name, password);
		
		this.setTypeOfUser("customer");
	}

//	public String getTypeOfUser() {
//		return typeOfUser;
//	}

//	public void setTypeOfUser(String typeOfUser) {
//		this.typeOfUser = typeOfUser;
//	}




}
