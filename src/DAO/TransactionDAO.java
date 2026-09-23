package src.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import src.database.DB;

public class TransactionDAO {
    
    public void getTransactionByUserId(int userId)
    {
        try {
            
            Connection connection = DB.connection();
            String sql = "SELECT * FROM Transaction as t WHERE t.id = 1";

        } catch (SQLException e) {
            System.out.println(e);
        }
        

        
    }
}
