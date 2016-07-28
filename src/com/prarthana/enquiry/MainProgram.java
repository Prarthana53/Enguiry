/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.enquiry;

import com.prarthana.enquiry.dao.EnquiryDAO;
import com.prarthana.enquiry.dao.impl.EnquiryDAOImpl;
import com.prarthana.enquiry.enq.Enquiry;
import java.util.Scanner;

/**
 *
 * @author prarthanapradhan
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
       EnquiryDAO enquiryDAO = new EnquiryDAOImpl();
        Scanner input = new Scanner(System.in);
        boolean yn = true;
        
        
       while(true){
           System.out.println("ENQUIRY MANAGEMENT SYSTEM");
           System.out.println("1. Enter new Enquiry");
           System.out.println("2. Delete Enquiry");           
           System.out.println("3. Show All Enquiries");
           System.out.println("4. Search for Enquiry");
           System.out.println("5. Exit");
           System.out.print("Enter your choice[1-5] : ");
           
           switch (input.nextInt()) {

                case 1:
                    System.out.println("ADD an Enquiry");
                    Enquiry e = new Enquiry();
                    yn = true;
                    while (yn) {
                        System.out.print("Enter Enquiry ID : ");
                        e.setId(input.nextInt());
                        System.out.print("Enter Enquiry Type : ");
                        e.setType(input.next());
                        System.out.print("Enter Description of Enquiry : ");
                        e.setDescription(input.next());
                        System.out.print("Enter Date : ");
                        e.setDate(input.next());
                        System.out.print("Enter status : ");
                        e.setStatus(input.nextBoolean());

                        if (enquiryDAO.insert(e)) {
                            System.out.println("Inserted Successfully!");
                        } else {
                            System.out.println("Data Full!");
                        }
                        System.out.print("Add Another Enquiry?[Y/N] : ");
                        if (input.next().equalsIgnoreCase("n")) {
                            yn = false;
                        }
                        System.out.println("");
                    }

                    break;

                case 2:
                    System.out.println("Delete an Enquiry");
                    yn = true;
                    while (yn) {
                        System.out.print("Enter Enquiry Id to Delete : ");
                        if (enquiryDAO.delete(input.nextInt())) {
                            System.out.println("Enquiry deleted successfully.");
                        } else {
                            System.out.println("Sorry! Enquiry ID does not exist.");
                        }
                        System.out.println("Remove Another Enquiry? [Y/N] : ");
                        if (input.next().equalsIgnoreCase("N")) {
                            yn = false;
                        }
                        System.out.println("");
                    }
                    break;

                case 3:
                    System.out.println("Show All Enquirires");
                    System.out.println("====================");
                    Enquiry[] enquiries = enquiryDAO.getAll();
                    for (int i = 0; i < enquiries.length; i++) {
                        Enquiry enquiry = enquiries[i];
                        if (enquiry != null) {
                            System.out.println("Enquiry ID : " + enquiry.getId());
                            System.out.println("Enquiry Type: " + enquiry.getType());
                            System.out.println("Desciption : " + enquiry.getDescription());
                            System.out.println("Date : " + enquiry.getDate() );
                            System.out.println("Status : " + enquiry.isStatus());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Search for an Enquiry");
                    yn = true;
                    while (yn) {
                        System.out.print("Enter Enquiry Type to Search : ");
                        Enquiry enquiry = enquiryDAO.getByName(input.next());
                        if (enquiry != null) {
                            System.out.println("ID : " + enquiry.getId());
                            System.out.println("Type: " + enquiry.getType());
                            System.out.println("Desciption : " + enquiry.getDescription());
                            System.out.println("Date : " + enquiry.getDate() );
                            System.out.println("Status : " + enquiry.isStatus());
                        } else {
                            System.out.println("Enquiry could not be found.");
                        }
                        System.out.println("Continue Search?[Y/N] : ");
                        if (input.next().equalsIgnoreCase("N")) {
                            yn = false;
                        }
                    }
                    System.out.println("");
                    break;

                case 5:
                    System.out.print("Do you really want to Exit?[Y/N] : ");
                    if (input.next().equalsIgnoreCase("Y")) {
                        System.out.println("Thankyou, visit again.");
                        System.exit(0);
                    }
                    break;
            }
           
       }
    }
    
}