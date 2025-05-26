package br.com.fiap.centerfin.dao.impl;

import br.com.fiap.centerfin.dao.ConnectionManager;
import br.com.fiap.centerfin.dao.ReceitaDao;
import br.com.fiap.centerfin.exception.DBException;
import br.com.fiap.centerfin.model.ReceitaFintech;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleReceitaDao implements ReceitaDao {

    private Connection conexao;

    @Override
    public void cadastrar(ReceitaFintech receita) throws DBException {
        PreparedStatement stmt = null;
        PreparedStatement stmtSeq = null;
        ResultSet rsSeq = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();


            String sqlSeq = "SELECT SEQ_RECEITA.NEXTVAL FROM DUAL";
            stmtSeq = conexao.prepareStatement(sqlSeq);
            rsSeq = stmtSeq.executeQuery();

            int idReceita = 0;
            if (rsSeq.next()) {
                idReceita = rsSeq.getInt(1);
            }


            String sql = "INSERT INTO T_RECEITA (CD_RECEITA, CD_USUARIO, DS_RECEITA, VL_RECEITA, DT_RECEITA) " +
                    "VALUES (?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, idReceita);
            stmt.setInt(2, receita.getCodigo());
            stmt.setString(3, receita.getDescricao());
            stmt.setDouble(4, receita.getValor());
            stmt.setDate(5, java.sql.Date.valueOf(receita.getData()));

            stmt.executeUpdate();


            receita.setId(idReceita);

            System.out.println("Receita cadastrada com sucesso !!!");
        } catch (Exception e) {
            throw new DBException("Erro ao cadastrar receita", e);
        } finally {
            try {
                if (rsSeq != null) rsSeq.close();
                if (stmtSeq != null) stmtSeq.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void atualizar(ReceitaFintech receita) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE T_RECEITA SET  DS_RECEITA = ?, VL_RECEITA = ?, DT_RECEITA = ? " +
                    "WHERE CD_RECEITA = ?";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, receita.getDescricao());
            stmt.setDouble(2, receita.getValor());
            stmt.setDate(3, Date.valueOf(receita.getData()));
            stmt.setInt(4, receita.getId());
            stmt.executeUpdate();
            System.out.println("Receita atualizada com sucesso!");

        } catch (Exception e) {
            throw new DBException("Erro ao atualizar receita", e);
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
            String sql = "DELETE FROM T_RECEITA WHERE CD_RECEITA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Receita removida com sucesso!");

        } catch (Exception e) {
            throw new DBException("Erro ao remover receita", e);
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
    public ReceitaFintech buscar(int codigo) {
        ReceitaFintech receita = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM T_RECEITA WHERE CD_RECEITA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idReceita = rs.getInt("cd_receita");
//                int codigoUsuario = rs.getInt("cd_usuario");
                String descricao = rs.getString("ds_receita");
                double valor = rs.getDouble("vl_receita");
                LocalDate data = rs.getDate("dt_receita").toLocalDate();

                receita = new ReceitaFintech(codigo,descricao, valor, data);
                receita.setId(idReceita);
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

        return receita;
    }

    @Override
    public List<ReceitaFintech> listar() {
        List<ReceitaFintech> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM T_RECEITA";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idReceita = rs.getInt("cd_receita");
                int codigoUsuario = rs.getInt("cd_usuario");
                String descricao = rs.getString("ds_receita");
                double valor = rs.getDouble("vl_receita");
                LocalDate data = rs.getDate("dt_receita").toLocalDate();

                ReceitaFintech receita = new ReceitaFintech(codigoUsuario, descricao, valor, data);
                receita.setId(idReceita);
                lista.add(receita);
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
