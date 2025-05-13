package com.example.part4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueManagementController {
    @FXML
    private Label C1P1;

    @FXML
    private Label C1P2;

    @FXML
    private Label C2P1;

    @FXML
    private Label C2P2;

    @FXML
    private Label C2P3;

    @FXML
    private Label C3P1;

    @FXML
    private Label C3P2;

    @FXML
    private Label C3P3;

    @FXML
    private Label C3P4;

    @FXML
    private Label C3P5;

    @FXML
    private Label W1;

    @FXML
    private Label W2;

    @FXML
    private Label W3;

    @FXML
    private Label W4;

    @FXML
    private Label W5;

    @FXML
    private Label Q1I;

    @FXML
    private Label Q2I;

    @FXML
    private Label Q3I;

    @FXML
    private Label total;

    @FXML
    private TextField search;

    @FXML
    private TextArea ShowSearch;

    public void Prompt() {
        Application.launch(QueueManagementApplication.class);
    }



    static FoodQueue obj = new FoodQueue();


    @FXML
    protected void AddDetails(){

        for (int i = 0; i < 4; i++) {
            if (i == 0) {

                if (obj.Cashier[0][0] == null) {
                    C1P1.setText("X");
                } else {
                    C1P1.setText("0 - " + obj.Cashier[0][0].getFirstName() + " " + obj.Cashier[0][0].getLastName());
                }

                if (obj.Cashier[0][1] == null) {
                    C1P2.setText("X");
                } else {
                    C1P2.setText("0 - " + obj.Cashier[0][1].getFirstName() + " " + obj.Cashier[0][1].getLastName());
                }


            }else if (i == 1) {
                if (obj.Cashier[1][0] == null) {
                    C2P1.setText("X");
                } else {
                    C2P1.setText("0 - " + obj.Cashier[1][0].getFirstName() + " " + obj.Cashier[1][0].getLastName());
                }

                if (obj.Cashier[1][1] == null) {
                    C2P2.setText("X");
                } else {
                    C2P2.setText("0 - " + obj.Cashier[1][1].getFirstName() + " " + obj.Cashier[1][1].getLastName());
                }

                if (obj.Cashier[1][2] == null) {
                    C2P3.setText("X");
                } else {
                    C2P3.setText("0 - " + obj.Cashier[1][2].getFirstName() + " " + obj.Cashier[1][2].getLastName());
                }

            }else if(i == 2){
                if (obj.Cashier[2][0] == null) {
                    C3P1.setText("X");
                } else {
                    C3P1.setText("0 - " + obj.Cashier[2][0].getFirstName() + " " + obj.Cashier[2][0].getLastName());
                }

                if (obj.Cashier[2][1] == null) {
                    C3P2.setText("X");
                } else {
                    C3P2.setText("0 - " + obj.Cashier[2][1].getFirstName() + " " + obj.Cashier[2][1].getLastName());
                }

                if (obj.Cashier[2][2] == null) {
                    C3P3.setText("X");
                } else {
                    C3P3.setText("0 - " + obj.Cashier[2][2].getFirstName() + " " + obj.Cashier[2][2].getLastName());
                }

                if (obj.Cashier[2][3] == null) {
                    C3P4.setText("X");
                } else {
                    C3P4.setText("0 - " + obj.Cashier[2][3].getFirstName() + " " + obj.Cashier[2][3].getLastName());
                }

                if (obj.Cashier[2][4] == null) {
                    C3P5.setText("X");
                } else {
                    C3P5.setText("0 - " + obj.Cashier[2][4].getFirstName() + " " + obj.Cashier[2][4].getLastName());
                }

            }else {
                if (obj.WaitingQueue[0] == null) {
                    W1.setText("X");
                } else {
                    W1.setText("0 - " + obj.WaitingQueue[0].getFirstName() + " " + obj.WaitingQueue[0].getLastName());
                }

                if (obj.WaitingQueue[1] == null) {
                    W2.setText("X");
                } else {
                    W2.setText("0 - " + obj.WaitingQueue[1].getFirstName() + " " + obj.WaitingQueue[1].getLastName());
                }

                if (obj.WaitingQueue[2] == null) {
                    W3.setText("X");
                } else {
                    W3.setText("0 - " + obj.WaitingQueue[2].getFirstName() + " " + obj.WaitingQueue[2].getLastName());
                }

                if (obj.WaitingQueue[3] == null) {
                    W4.setText("X");
                } else {
                    W4.setText("0 - " + obj.WaitingQueue[3].getFirstName() + " " + obj.WaitingQueue[3].getLastName());
                }

                if (obj.WaitingQueue[4] == null) {
                    W5.setText("X");
                } else {
                    W5.setText("0 - " + obj.WaitingQueue[4].getFirstName() + " " + obj.WaitingQueue[4].getLastName());
                }
            }
        }

        //Calculating the Income
        int Queue1Income = obj.Queue1BurgerCount * 650;
        int Queue2Income = obj.Queue2BurgerCount * 650;
        int Queue3Income = obj.Queue3BurgerCount * 650;
        int Total = (obj.Queue1BurgerCount + obj.Queue2BurgerCount + obj.Queue3BurgerCount) * 650;

        Q1I.setText("\u00a3" + String.valueOf(Queue1Income));
        Q2I.setText("\u00a3" + String.valueOf(Queue2Income));
        Q3I.setText("\u00a3" + String.valueOf(Queue3Income));
        total.setText("\u00a3" + String.valueOf(Total));
    }

    @FXML
    protected void SearchDetails(){
        Customer[][]  CustomerLine = new Customer[3][]; // 2D array for store customer names


        // set size for 2D array element which stored customer names
        CustomerLine[0] = new Customer[2];
        CustomerLine[1] = new Customer[3];
        CustomerLine[2] = new Customer[5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < obj.Cashier[i].length; j++) {
                if (obj.Cashier[i][j] != null) {
                    CustomerLine[i][j] = obj.Cashier[i][j];
                }
            }
        }

        ArrayList<String> MachingNames = new ArrayList<String>();

        String SearchString = search.getText();


        for (int i = 0; i < CustomerLine.length; i++) {
            for (int j = 0; j < CustomerLine[i].length; j++) {
                if (CustomerLine[i][j] != null && (CustomerLine[i][j].getFirstName().equals(SearchString) || (CustomerLine[i][j].getFirstName() + " " + CustomerLine[i][j].getLastName()).equals(SearchString))) {
                    MachingNames.add(obj.Cashier[i][j].getFirstName() + " " + obj.Cashier[i][j].getLastName() + " - " + obj.Cashier[i][j].getBurgersRequired() + " Burgers Required " + "(Position :" + "Queue " + (i+1) + " Number " + (j+1) + ")");

                }
            }

        }


        if (!MachingNames.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();

            for (String name : MachingNames) {
                stringBuilder.append(name).append("\n");
            }

            ShowSearch.setText(stringBuilder.toString());
        } else {
            ShowSearch.setText("No matching customers found.");
        }
    }

    @FXML
    protected void Exit(){
        System.exit(0);
    }

}