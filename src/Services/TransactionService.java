package src.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import src.DAO.TransactionDAO;

public class TransactionService {

    public static void deposit()
    {
        
    }
    
    public static void viewTransactions(String userEmail){

    try(ResultSet rs = TransactionDAO.getTransactionByUserEmail(userEmail)){

        while(rs.next()){
            Date date = rs.getDate("date");
            int amount = rs.getInt("amount");
            String type = rs.getString("type");
            String location = rs.getString("location");
            System.out.println(type + " | " + amount + "DH " + date + " " + location);
        }

    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
}
