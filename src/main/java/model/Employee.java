package model;

import java.util.Scanner;

import exceptions.AccountDeny;

public class Employee extends User {

	String typeOfUser = "employee";
	
	public Employee() {
		
		
	}
	
	public Employee(String firstName, String lastName, String passWord) {
		super(firstName, lastName, passWord);
		
	}

//approve or deny account
	public void approve() {
		
		boolean decision = false ;
		Scanner in = new Scanner(System.in);
		try {
			
			
			System.out.println("employee Hien! Do you want to approve or deny bank account apllication");
		    System.out.println("Please enter y/n; any number pressed will be considerd as no");
			
//	anny number enter will be converted to string so the catch block can not catch the type exception
//		    when it  expects int but string entered then catch block can catch exception
			String decisionString = in.nextLine();
			 in.close();
			
			
			switch (decisionString) {
		
			case "y":
				decision = true;
				break;

		
			}	
			
			
		} catch (Exception e) {
			System.out.println("please enter y or n not number");
			e.printStackTrace();
		}
		
		
		
			
		
		if(!decision ) {
			
			in.close();
			
			throw new AccountDeny();
			
			
		}
		
		System.out.println("Employee approved ");
		
		
	}
		
}
