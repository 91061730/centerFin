


package br.com.fiap.centerfin.teste;

import br.com.fiap.centerfin.dao.ReceitaDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.factory.DaoFactory;
import br.com.fiap.centerfin.model.ReceitaFintech;

import java.time.LocalDate;
import java.util.List;

public class ReceitaDaoTeste {

    public static void main(String[] args) {

        ReceitaDao dao = DaoFactory.getReceitaDao();

        ReceitaFintech receita = new ReceitaFintech(
                2,
                "esse teste vc fez agora 3",
                2000.0,
                LocalDate.of(2025, 5, 20)
        );

        try {
            dao.cadastrar(receita);
            System.out.println(" Receita cadastrada com sucesso. ID: " + receita.getId());
        } catch (DBException e) {
            e.printStackTrace();
            return;
        }


        ReceitaFintech receitaBuscada = dao.buscar(receita.getId());
        if (receitaBuscada != null) {
            receitaBuscada.setDescricao("Acabei de testa a mudança  ");
            receitaBuscada.setValor(234.0);

            try {
                dao.atualizar(receitaBuscada);
                System.out.println(" Receita atualizada com sucesso.");
            } catch (DBException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("⚠️ Receita não encontrada com o ID " + receita.getId());
        }


        System.out.println("\n Listando todas as receitas:");
        List<ReceitaFintech> lista = dao.listar();
        for (ReceitaFintech item : lista) {
            System.out.println(
                    "ID: " + item.getId() +
                            " | Usuário: " + item.getCodigo() +
                            " | Descrição: " + item.getDescricao() +
                            " | Valor: " + item.getValor() +
                            " | Data: " + item.getData());
        }

        // Remover uma receita (opcional)
//        try {
//            dao.remover(receita.getId());
//            System.out.println(" Receita removida com sucesso.");
//        } catch (DBException e) {
//            e.printStackTrace();
//        }
    }
}
