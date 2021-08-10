package manageDetails;
import javax.swing.plaf.nimbus.State;
import  java.sql.*;

public class DBOperation {

    DBConnector dbConnector = new DBConnector();
    ResultSet resultSet =null;
    PreparedStatement ps=null;
    
    public ResultSet loadHMapFromDB(){
        String query="SELECT * FROM AccountInfo";
        try{
            ps = dbConnector.getConnection().prepareStatement(query);
            resultSet = ps.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    
    //insert Customer Info to Database
    public int insertDetailToDB(String name, Date date, String location) throws  Exception  {
            String query="insert into CustomerInfo (CusName, CusDoB, Location) values (?, ?, ?)";
            int cusID=0;
            try {
                ps = dbConnector.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setDate(2, date);
                ps.setString(3, location);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    cusID = rs.getInt(1);
                }
                System.out.println("Customer Record inserted");
            } catch (SQLException  e) {
                e.printStackTrace();
                System.out.println("Exception Occurs at Adding Customer Details");
            } finally {
                dbConnector.getConnection().close();

            }
            return cusID;
    }
    
    //Insert AccountInfo to Database
    void insertAccountToDB(Integer accNo, Integer accBalance, String accBranch,Integer cusId) throws  SQLException{
            String query2 = "insert into AccountInfo (AccNumber, AccBalance, Branch, CusID ) values (?, ?, ?,?)";
            try {
                ps = dbConnector.getConnection().prepareStatement(query2);
                ps.setInt(1,accNo );
                ps.setInt(2, accBalance );
                ps.setString(3, accBranch);
                ps.setInt(4,cusId);
                ps.executeUpdate();
                System.out.println("Account Record inserted");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Exception Occurs at Add account Details");
            } finally {
                dbConnector.getConnection().close();
            }
    }
}