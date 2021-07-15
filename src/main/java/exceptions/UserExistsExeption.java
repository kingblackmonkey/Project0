package exceptions;

public class UserExistsExeption extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UserExistsExeption() {
		super("A username was created that already exists in the database");
	}
}
