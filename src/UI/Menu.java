package src.UI;

import java.util.Scanner;
import src.Services.ReportService;

public class Menu {

    private static Scanner scan = new Scanner(System.in); 

    public static void show()
    {
        boolean picked = false;
        int choice = 100;

        while(!picked){
            System.out.println("********** Welcome to Bank Analys **********");
            System.out.println("1. Record a transaction (deposit, withdrawal, transfer)");
            System.out.println("2. View the transaction history of an account");
            System.out.println("3. Analysis");
            System.out.println("4. Alerts");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    picked = true;
                    break;
                case 1:
                    Record.show();
                    break;
                case 2:
                    TransactionMenu.show();
                    break;
                case 3:
                    scan.nextLine();
                    System.out.print("Enter Your Email: ");
                    String email = scan.nextLine();
                    ReportService.accountAnalysis(email);
                    break;
                case 4:
                    scan.nextLine();
                    System.out.print("Enter Your Email: ");
                    String alertEmail = scan.nextLine();
                    ReportService.alerts(alertEmail);
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again");
            }
            
        }
        

    }
}
