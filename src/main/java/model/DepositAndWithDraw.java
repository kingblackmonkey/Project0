package model;

public class DepositAndWithDraw {

	private int  transaction_id;
	private int  deposit;
	private int  withdraw;
	private int  customer_id;
	
	private String  first_name;

	private String  last_name;
	private String  username;
	private String  typeofuser;
	private String  password;
	
	
	
	
	
	
	public DepositAndWithDraw(int transaction_id, int deposit, int withdraw, int customer_id, String first_name,
			String last_name, String username, String typeofuser, String password) {
		super();
		this.transaction_id = transaction_id;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.typeofuser = typeofuser;
		this.password = password;
	}






	@Override
	public String toString() {
		return "DepositAndWithDraw [transaction_id=" + transaction_id + ", deposit=" + deposit + ", withdraw="
				+ withdraw + ", customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", username=" + username + ", typeofuser=" + typeofuser + ", password=" + password + "]" + "\n";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
