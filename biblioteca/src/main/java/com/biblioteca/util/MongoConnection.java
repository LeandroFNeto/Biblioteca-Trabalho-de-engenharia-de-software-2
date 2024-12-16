package com.biblioteca.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private static MongoConnection instance;
    private MongoDatabase database;

    private MongoConnection() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        this.database = client.getDatabase("biblioteca"); // Substitua "biblioteca" pelo nome do seu banco
    }

    public static MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
