package com.example.part4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FoodQueue {

    static Customer[][] Cashier = new Customer[3][]; //2D array for all the cashiers

    static Customer[] WaitingQueue = new Customer[5]; // Making Arraylist for waiting Queue
    static int FirstFlag = 0; //define the first one of the array
    static int LastFlag = 0; //define the first last of the array
    static int BurgerStock = 50; //define the burger stock
    static int SoldBurgers = 0; //counting the sold burgers

    static int Queue1BurgerCount = 0; //counting burger count for cashier 1
    static int Queue2BurgerCount = 0; //counting burger count for cashier 2
    static int Queue3BurgerCount = 0; //counting burger count for cashier 3


    //define the size for queues
    public void Queues(){
        Cashier[0] = new Customer[2];
        Cashier[1] = new Customer[3];
        Cashier[2] = new Customer[5];

    }




    //method to view all queues
    public static void ViewAllQueues() {
        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");

        for (int i = 0; i < 5; i++) { //check the customer
            for (int j = 0; j < Cashier.length; j++) { // check the cashier
                if (i < Cashier[j].length) {
                    if (Cashier[j][i] == null) {
                        System.out.print(" X    ");
                    } else {
                        System.out.print(" O    ");
                    }
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
        }
        System.out.println("0-Occupied X-Notoccupied");
    }

    //method for view empty queues
    public void ViewEmptyQueues(){
        // boolean variables for check the cashiers contains null values
        boolean ContainsNullLine1 = false;
        boolean ContainsNullLine2 = false;
        boolean ContainsNullLine3 = false;

        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");

        for (Customer element : Cashier[0]) {
            if (element == null) {
                ContainsNullLine1 = true;
                break;
            }
        }

        for (Customer element : Cashier[1]) {
            if (element == null) {
                ContainsNullLine2 = true;
                break;
            }
        }

        for (Customer element : Cashier[2]) {
            if (element == null) {
                ContainsNullLine3 = true;
                break;
            }
        }

        if(ContainsNullLine1 && ContainsNullLine2 && ContainsNullLine3) {
            System.out.printf("%2s %5s %6s %n", Cashier[0][0] != null ? "o" : "x", Cashier[1][0] != null ? "o" : "x", Cashier[2][0] != null ? "o" : "x");
            System.out.printf("%2s %5s %6s %n", Cashier[0][1] != null ? "o" : "x", Cashier[1][1] != null ? "o" : "x", Cashier[2][1] != null ? "o" : "x");
            System.out.printf("%8s %6s %n", Cashier[1][2] != null ? "o" : "x", Cashier[2][2] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][3] != null ? "o" : "x");
        } else if (ContainsNullLine1 && ContainsNullLine2) {
            System.out.printf("%2s %5s %n", Cashier[0][0] != null ? "o" : "x", Cashier[1][0] != null ? "o" : "x");
            System.out.printf("%2s %5s %n", Cashier[0][1] != null ? "o" : "x", Cashier[1][1] != null ? "o" : "x");
            System.out.printf("%8s %n", Cashier[1][2] != null ? "o" : "x");
        } else if (ContainsNullLine1 && ContainsNullLine3){
            System.out.printf("%2s %12s %n", Cashier[0][0] != null ? "o" : "x", Cashier[2][0] != null ? "o" : "x");
            System.out.printf("%2s %12s %n", Cashier[0][1] != null ? "o" : "x", Cashier[2][1] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][2] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][3] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][4] != null ? "o" : "x");
        } else if (ContainsNullLine2 && ContainsNullLine3) {
            System.out.printf("%8s %6s %n",Cashier[1][0] != null ? "o" : "x",Cashier[2][0]!= null ? "o" : "x");
            System.out.printf("%8s %6s %n",Cashier[1][1]!= null ? "o" : "x",Cashier[2][1]!= null ? "o" : "x");
            System.out.printf("%8s %6s %n",Cashier[1][2]!= null ? "o" : "x",Cashier[2][2]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][3]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][4]!= null ? "o" : "x");
        } else if (ContainsNullLine1) {
            System.out.printf("%2s %n",Cashier[0][0]!= null ? "o" : "x");
            System.out.printf("%2s %n",Cashier[0][1]!= null ? "o" : "x");
        } else if (ContainsNullLine2) {
            System.out.printf("%8s %n",Cashier[1][0]!= null ? "o" : "x");
            System.out.printf("%8s %n",Cashier[1][1]!= null ? "o" : "x");
            System.out.printf("%8s %n",Cashier[1][2]!= null ? "o" : "x");
        }else {
            System.out.printf("%15s %n",Cashier[2][0]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][1]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][2]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][3]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][4]!= null ? "o" : "x");
        }
        System.out.println("0-Occupied X-Notoccupied");
    }

    //method for check the queue length
    /*
    * param1 Queue - use to get the cashier number for checking
    */
    public static int CheckQueueLength(int Queue){
        int Counter = 0; //variable for get the customer count

        if(Queue == 1){
            for (int i = 0; i < 2; i++){
                if(Cashier[0][i] != null){
                    Counter += 1;
                }
            }
        }

        if(Queue == 2){
            for (int i = 0; i < 3; i++){
                if(Cashier[1][i] != null){
                    Counter += 1;
                }
            }
        }

        if(Queue == 3){
            for (int i = 0; i < 5; i++){
                if(Cashier[2][i] != null){
                    Counter += 1;
                }
            }
        }

        if(Queue == 4){  //Checking customer count in WaitingQueue
            for (int i = 0; i < 5; i++){
                if(WaitingQueue[i] != null){
                    Counter += 1;
                }
            }
        }

        return Counter;
    }

    //method to find the smallest queue
    public static int FindTheSmallestQueue() {
        int SmallestQueue =0;
        int Queue1Length = CheckQueueLength(1); //checking the queue length using CheckQueueLength method according to the queue
        int Queue2Length = CheckQueueLength(2);
        int Queue3Length = CheckQueueLength(3);

        if(Queue1Length !=2 || Queue2Length != 3 || Queue3Length != 5) { // check the queues are full or not
            if (Queue1Length <= Queue2Length && Queue1Length <= Queue3Length && Queue1Length != 2) {
                SmallestQueue = 1;
            } else if (Queue2Length <= Queue1Length && Queue2Length <= Queue3Length && Queue2Length != 3) {
                SmallestQueue = 2;
            } else {
                SmallestQueue = 3;
            }
        }else {
            System.out.println("Queues are Full please wait");
        }

        return SmallestQueue;
    }

    //method for add customers
    public static void AddCustomer(){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Customer's First name : ");
        String FirstName = input.next(); // get the customers first name by user


        System.out.print("Enter Customer's Last name : ");
        String LastName = input.next();// get the customers last name by user

        // validating the burger count as an integer
        int BurgersRequired = 0;
        boolean ValidInput = false;
        while (!ValidInput) {
            System.out.print("Enter how many Burgers required: ");
            if (input.hasNextInt()) {
                BurgersRequired = input.nextInt(); // get the customers required burger count by user
                ValidInput = true;
            } else {
                System.out.println("Wrong input. Please enter a valid integer.");
                input.next(); // Clear the invalid input from the scanner
            }
        }

        Customer Person = new Customer(FirstName, LastName, BurgersRequired); //creating object to save customer names

        if (CheckQueueLength(1) == 2 && CheckQueueLength(2) == 3 && CheckQueueLength(3) == 5){ // check the queues are full
            if (CheckQueueLength(4) != 5) {

                if (WaitingQueue[LastFlag] == null) {
                        WaitingQueue[LastFlag] = Person; //add customer to the waiting queue
                        System.out.println("\nCustomer Added to Waiting list\n");
                        if (LastFlag != 4){
                            LastFlag += 1;
                        }else {
                            LastFlag = 0;
                        }

                }

            }else {
                System.out.println("Waiting list is full Please wait");
            }
        }

        int SmallestQueue = FindTheSmallestQueue(); //run FindTheSmallestQueue method and find the smallest queue

        if (SmallestQueue == 1) {
            Queue1BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[0].length; i++) {
                if (Cashier[0][i] == null) {
                    Cashier[0][i] = Person; //adding the customer details into queue 1
                    break;
                }
            }
        } else if (SmallestQueue == 2) {
            Queue2BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[1].length; i++) {
                if (Cashier[1][i] == null) {
                    Cashier[1][i] = Person; //adding the customer details into queue 2
                    break;
                }
            }
        } else {
            Queue3BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[2].length; i++) {
                if (Cashier[2][i] == null) {
                    Cashier[2][i] = Person; //adding the customer details into queue 3
                    break;
                }
            }
        }


        ViewAllQueues(); //run ViewAllQueues method to show customer is added

    }

    // method to remove a customer in a specific location
    public static void RemoveCustomer(){
        try {

            Scanner input2 = new Scanner(System.in);
            int WhichQueue;
            int WhichOne;
            // looping until get correct input
            do {

                System.out.print("Enter the Queue to remove the customer (1,2 or 3):");
                WhichQueue = input2.nextInt(); //asking queue to remove customer

                if (WhichQueue > 3 || WhichQueue < 1) {
                    System.out.println("Invalid Input");
                }

            } while (WhichQueue > 3 || WhichQueue < 1);


            if (WhichQueue == 1) {

                // looping until get correct input
                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt(); //asking which customer want to remove

                    if (WhichOne < 1 || WhichOne > Cashier[0].length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > Cashier[0].length);

                if (Cashier[0][WhichOne - 1] != null) {
                    for (int i = WhichOne - 1; i < 1; i++) {
                        Cashier[0][i] = Cashier[0][i + 1]; //shifting the elements of cashier

                    }
                    Cashier[0][1] = WaitingQueue[FirstFlag];
                    WaitingQueue[FirstFlag] = null;
                    if (FirstFlag != 4) {
                        FirstFlag += 1;
                    }else {
                        FirstFlag = 0;
                    }
                }else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                    System.out.println("\n");
                }


            } else if (WhichQueue == 2) {
                // looping until get correct input
                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt(); //asking which customer want to remove

                    if (WhichOne < 1 || WhichOne > Cashier[1].length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > Cashier[1].length);

                if (Cashier[1][WhichOne - 1] != null) {
                    for (int i = WhichOne - 1; i < 2; i++) {
                        Cashier[1][i] = Cashier[1][i + 1]; //shifting the elements of cashier

                    }
                    Cashier[1][2] = WaitingQueue[FirstFlag];
                    WaitingQueue[FirstFlag] = null;
                    if (FirstFlag != 4) {
                        FirstFlag += 1;
                    }else {
                        FirstFlag = 0;
                    }
                }else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                    System.out.println("\n");
                }


            } else {

                // looping until get correct input
                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt(); //asking which customer want to remove

                    if (WhichOne < 1 || WhichOne > Cashier[2].length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > Cashier[2].length);

                if (Cashier[2][WhichOne - 1] != null) {
                    for (int i = WhichOne - 1; i < 4; i++) {
                        Cashier[2][i] = Cashier[2][i + 1]; //shifting the elements of cashier

                    }
                    Cashier[2][4] = WaitingQueue[FirstFlag];
                    WaitingQueue[FirstFlag] = null;
                    if (FirstFlag != 4) {
                        FirstFlag += 1;
                    }else {
                        FirstFlag = 0;
                    }
                }else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                    System.out.println("\n");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Wrong input");
        }

        ViewAllQueues(); //run ViewAllQueues method to show customer was removed
    }


    //Method for remove served customer
    static void RemoveServedCustomer(){
        try {
            int WhichQueue;
            int RequiredBurgerCount;

            Scanner input3 = new Scanner(System.in);

            do {

                System.out.print("Enter the Queue to remove the customer (1,2 or 3):");
                WhichQueue = input3.nextInt(); //asking queue to remove customer

                if (WhichQueue > 3 || WhichQueue < 1) {
                    System.out.println("Invalid Input");
                }

            } while (WhichQueue > 3 || WhichQueue < 1);

            int CustomerCount;

            if (WhichQueue == 1) {
                RequiredBurgerCount = Cashier[0][0].getBurgersRequired();
                SoldBurgers += RequiredBurgerCount;
                BurgerStock = BurgerStock - RequiredBurgerCount;
                CustomerCount = CheckQueueLength(1);

                if (CustomerCount != 0) {
                    for (int i = 0; i < 1; i++) {
                        Cashier[0][i] = Cashier[0][i + 1]; //shifting the elements of cashier
                    }
                    Cashier[0][1] = WaitingQueue[FirstFlag];
                    WaitingQueue[FirstFlag] = null;
                    if (FirstFlag != 4) {
                        FirstFlag += 1;
                    }else {
                        FirstFlag = 0;
                    }

                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }

            } else if (WhichQueue == 2) {
                RequiredBurgerCount = Cashier[1][0].getBurgersRequired();
                BurgerStock = BurgerStock - RequiredBurgerCount;
                CustomerCount = CheckQueueLength(2);

                if (CustomerCount != 0) {
                    for (int i = 0; i < 2; i++) {
                        Cashier[1][i] = Cashier[1][i + 1]; //shifting the elements of cashier
                    }
                    Cashier[1][2] = WaitingQueue[FirstFlag];
                    WaitingQueue[FirstFlag] = null;
                    if (FirstFlag != 4) {
                        FirstFlag += 1;
                    }else {
                        FirstFlag = 0;
                    }
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }
            } else {
                RequiredBurgerCount = Cashier[2][0].getBurgersRequired();
                BurgerStock = BurgerStock - RequiredBurgerCount;
                CustomerCount = CheckQueueLength(3);

                if (CustomerCount != 0) {
                    for (int i = 0; i < 4; i++) {
                        Cashier[2][i] = Cashier[2][i + 1]; //shifting the elements of cashier
                    }
                    Cashier[2][4] = WaitingQueue[FirstFlag];
                    WaitingQueue[FirstFlag] = null;
                    if (FirstFlag != 4) {
                        FirstFlag += 1;
                    }else {
                        FirstFlag = 0;
                    }
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Wrong input");
        }
        ViewAllQueues(); //run ViewAllQueues method to show customer was removed
    }


    //Method to view customers in alpebatical order
    static void ViewCustomers(){

        String[][]  CustomerLine = new String[3][]; // 2D array for store customer names


        // set size for 2D array element which stored customer names
        CustomerLine[0] = new String[2];
        CustomerLine[1] = new String[3];
        CustomerLine[2] = new String[5];

        //Get data from Cashier and store it in CustomerLine Array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Cashier[i].length; j++) {
                if (Cashier[i][j] != null) {
                    CustomerLine[i][j] = Cashier[i][j].getFirstName() + " " + Cashier[i][j].getLastName();
                }
            }
        }


        try {

            // Flatten the 2D array into a 1D array
            String[] flattenedArray = Arrays.stream(CustomerLine)
                    .flatMap(Arrays::stream)
                    .toArray(String[]::new);

            // Bubble sort algorithm to Sort customers in alphabetical order
            int n = flattenedArray.length;
            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (flattenedArray[j] != null && flattenedArray[j + 1] != null && flattenedArray[j].compareTo(flattenedArray[j + 1]) > 0) {
                        // Swap array[j] and array[j+1]
                        String temp = flattenedArray[j];
                        flattenedArray[j] = flattenedArray[j + 1];
                        flattenedArray[j + 1] = temp;
                        swapped = true;
                    }
                }

                // If no two elements were swapped in the inner loop, the array is already sorted
                if (!swapped) {
                    break;
                }
            }

            for (String item : flattenedArray) {
                if (item != null) {
                    System.out.println(item);
                }
            }

        }catch (NullPointerException e){
            System.out.println("No customers to show");
        }
    }

    //method for add data to a file
    static void AddDataToFile(){

        String[][]  CustomerLine = new String[3][]; // 2D array for store customer names


        // set size for 2D array element which stored customer names
        CustomerLine[0] = new String[2];
        CustomerLine[1] = new String[3];
        CustomerLine[2] = new String[5];

        //Get data from Cashier and store it in CustomerLine Array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Cashier[i].length; j++) {
                if (Cashier[i][j] != null) {
                    CustomerLine[i][j] = Cashier[i][j].getFirstName() + " " + Cashier[i][j].getLastName() + " " + Cashier[i][j].getBurgersRequired() + " Burgers Required ";
                }
            }
        }

        try {
            File customerDetails = new File("QueueManagementDetails.txt");
            FileWriter Details = new FileWriter(customerDetails);

            Details.write("---------------------Queue Management Details---------------------");
            Details.write("\n");

            for(int i=0; i<CustomerLine.length; i++){
                for(int j = 0; j<CustomerLine[i].length; j++){
                    if (CustomerLine[i][j] != null) {
                        Details.write(CustomerLine[i][j]);
                        Details.write(" Position :" + "Queue " + (i+1) + " Number " + (j+1));
                        Details.write("\n");
                    }

                }
            }

            Details.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data stored successfully");
    }


    //Method to read data from QueueManagementDetails.txt
    static void ReadFileData(){

        try {

            File customerDetails = new File("QueueManagementDetails.txt");

            Scanner ReadDetails = new Scanner(customerDetails);

            while (ReadDetails.hasNextLine()) {
                String data = ReadDetails.nextLine();
                System.out.println(data);
            }
            ReadDetails.close();

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


    //Method to view burger count
    static void ViewBurgerCount(){

        System.out.println(BurgerStock + " burgers are remaining");

    }


    static void AddBurgers(){
        // checking burger count reach minimum level
        if (BurgerStock == 10) {
            BurgerStock += 40;
            System.out.println("Burgers Added");
        }else {
            System.out.println("The number of Burgers has not reachrd the minimum level");
        }

    }

    //method for calculate the income
    static void CalculateTheIncome(){
        int Queue1Income = Queue1BurgerCount * 650;
        int Queue2Income = Queue2BurgerCount * 650;
        int Queue3Income = Queue3BurgerCount * 650;

        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║              Income               ║");
        System.out.println("╟───────────────────────────────────╢");
        System.out.println("║ Queue 1 : " + Queue1Income);
        System.out.println("║ Queue 2 : " + Queue2Income);
        System.out.println("║ Queue 2 : " + Queue3Income);
        System.out.println("║ Total   : " + (Queue1Income+Queue2Income+Queue3Income));
        System.out.println("╚═══════════════════════════════════╝");
    }

    //method for print waiting queue First flag to last flag
    /*
    * param1 String[] Array - to get waiting queue array in to the method
    * param2 int FirstElement - to define the first element
     */
    public static void PrintCircularQueue(String[] Array, int FirstElement) {

        int index = FirstElement % Array.length;
        int j = 1;
        for (int i = index; i < index + Array.length; i++) {
            if(Array[i % Array.length] != null) {
                System.out.println(j + "." + Array[i % Array.length]);
                j += 1;
            }
        }

    }

    //method for display waiting queue
    static void DisplayWaitingQueue(){

        String[] WaitingQueueArray = new String[5];

        //Get data from WaitingQueue and store it in WaitingQueueArray
        for (int i = 0; i < 5; i++) {
            if (WaitingQueue[i] != null) {
                WaitingQueueArray[i] = WaitingQueue[i].getFirstName() + " " + WaitingQueue[i].getLastName();
            }
        }

        PrintCircularQueue(WaitingQueueArray,FirstFlag);
    }

    //method for print the warning message
    static void PrintWarningMessage(){
        //Print warning massege when burger count reach 10
        if(BurgerStock == 10){
            System.out.println("******-WARNING-*****");
            System.out.println("* Low burger stock *");
            System.out.println("********************");
        }
    }


}
