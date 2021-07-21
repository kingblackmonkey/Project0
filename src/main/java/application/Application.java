package application;
import java.lang.invoke.SwitchPoint;
import java.util.List;
import java.util.Scanner;

import exceptions.UserNameAlreadyExistsException;
import model.Bank;
import model.Customer;
import model.Employee;
import model.User;
import service.BankService;
import service.EmployeeService;
import service.UserService;


public class Application {

	public static  void main(String[] args) {
		
		try {
			
			
			
			// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			
		      UserService userService = new  UserService();
				 	 BankService bankService = new  BankService();
				 	EmployeeService employeeService = new EmployeeService();	
				 	
				 	User receiverObj = null;
				 	User user = new User();	 	
				 	List<User> theListOfAllUsers;
					String  choice ;
				 	boolean done = false;
				 	
				 	Bank theBankAccountOfaUser = null;
					//in user carry the list of users
					
//					get all user first from database to check for existing username for sign up functionality
				 	 theListOfAllUsers = user.getAllUsers();
				 	
					System.out.println(	 theListOfAllUsers);
				 	
				 	
	//ask to choose login or sign up
		//use scanner			 	
					
					System.out.println("Login press 1; Sign up press 2 ");		 	
				 	
				
				 	
		String option = in.nextLine();	 
			
//					System.out.println(option.equals("1"));
					
					
					if(option.equals("1")) {
						//login part
						   //login functionality
					
						System.out.println("Please enter you user name: ");
						String  username = in.nextLine();					
						System.out.println("Please enter a password: ");
						String password = in.nextLine();
						Customer signedInCustomer =   (Customer) userService.customerLogin(username, password);
						 System.out.println(signedInCustomer);
						 
					//if there is a user proram will run ; if not it throws invalid credential exption
						 //if customer shows customers funtionality else show employee functionality
//						 System.out.println(signedInCustomer.getTypeOfUser().equals("customer"));
						 
						 while(!done) {
							 
							 
						 		if( signedInCustomer.getTypeOfUser().equals("customer")) {
						 			 Bank bankAccount;
						 			 String amountStr ;
						 			int amount ;
						 			String IDStringReceiver;
						 			 int IDReceiver;
						 			String amountTransferStr;
						 			 int amountTransfer;
						 			
						 			System.out.println("You are loggined as  " + signedInCustomer.getUsername());	
						 			System.out.println(" Customer's Options ");	
						 			System.out.println("press 1 to apply for a bank account and recieve 100 dollars in your balance account ");	
						 			System.out.println("press 2 to deposit  ");	
						 			System.out.println("press 3 to withdraw ");	
						 			System.out.println("press 4 to transfer money ");	
						 			System.out.println("press 5 to check balance ");
						 			System.out.println("press 6 to log out ");	
						 			
						 			

						 			System.out.println("Please enter your choice  ");
									  choice = in.nextLine();	
						 			
						 			switch (choice )
						 			{
						 			     case "1":
						 			    	 
						 			    	System.out.println("code block in apply bank option runs ");	
						 			    	 
						 			    //apply for bank account
						 					 bankService.customerCreateBankAccount(signedInCustomer.getId()); 
						 			    	 break;
						 			     
						 			     case "2":
						 			    	//deposit
						 			    	 
						 				 	 // get a bank account by a user and deposit \
						 				 	 
					 				 	     bankAccount = bankService.getBankAccountByuser(signedInCustomer.getId()); 
						 			    	 
					 				 	   System.out.println("Please enter your deposit amount ");	
					 				 	   amountStr = in.nextLine();	
					 				 	 amount =Integer.parseInt(amountStr);  

					 		
						 				 	System.out.println(	bankService.deposit( bankAccount, amount));
						 				 	System.out.println("Deposit Successful! ");	
						 			    	 break;
						 			  
						 			     case "3":
						 			    	//withdraw
						 			    	 
						 			    	    bankAccount = bankService.getBankAccountByuser(signedInCustomer.getId()); 
						 			    	
						 				 	   System.out.println("Please enter your withdraw amount ");	
							 				 	  amountStr = in.nextLine();	
							 				 	 amount =Integer.parseInt(amountStr); 					 				 
						 			    	    
						 			    	    
						 			    	    System.out.println(	bankService.withdraw( bankAccount,  amount));
						 			    	    
						 			    	   System.out.println("withDraw Successful! ");	
						 			    	
						 			    	    break;
						 			    
						 			     
						 			    case "4":	    
						 			    	    
						 					//transfer money 
//						 				 	 this function receive a sender get back all receiver customer  but not employee and sender	
						 			    	System.out.println("Here is the list of receivers");
						 			    	
						 			    	
						 			    		
						 				 	System.out.println( userService.getAllUsersExeptSenderAndEmployee(signedInCustomer.getId())	);
						 			    	
						 				 	
						 					 //ask to choose a receiver customer id
						 					 System.out.println("Please choose a receiver; use their ID and dont enter letter; must be number or request will be cancelled;  ");
						 					IDStringReceiver  =  in.nextLine();	
						 					IDReceiver = 	Integer.parseInt(IDStringReceiver); 
						 					
						 					
//						 					 	 ask for amount to transfer
					 						System.out.println("Please enter amount to transfer: ");
					 						amountTransferStr  = in.nextLine();	
					 						amountTransfer = Integer.parseInt(amountTransferStr); 

//						 						
						 					 	 //use bank service to call transfer
					 						System.out.println( 	bankService.transfer(signedInCustomer.getId(), IDReceiver, amountTransfer));  
						 					
					 						System.out.println("Tranfer Successful!; first row is you; first name and username respectively   " + signedInCustomer.getFirst_name() + "     "  + signedInCustomer.getUsername());	
					 						
					 		
					 							
					 							
					 							
					 						
					 						System.out.println("and the second row is your reciever first name and username respectively   "     );	
					 					
						 				 	
						 				 	
										//get the matching object for receiver; to display on console
					 						for(int i=0; i< theListOfAllUsers.size(); i++) {
					 							
					 							if(theListOfAllUsers.get(i).getId() == IDReceiver) {
					 								receiverObj= theListOfAllUsers.get(i);
					 								 i= theListOfAllUsers.size();
					 							}
					 							
					 							
					 						}
						 				 	
					 						
						 				 	
					 						System.out.println(receiverObj.getFirst_name() + "   " + receiverObj.getUsername());
						 				 	
						 			    	 break;
								 		
						 			    	 
						 			    	 
						 			   case "5":
						 				   
						 				   //check balance 
						 				   
						 				  System.out.println("Here is your bank account");
						 				   
						 				 theBankAccountOfaUser =  bankService.getBankAccountByuser(signedInCustomer.getId());
						 				
						 				 System.out.println( theBankAccountOfaUser);
						 				 
						 				 System.out.println("        ");  
						 				  
						 				  
						 				  System.out.println("Your balance is " +  theBankAccountOfaUser.getBalance() + " dollars");
						 				   
						 				         break;
						 			     default:
						 			        //set done equal to false to exist loop
						 			    	done = true;
						 			     break;
						 			}
						 		
						 	
						 		
						 			
						 
						 			
						 	
						 			
						 			
						 			
						 			}else {
						 				//employee functionalities
						 				
						 				System.out.println("You are loggined as  " + signedInCustomer.getUsername() + "  " + " type of user: " + signedInCustomer.getTypeOfUser() + "\n");	
							 			System.out.println(" Employee's Options " + "\n");	
							 	
//							 		employeeService.viewAllTransferTransaction();
							 			
//							 			employeeService.viewAllBankAccounts();
						 		
						 			
							 			System.out.println("press 1 to view all bank accounts ");	
							 			System.out.println("press 2 to view all transfer transactions ");	
							 			System.out.println("press 3 to view deposit and withdraw transaction ");
							 			System.out.println("press 4 to log out " + "\n");	
						 			
							 			System.out.println("Please enter your choice  ");
										  choice = in.nextLine();	
						 			switch (  choice) {
									case "1":
										
										employeeService.viewAllBankAccounts();
										
										break;
										
										
									case "2":
										
										employeeService.viewAllTransferTransaction();
										break;	
										
										
									case "3":
										
										employeeService.viewDepositAndWithdrawTransactions();
										break;
										
										
										
										

									default:
										done = true;
										break;
									}
						 			
						 			}
						
				
					
					
					
					
					
					
					
					
					} 
					
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
						 }
						 
						 
						 
		
					
					if (option.equals("2")){
						//sign up part.
						//user must run the program again to login
						
						
						System.out.print("Please enter you first name: ");
						String firstName = in.nextLine();
						System.out.println("Please enter your last name: ");
						String lastName = in.nextLine();
						System.out.println("Please enter a password: ");
						String passWord = in.nextLine();
						
						System.out.println("Sign up Sucessful! " + "\n");
						System.out.println("Please login again " + "\n");
						System.out.println("Here is your credentials ! " + "\n");
					
						 System.out.println(	 userService.customerSignup(firstName, lastName,passWord, user));
					}	
					
					
					if(!option.equals("1")  || !option.equals("2")){
						
						System.out.println("Bye Bye");
					}			
							
							
					
					
					
					
		
					
					
					
					
				 	

			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (RuntimeException e) {
			// TODO: handle exception
		e.printStackTrace()	;
		
		}
		
		
		
		
		
		
		


		
		
		
//		in.close();

//		employee view deposit and withdraws transactions
//		 employeeService.viewDepositAndWithdrawTransactions();

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
		
			
		 //signn in scanner
		
	
		 
//	 System.out.println("Please enter your user name: ");
//		String username = in.nextLine();
//		System.out.println("Please enter a password: ");
//		String password = in.nextLine();
//		Customer signedInCustomer =   (Customer) userService.customerLogin(username, password);
//		 System.out.println(signedInCustomer);
//	
//      
 
//		 in.close();  you dont close here yet cause scanner  in employee  approve methoed will close it	 
//customer create bank dint need to close scanner
		
		
		
		
		 //		 customer create bank account
		 
	
		 	 
//		 	 bankService.customerCreateBankAccount(8);
//		 	
//		 	 System.out.println( bankService.getBankAccountByuser(8));
		 	 

	

	
		 	
		 	


		 	 
		 	 
		 	 
		 	 //	------	 	 user to tranfer money
//get list of recievers
		 	 //show to console
	
		 	 
		 	 /* 	
		 	  

		 	
	try {
		

		
		
		
		
	} catch ( RuntimeException e) {
		// TODO: handle exception
		System.out.println("invalid input");
		e.printStackTrace();

	}	 	 
		*/	   
	
	
	}

}
