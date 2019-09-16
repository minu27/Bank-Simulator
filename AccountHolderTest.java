package BankOfIIT;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

/**
 * This class contains the main method and calls the methods of the
 * AccountHolder class to execute all the banking requests of the user.
 * 
 * @author Minal Devanand Vaity
 * @version 1.0
 * @since 2019-09-13
 * @Lab Lab-1
 */

public class AccountHolderTest {
	//This is the main method of the class.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Bank of IIT.");
		System.out.println("Enter Initial Balance.\n");
		// AccountHolder is called to set up the initial balance amount.
		try {
		AccountHolder acct = new AccountHolder(sc.nextDouble());
		
		int i = 1;
		
		// To loop the menu till the value stays true.
		while(i==1)
		{  
			/**The account holder will select the options from the menu where the customer can 
			 * check the balance, deposit the money, withdraw amount from his account and 
			 * can calculate monthly interest rate @ 4%
			 */
			System.out.println("\nChoose from the below options: \n");
			System.out.println("__________________________________");
			System.out.println("\n1.Deposit Money \n2.Withdraw Money \n3.Balance Enquiry \n4.Annual Balance History \n5.Exit");
			System.out.println("__________________________________");
			/**
			 * @throws The compiler will throw InputMismatchException if user
			 * enters a character or a string.It is taken care of
			 * using the try catch block.
			 */
			try
			{
				menu = sc.nextInt();
			}
			catch(InputMismatchException e) 
			{
				sc.next();
			}
			switch(menu)
			{
			//Option 1 is called to deposit the amount in the Account holders account using deposit method from Accountholder.java
			case 1:
				System.out.print("\nEnter the amount to be deposited.\n");
				double d = 0;
				d = sc.nextDouble();
				acct.deposit(d);
				break;
			//Option 2 is called to withdraw amount from the account using withdraw method from Accountholder.java 	
			case 2:
				double w = 0;
				System.out.println("\nEnter the amount to be withdrawn.\n");
				w = sc.nextDouble();
				acct.withdraw(w);
				break;
			// Option 4 is called to display current balance amount using the getBalance method from Accountholder.java
			case 3:
				System.out.println("\nYour Account Balance is " + acct.getBalance());
				break;
			// Option 4 is called to display monthly interest on monthly basis from the current balance using monthlyInterest method from Accountholder.java 
			case 4:
				acct.monthlyInterest();
				break;
			// Option 5 is called to sign off from Customer system.  
			case 5:
				System.out.println("\nThank you for banking with Bank of IIT.\n");
				i=0;
				break;
			default:
				System.out.println("\nInvalid Input. Please try again.\n");
				break;
			}
		}
		// Displays the current date and time and my name.
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Minal Devanand Vaity\n");
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input. Please re-run the program and try again.");
		}
		sc.close();
	}
}
