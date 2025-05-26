package br.com.fiap.centerfin.teste;

import br.com.fiap.centerfin.dao.impl.OracleInvestimentoDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.InvestimentoFintech;

import java.time.LocalDate;
import java.util.List;

public class InvestimentoDaoTeste {

    public static void main(String[] args) {

        OracleInvestimentoDao dao = new OracleInvestimentoDao();

        try {

            InvestimentoFintech investimento = new InvestimentoFintech();
            investimento.setId(3001);
            investimento.setCodigoUsuario(1);
            investimento.setDescricao("Investimento em CDB");
            investimento.setValor(5000.00);
            investimento.setData(LocalDate.of(2025, 5, 1));
            investimento.setInstituicao("Banco XP");
            investimento.setNomeAplicacao("CDB 100% CDI");
            investimento.setDataVencimento(LocalDate.of(2026, 5, 1));


            dao.cadastrar(investimento);
            System.out.println("Investimento cadastrado com sucesso!");


            InvestimentoFintech invBuscado = dao.buscar(3001);
            if (invBuscado != null) {
                System.out.println("Investimento encontrado: " + invBuscado.getDescricao() + " - R$" + invBuscado.getValor());
            }


            invBuscado.setValor(5200.00);
            invBuscado.setDescricao("Investimento em CDB Atualizado");
            dao.atualizar(invBuscado);
            System.out.println("Investimento atualizado.");


            List<InvestimentoFintech> lista = dao.listar();
            System.out.println("Lista de investimentos:");
            for (InvestimentoFintech inv : lista) {
                System.out.println(inv.getId() + ": " + inv.getDescricao() + " - R$" + inv.getValor() + " - Instituição: " + inv.getInstituicao());
            }


            dao.remover(investimento.getId());
            System.out.println("Investimento removido.");

        } catch (DBException e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
