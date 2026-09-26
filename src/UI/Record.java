package src.UI;

import java.util.Scanner;
import src.DAO.AccountDAO;
import src.Services.*;

public class Record {

    private static final Scanner scan = new Scanner(System.in);
    
    public static void show()
    {
        boolean picked = false;
        int choice = 100;

        while(!picked){
            System.out.println("********** Record a transaction **********");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Transfer");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    picked = true;
                    break;
                case 1:
                    depositMenu();
                    break;
                case 2:
                    withdrawalMenu();
                    break;
                case 3:
                    transfer();
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again");
            }
            
        }
    }
    public static void depositMenu(){
           
        scan.nextLine();

        System.out.print("Please Enter Your Email: ");
        String email = scan.nextLine();

        boolean acc = AccountService.getClientAccounts(email);

        if(!acc){
            return;
        }

        System.out.println("");
        System.out.print("Enter Account ID To Deposit Into: ");
        int accountId = scan.nextInt();
        System.out.print("Enter Amount: ");
        Double amount = scan.nextDouble();
        if(amount < 0){
            System.out.println("Amount Can't Be Negative");
        }
        if(AccountDAO.deposit(accountId, amount)){
            System.out.println("You Have Added " + amount + " To Your Account");
        }else{
            System.out.println("Error Deposit");
        }
        TransactionService.deposit(amount, accountId);
    }

    public static void withdrawalMenu(){
           
        scan.nextLine();

        System.out.print("Please Enter Your Email: ");
        String email = scan.nextLine();

        boolean acc = AccountService.getClientAccounts(email);

        if(!acc){
            return;
        }

        System.out.println("");
        System.out.print("Enter Account ID To Withdrawal From: ");
        int accountId = scan.nextInt();
        System.out.print("Enter Amount: ");
        Double amount = scan.nextDouble();

        if(AccountDAO.withdrawal(accountId, amount)){
            System.out.println("You Have Took " + amount + " From Your Account");
        }else{
            System.out.println("Error Withdrawal");
        }
        TransactionService.withdrawal(amount, accountId);
    }

    public static void transfer(){
        scan.nextLine();

        System.out.print("Please Enter Your Email: ");
        String email = scan.nextLine();

        boolean acc = AccountService.getClientAccounts(email);

        if(!acc){
            return;
        }
    
        System.out.println("Enter Account ID to Transfer From");
        int from = scan.nextInt();

        System.out.println("Enter Account ID to Transfer To");
        int to = scan.nextInt();

        System.out.print("Enter Amount: ");
        Double amount = scan.nextDouble();

        if(AccountService.transfer(from, to, amount)){
            System.out.println("Transformed " + amount );
        }else{
            System.out.println("Error Transfering Money");
        }
        TransactionService.transfer(amount, from);
    }
}
