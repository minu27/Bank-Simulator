package BankOfIIT;
import java.util.*;
import java.util.Scanner;
/**
 * The AccountHolder program contains all the methods
 * applicable to the banking systems. It contains methods for all 
 * the basic functionalities requested by the user in a bank.
 * 
 * @author Minal Devanand Vaity
 * @version 2.0
 * @since 2019-09-13
 */
public class AccountHolder 
{
		// introduce a Scanner class object
		Scanner sc = new Scanner(System.in);
		// declare and initialize the variables
	    double balance = 0;
	    //Interest Rate for all accounts
	    static double annualInterestRate = 0.04;
	    /**
		 * The below method declares the format in which the balance is 
		 * displayed on the screen.
		 * 
		 * @return will result in display of the balance correctly with two 
		 * decimal places correct.
		 */
	    public String getBalance() 
	    {
			return String.format("$%.2f", balance);
		}
	    /**
		 * The constructor will create a new account with the specified balance
		 * and check if the balance is less than zero.
		 * If the balance is negative then assign the value zero to balance
		 * and ask user to re-enter the initial balance.
		 * 
		 * @param balance The value passed by the user to set up initial balance.
		 */
	    AccountHolder(double balance)
	    {
	    	try 
	    	{
	    		this.balance = balance;
	    		if(balance <= 0)
	    		{
	    			balance = 0;
	    			System.out.println("Please re-enter a positive beginning balance!");
	    			balance = sc.nextDouble();
	    		}
	    	}
	    	catch(InputMismatchException e)
	    	{
	    		System.out.println("Invalid Input please try again.");
	    		balance = sc.nextDouble();
	    	}
	    }
	    
	    /**This method computes monthly interest on monthly basis for 12 months based on balance
	     * and annual interest rate at 4 percent.
	     * 
	     * @param This method does not accept any parameters and does not return anything.
	     */
	    public void monthlyInterest()
	    {
	    	System.out.println("\nMonthly Balance with Interest at "+annualInterestRate);
			System.out.println("\nBase Balance :" + getBalance());
			for (int i = 0; i < 12; i++) 
			{
				balance += balance * (annualInterestRate / 12.0);
				System.out.println("Balance for Month" + " " + (i + 1) + ": " + getBalance());
			}
	    }
	    
	    /**
		 * This method is used to deposit money into the user's bank account.
		 * 
		 * @param dep Input from the user for depositing the amount dep.
		 */
	    public void deposit(double dep)
	    {
	    	if(dep <= 0) 
	    	{
	    		System.out.println("Please deposit an amount greater than zero");
	    	}
	    	else
	    	{
	    		balance = balance + dep;
	    		System.out.println("Deposit Successful!");
	    		System.out.println("Your Account Balance is " + getBalance());
	    	}
	    }
	    
	    /**
		 * This method declares the conditions to be imposed upon
		 * the user while withdrawing money from the bank.
		 * 
		 * @param wit Input from the user for withdrawing amount wit.
		 */	    
	    public void withdraw(double wit)
	    {
	    	// Balance after withdrawal is checked if it goes below zero and $50 is then deducted.
	    	if (balance - wit <= 0)
	    	{
	    		System.out.println("You have a low balance! $50 deducted from your current account");
	    		balance = balance - 50;
	    		System.out.println("Your Account Balance is " + getBalance());
	    	}
	    	// Withdrawal amount is checked if it is zero or negative and error message is displayed.
	    	else if(wit <= 0)
	    	{
	    		System.out.println("Invalid entry. Please try again.");
	    	}
	    	// If valid amount is entered then balance is withdrawn successfully and account balance is displayed.
	    	else
	    	{
	    		balance = balance - wit;
	    		System.out.println("Withdrawal Successful!");
	    		System.out.println("Your Account Balance is " + getBalance());
	    	}
	    }
}

