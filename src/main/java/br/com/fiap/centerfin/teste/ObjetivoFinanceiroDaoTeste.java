package br.com.fiap.centerfin.teste;

import br.com.fiap.centerfin.dao.ObjetivoDao;
import br.com.fiap.centerfin.dao.impl.OracleObjetivoFinanceiroDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.ObjetivoFinanceiroFintech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.centerfin.dao.ConnectionManager;

public class ObjetivoFinanceiroDaoTeste {

    public static void main(String[] args) {
        ObjetivoDao dao = new OracleObjetivoFinanceiroDao();

      //limparTabela(); //

        try {
            ObjetivoFinanceiroFintech objetivo = new ObjetivoFinanceiroFintech();
            objetivo.setId(1);
            objetivo.setCodigoUsuario(100);
            objetivo.setNomeObjetivo("Comprar carro");
            objetivo.setDescricao("Juntar dinheiro para comprar um carro novo");
            objetivo.setValor(30000.0);
            objetivo.setDataConclusao(LocalDate.of(2026, 12, 31));


            dao.cadastrar(objetivo);
            System.out.println("Objetivo cadastrado com sucesso!");


            ObjetivoFinanceiroFintech objBuscado = dao.buscar(1);
            System.out.println("Objetivo buscado: " + objBuscado.getNomeObjetivo() + " - " + objBuscado.getDescricao());


            objBuscado.setDescricao("Juntar dinheiro para comprar um carro novo e pagar seguro");
            dao.atualizar(objBuscado);
            System.out.println("Objetivo atualizado!");


            List<ObjetivoFinanceiroFintech> lista = dao.listar();
            System.out.println("Listagem de objetivos:");
            for (ObjetivoFinanceiroFintech obj : lista) {
                System.out.println(obj.getId() + " - " + obj.getNomeObjetivo() + " - " + obj.getDescricao() + " - " + obj.getValor());
            }

        /*
        // Remover
        dao.remover(objBuscado);
        System.out.println("Objetivo removido!");
        */

        } catch (DBException e) {
            System.err.println("Erro durante o teste: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void limparTabela() {
    }
}
