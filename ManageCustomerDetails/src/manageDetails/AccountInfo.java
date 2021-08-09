package manageDetails;

import java.util.Random;

public class AccountInfo {
    //variables
    private int AccNo;
    private int AccBalance;
    private String AccBranch;


    public  AccountInfo(int accNo,int accBalance,String accBranch){
        AccNo = accNo;
        AccBalance = accBalance;
        AccBranch = accBranch;
    }

    //Getter Setter Methods for Variables
    public int getAccNo() {
        return AccNo; }

    public void setAccNo(int accNo) {
        Random random = new Random();

        AccNo = (int) (10001 + Math.random());

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

}
