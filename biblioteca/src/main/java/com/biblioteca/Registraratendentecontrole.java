package com.biblioteca;

import com.biblioteca.modelo.Atendente;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import com.biblioteca.util.Dao;


/**
 * Classe de controle para a tela de registro de atendentes.
 */
public class Registraratendentecontrole {

    @FXML
    private TextField campoNome; // Campo de texto para o nome

    @FXML
    private TextField campoId; // Campo de texto para o ID

    @FXML
    private TextField campoLogin; // Campo de texto para o login

    @FXML
    private PasswordField campoSenha; // Campo de texto para a senha

    private Dao<Atendente> daoAtendente; // DAO para manipulação do banco de dados

    public Registraratendentecontrole() {
        try {
            daoAtendente = new Dao<>(Atendente.class);
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao inicializar o DAO: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    /**
     * Método chamado quando o botão "Confirmar" é clicado.
     */
    @FXML
    private void confirmarRegistro(ActionEvent event) {
        String nome = campoNome.getText();
        String id = campoId.getText();
        String login = campoLogin.getText();
        String senha = campoSenha.getText();

        if (nome.isBlank() || id.isBlank() || login.isBlank() || senha.isBlank()) {
            mostrarAlerta("Erro", "Todos os campos são obrigatórios.", Alert.AlertType.WARNING);
            return;
        }

        try {
            // Verifica se o login já existe
            Atendente existente = daoAtendente.buscarPorChave("login", login);
            if (existente != null) {
                mostrarAlerta("Erro", "Este login já está em uso.", Alert.AlertType.ERROR);
                return;
            }

            // Cria um novo atendente usando Factory Method
            Atendente novoAtendente = criarAtendente(id, nome, login, senha);

            // Salva o atendente no banco de dados
            daoAtendente.inserir(novoAtendente);

            mostrarAlerta("Sucesso", "Atendente registrado com sucesso!", Alert.AlertType.INFORMATION);
            limparCampos();
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao registrar atendente: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    /**
     * Método para criar um objeto Atendente usando Factory Method.
     */
    private Atendente criarAtendente(String id, String nome, String login, String senha) {
        return new Atendente(id, nome, login, senha);
    }

    /**
     * Método chamado quando o botão "Voltar" é clicado.
     */
    @FXML
    private void voltarTelaPrincipal(ActionEvent event) throws IOException {
        App.setRoot("telaprincipal");
    }

    /**
     * Limpa os campos de texto.
     */
    private void limparCampos() {
        campoNome.clear();
        campoId.clear();
        campoLogin.clear();
        campoSenha.clear();
    }

    /**
     * Mostra uma mensagem de alerta para o usuário.
     */
    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
