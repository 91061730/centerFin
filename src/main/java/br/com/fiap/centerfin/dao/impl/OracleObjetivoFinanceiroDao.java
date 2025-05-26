

package br.com.fiap.centerfin.dao.impl;

import br.com.fiap.centerfin.dao.ConnectionManager;
import br.com.fiap.centerfin.dao.ObjetivoDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.ObjetivoFinanceiroFintech;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleObjetivoFinanceiroDao implements ObjetivoDao {

    private Connection conexao;

    @Override
    public void cadastrar(ObjetivoFinanceiroFintech objetivo) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();


            String sql = "INSERT INTO T_OBJETIVO_FINANCEIRO " +
                    "(cd_usuario, nm_objetivo, ds_objetivo, vl_objetivo, dt_conclusao) " +
                    "VALUES (?, ?, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, objetivo.getCodigoUsuario());
            stmt.setString(2, objetivo.getNomeObjetivo());
            stmt.setString(3, objetivo.getDescricao());
            stmt.setDouble(4, objetivo.getValor());
            if (objetivo.getDataConclusao() != null) {
                stmt.setDate(5, Date.valueOf(objetivo.getDataConclusao()));
            } else {
                stmt.setNull(5, Types.DATE);
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar objetivo financeiro", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(ObjetivoFinanceiroFintech objetivo) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE T_OBJETIVO_FINANCEIRO SET cd_usuario = ?, nm_objetivo = ?, ds_objetivo = ?, vl_objetivo = ?, dt_conclusao = ? " +
                    "WHERE cd_objetivo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, objetivo.getCodigoUsuario());
            stmt.setString(2, objetivo.getNomeObjetivo());
            stmt.setString(3, objetivo.getDescricao());
            stmt.setDouble(4, objetivo.getValor());
            if (objetivo.getDataConclusao() != null) {
                stmt.setDate(5, Date.valueOf(objetivo.getDataConclusao()));
            } else {
                stmt.setNull(5, Types.DATE);
            }
            stmt.setInt(6, objetivo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao atualizar objetivo financeiro", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remover(int id) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM T_OBJETIVO_FINANCEIRO WHERE cd_objetivo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao remover objetivo financeiro", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ObjetivoFinanceiroFintech buscar(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObjetivoFinanceiroFintech objetivo = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM T_OBJETIVO_FINANCEIRO WHERE cd_objetivo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                objetivo = new ObjetivoFinanceiroFintech();
                objetivo.setId(rs.getInt("cd_objetivo"));
                objetivo.setCodigoUsuario(rs.getInt("cd_usuario"));
                objetivo.setNomeObjetivo(rs.getString("nm_objetivo"));
                objetivo.setDescricao(rs.getString("ds_objetivo"));
                objetivo.setValor(rs.getDouble("vl_objetivo"));
                Date dtConclusao = rs.getDate("dt_conclusao");
                if (dtConclusao != null) {
                    objetivo.setDataConclusao(dtConclusao.toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return objetivo;
    }

    @Override
    public List<ObjetivoFinanceiroFintech> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ObjetivoFinanceiroFintech> lista = new ArrayList<>();
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM T_OBJETIVO_FINANCEIRO";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ObjetivoFinanceiroFintech objetivo = new ObjetivoFinanceiroFintech();
                objetivo.setId(rs.getInt("cd_objetivo"));
                objetivo.setCodigoUsuario(rs.getInt("cd_usuario"));
                objetivo.setNomeObjetivo(rs.getString("nm_objetivo"));
                objetivo.setDescricao(rs.getString("ds_objetivo"));
                objetivo.setValor(rs.getDouble("vl_objetivo"));
                Date dtConclusao = rs.getDate("dt_conclusao");
                if (dtConclusao != null) {
                    objetivo.setDataConclusao(dtConclusao.toLocalDate());
                }
                lista.add(objetivo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}

