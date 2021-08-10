package manageDetails;

import java.sql.*;

public class DBConnector {
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Root@123");
        return(con);
    }
//    public  PreparedStatement prepStatement(String sql) throws  SQLException {
//        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
//        return preparedStatement;
//    }


}
