package Deposit;

public class deposit {
	
	public static double deposit(double x, double y)
    {
        double depositAmt = y, currentBal = x;
        double newBalance = depositAmt + currentBal;

        System.out.printf("Your New Balance is P%.2f\n",  newBalance);

        return newBalance;
    }

}
