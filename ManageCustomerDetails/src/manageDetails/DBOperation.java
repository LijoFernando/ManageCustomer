package manageDetails;
import jdk.jfr.internal.JVMSupport;
import org.omg.CORBA.INTERNAL;

import  java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBOperation {




    private  Connection con;
    private  void loadConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Root@123");
    }

    public  Connection getConnection() throws SQLException {
        if(con==null){
            loadConnection();
        }
        return  con;

    }

        public ArrayList<AccountInfo> loadHMapFromDB(){
        ArrayList<AccountInfo> accountInfoArray= new ArrayList<>();
        PreparedStatement ps = null;
        AccountInfo accountInfo =null;
        ResultSet rs;
        String query="SELECT * FROM AccountInfo";
        try{
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    accountInfo = new AccountInfo();
                    accountInfo.setAccId(rs.getInt(1));
                    accountInfo.setAccNo(rs.getInt(2));
                    accountInfo.setAccBalance(rs.getInt(3));
                    accountInfo.setAccBranch(rs.getString(4));
                    accountInfo.setCusId(rs.getInt(5));
                    accountInfoArray.add(accountInfo);
                }
            }
            finally {
                rs.close();
                ps.close();
            }

        } catch (Exception e){
            e.printStackTrace();

        }

        return  accountInfoArray;
    }



    
    //insert Customer Info to Database
    public int insertDetailToDB(String name, Date date, String location) throws  Exception  {
            PreparedStatement  ps = null;
            ResultSet rs = null;
            String query="insert into CustomerInfo (CusName, CusDoB, Location) values (?, ?, ?)";
            int cusID=0;
            try {
                ps = getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setDate(2, date);
                ps.setString(3, location);
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    cusID = rs.getInt(1);
                }
                System.out.println("Customer Record inserted");
            } catch (SQLException  e) {
                e.printStackTrace();
                System.out.println("Exception Occurs at Adding Customer Details");
            } finally {
                rs.close();
                ps.close();


            }
            return cusID;
    }
    
    //Insert AccountInfo to Database
    void insertAccountToDB(Integer accNo, Integer accBalance, String accBranch,Integer cusId) throws  SQLException{
        PreparedStatement ps;
            String query2 = "insert into AccountInfo (AccNumber, AccBalance, Branch, CusID ) values (?, ?, ?,?)";
            try {
                ps = getConnection().prepareStatement(query2);
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
                getConnection().close();
            }
    }
}