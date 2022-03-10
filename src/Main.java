import Utility.Account;
import Utility.CAccount;

import java.util.Random;
import java.util.Scanner;


/**
 * The Main class provides a sample console program.
 */
public class Main {
// static
	public static class TestAccount
	{
		// String[] args
		public static void main(String[] args)
		{
			int userChoice = 0;
			CAccount a1 = new CAccount("Tan A K", "S123", 200,500);
			while (userChoice != 3) {
				userChoice = menu();
				Scanner input = new Scanner(System.in);
				switch (userChoice) {
					case 1 -> {
						System.out.println("Enter a deposit amount: ");
						double depositAmt = input.nextDouble();
						a1.deposit(depositAmt);
						CAccount.PrintAccount(a1);
					}
					case 2 -> {
						System.out.println("Enter a withdraw amount: ");
						double withdrawAmt = input.nextDouble();
						a1.withdraw(withdrawAmt);
						CAccount.PrintAccount(a1);
					}
					case 3 -> System.out.println("Exiting...");
					default -> System.out.println("Invalid choice");
				}
			}
		}
// print account

	}
	private static int menu() {
		// Selection menu class
		int selection;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Select an account operation: ");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Exit");
		} while (!input.hasNextInt());
		selection = input.nextInt();
		return selection;
	}
}
