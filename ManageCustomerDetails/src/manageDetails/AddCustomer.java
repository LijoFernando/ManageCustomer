package manageDetails;


import java.io.IOException;
import java.sql.Date;

import java.util.Scanner;

public class AddCustomer {
        Scanner input=new Scanner(System.in);
        Customer customerInput = new Customer();


        void customerInput(){
            System.out.println("Enter Customer Details");
            System.out.print("Enter Customer Name: ");
            String name=input.nextLine();
            System.out.print("Enter Customer Date of Birth(example: 2000-12-3): ");
            String dateOfBirth=input.nextLine();

            //customerInput.setDofBirth(inputDate);
            try {
                validateInput(name, dateOfBirth);
            }

            catch (IOException ioException){
                System.out.println("Exception");
                ioException.printStackTrace();

            }

        }
        void validateInput(String name, String dateOfBirth) throws IOException {

                if (name != null && dateOfBirth != null && dateOfBirth.matches("^[0-9]{4}-[0-3][0-9]-[0-3][0-9]$")) {
                    Date inputDate = Date.valueOf(dateOfBirth);
                    customerInput.setName(name);
                    customerInput.setDofBirth(inputDate);
                    insertCustomer(name, inputDate);
                }



        }
        void insertCustomer(String name,Date inputDate){
            System.out.println(customerInput.getId());
            System.out.println(customerInput.getName());
            System.out.println(customerInput.getDofBirth());
        }
}
