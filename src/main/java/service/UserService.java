package service;

import model.Customer;
import model.User;

public class UserService {

	
	//customer signup 
	
	public Customer customerSignup(String first_name, String  last_name, String password,User user ) {
	Customer customer = new Customer(first_name, last_name, password);
		
	//customer sign up 
	    Customer newCreatedCustomer =   (Customer) customer.signUp(customer,user);
		return newCreatedCustomer;
	}
	
	
}
