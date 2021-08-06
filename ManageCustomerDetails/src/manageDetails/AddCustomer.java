package manageDetails;

import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;

public class AddCustomer {
        Scanner input=new Scanner(System.in);
        Customer customerInput = new Customer();
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
                validateInput(name, dateOfBirth);
            }
            catch (IOException ioException){
                System.out.println("Exception");
                ioException.printStackTrace();
            }

        }
        void validateInput(String name, String dateOfBirth) throws IOException {

                if (name != null && dateOfBirth != null && dateOfBirth.matches("^[0-9]{4}-[0-3][0-9]-[0-3][0-9]$")) {
                    Date date = Date.valueOf(dateOfBirth);
                    customerInput.setName(name);
                    customerInput.setDofBirth(date);
                    insertCustomer(name, date);
                }



        }
        void insertCustomer(String name,Date date){
            dbConnection.insertDetailToDB(name, date);
        }
}
