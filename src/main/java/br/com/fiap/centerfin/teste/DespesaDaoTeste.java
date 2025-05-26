package br.com.fiap.centerfin.teste;

import br.com.fiap.centerfin.dao.DespesaDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.factory.DaoFactory;
import br.com.fiap.centerfin.model.DespesasFintech;

import java.time.LocalDate;
import java.util.List;

public class DespesaDaoTeste {

    public static void main(String[] args) {
        DespesaDao dao = DaoFactory.getDespesaDao();


        DespesasFintech nova = new DespesasFintech(
                0,
                1,
                "Conta de Luz",
                300.00,
                LocalDate.of(2025, 5, 10),
                "Boleto"
        );

        try {
            dao.cadastrar(nova);
            System.out.println(" Despesa cadastrada!");
        } catch (DBException e) {
            e.printStackTrace();
        }


        DespesasFintech busca = dao.buscar(1); // ajuste o ID se necessário
        if (busca != null) {
            busca.setDescricao("Conta de Luz Atualizada");
            busca.setValor(350.00);
            busca.setFormaPagamento("PIX");

            try {
                dao.atualizar(busca);
                System.out.println(" Despesa atualizada!");
            } catch (DBException e) {
                e.printStackTrace();
            }
        }


        System.out.println("\n Lista de despesas:");
        List<DespesasFintech> lista = dao.listar();
        for (DespesasFintech d : lista) {
            System.out.println("ID: " + d.getId() + " | Usuário: " + d.getCodigo() +
                    " | Descrição: " + d.getDescricao() + " | Valor: " + d.getValor() +
                    " | Data: " + d.getData() + " | Forma de Pagamento: " + d.getFormaPagamento());
        }

        // Remover
//        try {
//            dao.remover(busca);
//            System.out.println("🗑 Despesa removida!");
//        } catch (DBException e) {
//            e.printStackTrace();
//        }
    }
}
