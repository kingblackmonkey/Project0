package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.AccountDeny;

public class Employee extends User {


	
	public Employee() {
		
		
	}
	
	public Employee(String firstName, String lastName, String passWord) {
		super(firstName, lastName, passWord);
		
		this.setTypeOfUser("employee");
		
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
//			 in.close();
			
			
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
		
		System.out.println("Employee approved " + "\n");
		
		
	}
	
	
	
//view customer deposit and withdraw transaction
	public void viewDepositAndWithdrawTransactions() {
		
		//execute the sql query and get result back 
		List<DepositAndWithDraw> depositAndwithdrawTransList = new ArrayList<DepositAndWithDraw>();
		
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statment we write our query as a string
			
			String sql = "select * from depositAndWithdraw d inner join users u on d.customer_id = u.id ;";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				depositAndwithdrawTransList.add(new  DepositAndWithDraw(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(6), rs.getString(7),  rs.getString(8),  rs.getString(9)   ,  rs.getString(10)  ));
			}


			
			
	
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(depositAndwithdrawTransList);
		
		
		
		//call the view deposit and withdraw transactions class to create instance of its class and display the deposit and withdraw transactions
		
		
	}
	
	
	
	
	
	
	public void viewAllTransferTransaction() {
		
		//execute the sql query and get result back 
		List< AllTransferTransaction > transferTransactions = new ArrayList< AllTransferTransaction >();
		
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statment we write our query as a string
			
			String sql = "select * from transfer  ;";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				transferTransactions.add(	new  AllTransferTransaction (  rs.getInt(1),  rs.getInt(2),   rs.getInt(3), rs.getInt(4) ) );
			}
			
			

			//loop through tranfer transaction list has alltransfer intance
			for(int i = 0; i<transferTransactions.size(); i++ ) {
				
				transferTransactions.get(i).setSender( new User().getAuser(transferTransactions.get(i).getSenderId())          );
				transferTransactions.get(i).setReciever( new User().getAuser(transferTransactions.get(i).getRecieverId())          );
				
			}
			
			//each  alltranfer instance has prop sender and reveiver
//			
//			and create user instance then 
		
	
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				System.out.println(transferTransactions);
		
		
		
		//call the view deposit and withdraw transactions class to create instance of its class and display the deposit and withdraw transactions
		
		
	}

	
	
	
	
	
	public void viewAllBankAccounts() {
		
		

		//execute the sql query and get result back 
		List< ViewAllBankAccounts > bankAccountsList = new ArrayList<  ViewAllBankAccounts >();
		
		try {
			Connection con = conUtil.getConnection();
		
			
			String sql = "select * from users  inner join bankAccount on  users.id  = bankAccount.customer_id ;";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				 bankAccountsList.add(	new   ViewAllBankAccounts (  rs.getInt(1),  rs.getString(2),   rs.getString(3), rs.getString(4)  ,   rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8) ,     rs.getInt(9)                                              ) );
			}
			
			



		
	
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				System.out.println( bankAccountsList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
