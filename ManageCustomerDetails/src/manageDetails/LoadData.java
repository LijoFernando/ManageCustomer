package manageDetails;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class LoadData {
    HashMap<Integer, AccountInfo> hashMap1 = new HashMap<>();
    HashMap<Integer,HashMap<Integer,AccountInfo>> hashMap2= new HashMap<>();
    ArrayList<AccountInfo> outputAryList = new ArrayList();
    DBOperation dbOperation = new DBOperation();
    OutputData outputData = new OutputData();
    AccountInfo accInfo;
    ResultSet rs = dbOperation.loadHMapFromDB();
    int count=1;
    public void chkDatabase(){

    }

    public LoadData(){
       try {
            while (rs.next()) {
                int accId =rs.getInt("AccId");
                int accNo =rs.getInt("AccNumber");
                int accBalance =rs.getInt("AccBalance");
                String accBranch =rs.getString("Branch");
                int cusId=rs.getInt("CusID");
                accInfo = new AccountInfo(accId, accNo, accBalance, accBranch, cusId);
                hashMap1.put(accId,accInfo);
                hashMap2.put(cusId,hashMap1);
            }
       } catch (SQLException e) {
            e.printStackTrace();
       }
    }

    public void loadSpecific(int cusId) throws IOException {
        AccountInfo accountInfo = null;
        ArrayList<AccountInfo> arrayList =null;
        if(hashMap2.containsKey(cusId))  {
             for (Integer i : hashMap1.keySet()) {
                    if (cusId == hashMap1.get(i).getCusId()) {
                        accountInfo = new AccountInfo(hashMap1.get(i).getAccNo(), hashMap1.get(i).getAccBalance(), hashMap1.get(i).getAccBranch());
                        outputData.printSortedAccList(count, accountInfo);
                    }
             }
        }
   }

    public void printMap(){
        for(Integer i:hashMap1.keySet()){
            accInfo = new AccountInfo(hashMap1.get(i).getAccId(), hashMap1.get(i).getAccNo(),hashMap1.get(i).getAccBalance(),hashMap1.get(i).getAccBranch());
            outputData.printAllAccList(accInfo);
        }
    }

}
