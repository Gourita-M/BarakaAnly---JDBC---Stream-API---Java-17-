package src.DAO;

import java.sql.Connection;
import src.Exceptions.ClientError;
import src.database.DB;

public class ClientDAO {

    private Connection connection;

    public void create() throws Exception
    {
        try {

            connection = DB.connection();
            
            String sql = "INSERT INTO Client(name,email) VALUES('Mouad','mouad.mouad')";

            throw new ClientError("Problems Creating a New Client");
        
        } catch (ClientError e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void update()
    {

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