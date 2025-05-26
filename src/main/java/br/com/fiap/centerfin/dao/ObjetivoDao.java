package br.com.fiap.centerfin.dao;

import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.ObjetivoFinanceiroFintech;

import java.util.List;

public interface ObjetivoDao {

    void cadastrar(ObjetivoFinanceiroFintech objetivo) throws DBException;

    void atualizar(ObjetivoFinanceiroFintech objetivo) throws DBException;

    void remover(int id) throws DBException;

    ObjetivoFinanceiroFintech buscar(int id);

    List<ObjetivoFinanceiroFintech> listar();
}

