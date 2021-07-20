package service;

import java.util.List;

import model.Bank;

public class BankService {

	
	
	
	
//customer create bank	
	
	public void customerCreateBankAccount(int customer_id ) {
		
		Bank bank = new Bank();
		bank.checkDuplicateBankAccount(bank, customer_id );
		EmployeeService employeeService = new EmployeeService();
		employeeService.employeeServiceApprove();
		bank.createbank(customer_id);
	}
	
	
	
	
	public Bank getBankAccountByuser(int user_id) {
		
		Bank bankAccount = new Bank();
		bankAccount =    bankAccount.getBankAccountByuser(user_id);
		
		
		return bankAccount;
	} 
	
	public Bank deposit(Bank bankAccount,int depositAmount) {
		
	
		bankAccount =    bankAccount.deposit(bankAccount, depositAmount);
		return bankAccount;
	}
	
	public Bank withdraw(Bank bankAccount,int withdrawAmount) {
		

					bankAccount =    bankAccount.withdraw (bankAccount,  withdrawAmount);
	
		
						return bankAccount;
	}
	
	public List <Bank>  transfer(int sender, int receiver, int amount ) {
		

		Bank bankAccount = new Bank();
		
		return bankAccount.transfer(sender, receiver, amount);


		
  }

}
