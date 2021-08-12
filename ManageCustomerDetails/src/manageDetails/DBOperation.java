package manageDetails;

import  java.sql.*;
import java.util.ArrayList;

public class DBOperation {

    private Connection con;
    private void loadConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Root@123");
    }

    public Connection getConnection() throws SQLException {
        if(con == null){
            loadConnection();
        }
    return  con;
    }

    public ArrayList<AccountInfo> accountInfoRecords() throws MyException {
        ArrayList<AccountInfo> accountInfoArray = new ArrayList<>();
        ResultSet rs;
        String query = "//SELECT * FROM AccountInfo";
            try {
                PreparedStatement  ps = getConnection().prepareStatement(query);
                rs = ps.executeQuery();
                try {
                    while (rs.next()) {
                        AccountInfo accountInfo = new AccountInfo();
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
            }
            catch (SQLException e){
                   throw new MyException("Account HashMap Loading is Unsuccessful,Invalid Query!!");
            }

    return accountInfoArray;
    }

    //insert Customer Info to Database
    public int insertDetailToDB (String name, Date date, String location) throws MyException {
          try {
              PreparedStatement ps = null;
              ResultSet rs = null;
              String query = "insert into CustomerInfo (CusName, CusDoB, Location) values (?, ?, ?)";
              int cusID = 0;
              try {
                  ps = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                  ps.setString(1, name);
                  ps.setDate(2, date);
                  ps.setString(3, location);
                  ps.executeUpdate();
                  rs = ps.getGeneratedKeys();
                  if (rs.next()) {
                      cusID = rs.getInt(1);
                  }
                  System.out.println("Customer Record inserted");
              }
              finally {
                  rs.close();
                  ps.close();
              }
              return cusID;
          }catch (SQLException e){
              throw  new MyException("Customer Records Submission Unsuccessful");
          }
    }
    
    //Insert AccountInfo to Database
    public void insertAccountToDB(Integer accNo, Integer accBalance, String accBranch, Integer cusId) throws MyException {
        try{
            String query2 = "//insert into AccountInfo (AccNumber, AccBalance, Branch, CusID ) values (?, ?, ?,?)";
            PreparedStatement ps = null;
            try {
                ps = getConnection().prepareStatement(query2);
                ps.setInt(1, accNo);
                ps.setInt(2, accBalance);
                ps.setString(3, accBranch);
                ps.setInt(4, cusId);
                ps.executeUpdate();
                System.out.println("Account Record inserted");
            }finally {
                ps.close();
            }
        } catch (SQLException e) {
           throw new MyException("Account Detail Submission Failed, Query Error");

        }
    }
}