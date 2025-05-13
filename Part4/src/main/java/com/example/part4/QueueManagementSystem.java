package com.example.part4;

import java.util.Scanner;
public class QueueManagementSystem {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("-------------------------------Foodies Fave Queue Management System.--------------------------------");
        System.out.println("\n");

        FoodQueue myObj = new FoodQueue();
        myObj.Queues();

        QueueManagementController myObj2 = new QueueManagementController();

        while (true) {
            System.out.println("\n");

            System.out.println("||============================================================||");
            System.out.println("||                          MENU                              ||");
            System.out.println("||============================================================||");
            System.out.println("||  100 or VFQ: View all Queues.                              ||");
            System.out.println("||  101 or VEQ: View all Empty Queues.                        ||");
            System.out.println("||  102 or ACQ: Add customer to a Queue.                      ||");
            System.out.println("||  103 or RCQ: Remove a customer from a Queue.               ||");
            System.out.println("||  104 or PCQ: Remove a served customer.                     ||");
            System.out.println("||  105 or VCS: View Customers Sorted in alphabetical order.  ||");
            System.out.println("||  106 or SPD: Store Program Data into file.                 ||");
            System.out.println("||  107 or LPD: Load Program Data from file.                  ||");
            System.out.println("||  108 or STK: View Remaining burgers Stock.                 ||");
            System.out.println("||  109 or AFS: Add burgers to Stock.                         ||");
            System.out.println("||  110 or IFQ: View Income of Each Queue.                    ||");
            System.out.println("||  111 or DWQ: Display Waiting Queue.                        ||");
            System.out.println("||  112 or GUI: Graphical User Interface.                     ||");
            System.out.println("||  999 or EXT: Exit the Program.                             ||");
            System.out.println("||============================================================||");

            System.out.println("\n");

            myObj.PrintWarningMessage();

            Scanner input = new Scanner(System.in);

            System.out.print("Enter what you want to do: ");
            String task = input.next().toLowerCase();

            //Enhanced swich case to call all methods
            switch (task) {
                case "100", "vfq" -> myObj.ViewAllQueues();
                case "101", "veq" -> myObj.ViewEmptyQueues();
                case "102", "acq" -> myObj.AddCustomer();
                case "103", "rcq" -> myObj. RemoveCustomer();
                case "104", "pcq" -> myObj.RemoveServedCustomer();
                case "105", "vcs" -> myObj.ViewCustomers();
                case "106", "spd" -> myObj.AddDataToFile();
                case "107", "lpd" -> myObj.ReadFileData();
                case "108", "stk" -> myObj.ViewBurgerCount();
                case "109", "afs" -> myObj.AddBurgers();
                case "110", "ifq" -> myObj.CalculateTheIncome();
                case "111", "dwq" -> myObj.DisplayWaitingQueue();
                case "112", "gui" -> myObj2.Prompt();
                case "999", "ext" -> System.exit(0);
                default -> System.out.println("Wrong Input");
            }


        }



    }
}