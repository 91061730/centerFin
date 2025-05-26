package br.com.fiap.centerfin.dao;

import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.ReceitaFintech;

import java.util.List;

public interface ReceitaDao {


    void cadastrar (ReceitaFintech receita) throws DBException;
    void atualizar (ReceitaFintech receita)throws DBException;
    void remover   (int id)throws DBException;
    ReceitaFintech buscar (int id);
    List<ReceitaFintech> listar();
}
