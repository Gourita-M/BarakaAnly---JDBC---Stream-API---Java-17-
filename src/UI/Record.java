package src.UI;

import java.util.Scanner;
import src.DAO.AccountDAO;
import src.Services.AccountService;
;

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

                    break;
                default:
                    System.out.println("Invalid Choice. Try Again");
            }
            
        }
    }
    public static void depositMenu()
    {   
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

        AccountDAO.deposit(accountId, amount);
    }
}
