package src.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import src.DAO.*;

public class AccountService  { 
    
    public static boolean getClientAccounts(String Email)
    {
        int clientId = ClientDAO.getClientId(Email);

        if(clientId == 0){
            return false;
        }
        
        ResultSet result = AccountDAO.getAccountsbyClientId(clientId);

        try{
        
        if (result.next()) {

                do {
                    int id = result.getInt("id");
                    int number = result.getInt("number");
                    double balance = result.getDouble("balance");

                    System.out.println(
                        "ID: " + id +
                        " | " + balance + "DH" +
                        " | " + number
                    );

                } while (result.next());

            } else {

                System.out.println("You Don't Have Any Accounts");
                return false;
            }
        
        
        }catch(SQLException e){
            System.out.println(e);
        }

        return true;
    }
}
