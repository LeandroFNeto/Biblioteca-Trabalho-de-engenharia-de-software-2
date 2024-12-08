package com.biblioteca;

import java.io.IOException;
import javafx.fxml.FXML;

public class Registraratedentecontrole {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}