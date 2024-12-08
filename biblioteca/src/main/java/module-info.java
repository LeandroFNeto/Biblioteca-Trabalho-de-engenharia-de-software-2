module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.core;
    


    opens com.biblioteca to javafx.fxml;
    exports com.biblioteca;
   
    requires org.mongodb.driver.sync.client;
}
