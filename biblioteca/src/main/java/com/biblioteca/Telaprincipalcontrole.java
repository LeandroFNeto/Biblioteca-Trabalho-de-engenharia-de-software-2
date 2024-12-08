package com.biblioteca;

import java.io.IOException;
import javafx.fxml.FXML;

public class Telaprincipalcontrole {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
