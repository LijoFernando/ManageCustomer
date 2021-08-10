package manageDetails;

import java.util.Scanner;

public class AddAccountInfo {
    Scanner input = new Scanner(System.in);
    AccountInfo accountInfoInput = new AccountInfo();
    DBOperation dbConnection = new DBOperation();

    void  AccountInput(Integer cusID ){
        System.out.println("Enter the Account  Number: ");
        int accNumber = input.nextInt();
        System.out.println("Enter the Accoount Balance: ");
        int accBalance = input.nextInt();
        input.nextLine();
        System.out.println("Enter the Branch Name: ");
        String accBranch = input.nextLine();
        System.out.println(accNumber+", "+accBalance +", "+ accBranch+", "+cusID);
        insertAccountDB(accNumber, accBalance,  accBranch, cusID);
    }

    void insertAccountDB(Integer accNumber, Integer accBalance, String accBranch, Integer cusId)  {
        if(accNumber!=null && accBalance !=null && accBranch!=null){
            accountInfoInput.setAccNo(accNumber);
            accountInfoInput.setAccBalance(accBalance);
            accountInfoInput.setAccBranch(accBranch);
            accountInfoInput.setCusId(cusId);
            int accNoGet = accountInfoInput.getAccNo();
            int accBalanceGet = accountInfoInput.getAccBalance();
            String accBranchGet = accountInfoInput.getAccBranch();
            int accCusIdGet = accountInfoInput.getCusId();
            try {
                System.out.println(accNumber+", "+accBalance +", "+ accBranch+", "+cusId);
               dbConnection.insertAccountToDB(accNoGet, accBalanceGet, accBranchGet,accCusIdGet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
