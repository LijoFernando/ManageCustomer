package manageDetails;

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
                "\n3.get AccountInfo of customer");

        System.out.print("Enter ur choice: ");
        int choice = input.nextInt();

        if(choice==1) {
             addCustomerDetail.chooseNoOfRecord();
             addAccountInfo.AccountInput();

        }
        else if (choice==2){

        }
        else if(choice==3){
            new LoadData();
            syncHashMap.printMap();
        }
        else if(choice==4){
            System.out.println("Enter id: ");
            int cusid= input.nextInt();
            syncHashMap.loadSpecific(cusid);
        }
        else{
            System.out.println("Enter Valid Choice");
        }

    }
}
