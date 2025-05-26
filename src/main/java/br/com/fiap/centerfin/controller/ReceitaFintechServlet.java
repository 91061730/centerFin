

package br.com.fiap.centerfin.controller;

import br.com.fiap.centerfin.dao.ReceitaDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.factory.DaoFactory;
import br.com.fiap.centerfin.model.ReceitaFintech;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/receita")
public class ReceitaFintechServlet extends HttpServlet {

    private ReceitaDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getReceitaDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");

        switch (acao) {
            case "cadastrar":
                cadastrar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;
            case "excluir":
                excluir(req, resp);
                break;
        }
    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int codigo = Integer.parseInt(req.getParameter("codigoExcluir"));
        try{
            dao.remover(codigo);
            req.setAttribute("mensagem", "Receita excluida com sucesso!");
        }catch (DBException e){
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao excluir receita.");
        }
        listar(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String descricao = req.getParameter("descricao");
        double valor = Double.parseDouble(req.getParameter("valor"));
        LocalDate data = LocalDate.parse(req.getParameter("data"));


        ReceitaFintech receita = new ReceitaFintech(
                0,
                0,
                descricao,
                valor,
                data);

        try {
            dao.cadastrar(receita);
            req.setAttribute("mensagem", "Receita cadastrada com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar receita.");
        }

        req.getRequestDispatcher("cadastro-receita.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String descricao = req.getParameter("descricao");
            double valor = Double.parseDouble(req.getParameter("valor"));
            LocalDate data = LocalDate.parse(req.getParameter("data"));
            int id = Integer.parseInt(req.getParameter("codigo"));




            ReceitaFintech receita = new ReceitaFintech(id
                    ,0
                    , descricao
                    , valor
                    , data);

            dao.atualizar(receita);

            req.setAttribute("mensagem", "Receita atualizada com sucesso!");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar receita.");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Por favor, valide os dados.");
        }

        listar(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");

        switch (acao) {
            case "listar":
                listar(req, resp);
                break;
            case "abrir-form-edicao":
                abrirForm(req, resp);
                break;
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("codigo"));
        ReceitaFintech receita = dao.buscar(id);
        req.setAttribute("receita", receita);
        req.getRequestDispatcher("editar-receita.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ReceitaFintech> lista = dao.listar();
        double total = lista.stream().mapToDouble(ReceitaFintech::getValor).sum();

        req.setAttribute("receita", lista);
        req.setAttribute("totalReceita", total);
        req.getRequestDispatcher("lista-receita.jsp").forward(req, resp);
    }
}

