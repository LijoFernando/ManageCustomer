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

    int count=1;
    public void loadHashMap(){
        HashMap<Integer,HashMap> outerHashMap = dbOperation.loadHMapFromDB();
        //HashMap<Integer,AccountInfo> infoHashMap =
        System.out.println(outerHashMap.get(1));


    }



    public void loadSpecific(int cusId) throws IOException {
        AccountInfo accountInfo = null;
        ArrayList<AccountInfo> arrayList =null;
        if(hashMap2.containsKey(cusId))  {
             for (Integer i : hashMap1.keySet()) {
                    if (cusId == hashMap1.get(i).getCusId()) {
                       // accountInfo = new AccountInfo(hashMap1.get(i).getAccNo(), hashMap1.get(i).getAccBalance(), hashMap1.get(i).getAccBranch());
                        outputData.printSortedAccList(count, accountInfo);
                    }
             }
        }
   }

    public void printMap(){
        for(Integer i:hashMap1.keySet()){
           // accInfo = new AccountInfo(hashMap1.get(i).getAccId(), hashMap1.get(i).getAccNo(),hashMap1.get(i).getAccBalance(),hashMap1.get(i).getAccBranch());
            outputData.printAllAccList(accInfo);
        }
    }

}
