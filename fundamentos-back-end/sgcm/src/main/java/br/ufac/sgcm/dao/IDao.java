package br.ufac.sgcm.dao;

import java.util.List;

//Interface
public interface IDao<T> { //<T> - tipo genérico
    
    List<T> get();
    T get(Long id); //sobrecarga do metodo
    List<T> get(String termoBusca);
    int insert(T objeto);
    int update(T objeto);
    int delete(Long id);


}
