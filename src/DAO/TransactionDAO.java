package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.database.DB;

public class TransactionDAO {
    
    public static ResultSet getTransactionByUserEmail(String userEmail)
    {
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
