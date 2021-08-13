package manageDetails;

import  java.sql.*;
import java.util.ArrayList;

public class DBOperation {

    private Connection con;

    private void loadConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Root@123");
    }

    public Connection getConnection() throws SQLException {
        if (con == null) {
            loadConnection();
        }
        return con;
    }

    public ArrayList<AccountInfo> accountInfoRecords() throws MyException {
        ArrayList<AccountInfo> accountInfoArray = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM AccountInfo";
        try {
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccountInfo accountInfo = new AccountInfo();
                accountInfo.setAccId(rs.getInt(1));
                accountInfo.setAccNo(rs.getInt(2));
                accountInfo.setAccBalance(rs.getInt(3));
                accountInfo.setAccBranch(rs.getString(4));
                accountInfo.setCusId(rs.getInt(5));
                accountInfoArray.add(accountInfo);
            }
        } catch (SQLException e) {
            throw new MyException("Account HashMap Loading is Unsuccessful,Invalid Query!!");
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                throw new MyException("");
            }
        }
    return accountInfoArray;
    }

    //insert Customer Info to Database
    public int insertDetailToDB (String[] name, Date[] date, String[] location) throws MyException {
              PreparedStatement ps = null;
              ResultSet rs = null;
              String query = "insert into CustomerInfo (CusName, CusDoB, Location) values (?, ?, ?)";
              int cusID = 0;
              try {
                  ps = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                  for (int i = 0; i < name.length; i++) {
                      ps.setString(1, name[i]);
                      ps.setDate(2, date[i]);
                      ps.setString(3, location[i]);
                      ps.executeUpdate();
                  }
                  rs = ps.getGeneratedKeys();
                  if (rs.next()) {
                      cusID = rs.getInt(1);
                  }
                  System.out.println("Customer Record inserted");
              } catch (SQLException e) {
                  throw  new MyException("Customer Records Submission Unsuccessful");
              } catch (Exception e){
                  throw new MyException("Other Exception");
              }
              finally {
                  try {
                      rs.close();
                      ps.close();
                  }
                  catch (SQLException e){
                      throw  new MyException("Customer Records Submission Unsuccessful,PS");
                  }
              }
              return cusID;
    }
    
    //Insert AccountInfo to Database
    public void insertAccountToDB(Integer accNo, Integer accBalance, String accBranch, Integer cusId) throws MyException {
            String query2 = "insert into accountinfo (AccNumber, AccBalance, Branch, CusID ) values (?, ?, ?,?)";
            PreparedStatement ps = null;
            try {
                ps = getConnection().prepareStatement(query2);
                ps.setInt(1, accNo);
                ps.setInt(2, accBalance);
                ps.setString(3, accBranch);
                ps.setInt(4, cusId);
                ps.executeUpdate();
                System.out.println("Account Record inserted");
            } catch (SQLException e) {
                throw new MyException("Account Detail Submission Failed, Query Error");
            } catch (NullPointerException e){
                throw new MyException("Invalid Customer ID");
            }
            finally {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new MyException("Prepared Statement unable to closed");
                }
            }
    }
}