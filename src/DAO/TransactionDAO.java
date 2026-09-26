package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.database.DB;
import src.entity.*;

public class TransactionDAO {
    
    public static boolean createTransaction(Transaction transaction){
        try {
            Connection connection = DB.connection();

            String sql = "INSERT INTO Transaction(date,amount,type,location,accountId) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            java.util.Date date = transaction.getDate();
            ps.setDate(1, new java.sql.Date(date.getTime()));

            ps.setDouble(2, transaction.getAmount());
            ps.setString(3, transaction.getType().name());
            ps.setString(4, transaction.getLocation());
            ps.setInt(5, transaction.getAccountId());

            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public static ResultSet getTransactionByUserEmail(String userEmail){

        try {
            
            Connection connection = DB.connection();

            String sql = "SELECT u.id FROM Client as u WHERE u.email = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, userEmail);

            ResultSet result = ps.executeQuery();

            int userId;

            if(result.next()){
                userId = result.getInt("id");
            }else{
                return null;
            }

            sql = "SELECT * FROM Transaction as t WHERE t.accountId = ?";

            ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);

            result = ps.executeQuery();

            return result;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        

        
    }
}
