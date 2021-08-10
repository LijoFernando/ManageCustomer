package manageDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskRunner {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        AddCustomer addCustomerDetail = new AddCustomer();
        AddAccountInfo addAccountInfo = new AddAccountInfo();
        LoadData syncHashMap= new LoadData();

        System.out.println("Select from (1-3)" +
                "\n1.Add new Customer. " +
                    "\n2.Add AccountInfo for Existing Customer. " +
                        "\n3.get AccountInfo of customers"+
                            "\n4.get AccountInfo for Specific ID");

        System.out.print("Enter ur choice: ");
        int choice = input.nextInt();

        if(choice==1) {
             addCustomerDetail.chooseNoOfRecord();
          // addAccountInfo.AccountInput();

        }
        else if (choice==2){
            System.out.println("Enter CusID");
            int cusId= input.nextInt();
            addAccountInfo.AccountInput(cusId);
        }
        else if(choice==3){
            syncHashMap.loadHashMap();



        }
        else if(choice==4) {
            System.out.println("Enter id: ");
            String msg="";
            int cusid = input.nextInt();

            try {
                syncHashMap.loadSpecific(cusid);

            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Customer ID not Found"+e);
                System.out.println(msg);
            }

        }
        else{
            System.out.println("Enter Valid Choice");
        }

    }
}
