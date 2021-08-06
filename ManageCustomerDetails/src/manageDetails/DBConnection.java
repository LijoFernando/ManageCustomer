package manageDetails;
import  java.sql.*;

public class DBConnection {
    //Class.forName("com.mysql.jdbc.Driver");
    void insertDetailToDB(String name , Date date) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Q@W#E$R%");
            PreparedStatement preparedStatement = con.prepareStatement("insert into CustomerInfo (Name,Birth) values (?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setDate(2,date);
            con.close();
            System.out.println("Record inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void loadToHash(){
        try {


        }
    }

}
