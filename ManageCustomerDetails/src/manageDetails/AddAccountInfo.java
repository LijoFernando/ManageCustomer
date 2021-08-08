package manageDetails;

import java.sql.SQLException;
import java.util.Scanner;

public class AddAccountInfo {
    Scanner input = new Scanner(System.in);
    AccountInfo accountInfoInput = new AccountInfo();
    DBOperation dbOperation = new DBOperation();

    void findCusId(){
    }

    void AccountInput( ){
        System.out.println("Enter the Account  Number: ");
        int accNumber = input.nextInt();
        System.out.println("Enter the Account Balance: ");
        int accBalance = input.nextInt();input.nextLine();
        System.out.println("Enter the Branch Name: ");
        String accBranch = input.nextLine();
        insertAccountDB(accNumber, accBalance, accBranch);

    }
    void insertAccountDB(Integer accNumber, Integer accBalance, String accBranch)  {
        try {
            if (accNumber != null && accBalance != null && accBranch != null) {
                accountInfoInput.setAccNo(accNumber);
                accountInfoInput.setAccBalance(accBalance);
                accountInfoInput.setAccBranch(accBranch);
                int accNoInput = accountInfoInput.getAccNo();
                int accBalanceInput = accountInfoInput.getAccBalance();
                String accBranchInput = accountInfoInput.getAccBranch();
                dbOperation.insertAccountToDB(accNoInput, accBalanceInput, accBranchInput);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
