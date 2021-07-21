package exceptions;

public class NoBankAccountFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NoBankAccountFound() {
		super("You dont have a bank account yet. Please aplly one ");

}
	
	
	
}
