package br.com.fiap.centerfin.dao;

import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.InvestimentoFintech;

import java.util.List;

public interface InvestimentoDao {

    void cadastrar(InvestimentoFintech investimento) throws DBException;

    void atualizar(InvestimentoFintech investimento) throws DBException;

    void remover(int id) throws DBException;

    InvestimentoFintech buscar(int id);

    List<InvestimentoFintech> listar();
}
