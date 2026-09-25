package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.database.DB;

public class AccountDAO {
    
    public static ResultSet getAccountsbyClientId(int ClientId)
    {
        try {
            Connection connection = DB.connection();

            String sql = "SELECT * FROM Account a WHERE a.clientId = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, ClientId);

            ResultSet result = ps.executeQuery();

            return result;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void deposit(int accountId, Double amount)
    {
        Double balance = 0.00;

        try {
            ResultSet result = getAccountBalance(accountId);

            if(result.next()){
                do { 
                    balance = result.getDouble("balance");
                } while(result.next());
            }else{
                System.out.println("There is No Account with this ID");
            }

            Connection connection = DB.connection();

            String sql = "UPDATE Account SET balance = ? WHERE clientId = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDouble(1, balance + amount);
            ps.setInt(2, accountId);
            ps.executeUpdate();

            System.out.println("You Have Added " + amount + " To Your Account.");
            
        } catch (SQLException e) {
            
            System.out.println(e);
        }
    }

    public static ResultSet getAccountBalance(int accountId)
    {
        try {
            Connection connection = DB.connection();

            String sql = "SELECT a.balance FROM Account a WHERE a.id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, accountId);

            ResultSet result = ps.executeQuery();

            return result;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
