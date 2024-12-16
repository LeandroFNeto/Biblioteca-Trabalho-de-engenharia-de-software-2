package com.biblioteca.util;

import com.mongodb.client.MongoDatabase;

public abstract class DaoFactory {
    public abstract <T> Dao<T> criarDao(Class<T> clazz);
}

