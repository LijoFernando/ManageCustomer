package manageDetails;

import java.sql.SQLException;
import java.util.Scanner;

public class AddAccountInfo {
    Scanner input = new Scanner(System.in);
    AccountInfo accountInfoInput = null;
    DBOperation dbConnection = new DBOperation();

    void AccountInput( ){
        System.out.println("Enter the Account  Number: ");
        int accNumber = input.nextInt();
        System.out.println("Enter the Accoount Balance: ");
        int accBalance = input.nextInt();
        input.nextLine();
        System.out.println("Enter the Branch Name: ");
        String accBranch = input.nextLine();

        //insertAccountoDB(accNumber, accBalance, accBranch);

    }
    void insertAccountoDB(Integer accNumber, Integer accBalance, String accBranch,Integer cusId)  {
        if(accNumber!=null && accBalance !=null && accBranch!=null){
            accountInfoInput.setAccNo(accNumber);
            accountInfoInput.setAccBalance(accBalance);
            accountInfoInput.setAccBranch(accBranch);
            accountInfoInput.setCusid(cusId);
            int accNoGet = accountInfoInput.getAccNo();
            int accBalanceGet = accountInfoInput.getAccBalance();
            String accBranchGet = accountInfoInput.getAccBranch();
            int cusID = accountInfoInput.getCusid();
            try {
                dbConnection.insertAccountToDB(accNoGet, accBalanceGet, accBranchGet,cusID);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

}
