package manageDetails;

import java.util.Scanner;

public class AddAccountInfo {
    Scanner input = new Scanner(System.in);
    AccountInfo accountInfoInput = new AccountInfo();
    DBConnection dbConnection = new DBConnection();
    void findCusId(){

    }
    void AccountInput( ){
        System.out.println("Enter the Account  Number: ");
        int accNumber = input.nextInt();
        System.out.println("Enter the Accoount Balance: ");
        int accBalance = input.nextInt();
        input.nextLine();
        System.out.println("Enter the Branch Name: ");
        String accBranch = input.nextLine();
        insertAccountoDB(accNumber, accBalance, accBranch);

    }
    void insertAccountoDB(Integer accNumber, Integer accBalance, String accBranch){
        if(accNumber!=null && accBalance !=null && accBranch!=null){
            accountInfoInput.setAccNo(accNumber);
            accountInfoInput.setAccBalance(accBalance);
            accountInfoInput.setAccBranch(accBranch);
            int accNoGet = accountInfoInput.getAccNo();
            int accBalanceGet = accountInfoInput.getAccBalance();
            String accBranchGet = accountInfoInput.getAccBranch();
            //dbConnection.insertAccountToDB(accNoGet, accBalanceGet, accBranchGet);


        }

    }

}
