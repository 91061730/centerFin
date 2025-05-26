
package br.com.fiap.centerfin.dao.impl;

import br.com.fiap.centerfin.dao.ConnectionManager;
import br.com.fiap.centerfin.dao.InvestimentoDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.InvestimentoFintech;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleInvestimentoDao implements InvestimentoDao {

    private Connection conexao;

    @Override
    public void cadastrar(InvestimentoFintech investimento) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO T_INVESTIMENTO (cd_investimento, cd_usuario, nm_aplicacao, int_financeira, vl_aplicacao, dt_aplicacao, dt_vencimento) " +
                    "VALUES (SEQ_CD_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, investimento.getCodigoUsuario());
            stmt.setString(2, investimento.getNomeAplicacao());
            stmt.setString(3, investimento.getInstituicao());
            stmt.setDouble(4, investimento.getValor());
            stmt.setDate(5, Date.valueOf(investimento.getData()));
            if (investimento.getDataVencimento() != null) {
                stmt.setDate(6, Date.valueOf(investimento.getDataVencimento()));
            } else {
                stmt.setNull(6, Types.DATE);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar investimento", e);
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
    public void atualizar(InvestimentoFintech investimento) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE T_INVESTIMENTO SET cd_usuario = ?, nm_aplicacao = ?, int_financeira = ?, vl_aplicacao = ?, dt_aplicacao = ?, dt_vencimento = ? " +
                    "WHERE cd_investimento = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, investimento.getCodigoUsuario());
            stmt.setString(2, investimento.getNomeAplicacao());
            stmt.setString(3, investimento.getInstituicao());
            stmt.setDouble(4, investimento.getValor());
            stmt.setDate(5, Date.valueOf(investimento.getData()));
            if (investimento.getDataVencimento() != null) {
                stmt.setDate(6, Date.valueOf(investimento.getDataVencimento()));
            } else {
                stmt.setNull(6, Types.DATE);
            }
            stmt.setInt(7, investimento.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao atualizar investimento", e);
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
            String sql = "DELETE FROM T_INVESTIMENTO WHERE cd_investimento = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao remover investimento", e);
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
    public InvestimentoFintech buscar(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InvestimentoFintech investimento = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM T_INVESTIMENTO WHERE cd_investimento = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                investimento = new InvestimentoFintech();
                investimento.setId(rs.getInt("cd_investimento"));
                investimento.setCodigoUsuario(rs.getInt("cd_usuario"));
                investimento.setNomeAplicacao(rs.getString("nm_aplicacao"));
                investimento.setInstituicao(rs.getString("int_financeira"));
                investimento.setValor(rs.getDouble("vl_aplicacao"));
                investimento.setData(rs.getDate("dt_aplicacao").toLocalDate());

                Date dtVenc = rs.getDate("dt_vencimento");
                if (dtVenc != null) {
                    investimento.setDataVencimento(dtVenc.toLocalDate());
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
        return investimento;
    }

    @Override
    public List<InvestimentoFintech> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<InvestimentoFintech> lista = new ArrayList<>();
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM T_INVESTIMENTO";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                InvestimentoFintech investimento = new InvestimentoFintech();
                investimento.setId(rs.getInt("cd_investimento"));
                investimento.setCodigoUsuario(rs.getInt("cd_usuario"));
                investimento.setNomeAplicacao(rs.getString("nm_aplicacao"));
                investimento.setInstituicao(rs.getString("int_financeira"));
                investimento.setValor(rs.getDouble("vl_aplicacao"));
                investimento.setData(rs.getDate("dt_aplicacao").toLocalDate());

                Date dtVenc = rs.getDate("dt_vencimento");
                if (dtVenc != null) {
                    investimento.setDataVencimento(dtVenc.toLocalDate());
                }
                lista.add(investimento);
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

