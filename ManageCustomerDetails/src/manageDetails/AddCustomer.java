package manageDetails;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class AddCustomer {
        Scanner input = new Scanner(System.in);
        Customer customerInput = null;
        AddAccountInfo accInfoInput = null;
        DBOperation dbConnection = new DBOperation();

        public void enterNoOfCustomer() throws MyException {
            System.out.print("Enter No of Record to insert: ");
            int noOfRecord = input.nextInt();
            for(int i=0; i<noOfRecord; i++){
                this.customerInput();
            }
        }

        private void customerInput() throws MyException {
                try {
                    System.out.println("Enter Customer Details");
                    System.out.println("Enter Customer Name: ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.println("Enter Customer Date of Birth(example: 2000-12-3): ");
                    String dateOfBirth = input.nextLine();
                    Date date = Date.valueOf(dateOfBirth);
                    System.out.println("Enter Customer Location: ");
                    String location = input.nextLine();
                    validateInput(name, date, location);
                } catch(IllegalArgumentException e){
                    throw  new MyException("Input format is not valid",e);
                }

        }

        private void validateInput(String name, Date date, String location) throws MyException {
                if (name != null && date != null  && location != null ) {
                    customerInput = new Customer();
                    customerInput.setName(name);
                    customerInput.setDofBirth(date);
                    customerInput.setLocation(location);
                    String nameInput = customerInput.getName();
                    Date dateInput = customerInput.getDofBirth();
                    String locationInput = customerInput.getLocation();
                    try {
                        int cusID = dbConnection.insertDetailToDB(nameInput, dateInput, locationInput);
                        accInfoInput = new AddAccountInfo();
                        accInfoInput.AccountInput(cusID);

                    }   catch (SQLException  e){
                        throw new MyException("DB Not inserted",e);
                    }
                }
                else {
                    System.out.println("Enter all the field");
                }
        }
}
