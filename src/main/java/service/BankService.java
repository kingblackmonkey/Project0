package service;

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
}
