package application;
import java.util.Scanner;

import model.Bank;
import model.Customer;
import model.Employee;
import model.User;
import service.BankService;
import service.UserService;


public class Application {

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		

//		System.out.print("Please enter you first name: ");
//		String firstName = in.nextLine();
//		System.out.println("Please enter your last name: ");
//		String lastName = in.nextLine();
//		System.out.println("Please enter a password: ");
//		String passWord = in.nextLine();
		

		
		
		
//		in.close();
		//in user carry the list of users
		User user = new User();
//		get all user first
		System.out.println(user.getAllUsers());
		
		

	/*	
//	sign up scanner
		System.out.print("Please enter you first name: ");
		String  first_name = in.nextLine();
	    System.out.println("Please enter your last name: ");
		String last_name = in.nextLine();
		System.out.println("Please enter a password: ");
		String password = in.nextLine();
		
		
		
		//sign up scanner
		 UserService userService = new  UserService();
		 
		 Customer newCreatedCustomer =   userService.customerSignup(first_name, last_name, password, user);
		 
		 System.out.println(newCreatedCustomer);
		 
	*/
		
		
		 //sign in scanner
		 UserService userService = new  UserService();
		 
	 System.out.println("Please enter your user name: ");
		String username = in.nextLine();
		System.out.println("Please enter a password: ");
		String password = in.nextLine();
		Customer signedInCustomer =   (Customer) userService.customerLogin(username, password);
		 System.out.println(signedInCustomer);
	

 
//		 in.close();  you dont close here yet cause scanner  in employee  approve methoed will close it	 

		 //		 customer create bank account
		 	 BankService bankService = new  BankService();
//		 bankService.customerCreateBankAccount(signedInCustomer.getId());
		 	 
//		 	 bankService.customerCreateBankAccount(8);
//		 	
//		 	 System.out.println( bankService.getBankAccountByuser(8));
		 	 
		 	 // get a bank account by a user and deposit \
		 	 
//		 	Bank bankAccount = bankService.getBankAccountByuser(4); 
//		 	bankService.deposit( bankAccount, 100);
		 	
//		 	System.out.println(	bankService.deposit( bankAccount, 100));
	

	
		 	
		 	
//	System.out.println(	bankService.withdraw( bankAccount, 50));

		 	 
		 	 
		 	 
		 	 //		 	 user to tranfer money
//get list of recievers
		 	 //show to console
	
		 	 
		 	 /* 	 	  
	 	System.out.println(	userService.getAllUsersExeptSenderAndEmployee(4));
		 	
	try {
		
		 //ask to choose a receiver
		 System.out.println("Please choose receiver: ");
			int receiver = in.nextInt();
			
//		 	 ask for amount to tranfer
			System.out.println("Please enter amount: ");
			int amount = in.nextInt();

		 	 //use bank service to call transfer
		 	 
		
		 	 
		 	 System.out.println( 	bankService.transfer(1, receiver, amount));  
		
		
		
		
	} catch ( RuntimeException e) {
		// TODO: handle exception
		System.out.println("invalid input");
		e.printStackTrace();

	}	 	 
		*/	   
	
	
	}

}
