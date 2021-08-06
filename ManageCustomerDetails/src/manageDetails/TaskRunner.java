package manageDetails;

import java.util.Scanner;

public class TaskRunner {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Select from (1-3)" +
                "\n1.Add new Customer. " +
                "\n2.Add AccountInfo for Existing Customer. " +
                "\n3.get AccountInfo of customer");
        System.out.print("Enter ur choice: ");
        int choice = input.nextInt();
        if(choice==1) {
            AddCustomer addCustomerDetail = new AddCustomer();
            addCustomerDetail.chooseNoOfRecord();
        }
        else if (choice==2){

        }

    }
}
