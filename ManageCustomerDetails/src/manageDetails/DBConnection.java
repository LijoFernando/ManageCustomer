package manageDetails;
import  java.sql.*;

public class DBConnection {
    //c
    Customer customerValue = new Customer();
    public Connection conncetion() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Root@123");
        return(con);
    }

    void insertDetailToDB(String name, Date date, String location) throws SQLException {

            Connection con =conncetion();
            try (PreparedStatement preparedStatement = con.prepareStatement("insert into CustomerInfo (CusName, CusDoB, Location) values (?, ?, ?)")) {
                preparedStatement.setString(1, name);
                preparedStatement.setDate(2, date);
                preparedStatement.setString(3, location);
                preparedStatement.executeUpdate();
            }
            con.close();
            System.out.println("Record inserted");

    }

//    void insertAccountToDB(accNo, accBalance, accBranch){
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con =conncetion();
//            try (PreparedStatement preparedStatement = con.prepareStatement("insert into Info (CusName, CusDoB, Location) values (?, ?, ?)")) {
//                preparedStatement.setString(1, name);
//                preparedStatement.setDate(2, date);
//                preparedStatement.setString(3, location);
//                preparedStatement.executeUpdate();
//            }
//            con.close();
//            System.out.println("Record inserted");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}