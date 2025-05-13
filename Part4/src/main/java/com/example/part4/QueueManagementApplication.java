package com.example.part4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QueueManagementApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QueueManagementApplication.class.getResource("QueueManagement-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("Foodies Fave Queue Management System");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}

