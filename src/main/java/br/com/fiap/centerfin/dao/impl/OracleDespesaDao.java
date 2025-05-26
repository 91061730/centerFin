package br.com.fiap.centerfin.dao.impl;

import br.com.fiap.centerfin.dao.ConnectionManager;
import br.com.fiap.centerfin.dao.DespesaDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.DespesasFintech;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleDespesaDao implements DespesaDao {

    private Connection conexao;

    @Override
    public void cadastrar(DespesasFintech despesa) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO T_DESPESA (CD_DESPESA, CD_USUARIO, DS_DESPESA, VL_DESPESA, DT_DESPESA, FM_PAGAMENTO) " +
                    "VALUES (SQ_T_DESPESA.NEXTVAL, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, despesa.getCodigo());
            stmt.setString(2, despesa.getDescricao());
            stmt.setDouble(3, despesa.getValor());
            stmt.setDate(4, Date.valueOf(despesa.getData()));
            stmt.setString(5, despesa.getFormaPagamento());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DBException("Erro ao cadastrar despesa.", e);
        } finally {
            closeResources(stmt, conexao);
        }
    }

    @Override
    public void atualizar(DespesasFintech despesa) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE T_DESPESA SET CD_USUARIO = ?, DS_DESPESA = ?, VL_DESPESA = ?, DT_DESPESA = ?, FM_PAGAMENTO = ? " +
                    "WHERE CD_DESPESA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, despesa.getCodigo());
            stmt.setString(2, despesa.getDescricao());
            stmt.setDouble(3, despesa.getValor());
            stmt.setDate(4, Date.valueOf(despesa.getData()));
            stmt.setString(5, despesa.getFormaPagamento());
            stmt.setInt(6, despesa.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DBException("Erro ao atualizar despesa.", e);
        } finally {
            closeResources(stmt, conexao);
        }
    }

    @Override
    public void remover(int id) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM T_DESPESA WHERE CD_DESPESA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DBException("Erro ao remover despesa.", e);
        } finally {
            closeResources(stmt, conexao);
        }
    }

    @Override
    public DespesasFintech buscar(int id) {
        DespesasFintech despesa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_DESPESA WHERE CD_DESPESA = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                despesa = new DespesasFintech(
                        rs.getInt("CD_DESPESA"),
                        rs.getInt("CD_USUARIO"),
                        rs.getString("DS_DESPESA"),
                        rs.getDouble("VL_DESPESA"),
                        rs.getDate("DT_DESPESA").toLocalDate(),
                        rs.getString("FM_PAGAMENTO")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conexao);
        }
        return despesa;
    }

    @Override
    public List<DespesasFintech> listar() {
        List<DespesasFintech> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.createStatement();
            rs = stmt.executeQuery("SELECT * FROM T_DESPESA");
            while (rs.next()) {
                DespesasFintech despesa = new DespesasFintech(
                        rs.getInt("CD_DESPESA"),
                        rs.getInt("CD_USUARIO"),
                        rs.getString("DS_DESPESA"),
                        rs.getDouble("VL_DESPESA"),
                        rs.getDate("DT_DESPESA").toLocalDate(),
                        rs.getString("FM_PAGAMENTO")
                );
                lista.add(despesa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conexao);
        }
        return lista;
    }

    private void closeResources(AutoCloseable... resources) {
        for (AutoCloseable r : resources) {
            try {
                if (r != null) r.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
