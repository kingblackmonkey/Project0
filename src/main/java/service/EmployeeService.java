package service;

import model.Employee;

public class EmployeeService {

	public void employeeServiceApprove() {
		// TODO Auto-generated constructor stub
		
		Employee employee = new Employee();
		  employee.approve();
	}
	
	
	public void viewDepositAndWithdrawTransactions() {
		
		Employee employee = new Employee();
		
		employee.viewDepositAndWithdrawTransactions();
	}


	public void viewAllTransferTransaction() {
		
		Employee employee = new Employee();
		employee.viewAllTransferTransaction();
	} 

public void  viewAllBankAccounts() {
	
	Employee employee = new Employee();
	employee.viewAllBankAccounts();
	
}



}
