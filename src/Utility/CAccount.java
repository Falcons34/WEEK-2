package Utility;

public class CAccount extends Account{
	// constructor for CAccount
	private double overdraftLimit;
	private double overdraft;

	public CAccount(String name, String ID, double balance, double overdraft) {
		super(name, ID, balance);
		this.overdraft = overdraft;
		this.overdraftLimit = 500;
	}
// withdraw method for CAccount
	public double getOverdraft() {
		return this.overdraft;
	}
// set the overdraft for CAccount
	public void setOverdraft(double overdraft) {
		if(this.checkOverdrawLimit(overdraft)){
			this.overdraft += overdraft;
		}
	}
// withdraw method for CAccount
	public double getOverdraftLimit() {
		return overdraftLimit;
	}
// withdraw method for CAccount
	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	// check overdraw limit
	public boolean checkOverdrawLimit(double amount) {
		return amount <= this.overdraftLimit;
	}

// withdraw method for CAccount takes into account overdraw limit
	@Override
	public void withdraw(double amt) {
		// standard withdraw
		double balance = super.getBalance();
		if (balance - amt >= 0){
			super.setBalance(balance - amt);
		}else if (balance - amt < 0){
			// get difference between account balance and amount -> 200 - 250 = 50
			double overdraw = balance - amt;
			if (this.checkOverdrawLimit(overdraw)){
				double accountOverdraw = this.getOverdraft();
				if (accountOverdraw - overdraw > 0){
					super.setBalance(0);
					this.setOverdraft(accountOverdraw - overdraw);
				}else{
					System.out.println("Insufficient funds");
				}
			}else {
				System.out.println("Overdraw limit exceeded");
			}
		}
	}
// deposit override method for CAccount
	@Override
	public void deposit(double amount) {
		double overdraft = this.getOverdraft();
		double balance = super.getBalance();
		double overdraftLimit = this.getOverdraftLimit();
			// handle overdraft deposit
		if (balance >= 0){
			super.setBalance(balance + amount);
		}else{
			if (amount <= overdraft){
				this.setOverdraft(amount); // just top up overdraft
			}else{
				// fill overdraft top up account
				double remainingOverDraft = overdraftLimit - overdraft; // 50
				double difference = Math.abs(remainingOverDraft - amount); // 300 - 700 = 400
				this.setOverdraft(remainingOverDraft); // 400
				super.setBalance(difference); // 300
			}
		}

	}

	public double getAvailable() {
		return super.getBalance() + this.getOverdraft();
	}
	public static void PrintAccount(CAccount a1) {
		System.out.printf("Account: %s%n Name: %s%n Balance: $%5.2f%n " +
						"Overdraft: $%5.2f%n Available: $%5.2f%n Overdraft Limit: $%5.2f%n"
				, a1.getID(), a1.getName(), a1.getBalance(), a1.getOverdraft(), a1.getAvailable(),a1.getOverdraftLimit());
	}
}
