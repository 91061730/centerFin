

package br.com.fiap.centerfin.controller;

import br.com.fiap.centerfin.dao.DespesaDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.factory.DaoFactory;
import br.com.fiap.centerfin.model.DespesasFintech;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/despesa")
public class DespesaFintechServlet extends HttpServlet {

    private DespesaDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getDespesaDao();
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
        try {
            dao.remover(codigo);
            req.setAttribute("mensagem", "Despesa excluída com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao excluir despesa");
        }
        listar(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String descricao = req.getParameter("descricao");
        double valor = Double.parseDouble(req.getParameter("valor"));
        String formaPagamento = req.getParameter("pagamento");
        LocalDate data = LocalDate.parse(req.getParameter("data"));

        DespesasFintech despesa = new DespesasFintech(
                0,
                0,
                descricao,
                valor,
                data,
                formaPagamento
        );

        try {
            dao.cadastrar(despesa);
            req.setAttribute("mensagem", "Despesa cadastrada com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar despesa");
        }

        req.getRequestDispatcher("cadastro-despesa.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String descricao = req.getParameter("descricao");
            double valor = Double.parseDouble(req.getParameter("valor"));
            String formaPagamento = req.getParameter("pagamento");
            LocalDate data = LocalDate.parse(req.getParameter("data"));
            int id = Integer.parseInt(req.getParameter("codigo"));

            DespesasFintech despesa = new DespesasFintech(
                    id,
                    0,
                    descricao,
                    valor,
                    data,
                    formaPagamento);

            dao.atualizar(despesa);

            req.setAttribute("mensagem", "Despesa atualizada com sucesso!");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar despesa.");
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
            default:
                listar(req, resp);
                break;
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("codigo"));
        DespesasFintech despesa = dao.buscar(id);
        req.setAttribute("despesa", despesa);
        req.getRequestDispatcher("editar-despesa.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DespesasFintech> lista = dao.listar();
        double total = lista.stream().mapToDouble(DespesasFintech::getValor).sum();

        req.setAttribute("despesa", lista);
        req.setAttribute("totalDespesas", total);

        req.getRequestDispatcher("lista-despesa.jsp").forward(req, resp);
    }
}
