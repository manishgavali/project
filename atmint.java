import java.util.Scanner;

class ATM 
{
	private BankAccount userAccount;
	public ATM(BankAccount acc) 
	{
        		this.userAccount = acc;
    	}

	public void displayMenu()
	{
        		System.out.println("\n--------ATM Menu:--------");
        		System.out.println("1. Withdraw");
        		System.out.println("2. Deposit");
		System.out.println("3. Check Balance");
        		System.out.println("4. Exit");
    	}

    	public void processOption(int option)
	{
        		Scanner s = new Scanner(System.in);

	        	switch (option)
		{
            			case 1:
                			System.out.print("Enter withdrawal amount: ");
	                		double withdrawAmount = s.nextDouble();
                			userAccount.withdraw(withdrawAmount);
                			break;
	            		case 2:
                			System.out.print("Enter deposit amount: ");
                			double depositAmount = s.nextDouble();
                			userAccount.deposit(depositAmount);
	                		break;
            			case 3:
                			System.out.println("Current Balance: " + userAccount.getBalance());
                			break;
	            		case 4:
                			System.out.println("Exiting. Thank you!");
	                		System.exit(0);
                			break;
	            		default:
                			System.out.println("Invalid option. Please choose a valid option.");
	        	}
 	}
}

class BankAccount 
{
	private double bal;

	public BankAccount(double inBal)
	{
		this.bal = inBal;
	}

	public double getBalance()
	{
		return bal;
	}

	public void deposit(double amnt) 
	{
		 if (amnt > 0)
		 {
			bal += amnt;
			System.out.println("SUCCESSFULLY DEPOSITED ");
		}
		else
		{
			System.out.println("INVALID AMOUNT");
		}	
	}

	public void withdraw(double amnt)
	{	
		if (amnt > 0 && amnt <= bal) 
		{
			bal -= amnt;
			System.out.println("SUCCESSFULLY WITHDRAW  ");
        		}
		else if (amnt > 0 && amnt > bal)  
		{
            			System.out.println("INSUFFICIENT BALANCE ");
		}
		else
		{
			System.out.println("INVALID AMOUNT");
		}
	}
}


public class atmint 
{
	public static void main(String args[])
	 {
	        	Scanner s = new Scanner(System.in);

        		System.out.print("ENTER YOUR INITIAL BALANCE : ");
	        	double inBal = s.nextDouble();

        		BankAccount userAccount = new BankAccount(inBal);
	        	ATM atm = new ATM(userAccount);

	        	while (true)
		{
	            		atm.displayMenu();
		            	System.out.print("ENTER YOUR OPTION: ");
		            	int opt = s.nextInt();
            			atm.processOption(opt);
		}
    	}
}
