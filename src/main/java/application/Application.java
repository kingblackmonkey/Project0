package application;
import java.util.Scanner;

import model.Customer;
import model.User;
import service.UserService;


public class Application {

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
		
		
//		System.out.print("Please enter you first name: ");
//		String firstName = in.nextLine();
//		System.out.println("Please enter your last name: ");
//		String lastName = in.nextLine();
//		System.out.println("Please enter a password: ");
//		String passWord = in.nextLine();
		
//		 CustomerService customerService = new  CustomerService("customers.txt");
//		 User user =  (User) customerService.signUp(firstName, lastName, passWord);
//		 System.out.println("first name is : " + user.getFirstName());
//		 System.out.println("io file  name : " + customerService.iO.fileName);
		
		
		
//		in.close();
		//in user carry the list of users
		User user = new User();
//		get all user first
		System.out.println(user.getAllUsers());
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter you first name: ");
		String  first_name = in.nextLine();
	    System.out.println("Please enter your last name: ");
		String last_name = in.nextLine();
		System.out.println("Please enter a password: ");
		String password = in.nextLine();
		
		 UserService userService = new  UserService();
		 
		 Customer newCreatedCustomer =   userService.customerSignup(first_name, last_name, password, user);
		 
		 System.out.println(newCreatedCustomer.getUsername());
		 
	
		 in.close();
	}

}