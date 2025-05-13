import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class QueueManagementSysyem {

    static boolean RunProgramme = true;
    static int BurgerStock = 50;

    static String[] cashier1 = {"x","x"}; //queue1
    static String[] cashier2 = {"x","x","x"}; //queue2
    static String[] cashier3 = {"x","x","x","x","x"}; //queue3


    static String[][]  CustomerLine = new String[3][]; // 2D array for store customer names

    //customer positions for write in file
    static int Position1 = 0;
    static int Position2 = 0;
    static int Position3 = 0;


    //method to view all queues
    static void ViewAllQueues() {
        //print queues using print formating
        System.out.println("\n");
        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");
        System.out.printf("%2s %5s %6s %n",cashier1[0],cashier2[0],cashier3[0]);
        System.out.printf("%2s %5s %6s %n",cashier1[1],cashier2[1],cashier3[1]);
        System.out.printf("%8s %6s %n",cashier2[2],cashier3[2]);
        System.out.printf("%15s %n",cashier3[3]);
        System.out.printf("%15s %n",cashier3[4]);
        System.out.println("o-Occupied x-Notoccupied");
        System.out.println("\n");
    }

    //method to view empty queues
    static void ViewEmptyQueues() {
        boolean Queue1 = false;
        boolean Queue2 = false;
        boolean Queue3 = false;

        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");

        for (String Element : cashier1) {
            if (Element.equals("x")) {
                Queue1 = true;
                break;
            }
        }

        for (String Element : cashier2) {
            if (Element.equals("x")) {
                Queue2 = true;
                break;
            }
        }

        for (String Element : cashier3) {
            if (Element.equals("x")) {
                Queue3 = true;
                break;
            }
        }

        if(Queue1 && Queue2 && Queue3) {
            System.out.printf("%2s %5s %6s %n",cashier1[0],cashier2[0],cashier3[0]);
            System.out.printf("%2s %5s %6s %n",cashier1[1],cashier2[1],cashier3[1]);
            System.out.printf("%8s %6s %n",cashier2[2],cashier3[2]);
            System.out.printf("%15s %n",cashier3[3]);
        } else if (Queue1 && Queue2) {
            System.out.printf("%2s %5s %n",cashier1[0],cashier2[0]);
            System.out.printf("%2s %5s %n",cashier1[1],cashier2[1]);
            System.out.printf("%8s %n",cashier2[2]);
        } else if (Queue1 && Queue3){
            System.out.printf("%2s %12s %n",cashier1[0],cashier3[0]);
            System.out.printf("%2s %12s %n",cashier1[1],cashier3[1]);
            System.out.printf("%15s %n",cashier3[2]);
            System.out.printf("%15s %n",cashier3[3]);
            System.out.printf("%15s %n",cashier3[4]);
        } else if (Queue2 && Queue3) {
            System.out.printf("%8s %6s %n",cashier2[0],cashier3[0]);
            System.out.printf("%8s %6s %n",cashier2[1],cashier3[1]);
            System.out.printf("%8s %6s %n",cashier2[2],cashier3[2]);
            System.out.printf("%15s %n",cashier3[3]);
            System.out.printf("%15s %n",cashier3[4]);
        } else if (Queue1) {
            System.out.printf("%2s %n",cashier1[0]);
            System.out.printf("%2s %n",cashier1[1]);
        } else if (Queue2) {
            System.out.printf("%8s %n",cashier2[0]);
            System.out.printf("%8s %n",cashier2[1]);
            System.out.printf("%8s %n",cashier2[2]);
        }else {
            System.out.printf("%15s %n",cashier3[0]);
            System.out.printf("%15s %n",cashier3[1]);
            System.out.printf("%15s %n",cashier3[2]);
            System.out.printf("%15s %n",cashier3[3]);
            System.out.printf("%15s %n",cashier3[4]);
        }
        System.out.println("o-Occupied x-Notoccupied");
    }


    // use in AddCustomer method,RemoveCustomer and RemoveServedCustomer to check how many customers in the queue
    /*
    * param(Cashier) = use to check which cashier in AddCostomer method*/
    static int CountCustomer(String[] Cashier) {
        int Count = 0;

        for (String element : Cashier) {
            if (element.equals("o")) {
                Count++;

            }
        }
        return Count;
    }

    //Method for add customer names into 2D array
    /*
    * param 1(QueueNumber) = checking which queue in AddCustomer method
    * param 2(Name) = Get customer name
    */
    static void AddCustomerName(int QueueNumber ,String Name ){

        if(QueueNumber == 1){
            CustomerLine[0][Position1] = Name;
            Position1++;
        }else if(QueueNumber == 2){
                CustomerLine[1][Position2] = Name;
                Position2++;
        }else {
            CustomerLine[2][Position3] = Name;
            Position3++;
        }

    }

    //method to add customer
    static void AddCustomer(){


        Scanner input1 = new Scanner(System.in);

        System.out.print("Enter the customer's name :");
        String Name = input1.next();

        try {


            System.out.print("Which queue you want to add to(Enter 1,2 or 3) :");
            int WhichQueue = input1.nextInt();


            int CashierFull;

            if (0 < WhichQueue && WhichQueue < 4) {

                if (WhichQueue == 1) {
                    CashierFull = CountCustomer(cashier1);

                    if (CashierFull < 2) {
                        AddCustomerName(1, Name);

                        for (int i = 0; i < cashier1.length; i++) {
                            if (cashier1[i].equals("x")) {
                                cashier1[i] = "o";
                                break;
                            }
                        }
                    } else {
                        System.out.println("\n");
                        System.out.println("Queue is Full Please wait!");
                        System.out.println("\n");
                    }

                } else if (WhichQueue == 2) {
                    CashierFull = CountCustomer(cashier2);

                    if (CashierFull < 3) {
                        AddCustomerName(2, Name);

                        for (int i = 0; i < cashier2.length; i++) {
                            if (cashier2[i].equals("x")) {
                                cashier2[i] = "o";
                                break;
                            }
                        }
                    } else {
                        System.out.println("\n");
                        System.out.println("Queue is Full Please wait!");
                        System.out.println("\n");
                    }

                } else {
                    CashierFull = CountCustomer(cashier3);

                    if (CashierFull < 5) {
                        AddCustomerName(3, Name);

                        for (int i = 0; i < cashier3.length; i++) {
                            if (cashier3[i].equals("x")) {
                                cashier3[i] = "o";
                                break;
                            }
                        }
                    } else {
                        System.out.println("\n");
                        System.out.println("Queue is Full Please wait!");
                        System.out.println("\n");
                    }
                }
            } else {
                System.out.println("Wrong Input");
            }

        }catch (InputMismatchException e){
            System.out.println("Wrong input");
        }

        ViewAllQueues();

    }

    // method to remove a customer in a specific location
    static void RemoveCustomer(){

        try {
            Scanner input2 = new Scanner(System.in);
            int WhichQueue;
            int WhichOne;
            // looping until get correct input
            do {

                System.out.print("Enter the Queue to remove the customer (1,2 or 3):");
                WhichQueue = input2.nextInt();

                if (WhichQueue > 3 || WhichQueue < 1) {
                    System.out.println("Invalid Input");
                }

            } while (WhichQueue > 3 || WhichQueue < 1);


            if (WhichQueue == 1) {
                Position1 -= 1;
                // looping until get correct input
                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt();

                    if (WhichOne < 1 || WhichOne > cashier1.length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > cashier1.length);


                if (cashier1[WhichOne - 1].equals("o")) {
                    for (int i = WhichOne - 1; i < 1; i++) {
                        cashier1[i] = cashier1[i + 1];
                        CustomerLine[0][i] = CustomerLine[0][i + 1];

                    }
                    cashier1[1] = "x";
                    CustomerLine[0][1] = null;
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }


            } else if (WhichQueue == 2) {
                Position2 -= 1;

                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt();

                    if (WhichOne < 1 || WhichOne > cashier2.length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > cashier2.length);

                if (cashier2[WhichOne - 1].equals("o")) {

                    for (int i = WhichOne - 1; i < 2; i++) {
                        cashier2[i] = cashier2[i + 1];
                        CustomerLine[1][i] = CustomerLine[1][i + 1];

                    }
                    cashier2[2] = "x";
                    CustomerLine[1][2] = null;

                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }

            } else {
                Position3 -= 1;

                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt();

                    if (WhichOne < 1 || WhichOne > cashier3.length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > cashier3.length);

                if (cashier3[WhichOne - 1].equals("o")) {

                    for (int i = WhichOne - 1; i < 4; i++) {
                        cashier3[i] = cashier3[i + 1];
                        CustomerLine[2][i] = CustomerLine[2][i + 1];

                    }
                    cashier3[4] = "x";
                    CustomerLine[2][4] = null;

                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Wrong input");
        }
        ViewAllQueues();
    }


    //Method for remove served customer
    static void RemoveServedCustomer(){
        try {
            BurgerStock -= 5; // reduse burger stock by 5
            int WhichQueue;

            Scanner input3 = new Scanner(System.in);

            // looping until get correct input
            do {

                System.out.print("Enter the Queue to remove the customer (1,2 or 3):");
                WhichQueue = input3.nextInt();

                if (WhichQueue > 3 || WhichQueue < 1) {
                    System.out.println("Invalid Input");
                }

            } while (WhichQueue > 3 || WhichQueue < 1);

            int CustomerCount;

            if (WhichQueue == 1) {
                Position1 -= 1;
                CustomerCount = CountCustomer(cashier1);

                if (CustomerCount != 0) {

                    for (int i = 0; i < 1; i++) {
                        cashier1[i] = cashier1[i + 1];
                        CustomerLine[0][i] = CustomerLine[0][i + 1];

                    }
                    cashier1[1] = "x";
                    CustomerLine[0][1] = null;

                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }

            } else if (WhichQueue == 2) {
                Position2 -= 1;
                CustomerCount = CountCustomer(cashier2);

                if (CustomerCount != 0) {

                    for (int i = 0; i < 2; i++) {
                        cashier2[i] = cashier2[i + 1];
                        CustomerLine[1][i] = CustomerLine[1][i + 1];

                    }
                    cashier2[2] = "x";
                    CustomerLine[1][2] = null;

                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }

            } else {
                Position3 -= 1;
                CustomerCount = CountCustomer(cashier3);

                if (CustomerCount != 0) {

                    for (int i = 0; i < 4; i++) {
                        cashier3[i] = cashier3[i + 1];
                        CustomerLine[2][i] = CustomerLine[2][i + 1];

                    }
                    cashier3[4] = "x";
                    CustomerLine[2][4] = null;

                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Wrong input");
        }
        ViewAllQueues();
    }


    //Method to view customers in alpebatical order
    static void ViewCustomers(){


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

    //Method to add data to QueueManagementDetails.txt
    static void AddDataToFile(){
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

    //Method to add burgers
    static void AddBurgers(){
        // checking burger count reach minimum level
        if (BurgerStock == 10) {
            BurgerStock += 40;
            System.out.println("Burgers Added");
        }else {
            System.out.println("The number of Burgers has not reachrd the minimum level");
        }

    }

    //Method to stop execution
    static void Exit(){
        RunProgramme = false;
    }

    //Method for select item from the menue
    static void Menu(){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter what you want to do: ");
        String task = input.next().toLowerCase();

        //Enhanced swich case to call all methods
        switch (task) {
            case "100", "vfq" -> ViewAllQueues();
            case "101", "veq" -> ViewEmptyQueues();
            case "102", "acq" -> AddCustomer();
            case "103", "rcq" -> RemoveCustomer();
            case "104", "pcq" -> RemoveServedCustomer();
            case "105", "vcs" -> ViewCustomers();
            case "106", "spd" -> AddDataToFile();
            case "107", "lpd" -> ReadFileData();
            case "108", "stk" -> ViewBurgerCount();
            case "109", "afs" -> AddBurgers();
            case "999", "ext" -> Exit();
            default -> System.out.println("Wrong Input");
        }


    }



    public static void main(String[] args) {

        // set size for 2D array element which stored customer names
        CustomerLine[0] = new String[2];
        CustomerLine[1] = new String[3];
        CustomerLine[2] = new String[5];



        System.out.println("\n");
        System.out.println("-------------------------------Foodies Fave Queue Management System.--------------------------------");
        System.out.println("\n");

        while (RunProgramme) {
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
            System.out.println("||  999 or EXT: Exit the Program.                             ||");
            System.out.println("||============================================================||");

            System.out.println("\n");


            //Print warning massege when burger count reach 10
            if(BurgerStock == 10){
                System.out.println("******-WARNING-*****");
                System.out.println("* Low burger stock *");
                System.out.println("********************");
            }


            Menu();

        }
    }
}