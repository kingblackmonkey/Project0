package model;

public class ViewAllBankAccounts {
private int ID;
private String first_name;
private String last_name;
private  String username;
private  String typeofuser;

private  String password;
private  int account_id;
private int account_number;

private int balance;


















public ViewAllBankAccounts(int iD, String first_name, String last_name, String username, String typeofuser,
		String password, int account_id, int account_number, int balance) {
	super();
	ID = iD;
	this.first_name = first_name;
	this.last_name = last_name;
	this.username = username;
	this.typeofuser = typeofuser;
	this.password = password;
	this.account_id = account_id;
	this.account_number = account_number;
	this.balance = balance;
}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getTypeofuser() {
	return typeofuser;
}

public void setTypeofuser(String typeofuser) {
	this.typeofuser = typeofuser;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

@Override
public String toString() {
	return "ViewAllBankAccounts [ID=" + ID + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
			+ username + ", typeofuser=" + typeofuser + ", password=" + password + ", account_id=" + account_id
			+ ", account_number=" + account_number + ", balance=" + balance + "]" + "\n" + "\n";
}







}
