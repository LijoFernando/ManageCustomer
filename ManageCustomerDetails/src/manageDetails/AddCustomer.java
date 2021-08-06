package manageDetails;

import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;


public class AddCustomer {
        Scanner input=new Scanner(System.in);
        Customer customerInput = new Customer();
        AddAccountInfo accInfoInput = new AddAccountInfo();
        DBConnection dbConnection = new DBConnection();

        void chooseNoOfRecord(){
            System.out.print("Enter No of Record to insert: ");
            int noOfRecord=input.nextInt();
            for(int i=0; i<noOfRecord; i++){
                this.customerInput();
            }
        }
        void customerInput(){

            //customerInput.setDofBirth(inputDate);
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
            }
            catch (IOException ioException){
                System.out.println("Exception");
                ioException.printStackTrace();
            }

        }
        void validateInput(String name, Date date, String location) throws IOException {

                if (name != null && date != null  && location != null) {

                    customerInput.setName(name);
                    customerInput.setDofBirth(date);
                    customerInput.setLocation(location);
                    String nameInput = customerInput.getName();
                    Date dateInput = customerInput.getDofBirth();
                    String locationInput = customerInput.getLocation();
                    accInfoInput.AccountInput();
                    try {
                        dbConnection.insertDetailToDB(nameInput, dateInput, locationInput);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Enter all the field");
                }

        }

}
