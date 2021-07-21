package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import exceptions.AccountNumberAlreadyExist;
import exceptions.InsufficientFund;
import exceptions.InsufficientFundToTransfer;
import exceptions.NoBankAccountFound;
import fileIO.ConnectionUtil;



public class Bank {
	
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
private int account_id;
private int account_number = (new Random().nextInt(9000)+1000);
private int balance = 100 ;
private int customer_id;


public Bank() {}

public Bank(int account_id, int account_number, int balance, int customer_id) {
	super();
	this.account_id = account_id;
	this.account_number = account_number;
	this.balance = balance;
	this.customer_id = customer_id;
}
public int getAccount_id() {
	return account_id;
}
public void setAccount_id(int account_id) {
	this.account_id = account_id;
}
public int getAccount_number() {
	return account_number;
}
public void setAccount_number(int account_number) {
	this.account_number = account_number;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}



//create a new bank 
public void createbank (int customer_id) {
	
	//create bank instance
	
	
	
	
//	create bank using store procedure 
	
	try {
		Connection con = conUtil.getConnection();
		//To use our functions/procedure we need to turn off auto commit
		con.setAutoCommit(false);
		String sql = "call create_bank(?,?,?)";
		CallableStatement cs = con.prepareCall(sql);
		
		cs.setInt(1, this.getAccount_number());
		cs.setInt(2,this.getBalance());
		cs.setInt(3, customer_id);
		
		  cs.execute();
		
		con.setAutoCommit(true);
	
		System.out.println("Your bank account is created");
	
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	
	
}


//check for dudplicate bank account check both account number or customer id
//one customer can only have one bank account
public void checkDuplicateBankAccount(Bank generatedBankAccount, int customer_id) {
	

  List<Bank> accounts = new ArrayList <Bank>();
 	
	try {
		
		
		Connection con = conUtil.getConnection();
		//To create a simple statment we write our query as a string
		String sql = "SELECT * FROM bankAccount";
		
		//We need to create a statement with this sql string
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			accounts.add(new Bank(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
		}
		
	
//		check if account exist
		for(int i=0; i<accounts.size(); i++) {
			Bank account = accounts.get(i);
//			System.out.println(account.getCustomer_id());
//			System.out.println(customer_id);
			if(account.getAccount_number() ==  generatedBankAccount.getAccount_number() || account.getCustomer_id() == customer_id ) {
				throw new AccountNumberAlreadyExist();
			}
		}
		
		

	
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
 	
 	
 	

}


//get bank account by a user
public Bank getBankAccountByuser(int user_id) {
	
	List<Bank> bankAccounts= new ArrayList<Bank>();
	try {
		Connection con = conUtil.getConnection();
//		con.setAutoCommit(false);
//		String sql = "{?=call get_user_posts(?)}";
//		
//		CallableStatement cs = con.prepareCall(sql);
//		
//		cs.registerOutParameter(1, Types.OTHER);
//		cs.setInt(2, u.getId());
//		
//		cs.execute();
//		
//		ResultSet rs = (ResultSet) cs.getObject(1);
//		
//		while(rs.next()) {
//			Post p = new Post(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
//			posts.add(p);
//		}
//		
//		u.setPosts(posts);
//		
//		con.setAutoCommit(true);
		
		
		String sql = "SELECT * FROM bankAccount WHERE bankAccount.customer_id =" + "'" + user_id + "';" ;
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			bankAccounts.add(new Bank(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
		}
		
		//this method work for only one user own only one account
//		i have rule for allowing one user own one account only in the create bank method
		//same user id with many bank account will not work be cause i only select the first account in the list.
		
		if(bankAccounts.size() != 0) {
				Bank bankAccount = bankAccounts.get(0);
			return bankAccount;
		}else {
			
			throw new NoBankAccountFound();
		}	
		
		
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
	
	


//	deposit 
	public Bank deposit(Bank bankAccount,int depositAmount) {
		
		
		try {
			

			//add money transaction in widraw and deposit table
	  
			
			Connection con = conUtil.getConnection();		
		
//			String sql = "insert into depositAndWithdraw (deposit, customer_id) values " + "(" +depositAmount + ", " + bankAccount.getCustomer_id() + ");";
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);		
			
			
			
			
			String sql = "insert into depositAndWithdraw (deposit, customer_id) values"
					+ "(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, depositAmount);    
			ps.setInt(2, bankAccount.getCustomer_id());
		
			
			ps.execute();
			
	
			//adding deposit to bank account
			
			bankAccount.setBalance(depositAmount + bankAccount.getBalance());
			
			
			//create query to update bank account using bank account
			
			 sql = "UPDATE bankAccount SET balance = ?"
					+ " WHERE bankAccount.account_id = ?";
			
			      ps = con.prepareStatement(sql);
			
			ps.setInt(1,  bankAccount.getBalance());
			ps.setInt(2,  bankAccount.getAccount_id());
		
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return calculated balance bank account
		return bankAccount;
		
		
		
		
	}


	
	//withdraw
	public Bank withdraw (Bank bankAccount,int withdrawAmount) {
		
		
		try {
			

			//add money transaction in widrawal and deposit table
	  
			
			Connection con = conUtil.getConnection();			

			
			String sql = "insert into depositAndWithdraw (withdraw, customer_id) values"
					+ "(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, - withdrawAmount);    
			ps.setInt(2, bankAccount.getCustomer_id());
		
			
			ps.execute();
			
			//check if balance is less than 
			if(withdrawAmount >  bankAccount.getBalance() ||  bankAccount.getBalance() <= 0  ) {
				
				throw new InsufficientFund();
				
			}
			
			
	
			//adding deposit to bank account
			
			bankAccount.setBalance(- withdrawAmount + bankAccount.getBalance());
			
			
			//create query to update bank account using bank account
			
			 sql = "UPDATE bankAccount SET balance = ?"
					+ " WHERE bankAccount.account_id = ?";
			
			      ps = con.prepareStatement(sql);
			
			ps.setInt(1,  bankAccount.getBalance());
			ps.setInt(2,  bankAccount.getAccount_id());
		
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return calculated balance bank account
		return bankAccount;
		
		
	}
	
	
	
	
	
	
//transfer	money
	
	public  List<Bank> transfer(int sender, int receiver, int amount){
		
		
		List<Bank> bankAccountsList = new ArrayList<Bank>();
		
//		recieve sender id, recevier id , amount 
		
		try {
			Connection con = conUtil.getConnection();
	
		
//			insert to transer table transfer transaction
			
			String sql = "insert into transfer (sender_id , reciever_id , amount) values"
					+ "(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, sender);    
			ps.setInt(2, receiver);
			ps.setInt(3, amount);
			
			ps.execute();

			
	//update the account balance of sender and receiver
			
		
			
        //calculate			
			//get sender  bank account
		Bank senderAccount = 	this.getBankAccountByuser(sender);
		
		if(amount > senderAccount.getBalance() || senderAccount.getBalance() <= 0) {
			
			throw new  InsufficientFundToTransfer();
			
		}
		
			//get sender balance and add up the amount
		senderAccount.setBalance(senderAccount.getBalance() - amount);
		
		//get  receiver bank account
			
		Bank receiverAccount = 	this.getBankAccountByuser(receiver);
		//get receiver balance and minus the amount
		receiverAccount.setBalance(receiverAccount.getBalance() + amount);
		
		//update sender account
		
		 sql = "UPDATE bankAccount SET balance = ?"
					+ " WHERE bankAccount.customer_id = ?";
			
			      ps = con.prepareStatement(sql);
			
			ps.setInt(1, senderAccount.getBalance());
			ps.setInt(2, sender);
		
			
			ps.execute();
			//update receviver account	
			
			
			 sql = "UPDATE bankAccount SET balance = ?"
						+ " WHERE bankAccount.customer_id = ?";
				
				      ps = con.prepareStatement(sql);
				
				ps.setInt(1, receiverAccount.getBalance());
				ps.setInt(2, receiver);
			
				
				ps.execute();
				
				bankAccountsList.add(senderAccount);
				bankAccountsList.add(receiverAccount);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return bankAccountsList;
		
		
		
	}
	
	@Override
	public String toString() {
		return "bank account [id=" + account_id + ",account_number=" + account_number + ", balance=" + balance + ",  customer_id=" +  customer_id
				+   "]" + "\n";
	}





}
