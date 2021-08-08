package manageDetails;
import  java.sql.*;

public class DBOperation {

    DBConnector dbConnector = new DBConnector();

    void insertDetailToDB(String name, Date date, String location) throws  Exception  {
            String query="insert into CustomerInfo (CusName, CusDoB, Location) values (?, ?, ?)";
            try {
                dbConnector.prepStatement(query).setString(1, name);
                dbConnector.prepStatement(query).setDate(2, date);
                dbConnector.prepStatement(query).setString(3, location);
                dbConnector.prepStatement(query).executeUpdate();
                System.out.println("Customer Record inserted");
            } catch (SQLException  e) {
                e.printStackTrace();
                System.out.println("Exception Occurs at Adding Customer Details");
            } finally {
                dbConnector.getConnection().close();

            }
    }

    void insertAccountToDB(Integer accNo, Integer accBalance, String accBranch) throws  SQLException{
            String query2 = "insert into AccountInfo (CusName, CusDoB, Location) values (?, ?, ?)";
            try {
                dbConnector.prepStatement(query2).setInt(1,accNo );
                dbConnector.prepStatement(query2).setInt(2, accBalance );
                dbConnector.prepStatement(query2).setString(3, accBranch);
                dbConnector.prepStatement(query2).executeUpdate();
                System.out.println("Account Record inserted");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Exception Occurs at Add account Details");
            } finally {
                dbConnector.getConnection().close();
            }
    }
}