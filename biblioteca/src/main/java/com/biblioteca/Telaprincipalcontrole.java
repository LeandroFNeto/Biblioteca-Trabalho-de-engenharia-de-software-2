package com.biblioteca;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Classe de controle para a tela principal.
 */
public class Telaprincipalcontrole {

    @FXML
    private void trocarParaNovoAluno() throws IOException {
        App.setRoot("novoaluno");
    }

    @FXML
    private void trocarParaAlterarAluno() throws IOException {
        App.setRoot("alteraraluno");
    }

    @FXML
    private void trocarParaAdicionarLivro() throws IOException {
        App.setRoot("adicionarlivro");
    }

    @FXML
    private void trocarParaAlterarLivro() throws IOException {
        App.setRoot("alterarlivro");
    }

    @FXML
    private void trocarParaEmprestimo() throws IOException {
        App.setRoot("emprestimo");
    }

    @FXML
    private void trocarParaDevolucao() throws IOException {
        App.setRoot("devolucao");
    }

    @FXML
    private void trocarParaNovoAtendente() throws IOException {
        App.setRoot("registraratendente");
    }

    @FXML
    private void trocarParaAlterarAtendente() throws IOException {
        App.setRoot("alteraratendente");
    }

    @FXML
    private void encerrarAplicacao() {
        System.exit(0);
    }

    private void mostrarMensagem(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}

