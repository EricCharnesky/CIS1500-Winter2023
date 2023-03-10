import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        // new keyword creates an 'instance' of BankAccount in memory
        BankAccount ericsChecking = new BankAccount();

        ericsChecking.setOwnersName("Eric");
        ericsChecking.setBalance(1_000_000);
        ericsChecking.setInterestRate(.02);

                                    // calls constructor method
        BankAccount ericsSavings = new BankAccount();

        ericsSavings.setOwnersName("Eric");
        ericsSavings.setBalance(500);
        ericsSavings.setInterestRate(.04);

        BankAccount ericsDisneyFund =
                new BankAccount("Eric", 1_000, .01);

        printBankAccountDetails(ericsDisneyFund);

        if ( ericsDisneyFund.getOwnersName().equalsIgnoreCase("Eric")){
            System.out.println("This is Eric's disney fund");
        }

        printBankAccountDetails(ericsChecking);
        printBankAccountDetails(ericsSavings);

        withdrawFromAccount(
                getAccountByName("Which account do you want to withdrawn from?"
                        , ericsChecking, ericsSavings, ericsDisneyFund));

        depositToAccount(
                getAccountByName("Which account do you want to deposit to?"
                        , ericsChecking, ericsSavings, ericsDisneyFund));

    }

    public static BankAccount getAccountByName(String prompt, BankAccount checking, BankAccount savings, BankAccount disneyFund){
        Scanner keyboard = new Scanner(System.in);

        System.out.println(prompt);
        String account = keyboard.nextLine();

        while ( !account.equalsIgnoreCase("checking") &&
                !account.equalsIgnoreCase("savings") &&
                !account.equalsIgnoreCase("disney fund")){
            System.out.println("Which account do you want?");
            account = keyboard.nextLine();
        }

        if ( account.equalsIgnoreCase("Checking")) {
            return checking;
        } else if ( account.equalsIgnoreCase("Savings")){
            return savings;
        } else {
            return disneyFund;
        }
    }

    public static void depositToAccount(BankAccount account){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How much do you want to deposit?");
        double deposit = Double.parseDouble(keyboard.nextLine());

        account.deposit(deposit);

        System.out.println("Your new balance is: $" + account.getBalance());

    }

    public static void withdrawFromAccount(BankAccount account){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How much money do you want to withdraw?");
        double amount = Double.parseDouble(keyboard.nextLine());
        while ( !account.withdraw(amount ) ){
            System.out.println("Unable to withdraw that amount");
            System.out.println("Your balance is $" + account.getBalance());
            System.out.println("How much money do you want to withdraw?");
            amount = Double.parseDouble(keyboard.nextLine());
        }

        System.out.println("Withdraw successful");
        System.out.println("Your new balance is $" + account.getBalance());
    }

    public static void printBankAccountDetails( BankAccount account ){
        System.out.println("The account owners name is " + account.getOwnersName());
        System.out.println("The account balance is: $" + account.getBalance());
        System.out.println("The interest rate is " + account.getInterestRate());
    }
}