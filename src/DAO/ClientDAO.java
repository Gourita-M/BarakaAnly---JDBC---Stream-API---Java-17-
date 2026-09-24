package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.Exceptions.ClientError;
import src.database.DB;

public class ClientDAO {

    public void create() throws Exception
    {
        try {

            Connection connection = DB.connection();
            
            String sql = "INSERT INTO Client(name,email) VALUES('Mouad','mouad.mouad')";

            throw new ClientError("Problems Creating a New Client");
        
        } catch (ClientError e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static int getClientId(String Email)
    {
        int userId = 0;

        try {
            Connection connection = DB.connection();

            String sql = "SELECT u.id FROM Client as u WHERE u.email = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, Email);

            ResultSet result = ps.executeQuery();

            

            if(result.next()){
                userId = result.getInt("id");
            }

            if(userId != 0){
                return userId;
            }else{
                System.out.println("Client Not Found");
                return userId;
            }
            

        } catch (SQLException e) {
            System.out.println(e);
            return userId;
        }
    }

    public void getAll()
    {

    }

    public void delete()
    {

    }
}

// try {
//             Statement statement = DB.connection();
//             String sql = "INSERT INTO users (name, age) VALUES ('"
//                     + "name" + "', " + 66 + ")";
//             statement.executeUpdate(sql);

//             // while (result.next()) {

//             //     String name = result.getString("name");
//             //     String age = result.getString("age");

//             //     System.out.println(name);
//             //     System.out.println(age);
//             // }

//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }