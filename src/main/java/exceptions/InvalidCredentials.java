package exceptions;

public class InvalidCredentials extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidCredentials() {
		super("Invalid Credentials Please run the program and login again");
	}
}
