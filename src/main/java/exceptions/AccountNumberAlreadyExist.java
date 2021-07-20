package exceptions;

public class AccountNumberAlreadyExist extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNumberAlreadyExist() {
		// TODO Auto-generated constructor stub
		super("Account number already exists or you already have account with us. please create bank account again by signing up");
	}

}
