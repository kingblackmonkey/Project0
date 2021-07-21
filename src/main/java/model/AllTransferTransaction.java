package model;


public class AllTransferTransaction {
	private int transactionId;
	private int senderId;
	private User sender;
	private int recieverId;
	private User reciever;
	private int amount;
	
	
	
	

	
	
	
	
	
	
	
	
	
	public AllTransferTransaction(int transactionId, int senderId, int recieverId, int amount) {
		super();
		this.transactionId = transactionId;
		this.senderId = senderId;
		
		this.recieverId = recieverId;

		this.amount = amount;
	}










	public int getTransactionId() {
	return transactionId;
}










public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}










	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public int getRecieverId() {
		return recieverId;
	}
	public void setRecieverId(int recieverId) {
		this.recieverId = recieverId;
	}
	public User getReciever() {
		return reciever;
	}
	public void setReciever(User reciever) {
		this.reciever = reciever;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}










	@Override
	public String toString() {
		return "AllTransferTransaction [transactionId=" + transactionId + ", senderId=" + senderId + ", sender="
				+ sender + ", recieverId=" + recieverId + ", reciever=" + reciever + ", amount=" + amount + "]" + "\n" + "\n";
	}
	
	
	
	
	
}
