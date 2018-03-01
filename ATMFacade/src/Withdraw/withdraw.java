package Withdraw;

public class withdraw {
	
	public static double withdraw(double x, double y)
    {
        double withdrawAmt = y, currentBal = x, newBalance;

        newBalance = currentBal - withdrawAmt;
        System.out.printf("Your New Balance is P%.2f\n",newBalance);

        return newBalance;  
    }

}
