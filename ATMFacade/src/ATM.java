import java.util.*;
import Shared.*;
import Withdraw.*;
import Deposit.*;
//KYLE WAS HEEEERE
/*
 * Disclaimer: We do not own most of this code, we just got it from https://codereview.stackexchange.com/questions/109831/simple-atm-program-with-various-options
 * and applied the facade pattern by making separate packages and classes for each function like withdrawing, depositing, etc.
 * 
 * The original project only had one class called ATM, as shown in the link. 
 */

public class ATM {
	
	public static Scanner keypad = new Scanner(System.in);
    
    // The checkID method determines if acctNum is a valid account number
    // and pinCode is the correct password for the account.  If the account information
    // is valid, the method returns the current account balance, as a string.
    // If the account information is invalid, the method returns the string "error".
    public static String checkID(String acctNum, String pinCode)
    {
        String result = "error";

        // Strings a, b, and c contain the valid account numbers and passwords.
        // For each string, the account number is listed first, followed by
        // a space, followed by the password for the account, followed by a space,
        // followed by the current balance.
        String a = "Account1 1234 420";
        String b = "Account2 5678 69";
        String c = "Account3 0123 12629";

        if (acctNum.equals(a.substring(0, a.indexOf(" "))) && 
                pinCode.equals(a.substring(a.indexOf(" ")+1,a.lastIndexOf(" "))))
            return result = a.substring(a.lastIndexOf(" ") + 1);

        if (acctNum.equals(b.substring(0, b.indexOf(" "))) && 
                pinCode.equals(b.substring(b.indexOf(" ")+1,b.lastIndexOf(" "))))
            return result = b.substring(b.lastIndexOf(" ") + 1);

        if (acctNum.equals(c.substring(0, c.indexOf(" "))) && 
                pinCode.equals(c.substring(c.indexOf(" ") + 1,c.lastIndexOf(" "))))
            return result = c.substring(c.lastIndexOf(" ") + 1);

        return result;
    }
    
    //MENU STARTS HERE

    public static void main(String[] args) {

        String accNum, pass, origBal = "error";
        int count = 0, menuOption = 0;
        double depositAmt = 0, withdrawAmt = 0, currentBal=0; 
        boolean  foundNonDigit;
        //loop that will count the number of login attempts
        //you make and will exit program if it is more than 3.
        //as long as oriBal equals an error.  
        do{
            foundNonDigit = false;
            System.out.println("Please Enter Your Account Number: ");
            accNum = keypad.next();

            System.out.println("Enter Your Password: ");
            pass = keypad.next();

            origBal = checkID(accNum, pass);

            count++;

            if (count >= 3 && origBal.equals("error")){
                System.out.print("Maximum Login Attempts Reached.");
                System.exit(0);
            }
            if (!(origBal.equals("error"))){
                System.out.println("\nYour New Balance is: P "+ origBal);
            }
            else
                System.out.println(origBal);


        }while(origBal.equals("error"));

        currentBal=Double.parseDouble(origBal);
        //this loop will keep track of the options that 
        //the user inputs in for the menu. and will 
        //give the option of deposit, withdraw, or logout.

        while (menuOption != 4)
        { 
            menuOption = displayMenu.menu(); //method call to withdraw package
            
            switch (menuOption) {
            case 1:
            	
                displayBalance.displayBalance(currentBal); //method call to withdraw package
                break;
                
            case 2:
            	
                System.out.print("\nEnter Amount You Wish to Deposit: P ");
                depositAmt = keypad.nextDouble();
                currentBal=deposit.deposit(depositAmt, currentBal); //method call to withdraw package
                break;
                
            case 3:
            	
                System.out.print("\nEnter Amount You Wish to Withdrawl: P ");
                withdrawAmt = keypad.nextDouble();

                while(withdrawAmt>currentBal){
                    System.out.print("ERROR: INSUFFICIENT FUNDS!! "
                            + "PLEASE ENTER A DIFFERENT AMOUNT: P");
                    withdrawAmt = keypad.nextDouble();
                }

                currentBal = withdraw.withdraw(currentBal, withdrawAmt); //method call to withdraw package
                break;
                
            case 4:
            	
                System.out.print("\nThank you for you transaction! Goodbye!");
                System.exit(0);
                break;
                
            }
            
        }
        
    }
    
}