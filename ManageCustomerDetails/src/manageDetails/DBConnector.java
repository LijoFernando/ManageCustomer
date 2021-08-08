package manageDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Root@123");
        return(con);
    }
    public  static PreparedStatement prepStatement(String query) throws  SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        return preparedStatement;
    }
}
