package manageDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadData {
    DBOperation dbOperation =  new DBOperation();
    HashMap <Integer, HashMap<Integer,AccountInfo> > outerHashMap = new HashMap<>();

    public String loadHashMap() throws MyException {
        //load hashMap from DB
        ArrayList<AccountInfo> dbArrayList = dbOperation.accountInfoRecords();
        try {
            for (AccountInfo accountinfo : dbArrayList) {
                int cusId = accountinfo.getCusId();
                int accId = accountinfo.getAccNo();
                HashMap<Integer, AccountInfo> innerHashMap = outerHashMap.get(cusId);
                if (innerHashMap == null) {
                    innerHashMap = new HashMap<>();
                    outerHashMap.put(cusId, innerHashMap);
                }
                innerHashMap.put(accId, accountinfo);
            }
            System.out.println(outerHashMap.entrySet());
            return "HashMap Loaded Successfully";
        }
        catch (Exception e) {
            throw new MyException("AccountInfo HashMap not loaded");
        }
    }

    public void loadSpecific(Integer cusId) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(outerHashMap.get(cusId).values().toString());
        System.out.println(arrayList);
    }
}
