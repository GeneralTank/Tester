package Shared;

import java.util.Scanner;

public class displayMenu {
	
	public static Scanner keypad = new Scanner(System.in);
	
	public static int menu()
    {
        int menuChoice;
        do
        { 
            System.out.print("\nPlease Choose From the Following Options:"
                    + "\n 1. Display Balance \n 2. Deposit"
                    + "\n 3. Withdraw\n 4. Log Out\n\n");

            menuChoice = keypad.nextInt();

            if (menuChoice < 1 || menuChoice > 4){
                System.out.println("error");
            }

        }while (menuChoice < 1 || menuChoice > 4);

        return menuChoice;
    }

}
