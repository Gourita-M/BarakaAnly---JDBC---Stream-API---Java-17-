package src.Presentation;

import java.util.Scanner;

public class ClientMenu {

    private static Scanner scan = new Scanner(System.in); 

    public static void show()
    {
        boolean picked = false;
        int choice = 100;

        while(!picked){
            System.out.println("********** Client Managment **********");
            System.out.println("1. Add a Client ");
            System.out.println("2. Modify a Client");
            System.out.println("3. Delete a Client");
            System.out.print("Enter Your Choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    picked = true;
                    break;
                case 1:
                    picked = true;
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again");
            }
            
        }
        

    }
}

