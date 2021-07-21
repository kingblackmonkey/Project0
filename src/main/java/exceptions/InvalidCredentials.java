package exceptions;

public class InvalidCredentials extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidCredentials() {
		super("Invalid Credentials. Check your username or password or you sign up if you dont have an account. Please run the program again ");
	}
}
