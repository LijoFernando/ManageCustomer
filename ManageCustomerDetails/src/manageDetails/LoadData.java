package manageDetails;

import java.util.ArrayList;
import java.util.HashMap;


public class LoadData {

    HashMap <Integer,HashMap<Integer,AccountInfo>> outerHashMap = null;

    DBOperation dbOperation = null;
    OutputData outputData = new OutputData();


    public void loadHashMap(){
        //load hashMap from DB
        ArrayList<AccountInfo> dbArrayList = new ArrayList<>();
        dbOperation = new DBOperation();
        outerHashMap =new HashMap<>();
        dbArrayList = dbOperation.loadHMapFromDB();
        for (AccountInfo i:dbArrayList) {

            if (outerHashMap.keySet().contains(i.getCusId())) {
                outerHashMap.get(i.getCusId()).put(i.getAccId(),i);
            }
            else
            {
                outerHashMap.put(i.getCusId() , new HashMap<>());
                outerHashMap.get(i.getCusId()).put(i.getAccId(),i);
            }
        }
        System.out.println(outerHashMap.entrySet());
    }

    public void loadSpecific(int cusId)  {
        loadHashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        //System.out.println(outerHashMap.get(cusId).values());
        arrayList.add(outerHashMap.get(cusId).values().toString());
        for (int i = 0; i < arrayList.size(); i++) {
            //System.out.println(i);
          //  System.out.println("("+arrayList.get(i)+")");
        }


    }

    public void printMap(){

    }

}
