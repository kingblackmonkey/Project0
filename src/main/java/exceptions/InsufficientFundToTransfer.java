package exceptions;

public class InsufficientFundToTransfer extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public InsufficientFundToTransfer() {
		super("View your balance again. Transfer amount is more than your available balance");

}
	
}
