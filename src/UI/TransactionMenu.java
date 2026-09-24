package src.UI;

import java.util.Scanner;
import src.Services.TransactionService;

public class TransactionMenu {
    private final static Scanner scan = new Scanner(System.in);
    
    public static void show()
    {
        System.out.print("Enter Account Email: ");
        String accountEmail = scan.nextLine();

        TransactionService.viewTransactions(accountEmail);

    }
}
