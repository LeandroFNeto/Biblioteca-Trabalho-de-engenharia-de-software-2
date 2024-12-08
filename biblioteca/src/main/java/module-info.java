module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client; // Para uso do MongoDB Driver
    requires org.mongodb.bson;

    opens com.biblioteca to javafx.fxml;
    exports com.biblioteca;
    exports com.biblioteca.util; // Se quiser expor o pacote util
}
