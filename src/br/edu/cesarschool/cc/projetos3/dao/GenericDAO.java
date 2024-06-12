package br.edu.cesarschool.cc.projetos3.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDAO<T> {
    
    private Map<String, T> database = new HashMap<>(); // vai simular um banco de dados, visse?
    
    private String obterIdUnico(T objeto) {
      try {
        Object id = objeto.getClass().getMethod("getId").invoke(objeto);
        return String.valueOf(id);
      } catch (Exception e) {
        throw new RuntimeException("Erro ao obter ID único", e);
      }
    }
    
    public T buscar(String id) {
        return database.get(id);
    }

    public List<T> buscarTodos() {
    return new ArrayList<>(database.values());
}
    
    public boolean incluir(T objeto) {
        String id = obterIdUnico(objeto);
        if (database.containsKey(id)) {
            return false;
        }
        database.put(id, objeto);
        return true;
    }
    
    public boolean alterar(T objeto) {
        String id = obterIdUnico(objeto);
        if (!database.containsKey(id)) {
            return false;
        }
        database.put(id, objeto);
        return true;
    }
    
    public boolean excluir(String id) {
        if (!database.containsKey(id)) {
            return false;
        }
        database.remove(id);
        return true;
    }
}

