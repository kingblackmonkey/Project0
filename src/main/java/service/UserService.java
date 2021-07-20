package service;

import java.sql.SQLException;

import model.Customer;
import model.User;

public class UserService {

	
	//customer signup 
	
	public Customer customerSignup(String first_name, String  last_name, String password,User user ) {
	Customer customer = new Customer(first_name, last_name, password);
		
	// call customer sign up 
	    Customer newCreatedCustomer = null;
		try {
			newCreatedCustomer = (Customer) customer.signUp(customer,user);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return newCreatedCustomer;
	}
	
	
	
	//customer login => create customer; receive username and pass word and  call login method in user
	public Customer customerLogin( String username,String password) {
		
		Customer customer  = new Customer();
		  Customer signedInCustomer = null;
		try {
			signedInCustomer =(Customer) customer.login(username, password);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signedInCustomer;
	}
//	return user ->custmer to apllication
}
