package manageDetails;

import java.io.IOException;
import java.util.Scanner;

public class TaskRunner {
    public static void main(String[] args) throws IOException {

        Scanner input=new Scanner(System.in);
        AddCustomer addCustomerDetail = new AddCustomer();
        AddAccountInfo addAccountInfo = new AddAccountInfo();
        LoadData syncHashMap= new LoadData();

        System.out.println("Select from (1-3)" +
                "\n1.Add new Customer. " +
                "\n2.Add AccountInfo for Existing Customer. " +
                "\n3.get AccountInfo of customer");

        System.out.print("Enter ur choice: ");
        int choice = input.nextInt();

        if(choice==1) {
             addCustomerDetail.enterNoOfCustomer();


        }
        else if (choice==2){

        }
        else if(choice==3){

        }
        else if(choice==4){
            System.out.println("Enter id: ");
            int cusId= input.nextInt();
          syncHashMap.loadSpecific(cusId);
        }
        else{
            System.out.println("Enter Valid Choice");
        }

    }
}
