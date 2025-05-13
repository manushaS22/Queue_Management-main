module com.example.part4 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.part4 to javafx.fxml;
    exports com.example.part4;
}