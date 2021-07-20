package exceptions;

public class InsufficientFund extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public InsufficientFund() {
		
		super("View your balance again. your withdrawal must be less than your available balance");
		// TODO Auto-generated constructor stub
	}

}
