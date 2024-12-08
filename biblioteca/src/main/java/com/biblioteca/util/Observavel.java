/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para implementar notificações.
 */
public class Observavel {

    private final List<Observer> observers = new ArrayList<>();

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificar(String mensagem) {
        for (Observer observer : observers) {
            observer.atualizar(mensagem);
        }
    }
}
