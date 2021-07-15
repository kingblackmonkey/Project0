package fileIO;

import java.util.ArrayList;

import model.User;

public class Storage {

	ArrayList<User> customersArrList ;

	//	ArrayList<User> employeesArrList ;
	
	// create user array list either customer or employee
	public Storage() {
		super();
		this.customersArrList = new ArrayList<>();
		
		
//		this.employeesArrList = new ArrayList<>();;
	}
	
	
//get list of customer
	
	
	public ArrayList<User> getCustomersList () {
		
		
		return this.customersArrList;
	}
	

	
	
	
	
	
}
