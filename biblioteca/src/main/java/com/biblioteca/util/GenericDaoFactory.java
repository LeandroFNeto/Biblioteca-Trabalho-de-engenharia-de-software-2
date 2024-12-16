
package com.biblioteca.util;

import com.mongodb.client.MongoDatabase;

public class GenericDaoFactory extends DaoFactory {

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
        try {
            MongoConnection connection = MongoConnection.getInstance();
            MongoDatabase database = connection.getDatabase();
            return new Dao<>(clazz, database);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar DAO para " + clazz.getSimpleName(), e);
        }
    }
}

