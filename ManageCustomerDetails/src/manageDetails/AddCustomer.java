package manageDetails;

import java.sql.Date;
import java.util.*;

public class AddCustomer {
        Scanner input = new Scanner(System.in);
        Customer customerInput = new Customer();
        DBOperation dbOperation = new DBOperation();

        void chooseNoOfRecord(){
            System.out.print("Enter No of Record to insert: ");
            int noOfRecord = input.nextInt();
            for(int i=0; i<noOfRecord; i++){
                this.customerInput();
            }
        }

        void customerInput(){
            //customerInput.setDofBirth(inputDate);

                System.out.println("Enter Customer Details");
                System.out.println("Enter Customer Name: ");
                input.nextLine();
                String name = input.nextLine();
                System.out.println("Enter Customer Date of Birth(example: 2000-12-3): ");
                String dateOfBirth = input.nextLine();
                System.out.println("Enter the location: ");
                String location = input.nextLine();
                validateInput(name, dateOfBirth,location );


        }

        void validateInput(String name, String dateOfBirth, String location) {
                if(name != null && dateOfBirth != null
                        && dateOfBirth.matches("^[0-9]{4}-[0-3][0-9]-[0-3][0-9]$")) {
                    try {
                    Date date = Date.valueOf(dateOfBirth);
                    customerInput.setName(name);
                    customerInput.setDofBirth(date);
                    customerInput.setLocation(location);
                    String inputName = customerInput.getName();
                    Date inputDate = customerInput.getDofBirth();
                    String inputLocation = customerInput.getLocation();
                    dbOperation.insertDetailToDB(inputName, inputDate, inputLocation);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("SQL Exception Occurs :" + e);


                    }
                }

        }
}
