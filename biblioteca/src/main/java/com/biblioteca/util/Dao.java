/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 * Classe genérica para manipulação de dados com o MongoDB.
 * @param <T> Tipo da entidade
 */
public class Dao<T> {

    private final MongoDatabase database;
    private final MongoCollection<T> collection;

    public Dao(Class<T> clazz) {
        MongoConnection connection = MongoConnection.getInstance();
        this.database = connection.getDatabase();
        this.collection = database.getCollection(clazz.getName(), clazz);
    }

    public void inserir(T objeto) {
        collection.insertOne(objeto);
    }

    public T buscarPorChave(String chave, String valor) {
        return collection.find(new Document(chave, valor)).first();
    }

    public void alterar(String chave, String valor, T novo) {
        collection.replaceOne(new Document(chave, valor), novo);
    }

    public boolean excluir(String chave, String valor) {
        DeleteResult result = collection.deleteOne(new Document(chave, valor));
        return result.getDeletedCount() > 0;
    }

    public List<T> listarTodos() {
        List<T> lista = new ArrayList<>();
        try (MongoCursor<T> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                lista.add(cursor.next());
            }
        }
        return lista;
    }
}
