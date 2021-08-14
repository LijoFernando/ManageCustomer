package manageDetails;

import java.sql.Date;
import java.util.Scanner;


public class AddCustomer {
        Scanner input = new Scanner(System.in);
        Customer customerInput = null;
        AddAccountInfo accInfoInput = null;
        DBOperation dbConnection = new DBOperation();
        String[] nameInput;
        Date[] dateInput;
        String[] locationInput;

         public void enterNoOfCustomer() throws MyException {
                System.out.print("Enter No of Record to insert: ");
                int noOfRecord = input.nextInt();
                nameInput = new String[noOfRecord];
                dateInput = new Date[noOfRecord];
                locationInput = new String[noOfRecord];
                for(int i=0; i<noOfRecord; i++){
                        this.customerInput(i);
                }
        }

        private void customerInput(Integer noOfRecords) throws MyException {
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
                    validateInput(name, date, location,noOfRecords);
                } catch(IllegalArgumentException e){
                    throw new MyException("Input format is not valid",e);
                }

        }

        public void validateInput(String name, Date date, String location,Integer nthRecord) throws MyException {
                    customerInput = new Customer();
                    customerInput.setName(name);
                    customerInput.setDofBirth(date);
                    customerInput.setLocation(location);
                    nameInput [nthRecord] =customerInput.getName();
                    dateInput [nthRecord] = customerInput.getDofBirth();
                    locationInput [nthRecord] = customerInput.getLocation();
                    // if (nthRecord == (name.length())) {
                    int[] cusID = dbConnection.insertDetailToDB(nameInput, dateInput, locationInput);
                    // accInfoInput = new AddAccountInfo();
                    // accInfoInput.AccountInput(cusID);
                    // }
        }
}

