
package com.biblioteca.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe genérica para manipulação de dados com o MongoDB.
 * Agora integrada ao padrão Observer para notificações.
 *
 * @param <T> Tipo da entidade.
 */
public class Dao<T> extends Observavel {

    private final MongoCollection<T> collection;

    public Dao(Class<T> clazz, MongoDatabase database) {
        this.collection = database.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
    }

    public void inserir(T objeto) {
        collection.insertOne(objeto);
        notificarObservadores("Inserção realizada: " + objeto);
    }

    public T buscarPorChave(String chave, String valor) {
        T resultado = collection.find(new Document(chave, valor)).first();
        notificarObservadores("Busca realizada por chave: " + chave + " com valor: " + valor);
        return resultado;
    }

    public void alterar(String chave, String valor, T novo) {
        collection.replaceOne(new Document(chave, valor), novo);
        notificarObservadores("Alteração realizada para chave: " + chave);
    }

    public boolean excluir(String chave, String valor) {
        DeleteResult result = collection.deleteOne(new Document(chave, valor));
        notificarObservadores("Exclusão realizada para chave: " + chave + ", sucesso: " + (result.getDeletedCount() > 0));
        return result.getDeletedCount() > 0;
    }

    public List<T> listarTodos() {
        List<T> lista = new ArrayList<>();
        try (MongoCursor<T> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                lista.add(cursor.next());
            }
        }
        notificarObservadores("Listagem completa realizada.");
        return lista;
    }
}
