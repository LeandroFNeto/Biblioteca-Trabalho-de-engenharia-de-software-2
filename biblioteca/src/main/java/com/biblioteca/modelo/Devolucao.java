/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.modelo;

import java.time.LocalDate;

public class Devolucao {
    private String id;
    private String idEmprestimo;
    private LocalDate dataDevolucaoEfetiva;
    private double multa;

    // Construtor
    public Devolucao(String id, String idEmprestimo, LocalDate dataDevolucaoEfetiva, double multa) {
        this.id = id;
        this.idEmprestimo = idEmprestimo;
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
        this.multa = multa;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(String idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public LocalDate getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public void setDataDevolucaoEfetiva(LocalDate dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
