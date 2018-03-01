package Shared;

public class Accounts {
	
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

}
