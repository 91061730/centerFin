

package br.com.fiap.centerfin.controller;

import br.com.fiap.centerfin.dao.ObjetivoDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.factory.DaoFactory;
import br.com.fiap.centerfin.model.ObjetivoFinanceiroFintech;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/objetivo")
public class ObjetivoFinanceiroFintechServlet extends HttpServlet {

    private ObjetivoDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getObjetivoDao();
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
            req.setAttribute("mensagem", "Objetivo excluido com sucesso!");
        }catch (DBException e){
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao excluir investimento");
        }
        listar(req, resp);



    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String descricao = req.getParameter("descricao");
        String nomeObjetivo = req.getParameter("nomeObjetivo");
        double valor = Double.parseDouble(req.getParameter("valor"));
        LocalDate dataConclusao = LocalDate.parse(req.getParameter("data"));

        ObjetivoFinanceiroFintech objetivo = new ObjetivoFinanceiroFintech(
                0,
                0,
                nomeObjetivo,
                descricao,
                valor,
                dataConclusao
        );

        try {
            dao.cadastrar(objetivo);
            req.setAttribute("mensagem", "Objetivo cadastrado com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar objetivo financeiro");
        }
        req.getRequestDispatcher("cadastro-objetivoFinanceiro.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("codigo"));
            String descricao = req.getParameter("descricao");
            String nomeObjetivo = req.getParameter("nomeObjetivo");
            double valor = Double.parseDouble(req.getParameter("valor"));
            LocalDate dataConclusao = LocalDate.parse(req.getParameter("data"));

            ObjetivoFinanceiroFintech objetivo = new ObjetivoFinanceiroFintech(id, 0, nomeObjetivo, descricao, valor, dataConclusao);
            dao.atualizar(objetivo);

            req.setAttribute("mensagem", "Objetivo atualizado com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar objetivo financeiro");
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
        ObjetivoFinanceiroFintech objetivo = dao.buscar(id);
        req.setAttribute("objetivo", objetivo);
        req.getRequestDispatcher("editar-objetivo.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ObjetivoFinanceiroFintech> lista = dao.listar();
        double total = lista.stream().mapToDouble(ObjetivoFinanceiroFintech::getValor).sum();

        req.setAttribute("objetivo", lista);
        req.setAttribute("totalObjetivo", total);
        req.getRequestDispatcher("lista-objetivo.jsp").forward(req, resp);
    }
}

