package exceptions;

public class AccountDeny extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountDeny() {
		// TODO Auto-generated constructor stub
		super("Your account application is denied");
	}

}
