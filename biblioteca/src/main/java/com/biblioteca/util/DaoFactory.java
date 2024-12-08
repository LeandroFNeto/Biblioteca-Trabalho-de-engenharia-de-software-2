/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.util;

/**
 * Classe responsável pela criação de DAOs.
 */
public abstract class DaoFactory {

    public abstract <T> Dao<T> criarDao(Class<T> clazz);

}

class GenericDaoFactory extends DaoFactory {

    @Override
    public <T> Dao<T> criarDao(Class<T> clazz) {
        return new Dao<>(clazz);
    }
}
