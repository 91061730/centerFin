package br.com.fiap.centerfin.dao;

import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.DespesasFintech;

import java.util.List;

public interface DespesaDao {




    void cadastrar(DespesasFintech despesa)throws DBException;
    void atualizar(DespesasFintech despesa)throws DBException;
    void remover(int id)throws DBException;
    DespesasFintech buscar(int id);
    List<DespesasFintech> listar ();
}
