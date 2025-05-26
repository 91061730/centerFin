
package br.com.fiap.centerfin.controller;

import br.com.fiap.centerfin.dao.InvestimentoDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.factory.DaoFactory;
import br.com.fiap.centerfin.model.InvestimentoFintech;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/investimento")
public class InvestimentoFintechServlet extends HttpServlet {

    private InvestimentoDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getInvestimentoDao();
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
            req.setAttribute("mensagem", "Investimento excluido com sucesso!");
        }catch (DBException e){
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao excluir investimento");
        }
        listar(req, resp);


    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String descricao = req.getParameter("descricao");
            String nomeAplicacao = req.getParameter("aplicacao");
            double valor = Double.parseDouble(req.getParameter("valor"));
            String instituicao = req.getParameter("instituicao");
            LocalDate dataAplicacao = LocalDate.parse(req.getParameter("dataAplicacao"));
            LocalDate dataVencimento = LocalDate.parse(req.getParameter("dataVencimento"));

            InvestimentoFintech investimento = new InvestimentoFintech(
                    0, 0, nomeAplicacao, instituicao, valor, dataAplicacao, dataVencimento
            );
            investimento.setDescricao(descricao);

            dao.cadastrar(investimento);
            req.setAttribute("mensagem", "Investimento cadastrado com sucesso!");

        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar investimento");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Por favor, valide os dados.");
        }

        req.getRequestDispatcher("cadastro-investimento.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("codigo"));
            String descricao = req.getParameter("descricao");
            String nomeAplicacao = req.getParameter("aplicacao");
            double valor = Double.parseDouble(req.getParameter("valor"));
            String instituicao = req.getParameter("instituicao");
            LocalDate dataAplicacao = LocalDate.parse(req.getParameter("dataAplicacao"));
            LocalDate dataVencimento = LocalDate.parse(req.getParameter("dataVencimento"));

            InvestimentoFintech investimento = new InvestimentoFintech(
                    id, 0, nomeAplicacao, instituicao, valor, dataAplicacao, dataVencimento
            );
            investimento.setDescricao(descricao);

            dao.atualizar(investimento);
            req.setAttribute("mensagem", "Investimento atualizado com sucesso!");

        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar investimento");
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
        InvestimentoFintech investimento = dao.buscar(id);
        req.setAttribute("investimento", investimento);
        req.getRequestDispatcher("editar-investimento.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<InvestimentoFintech> lista = dao.listar();

        double total = lista.stream().mapToDouble(InvestimentoFintech::getValor).sum();
        req.setAttribute("investimentos", lista);
        req.setAttribute("totalInvestido", total);
        req.getRequestDispatcher("lista-investimento.jsp").forward(req, resp);
    }
}

