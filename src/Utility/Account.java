package Utility;

// Class as public
public class Account
{
	private String name;
	private String ID;
	//balance needs to be private
	private double balance;
	// Constructor needs to be non-void
	public Account(String name, String ID, double balance)
	{
		this.name = name;
		this.ID = ID;
		this.balance = balance;
	}
	// return balance
	// @return balance
	public double getBalance()
	{
		return balance;
	}
	// Method to withdraw money
	// @param amt - amount to withdraw
	public void withdraw(double amt)
	{
		if (this.balance - amt > 0){
			this.balance -= amt;
		}else {
			System.out.println("Insufficient funds");
		}
	}
	// Method to deposit money
	// @param amt - amount to deposit
	public void deposit(double amt)
	{
		this.balance += amt;
	}
	// Set name of account
	// @param name - name of account
	public void setName(String name)
	{
		this.name = name;
	}
	// Set ID of account
	// @param ID - ID of account
	public void setID(String ID)
	{
		this.ID = ID;
	}
	// Set balance of account
	// @param balance - balance of account
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	// Return name of account
	// @return name of account
	public String getName()
	{
		return this.name;
	}
	// Return ID of account
	// @return ID of account
	public String getID()
	{
		return this.ID;
	}
	public static void PrintAccount(CAccount a1) {
		System.out.printf("Account: %s%n Name: %s%n Balance: $%5.2f%n Available: $%5.2f%n"
				, a1.getID(), a1.getName(), a1.getBalance(), a1.getAvailable());
	}
}

