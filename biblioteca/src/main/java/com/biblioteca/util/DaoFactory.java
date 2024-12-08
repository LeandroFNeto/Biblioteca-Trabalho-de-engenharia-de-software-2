package com.biblioteca.util;

/**
 * Classe responsável pela criação de DAOs.
 */
public abstract class DaoFactory {

    public abstract <T> Dao<T> criarDao(Class<T> clazz);

}

class GenericDaoFactory extends DaoFactory {

    private static GenericDaoFactory instance;

    private GenericDaoFactory() {}

    public static GenericDaoFactory getInstance() {
        if (instance == null) {
            instance = new GenericDaoFactory();
        }
        return instance;
    }

    @Override
    public <T> Dao<T> criarDao(Class<T> clazz) {
        return new Dao<>(clazz);
    }
}
