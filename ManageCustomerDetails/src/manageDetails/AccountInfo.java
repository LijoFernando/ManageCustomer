package manageDetails;

import java.util.Random;

public class AccountInfo {


    //variables
    private int AccId;
    private int AccNo;
    private int AccBalance;
    private String AccBranch;
    private int CusID;

    public AccountInfo(int accNo,int accBalance,String accBranch, int cusID){

        AccNo = accNo;
        AccBalance = accBalance;
        AccBranch = accBranch;
        CusID = cusID;
    }

    public  AccountInfo(int accId, int accNo,int accBalance,String accBranch,int cusID){
        AccId = accId;
        AccNo = accNo;
        AccBalance = accBalance;
        AccBranch = accBranch;
        CusID = cusID;
    }

    //Getter Setter Methods for Variables
    public int getAccId() {
        return AccId;
    }

    public void setAccId(int accId) {
        AccId = accId;
    }
    public int getAccNo() {
        return AccNo; }

    public void setAccNo(int accNo) {
               AccNo = accNo;
   }

    public int getAccBalance() {
        return AccBalance;
    }

    public void setAccBalance(int accBalance) {
        AccBalance = accBalance;
    }

    public String getAccBranch() {
        return AccBranch;
    }

    public void setAccBranch(String accBranch) {
        AccBranch = accBranch;
    }
    public int getCusid() {
        return CusID;
    }

    public void setCusid(int cusid) {
        CusID = cusid;
    }


}
