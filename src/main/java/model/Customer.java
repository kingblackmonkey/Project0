package model;

//import java.io.Serializable;

public class Customer  extends User   {
	

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	
	String typeOfUser = "customer";
	
	public Customer(String first_name, String  last_name, String password) {
		
		super(first_name, last_name, password);
		
		
	}




}
