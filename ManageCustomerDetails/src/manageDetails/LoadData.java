package manageDetails;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LoadData {
    HashMap<Integer, AccountInfo> hMap1 = new HashMap<>();
    HashMap<Integer,HashMap<Integer,AccountInfo>> hm2= new HashMap<>();
    DBOperation dbOperation = new DBOperation();
    AccountInfo accInfo;
    ResultSet rs = dbOperation.loadHMapFromDB();


    public LoadData(){
       try {
            while (rs.next()) {
                int accId =rs.getInt("AccId");
                int accNo =rs.getInt("AccNumber");
                int accBalance =rs.getInt("AccBalance");
                String accBranch =rs.getString("Branch");
                int cusId=rs.getInt("CusID");
                accInfo = new AccountInfo(accId, accNo, accBalance, accBranch, cusId);
                hMap1.put(accId,accInfo);
                //if(){

                //}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadSpecific(int cusId) {
        try {
            for (Integer i : hMap1.keySet()) {

                if (cusId == hMap1.get(i).getCusid()) {
                    System.out.println(hMap1.get(i).getAccNo() + " : " + hMap1.get(i).getAccBalance() + " : " + hMap1.get(i).getAccBranch());
                }
            }

        }catch (Exception e){

        }
    }

    public void printMap(){
        for(Integer i:hMap1.keySet()){
            accInfo = hMap1.get(i);
            System.out.println("Account ID: "+accInfo.getAccId()+" Account Details: "+accInfo.getAccNo()
                    +" , "+ accInfo.getAccBalance()+" , "+accInfo.getAccBranch()+" , "+accInfo.getCusid());
        }
    }

}
